package com.jcraft.jzlib;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class InfBlocks {
    private static final int BAD = 9;
    private static final int BTREE = 4;
    private static final int CODES = 6;
    private static final int DONE = 8;
    private static final int DRY = 7;
    private static final int DTREE = 5;
    private static final int LENS = 1;
    private static final int MANY = 1440;
    private static final int STORED = 2;
    private static final int TABLE = 3;
    private static final int TYPE = 0;
    private static final int Z_BUF_ERROR = -5;
    private static final int Z_DATA_ERROR = -3;
    private static final int Z_ERRNO = -1;
    private static final int Z_MEM_ERROR = -4;
    private static final int Z_NEED_DICT = 2;
    private static final int Z_OK = 0;
    private static final int Z_STREAM_END = 1;
    private static final int Z_STREAM_ERROR = -2;
    private static final int Z_VERSION_ERROR = -6;
    int bitb;
    int bitk;
    int[] blens;
    private boolean check;
    private final InfCodes codes;
    int end;
    int index;
    int last;
    int left;
    int mode;
    int read;
    int table;
    byte[] window;
    int write;
    private final ZStream z;
    private static final int[] inflate_mask = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    static final int[] border = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};
    int[] bb = new int[1];
    int[] tb = new int[1];
    int[] bl = new int[1];
    int[] bd = new int[1];
    int[][] tl = new int[1][];
    int[][] td = new int[1][];
    int[] tli = new int[1];
    int[] tdi = new int[1];
    private final InfTree inftree = new InfTree();
    int[] hufts = new int[4320];

    public InfBlocks(ZStream zStream, int i) {
        this.z = zStream;
        this.codes = new InfCodes(zStream, this);
        this.window = new byte[i];
        this.end = i;
        this.check = zStream.istate.wrap != 0;
        this.mode = 0;
        reset();
    }

    public void free() {
        reset();
        this.window = null;
        this.hufts = null;
    }

    public int inflate_flush(int i) {
        ZStream zStream = this.z;
        int i2 = zStream.next_out_index;
        int i3 = this.read;
        int i4 = this.write;
        if (i3 > i4) {
            i4 = this.end;
        }
        int i5 = i4 - i3;
        int i6 = zStream.avail_out;
        if (i5 > i6) {
            i5 = i6;
        }
        if (i5 != 0 && i == -5) {
            i = 0;
        }
        zStream.avail_out = i6 - i5;
        zStream.total_out += (long) i5;
        if (this.check && i5 > 0) {
            zStream.adler.update(this.window, i3, i5);
        }
        System.arraycopy(this.window, i3, this.z.next_out, i2, i5);
        int i7 = i2 + i5;
        int i8 = i3 + i5;
        int i9 = this.end;
        if (i8 == i9) {
            if (this.write == i9) {
                this.write = 0;
            }
            int i10 = this.write;
            ZStream zStream2 = this.z;
            int i11 = zStream2.avail_out;
            if (i10 > i11) {
                i10 = i11;
            }
            if (i10 != 0 && i == -5) {
                i = 0;
            }
            zStream2.avail_out = i11 - i10;
            zStream2.total_out += (long) i10;
            if (this.check && i10 > 0) {
                zStream2.adler.update(this.window, 0, i10);
            }
            System.arraycopy(this.window, 0, this.z.next_out, i7, i10);
            i7 += i10;
            i8 = i10;
        }
        this.z.next_out_index = i7;
        this.read = i8;
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x032d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x032f A[LOOP:4: B:99:0x0329->B:102:0x032f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:107:0x037a  */
    /* JADX WARN: Code duplicated, block: B:212:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:213:0x0165 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x01d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x0232 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x025e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:217:0x02cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x0342 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x0381 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:239:0x019a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:251:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00e8 A[ADDED_TO_REGION, LOOP:7: B:38:0x00e8->B:40:0x00ec, LOOP_START, PHI: r1 r2 r3 r4 r5
      0x00e8: PHI (r1v39 int) = (r1v36 int), (r1v46 int) binds: [B:37:0x00e6, B:40:0x00ec] A[DONT_GENERATE, DONT_INLINE]
      0x00e8: PHI (r2v24 int) = (r2v21 int), (r2v27 int) binds: [B:37:0x00e6, B:40:0x00ec] A[DONT_GENERATE, DONT_INLINE]
      0x00e8: PHI (r3v10 int) = (r3v9 int), (r3v11 int) binds: [B:37:0x00e6, B:40:0x00ec] A[DONT_GENERATE, DONT_INLINE]
      0x00e8: PHI (r4v22 int) = (r4v19 int), (r4v25 int) binds: [B:37:0x00e6, B:40:0x00ec] A[DONT_GENERATE, DONT_INLINE]
      0x00e8: PHI (r5v11 int) = (r5v10 int), (r5v13 int) binds: [B:37:0x00e6, B:40:0x00ec] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ea A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ec A[LOOP:7: B:38:0x00e8->B:40:0x00ec, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x0136 A[LOOP:8: B:44:0x0130->B:46:0x0136, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x0167  */
    /* JADX WARN: Code duplicated, block: B:53:0x0186  */
    /* JADX WARN: Code duplicated, block: B:60:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:63:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:68:0x0237  */
    /* JADX WARN: Code duplicated, block: B:70:0x024e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0252  */
    /* JADX WARN: Code duplicated, block: B:74:0x0259  */
    /* JADX WARN: Code duplicated, block: B:83:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:85:0x02b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x02b8 A[LOOP:3: B:84:0x02b4->B:86:0x02b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:91:0x030a  */
    /* JADX WARN: Code duplicated, block: B:92:0x031a  */
    /* JADX WARN: Code duplicated, block: B:94:0x031e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0320  */
    /* JADX WARN: Code duplicated, block: B:97:0x0324  */
    /* JADX WARN: Code duplicated, block: B:98:0x0327  */
    public int proc(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int iInflate_trees_bits;
        int i7;
        int iProc;
        int i8;
        int i9;
        int i10;
        int iInflate_trees_dynamic;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        ZStream zStream = this.z;
        int i21 = zStream.next_in_index;
        int i22 = zStream.avail_in;
        int i23 = this.bitb;
        int i24 = this.bitk;
        int i25 = this.write;
        int i26 = this.read;
        int i27 = i25 < i26 ? (i26 - i25) - 1 : this.end - i25;
        int i28 = i25;
        int i29 = i24;
        int i30 = i23;
        int i31 = i21;
        int i32 = i22;
        int i33 = i;
        while (true) {
            int i34 = 9;
            int i35 = 7;
            switch (this.mode) {
                case 0:
                    int i36 = 6;
                    for (int i37 = 3; i29 < i37; i37 = 3) {
                        if (i32 == 0) {
                            this.bitb = i30;
                            this.bitk = i29;
                            ZStream zStream2 = this.z;
                            zStream2.avail_in = i32;
                            zStream2.total_in += (long) (i31 - zStream2.next_in_index);
                            zStream2.next_in_index = i31;
                            this.write = i28;
                            return inflate_flush(i33);
                        }
                        i32--;
                        i30 |= (this.z.next_in[i31] & GZIPHeader.OS_UNKNOWN) << i29;
                        i29 += 8;
                        i31++;
                        i33 = 0;
                    }
                    this.last = i30 & 1;
                    int i38 = (i30 & 7) >>> 1;
                    if (i38 != 0) {
                        if (i38 != 1) {
                            i36 = 3;
                            if (i38 != 2) {
                                if (i38 == 3) {
                                    int i39 = i30 >>> 3;
                                    this.mode = 9;
                                    ZStream zStream3 = this.z;
                                    zStream3.msg = "invalid block type";
                                    this.bitb = i39;
                                    this.bitk = i29 - 3;
                                    zStream3.avail_in = i32;
                                    zStream3.total_in += (long) (i31 - zStream3.next_in_index);
                                    zStream3.next_in_index = i31;
                                    this.write = i28;
                                    return inflate_flush(-3);
                                }
                            }
                        } else {
                            InfTree.inflate_trees_fixed(this.bl, this.bd, this.tl, this.td, this.z);
                            this.codes.init(this.bl[0], this.bd[0], this.tl[0], 0, this.td[0], 0);
                        }
                        i30 >>>= 3;
                        i29 -= 3;
                        this.mode = i36;
                    } else {
                        int i40 = i29 - 3;
                        int i41 = i40 & 7;
                        i30 = (i30 >>> 3) >>> i41;
                        i29 = i40 - i41;
                        this.mode = 1;
                    }
                    break;
                case 1:
                    while (i29 < 32) {
                        if (i32 == 0) {
                            this.bitb = i30;
                            this.bitk = i29;
                            ZStream zStream4 = this.z;
                            zStream4.avail_in = i32;
                            zStream4.total_in += (long) (i31 - zStream4.next_in_index);
                            zStream4.next_in_index = i31;
                            this.write = i28;
                            return inflate_flush(i33);
                        }
                        i32--;
                        i30 |= (this.z.next_in[i31] & 255) << i29;
                        i29 += 8;
                        i31++;
                        i33 = 0;
                    }
                    int i42 = 65535 & i30;
                    if ((((~i30) >>> 16) & 65535) != i42) {
                        this.mode = 9;
                        ZStream zStream5 = this.z;
                        zStream5.msg = "invalid stored block lengths";
                        this.bitb = i30;
                        this.bitk = i29;
                        zStream5.avail_in = i32;
                        zStream5.total_in += (long) (i31 - zStream5.next_in_index);
                        zStream5.next_in_index = i31;
                        this.write = i28;
                        return inflate_flush(-3);
                    }
                    this.left = i42;
                    this.mode = i42 != 0 ? 2 : this.last != 0 ? 7 : 0;
                    i30 = 0;
                    i29 = 0;
                    break;
                    break;
                case 2:
                    if (i32 == 0) {
                        this.bitb = i30;
                        this.bitk = i29;
                        ZStream zStream6 = this.z;
                        zStream6.avail_in = i32;
                        zStream6.total_in += (long) (i31 - zStream6.next_in_index);
                        zStream6.next_in_index = i31;
                        this.write = i28;
                        return inflate_flush(i33);
                    }
                    if (i27 == 0) {
                        int i43 = this.end;
                        if (i28 == i43 && (i3 = this.read) != 0) {
                            i27 = i3 > 0 ? i3 - 1 : i43;
                            i28 = 0;
                        }
                        if (i27 == 0) {
                            this.write = i28;
                            int iInflate_flush = inflate_flush(i33);
                            i28 = this.write;
                            int i44 = this.read;
                            i27 = i28 < i44 ? (i44 - i28) - 1 : this.end - i28;
                            int i45 = this.end;
                            if (i28 == i45 && i44 != 0) {
                                if (i44 > 0) {
                                    i45 = i44 - 1;
                                }
                                i27 = i45;
                                i28 = 0;
                            }
                            if (i27 == 0) {
                                this.bitb = i30;
                                this.bitk = i29;
                                ZStream zStream7 = this.z;
                                zStream7.avail_in = i32;
                                zStream7.total_in += (long) (i31 - zStream7.next_in_index);
                                zStream7.next_in_index = i31;
                                this.write = i28;
                                return inflate_flush(iInflate_flush);
                            }
                        }
                    }
                    int i46 = this.left;
                    if (i46 > i32) {
                        i46 = i32;
                    }
                    if (i46 > i27) {
                        i46 = i27;
                    }
                    System.arraycopy(this.z.next_in, i31, this.window, i28, i46);
                    i31 += i46;
                    i32 -= i46;
                    i28 += i46;
                    int i47 = i27 - i46;
                    int i48 = this.left - i46;
                    this.left = i48;
                    if (i48 == 0) {
                        this.mode = this.last != 0 ? 7 : 0;
                    }
                    i2 = i47;
                    i27 = i2;
                    i33 = 0;
                    break;
                    break;
                case 3:
                    while (i29 < 14) {
                        if (i32 == 0) {
                            this.bitb = i30;
                            this.bitk = i29;
                            ZStream zStream8 = this.z;
                            zStream8.avail_in = i32;
                            zStream8.total_in += (long) (i31 - zStream8.next_in_index);
                            zStream8.next_in_index = i31;
                            this.write = i28;
                            return inflate_flush(i33);
                        }
                        i32--;
                        i30 |= (this.z.next_in[i31] & GZIPHeader.OS_UNKNOWN) << i29;
                        i29 += 8;
                        i33 = 0;
                        i31++;
                    }
                    int i49 = i30 & 16383;
                    this.table = i49;
                    int i50 = i30 & 31;
                    i4 = 6;
                    if (i50 > 29 || (i5 = (i49 >> 5) & 31) > 29) {
                        this.mode = 9;
                        ZStream zStream9 = this.z;
                        zStream9.msg = "too many length or distance symbols";
                        this.bitb = i30;
                        this.bitk = i29;
                        zStream9.avail_in = i32;
                        zStream9.total_in += (long) (i31 - zStream9.next_in_index);
                        zStream9.next_in_index = i31;
                        this.write = i28;
                        return inflate_flush(-3);
                    }
                    int i51 = i50 + 258 + i5;
                    int[] iArr = this.blens;
                    if (iArr == null || iArr.length < i51) {
                        this.blens = new int[i51];
                    } else {
                        for (int i52 = 0; i52 < i51; i52++) {
                            this.blens[i52] = 0;
                        }
                    }
                    i30 >>>= 14;
                    i29 -= 14;
                    this.index = 0;
                    this.mode = 4;
                    for (int i53 = 4; this.index < (this.table >>> 10) + i53; i53 = 4) {
                        while (i29 < 3) {
                            if (i32 != 0) {
                                this.bitb = i30;
                                this.bitk = i29;
                                ZStream zStream10 = this.z;
                                zStream10.avail_in = i32;
                                zStream10.total_in += (long) (i31 - zStream10.next_in_index);
                                zStream10.next_in_index = i31;
                                this.write = i28;
                                return inflate_flush(i33);
                            }
                            i32--;
                            i30 |= (this.z.next_in[i31] & GZIPHeader.OS_UNKNOWN) << i29;
                            i29 += 8;
                            i33 = 0;
                            i31++;
                        }
                        int[] iArr2 = this.blens;
                        int[] iArr3 = border;
                        int i54 = this.index;
                        this.index = i54 + 1;
                        iArr2[iArr3[i54]] = i30 & 7;
                        i30 >>>= 3;
                        i29 -= 3;
                    }
                    while (true) {
                        i6 = this.index;
                        if (i6 >= 19) {
                            int[] iArr4 = this.bb;
                            iArr4[0] = 7;
                            iInflate_trees_bits = this.inftree.inflate_trees_bits(this.blens, iArr4, this.tb, this.hufts, this.z);
                            if (iInflate_trees_bits != 0) {
                                if (iInflate_trees_bits == -3) {
                                    this.blens = null;
                                    this.mode = 9;
                                }
                                this.bitb = i30;
                                this.bitk = i29;
                                ZStream zStream11 = this.z;
                                zStream11.avail_in = i32;
                                zStream11.total_in += (long) (i31 - zStream11.next_in_index);
                                zStream11.next_in_index = i31;
                                this.write = i28;
                                return inflate_flush(iInflate_trees_bits);
                            }
                            this.index = 0;
                            i7 = 5;
                            this.mode = 5;
                            while (true) {
                                int i55 = this.table;
                                i9 = i55 & 31;
                                i10 = (i55 >> i7) & 31;
                                if (this.index >= i9 + 258 + i10) {
                                    this.tb[0] = -1;
                                    int[] iArr5 = this.bl;
                                    iArr5[0] = i34;
                                    int[] iArr6 = this.bd;
                                    iArr6[0] = i4;
                                    iInflate_trees_dynamic = this.inftree.inflate_trees_dynamic(i9 + 257, i10 + 1, this.blens, iArr5, iArr6, this.tli, this.tdi, this.hufts, this.z);
                                    if (iInflate_trees_dynamic != 0) {
                                        if (iInflate_trees_dynamic == -3) {
                                            this.blens = null;
                                            this.mode = 9;
                                        }
                                        this.bitb = i30;
                                        this.bitk = i29;
                                        ZStream zStream12 = this.z;
                                        zStream12.avail_in = i32;
                                        zStream12.total_in += (long) (i31 - zStream12.next_in_index);
                                        zStream12.next_in_index = i31;
                                        this.write = i28;
                                        return inflate_flush(iInflate_trees_dynamic);
                                    }
                                    InfCodes infCodes = this.codes;
                                    int i56 = this.bl[0];
                                    int i57 = this.bd[0];
                                    int[] iArr7 = this.hufts;
                                    infCodes.init(i56, i57, iArr7, this.tli[0], iArr7, this.tdi[0]);
                                    this.mode = i4;
                                } else {
                                    i11 = i35;
                                    int i58 = i4;
                                    i12 = this.bb[0];
                                    while (i29 < i12) {
                                        if (i32 == 0) {
                                            this.bitb = i30;
                                            this.bitk = i29;
                                            ZStream zStream13 = this.z;
                                            zStream13.avail_in = i32;
                                            zStream13.total_in += (long) (i31 - zStream13.next_in_index);
                                            zStream13.next_in_index = i31;
                                            this.write = i28;
                                            return inflate_flush(i33);
                                        }
                                        i32--;
                                        i30 |= (this.z.next_in[i31] & GZIPHeader.OS_UNKNOWN) << i29;
                                        i29 += 8;
                                        i31++;
                                        i33 = 0;
                                    }
                                    int i59 = this.tb[0];
                                    int[] iArr8 = this.hufts;
                                    int[] iArr9 = inflate_mask;
                                    i13 = iArr8[(((iArr9[i12] & i30) + i59) * 3) + 1];
                                    i14 = iArr8[((i59 + (iArr9[i13] & i30)) * 3) + 2];
                                    if (i14 < 16) {
                                        i30 >>>= i13;
                                        i29 -= i13;
                                        int[] iArr10 = this.blens;
                                        int i60 = this.index;
                                        this.index = i60 + 1;
                                        iArr10[i60] = i14;
                                        i20 = 5;
                                    } else {
                                        if (i14 == 18) {
                                            i15 = i11;
                                        } else {
                                            i15 = i14 - 14;
                                        }
                                        if (i14 == 18) {
                                            i16 = 11;
                                        } else {
                                            i16 = 3;
                                        }
                                        while (i29 < i13 + i15) {
                                            if (i32 == 0) {
                                                this.bitb = i30;
                                                this.bitk = i29;
                                                ZStream zStream14 = this.z;
                                                zStream14.avail_in = i32;
                                                zStream14.total_in += (long) (i31 - zStream14.next_in_index);
                                                zStream14.next_in_index = i31;
                                                this.write = i28;
                                                return inflate_flush(i33);
                                            }
                                            i32--;
                                            i30 |= (this.z.next_in[i31] & GZIPHeader.OS_UNKNOWN) << i29;
                                            i29 += 8;
                                            i31++;
                                            i33 = 0;
                                        }
                                        int i61 = i30 >>> i13;
                                        i17 = i16 + (inflate_mask[i15] & i61);
                                        i30 = i61 >>> i15;
                                        i29 = (i29 - i13) - i15;
                                        i18 = this.index;
                                        i19 = this.table;
                                        i20 = 5;
                                        if (i18 + i17 <= (i19 & 31) + 258 + ((i19 >> 5) & 31) || (i14 == 16 && i18 < 1)) {
                                            this.blens = null;
                                            this.mode = 9;
                                            ZStream zStream15 = this.z;
                                            zStream15.msg = "invalid bit length repeat";
                                            this.bitb = i30;
                                            this.bitk = i29;
                                            zStream15.avail_in = i32;
                                            zStream15.total_in += (long) (i31 - zStream15.next_in_index);
                                            zStream15.next_in_index = i31;
                                            this.write = i28;
                                            return inflate_flush(-3);
                                        }
                                        int i62 = i14 == 16 ? this.blens[i18 - 1] : 0;
                                        while (true) {
                                            int i63 = i18 + 1;
                                            this.blens[i18] = i62;
                                            i17--;
                                            if (i17 == 0) {
                                                this.index = i63;
                                            } else {
                                                i18 = i63;
                                            }
                                        }
                                    }
                                    i4 = i58;
                                    i35 = i11;
                                    i7 = i20;
                                    i34 = 9;
                                }
                            }
                            this.bitb = i30;
                            this.bitk = i29;
                            ZStream zStream16 = this.z;
                            zStream16.avail_in = i32;
                            zStream16.total_in += (long) (i31 - zStream16.next_in_index);
                            zStream16.next_in_index = i31;
                            this.write = i28;
                            iProc = this.codes.proc(i33);
                            if (iProc != 1) {
                                return inflate_flush(iProc);
                            }
                            this.codes.free(this.z);
                            ZStream zStream17 = this.z;
                            i31 = zStream17.next_in_index;
                            i32 = zStream17.avail_in;
                            i30 = this.bitb;
                            i29 = this.bitk;
                            i28 = this.write;
                            i8 = this.read;
                            if (i28 < i8) {
                                i2 = (i8 - i28) - 1;
                            } else {
                                i2 = this.end - i28;
                            }
                            if (this.last == 0) {
                                this.mode = 0;
                                i27 = i2;
                                i33 = 0;
                            } else {
                                this.mode = i35;
                                i33 = 0;
                            }
                        } else {
                            int[] iArr11 = this.blens;
                            int[] iArr12 = border;
                            this.index = i6 + 1;
                            iArr11[iArr12[i6]] = 0;
                        }
                        break;
                    }
                    break;
                case 4:
                    i4 = 6;
                    while (this.index < (this.table >>> 10) + i53) {
                        while (i29 < 3) {
                            if (i32 != 0) {
                                this.bitb = i30;
                                this.bitk = i29;
                                ZStream zStream18 = this.z;
                                zStream18.avail_in = i32;
                                zStream18.total_in += (long) (i31 - zStream18.next_in_index);
                                zStream18.next_in_index = i31;
                                this.write = i28;
                                return inflate_flush(i33);
                            }
                            i32--;
                            i30 |= (this.z.next_in[i31] & GZIPHeader.OS_UNKNOWN) << i29;
                            i29 += 8;
                            i33 = 0;
                            i31++;
                        }
                        int[] iArr13 = this.blens;
                        int[] iArr14 = border;
                        int i510 = this.index;
                        this.index = i510 + 1;
                        iArr13[iArr14[i510]] = i30 & 7;
                        i30 >>>= 3;
                        i29 -= 3;
                    }
                    while (true) {
                        i6 = this.index;
                        if (i6 >= 19) {
                            int[] iArr15 = this.blens;
                            int[] iArr16 = border;
                            this.index = i6 + 1;
                            iArr15[iArr16[i6]] = 0;
                        } else {
                            int[] iArr17 = this.bb;
                            iArr17[0] = 7;
                            iInflate_trees_bits = this.inftree.inflate_trees_bits(this.blens, iArr17, this.tb, this.hufts, this.z);
                            if (iInflate_trees_bits != 0) {
                                if (iInflate_trees_bits == -3) {
                                    this.blens = null;
                                    this.mode = 9;
                                }
                                this.bitb = i30;
                                this.bitk = i29;
                                ZStream zStream19 = this.z;
                                zStream19.avail_in = i32;
                                zStream19.total_in += (long) (i31 - zStream19.next_in_index);
                                zStream19.next_in_index = i31;
                                this.write = i28;
                                return inflate_flush(iInflate_trees_bits);
                            }
                            this.index = 0;
                            i7 = 5;
                            this.mode = 5;
                            while (true) {
                                int i511 = this.table;
                                i9 = i511 & 31;
                                i10 = (i511 >> i7) & 31;
                                if (this.index >= i9 + 258 + i10) {
                                    this.tb[0] = -1;
                                    int[] iArr18 = this.bl;
                                    iArr18[0] = i34;
                                    int[] iArr19 = this.bd;
                                    iArr19[0] = i4;
                                    iInflate_trees_dynamic = this.inftree.inflate_trees_dynamic(i9 + 257, i10 + 1, this.blens, iArr18, iArr19, this.tli, this.tdi, this.hufts, this.z);
                                    if (iInflate_trees_dynamic != 0) {
                                        if (iInflate_trees_dynamic == -3) {
                                            this.blens = null;
                                            this.mode = 9;
                                        }
                                        this.bitb = i30;
                                        this.bitk = i29;
                                        ZStream zStream110 = this.z;
                                        zStream110.avail_in = i32;
                                        zStream110.total_in += (long) (i31 - zStream110.next_in_index);
                                        zStream110.next_in_index = i31;
                                        this.write = i28;
                                        return inflate_flush(iInflate_trees_dynamic);
                                    }
                                    InfCodes infCodes2 = this.codes;
                                    int i512 = this.bl[0];
                                    int i513 = this.bd[0];
                                    int[] iArr20 = this.hufts;
                                    infCodes2.init(i512, i513, iArr20, this.tli[0], iArr20, this.tdi[0]);
                                    this.mode = i4;
                                    this.bitb = i30;
                                    this.bitk = i29;
                                    ZStream zStream111 = this.z;
                                    zStream111.avail_in = i32;
                                    zStream111.total_in += (long) (i31 - zStream111.next_in_index);
                                    zStream111.next_in_index = i31;
                                    this.write = i28;
                                    iProc = this.codes.proc(i33);
                                    if (iProc != 1) {
                                        return inflate_flush(iProc);
                                    }
                                    this.codes.free(this.z);
                                    ZStream zStream112 = this.z;
                                    i31 = zStream112.next_in_index;
                                    i32 = zStream112.avail_in;
                                    i30 = this.bitb;
                                    i29 = this.bitk;
                                    i28 = this.write;
                                    i8 = this.read;
                                    if (i28 < i8) {
                                        i2 = (i8 - i28) - 1;
                                    } else {
                                        i2 = this.end - i28;
                                    }
                                    if (this.last == 0) {
                                        this.mode = 0;
                                        i27 = i2;
                                        i33 = 0;
                                    } else {
                                        this.mode = i35;
                                        i33 = 0;
                                    }
                                } else {
                                    i11 = i35;
                                    int i514 = i4;
                                    i12 = this.bb[0];
                                    while (i29 < i12) {
                                        if (i32 == 0) {
                                            this.bitb = i30;
                                            this.bitk = i29;
                                            ZStream zStream113 = this.z;
                                            zStream113.avail_in = i32;
                                            zStream113.total_in += (long) (i31 - zStream113.next_in_index);
                                            zStream113.next_in_index = i31;
                                            this.write = i28;
                                            return inflate_flush(i33);
                                        }
                                        i32--;
                                        i30 |= (this.z.next_in[i31] & GZIPHeader.OS_UNKNOWN) << i29;
                                        i29 += 8;
                                        i31++;
                                        i33 = 0;
                                    }
                                    int i515 = this.tb[0];
                                    int[] iArr21 = this.hufts;
                                    int[] iArr22 = inflate_mask;
                                    i13 = iArr21[(((iArr22[i12] & i30) + i515) * 3) + 1];
                                    i14 = iArr21[((i515 + (iArr22[i13] & i30)) * 3) + 2];
                                    if (i14 < 16) {
                                        if (i14 == 18) {
                                            i15 = i11;
                                        } else {
                                            i15 = i14 - 14;
                                        }
                                        if (i14 == 18) {
                                            i16 = 11;
                                        } else {
                                            i16 = 3;
                                        }
                                        while (i29 < i13 + i15) {
                                            if (i32 == 0) {
                                                this.bitb = i30;
                                                this.bitk = i29;
                                                ZStream zStream114 = this.z;
                                                zStream114.avail_in = i32;
                                                zStream114.total_in += (long) (i31 - zStream114.next_in_index);
                                                zStream114.next_in_index = i31;
                                                this.write = i28;
                                                return inflate_flush(i33);
                                            }
                                            i32--;
                                            i30 |= (this.z.next_in[i31] & GZIPHeader.OS_UNKNOWN) << i29;
                                            i29 += 8;
                                            i31++;
                                            i33 = 0;
                                        }
                                        int i64 = i30 >>> i13;
                                        i17 = i16 + (inflate_mask[i15] & i64);
                                        i30 = i64 >>> i15;
                                        i29 = (i29 - i13) - i15;
                                        i18 = this.index;
                                        i19 = this.table;
                                        i20 = 5;
                                        if (i18 + i17 <= (i19 & 31) + 258 + ((i19 >> 5) & 31)) {
                                        }
                                        this.blens = null;
                                        this.mode = 9;
                                        ZStream zStream115 = this.z;
                                        zStream115.msg = "invalid bit length repeat";
                                        this.bitb = i30;
                                        this.bitk = i29;
                                        zStream115.avail_in = i32;
                                        zStream115.total_in += (long) (i31 - zStream115.next_in_index);
                                        zStream115.next_in_index = i31;
                                        this.write = i28;
                                        return inflate_flush(-3);
                                    }
                                    i30 >>>= i13;
                                    i29 -= i13;
                                    int[] iArr110 = this.blens;
                                    int i65 = this.index;
                                    this.index = i65 + 1;
                                    iArr110[i65] = i14;
                                    i20 = 5;
                                    i4 = i514;
                                    i35 = i11;
                                    i7 = i20;
                                    i34 = 9;
                                }
                            }
                        }
                        break;
                    }
                    break;
                case 5:
                    i7 = 5;
                    i4 = 6;
                    while (true) {
                        int i516 = this.table;
                        i9 = i516 & 31;
                        i10 = (i516 >> i7) & 31;
                        if (this.index >= i9 + 258 + i10) {
                            this.tb[0] = -1;
                            int[] iArr111 = this.bl;
                            iArr111[0] = i34;
                            int[] iArr112 = this.bd;
                            iArr112[0] = i4;
                            iInflate_trees_dynamic = this.inftree.inflate_trees_dynamic(i9 + 257, i10 + 1, this.blens, iArr111, iArr112, this.tli, this.tdi, this.hufts, this.z);
                            if (iInflate_trees_dynamic != 0) {
                                if (iInflate_trees_dynamic == -3) {
                                    this.blens = null;
                                    this.mode = 9;
                                }
                                this.bitb = i30;
                                this.bitk = i29;
                                ZStream zStream116 = this.z;
                                zStream116.avail_in = i32;
                                zStream116.total_in += (long) (i31 - zStream116.next_in_index);
                                zStream116.next_in_index = i31;
                                this.write = i28;
                                return inflate_flush(iInflate_trees_dynamic);
                            }
                            InfCodes infCodes3 = this.codes;
                            int i517 = this.bl[0];
                            int i518 = this.bd[0];
                            int[] iArr23 = this.hufts;
                            infCodes3.init(i517, i518, iArr23, this.tli[0], iArr23, this.tdi[0]);
                            this.mode = i4;
                            this.bitb = i30;
                            this.bitk = i29;
                            ZStream zStream117 = this.z;
                            zStream117.avail_in = i32;
                            zStream117.total_in += (long) (i31 - zStream117.next_in_index);
                            zStream117.next_in_index = i31;
                            this.write = i28;
                            iProc = this.codes.proc(i33);
                            if (iProc != 1) {
                                return inflate_flush(iProc);
                            }
                            this.codes.free(this.z);
                            ZStream zStream118 = this.z;
                            i31 = zStream118.next_in_index;
                            i32 = zStream118.avail_in;
                            i30 = this.bitb;
                            i29 = this.bitk;
                            i28 = this.write;
                            i8 = this.read;
                            if (i28 < i8) {
                                i2 = (i8 - i28) - 1;
                            } else {
                                i2 = this.end - i28;
                            }
                            if (this.last == 0) {
                                this.mode = 0;
                                i27 = i2;
                                i33 = 0;
                            } else {
                                this.mode = i35;
                                i33 = 0;
                            }
                        } else {
                            i11 = i35;
                            int i519 = i4;
                            i12 = this.bb[0];
                            while (i29 < i12) {
                                if (i32 == 0) {
                                    this.bitb = i30;
                                    this.bitk = i29;
                                    ZStream zStream119 = this.z;
                                    zStream119.avail_in = i32;
                                    zStream119.total_in += (long) (i31 - zStream119.next_in_index);
                                    zStream119.next_in_index = i31;
                                    this.write = i28;
                                    return inflate_flush(i33);
                                }
                                i32--;
                                i30 |= (this.z.next_in[i31] & GZIPHeader.OS_UNKNOWN) << i29;
                                i29 += 8;
                                i31++;
                                i33 = 0;
                            }
                            int i5110 = this.tb[0];
                            int[] iArr24 = this.hufts;
                            int[] iArr25 = inflate_mask;
                            i13 = iArr24[(((iArr25[i12] & i30) + i5110) * 3) + 1];
                            i14 = iArr24[((i5110 + (iArr25[i13] & i30)) * 3) + 2];
                            if (i14 < 16) {
                                if (i14 == 18) {
                                    i15 = i11;
                                } else {
                                    i15 = i14 - 14;
                                }
                                if (i14 == 18) {
                                    i16 = 11;
                                } else {
                                    i16 = 3;
                                }
                                while (i29 < i13 + i15) {
                                    if (i32 == 0) {
                                        this.bitb = i30;
                                        this.bitk = i29;
                                        ZStream zStream1110 = this.z;
                                        zStream1110.avail_in = i32;
                                        zStream1110.total_in += (long) (i31 - zStream1110.next_in_index);
                                        zStream1110.next_in_index = i31;
                                        this.write = i28;
                                        return inflate_flush(i33);
                                    }
                                    i32--;
                                    i30 |= (this.z.next_in[i31] & GZIPHeader.OS_UNKNOWN) << i29;
                                    i29 += 8;
                                    i31++;
                                    i33 = 0;
                                }
                                int i66 = i30 >>> i13;
                                i17 = i16 + (inflate_mask[i15] & i66);
                                i30 = i66 >>> i15;
                                i29 = (i29 - i13) - i15;
                                i18 = this.index;
                                i19 = this.table;
                                i20 = 5;
                                if (i18 + i17 <= (i19 & 31) + 258 + ((i19 >> 5) & 31)) {
                                }
                                this.blens = null;
                                this.mode = 9;
                                ZStream zStream1111 = this.z;
                                zStream1111.msg = "invalid bit length repeat";
                                this.bitb = i30;
                                this.bitk = i29;
                                zStream1111.avail_in = i32;
                                zStream1111.total_in += (long) (i31 - zStream1111.next_in_index);
                                zStream1111.next_in_index = i31;
                                this.write = i28;
                                return inflate_flush(-3);
                            }
                            i30 >>>= i13;
                            i29 -= i13;
                            int[] iArr113 = this.blens;
                            int i67 = this.index;
                            this.index = i67 + 1;
                            iArr113[i67] = i14;
                            i20 = 5;
                            i4 = i519;
                            i35 = i11;
                            i7 = i20;
                            i34 = 9;
                        }
                        break;
                    }
                    break;
                case 6:
                    this.bitb = i30;
                    this.bitk = i29;
                    ZStream zStream1112 = this.z;
                    zStream1112.avail_in = i32;
                    zStream1112.total_in += (long) (i31 - zStream1112.next_in_index);
                    zStream1112.next_in_index = i31;
                    this.write = i28;
                    iProc = this.codes.proc(i33);
                    if (iProc != 1) {
                        return inflate_flush(iProc);
                    }
                    this.codes.free(this.z);
                    ZStream zStream1113 = this.z;
                    i31 = zStream1113.next_in_index;
                    i32 = zStream1113.avail_in;
                    i30 = this.bitb;
                    i29 = this.bitk;
                    i28 = this.write;
                    i8 = this.read;
                    if (i28 < i8) {
                        i2 = (i8 - i28) - 1;
                    } else {
                        i2 = this.end - i28;
                    }
                    if (this.last == 0) {
                        this.mode = 0;
                        i27 = i2;
                        i33 = 0;
                    } else {
                        this.mode = i35;
                        i33 = 0;
                    }
                    break;
                    break;
                case 7:
                    break;
                case 8:
                    this.bitb = i30;
                    this.bitk = i29;
                    ZStream zStream20 = this.z;
                    zStream20.avail_in = i32;
                    zStream20.total_in += (long) (i31 - zStream20.next_in_index);
                    zStream20.next_in_index = i31;
                    this.write = i28;
                    return inflate_flush(1);
                case 9:
                    this.bitb = i30;
                    this.bitk = i29;
                    ZStream zStream21 = this.z;
                    zStream21.avail_in = i32;
                    zStream21.total_in += (long) (i31 - zStream21.next_in_index);
                    zStream21.next_in_index = i31;
                    this.write = i28;
                    return inflate_flush(-3);
                default:
                    this.bitb = i30;
                    this.bitk = i29;
                    ZStream zStream22 = this.z;
                    zStream22.avail_in = i32;
                    zStream22.total_in += (long) (i31 - zStream22.next_in_index);
                    zStream22.next_in_index = i31;
                    this.write = i28;
                    return inflate_flush(-2);
            }
        }
        this.write = i28;
        int iInflate_flush2 = inflate_flush(i33);
        i28 = this.write;
        if (this.read != i28) {
            this.bitb = i30;
            this.bitk = i29;
            ZStream zStream23 = this.z;
            zStream23.avail_in = i32;
            zStream23.total_in += (long) (i31 - zStream23.next_in_index);
            zStream23.next_in_index = i31;
            this.write = i28;
            return inflate_flush(iInflate_flush2);
        }
        this.mode = 8;
        this.bitb = i30;
        this.bitk = i29;
        ZStream zStream24 = this.z;
        zStream24.avail_in = i32;
        zStream24.total_in += (long) (i31 - zStream24.next_in_index);
        zStream24.next_in_index = i31;
        this.write = i28;
        return inflate_flush(1);
    }

    public void reset() {
        if (this.mode == 6) {
            this.codes.free(this.z);
        }
        this.mode = 0;
        this.bitk = 0;
        this.bitb = 0;
        this.write = 0;
        this.read = 0;
        if (this.check) {
            this.z.adler.reset();
        }
    }

    public void set_dictionary(byte[] bArr, int i, int i2) {
        System.arraycopy(bArr, i, this.window, 0, i2);
        this.write = i2;
        this.read = i2;
    }

    public int sync_point() {
        return this.mode == 1 ? 1 : 0;
    }
}
