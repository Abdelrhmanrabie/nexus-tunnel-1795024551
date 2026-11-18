package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hf0 extends ff0.f implements ml0 {
    public volatile g f;
    public final /* synthetic */ i i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hf0(ff0 ff0Var, ca0 ca0Var, i iVar) {
        super(ff0Var, ca0Var);
        this.i = iVar;
        if (ff0Var == null) {
            a$ff0$i(0);
            throw null;
        }
        this.f = null;
    }

    public static /* synthetic */ void a$ff0$i(int i) {
        String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 2 ? 3 : 2];
        if (i == 1) {
            objArr[0] = "computable";
        } else if (i != 2) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        }
        if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        } else {
            objArr[1] = "invoke";
        }
        if (i != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i == 2) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // ff0.f
    public final void b(Object obj) {
        this.f = new g(obj);
        try {
            if (obj == null) {
                throw new IllegalArgumentException("Argument for @NotNull parameter 'value' of kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5.doPostCompute must not be null");
            }
            this.i.invoke(obj);
            this.f = null;
        } catch (Throwable th) {
            this.f = null;
            throw th;
        }
    }

    @Override // ff0.f
    public final c5 c(boolean z) {
        return new c5(4, p0.b$7.invoke(Boolean.valueOf(z)), false);
    }

    @Override // ff0.f, defpackage.lw
    public final Object invoke() throws Throwable {
        Object objInvoke;
        g gVar = this.f;
        if (gVar == null || ((Thread) gVar.b) != Thread.currentThread()) {
            objInvoke = super.invoke();
        } else if (((Thread) gVar.b) == Thread.currentThread()) {
            objInvoke = gVar.a;
        } else {
            d.AnonymousClass0.m("No value in this thread (hasValue should be checked before)");
            objInvoke = null;
        }
        if (objInvoke != null) {
            return objInvoke;
        }
        a$ff0$i(2);
        throw null;
    }
}
