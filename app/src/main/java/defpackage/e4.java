package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.view.View;
import android.widget.EdgeEffect;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class e4 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static oo f46a;
    public static final ke b = new ke(9);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f49a = {48, 49, 53, 0};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final byte[] f50b = {48, 49, 48, 0};
    public static final byte[] c = {48, 48, 57, 0};
    public static final byte[] d = {48, 48, 53, 0};
    public static final byte[] e = {48, 48, 49, 0};
    public static final byte[] f = {48, 48, 49, 0};
    public static final byte[] g = {48, 48, 50, 0};
    public static final ci0 a = new ci0("KotlinTypeRefiner", 0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final xt.a f48a = new xt.a(0, 1, 0);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String[] f51c = {"standard", "accelerate", "decelerate", "linear"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final s4$a$a f47a = new s4$a$a();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements InvocationHandler {
        public final /* synthetic */ Class a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ v41 c;
        public final /* synthetic */ v41 d;
        public final /* synthetic */ List e;

        public b(Class cls, Map map, v41 v41Var, v41 v41Var2, List list) {
            this.a = cls;
            this.b = map;
            this.c = v41Var;
            this.d = v41Var2;
            this.e = list;
        }

        /* JADX WARN: Code duplicated, block: B:131:0x0167 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:142:? A[LOOP:0: B:46:0x009d->B:142:?, LOOP_END, SYNTHETIC] */
        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
            Class clsD;
            boolean zA;
            String str;
            boolean z;
            String name = method.getName();
            Class cls = this.a;
            if (name != null) {
                int iHashCode = name.hashCode();
                if (iHashCode != -1776922004) {
                    if (iHashCode != 147696667) {
                        if (iHashCode == 1444986633 && name.equals("annotationType")) {
                            return cls;
                        }
                    } else if (name.equals("hashCode")) {
                        return Integer.valueOf(((Number) this.d.getValue()).intValue());
                    }
                } else if (name.equals("toString")) {
                    return (String) this.c.getValue();
                }
            }
            boolean zA2 = e4.a(name, "equals");
            Map map = this.b;
            boolean z2 = false;
            if (!zA2 || objArr == null || objArr.length != 1) {
                if (map.containsKey(name)) {
                    return map.get(name);
                }
                StringBuilder sb = new StringBuilder("Method is not supported: ");
                sb.append(method);
                sb.append(" (args: ");
                if (objArr == null) {
                    objArr = new Object[0];
                }
                sb.append(ae.M0(objArr));
                sb.append(')');
                throw new yi(sb.toString());
            }
            Object objL0 = ae.L0(objArr);
            Annotation annotation = objL0 instanceof Annotation ? (Annotation) objL0 : null;
            if (annotation == null) {
                clsD = null;
            } else {
                clsD = ((sc) ou0.a.b(annotation.annotationType())).d();
            }
            if (e4.a(clsD, cls)) {
                List list = this.e;
                if (list != null && list.isEmpty()) {
                    z = true;
                    break;
                }
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    Method method2 = (Method) it.next();
                    Object obj2 = map.get(method2.getName());
                    Object objInvoke = method2.invoke(objL0, null);
                    if (obj2 instanceof boolean[]) {
                        boolean[] zArr = (boolean[]) obj2;
                        if (objInvoke == null) {
                            str = "null cannot be cast to non-null type kotlin.BooleanArray";
                            d.AnonymousClass0.m$1(str);
                            return null;
                        }
                        zA = Arrays.equals(zArr, (boolean[]) objInvoke);
                        if (!zA) {
                            z = false;
                            break;
                        }
                    } else if (obj2 instanceof char[]) {
                        char[] cArr = (char[]) obj2;
                        if (objInvoke == null) {
                            str = "null cannot be cast to non-null type kotlin.CharArray";
                            d.AnonymousClass0.m$1(str);
                            return null;
                        }
                        zA = Arrays.equals(cArr, (char[]) objInvoke);
                        if (!zA) {
                            z = false;
                            break;
                        }
                    } else if (obj2 instanceof byte[]) {
                        byte[] bArr = (byte[]) obj2;
                        if (objInvoke == null) {
                            str = "null cannot be cast to non-null type kotlin.ByteArray";
                            d.AnonymousClass0.m$1(str);
                            return null;
                        }
                        zA = Arrays.equals(bArr, (byte[]) objInvoke);
                        if (!zA) {
                            z = false;
                            break;
                        }
                    } else if (obj2 instanceof short[]) {
                        short[] sArr = (short[]) obj2;
                        if (objInvoke == null) {
                            str = "null cannot be cast to non-null type kotlin.ShortArray";
                            d.AnonymousClass0.m$1(str);
                            return null;
                        }
                        zA = Arrays.equals(sArr, (short[]) objInvoke);
                        if (!zA) {
                            z = false;
                            break;
                        }
                    } else if (obj2 instanceof int[]) {
                        int[] iArr = (int[]) obj2;
                        if (objInvoke == null) {
                            str = "null cannot be cast to non-null type kotlin.IntArray";
                            d.AnonymousClass0.m$1(str);
                            return null;
                        }
                        zA = Arrays.equals(iArr, (int[]) objInvoke);
                        if (!zA) {
                            z = false;
                            break;
                        }
                    } else if (obj2 instanceof float[]) {
                        float[] fArr = (float[]) obj2;
                        if (objInvoke == null) {
                            str = "null cannot be cast to non-null type kotlin.FloatArray";
                            d.AnonymousClass0.m$1(str);
                            return null;
                        }
                        zA = Arrays.equals(fArr, (float[]) objInvoke);
                        if (!zA) {
                            z = false;
                            break;
                        }
                    } else if (obj2 instanceof long[]) {
                        long[] jArr = (long[]) obj2;
                        if (objInvoke == null) {
                            str = "null cannot be cast to non-null type kotlin.LongArray";
                            d.AnonymousClass0.m$1(str);
                            return null;
                        }
                        zA = Arrays.equals(jArr, (long[]) objInvoke);
                        if (!zA) {
                            z = false;
                            break;
                        }
                    } else if (obj2 instanceof double[]) {
                        double[] dArr = (double[]) obj2;
                        if (objInvoke == null) {
                            str = "null cannot be cast to non-null type kotlin.DoubleArray";
                            d.AnonymousClass0.m$1(str);
                            return null;
                        }
                        zA = Arrays.equals(dArr, (double[]) objInvoke);
                        if (!zA) {
                            z = false;
                            break;
                        }
                    } else {
                        if (obj2 instanceof Object[]) {
                            Object[] objArr2 = (Object[]) obj2;
                            if (objInvoke == null) {
                                str = "null cannot be cast to non-null type kotlin.Array<*>";
                                d.AnonymousClass0.m$1(str);
                                return null;
                            }
                            zA = Arrays.equals(objArr2, (Object[]) objInvoke);
                        } else {
                            zA = e4.a(obj2, objInvoke);
                        }
                        if (!zA) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z) {
                    z2 = true;
                }
            }
            return Boolean.valueOf(z2);
        }
    }

    public static boolean A(fc0 fc0Var, cv cvVar) {
        if (fb$1.m(fc0Var)) {
            return fc0Var.getAnnotations().f(cvVar);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(fc0Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, fc0Var.getClass(), sb));
        return false;
    }

    public static boolean C(v91 v91Var, b91 b91Var) {
        if (b91Var == null ? true : b91Var instanceof a91) {
            return e.J(v91Var, (a91) b91Var, null);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(v91Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, v91Var.getClass(), sb));
        return false;
    }

    public static boolean D(w01 w01Var, w01 w01Var2) {
        String strM;
        if (!(w01Var instanceof u01)) {
            strM = fb$1.m(ou0.a, w01Var.getClass(), e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", "));
        } else {
            if (w01Var2 instanceof u01) {
                return ((u01) w01Var).K0() == ((u01) w01Var2).K0();
            }
            strM = fb$1.m(ou0.a, w01Var2.getClass(), e.m("ClassicTypeSystemContext couldn't handle: ", w01Var2, ", "));
        }
        d.AnonymousClass0.m((Object) strM);
        return false;
    }

    public static cc1 E(ArrayList arrayList) {
        u01 u01Var;
        int size = arrayList.size();
        if (size == 0) {
            d.AnonymousClass0.m("Expected some types");
            return null;
        }
        if (size == 1) {
            return (cc1) he.a1(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(ae.y0(arrayList));
        Iterator it = arrayList.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            cc1 cc1Var = (cc1) it.next();
            z = z || e.O((fc0) cc1Var);
            if (cc1Var instanceof u01) {
                u01Var = (u01) cc1Var;
            } else {
                if (!(cc1Var instanceof zt)) {
                    d.AnonymousClass0.m();
                    return null;
                }
                if (cc1Var instanceof op) {
                    return cc1Var;
                }
                u01Var = ((zt) cc1Var).c;
                z2 = true;
            }
            arrayList2.add(u01Var);
        }
        if (z) {
            return pr.d(j("Intersection of error types: ", arrayList));
        }
        o91 o91Var = o91.a;
        if (!z2) {
            return o91Var.b(arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(ae.y0(arrayList));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add(e.s1((cc1) it2.next()));
        }
        return c(o91Var.b(arrayList2), o91Var.b(arrayList3));
    }

    public static boolean F(b91 b91Var) {
        if (b91Var instanceof a91) {
            return ub0.J((a91) b91Var, m21.a.a);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(b91Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, b91Var.getClass(), sb));
        return false;
    }

    public static boolean G(b91 b91Var) {
        if (b91Var instanceof a91) {
            return ((a91) b91Var).b() instanceof ai0;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(b91Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, b91Var.getClass(), sb));
        return false;
    }

    public static boolean H(b91 b91Var) {
        if (b91Var instanceof a91) {
            od odVarB = ((a91) b91Var).b();
            ai0 ai0Var = odVarB instanceof ai0 ? (ai0) odVarB : null;
            return (ai0Var == null || ai0Var.p() != zh0.b || ai0Var.v() == 3 || ai0Var.v() == 4 || ai0Var.v() == 5) ? false : true;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(b91Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, b91Var.getClass(), sb));
        return false;
    }

    public static boolean I(b91 b91Var) {
        if (b91Var instanceof a91) {
            return ((a91) b91Var).c();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(b91Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, b91Var.getClass(), sb));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean J(w01 w01Var) {
        if (w01Var instanceof fc0) {
            return e.O((fc0) w01Var);
        }
        StringBuilder sbM = e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), sbM));
        return false;
    }

    public static boolean L(b91 b91Var) {
        if (b91Var instanceof a91) {
            return b91Var instanceof c30;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(b91Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, b91Var.getClass(), sb));
        return false;
    }

    public static boolean M(b91 b91Var) {
        if (b91Var instanceof a91) {
            return b91Var instanceof j30;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(b91Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, b91Var.getClass(), sb));
        return false;
    }

    public static boolean N(w01 w01Var) {
        if (w01Var instanceof u01) {
            return ((u01) w01Var).M0();
        }
        StringBuilder sbM = e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), sbM));
        return false;
    }

    public static boolean P(b91 b91Var) {
        if (b91Var instanceof a91) {
            return ub0.J((a91) b91Var, m21.a.b);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(b91Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, b91Var.getClass(), sb));
        return false;
    }

    public static boolean Q(jc0 jc0Var) {
        if (jc0Var instanceof fc0) {
            return ma1.g((fc0) jc0Var);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(jc0Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, jc0Var.getClass(), sb));
        return false;
    }

    public static boolean S(rb rbVar) {
        if (rbVar instanceof tk0) {
            return ((tk0) rbVar).j;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(rbVar);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, rbVar.getClass(), sb));
        return false;
    }

    public static boolean T(ca1 ca1Var) {
        if (ca1Var != null) {
            return ca1Var.b();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(ca1Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, ca1Var.getClass(), sb));
        return false;
    }

    public static void U(w01 w01Var) {
        if (w01Var instanceof u01) {
            if (w01Var instanceof ml) {
            }
        } else {
            StringBuilder sbM = e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
            d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), sbM));
        }
    }

    public static void V(w01 w01Var) {
        if (w01Var instanceof u01) {
            if (w01Var instanceof ml) {
            }
        } else {
            StringBuilder sbM = e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
            d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), sbM));
        }
    }

    public static u01 X(zt ztVar) {
        if (ztVar != null) {
            return ztVar.c;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(ztVar);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, ztVar.getClass(), sb));
        return null;
    }

    public static cc1 Z(rb rbVar) {
        if (rbVar instanceof tk0) {
            return ((tk0) rbVar).f;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(rbVar);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, rbVar.getClass(), sb));
        return null;
    }

    public static float a(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
            }
        }
        return 0.0f;
    }

    public static final ai0 a(gi0 gi0Var, dd ddVar) {
        od odVarB = b(gi0Var, ddVar);
        if (odVarB instanceof ai0) {
            return (ai0) odVarB;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0021  */
    /* JADX WARN: Code duplicated, block: B:24:0x002f A[EDGE_INSN: B:24:0x002f->B:19:0x002f BREAK  A[LOOP:0: B:3:0x0001->B:27:0x0001], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x002c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0029 A[SYNTHETIC] */
    public static NavController a(View view) {
        NavController navController;
        View view2 = view;
        while (true) {
            if (view2 == null) {
                navController = null;
                break;
            }
            Object tag = view2.getTag(R.attr.s0);
            if (tag instanceof WeakReference) {
                tag = ((WeakReference) tag).get();
            } else {
                if (!(tag instanceof NavController)) {
                    navController = null;
                }
                if (navController != null) {
                    break;
                }
                Object parent = view2.getParent();
                view2 = parent instanceof View ? (View) parent : null;
            }
            navController = (NavController) tag;
            if (navController != null) {
                break;
                break;
            }
            Object parent2 = view2.getParent();
            if (parent2 instanceof View) {
            }
        }
        if (navController != null) {
            return navController;
        }
        d.AnonymousClass0.m("View ", view, " does not have a NavController set");
        return null;
    }

    public static final Object a(Class cls, Map map, List list) {
        int i = 4;
        v41 v41Var = new v41(new ca0(i, map));
        Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new b(cls, map, new v41(new qn(i, cls, map)), v41Var, list));
        if (objNewProxyInstance != null) {
            return objNewProxyInstance;
        }
        d.AnonymousClass0.m$1("null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return null;
    }

    public static String a(gc gcVar, q50 q50Var) {
        if (gcVar.b(q50Var)) {
            return null;
        }
        return gcVar.getDescription();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006c  */
    public static ju0 a(Class cls) throws InvocationTargetException {
        wb0 wb0Var;
        ns0 ns0Var = new ns0();
        ns0Var.a = null;
        ns0Var.b = null;
        ns0Var.c = 0;
        ns0Var.d = null;
        ns0Var.e = null;
        ns0Var.f = null;
        ns0Var.g = null;
        ns0Var.h = null;
        e.C(cls, ns0Var);
        if (ns0Var.g == null || ns0Var.a == null) {
            wb0Var = null;
        } else {
            q80 q80Var = new q80(ns0Var.a, (ns0Var.c & 8) != 0);
            if (q80Var.c()) {
                wb0.a aVar = ns0Var.g;
                if ((aVar == wb0.a.CLASS || aVar == wb0.a.FILE_FACADE || aVar == wb0.a.MULTIFILE_CLASS_PART) && ns0Var.d == null) {
                    wb0Var = null;
                }
            } else {
                ns0Var.f = ns0Var.d;
                ns0Var.d = null;
            }
            String[] strArr = ns0Var.h;
            if (strArr != null) {
                z8.b(strArr);
            }
            wb0Var = new wb0(ns0Var.g, q80Var, ns0Var.d, ns0Var.f, ns0Var.e, ns0Var.b, ns0Var.c);
        }
        if (wb0Var == null) {
            return null;
        }
        return new ju0(cls, wb0Var);
    }

    public static final m6 a(u01 u01Var, pd pdVar, int i) {
        pd pdVar2 = null;
        if (pdVar == null || pr.h(pdVar)) {
            return null;
        }
        int size = pdVar.o().size() + i;
        if (pdVar.B()) {
            List listSubList = u01Var.K0().subList(i, size);
            ok okVarB = pdVar.b();
            return new m6(pdVar, listSubList, a(u01Var, okVarB instanceof pd ? (pd) okVarB : null, size));
        }
        if (size != u01Var.K0().size()) {
            xm.o(pdVar);
        }
        return new m6(pdVar, u01Var.K0().subList(i, u01Var.K0().size()), pdVar2);
    }

    public static nm a(nw nwVar) {
        um umVar = new um();
        nwVar.invoke(umVar);
        umVar.a = true;
        return new nm(umVar);
    }

    public static r9 a(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        y20 y20Var = new y20(1, dataInputStream.readInt(), 1);
        ArrayList arrayList = new ArrayList(ae.y0(y20Var));
        Iterator it = y20Var.iterator();
        while (true) {
            x20 x20Var = (x20) it;
            if (!x20Var.d) {
                break;
            }
            x20Var.nextInt();
            arrayList.add(Integer.valueOf(dataInputStream.readInt()));
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        Iterator it2 = arrayList.iterator();
        int i = 0;
        while (it2.hasNext()) {
            iArr[i] = ((Number) it2.next()).intValue();
            i++;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, size);
        return new r9(Arrays.copyOf(iArrCopyOf, iArrCopyOf.length));
    }

    public static xf1 a(ch chVar, int i, ArrayList arrayList, xf1 xf1Var) {
        vg vgVar;
        int i2;
        int i3 = i == 0 ? chVar.q0 : chVar.r0;
        if (i3 != -1 && (xf1Var == null || i3 != xf1Var.b)) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                xf1 xf1Var2 = (xf1) arrayList.get(i4);
                if (xf1Var2.b == i3) {
                    if (xf1Var != null) {
                        xf1Var.c(i, xf1Var2);
                        arrayList.remove(xf1Var);
                    }
                    xf1Var = xf1Var2;
                    break;
                }
            }
        } else if (i3 != -1) {
            return xf1Var;
        }
        if (xf1Var == null) {
            if (chVar instanceof h8) {
                h8 h8Var = (h8) chVar;
                int i5 = 0;
                while (true) {
                    if (i5 >= h8Var.t0) {
                        i2 = -1;
                        break;
                    }
                    ch chVar2 = h8Var.s0[i5];
                    if ((i == 0 && (i2 = chVar2.q0) != -1) || (i == 1 && (i2 = chVar2.r0) != -1)) {
                        break;
                    }
                    i5++;
                }
                if (i2 != -1) {
                    for (int i6 = 0; i6 < arrayList.size(); i6++) {
                        xf1 xf1Var3 = (xf1) arrayList.get(i6);
                        if (xf1Var3.b == i2) {
                            xf1Var = xf1Var3;
                            break;
                        }
                    }
                }
            }
            if (xf1Var == null) {
                xf1Var = new xf1(i);
            }
            arrayList.add(xf1Var);
        }
        ArrayList arrayList2 = xf1Var.a;
        if (arrayList2.contains(chVar)) {
            return xf1Var;
        }
        arrayList2.add(chVar);
        if (chVar instanceof py) {
            py pyVar = (py) chVar;
            pyVar.v0.b(pyVar.w0 == 0 ? 1 : 0, xf1Var, arrayList);
        }
        int i7 = xf1Var.b;
        if (i == 0) {
            chVar.q0 = i7;
            chVar.K.b(i, xf1Var, arrayList);
            vgVar = chVar.M;
        } else {
            chVar.r0 = i7;
            chVar.L.b(i, xf1Var, arrayList);
            chVar.O.b(i, xf1Var, arrayList);
            vgVar = chVar.N;
        }
        vgVar.b(i, xf1Var, arrayList);
        chVar.R.b(i, xf1Var, arrayList);
        return xf1Var;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:0x00c1 A[EDGE_INSN: B:101:0x00c1->B:79:0x00c1 BREAK  A[LOOP:0: B:20:0x0029->B:109:0x0029], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0029 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00bb  */
    public static yo a(h70 h70Var, g70 g70Var, int i) {
        g70 w30Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Throwable thB;
        boolean z = (i & 1) == 0;
        boolean z2 = (i & 2) != 0;
        h70Var.getClass();
        if (z) {
            w30Var = g70Var instanceof e70 ? (e70) g70Var : null;
            if (w30Var == null) {
                w30Var = new w30(g70Var);
            }
        } else {
            w30Var = g70Var;
        }
        w30Var.f = h70Var;
        loop0: while (true) {
            Object objN = h70Var.N();
            if (objN instanceof oq) {
                oq oqVar = (oq) objN;
                if (oqVar.b) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = h70.b;
                    while (!atomicReferenceFieldUpdater2.compareAndSet(h70Var, objN, w30Var)) {
                        if (atomicReferenceFieldUpdater2.get(h70Var) != objN) {
                        }
                    }
                    break loop0;
                }
                fl0 fl0Var = new fl0();
                Object v10Var = fl0Var;
                if (!oqVar.b) {
                    v10Var = new v10(fl0Var);
                }
                do {
                    atomicReferenceFieldUpdater = h70.b;
                    if (atomicReferenceFieldUpdater.compareAndSet(h70Var, oqVar, v10Var)) {
                        break;
                    }
                } while (atomicReferenceFieldUpdater.get(h70Var) == oqVar);
            } else {
                if (!(objN instanceof x10)) {
                    if (z2) {
                        te teVar = objN instanceof te ? (te) objN : null;
                        g70Var.invoke(teVar != null ? teVar.a : null);
                    }
                    return gl0.b;
                }
                x10 x10Var = (x10) objN;
                fl0 fl0VarC = x10Var.c();
                if (fl0VarC == null) {
                    h70Var.Y((g70) objN);
                } else {
                    yo yoVar = gl0.b;
                    if (z && (objN instanceof h70.c)) {
                        synchronized (objN) {
                            try {
                                thB = ((h70.c) objN).b();
                                if (thB == null || ((g70Var instanceof oc) && !((h70.c) objN).e())) {
                                    if (h70Var.b((x10) objN, fl0VarC, w30Var)) {
                                        if (thB == null) {
                                            return w30Var;
                                        }
                                        yoVar = w30Var;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (thB != null) {
                            if (z2) {
                                g70Var.invoke(thB);
                            }
                            return yoVar;
                        }
                        if (h70Var.b(x10Var, fl0VarC, w30Var)) {
                            break;
                            break;
                        }
                    } else {
                        thB = null;
                        if (thB != null) {
                            if (z2) {
                                g70Var.invoke(thB);
                            }
                            return yoVar;
                        }
                        if (h70Var.b(x10Var, fl0VarC, w30Var)) {
                            break;
                        }
                    }
                }
            }
        }
        return w30Var;
    }

    public static boolean a(b91 b91Var, b91 b91Var2) {
        String strM;
        if (!(b91Var instanceof a91)) {
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(b91Var);
            sb.append(", ");
            strM = fb$1.m(ou0.a, b91Var.getClass(), sb);
        } else {
            if (b91Var2 instanceof a91) {
                return b91Var.equals(b91Var2);
            }
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(b91Var2);
            sb2.append(", ");
            strM = fb$1.m(ou0.a, b91Var2.getClass(), sb2);
        }
        d.AnonymousClass0.m((Object) strM);
        return false;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean a(so0$a[] so0_aArr, so0$a[] so0_aArr2) {
        if (so0_aArr != null && so0_aArr2 != null && so0_aArr.length == so0_aArr2.length) {
            for (int i = 0; i < so0_aArr.length; i++) {
                so0$a so0_a = so0_aArr[i];
                char c2 = so0_a.a;
                so0$a so0_a2 = so0_aArr2[i];
                if (c2 == so0_a2.a && so0_a.b.length == so0_a2.b.length) {
                }
            }
            return true;
        }
        return false;
    }

    public static float b(EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT < 31) {
            edgeEffect.onPull(f2, f3);
            return f2;
        }
        try {
            return edgeEffect.onPullDistance(f2, f3);
        } catch (Throwable unused) {
            edgeEffect.onPull(f2, f3);
            return 0.0f;
        }
    }

    public static int b(jc0 jc0Var) {
        if (jc0Var instanceof fc0) {
            return ((fc0) jc0Var).K0().size();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(jc0Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, jc0Var.getClass(), sb));
        return 0;
    }

    public static List b(ft0 ft0Var) {
        AnnotatedElement element = ft0Var.getElement();
        Annotation[] declaredAnnotations = element == null ? null : element.getDeclaredAnnotations();
        if (declaredAnnotations == null) {
            return uq.b;
        }
        ArrayList arrayList = new ArrayList(declaredAnnotations.length);
        int length = declaredAnnotations.length;
        int i = 0;
        while (i < length) {
            Annotation annotation = declaredAnnotations[i];
            i++;
            arrayList.add(new ct0(annotation));
        }
        return arrayList;
    }

    public static final List b(pd pdVar) {
        Object next;
        List listO = pdVar.o();
        if (!pdVar.B() && !(pdVar.b() instanceof ja)) {
            return listO;
        }
        int i = ym.$r8$clinit;
        ba baVar = ba.b$8;
        sy0 sy0VarW = fz0.w(pdVar, baVar);
        List listE = fz0.E(new yt(fz0.y(new ge(1, sy0VarW instanceof lp ? ((lp) sy0VarW).a() : new kp(sy0VarW, 1)), ba.b$6), ba.b$7, ez0.d));
        sy0 sy0VarW2 = fz0.w(pdVar, baVar);
        Iterator it = (sy0VarW2 instanceof lp ? ((lp) sy0VarW2).a() : new kp(sy0VarW2, 1)).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof ai0));
        ai0 ai0Var = (ai0) next;
        List parameters = ai0Var != null ? ai0Var.h().getParameters() : null;
        if (parameters == null) {
            parameters = uq.b;
        }
        if (listE.isEmpty() && parameters.isEmpty()) {
            return pdVar.o();
        }
        ArrayList arrayListX0 = he.X0(parameters, listE);
        ArrayList arrayList = new ArrayList(ae.y0(arrayListX0));
        Iterator it2 = arrayListX0.iterator();
        while (it2.hasNext()) {
            arrayList.add(new sb((v91) it2.next(), pdVar, listO.size()));
        }
        return he.X0(arrayList, listO);
    }

    public static final od b(gi0 gi0Var, dd ddVar) {
        if (gi0Var.t0(ak.f0a) != null) {
            d.AnonymousClass0.m$1();
            return null;
        }
        dl0 dl0Var = dl0.j;
        vd0 vd0VarU = gi0Var.U(ddVar.h());
        List listF = ddVar.i().a.f();
        od odVarE = vd0VarU.j.e((ij0) he.K0(listF), dl0Var);
        if (odVarE != null) {
            for (ij0 ij0Var : listF.subList(1, listF.size())) {
                if (odVarE instanceof ai0) {
                    od odVarE2 = ((ai0) odVarE).V().e(ij0Var, dl0Var);
                    odVarE = odVarE2 instanceof ai0 ? (ai0) odVarE2 : null;
                    if (odVarE == null) {
                    }
                }
            }
            return odVarE;
        }
        return null;
    }

    public static void b(CardView.a aVar) {
        float f2;
        CardView cardView = CardView.this;
        if (!cardView.mCompatPadding) {
            aVar.a(0, 0, 0, 0);
            return;
        }
        mw0 mw0Var = aVar.a;
        float f3 = mw0Var.e;
        float f4 = mw0Var.a;
        if (cardView.mPreventCornerOverlap) {
            f2 = (float) (((1.0d - nw0.a) * ((double) f4)) + ((double) f3));
        } else {
            int i = nw0.$r8$clinit;
            f2 = f3;
        }
        int iCeil = (int) Math.ceil(f2);
        float f5 = f3 * 1.5f;
        if (cardView.mPreventCornerOverlap) {
            f5 = (float) (((1.0d - nw0.a) * ((double) f4)) + ((double) f5));
        }
        int iCeil2 = (int) Math.ceil(f5);
        aVar.a(iCeil, iCeil2, iCeil, iCeil2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(i8 i8Var) {
        if (((kx) i8Var).getArity() == 2) {
            return;
        }
        c("kotlin.jvm.functions.Function2", i8Var);
        throw null;
    }

    public static final void b(Object obj) throws Throwable {
        if (obj instanceof bw0.a) {
            throw ((bw0.a) obj).b;
        }
    }

    public static boolean b(int i, int i2, int i3, int i4) {
        return (i3 == 1 || i3 == 2 || (i3 == 4 && i != 2)) || (i4 == 1 || i4 == 2 || (i4 == 4 && i2 != 2));
    }

    public static boolean b(File file, Resources resources, int i) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
            try {
                boolean zC = c(file, inputStreamOpenRawResource);
                if (inputStreamOpenRawResource != null) {
                    try {
                        inputStreamOpenRawResource.close();
                    } catch (IOException unused) {
                    }
                }
                return zC;
            } catch (Throwable th) {
                th = th;
                if (inputStreamOpenRawResource != null) {
                    try {
                        inputStreamOpenRawResource.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static final ai0 c(gi0 gi0Var, dd ddVar, oo ooVar) {
        ai0 ai0VarA = a(gi0Var, ddVar);
        return ai0VarA != null ? ai0VarA : ooVar.a(ddVar, fz0.E(new c81(fz0.w(ddVar, kt$a.d), ba.b$28)));
    }

    public static final cc1 c(u01 u01Var, u01 u01Var2) {
        return a(u01Var, u01Var2) ? u01Var : new bu(u01Var, u01Var2);
    }

    public static w81 c(w01 w01Var) {
        if (w01Var instanceof u01) {
            return (w81) w01Var;
        }
        StringBuilder sbM = e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), sbM));
        return null;
    }

    public static void c(String str, Object obj) {
        throw new ClassCastException(e.j(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
    }

    public static boolean c(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i != -1) {
                            fileOutputStream.write(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    }
                    fileOutputStream.close();
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    e.getMessage();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:21:0x0052  */
    /* JADX WARN: Code duplicated, block: B:39:0x008e A[PHI: r15
      0x008e: PHI (r15v3 int) = (r15v1 int), (r15v1 int), (r15v6 int) binds: [B:28:0x0076, B:31:0x007c, B:37:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x009c A[Catch: NumberFormatException -> 0x0098, TryCatch #0 {NumberFormatException -> 0x0098, blocks: (B:22:0x0055, B:25:0x006a, B:27:0x0070, B:31:0x007c, B:43:0x0094, B:47:0x009c, B:50:0x00ad, B:54:0x00b6, B:55:0x00c2, B:56:0x00c7, B:57:0x00c8, B:58:0x00cd), top: B:72:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ad A[Catch: NumberFormatException -> 0x0098, TryCatch #0 {NumberFormatException -> 0x0098, blocks: (B:22:0x0055, B:25:0x006a, B:27:0x0070, B:31:0x007c, B:43:0x0094, B:47:0x009c, B:50:0x00ad, B:54:0x00b6, B:55:0x00c2, B:56:0x00c7, B:57:0x00c8, B:58:0x00cd), top: B:72:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0087, code lost:
    
        if (r17 == 0) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.so0$a[] c(java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e4.c(java.lang.String):so0$a[]");
    }

    public static int c0(b91 b91Var) {
        if (b91Var instanceof a91) {
            return ((a91) b91Var).getParameters().size();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(b91Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, b91Var.getClass(), sb));
        return 0;
    }

    public static Path d(String str) {
        Path path = new Path();
        try {
            so0$a.b(c(str), path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing ".concat(str), e2);
        }
    }

    public static File d(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, str + i);
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public static rb d(ld ldVar, w01 w01Var) {
        if (!(w01Var instanceof u01)) {
            StringBuilder sbM = e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
            d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), sbM));
            return null;
        }
        if (w01Var instanceof x01) {
            return ldVar.e(((x01) w01Var).c);
        }
        if (w01Var instanceof tk0) {
            return (tk0) w01Var;
        }
        return null;
    }

    public static Set d0(ld ldVar, w01 w01Var) {
        a91 a91VarC = ldVar.c(w01Var);
        if (a91VarC instanceof c30) {
            return ((c30) a91VarC).c;
        }
        StringBuilder sbM = e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), sbM));
        return null;
    }

    public static MappedByteBuffer e(Context context, Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return null;
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return map;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
        } catch (IOException unused) {
        }
    }

    public static ml e(w01 w01Var) {
        if (w01Var instanceof u01) {
            if (w01Var instanceof ml) {
                return (ml) w01Var;
            }
            return null;
        }
        StringBuilder sbM = e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), sbM));
        return null;
    }

    public static ca1 e0(mb mbVar) {
        if (mbVar instanceof vk0) {
            return ((vk0) mbVar).a;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(mbVar);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, mbVar.getClass(), sb));
        return null;
    }

    public static op f(zt ztVar) {
        if (ztVar instanceof op) {
            return (op) ztVar;
        }
        return null;
    }

    public static final u01 f(s4 s4Var, a91 a91Var, List list, boolean z) {
        vg0 vg0VarA;
        if (s4Var.isEmpty() && list.isEmpty() && !z && a91Var.b() != null) {
            return a91Var.b().n();
        }
        od odVarB = a91Var.b();
        int i = 1;
        if (odVarB instanceof v91) {
            vg0VarA = ((v91) odVarB).n().m();
        } else if (odVarB instanceof ai0) {
            int i2 = ym.$r8$clinit;
            ym.i(xm.d(odVarB));
            boolean zIsEmpty = list.isEmpty();
            ai0 ai0Var = (ai0) odVarB;
            lc0$a lc0_a = lc0$a.a;
            vg0VarA = zIsEmpty ? ai0Var.W(lc0_a) : ai0Var.z(ak.b(a91Var, list), lc0_a);
        } else if (odVarB instanceof co) {
            vg0VarA = pr.c(j("Scope for abbreviation: ", ((co) odVarB).getName()), true);
        } else {
            if (!(a91Var instanceof j30)) {
                throw new IllegalStateException("Unsupported classifier: " + odVarB + " for constructor: " + a91Var);
            }
            vg0VarA = b2.a("member scope for intersection type", (SequencedCollection) ((j30) a91Var).b);
        }
        return g(s4Var, a91Var, list, z, vg0VarA, new ic0(list, a91Var, i));
    }

    public static int f0(ld ldVar, w81 w81Var) {
        if (w81Var instanceof w01) {
            return ldVar.O((jc0) w81Var);
        }
        if (w81Var instanceof x6) {
            return ((x6) w81Var).size();
        }
        StringBuilder sb = new StringBuilder("unknown type argument list type: ");
        sb.append(w81Var);
        h90 h90VarB = ou0.a.b(w81Var.getClass());
        sb.append(", ");
        sb.append(h90VarB);
        throw new IllegalStateException(sb.toString().toString());
    }

    public static final u01 g(s4 s4Var, a91 a91Var, List list, boolean z, vg0 vg0Var, nw nwVar) {
        v01 v01Var = new v01(a91Var, list, z, vg0Var, nwVar);
        return s4Var.isEmpty() ? v01Var : new z3(v01Var, s4Var);
    }

    public static zt g(jc0 jc0Var) {
        if (jc0Var instanceof fc0) {
            cc1 cc1VarO0 = ((fc0) jc0Var).O0();
            if (cc1VarO0 instanceof zt) {
                return (zt) cc1VarO0;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(jc0Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, jc0Var.getClass(), sb));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static md g0(ld ldVar, w01 w01Var) {
        if (w01Var instanceof u01) {
            fc0 fc0Var = (fc0) w01Var;
            return new md(ldVar, new ha1(ak.b(fc0Var.L0(), fc0Var.K0())));
        }
        StringBuilder sbM = e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), sbM));
        return null;
    }

    public static final u01 h(List list, s4 s4Var, vg0 vg0Var, a91 a91Var, boolean z) {
        v01 v01Var = new v01(a91Var, list, z, vg0Var, new ic0(list, a91Var, 0));
        return s4Var.isEmpty() ? v01Var : new z3(v01Var, s4Var);
    }

    public static u01 h(jc0 jc0Var) {
        if (jc0Var instanceof fc0) {
            cc1 cc1VarO0 = ((fc0) jc0Var).O0();
            if (cc1VarO0 instanceof u01) {
                return (u01) cc1VarO0;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(jc0Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, jc0Var.getClass(), sb));
        return null;
    }

    public static Collection h0(b91 b91Var) {
        if (b91Var instanceof a91) {
            return ((a91) b91Var).d();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(b91Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, b91Var.getClass(), sb));
        return null;
    }

    public static da1 i(jc0 jc0Var) {
        if (jc0Var instanceof fc0) {
            return new da1((fc0) jc0Var);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(jc0Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, jc0Var.getClass(), sb));
        return null;
    }

    public static vk0 i0(rb rbVar) {
        if (rbVar instanceof tk0) {
            return ((tk0) rbVar).d;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(rbVar);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, rbVar.getClass(), sb));
        return null;
    }

    public static String j(String str, Object obj) {
        return str + obj;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0148  */
    public static u01 j(w01 w01Var) {
        ArrayList arrayList;
        kc0$a kc0_a = kc0$a.a;
        ib ibVar = ib.b;
        uk0 uk0Var = null;
        if (!(w01Var instanceof u01)) {
            d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ")));
            return null;
        }
        u01 u01Var = (u01) w01Var;
        if (u01Var.K0().size() != u01Var.L0().getParameters().size()) {
            arrayList = null;
        } else {
            List listK0 = u01Var.K0();
            int i = 0;
            boolean z = listK0 != null;
            ad1 ad1Var = ad1.INVARIANT;
            if (z && listK0.isEmpty()) {
                arrayList = null;
            } else {
                Iterator it = listK0.iterator();
                while (it.hasNext()) {
                    if (((ca1) it.next()).c() != ad1Var) {
                        ArrayList<jo0> arrayListK1 = he.k1(listK0, u01Var.L0().getParameters());
                        arrayList = new ArrayList(ae.y0(arrayListK1));
                        for (jo0 jo0Var : arrayListK1) {
                            ca1 da1Var = (ca1) jo0Var.b;
                            v91 v91Var = (v91) jo0Var.c;
                            if (da1Var.c() != ad1Var) {
                                da1Var = new da1(new tk0(ibVar, new vk0(da1Var, uk0Var, v91Var, 6), (da1Var.b() || da1Var.c() != ad1.IN_VARIANCE) ? null : da1Var.getType().O0(), (s4) null, false, 56));
                            }
                            arrayList.add(da1Var);
                        }
                        ha1 ha1Var = new ha1(ak.b(u01Var.L0(), arrayList));
                        int size = listK0.size();
                        while (i < size) {
                            int i2 = i + 1;
                            ca1 ca1Var = (ca1) listK0.get(i);
                            ca1 ca1Var2 = (ca1) arrayList.get(i);
                            if (ca1Var.c() != ad1Var) {
                                List upperBounds = ((v91) u01Var.L0().getParameters().get(i)).getUpperBounds();
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it2 = upperBounds.iterator();
                                while (it2.hasNext()) {
                                    arrayList2.add(kc0_a.b(ha1Var.i((fc0) it2.next(), ad1Var).O0()));
                                }
                                if (!ca1Var.b() && ca1Var.c() == ad1.OUT_VARIANCE) {
                                    arrayList2.add(kc0_a.b(ca1Var.getType().O0()));
                                }
                                vk0 vk0Var = ((tk0) ca1Var2.getType()).d;
                                vk0Var.getClass();
                                vk0Var.b = new uk0(arrayList2, 2);
                            }
                            i = i2;
                        }
                    }
                }
                arrayList = null;
            }
        }
        if (arrayList == null) {
            return null;
        }
        return f(u01Var.getAnnotations(), u01Var.L0(), arrayList, u01Var.M0());
    }

    public static a91 j0(w01 w01Var) {
        if (w01Var instanceof u01) {
            return ((u01) w01Var).L0();
        }
        StringBuilder sbM = e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), sbM));
        return null;
    }

    public static ib k(rb rbVar) {
        if (rbVar instanceof tk0) {
            return ((tk0) rbVar).c;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(rbVar);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, rbVar.getClass(), sb));
        return null;
    }

    public static u01 k0(zt ztVar) {
        if (ztVar != null) {
            return ztVar.d;
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(ztVar);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, ztVar.getClass(), sb));
        return null;
    }

    public static cc1 l(ld ldVar, w01 w01Var, w01 w01Var2) {
        if ((w01Var instanceof u01) && (w01Var2 instanceof u01)) {
            return c((u01) w01Var, (u01) w01Var2);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(ldVar);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, ldVar.getClass(), sb));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ca1 m(ld ldVar, w81 w81Var, int i) {
        if (w81Var instanceof w01) {
            return ldVar.J((jc0) w81Var, i);
        }
        if (w81Var instanceof x6) {
            return (ca1) ((x6) w81Var).get(i);
        }
        StringBuilder sb = new StringBuilder("unknown type argument list type: ");
        sb.append(w81Var);
        h90 h90VarB = ou0.a.b(w81Var.getClass());
        sb.append(", ");
        sb.append(h90VarB);
        throw new IllegalStateException(sb.toString().toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static cc1 m0(ld ldVar, cc1 cc1Var) {
        if (cc1Var instanceof w01) {
            return ldVar.b((w01) cc1Var, true);
        }
        if (cc1Var instanceof zt) {
            zt ztVar = (zt) cc1Var;
            return ldVar.m0(ldVar.b(ldVar.d(ztVar), true), ldVar.b(ldVar.f(ztVar), true));
        }
        d.AnonymousClass0.m("sealed");
        return null;
    }

    public static ca1 n(jc0 jc0Var, int i) {
        if (jc0Var instanceof fc0) {
            return (ca1) ((fc0) jc0Var).K0().get(i);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(jc0Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, jc0Var.getClass(), sb));
        return null;
    }

    public static u01 n0(w01 w01Var, boolean z) {
        if (w01Var instanceof u01) {
            return ((u01) w01Var).P0(z);
        }
        StringBuilder sbM = e.m("ClassicTypeSystemContext couldn't handle: ", w01Var, ", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, w01Var.getClass(), sbM));
        return null;
    }

    public static v91 q(b91 b91Var, int i) {
        if (b91Var instanceof a91) {
            return (v91) ((a91) b91Var).getParameters().get(i);
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(b91Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, b91Var.getClass(), sb));
        return null;
    }

    public static cc1 v(ca1 ca1Var) {
        if (ca1Var != null) {
            return ca1Var.getType().O0();
        }
        StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
        sb.append(ca1Var);
        sb.append(", ");
        d.AnonymousClass0.m((Object) fb$1.m(ou0.a, ca1Var.getClass(), sb));
        return null;
    }

    public static int y(ca1 ca1Var) {
        if (ca1Var == null) {
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(ca1Var);
            sb.append(", ");
            d.AnonymousClass0.m((Object) fb$1.m(ou0.a, ca1Var.getClass(), sb));
            return 0;
        }
        int iOrdinal = ca1Var.c().ordinal();
        if (iOrdinal == 0) {
            return 3;
        }
        if (iOrdinal == 1) {
            return 1;
        }
        if (iOrdinal == 2) {
            return 2;
        }
        d.AnonymousClass0.m();
        return 0;
    }

    public static int z(v91 v91Var) {
        if (v91Var == null) {
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(v91Var);
            sb.append(", ");
            d.AnonymousClass0.m((Object) fb$1.m(ou0.a, v91Var.getClass(), sb));
            return 0;
        }
        int iOrdinal = v91Var.j().ordinal();
        if (iOrdinal == 0) {
            return 3;
        }
        if (iOrdinal == 1) {
            return 1;
        }
        if (iOrdinal == 2) {
            return 2;
        }
        d.AnonymousClass0.m();
        return 0;
    }

    public abstract String a();
}
