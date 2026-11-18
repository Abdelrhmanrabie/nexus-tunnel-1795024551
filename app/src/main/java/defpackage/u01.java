package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class u01 extends cc1 implements w01, w81 {
    @Override // defpackage.cc1
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public abstract u01 P0(boolean z);

    @Override // defpackage.cc1
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public abstract u01 R0(s4 s4Var);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = getAnnotations().iterator();
        while (it.hasNext()) {
            String[] strArr = {"[", mm.b.F((g4) it.next(), null), "] "};
            for (int i = 0; i < 3; i++) {
                sb.append(strArr[i]);
            }
        }
        sb.append(L0());
        if (!K0().isEmpty()) {
            he.P0(K0(), sb, "<", ">", null, 112);
        }
        if (M0()) {
            sb.append("?");
        }
        return sb.toString();
    }
}
