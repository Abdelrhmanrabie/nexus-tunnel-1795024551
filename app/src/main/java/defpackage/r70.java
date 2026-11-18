package defpackage;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class r70 {
    public static final cv a;
    public static final ij0 b;
    public static final cv c;
    public static final cv d;
    public static final cv e;
    public static final cv f;
    public static final cv g;
    public static final cv h;
    public static final cv i;
    public static final cv j;
    public static final cv k;
    public static final cv l;
    public static final cv m;
    public static final cv n;
    public static final cv o;
    public static final cv p;

    static {
        cv cvVar = new cv("kotlin.Metadata");
        a = cvVar;
        if (cvVar.b().replace('.', '/') == null) {
            m80.a(5);
            throw null;
        }
        b = ij0.f(XMLRPC.TAG_VALUE);
        c = new cv(Target.class.getName());
        new cv(ElementType.class.getName());
        d = new cv(Retention.class.getName());
        new cv(RetentionPolicy.class.getName());
        e = new cv(Deprecated.class.getName());
        f = new cv(Documented.class.getName());
        g = new cv("java.lang.annotation.Repeatable");
        h = new cv("org.jetbrains.annotations.NotNull");
        i = new cv("org.jetbrains.annotations.Nullable");
        j = new cv("org.jetbrains.annotations.Mutable");
        k = new cv("org.jetbrains.annotations.ReadOnly");
        l = new cv("kotlin.annotations.jvm.ReadOnly");
        m = new cv("kotlin.annotations.jvm.Mutable");
        n = new cv("kotlin.jvm.PurelyImplements");
        new cv("kotlin.jvm.internal");
        o = new cv("kotlin.jvm.internal.EnhancedNullability");
        p = new cv("kotlin.jvm.internal.EnhancedMutability");
    }
}
