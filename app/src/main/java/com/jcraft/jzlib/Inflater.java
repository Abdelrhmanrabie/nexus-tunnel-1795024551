package com.jcraft.jzlib;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Inflater extends ZStream {
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

    public Inflater() {
        this.finished = false;
        init();
    }

    public Inflater(int i) {
        this(i, false);
    }

    public Inflater(int i, JZlib.WrapperType wrapperType) throws GZIPException {
        this.finished = false;
        int iInit = init(i, wrapperType);
        if (iInit == 0) {
            return;
        }
        throw new GZIPException(iInit + ": " + this.msg);
    }

    public Inflater(int i, boolean z) throws GZIPException {
        this.finished = false;
        int iInit = init(i, z);
        if (iInit == 0) {
            return;
        }
        throw new GZIPException(iInit + ": " + this.msg);
    }

    public Inflater(JZlib.WrapperType wrapperType) {
        this(15, wrapperType);
    }

    public Inflater(boolean z) {
        this(15, z);
    }

    @Override // com.jcraft.jzlib.ZStream
    public int end() {
        this.finished = true;
        Inflate inflate = this.istate;
        if (inflate == null) {
            return -2;
        }
        return inflate.inflateEnd();
    }

    @Override // com.jcraft.jzlib.ZStream
    public boolean finished() {
        return this.istate.mode == 12;
    }

    @Override // com.jcraft.jzlib.ZStream
    public int inflate(int i) {
        Inflate inflate = this.istate;
        if (inflate == null) {
            return -2;
        }
        int iInflate = inflate.inflate(i);
        if (iInflate == 1) {
            this.finished = true;
        }
        return iInflate;
    }

    public int init() {
        return init(15);
    }

    public int init(int i) {
        return init(i, false);
    }

    public int init(int i, JZlib.WrapperType wrapperType) {
        boolean z;
        if (wrapperType == JZlib.W_NONE) {
            z = true;
        } else {
            if (wrapperType == JZlib.W_GZIP) {
                i += 16;
            } else if (wrapperType == JZlib.W_ANY) {
                i |= 1073741824;
            }
            z = false;
        }
        return init(i, z);
    }

    public int init(int i, boolean z) {
        this.finished = false;
        Inflate inflate = new Inflate(this);
        this.istate = inflate;
        if (z) {
            i = -i;
        }
        return inflate.inflateInit(i);
    }

    public int init(JZlib.WrapperType wrapperType) {
        return init(15, wrapperType);
    }

    public int init(boolean z) {
        return init(15, z);
    }

    public int setDictionary(byte[] bArr, int i) {
        Inflate inflate = this.istate;
        if (inflate == null) {
            return -2;
        }
        return inflate.inflateSetDictionary(bArr, i);
    }

    public int sync() {
        Inflate inflate = this.istate;
        if (inflate == null) {
            return -2;
        }
        return inflate.inflateSync();
    }

    public int syncPoint() {
        Inflate inflate = this.istate;
        if (inflate == null) {
            return -2;
        }
        return inflate.inflateSyncPoint();
    }
}
