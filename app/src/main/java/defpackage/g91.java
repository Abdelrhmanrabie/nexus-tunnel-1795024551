package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g91 extends oc0 implements nw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ e91 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g91(e91 e91Var, int i) {
        super(1);
        this.G0 = i;
        this.b = e91Var;
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        int i = this.G0;
        e91 e91Var = this.b;
        if (i != 0) {
            int iIntValue = ((Number) obj).intValue();
            if (i == 1) {
                hn hnVar = (hn) e91Var.a;
                dd ddVarX = e.x(hnVar.b, iIntValue);
                boolean z = ddVarX.c;
                fn fnVar = hnVar.a;
                if (!z) {
                    return e4.b(fnVar.b, ddVarX);
                }
                Set set = cd.c;
                cd cdVar = fnVar.s;
                cdVar.getClass();
                return (ai0) cdVar.b.invoke(new cd.a(ddVarX, null));
            }
            hn hnVar2 = (hn) e91Var.a;
            dd ddVarX2 = e.x(hnVar2.b, iIntValue);
            if (!ddVarX2.c) {
                od odVarB = e4.b(hnVar2.a.b, ddVarX2);
                if (odVarB instanceof co) {
                    return (co) odVarB;
                }
            }
        } else {
            nr0 nr0Var = (nr0) obj;
            fi0 fi0Var = ((hn) e91Var.a).d;
            int i2 = nr0Var.d;
            if ((i2 & 256) == 256) {
                return nr0Var.s;
            }
            if ((i2 & 512) == 512) {
                return fi0Var.a(nr0Var.t);
            }
        }
        return null;
    }
}
