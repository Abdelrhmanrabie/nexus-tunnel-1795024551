package renz.javacodez.v2ray.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.preference.e;
import defpackage.r3;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsViewModel extends r3 implements SharedPreferences.OnSharedPreferenceChangeListener {
    public SettingsViewModel(Application application) {
        super(application);
    }

    @Override // defpackage.zd1
    public void onCleared() {
        Application application = getApplication();
        application.getSharedPreferences(e.a(application), 0).unregisterOnSharedPreferenceChangeListener(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0148, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_FRAGMENT_INTERVAL) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x015e, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_REMOTE_DNS) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0161, code lost:
    
        r1 = renz.javacodez.v2ray.handler.MmkvManager.INSTANCE;
        r2 = renz.javacodez.v2ray.AppConfig.CUSTOM;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0165, code lost:
    
        r1.encodeSettings(r5, r4.getString(r5, r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0173, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_ROUTE_ONLY_ENABLED) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0176, code lost:
    
        r1 = renz.javacodez.v2ray.handler.MmkvManager.INSTANCE;
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_MUX_XUDP_QUIC) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_APPEND_HTTP_PROXY) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_MUX_ENABLED) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_SOCKS_PORT) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_UI_MODE_NIGHT) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_START_SCAN_IMMEDIATE) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_PER_APP_PROXY) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_LOCAL_DNS_ENABLED) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_LOGLEVEL) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_ALLOW_INSECURE) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_SPEED_ENABLED) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0089, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_FAKE_DNS_ENABLED) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0093, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_PROXY_SHARING) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009d, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_PREFER_IPV6) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a7, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_DOMESTIC_DNS) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b1, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_FRAGMENT_LENGTH) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bb, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.SUBSCRIPTION_AUTO_UPDATE_INTERVAL) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_FRAGMENT_PACKETS) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cf, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_BYPASS_APPS) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d9, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.SUBSCRIPTION_AUTO_UPDATE) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e3, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_MUX_XUDP_CONCURRENCY) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ed, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_ROUTING_DOMAIN_STRATEGY) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f7, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_FRAGMENT_ENABLED) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0101, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_LOCAL_DNS_PORT) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x010b, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_IS_BOOTED) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0115, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_VPN_DNS) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x011f, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_CONFIRM_REMOVE) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_LANGUAGE) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0128, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_MUX_CONCURRENCY) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x012b, code lost:
    
        r1 = renz.javacodez.v2ray.handler.MmkvManager.INSTANCE;
        r2 = "8";
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0136, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_DELAY_TEST_URL) == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x013f, code lost:
    
        if (r5.equals(renz.javacodez.v2ray.AppConfig.PREF_MODE) == false) goto L118;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSharedPreferenceChanged(android.content.SharedPreferences r4, java.lang.String r5) {
        /*
            Method dump skipped, instruction units count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: renz.javacodez.v2ray.viewmodel.SettingsViewModel.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    public final void startListenPreferenceChange() {
        Application application = getApplication();
        application.getSharedPreferences(e.a(application), 0).registerOnSharedPreferenceChangeListener(this);
    }
}
