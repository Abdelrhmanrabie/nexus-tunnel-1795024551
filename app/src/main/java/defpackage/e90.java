package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e90 extends oc0 implements lw {
    public final /* synthetic */ la b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e90(la laVar, int i) {
        super(0);
        this.b = laVar;
        this.c = i;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        return (lo0) this.b.f().get(this.c);
    }
}
