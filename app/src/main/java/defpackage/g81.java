package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g81 {
    public View b;
    public final HashMap a = new HashMap();
    public final ArrayList c = new ArrayList();

    public g81(View view) {
        this.b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g81)) {
            return false;
        }
        g81 g81Var = (g81) obj;
        return this.b == g81Var.b && this.a.equals(g81Var.a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sbO = ak.o("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbO.append(this.b);
        sbO.append("\n");
        String strJ = ak.j(sbO.toString(), "    values:");
        HashMap map = this.a;
        for (String str : map.keySet()) {
            strJ = strJ + "    " + str + ": " + map.get(str) + "\n";
        }
        return strJ;
    }
}
