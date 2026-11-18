package defpackage;

import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.e;
import androidx.lifecycle.h;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cf implements h {
    public final /* synthetic */ int G0 = 0;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ cf(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
        this.b = onBackPressedDispatcher;
        this.c = componentActivity;
    }

    public /* synthetic */ cf(dh0 dh0Var, kh0 kh0Var) {
        this.b = dh0Var;
        this.c = kh0Var;
    }

    @Override // androidx.lifecycle.h
    public final void a(he0 he0Var, e.a aVar) {
        if (this.G0 == 0) {
            ComponentActivity.n((OnBackPressedDispatcher) this.b, (ComponentActivity) this.c, he0Var, aVar);
            return;
        }
        e.a aVar2 = e.a.ON_DESTROY;
        dh0 dh0Var = (dh0) this.b;
        if (aVar == aVar2) {
            dh0Var.c((kh0) this.c);
        } else {
            dh0Var.getClass();
        }
    }
}
