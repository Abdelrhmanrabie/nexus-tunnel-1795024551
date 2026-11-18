package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ip0 extends gp0 {
    public final Object c;

    public ip0(int i) {
        super(i);
        this.c = new Object();
    }

    @Override // defpackage.gp0
    public final boolean a(Object obj) {
        boolean zA;
        synchronized (this.c) {
            zA = super.a(obj);
        }
        return zA;
    }

    @Override // defpackage.gp0
    public final Object b() {
        Object objB;
        synchronized (this.c) {
            objB = super.b();
        }
        return objB;
    }
}
