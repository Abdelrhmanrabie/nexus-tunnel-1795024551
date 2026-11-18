package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class kq0 extends rk implements ox {
    public boolean g;
    public final boolean i;
    public final zh0 j;
    public final nq0 n;
    public final boolean o;
    public final la.a p;
    public cn.d q;
    public ox r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kq0(zh0 zh0Var, cn.d dVar, nq0 nq0Var, s4 s4Var, ij0 ij0Var, boolean z, boolean z2, boolean z3, la.a aVar, t11 t11Var) {
        super(nq0Var.b(), s4Var, ij0Var, t11Var);
        if (zh0Var == null) {
            z(0);
            throw null;
        }
        if (dVar == null) {
            z(1);
            throw null;
        }
        this.r = null;
        this.j = zh0Var;
        this.q = dVar;
        this.n = nq0Var;
        this.g = z;
        this.i = z2;
        this.o = z3;
        this.p = aVar;
    }

    public static /* synthetic */ void z(int i) {
        String str;
        int i2;
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            case 7:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 14:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 14:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // defpackage.ox
    public final boolean D() {
        return false;
    }

    @Override // defpackage.ox
    public final boolean D0() {
        return false;
    }

    @Override // defpackage.la
    public final void E0(Collection collection) {
        if (collection != null) {
            return;
        }
        z(14);
        throw null;
    }

    @Override // defpackage.ox
    public final boolean F0() {
        return false;
    }

    @Override // defpackage.ox
    public final boolean H0() {
        return false;
    }

    public final ArrayList K0(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (nq0 nq0Var : X().d()) {
            j0 j0Var = z ? nq0Var.B : nq0Var.C;
            if (j0Var != null) {
                arrayList.add(j0Var);
            }
        }
        return arrayList;
    }

    @Override // defpackage.ja
    public final sc0 N() {
        return X().y;
    }

    @Override // defpackage.ja
    public final sc0 Q() {
        return X().z;
    }

    public final nq0 X() {
        nq0 nq0Var = this.n;
        if (nq0Var != null) {
            return nq0Var;
        }
        z(12);
        throw null;
    }

    @Override // defpackage.qg0
    public final boolean Z() {
        return false;
    }

    @Override // defpackage.qg0
    public final boolean b0() {
        return this.i;
    }

    @Override // defpackage.ox, defpackage.b41
    public final ox c(ha1 ha1Var) {
        if (ha1Var != null) {
            throw new UnsupportedOperationException();
        }
        z(7);
        throw null;
    }

    @Override // defpackage.b41
    public final /* bridge */ /* synthetic */ qk c(ha1 ha1Var) {
        c(ha1Var);
        throw null;
    }

    @Override // defpackage.la
    public final la.a getKind() {
        la.a aVar = this.p;
        if (aVar != null) {
            return aVar;
        }
        z(6);
        throw null;
    }

    @Override // defpackage.ja
    public final List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        z(8);
        throw null;
    }

    @Override // defpackage.uk, defpackage.qg0
    public final cn.d getVisibility() {
        cn.d dVar = this.q;
        if (dVar != null) {
            return dVar;
        }
        z(10);
        throw null;
    }

    @Override // defpackage.ja
    public final boolean h0() {
        return false;
    }

    @Override // defpackage.ox
    public final boolean isSuspend() {
        return false;
    }

    @Override // defpackage.qg0
    public final boolean l0() {
        return false;
    }

    @Override // defpackage.ja
    public final Object m0(fm$a fm_a) {
        return null;
    }

    @Override // defpackage.ox
    public final boolean n0() {
        return false;
    }

    @Override // defpackage.qg0
    public final zh0 p() {
        zh0 zh0Var = this.j;
        if (zh0Var != null) {
            return zh0Var;
        }
        z(9);
        throw null;
    }

    @Override // defpackage.ox
    public final boolean r() {
        return this.o;
    }

    @Override // defpackage.ox
    public final ox v0() {
        return this.r;
    }

    @Override // defpackage.la
    public final la w(ai0 ai0Var, zh0 zh0Var, cn.d dVar) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }
}
