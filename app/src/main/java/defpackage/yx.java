package defpackage;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class yx extends b0 implements Serializable {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class a implements Cloneable, oh0 {
        public fa b = fa.b;

        public abstract a b(xd xdVar, ps psVar);

        public abstract b0 build();

        public abstract a e(yx yxVar);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class b extends a implements oh0 {
        public dt c = dt.d;
        public boolean d;

        public final void f(c cVar) {
            l11 l11Var;
            if (!this.d) {
                this.c = this.c.clone();
                this.d = true;
            }
            dt dtVar = this.c;
            dt dtVar2 = cVar.b;
            dtVar.getClass();
            int i = 0;
            while (true) {
                int size = dtVar2.a.c.size();
                l11Var = dtVar2.a;
                if (i >= size) {
                    break;
                }
                dtVar.i((Map.Entry) l11Var.c.get(i));
                i++;
            }
            Iterator it = l11Var.c().iterator();
            while (it.hasNext()) {
                dtVar.i((Map.Entry) it.next());
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class c extends yx {
        public final dt b;

        public c() {
            this.b = new dt();
        }

        public c(b bVar) {
            bVar.c.h();
            bVar.d = false;
            this.b = bVar.c;
        }

        public final boolean e() {
            int i = 0;
            while (true) {
                l11 l11Var = this.b.a;
                if (i >= l11Var.c.size()) {
                    Iterator it = l11Var.c().iterator();
                    while (it.hasNext()) {
                        if (!dt.g((Map.Entry) it.next())) {
                            break;
                        }
                    }
                    return true;
                }
                if (!dt.g((Map.Entry) l11Var.c.get(i))) {
                    break;
                }
                i++;
            }
            return false;
        }

        public final int f() {
            l11 l11Var;
            int i = 0;
            int iE = 0;
            while (true) {
                l11Var = this.b.a;
                if (i >= l11Var.c.size()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) l11Var.c.get(i);
                iE += dt.e((d) entry.getKey(), entry.getValue());
                i++;
            }
            for (Map.Entry entry2 : l11Var.c()) {
                iE += dt.e((d) entry2.getKey(), entry2.getValue());
            }
            return iE;
        }

        public final Object g(e eVar) {
            l(eVar);
            d dVar = eVar.d;
            Object obj = this.b.a.get(dVar);
            if (obj == null) {
                return eVar.b;
            }
            if (!dVar.d) {
                return eVar.a(obj);
            }
            if (dVar.c.b != lg1.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(eVar.a(it.next()));
            }
            return arrayList;
        }

        public final boolean h(e eVar) {
            l(eVar);
            dt dtVar = this.b;
            dtVar.getClass();
            d dVar = eVar.d;
            if (!dVar.d) {
                return dtVar.a.get(dVar) != null;
            }
            defpackage.d.AnonymousClass0.m$2("hasField() can only be called on non-repeated fields.");
            return false;
        }

        public final void i$1() {
            this.b.h();
        }

        /* JADX WARN: Code duplicated, block: B:15:0x003a  */
        public final boolean k(xd xdVar, yd ydVar, ps psVar, int i) throws t30 {
            boolean z;
            boolean z2;
            Object objBuild;
            b0 b0Var;
            b0 defaultInstanceForType = getDefaultInstanceForType();
            int i2 = i & 7;
            psVar.getClass();
            e eVar = (e) psVar.a.get(new ps.a(i >>> 3, defaultInstanceForType));
            if (eVar == null) {
                z = false;
                z2 = true;
            } else {
                d dVar = eVar.d;
                kg1 kg1Var = dVar.c;
                dt dtVar = dt.d;
                if (i2 == kg1Var.c) {
                    z2 = false;
                    z = false;
                } else if (dVar.d && kg1Var.a() && i2 == 2) {
                    z2 = false;
                    z = true;
                } else {
                    z = false;
                    z2 = true;
                }
            }
            if (z2) {
                return xdVar.q(i, ydVar);
            }
            dt dtVar2 = this.b;
            a aVarNewBuilderForType = null;
            if (z) {
                int iD = xdVar.d(xdVar.k());
                d dVar2 = eVar.d;
                if (dVar2.c != kg1.j) {
                    while (xdVar.b() > 0) {
                        dtVar2.a(dVar2, dt.j(xdVar, dVar2.c));
                    }
                } else if (xdVar.b() > 0) {
                    xdVar.k();
                    throw null;
                }
                xdVar.c(iD);
                return true;
            }
            int iOrdinal = eVar.d.c.b.ordinal();
            d dVar3 = eVar.d;
            if (iOrdinal == 7) {
                xdVar.k();
                dVar3.getClass();
                throw null;
            }
            if (iOrdinal != 8) {
                objBuild = dt.j(xdVar, dVar3.c);
            } else {
                if (!dVar3.d && (b0Var = (b0) dtVar2.a.get(dVar3)) != null) {
                    aVarNewBuilderForType = b0Var.toBuilder();
                }
                if (aVarNewBuilderForType == null) {
                    aVarNewBuilderForType = eVar.c.newBuilderForType();
                }
                if (dVar3.c == kg1.g) {
                    int i3 = xdVar.i;
                    if (i3 >= 64) {
                        throw new t30("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
                    }
                    xdVar.i = i3 + 1;
                    aVarNewBuilderForType.b(xdVar, psVar);
                    xdVar.a((dVar3.b << 3) | 4);
                    xdVar.i--;
                } else {
                    int iK = xdVar.k();
                    if (xdVar.i >= 64) {
                        throw new t30("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
                    }
                    int iD2 = xdVar.d(iK);
                    xdVar.i++;
                    aVarNewBuilderForType.b(xdVar, psVar);
                    xdVar.a(0);
                    xdVar.i--;
                    xdVar.c(iD2);
                }
                objBuild = aVarNewBuilderForType.build();
            }
            boolean z3 = dVar3.d;
            if (dVar3.c.b == lg1.ENUM) {
                objBuild = Integer.valueOf(((h30.a) objBuild).getNumber());
            }
            if (z3) {
                dtVar2.a(dVar3, objBuild);
                return true;
            }
            dtVar2.k(dVar3, objBuild);
            return true;
        }

        public final void l(e eVar) {
            if (eVar.a == getDefaultInstanceForType()) {
                return;
            }
            defpackage.d.AnonymousClass0.m$2("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d implements Comparable {
        public final int b;
        public final kg1 c;
        public final boolean d;

        public d(int i, kg1 kg1Var, boolean z) {
            this.b = i;
            this.c = kg1Var;
            this.d = z;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.b - ((d) obj).b;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class e {
        public final c a;
        public final Object b;
        public final yx c;
        public final d d;
        public final Method e;

        public e(c cVar, Object obj, yx yxVar, d dVar, Class cls) {
            Method method = null;
            if (cVar == null) {
                defpackage.d.AnonymousClass0.m$2("Null containingTypeDefaultInstance");
                throw null;
            }
            if (dVar.c == kg1.i && yxVar == null) {
                defpackage.d.AnonymousClass0.m$2("Null messageDefaultInstance");
                throw null;
            }
            this.a = cVar;
            this.b = obj;
            this.c = yxVar;
            this.d = dVar;
            if (h30.a.class.isAssignableFrom(cls)) {
                try {
                    method = cls.getMethod("valueOf", Integer.TYPE);
                } catch (NoSuchMethodException e) {
                    String name = cls.getName();
                    throw new RuntimeException(defpackage.e.c(new StringBuilder(name.length() + 52), "Generated message class \"", name, "\" missing method \"valueOf\"."), e);
                }
            }
            this.e = method;
        }

        public final Object a(Object obj) {
            Throwable e;
            String str;
            if (this.d.c.b == lg1.ENUM) {
                Object[] objArr = {(Integer) obj};
                obj = null;
                try {
                    return this.e.invoke(null, objArr);
                } catch (IllegalAccessException e2) {
                    e = e2;
                    str = "Couldn't use Java reflection to implement protocol message reflection.";
                    defpackage.d.AnonymousClass0.m$1(str, e);
                    return obj;
                } catch (InvocationTargetException e3) {
                    e = e3.getCause();
                    if (e instanceof RuntimeException) {
                        throw ((RuntimeException) e);
                    }
                    if (e instanceof Error) {
                        throw ((Error) e);
                    }
                    str = "Unexpected exception thrown by generated accessor method.";
                    defpackage.d.AnonymousClass0.m$1(str, e);
                    return obj;
                }
            }
            return obj;
        }
    }

    public static e c(c cVar, yx yxVar, int i, kg1.c cVar2, Class cls) {
        return new e(cVar, Collections.EMPTY_LIST, yxVar, new d(i, cVar2, true), cls);
    }

    public static e d(c cVar, Serializable serializable, yx yxVar, int i, kg1 kg1Var, Class cls) {
        return new e(cVar, serializable, yxVar, new d(i, kg1Var, false), cls);
    }
}
