package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ir extends zc {
    public final jd n;
    public final a o;
    public final ml0 p;
    public final s4 q;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends wg0 {
        public final ff0.c b;
        public final ff0.c c;
        public final ff0.h d;
        public final /* synthetic */ ir e;

        /* JADX INFO: renamed from: ir$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class C0033a implements nw {
            public final /* synthetic */ int G0;
            public final /* synthetic */ a b;

            public /* synthetic */ C0033a(a aVar, int i) {
                this.G0 = i;
                this.b = aVar;
            }

            @Override // defpackage.nw
            public final Object invoke(Object obj) {
                a aVar;
                Collection collectionA;
                ij0 ij0Var = (ij0) obj;
                if (this.G0 != 0) {
                    if (ij0Var == null) {
                        a.h(4);
                        throw null;
                    }
                    aVar = this.b;
                    collectionA = aVar.i().c(ij0Var, dl0.i);
                } else {
                    if (ij0Var == null) {
                        a.h(8);
                        throw null;
                    }
                    aVar = this.b;
                    collectionA = aVar.i().a(ij0Var, dl0.i);
                }
                return aVar.j(collectionA, ij0Var);
            }
        }

        public a(ir irVar, ff0 ff0Var) {
            int i = 0;
            if (ff0Var == null) {
                h(0);
                throw null;
            }
            this.e = irVar;
            this.b = ff0Var.g(new C0033a(this, i));
            int i2 = 1;
            this.c = ff0Var.g(new C0033a(this, i2));
            this.d = new ff0.h(ff0Var, new qx(i2, this));
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0014  */
        public static /* synthetic */ void h(int i) {
            String str;
            int i2;
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
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
                case 4:
                case 5:
                case 8:
                case 10:
                    objArr[0] = XMLRPC.TAG_NAME;
                    break;
                case 2:
                case 6:
                    objArr[0] = "location";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                    break;
                case 11:
                    objArr[0] = "fromSupertypes";
                    break;
                case 13:
                    objArr[0] = "kindFilter";
                    break;
                case 14:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 3) {
                objArr[1] = "getContributedVariables";
            } else if (i == 7) {
                objArr[1] = "getContributedFunctions";
            } else if (i == 9) {
                objArr[1] = "getSupertypeScope";
            } else if (i != 12) {
                switch (i) {
                    case 15:
                        objArr[1] = "getContributedDescriptors";
                        break;
                    case 16:
                        objArr[1] = "computeAllDeclarations";
                        break;
                    case 17:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 18:
                        objArr[1] = "getClassifierNames";
                        break;
                    case 19:
                        objArr[1] = "getVariableNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                        break;
                }
            } else {
                objArr[1] = "resolveFakeOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedVariables";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                case 4:
                    objArr[2] = "computeProperties";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 8:
                    objArr[2] = "computeFunctions";
                    break;
                case 10:
                case 11:
                    objArr[2] = "resolveFakeOverrides";
                    break;
                case 13:
                case 14:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // defpackage.wg0, defpackage.vg0
        public final Collection a(ij0 ij0Var, dl0 dl0Var) {
            if (ij0Var != null) {
                return (Collection) this.b.invoke(ij0Var);
            }
            h(5);
            throw null;
        }

        @Override // defpackage.wg0, defpackage.vg0
        public final Set b() {
            Set set = (Set) this.e.p.invoke();
            if (set != null) {
                return set;
            }
            h(17);
            throw null;
        }

        @Override // defpackage.wg0, defpackage.vg0
        public final Collection c(ij0 ij0Var, dl0 dl0Var) {
            if (ij0Var != null) {
                return (Collection) this.c.invoke(ij0Var);
            }
            h(1);
            throw null;
        }

        @Override // defpackage.wg0, defpackage.vg0
        public final Set d() {
            Set set = (Set) this.e.p.invoke();
            if (set != null) {
                return set;
            }
            h(19);
            throw null;
        }

        @Override // defpackage.wg0, defpackage.vg0
        public final Collection f(lm lmVar, nw nwVar) {
            if (lmVar == null) {
                h(13);
                throw null;
            }
            if (nwVar != null) {
                return (Collection) this.d.invoke();
            }
            h(14);
            throw null;
        }

        @Override // defpackage.wg0, defpackage.vg0
        public final Set g() {
            Set set = Collections.EMPTY_SET;
            if (set != null) {
                return set;
            }
            h(18);
            throw null;
        }

        public final vg0 i() {
            vg0 vg0VarM = ((fc0) ((s0) this.e.h()).d().iterator().next()).m();
            if (vg0VarM != null) {
                return vg0VarM;
            }
            h(9);
            throw null;
        }

        public final LinkedHashSet j(Collection collection, ij0 ij0Var) {
            if (ij0Var == null) {
                h(10);
                throw null;
            }
            if (collection == null) {
                h(11);
                throw null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            pn0.d.h(ij0Var, collection, Collections.EMPTY_SET, this.e, new jr(linkedHashSet, 0));
            return linkedHashSet;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ir(ff0 ff0Var, ai0 ai0Var, u01 u01Var, ij0 ij0Var, ml0 ml0Var, s4 s4Var, t11 t11Var) {
        super(ff0Var, ai0Var, ij0Var, t11Var);
        if (ff0Var == null) {
            i0(6);
            throw null;
        }
        if (ai0Var == null) {
            i0(7);
            throw null;
        }
        if (u01Var == null) {
            i0(8);
            throw null;
        }
        if (ij0Var == null) {
            i0(9);
            throw null;
        }
        if (ml0Var == null) {
            i0(10);
            throw null;
        }
        this.q = s4Var;
        this.n = new jd(this, Collections.EMPTY_LIST, Collections.singleton(u01Var), ff0Var);
        this.o = new a(this, ff0Var);
        this.p = ml0Var;
    }

    public static ir K0(ff0 ff0Var, ai0 ai0Var, ij0 ij0Var, ff0.h hVar, s4 s4Var, t11 t11Var) {
        if (ff0Var == null) {
            i0(0);
            throw null;
        }
        if (ai0Var == null) {
            i0(1);
            throw null;
        }
        if (ij0Var == null) {
            i0(2);
            throw null;
        }
        if (hVar != null) {
            return new ir(ff0Var, ai0Var, ai0Var.n(), ij0Var, hVar, s4Var, t11Var);
        }
        i0(3);
        throw null;
    }

    public static /* synthetic */ void i0(int i) {
        String str;
        int i2;
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // defpackage.ai0
    public final Collection A() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        i0(23);
        throw null;
    }

    @Override // defpackage.pd
    public final boolean B() {
        return false;
    }

    @Override // defpackage.ai0
    public final uc E() {
        return null;
    }

    @Override // defpackage.ai0
    public final boolean I0() {
        return false;
    }

    @Override // defpackage.ai0
    public final vg0 W(lc0$a lc0_a) {
        a aVar = this.o;
        if (aVar != null) {
            return aVar;
        }
        i0(14);
        throw null;
    }

    @Override // defpackage.qg0
    public final boolean Z() {
        return false;
    }

    @Override // defpackage.ai0
    public final boolean c0() {
        return false;
    }

    @Override // defpackage.ai0
    public final boolean f0() {
        return false;
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        s4 s4Var = this.q;
        if (s4Var != null) {
            return s4Var;
        }
        i0(21);
        throw null;
    }

    @Override // defpackage.ai0, defpackage.uk, defpackage.qg0
    public final cn.d getVisibility() {
        cn.d dVar = cn.e;
        if (dVar != null) {
            return dVar;
        }
        i0(20);
        throw null;
    }

    @Override // defpackage.od
    public final a91 h() {
        jd jdVar = this.n;
        if (jdVar != null) {
            return jdVar;
        }
        i0(17);
        throw null;
    }

    @Override // defpackage.ai0
    public final Collection i() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        i0(16);
        throw null;
    }

    @Override // defpackage.ai0
    public final boolean k0() {
        return false;
    }

    @Override // defpackage.qg0
    public final boolean l0() {
        return false;
    }

    @Override // defpackage.ai0, defpackage.pd
    public final List o() {
        List list = Collections.EMPTY_LIST;
        if (list != null) {
            return list;
        }
        i0(22);
        throw null;
    }

    @Override // defpackage.ai0
    public final vg0 o0() {
        return vg0.b.b;
    }

    @Override // defpackage.ai0, defpackage.qg0
    public final zh0 p() {
        return zh0.b;
    }

    @Override // defpackage.ai0
    public final boolean r() {
        return false;
    }

    @Override // defpackage.ai0
    public final i20 t() {
        return null;
    }

    public final String toString() {
        return "enum entry " + getName();
    }

    @Override // defpackage.ai0
    public final int v() {
        return 4;
    }
}
