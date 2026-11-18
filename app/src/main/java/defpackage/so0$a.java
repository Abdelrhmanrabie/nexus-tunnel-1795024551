package defpackage;

import android.graphics.Path;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class so0$a {
    public char a;
    public final float[] b;

    public so0$a(char c, float[] fArr) {
        this.a = c;
        this.b = fArr;
    }

    public so0$a(so0$a so0_a) {
        this.a = so0_a.a;
        float[] fArr = so0_a.b;
        int length = fArr.length;
        if (length < 0) {
            throw new IllegalArgumentException();
        }
        int length2 = fArr.length;
        if (length2 < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(length, length2);
        float[] fArr2 = new float[length];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        this.b = fArr2;
    }

    public static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double d;
        double d2;
        double radians = Math.toRadians(f7);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d3 = f;
        double d4 = f2;
        double d5 = f5;
        double d6 = ((d4 * dSin) + (d3 * dCos)) / d5;
        double d7 = f6;
        double d8 = ((d4 * dCos) + (((double) (-f)) * dSin)) / d7;
        double d9 = f4;
        double d10 = ((d9 * dSin) + (((double) f3) * dCos)) / d5;
        double d11 = ((d9 * dCos) + (((double) (-f3)) * dSin)) / d7;
        double d12 = d6 - d10;
        double d13 = d8 - d11;
        double d14 = (d6 + d10) / 2.0d;
        double d15 = (d8 + d11) / 2.0d;
        double d16 = (d13 * d13) + (d12 * d12);
        if (d16 == 0.0d) {
            return;
        }
        double d17 = (1.0d / d16) - 0.25d;
        if (d17 < 0.0d) {
            float fSqrt = (float) (Math.sqrt(d16) / 1.99999d);
            a(path, f, f2, f3, f4, f5 * fSqrt, fSqrt * f6, f7, z, z2);
            return;
        }
        double dSqrt = Math.sqrt(d17);
        double d18 = d12 * dSqrt;
        double d19 = dSqrt * d13;
        if (z == z2) {
            d = d14 - d19;
            d2 = d15 + d18;
        } else {
            d = d14 + d19;
            d2 = d15 - d18;
        }
        double dAtan2 = Math.atan2(d8 - d2, d6 - d);
        double dAtan3 = Math.atan2(d11 - d2, d10 - d) - dAtan2;
        if (z2 != (dAtan3 >= 0.0d)) {
            dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
        }
        double d20 = d * d5;
        double d21 = d2 * d7;
        double d22 = (d20 * dCos) - (d21 * dSin);
        double d23 = (d21 * dCos) + (d20 * dSin);
        int iCeil = (int) Math.ceil(Math.abs((dAtan3 * 4.0d) / 3.141592653589793d));
        double dCos2 = Math.cos(radians);
        double dSin2 = Math.sin(radians);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d24 = -d5;
        double d25 = d24 * dCos2;
        double d26 = d7 * dSin2;
        double d27 = (d25 * dSin3) - (d26 * dCos3);
        double d28 = d24 * dSin2;
        double d29 = d7 * dCos2;
        double d30 = dAtan3 / ((double) iCeil);
        double d31 = (dCos3 * d29) + (dSin3 * d28);
        int i = 0;
        double d32 = d3;
        double d33 = d4;
        double d34 = dAtan2;
        while (i < iCeil) {
            double d35 = d34 + d30;
            double dSin4 = Math.sin(d35);
            double dCos4 = Math.cos(d35);
            double d36 = d30;
            double d37 = (((d5 * dCos2) * dCos4) + d22) - (d26 * dSin4);
            double d38 = d22;
            double d39 = (d29 * dSin4) + (d5 * dSin2 * dCos4) + d23;
            double d40 = (d25 * dSin4) - (d26 * dCos4);
            double d41 = (dCos4 * d29) + (dSin4 * d28);
            double d42 = d35 - d34;
            double dTan = Math.tan(d42 / 2.0d);
            double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d42)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d27 * dSqrt2) + d32), (float) ((d31 * dSqrt2) + d33), (float) (d37 - (dSqrt2 * d40)), (float) (d39 - (dSqrt2 * d41)), (float) d37, (float) d39);
            i++;
            d33 = d39;
            iCeil = iCeil;
            d28 = d28;
            dCos2 = dCos2;
            d34 = d35;
            d31 = d41;
            d27 = d40;
            d22 = d38;
            d32 = d37;
            d30 = d36;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(so0$a[] so0_aArr, Path path) {
        int i;
        int i2;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        so0$a[] so0_aArr2 = so0_aArr;
        float[] fArr = new float[6];
        int length = so0_aArr2.length;
        int i3 = 0;
        char c = 'm';
        int i4 = 0;
        char c2 = 'm';
        while (i4 < length) {
            so0$a so0_a = so0_aArr2[i4];
            char c3 = so0_a.a;
            float f16 = fArr[i3];
            float f17 = fArr[1];
            float f18 = fArr[2];
            float f19 = fArr[3];
            float f20 = fArr[4];
            float f21 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f20, f21);
                    f16 = f20;
                    f18 = f16;
                    f17 = f21;
                    f19 = f17;
                default:
                    i = 2;
                    break;
            }
            float f22 = f17;
            float f23 = f20;
            float f24 = f21;
            float f25 = f16;
            int i5 = i3;
            while (true) {
                float[] fArr2 = so0_a.b;
                if (i5 < fArr2.length) {
                    int i6 = i3;
                    if (c3 != 'A') {
                        if (c3 == 'C') {
                            i2 = i5;
                            i4 = i4;
                            so0_a = so0_a;
                            c3 = c3;
                            int i7 = i2 + 2;
                            int i8 = i2 + 3;
                            int i9 = i2 + 4;
                            int i10 = i2 + 5;
                            path.cubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i7], fArr2[i8], fArr2[i9], fArr2[i10]);
                            float f26 = fArr2[i9];
                            float f27 = fArr2[i10];
                            f18 = fArr2[i7];
                            f19 = fArr2[i8];
                            f2 = f27;
                            f = f26;
                        } else if (c3 == 'H') {
                            i2 = i5;
                            so0_a = so0_a;
                            c3 = c3;
                            f2 = f22;
                            i4 = i4;
                            path.lineTo(fArr2[i2], f2);
                            f = fArr2[i2];
                        } else if (c3 == 'Q') {
                            i2 = i5;
                            i4 = i4;
                            so0_a = so0_a;
                            c3 = c3;
                            int i11 = i2 + 1;
                            int i12 = i2 + 2;
                            int i13 = i2 + 3;
                            path.quadTo(fArr2[i2], fArr2[i11], fArr2[i12], fArr2[i13]);
                            float f28 = fArr2[i2];
                            float f29 = fArr2[i11];
                            float f30 = fArr2[i12];
                            f19 = f29;
                            f2 = fArr2[i13];
                            f18 = f28;
                            f = f30;
                        } else if (c3 == 'V') {
                            i2 = i5;
                            i4 = i4;
                            so0_a = so0_a;
                            f = f25;
                            c3 = c3;
                            path.lineTo(f, fArr2[i2]);
                            f2 = fArr2[i2];
                        } else if (c3 != 'a') {
                            if (c3 != 'c') {
                                if (c3 != 'h') {
                                    if (c3 != 'q') {
                                        if (c3 != 'v') {
                                            if (c3 != 'L') {
                                                if (c3 == 'M') {
                                                    i2 = i5;
                                                    f10 = fArr2[i2];
                                                    f11 = fArr2[i2 + 1];
                                                    if (i2 > 0) {
                                                        path.lineTo(f10, f11);
                                                    } else {
                                                        path.moveTo(f10, f11);
                                                        f23 = f10;
                                                        f22 = f11;
                                                    }
                                                } else if (c3 != 'S') {
                                                    if (c3 == 'T') {
                                                        i2 = i5;
                                                        if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                                                            f25 = (f25 * 2.0f) - f18;
                                                            f22 = (f22 * 2.0f) - f19;
                                                        }
                                                        f6 = f22;
                                                        float f31 = fArr2[i2];
                                                        int i14 = i2 + 1;
                                                        path.quadTo(f25, f6, f31, fArr2[i14]);
                                                        f5 = fArr2[i2];
                                                        f4 = fArr2[i14];
                                                    } else if (c3 == 'l') {
                                                        i2 = i5;
                                                        int i15 = i2 + 1;
                                                        path.rLineTo(fArr2[i2], fArr2[i15]);
                                                        f25 += fArr2[i2];
                                                        f9 = fArr2[i15];
                                                    } else if (c3 == c) {
                                                        i2 = i5;
                                                        float f32 = fArr2[i2];
                                                        f25 += f32;
                                                        float f33 = fArr2[i2 + 1];
                                                        f22 += f33;
                                                        if (i2 > 0) {
                                                            path.rLineTo(f32, f33);
                                                        } else {
                                                            path.rMoveTo(f32, f33);
                                                            f23 = f25;
                                                        }
                                                    } else if (c3 != 's') {
                                                        if (c3 == 't') {
                                                            if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                                                                f14 = f25 - f18;
                                                                f15 = f22 - f19;
                                                            } else {
                                                                f15 = 0.0f;
                                                                f14 = 0.0f;
                                                            }
                                                            int i16 = i5 + 1;
                                                            path.rQuadTo(f14, f15, fArr2[i5], fArr2[i16]);
                                                            f18 = f14 + f25;
                                                            float f34 = f15 + f22;
                                                            f25 += fArr2[i5];
                                                            f22 += fArr2[i16];
                                                            f19 = f34;
                                                        }
                                                        i2 = i5;
                                                    } else {
                                                        if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                                                            f12 = f22 - f19;
                                                            f13 = f25 - f18;
                                                        } else {
                                                            f13 = 0.0f;
                                                            f12 = 0.0f;
                                                        }
                                                        int i17 = i5 + 1;
                                                        int i18 = i5 + 2;
                                                        int i19 = i5 + 3;
                                                        float f35 = f12;
                                                        i2 = i5;
                                                        path.rCubicTo(f13, f35, fArr2[i5], fArr2[i17], fArr2[i18], fArr2[i19]);
                                                        f7 = fArr2[i2] + f25;
                                                        f8 = fArr2[i17] + f22;
                                                        f25 += fArr2[i18];
                                                        f3 = fArr2[i19];
                                                    }
                                                    f19 = f6;
                                                    f = f5;
                                                    f2 = f4;
                                                    i4 = i4;
                                                    so0_a = so0_a;
                                                    f18 = f25;
                                                    c3 = c3;
                                                } else {
                                                    i2 = i5;
                                                    if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                                                        f25 = (f25 * 2.0f) - f18;
                                                        f22 = (f22 * 2.0f) - f19;
                                                    }
                                                    float f36 = f25;
                                                    float f37 = f22;
                                                    int i20 = i2 + 1;
                                                    int i21 = i2 + 2;
                                                    int i22 = i2 + 3;
                                                    path.cubicTo(f36, f37, fArr2[i2], fArr2[i20], fArr2[i21], fArr2[i22]);
                                                    f18 = fArr2[i2];
                                                    f19 = fArr2[i20];
                                                    f25 = fArr2[i21];
                                                    f22 = fArr2[i22];
                                                }
                                                f24 = f22;
                                                f25 = f23;
                                            } else {
                                                i2 = i5;
                                                int i23 = i2 + 1;
                                                path.lineTo(fArr2[i2], fArr2[i23]);
                                                f10 = fArr2[i2];
                                                f11 = fArr2[i23];
                                            }
                                            f25 = f10;
                                            f22 = f11;
                                        } else {
                                            i2 = i5;
                                            path.rLineTo(0.0f, fArr2[i2]);
                                            f9 = fArr2[i2];
                                        }
                                        f22 += f9;
                                    } else {
                                        i2 = i5;
                                        int i24 = i2 + 1;
                                        int i25 = i2 + 2;
                                        int i26 = i2 + 3;
                                        path.rQuadTo(fArr2[i2], fArr2[i24], fArr2[i25], fArr2[i26]);
                                        f7 = fArr2[i2] + f25;
                                        f8 = fArr2[i24] + f22;
                                        f25 += fArr2[i25];
                                        f3 = fArr2[i26];
                                    }
                                    f18 = f7;
                                    f19 = f8;
                                } else {
                                    i2 = i5;
                                    path.rLineTo(fArr2[i2], 0.0f);
                                    f25 += fArr2[i2];
                                }
                                f6 = f19;
                                f5 = f25;
                                f4 = f22;
                                f25 = f18;
                                f19 = f6;
                                f = f5;
                                f2 = f4;
                                i4 = i4;
                                so0_a = so0_a;
                                f18 = f25;
                                c3 = c3;
                            } else {
                                i2 = i5;
                                int i27 = i2 + 2;
                                int i28 = i2 + 3;
                                int i29 = i2 + 4;
                                int i30 = i2 + 5;
                                path.rCubicTo(fArr2[i2], fArr2[i2 + 1], fArr2[i27], fArr2[i28], fArr2[i29], fArr2[i30]);
                                float f38 = fArr2[i27] + f25;
                                float f39 = fArr2[i28] + f22;
                                f25 += fArr2[i29];
                                f3 = fArr2[i30];
                                f18 = f38;
                                f19 = f39;
                            }
                            f22 += f3;
                            f6 = f19;
                            f5 = f25;
                            f4 = f22;
                            f25 = f18;
                            f19 = f6;
                            f = f5;
                            f2 = f4;
                            i4 = i4;
                            so0_a = so0_a;
                            f18 = f25;
                            c3 = c3;
                        } else {
                            i2 = i5;
                            int i31 = i2 + 5;
                            int i32 = i2 + 6;
                            float f40 = f25;
                            float f41 = f22;
                            a(path, f40, f41, fArr2[i31] + f25, fArr2[i32] + f22, fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f ? 1 : i6, fArr2[i2 + 4] != 0.0f ? 1 : i6);
                            f = f40 + fArr2[i31];
                            f2 = f41 + fArr2[i32];
                        }
                        int i33 = i2 + i;
                        so0_a = so0_a;
                        c3 = c3;
                        i4 = i4;
                        i3 = i6;
                        c = 'm';
                        f25 = f;
                        f22 = f2;
                        c2 = c3;
                        i5 = i33;
                        path = path;
                    } else {
                        i2 = i5;
                        int i34 = i2 + 5;
                        int i35 = i2 + 6;
                        a(path, f25, f22, fArr2[i34], fArr2[i35], fArr2[i2], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f ? 1 : i6, fArr2[i2 + 4] != 0.0f ? 1 : i6);
                        f = fArr2[i34];
                        f2 = fArr2[i35];
                    }
                    f18 = f;
                    f19 = f2;
                    int i36 = i2 + i;
                    so0_a = so0_a;
                    c3 = c3;
                    i4 = i4;
                    i3 = i6;
                    c = 'm';
                    f25 = f;
                    f22 = f2;
                    c2 = c3;
                    i5 = i36;
                    path = path;
                }
            }
            fArr[i3] = f25;
            fArr[1] = f22;
            fArr[2] = f18;
            fArr[3] = f19;
            fArr[4] = f23;
            fArr[5] = f24;
            c2 = so0_a.a;
            i4++;
            so0_aArr2 = so0_aArr;
            c = 'm';
        }
    }
}
