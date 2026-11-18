package renz.javacodez.v2ray.plugin;

import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import defpackage.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class NativePlugin extends ResolvedPlugin {
    public NativePlugin(ResolveInfo resolveInfo) {
        super(resolveInfo);
        if (resolveInfo.providerInfo != null) {
            return;
        }
        d.AnonymousClass0.m("Check failed.");
        throw null;
    }

    @Override // renz.javacodez.v2ray.plugin.ResolvedPlugin
    public ProviderInfo getComponentInfo() {
        return getResolveInfo().providerInfo;
    }
}
