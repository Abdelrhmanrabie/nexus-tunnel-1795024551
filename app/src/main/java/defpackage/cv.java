package defpackage;

import net.openvpn.ovpn3.XMLRPC;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class cv {
    public static final cv c = new cv(AppConfig.CUSTOM);
    public final dv a;
    public transient cv b;

    public cv(dv dvVar) {
        this.a = dvVar;
    }

    public cv(dv dvVar, cv cvVar) {
        this.a = dvVar;
        this.b = cvVar;
    }

    public cv(String str) {
        if (str != null) {
            this.a = new dv(str, this);
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i2 = 2;
                break;
            case 8:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = XMLRPC.TAG_NAME;
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(str2);
            case 8:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static cv j(ij0 ij0Var) {
        if (ij0Var != null) {
            return new cv(new dv(ij0Var.b(), c.i(), ij0Var));
        }
        a(13);
        throw null;
    }

    public final String b() {
        String str = this.a.a;
        if (str != null) {
            return str;
        }
        dv.a(4);
        throw null;
    }

    public final cv c(ij0 ij0Var) {
        if (ij0Var != null) {
            return new cv(this.a.b(ij0Var), this);
        }
        a(8);
        throw null;
    }

    public final boolean d() {
        return this.a.a.isEmpty();
    }

    public final cv e() {
        cv cvVar = this.b;
        if (cvVar != null) {
            return cvVar;
        }
        if (d()) {
            d.AnonymousClass0.m("root");
            return null;
        }
        dv dvVar = this.a;
        dv dvVar2 = dvVar.c;
        if (dvVar2 == null) {
            if (dvVar.a.isEmpty()) {
                d.AnonymousClass0.m("root");
                return null;
            }
            dvVar.c();
            dvVar2 = dvVar.c;
            if (dvVar2 == null) {
                dv.a(8);
                throw null;
            }
        }
        cv cvVar2 = new cv(dvVar2);
        this.b = cvVar2;
        return cvVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof cv) && this.a.equals(((cv) obj).a);
    }

    public final boolean h(ij0 ij0Var) {
        if (ij0Var == null) {
            a(12);
            throw null;
        }
        dv dvVar = this.a;
        if (dvVar.a.isEmpty()) {
            return false;
        }
        String str = dvVar.a;
        int iIndexOf = str.indexOf(46);
        String strB = ij0Var.b();
        if (iIndexOf == -1) {
            iIndexOf = str.length();
        }
        return str.regionMatches(0, strB, 0, iIndexOf);
    }

    public final int hashCode() {
        return this.a.a.hashCode();
    }

    public final dv i() {
        dv dvVar = this.a;
        if (dvVar != null) {
            return dvVar;
        }
        a(5);
        throw null;
    }

    public final String toString() {
        return this.a.toString();
    }
}
