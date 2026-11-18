package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class zt0 extends ui implements ft0, bu0, o40 {
    public abstract Member O();

    /* JADX WARN: Code duplicated, block: B:46:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c7  */
    public final ArrayList P(Type[] typeArr, Annotation[][] annotationArr, boolean z) throws IllegalAccessException, InvocationTargetException {
        ArrayList arrayList;
        fu0 ht0Var;
        fu0 du0Var;
        String str;
        Method method;
        String str2;
        g40$a g40_a;
        ArrayList arrayList2 = new ArrayList(typeArr.length);
        ke keVar = ke.a$1;
        Member memberO = O();
        g40$a g40_a2 = ke.b;
        if (g40_a2 == null) {
            synchronized (keVar) {
                try {
                    g40_a2 = ke.b;
                    if (g40_a2 == null) {
                        Class<?> cls = memberO.getClass();
                        try {
                            Method method2 = cls.getMethod("getParameters", null);
                            List list = bt0.a;
                            ClassLoader classLoader = cls.getClassLoader();
                            if (classLoader == null) {
                                classLoader = ClassLoader.getSystemClassLoader();
                            }
                            g40_a = new g40$a(method2, classLoader.loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
                        } catch (NoSuchMethodException unused) {
                            g40_a = new g40$a(null, null);
                        }
                        ke.b = g40_a;
                        g40_a2 = g40_a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        Method method3 = g40_a2.a;
        if (method3 != null && (method = g40_a2.b) != null) {
            Object objInvoke = method3.invoke(memberO, null);
            if (objInvoke != null) {
                Object[] objArr = (Object[]) objInvoke;
                arrayList = new ArrayList(objArr.length);
                int length = objArr.length;
                int i = 0;
                while (i < length) {
                    Object obj = objArr[i];
                    i++;
                    Object objInvoke2 = method.invoke(obj, null);
                    if (objInvoke2 != null) {
                        arrayList.add((String) objInvoke2);
                    } else {
                        str2 = "null cannot be cast to non-null type kotlin.String";
                    }
                }
            } else {
                str2 = "null cannot be cast to non-null type kotlin.Array<*>";
            }
            d.AnonymousClass0.m$1(str2);
            return null;
        }
        arrayList = null;
        int size = arrayList == null ? 0 : arrayList.size() - typeArr.length;
        int length2 = typeArr.length;
        int i2 = 0;
        while (i2 < length2) {
            int i3 = i2 + 1;
            Type type = typeArr[i2];
            boolean z2 = type instanceof Class;
            if (z2) {
                Class cls2 = (Class) type;
                if (cls2.isPrimitive()) {
                    du0Var = new du0(cls2);
                } else {
                    if (!(type instanceof GenericArrayType) || (z2 && ((Class) type).isArray())) {
                        ht0Var = new ht0(type);
                    } else {
                        ht0Var = type instanceof WildcardType ? new iu0((WildcardType) type) : new tt0(type);
                    }
                    du0Var = ht0Var;
                }
            } else {
                if (type instanceof GenericArrayType) {
                    ht0Var = new ht0(type);
                } else {
                    ht0Var = new ht0(type);
                }
                du0Var = ht0Var;
            }
            if (arrayList == null) {
                str = null;
            } else {
                str = (String) he.N0(arrayList, i2 + size);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i2 + '+' + size + " (name=" + getName() + " type=" + du0Var + ") in " + this).toString());
                }
            }
            arrayList2.add(new hu0(du0Var, annotationArr[i2], str, z && i2 == typeArr.length + (-1)));
            i2 = i3;
        }
        return arrayList2;
    }

    @Override // defpackage.o40
    public final ct0 c(cv cvVar) {
        Annotation[] declaredAnnotations;
        AnnotatedElement element = getElement();
        if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
            return null;
        }
        return e.N0(declaredAnnotations, cvVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zt0) && e4.a(O(), ((zt0) obj).O());
    }

    @Override // defpackage.o40
    public final Collection getAnnotations() {
        return e4.b((ft0) this);
    }

    @Override // defpackage.ft0
    public final AnnotatedElement getElement() {
        return (AnnotatedElement) O();
    }

    @Override // defpackage.bu0
    public final int getModifiers() {
        return O().getModifiers();
    }

    public final ij0 getName() {
        String name = O().getName();
        return name == null ? f21.a : ij0.f(name);
    }

    public final int hashCode() {
        return O().hashCode();
    }

    public final String toString() {
        return getClass().getName() + ": " + O();
    }
}
