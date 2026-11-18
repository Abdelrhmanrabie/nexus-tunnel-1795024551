package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class pq0 extends kq0 {
    public fc0 s;
    public final pq0 t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pq0(nq0 nq0Var, s4 s4Var, zh0 zh0Var, cn.d dVar, boolean z, boolean z2, boolean z3, la.a aVar, pq0 pq0Var, t11 t11Var) {
        super(zh0Var, dVar, nq0Var, s4Var, ij0.h("<get-" + nq0Var.getName() + ">"), z, z2, z3, aVar, t11Var);
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
        this.t = pq0Var != null ? pq0Var : this;
    }

    public static /* synthetic */ void z(int i) {
        String str = (i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
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
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i == 7) {
            objArr[1] = "getValueParameters";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 6 && i != 7 && i != 8) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // defpackage.rk
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public final pq0 a() {
        pq0 pq0Var = this.t;
        if (pq0Var != null) {
            return pq0Var;
        }
        z(8);
        throw null;
    }

    @Override // defpackage.la, defpackage.ja
    public final Collection d() {
        return K0(true);
    }

    @Override // defpackage.ja
    public final List f() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        z(7);
        throw null;
    }

    @Override // defpackage.ja
    public final fc0 getReturnType() {
        return this.s;
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        if (bjVar.G0 == 0) {
            return bjVar.e(this, obj);
        }
        bjVar.o(this, (StringBuilder) obj, "getter");
        return tb1.a;
    }
}
