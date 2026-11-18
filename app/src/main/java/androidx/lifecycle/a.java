package androidx.lifecycle;

import defpackage.he0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a c = new a();
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();

    /* JADX INFO: renamed from: androidx.lifecycle.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class C0014a {
        public final HashMap a = new HashMap();
        public final HashMap b;

        public C0014a(HashMap map) {
            this.b = map;
            for (Map.Entry entry : map.entrySet()) {
                e.a aVar = (e.a) entry.getValue();
                List arrayList = (List) this.a.get(aVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.a.put(aVar, arrayList);
                }
                arrayList.add((b) entry.getKey());
            }
        }

        public static void a(List list, he0 he0Var, e.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    b bVar = (b) list.get(size);
                    bVar.getClass();
                    try {
                        int i = bVar.a;
                        Method method = bVar.b;
                        if (i == 0) {
                            method.invoke(obj, null);
                        } else if (i == 1) {
                            method.invoke(obj, he0Var);
                        } else if (i == 2) {
                            method.invoke(obj, he0Var, aVar);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to call observer method", e2.getCause());
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class b {
        public final int a;
        public final Method b;

        public b(Method method, int i) {
            this.a = i;
            this.b = method;
            method.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b.getName().equals(bVar.b.getName());
        }

        public final int hashCode() {
            return this.b.getName().hashCode() + (this.a * 31);
        }
    }

    public static void c(HashMap map, b bVar, e.a aVar, Class cls) {
        e.a aVar2 = (e.a) map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009e  */
    /* JADX WARN: Code duplicated, block: B:53:0x00aa A[SYNTHETIC] */
    public final C0014a a(Class cls, Method[] methodArr) {
        int i;
        String str;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null) {
            map.putAll(b(superclass).b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : b(cls2).b.entrySet()) {
                c(map, (b) entry.getKey(), (e.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            j jVar = (j) method.getAnnotation(j.class);
            if (jVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    if (he0.class.isAssignableFrom(parameterTypes[0])) {
                        i = 1;
                    } else {
                        str = "invalid parameter type. Must be one and instanceof LifecycleOwner";
                    }
                    defpackage.d.AnonymousClass0.m$2(str);
                    return null;
                }
                i = 0;
                e.a aVarValue = jVar.value();
                if (parameterTypes.length <= 1) {
                    if (parameterTypes.length <= 2) {
                        c(map, new b(method, i), aVarValue, cls);
                        z = true;
                    } else {
                        str = "cannot have more than 2 params";
                    }
                } else if (!e.a.class.isAssignableFrom(parameterTypes[1])) {
                    str = "invalid parameter type. second arg must be an event";
                } else if (aVarValue == e.a.ON_ANY) {
                    i = 2;
                    if (parameterTypes.length <= 2) {
                        c(map, new b(method, i), aVarValue, cls);
                        z = true;
                    } else {
                        str = "cannot have more than 2 params";
                    }
                } else {
                    str = "Second arg is supported only for ON_ANY value";
                }
                defpackage.d.AnonymousClass0.m$2(str);
                return null;
            }
        }
        C0014a c0014a = new C0014a(map);
        this.a.put(cls, c0014a);
        this.b.put(cls, Boolean.valueOf(z));
        return c0014a;
    }

    public final C0014a b(Class cls) {
        C0014a c0014a = (C0014a) this.a.get(cls);
        return c0014a != null ? c0014a : a(cls, null);
    }
}
