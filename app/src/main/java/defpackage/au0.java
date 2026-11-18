package defpackage;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class au0 extends zt0 implements r60 {
    public final Method a;

    public au0(Method method) {
        this.a = method;
    }

    public final fu0 C() {
        Type genericReturnType = this.a.getGenericReturnType();
        boolean z = genericReturnType instanceof Class;
        if (z) {
            Class cls = (Class) genericReturnType;
            if (cls.isPrimitive()) {
                return new du0(cls);
            }
        }
        if ((genericReturnType instanceof GenericArrayType) || (z && ((Class) genericReturnType).isArray())) {
            return new ht0(genericReturnType);
        }
        return genericReturnType instanceof WildcardType ? new iu0((WildcardType) genericReturnType) : new tt0(genericReturnType);
    }

    @Override // defpackage.zt0
    public final Member O() {
        return this.a;
    }

    public final List f() {
        Method method = this.a;
        return P(method.getGenericParameterTypes(), method.getParameterAnnotations(), method.isVarArgs());
    }

    @Override // defpackage.r60
    public final ArrayList getTypeParameters() {
        TypeVariable<Method>[] typeParameters = this.a.getTypeParameters();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        int length = typeParameters.length;
        int i = 0;
        while (i < length) {
            TypeVariable<Method> typeVariable = typeParameters[i];
            i++;
            arrayList.add(new gu0(typeVariable));
        }
        return arrayList;
    }
}
