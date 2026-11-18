package defpackage;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c91 extends d91 {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object c;

    public /* synthetic */ c91(int i, Object obj) {
        this.G0 = i;
        this.c = obj;
    }

    @Override // defpackage.ea1
    public boolean a() {
        if (this.G0 != 0) {
            return super.a();
        }
        return false;
    }

    @Override // defpackage.ea1
    public boolean e() {
        return this.G0 != 0 ? super.e() : ((Map) this.c).isEmpty();
    }

    @Override // defpackage.d91
    public final ca1 g(a91 a91Var) {
        int i = this.G0;
        Object obj = this.c;
        if (i == 0) {
            return (ca1) ((Map) obj).get(a91Var);
        }
        if (!((ArrayList) obj).contains(a91Var)) {
            return null;
        }
        od odVarB = a91Var.b();
        if (odVarB != null) {
            return ma1.m((v91) odVarB);
        }
        d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        return null;
    }
}
