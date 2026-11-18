package net.openvpn.ovpn3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import defpackage.uh;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;
import renz.javacodez.vpn.activities.d;
import renz.javacodez.vpn.service.RenzInjectorService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class OpenVPNRebootReceiver extends BroadcastReceiver {
    private static final String TAG = "OpenVPNRebootReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        RenzInjectorService renzInjectorService = d.i;
        PrefUtil prefUtil = new PrefUtil(PreferenceManager.getDefaultSharedPreferences(context));
        String str = prefUtil.get_string(uh.a(-6022275169566L));
        if (str != null) {
            prefUtil.delete_key(uh.a(-6121059417374L));
            if (prefUtil.get_boolean(uh.a(-6219843665182L), false)) {
                Intent intentPutExtra = new Intent(context, (Class<?>) HamoTunnelPlusMain.class).addFlags(276824064).putExtra(uh.a(-6262793338142L), str);
                context.startActivity(intentPutExtra);
                uh.a(-6447476931870L);
                uh.a(-6524786343198L);
                uh.a(-6649340394782L);
                intentPutExtra.toString();
            }
        }
    }
}
