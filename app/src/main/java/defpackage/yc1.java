package defpackage;

import java.util.Collections;
import java.util.List;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class yc1 extends rk implements ja {
    public fc0 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yc1(ok okVar, s4 s4Var, ij0 ij0Var, fc0 fc0Var, t11 t11Var) {
        super(okVar, s4Var, ij0Var, t11Var);
        if (okVar == null) {
            z(0);
            throw null;
        }
        if (ij0Var == null) {
            z(2);
            throw null;
        }
        if (t11Var == null) {
            z(3);
            throw null;
        }
        this.g = fc0Var;
    }

    public static /* synthetic */ void z(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public sc0 N() {
        return null;
    }

    public abstract boolean P();

    public sc0 Q() {
        return null;
    }

    @Override // defpackage.ja
    public final List f() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        z(6);
        throw null;
    }

    public fc0 getReturnType() {
        return getType();
    }

    @Override // defpackage.j0, defpackage.ws0
    public final fc0 getType() {
        fc0 fc0Var = this.g;
        if (fc0Var != null) {
            return fc0Var;
        }
        z(4);
        throw null;
    }

    public List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        z(8);
        throw null;
    }

    public boolean h0() {
        return false;
    }

    public abstract boolean isConst();

    public abstract qg q0();
}
