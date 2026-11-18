package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class wq0 extends kq0 {
    public wc1 s;
    public final wq0 t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wq0(nq0 nq0Var, s4 s4Var, zh0 zh0Var, cn.d dVar, boolean z, boolean z2, boolean z3, la.a aVar, wq0 wq0Var, t11 t11Var) {
        super(zh0Var, dVar, nq0Var, s4Var, ij0.h("<set-" + nq0Var.getName() + ">"), z, z2, z3, aVar, t11Var);
        if (zh0Var == null) {
            z(2);
            throw null;
        }
        if (dVar == null) {
            z(3);
            throw null;
        }
        if (aVar == null) {
            z(4);
            throw null;
        }
        this.t = wq0Var != null ? wq0Var : this;
    }

    public static wc1 L0(wq0 wq0Var, fc0 fc0Var, s4 s4Var) {
        return new wc1(wq0Var, null, 0, s4Var, ij0.h("<set-?>"), fc0Var, false, false, false, null, t11.a);
    }

    public static /* synthetic */ void z(int i) {
        String str;
        int i2;
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 9:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // defpackage.rk
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public final wq0 a() {
        wq0 wq0Var = this.t;
        if (wq0Var != null) {
            return wq0Var;
        }
        z(13);
        throw null;
    }

    @Override // defpackage.la, defpackage.ja
    public final Collection d() {
        return K0(false);
    }

    @Override // defpackage.ja
    public final List f() {
        wc1 wc1Var = this.s;
        if (wc1Var == null) {
            throw new IllegalStateException();
        }
        List listSingletonList = Collections.singletonList(wc1Var);
        if (listSingletonList != null) {
            return listSingletonList;
        }
        z(11);
        throw null;
    }

    @Override // defpackage.ja
    public final fc0 getReturnType() {
        return ym.e(this).x();
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        if (bjVar.G0 == 0) {
            return bjVar.e(this, obj);
        }
        bjVar.o(this, (StringBuilder) obj, "setter");
        return tb1.a;
    }
}
