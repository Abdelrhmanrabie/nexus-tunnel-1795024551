package defpackage;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class z81 {
    public final boolean a;
    public final boolean b;
    public final ld c;
    public final kc0$a d;
    public final lc0$a e;
    public int f;
    public ArrayDeque g;
    public o11 h;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends v3 {
        public static final b a = new b(0);
        public static final b a$1 = new b(1);
        public static final b a$2 = new b(2);
        public final /* synthetic */ int G0;

        public /* synthetic */ b(int i) {
            this.G0 = i;
        }

        @Override // defpackage.v3
        public final w01 a(z81 z81Var, jc0 jc0Var) {
            int i = this.G0;
            if (i == 0) {
                return z81Var.c.V(jc0Var);
            }
            if (i != 1) {
                return z81Var.c.z(jc0Var);
            }
            throw new UnsupportedOperationException("Should not be called");
        }
    }

    public z81(boolean z, boolean z2, ld ldVar, kc0$a kc0_a, lc0$a lc0_a) {
        this.a = z;
        this.b = z2;
        this.c = ldVar;
        this.d = kc0_a;
        this.e = lc0_a;
    }

    public final void a() {
        this.g.clear();
        this.h.clear();
    }

    public final void b() {
        if (this.g == null) {
            this.g = new ArrayDeque(4);
        }
        if (this.h == null) {
            this.h = new o11();
        }
    }
}
