package com.jcraft.jzlib;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class Tree {
    private static final int BL_CODES = 19;
    static final int Buf_size = 16;
    static final int DIST_CODE_LEN = 512;
    private static final int D_CODES = 30;
    static final int END_BLOCK = 256;
    private static final int HEAP_SIZE = 573;
    private static final int LENGTH_CODES = 29;
    private static final int LITERALS = 256;
    private static final int L_CODES = 286;
    private static final int MAX_BITS = 15;
    static final int MAX_BL_BITS = 7;
    static final int REPZ_11_138 = 18;
    static final int REPZ_3_10 = 17;
    static final int REP_3_6 = 16;
    short[] dyn_tree;
    int max_code;
    StaticTree stat_desc;
    static final int[] extra_lbits = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0};
    static final int[] extra_dbits = {0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13};
    static final int[] extra_blbits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 7};
    static final byte[] bl_order = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, GZIPHeader.OS_WIN32, 4, GZIPHeader.OS_QDOS, 3, GZIPHeader.OS_RISCOS, 2, 14, 1, 15};
    static final byte[] _dist_code = {0, 1, 2, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 0, 0, 16, 17, 18, 18, 19, 19, 20, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29};
    static final byte[] _length_code = {0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 10, 10, GZIPHeader.OS_WIN32, GZIPHeader.OS_WIN32, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_QDOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, GZIPHeader.OS_RISCOS, 14, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 28};
    static final int[] base_length = {0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 14, 16, 20, 24, 28, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 0};
    static final int[] base_dist = {0, 1, 2, 3, 4, 6, 8, 12, 16, 24, 32, 48, 64, 96, 128, 192, 256, 384, 512, 768, 1024, 1536, 2048, 3072, 4096, 6144, AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT, 12288, AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME, 24576};

    private static final int bi_reverse(int i, int i2) {
        int i3 = 0;
        do {
            int i4 = i3 | (i & 1);
            i >>>= 1;
            i3 = i4 << 1;
            i2--;
        } while (i2 > 0);
        return i3 >>> 1;
    }

    public static int d_code(int i) {
        return i < 256 ? _dist_code[i] : _dist_code[(i >>> 7) + 256];
    }

    private static final void gen_codes(short[] sArr, int i, short[] sArr2, short[] sArr3) {
        sArr3[0] = 0;
        short s = 0;
        for (int i2 = 1; i2 <= 15; i2++) {
            s = (short) ((s + sArr2[i2 - 1]) << 1);
            sArr3[i2] = s;
        }
        for (int i3 = 0; i3 <= i; i3++) {
            int i4 = i3 * 2;
            short s2 = sArr[i4 + 1];
            if (s2 != 0) {
                short s3 = sArr3[s2];
                sArr3[s2] = (short) (s3 + 1);
                sArr[i4] = (short) bi_reverse(s3, s2);
            }
        }
    }

    public void build_tree(Deflate deflate) {
        int i;
        int i2;
        int i3;
        short[] sArr = this.dyn_tree;
        StaticTree staticTree = this.stat_desc;
        short[] sArr2 = staticTree.static_tree;
        int i4 = staticTree.elems;
        deflate.heap_len = 0;
        deflate.heap_max = HEAP_SIZE;
        int i5 = -1;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = i6 * 2;
            if (sArr[i7] != 0) {
                int[] iArr = deflate.heap;
                int i8 = deflate.heap_len + 1;
                deflate.heap_len = i8;
                iArr[i8] = i6;
                deflate.depth[i6] = 0;
                i5 = i6;
            } else {
                sArr[i7 + 1] = 0;
            }
        }
        while (true) {
            i = deflate.heap_len;
            if (i >= 2) {
                break;
            }
            int[] iArr2 = deflate.heap;
            int i9 = i + 1;
            deflate.heap_len = i9;
            if (i5 < 2) {
                i3 = i5 + 1;
                i2 = i3;
            } else {
                i2 = i5;
                i3 = 0;
            }
            iArr2[i9] = i3;
            int i10 = i3 * 2;
            sArr[i10] = 1;
            deflate.depth[i3] = 0;
            deflate.opt_len--;
            if (sArr2 != null) {
                deflate.static_len -= sArr2[i10 + 1];
            }
            i5 = i2;
        }
        this.max_code = i5;
        for (int i11 = i / 2; i11 >= 1; i11--) {
            deflate.pqdownheap(sArr, i11);
        }
        while (true) {
            int[] iArr3 = deflate.heap;
            int i12 = iArr3[1];
            int i13 = deflate.heap_len;
            deflate.heap_len = i13 - 1;
            iArr3[1] = iArr3[i13];
            deflate.pqdownheap(sArr, 1);
            int[] iArr4 = deflate.heap;
            int i14 = iArr4[1];
            int i15 = deflate.heap_max;
            iArr4[i15 - 1] = i12;
            int i16 = i15 - 2;
            deflate.heap_max = i16;
            iArr4[i16] = i14;
            int i17 = i12 * 2;
            int i18 = i14 * 2;
            sArr[i4 * 2] = (short) (sArr[i17] + sArr[i18]);
            byte[] bArr = deflate.depth;
            bArr[i4] = (byte) (Math.max((int) bArr[i12], (int) bArr[i14]) + 1);
            short s = (short) i4;
            sArr[i18 + 1] = s;
            sArr[i17 + 1] = s;
            int i19 = i4 + 1;
            deflate.heap[1] = i4;
            deflate.pqdownheap(sArr, 1);
            if (deflate.heap_len < 2) {
                int[] iArr5 = deflate.heap;
                int i20 = deflate.heap_max - 1;
                deflate.heap_max = i20;
                iArr5[i20] = iArr5[1];
                gen_bitlen(deflate);
                gen_codes(sArr, i5, deflate.bl_count, deflate.next_code);
                return;
            }
            i4 = i19;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void gen_bitlen(Deflate deflate) {
        short[] sArr;
        short s;
        short[] sArr2 = this.dyn_tree;
        StaticTree staticTree = this.stat_desc;
        short[] sArr3 = staticTree.static_tree;
        int[] iArr = staticTree.extra_bits;
        int i = staticTree.extra_base;
        int i2 = staticTree.max_length;
        for (int i3 = 0; i3 <= 15; i3++) {
            deflate.bl_count[i3] = 0;
        }
        int[] iArr2 = deflate.heap;
        int i4 = deflate.heap_max;
        sArr2[(iArr2[i4] * 2) + 1] = 0;
        int i5 = i4 + 1;
        int i6 = 0;
        while (i5 < HEAP_SIZE) {
            int i7 = deflate.heap[i5];
            int i8 = i7 * 2;
            int i9 = i8 + 1;
            int i10 = sArr2[(sArr2[i9] * 2) + 1] + 1;
            if (i10 > i2) {
                i6++;
                i10 = i2;
            }
            sArr2[i9] = (short) i10;
            if (i7 <= this.max_code) {
                short[] sArr4 = deflate.bl_count;
                sArr4[i10] = (short) (sArr4[i10] + 1);
                int i11 = i7 >= i ? iArr[i7 - i] : 0;
                short s2 = sArr2[i8];
                deflate.opt_len = ((i10 + i11) * s2) + deflate.opt_len;
                if (sArr3 != null) {
                    deflate.static_len = ((sArr3[i9] + i11) * s2) + deflate.static_len;
                }
            }
            i5++;
        }
        if (i6 == 0) {
            return;
        }
        do {
            int i12 = i2 - 1;
            while (true) {
                sArr = deflate.bl_count;
                s = sArr[i12];
                if (s != 0) {
                    break;
                } else {
                    i12--;
                }
            }
            sArr[i12] = (short) (s - 1);
            int i13 = i12 + 1;
            sArr[i13] = (short) (sArr[i13] + 2);
            sArr[i2] = (short) (sArr[i2] - 1);
            i6 -= 2;
        } while (i6 > 0);
        while (i2 != 0) {
            short s3 = deflate.bl_count[i2];
            while (s3 != 0) {
                i5--;
                int i14 = deflate.heap[i5];
                if (i14 <= this.max_code) {
                    int i15 = i14 * 2;
                    int i16 = i15 + 1;
                    short s4 = sArr2[i16];
                    if (s4 != i2) {
                        deflate.opt_len = (int) (((((long) i2) - ((long) s4)) * ((long) sArr2[i15])) + ((long) deflate.opt_len));
                        sArr2[i16] = (short) i2;
                    }
                    s3--;
                }
            }
            i2--;
        }
    }
}
