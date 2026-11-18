package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ru implements ih {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object a;

    public /* synthetic */ ru(int i, Object obj) {
        this.G0 = i;
        this.a = obj;
    }

    @Override // defpackage.ih
    public final void accept(Object obj) {
        uu.a aVar = (uu.a) obj;
        if (this.G0 == 0) {
            if (aVar == null) {
                aVar = new uu.a(-3);
            }
            ((g) this.a).a(aVar);
            return;
        }
        synchronized (uu.c) {
            try {
                o01 o01Var = uu.d;
                ArrayList arrayList = (ArrayList) o01Var.getOrDefault((String) this.a, null);
                if (arrayList == null) {
                    return;
                }
                o01Var.remove((String) this.a);
                for (int i = 0; i < arrayList.size(); i++) {
                    ((ih) arrayList.get(i)).accept(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
