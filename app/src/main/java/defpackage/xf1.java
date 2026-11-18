package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class xf1 {
    public static int f;
    public final int b;
    public int c;
    public final ArrayList a = new ArrayList();
    public ArrayList d = null;
    public int e = -1;

    public xf1(int i) {
        int i2 = f;
        f = i2 + 1;
        this.b = i2;
        this.c = i;
    }

    public final void a(ArrayList arrayList) {
        int size = this.a.size();
        if (this.e != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                xf1 xf1Var = (xf1) arrayList.get(i);
                if (this.e == xf1Var.b) {
                    c(this.c, xf1Var);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(oe0 oe0Var, int i) {
        int iO;
        vg vgVar;
        ArrayList arrayList = this.a;
        if (arrayList.size() == 0) {
            return 0;
        }
        dh dhVar = ((ch) arrayList.get(0)).W;
        oe0Var.u();
        dhVar.b(oe0Var, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((ch) arrayList.get(i2)).b(oe0Var, false);
        }
        if (i == 0 && dhVar.B0 > 0) {
            e.h(dhVar, oe0Var, arrayList, 0);
        }
        if (i == 1 && dhVar.C0 > 0) {
            e.h(dhVar, oe0Var, arrayList, 1);
        }
        try {
            oe0Var.q();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ch chVar = (ch) arrayList.get(i3);
            ke keVar = new ke(27);
            new WeakReference(chVar);
            oe0.o(chVar.K);
            oe0.o(chVar.L);
            oe0.o(chVar.M);
            oe0.o(chVar.N);
            oe0.o(chVar.O);
            this.d.add(keVar);
        }
        if (i == 0) {
            iO = oe0.o(dhVar.K);
            vgVar = dhVar.M;
        } else {
            iO = oe0.o(dhVar.L);
            vgVar = dhVar.N;
        }
        int iO2 = oe0.o(vgVar);
        oe0Var.u();
        return iO2 - iO;
    }

    public final void c(int i, xf1 xf1Var) {
        Iterator it = this.a.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            int i2 = xf1Var.b;
            if (!zHasNext) {
                this.e = i2;
                return;
            }
            ch chVar = (ch) it.next();
            ArrayList arrayList = xf1Var.a;
            if (!arrayList.contains(chVar)) {
                arrayList.add(chVar);
            }
            if (i == 0) {
                chVar.q0 = i2;
            } else {
                chVar.r0 = i2;
            }
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        int i = this.c;
        if (i == 0) {
            str = "Horizontal";
        } else if (i == 1) {
            str = "Vertical";
        } else {
            str = i == 2 ? "Both" : "Unknown";
        }
        sb.append(str);
        sb.append(" [");
        sb.append(this.b);
        sb.append("] <");
        String string = sb.toString();
        for (ch chVar : this.a) {
            StringBuilder sbO = ak.o(string, " ");
            sbO.append(chVar.k0);
            string = sbO.toString();
        }
        return ak.j(string, " >");
    }
}
