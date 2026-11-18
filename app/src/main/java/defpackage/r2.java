package defpackage;

import java.util.Collections;
import java.util.ServiceLoader;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class r2 extends oc0 implements lw {
    public static final r2 b;
    public static final r2 b$1;
    public static final r2 b$2;
    public static final r2 b$3;
    public static final r2 b$4;
    public final /* synthetic */ int G0;

    static {
        int i = 0;
        b$1 = new r2(i, 2);
        b$2 = new r2(i, 3);
        b = new r2(i, i);
        b$3 = new r2(i, 4);
        b$4 = new r2(i, 5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r2(int i, int i2) {
        super(i);
        this.G0 = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r2(c30 c30Var) {
        super(0);
        this.G0 = 1;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        if (i == 0) {
            return Integer.valueOf(h0.c.b().nextInt(2147418112) + 65536);
        }
        if (i == 1) {
            throw null;
        }
        if (i == 2) {
            return Collections.singletonMap(n40.a, new h31("Deprecated in Java"));
        }
        if (i == 3) {
            return Object.class;
        }
        if (i != 4) {
            return uq.b;
        }
        s9 s9Var = (s9) he.L0(ServiceLoader.load(s9.class, s9.class.getClassLoader()));
        if (s9Var != null) {
            return s9Var;
        }
        d.AnonymousClass0.m("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
        return null;
    }
}
