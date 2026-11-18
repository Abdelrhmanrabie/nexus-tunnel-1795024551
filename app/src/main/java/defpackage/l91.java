package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class l91 implements vg0 {
    public final /* synthetic */ int G0 = 1;
    public final Object b;

    public l91(ff0 ff0Var, lw lwVar) {
        ca0 ca0Var = new ca0(24, lwVar);
        ff0Var.getClass();
        this.b = new ff0.h(ff0Var, ca0Var);
    }

    public l91(vg0 vg0Var) {
        this.b = vg0Var;
    }

    @Override // defpackage.vg0
    public Collection a(ij0 ij0Var, dl0 dl0Var) {
        int i = this.G0;
        Collection collectionA$l0 = a$l0(ij0Var, dl0Var);
        return i != 0 ? collectionA$l0 : uh.a(collectionA$l0, ld0.b$7);
    }

    public final Collection a$l0(ij0 ij0Var, dl0 dl0Var) {
        return i().a(ij0Var, dl0Var);
    }

    @Override // defpackage.vg0
    public final Set b() {
        return i().b();
    }

    @Override // defpackage.vg0
    public Collection c(ij0 ij0Var, dl0 dl0Var) {
        int i = this.G0;
        Collection collectionC$l0 = c$l0(ij0Var, dl0Var);
        return i != 0 ? collectionC$l0 : uh.a(collectionC$l0, ld0.b$20);
    }

    public final Collection c$l0(ij0 ij0Var, dl0 dl0Var) {
        return i().c(ij0Var, dl0Var);
    }

    @Override // defpackage.vg0
    public final Set d() {
        return i().d();
    }

    @Override // defpackage.vg0
    public final od e(ij0 ij0Var, dl0 dl0Var) {
        return i().e(ij0Var, dl0Var);
    }

    @Override // defpackage.vg0
    public Collection f(lm lmVar, nw nwVar) {
        int i = this.G0;
        Collection collectionF$l0 = f$l0(lmVar, nwVar);
        if (i != 0) {
            return collectionF$l0;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionF$l0) {
            if (((ok) obj) instanceof ja) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        return he.X0(arrayList2, uh.a(arrayList, ld0.b$1));
    }

    public final Collection f$l0(lm lmVar, nw nwVar) {
        return i().f(lmVar, nwVar);
    }

    @Override // defpackage.vg0
    public final Set g() {
        return i().g();
    }

    public final vg0 h() {
        return i() instanceof l91 ? ((l91) i()).h() : i();
    }

    public final vg0 i() {
        int i = this.G0;
        Object obj = this.b;
        return i != 0 ? (vg0) ((ff0.h) obj).invoke() : (vg0) obj;
    }
}
