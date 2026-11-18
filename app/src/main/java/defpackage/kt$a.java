package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kt$a extends ux implements nw {
    public static final kt$a d = new kt$a(1);

    @Override // kotlin.jvm.internal.a, defpackage.a90
    public final String getName() {
        return "getOuterClassId";
    }

    @Override // kotlin.jvm.internal.a
    public final o90 getOwner() {
        return ou0.a.b(dd.class);
    }

    @Override // kotlin.jvm.internal.a
    public final String getSignature() {
        return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        return ((dd) obj).g();
    }
}
