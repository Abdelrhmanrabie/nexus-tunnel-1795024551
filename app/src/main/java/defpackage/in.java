package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class in implements s4 {
    public static final /* synthetic */ ja0[] c;
    public final ff0.h b;

    static {
        pu0 pu0Var = ou0.a;
        c = new ja0[]{pu0Var.f(new tq0(pu0Var.b(in.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public in(ff0 ff0Var, lw lwVar) {
        ff0Var.getClass();
        this.b = new ff0.h(ff0Var, lwVar);
    }

    @Override // defpackage.s4
    public final g4 c(cv cvVar) {
        Object next;
        Iterator it = iterator();
        while (it.hasNext()) {
            next = it.next();
            if (e4.a(((g4) next).e(), cvVar)) {
                return (g4) next;
            }
        }
        next = null;
        return (g4) next;
    }

    @Override // defpackage.s4
    public final boolean f(cv cvVar) {
        return c(cvVar) != null;
    }

    @Override // defpackage.s4
    public boolean isEmpty() {
        ja0 ja0Var = c[0];
        return ((List) this.b.invoke()).isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        ja0 ja0Var = c[0];
        return ((List) this.b.invoke()).iterator();
    }
}
