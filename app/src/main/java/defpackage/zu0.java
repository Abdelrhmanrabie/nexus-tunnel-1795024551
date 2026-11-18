package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class zu0 {
    public static final b b;
    public static final a c;
    public static final /* synthetic */ zu0[] d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends zu0 {
        public a() {
            super("HTML", 1);
        }

        @Override // defpackage.zu0
        public final String a(String str) {
            return q31.b0(q31.b0(str, "<", "&lt;"), ">", "&gt;");
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends zu0 {
        public b() {
            super("PLAIN", 0);
        }

        @Override // defpackage.zu0
        public final String a(String str) {
            return str;
        }
    }

    static {
        b bVar = new b();
        b = bVar;
        a aVar = new a();
        c = aVar;
        d = new zu0[]{bVar, aVar};
    }

    public static zu0 valueOf(String str) {
        return (zu0) Enum.valueOf(zu0.class, str);
    }

    public static zu0[] values() {
        return (zu0[]) d.clone();
    }

    public abstract String a(String str);
}
