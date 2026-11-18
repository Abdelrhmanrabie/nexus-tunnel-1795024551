package defpackage;

import android.os.Build;
import android.view.Window;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class tp extends e {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ tp(int i) {
        super(2);
        this.G0 = i;
    }

    @Override // defpackage.yp
    public void c(hk0 hk0Var, hk0 hk0Var2, Window window, boolean z, boolean z2) {
        e ig1Var;
        e ig1Var2;
        int i = this.G0;
        ak.a(window);
        if (i == 0) {
            window.setStatusBarColor(z ? hk0Var.b : hk0Var.a);
            window.setNavigationBarColor(hk0Var2.b);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                ig1Var = new jg1(window);
            } else {
                ig1Var = i2 >= 26 ? new ig1(window) : new hg1(window);
            }
            ig1Var.c(!z);
            return;
        }
        window.setStatusBarColor(z ? hk0Var.b : hk0Var.a);
        window.setNavigationBarColor(z2 ? hk0Var2.b : hk0Var2.a);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            ig1Var2 = new jg1(window);
        } else {
            ig1Var2 = i3 >= 26 ? new ig1(window) : new hg1(window);
        }
        ig1Var2.c(!z);
        ig1Var2.b(!z2);
    }
}
