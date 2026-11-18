package com.google.zxing.qrcode.decoder;

import defpackage.ha;
import defpackage.hk0;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Version {
    public static final Version[] VERSIONS;
    public static final int[] VERSION_DECODE_INFO = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    public final int[] alignmentPatternCenters;
    public final ha[] ecBlocks;
    public final int totalCodewords;
    public final int versionNumber;

    static {
        int i = 2;
        int i2 = 10;
        Version version = new Version(1, new int[0], new ha(7, new hk0[]{new hk0(1, 19)}, i), new ha(i2, new hk0[]{new hk0(1, 16)}, i), new ha(13, new hk0[]{new hk0(1, 13)}, i), new ha(17, new hk0[]{new hk0(1, 9)}, i));
        int i3 = 22;
        Version version2 = new Version(2, new int[]{6, 18}, new ha(i2, new hk0[]{new hk0(1, 34)}, i), new ha(16, new hk0[]{new hk0(1, 28)}, i), new ha(i3, new hk0[]{new hk0(1, 22)}, i), new ha(28, new hk0[]{new hk0(1, 16)}, i));
        int i4 = 26;
        int i5 = 18;
        Version version3 = new Version(3, new int[]{6, 22}, new ha(15, new hk0[]{new hk0(1, 55)}, i), new ha(i4, new hk0[]{new hk0(1, 44)}, i), new ha(i5, new hk0[]{new hk0(2, 17)}, i), new ha(i3, new hk0[]{new hk0(2, 13)}, i));
        Version version4 = new Version(4, new int[]{6, 26}, new ha(20, new hk0[]{new hk0(1, 80)}, i), new ha(i5, new hk0[]{new hk0(2, 32)}, i), new ha(i4, new hk0[]{new hk0(2, 24)}, i), new ha(16, new hk0[]{new hk0(4, 9)}, i));
        Version version5 = new Version(5, new int[]{6, 30}, new ha(i4, new hk0[]{new hk0(1, 108)}, i), new ha(24, new hk0[]{new hk0(2, 43)}, i), new ha(18, new hk0[]{new hk0(2, 15), new hk0(2, 16)}, i), new ha(22, new hk0[]{new hk0(2, 11), new hk0(2, 12)}, i));
        Version version6 = new Version(6, new int[]{6, 34}, new ha(18, new hk0[]{new hk0(2, 68)}, i), new ha(16, new hk0[]{new hk0(4, 27)}, i), new ha(24, new hk0[]{new hk0(4, 19)}, i), new ha(28, new hk0[]{new hk0(4, 15)}, i));
        Version version7 = new Version(7, new int[]{6, 22, 38}, new ha(20, new hk0[]{new hk0(2, 78)}, i), new ha(18, new hk0[]{new hk0(4, 31)}, i), new ha(18, new hk0[]{new hk0(2, 14), new hk0(4, 15)}, i), new ha(26, new hk0[]{new hk0(4, 13), new hk0(1, 14)}, i));
        int i6 = 22;
        Version version8 = new Version(8, new int[]{6, 24, 42}, new ha(24, new hk0[]{new hk0(2, 97)}, i), new ha(i6, new hk0[]{new hk0(2, 38), new hk0(2, 39)}, i), new ha(i6, new hk0[]{new hk0(4, 18), new hk0(2, 19)}, i), new ha(26, new hk0[]{new hk0(4, 14), new hk0(2, 15)}, i));
        Version version9 = new Version(9, new int[]{6, 26, 46}, new ha(30, new hk0[]{new hk0(2, 116)}, i), new ha(22, new hk0[]{new hk0(3, 36), new hk0(2, 37)}, i), new ha(20, new hk0[]{new hk0(4, 16), new hk0(4, 17)}, i), new ha(24, new hk0[]{new hk0(4, 12), new hk0(4, 13)}, i));
        Version version10 = new Version(10, new int[]{6, 28, 50}, new ha(18, new hk0[]{new hk0(2, 68), new hk0(2, 69)}, i), new ha(26, new hk0[]{new hk0(4, 43), new hk0(1, 44)}, i), new ha(24, new hk0[]{new hk0(6, 19), new hk0(2, 20)}, i), new ha(28, new hk0[]{new hk0(6, 15), new hk0(2, 16)}, i));
        Version version11 = new Version(11, new int[]{6, 30, 54}, new ha(20, new hk0[]{new hk0(4, 81)}, i), new ha(30, new hk0[]{new hk0(1, 50), new hk0(4, 51)}, i), new ha(28, new hk0[]{new hk0(4, 22), new hk0(4, 23)}, i), new ha(24, new hk0[]{new hk0(3, 12), new hk0(8, 13)}, i));
        Version version12 = new Version(12, new int[]{6, 32, 58}, new ha(24, new hk0[]{new hk0(2, 92), new hk0(2, 93)}, i), new ha(22, new hk0[]{new hk0(6, 36), new hk0(2, 37)}, i), new ha(26, new hk0[]{new hk0(4, 20), new hk0(6, 21)}, i), new ha(28, new hk0[]{new hk0(7, 14), new hk0(4, 15)}, i));
        Version version13 = new Version(13, new int[]{6, 34, 62}, new ha(26, new hk0[]{new hk0(4, 107)}, i), new ha(22, new hk0[]{new hk0(8, 37), new hk0(1, 38)}, i), new ha(24, new hk0[]{new hk0(8, 20), new hk0(4, 21)}, i), new ha(22, new hk0[]{new hk0(12, 11), new hk0(4, 12)}, 2));
        int i7 = 2;
        Version version14 = new Version(14, new int[]{6, 26, 46, 66}, new ha(30, new hk0[]{new hk0(3, 115), new hk0(1, 116)}, i7), new ha(24, new hk0[]{new hk0(4, 40), new hk0(5, 41)}, i7), new ha(20, new hk0[]{new hk0(11, 16), new hk0(5, 17)}, 2), new ha(24, new hk0[]{new hk0(11, 12), new hk0(5, 13)}, 2));
        int i8 = 2;
        Version version15 = new Version(15, new int[]{6, 26, 48, 70}, new ha(22, new hk0[]{new hk0(5, 87), new hk0(1, 88)}, i8), new ha(24, new hk0[]{new hk0(5, 41), new hk0(5, 42)}, i8), new ha(30, new hk0[]{new hk0(5, 24), new hk0(7, 25)}, i8), new ha(24, new hk0[]{new hk0(11, 12), new hk0(7, 13)}, 2));
        int i9 = 2;
        Version version16 = new Version(16, new int[]{6, 26, 50, 74}, new ha(24, new hk0[]{new hk0(5, 98), new hk0(1, 99)}, i9), new ha(28, new hk0[]{new hk0(7, 45), new hk0(3, 46)}, i9), new ha(24, new hk0[]{new hk0(15, 19), new hk0(2, 20)}, i9), new ha(30, new hk0[]{new hk0(3, 15), new hk0(13, 16)}, 2));
        int i10 = 2;
        Version version17 = new Version(17, new int[]{6, 30, 54, 78}, new ha(28, new hk0[]{new hk0(1, 107), new hk0(5, 108)}, i10), new ha(28, new hk0[]{new hk0(10, 46), new hk0(1, 47)}, i10), new ha(28, new hk0[]{new hk0(1, 22), new hk0(15, 23)}, i10), new ha(28, new hk0[]{new hk0(2, 14), new hk0(17, 15)}, i10));
        int i11 = 2;
        Version version18 = new Version(18, new int[]{6, 30, 56, 82}, new ha(30, new hk0[]{new hk0(5, 120), new hk0(1, 121)}, i11), new ha(26, new hk0[]{new hk0(9, 43), new hk0(4, 44)}, i11), new ha(28, new hk0[]{new hk0(17, 22), new hk0(1, 23)}, i11), new ha(28, new hk0[]{new hk0(2, 14), new hk0(19, 15)}, i11));
        int i12 = 2;
        Version version19 = new Version(19, new int[]{6, 30, 58, 86}, new ha(28, new hk0[]{new hk0(3, 113), new hk0(4, 114)}, i12), new ha(26, new hk0[]{new hk0(3, 44), new hk0(11, 45)}, i12), new ha(26, new hk0[]{new hk0(17, 21), new hk0(4, 22)}, i12), new ha(26, new hk0[]{new hk0(9, 13), new hk0(16, 14)}, i12));
        int i13 = 2;
        Version version20 = new Version(20, new int[]{6, 34, 62, 90}, new ha(28, new hk0[]{new hk0(3, 107), new hk0(5, 108)}, i13), new ha(26, new hk0[]{new hk0(3, 41), new hk0(13, 42)}, i13), new ha(30, new hk0[]{new hk0(15, 24), new hk0(5, 25)}, i13), new ha(28, new hk0[]{new hk0(15, 15), new hk0(10, 16)}, i13));
        int i14 = 2;
        int i15 = 2;
        Version version21 = new Version(21, new int[]{6, 28, 50, 72, 94}, new ha(28, new hk0[]{new hk0(4, 116), new hk0(4, 117)}, i14), new ha(26, new hk0[]{new hk0(17, 42)}, i14), new ha(28, new hk0[]{new hk0(17, 22), new hk0(6, 23)}, i14), new ha(30, new hk0[]{new hk0(19, 16), new hk0(6, 17)}, i15));
        int i16 = 28;
        ha haVar = new ha(i16, new hk0[]{new hk0(2, 111), new hk0(7, 112)}, i15);
        int i17 = 2;
        Version version22 = new Version(22, new int[]{6, 26, 50, 74, 98}, haVar, new ha(i16, new hk0[]{new hk0(17, 46)}, i17), new ha(30, new hk0[]{new hk0(7, 24), new hk0(16, 25)}, i17), new ha(24, new hk0[]{new hk0(34, 13)}, i17));
        int i18 = 2;
        Version version23 = new Version(23, new int[]{6, 30, 54, 78, 102}, new ha(30, new hk0[]{new hk0(4, 121), new hk0(5, 122)}, i18), new ha(28, new hk0[]{new hk0(4, 47), new hk0(14, 48)}, i18), new ha(30, new hk0[]{new hk0(11, 24), new hk0(14, 25)}, 2), new ha(30, new hk0[]{new hk0(16, 15), new hk0(14, 16)}, 2));
        int i19 = 2;
        Version version24 = new Version(24, new int[]{6, 28, 54, 80, 106}, new ha(30, new hk0[]{new hk0(6, 117), new hk0(4, 118)}, i19), new ha(28, new hk0[]{new hk0(6, 45), new hk0(14, 46)}, i19), new ha(30, new hk0[]{new hk0(11, 24), new hk0(16, 25)}, i19), new ha(30, new hk0[]{new hk0(30, 16), new hk0(2, 17)}, i19));
        int i20 = 2;
        Version version25 = new Version(25, new int[]{6, 32, 58, 84, 110}, new ha(26, new hk0[]{new hk0(8, 106), new hk0(4, 107)}, i20), new ha(28, new hk0[]{new hk0(8, 47), new hk0(13, 48)}, i20), new ha(30, new hk0[]{new hk0(7, 24), new hk0(22, 25)}, i20), new ha(30, new hk0[]{new hk0(22, 15), new hk0(13, 16)}, i20));
        int i21 = 28;
        Version version26 = new Version(26, new int[]{6, 30, 58, 86, 114}, new ha(i21, new hk0[]{new hk0(10, 114), new hk0(2, 115)}, i20), new ha(i21, new hk0[]{new hk0(19, 46), new hk0(4, 47)}, i20), new ha(28, new hk0[]{new hk0(28, 22), new hk0(6, 23)}, i20), new ha(30, new hk0[]{new hk0(33, 16), new hk0(4, 17)}, i20));
        int i22 = 2;
        Version version27 = new Version(27, new int[]{6, 34, 62, 90, 118}, new ha(30, new hk0[]{new hk0(8, 122), new hk0(4, 123)}, i22), new ha(28, new hk0[]{new hk0(22, 45), new hk0(3, 46)}, i22), new ha(30, new hk0[]{new hk0(8, 23), new hk0(26, 24)}, i22), new ha(30, new hk0[]{new hk0(12, 15), new hk0(28, 16)}, i22));
        int i23 = 2;
        Version version28 = new Version(28, new int[]{6, 26, 50, 74, 98, 122}, new ha(30, new hk0[]{new hk0(3, 117), new hk0(10, 118)}, i23), new ha(28, new hk0[]{new hk0(3, 45), new hk0(23, 46)}, i23), new ha(30, new hk0[]{new hk0(4, 24), new hk0(31, 25)}, i23), new ha(30, new hk0[]{new hk0(11, 15), new hk0(31, 16)}, 2));
        int i24 = 2;
        Version version29 = new Version(29, new int[]{6, 30, 54, 78, 102, R.styleable.AppCompatTheme_windowNoTitle}, new ha(30, new hk0[]{new hk0(7, 116), new hk0(7, 117)}, i24), new ha(28, new hk0[]{new hk0(21, 45), new hk0(7, 46)}, i24), new ha(30, new hk0[]{new hk0(1, 23), new hk0(37, 24)}, i24), new ha(30, new hk0[]{new hk0(19, 15), new hk0(26, 16)}, i24));
        int i25 = 2;
        Version version30 = new Version(30, new int[]{6, 26, 52, 78, 104, 130}, new ha(30, new hk0[]{new hk0(5, 115), new hk0(10, 116)}, i25), new ha(28, new hk0[]{new hk0(19, 47), new hk0(10, 48)}, i25), new ha(30, new hk0[]{new hk0(15, 24), new hk0(25, 25)}, i25), new ha(30, new hk0[]{new hk0(23, 15), new hk0(25, 16)}, i25));
        Version version31 = new Version(31, new int[]{6, 30, 56, 82, 108, 134}, new ha(30, new hk0[]{new hk0(13, 115), new hk0(3, 116)}, i25), new ha(28, new hk0[]{new hk0(2, 46), new hk0(29, 47)}, i25), new ha(30, new hk0[]{new hk0(42, 24), new hk0(1, 25)}, i25), new ha(30, new hk0[]{new hk0(23, 15), new hk0(28, 16)}, i25));
        ha haVar2 = new ha(30, new hk0[]{new hk0(17, 115)}, i25);
        ha haVar3 = new ha(28, new hk0[]{new hk0(10, 46), new hk0(23, 47)}, i25);
        ha haVar4 = new ha(30, new hk0[]{new hk0(10, 24), new hk0(35, 25)}, i25);
        int i26 = 2;
        Version version32 = new Version(32, new int[]{6, 34, 60, 86, 112, 138}, haVar2, haVar3, haVar4, new ha(30, new hk0[]{new hk0(19, 15), new hk0(35, 16)}, i26));
        Version version33 = new Version(33, new int[]{6, 30, 58, 86, 114, 142}, new ha(30, new hk0[]{new hk0(17, 115), new hk0(1, 116)}, i26), new ha(28, new hk0[]{new hk0(14, 46), new hk0(21, 47)}, i26), new ha(30, new hk0[]{new hk0(29, 24), new hk0(19, 25)}, i26), new ha(30, new hk0[]{new hk0(11, 15), new hk0(46, 16)}, i26));
        int i27 = 2;
        Version version34 = new Version(34, new int[]{6, 34, 62, 90, 118, 146}, new ha(30, new hk0[]{new hk0(13, 115), new hk0(6, 116)}, i27), new ha(28, new hk0[]{new hk0(14, 46), new hk0(23, 47)}, i27), new ha(30, new hk0[]{new hk0(44, 24), new hk0(7, 25)}, i27), new ha(30, new hk0[]{new hk0(59, 16), new hk0(1, 17)}, i27));
        int i28 = 2;
        Version version35 = new Version(35, new int[]{6, 30, 54, 78, 102, R.styleable.AppCompatTheme_windowNoTitle, 150}, new ha(30, new hk0[]{new hk0(12, 121), new hk0(7, 122)}, i28), new ha(28, new hk0[]{new hk0(12, 47), new hk0(26, 48)}, i28), new ha(30, new hk0[]{new hk0(39, 24), new hk0(14, 25)}, i28), new ha(30, new hk0[]{new hk0(22, 15), new hk0(41, 16)}, i28));
        int i29 = 2;
        Version version36 = new Version(36, new int[]{6, 24, 50, 76, 102, 128, 154}, new ha(30, new hk0[]{new hk0(6, 121), new hk0(14, 122)}, i29), new ha(28, new hk0[]{new hk0(6, 47), new hk0(34, 48)}, i29), new ha(30, new hk0[]{new hk0(46, 24), new hk0(10, 25)}, i29), new ha(30, new hk0[]{new hk0(2, 15), new hk0(64, 16)}, i29));
        int i30 = 2;
        Version version37 = new Version(37, new int[]{6, 28, 54, 80, 106, 132, 158}, new ha(30, new hk0[]{new hk0(17, 122), new hk0(4, 123)}, i30), new ha(28, new hk0[]{new hk0(29, 46), new hk0(14, 47)}, i30), new ha(30, new hk0[]{new hk0(49, 24), new hk0(10, 25)}, i30), new ha(30, new hk0[]{new hk0(24, 15), new hk0(46, 16)}, i30));
        int i31 = 2;
        Version version38 = new Version(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new ha(30, new hk0[]{new hk0(4, 122), new hk0(18, 123)}, i31), new ha(28, new hk0[]{new hk0(13, 46), new hk0(32, 47)}, i31), new ha(30, new hk0[]{new hk0(48, 24), new hk0(14, 25)}, i31), new ha(30, new hk0[]{new hk0(42, 15), new hk0(32, 16)}, i31));
        int i32 = 2;
        Version version39 = new Version(39, new int[]{6, 26, 54, 82, 110, 138, 166}, new ha(30, new hk0[]{new hk0(20, 117), new hk0(4, 118)}, i32), new ha(28, new hk0[]{new hk0(40, 47), new hk0(7, 48)}, i32), new ha(30, new hk0[]{new hk0(43, 24), new hk0(22, 25)}, i32), new ha(30, new hk0[]{new hk0(10, 15), new hk0(67, 16)}, i32));
        int i33 = 2;
        VERSIONS = new Version[]{version, version2, version3, version4, version5, version6, version7, version8, version9, version10, version11, version12, version13, version14, version15, version16, version17, version18, version19, version20, version21, version22, version23, version24, version25, version26, version27, version28, version29, version30, version31, version32, version33, version34, version35, version36, version37, version38, version39, new Version(40, new int[]{6, 30, 58, 86, 114, 142, 170}, new ha(30, new hk0[]{new hk0(19, 118), new hk0(6, 119)}, i33), new ha(28, new hk0[]{new hk0(18, 47), new hk0(31, 48)}, i33), new ha(30, new hk0[]{new hk0(34, 24), new hk0(34, 25)}, i33), new ha(30, new hk0[]{new hk0(20, 15), new hk0(61, 16)}, i33))};
    }

    public Version(int i, int[] iArr, ha... haVarArr) {
        this.versionNumber = i;
        this.alignmentPatternCenters = iArr;
        this.ecBlocks = haVarArr;
        ha haVar = haVarArr[0];
        int i2 = haVar.b;
        int i3 = 0;
        for (hk0 hk0Var : (hk0[]) haVar.a) {
            i3 += (hk0Var.b + i2) * hk0Var.a;
        }
        this.totalCodewords = i3;
    }

    public static Version decodeVersionInformation(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        for (int i4 = 0; i4 < 34; i4++) {
            int i5 = VERSION_DECODE_INFO[i4];
            if (i5 == i) {
                return getVersionForNumber(i4 + 7);
            }
            int iBitCount = Integer.bitCount(i5 ^ i);
            if (iBitCount < i2) {
                i3 = i4 + 7;
                i2 = iBitCount;
            }
        }
        if (i2 <= 3) {
            return getVersionForNumber(i3);
        }
        return null;
    }

    public static Version getVersionForNumber(int i) {
        if (i <= 0 || i > 40) {
            throw new IllegalArgumentException();
        }
        return VERSIONS[i - 1];
    }

    public final String toString() {
        return String.valueOf(this.versionNumber);
    }
}
