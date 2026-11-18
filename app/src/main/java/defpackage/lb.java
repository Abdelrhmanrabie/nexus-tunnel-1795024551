package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lb extends d91 {
    @Override // defpackage.d91
    public final ca1 g(a91 a91Var) {
        mb mbVar = a91Var instanceof mb ? (mb) a91Var : null;
        if (mbVar == null) {
            return null;
        }
        if (mbVar.a().b()) {
            return new da1(mbVar.a().getType(), ad1.OUT_VARIANCE);
        }
        return mbVar.a();
    }
}
