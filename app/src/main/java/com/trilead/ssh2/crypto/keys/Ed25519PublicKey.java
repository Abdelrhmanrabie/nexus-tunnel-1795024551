package com.trilead.ssh2.crypto.keys;

import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.packets.TypesWriter;
import defpackage.ak;
import java.io.IOException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Ed25519PublicKey implements PublicKey {
    private static final byte[] ED25519_OID = {43, 101, 112};
    private static final int ENCODED_SIZE = 44;
    private static final int KEY_BYTES_LENGTH = 32;
    private final byte[] keyBytes;

    public Ed25519PublicKey(X509EncodedKeySpec x509EncodedKeySpec) {
        this.keyBytes = decode(x509EncodedKeySpec.getEncoded());
    }

    public Ed25519PublicKey(byte[] bArr) {
        this.keyBytes = bArr;
    }

    private static byte[] decode(byte[] bArr) throws InvalidKeySpecException {
        if (bArr.length != 44) {
            throw new InvalidKeySpecException("Key is not of correct size");
        }
        try {
            TypesReader typesReader = new TypesReader(bArr);
            if (typesReader.readByte() == 48) {
                int i = typesReader.readByte();
                byte[] bArr2 = ED25519_OID;
                if (i == bArr2.length + 39 && typesReader.readByte() == 48 && typesReader.readByte() == bArr2.length + 2 && typesReader.readByte() == 6 && typesReader.readByte() == bArr2.length) {
                    if (Arrays.equals(typesReader.readBytes(bArr2.length), bArr2) && typesReader.readByte() == 3 && typesReader.readByte() == 33 && typesReader.readByte() == 0) {
                        return typesReader.readBytes(32);
                    }
                    throw new InvalidKeySpecException("Key was not encoded correctly");
                }
            }
            throw new InvalidKeySpecException("Key was not encoded correctly");
        } catch (IOException unused) {
            throw new InvalidKeySpecException("Key was not encoded correctly");
        }
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (!(obj instanceof Ed25519PublicKey)) {
            return false;
        }
        Ed25519PublicKey ed25519PublicKey = (Ed25519PublicKey) obj;
        byte[] bArr2 = this.keyBytes;
        if (bArr2 == null || (bArr = ed25519PublicKey.keyBytes) == null) {
            return false;
        }
        return Arrays.equals(bArr2, bArr);
    }

    public byte[] getAbyte() {
        return this.keyBytes;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "EdDSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        TypesWriter typesWriterI = ak.i(48);
        byte[] bArr = ED25519_OID;
        typesWriterI.writeByte(bArr.length + 7 + this.keyBytes.length);
        typesWriterI.writeByte(48);
        typesWriterI.writeByte(bArr.length + 2);
        typesWriterI.writeByte(6);
        typesWriterI.writeByte(bArr.length);
        typesWriterI.writeBytes(bArr);
        typesWriterI.writeByte(3);
        typesWriterI.writeByte(this.keyBytes.length + 1);
        typesWriterI.writeByte(0);
        typesWriterI.writeBytes(this.keyBytes);
        return typesWriterI.getBytes();
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return Arrays.hashCode(this.keyBytes);
    }
}
