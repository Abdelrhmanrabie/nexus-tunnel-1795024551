package renz.javacodez.v2ray.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import defpackage.ai;
import defpackage.bg;
import defpackage.bx;
import defpackage.cy0;
import defpackage.d;
import defpackage.e;
import defpackage.e4;
import defpackage.g;
import defpackage.gm0;
import defpackage.he;
import defpackage.hh;
import defpackage.pc0;
import defpackage.q31;
import defpackage.sl0;
import defpackage.t41;
import defpackage.tb1;
import defpackage.ti;
import defpackage.ui;
import defpackage.uo;
import defpackage.vi;
import defpackage.wo;
import defpackage.xs0;
import go.Seq;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import libv2ray.Libv2ray;
import libv2ray.V2RayPoint;
import libv2ray.V2RayVPNServiceSupportsSet;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.R;
import renz.javacodez.v2ray.dto.ConfigResult;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.extension._ExtKt;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.handler.V2rayConfigManager;
import renz.javacodez.v2ray.util.MessageUtil;
import renz.javacodez.v2ray.util.PluginUtil;
import renz.javacodez.v2ray.util.Utils;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class V2RayServiceManager {
    public static final V2RayServiceManager INSTANCE = new V2RayServiceManager();
    private static final int NOTIFICATION_ICON_THRESHOLD = 3000;
    private static final int NOTIFICATION_ID = 1;
    private static final int NOTIFICATION_PENDING_INTENT_CONTENT = 0;
    private static final int NOTIFICATION_PENDING_INTENT_RESTART_V2RAY = 2;
    private static final int NOTIFICATION_PENDING_INTENT_STOP_V2RAY = 1;
    private static ProfileItem currentConfig;
    private static long lastQueryTime;
    private static sl0 mBuilder;
    private static wo mDisposable;
    private static final ReceiveMessageHandler mMsgReceive;
    private static NotificationManager mNotificationManager;
    private static SoftReference<ServiceControl> serviceControl;
    private static final V2RayPoint v2rayPoint;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class ReceiveMessageHandler extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws InterruptedException {
            ServiceControl serviceControl;
            MessageUtil messageUtil;
            Service service;
            int i;
            V2RayServiceManager v2RayServiceManager = V2RayServiceManager.INSTANCE;
            SoftReference<ServiceControl> serviceControl2 = v2RayServiceManager.getServiceControl();
            if (serviceControl2 == null || (serviceControl = serviceControl2.get()) == null) {
                return;
            }
            Integer numValueOf = intent != null ? Integer.valueOf(intent.getIntExtra("key", 0)) : null;
            if (numValueOf != null && numValueOf.intValue() == 1) {
                if (v2RayServiceManager.getV2rayPoint().getIsRunning()) {
                    messageUtil = MessageUtil.INSTANCE;
                    service = serviceControl.getService();
                    i = 11;
                } else {
                    messageUtil = MessageUtil.INSTANCE;
                    service = serviceControl.getService();
                    i = 12;
                }
                messageUtil.sendMsg2UI(service, i, AppConfig.CUSTOM);
            } else if ((numValueOf == null || numValueOf.intValue() != 2) && (numValueOf == null || numValueOf.intValue() != 3)) {
                if (numValueOf != null && numValueOf.intValue() == 4) {
                    serviceControl.stopService();
                } else if (numValueOf != null && numValueOf.intValue() == 5) {
                    serviceControl.stopService();
                    Thread.sleep(500L);
                    v2RayServiceManager.startV2Ray(serviceControl.getService());
                } else if (numValueOf != null && numValueOf.intValue() == 6) {
                    v2RayServiceManager.measureV2rayDelay();
                }
            }
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -2128145023) {
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        v2RayServiceManager.stopSpeedNotification();
                    }
                } else if (iHashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                    v2RayServiceManager.startSpeedNotification();
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class V2RayCallback implements V2RayVPNServiceSupportsSet {
        @Override // libv2ray.V2RayVPNServiceSupportsSet
        public long onEmitStatus(long j, String str) {
            return 0L;
        }

        @Override // libv2ray.V2RayVPNServiceSupportsSet
        public long prepare() {
            return 0L;
        }

        @Override // libv2ray.V2RayVPNServiceSupportsSet
        public boolean protect(long j) {
            ServiceControl serviceControl;
            SoftReference<ServiceControl> serviceControl2 = V2RayServiceManager.INSTANCE.getServiceControl();
            if (serviceControl2 == null || (serviceControl = serviceControl2.get()) == null) {
                return true;
            }
            return serviceControl.vpnProtect((int) j);
        }

        @Override // libv2ray.V2RayVPNServiceSupportsSet
        public long setup(String str) {
            ServiceControl serviceControl;
            V2RayServiceManager v2RayServiceManager = V2RayServiceManager.INSTANCE;
            SoftReference<ServiceControl> serviceControl2 = v2RayServiceManager.getServiceControl();
            if (serviceControl2 == null || (serviceControl = serviceControl2.get()) == null) {
                return -1L;
            }
            try {
                serviceControl.startService();
                V2RayServiceManager.lastQueryTime = System.currentTimeMillis();
                v2RayServiceManager.startSpeedNotification();
                return 0L;
            } catch (Exception e) {
                e.toString();
                return -1L;
            }
        }

        @Override // libv2ray.V2RayVPNServiceSupportsSet
        public long shutdown() {
            ServiceControl serviceControl;
            SoftReference<ServiceControl> serviceControl2 = V2RayServiceManager.INSTANCE.getServiceControl();
            if (serviceControl2 == null || (serviceControl = serviceControl2.get()) == null) {
                return -1L;
            }
            try {
                serviceControl.stopService();
                return 0L;
            } catch (Exception e) {
                e.toString();
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: renz.javacodez.v2ray.service.V2RayServiceManager$measureV2rayDelay$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class AnonymousClass1 extends t41 implements bx {
        int label;

        public AnonymousClass1(ai aiVar) {
            super(aiVar);
        }

        @Override // defpackage.i8
        public final ai create(Object obj, ai aiVar) {
            return new AnonymousClass1(aiVar);
        }

        @Override // defpackage.bx
        public final Object invoke(ti tiVar, ai aiVar) {
            return ((AnonymousClass1) create(tiVar, aiVar)).invokeSuspend(tb1.a);
        }

        @Override // defpackage.i8
        public final Object invokeSuspend(Object obj) throws Throwable {
            ServiceControl serviceControl;
            Service service;
            long jMeasureDelay;
            vi viVar = vi.b;
            if (this.label != 0) {
                d.AnonymousClass0.m("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            e4.b(obj);
            V2RayServiceManager v2RayServiceManager = V2RayServiceManager.INSTANCE;
            SoftReference<ServiceControl> serviceControl2 = v2RayServiceManager.getServiceControl();
            tb1 tb1Var = tb1.a;
            if (serviceControl2 != null && (serviceControl = serviceControl2.get()) != null && (service = serviceControl.getService()) != null) {
                boolean isRunning = v2RayServiceManager.getV2rayPoint().getIsRunning();
                String strW0 = AppConfig.CUSTOM;
                if (isRunning) {
                    try {
                        jMeasureDelay = v2RayServiceManager.getV2rayPoint().measureDelay(Utils.getDelayTestUrl$default(Utils.INSTANCE, false, 1, null));
                    } catch (Exception e) {
                        e.toString();
                        String message = e.getMessage();
                        strW0 = message != null ? q31.w0(message, "\":", message) : "empty message";
                        jMeasureDelay = -1;
                    }
                    if (jMeasureDelay == -1) {
                        try {
                            jMeasureDelay = V2RayServiceManager.INSTANCE.getV2rayPoint().measureDelay(Utils.INSTANCE.getDelayTestUrl(true));
                        } catch (Exception e2) {
                            e2.toString();
                            String message2 = e2.getMessage();
                            strW0 = message2 != null ? q31.w0(message2, "\":", message2) : "empty message";
                        }
                    }
                } else {
                    jMeasureDelay = -1;
                }
                MessageUtil.INSTANCE.sendMsg2UI(service, 61, jMeasureDelay == -1 ? service.getString(R.string.connection_test_error, strW0) : service.getString(R.string.connection_test_available, new Long(jMeasureDelay)));
            }
            return tb1Var;
        }
    }

    /* JADX INFO: renamed from: renz.javacodez.v2ray.service.V2RayServiceManager$stopV2rayPoint$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class C00511 extends t41 implements bx {
        int label;

        public C00511(ai aiVar) {
            super(aiVar);
        }

        @Override // defpackage.i8
        public final ai create(Object obj, ai aiVar) {
            return new C00511(aiVar);
        }

        @Override // defpackage.bx
        public final Object invoke(ti tiVar, ai aiVar) {
            return ((C00511) create(tiVar, aiVar)).invokeSuspend(tb1.a);
        }

        @Override // defpackage.i8
        public final Object invokeSuspend(Object obj) throws Throwable {
            vi viVar = vi.b;
            if (this.label != 0) {
                d.AnonymousClass0.m("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            e4.b(obj);
            try {
                V2RayServiceManager.INSTANCE.getV2rayPoint().stopLoop();
            } catch (Exception e) {
                e.toString();
            }
            return tb1.a;
        }
    }

    static {
        v2rayPoint = Libv2ray.newV2RayPoint(new V2RayCallback(), Build.VERSION.SDK_INT >= 25);
        mMsgReceive = new ReceiveMessageHandler();
    }

    private V2RayServiceManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void appendSpeedString(StringBuilder sb, String str, double d, double d2) {
        if (str == null) {
            str = "no tag";
        }
        String strSubstring = str.substring(0, Math.min(str.length(), 6));
        sb.append(strSubstring);
        int length = strSubstring.length();
        int i = e.i(length, 6, 2);
        if (length <= i) {
            while (true) {
                sb.append("\t");
                if (length == i) {
                    break;
                } else {
                    length += 2;
                }
            }
        }
        sb.append("•  " + _ExtKt.toSpeedString((long) d) + "↑  " + _ExtKt.toSpeedString((long) d2) + "↓\n");
    }

    private final String createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(AppConfig.RAY_NG_CHANNEL_ID, AppConfig.RAY_NG_CHANNEL_NAME, 4);
        notificationChannel.setLightColor(-12303292);
        notificationChannel.setImportance(0);
        notificationChannel.setLockscreenVisibility(0);
        NotificationManager notificationManager = getNotificationManager();
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return AppConfig.RAY_NG_CHANNEL_ID;
    }

    private final NotificationManager getNotificationManager() {
        ServiceControl serviceControl2;
        Service service;
        if (mNotificationManager == null) {
            SoftReference<ServiceControl> softReference = serviceControl;
            if (softReference == null || (serviceControl2 = softReference.get()) == null || (service = serviceControl2.getService()) == null) {
                return null;
            }
            mNotificationManager = (NotificationManager) service.getSystemService("notification");
        }
        return mNotificationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void measureV2rayDelay() {
        e.Y0(ui.a(uo.b), null, new AnonymousClass1(null), 3);
    }

    private final void showNotification() {
        ServiceControl serviceControl2;
        Service service;
        SoftReference<ServiceControl> softReference = serviceControl;
        if (softReference == null || (serviceControl2 = softReference.get()) == null || (service = serviceControl2.getService()) == null) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        int i2 = HamoTunnelPlusMain.b1;
        PendingIntent activity = PendingIntent.getActivity(service, 0, new Intent(service, (Class<?>) HamoTunnelPlusMain.class), 201326592);
        Intent intent = new Intent(AppConfig.BROADCAST_ACTION_SERVICE);
        intent.setPackage(AppConfig.ANG_PACKAGE);
        intent.putExtra("key", 4);
        PendingIntent broadcast = PendingIntent.getBroadcast(service, 1, intent, 201326592);
        Intent intent2 = new Intent(AppConfig.BROADCAST_ACTION_SERVICE);
        intent2.setPackage(AppConfig.ANG_PACKAGE);
        intent2.putExtra("key", 5);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(service, 2, intent2, 201326592);
        sl0 sl0Var = new sl0(service, i >= 26 ? createNotificationChannel() : AppConfig.CUSTOM);
        int i3 = R.drawable.ic_stat_name;
        Notification notification = sl0Var.s;
        notification.icon = i3;
        ProfileItem profileItem = currentConfig;
        sl0Var.e = sl0.c(profileItem != null ? profileItem.getRemarks() : null);
        sl0Var.j = -2;
        int i4 = notification.flags;
        sl0Var.k = false;
        notification.flags = i4 | 10;
        sl0Var.g = activity;
        int i5 = R.drawable.ic_delete_24dp;
        sl0Var.a(i5, service.getString(R.string.notification_action_stop_v2ray), broadcast);
        sl0Var.a(i5, service.getString(R.string.title_service_restart), broadcast2);
        mBuilder = sl0Var;
        service.startForeground(1, sl0Var.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSpeedNotification() {
        if (mDisposable == null && v2rayPoint.getIsRunning() && MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_SPEED_ENABLED)) {
            final xs0 xs0Var = new xs0();
            ProfileItem profileItem = currentConfig;
            final List<String> allOutboundTags = profileItem != null ? profileItem.getAllOutboundTags() : null;
            if (allOutboundTags != null) {
                allOutboundTags.remove(AppConfig.TAG_DIRECT);
            }
            TimeUnit timeUnit = TimeUnit.SECONDS;
            bg bgVar = cy0.a;
            Objects.requireNonNull(timeUnit, "unit is null");
            Objects.requireNonNull(bgVar, "scheduler is null");
            gm0 gm0Var = new gm0(Math.max(0L, 3L), Math.max(0L, 3L), timeUnit, bgVar);
            pc0 pc0Var = new pc0(new hh() { // from class: renz.javacodez.v2ray.service.V2RayServiceManager.startSpeedNotification.1
                @Override // defpackage.hh
                public final void accept(Long l) {
                    long j;
                    long j2;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    double d = (jCurrentTimeMillis - V2RayServiceManager.lastQueryTime) / 1000.0d;
                    StringBuilder sb = new StringBuilder();
                    List<String> list = allOutboundTags;
                    if (list != null) {
                        long j3 = 0;
                        for (String str : list) {
                            V2RayServiceManager v2RayServiceManager = V2RayServiceManager.INSTANCE;
                            long jQueryStats = v2RayServiceManager.getV2rayPoint().queryStats(str, AppConfig.UPLINK);
                            long jQueryStats2 = v2RayServiceManager.getV2rayPoint().queryStats(str, AppConfig.DOWNLINK);
                            long j4 = jQueryStats + jQueryStats2;
                            if (j4 > 0) {
                                v2RayServiceManager.appendSpeedString(sb, str, jQueryStats / d, jQueryStats2 / d);
                                j3 += j4;
                            }
                        }
                        j = j3;
                    } else {
                        j = 0;
                    }
                    V2RayServiceManager v2RayServiceManager2 = V2RayServiceManager.INSTANCE;
                    long jQueryStats3 = v2RayServiceManager2.getV2rayPoint().queryStats(AppConfig.TAG_DIRECT, AppConfig.UPLINK);
                    long jQueryStats4 = v2RayServiceManager2.getV2rayPoint().queryStats(AppConfig.TAG_DIRECT, AppConfig.DOWNLINK);
                    boolean z = j == 0 && jQueryStats3 == 0 && jQueryStats4 == 0;
                    if (z && xs0Var.b) {
                        jCurrentTimeMillis = jCurrentTimeMillis;
                    } else {
                        if (j == 0) {
                            List<String> list2 = allOutboundTags;
                            j2 = jQueryStats3;
                            v2RayServiceManager2.appendSpeedString(sb, list2 != null ? (String) he.M0(list2) : null, 0.0d, 0.0d);
                        } else {
                            j2 = jQueryStats3;
                        }
                        v2RayServiceManager2.appendSpeedString(sb, AppConfig.TAG_DIRECT, j2 / d, jQueryStats4 / d);
                        v2RayServiceManager2.updateNotification(sb.toString(), j, jQueryStats4 + j2);
                    }
                    xs0Var.b = z;
                    V2RayServiceManager.lastQueryTime = jCurrentTimeMillis;
                }
            });
            try {
                gm0Var.b(pc0Var);
                mDisposable = pc0Var;
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                e.r(th);
                ui.a(th);
                NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopSpeedNotification() {
        wo woVar = mDisposable;
        if (woVar != null) {
            woVar.a();
            mDisposable = null;
            V2RayServiceManager v2RayServiceManager = INSTANCE;
            ProfileItem profileItem = currentConfig;
            v2RayServiceManager.updateNotification(profileItem != null ? profileItem.getRemarks() : null, 0L, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNotification(String str, long j, long j2) {
        int i;
        sl0 sl0Var = mBuilder;
        if (sl0Var != null) {
            if (j >= 3000 || j2 >= 3000) {
                i = j > j2 ? R.drawable.ic_stat_proxy : R.drawable.ic_stat_direct;
            } else {
                i = R.drawable.ic_stat_name;
            }
            sl0Var.s.icon = i;
            g gVar = new g(22);
            gVar.b = sl0.c(str);
            sl0Var.g(gVar);
            sl0 sl0Var2 = mBuilder;
            if (sl0Var2 != null) {
                sl0Var2.f = sl0.c(str);
            }
            NotificationManager notificationManager = getNotificationManager();
            if (notificationManager != null) {
                sl0 sl0Var3 = mBuilder;
                notificationManager.notify(1, sl0Var3 != null ? sl0Var3.b() : null);
            }
        }
    }

    public final void cancelNotification() {
        ServiceControl serviceControl2;
        Service service;
        SoftReference<ServiceControl> softReference = serviceControl;
        if (softReference == null || (serviceControl2 = softReference.get()) == null || (service = serviceControl2.getService()) == null) {
            return;
        }
        service.stopForeground(true);
        mBuilder = null;
        wo woVar = mDisposable;
        if (woVar != null) {
            woVar.a();
        }
        mDisposable = null;
    }

    public final ProfileItem getCurrentConfig() {
        return currentConfig;
    }

    public final SoftReference<ServiceControl> getServiceControl() {
        return serviceControl;
    }

    public final V2RayPoint getV2rayPoint() {
        return v2rayPoint;
    }

    public final void setCurrentConfig(ProfileItem profileItem) {
        currentConfig = profileItem;
    }

    public final void setServiceControl(SoftReference<ServiceControl> softReference) {
        ServiceControl serviceControl2;
        ServiceControl serviceControl3;
        Service service;
        serviceControl = softReference;
        Service service2 = null;
        Seq.setContext((softReference == null || (serviceControl3 = softReference.get()) == null || (service = serviceControl3.getService()) == null) ? null : service.getApplicationContext());
        Utils utils = Utils.INSTANCE;
        if (softReference != null && (serviceControl2 = softReference.get()) != null) {
            service2 = serviceControl2.getService();
        }
        Libv2ray.initV2Env(utils.userAssetPath(service2), utils.getDeviceIdForXUDPBaseKey());
    }

    public final void startV2Ray(Context context) {
        MmkvManager mmkvManager;
        String selectServer;
        ProfileItem profileItemDecodeServerConfig;
        if (v2rayPoint.getIsRunning() || (selectServer = (mmkvManager = MmkvManager.INSTANCE).getSelectServer()) == null || (profileItemDecodeServerConfig = mmkvManager.decodeServerConfig(context, selectServer)) == null) {
            return;
        }
        Utils utils = Utils.INSTANCE;
        if ((utils.isValidUrl(profileItemDecodeServerConfig.getServer()) || utils.isIpAddress(profileItemDecodeServerConfig.getServer())) && V2rayConfigManager.INSTANCE.getV2rayConfig(context, selectServer).getStatus()) {
            if (mmkvManager.decodeSettingsBool(AppConfig.PREF_PROXY_SHARING)) {
                _ExtKt.toast(context, R.string.toast_warning_pref_proxysharing_short);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(androidx.preference.e.a(context), 0);
            sharedPreferences.edit().putBoolean(AppConfig.PREF_SPEED_ENABLED, true).commit();
            sharedPreferences.edit().putString(AppConfig.PREF_MODE, AppConfig.VPN).commit();
            mmkvManager.encodeSettings(AppConfig.PREF_SPEED_ENABLED, true);
            mmkvManager.encodeSettings(AppConfig.PREF_MODE, AppConfig.VPN);
            String strDecodeSettingsString = mmkvManager.decodeSettingsString(AppConfig.PREF_MODE);
            if (strDecodeSettingsString == null) {
                strDecodeSettingsString = AppConfig.VPN;
            }
            context.startService(strDecodeSettingsString.equals(AppConfig.VPN) ? new Intent(context.getApplicationContext(), (Class<?>) V2RayVpnService.class) : new Intent(context.getApplicationContext(), (Class<?>) V2RayProxyOnlyService.class));
        }
    }

    public final void startV2rayPoint() {
        ServiceControl serviceControl2;
        Service service;
        MmkvManager mmkvManager;
        String selectServer;
        ProfileItem profileItemDecodeServerConfig;
        SoftReference<ServiceControl> softReference = serviceControl;
        if (softReference == null || (serviceControl2 = softReference.get()) == null || (service = serviceControl2.getService()) == null || (selectServer = (mmkvManager = MmkvManager.INSTANCE).getSelectServer()) == null || (profileItemDecodeServerConfig = mmkvManager.decodeServerConfig(service, selectServer)) == null || v2rayPoint.getIsRunning()) {
            return;
        }
        ConfigResult v2rayConfig = V2rayConfigManager.INSTANCE.getV2rayConfig(service, selectServer);
        if (v2rayConfig.getStatus()) {
            try {
                IntentFilter intentFilter = new IntentFilter(AppConfig.BROADCAST_ACTION_SERVICE);
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                if (Build.VERSION.SDK_INT >= 33) {
                    service.registerReceiver(mMsgReceive, intentFilter, 2);
                } else {
                    service.registerReceiver(mMsgReceive, intentFilter);
                }
            } catch (Exception e) {
                e.toString();
            }
            V2RayPoint v2RayPoint = v2rayPoint;
            v2RayPoint.setConfigureFileContent(v2rayConfig.getContent());
            v2RayPoint.setDomainName(v2rayConfig.getDomainPort());
            currentConfig = profileItemDecodeServerConfig;
            try {
                v2RayPoint.runLoop(MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_PREFER_IPV6));
            } catch (Exception e2) {
                e2.toString();
            }
            if (!v2rayPoint.getIsRunning()) {
                MessageUtil.INSTANCE.sendMsg2UI(service, 32, AppConfig.CUSTOM);
                cancelNotification();
            } else {
                MessageUtil.INSTANCE.sendMsg2UI(service, 31, AppConfig.CUSTOM);
                showNotification();
                PluginUtil.INSTANCE.runPlugin(service, profileItemDecodeServerConfig, v2rayConfig.getDomainPort());
            }
        }
    }

    public final void stopV2rayPoint() {
        ServiceControl serviceControl2;
        Service service;
        SoftReference<ServiceControl> softReference = serviceControl;
        if (softReference == null || (serviceControl2 = softReference.get()) == null || (service = serviceControl2.getService()) == null) {
            return;
        }
        if (v2rayPoint.getIsRunning()) {
            e.Y0(ui.a(uo.b), null, new C00511(null), 3);
        }
        MessageUtil.INSTANCE.sendMsg2UI(service, 41, AppConfig.CUSTOM);
        cancelNotification();
        try {
            service.unregisterReceiver(mMsgReceive);
        } catch (Exception e) {
            e.toString();
        }
        PluginUtil.INSTANCE.stopPlugin();
    }
}
