package defpackage;

import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class e5 {
    public static int b = -100;
    public static final g7 c = new g7(0);
    public static final Object d = new Object();

    public static void s(f5 f5Var) {
        synchronized (d) {
            try {
                Iterator it = c.iterator();
                while (true) {
                    dg0.a aVar = (dg0.a) it;
                    if (aVar.hasNext()) {
                        e5 e5Var = (e5) ((WeakReference) aVar.next()).get();
                        if (e5Var == f5Var || e5Var == null) {
                            aVar.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void x(int i) {
        if ((i == -1 || i == 0 || i == 1 || i == 2 || i == 3) && b != i) {
            b = i;
            synchronized (d) {
                try {
                    Iterator it = c.iterator();
                    while (true) {
                        dg0.a aVar = (dg0.a) it;
                        if (aVar.hasNext()) {
                            e5 e5Var = (e5) ((WeakReference) aVar.next()).get();
                            if (e5Var != null) {
                                ((f5) e5Var).C(true);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public abstract void A(CharSequence charSequence);

    public abstract y1 B(y1.a aVar);

    public abstract void j();

    public abstract void l();

    public abstract void m();

    public abstract boolean t(int i);

    public abstract void u(int i);
}
