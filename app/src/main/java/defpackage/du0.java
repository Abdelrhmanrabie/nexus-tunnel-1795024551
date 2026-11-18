package defpackage;

import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class du0 extends fu0 {
    public final Class a;

    public du0(Class cls) {
        this.a = cls;
    }

    @Override // defpackage.fu0
    public final Type O() {
        return this.a;
    }

    @Override // defpackage.o40
    public final Collection getAnnotations() {
        return uq.b;
    }
}
