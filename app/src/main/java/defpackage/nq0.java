package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class nq0 extends zc1 implements la {
    public ArrayList A;
    public pq0 B;
    public wq0 C;
    public bt D;
    public bt E;
    public final zh0 n;
    public cn.d o;
    public Collection p;
    public final nq0 q;
    public final la.a r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean w;
    public final boolean x;
    public sc0 y;
    public sc0 z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public ok a;
        public zh0 b;
        public cn.d c;
        public la.a e;
        public final sc0 h;
        public final ij0 i;
        public final fc0 j;
        public nq0 d = null;
        public ea1 f = ea1.a;
        public boolean g = true;

        public a() {
            this.a = nq0.this.b();
            this.b = nq0.this.p();
            this.c = nq0.this.getVisibility();
            this.e = nq0.this.getKind();
            this.h = nq0.this.y;
            this.i = nq0.this.getName();
            this.j = nq0.this.getType();
        }

        public final nq0 b() {
            sc0 sc0VarC;
            sc0 sc0Var;
            pq0 pq0Var;
            wq0 wq0Var;
            ha1 ha1Var;
            ff0.f fVar;
            ok okVar = this.a;
            zh0 zh0Var = this.b;
            cn.d dVar = this.c;
            nq0 nq0Var = this.d;
            la.a aVar = this.e;
            nq0 nq0Var2 = nq0.this;
            nq0 nq0VarG0 = nq0Var2.G0(okVar, zh0Var, dVar, nq0Var, aVar, this.i);
            List typeParameters = nq0Var2.getTypeParameters();
            ArrayList arrayList = new ArrayList(((ArrayList) typeParameters).size());
            ha1 ha1VarD0 = e.d0(typeParameters, this.f, nq0VarG0, arrayList);
            ad1 ad1Var = ad1.OUT_VARIANCE;
            fc0 fc0Var = this.j;
            fc0 fc0VarK = ha1VarD0.k(fc0Var, ad1Var);
            if (fc0VarK != null) {
                ad1 ad1Var2 = ad1.IN_VARIANCE;
                ha1VarD0.k(fc0Var, ad1Var2);
                sc0 sc0Var2 = this.h;
                if (sc0Var2 != null) {
                    sc0VarC = sc0Var2.c(ha1VarD0);
                    if (sc0VarC != null) {
                    }
                } else {
                    sc0VarC = null;
                }
                sc0 sc0Var3 = nq0Var2.z;
                if (sc0Var3 != null) {
                    fc0 fc0VarK2 = ha1VarD0.k(sc0Var3.getType(), ad1Var2);
                    if (fc0VarK2 != null) {
                        nq0Var2.z.getValue();
                        sc0Var = new sc0(nq0VarG0, new os(nq0VarG0, fc0VarK2), nq0Var2.z.getAnnotations());
                    }
                } else {
                    sc0Var = null;
                }
                nq0VarG0.N0(fc0VarK, arrayList, sc0VarC, sc0Var);
                pq0 pq0Var2 = nq0Var2.B;
                la.a aVar2 = la.a.c;
                ke keVar = t11.a;
                if (pq0Var2 == null) {
                    pq0Var = null;
                } else {
                    s4 annotations = pq0Var2.getAnnotations();
                    zh0 zh0Var2 = this.b;
                    cn.d visibility = nq0Var2.B.getVisibility();
                    if (this.e == aVar2 && cn.e(cn.g(visibility.a.c()))) {
                        visibility = cn.h;
                    }
                    cn.d dVar2 = visibility;
                    pq0 pq0Var3 = nq0Var2.B;
                    boolean z = pq0Var3.g;
                    boolean z2 = pq0Var3.i;
                    boolean z3 = pq0Var3.o;
                    la.a aVar3 = this.e;
                    nq0 nq0Var3 = this.d;
                    pq0Var = new pq0(nq0VarG0, annotations, zh0Var2, dVar2, z, z2, z3, aVar3, nq0Var3 == null ? null : nq0Var3.B, keVar);
                }
                if (pq0Var != null) {
                    pq0 pq0Var4 = nq0Var2.B;
                    fc0 fc0Var2 = pq0Var4.s;
                    ox oxVar = pq0Var4.r;
                    pq0Var.r = oxVar != null ? oxVar.c(ha1VarD0) : null;
                    fc0 fc0VarK3 = fc0Var2 != null ? ha1VarD0.k(fc0Var2, ad1Var) : null;
                    if (fc0VarK3 == null) {
                        fc0VarK3 = pq0Var.X().getType();
                    }
                    pq0Var.s = fc0VarK3;
                }
                wq0 wq0Var2 = nq0Var2.C;
                if (wq0Var2 == null) {
                    wq0Var = null;
                } else {
                    s4 annotations2 = wq0Var2.getAnnotations();
                    zh0 zh0Var3 = this.b;
                    cn.d visibility2 = nq0Var2.C.getVisibility();
                    if (this.e == aVar2 && cn.e(cn.g(visibility2.a.c()))) {
                        visibility2 = cn.h;
                    }
                    cn.d dVar3 = visibility2;
                    wq0 wq0Var3 = nq0Var2.C;
                    boolean z4 = wq0Var3.g;
                    boolean z5 = wq0Var3.i;
                    boolean z6 = wq0Var3.o;
                    la.a aVar4 = this.e;
                    nq0 nq0Var4 = this.d;
                    wq0Var = new wq0(nq0VarG0, annotations2, zh0Var3, dVar3, z4, z5, z6, aVar4, nq0Var4 == null ? null : nq0Var4.C, keVar);
                }
                if (wq0Var != null) {
                    ha1Var = ha1VarD0;
                    List listM0 = rx.M0(wq0Var, nq0Var2.C.f(), ha1Var, false, false, null);
                    if (listM0 == null) {
                        listM0 = Collections.singletonList(wq0.L0(wq0Var, ym.e(this.a).o(), ((wc1) nq0Var2.C.f().get(0)).getAnnotations()));
                    }
                    if (listM0.size() != 1) {
                        throw new IllegalStateException();
                    }
                    wq0 wq0Var4 = nq0Var2.C;
                    if (wq0Var4 == null) {
                        nq0.z(27);
                        throw null;
                    }
                    ox oxVar2 = wq0Var4.r;
                    wq0Var.r = oxVar2 != null ? oxVar2.c(ha1Var) : null;
                    wc1 wc1Var = (wc1) listM0.get(0);
                    if (wc1Var == null) {
                        wq0.z(6);
                        throw null;
                    }
                    wq0Var.s = wc1Var;
                } else {
                    ha1Var = ha1VarD0;
                }
                bt btVar = nq0Var2.D;
                bt btVar2 = btVar == null ? null : new bt(btVar.getAnnotations());
                bt btVar3 = nq0Var2.E;
                nq0VarG0.L0(pq0Var, wq0Var, btVar2, btVar3 != null ? new bt(btVar3.getAnnotations()) : null);
                if (this.g) {
                    o11 o11Var = new o11();
                    Iterator it = nq0Var2.d().iterator();
                    while (it.hasNext()) {
                        o11Var.add(((nq0) it.next()).c(ha1Var));
                    }
                    nq0VarG0.p = o11Var;
                }
                if (nq0Var2.isConst() && (fVar = nq0Var2.j) != null) {
                    nq0VarG0.j = fVar;
                }
                return nq0VarG0;
            }
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nq0(ok okVar, nq0 nq0Var, s4 s4Var, zh0 zh0Var, cn.d dVar, boolean z, ij0 ij0Var, la.a aVar, t11 t11Var, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        super(okVar, s4Var, ij0Var, z, t11Var);
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
            z(5);
            throw null;
        }
        this.p = null;
        this.n = zh0Var;
        this.o = dVar;
        this.q = nq0Var == null ? this : nq0Var;
        this.r = aVar;
        this.s = z2;
        this.t = z3;
        this.u = z4;
        this.w = z5;
        this.x = z6;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    public static /* synthetic */ void z(int i) {
        String str;
        int i2;
        if (i != 24 && i != 34 && i != 35 && i != 37 && i != 38) {
            switch (i) {
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 24 && i != 34 && i != 35 && i != 37 && i != 38) {
            switch (i) {
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
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
            case 17:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 5:
            case 12:
            case 31:
                objArr[0] = "kind";
                break;
            case 6:
            case 13:
            case 33:
                objArr[0] = "source";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 14:
                objArr[0] = "inType";
                break;
            case 15:
                objArr[0] = "outType";
                break;
            case 16:
                objArr[0] = "typeParameters";
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 34:
            case 35:
            case 37:
            case 38:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            case 23:
                objArr[0] = "originalSubstitutor";
                break;
            case 25:
                objArr[0] = "copyConfiguration";
                break;
            case 26:
                objArr[0] = "substitutor";
                break;
            case 27:
                objArr[0] = "accessorDescriptor";
                break;
            case 28:
                objArr[0] = "newOwner";
                break;
            case 29:
                objArr[0] = "newModality";
                break;
            case 30:
                objArr[0] = "newVisibility";
                break;
            case 32:
                objArr[0] = "newName";
                break;
            case 36:
                objArr[0] = "overriddenDescriptors";
                break;
        }
        if (i == 24) {
            objArr[1] = "getSourceToUseForCopy";
        } else if (i == 34) {
            objArr[1] = "getOriginal";
        } else if (i == 35) {
            objArr[1] = "getKind";
        } else if (i == 37) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i != 38) {
            switch (i) {
                case 18:
                    objArr[1] = "getTypeParameters";
                    break;
                case 19:
                    objArr[1] = "getReturnType";
                    break;
                case 20:
                    objArr[1] = "getModality";
                    break;
                case 21:
                    objArr[1] = "getVisibility";
                    break;
                case 22:
                    objArr[1] = "getAccessors";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[2] = "create";
                break;
            case 14:
                objArr[2] = "setInType";
                break;
            case 15:
            case 16:
                objArr[2] = "setType";
                break;
            case 17:
                objArr[2] = "setVisibility";
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 34:
            case 35:
            case 37:
            case 38:
                break;
            case 23:
                objArr[2] = "substitute";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
                objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 36:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 24 && i != 34 && i != 35 && i != 37 && i != 38) {
            switch (i) {
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    @Override // defpackage.la
    public final void E0(Collection collection) {
        this.p = collection;
    }

    public nq0 G0(ok okVar, zh0 zh0Var, cn.d dVar, nq0 nq0Var, la.a aVar, ij0 ij0Var) {
        if (okVar == null) {
            z(28);
            throw null;
        }
        if (zh0Var == null) {
            z(29);
            throw null;
        }
        if (dVar == null) {
            z(30);
            throw null;
        }
        if (aVar == null) {
            z(31);
            throw null;
        }
        if (ij0Var == null) {
            z(32);
            throw null;
        }
        return new nq0(okVar, nq0Var, getAnnotations(), zh0Var, dVar, this.i, ij0Var, aVar, t11.a, this.s, isConst(), this.u, b0(), this.x);
    }

    public final void L0(pq0 pq0Var, wq0 wq0Var, bt btVar, bt btVar2) {
        this.B = pq0Var;
        this.C = wq0Var;
        this.D = btVar;
        this.E = btVar2;
    }

    @Override // defpackage.yc1, defpackage.ja
    public final sc0 N() {
        return this.y;
    }

    public final void N0(fc0 fc0Var, List list, sc0 sc0Var, sc0 sc0Var2) {
        if (fc0Var == null) {
            z(15);
            throw null;
        }
        if (list == null) {
            z(16);
            throw null;
        }
        this.g = fc0Var;
        this.A = new ArrayList(list);
        this.z = sc0Var2;
        this.y = sc0Var;
    }

    @Override // defpackage.yc1, defpackage.ja
    public final sc0 Q() {
        return this.z;
    }

    @Override // defpackage.qg0
    public final boolean Z() {
        return false;
    }

    @Override // defpackage.rk
    public final nq0 a() {
        nq0 nq0Var = this.q;
        nq0 nq0VarA = nq0Var == this ? this : nq0Var.a();
        if (nq0VarA != null) {
            return nq0VarA;
        }
        z(34);
        throw null;
    }

    public boolean b0() {
        return this.w;
    }

    @Override // defpackage.b41
    public final nq0 c(ha1 ha1Var) {
        if (ha1Var == null) {
            z(23);
            throw null;
        }
        ea1 ea1Var = ha1Var.a;
        if (ea1Var.e()) {
            return this;
        }
        a aVar = new a();
        aVar.f = ea1Var;
        aVar.d = a();
        return aVar.b();
    }

    @Override // defpackage.ja
    public final Collection d() {
        Collection collection = this.p;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection != null) {
            return collection;
        }
        z(37);
        throw null;
    }

    @Override // defpackage.la
    public final la.a getKind() {
        la.a aVar = this.r;
        if (aVar != null) {
            return aVar;
        }
        z(35);
        throw null;
    }

    @Override // defpackage.yc1, defpackage.ja
    public final fc0 getReturnType() {
        return getType();
    }

    @Override // defpackage.yc1, defpackage.ja
    public final List getTypeParameters() {
        ArrayList arrayList = this.A;
        if (arrayList != null) {
            return arrayList;
        }
        throw new IllegalStateException("typeParameters == null for ".concat(pk.W(this)));
    }

    @Override // defpackage.uk, defpackage.qg0
    public final cn.d getVisibility() {
        cn.d dVar = this.o;
        if (dVar != null) {
            return dVar;
        }
        z(21);
        throw null;
    }

    @Override // defpackage.yc1
    public boolean isConst() {
        return this.t;
    }

    @Override // defpackage.qg0
    public final boolean l0() {
        return this.u;
    }

    @Override // defpackage.ja
    public Object m0(fm$a fm_a) {
        throw null;
    }

    @Override // defpackage.qg0
    public final zh0 p() {
        zh0 zh0Var = this.n;
        if (zh0Var != null) {
            return zh0Var;
        }
        z(20);
        throw null;
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        if (bjVar.G0 != 0) {
            nm.u((nm) bjVar.a, this, (StringBuilder) obj);
            return tb1.a;
        }
        int i = 0;
        int i2 = (this.y == null ? 0 : 1) + (this.z == null ? 0 : 1);
        p90 p90Var = (p90) bjVar.a;
        if (this.i) {
            if (i2 == 0) {
                return new y90(p90Var, this);
            }
            if (i2 == 1) {
                return new aa0(p90Var, this);
            }
            if (i2 == 2) {
                ba0 ba0Var = new ba0(p90Var, this);
                new nu0$b(new ca0(i, ba0Var));
                return ba0Var;
            }
        } else {
            if (i2 == 0) {
                return new la0(p90Var, this);
            }
            if (i2 == 1) {
                return new na0(p90Var, this);
            }
            if (i2 == 2) {
                return new oa0(p90Var, this);
            }
        }
        throw new yi(e4.j("Unsupported property: ", this));
    }

    @Override // defpackage.la
    public final la w(ai0 ai0Var, zh0 zh0Var, cn.d dVar) {
        la.a aVar = la.a.c;
        a aVar2 = new a();
        if (ai0Var == null) {
            ak.AnonymousClass1.m("Argument for @NotNull parameter 'owner' of kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration.setOwner must not be null");
            return null;
        }
        aVar2.a = ai0Var;
        aVar2.d = null;
        aVar2.b = zh0Var;
        aVar2.c = dVar;
        aVar2.e = aVar;
        aVar2.g = false;
        nq0 nq0VarB = aVar2.b();
        if (nq0VarB != null) {
            return nq0VarB;
        }
        z(38);
        throw null;
    }
}
