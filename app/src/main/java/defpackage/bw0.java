package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class bw0 implements Serializable {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Serializable {
        public final Throwable b;

        public a(Throwable th) {
            this.b = th;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.b.equals(((a) obj).b);
            }
            return false;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.b + ')';
        }
    }

    public static final Throwable a(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).b;
        }
        return null;
    }
}
