package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SequencedCollection;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class qn extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qn(int i, Object obj, Object obj2) {
        super(0);
        this.G0 = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qn(nr0 nr0Var, e91 e91Var) {
        super(0);
        this.G0 = 6;
        this.b = e91Var;
        this.c = nr0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object, rc0] */
    /* JADX WARN: Type inference failed for: r1v14, types: [lw, oc0] */
    /* JADX WARN: Type inference failed for: r1v97, types: [java.lang.Object, rc0] */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object, rc0] */
    @Override // defpackage.lw
    public final Object invoke() throws IllegalAccessException, InvocationTargetException {
        s4$a$a s4_a_a;
        List list;
        v40 v40Var;
        ArrayList arrayList;
        ArrayList<au0> arrayList2;
        jo0 jo0Var;
        List listP;
        ha1 ha1VarD;
        ab0 ab0Var;
        int i = 0;
        int i2 = 1;
        switch (this.G0) {
            case 0:
                on onVar = (on) this.b;
                return he.g1(onVar.r.a.e.h(onVar.C, (dr0) this.c));
            case 1:
                a80 a80Var = (a80) this.b;
                ji0 ji0Var = a80Var.g().a;
                u70.d.getClass();
                return e4.c(ji0Var, u70.h, new oo((ff0) this.c, a80Var.g().a)).n();
            case 2:
                jc0 jc0Var = (jc0) ((de0) this.c).d.invoke();
                ((lc0$a) this.b).getClass();
                return (fc0) jc0Var;
            case 3:
                dd0 dd0Var = (dd0) this.b;
                qt0 qt0Var = dd0Var.o;
                List listE = fz0.E(new c81(new ht(ae.B0(qt0Var.a.getDeclaredConstructors()), false, it0.d), jt0.d));
                SequencedCollection arrayList3 = new ArrayList(listE.size());
                Iterator it = listE.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    v8 v8Var = dd0Var.b;
                    ai0 ai0Var = dd0Var.n;
                    if (!zHasNext) {
                        boolean zO = qt0Var.o();
                        Class cls = qt0Var.a;
                        s4$a$a s4_a_a2 = e4.f47a;
                        v8 v8Var2 = (v8) this.c;
                        if (zO) {
                            ((c60) v8Var.a).j.getClass();
                            v40 v40VarX0 = v40.X0(ai0Var, s4_a_a2, true, new tw0$a(qt0Var));
                            ArrayList<eu0> arrayListK = qt0Var.k();
                            ArrayList arrayList4 = new ArrayList(arrayListK.size());
                            n60 n60VarB = w60.b(2, false, null, 2);
                            int i3 = 0;
                            for (eu0 eu0Var : arrayListK) {
                                fc0 fc0VarE = ((oo) v8Var.e).e(eu0Var.getType(), n60VarB);
                                c60 c60Var = (c60) v8Var.a;
                                ij0 name = eu0Var.getName();
                                c60Var.j.getClass();
                                s4$a$a s4_a_a3 = s4_a_a2;
                                arrayList4.add(new wc1(v40VarX0, null, i3, s4_a_a3, name, fc0VarE, false, false, false, null, new tw0$a(eu0Var)));
                                i3++;
                                s4_a_a2 = s4_a_a3;
                                i = 0;
                            }
                            boolean z = i;
                            s4_a_a = s4_a_a2;
                            v40VarX0.R0(z);
                            cn.d visibility = ai0Var.getVisibility();
                            if (e4.a(visibility, h50.b)) {
                                visibility = h50.c;
                            }
                            v40VarX0.V0(arrayList4, visibility);
                            v40VarX0.Q0(z);
                            v40VarX0.j = ai0Var.n();
                            int i4 = 2;
                            String strO = e.o(v40VarX0, 2);
                            if (arrayList3.isEmpty()) {
                                arrayList3.add(v40VarX0);
                                ((c60) v8Var2.a).g.getClass();
                            } else {
                                Iterator it2 = arrayList3.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        arrayList3.add(v40VarX0);
                                        ((c60) v8Var2.a).g.getClass();
                                    } else if (!e.o((uc) it2.next(), i4).equals(strO)) {
                                        i4 = 2;
                                    }
                                }
                            }
                        } else {
                            s4_a_a = s4_a_a2;
                        }
                        ((c60) v8Var2.a).x.getClass();
                        m6 m6Var = ((c60) v8Var2.a).r;
                        if (arrayList3.isEmpty()) {
                            boolean zIsAnnotation = cls.isAnnotation();
                            cls.isInterface();
                            if (zIsAnnotation) {
                                ((c60) v8Var.a).j.getClass();
                                v40 v40VarX1 = v40.X0(ai0Var, s4_a_a, true, new tw0$a(qt0Var));
                                if (zIsAnnotation) {
                                    List listA = qt0Var.A();
                                    ArrayList arrayList5 = new ArrayList(listA.size());
                                    n60 n60VarB2 = w60.b(2, true, null, 2);
                                    ArrayList arrayList6 = new ArrayList();
                                    ArrayList arrayList7 = new ArrayList();
                                    for (Object obj : listA) {
                                        if (e4.a(((au0) obj).getName(), r70.b)) {
                                            arrayList6.add(obj);
                                        } else {
                                            arrayList7.add(obj);
                                        }
                                    }
                                    arrayList6.size();
                                    au0 au0Var = (au0) he.M0(arrayList6);
                                    oo ooVar = (oo) v8Var.e;
                                    if (au0Var != null) {
                                        fu0 fu0VarC = au0Var.C();
                                        if (fu0VarC instanceof ht0) {
                                            ht0 ht0Var = (ht0) fu0VarC;
                                            jo0Var = new jo0(ooVar.c(ht0Var, n60VarB2, true), ooVar.e(ht0Var.b, n60VarB2));
                                        } else {
                                            jo0Var = new jo0(ooVar.e(fu0VarC, n60VarB2), null);
                                        }
                                        arrayList = arrayList5;
                                        arrayList2 = arrayList7;
                                        dd0Var.x(arrayList, v40VarX1, 0, au0Var, (fc0) jo0Var.b, (fc0) jo0Var.c);
                                    } else {
                                        arrayList = arrayList5;
                                        arrayList2 = arrayList7;
                                    }
                                    int i5 = au0Var != null ? 1 : 0;
                                    int i6 = 0;
                                    for (au0 au0Var2 : arrayList2) {
                                        dd0Var.x(arrayList, v40VarX1, i6 + i5, au0Var2, ooVar.e(au0Var2.C(), n60VarB2), null);
                                        i6++;
                                    }
                                    list = arrayList;
                                } else {
                                    list = Collections.EMPTY_LIST;
                                }
                                v40VarX1.R0(false);
                                cn.d visibility2 = ai0Var.getVisibility();
                                if (e4.a(visibility2, h50.b)) {
                                    visibility2 = h50.c;
                                }
                                v40VarX1.V0(list, visibility2);
                                v40VarX1.Q0(true);
                                v40VarX1.j = ai0Var.n();
                                ((c60) v8Var.a).g.getClass();
                                v40Var = v40VarX1;
                            } else {
                                v40Var = null;
                            }
                            arrayList3 = e.Z(v40Var);
                        }
                        return he.g1(m6Var.a(v8Var2, arrayList3));
                    }
                    ut0 ut0Var = (ut0) it.next();
                    wc0 wc0VarZ = e.Z(v8Var, ut0Var);
                    c60 c60Var2 = (c60) v8Var.a;
                    c60Var2.j.getClass();
                    v40 v40VarX2 = v40.X0(ai0Var, wc0VarZ, false, new tw0$a(ut0Var));
                    v8 v8Var3 = new v8(c60Var2, new ud0(v8Var, v40VarX2, ut0Var, ai0Var.o().size()), v8Var.c);
                    Constructor constructor = ut0Var.a;
                    Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                    if (genericParameterTypes.length == 0) {
                        listP = uq.b;
                    } else {
                        Class declaringClass = constructor.getDeclaringClass();
                        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
                            genericParameterTypes = (Type[]) ae.A0(i2, genericParameterTypes.length, genericParameterTypes);
                        }
                        Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                        if (parameterAnnotations.length < genericParameterTypes.length) {
                            throw new IllegalStateException(e4.j("Illegal generic signature: ", constructor));
                        }
                        if (parameterAnnotations.length > genericParameterTypes.length) {
                            parameterAnnotations = (Annotation[][]) ae.A0(parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length, parameterAnnotations);
                        }
                        listP = ut0Var.P(genericParameterTypes, parameterAnnotations, constructor.isVarArgs());
                    }
                    c5 c5VarU = jd0.u(v8Var3, v40VarX2, listP);
                    List listO = ai0Var.o();
                    ArrayList typeParameters = ut0Var.getTypeParameters();
                    ArrayList arrayList8 = new ArrayList(ae.y0(typeParameters));
                    Iterator it3 = typeParameters.iterator();
                    while (it3.hasNext()) {
                        arrayList8.add(((y91) v8Var3.b).a((gu0) it3.next()));
                    }
                    v40VarX2.W0((List) c5VarU.a, e.f0(b2.a((bu0) ut0Var)), he.X0(arrayList8, listO));
                    v40VarX2.Q0(false);
                    v40VarX2.R0(c5VarU.f);
                    v40VarX2.j = ai0Var.n();
                    ((c60) v8Var3.a).g.getClass();
                    arrayList3.add(v40VarX2);
                    i2 = 1;
                }
                break;
            case 4:
                StringBuilder sb = new StringBuilder();
                sb.append('@');
                sb.append(((Class) this.b).getCanonicalName());
                he.P0(((Map) this.c).entrySet(), sb, "(", ")", ba.b$15, 48);
                return sb.toString();
            case 5:
                xc0 xc0Var = (xc0) this.b;
                v8 v8Var4 = xc0Var.q;
                c60 c60Var3 = (c60) v8Var4.a;
                return new xc0(new v8(new c60(c60Var3.a, c60Var3.b, c60Var3.c, c60Var3.d, c60Var3.e, c60Var3.f, c60Var3.h, c60Var3.i, c60Var3.j, c60Var3.k, c60Var3.l, c60Var3.m, c60Var3.n, c60Var3.o, c60Var3.p, c60Var3.q, c60Var3.r, c60Var3.s, c60Var3.t, c60Var3.u, c60Var3.v, c60Var3.w), (y91) v8Var4.b, v8Var4.c), xc0Var.b(), xc0Var.o, (ai0) this.c);
            case 6:
                hn hnVar = (hn) ((e91) this.b).a;
                return hnVar.a.e.c((nr0) this.c, hnVar.b);
            case 7:
                return new fd0(((gd0) this.b).a, (cu0) this.c);
            case 8:
                ku0 ku0Var = ((c60) ((v8) this.b).a).b;
                cv cvVar = ((hd0) this.c).o.g;
                ku0Var.getClass();
                return null;
            case 9:
                return ((c60) ((v8) this.b).a).o.k().j(((m40) this.c).a).n();
            case 10:
                p81 p81Var = (p81) this.b;
                ff0 ff0Var = p81Var.J;
                co coVar = p81Var.K;
                uc ucVar = (uc) this.c;
                s4 annotations = ucVar.getAnnotations();
                la.a kind = ucVar.getKind();
                co coVar2 = p81Var.K;
                p81 p81Var2 = new p81(ff0Var, coVar, ucVar, p81Var, annotations, kind, coVar2.g());
                p81.M.getClass();
                if (coVar2.q() == null) {
                    ha1VarD = null;
                } else {
                    u01 u01Var = coVar2.v;
                    u01Var.getClass();
                    ha1VarD = ha1.d(u01Var);
                }
                if (ha1VarD == null) {
                    return null;
                }
                sc0 sc0Var = ucVar.o;
                sc0 sc0VarC = sc0Var != null ? sc0Var.c(ha1VarD) : null;
                List list2 = coVar2.i;
                list2.getClass();
                p81Var2.N0(null, sc0VarC, list2, p81Var.f(), p81Var.j, zh0.b, coVar2.g);
                return p81Var2;
            case 11:
                return uh.b((v8) this.b, ((gd) this.c).getAnnotations());
            case 12:
                return uh.b((v8) this.b, (s4) this.c);
            case 13:
                u70 u70Var = (u70) this.b;
                p0 p0Var = p0.b$9;
                ji0 ji0Var2 = u70Var.a;
                ok okVar = (ok) p0Var.invoke(ji0Var2);
                ij0 ij0Var = u70.g;
                zh0 zh0Var = zh0.f;
                List listSingletonList = Collections.singletonList(ji0Var2.f.f());
                ff0 ff0Var2 = (ff0) this.c;
                bd bdVar = new bd(okVar, ij0Var, zh0Var, 2, listSingletonList, ff0Var2);
                bdVar.K0(new sd(ff0Var2, bdVar), yq.b, null);
                return bdVar;
            case 14:
                v90 v90Var = (v90) this.b;
                p90 p90Var = v90Var.g;
                p90Var.getClass();
                String str = (String) this.c;
                String str2 = v90Var.i;
                Collection collectionG1 = e4.a(str, "<init>") ? he.g1(p90Var.k()) : p90Var.l(ij0.f(str));
                ArrayList arrayList9 = new ArrayList();
                for (Object obj2 : collectionG1) {
                    if (e4.a(uw0.c((ox) obj2).a(), str2)) {
                        arrayList9.add(obj2);
                    }
                }
                if (arrayList9.size() == 1) {
                    return (ox) he.a1(arrayList9);
                }
                String strR0 = he.R0(collectionG1, "\n", null, null, p0.b$3, 30);
                StringBuilder sb2 = new StringBuilder("Function '");
                sb2.append(str);
                sb2.append("' (JVM signature: ");
                sb2.append(str2);
                sb2.append(") not resolved in ");
                sb2.append(p90Var);
                sb2.append(':');
                sb2.append(strR0.length() == 0 ? " no members found" : e4.j("\n", strR0));
                throw new yi(sb2.toString());
            case 15:
                Iterable iterable = (List) ((vk0) this.b).e.getValue();
                if (iterable == null) {
                    iterable = uq.b;
                }
                ArrayList arrayList10 = new ArrayList(ae.y0(iterable));
                Iterator it4 = iterable.iterator();
                while (it4.hasNext()) {
                    arrayList10.add(((cc1) it4.next()).Q0((lc0$a) this.c));
                }
                return arrayList10;
            case 16:
                wa0 wa0Var = (wa0) this.b;
                List listK0 = wa0Var.b.K0();
                if (listK0.isEmpty()) {
                    return uq.b;
                }
                rc0 rc0VarV = e.V(be0.b, new va0(wa0Var, i));
                ArrayList arrayList11 = new ArrayList(ae.y0(listK0));
                for (Object obj3 : listK0) {
                    int i7 = i + 1;
                    if (i < 0) {
                        e.q0();
                        throw null;
                    }
                    ca1 ca1Var = (ca1) obj3;
                    if (ca1Var.b()) {
                        ab0Var = ab0.c;
                    } else {
                        wa0 wa0Var2 = new wa0(ca1Var.getType(), ((lw) this.c) == null ? null : new ua0(wa0Var, i, rc0VarV));
                        int iOrdinal = ca1Var.c().ordinal();
                        if (iOrdinal == 0) {
                            ab0Var = new ab0(bb0.b, wa0Var2);
                        } else if (iOrdinal == 1) {
                            ab0Var = new ab0(bb0.c, wa0Var2);
                        } else {
                            if (iOrdinal != 2) {
                                d.AnonymousClass0.m();
                                return null;
                            }
                            ab0Var = new ab0(bb0.d, wa0Var2);
                        }
                    }
                    arrayList11.add(ab0Var);
                    i = i7;
                }
                return arrayList11;
            default:
                w70 w70Var = (w70) this.b;
                ji0 ji0Var3 = w70Var.a;
                ji0Var3.getClass();
                return new a80(ji0Var3, (ff0) this.c, new ca0(25, w70Var));
        }
    }
}
