package defpackage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ub0 {
    public static final ij0 e = ij0.h("<built-ins module>");
    public ji0 a;
    public final ff0.h b;
    public final ff0.c c;
    public final ff0 d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final EnumMap a;
        public final HashMap c;

        public a(EnumMap enumMap, HashMap map) {
            this.a = enumMap;
            this.c = map;
        }
    }

    public ub0(ff0 ff0Var) {
        this.d = ff0Var;
        ff0Var.h(new qb0(this, 0));
        this.b = new ff0.h(ff0Var, new qb0(this, 1));
        this.c = ff0Var.g(new j(2, this));
    }

    public static boolean A(ok okVar) {
        if (okVar != null) {
            return xm.i(okVar, v9.class, false) != null;
        }
        a(9);
        throw null;
    }

    public static boolean B(fc0 fc0Var, dv dvVar) {
        if (fc0Var == null) {
            a(97);
            throw null;
        }
        if (dvVar != null) {
            return J(fc0Var.L0(), dvVar);
        }
        a(98);
        throw null;
    }

    public static boolean C(fc0 fc0Var, dv dvVar) {
        return B(fc0Var, dvVar) && !fc0Var.M0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean D(ox oxVar) {
        if (oxVar.a().getAnnotations().f(m21.a.m)) {
            return true;
        }
        if (!(oxVar instanceof nq0)) {
            return false;
        }
        nq0 nq0Var = (nq0) oxVar;
        boolean z = nq0Var.i;
        pq0 pq0Var = nq0Var.B;
        wq0 wq0Var = nq0Var.C;
        if (pq0Var == null || !D(pq0Var)) {
            return false;
        }
        if (z) {
            return wq0Var != null && D(wq0Var);
        }
        return true;
    }

    public static boolean E(fc0 fc0Var, dv dvVar) {
        if (dvVar != null) {
            return !fc0Var.M0() && B(fc0Var, dvVar);
        }
        a(106);
        throw null;
    }

    public static boolean F(fc0 fc0Var) {
        if (fc0Var != null) {
            return B(fc0Var, m21.a.b) && !ma1.g(fc0Var);
        }
        a(136);
        throw null;
    }

    public static boolean G(fc0 fc0Var) {
        if (fc0Var == null) {
            a(94);
            throw null;
        }
        if (fc0Var.M0()) {
            return false;
        }
        od odVarB = fc0Var.L0().b();
        return (odVarB instanceof ai0) && u((ai0) odVarB) != null;
    }

    public static boolean J(a91 a91Var, dv dvVar) {
        if (a91Var == null) {
            a(101);
            throw null;
        }
        if (dvVar != null) {
            od odVarB = a91Var.b();
            return (odVarB instanceof ai0) && c((ai0) odVarB, dvVar);
        }
        a(102);
        throw null;
    }

    public static boolean K(od odVar) {
        if (odVar == null) {
            a(10);
            throw null;
        }
        for (ok okVarB = odVar; okVarB != null; okVarB = okVarB.b()) {
            if (okVarB instanceof wn0) {
                return ((xn0) ((wn0) okVarB)).g.h(m21.h);
            }
        }
        return false;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                i2 = 2;
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 72:
                objArr[0] = "module";
                break;
            case 2:
                objArr[0] = "computation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case 76:
            case 77:
            case 89:
            case 96:
            case 103:
            case 107:
            case 108:
            case 145:
            case 146:
            case 148:
            case 156:
            case 157:
            case 158:
            case 159:
                objArr[0] = "descriptor";
                break;
            case 12:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 135:
                objArr[0] = "fqName";
                break;
            case 14:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case 53:
            case 88:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 99:
            case 105:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case R.styleable.AppCompatTheme_windowMinWidthMajor /* 124 */:
            case R.styleable.AppCompatTheme_windowMinWidthMinor /* 125 */:
            case R.styleable.AppCompatTheme_windowNoTitle /* 126 */:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 147:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 161:
                objArr[0] = "type";
                break;
            case 46:
                objArr[0] = "classSimpleName";
                break;
            case 67:
                objArr[0] = "arrayType";
                break;
            case 71:
                objArr[0] = "notNullArrayType";
                break;
            case 73:
                objArr[0] = "primitiveType";
                break;
            case 75:
                objArr[0] = "kotlinType";
                break;
            case 78:
            case 82:
                objArr[0] = "projectionType";
                break;
            case 79:
            case 83:
            case 85:
                objArr[0] = "argument";
                break;
            case 80:
                objArr[0] = "annotations";
                break;
            case 101:
                objArr[0] = "typeConstructor";
                break;
            case 112:
                objArr[0] = "classDescriptor";
                break;
            case 160:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 3:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 4:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 5:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 6:
                objArr[1] = "getStorageManager";
                break;
            case 7:
                objArr[1] = "getBuiltInsModule";
                break;
            case 8:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 11:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 13:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 15:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 18:
                objArr[1] = "getSuspendFunction";
                break;
            case 19:
                objArr[1] = "getKFunction";
                break;
            case 20:
                objArr[1] = "getKSuspendFunction";
                break;
            case 21:
                objArr[1] = "getKClass";
                break;
            case 22:
                objArr[1] = "getKCallable";
                break;
            case 23:
                objArr[1] = "getKProperty";
                break;
            case 24:
                objArr[1] = "getKProperty0";
                break;
            case 25:
                objArr[1] = "getKProperty1";
                break;
            case 26:
                objArr[1] = "getKProperty2";
                break;
            case 27:
                objArr[1] = "getKMutableProperty0";
                break;
            case 28:
                objArr[1] = "getKMutableProperty1";
                break;
            case 29:
                objArr[1] = "getKMutableProperty2";
                break;
            case 30:
                objArr[1] = "getIterator";
                break;
            case 31:
                objArr[1] = "getIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterable";
                break;
            case 33:
                objArr[1] = "getMutableIterator";
                break;
            case 34:
                objArr[1] = "getCollection";
                break;
            case 35:
                objArr[1] = "getMutableCollection";
                break;
            case 36:
                objArr[1] = "getList";
                break;
            case 37:
                objArr[1] = "getMutableList";
                break;
            case 38:
                objArr[1] = "getSet";
                break;
            case 39:
                objArr[1] = "getMutableSet";
                break;
            case 40:
                objArr[1] = "getMap";
                break;
            case 41:
                objArr[1] = "getMutableMap";
                break;
            case 42:
                objArr[1] = "getMapEntry";
                break;
            case 43:
                objArr[1] = "getMutableMapEntry";
                break;
            case 44:
                objArr[1] = "getListIterator";
                break;
            case 45:
                objArr[1] = "getMutableListIterator";
                break;
            case 47:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 48:
                objArr[1] = "getNothingType";
                break;
            case 49:
                objArr[1] = "getNullableNothingType";
                break;
            case 50:
                objArr[1] = "getAnyType";
                break;
            case 51:
                objArr[1] = "getNullableAnyType";
                break;
            case 52:
                objArr[1] = "getDefaultBound";
                break;
            case 54:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 55:
                objArr[1] = "getNumberType";
                break;
            case 56:
                objArr[1] = "getByteType";
                break;
            case 57:
                objArr[1] = "getShortType";
                break;
            case 58:
                objArr[1] = "getIntType";
                break;
            case 59:
                objArr[1] = "getLongType";
                break;
            case 60:
                objArr[1] = "getFloatType";
                break;
            case 61:
                objArr[1] = "getDoubleType";
                break;
            case 62:
                objArr[1] = "getCharType";
                break;
            case 63:
                objArr[1] = "getBooleanType";
                break;
            case 64:
                objArr[1] = "getUnitType";
                break;
            case 65:
                objArr[1] = "getStringType";
                break;
            case 66:
                objArr[1] = "getIterableType";
                break;
            case 68:
            case 69:
            case 70:
                objArr[1] = "getArrayElementType";
                break;
            case 74:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 81:
            case 84:
                objArr[1] = "getArrayType";
                break;
            case 86:
                objArr[1] = "getEnumType";
                break;
            case 87:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
                objArr[2] = "setPostponedBuiltinsModuleComputation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                break;
            case 9:
                objArr[2] = "isBuiltIn";
                break;
            case 10:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 12:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 46:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 53:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 67:
                objArr[2] = "getArrayElementType";
                break;
            case 71:
            case 72:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 73:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 75:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 76:
            case 93:
                objArr[2] = "getPrimitiveType";
                break;
            case 77:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
                objArr[2] = "getArrayType";
                break;
            case 85:
                objArr[2] = "getEnumType";
                break;
            case 88:
                objArr[2] = "isArray";
                break;
            case 89:
            case 90:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 91:
                objArr[2] = "isPrimitiveArray";
                break;
            case 92:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 94:
                objArr[2] = "isPrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 96:
                objArr[2] = "isPrimitiveClass";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 101:
            case 102:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 103:
            case 104:
                objArr[2] = "classFqNameEquals";
                break;
            case 105:
            case 106:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 107:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 108:
            case 109:
                objArr[2] = "isAny";
                break;
            case 110:
            case 112:
                objArr[2] = "isBoolean";
                break;
            case 111:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 113:
                objArr[2] = "isNumber";
                break;
            case 114:
                objArr[2] = "isChar";
                break;
            case 115:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 116:
                objArr[2] = "isInt";
                break;
            case 117:
                objArr[2] = "isByte";
                break;
            case 118:
                objArr[2] = "isLong";
                break;
            case 119:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 120:
                objArr[2] = "isShort";
                break;
            case 121:
                objArr[2] = "isFloat";
                break;
            case 122:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 123:
                objArr[2] = "isDouble";
                break;
            case R.styleable.AppCompatTheme_windowMinWidthMajor /* 124 */:
                objArr[2] = "isUByte";
                break;
            case R.styleable.AppCompatTheme_windowMinWidthMinor /* 125 */:
                objArr[2] = "isUShort";
                break;
            case R.styleable.AppCompatTheme_windowNoTitle /* 126 */:
                objArr[2] = "isUInt";
                break;
            case 127:
                objArr[2] = "isULong";
                break;
            case 128:
                objArr[2] = "isUByteArray";
                break;
            case 129:
                objArr[2] = "isUShortArray";
                break;
            case 130:
                objArr[2] = "isUIntArray";
                break;
            case 131:
                objArr[2] = "isULongArray";
                break;
            case 132:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 133:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 134:
            case 135:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 136:
                objArr[2] = "isNothing";
                break;
            case 137:
                objArr[2] = "isNullableNothing";
                break;
            case 138:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 139:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 140:
                objArr[2] = "isNullableAny";
                break;
            case 141:
                objArr[2] = "isDefaultBound";
                break;
            case 142:
                objArr[2] = "isUnit";
                break;
            case 143:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 144:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 145:
                objArr[2] = "isMemberOfAny";
                break;
            case 146:
            case 147:
                objArr[2] = "isEnum";
                break;
            case 148:
            case 149:
                objArr[2] = "isComparable";
                break;
            case 150:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 151:
                objArr[2] = "isListOrNullableList";
                break;
            case 152:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 153:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 154:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 155:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 156:
                objArr[2] = "isThrowable";
                break;
            case 157:
                objArr[2] = "isKClass";
                break;
            case 158:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 159:
                objArr[2] = "isCloneable";
                break;
            case 160:
                objArr[2] = "isDeprecated";
                break;
            case 161:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean c(ai0 ai0Var, dv dvVar) {
        if (ai0Var == null) {
            a(103);
            throw null;
        }
        if (dvVar != null) {
            return ai0Var.getName().equals(dvVar.g()) && dvVar.equals(xm.g(ai0Var));
        }
        a(104);
        throw null;
    }

    public static wp0 s(od odVar) {
        if (odVar == null) {
            a(77);
            throw null;
        }
        if (m21.a.Z.contains(odVar.getName())) {
            return (wp0) m21.a.b0.get(xm.g(odVar));
        }
        return null;
    }

    public static wp0 u(ai0 ai0Var) {
        if (m21.a.Y.contains(ai0Var.getName())) {
            return (wp0) m21.a.a0.get(xm.g(ai0Var));
        }
        return null;
    }

    public static boolean y(fc0 fc0Var) {
        if (fc0Var != null) {
            return B(fc0Var, m21.a.a);
        }
        a(139);
        throw null;
    }

    public static boolean z(fc0 fc0Var) {
        if (fc0Var != null) {
            return B(fc0Var, m21.a.g);
        }
        a(88);
        throw null;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, rc0] */
    public final void d() {
        ij0 ij0Var = e;
        ff0 ff0Var = this.d;
        ji0 ji0Var = new ji0(ij0Var, ff0Var, this, 48);
        this.a = ji0Var;
        s9.a.getClass();
        s9 s9Var = (s9) s9.a.b.getValue();
        ji0 ji0Var2 = this.a;
        Iterable iterableM = m();
        yo0 yo0VarQ = q();
        f3 f3VarE = e();
        t9 t9Var = (t9) s9Var;
        t9Var.getClass();
        Set<cv> set = m21.m;
        n4 n4Var = new n4(1, t9Var.b, 4);
        ArrayList arrayList = new ArrayList(ae.y0(set));
        for (cv cvVar : set) {
            q9.m.getClass();
            String strA = q9.a(cvVar);
            InputStream inputStream = (InputStream) n4Var.invoke(strA);
            if (inputStream == null) {
                throw new IllegalStateException(e4.j("Resource not found in classpath: ", strA));
            }
            arrayList.add(ui.a(cvVar, ji0Var2, inputStream));
        }
        zn0 zn0Var = new zn0(arrayList);
        oo ooVar = new oo(ff0Var, ji0Var2);
        bj bjVar = new bj(28, zn0Var);
        q9 q9Var = q9.m;
        g gVar = new g(ji0Var2, ooVar, q9Var);
        e eVar = e.a$4;
        ps psVar = q9Var.a;
        new ke(ff0Var);
        fn fnVar = new fn(ff0Var, ji0Var2, bjVar, gVar, zn0Var, mr.a, eVar, iterableM, ooVar, f3VarE, yo0VarQ, psVar, null, 327680);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((v9) it.next()).K0(fnVar);
        }
        ji0Var.n = zn0Var;
        ji0 ji0Var3 = this.a;
        ji0Var3.getClass();
        ji0Var3.j = new fi0(ae.M0(new ji0[]{ji0Var3}));
    }

    public f3 e() {
        return e.a$9;
    }

    public final u01 f() {
        return k("Any").n();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x008f  */
    public final fc0 g(fc0 fc0Var) {
        u01 u01VarN;
        dd ddVarF;
        dd ddVar;
        ai0 ai0VarA;
        if (fc0Var == null) {
            a(67);
            throw null;
        }
        if (z(fc0Var)) {
            if (fc0Var.K0().size() != 1) {
                throw new IllegalStateException();
            }
            fc0 type = ((ca1) fc0Var.K0().get(0)).getType();
            if (type != null) {
                return type;
            }
            a(68);
            throw null;
        }
        cc1 cc1VarJ = ma1.j(fc0Var, false);
        fc0 fc0Var2 = (fc0) ((a) this.b.invoke()).c.get(cc1VarJ);
        if (fc0Var2 != null) {
            return fc0Var2;
        }
        int i = xm.$r8$clinit;
        od odVarB = cc1VarJ.L0().b();
        gi0 gi0VarE = odVarB == null ? null : xm.e(odVarB);
        if (gi0VarE != null) {
            od odVarB2 = cc1VarJ.L0().b();
            if (odVarB2 == null) {
                u01VarN = null;
            } else {
                Set set = ac1.a;
                if (!ac1.d.contains(odVarB2.getName()) || (ddVarF = ym.f(odVarB2)) == null || (ddVar = (dd) ac1.b.get(ddVarF)) == null || (ai0VarA = e4.a(gi0VarE, ddVar)) == null) {
                    u01VarN = null;
                } else {
                    u01VarN = ai0VarA.n();
                }
            }
            if (u01VarN != null) {
                return u01VarN;
            }
        }
        d.AnonymousClass0.m$3("not array: ", fc0Var);
        return null;
    }

    public final u01 h(cc1 cc1Var) {
        ad1 ad1Var = ad1.INVARIANT;
        if (cc1Var != null) {
            return i(ad1Var, cc1Var, e4.f47a);
        }
        a(83);
        throw null;
    }

    public final u01 i(ad1 ad1Var, fc0 fc0Var, s4 s4Var) {
        if (fc0Var != null) {
            return e4.f(s4Var, k("Array").h(), Collections.singletonList(new da1(fc0Var, ad1Var)), false);
        }
        a(79);
        throw null;
    }

    public final ai0 j(cv cvVar) {
        if (cvVar == null) {
            a(12);
            throw null;
        }
        ji0 ji0Var = this.a;
        ji0Var.getClass();
        ai0 ai0VarJ0 = e.j0(ji0Var, cvVar);
        if (ai0VarJ0 != null) {
            return ai0VarJ0;
        }
        a(13);
        throw null;
    }

    public final ai0 k(String str) {
        return (ai0) this.c.invoke(ij0.f(str));
    }

    public Iterable m() {
        ji0 ji0Var = this.a;
        ji0Var.getClass();
        List listSingletonList = Collections.singletonList(new p9(this.d, ji0Var));
        if (listSingletonList != null) {
            return listSingletonList;
        }
        a(5);
        throw null;
    }

    public final u01 o() {
        return k("Nothing").n();
    }

    public final u01 p() {
        u01 u01VarS0 = f().P0(true);
        if (u01VarS0 != null) {
            return u01VarS0;
        }
        a(51);
        throw null;
    }

    public yo0 q() {
        return zm.a$2;
    }

    public final u01 r(wp0 wp0Var) {
        if (wp0Var == null) {
            a(73);
            throw null;
        }
        u01 u01Var = (u01) ((a) this.b.invoke()).a.get(wp0Var);
        if (u01Var != null) {
            return u01Var;
        }
        a(74);
        throw null;
    }

    public final u01 t(wp0 wp0Var) {
        if (wp0Var != null) {
            return k(wp0Var.b.b()).n();
        }
        a(53);
        throw null;
    }

    public final u01 v() {
        return k("String").n();
    }

    public final u01 x() {
        return k("Unit").n();
    }
}
