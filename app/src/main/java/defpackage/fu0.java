package defpackage;

import java.lang.reflect.Type;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class fu0 implements o40 {
    public abstract Type O();

    @Override // defpackage.o40
    public ct0 c(cv cvVar) {
        Object next;
        Iterator it = getAnnotations().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (bt0.a(((sc) e.v(((ct0) next).a)).d()).b().equals(cvVar)) {
                return (ct0) next;
            }
        }
        next = null;
        return (ct0) next;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof fu0) && e4.a(O(), ((fu0) obj).O());
    }

    public final int hashCode() {
        return O().hashCode();
    }

    public final String toString() {
        return getClass().getName() + ": " + O();
    }
}
