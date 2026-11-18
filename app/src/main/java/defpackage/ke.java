package defpackage;

import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class ke implements bx, mr, li.c, gc0.a, t11, g31.a, hh, y91, w41 {
    public static g40$a b;
    public final /* synthetic */ int G0;
    public static final ke a = new ke(1);
    public static final ke a$1 = new ke(2);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final /* synthetic */ ke f52b = new ke(13);
    public static final ke a$2 = new ke(19);
    public static final ke a$3 = new ke(21);
    public static final /* synthetic */ ke a$4 = new ke(24);
    public static final ke a$5 = new ke(28);

    public /* synthetic */ ke(int i) {
        this.G0 = i;
    }

    public ke(ff0 ff0Var) {
        this.G0 = 10;
        new ff0.c(ff0Var, new ConcurrentHashMap(3, 1.0f, 2));
    }

    public /* synthetic */ ke(Thread thread, int i) {
        this.G0 = i;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0091  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:59:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:87:0x018e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0190  */
    /* JADX WARN: Code duplicated, block: B:90:0x0196  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v10 */
    public static c.a a(u01 u01Var, nw nwVar, int i, int i2, boolean z, boolean z2) {
        od odVarB;
        ai0 ai0VarQ;
        Boolean bool;
        ha haVar;
        ad1 ad1VarC;
        ad1 ad1VarJ;
        da1 da1Var;
        ak.r(i2, "<this>");
        ?? r5 = 0;
        Object[] objArr = i2 != 3;
        Object[] objArr2 = (z2 && z) ? false : true;
        Object obj = null;
        if ((objArr != false || !u01Var.K0().isEmpty()) && (odVarB = u01Var.L0().b()) != null) {
            s60 s60Var = (s60) nwVar.invoke(Integer.valueOf(i));
            t4 t4Var = k91.a;
            ak.r(i2, "<this>");
            if ((i2 != 3) != true || !(odVarB instanceof ai0)) {
                ai0VarQ = null;
            } else if (s60Var.b == vi0.b && i2 == 1) {
                ai0 ai0Var = (ai0) odVarB;
                String str = l60.a;
                dv dvVarG = xm.g(ai0Var);
                HashMap map = l60.j;
                if (map.containsKey(dvVarG)) {
                    cv cvVar = (cv) map.get(xm.g(ai0Var));
                    if (cvVar == null) {
                        d.AnonymousClass0.m$1("Given class ", ai0Var, " is not a mutable collection");
                        return null;
                    }
                    ai0VarQ = ym.e(ai0Var).j(cvVar);
                } else if (s60Var.b == vi0.c) {
                    ai0VarQ = null;
                } else {
                    ai0VarQ = null;
                }
            } else if (s60Var.b == vi0.c || i2 != 2) {
                ai0VarQ = null;
            } else {
                ai0 ai0Var2 = (ai0) odVarB;
                String str2 = l60.a;
                if (l60.k.containsKey(xm.g(ai0Var2))) {
                    ai0VarQ = e.q(ai0Var2);
                } else {
                    ai0VarQ = null;
                }
            }
            ak.r(i2, "<this>");
            if (i2 == 3) {
                bool = null;
            } else {
                am0 am0Var = s60Var.a;
                int i3 = am0Var == null ? -1 : k91.a.a[am0Var.ordinal()];
                if (i3 == 1) {
                    bool = Boolean.TRUE;
                } else if (i3 != 2) {
                    bool = null;
                } else {
                    bool = Boolean.FALSE;
                }
            }
            a91 a91VarL0 = ai0VarQ == null ? u01Var.L0() : ai0VarQ.h();
            int i4 = i + 1;
            List listK0 = u01Var.K0();
            List parameters = a91VarL0.getParameters();
            Iterator it = listK0.iterator();
            Iterator it2 = parameters.iterator();
            ArrayList arrayList = new ArrayList(Math.min(ae.y0(listK0), ae.y0(parameters)));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                v91 v91Var = (v91) it2.next();
                ca1 ca1Var = (ca1) next;
                int i5 = 4;
                if (objArr2 != true) {
                    haVar = new ha(obj, (int) r5, i5);
                } else if (!ca1Var.b()) {
                    haVar = b(ca1Var.getType().O0(), nwVar, i4, z2);
                } else if (((s60) nwVar.invoke(Integer.valueOf(i4))).a == am0.b) {
                    cc1 cc1VarO0 = ca1Var.getType().O0();
                    haVar = new ha(e4.c(e.c1(cc1VarO0).P0(r5), e.s1(cc1VarO0).P0(true)), 1, 4);
                } else {
                    haVar = new ha((Object) null, 1, i5);
                }
                i4 += haVar.b;
                fc0 type = (cc1) haVar.a;
                if (type != null) {
                    ad1VarC = ca1Var.c();
                    if (v91Var == null) {
                        ad1VarJ = null;
                    } else {
                        ad1VarJ = v91Var.j();
                    }
                    if (ad1VarJ == ad1VarC) {
                        ad1VarC = ad1.INVARIANT;
                    }
                    da1Var = new da1(type, ad1VarC);
                } else if (ai0VarQ == null || ca1Var.b()) {
                    da1Var = ai0VarQ != null ? ma1.m(v91Var) : null;
                } else {
                    type = ca1Var.getType();
                    ad1VarC = ca1Var.c();
                    if (v91Var == null) {
                        ad1VarJ = null;
                    } else {
                        ad1VarJ = v91Var.j();
                    }
                    if (ad1VarJ == ad1VarC) {
                        ad1VarC = ad1.INVARIANT;
                    }
                    da1Var = new da1(type, ad1VarC);
                }
                arrayList.add(da1Var);
                r5 = 0;
                obj = null;
            }
            int i6 = i4 - i;
            if (ai0VarQ == null && bool == null) {
                if (!arrayList.isEmpty()) {
                    Iterator it3 = arrayList.iterator();
                    do {
                        if (it3.hasNext()) {
                        }
                    } while (((ca1) it3.next()) == null);
                }
                return new c.a(null, i6, false);
            }
            s4 annotations = u01Var.getAnnotations();
            t4 t4Var2 = k91.b;
            if (ai0VarQ == null) {
                t4Var2 = null;
            }
            t4 t4Var3 = k91.a;
            if (bool == null) {
                t4Var3 = null;
            }
            char c = 1;
            ArrayList arrayListD0 = ae.D0(new s4[]{annotations, t4Var2, t4Var3});
            int size = arrayListD0.size();
            if (size == 0) {
                d.AnonymousClass0.m("At least one Annotations object expected");
                return null;
            }
            s4 t4Var4 = size != 1 ? new t4(c == true ? 1 : 0, he.g1(arrayListD0)) : (s4) he.a1(arrayListD0);
            List listK1 = u01Var.K0();
            Iterator it4 = arrayList.iterator();
            Iterator it5 = listK1.iterator();
            ArrayList arrayList2 = new ArrayList(Math.min(ae.y0(arrayList), ae.y0(listK1)));
            while (it4.hasNext() && it5.hasNext()) {
                Object next2 = it4.next();
                ca1 ca1Var2 = (ca1) it5.next();
                ca1 ca1Var3 = (ca1) next2;
                if (ca1Var3 != null) {
                    ca1Var2 = ca1Var3;
                }
                arrayList2.add(ca1Var2);
            }
            u01 u01VarF = e4.f(t4Var4, a91VarL0, arrayList2, bool == null ? u01Var.M0() : bool.booleanValue());
            if (s60Var.c) {
                u01VarF = new ol0(u01VarF);
            }
            return new c.a(u01VarF, i6, bool != null && s60Var.d);
        }
        return new c.a(null, 1, false);
    }

    public static mx$a$a a(String str, cv cvVar) {
        mx mxVar;
        Integer numValueOf;
        mx[] mxVarArrValues = mx.values();
        int length = mxVarArrValues.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                mxVar = null;
                break;
            }
            mxVar = mxVarArrValues[i2];
            i2++;
            if (e4.a(mxVar.b, cvVar) && str.startsWith(mxVar.c)) {
                break;
            }
        }
        if (mxVar != null) {
            String strSubstring = str.substring(mxVar.c.length());
            if (strSubstring.length() != 0) {
                int length2 = strSubstring.length();
                int i3 = 0;
                while (true) {
                    if (i >= length2) {
                        numValueOf = Integer.valueOf(i3);
                        break;
                    }
                    char cCharAt = strSubstring.charAt(i);
                    i++;
                    int i4 = cCharAt - '0';
                    if (i4 < 0 || i4 >= 10) {
                        numValueOf = null;
                        break;
                    }
                    i3 = (i3 * 10) + i4;
                }
            } else {
                numValueOf = null;
                break;
            }
            if (numValueOf != null) {
                return new mx$a$a(mxVar, numValueOf.intValue());
            }
        }
        return null;
    }

    public static void a(s4 s4Var, s4 s4Var2) {
        HashSet hashSet = new HashSet();
        Iterator it = s4Var.iterator();
        while (it.hasNext()) {
            hashSet.add(((g4) it.next()).e());
        }
        Iterator it2 = s4Var2.iterator();
        while (it2.hasNext()) {
            hashSet.contains(((g4) it2.next()).e());
        }
    }

    private final void a$uo0$a(String str) {
    }

    private final void a$us$a(String str) {
    }

    private final void accept$wx$b(Object obj) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2, types: [u01] */
    /* JADX WARN: Type inference failed for: r6v3, types: [fc0] */
    /* JADX WARN: Type inference failed for: r6v4, types: [u01] */
    /* JADX WARN: Type inference failed for: r6v5, types: [cc1] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [u01] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [u01] */
    public static ha b(cc1 cc1Var, nw nwVar, int i, boolean z) {
        ?? r6;
        ?? r7;
        int i2 = 4;
        Object objV1 = null;
        if (e.O((fc0) cc1Var)) {
            return new ha(objV1, 1, i2);
        }
        if (!(cc1Var instanceof zt)) {
            if (!(cc1Var instanceof u01)) {
                d.AnonymousClass0.m();
                return null;
            }
            c.a aVarA = a((u01) cc1Var, nwVar, i, 3, false, z);
            boolean z2 = aVarA.a;
            cc1 cc1VarV1 = (u01) aVarA.c;
            if (z2) {
                cc1VarV1 = e.v1(cc1Var, cc1VarV1);
            }
            return new ha(cc1VarV1, aVarA.b, i2);
        }
        boolean z3 = cc1Var instanceof ls0;
        zt ztVar = (zt) cc1Var;
        c.a aVarA2 = a(ztVar.c, nwVar, i, 1, z3, z);
        c.a aVarA3 = a(ztVar.d, nwVar, i, 2, z3, z);
        u01 u01Var = (u01) aVarA3.c;
        ?? C = (u01) aVarA2.c;
        if (C != 0 || u01Var != null) {
            if (aVarA2.a || aVarA3.a) {
                if (u01Var != null) {
                    if (C == 0) {
                        C = u01Var;
                    }
                    C = e4.c((u01) C, u01Var);
                }
                objV1 = e.v1(cc1Var, C);
            } else {
                u01 u01Var2 = ztVar.d;
                u01 u01Var3 = ztVar.c;
                if (z3) {
                    if (C == 0) {
                        r6 = C;
                        r7 = C;
                        r7 = u01Var3;
                    }
                    if (u01Var == null) {
                        u01Var = u01Var2;
                    }
                    objV1 = new ls0(r7, u01Var, 0);
                } else {
                    if (C == 0) {
                        r6 = u01Var3;
                    }
                    if (u01Var == null) {
                        u01Var = u01Var2;
                    }
                    objV1 = e4.c((u01) r6, u01Var);
                }
            }
        }
        return new ha(objV1, aVarA2.b, i2);
    }

    public static /* synthetic */ void b(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "a";
        } else {
            objArr[0] = "b";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
        objArr[2] = "equals";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // defpackage.y91
    public v91 a(gu0 gu0Var) {
        return null;
    }

    @Override // g31.a
    public void a(String str) {
    }

    @Override // gc0.a
    public boolean a(a91 a91Var, a91 a91Var2) {
        if (a91Var == null) {
            b(0);
            throw null;
        }
        if (a91Var2 != null) {
            return a91Var.equals(a91Var2);
        }
        b(1);
        throw null;
    }

    public boolean a(TextView textView) {
        Object objInvoke = Boolean.FALSE;
        try {
            objInvoke = i6.d("getHorizontallyScrolling").invoke(textView, null);
        } catch (Exception unused) {
        }
        return ((Boolean) objInvoke).booleanValue();
    }

    @Override // defpackage.hh
    public void accept(Object obj) {
        if (this.G0 != 25) {
            Throwable nullPointerException = (Throwable) obj;
            String str = "The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + nullPointerException;
            if (nullPointerException == null) {
                nullPointerException = new NullPointerException();
            }
            ui.a(new ym0(str, nullPointerException));
        }
    }

    public u01 b(oo ooVar, s4 s4Var, boolean z, int i, boolean z2) {
        ad1 ad1Var = ad1.INVARIANT;
        co coVar = (co) ooVar.b;
        u01 u01Var = coVar.u;
        u01Var.getClass();
        ca1 ca1VarC = c(new da1(u01Var, ad1Var), ooVar, null, i);
        u01 u01VarG = e.g(ca1VarC.getType());
        if (e.O((fc0) u01VarG)) {
            return u01VarG;
        }
        ca1VarC.c();
        a(u01VarG.getAnnotations(), s4Var);
        if (!e.O((fc0) u01VarG)) {
            boolean zO = e.O((fc0) u01VarG);
            s4 annotations = u01VarG.getAnnotations();
            if (!zO) {
                annotations = e.n(s4Var, annotations);
            }
            u01VarG = e.W(u01VarG, null, annotations, 1);
        }
        if (u01VarG == null) {
            ma1.a(5);
            throw null;
        }
        or orVar = ma1.a;
        if (!z || (u01VarG = u01VarG.P0(true)) != null) {
            return z2 ? e.t1(u01VarG, e4.h((List) ooVar.c, s4Var, vg0.b.b, coVar.j, z)) : u01VarG;
        }
        ma1.a(6);
        throw null;
    }

    public void b(StaticLayout.Builder builder, TextView textView) {
        Object objInvoke = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        try {
            objInvoke = i6.d("getTextDirectionHeuristic").invoke(textView, null);
        } catch (Exception unused) {
        }
        builder.setTextDirection((TextDirectionHeuristic) objInvoke);
    }

    @Override // defpackage.mr
    public void b(k kVar, ArrayList arrayList) {
    }

    public ca1 c(ca1 ca1Var, oo ooVar, v91 v91Var, int i) {
        fc0 fc0VarW;
        co coVar = (co) ooVar.b;
        if (i > 100) {
            throw new AssertionError(e4.j("Too deep recursion while expanding type alias ", coVar.getName()));
        }
        if (!ca1Var.b()) {
            fc0 type = ca1Var.getType();
            od odVarB = type.L0().b();
            ca1 ca1Var2 = odVarB instanceof v91 ? (ca1) ((Map) ooVar.d).get(odVarB) : null;
            ad1 ad1Var = ad1.INVARIANT;
            if (ca1Var2 == null) {
                cc1 cc1VarO0 = ca1Var.getType().O0();
                cc1VarO0.getClass();
                if (!(cc1VarO0 instanceof op)) {
                    u01 u01VarG = e.g(cc1VarO0);
                    if (!e.O((fc0) u01VarG) && ma1.d(u01VarG, ld0.b$26, null, null)) {
                        a91 a91VarL0 = u01VarG.L0();
                        od odVarB2 = a91VarL0.b();
                        a91VarL0.getParameters().size();
                        u01VarG.K0().size();
                        if (!(odVarB2 instanceof v91)) {
                            int i2 = 0;
                            if (odVarB2 instanceof co) {
                                co coVar2 = (co) odVarB2;
                                if (ooVar.a(coVar2)) {
                                    return new da1(pr.d(e4.j("Recursive type alias: ", coVar2.getName())), ad1Var);
                                }
                                List listK0 = u01VarG.K0();
                                ArrayList arrayList = new ArrayList(ae.y0(listK0));
                                for (Object obj : listK0) {
                                    int i3 = i2 + 1;
                                    if (i2 < 0) {
                                        e.q0();
                                        throw null;
                                    }
                                    arrayList.add(c((ca1) obj, ooVar, (v91) a91VarL0.getParameters().get(i2), i + 1));
                                    i2 = i3;
                                }
                                return new da1(e.t1(b(b2.a(ooVar, coVar2, arrayList), u01VarG.getAnnotations(), u01VarG.M0(), i + 1, false), d(u01VarG, ooVar, i)), ca1Var.c());
                            }
                            u01 u01VarD = d(u01VarG, ooVar, i);
                            ha1.d(u01VarD);
                            for (Object obj2 : u01VarD.K0()) {
                                int i4 = i2 + 1;
                                if (i2 < 0) {
                                    e.q0();
                                    throw null;
                                }
                                ca1 ca1Var3 = (ca1) obj2;
                                if (!ca1Var3.b() && !ma1.d(ca1Var3.getType(), ld0.b$21, null, null)) {
                                }
                                i2 = i4;
                            }
                            return new da1(u01VarD, ca1Var.c());
                        }
                    }
                }
                return ca1Var;
            }
            if (!ca1Var2.b()) {
                cc1 cc1VarO1 = ca1Var2.getType().O0();
                ad1 ad1VarC = ca1Var2.c();
                ad1 ad1VarC2 = ca1Var.c();
                if (ad1VarC2 != ad1VarC && ad1VarC2 != ad1Var && ad1VarC == ad1Var) {
                    ad1VarC = ad1VarC2;
                }
                ad1 ad1VarJ = v91Var == null ? ad1Var : v91Var.j();
                if (ad1VarJ == ad1VarC || ad1VarJ == ad1Var || ad1VarC != ad1Var) {
                    ad1Var = ad1VarC;
                }
                a(type.getAnnotations(), cc1VarO1.getAnnotations());
                if (cc1VarO1 instanceof op) {
                    op opVar = (op) cc1VarO1;
                    s4 annotations = type.getAnnotations();
                    boolean zO = e.O((fc0) opVar);
                    s4 s4VarN = opVar.f;
                    if (!zO) {
                        s4VarN = e.n(annotations, s4VarN);
                    }
                    fc0VarW = new op(opVar.d.L0().k(), s4VarN);
                } else {
                    u01 u01VarG2 = e.g(cc1VarO1);
                    boolean zM0 = type.M0();
                    or orVar = ma1.a;
                    if (zM0 && (u01VarG2 = u01VarG2.P0(true)) == null) {
                        ma1.a(6);
                        throw null;
                    }
                    s4 annotations2 = type.getAnnotations();
                    if (e.O((fc0) u01VarG2)) {
                        fc0VarW = u01VarG2;
                    } else {
                        boolean zO2 = e.O((fc0) u01VarG2);
                        s4 annotations3 = u01VarG2.getAnnotations();
                        if (!zO2) {
                            annotations3 = e.n(annotations2, annotations3);
                        }
                        fc0VarW = e.W(u01VarG2, null, annotations3, 1);
                    }
                }
                return new da1(fc0VarW, ad1Var);
            }
        }
        return ma1.m(v91Var);
    }

    @Override // defpackage.mr
    public void c(la laVar) {
        if (laVar != null) {
            return;
        }
        ak.AnonymousClass1.m("Argument for @NotNull parameter 'descriptor' of kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1.reportCannotInferVisibility must not be null");
    }

    public u01 d(u01 u01Var, oo ooVar, int i) {
        a91 a91VarL0 = u01Var.L0();
        List listK0 = u01Var.K0();
        ArrayList arrayList = new ArrayList(ae.y0(listK0));
        int i2 = 0;
        for (Object obj : listK0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                e.q0();
                throw null;
            }
            ca1 ca1Var = (ca1) obj;
            ca1 ca1VarC = c(ca1Var, ooVar, (v91) a91VarL0.getParameters().get(i2), i + 1);
            if (!ca1VarC.b()) {
                ca1VarC = new da1(ma1.k(ca1VarC.getType(), ca1Var.getType().M0()), ca1VarC.c());
            }
            arrayList.add(ca1VarC);
            i2 = i3;
        }
        return e.W(u01Var, arrayList, null, 2);
    }

    @Override // defpackage.bx
    public Object invoke(Object obj, Object obj2) {
        if (this.G0 == 0) {
            String str = (String) obj;
            li.b bVar = (li.b) obj2;
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
        li.b bVar2 = (li.b) obj2;
        li liVarF = ((li) obj).f(bVar2.getKey());
        rq rqVar = rq.b;
        if (liVarF == rqVar) {
            return bVar2;
        }
        e eVar = e.b$2;
        oi oiVar = (oi) liVarF.a(eVar);
        if (oiVar == null) {
            return new le(bVar2, liVarF);
        }
        li liVarF2 = liVarF.f(eVar);
        return liVarF2 == rqVar ? new le(oiVar, bVar2) : new le(oiVar, new le(bVar2, liVarF2));
    }

    public String toString() {
        int i = this.G0;
        if (i != 16) {
            return i != 25 ? super.toString() : "EmptyConsumer";
        }
        return "NO_SOURCE";
    }
}
