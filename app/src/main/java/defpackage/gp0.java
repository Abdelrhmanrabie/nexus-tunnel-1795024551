package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class gp0 {
    public final Object[] a;
    public int b;

    public gp0() {
        this.a = new Object[256];
    }

    public gp0(int i) {
        if (i > 0) {
            this.a = new Object[i];
        } else {
            d.AnonymousClass0.m$2("The max pool size must be > 0");
            throw null;
        }
    }

    public boolean a(Object obj) {
        int i = this.b;
        int i2 = 0;
        while (true) {
            Object[] objArr = this.a;
            if (i2 >= i) {
                int i3 = this.b;
                if (i3 >= objArr.length) {
                    return false;
                }
                objArr[i3] = obj;
                this.b = i3 + 1;
                return true;
            }
            if (objArr[i2] == obj) {
                d.AnonymousClass0.m("Already in the pool!");
                return false;
            }
            i2++;
        }
    }

    public Object b() {
        int i = this.b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.a;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.b = i2;
        return obj;
    }
}
