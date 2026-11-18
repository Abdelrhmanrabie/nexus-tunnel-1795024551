package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.provider.Settings;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    public final IndeterminateAnimatorDelegate animatorDelegate;
    public final DrawingDelegate drawingDelegate;

    public IndeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate<S> drawingDelegate, IndeterminateAnimatorDelegate<ObjectAnimator> indeterminateAnimatorDelegate) {
        super(context, baseProgressIndicatorSpec);
        this.drawingDelegate = drawingDelegate;
        drawingDelegate.drawable = this;
        this.animatorDelegate = indeterminateAnimatorDelegate;
        indeterminateAnimatorDelegate.drawable = this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        float growFraction = getGrowFraction();
        DrawingDelegate drawingDelegate = this.drawingDelegate;
        drawingDelegate.spec.validateSpec();
        drawingDelegate.adjustCanvas(canvas, growFraction);
        DrawingDelegate drawingDelegate2 = this.drawingDelegate;
        Paint paint = this.paint;
        drawingDelegate2.fillTrack(canvas, paint);
        int i = 0;
        while (true) {
            IndeterminateAnimatorDelegate indeterminateAnimatorDelegate = this.animatorDelegate;
            int[] iArr = indeterminateAnimatorDelegate.segmentColors;
            if (i >= iArr.length) {
                canvas.restore();
                return;
            }
            float[] fArr = indeterminateAnimatorDelegate.segmentPositions;
            int i2 = i * 2;
            this.drawingDelegate.fillIndicator(canvas, paint, fArr[i2], fArr[i2 + 1], iArr[i]);
            i++;
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

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return setVisible(z, z2, true);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public final boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        boolean visibleInternal = super.setVisibleInternal(z, z2, z3);
        if (!super.isRunning()) {
            this.animatorDelegate.cancelAnimatorImmediately();
        }
        ContentResolver contentResolver = this.context.getContentResolver();
        this.animatorDurationScaleProvider.getClass();
        Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        if (z && z3) {
            this.animatorDelegate.startAnimator();
        }
        return visibleInternal;
    }
}
