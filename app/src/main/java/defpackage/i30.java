package defpackage;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class i30 implements ta {
    public final Method a;
    public final List b;
    public final Class c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends i30 implements g9 {
        public final Object d;

        public a(Method method, Object obj) {
            super(method, uq.b);
            this.d = obj;
        }

        @Override // defpackage.ta
        public final Object call(Object[] objArr) {
            b2.a(this, objArr);
            return this.a.invoke(this.d, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends i30 {
        @Override // defpackage.ta
        public final Object call(Object[] objArr) {
            b2.a(this, objArr);
            Object obj = objArr[0];
            Object[] objArrA0 = objArr.length <= 1 ? new Object[0] : ae.A0(1, objArr.length, objArr);
            return this.a.invoke(obj, Arrays.copyOf(objArrA0, objArrA0.length));
        }
    }

    public i30(Method method, List list) {
        this.a = method;
        this.b = list;
        this.c = method.getReturnType();
    }

    @Override // defpackage.ta
    public final List a() {
        return this.b;
    }

    @Override // defpackage.ta
    public final Type getReturnType() {
        return this.c;
    }
}
