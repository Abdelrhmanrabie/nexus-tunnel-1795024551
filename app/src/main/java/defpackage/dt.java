package defpackage;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dt {
    public static final dt d = new dt(0);
    public final l11 a = new l11(16);
    public boolean b;

    public dt() {
    }

    public dt(int i) {
        h();
    }

    public static int d(kg1 kg1Var, Object obj) {
        Object obj2;
        Object obj3;
        int serializedSize;
        int iF;
        switch (kg1Var.ordinal()) {
            case 0:
                obj2 = (Double) obj;
                obj2.getClass();
                return 8;
            case 1:
                obj3 = (Float) obj;
                obj3.getClass();
                return 4;
            case 2:
                return yd.g(((Long) obj).longValue());
            case 3:
                return yd.g(((Long) obj).longValue());
            case 4:
                return yd.c(((Integer) obj).intValue());
            case 5:
            case 15:
                obj2 = (Long) obj;
                obj2.getClass();
                return 8;
            case 6:
            case 14:
                obj3 = (Integer) obj;
                obj3.getClass();
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                return 1;
            case 8:
                try {
                    byte[] bytes = ((String) obj).getBytes("UTF-8");
                    return yd.f(bytes.length) + bytes.length;
                } catch (UnsupportedEncodingException e) {
                    d.AnonymousClass0.m$1("UTF-8 not supported.", (Throwable) e);
                    return 0;
                }
            case 9:
                return ((b0) obj).getSerializedSize();
            case 10:
                serializedSize = ((b0) obj).getSerializedSize();
                iF = yd.f(serializedSize);
                return iF + serializedSize;
            case 11:
                if (!(obj instanceof fa)) {
                    byte[] bArr = (byte[]) obj;
                    return yd.f(bArr.length) + bArr.length;
                }
                fa faVar = (fa) obj;
                serializedSize = yd.f(faVar.size());
                iF = faVar.size();
                return iF + serializedSize;
            case 12:
                return yd.f(((Integer) obj).intValue());
            case 13:
                return obj instanceof h30.a ? yd.c(((h30.a) obj).getNumber()) : yd.c(((Integer) obj).intValue());
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return yd.f((iIntValue >> 31) ^ (iIntValue << 1));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return yd.g((jLongValue >> 63) ^ (jLongValue << 1));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int e(yx.d dVar, Object obj) {
        kg1 kg1Var = dVar.c;
        int i = dVar.b;
        if (!dVar.d) {
            int iH = yd.h(i);
            if (kg1Var == kg1.g) {
                iH *= 2;
            }
            return d(kg1Var, obj) + iH;
        }
        int iD = 0;
        for (Object obj2 : (List) obj) {
            int iH2 = yd.h(i);
            if (kg1Var == kg1.g) {
                iH2 *= 2;
            }
            iD += d(kg1Var, obj2) + iH2;
        }
        return iD;
    }

    public static boolean g(Map.Entry entry) {
        yx.d dVar = (yx.d) entry.getKey();
        if (dVar.c.b != lg1.MESSAGE) {
            return true;
        }
        boolean z = dVar.d;
        Object value = entry.getValue();
        if (z) {
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                if (!((b0) it.next()).isInitialized()) {
                }
            }
            return true;
        }
        if (!(value instanceof b0)) {
            d.AnonymousClass0.m$2("Wrong object type used with protocol message reflection.");
            return false;
        }
        if (((b0) value).isInitialized()) {
            return true;
        }
        return false;
    }

    public static Object j(xd xdVar, kg1 kg1Var) {
        switch (kg1Var.ordinal()) {
            case 0:
                return Double.valueOf(Double.longBitsToDouble(xdVar.j()));
            case 1:
                return Float.valueOf(Float.intBitsToFloat(xdVar.i()));
            case 2:
                return Long.valueOf(xdVar.l());
            case 3:
                return Long.valueOf(xdVar.l());
            case 4:
                return Integer.valueOf(xdVar.k());
            case 5:
                return Long.valueOf(xdVar.j());
            case 6:
                return Integer.valueOf(xdVar.i());
            case 7:
                return Boolean.valueOf(xdVar.l() != 0);
            case 8:
                int iK = xdVar.k();
                int i = xdVar.b;
                int i2 = xdVar.d;
                if (iK > i - i2 || iK <= 0) {
                    return iK == 0 ? AppConfig.CUSTOM : new String(xdVar.h(iK), "UTF-8");
                }
                String str = new String(xdVar.a, i2, iK, "UTF-8");
                xdVar.d += iK;
                return str;
            case 9:
                d.AnonymousClass0.m$2("readPrimitiveField() cannot handle nested groups.");
                return null;
            case 10:
                d.AnonymousClass0.m$2("readPrimitiveField() cannot handle embedded messages.");
                return null;
            case 11:
                return xdVar.e();
            case 12:
                return Integer.valueOf(xdVar.k());
            case 13:
                d.AnonymousClass0.m$2("readPrimitiveField() cannot handle enums.");
                return null;
            case 14:
                return Integer.valueOf(xdVar.i());
            case 15:
                return Long.valueOf(xdVar.j());
            case 16:
                int iK2 = xdVar.k();
                return Integer.valueOf((-(iK2 & 1)) ^ (iK2 >>> 1));
            case 17:
                long jL = xdVar.l();
                return Long.valueOf((-(jL & 1)) ^ (jL >>> 1));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0024  */
    /* JADX WARN: Code duplicated, block: B:19:0x0026  */
    public static void l(kg1 kg1Var, Object obj) {
        boolean z;
        obj.getClass();
        switch (kg1Var.b) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if ((obj instanceof fa) || (obj instanceof byte[])) {
                    z = true;
                } else {
                    z = false;
                }
                break;
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof h30.a)) {
                    z = true;
                } else {
                    z = false;
                }
                break;
            case MESSAGE:
                if (!(obj instanceof b0)) {
                    z = false;
                } else {
                    z = true;
                }
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            return;
        }
        d.AnonymousClass0.m$2("Wrong object type used with protocol message reflection.");
    }

    public final void a(yx.d dVar, Object obj) {
        List arrayList;
        if (!dVar.d) {
            d.AnonymousClass0.m$2("addRepeatedField() can only be called on repeated fields.");
            return;
        }
        l(dVar.c, obj);
        l11 l11Var = this.a;
        Object obj2 = l11Var.get(dVar);
        if (obj2 == null) {
            arrayList = new ArrayList();
            l11Var.put(dVar, arrayList);
        } else {
            arrayList = (List) obj2;
        }
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final dt clone() {
        l11 l11Var;
        dt dtVar = new dt();
        int i = 0;
        while (true) {
            l11Var = this.a;
            if (i >= l11Var.c.size()) {
                break;
            }
            Map.Entry entry = (Map.Entry) l11Var.c.get(i);
            dtVar.k((yx.d) entry.getKey(), entry.getValue());
            i++;
        }
        for (Map.Entry entry2 : l11Var.c()) {
            dtVar.k((yx.d) entry2.getKey(), entry2.getValue());
        }
        return dtVar;
    }

    public final void h() {
        if (this.b) {
            return;
        }
        l11 l11Var = this.a;
        if (!l11Var.f) {
            for (int i = 0; i < l11Var.c.size(); i++) {
                Map.Entry entry = (Map.Entry) l11Var.c.get(i);
                if (((yx.d) entry.getKey()).d) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
            for (Map.Entry entry2 : l11Var.c()) {
                if (((yx.d) entry2.getKey()).d) {
                    entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                }
            }
        }
        if (!l11Var.f) {
            l11Var.d = l11Var.d.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(l11Var.d);
            l11Var.f = true;
        }
        this.b = true;
    }

    public final void i(Map.Entry entry) {
        Object obj;
        yx.d dVar = (yx.d) entry.getKey();
        Object value = entry.getValue();
        boolean z = dVar.d;
        l11 l11Var = this.a;
        if (!z) {
            if (dVar.c.b == lg1.MESSAGE && (obj = l11Var.get(dVar)) != null) {
                value = ((b0) obj).toBuilder().e((yx) ((b0) value)).build();
            } else if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                byte[] bArr2 = new byte[bArr.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                value = bArr2;
            }
            l11Var.put(dVar, value);
            return;
        }
        Object arrayList = l11Var.get(dVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        for (Object obj2 : (List) value) {
            List list = (List) arrayList;
            if (obj2 instanceof byte[]) {
                byte[] bArr3 = (byte[]) obj2;
                byte[] bArr4 = new byte[bArr3.length];
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                obj2 = bArr4;
            }
            list.add(obj2);
        }
        l11Var.put(dVar, arrayList);
    }

    public final void k(yx.d dVar, Object obj) {
        boolean z = dVar.d;
        kg1 kg1Var = dVar.c;
        if (!z) {
            l(kg1Var, obj);
        } else {
            if (!(obj instanceof List)) {
                d.AnonymousClass0.m$2("Wrong object type used with protocol message reflection.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                l(kg1Var, it.next());
            }
            obj = arrayList;
        }
        this.a.put(dVar, obj);
    }
}
