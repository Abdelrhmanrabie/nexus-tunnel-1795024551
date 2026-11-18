package defpackage;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class p90 implements sc {
    public static final vu0 b = new vu0("<v#(\\d+)>");

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class a {
        public static final /* synthetic */ ja0[] b;
        public final nu0$a a;

        static {
            pu0 pu0Var = ou0.a;
            b = new ja0[]{pu0Var.f(new tq0(pu0Var.b(a.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        }

        public a(p90 p90Var) {
            this.a = ak.c(new ca0(15, p90Var));
        }
    }

    public static Method r(Class cls, String str, Class[] clsArr, Class cls2) {
        Method methodR;
        Class superclass;
        int i = 0;
        try {
            methodR = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (!e4.a(methodR.getReturnType(), cls2)) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        methodR = null;
                        break;
                    }
                    Method method = declaredMethods[i2];
                    i2++;
                    if (e4.a(method.getName(), str) && e4.a(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                        methodR = method;
                        break;
                    }
                }
            }
        } catch (NoSuchMethodException unused) {
        }
        if (methodR != null || ((superclass = cls.getSuperclass()) != null && (methodR = r(superclass, str, clsArr, cls2)) != null)) {
            return methodR;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        int length2 = interfaces.length;
        while (i < length2) {
            Class<?> cls3 = interfaces[i];
            i++;
            Method methodR2 = r(cls3, str, clsArr, cls2);
            if (methodR2 != null) {
                return methodR2;
            }
        }
        return null;
    }

    public final Method i(String str, String str2) {
        Method methodR;
        if (!e4.a(str, "<init>")) {
            Object[] array = q(str2).toArray(new Class[0]);
            if (array == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                return null;
            }
            Class[] clsArr = (Class[]) array;
            Class clsS = s(q31.j0(str2, ')', 0, 6) + 1, str2.length(), str2);
            Method methodR2 = r(o(), str, clsArr, clsS);
            if (methodR2 != null) {
                return methodR2;
            }
            if (o().isInterface() && (methodR = r(Object.class, str, clsArr, clsS)) != null) {
                return methodR;
            }
        }
        return null;
    }

    public abstract Collection k();

    public abstract Collection l(ij0 ij0Var);

    public abstract nq0 m(int i);

    /* JADX WARN: Code duplicated, block: B:18:0x0054  */
    public final List n(vg0 vg0Var, int i) {
        b90 b90Var;
        ak.r(i, "belonginess");
        t90 t90Var = new t90(0, this);
        Collection<ok> collectionA = b2.a(vg0Var, (lm) null, 3);
        ArrayList arrayList = new ArrayList();
        for (ok okVar : collectionA) {
            if (okVar instanceof la) {
                la laVar = (la) okVar;
                if (e4.a(laVar.getVisibility(), cn.h)) {
                    b90Var = null;
                } else if ((laVar.getKind() != la.a.c) == (i == 1)) {
                    b90Var = (b90) okVar.r0(t90Var, tb1.a);
                } else {
                    b90Var = null;
                }
            } else {
                b90Var = null;
            }
            if (b90Var != null) {
                arrayList.add(b90Var);
            }
        }
        return he.g1(arrayList);
    }

    public Class o() {
        Class cls = (Class) bt0.c.get(d());
        return cls == null ? d() : cls;
    }

    public abstract Collection p(ij0 ij0Var);

    public final ArrayList q(String str) {
        int iJ0;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (str.charAt(i) != ')') {
            int i2 = i;
            while (str.charAt(i2) == '[') {
                i2++;
            }
            char cCharAt = str.charAt(i2);
            if (q31.d0("VZCBSIFJD", cCharAt)) {
                iJ0 = i2 + 1;
            } else {
                if (cCharAt != 'L') {
                    throw new yi(e4.j("Unknown type prefix in the method signature: ", str));
                }
                iJ0 = q31.j0(str, ';', i, 4) + 1;
            }
            arrayList.add(s(i, iJ0, str));
            i = iJ0;
        }
        return arrayList;
    }

    public final Class s(int i, int i2, String str) {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'L') {
            Class clsD = d();
            List list = bt0.a;
            ClassLoader classLoader = clsD.getClassLoader();
            if (classLoader == null) {
                classLoader = ClassLoader.getSystemClassLoader();
            }
            return classLoader.loadClass(str.substring(i + 1, i2 - 1).replace('/', '.'));
        }
        if (cCharAt == '[') {
            Class clsS = s(i + 1, i2, str);
            cv cvVar = lc1.a;
            return Array.newInstance((Class<?>) clsS, 0).getClass();
        }
        if (cCharAt == 'V') {
            return Void.TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == 'C') {
            return Character.TYPE;
        }
        if (cCharAt == 'B') {
            return Byte.TYPE;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'D') {
            return Double.TYPE;
        }
        throw new yi(e4.j("Unknown type prefix in the method signature: ", str));
    }
}
