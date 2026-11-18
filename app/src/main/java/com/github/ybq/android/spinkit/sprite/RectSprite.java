package com.github.ybq.android.spinkit.sprite;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class RectSprite extends ShapeSprite {
    public final /* synthetic */ int G0;

    @Override // com.github.ybq.android.spinkit.sprite.ShapeSprite
    public final void drawShape(Canvas canvas, Paint paint) {
        int i = this.G0;
        Rect rect = this.drawBounds;
        if (i == 0) {
            if (rect != null) {
                canvas.drawRect(rect, paint);
            }
        } else if (rect != null) {
            canvas.drawCircle(this.drawBounds.centerX(), this.drawBounds.centerY(), Math.min(rect.width(), this.drawBounds.height()) / 2, paint);
        }
    }
}
