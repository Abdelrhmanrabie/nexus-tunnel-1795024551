package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum wp0 {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");

    public final ij0 b;
    public final ij0 c;
    public final Object d;
    public final Object f;
    public static final Set g = ae.O0(new wp0[]{CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE});

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends oc0 implements lw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ wp0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(wp0 wp0Var, int i) {
            super(0);
            this.G0 = i;
            this.b = wp0Var;
        }

        @Override // defpackage.lw
        public final Object invoke() {
            cv cvVar;
            ij0 ij0Var;
            if (this.G0 != 0) {
                cvVar = m21.i;
                ij0Var = this.b.b;
            } else {
                cvVar = m21.i;
                ij0Var = this.b.c;
            }
            return cvVar.c(ij0Var);
        }
    }

    wp0(String str) {
        this.b = ij0.f(str);
        this.c = ij0.f(e4.j(str, "Array"));
        a aVar = new a(this, 1);
        be0 be0Var = be0.b;
        this.d = e.V(be0Var, aVar);
        this.f = e.V(be0Var, new a(this, 0));
    }
}
