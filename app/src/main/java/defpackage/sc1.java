package defpackage;

import java.util.List;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class sc1 implements gc {
    public final /* synthetic */ int G0;
    public final String a;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends sc1 {
        public final int b;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(int i) {
            StringBuilder sbN = ak.n(i, "must have at least ", " value parameter");
            sbN.append(i > 1 ? "s" : AppConfig.CUSTOM);
            super(sbN.toString(), 0);
            this.b = i;
        }

        @Override // defpackage.gc
        public final boolean b(q50 q50Var) {
            return q50Var.f().size() >= this.b;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends sc1 {
        public static final b b = new b("must have no value parameters", 1);
        public static final b b$1 = new b("must have a single value parameter", 2);
        public final /* synthetic */ int G0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(String str, int i) {
            super(str, 0);
            this.G0 = i;
        }

        @Override // defpackage.gc
        public final boolean b(q50 q50Var) {
            int i = this.G0;
            List listF = q50Var.f();
            if (i != 0) {
                if (i == 1) {
                    return listF.isEmpty();
                }
                if (listF.size() != 1) {
                    return false;
                }
            } else if (listF.size() != 2) {
                return false;
            }
            return true;
        }
    }

    public /* synthetic */ sc1(String str, int i) {
        this.G0 = i;
        this.a = str;
    }

    @Override // defpackage.gc
    public final String a(q50 q50Var) {
        return e4.a((gc) this, q50Var);
    }

    @Override // defpackage.gc
    public final String getDescription() {
        return this.a;
    }
}
