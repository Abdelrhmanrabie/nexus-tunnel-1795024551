package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.n;
import androidx.fragment.app.q;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class fv implements ih {
    public final /* synthetic */ int G0;
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ fv(Object obj, int i, int i2) {
        this.G0 = i2;
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.ih
    public final void accept(Object obj) {
        int i = this.G0;
        int i2 = this.a;
        Object obj2 = this.b;
        if (i != 0) {
            if (i2 == 0) {
                ((n) obj2).mFragments.a();
                return;
            }
            boolean z = ((ui0) obj).a;
            for (Fragment fragment : ((q) obj2).c.f()) {
                if (fragment != null) {
                    fragment.performMultiWindowModeChanged(z);
                }
            }
            return;
        }
        if (i2 == 0) {
            ((n) obj2).mFragments.a();
            return;
        }
        q qVar = (q) obj2;
        if (((Integer) obj).intValue() == 80) {
            for (Fragment fragment2 : qVar.c.f()) {
                if (fragment2 != null) {
                    fragment2.performLowMemory();
                }
            }
        }
    }
}
