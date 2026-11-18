package defpackage;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class s70 {
    public static final cv a;
    public static final cv b;
    public static final cv c;
    public static final List d;
    public static final cv e;
    public static final cv f;
    public static final List g;
    public static final cv h;
    public static final cv i;
    public static final cv j;
    public static final cv k;
    public static final List l;
    public static final List m;

    static {
        cv cvVar = new cv("org.jspecify.nullness.Nullable");
        a = cvVar;
        cv cvVar2 = new cv("org.jspecify.nullness.NullnessUnspecified");
        b = cvVar2;
        cv cvVar3 = new cv("org.jspecify.nullness.NullMarked");
        c = cvVar3;
        List listAsList = Arrays.asList(r70.i, new cv("androidx.annotation.Nullable"), new cv("androidx.annotation.Nullable"), new cv("android.annotation.Nullable"), new cv("com.android.annotations.Nullable"), new cv("org.eclipse.jdt.annotation.Nullable"), new cv("org.checkerframework.checker.nullness.qual.Nullable"), new cv("javax.annotation.Nullable"), new cv("javax.annotation.CheckForNull"), new cv("edu.umd.cs.findbugs.annotations.CheckForNull"), new cv("edu.umd.cs.findbugs.annotations.Nullable"), new cv("edu.umd.cs.findbugs.annotations.PossiblyNull"), new cv("io.reactivex.annotations.Nullable"), new cv("io.reactivex.rxjava3.annotations.Nullable"));
        d = listAsList;
        cv cvVar4 = new cv("javax.annotation.Nonnull");
        e = cvVar4;
        f = new cv("javax.annotation.CheckForNull");
        List listAsList2 = Arrays.asList(r70.h, new cv("edu.umd.cs.findbugs.annotations.NonNull"), new cv("androidx.annotation.NonNull"), new cv("androidx.annotation.NonNull"), new cv("android.annotation.NonNull"), new cv("com.android.annotations.NonNull"), new cv("org.eclipse.jdt.annotation.NonNull"), new cv("org.checkerframework.checker.nullness.qual.NonNull"), new cv("lombok.NonNull"), new cv("io.reactivex.annotations.NonNull"), new cv("io.reactivex.rxjava3.annotations.NonNull"));
        g = listAsList2;
        cv cvVar5 = new cv("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        h = cvVar5;
        cv cvVar6 = new cv("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        i = cvVar6;
        cv cvVar7 = new cv("androidx.annotation.RecentlyNullable");
        j = cvVar7;
        cv cvVar8 = new cv("androidx.annotation.RecentlyNonNull");
        k = cvVar8;
        nz0.y1(nz0.y1(nz0.y1(nz0.y1(nz0.y1(nz0.y1(nz0.y1(nz0.x1(nz0.y1(nz0.x1(new LinkedHashSet(), listAsList), cvVar4), listAsList2), cvVar5), cvVar6), cvVar7), cvVar8), cvVar), cvVar2), cvVar3);
        l = Arrays.asList(r70.k, r70.l);
        m = Arrays.asList(r70.j, r70.m);
    }
}
