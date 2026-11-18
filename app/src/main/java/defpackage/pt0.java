package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pt0 extends ux implements nw {
    public static final pt0 d = new pt0(1);

    @Override // kotlin.jvm.internal.a, defpackage.a90
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.a
    public final o90 getOwner() {
        return ou0.a.b(au0.class);
    }

    @Override // kotlin.jvm.internal.a
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Method;)V";
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        return new au0((Method) obj);
    }
}
