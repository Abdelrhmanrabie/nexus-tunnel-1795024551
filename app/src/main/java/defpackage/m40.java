package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class m40 implements g4, kp0 {
    public static final /* synthetic */ ja0[] f;
    public final cv a;
    public final t11 b;
    public final ff0.h c;
    public final dt0 d;

    static {
        pu0 pu0Var = ou0.a;
        f = new ja0[]{pu0Var.f(new tq0(pu0Var.b(m40.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    }

    public m40(v8 v8Var, ct0 ct0Var, cv cvVar) {
        t11 tw0_a;
        this.a = cvVar;
        c60 c60Var = (c60) v8Var.a;
        if (ct0Var == null) {
            tw0_a = t11.a;
        } else {
            c60Var.j.getClass();
            tw0_a = new tw0$a(ct0Var);
        }
        this.b = tw0_a;
        ff0 ff0Var = c60Var.a;
        qn qnVar = new qn(9, v8Var, this);
        ff0Var.getClass();
        this.c = new ff0.h(ff0Var, qnVar);
        this.d = ct0Var == null ? null : (dt0) he.L0(ct0Var.g());
    }

    @Override // defpackage.g4
    public final cv e() {
        return this.a;
    }

    @Override // defpackage.g4
    public final t11 g() {
        return this.b;
    }

    @Override // defpackage.g4
    public final fc0 getType() {
        ja0 ja0Var = f[0];
        return (u01) this.c.invoke();
    }

    @Override // defpackage.g4
    public Map h() {
        return vq.b;
    }
}
