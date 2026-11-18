package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Ed25519$CachedXYT;
import com.google.crypto.tink.internal.Ed25519$CachedXYZT;
import com.google.crypto.tink.internal.Ed25519$XYZT;
import com.google.crypto.tink.internal.Ed25519Constants;
import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.util.Bytes;
import com.jcraft.jzlib.GZIPHeader;
import defpackage.m6;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Ed25519Verify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility.AnonymousClass1 FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    public final Bytes publicKey;

    public Ed25519Verify(byte[] bArr) {
        FIPS.getClass();
        if (TinkFipsUtil.isRestrictedToFips.get()) {
            throw new IllegalStateException(new GeneralSecurityException("Can not use Ed25519 in FIPS-mode."));
        }
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Given public key's length is not 32.");
        }
        this.publicKey = new Bytes(bArr, bArr.length);
    }

    public final void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = bArr;
        if (bArr3.length != 64) {
            throw new GeneralSecurityException("The length of the signature is not 64.");
        }
        byte[] bArr4 = this.publicKey.data;
        byte[] bArr5 = new byte[bArr4.length];
        System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
        if (bArr3.length == 64) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr3, 32, 64);
            int i = 31;
            while (i >= 0) {
                int i2 = bArrCopyOfRange[i] & GZIPHeader.OS_UNKNOWN;
                int i3 = Hex.GROUP_ORDER[i] & GZIPHeader.OS_UNKNOWN;
                if (i2 != i3) {
                    if (i2 >= i3) {
                        break;
                    }
                    MessageDigest messageDigest = (MessageDigest) EngineFactory.MESSAGE_DIGEST.policy.getInstance();
                    messageDigest.update(bArr3, 0, 32);
                    messageDigest.update(bArr5);
                    messageDigest.update(bArr2);
                    byte[] bArrDigest = messageDigest.digest();
                    Hex.reduce(bArrDigest);
                    long[] jArr = new long[10];
                    long[] jArrExpand = Hex.expand(bArr5);
                    long[] jArr2 = new long[10];
                    jArr2[0] = 1;
                    long[] jArr3 = new long[10];
                    long[] jArr4 = new long[10];
                    long[] jArr5 = new long[10];
                    long[] jArr6 = new long[10];
                    long[] jArr7 = new long[10];
                    Hex.square(jArr4, jArrExpand);
                    Hex.mult(jArr5, jArr4, Ed25519Constants.D);
                    Hex.sub(jArr4, jArr4, jArr2);
                    Hex.sum(jArr5, jArr5, jArr2);
                    long[] jArr8 = new long[10];
                    Hex.square(jArr8, jArr5);
                    Hex.mult(jArr8, jArr8, jArr5);
                    Hex.square(jArr, jArr8);
                    Hex.mult(jArr, jArr, jArr5);
                    Hex.mult(jArr, jArr, jArr4);
                    long[] jArr9 = new long[10];
                    long[] jArr10 = new long[10];
                    long[] jArr11 = new long[10];
                    Hex.square(jArr9, jArr);
                    Hex.square(jArr10, jArr9);
                    Hex.square(jArr10, jArr10);
                    Hex.mult(jArr10, jArr, jArr10);
                    Hex.mult(jArr9, jArr9, jArr10);
                    Hex.square(jArr9, jArr9);
                    Hex.mult(jArr9, jArr10, jArr9);
                    Hex.square(jArr10, jArr9);
                    for (int i4 = 1; i4 < 5; i4++) {
                        Hex.square(jArr10, jArr10);
                    }
                    Hex.mult(jArr9, jArr10, jArr9);
                    Hex.square(jArr10, jArr9);
                    for (int i5 = 1; i5 < 10; i5++) {
                        Hex.square(jArr10, jArr10);
                    }
                    Hex.mult(jArr10, jArr10, jArr9);
                    Hex.square(jArr11, jArr10);
                    for (int i6 = 1; i6 < 20; i6++) {
                        Hex.square(jArr11, jArr11);
                    }
                    Hex.mult(jArr10, jArr11, jArr10);
                    Hex.square(jArr10, jArr10);
                    for (int i7 = 1; i7 < 10; i7++) {
                        Hex.square(jArr10, jArr10);
                    }
                    Hex.mult(jArr9, jArr10, jArr9);
                    Hex.square(jArr10, jArr9);
                    for (int i8 = 1; i8 < 50; i8++) {
                        Hex.square(jArr10, jArr10);
                    }
                    Hex.mult(jArr10, jArr10, jArr9);
                    Hex.square(jArr11, jArr10);
                    for (int i9 = 1; i9 < 100; i9++) {
                        Hex.square(jArr11, jArr11);
                    }
                    Hex.mult(jArr10, jArr11, jArr10);
                    Hex.square(jArr10, jArr10);
                    for (int i10 = 1; i10 < 50; i10++) {
                        Hex.square(jArr10, jArr10);
                    }
                    Hex.mult(jArr9, jArr10, jArr9);
                    Hex.square(jArr9, jArr9);
                    Hex.square(jArr9, jArr9);
                    Hex.mult(jArr, jArr9, jArr);
                    Hex.mult(jArr, jArr, jArr8);
                    Hex.mult(jArr, jArr, jArr4);
                    Hex.square(jArr6, jArr);
                    Hex.mult(jArr6, jArr6, jArr5);
                    Hex.sub(jArr7, jArr6, jArr4);
                    if (Hex.access$200(jArr7)) {
                        Hex.sum(jArr7, jArr6, jArr4);
                        if (Hex.access$200(jArr7)) {
                            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                        }
                        Hex.mult(jArr, jArr, Ed25519Constants.SQRTM1);
                    }
                    if (!Hex.access$200(jArr) && ((bArr5[31] & GZIPHeader.OS_UNKNOWN) >> 7) != 0) {
                        throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
                    }
                    if ((Hex.contract(jArr)[0] & 1) == ((bArr5[31] & GZIPHeader.OS_UNKNOWN) >> 7)) {
                        for (int i11 = 0; i11 < 10; i11++) {
                            jArr[i11] = -jArr[i11];
                        }
                    }
                    Hex.mult(jArr3, jArr, jArrExpand);
                    m6 m6Var = new m6(jArr, jArrExpand, jArr2);
                    final Ed25519$XYZT ed25519$XYZT = new Ed25519$XYZT(m6Var, jArr3);
                    Ed25519$CachedXYT[] ed25519$CachedXYTArr = new Ed25519$CachedXYZT[8];
                    ed25519$CachedXYTArr[0] = new Ed25519$CachedXYT(ed25519$XYZT) { // from class: com.google.crypto.tink.internal.Ed25519$CachedXYZT
                        public final long[] z;

                        /* JADX WARN: Illegal instructions before constructor call */
                        {
                            long[] jArr12 = new long[10];
                            long[] jArr13 = new long[10];
                            long[] jArr14 = new long[10];
                            long[] jArr15 = new long[10];
                            super(jArr12, jArr13, jArr15);
                            this.z = jArr14;
                            m6 m6Var2 = ed25519$XYZT.xyz;
                            Hex.sum(jArr12, (long[]) m6Var2.b, (long[]) m6Var2.a);
                            Hex.sub(jArr13, (long[]) m6Var2.b, (long[]) m6Var2.a);
                            System.arraycopy((long[]) m6Var2.c, 0, jArr14, 0, 10);
                            Hex.mult(jArr15, ed25519$XYZT.t, Ed25519Constants.D2);
                        }

                        @Override // com.google.crypto.tink.internal.Ed25519$CachedXYT
                        public final void multByZ(long[] jArr12, long[] jArr13) {
                            Hex.mult(jArr12, jArr13, this.z);
                        }
                    };
                    Ed25519$XYZT ed25519$XYZT2 = new Ed25519$XYZT(new m6(3), new long[10]);
                    Hex.doubleXYZ(ed25519$XYZT2, m6Var);
                    Ed25519$XYZT ed25519$XYZT3 = new Ed25519$XYZT(ed25519$XYZT2);
                    for (int i12 = 1; i12 < 8; i12++) {
                        Hex.add(ed25519$XYZT2, ed25519$XYZT3, ed25519$CachedXYTArr[i12 - 1]);
                        final Ed25519$XYZT ed25519$XYZT4 = new Ed25519$XYZT(ed25519$XYZT2);
                        ed25519$CachedXYTArr[i12] = new Ed25519$CachedXYT(ed25519$XYZT4) { // from class: com.google.crypto.tink.internal.Ed25519$CachedXYZT
                            public final long[] z;

                            /* JADX WARN: Illegal instructions before constructor call */
                            {
                                long[] jArr12 = new long[10];
                                long[] jArr13 = new long[10];
                                long[] jArr14 = new long[10];
                                long[] jArr15 = new long[10];
                                super(jArr12, jArr13, jArr15);
                                this.z = jArr14;
                                m6 m6Var2 = ed25519$XYZT4.xyz;
                                Hex.sum(jArr12, (long[]) m6Var2.b, (long[]) m6Var2.a);
                                Hex.sub(jArr13, (long[]) m6Var2.b, (long[]) m6Var2.a);
                                System.arraycopy((long[]) m6Var2.c, 0, jArr14, 0, 10);
                                Hex.mult(jArr15, ed25519$XYZT4.t, Ed25519Constants.D2);
                            }

                            @Override // com.google.crypto.tink.internal.Ed25519$CachedXYT
                            public final void multByZ(long[] jArr12, long[] jArr13) {
                                Hex.mult(jArr12, jArr13, this.z);
                            }
                        };
                    }
                    byte[] bArrSlide = Hex.slide(bArrDigest);
                    byte[] bArrSlide2 = Hex.slide(bArrCopyOfRange);
                    Ed25519$XYZT ed25519$XYZT5 = new Ed25519$XYZT(1);
                    Ed25519$XYZT ed25519$XYZT6 = new Ed25519$XYZT(0);
                    int i13 = 255;
                    while (i13 >= 0 && bArrSlide[i13] == 0 && bArrSlide2[i13] == 0) {
                        i13--;
                    }
                    while (i13 >= 0) {
                        Hex.doubleXYZ(ed25519$XYZT5, new m6(ed25519$XYZT5));
                        byte b = bArrSlide[i13];
                        if (b > 0) {
                            Ed25519$XYZT.fromPartialXYZT(ed25519$XYZT6, ed25519$XYZT5);
                            Hex.add(ed25519$XYZT5, ed25519$XYZT6, ed25519$CachedXYTArr[bArrSlide[i13] / 2]);
                        } else if (b < 0) {
                            Ed25519$XYZT.fromPartialXYZT(ed25519$XYZT6, ed25519$XYZT5);
                            Hex.sub(ed25519$XYZT5, ed25519$XYZT6, ed25519$CachedXYTArr[(-bArrSlide[i13]) / 2]);
                        }
                        byte b2 = bArrSlide2[i13];
                        if (b2 > 0) {
                            Ed25519$XYZT.fromPartialXYZT(ed25519$XYZT6, ed25519$XYZT5);
                            Hex.add(ed25519$XYZT5, ed25519$XYZT6, Ed25519Constants.B2[bArrSlide2[i13] / 2]);
                        } else if (b2 < 0) {
                            Ed25519$XYZT.fromPartialXYZT(ed25519$XYZT6, ed25519$XYZT5);
                            Hex.sub(ed25519$XYZT5, ed25519$XYZT6, Ed25519Constants.B2[(-bArrSlide2[i13]) / 2]);
                        }
                        i13--;
                    }
                    byte[] bytes = new m6(ed25519$XYZT5).toBytes();
                    for (int i14 = 0; i14 < 32; i14++) {
                        if (bytes[i14] != bArr[i14]) {
                            break;
                        }
                    }
                    return;
                }
                i--;
                bArr3 = bArr;
            }
        }
        throw new GeneralSecurityException("Signature check failed.");
    }
}
