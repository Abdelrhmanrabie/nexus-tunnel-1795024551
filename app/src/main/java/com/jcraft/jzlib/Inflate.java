package com.jcraft.jzlib;

import java.io.ByteArrayOutputStream;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
final class Inflate {
    private static final int BAD = 13;
    private static final int BLOCKS = 7;
    private static final int CHECK1 = 11;
    private static final int CHECK2 = 10;
    private static final int CHECK3 = 9;
    private static final int CHECK4 = 8;
    private static final int COMMENT = 21;
    private static final int DICT0 = 6;
    private static final int DICT1 = 5;
    private static final int DICT2 = 4;
    private static final int DICT3 = 3;
    private static final int DICT4 = 2;
    private static final int DONE = 12;
    private static final int EXLEN = 18;
    private static final int EXTRA = 19;
    private static final int FLAG = 1;
    private static final int FLAGS = 23;
    private static final int HCRC = 22;
    private static final int HEAD = 14;
    static final int INFLATE_ANY = 1073741824;
    private static final int LENGTH = 15;
    private static final int MAX_WBITS = 15;
    private static final int METHOD = 0;
    private static final int NAME = 20;
    private static final int OS = 17;
    private static final int PRESET_DICT = 32;
    private static final int TIME = 16;
    private static final int Z_BUF_ERROR = -5;
    private static final int Z_DATA_ERROR = -3;
    private static final int Z_DEFLATED = 8;
    private static final int Z_ERRNO = -1;
    static final int Z_FINISH = 4;
    static final int Z_FULL_FLUSH = 3;
    private static final int Z_MEM_ERROR = -4;
    private static final int Z_NEED_DICT = 2;
    static final int Z_NO_FLUSH = 0;
    private static final int Z_OK = 0;
    static final int Z_PARTIAL_FLUSH = 1;
    private static final int Z_STREAM_END = 1;
    private static final int Z_STREAM_ERROR = -2;
    static final int Z_SYNC_FLUSH = 2;
    private static final int Z_VERSION_ERROR = -6;
    private static byte[] mark = {0, 0, -1, -1};
    InfBlocks blocks;
    private int flags;
    int marker;
    int method;
    int mode;
    long need;
    int wbits;
    int wrap;
    private final ZStream z;
    long was = -1;
    private int need_bytes = -1;
    private byte[] crcbuf = new byte[4];
    GZIPHeader gheader = null;
    private ByteArrayOutputStream tmp_string = null;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class Return extends Exception {
        int r;

        public Return(int i) {
            this.r = i;
        }
    }

    public Inflate(ZStream zStream) {
        this.z = zStream;
    }

    private void checksum(int i, long j) {
        for (int i2 = 0; i2 < i; i2++) {
            this.crcbuf[i2] = (byte) (255 & j);
            j >>= 8;
        }
        this.z.adler.update(this.crcbuf, 0, i);
    }

    private int readBytes(int i, int i2) throws Return {
        if (this.tmp_string == null) {
            this.tmp_string = new ByteArrayOutputStream();
        }
        while (this.need > 0) {
            ZStream zStream = this.z;
            int i3 = zStream.avail_in;
            if (i3 == 0) {
                throw new Return(i);
            }
            zStream.avail_in = i3 - 1;
            zStream.total_in++;
            byte[] bArr = zStream.next_in;
            int i4 = zStream.next_in_index;
            byte b = bArr[i4];
            this.tmp_string.write(bArr, i4, 1);
            ZStream zStream2 = this.z;
            zStream2.adler.update(zStream2.next_in, zStream2.next_in_index, 1);
            this.z.next_in_index++;
            this.need--;
            i = i2;
        }
        return i;
    }

    private int readBytes(int i, int i2, int i3) throws Return {
        long j;
        if (this.need_bytes == -1) {
            this.need_bytes = i;
            this.need = 0L;
        }
        while (true) {
            int i4 = this.need_bytes;
            if (i4 <= 0) {
                if (i != 2) {
                    j = i == 4 ? InternalZipConstants.ZIP_64_SIZE_LIMIT : 65535L;
                    this.need_bytes = -1;
                    return i2;
                }
                this.need = j & this.need;
                this.need_bytes = -1;
                return i2;
            }
            ZStream zStream = this.z;
            int i5 = zStream.avail_in;
            if (i5 == 0) {
                throw new Return(i2);
            }
            zStream.avail_in = i5 - 1;
            zStream.total_in++;
            long j2 = this.need;
            byte[] bArr = zStream.next_in;
            int i6 = zStream.next_in_index;
            zStream.next_in_index = i6 + 1;
            this.need = j2 | ((long) ((bArr[i6] & GZIPHeader.OS_UNKNOWN) << ((i - i4) * 8)));
            this.need_bytes = i4 - 1;
            i2 = i3;
        }
    }

    private int readString(int i, int i2) throws Return {
        if (this.tmp_string == null) {
            this.tmp_string = new ByteArrayOutputStream();
        }
        while (true) {
            ZStream zStream = this.z;
            int i3 = zStream.avail_in;
            if (i3 == 0) {
                throw new Return(i);
            }
            zStream.avail_in = i3 - 1;
            zStream.total_in++;
            byte[] bArr = zStream.next_in;
            int i4 = zStream.next_in_index;
            byte b = bArr[i4];
            if (b != 0) {
                this.tmp_string.write(bArr, i4, 1);
            }
            ZStream zStream2 = this.z;
            zStream2.adler.update(zStream2.next_in, zStream2.next_in_index, 1);
            this.z.next_in_index++;
            if (b == 0) {
                return i2;
            }
            i = i2;
        }
    }

    public GZIPHeader getGZIPHeader() {
        return this.gheader;
    }

