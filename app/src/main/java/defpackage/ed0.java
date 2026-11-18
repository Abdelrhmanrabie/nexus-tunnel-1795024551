package defpackage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ed0 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ dd0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ed0(dd0 dd0Var, int i) {
        super(0);
        this.G0 = i;
        this.b = dd0Var;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        dd0 dd0Var = this.b;
        if (i == 0) {
            return nz0.x1(dd0Var.b(), dd0Var.d());
        }
        if (i != 1) {
            return he.i1((Iterable) fz0.E(new ht(new c81(new ht(ae.B0(dd0Var.o.a.getDeclaredClasses()), false, ld0.b$19), ld0.b$23), false, new cz0(0))));
        }
        List fields = dd0Var.o.getFields();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fields) {
            if (((xt0) obj).a.isEnumConstant()) {
                arrayList.add(obj);
            }
        }
        int iE = ye1.e(ae.y0(arrayList));
        if (iE < 16) {
            iE = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iE);
        for (Object obj2 : arrayList) {
            linkedHashMap.put(((xt0) obj2).getName(), obj2);
        }
        return linkedHashMap;
    }
}
