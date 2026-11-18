package net.openvpn.ovpn3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import defpackage.ak;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.hamotunnelplus.xyz.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class HttpsClient {
    private static final String TAG = "OpenVPNHttpsClient";

    /* JADX INFO: renamed from: net.openvpn.ovpn3.HttpsClient$2, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class AnonymousClass2 implements Interact {
        final /* synthetic */ CancelDetect val$cancel;
        final /* synthetic */ Context val$context2;
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Runnable val$runnable;
        final /* synthetic */ Task val$task2;
        final /* synthetic */ boolean val$z;

        public AnonymousClass2(Handler handler, CancelDetect cancelDetect, Context context, boolean z, Runnable runnable, Task task) {
            this.val$handler = handler;
            this.val$cancel = cancelDetect;
            this.val$context2 = context;
            this.val$z = z;
            this.val$runnable = runnable;
            this.val$task2 = task;
        }

        @Override // net.openvpn.ovpn3.HttpsClient.Interact
        public void challenge_response_dialog(final AuthContext authContext, final String str) {
            this.val$handler.post(new Runnable() { // from class: net.openvpn.ovpn3.HttpsClient.2.2
                @Override // java.lang.Runnable
                public void run() {
                    DialogInterface.OnClickListener onClickListener;
                    AlertDialog.Builder message;
                    if (AnonymousClass2.this.val$cancel.is_canceled()) {
                        return;
                    }
                    try {
                        authContext.cr_parse(str);
                        boolean z = authContext.get_cr().get_echo();
                        boolean z2 = authContext.get_cr().get_response_required();
                        String str2 = authContext.get_cr().get_challenge_text();
                        if (z2) {
                            View viewInflate = LayoutInflater.from(AnonymousClass2.this.val$context2).inflate(R.layout.b3, (ViewGroup) null);
                            final EditText editText = (EditText) viewInflate.findViewById(R.attr.ib);
                            ((TextView) viewInflate.findViewById(R.attr.i8)).setText(str2);
                            editText.setTransformationMethod(z ? SingleLineTransformationMethod.getInstance() : PasswordTransformationMethod.getInstance());
                            onClickListener = new DialogInterface.OnClickListener() { // from class: net.openvpn.ovpn3.HttpsClient.2.2.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if (AnonymousClass2.this.val$cancel.is_canceled()) {
                                        return;
                                    }
                                    RunnableC00382 runnableC00382 = RunnableC00382.this;
                                    if (i == -1) {
                                        authContext.get_cr().set_response(editText.getText().toString());
                                        new Thread(AnonymousClass2.this.val$task2).start();
                                    } else {
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        anonymousClass2.val$handler.post(anonymousClass2.val$runnable);
                                    }
                                }
                            };
                            message = new AlertDialog.Builder(AnonymousClass2.this.val$context2).setTitle(HttpsClient.resstr(AnonymousClass2.this.val$context2, R.string.db)).setView(viewInflate);
                        } else {
                            onClickListener = new DialogInterface.OnClickListener() { // from class: net.openvpn.ovpn3.HttpsClient.2.2.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if (AnonymousClass2.this.val$cancel.is_canceled()) {
                                        return;
                                    }
                                    if (i == -1) {
                                        new Thread(AnonymousClass2.this.val$task2).start();
                                    } else {
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        anonymousClass2.val$handler.post(anonymousClass2.val$runnable);
                                    }
                                }
                            };
                            message = new AlertDialog.Builder(AnonymousClass2.this.val$context2).setTitle(HttpsClient.resstr(AnonymousClass2.this.val$context2, R.string.db)).setMessage(str2);
                        }
                        message.setPositiveButton(R.string.d_, onClickListener).setNegativeButton(R.string.d9, onClickListener).show();
                    } catch (Exception e) {
                        Context context = AnonymousClass2.this.val$context2;
                        HttpsClient.raise_dialog(context, HttpsClient.resstr(context, R.string.da), e.toString());
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        anonymousClass2.val$handler.post(anonymousClass2.val$runnable);
                    }
                }
            });
        }

        @Override // net.openvpn.ovpn3.HttpsClient.Interact
        public void error_dialog(final int i, final int i2, final Object obj) {
            this.val$handler.post(new Runnable() { // from class: net.openvpn.ovpn3.HttpsClient.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AnonymousClass2.this.val$cancel.is_canceled()) {
                        return;
                    }
                    Object obj2 = obj;
                    if (((obj2 instanceof Exception) && TrustMan.isTrustFail((Exception) obj2)) || i == 0) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    int i3 = i2;
                    if (i3 != 0) {
                        sb.append(HttpsClient.resstr(AnonymousClass2.this.val$context2, i3));
                    }
                    if (obj != null) {
                        if (sb.length() > 0) {
                            sb.append(" : ");
                        }
                        sb.append(obj.toString());
                    }
                    String strResstr = HttpsClient.resstr(AnonymousClass2.this.val$context2, i);
                    String string = sb.toString();
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    if (anonymousClass2.val$z) {
                        HttpsClient.raise_dialog(anonymousClass2.val$context2, strResstr, string);
                    }
                    AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                    anonymousClass3.val$handler.post(anonymousClass3.val$runnable);
                }
            });
        }
    }

    /* JADX INFO: renamed from: net.openvpn.ovpn3.HttpsClient$3, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class AnonymousClass3 implements TrustMan.Callback {
        final /* synthetic */ CancelDetect val$cancelDetect;
        final /* synthetic */ Context val$context3;
        final /* synthetic */ Handler val$handler2;
        final /* synthetic */ AdaptiveHostnameVerifier val$hv;
        final /* synthetic */ Runnable val$runnable2;
        final /* synthetic */ Task val$task3;
        final /* synthetic */ TrustMan val$tm;
        final /* synthetic */ boolean val$z2;

        public AnonymousClass3(Handler handler, boolean z, Context context, TrustMan trustMan, CancelDetect cancelDetect, Task task, Runnable runnable, AdaptiveHostnameVerifier adaptiveHostnameVerifier) {
            this.val$handler2 = handler;
            this.val$z2 = z;
            this.val$context3 = context;
            this.val$tm = trustMan;
            this.val$cancelDetect = cancelDetect;
            this.val$task3 = task;
            this.val$runnable2 = runnable;
            this.val$hv = adaptiveHostnameVerifier;
        }

        @Override // net.openvpn.ovpn3.TrustMan.Callback
        public void onTrustFail(final TrustMan.TrustContext trustContext) {
            this.val$handler2.post(new Runnable() { // from class: net.openvpn.ovpn3.HttpsClient.3.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    boolean z = anonymousClass3.val$z2;
                    Context context = anonymousClass3.val$context3;
                    if (z) {
                        TrustMan.TrustContext trustContext2 = trustContext;
                        new CertWarn(context, trustContext2.chain[0], trustContext2.excep.toString()) { // from class: net.openvpn.ovpn3.HttpsClient.3.1.1
                            @Override // net.openvpn.ovpn3.CertWarn
                            public void done(int i) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (i == 1) {
                                    AnonymousClass3.this.val$tm.trustCert(trustContext);
                                    if (AnonymousClass3.this.val$cancelDetect.is_canceled()) {
                                        return;
                                    }
                                    new Thread(AnonymousClass3.this.val$task3).start();
                                    return;
                                }
                                if (AnonymousClass3.this.val$cancelDetect.is_canceled()) {
                                    return;
                                }
                                AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                                anonymousClass4.val$handler2.post(anonymousClass4.val$runnable2);
                            }
                        };
                    } else {
                        HttpsClient.raise_dialog(context, HttpsClient.resstr(context, R.string.lh), HttpsClient.resstr(AnonymousClass3.this.val$context3, R.string.li));
                        AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                        anonymousClass4.val$handler2.post(anonymousClass4.val$runnable2);
                    }
                }
            });
        }

        @Override // net.openvpn.ovpn3.TrustMan.Callback
        public void onTrustSucceed(boolean z) {
            this.val$hv.allowAll(z);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class AdaptiveHostnameVerifier implements HostnameVerifier {
        private HostnameVerifier bchv;
        private boolean mode;

        public AdaptiveHostnameVerifier() {
            new BrowserCompatHostnameVerifier();
            throw null;
        }

        public void allowAll(boolean z) {
            this.mode = z;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (this.mode) {
                return true;
            }
            return this.bchv.verify(str, sSLSession);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class AuthContext {
        private CR cr;
        private String password;
        private String server;
        private String username;
        private String hostname = AppConfig.CUSTOM;
        private boolean pw_is_sess_id = false;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class CR {
            private String challenge_text;
            private boolean echo;
            private String response = AppConfig.CUSTOM;
            private boolean response_required;
            private String state_id;
            private String username;

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static class ParseError extends Exception {
                public ParseError() {
                    super("AuthContext.CR.ParseError");
                }
            }

            public CR(String str) throws ParseError {
                this.echo = false;
                this.response_required = false;
                String[] strArrSplit = str.split(":", 5);
                if (strArrSplit.length != 5) {
                    throw new ParseError();
                }
                if (!strArrSplit[0].equals("CRV1")) {
                    throw new ParseError();
                }
                for (String str2 : strArrSplit[1].split(",")) {
                    if (str2.equals("E")) {
                        this.echo = true;
                    }
                    if (str2.equals("R")) {
                        this.response_required = true;
                    }
                }
                this.state_id = strArrSplit[2];
                try {
                    this.username = new String(Base64.decode(strArrSplit[3], 0), "UTF-8");
                    this.challenge_text = strArrSplit[4];
                } catch (UnsupportedEncodingException unused) {
                    throw new ParseError();
                }
            }

            public static boolean is_challenge(String str) {
                return str != null && str.startsWith("CRV1:");
            }

            public String get_challenge_text() {
                return this.challenge_text;
            }

            public boolean get_echo() {
                return this.echo;
            }

            public String get_password() {
                return "CRV1::" + this.state_id + "::" + this.response;
            }

            public String get_response() {
                return this.response;
            }

            public boolean get_response_required() {
                return this.response_required;
            }

            public String get_username() {
                return this.username;
            }

            public void set_response(String str) {
                this.response = str;
            }
        }

        public AuthContext(String str, String str2, String str3) {
            this.server = str;
            this.username = str2;
            this.password = str3;
        }

        public static boolean is_challenge(String str) {
            return CR.is_challenge(str);
        }

        public boolean cr_defined() {
            return this.cr != null;
        }

        public void cr_parse(String str) {
            this.cr = new CR(str);
        }

        public String getHostname() {
            return this.hostname;
        }

        public CR get_cr() {
            return this.cr;
        }

        public String get_password() {
            CR cr = this.cr;
            return cr != null ? cr.get_password() : this.password;
        }

        public String get_username() {
            if (this.pw_is_sess_id) {
                return "SESSION_ID";
            }
            CR cr = this.cr;
            return cr != null ? cr.get_username() : this.username;
        }

        public String profile_filename() {
            return this.username + "@" + this.server + ".ovpn";
        }

        public void setHostname(String str) {
            this.hostname = str;
        }

        public void set_basic_auth(URLConnection uRLConnection) {
            StringBuilder sb = new StringBuilder("Basic ");
            sb.append(Base64.encodeToString((get_username() + ":" + get_password()).getBytes("UTF-8"), 2));
            uRLConnection.setRequestProperty("Authorization", sb.toString());
        }

        public void set_session_id(String str) {
            this.pw_is_sess_id = true;
            this.password = str;
            this.cr = null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class CancelDetect {
        private final int gen;
        private final I obj;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public interface I {
            int cancel_generation();
        }

        public CancelDetect(I i) {
            this.obj = i;
            this.gen = i.cancel_generation();
        }

        public boolean is_canceled() {
            return this.gen != this.obj.cancel_generation();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface Interact {
        void challenge_response_dialog(AuthContext authContext, String str);

        void error_dialog(int i, int i2, Object obj);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class PresettableHostnameVerifier implements HostnameVerifier {
        private HostnameVerifier bchv;
        public String hostnameOverride;

        public PresettableHostnameVerifier() {
            new BrowserCompatHostnameVerifier();
            throw null;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.bchv.verify(this.hostnameOverride, sSLSession);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class Task implements Runnable {
        protected static final int PROF_AUTOLOGIN = 1;
        protected static final int PROF_USERLOGIN = 2;
        protected HostnameVerifier hostnameVerifier;
        protected Interact interact;
        protected long max_download_size;
        protected SSLContext sslContext;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class ErrorDialogException extends Exception {
            private int msg_resid;
            private Object obj;
            private int title_resid;

            public ErrorDialogException(int i, int i2, Object obj) {
                super("ErrorDialogException");
                this.title_resid = i;
                this.msg_resid = i2;
                this.obj = obj;
            }

            public void dispatch(Interact interact) {
                interact.error_dialog(this.title_resid, this.msg_resid, this.obj);
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class SilentException extends ErrorDialogException {
            public SilentException() {
                super(0, 0, null);
            }
        }

        public static String xmlrpc_simple_query(String str) {
            return ak.AnonymousClass0.m("<?xml version=\"1.0\"?>\n<methodCall>\n<methodName>", str, "</methodName>\n<params></params>\n</methodCall>\n");
        }

        public void close_session(AuthContext authContext) throws IOException {
            HttpsURLConnection httpsURLConnection = get_conn(authContext);
            write(httpsURLConnection, xmlrpc_simple_query("CloseSession"));
            read(httpsURLConnection);
            httpsURLConnection.disconnect();
        }

        public HttpsURLConnection get_conn(AuthContext authContext) throws ProtocolException {
            HostnameVerifier hostnameVerifier;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://" + authContext.server + "/RPC2").openConnection();
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setReadTimeout(60000);
            if (authContext.getHostname().isEmpty()) {
                hostnameVerifier = this.hostnameVerifier;
            } else {
                PresettableHostnameVerifier presettableHostnameVerifier = new PresettableHostnameVerifier();
                presettableHostnameVerifier.hostnameOverride = authContext.getHostname();
                hostnameVerifier = presettableHostnameVerifier;
            }
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            httpsURLConnection.setSSLSocketFactory(this.sslContext.getSocketFactory());
            authContext.set_basic_auth(httpsURLConnection);
            return httpsURLConnection;
        }

        public String get_profile(AuthContext authContext, String str) throws XMLRPC.XMLRPCException, IOException {
            HttpsURLConnection httpsURLConnection = get_conn(authContext);
            write(httpsURLConnection, xmlrpc_simple_query(str));
            String str2 = read(httpsURLConnection);
            httpsURLConnection.disconnect();
            String str3 = (String) parse_xmlrpc(str2);
            if (str3 != null) {
                return str3;
            }
            throw new XMLRPC.XMLRPCException(ak.m("malformed XML response to ", str));
        }

        public void get_session_id(AuthContext authContext) throws XMLRPC.XMLRPCException, IOException, ErrorDialogException {
            Integer num;
            HttpsURLConnection httpsURLConnection = get_conn(authContext);
            write(httpsURLConnection, xmlrpc_simple_query("GetSession"));
            String str = read(httpsURLConnection);
            httpsURLConnection.disconnect();
            Map map = (Map) parse_xmlrpc(str);
            if (map != null && (num = (Integer) map.get("status")) != null) {
                if (num.intValue() == 0) {
                    String str2 = (String) map.get("session_id");
                    if (str2 != null) {
                        authContext.set_session_id(str2);
                        return;
                    }
                } else if (num.intValue() == 1) {
                    String str3 = (String) map.get("client_reason");
                    if (str3 == null) {
                        throw new ErrorDialogException(R.string.lh, R.string.ay, null);
                    }
                    if (!AuthContext.is_challenge(str3)) {
                        throw new ErrorDialogException(R.string.lh, R.string.ay, str3);
                    }
                    this.interact.challenge_response_dialog(authContext, str3);
                    throw new SilentException();
                }
            }
            throw new XMLRPC.XMLRPCException("malformed XML response to GetSession");
        }

        public Object parse_xmlrpc(String str) throws XmlPullParserException {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            return XMLRPC.parse_response(xmlPullParserNewPullParser);
        }

        public int profile_types_available(AuthContext authContext) throws XMLRPC.XMLRPCException, IOException {
            HttpsURLConnection httpsURLConnection = get_conn(authContext);
            write(httpsURLConnection, xmlrpc_simple_query("EnumConfigTypes"));
            String str = read(httpsURLConnection);
            httpsURLConnection.disconnect();
            Map map = (Map) parse_xmlrpc(str);
            if (map == null) {
                throw new XMLRPC.XMLRPCException("malformed XML response to EnumConfigTypes");
            }
            Boolean bool = (Boolean) map.get("autologin");
            int i = (bool == null || !bool.booleanValue()) ? 0 : 1;
            Boolean bool2 = (Boolean) map.get("userlogin");
            return (bool2 == null || !bool2.booleanValue()) ? i : i | 2;
        }

        public String read(HttpsURLConnection httpsURLConnection) {
            return FileUtil.readStream(new BufferedInputStream(httpsURLConnection.getInputStream()), this.max_download_size, "<XML-RPC input>");
        }

        public void write(HttpsURLConnection httpsURLConnection, String str) throws IOException {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream());
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void raise_dialog(Context context, String str, String str2) {
        new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setPositiveButton(R.string.kd, new DialogInterface.OnClickListener() { // from class: net.openvpn.ovpn3.HttpsClient.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String resstr(Context context, int i) {
        return context.getResources().getString(i);
    }

    public static void run_task(Context context, Task task, CancelDetect.I i, Runnable runnable, boolean z, boolean z2, long j) {
        Handler handler = new Handler();
        try {
            TrustMan trustMan = new TrustMan(context);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            CancelDetect cancelDetect = new CancelDetect(i);
            sSLContext.init(null, new X509TrustManager[]{trustMan}, new SecureRandom());
            AdaptiveHostnameVerifier adaptiveHostnameVerifier = new AdaptiveHostnameVerifier();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(handler, cancelDetect, context, z2, runnable, task);
            task.sslContext = sSLContext;
            task.hostnameVerifier = adaptiveHostnameVerifier;
            task.interact = anonymousClass2;
            task.max_download_size = j;
            trustMan.setCallback(new AnonymousClass3(handler, z, context, trustMan, cancelDetect, task, runnable, adaptiveHostnameVerifier));
            new Thread(task).start();
        } catch (Throwable th) {
            raise_dialog(context, resstr(context, R.string.f8), th.toString());
            handler.post(runnable);
        }
    }
}
