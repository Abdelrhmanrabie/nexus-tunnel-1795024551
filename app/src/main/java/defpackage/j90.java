package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class j90 extends p90 implements h90, za0 {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Class c;
    public final nu0$b d = new nu0$b(new c(this, 0));

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends p90.a {
        public static final /* synthetic */ ja0[] k;
        public final nu0$a c;
        public final nu0$a d;
        public final nu0$a e;
        public final nu0$a f;
        public final nu0$a g;
        public final nu0$a h;
        public final nu0$a i;
        public final nu0$a j;

        /* JADX INFO: renamed from: j90$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class C0034a extends oc0 implements lw {
            public final /* synthetic */ int G0;
            public final /* synthetic */ a b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C0034a(a aVar, int i) {
                super(0);
                this.G0 = i;
                this.b = aVar;
            }

            @Override // defpackage.lw
            public final Object invoke() {
                int i = this.G0;
                if (i == 0) {
                    ja0[] ja0VarArr = a.k;
                    ja0 ja0Var = ja0VarArr[14];
                    a aVar = this.b;
                    Collection collection = (Collection) aVar.i.invoke();
                    ja0 ja0Var2 = ja0VarArr[15];
                    return he.X0((Collection) aVar.j.invoke(), collection);
                }
                if (i == 1) {
                    ja0[] ja0VarArr2 = a.k;
                    ja0 ja0Var3 = ja0VarArr2[10];
                    a aVar2 = this.b;
                    Collection collection2 = (Collection) aVar2.e.invoke();
                    ja0 ja0Var4 = ja0VarArr2[12];
                    return he.X0((Collection) aVar2.g.invoke(), collection2);
                }
                if (i == 2) {
                    ja0[] ja0VarArr3 = a.k;
                    ja0 ja0Var5 = ja0VarArr3[11];
                    a aVar3 = this.b;
                    Collection collection3 = (Collection) aVar3.f.invoke();
                    ja0 ja0Var6 = ja0VarArr3[13];
                    return he.X0((Collection) aVar3.h.invoke(), collection3);
                }
                if (i == 3) {
                    return lc1.b(this.b.a());
                }
                if (i == 4) {
                    ja0[] ja0VarArr4 = a.k;
                    ja0 ja0Var7 = ja0VarArr4[10];
                    a aVar4 = this.b;
                    Collection collection4 = (Collection) aVar4.e.invoke();
                    ja0 ja0Var8 = ja0VarArr4[11];
                    return he.X0((Collection) aVar4.f.invoke(), collection4);
                }
                a aVar5 = this.b;
                if (i != 5) {
                    Collection<ai0> collectionA = aVar5.a().A();
                    ArrayList arrayList = new ArrayList();
                    for (ai0 ai0Var : collectionA) {
                        if (ai0Var == null) {
                            defpackage.d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                            return null;
                        }
                        Class clsH = lc1.h(ai0Var);
                        j90 j90Var = clsH == null ? null : new j90(clsH);
                        if (j90Var != null) {
                            arrayList.add(j90Var);
                        }
                    }
                    return arrayList;
                }
                Collection collectionA2 = b2.a(aVar5.a().V(), (lm) null, 3);
                ArrayList<ok> arrayList2 = new ArrayList();
                for (Object obj : collectionA2) {
                    ok okVar = (ok) obj;
                    if (okVar == null) {
                        xm.a(36);
                        throw null;
                    }
                    if (!xm.n(okVar, 4)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (ok okVar2 : arrayList2) {
                    ai0 ai0Var2 = okVar2 instanceof ai0 ? (ai0) okVar2 : null;
                    Class clsH2 = ai0Var2 == null ? null : lc1.h(ai0Var2);
                    j90 j90Var2 = clsH2 == null ? null : new j90(clsH2);
                    if (j90Var2 != null) {
                        arrayList3.add(j90Var2);
                    }
                }
                return arrayList3;
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class q extends oc0 implements lw {
            public final /* synthetic */ int G0;
            public final /* synthetic */ a b;
            public final /* synthetic */ j90 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ q(a aVar, j90 j90Var, int i) {
                super(0);
                this.G0 = i;
                this.b = aVar;
                this.c = j90Var;
            }

            @Override // defpackage.lw
            public final Object invoke() {
                int i = this.G0;
                j90 j90Var = this.c;
                a aVar = this.b;
                if (i != 0) {
                    List listO = aVar.a().o();
                    ArrayList arrayList = new ArrayList(ae.y0(listO));
                    Iterator it = listO.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new ya0(j90Var, (v91) it.next()));
                    }
                    return arrayList;
                }
                Collection<fc0> collectionD = aVar.a().h().d();
                ArrayList arrayList2 = new ArrayList(collectionD.size());
                for (fc0 fc0Var : collectionD) {
                    arrayList2.add(new wa0(fc0Var, new k90(fc0Var, aVar, j90Var, 0)));
                }
                ai0 ai0VarA = aVar.a();
                if (ai0VarA == null) {
                    ub0.a(107);
                    throw null;
                }
                ij0 ij0Var = ub0.e;
                if (!ub0.c(ai0VarA, m21.a.a) && !ub0.c(ai0VarA, m21.a.b)) {
                    if (arrayList2.isEmpty()) {
                        arrayList2.add(new wa0(ym.e(aVar.a()).f(), r2.b$2));
                    } else {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            int iV = xm.c(((wa0) it2.next()).b).v();
                            if (iV == 0) {
                                throw new NullPointerException(ak.j("getClassDescriptorForType(it.type).kind", " must not be null"));
                            }
                            if (iV == 2 || iV == 5) {
                            }
                        }
                        arrayList2.add(new wa0(ym.e(aVar.a()).f(), r2.b$2));
                    }
                }
                return e.G0(arrayList2);
            }
        }

        static {
            pu0 pu0Var = ou0.a;
            k = new ja0[]{pu0Var.f(new tq0(pu0Var.b(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), pu0Var.f(new tq0(pu0Var.b(a.class), "annotations", "getAnnotations()Ljava/util/List;")), pu0Var.f(new tq0(pu0Var.b(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), pu0Var.f(new tq0(pu0Var.b(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), pu0Var.f(new tq0(pu0Var.b(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), pu0Var.f(new tq0(pu0Var.b(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), pu0Var.f(new tq0(pu0Var.b(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), pu0Var.f(new tq0(pu0Var.b(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), pu0Var.f(new tq0(pu0Var.b(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), pu0Var.f(new tq0(pu0Var.b(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), pu0Var.f(new tq0(pu0Var.b(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), pu0Var.f(new tq0(pu0Var.b(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), pu0Var.f(new tq0(pu0Var.b(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), pu0Var.f(new tq0(pu0Var.b(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), pu0Var.f(new tq0(pu0Var.b(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), pu0Var.f(new tq0(pu0Var.b(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), pu0Var.f(new tq0(pu0Var.b(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), pu0Var.f(new tq0(pu0Var.b(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        }

        public a(j90 j90Var) {
            super(j90Var);
            int i = 4;
            this.c = ak.c(new c(j90Var, i));
            int i2 = 3;
            ak.c(new C0034a(this, i2));
            ak.c(new c(this, j90Var));
            this.d = ak.c(new c(j90Var, 7));
            int i3 = 1;
            ak.c(new c(j90Var, i3));
            int i4 = 5;
            ak.c(new C0034a(this, i4));
            ak.c(new q(this, j90Var, i3));
            int i5 = 0;
            ak.c(new q(this, j90Var, i5));
            int i6 = 6;
            ak.c(new C0034a(this, i6));
            int i7 = 2;
            this.e = ak.c(new c(j90Var, i7));
            this.f = ak.c(new c(j90Var, i2));
            this.g = ak.c(new c(j90Var, i4));
            this.h = ak.c(new c(j90Var, i6));
            this.i = ak.c(new C0034a(this, i3));
            this.j = ak.c(new C0034a(this, i7));
            ak.c(new C0034a(this, i));
            ak.c(new C0034a(this, i5));
        }

        public final ai0 a() {
            ja0 ja0Var = k[0];
            return (ai0) this.c.invoke();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[wb0.a.values().length];
            iArr[2] = 1;
            iArr[4] = 2;
            iArr[5] = 3;
            iArr[3] = 4;
            iArr[0] = 5;
            iArr[1] = 6;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c extends oc0 implements lw {
        public final /* synthetic */ int G0;
        public final /* synthetic */ j90 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, j90 j90Var) {
            super(0);
            this.G0 = 8;
            this.b = j90Var;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(j90 j90Var, int i) {
            super(0);
            this.G0 = i;
            this.b = j90Var;
        }

        @Override // defpackage.lw
        public final Object invoke() throws InvocationTargetException {
            ai0 ai0VarA;
            String name;
            int i = this.G0;
            j90 j90Var = this.b;
            switch (i) {
                case 0:
                    return new a(j90Var);
                case 1:
                    Collection collectionK = j90Var.k();
                    ArrayList arrayList = new ArrayList(ae.y0(collectionK));
                    Iterator it = collectionK.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new v90(j90Var, (gh) it.next()));
                    }
                    return arrayList;
                case 2:
                    return j90Var.n(((a) j90Var.d.invoke()).a().n().m(), 1);
                case 3:
                    return j90Var.n(((a) j90Var.d.invoke()).a().o0(), 1);
                case 4:
                    int i2 = j90.$r8$clinit;
                    dd ddVarV = j90Var.v();
                    a aVar = (a) j90Var.d.invoke();
                    aVar.getClass();
                    ja0 ja0Var = p90.a.b[0];
                    sw0 sw0Var = (sw0) aVar.a.invoke();
                    boolean z = ddVarV.c;
                    fn fnVar = sw0Var.a;
                    if (z) {
                        Set set = cd.c;
                        cd cdVar = fnVar.s;
                        cdVar.getClass();
                        ai0VarA = (ai0) cdVar.b.invoke(new cd.a(ddVarV, null));
                    } else {
                        ai0VarA = e4.a(fnVar.b, ddVarV);
                    }
                    if (ai0VarA != null) {
                        return ai0VarA;
                    }
                    Class cls = j90Var.c;
                    ju0 ju0VarA = e4.a(cls);
                    wb0.a aVar2 = ju0VarA == null ? null : ju0VarA.b.a;
                    switch (aVar2 != null ? b.a[aVar2.ordinal()] : -1) {
                        case -1:
                        case 6:
                            throw new yi(e4.j("Unresolved class: ", cls));
                        case 0:
                        default:
                            defpackage.d.AnonymousClass0.m();
                            return null;
                        case 1:
                        case 2:
                        case 3:
                            throw new UnsupportedOperationException(e4.j("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: ", cls));
                        case 4:
                            throw new UnsupportedOperationException(e4.j("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations does it have. Please use Java reflection to inspect this class: ", cls));
                        case 5:
                            defpackage.d.AnonymousClass0.m("Unknown class: ", cls, " (kind = ", aVar2);
                            return null;
                    }
                case 5:
                    return j90Var.n(((a) j90Var.d.invoke()).a().n().m(), 2);
                case 6:
                    return j90Var.n(((a) j90Var.d.invoke()).a().o0(), 2);
                case 7:
                    if (!j90Var.c.isAnonymousClass()) {
                        dd ddVarV2 = j90Var.v();
                        if (!ddVarV2.c) {
                            return ddVarV2.b().b();
                        }
                    }
                    return null;
                default:
                    Class cls2 = j90Var.c;
                    if (!cls2.isAnonymousClass()) {
                        dd ddVarV3 = j90Var.v();
                        if (!ddVarV3.c) {
                            return ddVarV3.j().b();
                        }
                        String simpleName = cls2.getSimpleName();
                        Method enclosingMethod = cls2.getEnclosingMethod();
                        if (enclosingMethod == null) {
                            Constructor<?> enclosingConstructor = cls2.getEnclosingConstructor();
                            if (enclosingConstructor == null) {
                                int iJ0 = q31.j0(simpleName, '$', 0, 6);
                                return iJ0 == -1 ? simpleName : simpleName.substring(iJ0 + 1, simpleName.length());
                            }
                            name = enclosingConstructor.getName();
                        } else {
                            name = enclosingMethod.getName();
                        }
                        return q31.w0(simpleName, e4.j(name, "$"), simpleName);
                    }
                    return null;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final /* synthetic */ class d extends ux implements bx {
        public static final d d = new d(2);

        @Override // kotlin.jvm.internal.a, defpackage.a90
        public final String getName() {
            return "loadProperty";
        }

        @Override // kotlin.jvm.internal.a
        public final o90 getOwner() {
            return ou0.a.b(rg0.class);
        }

        @Override // kotlin.jvm.internal.a
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // defpackage.bx
        public final Object invoke(Object obj, Object obj2) {
            return ((rg0) obj).f((kr0) obj2);
        }
    }

    public j90(Class cls) {
        this.c = cls;
    }

    @Override // defpackage.sc
    public final Class d() {
        return this.c;
    }

    @Override // defpackage.h90
    public final String e() {
        a aVar = (a) this.d.invoke();
        aVar.getClass();
        ja0 ja0Var = a.k[3];
        return (String) aVar.d.invoke();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof j90) && e.C(this).equals(e.C((h90) obj));
    }

    public final int hashCode() {
        return e.C(this).hashCode();
    }

    @Override // defpackage.p90
    public final Collection k() {
        ai0 ai0VarA = ((a) this.d.invoke()).a();
        return (ai0VarA.v() == 2 || ai0VarA.v() == 6) ? uq.b : ai0VarA.i();
    }

    @Override // defpackage.p90
    public final Collection l(ij0 ij0Var) {
        nu0$b nu0_b = this.d;
        vg0 vg0VarM = ((a) nu0_b.invoke()).a().n().m();
        dl0 dl0Var = dl0.c;
        return he.X0(((a) nu0_b.invoke()).a().o0().a(ij0Var, dl0Var), vg0VarM.a(ij0Var, dl0Var));
    }

    @Override // defpackage.p90
    public final nq0 m(int i) {
        Class<?> declaringClass;
        Class cls = this.c;
        if (cls.getSimpleName().equals("DefaultImpls") && (declaringClass = cls.getDeclaringClass()) != null && declaringClass.isInterface()) {
            return ((j90) ou0.a.b(declaringClass)).m(i);
        }
        ai0 ai0VarA = ((a) this.d.invoke()).a();
        on onVar = ai0VarA instanceof on ? (on) ai0VarA : null;
        if (onVar != null) {
            kr0 kr0Var = (kr0) e.A(onVar.g, w80.j, i);
            if (kr0Var != null) {
                hn hnVar = onVar.r;
                return (nq0) lc1.d(this.c, kr0Var, hnVar.b, hnVar.d, onVar.i, d.d);
            }
        }
        return null;
    }

    @Override // defpackage.p90
    public final Collection p(ij0 ij0Var) {
        nu0$b nu0_b = this.d;
        vg0 vg0VarM = ((a) nu0_b.invoke()).a().n().m();
        dl0 dl0Var = dl0.c;
        return he.X0(((a) nu0_b.invoke()).a().o0().c(ij0Var, dl0Var), vg0VarM.c(ij0Var, dl0Var));
    }

    public final String toString() {
        dd ddVarV = v();
        cv cvVarH = ddVarV.h();
        return e4.j("class ", e4.j(cvVarH.d() ? AppConfig.CUSTOM : e4.j(cvVarH.b(), "."), ddVarV.i().b().replace('.', '$')));
    }

    public final dd v() {
        wp0 wp0VarD;
        dd ddVar = uw0.a;
        Class cls = this.c;
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            wp0VarD = componentType.isPrimitive() ? u80.b(componentType.getSimpleName()).d() : null;
            return wp0VarD == null ? dd.l(m21.a.g.h()) : new dd(m21.i, wp0VarD.c);
        }
        if (cls.equals(Void.TYPE)) {
            return uw0.a;
        }
        wp0VarD = cls.isPrimitive() ? u80.b(cls.getSimpleName()).d() : null;
        if (wp0VarD != null) {
            return new dd(m21.i, wp0VarD.b);
        }
        dd ddVarA = bt0.a(cls);
        if (!ddVarA.c) {
            String str = l60.a;
            dd ddVar2 = (dd) l60.h.get(ddVarA.b().i());
            if (ddVar2 != null) {
                return ddVar2;
            }
        }
        return ddVarA;
    }
}
