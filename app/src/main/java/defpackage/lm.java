package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lm {
    public static final ke c = new ke(6);
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final lm m;
    public static final lm n;
    public static final lm o;
    public static final lm p;
    public static final lm q;
    public static final ArrayList r;
    public static final ArrayList s;
    public final List a;
    public final int b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final int a;
        public final String b;

        public a(int i, String str) {
            this.a = i;
            this.b = str;
        }
    }

    static {
        int i2 = d;
        int i3 = i2 << 1;
        e = i2;
        int i4 = i2 << 2;
        f = i3;
        int i5 = i2 << 3;
        g = i4;
        int i6 = i2 << 4;
        h = i5;
        int i7 = i2 << 5;
        i = i6;
        j = i7;
        d = i2 << 7;
        int i8 = (i2 << 6) - 1;
        k = i8;
        int i9 = i2 | i3 | i4;
        l = i9;
        m = new lm(i8);
        n = new lm(i6 | i7);
        new lm(i2);
        new lm(i3);
        new lm(i4);
        o = new lm(i9);
        new lm(i5);
        p = new lm(i6);
        q = new lm(i7);
        new lm(i3 | i6 | i7);
        Field[] fields = lm.class.getFields();
        ArrayList arrayList = new ArrayList();
        int length = fields.length;
        int i10 = 0;
        int i11 = 0;
        while (i11 < length) {
            Field field = fields[i11];
            i11++;
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Field field2 = (Field) it.next();
            Object obj = field2.get(null);
            lm lmVar = obj instanceof lm ? (lm) obj : null;
            a aVar = lmVar != null ? new a(lmVar.b, field2.getName()) : null;
            if (aVar != null) {
                arrayList2.add(aVar);
            }
        }
        r = arrayList2;
        Field[] fields2 = lm.class.getFields();
        ArrayList arrayList3 = new ArrayList();
        int length2 = fields2.length;
        while (i10 < length2) {
            Field field3 = fields2[i10];
            i10++;
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (e4.a(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            if (obj3 == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type kotlin.Int");
                return;
            }
            int iIntValue = ((Integer) obj3).intValue();
            a aVar2 = iIntValue == ((-iIntValue) & iIntValue) ? new a(iIntValue, field4.getName()) : null;
            if (aVar2 != null) {
                arrayList5.add(aVar2);
            }
        }
        s = arrayList5;
    }

    public /* synthetic */ lm(int i2) {
        this(uq.b, i2);
    }

    public lm(List list, int i2) {
        this.a = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i2 &= ~((km) it.next()).a();
        }
        this.b = i2;
    }

    public final boolean a(int i2) {
        return (i2 & this.b) != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (lm.class.equals(obj == null ? null : obj.getClass())) {
            if (obj == null) {
                d.AnonymousClass0.m$1("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
                return false;
            }
            lm lmVar = (lm) obj;
            if (e4.a(this.a, lmVar.a) && this.b == lmVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        Object next;
        Iterator it = r.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((a) next).a != this.b);
        a aVar = (a) next;
        String strR0 = aVar == null ? null : aVar.b;
        if (strR0 == null) {
            ArrayList arrayList = new ArrayList();
            for (a aVar2 : s) {
                String str = a(aVar2.a) ? aVar2.b : null;
                if (str != null) {
                    arrayList.add(str);
                }
            }
            strR0 = he.R0(arrayList, " | ", null, null, null, 62);
        }
        StringBuilder sbQ = ak.q("DescriptorKindFilter(", strR0, ", ");
        sbQ.append(this.a);
        sbQ.append(')');
        return sbQ.toString();
    }
}
