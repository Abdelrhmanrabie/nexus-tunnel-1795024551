package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dv {
    public static final ij0 e = ij0.h("<root>");
    public static final Pattern f = Pattern.compile("\\.");
    public static final mu g = new mu(1);
    public final String a;
    public transient cv b;
    public transient dv c;
    public transient ij0 d;

    public dv(String str) {
        this.a = str;
    }

    public dv(String str, cv cvVar) {
        if (str == null) {
            a(0);
            throw null;
        }
        this.a = str;
        this.b = cvVar;
    }

    public dv(String str, dv dvVar, ij0 ij0Var) {
        this.a = str;
        this.c = dvVar;
        this.d = ij0Var;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i2 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = XMLRPC.TAG_NAME;
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(str2);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public final dv b(ij0 ij0Var) {
        String strB;
        if (ij0Var == null) {
            a(9);
            throw null;
        }
        String str = this.a;
        if (str.isEmpty()) {
            strB = ij0Var.b();
        } else {
            strB = str + "." + ij0Var.b();
        }
        return new dv(strB, this, ij0Var);
    }

    public final void c() {
        String str = this.a;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            this.d = ij0.d(str.substring(iLastIndexOf + 1));
            this.c = new dv(str.substring(0, iLastIndexOf));
        } else {
            this.d = ij0.d(str);
            this.c = cv.c.i();
        }
    }

    public final boolean e() {
        if (this.b != null) {
            return true;
        }
        String str = this.a;
        if (str != null) {
            return str.indexOf(60) < 0;
        }
        a(4);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof dv) && this.a.equals(((dv) obj).a);
    }

    public final List f() {
        List list;
        String str = this.a;
        if (str.isEmpty()) {
            list = Collections.EMPTY_LIST;
        } else {
            String[] strArrSplit = f.split(str);
            ArrayList arrayList = new ArrayList(strArrSplit.length);
            for (String str2 : strArrSplit) {
                g.getClass();
                arrayList.add(ij0.d(str2));
            }
            list = arrayList;
        }
        if (list != null) {
            return list;
        }
        a(14);
        throw null;
    }

    public final ij0 g() {
        ij0 ij0Var = this.d;
        if (ij0Var != null) {
            return ij0Var;
        }
        if (this.a.isEmpty()) {
            d.AnonymousClass0.m("root");
            return null;
        }
        c();
        ij0 ij0Var2 = this.d;
        if (ij0Var2 != null) {
            return ij0Var2;
        }
        a(11);
        throw null;
    }

    public final cv h() {
        cv cvVar = this.b;
        if (cvVar != null) {
            return cvVar;
        }
        cv cvVar2 = new cv(this);
        this.b = cvVar2;
        return cvVar2;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        String strB = this.a;
        if (strB.isEmpty()) {
            strB = e.b();
        }
        if (strB != null) {
            return strB;
        }
        a(17);
        throw null;
    }
}
