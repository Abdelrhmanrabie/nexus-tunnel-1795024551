package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ct0 extends ui {
    public final Annotation a;

    public ct0(Annotation annotation) {
        this.a = annotation;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ct0) {
            return e4.a(this.a, ((ct0) obj).a);
        }
        return false;
    }

    public final ArrayList g() throws IllegalAccessException, InvocationTargetException {
        dt0 st0Var;
        Annotation annotation = this.a;
        Method[] declaredMethods = ((sc) e.v(annotation)).d().getDeclaredMethods();
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            i++;
            Object objInvoke = method.invoke(annotation, null);
            ij0 ij0VarF = ij0.f(method.getName());
            Class<?> cls = objInvoke.getClass();
            List list = bt0.a;
            if (Enum.class.isAssignableFrom(cls)) {
                st0Var = new wt0(ij0VarF, (Enum) objInvoke);
            } else if (objInvoke instanceof Annotation) {
                st0Var = new et0(ij0VarF, (Annotation) objInvoke);
            } else if (objInvoke instanceof Object[]) {
                st0Var = new gt0(ij0VarF, (Object[]) objInvoke);
            } else {
                st0Var = objInvoke instanceof Class ? new st0(ij0VarF, (Class) objInvoke) : new yt0(objInvoke, ij0VarF);
            }
            arrayList.add(st0Var);
        }
        return arrayList;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return ct0.class.getName() + ": " + this.a;
    }
}
