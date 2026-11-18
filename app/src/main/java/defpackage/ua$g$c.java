package defpackage;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ua$g$c extends ua.f implements g9 {
    public final Object f;

    /* JADX WARN: Illegal instructions before constructor call */
    public ua$g$c(Method method, Object obj) {
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        super(method, false, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : ae.A0(1, genericParameterTypes.length, genericParameterTypes)));
        this.f = obj;
    }

    @Override // ua.f, defpackage.ta
    public final Object call(Object[] objArr) {
        b2.a(this, objArr);
        o6 o6Var = new o6(2);
        o6Var.a(this.f);
        o6Var.b(objArr);
        return e(o6Var.f(new Object[o6Var.e()]), null);
    }
}
