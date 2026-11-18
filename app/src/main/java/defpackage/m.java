package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements nw {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ m(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        int i = this.b;
        Object obj2 = this.c;
        if (i != 0) {
            return ((lw) obj2).invoke();
        }
        return obj == ((z) obj2) ? "(this Collection)" : String.valueOf(obj);
    }
}
