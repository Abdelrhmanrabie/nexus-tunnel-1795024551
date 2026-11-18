package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class lc1 {
    public static final cv a = new cv("kotlin.jvm.JvmStatic");

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[wp0.values().length];
            iArr[wp0.BOOLEAN.ordinal()] = 1;
            iArr[wp0.CHAR.ordinal()] = 2;
            iArr[wp0.BYTE.ordinal()] = 3;
            iArr[wp0.SHORT.ordinal()] = 4;
            iArr[wp0.INT.ordinal()] = 5;
            iArr[wp0.FLOAT.ordinal()] = 6;
            iArr[wp0.LONG.ordinal()] = 7;
            iArr[wp0.DOUBLE.ordinal()] = 8;
            a = iArr;
        }
    }

    public static final v90 a(Object obj) {
        v90 v90Var = obj instanceof v90 ? (v90) obj : null;
        if (v90Var != null) {
            return v90Var;
        }
        ux uxVar = obj instanceof ux ? (ux) obj : null;
        a90 a90VarCompute = uxVar == null ? null : uxVar.compute();
        if (a90VarCompute instanceof v90) {
            return (v90) a90VarCompute;
        }
        return null;
    }

    public static final ArrayList b(w3 w3Var) throws IllegalAccessException, InvocationTargetException {
        List listSingletonList;
        s4 annotations = w3Var.getAnnotations();
        ArrayList<Annotation> arrayList = new ArrayList();
        Iterator it = annotations.iterator();
        while (true) {
            Annotation annotationG = null;
            if (!it.hasNext()) {
                break;
            }
            g4 g4Var = (g4) it.next();
            t11 t11VarG = g4Var.g();
            if (t11VarG instanceof at0) {
                annotationG = ((at0) t11VarG).b;
            } else if (t11VarG instanceof tw0$a) {
                ui uiVar = ((tw0$a) t11VarG).b;
                ct0 ct0Var = uiVar instanceof ct0 ? (ct0) uiVar : null;
                if (ct0Var != null) {
                    annotationG = ct0Var.a;
                }
            } else {
                annotationG = g(g4Var);
            }
            if (annotationG != null) {
                arrayList.add(annotationG);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (((sc) e.v((Annotation) it2.next())).d().getSimpleName().equals("Container")) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Annotation annotation : arrayList) {
                        Class clsD = ((sc) e.v(annotation)).d();
                        if (!clsD.getSimpleName().equals("Container") || clsD.getAnnotation(fv0.class) == null) {
                            listSingletonList = Collections.singletonList(annotation);
                        } else {
                            Object objInvoke = clsD.getDeclaredMethod(XMLRPC.TAG_VALUE, null).invoke(annotation, null);
                            if (objInvoke == null) {
                                d.AnonymousClass0.m$1("null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                                return null;
                            }
                            listSingletonList = Arrays.asList((Annotation[]) objInvoke);
                        }
                        he.C0(listSingletonList, arrayList2);
                    }
                    return arrayList2;
                }
            }
        }
        return arrayList;
    }

    public static final Object c(Class cls) {
        if (!fb$1.m(cls) || !cls.isPrimitive()) {
            return null;
        }
        if (cls.equals(Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (cls.equals(Character.TYPE)) {
            return (char) 0;
        }
        if (cls.equals(Byte.TYPE)) {
            return (byte) 0;
        }
        if (cls.equals(Short.TYPE)) {
            return (short) 0;
        }
        if (cls.equals(Integer.TYPE)) {
            return 0;
        }
        if (cls.equals(Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (cls.equals(Long.TYPE)) {
            return 0L;
        }
        if (cls.equals(Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (!cls.equals(Void.TYPE)) {
            throw new UnsupportedOperationException(e4.j("Unknown primitive: ", cls));
        }
        d.AnonymousClass0.m("Parameter with void type is illegal");
        return null;
    }

    public static final ja d(Class cls, yx.c cVar, jj0 jj0Var, fi0 fi0Var, y8 y8Var, bx bxVar) {
        List list;
        sw0 sw0VarA = bi0.a(cls);
        if (cVar instanceof fr0) {
            list = ((fr0) cVar).o;
        } else {
            if (!(cVar instanceof kr0)) {
                throw new IllegalStateException(e4.j("Unsupported message: ", cVar).toString());
            }
            list = ((kr0) cVar).o;
        }
        List list2 = list;
        fn fnVar = sw0VarA.a;
        return (ja) bxVar.invoke(new rg0(new hn(fnVar, jj0Var, fnVar.b, fi0Var, gd1.b, y8Var, null, null, list2)), cVar);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class f(ClassLoader classLoader, dd ddVar, int i) {
        String str = l60.a;
        dd ddVarG = l60.g(ddVar.b().i());
        if (ddVarG != null) {
            ddVar = ddVarG;
        }
        String strB = ddVar.h().b();
        String strB2 = ddVar.i().b();
        if (strB.equals("kotlin")) {
            switch (strB2.hashCode()) {
                case -901856463:
                    if (strB2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (strB2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (strB2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (strB2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (strB2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (strB2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (strB2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (strB2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (strB2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        String str2 = strB + '.' + strB2.replace('.', '$');
        if (i > 0) {
            str2 = q31.Z(i, "[") + 'L' + str2 + ';';
        }
        try {
            return Class.forName(str2, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final Annotation g(g4 g4Var) {
        ai0 ai0VarD = ym.d(g4Var);
        Class clsH = ai0VarD == null ? null : h(ai0VarD);
        if (clsH == null) {
            clsH = null;
        }
        if (clsH == null) {
            return null;
        }
        Set<Map.Entry> setEntrySet = g4Var.h().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : setEntrySet) {
            ij0 ij0Var = (ij0) entry.getKey();
            Object objI = i((qg) entry.getValue(), clsH.getClassLoader());
            jo0 jo0Var = objI == null ? null : new jo0(ij0Var.b(), objI);
            if (jo0Var != null) {
                arrayList.add(jo0Var);
            }
        }
        Map mapJ = ye1.j(arrayList);
        Set setKeySet = mapJ.keySet();
        ArrayList arrayList2 = new ArrayList(ae.y0(setKeySet));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList2.add(clsH.getDeclaredMethod((String) it.next(), null));
        }
        return (Annotation) e4.a(clsH, mapJ, arrayList2);
    }

    public static final Class h(ai0 ai0Var) {
        t11 t11VarG = ai0Var.g();
        if (t11VarG instanceof zb0) {
            return ((zb0) t11VarG).b.a;
        }
        if (t11VarG instanceof tw0$a) {
            return ((qt0) ((tw0$a) t11VarG).b).a;
        }
        dd ddVarF = ym.f(ai0Var);
        if (ddVarF == null) {
            return null;
        }
        Class<?> cls = ai0Var.getClass();
        List list = bt0.a;
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return f(classLoader, ddVarF, 0);
    }

    public static final Object i(qg qgVar, ClassLoader classLoader) {
        String str;
        if (qgVar instanceof r4) {
            return g((g4) ((r4) qgVar).a);
        }
        int i = 0;
        if (qgVar instanceof h7) {
            h7 h7Var = (h7) qgVar;
            Object obj = h7Var.a;
            kn knVar = h7Var instanceof kn ? (kn) h7Var : null;
            if (knVar != null) {
                Iterable iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(ae.y0(iterable));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(i((qg) it.next(), classLoader));
                }
                fc0 fc0Var = knVar.c;
                ij0 ij0Var = ub0.e;
                od odVarB = fc0Var.L0().b();
                wp0 wp0VarS = odVarB == null ? null : ub0.s(odVarB);
                switch (wp0VarS == null ? -1 : a.a[wp0VarS.ordinal()]) {
                    case -1:
                        if (!ub0.z(fc0Var)) {
                            throw new IllegalStateException(e4.j("Not an array type: ", fc0Var).toString());
                        }
                        fc0 type = ((ca1) he.a1(fc0Var.K0())).getType();
                        od odVarB2 = type.L0().b();
                        ai0 ai0Var = odVarB2 instanceof ai0 ? (ai0) odVarB2 : null;
                        if (ai0Var == null) {
                            throw new IllegalStateException(e4.j("Not a class type: ", type).toString());
                        }
                        if (ub0.E(type, m21.a.f)) {
                            int size = ((List) obj).size();
                            String[] strArr = new String[size];
                            while (i < size) {
                                Object obj2 = arrayList.get(i);
                                if (obj2 != null) {
                                    strArr[i] = (String) obj2;
                                    i++;
                                } else {
                                    str = "null cannot be cast to non-null type kotlin.String";
                                }
                            }
                            return strArr;
                        }
                        if (ub0.c(ai0Var, m21.a.O)) {
                            int size2 = ((List) obj).size();
                            Class[] clsArr = new Class[size2];
                            while (i < size2) {
                                Object obj3 = arrayList.get(i);
                                if (obj3 != null) {
                                    clsArr[i] = (Class) obj3;
                                    i++;
                                } else {
                                    str = "null cannot be cast to non-null type java.lang.Class<*>";
                                }
                            }
                            return clsArr;
                        }
                        dd ddVarF = ym.f(ai0Var);
                        Class clsF = ddVarF == null ? null : f(classLoader, ddVarF, 0);
                        if (clsF != null) {
                            Object objNewInstance = Array.newInstance((Class<?>) clsF, ((List) obj).size());
                            if (objNewInstance != null) {
                                Object[] objArr = (Object[]) objNewInstance;
                                int size3 = arrayList.size();
                                while (i < size3) {
                                    objArr[i] = arrayList.get(i);
                                    i++;
                                }
                                return objArr;
                            }
                            str = "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>";
                        }
                        d.AnonymousClass0.m$1(str);
                        return null;
                    case 0:
                    default:
                        d.AnonymousClass0.m();
                        return null;
                    case 1:
                        int size4 = ((List) obj).size();
                        boolean[] zArr = new boolean[size4];
                        while (i < size4) {
                            Object obj4 = arrayList.get(i);
                            if (obj4 == null) {
                                str = "null cannot be cast to non-null type kotlin.Boolean";
                                d.AnonymousClass0.m$1(str);
                                return null;
                            }
                            zArr[i] = ((Boolean) obj4).booleanValue();
                            i++;
                        }
                        return zArr;
                    case 2:
                        int size5 = ((List) obj).size();
                        char[] cArr = new char[size5];
                        while (i < size5) {
                            Object obj5 = arrayList.get(i);
                            if (obj5 == null) {
                                str = "null cannot be cast to non-null type kotlin.Char";
                                d.AnonymousClass0.m$1(str);
                                return null;
                            }
                            cArr[i] = ((Character) obj5).charValue();
                            i++;
                        }
                        return cArr;
                    case 3:
                        int size6 = ((List) obj).size();
                        byte[] bArr = new byte[size6];
                        while (i < size6) {
                            Object obj6 = arrayList.get(i);
                            if (obj6 == null) {
                                str = "null cannot be cast to non-null type kotlin.Byte";
                                d.AnonymousClass0.m$1(str);
                                return null;
                            }
                            bArr[i] = ((Byte) obj6).byteValue();
                            i++;
                        }
                        return bArr;
                    case 4:
                        int size7 = ((List) obj).size();
                        short[] sArr = new short[size7];
                        while (i < size7) {
                            Object obj7 = arrayList.get(i);
                            if (obj7 == null) {
                                str = "null cannot be cast to non-null type kotlin.Short";
                                d.AnonymousClass0.m$1(str);
                                return null;
                            }
                            sArr[i] = ((Short) obj7).shortValue();
                            i++;
                        }
                        return sArr;
                    case 5:
                        int size8 = ((List) obj).size();
                        int[] iArr = new int[size8];
                        while (i < size8) {
                            Object obj8 = arrayList.get(i);
                            if (obj8 == null) {
                                str = "null cannot be cast to non-null type kotlin.Int";
                                d.AnonymousClass0.m$1(str);
                                return null;
                            }
                            iArr[i] = ((Integer) obj8).intValue();
                            i++;
                        }
                        return iArr;
                    case 6:
                        int size9 = ((List) obj).size();
                        float[] fArr = new float[size9];
                        while (i < size9) {
                            Object obj9 = arrayList.get(i);
                            if (obj9 == null) {
                                str = "null cannot be cast to non-null type kotlin.Float";
                                d.AnonymousClass0.m$1(str);
                                return null;
                            }
                            fArr[i] = ((Float) obj9).floatValue();
                            i++;
                        }
                        return fArr;
                    case 7:
                        int size10 = ((List) obj).size();
                        long[] jArr = new long[size10];
                        while (i < size10) {
                            Object obj10 = arrayList.get(i);
                            if (obj10 == null) {
                                str = "null cannot be cast to non-null type kotlin.Long";
                                d.AnonymousClass0.m$1(str);
                                return null;
                            }
                            jArr[i] = ((Long) obj10).longValue();
                            i++;
                        }
                        return jArr;
                    case 8:
                        int size11 = ((List) obj).size();
                        double[] dArr = new double[size11];
                        while (i < size11) {
                            Object obj11 = arrayList.get(i);
                            if (obj11 == null) {
                                str = "null cannot be cast to non-null type kotlin.Double";
                                d.AnonymousClass0.m$1(str);
                                return null;
                            }
                            dArr[i] = ((Double) obj11).doubleValue();
                            i++;
                        }
                        return dArr;
                }
            }
        } else if (qgVar instanceof kr) {
            jo0 jo0Var = (jo0) ((kr) qgVar).a;
            dd ddVar = (dd) jo0Var.b;
            ij0 ij0Var2 = (ij0) jo0Var.c;
            Class clsF2 = f(classLoader, ddVar, 0);
            if (clsF2 != null) {
                return Enum.valueOf(clsF2, ij0Var2.b());
            }
        } else if (qgVar instanceof m90) {
            m90.a aVar = (m90.a) ((m90) qgVar).a;
            if (aVar instanceof m90.a.b) {
                ed edVar = ((m90.a.b) aVar).a;
                return f(classLoader, edVar.a, edVar.b);
            }
            if (!(aVar instanceof m90.a.C0037a)) {
                d.AnonymousClass0.m();
                return null;
            }
            od odVarB3 = ((m90.a.C0037a) aVar).a.L0().b();
            ai0 ai0Var2 = odVarB3 instanceof ai0 ? (ai0) odVarB3 : null;
            if (ai0Var2 != null) {
                return h(ai0Var2);
            }
        } else {
            if (!(qgVar instanceof rr$a ? true : qgVar instanceof xl0)) {
                return qgVar.b();
            }
        }
        return null;
    }
}
