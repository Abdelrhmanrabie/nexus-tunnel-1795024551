package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vc {
    public final jj0 a;
    public final zq0 b;
    public final y8 c;
    public final t11 d;

    public vc(jj0 jj0Var, zq0 zq0Var, y8 y8Var, t11 t11Var) {
        this.a = jj0Var;
        this.b = zq0Var;
        this.c = y8Var;
        this.d = t11Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vc)) {
            return false;
        }
        vc vcVar = (vc) obj;
        return e4.a(this.a, vcVar.a) && e4.a(this.b, vcVar.b) && this.c.equals(vcVar.c) && e4.a(this.d, vcVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ClassData(nameResolver=" + this.a + ", classProto=" + this.b + ", metadataVersion=" + this.c + ", sourceElement=" + this.d + ')';
    }
}
