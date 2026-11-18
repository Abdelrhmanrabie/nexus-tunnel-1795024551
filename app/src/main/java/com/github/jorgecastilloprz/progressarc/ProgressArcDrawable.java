package com.github.jorgecastilloprz.progressarc;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import com.android.volley.toolbox.HurlStack;
import com.github.jorgecastilloprz.progressarc.animations.ArcAnimationFactory$Type;
import com.google.crypto.tink.subtle.Hex;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ProgressArcDrawable extends Drawable implements Animatable {
    public HurlStack animationFactory;
    public boolean animationPlaying;
    public final RectF arcBounds = new RectF();
    public ValueAnimator completeAnim;
    public float currentRotationAngle;
    public float currentRotationAngleOffset;
    public float currentSweepAngle;
    public ValueAnimator growAnim;
    public boolean growing;
    public int maxSweepAngle;
    public int minSweepAngle;
    public final Paint paint;
    public ValueAnimator rotateAnim;
    public ValueAnimator shrinkAnim;

    /* JADX INFO: renamed from: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable$3, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class AnonymousClass3 implements Animator.AnimatorListener {
        public final /* synthetic */ int G0;
        public boolean cancelled;
        public final /* synthetic */ ProgressArcDrawable this$0;

        public AnonymousClass3(ProgressArcDrawable progressArcDrawable) {
            this.G0 = 1;
            this.this$0 = progressArcDrawable;
        }

        public /* synthetic */ AnonymousClass3(ProgressArcDrawable progressArcDrawable, int i) {
            this.G0 = i;
            this.this$0 = progressArcDrawable;
            this.cancelled = false;
        }

        private final void onAnimationRepeat$com$github$jorgecastilloprz$progressarc$ProgressArcDrawable$3(Animator animator) {
        }

        private final void onAnimationRepeat$com$github$jorgecastilloprz$progressarc$ProgressArcDrawable$5(Animator animator) {
        }

        private final void onAnimationRepeat$com$github$jorgecastilloprz$progressarc$ProgressArcDrawable$7(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.cancelled = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ValueAnimator valueAnimator;
            int i = this.G0;
            boolean z = this.cancelled;
            if (i != 0) {
                if (i != 1) {
                    ProgressArcDrawable progressArcDrawable = this.this$0;
                    if (!z) {
                        progressArcDrawable.stop();
                    }
                    progressArcDrawable.completeAnim.removeListener(this);
                    throw null;
                }
                if (z) {
                    return;
                }
                ProgressArcDrawable progressArcDrawable2 = this.this$0;
                progressArcDrawable2.growing = true;
                progressArcDrawable2.currentRotationAngleOffset += progressArcDrawable2.minSweepAngle;
                valueAnimator = progressArcDrawable2.growAnim;
            } else {
                if (z) {
                    return;
                }
                ProgressArcDrawable progressArcDrawable3 = this.this$0;
                progressArcDrawable3.growing = false;
                progressArcDrawable3.currentRotationAngleOffset += 360 - progressArcDrawable3.maxSweepAngle;
                valueAnimator = progressArcDrawable3.shrinkAnim;
            }
            valueAnimator.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            int i = this.G0;
            this.cancelled = false;
            if (i == 0) {
                this.this$0.growing = true;
            } else if (i != 1) {
                ProgressArcDrawable progressArcDrawable = this.this$0;
                progressArcDrawable.growing = true;
                progressArcDrawable.rotateAnim.setInterpolator(new DecelerateInterpolator());
                progressArcDrawable.rotateAnim.setDuration(12000L);
            }
        }
    }

    public ProgressArcDrawable(float f, int i, boolean z) {
        Paint paint = new Paint();
        this.paint = paint;
        final int i2 = 1;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
        paint.setStrokeCap(z ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        paint.setColor(i);
        final int i3 = 2;
        this.animationFactory = new HurlStack(i3);
        this.minSweepAngle = 20;
        this.maxSweepAngle = 300;
        final int i4 = 0;
        this.rotateAnim = HurlStack.buildAnimation(ArcAnimationFactory$Type.ROTATE, new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable.1
            public final /* synthetic */ ProgressArcDrawable this$0;

            {
                this.this$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2;
                int i5 = i4;
                float animatedFraction = Hex.getAnimatedFraction(valueAnimator);
                ProgressArcDrawable progressArcDrawable = this.this$0;
                if (i5 != 0) {
                    if (i5 == 1) {
                        int i6 = progressArcDrawable.minSweepAngle;
                        f2 = (animatedFraction * (progressArcDrawable.maxSweepAngle - i6)) + i6;
                    } else if (i5 != 2) {
                        f2 = (animatedFraction * 360.0f) + progressArcDrawable.minSweepAngle;
                    } else {
                        int i7 = progressArcDrawable.maxSweepAngle;
                        progressArcDrawable.currentSweepAngle = i7 - (animatedFraction * (i7 - progressArcDrawable.minSweepAngle));
                    }
                    progressArcDrawable.currentSweepAngle = f2;
                } else {
                    progressArcDrawable.currentRotationAngle = animatedFraction * 360.0f;
                }
                progressArcDrawable.invalidateSelf();
            }
        }, null);
        HurlStack hurlStack = this.animationFactory;
        ArcAnimationFactory$Type arcAnimationFactory$Type = ArcAnimationFactory$Type.GROW;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable.1
            public final /* synthetic */ ProgressArcDrawable this$0;

            {
                this.this$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2;
                int i5 = i2;
                float animatedFraction = Hex.getAnimatedFraction(valueAnimator);
                ProgressArcDrawable progressArcDrawable = this.this$0;
                if (i5 != 0) {
                    if (i5 == 1) {
                        int i6 = progressArcDrawable.minSweepAngle;
                        f2 = (animatedFraction * (progressArcDrawable.maxSweepAngle - i6)) + i6;
                    } else if (i5 != 2) {
                        f2 = (animatedFraction * 360.0f) + progressArcDrawable.minSweepAngle;
                    } else {
                        int i7 = progressArcDrawable.maxSweepAngle;
                        progressArcDrawable.currentSweepAngle = i7 - (animatedFraction * (i7 - progressArcDrawable.minSweepAngle));
                    }
                    progressArcDrawable.currentSweepAngle = f2;
                } else {
                    progressArcDrawable.currentRotationAngle = animatedFraction * 360.0f;
                }
                progressArcDrawable.invalidateSelf();
            }
        };
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(this, i4);
        hurlStack.getClass();
        this.growAnim = HurlStack.buildAnimation(arcAnimationFactory$Type, animatorUpdateListener, anonymousClass3);
        HurlStack hurlStack2 = this.animationFactory;
        ArcAnimationFactory$Type arcAnimationFactory$Type2 = ArcAnimationFactory$Type.SHRINK;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable.1
            public final /* synthetic */ ProgressArcDrawable this$0;

            {
                this.this$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2;
                int i5 = i3;
                float animatedFraction = Hex.getAnimatedFraction(valueAnimator);
                ProgressArcDrawable progressArcDrawable = this.this$0;
                if (i5 != 0) {
                    if (i5 == 1) {
                        int i6 = progressArcDrawable.minSweepAngle;
                        f2 = (animatedFraction * (progressArcDrawable.maxSweepAngle - i6)) + i6;
                    } else if (i5 != 2) {
                        f2 = (animatedFraction * 360.0f) + progressArcDrawable.minSweepAngle;
                    } else {
                        int i7 = progressArcDrawable.maxSweepAngle;
                        progressArcDrawable.currentSweepAngle = i7 - (animatedFraction * (i7 - progressArcDrawable.minSweepAngle));
                    }
                    progressArcDrawable.currentSweepAngle = f2;
                } else {
                    progressArcDrawable.currentRotationAngle = animatedFraction * 360.0f;
                }
                progressArcDrawable.invalidateSelf();
            }
        };
        AnonymousClass3 anonymousClass4 = new AnonymousClass3(this);
        hurlStack2.getClass();
        this.shrinkAnim = HurlStack.buildAnimation(arcAnimationFactory$Type2, animatorUpdateListener2, anonymousClass4);
        HurlStack hurlStack3 = this.animationFactory;
        ArcAnimationFactory$Type arcAnimationFactory$Type3 = ArcAnimationFactory$Type.COMPLETE;
        final int i5 = 3;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener3 = new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable.1
            public final /* synthetic */ ProgressArcDrawable this$0;

            {
                this.this$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2;
                int i6 = i5;
                float animatedFraction = Hex.getAnimatedFraction(valueAnimator);
                ProgressArcDrawable progressArcDrawable = this.this$0;
                if (i6 != 0) {
                    if (i6 == 1) {
                        int i7 = progressArcDrawable.minSweepAngle;
                        f2 = (animatedFraction * (progressArcDrawable.maxSweepAngle - i7)) + i7;
                    } else if (i6 != 2) {
                        f2 = (animatedFraction * 360.0f) + progressArcDrawable.minSweepAngle;
                    } else {
                        int i8 = progressArcDrawable.maxSweepAngle;
                        progressArcDrawable.currentSweepAngle = i8 - (animatedFraction * (i8 - progressArcDrawable.minSweepAngle));
                    }
                    progressArcDrawable.currentSweepAngle = f2;
                } else {
                    progressArcDrawable.currentRotationAngle = animatedFraction * 360.0f;
                }
                progressArcDrawable.invalidateSelf();
            }
        };
        AnonymousClass3 anonymousClass5 = new AnonymousClass3(this, i3);
        hurlStack3.getClass();
        this.completeAnim = HurlStack.buildAnimation(arcAnimationFactory$Type3, animatorUpdateListener3, anonymousClass5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f = this.currentRotationAngle - this.currentRotationAngleOffset;
        float f2 = this.currentSweepAngle;
        if (!this.growing) {
            f += 360.0f - f2;
        }
        Paint paint = this.paint;
        canvas.drawArc(this.arcBounds, f, f2, false, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 4;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.animationPlaying;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        float f = rect.left;
        RectF rectF = this.arcBounds;
        rectF.left = f;
        rectF.right = rect.right;
        rectF.top = rect.top;
        rectF.bottom = rect.bottom;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.animationPlaying = true;
        this.currentSweepAngle = 0.0f;
        this.currentRotationAngle = 0.0f;
        this.currentRotationAngleOffset = 0.0f;
        this.rotateAnim.start();
        this.growAnim.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.animationPlaying = false;
        this.rotateAnim.cancel();
        this.growAnim.cancel();
        this.shrinkAnim.cancel();
        this.completeAnim.cancel();
        invalidateSelf();
    }
}
