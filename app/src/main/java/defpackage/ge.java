package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ge implements sy0 {
    public final /* synthetic */ int G0;
    public final Object a;

    public /* synthetic */ ge(int i, Object obj) {
        this.G0 = i;
        this.a = obj;
    }

    @Override // defpackage.sy0
    public final Iterator iterator() {
        int i = this.G0;
        if (i == 0) {
            return ((Iterable) this.a).iterator();
        }
        if (i == 1) {
            return new ay.a(this);
        }
        Object obj = this.a;
        if (i == 2) {
            return new a7(0, (Object[]) obj);
        }
        if (i == 3) {
            return new pe0((CharSequence) obj);
        }
        if (i != 4) {
            return (Iterator) obj;
        }
        ty0 ty0Var = new ty0();
        ty0Var.d = ((i70) obj).create(ty0Var, ty0Var);
        return ty0Var;
    }
}
