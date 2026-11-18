package androidx.lifecycle;

import defpackage.he0;
import defpackage.sh0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements h {
    public final b[] b;

    public CompositeGeneratedAdaptersObserver(b[] bVarArr) {
        this.b = bVarArr;
    }

    @Override // androidx.lifecycle.h
    public final void a(he0 he0Var, e.a aVar) {
        sh0 sh0Var = new sh0();
        b[] bVarArr = this.b;
        for (b bVar : bVarArr) {
            bVar.a(aVar, false, sh0Var);
        }
        for (b bVar2 : bVarArr) {
            bVar2.a(aVar, true, sh0Var);
        }
    }
}
