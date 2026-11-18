package defpackage;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vk0 implements mb {
    public final ca1 a;
    public lw b;
    public final vk0 c;
    public final v91 d;
    public final Object e;

    public vk0(ca1 ca1Var, lw lwVar, vk0 vk0Var, v91 v91Var) {
        this.a = ca1Var;
        this.b = lwVar;
        this.c = vk0Var;
        this.d = v91Var;
        this.e = e.V(be0.b, new ca0(21, this));
    }

    public /* synthetic */ vk0(ca1 ca1Var, uk0 uk0Var, v91 v91Var, int i) {
        this(ca1Var, (i & 2) != 0 ? null : uk0Var, (vk0) null, (i & 8) != 0 ? null : v91Var);
    }

    @Override // defpackage.mb
    public final ca1 a() {
        return this.a;
    }

    @Override // defpackage.a91
    public final od b() {
        return null;
    }

    @Override // defpackage.a91
    public final boolean c() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, rc0] */
    @Override // defpackage.a91
    public final Collection d() {
        List list = (List) this.e.getValue();
        return list == null ? uq.b : list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (vk0.class.equals(obj == null ? null : obj.getClass())) {
            if (obj == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
                return false;
            }
            vk0 vk0Var = (vk0) obj;
            vk0 vk0Var2 = this.c;
            if (vk0Var2 == null) {
                vk0Var2 = this;
            }
            vk0 vk0Var3 = vk0Var.c;
            if (vk0Var3 != null) {
                vk0Var = vk0Var3;
            }
            if (vk0Var2 == vk0Var) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.a91
    public final List getParameters() {
        return uq.b;
    }

    public final int hashCode() {
        vk0 vk0Var = this.c;
        return vk0Var == null ? super.hashCode() : vk0Var.hashCode();
    }

    @Override // defpackage.a91
    public final ub0 k() {
        return this.a.getType().L0().k();
    }

    public final String toString() {
        return "CapturedType(" + this.a + ')';
    }
}
