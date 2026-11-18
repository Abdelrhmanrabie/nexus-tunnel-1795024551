package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.ha;
import defpackage.qd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements ExpandableTransformationWidget, Shapeable, CoordinatorLayout.b {
    public ColorStateList backgroundTint;
    public PorterDuff.Mode backgroundTintMode;
    public final boolean compatPadding;
    public final int customSize;
    public final ExpandableWidgetHelper expandableWidgetHelper;
    public final ha imageHelper;
    public int imagePadding;
    public FloatingActionButtonImplLollipop impl;
    public final int maxImageSize;
    public final Rect shadowPadding;
    public final int size;
    public final Rect touchArea;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {
        public final boolean autoHideEnabled;
        public Rect tmpRect;

        public BaseBehavior() {
            this.autoHideEnabled = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean getInsetDodgeRect(View view, Rect rect) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            Rect rect2 = floatingActionButton.shadowPadding;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
                return false;
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).a instanceof BottomSheetBehavior : false) {
                updateFabVisibilityForBottomSheet(view2, floatingActionButton);
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                View view2 = (View) dependencies.get(i3);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).a instanceof BottomSheetBehavior : false) && updateFabVisibilityForBottomSheet(view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            Rect rect = floatingActionButton.shadowPadding;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
                int i4 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    WeakHashMap weakHashMap = qd1.a;
                    floatingActionButton.offsetTopAndBottom(i2);
                }
                if (i4 != 0) {
                    WeakHashMap weakHashMap2 = qd1.a;
                    floatingActionButton.offsetLeftAndRight(i4);
                }
            }
            return true;
        }

        public final boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            if (!this.autoHideEnabled || fVar.f != appBarLayout.getId() || floatingActionButton.userSetVisibility != 0) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.hide$1();
                return true;
            }
            floatingActionButton.show(null, false);
            return true;
        }

        public final boolean updateFabVisibilityForBottomSheet(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            if (!this.autoHideEnabled || fVar.f != view.getId() || floatingActionButton.userSetVisibility != 0) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.hide$1();
                return true;
            }
            floatingActionButton.show(null, false);
            return true;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class OnVisibilityChangedListener {
        public void onHidden(FloatingActionButton floatingActionButton) {
        }

        public void onShown() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class ShadowDelegateImpl implements ShadowViewDelegate {
        public ShadowDelegateImpl() {
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public final boolean isCompatPaddingEnabled() {
            return FloatingActionButton.this.compatPadding;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public final void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public final void setShadowPadding(int i, int i2, int i3, int i4) {
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.shadowPadding.set(i, i2, i3, i4);
            int i5 = floatingActionButton.imagePadding;
            floatingActionButton.setPadding(i + i5, i2 + i5, i3 + i5, i5 + i4);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class TransformationCallbackWrapper<T extends FloatingActionButton> implements FloatingActionButtonImpl.InternalTransformationCallback {
        public final TransformationCallback listener;

        public TransformationCallbackWrapper(TransformationCallback<T> transformationCallback) {
            this.listener = transformationCallback;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof TransformationCallbackWrapper) && ((TransformationCallbackWrapper) obj).listener.equals(this.listener);
        }

        public final int hashCode() {
            return this.listener.hashCode();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public final void onScaleChanged() {
            this.listener.onScaleChanged(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public final void onTranslationChanged() {
            this.listener.onTranslationChanged(FloatingActionButton.this);
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.m8);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        Drawable drawable;
        Drawable layerDrawable;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.wi), attributeSet, i);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.FloatingActionButton, i, org.hamotunnelplus.xyz.R.plurals.wi, new int[0]);
        this.backgroundTint = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 1);
        this.backgroundTintMode = ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(2, -1), null);
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 12);
        this.size = typedArrayObtainStyledAttributes.getInt(7, -1);
        this.customSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0);
        float dimension = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(9, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(11, 0.0f);
        this.compatPadding = typedArrayObtainStyledAttributes.getBoolean(16, false);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(org.hamotunnelplus.xyz.R.dimen.md);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, 0);
        this.maxImageSize = dimensionPixelSize3;
        FloatingActionButtonImpl impl = getImpl();
        if (impl.maxImageSize != dimensionPixelSize3) {
            impl.maxImageSize = dimensionPixelSize3;
            float f = impl.imageMatrixScale;
            impl.imageMatrixScale = f;
            Matrix matrix = impl.tmpMatrix;
            impl.calculateImageMatrixFromScale(f, matrix);
            impl.view.setImageMatrix(matrix);
        }
        MotionSpec motionSpecCreateFromAttribute = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, 15);
        MotionSpec motionSpecCreateFromAttribute2 = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, 8);
        ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder(context2, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.wi, ShapeAppearanceModel.PILL).build();
        boolean z = typedArrayObtainStyledAttributes.getBoolean(5, false);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
        ha haVar = new ha(this);
        this.imageHelper = haVar;
        haVar.b(attributeSet, i);
        this.expandableWidgetHelper = new ExpandableWidgetHelper(this);
        getImpl().setShapeAppearance(shapeAppearanceModelBuild);
        FloatingActionButtonImpl impl2 = getImpl();
        ColorStateList colorStateList2 = this.backgroundTint;
        PorterDuff.Mode mode = this.backgroundTintMode;
        FloatingActionButtonImplLollipop floatingActionButtonImplLollipop = (FloatingActionButtonImplLollipop) impl2;
        FloatingActionButton floatingActionButton = floatingActionButtonImplLollipop.view;
        ShapeAppearanceModel shapeAppearanceModel = floatingActionButtonImplLollipop.shapeAppearance;
        shapeAppearanceModel.getClass();
        FloatingActionButtonImplLollipop.AlwaysStatefulMaterialShapeDrawable alwaysStatefulMaterialShapeDrawable = new FloatingActionButtonImplLollipop.AlwaysStatefulMaterialShapeDrawable(shapeAppearanceModel);
        floatingActionButtonImplLollipop.shapeDrawable = alwaysStatefulMaterialShapeDrawable;
        alwaysStatefulMaterialShapeDrawable.setTintList(colorStateList2);
        if (mode != null) {
            floatingActionButtonImplLollipop.shapeDrawable.setTintMode(mode);
        }
        floatingActionButtonImplLollipop.shapeDrawable.initializeElevationOverlay(floatingActionButton.getContext());
        if (dimensionPixelSize > 0) {
            Context context3 = floatingActionButton.getContext();
            ShapeAppearanceModel shapeAppearanceModel2 = floatingActionButtonImplLollipop.shapeAppearance;
            shapeAppearanceModel2.getClass();
            BorderDrawable borderDrawable = new BorderDrawable(shapeAppearanceModel2);
            int color = context3.getColor(org.hamotunnelplus.xyz.R.color.cu);
            int color2 = context3.getColor(org.hamotunnelplus.xyz.R.color.ct);
            int color3 = context3.getColor(org.hamotunnelplus.xyz.R.color.cr);
            int color4 = context3.getColor(org.hamotunnelplus.xyz.R.color.cs);
            borderDrawable.topOuterStrokeColor = color;
            borderDrawable.topInnerStrokeColor = color2;
            borderDrawable.bottomOuterStrokeColor = color3;
            borderDrawable.bottomInnerStrokeColor = color4;
            float f2 = dimensionPixelSize;
            if (borderDrawable.borderWidth != f2) {
                borderDrawable.borderWidth = f2;
                borderDrawable.paint.setStrokeWidth(f2 * 1.3333f);
                borderDrawable.invalidateShader = true;
                borderDrawable.invalidateSelf();
            }
            if (colorStateList2 != null) {
                borderDrawable.currentBorderTintColor = colorStateList2.getColorForState(borderDrawable.getState(), borderDrawable.currentBorderTintColor);
            }
            borderDrawable.borderTint = colorStateList2;
            borderDrawable.invalidateShader = true;
            borderDrawable.invalidateSelf();
            floatingActionButtonImplLollipop.borderDrawable = borderDrawable;
            BorderDrawable borderDrawable2 = floatingActionButtonImplLollipop.borderDrawable;
            borderDrawable2.getClass();
            MaterialShapeDrawable materialShapeDrawable = floatingActionButtonImplLollipop.shapeDrawable;
            materialShapeDrawable.getClass();
            layerDrawable = new LayerDrawable(new Drawable[]{borderDrawable2, materialShapeDrawable});
            drawable = null;
        } else {
            drawable = null;
            floatingActionButtonImplLollipop.borderDrawable = null;
            layerDrawable = floatingActionButtonImplLollipop.shapeDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList), layerDrawable, drawable);
        floatingActionButtonImplLollipop.rippleDrawable = rippleDrawable;
        floatingActionButtonImplLollipop.contentBackground = rippleDrawable;
        getImpl().minTouchTargetSize = dimensionPixelSize2;
        FloatingActionButtonImpl impl3 = getImpl();
        if (impl3.elevation != dimension) {
            impl3.elevation = dimension;
            impl3.onElevationsChanged(dimension, impl3.hoveredFocusedTranslationZ, impl3.pressedTranslationZ);
        }
        FloatingActionButtonImpl impl4 = getImpl();
        if (impl4.hoveredFocusedTranslationZ != dimension2) {
            impl4.hoveredFocusedTranslationZ = dimension2;
            impl4.onElevationsChanged(impl4.elevation, dimension2, impl4.pressedTranslationZ);
        }
        FloatingActionButtonImpl impl5 = getImpl();
        if (impl5.pressedTranslationZ != dimension3) {
            impl5.pressedTranslationZ = dimension3;
            impl5.onElevationsChanged(impl5.elevation, impl5.hoveredFocusedTranslationZ, dimension3);
        }
        getImpl().showMotionSpec = motionSpecCreateFromAttribute;
        getImpl().hideMotionSpec = motionSpecCreateFromAttribute2;
        getImpl().ensureMinTouchTargetSize = z;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.hideListeners == null) {
            impl.hideListeners = new ArrayList();
        }
        impl.hideListeners.add(animatorListener);
    }

    public final void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        FloatingActionButtonImpl impl = getImpl();
        if (impl.showListeners == null) {
            impl.showListeners = new ArrayList();
        }
        impl.showListeners.add(animatorListener);
    }

    public final void addTransformationCallback(TransformationCallback transformationCallback) {
        FloatingActionButtonImpl impl = getImpl();
        TransformationCallbackWrapper transformationCallbackWrapper = new TransformationCallbackWrapper(transformationCallback);
        if (impl.transformationCallbacks == null) {
            impl.transformationCallbacks = new ArrayList();
        }
        impl.transformationCallbacks.add(transformationCallbackWrapper);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        FloatingActionButtonImpl impl = getImpl();
        getDrawableState();
        impl.getClass();
    }

    @Override // android.view.View
    public final ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    public final PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public final CoordinatorLayout.c getBehavior() {
        return new Behavior();
    }

    public final MotionSpec getHideMotionSpec() {
        return getImpl().hideMotionSpec;
    }

    public final FloatingActionButtonImpl getImpl() {
        if (this.impl == null) {
            this.impl = new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
        }
        return this.impl;
    }

    @Override // com.google.android.material.shape.Shapeable
    public final ShapeAppearanceModel getShapeAppearanceModel() {
        ShapeAppearanceModel shapeAppearanceModel = getImpl().shapeAppearance;
        shapeAppearanceModel.getClass();
        return shapeAppearanceModel;
    }

    public final MotionSpec getShowMotionSpec() {
        return getImpl().showMotionSpec;
    }

    public final int getSizeDimension(int i) {
        int i2 = this.customSize;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            return resources.getDimensionPixelSize(i != 1 ? org.hamotunnelplus.xyz.R.dimen.cm : org.hamotunnelplus.xyz.R.dimen.cl);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? getSizeDimension(1) : getSizeDimension(0);
    }

    public final void hide$1() {
        final FloatingActionButtonImpl impl = getImpl();
        FloatingActionButton floatingActionButton = impl.view;
        int visibility = floatingActionButton.getVisibility();
        int i = impl.animState;
        if (visibility == 0) {
            if (i == 1) {
                return;
            }
        } else if (i != 2) {
            return;
        }
        Animator animator = impl.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        FloatingActionButton floatingActionButton2 = impl.view;
        WeakHashMap weakHashMap = qd1.a;
        final boolean z = false;
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            floatingActionButton.internalSetVisibility(4, false);
            return;
        }
        MotionSpec motionSpec = impl.hideMotionSpec;
        AnimatorSet animatorSetCreateAnimator = motionSpec != null ? impl.createAnimator(motionSpec, 0.0f, 0.0f, 0.0f) : impl.createDefaultAnimator(0.0f, 0.4f, 0.4f);
        final FloatingActionButtonImpl.InternalVisibilityChangedListener internalVisibilityChangedListener = null;
        animatorSetCreateAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1
            public boolean cancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator2) {
                this.cancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.animState = 0;
                floatingActionButtonImpl.currentAnimator = null;
                if (this.cancelled) {
                    return;
                }
                FloatingActionButton floatingActionButton3 = floatingActionButtonImpl.view;
                boolean z2 = z;
                floatingActionButton3.internalSetVisibility(z2 ? 8 : 4, z2);
                InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                if (internalVisibilityChangedListener2 != null) {
                    internalVisibilityChangedListener2.onHidden();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.view.internalSetVisibility(0, z);
                floatingActionButtonImpl.animState = 1;
                floatingActionButtonImpl.currentAnimator = animator2;
                this.cancelled = false;
            }
        });
        ArrayList arrayList = impl.hideListeners;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetCreateAnimator.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetCreateAnimator.start();
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public final boolean isExpanded() {
        return this.expandableWidgetHelper.expanded;
    }

    public final boolean isOrWillBeShown$1() {
        FloatingActionButtonImpl impl = getImpl();
        int visibility = impl.view.getVisibility();
        int i = impl.animState;
        if (visibility != 0) {
            if (i != 2) {
                return false;
            }
        } else if (i == 1) {
            return false;
        }
        return true;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().getClass();
    }

    public final void offsetRectWithShadow(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.shadowPadding;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FloatingActionButtonImpl impl = getImpl();
        FloatingActionButton floatingActionButton = impl.view;
        MaterialShapeDrawable materialShapeDrawable = impl.shapeDrawable;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.setParentAbsoluteElevation(floatingActionButton, materialShapeDrawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FloatingActionButtonImpl impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.view.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.preDrawListener;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.preDrawListener = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension(this.size);
        this.imagePadding = (sizeDimension - this.maxImageSize) / 2;
        getImpl().updatePadding();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(sizeDimension, size);
        } else if (mode == 0) {
            size = sizeDimension;
        } else if (mode != 1073741824) {
            throw new IllegalArgumentException();
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            sizeDimension = Math.min(sizeDimension, size2);
        } else if (mode2 != 0) {
            if (mode2 != 1073741824) {
                throw new IllegalArgumentException();
            }
            sizeDimension = size2;
        }
        int iMin = Math.min(size, sizeDimension);
        Rect rect = this.shadowPadding;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.mSuperState);
        Object orDefault = extendableSavedState.extendableStates.getOrDefault("expandableWidgetHelper", null);
        orDefault.getClass();
        Bundle bundle = (Bundle) orDefault;
        ExpandableWidgetHelper expandableWidgetHelper = this.expandableWidgetHelper;
        expandableWidgetHelper.getClass();
        expandableWidgetHelper.expanded = bundle.getBoolean("expanded", false);
        expandableWidgetHelper.expandedComponentIdHint = bundle.getInt("expandedComponentIdHint", 0);
        if (expandableWidgetHelper.expanded) {
            View view = expandableWidgetHelper.widget;
            ViewParent parent = view.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).dispatchDependentViewsChanged(view);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        ExpandableWidgetHelper expandableWidgetHelper = this.expandableWidgetHelper;
        expandableWidgetHelper.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", expandableWidgetHelper.expanded);
        bundle.putInt("expandedComponentIdHint", expandableWidgetHelper.expandedComponentIdHint);
        extendableSavedState.extendableStates.put("expandableWidgetHelper", bundle);
        return extendableSavedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            WeakHashMap weakHashMap = qd1.a;
            if (isLaidOut()) {
                int width = getWidth();
                int height = getHeight();
                Rect rect = this.touchArea;
                rect.set(0, 0, width, height);
                offsetRectWithShadow(rect);
                if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
    }

    @Override // android.view.View
    public final void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            FloatingActionButtonImpl impl = getImpl();
            MaterialShapeDrawable materialShapeDrawable = impl.shapeDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintList(colorStateList);
            }
            BorderDrawable borderDrawable = impl.borderDrawable;
            if (borderDrawable != null) {
                if (colorStateList != null) {
                    borderDrawable.currentBorderTintColor = colorStateList.getColorForState(borderDrawable.getState(), borderDrawable.currentBorderTintColor);
                }
                borderDrawable.borderTint = colorStateList;
                borderDrawable.invalidateShader = true;
                borderDrawable.invalidateSelf();
            }
        }
    }

    @Override // android.view.View
    public final void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            MaterialShapeDrawable materialShapeDrawable = getImpl().shapeDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setTintMode(mode);
            }
        }
    }

    @Override // android.view.View
    public final void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeDrawable materialShapeDrawable = getImpl().shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f);
        }
    }

    public final void setHideMotionSpecResource() {
        getImpl().hideMotionSpec = MotionSpec.createFromResource(getContext(), org.hamotunnelplus.xyz.R.animator.a2);
    }

    @Override // android.widget.ImageView
    public final void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            FloatingActionButtonImpl impl = getImpl();
            float f = impl.imageMatrixScale;
            impl.imageMatrixScale = f;
            Matrix matrix = impl.tmpMatrix;
            impl.calculateImageMatrixFromScale(f, matrix);
            impl.view.setImageMatrix(matrix);
        }
    }

    @Override // android.widget.ImageView
    public final void setImageResource(int i) {
        this.imageHelper.c(i);
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        drawable.clearColorFilter();
    }

    @Override // android.view.View
    public final void setScaleX(float f) {
        super.setScaleX(f);
        ArrayList arrayList = getImpl().transformationCallbacks;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((FloatingActionButtonImpl.InternalTransformationCallback) it.next()).onScaleChanged();
            }
        }
    }

    @Override // android.view.View
    public final void setScaleY(float f) {
        super.setScaleY(f);
        ArrayList arrayList = getImpl().transformationCallbacks;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((FloatingActionButtonImpl.InternalTransformationCallback) it.next()).onScaleChanged();
            }
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().setShapeAppearance(shapeAppearanceModel);
    }

    public final void setShowMotionSpecResource() {
        getImpl().showMotionSpec = MotionSpec.createFromResource(getContext(), org.hamotunnelplus.xyz.R.animator.a3);
    }

    @Override // android.view.View
    public final void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public final void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().onTranslationChanged();
    }

    @Override // android.view.View
    public final void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().onTranslationChanged();
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public final void setVisibility(int i) {
        internalSetVisibility(i, true);
    }

    public final void show(final OnVisibilityChangedListener onVisibilityChangedListener, final boolean z) {
        final FloatingActionButtonImpl impl = getImpl();
        final FloatingActionButtonImpl.InternalVisibilityChangedListener internalVisibilityChangedListener = onVisibilityChangedListener == null ? null : new FloatingActionButtonImpl.InternalVisibilityChangedListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButton.1
            @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
            public final void onHidden() {
                onVisibilityChangedListener.onHidden(FloatingActionButton.this);
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
            public final void onShown() {
                onVisibilityChangedListener.onShown();
            }
        };
        FloatingActionButton floatingActionButton = impl.view;
        Matrix matrix = impl.tmpMatrix;
        int visibility = floatingActionButton.getVisibility();
        int i = impl.animState;
        if (visibility != 0) {
            if (i == 2) {
                return;
            }
        } else if (i != 1) {
            return;
        }
        Animator animator = impl.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        boolean z2 = impl.showMotionSpec == null;
        WeakHashMap weakHashMap = qd1.a;
        if (!(floatingActionButton.isLaidOut() && !floatingActionButton.isInEditMode())) {
            floatingActionButton.internalSetVisibility(0, z);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.imageMatrixScale = 1.0f;
            impl.calculateImageMatrixFromScale(1.0f, matrix);
            floatingActionButton.setImageMatrix(matrix);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onShown();
                return;
            }
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            floatingActionButton.setAlpha(0.0f);
            floatingActionButton.setScaleY(z2 ? 0.4f : 0.0f);
            floatingActionButton.setScaleX(z2 ? 0.4f : 0.0f);
            float f = z2 ? 0.4f : 0.0f;
            impl.imageMatrixScale = f;
            impl.calculateImageMatrixFromScale(f, matrix);
            floatingActionButton.setImageMatrix(matrix);
        }
        MotionSpec motionSpec = impl.showMotionSpec;
        AnimatorSet animatorSetCreateAnimator = motionSpec != null ? impl.createAnimator(motionSpec, 1.0f, 1.0f, 1.0f) : impl.createDefaultAnimator(1.0f, 1.0f, 1.0f);
        animatorSetCreateAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.animState = 0;
                floatingActionButtonImpl.currentAnimator = null;
                InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                if (internalVisibilityChangedListener2 != null) {
                    internalVisibilityChangedListener2.onShown();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.view.internalSetVisibility(0, z);
                floatingActionButtonImpl.animState = 2;
                floatingActionButtonImpl.currentAnimator = animator2;
            }
        });
        ArrayList arrayList = impl.showListeners;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetCreateAnimator.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetCreateAnimator.start();
    }
}
