package defpackage;

import kotlin.jvm.internal.a;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class uq0 extends a implements ja0 {
    public final boolean syntheticJavaProperty;

    public uq0(int i, Class cls, Object obj, String str, String str2) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.syntheticJavaProperty = (i & 2) == 2;
    }

    @Override // kotlin.jvm.internal.a
    public final a90 compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof uq0) {
            uq0 uq0Var = (uq0) obj;
            return getOwner().equals(uq0Var.getOwner()) && this.name.equals(uq0Var.name) && this.signature.equals(uq0Var.signature) && e4.a(this.receiver, uq0Var.receiver);
        }
        if (obj instanceof ja0) {
            return obj.equals(compute());
        }
        return false;
    }

    public final ja0 getReflected() {
        if (this.syntheticJavaProperty) {
            d.AnonymousClass0.m$3("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
            return null;
        }
        a90 a90VarCompute = compute();
        if (a90VarCompute != this) {
            return (ja0) a90VarCompute;
        }
        throw new yi("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public final int hashCode() {
        return this.signature.hashCode() + ((this.name.hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    public final String toString() {
        a90 a90VarCompute = compute();
        return a90VarCompute != this ? a90VarCompute.toString() : fb$1.m(new StringBuilder("property "), this.name, " (Kotlin reflection is not available)");
    }
}
