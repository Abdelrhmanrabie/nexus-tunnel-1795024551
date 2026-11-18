package com.jcraft.jzlib;

import androidx.recyclerview.widget.n;
import com.trilead.ssh2.sftp.Packet;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class InfTree {
    static final int BMAX = 15;
    private static final int MANY = 1440;
    private static final int Z_BUF_ERROR = -5;
    private static final int Z_DATA_ERROR = -3;
    private static final int Z_ERRNO = -1;
    private static final int Z_MEM_ERROR = -4;
    private static final int Z_NEED_DICT = 2;
    private static final int Z_OK = 0;
    private static final int Z_STREAM_END = 1;
    private static final int Z_STREAM_ERROR = -2;
    private static final int Z_VERSION_ERROR = -6;
    static final int fixed_bd = 5;
    static final int fixed_bl = 9;
    static final int[] fixed_tl = {96, 7, 256, 0, 8, 80, 0, 8, 16, 84, 8, 115, 82, 7, 31, 0, 8, 112, 0, 8, 48, 0, 9, 192, 80, 7, 10, 0, 8, 96, 0, 8, 32, 0, 9, 160, 0, 8, 0, 0, 8, 128, 0, 8, 64, 0, 9, 224, 80, 7, 6, 0, 8, 88, 0, 8, 24, 0, 9, 144, 83, 7, 59, 0, 8, 120, 0, 8, 56, 0, 9, 208, 81, 7, 17, 0, 8, 104, 0, 8, 40, 0, 9, 176, 0, 8, 8, 0, 8, 136, 0, 8, 72, 0, 9, 240, 80, 7, 4, 0, 8, 84, 0, 8, 20, 85, 8, 227, 83, 7, 43, 0, 8, 116, 0, 8, 52, 0, 9, 200, 81, 7, 13, 0, 8, 100, 0, 8, 36, 0, 9, 168, 0, 8, 4, 0, 8, 132, 0, 8, 68, 0, 9, 232, 80, 7, 8, 0, 8, 92, 0, 8, 28, 0, 9, 152, 84, 7, 83, 0, 8, R.styleable.AppCompatTheme_windowMinWidthMajor, 0, 8, 60, 0, 9, 216, 82, 7, 23, 0, 8, 108, 0, 8, 44, 0, 9, 184, 0, 8, 12, 0, 8, 140, 0, 8, 76, 0, 9, 248, 80, 7, 3, 0, 8, 82, 0, 8, 18, 85, 8, 163, 83, 7, 35, 0, 8, 114, 0, 8, 50, 0, 9, 196, 81, 7, 11, 0, 8, 98, 0, 8, 34, 0, 9, 164, 0, 8, 2, 0, 8, 130, 0, 8, 66, 0, 9, 228, 80, 7, 7, 0, 8, 90, 0, 8, 26, 0, 9, 148, 84, 7, 67, 0, 8, 122, 0, 8, 58, 0, 9, 212, 82, 7, 19, 0, 8, 106, 0, 8, 42, 0, 9, 180, 0, 8, 10, 0, 8, 138, 0, 8, 74, 0, 9, 244, 80, 7, 5, 0, 8, 86, 0, 8, 22, 192, 8, 0, 83, 7, 51, 0, 8, 118, 0, 8, 54, 0, 9, 204, 81, 7, 15, 0, 8, 102, 0, 8, 38, 0, 9, 172, 0, 8, 6, 0, 8, 134, 0, 8, 70, 0, 9, 236, 80, 7, 9, 0, 8, 94, 0, 8, 30, 0, 9, 156, 84, 7, 99, 0, 8, R.styleable.AppCompatTheme_windowNoTitle, 0, 8, 62, 0, 9, 220, 82, 7, 27, 0, 8, 110, 0, 8, 46, 0, 9, 188, 0, 8, 14, 0, 8, 142, 0, 8, 78, 0, 9, 252, 96, 7, 256, 0, 8, 81, 0, 8, 17, 85, 8, 131, 82, 7, 31, 0, 8, 113, 0, 8, 49, 0, 9, 194, 80, 7, 10, 0, 8, 97, 0, 8, 33, 0, 9, 162, 0, 8, 1, 0, 8, 129, 0, 8, 65, 0, 9, 226, 80, 7, 6, 0, 8, 89, 0, 8, 25, 0, 9, 146, 83, 7, 59, 0, 8, 121, 0, 8, 57, 0, 9, 210, 81, 7, 17, 0, 8, 105, 0, 8, 41, 0, 9, 178, 0, 8, 9, 0, 8, 137, 0, 8, 73, 0, 9, 242, 80, 7, 4, 0, 8, 85, 0, 8, 21, 80, 8, 258, 83, 7, 43, 0, 8, 117, 0, 8, 53, 0, 9, 202, 81, 7, 13, 0, 8, 101, 0, 8, 37, 0, 9, 170, 0, 8, 5, 0, 8, 133, 0, 8, 69, 0, 9, 234, 80, 7, 8, 0, 8, 93, 0, 8, 29, 0, 9, 154, 84, 7, 83, 0, 8, R.styleable.AppCompatTheme_windowMinWidthMinor, 0, 8, 61, 0, 9, 218, 82, 7, 23, 0, 8, 109, 0, 8, 45, 0, 9, 186, 0, 8, 13, 0, 8, 141, 0, 8, 77, 0, 9, n.DEFAULT_SWIPE_ANIMATION_DURATION, 80, 7, 3, 0, 8, 83, 0, 8, 19, 85, 8, 195, 83, 7, 35, 0, 8, 115, 0, 8, 51, 0, 9, 198, 81, 7, 11, 0, 8, 99, 0, 8, 35, 0, 9, 166, 0, 8, 3, 0, 8, 131, 0, 8, 67, 0, 9, 230, 80, 7, 7, 0, 8, 91, 0, 8, 27, 0, 9, 150, 84, 7, 67, 0, 8, 123, 0, 8, 59, 0, 9, 214, 82, 7, 19, 0, 8, 107, 0, 8, 43, 0, 9, 182, 0, 8, 11, 0, 8, 139, 0, 8, 75, 0, 9, 246, 80, 7, 5, 0, 8, 87, 0, 8, 23, 192, 8, 0, 83, 7, 51, 0, 8, 119, 0, 8, 55, 0, 9, 206, 81, 7, 15, 0, 8, 103, 0, 8, 39, 0, 9, 174, 0, 8, 7, 0, 8, 135, 0, 8, 71, 0, 9, 238, 80, 7, 9, 0, 8, 95, 0, 8, 31, 0, 9, 158, 84, 7, 99, 0, 8, 127, 0, 8, 63, 0, 9, 222, 82, 7, 27, 0, 8, 111, 0, 8, 47, 0, 9, 190, 0, 8, 15, 0, 8, 143, 0, 8, 79, 0, 9, 254, 96, 7, 256, 0, 8, 80, 0, 8, 16, 84, 8, 115, 82, 7, 31, 0, 8, 112, 0, 8, 48, 0, 9, 193, 80, 7, 10, 0, 8, 96, 0, 8, 32, 0, 9, 161, 0, 8, 0, 0, 8, 128, 0, 8, 64, 0, 9, 225, 80, 7, 6, 0, 8, 88, 0, 8, 24, 0, 9, 145, 83, 7, 59, 0, 8, 120, 0, 8, 56, 0, 9, 209, 81, 7, 17, 0, 8, 104, 0, 8, 40, 0, 9, 177, 0, 8, 8, 0, 8, 136, 0, 8, 72, 0, 9, 241, 80, 7, 4, 0, 8, 84, 0, 8, 20, 85, 8, 227, 83, 7, 43, 0, 8, 116, 0, 8, 52, 0, 9, Packet.SSH_FXP_EXTENDED_REPLY, 81, 7, 13, 0, 8, 100, 0, 8, 36, 0, 9, 169, 0, 8, 4, 0, 8, 132, 0, 8, 68, 0, 9, 233, 80, 7, 8, 0, 8, 92, 0, 8, 28, 0, 9, 153, 84, 7, 83, 0, 8, R.styleable.AppCompatTheme_windowMinWidthMajor, 0, 8, 60, 0, 9, 217, 82, 7, 23, 0, 8, 108, 0, 8, 44, 0, 9, 185, 0, 8, 12, 0, 8, 140, 0, 8, 76, 0, 9, 249, 80, 7, 3, 0, 8, 82, 0, 8, 18, 85, 8, 163, 83, 7, 35, 0, 8, 114, 0, 8, 50, 0, 9, 197, 81, 7, 11, 0, 8, 98, 0, 8, 34, 0, 9, 165, 0, 8, 2, 0, 
    8, 130, 0, 8, 66, 0, 9, 229, 80, 7, 7, 0, 8, 90, 0, 8, 26, 0, 9, 149, 84, 7, 67, 0, 8, 122, 0, 8, 58, 0, 9, 213, 82, 7, 19, 0, 8, 106, 0, 8, 42, 0, 9, 181, 0, 8, 10, 0, 8, 138, 0, 8, 74, 0, 9, 245, 80, 7, 5, 0, 8, 86, 0, 8, 22, 192, 8, 0, 83, 7, 51, 0, 8, 118, 0, 8, 54, 0, 9, 205, 81, 7, 15, 0, 8, 102, 0, 8, 38, 0, 9, 173, 0, 8, 6, 0, 8, 134, 0, 8, 70, 0, 9, 237, 80, 7, 9, 0, 8, 94, 0, 8, 30, 0, 9, 157, 84, 7, 99, 0, 8, R.styleable.AppCompatTheme_windowNoTitle, 0, 8, 62, 0, 9, 221, 82, 7, 27, 0, 8, 110, 0, 8, 46, 0, 9, 189, 0, 8, 14, 0, 8, 142, 0, 8, 78, 0, 9, 253, 96, 7, 256, 0, 8, 81, 0, 8, 17, 85, 8, 131, 82, 7, 31, 0, 8, 113, 0, 8, 49, 0, 9, 195, 80, 7, 10, 0, 8, 97, 0, 8, 33, 0, 9, 163, 0, 8, 1, 0, 8, 129, 0, 8, 65, 0, 9, 227, 80, 7, 6, 0, 8, 89, 0, 8, 25, 0, 9, 147, 83, 7, 59, 0, 8, 121, 0, 8, 57, 0, 9, 211, 81, 7, 17, 0, 8, 105, 0, 8, 41, 0, 9, 179, 0, 8, 9, 0, 8, 137, 0, 8, 73, 0, 9, 243, 80, 7, 4, 0, 8, 85, 0, 8, 21, 80, 8, 258, 83, 7, 43, 0, 8, 117, 0, 8, 53, 0, 9, 203, 81, 7, 13, 0, 8, 101, 0, 8, 37, 0, 9, 171, 0, 8, 5, 0, 8, 133, 0, 8, 69, 0, 9, 235, 80, 7, 8, 0, 8, 93, 0, 8, 29, 0, 9, 155, 84, 7, 83, 0, 8, R.styleable.AppCompatTheme_windowMinWidthMinor, 0, 8, 61, 0, 9, 219, 82, 7, 23, 0, 8, 109, 0, 8, 45, 0, 9, 187, 0, 8, 13, 0, 8, 141, 0, 8, 77, 0, 9, 251, 80, 7, 3, 0, 8, 83, 0, 8, 19, 85, 8, 195, 83, 7, 35, 0, 8, 115, 0, 8, 51, 0, 9, 199, 81, 7, 11, 0, 8, 99, 0, 8, 35, 0, 9, 167, 0, 8, 3, 0, 8, 131, 0, 8, 67, 0, 9, 231, 80, 7, 7, 0, 8, 91, 0, 8, 27, 0, 9, 151, 84, 7, 67, 0, 8, 123, 0, 8, 59, 0, 9, 215, 82, 7, 19, 0, 8, 107, 0, 8, 43, 0, 9, 183, 0, 8, 11, 0, 8, 139, 0, 8, 75, 0, 9, 247, 80, 7, 5, 0, 8, 87, 0, 8, 23, 192, 8, 0, 83, 7, 51, 0, 8, 119, 0, 8, 55, 0, 9, 207, 81, 7, 15, 0, 8, 103, 0, 8, 39, 0, 9, 175, 0, 8, 7, 0, 8, 135, 0, 8, 71, 0, 9, 239, 80, 7, 9, 0, 8, 95, 0, 8, 31, 0, 9, 159, 84, 7, 99, 0, 8, 127, 0, 8, 63, 0, 9, 223, 82, 7, 27, 0, 8, 111, 0, 8, 47, 0, 9, 191, 0, 8, 15, 0, 8, 143, 0, 8, 79, 0, 9, 255};
    static final int[] fixed_td = {80, 5, 1, 87, 5, 257, 83, 5, 17, 91, 5, 4097, 81, 5, 5, 89, 5, 1025, 85, 5, 65, 93, 5, 16385, 80, 5, 3, 88, 5, 513, 84, 5, 33, 92, 5, 8193, 82, 5, 9, 90, 5, 2049, 86, 5, 129, 192, 5, 24577, 80, 5, 2, 87, 5, 385, 83, 5, 25, 91, 5, 6145, 81, 5, 7, 89, 5, 1537, 85, 5, 97, 93, 5, 24577, 80, 5, 4, 88, 5, 769, 84, 5, 49, 92, 5, 12289, 82, 5, 13, 90, 5, 3073, 86, 5, 193, 192, 5, 24577};
    static final int[] cplens = {3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 19, 23, 27, 31, 35, 43, 51, 59, 67, 83, 99, 115, 131, 163, 195, 227, 258, 0, 0};
    static final int[] cplext = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0, 112, 112};
    static final int[] cpdist = {1, 2, 3, 4, 5, 7, 9, 13, 17, 25, 33, 49, 65, 97, 129, 193, 257, 385, 513, 769, 1025, 1537, 2049, 3073, 4097, 6145, 8193, 12289, 16385, 24577};
    static final int[] cpdext = {0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13};
    int[] hn = null;
    int[] v = null;
    int[] c = null;
    int[] r = null;
    int[] u = null;
    int[] x = null;

    private int huft_build(int[] iArr, int i, int i2, int i3, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7, int[] iArr8) {
        int[] iArr9;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = 0;
        int i12 = i2;
        int i13 = 0;
        do {
            iArr9 = this.c;
            int i14 = iArr[i + i13];
            i4 = 1;
            iArr9[i14] = iArr9[i14] + 1;
            i13++;
            i5 = -1;
            i12--;
        } while (i12 != 0);
        if (iArr9[0] == i2) {
            iArr4[0] = -1;
            iArr5[0] = 0;
            return 0;
        }
        int i15 = iArr5[0];
        int i16 = 1;
        while (i16 <= 15 && this.c[i16] == 0) {
            i16++;
        }
        if (i15 < i16) {
            i15 = i16;
        }
        int i17 = 15;
        while (i17 != 0 && this.c[i17] == 0) {
            i17--;
        }
        int i18 = i15 > i17 ? i17 : i15;
        iArr5[0] = i18;
        int i19 = 1 << i16;
        int i20 = i16;
        while (true) {
            int[] iArr10 = this.c;
            if (i20 < i17) {
                int i21 = i19 - iArr10[i20];
                if (i21 < 0) {
                    return -3;
                }
                i20++;
                i19 = i21 << 1;
            } else {
                int i22 = iArr10[i17];
                int i23 = i19 - i22;
                if (i23 < 0) {
                    return -3;
                }
                iArr10[i17] = i22 + i23;
                this.x[1] = 0;
                int i24 = 0;
                int i25 = i17;
                int i26 = 1;
                int i27 = 2;
                while (true) {
                    i25 += i5;
                    i6 = i5;
                    if (i25 == 0) {
                        break;
                    }
                    int[] iArr11 = this.x;
                    i24 += this.c[i26];
                    iArr11[i27] = i24;
                    i27++;
                    i26++;
                    i5 = i6;
                }
                int i28 = 0;
                int i29 = 0;
                while (true) {
                    int i30 = iArr[i + i28];
                    if (i30 != 0) {
                        int[] iArr12 = this.x;
                        int i31 = iArr12[i30];
                        iArr12[i30] = i31 + 1;
                        iArr8[i31] = i29;
                    }
                    i28++;
                    i29++;
                    if (i29 >= i2) {
                        break;
                    }
                    i3 = i3;
                }
                int[] iArr13 = this.x;
                int i32 = iArr13[i17];
                iArr13[0] = 0;
                int i33 = -i18;
                this.u[0] = 0;
                int i34 = 0;
                int i35 = 0;
                int i36 = 0;
                int i37 = 0;
                int i38 = i6;
                while (true) {
                    int i39 = i4;
                    if (i16 > i17) {
                        return (i23 == 0 || i17 == i39) ? 0 : -5;
                    }
                    int i40 = this.c[i16];
                    while (true) {
                        int i41 = i40 - 1;
                        if (i40 != 0) {
                            int i42 = i11;
                            while (true) {
                                int i43 = i33 + i18;
                                i7 = i33;
                                if (i16 > i43) {
                                    int i44 = i38 + 1;
                                    int i45 = i17 - i43;
                                    if (i45 > i18) {
                                        i45 = i18;
                                    }
                                    int i46 = i16 - i43;
                                    int i47 = i39 << i46;
                                    if (i47 > i40) {
                                        int i48 = i47 - i40;
                                        if (i46 < i45) {
                                            int i49 = i16;
                                            while (true) {
                                                int i50 = i46 + 1;
                                                if (i50 >= i45) {
                                                    i10 = i50;
                                                    break;
                                                }
                                                int i51 = i48 << 1;
                                                i10 = i50;
                                                i49++;
                                                int i52 = this.c[i49];
                                                if (i51 <= i52) {
                                                    break;
                                                }
                                                i48 = i51 - i52;
                                                i46 = i10;
                                            }
                                            i46 = i10;
                                        }
                                    }
                                    i37 = i39 << i46;
                                    int i53 = iArr7[i42];
                                    int i54 = i34;
                                    if (i53 + i37 > MANY) {
                                        return -3;
                                    }
                                    int[] iArr14 = this.u;
                                    iArr14[i44] = i53;
                                    iArr7[i42] = iArr7[i42] + i37;
                                    if (i44 != 0) {
                                        this.x[i44] = i54;
                                        int[] iArr15 = this.r;
                                        iArr15[i42] = (byte) i46;
                                        iArr15[i39] = (byte) i18;
                                        int i55 = i54 >>> (i43 - i18);
                                        iArr15[2] = (i53 - iArr14[i38]) - i55;
                                        int i56 = (iArr14[i38] + i55) * 3;
                                        i9 = i42;
                                        System.arraycopy(iArr15, i9, iArr6, i56, 3);
                                    } else {
                                        i9 = i42;
                                        iArr4[i9] = i53;
                                    }
                                    i34 = i54;
                                    i42 = i9;
                                    i38 = i44;
                                    i36 = i53;
                                    i33 = i43;
                                }
                            }
                            int i57 = i34;
                            int i58 = i42;
                            int[] iArr16 = this.r;
                            int i59 = i16 - i7;
                            iArr16[i39] = (byte) i59;
                            if (i35 >= i32) {
                                iArr16[i58] = 192;
                            } else {
                                int i60 = iArr8[i35];
                                if (i60 < i3) {
                                    iArr16[i58] = (byte) (i60 < 256 ? i58 : 96);
                                    i8 = i35 + 1;
                                    iArr16[2] = iArr8[i35];
                                } else {
                                    iArr16[i58] = (byte) (iArr3[i60 - i3] + 80);
                                    i8 = i35 + 1;
                                    iArr16[2] = iArr2[iArr8[i35] - i3];
                                }
                                i35 = i8;
                            }
                            int i61 = i39 << i59;
                            int i62 = i57 >>> i7;
                            while (i62 < i37) {
                                int i63 = i61;
                                System.arraycopy(this.r, 0, iArr6, (i36 + i62) * 3, 3);
                                i62 += i63;
                                i61 = i63;
                            }
                            int i64 = i39 << (i16 - 1);
                            i34 = i57;
                            while (true) {
                                int i65 = i34 & i64;
                                i34 ^= i64;
                                if (i65 == 0) {
                                    break;
                                }
                                i64 >>>= 1;
                            }
                            i33 = i7;
                            while ((((i39 << i33) - 1) & i34) != this.x[i38]) {
                                i38--;
                                i33 -= i18;
                            }
                            i3 = i3;
                            i40 = i41;
                            i11 = 0;
                        }
                    }
                    i16++;
                    i3 = i3;
                    i4 = i39;
                    i11 = 0;
                }
            }
        }
    }

    public static int inflate_trees_fixed(int[] iArr, int[] iArr2, int[][] iArr3, int[][] iArr4, ZStream zStream) {
        iArr[0] = 9;
        iArr2[0] = 5;
        iArr3[0] = fixed_tl;
        iArr4[0] = fixed_td;
        return 0;
    }

    private void initWorkArea(int i) {
        if (this.hn == null) {
            this.hn = new int[1];
            this.v = new int[i];
            this.c = new int[16];
            this.r = new int[3];
            this.u = new int[15];
            this.x = new int[16];
        }
        if (this.v.length < i) {
            this.v = new int[i];
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.v[i2] = 0;
        }
        for (int i3 = 0; i3 < 16; i3++) {
            this.c[i3] = 0;
        }
        for (int i4 = 0; i4 < 3; i4++) {
            this.r[i4] = 0;
        }
        System.arraycopy(this.c, 0, this.u, 0, 15);
        System.arraycopy(this.c, 0, this.x, 0, 16);
    }

    public int inflate_trees_bits(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, ZStream zStream) {
        initWorkArea(19);
        int[] iArr5 = this.hn;
        iArr5[0] = 0;
        int iHuft_build = huft_build(iArr, 0, 19, 19, null, null, iArr3, iArr2, iArr4, iArr5, this.v);
        if (iHuft_build == -3) {
            zStream.msg = "oversubscribed dynamic bit lengths tree";
            return iHuft_build;
        }
        if (iHuft_build != -5 && iArr2[0] != 0) {
            return iHuft_build;
        }
        zStream.msg = "incomplete dynamic bit lengths tree";
        return -3;
    }

    public int inflate_trees_dynamic(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, ZStream zStream) {
        String str;
        initWorkArea(288);
        int[] iArr7 = this.hn;
        iArr7[0] = 0;
        int iHuft_build = huft_build(iArr, 0, i, 257, cplens, cplext, iArr4, iArr2, iArr6, iArr7, this.v);
        if (iHuft_build != 0 || iArr2[0] == 0) {
            if (iHuft_build == -3) {
                zStream.msg = "oversubscribed literal/length tree";
                return iHuft_build;
            }
            if (iHuft_build == -4) {
                return iHuft_build;
            }
            zStream.msg = "incomplete literal/length tree";
            return -3;
        }
        initWorkArea(288);
        int iHuft_build2 = huft_build(iArr, i, i2, 0, cpdist, cpdext, iArr5, iArr3, iArr6, this.hn, this.v);
        if (iHuft_build2 == 0 && (iArr3[0] != 0 || i <= 257)) {
            return 0;
        }
        if (iHuft_build2 == -3) {
            zStream.msg = "oversubscribed distance tree";
            return iHuft_build2;
        }
        if (iHuft_build2 == -5) {
            str = "incomplete distance tree";
        } else {
            if (iHuft_build2 == -4) {
                return iHuft_build2;
            }
            str = "empty distance tree with lengths";
        }
        zStream.msg = str;
        return -3;
    }
}
