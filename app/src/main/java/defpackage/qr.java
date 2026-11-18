package defpackage;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qr implements a91 {
    public final /* synthetic */ pr.b a;
    public final /* synthetic */ String b;

    public qr(String str, pr.b bVar) {
        this.a = bVar;
        this.b = str;
    }

    @Override // defpackage.a91
    public final od b() {
        return this.a;
    }

    @Override // defpackage.a91
    public final boolean c() {
        return false;
    }

    @Override // defpackage.a91
    public final Collection d() {
        return uq.b;
    }

    @Override // defpackage.a91
    public final List getParameters() {
        return uq.b;
    }

    @Override // defpackage.a91
    public final ub0 k() {
        yk ykVar = yk.f;
        if (ykVar != null) {
            return ykVar;
        }
        throw new IllegalStateException("@NotNull method kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2.getBuiltIns must not return null");
    }

    public final String toString() {
        return this.b;
    }
}
