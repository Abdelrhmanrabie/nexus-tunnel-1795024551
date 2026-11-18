package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import defpackage.qd1;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final RecyclerView.e a;
    public final a b = new a();
    public final ArrayList c = new ArrayList();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a {
        public long a = 0;
        public a b;

        public final void a(int i) {
            if (i < 64) {
                this.a &= ~(1 << i);
                return;
            }
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(i - 64);
            }
        }

        public final int b(int i) {
            long j;
            a aVar = this.b;
            if (aVar == null) {
                if (i >= 64) {
                    j = this.a;
                }
                return Long.bitCount(j);
            }
            if (i >= 64) {
                return Long.bitCount(this.a) + aVar.b(i - 64);
            }
            j = this.a & ((1 << i) - 1);
            return Long.bitCount(j);
        }

        public final void c() {
            if (this.b == null) {
                this.b = new a();
            }
        }

        public final boolean d(int i) {
            if (i < 64) {
                return (this.a & (1 << i)) != 0;
            }
            c();
            return this.b.d(i - 64);
        }

        public final void e(int i, boolean z) {
            if (i >= 64) {
                c();
                this.b.e(i - 64, z);
                return;
            }
            long j = this.a;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.a = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (z2 || this.b != null) {
                c();
                this.b.e(0, z2);
            }
        }

        public final boolean f(int i) {
            if (i >= 64) {
                c();
                return this.b.f(i - 64);
            }
            long j = 1 << i;
            long j2 = this.a;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.a = j3;
            long j4 = j - 1;
            this.a = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            a aVar = this.b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.b.f(0);
            }
            return z;
        }

        public final void g() {
            this.a = 0L;
            a aVar = this.b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public final void h(int i) {
            if (i < 64) {
                this.a |= 1 << i;
            } else {
                c();
                this.b.h(i - 64);
            }
        }

        public final String toString() {
            if (this.b == null) {
                return Long.toBinaryString(this.a);
            }
            return this.b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface InterfaceC0026b {
    }

    public b(RecyclerView.e eVar) {
        this.a = eVar;
    }

    public final void a(View view, int i, boolean z) {
        RecyclerView.e eVar = this.a;
        int childCount = i < 0 ? RecyclerView.this.getChildCount() : f(i);
        this.b.e(childCount, z);
        if (z) {
            i(view);
        }
        RecyclerView.this.addView(view, childCount);
        RecyclerView.getChildViewHolderInt(view);
    }

    public final void b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView.e eVar = this.a;
        int childCount = i < 0 ? RecyclerView.this.getChildCount() : f(i);
        this.b.e(childCount, z);
        if (z) {
            i(view);
        }
        eVar.getClass();
        RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        RecyclerView recyclerView = RecyclerView.this;
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(defpackage.e.h(recyclerView, sb));
            }
            childViewHolderInt.mFlags &= -257;
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public final void c(int i) {
        RecyclerView.d0 childViewHolderInt;
        int iF = f(i);
        this.b.f(iF);
        RecyclerView.e eVar = this.a;
        View childAt = RecyclerView.this.getChildAt(iF);
        RecyclerView recyclerView = RecyclerView.this;
        if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
            if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(defpackage.e.h(recyclerView, sb));
            }
            childViewHolderInt.addFlags(256);
        }
        recyclerView.detachViewFromParent(iF);
    }

    public final View d(int i) {
        return RecyclerView.this.getChildAt(f(i));
    }

    public final int e() {
        return RecyclerView.this.getChildCount() - this.c.size();
    }

    public final int f(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = RecyclerView.this.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            a aVar = this.b;
            int iB = i - (i2 - aVar.b(i2));
            if (iB == 0) {
                while (aVar.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iB;
        }
        return -1;
    }

    public final View g(int i) {
        return RecyclerView.this.getChildAt(i);
    }

    public final int h() {
        return RecyclerView.this.getChildCount();
    }

    public final void i(View view) {
        this.c.add(view);
        RecyclerView.e eVar = this.a;
        eVar.getClass();
        RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            View view2 = childViewHolderInt.itemView;
            RecyclerView recyclerView = RecyclerView.this;
            int importantForAccessibility = childViewHolderInt.mPendingAccessibilityState;
            if (importantForAccessibility == -1) {
                WeakHashMap weakHashMap = qd1.a;
                importantForAccessibility = view2.getImportantForAccessibility();
            }
            childViewHolderInt.mWasImportantForAccessibilityBeforeHidden = importantForAccessibility;
            if (recyclerView.isComputingLayout()) {
                childViewHolderInt.mPendingAccessibilityState = 4;
                recyclerView.mPendingAccessibilityImportanceChange.add(childViewHolderInt);
            } else {
                WeakHashMap weakHashMap2 = qd1.a;
                view2.setImportantForAccessibility(4);
            }
        }
    }

    public final void m(View view) {
        if (this.c.remove(view)) {
            RecyclerView.e eVar = this.a;
            eVar.getClass();
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                RecyclerView recyclerView = RecyclerView.this;
                int i = childViewHolderInt.mWasImportantForAccessibilityBeforeHidden;
                if (recyclerView.isComputingLayout()) {
                    childViewHolderInt.mPendingAccessibilityState = i;
                    recyclerView.mPendingAccessibilityImportanceChange.add(childViewHolderInt);
                } else {
                    View view2 = childViewHolderInt.itemView;
                    WeakHashMap weakHashMap = qd1.a;
                    view2.setImportantForAccessibility(i);
                }
                childViewHolderInt.mWasImportantForAccessibilityBeforeHidden = 0;
            }
        }
    }

    public final String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}
