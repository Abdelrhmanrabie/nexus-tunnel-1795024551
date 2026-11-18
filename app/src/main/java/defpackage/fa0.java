package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class fa0 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ ea0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fa0(ea0 ea0Var, int i) {
        super(0);
        this.G0 = i;
        this.b = ea0Var;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        return this.G0 != 0 ? e4.a(this.b.c) : new ea0.a(this.b);
    }
}
