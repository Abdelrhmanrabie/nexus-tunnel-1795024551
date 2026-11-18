package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class q50 extends q01 implements t40 {
    public static final fm$a L = new fm$a();
    public static final fm$a M = new fm$a();
    public int J;
    public final boolean K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q50(ok okVar, q01 q01Var, s4 s4Var, ij0 ij0Var, la.a aVar, t11 t11Var, boolean z) {
        super(okVar, q01Var, s4Var, ij0Var, aVar, t11Var);
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
        this.J = 0;
        this.K = z;
    }

    public static q50 Y0(ok okVar, wc0 wc0Var, ij0 ij0Var, tw0$a tw0_a, boolean z) {
        if (okVar == null) {
            z(5);
            throw null;
        }
        if (ij0Var != null) {
            return new q50(okVar, null, wc0Var, ij0Var, la.a.b, tw0_a, z);
        }
        z(7);
        throw null;
    }

    public static /* synthetic */ void z(int i) {
        String str = (i == 12 || i == 17 || i == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 17 || i == 20) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 12) {
            objArr[1] = "initialize";
        } else if (i == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 12 && i != 17 && i != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d  */
    @Override // defpackage.q01, defpackage.rx
    public final rx K0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var, ij0 ij0Var) {
        boolean z;
        if (okVar == null) {
            z(13);
            throw null;
        }
        if (aVar == null) {
            z(14);
            throw null;
        }
        if (s4Var == null) {
            z(15);
            throw null;
        }
        q01 q01Var = (q01) oxVar;
        if (ij0Var == null) {
            ij0Var = getName();
        }
        q50 q50Var = new q50(okVar, q01Var, s4Var, ij0Var, aVar, t11Var, this.K);
        int i = this.J;
        boolean z2 = false;
        int i2 = 4;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    z = false;
                } else if (i != 4) {
                    throw null;
                }
            }
            z = true;
        } else {
            z = false;
        }
        if (i != 1 && i != 2) {
            if (i != 3 && i != 4) {
                throw null;
            }
            z2 = true;
        }
        if (!z) {
            i2 = z2 ? 3 : 1;
        } else if (!z2) {
            i2 = 2;
        }
        q50Var.J = i2;
        return q50Var;
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [nw, oc0] */
    @Override // defpackage.q01
    public final q01 X0(sc0 sc0Var, sc0 sc0Var2, List list, List list2, fc0 fc0Var, zh0 zh0Var, cn.d dVar, Map map) {
        hc$a hc_a;
        if (list == null) {
            z(9);
            throw null;
        }
        if (list2 == null) {
            z(10);
            throw null;
        }
        if (dVar == null) {
            z(11);
            throw null;
        }
        super.X0(sc0Var, sc0Var2, list, list2, fc0Var, zh0Var, dVar, map);
        for (lc lcVar : ln0.b) {
            lcVar.getClass();
            ij0 ij0Var = lcVar.a;
            if (ij0Var == null || getName().equals(ij0Var)) {
                vu0 vu0Var = lcVar.b;
                if (vu0Var != null) {
                    if (!((Pattern) vu0Var.b).matcher(getName().b()).matches()) {
                        continue;
                    }
                }
                Collection collection = lcVar.c;
                if (collection == null || collection.contains(getName())) {
                    gc[] gcVarArr = lcVar.e;
                    int length = gcVarArr.length;
                    int i = 0;
                    while (i < length) {
                        gc gcVar = gcVarArr[i];
                        i++;
                        if (gcVar.a(this) != null) {
                            hc_a = new hc$a(false);
                            this.r = hc_a.a;
                            return this;
                        }
                    }
                    hc_a = ((String) lcVar.d.invoke(this)) != null ? new hc$a(false) : hc$a.b$1;
                    this.r = hc_a.a;
                    return this;
                }
            }
        }
        hc_a = hc$a.b;
        this.r = hc_a.a;
        return this;
    }

    @Override // defpackage.t40
    public final t40 a0(fc0 fc0Var, ArrayList arrayList, fc0 fc0Var2, jo0 jo0Var) {
        if (fc0Var2 == null) {
            z(19);
            throw null;
        }
        ArrayList arrayListI0 = e.I0(arrayList, f(), this);
        sc0 sc0VarF = fc0Var == null ? null : b2.f(this, fc0Var, e4.f47a);
        rx.a aVarO0 = O0(ha1.b);
        aVarO0.g = arrayListI0;
        aVarO0.j = fc0Var2;
        aVarO0.h = sc0VarF;
        aVarO0.o = true;
        aVarO0.n = true;
        q50 q50Var = (q50) aVarO0.w.L0(aVarO0);
        if (jo0Var != null) {
            fm$a fm_a = (fm$a) jo0Var.b;
            Object obj = jo0Var.c;
            if (q50Var.I == null) {
                q50Var.I = new LinkedHashMap();
            }
            q50Var.I.put(fm_a, obj);
        }
        if (q50Var != null) {
            return q50Var;
        }
        z(20);
        throw null;
    }

    @Override // defpackage.rx, defpackage.ja
    public final boolean h0() {
        int i = this.J;
        if (i == 1 || i == 2) {
            return false;
        }
        if (i == 3 || i == 4) {
            return true;
        }
        throw null;
    }
}
