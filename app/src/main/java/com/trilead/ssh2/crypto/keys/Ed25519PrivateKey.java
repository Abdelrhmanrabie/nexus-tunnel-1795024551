package com.trilead.ssh2.crypto.keys;

import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.packets.TypesWriter;
import defpackage.ak;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Ed25519PrivateKey implements PrivateKey {
    private static final byte[] ED25519_OID = {43, 101, 112};
    private static final int ENCODED_SIZE = 48;
    private static final int KEY_BYTES_LENGTH = 32;
    private boolean destroyed;
    private final byte[] seed;

    public Ed25519PrivateKey(PKCS8EncodedKeySpec pKCS8EncodedKeySpec) {
        this.seed = decode(pKCS8EncodedKeySpec);
    }

    public Ed25519PrivateKey(byte[] bArr) {
        this.seed = bArr;
    }

    private static byte[] decode(PKCS8EncodedKeySpec pKCS8EncodedKeySpec) throws InvalidKeySpecException {
        if (pKCS8EncodedKeySpec.getEncoded().length != 48) {
            throw new InvalidKeySpecException("Key spec is of invalid size");
        }
        try {
            TypesReader typesReader = new TypesReader(pKCS8EncodedKeySpec.getEncoded());
            if (typesReader.readByte() == 48 && typesReader.readByte() == 46 && typesReader.readByte() == 2 && typesReader.readByte() == 1 && typesReader.readByte() == 0 && typesReader.readByte() == 48) {
                int i = typesReader.readByte();
                byte[] bArr = ED25519_OID;
                if (i == bArr.length + 2 && typesReader.readByte() == 6 && typesReader.readByte() == bArr.length) {
                    if (Arrays.equals(bArr, typesReader.readBytes(bArr.length)) && typesReader.readByte() == 4 && typesReader.readByte() == 34 && typesReader.readByte() == 4 && typesReader.readByte() == 32) {
                        return typesReader.readBytes(32);
                    }
                    throw new InvalidKeySpecException("Key was not encoded correctly");
                }
            }
            throw new InvalidKeySpecException("Key was not encoded correctly");
        } catch (IOException e) {
            throw new InvalidKeySpecException("Key was not encoded correctly", e);
        }
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        Arrays.fill(this.seed, (byte) 0);
        this.destroyed = true;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj instanceof Ed25519PrivateKey) {
            Ed25519PrivateKey ed25519PrivateKey = (Ed25519PrivateKey) obj;
            byte[] bArr2 = this.seed;
            if (bArr2 != null && (bArr = ed25519PrivateKey.seed) != null && bArr2.length == bArr.length) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = this.seed;
                    if (i >= bArr3.length) {
                        break;
                    }
                    i2 |= bArr3[i] ^ ed25519PrivateKey.seed[i];
                    i++;
                }
                if (i2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "EdDSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        TypesWriter typesWriterI = ak.i(48);
        byte[] bArr = ED25519_OID;
        typesWriterI.writeByte(bArr.length + 11 + this.seed.length);
        typesWriterI.writeByte(2);
        typesWriterI.writeByte(1);
        typesWriterI.writeByte(0);
        typesWriterI.writeByte(48);
        typesWriterI.writeByte(bArr.length + 2);
        typesWriterI.writeByte(6);
        typesWriterI.writeByte(bArr.length);
        typesWriterI.writeBytes(bArr);
        typesWriterI.writeByte(4);
        typesWriterI.writeByte(this.seed.length + 2);
        typesWriterI.writeByte(4);
        typesWriterI.writeByte(this.seed.length);
        typesWriterI.writeBytes(this.seed);
        return typesWriterI.getBytes();
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public int hashCode() {
        return Arrays.hashCode(this.seed);
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.destroyed;
    }
}
