package defpackage;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.savedstate.a;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ef implements h {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ ef(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // androidx.lifecycle.h
    public final void a(he0 he0Var, e.a aVar) {
        boolean z;
        int i = this.b;
        Object obj = this.c;
        if (i == 0) {
            ComponentActivity.m((ComponentActivity) obj, he0Var, aVar);
            return;
        }
        a aVar2 = (a) obj;
        if (aVar == e.a.ON_START) {
            z = true;
        } else if (aVar != e.a.ON_STOP) {
            return;
        } else {
            z = false;
        }
        aVar2.f = z;
    }
}
