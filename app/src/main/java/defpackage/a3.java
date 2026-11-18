package defpackage;

import android.view.View;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class a3 implements View.OnClickListener {
    public final /* synthetic */ int G0;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ c3 c;

    public /* synthetic */ a3(c3 c3Var, JSONObject jSONObject, int i) {
        this.G0 = i;
        this.c = c3Var;
        this.b = jSONObject;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2 = this.G0;
        JSONObject jSONObject = this.b;
        c3 c3Var = this.c;
        int i3 = 0;
        if (i2 == 0) {
            f00 f00Var = c3Var.c;
            int iIndexOf = c3Var.b.indexOf(jSONObject);
            HamoTunnelPlusMain hamoTunnelPlusMain = f00Var.b;
            try {
                hamoTunnelPlusMain.i0.M(mc1.b(hamoTunnelPlusMain, jSONObject.getString(uh.a(-32706906979614L))));
                hamoTunnelPlusMain.i0.N(iIndexOf);
                int i4 = jSONObject.getInt(uh.a(-32728381816094L));
                if (i4 != 8 && i4 != 10 && i4 != 9) {
                    if (jSONObject.has(uh.a(-32775626456350L)) && (i = jSONObject.getInt(uh.a(-32840050965790L))) != 0) {
                        i3 = 1;
                        if (i != 1) {
                        }
                        int i5 = HamoTunnelPlusMain.b1;
                        hamoTunnelPlusMain.v0();
                        f00Var.a.dismiss();
                        return;
                    }
                    hamoTunnelPlusMain.k0(i3);
                } else if (i4 == 8) {
                    i3 = 2;
                    hamoTunnelPlusMain.k0(2);
                } else if (i4 == 10) {
                    i3 = 4;
                    hamoTunnelPlusMain.k0(4);
                } else {
                    i3 = 3;
                    hamoTunnelPlusMain.k0(3);
                }
                hamoTunnelPlusMain.i0.b0(i3);
            } catch (JSONException unused) {
            }
            int i6 = HamoTunnelPlusMain.b1;
            hamoTunnelPlusMain.v0();
            f00Var.a.dismiss();
            return;
        }
        c3Var.d.remove(jSONObject);
        f00 f00Var2 = c3Var.c;
        while (true) {
            HamoTunnelPlusMain hamoTunnelPlusMain2 = f00Var2.b;
            if (i3 >= hamoTunnelPlusMain2.w().length()) {
                c3Var.notifyDataSetChanged();
                return;
            }
            try {
                JSONArray jSONArrayW = hamoTunnelPlusMain2.w();
                if (mc1.b(hamoTunnelPlusMain2, jSONArrayW.getJSONObject(i3).getString(uh.a(-32432029072670L))).equals(mc1.b(hamoTunnelPlusMain2, jSONObject.getString(uh.a(-32453503909150L))))) {
                    jSONArrayW.remove(i3);
                    mc1.s(new File(hamoTunnelPlusMain2.getFilesDir(), uh.a(-32474978745630L)), mc1.d(jSONArrayW.toString()));
                    hamoTunnelPlusMain2.i0();
                    hamoTunnelPlusMain2.H(uh.a(-32560878091550L));
                    f00Var2.a.dismiss();
                }
            } catch (Exception e) {
                hamoTunnelPlusMain2.H(uh.a(-32633892535582L) + e.getMessage());
            }
            i3++;
        }
    }
}
