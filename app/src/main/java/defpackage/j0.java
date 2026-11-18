package defpackage;

import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class j0 implements ws0, xb0$b, w3 {
    public final Object a;

    public j0() {
        this.a = new ArrayList();
    }

    public j0(ViewPortHandler viewPortHandler) {
        this.a = viewPortHandler;
    }

    public j0(fc0 fc0Var) {
        if (fc0Var != null) {
            this.a = fc0Var;
        } else {
            b(0);
            throw null;
        }
    }

    public j0(s4 s4Var) {
        if (s4Var != null) {
            this.a = s4Var;
        } else {
            z(0);
            throw null;
        }
    }

    public static /* synthetic */ void b(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i == 1) {
            objArr[1] = "getType";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 1 && i != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static /* synthetic */ void z(int i) {
        String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 1 ? 3 : 2];
        if (i != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i != 1) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // defpackage.xb0$b
    public void a() {
        f((String[]) ((ArrayList) this.a).toArray(new String[0]));
    }

    @Override // defpackage.xb0$b
    public xb0$a b(dd ddVar) {
        return null;
    }

    @Override // defpackage.xb0$b
    public void c(Object obj) {
        if (obj instanceof String) {
            ((ArrayList) this.a).add((String) obj);
        }
    }

    @Override // defpackage.xb0$b
    public void d(dd ddVar, ij0 ij0Var) {
    }

    @Override // defpackage.xb0$b
    public void e(ed edVar) {
    }

    public abstract void f(String[] strArr);

    public s4 getAnnotations() {
        s4 s4Var = (s4) this.a;
        if (s4Var != null) {
            return s4Var;
        }
        z(1);
        throw null;
    }

    @Override // defpackage.ws0
    public fc0 getType() {
        fc0 fc0Var = (fc0) this.a;
        if (fc0Var != null) {
            return fc0Var;
        }
        b(1);
        throw null;
    }
}
