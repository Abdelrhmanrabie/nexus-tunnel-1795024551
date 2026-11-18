package renz.javacodez.v2ray.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.service.V2RayServiceManager;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class TaskerReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle bundleExtra;
        if (intent != null) {
            try {
                bundleExtra = intent.getBundleExtra(AppConfig.TASKER_EXTRA_BUNDLE);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            bundleExtra = null;
        }
        Boolean boolValueOf = bundleExtra != null ? Boolean.valueOf(bundleExtra.getBoolean(AppConfig.TASKER_EXTRA_BUNDLE_SWITCH, false)) : null;
        String string = bundleExtra != null ? bundleExtra.getString(AppConfig.TASKER_EXTRA_BUNDLE_GUID) : null;
        if (string == null) {
            string = AppConfig.CUSTOM;
        }
        if (boolValueOf != null && !TextUtils.isEmpty(string)) {
            if (!boolValueOf.booleanValue()) {
                Utils.INSTANCE.stopVService(context);
            } else if (string.equals(AppConfig.TASKER_DEFAULT_GUID)) {
                Utils.INSTANCE.startVServiceFromToggle(context);
            } else {
                MmkvManager.INSTANCE.setSelectServer(string);
                V2RayServiceManager.INSTANCE.startV2Ray(context);
            }
        }
    }
}
