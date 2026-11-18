package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class p60 {
    public static final p60 d;
    public final p70 a;
    public final boolean c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final /* synthetic */ class a extends ux implements nw {
        public static final a d = new a(1);

        @Override // kotlin.jvm.internal.a, defpackage.a90
        public final String getName() {
            return "getDefaultReportLevelForAnnotation";
        }

        @Override // kotlin.jvm.internal.a
        public final o90 getOwner() {
            return ou0.a.c(u50.class, "compiler.common.jvm");
        }

        @Override // kotlin.jvm.internal.a
        public final String getSignature() {
            return "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;";
        }

        @Override // defpackage.nw
        public final Object invoke(Object obj) {
            cv cvVar = (cv) obj;
            cv cvVar2 = u50.a;
            yl0.a.getClass();
            zl0 zl0Var = yl0.a.b;
            nc0 nc0Var = nc0.g;
            gv0 gv0Var = (gv0) ((ff0.j) zl0Var.c).invoke(cvVar);
            if (gv0Var != null) {
                return gv0Var;
            }
            zl0 zl0Var2 = u50.b;
            zl0Var2.getClass();
            v50 v50Var = (v50) ((ff0.j) zl0Var2.c).invoke(cvVar);
            if (v50Var == null) {
                return gv0.c;
            }
            nc0 nc0Var2 = v50Var.b;
            return (nc0Var2 == null || nc0Var2.f - nc0Var.f > 0) ? v50Var.a : v50Var.c;
        }
    }

    static {
        cv cvVar = u50.a;
        nc0 nc0Var = nc0.g;
        v50 v50Var = u50.c;
        nc0 nc0Var2 = v50Var.b;
        gv0 gv0Var = (nc0Var2 == null || nc0Var2.f - nc0Var.f > 0) ? v50Var.a : v50Var.c;
        p70 p70Var = new p70(gv0Var, gv0Var == gv0.d ? null : gv0Var);
        a aVar = a.d;
        d = new p60(p70Var);
    }

    public p60(p70 p70Var) {
        a aVar = a.d;
        this.a = p70Var;
        this.c = p70Var.d || aVar.invoke(u50.a) == gv0.c;
    }

    public final String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.a + ", getReportLevelForAnnotation=" + a.d + ')';
    }
}
