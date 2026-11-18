package com.jcraft.jzlib;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class InfCodes {
    private static final int BADCODE = 9;
    private static final int COPY = 5;
    private static final int DIST = 3;
    private static final int DISTEXT = 4;
    private static final int END = 8;
    private static final int LEN = 1;
    private static final int LENEXT = 2;
    private static final int LIT = 6;
    private static final int START = 0;
    private static final int WASH = 7;
    private static final int Z_BUF_ERROR = -5;
    private static final int Z_DATA_ERROR = -3;
    private static final int Z_ERRNO = -1;
    private static final int Z_MEM_ERROR = -4;
    private static final int Z_NEED_DICT = 2;
    private static final int Z_OK = 0;
    private static final int Z_STREAM_END = 1;
    private static final int Z_STREAM_ERROR = -2;
    private static final int Z_VERSION_ERROR = -6;
    private static final int[] inflate_mask = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte dbits;
    int dist;
    int[] dtree;
    int dtree_index;
    int get;
    byte lbits;
    int len;
    int lit;
    int[] ltree;
    int ltree_index;
    int mode;
    int need;
    private final InfBlocks s;
    int[] tree;
    int tree_index = 0;
    private final ZStream z;

    public InfCodes(ZStream zStream, InfBlocks infBlocks) {
        this.z = zStream;
        this.s = infBlocks;
    }

    public void free(ZStream zStream) {
    }

    /* JADX WARN: Code duplicated, block: B:61:0x015b A[EDGE_INSN: B:61:0x015b->B:87:0x01e6 BREAK  A[LOOP:0: B:7:0x001f->B:95:0x001f, LOOP_LABEL: LOOP:0: B:7:0x001f->B:95:0x001f], PHI: r2 r3 r4 r5 r8
      0x015b: PHI (r2v34 int) = (r2v7 int), (r2v1 int) binds: [B:60:0x0159, B:85:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x015b: PHI (r3v21 int) = (r3v4 int), (r3v1 int) binds: [B:60:0x0159, B:85:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x015b: PHI (r4v22 int) = (r4v9 int), (r4v5 int) binds: [B:60:0x0159, B:85:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x015b: PHI (r5v18 int) = (r5v9 int), (r5v5 int) binds: [B:60:0x0159, B:85:0x01e2] A[DONT_GENERATE, DONT_INLINE]
      0x015b: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:60:0x0159, B:85:0x01e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:74:0x0198  */
    public int inflate_fast(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4, InfBlocks infBlocks, ZStream zStream) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13 = zStream.next_in_index;
        int i14 = zStream.avail_in;
        int i15 = infBlocks.bitb;
        int i16 = infBlocks.bitk;
        int i17 = infBlocks.write;
        int i18 = infBlocks.read;
        int i19 = i17 < i18 ? (i18 - i17) - 1 : infBlocks.end - i17;
        int[] iArr3 = inflate_mask;
        int i20 = iArr3[i];
        int i21 = iArr3[i2];
        loop0: while (true) {
            if (i16 >= 20) {
                int i22 = i15 & i20;
                int i23 = (i3 + i22) * 3;
                int i24 = iArr[i23];
                if (i24 != 0) {
                    while (true) {
                        int i25 = iArr[i23 + 1];
                        i15 >>= i25;
                        i16 -= i25;
                        if ((i24 & 16) == 0) {
                            if ((i24 & 64) != 0) {
                                if ((i24 & 32) == 0) {
                                    zStream.msg = "invalid literal/length code";
                                    i8 = zStream.avail_in - i14;
                                    i9 = i16 >> 3;
                                    if (i9 >= i8) {
                                        break loop0;
                                    }
                                    i8 = i9;
                                    break loop0;
                                }
                                int i26 = zStream.avail_in - i14;
                                int i27 = i16 >> 3;
                                if (i27 < i26) {
                                    i26 = i27;
                                }
                                int i28 = i13 - i26;
                                infBlocks.bitb = i15;
                                infBlocks.bitk = i16 - (i26 << 3);
                                zStream.avail_in = i14 + i26;
                                zStream.total_in += (long) (i28 - zStream.next_in_index);
                                zStream.next_in_index = i28;
                                infBlocks.write = i17;
                                return 1;
                            }
                            i22 = i22 + iArr[i23 + 2] + (inflate_mask[i24] & i15);
                            i23 = (i3 + i22) * 3;
                            i24 = iArr[i23];
                            if (i24 == 0) {
                                int i29 = iArr[i23 + 1];
                                i15 >>= i29;
                                i16 -= i29;
                                i10 = i17 + 1;
                                infBlocks.window[i17] = (byte) iArr[i23 + 2];
                            }
                        } else {
                            int i30 = i24 & 15;
                            int i31 = iArr[i23 + 2] + (inflate_mask[i30] & i15);
                            i15 >>= i30;
                            i16 -= i30;
                            while (i16 < 15) {
                                i14--;
                                i15 |= (zStream.next_in[i13] & GZIPHeader.OS_UNKNOWN) << i16;
                                i16 += 8;
                                i13++;
                            }
                            int i32 = i15 & i21;
                            int i33 = (i4 + i32) * 3;
                            int i34 = iArr2[i33];
                            while (true) {
                                int i35 = iArr2[i33 + 1];
                                i15 >>= i35;
                                i16 -= i35;
                                if ((i34 & 16) == 0) {
                                    if ((i34 & 64) != 0) {
                                        zStream.msg = "invalid distance code";
                                        i8 = zStream.avail_in - i14;
                                        i9 = i16 >> 3;
                                        if (i9 >= i8) {
                                            break loop0;
                                        }
                                        i8 = i9;
                                        break loop0;
                                    }
                                    i32 = i32 + iArr2[i33 + 2] + (inflate_mask[i34] & i15);
                                    i33 = (i4 + i32) * 3;
                                    i34 = iArr2[i33];
                                } else {
                                    int i36 = i34 & 15;
                                    int i37 = i13;
                                    int i38 = i14;
                                    while (i16 < i36) {
                                        i38--;
                                        i15 |= (zStream.next_in[i37] & GZIPHeader.OS_UNKNOWN) << i16;
                                        i16 += 8;
                                        i37++;
                                    }
                                    int i39 = iArr2[i33 + 2] + (inflate_mask[i36] & i15);
                                    int i40 = i15 >> i36;
                                    int i41 = i16 - i36;
                                    int i42 = i19 - i31;
                                    if (i17 >= i39) {
                                        int i43 = i17 - i39;
                                        int i44 = i17 - i43;
                                        if (i44 <= 0 || 2 <= i44) {
                                            byte[] bArr = infBlocks.window;
                                            System.arraycopy(bArr, i43, bArr, i17, 2);
                                            i17 += 2;
                                            i5 = i43 + 2;
                                        } else {
                                            byte[] bArr2 = infBlocks.window;
                                            int i45 = i17 + 1;
                                            int i46 = i43 + 1;
                                            bArr2[i17] = bArr2[i43];
                                            i17 += 2;
                                            i5 = i43 + 2;
                                            bArr2[i45] = bArr2[i46];
                                        }
                                        i31 -= 2;
                                    } else {
                                        i5 = i17 - i39;
                                        do {
                                            i6 = infBlocks.end;
                                            i5 += i6;
                                        } while (i5 < 0);
                                        int i47 = i6 - i5;
                                        if (i31 > i47) {
                                            i31 -= i47;
                                            int i48 = i17 - i5;
                                            if (i48 <= 0 || i47 <= i48) {
                                                byte[] bArr3 = infBlocks.window;
                                                System.arraycopy(bArr3, i5, bArr3, i17, i47);
                                                i17 += i47;
                                            } else {
                                                while (true) {
                                                    byte[] bArr4 = infBlocks.window;
                                                    int i49 = i5 + 1;
                                                    bArr4[i17] = bArr4[i5];
                                                    i47--;
                                                    i17++;
                                                    if (i47 == 0) {
                                                        break;
                                                    }
                                                    i5 = i49;
                                                }
                                            }
                                            i5 = 0;
                                        }
                                    }
                                    int i50 = i17 - i5;
                                    if (i50 <= 0 || i31 <= i50) {
                                        byte[] bArr5 = infBlocks.window;
                                        System.arraycopy(bArr5, i5, bArr5, i17, i31);
                                        i7 = i17 + i31;
                                    } else {
                                        while (true) {
                                            byte[] bArr6 = infBlocks.window;
                                            i7 = i17 + 1;
                                            int i51 = i5 + 1;
                                            bArr6[i17] = bArr6[i5];
                                            i31--;
                                            if (i31 == 0) {
                                                break;
                                            }
                                            i17 = i7;
                                            i5 = i51;
                                        }
                                    }
                                    i17 = i7;
                                    i14 = i38;
                                    i13 = i37;
                                    i15 = i40;
                                    i16 = i41;
                                    i19 = i42;
                                    if (i19 >= 258 || i14 < 10) {
                                        i11 = zStream.avail_in - i14;
                                        i12 = i16 >> 3;
                                        if (i12 < i11) {
                                            i11 = i12;
                                        }
                                        int i52 = i13 - i11;
                                        infBlocks.bitb = i15;
                                        infBlocks.bitk = i16 - (i11 << 3);
                                        zStream.avail_in = i14 + i11;
                                        zStream.total_in += (long) (i52 - zStream.next_in_index);
                                        zStream.next_in_index = i52;
                                        infBlocks.write = i17;
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    int i53 = iArr[i23 + 1];
                    i15 >>= i53;
                    i16 -= i53;
                    i10 = i17 + 1;
                    infBlocks.window[i17] = (byte) iArr[i23 + 2];
                }
                i19--;
                i17 = i10;
                if (i19 >= 258) {
                }
                i11 = zStream.avail_in - i14;
                i12 = i16 >> 3;
                if (i12 < i11) {
                    i11 = i12;
                }
                int i54 = i13 - i11;
                infBlocks.bitb = i15;
                infBlocks.bitk = i16 - (i11 << 3);
                zStream.avail_in = i14 + i11;
                zStream.total_in += (long) (i54 - zStream.next_in_index);
                zStream.next_in_index = i54;
                infBlocks.write = i17;
                return 0;
            }
            i14--;
            i15 |= (zStream.next_in[i13] & GZIPHeader.OS_UNKNOWN) << i16;
            i16 += 8;
            i13++;
        }
        int i55 = i13 - i8;
        infBlocks.bitb = i15;
        infBlocks.bitk = i16 - (i8 << 3);
        zStream.avail_in = i14 + i8;
        zStream.total_in += (long) (i55 - zStream.next_in_index);
        zStream.next_in_index = i55;
        infBlocks.write = i17;
        return -3;
    }

    public void init(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        this.mode = 0;
        this.lbits = (byte) i;
        this.dbits = (byte) i2;
        this.ltree = iArr;
        this.ltree_index = i3;
        this.dtree = iArr2;
        this.dtree_index = i4;
        this.tree = null;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x029d  */
    /* JADX WARN: Code duplicated, block: B:126:0x033c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x033e A[LOOP:6: B:125:0x033a->B:127:0x033e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:133:0x038b  */
    /* JADX WARN: Code duplicated, block: B:143:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:158:0x01b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x039e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x0299 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x0351 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x038f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x03af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x028c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x02a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x03a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x03b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x016f A[LOOP:2: B:55:0x016d->B:56:0x016f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:59:0x0179  */
    /* JADX WARN: Code duplicated, block: B:60:0x017b  */
    /* JADX WARN: Code duplicated, block: B:65:0x0187  */
    /* JADX WARN: Code duplicated, block: B:66:0x018b  */
    /* JADX WARN: Code duplicated, block: B:69:0x018f  */
    /* JADX WARN: Code duplicated, block: B:71:0x019d  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:82:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:86:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:98:0x0243 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x0245 A[LOOP:5: B:97:0x0241->B:99:0x0245, LOOP_END] */
    public int proc(int i) {
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr2;
        int i11;
        int i12;
        InfBlocks infBlocks;
        int i13;
        InfBlocks infBlocks2;
        int i14;
        InfBlocks infBlocks3;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        ZStream zStream = this.z;
        int i20 = zStream.next_in_index;
        int i21 = zStream.avail_in;
        InfBlocks infBlocks4 = this.s;
        int i22 = infBlocks4.bitb;
        int i23 = infBlocks4.bitk;
        int i24 = infBlocks4.write;
        int i25 = infBlocks4.read;
        int i26 = i24 < i25 ? (i25 - i24) - 1 : infBlocks4.end - i24;
        int i27 = i20;
        int i28 = i21;
        int iInflate_fast = i;
        while (true) {
            switch (this.mode) {
                case 0:
                    if (i26 >= 258 && i28 >= 10) {
                        InfBlocks infBlocks5 = this.s;
                        infBlocks5.bitb = i22;
                        infBlocks5.bitk = i23;
                        ZStream zStream2 = this.z;
                        zStream2.avail_in = i28;
                        zStream2.total_in += (long) (i27 - zStream2.next_in_index);
                        zStream2.next_in_index = i27;
                        infBlocks5.write = i24;
                        iInflate_fast = inflate_fast(this.lbits, this.dbits, this.ltree, this.ltree_index, this.dtree, this.dtree_index, infBlocks5, zStream2);
                        ZStream zStream3 = this.z;
                        i27 = zStream3.next_in_index;
                        i28 = zStream3.avail_in;
                        InfBlocks infBlocks6 = this.s;
                        int i29 = infBlocks6.bitb;
                        int i30 = infBlocks6.bitk;
                        int i31 = infBlocks6.write;
                        int i32 = infBlocks6.read;
                        int i33 = i31 < i32 ? (i32 - i31) - 1 : infBlocks6.end - i31;
                        if (iInflate_fast != 0) {
                            this.mode = iInflate_fast == 1 ? 7 : 9;
                            i26 = i33;
                            i22 = i29;
                            i23 = i30;
                            i24 = i31;
                        } else {
                            i26 = i33;
                            i22 = i29;
                            i23 = i30;
                            i24 = i31;
                        }
                        break;
                    }
                    this.need = this.lbits;
                    this.tree = this.ltree;
                    this.tree_index = this.ltree_index;
                    this.mode = 1;
                    i3 = this.need;
                    while (i23 < i3) {
                        if (i28 != 0) {
                            InfBlocks infBlocks7 = this.s;
                            infBlocks7.bitb = i22;
                            infBlocks7.bitk = i23;
                            ZStream zStream4 = this.z;
                            zStream4.avail_in = i28;
                            zStream4.total_in += (long) (i27 - zStream4.next_in_index);
                            zStream4.next_in_index = i27;
                            infBlocks7.write = i24;
                            return infBlocks7.inflate_flush(iInflate_fast);
                        }
                        i28--;
                        i22 |= (this.z.next_in[i27] & GZIPHeader.OS_UNKNOWN) << i23;
                        i23 += 8;
                        iInflate_fast = 0;
                        i27++;
                    }
                    i4 = (this.tree_index + (inflate_mask[i3] & i22)) * 3;
                    iArr = this.tree;
                    int i34 = iArr[i4 + 1];
                    i22 >>>= i34;
                    i23 -= i34;
                    i5 = iArr[i4];
                    if (i5 == 0) {
                        this.lit = iArr[i4 + 2];
                        i6 = 6;
                    } else if ((i5 & 16) != 0) {
                        this.get = i5 & 15;
                        this.len = iArr[i4 + 2];
                        i6 = 2;
                    } else if ((i5 & 64) == 0) {
                        this.need = i5;
                        i7 = i4 / 3;
                        i8 = iArr[i4 + 2];
                        this.tree_index = i7 + i8;
                    } else {
                        if ((i5 & 32) != 0) {
                            this.mode = 9;
                            ZStream zStream5 = this.z;
                            zStream5.msg = "invalid literal/length code";
                            InfBlocks infBlocks8 = this.s;
                            infBlocks8.bitb = i22;
                            infBlocks8.bitk = i23;
                            zStream5.avail_in = i28;
                            zStream5.total_in += (long) (i27 - zStream5.next_in_index);
                            zStream5.next_in_index = i27;
                            infBlocks8.write = i24;
                            return infBlocks8.inflate_flush(-3);
                        }
                        this.mode = 7;
                    }
                    this.mode = i6;
                    break;
                case 1:
                    i3 = this.need;
                    while (i23 < i3) {
                        if (i28 != 0) {
                            InfBlocks infBlocks9 = this.s;
                            infBlocks9.bitb = i22;
                            infBlocks9.bitk = i23;
                            ZStream zStream6 = this.z;
                            zStream6.avail_in = i28;
                            zStream6.total_in += (long) (i27 - zStream6.next_in_index);
                            zStream6.next_in_index = i27;
                            infBlocks9.write = i24;
                            return infBlocks9.inflate_flush(iInflate_fast);
                        }
                        i28--;
                        i22 |= (this.z.next_in[i27] & GZIPHeader.OS_UNKNOWN) << i23;
                        i23 += 8;
                        iInflate_fast = 0;
                        i27++;
                    }
                    i4 = (this.tree_index + (inflate_mask[i3] & i22)) * 3;
                    iArr = this.tree;
                    int i35 = iArr[i4 + 1];
                    i22 >>>= i35;
                    i23 -= i35;
                    i5 = iArr[i4];
                    if (i5 == 0) {
                        this.lit = iArr[i4 + 2];
                        i6 = 6;
                    } else if ((i5 & 16) != 0) {
                        this.get = i5 & 15;
                        this.len = iArr[i4 + 2];
                        i6 = 2;
                    } else if ((i5 & 64) == 0) {
                        this.need = i5;
                        i7 = i4 / 3;
                        i8 = iArr[i4 + 2];
                        this.tree_index = i7 + i8;
                    } else {
                        if ((i5 & 32) != 0) {
                            this.mode = 9;
                            ZStream zStream7 = this.z;
                            zStream7.msg = "invalid literal/length code";
                            InfBlocks infBlocks10 = this.s;
                            infBlocks10.bitb = i22;
                            infBlocks10.bitk = i23;
                            zStream7.avail_in = i28;
                            zStream7.total_in += (long) (i27 - zStream7.next_in_index);
                            zStream7.next_in_index = i27;
                            infBlocks10.write = i24;
                            return infBlocks10.inflate_flush(-3);
                        }
                        this.mode = 7;
                    }
                    this.mode = i6;
                    break;
                case 2:
                    int i36 = this.get;
                    while (i23 < i36) {
                        if (i28 == 0) {
                            InfBlocks infBlocks11 = this.s;
                            infBlocks11.bitb = i22;
                            infBlocks11.bitk = i23;
                            ZStream zStream8 = this.z;
                            zStream8.avail_in = i28;
                            zStream8.total_in += (long) (i27 - zStream8.next_in_index);
                            zStream8.next_in_index = i27;
                            infBlocks11.write = i24;
                            return infBlocks11.inflate_flush(iInflate_fast);
                        }
                        i28--;
                        i22 |= (this.z.next_in[i27] & GZIPHeader.OS_UNKNOWN) << i23;
                        i23 += 8;
                        i27++;
                        iInflate_fast = 0;
                    }
                    this.len += inflate_mask[i36] & i22;
                    i22 >>= i36;
                    i23 -= i36;
                    this.need = this.dbits;
                    this.tree = this.dtree;
                    this.tree_index = this.dtree_index;
                    this.mode = 3;
                    i9 = this.need;
                    while (i23 < i9) {
                        if (i28 != 0) {
                            InfBlocks infBlocks12 = this.s;
                            infBlocks12.bitb = i22;
                            infBlocks12.bitk = i23;
                            ZStream zStream9 = this.z;
                            zStream9.avail_in = i28;
                            zStream9.total_in += (long) (i27 - zStream9.next_in_index);
                            zStream9.next_in_index = i27;
                            infBlocks12.write = i24;
                            return infBlocks12.inflate_flush(iInflate_fast);
                        }
                        i28--;
                        i22 |= (this.z.next_in[i27] & GZIPHeader.OS_UNKNOWN) << i23;
                        i23 += 8;
                        i27++;
                        iInflate_fast = 0;
                    }
                    i10 = (this.tree_index + (inflate_mask[i9] & i22)) * 3;
                    iArr2 = this.tree;
                    int i37 = iArr2[i10 + 1];
                    i22 >>= i37;
                    i23 -= i37;
                    i11 = iArr2[i10];
                    if ((i11 & 16) != 0) {
                        this.get = i11 & 15;
                        this.dist = iArr2[i10 + 2];
                        i6 = 4;
                        this.mode = i6;
                    } else {
                        if ((i11 & 64) == 0) {
                            this.mode = 9;
                            ZStream zStream10 = this.z;
                            zStream10.msg = "invalid distance code";
                            InfBlocks infBlocks13 = this.s;
                            infBlocks13.bitb = i22;
                            infBlocks13.bitk = i23;
                            zStream10.avail_in = i28;
                            zStream10.total_in += (long) (i27 - zStream10.next_in_index);
                            zStream10.next_in_index = i27;
                            infBlocks13.write = i24;
                            return infBlocks13.inflate_flush(-3);
                        }
                        this.need = i11;
                        i7 = i10 / 3;
                        i8 = iArr2[i10 + 2];
                        this.tree_index = i7 + i8;
                    }
                    break;
                case 3:
                    i9 = this.need;
                    while (i23 < i9) {
                        if (i28 != 0) {
                            InfBlocks infBlocks14 = this.s;
                            infBlocks14.bitb = i22;
                            infBlocks14.bitk = i23;
                            ZStream zStream11 = this.z;
                            zStream11.avail_in = i28;
                            zStream11.total_in += (long) (i27 - zStream11.next_in_index);
                            zStream11.next_in_index = i27;
                            infBlocks14.write = i24;
                            return infBlocks14.inflate_flush(iInflate_fast);
                        }
                        i28--;
                        i22 |= (this.z.next_in[i27] & GZIPHeader.OS_UNKNOWN) << i23;
                        i23 += 8;
                        i27++;
                        iInflate_fast = 0;
                    }
                    i10 = (this.tree_index + (inflate_mask[i9] & i22)) * 3;
                    iArr2 = this.tree;
                    int i38 = iArr2[i10 + 1];
                    i22 >>= i38;
                    i23 -= i38;
                    i11 = iArr2[i10];
                    if ((i11 & 16) != 0) {
                        this.get = i11 & 15;
                        this.dist = iArr2[i10 + 2];
                        i6 = 4;
                        this.mode = i6;
                    } else {
                        if ((i11 & 64) == 0) {
                            this.mode = 9;
                            ZStream zStream12 = this.z;
                            zStream12.msg = "invalid distance code";
                            InfBlocks infBlocks15 = this.s;
                            infBlocks15.bitb = i22;
                            infBlocks15.bitk = i23;
                            zStream12.avail_in = i28;
                            zStream12.total_in += (long) (i27 - zStream12.next_in_index);
                            zStream12.next_in_index = i27;
                            infBlocks15.write = i24;
                            return infBlocks15.inflate_flush(-3);
                        }
                        this.need = i11;
                        i7 = i10 / 3;
                        i8 = iArr2[i10 + 2];
                        this.tree_index = i7 + i8;
                    }
                    break;
                case 4:
                    int i39 = this.get;
                    while (i23 < i39) {
                        if (i28 == 0) {
                            InfBlocks infBlocks16 = this.s;
                            infBlocks16.bitb = i22;
                            infBlocks16.bitk = i23;
                            ZStream zStream13 = this.z;
                            zStream13.avail_in = i28;
                            zStream13.total_in += (long) (i27 - zStream13.next_in_index);
                            zStream13.next_in_index = i27;
                            infBlocks16.write = i24;
                            return infBlocks16.inflate_flush(iInflate_fast);
                        }
                        i28--;
                        i22 |= (this.z.next_in[i27] & GZIPHeader.OS_UNKNOWN) << i23;
                        i23 += 8;
                        i27++;
                        iInflate_fast = 0;
                    }
                    this.dist += inflate_mask[i39] & i22;
                    i22 >>= i39;
                    i23 -= i39;
                    this.mode = 5;
                    i12 = i24 - this.dist;
                    while (i12 < 0) {
                        i12 += this.s.end;
                    }
                    while (this.len != 0) {
                        if (i26 == 0) {
                            infBlocks2 = this.s;
                            i14 = infBlocks2.end;
                            if (i24 == i14 && (i19 = infBlocks2.read) != 0) {
                                if (i19 > 0) {
                                    i26 = i19 - 1;
                                } else {
                                    i26 = i14;
                                }
                                i24 = 0;
                            }
                            if (i26 == 0) {
                                infBlocks2.write = i24;
                                iInflate_fast = infBlocks2.inflate_flush(iInflate_fast);
                                infBlocks3 = this.s;
                                i15 = infBlocks3.write;
                                i16 = infBlocks3.read;
                                if (i15 < i16) {
                                    i17 = (i16 - i15) - 1;
                                } else {
                                    i17 = infBlocks3.end - i15;
                                }
                                i18 = infBlocks3.end;
                                if (i15 == i18 && i16 != 0) {
                                    if (i16 > 0) {
                                        i18 = i16 - 1;
                                    }
                                    i17 = i18;
                                    i15 = 0;
                                }
                                if (i17 == 0) {
                                    infBlocks3.bitb = i22;
                                    infBlocks3.bitk = i23;
                                    ZStream zStream14 = this.z;
                                    zStream14.avail_in = i28;
                                    zStream14.total_in += (long) (i27 - zStream14.next_in_index);
                                    zStream14.next_in_index = i27;
                                    infBlocks3.write = i15;
                                    return infBlocks3.inflate_flush(iInflate_fast);
                                }
                                i24 = i15;
                                i26 = i17;
                            }
                        }
                        infBlocks = this.s;
                        byte[] bArr = infBlocks.window;
                        int i40 = i24 + 1;
                        i13 = i12 + 1;
                        bArr[i24] = bArr[i12];
                        i26--;
                        if (i13 == infBlocks.end) {
                            i12 = 0;
                        } else {
                            i12 = i13;
                        }
                        this.len--;
                        i24 = i40;
                    }
                    this.mode = 0;
                    break;
                case 5:
                    i12 = i24 - this.dist;
                    while (i12 < 0) {
                        i12 += this.s.end;
                    }
                    while (this.len != 0) {
                        if (i26 == 0) {
                            infBlocks2 = this.s;
                            i14 = infBlocks2.end;
                            if (i24 == i14) {
                                if (i19 > 0) {
                                    i26 = i19 - 1;
                                } else {
                                    i26 = i14;
                                }
                                i24 = 0;
                            }
                            if (i26 == 0) {
                                infBlocks2.write = i24;
                                iInflate_fast = infBlocks2.inflate_flush(iInflate_fast);
                                infBlocks3 = this.s;
                                i15 = infBlocks3.write;
                                i16 = infBlocks3.read;
                                if (i15 < i16) {
                                    i17 = (i16 - i15) - 1;
                                } else {
                                    i17 = infBlocks3.end - i15;
                                }
                                i18 = infBlocks3.end;
                                if (i15 == i18) {
                                    if (i16 > 0) {
                                        i18 = i16 - 1;
                                    }
                                    i17 = i18;
                                    i15 = 0;
                                }
                                if (i17 == 0) {
                                    infBlocks3.bitb = i22;
                                    infBlocks3.bitk = i23;
                                    ZStream zStream15 = this.z;
                                    zStream15.avail_in = i28;
                                    zStream15.total_in += (long) (i27 - zStream15.next_in_index);
                                    zStream15.next_in_index = i27;
                                    infBlocks3.write = i15;
                                    return infBlocks3.inflate_flush(iInflate_fast);
                                }
                                i24 = i15;
                                i26 = i17;
                            }
                        }
                        infBlocks = this.s;
                        byte[] bArr2 = infBlocks.window;
                        int i41 = i24 + 1;
                        i13 = i12 + 1;
                        bArr2[i24] = bArr2[i12];
                        i26--;
                        if (i13 == infBlocks.end) {
                            i12 = 0;
                        } else {
                            i12 = i13;
                        }
                        this.len--;
                        i24 = i41;
                    }
                    this.mode = 0;
                    break;
                case 6:
                    if (i26 == 0) {
                        InfBlocks infBlocks17 = this.s;
                        int i42 = infBlocks17.end;
                        if (i24 == i42 && (i2 = infBlocks17.read) != 0) {
                            i26 = i2 > 0 ? i2 - 1 : i42;
                            i24 = 0;
                        }
                        if (i26 == 0) {
                            infBlocks17.write = i24;
                            int iInflate_flush = infBlocks17.inflate_flush(iInflate_fast);
                            InfBlocks infBlocks18 = this.s;
                            int i43 = infBlocks18.write;
                            int i44 = infBlocks18.read;
                            int i45 = i43 < i44 ? (i44 - i43) - 1 : infBlocks18.end - i43;
                            int i46 = infBlocks18.end;
                            if (i43 == i46 && i44 != 0) {
                                if (i44 > 0) {
                                    i46 = i44 - 1;
                                }
                                i45 = i46;
                                i43 = 0;
                            }
                            if (i45 == 0) {
                                infBlocks18.bitb = i22;
                                infBlocks18.bitk = i23;
                                ZStream zStream16 = this.z;
                                zStream16.avail_in = i28;
                                zStream16.total_in += (long) (i27 - zStream16.next_in_index);
                                zStream16.next_in_index = i27;
                                infBlocks18.write = i43;
                                return infBlocks18.inflate_flush(iInflate_flush);
                            }
                            i24 = i43;
                            i26 = i45;
                        }
                    }
                    this.s.window[i24] = (byte) this.lit;
                    i26--;
                    this.mode = 0;
                    i24++;
                    iInflate_fast = 0;
                    break;
                case 7:
                    if (i23 > 7) {
                        i23 -= 8;
                        i28++;
                        i27--;
                    }
                    InfBlocks infBlocks19 = this.s;
                    infBlocks19.write = i24;
                    int iInflate_flush2 = infBlocks19.inflate_flush(iInflate_fast);
                    InfBlocks infBlocks20 = this.s;
                    int i47 = infBlocks20.write;
                    if (infBlocks20.read != i47) {
                        infBlocks20.bitb = i22;
                        infBlocks20.bitk = i23;
                        ZStream zStream17 = this.z;
                        zStream17.avail_in = i28;
                        zStream17.total_in += (long) (i27 - zStream17.next_in_index);
                        zStream17.next_in_index = i27;
                        infBlocks20.write = i47;
                        return infBlocks20.inflate_flush(iInflate_flush2);
                    }
                    this.mode = 8;
                    i24 = i47;
                    InfBlocks infBlocks21 = this.s;
                    infBlocks21.bitb = i22;
                    infBlocks21.bitk = i23;
                    ZStream zStream18 = this.z;
                    zStream18.avail_in = i28;
                    zStream18.total_in += (long) (i27 - zStream18.next_in_index);
                    zStream18.next_in_index = i27;
                    infBlocks21.write = i24;
                    return infBlocks21.inflate_flush(1);
                case 8:
                    InfBlocks infBlocks22 = this.s;
                    infBlocks22.bitb = i22;
                    infBlocks22.bitk = i23;
                    ZStream zStream19 = this.z;
                    zStream19.avail_in = i28;
                    zStream19.total_in += (long) (i27 - zStream19.next_in_index);
                    zStream19.next_in_index = i27;
                    infBlocks22.write = i24;
                    return infBlocks22.inflate_flush(1);
                case 9:
                    InfBlocks infBlocks23 = this.s;
                    infBlocks23.bitb = i22;
                    infBlocks23.bitk = i23;
                    ZStream zStream20 = this.z;
                    zStream20.avail_in = i28;
                    zStream20.total_in += (long) (i27 - zStream20.next_in_index);
                    zStream20.next_in_index = i27;
                    infBlocks23.write = i24;
                    return infBlocks23.inflate_flush(-3);
                default:
                    InfBlocks infBlocks24 = this.s;
                    infBlocks24.bitb = i22;
                    infBlocks24.bitk = i23;
                    ZStream zStream21 = this.z;
                    zStream21.avail_in = i28;
                    zStream21.total_in += (long) (i27 - zStream21.next_in_index);
                    zStream21.next_in_index = i27;
                    infBlocks24.write = i24;
                    return infBlocks24.inflate_flush(-2);
            }
        }
    }
}
