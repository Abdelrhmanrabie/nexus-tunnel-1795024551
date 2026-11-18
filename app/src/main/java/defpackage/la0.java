package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class la0 extends ra0 implements ka0 {
    public final nu0$b r;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends ra0.b implements lw {
        public final la0 n;

        public a(la0 la0Var) {
            this.n = la0Var;
        }

        @Override // defpackage.lw
        public final Object invoke() {
            return ((a) this.n.r.invoke()).call(new Object[0]);
        }

        @Override // ra0.a
        public final ra0 p() {
            return this.n;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends oc0 implements lw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ la0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(la0 la0Var, int i) {
            super(0);
            this.G0 = i;
            this.b = la0Var;
        }

        @Override // defpackage.lw
        public final Object invoke() throws p10 {
            int i = this.G0;
            la0 la0Var = this.b;
            if (i == 0) {
                return new a(la0Var);
            }
            Member memberO = la0Var.o();
            try {
                Object obj = ra0.q;
                Object objJ = la0Var.n() ? e.j(la0Var.n, la0Var.l()) : null;
                if (objJ == obj) {
                    objJ = null;
                }
                la0Var.n();
                if (memberO == null) {
                    return null;
                }
                if (memberO instanceof Field) {
                    return ((Field) memberO).get(objJ);
                }
                if (!(memberO instanceof Method)) {
                    throw new AssertionError("delegate field/method " + memberO + " neither field nor method");
                }
                int length = ((Method) memberO).getParameterTypes().length;
                if (length == 0) {
                    return ((Method) memberO).invoke(null, null);
                }
                if (length == 1) {
                    Method method = (Method) memberO;
                    if (objJ == null) {
                        objJ = lc1.c(((Method) memberO).getParameterTypes()[0]);
                    }
                    return method.invoke(null, objJ);
                }
                if (length == 2) {
                    return ((Method) memberO).invoke(null, objJ, lc1.c(((Method) memberO).getParameterTypes()[1]));
                }
                throw new AssertionError("delegate method " + memberO + " should take 0, 1, or 2 parameters");
            } catch (IllegalAccessException e) {
                throw new p10("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", e);
            }
        }
    }

    public la0(p90 p90Var, String str, String str2, Object obj) {
        super(p90Var, str, str2, null, obj);
        this.r = new nu0$b(new b(this, 0));
        e.V(be0.b, new b(this, 1));
    }

    public la0(p90 p90Var, nq0 nq0Var) {
        super(p90Var, nq0Var);
        this.r = new nu0$b(new b(this, 0));
        e.V(be0.b, new b(this, 1));
    }

    @Override // defpackage.lw
    public final Object invoke() {
        return ((a) this.r.invoke()).call(new Object[0]);
    }

    @Override // defpackage.ra0
    public final ra0.b r() {
        return (a) this.r.invoke();
    }
}
