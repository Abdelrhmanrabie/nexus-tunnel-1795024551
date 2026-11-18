package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;
import renz.javacodez.vpn.service.RenzOpenVPNservice;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ry implements DialogInterface.OnClickListener {
    public final /* synthetic */ String b;
    public final /* synthetic */ HamoTunnelPlusMain c;

    public ry(HamoTunnelPlusMain hamoTunnelPlusMain, String str) {
        this.c = hamoTunnelPlusMain;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i != -1) {
            return;
        }
        HamoTunnelPlusMain hamoTunnelPlusMain = this.c;
        hamoTunnelPlusMain.startService(new Intent(hamoTunnelPlusMain, (Class<?>) RenzOpenVPNservice.class).setAction(uh.a(-7821866466590L)).putExtra(uh.a(-7972190321950L), this.b));
    }
}
