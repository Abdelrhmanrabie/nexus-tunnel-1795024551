package defpackage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class q01 extends rx {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q01(ok okVar, q01 q01Var, s4 s4Var, ij0 ij0Var, la.a aVar, t11 t11Var) {
        super(aVar, okVar, q01Var, t11Var, s4Var, ij0Var);
        if (okVar == null) {
            z(0);
            throw null;
        }
        if (s4Var == null) {
            z(1);
            throw null;
        }
        if (ij0Var == null) {
            z(2);
            throw null;
        }
        if (aVar == null) {
            z(3);
            throw null;
        }
        if (t11Var != null) {
        } else {
            z(4);
            throw null;
        }
    }

    public static q01 U0(ai0 ai0Var, ij0 ij0Var, la.a aVar, t11 t11Var) {
        s4$a$a s4_a_a = e4.f47a;
        if (ai0Var == null) {
            z(5);
            throw null;
        }
        if (ij0Var == null) {
            z(7);
            throw null;
        }
        if (t11Var != null) {
            return new q01(ai0Var, null, s4_a_a, ij0Var, aVar, t11Var);
        }
        z(9);
        throw null;
    }

    public static /* synthetic */ void z(int i) {
        String str = (i == 13 || i == 17 || i == 18 || i == 23 || i == 24) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 13 || i == 17 || i == 18 || i == 23 || i == 24) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 21:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 3:
            case 8:
            case 20:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 22:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 15:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 16:
                objArr[0] = "visibility";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 19:
                objArr[0] = "newOwner";
                break;
        }
        if (i == 13 || i == 17) {
            objArr[1] = "initialize";
        } else if (i == 18) {
            objArr[1] = "getOriginal";
        } else if (i == 23) {
            objArr[1] = "copy";
        } else if (i != 24) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
                objArr[2] = "initialize";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 13 && i != 17 && i != 18 && i != 23 && i != 24) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // defpackage.rx
    public rx K0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var, ij0 ij0Var) {
        if (okVar == null) {
            z(19);
            throw null;
        }
        if (aVar == null) {
            z(20);
            throw null;
        }
        if (s4Var == null) {
            z(21);
            throw null;
        }
        q01 q01Var = (q01) oxVar;
        if (ij0Var == null) {
            ij0Var = getName();
        }
        return new q01(okVar, q01Var, s4Var, ij0Var, aVar, t11Var);
    }

    public final q01 V0() {
        return (q01) super.a();
    }

    @Override // defpackage.rx
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public final q01 N0(sc0 sc0Var, sc0 sc0Var2, List list, List list2, fc0 fc0Var, zh0 zh0Var, cn.d dVar) {
        if (list == null) {
            z(10);
            throw null;
        }
        if (list2 == null) {
            z(11);
            throw null;
        }
        if (dVar != null) {
            return X0(sc0Var, sc0Var2, list, list2, fc0Var, zh0Var, dVar, null);
        }
        z(12);
        throw null;
    }

    public q01 X0(sc0 sc0Var, sc0 sc0Var2, List list, List list2, fc0 fc0Var, zh0 zh0Var, cn.d dVar, Map map) {
        if (list == null) {
            z(14);
            throw null;
        }
        if (list2 == null) {
            z(15);
            throw null;
        }
        if (dVar == null) {
            z(16);
            throw null;
        }
        super.N0(sc0Var, sc0Var2, list, list2, fc0Var, zh0Var, dVar);
        if (map != null && !map.isEmpty()) {
            this.I = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final ja a() {
        return (q01) super.a();
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final la a() {
        return (q01) super.a();
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final ok a() {
        return (q01) super.a();
    }

    @Override // defpackage.rx, defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final ox a() {
        return (q01) super.a();
    }

    @Override // defpackage.rk
    /* JADX INFO: renamed from: i0 */
    public final qk a() {
        return (q01) super.a();
    }

    @Override // defpackage.rx, defpackage.ox
    public ox.a s() {
        return O0(ha1.b);
    }
}
