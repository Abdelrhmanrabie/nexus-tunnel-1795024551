package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lr implements qs {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            System.arraycopy(ak.a$1, 0, new int[3], 0, 3);
            a = new int[]{1, 0, 0};
        }
    }

    @Override // defpackage.qs
    public final qs.a a() {
        return qs.a.c;
    }

    @Override // defpackage.qs
    public final qs.b b(ja jaVar, ja jaVar2, ai0 ai0Var) {
        boolean z;
        ja jaVarMo7build;
        boolean z2 = jaVar2 instanceof q50;
        qs.b bVar = qs.b.d;
        if (z2) {
            q50 q50Var = (q50) jaVar2;
            if (q50Var.getTypeParameters().isEmpty()) {
                pn0.b bVarI = pn0.i(jaVar, jaVar2);
                if ((bVarI == null ? 0 : bVarI.c()) == 0) {
                    yt ytVarU = fz0.u(ae.B0(new sy0[]{new c81(new ge(0, q50Var.f()), ld0.b$5), ae.B0(new Object[]{q50Var.j})}));
                    sc0 sc0Var = q50Var.n;
                    et.b bVar2 = new et.b(fz0.u(ae.B0(new sy0[]{ytVarU, new ge(0, e.Z(sc0Var == null ? null : sc0Var.getType()))})));
                    while (true) {
                        if (!bVar2.hasNext()) {
                            z = false;
                            break;
                        }
                        fc0 fc0Var = (fc0) bVar2.next();
                        if ((fc0Var.K0().isEmpty() || (fc0Var.O0() instanceof ls0)) ? false : true) {
                            z = true;
                            break;
                        }
                    }
                    if (!z && (jaVarMo7build = (ja) jaVar.c(new ha1(new js0(null)))) != null) {
                        if (jaVarMo7build instanceof q01) {
                            q01 q01Var = (q01) jaVarMo7build;
                            if (!q01Var.getTypeParameters().isEmpty()) {
                                jaVarMo7build = q01Var.s().j().mo7build();
                            }
                        }
                        int iC = pn0.d.n(jaVarMo7build, jaVar2, false).c();
                        if (iC == 0) {
                            throw new NullPointerException(ak.j("DEFAULT.isOverridableByW…Descriptor, false).result", " must not be null"));
                        }
                        if (a.a[ak.u(iC)] == 1) {
                            return qs.b.b;
                        }
                    }
                }
            }
        }
        return bVar;
    }
}
