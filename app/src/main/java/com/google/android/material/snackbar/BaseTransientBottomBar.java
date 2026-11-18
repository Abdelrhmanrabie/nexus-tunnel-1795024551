package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.a1;
import defpackage.b2;
import defpackage.d;
import defpackage.fg1;
import defpackage.lm0;
import defpackage.o1;
import defpackage.qd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int[] SNACKBAR_STYLE_ATTR = {R.style.a0o};
    public static final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
            int i = message.what;
            if (i == 0) {
                final BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                SnackbarBaseLayout snackbarBaseLayout = baseTransientBottomBar.view;
                snackbarBaseLayout.onAttachStateChangeListener = new AnonymousClass6();
                if (snackbarBaseLayout.getParent() == null) {
                    ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.f) {
                        CoordinatorLayout.f fVar = (CoordinatorLayout.f) layoutParams;
                        Behavior behavior = new Behavior();
                        BehaviorDelegate behaviorDelegate = behavior.delegate;
                        behaviorDelegate.getClass();
                        behaviorDelegate.managerCallback = baseTransientBottomBar.managerCallback;
                        behavior.listener = new SwipeDismissBehavior.OnDismissListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
                            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
                            public final void onDismiss(View view) {
                                if (view.getParent() != null) {
                                    view.setVisibility(8);
                                }
                                BaseTransientBottomBar.this.dispatchDismiss(0);
                            }

                            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
                            public final void onDragStateChanged(int i2) {
                                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                                if (i2 == 0) {
                                    SnackbarManager.getInstance().restoreTimeoutIfPaused(baseTransientBottomBar2.managerCallback);
                                } else if (i2 == 1 || i2 == 2) {
                                    SnackbarManager.getInstance().pauseTimeout(baseTransientBottomBar2.managerCallback);
                                }
                            }
                        };
                        fVar.b(behavior);
                        fVar.g = 80;
                    }
                    baseTransientBottomBar.updateMargins();
                    snackbarBaseLayout.setVisibility(4);
                    baseTransientBottomBar.targetParent.addView(snackbarBaseLayout);
                }
                WeakHashMap weakHashMap = qd1.a;
                if (snackbarBaseLayout.isLaidOut()) {
                    baseTransientBottomBar.showViewImpl();
                    return true;
                }
                snackbarBaseLayout.onLayoutChangeListener = new AnonymousClass7();
                return true;
            }
            if (i != 1) {
                return false;
            }
            final BaseTransientBottomBar baseTransientBottomBar2 = (BaseTransientBottomBar) message.obj;
            int i2 = message.arg1;
            SnackbarBaseLayout snackbarBaseLayout2 = baseTransientBottomBar2.view;
            AccessibilityManager accessibilityManager = baseTransientBottomBar2.accessibilityManager;
            if ((accessibilityManager != null && ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) == null || !enabledAccessibilityServiceList.isEmpty())) || snackbarBaseLayout2.getVisibility() != 0) {
                baseTransientBottomBar2.onViewHidden();
                return true;
            }
            if (snackbarBaseLayout2.animationMode == 1) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                valueAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
                valueAnimatorOfFloat.addUpdateListener(new AnonymousClass12());
                valueAnimatorOfFloat.setDuration(75L);
                valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter(i2) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.11
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        BaseTransientBottomBar.this.onViewHidden();
                    }
                });
                valueAnimatorOfFloat.start();
                return true;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            SnackbarBaseLayout snackbarBaseLayout3 = baseTransientBottomBar2.view;
            int height = snackbarBaseLayout3.getHeight();
            ViewGroup.LayoutParams layoutParams2 = snackbarBaseLayout3.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                height += ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
            }
            valueAnimator.setIntValues(0, height);
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new AnimatorListenerAdapter(i2) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.16
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    BaseTransientBottomBar.this.onViewHidden();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    BaseTransientBottomBar.this.contentViewCallback.animateContentOut();
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.17
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                    int[] iArr = BaseTransientBottomBar.SNACKBAR_STYLE_ATTR;
                    BaseTransientBottomBar.this.view.setTranslationY(iIntValue);
                }
            });
            valueAnimator.start();
            return true;
        }
    });
    public final AccessibilityManager accessibilityManager;
    public final Runnable bottomMarginGestureInsetRunnable;
    public final com.google.android.material.snackbar.ContentViewCallback contentViewCallback;
    public final Context context;
    public int duration;
    public int extraBottomMarginGestureInset;
    public int extraBottomMarginWindowInset;
    public int extraLeftMarginWindowInset;
    public int extraRightMarginWindowInset;
    public final AnonymousClass5 managerCallback;
    public final Rect originalMargins;
    public final ViewGroup targetParent;
    public final SnackbarBaseLayout view;

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$12, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    class AnonymousClass12 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass12() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$6, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    class AnonymousClass6 implements OnAttachStateChangeListener {
        public AnonymousClass6() {
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$7, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    class AnonymousClass7 implements OnLayoutChangeListener {
        public AnonymousClass7() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Anchor implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        public final WeakReference anchorView;
        public final WeakReference transientBottomBar;

        private Anchor(BaseTransientBottomBar baseTransientBottomBar, View view) {
            this.transientBottomBar = new WeakReference(baseTransientBottomBar);
            this.anchorView = new WeakReference(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (unanchorIfNoTransientBottomBar()) {
                return;
            }
            BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) this.transientBottomBar.get();
            int[] iArr = BaseTransientBottomBar.SNACKBAR_STYLE_ATTR;
            baseTransientBottomBar.getClass();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            if (unanchorIfNoTransientBottomBar() || view == null) {
                return;
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            if (unanchorIfNoTransientBottomBar() || view == null) {
                return;
            }
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public final boolean unanchorIfNoTransientBottomBar() {
            WeakReference weakReference = this.transientBottomBar;
            if (weakReference.get() != null) {
                return false;
            }
            WeakReference weakReference2 = this.anchorView;
            if (weakReference2.get() != null) {
                ((View) weakReference2.get()).removeOnAttachStateChangeListener(this);
                View view = (View) weakReference2.get();
                if (view != null) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
            weakReference2.clear();
            weakReference.clear();
            return true;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationMode {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class BaseCallback<B> {

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        @Retention(RetentionPolicy.SOURCE)
        public @interface DismissEvent {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Behavior extends SwipeDismissBehavior<View> {
        public final BehaviorDelegate delegate = new BehaviorDelegate(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public final boolean canSwipeDismissView(View view) {
            this.delegate.getClass();
            return view instanceof SnackbarBaseLayout;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            BehaviorDelegate behaviorDelegate = this.delegate;
            behaviorDelegate.getClass();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    SnackbarManager.getInstance().restoreTimeoutIfPaused(behaviorDelegate.managerCallback);
                }
            } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                SnackbarManager.getInstance().pauseTimeout(behaviorDelegate.managerCallback);
            }
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class BehaviorDelegate {
        public SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.getClass();
            swipeDismissBehavior.alphaStartSwipeDistance = Math.min(Math.max(0.0f, 0.1f), 1.0f);
            swipeDismissBehavior.alphaEndSwipeDistance = Math.min(Math.max(0.0f, 0.6f), 1.0f);
            swipeDismissBehavior.swipeDirection = 0;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnAttachStateChangeListener {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnLayoutChangeListener {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SnackbarBaseLayout extends FrameLayout {
        public static final View.OnTouchListener consumeAllTouchListener = new View.OnTouchListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        public final float actionTextColorAlpha;
        public final int animationMode;
        public ColorStateList backgroundTint;
        public PorterDuff.Mode backgroundTintMode;
        public final int maxInlineActionWidth;
        public final int maxWidth;
        public OnAttachStateChangeListener onAttachStateChangeListener;
        public OnLayoutChangeListener onLayoutChangeListener;

        public SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        public SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(MaterialThemeOverlay.wrap(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(6)) {
                float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
                WeakHashMap weakHashMap = qd1.a;
                setElevation(dimensionPixelSize);
            }
            this.animationMode = typedArrayObtainStyledAttributes.getInt(2, 0);
            float f = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
            setBackgroundTintList(MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 4));
            setBackgroundTintMode(ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
            this.maxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
            this.maxInlineActionWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() == null) {
                float dimension = getResources().getDimension(R.dimen.ny);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                gradientDrawable.setColor(MaterialColors.layer(MaterialColors.getColor(this, R.style.gx), MaterialColors.getColor(this, R.style.gh), f));
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    gradientDrawable.setTintList(colorStateList);
                }
                WeakHashMap weakHashMap2 = qd1.a;
                setBackgroundDrawable(gradientDrawable);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            WindowInsets rootWindowInsets;
            super.onAttachedToWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener != null) {
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = baseTransientBottomBar.view.getRootWindowInsets()) != null) {
                    baseTransientBottomBar.extraBottomMarginGestureInset = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                    baseTransientBottomBar.updateMargins();
                }
            }
            WeakHashMap weakHashMap = qd1.a;
            requestApplyInsets();
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onDetachedFromWindow() {
            boolean z;
            SnackbarManager.SnackbarRecord snackbarRecord;
            super.onDetachedFromWindow();
            OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
            if (onAttachStateChangeListener != null) {
                final AnonymousClass6 anonymousClass6 = (AnonymousClass6) onAttachStateChangeListener;
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                baseTransientBottomBar.getClass();
                SnackbarManager snackbarManager = SnackbarManager.getInstance();
                AnonymousClass5 anonymousClass5 = baseTransientBottomBar.managerCallback;
                synchronized (snackbarManager.lock) {
                    try {
                        z = snackbarManager.isCurrentSnackbarLocked(anonymousClass5) || !((snackbarRecord = snackbarManager.nextSnackbar) == null || anonymousClass5 == null || snackbarRecord.callback.get() != anonymousClass5);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z) {
                    BaseTransientBottomBar.handler.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BaseTransientBottomBar.this.onViewHidden();
                        }
                    });
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
            if (onLayoutChangeListener != null) {
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                baseTransientBottomBar.view.onLayoutChangeListener = null;
                baseTransientBottomBar.showViewImpl();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int i3 = this.maxWidth;
            if (i3 <= 0 || getMeasuredWidth() <= i3) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
        }

        @Override // android.view.View
        public final void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public final void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.backgroundTint != null) {
                drawable = drawable.mutate();
                drawable.setTintList(this.backgroundTint);
                drawable.setTintMode(this.backgroundTintMode);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public final void setBackgroundTintList(ColorStateList colorStateList) {
            this.backgroundTint = colorStateList;
            if (getBackground() != null) {
                Drawable drawableMutate = getBackground().mutate();
                drawableMutate.setTintList(colorStateList);
                drawableMutate.setTintMode(this.backgroundTintMode);
                if (drawableMutate != getBackground()) {
                    super.setBackgroundDrawable(drawableMutate);
                }
            }
        }

        @Override // android.view.View
        public final void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.backgroundTintMode = mode;
            if (getBackground() != null) {
                Drawable drawableMutate = getBackground().mutate();
                drawableMutate.setTintMode(mode);
                if (drawableMutate != getBackground()) {
                    super.setBackgroundDrawable(drawableMutate);
                }
            }
        }

        @Override // android.view.View
        public final void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : consumeAllTouchListener);
            super.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.material.snackbar.BaseTransientBottomBar$5] */
    public BaseTransientBottomBar(Context context, ViewGroup viewGroup, View view, com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        this.bottomMarginGestureInsetRunnable = new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
            @Override // java.lang.Runnable
            public final void run() {
                Context context2;
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                if (baseTransientBottomBar.view == null || (context2 = baseTransientBottomBar.context) == null) {
                    return;
                }
                WindowManager windowManager = (WindowManager) context2.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                int i = displayMetrics.heightPixels;
                int[] iArr = new int[2];
                SnackbarBaseLayout snackbarBaseLayout = baseTransientBottomBar.view;
                snackbarBaseLayout.getLocationOnScreen(iArr);
                int height = (i - (snackbarBaseLayout.getHeight() + iArr[1])) + ((int) baseTransientBottomBar.view.getTranslationY());
                if (height >= baseTransientBottomBar.extraBottomMarginGestureInset) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = baseTransientBottomBar.view.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    int[] iArr2 = BaseTransientBottomBar.SNACKBAR_STYLE_ATTR;
                    return;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = (baseTransientBottomBar.extraBottomMarginGestureInset - height) + marginLayoutParams.bottomMargin;
                baseTransientBottomBar.view.requestLayout();
            }
        };
        this.managerCallback = new SnackbarManager.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5
            @Override // com.google.android.material.snackbar.SnackbarManager.Callback
            public final void dismiss(int i) {
                Handler handler2 = BaseTransientBottomBar.handler;
                handler2.sendMessage(handler2.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
            }

            @Override // com.google.android.material.snackbar.SnackbarManager.Callback
            public final void show() {
                Handler handler2 = BaseTransientBottomBar.handler;
                handler2.sendMessage(handler2.obtainMessage(0, BaseTransientBottomBar.this));
            }
        };
        if (viewGroup == null) {
            d.AnonymousClass0.m$2("Transient bottom bar must have non-null parent");
            throw null;
        }
        if (view == null) {
            d.AnonymousClass0.m$2("Transient bottom bar must have non-null content");
            throw null;
        }
        if (contentViewCallback == null) {
            d.AnonymousClass0.m$2("Transient bottom bar must have non-null callback");
            throw null;
        }
        this.targetParent = viewGroup;
        this.contentViewCallback = contentViewCallback;
        this.context = context;
        ThemeEnforcement.checkTheme(context, ThemeEnforcement.APPCOMPAT_CHECK_ATTRS, "Theme.AppCompat");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) layoutInflaterFrom.inflate(resourceId != -1 ? R.layout.dn : R.layout.bd, viewGroup, false);
        this.view = snackbarBaseLayout;
        if (view instanceof SnackbarContentLayout) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
            float f = snackbarBaseLayout.actionTextColorAlpha;
            if (f != 1.0f) {
                snackbarContentLayout.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(snackbarContentLayout, R.style.gx), snackbarContentLayout.actionView.getCurrentTextColor(), f));
            }
            snackbarContentLayout.maxInlineActionWidth = snackbarBaseLayout.maxInlineActionWidth;
        }
        snackbarBaseLayout.addView(view);
        ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.originalMargins = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        WeakHashMap weakHashMap = qd1.a;
        snackbarBaseLayout.setAccessibilityLiveRegion(1);
        snackbarBaseLayout.setImportantForAccessibility(1);
        snackbarBaseLayout.setFitsSystemWindows(true);
        b2.u(snackbarBaseLayout, new lm0() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.3
            @Override // defpackage.lm0
            public final fg1 onApplyWindowInsets(View view2, fg1 fg1Var) {
                int iA = fg1Var.a();
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                baseTransientBottomBar.extraBottomMarginWindowInset = iA;
                baseTransientBottomBar.extraLeftMarginWindowInset = fg1Var.b();
                baseTransientBottomBar.extraRightMarginWindowInset = fg1Var.c();
                baseTransientBottomBar.updateMargins();
                return fg1Var;
            }
        });
        qd1.l(snackbarBaseLayout, new a1() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.4
            @Override // defpackage.a1
            public final void onInitializeAccessibilityNodeInfo(View view2, o1 o1Var) {
                AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
                this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                o1Var.a(1048576);
                accessibilityNodeInfo.setDismissable(true);
            }

            @Override // defpackage.a1
            public final boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
                if (i != 1048576) {
                    return super.performAccessibilityAction(view2, i, bundle);
                }
                BaseTransientBottomBar.this.dismiss();
                return true;
            }
        });
        this.accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
    }

    public BaseTransientBottomBar(ViewGroup viewGroup, View view, com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        this(viewGroup.getContext(), viewGroup, view, contentViewCallback);
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    public final void dispatchDismiss(int i) {
        SnackbarManager.SnackbarRecord snackbarRecord;
        SnackbarManager snackbarManager = SnackbarManager.getInstance();
        AnonymousClass5 anonymousClass5 = this.managerCallback;
        synchronized (snackbarManager.lock) {
            try {
                if (snackbarManager.isCurrentSnackbarLocked(anonymousClass5)) {
                    snackbarRecord = snackbarManager.currentSnackbar;
                } else {
                    SnackbarManager.SnackbarRecord snackbarRecord2 = snackbarManager.nextSnackbar;
                    if (snackbarRecord2 != null && anonymousClass5 != null && snackbarRecord2.callback.get() == anonymousClass5) {
                        snackbarRecord = snackbarManager.nextSnackbar;
                    }
                }
                snackbarManager.cancelSnackbarLocked(snackbarRecord, i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onViewHidden() {
        SnackbarManager snackbarManager = SnackbarManager.getInstance();
        AnonymousClass5 anonymousClass5 = this.managerCallback;
        synchronized (snackbarManager.lock) {
            try {
                if (snackbarManager.isCurrentSnackbarLocked(anonymousClass5)) {
                    snackbarManager.currentSnackbar = null;
                    SnackbarManager.SnackbarRecord snackbarRecord = snackbarManager.nextSnackbar;
                    if (snackbarRecord != null) {
                        snackbarManager.currentSnackbar = snackbarRecord;
                        snackbarManager.nextSnackbar = null;
                        SnackbarManager.Callback callback = (SnackbarManager.Callback) snackbarRecord.callback.get();
                        if (callback != null) {
                            callback.show();
                        } else {
                            snackbarManager.currentSnackbar = null;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ViewParent parent = this.view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.view);
        }
    }

    public final void onViewShown() {
        SnackbarManager snackbarManager = SnackbarManager.getInstance();
        AnonymousClass5 anonymousClass5 = this.managerCallback;
        synchronized (snackbarManager.lock) {
            try {
                if (snackbarManager.isCurrentSnackbarLocked(anonymousClass5)) {
                    snackbarManager.scheduleTimeoutLocked(snackbarManager.currentSnackbar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void showViewImpl() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        boolean z = true;
        if (accessibilityManager != null && ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) == null || !enabledAccessibilityServiceList.isEmpty())) {
            z = false;
        }
        SnackbarBaseLayout snackbarBaseLayout = this.view;
        if (z) {
            snackbarBaseLayout.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.9
                @Override // java.lang.Runnable
                public final void run() {
                    final BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                    SnackbarBaseLayout snackbarBaseLayout2 = baseTransientBottomBar.view;
                    if (snackbarBaseLayout2 == null) {
                        return;
                    }
                    if (snackbarBaseLayout2.getParent() != null) {
                        snackbarBaseLayout2.setVisibility(0);
                    }
                    if (snackbarBaseLayout2.animationMode == 1) {
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        valueAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
                        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass12());
                        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
                        valueAnimatorOfFloat2.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.13
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                                baseTransientBottomBar2.view.setScaleX(fFloatValue);
                                baseTransientBottomBar2.view.setScaleY(fFloatValue);
                            }
                        });
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
                        animatorSet.setDuration(150L);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.10
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                BaseTransientBottomBar.this.onViewShown();
                            }
                        });
                        animatorSet.start();
                        return;
                    }
                    int height = snackbarBaseLayout2.getHeight();
                    ViewGroup.LayoutParams layoutParams = snackbarBaseLayout2.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        height += ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    }
                    snackbarBaseLayout2.setTranslationY(height);
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setIntValues(height, 0);
                    valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                    valueAnimator.setDuration(250L);
                    valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.14
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            BaseTransientBottomBar.this.onViewShown();
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator) {
                            BaseTransientBottomBar.this.contentViewCallback.animateContentIn();
                        }
                    });
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(height) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.15
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            int iIntValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                            int[] iArr = BaseTransientBottomBar.SNACKBAR_STYLE_ATTR;
                            BaseTransientBottomBar.this.view.setTranslationY(iIntValue);
                        }
                    });
                    valueAnimator.start();
                }
            });
            return;
        }
        if (snackbarBaseLayout.getParent() != null) {
            snackbarBaseLayout.setVisibility(0);
        }
        onViewShown();
    }

    public final void updateMargins() {
        Rect rect;
        SnackbarBaseLayout snackbarBaseLayout = this.view;
        ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || (rect = this.originalMargins) == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = rect.bottom + this.extraBottomMarginWindowInset;
        marginLayoutParams.leftMargin = rect.left + this.extraLeftMarginWindowInset;
        marginLayoutParams.rightMargin = rect.right + this.extraRightMarginWindowInset;
        snackbarBaseLayout.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || this.extraBottomMarginGestureInset <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = snackbarBaseLayout.getLayoutParams();
        if ((layoutParams2 instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams2).a instanceof SwipeDismissBehavior)) {
            Runnable runnable = this.bottomMarginGestureInsetRunnable;
            snackbarBaseLayout.removeCallbacks(runnable);
            snackbarBaseLayout.post(runnable);
        }
    }
}
