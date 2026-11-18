package com.jcraft.jzlib;

import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Deflate implements Cloneable {
    private static final int BL_CODES = 19;
    private static final int BUSY_STATE = 113;
    private static final int BlockDone = 1;
    private static final int Buf_size = 16;
    private static final int DEF_MEM_LEVEL = 8;
    private static final int DYN_TREES = 2;
    private static final int D_CODES = 30;
    private static final int END_BLOCK = 256;
    private static final int FAST = 1;
    private static final int FINISH_STATE = 666;
    private static final int FinishDone = 3;
    private static final int FinishStarted = 2;
    private static final int HEAP_SIZE = 573;
    private static final int INIT_STATE = 42;
    private static final int LENGTH_CODES = 29;
    private static final int LITERALS = 256;
    private static final int L_CODES = 286;
    private static final int MAX_BITS = 15;
    private static final int MAX_MEM_LEVEL = 9;
    private static final int MAX_WBITS = 15;
    private static final int MIN_LOOKAHEAD = 262;
    private static final int MIN_MATCH = 3;
    private static final int NeedMore = 0;
    private static final int PRESET_DICT = 32;
    private static final int REPZ_11_138 = 18;
    private static final int REPZ_3_10 = 17;
    private static final int REP_3_6 = 16;
    private static final int SLOW = 2;
    private static final int STATIC_TREES = 1;
    private static final int STORED = 0;
    private static final int STORED_BLOCK = 0;
    private static final int Z_ASCII = 1;
    private static final int Z_BINARY = 0;
    private static final int Z_BUF_ERROR = -5;
    private static final int Z_DATA_ERROR = -3;
    private static final int Z_DEFAULT_COMPRESSION = -1;
    private static final int Z_DEFAULT_STRATEGY = 0;
    private static final int Z_DEFLATED = 8;
    private static final int Z_ERRNO = -1;
    private static final int Z_FILTERED = 1;
    private static final int Z_FINISH = 4;
    private static final int Z_FULL_FLUSH = 3;
    private static final int Z_HUFFMAN_ONLY = 2;
    private static final int Z_MEM_ERROR = -4;
    private static final int Z_NEED_DICT = 2;
    private static final int Z_NO_FLUSH = 0;
    private static final int Z_OK = 0;
    private static final int Z_PARTIAL_FLUSH = 1;
    private static final int Z_STREAM_END = 1;
    private static final int Z_STREAM_ERROR = -2;
    private static final int Z_SYNC_FLUSH = 2;
    private static final int Z_UNKNOWN = 2;
    private static final int Z_VERSION_ERROR = -6;
    short bi_buf;
    int bi_valid;
    int block_start;
    int d_buf;
    byte data_type;
    int good_match;
    int hash_bits;
    int hash_mask;
    int hash_shift;
    int hash_size;
    short[] head;
    int heap_len;
    int heap_max;
    int ins_h;
    byte[] l_buf;
    int last_eob_len;
    int last_flush;
    int last_lit;
    int level;
    int lit_bufsize;
    int lookahead;
    int match_available;
    int match_length;
    int match_start;
    int matches;
    int max_chain_length;
    int max_lazy_match;
    byte method;
    int nice_match;
    int opt_len;
    int pending;
    byte[] pending_buf;
    int pending_buf_size;
    int pending_out;
    short[] prev;
    int prev_length;
    int prev_match;
    int static_len;
    int status;
    int strategy;
    ZStream strm;
    int strstart;
    int w_bits;
    int w_mask;
    int w_size;
    byte[] window;
    int window_size;
    private static final int MAX_MATCH = 258;
    private static final Config[] config_table = {new Config(0, 0, 0, 0, 0), new Config(4, 4, 8, 4, 1), new Config(4, 5, 16, 8, 1), new Config(4, 6, 32, 32, 1), new Config(4, 4, 16, 16, 2), new Config(8, 16, 32, 32, 2), new Config(8, 16, 128, 128, 2), new Config(8, 32, 128, 256, 2), new Config(32, 128, MAX_MATCH, 1024, 2), new Config(32, MAX_MATCH, MAX_MATCH, 4096, 2)};
    private static final String[] z_errmsg = {"need dictionary", "stream end", AppConfig.CUSTOM, "file error", "stream error", "data error", "insufficient memory", "buffer error", "incompatible version", AppConfig.CUSTOM};
    int wrap = 1;
    Tree l_desc = new Tree();
    Tree d_desc = new Tree();
    Tree bl_desc = new Tree();
    short[] bl_count = new short[16];
    short[] next_code = new short[16];
    int[] heap = new int[HEAP_SIZE];
    byte[] depth = new byte[HEAP_SIZE];
    GZIPHeader gheader = null;
    short[] dyn_ltree = new short[1146];
    short[] dyn_dtree = new short[122];
    short[] bl_tree = new short[78];

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Config {
        int func;
        int good_length;
        int max_chain;
        int max_lazy;
        int nice_length;

        public Config(int i, int i2, int i3, int i4, int i5) {
            this.good_length = i;
            this.max_lazy = i2;
            this.nice_length = i3;
            this.max_chain = i4;
            this.func = i5;
        }
    }

    public Deflate(ZStream zStream) {
        this.strm = zStream;
    }

    public static int deflateCopy(ZStream zStream, ZStream zStream2) {
        if (zStream2.dstate == null) {
            return -2;
        }
        byte[] bArr = zStream2.next_in;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            zStream.next_in = bArr2;
            byte[] bArr3 = zStream2.next_in;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        }
        zStream.next_in_index = zStream2.next_in_index;
        zStream.avail_in = zStream2.avail_in;
        zStream.total_in = zStream2.total_in;
        byte[] bArr4 = zStream2.next_out;
        if (bArr4 != null) {
            byte[] bArr5 = new byte[bArr4.length];
            zStream.next_out = bArr5;
            byte[] bArr6 = zStream2.next_out;
            System.arraycopy(bArr6, 0, bArr5, 0, bArr6.length);
        }
        zStream.next_out_index = zStream2.next_out_index;
        zStream.avail_out = zStream2.avail_out;
        zStream.total_out = zStream2.total_out;
        zStream.msg = zStream2.msg;
        zStream.data_type = zStream2.data_type;
        zStream.adler = zStream2.adler.copy();
        try {
            Deflate deflate = (Deflate) zStream2.dstate.clone();
            zStream.dstate = deflate;
            deflate.strm = zStream;
        } catch (CloneNotSupportedException unused) {
        }
        return 0;
    }

    private int deflateInit(int i, int i2, int i3, int i4, int i5) {
        int i6;
        ZStream zStream = this.strm;
        zStream.msg = null;
        if (i == -1) {
            i = 6;
        }
        if (i3 < 0) {
            i3 = -i3;
            i6 = 0;
        } else if (i3 > 15) {
            i3 -= 16;
            zStream.adler = new CRC32();
            i6 = 2;
        } else {
            i6 = 1;
        }
        if (i4 < 1 || i4 > 9 || i2 != 8 || i3 < 9 || i3 > 15 || i < 0 || i > 9 || i5 < 0 || i5 > 2) {
            return -2;
        }
        this.strm.dstate = this;
        this.wrap = i6;
        this.w_bits = i3;
        int i7 = 1 << i3;
        this.w_size = i7;
        this.w_mask = i7 - 1;
        int i8 = i4 + 7;
        this.hash_bits = i8;
        int i9 = 1 << i8;
        this.hash_size = i9;
        this.hash_mask = i9 - 1;
        this.hash_shift = (i4 + 9) / 3;
        this.window = new byte[i7 * 2];
        this.prev = new short[i7];
        this.head = new short[i9];
        int i10 = 1 << (i4 + 6);
        this.lit_bufsize = i10;
        int i11 = i10 * 3;
        this.pending_buf = new byte[i11];
        this.pending_buf_size = i11;
        this.d_buf = i10;
        this.l_buf = new byte[i10];
        this.level = i;
        this.strategy = i5;
        this.method = (byte) i2;
        return deflateReset();
    }

    private byte[] dup(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private int[] dup(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    private short[] dup(short[] sArr) {
        int length = sArr.length;
        short[] sArr2 = new short[length];
        System.arraycopy(sArr, 0, sArr2, 0, length);
        return sArr2;
    }

    public static boolean smaller(short[] sArr, int i, int i2, byte[] bArr) {
        short s = sArr[i * 2];
        short s2 = sArr[i2 * 2];
        if (s >= s2) {
            return s == s2 && bArr[i] <= bArr[i2];
        }
        return true;
    }

    public void _tr_align() {
        send_bits(2, 3);
        short[] sArr = StaticTree.static_ltree;
        send_code(256, sArr);
        bi_flush();
        if ((this.last_eob_len + 11) - this.bi_valid < 9) {
            send_bits(2, 3);
            send_code(256, sArr);
            bi_flush();
        }
        this.last_eob_len = 7;
    }

    public void _tr_flush_block(int i, int i2, boolean z) {
        int i3;
        int iBuild_bl_tree;
        int i4;
        if (this.level > 0) {
            if (this.data_type == 2) {
                set_data_type();
            }
            this.l_desc.build_tree(this);
            this.d_desc.build_tree(this);
            iBuild_bl_tree = build_bl_tree();
            i3 = (this.opt_len + 10) >>> 3;
            i4 = (this.static_len + 10) >>> 3;
            if (i4 <= i3) {
                i3 = i4;
            }
        } else {
            i3 = i2 + 5;
            iBuild_bl_tree = 0;
            i4 = i3;
        }
        if (i2 + 4 <= i3 && i != -1) {
            _tr_stored_block(i, i2, z);
        } else if (i4 == i3) {
            send_bits((z ? 1 : 0) + 2, 3);
            compress_block(StaticTree.static_ltree, StaticTree.static_dtree);
        } else {
            send_bits((z ? 1 : 0) + 4, 3);
            send_all_trees(this.l_desc.max_code + 1, this.d_desc.max_code + 1, iBuild_bl_tree + 1);
            compress_block(this.dyn_ltree, this.dyn_dtree);
        }
        init_block();
        if (z) {
            bi_windup();
        }
    }

    public void _tr_stored_block(int i, int i2, boolean z) {
        send_bits(z ? 1 : 0, 3);
        copy_block(i, i2, true);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0085  */
    /* JADX WARN: Code duplicated, block: B:22:0x008d A[RETURN] */
    public boolean _tr_tally(int i, int i2) {
        byte[] bArr = this.pending_buf;
        int i3 = this.d_buf;
        int i4 = this.last_lit;
        int i5 = (i4 * 2) + i3;
        bArr[i5] = (byte) (i >>> 8);
        bArr[i5 + 1] = (byte) i;
        this.l_buf[i4] = (byte) i2;
        this.last_lit = i4 + 1;
        if (i == 0) {
            short[] sArr = this.dyn_ltree;
            int i6 = i2 * 2;
            sArr[i6] = (short) (sArr[i6] + 1);
        } else {
            this.matches++;
            short[] sArr2 = this.dyn_ltree;
            int i7 = (Tree._length_code[i2] + 257) * 2;
            sArr2[i7] = (short) (sArr2[i7] + 1);
            short[] sArr3 = this.dyn_dtree;
            int iD_code = Tree.d_code(i - 1) * 2;
            sArr3[iD_code] = (short) (sArr3[iD_code] + 1);
        }
        int i8 = this.last_lit;
        if ((i8 & 8191) == 0 && this.level > 2) {
            int i9 = i8 * 8;
            int i10 = this.strstart - this.block_start;
            for (int i11 = 0; i11 < 30; i11++) {
                i9 = (int) (((((long) Tree.extra_dbits[i11]) + 5) * ((long) this.dyn_dtree[i11 * 2])) + ((long) i9));
            }
            int i12 = i9 >>> 3;
            if (this.matches >= this.last_lit / 2 || i12 >= i10 / 2) {
                if (this.last_lit == this.lit_bufsize - 1) {
                    return false;
                }
            }
        } else if (this.last_lit == this.lit_bufsize - 1) {
            return false;
        }
        return true;
    }

    public void bi_flush() {
        int i;
        int i2 = this.bi_valid;
        if (i2 == 16) {
            put_short(this.bi_buf);
            i = 0;
            this.bi_buf = (short) 0;
        } else {
            if (i2 < 8) {
                return;
            }
            put_byte((byte) this.bi_buf);
            this.bi_buf = (short) (this.bi_buf >>> 8);
            i = this.bi_valid - 8;
        }
        this.bi_valid = i;
    }

    public void bi_windup() {
        int i = this.bi_valid;
        if (i > 8) {
            put_short(this.bi_buf);
        } else if (i > 0) {
            put_byte((byte) this.bi_buf);
        }
        this.bi_buf = (short) 0;
        this.bi_valid = 0;
    }

    public int build_bl_tree() {
        scan_tree(this.dyn_ltree, this.l_desc.max_code);
        scan_tree(this.dyn_dtree, this.d_desc.max_code);
        this.bl_desc.build_tree(this);
        int i = 18;
        while (i >= 3 && this.bl_tree[(Tree.bl_order[i] * 2) + 1] == 0) {
            i--;
        }
        this.opt_len = ((i + 1) * 3) + 14 + this.opt_len;
        return i;
    }

    public Object clone() {
        Deflate deflate = (Deflate) super.clone();
        deflate.pending_buf = dup(deflate.pending_buf);
        deflate.d_buf = deflate.d_buf;
        deflate.l_buf = dup(deflate.l_buf);
        deflate.window = dup(deflate.window);
        deflate.prev = dup(deflate.prev);
        deflate.head = dup(deflate.head);
        deflate.dyn_ltree = dup(deflate.dyn_ltree);
        deflate.dyn_dtree = dup(deflate.dyn_dtree);
        deflate.bl_tree = dup(deflate.bl_tree);
        deflate.bl_count = dup(deflate.bl_count);
        deflate.next_code = dup(deflate.next_code);
        deflate.heap = dup(deflate.heap);
        deflate.depth = dup(deflate.depth);
        deflate.l_desc.dyn_tree = deflate.dyn_ltree;
        deflate.d_desc.dyn_tree = deflate.dyn_dtree;
        deflate.bl_desc.dyn_tree = deflate.bl_tree;
        GZIPHeader gZIPHeader = deflate.gheader;
        if (gZIPHeader != null) {
            deflate.gheader = (GZIPHeader) gZIPHeader.clone();
        }
        return deflate;
    }

    public void compress_block(short[] sArr, short[] sArr2) {
        if (this.last_lit != 0) {
            int i = 0;
            do {
                byte[] bArr = this.pending_buf;
                int i2 = (i * 2) + this.d_buf;
                int i3 = (bArr[i2 + 1] & GZIPHeader.OS_UNKNOWN) | ((bArr[i2] << 8) & 65280);
                int i4 = this.l_buf[i] & GZIPHeader.OS_UNKNOWN;
                i++;
                if (i3 == 0) {
                    send_code(i4, sArr);
                } else {
                    byte b = Tree._length_code[i4];
                    send_code(b + 257, sArr);
                    int i5 = Tree.extra_lbits[b];
                    if (i5 != 0) {
                        send_bits(i4 - Tree.base_length[b], i5);
                    }
                    int i6 = i3 - 1;
                    int iD_code = Tree.d_code(i6);
                    send_code(iD_code, sArr2);
                    int i7 = Tree.extra_dbits[iD_code];
                    if (i7 != 0) {
                        send_bits(i6 - Tree.base_dist[iD_code], i7);
                    }
                }
            } while (i < this.last_lit);
        }
        send_code(256, sArr);
        this.last_eob_len = sArr[513];
    }

    public void copy_block(int i, int i2, boolean z) {
        bi_windup();
        this.last_eob_len = 8;
        if (z) {
            put_short((short) i2);
            put_short((short) (~i2));
        }
        put_byte(this.window, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:89:0x0133  */
    /* JADX WARN: Code duplicated, block: B:92:0x0139  */
    /* JADX WARN: Code duplicated, block: B:94:0x013d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0199  */
    /* JADX WARN: Code duplicated, block: B:98:0x01b3  */
    public int deflate(int i) {
        int i2;
        String str;
        int iDeflate_stored;
        int i3;
        ZStream zStream;
        int i4;
        if (i <= 4 && i >= 0) {
            ZStream zStream2 = this.strm;
            if (zStream2.next_out != null && ((zStream2.next_in != null || zStream2.avail_in == 0) && ((i2 = this.status) != FINISH_STATE || i == 4))) {
                char c = 7;
                if (zStream2.avail_out != 0) {
                    int i5 = this.last_flush;
                    this.last_flush = i;
                    char c2 = '\b';
                    if (i2 == 42) {
                        if (this.wrap == 2) {
                            getGZIPHeader().put(this);
                            this.status = 113;
                        } else {
                            int i6 = (((this.w_bits - 8) << 4) + 8) << 8;
                            int i7 = ((this.level - 1) & 255) >> 1;
                            if (i7 > 3) {
                                i7 = 3;
                            }
                            int i8 = i6 | (i7 << 6);
                            if (this.strstart != 0) {
                                i8 |= 32;
                            }
                            this.status = 113;
                            putShortMSB((31 - (i8 % 31)) + i8);
                            if (this.strstart != 0) {
                                long value = this.strm.adler.getValue();
                                putShortMSB((int) (value >>> 16));
                                putShortMSB((int) (value & 65535));
                            }
                            this.strm.adler.reset();
                        }
                        this.strm.adler.reset();
                    } else {
                        c = 7;
                        c2 = '\b';
                    }
                    int i9 = this.pending;
                    ZStream zStream3 = this.strm;
                    char c3 = c;
                    if (i9 != 0) {
                        zStream3.flush_pending();
                        if (this.strm.avail_out == 0) {
                            this.last_flush = -1;
                            return 0;
                        }
                    } else if (zStream3.avail_in == 0 && i <= i5 && i != 4) {
                        str = z_errmsg[c3];
                        zStream2 = zStream3;
                    }
                    int i10 = this.status;
                    if (i10 == FINISH_STATE) {
                        ZStream zStream4 = this.strm;
                        if (zStream4.avail_in != 0) {
                            str = z_errmsg[c3];
                            zStream2 = zStream4;
                        }
                    }
                    if (this.strm.avail_in != 0 || this.lookahead != 0 || (i != 0 && i10 != FINISH_STATE)) {
                        int i11 = config_table[this.level].func;
                        if (i11 == 0) {
                            iDeflate_stored = deflate_stored(i);
                        } else if (i11 != 1) {
                            iDeflate_stored = i11 != 2 ? -1 : deflate_slow(i);
                        } else {
                            iDeflate_stored = deflate_fast(i);
                        }
                        if (iDeflate_stored == 2 || iDeflate_stored == 3) {
                            this.status = FINISH_STATE;
                        }
                        if (iDeflate_stored != 0 && iDeflate_stored != 2) {
                            if (iDeflate_stored == 1) {
                                if (i == 1) {
                                    _tr_align();
                                } else {
                                    _tr_stored_block(0, 0, false);
                                    if (i == 3) {
                                        for (int i12 = 0; i12 < this.hash_size; i12++) {
                                            this.head[i12] = 0;
                                        }
                                    }
                                }
                                this.strm.flush_pending();
                                if (this.strm.avail_out == 0) {
                                    this.last_flush = -1;
                                    return 0;
                                }
                            }
                            if (i == 4) {
                                i3 = this.wrap;
                                if (i3 > 0) {
                                    zStream = this.strm;
                                    if (i3 == 2) {
                                        long value2 = zStream.adler.getValue();
                                        put_byte((byte) (value2 & 255));
                                        put_byte((byte) ((value2 >> c2) & 255));
                                        put_byte((byte) ((value2 >> 16) & 255));
                                        put_byte((byte) ((value2 >> 24) & 255));
                                        put_byte((byte) (this.strm.total_in & 255));
                                        put_byte((byte) ((this.strm.total_in >> c2) & 255));
                                        put_byte((byte) ((this.strm.total_in >> 16) & 255));
                                        put_byte((byte) (255 & (this.strm.total_in >> 24)));
                                        getGZIPHeader().setCRC(value2);
                                    } else {
                                        long value3 = zStream.adler.getValue();
                                        putShortMSB((int) (value3 >>> 16));
                                        putShortMSB((int) (value3 & 65535));
                                    }
                                    this.strm.flush_pending();
                                    i4 = this.wrap;
                                    if (i4 > 0) {
                                        this.wrap = -i4;
                                    }
                                    if (this.pending != 0) {
                                    }
                                }
                                return 1;
                            }
                        } else if (this.strm.avail_out == 0) {
                            this.last_flush = -1;
                        }
                    } else if (i == 4) {
                        i3 = this.wrap;
                        if (i3 > 0) {
                            zStream = this.strm;
                            if (i3 == 2) {
                                long value4 = zStream.adler.getValue();
                                put_byte((byte) (value4 & 255));
                                put_byte((byte) ((value4 >> c2) & 255));
                                put_byte((byte) ((value4 >> 16) & 255));
                                put_byte((byte) ((value4 >> 24) & 255));
                                put_byte((byte) (this.strm.total_in & 255));
                                put_byte((byte) ((this.strm.total_in >> c2) & 255));
                                put_byte((byte) ((this.strm.total_in >> 16) & 255));
                                put_byte((byte) (255 & (this.strm.total_in >> 24)));
                                getGZIPHeader().setCRC(value4);
                            } else {
                                long value5 = zStream.adler.getValue();
                                putShortMSB((int) (value5 >>> 16));
                                putShortMSB((int) (value5 & 65535));
                            }
                            this.strm.flush_pending();
                            i4 = this.wrap;
                            if (i4 > 0) {
                                this.wrap = -i4;
                            }
                            if (this.pending != 0) {
                            }
                        }
                        return 1;
                    }
                    return 0;
                }
                str = z_errmsg[7];
                zStream2.msg = str;
                return -5;
            }
            zStream2.msg = z_errmsg[4];
        }
        return -2;
    }

    public int deflateEnd() {
        int i = this.status;
        if (i != 42 && i != 113 && i != FINISH_STATE) {
            return -2;
        }
        this.pending_buf = null;
        this.l_buf = null;
        this.head = null;
        this.prev = null;
        this.window = null;
        return i == 113 ? -3 : 0;
    }

    public int deflateInit(int i) {
        return deflateInit(i, 15);
    }

    public int deflateInit(int i, int i2) {
        return deflateInit(i, 8, i2, 8, 0);
    }

    public int deflateInit(int i, int i2, int i3) {
        return deflateInit(i, 8, i2, i3, 0);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002e  */
    public int deflateParams(int i, int i2) {
        int iDeflate;
        if (i == -1) {
            i = 6;
        }
        if (i < 0 || i > 9 || i2 < 0 || i2 > 2) {
            return -2;
        }
        Config[] configArr = config_table;
        if (configArr[this.level].func != configArr[i].func) {
            ZStream zStream = this.strm;
            if (zStream.total_in != 0) {
                iDeflate = zStream.deflate(1);
            } else {
                iDeflate = 0;
            }
        } else {
            iDeflate = 0;
        }
        if (this.level != i) {
            this.level = i;
            Config config = configArr[i];
            this.max_lazy_match = config.max_lazy;
            this.good_match = config.good_length;
            this.nice_match = config.nice_length;
            this.max_chain_length = config.max_chain;
        }
        this.strategy = i2;
        return iDeflate;
    }

    public int deflateReset() {
        ZStream zStream = this.strm;
        zStream.total_out = 0L;
        zStream.total_in = 0L;
        zStream.msg = null;
        zStream.data_type = 2;
        this.pending = 0;
        this.pending_out = 0;
        int i = this.wrap;
        if (i < 0) {
            this.wrap = -i;
        }
        this.status = this.wrap == 0 ? 113 : 42;
        zStream.adler.reset();
        this.last_flush = 0;
        tr_init();
        lm_init();
        return 0;
    }

    public int deflateSetDictionary(byte[] bArr, int i) {
        int i2;
        if (bArr == null || this.status != 42) {
            return -2;
        }
        this.strm.adler.update(bArr, 0, i);
        if (i >= 3) {
            int i3 = this.w_size - 262;
            if (i > i3) {
                i2 = i - i3;
            } else {
                i3 = i;
                i2 = 0;
            }
            System.arraycopy(bArr, i2, this.window, 0, i3);
            this.strstart = i3;
            this.block_start = i3;
            byte[] bArr2 = this.window;
            this.ins_h = ((bArr2[1] & GZIPHeader.OS_UNKNOWN) ^ ((bArr2[0] & GZIPHeader.OS_UNKNOWN) << this.hash_shift)) & this.hash_mask;
            for (int i4 = 0; i4 <= i3 - 3; i4++) {
                int i5 = ((this.ins_h << this.hash_shift) ^ (this.window[i4 + 2] & GZIPHeader.OS_UNKNOWN)) & this.hash_mask;
                this.ins_h = i5;
                short[] sArr = this.prev;
                int i6 = this.w_mask & i4;
                short[] sArr2 = this.head;
                sArr[i6] = sArr2[i5];
                sArr2[i5] = (short) i4;
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0035  */
    /* JADX WARN: Code duplicated, block: B:33:0x0079  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0108 A[EDGE_INSN: B:49:0x0108->B:45:0x0108 BREAK  A[LOOP:0: B:3:0x0002->B:50:0x0002], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0002 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0002 A[SYNTHETIC] */
    public int deflate_fast(int i) {
        int i2;
        boolean z_tr_tally;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        while (true) {
            if (this.lookahead < MIN_LOOKAHEAD) {
                fill_window();
                int i8 = this.lookahead;
                if (i8 < MIN_LOOKAHEAD && i == 0) {
                    break;
                }
                if (i8 == 0) {
                    flush_block_only(i == 4);
                    if (this.strm.avail_out != 0) {
                        return i == 4 ? 3 : 1;
                    }
                    if (i == 4) {
                        return 2;
                    }
                } else {
                    if (this.lookahead >= 3) {
                        int i9 = this.ins_h << this.hash_shift;
                        byte[] bArr = this.window;
                        int i10 = this.strstart;
                        int i11 = (i9 ^ (bArr[i10 + 2] & GZIPHeader.OS_UNKNOWN)) & this.hash_mask;
                        this.ins_h = i11;
                        short[] sArr = this.head;
                        short s = sArr[i11];
                        this.prev[this.w_mask & i10] = s;
                        sArr[i11] = (short) i10;
                        i7 = s & 65535;
                    }
                    if (i7 != 0 && ((this.strstart - i7) & 65535) <= this.w_size - MIN_LOOKAHEAD && this.strategy != 2) {
                        this.match_length = longest_match(i7);
                    }
                    i2 = this.match_length;
                    if (i2 >= 3) {
                        z_tr_tally = _tr_tally(this.strstart - this.match_start, i2 - 3);
                        int i12 = this.lookahead;
                        i3 = this.match_length;
                        int i13 = i12 - i3;
                        this.lookahead = i13;
                        if (i3 <= this.max_lazy_match || i13 < 3) {
                            int i14 = this.strstart + i3;
                            this.strstart = i14;
                            this.match_length = 0;
                            byte[] bArr2 = this.window;
                            this.ins_h = ((bArr2[i14 + 1] & GZIPHeader.OS_UNKNOWN) ^ ((bArr2[i14] & GZIPHeader.OS_UNKNOWN) << this.hash_shift)) & this.hash_mask;
                        } else {
                            this.match_length = i3 - 1;
                            do {
                                i4 = this.strstart;
                                int i15 = i4 + 1;
                                this.strstart = i15;
                                int i16 = ((this.ins_h << this.hash_shift) ^ (this.window[i4 + 3] & GZIPHeader.OS_UNKNOWN)) & this.hash_mask;
                                this.ins_h = i16;
                                short[] sArr2 = this.head;
                                short s2 = sArr2[i16];
                                i5 = s2 & 65535;
                                this.prev[this.w_mask & i15] = s2;
                                sArr2[i16] = (short) i15;
                                i6 = this.match_length - 1;
                                this.match_length = i6;
                            } while (i6 != 0);
                            this.strstart = i4 + 2;
                            i7 = i5;
                        }
                    } else {
                        z_tr_tally = _tr_tally(0, this.window[this.strstart] & GZIPHeader.OS_UNKNOWN);
                        this.lookahead--;
                        this.strstart++;
                    }
                    if (z_tr_tally) {
                        flush_block_only(false);
                        if (this.strm.avail_out == 0) {
                            break;
                        }
                    }
                }
            } else {
                if (this.lookahead >= 3) {
                    int i17 = this.ins_h << this.hash_shift;
                    byte[] bArr3 = this.window;
                    int i18 = this.strstart;
                    int i19 = (i17 ^ (bArr3[i18 + 2] & GZIPHeader.OS_UNKNOWN)) & this.hash_mask;
                    this.ins_h = i19;
                    short[] sArr3 = this.head;
                    short s3 = sArr3[i19];
                    this.prev[this.w_mask & i18] = s3;
                    sArr3[i19] = (short) i18;
                    i7 = s3 & 65535;
                }
                if (i7 != 0) {
                    this.match_length = longest_match(i7);
                }
                i2 = this.match_length;
                if (i2 >= 3) {
                    z_tr_tally = _tr_tally(this.strstart - this.match_start, i2 - 3);
                    int i110 = this.lookahead;
                    i3 = this.match_length;
                    int i111 = i110 - i3;
                    this.lookahead = i111;
                    if (i3 <= this.max_lazy_match) {
                        int i112 = this.strstart + i3;
                        this.strstart = i112;
                        this.match_length = 0;
                        byte[] bArr4 = this.window;
                        this.ins_h = ((bArr4[i112 + 1] & GZIPHeader.OS_UNKNOWN) ^ ((bArr4[i112] & GZIPHeader.OS_UNKNOWN) << this.hash_shift)) & this.hash_mask;
                    } else {
                        int i113 = this.strstart + i3;
                        this.strstart = i113;
                        this.match_length = 0;
                        byte[] bArr5 = this.window;
                        this.ins_h = ((bArr5[i113 + 1] & GZIPHeader.OS_UNKNOWN) ^ ((bArr5[i113] & GZIPHeader.OS_UNKNOWN) << this.hash_shift)) & this.hash_mask;
                    }
                } else {
                    z_tr_tally = _tr_tally(0, this.window[this.strstart] & GZIPHeader.OS_UNKNOWN);
                    this.lookahead--;
                    this.strstart++;
                }
                if (z_tr_tally) {
                    flush_block_only(false);
                    if (this.strm.avail_out == 0) {
                        break;
                        break;
                    }
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0040  */
    /* JADX WARN: Code duplicated, block: B:26:0x0047  */
    /* JADX WARN: Code duplicated, block: B:35:0x008a  */
    /* JADX WARN: Code duplicated, block: B:63:0x0124  */
    /* JADX WARN: Code duplicated, block: B:74:0x0137 A[EDGE_INSN: B:74:0x0137->B:66:0x0137 BREAK  A[LOOP:0: B:3:0x0002->B:78:0x0002], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0002 A[SYNTHETIC] */
    public int deflate_slow(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        while (true) {
            if (this.lookahead < MIN_LOOKAHEAD) {
                fill_window();
                int i7 = this.lookahead;
                if (i7 < MIN_LOOKAHEAD && i == 0) {
                    break;
                }
                if (i7 == 0) {
                    if (this.match_available != 0) {
                        _tr_tally(0, this.window[this.strstart - 1] & GZIPHeader.OS_UNKNOWN);
                        this.match_available = 0;
                    }
                    flush_block_only(i == 4);
                    if (this.strm.avail_out != 0) {
                        return i == 4 ? 3 : 1;
                    }
                    if (i == 4) {
                        return 2;
                    }
                } else {
                    if (this.lookahead >= 3) {
                        int i8 = this.ins_h << this.hash_shift;
                        byte[] bArr = this.window;
                        int i9 = this.strstart;
                        int i10 = (i8 ^ (bArr[i9 + 2] & GZIPHeader.OS_UNKNOWN)) & this.hash_mask;
                        this.ins_h = i10;
                        short[] sArr = this.head;
                        short s = sArr[i10];
                        this.prev[this.w_mask & i9] = s;
                        sArr[i10] = (short) i9;
                        i6 = s & 65535;
                    }
                    int i11 = this.match_length;
                    this.prev_length = i11;
                    this.prev_match = this.match_start;
                    this.match_length = 2;
                    if (i6 != 0 && i11 < this.max_lazy_match && ((this.strstart - i6) & 65535) <= this.w_size - MIN_LOOKAHEAD) {
                        if (this.strategy != 2) {
                            this.match_length = longest_match(i6);
                        }
                        i5 = this.match_length;
                        if (i5 <= 5 && (this.strategy == 1 || (i5 == 3 && this.strstart - this.match_start > 4096))) {
                            this.match_length = 2;
                        }
                    }
                    i2 = this.prev_length;
                    if (i2 < 3 && this.match_length <= i2) {
                        int i12 = this.strstart;
                        int i13 = (this.lookahead + i12) - 3;
                        boolean z_tr_tally = _tr_tally((i12 - 1) - this.prev_match, i2 - 3);
                        int i14 = this.lookahead;
                        int i15 = this.prev_length;
                        this.lookahead = i14 - (i15 - 1);
                        this.prev_length = i15 - 2;
                        do {
                            i3 = this.strstart;
                            int i16 = i3 + 1;
                            this.strstart = i16;
                            if (i16 <= i13) {
                                int i17 = ((this.ins_h << this.hash_shift) ^ (this.window[i3 + 3] & GZIPHeader.OS_UNKNOWN)) & this.hash_mask;
                                this.ins_h = i17;
                                short[] sArr2 = this.head;
                                short s2 = sArr2[i17];
                                this.prev[this.w_mask & i16] = s2;
                                sArr2[i17] = (short) i16;
                                i6 = s2 & 65535;
                            }
                            i4 = this.prev_length - 1;
                            this.prev_length = i4;
                        } while (i4 != 0);
                        this.match_available = 0;
                        this.match_length = 2;
                        this.strstart = i3 + 2;
                        if (z_tr_tally) {
                            flush_block_only(false);
                            if (this.strm.avail_out == 0) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else if (this.match_available != 0) {
                        if (_tr_tally(0, this.window[this.strstart - 1] & GZIPHeader.OS_UNKNOWN)) {
                            flush_block_only(false);
                        }
                        this.strstart++;
                        this.lookahead--;
                        if (this.strm.avail_out == 0) {
                            break;
                        }
                    } else {
                        this.match_available = 1;
                        this.strstart++;
                        this.lookahead--;
                    }
                }
            } else {
                if (this.lookahead >= 3) {
                    int i18 = this.ins_h << this.hash_shift;
                    byte[] bArr2 = this.window;
                    int i19 = this.strstart;
                    int i110 = (i18 ^ (bArr2[i19 + 2] & GZIPHeader.OS_UNKNOWN)) & this.hash_mask;
                    this.ins_h = i110;
                    short[] sArr3 = this.head;
                    short s3 = sArr3[i110];
                    this.prev[this.w_mask & i19] = s3;
                    sArr3[i110] = (short) i19;
                    i6 = s3 & 65535;
                }
                int i111 = this.match_length;
                this.prev_length = i111;
                this.prev_match = this.match_start;
                this.match_length = 2;
                if (i6 != 0) {
                    if (this.strategy != 2) {
                        this.match_length = longest_match(i6);
                    }
                    i5 = this.match_length;
                    if (i5 <= 5) {
                        this.match_length = 2;
                    }
                }
                i2 = this.prev_length;
                if (i2 < 3) {
                }
                if (this.match_available != 0) {
                    if (_tr_tally(0, this.window[this.strstart - 1] & GZIPHeader.OS_UNKNOWN)) {
                        flush_block_only(false);
                    }
                    this.strstart++;
                    this.lookahead--;
                    if (this.strm.avail_out == 0) {
                        break;
                        break;
                    }
                } else {
                    this.match_available = 1;
                    this.strstart++;
                    this.lookahead--;
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0035  */
    /* JADX WARN: Code duplicated, block: B:29:0x0045  */
    /* JADX WARN: Code duplicated, block: B:32:0x0054  */
    /* JADX WARN: Code duplicated, block: B:37:0x005f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0068 A[EDGE_INSN: B:40:0x0068->B:36:0x0068 BREAK  A[LOOP:0: B:6:0x000b->B:42:0x000b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0068 A[EDGE_INSN: B:41:0x0068->B:36:0x0068 BREAK  A[LOOP:0: B:6:0x000b->B:42:0x000b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x000b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x000b A[SYNTHETIC] */
    public int deflate_stored(int i) {
        int i2;
        int i3;
        int i4 = this.pending_buf_size - 5;
        if (65535 <= i4) {
            i4 = 65535;
        }
        while (true) {
            if (this.lookahead <= 1) {
                fill_window();
                int i5 = this.lookahead;
                if (i5 == 0 && i == 0) {
                    break;
                }
                if (i5 == 0) {
                    flush_block_only(i == 4);
                    if (this.strm.avail_out != 0) {
                        return i == 4 ? 3 : 1;
                    }
                    if (i == 4) {
                        return 2;
                    }
                } else {
                    i2 = this.strstart + this.lookahead;
                    this.strstart = i2;
                    this.lookahead = 0;
                    i3 = this.block_start + i4;
                    if (i2 != 0 || i2 >= i3) {
                        this.lookahead = i2 - i3;
                        this.strstart = i3;
                        flush_block_only(false);
                        if (this.strm.avail_out == 0) {
                            break;
                        }
                        if (this.strstart - this.block_start >= this.w_size - 262) {
                            flush_block_only(false);
                            if (this.strm.avail_out == 0) {
                                break;
                            }
                        }
                    } else if (this.strstart - this.block_start >= this.w_size - 262) {
                        flush_block_only(false);
                        if (this.strm.avail_out == 0) {
                            break;
                            break;
                        }
                    }
                }
            } else {
                i2 = this.strstart + this.lookahead;
                this.strstart = i2;
                this.lookahead = 0;
                i3 = this.block_start + i4;
                if (i2 != 0) {
                    this.lookahead = i2 - i3;
                    this.strstart = i3;
                    flush_block_only(false);
                    if (this.strm.avail_out == 0) {
                        break;
                        break;
                    }
                    if (this.strstart - this.block_start >= this.w_size - 262) {
                        flush_block_only(false);
                        if (this.strm.avail_out == 0) {
                            break;
                            break;
                        }
                    }
                } else {
                    this.lookahead = i2 - i3;
                    this.strstart = i3;
                    flush_block_only(false);
                    if (this.strm.avail_out == 0) {
                        break;
                        break;
                    }
                    if (this.strstart - this.block_start >= this.w_size - 262) {
                        flush_block_only(false);
                        if (this.strm.avail_out == 0) {
                            break;
                            break;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public void fill_window() {
        int i;
        int i2;
        do {
            int i3 = this.window_size;
            int i4 = this.lookahead;
            int i5 = this.strstart;
            int i6 = (i3 - i4) - i5;
            if (i6 == 0 && i5 == 0 && i4 == 0) {
                i6 = this.w_size;
            } else if (i6 == -1) {
                i6--;
            } else {
                int i7 = this.w_size;
                if (i5 >= (i7 + i7) - MIN_LOOKAHEAD) {
                    byte[] bArr = this.window;
                    System.arraycopy(bArr, i7, bArr, 0, i7);
                    int i8 = this.match_start;
                    int i9 = this.w_size;
                    this.match_start = i8 - i9;
                    this.strstart -= i9;
                    this.block_start -= i9;
                    int i10 = this.hash_size;
                    int i11 = i10;
                    do {
                        short[] sArr = this.head;
                        i10--;
                        int i12 = sArr[i10] & 65535;
                        i = this.w_size;
                        sArr[i10] = i12 >= i ? (short) (i12 - i) : (short) 0;
                        i11--;
                    } while (i11 != 0);
                    int i13 = i;
                    do {
                        short[] sArr2 = this.prev;
                        i--;
                        int i14 = sArr2[i] & 65535;
                        i2 = this.w_size;
                        sArr2[i] = i14 >= i2 ? (short) (i14 - i2) : (short) 0;
                        i13--;
                    } while (i13 != 0);
                    i6 += i2;
                }
            }
            ZStream zStream = this.strm;
            if (zStream.avail_in == 0) {
                return;
            }
            int i15 = this.lookahead + zStream.read_buf(this.window, this.strstart + this.lookahead, i6);
            this.lookahead = i15;
            if (i15 >= 3) {
                byte[] bArr2 = this.window;
                int i16 = this.strstart;
                this.ins_h = ((bArr2[i16 + 1] & GZIPHeader.OS_UNKNOWN) ^ ((bArr2[i16] & GZIPHeader.OS_UNKNOWN) << this.hash_shift)) & this.hash_mask;
            }
            if (i15 >= MIN_LOOKAHEAD) {
                return;
            }
        } while (this.strm.avail_in != 0);
    }

    public void flush_block_only(boolean z) {
        int i = this.block_start;
        _tr_flush_block(i >= 0 ? i : -1, this.strstart - i, z);
        this.block_start = this.strstart;
        this.strm.flush_pending();
    }

    public synchronized GZIPHeader getGZIPHeader() {
        try {
            if (this.gheader == null) {
                this.gheader = new GZIPHeader();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.gheader;
    }

    public void init_block() {
        for (int i = 0; i < L_CODES; i++) {
            this.dyn_ltree[i * 2] = 0;
        }
        for (int i2 = 0; i2 < 30; i2++) {
            this.dyn_dtree[i2 * 2] = 0;
        }
        for (int i3 = 0; i3 < 19; i3++) {
            this.bl_tree[i3 * 2] = 0;
        }
        this.dyn_ltree[512] = 1;
        this.static_len = 0;
        this.opt_len = 0;
        this.matches = 0;
        this.last_lit = 0;
    }

    public void lm_init() {
        this.window_size = this.w_size * 2;
        this.head[this.hash_size - 1] = 0;
        for (int i = 0; i < this.hash_size - 1; i++) {
            this.head[i] = 0;
        }
        Config config = config_table[this.level];
        this.max_lazy_match = config.max_lazy;
        this.good_match = config.good_length;
        this.nice_match = config.nice_length;
        this.max_chain_length = config.max_chain;
        this.strstart = 0;
        this.block_start = 0;
        this.lookahead = 0;
        this.prev_length = 2;
        this.match_length = 2;
        this.match_available = 0;
        this.ins_h = 0;
    }

    public int longest_match(int i) {
        int i2;
        int i3;
        byte[] bArr;
        int i4;
        int i5 = this.max_chain_length;
        int i6 = this.strstart;
        int i7 = this.prev_length;
        int i8 = this.w_size - 262;
        int i9 = i6 > i8 ? i6 - i8 : 0;
        int i10 = this.nice_match;
        int i11 = this.w_mask;
        int i12 = i6 + MAX_MATCH;
        byte[] bArr2 = this.window;
        int i13 = i6 + i7;
        byte b = bArr2[i13 - 1];
        byte b2 = bArr2[i13];
        if (i7 >= this.good_match) {
            i5 >>= 2;
        }
        int i14 = this.lookahead;
        if (i10 > i14) {
            i10 = i14;
        }
        byte b3 = b2;
        int i15 = i7;
        int i16 = i5;
        int i17 = i;
        while (true) {
            byte[] bArr3 = this.window;
            int i18 = i17 + i15;
            if (bArr3[i18] == b3 && bArr3[i18 - 1] == b && bArr3[i17] == bArr3[i6] && bArr3[i17 + 1] == bArr3[i6 + 1]) {
                int i19 = i6 + 2;
                int i20 = i17 + 2;
                while (true) {
                    bArr = this.window;
                    i4 = i19 + 1;
                    i2 = i6;
                    if (bArr[i4] != bArr[i20 + 1]) {
                        break;
                    }
                    i4 = i19 + 2;
                    if (bArr[i4] != bArr[i20 + 2]) {
                        break;
                    }
                    i4 = i19 + 3;
                    if (bArr[i4] != bArr[i20 + 3]) {
                        break;
                    }
                    i4 = i19 + 4;
                    if (bArr[i4] != bArr[i20 + 4]) {
                        break;
                    }
                    i4 = i19 + 5;
                    if (bArr[i4] != bArr[i20 + 5]) {
                        break;
                    }
                    i4 = i19 + 6;
                    if (bArr[i4] != bArr[i20 + 6]) {
                        break;
                    }
                    i4 = i19 + 7;
                    if (bArr[i4] != bArr[i20 + 7]) {
                        break;
                    }
                    i19 += 8;
                    i20 += 8;
                    if (bArr[i19] != bArr[i20] || i19 >= i12) {
                        i4 = i19;
                        break;
                    }
                    i6 = i2;
                }
                i3 = 258 - (i12 - i4);
                if (i3 > i15) {
                    this.match_start = i17;
                    if (i3 >= i10) {
                        break;
                    }
                    int i21 = i2 + i3;
                    b = bArr[i21 - 1];
                    b3 = bArr[i21];
                    i15 = i3;
                }
            } else {
                i2 = i6;
            }
            i17 = this.prev[i17 & i11] & 65535;
            if (i17 <= i9 || (i16 = i16 - 1) == 0) {
                i3 = i15;
                break;
            }
            i6 = i2;
        }
        int i22 = this.lookahead;
        return i3 <= i22 ? i3 : i22;
    }

    public void pqdownheap(short[] sArr, int i) {
        int i2 = this.heap[i];
        int i3 = i << 1;
        while (true) {
            int i4 = this.heap_len;
            if (i3 > i4) {
                break;
            }
            if (i3 < i4) {
                int[] iArr = this.heap;
                int i5 = i3 + 1;
                if (smaller(sArr, iArr[i5], iArr[i3], this.depth)) {
                    i3 = i5;
                }
            }
            if (smaller(sArr, i2, this.heap[i3], this.depth)) {
                break;
            }
            int[] iArr2 = this.heap;
            iArr2[i] = iArr2[i3];
            int i6 = i3;
            i3 <<= 1;
            i = i6;
        }
        this.heap[i] = i2;
    }

    public final void putShortMSB(int i) {
        put_byte((byte) (i >> 8));
        put_byte((byte) i);
    }

    public final void put_byte(byte b) {
        byte[] bArr = this.pending_buf;
        int i = this.pending;
        this.pending = i + 1;
        bArr[i] = b;
    }

    public final void put_byte(byte[] bArr, int i, int i2) {
        System.arraycopy(bArr, i, this.pending_buf, this.pending, i2);
        this.pending += i2;
    }

    public final void put_short(int i) {
        put_byte((byte) i);
        put_byte((byte) (i >>> 8));
    }

    public void scan_tree(short[] sArr, int i) {
        int i2;
        int i3;
        short s = sArr[1];
        if (s == 0) {
            i2 = 138;
            i3 = 3;
        } else {
            i2 = 7;
            i3 = 4;
        }
        short s2 = -1;
        sArr[((i + 1) * 2) + 1] = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 <= i) {
            i4++;
            short s3 = sArr[(i4 * 2) + 1];
            i5++;
            if (i5 >= i2 || s != s3) {
                if (i5 < i3) {
                    short[] sArr2 = this.bl_tree;
                    int i6 = s * 2;
                    sArr2[i6] = (short) (sArr2[i6] + i5);
                } else if (s != 0) {
                    if (s != s2) {
                        short[] sArr3 = this.bl_tree;
                        int i7 = s * 2;
                        sArr3[i7] = (short) (sArr3[i7] + 1);
                    }
                    short[] sArr4 = this.bl_tree;
                    sArr4[32] = (short) (sArr4[32] + 1);
                } else {
                    short[] sArr5 = this.bl_tree;
                    if (i5 <= 10) {
                        sArr5[34] = (short) (sArr5[34] + 1);
                    } else {
                        sArr5[36] = (short) (sArr5[36] + 1);
                    }
                }
                if (s3 == 0) {
                    i2 = 138;
                } else {
                    if (s == s3) {
                        i2 = 6;
                    } else {
                        i2 = 7;
                        i3 = 4;
                    }
                    s2 = s;
                    i5 = 0;
                }
                i3 = 3;
                s2 = s;
                i5 = 0;
            }
            s = s3;
        }
    }

    public void send_all_trees(int i, int i2, int i3) {
        send_bits(i - 257, 5);
        int i4 = i2 - 1;
        send_bits(i4, 5);
        send_bits(i3 - 4, 4);
        for (int i5 = 0; i5 < i3; i5++) {
            send_bits(this.bl_tree[(Tree.bl_order[i5] * 2) + 1], 3);
        }
        send_tree(this.dyn_ltree, i - 1);
        send_tree(this.dyn_dtree, i4);
    }

    public void send_bits(int i, int i2) {
        int i3 = this.bi_valid;
        int i4 = 16 - i2;
        short s = this.bi_buf;
        if (i3 <= i4) {
            this.bi_buf = (short) (((i << i3) & 65535) | s);
            this.bi_valid = i3 + i2;
            return;
        }
        short s2 = (short) (((i << i3) & 65535) | s);
        this.bi_buf = s2;
        put_short(s2);
        int i5 = this.bi_valid;
        this.bi_buf = (short) (i >>> (16 - i5));
        this.bi_valid = (i2 - 16) + i5;
    }

    public final void send_code(int i, short[] sArr) {
        int i2 = i * 2;
        send_bits(sArr[i2] & 65535, sArr[i2 + 1] & 65535);
    }

    public void send_tree(short[] sArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 1;
        short s = sArr[1];
        if (s == 0) {
            i2 = 138;
            i3 = 3;
        } else {
            i2 = 7;
            i3 = 4;
        }
        short s2 = -1;
        int i7 = 0;
        int i8 = 0;
        while (i7 <= i) {
            i7++;
            short s3 = sArr[(i7 * 2) + i6];
            int i9 = i8 + 1;
            if (i9 >= i2 || s != s3) {
                if (i9 < i3) {
                    do {
                        send_code(s, this.bl_tree);
                        i9--;
                    } while (i9 != 0);
                } else if (s != 0) {
                    if (s != s2) {
                        send_code(s, this.bl_tree);
                    } else {
                        i8 = i9;
                    }
                    send_code(16, this.bl_tree);
                    send_bits(i8 - 3, 2);
                } else {
                    short[] sArr2 = this.bl_tree;
                    if (i9 <= 10) {
                        send_code(17, sArr2);
                        send_bits(i8 - 2, 3);
                    } else {
                        send_code(18, sArr2);
                        send_bits(i8 - 10, 7);
                    }
                }
                if (s3 == 0) {
                    i4 = 138;
                } else {
                    if (s == s3) {
                        i4 = 6;
                    } else {
                        i4 = 7;
                        i5 = 4;
                    }
                    s2 = s;
                    i3 = i5;
                    i8 = 0;
                    i2 = i4;
                }
                i5 = 3;
                s2 = s;
                i3 = i5;
                i8 = 0;
                i2 = i4;
            } else {
                i8 = i9;
            }
            s = s3;
            i6 = 1;
        }
    }

    public void set_data_type() {
        int i = 0;
        int i2 = 0;
        while (i < 7) {
            i2 += this.dyn_ltree[i * 2];
            i++;
        }
        int i3 = 0;
        while (i < 128) {
            i3 += this.dyn_ltree[i * 2];
            i++;
        }
        while (i < 256) {
            i2 += this.dyn_ltree[i * 2];
            i++;
        }
        this.data_type = (byte) (i2 <= (i3 >>> 2) ? 1 : 0);
    }

    public void tr_init() {
        Tree tree = this.l_desc;
        tree.dyn_tree = this.dyn_ltree;
        tree.stat_desc = StaticTree.static_l_desc;
        Tree tree2 = this.d_desc;
        tree2.dyn_tree = this.dyn_dtree;
        tree2.stat_desc = StaticTree.static_d_desc;
        Tree tree3 = this.bl_desc;
        tree3.dyn_tree = this.bl_tree;
        tree3.stat_desc = StaticTree.static_bl_desc;
        this.bi_buf = (short) 0;
        this.bi_valid = 0;
        this.last_eob_len = 8;
        init_block();
    }
}
