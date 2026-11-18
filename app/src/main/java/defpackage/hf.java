package defpackage;

import android.view.LayoutInflater;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.n;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hf implements xm0 {
    public final /* synthetic */ int G0;
    public final /* synthetic */ ComponentActivity a;

    public /* synthetic */ hf(ComponentActivity componentActivity, int i) {
        this.G0 = i;
        this.a = componentActivity;
    }

    @Override // defpackage.xm0
    public final void a(ComponentActivity componentActivity) {
        int i = this.G0;
        ComponentActivity componentActivity2 = this.a;
        if (i == 0) {
            ComponentActivity.j(componentActivity2, componentActivity);
            return;
        }
        if (i == 1) {
            n.r((n) componentActivity2, componentActivity);
            return;
        }
        w4 w4Var = (w4) componentActivity2;
        e5 delegate = w4Var.getDelegate();
        f5 f5Var = (f5) delegate;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(f5Var.g);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(f5Var);
        } else {
            layoutInflaterFrom.getFactory2();
        }
        w4Var.getSavedStateRegistry().a("androidx:appcompat");
        delegate.l();
    }
}
