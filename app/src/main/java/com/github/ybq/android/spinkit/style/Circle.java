package com.github.ybq.android.spinkit.style;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.sprite.SpriteContainer;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Circle extends SpriteContainer {
    public final /* synthetic */ int G0;

    @Override // com.github.ybq.android.spinkit.sprite.SpriteContainer
    public final void drawChild(Canvas canvas) {
        for (int i = 0; i < getChildCount(); i++) {
            Sprite childAt = getChildAt(i);
            int iSave = canvas.save();
            canvas.rotate((i * 360) / getChildCount(), getBounds().centerX(), getBounds().centerY());
            childAt.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // com.github.ybq.android.spinkit.sprite.SpriteContainer, com.github.ybq.android.spinkit.sprite.Sprite, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect rectClipSquare = Sprite.clipSquare(rect);
        int iWidth = (int) (((((double) rectClipSquare.width()) * 3.141592653589793d) / 3.5999999046325684d) / ((double) getChildCount()));
        int iCenterX = rectClipSquare.centerX() - iWidth;
        int iCenterX2 = rectClipSquare.centerX() + iWidth;
        for (int i = 0; i < getChildCount(); i++) {
            Sprite childAt = getChildAt(i);
            int i2 = rectClipSquare.top;
            childAt.setDrawBounds(iCenterX, i2, iCenterX2, (iWidth * 2) + i2);
        }
    }

    @Override // com.github.ybq.android.spinkit.sprite.SpriteContainer
    public final Sprite[] onCreateChild() {
        if (this.G0 != 0) {
            Pulse[] pulseArr = new Pulse[12];
            for (int i = 0; i < 12; i++) {
                Pulse pulse = new Pulse(4, false);
                pulse.setAlpha(0);
                pulseArr[i] = pulse;
                pulse.animationDelay = Build.VERSION.SDK_INT >= 24 ? i * 100 : (i * 100) - 1200;
            }
            return pulseArr;
        }
        Pulse[] pulseArr2 = new Pulse[12];
        for (int i2 = 0; i2 < 12; i2++) {
            Pulse pulse2 = new Pulse(2, false);
            pulse2.setScale(0.0f);
            pulseArr2[i2] = pulse2;
            pulse2.animationDelay = Build.VERSION.SDK_INT >= 24 ? i2 * 100 : (i2 * 100) - 1200;
        }
        return pulseArr2;
    }
}
