package androidx.emoji2.text;

import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c.h {
    public final /* synthetic */ c.a a;

    public b(c.a aVar) {
        this.a = aVar;
    }

    @Override // androidx.emoji2.text.c.h
    public final void a(Throwable th) {
        this.a.a.d(th);
    }

    @Override // androidx.emoji2.text.c.h
    public final void b(g gVar) {
        c.a aVar = this.a;
        aVar.c = gVar;
        aVar.b = new e(aVar.c, new c.i(), aVar.a.h);
        c cVar = aVar.a;
        cVar.getClass();
        ArrayList arrayList = new ArrayList();
        cVar.a.writeLock().lock();
        try {
            cVar.c = 1;
            arrayList.addAll(cVar.b);
            cVar.b.clear();
            cVar.a.writeLock().unlock();
            cVar.d.post(new c.f(arrayList, cVar.c, null));
        } catch (Throwable th) {
            cVar.a.writeLock().unlock();
            throw th;
        }
    }
}
