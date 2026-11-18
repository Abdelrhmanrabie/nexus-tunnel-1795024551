package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class om extends oc0 implements nw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ nm b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ om(nm nmVar, int i) {
        super(1);
        this.G0 = i;
        this.b = nmVar;
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        int i = this.G0;
        if (i != 0) {
            if (i != 1) {
                return this.b.s((fc0) obj);
            }
            return this.b.I((qg) obj);
        }
        ca1 ca1Var = (ca1) obj;
        if (ca1Var.b()) {
            return "*";
        }
        String strS = this.b.s(ca1Var.getType());
        if (ca1Var.c() == ad1.INVARIANT) {
            return strS;
        }
        return ca1Var.c() + ' ' + strS;
    }
}
