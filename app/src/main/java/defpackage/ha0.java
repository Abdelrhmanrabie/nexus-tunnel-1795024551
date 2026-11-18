package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ha0 {
    public static final /* synthetic */ ja0[] g;
    public final b90 b;
    public final int c;
    public final ga0$a d;
    public final nu0$a f;

    static {
        pu0 pu0Var = ou0.a;
        g = new ja0[]{pu0Var.f(new tq0(pu0Var.b(ha0.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), pu0Var.f(new tq0(pu0Var.b(ha0.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public ha0(b90 b90Var, int i, ga0$a ga0_a, lw lwVar) {
        this.b = b90Var;
        this.c = i;
        this.d = ga0_a;
        this.f = ak.c(lwVar);
        ak.c(new ca0(7, this));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ha0)) {
            return false;
        }
        ha0 ha0Var = (ha0) obj;
        if (this.b.equals(ha0Var.b)) {
            return this.c == ha0Var.c;
        }
        return false;
    }

    public final String getName() {
        ja0 ja0Var = g[0];
        lo0 lo0Var = (lo0) this.f.invoke();
        wc1 wc1Var = lo0Var instanceof wc1 ? (wc1) lo0Var : null;
        if (wc1Var != null && !wc1Var.b().h0()) {
            ij0 name = wc1Var.getName();
            if (!name.c) {
                return name.b();
            }
        }
        return null;
    }

    public final int hashCode() {
        return Integer.valueOf(this.c).hashCode() + (this.b.hashCode() * 31);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0051  */
    /* JADX WARN: Code duplicated, block: B:18:0x0055  */
    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    public final String toString() {
        String str;
        la laVarL;
        String strB;
        nm nmVar = ru0.a;
        StringBuilder sb = new StringBuilder();
        int iOrdinal = this.d.ordinal();
        if (iOrdinal == 0) {
            str = "instance parameter";
        } else {
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    str = "parameter #" + this.c + ' ' + ((Object) getName());
                }
                sb.append(" of ");
                laVarL = this.b.l();
                if (laVarL instanceof nq0) {
                    strB = ru0.c((nq0) laVarL);
                } else {
                    if (laVarL instanceof ox) {
                        throw new IllegalStateException(e4.j("Illegal callable: ", laVarL).toString());
                    }
                    strB = ru0.b((ox) laVarL);
                }
                sb.append(strB);
                return sb.toString();
            }
            str = "extension receiver parameter";
        }
        sb.append(str);
        sb.append(" of ");
        laVarL = this.b.l();
        if (laVarL instanceof nq0) {
            strB = ru0.c((nq0) laVarL);
        } else {
            if (laVarL instanceof ox) {
                throw new IllegalStateException(e4.j("Illegal callable: ", laVarL).toString());
            }
            strB = ru0.b((ox) laVarL);
        }
        sb.append(strB);
        return sb.toString();
    }
}
