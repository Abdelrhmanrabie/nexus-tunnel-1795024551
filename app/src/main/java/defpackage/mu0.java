package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mu0 extends ux implements bx {
    public static final mu0 d = new mu0(2);

    @Override // kotlin.jvm.internal.a, defpackage.a90
    public final String getName() {
        return "loadFunction";
    }

    @Override // kotlin.jvm.internal.a
    public final o90 getOwner() {
        return ou0.a.b(rg0.class);
    }

    @Override // kotlin.jvm.internal.a
    public final String getSignature() {
        return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
    }

    @Override // defpackage.bx
    public final Object invoke(Object obj, Object obj2) {
        return ((rg0) obj).e((fr0) obj2);
    }
}
