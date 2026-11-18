package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ug0$a extends sc1 {
    public static final ug0$a b = new ug0$a("must be a member function", 0);
    public static final ug0$a b$1 = new ug0$a("must be a member or an extension function", 1);
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ug0$a(String str, int i) {
        super(str, 1);
        this.G0 = i;
    }

    @Override // defpackage.gc
    public final boolean b(q50 q50Var) {
        if (this.G0 != 0) {
            return (q50Var.o == null && q50Var.n == null) ? false : true;
        }
        return q50Var.o != null;
    }
}
