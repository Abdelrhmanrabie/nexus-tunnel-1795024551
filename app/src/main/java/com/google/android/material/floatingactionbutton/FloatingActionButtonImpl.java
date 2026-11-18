package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import defpackage.d;
import defpackage.e;
import defpackage.vs;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class FloatingActionButtonImpl {
    public BorderDrawable borderDrawable;
    public LayerDrawable contentBackground;
    public Animator currentAnimator;
    public float elevation;
    public boolean ensureMinTouchTargetSize;
    public ArrayList hideListeners;
    public MotionSpec hideMotionSpec;
    public float hoveredFocusedTranslationZ;
    public int maxImageSize;
    public int minTouchTargetSize;
    public ViewTreeObserver.OnPreDrawListener preDrawListener;
    public float pressedTranslationZ;
    public Drawable rippleDrawable;
    public float rotation;
    public final ShadowViewDelegate shadowViewDelegate;
    public ShapeAppearanceModel shapeAppearance;
    public MaterialShapeDrawable shapeDrawable;
    public ArrayList showListeners;
    public MotionSpec showMotionSpec;
    public ArrayList transformationCallbacks;
    public final FloatingActionButton view;
    public static final vs ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final int[] PRESSED_ENABLED_STATE_SET = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] FOCUSED_ENABLED_STATE_SET = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] HOVERED_ENABLED_STATE_SET = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] ENABLED_STATE_SET = {R.attr.state_enabled};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public float imageMatrixScale = 1.0f;
    public int animState = 0;
    public final Rect tmpRect = new Rect();
    public final RectF tmpRectF1 = new RectF();
    public final RectF tmpRectF2 = new RectF();
    public final Matrix tmpMatrix = new Matrix();

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$6, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    class AnonymousClass6 implements ViewTreeObserver.OnPreDrawListener {
        public AnonymousClass6() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            float rotation = floatingActionButtonImpl.view.getRotation();
            if (floatingActionButtonImpl.rotation == rotation) {
                return true;
            }
            floatingActionButtonImpl.rotation = rotation;
            floatingActionButtonImpl.updateFromViewRotation();
            return true;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class DisabledElevationAnimation extends ShadowAnimatorImpl {
        public DisabledElevationAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float getTargetShadowSize() {
            return 0.0f;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        public ElevateToHoveredFocusedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float getTargetShadowSize() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.hoveredFocusedTranslationZ;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        public ElevateToPressedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float getTargetShadowSize() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.pressedTranslationZ;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class ResetElevationAnimation extends ShadowAnimatorImpl {
        public ResetElevationAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public float shadowSizeEnd;
        public float shadowSizeStart;
        public boolean validValues;

        private ShadowAnimatorImpl() {
        }

        public abstract float getTargetShadowSize();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            float f = (int) this.shadowSizeEnd;
            MaterialShapeDrawable materialShapeDrawable = FloatingActionButtonImpl.this.shapeDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setElevation(f);
            }
            this.validValues = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            boolean z = this.validValues;
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            if (!z) {
                MaterialShapeDrawable materialShapeDrawable = floatingActionButtonImpl.shapeDrawable;
                this.shadowSizeStart = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.getElevation();
                this.shadowSizeEnd = getTargetShadowSize();
                this.validValues = true;
            }
            float f = this.shadowSizeStart;
            float animatedFraction = (int) ((valueAnimator.getAnimatedFraction() * (this.shadowSizeEnd - f)) + f);
            MaterialShapeDrawable materialShapeDrawable2 = floatingActionButtonImpl.shapeDrawable;
            if (materialShapeDrawable2 != null) {
                materialShapeDrawable2.setElevation(animatedFraction);
            }
        }
    }

    public FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.view = floatingActionButton;
        this.shadowViewDelegate = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation()));
        stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation()));
        stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation(this)));
        this.rotation = floatingActionButton.getRotation();
    }

    public static ValueAnimator createElevationAnimator(ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void calculateImageMatrixFromScale(float f, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.view.getDrawable();
        if (drawable == null || this.maxImageSize == 0) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        RectF rectF = this.tmpRectF1;
        rectF.set(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        float f2 = this.maxImageSize;
        RectF rectF2 = this.tmpRectF2;
        rectF2.set(0.0f, 0.0f, f2, f2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        float f3 = this.maxImageSize / 2.0f;
        matrix.postScale(f, f, f3, f3);
    }

    public final AnimatorSet createAnimator(MotionSpec motionSpec, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.view;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        motionSpec.getTiming("opacity").apply(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f2);
        motionSpec.getTiming("scale").apply(objectAnimatorOfFloat2);
        int i = Build.VERSION.SDK_INT;
        if (i == 26) {
            objectAnimatorOfFloat2.setEvaluator(new TypeEvaluator<Float>(this) { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.5
                public final FloatEvaluator floatEvaluator = new FloatEvaluator();

                @Override // android.animation.TypeEvaluator
                public final Float evaluate(float f4, Float f5, Float f6) {
                    float fFloatValue = this.floatEvaluator.evaluate(f4, (Number) f5, (Number) f6).floatValue();
                    if (fFloatValue < 0.1f) {
                        fFloatValue = 0.0f;
                    }
                    return Float.valueOf(fFloatValue);
                }
            });
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f2);
        motionSpec.getTiming("scale").apply(objectAnimatorOfFloat3);
        if (i == 26) {
            objectAnimatorOfFloat3.setEvaluator(new TypeEvaluator<Float>(this) { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.5
                public final FloatEvaluator floatEvaluator = new FloatEvaluator();

                @Override // android.animation.TypeEvaluator
                public final Float evaluate(float f4, Float f5, Float f6) {
                    float fFloatValue = this.floatEvaluator.evaluate(f4, (Number) f5, (Number) f6).floatValue();
                    if (fFloatValue < 0.1f) {
                        fFloatValue = 0.0f;
                    }
                    return Float.valueOf(fFloatValue);
                }
            });
        }
        arrayList.add(objectAnimatorOfFloat3);
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f3, matrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(floatingActionButton, new ImageMatrixProperty(), new MatrixEvaluator() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
            public final Matrix evaluate(float f4, Matrix matrix2, Matrix matrix3) {
                FloatingActionButtonImpl.this.imageMatrixScale = f4;
                return super.evaluate(f4, matrix2, matrix3);
            }
        }, new Matrix(matrix));
        motionSpec.getTiming("iconScale").apply(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet createDefaultAnimator(final float f, final float f2, final float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.view;
        final float alpha = floatingActionButton.getAlpha();
        final float scaleX = floatingActionButton.getScaleX();
        final float scaleY = floatingActionButton.getScaleY();
        final float f4 = this.imageMatrixScale;
        final Matrix matrix = new Matrix(this.tmpMatrix);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.view.setAlpha(AnimationUtils.lerp(alpha, f, 0.0f, 0.2f, fFloatValue));
                FloatingActionButton floatingActionButton2 = floatingActionButtonImpl.view;
                float f5 = f2;
                float f6 = scaleX;
                floatingActionButton2.setScaleX(e.a(f5, f6, fFloatValue, f6));
                FloatingActionButton floatingActionButton3 = floatingActionButtonImpl.view;
                float f7 = scaleY;
                floatingActionButton3.setScaleY(e.a(f5, f7, fFloatValue, f7));
                float f8 = f3;
                float f9 = f4;
                floatingActionButtonImpl.imageMatrixScale = e.a(f8, f9, fFloatValue, f9);
                float fA = e.a(f8, f9, fFloatValue, f9);
                Matrix matrix2 = matrix;
                floatingActionButtonImpl.calculateImageMatrixFromScale(fA, matrix2);
                floatingActionButtonImpl.view.setImageMatrix(matrix2);
            }
        });
        arrayList.add(valueAnimatorOfFloat);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.setDuration(MotionUtils.resolveThemeDuration(floatingActionButton.getContext(), org.hamotunnelplus.xyz.R.style.ug, floatingActionButton.getContext().getResources().getInteger(org.hamotunnelplus.xyz.R.integer.a3)));
        animatorSet.setInterpolator(MotionUtils.resolveThemeInterpolator(floatingActionButton.getContext(), org.hamotunnelplus.xyz.R.style.uq, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    public float getElevation() {
        return this.elevation;
    }

    public void getPadding(Rect rect) {
        int sizeDimension;
        if (this.ensureMinTouchTargetSize) {
            int i = this.minTouchTargetSize;
            FloatingActionButton floatingActionButton = this.view;
            sizeDimension = (i - floatingActionButton.getSizeDimension(floatingActionButton.size)) / 2;
        } else {
            sizeDimension = 0;
        }
        float elevation = getElevation() + this.pressedTranslationZ;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(elevation));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(elevation * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    public void onElevationsChanged(float f, float f2, float f3) {
        updatePadding();
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f);
        }
    }

    public final void onTranslationChanged() {
        ArrayList arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InternalTransformationCallback) it.next()).onTranslationChanged();
            }
        }
    }

    public final void setShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearance = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Object obj = this.rippleDrawable;
        if (obj instanceof Shapeable) {
            ((Shapeable) obj).setShapeAppearanceModel(shapeAppearanceModel);
        }
        BorderDrawable borderDrawable = this.borderDrawable;
        if (borderDrawable != null) {
            borderDrawable.shapeAppearanceModel = shapeAppearanceModel;
            borderDrawable.invalidateSelf();
        }
    }

    public boolean shouldAddPadding() {
        return true;
    }

    public void updateFromViewRotation() {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShadowCompatRotation((int) this.rotation);
        }
    }

    public final void updatePadding() {
        Rect rect = this.tmpRect;
        getPadding(rect);
        if (this.contentBackground == null) {
            d.AnonymousClass0.m$1("Didn't initialize content background");
            return;
        }
        Drawable insetDrawable = shouldAddPadding() ? new InsetDrawable((Drawable) this.contentBackground, rect.left, rect.top, rect.right, rect.bottom) : this.contentBackground;
        ShadowViewDelegate shadowViewDelegate = this.shadowViewDelegate;
        shadowViewDelegate.setBackgroundDrawable(insetDrawable);
        shadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
