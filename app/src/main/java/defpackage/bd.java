package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class bd extends zc {
    public final zh0 n;
    public final int o;
    public final jd p;
    public vg0 q;
    public Set r;
    public uc s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(ok okVar, ij0 ij0Var, zh0 zh0Var, int i, List list, ff0 ff0Var) {
        super(ff0Var, okVar, ij0Var, t11.a);
        if (okVar == null) {
            i0(0);
            throw null;
        }
        if (ij0Var == null) {
            i0(1);
            throw null;
        }
        if (i == 0) {
            i0(3);
            throw null;
        }
        if (list == null) {
            i0(4);
            throw null;
        }
        if (ff0Var == null) {
            i0(6);
            throw null;
        }
        this.n = zh0Var;
        this.o = i;
        this.p = new jd(this, Collections.EMPTY_LIST, list, ff0Var);
    }

    public static /* synthetic */ void i0(int i) {
        String str;
        int i2;
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 12:
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
        return this.s;
    }

    @Override // defpackage.ai0
    public final boolean I0() {
        return false;
    }

    public final void K0(vg0 vg0Var, Set set, uc ucVar) {
        if (set == null) {
            i0(8);
            throw null;
        }
        this.q = vg0Var;
        this.r = set;
        this.s = ucVar;
    }

    @Override // defpackage.ai0
    public final vg0 W(lc0$a lc0_a) {
        vg0 vg0Var = this.q;
        if (vg0Var != null) {
            return vg0Var;
        }
        i0(13);
        throw null;
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
        cn.d dVar = cn.e;
        if (dVar != null) {
            return dVar;
        }
        i0(17);
        throw null;
    }

    @Override // defpackage.od
    public final a91 h() {
        jd jdVar = this.p;
        if (jdVar != null) {
            return jdVar;
        }
        i0(10);
        throw null;
    }

    @Override // defpackage.ai0
    public final Collection i() {
        Set set = this.r;
        if (set != null) {
            return set;
        }
        i0(11);
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
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        i0(18);
        throw null;
    }

    @Override // defpackage.ai0
    public final vg0 o0() {
        return vg0.b.b;
    }

    @Override // defpackage.ai0, defpackage.qg0
    public final zh0 p() {
        zh0 zh0Var = this.n;
        if (zh0Var != null) {
            return zh0Var;
        }
        i0(16);
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

    public String toString() {
        return "class " + getName();
    }

    @Override // defpackage.ai0
    public final int v() {
        int i = this.o;
        if (i != 0) {
            return i;
        }
        i0(15);
        throw null;
    }
}
