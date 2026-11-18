package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class rx extends rk implements ox {
    public boolean A;
    public boolean B;
    public boolean C;
    public Collection D;
    public volatile lw E;
    public final ox F;
    public final la.a G;
    public ox H;
    public Map I;
    public List g;
    public List i;
    public fc0 j;
    public sc0 n;
    public sc0 o;
    public zh0 p;
    public cn.d q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements ox.a {
        public ea1 a;
        public ok b;
        public zh0 c;
        public cn.d d;
        public ox e;
        public la.a f;
        public List g;
        public sc0 h;
        public sc0 i;
        public fc0 j;
        public ij0 k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public uq q;
        public s4 r;
        public boolean s;
        public final LinkedHashMap t;
        public Boolean u;
        public boolean v;
        public final /* synthetic */ rx w;

        public a(rx rxVar, ea1 ea1Var, ok okVar, zh0 zh0Var, cn.d dVar, la.a aVar, List list, sc0 sc0Var, fc0 fc0Var) {
            if (okVar == null) {
                s(1);
                throw null;
            }
            if (fc0Var == null) {
                s(6);
                throw null;
            }
            this.w = rxVar;
            this.e = null;
            this.i = rxVar.o;
            this.l = true;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = rxVar.y;
            this.q = null;
            this.r = null;
            this.s = rxVar.z;
            this.t = new LinkedHashMap();
            this.u = null;
            this.v = false;
            this.a = ea1Var;
            this.b = okVar;
            this.c = zh0Var;
            this.d = dVar;
            this.f = aVar;
            this.g = list;
            this.h = sc0Var;
            this.j = fc0Var;
            this.k = null;
        }

        public static /* synthetic */ void s(int i) {
            String str;
            int i2;
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i2 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = "owner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = XMLRPC.TAG_NAME;
                    break;
                case 18:
                case 20:
                    objArr[0] = "parameters";
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    throw new IllegalStateException(str2);
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    throw new IllegalArgumentException(str2);
            }
        }

        @Override // ox.a
        public final ox.a a(List list) {
            this.g = list;
            return this;
        }

        @Override // ox.a
        /* JADX INFO: renamed from: b */
        public final ox.a mo6b() {
            Boolean bool = Boolean.TRUE;
            this.t.put(q50.M, bool);
            return this;
        }

        @Override // ox.a
        /* JADX INFO: renamed from: build */
        public final ox mo7build() {
            return this.w.L0(this);
        }

        @Override // ox.a
        public final ox.a c(cn.d dVar) {
            this.d = dVar;
            return this;
        }

        @Override // ox.a
        public final ox.a d(sc0 sc0Var) {
            this.i = sc0Var;
            return this;
        }

        @Override // ox.a
        public final ox.a f() {
            this.s = true;
            return this;
        }

        @Override // ox.a
        public final ox.a g(s4 s4Var) {
            this.r = s4Var;
            return this;
        }

        @Override // ox.a
        public final ox.a h() {
            this.l = false;
            return this;
        }

        @Override // ox.a
        public final ox.a i(zh0 zh0Var) {
            this.c = zh0Var;
            return this;
        }

        @Override // ox.a
        public final ox.a j() {
            this.q = uq.b;
            return this;
        }

        @Override // ox.a
        public final ox.a k() {
            this.p = true;
            return this;
        }

        @Override // ox.a
        public final ox.a l(ok okVar) {
            if (okVar != null) {
                this.b = okVar;
                return this;
            }
            s(7);
            throw null;
        }

        @Override // ox.a
        public final ox.a n() {
            this.f = la.a.c;
            return this;
        }

        @Override // ox.a
        public final ox.a o() {
            this.n = true;
            return this;
        }

        @Override // ox.a
        public final ox.a p(fc0 fc0Var) {
            if (fc0Var != null) {
                this.j = fc0Var;
                return this;
            }
            s(22);
            throw null;
        }

        @Override // ox.a
        public final ox.a q(ij0 ij0Var) {
            if (ij0Var != null) {
                this.k = ij0Var;
                return this;
            }
            s(16);
            throw null;
        }

        @Override // ox.a
        public final ox.a r() {
            this.m = true;
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rx(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var, ij0 ij0Var) {
        super(okVar, s4Var, ij0Var, t11Var);
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
        if (t11Var == null) {
            z(4);
            throw null;
        }
        this.q = cn.i;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = false;
        this.D = null;
        this.E = null;
        this.H = null;
        this.I = null;
        this.F = oxVar == null ? this : oxVar;
        this.G = aVar;
    }

    public static ArrayList M0(ox oxVar, List list, ha1 ha1Var, boolean z, boolean z2, boolean[] zArr) {
        if (list == null) {
            z(28);
            throw null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            wc1 wc1Var = (wc1) it.next();
            fc0 type = wc1Var.getType();
            ad1 ad1Var = ad1.IN_VARIANCE;
            fc0 fc0VarK = ha1Var.k(type, ad1Var);
            fc0 fc0Var = wc1Var.p;
            fc0 fc0VarK2 = fc0Var == null ? null : ha1Var.k(fc0Var, ad1Var);
            if (fc0VarK == null) {
                return null;
            }
            int i = 0;
            if ((fc0VarK != wc1Var.getType() || fc0Var != fc0VarK2) && zArr != null) {
                zArr[0] = true;
            }
            qx qxVar = wc1Var instanceof wc1.a ? new qx(i, (List) ((wc1.a) wc1Var).r.getValue()) : null;
            wc1 wc1Var2 = z ? null : wc1Var;
            int i2 = wc1Var.i;
            s4 annotations = wc1Var.getAnnotations();
            ij0 name = wc1Var.getName();
            boolean zB0 = wc1Var.B0();
            boolean z3 = wc1Var.n;
            boolean z4 = wc1Var.o;
            t11 t11VarG = z2 ? wc1Var.g() : t11.a;
            arrayList.add(qxVar == null ? new wc1(oxVar, wc1Var2, i2, annotations, name, fc0VarK, zB0, z3, z4, fc0VarK2, t11VarG) : new wc1.a(oxVar, wc1Var2, i2, annotations, name, fc0VarK, zB0, z3, z4, fc0VarK2, t11VarG, qxVar));
        }
        return arrayList;
    }

    public static /* synthetic */ void z(int i) {
        String str;
        int i2;
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i2 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
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
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = "copy";
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public boolean D() {
        return this.v;
    }

    @Override // defpackage.ox
    public final boolean D0() {
        return this.y;
    }

    public void E0(Collection collection) {
        if (collection == null) {
            z(15);
            throw null;
        }
        this.D = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((ox) it.next()).F0()) {
                this.z = true;
                return;
            }
        }
    }

    @Override // defpackage.ox
    public final boolean F0() {
        return this.z;
    }

    public final ox G0(ok okVar, zh0 zh0Var, cn.d dVar) {
        la.a aVar = la.a.b;
        ox oxVarMo7build = s().l(okVar).i(zh0Var).c(dVar).n().h().mo7build();
        if (oxVarMo7build != null) {
            return oxVarMo7build;
        }
        z(24);
        throw null;
    }

    @Override // defpackage.ox
    public final boolean H0() {
        if (this.s) {
            return true;
        }
        Iterator it = a().d().iterator();
        while (it.hasNext()) {
            if (((ox) it.next()).H0()) {
                return true;
            }
        }
        return false;
    }

    public abstract rx K0(la.a aVar, ok okVar, ox oxVar, t11 t11Var, s4 s4Var, ij0 ij0Var);

    public rx L0(a aVar) {
        sc0 sc0Var;
        lw pxVar;
        boolean[] zArr = new boolean[1];
        s4 s4VarN = aVar.r != null ? e.n(getAnnotations(), aVar.r) : getAnnotations();
        ok okVar = aVar.b;
        ox oxVar = aVar.e;
        la.a aVar2 = aVar.f;
        ij0 ij0Var = aVar.k;
        rx rxVarK0 = K0(aVar2, okVar, oxVar, aVar.n ? ((rk) (oxVar != null ? oxVar : a())).g() : t11.a, s4VarN, ij0Var);
        List typeParameters = aVar.q;
        if (typeParameters == null) {
            typeParameters = getTypeParameters();
        }
        char c = 0;
        zArr[0] = (zArr[0] ? 1 : 0) | (!typeParameters.isEmpty() ? 1 : 0);
        ArrayList arrayList = new ArrayList(typeParameters.size());
        ha1 ha1VarE0 = e.e0(typeParameters, aVar.a, rxVarK0, arrayList, zArr);
        sc0 sc0Var2 = null;
        if (ha1VarE0 != null) {
            sc0 sc0Var3 = aVar.h;
            if (sc0Var3 != null) {
                fc0 fc0VarK = ha1VarE0.k(sc0Var3.getType(), ad1.IN_VARIANCE);
                if (fc0VarK != null) {
                    aVar.h.getValue();
                    sc0 sc0Var4 = new sc0(rxVarK0, new os(rxVarK0, fc0VarK), aVar.h.getAnnotations());
                    zArr[0] = (fc0VarK != aVar.h.getType() ? (char) 1 : (char) 0) | (zArr[0] ? 1 : 0);
                    sc0Var = sc0Var4;
                }
            } else {
                sc0Var = null;
            }
            sc0 sc0Var5 = aVar.i;
            if (sc0Var5 != null) {
                sc0 sc0VarC = sc0Var5.c(ha1VarE0);
                if (sc0VarC != null) {
                    zArr[c] = (zArr[c] ? 1 : 0) | (sc0VarC != aVar.i ? (char) 1 : c);
                    sc0Var2 = sc0VarC;
                }
            }
            ArrayList arrayListM0 = M0(rxVarK0, aVar.g, ha1VarE0, aVar.o, aVar.n, zArr);
            if (arrayListM0 == null) {
                return sc0Var2;
            }
            fc0 fc0VarK2 = ha1VarE0.k(aVar.j, ad1.OUT_VARIANCE);
            if (fc0VarK2 == null) {
                return 0;
            }
            boolean z = (zArr[c] ? 1 : 0) | (fc0VarK2 != aVar.j ? (char) 1 : c);
            zArr[c] = z;
            if (z == 0 && aVar.v) {
                return this;
            }
            rxVarK0.N0(sc0Var, sc0Var2, arrayList, arrayListM0, fc0VarK2, aVar.c, aVar.d);
            rxVarK0.r = this.r;
            rxVarK0.s = this.s;
            rxVarK0.t = this.t;
            rxVarK0.u = this.u;
            rxVarK0.v = this.v;
            rxVarK0.A = this.A;
            rxVarK0.w = this.w;
            rxVarK0.Q0(this.B);
            rxVarK0.y = aVar.p;
            rxVarK0.z = aVar.s;
            Boolean bool = aVar.u;
            rxVarK0.R0(bool != null ? bool.booleanValue() : this.C);
            if (!aVar.t.isEmpty() || this.I != null) {
                LinkedHashMap linkedHashMap = aVar.t;
                Map map = this.I;
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (!linkedHashMap.containsKey(entry.getKey())) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                int size = linkedHashMap.size();
                Map mapSingletonMap = linkedHashMap;
                if (size == 1) {
                    mapSingletonMap = Collections.singletonMap(linkedHashMap.keySet().iterator().next(), linkedHashMap.values().iterator().next());
                }
                rxVarK0.I = mapSingletonMap;
            }
            if (aVar.m || this.H != null) {
                ox oxVar2 = this.H;
                if (oxVar2 == null) {
                    oxVar2 = this;
                }
                rxVarK0.H = oxVar2.c(ha1VarE0);
            }
            if (aVar.l && !a().d().isEmpty()) {
                if (aVar.a.e()) {
                    pxVar = this.E;
                    if (pxVar == null) {
                        rxVarK0.E0(d());
                        return rxVarK0;
                    }
                } else {
                    pxVar = new px(c, this, ha1VarE0);
                }
                rxVarK0.E = pxVar;
            }
            return rxVarK0;
        }
        return null;
    }

    @Override // defpackage.ja
    public final sc0 N() {
        return this.o;
    }

    public void N0(sc0 sc0Var, sc0 sc0Var2, List list, List list2, fc0 fc0Var, zh0 zh0Var, cn.d dVar) {
        if (list == null) {
            z(5);
            throw null;
        }
        if (list2 == null) {
            z(6);
            throw null;
        }
        if (dVar == null) {
            z(7);
            throw null;
        }
        this.g = he.g1(list);
        this.i = he.g1(list2);
        this.j = fc0Var;
        this.p = zh0Var;
        this.q = dVar;
        this.n = sc0Var;
        this.o = sc0Var2;
        for (int i = 0; i < list.size(); i++) {
            v91 v91Var = (v91) list.get(i);
            if (v91Var.getIndex() != i) {
                StringBuilder sb = new StringBuilder();
                sb.append(v91Var);
                int index = v91Var.getIndex();
                sb.append(" index is ");
                sb.append(index);
                sb.append(" but position is ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
            }
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            wc1 wc1Var = (wc1) list2.get(i2);
            if (wc1Var.i != i2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(wc1Var);
                int i3 = wc1Var.i;
                sb2.append("index is ");
                sb2.append(i3);
                sb2.append(" but position is ");
                sb2.append(i2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public final a O0(ha1 ha1Var) {
        if (ha1Var != null) {
            return new a(this, ha1Var.a, b(), p(), getVisibility(), getKind(), f(), this.n, getReturnType());
        }
        z(22);
        throw null;
    }

    @Override // defpackage.ja
    public final sc0 Q() {
        return this.n;
    }

    public void Q0(boolean z) {
        this.B = z;
    }

    public void R0(boolean z) {
        this.C = z;
    }

    @Override // defpackage.la
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public q01 w(ok okVar, zh0 zh0Var, cn.d dVar) {
        return (q01) G0(okVar, zh0Var, dVar);
    }

    @Override // defpackage.qg0
    public final boolean Z() {
        return false;
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public ox a() {
        ox oxVar = this.F;
        return oxVar == this ? this : oxVar.a();
    }

    public boolean b0() {
        return this.t;
    }

    @Override // defpackage.b41
    public ox c(ha1 ha1Var) {
        if (ha1Var == null) {
            z(20);
            throw null;
        }
        if (ha1Var.a.e()) {
            return this;
        }
        a aVarO0 = O0(ha1Var);
        aVarO0.e = a();
        aVarO0.n = true;
        aVarO0.v = true;
        return aVarO0.w.L0(aVarO0);
    }

    @Override // defpackage.la, defpackage.ja
    public Collection d() {
        lw lwVar = this.E;
        if (lwVar != null) {
            this.D = (Collection) lwVar.invoke();
            this.E = null;
        }
        Collection collection = this.D;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection != null) {
            return collection;
        }
        z(12);
        throw null;
    }

    @Override // defpackage.ja
    public final List f() {
        List list = this.i;
        if (list != null) {
            return list;
        }
        z(17);
        throw null;
    }

    @Override // defpackage.la
    public final la.a getKind() {
        la.a aVar = this.G;
        if (aVar != null) {
            return aVar;
        }
        z(19);
        throw null;
    }

    public fc0 getReturnType() {
        return this.j;
    }

    @Override // defpackage.ja
    public final List getTypeParameters() {
        List list = this.g;
        if (list != null) {
            return list;
        }
        d.AnonymousClass0.m$3("typeParameters == null for ", this);
        return null;
    }

    @Override // defpackage.uk, defpackage.qg0
    public final cn.d getVisibility() {
        cn.d dVar = this.q;
        if (dVar != null) {
            return dVar;
        }
        z(14);
        throw null;
    }

    public boolean h0() {
        return this.C;
    }

    public boolean isSuspend() {
        return this.A;
    }

    @Override // defpackage.qg0
    public final boolean l0() {
        return this.w;
    }

    public Object m0(fm$a fm_a) {
        Map map = this.I;
        if (map == null) {
            return null;
        }
        return map.get(fm_a);
    }

    @Override // defpackage.ox
    public final boolean n0() {
        if (this.r) {
            return true;
        }
        Iterator it = a().d().iterator();
        while (it.hasNext()) {
            if (((ox) it.next()).n0()) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.qg0
    public final zh0 p() {
        zh0 zh0Var = this.p;
        if (zh0Var != null) {
            return zh0Var;
        }
        z(13);
        throw null;
    }

    public boolean r() {
        return this.u;
    }

    @Override // defpackage.ok
    public Object r0(bj bjVar, Object obj) {
        return bjVar.e(this, obj);
    }

    public ox.a s() {
        return O0(ha1.b);
    }

    @Override // defpackage.ox
    public final ox v0() {
        return this.H;
    }
}
