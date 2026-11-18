package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class nb implements mb {
    public final ca1 a;
    public vk0 b;

    public nb(ca1 ca1Var) {
        this.a = ca1Var;
        ca1Var.c();
    }

    @Override // defpackage.mb
    public final ca1 a() {
        return this.a;
    }

    @Override // defpackage.a91
    public final /* bridge */ /* synthetic */ od b() {
        return null;
    }

    @Override // defpackage.a91
    public final boolean c() {
        return false;
    }

    @Override // defpackage.a91
    public final Collection d() {
        ca1 ca1Var = this.a;
        return Collections.singletonList(ca1Var.c() == ad1.OUT_VARIANCE ? ca1Var.getType() : k().p());
    }

    @Override // defpackage.a91
    public final List getParameters() {
        return uq.b;
    }

    @Override // defpackage.a91
    public final ub0 k() {
        return this.a.getType().L0().k();
    }

    public final String toString() {
        return "CapturedTypeConstructor(" + this.a + ')';
    }
}
