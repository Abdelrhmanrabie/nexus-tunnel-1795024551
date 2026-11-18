package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import defpackage.d;
import defpackage.e;
import defpackage.o01;
import defpackage.qd1;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public float dependencyOriginalTranslationX;
    public float dependencyOriginalTranslationY;
    public final int[] tmpArray;
    public final Rect tmpRect;
    public final RectF tmpRectF1;
    public final RectF tmpRectF2;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class FabTransformationSpec {
        public Positioning positioning;
        public MotionSpec timings;
    }

    public FabTransformationBehavior() {
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    public static Pair calculateMotionTiming(float f, float f2, boolean z, FabTransformationSpec fabTransformationSpec) {
        MotionTiming timing;
        MotionSpec motionSpec;
        String str;
        if (f == 0.0f || f2 == 0.0f) {
            timing = fabTransformationSpec.timings.getTiming("translationXLinear");
            motionSpec = fabTransformationSpec.timings;
            str = "translationYLinear";
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            timing = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
            motionSpec = fabTransformationSpec.timings;
            str = "translationYCurveDownwards";
        } else {
            timing = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
            motionSpec = fabTransformationSpec.timings;
            str = "translationYCurveUpwards";
        }
        return new Pair(timing, motionSpec.getTiming(str));
    }

    public static float calculateValueOfAnimationAtEndOfExpansion(FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, float f) {
        long j = motionTiming.delay;
        long j2 = motionTiming.duration;
        MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
        float interpolation = motionTiming.getInterpolator().getInterpolation((((timing.duration + timing.delay) + 17) - j) / j2);
        DecelerateInterpolator decelerateInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
        return e.a(0.0f, f, interpolation, f);
    }

    public final float calculateTranslationX(View view, View view2, Positioning positioning) {
        float fCenterX;
        float fCenterX2;
        float f;
        RectF rectF = this.tmpRectF1;
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view2, rectF2);
        int i = positioning.gravity & 7;
        if (i == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else {
            if (i != 3) {
                if (i != 5) {
                    f = 0.0f;
                } else {
                    fCenterX = rectF2.right;
                    fCenterX2 = rectF.right;
                }
                return f + positioning.xAdjustment;
            }
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        }
        f = fCenterX - fCenterX2;
        return f + positioning.xAdjustment;
    }

    public final float calculateTranslationY(View view, View view2, Positioning positioning) {
        float fCenterY;
        float fCenterY2;
        float f;
        RectF rectF = this.tmpRectF1;
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view2, rectF2);
        int i = positioning.gravity & 112;
        if (i == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else {
            if (i != 48) {
                if (i != 80) {
                    f = 0.0f;
                } else {
                    fCenterY = rectF2.bottom;
                    fCenterY2 = rectF.bottom;
                }
                return f + positioning.yAdjustment;
            }
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        }
        f = fCenterY - fCenterY2;
        return f + positioning.yAdjustment;
    }

    public final void calculateWindowBounds(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.tmpArray;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean layoutDependsOn(View view, View view2) {
        int i;
        if (view.getVisibility() != 8) {
            return (view2 instanceof FloatingActionButton) && ((i = ((FloatingActionButton) view2).expandableWidgetHelper.expandedComponentIdHint) == 0 || i == view.getId());
        }
        d.AnonymousClass0.m("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        if (fVar.h == 0) {
            fVar.h = 80;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0148  */
    /* JADX WARN: Code duplicated, block: B:97:0x0344  */
    /* JADX WARN: Code duplicated, block: B:99:0x0347  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet onCreateExpandedStateChangeAnimation(final View view, final View view2, final boolean z, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat;
        float f;
        ObjectAnimator objectAnimatorOfFloat2;
        ObjectAnimator objectAnimatorOfFloat3;
        ArrayList arrayList;
        AnimatorSet animatorSetCreateCircularReveal;
        int i;
        ViewGroup viewGroup;
        ObjectAnimator objectAnimatorOfFloat4;
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2;
        FabTransformationSpec fabTransformationSpecOnCreateMotionSpec = onCreateMotionSpec(view2.getContext(), z);
        if (z) {
            this.dependencyOriginalTranslationX = view.getTranslationX();
            this.dependencyOriginalTranslationY = view.getTranslationY();
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        WeakHashMap weakHashMap = qd1.a;
        float elevation = view2.getElevation() - view.getElevation();
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        fabTransformationSpecOnCreateMotionSpec.timings.getTiming("elevation").apply(objectAnimatorOfFloat);
        arrayList2.add(objectAnimatorOfFloat);
        float fCalculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpecOnCreateMotionSpec.positioning);
        float fCalculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpecOnCreateMotionSpec.positioning);
        Pair pairCalculateMotionTiming = calculateMotionTiming(fCalculateTranslationX, fCalculateTranslationY, z, fabTransformationSpecOnCreateMotionSpec);
        MotionTiming motionTiming = (MotionTiming) pairCalculateMotionTiming.first;
        MotionTiming motionTiming2 = (MotionTiming) pairCalculateMotionTiming.second;
        RectF rectF = this.tmpRectF2;
        Rect rect = this.tmpRect;
        RectF rectF2 = this.tmpRectF1;
        if (z) {
            f = 0.0f;
            if (!z2) {
                view2.setTranslationX(-fCalculateTranslationX);
                view2.setTranslationY(-fCalculateTranslationY);
            }
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            float fCalculateValueOfAnimationAtEndOfExpansion = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpecOnCreateMotionSpec, motionTiming, -fCalculateTranslationX);
            float fCalculateValueOfAnimationAtEndOfExpansion2 = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpecOnCreateMotionSpec, motionTiming2, -fCalculateTranslationY);
            view2.getWindowVisibleDisplayFrame(rect);
            rectF2.set(rect);
            calculateWindowBounds(view2, rectF);
            rectF.offset(fCalculateValueOfAnimationAtEndOfExpansion, fCalculateValueOfAnimationAtEndOfExpansion2);
            rectF.intersect(rectF2);
            rectF2.set(rectF);
            objectAnimatorOfFloat3 = objectAnimatorOfFloat6;
            objectAnimatorOfFloat2 = objectAnimatorOfFloat5;
        } else {
            f = 0.0f;
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fCalculateTranslationX);
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fCalculateTranslationY);
        }
        motionTiming.apply(objectAnimatorOfFloat2);
        motionTiming2.apply(objectAnimatorOfFloat3);
        arrayList2.add(objectAnimatorOfFloat2);
        arrayList2.add(objectAnimatorOfFloat3);
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        float fCalculateTranslationX2 = calculateTranslationX(view, view2, fabTransformationSpecOnCreateMotionSpec.positioning);
        float fCalculateTranslationY2 = calculateTranslationY(view, view2, fabTransformationSpecOnCreateMotionSpec.positioning);
        Pair pairCalculateMotionTiming2 = calculateMotionTiming(fCalculateTranslationX2, fCalculateTranslationY2, z, fabTransformationSpecOnCreateMotionSpec);
        MotionTiming motionTiming3 = (MotionTiming) pairCalculateMotionTiming2.first;
        MotionTiming motionTiming4 = (MotionTiming) pairCalculateMotionTiming2.second;
        Property property = View.TRANSLATION_X;
        if (!z) {
            fCalculateTranslationX2 = this.dependencyOriginalTranslationX;
        }
        float f2 = fCalculateTranslationY2;
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fCalculateTranslationX2);
        Property property2 = View.TRANSLATION_Y;
        if (!z) {
            f2 = this.dependencyOriginalTranslationY;
        }
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, f2);
        motionTiming3.apply(objectAnimatorOfFloat7);
        motionTiming4.apply(objectAnimatorOfFloat8);
        arrayList2.add(objectAnimatorOfFloat7);
        arrayList2.add(objectAnimatorOfFloat8);
        boolean z3 = view2 instanceof CircularRevealWidget;
        if (z3 && (view instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                arrayList = arrayList3;
            } else {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimatorOfInt2 = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 0);
                } else {
                    objectAnimatorOfInt2 = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, 255);
                }
                objectAnimatorOfInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.transformation.FabTransformationBehavior.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view2.invalidate();
                    }
                });
                fabTransformationSpecOnCreateMotionSpec.timings.getTiming("iconFade").apply(objectAnimatorOfInt2);
                arrayList2.add(objectAnimatorOfInt2);
                AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(this) { // from class: com.google.android.material.transformation.FabTransformationBehavior.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable(null);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationStart(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable(drawable);
                    }
                };
                arrayList = arrayList3;
                arrayList.add(animatorListenerAdapter);
            }
        } else {
            arrayList = arrayList3;
        }
        if (z3) {
            final CircularRevealWidget circularRevealWidget2 = (CircularRevealWidget) view2;
            Positioning positioning = fabTransformationSpecOnCreateMotionSpec.positioning;
            calculateWindowBounds(view, rectF2);
            rectF2.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
            calculateWindowBounds(view2, rectF);
            rectF.offset(-calculateTranslationX(view, view2, positioning), f);
            float fCenterX = rectF2.centerX() - rectF.left;
            Positioning positioning2 = fabTransformationSpecOnCreateMotionSpec.positioning;
            calculateWindowBounds(view, rectF2);
            rectF2.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
            calculateWindowBounds(view2, rectF);
            rectF.offset(0.0f, -calculateTranslationY(view, view2, positioning2));
            float fCenterY = rectF2.centerY() - rectF.top;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (floatingActionButton.isLaidOut()) {
                rect.set(0, 0, floatingActionButton.getWidth(), floatingActionButton.getHeight());
                floatingActionButton.offsetRectWithShadow(rect);
            }
            float fWidth2 = rect.width() / 2.0f;
            MotionTiming timing = fabTransformationSpecOnCreateMotionSpec.timings.getTiming("expansion");
            if (z) {
                if (!z2) {
                    circularRevealWidget2.setRevealInfo(new CircularRevealWidget.RevealInfo(fCenterX, fCenterY, fWidth2));
                }
                if (z2) {
                    fWidth2 = circularRevealWidget2.getRevealInfo().radius;
                }
                animatorSetCreateCircularReveal = CircularRevealCompat.createCircularReveal(circularRevealWidget2, fCenterX, fCenterY, MathUtils.distanceToFurthestCorner(fCenterX, fCenterY, fWidth, fHeight));
                animatorSetCreateCircularReveal.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.transformation.FabTransformationBehavior.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        CircularRevealWidget circularRevealWidget3 = circularRevealWidget2;
                        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget3.getRevealInfo();
                        revealInfo.radius = Float.MAX_VALUE;
                        circularRevealWidget3.setRevealInfo(revealInfo);
                    }
                });
                long j = timing.delay;
                int i2 = (int) fCenterX;
                int i3 = (int) fCenterY;
                if (j > 0) {
                    Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i2, i3, fWidth2, fWidth2);
                    animatorCreateCircularReveal.setStartDelay(0L);
                    animatorCreateCircularReveal.setDuration(j);
                    arrayList2.add(animatorCreateCircularReveal);
                }
            } else {
                float f3 = circularRevealWidget2.getRevealInfo().radius;
                AnimatorSet animatorSetCreateCircularReveal2 = CircularRevealCompat.createCircularReveal(circularRevealWidget2, fCenterX, fCenterY, fWidth2);
                long j2 = timing.delay;
                int i4 = (int) fCenterX;
                int i5 = (int) fCenterY;
                if (j2 > 0) {
                    Animator animatorCreateCircularReveal2 = ViewAnimationUtils.createCircularReveal(view2, i4, i5, f3, f3);
                    animatorCreateCircularReveal2.setStartDelay(0L);
                    animatorCreateCircularReveal2.setDuration(j2);
                    arrayList2.add(animatorCreateCircularReveal2);
                }
                long j3 = timing.delay;
                long j4 = timing.duration;
                o01 o01Var = fabTransformationSpecOnCreateMotionSpec.timings.timings;
                int i6 = o01Var.d;
                long jMax = 0;
                int i7 = 0;
                while (i7 < i6) {
                    o01 o01Var2 = o01Var;
                    MotionTiming motionTiming5 = (MotionTiming) o01Var.k(i7);
                    jMax = Math.max(jMax, motionTiming5.duration + motionTiming5.delay);
                    i7++;
                    o01Var = o01Var2;
                    j3 = j3;
                }
                long j5 = j3 + j4;
                if (j5 < jMax) {
                    Animator animatorCreateCircularReveal3 = ViewAnimationUtils.createCircularReveal(view2, i4, i5, fWidth2, fWidth2);
                    animatorCreateCircularReveal3.setStartDelay(j5);
                    animatorCreateCircularReveal3.setDuration(jMax - j5);
                    arrayList2.add(animatorCreateCircularReveal3);
                }
                animatorSetCreateCircularReveal = animatorSetCreateCircularReveal2;
            }
            timing.apply(animatorSetCreateCircularReveal);
            arrayList2.add(animatorSetCreateCircularReveal);
            arrayList.add(CircularRevealCompat.createCircularRevealListener(circularRevealWidget2));
        }
        if (z3) {
            CircularRevealWidget circularRevealWidget3 = (CircularRevealWidget) view2;
            WeakHashMap weakHashMap2 = qd1.a;
            ColorStateList backgroundTintList = view.getBackgroundTintList();
            int colorForState = backgroundTintList != null ? backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor()) : 0;
            int i8 = 16777215 & colorForState;
            if (z) {
                if (!z2) {
                    circularRevealWidget3.setCircularRevealScrimColor(colorForState);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(circularRevealWidget3, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, i8);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(circularRevealWidget3, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, colorForState);
            }
            objectAnimatorOfInt.setEvaluator(ArgbEvaluatorCompat.instance);
            fabTransformationSpecOnCreateMotionSpec.timings.getTiming("color").apply(objectAnimatorOfInt);
            arrayList2.add(objectAnimatorOfInt);
        }
        boolean z4 = view2 instanceof ViewGroup;
        if (z4) {
            View viewFindViewById = view2.findViewById(R.attr.rl);
            if (viewFindViewById != null) {
                if (viewFindViewById instanceof ViewGroup) {
                    viewGroup = (ViewGroup) viewFindViewById;
                } else {
                    viewGroup = null;
                }
            } else if ((view2 instanceof TransformationChildLayout) || (view2 instanceof TransformationChildCard)) {
                View childAt = ((ViewGroup) view2).getChildAt(0);
                if (childAt instanceof ViewGroup) {
                    viewGroup = (ViewGroup) childAt;
                } else {
                    viewGroup = null;
                }
            } else if (z4) {
                viewGroup = (ViewGroup) view2;
            } else {
                viewGroup = null;
            }
            if (viewGroup == null) {
                i = 0;
            } else {
                if (z) {
                    if (!z2) {
                        ChildrenAlphaProperty.CHILDREN_ALPHA.set(viewGroup, Float.valueOf(0.0f));
                    }
                    i = 0;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, ChildrenAlphaProperty.CHILDREN_ALPHA, 1.0f);
                } else {
                    i = 0;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, ChildrenAlphaProperty.CHILDREN_ALPHA, 0.0f);
                }
                fabTransformationSpecOnCreateMotionSpec.timings.getTiming("contentFade").apply(objectAnimatorOfFloat4);
                arrayList2.add(objectAnimatorOfFloat4);
            }
        } else {
            i = 0;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList2);
        animatorSet.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.transformation.FabTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (z) {
                    return;
                }
                view2.setVisibility(4);
                View view3 = view;
                view3.setAlpha(1.0f);
                view3.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                if (z) {
                    view2.setVisibility(0);
                    View view3 = view;
                    view3.setAlpha(0.0f);
                    view3.setVisibility(4);
                }
            }
        });
        int size = arrayList.size();
        for (int i9 = i; i9 < size; i9++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList.get(i9));
        }
        return animatorSet;
    }

    public abstract FabTransformationSpec onCreateMotionSpec(Context context, boolean z);
}
