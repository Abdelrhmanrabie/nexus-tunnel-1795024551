package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class pr {
    public static final a a = new a();
    public static final b b;
    public static final or c;
    public static final Set d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements gi0 {
        /* JADX WARN: Code duplicated, block: B:11:0x001a  */
        public static /* synthetic */ void z(int i) {
            String str;
            int i2;
            if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
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
                case 6:
                case 8:
                case 9:
                case 10:
                case 13:
                case 14:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                    break;
                case 2:
                case 7:
                    objArr[0] = "fqName";
                    break;
                case 3:
                    objArr[0] = "nameFilter";
                    break;
                case 11:
                    objArr[0] = "visitor";
                    break;
                case 12:
                    objArr[0] = "targetModule";
                    break;
                default:
                    objArr[0] = "capability";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getAnnotations";
            } else if (i == 4) {
                objArr[1] = "getSubPackagesOf";
            } else if (i == 5) {
                objArr[1] = "getName";
            } else if (i == 6) {
                objArr[1] = "getStableName";
            } else if (i == 13) {
                objArr[1] = "getOriginal";
            } else if (i != 14) {
                switch (i) {
                    case 8:
                        objArr[1] = "getAllDependencyModules";
                        break;
                    case 9:
                        objArr[1] = "getExpectedByModules";
                        break;
                    case 10:
                        objArr[1] = "getAllExpectedByModules";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                        break;
                }
            } else {
                objArr[1] = "getBuiltIns";
            }
            switch (i) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 13:
                case 14:
                    break;
                case 2:
                case 3:
                    objArr[2] = "getSubPackagesOf";
                    break;
                case 7:
                    objArr[2] = "getPackage";
                    break;
                case 11:
                    objArr[2] = "accept";
                    break;
                case 12:
                    objArr[2] = "shouldSeeInternalsOf";
                    break;
                default:
                    objArr[2] = "getCapability";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // defpackage.gi0
        public final void A0() {
        }

        @Override // defpackage.gi0
        public final vd0 U(cv cvVar) {
            if (cvVar != null) {
                throw new IllegalStateException("Should not be called!");
            }
            z(7);
            throw null;
        }

        @Override // defpackage.ok, defpackage.od
        public final ok a() {
            return this;
        }

        @Override // defpackage.ok
        public final ok b() {
            return null;
        }

        @Override // defpackage.w3
        public final s4 getAnnotations() {
            return e4.f47a;
        }

        @Override // defpackage.ok
        public final ij0 getName() {
            return ij0.h("<ERROR MODULE>");
        }

        @Override // defpackage.gi0
        public final ub0 k() {
            yk ykVar = yk.f;
            if (ykVar != null) {
                return ykVar;
            }
            z(14);
            throw null;
        }

        @Override // defpackage.ok
        public final Object r0(bj bjVar, Object obj) {
            return null;
        }

        @Override // defpackage.gi0
        public final Object t0(ci0 ci0Var) {
            return null;
        }

        @Override // defpackage.gi0
        public final boolean y(gi0 gi0Var) {
            return false;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends bd {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(ij0 ij0Var) {
            a aVar = pr.a;
            zh0 zh0Var = zh0.d;
            List list = Collections.EMPTY_LIST;
            super(aVar, ij0Var, zh0Var, 1, list, ff0.e);
            uc ucVar = new uc(this, null, e4.f47a, true, la.a.b, t11.a);
            ucVar.V0(list, cn.d);
            vg0 vg0VarC = pr.c(getName().b(), false);
            ucVar.j = new or(pr.f("<ERROR>", this), vg0VarC);
            K0(vg0VarC, Collections.singleton(ucVar), ucVar);
        }

        @Override // defpackage.k
        /* JADX INFO: renamed from: G0 */
        public final ai0 c(ha1 ha1Var) {
            if (ha1Var != null) {
                return this;
            }
            ak.AnonymousClass1.m("Argument for @NotNull parameter 'substitutor' of kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor.substitute must not be null");
            return null;
        }

        @Override // defpackage.k, defpackage.b41
        public final /* bridge */ /* synthetic */ qk c(ha1 ha1Var) {
            c(ha1Var);
            return this;
        }

        @Override // defpackage.bd
        public final String toString() {
            return getName().b();
        }

        @Override // defpackage.k, defpackage.ai0
        public final vg0 z(ea1 ea1Var, lc0$a lc0_a) {
            return pr.c("Error scope for class " + getName() + " with arguments: " + ea1Var, false);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c implements vg0 {
        public final String b;

        public c(String str) {
            if (str != null) {
                this.b = str;
            } else {
                h(0);
                throw null;
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x000d  */
        public static /* synthetic */ void h(int i) {
            String str;
            int i2;
            if (i != 7 && i != 18) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 7 && i != 18) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
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
                case 3:
                case 5:
                case 8:
                case 14:
                case 19:
                    objArr[0] = XMLRPC.TAG_NAME;
                    break;
                case 2:
                case 4:
                case 6:
                case 9:
                case 15:
                    objArr[0] = "location";
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                    break;
                case 16:
                    objArr[0] = "kindFilter";
                    break;
                case 17:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "debugMessage";
                    break;
            }
            if (i == 7) {
                objArr[1] = "getContributedVariables";
            } else if (i != 18) {
                switch (i) {
                    case 10:
                        objArr[1] = "getContributedFunctions";
                        break;
                    case 11:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 12:
                        objArr[1] = "getVariableNames";
                        break;
                    case 13:
                        objArr[1] = "getClassifierNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                        break;
                }
            } else {
                objArr[1] = "getContributedDescriptors";
            }
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    break;
                case 8:
                case 9:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 14:
                case 15:
                    objArr[2] = "recordLookup";
                    break;
                case 16:
                case 17:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 19:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 7 && i != 18) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // defpackage.vg0
        public final Collection a(ij0 ij0Var, dl0 dl0Var) {
            if (ij0Var == null) {
                h(8);
                throw null;
            }
            b bVar = pr.b;
            if (bVar == null) {
                nr.z(0);
                throw null;
            }
            nr nrVar = new nr(bVar, null, e4.f47a, ij0.h("<ERROR FUNCTION>"), la.a.b, t11.a);
            List list = Collections.EMPTY_LIST;
            nrVar.N0(null, null, list, list, pr.d("<ERROR FUNCTION RETURN TYPE>"), zh0.d, cn.e);
            Set setSingleton = Collections.singleton(nrVar);
            if (setSingleton != null) {
                return setSingleton;
            }
            h(10);
            throw null;
        }

        @Override // defpackage.vg0
        public final Set b() {
            Set set = Collections.EMPTY_SET;
            if (set != null) {
                return set;
            }
            h(11);
            throw null;
        }

        @Override // defpackage.vg0
        public final Collection c(ij0 ij0Var, dl0 dl0Var) {
            if (ij0Var == null) {
                h(5);
                throw null;
            }
            Set set = pr.d;
            if (set != null) {
                return set;
            }
            h(7);
            throw null;
        }

        @Override // defpackage.vg0
        public final Set d() {
            Set set = Collections.EMPTY_SET;
            if (set != null) {
                return set;
            }
            h(12);
            throw null;
        }

        @Override // defpackage.vg0
        public final od e(ij0 ij0Var, dl0 dl0Var) {
            if (ij0Var == null) {
                h(1);
                throw null;
            }
            return new b(ij0.h("<ERROR CLASS: " + ij0Var.b() + ">"));
        }

        @Override // defpackage.vg0
        public final Collection f(lm lmVar, nw nwVar) {
            if (lmVar == null) {
                h(16);
                throw null;
            }
            if (nwVar == null) {
                h(17);
                throw null;
            }
            List list = Collections.EMPTY_LIST;
            if (list != null) {
                return list;
            }
            h(18);
            throw null;
        }

        @Override // defpackage.vg0
        public final Set g() {
            Set set = Collections.EMPTY_SET;
            if (set != null) {
                return set;
            }
            h(13);
            throw null;
        }

        public final String toString() {
            return fb$1.m(new StringBuilder("ErrorScope{"), this.b, '}');
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d implements vg0 {
        public final String b;

        public d(String str) {
            if (str != null) {
                this.b = str;
            } else {
                h(0);
                throw null;
            }
        }

        public static /* synthetic */ void h(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = XMLRPC.TAG_NAME;
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = "location";
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.vg0
        public final Collection a(ij0 ij0Var, dl0 dl0Var) {
            if (ij0Var == null) {
                h(7);
                throw null;
            }
            throw new IllegalStateException(this.b + ", required name: " + ij0Var);
        }

        @Override // defpackage.vg0
        public final Set b() {
            throw new IllegalStateException();
        }

        @Override // defpackage.vg0
        public final Collection c(ij0 ij0Var, dl0 dl0Var) {
            if (ij0Var == null) {
                h(5);
                throw null;
            }
            throw new IllegalStateException(this.b + ", required name: " + ij0Var);
        }

        @Override // defpackage.vg0
        public final Set d() {
            throw new IllegalStateException();
        }

        @Override // defpackage.vg0
        public final od e(ij0 ij0Var, dl0 dl0Var) {
            if (ij0Var == null) {
                h(1);
                throw null;
            }
            throw new IllegalStateException(this.b + ", required name: " + ij0Var);
        }

        @Override // defpackage.vg0
        public final Collection f(lm lmVar, nw nwVar) {
            if (lmVar == null) {
                h(9);
                throw null;
            }
            if (nwVar != null) {
                throw new IllegalStateException(this.b);
            }
            h(10);
            throw null;
        }

        @Override // defpackage.vg0
        public final Set g() {
            throw new IllegalStateException();
        }

        public final String toString() {
            return fb$1.m(new StringBuilder("ThrowingScope{"), this.b, '}');
        }
    }

    static {
        b bVar = new b(ij0.h("<ERROR CLASS>"));
        b = bVar;
        c = d("<LOOP IN SUPERTYPES>");
        or orVarD = d("<ERROR PROPERTY TYPE>");
        nq0 nq0Var = new nq0(bVar, null, e4.f47a, zh0.d, cn.e, true, ij0.h("<ERROR PROPERTY>"), la.a.b, t11.a, false, false, false, false, false);
        nq0Var.N0(orVarD, Collections.EMPTY_LIST, null, null);
        d = Collections.singleton(nq0Var);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 6 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 6 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        if (i == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 6 && i != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static vg0 c(String str, boolean z) {
        if (str != null) {
            return z ? new d(str) : new c(str);
        }
        a(3);
        throw null;
    }

    public static or d(String str) {
        if (str != null) {
            return g(Collections.EMPTY_LIST, str);
        }
        a(7);
        throw null;
    }

    public static qr f(String str, b bVar) {
        if (bVar != null) {
            return new qr(str, bVar);
        }
        a(18);
        throw null;
    }

    public static or g(List list, String str) {
        if (str == null) {
            a(11);
            throw null;
        }
        if (list != null) {
            return new or(f(e.n("[ERROR : ", str, "]"), b), c(str, false), list, false, 16);
        }
        a(12);
        throw null;
    }

    public static boolean h(ok okVar) {
        if (okVar == null) {
            return false;
        }
        return (okVar instanceof b) || (okVar.b() instanceof b) || okVar == a;
    }
}
