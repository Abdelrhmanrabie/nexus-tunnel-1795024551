package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class sc0 extends pk implements lo0 {
    public final /* synthetic */ int G0;
    public final ok d;
    public final ws0 f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sc0(k kVar) {
        this(e4.f47a);
        this.G0 = 0;
        this.d = kVar;
        this.f = new u10(kVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sc0(ok okVar, j0 j0Var, s4 s4Var) {
        this(s4Var);
        this.G0 = 1;
        if (okVar == null) {
            z$1(0);
            throw null;
        }
        this.d = okVar;
        this.f = j0Var;
    }

    public sc0(s4 s4Var) {
        super(s4Var, f21.d);
    }

    public static /* synthetic */ void z(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static /* synthetic */ void z$1(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = XMLRPC.TAG_VALUE;
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 5:
                objArr[0] = "newOwner";
                break;
            case 6:
                objArr[0] = "outType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 3) {
            objArr[1] = "getValue";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 3 && i != 4) {
            if (i == 5) {
                objArr[2] = "copy";
            } else if (i != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "setOutType";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static /* synthetic */ void z$i0(int i) {
        String str;
        int i2;
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i) {
            case 2:
                objArr[1] = "getTypeParameters";
                break;
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getValueParameters";
                break;
            case 5:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 6:
                objArr[1] = "getVisibility";
                break;
            case 7:
                objArr[1] = "getOriginal";
                break;
            case 8:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // defpackage.ja
    public final sc0 N() {
        return null;
    }

    @Override // defpackage.ja
    public final sc0 Q() {
        return null;
    }

    @Override // defpackage.pk, defpackage.ok, defpackage.od
    public final ja a() {
        return this;
    }

    @Override // defpackage.pk, defpackage.ok, defpackage.od
    public final ok a() {
        return this;
    }

    @Override // defpackage.ok
    public final ok b() {
        int i = this.G0;
        ok okVar = this.d;
        if (i != 0) {
            if (okVar != null) {
                return okVar;
            }
            z$1(4);
            throw null;
        }
        k kVar = (k) okVar;
        if (kVar != null) {
            return kVar;
        }
        z(2);
        throw null;
    }

    @Override // defpackage.b41
    public final sc0 c(ha1 ha1Var) {
        fc0 type;
        ad1 ad1Var;
        if (ha1Var == null) {
            z$i0(1);
            throw null;
        }
        if (!ha1Var.a.e()) {
            if (b() instanceof ai0) {
                type = getType();
                ad1Var = ad1.OUT_VARIANCE;
            } else {
                type = getType();
                ad1Var = ad1.INVARIANT;
            }
            fc0 fc0VarK = ha1Var.k(type, ad1Var);
            if (fc0VarK == null) {
                return null;
            }
            if (fc0VarK != getType()) {
                return new sc0(b(), new d81(fc0VarK), getAnnotations());
            }
        }
        return this;
    }

    @Override // defpackage.ja
    public final Collection d() {
        Set set = Collections.EMPTY_SET;
        if (set != null) {
            return set;
        }
        z$i0(5);
        throw null;
    }

    @Override // defpackage.ja
    public final List f() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        z$i0(4);
        throw null;
    }

    @Override // defpackage.qk
    public final t11 g() {
        return t11.a;
    }

    @Override // defpackage.ja
    public final fc0 getReturnType() {
        return getType();
    }

    @Override // defpackage.j0, defpackage.ws0
    public final fc0 getType() {
        fc0 type = getValue().getType();
        if (type != null) {
            return type;
        }
        z$i0(3);
        throw null;
    }

    @Override // defpackage.ja
    public final List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        z$i0(2);
        throw null;
    }

    public final ws0 getValue() {
        int i = this.G0;
        ws0 ws0Var = this.f;
        if (i != 0) {
            j0 j0Var = (j0) ws0Var;
            if (j0Var != null) {
                return j0Var;
            }
            z$1(3);
            throw null;
        }
        u10 u10Var = (u10) ws0Var;
        if (u10Var != null) {
            return u10Var;
        }
        z(1);
        throw null;
    }

    @Override // defpackage.uk, defpackage.qg0
    public final cn.d getVisibility() {
        cn.d dVar = cn.f;
        if (dVar != null) {
            return dVar;
        }
        z$i0(6);
        throw null;
    }

    @Override // defpackage.ja
    public final boolean h0() {
        return false;
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        ((StringBuilder) obj).append(getName());
        return tb1.a;
    }

    @Override // defpackage.pk
    public String toString() {
        if (this.G0 != 0) {
            return super.toString();
        }
        return "class " + ((k) this.d).getName() + "::this";
    }
}
