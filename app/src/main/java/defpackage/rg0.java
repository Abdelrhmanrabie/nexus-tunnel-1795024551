package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class rg0 {
    public final hn a;
    public final g b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends oc0 implements lw {
        public final /* synthetic */ boolean c;
        public final /* synthetic */ kr0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, kr0 kr0Var) {
            super(0);
            this.c = z;
            this.d = kr0Var;
        }

        @Override // defpackage.lw
        public final Object invoke() {
            List listG1;
            rg0 rg0Var = rg0.this;
            hn hnVar = rg0Var.a;
            dg0 dg0VarA = rg0Var.a(hnVar.c);
            if (dg0VarA == null) {
                listG1 = null;
            } else {
                fn fnVar = hnVar.a;
                boolean z = this.c;
                kr0 kr0Var = this.d;
                a4 a4Var = fnVar.e;
                listG1 = he.g1(z ? a4Var.i(dg0VarA, kr0Var) : a4Var.f(dg0VarA, kr0Var));
            }
            return listG1 == null ? uq.b : listG1;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends oc0 implements lw {
        public final /* synthetic */ dg0 c;
        public final /* synthetic */ b0 d;
        public final /* synthetic */ x3 f;
        public final /* synthetic */ int g;
        public final /* synthetic */ rr0 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(dg0 dg0Var, b0 b0Var, x3 x3Var, int i, rr0 rr0Var) {
            super(0);
            this.c = dg0Var;
            this.d = b0Var;
            this.f = x3Var;
            this.g = i;
            this.i = rr0Var;
        }

        @Override // defpackage.lw
        public final Object invoke() {
            return he.g1(rg0.this.a.a.e.b(this.c, this.d, this.f, this.g, this.i));
        }
    }

    public rg0(hn hnVar) {
        this.a = hnVar;
        fn fnVar = hnVar.a;
        this.b = new g(fnVar.b, fnVar.l, 13, false);
    }

    public final dg0 a(ok okVar) {
        if (!(okVar instanceof wn0)) {
            if (okVar instanceof on) {
                return ((on) okVar).C;
            }
            return null;
        }
        final cv cvVar = ((xn0) ((wn0) okVar)).g;
        hn hnVar = this.a;
        final jj0 jj0Var = hnVar.b;
        final fi0 fi0Var = hnVar.d;
        final rn rnVar = hnVar.g;
        return new dg0(cvVar, jj0Var, fi0Var, rnVar) { // from class: vr0$b
            public final cv d;

            {
                super(jj0Var, fi0Var, rnVar);
                this.d = cvVar;
            }

            @Override // defpackage.dg0
            public final cv a() {
                return this.d;
            }
        };
    }

    public final s4 b(yx.c cVar, int i, x3 x3Var) {
        return !xt.c.c(i).booleanValue() ? e4.f47a : new hl0(this.a.a.a, new sg0(this, cVar, x3Var, 1));
    }

    public final s4 c(kr0 kr0Var, boolean z) {
        return !xt.c.c(kr0Var.f).booleanValue() ? e4.f47a : new hl0(this.a.a.a, new b(z, kr0Var));
    }

    public final mn d(ar0 ar0Var, boolean z) {
        hn hnVar = this.a;
        ai0 ai0Var = (ai0) hnVar.c;
        int i = ar0Var.f;
        x3 x3Var = x3.b;
        mn mnVar = new mn(ai0Var, null, b(ar0Var, i, x3Var), z, la.a.b, ar0Var, hnVar.b, hnVar.d, hnVar.e, hnVar.g, null);
        mnVar.V0(hn.b(hnVar, mnVar, uq.b).i.h(ar0Var.g, ar0Var, x3Var), ui.a((ur0) xt.d.c(ar0Var.f)));
        mnVar.j = ai0Var.n();
        mnVar.B = !xt.n.c(ar0Var.f).booleanValue();
        return mnVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
    public final bo e(fr0 fr0Var) {
        int i;
        nr0 nr0VarA;
        if ((fr0Var.d & 1) == 1) {
            i = fr0Var.f;
        } else {
            int i2 = fr0Var.g;
            i = ((i2 >> 8) << 6) + (i2 & 63);
        }
        int i3 = i;
        x3 x3Var = x3.b;
        s4 s4VarB = b(fr0Var, i3, x3Var);
        int i4 = fr0Var.d;
        int i5 = 0;
        boolean z = (i4 & 32) == 32 || (i4 & 64) == 64;
        hn hnVar = this.a;
        fi0 fi0Var = hnVar.d;
        ok okVar = hnVar.c;
        fn fnVar = hnVar.a;
        s4 inVar = z ? new in(fnVar.a, new sg0(this, fr0Var, x3Var, i5)) : e4.f47a;
        cv cvVarG = ym.g(okVar);
        int i6 = fr0Var.i;
        jj0 jj0Var = hnVar.b;
        s4 s4Var = inVar;
        bo boVar = new bo(hnVar.c, null, s4VarB, ij0.d(jj0Var.getString(fr0Var.i)), ui.b((gr0) xt.o.c(i3)), fr0Var, hnVar.b, fi0Var, cvVarG.c(e.E(jj0Var, i6)).equals(r41.a) ? gd1.b : hnVar.e, hnVar.g, null);
        hn hnVarB = hn.b(hnVar, boVar, fr0Var.o);
        int i7 = fr0Var.d;
        if ((i7 & 32) == 32) {
            nr0VarA = fr0Var.p;
        } else {
            nr0VarA = (i7 & 64) == 64 ? fi0Var.a(fr0Var.q) : null;
        }
        e91 e91Var = hnVarB.h;
        sc0 sc0VarF = nr0VarA == null ? null : b2.f(boVar, e91Var.f(nr0VarA), s4Var);
        ai0 ai0Var = okVar instanceof ai0 ? (ai0) okVar : null;
        boVar.X0(sc0VarF, ai0Var != null ? ai0Var.J0() : null, he.g1(e91Var.g.values()), hnVarB.i.h(fr0Var.r, fr0Var, x3Var), e91Var.f(e.k0(fr0Var, fi0Var)), uh.a((hr0) xt.e.c(i3)), ui.a((ur0) xt.d.c(i3)), vq.b);
        boVar.r = e.i(xt.p, i3);
        boVar.s = e.i(xt.q, i3);
        boVar.t = e.i(xt.t, i3);
        boVar.u = e.i(xt.r, i3);
        boVar.v = e.i(xt.s, i3);
        boVar.A = e.i(xt.u, i3);
        boVar.w = e.i(xt.v, i3);
        boVar.B = !xt.w.c(i3).booleanValue();
        fnVar.m.getClass();
        return boVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:68:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:69:0x02de  */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object, java.util.Map] */
    public final ao f(kr0 kr0Var) {
        int i;
        rg0 rg0Var;
        ff0 ff0Var;
        s4 inVar;
        nr0 nr0VarA;
        boolean z;
        int i2;
        pq0 pq0Var;
        rg0 rg0Var2;
        wq0 wq0Var;
        boolean z2;
        if ((kr0Var.d & 1) == 1) {
            i = kr0Var.f;
        } else {
            int i3 = kr0Var.g;
            i = ((i3 >> 8) << 6) + (i3 & 63);
        }
        hn hnVar = this.a;
        fi0 fi0Var = hnVar.d;
        ok okVar = hnVar.c;
        ff0 ff0Var2 = hnVar.a.a;
        s4 s4VarB = b(kr0Var, i, x3.c);
        xt.b bVar = xt.e;
        zh0 zh0VarA = uh.a((hr0) bVar.c(i));
        xt.b bVar2 = xt.d;
        int i4 = i;
        ao aoVar = new ao(okVar, null, s4VarB, zh0VarA, ui.a((ur0) bVar2.c(i)), e.i(xt.x, i), e.E(hnVar.b, kr0Var.i), ui.b((gr0) xt.o.c(i)), e.i(xt.B, i), e.i(xt.A, i), e.i(xt.D, i), e.i(xt.E, i), e.i(xt.F, i), kr0Var, hnVar.b, fi0Var, hnVar.e, hnVar.g);
        hn hnVarB = hn.b(hnVar, aoVar, kr0Var.o);
        boolean zI = e.i(xt.y, i4);
        x3 x3Var = x3.d;
        s4$a$a s4_a_a = e4.f47a;
        int i5 = 0;
        if (zI) {
            int i6 = kr0Var.d;
            if ((i6 & 32) == 32 || (i6 & 64) == 64) {
                rg0Var = this;
                ff0Var = ff0Var2;
                inVar = new in(ff0Var, new sg0(rg0Var, kr0Var, x3Var, i5));
            } else {
                rg0Var = this;
                ff0Var = ff0Var2;
                inVar = s4_a_a;
            }
        } else {
            rg0Var = this;
            ff0Var = ff0Var2;
            inVar = s4_a_a;
        }
        nr0 nr0VarL0 = e.l0(kr0Var, fi0Var);
        e91 e91Var = hnVarB.h;
        fc0 fc0VarF = e91Var.f(nr0VarL0);
        List listG1 = he.g1(e91Var.g.values());
        ok okVar2 = hnVar.c;
        wq0 wq0VarH = null;
        ai0 ai0Var = okVar2 instanceof ai0 ? (ai0) okVar2 : null;
        sc0 sc0VarJ0 = ai0Var == null ? null : ai0Var.J0();
        int i7 = kr0Var.d;
        if ((i7 & 32) == 32) {
            nr0VarA = kr0Var.p;
        } else {
            nr0VarA = (i7 & 64) == 64 ? fi0Var.a(kr0Var.q) : null;
        }
        aoVar.N0(fc0VarF, listG1, sc0VarJ0, nr0VarA == null ? null : b2.f(aoVar, e91Var.f(nr0VarA), inVar));
        xt.a aVar = xt.c;
        boolean zI2 = e.i(aVar, i4);
        xt.b bVar3 = bVar2;
        ur0 ur0Var = (ur0) bVar3.c(i4);
        xt.b bVar4 = bVar;
        hr0 hr0Var = (hr0) bVar4.c(i4);
        if (ur0Var == null) {
            xt.a(10);
            throw null;
        }
        if (hr0Var == null) {
            xt.a(11);
            throw null;
        }
        if (zI2) {
            z = true;
            i2 = 1 << aVar.a;
        } else {
            z = true;
            i2 = 0;
        }
        int i8 = i2 | (hr0Var.b << bVar4.a) | (ur0Var.b << bVar3.a);
        xt.a aVar2 = xt.J;
        Boolean bool = Boolean.FALSE;
        aVar2.getClass();
        xt.a aVar3 = xt.K;
        aVar3.getClass();
        xt.a aVar4 = xt.L;
        aVar4.getClass();
        ke keVar = t11.a;
        if (zI) {
            boolean z3 = z;
            int i9 = (kr0Var.d & 256) == 256 ? kr0Var.s : i8;
            boolean zBooleanValue = aVar2.c(i9).booleanValue();
            boolean zBooleanValue2 = aVar3.c(i9).booleanValue();
            boolean zBooleanValue3 = aVar4.c(i9).booleanValue();
            s4 s4VarB2 = rg0Var.b(kr0Var, i9, x3Var);
            pq0Var = zBooleanValue ? new pq0(aoVar, s4VarB2, uh.a((hr0) bVar4.c(i9)), ui.a((ur0) bVar3.c(i9)), !zBooleanValue, zBooleanValue2, zBooleanValue3, aoVar.getKind(), null, keVar) : b2.g(aoVar, s4VarB2, z3, aoVar.g());
            pq0Var.s = aoVar.getType();
        } else {
            i8 = i8;
            hnVarB = hnVarB;
            bVar3 = bVar3;
            aVar2 = aVar2;
            bVar4 = bVar4;
            aVar3 = aVar3;
            aVar4 = aVar4;
            ff0Var = ff0Var;
            pq0Var = null;
        }
        if (e.i(xt.z, i4)) {
            int i10 = (kr0Var.d & 512) == 512 ? kr0Var.t : i8;
            boolean zBooleanValue4 = aVar2.c(i10).booleanValue();
            boolean zBooleanValue5 = aVar3.c(i10).booleanValue();
            boolean zBooleanValue6 = aVar4.c(i10).booleanValue();
            x3 x3Var2 = x3.f;
            rg0Var2 = this;
            s4 s4VarB3 = rg0Var2.b(kr0Var, i10, x3Var2);
            if (zBooleanValue4) {
                pq0Var = pq0Var;
                wq0Var = new wq0(aoVar, s4VarB3, uh.a((hr0) bVar4.c(i10)), ui.a((ur0) bVar3.c(i10)), !zBooleanValue4, zBooleanValue5, zBooleanValue6, aoVar.getKind(), null, keVar);
                wc1 wc1Var = (wc1) he.a1(hn.b(hnVarB, wq0Var, uq.b).i.h(Collections.singletonList(kr0Var.r), kr0Var, x3Var2));
                if (wc1Var == null) {
                    wq0.z(6);
                    throw null;
                }
                wq0Var.s = wc1Var;
            } else {
                wq0VarH = b2.h(aoVar, s4VarB3, s4_a_a, true, aoVar.getVisibility(), aoVar.g());
                aoVar = aoVar;
            }
            if (e.i(xt.C, i4)) {
                z2 = true;
                k90 k90Var = new k90(rg0Var2, kr0Var, aoVar, 1 == true ? 1 : 0);
                ff0Var.getClass();
                aoVar.j = new ff0.f(ff0Var, k90Var);
            } else {
                z2 = true;
            }
            aoVar.L0(pq0Var, wq0Var, new bt(rg0Var2.c(kr0Var, false)), new bt(rg0Var2.c(kr0Var, z2)));
            return aoVar;
        }
        rg0Var2 = this;
        wq0Var = wq0VarH;
        if (e.i(xt.C, i4)) {
            z2 = true;
            k90 k90Var2 = new k90(rg0Var2, kr0Var, aoVar, 1 == true ? 1 : 0);
            ff0Var.getClass();
            aoVar.j = new ff0.f(ff0Var, k90Var2);
        } else {
            z2 = true;
        }
        aoVar.L0(pq0Var, wq0Var, new bt(rg0Var2.c(kr0Var, false)), new bt(rg0Var2.c(kr0Var, z2)));
        return aoVar;
    }

    public final List h(List list, yx.c cVar, x3 x3Var) {
        rg0 rg0Var = this;
        hn hnVar = rg0Var.a;
        ja jaVar = (ja) hnVar.c;
        dg0 dg0VarA = rg0Var.a(jaVar.b());
        ArrayList arrayList = new ArrayList(ae.y0(list));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                e.q0();
                throw null;
            }
            rr0 rr0Var = (rr0) obj;
            int i3 = (rr0Var.d & 1) == 1 ? rr0Var.f : 0;
            s4 hl0Var = (dg0VarA == null || !e.i(xt.c, i3)) ? e4.f47a : new hl0(hnVar.a.a, rg0Var.new c(dg0VarA, cVar, x3Var, i, rr0Var));
            ij0 ij0VarE = e.E(hnVar.b, rr0Var.g);
            fi0 fi0Var = hnVar.d;
            nr0 nr0VarW0 = e.w0(rr0Var, fi0Var);
            e91 e91Var = hnVar.h;
            fc0 fc0VarF = e91Var.f(nr0VarW0);
            boolean zI = e.i(xt.G, i3);
            boolean zI2 = e.i(xt.H, i3);
            boolean zBooleanValue = xt.I.c(i3).booleanValue();
            int i4 = rr0Var.d;
            nr0 nr0VarA = (i4 & 16) == 16 ? rr0Var.n : (i4 & 32) == 32 ? fi0Var.a(rr0Var.o) : null;
            fc0 fc0VarF2 = nr0VarA != null ? e91Var.f(nr0VarA) : null;
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new wc1(jaVar, null, i, hl0Var, ij0VarE, fc0VarF, zI, zI2, zBooleanValue, fc0VarF2, t11.a));
            rg0Var = this;
            arrayList = arrayList2;
            i = i2;
        }
        return he.g1(arrayList);
    }
}
