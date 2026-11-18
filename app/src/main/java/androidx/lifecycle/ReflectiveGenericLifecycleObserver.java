package androidx.lifecycle;

import defpackage.he0;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements h {
    public final Object b;
    public final a.C0014a c;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.b = obj;
        this.c = a.c.b(obj.getClass());
    }

    @Override // androidx.lifecycle.h
    public final void a(he0 he0Var, e.a aVar) {
        HashMap map = this.c.a;
        List list = (List) map.get(aVar);
        Object obj = this.b;
        a.C0014a.a(list, he0Var, aVar, obj);
        a.C0014a.a((List) map.get(e.a.ON_ANY), he0Var, aVar, obj);
    }
}
