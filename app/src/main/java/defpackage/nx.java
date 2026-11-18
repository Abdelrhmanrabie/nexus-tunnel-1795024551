package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class nx extends iy {
    @Override // defpackage.iy
    public final List h() {
        tx txVarA;
        lx lxVar = (lx) this.b;
        int iOrdinal = lxVar.j.ordinal();
        if (iOrdinal == 0) {
            txVarA = v3.a(lxVar, false);
        } else {
            if (iOrdinal != 1) {
                return uq.b;
            }
            txVarA = v3.a(lxVar, true);
        }
        return Collections.singletonList(txVarA);
    }
}
