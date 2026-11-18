package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ba extends oc0 implements nw {
    public static final ba b;
    public static final ba b$1;
    public static final ba b$10;
    public static final ba b$11;
    public static final ba b$12;
    public static final ba b$13;
    public static final ba b$14;
    public static final ba b$15;
    public static final ba b$16;
    public static final ba b$17;
    public static final ba b$18;
    public static final ba b$19;
    public static final ba b$2;
    public static final ba b$20;
    public static final ba b$21;
    public static final ba b$22;
    public static final ba b$23;
    public static final ba b$24;
    public static final ba b$25;
    public static final ba b$26;
    public static final ba b$27;
    public static final ba b$28;
    public static final ba b$3;
    public static final ba b$4;
    public static final ba b$5;
    public static final ba b$6;
    public static final ba b$7;
    public static final ba b$8;
    public static final ba b$9;
    public final /* synthetic */ int G0;

    static {
        int i = 1;
        b$1 = new ba(i, i);
        b$2 = new ba(i, 2);
        b$3 = new ba(i, 3);
        b$4 = new ba(i, 4);
        b$5 = new ba(i, 5);
        b$6 = new ba(i, 6);
        b$7 = new ba(i, 7);
        b = new ba(i, 0);
        b$8 = new ba(i, 8);
        b$9 = new ba(i, 9);
        b$10 = new ba(i, 10);
        b$11 = new ba(i, 11);
        b$12 = new ba(i, 12);
        b$13 = new ba(i, 13);
        b$14 = new ba(i, 14);
        b$15 = new ba(i, 15);
        b$16 = new ba(i, 16);
        b$17 = new ba(i, 17);
        b$18 = new ba(i, 18);
        b$19 = new ba(i, 19);
        b$20 = new ba(i, 20);
        b$21 = new ba(i, 21);
        b$22 = new ba(i, 23);
        b$23 = new ba(i, 24);
        b$24 = new ba(i, 25);
        b$25 = new ba(i, 26);
        b$26 = new ba(i, 27);
        b$27 = new ba(i, 28);
        b$28 = new ba(i, 29);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ba(int i, int i2) {
        super(i);
        this.G0 = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(a80 a80Var) {
        super(1);
        this.G0 = 22;
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0205  */
    /* JADX WARN: Code duplicated, block: B:135:0x024f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.nw
    public final Object invoke(Object obj) {
        String string;
        boolean z = true;
        int i = 0;
        switch (this.G0) {
            case 0:
                la laVar = (la) obj;
                if (laVar instanceof ox) {
                    int i2 = aa.$r8$clinit;
                    z = c21.g.contains(e.p(laVar));
                }
                return Boolean.valueOf(z);
            case 1:
                return Boolean.valueOf(e.I(ym.l((la) obj)));
            case 2:
                int i3 = z9.$r8$clinit;
                q01 q01Var = (q01) ((la) obj);
                return Boolean.valueOf(ub0.A(q01Var) && ym.b(q01Var, new i(19, q01Var)) != null);
            case 3:
                la laVar2 = (la) obj;
                if (ub0.A(laVar2)) {
                    int i4 = aa.$r8$clinit;
                    if (c21.f.contains(((pk) laVar2).getName())) {
                        la laVarB = ym.b(laVar2, b);
                        String strP = laVarB != null ? e.p(laVarB) : null;
                        if (strP == null) {
                            z = false;
                        } else if (!c21.c.contains(strP)) {
                            LinkedHashMap linkedHashMap = c21.e;
                            Object obj2 = linkedHashMap.get(strP);
                            if (obj2 == null && !linkedHashMap.containsKey(strP)) {
                                throw new NoSuchElementException("Key " + ((Object) strP) + " is missing in the map.");
                            }
                            c21.b bVar = c21.b.c;
                        }
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 4:
                int i5 = aa.$r8$clinit;
                return Boolean.valueOf(c21.g.contains(e.p((la) obj)));
            case 5:
                return Boolean.valueOf(((ok) obj) instanceof ja);
            case 6:
                return Boolean.valueOf(!(((ok) obj) instanceof gh));
            case 7:
                return new ge(i, ((ja) ((ok) obj)).getTypeParameters());
            case 8:
                return ((ok) obj).b();
            case 9:
                Type ownerType = ((ParameterizedType) obj).getOwnerType();
                if (ownerType instanceof ParameterizedType) {
                    return (ParameterizedType) ownerType;
                }
                return null;
            case 10:
                return ae.B0(((ParameterizedType) obj).getActualTypeArguments());
            case 11:
                String str = (String) obj;
                if (str.length() <= 1) {
                    return str;
                }
                return "L" + str + ';';
            case 12:
                return Boolean.valueOf(((fc0) obj) instanceof ls0);
            case 13:
                return ((fc0) obj).toString();
            case 14:
                return ((la) obj).Q().getType();
            case 15:
                Map.Entry entry = (Map.Entry) obj;
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    string = Arrays.toString((boolean[]) value);
                } else if (value instanceof char[]) {
                    string = Arrays.toString((char[]) value);
                } else if (value instanceof byte[]) {
                    string = Arrays.toString((byte[]) value);
                } else if (value instanceof short[]) {
                    string = Arrays.toString((short[]) value);
                } else if (value instanceof int[]) {
                    string = Arrays.toString((int[]) value);
                } else if (value instanceof float[]) {
                    string = Arrays.toString((float[]) value);
                } else if (value instanceof long[]) {
                    string = Arrays.toString((long[]) value);
                } else if (value instanceof double[]) {
                    string = Arrays.toString((double[]) value);
                } else {
                    string = value instanceof Object[] ? Arrays.toString((Object[]) value) : value.toString();
                }
                return str2 + '=' + string;
            case 16:
                return ((la) obj).getReturnType();
            case 17:
                return ((ub0) obj).t(wp0.BOOLEAN);
            case 18:
                return ((ub0) obj).t(wp0.INT);
            case 19:
                return ((ub0) obj).x();
            case 20:
                return Integer.valueOf(((nr0) obj).f.size());
            case 21:
                return Boolean.valueOf(((cc1) obj) instanceof ls0);
            case 22:
                la laVar3 = (la) obj;
                if (laVar3.getKind() == la.a.b) {
                    ai0 ai0Var = (ai0) laVar3.b();
                    String str3 = l60.a;
                    z = l60.j.containsKey(xm.g(ai0Var));
                }
                return Boolean.valueOf(z);
            case 23:
                return null;
            case 24:
                return null;
            case 25:
                return ((fc0) obj).toString();
            case 26:
                return Boolean.valueOf(((cc1) obj).L0() instanceof mb);
            case 27:
                return null;
            case 28:
                return Boolean.valueOf(e.I((la) obj));
            default:
                return 0;
        }
    }
}
