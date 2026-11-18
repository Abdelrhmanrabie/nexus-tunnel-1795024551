package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class a70 {
    public final /* synthetic */ int G0;
    public final String a;
    public final boolean b;
    public static final a70 c = new a70(0, "protected_static", true);
    public static final a70 c$1 = new a70(1, "inherited", false);
    public static final a70 c$2 = new a70(2, "internal", false);
    public static final a70 c$3 = new a70(3, "invisible_fake", false);
    public static final a70 c$4 = new a70(4, "local", false);
    public static final a70 c$5 = new a70(5, "private", false);
    public static final a70 c$6 = new a70(6, "private_to_this", false);
    public static final a70 c$7 = new a70(7, "protected", true);
    public static final a70 c$8 = new a70(8, "public", true);
    public static final a70 c$9 = new a70(9, "unknown", false);
    public static final a70 c$10 = new a70(10, "package", false);
    public static final a70 c$11 = new a70(11, "protected_and_package", true);

    public a70(int i, String str, boolean z) {
        this.G0 = i;
        this.a = str;
        this.b = z;
    }

    public Integer a(a70 a70Var) {
        int i = this.G0;
        a70 a70Var2 = c$6;
        a70 a70Var3 = c$5;
        int i2 = 0;
        if (i == 10) {
            if (this != a70Var) {
                zf0 zf0Var = ef1.a;
                i2 = (a70Var == a70Var3 || a70Var == a70Var2) ? 1 : -1;
            }
            return Integer.valueOf(i2);
        }
        if (i != 11) {
            zf0 zf0Var2 = ef1.a;
            if (this != a70Var) {
                zf0 zf0Var3 = ef1.a;
                Integer num = (Integer) zf0Var3.get(this);
                Integer num2 = (Integer) zf0Var3.get(a70Var);
                if (num == null || num2 == null || num.equals(num2)) {
                    return null;
                }
                return Integer.valueOf(num.intValue() - num2.intValue());
            }
        } else if (!equals(a70Var)) {
            if (a70Var == c$2) {
                return null;
            }
            zf0 zf0Var4 = ef1.a;
            return Integer.valueOf((a70Var == a70Var3 || a70Var == a70Var2) ? 1 : -1);
        }
        return 0;
    }

    public String b() {
        int i = this.G0;
        if (i == 0) {
            return "protected/*protected static*/";
        }
        if (i == 6) {
            return "private/*private to this*/";
        }
        if (i != 10) {
            return i != 11 ? this.a : "protected/*protected and package*/";
        }
        return "public/*package*/";
    }

    public a70 c() {
        int i = this.G0;
        return (i == 0 || i == 10 || i == 11) ? c$7 : this;
    }

    public final String toString() {
        return b();
    }
}
