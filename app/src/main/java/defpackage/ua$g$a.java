package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ua$g$a extends ua.f implements g9 {
    public final Object f;

    public ua$g$a(Method method, Object obj) {
        super(method, false, 4);
        this.f = obj;
    }

    @Override // ua.f, defpackage.ta
    public final Object call(Object[] objArr) {
        b2.a(this, objArr);
        return e(objArr, this.f);
    }
}
