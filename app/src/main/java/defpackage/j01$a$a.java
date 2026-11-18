package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class j01$a$a {
    public final String a;
    public final ArrayList b = new ArrayList();
    public jo0 c = new jo0("V", null);

    public j01$a$a(g gVar, String str) {
        this.a = str;
    }

    public final void a(String str, s60... s60VarArr) {
        j91 j91Var;
        if (s60VarArr.length == 0) {
            j91Var = null;
        } else {
            l7 l7Var = new l7(1, new k7(s60VarArr, 0, 0));
            int iE = ye1.e(ae.y0(l7Var));
            if (iE < 16) {
                iE = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iE);
            Iterator it = l7Var.iterator();
            while (true) {
                c20 c20Var = (c20) it;
                if (!c20Var.b.hasNext()) {
                    break;
                }
                a20 a20Var = (a20) c20Var.next();
                linkedHashMap.put(Integer.valueOf(a20Var.a), (s60) a20Var.b);
            }
            j91Var = new j91(linkedHashMap);
        }
        this.b.add(new jo0(str, j91Var));
    }

    public final void c(String str, s60... s60VarArr) {
        l7 l7Var = new l7(1, new k7(s60VarArr, 0, 0));
        int iE = ye1.e(ae.y0(l7Var));
        if (iE < 16) {
            iE = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iE);
        Iterator it = l7Var.iterator();
        while (true) {
            c20 c20Var = (c20) it;
            if (!c20Var.b.hasNext()) {
                this.c = new jo0(str, new j91(linkedHashMap));
                return;
            } else {
                a20 a20Var = (a20) c20Var.next();
                linkedHashMap.put(Integer.valueOf(a20Var.a), (s60) a20Var.b);
            }
        }
    }
}
