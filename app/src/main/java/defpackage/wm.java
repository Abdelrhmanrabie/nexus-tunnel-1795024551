package defpackage;

import java.util.Collection;
import java.util.LinkedHashSet;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class wm extends rd {
    public final /* synthetic */ mr a;
    public final /* synthetic */ LinkedHashSet b;
    public final /* synthetic */ boolean c;

    public wm(mr mrVar, LinkedHashSet linkedHashSet, boolean z) {
        this.a = mrVar;
        this.b = linkedHashSet;
        this.c = z;
    }

    public static /* synthetic */ void h(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "fromSuper";
        } else if (i == 2) {
            objArr[0] = "fromCurrent";
        } else if (i == 3) {
            objArr[0] = XMLRPC.TAG_MEMBER;
        } else if (i != 4) {
            objArr[0] = "fakeOverride";
        } else {
            objArr[0] = "overridden";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
        if (i == 1 || i == 2) {
            objArr[2] = "conflict";
        } else if (i == 3 || i == 4) {
            objArr[2] = "setOverriddenDescriptors";
        } else {
            objArr[2] = "addFakeOverride";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // defpackage.v3
    public final void a(la laVar) {
        if (laVar == null) {
            h(0);
            throw null;
        }
        pn0.r(laVar, new j(3, this));
        this.b.add(laVar);
    }

    @Override // defpackage.v3
    public final void f(la laVar, Collection collection) {
        if (laVar == null) {
            h(3);
            throw null;
        }
        if (!this.c || laVar.getKind() == la.a.c) {
            laVar.E0(collection);
        }
    }

    @Override // defpackage.rd
    public final void g(la laVar, la laVar2) {
        if (laVar == null) {
            h(1);
            throw null;
        }
        if (laVar2 != null) {
            return;
        }
        h(2);
        throw null;
    }
}
