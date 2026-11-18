package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class u50 {
    public static final cv a;
    public static final zl0 b;
    public static final v50 c;

    static {
        cv cvVar = new cv("org.jspecify.nullness");
        a = cvVar;
        cv cvVar2 = new cv("org.checkerframework.checker.nullness.compatqual");
        cv cvVar3 = new cv("org.jetbrains.annotations");
        v50 v50Var = v50.d;
        jo0 jo0Var = new jo0(cvVar3, v50Var);
        jo0 jo0Var2 = new jo0(new cv("androidx.annotation"), v50Var);
        jo0 jo0Var3 = new jo0(new cv("android.support.annotation"), v50Var);
        jo0 jo0Var4 = new jo0(new cv("android.annotation"), v50Var);
        jo0 jo0Var5 = new jo0(new cv("com.android.annotations"), v50Var);
        jo0 jo0Var6 = new jo0(new cv("org.eclipse.jdt.annotation"), v50Var);
        jo0 jo0Var7 = new jo0(new cv("org.checkerframework.checker.nullness.qual"), v50Var);
        jo0 jo0Var8 = new jo0(cvVar2, v50Var);
        jo0 jo0Var9 = new jo0(new cv("javax.annotation"), v50Var);
        jo0 jo0Var10 = new jo0(new cv("edu.umd.cs.findbugs.annotations"), v50Var);
        jo0 jo0Var11 = new jo0(new cv("io.reactivex.annotations"), v50Var);
        cv cvVar4 = new cv("androidx.annotation.RecentlyNullable");
        gv0 gv0Var = gv0.d;
        jo0 jo0Var12 = new jo0(cvVar4, new v50(gv0Var, 4));
        jo0 jo0Var13 = new jo0(new cv("androidx.annotation.RecentlyNonNull"), new v50(gv0Var, 4));
        jo0 jo0Var14 = new jo0(new cv("lombok"), v50Var);
        nc0 nc0Var = new nc0(1, 7);
        gv0 gv0Var2 = gv0.f;
        b = new zl0(ye1.h(jo0Var, jo0Var2, jo0Var3, jo0Var4, jo0Var5, jo0Var6, jo0Var7, jo0Var8, jo0Var9, jo0Var10, jo0Var11, jo0Var12, jo0Var13, jo0Var14, new jo0(cvVar, new v50(gv0Var, nc0Var, gv0Var2)), new jo0(new cv("io.reactivex.rxjava3.annotations"), new v50(gv0Var, new nc0(1, 7), gv0Var2))));
        c = new v50(gv0Var, 4);
    }
}
