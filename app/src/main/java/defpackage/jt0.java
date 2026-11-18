package defpackage;

import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jt0 extends ux implements nw {
    public static final jt0 d = new jt0(1);

    @Override // kotlin.jvm.internal.a, defpackage.a90
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.a
    public final o90 getOwner() {
        return ou0.a.b(ut0.class);
    }

    @Override // kotlin.jvm.internal.a
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Constructor;)V";
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        return new ut0((Constructor) obj);
    }
}
