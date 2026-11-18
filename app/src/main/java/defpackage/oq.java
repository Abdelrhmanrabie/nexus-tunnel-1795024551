package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class oq implements x10 {
    public final boolean b;

    public oq(boolean z) {
        this.b = z;
    }

    @Override // defpackage.x10
    public final fl0 c() {
        return null;
    }

    @Override // defpackage.x10
    public final boolean isActive() {
        return this.b;
    }

    public final String toString() {
        return fb$1.m(new StringBuilder("Empty{"), this.b ? "Active" : "New", '}');
    }
}
