package renz.javacodez.v2ray.ui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import defpackage.e;
import defpackage.hg1;
import defpackage.ig1;
import defpackage.jg1;
import defpackage.t1;
import defpackage.w4;
import renz.javacodez.v2ray.util.MyContextWrapper;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseActivity extends w4 {
    @Override // defpackage.w4, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        MyContextWrapper.Companion companion = MyContextWrapper.Companion;
        if (context == null) {
            return;
        }
        super.attachBaseContext(companion.wrap(context, Utils.INSTANCE.getLocale()));
    }

    @Override // androidx.fragment.app.n, androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public void onCreate(Bundle bundle) {
        e ig1Var;
        super.onCreate(bundle);
        t1 supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.m(true);
        }
        if (Utils.INSTANCE.getDarkModeStatus(this)) {
            return;
        }
        Window window = getWindow();
        getWindow().getDecorView();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            ig1Var = new jg1(window);
        } else {
            ig1Var = i >= 26 ? new ig1(window) : new hg1(window);
        }
        ig1Var.c(true);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getOnBackPressedDispatcher().c();
        return true;
    }
}
