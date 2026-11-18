package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class y80 {
    public static final c a = new c(u80.BOOLEAN);
    public static final c b = new c(u80.CHAR);
    public static final c c = new c(u80.BYTE);
    public static final c d = new c(u80.SHORT);
    public static final c e = new c(u80.INT);
    public static final c f = new c(u80.FLOAT);
    public static final c g = new c(u80.LONG);
    public static final c h = new c(u80.DOUBLE);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends y80 {
        public final y80 i;

        public a(y80 y80Var) {
            this.i = y80Var;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends y80 {
        public final String i;

        public b(String str) {
            this.i = str;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends y80 {
        public final u80 i;

        public c(u80 u80Var) {
            this.i = u80Var;
        }
    }

    public final String toString() {
        return e.t0(this);
    }
}
