package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ae0 extends ai0 {
    public final ai0 b;
    public final ha1 c;
    public ha1 d;
    public ArrayList f;
    public ArrayList g;
    public jd i;

    public ae0(ai0 ai0Var, ha1 ha1Var) {
        this.b = ai0Var;
        this.c = ha1Var;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0051  */
    /* JADX WARN: Code duplicated, block: B:35:0x0056  */
    /* JADX WARN: Code duplicated, block: B:36:0x005b  */
    public static /* synthetic */ void i0(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10 || i == 13 || i == 22) ? 3 : 2];
        if (i == 2) {
            objArr[0] = "typeArguments";
        } else if (i == 3) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i == 5) {
            objArr[0] = "typeSubstitution";
        } else if (i == 6) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i == 8) {
            objArr[0] = "typeArguments";
        } else if (i == 10) {
            objArr[0] = "typeSubstitution";
        } else if (i == 13) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i != 22) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
        } else {
            objArr[0] = "substitutor";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 22:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 11:
                objArr[1] = "getMemberScope";
                break;
            case 12:
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getDefaultType";
                break;
            case 17:
                objArr[1] = "getConstructors";
                break;
            case 18:
                objArr[1] = "getAnnotations";
                break;
            case 19:
                objArr[1] = "getName";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getContainingDeclaration";
                break;
            case 23:
                objArr[1] = "substitute";
                break;
            case 24:
                objArr[1] = "getKind";
                break;
            case 25:
                objArr[1] = "getModality";
                break;
            case 26:
                objArr[1] = "getVisibility";
                break;
            case 27:
                objArr[1] = "getUnsubstitutedInnerClassesScope";
                break;
            case 28:
                objArr[1] = "getSource";
                break;
            case 29:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 30:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "getTypeConstructor";
                break;
        }
        if (i == 2 || i == 3 || i == 5 || i == 6 || i == 8 || i == 10) {
            objArr[2] = "getMemberScope";
        } else if (i == 13) {
            objArr[2] = "getUnsubstitutedMemberScope";
        } else if (i == 22) {
            objArr[2] = "substitute";
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 8 && i != 10 && i != 13 && i != 22) {
            throw new IllegalStateException(str2);
        }
        throw new IllegalArgumentException(str2);
    }

    @Override // defpackage.ai0
    public final Collection A() {
        Collection collectionA = this.b.A();
        if (collectionA != null) {
            return collectionA;
        }
        i0(30);
        throw null;
    }

    @Override // defpackage.pd
    public final boolean B() {
        return this.b.B();
    }

    @Override // defpackage.ai0
    public final uc E() {
        return this.b.E();
    }

    public final ha1 G0() {
        if (this.d == null) {
            ha1 ha1Var = this.c;
            if (ha1Var.a.e()) {
                this.d = ha1Var;
            } else {
                List parameters = this.b.h().getParameters();
                ArrayList arrayList = new ArrayList(parameters.size());
                this.f = arrayList;
                this.d = e.d0(parameters, ha1Var.a, this, arrayList);
                ArrayList arrayList2 = this.f;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    if (!((v91) obj).S()) {
                        arrayList3.add(obj);
                    }
                }
                this.g = arrayList3;
            }
        }
        return this.d;
    }

    @Override // defpackage.ai0
    public final boolean I0() {
        return this.b.I0();
    }

    @Override // defpackage.ai0
    public final vg0 J(ea1 ea1Var) {
        ym.i(xm.d(this));
        return z(ea1Var, lc0$a.a);
    }

    @Override // defpackage.ai0
    public final sc0 J0() {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.ai0
    public final vg0 V() {
        vg0 vg0VarV = this.b.V();
        if (vg0VarV != null) {
            return vg0VarV;
        }
        i0(27);
        throw null;
    }

    @Override // defpackage.ai0
    public final vg0 W(lc0$a lc0_a) {
        vg0 vg0VarW = this.b.W(lc0_a);
        if (!this.c.a.e()) {
            return new c41(vg0VarW, G0());
        }
        if (vg0VarW != null) {
            return vg0VarW;
        }
        i0(14);
        throw null;
    }

    @Override // defpackage.ai0
    public final vg0 Y() {
        ym.i(xm.d(this.b));
        return W(lc0$a.a);
    }

    @Override // defpackage.qg0
    public final boolean Z() {
        return this.b.Z();
    }

    @Override // defpackage.ai0, defpackage.ok, defpackage.od
    public final ai0 a() {
        return this.b.a();
    }

    @Override // defpackage.ok
    public final ok b() {
        ok okVarB = this.b.b();
        if (okVarB != null) {
            return okVarB;
        }
        i0(21);
        throw null;
    }

    @Override // defpackage.qg0
    public final boolean b0() {
        return this.b.b0();
    }

    @Override // defpackage.b41
    public final qk c(ha1 ha1Var) {
        if (ha1Var != null) {
            ea1 ea1Var = ha1Var.a;
            return ea1Var.e() ? this : new ae0(this, ha1.f(ea1Var, G0().a));
        }
        i0(22);
        throw null;
    }

    @Override // defpackage.ai0
    public final boolean c0() {
        return this.b.c0();
    }

    @Override // defpackage.ai0
    public final boolean f0() {
        return this.b.f0();
    }

    @Override // defpackage.qk
    public final t11 g() {
        return t11.a;
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        s4 annotations = this.b.getAnnotations();
        if (annotations != null) {
            return annotations;
        }
        i0(18);
        throw null;
    }

    @Override // defpackage.ok
    public final ij0 getName() {
        ij0 name = this.b.getName();
        if (name != null) {
            return name;
        }
        i0(19);
        throw null;
    }

    @Override // defpackage.ai0, defpackage.uk, defpackage.qg0
    public final cn.d getVisibility() {
        cn.d visibility = this.b.getVisibility();
        if (visibility != null) {
            return visibility;
        }
        i0(26);
        throw null;
    }

    @Override // defpackage.od
    public final a91 h() {
        a91 a91VarH = this.b.h();
        if (this.c.a.e()) {
            if (a91VarH != null) {
                return a91VarH;
            }
            i0(0);
            throw null;
        }
        if (this.i == null) {
            ha1 ha1VarG0 = G0();
            Collection collectionD = a91VarH.d();
            ArrayList arrayList = new ArrayList(collectionD.size());
            Iterator it = collectionD.iterator();
            while (it.hasNext()) {
                arrayList.add(ha1VarG0.k((fc0) it.next(), ad1.INVARIANT));
            }
            this.i = new jd(this, this.f, arrayList, ff0.e);
        }
        jd jdVar = this.i;
        if (jdVar != null) {
            return jdVar;
        }
        i0(1);
        throw null;
    }

    @Override // defpackage.ai0
    public final Collection i() {
        Collection<uc> collectionI = this.b.i();
        ArrayList arrayList = new ArrayList(collectionI.size());
        for (uc ucVar : collectionI) {
            ucVar.getClass();
            rx.a aVarO0 = ucVar.O0(ha1.b);
            aVarO0.e = ucVar.a();
            aVarO0.c = ucVar.p();
            aVarO0.d = ucVar.getVisibility();
            aVarO0.f = ucVar.getKind();
            aVarO0.l = false;
            arrayList.add(((uc) aVarO0.w.L0(aVarO0)).c(G0()));
        }
        return arrayList;
    }

    @Override // defpackage.ai0
    public final boolean k0() {
        return this.b.k0();
    }

    @Override // defpackage.qg0
    public final boolean l0() {
        return this.b.l0();
    }

    @Override // defpackage.ai0, defpackage.od
    public final u01 n() {
        return e4.h(ma1.e(h().getParameters()), getAnnotations(), Y(), h(), false);
    }

    @Override // defpackage.ai0, defpackage.pd
    public final List o() {
        G0();
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            return arrayList;
        }
        i0(29);
        throw null;
    }

    @Override // defpackage.ai0
    public final vg0 o0() {
        vg0 vg0VarO0 = this.b.o0();
        if (vg0VarO0 != null) {
            return vg0VarO0;
        }
        i0(15);
        throw null;
    }

    @Override // defpackage.ai0, defpackage.qg0
    public final zh0 p() {
        zh0 zh0VarP = this.b.p();
        if (zh0VarP != null) {
            return zh0VarP;
        }
        i0(25);
        throw null;
    }

    @Override // defpackage.ai0
    public final boolean r() {
        return this.b.r();
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        return bjVar.d(this, (StringBuilder) obj);
    }

    @Override // defpackage.ai0
    public final i20 t() {
        i20 i20VarT = this.b.t();
        if (i20VarT == null) {
            return null;
        }
        u01 u01Var = t().b;
        if (u01Var != null && !this.c.a.e()) {
            u01Var = (u01) G0().k(u01Var, ad1.INVARIANT);
        }
        return new i20(i20VarT.a, u01Var);
    }

    @Override // defpackage.ai0
    public final int v() {
        int iV = this.b.v();
        if (iV != 0) {
            return iV;
        }
        i0(24);
        throw null;
    }

    @Override // defpackage.ai0
    public final vg0 z(ea1 ea1Var, lc0$a lc0_a) {
        vg0 vg0VarZ = this.b.z(ea1Var, lc0_a);
        return this.c.a.e() ? vg0VarZ : new c41(vg0VarZ, G0());
    }
}
