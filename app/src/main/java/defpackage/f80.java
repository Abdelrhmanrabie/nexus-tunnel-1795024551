package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class f80 extends oc0 implements nw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ ij0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f80(ij0 ij0Var, int i) {
        super(1);
        this.G0 = i;
        this.b = ij0Var;
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        vg0 vg0Var = (vg0) obj;
        if (this.G0 != 0) {
            return vg0Var.c(this.b, dl0.g);
        }
        return vg0Var.a(this.b, dl0.b);
    }
}
