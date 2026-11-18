package renz.javacodez.vpn.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.service.RenzInjectorService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class HamoTunnelPlusPrefs extends PreferenceActivity {
    @Override // android.preference.PreferenceActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        RenzInjectorService renzInjectorService = d.i;
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.g);
    }
}
