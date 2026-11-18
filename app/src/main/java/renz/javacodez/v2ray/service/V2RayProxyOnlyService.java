package renz.javacodez.v2ray.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.SoftReference;
import renz.javacodez.v2ray.util.MyContextWrapper;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class V2RayProxyOnlyService extends Service implements ServiceControl {
    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context != null ? MyContextWrapper.Companion.wrap(context, Utils.INSTANCE.getLocale()) : null);
    }

    @Override // renz.javacodez.v2ray.service.ServiceControl
    public Service getService() {
        return this;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        V2RayServiceManager.INSTANCE.setServiceControl(new SoftReference<>(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        V2RayServiceManager.INSTANCE.stopV2rayPoint();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        V2RayServiceManager.INSTANCE.startV2rayPoint();
        return 1;
    }

    @Override // renz.javacodez.v2ray.service.ServiceControl
    public void startService() {
    }

    @Override // renz.javacodez.v2ray.service.ServiceControl
    public void stopService() {
        stopSelf();
    }

    @Override // renz.javacodez.v2ray.service.ServiceControl
    public boolean vpnProtect(int i) {
        return true;
    }
}
