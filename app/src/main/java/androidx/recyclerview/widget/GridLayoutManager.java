package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import defpackage.ak;
import defpackage.o1;
import defpackage.qd1;
import defpackage.qz;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean a;
    public int b;
    public int[] c;
    public View[] d;
    public final SparseIntArray e;
    public final SparseIntArray f;
    public final a g;
    public final Rect h;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class a extends c {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b extends RecyclerView.p {
        public int e;
        public int f;

        public b(int i, int i2) {
            super(i, i2);
            this.e = -1;
            this.f = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = -1;
            this.f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.e = -1;
            this.f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.e = -1;
            this.f = 0;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class c {
        public final SparseIntArray a = new SparseIntArray();
        public final SparseIntArray b = new SparseIntArray();

        public final void b() {
            this.a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        g(RecyclerView.o.getProperties(context, attributeSet, i, i2).b);
    }

    public GridLayoutManager(ContextThemeWrapper contextThemeWrapper, int i) {
        super(contextThemeWrapper, 1, false);
        this.a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        g(i);
    }

    public final void a(int i) {
        int i2;
        int[] iArr = this.c;
        int i3 = this.b;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.c = iArr;
    }

    public final int b(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.c;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.c;
        int i3 = this.b - i;
        return iArr2[i3] - iArr2[i3 - i2];
    }

    public final int c(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.g && (i = vVar.b(i)) == -1) {
            return 0;
        }
        int i2 = this.b;
        this.g.getClass();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            i3++;
            if (i3 == i2) {
                i4++;
                i3 = 0;
            } else if (i3 > i2) {
                i4++;
                i3 = 1;
            }
        }
        return i3 + 1 > i2 ? i4 + 1 : i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean checkLayoutParams(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void collectPrefetchPositionsForLayoutState(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, m.b bVar) {
        int i;
        int i2 = this.b;
        for (int i3 = 0; i3 < this.b && (i = cVar.d) >= 0 && i < a0Var.b() && i2 > 0; i3++) {
            bVar.a(cVar.d, Math.max(0, cVar.g));
            this.g.getClass();
            i2--;
            cVar.d += cVar.e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int computeHorizontalScrollOffset(RecyclerView.a0 a0Var) {
        return computeScrollOffset(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int computeHorizontalScrollRange(RecyclerView.a0 a0Var) {
        return computeScrollRange(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int computeVerticalScrollOffset(RecyclerView.a0 a0Var) {
        return computeScrollOffset(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int computeVerticalScrollRange(RecyclerView.a0 a0Var) {
        return computeScrollRange(a0Var);
    }

    public final int d(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.g) {
            int i2 = this.f.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            i = vVar.b(i);
            if (i == -1) {
                return 0;
            }
        }
        int i3 = this.b;
        this.g.getClass();
        return i % i3;
    }

    public final int e(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        boolean z = a0Var.g;
        a aVar = this.g;
        if (!z) {
            aVar.getClass();
            return 1;
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (vVar.b(i) == -1) {
            return 1;
        }
        aVar.getClass();
        return 1;
    }

    public final void f(View view, int i, boolean z) {
        int childMeasureSpec;
        int childMeasureSpec2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.b;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int iB = b(bVar.e, bVar.f);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = RecyclerView.o.getChildMeasureSpec(false, iB, i, i3, ((ViewGroup.MarginLayoutParams) bVar).width);
            childMeasureSpec = RecyclerView.o.getChildMeasureSpec(true, this.mOrientationHelper.l(), this.mHeightMode, i2, ((ViewGroup.MarginLayoutParams) bVar).height);
        } else {
            int childMeasureSpec3 = RecyclerView.o.getChildMeasureSpec(false, iB, i, i2, ((ViewGroup.MarginLayoutParams) bVar).height);
            int childMeasureSpec4 = RecyclerView.o.getChildMeasureSpec(true, this.mOrientationHelper.l(), this.mWidthMode, i3, ((ViewGroup.MarginLayoutParams) bVar).width);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z ? shouldReMeasureChild(view, childMeasureSpec2, childMeasureSpec, pVar) : shouldMeasureChild(view, childMeasureSpec2, childMeasureSpec, pVar)) {
            view.measure(childMeasureSpec2, childMeasureSpec);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View findReferenceChild(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z, boolean z2) {
        int i;
        int childCount;
        int childCount2 = getChildCount();
        int i2 = 1;
        if (z2) {
            childCount = getChildCount() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = childCount2;
            childCount = 0;
        }
        int iB = a0Var.b();
        ensureLayoutState();
        int iK = this.mOrientationHelper.k();
        int iG = this.mOrientationHelper.g();
        View view = null;
        View view2 = null;
        while (childCount != i) {
            View childAt = getChildAt(childCount);
            int position = RecyclerView.o.getPosition(childAt);
            if (position >= 0 && position < iB && d(position, vVar, a0Var) == 0) {
                if (((RecyclerView.p) childAt.getLayoutParams()).a.isRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.e(childAt) < iG && this.mOrientationHelper.b(childAt) >= iK) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            childCount += i2;
        }
        return view != null ? view : view2;
    }

    public final void g(int i) {
        if (i == this.b) {
            return;
        }
        this.a = true;
        if (i < 1) {
            throw new IllegalArgumentException(ak.h(i, "Span count should be at least 1. Provided "));
        }
        this.b = i;
        this.g.b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int getColumnCountForAccessibility(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 1) {
            return this.b;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return c(a0Var.b() - 1, vVar, a0Var) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int getRowCountForAccessibility(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 0) {
            return this.b;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return c(a0Var.b() - 1, vVar, a0Var) + 1;
    }

    public final void h() {
        int paddingBottom;
        int paddingTop;
        if (this.mOrientation == 1) {
            paddingBottom = this.mWidth - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            paddingBottom = this.mHeight - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        a(paddingBottom - paddingTop);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void layoutChunk(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int iD;
        int paddingTop;
        int i5;
        int i6;
        int childMeasureSpec;
        int childMeasureSpec2;
        ?? r12;
        int i7;
        View viewB;
        int iJ = this.mOrientationHelper.j();
        boolean z = iJ != 1073741824;
        int i8 = getChildCount() > 0 ? this.c[this.b] : 0;
        if (z) {
            h();
        }
        boolean z2 = cVar.e == 1;
        int iD2 = this.b;
        if (!z2) {
            iD2 = d(cVar.d, vVar, a0Var) + e(cVar.d, vVar, a0Var);
        }
        int i9 = 0;
        while (i9 < this.b && (i7 = cVar.d) >= 0 && i7 < a0Var.b() && iD2 > 0) {
            int i10 = cVar.d;
            int iE = e(i10, vVar, a0Var);
            if (iE > this.b) {
                throw new IllegalArgumentException("Item at position " + i10 + " requires " + iE + " spans but GridLayoutManager has only " + this.b + " spans.");
            }
            iD2 -= iE;
            if (iD2 < 0 || (viewB = cVar.b(vVar)) == null) {
                break;
            }
            this.d[i9] = viewB;
            i9++;
        }
        if (i9 == 0) {
            bVar.b = true;
            return;
        }
        if (z2) {
            i3 = 1;
            i2 = i9;
            i = 0;
        } else {
            i = i9 - 1;
            i2 = -1;
            i3 = -1;
        }
        int i11 = 0;
        while (i != i2) {
            View view = this.d[i];
            b bVar2 = (b) view.getLayoutParams();
            int iE2 = e(RecyclerView.o.getPosition(view), vVar, a0Var);
            bVar2.f = iE2;
            bVar2.e = i11;
            i11 += iE2;
            i += i3;
        }
        float f = 0.0f;
        int i12 = 0;
        for (int i13 = 0; i13 < i9; i13++) {
            View view2 = this.d[i13];
            if (cVar.k == null) {
                r12 = 0;
                r12 = 0;
                if (z2) {
                    addViewInt(view2, -1, false);
                } else {
                    addViewInt(view2, 0, false);
                }
            } else {
                r12 = 0;
                r12 = 0;
                if (z2) {
                    addViewInt(view2, -1, true);
                } else {
                    addViewInt(view2, 0, true);
                }
            }
            RecyclerView recyclerView = this.mRecyclerView;
            Rect rect = this.h;
            if (recyclerView == null) {
                rect.set(r12, r12, r12, r12);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view2));
            }
            f(view2, iJ, r12);
            int iC = this.mOrientationHelper.c(view2);
            if (iC > i12) {
                i12 = iC;
            }
            float fD = (this.mOrientationHelper.d(view2) * 1.0f) / ((b) view2.getLayoutParams()).f;
            if (fD > f) {
                f = fD;
            }
        }
        if (z) {
            a(Math.max(Math.round(f * this.b), i8));
            i12 = 0;
            for (int i14 = 0; i14 < i9; i14++) {
                View view3 = this.d[i14];
                f(view3, 1073741824, true);
                int iC2 = this.mOrientationHelper.c(view3);
                if (iC2 > i12) {
                    i12 = iC2;
                }
            }
        }
        for (int i15 = 0; i15 < i9; i15++) {
            View view4 = this.d[i15];
            if (this.mOrientationHelper.c(view4) != i12) {
                b bVar3 = (b) view4.getLayoutParams();
                Rect rect2 = bVar3.b;
                int i16 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) bVar3).topMargin + ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin;
                int i17 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) bVar3).leftMargin + ((ViewGroup.MarginLayoutParams) bVar3).rightMargin;
                int iB = b(bVar3.e, bVar3.f);
                if (this.mOrientation == 1) {
                    childMeasureSpec2 = RecyclerView.o.getChildMeasureSpec(false, iB, 1073741824, i17, ((ViewGroup.MarginLayoutParams) bVar3).width);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12 - i16, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12 - i17, 1073741824);
                    childMeasureSpec = RecyclerView.o.getChildMeasureSpec(false, iB, 1073741824, i16, ((ViewGroup.MarginLayoutParams) bVar3).height);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                if (shouldReMeasureChild(view4, childMeasureSpec2, childMeasureSpec, (RecyclerView.p) view4.getLayoutParams())) {
                    view4.measure(childMeasureSpec2, childMeasureSpec);
                }
            }
        }
        int iD3 = 0;
        bVar.a = i12;
        int i18 = this.mOrientation;
        int i19 = cVar.f;
        int paddingLeft = cVar.b;
        if (i18 == 1) {
            if (i19 == -1) {
                i6 = paddingLeft - i12;
            } else {
                i6 = paddingLeft;
                paddingLeft = i12 + paddingLeft;
            }
            paddingTop = i6;
            iD = 0;
            i5 = 0;
            iD3 = paddingLeft;
            paddingLeft = 0;
        } else {
            if (i19 == -1) {
                int i20 = paddingLeft - i12;
                i4 = paddingLeft;
                paddingLeft = i20;
            } else {
                i4 = i12 + paddingLeft;
            }
            iD = i4;
            paddingTop = 0;
            i5 = 0;
        }
        while (true) {
            View[] viewArr = this.d;
            if (i5 >= i9) {
                Arrays.fill(viewArr, (Object) null);
                return;
            }
            View view5 = viewArr[i5];
            b bVar4 = (b) view5.getLayoutParams();
            if (this.mOrientation != 1) {
                paddingTop = getPaddingTop() + this.c[bVar4.e];
                iD3 = this.mOrientationHelper.d(view5) + paddingTop;
            } else if (isLayoutRTL()) {
                iD = getPaddingLeft() + this.c[this.b - bVar4.e];
                paddingLeft = iD - this.mOrientationHelper.d(view5);
            } else {
                paddingLeft = this.c[bVar4.e] + getPaddingLeft();
                iD = this.mOrientationHelper.d(view5) + paddingLeft;
            }
            RecyclerView.o.layoutDecoratedWithMargins(view5, paddingLeft, paddingTop, iD, iD3);
            if (bVar4.a.isRemoved() || bVar4.a.isUpdated()) {
                bVar.c = true;
            }
            bVar.d = view5.hasFocusable() | bVar.d;
            i5++;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void onAnchorReady(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i) {
        h();
        if (a0Var.b() > 0 && !a0Var.g) {
            boolean z = i == 1;
            int iD = d(aVar.b, vVar, a0Var);
            if (z) {
                while (iD > 0) {
                    int i2 = aVar.b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    aVar.b = i3;
                    iD = d(i3, vVar, a0Var);
                }
            } else {
                int iB = a0Var.b() - 1;
                int i4 = aVar.b;
                while (i4 < iB) {
                    int i5 = i4 + 1;
                    int iD2 = d(i5, vVar, a0Var);
                    if (iD2 <= iD) {
                        break;
                    }
                    i4 = i5;
                    iD = iD2;
                }
                aVar.b = i4;
            }
        }
        View[] viewArr = this.d;
        if (viewArr == null || viewArr.length != this.b) {
            this.d = new View[this.b];
        }
    }

    /* JADX WARN: Code duplicated, block: B:84:0x0118  */
    /* JADX WARN: Code duplicated, block: B:85:0x011d  */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00df, code lost:
    
        if (r13 == (r2 > r15)) goto L67;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onFocusSearchFailed(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.v r25, androidx.recyclerview.widget.RecyclerView.a0 r26) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onInitializeAccessibilityNodeInfoForItem(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, o1 o1Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            onInitializeAccessibilityNodeInfoForItem(view, o1Var);
            return;
        }
        b bVar = (b) layoutParams;
        int iC = c(bVar.a.getLayoutPosition(), vVar, a0Var);
        int i = this.mOrientation;
        int i2 = bVar.e;
        int i3 = bVar.f;
        int i4 = 1;
        if (i == 0) {
            i2 = iC;
            iC = i2;
        } else {
            i4 = i3;
            i3 = 1;
        }
        o1Var.a.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) qz.a(false, iC, i3, i2, i4).a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onItemsAdded(int i, int i2) {
        a aVar = this.g;
        aVar.b();
        aVar.b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onItemsChanged() {
        a aVar = this.g;
        aVar.b();
        aVar.b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onItemsMoved(int i, int i2) {
        a aVar = this.g;
        aVar.b();
        aVar.b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onItemsRemoved(int i, int i2) {
        a aVar = this.g;
        aVar.b();
        aVar.b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onItemsUpdated(int i, int i2) {
        a aVar = this.g;
        aVar.b();
        aVar.b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        boolean z = a0Var.g;
        SparseIntArray sparseIntArray = this.f;
        SparseIntArray sparseIntArray2 = this.e;
        if (z) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                b bVar = (b) getChildAt(i).getLayoutParams();
                int layoutPosition = bVar.a.getLayoutPosition();
                sparseIntArray2.put(layoutPosition, bVar.f);
                sparseIntArray.put(layoutPosition, bVar.e);
            }
        }
        super.onLayoutChildren(vVar, a0Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final void onLayoutCompleted(RecyclerView.a0 a0Var) {
        super.onLayoutCompleted(a0Var);
        this.a = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int scrollHorizontallyBy(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        h();
        View[] viewArr = this.d;
        if (viewArr == null || viewArr.length != this.b) {
            this.d = new View[this.b];
        }
        return super.scrollHorizontallyBy(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int scrollVerticallyBy(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        h();
        View[] viewArr = this.d;
        if (viewArr == null || viewArr.length != this.b) {
            this.d = new View[this.b];
        }
        return super.scrollVerticallyBy(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        if (this.c == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            int iHeight = rect.height() + paddingBottom;
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap weakHashMap = qd1.a;
            iChooseSize2 = RecyclerView.o.chooseSize(i2, iHeight, recyclerView.getMinimumHeight());
            int[] iArr = this.c;
            iChooseSize = RecyclerView.o.chooseSize(i, iArr[iArr.length - 1] + paddingRight, this.mRecyclerView.getMinimumWidth());
        } else {
            int iWidth = rect.width() + paddingRight;
            RecyclerView recyclerView2 = this.mRecyclerView;
            WeakHashMap weakHashMap2 = qd1.a;
            iChooseSize = RecyclerView.o.chooseSize(i, iWidth, recyclerView2.getMinimumWidth());
            int[] iArr2 = this.c;
            iChooseSize2 = RecyclerView.o.chooseSize(i2, iArr2[iArr2.length - 1] + paddingBottom, this.mRecyclerView.getMinimumHeight());
        }
        this.mRecyclerView.setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void setStackFromEnd(boolean z) {
        if (z) {
            defpackage.d.AnonymousClass0.m$3("GridLayoutManager does not support stack from end. Consider using reverse layout");
        } else {
            super.setStackFromEnd(false);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.a;
    }
}
