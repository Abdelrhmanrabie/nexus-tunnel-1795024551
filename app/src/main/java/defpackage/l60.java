package defpackage;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class l60 {
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final dd e;
    public static final cv f;
    public static final dd g;
    public static final HashMap h;
    public static final HashMap i;
    public static final HashMap j;
    public static final HashMap k;
    public static final List l;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final dd a;
        public final dd b;
        public final dd c;

        public a(dd ddVar, dd ddVar2, dd ddVar3) {
            this.a = ddVar;
            this.b = ddVar2;
            this.c = ddVar3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a.equals(aVar.a) && this.b.equals(aVar.b) && this.c.equals(aVar.c);
        }

        public final int hashCode() {
            return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
        }

        public final String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.a + ", kotlinReadOnly=" + this.b + ", kotlinMutable=" + this.c + ')';
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        mx mxVar = mx.f;
        sb.append(mxVar.b.a.toString());
        sb.append('.');
        sb.append(mxVar.c);
        a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        mx mxVar2 = mx.i;
        sb2.append(mxVar2.b.a.toString());
        sb2.append('.');
        sb2.append(mxVar2.c);
        b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        mx mxVar3 = mx.g;
        sb3.append(mxVar3.b.a.toString());
        sb3.append('.');
        sb3.append(mxVar3.c);
        c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        mx mxVar4 = mx.j;
        sb4.append(mxVar4.b.a.toString());
        sb4.append('.');
        sb4.append(mxVar4.c);
        d = sb4.toString();
        dd ddVarL = dd.l(new cv("kotlin.jvm.functions.FunctionN"));
        e = ddVarL;
        f = ddVarL.b();
        g = dd.l(new cv("kotlin.reflect.KFunction"));
        dd.l(new cv("kotlin.reflect.KClass"));
        d(Class.class);
        h = new HashMap();
        i = new HashMap();
        j = new HashMap();
        k = new HashMap();
        dd ddVarL2 = dd.l(m21.a.z);
        a aVar = new a(d(Iterable.class), ddVarL2, new dd(ddVarL2.h(), e.P(m21.a.H, ddVarL2.h()), false));
        dd ddVarL3 = dd.l(m21.a.y);
        a aVar2 = new a(d(Iterator.class), ddVarL3, new dd(ddVarL3.h(), e.P(m21.a.G, ddVarL3.h()), false));
        dd ddVarL4 = dd.l(m21.a.A);
        a aVar3 = new a(d(Collection.class), ddVarL4, new dd(ddVarL4.h(), e.P(m21.a.I, ddVarL4.h()), false));
        dd ddVarL5 = dd.l(m21.a.B);
        a aVar4 = new a(d(List.class), ddVarL5, new dd(ddVarL5.h(), e.P(m21.a.J, ddVarL5.h()), false));
        dd ddVarL6 = dd.l(m21.a.D);
        a aVar5 = new a(d(Set.class), ddVarL6, new dd(ddVarL6.h(), e.P(m21.a.L, ddVarL6.h()), false));
        dd ddVarL7 = dd.l(m21.a.C);
        a aVar6 = new a(d(ListIterator.class), ddVarL7, new dd(ddVarL7.h(), e.P(m21.a.K, ddVarL7.h()), false));
        cv cvVar = m21.a.E;
        dd ddVarL8 = dd.l(cvVar);
        a aVar7 = new a(d(Map.class), ddVarL8, new dd(ddVarL8.h(), e.P(m21.a.M, ddVarL8.h()), false));
        dd ddVarD = dd.l(cvVar).d(m21.a.F.a.g());
        List<a> listAsList = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, new a(d(Map.Entry.class), ddVarD, new dd(ddVarD.h(), e.P(m21.a.N, ddVarD.h()), false)));
        l = listAsList;
        c(Object.class, m21.a.a);
        c(String.class, m21.a.f);
        c(CharSequence.class, m21.a.e);
        a(d(Throwable.class), dd.l(m21.a.k));
        c(Cloneable.class, m21.a.c);
        c(Number.class, m21.a.i);
        a(d(Comparable.class), dd.l(m21.a.l));
        c(Enum.class, m21.a.j);
        a(d(Annotation.class), dd.l(m21.a.r));
        for (a aVar8 : listAsList) {
            dd ddVar = aVar8.a;
            dd ddVar2 = aVar8.b;
            a(ddVar, ddVar2);
            dd ddVar3 = aVar8.c;
            i.put(ddVar3.b().i(), ddVar);
            cv cvVarB = ddVar2.b();
            cv cvVarB2 = ddVar3.b();
            j.put(ddVar3.b().i(), cvVarB);
            k.put(cvVarB.i(), cvVarB2);
        }
        u80[] u80VarArrValues = u80.values();
        int length = u80VarArrValues.length;
        int i2 = 0;
        while (i2 < length) {
            u80 u80Var = u80VarArrValues[i2];
            i2++;
            a(dd.l(u80Var.f()), dd.l(m21.i.c(u80Var.d().b)));
        }
        for (dd ddVar4 : me.a) {
            a(dd.l(new cv("kotlin.jvm.internal." + ddVar4.j().b() + "CompanionObject")), ddVar4.d(f21.b));
        }
        for (int i3 = 0; i3 < 23; i3++) {
            a(dd.l(new cv(e4.j("kotlin.jvm.functions.Function", Integer.valueOf(i3)))), new dd(m21.i, ij0.f(e4.j("Function", Integer.valueOf(i3)))));
            i.put(new cv(e4.j(b, Integer.valueOf(i3))).i(), g);
        }
        for (int i4 = 0; i4 < 22; i4++) {
            mx mxVar5 = mx.j;
            i.put(new cv(e4.j(mxVar5.b.a.toString() + '.' + mxVar5.c, Integer.valueOf(i4))).i(), g);
        }
        i.put(m21.a.b.h().i(), d(Void.class));
    }

    public static void a(dd ddVar, dd ddVar2) {
        h.put(ddVar.b().i(), ddVar2);
        i.put(ddVar2.b().i(), ddVar);
    }

    public static void c(Class cls, dv dvVar) {
        a(d(cls), dd.l(dvVar.h()));
    }

    public static dd d(Class cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        return declaringClass == null ? dd.l(new cv(cls.getCanonicalName())) : d(declaringClass).d(ij0.f(cls.getSimpleName()));
    }

    public static boolean e(dv dvVar, String str) {
        Integer numU;
        String str2 = dvVar.a;
        if (str2 != null) {
            String strW0 = q31.w0(str2, str, AppConfig.CUSTOM);
            return strW0.length() > 0 && (strW0.length() <= 0 || !e.h(strW0.charAt(0), '0', false)) && (numU = q31.U(strW0)) != null && numU.intValue() >= 23;
        }
        dv.a(4);
        throw null;
    }

    public static dd g(dv dvVar) {
        if (e(dvVar, a) || e(dvVar, c)) {
            return e;
        }
        return (e(dvVar, b) || e(dvVar, d)) ? g : (dd) i.get(dvVar);
    }
}
