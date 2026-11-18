package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class cn {
    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    public static final d g;
    public static final d h;
    public static final d i;
    public static final d k;
    public static final e l;
    public static final e m;
    public static final e n;
    public static final li0$a o;
    public static final HashMap p;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d {
        public final /* synthetic */ int G0;
        public final a70 a;

        public d(a70 a70Var, int i) {
            this.G0 = i;
            this.a = a70Var;
        }

        /* JADX WARN: Code duplicated, block: B:134:0x0196 A[ADDED_TO_REGION, LOOP:1: B:134:0x0196->B:146:0x01c6, LOOP_START, PHI: r8
          0x0196: PHI (r8v1 ok) = (r8v0 ok), (r8v2 ok) binds: [B:132:0x0193, B:146:0x01c6] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:135:0x0198  */
        /* JADX WARN: Code duplicated, block: B:137:0x019b  */
        /* JADX WARN: Code duplicated, block: B:146:0x01c6 A[LOOP:1: B:134:0x0196->B:146:0x01c6, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:157:0x01c5 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:158:0x019f A[SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11, types: [ok] */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v25, types: [uk] */
        /* JADX WARN: Type inference failed for: r0v33 */
        /* JADX WARN: Type inference failed for: r0v34, types: [uk] */
        /* JADX WARN: Type inference failed for: r0v40 */
        /* JADX WARN: Type inference failed for: r0v41 */
        /* JADX WARN: Type inference failed for: r0v42 */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Type inference failed for: r7v0, types: [ok, uk] */
        /* JADX WARN: Type inference failed for: r7v1, types: [ok] */
        /* JADX WARN: Type inference failed for: r7v2, types: [ok] */
        /* JADX WARN: Type inference failed for: r7v4, types: [ok] */
        public final boolean c(e eVar, uk ukVar, ok okVar) {
            String str;
            ai0 ai0Var;
            String str2;
            ?? U;
            ?? U2;
            switch (this.G0) {
                case 0:
                    if (okVar == null) {
                        str = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1.isVisible must not be null";
                        defpackage.d.AnonymousClass0.m$4(str);
                        return false;
                    }
                    if (xm.t(ukVar)) {
                        xm.f(okVar);
                    }
                    if (ukVar instanceof gh) {
                        pd pdVarB = ((gh) ukVar).b();
                        if (xm.q(pdVarB) && xm.t(pdVarB) && (okVar instanceof gh) && xm.t(okVar.b())) {
                            xm.f(okVar);
                        }
                    }
                    while (ukVar != 0) {
                        ukVar = ukVar.b();
                        if (((ukVar instanceof ai0) && !xm.l(ukVar)) || (ukVar instanceof wn0)) {
                            if (ukVar != 0) {
                                while (okVar != null) {
                                    if (ukVar != okVar) {
                                        if (okVar instanceof wn0) {
                                            okVar = okVar.b();
                                        } else if ((ukVar instanceof wn0) || !((xn0) ((wn0) ukVar)).g.equals(((xn0) ((wn0) okVar)).g) || !xm.d(okVar).equals(xm.d(ukVar))) {
                                        }
                                    }
                                    return true;
                                }
                            }
                            return false;
                        }
                    }
                    if (ukVar != 0) {
                        while (okVar != null) {
                            if (ukVar != okVar) {
                                if (okVar instanceof wn0) {
                                    okVar = okVar.b();
                                } else if (ukVar instanceof wn0) {
                                }
                            }
                            return true;
                        }
                    }
                    return false;
                case 1:
                    if (okVar == null) {
                        str = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2.isVisible must not be null";
                        defpackage.d.AnonymousClass0.m$4(str);
                        return false;
                    }
                    if (cn.a.c(eVar, ukVar, okVar)) {
                        if (eVar != cn.m) {
                            if (eVar != cn.l) {
                                xm.i(ukVar, ai0.class, true);
                                return false;
                            }
                        }
                        return true;
                    }
                    return false;
                case 2:
                    if (okVar == null) {
                        str = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3.isVisible must not be null";
                        defpackage.d.AnonymousClass0.m$4(str);
                        return false;
                    }
                    ai0 ai0Var2 = (ai0) xm.i(ukVar, ai0.class, true);
                    ai0 ai0Var3 = (ai0) xm.i(okVar, ai0.class, false);
                    if (ai0Var3 != null) {
                        if (ai0Var2 == null || !xm.l(ai0Var2) || (ai0Var = (ai0) xm.i(ai0Var2, ai0.class, true)) == null || !xm.s(ai0Var3.n(), ai0Var.a())) {
                            ?? U3 = ukVar instanceof la ? xm.u((la) ukVar) : ukVar;
                            ai0 ai0Var4 = (ai0) xm.i(U3, ai0.class, true);
                            if (ai0Var4 != null) {
                                if (xm.s(ai0Var3.n(), ai0Var4.a()) && eVar != cn.n) {
                                    if ((U3 instanceof la) && !(U3 instanceof gh) && eVar != cn.m) {
                                        if (eVar != cn.l && eVar != null) {
                                            eVar.getType();
                                            throw null;
                                        }
                                    }
                                }
                                return c(eVar, ukVar, ai0Var3.b());
                            }
                        }
                        return true;
                    }
                    return false;
                case 3:
                    if (okVar == null) {
                        str = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4.isVisible must not be null";
                        defpackage.d.AnonymousClass0.m$4(str);
                        return false;
                    }
                    if (xm.d(okVar).y(xm.d(ukVar))) {
                        cn.o.getClass();
                        return true;
                    }
                    return false;
                case 4:
                    if (okVar != null) {
                        return true;
                    }
                    str2 = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5.isVisible must not be null";
                    ak.AnonymousClass1.m(str2);
                    return false;
                case 5:
                    if (okVar != null) {
                        throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
                    }
                    str2 = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6.isVisible must not be null";
                    ak.AnonymousClass1.m(str2);
                    return false;
                case 6:
                    if (okVar != null) {
                        throw new IllegalStateException("Visibility is unknown yet");
                    }
                    str2 = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7.isVisible must not be null";
                    ak.AnonymousClass1.m(str2);
                    return false;
                case 7:
                    if (okVar != null) {
                        return false;
                    }
                    str2 = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8.isVisible must not be null";
                    ak.AnonymousClass1.m(str2);
                    return false;
                case 8:
                    if (okVar != null) {
                        return false;
                    }
                    str2 = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9.isVisible must not be null";
                    ak.AnonymousClass1.m(str2);
                    return false;
                case 9:
                    if (okVar != null) {
                        return h50.c(ukVar, okVar);
                    }
                    str = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1.isVisible must not be null";
                    defpackage.d.AnonymousClass0.m$4(str);
                    return false;
                case 10:
                    if (okVar == null) {
                        str = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2.isVisible must not be null";
                        defpackage.d.AnonymousClass0.m$4(str);
                        return false;
                    }
                    if (ukVar instanceof la) {
                        U = xm.u((la) ukVar);
                    } else {
                        int i = xm.$r8$clinit;
                        U = ukVar;
                    }
                    if (!h50.c(U, okVar)) {
                        return cn.c.c(eVar, ukVar, okVar);
                    }
                    return true;
                default:
                    if (okVar == null) {
                        str = "Argument for @NotNull parameter 'from' of kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3.isVisible must not be null";
                        defpackage.d.AnonymousClass0.m$4(str);
                        return false;
                    }
                    if (ukVar instanceof la) {
                        U2 = xm.u((la) ukVar);
                    } else {
                        int i2 = xm.$r8$clinit;
                        U2 = ukVar;
                    }
                    if (!h50.c(U2, okVar)) {
                        return cn.c.c(eVar, ukVar, okVar);
                    }
                    return true;
            }
        }

        public final String toString() {
            return this.a.b();
        }
    }

    static {
        a70 a70Var = a70.c$5;
        d dVar = new d(a70Var, 0);
        a = dVar;
        a70 a70Var2 = a70.c$6;
        d dVar2 = new d(a70Var2, 1);
        b = dVar2;
        a70 a70Var3 = a70.c$7;
        d dVar3 = new d(a70Var3, 2);
        c = dVar3;
        a70 a70Var4 = a70.c$2;
        d dVar4 = new d(a70Var4, 3);
        d = dVar4;
        a70 a70Var5 = a70.c$8;
        d dVar5 = new d(a70Var5, 4);
        e = dVar5;
        a70 a70Var6 = a70.c$4;
        d dVar6 = new d(a70Var6, 5);
        f = dVar6;
        a70 a70Var7 = a70.c$1;
        d dVar7 = new d(a70Var7, 6);
        g = dVar7;
        a70 a70Var8 = a70.c$3;
        d dVar8 = new d(a70Var8, 7);
        h = dVar8;
        a70 a70Var9 = a70.c$9;
        d dVar9 = new d(a70Var9, 8);
        i = dVar9;
        Collections.unmodifiableSet(ae.O0(new d[]{dVar, dVar2, dVar4, dVar6}));
        HashMap map = new HashMap(6);
        map.put(dVar2, 0);
        map.put(dVar, 0);
        map.put(dVar4, 1);
        map.put(dVar3, 1);
        map.put(dVar5, 2);
        Collections.unmodifiableMap(map);
        k = dVar5;
        l = new e(15);
        m = new e(16);
        n = new e(17);
        try {
            Iterator it = Arrays.asList(new li0$a[0]).iterator();
            o = it.hasNext() ? (li0$a) it.next() : li0$a.a;
            HashMap map2 = new HashMap();
            p = map2;
            map2.put(a70Var, dVar);
            map2.put(a70Var2, dVar2);
            map2.put(a70Var3, dVar3);
            map2.put(a70Var4, dVar4);
            map2.put(a70Var5, dVar5);
            map2.put(a70Var6, dVar6);
            map2.put(a70Var7, dVar7);
            map2.put(a70Var8, dVar8);
            map2.put(a70Var9, dVar9);
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003a  */
    public static /* synthetic */ void a(int i2) {
        String str = i2 != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 16 ? 3 : 2];
        if (i2 != 1 && i2 != 3 && i2 != 5 && i2 != 7) {
            switch (i2) {
                case 9:
                    objArr[0] = "from";
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = "second";
                    break;
                case 14:
                case 15:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
        } else {
            objArr[0] = "from";
        }
        if (i2 != 16) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        } else {
            objArr[1] = "toDescriptorVisibility";
        }
        switch (i2) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case 12:
            case 13:
                objArr[2] = "compare";
                break;
            case 14:
                objArr[2] = "isPrivate";
                break;
            case 15:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 16:
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 == 16) {
            throw new IllegalStateException(str2);
        }
    }

    public static Integer b(d dVar, d dVar2) {
        if (dVar == null) {
            a(12);
            throw null;
        }
        a70 a70Var = dVar.a;
        if (dVar2 == null) {
            a(13);
            throw null;
        }
        a70 a70Var2 = dVar2.a;
        Integer numA = a70Var.a(a70Var2);
        if (numA != null) {
            return numA;
        }
        Integer numA2 = a70Var2.a(a70Var);
        if (numA2 != null) {
            return Integer.valueOf(-numA2.intValue());
        }
        return null;
    }

    public static uk c(e eVar, la laVar, ok okVar) {
        uk ukVarC;
        if (laVar == null) {
            a(8);
            throw null;
        }
        if (okVar == null) {
            a(9);
            throw null;
        }
        ok okVarA = laVar.a();
        while (true) {
            uk ukVar = (uk) okVarA;
            if (ukVar == null || ukVar.getVisibility() == f) {
                break;
            }
            if (!ukVar.getVisibility().c(eVar, ukVar, okVar)) {
                return ukVar;
            }
            okVarA = xm.i(ukVar, uk.class, true);
        }
        if (!(laVar instanceof p81) || (ukVarC = c(eVar, ((p81) laVar).L, okVar)) == null) {
            return null;
        }
        return ukVarC;
    }

    public static boolean e(d dVar) {
        if (dVar != null) {
            return dVar == a || dVar == b;
        }
        a(14);
        throw null;
    }

    public static d g(a70 a70Var) {
        if (a70Var == null) {
            a(15);
            throw null;
        }
        d dVar = (d) p.get(a70Var);
        if (dVar != null) {
            return dVar;
        }
        defpackage.d.AnonymousClass0.m("Inapplicable visibility: ", a70Var);
        return null;
    }
}
