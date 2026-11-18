package renz.javacodez.vpn.activities;

import android.os.Bundle;
import renz.javacodez.vpn.service.RenzInjectorService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class HamoTunnelPlusDisconnect extends d {
    @Override // renz.javacodez.vpn.activities.d, androidx.fragment.app.n, androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public final void onCreate(Bundle bundle) {
        RenzInjectorService.c cVar;
        super.onCreate(bundle);
        RenzInjectorService renzInjectorService = d.i;
        if (renzInjectorService != null && (cVar = renzInjectorService.n) != null) {
            cVar.c();
        }
        I();
        finish();
    }
}
