package defpackage;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedCollection;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class j30 implements a91, b91 {
    public final fc0 a;
    public final LinkedHashSet b;
    public final int c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements Comparator {
        public final /* synthetic */ oc0 b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(nw nwVar) {
            this.b = (oc0) nwVar;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [nw, oc0] */
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            ?? r0 = this.b;
            return e.l(r0.invoke((fc0) obj).toString(), r0.invoke((fc0) obj2).toString());
        }
    }

    public j30(AbstractCollection abstractCollection) {
        abstractCollection.isEmpty();
        LinkedHashSet linkedHashSet = new LinkedHashSet(abstractCollection);
        this.b = linkedHashSet;
        this.c = linkedHashSet.hashCode();
    }

    public j30(LinkedHashSet linkedHashSet, fc0 fc0Var) {
        this(linkedHashSet);
        this.a = fc0Var;
    }

    @Override // defpackage.a91
    public final od b() {
        return null;
    }

    @Override // defpackage.a91
    public final boolean c() {
        return false;
    }

    @Override // defpackage.a91
    public final Collection d() {
        return this.b;
    }

    public final u01 e() {
        return e4.g(e4.f47a, this, uq.b, false, b2.a("member scope for intersection type", (SequencedCollection) this.b), new i(5, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j30)) {
            return false;
        }
        return e4.a(this.b, ((j30) obj).b);
    }

    @Override // defpackage.a91
    public final List getParameters() {
        return uq.b;
    }

    public final int hashCode() {
        return this.c;
    }

    @Override // defpackage.a91
    public final ub0 k() {
        return ((fc0) this.b.iterator().next()).L0().k();
    }

    public final String toString() {
        List listAsList;
        ba baVar = ba.b$24;
        b bVar = new b(baVar);
        LinkedHashSet linkedHashSet = this.b;
        if (linkedHashSet.size() <= 1) {
            listAsList = he.g1(linkedHashSet);
        } else {
            Object[] array = linkedHashSet.toArray(new Object[0]);
            if (array.length > 1) {
                Arrays.sort(array, bVar);
            }
            listAsList = Arrays.asList(array);
        }
        return he.R0(listAsList, " & ", "{", "}", new i(baVar), 24);
    }
}
