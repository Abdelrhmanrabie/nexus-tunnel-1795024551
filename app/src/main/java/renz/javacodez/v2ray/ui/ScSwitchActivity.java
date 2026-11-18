package renz.javacodez.v2ray.ui;

import android.os.Bundle;
import renz.javacodez.v2ray.R;
import renz.javacodez.v2ray.service.V2RayServiceManager;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ScSwitchActivity extends BaseActivity {
    @Override // renz.javacodez.v2ray.ui.BaseActivity, androidx.fragment.app.n, androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        moveTaskToBack(true);
        setContentView(R.layout.activity_none);
        if (V2RayServiceManager.INSTANCE.getV2rayPoint().getIsRunning()) {
            Utils.INSTANCE.stopVService(this);
        } else {
            Utils.INSTANCE.startVServiceFromToggle(this);
        }
        finish();
    }
}
