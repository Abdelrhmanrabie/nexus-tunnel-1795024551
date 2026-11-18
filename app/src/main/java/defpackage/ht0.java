package defpackage;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ht0 extends fu0 {
    public final Type a;
    public final fu0 b;
    public final uq c;

    /* JADX WARN: Multi-variable type inference failed */
    public ht0(Type type) {
        fu0 du0Var;
        fu0 du0Var2;
        this.a = type;
        if (!(type instanceof GenericArrayType)) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    du0Var = componentType.isPrimitive() ? new du0(componentType) : ((componentType instanceof GenericArrayType) || componentType.isArray()) ? new ht0(componentType) : componentType instanceof WildcardType ? new iu0((WildcardType) componentType) : new tt0(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + type.getClass() + "): " + type);
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        boolean z = genericComponentType instanceof Class;
        if (z) {
            Class cls2 = (Class) genericComponentType;
            du0Var2 = cls2.isPrimitive() ? new du0(cls2) : du0Var2;
            this.b = du0Var2;
            this.c = uq.b;
        }
        du0Var = ((genericComponentType instanceof GenericArrayType) || (z && ((Class) genericComponentType).isArray())) ? new ht0(genericComponentType) : genericComponentType instanceof WildcardType ? new iu0((WildcardType) genericComponentType) : new tt0(genericComponentType);
        du0Var2 = du0Var;
        this.b = du0Var2;
        this.c = uq.b;
    }

    @Override // defpackage.fu0
    public final Type O() {
        return this.a;
    }

    @Override // defpackage.o40
    public final Collection getAnnotations() {
        return this.c;
    }
}
