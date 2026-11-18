package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class os extends j0 {
    public final rk c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public os(ja jaVar, fc0 fc0Var) {
        super(fc0Var);
        if (fc0Var == null) {
            ak.AnonymousClass1.m("Argument for @NotNull parameter 'receiverType' of kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver.<init> must not be null");
            throw null;
        }
        this.c = (rk) jaVar;
    }

    public final String toString() {
        return getType() + ": Ext {" + this.c + "}";
    }
}
