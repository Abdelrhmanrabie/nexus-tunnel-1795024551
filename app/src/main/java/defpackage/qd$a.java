package defpackage;

import java.util.ArrayList;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qd$a {
    public static final qd$a a = new qd$a(0);
    public static final qd$a a$1 = new qd$a(1);
    public static final qd$a a$2 = new qd$a(2);
    public final /* synthetic */ int G0;

    public /* synthetic */ qd$a(int i) {
        this.G0 = i;
    }

    public static String b(od odVar) {
        String strI1;
        String strH1 = e.h1(odVar.getName());
        if (odVar instanceof v91) {
            return strH1;
        }
        ok okVarB = odVar.b();
        if (okVarB instanceof ai0) {
            strI1 = b((od) okVarB);
        } else {
            strI1 = okVarB instanceof wn0 ? e.i1(((xn0) ((wn0) okVarB)).g.i().f()) : null;
        }
        if (strI1 == null || strI1.equals(AppConfig.CUSTOM)) {
            return strH1;
        }
        return ((Object) strI1) + '.' + strH1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [od, ok] */
    /* JADX WARN: Type inference failed for: r4v8, types: [ok] */
    /* JADX WARN: Type inference failed for: r4v9, types: [ok] */
    public final String a(od odVar, nm nmVar) {
        int i = this.G0;
        if (i == 0) {
            return odVar instanceof v91 ? nmVar.r(((v91) odVar).getName(), false) : nmVar.w(e.i1(xm.g(odVar).f()));
        }
        if (i != 1) {
            return b(odVar);
        }
        if (odVar instanceof v91) {
            return nmVar.r(((v91) odVar).getName(), false);
        }
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(odVar.getName());
            odVar = odVar.b();
        } while (odVar instanceof ai0);
        return e.i1(new hw0(arrayList));
    }
}
