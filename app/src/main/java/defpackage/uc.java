package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class uc extends rx implements gh {
    public final boolean J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uc(ai0 ai0Var, gh ghVar, s4 s4Var, boolean z, la.a aVar, t11 t11Var) {
        super(aVar, ai0Var, ghVar, t11Var, s4Var, f21.e);
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
        this.J = z;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    public static /* synthetic */ void z(int i) {
        String str;
        int i2;
        if (i != 19 && i != 25) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 19 && i != 25) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 5:
            case 8:
            case 23:
                objArr[0] = "annotations";
                break;
            case 2:
            case 22:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 9:
            case 24:
                objArr[0] = "source";
                break;
            case 4:
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 13:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
            case 14:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "typeParameterDescriptors";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                break;
            case 18:
                objArr[0] = "originalSubstitutor";
                break;
            case 20:
                objArr[0] = "overriddenDescriptors";
                break;
            case 21:
                objArr[0] = "newOwner";
                break;
        }
        if (i == 19) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i != 25) {
            switch (i) {
                case 15:
                    objArr[1] = "getContainingDeclaration";
                    break;
                case 16:
                    objArr[1] = "getConstructedClass";
                    break;
                case 17:
                    objArr[1] = "getOriginal";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "create";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSynthesized";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                objArr[2] = "initialize";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            case 20:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 21:
            case 22:
            case 23:
            case 24:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 19 && i != 25) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    @Override // defpackage.rx, defpackage.la
    public final void E0(Collection collection) {
        if (collection != null) {
            return;
        }
        z(20);
        throw null;
    }

    @Override // defpackage.rx
    public /* bridge */ /* synthetic */ rx K0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var, ij0 ij0Var) {
        return T0(aVar, okVar, oxVar, t11Var, s4Var);
    }

    public uc T0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var) {
        if (okVar == null) {
            z(21);
            throw null;
        }
        if (aVar == null) {
            z(22);
            throw null;
        }
        if (s4Var == null) {
            z(23);
            throw null;
        }
        la.a aVar2 = la.a.b;
        if (aVar == aVar2 || aVar == la.a.f) {
            return new uc((ai0) okVar, this, s4Var, this.J, aVar2, t11Var);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + okVar + "\nkind: " + aVar);
    }

    public final ai0 U0() {
        return (ai0) super.b();
    }

    public final void V0(List list, cn.d dVar) {
        if (list == null) {
            z(13);
            throw null;
        }
        if (dVar != null) {
            W0(list, dVar, ((ai0) super.b()).o());
        } else {
            z(14);
            throw null;
        }
    }

    public final void W0(List list, cn.d dVar, List list2) {
        sc0 sc0VarJ0 = null;
        if (list == null) {
            z(10);
            throw null;
        }
        if (dVar == null) {
            z(11);
            throw null;
        }
        if (list2 == null) {
            z(12);
            throw null;
        }
        ai0 ai0Var = (ai0) super.b();
        if (ai0Var.B()) {
            ok okVarB = ai0Var.b();
            if (okVarB instanceof ai0) {
                sc0VarJ0 = ((ai0) okVarB).J0();
            }
        }
        N0(null, sc0VarJ0, list2, list, null, zh0.b, dVar);
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final ja a() {
        return (uc) super.a();
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final la a() {
        return (uc) super.a();
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final ok a() {
        return (uc) super.a();
    }

    @Override // defpackage.rx, defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final ox a() {
        return (uc) super.a();
    }

    @Override // defpackage.rx, defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final uc a() {
        return (uc) super.a();
    }

    @Override // defpackage.rk, defpackage.ok
    public final ok b() {
        return (ai0) super.b();
    }

    @Override // defpackage.rk, defpackage.ok
    public final pd b() {
        return (ai0) super.b();
    }

    @Override // defpackage.rx, defpackage.b41
    public final uc c(ha1 ha1Var) {
        if (ha1Var != null) {
            return (uc) super.c(ha1Var);
        }
        z(18);
        throw null;
    }

    @Override // defpackage.rx, defpackage.la, defpackage.ja
    public final Collection d() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        z(19);
        throw null;
    }

    @Override // defpackage.gh
    public final ai0 e0() {
        return (ai0) super.b();
    }

    @Override // defpackage.rk
    /* JADX INFO: renamed from: i0 */
    public final qk a() {
        return (uc) super.a();
    }

    @Override // defpackage.rx, defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        return bjVar.b(this, obj);
    }

    @Override // defpackage.rx, defpackage.la
    public final la w(ai0 ai0Var, zh0 zh0Var, cn.d dVar) {
        return (uc) G0(ai0Var, zh0Var, dVar);
    }
}
