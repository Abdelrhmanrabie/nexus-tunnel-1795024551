package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedCollection;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class jd0 extends wg0 {
    public static final /* synthetic */ ja0[] m;
    public final v8 b;
    public final jd0 c;
    public final gf0 d;
    public final ff0.h e;
    public final ff0.c f;
    public final ff0.j g;
    public final ff0.c h;
    public final ff0.h i;
    public final ff0.h j;
    public final ff0.h k;
    public final ff0.c l;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final fc0 a;
        public final List c;
        public final ArrayList d;
        public final List f;

        public a(List list, ArrayList arrayList, List list2, fc0 fc0Var) {
            this.a = fc0Var;
            this.c = list;
            this.d = arrayList;
            this.f = list2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return e4.a(this.a, aVar.a) && e4.a(this.c, aVar.c) && this.d.equals(aVar.d) && this.f.equals(aVar.f);
        }

        public final int hashCode() {
            return this.f.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + (this.a.hashCode() * 961)) * 31)) * 961);
        }

        public final String toString() {
            return "MethodSignatureData(returnType=" + this.a + ", receiverType=null, valueParameters=" + this.c + ", typeParameters=" + this.d + ", hasStableParameterNames=false, errors=" + this.f + ')';
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class e extends oc0 implements nw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ jd0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ e(jd0 jd0Var, int i) {
            super(1);
            this.G0 = i;
            this.b = jd0Var;
        }

        /* JADX WARN: Code duplicated, block: B:60:0x019c  */
        /* JADX WARN: Code duplicated, block: B:71:0x01bf  */
        /* JADX WARN: Code duplicated, block: B:97:0x0248  */
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
        @Override // defpackage.nw
        public final Object invoke(Object obj) {
            fu0 ht0Var;
            fu0 du0Var;
            int i = this.G0;
            jd0 jd0Var = this.b;
            if (i != 0) {
                if (i == 1) {
                    ij0 ij0Var = (ij0) obj;
                    jd0 jd0Var2 = jd0Var.c;
                    if (jd0Var2 != null) {
                        return (Collection) jd0Var2.f.invoke(ij0Var);
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((vk) jd0Var.e.invoke()).f(ij0Var).iterator();
                    while (it.hasNext()) {
                        q50 q50VarT = jd0Var.t((au0) it.next());
                        if (jd0Var.r(q50VarT)) {
                            ((c60) jd0Var.b.a).g.getClass();
                            arrayList.add(q50VarT);
                        }
                    }
                    jd0Var.j(ij0Var, arrayList);
                    return arrayList;
                }
                if (i != 2) {
                    ij0 ij0Var2 = (ij0) obj;
                    ArrayList arrayList2 = new ArrayList();
                    defpackage.e.s0(arrayList2, jd0Var.g.invoke(ij0Var2));
                    jd0Var.n(ij0Var2, arrayList2);
                    if (xm.n(jd0Var.q(), 5)) {
                        return he.g1(arrayList2);
                    }
                    v8 v8Var = jd0Var.b;
                    return he.g1(((c60) v8Var.a).r.a(v8Var, arrayList2));
                }
                ij0 ij0Var3 = (ij0) obj;
                SequencedCollection linkedHashSet = new LinkedHashSet((Collection) jd0Var.f.invoke(ij0Var3));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj2 : linkedHashSet) {
                    String strO = defpackage.e.o((q01) obj2, 2);
                    Object arrayList3 = linkedHashMap.get(strO);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        linkedHashMap.put(strO, arrayList3);
                    }
                    ((List) arrayList3).add(obj2);
                }
                for (List list : linkedHashMap.values()) {
                    if (list.size() != 1) {
                        Collection collectionA = uh.a(list, ld0.b);
                        linkedHashSet.removeAll(list);
                        linkedHashSet.addAll(collectionA);
                    }
                }
                jd0Var.m(linkedHashSet, ij0Var3);
                v8 v8Var2 = jd0Var.b;
                return he.g1(((c60) v8Var2.a).r.a(v8Var2, linkedHashSet));
            }
            ij0 ij0Var4 = (ij0) obj;
            jd0 jd0Var3 = jd0Var.c;
            if (jd0Var3 != null) {
                return (nq0) jd0Var3.g.invoke(ij0Var4);
            }
            xt0 xt0VarB = ((vk) jd0Var.e.invoke()).b(ij0Var4);
            if (xt0VarB != null) {
                Field field = xt0VarB.a;
                if (!field.isEnumConstant()) {
                    boolean z = !Modifier.isFinal(xt0VarB.getModifiers());
                    v8 v8Var3 = jd0Var.b;
                    wc0 wc0VarZ = defpackage.e.Z(v8Var3, xt0VarB);
                    ok okVarQ = jd0Var.q();
                    cn.d dVarF0 = defpackage.e.f0(b2.a((bu0) xt0VarB));
                    ij0 name = xt0VarB.getName();
                    c60 c60Var = (c60) v8Var3.a;
                    c60Var.j.getClass();
                    y50 y50VarO0 = y50.O0(okVarQ, wc0VarZ, dVarF0, z, name, new tw0$a(xt0VarB), Modifier.isFinal(xt0VarB.getModifiers()) && Modifier.isStatic(xt0VarB.getModifiers()));
                    y50VarO0.L0(null, null, null, null);
                    Type genericType = field.getGenericType();
                    boolean z2 = genericType instanceof Class;
                    if (z2) {
                        Class cls = (Class) genericType;
                        if (cls.isPrimitive()) {
                            du0Var = new du0(cls);
                        } else {
                            if (!(genericType instanceof GenericArrayType) || (z2 && ((Class) genericType).isArray())) {
                                ht0Var = new ht0(genericType);
                            } else {
                                ht0Var = genericType instanceof WildcardType ? new iu0((WildcardType) genericType) : new tt0(genericType);
                            }
                            du0Var = ht0Var;
                        }
                    } else {
                        if (genericType instanceof GenericArrayType) {
                            ht0Var = new ht0(genericType);
                        } else {
                            ht0Var = new ht0(genericType);
                        }
                        du0Var = ht0Var;
                    }
                    fc0 fc0VarE = ((oo) v8Var3.e).e(du0Var, w60.b(2, false, null, 3));
                    if ((ub0.G(fc0VarE) || ub0.E(fc0VarE, m21.a.f)) && Modifier.isFinal(xt0VarB.getModifiers())) {
                        Modifier.isStatic(xt0VarB.getModifiers());
                    }
                    y50VarO0.N0(fc0VarE, uq.b, jd0Var.p(), null);
                    fc0 type = y50VarO0.getType();
                    int i2 = xm.$r8$clinit;
                    if (!y50VarO0.i && !defpackage.e.O(type)) {
                        if (ma1.b(type)) {
                            kd0 kd0Var = new kd0(jd0Var, xt0VarB, y50VarO0);
                            ff0 ff0Var = c60Var.a;
                            ff0Var.getClass();
                            y50VarO0.j = new ff0.f(ff0Var, kd0Var);
                        } else {
                            ub0 ub0VarE = ym.e(y50VarO0);
                            if (ub0.G(type)) {
                                kd0 kd0Var2 = new kd0(jd0Var, xt0VarB, y50VarO0);
                                ff0 ff0Var2 = c60Var.a;
                                ff0Var2.getClass();
                                y50VarO0.j = new ff0.f(ff0Var2, kd0Var2);
                            } else {
                                yk0 yk0Var = gc0.a;
                                if (yk0Var.c(ub0VarE.v(), type) || yk0Var.c(ub0VarE.k("Number").n(), type) || yk0Var.c(ub0VarE.f(), type) || ac1.a(type)) {
                                    kd0 kd0Var3 = new kd0(jd0Var, xt0VarB, y50VarO0);
                                    ff0 ff0Var3 = c60Var.a;
                                    ff0Var3.getClass();
                                    y50VarO0.j = new ff0.f(ff0Var3, kd0Var3);
                                }
                            }
                        }
                    }
                    c60Var.g.getClass();
                    return y50VarO0;
                }
            }
            return null;
        }
    }

    static {
        pu0 pu0Var = ou0.a;
        m = new ja0[]{pu0Var.f(new tq0(pu0Var.b(jd0.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), pu0Var.f(new tq0(pu0Var.b(jd0.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), pu0Var.f(new tq0(pu0Var.b(jd0.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    public jd0(v8 v8Var, dd0 dd0Var) {
        this.b = v8Var;
        this.c = dd0Var;
        ff0 ff0Var = ((c60) v8Var.a).a;
        int i = 1;
        kd0 kd0Var = new kd0(this, i);
        ff0Var.getClass();
        this.d = new gf0(ff0Var, kd0Var);
        int i2 = 3;
        this.e = new ff0.h(ff0Var, new kd0(this, i2));
        this.f = ff0Var.g(new e(this, i));
        this.g = ff0Var.d(new e(this, 0));
        int i3 = 2;
        this.h = ff0Var.g(new e(this, i3));
        this.i = new ff0.h(ff0Var, new kd0(this, 4));
        this.j = new ff0.h(ff0Var, new kd0(this, 5));
        this.k = new ff0.h(ff0Var, new kd0(this, i3));
        this.l = ff0Var.g(new e(this, i2));
    }

    public static c5 u(v8 v8Var, rx rxVar, List list) {
        jo0 jo0Var;
        ij0 ij0VarD;
        String strJ;
        l7 l7VarJ1 = he.j1(list);
        ArrayList arrayList = new ArrayList(ae.y0(l7VarJ1));
        Iterator it = l7VarJ1.iterator();
        boolean z = false;
        while (true) {
            c20 c20Var = (c20) it;
            if (!c20Var.b.hasNext()) {
                return new c5(5, he.g1(arrayList), z);
            }
            a20 a20Var = (a20) c20Var.next();
            int i = a20Var.a;
            hu0 hu0Var = (hu0) a20Var.b;
            wc0 wc0VarZ = defpackage.e.Z(v8Var, hu0Var);
            n60 n60VarB = w60.b(2, false, null, 3);
            boolean z2 = hu0Var.d;
            oo ooVar = (oo) v8Var.e;
            c60 c60Var = (c60) v8Var.a;
            gi0 gi0Var = c60Var.o;
            fu0 fu0Var = hu0Var.a;
            if (z2) {
                ht0 ht0Var = fu0Var instanceof ht0 ? (ht0) fu0Var : null;
                if (ht0Var == null) {
                    throw new AssertionError(e4.j("Vararg parameter should be an array: ", hu0Var));
                }
                cc1 cc1VarC = ooVar.c(ht0Var, n60VarB, true);
                jo0Var = new jo0(cc1VarC, gi0Var.k().g(cc1VarC));
            } else {
                jo0Var = new jo0(ooVar.e(fu0Var, n60VarB), null);
            }
            fc0 fc0Var = (fc0) jo0Var.b;
            fc0 fc0Var2 = (fc0) jo0Var.c;
            if (rxVar.getName().b().equals("equals") && list.size() == 1 && gi0Var.k().p().equals(fc0Var)) {
                strJ = "other";
            } else {
                String str = hu0Var.c;
                ij0VarD = str != null ? ij0.d(str) : null;
                if (ij0VarD == null) {
                    z = true;
                }
                if (ij0VarD == null) {
                    strJ = e4.j("p", Integer.valueOf(i));
                }
                c60Var.j.getClass();
                arrayList.add(new wc1(rxVar, null, i, wc0VarZ, ij0VarD, fc0Var, false, false, false, fc0Var2, new tw0$a(hu0Var)));
            }
            ij0VarD = ij0.f(strJ);
            c60Var.j.getClass();
            arrayList.add(new wc1(rxVar, null, i, wc0VarZ, ij0VarD, fc0Var, false, false, false, fc0Var2, new tw0$a(hu0Var)));
        }
    }

    @Override // defpackage.wg0, defpackage.vg0
    public Collection a(ij0 ij0Var, dl0 dl0Var) {
        return !b().contains(ij0Var) ? uq.b : (Collection) this.h.invoke(ij0Var);
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Set b() {
        ja0 ja0Var = m[0];
        return (Set) this.i.invoke();
    }

    @Override // defpackage.wg0, defpackage.vg0
    public Collection c(ij0 ij0Var, dl0 dl0Var) {
        return !d().contains(ij0Var) ? uq.b : (Collection) this.l.invoke(ij0Var);
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Set d() {
        ja0 ja0Var = m[1];
        return (Set) this.j.invoke();
    }

    @Override // defpackage.wg0, defpackage.vg0
    public Collection f(lm lmVar, nw nwVar) {
        return (Collection) this.d.invoke();
    }

    @Override // defpackage.wg0, defpackage.vg0
    public final Set g() {
        ja0 ja0Var = m[2];
        return (Set) this.k.invoke();
    }

    public abstract Set h(lm lmVar, p0 p0Var);

    public abstract Set i(lm lmVar, p0 p0Var);

    public void j(ij0 ij0Var, ArrayList arrayList) {
    }

    public abstract vk k();

    public abstract void m(LinkedHashSet linkedHashSet, ij0 ij0Var);

    public abstract void n(ij0 ij0Var, ArrayList arrayList);

    public abstract Set o();

    public abstract sc0 p();

    public abstract ok q();

    public boolean r(q50 q50Var) {
        return true;
    }

    public abstract a s(ArrayList arrayList, fc0 fc0Var, List list);

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, rc0] */
    public final q50 t(au0 au0Var) {
        zh0 zh0Var;
        v8 v8Var = this.b;
        wc0 wc0VarZ = defpackage.e.Z(v8Var, au0Var);
        ok okVarQ = q();
        ij0 name = au0Var.getName();
        ((c60) v8Var.a).j.getClass();
        q50 q50VarY0 = q50.Y0(okVarQ, wc0VarZ, name, new tw0$a(au0Var), ((vk) this.e.invoke()).e(au0Var.getName()) != null && ((ArrayList) au0Var.f()).isEmpty());
        v8 v8Var2 = new v8((c60) v8Var.a, new ud0(v8Var, q50VarY0, au0Var, 0), v8Var.c);
        ArrayList typeParameters = au0Var.getTypeParameters();
        ArrayList arrayList = new ArrayList(ae.y0(typeParameters));
        Iterator it = typeParameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((y91) v8Var2.b).a((gu0) it.next()));
        }
        c5 c5VarU = u(v8Var2, q50VarY0, au0Var.f());
        a aVarS = s(arrayList, ((oo) v8Var2.e).e(au0Var.C(), w60.b(2, au0Var.a.getDeclaringClass().isAnnotation(), null, 2)), (List) c5VarU.a);
        sc0 sc0VarP = p();
        ArrayList arrayList2 = aVarS.d;
        List list = aVarS.c;
        fc0 fc0Var = aVarS.a;
        boolean zIsAbstract = Modifier.isAbstract(au0Var.getModifiers());
        boolean zIsFinal = Modifier.isFinal(au0Var.getModifiers());
        if (zIsAbstract) {
            zh0Var = zh0.f;
        } else {
            zh0Var = !zIsFinal ? zh0.d : zh0.b;
        }
        q50VarY0.X0(null, sc0VarP, arrayList2, list, fc0Var, zh0Var, defpackage.e.f0(b2.a((bu0) au0Var)), vq.b);
        q50VarY0.J = c5VarU.f ? 3 : 1;
        if (aVarS.f.isEmpty()) {
            return q50VarY0;
        }
        ((k01.a) ((c60) v8Var2.a).e).getClass();
        d.AnonymousClass0.m$3("Should not be called");
        return null;
    }

    public String toString() {
        return e4.j("Lazy scope for ", q());
    }
}
