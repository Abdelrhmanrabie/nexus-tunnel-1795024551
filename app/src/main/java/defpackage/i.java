package defpackage;

import g.a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class i extends oc0 implements nw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(int i, Object obj) {
        super(1);
        this.G0 = i;
        this.b = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i(nw nwVar) {
        super(1);
        this.G0 = 6;
        this.b = (oc0) nwVar;
    }

    /* JADX WARN: Code duplicated, block: B:207:0x040c  */
    /* JADX WARN: Code duplicated, block: B:210:0x041a  */
    /* JADX WARN: Code duplicated, block: B:213:0x041e  */
    /* JADX WARN: Code duplicated, block: B:251:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:267:0x0523  */
    /* JADX WARN: Code duplicated, block: B:285:0x0579  */
    /* JADX WARN: Code duplicated, block: B:288:0x057d  */
    /* JADX WARN: Code duplicated, block: B:366:0x06dd  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v130, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v53, types: [nw, oc0] */
    /* JADX WARN: Type inference failed for: r4v37, types: [nw, oc0] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.Object, rc0] */
    /* JADX WARN: Type inference failed for: r6v14, types: [int] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v58 */
    @Override // defpackage.nw
    public final Object invoke(Object obj) throws IOException, InvocationTargetException {
        ?? r6;
        vc vcVarA;
        Object next;
        wn0 wn0Var;
        hn hnVar;
        ij0 ij0VarJ;
        zn znVar;
        ai0 ai0VarA;
        boolean zEquals;
        InputStream inputStream;
        boolean z;
        boolean zIsEmpty;
        cc1 cc1VarW;
        ca1 ca1VarG;
        Object next2;
        int i = this.G0;
        tb1 tb1Var = tb1.a;
        Object obj2 = this.b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        j30 j30Var = null;
        switch (i) {
            case 0:
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                g gVar = new g((v8) obj2, map, z3 ? 1 : 0, z3);
                Class cls = ((ju0) obj).a;
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i2 = 0;
                while (i2 < length) {
                    Method method = declaredMethods[i2];
                    i2++;
                    ij0 ij0VarF = ij0.f(method.getName());
                    StringBuilder sb = new StringBuilder("(");
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    int length2 = parameterTypes.length;
                    int i3 = z3 ? 1 : 0;
                    while (i3 < length2) {
                        Class<?> cls2 = parameterTypes[i3];
                        i3++;
                        sb.append(bt0.b(cls2));
                    }
                    sb.append(")");
                    sb.append(bt0.b(method.getReturnType()));
                    g.a aVar = gVar.new a(new xg0(e4.j(ij0VarF.b(), sb.toString())));
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    int length3 = declaredAnnotations.length;
                    int i4 = z3 ? 1 : 0;
                    while (i4 < length3) {
                        Annotation annotation = declaredAnnotations[i4];
                        i4++;
                        e.G(aVar, annotation);
                    }
                    Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                    int length4 = parameterAnnotations.length;
                    int i5 = z3 ? 1 : 0;
                    boolean z5 = z3;
                    while (i5 < length4) {
                        Annotation[] annotationArr = parameterAnnotations[i5];
                        int i6 = i5 + 1;
                        int length5 = annotationArr.length;
                        while (r6 < length5) {
                            Annotation annotation2 = annotationArr[r6];
                            int i7 = r6 + 1;
                            Class cls3 = cls;
                            Class clsD = ((sc) e.v(annotation2)).d();
                            Method[] methodArr = declaredMethods;
                            hg hgVarC = aVar.c(i5, bt0.a(clsD), new at0(annotation2));
                            if (hgVarC == null) {
                                r6 = z5;
                            } else {
                                r6 = z5;
                                e.H(hgVarC, annotation2, clsD);
                            }
                            cls = cls3;
                            declaredMethods = methodArr;
                            r6 = i7;
                        }
                        r6 = z5;
                        i5 = i6;
                        z5 = false;
                    }
                    aVar.mo4a();
                    z3 = false;
                }
                Class cls4 = cls;
                Constructor<?>[] declaredConstructors = cls4.getDeclaredConstructors();
                int length6 = declaredConstructors.length;
                int i8 = 0;
                while (i8 < length6) {
                    Constructor<?> constructor = declaredConstructors[i8];
                    int i9 = i8 + 1;
                    ij0 ij0Var = f21.e;
                    StringBuilder sb2 = new StringBuilder("(");
                    Class<?>[] parameterTypes2 = constructor.getParameterTypes();
                    int length7 = parameterTypes2.length;
                    int i10 = 0;
                    while (i10 < length7) {
                        Class<?> cls5 = parameterTypes2[i10];
                        i10++;
                        sb2.append(bt0.b(cls5));
                    }
                    sb2.append(")V");
                    g.a aVar2 = gVar.new a(new xg0(e4.j(ij0Var.b(), sb2.toString())));
                    Annotation[] declaredAnnotations2 = constructor.getDeclaredAnnotations();
                    int length8 = declaredAnnotations2.length;
                    int i11 = 0;
                    while (i11 < length8) {
                        Annotation annotation3 = declaredAnnotations2[i11];
                        i11++;
                        e.G(aVar2, annotation3);
                    }
                    Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
                    if (parameterAnnotations2.length != 0) {
                        int length9 = constructor.getParameterTypes().length - parameterAnnotations2.length;
                        int length10 = parameterAnnotations2.length;
                        int i12 = 0;
                        while (i12 < length10) {
                            Annotation[] annotationArr2 = parameterAnnotations2[i12];
                            int i13 = i12 + 1;
                            int length11 = annotationArr2.length;
                            int i14 = 0;
                            while (i14 < length11) {
                                Constructor<?>[] constructorArr = declaredConstructors;
                                Annotation annotation4 = annotationArr2[i14];
                                i14++;
                                int i15 = length6;
                                Class clsD2 = ((sc) e.v(annotation4)).d();
                                int i16 = i9;
                                int i17 = length9;
                                Annotation[][] annotationArr3 = parameterAnnotations2;
                                hg hgVarC2 = aVar2.c(i12 + length9, bt0.a(clsD2), new at0(annotation4));
                                if (hgVarC2 != null) {
                                    e.H(hgVarC2, annotation4, clsD2);
                                }
                                declaredConstructors = constructorArr;
                                i9 = i16;
                                length6 = i15;
                                length9 = i17;
                                parameterAnnotations2 = annotationArr3;
                            }
                            i12 = i13;
                        }
                    }
                    Constructor<?>[] constructorArr2 = declaredConstructors;
                    int i18 = length6;
                    int i19 = i9;
                    aVar2.mo4a();
                    declaredConstructors = constructorArr2;
                    i8 = i19;
                    length6 = i18;
                }
                Field[] declaredFields = cls4.getDeclaredFields();
                int length12 = declaredFields.length;
                int i20 = 0;
                while (i20 < length12) {
                    Field field = declaredFields[i20];
                    i20++;
                    ij0 ij0VarF2 = ij0.f(field.getName());
                    String strB = bt0.b(field.getType());
                    m6 m6Var = new m6(gVar, new xg0(ij0VarF2.b() + '#' + strB));
                    Annotation[] declaredAnnotations3 = field.getDeclaredAnnotations();
                    int length13 = declaredAnnotations3.length;
                    int i21 = 0;
                    while (i21 < length13) {
                        Annotation annotation5 = declaredAnnotations3[i21];
                        i21++;
                        e.G(m6Var, annotation5);
                    }
                    m6Var.mo4a();
                }
                return new f$a(map, map2);
            case 1:
                cd.a aVar3 = (cd.a) obj;
                cd cdVar = (cd) obj2;
                fn fnVar = cdVar.a;
                Iterator it = fnVar.k.iterator();
                do {
                    boolean zHasNext = it.hasNext();
                    dd ddVar = aVar3.a;
                    if (!zHasNext) {
                        if (!cd.c.contains(ddVar) && ((vcVarA = aVar3.b) != null || (vcVarA = fnVar.d.a(ddVar)) != null)) {
                            jj0 jj0Var = vcVarA.a;
                            zq0 zq0Var = vcVarA.b;
                            y8 y8Var = vcVarA.c;
                            t11 t11Var = vcVarA.d;
                            dd ddVarG = ddVar.g();
                            if (ddVarG != null) {
                                ai0 ai0Var = (ai0) cdVar.b.invoke(new cd.a(ddVarG, null));
                                on onVar = ai0Var instanceof on ? (on) ai0Var : null;
                                if (onVar != null && onVar.K0().m().contains(ddVar.j())) {
                                    hnVar = onVar.r;
                                    return new on(hnVar, zq0Var, jj0Var, y8Var, t11Var);
                                }
                            } else {
                                cv cvVarH = ddVar.h();
                                ao0 ao0Var = fnVar.f;
                                ArrayList arrayList = new ArrayList();
                                e.k(ao0Var, cvVarH, arrayList);
                                Iterator it2 = arrayList.iterator();
                                do {
                                    if (it2.hasNext()) {
                                        next = it2.next();
                                        wn0 wn0Var2 = (wn0) next;
                                        if (wn0Var2 instanceof v9) {
                                            ij0VarJ = ddVar.j();
                                            znVar = ((v9) wn0Var2).r;
                                            znVar.getClass();
                                        }
                                    } else {
                                        next = null;
                                    }
                                    wn0Var = (wn0) next;
                                    if (wn0Var != null) {
                                        fi0 fi0Var = new fi0(zq0Var.C);
                                        gd1 gd1Var = gd1.b;
                                        hnVar = new hn(fnVar, jj0Var, wn0Var, fi0Var, ak.a(zq0Var.E), y8Var, null, null, uq.b);
                                        return new on(hnVar, zq0Var, jj0Var, y8Var, t11Var);
                                    }
                                } while (!znVar.m().contains(ij0VarJ));
                                wn0Var = (wn0) next;
                                if (wn0Var != null) {
                                    fi0 fi0Var2 = new fi0(zq0Var.C);
                                    gd1 gd1Var2 = gd1.b;
                                    hnVar = new hn(fnVar, jj0Var, wn0Var, fi0Var2, ak.a(zq0Var.E), y8Var, null, null, uq.b);
                                    return new on(hnVar, zq0Var, jj0Var, y8Var, t11Var);
                                }
                            }
                        }
                        return null;
                    }
                    ai0VarA = ((ad) it.next()).a(ddVar);
                } while (ai0VarA == null);
                return ai0VarA;
            case 2:
                int iIntValue = ((Number) obj).intValue();
                if (iIntValue >= 0) {
                    s60[] s60VarArr = (s60[]) obj2;
                    if (iIntValue <= s60VarArr.length - 1) {
                        return s60VarArr[iIntValue];
                    }
                }
                return s60.e;
            case 3:
                return ((wc1) ((la) obj).f().get(((wc1) obj2).i)).getType();
            case 4:
                ji0 ji0Var = (ji0) obj2;
                e eVar = ji0Var.i;
                ff0 ff0Var = ji0Var.d;
                eVar.getClass();
                return new vd0(ji0Var, (cv) obj, ff0Var);
            case 5:
                lc0$a lc0_a = (lc0$a) obj;
                j30 j30Var2 = (j30) obj2;
                LinkedHashSet linkedHashSet = j30Var2.b;
                ArrayList arrayList2 = new ArrayList(ae.y0(linkedHashSet));
                Iterator it3 = linkedHashSet.iterator();
                while (it3.hasNext()) {
                    arrayList2.add(((fc0) it3.next()).Q0(lc0_a));
                    z4 = true;
                }
                if (z4) {
                    fc0 fc0Var = j30Var2.a;
                    j30Var = new j30(new j30(arrayList2).b, fc0Var != null ? fc0Var.Q0(lc0_a) : null);
                }
                if (j30Var != null) {
                    j30Var2 = j30Var;
                }
                return j30Var2.e();
            case 6:
                return ((oc0) obj2).invoke((fc0) obj).toString();
            case 7:
                lc0$a lc0_a2 = (lc0$a) obj;
                if (ym.f((ai0) obj2) != null) {
                    lc0_a2.getClass();
                    return null;
                }
                return null;
            case 8:
                Method method2 = (Method) obj;
                if (method2.isSynthetic()) {
                    z2 = false;
                } else if (((qt0) obj2).a.isEnum()) {
                    String name = method2.getName();
                    if (e4.a(name, "values")) {
                        if (method2.getParameterTypes().length == 0) {
                            zEquals = true;
                        } else {
                            zEquals = false;
                        }
                    } else if (e4.a(name, "valueOf")) {
                        zEquals = Arrays.equals(method2.getParameterTypes(), new Class[]{String.class});
                    } else {
                        zEquals = false;
                    }
                    if (zEquals) {
                        z2 = false;
                    }
                }
                return Boolean.valueOf(z2);
            case 9:
                return ((gi0) obj).k().h(((ub0) obj2).v());
            case 10:
                cc1 cc1Var = (cc1) obj;
                if (!e.O((fc0) cc1Var)) {
                    od odVarB = cc1Var.L0().b();
                    z2 = (odVarB instanceof v91) && !e4.a(((v91) odVarB).b(), (co) obj2);
                }
                return Boolean.valueOf(z2);
            case 11:
                cv cvVar = (cv) obj;
                k80 k80Var = (k80) obj2;
                if (cvVar.h(m21.h)) {
                    q9.m.getClass();
                    String strA = q9.a(cvVar);
                    ClassLoader classLoader = x9.class.getClassLoader();
                    if (classLoader == null) {
                        inputStream = ClassLoader.getSystemResourceAsStream(strA);
                    } else {
                        URL resource = classLoader.getResource(strA);
                        if (resource == null) {
                            inputStream = null;
                        } else {
                            URLConnection uRLConnectionOpenConnection = resource.openConnection();
                            uRLConnectionOpenConnection.setUseCaches(false);
                            inputStream = uRLConnectionOpenConnection.getInputStream();
                        }
                    }
                } else {
                    inputStream = null;
                }
                v9 v9VarA = inputStream == null ? null : ui.a(cvVar, k80Var.c, inputStream);
                if (v9VarA != null) {
                    fn fnVar2 = k80Var.d;
                    fnVar2.getClass();
                    v9VarA.K0(fnVar2);
                    return v9VarA;
                }
                return null;
            case 12:
                s0.a aVar4 = (s0.a) obj;
                s0 s0Var = (s0) obj2;
                ke keVarJ = s0Var.j();
                Collection collection = aVar4.a;
                keVarJ.getClass();
                if (collection.isEmpty()) {
                    fc0 fc0VarH = s0Var.h();
                    List listSingletonList = fc0VarH == null ? null : Collections.singletonList(fc0VarH);
                    if (listSingletonList == null) {
                        listSingletonList = uq.b;
                    }
                    collection = listSingletonList;
                }
                List listG1 = collection instanceof List ? (List) collection : null;
                if (listG1 == null) {
                    listG1 = he.g1(collection);
                }
                aVar4.b = s0Var.m(listG1);
                return tb1Var;
            case 13:
                return ((gi0) obj).k().r((wp0) obj2);
            case 14:
                gu0 gu0Var = (gu0) obj;
                ud0 ud0Var = (ud0) obj2;
                Integer num = (Integer) ud0Var.d.get(gu0Var);
                if (num != null) {
                    int iIntValue2 = num.intValue();
                    v8 v8Var = ud0Var.a;
                    v8 v8Var2 = new v8((c60) v8Var.a, ud0Var, v8Var.c);
                    qk qkVar = ud0Var.b;
                    return new td0(uh.c(v8Var2, qkVar.getAnnotations()), gu0Var, ud0Var.c + iIntValue2, qkVar);
                }
                return null;
            case 15:
                ((o11) obj2).add(obj);
                return tb1Var;
            case 16:
                ij0 ij0Var2 = n40.a;
                wc0 wc0Var = (wc0) obj2;
                return n40.b(wc0Var.b, (ct0) obj, wc0Var.d);
            case 17:
                au0 au0Var = (au0) obj;
                if (((Boolean) ((xc) obj2).b.invoke(au0Var)).booleanValue()) {
                    au0Var.getClass();
                    if (au0Var.a.getDeclaringClass().isInterface()) {
                        String strB2 = au0Var.getName().b();
                        int iHashCode = strB2.hashCode();
                        if (iHashCode != -1776922004) {
                            if (iHashCode != -1295482945) {
                                if (iHashCode == 147696667 && strB2.equals("hashCode")) {
                                    zIsEmpty = ((ArrayList) au0Var.f()).isEmpty();
                                }
                            } else if (strB2.equals("equals")) {
                                ArrayList arrayList3 = (ArrayList) au0Var.f();
                                hu0 hu0Var = (hu0) (arrayList3.size() == 1 ? arrayList3.get(0) : null);
                                fu0 fu0Var = hu0Var == null ? null : hu0Var.a;
                                tt0 tt0Var = fu0Var instanceof tt0 ? (tt0) fu0Var : null;
                                if (tt0Var != null) {
                                    b50 b50VarB = tt0Var.b();
                                    if ((b50VarB instanceof qt0) && ((qt0) b50VarB).e().b().equals("java.lang.Object")) {
                                        zIsEmpty = true;
                                    }
                                }
                            }
                            zIsEmpty = false;
                        } else if (strB2.equals("toString")) {
                            zIsEmpty = ((ArrayList) au0Var.f()).isEmpty();
                        } else {
                            zIsEmpty = false;
                        }
                        if (zIsEmpty) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    z2 = z ? false : true;
                }
                return Boolean.valueOf(z2);
            case 18:
                xc0 xc0Var = (xc0) obj2;
                return new dd0(xc0Var.q, xc0Var, xc0Var.o, xc0Var.p != null, xc0Var.x);
            case 19:
                return Boolean.valueOf(c21.j.containsKey(e.p((q01) obj2)));
            case 20:
                z91$a z91_a = (z91$a) obj;
                v91 v91Var = z91_a.a;
                m6 m6Var2 = (m6) obj2;
                n60 n60Var = z91_a.c;
                Set set = n60Var.d;
                if (set == null || !set.contains(v91Var.a())) {
                    u01 u01VarN = v91Var.n();
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    e.q(u01VarN, u01VarN, linkedHashSet2, set);
                    int iE = ye1.e(ae.y0(linkedHashSet2));
                    if (iE < 16) {
                        iE = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(iE);
                    Iterator it4 = linkedHashSet2.iterator();
                    while (true) {
                        boolean zHasNext2 = it4.hasNext();
                        Set set2 = n60Var.d;
                        if (!zHasNext2) {
                            ha1 ha1Var = new ha1(new c91(z3 ? 1 : 0, linkedHashMap));
                            fc0 fc0Var2 = (fc0) he.K0(v91Var.getUpperBounds());
                            if (!(fc0Var2.L0().b() instanceof ai0)) {
                                Set setSingleton = set2 == null ? Collections.singleton(m6Var2) : set2;
                                od odVarB2 = fc0Var2.L0().b();
                                if (odVarB2 != null) {
                                    while (true) {
                                        v91 v91Var2 = (v91) odVarB2;
                                        if (!setSingleton.contains(v91Var2)) {
                                            fc0Var2 = (fc0) he.K0(v91Var2.getUpperBounds());
                                            if (!(fc0Var2.L0().b() instanceof ai0)) {
                                                odVarB2 = fc0Var2.L0().b();
                                                if (odVarB2 != null) {
                                                }
                                            }
                                        }
                                    }
                                }
                                d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                                return null;
                            }
                            ad1 ad1Var = ad1.OUT_VARIANCE;
                            jc0 jc0VarO0 = fc0Var2.O0();
                            if (jc0VarO0 instanceof zt) {
                                zt ztVar = (zt) jc0VarO0;
                                u01 u01VarW = ztVar.c;
                                if (!u01VarW.L0().getParameters().isEmpty() && u01VarW.L0().b() != null) {
                                    List<v91> parameters = u01VarW.L0().getParameters();
                                    ArrayList arrayList4 = new ArrayList(ae.y0(parameters));
                                    for (v91 v91Var3 : parameters) {
                                        ca1 da1Var = (ca1) he.N0(fc0Var2.K0(), v91Var3.getIndex());
                                        if ((set2 != null && set2.contains(v91Var3)) || da1Var == null || !linkedHashMap.containsKey(da1Var.getType().L0())) {
                                            da1Var = new da1(v91Var3);
                                        }
                                        arrayList4.add(da1Var);
                                    }
                                    u01VarW = e.W(u01VarW, arrayList4, null, 2);
                                }
                                u01 u01VarW2 = ztVar.d;
                                if (!u01VarW2.L0().getParameters().isEmpty() && u01VarW2.L0().b() != null) {
                                    List<v91> parameters2 = u01VarW2.L0().getParameters();
                                    ArrayList arrayList5 = new ArrayList(ae.y0(parameters2));
                                    for (v91 v91Var4 : parameters2) {
                                        ca1 da1Var2 = (ca1) he.N0(fc0Var2.K0(), v91Var4.getIndex());
                                        if ((set2 != null && set2.contains(v91Var4)) || da1Var2 == null || !linkedHashMap.containsKey(da1Var2.getType().L0())) {
                                            da1Var2 = new da1(v91Var4);
                                        }
                                        arrayList5.add(da1Var2);
                                    }
                                    u01VarW2 = e.W(u01VarW2, arrayList5, null, 2);
                                }
                                cc1VarW = e4.c(u01VarW, u01VarW2);
                            } else {
                                if (!(jc0VarO0 instanceof u01)) {
                                    d.AnonymousClass0.m();
                                    return null;
                                }
                                u01 u01Var = (u01) jc0VarO0;
                                if (u01Var.L0().getParameters().isEmpty() || u01Var.L0().b() == null) {
                                    cc1VarW = u01Var;
                                } else {
                                    List<v91> parameters3 = u01Var.L0().getParameters();
                                    ArrayList arrayList6 = new ArrayList(ae.y0(parameters3));
                                    for (v91 v91Var5 : parameters3) {
                                        ca1 da1Var3 = (ca1) he.N0(fc0Var2.K0(), v91Var5.getIndex());
                                        if ((set2 != null && set2.contains(v91Var5)) || da1Var3 == null || !linkedHashMap.containsKey(da1Var3.getType().L0())) {
                                            da1Var3 = new da1(v91Var5);
                                        }
                                        arrayList6.add(da1Var3);
                                    }
                                    cc1VarW = e.W(u01Var, arrayList6, null, 2);
                                }
                            }
                            return ha1Var.i(e.v1(cc1VarW, jc0VarO0 instanceof ra1 ? ((ra1) jc0VarO0).i0() : null), ad1Var);
                        }
                        v91 v91Var6 = (v91) it4.next();
                        if (set == null || !set.contains(v91Var6)) {
                            boolean z6 = z91_a.b;
                            n60 n60VarB = z6 ? n60Var : n60Var.b(1);
                            fc0 fc0VarA = m6Var2.a(v91Var6, z6, n60.a(n60Var, 0, set2 != null ? nz0.y1(set2, v91Var) : Collections.singleton(v91Var), null, 23));
                            ((js0) m6Var2.b).getClass();
                            ca1VarG = js0.g(v91Var6, n60VarB, fc0VarA);
                        } else {
                            ca1VarG = w60.a(v91Var6, n60Var);
                        }
                        linkedHashMap.put(v91Var6.h(), ca1VarG);
                    }
                }
                u01 u01Var2 = n60Var.e;
                return u01Var2 == null ? (u01) ((v41) m6Var2.a).getValue() : e.Y((fc0) u01Var2);
            default:
                cv cvVar2 = (cv) obj;
                ?? r1 = ((zl0) obj2).b;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : r1.entrySet()) {
                    cv cvVar3 = (cv) entry.getKey();
                    if (!e4.a(cvVar2, cvVar3)) {
                        if (e4.a(cvVar2.d() ? null : cvVar2.e(), cvVar3)) {
                        }
                    }
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
                if (linkedHashMap2.isEmpty()) {
                    linkedHashMap2 = null;
                }
                if (linkedHashMap2 != null) {
                    Iterator it5 = linkedHashMap2.entrySet().iterator();
                    if (it5.hasNext()) {
                        next2 = it5.next();
                        if (it5.hasNext()) {
                            int length14 = e.P((cv) ((Map.Entry) next2).getKey(), cvVar2).b().length();
                            do {
                                Object next3 = it5.next();
                                int length15 = e.P((cv) ((Map.Entry) next3).getKey(), cvVar2).b().length();
                                if (length14 > length15) {
                                    next2 = next3;
                                    length14 = length15;
                                }
                            } while (it5.hasNext());
                        }
                    } else {
                        next2 = null;
                    }
                    Map.Entry entry2 = (Map.Entry) next2;
                    if (entry2 != null) {
                        return entry2.getValue();
                    }
                }
                return null;
        }
    }
}
