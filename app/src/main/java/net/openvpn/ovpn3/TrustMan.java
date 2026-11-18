package net.openvpn.ovpn3;

import android.content.Context;
import defpackage.ak;
import defpackage.fb$1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.X509Certificate;
import java.util.Objects;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class TrustMan implements X509TrustManager {
    private static final String KEYSTORE_FILE = "trusted-certs.keystore";
    private static final String TAG = "TrustMan";
    private static int generation;
    private KeyStore appKeyStore;
    private X509TrustManager appTrustManager;
    private int current_generation;
    private X509TrustManager defaultTrustManager;
    private File keyStoreFile;
    private Callback parent;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface Callback {
        void onTrustFail(TrustContext trustContext);

        void onTrustSucceed(boolean z);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Error extends Exception {
        public Error(String str) {
            super(ak.m("TrustMan: ", str));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class TrustContext {
        public String authType;
        public X509Certificate[] chain;
        public CertificateException excep;

        public String toString() {
            return "TrustContext chain=" + this.chain + " authType=" + this.authType + " excep=" + this.excep;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class TrustFail extends CertificateException {
        public TrustFail(CertificateException certificateException) {
            super(certificateException);
        }
    }

    public TrustMan(Context context) throws Error {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir());
        this.keyStoreFile = new File(fb$1.m(sb, File.separator, KEYSTORE_FILE));
        reload();
    }

    private void callOnTrustSucceed(boolean z) {
        Callback callback = this.parent;
        if (callback != null) {
            callback.onTrustSucceed(z);
        }
    }

    private void checkCertTrusted(X509Certificate[] x509CertificateArr, String str, boolean z) throws TrustFail {
        check_reload();
        X509TrustManager x509TrustManager = this.appTrustManager;
        try {
            if (z) {
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
            } else {
                x509TrustManager.checkClientTrusted(x509CertificateArr, str);
            }
            callOnTrustSucceed(true);
        } catch (CertificateException e) {
            if (isExpiredException(e) || isCertKnown(x509CertificateArr[0])) {
                callOnTrustSucceed(true);
                return;
            }
            X509TrustManager x509TrustManager2 = this.defaultTrustManager;
            try {
                if (z) {
                    x509TrustManager2.checkServerTrusted(x509CertificateArr, str);
                } else {
                    x509TrustManager2.checkClientTrusted(x509CertificateArr, str);
                }
                callOnTrustSucceed(false);
            } catch (CertificateException e2) {
                TrustContext trustContext = new TrustContext();
                trustContext.chain = x509CertificateArr;
                trustContext.authType = str;
                trustContext.excep = e2;
                Callback callback = this.parent;
                if (callback != null) {
                    callback.onTrustFail(trustContext);
                }
                throw new TrustFail(e2);
            }
        }
    }

    private void check_reload() {
        try {
            if (this.current_generation != generation) {
                reload();
            }
        } catch (Error unused) {
        }
    }

    public static void forget_certs(Context context) {
        boolean zDeleteFile = context.deleteFile(KEYSTORE_FILE);
        generation++;
        String.format("forget certs: fn=%s status=%b gen=%d", KEYSTORE_FILE, Boolean.valueOf(zDeleteFile), Integer.valueOf(generation));
    }

    private X509TrustManager getTrustManager(KeyStore keyStore, String str) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            return null;
        } catch (Exception unused) {
            Objects.toString(keyStore);
            return null;
        }
    }

    private boolean isCertKnown(X509Certificate x509Certificate) {
        try {
            return this.appKeyStore.getCertificateAlias(x509Certificate) != null;
        } catch (KeyStoreException unused) {
            return false;
        }
    }

    private boolean isExpiredException(Throwable th) {
        while (!(th instanceof CertificateExpiredException)) {
            th = th.getCause();
            if (th == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTrustFail(Exception exc) {
        for (Throwable cause = exc; cause != null; cause = cause.getCause()) {
            if (cause instanceof TrustFail) {
                return true;
            }
        }
        return false;
    }

    private KeyStore loadAppKeyStore() {
        KeyStore keyStore = null;
        try {
            KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                try {
                    keyStore2.load(null, null);
                    keyStore2.load(new FileInputStream(this.keyStoreFile), "OpenVPN".toCharArray());
                    return keyStore2;
                } catch (KeyStoreException unused) {
                    keyStore = keyStore2;
                    return keyStore;
                }
            } catch (FileNotFoundException | Exception unused2) {
                Objects.toString(this.keyStoreFile);
                return keyStore2;
            }
        } catch (KeyStoreException unused3) {
        }
    }

    private void reload() throws Error {
        String.format("reload certs: gen=%d/%d", Integer.valueOf(this.current_generation), Integer.valueOf(generation));
        KeyStore keyStoreLoadAppKeyStore = loadAppKeyStore();
        if (keyStoreLoadAppKeyStore == null) {
            throw new Error("could not load appKeyStore");
        }
        X509TrustManager trustManager = getTrustManager(null, "default");
        if (trustManager == null) {
            throw new Error("could not load defaultTrustManager");
        }
        X509TrustManager trustManager2 = getTrustManager(keyStoreLoadAppKeyStore, "app-init");
        if (trustManager2 == null) {
            throw new Error("could not load appTrustManager");
        }
        this.current_generation = generation;
        this.appKeyStore = keyStoreLoadAppKeyStore;
        this.defaultTrustManager = trustManager;
        this.appTrustManager = trustManager2;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws TrustFail {
        checkCertTrusted(x509CertificateArr, str, false);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws TrustFail {
        checkCertTrusted(x509CertificateArr, str, true);
    }

    public void clearCallback() {
        this.parent = null;
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        check_reload();
        return this.defaultTrustManager.getAcceptedIssuers();
    }

    public void setCallback(Callback callback) {
        this.parent = callback;
    }

    public void trustCert(TrustContext trustContext) {
        trustContext.toString();
        try {
            this.appKeyStore.setCertificateEntry(trustContext.chain[0].getSubjectDN().toString(), trustContext.chain[0]);
            X509TrustManager trustManager = getTrustManager(this.appKeyStore, "app-reload");
            if (trustManager != null) {
                this.appTrustManager = trustManager;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.keyStoreFile);
                this.appKeyStore.store(fileOutputStream, "OpenVPN".toCharArray());
                fileOutputStream.close();
            } catch (Exception unused) {
                Objects.toString(this.keyStoreFile);
            }
        } catch (KeyStoreException unused2) {
        }
    }
}
