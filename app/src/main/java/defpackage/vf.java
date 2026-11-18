package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vf implements wo {
    public final /* synthetic */ int b;
    public volatile boolean c;
    public Object d;

    @Override // defpackage.wo
    public final void a() {
        if (this.b != 0) {
            f();
            return;
        }
        if (this.c) {
            return;
        }
        synchronized (this) {
            try {
                if (this.c) {
                    return;
                }
                this.c = true;
                in0 in0Var = (in0) this.d;
                ArrayList arrayList = null;
                this.d = null;
                if (in0Var == null) {
                    return;
                }
                for (Object obj : in0Var.d) {
                    if (obj instanceof wo) {
                        try {
                            ((wo) obj).a();
                        } catch (Throwable th) {
                            e.r(th);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(th);
                        }
                    }
                }
                if (arrayList != null) {
                    if (arrayList.size() != 1) {
                        throw new wf(arrayList);
                    }
                    throw xr.a((Throwable) arrayList.get(0));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean b(wo woVar) {
        in0 in0Var;
        Object obj;
        int i;
        Object obj2;
        if (this.b != 0) {
            return e(woVar);
        }
        if (this.c) {
            return false;
        }
        synchronized (this) {
            try {
                if (!this.c && (in0Var = (in0) this.d) != null) {
                    Object[] objArr = in0Var.d;
                    int i2 = in0Var.a;
                    int iHashCode = woVar.hashCode() * (-1640531527);
                    int i3 = (iHashCode ^ (iHashCode >>> 16)) & i2;
                    Object obj3 = objArr[i3];
                    if (obj3 != null) {
                        if (!obj3.equals(woVar)) {
                            do {
                                i3 = (i3 + 1) & i2;
                                obj = objArr[i3];
                                if (obj == null) {
                                }
                            } while (!obj.equals(woVar));
                        }
                        in0Var.b--;
                        while (true) {
                            int i4 = i3 + 1;
                            while (true) {
                                i = i4 & i2;
                                obj2 = objArr[i];
                                if (obj2 != null) {
                                    int iHashCode2 = obj2.hashCode() * (-1640531527);
                                    int i5 = (iHashCode2 ^ (iHashCode2 >>> 16)) & i2;
                                    if (i3 > i) {
                                        if (i3 >= i5 && i5 > i) {
                                            break;
                                        }
                                        i4 = i + 1;
                                    } else {
                                        if (i3 >= i5 || i5 > i) {
                                            break;
                                            break;
                                        }
                                        i4 = i + 1;
                                    }
                                } else {
                                    objArr[i3] = null;
                                    return true;
                                }
                            }
                            objArr[i3] = obj2;
                            i3 = i;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d(wo woVar) {
        if (!this.c) {
            synchronized (this) {
                try {
                    if (!this.c) {
                        List linkedList = (List) this.d;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.d = linkedList;
                        }
                        linkedList.add(woVar);
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        woVar.a();
        return false;
    }

    public final boolean e(wo woVar) {
        List list;
        if (this.c) {
            return false;
        }
        synchronized (this) {
            try {
                if (!this.c && (list = (List) this.d) != null && list.remove(woVar)) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        if (this.c) {
            return;
        }
        synchronized (this) {
            try {
                if (this.c) {
                    return;
                }
                this.c = true;
                List list = (List) this.d;
                ArrayList arrayList = null;
                this.d = null;
                if (list == null) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    try {
                        ((wo) it.next()).a();
                    } catch (Throwable th) {
                        e.r(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
                if (arrayList != null) {
                    if (arrayList.size() != 1) {
                        throw new wf(arrayList);
                    }
                    throw xr.a((Throwable) arrayList.get(0));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
