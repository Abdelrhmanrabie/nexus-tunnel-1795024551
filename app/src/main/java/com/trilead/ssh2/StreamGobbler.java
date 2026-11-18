package com.trilead.ssh2;

import com.jcraft.jzlib.GZIPHeader;
import com.trilead.ssh2.sftp.AttribFlags;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class StreamGobbler extends InputStream {
    private InputStream is;
    private GobblerThread t;
    private Object synchronizer = new Object();
    private boolean isEOF = false;
    private boolean isClosed = false;
    private IOException exception = null;
    private byte[] buffer = new byte[2048];
    private int read_pos = 0;
    private int write_pos = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class GobblerThread extends Thread {
        public GobblerThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
            while (true) {
                try {
                    int i = StreamGobbler.this.is.read(bArr);
                    synchronized (StreamGobbler.this.synchronizer) {
                        StreamGobbler streamGobbler = StreamGobbler.this;
                        if (i <= 0) {
                            streamGobbler.isEOF = true;
                            StreamGobbler.this.synchronizer.notifyAll();
                            return;
                        }
                        try {
                            if (streamGobbler.buffer.length - StreamGobbler.this.write_pos < i) {
                                int i2 = StreamGobbler.this.write_pos - StreamGobbler.this.read_pos;
                                int i3 = i2 + i;
                                byte[] bArr2 = StreamGobbler.this.buffer;
                                if (i3 > StreamGobbler.this.buffer.length) {
                                    int i4 = i3 / 3;
                                    if (i4 < 256) {
                                        i4 = 256;
                                    }
                                    if (i4 > 8192) {
                                        i4 = 8192;
                                    }
                                    bArr2 = new byte[i3 + i4];
                                }
                                if (i2 > 0) {
                                    System.arraycopy(StreamGobbler.this.buffer, StreamGobbler.this.read_pos, bArr2, 0, i2);
                                }
                                StreamGobbler.this.buffer = bArr2;
                                StreamGobbler.this.read_pos = 0;
                                StreamGobbler.this.write_pos = i2;
                            }
                            System.arraycopy(bArr, 0, StreamGobbler.this.buffer, StreamGobbler.this.write_pos, i);
                            StreamGobbler.access$412(StreamGobbler.this, i);
                            StreamGobbler.this.synchronizer.notifyAll();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (IOException e) {
                    synchronized (StreamGobbler.this.synchronizer) {
                        StreamGobbler.this.exception = e;
                        StreamGobbler.this.synchronizer.notifyAll();
                        return;
                    }
                }
            }
        }
    }

    public StreamGobbler(InputStream inputStream) {
        this.is = inputStream;
        GobblerThread gobblerThread = new GobblerThread();
        this.t = gobblerThread;
        gobblerThread.setDaemon(true);
        this.t.start();
    }

    public static /* synthetic */ int access$412(StreamGobbler streamGobbler, int i) {
        int i2 = streamGobbler.write_pos + i;
        streamGobbler.write_pos = i2;
        return i2;
    }

    @Override // java.io.InputStream
    public int available() {
        int i;
        synchronized (this.synchronizer) {
            try {
                if (this.isClosed) {
                    throw new IOException("This StreamGobbler is closed.");
                }
                i = this.write_pos - this.read_pos;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.synchronizer) {
            if (!this.isClosed) {
                this.isClosed = true;
                this.isEOF = true;
                this.synchronizer.notifyAll();
                this.is.close();
            }
        }
    }

    @Override // java.io.InputStream
    public int read() {
        synchronized (this.synchronizer) {
            if (this.isClosed) {
                throw new IOException("This StreamGobbler is closed.");
            }
            while (true) {
                int i = this.read_pos;
                if (i != this.write_pos) {
                    byte[] bArr = this.buffer;
                    this.read_pos = i + 1;
                    return bArr[i] & GZIPHeader.OS_UNKNOWN;
                }
                IOException iOException = this.exception;
                if (iOException != null) {
                    throw iOException;
                }
                if (this.isEOF) {
                    return -1;
                }
                try {
                    this.synchronizer.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3;
        bArr.getClass();
        if (i < 0 || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0 || i > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        synchronized (this.synchronizer) {
            if (this.isClosed) {
                throw new IOException("This StreamGobbler is closed.");
            }
            while (true) {
                int i4 = this.read_pos;
                int i5 = this.write_pos;
                if (i4 != i5) {
                    int i6 = i5 - i4;
                    if (i6 <= i2) {
                        i2 = i6;
                    }
                    System.arraycopy(this.buffer, i4, bArr, i, i2);
                    this.read_pos += i2;
                    return i2;
                }
                IOException iOException = this.exception;
                if (iOException != null) {
                    throw iOException;
                }
                if (this.isEOF) {
                    return -1;
                }
                try {
                    this.synchronizer.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }
}
