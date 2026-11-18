package androidx.appcompat.view.menu;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {
    public final /* synthetic */ b.d b;
    public final /* synthetic */ h c;
    public final /* synthetic */ f d;
    public final /* synthetic */ b.c f;

    public c(b.c cVar, b.d dVar, h hVar, f fVar) {
        this.f = cVar;
        this.b = dVar;
        this.c = hVar;
        this.d = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.d dVar = this.b;
        if (dVar != null) {
            b.c cVar = this.f;
            b.this.G = true;
            dVar.b.close(false);
            b.this.G = false;
        }
        h hVar = this.c;
        if (hVar.isEnabled() && hVar.hasSubMenu()) {
            this.d.performItemAction(hVar, null, 4);
        }
    }
}
