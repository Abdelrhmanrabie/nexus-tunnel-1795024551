package defpackage;

import android.app.ActivityManager;
import android.content.DialogInterface;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class sy implements DialogInterface.OnClickListener {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;

    public /* synthetic */ sy(int i, Object obj) {
        this.G0 = i;
        this.b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.G0;
        Object obj = this.b;
        if (i2 == 0) {
            HamoTunnelPlusMain.r rVar = (HamoTunnelPlusMain.r) obj;
            if (rVar != null) {
                rVar.run();
                return;
            }
            return;
        }
        if (i2 != 1) {
            te0 te0Var = (te0) obj;
            te0Var.o = i;
            te0Var.n = -1;
            dialogInterface.dismiss();
            return;
        }
        HamoTunnelPlusMain hamoTunnelPlusMain = (HamoTunnelPlusMain) obj;
        try {
            ((ActivityManager) hamoTunnelPlusMain.getSystemService(uh.a(-35249527618846L))).clearApplicationUserData();
            int i3 = HamoTunnelPlusMain.b1;
            hamoTunnelPlusMain.r0();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
