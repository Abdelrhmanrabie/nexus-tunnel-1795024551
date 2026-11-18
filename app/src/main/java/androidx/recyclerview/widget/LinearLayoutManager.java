package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.a40;
import defpackage.ak;
import defpackage.qd1;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements a40, RecyclerView.z.b {
    public final a mAnchorInfo;
    public final int mInitialPrefetchItemCount;
    public boolean mLastStackFromEnd;
    public final b mLayoutChunkResult;
    public c mLayoutState;
    public int mOrientation;
    public u mOrientationHelper;
    public d mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    public final int[] mReusableIntPair;
    public final boolean mReverseLayout;
    public boolean mShouldReverseLayout;
    public final boolean mSmoothScrollbarEnabled;
    public boolean mStackFromEnd;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a {
        public u a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;

        public a() {
            d();
        }

        public final void a() {
            boolean z = this.d;
            u uVar = this.a;
            this.c = z ? uVar.g() : uVar.k();
        }

        public final void b(View view, int i) {
            boolean z = this.d;
            u uVar = this.a;
            if (z) {
                int iB = uVar.b(view);
                u uVar2 = this.a;
                this.c = (Integer.MIN_VALUE == uVar2.b ? 0 : uVar2.l() - uVar2.b) + iB;
            } else {
                this.c = uVar.e(view);
            }
            this.b = i;
        }

        public final void c(View view, int i) {
            int iMin;
            u uVar = this.a;
            int iL = Integer.MIN_VALUE == uVar.b ? 0 : uVar.l() - uVar.b;
            if (iL >= 0) {
                b(view, i);
                return;
            }
            this.b = i;
            boolean z = this.d;
            u uVar2 = this.a;
            if (z) {
                int iG = (uVar2.g() - iL) - this.a.b(view);
                this.c = this.a.g() - iG;
                if (iG <= 0) {
                    return;
                }
                int iC = this.c - this.a.c(view);
                int iK = this.a.k();
                int iMin2 = iC - (Math.min(this.a.e(view) - iK, 0) + iK);
                if (iMin2 >= 0) {
                    return;
                } else {
                    iMin = Math.min(iG, -iMin2) + this.c;
                }
            } else {
                int iE = uVar2.e(view);
                int iK2 = iE - this.a.k();
                this.c = iE;
                if (iK2 <= 0) {
                    return;
                }
                int iG2 = (this.a.g() - Math.min(0, (this.a.g() - iL) - this.a.b(view))) - (this.a.c(view) + iE);
                if (iG2 >= 0) {
                    return;
                } else {
                    iMin = this.c - Math.min(iK2, -iG2);
                }
            }
            this.c = iMin;
        }

        public final void d() {
            this.b = -1;
            this.c = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            this.d = false;
            this.e = false;
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c {
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int j;
        public boolean l;
        public boolean a = true;
        public int h = 0;
        public int i = 0;
        public List k = null;

        public final void a(View view) {
            int layoutPosition;
            int size = this.k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = ((RecyclerView.d0) this.k.get(i2)).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.a.isRemoved() && (layoutPosition = (pVar.a.getLayoutPosition() - this.d) * this.e) >= 0 && layoutPosition < i) {
                    view2 = view3;
                    if (layoutPosition == 0) {
                        break;
                    } else {
                        i = layoutPosition;
                    }
                }
            }
            this.d = view2 == null ? -1 : ((RecyclerView.p) view2.getLayoutParams()).a.getLayoutPosition();
        }

        public final View b(RecyclerView.v vVar) {
            List list = this.k;
            if (list == null) {
                View view = vVar.j(this.d, Long.MAX_VALUE).itemView;
                this.d += this.e;
                return view;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view2 = ((RecyclerView.d0) this.k.get(i)).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view2.getLayoutParams();
                if (!pVar.a.isRemoved() && this.d == pVar.a.getLayoutPosition()) {
                    a(view2);
                    return view2;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();
        public int b;
        public int c;
        public boolean d;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Parcelable.Creator<d> {
            @Override // android.os.Parcelable.Creator
            public final d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final d[] newArray(int i) {
                return new d[i];
            }
        }

        public d() {
        }

        public d(Parcel parcel) {
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.b = dVar.b;
            this.c = dVar.c;
            this.d = dVar.d;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        assertNotInLayoutOrScroll(null);
        if (z) {
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.a);
        boolean z = properties.c;
        assertNotInLayoutOrScroll(null);
        if (z) {
            this.mReverseLayout = z;
            requestLayout();
        }
        setStackFromEnd(properties.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.a0 a0Var, int[] iArr) {
        int i;
        int iL = a0Var.a != -1 ? this.mOrientationHelper.l() : 0;
        if (this.mLayoutState.f == -1) {
            i = 0;
        } else {
            i = iL;
            iL = 0;
        }
        iArr[0] = iL;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.a0 a0Var, m.b bVar) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, a0Var);
        collectPrefetchPositionsForLayoutState(a0Var, this.mLayoutState, bVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void collectInitialPrefetchPositions(int i, m.b bVar) {
        boolean z;
        int i2;
        d dVar = this.mPendingSavedState;
        if (dVar == null || (i2 = dVar.b) < 0) {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            z = dVar.d;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            bVar.a(i2, 0);
            i2 += i3;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.a0 a0Var, c cVar, m.b bVar) {
        int i = cVar.d;
        if (i < 0 || i >= a0Var.b()) {
            return;
        }
        bVar.a(i, Math.max(0, cVar.g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int computeHorizontalScrollExtent(RecyclerView.a0 a0Var) {
        return computeScrollExtent(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.a0 a0Var) {
        return computeScrollOffset(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.a0 a0Var) {
        return computeScrollRange(a0Var);
    }

    public final int computeScrollExtent(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        u uVar = this.mOrientationHelper;
        boolean z = !this.mSmoothScrollbarEnabled;
        return y.a(a0Var, uVar, findFirstVisibleChildClosestToStart(z), findFirstVisibleChildClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    public final int computeScrollOffset(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        u uVar = this.mOrientationHelper;
        boolean z = !this.mSmoothScrollbarEnabled;
        return y.b(a0Var, uVar, findFirstVisibleChildClosestToStart(z), findFirstVisibleChildClosestToEnd(z), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public final int computeScrollRange(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        u uVar = this.mOrientationHelper;
        boolean z = !this.mSmoothScrollbarEnabled;
        return y.c(a0Var, uVar, findFirstVisibleChildClosestToStart(z), findFirstVisibleChildClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public final PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < RecyclerView.o.getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int computeVerticalScrollExtent(RecyclerView.a0 a0Var) {
        return computeScrollExtent(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.a0 a0Var) {
        return computeScrollOffset(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.a0 a0Var) {
        return computeScrollRange(a0Var);
    }

    public final int convertFocusDirectionToLayoutDirection(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 17) {
                    if (this.mOrientation == 0) {
                        return -1;
                    }
                    return AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                }
                if (i == 33) {
                    if (this.mOrientation == 1) {
                        return -1;
                    }
                    return AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                }
                if (i != 66) {
                    if (i != 130 || this.mOrientation != 1) {
                        return AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                    }
                } else if (this.mOrientation != 0) {
                    return AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                }
            } else if (this.mOrientation != 1 && isLayoutRTL()) {
                return -1;
            }
        } else if (this.mOrientation == 1 || !isLayoutRTL()) {
            return -1;
        }
        return 1;
    }

    public final void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = new c();
        }
    }

    public final int fill(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z) {
        int i;
        int i2 = cVar.c;
        int i3 = cVar.g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cVar.g = i3 + i2;
            }
            recycleByLayoutState(vVar, cVar);
        }
        int i4 = cVar.c + cVar.h;
        while (true) {
            if ((!cVar.l && i4 <= 0) || (i = cVar.d) < 0 || i >= a0Var.b()) {
                break;
            }
            b bVar = this.mLayoutChunkResult;
            bVar.a = 0;
            bVar.b = false;
            bVar.c = false;
            bVar.d = false;
            layoutChunk(vVar, a0Var, cVar, bVar);
            if (!bVar.b) {
                int i5 = cVar.b;
                int i6 = bVar.a;
                cVar.b = (cVar.f * i6) + i5;
                if (!bVar.c || cVar.k != null || !a0Var.g) {
                    cVar.c -= i6;
                    i4 -= i6;
                }
                int i7 = cVar.g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + i6;
                    cVar.g = i8;
                    int i9 = cVar.c;
                    if (i9 < 0) {
                        cVar.g = i8 + i9;
                    }
                    recycleByLayoutState(vVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.c;
    }

    public final View findFirstVisibleChildClosestToEnd(boolean z) {
        int childCount;
        int childCount2;
        if (this.mShouldReverseLayout) {
            childCount2 = getChildCount();
            childCount = 0;
        } else {
            childCount = getChildCount() - 1;
            childCount2 = -1;
        }
        return findOneVisibleChild(childCount, childCount2, z);
    }

    public final View findFirstVisibleChildClosestToStart(boolean z) {
        int childCount;
        int childCount2;
        if (this.mShouldReverseLayout) {
            childCount = -1;
            childCount2 = getChildCount() - 1;
        } else {
            childCount = getChildCount();
            childCount2 = 0;
        }
        return findOneVisibleChild(childCount2, childCount, z);
    }

    public final int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return RecyclerView.o.getPosition(viewFindOneVisibleChild);
    }

    public final View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if (i2 <= i && i2 >= i) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.e(getChildAt(i)) < this.mOrientationHelper.k()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.mOrientation == 0 ? this.mHorizontalBoundCheck : this.mVerticalBoundCheck).a(i, i2, i3, i4);
    }

    public final View findOneVisibleChild(int i, int i2, boolean z) {
        ensureLayoutState();
        return (this.mOrientation == 0 ? this.mHorizontalBoundCheck : this.mVerticalBoundCheck).a(i, i2, z ? 24579 : 320, 320);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0075  */
    /* JADX WARN: Code duplicated, block: B:35:0x0079  */
    public View findReferenceChild(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z, boolean z2) {
        int i;
        int childCount;
        int i2;
        ensureLayoutState();
        int childCount2 = getChildCount();
        if (z2) {
            childCount = getChildCount() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = childCount2;
            childCount = 0;
            i2 = 1;
        }
        int iB = a0Var.b();
        int iK = this.mOrientationHelper.k();
        int iG = this.mOrientationHelper.g();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (childCount != i) {
            View childAt = getChildAt(childCount);
            int position = RecyclerView.o.getPosition(childAt);
            int iE = this.mOrientationHelper.e(childAt);
            int iB2 = this.mOrientationHelper.b(childAt);
            if (position >= 0 && position < iB) {
                if (!((RecyclerView.p) childAt.getLayoutParams()).a.isRemoved()) {
                    boolean z3 = iB2 <= iK && iE < iK;
                    boolean z4 = iE >= iG && iB2 > iG;
                    if (!z3 && !z4) {
                        return childAt;
                    }
                    if (z) {
                        if (z4) {
                            view2 = childAt;
                        } else if (view == null) {
                            view = childAt;
                        }
                    } else if (z3) {
                        view2 = childAt;
                    } else if (view == null) {
                        view = childAt;
                    }
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            childCount += i2;
        }
        if (view != null) {
            return view;
        }
        return view2 != null ? view2 : view3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - RecyclerView.o.getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (RecyclerView.o.getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    public final int fixLayoutEndGap(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iG;
        int iG2 = this.mOrientationHelper.g() - i;
        if (iG2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-iG2, vVar, a0Var);
        int i3 = i + i2;
        if (!z || (iG = this.mOrientationHelper.g() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.o(iG);
        return iG + i2;
    }

    public final int fixLayoutStartGap(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iK;
        int iK2 = i - this.mOrientationHelper.k();
        if (iK2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(iK2, vVar, a0Var);
        int i3 = i + i2;
        if (!z || (iK = i3 - this.mOrientationHelper.k()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.o(-iK);
        return i2 - iK;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        return new RecyclerView.p(-2, -2);
    }

    public final View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    public final View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    public final boolean isLayoutRTL() {
        RecyclerView recyclerView = this.mRecyclerView;
        WeakHashMap weakHashMap = qd1.a;
        return recyclerView.getLayoutDirection() == 1;
    }

    public void layoutChunk(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int iD;
        int i;
        int i2;
        int iD2;
        int paddingLeft;
        View viewB = cVar.b(vVar);
        if (viewB == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewB.getLayoutParams();
        List list = cVar.k;
        boolean z = this.mShouldReverseLayout;
        int i3 = cVar.f;
        if (list == null) {
            if (z == (i3 == -1)) {
                addViewInt(viewB, -1, false);
            } else {
                addViewInt(viewB, 0, false);
            }
        } else {
            if (z == (i3 == -1)) {
                addViewInt(viewB, -1, true);
            } else {
                addViewInt(viewB, 0, true);
            }
        }
        RecyclerView.p pVar2 = (RecyclerView.p) viewB.getLayoutParams();
        Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(viewB);
        int i4 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
        int i5 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
        int childMeasureSpec = RecyclerView.o.getChildMeasureSpec(canScrollHorizontally(), this.mWidth, this.mWidthMode, getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) pVar2).leftMargin + ((ViewGroup.MarginLayoutParams) pVar2).rightMargin + i4, ((ViewGroup.MarginLayoutParams) pVar2).width);
        int childMeasureSpec2 = RecyclerView.o.getChildMeasureSpec(canScrollVertically(), this.mHeight, this.mHeightMode, getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) pVar2).topMargin + ((ViewGroup.MarginLayoutParams) pVar2).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) pVar2).height);
        if (shouldMeasureChild(viewB, childMeasureSpec, childMeasureSpec2, pVar2)) {
            viewB.measure(childMeasureSpec, childMeasureSpec2);
        }
        bVar.a = this.mOrientationHelper.c(viewB);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                iD2 = this.mWidth - getPaddingRight();
                paddingLeft = iD2 - this.mOrientationHelper.d(viewB);
            } else {
                paddingLeft = getPaddingLeft();
                iD2 = this.mOrientationHelper.d(viewB) + paddingLeft;
            }
            int i6 = cVar.f;
            i2 = cVar.b;
            int i7 = bVar.a;
            if (i6 == -1) {
                int i8 = paddingLeft;
                iD = i2;
                i2 -= i7;
                i = i8;
            } else {
                i = paddingLeft;
                iD = i7 + i2;
            }
        } else {
            int paddingTop = getPaddingTop();
            iD = this.mOrientationHelper.d(viewB) + paddingTop;
            int i9 = cVar.f;
            int i10 = cVar.b;
            int i11 = bVar.a;
            if (i9 == -1) {
                i = i10 - i11;
                iD2 = i10;
                i2 = paddingTop;
            } else {
                int i12 = i11 + i10;
                i = i10;
                i2 = paddingTop;
                iD2 = i12;
            }
        }
        RecyclerView.o.layoutDecoratedWithMargins(viewB, i, i2, iD2, iD);
        if (pVar.a.isRemoved() || pVar.a.isUpdated()) {
            bVar.c = true;
        }
        bVar.d = viewB.hasFocusable();
    }

    public void onAnchorReady(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onDetachedFromWindow(RecyclerView recyclerView) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View onFocusSearchFailed(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int iConvertFocusDirectionToLayoutDirection;
        resolveShouldLayoutReverse();
        if (getChildCount() != 0 && (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) != Integer.MIN_VALUE) {
            ensureLayoutState();
            updateLayoutState(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.l() * 0.33333334f), false, a0Var);
            c cVar = this.mLayoutState;
            cVar.g = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            cVar.a = false;
            fill(vVar, cVar, a0Var, true);
            boolean z = this.mShouldReverseLayout;
            View viewFindOnePartiallyOrCompletelyInvisibleChild = (iConvertFocusDirectionToLayoutDirection != -1 ? !z : z) ? findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1) : findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
            View childClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? getChildClosestToStart() : getChildClosestToEnd();
            if (!childClosestToStart.hasFocusable()) {
                return viewFindOnePartiallyOrCompletelyInvisibleChild;
            }
            if (viewFindOnePartiallyOrCompletelyInvisibleChild != null) {
                return childClosestToStart;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false);
            accessibilityEvent.setFromIndex(viewFindOneVisibleChild == null ? -1 : RecyclerView.o.getPosition(viewFindOneVisibleChild));
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0192  */
    /* JADX WARN: Code duplicated, block: B:106:0x0195  */
    /* JADX WARN: Code duplicated, block: B:113:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:116:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:120:0x01da  */
    /* JADX WARN: Code duplicated, block: B:124:0x01fa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:126:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:128:0x0201 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:130:0x0205  */
    /* JADX WARN: Code duplicated, block: B:132:0x0208 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:135:0x020e  */
    /* JADX WARN: Code duplicated, block: B:137:0x0212  */
    /* JADX WARN: Code duplicated, block: B:139:0x0219  */
    /* JADX WARN: Code duplicated, block: B:140:0x021f  */
    /* JADX WARN: Code duplicated, block: B:97:0x017d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View focusedChild;
        int iB;
        RecyclerView recyclerView;
        View focusedChild2;
        boolean z;
        boolean z2;
        View viewFindReferenceChild;
        int iE;
        int iB2;
        int iK;
        int iG;
        boolean z3;
        boolean z4;
        RecyclerView.p pVar;
        int i;
        int iK2;
        int i2;
        int iG2;
        int i3;
        int i4;
        int i5;
        int i6;
        ?? r4;
        List list;
        int i7;
        int i8;
        int iFixLayoutEndGap;
        int i9;
        View viewFindViewByPosition;
        int iE2;
        int iG3;
        int i10;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && a0Var.b() == 0) {
            removeAndRecycleAllViews(vVar);
            return;
        }
        d dVar = this.mPendingSavedState;
        if (dVar != null && (i10 = dVar.b) >= 0) {
            this.mPendingScrollPosition = i10;
        }
        ensureLayoutState();
        boolean z5 = false;
        this.mLayoutState.a = false;
        resolveShouldLayoutReverse();
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null || (focusedChild = recyclerView2.getFocusedChild()) == null || this.mChildHelper.c.contains(focusedChild)) {
            focusedChild = null;
        }
        a aVar = this.mAnchorInfo;
        if (!aVar.e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            aVar.d();
            aVar.d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            if (a0Var.g || (i = this.mPendingScrollPosition) == -1) {
                if (getChildCount() != 0) {
                    recyclerView = this.mRecyclerView;
                    if (recyclerView != null || (focusedChild2 = recyclerView.getFocusedChild()) == null || this.mChildHelper.c.contains(focusedChild2)) {
                        focusedChild2 = null;
                    }
                    if (focusedChild2 != null) {
                        pVar = (RecyclerView.p) focusedChild2.getLayoutParams();
                        if (!pVar.a.isRemoved() || pVar.a.getLayoutPosition() < 0 || pVar.a.getLayoutPosition() >= a0Var.b()) {
                            z = this.mLastStackFromEnd;
                            z2 = this.mStackFromEnd;
                            if (z == z2 || (viewFindReferenceChild = findReferenceChild(vVar, a0Var, aVar.d, z2)) == null) {
                                aVar.a();
                                if (this.mStackFromEnd) {
                                    iB = a0Var.b() - 1;
                                } else {
                                    iB = 0;
                                }
                                aVar.b = iB;
                            } else {
                                aVar.b(viewFindReferenceChild, RecyclerView.o.getPosition(viewFindReferenceChild));
                                if (!a0Var.g && supportsPredictiveItemAnimations()) {
                                    iE = this.mOrientationHelper.e(viewFindReferenceChild);
                                    iB2 = this.mOrientationHelper.b(viewFindReferenceChild);
                                    iK = this.mOrientationHelper.k();
                                    iG = this.mOrientationHelper.g();
                                    if (iB2 <= iK || iE >= iK) {
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                    if (iE >= iG || iB2 <= iG) {
                                        z4 = false;
                                    } else {
                                        z4 = true;
                                    }
                                    if (!z3 || z4) {
                                        if (aVar.d) {
                                            iK = iG;
                                        }
                                        aVar.c = iK;
                                    }
                                }
                            }
                        } else {
                            aVar.c(focusedChild2, RecyclerView.o.getPosition(focusedChild2));
                        }
                    } else {
                        z = this.mLastStackFromEnd;
                        z2 = this.mStackFromEnd;
                        if (z == z2) {
                            aVar.a();
                            if (this.mStackFromEnd) {
                                iB = a0Var.b() - 1;
                            } else {
                                iB = 0;
                            }
                            aVar.b = iB;
                        } else {
                            aVar.b(viewFindReferenceChild, RecyclerView.o.getPosition(viewFindReferenceChild));
                            if (!a0Var.g) {
                                iE = this.mOrientationHelper.e(viewFindReferenceChild);
                                iB2 = this.mOrientationHelper.b(viewFindReferenceChild);
                                iK = this.mOrientationHelper.k();
                                iG = this.mOrientationHelper.g();
                                if (iB2 <= iK) {
                                    z3 = false;
                                } else {
                                    z3 = false;
                                }
                                if (iE >= iG) {
                                    z4 = false;
                                } else {
                                    z4 = false;
                                }
                                if (!z3) {
                                }
                                if (aVar.d) {
                                    iK = iG;
                                }
                                aVar.c = iK;
                            }
                        }
                    }
                } else {
                    aVar.a();
                    if (this.mStackFromEnd) {
                        iB = a0Var.b() - 1;
                    } else {
                        iB = 0;
                    }
                    aVar.b = iB;
                }
            } else if (i < 0 || i >= a0Var.b()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                if (getChildCount() != 0) {
                    recyclerView = this.mRecyclerView;
                    if (recyclerView != null) {
                        focusedChild2 = null;
                    } else {
                        focusedChild2 = null;
                    }
                    if (focusedChild2 != null) {
                        pVar = (RecyclerView.p) focusedChild2.getLayoutParams();
                        if (pVar.a.isRemoved()) {
                            z = this.mLastStackFromEnd;
                            z2 = this.mStackFromEnd;
                            if (z == z2) {
                                aVar.a();
                                if (this.mStackFromEnd) {
                                    iB = a0Var.b() - 1;
                                } else {
                                    iB = 0;
                                }
                                aVar.b = iB;
                            } else {
                                aVar.b(viewFindReferenceChild, RecyclerView.o.getPosition(viewFindReferenceChild));
                                if (!a0Var.g) {
                                    iE = this.mOrientationHelper.e(viewFindReferenceChild);
                                    iB2 = this.mOrientationHelper.b(viewFindReferenceChild);
                                    iK = this.mOrientationHelper.k();
                                    iG = this.mOrientationHelper.g();
                                    if (iB2 <= iK) {
                                        z3 = false;
                                    } else {
                                        z3 = false;
                                    }
                                    if (iE >= iG) {
                                        z4 = false;
                                    } else {
                                        z4 = false;
                                    }
                                    if (!z3) {
                                    }
                                    if (aVar.d) {
                                        iK = iG;
                                    }
                                    aVar.c = iK;
                                }
                            }
                        } else {
                            z = this.mLastStackFromEnd;
                            z2 = this.mStackFromEnd;
                            if (z == z2) {
                                aVar.a();
                                if (this.mStackFromEnd) {
                                    iB = a0Var.b() - 1;
                                } else {
                                    iB = 0;
                                }
                                aVar.b = iB;
                            } else {
                                aVar.b(viewFindReferenceChild, RecyclerView.o.getPosition(viewFindReferenceChild));
                                if (!a0Var.g) {
                                    iE = this.mOrientationHelper.e(viewFindReferenceChild);
                                    iB2 = this.mOrientationHelper.b(viewFindReferenceChild);
                                    iK = this.mOrientationHelper.k();
                                    iG = this.mOrientationHelper.g();
                                    if (iB2 <= iK) {
                                        z3 = false;
                                    } else {
                                        z3 = false;
                                    }
                                    if (iE >= iG) {
                                        z4 = false;
                                    } else {
                                        z4 = false;
                                    }
                                    if (!z3) {
                                    }
                                    if (aVar.d) {
                                        iK = iG;
                                    }
                                    aVar.c = iK;
                                }
                            }
                        }
                    } else {
                        z = this.mLastStackFromEnd;
                        z2 = this.mStackFromEnd;
                        if (z == z2) {
                            aVar.a();
                            if (this.mStackFromEnd) {
                                iB = a0Var.b() - 1;
                            } else {
                                iB = 0;
                            }
                            aVar.b = iB;
                        } else {
                            aVar.b(viewFindReferenceChild, RecyclerView.o.getPosition(viewFindReferenceChild));
                            if (!a0Var.g) {
                                iE = this.mOrientationHelper.e(viewFindReferenceChild);
                                iB2 = this.mOrientationHelper.b(viewFindReferenceChild);
                                iK = this.mOrientationHelper.k();
                                iG = this.mOrientationHelper.g();
                                if (iB2 <= iK) {
                                    z3 = false;
                                } else {
                                    z3 = false;
                                }
                                if (iE >= iG) {
                                    z4 = false;
                                } else {
                                    z4 = false;
                                }
                                if (!z3) {
                                }
                                if (aVar.d) {
                                    iK = iG;
                                }
                                aVar.c = iK;
                            }
                        }
                    }
                } else {
                    aVar.a();
                    if (this.mStackFromEnd) {
                        iB = a0Var.b() - 1;
                    } else {
                        iB = 0;
                    }
                    aVar.b = iB;
                }
            } else {
                int i11 = this.mPendingScrollPosition;
                aVar.b = i11;
                d dVar2 = this.mPendingSavedState;
                if (dVar2 != null && dVar2.b >= 0) {
                    boolean z6 = dVar2.d;
                    aVar.d = z6;
                    u uVar = this.mOrientationHelper;
                    if (z6) {
                        iG2 = uVar.g();
                        i3 = this.mPendingSavedState.c;
                        i4 = iG2 - i3;
                        aVar.c = i4;
                    } else {
                        iK2 = uVar.k();
                        i2 = this.mPendingSavedState.c;
                        i4 = iK2 + i2;
                        aVar.c = i4;
                    }
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View viewFindViewByPosition2 = findViewByPosition(i11);
                    if (viewFindViewByPosition2 != null) {
                        if (this.mOrientationHelper.c(viewFindViewByPosition2) <= this.mOrientationHelper.l()) {
                            int iE3 = this.mOrientationHelper.e(viewFindViewByPosition2) - this.mOrientationHelper.k();
                            u uVar2 = this.mOrientationHelper;
                            if (iE3 < 0) {
                                aVar.c = uVar2.k();
                                aVar.d = false;
                            } else if (uVar2.g() - this.mOrientationHelper.b(viewFindViewByPosition2) < 0) {
                                aVar.c = this.mOrientationHelper.g();
                                aVar.d = true;
                            } else {
                                boolean z7 = aVar.d;
                                u uVar3 = this.mOrientationHelper;
                                if (z7) {
                                    int iB3 = uVar3.b(viewFindViewByPosition2);
                                    u uVar4 = this.mOrientationHelper;
                                    iK = (Integer.MIN_VALUE == uVar4.b ? 0 : uVar4.l() - uVar4.b) + iB3;
                                } else {
                                    iK = uVar3.e(viewFindViewByPosition2);
                                }
                                aVar.c = iK;
                            }
                        }
                    } else if (getChildCount() > 0) {
                        aVar.d = (this.mPendingScrollPosition < RecyclerView.o.getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                    }
                    aVar.a();
                } else {
                    boolean z8 = this.mShouldReverseLayout;
                    aVar.d = z8;
                    u uVar5 = this.mOrientationHelper;
                    if (z8) {
                        iG2 = uVar5.g();
                        i3 = this.mPendingScrollPositionOffset;
                        i4 = iG2 - i3;
                        aVar.c = i4;
                    } else {
                        iK2 = uVar5.k();
                        i2 = this.mPendingScrollPositionOffset;
                        i4 = iK2 + i2;
                        aVar.c = i4;
                    }
                }
            }
            aVar.e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.e(focusedChild) >= this.mOrientationHelper.g() || this.mOrientationHelper.b(focusedChild) <= this.mOrientationHelper.k())) {
            aVar.c(focusedChild, RecyclerView.o.getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f = cVar.j >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(a0Var, iArr);
        int iK3 = this.mOrientationHelper.k() + Math.max(0, iArr[0]);
        int iH = this.mOrientationHelper.h() + Math.max(0, iArr[1]);
        if (a0Var.g && (i9 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i9)) != null) {
            boolean z9 = this.mShouldReverseLayout;
            u uVar6 = this.mOrientationHelper;
            if (z9) {
                iG3 = uVar6.g() - this.mOrientationHelper.b(viewFindViewByPosition);
                iE2 = this.mPendingScrollPositionOffset;
            } else {
                iE2 = uVar6.e(viewFindViewByPosition) - this.mOrientationHelper.k();
                iG3 = this.mPendingScrollPositionOffset;
            }
            int i12 = iG3 - iE2;
            if (i12 > 0) {
                iK3 += i12;
            } else {
                iH -= i12;
            }
        }
        boolean z10 = aVar.d;
        boolean z11 = this.mShouldReverseLayout;
        onAnchorReady(vVar, a0Var, aVar, (!z10 ? z11 : !z11) ? 1 : -1);
        detachAndScrapAttachedViews(vVar);
        this.mLayoutState.l = this.mOrientationHelper.i() == 0 && this.mOrientationHelper.f() == 0;
        this.mLayoutState.getClass();
        this.mLayoutState.i = 0;
        boolean z12 = aVar.d;
        int i13 = aVar.b;
        int i14 = aVar.c;
        if (z12) {
            updateLayoutStateToFillStart(i13, i14);
            c cVar2 = this.mLayoutState;
            cVar2.h = iK3;
            fill(vVar, cVar2, a0Var, false);
            c cVar3 = this.mLayoutState;
            i6 = cVar3.b;
            int i15 = cVar3.d;
            int i16 = cVar3.c;
            if (i16 > 0) {
                iH += i16;
            }
            updateLayoutStateToFillEnd(aVar.b, aVar.c);
            c cVar4 = this.mLayoutState;
            cVar4.h = iH;
            cVar4.d += cVar4.e;
            fill(vVar, cVar4, a0Var, false);
            c cVar5 = this.mLayoutState;
            i5 = cVar5.b;
            int i17 = cVar5.c;
            if (i17 > 0) {
                updateLayoutStateToFillStart(i15, i6);
                c cVar6 = this.mLayoutState;
                cVar6.h = i17;
                fill(vVar, cVar6, a0Var, false);
                i6 = this.mLayoutState.b;
            }
        } else {
            updateLayoutStateToFillEnd(i13, i14);
            c cVar7 = this.mLayoutState;
            cVar7.h = iH;
            fill(vVar, cVar7, a0Var, false);
            c cVar8 = this.mLayoutState;
            i5 = cVar8.b;
            int i18 = cVar8.d;
            int i19 = cVar8.c;
            if (i19 > 0) {
                iK3 += i19;
            }
            updateLayoutStateToFillStart(aVar.b, aVar.c);
            c cVar9 = this.mLayoutState;
            cVar9.h = iK3;
            cVar9.d += cVar9.e;
            fill(vVar, cVar9, a0Var, false);
            c cVar10 = this.mLayoutState;
            int i20 = cVar10.b;
            int i21 = cVar10.c;
            if (i21 > 0) {
                updateLayoutStateToFillEnd(i18, i5);
                c cVar11 = this.mLayoutState;
                cVar11.h = i21;
                fill(vVar, cVar11, a0Var, false);
                i5 = this.mLayoutState.b;
            }
            i6 = i20;
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int iFixLayoutEndGap2 = fixLayoutEndGap(i5, vVar, a0Var, true);
                i7 = i6 + iFixLayoutEndGap2;
                i8 = i5 + iFixLayoutEndGap2;
                iFixLayoutEndGap = fixLayoutStartGap(i7, vVar, a0Var, false);
            } else {
                int iFixLayoutStartGap = fixLayoutStartGap(i6, vVar, a0Var, true);
                i7 = i6 + iFixLayoutStartGap;
                i8 = i5 + iFixLayoutStartGap;
                iFixLayoutEndGap = fixLayoutEndGap(i8, vVar, a0Var, false);
            }
            i6 = i7 + iFixLayoutEndGap;
            i5 = i8 + iFixLayoutEndGap;
        }
        if (a0Var.k && getChildCount() != 0 && !a0Var.g && supportsPredictiveItemAnimations()) {
            List list2 = vVar.d;
            int size = list2.size();
            int position = RecyclerView.o.getPosition(getChildAt(0));
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i22 < size) {
                RecyclerView.d0 d0Var = (RecyclerView.d0) list2.get(i22);
                if (!d0Var.isRemoved()) {
                    byte b2 = (d0Var.getLayoutPosition() < position ? true : z5) != this.mShouldReverseLayout ? (byte) -1 : (byte) 1;
                    int iC = this.mOrientationHelper.c(d0Var.itemView);
                    if (b2 == -1) {
                        i23 += iC;
                    } else {
                        i24 += iC;
                    }
                }
                i22++;
                z5 = false;
            }
            this.mLayoutState.k = list2;
            if (i23 > 0) {
                updateLayoutStateToFillStart(RecyclerView.o.getPosition(getChildClosestToStart()), i6);
                c cVar12 = this.mLayoutState;
                cVar12.h = i23;
                r4 = 0;
                cVar12.c = 0;
                cVar12.a(null);
                fill(vVar, this.mLayoutState, a0Var, false);
            } else {
                r4 = 0;
            }
            if (i24 > 0) {
                updateLayoutStateToFillEnd(RecyclerView.o.getPosition(getChildClosestToEnd()), i5);
                c cVar13 = this.mLayoutState;
                cVar13.h = i24;
                cVar13.c = r4;
                list = null;
                cVar13.a(null);
                fill(vVar, this.mLayoutState, a0Var, r4);
            } else {
                list = null;
            }
            this.mLayoutState.k = list;
        }
        if (a0Var.g) {
            aVar.d();
        } else {
            u uVar7 = this.mOrientationHelper;
            uVar7.b = uVar7.l();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.a0 a0Var) {
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        this.mAnchorInfo.d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            d dVar = (d) parcelable;
            this.mPendingSavedState = dVar;
            if (this.mPendingScrollPosition != -1) {
                dVar.b = -1;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final Parcelable onSaveInstanceState() {
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (getChildCount() <= 0) {
            dVar2.b = -1;
            return dVar2;
        }
        ensureLayoutState();
        boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
        dVar2.d = z;
        if (z) {
            View childClosestToEnd = getChildClosestToEnd();
            dVar2.c = this.mOrientationHelper.g() - this.mOrientationHelper.b(childClosestToEnd);
            dVar2.b = RecyclerView.o.getPosition(childClosestToEnd);
            return dVar2;
        }
        View childClosestToStart = getChildClosestToStart();
        dVar2.b = RecyclerView.o.getPosition(childClosestToStart);
        dVar2.c = this.mOrientationHelper.e(childClosestToStart) - this.mOrientationHelper.k();
        return dVar2;
    }

    public final void recycleByLayoutState(RecyclerView.v vVar, c cVar) {
        if (!cVar.a || cVar.l) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f == -1) {
            int childCount = getChildCount();
            if (i < 0) {
                return;
            }
            int iF = (this.mOrientationHelper.f() - i) + i2;
            if (this.mShouldReverseLayout) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (this.mOrientationHelper.e(childAt) < iF || this.mOrientationHelper.n(childAt) < iF) {
                        recycleChildren(vVar, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = childCount - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View childAt2 = getChildAt(i5);
                if (this.mOrientationHelper.e(childAt2) < iF || this.mOrientationHelper.n(childAt2) < iF) {
                    recycleChildren(vVar, i4, i5);
                    return;
                }
            }
            return;
        }
        if (i < 0) {
            return;
        }
        int i6 = i - i2;
        int childCount2 = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i7 = 0; i7 < childCount2; i7++) {
                View childAt3 = getChildAt(i7);
                if (this.mOrientationHelper.b(childAt3) > i6 || this.mOrientationHelper.m(childAt3) > i6) {
                    recycleChildren(vVar, 0, i7);
                    return;
                }
            }
            return;
        }
        int i8 = childCount2 - 1;
        for (int i9 = i8; i9 >= 0; i9--) {
            View childAt4 = getChildAt(i9);
            if (this.mOrientationHelper.b(childAt4) > i6 || this.mOrientationHelper.m(childAt4) > i6) {
                recycleChildren(vVar, i8, i9);
                return;
            }
        }
    }

    public final void recycleChildren(RecyclerView.v vVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, vVar);
                i--;
            }
        } else {
            while (true) {
                i2--;
                if (i2 < i) {
                    return;
                } else {
                    removeAndRecycleViewAt(i2, vVar);
                }
            }
        }
    }

    public final void resolveShouldLayoutReverse() {
        this.mShouldReverseLayout = (this.mOrientation == 1 || !isLayoutRTL()) ? this.mReverseLayout : !this.mReverseLayout;
    }

    public final int scrollBy(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (getChildCount() != 0 && i != 0) {
            ensureLayoutState();
            this.mLayoutState.a = true;
            int i2 = i > 0 ? 1 : -1;
            int iAbs = Math.abs(i);
            updateLayoutState(i2, iAbs, true, a0Var);
            c cVar = this.mLayoutState;
            int iFill = fill(vVar, cVar, a0Var, false) + cVar.g;
            if (iFill >= 0) {
                if (iAbs > iFill) {
                    i = i2 * iFill;
                }
                this.mOrientationHelper.o(-i);
                this.mLayoutState.j = i;
                return i;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.b = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, vVar, a0Var);
    }

    public final void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(ak.h(i, "invalid orientation:"));
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.mOrientation || this.mOrientationHelper == null) {
            u uVarA = u.a(this, i);
            this.mOrientationHelper = uVarA;
            this.mAnchorInfo.a = uVarA;
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean shouldMeasureTwice() {
        if (this.mHeightMode != 1073741824 && this.mWidthMode != 1073741824) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, int i) {
        q qVar = new q(recyclerView.getContext());
        qVar.mTargetPosition = i;
        startSmoothScroll(qVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public final void updateLayoutState(int i, int i2, boolean z, RecyclerView.a0 a0Var) {
        int iK;
        this.mLayoutState.l = this.mOrientationHelper.i() == 0 && this.mOrientationHelper.f() == 0;
        this.mLayoutState.f = i;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(a0Var, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z2 = i == 1;
        c cVar = this.mLayoutState;
        int i3 = z2 ? iMax2 : iMax;
        cVar.h = i3;
        if (!z2) {
            iMax = iMax2;
        }
        cVar.i = iMax;
        if (z2) {
            cVar.h = this.mOrientationHelper.h() + i3;
            View childClosestToEnd = getChildClosestToEnd();
            c cVar2 = this.mLayoutState;
            cVar2.e = this.mShouldReverseLayout ? -1 : 1;
            int position = RecyclerView.o.getPosition(childClosestToEnd);
            c cVar3 = this.mLayoutState;
            cVar2.d = position + cVar3.e;
            cVar3.b = this.mOrientationHelper.b(childClosestToEnd);
            iK = this.mOrientationHelper.b(childClosestToEnd) - this.mOrientationHelper.g();
        } else {
            View childClosestToStart = getChildClosestToStart();
            c cVar4 = this.mLayoutState;
            cVar4.h = this.mOrientationHelper.k() + cVar4.h;
            c cVar5 = this.mLayoutState;
            cVar5.e = this.mShouldReverseLayout ? 1 : -1;
            int position2 = RecyclerView.o.getPosition(childClosestToStart);
            c cVar6 = this.mLayoutState;
            cVar5.d = position2 + cVar6.e;
            cVar6.b = this.mOrientationHelper.e(childClosestToStart);
            iK = (-this.mOrientationHelper.e(childClosestToStart)) + this.mOrientationHelper.k();
        }
        c cVar7 = this.mLayoutState;
        cVar7.c = i2;
        if (z) {
            cVar7.c = i2 - iK;
        }
        cVar7.g = iK;
    }

    public final void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.c = this.mOrientationHelper.g() - i2;
        c cVar = this.mLayoutState;
        cVar.e = this.mShouldReverseLayout ? -1 : 1;
        cVar.d = i;
        cVar.f = 1;
        cVar.b = i2;
        cVar.g = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
    }

    public final void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.c = i2 - this.mOrientationHelper.k();
        c cVar = this.mLayoutState;
        cVar.d = i;
        cVar.e = this.mShouldReverseLayout ? 1 : -1;
        cVar.f = -1;
        cVar.b = i2;
        cVar.g = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
    }
}
