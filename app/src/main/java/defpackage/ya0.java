package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ya0 implements n90 {
    public static final /* synthetic */ ja0[] f;
    public final v91 b;
    public final nu0$a c = ak.c(new ca0(28, this));
    public final za0 d;

    static {
        pu0 pu0Var = ou0.a;
        f = new ja0[]{pu0Var.f(new tq0(pu0Var.b(ya0.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    }

    public ya0(za0 za0Var, v91 v91Var) {
        j90 j90VarA;
        Object objR0;
        this.b = v91Var;
        if (za0Var == null) {
            ok okVarB = v91Var.b();
            if (okVarB instanceof ai0) {
                objR0 = a((ai0) okVarB);
            } else {
                if (!(okVarB instanceof la)) {
                    throw new yi(e4.j("Unknown type parameter container: ", okVarB));
                }
                ok okVarB2 = ((la) okVarB).b();
                if (okVarB2 instanceof ai0) {
                    j90VarA = a((ai0) okVarB2);
                } else {
                    un unVar = okVarB instanceof un ? (un) okVarB : null;
                    if (unVar == null) {
                        throw new yi(e4.j("Non-class callable descriptor must be deserialized: ", okVarB));
                    }
                    rn rnVarM = unVar.M();
                    s80 s80Var = (s80) (rnVarM instanceof s80 ? rnVarM : null);
                    ju0 ju0Var = s80Var == null ? null : s80Var.d;
                    ju0 ju0Var2 = ju0Var != null ? ju0Var : null;
                    if (ju0Var2 == null) {
                        throw new yi(e4.j("Container of deserialized member is not resolved: ", unVar));
                    }
                    j90VarA = (j90) ou0.a.b(ju0Var2.a);
                }
                objR0 = okVarB.r0(new bj(0, j90VarA), tb1.a);
            }
            za0Var = (za0) objR0;
        }
        this.d = za0Var;
    }

    public static j90 a(ai0 ai0Var) {
        Class clsH = lc1.h(ai0Var);
        j90 j90Var = (j90) (clsH == null ? null : ou0.a.b(clsH));
        if (j90Var != null) {
            return j90Var;
        }
        throw new yi(e4.j("Type parameter container is not resolved: ", ai0Var.b()));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ya0)) {
            return false;
        }
        ya0 ya0Var = (ya0) obj;
        return e4.a(this.d, ya0Var.d) && this.b.getName().b().equals(ya0Var.b.getName().b());
    }

    public final int hashCode() {
        return this.b.getName().b().hashCode() + (this.d.hashCode() * 31);
    }

    public final String toString() {
        bb0 bb0Var;
        String str;
        StringBuilder sb = new StringBuilder();
        v91 v91Var = this.b;
        int iOrdinal = v91Var.j().ordinal();
        if (iOrdinal == 0) {
            bb0Var = bb0.b;
        } else if (iOrdinal == 1) {
            bb0Var = bb0.c;
        } else {
            if (iOrdinal != 2) {
                d.AnonymousClass0.m();
                return null;
            }
            bb0Var = bb0.d;
        }
        int iOrdinal2 = bb0Var.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                str = "in ";
            } else {
                if (iOrdinal2 != 2) {
                    d.AnonymousClass0.m();
                    return null;
                }
                str = "out ";
            }
            sb.append(str);
        }
        sb.append(v91Var.getName().b());
        return sb.toString();
    }
}
