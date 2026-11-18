package defpackage;

import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class o80$b extends e4 {
    public final Constructor a;

    public o80$b(Constructor constructor) {
        this.a = constructor;
    }

    @Override // defpackage.e4
    public final String a() {
        return ae.J0(this.a.getParameterTypes(), "<init>(", ")V", ld0.b$25);
    }
}
