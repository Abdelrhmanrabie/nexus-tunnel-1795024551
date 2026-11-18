package defpackage;

import java.io.ByteArrayInputStream;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class k90 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k90(Object obj, Object obj2, Object obj3, int i) {
        super(0);
        this.G0 = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        if (i != 0) {
            if (i != 1) {
                return ((ar0.a) this.b).c((ByteArrayInputStream) this.c, ((vn) this.d).b.a.p);
            }
            rg0 rg0Var = (rg0) this.b;
            return (qg) rg0Var.a.a.e.j(rg0Var.a(rg0Var.a.c), (kr0) this.c, ((ao) this.d).getType());
        }
        od odVarB = ((fc0) this.b).L0().b();
        if (!(odVarB instanceof ai0)) {
            throw new yi(e4.j("Supertype not a class: ", odVarB));
        }
        Class clsH = lc1.h((ai0) odVarB);
        j90.a aVar = (j90.a) this.c;
        if (clsH == null) {
            throw new yi("Unsupported superclass of " + aVar + ": " + odVarB);
        }
        Class cls = ((j90) this.d).c;
        if (e4.a(cls.getSuperclass(), clsH)) {
            return cls.getGenericSuperclass();
        }
        int iH0 = ae.H0(cls.getInterfaces(), clsH);
        if (iH0 >= 0) {
            return cls.getGenericInterfaces()[iH0];
        }
        throw new yi("No superclass of " + aVar + " in Java reflection for " + odVarB);
    }
}
