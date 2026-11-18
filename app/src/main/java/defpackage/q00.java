package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.widget.EditText;
import net.openvpn.ovpn3.ProxyList;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;
import renz.javacodez.vpn.service.RenzOpenVPNservice;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class q00 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int G0;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ HamoTunnelPlusMain d;

    public /* synthetic */ q00(HamoTunnelPlusMain hamoTunnelPlusMain, String str, EditText editText, int i) {
        this.G0 = i;
        this.d = hamoTunnelPlusMain;
        this.b = str;
        this.c = editText;
    }

    public q00(HamoTunnelPlusMain hamoTunnelPlusMain, ProxyList proxyList, String str) {
        this.G0 = 2;
        this.d = hamoTunnelPlusMain;
        this.c = proxyList;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ProxyList proxyList;
        int i2 = this.G0;
        if (i2 == 0) {
            if (i != -1) {
                return;
            }
            ((EditText) this.c).getText().toString();
            new Intent(this.d, (Class<?>) HamoTunnelPlusMain.class).addFlags(8388608).setAction(uh.a(-8423161888030L)).putExtra(uh.a(-8543420972318L), this.b);
            return;
        }
        if (i2 != 1) {
            if (i == -1 && (proxyList = (ProxyList) this.c) != null) {
                proxyList.remove(this.b);
                proxyList.save();
                this.d.v(false);
                return;
            }
            return;
        }
        if (i != -1) {
            return;
        }
        String string = ((EditText) this.c).getText().toString();
        String strA = uh.a(-8092449406238L);
        HamoTunnelPlusMain hamoTunnelPlusMain = this.d;
        hamoTunnelPlusMain.startService(new Intent(hamoTunnelPlusMain, (Class<?>) RenzOpenVPNservice.class).setAction(uh.a(-8178348752158L)).putExtra(strA.concat(uh.a(-8328672607518L)), this.b).putExtra(strA.concat(uh.a(-8367327313182L)), string));
    }
}
