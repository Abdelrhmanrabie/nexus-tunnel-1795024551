package defpackage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class m21 {
    public static final ij0 a = ij0.f("values");
    public static final ij0 b = ij0.f("valueOf");
    public static final cv c;
    public static final cv d;
    public static final cv e;
    public static final cv f;
    public static final List g;
    public static final ij0 h;
    public static final cv i;
    public static final cv j;
    public static final cv k;
    public static final cv l;
    public static final Set m;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class a {
        public static final cv A;
        public static final cv B;
        public static final cv C;
        public static final cv D;
        public static final cv E;
        public static final cv F;
        public static final cv G;
        public static final cv H;
        public static final cv I;
        public static final cv J;
        public static final cv K;
        public static final cv L;
        public static final cv M;
        public static final cv N;
        public static final dv O;
        public static final dd P;
        public static final dd Q;
        public static final dd R;
        public static final dd S;
        public static final dd T;
        public static final cv U;
        public static final cv V;
        public static final cv W;
        public static final cv X;
        public static final HashSet Y;
        public static final HashSet Z;
        public static final HashMap a0;
        public static final HashMap b0;
        public static final dv d;
        public static final dv e;
        public static final dv f;
        public static final dv g;
        public static final dv h;
        public static final dv i;
        public static final dv j;
        public static final cv k;
        public static final cv l;
        public static final cv m;
        public static final cv n;
        public static final cv o;
        public static final cv p;
        public static final cv q;
        public static final cv r;
        public static final cv s;
        public static final cv t;
        public static final cv u;
        public static final cv v;
        public static final cv w;
        public static final cv x;
        public static final cv y;
        public static final cv z;
        public static final dv a = d("Any");
        public static final dv b = d("Nothing");
        public static final dv c = d("Cloneable");

        static {
            c("Suppress");
            d = d("Unit");
            e = d("CharSequence");
            f = d("String");
            g = d("Array");
            h = d("Boolean");
            d("Char");
            d("Byte");
            d("Short");
            d("Int");
            d("Long");
            d("Float");
            d("Double");
            i = d("Number");
            j = d("Enum");
            d("Function");
            k = c("Throwable");
            l = c("Comparable");
            cv cvVar = m21.l;
            cvVar.c(ij0.f("IntRange")).i();
            cvVar.c(ij0.f("LongRange")).i();
            m = c("Deprecated");
            c("DeprecatedSinceKotlin");
            n = c("DeprecationLevel");
            o = c("ReplaceWith");
            p = c("ExtensionFunctionType");
            q = c("ParameterName");
            r = c("Annotation");
            s = a("Target");
            t = a("AnnotationTarget");
            u = a("AnnotationRetention");
            v = a("Retention");
            a("Repeatable");
            w = a("MustBeDocumented");
            x = c("UnsafeVariance");
            c("PublishedApi");
            y = b("Iterator");
            z = b("Iterable");
            A = b("Collection");
            B = b("List");
            C = b("ListIterator");
            D = b("Set");
            cv cvVarB = b("Map");
            E = cvVarB;
            F = cvVarB.c(ij0.f("Entry"));
            G = b("MutableIterator");
            H = b("MutableIterable");
            I = b("MutableCollection");
            J = b("MutableList");
            K = b("MutableListIterator");
            L = b("MutableSet");
            cv cvVarB2 = b("MutableMap");
            M = cvVarB2;
            N = cvVarB2.c(ij0.f("MutableEntry"));
            O = e("KClass");
            e("KCallable");
            e("KProperty0");
            e("KProperty1");
            e("KProperty2");
            e("KMutableProperty0");
            e("KMutableProperty1");
            e("KMutableProperty2");
            dv dvVarE = e("KProperty");
            e("KMutableProperty");
            P = dd.l(dvVarE.h());
            e("KDeclarationContainer");
            cv cvVarC = c("UByte");
            cv cvVarC2 = c("UShort");
            cv cvVarC3 = c("UInt");
            cv cvVarC4 = c("ULong");
            Q = dd.l(cvVarC);
            R = dd.l(cvVarC2);
            S = dd.l(cvVarC3);
            T = dd.l(cvVarC4);
            U = c("UByteArray");
            V = c("UShortArray");
            W = c("UIntArray");
            X = c("ULongArray");
            int length = wp0.values().length;
            HashSet hashSet = new HashSet(length < 3 ? 3 : (length / 3) + length + 1);
            wp0[] wp0VarArrValues = wp0.values();
            int length2 = wp0VarArrValues.length;
            int i2 = 0;
            int i3 = 0;
            while (i3 < length2) {
                wp0 wp0Var = wp0VarArrValues[i3];
                i3++;
                hashSet.add(wp0Var.b);
            }
            Y = hashSet;
            int length3 = wp0.values().length;
            HashSet hashSet2 = new HashSet(length3 < 3 ? 3 : (length3 / 3) + length3 + 1);
            wp0[] wp0VarArrValues2 = wp0.values();
            int length4 = wp0VarArrValues2.length;
            int i4 = 0;
            while (i4 < length4) {
                wp0 wp0Var2 = wp0VarArrValues2[i4];
                i4++;
                hashSet2.add(wp0Var2.c);
            }
            Z = hashSet2;
            int length5 = wp0.values().length;
            HashMap map = new HashMap(length5 < 3 ? 3 : (length5 / 3) + length5 + 1);
            wp0[] wp0VarArrValues3 = wp0.values();
            int length6 = wp0VarArrValues3.length;
            int i5 = 0;
            while (i5 < length6) {
                wp0 wp0Var3 = wp0VarArrValues3[i5];
                i5++;
                map.put(d(wp0Var3.b.b()), wp0Var3);
            }
            a0 = map;
            int length7 = wp0.values().length;
            HashMap map2 = new HashMap(length7 >= 3 ? (length7 / 3) + length7 + 1 : 3);
            wp0[] wp0VarArrValues4 = wp0.values();
            int length8 = wp0VarArrValues4.length;
            while (i2 < length8) {
                wp0 wp0Var4 = wp0VarArrValues4[i2];
                i2++;
                map2.put(d(wp0Var4.c.b()), wp0Var4);
            }
            b0 = map2;
        }

        public static cv a(String str) {
            return m21.j.c(ij0.f(str));
        }

        public static cv b(String str) {
            return m21.k.c(ij0.f(str));
        }

        public static cv c(String str) {
            return m21.i.c(ij0.f(str));
        }

        public static dv d(String str) {
            return c(str).i();
        }

        public static final dv e(String str) {
            return m21.f.c(ij0.f(str)).i();
        }
    }

    static {
        ij0.f("code");
        cv cvVar = new cv("kotlin.coroutines");
        c = cvVar;
        new cv("kotlin.coroutines.jvm.internal");
        new cv("kotlin.coroutines.intrinsics");
        d = cvVar.c(ij0.f("Continuation"));
        e = new cv("kotlin.Result");
        cv cvVar2 = new cv("kotlin.reflect");
        f = cvVar2;
        g = Arrays.asList("KProperty", "KMutableProperty", "KFunction", "KSuspendFunction");
        ij0 ij0VarF = ij0.f("kotlin");
        h = ij0VarF;
        cv cvVarJ = cv.j(ij0VarF);
        i = cvVarJ;
        cv cvVarC = cvVarJ.c(ij0.f("annotation"));
        j = cvVarC;
        cv cvVarC2 = cvVarJ.c(ij0.f("collections"));
        k = cvVarC2;
        cv cvVarC3 = cvVarJ.c(ij0.f("ranges"));
        l = cvVarC3;
        cvVarJ.c(ij0.f("text"));
        m = ae.O0(new cv[]{cvVarJ, cvVarC2, cvVarC3, cvVarC, cvVar2, cvVarJ.c(ij0.f("internal")), cvVar});
    }
}
