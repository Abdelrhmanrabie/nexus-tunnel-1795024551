package defpackage;

import com.google.android.material.snackbar.Snackbar;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class tz implements km0 {
    public final /* synthetic */ int G0;
    public final /* synthetic */ HamoTunnelPlusMain a;

    public /* synthetic */ tz(HamoTunnelPlusMain hamoTunnelPlusMain, int i) {
        this.G0 = i;
        this.a = hamoTunnelPlusMain;
    }

    @Override // defpackage.km0
    public void a(Object obj) {
        int i = this.G0;
        HamoTunnelPlusMain hamoTunnelPlusMain = this.a;
        if (i == 0) {
            String str = (String) obj;
            if (str.startsWith(uh.a(-29305292881182L))) {
                hamoTunnelPlusMain.c0.setTextColor(-16711936);
                hamoTunnelPlusMain.c0.setText(str);
                hamoTunnelPlusMain.H0.setTextColor(-16711936);
                hamoTunnelPlusMain.H0.setText(str);
                hamoTunnelPlusMain.F0(100);
                hamoTunnelPlusMain.A0.b();
                hamoTunnelPlusMain.t0 = HamoTunnelPlusMain.w.c;
                if (hamoTunnelPlusMain.Q()) {
                }
                Snackbar.make(hamoTunnelPlusMain.c0, str).show();
                return;
            }
            int i2 = HamoTunnelPlusMain.b1;
            hamoTunnelPlusMain.O0();
            Snackbar.make(hamoTunnelPlusMain.c0, str).show();
            return;
        }
        Boolean bool = (Boolean) obj;
        if (hamoTunnelPlusMain.i0.s() == 3) {
            if (!bool.booleanValue()) {
                hamoTunnelPlusMain.F0(0);
                hamoTunnelPlusMain.c0.setTextColor(-65536);
                hamoTunnelPlusMain.c0.setText(hamoTunnelPlusMain.getString(R.string.ds));
                hamoTunnelPlusMain.H0.setTextColor(-65536);
                hamoTunnelPlusMain.H0.setText(hamoTunnelPlusMain.getString(R.string.ds));
                return;
            }
            hamoTunnelPlusMain.c0.setTextColor(-16711936);
            hamoTunnelPlusMain.c0.setText(hamoTunnelPlusMain.getString(R.string.cr));
            hamoTunnelPlusMain.H0.setTextColor(-16711936);
            hamoTunnelPlusMain.H0.setText(hamoTunnelPlusMain.getString(R.string.cr));
            hamoTunnelPlusMain.F0(100);
            hamoTunnelPlusMain.V(false);
            hamoTunnelPlusMain.X0.testCurrentServerRealPing();
        }
    }
}
