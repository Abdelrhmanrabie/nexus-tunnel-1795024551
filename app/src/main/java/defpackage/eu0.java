package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class eu0 extends zt0 {
    public final Object a;

    public eu0(Object obj) {
        this.a = obj;
    }

    @Override // defpackage.zt0
    public final Member O() throws IllegalAccessException, InvocationTargetException {
        g40$a g40_a = b2.f11a;
        Object obj = this.a;
        Method method = null;
        if (g40_a == null) {
            Class<?> cls = obj.getClass();
            try {
                g40_a = new g40$a(cls.getMethod("getType", null), cls.getMethod("getAccessor", null));
            } catch (NoSuchMethodException unused) {
                g40_a = new g40$a(null, null);
            }
            b2.f11a = g40_a;
        }
        Method method2 = g40_a.b;
        if (method2 != null) {
            Object objInvoke = method2.invoke(obj, null);
            if (objInvoke == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type java.lang.reflect.Method");
                return null;
            }
            method = (Method) objInvoke;
        }
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    public final fu0 getType() throws IllegalAccessException, InvocationTargetException {
        g40$a g40_a = b2.f11a;
        Object obj = this.a;
        Class cls = null;
        if (g40_a == null) {
            Class<?> cls2 = obj.getClass();
            try {
                g40_a = new g40$a(cls2.getMethod("getType", null), cls2.getMethod("getAccessor", null));
            } catch (NoSuchMethodException unused) {
                g40_a = new g40$a(null, null);
            }
            b2.f11a = g40_a;
        }
        Method method = g40_a.a;
        if (method != null) {
            Object objInvoke = method.invoke(obj, null);
            if (objInvoke == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type java.lang.Class<*>");
                return null;
            }
            cls = (Class) objInvoke;
        }
        if (cls != null) {
            return new tt0(cls);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }
}
