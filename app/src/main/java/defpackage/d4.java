package defpackage;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.openvpn.ovpn3.XMLRPC;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d4 implements ta {
    public final Class a;
    public final ArrayList b;
    public final int c;
    public final List d;
    public final ArrayList e;
    public final ArrayList f;
    public final ArrayList g;

    public d4(Class cls, ArrayList arrayList, int i, List list) {
        boolean z;
        ak.r(2, "callMode");
        ak.r(i, "origin");
        this.a = cls;
        this.b = arrayList;
        this.c = 2;
        this.d = list;
        ArrayList arrayList2 = new ArrayList(ae.y0(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Method) it.next()).getGenericReturnType());
        }
        this.e = arrayList2;
        List list2 = this.d;
        ArrayList arrayList3 = new ArrayList(ae.y0(list2));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            Class<?> cls2 = (Class) bt0.c.get(returnType);
            if (cls2 != null) {
                returnType = cls2;
            }
            arrayList3.add(returnType);
        }
        this.f = arrayList3;
        List list3 = this.d;
        ArrayList arrayList4 = new ArrayList(ae.y0(list3));
        Iterator it3 = list3.iterator();
        while (it3.hasNext()) {
            arrayList4.add(((Method) it3.next()).getDefaultValue());
        }
        this.g = arrayList4;
        if (this.c == 2 && i == 1) {
            ArrayList arrayList5 = this.b;
            ArrayList arrayList6 = new ArrayList(ae.y0(arrayList5));
            boolean z2 = false;
            for (Object obj : arrayList5) {
                if (z2 || !e4.a(obj, XMLRPC.TAG_VALUE)) {
                    z = true;
                } else {
                    z2 = true;
                    z = false;
                }
                if (z) {
                    arrayList6.add(obj);
                }
            }
            if (arrayList6.isEmpty()) {
                return;
            }
            d.AnonymousClass0.m$3("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
            throw null;
        }
    }

    @Override // defpackage.ta
    public final List a() {
        return this.e;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:36:0x008f A[PHI: r17
      0x008f: PHI (r17v1 java.lang.Object) = (r17v0 java.lang.Object), (r17v5 java.lang.Object) binds: [B:21:0x0051, B:34:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.ta
    public final Object call(Object[] objArr) {
        Object obj;
        String strE;
        b2.a(this, objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            ArrayList arrayList2 = this.b;
            if (i >= length) {
                return e4.a(this.a, ye1.j(he.k1(arrayList2, arrayList)), this.d);
            }
            Object array = objArr[i];
            i++;
            int i3 = i2 + 1;
            ArrayList arrayList3 = this.f;
            if (array == null && this.c == 1) {
                array = this.g.get(i2);
            } else {
                Class cls = (Class) arrayList3.get(i2);
                if (array instanceof Class) {
                    obj = null;
                    array = obj;
                } else {
                    if (array instanceof h90) {
                        array = ((sc) ((h90) array)).d();
                    } else {
                        if (array instanceof Object[]) {
                            Object[] objArr2 = (Object[]) array;
                            if (objArr2 instanceof Class[]) {
                                obj = null;
                            } else if (objArr2 instanceof h90[]) {
                                h90[] h90VarArr = (h90[]) array;
                                ArrayList arrayList4 = new ArrayList(h90VarArr.length);
                                int length2 = h90VarArr.length;
                                int i4 = 0;
                                while (i4 < length2) {
                                    h90 h90Var = h90VarArr[i4];
                                    i4++;
                                    arrayList4.add(((sc) h90Var).d());
                                }
                                obj = null;
                                array = arrayList4.toArray(new Class[0]);
                                if (array == null) {
                                    d.AnonymousClass0.m$1("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                    return null;
                                }
                            } else {
                                obj = null;
                                array = objArr2;
                            }
                            array = obj;
                        }
                        if (!cls.isInstance(array)) {
                            array = obj;
                        }
                    }
                    obj = null;
                    if (!cls.isInstance(array)) {
                        array = obj;
                    }
                }
            }
            if (array == null) {
                String str = (String) arrayList2.get(i2);
                Class cls2 = (Class) arrayList3.get(i2);
                if (e4.a(cls2, Class.class)) {
                    cls2 = h90.class;
                } else if (cls2.isArray() && e4.a(cls2.getComponentType(), Class.class)) {
                    cls2 = h90[].class;
                }
                pu0 pu0Var = ou0.a;
                h90 h90VarB = pu0Var.b(cls2);
                if (e4.a(h90VarB.e(), pu0Var.b(Object[].class).e())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((Object) h90VarB.e());
                    sb.append('<');
                    sb.append((Object) pu0Var.b(((sc) h90VarB).d().getComponentType()).e());
                    sb.append('>');
                    strE = sb.toString();
                } else {
                    strE = h90VarB.e();
                }
                throw new IllegalArgumentException("Argument #" + i2 + ' ' + str + " is not of the required type " + ((Object) strE));
            }
            arrayList.add(array);
            i2 = i3;
        }
    }

    @Override // defpackage.ta
    public final Type getReturnType() {
        return this.a;
    }
}
