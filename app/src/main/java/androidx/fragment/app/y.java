package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ak;
import defpackage.b21;
import defpackage.gb;
import defpackage.qd1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class y {
    public final ViewGroup a;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public boolean d = false;
    public boolean e = false;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Runnable {
        public final /* synthetic */ c b;

        public a(c cVar) {
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList = y.this.b;
            c cVar = this.b;
            if (arrayList.contains(cVar)) {
                cVar.a.a(cVar.c.mView);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements Runnable {
        public final /* synthetic */ c b;

        public b(c cVar) {
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            y yVar = y.this;
            ArrayList arrayList = yVar.b;
            c cVar = this.b;
            arrayList.remove(cVar);
            yVar.c.remove(cVar);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c extends d {
        public final u h;

        public c(d.c cVar, d.b bVar, u uVar, gb gbVar) {
            super(cVar, bVar, uVar.c, gbVar);
            this.h = uVar;
        }

        @Override // androidx.fragment.app.y.d
        public final void b() {
            super.b();
            this.h.i();
        }

        @Override // androidx.fragment.app.y.d
        public final void d() {
            d.b bVar = this.b;
            d.b bVar2 = d.b.ADDING;
            u uVar = this.h;
            if (bVar != bVar2) {
                if (bVar == d.b.REMOVING) {
                    Fragment fragment = uVar.c;
                    View viewRequireView = fragment.requireView();
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Objects.toString(viewRequireView.findFocus());
                        viewRequireView.toString();
                        fragment.toString();
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragment2 = uVar.c;
            View viewFindFocus = fragment2.mView.findFocus();
            if (viewFindFocus != null) {
                fragment2.setFocusedView(viewFindFocus);
                if (Log.isLoggable("FragmentManager", 2)) {
                    viewFindFocus.toString();
                    fragment2.toString();
                }
            }
            View viewRequireView2 = this.c.requireView();
            if (viewRequireView2.getParent() == null) {
                uVar.a();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(fragment2.getPostOnViewCreatedAlpha());
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class d {
        public c a;
        public b b;
        public final Fragment c;
        public final ArrayList d = new ArrayList();
        public final HashSet e = new HashSet();
        public boolean f = false;
        public boolean g = false;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements gb.a {
            public a() {
            }

            @Override // gb.a
            public final void onCancel() {
                d.this.a();
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c b(int i) {
                if (i == 0) {
                    return VISIBLE;
                }
                if (i == 4) {
                    return INVISIBLE;
                }
                if (i == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException(ak.h(i, "Unknown visibility "));
            }

            public static c c(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            public final void a(View view) {
                int i;
                int iOrdinal = ordinal();
                if (iOrdinal == 0) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (Log.isLoggable("FragmentManager", 2)) {
                            view.toString();
                            viewGroup.toString();
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (iOrdinal == 1) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Objects.toString(view);
                    }
                    i = 0;
                } else if (iOrdinal == 2) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Objects.toString(view);
                    }
                    i = 8;
                } else {
                    if (iOrdinal != 3) {
                        return;
                    }
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Objects.toString(view);
                    }
                    i = 4;
                }
                view.setVisibility(i);
            }
        }

        public d(c cVar, b bVar, Fragment fragment, gb gbVar) {
            this.a = cVar;
            this.b = bVar;
            this.c = fragment;
            gbVar.b(new a());
        }

        public final void a() {
            if (this.f) {
                return;
            }
            this.f = true;
            HashSet hashSet = this.e;
            if (hashSet.isEmpty()) {
                b();
                return;
            }
            for (gb gbVar : new ArrayList(hashSet)) {
                synchronized (gbVar) {
                    try {
                        if (!gbVar.a) {
                            gbVar.a = true;
                            gbVar.c = true;
                            gb.a aVar = gbVar.b;
                            if (aVar != null) {
                                try {
                                    aVar.onCancel();
                                } catch (Throwable th) {
                                    synchronized (gbVar) {
                                        gbVar.c = false;
                                        gbVar.notifyAll();
                                        throw th;
                                    }
                                }
                            }
                            synchronized (gbVar) {
                                gbVar.c = false;
                                gbVar.notifyAll();
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        public void b() {
            if (this.g) {
                return;
            }
            if (Log.isLoggable("FragmentManager", 2)) {
                toString();
            }
            this.g = true;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void c(c cVar, b bVar) {
            b bVar2;
            int iOrdinal = bVar.ordinal();
            c cVar2 = c.REMOVED;
            Fragment fragment = this.c;
            if (iOrdinal == 0) {
                if (this.a != cVar2) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Objects.toString(fragment);
                        Objects.toString(this.a);
                        Objects.toString(cVar);
                    }
                    this.a = cVar;
                    return;
                }
                return;
            }
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    return;
                }
                if (Log.isLoggable("FragmentManager", 2)) {
                    Objects.toString(fragment);
                    Objects.toString(this.a);
                    Objects.toString(this.b);
                }
                this.a = cVar2;
                bVar2 = b.REMOVING;
            } else {
                if (this.a != cVar2) {
                    return;
                }
                if (Log.isLoggable("FragmentManager", 2)) {
                    Objects.toString(fragment);
                    Objects.toString(this.b);
                }
                this.a = c.VISIBLE;
                bVar2 = b.ADDING;
            }
            this.b = bVar2;
        }

        public void d() {
        }

        public final String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.a + "} {mLifecycleImpact = " + this.b + "} {mFragment = " + this.c + "}";
        }
    }

    public y(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public static y f(ViewGroup viewGroup, b21 b21Var) {
        Object tag = viewGroup.getTag(R.attr.yy);
        if (tag instanceof y) {
            return (y) tag;
        }
        ((q.e) b21Var).getClass();
        l lVar = new l(viewGroup);
        viewGroup.setTag(R.attr.yy, lVar);
        return lVar;
    }

    public final void a(d.c cVar, d.b bVar, u uVar) {
        synchronized (this.b) {
            try {
                gb gbVar = new gb();
                d dVarD = d(uVar.c);
                if (dVarD != null) {
                    dVarD.c(cVar, bVar);
                } else {
                    c cVar2 = new c(cVar, bVar, uVar, gbVar);
                    this.b.add(cVar2);
                    cVar2.d.add(new a(cVar2));
                    cVar2.d.add(new b(cVar2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void b(ArrayList arrayList, boolean z);

    public final void c() {
        if (this.e) {
            return;
        }
        ViewGroup viewGroup = this.a;
        WeakHashMap weakHashMap = qd1.a;
        if (!viewGroup.isAttachedToWindow()) {
            e();
            this.d = false;
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.b.isEmpty()) {
                    ArrayList<d> arrayList = new ArrayList(this.c);
                    this.c.clear();
                    for (d dVar : arrayList) {
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Objects.toString(dVar);
                        }
                        dVar.a();
                        if (!dVar.g) {
                            this.c.add(dVar);
                        }
                    }
                    i();
                    ArrayList arrayList2 = new ArrayList(this.b);
                    this.b.clear();
                    this.c.addAll(arrayList2);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).d();
                    }
                    b(arrayList2, this.d);
                    this.d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final d d(Fragment fragment) {
        for (d dVar : this.b) {
            if (dVar.c.equals(fragment) && !dVar.f) {
                return dVar;
            }
        }
        return null;
    }

    public final void e() {
        ViewGroup viewGroup = this.a;
        WeakHashMap weakHashMap = qd1.a;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.b) {
            try {
                i();
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).d();
                }
                for (d dVar : new ArrayList(this.c)) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        if (!zIsAttachedToWindow) {
                            Objects.toString(this.a);
                        }
                        Objects.toString(dVar);
                    }
                    dVar.a();
                }
                for (d dVar2 : new ArrayList(this.b)) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        if (!zIsAttachedToWindow) {
                            Objects.toString(this.a);
                        }
                        Objects.toString(dVar2);
                    }
                    dVar2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this.b) {
            try {
                i();
                this.e = false;
                int size = this.b.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    d dVar = (d) this.b.get(size);
                    d.c cVarC = d.c.c(dVar.c.mView);
                    d.c cVar = dVar.a;
                    d.c cVar2 = d.c.VISIBLE;
                    if (cVar == cVar2 && cVarC != cVar2) {
                        this.e = dVar.c.isPostponed();
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        for (d dVar : this.b) {
            if (dVar.b == d.b.ADDING) {
                dVar.c(d.c.b(dVar.c.requireView().getVisibility()), d.b.NONE);
            }
        }
    }
}
