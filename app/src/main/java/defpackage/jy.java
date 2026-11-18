package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class jy extends rd {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ iy b;

    public jy(ArrayList arrayList, iy iyVar) {
        this.a = arrayList;
        this.b = iyVar;
    }

    @Override // defpackage.v3
    public final void a(la laVar) {
        pn0.r(laVar, null);
        this.a.add(laVar);
    }

    @Override // defpackage.rd
    public final void g(la laVar, la laVar2) {
        throw new IllegalStateException(("Conflict in scope of " + this.b.b + ": " + laVar + " vs " + laVar2).toString());
    }
}
