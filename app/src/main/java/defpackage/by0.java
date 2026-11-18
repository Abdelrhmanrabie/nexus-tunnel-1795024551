package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class by0 {
    public static final boolean a;

    static {
        boolean zEquals;
        try {
            String property = System.getProperty("rx3.purge-enabled");
            zEquals = property == null ? true : "true".equals(property);
        } catch (Throwable th) {
            e.r(th);
        }
        a = zEquals;
    }
}
