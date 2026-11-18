package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class uf$a extends oc0 implements nw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ cv b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ uf$a(cv cvVar, int i) {
        super(1);
        this.G0 = i;
        this.b = cvVar;
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        if (this.G0 == 0) {
            return ((s4) obj).c(this.b);
        }
        cv cvVar = (cv) obj;
        return Boolean.valueOf(!cvVar.d() && cvVar.e().equals(this.b));
    }
}
