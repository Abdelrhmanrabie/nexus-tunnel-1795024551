package com.github.ybq.android.spinkit.sprite;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShapeSprite extends Sprite {
    public int mBaseColor;
    public final Paint mPaint;
    public int mUseColor;

    public ShapeSprite() {
        setColor(-1);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(this.mUseColor);
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite
    public final void drawSelf(Canvas canvas) {
        int i = this.mUseColor;
        Paint paint = this.mPaint;
        paint.setColor(i);
        drawShape(canvas, paint);
    }

    public abstract void drawShape(Canvas canvas, Paint paint);

    @Override // com.github.ybq.android.spinkit.sprite.Sprite
    public final int getColor() {
        return this.mBaseColor;
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.alpha = i;
        updateUseColor();
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite
    public final void setColor(int i) {
        this.mBaseColor = i;
        updateUseColor();
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public final void updateUseColor() {
        int i = this.alpha;
        int i2 = this.mBaseColor;
        this.mUseColor = ((((i2 >>> 24) * (i + (i >> 7))) >> 8) << 24) | ((i2 << 8) >>> 8);
    }
}
