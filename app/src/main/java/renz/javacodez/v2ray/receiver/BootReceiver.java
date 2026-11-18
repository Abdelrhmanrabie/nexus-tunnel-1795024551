package renz.javacodez.v2ray.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import defpackage.e4;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.service.V2RayServiceManager;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String selectServer;
        if (context != null) {
            if (e4.a(intent != null ? intent.getAction() : null, "android.intent.action.BOOT_COMPLETED")) {
                MmkvManager mmkvManager = MmkvManager.INSTANCE;
                if (!mmkvManager.decodeStartOnBoot() || (selectServer = mmkvManager.getSelectServer()) == null || selectServer.length() == 0) {
                    return;
                }
                V2RayServiceManager.INSTANCE.startV2Ray(context);
            }
        }
    }
}
