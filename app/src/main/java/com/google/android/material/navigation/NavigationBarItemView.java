package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.k;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.motion.MotionUtils;
import defpackage.b2;
import defpackage.bj;
import defpackage.e;
import defpackage.o1;
import defpackage.qd1;
import defpackage.qz;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationBarItemView extends FrameLayout implements k.a {
    public static final ActiveIndicatorTransform ACTIVE_INDICATOR_LABELED_TRANSFORM;
    public static final ActiveIndicatorUnlabeledTransform ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public ValueAnimator activeIndicatorAnimator;
    public int activeIndicatorDesiredHeight;
    public int activeIndicatorDesiredWidth;
    public boolean activeIndicatorEnabled;
    public int activeIndicatorMarginHorizontal;
    public float activeIndicatorProgress;
    public boolean activeIndicatorResizeable;
    public ActiveIndicatorTransform activeIndicatorTransform;
    public final View activeIndicatorView;
    public BadgeDrawable badgeDrawable;
    public final ImageView icon;
    public final FrameLayout iconContainer;
    public ColorStateList iconTint;
    public boolean initialized;
    public boolean isShifting;
    public h itemData;
    public int itemPaddingBottom;
    public int itemPaddingTop;
    public final ViewGroup labelGroup;
    public int labelVisibilityMode;
    public final TextView largeLabel;
    public Drawable originalIconDrawable;
    public float scaleDownFactor;
    public float scaleUpFactor;
    public float shiftAmount;
    public final TextView smallLabel;
    public Drawable wrappedIconDrawable;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class ActiveIndicatorTransform {
        private ActiveIndicatorTransform() {
        }

        public float calculateScaleY(float f, float f2) {
            return 1.0f;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        private ActiveIndicatorUnlabeledTransform() {
            super();
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.ActiveIndicatorTransform
        public final float calculateScaleY(float f, float f2) {
            DecelerateInterpolator decelerateInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
            return e.a(1.0f, 0.4f, f, 0.4f);
        }
    }

    static {
        ACTIVE_INDICATOR_LABELED_TRANSFORM = new ActiveIndicatorTransform();
        ACTIVE_INDICATOR_UNLABELED_TRANSFORM = new ActiveIndicatorUnlabeledTransform();
    }

    public NavigationBarItemView(Context context) {
        super(context);
        this.initialized = false;
        this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        this.activeIndicatorProgress = 0.0f;
        this.activeIndicatorEnabled = false;
        this.activeIndicatorDesiredWidth = 0;
        this.activeIndicatorDesiredHeight = 0;
        this.activeIndicatorResizeable = false;
        this.activeIndicatorMarginHorizontal = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.iconContainer = (FrameLayout) findViewById(org.hamotunnelplus.xyz.R.attr.s4);
        this.activeIndicatorView = findViewById(org.hamotunnelplus.xyz.R.attr.s3);
        ImageView imageView = (ImageView) findViewById(org.hamotunnelplus.xyz.R.attr.s5);
        this.icon = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(org.hamotunnelplus.xyz.R.attr.s6);
        this.labelGroup = viewGroup;
        TextView textView = (TextView) findViewById(org.hamotunnelplus.xyz.R.attr.s8);
        this.smallLabel = textView;
        TextView textView2 = (TextView) findViewById(org.hamotunnelplus.xyz.R.attr.s7);
        this.largeLabel = textView2;
        setBackgroundResource(org.hamotunnelplus.xyz.R.drawable.mw);
        this.itemPaddingTop = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.itemPaddingBottom = viewGroup.getPaddingBottom();
        WeakHashMap weakHashMap = qd1.a;
        textView.setImportantForAccessibility(2);
        textView2.setImportantForAccessibility(2);
        setFocusable(true);
        calculateTextScaleFactors(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.navigation.NavigationBarItemView.1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                    if (navigationBarItemView.icon.getVisibility() == 0) {
                        ImageView imageView2 = navigationBarItemView.icon;
                        BadgeDrawable badgeDrawable = navigationBarItemView.badgeDrawable;
                        if (badgeDrawable != null) {
                            Rect rect = new Rect();
                            imageView2.getDrawingRect(rect);
                            badgeDrawable.setBounds(rect);
                            badgeDrawable.updateBadgeCoordinates(imageView2, null);
                        }
                    }
                }
            });
        }
    }

    public static void setViewTopMarginAndGravity(View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    public static void updateViewPaddingBottom(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    public final void calculateTextScaleFactors(float f, float f2) {
        this.shiftAmount = f - f2;
        this.scaleUpFactor = (f2 * 1.0f) / f;
        this.scaleDownFactor = (f * 1.0f) / f2;
    }

    public final View getIconOrContainer() {
        FrameLayout frameLayout = this.iconContainer;
        return frameLayout != null ? frameLayout : this.icon;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final h getItemData() {
        return this.itemData;
    }

    public int getItemDefaultMarginResId() {
        return org.hamotunnelplus.xyz.R.dimen.mr;
    }

    public abstract int getItemLayoutResId();

    @Override // android.view.View
    public final int getSuggestedMinimumHeight() {
        ViewGroup viewGroup = this.labelGroup;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        int minimumHeight = badgeDrawable != null ? badgeDrawable.getMinimumHeight() / 2 : 0;
        return viewGroup.getMeasuredHeight() + this.icon.getMeasuredWidth() + Math.max(minimumHeight, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + minimumHeight + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public final int getSuggestedMinimumWidth() {
        ViewGroup viewGroup = this.labelGroup;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        int measuredWidth = viewGroup.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.badgeDrawable.savedState.horizontalOffsetWithoutText;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(Math.max(minimumWidth, layoutParams2.rightMargin) + this.icon.getMeasuredWidth() + Math.max(minimumWidth, layoutParams2.leftMargin), measuredWidth);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final void initialize(h hVar) {
        this.itemData = hVar;
        hVar.getClass();
        refreshDrawableState();
        setChecked(hVar.isChecked());
        setEnabled(hVar.isEnabled());
        Drawable icon = hVar.getIcon();
        if (icon != this.originalIconDrawable) {
            this.originalIconDrawable = icon;
            if (icon != null) {
                Drawable.ConstantState constantState = icon.getConstantState();
                if (constantState != null) {
                    icon = constantState.newDrawable();
                }
                icon = icon.mutate();
                this.wrappedIconDrawable = icon;
                ColorStateList colorStateList = this.iconTint;
                if (colorStateList != null) {
                    icon.setTintList(colorStateList);
                }
            }
            this.icon.setImageDrawable(icon);
        }
        CharSequence charSequence = hVar.e;
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        h hVar2 = this.itemData;
        if (hVar2 == null || TextUtils.isEmpty(hVar2.q)) {
            setContentDescription(charSequence);
        }
        h hVar3 = this.itemData;
        if (hVar3 != null && !TextUtils.isEmpty(hVar3.r)) {
            charSequence = this.itemData.r;
        }
        int i = Build.VERSION.SDK_INT;
        if (i > 23) {
            b2.a(charSequence, this);
        }
        setId(hVar.a);
        if (!TextUtils.isEmpty(hVar.q)) {
            setContentDescription(hVar.q);
        }
        CharSequence charSequence2 = !TextUtils.isEmpty(hVar.r) ? hVar.r : hVar.e;
        if (i > 23) {
            b2.a(charSequence2, this);
        }
        setVisibility(hVar.isVisible() ? 0 : 8);
        this.initialized = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        h hVar = this.itemData;
        if (hVar != null && hVar.isCheckable() && this.itemData.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007e  */
    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        String quantityString;
        Context context;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            h hVar = this.itemData;
            CharSequence charSequence = hVar.e;
            if (!TextUtils.isEmpty(hVar.q)) {
                charSequence = this.itemData.q;
            }
            StringBuilder sb = new StringBuilder();
            sb.append((Object) charSequence);
            sb.append(", ");
            BadgeDrawable badgeDrawable2 = this.badgeDrawable;
            BadgeDrawable.SavedState savedState = badgeDrawable2.savedState;
            if (!badgeDrawable2.isVisible()) {
                quantityString = null;
            } else if (!badgeDrawable2.hasNumber()) {
                quantityString = savedState.contentDescriptionNumberless;
            } else if (savedState.contentDescriptionQuantityStrings <= 0 || (context = (Context) badgeDrawable2.contextRef.get()) == null) {
                quantityString = null;
            } else {
                int number = badgeDrawable2.getNumber();
                int i = badgeDrawable2.maxBadgeNumber;
                quantityString = number <= i ? context.getResources().getQuantityString(savedState.contentDescriptionQuantityStrings, badgeDrawable2.getNumber(), Integer.valueOf(badgeDrawable2.getNumber())) : context.getString(savedState.contentDescriptionExceedsMaxBadgeNumberRes, Integer.valueOf(i));
            }
            sb.append((Object) quantityString);
            accessibilityNodeInfo.setContentDescription(sb.toString());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i2 = 0;
        for (int i3 = 0; i3 < iIndexOfChild; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i2++;
            }
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) qz.a(isSelected(), 0, 1, i2, 1).a);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) o1.a.g.a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(org.hamotunnelplus.xyz.R.string.fy));
    }

    @Override // android.view.View
    public final void onSizeChanged(final int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new Runnable() { // from class: com.google.android.material.navigation.NavigationBarItemView.2
            @Override // java.lang.Runnable
            public final void run() {
                ActiveIndicatorTransform activeIndicatorTransform = NavigationBarItemView.ACTIVE_INDICATOR_LABELED_TRANSFORM;
                NavigationBarItemView.this.updateActiveIndicatorLayoutParams(i);
            }
        });
    }

    public final void setActiveIndicatorProgress(float f, float f2) {
        View view = this.activeIndicatorView;
        if (view != null) {
            ActiveIndicatorTransform activeIndicatorTransform = this.activeIndicatorTransform;
            activeIndicatorTransform.getClass();
            DecelerateInterpolator decelerateInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
            view.setScaleX(e.a(1.0f, 0.4f, f, 0.4f));
            view.setScaleY(activeIndicatorTransform.calculateScaleY(f, f2));
            view.setAlpha(AnimationUtils.lerp(0.0f, 1.0f, f2 == 0.0f ? 0.8f : 0.0f, f2 == 0.0f ? 1.0f : 0.2f, f));
        }
        this.activeIndicatorProgress = f;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0095  */
    /* JADX WARN: Code duplicated, block: B:35:0x00dc A[PHI: r2 r3
      0x00dc: PHI (r2v4 android.view.View) = (r2v3 android.view.View), (r2v10 android.view.View) binds: [B:34:0x00da, B:29:0x00cd] A[DONT_GENERATE, DONT_INLINE]
      0x00dc: PHI (r3v7 int) = (r3v6 int), (r3v9 int) binds: [B:34:0x00da, B:29:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x00e8 A[PHI: r2 r3
      0x00e8: PHI (r2v6 android.view.View) = (r2v3 android.view.View), (r2v10 android.view.View) binds: [B:34:0x00da, B:29:0x00cd] A[DONT_GENERATE, DONT_INLINE]
      0x00e8: PHI (r3v8 int) = (r3v6 int), (r3v9 int) binds: [B:34:0x00da, B:29:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:41:0x011c  */
    public final void setChecked(boolean z) {
        View iconOrContainer;
        int i;
        TextView textView = this.largeLabel;
        textView.setPivotX(textView.getWidth() / 2);
        textView.setPivotY(textView.getBaseline());
        TextView textView2 = this.smallLabel;
        textView2.setPivotX(textView2.getWidth() / 2);
        textView2.setPivotY(textView2.getBaseline());
        final float f = z ? 1.0f : 0.0f;
        if (this.activeIndicatorEnabled && this.initialized) {
            WeakHashMap weakHashMap = qd1.a;
            if (isAttachedToWindow()) {
                ValueAnimator valueAnimator = this.activeIndicatorAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.activeIndicatorAnimator = null;
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.activeIndicatorProgress, f);
                this.activeIndicatorAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.navigation.NavigationBarItemView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                        ActiveIndicatorTransform activeIndicatorTransform = NavigationBarItemView.ACTIVE_INDICATOR_LABELED_TRANSFORM;
                        NavigationBarItemView.this.setActiveIndicatorProgress(fFloatValue, f);
                    }
                });
                this.activeIndicatorAnimator.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), org.hamotunnelplus.xyz.R.style.uq, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
                this.activeIndicatorAnimator.setDuration(MotionUtils.resolveThemeDuration(getContext(), org.hamotunnelplus.xyz.R.style.ug, getResources().getInteger(org.hamotunnelplus.xyz.R.integer.a3)));
                this.activeIndicatorAnimator.start();
            } else {
                setActiveIndicatorProgress(f, f);
            }
        } else {
            setActiveIndicatorProgress(f, f);
        }
        int i2 = this.labelVisibilityMode;
        ViewGroup viewGroup = this.labelGroup;
        if (i2 != -1) {
            if (i2 == 0) {
                iconOrContainer = getIconOrContainer();
                i = this.itemPaddingTop;
                if (z) {
                    setViewTopMarginAndGravity(iconOrContainer, i, 49);
                    updateViewPaddingBottom(viewGroup, this.itemPaddingBottom);
                    textView.setVisibility(0);
                } else {
                    setViewTopMarginAndGravity(iconOrContainer, i, 17);
                    updateViewPaddingBottom(viewGroup, 0);
                    textView.setVisibility(4);
                }
                textView2.setVisibility(4);
            } else if (i2 == 1) {
                updateViewPaddingBottom(viewGroup, this.itemPaddingBottom);
                if (z) {
                    setViewTopMarginAndGravity(getIconOrContainer(), (int) (this.itemPaddingTop + this.shiftAmount), 49);
                    textView.setScaleX(1.0f);
                    textView.setScaleY(1.0f);
                    textView.setVisibility(0);
                    float f2 = this.scaleUpFactor;
                    textView2.setScaleX(f2);
                    textView2.setScaleY(f2);
                    textView2.setVisibility(4);
                } else {
                    setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
                    float f3 = this.scaleDownFactor;
                    textView.setScaleX(f3);
                    textView.setScaleY(f3);
                    textView.setVisibility(4);
                    textView2.setScaleX(1.0f);
                    textView2.setScaleY(1.0f);
                    textView2.setVisibility(0);
                }
            } else if (i2 == 2) {
                setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 17);
                textView.setVisibility(8);
                textView2.setVisibility(8);
            }
        } else if (this.isShifting) {
            iconOrContainer = getIconOrContainer();
            i = this.itemPaddingTop;
            if (z) {
                setViewTopMarginAndGravity(iconOrContainer, i, 49);
                updateViewPaddingBottom(viewGroup, this.itemPaddingBottom);
                textView.setVisibility(0);
            } else {
                setViewTopMarginAndGravity(iconOrContainer, i, 17);
                updateViewPaddingBottom(viewGroup, 0);
                textView.setVisibility(4);
            }
            textView2.setVisibility(4);
        } else {
            updateViewPaddingBottom(viewGroup, this.itemPaddingBottom);
            if (z) {
                setViewTopMarginAndGravity(getIconOrContainer(), (int) (this.itemPaddingTop + this.shiftAmount), 49);
                textView.setScaleX(1.0f);
                textView.setScaleY(1.0f);
                textView.setVisibility(0);
                float f4 = this.scaleUpFactor;
                textView2.setScaleX(f4);
                textView2.setScaleY(f4);
                textView2.setVisibility(4);
            } else {
                setViewTopMarginAndGravity(getIconOrContainer(), this.itemPaddingTop, 49);
                float f5 = this.scaleDownFactor;
                textView.setScaleX(f5);
                textView.setScaleY(f5);
                textView.setVisibility(4);
                textView2.setScaleX(1.0f);
                textView2.setScaleY(1.0f);
                textView2.setVisibility(0);
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public final void setEnabled(boolean z) {
        bj bjVar;
        super.setEnabled(z);
        this.smallLabel.setEnabled(z);
        this.largeLabel.setEnabled(z);
        this.icon.setEnabled(z);
        PointerIcon pointerIcon = null;
        if (z) {
            int i = 15;
            bjVar = Build.VERSION.SDK_INT >= 24 ? new bj(i, PointerIcon.getSystemIcon(getContext(), 1002)) : new bj(i, pointerIcon);
        } else {
            bjVar = null;
        }
        WeakHashMap weakHashMap = qd1.a;
        if (Build.VERSION.SDK_INT >= 24) {
            setPointerIcon(bjVar != null ? (PointerIcon) bjVar.a : null);
        }
    }

    public final void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        WeakHashMap weakHashMap = qd1.a;
        setBackground(drawable);
    }

    public final void setLabelVisibilityMode(int i) {
        if (this.labelVisibilityMode != i) {
            this.labelVisibilityMode = i;
            this.activeIndicatorTransform = (this.activeIndicatorResizeable && i == 2) ? ACTIVE_INDICATOR_UNLABELED_TRANSFORM : ACTIVE_INDICATOR_LABELED_TRANSFORM;
            updateActiveIndicatorLayoutParams(getWidth());
            h hVar = this.itemData;
            if (hVar != null) {
                setChecked(hVar.isChecked());
            }
        }
    }

    public final void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    public final void updateActiveIndicatorLayoutParams(int i) {
        View view = this.activeIndicatorView;
        if (view == null) {
            return;
        }
        int iMin = Math.min(this.activeIndicatorDesiredWidth, i - (this.activeIndicatorMarginHorizontal * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = (this.activeIndicatorResizeable && this.labelVisibilityMode == 2) ? iMin : this.activeIndicatorDesiredHeight;
        layoutParams.width = iMin;
        view.setLayoutParams(layoutParams);
    }
}
