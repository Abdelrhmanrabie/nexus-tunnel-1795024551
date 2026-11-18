package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class y00 extends oi implements ol {
    public final Handler d;
    public final boolean g;
    public final y00 i;

    public y00(Handler handler, boolean z) {
        this.d = handler;
        this.g = z;
        this.i = z ? this : new y00(handler, true);
    }

    @Override // defpackage.oi
    public final boolean A() {
        return (this.g && e4.a(Looper.myLooper(), this.d.getLooper())) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof y00)) {
            return false;
        }
        y00 y00Var = (y00) obj;
        return y00Var.d == this.d && y00Var.g == this.g;
    }

    public final int hashCode() {
        return System.identityHashCode(this.d) ^ (this.g ? 1231 : 1237);
    }

    @Override // defpackage.oi
    public final String toString() {
        y00 y00Var;
        String str;
        hl hlVar = uo.a;
        y00 y00Var2 = yf0.a;
        if (this == y00Var2) {
            str = "Dispatchers.Main";
        } else {
            try {
                y00Var = y00Var2.i;
            } catch (UnsupportedOperationException unused) {
                y00Var = null;
            }
            str = this == y00Var ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.d.toString();
        return this.g ? ak.j(string, ".immediate") : string;
    }

    @Override // defpackage.oi
    public final void x(li liVar, Runnable runnable) {
        if (this.d.post(runnable)) {
            return;
        }
        e.z0(liVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        uo.b.x(liVar, runnable);
    }
}
