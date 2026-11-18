package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dm0 extends ul {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ dm0(u01 u01Var, int i) {
        super(u01Var);
        this.G0 = i;
    }

    @Override // defpackage.tl, defpackage.fc0
    public final boolean M0() {
        return this.G0 == 0;
    }

    @Override // defpackage.tl
    public final tl W0(u01 u01Var) {
        return this.G0 != 0 ? new dm0(u01Var, 1) : new dm0(u01Var, 0);
    }
}
