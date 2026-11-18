package com.google.crypto.tink.internal;

import com.google.crypto.tink.subtle.Hex;
import defpackage.g;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ed25519Constants {
    public static final Ed25519$CachedXYT[] B2;
    public static final Ed25519$CachedXYT[][] B_TABLE;
    public static final long[] D;
    public static final long[] D2;
    public static final BigInteger D2_BI;
    public static final BigInteger D_BI;
    public static final BigInteger P_BI;
    public static final long[] SQRTM1;

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        P_BI = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        D_BI = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        D2_BI = bigIntegerMod2;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(2L);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigIntegerModPow = bigIntegerValueOf.modPow(bigIntegerSubtract.subtract(bigInteger).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        g gVar = new g(6);
        BigInteger bigIntegerMod3 = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        gVar.b = bigIntegerMod3;
        BigInteger bigIntegerMultiply = bigIntegerMod3.pow(2).subtract(bigInteger).multiply(bigIntegerMod.multiply(bigIntegerMod3.pow(2)).add(bigInteger).modInverse(bigIntegerSubtract));
        BigInteger bigIntegerModPow2 = bigIntegerMultiply.modPow(bigIntegerSubtract.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigIntegerSubtract);
        if (!bigIntegerModPow2.pow(2).subtract(bigIntegerMultiply).mod(bigIntegerSubtract).equals(BigInteger.ZERO)) {
            bigIntegerModPow2 = bigIntegerModPow2.multiply(bigIntegerModPow).mod(bigIntegerSubtract);
        }
        if (bigIntegerModPow2.testBit(0)) {
            bigIntegerModPow2 = bigIntegerSubtract.subtract(bigIntegerModPow2);
        }
        gVar.a = bigIntegerModPow2;
        D = Hex.expand(toLittleEndian(bigIntegerMod));
        D2 = Hex.expand(toLittleEndian(bigIntegerMod2));
        SQRTM1 = Hex.expand(toLittleEndian(bigIntegerModPow));
        B_TABLE = (Ed25519$CachedXYT[][]) Array.newInstance((Class<?>) Ed25519$CachedXYT.class, 32, 8);
        g gVarEdwards = gVar;
        for (int i = 0; i < 32; i++) {
            g gVarEdwards2 = gVarEdwards;
            for (int i2 = 0; i2 < 8; i2++) {
                B_TABLE[i][i2] = getCachedXYT(gVarEdwards2);
                gVarEdwards2 = edwards(gVarEdwards2, gVarEdwards);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                gVarEdwards = edwards(gVarEdwards, gVarEdwards);
            }
        }
        g gVarEdwards3 = edwards(gVar, gVar);
        B2 = new Ed25519$CachedXYT[8];
        for (int i4 = 0; i4 < 8; i4++) {
            B2[i4] = getCachedXYT(gVar);
            gVar = edwards(gVar, gVarEdwards3);
        }
    }

    public static g edwards(g gVar, g gVar2) {
        g gVar3 = new g(6);
        BigInteger bigIntegerMultiply = D_BI.multiply(((BigInteger) gVar.a).multiply((BigInteger) gVar2.a).multiply((BigInteger) gVar.b).multiply((BigInteger) gVar2.b));
        BigInteger bigInteger = P_BI;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        BigInteger bigIntegerAdd = ((BigInteger) gVar.a).multiply((BigInteger) gVar2.b).add(((BigInteger) gVar2.a).multiply((BigInteger) gVar.b));
        BigInteger bigInteger2 = BigInteger.ONE;
        gVar3.a = bigIntegerAdd.multiply(bigInteger2.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        gVar3.b = ((BigInteger) gVar.b).multiply((BigInteger) gVar2.b).add(((BigInteger) gVar.a).multiply((BigInteger) gVar2.a)).multiply(bigInteger2.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        return gVar3;
    }

    public static Ed25519$CachedXYT getCachedXYT(g gVar) {
        BigInteger bigIntegerAdd = ((BigInteger) gVar.b).add((BigInteger) gVar.a);
        BigInteger bigInteger = P_BI;
        return new Ed25519$CachedXYT(Hex.expand(toLittleEndian(bigIntegerAdd.mod(bigInteger))), Hex.expand(toLittleEndian(((BigInteger) gVar.b).subtract((BigInteger) gVar.a).mod(bigInteger))), Hex.expand(toLittleEndian(D2_BI.multiply((BigInteger) gVar.a).multiply((BigInteger) gVar.b).mod(bigInteger))));
    }

    public static byte[] toLittleEndian(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            int i2 = 31 - i;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }
}
