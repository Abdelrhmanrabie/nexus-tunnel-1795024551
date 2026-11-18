package com.mecofarid.squeezeloader;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import defpackage.ae;
import defpackage.rc;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SqueezeLoader extends ProgressBar {
    public final int MIN_HEIGHT_SQUEEZEBAR;
    public final int MIN_WIDTH_SQUEEZELOADER;
    public final long mAnimatioDuration;
    public float mAnimationFraction;
    public ValueAnimator mSqueezebarAnimator;
    public float mSqueezebarDisplacement;
    public int mSqueezebarHeight;
    public final Paint mSqueezebarPaint;
    public final float mSqueezebarWidth;

    public SqueezeLoader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SqueezeLoader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MIN_WIDTH_SQUEEZELOADER = (int) getResources().getDimension(R.dimen.pe);
        float dimension = getResources().getDimension(R.dimen.pd);
        float dimension2 = getResources().getDimension(R.dimen.pf);
        float dimension3 = getResources().getDimension(R.dimen.pg);
        this.MIN_HEIGHT_SQUEEZEBAR = (int) getResources().getDimension(R.dimen.pc);
        int integer = getResources().getInteger(R.integer.ap);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SqueezeLoader, i, 0);
        int color = typedArrayObtainStyledAttributes.getColor(1, context.getColor(R.color.qz));
        this.mAnimatioDuration = Math.max(typedArrayObtainStyledAttributes.getInteger(0, integer), integer);
        this.mSqueezebarWidth = Math.min(typedArrayObtainStyledAttributes.getDimension(2, dimension), dimension2) * 2;
        Paint paint = new Paint(1);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(dimension3);
        this.mSqueezebarPaint = paint;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ValueAnimator valueAnimator = this.mSqueezebarAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.mSqueezebarAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        System.out.println((Object) "Josiah ondraw");
        super.onDraw(canvas);
        float f = this.mSqueezebarDisplacement;
        float f2 = this.mAnimationFraction;
        if (f2 > 0.5d) {
            f2 = 1 - f2;
        }
        float f3 = (f2 * this.mSqueezebarWidth) / 2.0f;
        float f4 = f - f3;
        float f5 = f3 + f;
        RectF rectF = new RectF();
        rectF.left = f4;
        rectF.top = 0.0f;
        rectF.right = f5;
        rectF.bottom = this.mSqueezebarHeight;
        canvas.drawRect(rectF, this.mSqueezebarPaint);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int iMax = Math.max(this.MIN_WIDTH_SQUEEZELOADER, size);
        if (mode != 1073741824) {
            size2 = Math.min(this.MIN_HEIGHT_SQUEEZEBAR, size2);
        }
        setMeasuredDimension(iMax, size2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mSqueezebarHeight = Math.max(this.MIN_HEIGHT_SQUEEZEBAR, i2);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, i);
        valueAnimatorOfFloat.addUpdateListener(new rc(1, this));
        valueAnimatorOfFloat.setDuration(this.mAnimatioDuration);
        valueAnimatorOfFloat.setRepeatMode(2);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setInterpolator(new EaseInOutCubicInterpolator());
        valueAnimatorOfFloat.start();
        this.mSqueezebarAnimator = valueAnimatorOfFloat;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        ValueAnimator valueAnimator = this.mSqueezebarAnimator;
        if (valueAnimator != null) {
            if (valueAnimator.isStarted() && ae.O0(new Integer[]{4, 8}).contains(Integer.valueOf(i))) {
                valueAnimator.cancel();
            } else {
                if (valueAnimator.isStarted() || i != 0) {
                    return;
                }
                valueAnimator.start();
            }
        }
    }
}
