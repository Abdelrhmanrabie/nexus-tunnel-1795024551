package defpackage;

import android.content.pm.ResolveInfo;
import renz.javacodez.v2ray.plugin.PluginManager;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cz0 implements nw {
    public final /* synthetic */ int b;

    public /* synthetic */ cz0(int i) {
        this.b = i;
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        if (this.b != 0) {
            return PluginManager.initNative$lambda$8((ResolveInfo) obj);
        }
        return Boolean.valueOf(obj == null);
    }
}
