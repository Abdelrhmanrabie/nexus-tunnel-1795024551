package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.StringUtils;
import com.jcraft.jzlib.GZIPHeader;
import defpackage.yg$a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class DecodedBitStreamParser {
    public static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    public static void decodeAlphanumericSegment(yg$a yg_a, StringBuilder sb, int i, boolean z) {
        while (i > 1) {
            if (yg_a.available() < 11) {
                throw FormatException.getFormatInstance();
            }
            int bits = yg_a.readBits(11);
            sb.append(toAlphaNumericChar(bits / 45));
            sb.append(toAlphaNumericChar(bits % 45));
            i -= 2;
        }
        if (i == 1) {
            if (yg_a.available() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(yg_a.readBits(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    } else {
                        sb.setCharAt(length, (char) 29);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0129  */
    /* JADX WARN: Code duplicated, block: B:112:0x0134 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x0136  */
    /* JADX WARN: Code duplicated, block: B:119:0x0140 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x0142 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x014e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x0150  */
    /* JADX WARN: Code duplicated, block: B:129:0x0153 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:130:0x0155  */
    /* JADX WARN: Code duplicated, block: B:131:0x0158 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x015a  */
    /* JADX WARN: Code duplicated, block: B:133:0x015d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0038  */
    /* JADX WARN: Code duplicated, block: B:148:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0051  */
    /* JADX WARN: Code duplicated, block: B:32:0x0079  */
    /* JADX WARN: Code duplicated, block: B:34:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0081  */
    /* JADX WARN: Code duplicated, block: B:36:0x0084  */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:39:0x008a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0090  */
    /* JADX WARN: Code duplicated, block: B:43:0x0094  */
    /* JADX WARN: Code duplicated, block: B:45:0x009a  */
    /* JADX WARN: Code duplicated, block: B:46:0x009d  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a6 A[PHI: r10
      0x00a6: PHI (r10v5 int) = (r10v1 int), (r10v3 int), (r10v1 int) binds: [B:38:0x0088, B:47:0x00a1, B:34:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c8 A[PHI: r17
      0x00c8: PHI (r17v2 int) = (r17v1 int), (r17v1 int), (r17v4 int), (r17v1 int) binds: [B:52:0x00ae, B:57:0x00b8, B:64:0x00c6, B:63:0x00c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00de  */
    /* JADX WARN: Code duplicated, block: B:98:0x0113  */
    public static void decodeByteSegment(yg$a yg_a, StringBuilder sb, int i, CharacterSetECI characterSetECI, ArrayList arrayList, Map map) {
        String strName;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        byte b;
        boolean z7;
        int i9;
        boolean z8;
        boolean z9;
        int i10;
        int i11;
        if ((i << 3) > yg_a.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i];
        int i12 = 0;
        for (int i13 = 0; i13 < i; i13++) {
            bArr[i13] = (byte) yg_a.readBits(8);
        }
        if (characterSetECI == null) {
            boolean z10 = StringUtils.ASSUME_SHIFT_JIS;
            if (map != null) {
                DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
                if (map.containsKey(decodeHintType)) {
                    strName = map.get(decodeHintType).toString();
                } else {
                    z = true;
                    if (i <= 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    int i14 = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    int i15 = 0;
                    i8 = 0;
                    int i16 = 0;
                    int i17 = 0;
                    z3 = true;
                    z4 = true;
                    while (i2 < i && (z || z3 || z4)) {
                        b = bArr[i2];
                        z7 = z;
                        i9 = b & GZIPHeader.OS_UNKNOWN;
                        if (z4) {
                            z8 = z2;
                            i10 = b & 128;
                            if (i3 > 0) {
                                if (i10 != 0) {
                                    i3--;
                                } else {
                                    z4 = false;
                                }
                            } else if (i10 != 0) {
                                if ((b & 64) != 0) {
                                    i11 = i3 + 1;
                                    if ((b & 32) == 0) {
                                        i5++;
                                    } else {
                                        i11 = i3 + 2;
                                        if ((b & 16) == 0) {
                                            i6++;
                                        } else {
                                            i3 += 3;
                                            if ((b & 8) == 0) {
                                                i7++;
                                            } else {
                                                z4 = false;
                                            }
                                        }
                                    }
                                    i3 = i11;
                                } else {
                                    z4 = false;
                                }
                            }
                        } else {
                            z8 = z2;
                        }
                        if (!z7) {
                            z9 = z7;
                        } else if (i9 > 127 || i9 >= 160) {
                            if (i9 > 159 && (i9 < 192 || i9 == 215 || i9 == 247)) {
                                i8++;
                            }
                            z9 = z7;
                        } else {
                            z9 = false;
                        }
                        boolean z11 = z9;
                        if (!z3) {
                            if (i4 > 0) {
                                if (i9 >= 64 || i9 == 127 || i9 > 252) {
                                    z3 = false;
                                } else {
                                    i4--;
                                }
                            } else if (i9 != 128 || i9 == 160 || i9 > 239) {
                                z3 = false;
                            } else if (i9 <= 160 || i9 >= 224) {
                                if (i9 > 127) {
                                    i4++;
                                    int i18 = i16 + 1;
                                    if (i18 > i12) {
                                        i12 = i18;
                                        i16 = i12;
                                    } else {
                                        i16 = i18;
                                    }
                                } else {
                                    i16 = 0;
                                }
                                i17 = 0;
                            } else {
                                i14++;
                                int i19 = i17 + 1;
                                if (i19 > i15) {
                                    i15 = i19;
                                }
                                i17 = i19;
                                i16 = 0;
                            }
                        }
                        i2++;
                        z = z11;
                        z2 = z8;
                    }
                    z5 = z;
                    boolean z12 = z2;
                    if (z4 && i3 > 0) {
                        z4 = false;
                    }
                    if (z3 || i4 <= 0) {
                        z6 = z3;
                    } else {
                        z6 = false;
                    }
                    if (!z4 && (z12 || i5 + i6 + i7 > 0)) {
                        strName = "UTF8";
                    } else if (!z6 && (StringUtils.ASSUME_SHIFT_JIS || i15 >= 3 || i12 >= 3)) {
                        strName = "SJIS";
                    } else if (z5 || !z6) {
                        if (z5) {
                            strName = "ISO8859_1";
                        } else if (z6) {
                            strName = "SJIS";
                        } else if (z4) {
                            strName = "UTF8";
                        } else {
                            strName = StringUtils.PLATFORM_DEFAULT_ENCODING;
                        }
                    } else if (!(i15 == 2 && i14 == 2) && i8 * 10 < i) {
                        strName = "ISO8859_1";
                    } else {
                        strName = "SJIS";
                    }
                }
            } else {
                z = true;
                if (i <= 3) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                int i110 = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                int i111 = 0;
                i8 = 0;
                int i112 = 0;
                int i113 = 0;
                z3 = true;
                z4 = true;
                while (i2 < i) {
                    b = bArr[i2];
                    z7 = z;
                    i9 = b & GZIPHeader.OS_UNKNOWN;
                    if (z4) {
                        z8 = z2;
                        i10 = b & 128;
                        if (i3 > 0) {
                            if (i10 != 0) {
                                i3--;
                            } else {
                                z4 = false;
                            }
                        } else if (i10 != 0) {
                            if ((b & 64) != 0) {
                                i11 = i3 + 1;
                                if ((b & 32) == 0) {
                                    i5++;
                                } else {
                                    i11 = i3 + 2;
                                    if ((b & 16) == 0) {
                                        i6++;
                                    } else {
                                        i3 += 3;
                                        if ((b & 8) == 0) {
                                            i7++;
                                        } else {
                                            z4 = false;
                                        }
                                    }
                                }
                                i3 = i11;
                            } else {
                                z4 = false;
                            }
                        }
                    } else {
                        z8 = z2;
                    }
                    if (!z7) {
                        z9 = z7;
                    } else {
                        if (i9 > 127) {
                        }
                        if (i9 > 159) {
                            i8++;
                        }
                        z9 = z7;
                    }
                    boolean z13 = z9;
                    if (!z3) {
                        if (i4 > 0) {
                            if (i9 >= 64) {
                                z3 = false;
                            } else {
                                z3 = false;
                            }
                        } else if (i9 != 128) {
                            z3 = false;
                        } else {
                            z3 = false;
                        }
                    }
                    i2++;
                    z = z13;
                    z2 = z8;
                }
                z5 = z;
                boolean z14 = z2;
                if (z4) {
                    z4 = false;
                }
                if (z3) {
                    z6 = z3;
                } else {
                    z6 = z3;
                }
                if (!z4) {
                    if (!z6) {
                        if (z5) {
                            if (z5) {
                                strName = "ISO8859_1";
                            } else if (z6) {
                                strName = "SJIS";
                            } else if (z4) {
                                strName = "UTF8";
                            } else {
                                strName = StringUtils.PLATFORM_DEFAULT_ENCODING;
                            }
                        } else if (z5) {
                            strName = "ISO8859_1";
                        } else if (z6) {
                            strName = "SJIS";
                        } else if (z4) {
                            strName = "UTF8";
                        } else {
                            strName = StringUtils.PLATFORM_DEFAULT_ENCODING;
                        }
                    } else if (z5) {
                        if (z5) {
                            strName = "ISO8859_1";
                        } else if (z6) {
                            strName = "SJIS";
                        } else if (z4) {
                            strName = "UTF8";
                        } else {
                            strName = StringUtils.PLATFORM_DEFAULT_ENCODING;
                        }
                    } else if (z5) {
                        strName = "ISO8859_1";
                    } else if (z6) {
                        strName = "SJIS";
                    } else if (z4) {
                        strName = "UTF8";
                    } else {
                        strName = StringUtils.PLATFORM_DEFAULT_ENCODING;
                    }
                } else if (!z6) {
                    if (z5) {
                        if (z5) {
                            strName = "ISO8859_1";
                        } else if (z6) {
                            strName = "SJIS";
                        } else if (z4) {
                            strName = "UTF8";
                        } else {
                            strName = StringUtils.PLATFORM_DEFAULT_ENCODING;
                        }
                    } else if (z5) {
                        strName = "ISO8859_1";
                    } else if (z6) {
                        strName = "SJIS";
                    } else if (z4) {
                        strName = "UTF8";
                    } else {
                        strName = StringUtils.PLATFORM_DEFAULT_ENCODING;
                    }
                } else if (z5) {
                    if (z5) {
                        strName = "ISO8859_1";
                    } else if (z6) {
                        strName = "SJIS";
                    } else if (z4) {
                        strName = "UTF8";
                    } else {
                        strName = StringUtils.PLATFORM_DEFAULT_ENCODING;
                    }
                } else if (z5) {
                    strName = "ISO8859_1";
                } else if (z6) {
                    strName = "SJIS";
                } else if (z4) {
                    strName = "UTF8";
                } else {
                    strName = StringUtils.PLATFORM_DEFAULT_ENCODING;
                }
            }
        } else {
            strName = characterSetECI.name();
        }
        try {
            sb.append(new String(bArr, strName));
            arrayList.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void decodeHanziSegment(yg$a yg_a, StringBuilder sb, int i) {
        if (i * 13 > yg_a.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int bits = yg_a.readBits(13);
            int i3 = (bits % 96) | ((bits / 96) << 8);
            int i4 = i3 + (i3 < 959 ? 41377 : 42657);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void decodeKanjiSegment(yg$a yg_a, StringBuilder sb, int i) {
        if (i * 13 > yg_a.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int bits = yg_a.readBits(13);
            int i3 = (bits % 192) | ((bits / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void decodeNumericSegment(yg$a yg_a, StringBuilder sb, int i) {
        int bits;
        while (i >= 3) {
            if (yg_a.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int bits2 = yg_a.readBits(10);
            if (bits2 >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits2 / 100));
            sb.append(toAlphaNumericChar((bits2 / 10) % 10));
            sb.append(toAlphaNumericChar(bits2 % 10));
            i -= 3;
        }
        if (i == 2) {
            if (yg_a.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            int bits3 = yg_a.readBits(7);
            if (bits3 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits3 / 10));
            bits = bits3 % 10;
        } else {
            if (i != 1) {
                return;
            }
            if (yg_a.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            bits = yg_a.readBits(4);
            if (bits >= 10) {
                throw FormatException.getFormatInstance();
            }
        }
        sb.append(toAlphaNumericChar(bits));
    }

    public static char toAlphaNumericChar(int i) throws FormatException {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw FormatException.getFormatInstance();
    }
}
