package defpackage;

import androidx.lifecycle.t;
import java.io.PrintWriter;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ye0 extends xe0 {
    public final Object a;
    public final b b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends zd1 {
        public static final a b = new a();
        public final z11 a = new z11();

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class a implements t.b {
            @Override // androidx.lifecycle.t.b
            public final zd1 a(Class cls, xi0 xi0Var) {
                return new b();
            }

            @Override // androidx.lifecycle.t.b
            public final zd1 b(Class cls) {
                return new b();
            }
        }

        @Override // defpackage.zd1
        public final void onCleared() {
            z11 z11Var = this.a;
            if (z11Var.g() > 0) {
                z11Var.h(0).getClass();
                d.AnonymousClass0.m$1();
                return;
            }
            int i = z11Var.f;
            Object[] objArr = z11Var.d;
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = null;
            }
            z11Var.f = 0;
            z11Var.b = false;
        }
    }

    public ye0(he0 he0Var, be1 be1Var) {
        this.a = he0Var;
        this.b = (b) new t(be1Var, b.b).a(b.class);
    }

    public final void b(String str, PrintWriter printWriter) {
        z11 z11Var = this.b.a;
        if (z11Var.g() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            if (z11Var.g() <= 0) {
                return;
            }
            if (z11Var.h(0) != null) {
                d.AnonymousClass0.m$1();
                return;
            }
            printWriter.print(str);
            printWriter.print("  #");
            if (z11Var.b) {
                z11Var.d();
            }
            printWriter.print(z11Var.c[0]);
            printWriter.print(": ");
            throw null;
        }
    }

    public final String toString() {
        int iLastIndexOf;
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.a;
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}}");
        return sb.toString();
    }
}
