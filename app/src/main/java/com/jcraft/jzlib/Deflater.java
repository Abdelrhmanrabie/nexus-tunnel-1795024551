package com.jcraft.jzlib;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Deflater extends ZStream {
    private static final int DEF_WBITS = 15;
    private static final int MAX_MEM_LEVEL = 9;
    private static final int MAX_WBITS = 15;
    private static final int Z_BUF_ERROR = -5;
    private static final int Z_DATA_ERROR = -3;
    private static final int Z_ERRNO = -1;
    private static final int Z_FINISH = 4;
    private static final int Z_FULL_FLUSH = 3;
    private static final int Z_MEM_ERROR = -4;
    private static final int Z_NEED_DICT = 2;
    private static final int Z_NO_FLUSH = 0;
    private static final int Z_OK = 0;
    private static final int Z_PARTIAL_FLUSH = 1;
    private static final int Z_STREAM_END = 1;
    private static final int Z_STREAM_ERROR = -2;
    private static final int Z_SYNC_FLUSH = 2;
    private static final int Z_VERSION_ERROR = -6;
    private boolean finished;

    public Deflater() {
        this.finished = false;
    }

    public Deflater(int i) {
        this(i, 15);
    }

    public Deflater(int i, int i2) {
        this(i, i2, false);
    }

    public Deflater(int i, int i2, int i3) throws GZIPException {
        this.finished = false;
        int iInit = init(i, i2, i3);
        if (iInit == 0) {
            return;
        }
        throw new GZIPException(iInit + ": " + this.msg);
    }

    public Deflater(int i, int i2, int i3, JZlib.WrapperType wrapperType) throws GZIPException {
        this.finished = false;
        int iInit = init(i, i2, i3, wrapperType);
        if (iInit == 0) {
            return;
        }
        throw new GZIPException(iInit + ": " + this.msg);
    }

    public Deflater(int i, int i2, boolean z) throws GZIPException {
        this.finished = false;
        int iInit = init(i, i2, z);
        if (iInit == 0) {
            return;
        }
        throw new GZIPException(iInit + ": " + this.msg);
    }

    public Deflater(int i, boolean z) {
        this(i, 15, z);
    }

    public int copy(Deflater deflater) {
        this.finished = deflater.finished;
        return Deflate.deflateCopy(this, deflater);
    }

    @Override // com.jcraft.jzlib.ZStream
    public int deflate(int i) {
        Deflate deflate = this.dstate;
        if (deflate == null) {
            return -2;
        }
        int iDeflate = deflate.deflate(i);
        if (iDeflate == 1) {
            this.finished = true;
        }
        return iDeflate;
    }

    @Override // com.jcraft.jzlib.ZStream
    public int end() {
        this.finished = true;
        Deflate deflate = this.dstate;
        if (deflate == null) {
            return -2;
        }
        int iDeflateEnd = deflate.deflateEnd();
        this.dstate = null;
        free();
        return iDeflateEnd;
    }

    @Override // com.jcraft.jzlib.ZStream
    public boolean finished() {
        return this.finished;
    }

    public int init(int i) {
        return init(i, 15);
    }

    public int init(int i, int i2) {
        return init(i, i2, false);
    }

    public int init(int i, int i2, int i3) {
        this.finished = false;
        Deflate deflate = new Deflate(this);
        this.dstate = deflate;
        return deflate.deflateInit(i, i2, i3);
    }

    public int init(int i, int i2, int i3, JZlib.WrapperType wrapperType) {
        if (i2 < 9 || i2 > 15) {
            return -2;
        }
        if (wrapperType == JZlib.W_NONE) {
            i2 *= -1;
        } else if (wrapperType == JZlib.W_GZIP) {
            i2 += 16;
        } else if (wrapperType == JZlib.W_ANY) {
            return -2;
        }
        return init(i, i2, i3);
    }

    public int init(int i, int i2, boolean z) {
        this.finished = false;
        Deflate deflate = new Deflate(this);
        this.dstate = deflate;
        if (z) {
            i2 = -i2;
        }
        return deflate.deflateInit(i, i2);
    }

    public int init(int i, boolean z) {
        return init(i, 15, z);
    }

    public int params(int i, int i2) {
        Deflate deflate = this.dstate;
        if (deflate == null) {
            return -2;
        }
        return deflate.deflateParams(i, i2);
    }

    public int setDictionary(byte[] bArr, int i) {
        Deflate deflate = this.dstate;
        if (deflate == null) {
            return -2;
        }
        return deflate.deflateSetDictionary(bArr, i);
    }
}
