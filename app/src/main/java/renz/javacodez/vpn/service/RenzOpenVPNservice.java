package renz.javacodez.vpn.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.net.VpnService;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.security.KeyChain;
import android.util.Base64;
import android.widget.Toast;
import defpackage.ak;
import defpackage.as0;
import defpackage.b2;
import defpackage.bv0;
import defpackage.ev0;
import defpackage.gf1;
import defpackage.hg;
import defpackage.hy0;
import defpackage.ig;
import defpackage.l81;
import defpackage.lb1;
import defpackage.lg;
import defpackage.mc1;
import defpackage.mg$a;
import defpackage.ng;
import defpackage.og;
import defpackage.oo;
import defpackage.pc1$a;
import defpackage.uh;
import defpackage.uo0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import javax.crypto.Cipher;
import net.lingala.zip4j.util.InternalZipConstants;
import net.openvpn.ovpn3.CPUUsage;
import net.openvpn.ovpn3.ClientAPI_Config;
import net.openvpn.ovpn3.ClientAPI_ConnectionInfo;
import net.openvpn.ovpn3.ClientAPI_EvalConfig;
import net.openvpn.ovpn3.ClientAPI_Event;
import net.openvpn.ovpn3.ClientAPI_ExternalPKICertRequest;
import net.openvpn.ovpn3.ClientAPI_ExternalPKISignRequest;
import net.openvpn.ovpn3.ClientAPI_InterfaceStats;
import net.openvpn.ovpn3.ClientAPI_LLVector;
import net.openvpn.ovpn3.ClientAPI_LogInfo;
import net.openvpn.ovpn3.ClientAPI_MergeConfig;
import net.openvpn.ovpn3.ClientAPI_OpenVPNClient;
import net.openvpn.ovpn3.ClientAPI_OpenVPNClientHelper;
import net.openvpn.ovpn3.ClientAPI_ProvideCreds;
import net.openvpn.ovpn3.ClientAPI_ServerEntry;
import net.openvpn.ovpn3.ClientAPI_ServerEntryVector;
import net.openvpn.ovpn3.ClientAPI_Status;
import net.openvpn.ovpn3.ClientAPI_TransportStats;
import net.openvpn.ovpn3.FileUtil;
import net.openvpn.ovpn3.OpenVPNClientThread;
import net.openvpn.ovpn3.OpenVPNDebug;
import net.openvpn.ovpn3.PasswordUtil;
import net.openvpn.ovpn3.PrefUtil;
import net.openvpn.ovpn3.ProxyList;
import org.hamotunnelplus.xyz.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.vpn.utils.RenzUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class RenzOpenVPNservice extends VpnService implements pc1$a, Handler.Callback, OpenVPNClientThread.EventReceiver {
    public static boolean M;
    public NotificationManager A;
    public ig B;
    public Timer C;
    public boolean D;
    public final boolean E;
    public o F;
    public ParcelFileDescriptor G;
    public l81 H;
    public lb1 I;
    public uo0 J;
    public String K;
    public Intent L;
    public boolean b = false;
    public final ArrayDeque<g> c = new ArrayDeque<>();
    public CPUUsage d;
    public k f;
    public boolean g;
    public HashMap i;
    public f j;
    public f n;
    public final ArrayDeque<j> o;
    public final i p;
    public d q;
    public Handler r;
    public Notification.Builder s;
    public OpenVPNClientThread t;
    public PrefUtil u;
    public m v;
    public ProxyList w;
    public PasswordUtil x;
    public boolean y;
    public long z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RenzOpenVPNservice renzOpenVPNservice = RenzOpenVPNservice.this;
            uo0 uo0Var = renzOpenVPNservice.J;
            if (uo0Var != null) {
                uo0Var.interrupt();
            }
            lb1 lb1Var = renzOpenVPNservice.I;
            if (lb1Var != null) {
                lb1Var.a(uh.a(-75635105103134L));
                new Thread(new as0(5, lb1Var)).start();
            }
            l81 l81Var = renzOpenVPNservice.H;
            if (l81Var != null) {
                l81Var.interrupt();
            }
            ParcelFileDescriptor parcelFileDescriptor = renzOpenVPNservice.G;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            renzOpenVPNservice.m(uh.a(-86729005628702L));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b {
        public String a;
        public boolean b;
        public boolean c;

        public final String toString() {
            return String.format(uh.a(-86965228829982L), this.a, Boolean.valueOf(this.b), Boolean.valueOf(this.c));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c {
        public long a;
        public long b;
        public int c;
        public int d;
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d extends og {
        public mg$a d;

        public d(Context context) {
            super(context);
            uh.a(-87003883535646L);
            this.d = new mg$a(a());
        }

        public final void b() {
            boolean z;
            boolean z2;
            mg$a mg_a = new mg$a(a());
            mg$a mg_a2 = this.d;
            mg_a2.getClass();
            int i = mg_a2.b;
            int i2 = mg_a.b;
            if (i <= 0 || i2 <= 0) {
                int i3 = mg_a.a;
                if (i != i2 || mg_a2.a != i3) {
                    RenzOpenVPNservice renzOpenVPNservice = RenzOpenVPNservice.this;
                    boolean z3 = renzOpenVPNservice.u.get_boolean(uh.a(-87094077848862L), false);
                    mg$a mg_a3 = this.d;
                    int i4 = mg_a3.b;
                    if ((i4 > 0 || mg_a3.a > 0) && i2 <= 0 && i3 <= 0) {
                        if (!renzOpenVPNservice.D && (z = renzOpenVPNservice.b) && z) {
                            renzOpenVPNservice.D = true;
                            renzOpenVPNservice.t.pause(uh.a(-108354165964062L));
                        }
                    } else if (i4 > 0 || mg_a3.a > 0 || (i2 <= 0 && i3 <= 0)) {
                        boolean z4 = renzOpenVPNservice.b;
                        if (z4 && !renzOpenVPNservice.D && z4) {
                            renzOpenVPNservice.t.reconnect(0);
                        }
                    } else if (renzOpenVPNservice.D && (z2 = renzOpenVPNservice.b) && ((!z3 || renzOpenVPNservice.E) && z2)) {
                        renzOpenVPNservice.D = false;
                        renzOpenVPNservice.t.resume();
                    }
                }
            }
            this.d = mg_a;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class e {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public e(int i, int i2, int i3, int i4, int i5) {
            this.e = i;
            this.b = i2;
            this.d = i3;
            this.c = i4;
            this.a = i5;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class f {
        public ClientAPI_ConnectionInfo a;
        public String e;
        public String f;
        public String h;
        public g k;
        public Handler m;
        public a n;
        public long b = 0;
        public int c = 0;
        public int d = -1;
        public int g = 1;
        public int i = 0;
        public int j = -1;
        public b l = b.b;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                f.this.getClass();
                if (RenzOpenVPNservice.M) {
                    return;
                }
                new Handler().postDelayed(new renz.javacodez.vpn.service.b(), 1000L);
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public enum b {
            b,
            c,
            d
        }

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            Object[] objArr = {this.f};
            stringBuffer.append(String.format(uh.a(-87523574578462L), objArr));
            if (this.m == null) {
                this.m = new Handler();
            }
            if (this.n == null) {
                this.n = new a();
            }
            if (String.format(uh.a(-87566524251422L), objArr).equals("WAIT")) {
                RenzOpenVPNservice.M = false;
                this.m.postDelayed(this.n, 3000L);
            } else {
                RenzOpenVPNservice.M = true;
                this.m.removeCallbacks(this.n);
            }
            if (this.e.length() > 0) {
                stringBuffer.append(String.format(uh.a(-87579409153310L), this.e));
            }
            b bVar = this.l;
            if (bVar != b.b) {
                stringBuffer.append(String.format(uh.a(-87626653793566L), bVar));
            }
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface g {
        void a(f fVar);

        void d(j jVar);

        PendingIntent e(int i);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class h extends RuntimeException {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class i extends Binder {
        public i() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class j {
        public String a;
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class k {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public String d;
        public final String e;
        public final String f;
        public final String g;
        public final boolean h;
        public n i;
        public final q j;
        public final b k;
        public final String l;

        public k(String str, String str2, boolean z, ClientAPI_EvalConfig clientAPI_EvalConfig) {
            this.e = str;
            this.g = str2;
            this.f = str2;
            if (z) {
                if (l.b(str2)) {
                    this.f = l.c(str2);
                }
                try {
                    this.f = URLDecoder.decode(this.f, uh.a(-87669603466526L));
                } catch (UnsupportedEncodingException unused) {
                    uh.a(-87695373270302L);
                    uh.a(-87759797779742L);
                }
            }
            if (clientAPI_EvalConfig.getError()) {
                clientAPI_EvalConfig.getMessage();
                return;
            }
            this.l = clientAPI_EvalConfig.getUserlockedUsername();
            boolean autologin = clientAPI_EvalConfig.getAutologin();
            this.b = autologin;
            this.c = clientAPI_EvalConfig.getExternalPki();
            this.h = clientAPI_EvalConfig.getPrivateKeyPasswordRequired();
            this.a = clientAPI_EvalConfig.getAllowPasswordSave();
            String staticChallenge = clientAPI_EvalConfig.getStaticChallenge();
            boolean z2 = true;
            if (staticChallenge.length() > 0) {
                b bVar = new b();
                bVar.a = staticChallenge;
                bVar.b = clientAPI_EvalConfig.getStaticChallengeEcho();
                bVar.c = true;
                this.k = bVar;
            }
            if (!z) {
                String profileName = clientAPI_EvalConfig.getProfileName();
                String friendlyName = clientAPI_EvalConfig.getFriendlyName();
                String str3 = this.e;
                if (str3 != null) {
                    str3.equals(uh.a(-88017495817502L));
                }
                if (friendlyName.length() > 0) {
                    profileName = friendlyName;
                } else {
                    z2 = false;
                }
                if (str2 != null && str2.equalsIgnoreCase(uh.a(-88056150523166L))) {
                    str2 = null;
                }
                str2 = l.b(str2) ? l.c(str2) : str2;
                String str4 = (str2 == null || profileName == null || !str2.equals(profileName)) ? str2 : null;
                StringBuffer stringBuffer = new StringBuffer();
                if (autologin && !z2 && str4 == null) {
                    stringBuffer.append(RenzOpenVPNservice.this.getText(R.string.b1).toString());
                }
                if (str4 != null) {
                    stringBuffer.append(str4);
                }
                this.f = stringBuffer.toString();
            }
            this.j = new q();
            ClientAPI_ServerEntryVector serverList = clientAPI_EvalConfig.getServerList();
            int size = serverList.size();
            for (int i = 0; i < size; i++) {
                ClientAPI_ServerEntry clientAPI_ServerEntry = serverList.get(i);
                p pVar = new p();
                pVar.b = clientAPI_ServerEntry.getServer();
                pVar.a = clientAPI_ServerEntry.getFriendlyName();
                this.j.a.add(pVar);
            }
            this.d = RenzOpenVPNservice.this.u.get_string_by_profile(this.f, uh.a(-88107690130718L));
        }

        public final String a() {
            String strA;
            String str = this.g;
            String str2 = this.e;
            return ((str2 == null || !str2.equals(uh.a(-88154934770974L))) && (strA = l.a(this.f)) != null) ? strA : str;
        }

        public final n b(boolean z) {
            n nVar = this.i;
            if (nVar != null && (nVar.b == 0 || SystemClock.elapsedRealtime() <= nVar.b)) {
                return this.i;
            }
            n nVar2 = z ? new n() : null;
            this.i = nVar2;
            return nVar2;
        }

        public final boolean c() {
            String str = this.e;
            return (str == null || str.equals(uh.a(-88189294509342L))) ? false : true;
        }

        public final String toString() {
            String strA = uh.a(-88365388168478L);
            String str = this.f;
            String str2 = this.g;
            String str3 = this.l;
            Boolean boolValueOf = Boolean.valueOf(this.b);
            Boolean boolValueOf2 = Boolean.valueOf(this.c);
            String str4 = this.d;
            String string = this.j.toString();
            b bVar = this.k;
            return String.format(strA, str, str2, str3, boolValueOf, boolValueOf2, str4, string, bVar != null ? bVar.toString() : uh.a(-88691805682974L), uh.a(-88713280519454L));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class l {
        public static String a(String str) {
            try {
                return URLEncoder.encode(str, uh.a(-88786294963486L)) + uh.a(-88812064767262L);
            } catch (UnsupportedEncodingException unused) {
                uh.a(-88837834571038L);
                uh.a(-88902259080478L);
                return null;
            }
        }

        public static boolean b(String str) {
            if (str == null) {
                return false;
            }
            return str.endsWith(uh.a(-88734755355934L)) || str.endsWith(uh.a(-88760525159710L));
        }

        public static String c(String str) {
            return (str == null || !b(str)) ? str : str.substring(0, str.length() - 5);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class m extends ArrayList<k> {
        public static final /* synthetic */ int c = 0;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Comparator<k> {
            @Override // java.util.Comparator
            public final int compare(k kVar, k kVar2) {
                return kVar.f.compareTo(kVar2.f);
            }
        }

        public m() {
        }

        public static void d(m mVar, String str) throws IOException {
            String strA;
            String[] strArrFileList;
            boolean z;
            String strP;
            String str2 = str;
            boolean zEquals = str2.equals(uh.a(-89159957118238L));
            RenzOpenVPNservice renzOpenVPNservice = RenzOpenVPNservice.this;
            if (zEquals) {
                strA = uh.a(-89194316856606L);
                strArrFileList = renzOpenVPNservice.getResources().getAssets().list(uh.a(-89224381627678L));
                z = false;
            } else {
                if (!str2.equals(uh.a(-89228676594974L))) {
                    throw new h();
                }
                strA = uh.a(-89267331300638L);
                strArrFileList = renzOpenVPNservice.fileList();
                z = true;
            }
            String str3 = strA;
            String[] strArr = strArrFileList;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str4 = strArr[i];
                if (l.b(str4)) {
                    try {
                        strP = renzOpenVPNservice.p(str2, str4);
                    } catch (IOException unused) {
                        uh.a(-89353230646558L);
                        String.format(uh.a(-89417655155998L), str4, str3);
                        strP = null;
                    }
                    try {
                        ClientAPI_Config clientAPI_Config = new ClientAPI_Config();
                        clientAPI_Config.setContent(strP);
                        ClientAPI_EvalConfig clientAPI_EvalConfigEval_config = new ClientAPI_OpenVPNClientHelper().eval_config(clientAPI_Config);
                        if (clientAPI_EvalConfigEval_config.getError()) {
                            uh.a(-89563684044062L);
                            String.format(uh.a(-89628108553502L), str4, clientAPI_EvalConfigEval_config.getMessage());
                        } else {
                            mVar.add(RenzOpenVPNservice.this.new k(str2, str4, z, clientAPI_EvalConfigEval_config));
                        }
                    } catch (Exception unused2) {
                        uh.a(-89769842474270L);
                        uh.a(-89834266983710L);
                        return;
                    }
                }
                i++;
                str2 = str;
            }
        }

        public final k e(String str) {
            if (str == null) {
                return null;
            }
            for (k kVar : this) {
                if (str.equals(kVar.f)) {
                    return kVar;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class n {
        public Intent a;
        public long b;
        public boolean c;
        public ProxyList.Item d;
        public String e;
        public String f;

        public final void a(Intent intent, String str, String str2, String str3, ProxyList proxyList, boolean z) {
            if (z) {
                return;
            }
            ProxyList.Item item = proxyList.get(str);
            if (item == null) {
                this.d = null;
                this.a = null;
                this.b = 0L;
                this.c = false;
                this.f = null;
                this.e = null;
                return;
            }
            this.d = item;
            this.a = intent;
            this.b = SystemClock.elapsedRealtime() + 120000;
            if (this.c) {
                return;
            }
            if (str2 == null || str3 == null) {
                this.f = item.username;
                this.e = item.password;
            } else {
                this.f = str2;
                this.e = str3;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class o extends BroadcastReceiver {
        public final RenzOpenVPNservice a;

        public o(RenzOpenVPNservice renzOpenVPNservice) {
            this.a = renzOpenVPNservice;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || !intent.getAction().equals(uh.a(-90482807045406L))) {
                return;
            }
            RenzOpenVPNservice renzOpenVPNservice = this.a;
            if (renzOpenVPNservice.b) {
                renzOpenVPNservice.t.reconnect(0);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class p {
        public String a;
        public String b;

        public final String toString() {
            return String.format(uh.a(-90525756718366L), this.b, this.a);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class q {
        public final ArrayList<p> a = new ArrayList<>();

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<p> it = this.a.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString() + uh.a(-90551526522142L));
            }
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class r extends VpnService.Builder implements OpenVPNClientThread.TunBuilder {
        public r() {
            super(RenzOpenVPNservice.this);
        }

        public static void a(String str, Exception exc) {
            uh.a(-94129234279710L);
            String.format(uh.a(-94193658789150L), str, exc.toString());
        }

        @Override // net.openvpn.ovpn3.OpenVPNClientThread.TunBuilder
        public final boolean tun_builder_add_address(String str, int i, String str2, boolean z, boolean z2) {
            try {
                uh.a(-90925188676894L);
                String.format(uh.a(-90989613186334L), str, Integer.valueOf(i), str2, Boolean.valueOf(z), Boolean.valueOf(z2));
                addAddress(str, i);
                return true;
            } catch (Exception e) {
                a(uh.a(-91191476649246L), e);
                return false;
            }
        }

        @Override // net.openvpn.ovpn3.OpenVPNClientThread.TunBuilder
        public final boolean tun_builder_add_dns_server(String str, boolean z) {
            try {
                uh.a(-92394067492126L);
                String.format(uh.a(-92458492001566L), str, Boolean.valueOf(z));
                addDnsServer(str);
                return true;
            } catch (Exception e) {
                a(uh.a(-92608815856926L), e);
                return false;
            }
        }

        @Override // net.openvpn.ovpn3.OpenVPNClientThread.TunBuilder
        public final boolean tun_builder_add_route(String str, int i, boolean z) {
            try {
                uh.a(-91681102920990L);
                String.format(uh.a(-91745527430430L), str, Integer.valueOf(i), Boolean.valueOf(z));
                addRoute(str, i);
                return true;
            } catch (Exception e) {
                a(uh.a(-91887261351198L), e);
                return false;
            }
        }

        @Override // net.openvpn.ovpn3.OpenVPNClientThread.TunBuilder
        public final boolean tun_builder_add_search_domain(String str) {
            try {
                uh.a(-92724779973918L);
                String.format(uh.a(-92789204483358L), str);
                addSearchDomain(str);
                return true;
            } catch (Exception e) {
                a(uh.a(-92918053502238L), e);
                return false;
            }
        }

        @Override // net.openvpn.ovpn3.OpenVPNClientThread.TunBuilder
        public final int tun_builder_establish() {
            PendingIntent pendingIntentE;
            try {
                uh.a(-93596658335006L);
                uh.a(-93661082844446L);
                RenzOpenVPNservice renzOpenVPNservice = RenzOpenVPNservice.this;
                boolean z = RenzOpenVPNservice.M;
                Iterator<g> it = renzOpenVPNservice.c.iterator();
                do {
                    if (!it.hasNext()) {
                        pendingIntentE = null;
                        break;
                    }
                    pendingIntentE = it.next().e(0);
                } while (pendingIntentE == null);
                if (pendingIntentE != null) {
                    setConfigureIntent(pendingIntentE);
                }
                return establish().detachFd();
            } catch (Exception e) {
                a(uh.a(-93742687223070L), e);
                return -1;
            }
        }

        @Override // net.openvpn.ovpn3.OpenVPNClientThread.TunBuilder
        public final boolean tun_builder_exclude_route(String str, int i, boolean z) {
            try {
                uh.a(-91981750631710L);
                String.format(uh.a(-92046175141150L), str, Integer.valueOf(i), Boolean.valueOf(z));
                return true;
            } catch (Exception e) {
                a(uh.a(-92282398342430L), e);
                return false;
            }
        }

        @Override // net.openvpn.ovpn3.OpenVPNClientThread.TunBuilder
        public final boolean tun_builder_reroute_gw(boolean z, boolean z2, long j) {
            try {
                uh.a(-91294555864350L);
                String.format(uh.a(-91358980373790L), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j));
                if ((j & 65536) == 0 && z) {
                    addRoute(uh.a(-91552253902110L), 0);
                    return true;
                }
                return true;
            } catch (Exception e) {
                a(uh.a(-91586613640478L), e);
                return false;
            }
        }

        @Override // net.openvpn.ovpn3.OpenVPNClientThread.TunBuilder
        public final boolean tun_builder_set_mtu(int i) {
            try {
                uh.a(-93046902521118L);
                String.format(uh.a(-93111327030558L), Integer.valueOf(i));
                setMtu(i);
                return true;
            } catch (Exception e) {
                a(uh.a(-93197226376478L), e);
                return false;
            }
        }

        @Override // net.openvpn.ovpn3.OpenVPNClientThread.TunBuilder
        public final boolean tun_builder_set_remote_address(String str, boolean z) {
            try {
                uh.a(-90560116456734L);
                String.format(uh.a(-90624540966174L), str, Boolean.valueOf(z));
                return true;
            } catch (Exception e) {
                a(uh.a(-90792044690718L), e);
                return false;
            }
        }

        @Override // net.openvpn.ovpn3.OpenVPNClientThread.TunBuilder
        public final boolean tun_builder_set_session_name(String str) {
            try {
                uh.a(-93283125722398L);
                String.format(uh.a(-93347550231838L), str);
                setSession(RenzOpenVPNservice.this.getString(R.string.app));
                return true;
            } catch (Exception e) {
                a(uh.a(-93472104283422L), e);
                return false;
            }
        }

        @Override // net.openvpn.ovpn3.OpenVPNClientThread.TunBuilder
        public final void tun_builder_teardown(boolean z) {
            try {
                uh.a(-93837176503582L);
                String.format(uh.a(-93901601013022L), Boolean.valueOf(z));
            } catch (Exception e) {
                a(uh.a(-94039039966494L), e);
            }
        }
    }

    static {
        uh.a(-117214683495710L);
        uh.a(-117304877808926L);
        uh.a(-117412251991326L);
        uh.a(-117532511075614L);
        uh.a(-117682834930974L);
        uh.a(-117815978917150L);
        uh.a(-117966302772510L);
        uh.a(-118185346104606L);
        uh.a(-118335669959966L);
        uh.a(-118533238455582L);
        uh.a(-118619137801502L);
        uh.a(-118683562310942L);
        M = true;
    }

    public RenzOpenVPNservice() {
        new SimpleDateFormat(uh.a(-94283853102366L));
        this.o = new ArrayDeque<>();
        this.p = new i();
        this.y = false;
        this.z = 0L;
        this.D = false;
        this.E = true;
    }

    public static String r(long j2) {
        String strA;
        float f2;
        float f3 = j2;
        if (f3 >= 1.0E12f) {
            strA = uh.a(-106670538784030L);
            f2 = 1.09951163E12f;
        } else if (f3 >= 1.0E9f) {
            strA = uh.a(-106683423685918L);
            f2 = 1.07374182E9f;
        } else if (f3 >= 1000000.0f) {
            strA = uh.a(-106696308587806L);
            f2 = 1048576.0f;
        } else {
            if (f3 < 1000.0f) {
                return String.format(uh.a(-106722078391582L), Float.valueOf(f3));
            }
            strA = uh.a(-106709193489694L);
            f2 = 1024.0f;
        }
        return String.format(uh.a(-106743553228062L), Float.valueOf(f3 / f2), strA);
    }

    @Override // defpackage.pc1$a
    public final boolean a(Socket socket) {
        return protect(socket);
    }

    public final void b(String str, String str2) {
        boolean z;
        String str3;
        String strA;
        ClientAPI_Config clientAPI_Config = new ClientAPI_Config();
        clientAPI_Config.setContent(str2);
        ClientAPI_EvalConfig clientAPI_EvalConfigEval_config = new ClientAPI_OpenVPNClientHelper().eval_config(clientAPI_Config);
        if (clientAPI_EvalConfigEval_config.getError()) {
            g(1, uh.a(-98724849286430L), String.format(uh.a(-98810748632350L), str, clientAPI_EvalConfigEval_config.getMessage()));
        }
        String strA2 = uh.a(-98845108370718L);
        if (clientAPI_EvalConfigEval_config.getError()) {
            clientAPI_EvalConfigEval_config.getMessage();
            str3 = str;
        } else {
            clientAPI_EvalConfigEval_config.getUserlockedUsername();
            boolean autologin = clientAPI_EvalConfigEval_config.getAutologin();
            clientAPI_EvalConfigEval_config.getExternalPki();
            clientAPI_EvalConfigEval_config.getPrivateKeyPasswordRequired();
            clientAPI_EvalConfigEval_config.getAllowPasswordSave();
            if (clientAPI_EvalConfigEval_config.getStaticChallenge().length() > 0) {
                clientAPI_EvalConfigEval_config.getStaticChallengeEcho();
            }
            String profileName = clientAPI_EvalConfigEval_config.getProfileName();
            String friendlyName = clientAPI_EvalConfigEval_config.getFriendlyName();
            strA2.equals(uh.a(-88017495817502L));
            if (friendlyName.length() > 0) {
                profileName = friendlyName;
                z = true;
            } else {
                z = false;
            }
            String strC = (str == null || !str.equalsIgnoreCase(uh.a(-88056150523166L))) ? str : null;
            if (l.b(strC)) {
                strC = l.c(strC);
            }
            String str4 = (strC == null || profileName == null || !strC.equals(profileName)) ? strC : null;
            StringBuffer stringBuffer = new StringBuffer();
            if (autologin && !z && str4 == null) {
                stringBuffer.append(getText(R.string.b1).toString());
            }
            if (str4 != null) {
                stringBuffer.append(str4);
            }
            String string = stringBuffer.toString();
            ArrayList arrayList = new ArrayList();
            ClientAPI_ServerEntryVector serverList = clientAPI_EvalConfigEval_config.getServerList();
            int size = serverList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ClientAPI_ServerEntry clientAPI_ServerEntry = serverList.get(i2);
                p pVar = new p();
                pVar.b = clientAPI_ServerEntry.getServer();
                pVar.a = clientAPI_ServerEntry.getFriendlyName();
                arrayList.add(pVar);
            }
            this.u.get_string_by_profile(string, uh.a(-88107690130718L));
            str3 = string;
        }
        try {
            if (strA2.equals(uh.a(-88154934770974L)) || (strA = l.a(str3)) == null) {
                strA = str;
            }
            FileUtil.writeFileAppPrivate(this, strA, str2);
            this.x.remove(uh.a(-98883763076382L), str3);
            this.x.remove(uh.a(-98905237912862L), str3);
            q();
            try {
                h(0, uh.a(-98918122814750L), str3, str3, null);
            } catch (IOException unused) {
                g(1, uh.a(-99016907062558L), str);
            }
        } catch (IOException unused2) {
        }
    }

    public final void c(renz.javacodez.vpn.activities.d dVar) {
        ArrayDeque<g> arrayDeque = this.c;
        arrayDeque.remove(dVar);
        arrayDeque.addFirst(dVar);
        uh.a(-107237474467102L);
        String.format(uh.a(-107301898976542L), Integer.valueOf(arrayDeque.size()));
    }

    public final void d(String str, Intent intent, boolean z) {
        if (!this.b) {
            e(str, intent, z);
            return;
        }
        this.D = false;
        w();
        new Handler().postDelayed(new ev0(this, str, intent, z), 2000L);
    }

    @Override // net.openvpn.ovpn3.OpenVPNClientThread.EventReceiver
    public final void done(ClientAPI_Status clientAPI_Status) {
        boolean error = clientAPI_Status.getError();
        String message = clientAPI_Status.getMessage();
        uh.a(-112404320124190L);
        String.format(uh.a(-112468744633630L), Boolean.valueOf(error), message);
        if (this.b) {
            int iStats_n = ClientAPI_OpenVPNClient.stats_n();
            String[] strArr = new String[iStats_n];
            for (int i2 = 0; i2 < iStats_n; i2++) {
                strArr[i2] = ClientAPI_OpenVPNClient.stats_name(i2);
            }
            OpenVPNClientThread openVPNClientThread = this.t;
            ClientAPI_LLVector clientAPI_LLVectorStats_bundle = openVPNClientThread != null ? openVPNClientThread.stats_bundle() : null;
            if (clientAPI_LLVectorStats_bundle != null) {
                for (int i3 = 0; i3 < iStats_n; i3++) {
                    String str = strArr[i3];
                    Long l2 = clientAPI_LLVectorStats_bundle.get(i3);
                    if (l2.longValue() > 0) {
                        uh.a(-113198889073950L);
                        String.format(uh.a(-113263313583390L), str, l2);
                    }
                }
            }
        }
        if (error) {
            if (message == null || !message.equals(uh.a(-112644838292766L))) {
                String status = clientAPI_Status.getStatus();
                if (status.length() == 0) {
                    status = uh.a(-112739327573278L);
                }
                g(1, status, message);
            } else {
                g(1, uh.a(-112816636984606L), null);
            }
        }
        g(0, uh.a(-112911126265118L), null);
        this.b = false;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x01e0 A[Catch: a | IOException -> 0x0288, a | IOException -> 0x0288, PHI: r8
      0x01e0: PHI (r8v9 int) = (r8v8 int), (r8v18 int), (r8v18 int) binds: [B:30:0x01d8, B:32:0x01db, B:33:0x01dd] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {a | IOException -> 0x0288, blocks: (B:12:0x0131, B:20:0x0182, B:20:0x0182, B:23:0x018b, B:23:0x018b, B:26:0x01b6, B:26:0x01b6, B:29:0x01d0, B:29:0x01d0, B:36:0x01ec, B:36:0x01ec, B:35:0x01e0, B:35:0x01e0, B:19:0x015d, B:19:0x015d), top: B:68:0x0131 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    public final boolean e(String str, Intent intent, boolean z) {
        int i2;
        n nVarB;
        int i3;
        ?? r18;
        int i4;
        String strA;
        String strG = ak.g(-103247449849118L, defpackage.e.d(str), intent);
        String strG2 = ak.g(-103286104554782L, defpackage.e.d(str), intent);
        String strG3 = ak.g(-103341939129630L, defpackage.e.d(str), intent);
        String strG4 = ak.g(-103393478737182L, defpackage.e.d(str), intent);
        String strG5 = ak.g(-103462198213918L, defpackage.e.d(str), intent);
        StringBuilder sbD = defpackage.e.d(str);
        sbD.append(uh.a(-103530917690654L));
        intent.getBooleanExtra(sbD.toString(), false);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String strG6 = ak.g(-103642586840350L, sb, intent);
        String strG7 = ak.g(-103676946578718L, defpackage.e.d(str), intent);
        String strG8 = ak.g(-103707011349790L, defpackage.e.d(str), intent);
        String strG9 = ak.g(-103732781153566L, defpackage.e.d(str), intent);
        String strG10 = ak.g(-103792910695710L, defpackage.e.d(str), intent);
        String strG11 = ak.g(-103835860368670L, defpackage.e.d(str), intent);
        StringBuilder sbD2 = defpackage.e.d(str);
        sbD2.append(uh.a(-103878810041630L));
        boolean booleanExtra = intent.getBooleanExtra(sbD2.toString(), false);
        String strG12 = ak.g(-103947529518366L, defpackage.e.d(str), intent);
        String strG13 = ak.g(-104003364093214L, defpackage.e.d(str), intent);
        String strG14 = ak.g(-104046313766174L, defpackage.e.d(str), intent);
        String strG15 = ak.g(-104097853373726L, defpackage.e.d(str), intent);
        String strPw_repl = OpenVPNDebug.pw_repl(strG10, strG11);
        k kVarL = l(strG);
        if (kVarL == null) {
            return false;
        }
        if (strG3 != null) {
            nVarB = kVarL.b(true);
            i2 = 1;
            nVarB.a(intent, strG3, strG4, strG5, this.w, z);
        } else {
            i2 = 1;
            nVarB = null;
            kVarL.i = null;
        }
        n nVar = nVarB;
        String str2 = kVarL.e;
        String strA2 = kVarL.a();
        try {
            String strP = p(str2, strA2);
            boolean z2 = false;
            try {
                hg hgVar = new hg(0);
                ig igVar = this.B;
                igVar.getClass();
                if (igVar.a.getBoolean(uh.a(-129854772247838L), false)) {
                    ig igVar2 = this.B;
                    igVar2.getClass();
                    hgVar.i(new StringReader(igVar2.a.getString(uh.a(-129803232640286L), uh.a(-129850477280542L))));
                } else {
                    try {
                        hgVar.i(new StringReader(strP));
                    } catch (hg.a | IOException unused) {
                        i4 = 2;
                        i3 = i4;
                        r18 = 0;
                        Object[] objArr = new Object[i3];
                        objArr[r18] = str2;
                        objArr[1] = strA2;
                        g(1, uh.a(-104381321215262L), String.format(uh.a(-104458630626590L), objArr));
                        return r18;
                    }
                }
                gf1 gf1VarC = hgVar.c();
                lg lgVar = gf1VarC.T[0];
                lgVar.b = this.B.m();
                lgVar.c = uh.a(-104175162785054L) + this.B.n();
                z2 = false;
                lgVar.d = false;
                if (this.B.v()) {
                    gf1VarC.t = i2;
                    gf1VarC.q = this.B.d();
                    gf1VarC.r = this.B.f();
                }
                int iQ = this.B.q();
                i4 = 3;
                if (iQ != 3) {
                    i4 = 4;
                    if (iQ == 4 || iQ == 5) {
                        lgVar.c = String.valueOf(this.B.o());
                    }
                } else {
                    lgVar.c = String.valueOf(this.B.o());
                }
                try {
                    if (this.B.g()) {
                        i4 = 2;
                        if (this.B.q() == 2) {
                            lgVar.b = this.B.l();
                            strA = uh.a(-104179457752350L);
                        }
                        lgVar.c = strA;
                        String strC = gf1VarC.c(this, i2);
                        uh.a(-104205227556126L);
                        Object[] objArr2 = new Object[i2];
                        try {
                            objArr2[0] = Integer.valueOf(strC.length());
                            String.format(uh.a(-104269652065566L), objArr2);
                            str2 = str2;
                            r18 = 0;
                            strA2 = strA2;
                            i3 = i4;
                            try {
                                return t(kVarL, strC, strG2, nVar, strG6, strG7, strG8, strG9, strG10, strPw_repl, booleanExtra, strG12, strG13, strG14, strG15);
                            } catch (hg.a | IOException unused2) {
                            }
                        } catch (hg.a | IOException unused3) {
                            str2 = str2;
                            strA2 = strA2;
                            i3 = i4;
                            r18 = 0;
                        }
                    } else {
                        i4 = 2;
                    }
                    if (!this.B.g() || this.B.q() != 5) {
                        String strC2 = gf1VarC.c(this, i2);
                        uh.a(-104205227556126L);
                        Object[] objArr3 = new Object[i2];
                        objArr3[0] = Integer.valueOf(strC2.length());
                        String.format(uh.a(-104269652065566L), objArr3);
                        str2 = str2;
                        r18 = 0;
                        strA2 = strA2;
                        i3 = i4;
                        return t(kVarL, strC2, strG2, nVar, strG6, strG7, strG8, strG9, strG10, strPw_repl, booleanExtra, strG12, strG13, strG14, strG15);
                    }
                    lgVar.b = this.B.l();
                    strA = uh.a(-104192342654238L);
                    lgVar.c = strA;
                    String strC3 = gf1VarC.c(this, i2);
                    uh.a(-104205227556126L);
                    Object[] objArr4 = new Object[i2];
                    objArr4[0] = Integer.valueOf(strC3.length());
                    String.format(uh.a(-104269652065566L), objArr4);
                    str2 = str2;
                    r18 = 0;
                    strA2 = strA2;
                    i3 = i4;
                    return t(kVarL, strC3, strG2, nVar, strG6, strG7, strG8, strG9, strG10, strPw_repl, booleanExtra, strG12, strG13, strG14, strG15);
                } catch (hg.a | IOException unused4) {
                    i3 = i4;
                    r18 = 0;
                }
            } catch (hg.a | IOException unused5) {
                str2 = str2;
                strA2 = strA2;
                r18 = z2;
                i3 = 2;
            }
        } catch (hg.a | IOException unused6) {
            i3 = 2;
        }
        Object[] objArr5 = new Object[i3];
        objArr5[r18] = str2;
        objArr5[1] = strA2;
        g(1, uh.a(-104381321215262L), String.format(uh.a(-104458630626590L), objArr5));
        return r18;
    }

    @Override // net.openvpn.ovpn3.OpenVPNClientThread.EventReceiver
    public final void event(ClientAPI_Event clientAPI_Event) {
        OpenVPNClientThread openVPNClientThread;
        f fVar = new f();
        if (clientAPI_Event.getError()) {
            fVar.c |= 1;
        }
        fVar.f = clientAPI_Event.getName();
        fVar.e = clientAPI_Event.getInfo();
        e eVar = (e) this.i.get(fVar.f);
        if (eVar != null) {
            fVar.i = eVar.d;
            fVar.g = eVar.c;
            int i2 = eVar.e;
            fVar.j = i2;
            fVar.d = eVar.b;
            fVar.c = eVar.a | fVar.c;
            if (i2 == R.string.cr && (openVPNClientThread = this.t) != null) {
                fVar.a = openVPNClientThread.connection_info();
            }
        } else {
            fVar.j = R.string.ui;
        }
        Handler handler = this.r;
        handler.sendMessage(handler.obtainMessage(1, fVar));
    }

    @Override // net.openvpn.ovpn3.OpenVPNClientThread.EventReceiver
    public final void external_pki_cert_request(ClientAPI_ExternalPKICertRequest clientAPI_ExternalPKICertRequest) {
        try {
            X509Certificate[] certificateChain = KeyChain.getCertificateChain(this, clientAPI_ExternalPKICertRequest.getAlias());
            if (certificateChain == null) {
                clientAPI_ExternalPKICertRequest.setError(true);
                clientAPI_ExternalPKICertRequest.setInvalidAlias(true);
                return;
            }
            if (certificateChain.length < 1) {
                clientAPI_ExternalPKICertRequest.setError(true);
                clientAPI_ExternalPKICertRequest.setInvalidAlias(true);
                clientAPI_ExternalPKICertRequest.setErrorText(getResources().getString(R.string.e3));
                return;
            }
            clientAPI_ExternalPKICertRequest.setCert(String.format(uh.a(-111257563856158L), Base64.encodeToString(certificateChain[0].getEncoded(), 0)));
            if (certificateChain.length >= 2) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 1; i2 < certificateChain.length; i2++) {
                    sb.append(String.format(uh.a(-111257563856158L), Base64.encodeToString(certificateChain[i2].getEncoded(), 0)));
                }
                clientAPI_ExternalPKICertRequest.setSupportingChain(sb.toString());
            }
        } catch (Exception e2) {
            uh.a(-111510966926622L);
            uh.a(-111575391436062L);
            clientAPI_ExternalPKICertRequest.setError(true);
            clientAPI_ExternalPKICertRequest.setInvalidAlias(true);
            clientAPI_ExternalPKICertRequest.setErrorText(e2.toString());
        }
    }

    @Override // net.openvpn.ovpn3.OpenVPNClientThread.EventReceiver
    public final void external_pki_sign_request(ClientAPI_ExternalPKISignRequest clientAPI_ExternalPKISignRequest) {
        byte[] bArrDoFinal;
        try {
            uh.a(-111747190127902L);
            byte[] bArrDecode = Base64.decode(clientAPI_ExternalPKISignRequest.getData(), 0);
            uh.a(-111936168688926L);
            uh.a(-112000593198366L);
            PrivateKey privateKey = KeyChain.getPrivateKey(this, clientAPI_ExternalPKISignRequest.getAlias());
            if (privateKey != null) {
                Cipher cipher = Cipher.getInstance(uh.a(-112077902609694L));
                cipher.init(1, privateKey);
                bArrDoFinal = cipher.doFinal(bArrDecode);
            } else {
                clientAPI_ExternalPKISignRequest.setError(true);
                clientAPI_ExternalPKISignRequest.setInvalidAlias(true);
                bArrDoFinal = null;
            }
            if (bArrDoFinal != null) {
                clientAPI_ExternalPKISignRequest.setSig(Base64.encodeToString(bArrDoFinal, 2));
            }
        } catch (Exception e2) {
            uh.a(-112168096922910L);
            uh.a(-112232521432350L);
            clientAPI_ExternalPKISignRequest.setError(true);
            clientAPI_ExternalPKISignRequest.setInvalidAlias(true);
            clientAPI_ExternalPKISignRequest.setErrorText(e2.toString());
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x04ad A[Catch: a | IOException -> 0x03f2, a | IOException -> 0x03f2, TryCatch #6 {a | IOException -> 0x03f2, blocks: (B:76:0x03e9, B:79:0x041f, B:82:0x0429, B:82:0x0429, B:85:0x0454, B:85:0x0454, B:87:0x045c, B:87:0x045c, B:88:0x046f, B:88:0x046f, B:95:0x048b, B:95:0x048b, B:97:0x0493, B:97:0x0493, B:99:0x049b, B:99:0x049b, B:105:0x04ce, B:105:0x04ce, B:100:0x04ad, B:100:0x04ad, B:102:0x04b5, B:102:0x04b5, B:104:0x04bd, B:104:0x04bd, B:94:0x047f, B:94:0x047f, B:78:0x03fa), top: B:136:0x03e7 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x04b5 A[Catch: a | IOException -> 0x03f2, a | IOException -> 0x03f2, TryCatch #6 {a | IOException -> 0x03f2, blocks: (B:76:0x03e9, B:79:0x041f, B:82:0x0429, B:82:0x0429, B:85:0x0454, B:85:0x0454, B:87:0x045c, B:87:0x045c, B:88:0x046f, B:88:0x046f, B:95:0x048b, B:95:0x048b, B:97:0x0493, B:97:0x0493, B:99:0x049b, B:99:0x049b, B:105:0x04ce, B:105:0x04ce, B:100:0x04ad, B:100:0x04ad, B:102:0x04b5, B:102:0x04b5, B:104:0x04bd, B:104:0x04bd, B:94:0x047f, B:94:0x047f, B:78:0x03fa), top: B:136:0x03e7 }] */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:55:0x022d  */
    /* JADX WARN: Code duplicated, block: B:58:0x0259  */
    /* JADX WARN: Code duplicated, block: B:67:0x03ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:70:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:76:0x03e9 A[Catch: a | IOException -> 0x03f2, TRY_ENTER, TryCatch #6 {a | IOException -> 0x03f2, blocks: (B:76:0x03e9, B:79:0x041f, B:82:0x0429, B:82:0x0429, B:85:0x0454, B:85:0x0454, B:87:0x045c, B:87:0x045c, B:88:0x046f, B:88:0x046f, B:95:0x048b, B:95:0x048b, B:97:0x0493, B:97:0x0493, B:99:0x049b, B:99:0x049b, B:105:0x04ce, B:105:0x04ce, B:100:0x04ad, B:100:0x04ad, B:102:0x04b5, B:102:0x04b5, B:104:0x04bd, B:104:0x04bd, B:94:0x047f, B:94:0x047f, B:78:0x03fa), top: B:136:0x03e7 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x03fa A[Catch: a | IOException -> 0x03f2, TryCatch #6 {a | IOException -> 0x03f2, blocks: (B:76:0x03e9, B:79:0x041f, B:82:0x0429, B:82:0x0429, B:85:0x0454, B:85:0x0454, B:87:0x045c, B:87:0x045c, B:88:0x046f, B:88:0x046f, B:95:0x048b, B:95:0x048b, B:97:0x0493, B:97:0x0493, B:99:0x049b, B:99:0x049b, B:105:0x04ce, B:105:0x04ce, B:100:0x04ad, B:100:0x04ad, B:102:0x04b5, B:102:0x04b5, B:104:0x04bd, B:104:0x04bd, B:94:0x047f, B:94:0x047f, B:78:0x03fa), top: B:136:0x03e7 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x045c A[Catch: a | IOException -> 0x03f2, a | IOException -> 0x03f2, TryCatch #6 {a | IOException -> 0x03f2, blocks: (B:76:0x03e9, B:79:0x041f, B:82:0x0429, B:82:0x0429, B:85:0x0454, B:85:0x0454, B:87:0x045c, B:87:0x045c, B:88:0x046f, B:88:0x046f, B:95:0x048b, B:95:0x048b, B:97:0x0493, B:97:0x0493, B:99:0x049b, B:99:0x049b, B:105:0x04ce, B:105:0x04ce, B:100:0x04ad, B:100:0x04ad, B:102:0x04b5, B:102:0x04b5, B:104:0x04bd, B:104:0x04bd, B:94:0x047f, B:94:0x047f, B:78:0x03fa), top: B:136:0x03e7 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x047f A[Catch: a | IOException -> 0x03f2, a | IOException -> 0x03f2, TryCatch #6 {a | IOException -> 0x03f2, blocks: (B:76:0x03e9, B:79:0x041f, B:82:0x0429, B:82:0x0429, B:85:0x0454, B:85:0x0454, B:87:0x045c, B:87:0x045c, B:88:0x046f, B:88:0x046f, B:95:0x048b, B:95:0x048b, B:97:0x0493, B:97:0x0493, B:99:0x049b, B:99:0x049b, B:105:0x04ce, B:105:0x04ce, B:100:0x04ad, B:100:0x04ad, B:102:0x04b5, B:102:0x04b5, B:104:0x04bd, B:104:0x04bd, B:94:0x047f, B:94:0x047f, B:78:0x03fa), top: B:136:0x03e7 }] */
    /* JADX WARN: Type inference failed for: r19v10 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r19v8 */
    /* JADX WARN: Type inference failed for: r19v9 */
    public final boolean f(String str, Intent intent) throws JSONException {
        oo ooVar;
        JSONObject jSONObjectOptJSONObject;
        String string;
        String string2;
        ig igVar;
        String strG;
        String strG2;
        String strG3;
        String strG4;
        String strG5;
        String strG6;
        String strG7;
        String strG8;
        String strR;
        boolean booleanExtra;
        boolean z;
        String strG9;
        String strG10;
        String strG11;
        String strG12;
        String strPw_repl;
        k kVarL;
        n nVarB;
        String str2;
        String strA;
        int i2;
        ?? r19;
        int i3;
        String strP;
        hg hgVar;
        boolean z2;
        ig igVar2;
        gf1 gf1VarC;
        lg lgVar;
        int iQ;
        String strA2;
        synchronized (oo.class) {
            try {
                if (oo.e == null) {
                    oo.e = new oo(this);
                }
                ooVar = oo.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        JSONArray jSONArray = (JSONArray) ooVar.b;
        if (jSONArray == null || jSONArray.length() == 0) {
            jSONObjectOptJSONObject = null;
        } else {
            JSONArray jSONArray2 = new JSONArray();
            for (int i4 = 0; i4 < ((JSONArray) ooVar.b).length(); i4++) {
                JSONObject jSONObjectOptJSONObject2 = ((JSONArray) ooVar.b).optJSONObject(i4);
                if (jSONObjectOptJSONObject2 != null) {
                    if (!mc1.b((ContextWrapper) ooVar.a, jSONObjectOptJSONObject2.optString("Name", AppConfig.CUSTOM)).startsWith("Auto")) {
                        jSONArray2.put(jSONObjectOptJSONObject2);
                    }
                }
            }
            ooVar.b = jSONArray2;
            if (jSONArray2.length() == 0) {
                jSONObjectOptJSONObject = null;
            } else {
                int iNextInt = ((Random) ooVar.c).nextInt(((JSONArray) ooVar.b).length());
                jSONObjectOptJSONObject = ((JSONArray) ooVar.b).optJSONObject(iNextInt);
                JSONArray jSONArray3 = new JSONArray();
                for (int i5 = 0; i5 < ((JSONArray) ooVar.b).length(); i5++) {
                    if (i5 != iNextInt) {
                        jSONArray3.put(((JSONArray) ooVar.b).opt(i5));
                    }
                }
                ooVar.b = jSONArray3;
            }
        }
        if (jSONObjectOptJSONObject == null) {
            return false;
        }
        m(uh.a(-101396318944542L) + mc1.b(this, jSONObjectOptJSONObject.getString(uh.a(-101374844108062L))) + uh.a(-101516578028830L));
        String strC = mc1.c(this, jSONObjectOptJSONObject.getString(uh.a(-101538052865310L)), 1);
        this.B.S(strC);
        if (strC.contains(uh.a(-101593887440158L))) {
            String[] strArrSplit = strC.split(uh.a(-101602477374750L));
            strC = strArrSplit[new Random().nextInt(strArrSplit.length)];
        } else if (strC.contains(uh.a(-101611067309342L))) {
            String[] strArrSplit2 = strC.split(uh.a(-101619657243934L));
            strC = strArrSplit2[new Random().nextInt(strArrSplit2.length)];
        } else {
            if (strC.contains(uh.a(-101628247178526L))) {
                String[] strArrSplit3 = strC.split(uh.a(-101636837113118L));
                strC = strArrSplit3[new Random().nextInt(strArrSplit3.length)];
            }
            ig igVar3 = this.B;
            String strB = mc1.b(this, jSONObjectOptJSONObject.getString(uh.a(-101645427047710L)));
            igVar3.getClass();
            String strA3 = uh.a(-128690836110622L);
            hy0.a aVar = igVar3.b;
            aVar.putString(strA3, strB);
            aVar.apply();
            ig igVar4 = this.B;
            String strB2 = mc1.b(this, jSONObjectOptJSONObject.getString(uh.a(-101709851557150L)));
            igVar4.getClass();
            String strA4 = uh.a(-126908424682782L);
            hy0.a aVar2 = igVar4.b;
            aVar2.putString(strA4, strB2);
            aVar2.apply();
            string = jSONObjectOptJSONObject.getString(uh.a(-101774276066590L));
            string2 = jSONObjectOptJSONObject.getString(uh.a(-101812930772254L));
            if (string.isEmpty() || !string2.isEmpty()) {
                this.B.a0(string);
                ig igVar5 = this.B;
                igVar5.getClass();
                String strA5 = uh.a(-128768145521950L);
                hy0.a aVar3 = igVar5.b;
                aVar3.putString(strA5, string2);
                aVar3.apply();
            } else {
                this.B.a0(ooVar.b().getString(uh.a(-101851585477918L)));
                ig igVar6 = this.B;
                String string3 = ooVar.b().getString(uh.a(-101890240183582L));
                igVar6.getClass();
                String strA6 = uh.a(-128768145521950L);
                hy0.a aVar4 = igVar6.b;
                aVar4.putString(strA6, string3);
                aVar4.apply();
            }
            igVar = this.B;
            igVar.getClass();
            if (igVar.a.getBoolean(uh.a(-134093904968990L), true)) {
                this.B.P(strC);
            }
            this.B.B(false);
            if (jSONObjectOptJSONObject.has(uh.a(-101928894889246L)) && jSONObjectOptJSONObject.getBoolean(uh.a(-101989024431390L))) {
                this.B.B(true);
                ig igVar7 = this.B;
                String strB3 = mc1.b(this, jSONObjectOptJSONObject.getString(uh.a(-102049153973534L)));
                igVar7.getClass();
                String strA7 = uh.a(-129755988000030L);
                hy0.a aVar5 = igVar7.b;
                aVar5.putString(strA7, strB3);
                aVar5.apply();
            }
            String strG13 = ak.g(-102096398613790L, defpackage.e.d(str), intent);
            strG = ak.g(-102135053319454L, defpackage.e.d(str), intent);
            strG2 = ak.g(-102190887894302L, defpackage.e.d(str), intent);
            strG3 = ak.g(-102242427501854L, defpackage.e.d(str), intent);
            strG4 = ak.g(-102311146978590L, defpackage.e.d(str), intent);
            StringBuilder sbD = defpackage.e.d(str);
            sbD.append(uh.a(-102379866455326L));
            intent.getBooleanExtra(sbD.toString(), false);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            strG5 = ak.g(-102491535605022L, sb, intent);
            strG6 = ak.g(-102525895343390L, defpackage.e.d(str), intent);
            strG7 = ak.g(-102555960114462L, defpackage.e.d(str), intent);
            strG8 = ak.g(-102581729918238L, defpackage.e.d(str), intent);
            strR = this.B.r();
            String strJ = this.B.j();
            StringBuilder sbD2 = defpackage.e.d(str);
            sbD2.append(uh.a(-102641859460382L));
            booleanExtra = intent.getBooleanExtra(sbD2.toString(), false);
            z = false;
            strG9 = ak.g(-102710578937118L, defpackage.e.d(str), intent);
            strG10 = ak.g(-102766413511966L, defpackage.e.d(str), intent);
            strG11 = ak.g(-102809363184926L, defpackage.e.d(str), intent);
            strG12 = ak.g(-102860902792478L, defpackage.e.d(str), intent);
            strPw_repl = OpenVPNDebug.pw_repl(strR, strJ);
            kVarL = l(strG13);
            if (kVarL == null) {
                return false;
            }
            if (strG2 != null) {
                nVarB = kVarL.b(true);
                nVarB.a(intent, strG2, strG3, strG4, this.w, false);
            } else {
                nVarB = null;
                kVarL.i = null;
            }
            n nVar = nVarB;
            str2 = kVarL.e;
            strA = kVarL.a();
            i2 = 2;
            try {
                strP = p(str2, strA);
                z2 = false;
                try {
                    hgVar = new hg(0);
                    igVar2 = this.B;
                    igVar2.getClass();
                    try {
                        if (igVar2.a.getBoolean(uh.a(-129854772247838L), false)) {
                            ig igVar8 = this.B;
                            igVar8.getClass();
                            hgVar.i(new StringReader(igVar8.a.getString(uh.a(-129803232640286L), uh.a(-129850477280542L))));
                        } else {
                            hgVar.i(new StringReader(strP));
                        }
                        gf1VarC = hgVar.c();
                        z = false;
                        lgVar = gf1VarC.T[0];
                        lgVar.b = this.B.m();
                        lgVar.c = uh.a(-102938212203806L) + this.B.n();
                        z2 = false;
                        lgVar.d = false;
                        if (this.B.v()) {
                            gf1VarC.t = true;
                            gf1VarC.q = this.B.d();
                            gf1VarC.r = this.B.f();
                        }
                        iQ = this.B.q();
                        if (iQ != 3 || iQ == 4 || iQ == 5) {
                            lgVar.c = String.valueOf(this.B.o());
                        }
                        try {
                            try {
                                try {
                                    if (this.B.g() || this.B.q() != 2) {
                                        if (this.B.g() || this.B.q() != 5) {
                                            String strC2 = gf1VarC.c(this, true);
                                            uh.a(-102968276974878L);
                                            Object[] objArr = new Object[1];
                                            r19 = 0;
                                            r19 = 0;
                                            objArr[0] = Integer.valueOf(strC2.length());
                                            String.format(uh.a(-103032701484318L), objArr);
                                            str2 = str2;
                                            i3 = 1;
                                            i2 = 2;
                                            strA = strA;
                                            return t(kVarL, strC2, strG, nVar, strG5, strG6, strG7, strG8, strR, strPw_repl, booleanExtra, strG9, strG10, strG11, strG12);
                                        }
                                        lgVar.b = this.B.l();
                                        strA2 = uh.a(-102955392072990L);
                                        Object[] objArr2 = new Object[i2];
                                        objArr2[r19] = str2;
                                        objArr2[i3] = strA;
                                        g(i3, uh.a(-103144370634014L), String.format(uh.a(-103221680045342L), objArr2));
                                        return r19;
                                    }
                                    lgVar.b = this.B.l();
                                    strA2 = uh.a(-102942507171102L);
                                    return t(kVarL, strC2, strG, nVar, strG5, strG6, strG7, strG8, strR, strPw_repl, booleanExtra, strG9, strG10, strG11, strG12);
                                } catch (hg.a | IOException unused) {
                                }
                                objArr[0] = Integer.valueOf(strC2.length());
                                String.format(uh.a(-103032701484318L), objArr);
                                str2 = str2;
                                i3 = 1;
                                i2 = 2;
                                strA = strA;
                            } catch (hg.a | IOException unused2) {
                                str2 = str2;
                                strA = strA;
                                i2 = 2;
                                i3 = 1;
                            }
                            String strC3 = gf1VarC.c(this, true);
                            uh.a(-102968276974878L);
                            Object[] objArr3 = new Object[1];
                            r19 = 0;
                            r19 = 0;
                        } catch (hg.a | IOException unused3) {
                            i3 = 1;
                            r19 = 0;
                        }
                        lgVar.c = strA2;
                    } catch (hg.a | IOException unused4) {
                        i3 = 1;
                    }
                } catch (hg.a | IOException unused5) {
                    r19 = z2;
                    i3 = 1;
                }
            } catch (hg.a | IOException unused6) {
                r19 = z;
            }
        }
        this.B.S(strC);
        ig igVar9 = this.B;
        String strB4 = mc1.b(this, jSONObjectOptJSONObject.getString(uh.a(-101645427047710L)));
        igVar9.getClass();
        String strA8 = uh.a(-128690836110622L);
        hy0.a aVar6 = igVar9.b;
        aVar6.putString(strA8, strB4);
        aVar6.apply();
        ig igVar10 = this.B;
        String strB5 = mc1.b(this, jSONObjectOptJSONObject.getString(uh.a(-101709851557150L)));
        igVar10.getClass();
        String strA9 = uh.a(-126908424682782L);
        hy0.a aVar7 = igVar10.b;
        aVar7.putString(strA9, strB5);
        aVar7.apply();
        string = jSONObjectOptJSONObject.getString(uh.a(-101774276066590L));
        string2 = jSONObjectOptJSONObject.getString(uh.a(-101812930772254L));
        if (string.isEmpty()) {
            this.B.a0(string);
            ig igVar11 = this.B;
            igVar11.getClass();
            String strA10 = uh.a(-128768145521950L);
            hy0.a aVar8 = igVar11.b;
            aVar8.putString(strA10, string2);
            aVar8.apply();
        } else {
            this.B.a0(string);
            ig igVar12 = this.B;
            igVar12.getClass();
            String strA11 = uh.a(-128768145521950L);
            hy0.a aVar9 = igVar12.b;
            aVar9.putString(strA11, string2);
            aVar9.apply();
        }
        igVar = this.B;
        igVar.getClass();
        if (igVar.a.getBoolean(uh.a(-134093904968990L), true)) {
            this.B.P(strC);
        }
        this.B.B(false);
        if (jSONObjectOptJSONObject.has(uh.a(-101928894889246L))) {
            this.B.B(true);
            ig igVar13 = this.B;
            String strB6 = mc1.b(this, jSONObjectOptJSONObject.getString(uh.a(-102049153973534L)));
            igVar13.getClass();
            String strA12 = uh.a(-129755988000030L);
            hy0.a aVar10 = igVar13.b;
            aVar10.putString(strA12, strB6);
            aVar10.apply();
        }
        String strG14 = ak.g(-102096398613790L, defpackage.e.d(str), intent);
        strG = ak.g(-102135053319454L, defpackage.e.d(str), intent);
        strG2 = ak.g(-102190887894302L, defpackage.e.d(str), intent);
        strG3 = ak.g(-102242427501854L, defpackage.e.d(str), intent);
        strG4 = ak.g(-102311146978590L, defpackage.e.d(str), intent);
        StringBuilder sbD3 = defpackage.e.d(str);
        sbD3.append(uh.a(-102379866455326L));
        intent.getBooleanExtra(sbD3.toString(), false);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        strG5 = ak.g(-102491535605022L, sb2, intent);
        strG6 = ak.g(-102525895343390L, defpackage.e.d(str), intent);
        strG7 = ak.g(-102555960114462L, defpackage.e.d(str), intent);
        strG8 = ak.g(-102581729918238L, defpackage.e.d(str), intent);
        strR = this.B.r();
        String strJ2 = this.B.j();
        StringBuilder sbD4 = defpackage.e.d(str);
        sbD4.append(uh.a(-102641859460382L));
        booleanExtra = intent.getBooleanExtra(sbD4.toString(), false);
        z = false;
        strG9 = ak.g(-102710578937118L, defpackage.e.d(str), intent);
        strG10 = ak.g(-102766413511966L, defpackage.e.d(str), intent);
        strG11 = ak.g(-102809363184926L, defpackage.e.d(str), intent);
        strG12 = ak.g(-102860902792478L, defpackage.e.d(str), intent);
        strPw_repl = OpenVPNDebug.pw_repl(strR, strJ2);
        kVarL = l(strG14);
        if (kVarL == null) {
            return false;
        }
        if (strG2 != null) {
            nVarB = kVarL.b(true);
            nVarB.a(intent, strG2, strG3, strG4, this.w, false);
        } else {
            nVarB = null;
            kVarL.i = null;
        }
        n nVar2 = nVarB;
        str2 = kVarL.e;
        strA = kVarL.a();
        i2 = 2;
        strP = p(str2, strA);
        z2 = false;
        hgVar = new hg(0);
        igVar2 = this.B;
        igVar2.getClass();
        if (igVar2.a.getBoolean(uh.a(-129854772247838L), false)) {
            hgVar.i(new StringReader(strP));
        } else {
            ig igVar14 = this.B;
            igVar14.getClass();
            hgVar.i(new StringReader(igVar14.a.getString(uh.a(-129803232640286L), uh.a(-129850477280542L))));
        }
        gf1VarC = hgVar.c();
        z = false;
        lgVar = gf1VarC.T[0];
        lgVar.b = this.B.m();
        lgVar.c = uh.a(-102938212203806L) + this.B.n();
        z2 = false;
        lgVar.d = false;
        if (this.B.v()) {
            gf1VarC.t = true;
            gf1VarC.q = this.B.d();
            gf1VarC.r = this.B.f();
        }
        iQ = this.B.q();
        if (iQ != 3) {
            lgVar.c = String.valueOf(this.B.o());
        } else {
            lgVar.c = String.valueOf(this.B.o());
        }
        if (this.B.g()) {
            if (this.B.g()) {
            }
        } else if (this.B.g()) {
        }
        String strC4 = gf1VarC.c(this, true);
        uh.a(-102968276974878L);
        Object[] objArr4 = new Object[1];
        r19 = 0;
        r19 = 0;
        objArr4[0] = Integer.valueOf(strC4.length());
        String.format(uh.a(-103032701484318L), objArr4);
        str2 = str2;
        i3 = 1;
        i2 = 2;
        strA = strA;
        return t(kVarL, strC4, strG, nVar2, strG5, strG6, strG7, strG8, strR, strPw_repl, booleanExtra, strG9, strG10, strG11, strG12);
    }

    public final void g(int i2, String str, String str2) {
        h(i2, str, str2, null, null);
    }

    public final void h(int i2, String str, String str2, String str3, g gVar) {
        e eVar = (e) this.i.get(str);
        f fVar = new f();
        int i3 = i2 | 2;
        fVar.c = i3;
        if (eVar != null) {
            fVar.i = eVar.d;
            fVar.g = eVar.c;
            fVar.j = eVar.e;
            fVar.d = eVar.b;
            fVar.k = gVar;
            fVar.c = i3 | eVar.a;
        } else {
            fVar.j = R.string.ui;
        }
        fVar.f = str;
        if (str2 != null) {
            fVar.e = str2;
        } else {
            fVar.e = uh.a(-109067130535198L);
        }
        if ((fVar.c & 4) != 0) {
            fVar.b = SystemClock.elapsedRealtime() + 60000;
        }
        fVar.h = str3;
        Handler handler = this.r;
        handler.sendMessage(handler.obtainMessage(1, fVar));
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0272 A[PHI: r0
      0x0272: PHI (r0v65 renz.javacodez.vpn.service.RenzOpenVPNservice$k) = (r0v56 renz.javacodez.vpn.service.RenzOpenVPNservice$k), (r0v68 renz.javacodez.vpn.service.RenzOpenVPNservice$k) binds: [B:105:0x0270, B:47:0x0128] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:151:0x0333  */
    /* JADX WARN: Code duplicated, block: B:152:0x0336  */
    /* JADX WARN: Code duplicated, block: B:154:0x033a  */
    /* JADX WARN: Code duplicated, block: B:157:0x0341  */
    /* JADX WARN: Code duplicated, block: B:159:0x0347  */
    /* JADX WARN: Code duplicated, block: B:162:0x0359  */
    /* JADX WARN: Code duplicated, block: B:164:0x0373  */
    /* JADX WARN: Code duplicated, block: B:167:0x037d  */
    /* JADX WARN: Code duplicated, block: B:169:0x0381  */
    /* JADX WARN: Code duplicated, block: B:171:0x038b  */
    /* JADX WARN: Code duplicated, block: B:172:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:180:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:182:0x0416  */
    /* JADX WARN: Code duplicated, block: B:183:0x042a  */
    /* JADX WARN: Code duplicated, block: B:188:0x045c  */
    /* JADX WARN: Code duplicated, block: B:205:0x01f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0222 A[Catch: Exception -> 0x0226, TryCatch #2 {Exception -> 0x0226, blocks: (B:87:0x01c5, B:88:0x01f1, B:90:0x01f7, B:92:0x0222, B:95:0x0228, B:97:0x022e, B:98:0x0231, B:99:0x0248), top: B:199:0x01c5 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x022e A[Catch: Exception -> 0x0226, TryCatch #2 {Exception -> 0x0226, blocks: (B:87:0x01c5, B:88:0x01f1, B:90:0x01f7, B:92:0x0222, B:95:0x0228, B:97:0x022e, B:98:0x0231, B:99:0x0248), top: B:199:0x01c5 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0248 A[Catch: Exception -> 0x0226, LOOP:1: B:88:0x01f1->B:99:0x0248, LOOP_END, TRY_LEAVE, TryCatch #2 {Exception -> 0x0226, blocks: (B:87:0x01c5, B:88:0x01f1, B:90:0x01f7, B:92:0x0222, B:95:0x0228, B:97:0x022e, B:98:0x0231, B:99:0x0248), top: B:199:0x01c5 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:180:0x03ed, please report this as an issue */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        f.b bVar;
        String string;
        Notification.Builder builder;
        int i2;
        Notification.Builder builder2;
        CPUUsage cPUUsage;
        long bytesIn;
        double dUsage;
        Toast toastMakeText;
        m mVar;
        String str;
        MediaPlayer mediaPlayer;
        InputStream inputStreamOpen;
        File file;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        int i3;
        k kVar;
        String[] list;
        String[] list2;
        int i4;
        f fVar = this.j;
        f fVar2 = (fVar == null || (fVar.b != 0 && SystemClock.elapsedRealtime() > fVar.b)) ? null : this.j;
        int i5 = message.what;
        if (i5 == 1) {
            f fVar3 = (f) message.obj;
            switch (fVar3.j) {
                case R.string.ay /* 2131886142 */:
                    if (this.B.s() == 0) {
                        this.D = false;
                        w();
                        try {
                            if (!f(this.K, this.L)) {
                                n(uh.a(-109122965110046L));
                            }
                        } catch (Exception e2) {
                            str = uh.a(-109200274521374L) + e2.getMessage();
                            n(str);
                        }
                    }
                    break;
                case R.string.cr /* 2131886209 */:
                    if (!RenzUtils.checkAppSign(this)) {
                        int i6 = mc1.$r8$clinit;
                        mediaPlayer = new MediaPlayer();
                        inputStreamOpen = getAssets().open(uh.a(-156393375169822L));
                        file = new File(getFilesDir(), uh.a(-156414850006302L));
                        fileOutputStream = new FileOutputStream(file);
                        bArr = new byte[1024];
                        while (true) {
                            i3 = inputStreamOpen.read(bArr);
                            if (i3 <= 0) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                mediaPlayer.setDataSource(file.getAbsolutePath());
                                AudioManager audioManager = (AudioManager) getSystemService(uh.a(-156440619810078L));
                                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                                audioManager.setStreamVolume(3, streamMaxVolume - 1, 0);
                                if (!mediaPlayer.isPlaying()) {
                                    mediaPlayer.prepare();
                                }
                                if (!mediaPlayer.isLooping()) {
                                    mediaPlayer.setLooping(true);
                                }
                                new Timer().schedule(new mc1.a(audioManager, streamMaxVolume), 0L, 1000L);
                                mediaPlayer.start();
                            } else {
                                fileOutputStream.write(bArr, 0, i3);
                            }
                            break;
                        }
                    } else {
                        int i7 = mc1.$r8$clinit;
                        AssetManager assets = getAssets();
                        try {
                            String[] list3 = assets.list(uh.a(-156930246081822L));
                            if ((list3 == null || list3.length <= 0) && (((list = assets.list(uh.a(-156964605820190L))) == null || list.length <= 0) && ((list2 = assets.list(uh.a(-156998965558558L))) == null || list2.length <= 0))) {
                                String[] list4 = assets.list(uh.a(-157067685035294L));
                                int length = list4.length;
                                int i8 = 0;
                                while (true) {
                                    if (i8 < length) {
                                        if (!list4[i8].contains(uh.a(-157071980002590L))) {
                                            i8++;
                                        }
                                    }
                                }
                            }
                            int i9 = mc1.$r8$clinit;
                            mediaPlayer = new MediaPlayer();
                            try {
                                inputStreamOpen = getAssets().open(uh.a(-156393375169822L));
                                file = new File(getFilesDir(), uh.a(-156414850006302L));
                                fileOutputStream = new FileOutputStream(file);
                                bArr = new byte[1024];
                                while (true) {
                                    i3 = inputStreamOpen.read(bArr);
                                    if (i3 <= 0) {
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                        mediaPlayer.setDataSource(file.getAbsolutePath());
                                        AudioManager audioManager2 = (AudioManager) getSystemService(uh.a(-156440619810078L));
                                        int streamMaxVolume2 = audioManager2.getStreamMaxVolume(3);
                                        audioManager2.setStreamVolume(3, streamMaxVolume2 - 1, 0);
                                        if (!mediaPlayer.isPlaying()) {
                                            mediaPlayer.prepare();
                                        }
                                        if (!mediaPlayer.isLooping()) {
                                            mediaPlayer.setLooping(true);
                                        }
                                        new Timer().schedule(new mc1.a(audioManager2, streamMaxVolume2), 0L, 1000L);
                                        mediaPlayer.start();
                                    } else {
                                        fileOutputStream.write(bArr, 0, i3);
                                    }
                                }
                            } catch (Exception e3) {
                                if (e3 instanceof FileNotFoundException) {
                                    Process.killProcess(Process.myPid());
                                    System.exit(0);
                                }
                            }
                            break;
                        } catch (IOException unused) {
                        }
                    }
                    Toast.makeText(getApplicationContext(), uh.a(-109513807133982L), 0).show();
                    kVar = this.f;
                    if (kVar != null) {
                        kVar.i = null;
                    }
                    break;
                case R.string.d6 /* 2131886224 */:
                case R.string.mz /* 2131886592 */:
                    this.o.clear();
                    break;
                case R.string.d8 /* 2131886226 */:
                    CPUUsage cPUUsage2 = this.d;
                    if (cPUUsage2 != null) {
                        cPUUsage2.stop();
                    }
                    if (this.s != null) {
                        this.s = null;
                        Timer timer = this.C;
                        if (timer != null) {
                            timer.cancel();
                        }
                        stopForeground(true);
                    }
                    if (!this.y) {
                        s(null);
                    }
                    break;
                case R.string.ds /* 2131886247 */:
                    if (fVar2 != null) {
                        if ((fVar2.c & 1) != 0) {
                            fVar3.g = 0;
                        }
                        kVar = this.f;
                        if (kVar != null && (i4 = fVar2.j) != R.string.mh && i4 != R.string.du) {
                            kVar.i = null;
                        }
                    }
                    break;
                case R.string.kt /* 2131886511 */:
                    this.D = true;
                    break;
                case R.string.kx /* 2131886515 */:
                    fVar3.e = uh.a(-109621181316382L);
                    break;
                case R.string.md /* 2131886570 */:
                    if (this.B.s() == 0) {
                        this.D = false;
                        w();
                        try {
                            n(uh.a(-109286173867294L));
                            if (!f(this.K, this.L)) {
                                n(uh.a(-109350598376734L));
                            }
                        } catch (Exception e4) {
                            str = uh.a(-109427907788062L) + e4.getMessage();
                            n(str);
                        }
                    }
                    break;
            }
            if (fVar3.j == R.string.e2 && (mVar = this.v) != null) {
                String str2 = fVar3.e;
                int i10 = m.c;
                for (k kVar2 : mVar) {
                    String str3 = kVar2.d;
                    if (str3 != null && str3.equals(str2)) {
                        kVar2.d = null;
                        RenzOpenVPNservice.this.u.delete_key_by_profile(kVar2.f, uh.a(-88270898887966L));
                    }
                }
            }
            if (this.g) {
                int i11 = fVar3.g;
                if (i11 == 2) {
                    toastMakeText = Toast.makeText(this, fVar3.j, 0);
                } else if (i11 == 3) {
                    toastMakeText = Toast.makeText(this, fVar3.j, 1);
                }
                toastMakeText.show();
            }
            int i12 = fVar3.j;
            if (i12 != R.string.cr || (fVar2 != null && fVar2.j == R.string.cr)) {
                if (i12 != R.string.cr && fVar2 != null && fVar2.j == R.string.cr) {
                    bVar = f.b.d;
                }
                if ((fVar3.c & 4) != 0) {
                    this.n = fVar3;
                } else if (fVar3.g >= 2) {
                    this.j = fVar3;
                }
                string = i12 != R.string.uh ? fVar3.toString() : null;
                if (string != null) {
                    uh.a(-109625476283678L);
                }
                if (fVar3.j == R.string.d6) {
                    n(String.format(uh.a(-109689900793118L), getString(R.string.app)));
                }
                if (string != null) {
                    n(string);
                }
                if (fVar3.j == R.string.d8) {
                    cPUUsage = this.d;
                    if (cPUUsage != null) {
                        dUsage = cPUUsage.usage();
                        if (dUsage > 0.0d) {
                            ClientAPI_InterfaceStats clientAPI_InterfaceStatsTun_stats = this.t.tun_stats();
                            bytesIn = (long) ((clientAPI_InterfaceStatsTun_stats.getBytesIn() + clientAPI_InterfaceStatsTun_stats.getBytesOut()) / dUsage);
                        } else {
                            bytesIn = 0;
                        }
                    } else {
                        bytesIn = 0;
                    }
                    n(String.format(uh.a(-109810159877406L), Long.valueOf(bytesIn)));
                    n(String.format(uh.a(-109947598830878L), getString(R.string.app)));
                }
                builder = this.s;
                if (builder != null && fVar3.g >= 1) {
                    builder.setContentText(getResources().getString(fVar3.j));
                    i2 = fVar3.j;
                    builder2 = this.s;
                    if (i2 == R.string.cr) {
                        builder2.setContentTitle(uh.a(-106610409241886L) + this.B.p());
                        if (this.B.s() == 0) {
                            Timer timer2 = new Timer();
                            this.C = timer2;
                            timer2.scheduleAtFixedRate(new renz.javacodez.vpn.service.a(this, fVar3), 0L, 1000L);
                        }
                    } else {
                        builder2.setContentTitle(getString(R.string.app));
                        this.s.setContentText(getString(fVar3.j));
                    }
                    this.A.notify(1642, this.s.getNotification());
                    startForeground(1642, this.s.getNotification());
                }
                for (g gVar : this.c) {
                    if ((fVar3.c & 16) != 0 || gVar != fVar3.k) {
                        gVar.a(fVar3);
                    }
                }
            } else {
                bVar = f.b.c;
            }
            fVar3.l = bVar;
            if ((fVar3.c & 4) != 0) {
                this.n = fVar3;
            } else if (fVar3.g >= 2) {
                this.j = fVar3;
            }
            if (i12 != R.string.uh) {
            }
            if (string != null) {
                uh.a(-109625476283678L);
            }
            if (fVar3.j == R.string.d6) {
                n(String.format(uh.a(-109689900793118L), getString(R.string.app)));
            }
            if (string != null) {
                n(string);
            }
            if (fVar3.j == R.string.d8) {
                cPUUsage = this.d;
                if (cPUUsage != null) {
                    dUsage = cPUUsage.usage();
                    if (dUsage > 0.0d) {
                        ClientAPI_InterfaceStats clientAPI_InterfaceStatsTun_stats2 = this.t.tun_stats();
                        bytesIn = (long) ((clientAPI_InterfaceStatsTun_stats2.getBytesIn() + clientAPI_InterfaceStatsTun_stats2.getBytesOut()) / dUsage);
                    } else {
                        bytesIn = 0;
                    }
                } else {
                    bytesIn = 0;
                }
                n(String.format(uh.a(-109810159877406L), Long.valueOf(bytesIn)));
                n(String.format(uh.a(-109947598830878L), getString(R.string.app)));
            }
            builder = this.s;
            if (builder != null) {
                builder.setContentText(getResources().getString(fVar3.j));
                i2 = fVar3.j;
                builder2 = this.s;
                if (i2 == R.string.cr) {
                    builder2.setContentTitle(uh.a(-106610409241886L) + this.B.p());
                    if (this.B.s() == 0) {
                        Timer timer3 = new Timer();
                        this.C = timer3;
                        timer3.scheduleAtFixedRate(new renz.javacodez.vpn.service.a(this, fVar3), 0L, 1000L);
                    }
                } else {
                    builder2.setContentTitle(getString(R.string.app));
                    this.s.setContentText(getString(fVar3.j));
                }
                this.A.notify(1642, this.s.getNotification());
                startForeground(1642, this.s.getNotification());
            }
            while (r0.hasNext()) {
                if ((fVar3.c & 16) != 0) {
                }
                gVar.a(fVar3);
            }
        } else {
            if (i5 == 2) {
                j jVar = (j) message.obj;
                uh.a(-110063562947870L);
                String.format(uh.a(-110127987457310L), jVar.a);
                o(jVar);
                return true;
            }
            if (i5 != 99) {
                uh.a(-110162347195678L);
                uh.a(-110226771705118L);
                return true;
            }
            c cVarI = i();
            if (this.s != null) {
                this.s.setContentText(String.format(uh.a(-109071425502494L), r(cVarI.b), r(cVarI.a)));
                this.A.notify(1642, this.s.getNotification());
                startForeground(1642, this.s.getNotification());
                return true;
            }
        }
        return true;
    }

    public final c i() {
        c cVar = new c();
        ClientAPI_TransportStats clientAPI_TransportStatsTransport_stats = this.t.transport_stats();
        cVar.d = -1;
        if (!this.b) {
            cVar.c = 0;
            cVar.a = 0L;
            cVar.b = 0L;
            return cVar;
        }
        int iElapsedRealtime = ((int) (SystemClock.elapsedRealtime() - this.z)) / InternalZipConstants.AES_HASH_ITERATIONS;
        cVar.c = iElapsedRealtime;
        if (iElapsedRealtime < 0) {
            cVar.c = 0;
        }
        cVar.a = clientAPI_TransportStatsTransport_stats.getBytesIn();
        cVar.b = clientAPI_TransportStatsTransport_stats.getBytesOut();
        int lastPacketReceived = clientAPI_TransportStatsTransport_stats.getLastPacketReceived();
        if (lastPacketReceived >= 0) {
            cVar.d = lastPacketReceived >> 10;
        }
        return cVar;
    }

    public final m j() {
        if (this.v == null) {
            q();
        }
        return this.v;
    }

    public final boolean k(String str, String str2, boolean z) {
        boolean z2;
        String str3;
        String strA;
        if (!l.b(str2) || FileUtil.dirname(str2) != null) {
            g(1, uh.a(-98626065038622L), str2);
            return false;
        }
        if (z) {
            ClientAPI_MergeConfig clientAPI_MergeConfigMerge_config_string = new ClientAPI_OpenVPNClientHelper().merge_config_string(str);
            String str4 = uh.a(-98114963930398L) + clientAPI_MergeConfigMerge_config_string.getStatus();
            if (!str4.equals(uh.a(-98153618636062L))) {
                g(1, str4, clientAPI_MergeConfigMerge_config_string.getErrorText());
                return false;
            }
            str = clientAPI_MergeConfigMerge_config_string.getProfileContent();
        }
        ClientAPI_Config clientAPI_Config = new ClientAPI_Config();
        clientAPI_Config.setContent(str);
        ClientAPI_EvalConfig clientAPI_EvalConfigEval_config = new ClientAPI_OpenVPNClientHelper().eval_config(clientAPI_Config);
        if (clientAPI_EvalConfigEval_config.getError()) {
            g(1, uh.a(-98248107916574L), String.format(uh.a(-98334007262494L), str2, clientAPI_EvalConfigEval_config.getMessage()));
            return false;
        }
        String strA2 = uh.a(-98368367000862L);
        if (clientAPI_EvalConfigEval_config.getError()) {
            clientAPI_EvalConfigEval_config.getMessage();
            str3 = str2;
        } else {
            clientAPI_EvalConfigEval_config.getUserlockedUsername();
            boolean autologin = clientAPI_EvalConfigEval_config.getAutologin();
            clientAPI_EvalConfigEval_config.getExternalPki();
            clientAPI_EvalConfigEval_config.getPrivateKeyPasswordRequired();
            clientAPI_EvalConfigEval_config.getAllowPasswordSave();
            if (clientAPI_EvalConfigEval_config.getStaticChallenge().length() > 0) {
                clientAPI_EvalConfigEval_config.getStaticChallengeEcho();
            }
            String profileName = clientAPI_EvalConfigEval_config.getProfileName();
            String friendlyName = clientAPI_EvalConfigEval_config.getFriendlyName();
            strA2.equals(uh.a(-88017495817502L));
            if (friendlyName.length() > 0) {
                profileName = friendlyName;
                z2 = true;
            } else {
                z2 = false;
            }
            String strC = (str2 == null || !str2.equalsIgnoreCase(uh.a(-88056150523166L))) ? str2 : null;
            if (l.b(strC)) {
                strC = l.c(strC);
            }
            String str5 = (strC == null || profileName == null || !strC.equals(profileName)) ? strC : null;
            StringBuffer stringBuffer = new StringBuffer();
            if (autologin && !z2 && str5 == null) {
                stringBuffer.append(getText(R.string.b1).toString());
            }
            if (str5 != null) {
                stringBuffer.append(str5);
            }
            String string = stringBuffer.toString();
            ArrayList arrayList = new ArrayList();
            ClientAPI_ServerEntryVector serverList = clientAPI_EvalConfigEval_config.getServerList();
            int size = serverList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ClientAPI_ServerEntry clientAPI_ServerEntry = serverList.get(i2);
                p pVar = new p();
                pVar.b = clientAPI_ServerEntry.getServer();
                pVar.a = clientAPI_ServerEntry.getFriendlyName();
                arrayList.add(pVar);
            }
            this.u.get_string_by_profile(string, uh.a(-88107690130718L));
            str3 = string;
        }
        try {
            if (strA2.equals(uh.a(-88154934770974L)) || (strA = l.a(str3)) == null) {
                strA = str2;
            }
            FileUtil.writeFileAppPrivate(this, strA, str);
            this.x.remove(uh.a(-98407021706526L), str3);
            this.x.remove(uh.a(-98428496543006L), str3);
            q();
            try {
                h(0, uh.a(-98441381444894L), str3, str3, null);
                return true;
            } catch (IOException unused) {
                g(1, uh.a(-98540165692702L), str2);
                return false;
            }
        } catch (IOException unused2) {
        }
    }

    public final k l(String str) {
        j();
        k kVarE = this.v.e(str);
        if (kVarE != null) {
            return kVarE;
        }
        g(1, uh.a(-100880922869022L), str);
        return null;
    }

    @Override // net.openvpn.ovpn3.OpenVPNClientThread.EventReceiver
    public final void log(ClientAPI_LogInfo clientAPI_LogInfo) {
        j jVar = new j();
        jVar.a = clientAPI_LogInfo.getText();
        Handler handler = this.r;
        handler.sendMessage(handler.obtainMessage(2, jVar));
    }

    public final void m(String str) {
        j jVar = new j();
        jVar.a = str;
        Handler handler = this.r;
        handler.sendMessage(handler.obtainMessage(2, jVar));
    }

    public final void n(String str) {
        j jVar = new j();
        jVar.a = str;
        o(jVar);
    }

    public final void o(j jVar) {
        String strR;
        String strR2;
        ig igVar = this.B;
        if (igVar != null) {
            boolean zContains = jVar.a.contains(igVar.m());
            String str = jVar.a;
            ig igVar2 = this.B;
            if (zContains) {
                strR = igVar2.m();
                strR2 = this.B.m();
            } else {
                boolean zContains2 = str.contains(igVar2.l());
                str = jVar.a;
                ig igVar3 = this.B;
                if (zContains2) {
                    strR = igVar3.l();
                    strR2 = this.B.l();
                } else if (str.contains(igVar3.r())) {
                    str = jVar.a;
                    strR = this.B.r();
                    strR2 = this.B.r();
                }
            }
            jVar.a = str.replace(strR, ig.u(strR2));
        }
        if (jVar.a.startsWith(uh.a(-110329850920222L))) {
            jVar.a = uh.a(-110355620723998L);
        }
        if (jVar.a.contains(uh.a(-110359915691294L))) {
            jVar.a = uh.a(-110424340200734L);
        }
        if (jVar.a.contains(uh.a(-110428635168030L))) {
            jVar.a = uh.a(-110467289873694L);
        }
        if (jVar.a.contains(uh.a(-110471584840990L))) {
            jVar.a = uh.a(-110518829481246L);
        }
        if (jVar.a.contains(uh.a(-110523124448542L))) {
            jVar.a = uh.a(-110587548957982L);
        }
        if (jVar.a.contains(uh.a(-110591843925278L))) {
            jVar.a = uh.a(-110617613729054L);
        }
        if (jVar.a.contains(uh.a(-110621908696350L))) {
            jVar.a = uh.a(-110673448303902L);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(uh.a(-110729282878750L), Locale.getDefault());
        String strA = uh.a(-110776527519006L);
        if (jVar.a.isEmpty()) {
            return;
        }
        jVar.a = String.format(strA, simpleDateFormat.format(new Date()), jVar.a);
        ArrayDeque<j> arrayDeque = this.o;
        arrayDeque.addLast(jVar);
        while (arrayDeque.size() > 250) {
            arrayDeque.removeFirst();
        }
        Iterator<g> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().d(jVar);
        }
    }

    @Override // android.net.VpnService, android.app.Service
    public final IBinder onBind(Intent intent) {
        if (intent == null || !intent.getAction().equals(uh.a(-106777912966430L))) {
            uh.a(-106885287148830L);
            String.format(uh.a(-106949711658270L), intent);
            return super.onBind(intent);
        }
        uh.a(-107074265709854L);
        String.format(uh.a(-107138690219294L), intent);
        return this.p;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        uh.a(-95039767346462L);
        uh.a(-95104191855902L);
        String strCrypto_self_test = new ClientAPI_OpenVPNClientHelper().crypto_self_test();
        if (strCrypto_self_test.length() > 0) {
            uh.a(-94863673687326L);
            String.format(uh.a(-94928098196766L), strCrypto_self_test);
        }
        this.r = new Handler(this);
        this.A = (NotificationManager) getSystemService(uh.a(-95233040874782L));
        HashMap map = new HashMap();
        this.i = map;
        map.put(uh.a(-113383572667678L), new e(R.string.mz, R.drawable.dj, 20, 2, 0));
        this.i.put(uh.a(-113439407242526L), new e(R.string.n5, R.drawable.dj, 30, 1, 0));
        this.i.put(uh.a(-113473766980894L), new e(R.string.ut, R.drawable.dj, 40, 1, 0));
        this.i.put(uh.a(-113521011621150L), new e(R.string.us, R.drawable.dj, 50, 1, 0));
        this.i.put(uh.a(-113542486457630L), new e(R.string.cs, R.drawable.dj, 60, 1, 0));
        this.i.put(uh.a(-113589731097886L), new e(R.string.f1, R.drawable.dj, 70, 1, 0));
        this.i.put(uh.a(-113636975738142L), new e(R.string.aw, R.drawable.dj, 80, 1, 0));
        this.i.put(uh.a(-113679925411102L), new e(R.string.a6, R.drawable.dj, 90, 1, 0));
        this.i.put(uh.a(-113727170051358L), new e(R.string.cr, R.drawable.fw, 100, 3, 0));
        this.i.put(uh.a(-113770119724318L), new e(R.string.ds, R.drawable.dw, 0, 2, 0));
        this.i.put(uh.a(-113825954299166L), new e(R.string.ay, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-113877493906718L), new e(R.string.kx, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-113954803318046L), new e(R.string.bn, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114027817762078L), new e(R.string.th, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114096537238814L), new e(R.string.du, R.drawable.e4, 0, 2, 0));
        this.i.put(uh.a(-114173846650142L), new e(R.string.ud, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114246861094174L), new e(R.string.u9, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114319875538206L), new e(R.string.re, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114397184949534L), new e(R.string.lp, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114474494360862L), new e(R.string.cm, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114577573575966L), new e(R.string.jt, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114650588019998L), new e(R.string.dg, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114702127627550L), new e(R.string.d2, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114783732006174L), new e(R.string.fm, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114856746450206L), new e(R.string.fo, R.drawable.o_, 0, 0, 0));
        this.i.put(uh.a(-114878221286686L), new e(R.string.uu, R.drawable.o_, 0, 0, 0));
        this.i.put(uh.a(-114899696123166L), new e(R.string.mh, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-114972710567198L), new e(R.string.md, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-115024250174750L), new e(R.string.m7, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-115118739455262L), new e(R.string.e1, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-115165984095518L), new e(R.string.e2, R.drawable.e4, 0, 0, 0));
        this.i.put(uh.a(-115247588474142L), new e(R.string.kt, R.drawable.nn, 0, 3, 0));
        this.i.put(uh.a(-115273358277918L), new e(R.string.n7, R.drawable.dj, 0, 2, 0));
        this.i.put(uh.a(-115303423048990L), new e(R.string.d6, R.drawable.dj, 10, 1, 0));
        this.i.put(uh.a(-115385027427614L), new e(R.string.d8, -1, 0, 0, 0));
        this.i.put(uh.a(-115475221740830L), new e(R.string.d7, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-115552531152158L), new e(R.string.d5, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-115647020432670L), new e(R.string.bz, R.drawable.e4, 0, 3, 0));
        this.i.put(uh.a(-115698560040222L), new e(R.string.c1, R.drawable.dj, 0, 2, 0));
        this.i.put(uh.a(-115762984549662L), new e(R.string.lj, R.drawable.o_, 0, 2, 44));
        this.i.put(uh.a(-115861768797470L), new e(R.string.lf, R.drawable.do_res_0x7f0800a2, 0, 2, 12));
        this.i.put(uh.a(-115960553045278L), new e(R.string.le, R.drawable.e4, 0, 2, 4));
        this.i.put(uh.a(-116055042325790L), new e(R.string.lq, R.drawable.e4, 0, 3, 4));
        this.i.put(uh.a(-116140941671710L), new e(R.string.l7, R.drawable.e4, 0, 3, 4));
        this.i.put(uh.a(-116213956115742L), new e(R.string.ly, R.drawable.e4, 0, 3, 4));
        this.i.put(uh.a(-116299855461662L), new e(R.string.lg, R.drawable.e4, 0, 3, 4));
        this.i.put(uh.a(-116398639709470L), new e(R.string.lt, R.drawable.o_, 0, 2, 12));
        this.i.put(uh.a(-116497423957278L), new e(R.string.ls, R.drawable.e4, 0, 2, 4));
        this.i.put(uh.a(-116591913237790L), new e(R.string.lk, R.drawable.e4, 0, 2, 4));
        this.i.put(uh.a(-116694992452894L), new e(R.string.lm, R.drawable.e4, 0, 2, 4));
        this.i.put(uh.a(-116815251537182L), new e(R.string.ln, R.drawable.e4, 0, 2, 4));
        this.i.put(uh.a(-116939805588766L), new e(R.string.lo, R.drawable.e4, 0, 2, 4));
        this.i.put(uh.a(-117038589836574L), new e(R.string.ll, R.drawable.e4, 0, 2, 4));
        this.i.put(uh.a(-117176028790046L), new e(R.string.uh, R.drawable.o_, 0, 0, 8));
        this.q = new d(this);
        o oVar = new o(this);
        this.F = oVar;
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(oVar, new IntentFilter(uh.a(-94339687677214L)), 4);
        } else {
            registerReceiver(oVar, new IntentFilter(uh.a(-94382637350174L)));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(uh.a(-94425587023134L));
        intentFilter.addAction(uh.a(-94584500813086L));
        intentFilter.addAction(uh.a(-94721939766558L));
        d dVar = this.q;
        ConnectivityManager connectivityManagerA = dVar.a();
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(15).build();
        ng ngVar = new ng(dVar);
        dVar.a = ngVar;
        connectivityManagerA.registerNetworkCallback(networkRequestBuild, ngVar);
        this.u = new PrefUtil(PreferenceManager.getDefaultSharedPreferences(this));
        this.x = new PasswordUtil(PreferenceManager.getDefaultSharedPreferences(this));
        ProxyList proxyList = new ProxyList(getResources().getString(R.string.mi));
        this.w = proxyList;
        proxyList.set_backing_file(this, uh.a(-95288875449630L));
        this.w.load();
        b2.f19b = this;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        uh.a(-108745007987998L);
        uh.a(-108809432497438L);
        this.y = true;
        w();
        d dVar = this.q;
        dVar.a().unregisterNetworkCallback(dVar.a);
        o oVar = this.F;
        if (oVar != null) {
            unregisterReceiver(oVar);
        }
        super.onDestroy();
    }

    @Override // android.net.VpnService
    public final void onRevoke() {
        uh.a(-108908216745246L);
        uh.a(-108972641254686L);
        w();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        m mVarJ;
        long j2;
        n nVarB;
        Intent intent2;
        if (intent != null) {
            String strA = uh.a(-95344710024478L);
            String action = intent.getAction();
            uh.a(-95430609370398L);
            int i4 = 0;
            String.format(uh.a(-95495033879838L), action);
            if (action.equals(uh.a(-95628177866014L))) {
                this.B = ig.h(this);
                m(uh.a(-95739847015710L));
                g(1, uh.a(-97015452302622L), uh.a(-97062696942878L));
                lb1 lb1Var = new lb1(this, new bv0(this, i4));
                this.I = lb1Var;
                lb1Var.start();
                u();
                return 1;
            }
            if (action.equals(uh.a(-95825746361630L))) {
                this.L = intent;
                this.K = strA;
                b2.f15a = this;
                b2.f19b = this;
                this.B = ig.h(this);
                d(strA, intent, false);
                return 1;
            }
            if (action.equals(uh.a(-95946005445918L))) {
                k kVarL = l(intent.getStringExtra(strA.concat(uh.a(-100958232280350L))));
                if (kVarL != null && (nVarB = kVarL.b(false)) != null) {
                    String stringExtra = intent.getStringExtra(strA.concat(uh.a(-100996886986014L)));
                    String stringExtra2 = intent.getStringExtra(strA.concat(uh.a(-101048426593566L)));
                    String stringExtra3 = intent.getStringExtra(strA.concat(uh.a(-101117146070302L)));
                    boolean booleanExtra = intent.getBooleanExtra(strA.concat(uh.a(-101185865547038L)), false);
                    ProxyList proxyList = this.w;
                    ProxyList.Item item = nVarB.d;
                    if (item == null || !item.name().equals(stringExtra) || stringExtra2 == null || stringExtra3 == null) {
                        intent2 = null;
                    } else {
                        nVarB.f = stringExtra2;
                        nVarB.e = stringExtra3;
                        nVarB.c = true;
                        if (booleanExtra) {
                            ProxyList.Item item2 = nVarB.d;
                            item2.username = stringExtra2;
                            item2.password = stringExtra3;
                            item2.remember_creds = booleanExtra;
                            proxyList.put(item2);
                            proxyList.save();
                        }
                        intent2 = nVarB.a;
                    }
                    if (intent2 != null) {
                        d(strA, intent2, true);
                        return 1;
                    }
                }
                g(1, uh.a(-101280354827550L), null);
                return 1;
            }
            if (action.equals(uh.a(-96143573941534L))) {
                if (this.B.s() == 2) {
                    v();
                }
                boolean booleanExtra2 = intent.getBooleanExtra(strA.concat(uh.a(-104484400430366L)), false);
                this.D = true;
                w();
                if (booleanExtra2) {
                    stopSelf();
                    return 1;
                }
            } else {
                if (action.equals(uh.a(-96276717927710L))) {
                    k(intent.getStringExtra(strA.concat(uh.a(-98003294780702L))), intent.getStringExtra(strA.concat(uh.a(-98041949486366L))), intent.getBooleanExtra(strA.concat(uh.a(-98084899159326L)), false));
                    return 1;
                }
                if (action.equals(uh.a(-96427041783070L))) {
                    ClientAPI_MergeConfig clientAPI_MergeConfigMerge_config = new ClientAPI_OpenVPNClientHelper().merge_config(intent.getStringExtra(strA.concat(uh.a(-97844380990750L))), true);
                    String str = uh.a(-97870150794526L) + clientAPI_MergeConfigMerge_config.getStatus();
                    if (str.equals(uh.a(-97908805500190L))) {
                        k(clientAPI_MergeConfigMerge_config.getProfileContent(), clientAPI_MergeConfigMerge_config.getBasename(), false);
                        return 1;
                    }
                    g(1, str, clientAPI_MergeConfigMerge_config.getErrorText());
                    return 1;
                }
                if (action.equals(uh.a(-96646085115166L))) {
                    String stringExtra4 = intent.getStringExtra(strA.concat(uh.a(-99102806408478L)));
                    j();
                    k kVarE = this.v.e(stringExtra4);
                    if (kVarE != null) {
                        if (!kVarE.c()) {
                            g(1, uh.a(-99369094380830L), stringExtra4);
                            return 1;
                        }
                        if (this.b && kVarE == this.f) {
                            w();
                        }
                        boolean zDeleteFile = deleteFile(kVarE.a());
                        String str2 = kVarE.f;
                        if (!zDeleteFile) {
                            g(1, uh.a(-99274605100318L), str2);
                            return 1;
                        }
                        this.x.remove(uh.a(-99141461114142L), stringExtra4);
                        this.x.remove(uh.a(-99162935950622L), stringExtra4);
                        q();
                        g(0, uh.a(-99175820852510L), str2);
                        return 1;
                    }
                } else if (action.equals(uh.a(-96796408970526L))) {
                    String stringExtra5 = intent.getStringExtra(strA.concat(uh.a(-99463583661342L)));
                    String stringExtra6 = intent.getStringExtra(strA.concat(uh.a(-99502238367006L)));
                    j();
                    k kVarE2 = this.v.e(stringExtra5);
                    if (kVarE2 != null) {
                        if (!kVarE2.c() || stringExtra6 == null || stringExtra6.length() == 0) {
                            uh.a(-99558072941854L);
                            uh.a(-99622497451294L);
                            j2 = -99832950848798L;
                        } else {
                            File filesDir = getFilesDir();
                            String str3 = String.format(uh.a(-99927440129310L), filesDir.getPath(), kVarE2.g);
                            String str4 = String.format(uh.a(-99953209933086L), filesDir.getPath(), l.a(stringExtra6));
                            if (FileUtil.renameFile(str3, str4)) {
                                q();
                                k kVarE3 = this.v.e(stringExtra6);
                                if (kVarE3 != null) {
                                    this.x.remove(uh.a(-100339756989726L), stringExtra5);
                                    this.x.remove(uh.a(-100361231826206L), stringExtra5);
                                    String strA2 = uh.a(-100374116728094L);
                                    String str5 = kVarE3.f;
                                    h(0, strA2, str5, str5, null);
                                    return 1;
                                }
                                uh.a(-99978979736862L);
                                uh.a(-100043404246302L);
                                j2 = -100245267709214L;
                            } else {
                                uh.a(-100472900975902L);
                                String.format(uh.a(-100537325485342L), str3, str4);
                                j2 = -100786433588510L;
                            }
                        }
                        g(1, uh.a(j2), stringExtra5);
                        return 1;
                    }
                } else if (action.equals(uh.a(-96946732825886L)) && (mVarJ = j()) != null) {
                    while (i4 < mVarJ.size()) {
                        k kVar = mVarJ.get(i4);
                        if (kVar != null) {
                            String str6 = kVar.f;
                            deleteFile(str6);
                            this.x.remove(uh.a(-97810021252382L), str6);
                            this.x.remove(uh.a(-97831496088862L), str6);
                        }
                        i4++;
                    }
                    q();
                }
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        uh.a(-108543144525086L);
        String.format(uh.a(-108607569034526L), intent.toString());
        return super.onUnbind(intent);
    }

    public final String p(String str, String str2) {
        if (str.equals(uh.a(-113310558223646L))) {
            return FileUtil.readAsset(this, str2);
        }
        if (str.equals(uh.a(-113344917962014L))) {
            return FileUtil.readFileAppPrivate(this, str2);
        }
        throw new h();
    }

    @Override // net.openvpn.ovpn3.OpenVPNClientThread.EventReceiver
    public final boolean pause_on_connection_timeout() {
        uh.a(-111059995360542L);
        String.format(uh.a(-111124419869982L), Boolean.FALSE);
        return false;
    }

    public final void q() {
        m mVar = new m();
        try {
            m.d(mVar, uh.a(-107649791327518L));
            m.d(mVar, uh.a(-107684151065886L));
            Collections.sort(mVar, new m.a());
        } catch (IOException unused) {
        }
        uh.a(-107722805771550L);
        uh.a(-107787230280990L);
        for (k kVar : mVar) {
            uh.a(-107890309496094L);
            String.format(uh.a(-107954734005534L), kVar.toString());
        }
        this.v = mVar;
    }

    public final void s(String str) {
        PrefUtil prefUtil = this.u;
        if (str != null) {
            prefUtil.set_string(uh.a(-113001320578334L), str);
        } else {
            prefUtil.delete_key(uh.a(-113100104826142L));
        }
    }

    @Override // net.openvpn.ovpn3.OpenVPNClientThread.EventReceiver
    public final boolean socket_protect(int i2) {
        boolean zProtect = protect(i2);
        uh.a(-110815182224670L);
        String.format(uh.a(-110879606734110L), Integer.valueOf(i2), Boolean.valueOf(zProtect));
        return zProtect;
    }

    public final boolean t(k kVar, String str, String str2, n nVar, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12) {
        int i2;
        String str13;
        String strA;
        ProxyList.Item item;
        if (this.b) {
            return false;
        }
        this.g = this.u.get_boolean(uh.a(-104510170234142L), false);
        OpenVPNClientThread openVPNClientThread = new OpenVPNClientThread();
        ClientAPI_Config clientAPI_Config = new ClientAPI_Config();
        ig.h(this);
        StringBuilder sbD = defpackage.e.d(str);
        sbD.append(String.format(uh.a(-104600364547358L), uh.a(-104823702846750L) + ig.e));
        clientAPI_Config.setContent(sbD.toString());
        clientAPI_Config.setInfo(true);
        if (str3 != null) {
            clientAPI_Config.setServerOverride(str3);
        }
        if (str4 != null) {
            clientAPI_Config.setProtoOverride(str4);
        }
        if (str6 != null) {
            try {
                i2 = Integer.parseInt(str6);
            } catch (NumberFormatException unused) {
                i2 = 0;
            }
            clientAPI_Config.setConnTimeout(i2);
        }
        if (str12 != null) {
            clientAPI_Config.setCompressionMode(str12);
        }
        if (str9 != null) {
            clientAPI_Config.setPrivateKeyPassword(str9);
        }
        clientAPI_Config.setTunPersist(this.u.get_boolean(uh.a(-104870947487006L), false));
        clientAPI_Config.setGoogleDnsFallback(this.u.get_boolean(uh.a(-105193070034206L), false));
        clientAPI_Config.setAltProxy(this.u.get_boolean(uh.a(-105278969380126L), false));
        String strA2 = uh.a(-105321919053086L);
        if (this.u.get_boolean(uh.a(-105386343562526L), false)) {
            strA2 = uh.a(-105480832843038L);
        }
        clientAPI_Config.setTlsCertProfileOverride(strA2);
        String str14 = this.u.get_string(uh.a(-105553847287070L));
        if (str14 != null) {
            clientAPI_Config.setTlsVersionMinOverride(str14);
        }
        if (str2 != null) {
            clientAPI_Config.setGuiVersion(str2);
        }
        boolean z2 = kVar.c;
        String str15 = kVar.f;
        if (z2) {
            if (str11 != null) {
                kVar.d = str11;
                RenzOpenVPNservice.this.u.set_string_by_profile(str15, uh.a(-88223654247710L), str11);
                str13 = str11;
            } else {
                str13 = kVar.d;
            }
            if (str13 != null) {
                if (str13.equals(uh.a(-105661221469470L))) {
                    clientAPI_Config.setDisableClientCert(true);
                } else {
                    clientAPI_Config.setExternalPkiAlias(str13);
                }
            }
        } else {
            str13 = str11;
        }
        if (nVar != null && (item = nVar.d) != null) {
            clientAPI_Config.setProxyHost(item.host);
            clientAPI_Config.setProxyPort(nVar.d.port);
            String str16 = nVar.f;
            if (str16 != null && nVar.e != null) {
                clientAPI_Config.setProxyUsername(str16);
                clientAPI_Config.setProxyPassword(nVar.e);
            }
            clientAPI_Config.setProxyAllowCleartextAuth(nVar.d.allow_cleartext_auth);
        }
        ClientAPI_EvalConfig clientAPI_EvalConfigEval_config = openVPNClientThread.eval_config(clientAPI_Config);
        if (clientAPI_EvalConfigEval_config.getError()) {
            g(1, uh.a(-105747120815390L), clientAPI_EvalConfigEval_config.getMessage());
            return false;
        }
        ClientAPI_ProvideCreds clientAPI_ProvideCreds = new ClientAPI_ProvideCreds();
        if (!clientAPI_EvalConfigEval_config.getAutologin() && str7 != null && str7.length() == 0) {
            g(1, uh.a(-105850200030494L), null);
            return false;
        }
        if (str7 != null) {
            clientAPI_ProvideCreds.setUsername(str7);
        }
        if (str8 != null) {
            clientAPI_ProvideCreds.setPassword(str8);
        }
        if (str10 != null) {
            clientAPI_ProvideCreds.setResponse(str10);
        }
        clientAPI_ProvideCreds.setCachePassword(z);
        clientAPI_ProvideCreds.setReplacePasswordWithSessionID(true);
        ClientAPI_Status clientAPI_StatusProvide_creds = openVPNClientThread.provide_creds(clientAPI_ProvideCreds);
        if (clientAPI_StatusProvide_creds.getError()) {
            g(1, uh.a(-105923214474526L), clientAPI_StatusProvide_creds.getMessage());
            return false;
        }
        uh.a(-105974754082078L);
        String strA3 = uh.a(-106039178591518L);
        if (nVar != null) {
            ProxyList.Item item2 = nVar.d;
            strA = item2 != null ? item2.name() : null;
        } else {
            strA = uh.a(-106468675321118L);
        }
        String.format(strA3, str15, str7, strA, str3, str4, str5, str6, str10, str13, str12);
        this.f = kVar;
        s(str15);
        this.D = false;
        u();
        g(0, uh.a(-106494445124894L), null);
        openVPNClientThread.connect(this);
        this.t = openVPNClientThread;
        this.z = SystemClock.elapsedRealtime();
        this.d = new CPUUsage();
        this.b = true;
        return true;
    }

    @Override // net.openvpn.ovpn3.OpenVPNClientThread.EventReceiver
    public final OpenVPNClientThread.TunBuilder tun_builder_new() {
        return new r();
    }

    public final void u() {
        PendingIntent pendingIntentE;
        if (this.s == null) {
            String strA = uh.a(-106576049503518L);
            Notification.Builder builder = new Notification.Builder(this);
            this.s = builder;
            if (Build.VERSION.SDK_INT >= 26) {
                builder.setChannelId(strA);
                NotificationManager notificationManager = this.A;
                String string = getString(R.string.bs);
                String string2 = getString(R.string.br);
                NotificationChannel notificationChannel = new NotificationChannel(strA, string, 2);
                notificationChannel.setShowBadge(true);
                notificationChannel.setDescription(string2);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            Notification.Builder builder2 = this.s;
            Iterator<g> it = this.c.iterator();
            while (it.hasNext()) {
                pendingIntentE = it.next().e(1);
                if (pendingIntentE != null) {
                    builder2.setContentIntent(pendingIntentE).setSmallIcon(R.drawable.ic_app_icon).setContentTitle(getString(R.string.app)).setContentText(getResources().getString(R.string.k2)).setOnlyAlertOnce(true).setOngoing(true).setWhen(new Date().getTime());
                    this.A.notify(1642, this.s.getNotification());
                    startForeground(1642, this.s.getNotification());
                }
            }
            pendingIntentE = null;
            builder2.setContentIntent(pendingIntentE).setSmallIcon(R.drawable.ic_app_icon).setContentTitle(getString(R.string.app)).setContentText(getResources().getString(R.string.k2)).setOnlyAlertOnce(true).setOngoing(true).setWhen(new Date().getTime());
            this.A.notify(1642, this.s.getNotification());
            startForeground(1642, this.s.getNotification());
        }
    }

    public final void v() {
        m(uh.a(-97560913149214L));
        stopForeground(true);
        new Thread(new a()).start();
    }

    public final void w() {
        if (this.b) {
            this.t.stop();
            this.t.wait_thread_short();
            uh.a(-108358460931358L);
            uh.a(-108422885440798L);
        }
    }
}
