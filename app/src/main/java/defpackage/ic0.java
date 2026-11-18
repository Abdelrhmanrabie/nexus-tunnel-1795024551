package defpackage;

import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ic0 extends oc0 implements nw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ a91 b;
    public final /* synthetic */ List c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ic0(List list, a91 a91Var, int i) {
        super(1);
        this.G0 = i;
        this.b = a91Var;
        this.c = list;
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        int i = this.G0;
        lc0$a lc0_a = (lc0$a) obj;
        a91 a91Var = this.b;
        if (i != 0) {
            if (a91Var.b() != null) {
                lc0_a.getClass();
                return null;
            }
        } else if (a91Var.b() != null) {
            lc0_a.getClass();
            return null;
        }
        return null;
    }
}
