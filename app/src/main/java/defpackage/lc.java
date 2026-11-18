package defpackage;

import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lc {
    public final ij0 a;
    public final vu0 b;
    public final Collection c;
    public final oc0 d;
    public final gc[] e;

    /* JADX WARN: Multi-variable type inference failed */
    public lc(ij0 ij0Var, vu0 vu0Var, Collection collection, nw nwVar, gc... gcVarArr) {
        this.a = ij0Var;
        this.b = vu0Var;
        this.c = collection;
        this.d = (oc0) nwVar;
        this.e = gcVarArr;
    }

    public lc(ij0 ij0Var, gc[] gcVarArr, nw nwVar) {
        this(ij0Var, null, null, nwVar, (gc[]) Arrays.copyOf(gcVarArr, gcVarArr.length));
    }

    public lc(Collection collection, gc[] gcVarArr, nw nwVar) {
        this(null, null, collection, nwVar, (gc[]) Arrays.copyOf(gcVarArr, gcVarArr.length));
    }
}
