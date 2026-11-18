package renz.javacodez.v2ray.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.ProxyInfo;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.StrictMode;
import defpackage.ai;
import defpackage.ak;
import defpackage.bx;
import defpackage.d;
import defpackage.e;
import defpackage.e4;
import defpackage.jf;
import defpackage.k7;
import defpackage.q31;
import defpackage.rc0;
import defpackage.t41;
import defpackage.tb1;
import defpackage.ti;
import defpackage.uh0;
import defpackage.ui;
import defpackage.uo;
import defpackage.v41;
import defpackage.vi;
import defpackage.zk;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.R;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.handler.SettingsManager;
import renz.javacodez.v2ray.util.MyContextWrapper;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class V2RayVpnService extends VpnService implements ServiceControl {
    public static final Companion Companion = new Companion(null);
    private static final String PRIVATE_VLAN4_CLIENT = "10.10.10.1";
    private static final String PRIVATE_VLAN4_ROUTER = "10.10.10.2";
    private static final String PRIVATE_VLAN6_CLIENT = "fc00::10:10:10:1";
    private static final String PRIVATE_VLAN6_ROUTER = "fc00::10:10:10:2";
    private static final String TUN2SOCKS = "libv2raysocks.so";
    private static final int VPN_MTU = 1500;
    private final rc0 connectivity$delegate;
    private final rc0 defaultNetworkCallback$delegate;
    private final rc0 defaultNetworkRequest$delegate;
    private boolean isRunning;
    private ParcelFileDescriptor mInterface;
    private Process process;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(zk zkVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: renz.javacodez.v2ray.service.V2RayVpnService$sendFd$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class AnonymousClass1 extends t41 implements bx {
        final /* synthetic */ FileDescriptor $fd;
        final /* synthetic */ String $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, FileDescriptor fileDescriptor, ai aiVar) {
            super(aiVar);
            this.$path = str;
            this.$fd = fileDescriptor;
        }

        @Override // defpackage.i8
        public final ai create(Object obj, ai aiVar) {
            return V2RayVpnService.this.new AnonymousClass1(this.$path, this.$fd, aiVar);
        }

        @Override // defpackage.bx
        public final Object invoke(ti tiVar, ai aiVar) {
            return ((AnonymousClass1) create(tiVar, aiVar)).invokeSuspend(tb1.a);
        }

        @Override // defpackage.i8
        public final Object invokeSuspend(Object obj) throws Throwable {
            vi viVar = vi.b;
            if (this.label != 0) {
                d.AnonymousClass0.m("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            e4.b(obj);
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(50 << i);
                    V2RayVpnService.this.getPackageName();
                    LocalSocket localSocket = new LocalSocket();
                    String str = this.$path;
                    FileDescriptor fileDescriptor = this.$fd;
                    try {
                        localSocket.connect(new LocalSocketAddress(str, LocalSocketAddress.Namespace.FILESYSTEM));
                        localSocket.setFileDescriptorsForSend(new FileDescriptor[]{fileDescriptor});
                        localSocket.getOutputStream().write(42);
                        localSocket.close();
                        break;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            e.F0(localSocket, th);
                            throw th2;
                        }
                    }
                } catch (Exception e) {
                    V2RayVpnService.this.getPackageName();
                    e.toString();
                    if (i > 5) {
                        break;
                    }
                    i++;
                }
            }
            return tb1.a;
        }
    }

    public V2RayVpnService() {
        int i = 3;
        int i2 = 1;
        this.defaultNetworkRequest$delegate = new v41(new uh0(i, i2));
        this.connectivity$delegate = new v41(new k7(this, i2, i2));
        this.defaultNetworkCallback$delegate = new v41(new k7(this, 2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectivityManager connectivity_delegate$lambda$1(V2RayVpnService v2RayVpnService) {
        return (ConnectivityManager) v2RayVpnService.getSystemService("connectivity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [renz.javacodez.v2ray.service.V2RayVpnService$defaultNetworkCallback$2$1] */
    public static final V2RayVpnService$defaultNetworkCallback$2$1 defaultNetworkCallback_delegate$lambda$2(final V2RayVpnService v2RayVpnService) {
        return new ConnectivityManager.NetworkCallback() { // from class: renz.javacodez.v2ray.service.V2RayVpnService$defaultNetworkCallback$2$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                this.this$0.setUnderlyingNetworks(new Network[]{network});
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                this.this$0.setUnderlyingNetworks(new Network[]{network});
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                this.this$0.setUnderlyingNetworks(null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkRequest defaultNetworkRequest_delegate$lambda$0() {
        return new NetworkRequest.Builder().addCapability(12).addCapability(13).build();
    }

    private final ConnectivityManager getConnectivity() {
        return (ConnectivityManager) this.connectivity$delegate.getValue();
    }

    private final V2RayVpnService$defaultNetworkCallback$2$1 getDefaultNetworkCallback() {
        return (V2RayVpnService$defaultNetworkCallback$2$1) this.defaultNetworkCallback$delegate.getValue();
    }

    private final NetworkRequest getDefaultNetworkRequest() {
        return (NetworkRequest) this.defaultNetworkRequest$delegate.getValue();
    }

    private final void runTun2socks() {
        ArrayList arrayListC = e.c(new File(getApplicationContext().getApplicationInfo().nativeLibraryDir, TUN2SOCKS).getAbsolutePath(), "--netif-ipaddr", PRIVATE_VLAN4_ROUTER, "--netif-netmask", "255.255.255.252", "--socks-server-addr", ak.h(SettingsManager.INSTANCE.getSocksPort(), "127.0.0.1:"), "--tunmtu", "1500", "--sock-path", "sock_path", "--enable-udprelay", "--loglevel", "notice");
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        if (mmkvManager.decodeSettingsBool(AppConfig.PREF_PREFER_IPV6)) {
            arrayListC.add("--netif-ip6addr");
            arrayListC.add(PRIVATE_VLAN6_ROUTER);
        }
        if (mmkvManager.decodeSettingsBool(AppConfig.PREF_LOCAL_DNS_ENABLED)) {
            int i = Utils.INSTANCE.parseInt(mmkvManager.decodeSettingsString(AppConfig.PREF_LOCAL_DNS_PORT), Integer.parseInt(AppConfig.PORT_LOCAL_DNS));
            arrayListC.add("--dnsgw");
            arrayListC.add("127.0.0.1:" + i);
        }
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(arrayListC);
            processBuilder.redirectErrorStream(true);
            this.process = processBuilder.directory(getApplicationContext().getFilesDir()).start();
            new Thread(new jf(this, 4, 2)).start();
            getPackageName();
            Process process = this.process;
            if (process == null) {
                throw null;
            }
            process.toString();
            sendFd();
        } catch (Exception e) {
            getPackageName();
            e.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runTun2socks$lambda$6(V2RayVpnService v2RayVpnService) throws InterruptedException {
        v2RayVpnService.getPackageName();
        Process process = v2RayVpnService.process;
        process.getClass();
        process.waitFor();
        v2RayVpnService.getPackageName();
        if (v2RayVpnService.isRunning) {
            v2RayVpnService.getPackageName();
            v2RayVpnService.runTun2socks();
        }
    }

    private final void sendFd() {
        ParcelFileDescriptor parcelFileDescriptor = this.mInterface;
        parcelFileDescriptor.getClass();
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        String absolutePath = new File(getApplicationContext().getFilesDir(), "sock_path").getAbsolutePath();
        getPackageName();
        e.Y0(ui.a(uo.b), null, new AnonymousClass1(absolutePath, fileDescriptor, null), 3);
    }

    private final void setup() throws PackageManager.NameNotFoundException {
        VpnService.Builder builder = new VpnService.Builder(this);
        builder.setMtu(VPN_MTU);
        builder.addAddress(PRIVATE_VLAN4_CLIENT, 30);
        boolean zRoutingRulesetsBypassLan = SettingsManager.INSTANCE.routingRulesetsBypassLan();
        if (zRoutingRulesetsBypassLan) {
            for (String str : getResources().getStringArray(R.array.bypass_private_ip_address)) {
                List listT0 = q31.t0(str, new char[]{'/'});
                builder.addRoute((String) listT0.get(0), Integer.parseInt((String) listT0.get(1)));
            }
        } else {
            builder.addRoute("0.0.0.0", 0);
        }
        if (MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_PREFER_IPV6)) {
            builder.addAddress(PRIVATE_VLAN6_CLIENT, R.styleable.AppCompatTheme_windowNoTitle);
            if (zRoutingRulesetsBypassLan) {
                builder.addRoute("2000::", 3);
            } else {
                builder.addRoute("::", 0);
            }
        }
        for (String str2 : Utils.INSTANCE.getVpnDnsServers()) {
            if (Utils.INSTANCE.isPureIpAddress(str2)) {
                builder.addDnsServer(str2);
            }
        }
        ProfileItem currentConfig = V2RayServiceManager.INSTANCE.getCurrentConfig();
        String remarks = currentConfig != null ? currentConfig.getRemarks() : null;
        if (remarks == null) {
            remarks = AppConfig.CUSTOM;
        }
        builder.setSession(remarks);
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        if (mmkvManager.decodeSettingsBool(AppConfig.PREF_PER_APP_PROXY)) {
            Set<String> setDecodeSettingsStringSet = mmkvManager.decodeSettingsStringSet(AppConfig.PREF_PER_APP_PROXY_SET);
            boolean zDecodeSettingsBool = mmkvManager.decodeSettingsBool(AppConfig.PREF_BYPASS_APPS);
            if (zDecodeSettingsBool) {
                if (setDecodeSettingsStringSet != null) {
                    setDecodeSettingsStringSet.add(AppConfig.ANG_PACKAGE);
                }
            } else if (setDecodeSettingsStringSet != null) {
                setDecodeSettingsStringSet.remove(AppConfig.ANG_PACKAGE);
            }
            if (setDecodeSettingsStringSet != null) {
                for (String str3 : setDecodeSettingsStringSet) {
                    if (zDecodeSettingsBool) {
                        try {
                            builder.addDisallowedApplication(str3);
                        } catch (PackageManager.NameNotFoundException e) {
                            e.getLocalizedMessage();
                        }
                    } else {
                        builder.addAllowedApplication(str3);
                    }
                }
            }
        } else {
            builder.addDisallowedApplication(AppConfig.ANG_PACKAGE);
        }
        try {
            ParcelFileDescriptor parcelFileDescriptor = this.mInterface;
            if (parcelFileDescriptor == null) {
                throw null;
            }
            parcelFileDescriptor.close();
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    getConnectivity().requestNetwork(getDefaultNetworkRequest(), getDefaultNetworkCallback());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setMetered(false);
                if (MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_APPEND_HTTP_PROXY)) {
                    builder.setHttpProxy(ProxyInfo.buildDirectProxy(AppConfig.LOOPBACK, SettingsManager.INSTANCE.getHttpPort()));
                }
            }
            try {
                this.mInterface = builder.establish();
                this.isRunning = true;
                runTun2socks();
            } catch (Exception e3) {
                e3.printStackTrace();
                stopV2Ray$default(this, false, 1, null);
            }
        } catch (Exception unused) {
        }
    }

    private final void stopV2Ray(boolean z) {
        this.isRunning = false;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                getConnectivity().unregisterNetworkCallback(getDefaultNetworkCallback());
            } catch (Exception unused) {
            }
        }
        try {
            getPackageName();
            Process process = this.process;
            if (process == null) {
                throw null;
            }
            process.destroy();
            V2RayServiceManager.INSTANCE.stopV2rayPoint();
            if (z) {
                stopSelf();
                try {
                    ParcelFileDescriptor parcelFileDescriptor = this.mInterface;
                    if (parcelFileDescriptor == null) {
                        throw null;
                    }
                    parcelFileDescriptor.close();
                } catch (Exception unused2) {
                }
            }
        } catch (Exception e) {
            getPackageName();
            e.toString();
        }
    }

    public static /* synthetic */ void stopV2Ray$default(V2RayVpnService v2RayVpnService, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        v2RayVpnService.stopV2Ray(z);
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context != null ? MyContextWrapper.Companion.wrap(context, Utils.INSTANCE.getLocale()) : null);
    }

    @Override // renz.javacodez.v2ray.service.ServiceControl
    public Service getService() {
        return this;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        V2RayServiceManager.INSTANCE.setServiceControl(new SoftReference<>(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        V2RayServiceManager.INSTANCE.cancelNotification();
    }

    @Override // android.net.VpnService
    public void onRevoke() {
        stopV2Ray$default(this, false, 1, null);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        V2RayServiceManager.INSTANCE.startV2rayPoint();
        return 1;
    }

    @Override // renz.javacodez.v2ray.service.ServiceControl
    public void startService() throws PackageManager.NameNotFoundException {
        setup();
    }

    @Override // renz.javacodez.v2ray.service.ServiceControl
    public void stopService() {
        stopV2Ray(true);
    }

    @Override // renz.javacodez.v2ray.service.ServiceControl
    public boolean vpnProtect(int i) {
        return protect(i);
    }
}
