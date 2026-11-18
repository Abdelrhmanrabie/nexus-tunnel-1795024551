package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d70 extends CancellationException {
    public final transient h70 b;

    public d70(String str, Throwable th, h70 h70Var) {
        super(str);
        this.b = h70Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d70)) {
            return false;
        }
        d70 d70Var = (d70) obj;
        return e4.a(d70Var.getMessage(), getMessage()) && e4.a(d70Var.b, this.b) && e4.a(d70Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (getMessage().hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.b;
    }
}
