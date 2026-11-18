package defpackage;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class cd {
    public static final Set c = Collections.singleton(dd.l(m21.a.c.h()));
    public final fn a;
    public final ff0.j b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final dd a;
        public final vc b;

        public a(dd ddVar, vc vcVar) {
            this.a = ddVar;
            this.b = vcVar;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                return e4.a(this.a, ((a) obj).a);
            }
            return false;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }
    }

    public cd(fn fnVar) {
        this.a = fnVar;
        this.b = fnVar.a.d(new i(1, this));
    }
}
