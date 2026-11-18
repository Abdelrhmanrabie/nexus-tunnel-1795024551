package com.trilead.ssh2;

import com.jcraft.jzlib.GZIPHeader;
import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.packets.TypesWriter;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ak;
import defpackage.d;
import defpackage.e;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Vector;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SFTPv3Client {
    String charsetName;
    final Connection conn;
    final PrintStream debug;
    boolean flag_closed;
    InputStream is;
    int next_request_id;
    OutputStream os;
    int protocol_version;
    HashMap server_extensions;
    final Session sess;

    public SFTPv3Client(Connection connection) {
        this(connection, null);
    }

    public SFTPv3Client(Connection connection, PrintStream printStream) throws IOException {
        this.flag_closed = false;
        this.protocol_version = 0;
        this.server_extensions = new HashMap();
        this.next_request_id = InternalZipConstants.AES_HASH_ITERATIONS;
        this.charsetName = null;
        if (connection == null) {
            d.AnonymousClass0.m$2("Cannot accept null argument!");
            throw null;
        }
        this.conn = connection;
        this.debug = printStream;
        if (printStream != null) {
            printStream.println("Opening session and starting SFTP subsystem.");
        }
        Session sessionOpenSession = connection.openSession();
        this.sess = sessionOpenSession;
        sessionOpenSession.startSubSystem("sftp");
        this.is = sessionOpenSession.getStdout();
        this.os = new BufferedOutputStream(sessionOpenSession.getStdin(), 2048);
        if (this.is != null) {
            init();
        } else {
            d.AnonymousClass0.m$6("There is a problem with the streams of the underlying channel.");
            throw null;
        }
    }

    private final void checkHandleValidAndOpen(SFTPv3FileHandle sFTPv3FileHandle) throws IOException {
        String str;
        if (sFTPv3FileHandle.client != this) {
            str = "The file handle was created with another SFTPv3FileHandle instance.";
        } else if (!sFTPv3FileHandle.isClosed) {
            return;
        } else {
            str = "The file handle is closed.";
        }
        d.AnonymousClass0.m$6(str);
    }

    private final void closeHandle(byte[] bArr) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(bArr, 0, bArr.length);
        sendMessage(4, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    private byte[] createAttrs(SFTPv3FileAttributes sFTPv3FileAttributes) {
        TypesWriter typesWriter = new TypesWriter();
        if (sFTPv3FileAttributes == null) {
            typesWriter.writeUINT32(0);
        } else {
            int i = sFTPv3FileAttributes.size != null ? 1 : 0;
            if (sFTPv3FileAttributes.uid != null && sFTPv3FileAttributes.gid != null) {
                i |= 2;
            }
            if (sFTPv3FileAttributes.permissions != null) {
                i |= 4;
            }
            if (sFTPv3FileAttributes.atime != null && sFTPv3FileAttributes.mtime != null) {
                i |= 8;
            }
            typesWriter.writeUINT32(i);
            Long l = sFTPv3FileAttributes.size;
            if (l != null) {
                typesWriter.writeUINT64(l.longValue());
            }
            Integer num = sFTPv3FileAttributes.uid;
            if (num != null && sFTPv3FileAttributes.gid != null) {
                typesWriter.writeUINT32(num.intValue());
                typesWriter.writeUINT32(sFTPv3FileAttributes.gid.intValue());
            }
            Integer num2 = sFTPv3FileAttributes.permissions;
            if (num2 != null) {
                typesWriter.writeUINT32(num2.intValue());
            }
            Long l2 = sFTPv3FileAttributes.atime;
            if (l2 != null && sFTPv3FileAttributes.mtime != null) {
                typesWriter.writeUINT32(l2.intValue());
                typesWriter.writeUINT32(sFTPv3FileAttributes.mtime.intValue());
            }
        }
        return typesWriter.getBytes();
    }

    private final String expandString(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i + i3] & GZIPHeader.OS_UNKNOWN;
            if (i4 < 32 || i4 > 126) {
                stringBuffer.append("{0x" + Integer.toHexString(i4) + "}");
            } else {
                stringBuffer.append((char) i4);
            }
        }
        return stringBuffer.toString();
    }

    private void expectStatusOKMessage(int i) throws IOException {
        byte[] bArrReceiveMessage = receiveMessage(34000);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Got REPLY.");
            this.debug.flush();
        }
        TypesReader typesReader = new TypesReader(bArrReceiveMessage);
        int i2 = typesReader.readByte();
        if (typesReader.readUINT32() != i) {
            d.AnonymousClass0.m$6("The server sent an invalid id field.");
        } else {
            if (i2 != 101) {
                throw new IOException(e.i(i2, "The SFTP server sent an unexpected packet type (", ")"));
            }
            int uint32 = typesReader.readUINT32();
            if (uint32 != 0) {
                throw new SFTPException(typesReader.readString(), uint32);
            }
        }
    }

    private final int generateNextRequestID() {
        int i;
        synchronized (this) {
            i = this.next_request_id;
            this.next_request_id = i + 1;
        }
        return i;
    }

    private void init() throws IOException {
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_INIT (3)...");
        }
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeUINT32(3);
        sendMessage(1, 0, typesWriter.getBytes());
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Waiting for SSH_FXP_VERSION...");
        }
        TypesReader typesReader = new TypesReader(receiveMessage(34000));
        int i = typesReader.readByte();
        if (i != 2) {
            throw new IOException(e.i(i, "The server did not send a SSH_FXP_VERSION packet (got ", ")"));
        }
        this.protocol_version = typesReader.readUINT32();
        PrintStream printStream3 = this.debug;
        if (printStream3 != null) {
            printStream3.println("SSH_FXP_VERSION: protocol_version = " + this.protocol_version);
        }
        if (this.protocol_version != 3) {
            throw new IOException("Server version " + this.protocol_version + " is currently not supported");
        }
        while (typesReader.remain() != 0) {
            String string = typesReader.readString();
            byte[] byteString = typesReader.readByteString();
            this.server_extensions.put(string, byteString);
            PrintStream printStream4 = this.debug;
            if (printStream4 != null) {
                StringBuilder sbQ = ak.q("SSH_FXP_VERSION: extension: ", string, " = '");
                sbQ.append(expandString(byteString, 0, byteString.length));
                sbQ.append("'");
                printStream4.println(sbQ.toString());
            }
        }
    }

    private final byte[] openDirectory(String str) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_OPENDIR...");
            this.debug.flush();
        }
        sendMessage(11, iGenerateNextRequestID, typesWriter.getBytes());
        TypesReader typesReader = new TypesReader(receiveMessage(34000));
        int i = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            d.AnonymousClass0.m$6("The server sent an invalid id field.");
            return null;
        }
        if (i != 102) {
            if (i != 101) {
                throw new IOException(e.i(i, "The SFTP server sent an unexpected packet type (", ")"));
            }
            throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
        }
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got SSH_FXP_HANDLE.");
            this.debug.flush();
        }
        return typesReader.readByteString();
    }

    private SFTPv3FileHandle openFile(String str, int i, SFTPv3FileAttributes sFTPv3FileAttributes) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        typesWriter.writeUINT32(i);
        typesWriter.writeBytes(createAttrs(sFTPv3FileAttributes));
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_OPEN...");
            this.debug.flush();
        }
        sendMessage(3, iGenerateNextRequestID, typesWriter.getBytes());
        TypesReader typesReader = new TypesReader(receiveMessage(34000));
        int i2 = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            d.AnonymousClass0.m$6("The server sent an invalid id field.");
            return null;
        }
        if (i2 != 102) {
            if (i2 != 101) {
                throw new IOException(e.i(i2, "The SFTP server sent an unexpected packet type (", ")"));
            }
            throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
        }
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got SSH_FXP_HANDLE.");
            this.debug.flush();
        }
        return new SFTPv3FileHandle(this, typesReader.readByteString());
    }

    private SFTPv3FileAttributes readAttrs(TypesReader typesReader) throws IOException {
        SFTPv3FileAttributes sFTPv3FileAttributes = new SFTPv3FileAttributes();
        int uint32 = typesReader.readUINT32();
        if ((uint32 & 1) != 0) {
            PrintStream printStream = this.debug;
            if (printStream != null) {
                printStream.println("SSH_FILEXFER_ATTR_SIZE");
            }
            sFTPv3FileAttributes.size = new Long(typesReader.readUINT64());
        }
        if ((uint32 & 2) != 0) {
            PrintStream printStream2 = this.debug;
            if (printStream2 != null) {
                printStream2.println("SSH_FILEXFER_ATTR_V3_UIDGID");
            }
            sFTPv3FileAttributes.uid = new Integer(typesReader.readUINT32());
            sFTPv3FileAttributes.gid = new Integer(typesReader.readUINT32());
        }
        if ((uint32 & 4) != 0) {
            PrintStream printStream3 = this.debug;
            if (printStream3 != null) {
                printStream3.println("SSH_FILEXFER_ATTR_PERMISSIONS");
            }
            sFTPv3FileAttributes.permissions = new Integer(typesReader.readUINT32());
        }
        if ((uint32 & 8) != 0) {
            PrintStream printStream4 = this.debug;
            if (printStream4 != null) {
                printStream4.println("SSH_FILEXFER_ATTR_V3_ACMODTIME");
            }
            sFTPv3FileAttributes.atime = new Long(((long) typesReader.readUINT32()) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            sFTPv3FileAttributes.mtime = new Long(((long) typesReader.readUINT32()) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        }
        if ((uint32 & AttribFlags.SSH_FILEXFER_ATTR_EXTENDED) != 0) {
            int uint33 = typesReader.readUINT32();
            PrintStream printStream5 = this.debug;
            if (printStream5 != null) {
                printStream5.println("SSH_FILEXFER_ATTR_EXTENDED (" + uint33 + ")");
            }
            while (uint33 > 0) {
                typesReader.readByteString();
                typesReader.readByteString();
                uint33--;
            }
        }
        return sFTPv3FileAttributes;
    }

    private final void readBytes(byte[] bArr, int i, int i2) throws IOException {
        String str;
        while (i2 > 0) {
            int i3 = this.is.read(bArr, i, i2);
            if (i3 < 0) {
                str = "Unexpected end of sftp stream.";
            } else if (i3 == 0 || i3 > i2) {
                str = "Underlying stream implementation is bogus!";
            } else {
                i2 -= i3;
                i += i3;
            }
            d.AnonymousClass0.m$6(str);
            return;
        }
    }

    private final byte[] receiveMessage(int i) throws IOException {
        byte[] bArr = new byte[4];
        readBytes(bArr, 0, 4);
        int i2 = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i2 > i || i2 <= 0) {
            throw new IOException(ak.h(i2, "Illegal sftp packet len: "));
        }
        byte[] bArr2 = new byte[i2];
        readBytes(bArr2, 0, i2);
        return bArr2;
    }

    private final Vector scanDirectory(byte[] bArr) throws IOException {
        Vector vector = new Vector();
        while (true) {
            int iGenerateNextRequestID = generateNextRequestID();
            TypesWriter typesWriter = new TypesWriter();
            typesWriter.writeString(bArr, 0, bArr.length);
            PrintStream printStream = this.debug;
            if (printStream != null) {
                printStream.println("Sending SSH_FXP_READDIR...");
                this.debug.flush();
            }
            sendMessage(12, iGenerateNextRequestID, typesWriter.getBytes());
            byte[] bArrReceiveMessage = receiveMessage(65536);
            PrintStream printStream2 = this.debug;
            if (printStream2 != null) {
                printStream2.println("Got REPLY.");
                this.debug.flush();
            }
            TypesReader typesReader = new TypesReader(bArrReceiveMessage);
            int i = typesReader.readByte();
            if (typesReader.readUINT32() != iGenerateNextRequestID) {
                d.AnonymousClass0.m$6("The server sent an invalid id field.");
                return null;
            }
            if (i != 104) {
                if (i != 101) {
                    throw new IOException(e.i(i, "The SFTP server sent an unexpected packet type (", ")"));
                }
                int uint32 = typesReader.readUINT32();
                if (uint32 == 1) {
                    return vector;
                }
                throw new SFTPException(typesReader.readString(), uint32);
            }
            int uint33 = typesReader.readUINT32();
            PrintStream printStream3 = this.debug;
            if (printStream3 != null) {
                printStream3.println("Parsing " + uint33 + " name entries...");
            }
            while (uint33 > 0) {
                SFTPv3DirectoryEntry sFTPv3DirectoryEntry = new SFTPv3DirectoryEntry();
                sFTPv3DirectoryEntry.filename = typesReader.readString(this.charsetName);
                sFTPv3DirectoryEntry.longEntry = typesReader.readString(this.charsetName);
                sFTPv3DirectoryEntry.attributes = readAttrs(typesReader);
                vector.addElement(sFTPv3DirectoryEntry);
                PrintStream printStream4 = this.debug;
                if (printStream4 != null) {
                    printStream4.println("File: '" + sFTPv3DirectoryEntry.filename + "'");
                }
                uint33--;
            }
        }
    }

    private final void sendMessage(int i, int i2, byte[] bArr) throws IOException {
        sendMessage(i, i2, bArr, 0, bArr.length);
    }

    private final void sendMessage(int i, int i2, byte[] bArr, int i3, int i4) throws IOException {
        int i5 = i4 + 1;
        if (i != 1) {
            i5 = i4 + 5;
        }
        this.os.write(i5 >> 24);
        this.os.write(i5 >> 16);
        this.os.write(i5 >> 8);
        this.os.write(i5);
        this.os.write(i);
        if (i != 1) {
            this.os.write(i2 >> 24);
            this.os.write(i2 >> 16);
            this.os.write(i2 >> 8);
            this.os.write(i2);
        }
        this.os.write(bArr, i3, i4);
        this.os.flush();
    }

    private SFTPv3FileAttributes statBoth(String str, int i) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_STAT/SSH_FXP_LSTAT...");
            this.debug.flush();
        }
        sendMessage(i, iGenerateNextRequestID, typesWriter.getBytes());
        byte[] bArrReceiveMessage = receiveMessage(34000);
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got REPLY.");
            this.debug.flush();
        }
        TypesReader typesReader = new TypesReader(bArrReceiveMessage);
        int i2 = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            d.AnonymousClass0.m$6("The server sent an invalid id field.");
            return null;
        }
        if (i2 == 105) {
            return readAttrs(typesReader);
        }
        if (i2 != 101) {
            throw new IOException(e.i(i2, "The SFTP server sent an unexpected packet type (", ")"));
        }
        throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
    }

    public String canonicalPath(String str) throws IOException {
        String str2;
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_REALPATH...");
            this.debug.flush();
        }
        sendMessage(16, iGenerateNextRequestID, typesWriter.getBytes());
        byte[] bArrReceiveMessage = receiveMessage(34000);
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got REPLY.");
            this.debug.flush();
        }
        TypesReader typesReader = new TypesReader(bArrReceiveMessage);
        int i = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            str2 = "The server sent an invalid id field.";
        } else {
            if (i != 104) {
                if (i != 101) {
                    throw new IOException(e.i(i, "The SFTP server sent an unexpected packet type (", ")"));
                }
                throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
            }
            if (typesReader.readUINT32() == 1) {
                return typesReader.readString(this.charsetName);
            }
            str2 = "The server sent an invalid SSH_FXP_NAME packet.";
        }
        d.AnonymousClass0.m$6(str2);
        return null;
    }

    public void close() {
        this.sess.close();
    }

    public void closeFile(SFTPv3FileHandle sFTPv3FileHandle) {
        if (sFTPv3FileHandle == null) {
            d.AnonymousClass0.m$2("the handle argument may not be null");
            return;
        }
        try {
            if (!sFTPv3FileHandle.isClosed) {
                closeHandle(sFTPv3FileHandle.fileHandle);
            }
        } finally {
            sFTPv3FileHandle.isClosed = true;
        }
    }

    public SFTPv3FileHandle createFile(String str) {
        return createFile(str, null);
    }

    public SFTPv3FileHandle createFile(String str, SFTPv3FileAttributes sFTPv3FileAttributes) {
        return openFile(str, 11, sFTPv3FileAttributes);
    }

    public SFTPv3FileHandle createFileTruncate(String str) {
        return createFileTruncate(str, null);
    }

    public SFTPv3FileHandle createFileTruncate(String str, SFTPv3FileAttributes sFTPv3FileAttributes) {
        return openFile(str, 27, sFTPv3FileAttributes);
    }

    public void createSymlink(String str, String str2) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str2, this.charsetName);
        typesWriter.writeString(str, this.charsetName);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_SYMLINK...");
            this.debug.flush();
        }
        sendMessage(20, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public void fsetstat(SFTPv3FileHandle sFTPv3FileHandle, SFTPv3FileAttributes sFTPv3FileAttributes) throws IOException {
        checkHandleValidAndOpen(sFTPv3FileHandle);
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        byte[] bArr = sFTPv3FileHandle.fileHandle;
        typesWriter.writeString(bArr, 0, bArr.length);
        typesWriter.writeBytes(createAttrs(sFTPv3FileAttributes));
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_FSETSTAT...");
            this.debug.flush();
        }
        sendMessage(10, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public SFTPv3FileAttributes fstat(SFTPv3FileHandle sFTPv3FileHandle) throws IOException {
        checkHandleValidAndOpen(sFTPv3FileHandle);
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        byte[] bArr = sFTPv3FileHandle.fileHandle;
        typesWriter.writeString(bArr, 0, bArr.length);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_FSTAT...");
            this.debug.flush();
        }
        sendMessage(8, iGenerateNextRequestID, typesWriter.getBytes());
        byte[] bArrReceiveMessage = receiveMessage(34000);
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got REPLY.");
            this.debug.flush();
        }
        TypesReader typesReader = new TypesReader(bArrReceiveMessage);
        int i = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            d.AnonymousClass0.m$6("The server sent an invalid id field.");
            return null;
        }
        if (i == 105) {
            return readAttrs(typesReader);
        }
        if (i != 101) {
            throw new IOException(e.i(i, "The SFTP server sent an unexpected packet type (", ")"));
        }
        throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
    }

    public String getCharset() {
        return this.charsetName;
    }

    public int getProtocolVersion() {
        return this.protocol_version;
    }

    public Vector ls(String str) throws IOException {
        byte[] bArrOpenDirectory = openDirectory(str);
        Vector vectorScanDirectory = scanDirectory(bArrOpenDirectory);
        closeHandle(bArrOpenDirectory);
        return vectorScanDirectory;
    }

    public SFTPv3FileAttributes lstat(String str) {
        return statBoth(str, 7);
    }

    public void mkdir(String str, int i) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        typesWriter.writeUINT32(4);
        typesWriter.writeUINT32(i);
        sendMessage(14, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public void mv(String str, String str2) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        typesWriter.writeString(str2, this.charsetName);
        sendMessage(18, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public SFTPv3FileHandle openFileRO(String str) {
        return openFile(str, 1, null);
    }

    public SFTPv3FileHandle openFileRW(String str) {
        return openFile(str, 3, null);
    }

    public int read(SFTPv3FileHandle sFTPv3FileHandle, long j, byte[] bArr, int i, int i2) throws IOException {
        String str;
        checkHandleValidAndOpen(sFTPv3FileHandle);
        if (i2 > 32768 || i2 <= 0) {
            d.AnonymousClass0.m$2("invalid len argument");
            return 0;
        }
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        byte[] bArr2 = sFTPv3FileHandle.fileHandle;
        typesWriter.writeString(bArr2, 0, bArr2.length);
        typesWriter.writeUINT64(j);
        typesWriter.writeUINT32(i2);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_READ...");
            this.debug.flush();
        }
        sendMessage(5, iGenerateNextRequestID, typesWriter.getBytes());
        TypesReader typesReader = new TypesReader(receiveMessage(34000));
        int i3 = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            str = "The server sent an invalid id field.";
        } else {
            if (i3 != 103) {
                if (i3 != 101) {
                    throw new IOException(e.i(i3, "The SFTP server sent an unexpected packet type (", ")"));
                }
                int uint32 = typesReader.readUINT32();
                if (uint32 != 1) {
                    throw new SFTPException(typesReader.readString(), uint32);
                }
                PrintStream printStream2 = this.debug;
                if (printStream2 == null) {
                    return -1;
                }
                printStream2.println("Got SSH_FX_EOF.");
                this.debug.flush();
                return -1;
            }
            PrintStream printStream3 = this.debug;
            if (printStream3 != null) {
                printStream3.println("Got SSH_FXP_DATA...");
                this.debug.flush();
            }
            int uint33 = typesReader.readUINT32();
            if (uint33 >= 0 && uint33 <= i2) {
                typesReader.readBytes(bArr, i, uint33);
                return uint33;
            }
            str = "The server sent an invalid length field.";
        }
        d.AnonymousClass0.m$6(str);
        return 0;
    }

    public String readLink(String str) throws IOException {
        String str2;
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_READLINK...");
            this.debug.flush();
        }
        sendMessage(19, iGenerateNextRequestID, typesWriter.getBytes());
        byte[] bArrReceiveMessage = receiveMessage(34000);
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got REPLY.");
            this.debug.flush();
        }
        TypesReader typesReader = new TypesReader(bArrReceiveMessage);
        int i = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            str2 = "The server sent an invalid id field.";
        } else {
            if (i != 104) {
                if (i != 101) {
                    throw new IOException(e.i(i, "The SFTP server sent an unexpected packet type (", ")"));
                }
                throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
            }
            if (typesReader.readUINT32() == 1) {
                return typesReader.readString(this.charsetName);
            }
            str2 = "The server sent an invalid SSH_FXP_NAME packet.";
        }
        d.AnonymousClass0.m$6(str2);
        return null;
    }

    public void rm(String str) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        sendMessage(13, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public void rmdir(String str) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        sendMessage(15, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public void setCharset(String str) throws IOException {
        if (str == null) {
            this.charsetName = str;
            return;
        }
        try {
            Charset.forName(str);
            this.charsetName = str;
        } catch (Exception e) {
            d.AnonymousClass0.m("This charset is not supported", (Throwable) e);
        }
    }

    public void setstat(String str, SFTPv3FileAttributes sFTPv3FileAttributes) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        typesWriter.writeBytes(createAttrs(sFTPv3FileAttributes));
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_SETSTAT...");
            this.debug.flush();
        }
        sendMessage(9, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public SFTPv3FileAttributes stat(String str) {
        return statBoth(str, 17);
    }

    public void write(SFTPv3FileHandle sFTPv3FileHandle, long j, byte[] bArr, int i, int i2) throws IOException {
        checkHandleValidAndOpen(sFTPv3FileHandle);
        while (i2 > 0) {
            int i3 = AttribFlags.SSH_FILEXFER_ATTR_CTIME;
            if (i2 <= 32768) {
                i3 = i2;
            }
            int iGenerateNextRequestID = generateNextRequestID();
            TypesWriter typesWriter = new TypesWriter();
            byte[] bArr2 = sFTPv3FileHandle.fileHandle;
            typesWriter.writeString(bArr2, 0, bArr2.length);
            typesWriter.writeUINT64(j);
            typesWriter.writeString(bArr, i, i3);
            PrintStream printStream = this.debug;
            if (printStream != null) {
                printStream.println("Sending SSH_FXP_WRITE...");
                this.debug.flush();
            }
            sendMessage(6, iGenerateNextRequestID, typesWriter.getBytes());
            j += (long) i3;
            i += i3;
            i2 -= i3;
            TypesReader typesReader = new TypesReader(receiveMessage(34000));
            int i4 = typesReader.readByte();
            if (typesReader.readUINT32() != iGenerateNextRequestID) {
                d.AnonymousClass0.m$6("The server sent an invalid id field.");
                return;
            } else {
                if (i4 != 101) {
                    throw new IOException(e.i(i4, "The SFTP server sent an unexpected packet type (", ")"));
                }
                int uint32 = typesReader.readUINT32();
                if (uint32 != 0) {
                    throw new SFTPException(typesReader.readString(), uint32);
                }
            }
        }
    }
}
