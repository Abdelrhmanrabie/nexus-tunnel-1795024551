package defpackage;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class j51 {
    public int a;
    public Object b;
    public int c;
    public int d;

    public j51() {
        if (e.n == null) {
            e.n = new e(4);
        }
    }

    public j51(int i, Class cls, int i2, int i3) {
        this.a = i;
        this.b = cls;
        this.d = i2;
        this.c = i3;
    }

    public int a(int i) {
        if (i < this.d) {
            return ((ByteBuffer) this.b).getShort(this.c + i);
        }
        return 0;
    }

    public void a() {
        if (((zf0) this.b).n != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object b(View view);

    public void b$1() {
        while (true) {
            int i = this.a;
            zf0 zf0Var = (zf0) this.b;
            if (i >= zf0Var.i || zf0Var.d[i] >= 0) {
                return;
            } else {
                this.a = i + 1;
            }
        }
    }

    public abstract void c(View view, Object obj);

    public void e(View view, Object obj) {
        Object tag;
        int i = this.a;
        int i2 = Build.VERSION.SDK_INT;
        int i3 = this.c;
        if (i2 >= i3) {
            c(view, obj);
            return;
        }
        a1 a1Var = null;
        if (i2 >= i3) {
            tag = b(view);
        } else {
            tag = view.getTag(i);
            if (!((Class) this.b).isInstance(tag)) {
                tag = null;
            }
        }
        if (f(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateD = qd1.d(view);
            if (accessibilityDelegateD != null) {
                a1Var = accessibilityDelegateD instanceof a1.a ? ((a1.a) accessibilityDelegateD).a : new a1(accessibilityDelegateD);
            }
            if (a1Var == null) {
                a1Var = new a1();
            }
            qd1.l(view, a1Var);
            view.setTag(i, obj);
            qd1.g(view, this.d);
        }
    }

    public abstract boolean f(Object obj, Object obj2);

    public boolean hasNext() {
        return this.a < ((zf0) this.b).i;
    }

    public void remove() {
        a();
        if (this.c == -1) {
            d.AnonymousClass0.m("Call next() before removing element from the iterator.");
            return;
        }
        zf0 zf0Var = (zf0) this.b;
        zf0Var.b$1();
        zf0Var.m(this.c);
        this.c = -1;
        this.d = zf0Var.n;
    }
}
