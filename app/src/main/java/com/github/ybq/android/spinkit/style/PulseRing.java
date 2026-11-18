package com.github.ybq.android.spinkit.style;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.PathInterpolator;
import com.github.ybq.android.spinkit.animation.interpolator.KeyFrameInterpolator;
import com.github.ybq.android.spinkit.sprite.ShapeSprite;
import com.github.ybq.android.spinkit.sprite.Sprite;
import defpackage.z20;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class PulseRing extends ShapeSprite {
    public PulseRing() {
        setScale(0.0f);
    }

    @Override // com.github.ybq.android.spinkit.sprite.ShapeSprite
    public final void drawShape(Canvas canvas, Paint paint) {
        if (this.drawBounds != null) {
            paint.setStyle(Paint.Style.STROKE);
            int iMin = Math.min(this.drawBounds.width(), this.drawBounds.height()) / 2;
            paint.setStrokeWidth(iMin / 12);
            canvas.drawCircle(this.drawBounds.centerX(), this.drawBounds.centerY(), iMin, paint);
        }
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite
    public final ValueAnimator onCreateAnimation() {
        float[] fArr = {0.0f, 0.7f, 1.0f};
        z20 z20Var = new z20(this);
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        z20Var.holder(fArr, Sprite.SCALE, new Float[]{fValueOf, fValueOf2, fValueOf2});
        z20Var.holder(fArr, Sprite.ALPHA, new Integer[]{255, 178, 0});
        z20Var.a = 1000L;
        KeyFrameInterpolator keyFrameInterpolator = new KeyFrameInterpolator(new PathInterpolator(0.21f, 0.53f, 0.56f, 0.8f), new float[0]);
        keyFrameInterpolator.fractions = fArr;
        z20Var.c = keyFrameInterpolator;
        return z20Var.build();
    }
}
