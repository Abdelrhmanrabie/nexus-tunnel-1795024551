package defpackage;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hm implements gc0.a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ ja b;
    public final /* synthetic */ ja c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends oc0 implements bx {
        public final /* synthetic */ ja b;
        public final /* synthetic */ ja c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ja jaVar, ja jaVar2) {
            super(2);
            this.b = jaVar;
            this.c = jaVar2;
        }

        @Override // defpackage.bx
        public final Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(e4.a((ok) obj, this.b) && e4.a((ok) obj2, this.c));
        }
    }

    public hm(ja jaVar, ja jaVar2, boolean z) {
        this.a = z;
        this.b = jaVar;
        this.c = jaVar2;
    }

    @Override // gc0.a
    public final boolean a(a91 a91Var, a91 a91Var2) {
        if (e4.a((Object) a91Var, (Object) a91Var2)) {
            return true;
        }
        od odVarB = a91Var.b();
        od odVarB2 = a91Var2.b();
        if (!(odVarB instanceof v91) || !(odVarB2 instanceof v91)) {
            return false;
        }
        return e.f31d.j((v91) odVarB, (v91) odVarB2, this.a, new a(this.b, this.c));
    }
}
