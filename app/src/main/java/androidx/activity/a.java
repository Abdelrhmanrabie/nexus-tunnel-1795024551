package androidx.activity;

import defpackage.lw;
import defpackage.oc0;
import defpackage.tb1;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class a extends oc0 implements lw {
    public final /* synthetic */ ComponentActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ComponentActivity componentActivity) {
        super(0);
        this.b = componentActivity;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        this.b.reportFullyDrawn();
        return tb1.a;
    }
}
