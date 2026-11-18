package renz.javacodez.v2ray.service;

import android.app.Service;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface ServiceControl {
    Service getService();

    void startService();

    void stopService();

    boolean vpnProtect(int i);
}
