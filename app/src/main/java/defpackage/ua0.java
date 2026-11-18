package defpackage;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ua0 extends oc0 implements lw {
    public final /* synthetic */ wa0 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua0(wa0 wa0Var, int i, rc0 rc0Var) {
        super(0);
        this.b = wa0Var;
        this.c = i;
        this.d = rc0Var;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, rc0] */
    @Override // defpackage.lw
    public final Object invoke() {
        wa0 wa0Var = this.b;
        nu0$a nu0_a = wa0Var.c;
        Type type = nu0_a == null ? null : (Type) nu0_a.invoke();
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? cls.getComponentType() : Object.class;
        }
        boolean z = type instanceof GenericArrayType;
        int i = this.c;
        if (z) {
            if (i == 0) {
                return ((GenericArrayType) type).getGenericComponentType();
            }
            throw new yi(e4.j("Array type has been queried for a non-0th argument: ", wa0Var));
        }
        if (!(type instanceof ParameterizedType)) {
            throw new yi(e4.j("Non-generic type has been queried for arguments: ", wa0Var));
        }
        Type type2 = (Type) ((List) this.d.getValue()).get(i);
        if (!(type2 instanceof WildcardType)) {
            return type2;
        }
        WildcardType wildcardType = (WildcardType) type2;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Type type3 = lowerBounds.length != 0 ? lowerBounds[0] : null;
        return type3 == null ? (Type) ae.E0(wildcardType.getUpperBounds()) : type3;
    }
}