    public boolean inParsingHeader() {
        int i = this.mode;
        if (i == 2 || i == 3 || i == 4 || i == 5 || i == 14) {
            return true;
        }
        switch (i) {
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0167  */
    /* JADX WARN: Code duplicated, block: B:102:0x016b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0177 A[Catch: Return -> 0x0074, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Return -> 0x0074, blocks: (B:14:0x004c, B:28:0x0077, B:36:0x0092, B:46:0x00bc, B:106:0x0177, B:118:0x01b2, B:202:0x037a), top: B:255:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:109:0x017f  */
    /* JADX WARN: Code duplicated, block: B:175:0x029d  */
    /* JADX WARN: Code duplicated, block: B:179:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:183:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:187:0x031f  */
    /* JADX WARN: Code duplicated, block: B:189:0x033f  */
    /* JADX WARN: Code duplicated, block: B:192:0x0362  */
    /* JADX WARN: Code duplicated, block: B:193:0x0365  */
    /* JADX WARN: Code duplicated, block: B:194:0x0367  */
    /* JADX WARN: Code duplicated, block: B:200:0x0376  */
    /* JADX WARN: Code duplicated, block: B:217:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:229:0x03d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:230:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:233:0x03fa A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:234:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:237:0x0422 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:238:0x0423  */
    /* JADX WARN: Code duplicated, block: B:241:0x044c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:242:0x044d  */
    /* JADX WARN: Code duplicated, block: B:249:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:251:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:278:0x011b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:280:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:281:0x01a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:282:0x01a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:286:0x029c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x02c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:288:0x02f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:289:0x031e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:292:0x03b9 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:294:0x0196 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:300:0x03a5 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x007f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0089  */
    /* JADX WARN: Code duplicated, block: B:39:0x009a  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bc A[Catch: Return -> 0x0074, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Return -> 0x0074, blocks: (B:14:0x004c, B:28:0x0077, B:36:0x0092, B:46:0x00bc, B:106:0x0177, B:118:0x01b2, B:202:0x037a), top: B:255:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f1 A[Catch: Return -> 0x0106, TryCatch #2 {Return -> 0x0106, blocks: (B:59:0x00e9, B:61:0x00f1, B:63:0x0101, B:66:0x0108), top: B:253:0x00e9 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0119  */
    /* JADX WARN: Code duplicated, block: B:78:0x012d A[Catch: Return -> 0x0136, TryCatch #1 {Return -> 0x0136, blocks: (B:76:0x0125, B:78:0x012d, B:81:0x0138), top: B:251:0x0125 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x013e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0142  */
    /* JADX WARN: Code duplicated, block: B:93:0x0156 A[Catch: Return -> 0x015f, TryCatch #0 {Return -> 0x015f, blocks: (B:91:0x014e, B:93:0x0156, B:96:0x0161), top: B:249:0x014e }] */
    public int inflate(int i) {
        ZStream zStream;
        int i2;
        ZStream zStream2;
        int i3;
        ZStream zStream3;
        int i4;
        String str;
        ZStream zStream4;
        int i5;
        long j;
        int i6;
        int i7;
        long j2;
        GZIPHeader gZIPHeader;
        ZStream zStream5;
        int i8;
        ZStream zStream6;
        int i9;
        ZStream zStream7;
        int i10;
        ZStream zStream8;
        int i11;
        ZStream zStream9;
        GZIPHeader gZIPHeader2;
        GZIPHeader gZIPHeader3;
        GZIPHeader gZIPHeader4;
        GZIPHeader gZIPHeader5;
        GZIPHeader gZIPHeader6;
        GZIPHeader gZIPHeader7;
        byte[] byteArray;
        int length;
        byte[] bArr;
        GZIPHeader gZIPHeader8;
        GZIPHeader gZIPHeader9;
        GZIPHeader gZIPHeader10;
        GZIPHeader gZIPHeader11;
        ZStream zStream10 = this.z;
        if (zStream10 == null || zStream10.next_in == null) {
            return (i == 4 && this.mode == 14) ? 0 : -2;
        }
        int iProc = -5;
        int i12 = i == 4 ? -5 : 0;
        while (true) {
            char c = '\b';
            String str2 = "unknown compression method";
            int i13 = 13;
            switch (this.mode) {
                case 2:
                    zStream8 = this.z;
                    i11 = zStream8.avail_in;
                    if (i11 == 0) {
                        return iProc;
                    }
                    zStream8.avail_in = i11 - 1;
                    zStream8.total_in++;
                    byte[] bArr2 = zStream8.next_in;
                    int i14 = zStream8.next_in_index;
                    zStream8.next_in_index = i14 + 1;
                    this.need = ((long) ((bArr2[i14] & GZIPHeader.OS_UNKNOWN) << 24)) & 4278190080L;
                    this.mode = 3;
                    iProc = i12;
                    zStream7 = this.z;
                    i10 = zStream7.avail_in;
                    if (i10 == 0) {
                        return iProc;
                    }
                    zStream7.avail_in = i10 - 1;
                    zStream7.total_in++;
                    long j3 = this.need;
                    byte[] bArr3 = zStream7.next_in;
                    int i15 = zStream7.next_in_index;
                    zStream7.next_in_index = i15 + 1;
                    this.need = j3 + (((long) ((bArr3[i15] & GZIPHeader.OS_UNKNOWN) << 16)) & 16711680);
                    this.mode = 4;
                    iProc = i12;
                    zStream6 = this.z;
                    i9 = zStream6.avail_in;
                    if (i9 == 0) {
                        return iProc;
                    }
                    zStream6.avail_in = i9 - 1;
                    zStream6.total_in++;
                    long j4 = this.need;
                    byte[] bArr4 = zStream6.next_in;
                    int i16 = zStream6.next_in_index;
                    zStream6.next_in_index = i16 + 1;
                    this.need = j4 + (((long) ((bArr4[i16] & GZIPHeader.OS_UNKNOWN) << 8)) & 65280);
                    this.mode = 5;
                    iProc = i12;
                    zStream5 = this.z;
                    i8 = zStream5.avail_in;
                    if (i8 == 0) {
                        return iProc;
                    }
                    zStream5.avail_in = i8 - 1;
                    zStream5.total_in++;
                    long j5 = this.need;
                    byte[] bArr5 = zStream5.next_in;
                    int i17 = zStream5.next_in_index;
                    zStream5.next_in_index = i17 + 1;
                    long j6 = j5 + (((long) bArr5[i17]) & 255);
                    this.need = j6;
                    zStream5.adler.reset(j6);
                    this.mode = 6;
                    return 2;
                case 3:
                    zStream7 = this.z;
                    i10 = zStream7.avail_in;
                    if (i10 == 0) {
                        return iProc;
                    }
                    zStream7.avail_in = i10 - 1;
                    zStream7.total_in++;
                    long j7 = this.need;
                    byte[] bArr6 = zStream7.next_in;
                    int i18 = zStream7.next_in_index;
                    zStream7.next_in_index = i18 + 1;
                    this.need = j7 + (((long) ((bArr6[i18] & GZIPHeader.OS_UNKNOWN) << 16)) & 16711680);
                    this.mode = 4;
                    iProc = i12;
                    zStream6 = this.z;
                    i9 = zStream6.avail_in;
                    if (i9 == 0) {
                        return iProc;
                    }
                    zStream6.avail_in = i9 - 1;
                    zStream6.total_in++;
                    long j8 = this.need;
                    byte[] bArr7 = zStream6.next_in;
                    int i19 = zStream6.next_in_index;
                    zStream6.next_in_index = i19 + 1;
                    this.need = j8 + (((long) ((bArr7[i19] & GZIPHeader.OS_UNKNOWN) << 8)) & 65280);
                    this.mode = 5;
                    iProc = i12;
                    zStream5 = this.z;
                    i8 = zStream5.avail_in;
                    if (i8 == 0) {
                        return iProc;
                    }
                    zStream5.avail_in = i8 - 1;
                    zStream5.total_in++;
                    long j9 = this.need;
                    byte[] bArr8 = zStream5.next_in;
                    int i110 = zStream5.next_in_index;
                    zStream5.next_in_index = i110 + 1;
                    long j10 = j9 + (((long) bArr8[i110]) & 255);
                    this.need = j10;
                    zStream5.adler.reset(j10);
                    this.mode = 6;
                    return 2;
                case 4:
                    zStream6 = this.z;
                    i9 = zStream6.avail_in;
                    if (i9 == 0) {
                        return iProc;
                    }
                    zStream6.avail_in = i9 - 1;
                    zStream6.total_in++;
                    long j11 = this.need;
                    byte[] bArr9 = zStream6.next_in;
                    int i111 = zStream6.next_in_index;
                    zStream6.next_in_index = i111 + 1;
                    this.need = j11 + (((long) ((bArr9[i111] & GZIPHeader.OS_UNKNOWN) << 8)) & 65280);
                    this.mode = 5;
                    iProc = i12;
                    zStream5 = this.z;
                    i8 = zStream5.avail_in;
                    if (i8 == 0) {
                        return iProc;
                    }
                    zStream5.avail_in = i8 - 1;
                    zStream5.total_in++;
                    long j12 = this.need;
                    byte[] bArr10 = zStream5.next_in;
                    int i112 = zStream5.next_in_index;
                    zStream5.next_in_index = i112 + 1;
                    long j13 = j12 + (((long) bArr10[i112]) & 255);
                    this.need = j13;
                    zStream5.adler.reset(j13);
                    this.mode = 6;
                    return 2;
                case 5:
                    zStream5 = this.z;
                    i8 = zStream5.avail_in;
                    if (i8 == 0) {
                        return iProc;
                    }
                    zStream5.avail_in = i8 - 1;
                    zStream5.total_in++;
                    long j14 = this.need;
                    byte[] bArr11 = zStream5.next_in;
                    int i113 = zStream5.next_in_index;
                    zStream5.next_in_index = i113 + 1;
                    long j15 = j14 + (((long) bArr11[i113]) & 255);
                    this.need = j15;
                    zStream5.adler.reset(j15);
                    this.mode = 6;
                    return 2;
                case 6:
                    this.mode = 13;
                    this.z.msg = "need dictionary";
                    this.marker = 0;
                    return -2;
                case 7:
                    iProc = this.blocks.proc(iProc);
                    if (iProc == -3) {
                        this.mode = 13;
                        this.marker = 0;
                    } else {
                        if (iProc == 0) {
                            iProc = i12;
                        }
                        if (iProc != 1) {
                            return iProc;
                        }
                        this.was = this.z.adler.getValue();
                        this.blocks.reset();
                        if (this.wrap == 0) {
                            this.mode = 12;
                            iProc = i12;
                        } else {
                            this.mode = 8;
                            iProc = i12;
                            zStream2 = this.z;
                            i3 = zStream2.avail_in;
                            if (i3 == 0) {
                                return iProc;
                            }
                            zStream2.avail_in = i3 - 1;
                            zStream2.total_in++;
                            byte[] bArr12 = zStream2.next_in;
                            int i20 = zStream2.next_in_index;
                            zStream2.next_in_index = i20 + 1;
                            this.need = ((long) ((bArr12[i20] & GZIPHeader.OS_UNKNOWN) << 24)) & 4278190080L;
                            this.mode = 9;
                            iProc = i12;
                            zStream = this.z;
                            i2 = zStream.avail_in;
                            if (i2 == 0) {
                                return iProc;
                            }
                            zStream.avail_in = i2 - 1;
                            zStream.total_in++;
                            long j16 = this.need;
                            byte[] bArr13 = zStream.next_in;
                            int i21 = zStream.next_in_index;
                            zStream.next_in_index = i21 + 1;
                            this.need = j16 + (((long) ((bArr13[i21] & GZIPHeader.OS_UNKNOWN) << 16)) & 16711680);
                            this.mode = 10;
                            iProc = i12;
                            zStream3 = this.z;
                            i4 = zStream3.avail_in;
                            if (i4 == 0) {
                                return iProc;
                            }
                            zStream3.avail_in = i4 - 1;
                            zStream3.total_in++;
                            long j17 = this.need;
                            byte[] bArr14 = zStream3.next_in;
                            int i22 = zStream3.next_in_index;
                            zStream3.next_in_index = i22 + 1;
                            this.need = j17 + (((long) ((bArr14[i22] & GZIPHeader.OS_UNKNOWN) << 8)) & 65280);
                            this.mode = 11;
                            iProc = i12;
                            zStream4 = this.z;
                            i5 = zStream4.avail_in;
                            if (i5 == 0) {
                                return iProc;
                            }
                            zStream4.avail_in = i5 - 1;
                            zStream4.total_in++;
                            long j18 = this.need;
                            byte[] bArr15 = zStream4.next_in;
                            int i23 = zStream4.next_in_index;
                            zStream4.next_in_index = i23 + 1;
                            j = j18 + (((long) bArr15[i23]) & 255);
                            this.need = j;
                            i6 = this.flags;
                            if (i6 != 0) {
                                this.need = (((65535 & j) << 24) | (((-16777216) & j) >> 24) | ((j & 16711680) >> c) | ((j & 65280) << c)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                            }
                            i7 = (int) this.was;
                            j2 = this.need;
                            if (i7 != ((int) j2)) {
                                zStream4.msg = "incorrect data check";
                            } else if (i6 != 0 && (gZIPHeader = this.gheader) != null) {
                                gZIPHeader.crc = j2;
                            }
                            this.mode = 15;
                            iProc = i12;
                            if (this.wrap != 0 || this.flags == 0) {
                                str = this.z.msg;
                                if (str != null || !str.equals("incorrect data check")) {
                                    this.mode = 12;
                                    return 1;
                                }
                                this.mode = 13;
                                this.marker = 5;
                            } else {
                                iProc = readBytes(4, iProc, i12);
                                String str3 = this.z.msg;
                                if (str3 == null || !str3.equals("incorrect data check")) {
                                    long j19 = this.need;
                                    ZStream zStream11 = this.z;
                                    if (j19 == (zStream11.total_out & InternalZipConstants.ZIP_64_SIZE_LIMIT)) {
                                        zStream11.msg = null;
                                        this.mode = 12;
                                        return 1;
                                    }
                                    zStream11.msg = "incorrect length check";
                                    this.mode = i13;
                                } else {
                                    this.mode = 13;
                                    this.marker = 5;
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    zStream2 = this.z;
                    i3 = zStream2.avail_in;
                    if (i3 == 0) {
                        return iProc;
                    }
                    zStream2.avail_in = i3 - 1;
                    zStream2.total_in++;
                    byte[] bArr16 = zStream2.next_in;
                    int i24 = zStream2.next_in_index;
                    zStream2.next_in_index = i24 + 1;
                    this.need = ((long) ((bArr16[i24] & GZIPHeader.OS_UNKNOWN) << 24)) & 4278190080L;
                    this.mode = 9;
                    iProc = i12;
                    zStream = this.z;
                    i2 = zStream.avail_in;
                    if (i2 == 0) {
                        return iProc;
                    }
                    zStream.avail_in = i2 - 1;
                    zStream.total_in++;
                    long j110 = this.need;
                    byte[] bArr17 = zStream.next_in;
                    int i25 = zStream.next_in_index;
                    zStream.next_in_index = i25 + 1;
                    this.need = j110 + (((long) ((bArr17[i25] & GZIPHeader.OS_UNKNOWN) << 16)) & 16711680);
                    this.mode = 10;
                    iProc = i12;
                    zStream3 = this.z;
                    i4 = zStream3.avail_in;
                    if (i4 == 0) {
                        return iProc;
                    }
                    zStream3.avail_in = i4 - 1;
                    zStream3.total_in++;
                    long j111 = this.need;
                    byte[] bArr18 = zStream3.next_in;
                    int i26 = zStream3.next_in_index;
                    zStream3.next_in_index = i26 + 1;
                    this.need = j111 + (((long) ((bArr18[i26] & GZIPHeader.OS_UNKNOWN) << 8)) & 65280);
                    this.mode = 11;
                    iProc = i12;
                    zStream4 = this.z;
                    i5 = zStream4.avail_in;
                    if (i5 == 0) {
                        return iProc;
                    }
                    zStream4.avail_in = i5 - 1;
                    zStream4.total_in++;
                    long j112 = this.need;
                    byte[] bArr19 = zStream4.next_in;
                    int i27 = zStream4.next_in_index;
                    zStream4.next_in_index = i27 + 1;
                    j = j112 + (((long) bArr19[i27]) & 255);
                    this.need = j;
                    i6 = this.flags;
                    if (i6 != 0) {
                        this.need = (((65535 & j) << 24) | (((-16777216) & j) >> 24) | ((j & 16711680) >> c) | ((j & 65280) << c)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                    }
                    i7 = (int) this.was;
                    j2 = this.need;
                    if (i7 != ((int) j2)) {
                        zStream4.msg = "incorrect data check";
                    } else if (i6 != 0) {
                        gZIPHeader.crc = j2;
                    }
                    this.mode = 15;
                    iProc = i12;
                    if (this.wrap != 0) {
                    }
                    str = this.z.msg;
                    if (str != null) {
                    }
                    this.mode = 12;
                    return 1;
                case 9:
                    zStream = this.z;
                    i2 = zStream.avail_in;
                    if (i2 == 0) {
                        return iProc;
                    }
                    zStream.avail_in = i2 - 1;
                    zStream.total_in++;
                    long j113 = this.need;
                    byte[] bArr110 = zStream.next_in;
                    int i28 = zStream.next_in_index;
                    zStream.next_in_index = i28 + 1;
                    this.need = j113 + (((long) ((bArr110[i28] & GZIPHeader.OS_UNKNOWN) << 16)) & 16711680);
                    this.mode = 10;
                    iProc = i12;
                    zStream3 = this.z;
                    i4 = zStream3.avail_in;
                    if (i4 == 0) {
                        return iProc;
                    }
                    zStream3.avail_in = i4 - 1;
                    zStream3.total_in++;
                    long j114 = this.need;
                    byte[] bArr111 = zStream3.next_in;
                    int i29 = zStream3.next_in_index;
                    zStream3.next_in_index = i29 + 1;
                    this.need = j114 + (((long) ((bArr111[i29] & GZIPHeader.OS_UNKNOWN) << 8)) & 65280);
                    this.mode = 11;
                    iProc = i12;
                    zStream4 = this.z;
                    i5 = zStream4.avail_in;
                    if (i5 == 0) {
                        return iProc;
                    }
                    zStream4.avail_in = i5 - 1;
                    zStream4.total_in++;
                    long j115 = this.need;
                    byte[] bArr112 = zStream4.next_in;
                    int i210 = zStream4.next_in_index;
                    zStream4.next_in_index = i210 + 1;
                    j = j115 + (((long) bArr112[i210]) & 255);
                    this.need = j;
                    i6 = this.flags;
                    if (i6 != 0) {
                        this.need = (((65535 & j) << 24) | (((-16777216) & j) >> 24) | ((j & 16711680) >> c) | ((j & 65280) << c)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                    }
                    i7 = (int) this.was;
                    j2 = this.need;
                    if (i7 != ((int) j2)) {
                        zStream4.msg = "incorrect data check";
                    } else if (i6 != 0) {
                        gZIPHeader.crc = j2;
                    }
                    this.mode = 15;
                    iProc = i12;
                    if (this.wrap != 0) {
                    }
                    str = this.z.msg;
                    if (str != null) {
                    }
                    this.mode = 12;
                    return 1;
                case 10:
                    zStream3 = this.z;
                    i4 = zStream3.avail_in;
                    if (i4 == 0) {
                        return iProc;
                    }
                    zStream3.avail_in = i4 - 1;
                    zStream3.total_in++;
                    long j116 = this.need;
                    byte[] bArr113 = zStream3.next_in;
                    int i211 = zStream3.next_in_index;
                    zStream3.next_in_index = i211 + 1;
                    this.need = j116 + (((long) ((bArr113[i211] & GZIPHeader.OS_UNKNOWN) << 8)) & 65280);
                    this.mode = 11;
                    iProc = i12;
                    zStream4 = this.z;
                    i5 = zStream4.avail_in;
                    if (i5 == 0) {
                        return iProc;
                    }
                    zStream4.avail_in = i5 - 1;
                    zStream4.total_in++;
                    long j117 = this.need;
                    byte[] bArr114 = zStream4.next_in;
                    int i212 = zStream4.next_in_index;
                    zStream4.next_in_index = i212 + 1;
                    j = j117 + (((long) bArr114[i212]) & 255);
                    this.need = j;
                    i6 = this.flags;
                    if (i6 != 0) {
                        this.need = (((65535 & j) << 24) | (((-16777216) & j) >> 24) | ((j & 16711680) >> c) | ((j & 65280) << c)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                    }
                    i7 = (int) this.was;
                    j2 = this.need;
                    if (i7 != ((int) j2)) {
                        zStream4.msg = "incorrect data check";
                    } else if (i6 != 0) {
                        gZIPHeader.crc = j2;
                    }
                    this.mode = 15;
                    iProc = i12;
                    if (this.wrap != 0) {
                    }
                    str = this.z.msg;
                    if (str != null) {
                    }
                    this.mode = 12;
                    return 1;
                case 11:
                    c = '\b';
                    zStream4 = this.z;
                    i5 = zStream4.avail_in;
                    if (i5 == 0) {
                        return iProc;
                    }
                    zStream4.avail_in = i5 - 1;
                    zStream4.total_in++;
                    long j118 = this.need;
                    byte[] bArr115 = zStream4.next_in;
                    int i213 = zStream4.next_in_index;
                    zStream4.next_in_index = i213 + 1;
                    j = j118 + (((long) bArr115[i213]) & 255);
                    this.need = j;
                    i6 = this.flags;
                    if (i6 != 0) {
                        this.need = (((65535 & j) << 24) | (((-16777216) & j) >> 24) | ((j & 16711680) >> c) | ((j & 65280) << c)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                    }
                    i7 = (int) this.was;
                    j2 = this.need;
                    if (i7 != ((int) j2)) {
                        zStream4.msg = "incorrect data check";
                    } else if (i6 != 0) {
                        gZIPHeader.crc = j2;
                    }
                    this.mode = 15;
                    iProc = i12;
                    if (this.wrap != 0) {
                    }
                    str = this.z.msg;
                    if (str != null) {
                    }
                    this.mode = 12;
                    return 1;
                case 12:
                    return 1;
                case 13:
                    return -3;
                case 14:
                    if (this.wrap != 0) {
                        iProc = readBytes(2, iProc, i12);
                        int i30 = this.wrap;
                        if ((i30 == 4 || (i30 & 2) != 0) && this.need == 35615) {
                            if (i30 == 4) {
                                this.wrap = 2;
                            }
                            this.z.adler = new CRC32();
                            checksum(2, this.need);
                            if (this.gheader == null) {
                                this.gheader = new GZIPHeader();
                            }
                            i13 = 23;
                            this.mode = i13;
                        } else {
                            if ((i30 & 2) == 0) {
                                this.flags = 0;
                                long j20 = this.need;
                                int i31 = (int) j20;
                                int i32 = i31 & 255;
                                this.method = i32;
                                int i33 = (int) (j20 >> 8);
                                int i34 = i33 & 255;
                                if (((i30 & 1) != 0 && ((i32 << 8) + i34) % 31 == 0) || (i31 & 15) == 8) {
                                    if ((i31 & 15) != 8) {
                                        this.mode = 13;
                                        zStream9 = this.z;
                                    } else {
                                        if (i30 == 4) {
                                            this.wrap = 1;
                                        }
                                        if ((i32 >> 4) + 8 > this.wbits) {
                                            this.mode = 13;
                                            zStream9 = this.z;
                                            str2 = "invalid window size";
                                        } else {
                                            this.z.adler = new Adler32();
                                            if ((i33 & 32) != 0) {
                                                this.mode = 2;
                                                zStream8 = this.z;
                                                i11 = zStream8.avail_in;
                                                if (i11 == 0) {
                                                    return iProc;
                                                }
                                                zStream8.avail_in = i11 - 1;
                                                zStream8.total_in++;
                                                byte[] bArr20 = zStream8.next_in;
                                                int i114 = zStream8.next_in_index;
                                                zStream8.next_in_index = i114 + 1;
                                                this.need = ((long) ((bArr20[i114] & GZIPHeader.OS_UNKNOWN) << 24)) & 4278190080L;
                                                this.mode = 3;
                                                iProc = i12;
                                                zStream7 = this.z;
                                                i10 = zStream7.avail_in;
                                                if (i10 == 0) {
                                                    return iProc;
                                                }
                                                zStream7.avail_in = i10 - 1;
                                                zStream7.total_in++;
                                                long j21 = this.need;
                                                byte[] bArr21 = zStream7.next_in;
                                                int i115 = zStream7.next_in_index;
                                                zStream7.next_in_index = i115 + 1;
                                                this.need = j21 + (((long) ((bArr21[i115] & GZIPHeader.OS_UNKNOWN) << 16)) & 16711680);
                                                this.mode = 4;
                                                iProc = i12;
                                                zStream6 = this.z;
                                                i9 = zStream6.avail_in;
                                                if (i9 == 0) {
                                                    return iProc;
                                                }
                                                zStream6.avail_in = i9 - 1;
                                                zStream6.total_in++;
                                                long j119 = this.need;
                                                byte[] bArr22 = zStream6.next_in;
                                                int i116 = zStream6.next_in_index;
                                                zStream6.next_in_index = i116 + 1;
                                                this.need = j119 + (((long) ((bArr22[i116] & GZIPHeader.OS_UNKNOWN) << 8)) & 65280);
                                                this.mode = 5;
                                                iProc = i12;
                                                zStream5 = this.z;
                                                i8 = zStream5.avail_in;
                                                if (i8 == 0) {
                                                    return iProc;
                                                }
                                                zStream5.avail_in = i8 - 1;
                                                zStream5.total_in++;
                                                long j120 = this.need;
                                                byte[] bArr116 = zStream5.next_in;
                                                int i117 = zStream5.next_in_index;
                                                zStream5.next_in_index = i117 + 1;
                                                long j121 = j120 + (((long) bArr116[i117]) & 255);
                                                this.need = j121;
                                                zStream5.adler.reset(j121);
                                                this.mode = 6;
                                                return 2;
                                            }
                                        }
                                    }
                                    zStream9.msg = str2;
                                } else if (i30 == 4) {
                                    ZStream zStream12 = this.z;
                                    zStream12.next_in_index -= 2;
                                    zStream12.avail_in += 2;
                                    zStream12.total_in -= 2;
                                    this.wrap = 0;
                                }
                            }
                            this.mode = 13;
                            zStream9 = this.z;
                            str2 = "incorrect header check";
                            zStream9.msg = str2;
                        }
                        break;
                    }
                    i13 = 7;
                    this.mode = i13;
                    break;
                case 15:
                    if (this.wrap != 0) {
                    }
                    str = this.z.msg;
                    if (str != null) {
                    }
                    this.mode = 12;
                    return 1;
                case 16:
                    iProc = readBytes(4, iProc, i12);
                    gZIPHeader11 = this.gheader;
                    if (gZIPHeader11 != null) {
                        gZIPHeader11.time = this.need;
                    }
                    if ((this.flags & 512) != 0) {
                        checksum(4, this.need);
                    }
                    this.mode = 17;
                    iProc = readBytes(2, iProc, i12);
                    gZIPHeader10 = this.gheader;
                    if (gZIPHeader10 != null) {
                        int i35 = (int) this.need;
                        gZIPHeader10.xflags = i35 & 255;
                        gZIPHeader10.os = (i35 >> 8) & 255;
                    }
                    if ((this.flags & 512) != 0) {
                        checksum(2, this.need);
                    }
                    this.mode = 18;
                    if ((this.flags & 1024) != 0) {
                        iProc = readBytes(2, iProc, i12);
                        gZIPHeader9 = this.gheader;
                        if (gZIPHeader9 != null) {
                            gZIPHeader9.extra = new byte[((int) this.need) & 65535];
                        }
                        if ((this.flags & 512) != 0) {
                            checksum(2, this.need);
                        }
                    } else {
                        gZIPHeader8 = this.gheader;
                        if (gZIPHeader8 != null) {
                            gZIPHeader8.extra = null;
                        }
                    }
                    this.mode = 19;
                    if ((this.flags & 1024) != 0) {
                        try {
                            iProc = readBytes(iProc, i12);
                            if (this.gheader != null) {
                                byteArray = this.tmp_string.toByteArray();
                                this.tmp_string = null;
                                length = byteArray.length;
                                bArr = this.gheader.extra;
                                if (length == bArr.length) {
                                    System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
                                } else {
                                    this.z.msg = "bad extra field length";
                                    this.mode = 13;
                                }
                                break;
                            }
                        } catch (Return e) {
                            return e.r;
                        }
                    } else {
                        gZIPHeader7 = this.gheader;
                        if (gZIPHeader7 != null) {
                            gZIPHeader7.extra = null;
                        }
                    }
                    this.mode = 20;
                    if ((this.flags & 2048) != 0) {
                        try {
                            iProc = readString(iProc, i12);
                            gZIPHeader5 = this.gheader;
                            if (gZIPHeader5 != null) {
                                gZIPHeader5.name = this.tmp_string.toByteArray();
                            }
                            this.tmp_string = null;
                        } catch (Return e2) {
                            return e2.r;
                        }
                    } else {
                        gZIPHeader6 = this.gheader;
                        if (gZIPHeader6 != null) {
                            gZIPHeader6.name = null;
                        }
                    }
                    this.mode = 21;
                    if ((this.flags & 4096) != 0) {
                        try {
                            iProc = readString(iProc, i12);
                            gZIPHeader3 = this.gheader;
                            if (gZIPHeader3 != null) {
                                gZIPHeader3.comment = this.tmp_string.toByteArray();
                            }
                            this.tmp_string = null;
                        } catch (Return e3) {
                            return e3.r;
                        }
                    } else {
                        gZIPHeader4 = this.gheader;
                        if (gZIPHeader4 != null) {
                            gZIPHeader4.comment = null;
                        }
                    }
                    this.mode = 22;
                    if ((this.flags & 512) != 0) {
                        iProc = readBytes(2, iProc, i12);
                        gZIPHeader2 = this.gheader;
                        if (gZIPHeader2 != null) {
                            gZIPHeader2.hcrc = (int) (this.need & 65535);
                        }
                        if (this.need != (65535 & this.z.adler.getValue())) {
                            this.mode = 13;
                            this.z.msg = "header crc mismatch";
                            this.marker = 5;
                            break;
                        }
                    }
                    this.z.adler = new CRC32();
                    i13 = 7;
                    this.mode = i13;
                    break;
                case 17:
                    iProc = readBytes(2, iProc, i12);
                    gZIPHeader10 = this.gheader;
                    if (gZIPHeader10 != null) {
                        int i36 = (int) this.need;
                        gZIPHeader10.xflags = i36 & 255;
                        gZIPHeader10.os = (i36 >> 8) & 255;
                    }
                    if ((this.flags & 512) != 0) {
                        checksum(2, this.need);
                    }
                    this.mode = 18;
                    if ((this.flags & 1024) != 0) {
                        iProc = readBytes(2, iProc, i12);
                        gZIPHeader9 = this.gheader;
                        if (gZIPHeader9 != null) {
                            gZIPHeader9.extra = new byte[((int) this.need) & 65535];
                        }
                        if ((this.flags & 512) != 0) {
                            checksum(2, this.need);
                        }
                    } else {
                        gZIPHeader8 = this.gheader;
                        if (gZIPHeader8 != null) {
                            gZIPHeader8.extra = null;
                        }
                    }
                    this.mode = 19;
                    if ((this.flags & 1024) != 0) {
                        iProc = readBytes(iProc, i12);
                        if (this.gheader != null) {
                            byteArray = this.tmp_string.toByteArray();
                            this.tmp_string = null;
                            length = byteArray.length;
                            bArr = this.gheader.extra;
                            if (length == bArr.length) {
                                System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
                            } else {
                                this.z.msg = "bad extra field length";
                                this.mode = 13;
                            }
                            break;
                        }
                    } else {
                        gZIPHeader7 = this.gheader;
                        if (gZIPHeader7 != null) {
                            gZIPHeader7.extra = null;
                        }
                    }
                    this.mode = 20;
                    if ((this.flags & 2048) != 0) {
                        iProc = readString(iProc, i12);
                        gZIPHeader5 = this.gheader;
                        if (gZIPHeader5 != null) {
                            gZIPHeader5.name = this.tmp_string.toByteArray();
                        }
                        this.tmp_string = null;
                    } else {
                        gZIPHeader6 = this.gheader;
                        if (gZIPHeader6 != null) {
                            gZIPHeader6.name = null;
                        }
                    }
                    this.mode = 21;
                    if ((this.flags & 4096) != 0) {
                        iProc = readString(iProc, i12);
                        gZIPHeader3 = this.gheader;
                        if (gZIPHeader3 != null) {
                            gZIPHeader3.comment = this.tmp_string.toByteArray();
                        }
                        this.tmp_string = null;
                    } else {
                        gZIPHeader4 = this.gheader;
                        if (gZIPHeader4 != null) {
                            gZIPHeader4.comment = null;
                        }
                    }
                    this.mode = 22;
                    if ((this.flags & 512) != 0) {
                        iProc = readBytes(2, iProc, i12);
                        gZIPHeader2 = this.gheader;
                        if (gZIPHeader2 != null) {
                            gZIPHeader2.hcrc = (int) (this.need & 65535);
                        }
                        if (this.need != (65535 & this.z.adler.getValue())) {
                            this.mode = 13;
                            this.z.msg = "header crc mismatch";
                            this.marker = 5;
                            break;
                        }
                    }
                    this.z.adler = new CRC32();
                    i13 = 7;
                    this.mode = i13;
                    break;
                case 18:
                    if ((this.flags & 1024) != 0) {
                        iProc = readBytes(2, iProc, i12);
                        gZIPHeader9 = this.gheader;
                        if (gZIPHeader9 != null) {
                            gZIPHeader9.extra = new byte[((int) this.need) & 65535];
                        }
                        if ((this.flags & 512) != 0) {
                            checksum(2, this.need);
                        }
                    } else {
                        gZIPHeader8 = this.gheader;
                        if (gZIPHeader8 != null) {
                            gZIPHeader8.extra = null;
                        }
                    }
                    this.mode = 19;
                    if ((this.flags & 1024) != 0) {
                        iProc = readBytes(iProc, i12);
                        if (this.gheader != null) {
                            byteArray = this.tmp_string.toByteArray();
                            this.tmp_string = null;
                            length = byteArray.length;
                            bArr = this.gheader.extra;
                            if (length == bArr.length) {
                                System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
                            } else {
                                this.z.msg = "bad extra field length";
                                this.mode = 13;
                            }
                            break;
                        }
                    } else {
                        gZIPHeader7 = this.gheader;
                        if (gZIPHeader7 != null) {
                            gZIPHeader7.extra = null;
                        }
                    }
                    this.mode = 20;
                    if ((this.flags & 2048) != 0) {
                        iProc = readString(iProc, i12);
                        gZIPHeader5 = this.gheader;
                        if (gZIPHeader5 != null) {
                            gZIPHeader5.name = this.tmp_string.toByteArray();
                        }
                        this.tmp_string = null;
                    } else {
                        gZIPHeader6 = this.gheader;
                        if (gZIPHeader6 != null) {
                            gZIPHeader6.name = null;
                        }
                    }
                    this.mode = 21;
                    if ((this.flags & 4096) != 0) {
                        iProc = readString(iProc, i12);
                        gZIPHeader3 = this.gheader;
                        if (gZIPHeader3 != null) {
                            gZIPHeader3.comment = this.tmp_string.toByteArray();
                        }
                        this.tmp_string = null;
                    } else {
                        gZIPHeader4 = this.gheader;
                        if (gZIPHeader4 != null) {
                            gZIPHeader4.comment = null;
                        }
                    }
                    this.mode = 22;
                    if ((this.flags & 512) != 0) {
                        iProc = readBytes(2, iProc, i12);
                        gZIPHeader2 = this.gheader;
                        if (gZIPHeader2 != null) {
                            gZIPHeader2.hcrc = (int) (this.need & 65535);
                        }
                        if (this.need != (65535 & this.z.adler.getValue())) {
                            this.mode = 13;
                            this.z.msg = "header crc mismatch";
                            this.marker = 5;
                            break;
                        }
                    }
                    this.z.adler = new CRC32();
                    i13 = 7;
                    this.mode = i13;
                    break;
                case 19:
                    if ((this.flags & 1024) != 0) {
                        iProc = readBytes(iProc, i12);
                        if (this.gheader != null) {
                            byteArray = this.tmp_string.toByteArray();
                            this.tmp_string = null;
                            length = byteArray.length;
                            bArr = this.gheader.extra;
                            if (length == bArr.length) {
                                System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
                            } else {
                                this.z.msg = "bad extra field length";
                                this.mode = 13;
                            }
                            break;
                        }
                    } else {
                        gZIPHeader7 = this.gheader;
                        if (gZIPHeader7 != null) {
                            gZIPHeader7.extra = null;
                        }
                    }
                    this.mode = 20;
                    if ((this.flags & 2048) != 0) {
                        iProc = readString(iProc, i12);
                        gZIPHeader5 = this.gheader;
                        if (gZIPHeader5 != null) {
                            gZIPHeader5.name = this.tmp_string.toByteArray();
                        }
                        this.tmp_string = null;
                    } else {
                        gZIPHeader6 = this.gheader;
                        if (gZIPHeader6 != null) {
                            gZIPHeader6.name = null;
                        }
                    }
                    this.mode = 21;
                    if ((this.flags & 4096) != 0) {
                        iProc = readString(iProc, i12);
                        gZIPHeader3 = this.gheader;
                        if (gZIPHeader3 != null) {
                            gZIPHeader3.comment = this.tmp_string.toByteArray();
                        }
                        this.tmp_string = null;
                    } else {
                        gZIPHeader4 = this.gheader;
                        if (gZIPHeader4 != null) {
                            gZIPHeader4.comment = null;
                        }
                    }
                    this.mode = 22;
                    if ((this.flags & 512) != 0) {
                        iProc = readBytes(2, iProc, i12);
                        gZIPHeader2 = this.gheader;
                        if (gZIPHeader2 != null) {
                            gZIPHeader2.hcrc = (int) (this.need & 65535);
                        }
                        if (this.need != (65535 & this.z.adler.getValue())) {
                            this.mode = 13;
                            this.z.msg = "header crc mismatch";
                            this.marker = 5;
                            break;
                        }
                    }
                    this.z.adler = new CRC32();
                    i13 = 7;
                    this.mode = i13;
                    break;
                case 20:
                    if ((this.flags & 2048) != 0) {
                        iProc = readString(iProc, i12);
                        gZIPHeader5 = this.gheader;
                        if (gZIPHeader5 != null) {
                            gZIPHeader5.name = this.tmp_string.toByteArray();
                        }
                        this.tmp_string = null;
                    } else {
                        gZIPHeader6 = this.gheader;
                        if (gZIPHeader6 != null) {
                            gZIPHeader6.name = null;
                        }
                    }
                    this.mode = 21;
                    if ((this.flags & 4096) != 0) {
                        iProc = readString(iProc, i12);
                        gZIPHeader3 = this.gheader;
                        if (gZIPHeader3 != null) {
                            gZIPHeader3.comment = this.tmp_string.toByteArray();
                        }
                        this.tmp_string = null;
                    } else {
                        gZIPHeader4 = this.gheader;
                        if (gZIPHeader4 != null) {
                            gZIPHeader4.comment = null;
                        }
                    }
                    this.mode = 22;
                    if ((this.flags & 512) != 0) {
                        iProc = readBytes(2, iProc, i12);
                        gZIPHeader2 = this.gheader;
                        if (gZIPHeader2 != null) {
                            gZIPHeader2.hcrc = (int) (this.need & 65535);
                        }
                        if (this.need != (65535 & this.z.adler.getValue())) {
                            this.mode = 13;
                            this.z.msg = "header crc mismatch";
                            this.marker = 5;
                            break;
                        }
                    }
                    this.z.adler = new CRC32();
                    i13 = 7;
                    this.mode = i13;
                    break;
                case 21:
                    if ((this.flags & 4096) != 0) {
                        iProc = readString(iProc, i12);
                        gZIPHeader3 = this.gheader;
                        if (gZIPHeader3 != null) {
                            gZIPHeader3.comment = this.tmp_string.toByteArray();
                        }
                        this.tmp_string = null;
                    } else {
                        gZIPHeader4 = this.gheader;
                        if (gZIPHeader4 != null) {
                            gZIPHeader4.comment = null;
                        }
                    }
                    this.mode = 22;
                    if ((this.flags & 512) != 0) {
                        iProc = readBytes(2, iProc, i12);
                        gZIPHeader2 = this.gheader;
                        if (gZIPHeader2 != null) {
                            gZIPHeader2.hcrc = (int) (this.need & 65535);
                        }
                        if (this.need != (65535 & this.z.adler.getValue())) {
                            this.mode = 13;
                            this.z.msg = "header crc mismatch";
                            this.marker = 5;
                            break;
                        }
                    }
                    this.z.adler = new CRC32();
                    i13 = 7;
                    this.mode = i13;
                    break;
                case 22:
                    if ((this.flags & 512) != 0) {
                        iProc = readBytes(2, iProc, i12);
                        gZIPHeader2 = this.gheader;
                        if (gZIPHeader2 != null) {
                            gZIPHeader2.hcrc = (int) (this.need & 65535);
                        }
                        if (this.need != (65535 & this.z.adler.getValue())) {
                            this.mode = 13;
                            this.z.msg = "header crc mismatch";
                            this.marker = 5;
                            break;
                        }
                    }
                    this.z.adler = new CRC32();
                    i13 = 7;
                    this.mode = i13;
                    break;
                case 23:
                    try {
                        iProc = readBytes(2, iProc, i12);
                        long j22 = this.need;
                        int i37 = (int) j22;
                        this.flags = i37 & 65535;
                        if ((i37 & 255) == 8) {
                            if ((57344 & i37) == 0) {
                                if ((i37 & 512) != 0) {
                                    checksum(2, j22);
                                }
                                this.mode = 16;
                                iProc = readBytes(4, iProc, i12);
                                gZIPHeader11 = this.gheader;
                                if (gZIPHeader11 != null) {
                                    gZIPHeader11.time = this.need;
                                }
                                if ((this.flags & 512) != 0) {
                                    checksum(4, this.need);
                                }
                                this.mode = 17;
                                iProc = readBytes(2, iProc, i12);
                                gZIPHeader10 = this.gheader;
                                if (gZIPHeader10 != null) {
                                    int i38 = (int) this.need;
                                    gZIPHeader10.xflags = i38 & 255;
                                    gZIPHeader10.os = (i38 >> 8) & 255;
                                }
                                if ((this.flags & 512) != 0) {
                                    checksum(2, this.need);
                                }
                                this.mode = 18;
                                if ((this.flags & 1024) != 0) {
                                    iProc = readBytes(2, iProc, i12);
                                    gZIPHeader9 = this.gheader;
                                    if (gZIPHeader9 != null) {
                                        gZIPHeader9.extra = new byte[((int) this.need) & 65535];
                                    }
                                    if ((this.flags & 512) != 0) {
                                        checksum(2, this.need);
                                    }
                                } else {
                                    gZIPHeader8 = this.gheader;
                                    if (gZIPHeader8 != null) {
                                        gZIPHeader8.extra = null;
                                    }
                                }
                                this.mode = 19;
                                if ((this.flags & 1024) != 0) {
                                    iProc = readBytes(iProc, i12);
                                    if (this.gheader != null) {
                                        byteArray = this.tmp_string.toByteArray();
                                        this.tmp_string = null;
                                        length = byteArray.length;
                                        bArr = this.gheader.extra;
                                        if (length == bArr.length) {
                                            System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
                                        } else {
                                            this.z.msg = "bad extra field length";
                                            this.mode = 13;
                                        }
                                        break;
                                    }
                                } else {
                                    gZIPHeader7 = this.gheader;
                                    if (gZIPHeader7 != null) {
                                        gZIPHeader7.extra = null;
                                    }
                                }
                                this.mode = 20;
                                if ((this.flags & 2048) != 0) {
                                    iProc = readString(iProc, i12);
                                    gZIPHeader5 = this.gheader;
                                    if (gZIPHeader5 != null) {
                                        gZIPHeader5.name = this.tmp_string.toByteArray();
                                    }
                                    this.tmp_string = null;
                                } else {
                                    gZIPHeader6 = this.gheader;
                                    if (gZIPHeader6 != null) {
                                        gZIPHeader6.name = null;
                                    }
                                }
                                this.mode = 21;
                                if ((this.flags & 4096) != 0) {
                                    iProc = readString(iProc, i12);
                                    gZIPHeader3 = this.gheader;
                                    if (gZIPHeader3 != null) {
                                        gZIPHeader3.comment = this.tmp_string.toByteArray();
                                    }
                                    this.tmp_string = null;
                                } else {
                                    gZIPHeader4 = this.gheader;
                                    if (gZIPHeader4 != null) {
                                        gZIPHeader4.comment = null;
                                    }
                                }
                                this.mode = 22;
                                if ((this.flags & 512) != 0) {
                                    iProc = readBytes(2, iProc, i12);
                                    gZIPHeader2 = this.gheader;
                                    if (gZIPHeader2 != null) {
                                        gZIPHeader2.hcrc = (int) (this.need & 65535);
                                    }
                                    if (this.need != (65535 & this.z.adler.getValue())) {
                                        this.mode = 13;
                                        this.z.msg = "header crc mismatch";
                                        this.marker = 5;
                                        break;
                                    }
                                }
                                this.z.adler = new CRC32();
                                i13 = 7;
                                this.mode = i13;
                            } else {
                                str2 = "unknown header flags set";
                            }
                            break;
                        }
                        this.z.msg = str2;
                        this.mode = i13;
                    } catch (Return e4) {
                        return e4.r;
                    }
                    break;
                default:
                    return -2;
            }
        }
    }

    public int inflateEnd() {
        InfBlocks infBlocks = this.blocks;
        if (infBlocks == null) {
            return 0;
        }
        infBlocks.free();
        return 0;
    }

    public int inflateInit(int i) {
        ZStream zStream = this.z;
        zStream.msg = null;
        this.blocks = null;
        this.wrap = 0;
        if (i < 0) {
            i = -i;
        } else if ((INFLATE_ANY & i) != 0) {
            this.wrap = 4;
            i &= -1073741825;
            if (i < 48) {
                i &= 15;
            }
        } else {
            if ((i & (-32)) != 0) {
                this.wrap = 4;
            } else {
                this.wrap = (i >> 4) + 1;
                if (i < 48) {
                }
            }
            i &= 15;
        }
        if (i < 8 || i > 15) {
            inflateEnd();
            return -2;
        }
        this.wbits = i;
        this.blocks = new InfBlocks(zStream, 1 << i);
        inflateReset();
        return 0;
    }

    public int inflateReset() {
        ZStream zStream = this.z;
        if (zStream == null) {
            return -2;
        }
        zStream.total_out = 0L;
        zStream.total_in = 0L;
        zStream.msg = null;
        this.mode = 14;
        this.need_bytes = -1;
        this.blocks.reset();
        return 0;
    }

    public int inflateSetDictionary(byte[] bArr, int i) {
        int i2;
        int i3;
        ZStream zStream = this.z;
        if (zStream == null) {
            return -2;
        }
        int i4 = this.mode;
        if (i4 != 6 && this.wrap != 0) {
            return -2;
        }
        if (i4 == 6) {
            long value = zStream.adler.getValue();
            this.z.adler.reset();
            this.z.adler.update(bArr, 0, i);
            if (this.z.adler.getValue() != value) {
                return -3;
            }
        }
        this.z.adler.reset();
        int i5 = 1 << this.wbits;
        if (i >= i5) {
            i2 = i5 - 1;
            i3 = i - i2;
        } else {
            i2 = i;
            i3 = 0;
        }
        this.blocks.set_dictionary(bArr, i3, i2);
        this.mode = 7;
        return 0;
    }

    public int inflateSync() {
        ZStream zStream = this.z;
        if (zStream == null) {
            return -2;
        }
        if (this.mode != 13) {
            this.mode = 13;
            this.marker = 0;
        }
        int i = zStream.avail_in;
        if (i == 0) {
            return -5;
        }
        int i2 = zStream.next_in_index;
        int i3 = this.marker;
        while (i != 0 && i3 < 4) {
            byte b = this.z.next_in[i2];
            if (b == mark[i3]) {
                i3++;
            } else {
                i3 = b != 0 ? 0 : 4 - i3;
            }
            i2++;
            i--;
        }
        ZStream zStream2 = this.z;
        long j = zStream2.total_in + ((long) (i2 - zStream2.next_in_index));
        zStream2.total_in = j;
        zStream2.next_in_index = i2;
        zStream2.avail_in = i;
        this.marker = i3;
        if (i3 != 4) {
            return -3;
        }
        long j2 = zStream2.total_out;
        inflateReset();
        ZStream zStream3 = this.z;
        zStream3.total_in = j;
        zStream3.total_out = j2;
        this.mode = 7;
        return 0;
    }

    public int inflateSyncPoint() {
        InfBlocks infBlocks;
        if (this.z == null || (infBlocks = this.blocks) == null) {
            return -2;
        }
        return infBlocks.sync_point();
    }
}
