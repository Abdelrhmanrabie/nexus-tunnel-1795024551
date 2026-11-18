package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import defpackage.qd1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {
    public static final /* synthetic */ int $r8$clinit = 0;
    public boolean animatingOnTouchUp;
    public final float centerDotRadius;
    public boolean changedDuringTouch;
    public int circleRadius;
    public double degRad;
    public float downX;
    public float downY;
    public boolean isInTapRegion;
    public final ArrayList listeners;
    public OnActionUpListener onActionUpListener;
    public float originalDeg;
    public final Paint paint;
    public ValueAnimator rotationAnimator;
    public final int scaledTouchSlop;
    public final RectF selectorBox;
    public final int selectorRadius;
    public final int selectorStrokeWidth;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnActionUpListener {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnRotateListener {
        void onRotate(float f, boolean z);
    }

    public ClockHandView(Context context) {
        this(context, null);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.th);
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.listeners = new ArrayList();
        Paint paint = new Paint();
        this.paint = paint;
        this.selectorBox = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.ClockHandView, i, R.plurals.a3d);
        this.circleRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.selectorRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        Resources resources = getResources();
        this.selectorStrokeWidth = resources.getDimensionPixelSize(R.dimen.ie);
        this.centerDotRadius = resources.getDimensionPixelSize(R.dimen.ic);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        setHandRotation(0.0f, false);
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = qd1.a;
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int getDegreesFromXY(float f, float f2) {
        int degrees = (int) Math.toDegrees(Math.atan2(f2 - (getHeight() / 2), f - (getWidth() / 2)));
        int i = degrees + 90;
        return i < 0 ? degrees + 450 : i;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f = width;
        float fCos = (this.circleRadius * ((float) Math.cos(this.degRad))) + f;
        float f2 = height;
        float fSin = (this.circleRadius * ((float) Math.sin(this.degRad))) + f2;
        Paint paint = this.paint;
        paint.setStrokeWidth(0.0f);
        int i = this.selectorRadius;
        canvas.drawCircle(fCos, fSin, i, paint);
        double dSin = Math.sin(this.degRad);
        double dCos = Math.cos(this.degRad);
        double d = this.circleRadius - i;
        paint.setStrokeWidth(this.selectorStrokeWidth);
        canvas.drawLine(f, f2, width + ((int) (dCos * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f, f2, this.centerDotRadius, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setHandRotation(this.originalDeg, false);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        OnActionUpListener onActionUpListener;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.downX = x;
            this.downY = y;
            this.isInTapRegion = true;
            this.changedDuringTouch = false;
            z = true;
            z2 = false;
            z3 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i = (int) (x - this.downX);
            int i2 = (int) (y - this.downY);
            this.isInTapRegion = (i2 * i2) + (i * i) > this.scaledTouchSlop;
            z3 = this.changedDuringTouch;
            z2 = actionMasked == 1;
            z = false;
        } else {
            z2 = false;
            z3 = false;
            z = false;
        }
        boolean z5 = this.changedDuringTouch;
        float degreesFromXY = getDegreesFromXY(x, y);
        boolean z6 = this.originalDeg != degreesFromXY;
        if (z && z6) {
            z4 = true;
        } else if (z6 || z3) {
            setHandRotation(degreesFromXY, z2 && this.animatingOnTouchUp);
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z7 = z4 | z5;
        this.changedDuringTouch = z7;
        if (z7 && z2 && (onActionUpListener = this.onActionUpListener) != null) {
            float degreesFromXY2 = getDegreesFromXY(x, y);
            boolean z8 = this.isInTapRegion;
            TimePickerClockPresenter timePickerClockPresenter = (TimePickerClockPresenter) onActionUpListener;
            TimePickerView timePickerView = timePickerClockPresenter.timePickerView;
            timePickerClockPresenter.broadcasting = true;
            TimeModel timeModel = timePickerClockPresenter.time;
            int i3 = timeModel.minute;
            int i4 = timeModel.hour;
            if (timeModel.selection == 10) {
                timePickerView.clockHandView.setHandRotation(timePickerClockPresenter.hourRotation, false);
                if (!((AccessibilityManager) timePickerView.getContext().getSystemService(AccessibilityManager.class)).isTouchExplorationEnabled()) {
                    timePickerClockPresenter.setSelection(12, true);
                }
            } else {
                int iRound = Math.round(degreesFromXY2);
                if (!z8) {
                    int i5 = (((iRound + 15) / 30) * 5) % 60;
                    timeModel.minute = i5;
                    timePickerClockPresenter.minuteRotation = i5 * 6;
                }
                timePickerView.clockHandView.setHandRotation(timePickerClockPresenter.minuteRotation, z8);
            }
            timePickerClockPresenter.broadcasting = false;
            timePickerClockPresenter.updateTime();
            if (timeModel.minute != i3 || timeModel.hour != i4) {
                timePickerView.performHapticFeedback(4);
            }
        }
        return true;
    }

    public final void setHandRotation(float f, boolean z) {
        ValueAnimator valueAnimator = this.rotationAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            setHandRotationInternal(f, false);
            return;
        }
        float f2 = this.originalDeg;
        if (Math.abs(f2 - f) > 180.0f) {
            if (f2 > 180.0f && f < 180.0f) {
                f += 360.0f;
            }
            if (f2 < 180.0f && f > 180.0f) {
                f2 += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(f2), Float.valueOf(f));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((Float) pair.first).floatValue(), ((Float) pair.second).floatValue());
        this.rotationAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.rotationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.ClockHandView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                int i = ClockHandView.$r8$clinit;
                ClockHandView.this.setHandRotationInternal(fFloatValue, true);
            }
        });
        this.rotationAnimator.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.timepicker.ClockHandView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
        this.rotationAnimator.start();
    }

    public final void setHandRotationInternal(float f, boolean z) {
        float f2 = f % 360.0f;
        this.originalDeg = f2;
        this.degRad = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        float fCos = (this.circleRadius * ((float) Math.cos(this.degRad))) + (getWidth() / 2);
        float fSin = (this.circleRadius * ((float) Math.sin(this.degRad))) + height;
        float f3 = this.selectorRadius;
        this.selectorBox.set(fCos - f3, fSin - f3, fCos + f3, fSin + f3);
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((OnRotateListener) it.next()).onRotate(f2, z);
        }
        invalidate();
    }
}
