package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class eg0 implements Serializable {
    public final String b;
    public final Object c;

    public eg0(String str, Object obj) {
        this.b = str;
        this.c = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof eg0)) {
            return false;
        }
        eg0 eg0Var = (eg0) obj;
        return this.b.equals(eg0Var.b) && this.c.equals(eg0Var.c);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ this.c.hashCode();
    }

    public final String toString() {
        return ((Object) this.b) + "=" + this.c;
    }
}
