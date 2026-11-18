package defpackage;

import com.trilead.ssh2.crypto.keys.Ed25519Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.security.PrivilegedAction;
import java.util.Properties;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qp implements PrivilegedAction {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Serializable a;

    public /* synthetic */ qp(int i, Serializable serializable) {
        this.G0 = i;
        this.a = serializable;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.security.PrivilegedAction
    public final Object run() throws Throwable {
        InputStream inputStream;
        StringBuffer stringBuffer;
        int i = this.G0;
        Serializable serializable = this.a;
        if (i == 0) {
            return ((Ed25519Provider) serializable).lambda$new$0();
        }
        InputStream inputStream2 = null;
        if (i != 1) {
            return System.getProperty((String) serializable, null);
        }
        URL url = (URL) serializable;
        try {
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            uRLConnectionOpenConnection.setUseCaches(false);
            inputStream = uRLConnectionOpenConnection.getInputStream();
            if (inputStream == null) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return null;
                    } catch (IOException unused) {
                        if (LogFactory.isDiagnosticsEnabled()) {
                            stringBuffer = new StringBuffer("Unable to close stream for URL ");
                            stringBuffer.append(url);
                            LogFactory.logDiagnostic(stringBuffer.toString());
                        }
                    }
                }
                return null;
            }
            try {
                try {
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    inputStream.close();
                    return properties;
                } catch (IOException unused2) {
                    if (LogFactory.isDiagnosticsEnabled()) {
                        StringBuffer stringBuffer2 = new StringBuffer("Unable to read URL ");
                        stringBuffer2.append(url);
                        LogFactory.logDiagnostic(stringBuffer2.toString());
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                            if (LogFactory.isDiagnosticsEnabled()) {
                                stringBuffer = new StringBuffer("Unable to close stream for URL ");
                                stringBuffer.append(url);
                                LogFactory.logDiagnostic(stringBuffer.toString());
                            }
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused4) {
                        if (LogFactory.isDiagnosticsEnabled()) {
                            StringBuffer stringBuffer3 = new StringBuffer("Unable to close stream for URL ");
                            stringBuffer3.append(url);
                            LogFactory.logDiagnostic(stringBuffer3.toString());
                        }
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }
}
