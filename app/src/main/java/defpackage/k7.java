package defpackage;

import renz.javacodez.v2ray.plugin.ResolvedPlugin;
import renz.javacodez.v2ray.service.V2RayVpnService;
import renz.javacodez.v2ray.ui.LogcatActivity;
import renz.javacodez.v2ray.ui.SettingsActivity;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k7 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ k7(Object obj, int i, int i2) {
        this.G0 = i2;
        this.b = i;
        this.c = obj;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        int i2 = this.b;
        if (i == 0) {
            Object obj = this.c;
            if (i2 != 0) {
                return i2 != 1 ? ResolvedPlugin.id_delegate$lambda$0((ResolvedPlugin) obj) : ((Iterable) obj).iterator();
            }
            return new a7(0, (Object[]) obj);
        }
        Object obj2 = this.c;
        if (i == 1) {
            return i2 != 0 ? V2RayVpnService.connectivity_delegate$lambda$1((V2RayVpnService) obj2) : Integer.valueOf(ResolvedPlugin.version_delegate$lambda$1((ResolvedPlugin) obj2));
        }
        if (i != 2) {
            if (i2 != 0) {
                return i2 != 1 ? V2RayVpnService.defaultNetworkCallback_delegate$lambda$2((V2RayVpnService) obj2) : ResolvedPlugin.versionName_delegate$lambda$2((ResolvedPlugin) obj2);
            }
            return obj2;
        }
        if (i2 == 0) {
            return SettingsActivity.SettingsFragment.fragmentLength_delegate$lambda$12((SettingsActivity.SettingsFragment) obj2);
        }
        if (i2 == 1) {
            return SettingsActivity.SettingsFragment.socksPort_delegate$lambda$16((SettingsActivity.SettingsFragment) obj2);
        }
        if (i2 == 2) {
            return SettingsActivity.SettingsFragment.localDns_delegate$lambda$1((SettingsActivity.SettingsFragment) obj2);
        }
        if (i2 != 3) {
            return i2 != 4 ? LogcatActivity.binding_delegate$lambda$0((LogcatActivity) obj2) : SettingsActivity.SettingsFragment.muxXudpConcurrency_delegate$lambda$8((SettingsActivity.SettingsFragment) obj2);
        }
        return SettingsActivity.SettingsFragment.localDnsPort_delegate$lambda$4((SettingsActivity.SettingsFragment) obj2);
    }
}
