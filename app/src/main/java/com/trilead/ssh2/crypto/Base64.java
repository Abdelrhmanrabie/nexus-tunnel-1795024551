package com.trilead.ssh2.crypto;

import com.jcraft.jzlib.GZIPHeader;
import defpackage.d;
import java.io.CharArrayWriter;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Base64 {
    static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e6 A[EDGE_INSN: B:62:0x00e6->B:58:0x00e6 BREAK  A[LOOP:0: B:3:0x000a->B:57:0x00e2], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00e2 A[SYNTHETIC] */
    public static byte[] decode(char[] cArr) throws IOException {
        String str;
        int i;
        int i2;
        byte b;
        byte b2;
        byte b3;
        byte b4;
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[cArr.length];
        int i3 = 0;
        int i4 = 0;
        for (char c : cArr) {
            if (c != '\n' && c != '\r' && c != ' ' && c != '\t') {
                if (c >= 'A' && c <= 'Z') {
                    i2 = i3 + 1;
                    bArr[i3] = (byte) (c - 'A');
                } else {
                    if (c < 'a' || c > 'z') {
                        if (c < '0' || c > '9') {
                            if (c == '+') {
                                i = i3 + 1;
                                bArr[i3] = 62;
                            } else if (c == '/') {
                                i = i3 + 1;
                                bArr[i3] = 63;
                            } else if (c == '=') {
                                i = i3 + 1;
                                bArr[i3] = 64;
                            } else {
                                str = "Illegal char in base64 code.";
                            }
                            i3 = i;
                            if (i3 != 4) {
                                b = bArr[0];
                                if (b != 64) {
                                    break;
                                }
                                b2 = bArr[1];
                                if (b2 == 64) {
                                    b3 = bArr[2];
                                    if (b3 == 64) {
                                        bArr2[i4] = (byte) ((((b & 63) << 6) | (b2 & 63)) >> 4);
                                        i4++;
                                        break;
                                    }
                                    b4 = bArr[3];
                                    if (b4 == 64) {
                                        int i5 = ((b & 63) << 12) | ((b2 & 63) << 6) | (b3 & 63);
                                        int i6 = i4 + 1;
                                        bArr2[i4] = (byte) (i5 >> 10);
                                        i4 += 2;
                                        bArr2[i6] = (byte) (i5 >> 2);
                                        break;
                                    }
                                    int i7 = ((b & 63) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
                                    bArr2[i4] = (byte) (i7 >> 16);
                                    int i8 = i4 + 2;
                                    bArr2[i4 + 1] = (byte) (i7 >> 8);
                                    i4 += 3;
                                    bArr2[i8] = (byte) i7;
                                    i3 = 0;
                                } else {
                                    str = "Unexpected '=' in base64 code.";
                                }
                            } else {
                                continue;
                            }
                        } else {
                            i2 = i3 + 1;
                            bArr[i3] = (byte) (c + 4);
                        }
                        d.AnonymousClass0.m$6(str);
                        return null;
                    }
                    i2 = i3 + 1;
                    bArr[i3] = (byte) (c - 'G');
                }
                i3 = i2;
                if (i3 != 4) {
                    b = bArr[0];
                    if (b != 64) {
                        break;
                        break;
                    }
                    b2 = bArr[1];
                    if (b2 == 64) {
                        str = "Unexpected '=' in base64 code.";
                        d.AnonymousClass0.m$6(str);
                        return null;
                    }
                    b3 = bArr[2];
                    if (b3 == 64) {
                        bArr2[i4] = (byte) ((((b & 63) << 6) | (b2 & 63)) >> 4);
                        i4++;
                        break;
                    }
                    b4 = bArr[3];
                    if (b4 == 64) {
                        int i9 = ((b & 63) << 12) | ((b2 & 63) << 6) | (b3 & 63);
                        int i10 = i4 + 1;
                        bArr2[i4] = (byte) (i9 >> 10);
                        i4 += 2;
                        bArr2[i10] = (byte) (i9 >> 2);
                        break;
                    }
                    int i11 = ((b & 63) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
                    bArr2[i4] = (byte) (i11 >> 16);
                    int i12 = i4 + 2;
                    bArr2[i4 + 1] = (byte) (i11 >> 8);
                    i4 += 3;
                    bArr2[i12] = (byte) i11;
                    i3 = 0;
                } else {
                    continue;
                }
            }
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, i4);
        return bArr3;
    }

    public static char[] encode(byte[] bArr) {
        CharArrayWriter charArrayWriter = new CharArrayWriter((bArr.length * 4) / 3);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 = i == 0 ? (bArr[i3] & GZIPHeader.OS_UNKNOWN) << 16 : i2 | (i == 1 ? (bArr[i3] & GZIPHeader.OS_UNKNOWN) << 8 : bArr[i3] & GZIPHeader.OS_UNKNOWN);
            i++;
            if (i == 3) {
                char[] cArr = alphabet;
                charArrayWriter.write(cArr[i2 >> 18]);
                charArrayWriter.write(cArr[(i2 >> 12) & 63]);
                charArrayWriter.write(cArr[(i2 >> 6) & 63]);
                charArrayWriter.write(cArr[i2 & 63]);
                i = 0;
            }
        }
        if (i == 1) {
            char[] cArr2 = alphabet;
            charArrayWriter.write(cArr2[i2 >> 18]);
            charArrayWriter.write(cArr2[(i2 >> 12) & 63]);
            charArrayWriter.write(61);
            charArrayWriter.write(61);
        }
        if (i == 2) {
            char[] cArr3 = alphabet;
            charArrayWriter.write(cArr3[i2 >> 18]);
            charArrayWriter.write(cArr3[(i2 >> 12) & 63]);
            charArrayWriter.write(cArr3[(i2 >> 6) & 63]);
            charArrayWriter.write(61);
        }
        return charArrayWriter.toCharArray();
    }
}
