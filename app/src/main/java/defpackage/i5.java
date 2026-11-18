package defpackage;

import android.view.ViewGroup;
import androidx.appcompat.widget.ActionBarContextView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class i5 implements Runnable {
    public final /* synthetic */ int G0;
    public final /* synthetic */ f5 b;

    public /* synthetic */ i5(f5 f5Var, int i) {
        this.G0 = i;
        this.b = f5Var;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0041  */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        ViewGroup viewGroup;
        int i = this.G0;
        f5 f5Var = this.b;
        if (i != 0) {
            if ((f5Var.a0 & 1) != 0) {
                f5Var.J(0);
            }
            if ((f5Var.a0 & 4096) != 0) {
                f5Var.J(108);
            }
            f5Var.Z = false;
            f5Var.a0 = 0;
            return;
        }
        f5Var.w.showAtLocation(f5Var.v, 55, 0, 0);
        je1 je1Var = f5Var.y;
        if (je1Var != null) {
            je1Var.b();
        }
        if (f5Var.A && (viewGroup = f5Var.B) != null) {
            WeakHashMap weakHashMap = qd1.a;
            z = viewGroup.isLaidOut();
        }
        ActionBarContextView actionBarContextView = f5Var.v;
        if (!z) {
            actionBarContextView.setAlpha(1.0f);
            f5Var.v.setVisibility(0);
            return;
        }
        actionBarContextView.setAlpha(0.0f);
        je1 je1VarA = qd1.a(f5Var.v);
        je1VarA.a(1.0f);
        f5Var.y = je1VarA;
        je1VarA.d(new j5(2, this));
    }
}
