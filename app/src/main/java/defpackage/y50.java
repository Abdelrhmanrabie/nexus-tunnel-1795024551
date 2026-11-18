package defpackage;

import java.util.ArrayList;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class y50 extends nq0 implements t40 {
    public final boolean F;
    public final jo0 G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y50(ok okVar, s4 s4Var, zh0 zh0Var, cn.d dVar, boolean z, ij0 ij0Var, t11 t11Var, nq0 nq0Var, la.a aVar, boolean z2, jo0 jo0Var) {
        super(okVar, nq0Var, s4Var, zh0Var, dVar, z, ij0Var, aVar, t11Var, false, false, false, false, false);
        if (okVar == null) {
            z(0);
            throw null;
        }
        if (zh0Var == null) {
            z(2);
            throw null;
        }
        if (dVar == null) {
            z(3);
            throw null;
        }
        if (ij0Var == null) {
            z(4);
            throw null;
        }
        if (aVar == null) {
            z(6);
            throw null;
        }
        this.F = z2;
        this.G = jo0Var;
    }

    public static y50 O0(ok okVar, wc0 wc0Var, cn.d dVar, boolean z, ij0 ij0Var, tw0$a tw0_a, boolean z2) {
        zh0 zh0Var = zh0.b;
        if (okVar == null) {
            z(7);
            throw null;
        }
        if (ij0Var != null) {
            return new y50(okVar, wc0Var, zh0Var, dVar, z, ij0Var, tw0_a, null, la.a.b, z2, null);
        }
        z(11);
        throw null;
    }

    public static /* synthetic */ void z(int i) {
        String str = i != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 21 ? 3 : 2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
        }
        if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i == 21) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // defpackage.nq0
    public final nq0 G0(ok okVar, zh0 zh0Var, cn.d dVar, nq0 nq0Var, la.a aVar, ij0 ij0Var) {
        if (okVar == null) {
            z(13);
            throw null;
        }
        if (zh0Var == null) {
            z(14);
            throw null;
        }
        if (dVar == null) {
            z(15);
            throw null;
        }
        if (aVar == null) {
            z(16);
            throw null;
        }
        if (ij0Var == null) {
            z(17);
            throw null;
        }
        return new y50(okVar, getAnnotations(), zh0Var, dVar, this.i, ij0Var, t11.a, nq0Var, aVar, this.F, this.G);
    }

    @Override // defpackage.t40
    public final t40 a0(fc0 fc0Var, ArrayList arrayList, fc0 fc0Var2, jo0 jo0Var) {
        pq0 pq0Var;
        wq0 wq0Var;
        if (fc0Var2 == null) {
            z(20);
            throw null;
        }
        nq0 nq0VarA = a() == this ? null : a();
        y50 y50Var = new y50(b(), getAnnotations(), p(), getVisibility(), this.i, getName(), g(), nq0VarA, getKind(), this.F, jo0Var);
        pq0 pq0Var2 = this.B;
        if (pq0Var2 != null) {
            pq0 pq0Var3 = new pq0(y50Var, pq0Var2.getAnnotations(), pq0Var2.p(), pq0Var2.getVisibility(), pq0Var2.g, pq0Var2.i, pq0Var2.o, getKind(), nq0VarA == null ? null : nq0VarA.B, pq0Var2.g());
            pq0Var3.r = pq0Var2.r;
            pq0Var3.s = fc0Var2;
            pq0Var = pq0Var3;
        } else {
            pq0Var = null;
        }
        wq0 wq0Var2 = this.C;
        if (wq0Var2 != null) {
            wq0Var = new wq0(y50Var, wq0Var2.getAnnotations(), wq0Var2.p(), wq0Var2.getVisibility(), wq0Var2.g, wq0Var2.i, wq0Var2.o, getKind(), nq0VarA == null ? null : nq0VarA.C, wq0Var2.g());
            wq0Var.r = wq0Var.r;
            wc1 wc1Var = (wc1) wq0Var2.f().get(0);
            if (wc1Var == null) {
                wq0.z(6);
                throw null;
            }
            wq0Var.s = wc1Var;
        } else {
            wq0Var = null;
        }
        y50Var.L0(pq0Var, wq0Var, this.D, this.E);
        ff0.f fVar = this.j;
        if (fVar != null) {
            y50Var.j = fVar;
        }
        y50Var.p = d();
        y50Var.N0(fc0Var2, getTypeParameters(), this.y, fc0Var != null ? b2.f(this, fc0Var, e4.f47a) : null);
        return y50Var;
    }

    @Override // defpackage.yc1, defpackage.ja
    public final boolean h0() {
        return false;
    }

    @Override // defpackage.nq0, defpackage.yc1
    public final boolean isConst() {
        fc0 type = getType();
        if (!this.F) {
            return false;
        }
        if (((!ub0.G(type) && !ac1.a(type)) || ma1.g(type)) && !ub0.E(type, m21.a.f)) {
            return false;
        }
        t4 t4Var = k91.a;
        return !e4.A(type, r70.o) || ub0.E(type, m21.a.f);
    }

    @Override // defpackage.nq0, defpackage.ja
    public final Object m0(fm$a fm_a) {
        jo0 jo0Var = this.G;
        if (jo0Var == null || !((fm$a) jo0Var.b).equals(q50.M)) {
            return null;
        }
        return jo0Var.c;
    }
}
