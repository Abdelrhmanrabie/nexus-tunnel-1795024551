package defpackage;

import android.view.View;
import java.util.ArrayList;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d3 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ e3 c;

    public d3(e3 e3Var, int i) {
        this.c = e3Var;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        e3 e3Var = this.c;
        f00 f00Var = e3Var.c;
        ArrayList arrayList = e3Var.b;
        int i = this.b;
        HamoTunnelPlusMain hamoTunnelPlusMain = f00Var.b;
        try {
            ig igVar = hamoTunnelPlusMain.i0;
            String strB = mc1.b(hamoTunnelPlusMain, hamoTunnelPlusMain.m0.get(i).getString(uh.a(-32904475475230L)));
            igVar.getClass();
            String strA = uh.a(-126637841743134L);
            hy0.a aVar = igVar.b;
            aVar.putString(strA, strB);
            aVar.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ig igVar2 = hamoTunnelPlusMain.i0;
        igVar2.getClass();
        String strA2 = uh.a(-126947079388446L);
        hy0.a aVar2 = igVar2.b;
        aVar2.putInt(strA2, i);
        aVar2.apply();
        hamoTunnelPlusMain.w0();
        f00Var.a.dismiss();
    }
}
