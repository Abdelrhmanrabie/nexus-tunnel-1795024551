package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class y0 extends rk implements v91 {
    public final ad1 g;
    public final boolean i;
    public final int j;
    public final ff0.h n;
    public final ff0.h o;
    public final ff0 p;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends s0 {
        public final ke c;
        public final /* synthetic */ y0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y0 y0Var, ff0 ff0Var, ke keVar) {
            super(ff0Var);
            if (ff0Var == null) {
                o(0);
                throw null;
            }
            this.d = y0Var;
            this.c = keVar;
        }

        public static /* synthetic */ void o(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // defpackage.a91
        public final od b() {
            return this.d;
        }

        @Override // defpackage.a91
        public final boolean c() {
            return true;
        }

        @Override // defpackage.s0
        public final boolean e(od odVar) {
            if (!(odVar instanceof v91)) {
                return false;
            }
            return e.f31d.j(this.d, (v91) odVar, true, gm.b$1);
        }

        @Override // defpackage.s0
        public final Collection g() {
            List listL0 = this.d.L0();
            if (listL0 != null) {
                return listL0;
            }
            o(1);
            throw null;
        }

        @Override // defpackage.a91
        public final List getParameters() {
            List list = Collections.EMPTY_LIST;
            if (list != null) {
                return list;
            }
            o(2);
            throw null;
        }

        @Override // defpackage.s0
        public final fc0 h() {
            return pr.d("Cyclic upper bounds");
        }

        @Override // defpackage.s0
        public final ke j() {
            ke keVar = this.c;
            if (keVar != null) {
                return keVar;
            }
            o(5);
            throw null;
        }

        @Override // defpackage.a91
        public final ub0 k() {
            ub0 ub0VarE = ym.e(this.d);
            if (ub0VarE != null) {
                return ub0VarE;
            }
            o(4);
            throw null;
        }

        @Override // defpackage.s0
        public final List m(List list) {
            List listG0 = this.d.G0(list);
            if (listG0 != null) {
                return listG0;
            }
            o(8);
            throw null;
        }

        public final String toString() {
            return this.d.getName().b;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(ff0 ff0Var, ok okVar, s4 s4Var, ij0 ij0Var, ad1 ad1Var, boolean z, int i, ke keVar) {
        super(okVar, s4Var, ij0Var, t11.a);
        if (ff0Var == null) {
            z(0);
            throw null;
        }
        if (okVar == null) {
            z(1);
            throw null;
        }
        int i2 = 2;
        if (s4Var == null) {
            z(2);
            throw null;
        }
        if (ij0Var == null) {
            z(3);
            throw null;
        }
        if (ad1Var == null) {
            z(4);
            throw null;
        }
        if (keVar == null) {
            z(6);
            throw null;
        }
        this.g = ad1Var;
        this.i = z;
        this.j = i;
        this.n = new ff0.h(ff0Var, new v0(this, ff0Var, keVar));
        this.o = new ff0.h(ff0Var, new px(i2, this, ij0Var));
        this.p = ff0Var;
    }

    public static /* synthetic */ void z(int i) {
        String str;
        int i2;
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public List G0(List list) {
        return list;
    }

    public abstract List L0();

    @Override // defpackage.v91
    public final ff0 O() {
        ff0 ff0Var = this.p;
        if (ff0Var != null) {
            return ff0Var;
        }
        z(14);
        throw null;
    }

    @Override // defpackage.v91
    public final boolean S() {
        return false;
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final od a() {
        return this;
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final ok a() {
        return this;
    }

    @Override // defpackage.rk, defpackage.pk, defpackage.ok, defpackage.od
    public final v91 a() {
        return this;
    }

    @Override // defpackage.v91
    public final int getIndex() {
        return this.j;
    }

    @Override // defpackage.v91
    public final List getUpperBounds() {
        List listD = ((a) h()).d();
        if (listD != null) {
            return listD;
        }
        z(8);
        throw null;
    }

    @Override // defpackage.od
    public final a91 h() {
        return (a91) this.n.invoke();
    }

    @Override // defpackage.rk
    /* JADX INFO: renamed from: i0 */
    public final qk a() {
        return this;
    }

    @Override // defpackage.v91
    public final ad1 j() {
        ad1 ad1Var = this.g;
        if (ad1Var != null) {
            return ad1Var;
        }
        z(7);
        throw null;
    }

    @Override // defpackage.od
    public final u01 n() {
        return (u01) this.o.invoke();
    }

    @Override // defpackage.ok
    public final Object r0(bj bjVar, Object obj) {
        ((nm) bjVar.a).c0(this, (StringBuilder) obj, true);
        return tb1.a;
    }

    @Override // defpackage.v91
    public final boolean x() {
        return this.i;
    }
}
