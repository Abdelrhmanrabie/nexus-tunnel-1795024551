package defpackage;

import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class px implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ px(int i, Object obj, Object obj2) {
        this.G0 = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        if (i == 0) {
            n11 n11Var = new n11();
            Iterator it = ((rx) this.c).d().iterator();
            while (it.hasNext()) {
                n11Var.add(((ox) it.next()).c((ha1) this.b));
            }
            return n11Var;
        }
        if (i != 1) {
            return e4.h(Collections.EMPTY_LIST, e4.f47a, new l91(ff0.e, new qx(2, this)), ((y0) this.c).h(), false);
        }
        w70 w70Var = (w70) this.c;
        ji0 ji0Var = w70Var.a;
        ji0 ji0Var2 = (ji0) this.b;
        if (ji0Var == null) {
            w70Var.a = ji0Var2;
            return null;
        }
        throw new AssertionError("Built-ins module is already set: " + w70Var.a + " (attempting to reset to " + ji0Var2 + ")");
    }
}
