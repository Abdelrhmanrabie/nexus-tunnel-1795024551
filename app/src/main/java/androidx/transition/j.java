package androidx.transition;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowId;
import defpackage.d7;
import defpackage.dg1;
import defpackage.g81;
import defpackage.oo;
import defpackage.qd1;
import defpackage.qf0;
import defpackage.te1;
import defpackage.u7;
import defpackage.ye1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final u7 a = new u7();
    public static final ThreadLocal b = new ThreadLocal();
    public static final ArrayList c = new ArrayList();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public final h b;
        public final ViewGroup c;

        /* JADX INFO: renamed from: androidx.transition.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class C0029a extends i {
            public final /* synthetic */ d7 b;

            public C0029a(d7 d7Var) {
                this.b = d7Var;
            }

            @Override // androidx.transition.h.g
            public final void onTransitionEnd(h hVar) {
                ((ArrayList) this.b.getOrDefault(a.this.c, null)).remove(hVar);
                hVar.removeListener(this);
            }
        }

        public a(ViewGroup viewGroup, h hVar) {
            this.b = hVar;
            this.c = viewGroup;
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0205  */
        /* JADX WARN: Code duplicated, block: B:106:0x0218  */
        /* JADX WARN: Code duplicated, block: B:108:0x0226  */
        /* JADX WARN: Code duplicated, block: B:113:0x0244  */
        /* JADX WARN: Code duplicated, block: B:143:0x01f1 A[EDGE_INSN: B:143:0x01f1->B:96:0x01f1 BREAK  A[LOOP:1: B:19:0x0087->B:95:0x01e7], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:14:0x004e  */
        /* JADX WARN: Code duplicated, block: B:17:0x0058 A[LOOP:0: B:15:0x0052->B:17:0x0058, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:180:0x0210 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:183:0x0231 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:186:0x02a7 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:21:0x008c  */
        /* JADX WARN: Code duplicated, block: B:23:0x0090  */
        /* JADX WARN: Code duplicated, block: B:25:0x0093  */
        /* JADX WARN: Code duplicated, block: B:27:0x0096  */
        /* JADX WARN: Code duplicated, block: B:30:0x009c  */
        /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:35:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:51:0x0101  */
        /* JADX WARN: Code duplicated, block: B:53:0x010b  */
        /* JADX WARN: Code duplicated, block: B:55:0x011b  */
        /* JADX WARN: Code duplicated, block: B:68:0x015f  */
        /* JADX WARN: Code duplicated, block: B:70:0x016d  */
        /* JADX WARN: Code duplicated, block: B:83:0x01b1  */
        /* JADX WARN: Code duplicated, block: B:86:0x01b8  */
        /* JADX WARN: Code duplicated, block: B:99:0x01f7  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ArrayList arrayList;
            h hVar;
            int i;
            oo ooVar;
            oo ooVar2;
            d7 d7Var;
            d7 d7Var2;
            int i2;
            int[] iArr;
            d7 d7Var3;
            int i3;
            int i4;
            d7 runningAnimators;
            int i5;
            Animator animator;
            h.d dVar;
            View view;
            dg1 dg1Var;
            g81 g81Var;
            g81 g81Var2;
            int i6;
            d7 d7Var4;
            int i7;
            View view2;
            g81 g81Var3;
            d7 d7Var5;
            int i8;
            int i9;
            View view3;
            View view4;
            SparseArray sparseArray;
            int size;
            int i10;
            View view5;
            View view6;
            qf0 qf0Var;
            int i11;
            int i12;
            View view7;
            d7 d7Var6;
            Iterator it;
            ViewGroup viewGroup = this.c;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            int i13 = 1;
            if (!j.c.remove(viewGroup)) {
                return true;
            }
            d7 d7VarB = j.b();
            Long l = null;
            ArrayList arrayList2 = (ArrayList) d7VarB.getOrDefault(viewGroup, null);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                d7VarB.put(viewGroup, arrayList2);
            } else {
                arrayList = arrayList2.size() > 0 ? new ArrayList(arrayList2) : null;
                hVar = this.b;
                arrayList2.add(hVar);
                hVar.addListener(new C0029a(d7VarB));
                i = 0;
                hVar.captureValues(viewGroup, false);
                if (arrayList != null) {
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((h) it.next()).resume(viewGroup);
                    }
                }
                hVar.mStartValuesList = new ArrayList();
                hVar.mEndValuesList = new ArrayList();
                ooVar = hVar.mStartValues;
                ooVar2 = hVar.mEndValues;
                d7Var = new d7((d7) ooVar.a);
                d7Var2 = new d7((d7) ooVar2.a);
                i2 = 0;
                while (true) {
                    iArr = hVar.mMatchOrder;
                    if (i2 < iArr.length) {
                        break;
                    }
                    i6 = iArr[i2];
                    if (i6 != i13) {
                        d7Var4 = d7Var;
                        i7 = d7Var4.d;
                        while (true) {
                            i7--;
                            if (i7 >= 0) {
                                view2 = (View) d7Var4.i(i7);
                                if (view2 == null && hVar.isValidTarget(view2) && (g81Var3 = (g81) d7Var2.remove(view2)) != null && hVar.isValidTarget(g81Var3.b)) {
                                    hVar.mStartValuesList.add((g81) d7Var4.j(i7));
                                    hVar.mEndValuesList.add(g81Var3);
                                }
                            }
                        }
                    } else if (i6 != 2) {
                        d7Var4 = d7Var;
                        d7Var5 = (d7) ooVar.d;
                        d7 d7Var7 = (d7) ooVar2.d;
                        i8 = d7Var5.d;
                        for (i9 = 0; i9 < i8; i9++) {
                            view3 = (View) d7Var5.k(i9);
                            if (view3 == null && hVar.isValidTarget(view3) && (view4 = (View) d7Var7.getOrDefault(d7Var5.i(i9), null)) != null && hVar.isValidTarget(view4)) {
                                g81 g81Var4 = (g81) d7Var4.getOrDefault(view3, null);
                                g81 g81Var5 = (g81) d7Var2.getOrDefault(view4, null);
                                if (g81Var4 != null && g81Var5 != null) {
                                    hVar.mStartValuesList.add(g81Var4);
                                    hVar.mEndValuesList.add(g81Var5);
                                    d7Var4.remove(view3);
                                    d7Var2.remove(view4);
                                }
                            }
                        }
                    } else if (i6 != 3) {
                        if (i6 == 4) {
                            qf0Var = (qf0) ooVar.c;
                            qf0 qf0Var2 = (qf0) ooVar2.c;
                            if (qf0Var.b) {
                                qf0Var.e();
                            }
                            i11 = qf0Var.f;
                            i12 = i;
                            while (i12 < i11) {
                                view7 = (View) qf0Var.h(i12);
                                if (view7 == null && hVar.isValidTarget(view7)) {
                                    if (qf0Var.b) {
                                        qf0Var.e();
                                    }
                                    d7 d7Var8 = d7Var;
                                    View view8 = (View) qf0Var2.f(qf0Var.c[i12], l);
                                    if (view8 == null || !hVar.isValidTarget(view8)) {
                                        d7Var6 = d7Var8;
                                    } else {
                                        d7Var6 = d7Var8;
                                        g81 g81Var6 = (g81) d7Var6.getOrDefault(view7, l);
                                        g81 g81Var7 = (g81) d7Var2.getOrDefault(view8, l);
                                        if (g81Var6 != null && g81Var7 != null) {
                                            hVar.mStartValuesList.add(g81Var6);
                                            hVar.mEndValuesList.add(g81Var7);
                                            d7Var6.remove(view7);
                                            d7Var2.remove(view8);
                                        }
                                    }
                                } else {
                                    d7Var6 = d7Var;
                                }
                                i12++;
                                d7Var = d7Var6;
                                l = null;
                            }
                        }
                        d7Var4 = d7Var;
                    } else {
                        d7Var4 = d7Var;
                        sparseArray = (SparseArray) ooVar.b;
                        SparseArray sparseArray2 = (SparseArray) ooVar2.b;
                        size = sparseArray.size();
                        for (i10 = 0; i10 < size; i10++) {
                            view5 = (View) sparseArray.valueAt(i10);
                            if (view5 == null && hVar.isValidTarget(view5) && (view6 = (View) sparseArray2.get(sparseArray.keyAt(i10))) != null && hVar.isValidTarget(view6)) {
                                g81 g81Var8 = (g81) d7Var4.getOrDefault(view5, null);
                                g81 g81Var9 = (g81) d7Var2.getOrDefault(view6, null);
                                if (g81Var8 != null && g81Var9 != null) {
                                    hVar.mStartValuesList.add(g81Var8);
                                    hVar.mEndValuesList.add(g81Var9);
                                    d7Var4.remove(view5);
                                    d7Var2.remove(view6);
                                }
                            }
                        }
                    }
                    i2++;
                    d7Var = d7Var4;
                    i = 0;
                    l = null;
                    i13 = 1;
                }
                d7Var3 = d7Var;
                for (i3 = 0; i3 < d7Var3.d; i3++) {
                    g81Var2 = (g81) d7Var3.k(i3);
                    if (hVar.isValidTarget(g81Var2.b)) {
                        hVar.mStartValuesList.add(g81Var2);
                        hVar.mEndValuesList.add(null);
                    }
                }
                for (i4 = 0; i4 < d7Var2.d; i4++) {
                    g81Var = (g81) d7Var2.k(i4);
                    if (hVar.isValidTarget(g81Var.b)) {
                        hVar.mEndValuesList.add(g81Var);
                        hVar.mStartValuesList.add(null);
                    }
                }
                runningAnimators = h.getRunningAnimators();
                i5 = runningAnimators.d;
                ye1 ye1Var = te1.a;
                WindowId windowId = viewGroup.getWindowId();
                while (true) {
                    i5--;
                    if (i5 >= 0) {
                        hVar.createAnimators(viewGroup, hVar.mStartValues, hVar.mEndValues, hVar.mStartValuesList, hVar.mEndValuesList);
                        hVar.runAnimators();
                        return true;
                    }
                    animator = (Animator) runningAnimators.i(i5);
                    if (animator == null && (dVar = (h.d) runningAnimators.getOrDefault(animator, null)) != null && (view = dVar.a) != null && (dg1Var = dVar.d) != null && dg1Var.a.equals(windowId)) {
                        g81 transitionValues = hVar.getTransitionValues(view, true);
                        g81 matchedTransitionValues = hVar.getMatchedTransitionValues(view, true);
                        if (transitionValues == null && matchedTransitionValues == null) {
                            matchedTransitionValues = (g81) ((d7) hVar.mEndValues.a).getOrDefault(view, null);
                        }
                        if (transitionValues != null || matchedTransitionValues != null) {
                            if (dVar.e.isTransitionRequired(dVar.c, matchedTransitionValues)) {
                                if (animator.isRunning() || animator.isStarted()) {
                                    animator.cancel();
                                } else {
                                    runningAnimators.remove(animator);
                                }
                            }
                        }
                    }
                }
            }
            hVar = this.b;
            arrayList2.add(hVar);
            hVar.addListener(new C0029a(d7VarB));
            i = 0;
            hVar.captureValues(viewGroup, false);
            if (arrayList != null) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    ((h) it.next()).resume(viewGroup);
                }
            }
            hVar.mStartValuesList = new ArrayList();
            hVar.mEndValuesList = new ArrayList();
            ooVar = hVar.mStartValues;
            ooVar2 = hVar.mEndValues;
            d7Var = new d7((d7) ooVar.a);
            d7Var2 = new d7((d7) ooVar2.a);
            i2 = 0;
            while (true) {
                iArr = hVar.mMatchOrder;
                if (i2 < iArr.length) {
                    break;
                    break;
                }
                i6 = iArr[i2];
                if (i6 != i13) {
                    d7Var4 = d7Var;
                    i7 = d7Var4.d;
                    while (true) {
                        i7--;
                        if (i7 >= 0) {
                            view2 = (View) d7Var4.i(i7);
                            if (view2 == null) {
                            }
                        }
                    }
                } else if (i6 != 2) {
                    d7Var4 = d7Var;
                    d7Var5 = (d7) ooVar.d;
                    d7 d7Var9 = (d7) ooVar2.d;
                    i8 = d7Var5.d;
                    while (i9 < i8) {
                        view3 = (View) d7Var5.k(i9);
                        if (view3 == null) {
                        }
                    }
                } else if (i6 != 3) {
                    if (i6 == 4) {
                        qf0Var = (qf0) ooVar.c;
                        qf0 qf0Var3 = (qf0) ooVar2.c;
                        if (qf0Var.b) {
                            qf0Var.e();
                        }
                        i11 = qf0Var.f;
                        i12 = i;
                        while (i12 < i11) {
                            view7 = (View) qf0Var.h(i12);
                            if (view7 == null) {
                                d7Var6 = d7Var;
                            } else {
                                d7Var6 = d7Var;
                            }
                            i12++;
                            d7Var = d7Var6;
                            l = null;
                        }
                    }
                    d7Var4 = d7Var;
                } else {
                    d7Var4 = d7Var;
                    sparseArray = (SparseArray) ooVar.b;
                    SparseArray sparseArray3 = (SparseArray) ooVar2.b;
                    size = sparseArray.size();
                    while (i10 < size) {
                        view5 = (View) sparseArray.valueAt(i10);
                        if (view5 == null) {
                        }
                    }
                }
                i2++;
                d7Var = d7Var4;
                i = 0;
                l = null;
                i13 = 1;
            }
            d7Var3 = d7Var;
            while (i3 < d7Var3.d) {
                g81Var2 = (g81) d7Var3.k(i3);
                if (hVar.isValidTarget(g81Var2.b)) {
                    hVar.mStartValuesList.add(g81Var2);
                    hVar.mEndValuesList.add(null);
                }
            }
            while (i4 < d7Var2.d) {
                g81Var = (g81) d7Var2.k(i4);
                if (hVar.isValidTarget(g81Var.b)) {
                    hVar.mEndValuesList.add(g81Var);
                    hVar.mStartValuesList.add(null);
                }
            }
            runningAnimators = h.getRunningAnimators();
            i5 = runningAnimators.d;
            ye1 ye1Var2 = te1.a;
            WindowId windowId2 = viewGroup.getWindowId();
            while (true) {
                i5--;
                if (i5 >= 0) {
                    hVar.createAnimators(viewGroup, hVar.mStartValues, hVar.mEndValues, hVar.mStartValuesList, hVar.mEndValuesList);
                    hVar.runAnimators();
                    return true;
                }
                animator = (Animator) runningAnimators.i(i5);
                if (animator == null) {
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            ViewGroup viewGroup = this.c;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            j.c.remove(viewGroup);
            ArrayList arrayList = (ArrayList) j.b().getOrDefault(viewGroup, null);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((h) it.next()).resume(viewGroup);
                }
            }
            this.b.clearValues(true);
        }
    }

    public static void a(ViewGroup viewGroup, h hVar) {
        ArrayList arrayList = c;
        if (arrayList.contains(viewGroup)) {
            return;
        }
        WeakHashMap weakHashMap = qd1.a;
        if (viewGroup.isLaidOut()) {
            arrayList.add(viewGroup);
            if (hVar == null) {
                hVar = a;
            }
            h hVarMo1clone = hVar.mo1clone();
            ArrayList arrayList2 = (ArrayList) b().getOrDefault(viewGroup, null);
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((h) it.next()).pause(viewGroup);
                }
            }
            if (hVarMo1clone != null) {
                hVarMo1clone.captureValues(viewGroup, true);
            }
            if (viewGroup.getTag(R.attr.a20) != null) {
                defpackage.d.AnonymousClass0.m$1();
                return;
            }
            viewGroup.setTag(R.attr.a20, null);
            if (hVarMo1clone != null) {
                a aVar = new a(viewGroup, hVarMo1clone);
                viewGroup.addOnAttachStateChangeListener(aVar);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
            }
        }
    }

    public static d7 b() {
        d7 d7Var;
        ThreadLocal threadLocal = b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (d7Var = (d7) weakReference.get()) != null) {
            return d7Var;
        }
        d7 d7Var2 = new d7();
        threadLocal.set(new WeakReference(d7Var2));
        return d7Var2;
    }
}
