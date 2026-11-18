package defpackage;

import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class sg0 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ rg0 b;
    public final /* synthetic */ b0 c;
    public final /* synthetic */ x3 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sg0(rg0 rg0Var, b0 b0Var, x3 x3Var, int i) {
        super(0);
        this.G0 = i;
        this.b = rg0Var;
        this.c = b0Var;
        this.d = x3Var;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        List listA;
        int i = this.G0;
        rg0 rg0Var = this.b;
        if (i == 0) {
            dg0 dg0VarA = rg0Var.a(rg0Var.a.c);
            listA = dg0VarA != null ? rg0Var.a.a.e.a(dg0VarA, this.c, this.d) : null;
            return listA == null ? uq.b : listA;
        }
        hn hnVar = rg0Var.a;
        dg0 dg0VarA2 = rg0Var.a(hnVar.c);
        listA = dg0VarA2 != null ? he.g1(hnVar.a.e.d(dg0VarA2, this.c, this.d)) : null;
        return listA == null ? uq.b : listA;
    }
}
