package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class b90 implements a90, za0 {
    public final nu0$a c;

    public b90() {
        ak.c(new g90(this, 1));
        this.c = ak.c(new g90(this, 2));
        ak.c(new g90(this, 3));
        ak.c(new g90(this, 4));
    }

    public final Object call(Object... objArr) throws p10 {
        try {
            return i().call(objArr);
        } catch (IllegalAccessException e) {
            throw new p10(e);
        }
    }

    public abstract ta i();

    public abstract p90 j();

    public abstract la l();

    public abstract boolean n();
}
