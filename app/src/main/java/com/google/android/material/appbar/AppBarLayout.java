package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.b2;
import defpackage.d;
import defpackage.dk0;
import defpackage.e;
import defpackage.fg1;
import defpackage.lm0;
import defpackage.o01;
import defpackage.o1;
import defpackage.qd1;
import defpackage.s1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    public int currentOffset;
    public int downPreScrollRange;
    public int downScrollRange;
    public ValueAnimator elevationOverlayAnimator;
    public boolean haveChildWithInterpolator;
    public fg1 lastInsets;
    public boolean liftOnScroll;
    public final ArrayList liftOnScrollListeners;
    public WeakReference liftOnScrollTargetView;
    public final int liftOnScrollTargetViewId;
    public boolean liftable;
    public boolean lifted;
    public ArrayList listeners;
    public int pendingAction;
    public final Drawable statusBarForeground;
    public int[] tmpStatesArray;
    public int totalScrollRange;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        public WeakReference lastNestedScrollingChildRef;
        public int lastStartedType;
        public ValueAnimator offsetAnimator;
        public int offsetDelta;
        public SavedState savedState;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static abstract class BaseDragCallback<T extends AppBarLayout> {
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class SavedState extends d {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.1
                @Override // android.os.Parcelable.Creator
                public final Object createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public final Object[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            public boolean firstVisibleChildAtMinimumHeight;
            public int firstVisibleChildIndex;
            public float firstVisibleChildPercentageShown;
            public boolean fullyScrolled;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.fullyScrolled = parcel.readByte() != 0;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // defpackage.d, android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public static View findFirstScrollingChild(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof dk0) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x005d  */
        public static void updateAppBarLayoutDrawableState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            View childAt;
            boolean zShouldLift;
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    childAt = null;
                    break;
                }
                childAt = appBarLayout.getChildAt(i3);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    break;
                } else {
                    i3++;
                }
            }
            if (childAt != null) {
                int i4 = ((LayoutParams) childAt.getLayoutParams()).scrollFlags;
                if ((i4 & 1) != 0) {
                    WeakHashMap weakHashMap = qd1.a;
                    int minimumHeight = childAt.getMinimumHeight();
                    if (i2 <= 0 || (i4 & 12) == 0 ? (i4 & 2) == 0 || (-i) < (childAt.getBottom() - minimumHeight) - appBarLayout.getTopInset() : (-i) < (childAt.getBottom() - minimumHeight) - appBarLayout.getTopInset()) {
                        zShouldLift = false;
                    } else {
                        zShouldLift = true;
                    }
                } else {
                    zShouldLift = false;
                }
            } else {
                zShouldLift = false;
            }
            if (appBarLayout.liftOnScroll) {
                zShouldLift = appBarLayout.shouldLift(findFirstScrollingChild(coordinatorLayout));
            }
            boolean liftedState = appBarLayout.setLiftedState(zShouldLift);
            if (!z) {
                if (liftedState) {
                    List list = (List) ((o01) coordinatorLayout.mChildDag.b).getOrDefault(appBarLayout, null);
                    ArrayList arrayList = coordinatorLayout.mTempDependenciesList;
                    arrayList.clear();
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                    int size = arrayList.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        CoordinatorLayout.c cVar = ((CoordinatorLayout.f) ((View) arrayList.get(i5)).getLayoutParams()).a;
                        if (cVar instanceof ScrollingViewBehavior) {
                            if (((ScrollingViewBehavior) cVar).overlayTop == 0) {
                                return;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            appBarLayout.jumpDrawablesToCurrentState();
        }

        public final void animateOffsetTo(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(getTopBottomOffsetForScrollingSibling() - i);
            float fAbs = Math.abs(0.0f);
            float f = iAbs;
            int iRound = fAbs > 0.0f ? Math.round((f / fAbs) * 1000.0f) * 3 : (int) (((f / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            ValueAnimator valueAnimator = this.offsetAnimator;
            if (topBottomOffsetForScrollingSibling == i) {
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.offsetAnimator.cancel();
                return;
            }
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.offsetAnimator = valueAnimator2;
                valueAnimator2.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        BaseBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, ((Integer) valueAnimator3.getAnimatedValue()).intValue(), AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, Integer.MAX_VALUE);
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.offsetAnimator.setDuration(Math.min(iRound, 600));
            this.offsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i);
            this.offsetAnimator.start();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final boolean canDragView(View view) {
            WeakReference weakReference = this.lastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            View view2 = (View) weakReference.get();
            return (view2 == null || !view2.isShown() || view2.canScrollVertically(-1)) ? false : true;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final int getMaxDragOffset(View view) {
            return -((AppBarLayout) view).getDownNestedScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final int getScrollRangeForDragFling(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public final int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final void onFlingFinished(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            snapToChildIfNeeded(coordinatorLayout, appBarLayout);
            if (appBarLayout.liftOnScroll) {
                appBarLayout.setLiftedState(appBarLayout.shouldLift(findFirstScrollingChild(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            BaseBehavior<T> baseBehavior;
            CoordinatorLayout coordinatorLayout2;
            int i2;
            int i3;
            int i4;
            int iRound;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.onLayoutChild(coordinatorLayout, appBarLayout, i);
            int i5 = appBarLayout.pendingAction;
            SavedState savedState = this.savedState;
            if (savedState != null && (i5 & 8) == 0) {
                if (savedState.fullyScrolled) {
                    i3 = -appBarLayout.getTotalScrollRange();
                } else {
                    View childAt = appBarLayout.getChildAt(savedState.firstVisibleChildIndex);
                    int i6 = -childAt.getBottom();
                    if (this.savedState.firstVisibleChildAtMinimumHeight) {
                        WeakHashMap weakHashMap = qd1.a;
                        iRound = appBarLayout.getTopInset() + childAt.getMinimumHeight() + i6;
                    } else {
                        iRound = Math.round(childAt.getHeight() * this.savedState.firstVisibleChildPercentageShown) + i6;
                    }
                    i4 = iRound;
                }
                baseBehavior = this;
                coordinatorLayout2 = coordinatorLayout;
                baseBehavior.setHeaderTopBottomOffset(coordinatorLayout2, appBarLayout, i4, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, Integer.MAX_VALUE);
                i2 = 0;
                appBarLayout.pendingAction = i2;
                baseBehavior.savedState = null;
                setTopAndBottomOffset(e.d(getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), i2));
                updateAppBarLayoutDrawableState(coordinatorLayout2, appBarLayout, getTopAndBottomOffset(), 0, true);
                appBarLayout.onOffsetChanged(getTopAndBottomOffset());
                updateAccessibilityActions(coordinatorLayout2, appBarLayout);
                return true;
            }
            if (i5 == 0) {
                baseBehavior = this;
                coordinatorLayout2 = coordinatorLayout;
                i2 = 0;
            } else {
                boolean z = (i5 & 4) != 0;
                if ((i5 & 2) != 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    if (z) {
                        animateOffsetTo(coordinatorLayout, appBarLayout, i3);
                        baseBehavior = this;
                        coordinatorLayout2 = coordinatorLayout;
                        i2 = 0;
                    }
                } else {
                    baseBehavior = this;
                    coordinatorLayout2 = coordinatorLayout;
                    if ((i5 & 1) == 0) {
                        i2 = 0;
                    } else if (z) {
                        animateOffsetTo(coordinatorLayout2, appBarLayout, 0);
                        i2 = 0;
                    } else {
                        i2 = 0;
                        baseBehavior.setHeaderTopBottomOffset(coordinatorLayout2, appBarLayout, 0, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, Integer.MAX_VALUE);
                    }
                }
            }
            appBarLayout.pendingAction = i2;
            baseBehavior.savedState = null;
            setTopAndBottomOffset(e.d(getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), i2));
            updateAppBarLayoutDrawableState(coordinatorLayout2, appBarLayout, getTopAndBottomOffset(), 0, true);
            appBarLayout.onOffsetChanged(getTopAndBottomOffset());
            updateAccessibilityActions(coordinatorLayout2, appBarLayout);
            return true;
            i4 = i3;
            baseBehavior = this;
            coordinatorLayout2 = coordinatorLayout;
            baseBehavior.setHeaderTopBottomOffset(coordinatorLayout2, appBarLayout, i4, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, Integer.MAX_VALUE);
            i2 = 0;
            appBarLayout.pendingAction = i2;
            baseBehavior.savedState = null;
            setTopAndBottomOffset(e.d(getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), i2));
            updateAppBarLayoutDrawableState(coordinatorLayout2, appBarLayout, getTopAndBottomOffset(), 0, true);
            appBarLayout.onOffsetChanged(getTopAndBottomOffset());
            updateAccessibilityActions(coordinatorLayout2, appBarLayout);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.onMeasureChild(i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), appBarLayout);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            onNestedPreScroll(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0025  */
        public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int[] iArr) {
            AppBarLayout appBarLayout2;
            if (i != 0) {
                int i2 = -appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = i < 0 ? appBarLayout.getDownNestedPreScrollRange() + i2 : 0;
                if (i2 != downNestedPreScrollRange) {
                    appBarLayout2 = appBarLayout;
                    iArr[1] = setHeaderTopBottomOffset(coordinatorLayout, appBarLayout2, getTopBottomOffsetForScrollingSibling() - i, i2, downNestedPreScrollRange);
                } else {
                    appBarLayout2 = appBarLayout;
                }
            } else {
                appBarLayout2 = appBarLayout;
            }
            if (appBarLayout2.liftOnScroll) {
                appBarLayout2.setLiftedState(appBarLayout2.shouldLift(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i3 < 0) {
                coordinatorLayout2 = coordinatorLayout;
                iArr[1] = setHeaderTopBottomOffset(coordinatorLayout2, appBarLayout, getTopBottomOffsetForScrollingSibling() - i3, -appBarLayout.getDownNestedScrollRange(), 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
            }
            if (i3 == 0) {
                updateAccessibilityActions(coordinatorLayout2, appBarLayout);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void onRestoreInstanceState(View view, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                this.savedState = (SavedState) parcelable;
            } else {
                this.savedState = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final Parcelable onSaveInstanceState(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(absSavedState);
                    savedState.fullyScrolled = (-getTopAndBottomOffset()) >= appBarLayout.getTotalScrollRange();
                    savedState.firstVisibleChildIndex = i;
                    WeakHashMap weakHashMap = qd1.a;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight();
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return absSavedState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z = (i & 2) != 0 && (appBarLayout.liftOnScroll || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z && (valueAnimator = this.offsetAnimator) != null) {
                valueAnimator.cancel();
            }
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = i2;
            return z;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.lastStartedType == 0 || i == 1) {
                snapToChildIfNeeded(coordinatorLayout, appBarLayout);
                if (appBarLayout.liftOnScroll) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view2));
                }
            }
            this.lastNestedScrollingChildRef = new WeakReference(view2);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public final int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            int top;
            int topInset;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i4 = 0;
            if (i2 == 0 || topBottomOffsetForScrollingSibling < i2 || topBottomOffsetForScrollingSibling > i3) {
                this.offsetDelta = 0;
            } else {
                int iD = e.d(i, i2, i3);
                if (topBottomOffsetForScrollingSibling != iD) {
                    if (!appBarLayout.haveChildWithInterpolator) {
                        top = iD;
                        break;
                    }
                    int iAbs = Math.abs(iD);
                    int childCount = appBarLayout.getChildCount();
                    int i5 = 0;
                    while (true) {
                        if (i5 < childCount) {
                            View childAt = appBarLayout.getChildAt(i5);
                            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                            Interpolator interpolator = layoutParams.scrollInterpolator;
                            if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                                i5++;
                            } else if (interpolator != null) {
                                int i6 = layoutParams.scrollFlags;
                                if ((i6 & 1) != 0) {
                                    topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                                    if ((i6 & 2) != 0) {
                                        WeakHashMap weakHashMap = qd1.a;
                                        topInset -= childAt.getMinimumHeight();
                                    }
                                } else {
                                    topInset = 0;
                                }
                                WeakHashMap weakHashMap2 = qd1.a;
                                if (childAt.getFitsSystemWindows()) {
                                    topInset -= appBarLayout.getTopInset();
                                }
                                if (topInset > 0) {
                                    float f = topInset;
                                    top = (childAt.getTop() + Math.round(interpolator.getInterpolation((iAbs - childAt.getTop()) / f) * f)) * Integer.signum(iD);
                                    break;
                                }
                            }
                        }
                        top = iD;
                        break;
                    }
                    boolean topAndBottomOffset = setTopAndBottomOffset(top);
                    int i7 = topBottomOffsetForScrollingSibling - iD;
                    this.offsetDelta = iD - top;
                    if (topAndBottomOffset) {
                        for (int i8 = 0; i8 < appBarLayout.getChildCount(); i8++) {
                            LayoutParams layoutParams2 = (LayoutParams) appBarLayout.getChildAt(i8).getLayoutParams();
                            CompressChildScrollEffect compressChildScrollEffect = layoutParams2.scrollEffect;
                            if (compressChildScrollEffect != null && (layoutParams2.scrollFlags & 1) != 0) {
                                View childAt2 = appBarLayout.getChildAt(i8);
                                float topAndBottomOffset2 = getTopAndBottomOffset();
                                Rect rect = compressChildScrollEffect.ghostRect;
                                Rect rect2 = compressChildScrollEffect.relativeRect;
                                childAt2.getDrawingRect(rect2);
                                appBarLayout.offsetDescendantRectToMyCoords(childAt2, rect2);
                                rect2.offset(0, -appBarLayout.getTopInset());
                                float fAbs = rect2.top - Math.abs(topAndBottomOffset2);
                                if (fAbs <= 0.0f) {
                                    float fAbs2 = Math.abs(fAbs / rect2.height());
                                    float f2 = 1.0f - (fAbs2 >= 0.0f ? fAbs2 > 1.0f ? 1.0f : fAbs2 : 0.0f);
                                    float fHeight = (-fAbs) - ((rect2.height() * 0.3f) * (1.0f - (f2 * f2)));
                                    childAt2.setTranslationY(fHeight);
                                    childAt2.getDrawingRect(rect);
                                    rect.offset(0, (int) (-fHeight));
                                    WeakHashMap weakHashMap3 = qd1.a;
                                    childAt2.setClipBounds(rect);
                                } else {
                                    WeakHashMap weakHashMap4 = qd1.a;
                                    childAt2.setClipBounds(null);
                                    childAt2.setTranslationY(0.0f);
                                }
                            }
                        }
                    }
                    if (!topAndBottomOffset && appBarLayout.haveChildWithInterpolator) {
                        coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
                    }
                    appBarLayout.onOffsetChanged(getTopAndBottomOffset());
                    updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, iD, iD < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                    i4 = i7;
                }
            }
            updateAccessibilityActions(coordinatorLayout, appBarLayout);
            return i4;
        }

        public final void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if ((layoutParams.scrollFlags & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i2 = -topBottomOffsetForScrollingSibling;
                if (top <= i2 && bottom >= i2) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                View childAt2 = appBarLayout.getChildAt(i);
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                int i3 = layoutParams2.scrollFlags;
                if ((i3 & 17) == 17) {
                    int i4 = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i == appBarLayout.getChildCount() - 1) {
                        minimumHeight += appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
                    }
                    if ((i3 & 2) == 2) {
                        WeakHashMap weakHashMap = qd1.a;
                        minimumHeight += childAt2.getMinimumHeight();
                    } else if ((i3 & 5) == 5) {
                        WeakHashMap weakHashMap2 = qd1.a;
                        int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                        if (topBottomOffsetForScrollingSibling < minimumHeight2) {
                            i4 = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if ((i3 & 32) == 32) {
                        i4 += ((LinearLayout.LayoutParams) layoutParams2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                    }
                    if (topBottomOffsetForScrollingSibling < (minimumHeight + i4) / 2) {
                        i4 = minimumHeight;
                    }
                    animateOffsetTo(coordinatorLayout, appBarLayout, e.d(i4, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        public final void updateAccessibilityActions(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
            o1.a aVar = o1.a.h;
            qd1.i(coordinatorLayout, aVar.a());
            final boolean z = false;
            qd1.g(coordinatorLayout, 0);
            o1.a aVar2 = o1.a.i;
            qd1.i(coordinatorLayout, aVar2.a());
            qd1.g(coordinatorLayout, 0);
            final View viewFindFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
            if (viewFindFirstScrollingChild != null && appBarLayout.getTotalScrollRange() != 0 && (((CoordinatorLayout.f) viewFindFirstScrollingChild.getLayoutParams()).a instanceof ScrollingViewBehavior)) {
                final boolean z2 = true;
                if (getTopBottomOffsetForScrollingSibling() != (-appBarLayout.getTotalScrollRange()) && viewFindFirstScrollingChild.canScrollVertically(1)) {
                    qd1.j(coordinatorLayout, aVar, new s1(this) { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                        @Override // defpackage.s1
                        public final boolean perform(View view) {
                            AppBarLayout appBarLayout2 = appBarLayout;
                            appBarLayout2.getClass();
                            WeakHashMap weakHashMap = qd1.a;
                            appBarLayout2.setExpanded(z, appBarLayout2.isLaidOut(), true);
                            return true;
                        }
                    });
                }
                if (getTopBottomOffsetForScrollingSibling() != 0) {
                    if (!viewFindFirstScrollingChild.canScrollVertically(-1)) {
                        qd1.j(coordinatorLayout, aVar2, new s1(this) { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                            @Override // defpackage.s1
                            public final boolean perform(View view) {
                                AppBarLayout appBarLayout2 = appBarLayout;
                                appBarLayout2.getClass();
                                WeakHashMap weakHashMap = qd1.a;
                                appBarLayout2.setExpanded(z2, appBarLayout2.isLaidOut(), true);
                                return true;
                            }
                        });
                        return;
                    }
                    final int i = -appBarLayout.getDownNestedPreScrollRange();
                    if (i != 0) {
                        qd1.j(coordinatorLayout, aVar2, new s1() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
                            @Override // defpackage.s1
                            public final boolean perform(View view) {
                                BaseBehavior.this.onNestedPreScroll(coordinatorLayout, appBarLayout, viewFindFirstScrollingChild, i, new int[]{0, 0});
                                return true;
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(int i);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Behavior extends BaseBehavior<AppBarLayout> {

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class ChildScrollEffect {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class CompressChildScrollEffect extends ChildScrollEffect {
        public final Rect relativeRect = new Rect();
        public final Rect ghostRect = new Rect();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public final CompressChildScrollEffect scrollEffect;
        public final int scrollFlags;
        public final Interpolator scrollInterpolator;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.scrollFlags = 1;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.scrollFlags = 1;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.scrollFlags = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.scrollFlags = typedArrayObtainStyledAttributes.getInt(1, 0);
            this.scrollEffect = typedArrayObtainStyledAttributes.getInt(0, 0) != 1 ? null : new CompressChildScrollEffect();
            if (typedArrayObtainStyledAttributes.hasValue(2)) {
                this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.scrollFlags = 1;
            this.scrollFlags = layoutParams.scrollFlags;
            this.scrollInterpolator = layoutParams.scrollInterpolator;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface LiftOnScrollListener {
        void onUpdate();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            this.overlayTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final AppBarLayout findFirstDependency(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = (View) arrayList.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final float getOverlapRatioForOffset(View view) {
            int i;
            if (!(view instanceof AppBarLayout)) {
                return 0.0f;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).a;
            int topBottomOffsetForScrollingSibling = cVar instanceof BaseBehavior ? ((BaseBehavior) cVar).getTopBottomOffsetForScrollingSibling() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + topBottomOffsetForScrollingSibling > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                return (topBottomOffsetForScrollingSibling / i) + 1.0f;
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final int getScrollRange(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : view.getMeasuredHeight();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public final /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            throw null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean layoutDependsOn(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            int iD;
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) view2.getLayoutParams()).a;
            if (cVar instanceof BaseBehavior) {
                int bottom = ((BaseBehavior) cVar).offsetDelta + (view2.getBottom() - view.getTop()) + this.verticalLayoutGap;
                if (this.overlayTop == 0) {
                    iD = 0;
                } else {
                    float overlapRatioForOffset = getOverlapRatioForOffset(view2);
                    int i = this.overlayTop;
                    iD = e.d((int) (overlapRatioForOffset * i), 0, i);
                }
                int i2 = bottom - iD;
                WeakHashMap weakHashMap = qd1.a;
                view.offsetTopAndBottom(i2);
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.liftOnScroll) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                qd1.i(coordinatorLayout, o1.a.h.a());
                qd1.g(coordinatorLayout, 0);
                qd1.i(coordinatorLayout, o1.a.i.a());
                qd1.g(coordinatorLayout, 0);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayout;
            ArrayList dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    appBarLayout = null;
                    break;
                }
                View view2 = (View) dependencies.get(i);
                if (view2 instanceof AppBarLayout) {
                    appBarLayout = (AppBarLayout) view2;
                    break;
                }
                i++;
            }
            if (appBarLayout != null) {
                rect.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect2 = this.tempRect1;
                rect2.set(0, 0, width, height);
                if (!rect2.contains(rect)) {
                    appBarLayout.setExpanded(false, !z, true);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public final /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            throw null;
        }
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.b4);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.we), attributeSet, i);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        boolean z = false;
        this.pendingAction = 0;
        this.liftOnScrollListeners = new ArrayList();
        Context context2 = getContext();
        super.setOrientation(1);
        int i2 = Build.VERSION.SDK_INT;
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context3, attributeSet, ViewUtilsLollipop.STATE_LIST_ANIM_ATTRS, i, org.hamotunnelplus.xyz.R.plurals.we, new int[0]);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayObtainStyledAttributes.getResourceId(0, 0)));
            }
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.AppBarLayout, i, org.hamotunnelplus.xyz.R.plurals.we, new int[0]);
            Drawable drawable = typedArrayObtainStyledAttributes2.getDrawable(0);
            WeakHashMap weakHashMap = qd1.a;
            setBackground(drawable);
            if (getBackground() instanceof ColorDrawable) {
                ColorDrawable colorDrawable = (ColorDrawable) getBackground();
                MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
                materialShapeDrawable.setFillColor(ColorStateList.valueOf(colorDrawable.getColor()));
                materialShapeDrawable.initializeElevationOverlay(context2);
                setBackground(materialShapeDrawable);
            }
            if (typedArrayObtainStyledAttributes2.hasValue(4)) {
                setExpanded(typedArrayObtainStyledAttributes2.getBoolean(4, false), false, false);
            }
            if (typedArrayObtainStyledAttributes2.hasValue(3)) {
                float dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(3, 0);
                int integer = getResources().getInteger(org.hamotunnelplus.xyz.R.integer.e);
                StateListAnimator stateListAnimator = new StateListAnimator();
                long j = integer;
                stateListAnimator.addState(new int[]{android.R.attr.state_enabled, org.hamotunnelplus.xyz.R.style.a1i, -2130969621}, ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(j));
                stateListAnimator.addState(new int[]{android.R.attr.state_enabled}, ObjectAnimator.ofFloat(this, "elevation", dimensionPixelSize).setDuration(j));
                stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(0L));
                setStateListAnimator(stateListAnimator);
            }
            if (i2 >= 26) {
                if (typedArrayObtainStyledAttributes2.hasValue(2)) {
                    setKeyboardNavigationCluster(typedArrayObtainStyledAttributes2.getBoolean(2, false));
                }
                if (typedArrayObtainStyledAttributes2.hasValue(1)) {
                    setTouchscreenBlocksFocus(typedArrayObtainStyledAttributes2.getBoolean(1, false));
                }
            }
            this.liftOnScroll = typedArrayObtainStyledAttributes2.getBoolean(5, false);
            this.liftOnScrollTargetViewId = typedArrayObtainStyledAttributes2.getResourceId(6, -1);
            Drawable drawable2 = typedArrayObtainStyledAttributes2.getDrawable(7);
            Drawable drawable3 = this.statusBarForeground;
            if (drawable3 != drawable2) {
                if (drawable3 != null) {
                    drawable3.setCallback(null);
                }
                Drawable drawableMutate = drawable2 != null ? drawable2.mutate() : null;
                this.statusBarForeground = drawableMutate;
                if (drawableMutate != null) {
                    if (drawableMutate.isStateful()) {
                        drawableMutate.setState(getDrawableState());
                    }
                    drawableMutate.setLayoutDirection(getLayoutDirection());
                    drawableMutate.setVisible(getVisibility() == 0, false);
                    drawableMutate.setCallback(this);
                }
                if (drawableMutate != null && getTopInset() > 0) {
                    z = true;
                }
                setWillNotDraw(!z);
                postInvalidateOnAnimation();
            }
            typedArrayObtainStyledAttributes2.recycle();
            b2.u(this, new lm0() { // from class: com.google.android.material.appbar.AppBarLayout.1
                @Override // defpackage.lm0
                public final fg1 onApplyWindowInsets(View view, fg1 fg1Var) {
                    AppBarLayout appBarLayout = AppBarLayout.this;
                    appBarLayout.getClass();
                    WeakHashMap weakHashMap2 = qd1.a;
                    fg1 fg1Var2 = appBarLayout.getFitsSystemWindows() ? fg1Var : null;
                    if (!Objects.equals(appBarLayout.lastInsets, fg1Var2)) {
                        appBarLayout.lastInsets = fg1Var2;
                        appBarLayout.setWillNotDraw(!(appBarLayout.statusBarForeground != null && appBarLayout.getTopInset() > 0));
                        appBarLayout.requestLayout();
                    }
                    return fg1Var;
                }
            });
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public static LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.statusBarForeground == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, -this.currentOffset);
        this.statusBarForeground.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarForeground;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public final CoordinatorLayout.c getBehavior() {
        return new Behavior();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0046  */
    /* JADX WARN: Code duplicated, block: B:20:0x004e  */
    public final int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i = this.downPreScrollRange;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.scrollFlags;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
            } else {
                int i4 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i3 & 8) != 0) {
                    WeakHashMap weakHashMap = qd1.a;
                    minimumHeight = childAt.getMinimumHeight();
                } else {
                    if ((i3 & 2) != 0) {
                        WeakHashMap weakHashMap2 = qd1.a;
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        iMin = i4 + measuredHeight;
                    }
                    if (childCount == 0) {
                        WeakHashMap weakHashMap3 = qd1.a;
                        if (childAt.getFitsSystemWindows()) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                    }
                    i2 += iMin;
                }
                iMin = minimumHeight + i4;
                if (childCount == 0) {
                    WeakHashMap weakHashMap4 = qd1.a;
                    if (childAt.getFitsSystemWindows()) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                }
                i2 += iMin;
            }
        }
        int iMax = Math.max(0, i2);
        this.downPreScrollRange = iMax;
        return iMax;
    }

    public final int getDownNestedScrollRange() {
        int i = this.downScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int minimumHeight = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
            int i3 = layoutParams.scrollFlags;
            if ((i3 & 1) == 0) {
                break;
            }
            minimumHeight += measuredHeight;
            if ((i3 & 2) != 0) {
                WeakHashMap weakHashMap = qd1.a;
                minimumHeight -= childAt.getMinimumHeight();
                break;
            }
        }
        int iMax = Math.max(0, minimumHeight);
        this.downScrollRange = iMax;
        return iMax;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        WeakHashMap weakHashMap = qd1.a;
        int minimumHeight = getMinimumHeight();
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public final int getTopInset() {
        fg1 fg1Var = this.lastInsets;
        if (fg1Var != null) {
            return fg1Var.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.totalScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int minimumHeight = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.scrollFlags;
            if ((i3 & 1) == 0) {
                break;
            }
            int topInset = measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + minimumHeight;
            if (i2 == 0) {
                WeakHashMap weakHashMap = qd1.a;
                if (childAt.getFitsSystemWindows()) {
                    topInset -= getTopInset();
                }
            }
            minimumHeight = topInset;
            if ((i3 & 2) != 0) {
                WeakHashMap weakHashMap2 = qd1.a;
                minimumHeight -= childAt.getMinimumHeight();
                break;
            }
        }
        int iMax = Math.max(0, minimumHeight);
        this.totalScrollRange = iMax;
        return iMax;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] iArr = this.tmpStatesArray;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z = this.liftable;
        iArr[0] = z ? org.hamotunnelplus.xyz.R.style.a1i : -2130969620;
        iArr[1] = (z && this.lifted) ? org.hamotunnelplus.xyz.R.style.a1j : -2130969621;
        iArr[2] = z ? org.hamotunnelplus.xyz.R.style.a1g : -2130969618;
        iArr[3] = (z && this.lifted) ? org.hamotunnelplus.xyz.R.style.a1f : -2130969617;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.liftOnScrollTargetView = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        WeakHashMap weakHashMap = qd1.a;
        boolean z2 = false;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    getChildAt(childCount).offsetTopAndBottom(topInset);
                }
            }
        }
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.haveChildWithInterpolator = false;
        int childCount2 = getChildCount();
        for (int i5 = 0; i5 < childCount2; i5++) {
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).scrollInterpolator != null) {
                this.haveChildWithInterpolator = true;
                break;
            }
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.liftOnScroll) {
            z2 = true;
            break;
        }
        int childCount3 = getChildCount();
        for (int i6 = 0; i6 < childCount3; i6++) {
            int i7 = ((LayoutParams) getChildAt(i6).getLayoutParams()).scrollFlags;
            if ((i7 & 1) == 1 && (i7 & 10) != 0) {
                z2 = true;
                break;
            }
        }
        if (this.liftable != z2) {
            this.liftable = z2;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            WeakHashMap weakHashMap = qd1.a;
            if (getFitsSystemWindows() && getChildCount() > 0) {
                View childAt = getChildAt(0);
                if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                    int measuredHeight = getMeasuredHeight();
                    if (mode == Integer.MIN_VALUE) {
                        measuredHeight = e.d(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i2));
                    } else if (mode == 0) {
                        measuredHeight += getTopInset();
                    }
                    setMeasuredDimension(getMeasuredWidth(), measuredHeight);
                }
            }
        }
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
    }

    public final void onOffsetChanged(int i) {
        this.currentOffset = i;
        if (!willNotDraw()) {
            WeakHashMap weakHashMap = qd1.a;
            postInvalidateOnAnimation();
        }
        ArrayList arrayList = this.listeners;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = (BaseOnOffsetChangedListener) this.listeners.get(i2);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.onOffsetChanged(i);
                }
            }
        }
    }

    @Override // android.view.View
    public final void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }

    public final void setExpanded(boolean z, boolean z2, boolean z3) {
        this.pendingAction = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    public final boolean setLiftedState(boolean z) {
        if (this.lifted == z) {
            return false;
        }
        this.lifted = z;
        refreshDrawableState();
        if (this.liftOnScroll && (getBackground() instanceof MaterialShapeDrawable)) {
            final MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
            float dimension = getResources().getDimension(org.hamotunnelplus.xyz.R.dimen.c3);
            float f = z ? 0.0f : dimension;
            if (!z) {
                dimension = 0.0f;
            }
            ValueAnimator valueAnimator = this.elevationOverlayAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, dimension);
            this.elevationOverlayAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(getResources().getInteger(org.hamotunnelplus.xyz.R.integer.e));
            this.elevationOverlayAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            this.elevationOverlayAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    materialShapeDrawable.setElevation(fFloatValue);
                    AppBarLayout appBarLayout = AppBarLayout.this;
                    Drawable drawable = appBarLayout.statusBarForeground;
                    if (drawable instanceof MaterialShapeDrawable) {
                        ((MaterialShapeDrawable) drawable).setElevation(fFloatValue);
                    }
                    Iterator it = appBarLayout.liftOnScrollListeners.iterator();
                    while (it.hasNext()) {
                        ((LiftOnScrollListener) it.next()).onUpdate();
                    }
                }
            });
            this.elevationOverlayAnimator.start();
        }
        return true;
    }

    @Override // android.widget.LinearLayout
    public final void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
        } else {
            d.AnonymousClass0.m$2("AppBarLayout is always vertical and does not support horizontal orientation");
        }
    }

    @Override // android.view.View
    public final void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    public final boolean shouldLift(View view) {
        int i;
        if (this.liftOnScrollTargetView == null && (i = this.liftOnScrollTargetViewId) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(i);
            }
            if (viewFindViewById != null) {
                this.liftOnScrollTargetView = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.liftOnScrollTargetView;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.statusBarForeground;
    }
}
