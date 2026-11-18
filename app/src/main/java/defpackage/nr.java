package defpackage;

import java.util.Collection;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class nr extends q01 {
    public static /* synthetic */ void z(int i) {
        String str = (i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "ownerScope";
                break;
            case 2:
                objArr[0] = "newOwner";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "annotations";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
            case 8:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 6) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 6:
            case 7:
                break;
            case 8:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // defpackage.rx, defpackage.la
    public final void E0(Collection collection) {
        if (collection != null) {
            return;
        }
        z(8);
        throw null;
    }

    @Override // defpackage.q01, defpackage.rx
    public final rx K0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var, ij0 ij0Var) {
        if (okVar == null) {
            z(2);
            throw null;
        }
        if (aVar == null) {
            z(3);
            throw null;
        }
        if (s4Var != null) {
            return this;
        }
        z(4);
        throw null;
    }

    @Override // defpackage.rx
    /* JADX INFO: renamed from: T0 */
    public final q01 w(ok okVar, zh0 zh0Var, cn.d dVar) {
        return this;
    }

    @Override // defpackage.rx, defpackage.ox
    public final boolean isSuspend() {
        return false;
    }

    @Override // defpackage.rx, defpackage.ja
    public final Object m0(fm$a fm_a) {
        return null;
    }

    @Override // defpackage.q01, defpackage.rx, defpackage.ox
    public final ox.a s() {
        return new bj(29, this);
    }

    @Override // defpackage.rx, defpackage.la
    public final la w(ai0 ai0Var, zh0 zh0Var, cn.d dVar) {
        return this;
    }
}
