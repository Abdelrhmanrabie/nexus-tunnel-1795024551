package defpackage;

import net.lingala.zip4j.util.InternalZipConstants;
import net.openvpn.ovpn3.XMLRPC;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dd {
    public final cv a;
    public final cv b;
    public final boolean c;

    public dd(cv cvVar, cv cvVar2, boolean z) {
        if (cvVar == null) {
            a(1);
            throw null;
        }
        this.a = cvVar;
        this.b = cvVar2;
        this.c = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public dd(cv cvVar, ij0 ij0Var) {
        this(cvVar, cv.j(ij0Var), false);
        if (cvVar == null) {
            a(3);
            throw null;
        }
        if (ij0Var != null) {
        } else {
            a(4);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 5 && i != 6 && i != 7 && i != 9) {
            switch (i) {
                case 13:
                case 14:
                case 15:
                case 16:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 5 && i != 6 && i != 7 && i != 9) {
            switch (i) {
                case 13:
                case 14:
                case 15:
                case 16:
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
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = XMLRPC.TYPE_STRING;
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i == 7) {
            objArr[1] = "getShortClassName";
        } else if (i != 9) {
            switch (i) {
                case 13:
                case 14:
                    objArr[1] = "asString";
                    break;
                case 15:
                case 16:
                    objArr[1] = "asFqNameString";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                    break;
            }
        } else {
            objArr[1] = "asSingleFqName";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 6 && i != 7 && i != 9) {
            switch (i) {
                case 13:
                case 14:
                case 15:
                case 16:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static dd f(String str, boolean z) {
        String str2;
        if (str == null) {
            a(12);
            throw null;
        }
        int iLastIndexOf = str.lastIndexOf(InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (iLastIndexOf == -1) {
            str2 = AppConfig.CUSTOM;
        } else {
            String strReplace = str.substring(0, iLastIndexOf).replace('/', '.');
            str = str.substring(iLastIndexOf + 1);
            str2 = strReplace;
        }
        return new dd(new cv(str2), new cv(str), z);
    }

    public static dd l(cv cvVar) {
        if (cvVar != null) {
            return new dd(cvVar.e(), cvVar.a.g());
        }
        a(0);
        throw null;
    }

    public final cv b() {
        cv cvVar = this.a;
        boolean zD = cvVar.d();
        cv cvVar2 = this.b;
        if (zD) {
            if (cvVar2 != null) {
                return cvVar2;
            }
            a(9);
            throw null;
        }
        return new cv(cvVar.b() + "." + cvVar2.b());
    }

    public final String c() {
        cv cvVar = this.a;
        boolean zD = cvVar.d();
        cv cvVar2 = this.b;
        if (zD) {
            return cvVar2.b();
        }
        return cvVar.b().replace('.', '/') + InternalZipConstants.ZIP_FILE_SEPARATOR + cvVar2.b();
    }

    public final dd d(ij0 ij0Var) {
        if (ij0Var != null) {
            return new dd(h(), this.b.c(ij0Var), this.c);
        }
        a(8);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || dd.class != obj.getClass()) {
            return false;
        }
        dd ddVar = (dd) obj;
        return this.a.equals(ddVar.a) && this.b.equals(ddVar.b) && this.c == ddVar.c;
    }

    public final dd g() {
        cv cvVarE = this.b.e();
        if (cvVarE.d()) {
            return null;
        }
        return new dd(h(), cvVarE, this.c);
    }

    public final cv h() {
        cv cvVar = this.a;
        if (cvVar != null) {
            return cvVar;
        }
        a(5);
        throw null;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.c).hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final cv i() {
        cv cvVar = this.b;
        if (cvVar != null) {
            return cvVar;
        }
        a(6);
        throw null;
    }

    public final ij0 j() {
        return this.b.a.g();
    }

    public final String toString() {
        return this.a.d() ? InternalZipConstants.ZIP_FILE_SEPARATOR.concat(c()) : c();
    }
}
