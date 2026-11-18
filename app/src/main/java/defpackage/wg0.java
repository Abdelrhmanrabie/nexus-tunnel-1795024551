package defpackage;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class wg0 implements vg0 {
    @Override // defpackage.vg0
    public Collection a(ij0 ij0Var, dl0 dl0Var) {
        return uq.b;
    }

    @Override // defpackage.vg0
    public Set b() {
        Collection collectionF = f(lm.p, p0.b$16);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionF) {
            if (obj instanceof q01) {
                linkedHashSet.add(((q01) obj).getName());
            }
        }
        return linkedHashSet;
    }

    @Override // defpackage.vg0
    public Collection c(ij0 ij0Var, dl0 dl0Var) {
        return uq.b;
    }

    @Override // defpackage.vg0
    public Set d() {
        Collection collectionF = f(lm.q, p0.b$16);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionF) {
            if (obj instanceof q01) {
                linkedHashSet.add(((q01) obj).getName());
            }
        }
        return linkedHashSet;
    }

    @Override // defpackage.vg0
    public od e(ij0 ij0Var, dl0 dl0Var) {
        return null;
    }

    @Override // defpackage.vg0
    public Collection f(lm lmVar, nw nwVar) {
        return uq.b;
    }

    @Override // defpackage.vg0
    public Set g() {
        return null;
    }
}
