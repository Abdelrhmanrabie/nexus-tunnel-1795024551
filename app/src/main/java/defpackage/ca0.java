package defpackage;

import androidx.lifecycle.o;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ca0 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ca0(int i, Object obj) {
        super(0);
        this.G0 = i;
        this.b = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ca0(lw lwVar) {
        super(0);
        this.G0 = 22;
        this.b = (oc0) lwVar;
    }

    /* JADX WARN: Code duplicated, block: B:201:0x048d  */
    /* JADX WARN: Code duplicated, block: B:236:0x0595  */
    /* JADX WARN: Code duplicated, block: B:237:0x0597  */
    /* JADX WARN: Code duplicated, block: B:240:0x05a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:301:0x0746 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:95:0x01fc  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.lang.Object, nw] */
    /* JADX WARN: Type inference failed for: r3v57, types: [lw, oc0] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v11, types: [pn0] */
    /* JADX WARN: Type inference failed for: r8v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v2, types: [int] */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r9v1, types: [uq] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.lw
    public final Object invoke() throws IllegalAccessException {
        int iHashCode;
        dc0 dc0Var;
        ?? arrayList;
        h7 h7Var;
        Iterable iterableSingletonList;
        Map mapSingletonMap;
        Object objI;
        ta ua_g_d;
        ta ua_g_c;
        ta bVar;
        boolean z;
        int i = this.G0;
        vq vqVar = vq.b;
        Object obj = this.b;
        vm vmVar = null;
        int i2 = 2;
        boolean z2 = true;
        boolean z3 = true;
        ?? HashCode = 0;
        int i3 = 0;
        switch (i) {
            case 0:
                return new ba0.a((ba0) obj);
            case 1:
                return new aa0.a((aa0) obj);
            case 2:
                c41 c41Var = (c41) obj;
                return c41Var.i(b2.a(c41Var.b, (lm) null, 3));
            case 3:
                Cdo cdo = (Cdo) obj;
                hn hnVar = cdo.q;
                return he.g1(hnVar.a.e.e(cdo.r, hnVar.b));
            case 4:
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof boolean[]) {
                        iHashCode = Arrays.hashCode((boolean[]) value);
                    } else if (value instanceof char[]) {
                        iHashCode = Arrays.hashCode((char[]) value);
                    } else if (value instanceof byte[]) {
                        iHashCode = Arrays.hashCode((byte[]) value);
                    } else if (value instanceof short[]) {
                        iHashCode = Arrays.hashCode((short[]) value);
                    } else if (value instanceof int[]) {
                        iHashCode = Arrays.hashCode((int[]) value);
                    } else if (value instanceof float[]) {
                        iHashCode = Arrays.hashCode((float[]) value);
                    } else if (value instanceof long[]) {
                        iHashCode = Arrays.hashCode((long[]) value);
                    } else if (value instanceof double[]) {
                        iHashCode = Arrays.hashCode((double[]) value);
                    } else {
                        iHashCode = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
                    }
                    HashCode += iHashCode ^ (str.hashCode() * 127);
                }
                return Integer.valueOf((int) HashCode);
            case 5:
                Object obj2 = q40.a;
                dt0 dt0Var = ((e60) obj).d;
                wt0 wt0Var = dt0Var instanceof wt0 ? (wt0) dt0Var : null;
                kr krVar = (wt0Var == null || (dc0Var = (dc0) q40.b.get(ij0.f(wt0Var.b.name()).b())) == null) ? null : new kr(dd.l(m21.a.u), ij0.f(dc0Var.name()));
                Map mapSingletonMap2 = krVar == null ? null : Collections.singletonMap(n40.c, krVar);
                if (mapSingletonMap2 == null) {
                    return vqVar;
                }
                return mapSingletonMap2;
            case 6:
                return (vg0) ((gy0) obj).b.invoke(lc0$a.a);
            case 7:
                ja0 ja0Var = ha0.g[0];
                return lc1.b((lo0) ((ha0) obj).f.invoke());
            case 8:
                iy iyVar = (iy) obj;
                List listH = iyVar.h();
                ArrayList arrayList2 = new ArrayList(3);
                k kVar = iyVar.b;
                Collection collectionD = kVar.h().d();
                ArrayList arrayList3 = new ArrayList();
                Iterator it = collectionD.iterator();
                while (it.hasNext()) {
                    he.C0(b2.a(((fc0) it.next()).m(), (lm) null, 3), arrayList3);
                }
                ArrayList arrayList4 = new ArrayList();
                for (Object obj3 : arrayList3) {
                    if (obj3 instanceof la) {
                        arrayList4.add(obj3);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj4 : arrayList4) {
                    ij0 name = ((pk) ((la) obj4)).getName();
                    Object arrayList5 = linkedHashMap.get(name);
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                        linkedHashMap.put(name, arrayList5);
                    }
                    ((List) arrayList5).add(obj4);
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    ij0 ij0Var = (ij0) entry2.getKey();
                    List list = (List) entry2.getValue();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Object obj5 : list) {
                        Boolean boolValueOf = Boolean.valueOf(((la) obj5) instanceof ox);
                        Object arrayList6 = linkedHashMap2.get(boolValueOf);
                        if (arrayList6 == null) {
                            arrayList6 = new ArrayList();
                            linkedHashMap2.put(boolValueOf, arrayList6);
                        }
                        ((List) arrayList6).add(obj5);
                    }
                    for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                        boolean zBooleanValue = ((Boolean) entry3.getKey()).booleanValue();
                        List list2 = (List) entry3.getValue();
                        ?? r6 = pn0.d;
                        if (zBooleanValue) {
                            arrayList = new ArrayList();
                            for (Object obj6 : listH) {
                                if (((pk) ((ox) obj6)).getName().equals(ij0Var)) {
                                    arrayList.add(obj6);
                                }
                            }
                        } else {
                            arrayList = uq.b;
                        }
                        r6.h(ij0Var, list2, arrayList, kVar, new jy(arrayList2, iyVar));
                    }
                }
                return he.X0(e.G0(arrayList2), listH);
            case 9:
                dt0 dt0Var2 = ((k60) obj).d;
                if (!(dt0Var2 instanceof gt0)) {
                    if (dt0Var2 instanceof wt0) {
                        Object obj7 = q40.a;
                        iterableSingletonList = Collections.singletonList(dt0Var2);
                    } else {
                        h7Var = null;
                    }
                    if (h7Var == null) {
                        mapSingletonMap = null;
                    } else {
                        mapSingletonMap = Collections.singletonMap(n40.b, h7Var);
                    }
                    if (mapSingletonMap == null) {
                        return vqVar;
                    }
                    return mapSingletonMap;
                }
                Object obj8 = q40.a;
                iterableSingletonList = ((gt0) dt0Var2).getElements();
                ArrayList arrayList7 = new ArrayList();
                for (Object obj9 : iterableSingletonList) {
                    if (obj9 instanceof wt0) {
                        arrayList7.add(obj9);
                    }
                }
                ArrayList arrayList8 = new ArrayList();
                Iterator it2 = arrayList7.iterator();
                while (it2.hasNext()) {
                    Iterable iterable = (EnumSet) q40.a.get(ij0.f(((wt0) it2.next()).b.name()).b());
                    if (iterable == null) {
                        iterable = yq.b;
                    }
                    he.C0(iterable, arrayList8);
                }
                ArrayList arrayList9 = new ArrayList(ae.y0(arrayList8));
                Iterator it3 = arrayList8.iterator();
                while (it3.hasNext()) {
                    arrayList9.add(new kr(dd.l(m21.a.t), ij0.f(((ec0) it3.next()).name())));
                }
                h7Var = new h7(arrayList9, p0.b);
                if (h7Var == null) {
                    mapSingletonMap = null;
                } else {
                    mapSingletonMap = Collections.singletonMap(n40.b, h7Var);
                }
                if (mapSingletonMap == null) {
                    return vqVar;
                }
                return mapSingletonMap;
            case 10:
                p0 p0Var = p0.b$2;
                um umVar = ((nm) obj).c;
                um umVar2 = new um();
                Field[] declaredFields = um.class.getDeclaredFields();
                int length = declaredFields.length;
                int i4 = 0;
                while (i4 < length) {
                    Field field = declaredFields[i4];
                    i4++;
                    if ((field.getModifiers() & 8) != 0) {
                        i3 = i3;
                    } else {
                        field.setAccessible(true);
                        Object obj10 = field.get(umVar);
                        vm vmVar2 = obj10 instanceof vm ? (vm) obj10 : vmVar;
                        if (vmVar2 == null) {
                            i3 = i3;
                        } else {
                            field.getName().startsWith("is");
                            h90 h90VarB = ou0.a.b(um.class);
                            String name2 = field.getName();
                            String name3 = field.getName();
                            if (name3.length() > 0) {
                                name3 = Character.toUpperCase(name3.charAt(i3)) + name3.substring(1);
                            }
                            new tq0(h90VarB, name2, e4.j("get", name3));
                            field.set(umVar2, new vm(vmVar2.a, umVar2));
                        }
                    }
                    i3 = i3;
                    vmVar = null;
                }
                p0Var.invoke(umVar2);
                umVar2.a = true;
                return new nm(umVar2);
            case 11:
                return e.r1((v91) ((da1) obj).a);
            case 12:
                o9 o9Var = (o9) obj;
                return o9Var.a.j(o9Var.b).n();
            case 13:
                return ((ca1) obj).getType();
            case 14:
                HashSet hashSet = new HashSet();
                on onVar = (on) ((oo) obj).d;
                Iterator it4 = onVar.t.d().iterator();
                while (it4.hasNext()) {
                    for (ok okVar : b2.a(((fc0) it4.next()).m(), (lm) null, 3)) {
                        if ((okVar instanceof q01) || (okVar instanceof nq0)) {
                            hashSet.add(okVar.getName());
                        }
                    }
                }
                zq0 zq0Var = onVar.g;
                Iterator it5 = zq0Var.t.iterator();
                while (true) {
                    boolean zHasNext = it5.hasNext();
                    hn hnVar2 = onVar.r;
                    if (!zHasNext) {
                        Iterator it6 = zq0Var.u.iterator();
                        while (it6.hasNext()) {
                            hashSet.add(e.E(hnVar2.b, ((kr0) it6.next()).i));
                        }
                        return nz0.x1(hashSet, hashSet);
                    }
                    hashSet.add(e.E(hnVar2.b, ((fr0) it5.next()).i));
                }
                break;
            case 15:
                return bi0.a(((p90) obj).d());
            case 16:
                return o.c((ce1) obj);
            case 17:
                return new s0.a(((s0) obj).g());
            case 18:
                t80 t80Var = (t80) obj;
                fd0 fd0Var = t80Var.c;
                ja0 ja0Var2 = fd0.s[0];
                Collection collectionValues = ((Map) fd0Var.o.invoke()).values();
                ArrayList arrayList10 = new ArrayList();
                Iterator it7 = collectionValues.iterator();
                while (it7.hasNext()) {
                    zn znVarA = ((c60) t80Var.b.a).d.a(fd0Var, (ju0) it7.next());
                    if (znVarA != null) {
                        arrayList10.add(znVarA);
                    }
                }
                return (vg0[]) e.b1(arrayList10).toArray(new vg0[0]);
            case 19:
                dd ddVar = uw0.a;
                v90 v90Var = (v90) obj;
                Object obj11 = v90Var.j;
                e4 e4VarC = uw0.c(v90Var.l());
                boolean z4 = e4VarC instanceof o80$d;
                p90 p90Var = v90Var.g;
                Class cls = null;
                if (z4) {
                    if (e4.a(v90Var.getName(), "<init>") && v90Var.j().d().isAnnotation()) {
                        Class clsD = p90Var.d();
                        List list3 = (List) v90Var.c.invoke();
                        ArrayList arrayList11 = new ArrayList(ae.y0(list3));
                        Iterator it8 = list3.iterator();
                        while (it8.hasNext()) {
                            arrayList11.add(((ha0) it8.next()).getName());
                        }
                        ArrayList arrayList12 = new ArrayList(ae.y0(arrayList11));
                        Iterator it9 = arrayList11.iterator();
                        while (it9.hasNext()) {
                            arrayList12.add(clsD.getDeclaredMethod((String) it9.next(), null));
                        }
                        return new d4(clsD, arrayList11, 2, arrayList12);
                    }
                    String str2 = ((o80$d) e4VarC).a.b;
                    p90Var.getClass();
                    Class clsD2 = p90Var.d();
                    try {
                        Object[] array = p90Var.q(str2).toArray(new Class[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        }
                        Class[] clsArr = (Class[]) array;
                        objI = clsD2.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                    } catch (NoSuchMethodException unused) {
                        objI = null;
                    }
                } else if (e4VarC instanceof o80$e) {
                    p80$b p80_b = ((o80$e) e4VarC).a;
                    objI = p90Var.i(p80_b.a, p80_b.b);
                } else if (e4VarC instanceof o80$c) {
                    objI = ((o80$c) e4VarC).a;
                } else {
                    if (!(e4VarC instanceof o80$b)) {
                        if (!(e4VarC instanceof o80$a)) {
                            d.AnonymousClass0.m();
                            return null;
                        }
                        List list4 = ((o80$a) e4VarC).a;
                        Class clsD3 = p90Var.d();
                        ArrayList arrayList13 = new ArrayList(ae.y0(list4));
                        Iterator it10 = list4.iterator();
                        while (it10.hasNext()) {
                            arrayList13.add(((Method) it10.next()).getName());
                        }
                        return new d4(clsD3, arrayList13, 1, list4);
                    }
                    objI = ((o80$b) e4VarC).a;
                }
                if (objI instanceof Constructor) {
                    Constructor constructor = (Constructor) objI;
                    ox oxVarP = v90Var.l();
                    uc ucVar = oxVarP instanceof uc ? (uc) oxVarP : null;
                    if (ucVar == null || cn.e(ucVar.getVisibility()) || j20.b(ucVar.e0()) || xm.q(ucVar.e0())) {
                        z = false;
                    } else {
                        List listF = ucVar.f();
                        if (listF.isEmpty()) {
                            z = false;
                        } else {
                            Iterator it11 = listF.iterator();
                            while (true) {
                                if (!it11.hasNext()) {
                                    z = false;
                                } else if (e.i0(((wc1) it11.next()).getType())) {
                                    z = true;
                                }
                            }
                        }
                    }
                    boolean zN = v90Var.n();
                    if (z) {
                        if (zN) {
                            bVar = new ua.a(constructor, e.j(obj11, v90Var.l()), 0);
                        } else {
                            Class declaringClass = constructor.getDeclaringClass();
                            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                            bVar = new ua.b(constructor, declaringClass, cls, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : ae.A0(0, genericParameterTypes.length - 1, genericParameterTypes)), 0);
                        }
                    } else if (zN) {
                        bVar = new ua.a(constructor, e.j(obj11, v90Var.l()), 1);
                    } else {
                        Class declaringClass2 = constructor.getDeclaringClass();
                        Class declaringClass3 = constructor.getDeclaringClass();
                        Class<?> declaringClass4 = declaringClass3.getDeclaringClass();
                        bVar = new ua.b(constructor, declaringClass2, (declaringClass4 == null || Modifier.isStatic(declaringClass3.getModifiers())) ? null : declaringClass4, constructor.getGenericParameterTypes(), 1);
                    }
                } else {
                    if (!(objI instanceof Method)) {
                        throw new yi("Could not compute caller for function: " + v90Var.l() + " (member = " + objI + ')');
                    }
                    Method method = (Method) objI;
                    int i5 = 6;
                    if (Modifier.isStatic(method.getModifiers())) {
                        if (((j0) v90Var.l()).getAnnotations().c(lc1.a) != null) {
                            int i6 = 4;
                            ua_g_d = v90Var.n() ? new ua$g$b(method, HashCode, i6) : new ua$g$d(method, z2, i6, z3 ? 1 : 0);
                        } else if (v90Var.n()) {
                            ua_g_c = new ua$g$c(method, e.j(obj11, v90Var.l()));
                            bVar = ua_g_c;
                        } else {
                            ua_g_d = new ua$g$d(method, HashCode, i5, i2);
                        }
                        bVar = ua_g_d;
                    } else if (v90Var.n()) {
                        ua_g_c = new ua$g$a(method, e.j(obj11, v90Var.l()));
                        bVar = ua_g_c;
                    } else {
                        ua_g_d = new ua$g$d(method, HashCode, i5, HashCode);
                        bVar = ua_g_d;
                    }
                }
                return e.n(bVar, v90Var.l());
            case 20:
                return (List) ((wc1.a) obj).r.getValue();
            case 21:
                lw lwVar = ((vk0) obj).b;
                if (lwVar != null) {
                    return (List) lwVar.invoke();
                }
                return null;
            case 22:
                return he.i1((Iterable) ((oc0) obj).invoke());
            case 23:
                vn vnVar = (vn) obj;
                Set setN = vnVar.n();
                if (setN != null) {
                    return nz0.x1(nz0.x1(vnVar.m(), vnVar.c.c.keySet()), setN);
                }
                return null;
            case 24:
                vg0 vg0Var = (vg0) ((lw) obj).invoke();
                return vg0Var instanceof l91 ? ((l91) vg0Var).h() : vg0Var;
            case 25:
                w70 w70Var = (w70) obj;
                hi0 hi0Var = w70Var.f;
                if (hi0Var == null) {
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
                w70.a aVar = (w70.a) hi0Var.invoke();
                w70Var.f = null;
                return aVar;
            case 26:
                on onVar2 = ((y21) obj).b;
                return Arrays.asList(b2.d(onVar2), b2.e(onVar2));
            case 27:
                return new y90.a((y90) obj);
            default:
                List upperBounds = ((ya0) obj).b.getUpperBounds();
                ArrayList arrayList14 = new ArrayList(ae.y0(upperBounds));
                Iterator it12 = upperBounds.iterator();
                while (it12.hasNext()) {
                    arrayList14.add(new wa0((fc0) it12.next(), null));
                }
                return arrayList14;
        }
    }
}
