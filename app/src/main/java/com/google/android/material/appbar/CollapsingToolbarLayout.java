package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.b2;
import defpackage.e;
import defpackage.fg1;
import defpackage.lm0;
import defpackage.qd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public final CollapsingTextHelper collapsingTextHelper;
    public final boolean collapsingTitleEnabled;
    public Drawable contentScrim;
    public int currentOffset;
    public boolean drawCollapsingTitle;
    public View dummyView;
    public final int expandedMarginBottom;
    public final int expandedMarginEnd;
    public final int expandedMarginStart;
    public final int expandedMarginTop;
    public int extraMultilineHeight;
    public final boolean extraMultilineHeightEnabled;
    public final boolean forceApplySystemWindowInsetTop;
    public fg1 lastInsets;
    public AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    public boolean refreshToolbar;
    public int scrimAlpha;
    public final long scrimAnimationDuration;
    public ValueAnimator scrimAnimator;
    public final int scrimVisibleHeightTrigger;
    public boolean scrimsAreShown;
    public final Drawable statusBarScrim;
    public final int titleCollapseMode;
    public final Rect tmpRect;
    public ViewGroup toolbar;
    public View toolbarDirectChild;
    public final int toolbarId;
    public int topInsetApplied;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public final int collapseMode;
        public final float parallaxMult;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = typedArrayObtainStyledAttributes.getInt(0, 0);
            this.parallaxMult = typedArrayObtainStyledAttributes.getFloat(1, 0.5f);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        public OffsetUpdateListener() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(int i) {
            int iD;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.currentOffset = i;
            CollapsingTextHelper collapsingTextHelper = collapsingToolbarLayout.collapsingTextHelper;
            fg1 fg1Var = collapsingToolbarLayout.lastInsets;
            int iD2 = fg1Var != null ? fg1Var.d() : 0;
            int childCount = collapsingToolbarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = collapsingToolbarLayout.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                int i3 = layoutParams.collapseMode;
                if (i3 != 1) {
                    if (i3 == 2) {
                        iD = Math.round((-i) * layoutParams.parallaxMult);
                    }
                } else {
                    iD = e.d(-i, 0, ((collapsingToolbarLayout.getHeight() - CollapsingToolbarLayout.getViewOffsetHelper(childAt).layoutTop) - childAt.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).bottomMargin);
                }
                viewOffsetHelper.setTopAndBottomOffset(iD);
            }
            collapsingToolbarLayout.updateScrimVisibility();
            if (collapsingToolbarLayout.statusBarScrim != null && iD2 > 0) {
                WeakHashMap weakHashMap = qd1.a;
                collapsingToolbarLayout.postInvalidateOnAnimation();
            }
            int height = collapsingToolbarLayout.getHeight();
            WeakHashMap weakHashMap2 = qd1.a;
            int minimumHeight = (height - collapsingToolbarLayout.getMinimumHeight()) - iD2;
            float scrimVisibleHeightTrigger = height - collapsingToolbarLayout.getScrimVisibleHeightTrigger();
            float f = minimumHeight;
            float fMin = Math.min(1.0f, scrimVisibleHeightTrigger / f);
            collapsingTextHelper.fadeModeStartFraction = fMin;
            collapsingTextHelper.fadeModeThresholdFraction = e.a(1.0f, fMin, 0.5f, fMin);
            collapsingTextHelper.currentOffsetY = collapsingToolbarLayout.currentOffset + minimumHeight;
            collapsingTextHelper.setExpansionFraction(Math.abs(i) / f);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TitleCollapseMode {
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.fy);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        int i2;
        ColorStateList colorStateList;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.wh), attributeSet, i);
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        this.topInsetApplied = 0;
        this.extraMultilineHeight = 0;
        Context context2 = getContext();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper;
        collapsingTextHelper.textSizeInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
        collapsingTextHelper.recalculate(false);
        collapsingTextHelper.isRtlTextDirectionHeuristicsEnabled = false;
        ElevationOverlayProvider elevationOverlayProvider = new ElevationOverlayProvider(context2);
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.CollapsingToolbarLayout, i, org.hamotunnelplus.xyz.R.plurals.wh, new int[0]);
        int i3 = typedArrayObtainStyledAttributes.getInt(4, 8388691);
        if (collapsingTextHelper.expandedTextGravity != i3) {
            collapsingTextHelper.expandedTextGravity = i3;
            collapsingTextHelper.recalculate(false);
        }
        int i4 = typedArrayObtainStyledAttributes.getInt(0, 8388627);
        if (collapsingTextHelper.collapsedTextGravity != i4) {
            collapsingTextHelper.collapsedTextGravity = i4;
            collapsingTextHelper.recalculate(false);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.expandedMarginBottom = dimensionPixelSize;
        this.expandedMarginEnd = dimensionPixelSize;
        this.expandedMarginTop = dimensionPixelSize;
        this.expandedMarginStart = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes.hasValue(8)) {
            this.expandedMarginStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(7)) {
            this.expandedMarginEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(9)) {
            this.expandedMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.expandedMarginBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(20, true);
        this.collapsingTitleEnabled = z;
        CharSequence text = typedArrayObtainStyledAttributes.getText(18);
        if (text == null || !TextUtils.equals(collapsingTextHelper.text, text)) {
            collapsingTextHelper.text = text;
            collapsingTextHelper.textToDraw = null;
            Bitmap bitmap = collapsingTextHelper.expandedTitleTexture;
            if (bitmap != null) {
                bitmap.recycle();
                collapsingTextHelper.expandedTitleTexture = null;
            }
            collapsingTextHelper.recalculate(false);
        }
        setContentDescription(z ? collapsingTextHelper.text : null);
        collapsingTextHelper.setExpandedTextAppearance(org.hamotunnelplus.xyz.R.plurals.nk);
        collapsingTextHelper.setCollapsedTextAppearance(org.hamotunnelplus.xyz.R.plurals.mv);
        if (typedArrayObtainStyledAttributes.hasValue(10)) {
            collapsingTextHelper.setExpandedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(10, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            collapsingTextHelper.setCollapsedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(1, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(11) && collapsingTextHelper.expandedTextColor != (colorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 11))) {
            collapsingTextHelper.expandedTextColor = colorStateList;
            collapsingTextHelper.recalculate(false);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            collapsingTextHelper.setCollapsedTextColor(MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 2));
        }
        this.scrimVisibleHeightTrigger = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, -1);
        if (typedArrayObtainStyledAttributes.hasValue(14) && (i2 = typedArrayObtainStyledAttributes.getInt(14, 1)) != collapsingTextHelper.maxLines) {
            collapsingTextHelper.maxLines = i2;
            Bitmap bitmap2 = collapsingTextHelper.expandedTitleTexture;
            if (bitmap2 != null) {
                bitmap2.recycle();
                collapsingTextHelper.expandedTitleTexture = null;
            }
            collapsingTextHelper.recalculate(false);
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            collapsingTextHelper.positionInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context2, typedArrayObtainStyledAttributes.getResourceId(21, 0));
            collapsingTextHelper.recalculate(false);
        }
        this.scrimAnimationDuration = typedArrayObtainStyledAttributes.getInt(15, 600);
        setContentScrim(typedArrayObtainStyledAttributes.getDrawable(3));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(17);
        Drawable drawable2 = this.statusBarScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.statusBarScrim = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(getDrawableState());
                }
                WeakHashMap weakHashMap = qd1.a;
                drawableMutate.setLayoutDirection(getLayoutDirection());
                drawableMutate.setVisible(getVisibility() == 0, false);
                drawableMutate.setCallback(this);
                drawableMutate.setAlpha(this.scrimAlpha);
            }
            WeakHashMap weakHashMap2 = qd1.a;
            postInvalidateOnAnimation();
        }
        int i5 = typedArrayObtainStyledAttributes.getInt(19, 0);
        this.titleCollapseMode = i5;
        boolean z2 = i5 == 1;
        collapsingTextHelper.fadeModeEnabled = z2;
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (i5 == 1) {
                appBarLayout.liftOnScroll = false;
            }
        }
        if (z2 && this.contentScrim == null) {
            setContentScrim(new ColorDrawable(elevationOverlayProvider.compositeOverlayIfNeeded(elevationOverlayProvider.colorSurface, getResources().getDimension(org.hamotunnelplus.xyz.R.dimen.c3))));
        }
        this.toolbarId = typedArrayObtainStyledAttributes.getResourceId(22, -1);
        this.forceApplySystemWindowInsetTop = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.extraMultilineHeightEnabled = typedArrayObtainStyledAttributes.getBoolean(12, false);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        lm0 lm0Var = new lm0() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.1
            @Override // defpackage.lm0
            public final fg1 onApplyWindowInsets(View view, fg1 fg1Var) {
                CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
                collapsingToolbarLayout.getClass();
                WeakHashMap weakHashMap3 = qd1.a;
                fg1 fg1Var2 = collapsingToolbarLayout.getFitsSystemWindows() ? fg1Var : null;
                if (!Objects.equals(collapsingToolbarLayout.lastInsets, fg1Var2)) {
                    collapsingToolbarLayout.lastInsets = fg1Var2;
                    collapsingToolbarLayout.requestLayout();
                }
                return fg1Var.a.c();
            }
        };
        WeakHashMap weakHashMap3 = qd1.a;
        b2.u(this, lm0Var);
    }

    public static ViewOffsetHelper getViewOffsetHelper(View view) {
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(org.hamotunnelplus.xyz.R.attr.a35);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(org.hamotunnelplus.xyz.R.attr.a35, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        ensureToolbar();
        if (this.toolbar == null && (drawable = this.contentScrim) != null && this.scrimAlpha > 0) {
            drawable.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
        }
        if (this.collapsingTitleEnabled && this.drawCollapsingTitle) {
            ViewGroup viewGroup = this.toolbar;
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            if (viewGroup == null || this.contentScrim == null || this.scrimAlpha <= 0 || this.titleCollapseMode != 1 || collapsingTextHelper.expandedFraction >= collapsingTextHelper.fadeModeThresholdFraction) {
                collapsingTextHelper.draw(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.contentScrim.getBounds(), Region.Op.DIFFERENCE);
                collapsingTextHelper.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.statusBarScrim == null || this.scrimAlpha <= 0) {
            return;
        }
        fg1 fg1Var = this.lastInsets;
        int iD = fg1Var != null ? fg1Var.d() : 0;
        if (iD > 0) {
            this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), iD - this.currentOffset);
            this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
            this.statusBarScrim.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        View view2;
        Drawable drawable = this.contentScrim;
        if (drawable == null || this.scrimAlpha <= 0 || ((view2 = this.toolbarDirectChild) == null || view2 == this ? view != this.toolbar : view != view2)) {
            z = false;
        } else {
            int width = getWidth();
            int height = getHeight();
            if (this.titleCollapseMode == 1 && view != null && this.collapsingTitleEnabled) {
                height = view.getBottom();
            }
            drawable.setBounds(0, 0, width, height);
            this.contentScrim.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        ColorStateList colorStateList;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarScrim;
        boolean z = false;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper != null) {
            collapsingTextHelper.state = drawableState;
            ColorStateList colorStateList2 = collapsingTextHelper.collapsedTextColor;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = collapsingTextHelper.expandedTextColor) != null && colorStateList.isStateful())) {
                collapsingTextHelper.recalculate(false);
                z = true;
            }
            state |= z;
        }
        if (state) {
            invalidate();
        }
    }

    public final void ensureToolbar() {
        View view;
        View view2;
        if (this.refreshToolbar) {
            ViewGroup viewGroup = null;
            this.toolbar = null;
            this.toolbarDirectChild = null;
            int i = this.toolbarId;
            if (i != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i);
                this.toolbar = viewGroup2;
                if (viewGroup2 != null) {
                    ViewParent parent = viewGroup2.getParent();
                    while (true) {
                        if (parent == this) {
                            view2 = viewGroup2;
                            break;
                        } else {
                            if (parent == null) {
                                break;
                            }
                            if (parent instanceof View) {
                                view2 = (View) parent;
                            }
                            parent = parent.getParent();
                            view2 = view2;
                        }
                    }
                    this.toolbarDirectChild = view2;
                }
            }
            if (this.toolbar == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if ((childAt instanceof Toolbar) || (childAt instanceof android.widget.Toolbar)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                }
                this.toolbar = viewGroup;
            }
            boolean z = this.collapsingTitleEnabled;
            if (!z && (view = this.dummyView) != null) {
                ViewParent parent2 = view.getParent();
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(this.dummyView);
                }
            }
            if (z && this.toolbar != null) {
                if (this.dummyView == null) {
                    this.dummyView = new View(getContext());
                }
                if (this.dummyView.getParent() == null) {
                    this.toolbar.addView(this.dummyView, -1, -1);
                }
            }
            this.refreshToolbar = false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final int getScrimVisibleHeightTrigger() {
        int i = this.scrimVisibleHeightTrigger;
        if (i >= 0) {
            return i + this.topInsetApplied + this.extraMultilineHeight;
        }
        fg1 fg1Var = this.lastInsets;
        int iD = fg1Var != null ? fg1Var.d() : 0;
        WeakHashMap weakHashMap = qd1.a;
        int minimumHeight = getMinimumHeight();
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + iD, getHeight()) : getHeight() / 3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.titleCollapseMode == 1) {
                appBarLayout.liftOnScroll = false;
            }
            WeakHashMap weakHashMap = qd1.a;
            setFitsSystemWindows(appBarLayout.getFitsSystemWindows());
            if (this.onOffsetChangedListener == null) {
                this.onOffsetChangedListener = new OffsetUpdateListener();
            }
            AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.onOffsetChangedListener;
            if (appBarLayout.listeners == null) {
                appBarLayout.listeners = new ArrayList();
            }
            if (onOffsetChangedListener != null && !appBarLayout.listeners.contains(onOffsetChangedListener)) {
                appBarLayout.listeners.add(onOffsetChangedListener);
            }
            requestApplyInsets();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.onOffsetChangedListener;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout) && (arrayList = ((AppBarLayout) parent).listeners) != null) {
            arrayList.remove(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        fg1 fg1Var = this.lastInsets;
        if (fg1Var != null) {
            int iD = fg1Var.d();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                WeakHashMap weakHashMap = qd1.a;
                if (!childAt.getFitsSystemWindows() && childAt.getTop() < iD) {
                    childAt.offsetTopAndBottom(iD);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            ViewOffsetHelper viewOffsetHelper = getViewOffsetHelper(getChildAt(i6));
            View view = viewOffsetHelper.view;
            viewOffsetHelper.layoutTop = view.getTop();
            viewOffsetHelper.layoutLeft = view.getLeft();
        }
        updateTextBounds(false, i, i2, i3, i4);
        updateTitleFromToolbarIfNeeded();
        updateScrimVisibility();
        int childCount3 = getChildCount();
        for (int i7 = 0; i7 < childCount3; i7++) {
            getViewOffsetHelper(getChildAt(i7)).applyOffsets();
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x007f  */
    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        CollapsingToolbarLayout collapsingToolbarLayout;
        int measuredHeight;
        int measuredHeight2;
        ensureToolbar();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        fg1 fg1Var = this.lastInsets;
        int iD = fg1Var != null ? fg1Var.d() : 0;
        if ((mode == 0 || this.forceApplySystemWindowInsetTop) && iD > 0) {
            this.topInsetApplied = iD;
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iD, 1073741824));
        }
        if (this.extraMultilineHeightEnabled) {
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            if (collapsingTextHelper.maxLines > 1) {
                updateTitleFromToolbarIfNeeded();
                collapsingToolbarLayout = this;
                collapsingToolbarLayout.updateTextBounds(true, 0, 0, getMeasuredWidth(), getMeasuredHeight());
                int i3 = collapsingTextHelper.expandedLineCount;
                if (i3 > 1) {
                    TextPaint textPaint = collapsingTextHelper.tmpPaint;
                    textPaint.setTextSize(collapsingTextHelper.expandedTextSize);
                    textPaint.setTypeface(collapsingTextHelper.expandedTypeface);
                    textPaint.setLetterSpacing(collapsingTextHelper.expandedLetterSpacing);
                    collapsingToolbarLayout.extraMultilineHeight = (i3 - 1) * Math.round(textPaint.descent() + (-textPaint.ascent()));
                    super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + collapsingToolbarLayout.extraMultilineHeight, 1073741824));
                }
            } else {
                collapsingToolbarLayout = this;
            }
        } else {
            collapsingToolbarLayout = this;
        }
        ViewGroup viewGroup = collapsingToolbarLayout.toolbar;
        if (viewGroup != null) {
            View view = collapsingToolbarLayout.toolbarDirectChild;
            if (view == null || view == collapsingToolbarLayout) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    measuredHeight = viewGroup.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    measuredHeight = viewGroup.getMeasuredHeight();
                }
                measuredHeight2 = measuredHeight;
            } else {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    measuredHeight2 = view.getMeasuredHeight() + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                } else {
                    measuredHeight2 = view.getMeasuredHeight();
                }
            }
            setMinimumHeight(measuredHeight2);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.contentScrim;
        if (drawable != null) {
            ViewGroup viewGroup = this.toolbar;
            if (this.titleCollapseMode == 1 && viewGroup != null && this.collapsingTitleEnabled) {
                i2 = viewGroup.getBottom();
            }
            drawable.setBounds(0, 0, i, i2);
        }
    }

    public final void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.contentScrim = drawableMutate;
            if (drawableMutate != null) {
                int width = getWidth();
                int height = getHeight();
                ViewGroup viewGroup = this.toolbar;
                if (this.titleCollapseMode == 1 && viewGroup != null && this.collapsingTitleEnabled) {
                    height = viewGroup.getBottom();
                }
                drawableMutate.setBounds(0, 0, width, height);
                this.contentScrim.setCallback(this);
                this.contentScrim.setAlpha(this.scrimAlpha);
            }
            WeakHashMap weakHashMap = qd1.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.statusBarScrim;
        if (drawable != null && drawable.isVisible() != z) {
            this.statusBarScrim.setVisible(z, false);
        }
        Drawable drawable2 = this.contentScrim;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.contentScrim.setVisible(z, false);
    }

    public final void updateScrimVisibility() {
        int i;
        ViewGroup viewGroup;
        if (this.contentScrim == null && this.statusBarScrim == null) {
            return;
        }
        boolean z = getHeight() + this.currentOffset < getScrimVisibleHeightTrigger();
        WeakHashMap weakHashMap = qd1.a;
        boolean z2 = isLaidOut() && !isInEditMode();
        if (this.scrimsAreShown != z) {
            if (z2) {
                i = z ? 255 : 0;
                ensureToolbar();
                ValueAnimator valueAnimator = this.scrimAnimator;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.scrimAnimator = valueAnimator2;
                    valueAnimator2.setInterpolator(i > this.scrimAlpha ? AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR : AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                    this.scrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                            ViewGroup viewGroup2;
                            int iIntValue = ((Integer) valueAnimator3.getAnimatedValue()).intValue();
                            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
                            if (iIntValue != collapsingToolbarLayout.scrimAlpha) {
                                if (collapsingToolbarLayout.contentScrim != null && (viewGroup2 = collapsingToolbarLayout.toolbar) != null) {
                                    WeakHashMap weakHashMap2 = qd1.a;
                                    viewGroup2.postInvalidateOnAnimation();
                                }
                                collapsingToolbarLayout.scrimAlpha = iIntValue;
                                WeakHashMap weakHashMap3 = qd1.a;
                                collapsingToolbarLayout.postInvalidateOnAnimation();
                            }
                        }
                    });
                } else if (valueAnimator.isRunning()) {
                    this.scrimAnimator.cancel();
                }
                this.scrimAnimator.setDuration(this.scrimAnimationDuration);
                this.scrimAnimator.setIntValues(this.scrimAlpha, i);
                this.scrimAnimator.start();
            } else {
                i = z ? 255 : 0;
                if (i != this.scrimAlpha) {
                    if (this.contentScrim != null && (viewGroup = this.toolbar) != null) {
                        viewGroup.postInvalidateOnAnimation();
                    }
                    this.scrimAlpha = i;
                    postInvalidateOnAnimation();
                }
            }
            this.scrimsAreShown = z;
        }
    }

    public final void updateTextBounds(boolean z, int i, int i2, int i3, int i4) {
        View view;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        if (!this.collapsingTitleEnabled || (view = this.dummyView) == null) {
            return;
        }
        WeakHashMap weakHashMap = qd1.a;
        int titleMarginStart = 0;
        boolean z2 = view.isAttachedToWindow() && this.dummyView.getVisibility() == 0;
        this.drawCollapsingTitle = z2;
        if (z2 || z) {
            boolean z3 = getLayoutDirection() == 1;
            View view2 = this.toolbarDirectChild;
            if (view2 == null) {
                view2 = this.toolbar;
            }
            int height = ((getHeight() - getViewOffsetHelper(view2).layoutTop) - view2.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view2.getLayoutParams())).bottomMargin;
            View view3 = this.dummyView;
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, view3, rect);
            ViewGroup viewGroup = this.toolbar;
            if (viewGroup instanceof Toolbar) {
                Toolbar toolbar = (Toolbar) viewGroup;
                titleMarginStart = toolbar.mTitleMarginStart;
                titleMarginEnd = toolbar.mTitleMarginEnd;
                titleMarginTop = toolbar.mTitleMarginTop;
                titleMarginBottom = toolbar.mTitleMarginBottom;
            } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
                titleMarginBottom = 0;
                titleMarginEnd = 0;
                titleMarginTop = 0;
            } else {
                android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                titleMarginStart = toolbar2.getTitleMarginStart();
                titleMarginEnd = toolbar2.getTitleMarginEnd();
                titleMarginTop = toolbar2.getTitleMarginTop();
                titleMarginBottom = toolbar2.getTitleMarginBottom();
            }
            int i5 = rect.left + (z3 ? titleMarginEnd : titleMarginStart);
            int i6 = rect.top + height + titleMarginTop;
            int i7 = rect.right;
            if (!z3) {
                titleMarginStart = titleMarginEnd;
            }
            int i8 = i7 - titleMarginStart;
            int i9 = (rect.bottom + height) - titleMarginBottom;
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            Rect rect2 = collapsingTextHelper.collapsedBounds;
            if (rect2.left != i5 || rect2.top != i6 || rect2.right != i8 || rect2.bottom != i9) {
                rect2.set(i5, i6, i8, i9);
                collapsingTextHelper.boundsChanged = true;
                collapsingTextHelper.onBoundsChanged();
            }
            int i10 = this.expandedMarginStart;
            int i11 = this.expandedMarginEnd;
            int i12 = z3 ? i11 : i10;
            int i13 = rect.top + this.expandedMarginTop;
            int i14 = i3 - i;
            if (!z3) {
                i10 = i11;
            }
            int i15 = i14 - i10;
            int i16 = (i4 - i2) - this.expandedMarginBottom;
            Rect rect3 = collapsingTextHelper.expandedBounds;
            if (rect3.left != i12 || rect3.top != i13 || rect3.right != i15 || rect3.bottom != i16) {
                rect3.set(i12, i13, i15, i16);
                collapsingTextHelper.boundsChanged = true;
                collapsingTextHelper.onBoundsChanged();
            }
            collapsingTextHelper.recalculate(z);
        }
    }

    public final void updateTitleFromToolbarIfNeeded() {
        boolean z;
        CharSequence title;
        if (this.toolbar == null || !(z = this.collapsingTitleEnabled)) {
            return;
        }
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (TextUtils.isEmpty(collapsingTextHelper.text)) {
            ViewGroup viewGroup = this.toolbar;
            if (viewGroup instanceof Toolbar) {
                title = ((Toolbar) viewGroup).mTitleText;
            } else {
                title = viewGroup instanceof android.widget.Toolbar ? ((android.widget.Toolbar) viewGroup).getTitle() : null;
            }
            if (title == null || !TextUtils.equals(collapsingTextHelper.text, title)) {
                collapsingTextHelper.text = title;
                collapsingTextHelper.textToDraw = null;
                Bitmap bitmap = collapsingTextHelper.expandedTitleTexture;
                if (bitmap != null) {
                    bitmap.recycle();
                    collapsingTextHelper.expandedTitleTexture = null;
                }
                collapsingTextHelper.recalculate(false);
            }
            setContentDescription(z ? collapsingTextHelper.text : null);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.contentScrim || drawable == this.statusBarScrim;
    }
}
