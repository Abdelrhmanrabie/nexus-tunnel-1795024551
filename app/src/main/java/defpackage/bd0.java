package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bd0 extends oc0 implements nw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ dd0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bd0(dd0 dd0Var, int i) {
        super(1);
        this.G0 = i;
        this.b = dd0Var;
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        int i = this.G0;
        ij0 ij0Var = (ij0) obj;
        dd0 dd0Var = this.b;
        return i != 0 ? dd0.w(dd0Var, ij0Var) : dd0.v(dd0Var, ij0Var);
    }
}
