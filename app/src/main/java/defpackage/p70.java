package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class p70 {
    public final gv0 a;
    public final gv0 b;
    public final boolean d;

    public p70(gv0 gv0Var, gv0 gv0Var2) {
        this.a = gv0Var;
        this.b = gv0Var2;
        gv0 gv0Var3 = gv0.c;
        this.d = gv0Var == gv0Var3 && gv0Var2 == gv0Var3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p70)) {
            return false;
        }
        p70 p70Var = (p70) obj;
        if (this.a != p70Var.a || this.b != p70Var.b) {
            return false;
        }
        vq vqVar = vq.b;
        return vqVar.equals(vqVar);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        gv0 gv0Var = this.b;
        return (iHashCode + (gv0Var == null ? 0 : gv0Var.hashCode())) * 31;
    }

    public final String toString() {
        return "Jsr305Settings(globalLevel=" + this.a + ", migrationLevel=" + this.b + ", userDefinedLevelForSpecificAnnotation=" + vq.b + ')';
    }
}
