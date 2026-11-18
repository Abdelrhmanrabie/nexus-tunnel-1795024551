package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.provider.Settings;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import androidx.dynamicanimation.animation.a;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import defpackage.d;
import defpackage.dq0;
import defpackage.h21;
import defpackage.i21;
import defpackage.m6;
import defpackage.u3;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    public static final a INDICATOR_LENGTH_IN_LEVEL = new a<DeterminateDrawable>("indicatorLevel") { // from class: com.google.android.material.progressindicator.DeterminateDrawable.1
        @Override // androidx.dynamicanimation.animation.a
        public final float getValue(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.indicatorFraction * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.a
        public final void setValue(DeterminateDrawable determinateDrawable, float f) {
            a aVar = DeterminateDrawable.INDICATOR_LENGTH_IN_LEVEL;
            determinateDrawable.indicatorFraction = f / 10000.0f;
            determinateDrawable.invalidateSelf();
        }
    };
    public final DrawingDelegate drawingDelegate;
    public float indicatorFraction;
    public boolean skipAnimationOnLevelChange;
    public final h21 springAnimation;
    public final i21 springForce;

    public DeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate<S> drawingDelegate) {
        super(context, baseProgressIndicatorSpec);
        this.skipAnimationOnLevelChange = false;
        this.drawingDelegate = drawingDelegate;
        drawingDelegate.drawable = this;
        i21 i21Var = new i21();
        this.springForce = i21Var;
        i21Var.b = 1.0f;
        i21Var.c = false;
        i21Var.a = Math.sqrt(50.0f);
        i21Var.c = false;
        h21 h21Var = new h21(this, INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimation = h21Var;
        h21Var.r = i21Var;
        if (this.growFraction != 1.0f) {
            this.growFraction = 1.0f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            float growFraction = getGrowFraction();
            DrawingDelegate drawingDelegate = this.drawingDelegate;
            drawingDelegate.spec.validateSpec();
            drawingDelegate.adjustCanvas(canvas, growFraction);
            DrawingDelegate drawingDelegate2 = this.drawingDelegate;
            Paint paint = this.paint;
            drawingDelegate2.fillTrack(canvas, paint);
            int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.totalAlpha);
            this.drawingDelegate.fillIndicator(canvas, paint, 0.0f, this.indicatorFraction, iCompositeARGBWithAlpha);
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.totalAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public final /* bridge */ /* synthetic */ int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public final void hideNow() {
        super.setVisible(false, false, false);
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.springAnimation.c();
        this.indicatorFraction = getLevel() / 10000.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        String str;
        boolean z = this.skipAnimationOnLevelChange;
        h21 h21Var = this.springAnimation;
        if (z) {
            h21Var.c();
            this.indicatorFraction = i / 10000.0f;
            invalidateSelf();
            return true;
        }
        h21Var.b = this.indicatorFraction * 10000.0f;
        h21Var.c = true;
        float f = i;
        if (h21Var.f) {
            h21Var.s = f;
            return true;
        }
        if (h21Var.r == null) {
            h21Var.r = new i21(f);
        }
        i21 i21Var = h21Var.r;
        double d = f;
        i21Var.i = d;
        double d2 = (float) d;
        if (d2 > Float.MAX_VALUE) {
            str = "Final position of the spring cannot be greater than the max value.";
        } else {
            if (d2 >= -3.4028235E38f) {
                double dAbs = Math.abs(h21Var.i * 0.75f);
                i21Var.d = dAbs;
                i21Var.e = dAbs * 62.5d;
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    throw new AndroidRuntimeException("Animations may only be started on the main thread");
                }
                boolean z2 = h21Var.f;
                if (!z2 && !z2) {
                    h21Var.f = true;
                    if (!h21Var.c) {
                        h21Var.b = h21Var.e.getValue(h21Var.d);
                    }
                    float f2 = h21Var.b;
                    if (f2 > Float.MAX_VALUE || f2 < -3.4028235E38f) {
                        d.AnonymousClass0.m$2("Starting value need to be in between min value and max value");
                        return false;
                    }
                    ThreadLocal threadLocal = u3.f;
                    if (threadLocal.get() == null) {
                        threadLocal.set(new u3());
                    }
                    u3 u3Var = (u3) threadLocal.get();
                    ArrayList arrayList = u3Var.b;
                    if (arrayList.size() == 0) {
                        if (u3Var.d == null) {
                            u3Var.d = new m6(u3Var.c);
                        }
                        m6 m6Var = u3Var.d;
                        ((Choreographer) m6Var.b).postFrameCallback((dq0) m6Var.c);
                    }
                    if (!arrayList.contains(h21Var)) {
                        arrayList.add(h21Var);
                        return true;
                    }
                }
                return true;
            }
            str = "Final position of the spring cannot be less than the min value.";
        }
        d.AnonymousClass0.m$3(str);
        return false;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return setVisible(z, z2, true);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public final boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        boolean visibleInternal = super.setVisibleInternal(z, z2, z3);
        ContentResolver contentResolver = this.context.getContentResolver();
        this.animatorDurationScaleProvider.getClass();
        float f = Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        if (f == 0.0f) {
            this.skipAnimationOnLevelChange = true;
            return visibleInternal;
        }
        this.skipAnimationOnLevelChange = false;
        float f2 = 50.0f / f;
        i21 i21Var = this.springForce;
        i21Var.getClass();
        if (f2 <= 0.0f) {
            d.AnonymousClass0.m$2("Spring stiffness constant must be positive.");
            return false;
        }
        i21Var.a = Math.sqrt(f2);
        i21Var.c = false;
        return visibleInternal;
    }
}
