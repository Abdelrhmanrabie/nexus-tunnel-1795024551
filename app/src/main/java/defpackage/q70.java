package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class q70 {
    public static final cv a = new cv("kotlin.jvm.JvmField");
    public static final dd b;

    static {
        dd.l(new cv("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        b = dd.f("kotlin/jvm/internal/RepeatableContainer", false);
    }

    public static final String a(String str) {
        return c(str) ? str : e4.j("get", e.f(str));
    }

    public static final boolean c(String str) {
        if (!str.startsWith("is") || str.length() == 2) {
            return false;
        }
        char cCharAt = str.charAt(2);
        if ('a' >= cCharAt && 'a' != cCharAt) {
            return true;
        }
        return cCharAt >= 'z' && cCharAt != 'z';
    }
}
