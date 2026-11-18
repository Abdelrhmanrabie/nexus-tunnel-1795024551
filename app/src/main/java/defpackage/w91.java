package defpackage;

import java.util.ArrayList;
import java.util.List;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class w91 extends y0 {
    public final ArrayList r;
    public boolean s;

    /* JADX WARN: Illegal instructions before constructor call */
    public w91(ok okVar, s4 s4Var, boolean z, ad1 ad1Var, ij0 ij0Var, int i, ff0 ff0Var) {
        ke keVar = ke.a;
        if (okVar == null) {
            z(19);
            throw null;
        }
        if (s4Var == null) {
            z(20);
            throw null;
        }
        if (ad1Var == null) {
            z(21);
            throw null;
        }
        if (ij0Var == null) {
            z(22);
            throw null;
        }
        if (ff0Var == null) {
            z(25);
            throw null;
        }
        super(ff0Var, okVar, s4Var, ij0Var, ad1Var, z, i, keVar);
        this.r = new ArrayList(1);
        this.s = false;
    }

    public static w91 N0(ok okVar, s4 s4Var, boolean z, ad1 ad1Var, ij0 ij0Var, int i, ff0 ff0Var) {
        if (okVar == null) {
            z(6);
            throw null;
        }
        if (s4Var == null) {
            z(7);
            throw null;
        }
        if (ad1Var == null) {
            z(8);
            throw null;
        }
        if (ij0Var == null) {
            z(9);
            throw null;
        }
        if (ff0Var != null) {
            return new w91(okVar, s4Var, z, ad1Var, ij0Var, i, ff0Var);
        }
        z(11);
        throw null;
    }

    public static w91 O0(k kVar, ad1 ad1Var, ij0 ij0Var, int i, ff0 ff0Var) {
        s4$a$a s4_a_a = e4.f47a;
        if (ff0Var == null) {
            z(4);
            throw null;
        }
        w91 w91VarN0 = N0(kVar, s4_a_a, false, ad1Var, ij0Var, i, ff0Var);
        u01 u01VarP = ym.e(kVar).p();
        w91VarN0.M0();
        if (!e.O((fc0) u01VarP)) {
            w91VarN0.r.add(u01VarP);
        }
        w91VarN0.M0();
        w91VarN0.s = true;
        return w91VarN0;
    }

    public static /* synthetic */ void z(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 28) ? 2 : 3];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // defpackage.y0
    public final List L0() {
        if (!this.s) {
            throw new IllegalStateException("Type parameter descriptor is not initialized: ".concat(P0()));
        }
        ArrayList arrayList = this.r;
        if (arrayList != null) {
            return arrayList;
        }
        z(28);
        throw null;
    }

    public final void M0() {
        if (this.s) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: ".concat(P0()));
        }
    }

    public final String P0() {
        return getName() + " declared in " + xm.g(b());
    }
}
