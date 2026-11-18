package defpackage;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ld0 extends oc0 implements nw {
    public static final ld0 b;
    public static final ld0 b$1;
    public static final ld0 b$10;
    public static final ld0 b$11;
    public static final ld0 b$12;
    public static final ld0 b$13;
    public static final ld0 b$14;
    public static final ld0 b$15;
    public static final ld0 b$16;
    public static final ld0 b$17;
    public static final ld0 b$18;
    public static final ld0 b$19;
    public static final ld0 b$2;
    public static final ld0 b$20;
    public static final ld0 b$21;
    public static final ld0 b$22;
    public static final ld0 b$23;
    public static final ld0 b$24;
    public static final ld0 b$25;
    public static final ld0 b$26;
    public static final ld0 b$27;
    public static final ld0 b$28;
    public static final ld0 b$3;
    public static final ld0 b$4;
    public static final ld0 b$5;
    public static final ld0 b$6;
    public static final ld0 b$7;
    public static final ld0 b$8;
    public static final ld0 b$9;
    public final /* synthetic */ int G0;

    static {
        int i = 1;
        b$1 = new ld0(i, i);
        b = new ld0(i, 0);
        b$2 = new ld0(i, 2);
        b$3 = new ld0(i, 3);
        b$4 = new ld0(i, 4);
        b$5 = new ld0(i, 5);
        b$6 = new ld0(i, 6);
        b$7 = new ld0(i, 7);
        b$8 = new ld0(i, 8);
        b$9 = new ld0(i, 9);
        b$10 = new ld0(i, 10);
        b$11 = new ld0(i, 11);
        b$12 = new ld0(i, 12);
        b$13 = new ld0(i, 13);
        b$14 = new ld0(i, 14);
        b$15 = new ld0(i, 15);
        b$16 = new ld0(i, 16);
        b$17 = new ld0(i, 17);
        b$18 = new ld0(i, 18);
        b$19 = new ld0(i, 19);
        b$20 = new ld0(i, 20);
        b$21 = new ld0(i, 21);
        b$22 = new ld0(i, 22);
        b$23 = new ld0(i, 24);
        b$24 = new ld0(i, 25);
        b$25 = new ld0(i, 26);
        b$26 = new ld0(i, 27);
        b$27 = new ld0(i, 28);
        b$28 = new ld0(i, 29);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ld0(int i, int i2) {
        super(i);
        this.G0 = i2;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x019e  */
    /* JADX WARN: Code duplicated, block: B:107:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:110:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:115:0x01ce A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:130:0x01f3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:136:0x01c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x01ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x01ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x017f  */
    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        Collection collectionD;
        Iterator it;
        ok okVarB;
        int i = this.G0;
        yq yqVar = yq.b;
        tb1 tb1Var = tb1.a;
        boolean z = true;
        switch (i) {
            case 0:
                return (q01) obj;
            case 1:
                return (ja) obj;
            case 2:
                wc1 wc1Var = (wc1) he.U0(((ox) obj).f());
                z = (wc1Var == null || ym.a(wc1Var) || wc1Var.p != null) ? false : true;
                List list = ln0.b;
                if (z) {
                    return null;
                }
                return "last parameter should not have a default value or be a vararg";
            case 3:
                ox oxVar = (ox) obj;
                List list2 = ln0.b;
                ok okVarB2 = oxVar.b();
                if (!(okVarB2 instanceof ai0)) {
                    collectionD = oxVar.d();
                    if (collectionD.isEmpty()) {
                        return "must override ''equals()'' in Any";
                    }
                    it = collectionD.iterator();
                    while (it.hasNext()) {
                        okVarB = ((ox) it.next()).b();
                        if (okVarB instanceof ai0) {
                            ij0 ij0Var = ub0.e;
                            if (ub0.c((ai0) okVarB, m21.a.a)) {
                            }
                        }
                    }
                    return "must override ''equals()'' in Any";
                }
                ij0 ij0Var2 = ub0.e;
                if (!ub0.c((ai0) okVarB2, m21.a.a)) {
                    collectionD = oxVar.d();
                    if (collectionD.isEmpty()) {
                        return "must override ''equals()'' in Any";
                    }
                    it = collectionD.iterator();
                    while (it.hasNext()) {
                        okVarB = ((ox) it.next()).b();
                        if (okVarB instanceof ai0) {
                            ij0 ij0Var3 = ub0.e;
                            if (ub0.c((ai0) okVarB, m21.a.a)) {
                            }
                        }
                    }
                    return "must override ''equals()'' in Any";
                }
                return null;
            case 4:
                ox oxVar2 = (ox) obj;
                sc0 sc0VarN = oxVar2.N();
                if (sc0VarN == null) {
                    sc0VarN = oxVar2.Q();
                }
                List list3 = ln0.b;
                if (sc0VarN != null) {
                    fc0 returnType = oxVar2.getReturnType();
                    z = returnType == null ? false : gc0.a.e(returnType, sc0VarN.getType());
                }
                if (z) {
                    return null;
                }
                return "receiver must be a supertype of the return type";
            case 5:
                return ((wc1) obj).getType();
            case 6:
                return e4.j("(raw) ", (String) obj);
            case 7:
                return (q01) obj;
            case 8:
                return Boolean.valueOf(Modifier.isStatic(((zt0) obj).getModifiers()));
            case 9:
                tm tmVar = (tm) obj;
                tmVar.n();
                tmVar.k(yqVar);
                return tb1Var;
            case 10:
                tm tmVar2 = (tm) obj;
                tmVar2.n();
                tmVar2.k(yqVar);
                tmVar2.i();
                return tb1Var;
            case 11:
                ((tm) obj).n();
                return tb1Var;
            case 12:
                tm tmVar3 = (tm) obj;
                tmVar3.k(yqVar);
                tmVar3.e(qd$a.a$1);
                tmVar3.m(mo0.c);
                return tb1Var;
            case 13:
                tm tmVar4 = (tm) obj;
                tmVar4.j();
                tmVar4.e(qd$a.a);
                tmVar4.k(sm.d);
                return tb1Var;
            case 14:
                ((tm) obj).k(sm.c);
                return tb1Var;
            case 15:
                ((tm) obj).k(sm.d);
                return tb1Var;
            case 16:
                tm tmVar5 = (tm) obj;
                tmVar5.o();
                tmVar5.k(sm.d);
                return tb1Var;
            case 17:
                tm tmVar6 = (tm) obj;
                tmVar6.n();
                tmVar6.k(yqVar);
                tmVar6.e(qd$a.a$1);
                tmVar6.d();
                tmVar6.m(mo0.d);
                tmVar6.a();
                tmVar6.b();
                tmVar6.i();
                tmVar6.f();
                return tb1Var;
            case 18:
                tm tmVar7 = (tm) obj;
                tmVar7.e(qd$a.a$1);
                tmVar7.m(mo0.c);
                return tb1Var;
            case 19:
                return Boolean.valueOf(((Class) obj).getSimpleName().length() == 0);
            case 20:
                return (nq0) obj;
            case 21:
                od odVarB = ((cc1) obj).L0().b();
                return Boolean.valueOf(odVarB != null && (odVarB instanceof v91) && (((v91) odVarB).b() instanceof co));
            case 22:
                return (fc0) obj;
            case 23:
                String strJ = e4.j("java/util/", "Spliterator");
                s60 s60Var = np0.b;
                ((j01$a$a) obj).c(strJ, s60Var, s60Var);
                return tb1Var;
            case 24:
                String simpleName = ((Class) obj).getSimpleName();
                if (!ij0.g(simpleName)) {
                    simpleName = null;
                }
                if (simpleName != null) {
                    return ij0.f(simpleName);
                }
                return null;
            case 25:
                return bt0.b(((Method) obj).getReturnType());
            case 26:
                return bt0.b((Class) obj);
            case 27:
                od odVarB2 = ((cc1) obj).L0().b();
                if (odVarB2 == null || (!(odVarB2 instanceof co) && !(odVarB2 instanceof v91))) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 28:
                return ((vg0) obj).d();
            default:
                li.b bVar = (li.b) obj;
                if (bVar instanceof oi) {
                    return (oi) bVar;
                }
                return null;
        }
    }
}
