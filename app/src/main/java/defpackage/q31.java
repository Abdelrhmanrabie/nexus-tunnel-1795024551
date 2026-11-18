package defpackage;

import com.trilead.ssh2.sftp.AttribFlags;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class q31 extends j31 {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static final CharSequence C0(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zL = e.l(str.charAt(!z ? i : length));
            if (z) {
                if (!zL) {
                    break;
                }
                length--;
            } else if (zL) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1);
    }

    public static final String D0(int i, String str) {
        if (i < 0) {
            d.AnonymousClass0.m((Object) e.i(i, "Requested character count ", " is less than zero."));
            return null;
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(i);
    }

    public static final Integer U(String str) {
        byte b;
        boolean z;
        int i;
        e.c(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        int i3 = 1;
        if (cCharAt < '0') {
            b = -1;
        } else {
            b = cCharAt == '0' ? (byte) 0 : (byte) 1;
        }
        int i4 = -2147483647;
        if (b >= 0) {
            z = false;
            i3 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i4 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                z = true;
            }
        }
        int i5 = -59652323;
        while (i3 < length) {
            int iDigit = Character.digit((int) str.charAt(i3), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i2 < i5 && (i5 != -59652323 || i2 < (i5 = i4 / 10))) || (i = i2 * 10) < i4 + iDigit) {
                return null;
            }
            i2 = i - iDigit;
            i3++;
        }
        return z ? Integer.valueOf(i2) : Integer.valueOf(-i2);
    }

    public static final Long V(String str) {
        byte b;
        e.c(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i = 0;
        char cCharAt = str.charAt(0);
        boolean z = true;
        if (cCharAt < '0') {
            b = -1;
        } else {
            b = cCharAt == '0' ? (byte) 0 : (byte) 1;
        }
        long j = -9223372036854775807L;
        if (b >= 0) {
            z = false;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
                i = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j = Long.MIN_VALUE;
                i = 1;
            }
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 != j2) {
                    return null;
                }
                j4 = j / ((long) 10);
                if (j3 < j4) {
                    return null;
                }
            }
            long j5 = j3 * ((long) 10);
            long j6 = iDigit;
            if (j5 < j + j6) {
                return null;
            }
            j3 = j5 - j6;
            i++;
            j2 = -256204778801521550L;
        }
        return z ? Long.valueOf(j3) : Long.valueOf(-j3);
    }

    public static final boolean X(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static final String Z(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        }
        if (i == 0) {
            return AppConfig.CUSTOM;
        }
        int i2 = 1;
        if (i == 1) {
            return str.toString();
        }
        int length = str.length();
        if (length == 0) {
            return AppConfig.CUSTOM;
        }
        if (length != 1) {
            StringBuilder sb = new StringBuilder(str.length() * i);
            if (1 <= i) {
                while (true) {
                    sb.append((CharSequence) str);
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
            return sb.toString();
        }
        char cCharAt = str.charAt(0);
        char[] cArr = new char[i];
        for (int i3 = 0; i3 < i; i3++) {
            cArr[i3] = cCharAt;
        }
        return new String(cArr);
    }

    public static String b0(String str, String str2, String str3) {
        int iH0 = h0(0, str, str2, false);
        if (iH0 < 0) {
            return str;
        }
        int length = str2.length();
        int i = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i2 = 0;
        do {
            sb.append((CharSequence) str, i2, iH0);
            sb.append(str3);
            i2 = iH0 + length;
            if (iH0 >= str.length()) {
                break;
            }
            iH0 = h0(iH0 + i, str, str2, false);
        } while (iH0 > 0);
        sb.append((CharSequence) str, i2, str.length());
        return sb.toString();
    }

    public static boolean d0(String str, char c) {
        return j0(str, c, 0, 2) >= 0;
    }

    public static boolean e0(String str, String str2) {
        return k0(str, str2, 0, 2) >= 0;
    }

    public static boolean f0(String str, char c) {
        return str.length() > 0 && e.h(str.charAt(str.length() + (-1)), c, false);
    }

    public static final int g0(CharSequence charSequence) {
        return charSequence.length() - 1;
    }

    public static final int h0(int i, CharSequence charSequence, String str, boolean z) {
        return (z || !(charSequence instanceof String)) ? i0(charSequence, str, i, charSequence.length(), z, false) : ((String) charSequence).indexOf(str, i);
    }

    public static final int i0(CharSequence charSequence, String str, int i, int i2, boolean z, boolean z2) {
        w20 w20Var;
        String str2;
        boolean z3;
        boolean zRegionMatches;
        if (z2) {
            int iG0 = g0(charSequence);
            if (i > iG0) {
                i = iG0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            w20Var = new w20(i, i2, -1);
        } else {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence.length();
            if (i2 > length) {
                i2 = length;
            }
            w20Var = new y20(i, i2, 1);
        }
        boolean z4 = charSequence instanceof String;
        int i3 = w20Var.b;
        int i4 = w20Var.d;
        int i5 = w20Var.c;
        if (z4 && fb$1.m(str)) {
            if ((i4 > 0 && i3 <= i5) || (i4 < 0 && i5 <= i3)) {
                int i6 = i3;
                while (true) {
                    String str3 = (String) charSequence;
                    int length2 = str.length();
                    if (z) {
                        str2 = str;
                        z3 = z;
                        zRegionMatches = str2.regionMatches(z3, 0, str3, i6, length2);
                    } else {
                        zRegionMatches = str.regionMatches(0, str3, i6, length2);
                        str2 = str;
                        z3 = z;
                    }
                    if (!zRegionMatches) {
                        if (i6 == i5) {
                            break;
                        }
                        i6 += i4;
                        str = str2;
                        z = z3;
                    } else {
                        return i6;
                    }
                }
            }
        } else if ((i4 > 0 && i3 <= i5) || (i4 < 0 && i5 <= i3)) {
            while (!o0(str, z, charSequence, i3, str.length())) {
                if (i3 != i5) {
                    i3 += i4;
                }
            }
            return i3;
        }
        return -1;
    }

    public static int j0(CharSequence charSequence, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return !(charSequence instanceof String) ? l0(i, charSequence, false, new char[]{c}) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int k0(CharSequence charSequence, String str, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return h0(i, charSequence, str, false);
    }

    public static final int l0(int i, CharSequence charSequence, boolean z, char[] cArr) {
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length == 1) {
                return ((String) charSequence).indexOf(cArr[0], i);
            }
            d.AnonymousClass0.m$2("Array has more than one element.");
            return 0;
        }
        if (i < 0) {
            i = 0;
        }
        int iG0 = g0(charSequence);
        if (i > iG0) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i);
            for (char c : cArr) {
                if (e.h(c, cCharAt, z)) {
                    return i;
                }
            }
            if (i == iG0) {
                return -1;
            }
            i++;
        }
    }

    public static final boolean m0(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!e.l(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int n0(String str, String str2) {
        int iG0 = g0(str);
        return !fb$1.m(str) ? i0(str, str2, iG0, 0, false, true) : str.lastIndexOf(str2, iG0);
    }

    public static final boolean o0(CharSequence charSequence, boolean z, CharSequence charSequence2, int i, int i2) {
        if (i >= 0 && charSequence.length() - i2 >= 0 && i <= charSequence2.length() - i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (e.h(charSequence.charAt(i3), charSequence2.charAt(i + i3), z)) {
                }
            }
            return true;
        }
        return false;
    }

    public static final String p0(String str, String str2) {
        return fb$1.m(str2) ? str2.startsWith(str) : o0(str2, false, str, 0, str.length()) ? str2.substring(str.length()) : str2;
    }

    public static final void q0(int i) {
        if (i >= 0) {
            return;
        }
        d.AnonymousClass0.m((Object) ak.h(i, "Limit must be non-negative, but was "));
    }

    public static final List r0(int i, CharSequence charSequence, String str) {
        q0(i);
        int iH0 = h0(0, charSequence, str, false);
        if (iH0 != -1) {
            if (i != 1) {
                boolean z = i > 0;
                int i2 = 10;
                if (z && i <= 10) {
                    i2 = i;
                }
                ArrayList arrayList = new ArrayList(i2);
                int length = 0;
                do {
                    arrayList.add(charSequence.subSequence(length, iH0).toString());
                    length = str.length() + iH0;
                    if (z && arrayList.size() == i - 1) {
                        break;
                    }
                    iH0 = h0(length, charSequence, str, false);
                } while (iH0 != -1);
                arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
                return arrayList;
            }
        }
        return Collections.singletonList(charSequence.toString());
    }

    public static List s0(String str, String[] strArr, int i) {
        int i2 = (i & 4) != 0 ? 0 : 2;
        if (strArr.length == 1) {
            String str2 = strArr[0];
            if (str2.length() != 0) {
                return r0(i2, str, str2);
            }
        }
        q0(i2);
        et etVar = new et(str, i2, new fi0(Arrays.asList(strArr)));
        ArrayList arrayList = new ArrayList(ae.y0(new l7(3, etVar)));
        wl$a wl_a = new wl$a(etVar);
        while (wl_a.hasNext()) {
            y20 y20Var = (y20) wl_a.next();
            arrayList.add(str.subSequence(y20Var.b, y20Var.c + 1).toString());
        }
        return arrayList;
    }

    public static List t0(String str, char[] cArr) {
        if (cArr.length == 1) {
            return r0(0, str, String.valueOf(cArr[0]));
        }
        q0(0);
        et etVar = new et(str, 0, new bj(23, cArr));
        ArrayList arrayList = new ArrayList(ae.y0(new l7(3, etVar)));
        wl$a wl_a = new wl$a(etVar);
        while (wl_a.hasNext()) {
            y20 y20Var = (y20) wl_a.next();
            arrayList.add(str.subSequence(y20Var.b, y20Var.c + 1).toString());
        }
        return arrayList;
    }

    public static final String w0(String str, String str2, String str3) {
        int iK0 = k0(str, str2, 0, 6);
        return iK0 == -1 ? str3 : str.substring(str2.length() + iK0, str.length());
    }

    public static String y0(String str, char c) {
        int iLastIndexOf = str.lastIndexOf(c, g0(str));
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1, str.length());
    }
}
