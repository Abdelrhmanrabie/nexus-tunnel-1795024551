package com.github.ybq.android.spinkit.style;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;
import com.github.ybq.android.spinkit.sprite.RectSprite;
import com.github.ybq.android.spinkit.sprite.Sprite;
import defpackage.z20;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class RotatingPlane extends RectSprite {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RotatingPlane(int i) {
        super(0);
        this.G0 = i;
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        if (this.G0 != 0) {
            super.onBoundsChange(rect);
        } else {
            Rect rectClipSquare = Sprite.clipSquare(rect);
            setDrawBounds(rectClipSquare.left, rectClipSquare.top, rectClipSquare.right, rectClipSquare.bottom);
        }
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite
    public final ValueAnimator onCreateAnimation() {
        int i = this.G0;
        Sprite.AnonymousClass1 anonymousClass1 = Sprite.ROTATE_Y;
        Sprite.AnonymousClass1 anonymousClass2 = Sprite.ROTATE_X;
        Float fValueOf = Float.valueOf(1.0f);
        if (i == 0) {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            z20 z20Var = new z20(this);
            z20Var.holder(fArr, anonymousClass2, new Integer[]{0, -180, -180});
            z20Var.holder(fArr, anonymousClass1, new Integer[]{0, 0, -180});
            z20Var.a = 1200L;
            z20Var.easeInOut(fArr);
            return z20Var.build();
        }
        if (i == 1) {
            float[] fArr2 = {0.0f, 0.35f, 0.7f, 1.0f};
            z20 z20Var2 = new z20(this);
            z20Var2.holder(fArr2, Sprite.SCALE, new Float[]{fValueOf, Float.valueOf(0.0f), fValueOf, fValueOf});
            z20Var2.a = 1300L;
            z20Var2.easeInOut(fArr2);
            return z20Var2.build();
        }
        if (i != 2) {
            float[] fArr3 = {0.0f, 0.2f, 0.4f, 1.0f};
            z20 z20Var3 = new z20(this);
            Float fValueOf2 = Float.valueOf(0.4f);
            z20Var3.holder(fArr3, Sprite.SCALE_Y, new Float[]{fValueOf2, fValueOf, fValueOf2, fValueOf2});
            z20Var3.a = 1200L;
            z20Var3.easeInOut(fArr3);
            return z20Var3.build();
        }
        float[] fArr4 = {0.0f, 0.1f, 0.25f, 0.75f, 0.9f, 1.0f};
        z20 z20Var4 = new z20(this);
        z20Var4.holder(fArr4, Sprite.ALPHA, new Integer[]{0, 0, 255, 255, 0, 0});
        z20Var4.holder(fArr4, anonymousClass2, new Integer[]{-180, -180, 0, 0, 0, 0});
        z20Var4.holder(fArr4, anonymousClass1, new Integer[]{0, 0, 0, 0, 180, 180});
        z20Var4.a = 2400L;
        z20Var4.c = new LinearInterpolator();
        return z20Var4.build();
    }
}
