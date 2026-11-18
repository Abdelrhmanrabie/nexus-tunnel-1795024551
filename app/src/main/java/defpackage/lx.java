package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class lx extends k {
    public static final dd r = new dd(m21.i, ij0.f("Function"));
    public static final dd s = new dd(m21.f, ij0.f("KFunction"));
    public final ff0 g;
    public final v9 i;
    public final mx j;
    public final int n;
    public final a o;
    public final nx p;
    public final List q;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends l {
        public a() {
            super(lx.this.g);
        }

        @Override // defpackage.l, defpackage.a91
        public final od b() {
            return lx.this;
        }

        @Override // defpackage.a91
        public final boolean c() {
            return true;
        }

        @Override // defpackage.s0
        public final Collection g() {
            List<dd> listSingletonList;
            Iterable iterableSingletonList;
            lx lxVar = lx.this;
            int iOrdinal = lxVar.j.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                listSingletonList = Collections.singletonList(lx.r);
            } else {
                int i = lxVar.n;
                if (iOrdinal == 2) {
                    listSingletonList = Arrays.asList(lx.s, new dd(m21.i, ij0.f(e4.j(mx.f.c, Integer.valueOf(i)))));
                } else {
                    if (iOrdinal != 3) {
                        d.AnonymousClass0.m();
                        return null;
                    }
                    listSingletonList = Arrays.asList(lx.s, new dd(m21.c, ij0.f(e4.j(mx.g.c, Integer.valueOf(i)))));
                }
            }
            gi0 gi0VarB = lxVar.i.b();
            ArrayList arrayList = new ArrayList(ae.y0(listSingletonList));
            for (dd ddVar : listSingletonList) {
                ai0 ai0VarA = e4.a(gi0VarB, ddVar);
                if (ai0VarA == null) {
                    throw new IllegalStateException(("Built-in class " + ddVar + " not found").toString());
                }
                int size = ai0VarA.h().getParameters().size();
                List list = lxVar.q;
                if (size < 0) {
                    d.AnonymousClass0.m((Object) e.i(size, "Requested element count ", " is less than zero."));
                    return null;
                }
                if (size == 0) {
                    iterableSingletonList = uq.b;
                } else {
                    int size2 = list.size();
                    if (size >= size2) {
                        iterableSingletonList = he.g1(list);
                    } else if (size == 1) {
                        iterableSingletonList = Collections.singletonList(he.T0(list));
                    } else {
                        ArrayList arrayList2 = new ArrayList(size);
                        if (list instanceof RandomAccess) {
                            for (int i2 = size2 - size; i2 < size2; i2++) {
                                arrayList2.add(list.get(i2));
                            }
                        } else {
                            ListIterator listIterator = list.listIterator(size2 - size);
                            while (listIterator.hasNext()) {
                                arrayList2.add(listIterator.next());
                            }
                        }
                        iterableSingletonList = arrayList2;
                    }
                }
                ArrayList arrayList3 = new ArrayList(ae.y0(iterableSingletonList));
                Iterator it = iterableSingletonList.iterator();
                while (it.hasNext()) {
                    arrayList3.add(new da1(((v91) it.next()).n()));
                }
                arrayList.add(e4.f(e4.f47a, ai0VarA.h(), arrayList3, false));
            }
            return he.g1(arrayList);
        }

        @Override // defpackage.a91
        public final List getParameters() {
            return lx.this.q;
        }

        @Override // defpackage.s0
        public final ke j() {
            return ke.a;
        }

        @Override // defpackage.l
        /* JADX INFO: renamed from: p */
        public final ai0 b() {
            return lx.this;
        }

        public final String toString() {
            return lx.this.toString();
        }
    }

    public lx(ff0 ff0Var, v9 v9Var, mx mxVar, int i) {
        super(ff0Var, ij0.f(e4.j(mxVar.c, Integer.valueOf(i))));
        this.g = ff0Var;
        this.i = v9Var;
        this.j = mxVar;
        this.n = i;
        this.o = new a();
        this.p = new nx(ff0Var, this);
        ArrayList arrayList = new ArrayList();
        y20 y20Var = new y20(1, i, 1);
        ArrayList arrayList2 = new ArrayList(ae.y0(y20Var));
        Iterator it = y20Var.iterator();
        while (true) {
            x20 x20Var = (x20) it;
            if (!x20Var.d) {
                arrayList.add(w91.O0(this, ad1.OUT_VARIANCE, ij0.f("R"), arrayList.size(), this.g));
                this.q = he.g1(arrayList);
                return;
            } else {
                arrayList.add(w91.O0(this, ad1.IN_VARIANCE, ij0.f(e4.j("P", Integer.valueOf(x20Var.nextInt()))), arrayList.size(), this.g));
                arrayList2.add(tb1.a);
            }
        }
    }

    @Override // defpackage.ai0
    public final /* bridge */ /* synthetic */ Collection A() {
        return uq.b;
    }

    @Override // defpackage.pd
    public final boolean B() {
        return false;
    }

    @Override // defpackage.ai0
    public final /* bridge */ /* synthetic */ uc E() {
        return null;
    }

    @Override // defpackage.ai0
    public final boolean I0() {
        return false;
    }

    @Override // defpackage.ai0
    public final vg0 W(lc0$a lc0_a) {
        return this.p;
    }

    @Override // defpackage.qg0
    public final boolean Z() {
        return false;
    }

    @Override // defpackage.ok
    public final ok b() {
        return this.i;
    }

    @Override // defpackage.qg0
    public final boolean b0() {
        return false;
    }

    @Override // defpackage.ai0
    public final boolean c0() {
        return false;
    }

    @Override // defpackage.ai0
    public final boolean f0() {
        return false;
    }

    @Override // defpackage.qk
    public final t11 g() {
        return t11.a;
    }

    @Override // defpackage.w3
    public final s4 getAnnotations() {
        return e4.f47a;
    }

    @Override // defpackage.ai0, defpackage.uk, defpackage.qg0
    public final cn.d getVisibility() {
        return cn.e;
    }

    @Override // defpackage.od
    public final a91 h() {
        return this.o;
    }

    @Override // defpackage.ai0
    public final /* bridge */ /* synthetic */ Collection i() {
        return uq.b;
    }

    @Override // defpackage.ai0
    public final boolean k0() {
        return false;
    }

    @Override // defpackage.qg0
    public final boolean l0() {
        return false;
    }

    @Override // defpackage.ai0, defpackage.pd
    public final List o() {
        return this.q;
    }

    @Override // defpackage.ai0
    public final vg0 o0() {
        return vg0.b.b;
    }

    @Override // defpackage.ai0, defpackage.qg0
    public final zh0 p() {
        return zh0.f;
    }

    @Override // defpackage.ai0
    public final boolean r() {
        return false;
    }

    @Override // defpackage.ai0
    public final i20 t() {
        return null;
    }

    public final String toString() {
        return getName().b();
    }

    @Override // defpackage.ai0
    public final int v() {
        return 2;
    }
}
