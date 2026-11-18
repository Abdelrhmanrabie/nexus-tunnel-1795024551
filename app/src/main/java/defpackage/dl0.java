package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dl0 {
    public static final dl0 b;
    public static final dl0 c;
    public static final dl0 d;
    public static final dl0 f;
    public static final dl0 g;
    public static final dl0 i;
    public static final dl0 j;
    public static final dl0 n;
    public static final /* synthetic */ dl0[] o;

    /* JADX INFO: Fake field, exist only in values array */
    dl0 EF0;

    static {
        dl0 dl0Var = new dl0("FROM_IDE", 0);
        dl0 dl0Var2 = new dl0("FROM_BACKEND", 1);
        dl0 dl0Var3 = new dl0("FROM_TEST", 2);
        dl0 dl0Var4 = new dl0("FROM_BUILTINS", 3);
        b = dl0Var4;
        dl0 dl0Var5 = new dl0("WHEN_CHECK_DECLARATION_CONFLICTS", 4);
        dl0 dl0Var6 = new dl0("WHEN_CHECK_OVERRIDES", 5);
        dl0 dl0Var7 = new dl0("FOR_SCRIPT", 6);
        dl0 dl0Var8 = new dl0("FROM_REFLECTION", 7);
        c = dl0Var8;
        dl0 dl0Var9 = new dl0("WHEN_RESOLVE_DECLARATION", 8);
        dl0 dl0Var10 = new dl0("WHEN_GET_DECLARATION_SCOPE", 9);
        dl0 dl0Var11 = new dl0("WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS", 10);
        dl0 dl0Var12 = new dl0("FOR_ALREADY_TRACKED", 11);
        d = dl0Var12;
        dl0 dl0Var13 = new dl0("WHEN_GET_ALL_DESCRIPTORS", 12);
        f = dl0Var13;
        dl0 dl0Var14 = new dl0("WHEN_TYPING", 13);
        dl0 dl0Var15 = new dl0("WHEN_GET_SUPER_MEMBERS", 14);
        g = dl0Var15;
        dl0 dl0Var16 = new dl0("FOR_NON_TRACKED_SCOPE", 15);
        i = dl0Var16;
        dl0 dl0Var17 = new dl0("FROM_SYNTHETIC_SCOPE", 16);
        dl0 dl0Var18 = new dl0("FROM_DESERIALIZATION", 17);
        j = dl0Var18;
        dl0 dl0Var19 = new dl0("FROM_JAVA_LOADER", 18);
        n = dl0Var19;
        o = new dl0[]{dl0Var, dl0Var2, dl0Var3, dl0Var4, dl0Var5, dl0Var6, dl0Var7, dl0Var8, dl0Var9, dl0Var10, dl0Var11, dl0Var12, dl0Var13, dl0Var14, dl0Var15, dl0Var16, dl0Var17, dl0Var18, dl0Var19, new dl0("WHEN_GET_LOCAL_VARIABLE", 19), new dl0("WHEN_FIND_BY_FQNAME", 20), new dl0("WHEN_GET_COMPANION_OBJECT", 21), new dl0("FOR_DEFAULT_IMPORTS", 22)};
    }

    public static dl0 valueOf(String str) {
        return (dl0) Enum.valueOf(dl0.class, str);
    }

    public static dl0[] values() {
        return (dl0[]) o.clone();
    }
}
