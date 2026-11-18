package com.github.ybq.android.spinkit.style;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.animation.LinearInterpolator;
import com.github.ybq.android.spinkit.sprite.RectSprite;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.sprite.SpriteContainer;
import defpackage.z20;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Wave extends SpriteContainer {
    public final /* synthetic */ int G0;

    @Override // com.github.ybq.android.spinkit.sprite.SpriteContainer
    public void drawChild(Canvas canvas) {
        if (this.G0 != 4) {
            super.drawChild(canvas);
            return;
        }
        Rect rectClipSquare = Sprite.clipSquare(getBounds());
        for (int i = 0; i < getChildCount(); i++) {
            int iSave = canvas.save();
            canvas.rotate((i * 90) + 45, rectClipSquare.centerX(), rectClipSquare.centerY());
            getChildAt(i).draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // com.github.ybq.android.spinkit.sprite.SpriteContainer, com.github.ybq.android.spinkit.sprite.Sprite, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i = this.G0;
        int i2 = 0;
        if (i == 0) {
            super.onBoundsChange(rect);
            Rect rectClipSquare = Sprite.clipSquare(rect);
            int iWidth = rectClipSquare.width() / getChildCount();
            int iWidth2 = ((rectClipSquare.width() / 5) * 3) / 5;
            while (i2 < getChildCount()) {
                Sprite childAt = getChildAt(i2);
                int i3 = (iWidth / 5) + (i2 * iWidth) + rectClipSquare.left;
                childAt.setDrawBounds(i3, rectClipSquare.top, i3 + iWidth2, rectClipSquare.bottom);
                i2++;
            }
            return;
        }
        if (i == 1) {
            super.onBoundsChange(rect);
            Rect rectClipSquare2 = Sprite.clipSquare(rect);
            int iWidth3 = (int) (rectClipSquare2.width() * 0.6f);
            Sprite childAt2 = getChildAt(0);
            int i4 = rectClipSquare2.right;
            int i5 = rectClipSquare2.top;
            childAt2.setDrawBounds(i4 - iWidth3, i5, i4, i5 + iWidth3);
            Sprite childAt3 = getChildAt(1);
            int i6 = rectClipSquare2.right;
            int i7 = rectClipSquare2.bottom;
            childAt3.setDrawBounds(i6 - iWidth3, i7 - iWidth3, i6, i7);
            return;
        }
        if (i == 2) {
            super.onBoundsChange(rect);
            Rect rectClipSquare3 = Sprite.clipSquare(rect);
            int iWidth4 = (int) (rectClipSquare3.width() * 0.33f);
            int iHeight = (int) (rectClipSquare3.height() * 0.33f);
            while (i2 < getChildCount()) {
                int i8 = ((i2 % 3) * iWidth4) + rectClipSquare3.left;
                int i9 = ((i2 / 3) * iHeight) + rectClipSquare3.top;
                getChildAt(i2).setDrawBounds(i8, i9, i8 + iWidth4, i9 + iHeight);
                i2++;
            }
            return;
        }
        if (i == 4) {
            super.onBoundsChange(rect);
            Rect rectClipSquare4 = Sprite.clipSquare(rect);
            int iMin = Math.min(rectClipSquare4.width(), rectClipSquare4.height()) / 2;
            int i10 = rectClipSquare4.left + iMin + 1;
            int i11 = rectClipSquare4.top + iMin + 1;
            while (i2 < getChildCount()) {
                Sprite childAt4 = getChildAt(i2);
                childAt4.setDrawBounds(rectClipSquare4.left, rectClipSquare4.top, i10, i11);
                Rect rect2 = childAt4.drawBounds;
                childAt4.pivotX = rect2.right;
                childAt4.pivotY = rect2.bottom;
                i2++;
            }
            return;
        }
        if (i == 7) {
            super.onBoundsChange(rect);
            Rect rectClipSquare5 = Sprite.clipSquare(rect);
            int iWidth5 = rectClipSquare5.width() / 8;
            int iCenterY = rectClipSquare5.centerY() - iWidth5;
            int iCenterY2 = rectClipSquare5.centerY() + iWidth5;
            while (i2 < getChildCount()) {
                int iWidth6 = ((rectClipSquare5.width() * i2) / 3) + rectClipSquare5.left;
                getChildAt(i2).setDrawBounds(iWidth6, iCenterY, (iWidth5 * 2) + iWidth6, iCenterY2);
                i2++;
            }
            return;
        }
        if (i != 8) {
            super.onBoundsChange(rect);
            return;
        }
        Rect rectClipSquare6 = Sprite.clipSquare(rect);
        super.onBoundsChange(rectClipSquare6);
        while (i2 < getChildCount()) {
            Sprite childAt5 = getChildAt(i2);
            int i12 = rectClipSquare6.left;
            childAt5.setDrawBounds(i12, rectClipSquare6.top, (rectClipSquare6.width() / 4) + i12, (rectClipSquare6.height() / 4) + rectClipSquare6.top);
            i2++;
        }
    }

    @Override // com.github.ybq.android.spinkit.sprite.SpriteContainer
    public void onChildCreated(Sprite... spriteArr) {
        Sprite sprite;
        Sprite sprite2;
        Sprite sprite3;
        int i;
        int i2 = this.G0;
        int i3 = -1000;
        if (i2 == 1) {
            if (Build.VERSION.SDK_INT >= 24) {
                sprite = spriteArr[1];
                i3 = 1000;
            } else {
                sprite = spriteArr[1];
            }
            sprite.animationDelay = i3;
            return;
        }
        if (i2 == 3) {
            if (Build.VERSION.SDK_INT >= 24) {
                sprite2 = spriteArr[1];
                i3 = 1000;
            } else {
                sprite2 = spriteArr[1];
            }
            sprite2.animationDelay = i3;
            return;
        }
        int i4 = 0;
        if (i2 == 5) {
            while (i4 < spriteArr.length) {
                Sprite sprite4 = spriteArr[i4];
                i4++;
                sprite4.animationDelay = i4 * 200;
            }
            return;
        }
        if (i2 == 6) {
            while (i4 < spriteArr.length) {
                Sprite sprite5 = spriteArr[i4];
                i4++;
                sprite5.animationDelay = i4 * 200;
            }
            return;
        }
        if (i2 == 7) {
            spriteArr[1].animationDelay = 160;
            sprite3 = spriteArr[2];
            i = 320;
        } else {
            if (i2 != 8 || Build.VERSION.SDK_INT >= 24) {
                return;
            }
            sprite3 = spriteArr[1];
            i = -900;
        }
        sprite3.animationDelay = i;
    }

    @Override // com.github.ybq.android.spinkit.sprite.SpriteContainer, com.github.ybq.android.spinkit.sprite.Sprite
    public ValueAnimator onCreateAnimation() {
        if (this.G0 != 1) {
            return super.onCreateAnimation();
        }
        z20 z20Var = new z20(this);
        z20Var.holder(new float[]{0.0f, 1.0f}, Sprite.ROTATE, new Integer[]{0, 360});
        z20Var.a = 2000L;
        z20Var.c = new LinearInterpolator();
        return z20Var.build();
    }

    @Override // com.github.ybq.android.spinkit.sprite.SpriteContainer
    public final Sprite[] onCreateChild() {
        final int i = 3;
        final int i2 = 0;
        switch (this.G0) {
            case 0:
                RotatingPlane[] rotatingPlaneArr = new RotatingPlane[5];
                while (i2 < 5) {
                    RotatingPlane rotatingPlane = new RotatingPlane(3);
                    rotatingPlane.scaleY = 0.4f;
                    rotatingPlaneArr[i2] = rotatingPlane;
                    rotatingPlane.animationDelay = Build.VERSION.SDK_INT >= 24 ? (i2 * 100) + 600 : (i2 * 100) - 1200;
                    i2++;
                }
                return rotatingPlaneArr;
            case 1:
                return new Sprite[]{new Pulse(1), new Pulse(1)};
            case 2:
                int[] iArr = {200, 300, 400, 100, 200, 300, 0, 100, 200};
                RotatingPlane[] rotatingPlaneArr2 = new RotatingPlane[9];
                while (i2 < 9) {
                    RotatingPlane rotatingPlane2 = new RotatingPlane(1);
                    rotatingPlaneArr2[i2] = rotatingPlane2;
                    rotatingPlane2.animationDelay = iArr[i2];
                    i2++;
                }
                return rotatingPlaneArr2;
            case 3:
                return new Sprite[]{new Pulse(3), new Pulse(3)};
            case 4:
                RotatingPlane[] rotatingPlaneArr3 = new RotatingPlane[4];
                for (int i3 = 0; i3 < 4; i3++) {
                    RotatingPlane rotatingPlane3 = new RotatingPlane(2);
                    rotatingPlane3.setAlpha(0);
                    rotatingPlane3.rotateX = -180;
                    rotatingPlaneArr3[i3] = rotatingPlane3;
                    rotatingPlane3.animationDelay = Build.VERSION.SDK_INT >= 24 ? i3 * 300 : (i3 * 300) - 1200;
                }
                return rotatingPlaneArr3;
            case 5:
                return new Sprite[]{new Pulse(0), new Pulse(0), new Pulse(0)};
            case 6:
                return new Sprite[]{new PulseRing(), new PulseRing(), new PulseRing()};
            case 7:
                return new Sprite[]{new Pulse(6), new Pulse(6), new Pulse(6)};
            default:
                return new Sprite[]{new RectSprite(i2) { // from class: com.github.ybq.android.spinkit.style.WanderingCubes$Cube
                    public final int startFrame;

                    {
                        super(0);
                        this.startFrame = i2;
                    }

                    @Override // com.github.ybq.android.spinkit.sprite.Sprite
                    public final ValueAnimator onCreateAnimation() {
                        float[] fArr = {0.0f, 0.25f, 0.5f, 0.51f, 0.75f, 1.0f};
                        z20 z20Var = new z20(this);
                        z20Var.holder(fArr, Sprite.ROTATE, new Integer[]{0, -90, -179, -180, -270, -360});
                        Float fValueOf = Float.valueOf(0.0f);
                        Float fValueOf2 = Float.valueOf(0.75f);
                        z20Var.holder(fArr, Sprite.TRANSLATE_X_PERCENTAGE, new Float[]{fValueOf, fValueOf2, fValueOf2, fValueOf2, fValueOf, fValueOf});
                        z20Var.holder(fArr, Sprite.TRANSLATE_Y_PERCENTAGE, new Float[]{fValueOf, fValueOf, fValueOf2, fValueOf2, fValueOf2, fValueOf});
                        Float fValueOf3 = Float.valueOf(1.0f);
                        Float fValueOf4 = Float.valueOf(0.5f);
                        z20Var.holder(fArr, Sprite.SCALE, new Float[]{fValueOf3, fValueOf4, fValueOf3, fValueOf3, fValueOf4, fValueOf3});
                        z20Var.a = 1800L;
                        z20Var.easeInOut(fArr);
                        if (Build.VERSION.SDK_INT >= 24) {
                            int i4 = this.startFrame;
                            z20Var.e = i4 >= 0 ? i4 : 0;
                        }
                        return z20Var.build();
                    }
                }, new RectSprite(i) { // from class: com.github.ybq.android.spinkit.style.WanderingCubes$Cube
                    public final int startFrame;

                    {
                        super(0);
                        this.startFrame = i;
                    }

                    @Override // com.github.ybq.android.spinkit.sprite.Sprite
                    public final ValueAnimator onCreateAnimation() {
                        float[] fArr = {0.0f, 0.25f, 0.5f, 0.51f, 0.75f, 1.0f};
                        z20 z20Var = new z20(this);
                        z20Var.holder(fArr, Sprite.ROTATE, new Integer[]{0, -90, -179, -180, -270, -360});
                        Float fValueOf = Float.valueOf(0.0f);
                        Float fValueOf2 = Float.valueOf(0.75f);
                        z20Var.holder(fArr, Sprite.TRANSLATE_X_PERCENTAGE, new Float[]{fValueOf, fValueOf2, fValueOf2, fValueOf2, fValueOf, fValueOf});
                        z20Var.holder(fArr, Sprite.TRANSLATE_Y_PERCENTAGE, new Float[]{fValueOf, fValueOf, fValueOf2, fValueOf2, fValueOf2, fValueOf});
                        Float fValueOf3 = Float.valueOf(1.0f);
                        Float fValueOf4 = Float.valueOf(0.5f);
                        z20Var.holder(fArr, Sprite.SCALE, new Float[]{fValueOf3, fValueOf4, fValueOf3, fValueOf3, fValueOf4, fValueOf3});
                        z20Var.a = 1800L;
                        z20Var.easeInOut(fArr);
                        if (Build.VERSION.SDK_INT >= 24) {
                            int i4 = this.startFrame;
                            z20Var.e = i4 >= 0 ? i4 : 0;
                        }
                        return z20Var.build();
                    }
                }};
        }
    }
}
