package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class fd0 extends xn0 {
    public static final /* synthetic */ ja0[] s;
    public final cu0 j;
    public final v8 n;
    public final ff0.h o;
    public final t80 p;
    public final gf0 q;
    public final s4 r;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends oc0 implements lw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ fd0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(fd0 fd0Var, int i) {
            super(0);
            this.G0 = i;
            this.b = fd0Var;
        }

        @Override // defpackage.lw
        public final Object invoke() {
            int i = this.G0;
            if (i == 0) {
                fd0 fd0Var = this.b;
                e eVar = ((c60) fd0Var.n.a).l;
                fd0Var.g.b();
                eVar.getClass();
                return ye1.j(new ArrayList());
            }
            if (i != 1) {
                this.b.j.getClass();
                return new ArrayList(ae.y0(uq.b));
            }
            HashMap map = new HashMap();
            ja0 ja0Var = fd0.s[0];
            for (Map.Entry entry : ((Map) this.b.o.invoke()).entrySet()) {
                String str = (String) entry.getKey();
                ju0 ju0Var = (ju0) entry.getValue();
                m80 m80VarC = m80.c(str);
                wb0 wb0Var = ju0Var.b;
                wb0.a aVar = wb0Var.a;
                int iOrdinal = aVar.ordinal();
                if (iOrdinal == 2) {
                    map.put(m80VarC, m80VarC);
                } else if (iOrdinal == 5) {
                    String str2 = aVar == wb0.a.MULTIFILE_CLASS_PART ? wb0Var.f : null;
                    if (str2 != null) {
                        map.put(m80VarC, m80.c(str2));
                    }
                }
            }
            return map;
        }
    }

    static {
        pu0 pu0Var = ou0.a;
        s = new ja0[]{pu0Var.f(new tq0(pu0Var.b(fd0.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), pu0Var.f(new tq0(pu0Var.b(fd0.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    public fd0(v8 v8Var, cu0 cu0Var) {
        super(((c60) v8Var.a).o, cu0Var.a);
        this.j = cu0Var;
        v8 v8VarA = uh.a(v8Var, this, null, 6);
        this.n = v8VarA;
        c60 c60Var = (c60) v8VarA.a;
        ff0 ff0Var = c60Var.a;
        a aVar = new a(this, 0);
        ff0Var.getClass();
        this.o = new ff0.h(ff0Var, aVar);
        this.p = new t80(v8VarA, cu0Var, this);
        this.q = new gf0(ff0Var, new a(this, 2));
        this.r = c60Var.v.c ? e4.f47a : e.Z(v8VarA, cu0Var);
        ff0Var.h(new a(this, 1));
    }

    @Override // defpackage.xn0, defpackage.rk, defpackage.qk
    public final t11 g() {
        return new qz(11, this);
    }

    @Override // defpackage.j0, defpackage.w3
    public final s4 getAnnotations() {
        return this.r;
    }

    @Override // defpackage.wn0
    public final vg0 m() {
        return this.p;
    }

    @Override // defpackage.xn0, defpackage.pk
    public final String toString() {
        return "Lazy Java package fragment: " + this.g + " of module " + ((c60) this.n.a).o;
    }
}
