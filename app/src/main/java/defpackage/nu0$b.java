package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class nu0$b extends e4 {
    public final oc0 c;
    public volatile Object d = null;

    /* JADX WARN: Multi-variable type inference failed */
    public nu0$b(lw lwVar) {
        this.c = (oc0) lwVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [lw, oc0] */
    public final Object invoke() {
        Object obj = this.d;
        Object obj2 = e4.b;
        if (obj != null) {
            if (obj == obj2) {
                return null;
            }
            return obj;
        }
        Object objInvoke = this.c.invoke();
        if (objInvoke != null) {
            obj2 = objInvoke;
        }
        this.d = obj2;
        return objInvoke;
    }
}
