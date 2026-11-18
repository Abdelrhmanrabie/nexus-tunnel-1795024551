package defpackage;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class iu0 extends fu0 {
    public final WildcardType a;

    public iu0(WildcardType wildcardType) {
        this.a = wildcardType;
    }

    @Override // defpackage.fu0
    public final Type O() {
        return this.a;
    }

    @Override // defpackage.o40
    public final Collection getAnnotations() {
        return uq.b;
    }

    public final fu0 p() {
        WildcardType wildcardType = this.a;
        Type[] upperBounds = wildcardType.getUpperBounds();
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException(e4.j("Wildcard types with many bounds are not yet supported: ", wildcardType));
        }
        if (lowerBounds.length == 1) {
            Type type = (Type) ae.L0(lowerBounds);
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new du0(cls);
                }
            }
            if ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) {
                return new ht0(type);
            }
            return type instanceof WildcardType ? new iu0((WildcardType) type) : new tt0(type);
        }
        if (upperBounds.length != 1) {
            return null;
        }
        Type type2 = (Type) ae.L0(upperBounds);
        if (e4.a(type2, Object.class)) {
            return null;
        }
        boolean z2 = type2 instanceof Class;
        if (z2) {
            Class cls2 = (Class) type2;
            if (cls2.isPrimitive()) {
                return new du0(cls2);
            }
        }
        if ((type2 instanceof GenericArrayType) || (z2 && ((Class) type2).isArray())) {
            return new ht0(type2);
        }
        return type2 instanceof WildcardType ? new iu0((WildcardType) type2) : new tt0(type2);
    }
}
