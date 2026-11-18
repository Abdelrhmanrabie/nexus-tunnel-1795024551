package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class yn$a extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ yn$a(int i, Object obj) {
        super(0);
        this.G0 = i;
        this.b = obj;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        if (this.G0 != 0) {
            return pr.d("Can't compute erased upper bound of type parameter `" + ((m6) this.b) + '`');
        }
        Set setKeySet = ((LinkedHashMap) ((v9) this.b).p.c).keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            dd ddVar = (dd) obj;
            if (ddVar.b.e().d() && !cd.c.contains(ddVar)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(ae.y0(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((dd) it.next()).j());
        }
        return arrayList2;
    }
}
