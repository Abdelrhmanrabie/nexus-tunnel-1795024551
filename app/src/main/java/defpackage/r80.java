package defpackage;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class r80 implements jj0 {
    public static final List d;
    public final String[] a;
    public final Set b;
    public final ArrayList c;

    static {
        String strR0 = he.R0(Arrays.asList('k', 'o', 't', 'l', 'i', 'n'), AppConfig.CUSTOM, null, null, null, 62);
        List listAsList = Arrays.asList(e4.j(strR0, "/Any"), e4.j(strR0, "/Nothing"), e4.j(strR0, "/Unit"), e4.j(strR0, "/Throwable"), e4.j(strR0, "/Number"), e4.j(strR0, "/Byte"), e4.j(strR0, "/Double"), e4.j(strR0, "/Float"), e4.j(strR0, "/Int"), e4.j(strR0, "/Long"), e4.j(strR0, "/Short"), e4.j(strR0, "/Boolean"), e4.j(strR0, "/Char"), e4.j(strR0, "/CharSequence"), e4.j(strR0, "/String"), e4.j(strR0, "/Comparable"), e4.j(strR0, "/Enum"), e4.j(strR0, "/Array"), e4.j(strR0, "/ByteArray"), e4.j(strR0, "/DoubleArray"), e4.j(strR0, "/FloatArray"), e4.j(strR0, "/IntArray"), e4.j(strR0, "/LongArray"), e4.j(strR0, "/ShortArray"), e4.j(strR0, "/BooleanArray"), e4.j(strR0, "/CharArray"), e4.j(strR0, "/Cloneable"), e4.j(strR0, "/Annotation"), e4.j(strR0, "/collections/Iterable"), e4.j(strR0, "/collections/MutableIterable"), e4.j(strR0, "/collections/Collection"), e4.j(strR0, "/collections/MutableCollection"), e4.j(strR0, "/collections/List"), e4.j(strR0, "/collections/MutableList"), e4.j(strR0, "/collections/Set"), e4.j(strR0, "/collections/MutableSet"), e4.j(strR0, "/collections/Map"), e4.j(strR0, "/collections/MutableMap"), e4.j(strR0, "/collections/Map.Entry"), e4.j(strR0, "/collections/MutableMap.MutableEntry"), e4.j(strR0, "/collections/Iterator"), e4.j(strR0, "/collections/MutableIterator"), e4.j(strR0, "/collections/ListIterator"), e4.j(strR0, "/collections/MutableListIterator"));
        d = listAsList;
        l7 l7VarJ1 = he.j1(listAsList);
        int iE = ye1.e(ae.y0(l7VarJ1));
        if (iE < 16) {
            iE = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iE);
        Iterator it = l7VarJ1.iterator();
        while (true) {
            c20 c20Var = (c20) it;
            if (!c20Var.b.hasNext()) {
                return;
            }
            a20 a20Var = (a20) c20Var.next();
            linkedHashMap.put((String) a20Var.b, Integer.valueOf(a20Var.a));
        }
    }

    public r80(w80.d dVar, String[] strArr) {
        this.a = strArr;
        List list = dVar.d;
        this.b = list.isEmpty() ? yq.b : he.i1((Iterable) list);
        ArrayList arrayList = new ArrayList();
        List<w80.d.c> list2 = dVar.c;
        arrayList.ensureCapacity(list2.size());
        for (w80.d.c cVar : list2) {
            int i = cVar.d;
            int i2 = 0;
            while (i2 < i) {
                i2++;
                arrayList.add(cVar);
            }
        }
        arrayList.trimToSize();
        this.c = arrayList;
    }

    @Override // defpackage.jj0
    public final boolean a(int i) {
        return this.b.contains(Integer.valueOf(i));
    }

    @Override // defpackage.jj0
    public final String b(int i) {
        return getString(i);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    @Override // defpackage.jj0
    public final String getString(int i) {
        String strSubstring;
        w80.d.c cVar = (w80.d.c) this.c.get(i);
        int i2 = cVar.c;
        if ((i2 & 4) == 4) {
            Object obj = cVar.g;
            if (obj instanceof String) {
                strSubstring = (String) obj;
            } else {
                fa faVar = (fa) obj;
                faVar.getClass();
                try {
                    String strP = faVar.p();
                    if (faVar.j()) {
                        cVar.g = strP;
                    }
                    strSubstring = strP;
                } catch (UnsupportedEncodingException e) {
                    d.AnonymousClass0.m$1("UTF-8 not supported?", (Throwable) e);
                    return null;
                }
            }
        } else if ((i2 & 2) == 2) {
            List list = d;
            int size = list.size();
            int i3 = cVar.f;
            if (i3 < 0 || i3 >= size) {
                strSubstring = this.a[i];
            } else {
                strSubstring = (String) list.get(i3);
            }
        } else {
            strSubstring = this.a[i];
        }
        if (cVar.j.size() >= 2) {
            List list2 = cVar.j;
            Integer num = (Integer) list2.get(0);
            Integer num2 = (Integer) list2.get(1);
            if (num.intValue() >= 0 && num.intValue() <= num2.intValue() && num2.intValue() <= strSubstring.length()) {
                strSubstring = strSubstring.substring(num.intValue(), num2.intValue());
            }
        }
        if (cVar.o.size() >= 2) {
            List list3 = cVar.o;
            strSubstring = strSubstring.replace((char) ((Integer) list3.get(0)).intValue(), (char) ((Integer) list3.get(1)).intValue());
        }
        w80.d.c.EnumC0046c enumC0046c = cVar.i;
        if (enumC0046c == null) {
            enumC0046c = w80.d.c.EnumC0046c.c;
        }
        int iOrdinal = enumC0046c.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                return strSubstring;
            }
            if (strSubstring.length() >= 2) {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
            }
        }
        return strSubstring.replace('$', '.');
    }
}
