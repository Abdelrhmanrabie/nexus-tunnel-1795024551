package defpackage;

import java.util.Collections;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class m90 extends qg {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class a {

        /* JADX INFO: renamed from: m90$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class C0037a extends a {
            public final fc0 a;

            public C0037a(fc0 fc0Var) {
                this.a = fc0Var;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0037a) && this.a.equals(((C0037a) obj).a);
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "LocalClass(type=" + this.a + ')';
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class b extends a {
            public final ed a;

            public b(ed edVar) {
                this.a = edVar;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && this.a.equals(((b) obj).a);
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "NormalClass(value=" + this.a + ')';
            }
        }
    }

    public m90(dd ddVar, int i) {
        super(new a.b(new ed(ddVar, i)));
    }

    public m90(ed edVar) {
        super(new a.b(edVar));
    }

    @Override // defpackage.qg
    public final fc0 a(gi0 gi0Var) {
        fc0 fc0VarD;
        s4$a$a s4_a_a = e4.f47a;
        ub0 ub0VarK = gi0Var.k();
        ub0VarK.getClass();
        ai0 ai0VarJ = ub0VarK.j(m21.a.O.h());
        Object obj = this.a;
        a aVar = (a) obj;
        if (aVar instanceof a.C0037a) {
            fc0VarD = ((a.C0037a) obj).a;
        } else {
            if (!(aVar instanceof a.b)) {
                d.AnonymousClass0.m();
                return null;
            }
            ed edVar = ((a.b) obj).a;
            dd ddVar = edVar.a;
            ai0 ai0VarA = e4.a(gi0Var, ddVar);
            int i = edVar.b;
            if (ai0VarA == null) {
                fc0VarD = pr.d("Unresolved type: " + ddVar + " (arrayDimensions=" + i + ')');
            } else {
                cc1 cc1VarY = e.Y((fc0) ai0VarA.n());
                int i2 = 0;
                while (i2 < i) {
                    i2++;
                    cc1VarY = gi0Var.k().h(cc1VarY);
                }
                fc0VarD = cc1VarY;
            }
        }
        return e4.f(s4_a_a, ai0VarJ.h(), Collections.singletonList(new da1(fc0VarD)), false);
    }
}
