package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gd0 implements ao0 {
    public final v8 a;
    public final ff0.b b;

    public gd0(c60 c60Var) {
        this.a = new v8(c60Var, ke.a$5, new d20());
        ff0 ff0Var = c60Var.a;
        ff0Var.getClass();
        this.b = new ff0.b(ff0Var, new ConcurrentHashMap(3, 1.0f, 2));
    }

    @Override // defpackage.ao0
    public final boolean a(cv cvVar) {
        ((c60) this.a.a).b.getClass();
        return false;
    }

    @Override // defpackage.ao0
    public final List b(cv cvVar) {
        return Collections.singletonList(d(cvVar));
    }

    @Override // defpackage.ao0
    public final void c(cv cvVar, ArrayList arrayList) {
        arrayList.add(d(cvVar));
    }

    public final fd0 d(cv cvVar) throws Throwable {
        ((c60) this.a.a).b.getClass();
        qn qnVar = new qn(7, this, new cu0(cvVar));
        ff0.b bVar = this.b;
        bVar.getClass();
        Object objInvoke = bVar.invoke(new ff0.e(cvVar, qnVar));
        if (objInvoke != null) {
            return (fd0) objInvoke;
        }
        throw new IllegalStateException("@NotNull method kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction.computeIfAbsent must not return null");
    }

    @Override // defpackage.ao0
    public final Collection l(cv cvVar, nw nwVar) {
        return (List) d(cvVar).q.invoke();
    }

    public final String toString() {
        return e4.j("LazyJavaPackageFragmentProvider of module ", ((c60) this.a.a).o);
    }
}
