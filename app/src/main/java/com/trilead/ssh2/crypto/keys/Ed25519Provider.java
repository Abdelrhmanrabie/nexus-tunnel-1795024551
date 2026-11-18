package com.trilead.ssh2.crypto.keys;

import defpackage.qp;
import java.security.AccessController;
import java.security.Provider;
import java.security.Security;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Ed25519Provider extends Provider {
    public static final String KEY_ALGORITHM = "Ed25519";
    private static final Object sInitLock = new Object();
    private static boolean sInitialized = false;

    public Ed25519Provider() {
        super("ConnectBot Ed25519 Provider", 1.0d, "Not for use elsewhere");
        AccessController.doPrivileged(new qp(0, this));
    }

    public static void insertIfNeeded() {
        synchronized (sInitLock) {
            try {
                if (!sInitialized) {
                    Security.addProvider(new Ed25519Provider());
                    sInitialized = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$0() {
        setup();
        return null;
    }

    public void setup() {
        put("KeyFactory.Ed25519", getClass().getPackage().getName() + ".Ed25519KeyFactory");
        put("KeyPairGenerator.Ed25519", getClass().getPackage().getName() + ".Ed25519KeyPairGenerator");
        put("Alg.Alias.KeyFactory.1.3.101.112", KEY_ALGORITHM);
        put("Alg.Alias.KeyFactory.EdDSA", KEY_ALGORITHM);
        put("Alg.Alias.KeyFactory.OID.1.3.101.112", KEY_ALGORITHM);
        put("Alg.Alias.KeyPairGenerator.1.3.101.112", KEY_ALGORITHM);
        put("Alg.Alias.KeyPairGenerator.EdDSA", KEY_ALGORITHM);
        put("Alg.Alias.KeyPairGenerator.OID.1.3.101.112", KEY_ALGORITHM);
    }
}
