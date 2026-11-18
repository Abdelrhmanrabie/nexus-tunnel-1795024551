package defpackage;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class tt0 extends fu0 {
    public final Type a;
    public final ui b;

    public tt0(Type type) {
        ui qt0Var;
        this.a = type;
        if (type instanceof Class) {
            qt0Var = new qt0((Class) type);
        } else if (type instanceof TypeVariable) {
            qt0Var = new gu0((TypeVariable) type);
        } else {
            if (!(type instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + type.getClass() + "): " + type);
            }
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type java.lang.Class<*>");
                throw null;
            }
            qt0Var = new qt0((Class) rawType);
        }
        this.b = qt0Var;
    }

    @Override // defpackage.fu0
    public final Type O() {
        return this.a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [b50, ui] */
    public final b50 b() {
        return this.b;
    }

    @Override // defpackage.fu0, defpackage.o40
    public final ct0 c(cv cvVar) {
        return null;
    }

    @Override // defpackage.o40
    public final Collection getAnnotations() {
        return uq.b;
    }

    public final boolean s() {
        Type type = this.a;
        return (type instanceof Class) && ((Class) type).getTypeParameters().length != 0;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0032  */
    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    public final ArrayList x() {
        fu0 ht0Var;
        fu0 du0Var;
        List<Type> listC = bt0.c(this.a);
        ArrayList arrayList = new ArrayList(ae.y0(listC));
        for (Type type : listC) {
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    du0Var = new du0(cls);
                } else {
                    if (!(type instanceof GenericArrayType) || (z && ((Class) type).isArray())) {
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
            arrayList.add(du0Var);
        }
        return arrayList;
    }
}
