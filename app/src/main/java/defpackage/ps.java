package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ps {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Map a;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final b0 a;
        public final int b;

        public a(int i, b0 b0Var) {
            this.a = b0Var;
            this.b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }
    }

    static {
        new ps(0);
    }

    public ps() {
        this.a = new HashMap();
    }

    public ps(int i) {
        this.a = Collections.EMPTY_MAP;
    }

    public final void a(yx.e eVar) {
        this.a.put(new a(eVar.d.b, eVar.a), eVar);
    }
}
