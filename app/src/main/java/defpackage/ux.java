package defpackage;

import kotlin.jvm.internal.a;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ux extends a implements kx, u90 {
    public final int b;
    public final int c;

    public ux(int i) {
        this(i, null, a.C0035a.b, null, null);
    }

    public ux(int i, Class cls, Object obj, String str, String str2) {
        super(obj, cls, str, str2, false);
        this.b = i;
        this.c = 0;
    }

    public ux(int i, Object obj) {
        this(i, null, obj, null, null);
    }

    @Override // kotlin.jvm.internal.a
    public final a90 computeReflected() {
        return ou0.a.a(this);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ux) {
            ux uxVar = (ux) obj;
            return getName().equals(uxVar.getName()) && getSignature().equals(uxVar.getSignature()) && this.c == uxVar.c && this.b == uxVar.b && e4.a(this.receiver, uxVar.receiver) && e4.a(getOwner(), uxVar.getOwner());
        }
        if (obj instanceof u90) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // defpackage.kx
    public final int getArity() {
        return this.b;
    }

    public final int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    public final String toString() {
        a90 a90VarCompute = compute();
        if (a90VarCompute != this) {
            return a90VarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
