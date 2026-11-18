package com.github.ybq.android.spinkit.sprite;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.google.crypto.tink.subtle.Hex;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class SpriteContainer extends Sprite {
    public int color;
    public final Sprite[] sprites;

    public SpriteContainer() {
        Sprite[] spriteArrOnCreateChild = onCreateChild();
        this.sprites = spriteArrOnCreateChild;
        for (Sprite sprite : spriteArrOnCreateChild) {
            sprite.setCallback(this);
        }
        onChildCreated(this.sprites);
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        drawChild(canvas);
    }

    public void drawChild(Canvas canvas) {
        Sprite[] spriteArr = this.sprites;
        if (spriteArr != null) {
            for (Sprite sprite : spriteArr) {
                int iSave = canvas.save();
                sprite.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite
    public final void drawSelf(Canvas canvas) {
    }

    public final Sprite getChildAt(int i) {
        Sprite[] spriteArr = this.sprites;
        if (spriteArr == null) {
            return null;
        }
        return spriteArr[i];
    }

    public final int getChildCount() {
        Sprite[] spriteArr = this.sprites;
        if (spriteArr == null) {
            return 0;
        }
        return spriteArr.length;
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite
    public final int getColor() {
        return this.color;
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return Hex.isRunning(this.sprites) || super.isRunning();
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        for (Sprite sprite : this.sprites) {
            sprite.setBounds(rect);
        }
    }

    public void onChildCreated(Sprite... spriteArr) {
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite
    public ValueAnimator onCreateAnimation() {
        return null;
    }

    public abstract Sprite[] onCreateChild();

    @Override // com.github.ybq.android.spinkit.sprite.Sprite
    public final void setColor(int i) {
        this.color = i;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).setColor(i);
        }
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite, android.graphics.drawable.Animatable
    public final void start() {
        super.start();
        for (Sprite sprite : this.sprites) {
            sprite.start();
        }
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite, android.graphics.drawable.Animatable
    public final void stop() {
        super.stop();
        for (Sprite sprite : this.sprites) {
            sprite.stop();
        }
    }
}
