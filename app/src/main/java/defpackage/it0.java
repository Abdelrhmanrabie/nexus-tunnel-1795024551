package defpackage;

import java.lang.reflect.Member;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class it0 extends ux implements nw {
    public static final it0 d = new it0(1);

    @Override // kotlin.jvm.internal.a, defpackage.a90
    public final String getName() {
        return "isSynthetic";
    }

    @Override // kotlin.jvm.internal.a
    public final o90 getOwner() {
        return ou0.a.b(Member.class);
    }

    @Override // kotlin.jvm.internal.a
    public final String getSignature() {
        return "isSynthetic()Z";
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        return Boolean.valueOf(((Member) obj).isSynthetic());
    }
}
