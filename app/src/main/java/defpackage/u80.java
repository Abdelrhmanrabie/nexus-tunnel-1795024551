package defpackage;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum u80 {
    BOOLEAN(wp0.BOOLEAN, XMLRPC.TYPE_BOOLEAN, "Z", "java.lang.Boolean"),
    CHAR(wp0.CHAR, "char", "C", "java.lang.Character"),
    BYTE(wp0.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(wp0.SHORT, "short", "S", "java.lang.Short"),
    INT(wp0.INT, XMLRPC.TYPE_INT, "I", "java.lang.Integer"),
    FLOAT(wp0.FLOAT, "float", "F", "java.lang.Float"),
    LONG(wp0.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(wp0.DOUBLE, XMLRPC.TYPE_DOUBLE, "D", "java.lang.Double");

    public static final HashSet s = new HashSet();
    public static final HashMap t = new HashMap();
    public static final EnumMap u = new EnumMap(wp0.class);
    public static final HashMap v = new HashMap();
    public final wp0 b;
    public final String c;
    public final String d;
    public final cv f;

    static {
        for (u80 u80Var : values()) {
            s.add(u80Var.f());
            t.put(u80Var.c, u80Var);
            u.put(u80Var.d(), u80Var);
            v.put(u80Var.d, u80Var);
        }
    }

    u80(wp0 wp0Var, String str, String str2, String str3) {
        if (wp0Var == null) {
            a(6);
            throw null;
        }
        this.b = wp0Var;
        this.c = str;
        this.d = str2;
        this.f = new cv(str3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000c  */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 2 && i != 4) {
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
        if (i != 2 && i != 4) {
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
            case 7:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                break;
            case 3:
                objArr[0] = "type";
                break;
            case 5:
            case 8:
                objArr[0] = "desc";
                break;
            case 6:
                objArr[0] = "primitiveType";
                break;
            case 9:
                objArr[0] = "wrapperClassName";
                break;
            default:
                objArr[0] = "className";
                break;
        }
        if (i != 2 && i != 4) {
            switch (i) {
                case 10:
                    objArr[1] = "getPrimitiveType";
                    break;
                case 11:
                    objArr[1] = "getJavaKeywordName";
                    break;
                case 12:
                    objArr[1] = "getDesc";
                    break;
                case 13:
                    objArr[1] = "getWrapperFqName";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                    break;
            }
        } else {
            objArr[1] = "get";
        }
        switch (i) {
            case 1:
            case 3:
                objArr[2] = "get";
                break;
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 5:
                objArr[2] = "getByDesc";
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "isWrapperClassName";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 4) {
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

    public static u80 b(String str) {
        u80 u80Var = (u80) t.get(str);
        if (u80Var != null) {
            return u80Var;
        }
        throw new AssertionError("Non-primitive type name passed: ".concat(str));
    }

    public final wp0 d() {
        wp0 wp0Var = this.b;
        if (wp0Var != null) {
            return wp0Var;
        }
        a(10);
        throw null;
    }

    public final cv f() {
        cv cvVar = this.f;
        if (cvVar != null) {
            return cvVar;
        }
        a(13);
        throw null;
    }
}
