package defpackage;

import android.os.Build;
import android.view.Window;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class wp extends vp {
    @Override // defpackage.tp, defpackage.yp
    public final void c(hk0 hk0Var, hk0 hk0Var2, Window window, boolean z, boolean z2) {
        e ig1Var;
        ak.a(window);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        window.setStatusBarContrastEnforced(false);
        window.setNavigationBarContrastEnforced(true);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            ig1Var = new jg1(window);
        } else {
            ig1Var = i >= 26 ? new ig1(window) : new hg1(window);
        }
        ig1Var.c(!z);
        ig1Var.b(true ^ z2);
    }
}
