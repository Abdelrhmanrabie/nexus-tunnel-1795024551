package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class j implements nw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;

    public /* synthetic */ j(int i, Object obj) {
        this.G0 = i;
        this.b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a4  */
    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        boolean z;
        int i = this.G0;
        if (i == 0) {
            k.a aVar = (k.a) this.b;
            ((lc0$a) obj).getClass();
            return (u01) aVar.b.c.invoke();
        }
        if (i == 1) {
            la laVar = (la) obj;
            if (!cn.e(laVar.getVisibility())) {
                ai0 ai0Var = (ai0) this.b;
                if (ai0Var == null) {
                    cn.a(3);
                    throw null;
                }
                z = cn.c(cn.m, laVar, ai0Var) == null;
            }
            return Boolean.valueOf(z);
        }
        if (i != 2) {
            la laVar2 = (la) obj;
            if (laVar2 != null) {
                ((wm) this.b).a.c(laVar2);
                return tb1.a;
            }
            d.AnonymousClass0.m$4("Argument for @NotNull parameter 'descriptor' of kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1.invoke must not be null");
            return null;
        }
        ij0 ij0Var = (ij0) obj;
        ji0 ji0Var = ((ub0) this.b).a;
        ji0Var.getClass();
        cv cvVar = m21.i;
        l91 l91Var = ji0Var.U(cvVar).j;
        if (l91Var == null) {
            ub0.a(11);
            throw null;
        }
        od odVarE = l91Var.e(ij0Var, dl0.b);
        if (odVarE == null) {
            throw new AssertionError("Built-in class " + cvVar.c(ij0Var) + " is not found");
        }
        if (odVarE instanceof ai0) {
            return (ai0) odVarE;
        }
        throw new AssertionError("Must be a class descriptor " + ij0Var + ", but was " + odVarE);
    }
}
