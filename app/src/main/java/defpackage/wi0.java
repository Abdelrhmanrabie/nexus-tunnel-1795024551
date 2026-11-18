package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class wi0 extends zc {
    public final int n;
    public zh0 p;
    public cn.d q;
    public jd r;
    public ArrayList s;
    public final ArrayList t;
    public final ff0.a u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wi0(wq wqVar, ij0 ij0Var, ff0.a aVar) {
        super(aVar, wqVar, ij0Var, t11.a);
        if (aVar == null) {
            i0(4);
            throw null;
        }
        this.t = new ArrayList();
        this.u = aVar;
        this.n = 2;
    }

    public static /* synthetic */ void i0(int i) {
        String str;
        int i2;
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i2 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // defpackage.ai0
    public final Collection A() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        i0(19);
        throw null;
    }

    @Override // defpackage.pd
    public final boolean B() {
        return false;
    }

    @Override // defpackage.ai0
    public final uc E() {
        return null;
    }

    @Override // defpackage.ai0
    public final boolean I0() {
        return false;
    }

    @Override // defpackage.ai0
    public final vg0 W(lc0$a lc0_a) {
        return vg0.b.b;
    }

    @Override // defpackage.qg0
    public final boolean Z() {
        return false;
    }

    @Override // defpackage.ai0
    public final boolean c0() {
        return false;
    }

    @Override // defpackage.ai0
    public final boolean f0() {
        return false;
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        return e4.f47a;
    }

    @Override // defpackage.ai0, defpackage.uk, defpackage.qg0
    public final cn.d getVisibility() {
        cn.d dVar = this.q;
        if (dVar != null) {
            return dVar;
        }
        i0(10);
        throw null;
    }

    @Override // defpackage.od
    public final a91 h() {
        jd jdVar = this.r;
        if (jdVar != null) {
            return jdVar;
        }
        i0(11);
        throw null;
    }

    @Override // defpackage.ai0
    public final Collection i() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        i0(13);
        throw null;
    }

    @Override // defpackage.ai0
    public final boolean k0() {
        return false;
    }

    @Override // defpackage.qg0
    public final boolean l0() {
        return false;
    }

    @Override // defpackage.ai0, defpackage.pd
    public final List o() {
        ArrayList arrayList = this.s;
        if (arrayList != null) {
            return arrayList;
        }
        i0(15);
        throw null;
    }

    @Override // defpackage.ai0
    public final vg0 o0() {
        return vg0.b.b;
    }

    @Override // defpackage.ai0, defpackage.qg0
    public final zh0 p() {
        zh0 zh0Var = this.p;
        if (zh0Var != null) {
            return zh0Var;
        }
        i0(7);
        throw null;
    }

    @Override // defpackage.ai0
    public final boolean r() {
        return false;
    }

    @Override // defpackage.ai0
    public final i20 t() {
        return null;
    }

    public final String toString() {
        return pk.W(this);
    }

    @Override // defpackage.ai0
    public final int v() {
        int i = this.n;
        if (i != 0) {
            return i;
        }
        i0(8);
        throw null;
    }
}
