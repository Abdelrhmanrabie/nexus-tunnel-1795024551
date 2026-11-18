package defpackage;

import com.jcraft.jzlib.GZIPHeader;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class z8 {
    static {
        String property;
        try {
            property = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            property = null;
        }
        "true".equals(property);
    }

    public static byte[] b(String[] strArr) {
        int i;
        if (strArr == null) {
            ak.AnonymousClass1.m("Argument for @NotNull parameter 'data' of kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding.decodeBytes must not be null");
            return null;
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char cCharAt = strArr[0].charAt(0);
            if (cCharAt == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                strArr2[0] = strArr2[0].substring(1);
                int length = strArr2.length;
                int i2 = 0;
                int length2 = 0;
                while (i2 < length) {
                    String str = strArr2[i2];
                    i2++;
                    length2 += str.length();
                }
                byte[] bArr = new byte[length2];
                int length3 = strArr2.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length3) {
                    String str2 = strArr2[i3];
                    i3++;
                    int length4 = str2.length() - 1;
                    if (length4 >= 0) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5 + 1;
                            i = i4 + 1;
                            bArr[i4] = (byte) str2.charAt(i5);
                            if (i5 == length4) {
                                break;
                            }
                            i5 = i6;
                            i4 = i;
                        }
                        i4 = i;
                    }
                }
                return bArr;
            }
            if (cCharAt == 65535) {
                strArr = (String[]) strArr.clone();
                strArr[0] = strArr[0].substring(1);
            }
        }
        int length5 = 0;
        for (String str3 : strArr) {
            length5 += str3.length();
        }
        byte[] bArr2 = new byte[length5];
        int i7 = 0;
        for (String str4 : strArr) {
            int length6 = str4.length();
            int i8 = 0;
            while (i8 < length6) {
                bArr2[i7] = (byte) str4.charAt(i8);
                i8++;
                i7++;
            }
        }
        for (int i9 = 0; i9 < length5; i9++) {
            bArr2[i9] = (byte) ((bArr2[i9] + 127) & 127);
        }
        int i10 = (length5 * 7) / 8;
        byte[] bArr3 = new byte[i10];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = i11 + 1;
            int i15 = i12 + 1;
            bArr3[i13] = (byte) (((bArr2[i11] & GZIPHeader.OS_UNKNOWN) >>> i12) + ((bArr2[i14] & ((1 << i15) - 1)) << (7 - i12)));
            if (i12 == 6) {
                i11 += 2;
                i12 = 0;
            } else {
                i11 = i14;
                i12 = i15;
            }
        }
        return bArr3;
    }
}
