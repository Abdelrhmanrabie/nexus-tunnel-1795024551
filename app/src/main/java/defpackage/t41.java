package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class t41 extends bi implements kx {
    private final int arity;

    public t41(ai aiVar) {
        super(aiVar, aiVar != null ? aiVar.getContext() : null);
        this.arity = 2;
    }

    @Override // defpackage.kx
    public int getArity() {
        return this.arity;
    }

    @Override // defpackage.i8
    public String toString() {
        return getCompletion() == null ? ou0.a.g(this) : super.toString();
    }
}
