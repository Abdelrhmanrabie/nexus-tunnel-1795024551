package defpackage;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class v40 extends uc implements t40 {
    public Boolean K;
    public Boolean L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v40(ai0 ai0Var, v40 v40Var, s4 s4Var, boolean z, la.a aVar, t11 t11Var) {
        super(ai0Var, v40Var, s4Var, z, aVar, t11Var);
        if (ai0Var == null) {
            z(0);
            throw null;
        }
        if (s4Var == null) {
            z(1);
            throw null;
        }
        if (aVar == null) {
            z(2);
            throw null;
        }
        this.K = null;
        this.L = null;
    }

    public static v40 X0(ai0 ai0Var, s4 s4Var, boolean z, tw0$a tw0_a) {
        if (ai0Var != null) {
            return new v40(ai0Var, null, s4Var, z, la.a.b, tw0_a);
        }
        z(4);
        throw null;
    }

    public static /* synthetic */ void z(int i) {
        String str = (i == 11 || i == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 11 || i == 18) ? 2 : 3];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 11 && i != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // defpackage.uc, defpackage.rx
    public final /* bridge */ /* synthetic */ rx K0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var, ij0 ij0Var) {
        return T0(aVar, okVar, oxVar, t11Var, s4Var);
    }

    @Override // defpackage.rx
    public final void Q0(boolean z) {
        this.K = Boolean.valueOf(z);
    }

    @Override // defpackage.rx
    public final void R0(boolean z) {
        this.L = Boolean.valueOf(z);
    }

    @Override // defpackage.uc
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public final v40 T0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var) {
        if (okVar == null) {
            z(7);
            throw null;
        }
        if (aVar == null) {
            z(8);
            throw null;
        }
        if (s4Var == null) {
            z(9);
            throw null;
        }
        if (aVar != la.a.b && aVar != la.a.f) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + okVar + "\nkind: " + aVar);
        }
        v40 v40Var = new v40((ai0) okVar, (v40) oxVar, s4Var, this.J, aVar, t11Var);
        Boolean bool = this.K;
        bool.getClass();
        v40Var.K = bool;
        Boolean bool2 = this.L;
        bool2.getClass();
        v40Var.L = bool2;
        return v40Var;
    }

    @Override // defpackage.t40
    public final t40 a0(fc0 fc0Var, ArrayList arrayList, fc0 fc0Var2, jo0 jo0Var) {
        if (fc0Var2 == null) {
            z(17);
            throw null;
        }
        v40 v40VarT0 = T0(getKind(), U0(), null, g(), getAnnotations());
        v40VarT0.N0(fc0Var != null ? b2.f(v40VarT0, fc0Var, e4.f47a) : null, this.o, getTypeParameters(), e.I0(arrayList, f(), v40VarT0), fc0Var2, p(), getVisibility());
        if (jo0Var != null) {
            fm$a fm_a = (fm$a) jo0Var.b;
            Object obj = jo0Var.c;
            if (v40VarT0.I == null) {
                v40VarT0.I = new LinkedHashMap();
            }
            v40VarT0.I.put(fm_a, obj);
        }
        return v40VarT0;
    }

    @Override // defpackage.rx, defpackage.ja
    public final boolean h0() {
        return this.L.booleanValue();
    }
}
