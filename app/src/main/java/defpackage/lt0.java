package defpackage;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lt0 extends ux implements nw {
    public static final lt0 d = new lt0(1);

    @Override // kotlin.jvm.internal.a, defpackage.a90
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.a
    public final o90 getOwner() {
        return ou0.a.b(xt0.class);
    }

    @Override // kotlin.jvm.internal.a
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Field;)V";
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        return new xt0((Field) obj);
    }
}
