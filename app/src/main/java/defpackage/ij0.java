package defpackage;

import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ij0 implements Comparable {
    public final String b;
    public final boolean c;

    public ij0(String str, boolean z) {
        if (str == null) {
            a(0);
            throw null;
        }
        this.b = str;
        this.c = z;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 2 : 3];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = XMLRPC.TAG_NAME;
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i == 2) {
            objArr[1] = "getIdentifier";
        } else if (i == 3 || i == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "special";
                break;
            case 8:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static ij0 d(String str) {
        if (str != null) {
            return str.startsWith("<") ? h(str) : f(str);
        }
        a(8);
        throw null;
    }

    public static ij0 f(String str) {
        if (str != null) {
            return new ij0(str, false);
        }
        a(5);
        throw null;
    }

    public static boolean g(String str) {
        if (str == null) {
            a(6);
            throw null;
        }
        if (!str.isEmpty() && !str.startsWith("<")) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '.' && cCharAt != '/' && cCharAt != '\\') {
                }
            }
            return true;
        }
        return false;
    }

    public static ij0 h(String str) {
        if (str == null) {
            a(7);
            throw null;
        }
        if (str.startsWith("<")) {
            return new ij0(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': ".concat(str));
    }

    public final String b() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        a(1);
        throw null;
    }

    public final String c() {
        if (!this.c) {
            return b();
        }
        d.AnonymousClass0.m$3("not identifier: ", this);
        return null;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.b.compareTo(((ij0) obj).b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ij0)) {
            return false;
        }
        ij0 ij0Var = (ij0) obj;
        return this.c == ij0Var.c && this.b.equals(ij0Var.b);
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + (this.c ? 1 : 0);
    }

    public final String toString() {
        return this.b;
    }
}
