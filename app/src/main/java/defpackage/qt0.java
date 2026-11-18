package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qt0 extends ui implements ft0, bu0, b50, r60 {
    public final Class a;

    public qt0(Class cls) {
        this.a = cls;
    }

    public final List A() {
        return fz0.E(new c81(fz0.y(ae.B0(this.a.getDeclaredMethods()), new i(8, this)), pt0.d));
    }

    @Override // defpackage.o40
    public final ct0 c(cv cvVar) {
        Annotation[] declaredAnnotations;
        AnnotatedElement element = getElement();
        if (element == null || (declaredAnnotations = ((Class) element).getDeclaredAnnotations()) == null) {
            return null;
        }
        return e.N0(declaredAnnotations, cvVar);
    }

    public final cv e() {
        return bt0.a(this.a).b();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof qt0) {
            return e4.a(this.a, ((qt0) obj).a);
        }
        return false;
    }

    @Override // defpackage.o40
    public final Collection getAnnotations() {
        return e4.b((ft0) this);
    }

    @Override // defpackage.ft0
    public final AnnotatedElement getElement() {
        return this.a;
    }

    public final List getFields() {
        return fz0.E(new c81(new ht(ae.B0(this.a.getDeclaredFields()), false, kt0.d), lt0.d));
    }

    @Override // defpackage.bu0
    public final int getModifiers() {
        return this.a.getModifiers();
    }

    @Override // defpackage.r60
    public final ArrayList getTypeParameters() {
        TypeVariable[] typeParameters = this.a.getTypeParameters();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        int length = typeParameters.length;
        int i = 0;
        while (i < length) {
            TypeVariable typeVariable = typeParameters[i];
            i++;
            arrayList.add(new gu0(typeVariable));
        }
        return arrayList;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final ArrayList k() {
        oo ooVar = e4.f46a;
        Object[] objArr = null;
        if (ooVar == null) {
            try {
                ooVar = new oo(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
            } catch (NoSuchMethodException unused) {
                ooVar = new oo(objArr, objArr, objArr, objArr);
            }
            e4.f46a = ooVar;
        }
        Method method = (Method) ooVar.d;
        objArr = method != null ? (Object[]) method.invoke(this.a, null) : null;
        int i = 0;
        if (objArr == null) {
            objArr = new Object[0];
        }
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            arrayList.add(new eu0(obj));
        }
        return arrayList;
    }

    public final boolean o() throws IllegalAccessException, InvocationTargetException {
        oo ooVar = e4.f46a;
        Boolean bool = null;
        if (ooVar == null) {
            try {
                ooVar = new oo(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
            } catch (NoSuchMethodException unused) {
                ooVar = new oo(bool, bool, bool, bool);
            }
            e4.f46a = ooVar;
        }
        Method method = (Method) ooVar.c;
        if (method != null) {
            Object objInvoke = method.invoke(this.a, null);
            if (objInvoke == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type kotlin.Boolean");
                return false;
            }
            bool = (Boolean) objInvoke;
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final String toString() {
        return qt0.class.getName() + ": " + this.a;
    }

    public final boolean w() throws IllegalAccessException, InvocationTargetException {
        oo ooVar = e4.f46a;
        Boolean bool = null;
        if (ooVar == null) {
            try {
                ooVar = new oo(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
            } catch (NoSuchMethodException unused) {
                ooVar = new oo(bool, bool, bool, bool);
            }
            e4.f46a = ooVar;
        }
        Method method = (Method) ooVar.a;
        if (method != null) {
            Object objInvoke = method.invoke(this.a, null);
            if (objInvoke == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type kotlin.Boolean");
                return false;
            }
            bool = (Boolean) objInvoke;
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
