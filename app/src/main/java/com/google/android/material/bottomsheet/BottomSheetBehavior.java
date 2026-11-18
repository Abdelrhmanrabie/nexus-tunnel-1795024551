package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.a1;
import defpackage.d;
import defpackage.e;
import defpackage.fg1;
import defpackage.o1;
import defpackage.qd1;
import defpackage.s1;
import defpackage.v3;
import defpackage.vd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public int activePointerId;
    public final ArrayList callbacks;
    public int childHeight;
    public int collapsedOffset;
    public final v3 dragCallback;
    public final boolean draggable;
    public final float elevation;
    public int expandHalfwayActionId;
    public final int expandedOffset;
    public boolean fitToContents;
    public int fitToContentsOffset;
    public int gestureInsetBottom;
    public final boolean gestureInsetBottomIgnored;
    public int halfExpandedOffset;
    public final float halfExpandedRatio;
    public boolean hideable;
    public boolean ignoreEvents;
    public HashMap importantForAccessibilityMap;
    public int initialY;
    public int insetBottom;
    public int insetTop;
    public final ValueAnimator interpolatorAnimator;
    public boolean isShapeExpanded;
    public int lastNestedScrollDy;
    public MaterialShapeDrawable materialShapeDrawable;
    public final int maxHeight;
    public final int maxWidth;
    public final float maximumVelocity;
    public boolean nestedScrolled;
    public WeakReference nestedScrollingChildRef;
    public final boolean paddingBottomSystemWindowInsets;
    public final boolean paddingLeftSystemWindowInsets;
    public final boolean paddingRightSystemWindowInsets;
    public final boolean paddingTopSystemWindowInsets;
    public int parentHeight;
    public int parentWidth;
    public int peekHeight;
    public boolean peekHeightAuto;
    public final int peekHeightGestureInsetBuffer;
    public int peekHeightMin;
    public final int saveFlags;
    public SettleRunnable settleRunnable;
    public ShapeAppearanceModel shapeAppearanceModelDefault;
    public final boolean shapeThemingEnabled;
    public boolean skipCollapsed;
    public int state;
    public boolean touchingScrollingChild;
    public VelocityTracker velocityTracker;
    public vd1 viewDragHelper;
    public WeakReference viewRef;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view);

        public abstract void onStateChanged(View view, int i);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SavedState extends d {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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
        public final boolean fitToContents;
        public final boolean hideable;
        public final int peekHeight;
        public final boolean skipCollapsed;
        public final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }

        @Override // defpackage.d, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class SettleRunnable implements Runnable {
        public boolean isPosted;
        public int targetState;
        public final View view;

        public SettleRunnable(View view, int i) {
            this.view = view;
            this.targetState = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            vd1 vd1Var = bottomSheetBehavior.viewDragHelper;
            if (vd1Var == null || !vd1Var.g()) {
                bottomSheetBehavior.setStateInternal(this.targetState);
            } else {
                WeakHashMap weakHashMap = qd1.a;
                this.view.postOnAnimation(this);
            }
            this.isPosted = false;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new v3() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
            @Override // defpackage.v3
            public final int clampViewPositionHorizontal(View view, int i) {
                return view.getLeft();
            }

            @Override // defpackage.v3
            public final int clampViewPositionVertical(View view, int i) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return e.d(i, bottomSheetBehavior.getExpandedOffset(), bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
            }

            @Override // defpackage.v3
            public final int getViewVerticalDragRange() {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset;
            }

            @Override // defpackage.v3
            public final void onViewDragStateChanged(int i) {
                if (i == 1) {
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.draggable) {
                        bottomSheetBehavior.setStateInternal(1);
                    }
                }
            }

            @Override // defpackage.v3
            public final void onViewPositionChanged(View view, int i, int i2) {
                BottomSheetBehavior.this.dispatchOnSlide(i2);
            }

            /* JADX WARN: Code duplicated, block: B:42:0x00b0  */
            /* JADX WARN: Code duplicated, block: B:48:0x00c2  */
            /* JADX WARN: Code duplicated, block: B:52:0x00d8  */
            /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
            
                if (r6 > r7) goto L54;
             */
            @Override // defpackage.v3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void onViewReleased(android.view.View r5, float r6, float r7) {
                /*
                    Method dump skipped, instruction units count: 230
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4.onViewReleased(android.view.View, float, float):void");
            }

            @Override // defpackage.v3
            public final boolean tryCaptureView(View view, int i) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i2 = bottomSheetBehavior.state;
                if (i2 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i2 == 3 && bottomSheetBehavior.activePointerId == i) {
                    WeakReference weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                    View view2 = weakReference != null ? (View) weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                System.currentTimeMillis();
                WeakReference weakReference2 = bottomSheetBehavior.viewRef;
                return weakReference2 != null && weakReference2.get() == view;
            }
        };
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new v3() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
            @Override // defpackage.v3
            public final int clampViewPositionHorizontal(View view, int i2) {
                return view.getLeft();
            }

            @Override // defpackage.v3
            public final int clampViewPositionVertical(View view, int i2) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return e.d(i2, bottomSheetBehavior.getExpandedOffset(), bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
            }

            @Override // defpackage.v3
            public final int getViewVerticalDragRange() {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset;
            }

            @Override // defpackage.v3
            public final void onViewDragStateChanged(int i2) {
                if (i2 == 1) {
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.draggable) {
                        bottomSheetBehavior.setStateInternal(1);
                    }
                }
            }

            @Override // defpackage.v3
            public final void onViewPositionChanged(View view, int i2, int i3) {
                BottomSheetBehavior.this.dispatchOnSlide(i3);
            }

            /* JADX WARN: Code duplicated, block: B:42:0x00b0  */
            /* JADX WARN: Code duplicated, block: B:48:0x00c2  */
            /* JADX WARN: Code duplicated, block: B:52:0x00d8  */
            /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
            
                if (r6 > r7) goto L54;
             */
            @Override // defpackage.v3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void onViewReleased(android.view.View r5, float r6, float r7) {
                /*
                    Method dump skipped, instruction units count: 230
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4.onViewReleased(android.view.View, float, float):void");
            }

            @Override // defpackage.v3
            public final boolean tryCaptureView(View view, int i2) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i3 = bottomSheetBehavior.state;
                if (i3 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i3 == 3 && bottomSheetBehavior.activePointerId == i2) {
                    WeakReference weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                    View view2 = weakReference != null ? (View) weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                System.currentTimeMillis();
                WeakReference weakReference2 = bottomSheetBehavior.viewRef;
                return weakReference2 != null && weakReference2.get() == view;
            }
        };
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.mp);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = typedArrayObtainStyledAttributes.hasValue(17);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(3);
        if (zHasValue) {
            createMaterialShapeDrawable(context, attributeSet, zHasValue, MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 3));
        } else {
            createMaterialShapeDrawable(context, attributeSet, zHasValue, null);
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.this.materialShapeDrawable;
                if (materialShapeDrawable != null) {
                    materialShapeDrawable.setInterpolation(fFloatValue);
                }
            }
        });
        this.elevation = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.maxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.maxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(9);
        if (typedValuePeekValue == null || (i = typedValuePeekValue.data) != -1) {
            setPeekHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(9, -1));
        } else {
            setPeekHeight(i);
        }
        setHideable(typedArrayObtainStyledAttributes.getBoolean(8, false));
        this.gestureInsetBottomIgnored = typedArrayObtainStyledAttributes.getBoolean(12, false);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(6, true);
        if (this.fitToContents != z) {
            this.fitToContents = z;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
            updateAccessibilityActions();
        }
        this.skipCollapsed = typedArrayObtainStyledAttributes.getBoolean(11, false);
        this.draggable = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.saveFlags = typedArrayObtainStyledAttributes.getInt(10, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(7, 0.5f);
        if (f <= 0.0f || f >= 1.0f) {
            d.AnonymousClass0.m$2("ratio must be a float value between 0 and 1");
            throw null;
        }
        this.halfExpandedRatio = f;
        if (this.viewRef != null) {
            this.halfExpandedOffset = (int) ((1.0f - f) * this.parentHeight);
        }
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(5);
        int dimensionPixelOffset = (typedValuePeekValue2 == null || typedValuePeekValue2.type != 16) ? typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 0) : typedValuePeekValue2.data;
        if (dimensionPixelOffset < 0) {
            d.AnonymousClass0.m$2("offset must be greater than or equal to 0");
            throw null;
        }
        this.expandedOffset = dimensionPixelOffset;
        this.paddingBottomSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.paddingLeftSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.paddingRightSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(15, false);
        this.paddingTopSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(16, true);
        typedArrayObtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static View findScrollingChild(View view) {
        WeakHashMap weakHashMap = qd1.a;
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewFindScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
            if (viewFindScrollingChild != null) {
                return viewFindScrollingChild;
            }
        }
        return null;
    }

    public static BottomSheetBehavior from(View view) {
        String str;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) layoutParams).a;
            if (cVar instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) cVar;
            }
            str = "The view is not associated with BottomSheetBehavior";
        } else {
            str = "The view is not a child of CoordinatorLayout";
        }
        d.AnonymousClass0.m$2(str);
        return null;
    }

    public static int getChildMeasureSpec(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
    }

    public final void calculateCollapsedOffset() {
        int iCalculatePeekHeight = calculatePeekHeight();
        boolean z = this.fitToContents;
        int i = this.parentHeight - iCalculatePeekHeight;
        if (z) {
            this.collapsedOffset = Math.max(i, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = i;
        }
    }

    public final int calculatePeekHeight() {
        int i;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom;
        }
        return (this.gestureInsetBottomIgnored || this.paddingBottomSystemWindowInsets || (i = this.gestureInsetBottom) <= 0) ? this.peekHeight + this.insetBottom : Math.max(this.peekHeight, i + this.peekHeightGestureInsetBuffer);
    }

    public final void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R.style.cr, R.plurals.wg).build();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            if (z && colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    public final void dispatchOnSlide(int i) {
        View view = (View) this.viewRef.get();
        if (view != null) {
            ArrayList arrayList = this.callbacks;
            if (arrayList.isEmpty()) {
                return;
            }
            int i2 = this.collapsedOffset;
            if (i <= i2 && i2 != getExpandedOffset()) {
                getExpandedOffset();
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ((BottomSheetCallback) arrayList.get(i3)).onSlide(view);
            }
        }
    }

    public final int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return Math.max(this.expandedOffset, this.paddingTopSystemWindowInsets ? 0 : this.insetTop);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onDetachedFromLayoutParams() {
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        vd1 vd1Var;
        if (!view.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.activePointerId = -1;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference weakReference = this.nestedScrollingChildRef;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(view, x, this.initialY);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (this.ignoreEvents || (vd1Var = this.viewDragHelper) == null || !vd1Var.r(motionEvent)) {
            WeakReference weakReference2 = this.nestedScrollingChildRef;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(this.initialY - motionEvent.getY()) <= this.viewDragHelper.b) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        int expandedOffset;
        MaterialShapeDrawable materialShapeDrawable;
        WeakHashMap weakHashMap = qd1.a;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.ch);
            final boolean z = (Build.VERSION.SDK_INT < 29 || this.gestureInsetBottomIgnored || this.peekHeightAuto) ? false : true;
            if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || z) {
                ViewUtils.doOnApplyWindowInsets(view, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
                    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
                    public final fg1 onApplyWindowInsets(View view2, fg1 fg1Var, ViewUtils.RelativePadding relativePadding) {
                        int iD = fg1Var.d();
                        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                        bottomSheetBehavior.insetTop = iD;
                        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(view2);
                        int paddingBottom = view2.getPaddingBottom();
                        int paddingLeft = view2.getPaddingLeft();
                        int paddingRight = view2.getPaddingRight();
                        boolean z2 = bottomSheetBehavior.paddingBottomSystemWindowInsets;
                        if (z2) {
                            int iA = fg1Var.a();
                            bottomSheetBehavior.insetBottom = iA;
                            paddingBottom = iA + relativePadding.bottom;
                        }
                        if (bottomSheetBehavior.paddingLeftSystemWindowInsets) {
                            paddingLeft = (zIsLayoutRtl ? relativePadding.end : relativePadding.start) + fg1Var.b();
                        }
                        if (bottomSheetBehavior.paddingRightSystemWindowInsets) {
                            paddingRight = fg1Var.c() + (zIsLayoutRtl ? relativePadding.start : relativePadding.end);
                        }
                        view2.setPadding(paddingLeft, view2.getPaddingTop(), paddingRight, paddingBottom);
                        boolean z3 = z;
                        if (z3) {
                            bottomSheetBehavior.gestureInsetBottom = fg1Var.a.g().d;
                        }
                        if (!z2 && !z3) {
                            return fg1Var;
                        }
                        bottomSheetBehavior.updatePeekHeight();
                        return fg1Var;
                    }
                });
            }
            this.viewRef = new WeakReference(view);
            if (this.shapeThemingEnabled && (materialShapeDrawable = this.materialShapeDrawable) != null) {
                view.setBackground(materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
            if (materialShapeDrawable2 != null) {
                float elevation = this.elevation;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                materialShapeDrawable2.setElevation(elevation);
                boolean z2 = this.state == 3;
                this.isShapeExpanded = z2;
                this.materialShapeDrawable.setInterpolation(z2 ? 0.0f : 1.0f);
            }
            updateAccessibilityActions();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = new vd1(coordinatorLayout.getContext(), coordinatorLayout, this.dragCallback);
        }
        int top = view.getTop();
        coordinatorLayout.onLayoutChild(view, i);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.childHeight = height;
        int i2 = this.parentHeight;
        int i3 = i2 - height;
        int i4 = this.insetTop;
        if (i3 < i4) {
            if (this.paddingTopSystemWindowInsets) {
                this.childHeight = i2;
            } else {
                this.childHeight = i2 - i4;
            }
        }
        this.fitToContentsOffset = Math.max(0, i2 - this.childHeight);
        this.halfExpandedOffset = (int) ((1.0f - this.halfExpandedRatio) * this.parentHeight);
        calculateCollapsedOffset();
        int i5 = this.state;
        if (i5 == 3) {
            expandedOffset = getExpandedOffset();
        } else if (i5 == 6) {
            expandedOffset = this.halfExpandedOffset;
        } else {
            if (!this.hideable || i5 != 5) {
                if (i5 == 4) {
                    expandedOffset = this.collapsedOffset;
                } else if (i5 == 1 || i5 == 2) {
                    view.offsetTopAndBottom(top - view.getTop());
                }
                this.nestedScrollingChildRef = new WeakReference(findScrollingChild(view));
                return true;
            }
            expandedOffset = this.parentHeight;
        }
        view.offsetTopAndBottom(expandedOffset);
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(view));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, this.maxWidth, marginLayoutParams.width), getChildMeasureSpec(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onNestedPreFling(View view) {
        WeakReference weakReference = this.nestedScrollingChildRef;
        return (weakReference == null || view != weakReference.get() || this.state == 3) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        int i4;
        if (i3 == 1) {
            return;
        }
        WeakReference weakReference = this.nestedScrollingChildRef;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i5 = top - i2;
        boolean z = this.draggable;
        if (i2 > 0) {
            if (i5 < getExpandedOffset()) {
                int expandedOffset = top - getExpandedOffset();
                iArr[1] = expandedOffset;
                int i6 = -expandedOffset;
                WeakHashMap weakHashMap = qd1.a;
                view.offsetTopAndBottom(i6);
                i4 = 3;
                setStateInternal(i4);
            } else {
                if (!z) {
                    return;
                }
                iArr[1] = i2;
                WeakHashMap weakHashMap2 = qd1.a;
                view.offsetTopAndBottom(-i2);
                setStateInternal(1);
            }
        } else if (i2 < 0 && !view2.canScrollVertically(-1)) {
            int i7 = this.collapsedOffset;
            if (i5 > i7 && !this.hideable) {
                int i8 = top - i7;
                iArr[1] = i8;
                int i9 = -i8;
                WeakHashMap weakHashMap3 = qd1.a;
                view.offsetTopAndBottom(i9);
                i4 = 4;
                setStateInternal(i4);
            } else {
                if (!z) {
                    return;
                }
                iArr[1] = i2;
                WeakHashMap weakHashMap4 = qd1.a;
                view.offsetTopAndBottom(-i2);
                setStateInternal(1);
            }
        }
        dispatchOnSlide(view.getTop());
        this.lastNestedScrollDy = i2;
        this.nestedScrolled = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onRestoreInstanceState(View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        int i = this.saveFlags;
        int i2 = 4;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.peekHeight = savedState.peekHeight;
            }
            if (i == -1 || (i & 2) == 2) {
                this.fitToContents = savedState.fitToContents;
            }
            if (i == -1 || (i & 4) == 4) {
                this.hideable = savedState.hideable;
            }
            if (i == -1 || (i & 8) == 8) {
                this.skipCollapsed = savedState.skipCollapsed;
            }
        }
        int i3 = savedState.state;
        if (i3 != 1 && i3 != 2) {
            i2 = i3;
        }
        this.state = i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final Parcelable onSaveInstanceState(View view) {
        return new SavedState((Parcelable) View.BaseSavedState.EMPTY_STATE, (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:32:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:36:0x0072  */
    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x0079  */
    /* JADX WARN: Code duplicated, block: B:41:0x0083  */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:45:0x0098  */
    /* JADX WARN: Code duplicated, block: B:48:0x009d  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b2  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
        int top;
        int i2;
        int expandedOffset;
        int top2;
        int i3;
        float yVelocity;
        int i4 = 3;
        if (view.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view2 == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    expandedOffset = this.fitToContentsOffset;
                } else {
                    int top3 = view.getTop();
                    i2 = this.halfExpandedOffset;
                    if (top3 > i2) {
                        i4 = 6;
                        expandedOffset = i2;
                    } else {
                        expandedOffset = getExpandedOffset();
                    }
                }
            } else if (this.hideable) {
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker == null) {
                    yVelocity = 0.0f;
                } else {
                    velocityTracker.computeCurrentVelocity(InternalZipConstants.AES_HASH_ITERATIONS, this.maximumVelocity);
                    yVelocity = this.velocityTracker.getYVelocity(this.activePointerId);
                }
                if (shouldHide(view, yVelocity)) {
                    expandedOffset = this.parentHeight;
                    i4 = 5;
                } else if (this.lastNestedScrollDy == 0) {
                    top2 = view.getTop();
                    if (this.fitToContents) {
                        i3 = this.halfExpandedOffset;
                        if (top2 < i3) {
                            if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                                expandedOffset = getExpandedOffset();
                            }
                        } else if (Math.abs(top2 - i3) < Math.abs(top2 - this.collapsedOffset)) {
                        }
                        i2 = this.halfExpandedOffset;
                        i4 = 6;
                        expandedOffset = i2;
                    } else if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        expandedOffset = this.fitToContentsOffset;
                    }
                    expandedOffset = this.collapsedOffset;
                    i4 = 4;
                } else {
                    if (!this.fitToContents) {
                        top = view.getTop();
                        if (Math.abs(top - this.halfExpandedOffset) < Math.abs(top - this.collapsedOffset)) {
                            i2 = this.halfExpandedOffset;
                            i4 = 6;
                            expandedOffset = i2;
                        }
                    }
                    expandedOffset = this.collapsedOffset;
                    i4 = 4;
                }
            } else if (this.lastNestedScrollDy == 0) {
                top2 = view.getTop();
                if (this.fitToContents) {
                    i3 = this.halfExpandedOffset;
                    if (top2 < i3) {
                        if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                            expandedOffset = getExpandedOffset();
                        }
                    } else if (Math.abs(top2 - i3) < Math.abs(top2 - this.collapsedOffset)) {
                    }
                    i2 = this.halfExpandedOffset;
                    i4 = 6;
                    expandedOffset = i2;
                } else if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                    expandedOffset = this.fitToContentsOffset;
                }
                expandedOffset = this.collapsedOffset;
                i4 = 4;
            } else {
                if (!this.fitToContents) {
                    top = view.getTop();
                    if (Math.abs(top - this.halfExpandedOffset) < Math.abs(top - this.collapsedOffset)) {
                        i2 = this.halfExpandedOffset;
                        i4 = 6;
                        expandedOffset = i2;
                    }
                }
                expandedOffset = this.collapsedOffset;
                i4 = 4;
            }
            startSettlingAnimation(view, i4, expandedOffset, false);
            this.nestedScrolled = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i = this.state;
        if (i == 1 && actionMasked == 0) {
            return true;
        }
        vd1 vd1Var = this.viewDragHelper;
        if (vd1Var != null && (this.draggable || i == 1)) {
            vd1Var.k(motionEvent);
        }
        if (actionMasked == 0) {
            this.activePointerId = -1;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (this.viewDragHelper != null && ((this.draggable || this.state == 1) && actionMasked == 2 && !this.ignoreEvents)) {
            float fAbs = Math.abs(this.initialY - motionEvent.getY());
            vd1 vd1Var2 = this.viewDragHelper;
            if (fAbs > vd1Var2.b) {
                vd1Var2.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.ignoreEvents;
    }

    public final void setHideable(boolean z) {
        if (this.hideable != z) {
            this.hideable = z;
            if (!z && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public final void setPeekHeight(int i) {
        boolean z = this.peekHeightAuto;
        if (i == -1) {
            if (z) {
                return;
            } else {
                this.peekHeightAuto = true;
            }
        } else {
            if (!z && this.peekHeight == i) {
                return;
            }
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i);
        }
        updatePeekHeight();
    }

    public final void setState(final int i) {
        if (i == this.state) {
            return;
        }
        WeakReference weakReference = this.viewRef;
        if (weakReference == null) {
            if (i == 4 || i == 3 || i == 6 || (this.hideable && i == 5)) {
                this.state = i;
                return;
            }
            return;
        }
        final View view = (View) weakReference.get();
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = qd1.a;
            if (view.isAttachedToWindow()) {
                view.post(new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        BottomSheetBehavior.this.settleToState(view, i);
                    }
                });
                return;
            }
        }
        settleToState(view, i);
    }

    public final void setStateInternal(int i) {
        View view;
        if (this.state == i) {
            return;
        }
        this.state = i;
        WeakReference weakReference = this.viewRef;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i2 = 0;
        if (i == 3) {
            updateImportantForAccessibility(true);
        } else if (i == 6 || i == 5 || i == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i);
        while (true) {
            ArrayList arrayList = this.callbacks;
            if (i2 >= arrayList.size()) {
                updateAccessibilityActions();
                return;
            } else {
                ((BottomSheetCallback) arrayList.get(i2)).onStateChanged(view, i);
                i2++;
            }
        }
    }

    public final void settleToState(View view, int i) {
        int expandedOffset;
        int i2;
        if (i == 4) {
            expandedOffset = this.collapsedOffset;
        } else if (i == 6) {
            expandedOffset = this.halfExpandedOffset;
            if (this.fitToContents && expandedOffset <= (i2 = this.fitToContentsOffset)) {
                i = 3;
                expandedOffset = i2;
            }
        } else if (i == 3) {
            expandedOffset = getExpandedOffset();
        } else if (!this.hideable || i != 5) {
            return;
        } else {
            expandedOffset = this.parentHeight;
        }
        startSettlingAnimation(view, i, expandedOffset, false);
    }

    public final boolean shouldHide(View view, float f) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        return Math.abs(((f * 0.1f) + ((float) view.getTop())) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f;
    }

    public final void startSettlingAnimation(View view, int i, int i2, boolean z) {
        vd1 vd1Var = this.viewDragHelper;
        if (vd1Var == null || (!z ? vd1Var.s(view, view.getLeft(), i2) : vd1Var.q(view.getLeft(), i2))) {
            setStateInternal(i);
            return;
        }
        setStateInternal(2);
        updateDrawableForTargetState(i);
        if (this.settleRunnable == null) {
            this.settleRunnable = new SettleRunnable(view, i);
        }
        SettleRunnable settleRunnable = this.settleRunnable;
        boolean z2 = settleRunnable.isPosted;
        settleRunnable.targetState = i;
        if (z2) {
            return;
        }
        WeakHashMap weakHashMap = qd1.a;
        view.postOnAnimation(settleRunnable);
        this.settleRunnable.isPosted = true;
    }

    public final void updateAccessibilityActions() {
        View view;
        o1.a aVar;
        s1 s1Var;
        int iA;
        WeakReference weakReference = this.viewRef;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        qd1.i(view, 524288);
        qd1.g(view, 0);
        qd1.i(view, 262144);
        qd1.g(view, 0);
        qd1.i(view, 1048576);
        qd1.g(view, 0);
        int i = this.expandHalfwayActionId;
        if (i != -1) {
            qd1.i(view, i);
            qd1.g(view, 0);
        }
        final int i2 = 6;
        if (!this.fitToContents && this.state != 6) {
            String string = view.getResources().getString(R.string.b_);
            s1 s1Var2 = new s1() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
                @Override // defpackage.s1
                public final boolean perform(View view2) {
                    BottomSheetBehavior.this.setState(i2);
                    return true;
                }
            };
            ArrayList arrayListE = qd1.e(view);
            int i3 = 0;
            while (true) {
                if (i3 >= arrayListE.size()) {
                    int i4 = -1;
                    for (int i5 = 0; i5 < 32 && i4 == -1; i5++) {
                        int i6 = qd1.d[i5];
                        boolean z = true;
                        for (int i7 = 0; i7 < arrayListE.size(); i7++) {
                            z &= ((o1.a) arrayListE.get(i7)).a() != i6;
                        }
                        if (z) {
                            i4 = i6;
                        }
                    }
                    iA = i4;
                    break;
                }
                if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((o1.a) arrayListE.get(i3)).a).getLabel())) {
                    iA = ((o1.a) arrayListE.get(i3)).a();
                    break;
                }
                i3++;
            }
            if (iA != -1) {
                o1.a aVar2 = new o1.a(null, iA, string, s1Var2, null);
                View.AccessibilityDelegate accessibilityDelegateD = qd1.d(view);
                a1 a1Var = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof a1.a ? ((a1.a) accessibilityDelegateD).a : new a1(accessibilityDelegateD);
                if (a1Var == null) {
                    a1Var = new a1();
                }
                qd1.l(view, a1Var);
                qd1.i(view, aVar2.a());
                qd1.e(view).add(aVar2);
                qd1.g(view, 0);
            }
            this.expandHalfwayActionId = iA;
        }
        if (this.hideable) {
            final int i8 = 5;
            if (this.state != 5) {
                qd1.j(view, o1.a.l, new s1() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
                    @Override // defpackage.s1
                    public final boolean perform(View view2) {
                        BottomSheetBehavior.this.setState(i8);
                        return true;
                    }
                });
            }
        }
        int i9 = this.state;
        final int i10 = 4;
        final int i11 = 3;
        if (i9 != 3) {
            if (i9 == 4) {
                i2 = this.fitToContents ? 3 : 6;
                aVar = o1.a.j;
            } else {
                if (i9 != 6) {
                    return;
                }
                qd1.j(view, o1.a.k, new s1() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
                    @Override // defpackage.s1
                    public final boolean perform(View view2) {
                        BottomSheetBehavior.this.setState(i10);
                        return true;
                    }
                });
                aVar = o1.a.j;
                s1Var = new s1() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
                    @Override // defpackage.s1
                    public final boolean perform(View view2) {
                        BottomSheetBehavior.this.setState(i11);
                        return true;
                    }
                };
            }
            qd1.j(view, aVar, s1Var);
        }
        i2 = this.fitToContents ? 4 : 6;
        aVar = o1.a.k;
        s1Var = new s1() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
            @Override // defpackage.s1
            public final boolean perform(View view2) {
                BottomSheetBehavior.this.setState(i2);
                return true;
            }
        };
        qd1.j(view, aVar, s1Var);
    }

    public final void updateDrawableForTargetState(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.isShapeExpanded != z) {
            this.isShapeExpanded = z;
            if (this.materialShapeDrawable == null || (valueAnimator = this.interpolatorAnimator) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            }
            float f = z ? 0.0f : 1.0f;
            valueAnimator.setFloatValues(1.0f - f, f);
            valueAnimator.start();
        }
    }

    public final void updateImportantForAccessibility(boolean z) {
        WeakReference weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                } else {
                    this.importantForAccessibilityMap = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.viewRef.get() && z) {
                    this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z) {
                return;
            }
            this.importantForAccessibilityMap = null;
        }
    }

    public final void updatePeekHeight() {
        View view;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state != 4 || (view = (View) this.viewRef.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }
}
