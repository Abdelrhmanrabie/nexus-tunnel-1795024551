package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class pa0 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ oa0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ pa0(oa0 oa0Var, int i) {
        super(0);
        this.G0 = i;
        this.b = oa0Var;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        return this.G0 != 0 ? this.b.o() : new oa0.a(this.b);
    }
}
