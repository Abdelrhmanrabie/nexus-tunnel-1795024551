package androidx.fragment.app;

import defpackage.o01;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class o {
    public static final o01 a = new o01();

    public static Class b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        o01 o01Var = a;
        o01 o01Var2 = (o01) o01Var.getOrDefault(classLoader, null);
        if (o01Var2 == null) {
            o01Var2 = new o01();
            o01Var.put(classLoader, o01Var2);
        }
        Class cls = (Class) o01Var2.getOrDefault(str, null);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        o01Var2.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment.k(defpackage.e.n("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.k(defpackage.e.n("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }

    public Fragment a(String str) {
        throw null;
    }
}
