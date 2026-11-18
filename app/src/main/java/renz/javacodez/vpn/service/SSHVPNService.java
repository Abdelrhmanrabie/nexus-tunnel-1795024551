package renz.javacodez.vpn.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.VpnService;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.ConnectionMonitor;
import com.trilead.ssh2.DynamicPortForwarder;
import com.trilead.ssh2.HTTPProxyData;
import com.trilead.ssh2.InteractiveCallback;
import com.trilead.ssh2.KnownHosts;
import com.trilead.ssh2.ProxyData;
import com.trilead.ssh2.ServerHostKeyVerifier;
import defpackage.as0;
import defpackage.ax0;
import defpackage.b2;
import defpackage.bk;
import defpackage.gj;
import defpackage.ha;
import defpackage.hy0;
import defpackage.ig;
import defpackage.l81;
import defpackage.mc1;
import defpackage.o6;
import defpackage.ok0$a;
import defpackage.pc1$a;
import defpackage.qz;
import defpackage.uh;
import defpackage.uo0;
import defpackage.us;
import defpackage.zw0;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SSHVPNService extends VpnService implements ServerHostKeyVerifier, InteractiveCallback, ConnectionMonitor, Handler.Callback {
    public boolean A;
    public us B;
    public String C;
    public Handler D;
    public boolean E;
    public Notification.Builder b;
    public NotificationManager c;
    public Connection g;
    public final ArrayDeque<zw0> j;
    public e n;
    public PowerManager.WakeLock o;
    public int p;
    public ig q;
    public Thread r;
    public ParcelFileDescriptor s;
    public uo0 t;
    public l81 u;
    public boolean v;
    public boolean w;
    public CountDownLatch x;
    public bk y;
    public int z;
    public SharedPreferences d = null;
    public DynamicPortForwarder f = null;
    public boolean i = false;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SSHVPNService sSHVPNService = SSHVPNService.this;
            l81 l81Var = sSHVPNService.u;
            if (l81Var != null) {
                l81Var.interrupt();
            }
            ParcelFileDescriptor parcelFileDescriptor = sSHVPNService.s;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            uo0 uo0Var = sSHVPNService.t;
            if (uo0Var != null) {
                uo0Var.interrupt();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SSHVPNService sSHVPNService = SSHVPNService.this;
            sSHVPNService.w = true;
            sSHVPNService.b();
            us usVar = sSHVPNService.B;
            if (usVar != null) {
                usVar.interrupt();
            }
            uo0 uo0Var = sSHVPNService.t;
            if (uo0Var != null) {
                uo0Var.interrupt();
            }
            bk bkVar = sSHVPNService.y;
            if (bkVar != null) {
                bkVar.interrupt();
            }
            CountDownLatch countDownLatch = sSHVPNService.x;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            Thread thread = sSHVPNService.r;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c implements pc1$a {
        public c() {
        }

        @Override // defpackage.pc1$a
        public final boolean a(Socket socket) {
            return SSHVPNService.this.protect(socket);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SSHVPNService.this.f();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface e {
        void b(int i);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class f extends Binder {
        public f() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class g {
        public int a;
    }

    static {
        uh.a(-122656407059742L);
        uh.a(-122699356732702L);
        uh.a(-122738011438366L);
        uh.a(-122815320849694L);
        uh.a(-122853975555358L);
        uh.a(-122901220195614L);
        uh.a(-122939874901278L);
        uh.a(-122978529606942L);
    }

    public SSHVPNService() {
        String str = ig.c;
        this.j = new ArrayDeque<>();
        this.p = R.string.qc;
        this.v = false;
        this.w = false;
        this.z = 2222;
        this.A = false;
        this.C = null;
        this.E = false;
    }

    public final void a() {
        String strA;
        try {
            String strR = this.q.r();
            String strJ = this.q.j();
            if (this.g.isAuthMethodAvailable(strR, uh.a(-119400821849374L))) {
                e(uh.a(-119439476555038L));
                d(R.string.q9);
                if (this.g.authenticateWithPassword(strR, strJ)) {
                    strA = uh.a(-119542555770142L);
                } else {
                    d(R.string.q_);
                    strA = uh.a(-119658519887134L);
                }
                e(strA);
            }
        } catch (Exception e2) {
            e(e2.getMessage());
        }
    }

    public final void b() {
        Connection connection = this.g;
        if (connection != null) {
            connection.close();
        }
        try {
            DynamicPortForwarder dynamicPortForwarder = this.f;
            if (dynamicPortForwarder != null) {
                dynamicPortForwarder.close();
            }
        } catch (Exception unused) {
        }
        d(R.string.qc);
    }

    public final PendingIntent c() {
        Intent intent = new Intent(this, (Class<?>) HamoTunnelPlusMain.class);
        intent.addFlags(67108864);
        intent.addFlags(65536);
        return PendingIntent.getActivity(this, 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
    }

    @Override // com.trilead.ssh2.ConnectionMonitor
    public final void connectionLost(Throwable th) {
        e(uh.a(-119753009167646L) + th.getMessage());
        this.A = false;
        if (((ConnectivityManager) getSystemService(uh.a(-121647089745182L))).getActiveNetworkInfo() != null) {
            if (th.getMessage().contains(uh.a(-119778778971422L))) {
                return;
            }
            f();
            return;
        }
        if (this.C == null) {
            this.C = getString(R.string.ui);
        }
        e(uh.a(-122265565035806L));
        i();
        stopForeground(true);
        stopSelf();
        this.w = true;
        this.v = false;
        this.i = false;
    }

    public final void d(int i) {
        g gVar = new g();
        gVar.a = i;
        Handler handler = this.D;
        handler.sendMessage(handler.obtainMessage(1, gVar));
    }

    public final void e(String str) {
        Handler handler = this.D;
        if (handler == null) {
            return;
        }
        zw0 zw0Var = new zw0();
        zw0Var.a = str;
        handler.sendMessage(handler.obtainMessage(0, zw0Var));
    }

    public final void f() {
        if (this.w || this.v || this.E) {
            return;
        }
        this.E = true;
        i();
        b();
        while (!this.w && !this.A) {
            this.v = true;
            e(uh.a(-119894743088414L));
            d(R.string.qd);
            try {
                g();
                this.v = false;
                this.E = false;
                return;
            } catch (Exception unused) {
                this.A = false;
                e(uh.a(-119959167597854L));
                this.v = false;
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused2) {
                    this.E = false;
                    return;
                }
            }
        }
        this.E = false;
    }

    public final void g() {
        Connection connection;
        ProxyData hTTPProxyData;
        int i;
        String string;
        d(R.string.qb);
        int i2 = 0;
        this.w = false;
        try {
            e(uh.a(-119151713746206L));
            int iQ = this.q.q();
            String strM = this.q.m();
            String strN = this.q.n();
            int iQ2 = this.q.q();
            if (iQ2 == 3 || iQ2 == 4 || iQ2 == 5) {
                strN = uh.a(-119254792961310L) + this.q.o();
            }
            if ((this.q.g() && iQ == 2) || iQ == 5) {
                strM = this.q.l();
                strN = uh.a(-119259087928606L);
            }
            if (this.q.s() == 4) {
                this.g = new Connection(uh.a(-119271972830494L), this.z);
                connection = new Connection(this.q.m(), 22);
                this.g = connection;
                hTTPProxyData = new gj(this, uh.a(-119314922503454L), this.z);
            } else {
                connection = new Connection(strM, Integer.parseInt(strN));
                this.g = connection;
                hTTPProxyData = new HTTPProxyData(uh.a(-119357872176414L), ig.e);
            }
            connection.setProxyData(hTTPProxyData);
            int i3 = 1;
            this.g.setCompression(true);
            this.g.addConnectionMonitor(this);
            this.g.connect(this, 30000, 30000);
            this.i = true;
            int i4 = 0;
            while (this.i && !this.g.isAuthenticationComplete()) {
                int i5 = i4 + 1;
                if (i4 >= 1) {
                    break;
                }
                a();
                Thread.sleep(1000L);
                i4 = i5;
            }
            if (this.g.isAuthenticationComplete()) {
                try {
                    this.f = this.g.createDynamicPortForwarder(1080);
                    e(uh.a(-121342147067166L));
                    e(uh.a(-120208275701022L));
                    d(R.string.qa);
                    this.A = true;
                    this.q = ig.h(this);
                    String strA = uh.a(-120251225373982L);
                    String strA2 = uh.a(-120285585112350L);
                    int iG = mc1.g(8091, 10);
                    o6 o6Var = new o6();
                    String str = (String) o6Var.a;
                    int iC = o6Var.c();
                    String strD = o6Var.d();
                    Locale.setDefault(new Locale(uh.a(-120319944850718L)));
                    VpnService.Builder builder = new VpnService.Builder(this);
                    builder.setSession(getString(R.string.app));
                    builder.addAddress(str, iC);
                    builder.setMtu(1500);
                    builder.setConfigureIntent(c());
                    qz qzVar = new qz(3);
                    qzVar.a(new ha(uh.a(-120332829752606L), 0, 0), true);
                    try {
                        String hostAddress = InetAddress.getByName(this.q.m()).getHostAddress();
                        if (hostAddress != null) {
                            i = 1080;
                            try {
                                qzVar.a(new ha(hostAddress, 32, 0), false);
                            } catch (Exception unused) {
                            }
                        } else {
                            i = 1080;
                        }
                    } catch (Exception unused2) {
                    }
                    if (this.q.s() == 4) {
                        qzVar.a(new ha(this.q.e(), 32, 0), false);
                        if (this.q.e().equals(uh.a(-120367189490974L))) {
                            qzVar.a(new ha(strA, 32, 0), false);
                            qzVar.a(new ha(strA2, 32, 0), false);
                            ig igVar = this.q;
                            igVar.getClass();
                            String strA3 = uh.a(-131516924591390L);
                            hy0.a aVar = igVar.b;
                            aVar.putBoolean(strA3, false);
                            aVar.apply();
                        }
                    }
                    if (!this.q.v() || this.q.e().equals(uh.a(-120401549229342L))) {
                        e(uh.a(-120521808313630L));
                    } else {
                        e(uh.a(-120435908967710L));
                        builder.addDnsServer(strA);
                        builder.addDnsServer(strA2);
                        qzVar.a(new ha(strA, 32, 0), true);
                        qzVar.a(new ha(strA2, 32, 0), true);
                    }
                    try {
                        ok0$a ok0_a = new ok0$a(new ha(uh.a(-120612002626846L), 3, 0), true);
                        for (ok0$a ok0_a2 : qzVar.c()) {
                            if (!ok0_a.a(ok0_a2)) {
                                builder.addRoute(ok0_a2.c(), ok0_a2.c);
                            }
                        }
                    } catch (Exception e2) {
                        e(uh.a(-120654952299806L) + e2.getMessage());
                    }
                    this.s = builder.establish();
                    uo0 uo0Var = new uo0(this, new String[]{strA, strA2}, str, iG);
                    this.t = uo0Var;
                    uo0Var.b = new ax0(this, i2);
                    if (this.q.v()) {
                        this.t.start();
                    }
                    ParcelFileDescriptor parcelFileDescriptor = this.s;
                    String str2 = uh.a(-121178938309918L) + Integer.toString(i);
                    String str3 = uh.a(-121226182950174L) + Integer.toString(7300);
                    String strA4 = uh.a(-121273427590430L);
                    if (this.q.v()) {
                        StringBuilder sbD = defpackage.e.d(str);
                        sbD.append(uh.a(-121333557132574L));
                        sbD.append(iG);
                        string = sbD.toString();
                    } else {
                        string = null;
                    }
                    l81 l81Var = new l81(this, parcelFileDescriptor, strD, strA4, str2, str3, string);
                    this.u = l81Var;
                    l81Var.q = new ax0(this, i3);
                    l81Var.start();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (ok0$a ok0_a3 : qzVar.b(false)) {
                        arrayList.add(String.format(uh.a(-120749441580318L), ok0_a3.c(), String.valueOf(ok0_a3.c)));
                    }
                    for (ok0$a ok0_a4 : qzVar.b(true)) {
                        arrayList2.add(String.format(uh.a(-120775211384094L), ok0_a4.c(), String.valueOf(ok0_a4.c)));
                    }
                    e(String.format(uh.a(-120800981187870L), TextUtils.join(uh.a(-120882585566494L), arrayList2.toArray(new String[arrayList2.size()]))));
                    e(uh.a(-120895470468382L));
                    return;
                } catch (Exception e3) {
                    e(uh.a(-121423751445790L) + e3.getMessage());
                    uh.a(-121449521249566L);
                    uh.a(-121492470922526L);
                }
            }
        } catch (Exception unused3) {
        }
        throw new Exception();
    }

    public final void h() {
        this.A = false;
        this.E = false;
        this.v = false;
        this.i = false;
        this.w = true;
        i();
        new Thread(new b()).start();
        PowerManager.WakeLock wakeLock = this.o;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.o.release();
            e(uh.a(-121715809221918L));
        }
        e(uh.a(-121788823665950L));
        d(R.string.qc);
        stopSelf();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Notification.Builder builder;
        SharedPreferences.Editor editorEdit = this.d.edit();
        int i = message.what;
        ArrayDeque<zw0> arrayDeque = this.j;
        if (i == 0) {
            zw0 zw0Var = (zw0) message.obj;
            this.n.getClass();
            arrayDeque.addLast(zw0Var);
            b2.f19b.n(zw0Var.a);
        } else if (i == 1) {
            g gVar = (g) message.obj;
            int i2 = gVar.a;
            if (i2 == R.string.qc || i2 == R.string.q_) {
                stopForeground(true);
            } else {
                NotificationManager notificationManager = (NotificationManager) getSystemService(uh.a(-122463133531422L));
                this.c = notificationManager;
                this.b = null;
                if (Build.VERSION.SDK_INT >= 26) {
                    NotificationChannel notificationChannel = new NotificationChannel(uh.a(-122536147975454L), uh.a(-122553327844638L), 2);
                    notificationChannel.setShowBadge(true);
                    notificationManager.createNotificationChannel(notificationChannel);
                    builder = new Notification.Builder(this, uh.a(-122518968106270L));
                } else {
                    builder = new Notification.Builder(this);
                }
                this.b = builder;
                builder.setContentTitle(getString(R.string.app));
                this.b.setContentText(getString(i2));
                this.b.setSmallIcon(R.drawable.ic_app_icon);
                this.b.setOnlyAlertOnce(true);
                this.b.setOngoing(true);
                this.b.setWhen(new Date().getTime());
                this.b.setContentIntent(c());
                Notification notification = this.b.getNotification();
                this.c.notify(1, notification);
                startForeground(1, notification);
            }
            int i3 = gVar.a;
            this.p = i3;
            if (i3 == R.string.qd) {
                arrayDeque.clear();
                b2.f19b.o.clear();
            }
            this.n.b(gVar.a);
        }
        editorEdit.commit();
        return true;
    }

    public final void i() {
        new Thread(new a()).start();
    }

    @Override // android.net.VpnService, android.app.Service
    public final IBinder onBind(Intent intent) {
        return new f();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Locale.setDefault(new Locale(uh.a(-121702924320030L)));
        this.D = new Handler(this);
        this.d = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (!action.equals(uh.a(-121840363273502L))) {
            if (action.equals(uh.a(-121917672684830L))) {
                h();
                return;
            } else {
                if (action.equals(uh.a(-121956327390494L))) {
                    new Thread(new d()).start();
                    return;
                }
                return;
            }
        }
        this.q = new ig(this);
        b2.f15a = new c();
        int i2 = 1;
        this.o = ((PowerManager) getSystemService(uh.a(-121999277063454L))).newWakeLock(1, uh.a(-122025046867230L));
        e(uh.a(-122080881442078L));
        this.o.acquire();
        e(uh.a(-122153895886110L));
        if (this.q.s() == 4) {
            this.z = mc1.g(2222, 9);
            us usVar = new us(this);
            this.B = usVar;
            usVar.start();
            bk bkVar = new bk(this);
            this.y = bkVar;
            bkVar.start();
        }
        Thread thread = new Thread(new as0(i2, this));
        this.r = thread;
        thread.start();
        new WeakReference(this);
    }

    @Override // com.trilead.ssh2.InteractiveCallback
    public final String[] replyToChallenge(String str, String str2, int i, String[] strArr, boolean[] zArr) {
        String[] strArr2 = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            if (strArr[i2].toLowerCase().contains(uh.a(-122226910330142L))) {
                strArr2[i2] = this.q.j();
            }
        }
        return strArr2;
    }

    @Override // com.trilead.ssh2.ServerHostKeyVerifier
    public final boolean verifyServerHostKey(String str, int i, String str2, byte[] bArr) {
        try {
            e(uh.a(-122342874447134L) + KnownHosts.createHexFingerprint(str2, bArr));
            return true;
        } catch (Exception e2) {
            e(uh.a(-122437363727646L) + e2.getMessage());
            return false;
        }
    }
}
