package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class j81 implements Serializable {
    public final Object b;
    public final Serializable c;
    public final Object d;

    public j81(Object obj, Serializable serializable, Object obj2) {
        this.b = obj;
        this.c = serializable;
        this.d = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j81)) {
            return false;
        }
        j81 j81Var = (j81) obj;
        return e4.a(this.b, j81Var.b) && e4.a(this.c, j81Var.c) && this.d.equals(j81Var.d);
    }

    public final int hashCode() {
        Object obj = this.b;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Serializable serializable = this.c;
        return this.d.hashCode() + ((iHashCode + (serializable != null ? serializable.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "(" + this.b + ", " + this.c + ", " + this.d + ')';
    }
}
