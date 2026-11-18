package defpackage;

import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class nu0$a extends e4 implements lw {
    public final lw c;
    public volatile SoftReference d;

    public nu0$a(la laVar, lw lwVar) {
        if (lwVar == null) {
            d.AnonymousClass0.m$4("Argument for @NotNull parameter 'initializer' of kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal.<init> must not be null");
            throw null;
        }
        this.d = null;
        this.c = lwVar;
        if (laVar != null) {
            this.d = new SoftReference(laVar);
        }
    }

    @Override // defpackage.lw
    public final Object invoke() {
        Object obj;
        SoftReference softReference = this.d;
        Object obj2 = e4.b;
        if (softReference != null && (obj = softReference.get()) != null) {
            if (obj == obj2) {
                return null;
            }
            return obj;
        }
        Object objInvoke = this.c.invoke();
        if (objInvoke != null) {
            obj2 = objInvoke;
        }
        this.d = new SoftReference(obj2);
        return objInvoke;
    }
}
