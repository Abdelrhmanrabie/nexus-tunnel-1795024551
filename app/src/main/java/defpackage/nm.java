package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class nm extends mm implements tm {
    public final um c;
    public final v41 d = new v41(new ca0(10, this));

    public nm(um umVar) {
        this.c = umVar;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0053 A[RETURN] */
    public static zh0 D(qg0 qg0Var) {
        boolean z = qg0Var instanceof ai0;
        zh0 zh0Var = zh0.f;
        zh0 zh0Var2 = zh0.b;
        if (z) {
            if (((ai0) qg0Var).v() == 2) {
                return zh0Var;
            }
            return zh0Var2;
        }
        ok okVarB = qg0Var.b();
        ai0 ai0Var = okVarB instanceof ai0 ? (ai0) okVarB : null;
        if (ai0Var != null && (qg0Var instanceof la)) {
            la laVar = (la) qg0Var;
            boolean zIsEmpty = laVar.d().isEmpty();
            zh0 zh0Var3 = zh0.d;
            if (zIsEmpty || ai0Var.p() == zh0Var2) {
                if (ai0Var.v() == 2 && !e4.a(laVar.getVisibility(), cn.a)) {
                    if (laVar.p() == zh0Var) {
                        return zh0Var;
                    }
                }
            }
            return zh0Var3;
        }
        return zh0Var2;
    }

    public static void Z(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    public static String k0(String str, String str2, String str3, String str4, String str5) {
        if (!str.startsWith(str2) || !str3.startsWith(str4)) {
            return null;
        }
        String strSubstring = str.substring(str2.length());
        String strSubstring2 = str3.substring(str4.length());
        String strJ = e4.j(str5, strSubstring);
        if (strSubstring.equals(strSubstring2)) {
            return strJ;
        }
        if (v(strSubstring, strSubstring2)) {
            return e4.j(strJ, "!");
        }
        return null;
    }

    public static boolean l0(fc0 fc0Var) {
        if (!e.L(fc0Var)) {
            return false;
        }
        List listK0 = fc0Var.K0();
        if (listK0 != null && listK0.isEmpty()) {
            return true;
        }
        Iterator it = listK0.iterator();
        while (it.hasNext()) {
            if (((ca1) it.next()).b()) {
                return false;
            }
        }
        return true;
    }

    public static final void u(nm nmVar, nq0 nq0Var, StringBuilder sb) {
        if (!nmVar.z()) {
            um umVar = nmVar.c;
            vm vmVar = umVar.g;
            ja0[] ja0VarArr = um.W;
            ja0 ja0Var = ja0VarArr[5];
            if (!((Boolean) vmVar.a).booleanValue()) {
                if (nmVar.y().contains(sm.j)) {
                    nmVar.G(sb, nq0Var, null);
                    w3 w3Var = nq0Var.D;
                    if (w3Var != null) {
                        nmVar.G(sb, w3Var, o4.FIELD);
                    }
                    w3 w3Var2 = nq0Var.E;
                    if (w3Var2 != null) {
                        nmVar.G(sb, w3Var2, o4.PROPERTY_DELEGATE_FIELD);
                    }
                    vm vmVar2 = umVar.G;
                    ja0 ja0Var2 = ja0VarArr[31];
                    if (((lq0) vmVar2.a) == lq0.c) {
                        w3 w3Var3 = nq0Var.B;
                        if (w3Var3 != null) {
                            nmVar.G(sb, w3Var3, o4.PROPERTY_GETTER);
                        }
                        wq0 wq0Var = nq0Var.C;
                        if (wq0Var != null) {
                            nmVar.G(sb, wq0Var, o4.PROPERTY_SETTER);
                            nmVar.G(sb, (wc1) he.a1(wq0Var.f()), o4.SETTER_PARAMETER);
                        }
                    }
                }
                nmVar.i0(nq0Var.getVisibility(), sb);
                nmVar.Q(sb, nmVar.y().contains(sm.t) && nq0Var.isConst(), "const");
                nmVar.N(nq0Var, sb);
                nmVar.P(sb, nq0Var);
                nmVar.U(sb, nq0Var);
                nmVar.Q(sb, nmVar.y().contains(sm.u) && nq0Var.s, "lateinit");
                nmVar.M(sb, nq0Var);
            }
            nmVar.f0(nq0Var, sb, false);
            nmVar.e0(sb, nq0Var.getTypeParameters(), true);
            nmVar.X(sb, nq0Var);
        }
        nmVar.R(nq0Var, sb, true);
        sb.append(": ");
        sb.append(nmVar.s(nq0Var.getType()));
        nmVar.Y(sb, nq0Var);
        nmVar.K(nq0Var, sb);
        nmVar.j0(nq0Var.getTypeParameters(), sb);
    }

    public static boolean v(String str, String str2) {
        if (e4.a(str, q31.b0(str2, "?", AppConfig.CUSTOM))) {
            return true;
        }
        if (str2.endsWith("?") && e4.j(str, "?").equals(str2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(str);
        sb.append(")?");
        return sb.toString().equals(str2);
    }

    public final zu0 A() {
        vm vmVar = this.c.C;
        ja0 ja0Var = um.W[27];
        return (zu0) vmVar.a;
    }

    public final mm$l$a B() {
        vm vmVar = this.c.B;
        ja0 ja0Var = um.W[26];
        return (mm$l$a) vmVar.a;
    }

    public final boolean C() {
        vm vmVar = this.c.j;
        ja0 ja0Var = um.W[8];
        return ((Boolean) vmVar.a).booleanValue();
    }

    public final String E(ok okVar) {
        ok okVarB;
        String str;
        StringBuilder sb = new StringBuilder();
        okVar.r0(new bj(27, this), sb);
        um umVar = this.c;
        vm vmVar = umVar.c;
        ja0[] ja0VarArr = um.W;
        ja0 ja0Var = ja0VarArr[1];
        if (((Boolean) vmVar.a).booleanValue() && !(okVar instanceof wn0) && !(okVar instanceof vd0) && (okVarB = okVar.b()) != null && !(okVarB instanceof gi0)) {
            sb.append(" ");
            int iOrdinal = A().ordinal();
            if (iOrdinal == 0) {
                str = "defined in";
            } else {
                if (iOrdinal != 1) {
                    d.AnonymousClass0.m();
                    return null;
                }
                str = "<i>defined in</i>";
            }
            sb.append(str);
            sb.append(" ");
            dv dvVarG = xm.g(okVarB);
            sb.append(dvVarG.a.isEmpty() ? "root package" : w(e.i1(dvVarG.f())));
            ja0 ja0Var2 = ja0VarArr[2];
            if (((Boolean) umVar.d.a).booleanValue() && (okVarB instanceof wn0) && (okVar instanceof qk)) {
                ((qk) okVar).g().getClass();
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Iterable, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [uq] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.ArrayList] */
    public final String F(g4 g4Var, o4 o4Var) {
        List listAsList;
        uc ucVarE;
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (o4Var != null) {
            sb.append(e4.j(o4Var.b, ":"));
        }
        fc0 type = g4Var.getType();
        sb.append(s(type));
        um umVar = this.c;
        vm vmVar = umVar.M;
        ja0[] ja0VarArr = um.W;
        ja0 ja0Var = ja0VarArr[37];
        if (((c4) vmVar.a).b) {
            Map mapH = g4Var.h();
            ja0 ja0Var2 = ja0VarArr[32];
            ?? arrayList = 0;
            arrayList = 0;
            ai0 ai0VarD = ((Boolean) umVar.H.a).booleanValue() ? ym.d(g4Var) : null;
            if (ai0VarD != null && (ucVarE = ai0VarD.E()) != null) {
                List listF = ucVarE.f();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listF) {
                    if (((wc1) obj).B0()) {
                        arrayList2.add(obj);
                    }
                }
                arrayList = new ArrayList(ae.y0(arrayList2));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((wc1) it.next()).getName());
                }
            }
            if (arrayList == 0) {
                arrayList = uq.b;
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (!mapH.containsKey((ij0) obj2)) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(ae.y0(arrayList3));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(e4.j(((ij0) it2.next()).b(), " = ..."));
            }
            Set<Map.Entry> setEntrySet = mapH.entrySet();
            ArrayList arrayList5 = new ArrayList(ae.y0(setEntrySet));
            for (Map.Entry entry : setEntrySet) {
                ij0 ij0Var = (ij0) entry.getKey();
                qg qgVar = (qg) entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ij0Var.b());
                sb2.append(" = ");
                sb2.append(!arrayList.contains(ij0Var) ? I(qgVar) : "...");
                arrayList5.add(sb2.toString());
            }
            ArrayList arrayListX0 = he.X0(arrayList5, arrayList4);
            if (arrayListX0.size() <= 1) {
                listAsList = he.g1(arrayListX0);
            } else {
                Object[] array = arrayListX0.toArray(new Comparable[0]);
                Comparable[] comparableArr = (Comparable[]) array;
                if (comparableArr.length > 1) {
                    Arrays.sort(comparableArr);
                }
                listAsList = Arrays.asList(array);
            }
            List list = listAsList;
            ja0 ja0Var3 = um.W[37];
            if (((c4) vmVar.a).c || !list.isEmpty()) {
                he.P0(list, sb, "(", ")", null, 112);
            }
        }
        if (C() && (e.O(type) || (type.L0().b() instanceof kl0$b))) {
            sb.append(" /* annotation class not found */");
        }
        return sb.toString();
    }

    public final void G(StringBuilder sb, w3 w3Var, o4 o4Var) {
        Set setG;
        if (y().contains(sm.j)) {
            boolean z = w3Var instanceof fc0;
            um umVar = this.c;
            if (z) {
                setG = umVar.g();
            } else {
                vm vmVar = umVar.J;
                ja0 ja0Var = um.W[34];
                setG = (Set) vmVar.a;
            }
            vm vmVar2 = umVar.L;
            ja0 ja0Var2 = um.W[36];
            nw nwVar = (nw) vmVar2.a;
            for (g4 g4Var : w3Var.getAnnotations()) {
                if (!setG.contains(g4Var.e()) && !e4.a(g4Var.e(), m21.a.q) && (nwVar == null || ((Boolean) nwVar.invoke(g4Var)).booleanValue())) {
                    sb.append(F(g4Var, o4Var));
                    ja0 ja0Var3 = um.W[33];
                    if (((Boolean) umVar.I.a).booleanValue()) {
                        sb.append('\n');
                    } else {
                        sb.append(" ");
                    }
                }
            }
        }
    }

    public final void H(pd pdVar, StringBuilder sb) {
        List listO = pdVar.o();
        List parameters = pdVar.h().getParameters();
        if (C() && pdVar.B() && parameters.size() > listO.size()) {
            sb.append(" /*captured type parameters: ");
            d0(parameters.subList(listO.size(), parameters.size()), sb);
            sb.append("*/");
        }
    }

    public final String I(qg qgVar) {
        if (qgVar instanceof h7) {
            return he.R0((Iterable) ((h7) qgVar).a, ", ", "{", "}", new om(this, 1), 24);
        }
        if (qgVar instanceof r4) {
            return q31.p0("@", F((g4) ((r4) qgVar).a, null));
        }
        if (!(qgVar instanceof m90)) {
            return qgVar.toString();
        }
        m90.a aVar = (m90.a) ((m90) qgVar).a;
        if (aVar instanceof m90.a.C0037a) {
            return ((m90.a.C0037a) aVar).a + "::class";
        }
        if (!(aVar instanceof m90.a.b)) {
            d.AnonymousClass0.m();
            return null;
        }
        ed edVar = ((m90.a.b) aVar).a;
        String strB = edVar.a.b().b();
        int i = 0;
        while (i < edVar.b) {
            i++;
            strB = "kotlin.Array<" + strB + '>';
        }
        return e4.j(strB, "::class");
    }

    public final void K(yc1 yc1Var, StringBuilder sb) {
        qg qgVarQ0;
        vm vmVar = this.c.u;
        ja0 ja0Var = um.W[19];
        if (!((Boolean) vmVar.a).booleanValue() || (qgVarQ0 = yc1Var.q0()) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(w(I(qgVarQ0)));
    }

    public final String L(String str) {
        int iOrdinal = A().ordinal();
        if (iOrdinal == 0) {
            return str;
        }
        if (iOrdinal != 1) {
            d.AnonymousClass0.m();
            return null;
        }
        vm vmVar = this.c.U;
        ja0 ja0Var = um.W[46];
        return ((Boolean) vmVar.a).booleanValue() ? str : e.n("<b>", str, "</b>");
    }

    public final void M(StringBuilder sb, la laVar) {
        if (y().contains(sm.o) && C() && laVar.getKind() != la.a.b) {
            sb.append("/*");
            sb.append(e.s0(laVar.getKind().name()));
            sb.append("*/ ");
        }
    }

    public final void N(qg0 qg0Var, StringBuilder sb) {
        Q(sb, qg0Var.b0(), "external");
        Q(sb, y().contains(sm.r) && qg0Var.l0(), "expect");
        Q(sb, y().contains(sm.s) && qg0Var.Z(), "actual");
    }

    public final void O(zh0 zh0Var, StringBuilder sb, zh0 zh0Var2) {
        vm vmVar = this.c.p;
        ja0 ja0Var = um.W[14];
        if (((Boolean) vmVar.a).booleanValue() || zh0Var != zh0Var2) {
            Q(sb, y().contains(sm.g), e.s0(zh0Var.name()));
        }
    }

    public final void P(StringBuilder sb, la laVar) {
        if (xm.t(laVar) && laVar.p() == zh0.b) {
            return;
        }
        vm vmVar = this.c.A;
        ja0 ja0Var = um.W[25];
        if (((on0) vmVar.a) == on0.b && laVar.p() == zh0.d && !laVar.d().isEmpty()) {
            return;
        }
        O(laVar.p(), sb, D(laVar));
    }

    public final void Q(StringBuilder sb, boolean z, String str) {
        if (z) {
            sb.append(L(str));
            sb.append(" ");
        }
    }

    public final void R(ok okVar, StringBuilder sb, boolean z) {
        sb.append(r(okVar.getName(), z));
    }

    public final void S(StringBuilder sb, fc0 fc0Var) {
        cc1 cc1VarO0 = fc0Var.O0();
        a aVar = cc1VarO0 instanceof a ? (a) cc1VarO0 : null;
        if (aVar == null) {
            T(sb, fc0Var);
            return;
        }
        um umVar = this.c;
        vm vmVar = umVar.Q;
        ja0[] ja0VarArr = um.W;
        ja0 ja0Var = ja0VarArr[41];
        boolean zBooleanValue = ((Boolean) vmVar.a).booleanValue();
        u01 u01Var = aVar.c;
        if (zBooleanValue) {
            T(sb, u01Var);
            return;
        }
        T(sb, aVar.d);
        ja0 ja0Var2 = ja0VarArr[40];
        if (((Boolean) umVar.P.a).booleanValue()) {
            zu0 zu0VarA = A();
            zu0.a aVar2 = zu0.c;
            if (zu0VarA == aVar2) {
                sb.append("<font color=\"808080\"><i>");
            }
            sb.append(" /* = ");
            T(sb, u01Var);
            sb.append(" */");
            if (A() == aVar2) {
                sb.append("</i></font>");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:114:0x022c  */
    /* JADX WARN: Code duplicated, block: B:117:0x0233  */
    /* JADX WARN: Code duplicated, block: B:118:0x0236  */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:12:0x0028  */
    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    public final void T(StringBuilder sb, fc0 fc0Var) {
        cc1 cc1VarO0;
        u01 u01Var;
        String strT0;
        String strB0;
        String strW;
        um umVar = this.c;
        if ((fc0Var instanceof de0) && umVar.h()) {
            ff0.h hVar = ((de0) fc0Var).f;
            if (hVar.d == ff0.l.b || hVar.d == ff0.l.c) {
                strT0 = "<Not computed yet>";
            } else {
                cc1VarO0 = fc0Var.O0();
                if (cc1VarO0 instanceof zt) {
                    strT0 = ((zt) cc1VarO0).T0(this, this);
                } else {
                    if (cc1VarO0 instanceof u01) {
                        return;
                    }
                    u01Var = (u01) cc1VarO0;
                    if (u01Var.equals(ma1.b)) {
                        strT0 = "???";
                    } else {
                        strT0 = "???";
                    }
                }
            }
        } else {
            cc1VarO0 = fc0Var.O0();
            if (cc1VarO0 instanceof zt) {
                strT0 = ((zt) cc1VarO0).T0(this, this);
            } else {
                if (cc1VarO0 instanceof u01) {
                    return;
                }
                u01Var = (u01) cc1VarO0;
                if (u01Var.equals(ma1.b) || u01Var.L0() == ma1.a.c) {
                    strT0 = "???";
                } else {
                    u01Var.L0();
                    int i = 0;
                    if (!e.O((fc0) u01Var) && l0(u01Var)) {
                        int length = sb.length();
                        ((nm) this.d.getValue()).G(sb, u01Var, null);
                        boolean z = sb.length() != length;
                        boolean zR = e.R((fc0) u01Var);
                        boolean zM0 = u01Var.M0();
                        fc0 fc0VarG = e.G(u01Var);
                        boolean z2 = zM0 || (z && fc0VarG != null);
                        if (z2) {
                            if (zR) {
                                sb.insert(length, '(');
                            } else {
                                if (z) {
                                    if (sb.length() == 0) {
                                        throw new NoSuchElementException("Char sequence is empty.");
                                    }
                                    e.l(sb.charAt(sb.length() - 1));
                                    if (sb.charAt(sb.length() - 2) != ')') {
                                        sb.insert(sb.length() - 1, "()");
                                    }
                                }
                                sb.append("(");
                            }
                        }
                        Q(sb, zR, "suspend");
                        if (fc0VarG != null) {
                            boolean z3 = (l0(fc0VarG) && !fc0VarG.M0()) || e.R(fc0VarG) || !fc0VarG.getAnnotations().isEmpty();
                            if (z3) {
                                sb.append("(");
                            }
                            S(sb, fc0VarG);
                            if (z3) {
                                sb.append(")");
                            }
                            sb.append(".");
                        }
                        sb.append("(");
                        int i2 = 0;
                        for (ca1 ca1Var : e.J(u01Var)) {
                            int i3 = i2 + 1;
                            if (i2 > 0) {
                                sb.append(", ");
                            }
                            vm vmVar = umVar.S;
                            ja0 ja0Var = um.W[43];
                            ij0 ij0VarZ = ((Boolean) vmVar.a).booleanValue() ? e.z(ca1Var.getType()) : null;
                            if (ij0VarZ != null) {
                                sb.append(r(ij0VarZ, false));
                                sb.append(": ");
                            }
                            StringBuilder sb2 = new StringBuilder();
                            he.P0(Collections.singletonList(ca1Var), sb2, null, null, new om(this, i), 60);
                            sb.append(sb2.toString());
                            i2 = i3;
                        }
                        sb.append(") ");
                        int iOrdinal = A().ordinal();
                        if (iOrdinal == 0) {
                            strW = w("->");
                        } else {
                            if (iOrdinal != 1) {
                                d.AnonymousClass0.m();
                                return;
                            }
                            strW = "&rarr;";
                        }
                        sb.append(strW);
                        sb.append(" ");
                        e.L(u01Var);
                        S(sb, ((ca1) he.T0(u01Var.K0())).getType());
                        if (z2) {
                            sb.append(")");
                        }
                        if (zM0) {
                            sb.append("?");
                            return;
                        }
                        return;
                    }
                    G(sb, u01Var, null);
                    if (!e.O((fc0) u01Var)) {
                        a91 a91VarL0 = u01Var.L0();
                        od odVarB = u01Var.L0().b();
                        m6 m6VarA = e4.a(u01Var, odVarB instanceof pd ? (pd) odVarB : null, 0);
                        if (m6VarA == null) {
                            strB0 = b0(a91VarL0);
                        } else {
                            W(sb, m6VarA);
                        }
                        if (u01Var.M0()) {
                            sb.append("?");
                        }
                        if (u01Var instanceof ml) {
                            return;
                        } else {
                            strT0 = " & Any";
                        }
                    } else if (u01Var instanceof or) {
                        vm vmVar2 = umVar.V;
                        ja0 ja0Var2 = um.W[47];
                        if (((Boolean) vmVar2.a).booleanValue()) {
                            strB0 = u01Var.L0().toString();
                        } else {
                            strB0 = ((or) u01Var).i;
                        }
                    } else {
                        strB0 = u01Var.L0().toString();
                    }
                    sb.append(strB0);
                    sb.append(a0(u01Var.K0()));
                    if (u01Var.M0()) {
                        sb.append("?");
                    }
                    if (u01Var instanceof ml) {
                        return;
                    } else {
                        strT0 = " & Any";
                    }
                }
            }
        }
        sb.append(strT0);
    }

    public final void U(StringBuilder sb, la laVar) {
        if (y().contains(sm.i) && !laVar.d().isEmpty()) {
            vm vmVar = this.c.A;
            ja0 ja0Var = um.W[25];
            if (((on0) vmVar.a) != on0.c) {
                Q(sb, true, "override");
                if (C()) {
                    sb.append("/*");
                    sb.append(laVar.d().size());
                    sb.append("*/ ");
                }
            }
        }
    }

    public final void V(cv cvVar, String str, StringBuilder sb) {
        sb.append(L(str));
        String strW = w(e.i1(cvVar.i().f()));
        if (strW.length() > 0) {
            sb.append(" ");
            sb.append(strW);
        }
    }

    public final void W(StringBuilder sb, m6 m6Var) {
        StringBuilder sb2;
        m6 m6Var2 = (m6) m6Var.c;
        pd pdVar = (pd) m6Var.a;
        if (m6Var2 == null) {
            sb2 = null;
        } else {
            W(sb, m6Var2);
            sb.append('.');
            sb.append(r(pdVar.getName(), false));
            sb2 = sb;
        }
        if (sb2 == null) {
            sb.append(b0(pdVar.h()));
        }
        sb.append(a0((List) m6Var.b));
    }

    public final void X(StringBuilder sb, ja jaVar) {
        sc0 sc0VarQ = jaVar.Q();
        if (sc0VarQ != null) {
            G(sb, sc0VarQ, o4.RECEIVER);
            fc0 type = sc0VarQ.getType();
            String strS = s(type);
            if (l0(type) && !ma1.g(type)) {
                strS = "(" + strS + ')';
            }
            sb.append(strS);
            sb.append(".");
        }
    }

    public final void Y(StringBuilder sb, ja jaVar) {
        sc0 sc0VarQ;
        vm vmVar = this.c.E;
        ja0 ja0Var = um.W[29];
        if (((Boolean) vmVar.a).booleanValue() && (sc0VarQ = jaVar.Q()) != null) {
            sb.append(" on ");
            sb.append(s(sc0VarQ.getType()));
        }
    }

    @Override // defpackage.tm
    public final void a() {
        this.c.a();
    }

    public final String a0(List list) {
        if (list.isEmpty()) {
            return AppConfig.CUSTOM;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(w("<"));
        he.P0(list, sb, null, null, new om(this, 0), 60);
        sb.append(w(">"));
        return sb.toString();
    }

    @Override // defpackage.tm
    public final void b() {
        this.c.b();
    }

    public final String b0(a91 a91Var) {
        List listAsList;
        od odVarB = a91Var.b();
        if (odVarB instanceof v91 ? true : odVarB instanceof ai0 ? true : odVarB instanceof co) {
            if (pr.h(odVarB)) {
                return odVarB.h().toString();
            }
            vm vmVar = this.c.b;
            ja0 ja0Var = um.W[0];
            return ((qd$a) vmVar.a).a(odVarB, this);
        }
        if (odVarB != null) {
            throw new IllegalStateException(e4.j("Unexpected classifier: ", odVarB.getClass()).toString());
        }
        if (!(a91Var instanceof j30)) {
            return a91Var.toString();
        }
        ld0 ld0Var = ld0.b$22;
        LinkedHashSet linkedHashSet = ((j30) a91Var).b;
        j30.b bVar = new j30.b(ld0Var);
        if (linkedHashSet.size() <= 1) {
            listAsList = he.g1(linkedHashSet);
        } else {
            Object[] array = linkedHashSet.toArray(new Object[0]);
            if (array.length > 1) {
                Arrays.sort(array, bVar);
            }
            listAsList = Arrays.asList(array);
        }
        return he.R0(listAsList, " & ", "{", "}", new i(ld0Var), 24);
    }

    public final void c0(v91 v91Var, StringBuilder sb, boolean z) {
        if (z) {
            sb.append(w("<"));
        }
        if (C()) {
            sb.append("/*");
            sb.append(v91Var.getIndex());
            sb.append("*/ ");
        }
        Q(sb, v91Var.x(), "reified");
        String str = v91Var.j().b;
        boolean z2 = true;
        Q(sb, str.length() > 0, str);
        G(sb, v91Var, null);
        R(v91Var, sb, z);
        int size = v91Var.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            fc0 fc0Var = (fc0) v91Var.getUpperBounds().iterator().next();
            if (fc0Var == null) {
                ub0.a(141);
                throw null;
            }
            if (!ub0.y(fc0Var) || !fc0Var.M0()) {
                sb.append(" : ");
                sb.append(s(fc0Var));
            }
        } else if (z) {
            for (fc0 fc0Var2 : v91Var.getUpperBounds()) {
                if (fc0Var2 == null) {
                    ub0.a(141);
                    throw null;
                }
                if (!ub0.y(fc0Var2) || !fc0Var2.M0()) {
                    if (z2) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    sb.append(s(fc0Var2));
                    z2 = false;
                }
            }
        }
        if (z) {
            sb.append(w(">"));
        }
    }

    @Override // defpackage.tm
    public final void d() {
        this.c.d();
    }

    public final void d0(List list, StringBuilder sb) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c0((v91) it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    @Override // defpackage.tm
    public final void e(qd$a qd_a) {
        this.c.e(qd_a);
    }

    public final void e0(StringBuilder sb, List list, boolean z) {
        vm vmVar = this.c.v;
        ja0 ja0Var = um.W[20];
        if (((Boolean) vmVar.a).booleanValue() || list.isEmpty()) {
            return;
        }
        sb.append(w("<"));
        d0(list, sb);
        sb.append(w(">"));
        if (z) {
            sb.append(" ");
        }
    }

    @Override // defpackage.tm
    public final void f() {
        this.c.f();
    }

    public final void f0(yc1 yc1Var, StringBuilder sb, boolean z) {
        if (z || !(yc1Var instanceof wc1)) {
            sb.append(L(yc1Var.P() ? "var" : "val"));
            sb.append(" ");
        }
    }

    @Override // defpackage.tm
    public final Set g() {
        return this.c.g();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0063  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e4  */
    public final void g0(wc1 wc1Var, boolean z, StringBuilder sb, boolean z2) {
        boolean z3;
        boolean z4;
        if (z2) {
            sb.append(L("value-parameter"));
            sb.append(" ");
        }
        if (C()) {
            sb.append("/*");
            sb.append(wc1Var.i);
            sb.append("*/ ");
        }
        G(sb, wc1Var, null);
        Q(sb, wc1Var.n, "crossinline");
        Q(sb, wc1Var.o, "noinline");
        um umVar = this.c;
        vm vmVar = umVar.r;
        vm vmVar2 = umVar.y;
        ja0[] ja0VarArr = um.W;
        ja0 ja0Var = ja0VarArr[16];
        if (((Boolean) vmVar.a).booleanValue()) {
            ja jaVarB = wc1Var.b();
            uc ucVar = jaVarB instanceof uc ? (uc) jaVarB : null;
            if (ucVar != null && ucVar.J) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            z3 = false;
        }
        if (z3) {
            ja0 ja0Var2 = ja0VarArr[17];
            Q(sb, ((Boolean) umVar.s.a).booleanValue(), "actual");
        }
        fc0 type = wc1Var.getType();
        fc0 fc0Var = wc1Var.p;
        fc0 fc0Var2 = fc0Var == null ? type : fc0Var;
        Q(sb, fc0Var != null, "vararg");
        if (z3 || (z2 && !z())) {
            f0(wc1Var, sb, z3);
        }
        if (z) {
            R(wc1Var, sb, z2);
            sb.append(": ");
        }
        sb.append(s(fc0Var2));
        K(wc1Var, sb);
        if (C() && fc0Var != null) {
            sb.append(" /*");
            sb.append(s(type));
            sb.append("*/");
        }
        ja0 ja0Var3 = ja0VarArr[23];
        if (((nw) vmVar2.a) != null) {
            z4 = umVar.h() ? wc1Var.B0() : ym.a(wc1Var);
        }
        if (z4) {
            ja0 ja0Var4 = ja0VarArr[23];
            sb.append(e4.j(" = ", ((nw) vmVar2.a).invoke(wc1Var)));
        }
    }

    public final void h0(StringBuilder sb, List list, boolean z) {
        vm vmVar = this.c.D;
        ja0 ja0Var = um.W[28];
        int iOrdinal = ((mo0) vmVar.a).ordinal();
        boolean z2 = true;
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    d.AnonymousClass0.m();
                    return;
                }
            } else if (z) {
            }
            z2 = false;
        }
        int size = list.size();
        B().getClass();
        sb.append("(");
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            wc1 wc1Var = (wc1) it.next();
            B().getClass();
            g0(wc1Var, z2, sb, false);
            B().getClass();
            if (i != size - 1) {
                sb.append(", ");
            }
            i = i2;
        }
        B().getClass();
        sb.append(")");
    }

    @Override // defpackage.tm
    public final void i() {
        this.c.i();
    }

    public final boolean i0(cn.d dVar, StringBuilder sb) {
        if (!y().contains(sm.f)) {
            return false;
        }
        um umVar = this.c;
        vm vmVar = umVar.n;
        ja0[] ja0VarArr = um.W;
        ja0 ja0Var = ja0VarArr[12];
        if (((Boolean) vmVar.a).booleanValue()) {
            dVar = cn.g(dVar.a.c());
        }
        ja0 ja0Var2 = ja0VarArr[13];
        if (!((Boolean) umVar.o.a).booleanValue() && e4.a(dVar, cn.k)) {
            return false;
        }
        sb.append(L(dVar.a.b()));
        sb.append(" ");
        return true;
    }

    @Override // defpackage.tm
    public final void j() {
        this.c.j();
    }

    public final void j0(List list, StringBuilder sb) {
        vm vmVar = this.c.v;
        ja0 ja0Var = um.W[20];
        if (((Boolean) vmVar.a).booleanValue()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v91 v91Var = (v91) it.next();
            Iterator it2 = he.G0(v91Var.getUpperBounds()).iterator();
            while (it2.hasNext()) {
                arrayList.add(r(v91Var.getName(), false) + " : " + s((fc0) it2.next()));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        sb.append(" ");
        sb.append(L("where"));
        sb.append(" ");
        he.P0(arrayList, sb, null, null, null, R.styleable.AppCompatTheme_windowMinWidthMajor);
    }

    @Override // defpackage.tm
    public final void k(Set set) {
        this.c.k(set);
    }

    @Override // defpackage.tm
    public final void l(LinkedHashSet linkedHashSet) {
        this.c.l(linkedHashSet);
    }

    @Override // defpackage.tm
    public final void m(mo0 mo0Var) {
        this.c.m(mo0Var);
    }

    @Override // defpackage.tm
    public final void n() {
        this.c.n();
    }

    @Override // defpackage.tm
    public final void o() {
        this.c.o();
    }

    public final String p(String str, String str2, ub0 ub0Var) {
        if (v(str, str2)) {
            return str2.startsWith("(") ? e.n("(", str, ")!") : e4.j(str, "!");
        }
        um umVar = this.c;
        vm vmVar = umVar.b;
        ja0[] ja0VarArr = um.W;
        ja0 ja0Var = ja0VarArr[0];
        String strA = ((qd$a) vmVar.a).a(ub0Var.j(m21.a.A), this);
        int iK0 = q31.k0(strA, "Collection", 0, 6);
        if (iK0 != -1) {
            strA = strA.substring(0, iK0);
        }
        String strK0 = k0(str, e4.j(strA, "Mutable"), str2, strA, strA.concat("(Mutable)"));
        if (strK0 != null) {
            return strK0;
        }
        String strK1 = k0(str, e4.j(strA, "MutableMap.MutableEntry"), str2, e4.j(strA, "Map.Entry"), e4.j(strA, "(Mutable)Map.(Mutable)Entry"));
        if (strK1 != null) {
            return strK1;
        }
        vm vmVar2 = umVar.b;
        ja0 ja0Var2 = ja0VarArr[0];
        String strA2 = ((qd$a) vmVar2.a).a(ub0Var.k("Array"), this);
        int iK1 = q31.k0(strA2, "Array", 0, 6);
        if (iK1 != -1) {
            strA2 = strA2.substring(0, iK1);
        }
        String strK2 = k0(str, e4.j(strA2, w("Array<")), str2, e4.j(strA2, w("Array<out ")), e4.j(strA2, w("Array<(out) ")));
        if (strK2 != null) {
            return strK2;
        }
        return "(" + str + ".." + str2 + ')';
    }

    public final String r(ij0 ij0Var, boolean z) {
        String strW = w(e.h1(ij0Var));
        vm vmVar = this.c.U;
        ja0 ja0Var = um.W[46];
        return (((Boolean) vmVar.a).booleanValue() && A() == zu0.c && z) ? e.n("<b>", strW, "</b>") : strW;
    }

    public final String s(fc0 fc0Var) {
        StringBuilder sb = new StringBuilder();
        vm vmVar = this.c.x;
        ja0 ja0Var = um.W[22];
        S(sb, (fc0) ((nw) vmVar.a).invoke(fc0Var));
        return sb.toString();
    }

    public final String w(String str) {
        return A().a(str);
    }

    public final Set y() {
        vm vmVar = this.c.e;
        ja0 ja0Var = um.W[3];
        return (Set) vmVar.a;
    }

    public final boolean z() {
        vm vmVar = this.c.f;
        ja0 ja0Var = um.W[4];
        return ((Boolean) vmVar.a).booleanValue();
    }
}
