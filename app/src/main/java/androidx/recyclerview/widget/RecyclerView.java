package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.preference.Preference;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.a1;
import defpackage.ak;
import defpackage.dk0;
import defpackage.ek0;
import defpackage.o01;
import defpackage.o1;
import defpackage.qd1;
import defpackage.qf0;
import defpackage.t71;
import defpackage.ud1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements dk0 {
    public static final Class[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    public static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    public static final c sQuinticInterpolator;
    public androidx.recyclerview.widget.x mAccessibilityDelegate;
    public final AccessibilityManager mAccessibilityManager;
    public g mAdapter;
    public final androidx.recyclerview.widget.a mAdapterHelper;
    public boolean mAdapterUpdateDuringMeasure;
    public EdgeEffect mBottomGlow;
    public final androidx.recyclerview.widget.b mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    public int mDispatchScrollCounter;
    public int mEatenAccessibilityChangeFlags;
    public final k mEdgeEffectFactory;
    public boolean mFirstLayoutComplete;
    public androidx.recyclerview.widget.m mGapWorker;
    public boolean mHasFixedSize;
    public boolean mIgnoreMotionEventTillDown;
    public int mInitialTouchX;
    public int mInitialTouchY;
    public int mInterceptRequestLayoutDepth;
    public s mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public final androidx.recyclerview.widget.k mItemAnimator;
    public final b mItemAnimatorRunner;
    public final ArrayList mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    public int mLastAutoMeasureNonExactMeasuredHeight;
    public int mLastAutoMeasureNonExactMeasuredWidth;
    public boolean mLastAutoMeasureSkippedDueToExact;
    public int mLastTouchX;
    public int mLastTouchY;
    public o mLayout;
    public int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    public EdgeEffect mLeftGlow;
    public final int mMaxFlingVelocity;
    public final int mMinFlingVelocity;
    public final int[] mMinMaxLayoutPositions;
    public final int[] mNestedOffsets;
    public final x mObserver;
    public androidx.recyclerview.widget.w mOnFlingListener;
    public final ArrayList mOnItemTouchListeners;
    public final ArrayList mPendingAccessibilityImportanceChange;
    public y mPendingSavedState;
    public boolean mPostedAnimatorRunner;
    public final androidx.recyclerview.widget.m.b mPrefetchRegistry;
    public final boolean mPreserveFocusAfterLayout;
    public final v mRecycler;
    public final ArrayList mRecyclerListeners;
    public final int[] mReusableIntPair;
    public EdgeEffect mRightGlow;
    public final float mScaledHorizontalScrollFactor;
    public final float mScaledVerticalScrollFactor;
    public ArrayList mScrollListeners;
    public final int[] mScrollOffset;
    public int mScrollPointerId;
    public int mScrollState;
    public ek0 mScrollingChildHelper;
    public final a0 mState;
    public final Rect mTempRect;
    public final Rect mTempRect2;
    public final RectF mTempRectF;
    public EdgeEffect mTopGlow;
    public final int mTouchSlop;
    public final a mUpdateChildViewsRunnable;
    public VelocityTracker mVelocityTracker;
    public final c0 mViewFlinger;
    public final d mViewInfoProcessCallback;
    public final androidx.recyclerview.widget.c0 mViewInfoStore;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                return;
            }
            if (!recyclerView.mIsAttached) {
                recyclerView.requestLayout();
            } else if (recyclerView.mLayoutSuppressed) {
                recyclerView.mLayoutWasDefered = true;
            } else {
                recyclerView.consumePendingUpdateOperations();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a0 {
        public int a = -1;
        public int b = 0;
        public int c = 0;
        public int d = 1;
        public int e = 0;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public int l;
        public long m;
        public int n;

        public final void a(int i) {
            if ((this.d & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.d));
        }

        public final int b() {
            return this.g ? this.b - this.c : this.e;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.a + ", mData=null, mItemCount=" + this.e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.c + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.j + ", mRunPredictiveAnimations=" + this.k + '}';
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements Runnable {
        public b() {
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0028  */
        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            long j;
            RecyclerView recyclerView = RecyclerView.this;
            androidx.recyclerview.widget.k kVar = recyclerView.mItemAnimator;
            if (kVar != null) {
                ArrayList arrayList = kVar.h;
                boolean zIsEmpty = arrayList.isEmpty();
                ArrayList arrayList2 = kVar.j;
                boolean zIsEmpty2 = arrayList2.isEmpty();
                ArrayList arrayList3 = kVar.k;
                boolean zIsEmpty3 = arrayList3.isEmpty();
                ArrayList arrayList4 = kVar.i;
                boolean zIsEmpty4 = arrayList4.isEmpty();
                if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
                    z = false;
                } else {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        boolean zHasNext = it.hasNext();
                        j = kVar.d;
                        if (!zHasNext) {
                            break;
                        }
                        d0 d0Var = (d0) it.next();
                        View view = d0Var.itemView;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        kVar.q.add(d0Var);
                        viewPropertyAnimatorAnimate.setDuration(j).alpha(0.0f).setListener(new androidx.recyclerview.widget.f(view, viewPropertyAnimatorAnimate, kVar, d0Var)).start();
                        arrayList = arrayList;
                    }
                    arrayList.clear();
                    if (!zIsEmpty2) {
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.addAll(arrayList2);
                        kVar.m.add(arrayList5);
                        arrayList2.clear();
                        androidx.recyclerview.widget.c cVar = new androidx.recyclerview.widget.c(kVar, arrayList5);
                        if (zIsEmpty) {
                            cVar.run();
                        } else {
                            View view2 = ((androidx.recyclerview.widget.k.b) arrayList5.get(0)).a.itemView;
                            WeakHashMap weakHashMap = qd1.a;
                            view2.postOnAnimationDelayed(cVar, j);
                        }
                    }
                    if (!zIsEmpty3) {
                        ArrayList arrayList6 = new ArrayList();
                        arrayList6.addAll(arrayList3);
                        kVar.n.add(arrayList6);
                        arrayList3.clear();
                        androidx.recyclerview.widget.d dVar = new androidx.recyclerview.widget.d(kVar, arrayList6);
                        if (zIsEmpty) {
                            dVar.run();
                        } else {
                            View view3 = ((androidx.recyclerview.widget.k.a) arrayList6.get(0)).a.itemView;
                            WeakHashMap weakHashMap2 = qd1.a;
                            view3.postOnAnimationDelayed(dVar, j);
                        }
                    }
                    if (zIsEmpty4) {
                        z = false;
                    } else {
                        ArrayList arrayList7 = new ArrayList();
                        arrayList7.addAll(arrayList4);
                        kVar.l.add(arrayList7);
                        arrayList4.clear();
                        androidx.recyclerview.widget.e eVar = new androidx.recyclerview.widget.e(kVar, arrayList7);
                        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
                            eVar.run();
                            z = false;
                        } else {
                            if (zIsEmpty) {
                                j = 0;
                            }
                            long jMax = Math.max(!zIsEmpty2 ? kVar.e : 0L, zIsEmpty3 ? 0L : kVar.f) + j;
                            z = false;
                            View view4 = ((d0) arrayList7.get(0)).itemView;
                            WeakHashMap weakHashMap3 = qd1.a;
                            view4.postOnAnimationDelayed(eVar, jMax);
                        }
                    }
                }
            } else {
                z = false;
            }
            recyclerView.mPostedAnimatorRunner = z;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class b0 {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c0 implements Runnable {
        public int b;
        public int c;
        public OverScroller d;
        public Interpolator f;
        public boolean g;
        public boolean i;

        public c0() {
            c cVar = RecyclerView.sQuinticInterpolator;
            this.f = cVar;
            this.g = false;
            this.i = false;
            this.d = new OverScroller(RecyclerView.this.getContext(), cVar);
        }

        public final void a() {
            if (this.g) {
                this.i = true;
                return;
            }
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = qd1.a;
            recyclerView.postOnAnimation(this);
        }

        public final void b(int i, int i2, BaseInterpolator baseInterpolator, int i3) {
            RecyclerView recyclerView = RecyclerView.this;
            if (i3 == Integer.MIN_VALUE) {
                int iAbs = Math.abs(i);
                int iAbs2 = Math.abs(i2);
                boolean z = iAbs > iAbs2;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                if (!z) {
                    iAbs = iAbs2;
                }
                i3 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
            }
            int i4 = i3;
            Interpolator interpolator = baseInterpolator;
            if (baseInterpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f != interpolator) {
                this.f = interpolator;
                this.d = new OverScroller(recyclerView.getContext(), interpolator);
            }
            this.c = 0;
            this.b = 0;
            recyclerView.setScrollState(2);
            this.d.startScroll(0, 0, i, i2, i4);
            a();
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            RecyclerView recyclerView = RecyclerView.this;
            o oVar = recyclerView.mLayout;
            int[] iArr = recyclerView.mReusableIntPair;
            if (oVar == null) {
                recyclerView.removeCallbacks(this);
                this.d.abortAnimation();
                return;
            }
            this.i = false;
            this.g = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i7 = currX - this.b;
                int i8 = currY - this.c;
                this.b = currX;
                this.c = currY;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView.getScrollingChildHelper().c(i7, i8, iArr, null, 1)) {
                    int i9 = i7 - iArr[0];
                    i = i8 - iArr[1];
                    i2 = i9;
                } else {
                    i = i8;
                    i2 = i7;
                }
                if (recyclerView.getOverScrollMode() != 2) {
                    recyclerView.considerReleasingGlowsOnScroll(i2, i);
                }
                if (recyclerView.mAdapter != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    recyclerView.scrollStep(i2, i, iArr);
                    int i10 = iArr[0];
                    int i11 = iArr[1];
                    int i12 = i2 - i10;
                    i -= i11;
                    androidx.recyclerview.widget.q qVar = recyclerView.mLayout.mSmoothScroller;
                    if (qVar != null && !qVar.mPendingInitialRun && qVar.mRunning) {
                        int iB = recyclerView.mState.b();
                        if (iB == 0) {
                            qVar.stop();
                        } else {
                            if (qVar.mTargetPosition >= iB) {
                                qVar.mTargetPosition = iB - 1;
                            }
                            qVar.onAnimation(i10, i11);
                        }
                    }
                    i4 = i12;
                    i5 = i11;
                    i3 = i10;
                } else {
                    i3 = 0;
                    i4 = i2;
                    i5 = 0;
                }
                if (!recyclerView.mItemDecorations.isEmpty()) {
                    recyclerView.invalidate();
                }
                iArr[0] = 0;
                iArr[1] = 0;
                recyclerView.getScrollingChildHelper().e(i3, i5, i4, i, null, 1, iArr);
                int i13 = i4 - iArr[0];
                int i14 = i - iArr[1];
                if (i3 != 0 || i5 != 0) {
                    recyclerView.dispatchOnScrolled(i3, i5);
                }
                if (!recyclerView.awakenScrollBars()) {
                    recyclerView.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i13 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i14 != 0));
                androidx.recyclerview.widget.q qVar2 = recyclerView.mLayout.mSmoothScroller;
                if ((qVar2 == null || !qVar2.mPendingInitialRun) && z) {
                    if (recyclerView.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i13 < 0) {
                            i6 = -currVelocity;
                        } else {
                            i6 = i13 > 0 ? currVelocity : 0;
                        }
                        if (i14 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i14 <= 0) {
                            currVelocity = 0;
                        }
                        if (i6 < 0) {
                            recyclerView.ensureLeftGlow();
                            if (recyclerView.mLeftGlow.isFinished()) {
                                recyclerView.mLeftGlow.onAbsorb(-i6);
                            }
                        } else if (i6 > 0) {
                            recyclerView.ensureRightGlow();
                            if (recyclerView.mRightGlow.isFinished()) {
                                recyclerView.mRightGlow.onAbsorb(i6);
                            }
                        }
                        if (currVelocity < 0) {
                            recyclerView.ensureTopGlow();
                            if (recyclerView.mTopGlow.isFinished()) {
                                recyclerView.mTopGlow.onAbsorb(-currVelocity);
                            }
                        } else if (currVelocity > 0) {
                            recyclerView.ensureBottomGlow();
                            if (recyclerView.mBottomGlow.isFinished()) {
                                recyclerView.mBottomGlow.onAbsorb(currVelocity);
                            }
                        }
                        if (i6 != 0 || currVelocity != 0) {
                            WeakHashMap weakHashMap = qd1.a;
                            recyclerView.postInvalidateOnAnimation();
                        }
                    }
                    androidx.recyclerview.widget.m.b bVar = recyclerView.mPrefetchRegistry;
                    int[] iArr2 = bVar.c;
                    if (iArr2 != null) {
                        Arrays.fill(iArr2, -1);
                    }
                    bVar.d = 0;
                } else {
                    a();
                    androidx.recyclerview.widget.m mVar = recyclerView.mGapWorker;
                    if (mVar != null) {
                        mVar.a(recyclerView, i3, i5);
                    }
                }
            }
            androidx.recyclerview.widget.q qVar3 = recyclerView.mLayout.mSmoothScroller;
            if (qVar3 != null && qVar3.mPendingInitialRun) {
                qVar3.onAnimation(0, 0);
            }
            this.g = false;
            if (!this.i) {
                recyclerView.setScrollState(0);
                recyclerView.getScrollingChildHelper().h(1);
            } else {
                recyclerView.removeCallbacks(this);
                WeakHashMap weakHashMap2 = qd1.a;
                recyclerView.postOnAnimation(this);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d implements androidx.recyclerview.widget.c0.b {
        public d() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class d0 {
        public static final List FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        public final View itemView;
        public g mBindingAdapter;
        public int mFlags;
        public WeakReference mNestedRecyclerView;
        public RecyclerView mOwnerRecyclerView;
        public int mPosition = -1;
        public int mOldPosition = -1;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public int mPreLayoutPosition = -1;
        public d0 mShadowedHolder = null;
        public d0 mShadowingHolder = null;
        public ArrayList mPayloads = null;
        public List mUnmodifiedPayloads = null;
        public int mIsRecyclableCount = 0;
        public v mScrapContainer = null;
        public boolean mInChangeScrap = false;
        public int mWasImportantForAccessibilityBeforeHidden = 0;
        public int mPendingAccessibilityState = -1;

        public d0(View view) {
            if (view != null) {
                this.itemView = view;
            } else {
                defpackage.d.AnonymousClass0.m$2("itemView may not be null");
                throw null;
            }
        }

        public final void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public final void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final List getUnmodifiedPayloads() {
            ArrayList arrayList;
            return ((this.mFlags & 1024) != 0 || (arrayList = this.mPayloads) == null || arrayList.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        public final boolean isAttachedToTransitionOverlay() {
            View view = this.itemView;
            return (view.getParent() == null || view.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        public final boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public final boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) != 0) {
                return false;
            }
            WeakHashMap weakHashMap = qd1.a;
            return !this.itemView.hasTransientState();
        }

        public final boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public final boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public final boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public final boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public final void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            View view = this.itemView;
            if (view.getLayoutParams() != null) {
                ((p) view.getLayoutParams()).c = true;
            }
        }

        public final void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            ArrayList arrayList = this.mPayloads;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.mFlags &= -1025;
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public final void setIsRecyclable(boolean z) {
            int i;
            int i2 = this.mIsRecyclableCount;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.mIsRecyclableCount = i3;
            if (i3 < 0) {
                this.mIsRecyclableCount = 0;
                toString();
                return;
            }
            if (!z && i3 == 1) {
                i = this.mFlags | 16;
            } else if (!z || i3 != 0) {
                return;
            } else {
                i = this.mFlags & (-17);
            }
            this.mFlags = i;
        }

        public final boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public final String toString() {
            StringBuilder sbO = ak.o(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
            sbO.append(Integer.toHexString(hashCode()));
            sbO.append(" position=");
            sbO.append(this.mPosition);
            sbO.append(" id=");
            sbO.append(this.mItemId);
            sbO.append(", oldPos=");
            sbO.append(this.mOldPosition);
            sbO.append(", pLpos:");
            sbO.append(this.mPreLayoutPosition);
            StringBuilder sb = new StringBuilder(sbO.toString());
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if ((this.mFlags & 2) != 0) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if ((this.mFlags & 512) != 0 || isInvalid()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class e implements androidx.recyclerview.widget.b.InterfaceC0026b {
        public e() {
        }

        public final void b(int i) {
            RecyclerView recyclerView = RecyclerView.this;
            View childAt = recyclerView.getChildAt(i);
            if (childAt != null) {
                RecyclerView.getChildViewHolderInt(childAt);
                childAt.clearAnimation();
            }
            recyclerView.removeViewAt(i);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class f implements androidx.recyclerview.widget.a.InterfaceC0025a {
        public f() {
        }

        public final void a(androidx.recyclerview.widget.a.b bVar) {
            int i = bVar.a;
            RecyclerView recyclerView = RecyclerView.this;
            if (i == 1) {
                recyclerView.mLayout.onItemsAdded(bVar.b, bVar.d);
                return;
            }
            if (i == 2) {
                recyclerView.mLayout.onItemsRemoved(bVar.b, bVar.d);
            } else if (i == 4) {
                recyclerView.mLayout.onItemsUpdated(bVar.b, bVar.d);
            } else {
                if (i != 8) {
                    return;
                }
                recyclerView.mLayout.onItemsMoved(bVar.b, bVar.d);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class g<VH extends d0> {
        public final h mObservable = new h();
        public boolean mHasStableIds = false;
        public final a mStateRestorationPolicy = a.ALLOW;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public enum a {
            ALLOW,
            /* JADX INFO: Fake field, exist only in values array */
            PREVENT_WHEN_EMPTY,
            /* JADX INFO: Fake field, exist only in values array */
            PREVENT
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public abstract void onBindViewHolder(d0 d0Var, int i);

        public abstract d0 onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onViewRecycled(d0 d0Var) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class h extends Observable<i> {
        public final boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public final void b() {
            int size = ((Observable) this).mObservers.size();
            while (true) {
                size--;
                if (size < 0) {
                    return;
                } else {
                    ((i) ((Observable) this).mObservers.get(size)).onChanged();
                }
            }
        }

        public final void d(int i, Preference preference) {
            int size = ((Observable) this).mObservers.size();
            while (true) {
                size--;
                if (size < 0) {
                    return;
                } else {
                    ((i) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, preference);
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class i {
        public void onChanged() {
        }

        public void onItemRangeChanged() {
        }

        public void onItemRangeChanged(int i, Preference preference) {
            onItemRangeChanged();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface j {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class k {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class l {
        public m a = null;
        public final ArrayList b = new ArrayList();
        public final long c = 120;
        public final long d = 120;
        public final long e = 250;
        public final long f = 250;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public interface a {
            void a();
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public interface b {
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class c {
            public int a;
            public int b;

            public final void a(d0 d0Var) {
                View view = d0Var.itemView;
                this.a = view.getLeft();
                this.b = view.getTop();
                view.getRight();
                view.getBottom();
            }
        }

        public static void b(d0 d0Var) {
            RecyclerView recyclerView;
            int i = d0Var.mFlags;
            if (d0Var.isInvalid() || (i & 4) != 0 || (recyclerView = d0Var.mOwnerRecyclerView) == null) {
                return;
            }
            recyclerView.getAdapterPositionInRecyclerView(d0Var);
        }

        public final void c(d0 d0Var) {
            m mVar = this.a;
            if (mVar != null) {
                boolean z = true;
                d0Var.setIsRecyclable(true);
                View view = d0Var.itemView;
                if (d0Var.mShadowedHolder != null && d0Var.mShadowingHolder == null) {
                    d0Var.mShadowedHolder = null;
                }
                d0Var.mShadowingHolder = null;
                if ((d0Var.mFlags & 16) != 0) {
                    return;
                }
                RecyclerView recyclerView = RecyclerView.this;
                v vVar = recyclerView.mRecycler;
                recyclerView.startInterceptRequestLayout();
                androidx.recyclerview.widget.b bVar = recyclerView.mChildHelper;
                e eVar = bVar.a;
                int iIndexOfChild = RecyclerView.this.indexOfChild(view);
                if (iIndexOfChild == -1) {
                    bVar.m(view);
                } else {
                    androidx.recyclerview.widget.b.a aVar = bVar.b;
                    if (aVar.d(iIndexOfChild)) {
                        aVar.f(iIndexOfChild);
                        bVar.m(view);
                        eVar.b(iIndexOfChild);
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                    vVar.k(childViewHolderInt);
                    vVar.h(childViewHolderInt);
                }
                recyclerView.stopInterceptRequestLayout(!z);
                if (z || !d0Var.isTmpDetached()) {
                    return;
                }
                recyclerView.removeDetachedView(view, false);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class m implements l.b {
        public m() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class n {
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView) {
            ((p) view.getLayoutParams()).a.getClass();
            rect.set(0, 0, 0, 0);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class o {
        public androidx.recyclerview.widget.b mChildHelper;
        public int mHeight;
        public int mHeightMode;
        public final androidx.recyclerview.widget.b0 mHorizontalBoundCheck;
        public boolean mIsAttachedToWindow;
        public final boolean mItemPrefetchEnabled;
        public final boolean mMeasurementCacheEnabled;
        public int mPrefetchMaxCountObserved;
        public boolean mPrefetchMaxObservedInInitialPrefetch;
        public RecyclerView mRecyclerView;
        public boolean mRequestedSimpleAnimations;
        public androidx.recyclerview.widget.q mSmoothScroller;
        public final androidx.recyclerview.widget.b0 mVerticalBoundCheck;
        public int mWidth;
        public int mWidthMode;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements androidx.recyclerview.widget.b0.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.b0.b
            public final int a(View view) {
                p pVar = (p) view.getLayoutParams();
                o.this.getClass();
                return o.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin;
            }

            @Override // androidx.recyclerview.widget.b0.b
            public final int b() {
                return o.this.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.b0.b
            public final int c() {
                o oVar = o.this;
                return oVar.mWidth - oVar.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.b0.b
            public final View d(int i) {
                return o.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.b0.b
            public final int e(View view) {
                p pVar = (p) view.getLayoutParams();
                o.this.getClass();
                return o.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class b implements androidx.recyclerview.widget.b0.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.b0.b
            public final int a(View view) {
                p pVar = (p) view.getLayoutParams();
                o.this.getClass();
                return o.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin;
            }

            @Override // androidx.recyclerview.widget.b0.b
            public final int b() {
                return o.this.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.b0.b
            public final int c() {
                o oVar = o.this;
                return oVar.mHeight - oVar.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.b0.b
            public final View d(int i) {
                return o.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.b0.b
            public final int e(View view) {
                p pVar = (p) view.getLayoutParams();
                o.this.getClass();
                return o.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public interface c {
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class d {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public o() {
            a aVar = new a();
            b bVar = new b();
            this.mHorizontalBoundCheck = new androidx.recyclerview.widget.b0(aVar);
            this.mVerticalBoundCheck = new androidx.recyclerview.widget.b0(bVar);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        /* JADX WARN: Code duplicated, block: B:12:0x001b  */
        /* JADX WARN: Code duplicated, block: B:14:0x001f  */
        /* JADX WARN: Code duplicated, block: B:22:0x002f  */
        public static int getChildMeasureSpec(boolean z, int i, int i2, int i3, int i4) {
            int iMax = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i2 = 1073741824;
                } else if (i4 != -1 || (i2 != Integer.MIN_VALUE && (i2 == 0 || i2 != 1073741824))) {
                    i2 = 0;
                    i4 = 0;
                } else {
                    i4 = iMax;
                }
            } else if (i4 >= 0) {
                i2 = 1073741824;
            } else if (i4 == -1) {
                i4 = iMax;
            } else if (i4 != -2) {
                i2 = 0;
                i4 = 0;
            } else if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                i4 = iMax;
                i2 = Integer.MIN_VALUE;
            } else {
                i4 = iMax;
                i2 = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        public static int getDecoratedBottom(View view) {
            return ((p) view.getLayoutParams()).b.bottom + view.getBottom();
        }

        public static int getDecoratedLeft(View view) {
            return view.getLeft() - ((p) view.getLayoutParams()).b.left;
        }

        public static int getDecoratedRight(View view) {
            return ((p) view.getLayoutParams()).b.right + view.getRight();
        }

        public static int getDecoratedTop(View view) {
            return view.getTop() - ((p) view.getLayoutParams()).b.top;
        }

        public static int getPosition(View view) {
            return ((p) view.getLayoutParams()).a.getLayoutPosition();
        }

        public static d getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, defpackage.e.f25b, i, i2);
            dVar.a = typedArrayObtainStyledAttributes.getInt(0, 1);
            dVar.b = typedArrayObtainStyledAttributes.getInt(10, 1);
            dVar.c = typedArrayObtainStyledAttributes.getBoolean(9, false);
            dVar.d = typedArrayObtainStyledAttributes.getBoolean(11, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public static void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0064  */
        public final void addViewInt(View view, int i, boolean z) {
            int iB;
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                o01 o01Var = this.mRecyclerView.mViewInfoStore.a;
                androidx.recyclerview.widget.c0.a aVarA = (androidx.recyclerview.widget.c0.a) o01Var.getOrDefault(childViewHolderInt, null);
                if (aVarA == null) {
                    aVarA = androidx.recyclerview.widget.c0.a.a();
                    o01Var.put(childViewHolderInt, aVarA);
                }
                aVarA.a |= 1;
            } else {
                this.mRecyclerView.mViewInfoStore.c(childViewHolderInt);
            }
            p pVar = (p) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.mScrapContainer.k(childViewHolderInt);
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.b(view, i, view.getLayoutParams(), false);
            } else {
                ViewParent parent = view.getParent();
                RecyclerView recyclerView = this.mRecyclerView;
                androidx.recyclerview.widget.b bVar = this.mChildHelper;
                if (parent == recyclerView) {
                    int iIndexOfChild = RecyclerView.this.indexOfChild(view);
                    if (iIndexOfChild == -1) {
                        iB = -1;
                    } else {
                        androidx.recyclerview.widget.b.a aVar = bVar.b;
                        if (aVar.d(iIndexOfChild)) {
                            iB = -1;
                        } else {
                            iB = iIndexOfChild - aVar.b(iIndexOfChild);
                        }
                    }
                    if (i == -1) {
                        i = this.mChildHelper.e();
                    }
                    if (iB == -1) {
                        StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        sb.append(this.mRecyclerView.indexOfChild(view));
                        throw new IllegalStateException(defpackage.e.h(this.mRecyclerView, sb));
                    }
                    if (iB != i) {
                        o oVar = this.mRecyclerView.mLayout;
                        View childAt = oVar.getChildAt(iB);
                        if (childAt == null) {
                            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iB + oVar.mRecyclerView.toString());
                        }
                        oVar.getChildAt(iB);
                        oVar.mChildHelper.c(iB);
                        p pVar2 = (p) childAt.getLayoutParams();
                        d0 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(childAt);
                        boolean zIsRemoved = childViewHolderInt2.isRemoved();
                        RecyclerView recyclerView2 = oVar.mRecyclerView;
                        if (zIsRemoved) {
                            o01 o01Var2 = recyclerView2.mViewInfoStore.a;
                            androidx.recyclerview.widget.c0.a aVarA2 = (androidx.recyclerview.widget.c0.a) o01Var2.getOrDefault(childViewHolderInt2, null);
                            if (aVarA2 == null) {
                                aVarA2 = androidx.recyclerview.widget.c0.a.a();
                                o01Var2.put(childViewHolderInt2, aVarA2);
                            }
                            aVarA2.a = 1 | aVarA2.a;
                        } else {
                            recyclerView2.mViewInfoStore.c(childViewHolderInt2);
                        }
                        oVar.mChildHelper.b(childAt, i, pVar2, childViewHolderInt2.isRemoved());
                    }
                } else {
                    bVar.a(view, i, false);
                    pVar.c = true;
                    androidx.recyclerview.widget.q qVar = this.mSmoothScroller;
                    if (qVar != null && qVar.mRunning) {
                        qVar.mRecyclerView.getClass();
                        d0 childViewHolderInt3 = RecyclerView.getChildViewHolderInt(view);
                        if ((childViewHolderInt3 != null ? childViewHolderInt3.getLayoutPosition() : -1) == qVar.mTargetPosition) {
                            qVar.mTargetView = view;
                        }
                    }
                }
            }
            if (pVar.d) {
                childViewHolderInt.itemView.invalidate();
                pVar.d = false;
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(p pVar) {
            return pVar != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, a0 a0Var, androidx.recyclerview.widget.m.b bVar) {
        }

        public void collectInitialPrefetchPositions(int i, androidx.recyclerview.widget.m.b bVar) {
        }

        public int computeHorizontalScrollExtent(a0 a0Var) {
            return 0;
        }

        public int computeHorizontalScrollOffset(a0 a0Var) {
            return 0;
        }

        public int computeHorizontalScrollRange(a0 a0Var) {
            return 0;
        }

        public int computeVerticalScrollExtent(a0 a0Var) {
            return 0;
        }

        public int computeVerticalScrollOffset(a0 a0Var) {
            return 0;
        }

        public int computeVerticalScrollRange(a0 a0Var) {
            return 0;
        }

        public final void detachAndScrapAttachedViews(v vVar) {
            int childCount = getChildCount();
            while (true) {
                childCount--;
                if (childCount < 0) {
                    return;
                }
                View childAt = getChildAt(childCount);
                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (!childViewHolderInt.shouldIgnore()) {
                    if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.mHasStableIds) {
                        getChildAt(childCount);
                        this.mChildHelper.c(childCount);
                        vVar.i(childAt);
                        this.mRecyclerView.mViewInfoStore.c(childViewHolderInt);
                    } else {
                        removeViewAt(childCount);
                        vVar.h(childViewHolderInt);
                    }
                }
            }
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.g || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract p generateDefaultLayoutParams();

        public p generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public p generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof p) {
                return new p((p) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public final View getChildAt(int i) {
            androidx.recyclerview.widget.b bVar = this.mChildHelper;
            if (bVar != null) {
                return bVar.d(i);
            }
            return null;
        }

        public final int getChildCount() {
            androidx.recyclerview.widget.b bVar = this.mChildHelper;
            if (bVar != null) {
                return bVar.e();
            }
            return 0;
        }

        public int getColumnCountForAccessibility(v vVar, a0 a0Var) {
            return -1;
        }

        public final int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public final int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public final int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public final int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getRowCountForAccessibility(v vVar, a0 a0Var) {
            return -1;
        }

        public final void getTransformedBoundingBox(View view, Rect rect) {
            Matrix matrix;
            Rect rect2 = ((p) view.getLayoutParams()).b;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean isAutoMeasureEnabled() {
            return false;
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                int iE = recyclerView.mChildHelper.e();
                for (int i2 = 0; i2 < iE; i2++) {
                    recyclerView.mChildHelper.d(i2).offsetLeftAndRight(i);
                }
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                int iE = recyclerView.mChildHelper.e();
                for (int i2 = 0; i2 < iE; i2++) {
                    recyclerView.mChildHelper.d(i2).offsetTopAndBottom(i);
                }
            }
        }

        public void onAdapterChanged() {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int i, v vVar, a0 a0Var) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            v vVar = recyclerView.mRecycler;
            if (accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            g gVar = this.mRecyclerView.mAdapter;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.getItemCount());
            }
        }

        public final void onInitializeAccessibilityNodeInfoForItem(View view, o1 o1Var) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved()) {
                return;
            }
            androidx.recyclerview.widget.b bVar = this.mChildHelper;
            if (bVar.c.contains(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, o1Var);
        }

        public void onInitializeAccessibilityNodeInfoForItem(v vVar, a0 a0Var, View view, o1 o1Var) {
        }

        public void onItemsAdded(int i, int i2) {
        }

        public void onItemsChanged() {
        }

        public void onItemsMoved(int i, int i2) {
        }

        public void onItemsRemoved(int i, int i2) {
        }

        public void onItemsUpdated(int i, int i2) {
        }

        public void onLayoutChildren(v vVar, a0 a0Var) {
        }

        public void onLayoutCompleted(a0 a0Var) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public final void removeAndRecycleAllViews(v vVar) {
            int childCount = getChildCount();
            while (true) {
                childCount--;
                if (childCount < 0) {
                    return;
                }
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, vVar);
                }
            }
        }

        public final void removeAndRecycleScrapInt(v vVar) {
            ArrayList arrayList;
            int size = vVar.a.size();
            int i = size - 1;
            while (true) {
                arrayList = vVar.a;
                if (i < 0) {
                    break;
                }
                View view = ((d0) arrayList.get(i)).itemView;
                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    androidx.recyclerview.widget.k kVar = this.mRecyclerView.mItemAnimator;
                    if (kVar != null) {
                        kVar.d(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    d0 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt2.mScrapContainer = null;
                    childViewHolderInt2.mInChangeScrap = false;
                    childViewHolderInt2.clearReturnedFromScrapFlag();
                    vVar.h(childViewHolderInt2);
                }
                i--;
            }
            arrayList.clear();
            ArrayList arrayList2 = vVar.b;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public final void removeAndRecycleView(View view, v vVar) {
            androidx.recyclerview.widget.b bVar = this.mChildHelper;
            e eVar = bVar.a;
            int iIndexOfChild = RecyclerView.this.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (bVar.b.f(iIndexOfChild)) {
                    bVar.m(view);
                }
                eVar.b(iIndexOfChild);
            }
            vVar.g(view);
        }

        public final void removeAndRecycleViewAt(int i, v vVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            vVar.g(childAt);
        }

        public final void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                androidx.recyclerview.widget.b bVar = this.mChildHelper;
                int iF = bVar.f(i);
                e eVar = bVar.a;
                View childAt = RecyclerView.this.getChildAt(iF);
                if (childAt == null) {
                    return;
                }
                if (bVar.b.f(iF)) {
                    bVar.m(childAt);
                }
                eVar.b(iF);
            }
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:33:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:35:0x00be  */
        public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = this.mWidth - getPaddingRight();
            int paddingBottom = this.mHeight - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - paddingLeft;
            int iMin = Math.min(0, i);
            int i2 = top - paddingTop;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - paddingRight;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - paddingBottom);
            RecyclerView recyclerView2 = this.mRecyclerView;
            WeakHashMap weakHashMap = qd1.a;
            if (recyclerView2.getLayoutDirection() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            int[] iArr = {iMax, iMin2};
            int i4 = iArr[0];
            int i5 = iArr[1];
            if (z2) {
                View focusedChild = recyclerView.getFocusedChild();
                if (focusedChild != null) {
                    int paddingLeft2 = getPaddingLeft();
                    int paddingTop2 = getPaddingTop();
                    int paddingRight2 = this.mWidth - getPaddingRight();
                    int paddingBottom2 = this.mHeight - getPaddingBottom();
                    Rect rect2 = this.mRecyclerView.mTempRect;
                    RecyclerView.getDecoratedBoundsWithMarginsInt(focusedChild, rect2);
                    if (rect2.left - i4 < paddingRight2 && rect2.right - i4 > paddingLeft2 && rect2.top - i5 < paddingBottom2 && rect2.bottom - i5 > paddingTop2) {
                        if (i4 == 0) {
                        }
                        if (z) {
                            recyclerView.scrollBy(i4, i5);
                            return true;
                        }
                        recyclerView.smoothScrollBy(i4, i5, false);
                        return true;
                    }
                }
            } else if (i4 == 0 || i5 != 0) {
                if (z) {
                    recyclerView.scrollBy(i4, i5);
                    return true;
                }
                recyclerView.smoothScrollBy(i4, i5, false);
                return true;
            }
            return false;
        }

        public final void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int scrollHorizontallyBy(int i, v vVar, a0 a0Var) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, v vVar, a0 a0Var) {
            return 0;
        }

        public final void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0) {
                Class[] clsArr = RecyclerView.LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 == 0) {
                Class[] clsArr2 = RecyclerView.LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
            }
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            int paddingRight = getPaddingRight() + getPaddingLeft() + rect.width();
            int paddingBottom = getPaddingBottom() + getPaddingTop() + rect.height();
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap weakHashMap = qd1.a;
            this.mRecyclerView.setMeasuredDimension(chooseSize(i, paddingRight, recyclerView.getMinimumWidth()), chooseSize(i2, paddingBottom, this.mRecyclerView.getMinimumHeight()));
        }

        public final void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                RecyclerView.getDecoratedBoundsWithMarginsInt(childAt, rect);
                int i8 = rect.left;
                if (i8 < i6) {
                    i6 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i5) {
                    i5 = i11;
                }
            }
            this.mRecyclerView.mTempRect.set(i6, i4, i3, i5);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public final void setRecyclerView(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                height = 0;
                this.mWidth = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.mHeight = height;
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public final boolean shouldMeasureChild(View view, int i, int i2, p pVar) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public final boolean shouldReMeasureChild(View view, int i, int i2, p pVar) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, int i) {
        }

        public final void startSmoothScroll(androidx.recyclerview.widget.q qVar) {
            androidx.recyclerview.widget.q qVar2 = this.mSmoothScroller;
            if (qVar2 != null && qVar != qVar2 && qVar2.mRunning) {
                qVar2.stop();
            }
            this.mSmoothScroller = qVar;
            RecyclerView recyclerView = this.mRecyclerView;
            c0 c0Var = recyclerView.mViewFlinger;
            RecyclerView.this.removeCallbacks(c0Var);
            c0Var.d.abortAnimation();
            qVar.mRecyclerView = recyclerView;
            qVar.mLayoutManager = this;
            int i = qVar.mTargetPosition;
            if (i == -1) {
                defpackage.d.AnonymousClass0.m$2("Invalid target position");
                return;
            }
            recyclerView.mState.a = i;
            qVar.mRunning = true;
            qVar.mPendingInitialRun = true;
            qVar.mTargetView = recyclerView.mLayout.findViewByPosition(i);
            qVar.mRecyclerView.mViewFlinger.a();
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class p extends ViewGroup.MarginLayoutParams {
        public d0 a;
        public final Rect b;
        public boolean c;
        public boolean d;

        public p(int i, int i2) {
            super(i, i2);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface q {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class r {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface s {
        void a(MotionEvent motionEvent);

        boolean c(MotionEvent motionEvent);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class t {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class u {
        public final SparseArray a = new SparseArray();
        public int b = 0;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class a {
            public final ArrayList a = new ArrayList();
            public final int b = 5;
            public long c = 0;
            public long d = 0;
        }

        public final a a(int i) {
            SparseArray sparseArray = this.a;
            a aVar = (a) sparseArray.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            sparseArray.put(i, aVar2);
            return aVar2;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class v {
        public final ArrayList a;
        public ArrayList b;
        public final ArrayList c;
        public final List d;
        public final int e;
        public int f;
        public u g;

        public v() {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            this.b = null;
            this.c = new ArrayList();
            this.d = Collections.unmodifiableList(arrayList);
            this.e = 2;
            this.f = 2;
        }

        public final void a(d0 d0Var, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(d0Var);
            View view = d0Var.itemView;
            RecyclerView recyclerView = RecyclerView.this;
            androidx.recyclerview.widget.x xVar = recyclerView.mAccessibilityDelegate;
            ArrayList arrayList = recyclerView.mRecyclerListeners;
            if (xVar != null) {
                a1 itemDelegate = xVar.getItemDelegate();
                qd1.l(view, itemDelegate instanceof androidx.recyclerview.widget.x.a ? (a1) ((androidx.recyclerview.widget.x.a) itemDelegate).b.remove(view) : null);
            }
            if (z) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((w) arrayList.get(i)).a();
                }
                g gVar = recyclerView.mAdapter;
                if (gVar != null) {
                    gVar.onViewRecycled(d0Var);
                }
                if (recyclerView.mState != null) {
                    recyclerView.mViewInfoStore.d(d0Var);
                }
            }
            d0Var.mBindingAdapter = null;
            d0Var.mOwnerRecyclerView = null;
            if (this.g == null) {
                this.g = new u();
            }
            u uVar = this.g;
            uVar.getClass();
            int i2 = d0Var.mItemViewType;
            ArrayList arrayList2 = uVar.a(i2).a;
            if (((u.a) uVar.a.get(i2)).b <= arrayList2.size()) {
                return;
            }
            d0Var.resetInternal();
            arrayList2.add(d0Var);
        }

        public final int b(int i) {
            RecyclerView recyclerView = RecyclerView.this;
            if (i >= 0 && i < recyclerView.mState.b()) {
                return !recyclerView.mState.g ? i : recyclerView.mAdapterHelper.f(i, 0);
            }
            StringBuilder sbN = ak.n(i, "invalid position ", ". State item count is ");
            sbN.append(recyclerView.mState.b());
            sbN.append(recyclerView.exceptionLabel());
            throw new IndexOutOfBoundsException(sbN.toString());
        }

        public final void e() {
            ArrayList arrayList = this.c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                f(size);
            }
            arrayList.clear();
            Class[] clsArr = RecyclerView.LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
            androidx.recyclerview.widget.m.b bVar = RecyclerView.this.mPrefetchRegistry;
            int[] iArr = bVar.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            bVar.d = 0;
        }

        public final void f(int i) {
            ArrayList arrayList = this.c;
            a((d0) arrayList.get(i), true);
            arrayList.remove(i);
        }

        public final void g(View view) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            boolean zIsTmpDetached = childViewHolderInt.isTmpDetached();
            RecyclerView recyclerView = RecyclerView.this;
            if (zIsTmpDetached) {
                recyclerView.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.mScrapContainer.k(childViewHolderInt);
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            h(childViewHolderInt);
            if (recyclerView.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            recyclerView.mItemAnimator.d(childViewHolderInt);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0030  */
        /* JADX WARN: Code duplicated, block: B:40:0x0076  */
        /* JADX WARN: Code duplicated, block: B:42:0x0082  */
        /* JADX WARN: Code duplicated, block: B:44:0x0089  */
        /* JADX WARN: Code duplicated, block: B:47:0x0091 A[LOOP:2: B:43:0x0087->B:47:0x0091, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:71:0x0094 A[EDGE_INSN: B:71:0x0094->B:48:0x0094 BREAK  A[LOOP:1: B:38:0x0072->B:46:0x008f], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:72:0x0094 A[EDGE_INSN: B:72:0x0094->B:48:0x0094 BREAK  A[LOOP:1: B:38:0x0072->B:46:0x008f], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:73:0x0094 A[EDGE_INSN: B:73:0x0094->B:48:0x0094 BREAK  A[LOOP:1: B:38:0x0072->B:46:0x008f, LOOP_LABEL: LOOP:1: B:38:0x0072->B:46:0x008f], SYNTHETIC] */
        public final void h(d0 d0Var) {
            boolean z;
            boolean z2;
            boolean z3;
            int i;
            int i2;
            int i3;
            int i4;
            boolean zIsScrap = d0Var.isScrap();
            View view = d0Var.itemView;
            RecyclerView recyclerView = RecyclerView.this;
            boolean z4 = false;
            if (zIsScrap || view.getParent() != null) {
                StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(d0Var.isScrap());
                sb.append(" isAttached:");
                sb.append(view.getParent() != null);
                sb.append(recyclerView.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
            if (d0Var.isTmpDetached()) {
                StringBuilder sb2 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb2.append(d0Var);
                throw new IllegalArgumentException(defpackage.e.h(recyclerView, sb2));
            }
            if (d0Var.shouldIgnore()) {
                throw new IllegalArgumentException(defpackage.e.h(recyclerView, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
            }
            if ((d0Var.mFlags & 16) == 0) {
                WeakHashMap weakHashMap = qd1.a;
                if (view.hasTransientState()) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            g gVar = recyclerView.mAdapter;
            androidx.recyclerview.widget.m.b bVar = recyclerView.mPrefetchRegistry;
            if (d0Var.isRecyclable()) {
                if (this.f <= 0 || (d0Var.mFlags & 526) != 0) {
                    z3 = false;
                } else {
                    ArrayList arrayList = this.c;
                    int size = arrayList.size();
                    if (size >= this.f && size > 0) {
                        f(0);
                        size--;
                    }
                    Class[] clsArr = RecyclerView.LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
                    if (size > 0) {
                        int i5 = d0Var.mPosition;
                        if (bVar.c == null) {
                            loop1: while (true) {
                                i = size - 1;
                                if (i >= 0) {
                                    break;
                                    break;
                                }
                                i2 = ((d0) arrayList.get(i)).mPosition;
                                if (bVar.c != null) {
                                    break;
                                    break;
                                }
                                i3 = bVar.d * 2;
                                i4 = 0;
                                while (true) {
                                    if (i4 < i3) {
                                        break loop1;
                                        break loop1;
                                    } else if (bVar.c[i4] == i2) {
                                        break;
                                    } else {
                                        i4 += 2;
                                    }
                                }
                                size = i;
                            }
                        } else {
                            int i6 = bVar.d * 2;
                            int i7 = 0;
                            while (true) {
                                if (i7 >= i6) {
                                    loop1: while (true) {
                                        i = size - 1;
                                        if (i >= 0) {
                                            break;
                                        }
                                        i2 = ((d0) arrayList.get(i)).mPosition;
                                        if (bVar.c != null) {
                                            break;
                                        }
                                        i3 = bVar.d * 2;
                                        i4 = 0;
                                        while (true) {
                                            if (i4 < i3) {
                                                break loop1;
                                            } else if (bVar.c[i4] == i2) {
                                                break;
                                            } else {
                                                i4 += 2;
                                            }
                                        }
                                        size = i;
                                    }
                                } else if (bVar.c[i7] != i5) {
                                    i7 += 2;
                                }
                            }
                        }
                    }
                    arrayList.add(size, d0Var);
                    z3 = true;
                }
                if (!z3) {
                    a(d0Var, true);
                    z4 = true;
                }
                boolean z5 = z4;
                z4 = z3;
                z2 = z5;
            } else {
                z2 = false;
            }
            recyclerView.mViewInfoStore.d(d0Var);
            if (z4 || z2 || !z) {
                return;
            }
            d0Var.mBindingAdapter = null;
            d0Var.mOwnerRecyclerView = null;
        }

        public final void i(View view) {
            ArrayList arrayList;
            androidx.recyclerview.widget.k kVar;
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            boolean z = (childViewHolderInt.mFlags & 12) != 0;
            RecyclerView recyclerView = RecyclerView.this;
            if (!z && childViewHolderInt.isUpdated() && (kVar = recyclerView.mItemAnimator) != null && childViewHolderInt.getUnmodifiedPayloads().isEmpty() && kVar.g && !childViewHolderInt.isInvalid()) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                childViewHolderInt.mScrapContainer = this;
                childViewHolderInt.mInChangeScrap = true;
                arrayList = this.b;
            } else {
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !recyclerView.mAdapter.mHasStableIds) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.".concat(recyclerView.exceptionLabel()));
                }
                childViewHolderInt.mScrapContainer = this;
                childViewHolderInt.mInChangeScrap = false;
                arrayList = this.a;
            }
            arrayList.add(childViewHolderInt);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x019a  */
        /* JADX WARN: Code duplicated, block: B:102:0x01a0  */
        /* JADX WARN: Code duplicated, block: B:103:0x01a3  */
        /* JADX WARN: Code duplicated, block: B:105:0x01a7  */
        /* JADX WARN: Code duplicated, block: B:117:0x01d3  */
        /* JADX WARN: Code duplicated, block: B:120:0x01d9  */
        /* JADX WARN: Code duplicated, block: B:122:0x01e3  */
        /* JADX WARN: Code duplicated, block: B:123:0x01ee  */
        /* JADX WARN: Code duplicated, block: B:125:0x01f4  */
        /* JADX WARN: Code duplicated, block: B:127:0x01fd  */
        /* JADX WARN: Code duplicated, block: B:130:0x021b  */
        /* JADX WARN: Code duplicated, block: B:133:0x0228  */
        /* JADX WARN: Code duplicated, block: B:184:0x0321 A[EDGE_INSN: B:184:0x0321->B:185:0x0322 BREAK  A[LOOP:3: B:179:0x0309->B:183:0x031e]] */
        /* JADX WARN: Code duplicated, block: B:221:0x03d9  */
        /* JADX WARN: Code duplicated, block: B:228:0x03eb  */
        /* JADX WARN: Code duplicated, block: B:229:0x03ee  */
        /* JADX WARN: Code duplicated, block: B:231:0x03f1  */
        /* JADX WARN: Code duplicated, block: B:233:0x03f9  */
        /* JADX WARN: Code duplicated, block: B:239:0x041c  */
        /* JADX WARN: Code duplicated, block: B:241:0x0422  */
        /* JADX WARN: Code duplicated, block: B:243:0x0428  */
        /* JADX WARN: Code duplicated, block: B:244:0x042b  */
        /* JADX WARN: Code duplicated, block: B:246:0x042e  */
        /* JADX WARN: Code duplicated, block: B:252:0x044d  */
        /* JADX WARN: Code duplicated, block: B:254:0x0459  */
        /* JADX WARN: Code duplicated, block: B:258:0x0461  */
        /* JADX WARN: Code duplicated, block: B:260:0x0465 A[PHI: r7
          0x0465: PHI (r7v2 int) = (r7v0 int), (r7v3 int) binds: [B:259:0x0463, B:249:0x0435] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:263:0x0473  */
        /* JADX WARN: Code duplicated, block: B:264:0x0476  */
        /* JADX WARN: Code duplicated, block: B:266:0x0479  */
        /* JADX WARN: Code duplicated, block: B:268:0x047f  */
        /* JADX WARN: Code duplicated, block: B:272:0x049e  */
        /* JADX WARN: Code duplicated, block: B:274:0x04a2  */
        /* JADX WARN: Code duplicated, block: B:277:0x04b3  */
        /* JADX WARN: Code duplicated, block: B:282:0x04d2  */
        /* JADX WARN: Code duplicated, block: B:285:0x04df  */
        /* JADX WARN: Code duplicated, block: B:288:0x04e7  */
        /* JADX WARN: Code duplicated, block: B:290:0x04ea  */
        /* JADX WARN: Code duplicated, block: B:292:0x04f3  */
        /* JADX WARN: Code duplicated, block: B:296:0x04fb  */
        /* JADX WARN: Code duplicated, block: B:298:0x0503  */
        /* JADX WARN: Code duplicated, block: B:300:0x050c  */
        /* JADX WARN: Code duplicated, block: B:301:0x050e  */
        /* JADX WARN: Code duplicated, block: B:303:0x0512  */
        /* JADX WARN: Code duplicated, block: B:304:0x0518  */
        /* JADX WARN: Code duplicated, block: B:306:0x051f A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:309:0x052a  */
        /* JADX WARN: Code duplicated, block: B:312:0x052f  */
        /* JADX WARN: Code duplicated, block: B:316:0x0538  */
        /* JADX WARN: Code duplicated, block: B:317:0x053d  */
        /* JADX WARN: Code duplicated, block: B:319:0x0543  */
        /* JADX WARN: Code duplicated, block: B:321:0x054d  */
        /* JADX WARN: Code duplicated, block: B:324:0x0554 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:326:0x0558  */
        /* JADX WARN: Code duplicated, block: B:338:0x00be A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:354:0x00f4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:359:0x0196 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:35:0x007b A[EDGE_INSN: B:35:0x007b->B:36:0x007c BREAK  A[LOOP:0: B:14:0x0023->B:20:0x003d]] */
        /* JADX WARN: Code duplicated, block: B:42:0x0089  */
        /* JADX WARN: Code duplicated, block: B:44:0x0090  */
        /* JADX WARN: Code duplicated, block: B:58:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:68:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:70:0x010c  */
        /* JADX WARN: Code duplicated, block: B:72:0x0114  */
        /* JADX WARN: Code duplicated, block: B:75:0x0127  */
        /* JADX WARN: Code duplicated, block: B:77:0x012f  */
        /* JADX WARN: Code duplicated, block: B:78:0x0131  */
        /* JADX WARN: Code duplicated, block: B:80:0x0138 A[EDGE_INSN: B:80:0x0138->B:99:0x0198 BREAK  A[LOOP:1: B:43:0x008e->B:55:0x00bb]] */
        /* JADX WARN: Code duplicated, block: B:81:0x0147  */
        /* JADX WARN: Code duplicated, block: B:83:0x0162  */
        /* JADX WARN: Code duplicated, block: B:85:0x0168  */
        /* JADX WARN: Code duplicated, block: B:87:0x016e  */
        /* JADX WARN: Code duplicated, block: B:89:0x0175  */
        /* JADX WARN: Instruction removed from duplicated block: B:81:0x0147, please report this as an issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v7, types: [androidx.recyclerview.widget.RecyclerView$v] */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r6v66 */
        /* JADX WARN: Type inference failed for: r6v69 */
        /* JADX WARN: Type inference failed for: r6v72 */
        /* JADX WARN: Type inference failed for: r6v79 */
        /* JADX WARN: Type inference failed for: r8v12, types: [boolean] */
        public final d0 j(int i, long j) {
            d0 d0VarOnCreateViewHolder;
            int i2;
            ArrayList arrayList;
            ArrayList arrayList2;
            int i3;
            d0 d0Var;
            long j2;
            long j3;
            View view;
            int i4;
            int iF;
            int i5;
            g gVar;
            int i6;
            long jNanoTime;
            long j4;
            AccessibilityManager accessibilityManager;
            boolean z;
            int i7;
            int i8;
            androidx.recyclerview.widget.x xVar;
            a1 itemDelegate;
            androidx.recyclerview.widget.x.a aVar;
            View.AccessibilityDelegate accessibilityDelegateD;
            a1 a1Var;
            ArrayList arrayList3;
            ViewGroup.LayoutParams layoutParams;
            long j5;
            int i9;
            int i10;
            ViewGroup.LayoutParams layoutParams2;
            p pVar;
            ViewGroup.LayoutParams layoutParamsGenerateLayoutParams;
            ?? r5;
            int i11;
            int i12;
            int iF2;
            d0 d0Var2;
            int i13;
            d0 d0Var3;
            int size;
            int i14;
            androidx.recyclerview.widget.b bVar;
            ArrayList arrayList4;
            int size2;
            int i15;
            View view2;
            int size3;
            int i16;
            d0 d0Var4;
            d0 childViewHolderInt;
            androidx.recyclerview.widget.b bVar2;
            int iIndexOfChild;
            androidx.recyclerview.widget.b.a aVar2;
            androidx.recyclerview.widget.b bVar3;
            int iIndexOfChild2;
            int iB;
            androidx.recyclerview.widget.b.a aVar3;
            d0 childViewHolderInt2;
            int i17;
            ?? r6;
            boolean z2;
            int size4;
            int iF3;
            RecyclerView recyclerView = RecyclerView.this;
            if (i >= 0) {
                a0 a0Var = recyclerView.mState;
                if (i < a0Var.b()) {
                    if (a0Var.g) {
                        ArrayList arrayList5 = this.b;
                        if (arrayList5 != null && (size4 = arrayList5.size()) != 0) {
                            int i18 = 0;
                            while (true) {
                                if (i18 >= size4) {
                                    if (recyclerView.mAdapter.mHasStableIds && (iF3 = recyclerView.mAdapterHelper.f(i, 0)) > 0 && iF3 < recyclerView.mAdapter.getItemCount()) {
                                        long itemId = recyclerView.mAdapter.getItemId(iF3);
                                        int i19 = 0;
                                        while (true) {
                                            if (i19 >= size4) {
                                                d0VarOnCreateViewHolder = null;
                                                break;
                                            }
                                            d0 d0Var5 = (d0) this.b.get(i19);
                                            if (!d0Var5.wasReturnedFromScrap() && d0Var5.mItemId == itemId) {
                                                d0Var5.addFlags(32);
                                                d0VarOnCreateViewHolder = d0Var5;
                                                break;
                                            }
                                            i19++;
                                        }
                                    } else {
                                        d0VarOnCreateViewHolder = null;
                                        break;
                                    }
                                } else {
                                    d0VarOnCreateViewHolder = (d0) this.b.get(i18);
                                    if (!d0VarOnCreateViewHolder.wasReturnedFromScrap() && d0VarOnCreateViewHolder.getLayoutPosition() == i) {
                                        d0VarOnCreateViewHolder.addFlags(32);
                                        break;
                                    }
                                    i18++;
                                }
                            }
                        } else {
                            d0VarOnCreateViewHolder = null;
                            break;
                        }
                        if (d0VarOnCreateViewHolder != null) {
                            i2 = 1;
                        }
                        arrayList = this.c;
                        arrayList2 = this.a;
                        if (d0VarOnCreateViewHolder == null) {
                            size = arrayList2.size();
                            i14 = 0;
                            while (true) {
                                if (i14 >= size) {
                                    bVar = recyclerView.mChildHelper;
                                    arrayList4 = bVar.c;
                                    size2 = arrayList4.size();
                                    i15 = 0;
                                    while (true) {
                                        if (i15 < size2) {
                                            i3 = 1;
                                            d0Var = null;
                                            view2 = null;
                                            break;
                                        }
                                        View view3 = (View) arrayList4.get(i15);
                                        i3 = 1;
                                        bVar.a.getClass();
                                        childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view3);
                                        d0Var = null;
                                        if (childViewHolderInt2.getLayoutPosition() != i && !childViewHolderInt2.isInvalid() && !childViewHolderInt2.isRemoved()) {
                                            view2 = view3;
                                            break;
                                        }
                                        i15++;
                                    }
                                    if (view2 != null) {
                                        size3 = arrayList.size();
                                        i16 = 0;
                                        while (true) {
                                            if (i16 < size3) {
                                                d0VarOnCreateViewHolder = d0Var;
                                                break;
                                            }
                                            d0Var4 = (d0) arrayList.get(i16);
                                            if (d0Var4.isInvalid() && d0Var4.getLayoutPosition() == i && !d0Var4.isAttachedToTransitionOverlay()) {
                                                arrayList.remove(i16);
                                            } else {
                                                i16++;
                                            }
                                        }
                                    } else {
                                        childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
                                        bVar2 = recyclerView.mChildHelper;
                                        iIndexOfChild = RecyclerView.this.indexOfChild(view2);
                                        if (iIndexOfChild >= 0) {
                                            defpackage.d.AnonymousClass0.m("view is not a child, cannot hide ", view2);
                                            return d0Var;
                                        }
                                        aVar2 = bVar2.b;
                                        if (aVar2.d(iIndexOfChild)) {
                                            defpackage.d.AnonymousClass0.m$2("trying to unhide a view that was not hidden", view2);
                                            return d0Var;
                                        }
                                        aVar2.a(iIndexOfChild);
                                        bVar2.m(view2);
                                        bVar3 = recyclerView.mChildHelper;
                                        iIndexOfChild2 = RecyclerView.this.indexOfChild(view2);
                                        if (iIndexOfChild2 == -1) {
                                            iB = -1;
                                        } else {
                                            aVar3 = bVar3.b;
                                            if (aVar3.d(iIndexOfChild2)) {
                                                iB = -1;
                                            } else {
                                                iB = iIndexOfChild2 - aVar3.b(iIndexOfChild2);
                                            }
                                        }
                                        if (iB != -1) {
                                            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + recyclerView.exceptionLabel());
                                        }
                                        recyclerView.mChildHelper.c(iB);
                                        i(view2);
                                        childViewHolderInt.addFlags(8224);
                                        d0VarOnCreateViewHolder = childViewHolderInt;
                                        break;
                                    }
                                } else {
                                    d0Var4 = (d0) arrayList2.get(i14);
                                    if (!d0Var4.wasReturnedFromScrap() || d0Var4.getLayoutPosition() != i || d0Var4.isInvalid() || (!a0Var.g && d0Var4.isRemoved())) {
                                        i14++;
                                    } else {
                                        d0Var4.addFlags(32);
                                        i3 = 1;
                                        d0Var = null;
                                    }
                                }
                                d0VarOnCreateViewHolder = d0Var4;
                                break;
                            }
                            if (d0VarOnCreateViewHolder != null) {
                                if (d0VarOnCreateViewHolder.isRemoved()) {
                                    z2 = a0Var.g;
                                } else {
                                    i17 = d0VarOnCreateViewHolder.mPosition;
                                    if (i17 >= 0 || i17 >= recyclerView.mAdapter.getItemCount()) {
                                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0VarOnCreateViewHolder + recyclerView.exceptionLabel());
                                    }
                                    if (a0Var.g || recyclerView.mAdapter.getItemViewType(d0VarOnCreateViewHolder.mPosition) == d0VarOnCreateViewHolder.mItemViewType) {
                                        g gVar2 = recyclerView.mAdapter;
                                        if (!gVar2.mHasStableIds || d0VarOnCreateViewHolder.mItemId == gVar2.getItemId(d0VarOnCreateViewHolder.mPosition)) {
                                            r6 = i3;
                                        } else {
                                            r6 = 0;
                                        }
                                    } else {
                                        r6 = 0;
                                    }
                                }
                                if (r6 == 0) {
                                    d0VarOnCreateViewHolder.addFlags(4);
                                    if (d0VarOnCreateViewHolder.isScrap()) {
                                        r6 = z2;
                                        recyclerView.removeDetachedView(d0VarOnCreateViewHolder.itemView, false);
                                        d0VarOnCreateViewHolder.mScrapContainer.k(d0VarOnCreateViewHolder);
                                    } else if (d0VarOnCreateViewHolder.wasReturnedFromScrap()) {
                                        r6 = z2;
                                        d0VarOnCreateViewHolder.clearReturnedFromScrapFlag();
                                    }
                                    r6 = z2;
                                    h(d0VarOnCreateViewHolder);
                                    d0VarOnCreateViewHolder = d0Var;
                                } else {
                                    r6 = z2;
                                    i2 = i3;
                                }
                            }
                        } else {
                            i3 = 1;
                            d0Var = null;
                        }
                        if (d0VarOnCreateViewHolder == null) {
                            iF2 = recyclerView.mAdapterHelper.f(i, 0);
                            if (iF2 >= 0 || iF2 >= recyclerView.mAdapter.getItemCount()) {
                                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iF2 + ").state:" + a0Var.b() + recyclerView.exceptionLabel());
                            }
                            int itemViewType = recyclerView.mAdapter.getItemViewType(iF2);
                            g gVar3 = recyclerView.mAdapter;
                            j2 = 4;
                            if (gVar3.mHasStableIds) {
                                long itemId2 = gVar3.getItemId(iF2);
                                int size5 = arrayList2.size() - 1;
                                while (true) {
                                    if (size5 < 0) {
                                        i13 = iF2;
                                        j3 = 3;
                                        int size6 = arrayList.size() - 1;
                                        while (true) {
                                            if (size6 >= 0) {
                                                d0 d0Var6 = (d0) arrayList.get(size6);
                                                if (d0Var6.mItemId != itemId2 || d0Var6.isAttachedToTransitionOverlay()) {
                                                    size6--;
                                                } else {
                                                    if (itemViewType == d0Var6.mItemViewType) {
                                                        arrayList.remove(size6);
                                                        d0Var3 = d0Var6;
                                                        break;
                                                    }
                                                    f(size6);
                                                }
                                            }
                                            d0Var3 = null;
                                            break;
                                        }
                                    }
                                    d0Var3 = (d0) arrayList2.get(size5);
                                    i13 = iF2;
                                    long j6 = d0Var3.mItemId;
                                    j3 = 3;
                                    View view4 = d0Var3.itemView;
                                    if (j6 == itemId2 && !d0Var3.wasReturnedFromScrap()) {
                                        if (itemViewType == d0Var3.mItemViewType) {
                                            d0Var3.addFlags(32);
                                            if (!d0Var3.isRemoved() || a0Var.g) {
                                                break;
                                                break;
                                            }
                                            d0Var3.mFlags = (d0Var3.mFlags & (-15)) | 2;
                                            break;
                                        }
                                        arrayList2.remove(size5);
                                        recyclerView.removeDetachedView(view4, false);
                                        d0 childViewHolderInt3 = RecyclerView.getChildViewHolderInt(view4);
                                        childViewHolderInt3.mScrapContainer = d0Var;
                                        childViewHolderInt3.mInChangeScrap = false;
                                        childViewHolderInt3.clearReturnedFromScrapFlag();
                                        h(childViewHolderInt3);
                                    }
                                    size5--;
                                    iF2 = i13;
                                    d0Var = null;
                                }
                                if (d0Var3 != null) {
                                    d0Var3.mPosition = i13;
                                    d0VarOnCreateViewHolder = d0Var3;
                                    i2 = i3;
                                } else {
                                    d0VarOnCreateViewHolder = d0Var3;
                                }
                            } else {
                                j3 = 3;
                            }
                            if (d0VarOnCreateViewHolder == null) {
                                if (this.g == null) {
                                    this.g = new u();
                                }
                                u.a aVar4 = (u.a) this.g.a.get(itemViewType);
                                if (aVar4 == null) {
                                    d0Var2 = null;
                                    break;
                                }
                                ArrayList arrayList6 = aVar4.a;
                                if (!arrayList6.isEmpty()) {
                                    int size7 = arrayList6.size() - 1;
                                    while (true) {
                                        if (size7 < 0) {
                                            d0Var2 = null;
                                            break;
                                        }
                                        if (!((d0) arrayList6.get(size7)).isAttachedToTransitionOverlay()) {
                                            d0Var2 = (d0) arrayList6.remove(size7);
                                            break;
                                        }
                                        size7--;
                                    }
                                } else {
                                    d0Var2 = null;
                                    break;
                                }
                                if (d0Var2 != null) {
                                    d0Var2.resetInternal();
                                    Class[] clsArr = RecyclerView.LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
                                }
                                d0VarOnCreateViewHolder = d0Var2;
                            }
                            if (d0VarOnCreateViewHolder == null) {
                                long jNanoTime2 = System.nanoTime();
                                if (j != Long.MAX_VALUE) {
                                    long j7 = this.g.a(itemViewType).c;
                                    if (((j7 == 0 || j7 + jNanoTime2 < j) ? i3 : 0) == 0) {
                                        return null;
                                    }
                                }
                                g gVar4 = recyclerView.mAdapter;
                                gVar4.getClass();
                                try {
                                    int i20 = t71.$r8$clinit;
                                    Trace.beginSection("RV CreateView");
                                    d0VarOnCreateViewHolder = gVar4.onCreateViewHolder(recyclerView, itemViewType);
                                    if (d0VarOnCreateViewHolder.itemView.getParent() != null) {
                                        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                                    }
                                    d0VarOnCreateViewHolder.mItemViewType = itemViewType;
                                    Trace.endSection();
                                    Class[] clsArr2 = RecyclerView.LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
                                    RecyclerView recyclerViewFindNestedRecyclerView = RecyclerView.findNestedRecyclerView(d0VarOnCreateViewHolder.itemView);
                                    if (recyclerViewFindNestedRecyclerView != null) {
                                        d0VarOnCreateViewHolder.mNestedRecyclerView = new WeakReference(recyclerViewFindNestedRecyclerView);
                                    }
                                    long jNanoTime3 = System.nanoTime() - jNanoTime2;
                                    u.a aVarA = this.g.a(itemViewType);
                                    long j8 = aVarA.c;
                                    if (j8 != 0) {
                                        jNanoTime3 = (jNanoTime3 / 4) + ((j8 / 4) * j3);
                                    }
                                    aVarA.c = jNanoTime3;
                                } catch (Throwable th) {
                                    int i21 = t71.$r8$clinit;
                                    Trace.endSection();
                                    throw th;
                                }
                            }
                        } else {
                            j2 = 4;
                            j3 = 3;
                        }
                        view = d0VarOnCreateViewHolder.itemView;
                        if (i2 != 0 && !a0Var.g) {
                            i11 = d0VarOnCreateViewHolder.mFlags;
                            if ((i11 & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0) {
                                i12 = i3;
                            } else {
                                i12 = 0;
                            }
                            if (i12 != 0) {
                                d0VarOnCreateViewHolder.mFlags = i11 & (-8193);
                                if (a0Var.j) {
                                    l.b(d0VarOnCreateViewHolder);
                                    androidx.recyclerview.widget.k kVar = recyclerView.mItemAnimator;
                                    d0VarOnCreateViewHolder.getUnmodifiedPayloads();
                                    kVar.getClass();
                                    l.c cVar = new l.c();
                                    cVar.a(d0VarOnCreateViewHolder);
                                    recyclerView.recordAnimationInfoIfBouncedHiddenView(d0VarOnCreateViewHolder, cVar);
                                }
                            }
                        }
                        if (a0Var.g || !d0VarOnCreateViewHolder.isBound()) {
                            if (d0VarOnCreateViewHolder.isBound()) {
                                if ((d0VarOnCreateViewHolder.mFlags & 2) != 0) {
                                    i10 = i3;
                                } else {
                                    i10 = 0;
                                }
                                if (i10 == 0 || d0VarOnCreateViewHolder.isInvalid()) {
                                }
                                i8 = i4;
                                i7 = i3;
                                layoutParams2 = view.getLayoutParams();
                                if (layoutParams2 != null) {
                                    if (recyclerView.checkLayoutParams(layoutParams2)) {
                                        pVar = (p) layoutParams2;
                                    } else {
                                        layoutParamsGenerateLayoutParams = recyclerView.generateLayoutParams(layoutParams2);
                                    }
                                    pVar.a = d0VarOnCreateViewHolder;
                                    if (i2 != 0 || i8 == 0) {
                                        r5 = i4;
                                    } else {
                                        r5 = i7;
                                    }
                                    pVar.d = r5;
                                    return d0VarOnCreateViewHolder;
                                }
                                layoutParamsGenerateLayoutParams = recyclerView.generateDefaultLayoutParams();
                                pVar = (p) layoutParamsGenerateLayoutParams;
                                view.setLayoutParams(pVar);
                                pVar.a = d0VarOnCreateViewHolder;
                                if (i2 != 0) {
                                    r5 = i4;
                                } else {
                                    r5 = i4;
                                }
                                pVar.d = r5;
                                return d0VarOnCreateViewHolder;
                            }
                            i4 = 0;
                            iF = recyclerView.mAdapterHelper.f(i, 0);
                            d0VarOnCreateViewHolder.mBindingAdapter = null;
                            d0VarOnCreateViewHolder.mOwnerRecyclerView = recyclerView;
                            i5 = d0VarOnCreateViewHolder.mItemViewType;
                            long jNanoTime4 = System.nanoTime();
                            if (j != Long.MAX_VALUE) {
                                j5 = this.g.a(i5).d;
                                if (j5 != 0 || j5 + jNanoTime4 < j) {
                                    i9 = i3;
                                } else {
                                    i9 = 0;
                                }
                                if (i9 == 0) {
                                    i8 = i4;
                                    i7 = i3;
                                }
                                layoutParams2 = view.getLayoutParams();
                                if (layoutParams2 != null) {
                                    if (recyclerView.checkLayoutParams(layoutParams2)) {
                                        layoutParamsGenerateLayoutParams = recyclerView.generateLayoutParams(layoutParams2);
                                    } else {
                                        pVar = (p) layoutParams2;
                                    }
                                    pVar.a = d0VarOnCreateViewHolder;
                                    if (i2 != 0) {
                                        r5 = i4;
                                    } else {
                                        r5 = i4;
                                    }
                                    pVar.d = r5;
                                    return d0VarOnCreateViewHolder;
                                }
                                layoutParamsGenerateLayoutParams = recyclerView.generateDefaultLayoutParams();
                                pVar = (p) layoutParamsGenerateLayoutParams;
                                view.setLayoutParams(pVar);
                                pVar.a = d0VarOnCreateViewHolder;
                                if (i2 != 0) {
                                    r5 = i4;
                                } else {
                                    r5 = i4;
                                }
                                pVar.d = r5;
                                return d0VarOnCreateViewHolder;
                            }
                            gVar = recyclerView.mAdapter;
                            gVar.getClass();
                            if (d0VarOnCreateViewHolder.mBindingAdapter == null) {
                                i6 = i3;
                            } else {
                                i6 = 0;
                            }
                            if (i6 != 0) {
                                d0VarOnCreateViewHolder.mPosition = iF;
                                if (gVar.mHasStableIds) {
                                    d0VarOnCreateViewHolder.mItemId = gVar.getItemId(iF);
                                }
                                d0VarOnCreateViewHolder.mFlags = i3 | (d0VarOnCreateViewHolder.mFlags & (-520));
                                int i22 = t71.$r8$clinit;
                                Trace.beginSection("RV OnBindView");
                            }
                            d0VarOnCreateViewHolder.mBindingAdapter = gVar;
                            d0VarOnCreateViewHolder.getUnmodifiedPayloads();
                            gVar.onBindViewHolder(d0VarOnCreateViewHolder, iF);
                            if (i6 != 0) {
                                arrayList3 = d0VarOnCreateViewHolder.mPayloads;
                                if (arrayList3 != null) {
                                    arrayList3.clear();
                                }
                                d0VarOnCreateViewHolder.mFlags &= -1025;
                                layoutParams = view.getLayoutParams();
                                if (layoutParams instanceof p) {
                                    ((p) layoutParams).c = i3;
                                }
                                int i23 = t71.$r8$clinit;
                                Trace.endSection();
                            }
                            jNanoTime = System.nanoTime() - jNanoTime4;
                            u.a aVarA2 = this.g.a(d0VarOnCreateViewHolder.mItemViewType);
                            j4 = aVarA2.d;
                            if (j4 != 0) {
                                jNanoTime = (jNanoTime / j2) + ((j4 / j2) * j3);
                            }
                            aVarA2.d = jNanoTime;
                            accessibilityManager = recyclerView.mAccessibilityManager;
                            if (accessibilityManager == null && accessibilityManager.isEnabled()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                WeakHashMap weakHashMap = qd1.a;
                                i7 = 1;
                                if (view.getImportantForAccessibility() == 0) {
                                    view.setImportantForAccessibility(1);
                                }
                                xVar = recyclerView.mAccessibilityDelegate;
                                if (xVar != null) {
                                    itemDelegate = xVar.getItemDelegate();
                                    if (itemDelegate instanceof androidx.recyclerview.widget.x.a) {
                                        aVar = (androidx.recyclerview.widget.x.a) itemDelegate;
                                        accessibilityDelegateD = qd1.d(view);
                                        if (accessibilityDelegateD == null) {
                                            a1Var = null;
                                        } else if (accessibilityDelegateD instanceof a1.a) {
                                            a1Var = ((a1.a) accessibilityDelegateD).a;
                                        } else {
                                            a1Var = new a1(accessibilityDelegateD);
                                        }
                                        if (a1Var != null && a1Var != aVar) {
                                            aVar.b.put(view, a1Var);
                                        }
                                    }
                                    qd1.l(view, itemDelegate);
                                }
                            } else {
                                i7 = 1;
                            }
                            if (a0Var.g) {
                                d0VarOnCreateViewHolder.mPreLayoutPosition = i;
                            }
                            i8 = i7;
                            layoutParams2 = view.getLayoutParams();
                            if (layoutParams2 != null) {
                                if (recyclerView.checkLayoutParams(layoutParams2)) {
                                    layoutParamsGenerateLayoutParams = recyclerView.generateLayoutParams(layoutParams2);
                                } else {
                                    pVar = (p) layoutParams2;
                                }
                                pVar.a = d0VarOnCreateViewHolder;
                                if (i2 != 0) {
                                    r5 = i4;
                                } else {
                                    r5 = i4;
                                }
                                pVar.d = r5;
                                return d0VarOnCreateViewHolder;
                            }
                            layoutParamsGenerateLayoutParams = recyclerView.generateDefaultLayoutParams();
                            pVar = (p) layoutParamsGenerateLayoutParams;
                            view.setLayoutParams(pVar);
                            pVar.a = d0VarOnCreateViewHolder;
                            if (i2 != 0) {
                                r5 = i4;
                            } else {
                                r5 = i4;
                            }
                            pVar.d = r5;
                            return d0VarOnCreateViewHolder;
                        }
                        d0VarOnCreateViewHolder.mPreLayoutPosition = i;
                        i4 = 0;
                        i8 = i4;
                        i7 = i3;
                        layoutParams2 = view.getLayoutParams();
                        if (layoutParams2 != null) {
                            if (recyclerView.checkLayoutParams(layoutParams2)) {
                                layoutParamsGenerateLayoutParams = recyclerView.generateLayoutParams(layoutParams2);
                            } else {
                                pVar = (p) layoutParams2;
                            }
                            pVar.a = d0VarOnCreateViewHolder;
                            if (i2 != 0) {
                                r5 = i4;
                            } else {
                                r5 = i4;
                            }
                            pVar.d = r5;
                            return d0VarOnCreateViewHolder;
                        }
                        layoutParamsGenerateLayoutParams = recyclerView.generateDefaultLayoutParams();
                        pVar = (p) layoutParamsGenerateLayoutParams;
                        view.setLayoutParams(pVar);
                        pVar.a = d0VarOnCreateViewHolder;
                        if (i2 != 0) {
                            r5 = i4;
                        } else {
                            r5 = i4;
                        }
                        pVar.d = r5;
                        return d0VarOnCreateViewHolder;
                    }
                    d0VarOnCreateViewHolder = null;
                    i2 = 0;
                    arrayList = this.c;
                    arrayList2 = this.a;
                    if (d0VarOnCreateViewHolder == null) {
                        size = arrayList2.size();
                        i14 = 0;
                        while (true) {
                            if (i14 >= size) {
                                d0Var4 = (d0) arrayList2.get(i14);
                                if (d0Var4.wasReturnedFromScrap()) {
                                }
                                i14++;
                            } else {
                                bVar = recyclerView.mChildHelper;
                                arrayList4 = bVar.c;
                                size2 = arrayList4.size();
                                i15 = 0;
                                while (true) {
                                    if (i15 < size2) {
                                        i3 = 1;
                                        d0Var = null;
                                        view2 = null;
                                        break;
                                    }
                                    View view5 = (View) arrayList4.get(i15);
                                    i3 = 1;
                                    bVar.a.getClass();
                                    childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view5);
                                    d0Var = null;
                                    if (childViewHolderInt2.getLayoutPosition() != i) {
                                    }
                                    i15++;
                                }
                                if (view2 != null) {
                                    size3 = arrayList.size();
                                    i16 = 0;
                                    while (true) {
                                        if (i16 < size3) {
                                            d0VarOnCreateViewHolder = d0Var;
                                            break;
                                        }
                                        d0Var4 = (d0) arrayList.get(i16);
                                        if (d0Var4.isInvalid()) {
                                        }
                                        i16++;
                                    }
                                } else {
                                    childViewHolderInt = RecyclerView.getChildViewHolderInt(view2);
                                    bVar2 = recyclerView.mChildHelper;
                                    iIndexOfChild = RecyclerView.this.indexOfChild(view2);
                                    if (iIndexOfChild >= 0) {
                                        defpackage.d.AnonymousClass0.m("view is not a child, cannot hide ", view2);
                                        return d0Var;
                                    }
                                    aVar2 = bVar2.b;
                                    if (aVar2.d(iIndexOfChild)) {
                                        defpackage.d.AnonymousClass0.m$2("trying to unhide a view that was not hidden", view2);
                                        return d0Var;
                                    }
                                    aVar2.a(iIndexOfChild);
                                    bVar2.m(view2);
                                    bVar3 = recyclerView.mChildHelper;
                                    iIndexOfChild2 = RecyclerView.this.indexOfChild(view2);
                                    if (iIndexOfChild2 == -1) {
                                        iB = -1;
                                    } else {
                                        aVar3 = bVar3.b;
                                        if (aVar3.d(iIndexOfChild2)) {
                                            iB = -1;
                                        } else {
                                            iB = iIndexOfChild2 - aVar3.b(iIndexOfChild2);
                                        }
                                    }
                                    if (iB != -1) {
                                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + recyclerView.exceptionLabel());
                                    }
                                    recyclerView.mChildHelper.c(iB);
                                    i(view2);
                                    childViewHolderInt.addFlags(8224);
                                    d0VarOnCreateViewHolder = childViewHolderInt;
                                    break;
                                }
                                if (d0VarOnCreateViewHolder != null) {
                                    if (d0VarOnCreateViewHolder.isRemoved()) {
                                        i17 = d0VarOnCreateViewHolder.mPosition;
                                        if (i17 >= 0) {
                                        }
                                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0VarOnCreateViewHolder + recyclerView.exceptionLabel());
                                    }
                                    z2 = a0Var.g;
                                    if (r6 == 0) {
                                        d0VarOnCreateViewHolder.addFlags(4);
                                        if (d0VarOnCreateViewHolder.isScrap()) {
                                            r6 = z2;
                                            recyclerView.removeDetachedView(d0VarOnCreateViewHolder.itemView, false);
                                            d0VarOnCreateViewHolder.mScrapContainer.k(d0VarOnCreateViewHolder);
                                        } else if (d0VarOnCreateViewHolder.wasReturnedFromScrap()) {
                                            r6 = z2;
                                            d0VarOnCreateViewHolder.clearReturnedFromScrapFlag();
                                        }
                                        r6 = z2;
                                        h(d0VarOnCreateViewHolder);
                                        d0VarOnCreateViewHolder = d0Var;
                                    } else {
                                        r6 = z2;
                                        i2 = i3;
                                    }
                                }
                            }
                            d0VarOnCreateViewHolder = d0Var4;
                            if (d0VarOnCreateViewHolder != null) {
                                if (d0VarOnCreateViewHolder.isRemoved()) {
                                    i17 = d0VarOnCreateViewHolder.mPosition;
                                    if (i17 >= 0) {
                                    }
                                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0VarOnCreateViewHolder + recyclerView.exceptionLabel());
                                }
                                z2 = a0Var.g;
                                if (r6 == 0) {
                                    d0VarOnCreateViewHolder.addFlags(4);
                                    if (d0VarOnCreateViewHolder.isScrap()) {
                                        r6 = z2;
                                        recyclerView.removeDetachedView(d0VarOnCreateViewHolder.itemView, false);
                                        d0VarOnCreateViewHolder.mScrapContainer.k(d0VarOnCreateViewHolder);
                                    } else if (d0VarOnCreateViewHolder.wasReturnedFromScrap()) {
                                        r6 = z2;
                                        d0VarOnCreateViewHolder.clearReturnedFromScrapFlag();
                                    }
                                    r6 = z2;
                                    h(d0VarOnCreateViewHolder);
                                    d0VarOnCreateViewHolder = d0Var;
                                } else {
                                    r6 = z2;
                                    i2 = i3;
                                }
                            }
                        }
                    } else {
                        i3 = 1;
                        d0Var = null;
                    }
                    if (d0VarOnCreateViewHolder == null) {
                        iF2 = recyclerView.mAdapterHelper.f(i, 0);
                        if (iF2 >= 0) {
                        }
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iF2 + ").state:" + a0Var.b() + recyclerView.exceptionLabel());
                    }
                    j2 = 4;
                    j3 = 3;
                    view = d0VarOnCreateViewHolder.itemView;
                    if (i2 != 0) {
                        i11 = d0VarOnCreateViewHolder.mFlags;
                        if ((i11 & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0) {
                            i12 = i3;
                        } else {
                            i12 = 0;
                        }
                        if (i12 != 0) {
                            d0VarOnCreateViewHolder.mFlags = i11 & (-8193);
                            if (a0Var.j) {
                                l.b(d0VarOnCreateViewHolder);
                                androidx.recyclerview.widget.k kVar2 = recyclerView.mItemAnimator;
                                d0VarOnCreateViewHolder.getUnmodifiedPayloads();
                                kVar2.getClass();
                                l.c cVar2 = new l.c();
                                cVar2.a(d0VarOnCreateViewHolder);
                                recyclerView.recordAnimationInfoIfBouncedHiddenView(d0VarOnCreateViewHolder, cVar2);
                            }
                        }
                    }
                    if (a0Var.g) {
                        if (d0VarOnCreateViewHolder.isBound()) {
                            if ((d0VarOnCreateViewHolder.mFlags & 2) != 0) {
                                i10 = i3;
                            } else {
                                i10 = 0;
                            }
                            if (i10 == 0) {
                            }
                        }
                        i4 = 0;
                        iF = recyclerView.mAdapterHelper.f(i, 0);
                        d0VarOnCreateViewHolder.mBindingAdapter = null;
                        d0VarOnCreateViewHolder.mOwnerRecyclerView = recyclerView;
                        i5 = d0VarOnCreateViewHolder.mItemViewType;
                        long jNanoTime5 = System.nanoTime();
                        if (j != Long.MAX_VALUE) {
                            j5 = this.g.a(i5).d;
                            if (j5 != 0) {
                                i9 = i3;
                            } else {
                                i9 = i3;
                            }
                            if (i9 == 0) {
                                i8 = i4;
                                i7 = i3;
                            }
                        }
                        gVar = recyclerView.mAdapter;
                        gVar.getClass();
                        if (d0VarOnCreateViewHolder.mBindingAdapter == null) {
                            i6 = i3;
                        } else {
                            i6 = 0;
                        }
                        if (i6 != 0) {
                            d0VarOnCreateViewHolder.mPosition = iF;
                            if (gVar.mHasStableIds) {
                                d0VarOnCreateViewHolder.mItemId = gVar.getItemId(iF);
                            }
                            d0VarOnCreateViewHolder.mFlags = i3 | (d0VarOnCreateViewHolder.mFlags & (-520));
                            int i24 = t71.$r8$clinit;
                            Trace.beginSection("RV OnBindView");
                        }
                        d0VarOnCreateViewHolder.mBindingAdapter = gVar;
                        d0VarOnCreateViewHolder.getUnmodifiedPayloads();
                        gVar.onBindViewHolder(d0VarOnCreateViewHolder, iF);
                        if (i6 != 0) {
                            arrayList3 = d0VarOnCreateViewHolder.mPayloads;
                            if (arrayList3 != null) {
                                arrayList3.clear();
                            }
                            d0VarOnCreateViewHolder.mFlags &= -1025;
                            layoutParams = view.getLayoutParams();
                            if (layoutParams instanceof p) {
                                ((p) layoutParams).c = i3;
                            }
                            int i25 = t71.$r8$clinit;
                            Trace.endSection();
                        }
                        jNanoTime = System.nanoTime() - jNanoTime5;
                        u.a aVarA3 = this.g.a(d0VarOnCreateViewHolder.mItemViewType);
                        j4 = aVarA3.d;
                        if (j4 != 0) {
                            jNanoTime = (jNanoTime / j2) + ((j4 / j2) * j3);
                        }
                        aVarA3.d = jNanoTime;
                        accessibilityManager = recyclerView.mAccessibilityManager;
                        if (accessibilityManager == null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (z) {
                            WeakHashMap weakHashMap2 = qd1.a;
                            i7 = 1;
                            if (view.getImportantForAccessibility() == 0) {
                                view.setImportantForAccessibility(1);
                            }
                            xVar = recyclerView.mAccessibilityDelegate;
                            if (xVar != null) {
                                itemDelegate = xVar.getItemDelegate();
                                if (itemDelegate instanceof androidx.recyclerview.widget.x.a) {
                                    aVar = (androidx.recyclerview.widget.x.a) itemDelegate;
                                    accessibilityDelegateD = qd1.d(view);
                                    if (accessibilityDelegateD == null) {
                                        a1Var = null;
                                    } else if (accessibilityDelegateD instanceof a1.a) {
                                        a1Var = ((a1.a) accessibilityDelegateD).a;
                                    } else {
                                        a1Var = new a1(accessibilityDelegateD);
                                    }
                                    if (a1Var != null) {
                                        aVar.b.put(view, a1Var);
                                    }
                                }
                                qd1.l(view, itemDelegate);
                            }
                        } else {
                            i7 = 1;
                        }
                        if (a0Var.g) {
                            d0VarOnCreateViewHolder.mPreLayoutPosition = i;
                        }
                        i8 = i7;
                    } else {
                        if (d0VarOnCreateViewHolder.isBound()) {
                            if ((d0VarOnCreateViewHolder.mFlags & 2) != 0) {
                                i10 = i3;
                            } else {
                                i10 = 0;
                            }
                            if (i10 == 0) {
                            }
                        }
                        i4 = 0;
                        iF = recyclerView.mAdapterHelper.f(i, 0);
                        d0VarOnCreateViewHolder.mBindingAdapter = null;
                        d0VarOnCreateViewHolder.mOwnerRecyclerView = recyclerView;
                        i5 = d0VarOnCreateViewHolder.mItemViewType;
                        long jNanoTime6 = System.nanoTime();
                        if (j != Long.MAX_VALUE) {
                            j5 = this.g.a(i5).d;
                            if (j5 != 0) {
                                i9 = i3;
                            } else {
                                i9 = i3;
                            }
                            if (i9 == 0) {
                                i8 = i4;
                                i7 = i3;
                            }
                        }
                        gVar = recyclerView.mAdapter;
                        gVar.getClass();
                        if (d0VarOnCreateViewHolder.mBindingAdapter == null) {
                            i6 = i3;
                        } else {
                            i6 = 0;
                        }
                        if (i6 != 0) {
                            d0VarOnCreateViewHolder.mPosition = iF;
                            if (gVar.mHasStableIds) {
                                d0VarOnCreateViewHolder.mItemId = gVar.getItemId(iF);
                            }
                            d0VarOnCreateViewHolder.mFlags = i3 | (d0VarOnCreateViewHolder.mFlags & (-520));
                            int i26 = t71.$r8$clinit;
                            Trace.beginSection("RV OnBindView");
                        }
                        d0VarOnCreateViewHolder.mBindingAdapter = gVar;
                        d0VarOnCreateViewHolder.getUnmodifiedPayloads();
                        gVar.onBindViewHolder(d0VarOnCreateViewHolder, iF);
                        if (i6 != 0) {
                            arrayList3 = d0VarOnCreateViewHolder.mPayloads;
                            if (arrayList3 != null) {
                                arrayList3.clear();
                            }
                            d0VarOnCreateViewHolder.mFlags &= -1025;
                            layoutParams = view.getLayoutParams();
                            if (layoutParams instanceof p) {
                                ((p) layoutParams).c = i3;
                            }
                            int i27 = t71.$r8$clinit;
                            Trace.endSection();
                        }
                        jNanoTime = System.nanoTime() - jNanoTime6;
                        u.a aVarA4 = this.g.a(d0VarOnCreateViewHolder.mItemViewType);
                        j4 = aVarA4.d;
                        if (j4 != 0) {
                            jNanoTime = (jNanoTime / j2) + ((j4 / j2) * j3);
                        }
                        aVarA4.d = jNanoTime;
                        accessibilityManager = recyclerView.mAccessibilityManager;
                        if (accessibilityManager == null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (z) {
                            WeakHashMap weakHashMap3 = qd1.a;
                            i7 = 1;
                            if (view.getImportantForAccessibility() == 0) {
                                view.setImportantForAccessibility(1);
                            }
                            xVar = recyclerView.mAccessibilityDelegate;
                            if (xVar != null) {
                                itemDelegate = xVar.getItemDelegate();
                                if (itemDelegate instanceof androidx.recyclerview.widget.x.a) {
                                    aVar = (androidx.recyclerview.widget.x.a) itemDelegate;
                                    accessibilityDelegateD = qd1.d(view);
                                    if (accessibilityDelegateD == null) {
                                        a1Var = null;
                                    } else if (accessibilityDelegateD instanceof a1.a) {
                                        a1Var = ((a1.a) accessibilityDelegateD).a;
                                    } else {
                                        a1Var = new a1(accessibilityDelegateD);
                                    }
                                    if (a1Var != null) {
                                        aVar.b.put(view, a1Var);
                                    }
                                }
                                qd1.l(view, itemDelegate);
                            }
                        } else {
                            i7 = 1;
                        }
                        if (a0Var.g) {
                            d0VarOnCreateViewHolder.mPreLayoutPosition = i;
                        }
                        i8 = i7;
                    }
                    layoutParams2 = view.getLayoutParams();
                    if (layoutParams2 != null) {
                        if (recyclerView.checkLayoutParams(layoutParams2)) {
                            layoutParamsGenerateLayoutParams = recyclerView.generateLayoutParams(layoutParams2);
                        } else {
                            pVar = (p) layoutParams2;
                        }
                        pVar.a = d0VarOnCreateViewHolder;
                        if (i2 != 0) {
                            r5 = i4;
                        } else {
                            r5 = i4;
                        }
                        pVar.d = r5;
                        return d0VarOnCreateViewHolder;
                    }
                    layoutParamsGenerateLayoutParams = recyclerView.generateDefaultLayoutParams();
                    pVar = (p) layoutParamsGenerateLayoutParams;
                    view.setLayoutParams(pVar);
                    pVar.a = d0VarOnCreateViewHolder;
                    if (i2 != 0) {
                        r5 = i4;
                    } else {
                        r5 = i4;
                    }
                    pVar.d = r5;
                    return d0VarOnCreateViewHolder;
                }
            }
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + recyclerView.mState.b() + recyclerView.exceptionLabel());
        }

        public final void k(d0 d0Var) {
            (d0Var.mInChangeScrap ? this.b : this.a).remove(d0Var);
            d0Var.mScrapContainer = null;
            d0Var.mInChangeScrap = false;
            d0Var.clearReturnedFromScrapFlag();
        }

        public final void l() {
            o oVar = RecyclerView.this.mLayout;
            this.f = this.e + (oVar != null ? oVar.mPrefetchMaxCountObserved : 0);
            ArrayList arrayList = this.c;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0 || arrayList.size() <= this.f) {
                    return;
                } else {
                    f(size);
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface w {
        void a();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class x extends i {
        public x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onChanged() {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.assertNotInLayoutOrScroll(null);
            recyclerView.mState.f = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (recyclerView.mAdapterHelper.g()) {
                return;
            }
            recyclerView.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeChanged(int i, Preference preference) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.assertNotInLayoutOrScroll(null);
            androidx.recyclerview.widget.a aVar = recyclerView.mAdapterHelper;
            ArrayList arrayList = aVar.b;
            arrayList.add(aVar.h(4, i, 1, preference));
            aVar.f |= 4;
            if (arrayList.size() == 1) {
                Class[] clsArr = RecyclerView.LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
                if (!recyclerView.mHasFixedSize || !recyclerView.mIsAttached) {
                    recyclerView.mAdapterUpdateDuringMeasure = true;
                    recyclerView.requestLayout();
                } else {
                    a aVar2 = recyclerView.mUpdateChildViewsRunnable;
                    WeakHashMap weakHashMap = qd1.a;
                    recyclerView.postOnAnimation(aVar2);
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class y extends defpackage.d {
        public static final Parcelable.Creator<y> CREATOR = new a();
        public Parcelable b;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Parcelable.ClassLoaderCreator<y> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new y[i];
            }
        }

        public y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        public y(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // defpackage.d, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.b, 0);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class z {
        public o mLayoutManager;
        public boolean mPendingInitialRun;
        public RecyclerView mRecyclerView;
        public boolean mRunning;
        public View mTargetView;
        public int mTargetPosition = -1;
        public final a mRecyclingAction = new a();

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class a {
            public int d = -1;
            public boolean f = false;
            public int a = 0;
            public int b = 0;
            public int c = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            public BaseInterpolator e = null;

            public final void a(RecyclerView recyclerView) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f = false;
                } else if (this.f) {
                    BaseInterpolator baseInterpolator = this.e;
                    if (baseInterpolator != null && this.c < 1) {
                        defpackage.d.AnonymousClass0.m("If you provide an interpolator, you must set a positive duration");
                        return;
                    }
                    int i2 = this.c;
                    if (i2 < 1) {
                        defpackage.d.AnonymousClass0.m("Scroll duration must be a positive number");
                    } else {
                        recyclerView.mViewFlinger.b(this.a, this.b, baseInterpolator, i2);
                        this.f = false;
                    }
                }
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public interface b {
            PointF computeScrollVectorForPosition(int i);
        }

        public final void onAnimation(int i, int i2) {
            Object obj;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && (obj = this.mLayoutManager) != null) {
                PointF pointFComputeScrollVectorForPosition = obj instanceof b ? ((b) obj).computeScrollVectorForPosition(this.mTargetPosition) : null;
                if (pointFComputeScrollVectorForPosition != null) {
                    float f = pointFComputeScrollVectorForPosition.x;
                    if (f != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f) {
                        recyclerView.scrollStep((int) Math.signum(f), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
                    }
                }
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            a aVar = this.mRecyclingAction;
            if (view != null) {
                this.mRecyclerView.getClass();
                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if ((childViewHolderInt != null ? childViewHolderInt.getLayoutPosition() : -1) == this.mTargetPosition) {
                    View view2 = this.mTargetView;
                    a0 a0Var = recyclerView.mState;
                    onTargetFound(view2, aVar);
                    aVar.a(recyclerView);
                    stop();
                } else {
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                a0 a0Var2 = recyclerView.mState;
                onSeekTargetStep(i, i2, aVar);
                boolean z = aVar.d >= 0;
                aVar.a(recyclerView);
                if (z && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.a();
                }
            }
        }

        public abstract void onSeekTargetStep(int i, int i2, a aVar);

        public abstract void onStop();

        public abstract void onTargetFound(View view, a aVar);

        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                o oVar = this.mLayoutManager;
                if (oVar.mSmoothScroller == this) {
                    oVar.mSmoothScroller = null;
                }
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    static {
        Class cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.yg);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x023d A[Catch: ClassCastException -> 0x0246, IllegalAccessException -> 0x0248, InstantiationException -> 0x024b, InvocationTargetException -> 0x024e, ClassNotFoundException -> 0x0251, TryCatch #4 {ClassCastException -> 0x0246, ClassNotFoundException -> 0x0251, IllegalAccessException -> 0x0248, InstantiationException -> 0x024b, InvocationTargetException -> 0x024e, blocks: (B:51:0x0237, B:53:0x023d, B:65:0x0258, B:66:0x0262, B:72:0x0284, B:70:0x027e, B:74:0x0293, B:75:0x02b3, B:64:0x0254), top: B:92:0x0237 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0254 A[Catch: ClassCastException -> 0x0246, IllegalAccessException -> 0x0248, InstantiationException -> 0x024b, InvocationTargetException -> 0x024e, ClassNotFoundException -> 0x0251, TryCatch #4 {ClassCastException -> 0x0246, ClassNotFoundException -> 0x0251, IllegalAccessException -> 0x0248, InstantiationException -> 0x024b, InvocationTargetException -> 0x024e, blocks: (B:51:0x0237, B:53:0x023d, B:65:0x0258, B:66:0x0262, B:72:0x0284, B:70:0x027e, B:74:0x0293, B:75:0x02b3, B:64:0x0254), top: B:92:0x0237 }] */
    public RecyclerView(Context context, AttributeSet attributeSet, int i2) throws NoSuchMethodException {
        float fA;
        char c2;
        int i3;
        StringBuilder sb;
        String str;
        ClassLoader classLoader;
        Class<? extends U> clsAsSubclass;
        Object[] objArr;
        Constructor constructor;
        super(context, attributeSet, i2);
        this.mObserver = new x();
        this.mRecycler = new v();
        this.mViewInfoStore = new androidx.recyclerview.widget.c0();
        this.mUpdateChildViewsRunnable = new a();
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new k();
        androidx.recyclerview.widget.k kVar = new androidx.recyclerview.widget.k();
        this.mItemAnimator = kVar;
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new c0();
        this.mPrefetchRegistry = new androidx.recyclerview.widget.m.b();
        this.mState = new a0();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        m mVar = new m();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new b();
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            Method method = ud1.a;
            fA = viewConfiguration.getScaledHorizontalScrollFactor();
        } else {
            fA = ud1.a(viewConfiguration, context);
        }
        this.mScaledHorizontalScrollFactor = fA;
        this.mScaledVerticalScrollFactor = i4 >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : ud1.a(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        kVar.a = mVar;
        this.mAdapterHelper = new androidx.recyclerview.widget.a(new f());
        this.mChildHelper = new androidx.recyclerview.widget.b(new e());
        WeakHashMap weakHashMap = qd1.a;
        if ((i4 >= 26 ? getImportantForAutofill() : 0) == 0 && i4 >= 26) {
            setImportantForAutofill(8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        androidx.recyclerview.widget.x xVar = new androidx.recyclerview.widget.x(this);
        this.mAccessibilityDelegate = xVar;
        qd1.l(this, xVar);
        int[] iArr = defpackage.e.f25b;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        qd1.k(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i2);
        String string = typedArrayObtainStyledAttributes.getString(8);
        if (typedArrayObtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(1, true);
        if (typedArrayObtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(6);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(5);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException("Trying to set fast scroller without both required drawables.".concat(exceptionLabel()));
            }
            Resources resources = getContext().getResources();
            i3 = 4;
            c2 = 3;
            new androidx.recyclerview.widget.l(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(org.hamotunnelplus.xyz.R.dimen.dk), resources.getDimensionPixelSize(org.hamotunnelplus.xyz.R.dimen.dm), resources.getDimensionPixelOffset(org.hamotunnelplus.xyz.R.dimen.dl));
        } else {
            c2 = 3;
            i3 = 4;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                try {
                    try {
                        if (strTrim.charAt(0) == '.') {
                            sb = new StringBuilder();
                            sb.append(context.getPackageName());
                        } else {
                            if (!strTrim.contains(".")) {
                                sb = new StringBuilder();
                                sb.append(RecyclerView.class.getPackage().getName());
                                sb.append('.');
                            }
                            str = strTrim;
                            if (isInEditMode()) {
                                classLoader = getClass().getClassLoader();
                            } else {
                                classLoader = context.getClassLoader();
                            }
                            clsAsSubclass = Class.forName(str, false, classLoader).asSubclass(o.class);
                            constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                            objArr = new Object[i3];
                            objArr[0] = context;
                            objArr[1] = attributeSet;
                            objArr[2] = Integer.valueOf(i2);
                            objArr[c2] = 0;
                            constructor.setAccessible(true);
                            setLayoutManager((o) constructor.newInstance(objArr));
                        }
                        constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[i3];
                        objArr[0] = context;
                        objArr[1] = attributeSet;
                        objArr[2] = Integer.valueOf(i2);
                        objArr[c2] = 0;
                    } catch (NoSuchMethodException e2) {
                        try {
                            objArr = null;
                            constructor = clsAsSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e3);
                        }
                    }
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    clsAsSubclass = Class.forName(str, false, classLoader).asSubclass(o.class);
                    constructor.setAccessible(true);
                    setLayoutManager((o) constructor.newInstance(objArr));
                } catch (ClassCastException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e4);
                } catch (ClassNotFoundException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e6);
                } catch (InstantiationException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e8);
                }
                sb.append(strTrim);
                strTrim = sb.toString();
                str = strTrim;
            }
        }
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i2, 0);
        qd1.k(this, context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i2);
        boolean z2 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
    }

    public static void clearNestedRecyclerViewIfNotNested(d0 d0Var) {
        WeakReference weakReference = d0Var.mNestedRecyclerView;
        if (weakReference == null) {
            return;
        }
        Object parent = weakReference.get();
        while (true) {
            View view = (View) parent;
            while (true) {
                if (view == null) {
                    d0Var.mNestedRecyclerView = null;
                    return;
                } else {
                    if (view == d0Var.itemView) {
                        return;
                    }
                    parent = view.getParent();
                    if (parent instanceof View) {
                        break;
                    } else {
                        view = null;
                    }
                }
            }
        }
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    public static d0 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).a;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    public final void addAnimatingView(d0 d0Var) {
        View view = d0Var.itemView;
        boolean z2 = view.getParent() == this;
        this.mRecycler.k(getChildViewHolder(view));
        boolean zIsTmpDetached = d0Var.isTmpDetached();
        androidx.recyclerview.widget.b bVar = this.mChildHelper;
        if (zIsTmpDetached) {
            bVar.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z2) {
            bVar.a(view, -1, true);
            return;
        }
        int iIndexOfChild = RecyclerView.this.indexOfChild(view);
        if (iIndexOfChild < 0) {
            defpackage.d.AnonymousClass0.m("view is not a child, cannot hide ", view);
        } else {
            bVar.b.h(iIndexOfChild);
            bVar.i(view);
        }
    }

    public final void addItemDecoration(n nVar) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.mItemDecorations;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(nVar);
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public final void addOnScrollListener(t tVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(tVar);
    }

    public final void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling".concat(exceptionLabel()));
            }
            defpackage.d.AnonymousClass0.m(str);
        } else if (this.mDispatchScrollCounter > 0) {
            new IllegalStateException(exceptionLabel());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.mLayout.checkLayoutParams((p) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public final void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = qd1.a;
            postInvalidateOnAnimation();
        }
    }

    public final void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            int i2 = t71.$r8$clinit;
            Trace.beginSection("RV FullInvalidate");
            dispatchLayout();
            Trace.endSection();
            return;
        }
        androidx.recyclerview.widget.a aVar = this.mAdapterHelper;
        if (aVar.g()) {
            int i3 = aVar.f;
            if ((i3 & 4) != 0 && (i3 & 11) == 0) {
                int i4 = t71.$r8$clinit;
                Trace.beginSection("RV PartialInvalidate");
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                aVar.j();
                if (!this.mLayoutWasDefered) {
                    androidx.recyclerview.widget.b bVar = this.mChildHelper;
                    int iE = bVar.e();
                    int i5 = 0;
                    while (true) {
                        if (i5 < iE) {
                            d0 childViewHolderInt = getChildViewHolderInt(bVar.d(i5));
                            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                                dispatchLayout();
                                break;
                            }
                            i5++;
                        } else {
                            aVar.b();
                            break;
                        }
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll(true);
            } else {
                if (!aVar.g()) {
                    return;
                }
                int i6 = t71.$r8$clinit;
                Trace.beginSection("RV FullInvalidate");
                dispatchLayout();
            }
            Trace.endSection();
        }
    }

    public final void defaultOnMeasure(int i2, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = qd1.a;
        setMeasuredDimension(o.chooseSize(i2, paddingRight, getMinimumWidth()), o.chooseSize(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x022d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0231  */
    /* JADX WARN: Code duplicated, block: B:105:0x0235  */
    /* JADX WARN: Code duplicated, block: B:106:0x0241  */
    /* JADX WARN: Code duplicated, block: B:107:0x0244  */
    /* JADX WARN: Code duplicated, block: B:109:0x024a  */
    /* JADX WARN: Code duplicated, block: B:110:0x024e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0254  */
    /* JADX WARN: Code duplicated, block: B:114:0x0268  */
    /* JADX WARN: Code duplicated, block: B:116:0x026e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0270  */
    /* JADX WARN: Code duplicated, block: B:123:0x0286  */
    /* JADX WARN: Code duplicated, block: B:125:0x0295 A[PHI: r5
      0x0295: PHI (r5v24 androidx.recyclerview.widget.RecyclerView) = (r5v22 androidx.recyclerview.widget.RecyclerView), (r5v26 androidx.recyclerview.widget.RecyclerView) binds: [B:124:0x0293, B:116:0x026e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:128:0x029d  */
    /* JADX WARN: Code duplicated, block: B:130:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:133:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:134:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:136:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:138:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:144:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:148:0x0300  */
    /* JADX WARN: Code duplicated, block: B:149:0x0304  */
    /* JADX WARN: Code duplicated, block: B:158:0x0333  */
    /* JADX WARN: Code duplicated, block: B:160:0x0345  */
    /* JADX WARN: Code duplicated, block: B:163:0x035f  */
    /* JADX WARN: Code duplicated, block: B:166:0x037e  */
    /* JADX WARN: Code duplicated, block: B:169:0x0387  */
    /* JADX WARN: Code duplicated, block: B:176:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:178:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:194:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:197:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:199:0x0403  */
    /* JADX WARN: Code duplicated, block: B:216:0x0441  */
    /* JADX WARN: Code duplicated, block: B:218:0x0444  */
    /* JADX WARN: Code duplicated, block: B:220:0x0450  */
    /* JADX WARN: Code duplicated, block: B:224:0x0459  */
    /* JADX WARN: Code duplicated, block: B:226:0x0461  */
    /* JADX WARN: Code duplicated, block: B:229:0x0468  */
    /* JADX WARN: Code duplicated, block: B:232:0x0470  */
    /* JADX WARN: Code duplicated, block: B:235:0x0477  */
    /* JADX WARN: Code duplicated, block: B:238:0x0481 A[LOOP:4: B:231:0x046e->B:238:0x0481, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:241:0x048e  */
    /* JADX WARN: Code duplicated, block: B:244:0x0495  */
    /* JADX WARN: Code duplicated, block: B:247:0x049f A[LOOP:5: B:240:0x048c->B:247:0x049f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:248:0x04a2 A[EDGE_INSN: B:248:0x04a2->B:249:0x04a3 BREAK  A[LOOP:5: B:240:0x048c->B:247:0x049f]] */
    /* JADX WARN: Code duplicated, block: B:250:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:252:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:277:0x0484 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:278:0x0484 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x047f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:280:0x04a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:281:0x04a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:282:0x049d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:93:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:98:0x0216  */
    /* JADX WARN: Instruction removed from duplicated block: B:130:0x02a1, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r9v9, types: [android.view.View] */
    public final void dispatchLayout() {
        int i2;
        boolean z2;
        v vVar;
        androidx.recyclerview.widget.c0 c0Var;
        d0 d0Var;
        boolean z3;
        int i3;
        d0 d0Var2;
        ArrayList arrayList;
        o oVar;
        boolean z4;
        int[] iArr;
        int i4;
        boolean z5;
        long j2;
        d0 d0Var3;
        ?? r9;
        int i5;
        int iB;
        int i6;
        int iMin;
        d0 d0VarFindViewHolderForAdapterPosition;
        View view;
        d0 d0VarFindViewHolderForAdapterPosition2;
        View view2;
        int i7;
        ?? r10;
        View viewFindViewById;
        View view3;
        boolean z6;
        int iE;
        o01 o01Var;
        int i8;
        d0 d0Var4;
        androidx.recyclerview.widget.c0.a aVar;
        int i9;
        int i10;
        d dVar;
        l.c cVar;
        l.c cVar2;
        l.c cVar3;
        RecyclerView recyclerView;
        boolean z7;
        androidx.recyclerview.widget.k kVar;
        int i11;
        int i12;
        RecyclerView recyclerView2;
        boolean zG;
        l.c cVar4;
        RecyclerView recyclerView3;
        androidx.recyclerview.widget.k kVar2;
        boolean zG2;
        int i13;
        int i14;
        l.c cVar5;
        RecyclerView recyclerView4;
        androidx.recyclerview.widget.k kVar3;
        View view4;
        int left;
        int top;
        boolean zG3;
        d0 childViewHolderInt;
        l.c cVar6;
        o01 o01Var2;
        d0 d0Var5;
        boolean z8;
        androidx.recyclerview.widget.c0.a aVarA;
        androidx.recyclerview.widget.c0.a aVarA2;
        if (this.mAdapter == null || this.mLayout == null) {
            return;
        }
        a0 a0Var = this.mState;
        a0Var.i = false;
        boolean z9 = true;
        boolean z10 = this.mLastAutoMeasureSkippedDueToExact && !(this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight());
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (a0Var.d != 1) {
            androidx.recyclerview.widget.a aVar2 = this.mAdapterHelper;
            if ((aVar2.c.isEmpty() || aVar2.b.isEmpty()) && !z10 && this.mLayout.mWidth == getWidth() && this.mLayout.mHeight == getHeight()) {
                o oVar2 = this.mLayout;
                oVar2.getClass();
                oVar2.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            }
            i2 = 4;
            a0Var.a(4);
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            a0Var.d = 1;
            z2 = a0Var.j;
            vVar = this.mRecycler;
            c0Var = this.mViewInfoStore;
            d0Var = null;
            if (z2) {
                iE = this.mChildHelper.e() - 1;
                while (iE >= 0) {
                    childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(iE));
                    if (childViewHolderInt.shouldIgnore()) {
                        z8 = z9;
                    } else {
                        long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                        androidx.recyclerview.widget.k kVar4 = this.mItemAnimator;
                        kVar4.getClass();
                        cVar6 = new l.c();
                        cVar6.a(childViewHolderInt);
                        qf0 qf0Var = c0Var.b;
                        o01Var2 = c0Var.a;
                        d0Var5 = (d0) qf0Var.f(changedHolderKey, null);
                        z8 = z9;
                        if (d0Var5 != null || d0Var5.shouldIgnore()) {
                            aVarA = (androidx.recyclerview.widget.c0.a) o01Var2.getOrDefault(childViewHolderInt, null);
                            if (aVarA == null) {
                                aVarA = androidx.recyclerview.widget.c0.a.a();
                                o01Var2.put(childViewHolderInt, aVarA);
                            }
                            aVarA.c = cVar6;
                            aVarA.a |= 8;
                        } else {
                            androidx.recyclerview.widget.c0.a aVar3 = (androidx.recyclerview.widget.c0.a) o01Var2.getOrDefault(d0Var5, null);
                            boolean z11 = (aVar3 == null || (aVar3.a & 1) == 0) ? false : z8;
                            androidx.recyclerview.widget.c0.a aVar4 = (androidx.recyclerview.widget.c0.a) o01Var2.getOrDefault(childViewHolderInt, null);
                            boolean z12 = (aVar4 == null || (aVar4.a & 1) == 0) ? false : z8;
                            if (z11 && d0Var5 == childViewHolderInt) {
                                aVarA = (androidx.recyclerview.widget.c0.a) o01Var2.getOrDefault(childViewHolderInt, null);
                                if (aVarA == null) {
                                    aVarA = androidx.recyclerview.widget.c0.a.a();
                                    o01Var2.put(childViewHolderInt, aVarA);
                                }
                                aVarA.c = cVar6;
                                aVarA.a |= 8;
                            } else {
                                boolean z13 = z11;
                                l.c cVarB = c0Var.b(d0Var5, i2);
                                androidx.recyclerview.widget.c0.a aVar5 = (androidx.recyclerview.widget.c0.a) o01Var2.getOrDefault(childViewHolderInt, null);
                                if (aVar5 == null) {
                                    aVarA2 = androidx.recyclerview.widget.c0.a.a();
                                    o01Var2.put(childViewHolderInt, aVarA2);
                                } else {
                                    aVarA2 = aVar5;
                                }
                                aVarA2.c = cVar6;
                                aVarA2.a |= 8;
                                l.c cVarB2 = c0Var.b(childViewHolderInt, 8);
                                if (cVarB == null) {
                                    int iE2 = this.mChildHelper.e();
                                    for (int i15 = 0; i15 < iE2; i15++) {
                                        d0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.d(i15));
                                        if (childViewHolderInt2 != childViewHolderInt && getChangedHolderKey(childViewHolderInt2) == changedHolderKey) {
                                            g gVar = this.mAdapter;
                                            if (gVar == null || !gVar.mHasStableIds) {
                                                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt2 + " \n View Holder 2:" + childViewHolderInt + exceptionLabel());
                                            }
                                            throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt2 + " \n View Holder 2:" + childViewHolderInt + exceptionLabel());
                                        }
                                    }
                                    Objects.toString(d0Var5);
                                    Objects.toString(childViewHolderInt);
                                    exceptionLabel();
                                } else {
                                    d0Var5.setIsRecyclable(false);
                                    if (z13) {
                                        addAnimatingView(d0Var5);
                                    }
                                    if (d0Var5 != childViewHolderInt) {
                                        if (z12) {
                                            addAnimatingView(childViewHolderInt);
                                        }
                                        d0Var5.mShadowedHolder = childViewHolderInt;
                                        addAnimatingView(d0Var5);
                                        vVar.k(d0Var5);
                                        childViewHolderInt.setIsRecyclable(false);
                                        childViewHolderInt.mShadowingHolder = d0Var5;
                                    }
                                    if (kVar4.a(d0Var5, childViewHolderInt, cVarB, cVarB2)) {
                                        postAnimationRunner();
                                    }
                                }
                            }
                        }
                    }
                    iE--;
                    z9 = z8;
                    i2 = 4;
                }
                z3 = z9;
                i3 = -1;
                o01Var = c0Var.a;
                i8 = o01Var.d - 1;
                while (i8 >= 0) {
                    d0Var4 = (d0) o01Var.i(i8);
                    aVar = (androidx.recyclerview.widget.c0.a) o01Var.j(i8);
                    i9 = aVar.a;
                    i10 = i9 & 3;
                    dVar = this.mViewInfoProcessCallback;
                    if (i10 != 3) {
                        if ((i9 & 1) != 0) {
                            cVar = aVar.b;
                            cVar5 = cVar != null ? aVar.c : null;
                            RecyclerView recyclerView5 = RecyclerView.this;
                            recyclerView5.mLayout.removeAndRecycleView(d0Var4.itemView, recyclerView5.mRecycler);
                            o01Var = o01Var;
                        } else {
                            if ((i9 & 14) == 14) {
                                o01Var = o01Var;
                            } else if ((i9 & 12) == 12) {
                                cVar2 = aVar.b;
                                cVar3 = aVar.c;
                                dVar.getClass();
                                d0Var4.setIsRecyclable(false);
                                recyclerView = RecyclerView.this;
                                z7 = recyclerView.mDataSetHasChangedAfterLayout;
                                kVar = recyclerView.mItemAnimator;
                                if (z7) {
                                    kVar.getClass();
                                    i11 = cVar2.a;
                                    i12 = cVar3.a;
                                    if (i11 == i12 || cVar2.b != cVar3.b) {
                                        recyclerView2 = recyclerView;
                                        zG = kVar.g(d0Var4, i11, cVar2.b, i12, cVar3.b);
                                    } else {
                                        kVar.c(d0Var4);
                                        recyclerView2 = recyclerView;
                                        zG = false;
                                    }
                                    if (zG) {
                                        recyclerView2.postAnimationRunner();
                                    }
                                } else if (kVar.a(d0Var4, d0Var4, cVar2, cVar3)) {
                                    recyclerView2 = recyclerView;
                                    recyclerView2.postAnimationRunner();
                                }
                                o01Var = o01Var;
                            } else if ((i9 & 4) != 0) {
                                cVar = aVar.b;
                            } else {
                                o01Var = o01Var;
                                if ((i9 & 8) != 0) {
                                }
                            }
                            cVar4 = aVar.b;
                            l.c cVar7 = aVar.c;
                            recyclerView3 = RecyclerView.this;
                            recyclerView3.getClass();
                            d0Var4.setIsRecyclable(false);
                            kVar2 = recyclerView3.mItemAnimator;
                            kVar2.getClass();
                            if (cVar4 != null || ((i13 = cVar4.a) == (i14 = cVar7.a) && cVar4.b == cVar7.b)) {
                                kVar2.l(d0Var4);
                                d0Var4.itemView.setAlpha(0.0f);
                                kVar2.i.add(d0Var4);
                                zG2 = z3;
                            } else {
                                zG2 = kVar2.g(d0Var4, i13, cVar4.b, i14, cVar7.b);
                            }
                            if (zG2) {
                                recyclerView3.postAnimationRunner();
                            }
                        }
                        recyclerView4 = RecyclerView.this;
                        recyclerView4.mRecycler.k(d0Var4);
                        recyclerView4.addAnimatingView(d0Var4);
                        d0Var4.setIsRecyclable(false);
                        kVar3 = recyclerView4.mItemAnimator;
                        kVar3.getClass();
                        int i16 = cVar.a;
                        int i17 = cVar.b;
                        view4 = d0Var4.itemView;
                        if (cVar5 == null) {
                            left = view4.getLeft();
                        } else {
                            left = cVar5.a;
                        }
                        if (cVar5 == null) {
                            top = view4.getTop();
                        } else {
                            top = cVar5.b;
                        }
                        int i18 = top;
                        if (!d0Var4.isRemoved() || (i16 == left && i17 == i18)) {
                            kVar3.l(d0Var4);
                            kVar3.h.add(d0Var4);
                            zG3 = z3;
                        } else {
                            view4.layout(left, i18, view4.getWidth() + left, view4.getHeight() + i18);
                            zG3 = kVar3.g(d0Var4, i16, i17, left, i18);
                        }
                        if (zG3) {
                            recyclerView4.postAnimationRunner();
                        }
                    } else {
                        RecyclerView recyclerView6 = RecyclerView.this;
                        recyclerView6.mLayout.removeAndRecycleView(d0Var4.itemView, recyclerView6.mRecycler);
                        o01Var = o01Var;
                    }
                    aVar.a = 0;
                    aVar.b = null;
                    aVar.c = null;
                    androidx.recyclerview.widget.c0.a.d.a(aVar);
                    i8--;
                    d0Var = null;
                    o01Var = o01Var;
                }
            } else {
                z3 = true;
                i3 = -1;
            }
            d0Var2 = d0Var;
            this.mLayout.removeAndRecycleScrapInt(vVar);
            a0Var.b = a0Var.e;
            this.mDataSetHasChangedAfterLayout = false;
            this.mDispatchItemsChangedEvent = false;
            a0Var.j = false;
            a0Var.k = false;
            this.mLayout.mRequestedSimpleAnimations = false;
            arrayList = vVar.b;
            if (arrayList != null) {
                arrayList.clear();
            }
            oVar = this.mLayout;
            if (oVar.mPrefetchMaxObservedInInitialPrefetch) {
                oVar.mPrefetchMaxCountObserved = 0;
                oVar.mPrefetchMaxObservedInInitialPrefetch = false;
                vVar.l();
            }
            this.mLayout.onLayoutCompleted(a0Var);
            z4 = z3;
            onExitLayoutOrScroll(z4);
            stopInterceptRequestLayout(false);
            c0Var.a.clear();
            c0Var.b.c();
            iArr = this.mMinMaxLayoutPositions;
            i4 = iArr[0];
            int i19 = iArr[z4 ? 1 : 0];
            findMinMaxChildLayoutPositions(iArr);
            if (iArr[0] == i4 || iArr[z4 ? 1 : 0] != i19) {
                z5 = z4 ? 1 : 0;
            } else {
                z5 = false;
            }
            if (z5) {
                dispatchOnScrolled(0, 0);
            }
            if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
                if (!isFocused()) {
                    j2 = a0Var.m;
                    if (j2 == -1) {
                        d0Var3 = d0Var2;
                    } else {
                        d0Var3 = d0Var2;
                    }
                    if (d0Var3 != null) {
                        view3 = d0Var3.itemView;
                        if (!this.mChildHelper.c.contains(view3)) {
                            if (this.mChildHelper.e() <= 0) {
                                r9 = d0Var2;
                                break;
                            }
                            i5 = a0Var.l;
                            if (i5 == i3) {
                                i5 = 0;
                            }
                            iB = a0Var.b();
                            i6 = i5;
                            while (true) {
                                if (i6 < iB) {
                                    d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i6);
                                    if (d0VarFindViewHolderForAdapterPosition2 != null) {
                                        view2 = d0VarFindViewHolderForAdapterPosition2.itemView;
                                        if (view2.hasFocusable()) {
                                            r9 = view2;
                                        } else {
                                            i6++;
                                        }
                                    }
                                }
                                iMin = Math.min(iB, i5) - 1;
                                while (true) {
                                    if (iMin >= 0) {
                                        d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                        if (d0VarFindViewHolderForAdapterPosition != null) {
                                            view = d0VarFindViewHolderForAdapterPosition.itemView;
                                            if (view.hasFocusable()) {
                                                r9 = view;
                                                break;
                                            }
                                            iMin--;
                                        }
                                    }
                                    r9 = d0Var2;
                                    break;
                                }
                            }
                        } else {
                            if (this.mChildHelper.e() <= 0) {
                                r9 = d0Var2;
                                break;
                            }
                            i5 = a0Var.l;
                            if (i5 == i3) {
                                i5 = 0;
                            }
                            iB = a0Var.b();
                            i6 = i5;
                            while (true) {
                                if (i6 < iB) {
                                    d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i6);
                                    if (d0VarFindViewHolderForAdapterPosition2 != null) {
                                        view2 = d0VarFindViewHolderForAdapterPosition2.itemView;
                                        if (view2.hasFocusable()) {
                                            r9 = view2;
                                        } else {
                                            i6++;
                                        }
                                    }
                                }
                                iMin = Math.min(iB, i5) - 1;
                                while (true) {
                                    if (iMin >= 0) {
                                        d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                        if (d0VarFindViewHolderForAdapterPosition != null) {
                                            view = d0VarFindViewHolderForAdapterPosition.itemView;
                                            if (view.hasFocusable()) {
                                                r9 = view;
                                                break;
                                            }
                                            iMin--;
                                        }
                                    }
                                    r9 = d0Var2;
                                    break;
                                }
                            }
                        }
                    } else {
                        if (this.mChildHelper.e() <= 0) {
                            r9 = d0Var2;
                            break;
                        }
                        i5 = a0Var.l;
                        if (i5 == i3) {
                            i5 = 0;
                        }
                        iB = a0Var.b();
                        i6 = i5;
                        while (true) {
                            if (i6 < iB) {
                                d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i6);
                                if (d0VarFindViewHolderForAdapterPosition2 != null) {
                                    view2 = d0VarFindViewHolderForAdapterPosition2.itemView;
                                    if (view2.hasFocusable()) {
                                        r9 = view2;
                                    } else {
                                        i6++;
                                    }
                                }
                            }
                            iMin = Math.min(iB, i5) - 1;
                            while (true) {
                                if (iMin >= 0) {
                                    d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                    if (d0VarFindViewHolderForAdapterPosition != null) {
                                        view = d0VarFindViewHolderForAdapterPosition.itemView;
                                        if (view.hasFocusable()) {
                                            r9 = view;
                                            break;
                                        }
                                        iMin--;
                                    }
                                }
                                r9 = d0Var2;
                                break;
                            }
                        }
                    }
                    if (r9 != 0) {
                        i7 = a0Var.n;
                        if (i7 != -1) {
                            r10 = r9;
                            r10 = r9;
                            r10 = r9;
                            r10 = viewFindViewById;
                        }
                        r10 = r9;
                        r10 = r9;
                        r10 = r9;
                        r10 = r9;
                        r10 = r9;
                        r10 = r9;
                        r10.requestFocus();
                    }
                } else if (this.mChildHelper.c.contains(getFocusedChild())) {
                    j2 = a0Var.m;
                    if (j2 == -1 && (z6 = this.mAdapter.mHasStableIds) && z6) {
                        int iH = this.mChildHelper.h();
                        d0Var3 = d0Var2;
                        for (int i20 = 0; i20 < iH; i20++) {
                            d0 childViewHolderInt3 = getChildViewHolderInt(this.mChildHelper.g(i20));
                            if (childViewHolderInt3 != null && !childViewHolderInt3.isRemoved() && childViewHolderInt3.mItemId == j2) {
                                if (!this.mChildHelper.c.contains(childViewHolderInt3.itemView)) {
                                    d0Var3 = childViewHolderInt3;
                                    break;
                                }
                                d0Var3 = childViewHolderInt3;
                            }
                        }
                    } else {
                        d0Var3 = d0Var2;
                    }
                    if (d0Var3 != null) {
                        view3 = d0Var3.itemView;
                        if (!this.mChildHelper.c.contains(view3) && view3.hasFocusable()) {
                            r9 = view3;
                        } else {
                            if (this.mChildHelper.e() <= 0) {
                                r9 = d0Var2;
                                break;
                            }
                            i5 = a0Var.l;
                            if (i5 == i3) {
                                i5 = 0;
                            }
                            iB = a0Var.b();
                            i6 = i5;
                            while (true) {
                                if (i6 < iB) {
                                    d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i6);
                                    if (d0VarFindViewHolderForAdapterPosition2 != null) {
                                        view2 = d0VarFindViewHolderForAdapterPosition2.itemView;
                                        if (view2.hasFocusable()) {
                                            r9 = view2;
                                        } else {
                                            i6++;
                                        }
                                    }
                                }
                                iMin = Math.min(iB, i5) - 1;
                                while (true) {
                                    if (iMin >= 0) {
                                        d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                        if (d0VarFindViewHolderForAdapterPosition != null) {
                                            view = d0VarFindViewHolderForAdapterPosition.itemView;
                                            if (view.hasFocusable()) {
                                                r9 = view;
                                                break;
                                            }
                                            iMin--;
                                        }
                                    }
                                    r9 = d0Var2;
                                    break;
                                }
                            }
                        }
                    } else {
                        if (this.mChildHelper.e() <= 0) {
                            r9 = d0Var2;
                            break;
                        }
                        i5 = a0Var.l;
                        if (i5 == i3) {
                            i5 = 0;
                        }
                        iB = a0Var.b();
                        i6 = i5;
                        while (true) {
                            if (i6 < iB) {
                                d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i6);
                                if (d0VarFindViewHolderForAdapterPosition2 != null) {
                                    view2 = d0VarFindViewHolderForAdapterPosition2.itemView;
                                    if (view2.hasFocusable()) {
                                        r9 = view2;
                                    } else {
                                        i6++;
                                    }
                                }
                            }
                            iMin = Math.min(iB, i5) - 1;
                            while (true) {
                                if (iMin >= 0) {
                                    d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                    if (d0VarFindViewHolderForAdapterPosition != null) {
                                        view = d0VarFindViewHolderForAdapterPosition.itemView;
                                        if (view.hasFocusable()) {
                                            r9 = view;
                                            break;
                                        }
                                        iMin--;
                                    }
                                }
                                r9 = d0Var2;
                                break;
                            }
                        }
                    }
                    if (r9 != 0) {
                        i7 = a0Var.n;
                        if (i7 != -1 && (viewFindViewById = r9.findViewById(i7)) != null && viewFindViewById.isFocusable()) {
                            r10 = r9;
                            r10 = r9;
                            r10 = r9;
                            r10 = viewFindViewById;
                        }
                        r10 = r9;
                        r10 = r9;
                        r10 = r9;
                        r10 = r9;
                        r10 = r9;
                        r10 = r9;
                        r10.requestFocus();
                    }
                }
            }
            a0Var.m = -1L;
            a0Var.l = -1;
            a0Var.n = -1;
        }
        dispatchLayoutStep1();
        o oVar3 = this.mLayout;
        oVar3.getClass();
        oVar3.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        dispatchLayoutStep2();
        i2 = 4;
        a0Var.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        a0Var.d = 1;
        z2 = a0Var.j;
        vVar = this.mRecycler;
        c0Var = this.mViewInfoStore;
        d0Var = null;
        if (z2) {
            iE = this.mChildHelper.e() - 1;
            while (iE >= 0) {
                childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(iE));
                if (childViewHolderInt.shouldIgnore()) {
                    z8 = z9;
                } else {
                    long changedHolderKey2 = getChangedHolderKey(childViewHolderInt);
                    androidx.recyclerview.widget.k kVar5 = this.mItemAnimator;
                    kVar5.getClass();
                    cVar6 = new l.c();
                    cVar6.a(childViewHolderInt);
                    qf0 qf0Var2 = c0Var.b;
                    o01Var2 = c0Var.a;
                    d0Var5 = (d0) qf0Var2.f(changedHolderKey2, null);
                    z8 = z9;
                    if (d0Var5 != null) {
                        aVarA = (androidx.recyclerview.widget.c0.a) o01Var2.getOrDefault(childViewHolderInt, null);
                        if (aVarA == null) {
                            aVarA = androidx.recyclerview.widget.c0.a.a();
                            o01Var2.put(childViewHolderInt, aVarA);
                        }
                        aVarA.c = cVar6;
                        aVarA.a |= 8;
                    } else {
                        aVarA = (androidx.recyclerview.widget.c0.a) o01Var2.getOrDefault(childViewHolderInt, null);
                        if (aVarA == null) {
                            aVarA = androidx.recyclerview.widget.c0.a.a();
                            o01Var2.put(childViewHolderInt, aVarA);
                        }
                        aVarA.c = cVar6;
                        aVarA.a |= 8;
                    }
                }
                iE--;
                z9 = z8;
                i2 = 4;
            }
            z3 = z9;
            i3 = -1;
            o01Var = c0Var.a;
            i8 = o01Var.d - 1;
            while (i8 >= 0) {
                d0Var4 = (d0) o01Var.i(i8);
                aVar = (androidx.recyclerview.widget.c0.a) o01Var.j(i8);
                i9 = aVar.a;
                i10 = i9 & 3;
                dVar = this.mViewInfoProcessCallback;
                if (i10 != 3) {
                    if ((i9 & 1) != 0) {
                        cVar = aVar.b;
                        if (cVar != null) {
                        }
                        RecyclerView recyclerView7 = RecyclerView.this;
                        recyclerView7.mLayout.removeAndRecycleView(d0Var4.itemView, recyclerView7.mRecycler);
                        o01Var = o01Var;
                    } else {
                        if ((i9 & 14) == 14) {
                            o01Var = o01Var;
                        } else if ((i9 & 12) == 12) {
                            cVar2 = aVar.b;
                            cVar3 = aVar.c;
                            dVar.getClass();
                            d0Var4.setIsRecyclable(false);
                            recyclerView = RecyclerView.this;
                            z7 = recyclerView.mDataSetHasChangedAfterLayout;
                            kVar = recyclerView.mItemAnimator;
                            if (z7) {
                                kVar.getClass();
                                i11 = cVar2.a;
                                i12 = cVar3.a;
                                if (i11 == i12) {
                                    recyclerView2 = recyclerView;
                                    zG = kVar.g(d0Var4, i11, cVar2.b, i12, cVar3.b);
                                } else {
                                    recyclerView2 = recyclerView;
                                    zG = kVar.g(d0Var4, i11, cVar2.b, i12, cVar3.b);
                                }
                                if (zG) {
                                    recyclerView2.postAnimationRunner();
                                }
                            } else if (kVar.a(d0Var4, d0Var4, cVar2, cVar3)) {
                                recyclerView2 = recyclerView;
                                recyclerView2.postAnimationRunner();
                            }
                            o01Var = o01Var;
                        } else if ((i9 & 4) != 0) {
                            cVar = aVar.b;
                        } else {
                            o01Var = o01Var;
                            if ((i9 & 8) != 0) {
                            }
                        }
                        cVar4 = aVar.b;
                        l.c cVar8 = aVar.c;
                        recyclerView3 = RecyclerView.this;
                        recyclerView3.getClass();
                        d0Var4.setIsRecyclable(false);
                        kVar2 = recyclerView3.mItemAnimator;
                        kVar2.getClass();
                        if (cVar4 != null) {
                            kVar2.l(d0Var4);
                            d0Var4.itemView.setAlpha(0.0f);
                            kVar2.i.add(d0Var4);
                            zG2 = z3;
                        } else {
                            kVar2.l(d0Var4);
                            d0Var4.itemView.setAlpha(0.0f);
                            kVar2.i.add(d0Var4);
                            zG2 = z3;
                        }
                        if (zG2) {
                            recyclerView3.postAnimationRunner();
                        }
                    }
                    recyclerView4 = RecyclerView.this;
                    recyclerView4.mRecycler.k(d0Var4);
                    recyclerView4.addAnimatingView(d0Var4);
                    d0Var4.setIsRecyclable(false);
                    kVar3 = recyclerView4.mItemAnimator;
                    kVar3.getClass();
                    int i110 = cVar.a;
                    int i111 = cVar.b;
                    view4 = d0Var4.itemView;
                    if (cVar5 == null) {
                        left = view4.getLeft();
                    } else {
                        left = cVar5.a;
                    }
                    if (cVar5 == null) {
                        top = view4.getTop();
                    } else {
                        top = cVar5.b;
                    }
                    int i112 = top;
                    if (d0Var4.isRemoved()) {
                        kVar3.l(d0Var4);
                        kVar3.h.add(d0Var4);
                        zG3 = z3;
                    } else {
                        kVar3.l(d0Var4);
                        kVar3.h.add(d0Var4);
                        zG3 = z3;
                    }
                    if (zG3) {
                        recyclerView4.postAnimationRunner();
                    }
                } else {
                    RecyclerView recyclerView8 = RecyclerView.this;
                    recyclerView8.mLayout.removeAndRecycleView(d0Var4.itemView, recyclerView8.mRecycler);
                    o01Var = o01Var;
                }
                aVar.a = 0;
                aVar.b = null;
                aVar.c = null;
                androidx.recyclerview.widget.c0.a.d.a(aVar);
                i8--;
                d0Var = null;
                o01Var = o01Var;
            }
        } else {
            z3 = true;
            i3 = -1;
        }
        d0Var2 = d0Var;
        this.mLayout.removeAndRecycleScrapInt(vVar);
        a0Var.b = a0Var.e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        a0Var.j = false;
        a0Var.k = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        arrayList = vVar.b;
        if (arrayList != null) {
            arrayList.clear();
        }
        oVar = this.mLayout;
        if (oVar.mPrefetchMaxObservedInInitialPrefetch) {
            oVar.mPrefetchMaxCountObserved = 0;
            oVar.mPrefetchMaxObservedInInitialPrefetch = false;
            vVar.l();
        }
        this.mLayout.onLayoutCompleted(a0Var);
        z4 = z3;
        onExitLayoutOrScroll(z4);
        stopInterceptRequestLayout(false);
        c0Var.a.clear();
        c0Var.b.c();
        iArr = this.mMinMaxLayoutPositions;
        i4 = iArr[0];
        int i113 = iArr[z4 ? 1 : 0];
        findMinMaxChildLayoutPositions(iArr);
        if (iArr[0] == i4) {
            z5 = z4 ? 1 : 0;
        } else {
            z5 = z4 ? 1 : 0;
        }
        if (z5) {
            dispatchOnScrolled(0, 0);
        }
        if (this.mPreserveFocusAfterLayout) {
            if (!isFocused()) {
                j2 = a0Var.m;
                if (j2 == -1) {
                    d0Var3 = d0Var2;
                } else {
                    d0Var3 = d0Var2;
                }
                if (d0Var3 != null) {
                    view3 = d0Var3.itemView;
                    if (!this.mChildHelper.c.contains(view3)) {
                        if (this.mChildHelper.e() <= 0) {
                            r9 = d0Var2;
                            break;
                        }
                        i5 = a0Var.l;
                        if (i5 == i3) {
                            i5 = 0;
                        }
                        iB = a0Var.b();
                        i6 = i5;
                        while (true) {
                            if (i6 < iB) {
                                d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i6);
                                if (d0VarFindViewHolderForAdapterPosition2 != null) {
                                    view2 = d0VarFindViewHolderForAdapterPosition2.itemView;
                                    if (view2.hasFocusable()) {
                                        r9 = view2;
                                    } else {
                                        i6++;
                                    }
                                }
                            }
                            iMin = Math.min(iB, i5) - 1;
                            while (true) {
                                if (iMin >= 0) {
                                    d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                    if (d0VarFindViewHolderForAdapterPosition != null) {
                                        view = d0VarFindViewHolderForAdapterPosition.itemView;
                                        if (view.hasFocusable()) {
                                            r9 = view;
                                            break;
                                        }
                                        iMin--;
                                    }
                                }
                                r9 = d0Var2;
                                break;
                            }
                        }
                    } else {
                        if (this.mChildHelper.e() <= 0) {
                            r9 = d0Var2;
                            break;
                        }
                        i5 = a0Var.l;
                        if (i5 == i3) {
                            i5 = 0;
                        }
                        iB = a0Var.b();
                        i6 = i5;
                        while (true) {
                            if (i6 < iB) {
                                d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i6);
                                if (d0VarFindViewHolderForAdapterPosition2 != null) {
                                    view2 = d0VarFindViewHolderForAdapterPosition2.itemView;
                                    if (view2.hasFocusable()) {
                                        r9 = view2;
                                    } else {
                                        i6++;
                                    }
                                }
                            }
                            iMin = Math.min(iB, i5) - 1;
                            while (true) {
                                if (iMin >= 0) {
                                    d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                    if (d0VarFindViewHolderForAdapterPosition != null) {
                                        view = d0VarFindViewHolderForAdapterPosition.itemView;
                                        if (view.hasFocusable()) {
                                            r9 = view;
                                            break;
                                        }
                                        iMin--;
                                    }
                                }
                                r9 = d0Var2;
                                break;
                            }
                        }
                    }
                } else {
                    if (this.mChildHelper.e() <= 0) {
                        r9 = d0Var2;
                        break;
                    }
                    i5 = a0Var.l;
                    if (i5 == i3) {
                        i5 = 0;
                    }
                    iB = a0Var.b();
                    i6 = i5;
                    while (true) {
                        if (i6 < iB) {
                            d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i6);
                            if (d0VarFindViewHolderForAdapterPosition2 != null) {
                                view2 = d0VarFindViewHolderForAdapterPosition2.itemView;
                                if (view2.hasFocusable()) {
                                    r9 = view2;
                                } else {
                                    i6++;
                                }
                            }
                        }
                        iMin = Math.min(iB, i5) - 1;
                        while (true) {
                            if (iMin >= 0) {
                                d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                if (d0VarFindViewHolderForAdapterPosition != null) {
                                    view = d0VarFindViewHolderForAdapterPosition.itemView;
                                    if (view.hasFocusable()) {
                                        r9 = view;
                                        break;
                                    }
                                    iMin--;
                                }
                            }
                            r9 = d0Var2;
                            break;
                        }
                    }
                }
                if (r9 != 0) {
                    i7 = a0Var.n;
                    if (i7 != -1) {
                        r10 = r9;
                        r10 = r9;
                        r10 = r9;
                        r10 = viewFindViewById;
                    }
                    r10 = r9;
                    r10 = r9;
                    r10 = r9;
                    r10 = r9;
                    r10 = r9;
                    r10 = r9;
                    r10.requestFocus();
                }
            } else if (this.mChildHelper.c.contains(getFocusedChild())) {
                j2 = a0Var.m;
                if (j2 == -1) {
                    d0Var3 = d0Var2;
                } else {
                    d0Var3 = d0Var2;
                }
                if (d0Var3 != null) {
                    view3 = d0Var3.itemView;
                    if (!this.mChildHelper.c.contains(view3)) {
                        if (this.mChildHelper.e() <= 0) {
                            r9 = d0Var2;
                            break;
                        }
                        i5 = a0Var.l;
                        if (i5 == i3) {
                            i5 = 0;
                        }
                        iB = a0Var.b();
                        i6 = i5;
                        while (true) {
                            if (i6 < iB) {
                                d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i6);
                                if (d0VarFindViewHolderForAdapterPosition2 != null) {
                                    view2 = d0VarFindViewHolderForAdapterPosition2.itemView;
                                    if (view2.hasFocusable()) {
                                        r9 = view2;
                                    } else {
                                        i6++;
                                    }
                                }
                            }
                            iMin = Math.min(iB, i5) - 1;
                            while (true) {
                                if (iMin >= 0) {
                                    d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                    if (d0VarFindViewHolderForAdapterPosition != null) {
                                        view = d0VarFindViewHolderForAdapterPosition.itemView;
                                        if (view.hasFocusable()) {
                                            r9 = view;
                                            break;
                                        }
                                        iMin--;
                                    }
                                }
                                r9 = d0Var2;
                                break;
                            }
                        }
                    } else {
                        if (this.mChildHelper.e() <= 0) {
                            r9 = d0Var2;
                            break;
                        }
                        i5 = a0Var.l;
                        if (i5 == i3) {
                            i5 = 0;
                        }
                        iB = a0Var.b();
                        i6 = i5;
                        while (true) {
                            if (i6 < iB) {
                                d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i6);
                                if (d0VarFindViewHolderForAdapterPosition2 != null) {
                                    view2 = d0VarFindViewHolderForAdapterPosition2.itemView;
                                    if (view2.hasFocusable()) {
                                        r9 = view2;
                                    } else {
                                        i6++;
                                    }
                                }
                            }
                            iMin = Math.min(iB, i5) - 1;
                            while (true) {
                                if (iMin >= 0) {
                                    d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                    if (d0VarFindViewHolderForAdapterPosition != null) {
                                        view = d0VarFindViewHolderForAdapterPosition.itemView;
                                        if (view.hasFocusable()) {
                                            r9 = view;
                                            break;
                                        }
                                        iMin--;
                                    }
                                }
                                r9 = d0Var2;
                                break;
                            }
                        }
                    }
                } else {
                    if (this.mChildHelper.e() <= 0) {
                        r9 = d0Var2;
                        break;
                    }
                    i5 = a0Var.l;
                    if (i5 == i3) {
                        i5 = 0;
                    }
                    iB = a0Var.b();
                    i6 = i5;
                    while (true) {
                        if (i6 < iB) {
                            d0VarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i6);
                            if (d0VarFindViewHolderForAdapterPosition2 != null) {
                                view2 = d0VarFindViewHolderForAdapterPosition2.itemView;
                                if (view2.hasFocusable()) {
                                    r9 = view2;
                                } else {
                                    i6++;
                                }
                            }
                        }
                        iMin = Math.min(iB, i5) - 1;
                        while (true) {
                            if (iMin >= 0) {
                                d0VarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin);
                                if (d0VarFindViewHolderForAdapterPosition != null) {
                                    view = d0VarFindViewHolderForAdapterPosition.itemView;
                                    if (view.hasFocusable()) {
                                        r9 = view;
                                        break;
                                    }
                                    iMin--;
                                }
                            }
                            r9 = d0Var2;
                            break;
                        }
                    }
                }
                if (r9 != 0) {
                    i7 = a0Var.n;
                    if (i7 != -1) {
                        r10 = r9;
                        r10 = r9;
                        r10 = r9;
                        r10 = viewFindViewById;
                    }
                    r10 = r9;
                    r10 = r9;
                    r10 = r9;
                    r10 = r9;
                    r10 = r9;
                    r10 = r9;
                    r10.requestFocus();
                }
            }
        }
        a0Var.m = -1L;
        a0Var.l = -1;
        a0Var.n = -1;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x006d  */
    public final void dispatchLayoutStep1() {
        int adapterPositionInRecyclerView;
        int id;
        androidx.recyclerview.widget.c0.a aVar;
        View viewFindContainingItemView;
        a0 a0Var = this.mState;
        a0Var.a(1);
        fillRemainingScrollValues(a0Var);
        a0Var.i = false;
        startInterceptRequestLayout();
        androidx.recyclerview.widget.c0 c0Var = this.mViewInfoStore;
        o01 o01Var = c0Var.a;
        o01Var.clear();
        qf0 qf0Var = c0Var.b;
        qf0Var.c();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        d0 childViewHolder = (focusedChild == null || (viewFindContainingItemView = findContainingItemView(focusedChild)) == null) ? null : getChildViewHolder(viewFindContainingItemView);
        if (childViewHolder == null) {
            a0Var.m = -1L;
            a0Var.l = -1;
            a0Var.n = -1;
        } else {
            a0Var.m = this.mAdapter.mHasStableIds ? childViewHolder.mItemId : -1L;
            if (this.mDataSetHasChangedAfterLayout) {
                adapterPositionInRecyclerView = -1;
            } else if (childViewHolder.isRemoved()) {
                adapterPositionInRecyclerView = childViewHolder.mOldPosition;
            } else {
                RecyclerView recyclerView = childViewHolder.mOwnerRecyclerView;
                if (recyclerView == null) {
                    adapterPositionInRecyclerView = -1;
                } else {
                    adapterPositionInRecyclerView = recyclerView.getAdapterPositionInRecyclerView(childViewHolder);
                }
            }
            a0Var.l = adapterPositionInRecyclerView;
            View focusedChild2 = childViewHolder.itemView;
            loop7: while (true) {
                id = focusedChild2.getId();
                while (true) {
                    if (focusedChild2.isFocused() || !(focusedChild2 instanceof ViewGroup) || !focusedChild2.hasFocus()) {
                        break loop7;
                    }
                    focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                    if (focusedChild2.getId() != -1) {
                    }
                }
            }
            a0Var.n = id;
        }
        a0Var.h = a0Var.j && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        a0Var.g = a0Var.k;
        a0Var.e = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        boolean z2 = a0Var.j;
        androidx.recyclerview.widget.k kVar = this.mItemAnimator;
        if (z2) {
            int iE = this.mChildHelper.e();
            for (int i2 = 0; i2 < iE; i2++) {
                d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.mHasStableIds)) {
                    l.b(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    kVar.getClass();
                    l.c cVar = new l.c();
                    cVar.a(childViewHolderInt);
                    androidx.recyclerview.widget.c0.a aVarA = (androidx.recyclerview.widget.c0.a) o01Var.getOrDefault(childViewHolderInt, null);
                    if (aVarA == null) {
                        aVarA = androidx.recyclerview.widget.c0.a.a();
                        o01Var.put(childViewHolderInt, aVarA);
                    }
                    aVarA.b = cVar;
                    aVarA.a |= 4;
                    if (a0Var.h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        qf0Var.g(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        boolean z3 = a0Var.k;
        v vVar = this.mRecycler;
        if (z3) {
            int iH = this.mChildHelper.h();
            for (int i3 = 0; i3 < iH; i3++) {
                d0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.g(i3));
                if (!childViewHolderInt2.shouldIgnore() && childViewHolderInt2.mOldPosition == -1) {
                    childViewHolderInt2.mOldPosition = childViewHolderInt2.mPosition;
                }
            }
            boolean z4 = a0Var.f;
            a0Var.f = false;
            this.mLayout.onLayoutChildren(vVar, a0Var);
            a0Var.f = z4;
            for (int i4 = 0; i4 < this.mChildHelper.e(); i4++) {
                d0 childViewHolderInt3 = getChildViewHolderInt(this.mChildHelper.d(i4));
                if (!childViewHolderInt3.shouldIgnore() && ((aVar = (androidx.recyclerview.widget.c0.a) o01Var.getOrDefault(childViewHolderInt3, null)) == null || (aVar.a & 4) == 0)) {
                    l.b(childViewHolderInt3);
                    boolean z5 = (childViewHolderInt3.mFlags & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0;
                    childViewHolderInt3.getUnmodifiedPayloads();
                    kVar.getClass();
                    l.c cVar2 = new l.c();
                    cVar2.a(childViewHolderInt3);
                    if (z5) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt3, cVar2);
                    } else {
                        androidx.recyclerview.widget.c0.a aVarA2 = (androidx.recyclerview.widget.c0.a) o01Var.getOrDefault(childViewHolderInt3, null);
                        if (aVarA2 == null) {
                            aVarA2 = androidx.recyclerview.widget.c0.a.a();
                            o01Var.put(childViewHolderInt3, aVarA2);
                        }
                        aVarA2.a |= 2;
                        aVarA2.b = cVar2;
                    }
                }
            }
        }
        int iH2 = this.mChildHelper.h();
        for (int i5 = 0; i5 < iH2; i5++) {
            d0 childViewHolderInt4 = getChildViewHolderInt(this.mChildHelper.g(i5));
            if (!childViewHolderInt4.shouldIgnore()) {
                childViewHolderInt4.mOldPosition = -1;
                childViewHolderInt4.mPreLayoutPosition = -1;
            }
        }
        ArrayList arrayList = vVar.c;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            d0 d0Var = (d0) arrayList.get(i6);
            d0Var.mOldPosition = -1;
            d0Var.mPreLayoutPosition = -1;
        }
        ArrayList arrayList2 = vVar.a;
        int size2 = arrayList2.size();
        for (int i7 = 0; i7 < size2; i7++) {
            d0 d0Var2 = (d0) arrayList2.get(i7);
            d0Var2.mOldPosition = -1;
            d0Var2.mPreLayoutPosition = -1;
        }
        ArrayList arrayList3 = vVar.b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i8 = 0; i8 < size3; i8++) {
                d0 d0Var3 = (d0) vVar.b.get(i8);
                d0Var3.mOldPosition = -1;
                d0Var3.mPreLayoutPosition = -1;
            }
        }
        onExitLayoutOrScroll(true);
        stopInterceptRequestLayout(false);
        a0Var.d = 2;
    }

    public final void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        a0 a0Var = this.mState;
        a0Var.a(6);
        this.mAdapterHelper.c();
        a0Var.e = this.mAdapter.getItemCount();
        a0Var.c = 0;
        if (this.mPendingSavedState != null) {
            g gVar = this.mAdapter;
            int iOrdinal = gVar.mStateRestorationPolicy.ordinal();
            if (iOrdinal == 1 ? gVar.getItemCount() > 0 : iOrdinal != 2) {
                Parcelable parcelable = this.mPendingSavedState.b;
                if (parcelable != null) {
                    this.mLayout.onRestoreInstanceState(parcelable);
                }
                this.mPendingSavedState = null;
            }
        }
        a0Var.g = false;
        this.mLayout.onLayoutChildren(this.mRecycler, a0Var);
        a0Var.f = false;
        a0Var.j = a0Var.j && this.mItemAnimator != null;
        a0Var.d = 4;
        onExitLayoutOrScroll(true);
        stopInterceptRequestLayout(false);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().e(i2, i3, i4, i5, iArr, 0, null);
    }

    public final void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        ArrayList arrayList = this.mScrollListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else {
                    ((t) this.mScrollListeners.get(size)).onScrolled(this, i2, i3);
                }
            }
        }
        this.mDispatchScrollCounter--;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z2;
        androidx.recyclerview.widget.k kVar;
        float paddingRight;
        float paddingBottom;
        super.draw(canvas);
        ArrayList arrayList = this.mItemDecorations;
        int size = arrayList.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ((n) arrayList.get(i2)).onDrawOver(canvas, this);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom2 = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom2, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                paddingRight = getPaddingRight() + (-getWidth());
                paddingBottom = getPaddingBottom() + (-getHeight());
            } else {
                paddingRight = -getWidth();
                paddingBottom = -getHeight();
            }
            canvas.translate(paddingRight, paddingBottom);
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || (kVar = this.mItemAnimator) == null || arrayList.size() <= 0 || !kVar.f()) ? z2 : true) {
            WeakHashMap weakHashMap = qd1.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public final void ensureBottomGlow() {
        int measuredWidth;
        int measuredHeight;
        if (this.mBottomGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mBottomGlow = edgeEffect;
        if (this.mClipToPadding) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffect.setSize(measuredWidth, measuredHeight);
    }

    public final void ensureLeftGlow() {
        int measuredHeight;
        int measuredWidth;
        if (this.mLeftGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mLeftGlow = edgeEffect;
        if (this.mClipToPadding) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffect.setSize(measuredHeight, measuredWidth);
    }

    public final void ensureRightGlow() {
        int measuredHeight;
        int measuredWidth;
        if (this.mRightGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mRightGlow = edgeEffect;
        if (this.mClipToPadding) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffect.setSize(measuredHeight, measuredWidth);
    }

    public final void ensureTopGlow() {
        int measuredWidth;
        int measuredHeight;
        if (this.mTopGlow != null) {
            return;
        }
        this.mEdgeEffectFactory.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.mTopGlow = edgeEffect;
        if (this.mClipToPadding) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffect.setSize(measuredWidth, measuredHeight);
    }

    public final String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(a0 a0Var) {
        if (this.mScrollState != 2) {
            a0Var.getClass();
            return;
        }
        OverScroller overScroller = this.mViewFlinger.d;
        overScroller.getFinalX();
        overScroller.getCurrX();
        a0Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public final View findContainingItemView(View view) {
        Object parent;
        while (true) {
            parent = view.getParent();
            if (parent == null || parent == this || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList arrayList = this.mOnItemTouchListeners;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = (s) arrayList.get(i2);
            if (sVar.c(motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = sVar;
                return true;
            }
        }
        return false;
    }

    public final void findMinMaxChildLayoutPositions(int[] iArr) {
        int iE = this.mChildHelper.e();
        if (iE == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        for (int i4 = 0; i4 < iE; i4++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public final d0 findViewHolderForAdapterPosition(int i2) {
        d0 d0Var = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iH = this.mChildHelper.h();
        for (int i3 = 0; i3 < iH; i3++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i2) {
                if (!this.mChildHelper.c.contains(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                d0Var = childViewHolderInt;
            }
        }
        return d0Var;
    }

    public final d0 findViewHolderForPosition(int i2) {
        int iH = this.mChildHelper.h();
        d0 d0Var = null;
        for (int i3 = 0; i3 < iH; i3++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.mPosition == i2) {
                if (!this.mChildHelper.c.contains(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                d0Var = childViewHolderInt;
            }
        }
        return d0Var;
    }

    /* JADX WARN: Code duplicated, block: B:136:0x019e  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:139:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i2) {
        View viewOnFocusSearchFailed;
        int i3;
        byte b2;
        boolean z2;
        this.mLayout.getClass();
        boolean z3 = true;
        boolean z4 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        a0 a0Var = this.mState;
        v vVar = this.mRecycler;
        if (z4 && (i2 == 2 || i2 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                if (focusFinder.findNextFocus(this, view, i2 == 2 ? 130 : 33) == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.mLayout.canScrollHorizontally()) {
                RecyclerView recyclerView = this.mLayout.mRecyclerView;
                WeakHashMap weakHashMap = qd1.a;
                z2 = focusFinder.findNextFocus(this, view, (recyclerView.getLayoutDirection() == 1) ^ (i2 == 2) ? 66 : 17) == null;
            }
            if (z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) != null) {
                    startInterceptRequestLayout();
                    this.mLayout.onFocusSearchFailed(view, i2, vVar, a0Var);
                    stopInterceptRequestLayout(false);
                }
                return null;
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, i2);
            if (viewOnFocusSearchFailed == null) {
            }
            if (viewOnFocusSearchFailed != null) {
                z3 = false;
            } else {
                z3 = false;
            }
            if (z3) {
                return viewOnFocusSearchFailed;
            }
            return super.focusSearch(view, i2);
        }
        View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
        if (viewFindNextFocus == null && z4) {
            consumePendingUpdateOperations();
            if (findContainingItemView(view) != null) {
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, i2, vVar, a0Var);
                stopInterceptRequestLayout(false);
            }
            return null;
        }
        viewOnFocusSearchFailed = viewFindNextFocus;
        if (viewOnFocusSearchFailed == null && !viewOnFocusSearchFailed.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i2);
            }
            requestChildOnScreen(viewOnFocusSearchFailed, null);
            return view;
        }
        if (viewOnFocusSearchFailed != null || viewOnFocusSearchFailed == this || viewOnFocusSearchFailed == view || findContainingItemView(viewOnFocusSearchFailed) == null) {
            z3 = false;
        } else if (view != null && findContainingItemView(view) != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            Rect rect = this.mTempRect;
            rect.set(0, 0, width, height);
            int width2 = viewOnFocusSearchFailed.getWidth();
            int height2 = viewOnFocusSearchFailed.getHeight();
            Rect rect2 = this.mTempRect2;
            rect2.set(0, 0, width2, height2);
            offsetDescendantRectToMyCoords(view, rect);
            offsetDescendantRectToMyCoords(viewOnFocusSearchFailed, rect2);
            RecyclerView recyclerView2 = this.mLayout.mRecyclerView;
            WeakHashMap weakHashMap2 = qd1.a;
            int i4 = recyclerView2.getLayoutDirection() == 1 ? -1 : 1;
            int i5 = rect.left;
            int i6 = rect2.left;
            if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
                i3 = 1;
            } else {
                int i7 = rect.right;
                int i8 = rect2.right;
                i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
            }
            int i9 = rect.top;
            int i10 = rect2.top;
            if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
                b2 = 1;
            } else {
                int i11 = rect.bottom;
                int i12 = rect2.bottom;
                b2 = ((i11 > i12 || i9 >= i12) && i9 > i10) ? (byte) -1 : (byte) 0;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 17) {
                        if (i2 != 33) {
                            if (i2 != 66) {
                                if (i2 != 130) {
                                    throw new IllegalArgumentException("Invalid direction: " + i2 + exceptionLabel());
                                }
                                if (b2 <= 0) {
                                    z3 = false;
                                }
                            } else if (i3 <= 0) {
                                z3 = false;
                            }
                        } else if (b2 >= 0) {
                            z3 = false;
                        }
                    } else if (i3 >= 0) {
                        z3 = false;
                    }
                } else if (b2 <= 0 && (b2 != 0 || i3 * i4 <= 0)) {
                    z3 = false;
                }
            } else if (b2 >= 0 && (b2 != 0 || i3 * i4 >= 0)) {
                z3 = false;
            }
        }
        if (z3) {
            return viewOnFocusSearchFailed;
        }
        return super.focusSearch(view, i2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager".concat(exceptionLabel()));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager".concat(exceptionLabel()));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager".concat(exceptionLabel()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public final int getAdapterPositionInRecyclerView(d0 d0Var) {
        if ((d0Var.mFlags & 524) != 0 || !d0Var.isBound()) {
            return -1;
        }
        int i2 = d0Var.mPosition;
        ArrayList arrayList = this.mAdapterHelper.b;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            androidx.recyclerview.widget.a.b bVar = (androidx.recyclerview.widget.a.b) arrayList.get(i3);
            int i4 = bVar.a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.b;
                    if (i5 <= i2) {
                        int i6 = bVar.d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.b;
                    if (i7 == i2) {
                        i2 = bVar.d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.b <= i2) {
                i2 += bVar.d;
            }
        }
        return i2;
    }

    @Override // android.view.View
    public final int getBaseline() {
        if (this.mLayout != null) {
            return -1;
        }
        return super.getBaseline();
    }

    public final long getChangedHolderKey(d0 d0Var) {
        return this.mAdapter.mHasStableIds ? d0Var.mItemId : d0Var.mPosition;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i2, int i3) {
        return super.getChildDrawingOrder(i2, i3);
    }

    public final d0 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        defpackage.d.AnonymousClass0.m$1("View ", view, " is not a direct child of ", this);
        return null;
    }

    @Override // android.view.ViewGroup
    public final boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public final Rect getItemDecorInsetsForChild(View view) {
        p pVar = (p) view.getLayoutParams();
        boolean z2 = pVar.c;
        Rect rect = pVar.b;
        if (!z2 || (this.mState.g && (pVar.a.isUpdated() || pVar.a.isInvalid()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.mItemDecorations;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Rect rect2 = this.mTempRect;
            rect2.set(0, 0, 0, 0);
            ((n) arrayList.get(i2)).getItemOffsets(rect2, view, this);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.c = false;
        return rect;
    }

    public final ek0 getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new ek0(this);
        }
        return this.mScrollingChildHelper;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0) != null;
    }

    public final boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.g();
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public final boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d;
    }

    public final void jumpToPositionForSmoothScroller(int i2) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i2);
        awakenScrollBars();
    }

    public final void markItemDecorInsetsDirty() {
        int iH = this.mChildHelper.h();
        for (int i2 = 0; i2 < iH; i2++) {
            ((p) this.mChildHelper.g(i2).getLayoutParams()).c = true;
        }
        ArrayList arrayList = this.mRecycler.c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = (p) ((d0) arrayList.get(i3)).itemView.getLayoutParams();
            if (pVar != null) {
                pVar.c = true;
            }
        }
    }

    public final void offsetPositionRecordsForInsert(int i2, int i3) {
        int iH = this.mChildHelper.h();
        for (int i4 = 0; i4 < iH; i4++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.f = true;
            }
        }
        ArrayList arrayList = this.mRecycler.c;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            d0 d0Var = (d0) arrayList.get(i5);
            if (d0Var != null && d0Var.mPosition >= i2) {
                d0Var.offsetPosition(i3, false);
            }
        }
        requestLayout();
    }

    public final void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int iH = this.mChildHelper.h();
        int i11 = -1;
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i12 = 0; i12 < iH; i12++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i12));
            if (childViewHolderInt != null && (i10 = childViewHolderInt.mPosition) >= i5 && i10 <= i4) {
                if (i10 == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i6, false);
                }
                this.mState.f = true;
            }
        }
        v vVar = this.mRecycler;
        vVar.getClass();
        if (i2 < i3) {
            i8 = i2;
            i7 = i3;
        } else {
            i7 = i2;
            i11 = 1;
            i8 = i3;
        }
        ArrayList arrayList = vVar.c;
        int size = arrayList.size();
        for (int i13 = 0; i13 < size; i13++) {
            d0 d0Var = (d0) arrayList.get(i13);
            if (d0Var != null && (i9 = d0Var.mPosition) >= i8 && i9 <= i7) {
                if (i9 == i2) {
                    d0Var.offsetPosition(i3 - i2, false);
                } else {
                    d0Var.offsetPosition(i11, false);
                }
            }
        }
        requestLayout();
    }

    public final void offsetPositionRecordsForRemove(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int iH = this.mChildHelper.h();
        for (int i5 = 0; i5 < iH; i5++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i6 = childViewHolderInt.mPosition;
                if (i6 >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z2);
                } else if (i6 >= i2) {
                    childViewHolderInt.addFlags(8);
                    childViewHolderInt.offsetPosition(-i3, z2);
                    childViewHolderInt.mPosition = i2 - 1;
                }
                this.mState.f = true;
            }
        }
        v vVar = this.mRecycler;
        ArrayList arrayList = vVar.c;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                requestLayout();
                return;
            }
            d0 d0Var = (d0) arrayList.get(size);
            if (d0Var != null) {
                int i7 = d0Var.mPosition;
                if (i7 >= i4) {
                    d0Var.offsetPosition(-i3, z2);
                } else if (i7 >= i2) {
                    d0Var.addFlags(8);
                    vVar.f(size);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004c  */
    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = this.mFirstLayoutComplete && !isLayoutRequested();
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.mIsAttachedToWindow = true;
        }
        this.mPostedAnimatorRunner = false;
        ThreadLocal threadLocal = androidx.recyclerview.widget.m.g;
        androidx.recyclerview.widget.m mVar = (androidx.recyclerview.widget.m) threadLocal.get();
        this.mGapWorker = mVar;
        if (mVar == null) {
            this.mGapWorker = new androidx.recyclerview.widget.m();
            WeakHashMap weakHashMap = qd1.a;
            Display display = getDisplay();
            if (isInEditMode() || display == null) {
                refreshRate = 60.0f;
            } else {
                refreshRate = display.getRefreshRate();
                if (refreshRate < 30.0f) {
                    refreshRate = 60.0f;
                }
            }
            androidx.recyclerview.widget.m mVar2 = this.mGapWorker;
            mVar2.d = (long) (1.0E9f / refreshRate);
            threadLocal.set(mVar2);
        }
        this.mGapWorker.b.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.recyclerview.widget.k kVar = this.mItemAnimator;
        if (kVar != null) {
            kVar.e();
        }
        stopScroll();
        this.mIsAttached = false;
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.mIsAttachedToWindow = false;
            oVar.onDetachedFromWindow(this);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.getClass();
        while (androidx.recyclerview.widget.c0.a.d.b() != null) {
        }
        androidx.recyclerview.widget.m mVar = this.mGapWorker;
        if (mVar != null) {
            mVar.b.remove(this);
            this.mGapWorker = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.mItemDecorations;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((n) arrayList.get(i2)).onDraw(canvas, this);
        }
    }

    public final void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public final void onExitLayoutOrScroll(boolean z2) {
        int i2;
        AccessibilityManager accessibilityManager;
        int i3 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i3;
        if (i3 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z2) {
                int i4 = this.mEatenAccessibilityChangeFlags;
                this.mEatenAccessibilityChangeFlags = 0;
                if (i4 != 0 && (accessibilityManager = this.mAccessibilityManager) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    accessibilityEventObtain.setContentChangeTypes(i4);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.mPendingAccessibilityImportanceChange;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    d0 d0Var = (d0) arrayList.get(size);
                    if (d0Var.itemView.getParent() == this && !d0Var.shouldIgnore() && (i2 = d0Var.mPendingAccessibilityState) != -1) {
                        View view = d0Var.itemView;
                        WeakHashMap weakHashMap = qd1.a;
                        view.setImportantForAccessibility(i2);
                        d0Var.mPendingAccessibilityState = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float axisValue;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.mLayout.canScrollHorizontally() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                axisValue = motionEvent.getAxisValue(26);
                if (this.mLayout.canScrollVertically()) {
                    f2 = -axisValue;
                } else if (this.mLayout.canScrollHorizontally()) {
                    f2 = 0.0f;
                } else {
                    f2 = 0.0f;
                    axisValue = 0.0f;
                }
            } else {
                f2 = 0.0f;
                axisValue = 0.0f;
            }
            if (f2 != 0.0f || axisValue != 0.0f) {
                int i2 = (int) (axisValue * this.mScaledHorizontalScrollFactor);
                int i3 = (int) (f2 * this.mScaledVerticalScrollFactor);
                o oVar = this.mLayout;
                if (oVar != null && !this.mLayoutSuppressed) {
                    int[] iArr = this.mReusableIntPair;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    boolean zCanScrollHorizontally = oVar.canScrollHorizontally();
                    boolean zCanScrollVertically = this.mLayout.canScrollVertically();
                    getScrollingChildHelper().g(zCanScrollVertically ? (zCanScrollHorizontally ? 1 : 0) | 2 : zCanScrollHorizontally ? 1 : 0, 1);
                    if (getScrollingChildHelper().c(zCanScrollHorizontally ? i2 : 0, zCanScrollVertically ? i3 : 0, this.mReusableIntPair, this.mScrollOffset, 1)) {
                        i2 -= iArr[0];
                        i3 -= iArr[1];
                    }
                    scrollByInternal(zCanScrollHorizontally ? i2 : 0, zCanScrollVertically ? i3 : 0, motionEvent, 1);
                    androidx.recyclerview.widget.m mVar = this.mGapWorker;
                    if (mVar != null && (i2 != 0 || i3 != 0)) {
                        mVar.a(this, i2, i3);
                    }
                    getScrollingChildHelper().h(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (!this.mLayoutSuppressed) {
            this.mInterceptingOnItemTouchListener = null;
            if (findInterceptingOnItemTouchListener(motionEvent)) {
                resetScroll();
                setScrollState(0);
                return true;
            }
            o oVar = this.mLayout;
            if (oVar != null) {
                boolean zCanScrollHorizontally = oVar.canScrollHorizontally();
                boolean zCanScrollVertically = this.mLayout.canScrollVertically();
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.mIgnoreMotionEventTillDown) {
                        this.mIgnoreMotionEventTillDown = false;
                    }
                    this.mScrollPointerId = motionEvent.getPointerId(0);
                    int x2 = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = x2;
                    this.mInitialTouchX = x2;
                    int y2 = (int) (motionEvent.getY() + 0.5f);
                    this.mLastTouchY = y2;
                    this.mInitialTouchY = y2;
                    if (this.mScrollState == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        getScrollingChildHelper().h(1);
                    }
                    int[] iArr = this.mNestedOffsets;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i2 = zCanScrollHorizontally;
                    if (zCanScrollVertically) {
                        i2 = (zCanScrollHorizontally ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().g(i2, 0);
                } else if (actionMasked == 1) {
                    this.mVelocityTracker.clear();
                    getScrollingChildHelper().h(0);
                } else if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (iFindPointerIndex >= 0) {
                        int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                        int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                        if (this.mScrollState != 1) {
                            int i3 = x3 - this.mInitialTouchX;
                            int i4 = y3 - this.mInitialTouchY;
                            int i5 = this.mTouchSlop;
                            if (!zCanScrollHorizontally || Math.abs(i3) <= i5) {
                                z2 = false;
                            } else {
                                this.mLastTouchX = x3;
                                z2 = true;
                            }
                            if (zCanScrollVertically && Math.abs(i4) > i5) {
                                this.mLastTouchY = y3;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                    }
                } else if (actionMasked == 3) {
                    resetScroll();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                    int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.mLastTouchX = x4;
                    this.mInitialTouchX = x4;
                    int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.mLastTouchY = y4;
                    this.mInitialTouchY = y4;
                } else if (actionMasked == 6) {
                    onPointerUp(motionEvent);
                }
                if (this.mScrollState == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = t71.$r8$clinit;
        Trace.beginSection("RV OnLayout");
        dispatchLayout();
        Trace.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean zIsAutoMeasureEnabled = oVar.isAutoMeasureEnabled();
        a0 a0Var = this.mState;
        boolean z2 = false;
        if (zIsAutoMeasureEnabled) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.mRecyclerView.defaultOnMeasure(i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z2;
            if (z2 || this.mAdapter == null) {
                return;
            }
            if (a0Var.d == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i2, i3);
            a0Var.i = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                a0Var.i = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.mRecyclerView.defaultOnMeasure(i2, i3);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll(true);
            if (a0Var.k) {
                a0Var.g = true;
            } else {
                this.mAdapterHelper.c();
                a0Var.g = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (a0Var.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.mAdapter;
        if (gVar != null) {
            a0Var.e = gVar.getItemCount();
        } else {
            a0Var.e = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.mRecyclerView.defaultOnMeasure(i2, i3);
        stopInterceptRequestLayout(false);
        a0Var.g = false;
    }

    public final void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.mPendingSavedState = yVar;
        super.onRestoreInstanceState(yVar.mSuperState);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.mPendingSavedState;
        if (yVar2 != null) {
            yVar.b = yVar2.b;
            return yVar;
        }
        o oVar = this.mLayout;
        yVar.b = oVar != null ? oVar.onSaveInstanceState() : null;
        return yVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:134:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:167:0x0254  */
    /* JADX WARN: Code duplicated, block: B:229:0x030f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:230:0x0311  */
    /* JADX WARN: Code duplicated, block: B:231:0x0314  */
    /* JADX WARN: Code duplicated, block: B:234:0x0342  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e2 A[PHI: r8
      0x00e2: PHI (r8v18 int) = (r8v14 int), (r8v22 int) binds: [B:50:0x00cf, B:54:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [androidx.recyclerview.widget.RecyclerView$o] */
    /* JADX WARN: Type inference failed for: r1v4, types: [ek0] */
    /* JADX WARN: Type inference failed for: r1v9, types: [ek0] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [int] */
    /* JADX WARN: Type inference failed for: r9v3, types: [androidx.recyclerview.widget.a0, androidx.recyclerview.widget.w] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zFindInterceptingOnItemTouchListener;
        ?? r2;
        ?? r20;
        boolean z2;
        ?? r7;
        c0 c0Var;
        RecyclerView recyclerView;
        Interpolator interpolator;
        c cVar;
        RecyclerView recyclerView2;
        ?? r14;
        int i2;
        boolean z3;
        boolean z4;
        int i3;
        int position;
        int i4;
        androidx.recyclerview.widget.u uVarE;
        PointF pointFComputeScrollVectorForPosition;
        int i5;
        int i6;
        boolean z5;
        if (!this.mLayoutSuppressed && !this.mIgnoreMotionEventTillDown) {
            s sVar = this.mInterceptingOnItemTouchListener;
            if (sVar == null) {
                zFindInterceptingOnItemTouchListener = motionEvent.getAction() == 0 ? false : findInterceptingOnItemTouchListener(motionEvent);
            } else {
                sVar.a(motionEvent);
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.mInterceptingOnItemTouchListener = null;
                }
                zFindInterceptingOnItemTouchListener = true;
            }
            if (zFindInterceptingOnItemTouchListener) {
                resetScroll();
                setScrollState(0);
                return true;
            }
            o oVar = this.mLayout;
            if (oVar != null) {
                boolean zCanScrollHorizontally = oVar.canScrollHorizontally();
                boolean zCanScrollVertically = this.mLayout.canScrollVertically();
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                int[] iArr = this.mNestedOffsets;
                if (actionMasked == 0) {
                    iArr[1] = 0;
                    iArr[0] = 0;
                }
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.offsetLocation(iArr[0], iArr[1]);
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        this.mVelocityTracker.addMovement(motionEventObtain);
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        int i7 = this.mMaxFlingVelocity;
                        velocityTracker.computeCurrentVelocity(InternalZipConstants.AES_HASH_ITERATIONS, i7);
                        float f2 = zCanScrollHorizontally ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
                        float f3 = zCanScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
                        if (f2 == 0.0f && f3 == 0.0f) {
                            setScrollState(0);
                        } else {
                            int i8 = (int) f2;
                            int i9 = (int) f3;
                            o oVar2 = this.mLayout;
                            if (oVar2 == null || this.mLayoutSuppressed) {
                                setScrollState(0);
                            } else {
                                boolean zCanScrollHorizontally2 = oVar2.canScrollHorizontally();
                                boolean zCanScrollVertically2 = this.mLayout.canScrollVertically();
                                int i10 = this.mMinFlingVelocity;
                                if (!zCanScrollHorizontally2 || Math.abs(i8) < i10) {
                                    i8 = 0;
                                }
                                if (!zCanScrollVertically2 || Math.abs(i9) < i10) {
                                    i9 = 0;
                                }
                                if (i8 == 0 && i9 == 0) {
                                    setScrollState(0);
                                } else {
                                    float f4 = i8;
                                    float f5 = i9;
                                    if (dispatchNestedPreFling(f4, f5)) {
                                        setScrollState(0);
                                    } else {
                                        boolean z6 = zCanScrollHorizontally2 || zCanScrollVertically2;
                                        dispatchNestedFling(f4, f5, z6);
                                        ?? r9 = this.mOnFlingListener;
                                        if (r9 == 0 || (r14 = (recyclerView2 = r9.a).mLayout) == 0 || recyclerView2.mAdapter == null || ((Math.abs(i9) <= (i2 = recyclerView2.mMinFlingVelocity) && Math.abs(i8) <= i2) || !((z3 = r14 instanceof z.b)))) {
                                            r20 = zCanScrollHorizontally2;
                                            z2 = zCanScrollVertically2;
                                            if (z6) {
                                                if (z2) {
                                                    r7 = r20 | 2;
                                                } else {
                                                    r7 = r20;
                                                }
                                                getScrollingChildHelper().g(r7, 1);
                                                int i11 = -i7;
                                                int iMax = Math.max(i11, Math.min(i8, i7));
                                                int iMax2 = Math.max(i11, Math.min(i9, i7));
                                                c0Var = this.mViewFlinger;
                                                recyclerView = RecyclerView.this;
                                                recyclerView.setScrollState(2);
                                                c0Var.c = 0;
                                                c0Var.b = 0;
                                                interpolator = c0Var.f;
                                                cVar = sQuinticInterpolator;
                                                if (interpolator != cVar) {
                                                    c0Var.f = cVar;
                                                    c0Var.d = new OverScroller(recyclerView.getContext(), cVar);
                                                }
                                                c0Var.d.fling(0, 0, iMax, iMax2, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, Integer.MAX_VALUE, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, Integer.MAX_VALUE);
                                                c0Var.a();
                                            } else {
                                                setScrollState(0);
                                            }
                                        } else {
                                            androidx.recyclerview.widget.v vVar = !z3 ? null : new androidx.recyclerview.widget.v(r9, r9.a.getContext());
                                            if (vVar == null) {
                                                r20 = zCanScrollHorizontally2;
                                                z2 = zCanScrollVertically2;
                                            } else {
                                                RecyclerView recyclerView3 = r14.mRecyclerView;
                                                g gVar = recyclerView3 != null ? recyclerView3.mAdapter : null;
                                                int itemCount = gVar != null ? gVar.getItemCount() : 0;
                                                if (itemCount != 0) {
                                                    if (r14.canScrollVertically()) {
                                                        uVarE = r9.f(r14);
                                                    } else {
                                                        uVarE = r14.canScrollHorizontally() ? r9.e(r14) : null;
                                                    }
                                                    if (uVarE == null) {
                                                        z4 = zCanScrollHorizontally2;
                                                        z2 = zCanScrollVertically2;
                                                        i3 = -1;
                                                    } else {
                                                        int childCount = r14.getChildCount();
                                                        z4 = zCanScrollHorizontally2;
                                                        int i12 = Integer.MAX_VALUE;
                                                        int i13 = Integer.MIN_VALUE;
                                                        int i14 = 0;
                                                        i3 = -1;
                                                        View view = null;
                                                        View view2 = null;
                                                        while (true) {
                                                            z2 = zCanScrollVertically2;
                                                            if (i14 >= childCount) {
                                                                break;
                                                            }
                                                            View childAt = r14.getChildAt(i14);
                                                            int i15 = i14;
                                                            if (childAt != null) {
                                                                int iC = androidx.recyclerview.widget.w.c(childAt, uVarE);
                                                                if (iC <= 0 && iC > i13) {
                                                                    i13 = iC;
                                                                    view2 = childAt;
                                                                }
                                                                if (iC >= 0 && iC < i12) {
                                                                    i12 = iC;
                                                                    view = childAt;
                                                                }
                                                            }
                                                            i14 = i15 + 1;
                                                            zCanScrollVertically2 = z2;
                                                        }
                                                        boolean z7 = !r14.canScrollHorizontally() ? i9 <= 0 : i8 <= 0;
                                                        if (z7 && view != null) {
                                                            position = o.getPosition(view);
                                                        } else if (z7 || view2 == null) {
                                                            if (z7) {
                                                                view = view2;
                                                            }
                                                            if (view != null) {
                                                                int position2 = o.getPosition(view);
                                                                RecyclerView recyclerView4 = r14.mRecyclerView;
                                                                g gVar2 = recyclerView4 != null ? recyclerView4.mAdapter : null;
                                                                int i16 = ((z3 && (pointFComputeScrollVectorForPosition = ((z.b) r14).computeScrollVectorForPosition((gVar2 != null ? gVar2.getItemCount() : 0) + (-1))) != null && ((pointFComputeScrollVectorForPosition.x > r1 ? 1 : (pointFComputeScrollVectorForPosition.x == r1 ? 0 : -1)) < 0 || (pointFComputeScrollVectorForPosition.y > 0 ? 1 : (pointFComputeScrollVectorForPosition.y == 0 ? 0 : -1)) < 0)) == z7 ? -1 : 1) + position2;
                                                                if (i16 >= 0 && i16 < itemCount) {
                                                                    position = i16;
                                                                }
                                                            }
                                                        } else {
                                                            position = o.getPosition(view2);
                                                        }
                                                        i4 = -1;
                                                        r20 = z4;
                                                    }
                                                    position = i3;
                                                    i4 = position;
                                                    r20 = z4;
                                                } else {
                                                    z4 = zCanScrollHorizontally2;
                                                    z2 = zCanScrollVertically2;
                                                    i3 = -1;
                                                    position = i3;
                                                    i4 = position;
                                                    r20 = z4;
                                                }
                                                if (position != i4) {
                                                    vVar.mTargetPosition = position;
                                                    r14.startSmoothScroll(vVar);
                                                }
                                            }
                                            if (z6) {
                                                if (z2) {
                                                    r7 = r20 | 2;
                                                } else {
                                                    r7 = r20;
                                                }
                                                getScrollingChildHelper().g(r7, 1);
                                                int i17 = -i7;
                                                int iMax3 = Math.max(i17, Math.min(i8, i7));
                                                int iMax4 = Math.max(i17, Math.min(i9, i7));
                                                c0Var = this.mViewFlinger;
                                                recyclerView = RecyclerView.this;
                                                recyclerView.setScrollState(2);
                                                c0Var.c = 0;
                                                c0Var.b = 0;
                                                interpolator = c0Var.f;
                                                cVar = sQuinticInterpolator;
                                                if (interpolator != cVar) {
                                                    c0Var.f = cVar;
                                                    c0Var.d = new OverScroller(recyclerView.getContext(), cVar);
                                                }
                                                c0Var.d.fling(0, 0, iMax3, iMax4, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, Integer.MAX_VALUE, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, Integer.MAX_VALUE);
                                                c0Var.a();
                                            } else {
                                                setScrollState(0);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        resetScroll();
                    } else if (actionMasked == 2) {
                        int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                        if (iFindPointerIndex >= 0) {
                            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                            int iMax5 = this.mLastTouchX - x2;
                            int iMax6 = this.mLastTouchY - y2;
                            if (this.mScrollState != 1) {
                                int i18 = this.mTouchSlop;
                                if (zCanScrollHorizontally) {
                                    iMax5 = iMax5 > 0 ? Math.max(0, iMax5 - i18) : Math.min(0, iMax5 + i18);
                                    if (iMax5 != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                } else {
                                    z5 = false;
                                }
                                if (zCanScrollVertically) {
                                    iMax6 = iMax6 > 0 ? Math.max(0, iMax6 - i18) : Math.min(0, iMax6 + i18);
                                    if (iMax6 != 0) {
                                        z5 = true;
                                    }
                                }
                                if (z5) {
                                    setScrollState(1);
                                }
                            }
                            if (this.mScrollState == 1) {
                                int[] iArr2 = this.mReusableIntPair;
                                iArr2[0] = 0;
                                iArr2[1] = 0;
                                boolean zC = getScrollingChildHelper().c(zCanScrollHorizontally ? iMax5 : 0, zCanScrollVertically ? iMax6 : 0, iArr2, this.mScrollOffset, 0);
                                int[] iArr3 = this.mScrollOffset;
                                if (zC) {
                                    iMax5 -= iArr2[0];
                                    iMax6 -= iArr2[1];
                                    iArr[0] = iArr[0] + iArr3[0];
                                    iArr[1] = iArr[1] + iArr3[1];
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                }
                                this.mLastTouchX = x2 - iArr3[0];
                                this.mLastTouchY = y2 - iArr3[1];
                                int i19 = zCanScrollHorizontally ? iMax5 : 0;
                                if (zCanScrollVertically) {
                                    i5 = iMax6;
                                    i6 = 0;
                                } else {
                                    i5 = 0;
                                    i6 = 0;
                                }
                                if (scrollByInternal(i19, i5, motionEvent, i6)) {
                                    getParent().requestDisallowInterceptTouchEvent(true);
                                }
                                androidx.recyclerview.widget.m mVar = this.mGapWorker;
                                if (mVar != null && (iMax5 != 0 || iMax6 != 0)) {
                                    mVar.a(this, iMax5, iMax6);
                                }
                            }
                        }
                    } else if (actionMasked == 3) {
                        resetScroll();
                        setScrollState(0);
                    } else if (actionMasked == 5) {
                        this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                        int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                        this.mLastTouchX = x3;
                        this.mInitialTouchX = x3;
                        int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                        this.mLastTouchY = y3;
                        this.mInitialTouchY = y3;
                    } else if (actionMasked == 6) {
                        onPointerUp(motionEvent);
                    }
                    motionEventObtain.recycle();
                    return true;
                }
                this.mScrollPointerId = motionEvent.getPointerId(0);
                int x4 = (int) (motionEvent.getX() + 0.5f);
                this.mLastTouchX = x4;
                this.mInitialTouchX = x4;
                int y4 = (int) (motionEvent.getY() + 0.5f);
                this.mLastTouchY = y4;
                this.mInitialTouchY = y4;
                if (zCanScrollVertically) {
                    r2 = zCanScrollHorizontally;
                    r2 = (zCanScrollHorizontally ? 1 : 0) | 2;
                }
                r2 = zCanScrollHorizontally;
                getScrollingChildHelper().g(r2, 0);
                this.mVelocityTracker.addMovement(motionEventObtain);
                motionEventObtain.recycle();
                return true;
            }
        }
        return false;
    }

    public final void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        WeakHashMap weakHashMap = qd1.a;
        postOnAnimation(this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    public final void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z2;
        boolean z3 = false;
        if (this.mDataSetHasChangedAfterLayout) {
            androidx.recyclerview.widget.a aVar = this.mAdapterHelper;
            aVar.l(aVar.b);
            aVar.l(aVar.c);
            aVar.f = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged();
            }
        }
        androidx.recyclerview.widget.k kVar = this.mItemAnimator;
        boolean z4 = kVar != null && this.mLayout.supportsPredictiveItemAnimations();
        androidx.recyclerview.widget.a aVar2 = this.mAdapterHelper;
        if (z4) {
            aVar2.j();
        } else {
            aVar2.c();
        }
        boolean z5 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        boolean z6 = this.mFirstLayoutComplete && kVar != null && ((z2 = this.mDataSetHasChangedAfterLayout) || z5 || this.mLayout.mRequestedSimpleAnimations) && (!z2 || this.mAdapter.mHasStableIds);
        a0 a0Var = this.mState;
        a0Var.j = z6;
        if (z6 && z5 && !this.mDataSetHasChangedAfterLayout && kVar != null && this.mLayout.supportsPredictiveItemAnimations()) {
            z3 = true;
        }
        a0Var.k = z3;
    }

    public final void processDataSetCompletelyChanged(boolean z2) {
        this.mDispatchItemsChangedEvent = z2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        int iH = this.mChildHelper.h();
        for (int i2 = 0; i2 < iH; i2++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        v vVar = this.mRecycler;
        ArrayList arrayList = vVar.c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            d0 d0Var = (d0) arrayList.get(i3);
            if (d0Var != null) {
                d0Var.addFlags(6);
                d0Var.addFlags(1024);
            }
        }
        g gVar = RecyclerView.this.mAdapter;
        if (gVar == null || !gVar.mHasStableIds) {
            vVar.e();
        }
    }

    public final void recordAnimationInfoIfBouncedHiddenView(d0 d0Var, l.c cVar) {
        d0Var.mFlags &= -8193;
        boolean z2 = this.mState.h;
        androidx.recyclerview.widget.c0 c0Var = this.mViewInfoStore;
        if (z2 && d0Var.isUpdated() && !d0Var.isRemoved() && !d0Var.shouldIgnore()) {
            c0Var.b.g(getChangedHolderKey(d0Var), d0Var);
        }
        o01 o01Var = c0Var.a;
        androidx.recyclerview.widget.c0.a aVarA = (androidx.recyclerview.widget.c0.a) o01Var.getOrDefault(d0Var, null);
        if (aVarA == null) {
            aVarA = androidx.recyclerview.widget.c0.a.a();
            o01Var.put(d0Var, aVarA);
        }
        aVarA.b = cVar;
        aVarA.a |= 4;
    }

    public final void removeAndRecycleViews() {
        androidx.recyclerview.widget.k kVar = this.mItemAnimator;
        if (kVar != null) {
            kVar.e();
        }
        o oVar = this.mLayout;
        v vVar = this.mRecycler;
        if (oVar != null) {
            oVar.removeAndRecycleAllViews(vVar);
            this.mLayout.removeAndRecycleScrapInt(vVar);
        }
        vVar.a.clear();
        vVar.e();
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z2) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.mFlags &= -257;
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        getChildViewHolderInt(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        androidx.recyclerview.widget.q qVar = this.mLayout.mSmoothScroller;
        if ((qVar == null || !qVar.mRunning) && !isComputingLayout() && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public final void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.mTempRect;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.c) {
                int i2 = rect.left;
                Rect rect2 = pVar.b;
                rect.left = i2 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z2, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z2) {
        ArrayList arrayList = this.mOnItemTouchListeners;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((s) arrayList.get(i2)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public final void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        getScrollingChildHelper().h(0);
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = qd1.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final void scrollBy(int i2, int i3) {
        o oVar = this.mLayout;
        if (oVar == null || this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = oVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i2 = 0;
            }
            if (!zCanScrollVertically) {
                i3 = 0;
            }
            scrollByInternal(i2, i3, null, 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00fc A[DONT_INVERT, PHI: r9
      0x00fc: PHI (r9v10 boolean) = (r9v8 boolean), (r9v11 boolean) binds: [B:33:0x00e3, B:35:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:41:0x0106  */
    public final boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        float f2;
        boolean z2;
        EdgeEffect edgeEffect;
        float width;
        float height;
        consumePendingUpdateOperations();
        g gVar = this.mAdapter;
        int[] iArr = this.mReusableIntPair;
        if (gVar != null) {
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i2, i3, iArr);
            int i9 = iArr[0];
            int i10 = iArr[1];
            i7 = i2 - i9;
            i8 = i3 - i10;
            i5 = i9;
            i6 = i10;
        } else {
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        getScrollingChildHelper().e(i5, i6, i7, i8, this.mScrollOffset, i4, iArr);
        int i11 = iArr[0];
        int i12 = i7 - i11;
        int i13 = iArr[1];
        int i14 = i8 - i13;
        boolean z3 = (i11 == 0 && i13 == 0) ? false : true;
        int i15 = this.mLastTouchX;
        int[] iArr2 = this.mScrollOffset;
        int i16 = iArr2[0];
        this.mLastTouchX = i15 - i16;
        int i17 = this.mLastTouchY;
        int i18 = iArr2[1];
        this.mLastTouchY = i17 - i18;
        int[] iArr3 = this.mNestedOffsets;
        iArr3[0] = iArr3[0] + i16;
        iArr3[1] = iArr3[1] + i18;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && (motionEvent.getSource() & 8194) != 8194) {
                float x2 = motionEvent.getX();
                float f3 = i12;
                float y2 = motionEvent.getY();
                float f4 = i14;
                if (f3 < 0.0f) {
                    ensureLeftGlow();
                    edgeEffect = this.mLeftGlow;
                    f2 = 0.0f;
                    width = (-f3) / getWidth();
                    height = 1.0f - (y2 / getHeight());
                } else {
                    f2 = 0.0f;
                    if (f3 > 0.0f) {
                        ensureRightGlow();
                        edgeEffect = this.mRightGlow;
                        width = f3 / getWidth();
                        height = y2 / getHeight();
                    } else {
                        z2 = false;
                    }
                    if (f4 < f2) {
                        ensureTopGlow();
                        this.mTopGlow.onPull((-f4) / getHeight(), x2 / getWidth());
                    } else if (f4 > f2) {
                        ensureBottomGlow();
                        this.mBottomGlow.onPull(f4 / getHeight(), 1.0f - (x2 / getWidth()));
                    } else if (z2 || f3 != f2 || f4 != f2) {
                        WeakHashMap weakHashMap = qd1.a;
                        postInvalidateOnAnimation();
                    }
                    z2 = true;
                    if (z2) {
                        WeakHashMap weakHashMap2 = qd1.a;
                        postInvalidateOnAnimation();
                    } else {
                        WeakHashMap weakHashMap3 = qd1.a;
                        postInvalidateOnAnimation();
                    }
                }
                edgeEffect.onPull(width, height);
                z2 = true;
                if (f4 < f2) {
                    ensureTopGlow();
                    this.mTopGlow.onPull((-f4) / getHeight(), x2 / getWidth());
                } else if (f4 > f2) {
                    ensureBottomGlow();
                    this.mBottomGlow.onPull(f4 / getHeight(), 1.0f - (x2 / getWidth()));
                } else if (z2) {
                    WeakHashMap weakHashMap4 = qd1.a;
                    postInvalidateOnAnimation();
                } else {
                    WeakHashMap weakHashMap5 = qd1.a;
                    postInvalidateOnAnimation();
                }
                z2 = true;
                if (z2) {
                    WeakHashMap weakHashMap6 = qd1.a;
                    postInvalidateOnAnimation();
                } else {
                    WeakHashMap weakHashMap7 = qd1.a;
                    postInvalidateOnAnimation();
                }
            }
            considerReleasingGlowsOnScroll(i2, i3);
        }
        if (i5 != 0 || i6 != 0) {
            dispatchOnScrolled(i5, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z3 && i5 == 0 && i6 == 0) ? false : true;
    }

    public final void scrollStep(int i2, int i3, int[] iArr) {
        d0 d0Var;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        int i4 = t71.$r8$clinit;
        Trace.beginSection("RV Scroll");
        a0 a0Var = this.mState;
        fillRemainingScrollValues(a0Var);
        v vVar = this.mRecycler;
        int iScrollHorizontallyBy = i2 != 0 ? this.mLayout.scrollHorizontallyBy(i2, vVar, a0Var) : 0;
        int iScrollVerticallyBy = i3 != 0 ? this.mLayout.scrollVerticallyBy(i3, vVar, a0Var) : 0;
        Trace.endSection();
        androidx.recyclerview.widget.b bVar = this.mChildHelper;
        int iE = bVar.e();
        for (int i5 = 0; i5 < iE; i5++) {
            View viewD = bVar.d(i5);
            d0 childViewHolder = getChildViewHolder(viewD);
            if (childViewHolder != null && (d0Var = childViewHolder.mShadowingHolder) != null) {
                View view = d0Var.itemView;
                int left = viewD.getLeft();
                int top = viewD.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        onExitLayoutOrScroll(true);
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i2, int i3) {
    }

    public final void scrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        o oVar = this.mLayout;
        if (oVar == null) {
            return;
        }
        oVar.scrollToPosition(i2);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.mEatenAccessibilityChangeFlags |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public final void setAdapter(g gVar) {
        suppressLayout(false);
        g gVar2 = this.mAdapter;
        x xVar = this.mObserver;
        if (gVar2 != null) {
            gVar2.mObservable.unregisterObserver(xVar);
            this.mAdapter.getClass();
        }
        removeAndRecycleViews();
        androidx.recyclerview.widget.a aVar = this.mAdapterHelper;
        aVar.l(aVar.b);
        aVar.l(aVar.c);
        aVar.f = 0;
        g gVar3 = this.mAdapter;
        this.mAdapter = gVar;
        if (gVar != null) {
            gVar.mObservable.registerObserver(xVar);
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.onAdapterChanged();
        }
        g gVar4 = this.mAdapter;
        v vVar = this.mRecycler;
        vVar.a.clear();
        vVar.e();
        if (vVar.g == null) {
            vVar.g = new u();
        }
        u uVar = vVar.g;
        if (gVar3 != null) {
            uVar.b--;
        }
        if (uVar.b == 0) {
            int i2 = 0;
            while (true) {
                SparseArray sparseArray = uVar.a;
                if (i2 >= sparseArray.size()) {
                    break;
                }
                ((u.a) sparseArray.valueAt(i2)).a.clear();
                i2++;
            }
        }
        if (gVar4 != null) {
            uVar.b++;
        }
        this.mState.f = true;
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final void setClipToPadding(boolean z2) {
        if (z2 != this.mClipToPadding) {
            this.mBottomGlow = null;
            this.mTopGlow = null;
            this.mRightGlow = null;
            this.mLeftGlow = null;
        }
        this.mClipToPadding = z2;
        super.setClipToPadding(z2);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public final void setLayoutManager(o oVar) {
        e eVar;
        RecyclerView recyclerView;
        if (oVar == this.mLayout) {
            return;
        }
        stopScroll();
        o oVar2 = this.mLayout;
        v vVar = this.mRecycler;
        int i2 = 0;
        if (oVar2 != null) {
            androidx.recyclerview.widget.k kVar = this.mItemAnimator;
            if (kVar != null) {
                kVar.e();
            }
            this.mLayout.removeAndRecycleAllViews(vVar);
            this.mLayout.removeAndRecycleScrapInt(vVar);
            vVar.a.clear();
            vVar.e();
            if (this.mIsAttached) {
                o oVar3 = this.mLayout;
                oVar3.mIsAttachedToWindow = false;
                oVar3.onDetachedFromWindow(this);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            vVar.a.clear();
            vVar.e();
        }
        androidx.recyclerview.widget.b bVar = this.mChildHelper;
        bVar.b.g();
        ArrayList arrayList = bVar.c;
        int size = arrayList.size();
        while (true) {
            size--;
            eVar = bVar.a;
            if (size < 0) {
                break;
            }
            View view = (View) arrayList.get(size);
            eVar.getClass();
            d0 childViewHolderInt = getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                RecyclerView recyclerView2 = RecyclerView.this;
                int i3 = childViewHolderInt.mWasImportantForAccessibilityBeforeHidden;
                if (recyclerView2.isComputingLayout()) {
                    childViewHolderInt.mPendingAccessibilityState = i3;
                    recyclerView2.mPendingAccessibilityImportanceChange.add(childViewHolderInt);
                } else {
                    View view2 = childViewHolderInt.itemView;
                    WeakHashMap weakHashMap = qd1.a;
                    view2.setImportantForAccessibility(i3);
                }
                childViewHolderInt.mWasImportantForAccessibilityBeforeHidden = 0;
            }
            arrayList.remove(size);
        }
        int childCount = RecyclerView.this.getChildCount();
        while (true) {
            recyclerView = RecyclerView.this;
            if (i2 >= childCount) {
                break;
            }
            View childAt = recyclerView.getChildAt(i2);
            getChildViewHolderInt(childAt);
            childAt.clearAnimation();
            i2++;
        }
        recyclerView.removeAllViews();
        this.mLayout = oVar;
        if (oVar != null) {
            if (oVar.mRecyclerView != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(oVar);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(defpackage.e.h(oVar.mRecyclerView, sb));
            }
            oVar.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.mIsAttachedToWindow = true;
            }
        }
        vVar.l();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
        } else {
            defpackage.d.AnonymousClass0.m$2("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
    }

    @Override // android.view.View
    public final void setNestedScrollingEnabled(boolean z2) {
        ek0 scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.d) {
            WeakHashMap weakHashMap = qd1.a;
            scrollingChildHelper.c.stopNestedScroll();
        }
        scrollingChildHelper.d = z2;
    }

    public final void setScrollState(int i2) {
        androidx.recyclerview.widget.q qVar;
        if (i2 == this.mScrollState) {
            return;
        }
        this.mScrollState = i2;
        if (i2 != 2) {
            c0 c0Var = this.mViewFlinger;
            RecyclerView.this.removeCallbacks(c0Var);
            c0Var.d.abortAnimation();
            o oVar = this.mLayout;
            if (oVar != null && (qVar = oVar.mSmoothScroller) != null) {
                qVar.stop();
            }
        }
        o oVar2 = this.mLayout;
        if (oVar2 != null) {
            oVar2.onScrollStateChanged(i2);
        }
        ArrayList arrayList = this.mScrollListeners;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((t) this.mScrollListeners.get(size)).onScrollStateChanged(this, i2);
            }
        }
    }

    public final void smoothScrollBy(int i2, int i3, boolean z2) {
        o oVar = this.mLayout;
        if (oVar == null || this.mLayoutSuppressed) {
            return;
        }
        if (!oVar.canScrollHorizontally()) {
            i2 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (z2) {
            int i4 = i2 != 0 ? 1 : 0;
            if (i3 != 0) {
                i4 |= 2;
            }
            getScrollingChildHelper().g(i4, 1);
        }
        this.mViewFlinger.b(i2, i3, null, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
    }

    public final void startInterceptRequestLayout() {
        int i2 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i2;
        if (i2 != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().g(i2, 0);
    }

    public final void stopInterceptRequestLayout(boolean z2) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z2 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z2 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    public final void stopScroll() {
        androidx.recyclerview.widget.q qVar;
        setScrollState(0);
        c0 c0Var = this.mViewFlinger;
        RecyclerView.this.removeCallbacks(c0Var);
        c0Var.d.abortAnimation();
        o oVar = this.mLayout;
        if (oVar == null || (qVar = oVar.mSmoothScroller) == null) {
            return;
        }
        qVar.stop();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public final void viewRangeUpdate(int i2, int i3, Object obj) {
        int i4;
        int i5;
        int iH = this.mChildHelper.h();
        int i6 = i3 + i2;
        for (int i7 = 0; i7 < iH; i7++) {
            View viewG = this.mChildHelper.g(i7);
            d0 childViewHolderInt = getChildViewHolderInt(viewG);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i5 = childViewHolderInt.mPosition) >= i2 && i5 < i6) {
                childViewHolderInt.addFlags(2);
                if (obj == null) {
                    childViewHolderInt.addFlags(1024);
                } else if ((1024 & childViewHolderInt.mFlags) == 0) {
                    if (childViewHolderInt.mPayloads == null) {
                        ArrayList arrayList = new ArrayList();
                        childViewHolderInt.mPayloads = arrayList;
                        childViewHolderInt.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
                    }
                    childViewHolderInt.mPayloads.add(obj);
                }
                ((p) viewG.getLayoutParams()).c = true;
            }
        }
        v vVar = this.mRecycler;
        ArrayList arrayList2 = vVar.c;
        int size = arrayList2.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            d0 d0Var = (d0) arrayList2.get(size);
            if (d0Var != null && (i4 = d0Var.mPosition) >= i2 && i4 < i6) {
                d0Var.addFlags(2);
                vVar.f(size);
            }
        }
    }
}
