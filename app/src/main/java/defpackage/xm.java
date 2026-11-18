package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class xm {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        new cv("kotlin.jvm.JvmName");
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case 21:
            case 23:
            case 24:
            case 34:
            case 35:
            case 36:
            case 57:
            case 58:
            case 59:
            case 61:
            case 79:
            case 92:
            case 94:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = "first";
                break;
            case 17:
                objArr[0] = "second";
                break;
            case 18:
            case 19:
                objArr[0] = "aClass";
                break;
            case 20:
                objArr[0] = "kotlinType";
                break;
            case 25:
                objArr[0] = "declarationDescriptor";
                break;
            case 26:
            case 28:
                objArr[0] = "subClass";
                break;
            case 27:
            case 29:
            case 33:
                objArr[0] = "superClass";
                break;
            case 30:
            case 32:
            case 45:
            case 64:
                objArr[0] = "type";
                break;
            case 31:
                objArr[0] = "other";
                break;
            case 37:
                objArr[0] = "classKind";
                break;
            case 38:
            case 39:
            case 41:
            case 44:
            case 48:
            case 54:
            case 65:
            case 66:
            case 67:
            case 74:
            case 75:
                objArr[0] = "classDescriptor";
                break;
            case 46:
                objArr[0] = "typeConstructor";
                break;
            case 55:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = "location";
                break;
            case 63:
                objArr[0] = "variable";
                break;
            case 68:
                objArr[0] = "f";
                break;
            case 70:
                objArr[0] = "current";
                break;
            case 71:
                objArr[0] = "result";
                break;
            case 72:
                objArr[0] = "memberDescriptor";
                break;
            case 76:
            case 77:
            case 78:
                objArr[0] = "annotated";
                break;
            case 82:
            case 84:
            case 87:
            case 89:
                objArr[0] = "scope";
                break;
            case 85:
            case 88:
            case 90:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 12:
                objArr[1] = "getClassIdForNonLocalClass";
                break;
            case 22:
                objArr[1] = "getContainingModule";
                break;
            case 40:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 42:
            case 43:
                objArr[1] = "getSuperClassType";
                break;
            case 47:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 62:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 69:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 73:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 80:
            case 81:
                objArr[1] = "getContainingSourceFile";
                break;
            case 83:
                objArr[1] = "getAllDescriptors";
                break;
            case 86:
                objArr[1] = "getFunctionByName";
                break;
            case 91:
                objArr[1] = "getPropertyByName";
                break;
            case 93:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "getClassIdForNonLocalClass";
                break;
            case 13:
                objArr[2] = "isExtension";
                break;
            case 14:
                objArr[2] = "isOverride";
                break;
            case 15:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case 17:
                objArr[2] = "areInSameModule";
                break;
            case 18:
            case 19:
                objArr[2] = "getParentOfType";
                break;
            case 20:
            case 23:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 21:
                objArr[2] = "getContainingModule";
                break;
            case 24:
                objArr[2] = "getContainingClass";
                break;
            case 25:
                objArr[2] = "isAncestor";
                break;
            case 26:
            case 27:
                objArr[2] = "isDirectSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSubclass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case 33:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 34:
                objArr[2] = "isAnonymousObject";
                break;
            case 35:
                objArr[2] = "isAnonymousFunction";
                break;
            case 36:
                objArr[2] = "isEnumEntry";
                break;
            case 37:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case 39:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 41:
                objArr[2] = "getSuperClassType";
                break;
            case 44:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 45:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case 55:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 61:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 63:
            case 64:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 65:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 66:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 67:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 68:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 70:
            case 71:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 72:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 74:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 75:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 76:
                objArr[2] = "getJvmName";
                break;
            case 77:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 78:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 79:
                objArr[2] = "getContainingSourceFile";
                break;
            case 82:
                objArr[2] = "getAllDescriptors";
                break;
            case 84:
            case 85:
                objArr[2] = "getFunctionByName";
                break;
            case 87:
            case 88:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 89:
            case 90:
                objArr[2] = "getPropertyByName";
                break;
            case 92:
                objArr[2] = "getDirectMember";
                break;
            case 94:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static void b(ja jaVar, LinkedHashSet linkedHashSet) {
        if (jaVar == null) {
            a(70);
            throw null;
        }
        if (linkedHashSet.contains(jaVar)) {
            return;
        }
        Iterator it = jaVar.a().d().iterator();
        while (it.hasNext()) {
            ja jaVarA = ((ja) it.next()).a();
            b(jaVarA, linkedHashSet);
            linkedHashSet.add(jaVarA);
        }
    }

    public static ai0 c(fc0 fc0Var) {
        if (fc0Var == null) {
            a(45);
            throw null;
        }
        a91 a91VarL0 = fc0Var.L0();
        if (a91VarL0 == null) {
            a(46);
            throw null;
        }
        ai0 ai0Var = (ai0) a91VarL0.b();
        if (ai0Var != null) {
            return ai0Var;
        }
        a(47);
        throw null;
    }

    public static gi0 d(ok okVar) {
        if (okVar == null) {
            a(21);
            throw null;
        }
        gi0 gi0VarE = e(okVar);
        if (gi0VarE != null) {
            return gi0VarE;
        }
        a(22);
        throw null;
    }

    public static gi0 e(ok okVar) {
        if (okVar == null) {
            a(23);
            throw null;
        }
        while (okVar != null) {
            if (okVar instanceof gi0) {
                return (gi0) okVar;
            }
            if (okVar instanceof vd0) {
                return ((vd0) okVar).d;
            }
            okVar = okVar.b();
        }
        return null;
    }

    public static void f(ok okVar) {
        if (okVar == null) {
            a(79);
            throw null;
        }
        if (okVar instanceof wq0) {
            okVar = ((wq0) okVar).X();
        }
        if (okVar instanceof qk) {
            ((qk) okVar).g().getClass();
        }
    }

    public static dv g(ok okVar) {
        if (okVar != null) {
            cv cvVarH = h(okVar);
            return cvVarH != null ? cvVarH.i() : g(okVar.b()).b(okVar.getName());
        }
        a(2);
        throw null;
    }

    public static cv h(ok okVar) {
        if (okVar == null) {
            a(5);
            throw null;
        }
        if ((okVar instanceof gi0) || pr.h(okVar)) {
            return cv.c;
        }
        if (okVar instanceof vd0) {
            return ((vd0) okVar).f;
        }
        if (okVar instanceof wn0) {
            return ((xn0) ((wn0) okVar)).g;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x000f A[LOOP:0: B:6:0x0006->B:10:0x000f, LOOP_END] */
    public static ok i(ok okVar, Class cls, boolean z) {
        ok okVarB;
        if (okVar == null) {
            return null;
        }
        if (z) {
        }
        for (okVarB = okVar.b(); okVarB != null; okVarB = okVarB.b()) {
            if (cls.isInstance(okVarB)) {
                return okVarB;
            }
        }
        return null;
    }

    public static boolean l(ok okVar) {
        return n(okVar, 6) && ((ai0) okVar).c0();
    }

    public static boolean n(ok okVar, int i) {
        if (i != 0) {
            return (okVar instanceof ai0) && ((ai0) okVar).v() == i;
        }
        a(37);
        throw null;
    }

    public static boolean o(ok okVar) {
        if (okVar == null) {
            a(1);
            throw null;
        }
        while (okVar != null) {
            if ((n(okVar, 1) && okVar.getName().equals(f21.a)) || ((okVar instanceof uk) && ((uk) okVar).getVisibility() == cn.f)) {
                return true;
            }
            okVar = okVar.b();
        }
        return false;
    }

    public static boolean p(fc0 fc0Var, ai0 ai0Var) {
        if (fc0Var == null) {
            a(30);
            throw null;
        }
        if (ai0Var == null) {
            a(31);
            throw null;
        }
        od odVarB = fc0Var.L0().b();
        if (odVarB == null) {
            return false;
        }
        ok okVarA = odVarB.a();
        return (okVarA instanceof od) && ai0Var.h().equals(((od) okVarA).h());
    }

    public static boolean q(pd pdVar) {
        return (n(pdVar, 1) || n(pdVar, 2)) && ((ai0) pdVar).p() == zh0.c;
    }

    public static boolean s(fc0 fc0Var, ai0 ai0Var) {
        if (fc0Var == null) {
            a(32);
            throw null;
        }
        if (ai0Var == null) {
            a(33);
            throw null;
        }
        if (p(fc0Var, ai0Var)) {
            return true;
        }
        Iterator it = fc0Var.L0().d().iterator();
        while (it.hasNext()) {
            if (s((fc0) it.next(), ai0Var)) {
                return true;
            }
        }
        return false;
    }

    public static boolean t(ok okVar) {
        return okVar != null && (okVar.b() instanceof wn0);
    }

    public static la u(la laVar) {
        if (laVar == null) {
            a(59);
            throw null;
        }
        while (laVar.getKind() == la.a.c) {
            Collection collectionD = laVar.d();
            if (collectionD.isEmpty()) {
                d.AnonymousClass0.m$3("Fake override should have at least one overridden descriptor: ", laVar);
                return null;
            }
            laVar = (la) collectionD.iterator().next();
        }
        return laVar;
    }
}
