package defpackage;

import android.content.res.Resources;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class p0 extends oc0 implements nw {
    public static final p0 b;
    public static final p0 b$1;
    public static final p0 b$10;
    public static final p0 b$11;
    public static final p0 b$12;
    public static final p0 b$13;
    public static final p0 b$14;
    public static final p0 b$15;
    public static final p0 b$16;
    public static final p0 b$17;
    public static final p0 b$18;
    public static final p0 b$2;
    public static final p0 b$3;
    public static final p0 b$4;
    public static final p0 b$5;
    public static final p0 b$6;
    public static final p0 b$7;
    public static final p0 b$8;
    public static final p0 b$9;
    public final /* synthetic */ int G0;

    static {
        int i = 1;
        b = new p0(i, i);
        b$1 = new p0(i, 2);
        b$2 = new p0(i, 3);
        b$3 = new p0(i, 4);
        b$4 = new p0(i, 5);
        b$5 = new p0(i, 6);
        b$6 = new p0(i, 7);
        b$7 = new p0(i, 8);
        b$8 = new p0(i, 9);
        b$9 = new p0(i, 10);
        b$10 = new p0(i, 11);
        b$11 = new p0(i, 12);
        b$12 = new p0(i, 13);
        b$13 = new p0(i, 14);
        b$14 = new p0(i, 15);
        b$15 = new p0(i, 16);
        b$16 = new p0(i, 18);
        b$17 = new p0(i, 19);
        b$18 = new p0(i, 20);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p0(int i, int i2) {
        super(i);
        this.G0 = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(v9 v9Var) {
        super(1);
        this.G0 = 17;
    }

    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        int i = 0;
        switch (this.G0) {
            case 0:
                ((lc0$a) obj).getClass();
                return null;
            case 1:
                wc1 wc1VarO0 = e.O0(n40.b, ((gi0) obj).k().j(m21.a.s));
                return wc1VarO0 == null ? pr.d("Error: AnnotationTarget[]") : wc1VarO0.getType();
            case 2:
                od odVarB = ((fc0) obj).L0().b();
                if (odVarB instanceof ai0) {
                    return (ai0) odVarB;
                }
                return null;
            case 3:
                tm tmVar = (tm) obj;
                tmVar.l(nz0.x1(tmVar.g(), Collections.singletonList(m21.a.p)));
                return tb1.a;
            case 4:
                ox oxVar = (ox) obj;
                return mm.b.E(oxVar) + " | " + uw0.c(oxVar).a();
            case 5:
                return AppConfig.CUSTOM;
            case 6:
                nq0 nq0Var = (nq0) obj;
                return mm.b.E(nq0Var) + " | " + uw0.b(nq0Var).a();
            case 7:
                nm nmVar = ru0.a;
                return ru0.a.s(((wc1) obj).getType());
            case 8:
                ((Boolean) obj).getClass();
                return new s0.a(Collections.singletonList(pr.c));
            case 9:
                nm nmVar2 = ru0.a;
                return ru0.a.s(((wc1) obj).getType());
            case 10:
                vd0 vd0VarU = ((gi0) obj).U(u70.f);
                vd0VarU.getClass();
                ja0 ja0Var = vd0.n[0];
                List list = (List) vd0VarU.g.invoke();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (obj2 instanceof v9) {
                        arrayList.add(obj2);
                    }
                }
                return (v9) he.K0(arrayList);
            case 11:
                return new ge(i, (s4) obj);
            case 12:
                return "...";
            case 13:
                return (fc0) obj;
            case 14:
                return Boolean.TRUE;
            case 15:
                return bt0.b((Class) obj);
            case 16:
                return Boolean.valueOf((((Resources) obj).getConfiguration().uiMode & 48) == 32);
            case 17:
                return t11.a;
            case 18:
                return Boolean.TRUE;
            case 19:
                return Boolean.valueOf(!Modifier.isStatic(((zt0) obj).getModifiers()));
            default:
                return ((xn0) ((wn0) obj)).g;
        }
    }
}
