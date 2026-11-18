package defpackage;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'i' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class mx {
    public static final ke d;
    public static final mx f;
    public static final mx g;
    public static final mx i;
    public static final mx j;
    public static final /* synthetic */ mx[] n;
    public final cv b;
    public final String c;

    static {
        mx mxVar = new mx("Function", 0, m21.i, "Function");
        f = mxVar;
        mx mxVar2 = new mx("SuspendFunction", 1, m21.c, "SuspendFunction");
        g = mxVar2;
        cv cvVar = m21.f;
        mx mxVar3 = new mx("KFunction", 2, cvVar, "KFunction");
        i = mxVar3;
        mx mxVar4 = new mx("KSuspendFunction", 3, cvVar, "KSuspendFunction");
        j = mxVar4;
        n = new mx[]{mxVar, mxVar2, mxVar3, mxVar4};
        d = new ke(8);
    }

    public mx(String str, int i2, cv cvVar, String str2) {
        super(str, i2);
        this.b = cvVar;
        this.c = str2;
    }

    public static mx valueOf(String str) {
        return (mx) Enum.valueOf(mx.class, str);
    }

    public static mx[] values() {
        return (mx[]) n.clone();
    }
}
