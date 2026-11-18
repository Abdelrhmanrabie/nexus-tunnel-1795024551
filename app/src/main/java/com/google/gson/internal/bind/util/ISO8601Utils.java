package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder((z ? 4 : 0) + 19 + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int iAbs = Math.abs(i / 60);
            int iAbs2 = Math.abs(i % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, iAbs, 2);
            sb.append(':');
            padInt(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String string = Integer.toString(i);
        for (int length = i2 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00eb A[Catch: IllegalArgumentException -> 0x0056, NumberFormatException -> 0x0059, IndexOutOfBoundsException -> 0x005c, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:23:0x0065, B:25:0x0075, B:26:0x0077, B:28:0x0083, B:29:0x0086, B:31:0x008c, B:35:0x0096, B:40:0x00a6, B:42:0x00ae, B:54:0x00e5, B:56:0x00eb, B:58:0x00f1, B:84:0x0182, B:64:0x0102, B:65:0x0118, B:66:0x0119, B:70:0x0129, B:72:0x0136, B:75:0x013f, B:77:0x0151, B:80:0x0160, B:81:0x017d, B:83:0x0180, B:69:0x0125, B:86:0x01b4, B:87:0x01bb, B:47:0x00c8, B:48:0x00cb), top: B:98:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f1 A[Catch: IllegalArgumentException -> 0x0056, NumberFormatException -> 0x0059, IndexOutOfBoundsException -> 0x005c, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:23:0x0065, B:25:0x0075, B:26:0x0077, B:28:0x0083, B:29:0x0086, B:31:0x008c, B:35:0x0096, B:40:0x00a6, B:42:0x00ae, B:54:0x00e5, B:56:0x00eb, B:58:0x00f1, B:84:0x0182, B:64:0x0102, B:65:0x0118, B:66:0x0119, B:70:0x0129, B:72:0x0136, B:75:0x013f, B:77:0x0151, B:80:0x0160, B:81:0x017d, B:83:0x0180, B:69:0x0125, B:86:0x01b4, B:87:0x01bb, B:47:0x00c8, B:48:0x00cb), top: B:98:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:68:0x0124  */
    /* JADX WARN: Code duplicated, block: B:69:0x0125 A[Catch: IllegalArgumentException -> 0x0056, NumberFormatException -> 0x0059, IndexOutOfBoundsException -> 0x005c, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:23:0x0065, B:25:0x0075, B:26:0x0077, B:28:0x0083, B:29:0x0086, B:31:0x008c, B:35:0x0096, B:40:0x00a6, B:42:0x00ae, B:54:0x00e5, B:56:0x00eb, B:58:0x00f1, B:84:0x0182, B:64:0x0102, B:65:0x0118, B:66:0x0119, B:70:0x0129, B:72:0x0136, B:75:0x013f, B:77:0x0151, B:80:0x0160, B:81:0x017d, B:83:0x0180, B:69:0x0125, B:86:0x01b4, B:87:0x01bb, B:47:0x00c8, B:48:0x00cb), top: B:98:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0180 A[Catch: IllegalArgumentException -> 0x0056, NumberFormatException -> 0x0059, IndexOutOfBoundsException -> 0x005c, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:23:0x0065, B:25:0x0075, B:26:0x0077, B:28:0x0083, B:29:0x0086, B:31:0x008c, B:35:0x0096, B:40:0x00a6, B:42:0x00ae, B:54:0x00e5, B:56:0x00eb, B:58:0x00f1, B:84:0x0182, B:64:0x0102, B:65:0x0118, B:66:0x0119, B:70:0x0129, B:72:0x0136, B:75:0x013f, B:77:0x0151, B:80:0x0160, B:81:0x017d, B:83:0x0180, B:69:0x0125, B:86:0x01b4, B:87:0x01bb, B:47:0x00c8, B:48:0x00cb), top: B:98:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01b4 A[Catch: IllegalArgumentException -> 0x0056, NumberFormatException -> 0x0059, IndexOutOfBoundsException -> 0x005c, TryCatch #2 {IllegalArgumentException -> 0x0056, IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0059, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:23:0x0065, B:25:0x0075, B:26:0x0077, B:28:0x0083, B:29:0x0086, B:31:0x008c, B:35:0x0096, B:40:0x00a6, B:42:0x00ae, B:54:0x00e5, B:56:0x00eb, B:58:0x00f1, B:84:0x0182, B:64:0x0102, B:65:0x0118, B:66:0x0119, B:70:0x0129, B:72:0x0136, B:75:0x013f, B:77:0x0151, B:80:0x0160, B:81:0x017d, B:83:0x0180, B:69:0x0125, B:86:0x01b4, B:87:0x01bb, B:47:0x00c8, B:48:0x00cb), top: B:98:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01be  */
    /* JADX WARN: Code duplicated, block: B:90:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:93:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:95:0x01df  */
    /* JADX WARN: Instruction removed from duplicated block: B:90:0x01c0, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:95:0x01df, please report this as an issue */
    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        String message;
        int i;
        int i2;
        int iIndexOfNonDigit;
        int i3;
        int i4;
        int i5;
        int i6;
        char cCharAt;
        String strSubstring;
        int length;
        TimeZone timeZone;
        char cCharAt2;
        try {
            int index = parsePosition.getIndex();
            int i7 = index + 4;
            int i8 = parseInt(str, index, i7);
            if (checkOffset(str, i7, '-')) {
                i7 = index + 5;
            }
            int i9 = i7 + 2;
            int i10 = parseInt(str, i7, i9);
            if (checkOffset(str, i9, '-')) {
                i9 = i7 + 3;
            }
            int i11 = i9 + 2;
            int i12 = parseInt(str, i9, i11);
            boolean zCheckOffset = checkOffset(str, i11, 'T');
            if (!zCheckOffset && str.length() <= i11) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(i8, i10 - 1, i12);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i11);
                return gregorianCalendar.getTime();
            }
            if (zCheckOffset) {
                int i13 = i9 + 5;
                i5 = parseInt(str, i9 + 3, i13);
                if (checkOffset(str, i13, ':')) {
                    i13 = i9 + 6;
                }
                int i14 = i13 + 2;
                i2 = parseInt(str, i13, i14);
                if (checkOffset(str, i14, ':')) {
                    i14 = i13 + 3;
                }
                if (str.length() <= i14 || (cCharAt2 = str.charAt(i14)) == 'Z' || cCharAt2 == '+' || cCharAt2 == '-') {
                    i11 = i14;
                    i = i5;
                } else {
                    iIndexOfNonDigit = i14 + 2;
                    i4 = parseInt(str, i14, iIndexOfNonDigit);
                    if (i4 > 59 && i4 < 63) {
                        i4 = 59;
                    }
                    if (checkOffset(str, iIndexOfNonDigit, '.')) {
                        int i15 = i14 + 3;
                        iIndexOfNonDigit = indexOfNonDigit(str, i14 + 4);
                        int iMin = Math.min(iIndexOfNonDigit, i14 + 6);
                        int i16 = parseInt(str, i15, iMin);
                        int i17 = iMin - i15;
                        if (i17 == 1) {
                            i16 *= 100;
                        } else if (i17 == 2) {
                            i16 *= 10;
                        }
                        i6 = i2;
                        i3 = i16;
                    } else {
                        i6 = i2;
                        i3 = 0;
                    }
                }
                if (str.length() > iIndexOfNonDigit) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                cCharAt = str.charAt(iIndexOfNonDigit);
                if (cCharAt == 'Z') {
                    timeZone = TIMEZONE_UTC;
                    length = iIndexOfNonDigit + 1;
                } else {
                    if (cCharAt != '+' && cCharAt != '-') {
                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                    }
                    strSubstring = str.substring(iIndexOfNonDigit);
                    if (strSubstring.length() >= 5) {
                        strSubstring = strSubstring.concat("00");
                    }
                    length = iIndexOfNonDigit + strSubstring.length();
                    if (!"+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                        timeZone = TIMEZONE_UTC;
                    } else {
                        String strConcat = "GMT".concat(strSubstring);
                        TimeZone timeZone2 = TimeZone.getTimeZone(strConcat);
                        String id = timeZone2.getID();
                        if (!id.equals(strConcat) && !id.replace(":", AppConfig.CUSTOM).equals(strConcat)) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + strConcat + " given, resolves to " + timeZone2.getID());
                        }
                        timeZone = timeZone2;
                    }
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                gregorianCalendar2.setLenient(false);
                gregorianCalendar2.set(1, i8);
                gregorianCalendar2.set(2, i10 - 1);
                gregorianCalendar2.set(5, i12);
                gregorianCalendar2.set(11, i5);
                gregorianCalendar2.set(12, i6);
                gregorianCalendar2.set(13, i4);
                gregorianCalendar2.set(14, i3);
                parsePosition.setIndex(length);
                return gregorianCalendar2.getTime();
            }
            i = 0;
            i2 = 0;
            iIndexOfNonDigit = i11;
            i3 = 0;
            i4 = 0;
            i5 = i;
            i6 = i2;
            if (str.length() > iIndexOfNonDigit) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            cCharAt = str.charAt(iIndexOfNonDigit);
            if (cCharAt == 'Z') {
                timeZone = TIMEZONE_UTC;
                length = iIndexOfNonDigit + 1;
            } else {
                if (cCharAt != '+') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                }
                strSubstring = str.substring(iIndexOfNonDigit);
                if (strSubstring.length() >= 5) {
                    strSubstring = strSubstring.concat("00");
                }
                length = iIndexOfNonDigit + strSubstring.length();
                if ("+0000".equals(strSubstring)) {
                    timeZone = TIMEZONE_UTC;
                } else {
                    timeZone = TIMEZONE_UTC;
                }
            }
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(timeZone);
            gregorianCalendar3.setLenient(false);
            gregorianCalendar3.set(1, i8);
            gregorianCalendar3.set(2, i10 - 1);
            gregorianCalendar3.set(5, i12);
            gregorianCalendar3.set(11, i5);
            gregorianCalendar3.set(12, i6);
            gregorianCalendar3.set(13, i4);
            gregorianCalendar3.set(14, i3);
            parsePosition.setIndex(length);
            return gregorianCalendar3.getTime();
        } catch (IllegalArgumentException e) {
            e = e;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException2 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(e);
            throw parseException2;
        } catch (NumberFormatException e3) {
            e = e3;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException3 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException3.initCause(e);
            throw parseException3;
        }
    }

    private static int parseInt(String str, int i, int i2) {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: ".concat(str.substring(i, i2)));
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: ".concat(str.substring(i, i2)));
            }
            i3 = (i3 * 10) - iDigit2;
            i4 = i5;
        }
        return -i3;
    }
}
