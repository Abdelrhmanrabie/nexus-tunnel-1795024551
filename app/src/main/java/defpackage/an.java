package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class an extends b2 {
    public final /* synthetic */ int G0 = 2;
    public final /* synthetic */ Object a;
    public final /* synthetic */ Serializable b;

    public an(String str, vu0 vu0Var) {
        this.b = str;
        this.a = vu0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public an(nw nwVar, boolean[] zArr) {
        this.a = nwVar;
        this.b = zArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public an(vu0 vu0Var, nw nwVar) {
        this.a = vu0Var;
        this.b = (oc0) nwVar;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [nw, oc0] */
    @Override // defpackage.b2
    public void a(Object obj) {
        if (this.G0 != 0) {
            return;
        }
        la laVar = (la) obj;
        vu0 vu0Var = (vu0) this.a;
        if (vu0Var.b == null && ((Boolean) ((oc0) this.b).invoke(laVar)).booleanValue()) {
            vu0Var.b = laVar;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0060 A[RETURN] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, nw] */
    @Override // defpackage.b2
    /* JADX INFO: renamed from: b */
    public final boolean mo2b(Object obj) {
        a80.a aVar;
        int i = this.G0;
        if (i == 0) {
            if (((vu0) this.a).b == null) {
                return true;
            }
            return false;
        }
        if (i == 1) {
            boolean zBooleanValue = ((Boolean) this.a.invoke(obj)).booleanValue();
            boolean[] zArr = (boolean[]) this.b;
            if (zBooleanValue) {
                zArr[0] = true;
            }
            return !zArr[0];
        }
        String strQ1 = e.q1((ai0) obj, (String) this.b);
        boolean zContains = l80.b.contains(strQ1);
        vu0 vu0Var = (vu0) this.a;
        if (zContains) {
            aVar = a80.a.b;
        } else {
            if (!l80.c.contains(strQ1)) {
                if (l80.a.contains(strQ1)) {
                    aVar = a80.a.f;
                }
                if (vu0Var.b == null) {
                    return true;
                }
                return false;
            }
            aVar = a80.a.c;
        }
        vu0Var.b = aVar;
        if (vu0Var.b == null) {
            return true;
        }
        return false;
    }

    @Override // defpackage.b2
    public final Object result() {
        int i = this.G0;
        if (i == 0) {
            return (la) ((vu0) this.a).b;
        }
        if (i == 1) {
            return Boolean.valueOf(((boolean[]) this.b)[0]);
        }
        a80.a aVar = (a80.a) ((vu0) this.a).b;
        return aVar == null ? a80.a.d : aVar;
    }
}
