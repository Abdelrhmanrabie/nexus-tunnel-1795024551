package defpackage;

import android.text.TextUtils;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.LinkedHashSet;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.vpn.service.RenzInjectorService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ex0 extends SSLSocketFactory {
    public final ig a;
    public final SSLContext b;
    public final RenzInjectorService c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public ex0(RenzInjectorService renzInjectorService) throws NoSuchAlgorithmException, KeyManagementException {
        this.a = ig.h(renzInjectorService);
        this.c = renzInjectorService;
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        this.b = sSLContext;
        sSLContext.init(null, new TrustManager[]{new a()}, new SecureRandom());
    }

    public final void a(int i, String str, boolean z) {
        SSLSocketFactory socketFactory = this.b.getSocketFactory();
        RenzInjectorService renzInjectorService = this.c;
        renzInjectorService.q = (SSLSocket) socketFactory.createSocket(renzInjectorService.i, str, i, z);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ig igVar = this.a;
        igVar.getClass();
        String string = igVar.a.getString(uh.a(-129365145976094L), uh.a(-129412390616350L));
        if (string.equals("SSL") || string.equals("TLS") || string.equals(AppConfig.TASKER_DEFAULT_GUID)) {
            Collections.addAll(linkedHashSet, renzInjectorService.q.getEnabledProtocols());
        } else {
            linkedHashSet.add(string);
        }
        renzInjectorService.q.setEnabledProtocols((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
        renzInjectorService.h("Enabled Protocols: " + TextUtils.join(", ", renzInjectorService.q.getEnabledProtocols()));
        renzInjectorService.q.addHandshakeCompletedListener(new dx0(this));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) {
        a(i, str, true);
        return this.c.q;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        a(i, str, z);
        return this.c.q;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
