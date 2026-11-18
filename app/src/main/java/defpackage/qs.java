package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface qs {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public static final a b;
        public static final a c;
        public static final a d;
        public static final /* synthetic */ a[] f;

        static {
            a aVar = new a("CONFLICTS_ONLY", 0);
            b = aVar;
            a aVar2 = new a("SUCCESS_ONLY", 1);
            c = aVar2;
            a aVar3 = new a("BOTH", 2);
            d = aVar3;
            f = new a[]{aVar, aVar2, aVar3};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b {
        public static final b b;
        public static final b c;
        public static final b d;
        public static final /* synthetic */ b[] f;

        static {
            b bVar = new b("OVERRIDABLE", 0);
            b = bVar;
            b bVar2 = new b("CONFLICT", 1);
            b bVar3 = new b("INCOMPATIBLE", 2);
            c = bVar3;
            b bVar4 = new b("UNKNOWN", 3);
            d = bVar4;
            f = new b[]{bVar, bVar2, bVar3, bVar4};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f.clone();
        }
    }

    a a();

    b b(ja jaVar, ja jaVar2, ai0 ai0Var);
}
