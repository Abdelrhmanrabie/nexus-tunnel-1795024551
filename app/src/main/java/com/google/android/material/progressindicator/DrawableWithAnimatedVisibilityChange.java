package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.util.Property;
import androidx.vectordrawable.graphics.drawable.a;
import com.google.android.material.animation.AnimationUtils;
import defpackage.d;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable {
    public static final Property GROW_FRACTION = new Property<DrawableWithAnimatedVisibilityChange, Float>(Float.class, "growFraction") { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.3
        @Override // android.util.Property
        public final Float get(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
            return Float.valueOf(drawableWithAnimatedVisibilityChange.getGrowFraction());
        }

        @Override // android.util.Property
        public final void set(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, Float f) {
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = drawableWithAnimatedVisibilityChange;
            float fFloatValue = f.floatValue();
            if (drawableWithAnimatedVisibilityChange2.growFraction != fFloatValue) {
                drawableWithAnimatedVisibilityChange2.growFraction = fFloatValue;
                drawableWithAnimatedVisibilityChange2.invalidateSelf();
            }
        }
    };
    public ArrayList animationCallbacks;
    public final BaseProgressIndicatorSpec baseSpec;
    public final Context context;
    public float growFraction;
    public ObjectAnimator hideAnimator;
    public boolean ignoreCallbacks;
    public ObjectAnimator showAnimator;
    public int totalAlpha;
    public final Paint paint = new Paint();
    public final AnimatorDurationScaleProvider animatorDurationScaleProvider = new AnimatorDurationScaleProvider();

    public DrawableWithAnimatedVisibilityChange(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.context = context;
        this.baseSpec = baseProgressIndicatorSpec;
        setAlpha(255);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.totalAlpha;
    }

    public final float getGrowFraction() {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.baseSpec;
        if (baseProgressIndicatorSpec.showAnimationBehavior == 0 && baseProgressIndicatorSpec.hideAnimationBehavior == 0) {
            return 1.0f;
        }
        return this.growFraction;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void hideNow() {
        setVisible(false, false, false);
    }

    public boolean isHiding() {
        ObjectAnimator objectAnimator = this.hideAnimator;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isShowing() || isHiding();
    }

    public boolean isShowing() {
        ObjectAnimator objectAnimator = this.showAnimator;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.totalAlpha = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return setVisible(z, z2, true);
    }

    public boolean setVisible(boolean z, boolean z2, boolean z3) {
        ContentResolver contentResolver = this.context.getContentResolver();
        this.animatorDurationScaleProvider.getClass();
        return setVisibleInternal(z, z2, z3 && Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) > 0.0f);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0074 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0076  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079  */
    /* JADX WARN: Code duplicated, block: B:31:0x007e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0084  */
    /* JADX WARN: Code duplicated, block: B:34:0x0088  */
    /* JADX WARN: Code duplicated, block: B:37:0x009c  */
    /* JADX WARN: Code duplicated, block: B:38:0x009e  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ba  */
    public boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        ObjectAnimator objectAnimator;
        boolean z4;
        ObjectAnimator objectAnimator2;
        String str;
        ObjectAnimator objectAnimator3 = this.showAnimator;
        Property property = GROW_FRACTION;
        if (objectAnimator3 != null) {
            if (this.hideAnimator == null) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<DrawableWithAnimatedVisibilityChange, Float>) property, 1.0f, 0.0f);
                this.hideAnimator = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(500L);
                this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                objectAnimator2 = this.hideAnimator;
                if (objectAnimator2 == null) {
                }
                this.hideAnimator = objectAnimator2;
                objectAnimator2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = DrawableWithAnimatedVisibilityChange.this;
                        DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                        ArrayList arrayList = drawableWithAnimatedVisibilityChange.animationCallbacks;
                        if (arrayList == null || drawableWithAnimatedVisibilityChange.ignoreCallbacks) {
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((a) it.next()).onAnimationEnd();
                        }
                    }
                });
            }
            if (isVisible()) {
                if (z) {
                    objectAnimator = this.showAnimator;
                } else {
                    objectAnimator = this.hideAnimator;
                }
                if (!z3) {
                    if (objectAnimator.isRunning()) {
                        objectAnimator.end();
                    } else {
                        boolean z5 = this.ignoreCallbacks;
                        this.ignoreCallbacks = true;
                        new ValueAnimator[]{objectAnimator}[0].end();
                        this.ignoreCallbacks = z5;
                    }
                    return super.setVisible(z, false);
                }
                if (z3) {
                }
                if (z) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.baseSpec;
                if (z) {
                    boolean z6 = this.ignoreCallbacks;
                    this.ignoreCallbacks = true;
                    new ValueAnimator[]{objectAnimator}[0].end();
                    this.ignoreCallbacks = z6;
                    return z4;
                }
                boolean z7 = this.ignoreCallbacks;
                this.ignoreCallbacks = true;
                new ValueAnimator[]{objectAnimator}[0].end();
                this.ignoreCallbacks = z7;
                return z4;
            }
            if (z) {
                objectAnimator = this.showAnimator;
            } else {
                objectAnimator = this.hideAnimator;
            }
            if (!z3) {
                if (objectAnimator.isRunning()) {
                    objectAnimator.end();
                } else {
                    boolean z8 = this.ignoreCallbacks;
                    this.ignoreCallbacks = true;
                    new ValueAnimator[]{objectAnimator}[0].end();
                    this.ignoreCallbacks = z8;
                }
                return super.setVisible(z, false);
            }
            if (z3) {
            }
            if (z) {
                z4 = true;
            } else {
                z4 = true;
            }
            BaseProgressIndicatorSpec baseProgressIndicatorSpec2 = this.baseSpec;
            if (z) {
                boolean z9 = this.ignoreCallbacks;
                this.ignoreCallbacks = true;
                new ValueAnimator[]{objectAnimator}[0].end();
                this.ignoreCallbacks = z9;
                return z4;
            }
            boolean z10 = this.ignoreCallbacks;
            this.ignoreCallbacks = true;
            new ValueAnimator[]{objectAnimator}[0].end();
            this.ignoreCallbacks = z10;
            return z4;
            return false;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<DrawableWithAnimatedVisibilityChange, Float>) property, 0.0f, 1.0f);
        this.showAnimator = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setDuration(500L);
        this.showAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        ObjectAnimator objectAnimator4 = this.showAnimator;
        if (objectAnimator4 == null || !objectAnimator4.isRunning()) {
            this.showAnimator = objectAnimator4;
            objectAnimator4.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = DrawableWithAnimatedVisibilityChange.this;
                    ArrayList arrayList = drawableWithAnimatedVisibilityChange.animationCallbacks;
                    if (arrayList == null || drawableWithAnimatedVisibilityChange.ignoreCallbacks) {
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).getClass();
                    }
                }
            });
            if (this.hideAnimator == null) {
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, (Property<DrawableWithAnimatedVisibilityChange, Float>) property, 1.0f, 0.0f);
                this.hideAnimator = objectAnimatorOfFloat3;
                objectAnimatorOfFloat3.setDuration(500L);
                this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                objectAnimator2 = this.hideAnimator;
                if (objectAnimator2 == null && objectAnimator2.isRunning()) {
                    str = "Cannot set hideAnimator while the current hideAnimator is running.";
                } else {
                    this.hideAnimator = objectAnimator2;
                    objectAnimator2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = DrawableWithAnimatedVisibilityChange.this;
                            DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                            ArrayList arrayList = drawableWithAnimatedVisibilityChange.animationCallbacks;
                            if (arrayList == null || drawableWithAnimatedVisibilityChange.ignoreCallbacks) {
                                return;
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((a) it.next()).onAnimationEnd();
                            }
                        }
                    });
                }
            }
            if (isVisible() || z) {
                if (z) {
                    objectAnimator = this.showAnimator;
                } else {
                    objectAnimator = this.hideAnimator;
                }
                if (!z3) {
                    if (objectAnimator.isRunning()) {
                        objectAnimator.end();
                    } else {
                        boolean z11 = this.ignoreCallbacks;
                        this.ignoreCallbacks = true;
                        new ValueAnimator[]{objectAnimator}[0].end();
                        this.ignoreCallbacks = z11;
                    }
                    return super.setVisible(z, false);
                }
                if (z3 || !objectAnimator.isRunning()) {
                    if (z || super.setVisible(z, false)) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    BaseProgressIndicatorSpec baseProgressIndicatorSpec3 = this.baseSpec;
                    if (z ? baseProgressIndicatorSpec3.hideAnimationBehavior == 0 : baseProgressIndicatorSpec3.showAnimationBehavior == 0) {
                        boolean z12 = this.ignoreCallbacks;
                        this.ignoreCallbacks = true;
                        new ValueAnimator[]{objectAnimator}[0].end();
                        this.ignoreCallbacks = z12;
                        return z4;
                    }
                    if (z2 || !objectAnimator.isPaused()) {
                        objectAnimator.start();
                        return z4;
                    }
                    objectAnimator.resume();
                    return z4;
                }
            }
            return false;
        }
        str = "Cannot set showAnimator while the current showAnimator is running.";
        d.AnonymousClass0.m$2(str);
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        setVisibleInternal(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        setVisibleInternal(false, true, false);
    }

    public boolean unregisterAnimationCallback(a aVar) {
        ArrayList arrayList = this.animationCallbacks;
        if (arrayList == null || !arrayList.contains(aVar)) {
            return false;
        }
        this.animationCallbacks.remove(aVar);
        if (!this.animationCallbacks.isEmpty()) {
            return true;
        }
        this.animationCallbacks = null;
        return true;
    }
}
