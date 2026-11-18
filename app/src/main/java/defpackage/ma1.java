package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ma1 {
    public static final or a = new or(pr.f("DONT_CARE", pr.b), pr.c("DONT_CARE", false));
    public static final or b = pr.d("Cannot be inferred");
    public static final a c = new a("NO_EXPECTED_TYPE");
    public static final a d = new a("UNIT_EXPECTED_TYPE");

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends tl {
        public final String c;

        public a(String str) {
            this.c = str;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0030  */
        public static /* synthetic */ void X0(int i) {
            String str = (i == 1 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 4) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else if (i == 2) {
                objArr[0] = "delegate";
            } else if (i == 3) {
                objArr[0] = "kotlinTypeRefiner";
            } else if (i != 4) {
                objArr[0] = "newAnnotations";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            }
            if (i == 1) {
                objArr[1] = "toString";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else {
                objArr[1] = "refine";
            }
            if (i != 1) {
                if (i == 2) {
                    objArr[2] = "replaceDelegate";
                } else if (i == 3) {
                    objArr[2] = "refine";
                } else if (i != 4) {
                    objArr[2] = "replaceAnnotations";
                }
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // defpackage.tl, defpackage.fc0
        /* JADX INFO: renamed from: N0 */
        public final fc0 Q0(lc0$a lc0_a) {
            if (lc0_a != null) {
                return this;
            }
            X0(3);
            throw null;
        }

        @Override // defpackage.u01, defpackage.cc1
        public final /* bridge */ /* synthetic */ cc1 P0(boolean z) {
            P0(z);
            throw null;
        }

        @Override // defpackage.tl, defpackage.cc1
        public final cc1 Q0(lc0$a lc0_a) {
            if (lc0_a != null) {
                return this;
            }
            X0(3);
            throw null;
        }

        @Override // defpackage.u01, defpackage.cc1
        public final /* bridge */ /* synthetic */ cc1 R0(t4 t4Var) {
            R0(t4Var);
            throw null;
        }

        @Override // defpackage.u01
        /* JADX INFO: renamed from: S0 */
        public final u01 P0(boolean z) {
            throw new IllegalStateException(this.c);
        }

        @Override // defpackage.u01
        /* JADX INFO: renamed from: T0 */
        public final u01 R0(s4 s4Var) {
            if (s4Var != null) {
                throw new IllegalStateException(this.c);
            }
            X0(0);
            throw null;
        }

        @Override // defpackage.tl
        public final u01 U0() {
            throw new IllegalStateException(this.c);
        }

        @Override // defpackage.tl
        /* JADX INFO: renamed from: V0 */
        public final u01 N0(lc0$a lc0_a) {
            if (lc0_a != null) {
                return this;
            }
            X0(3);
            throw null;
        }

        @Override // defpackage.tl
        public final tl W0(u01 u01Var) {
            if (u01Var != null) {
                throw new IllegalStateException(this.c);
            }
            X0(2);
            throw null;
        }

        @Override // defpackage.u01
        public final String toString() {
            return this.c;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:76:0x0111  */
    /* JADX WARN: Code duplicated, block: B:83:0x0126  */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 4 && i != 9 && i != 11 && i != 15 && i != 17 && i != 19 && i != 26 && i != 35 && i != 49 && i != 54 && i != 6 && i != 7) {
            switch (i) {
                case 57:
                case 58:
                case 59:
                case 60:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 4 && i != 9 && i != 11 && i != 15 && i != 17 && i != 19 && i != 26 && i != 35 && i != 49 && i != 54 && i != 6 && i != 7) {
            switch (i) {
                case 57:
                case 58:
                case 59:
                case 60:
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
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 49:
            case 54:
            case 57:
            case 58:
            case 59:
            case 60:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
            case 5:
            case 8:
            case 10:
            case 18:
            case 23:
            case 25:
            case 27:
            case 28:
            case 29:
            case 30:
            case 38:
            case 40:
            default:
                objArr[0] = "type";
                break;
            case 12:
                objArr[0] = "typeConstructor";
                break;
            case 13:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 14:
                objArr[0] = "refinedTypeFactory";
                break;
            case 16:
                objArr[0] = "parameters";
                break;
            case 20:
                objArr[0] = "subType";
                break;
            case 21:
                objArr[0] = "superType";
                break;
            case 22:
                objArr[0] = "substitutor";
                break;
            case 24:
                objArr[0] = "result";
                break;
            case 31:
            case 33:
                objArr[0] = "clazz";
                break;
            case 32:
                objArr[0] = "typeArguments";
                break;
            case 34:
                objArr[0] = "projections";
                break;
            case 36:
                objArr[0] = "a";
                break;
            case 37:
                objArr[0] = "b";
                break;
            case 39:
                objArr[0] = "typeParameters";
                break;
            case 41:
                objArr[0] = "typeParameterConstructors";
                break;
            case 42:
                objArr[0] = "specialType";
                break;
            case 43:
            case 44:
            case 46:
                objArr[0] = "isSpecialType";
                break;
            case 45:
                objArr[0] = "shouldStopAt";
                break;
            case 47:
                objArr[0] = "parameterDescriptor";
                break;
            case 48:
            case 52:
                objArr[0] = "numberValueTypeConstructor";
                break;
            case 50:
            case 51:
                objArr[0] = "supertypes";
                break;
            case 53:
            case 56:
                objArr[0] = "expectedType";
                break;
            case 55:
                objArr[0] = "literalTypeConstructor";
                break;
        }
        if (i == 4) {
            objArr[1] = "makeNullableAsSpecified";
        } else if (i == 9) {
            objArr[1] = "makeNullableIfNeeded";
        } else if (i == 11 || i == 15) {
            objArr[1] = "makeUnsubstitutedType";
        } else if (i == 17) {
            objArr[1] = "getDefaultTypeProjections";
        } else if (i == 19) {
            objArr[1] = "getImmediateSupertypes";
        } else if (i == 26) {
            objArr[1] = "getAllSupertypes";
        } else if (i == 35) {
            objArr[1] = "substituteProjectionsForParameters";
        } else if (i == 49) {
            objArr[1] = "getDefaultPrimitiveNumberType";
        } else if (i != 54) {
            if (i != 6 && i != 7) {
                switch (i) {
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                        objArr[1] = "getPrimitiveNumberType";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                        break;
                }
            } else {
                objArr[1] = "makeNullableIfNeeded";
            }
        } else {
            objArr[1] = "getPrimitiveNumberType";
        }
        switch (i) {
            case 1:
                objArr[2] = "makeNullable";
                break;
            case 2:
                objArr[2] = "makeNotNullable";
                break;
            case 3:
                objArr[2] = "makeNullableAsSpecified";
                break;
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 49:
            case 54:
            case 57:
            case 58:
            case 59:
            case 60:
                break;
            case 5:
            case 8:
                objArr[2] = "makeNullableIfNeeded";
                break;
            case 10:
                objArr[2] = "canHaveSubtypes";
                break;
            case 12:
            case 13:
            case 14:
                objArr[2] = "makeUnsubstitutedType";
                break;
            case 16:
                objArr[2] = "getDefaultTypeProjections";
                break;
            case 18:
                objArr[2] = "getImmediateSupertypes";
                break;
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedSupertype";
                break;
            case 23:
            case 24:
                objArr[2] = "collectAllSupertypes";
                break;
            case 25:
                objArr[2] = "getAllSupertypes";
                break;
            case 27:
                objArr[2] = "isNullableType";
                break;
            case 28:
                objArr[2] = "acceptsNullable";
                break;
            case 29:
                objArr[2] = "hasNullableSuperType";
                break;
            case 30:
                objArr[2] = "getClassDescriptor";
                break;
            case 31:
            case 32:
                objArr[2] = "substituteParameters";
                break;
            case 33:
            case 34:
                objArr[2] = "substituteProjectionsForParameters";
                break;
            case 36:
            case 37:
                objArr[2] = "equalTypes";
                break;
            case 38:
            case 39:
                objArr[2] = "dependsOnTypeParameters";
                break;
            case 40:
            case 41:
                objArr[2] = "dependsOnTypeConstructors";
                break;
            case 42:
            case 43:
            case 46:
                objArr[2] = "contains";
                break;
            case 44:
            case 45:
                objArr[2] = "containsStoppingAt";
                break;
            case 47:
                objArr[2] = "makeStarProjection";
                break;
            case 48:
            case 50:
                objArr[2] = "getDefaultPrimitiveNumberType";
                break;
            case 51:
                objArr[2] = "findByFqName";
                break;
            case 52:
            case 53:
            case 55:
            case 56:
                objArr[2] = "getPrimitiveNumberType";
                break;
            case 61:
                objArr[2] = "isTypeParameter";
                break;
            case 62:
                objArr[2] = "isReifiedTypeParameter";
                break;
            case 63:
                objArr[2] = "isNonReifiedTypeParameter";
                break;
            case 64:
                objArr[2] = "getTypeParameterDescriptorOrNull";
                break;
            default:
                objArr[2] = "noExpectedType";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 9 && i != 11 && i != 15 && i != 17 && i != 19 && i != 26 && i != 35 && i != 49 && i != 54 && i != 6 && i != 7) {
            switch (i) {
                case 57:
                case 58:
                case 59:
                case 60:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(fc0 fc0Var) {
        if (fc0Var == null) {
            a(28);
            throw null;
        }
        if (fc0Var.M0()) {
            return true;
        }
        return (fc0Var.O0() instanceof zt) && b(((zt) fc0Var.O0()).d);
    }

    public static boolean d(fc0 fc0Var, nw nwVar, ba baVar, o11 o11Var) {
        if (fc0Var == null) {
            return false;
        }
        cc1 cc1VarO0 = fc0Var.O0();
        if (p(fc0Var)) {
            return ((Boolean) nwVar.invoke(cc1VarO0)).booleanValue();
        }
        if (o11Var != null && o11Var.contains(fc0Var)) {
            return false;
        }
        if (((Boolean) nwVar.invoke(cc1VarO0)).booleanValue()) {
            return true;
        }
        if (baVar != null && (cc1VarO0 instanceof ls0)) {
            return false;
        }
        if (o11Var == null) {
            o11Var = new o11();
        }
        o11Var.add(fc0Var);
        zt ztVar = cc1VarO0 instanceof zt ? (zt) cc1VarO0 : null;
        if (ztVar != null && (d(ztVar.c, nwVar, baVar, o11Var) || d(ztVar.d, nwVar, baVar, o11Var))) {
            return true;
        }
        if ((cc1VarO0 instanceof ml) && d(((ml) cc1VarO0).c, nwVar, baVar, o11Var)) {
            return true;
        }
        a91 a91VarL0 = fc0Var.L0();
        if (a91VarL0 instanceof j30) {
            Iterator it = ((j30) a91VarL0).b.iterator();
            while (it.hasNext()) {
                if (d((fc0) it.next(), nwVar, baVar, o11Var)) {
                    return true;
                }
            }
            return false;
        }
        for (ca1 ca1Var : fc0Var.K0()) {
            if (!ca1Var.b()) {
                if (d(ca1Var.getType(), nwVar, baVar, o11Var)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List e(List list) {
        if (list == null) {
            a(16);
            throw null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new da1(((v91) it.next()).n()));
        }
        return he.g1(arrayList);
    }

    public static boolean g(fc0 fc0Var) {
        if (fc0Var == null) {
            a(27);
            throw null;
        }
        if (fc0Var.M0()) {
            return true;
        }
        if ((fc0Var.O0() instanceof zt) && g(((zt) fc0Var.O0()).d)) {
            return true;
        }
        if (fc0Var.O0() instanceof ml) {
            return false;
        }
        if (!h(fc0Var)) {
            a91 a91VarL0 = fc0Var.L0();
            if (!(a91VarL0 instanceof j30)) {
                return false;
            }
            Iterator it = ((j30) a91VarL0).b.iterator();
            while (it.hasNext()) {
                if (g((fc0) it.next())) {
                    return true;
                }
            }
            return false;
        }
        if (fc0Var.L0().b() instanceof ai0) {
            return false;
        }
        ha1 ha1VarD = ha1.d(fc0Var);
        Collection<fc0> collectionD = fc0Var.L0().d();
        ArrayList arrayList = new ArrayList(collectionD.size());
        for (fc0 fc0Var2 : collectionD) {
            if (fc0Var2 == null) {
                a(21);
                throw null;
            }
            fc0 fc0VarK = ha1VarD.k(fc0Var2, ad1.INVARIANT);
            fc0 fc0VarK2 = fc0VarK != null ? k(fc0VarK, fc0Var.M0()) : null;
            if (fc0VarK2 != null) {
                arrayList.add(fc0VarK2);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (g((fc0) it2.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(fc0 fc0Var) {
        if (fc0Var == null) {
            a(61);
            throw null;
        }
        if ((fc0Var.L0().b() instanceof v91 ? (v91) fc0Var.L0().b() : null) != null) {
            return true;
        }
        fc0Var.L0();
        return false;
    }

    public static cc1 j(fc0 fc0Var, boolean z) {
        if (fc0Var == null) {
            a(3);
            throw null;
        }
        cc1 cc1VarP0 = fc0Var.O0().P0(z);
        if (cc1VarP0 != null) {
            return cc1VarP0;
        }
        a(4);
        throw null;
    }

    public static fc0 k(fc0 fc0Var, boolean z) {
        if (fc0Var != null) {
            return z ? j(fc0Var, true) : fc0Var;
        }
        a(8);
        throw null;
    }

    public static da1 m(v91 v91Var) {
        if (v91Var != null) {
            return new da1(v91Var);
        }
        a(47);
        throw null;
    }

    public static u01 n(od odVar, vg0 vg0Var, nw nwVar) {
        if (pr.h(odVar)) {
            return pr.d("Unsubstituted type for " + odVar);
        }
        a91 a91VarH = odVar.h();
        if (a91VarH == null) {
            a(12);
            throw null;
        }
        if (vg0Var != null) {
            return e4.g(e4.f47a, a91VarH, e(a91VarH.getParameters()), false, vg0Var, nwVar);
        }
        a(13);
        throw null;
    }

    public static boolean p(fc0 fc0Var) {
        if (fc0Var != null) {
            return fc0Var == c || fc0Var == d;
        }
        a(0);
        throw null;
    }
}
