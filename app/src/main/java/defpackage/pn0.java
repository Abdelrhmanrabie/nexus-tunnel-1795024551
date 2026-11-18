package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.ServiceLoader;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class pn0 {
    public static final List c = he.g1(ServiceLoader.load(qs.class, qs.class.getClassLoader()));
    public static final pn0 d;
    public static final ke e;
    public final gc0.a b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b {
        public static final b b = new b(1);
        public final int a;

        public b(int i) {
            if (i != 0) {
                this.a = i;
            } else {
                a(3);
                throw null;
            }
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0031  */
        public static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 3 : 2];
            if (i == 1 || i == 2) {
                objArr[0] = "debugMessage";
            } else if (i == 3) {
                objArr[0] = "success";
            } else if (i != 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            } else {
                objArr[0] = "debugMessage";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
                case 5:
                    objArr[1] = "getResult";
                    break;
                case 6:
                    objArr[1] = "getDebugMessage";
                    break;
                default:
                    objArr[1] = "success";
                    break;
            }
            if (i == 1) {
                objArr[2] = "incompatible";
            } else if (i == 2) {
                objArr[2] = "conflict";
            } else if (i == 3 || i == 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4) {
                throw new IllegalStateException(str2);
            }
            throw new IllegalArgumentException(str2);
        }

        public static b d() {
            return new b(2);
        }

        public final int c() {
            int i = this.a;
            if (i != 0) {
                return i;
            }
            a(5);
            throw null;
        }
    }

    static {
        ke keVar = new ke(14);
        e = keVar;
        d = new pn0(keVar);
    }

    public pn0(gc0.a aVar) {
        if (aVar != null) {
            this.b = aVar;
        } else {
            a(4);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0199  */
    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[FALL_THROUGH] */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 95 && i != 98 && i != 103 && i != 44 && i != 45) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 90:
                                        case 91:
                                        case 92:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 95 && i != 98 && i != 103 && i != 44 && i != 45) {
            switch (i) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    i2 = 2;
                    break;
                default:
                    switch (i) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            i2 = 2;
                            break;
                        default:
                            switch (i) {
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    i2 = 2;
                                    break;
                                default:
                                    switch (i) {
                                        case 90:
                                        case 91:
                                        case 92:
                                            i2 = 2;
                                            break;
                                        default:
                                            i2 = 3;
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 5:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 3:
            default:
                objArr[0] = "equalityAxioms";
                break;
            case 4:
                objArr[0] = "axioms";
                break;
            case 6:
            case 7:
                objArr[0] = "candidateSet";
                break;
            case 8:
                objArr[0] = "transformFirst";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 44:
            case 45:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 90:
            case 91:
            case 92:
            case 95:
            case 98:
            case 103:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            case 11:
                objArr[0] = "f";
                break;
            case 12:
                objArr[0] = "g";
                break;
            case 13:
            case 15:
                objArr[0] = "descriptor";
                break;
            case 16:
                objArr[0] = "result";
                break;
            case 17:
            case 20:
            case 28:
            case 38:
                objArr[0] = "superDescriptor";
                break;
            case 18:
            case 21:
            case 29:
            case 39:
                objArr[0] = "subDescriptor";
                break;
            case 40:
            case 42:
                objArr[0] = "firstParameters";
                break;
            case 41:
            case 43:
                objArr[0] = "secondParameters";
                break;
            case 46:
                objArr[0] = "typeInSuper";
                break;
            case 47:
                objArr[0] = "typeInSub";
                break;
            case 48:
            case 51:
            case 77:
                objArr[0] = "typeChecker";
                break;
            case 49:
                objArr[0] = "superTypeParameter";
                break;
            case 50:
                objArr[0] = "subTypeParameter";
                break;
            case 52:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 53:
                objArr[0] = "membersFromSupertypes";
                break;
            case 54:
                objArr[0] = "membersFromCurrent";
                break;
            case 55:
            case 61:
            case 64:
            case 86:
            case 89:
            case 96:
                objArr[0] = "current";
                break;
            case 56:
            case 62:
            case 66:
            case 87:
            case 106:
                objArr[0] = "strategy";
                break;
            case 57:
                objArr[0] = "overriding";
                break;
            case 58:
                objArr[0] = "fromSuper";
                break;
            case 59:
                objArr[0] = "fromCurrent";
                break;
            case 60:
                objArr[0] = "descriptorsFromSuper";
                break;
            case 63:
            case 65:
                objArr[0] = "notOverridden";
                break;
            case 67:
            case 69:
            case 73:
                objArr[0] = "a";
                break;
            case 68:
            case 70:
            case 75:
                objArr[0] = "b";
                break;
            case 71:
                objArr[0] = "candidate";
                break;
            case 72:
            case 88:
            case 93:
            case 109:
                objArr[0] = "descriptors";
                break;
            case 74:
                objArr[0] = "aReturnType";
                break;
            case 76:
                objArr[0] = "bReturnType";
                break;
            case 78:
            case 85:
                objArr[0] = "overridables";
                break;
            case 79:
            case 101:
                objArr[0] = "descriptorByHandle";
                break;
            case 94:
                objArr[0] = "classModality";
                break;
            case 97:
                objArr[0] = "toFilter";
                break;
            case 99:
            case 104:
                objArr[0] = "overrider";
                break;
            case 100:
            case 105:
                objArr[0] = "extractFrom";
                break;
            case 102:
                objArr[0] = "onConflict";
                break;
            case 107:
            case 108:
                objArr[0] = "memberDescriptor";
                break;
        }
        if (i == 9 || i == 10) {
            objArr[1] = "filterOverrides";
        } else if (i == 14) {
            objArr[1] = "getOverriddenDeclarations";
        } else if (i == 19) {
            objArr[1] = "isOverridableBy";
        } else if (i == 95) {
            objArr[1] = "getMinimalModality";
        } else if (i == 98) {
            objArr[1] = "filterVisibleFakeOverrides";
        } else if (i == 103) {
            objArr[1] = "extractMembersOverridableInBothWays";
        } else if (i != 44 && i != 45) {
            switch (i) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    objArr[1] = "isOverridableBy";
                    break;
                default:
                    switch (i) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            objArr[1] = "isOverridableByWithoutExternalConditions";
                            break;
                        default:
                            switch (i) {
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    objArr[1] = "selectMostSpecificMember";
                                    break;
                                default:
                                    switch (i) {
                                        case 90:
                                        case 91:
                                        case 92:
                                            objArr[1] = "determineModalityForFakeOverride";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "createTypeCheckerState";
        }
        switch (i) {
            case 1:
                objArr[2] = "createWithTypeRefiner";
                break;
            case 2:
            case 3:
                objArr[2] = "create";
                break;
            case 4:
            case 5:
                objArr[2] = "<init>";
                break;
            case 6:
                objArr[2] = "filterOutOverridden";
                break;
            case 7:
            case 8:
                objArr[2] = "filterOverrides";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 44:
            case 45:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 90:
            case 91:
            case 92:
            case 95:
            case 98:
            case 103:
                break;
            case 11:
            case 12:
                objArr[2] = "overrides";
                break;
            case 13:
                objArr[2] = "getOverriddenDeclarations";
                break;
            case 15:
            case 16:
                objArr[2] = "collectOverriddenDeclarations";
                break;
            case 17:
            case 18:
            case 20:
            case 21:
                objArr[2] = "isOverridableBy";
                break;
            case 28:
            case 29:
                objArr[2] = "isOverridableByWithoutExternalConditions";
                break;
            case 38:
            case 39:
                objArr[2] = "getBasicOverridabilityProblem";
                break;
            case 40:
            case 41:
                objArr[2] = "createTypeChecker";
                break;
            case 42:
            case 43:
                objArr[2] = "createTypeCheckerState";
                break;
            case 46:
            case 47:
            case 48:
                objArr[2] = "areTypesEquivalent";
                break;
            case 49:
            case 50:
            case 51:
                objArr[2] = "areTypeParametersEquivalent";
                break;
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
                objArr[2] = "generateOverridesInFunctionGroup";
                break;
            case 57:
            case 58:
                objArr[2] = "isVisibleForOverride";
                break;
            case 59:
            case 60:
            case 61:
            case 62:
                objArr[2] = "extractAndBindOverridesForMember";
                break;
            case 63:
                objArr[2] = "allHasSameContainingDeclaration";
                break;
            case 64:
            case 65:
            case 66:
                objArr[2] = "createAndBindFakeOverrides";
                break;
            case 67:
            case 68:
                objArr[2] = "isMoreSpecific";
                break;
            case 69:
            case 70:
                objArr[2] = "isVisibilityMoreSpecific";
                break;
            case 71:
            case 72:
                objArr[2] = "isMoreSpecificThenAllOf";
                break;
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
                objArr[2] = "isReturnTypeMoreSpecific";
                break;
            case 78:
            case 79:
                objArr[2] = "selectMostSpecificMember";
                break;
            case 85:
            case 86:
            case 87:
                objArr[2] = "createAndBindFakeOverride";
                break;
            case 88:
            case 89:
                objArr[2] = "determineModalityForFakeOverride";
                break;
            case 93:
            case 94:
                objArr[2] = "getMinimalModality";
                break;
            case 96:
            case 97:
                objArr[2] = "filterVisibleFakeOverrides";
                break;
            case 99:
            case 100:
            case 101:
            case 102:
            case 104:
            case 105:
            case 106:
                objArr[2] = "extractMembersOverridableInBothWays";
                break;
            case 107:
                objArr[2] = "resolveUnknownVisibilityForMember";
                break;
            case 108:
                objArr[2] = "computeVisibilityToInherit";
                break;
            case 109:
                objArr[2] = "findMaxVisibility";
                break;
            default:
                objArr[2] = "createWithEqualityAxioms";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 95 && i != 98 && i != 103 && i != 44 && i != 45) {
            switch (i) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    switch (i) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                        default:
                            switch (i) {
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    break;
                                default:
                                    switch (i) {
                                        case 90:
                                        case 91:
                                        case 92:
                                            break;
                                        default:
                                            throw new IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(fc0 fc0Var, fc0 fc0Var2, jo0 jo0Var) {
        if (fc0Var == null) {
            a(46);
            throw null;
        }
        if (fc0Var2 == null) {
            a(47);
            throw null;
        }
        if (e.O(fc0Var) && e.O(fc0Var2)) {
            return true;
        }
        yk0 yk0Var = (yk0) jo0Var.b;
        z81 z81Var = (z81) jo0Var.c;
        cc1 cc1VarO0 = fc0Var.O0();
        cc1 cc1VarO1 = fc0Var2.O0();
        yk0Var.getClass();
        return e.y(z81Var, cc1VarO0, cc1VarO1);
    }

    public static void c(la laVar, LinkedHashSet linkedHashSet) {
        if (laVar == null) {
            a(15);
            throw null;
        }
        if (laVar.getKind() != la.a.c) {
            linkedHashSet.add(laVar);
        } else {
            if (laVar.d().isEmpty()) {
                d.AnonymousClass0.m$3("No overridden descriptors found for (fake override) ", laVar);
                return;
            }
            Iterator it = laVar.d().iterator();
            while (it.hasNext()) {
                c((la) it.next(), linkedHashSet);
            }
        }
    }

    public static ArrayList d(ja jaVar) {
        sc0 sc0VarQ = jaVar.Q();
        ArrayList arrayList = new ArrayList();
        if (sc0VarQ != null) {
            arrayList.add(sc0VarQ.getType());
        }
        Iterator it = jaVar.f().iterator();
        while (it.hasNext()) {
            arrayList.add(((wc1) it.next()).getType());
        }
        return arrayList;
    }

    public static void e(Collection collection, ai0 ai0Var, rd rdVar) {
        zh0 zh0Var;
        if (collection == null) {
            a(85);
            throw null;
        }
        if (ai0Var == null) {
            a(86);
            throw null;
        }
        j jVar = new j(1, ai0Var);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (((Boolean) jVar.invoke(obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        boolean zIsEmpty = arrayList.isEmpty();
        if (!zIsEmpty) {
            collection = arrayList;
        }
        Iterator it = collection.iterator();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            if (!it.hasNext()) {
                boolean zL0 = ai0Var.l0();
                zh0 zh0Var2 = zh0.f;
                if (zL0 && ai0Var.p() != zh0Var2 && ai0Var.p() != zh0.c) {
                    z = true;
                }
                if (z2 && !z3) {
                    zh0Var = zh0.d;
                    break;
                }
                if (!z2 && z3) {
                    zh0 zh0VarP = z ? ai0Var.p() : zh0Var2;
                    if (zh0VarP != null) {
                        zh0Var = zh0VarP;
                        break;
                    } else {
                        a(92);
                        throw null;
                    }
                }
                HashSet<la> hashSet = new HashSet();
                for (la laVar : collection) {
                    if (laVar == null) {
                        a(13);
                        throw null;
                    }
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    c(laVar, linkedHashSet);
                    hashSet.addAll(linkedHashSet);
                }
                if (!hashSet.isEmpty()) {
                    ok okVar = (ok) hashSet.iterator().next();
                    int i = ym.$r8$clinit;
                    if (xm.d(okVar).t0(e4.a) != null) {
                        d.AnonymousClass0.m$1();
                        return;
                    }
                }
                if (hashSet.size() > 1) {
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    for (Object obj2 : hashSet) {
                        Iterator it2 = linkedHashSet2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                linkedHashSet2.add(obj2);
                                break;
                            }
                            ja jaVar = (ja) obj2;
                            ja jaVar2 = (ja) it2.next();
                            if (!q(jaVar, jaVar2)) {
                                if (q(jaVar2, jaVar)) {
                                    break;
                                }
                            } else {
                                it2.remove();
                            }
                        }
                    }
                    hashSet = linkedHashSet2;
                }
                zh0 zh0VarP2 = ai0Var.p();
                if (zh0VarP2 == null) {
                    a(94);
                    throw null;
                }
                zh0 zh0Var3 = zh0Var2;
                for (la laVar2 : hashSet) {
                    zh0 zh0VarP3 = (z && laVar2.p() == zh0Var2) ? zh0VarP2 : laVar2.p();
                    if (zh0VarP3.compareTo(zh0Var3) < 0) {
                        zh0Var3 = zh0VarP3;
                    }
                }
                if (zh0Var3 != null) {
                    zh0Var = zh0Var3;
                    break;
                } else {
                    a(95);
                    throw null;
                }
            }
            la laVar3 = (la) it.next();
            int iOrdinal = laVar3.p().ordinal();
            if (iOrdinal == 0) {
                zh0Var = zh0.b;
                break;
            } else if (iOrdinal == 1) {
                d.AnonymousClass0.m$3("Member cannot have SEALED modality: ", laVar3);
                return;
            } else if (iOrdinal == 2) {
                z2 = true;
            } else if (iOrdinal == 3) {
                z3 = true;
            }
        }
        la laVarW = ((la) s(collection, new mu(4))).w(ai0Var, zh0Var, zIsEmpty ? cn.h : cn.g);
        rdVar.f(laVarW, collection);
        rdVar.a(laVarW);
    }

    public static ArrayList g(Object obj, LinkedList linkedList, nw nwVar, nw nwVar2) {
        if (obj == null) {
            a(99);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        ja jaVar = (ja) nwVar.invoke(obj);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            ja jaVar2 = (ja) nwVar.invoke(next);
            if (obj != next) {
                int iJ = j(jaVar, jaVar2);
                if (iJ == 1) {
                    arrayList.add(next);
                } else if (iJ == 3) {
                    nwVar2.invoke(next);
                }
            }
            it.remove();
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b i(ja jaVar, ja jaVar2) {
        boolean z;
        if (jaVar == 0) {
            a(38);
            throw null;
        }
        if (jaVar2 == 0) {
            a(39);
            throw null;
        }
        boolean z2 = jaVar instanceof ox;
        if ((!z2 || (jaVar2 instanceof ox)) && (!((z = jaVar instanceof nq0)) || (jaVar2 instanceof nq0))) {
            if (!z2 && !z) {
                d.AnonymousClass0.m("This type of CallableDescriptor cannot be checked for overridability: ", jaVar);
                return null;
            }
            if (((pk) jaVar).getName().equals(((pk) jaVar2).getName())) {
                b bVarD = ((jaVar.Q() == null) == (jaVar2.Q() == null) && jaVar.f().size() == jaVar2.f().size()) ? null : b.d();
                if (bVarD != null) {
                    return bVarD;
                }
                return null;
            }
        }
        return b.d();
    }

    public static int j(ja jaVar, ja jaVar2) {
        pn0 pn0Var = d;
        pn0Var.getClass();
        if (jaVar2 == null) {
            a(17);
            throw null;
        }
        if (jaVar == null) {
            a(18);
            throw null;
        }
        int iC = pn0Var.m(jaVar2, jaVar, null, false).c();
        int iC2 = pn0Var.m(jaVar, jaVar2, null, false).c();
        if (iC == 1 && iC2 == 1) {
            return 1;
        }
        return (iC == 3 || iC2 == 3) ? 3 : 2;
    }

    public static boolean k(ja jaVar, ja jaVar2) {
        if (jaVar == null) {
            a(67);
            throw null;
        }
        if (jaVar2 == null) {
            a(68);
            throw null;
        }
        fc0 returnType = jaVar.getReturnType();
        fc0 returnType2 = jaVar2.getReturnType();
        if (!p(jaVar, jaVar2)) {
            return false;
        }
        jo0 jo0VarF = d.f(jaVar.getTypeParameters(), jaVar2.getTypeParameters());
        if (jaVar instanceof ox) {
            return o(jaVar, returnType, jaVar2, returnType2, jo0VarF);
        }
        if (!(jaVar instanceof nq0)) {
            throw new IllegalArgumentException("Unexpected callable: " + jaVar.getClass());
        }
        nq0 nq0Var = (nq0) jaVar;
        nq0 nq0Var2 = (nq0) jaVar2;
        boolean z = nq0Var2.i;
        wq0 wq0Var = nq0Var.C;
        wq0 wq0Var2 = nq0Var2.C;
        if (!((wq0Var == null || wq0Var2 == null) ? true : p(wq0Var, wq0Var2))) {
            return false;
        }
        boolean z2 = nq0Var.i;
        if (!z2 || !z) {
            return (z2 || !z) && o(jaVar, returnType, jaVar2, returnType2, jo0VarF);
        }
        yk0 yk0Var = (yk0) jo0VarF.b;
        z81 z81Var = (z81) jo0VarF.c;
        cc1 cc1VarO0 = returnType.O0();
        cc1 cc1VarO1 = returnType2.O0();
        yk0Var.getClass();
        return e.y(z81Var, cc1VarO0, cc1VarO1);
    }

    public static boolean o(ja jaVar, fc0 fc0Var, ja jaVar2, fc0 fc0Var2, jo0 jo0Var) {
        if (jaVar == null) {
            a(73);
            throw null;
        }
        if (fc0Var == null) {
            a(74);
            throw null;
        }
        if (jaVar2 == null) {
            a(75);
            throw null;
        }
        if (fc0Var2 == null) {
            a(76);
            throw null;
        }
        yk0 yk0Var = (yk0) jo0Var.b;
        z81 z81Var = (z81) jo0Var.c;
        cc1 cc1VarO0 = fc0Var.O0();
        cc1 cc1VarO1 = fc0Var2.O0();
        yk0Var.getClass();
        return e.Q(z81Var, cc1VarO0, cc1VarO1);
    }

    public static boolean p(ja jaVar, ja jaVar2) {
        if (jaVar == null) {
            a(69);
            throw null;
        }
        if (jaVar2 != null) {
            Integer numB = cn.b(jaVar.getVisibility(), jaVar2.getVisibility());
            return numB == null || numB.intValue() >= 0;
        }
        a(70);
        throw null;
    }

    public static boolean q(ja jaVar, ja jaVar2) {
        if (jaVar == null) {
            a(11);
            throw null;
        }
        if (jaVar2 == null) {
            a(12);
            throw null;
        }
        boolean zEquals = jaVar.equals(jaVar2);
        e eVar = e.f31d;
        if (!zEquals && eVar.i((ok) jaVar.a(), (ok) jaVar2.a(), false)) {
            return true;
        }
        ja jaVarA = jaVar2.a();
        int i = xm.$r8$clinit;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        xm.b(jaVar.a(), linkedHashSet);
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            if (eVar.i((ok) jaVarA, (ok) it.next(), false)) {
                return true;
            }
        }
        return false;
    }

    public static void r(la laVar, nw nwVar) {
        cn.d dVar;
        cn.d dVarG;
        cn.d dVar2;
        if (laVar == null) {
            a(107);
            throw null;
        }
        for (la laVar2 : laVar.d()) {
            if (laVar2.getVisibility() == cn.g) {
                r(laVar2, nwVar);
            }
        }
        if (laVar.getVisibility() != cn.g) {
            return;
        }
        Collection<la> collectionD = laVar.d();
        if (collectionD == null) {
            a(109);
            throw null;
        }
        if (!collectionD.isEmpty()) {
            Iterator it = collectionD.iterator();
            loop3: while (true) {
                dVar = null;
                while (true) {
                    if (!it.hasNext()) {
                        break loop3;
                    }
                    cn.d visibility = ((la) it.next()).getVisibility();
                    if (dVar != null) {
                        Integer numB = cn.b(visibility, dVar);
                        if (numB != null) {
                            if (numB.intValue() > 0) {
                            }
                        }
                    }
                    dVar = visibility;
                }
            }
            if (dVar == null) {
                dVarG = null;
                break;
            }
            Iterator it2 = collectionD.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    dVarG = dVar;
                    break;
                }
                Integer numB2 = cn.b(dVar, ((la) it2.next()).getVisibility());
                if (numB2 == null || numB2.intValue() < 0) {
                    dVarG = null;
                    break;
                }
            }
        } else {
            dVarG = cn.k;
        }
        if (dVarG == null) {
            dVarG = null;
            break;
        }
        if (laVar.getKind() == la.a.c) {
            for (la laVar3 : collectionD) {
                if (laVar3.p() != zh0.f && !laVar3.getVisibility().equals(dVarG)) {
                    dVarG = null;
                    break;
                }
            }
        } else {
            dVarG = cn.g(dVarG.a.c());
        }
        if (dVarG == null) {
            if (nwVar != null) {
                nwVar.invoke(laVar);
            }
            dVar2 = cn.e;
        } else {
            dVar2 = dVarG;
        }
        if (!(laVar instanceof nq0)) {
            if (laVar instanceof rx) {
                ((rx) laVar).q = dVar2;
                return;
            }
            kq0 kq0Var = (kq0) laVar;
            kq0Var.q = dVar2;
            if (dVar2 != kq0Var.X().getVisibility()) {
                kq0Var.g = false;
                return;
            }
            return;
        }
        nq0 nq0Var = (nq0) laVar;
        nq0Var.o = dVar2;
        ArrayList arrayList = new ArrayList(2);
        pq0 pq0Var = nq0Var.B;
        if (pq0Var != null) {
            arrayList.add(pq0Var);
        }
        wq0 wq0Var = nq0Var.C;
        if (wq0Var != null) {
            arrayList.add(wq0Var);
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            r((kq0) it3.next(), dVarG == null ? null : nwVar);
        }
    }

    public static Object s(Collection collection, nw nwVar) {
        Object next;
        if (collection.size() == 1) {
            Object objJ0 = he.J0(collection);
            if (objJ0 != null) {
                return objJ0;
            }
            a(80);
            throw null;
        }
        ArrayList arrayList = new ArrayList(2);
        ArrayList arrayList2 = new ArrayList(ae.y0(collection));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList2.add(nwVar.invoke(it.next()));
        }
        Object objJ1 = he.J0(collection);
        ja jaVar = (ja) nwVar.invoke(objJ1);
        for (Object obj : collection) {
            ja jaVar2 = (ja) nwVar.invoke(obj);
            if (jaVar2 == null) {
                a(71);
                throw null;
            }
            Iterator it2 = arrayList2.iterator();
            do {
                if (!it2.hasNext()) {
                    arrayList.add(obj);
                    break;
                }
            } while (k(jaVar2, (ja) it2.next()));
            if (k(jaVar2, jaVar) && !k(jaVar, jaVar2)) {
                objJ1 = obj;
            }
        }
        if (arrayList.isEmpty()) {
            if (objJ1 != null) {
                return objJ1;
            }
            a(81);
            throw null;
        }
        if (arrayList.size() == 1) {
            Object objJ2 = he.J0(arrayList);
            if (objJ2 != null) {
                return objJ2;
            }
            a(82);
            throw null;
        }
        Iterator it3 = arrayList.iterator();
        do {
            if (!it3.hasNext()) {
                next = null;
                break;
            }
            next = it3.next();
        } while (((ja) nwVar.invoke(next)).getReturnType().O0() instanceof zt);
        if (next != null) {
            return next;
        }
        Object objJ3 = he.J0(arrayList);
        if (objJ3 != null) {
            return objJ3;
        }
        a(84);
        throw null;
    }

    public final jo0 f(List list, List list2) {
        g gVar;
        Object obj = null;
        if (list == null) {
            a(40);
            throw null;
        }
        if (list2 == null) {
            a(41);
            throw null;
        }
        yk0 yk0Var = new yk0();
        boolean zIsEmpty = list.isEmpty();
        gc0.a aVar = this.b;
        int i = 25;
        if (zIsEmpty) {
            gVar = new g(i, obj, aVar);
        } else {
            HashMap map = new HashMap();
            for (int i2 = 0; i2 < list.size(); i2++) {
                map.put(((v91) list.get(i2)).h(), ((v91) list2.get(i2)).h());
            }
            gVar = new g(i, map, aVar);
        }
        return new jo0(yk0Var, e.s(true, (ld) gVar, 8));
    }

    public final void h(ij0 ij0Var, Collection collection, Collection collection2, ai0 ai0Var, rd rdVar) {
        Integer numB;
        if (ij0Var == null) {
            a(52);
            throw null;
        }
        if (collection == null) {
            a(53);
            throw null;
        }
        if (collection2 == null) {
            a(54);
            throw null;
        }
        if (ai0Var == null) {
            a(55);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            la laVar = (la) it.next();
            if (laVar == null) {
                a(59);
                throw null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            o11 o11Var = new o11();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                la laVar2 = (la) it2.next();
                if (laVar2 == null) {
                    a(17);
                    throw null;
                }
                boolean z = false;
                int iC = m(laVar2, laVar, ai0Var, false).c();
                if (!cn.e(laVar2.getVisibility()) && cn.c(cn.m, laVar2, laVar) == null) {
                    z = true;
                }
                int iU = ak.u(iC);
                if (iU != 0) {
                    if (iU == 2) {
                        if (z) {
                            rdVar.g(laVar2, laVar);
                        }
                    }
                } else if (z) {
                    o11Var.add(laVar2);
                }
                arrayList.add(laVar2);
            }
            rdVar.f(laVar, o11Var);
            linkedHashSet.removeAll(arrayList);
        }
        if (linkedHashSet.size() >= 2) {
            ok okVarB = ((la) linkedHashSet.iterator().next()).b();
            if (!linkedHashSet.isEmpty()) {
                Iterator it3 = linkedHashSet.iterator();
                while (it3.hasNext()) {
                    if (((la) it3.next()).b() != okVarB) {
                        LinkedList<la> linkedList = new LinkedList(linkedHashSet);
                        while (!linkedList.isEmpty()) {
                            linkedList.isEmpty();
                            la laVar3 = null;
                            for (la laVar4 : linkedList) {
                                if (laVar3 == null || ((numB = cn.b(laVar3.getVisibility(), laVar4.getVisibility())) != null && numB.intValue() < 0)) {
                                    laVar3 = laVar4;
                                }
                            }
                            e(g(laVar3, linkedList, new mu(5), new tn0(rdVar, laVar3)), ai0Var, rdVar);
                        }
                        return;
                    }
                }
            }
        }
        Iterator it4 = linkedHashSet.iterator();
        while (it4.hasNext()) {
            e(Collections.singleton((la) it4.next()), ai0Var, rdVar);
        }
    }

    public final b m(ja jaVar, ja jaVar2, ai0 ai0Var, boolean z) {
        if (jaVar == null) {
            a(20);
            throw null;
        }
        if (jaVar2 == null) {
            a(21);
            throw null;
        }
        b bVarN = n(jaVar, jaVar2, z);
        boolean z2 = bVarN.c() == 1;
        List<qs> list = c;
        Iterator it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            qs.a aVar = qs.a.b;
            if (!zHasNext) {
                if (!z2) {
                    return bVarN;
                }
                for (qs qsVar : list) {
                    if (qsVar.a() == aVar) {
                        int iOrdinal = qsVar.b(jaVar, jaVar2, ai0Var).ordinal();
                        if (iOrdinal == 0) {
                            throw new IllegalStateException(ak.AnonymousClass0.m("Contract violation in ", qsVar.getClass().getName(), " condition. It's not supposed to end with success"));
                        }
                        if (iOrdinal == 1) {
                            return new b(3);
                        }
                        if (iOrdinal == 2) {
                            return b.d();
                        }
                    }
                }
                b bVar = b.b;
                if (bVar != null) {
                    return bVar;
                }
                b.a(0);
                throw null;
            }
            qs qsVar2 = (qs) it.next();
            if (qsVar2.a() != aVar && (!z2 || qsVar2.a() != qs.a.c)) {
                int iOrdinal2 = qsVar2.b(jaVar, jaVar2, ai0Var).ordinal();
                if (iOrdinal2 == 0) {
                    z2 = true;
                } else {
                    if (iOrdinal2 == 1) {
                        return new b(3);
                    }
                    if (iOrdinal2 == 2) {
                        return b.d();
                    }
                }
            }
        }
    }

    public final b n(ja jaVar, ja jaVar2, boolean z) {
        if (jaVar == null) {
            a(28);
            throw null;
        }
        if (jaVar2 == null) {
            a(29);
            throw null;
        }
        b bVarI = i(jaVar, jaVar2);
        if (bVarI != null) {
            return bVarI;
        }
        ArrayList arrayListD = d(jaVar);
        ArrayList arrayListD2 = d(jaVar2);
        List typeParameters = jaVar.getTypeParameters();
        List typeParameters2 = jaVar2.getTypeParameters();
        if (typeParameters.size() != typeParameters2.size()) {
            for (int i = 0; i < arrayListD.size(); i++) {
                if (!gc0.a.c((fc0) arrayListD.get(i), (fc0) arrayListD2.get(i))) {
                    return b.d();
                }
            }
            return new b(3);
        }
        jo0 jo0VarF = f(typeParameters, typeParameters2);
        for (int i2 = 0; i2 < typeParameters.size(); i2++) {
            v91 v91Var = (v91) typeParameters.get(i2);
            v91 v91Var2 = (v91) typeParameters2.get(i2);
            if (v91Var == null) {
                a(49);
                throw null;
            }
            if (v91Var2 == null) {
                a(50);
                throw null;
            }
            List<fc0> upperBounds = v91Var.getUpperBounds();
            ArrayList arrayList = new ArrayList(v91Var2.getUpperBounds());
            if (upperBounds.size() == arrayList.size()) {
                for (fc0 fc0Var : upperBounds) {
                    ListIterator listIterator = arrayList.listIterator();
                    do {
                        if (listIterator.hasNext()) {
                        }
                    } while (!b(fc0Var, (fc0) listIterator.next(), jo0VarF));
                    listIterator.remove();
                }
            }
            return b.d();
        }
        for (int i3 = 0; i3 < arrayListD.size(); i3++) {
            if (!b((fc0) arrayListD.get(i3), (fc0) arrayListD2.get(i3), jo0VarF)) {
                return b.d();
            }
        }
        if ((jaVar instanceof ox) && (jaVar2 instanceof ox) && ((ox) jaVar).isSuspend() != ((ox) jaVar2).isSuspend()) {
            return new b(3);
        }
        if (z) {
            fc0 returnType = jaVar.getReturnType();
            fc0 returnType2 = jaVar2.getReturnType();
            if (returnType != null && returnType2 != null && (!e.O(returnType2) || !e.O(returnType))) {
                yk0 yk0Var = (yk0) jo0VarF.b;
                z81 z81Var = (z81) jo0VarF.c;
                cc1 cc1VarO0 = returnType2.O0();
                cc1 cc1VarO1 = returnType.O0();
                yk0Var.getClass();
                if (!e.Q(z81Var, cc1VarO0, cc1VarO1)) {
                    return new b(3);
                }
            }
        }
        b bVar = b.b;
        if (bVar != null) {
            return bVar;
        }
        b.a(0);
        throw null;
    }
}
