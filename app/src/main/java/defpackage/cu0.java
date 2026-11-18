package defpackage;

import java.util.Collection;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class cu0 extends ui implements o40 {
    public final cv a;

    public cu0(cv cvVar) {
        this.a = cvVar;
    }

    @Override // defpackage.o40
    public final ct0 c(cv cvVar) {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof cu0) {
            return e4.a(this.a, ((cu0) obj).a);
        }
        return false;
    }

    @Override // defpackage.o40
    public final /* bridge */ /* synthetic */ Collection getAnnotations() {
        return uq.b;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return cu0.class.getName() + ": " + this.a;
    }
}
