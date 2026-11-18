package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class dm implements zl {
    public final yf1 d;
    public int f;
    public int g;
    public yf1 a = null;
    public boolean b = false;
    public boolean c = false;
    public int e = 1;
    public int h = 1;
    public ko i = null;
    public boolean j = false;
    public final ArrayList k = new ArrayList();
    public final ArrayList l = new ArrayList();

    public dm(yf1 yf1Var) {
        this.d = yf1Var;
    }

    @Override // defpackage.zl
    public final void a() {
        ArrayList<dm> arrayList = this.l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((dm) it.next()).j) {
                return;
            }
        }
        this.c = true;
        yf1 yf1Var = this.a;
        if (yf1Var != null) {
            yf1Var.a();
        }
        if (this.b) {
            this.d.a();
            return;
        }
        dm dmVar = null;
        int i = 0;
        for (dm dmVar2 : arrayList) {
            if (!(dmVar2 instanceof ko)) {
                i++;
                dmVar = dmVar2;
            }
        }
        if (dmVar != null && i == 1 && dmVar.j) {
            ko koVar = this.i;
            if (koVar != null) {
                if (!koVar.j) {
                    return;
                } else {
                    this.f = this.h * koVar.g;
                }
            }
            d(dmVar.g + this.f);
        }
        yf1 yf1Var2 = this.a;
        if (yf1Var2 != null) {
            yf1Var2.a();
        }
    }

    public final void b(yf1 yf1Var) {
        this.k.add(yf1Var);
        if (this.j) {
            yf1Var.a();
        }
    }

    public final void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((zl) it.next()).a();
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.k0);
        sb.append(":");
        int i = this.e;
        if (i == 1) {
            str = "UNKNOWN";
        } else if (i == 2) {
            str = "HORIZONTAL_DIMENSION";
        } else if (i == 3) {
            str = "VERTICAL_DIMENSION";
        } else if (i == 4) {
            str = "LEFT";
        } else if (i == 5) {
            str = "RIGHT";
        } else if (i == 6) {
            str = "TOP";
        } else if (i == 7) {
            str = "BOTTOM";
        } else {
            str = i == 8 ? "BASELINE" : "null";
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
}
