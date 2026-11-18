package renz.javacodez.vpn.activities;

import androidx.lifecycle.b;
import defpackage.sh0;
import java.util.HashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class HamoTunnelPlusApplication_LifecycleAdapter implements b {
    public final HamoTunnelPlusApplication a;

    public HamoTunnelPlusApplication_LifecycleAdapter(HamoTunnelPlusApplication hamoTunnelPlusApplication) {
        this.a = hamoTunnelPlusApplication;
    }

    @Override // androidx.lifecycle.b
    public final void a(androidx.lifecycle.e.a aVar, boolean z, sh0 sh0Var) {
        boolean z2 = sh0Var != null;
        if (!z && aVar == androidx.lifecycle.e.a.ON_START) {
            if (z2) {
                sh0Var.getClass();
                HashMap map = sh0Var.a;
                Integer num = (Integer) map.get("onMoveToForeground");
                int iIntValue = num != null ? num.intValue() : 0;
                boolean z3 = (iIntValue & 1) != 0;
                map.put("onMoveToForeground", Integer.valueOf(iIntValue | 1));
                if (z3) {
                    return;
                }
            }
            this.a.onMoveToForeground();
        }
    }
}
