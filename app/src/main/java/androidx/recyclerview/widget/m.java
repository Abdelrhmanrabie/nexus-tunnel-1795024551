package androidx.recyclerview.widget;

import android.os.Trace;
import defpackage.t71;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {
    public static final ThreadLocal g = new ThreadLocal();
    public static final a i = new a();
    public long c;
    public long d;
    public final ArrayList b = new ArrayList();
    public final ArrayList f = new ArrayList();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Comparator<c> {
        @Override // java.util.Comparator
        public final int compare(c cVar, c cVar2) {
            c cVar3 = cVar;
            c cVar4 = cVar2;
            RecyclerView recyclerView = cVar3.d;
            if ((recyclerView == null) == (cVar4.d == null)) {
                boolean z = cVar3.a;
                if (z == cVar4.a) {
                    int i = cVar4.b - cVar3.b;
                    if (i != 0) {
                        return i;
                    }
                    int i2 = cVar3.c - cVar4.c;
                    if (i2 != 0) {
                        return i2;
                    }
                    return 0;
                }
                if (z) {
                    return -1;
                }
            } else if (recyclerView != null) {
                return -1;
            }
            return 1;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b implements RecyclerView.o.c {
        public int a;
        public int b;
        public int[] c;
        public int d;

        public final void a(int i, int i2) {
            if (i < 0) {
                defpackage.d.AnonymousClass0.m$2("Layout positions must be non-negative");
                return;
            }
            if (i2 < 0) {
                defpackage.d.AnonymousClass0.m$2("Pixel distance must be non-negative");
                return;
            }
            int i3 = this.d;
            int i4 = i3 * 2;
            int[] iArr = this.c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i4 >= iArr.length) {
                int[] iArr3 = new int[i3 * 4];
                this.c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.c;
            iArr4[i4] = i;
            iArr4[i4 + 1] = i2;
            this.d++;
        }

        public final void b(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || oVar == null || !oVar.mItemPrefetchEnabled) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.g()) {
                    oVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                oVar.collectAdjacentPrefetchPositions(this.a, this.b, recyclerView.mState, this);
            }
            int i = this.d;
            if (i > oVar.mPrefetchMaxCountObserved) {
                oVar.mPrefetchMaxCountObserved = i;
                oVar.mPrefetchMaxObservedInInitialPrefetch = z;
                recyclerView.mRecycler.l();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c {
        public boolean a;
        public int b;
        public int c;
        public RecyclerView d;
        public int e;
    }

    public static RecyclerView.d0 c(RecyclerView recyclerView, int i2, long j) {
        int iH = recyclerView.mChildHelper.h();
        for (int i3 = 0; i3 < iH; i3++) {
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.g(i3));
            if (childViewHolderInt.mPosition == i2 && !childViewHolderInt.isInvalid()) {
                return null;
            }
        }
        RecyclerView.v vVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.d0 d0VarJ = vVar.j(i2, j);
            if (d0VarJ != null) {
                if (!d0VarJ.isBound() || d0VarJ.isInvalid()) {
                    vVar.a(d0VarJ, false);
                } else {
                    vVar.g(d0VarJ.itemView);
                }
            }
            return d0VarJ;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public final void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.mIsAttached && this.c == 0) {
            this.c = System.nanoTime();
            recyclerView.post(this);
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.a = i2;
        bVar.b = i3;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00cb  */
    public final void b(long j) {
        c cVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        c cVar2;
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList.get(i3);
            int windowVisibility = recyclerView3.getWindowVisibility();
            b bVar = recyclerView3.mPrefetchRegistry;
            if (windowVisibility == 0) {
                bVar.b(recyclerView3, false);
                i2 += bVar.d;
            }
        }
        ArrayList arrayList2 = this.f;
        arrayList2.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList.get(i5);
            if (recyclerView4.getWindowVisibility() == 0) {
                b bVar2 = recyclerView4.mPrefetchRegistry;
                int iAbs = Math.abs(bVar2.b) + Math.abs(bVar2.a);
                for (int i6 = 0; i6 < bVar2.d * 2; i6 += 2) {
                    if (i4 >= arrayList2.size()) {
                        cVar2 = new c();
                        arrayList2.add(cVar2);
                    } else {
                        cVar2 = (c) arrayList2.get(i4);
                    }
                    int[] iArr = bVar2.c;
                    int i7 = iArr[i6 + 1];
                    cVar2.a = i7 <= iAbs;
                    cVar2.b = iAbs;
                    cVar2.c = i7;
                    cVar2.d = recyclerView4;
                    cVar2.e = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(arrayList2, i);
        for (int i8 = 0; i8 < arrayList2.size() && (recyclerView = (cVar = (c) arrayList2.get(i8)).d) != null; i8++) {
            RecyclerView.d0 d0VarC = c(recyclerView, cVar.e, cVar.a ? Long.MAX_VALUE : j);
            if (d0VarC != null && d0VarC.mNestedRecyclerView != null && d0VarC.isBound() && !d0VarC.isInvalid() && (recyclerView2 = (RecyclerView) d0VarC.mNestedRecyclerView.get()) != null) {
                if (recyclerView2.mDataSetHasChangedAfterLayout && recyclerView2.mChildHelper.h() != 0) {
                    recyclerView2.removeAndRecycleViews();
                }
                b bVar3 = recyclerView2.mPrefetchRegistry;
                bVar3.b(recyclerView2, true);
                if (bVar3.d != 0) {
                    try {
                        int i9 = t71.$r8$clinit;
                        Trace.beginSection("RV Nested Prefetch");
                        RecyclerView.a0 a0Var = recyclerView2.mState;
                        RecyclerView.g gVar = recyclerView2.mAdapter;
                        a0Var.d = 1;
                        a0Var.e = gVar.getItemCount();
                        a0Var.g = false;
                        a0Var.h = false;
                        a0Var.i = false;
                        for (int i10 = 0; i10 < bVar3.d * 2; i10 += 2) {
                            c(recyclerView2, bVar3.c[i10], j);
                        }
                        Trace.endSection();
                    } catch (Throwable th) {
                        int i11 = t71.$r8$clinit;
                        Trace.endSection();
                        throw th;
                    }
                }
            }
            cVar.a = false;
            cVar.b = 0;
            cVar.c = 0;
            cVar.d = null;
            cVar.e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i2 = t71.$r8$clinit;
            Trace.beginSection("RV Prefetch");
            ArrayList arrayList = this.b;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long jMax = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i3);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.d);
                }
            }
            this.c = 0L;
        } finally {
            this.c = 0L;
            int i4 = t71.$r8$clinit;
            Trace.endSection();
        }
    }
}
