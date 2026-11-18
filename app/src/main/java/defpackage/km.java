package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class km {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends km {
        public static final a a = new a();
        public static final int b;

        static {
            lm.c.getClass();
            b = lm.k & (~(lm.i | lm.j));
        }

        @Override // defpackage.km
        public final int a() {
            return b;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends km {
        public static final b a = new b();

        @Override // defpackage.km
        public final int a() {
            return 0;
        }
    }

    public abstract int a();

    public final String toString() {
        return getClass().getSimpleName();
    }
}
