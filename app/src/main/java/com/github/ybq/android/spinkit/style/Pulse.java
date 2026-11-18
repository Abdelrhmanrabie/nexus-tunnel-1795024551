package com.github.ybq.android.spinkit.style;

import android.animation.ValueAnimator;
import com.github.ybq.android.spinkit.sprite.RectSprite;
import com.github.ybq.android.spinkit.sprite.Sprite;
import defpackage.z20;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Pulse extends RectSprite {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pulse(int i) {
        super(1);
        this.G0 = i;
        if (i == 1 || i != 3) {
            super(1);
        } else {
            setAlpha(153);
        }
        setScale(0.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Pulse(int i, boolean z) {
        super(1);
        this.G0 = i;
    }

    @Override // com.github.ybq.android.spinkit.sprite.Sprite
    public final ValueAnimator onCreateAnimation() {
        int i = this.G0;
        Sprite.AnonymousClass1 anonymousClass1 = Sprite.ALPHA;
        Sprite.AnonymousClass6 anonymousClass6 = Sprite.SCALE;
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        if (i == 0) {
            float[] fArr = {0.0f, 1.0f};
            z20 z20Var = new z20(this);
            z20Var.holder(fArr, anonymousClass6, new Float[]{fValueOf2, fValueOf});
            z20Var.holder(fArr, anonymousClass1, new Integer[]{255, 0});
            z20Var.a = 1000L;
            z20Var.easeInOut(fArr);
            return z20Var.build();
        }
        if (i == 1) {
            float[] fArr2 = {0.0f, 0.5f, 1.0f};
            z20 z20Var2 = new z20(this);
            z20Var2.holder(fArr2, anonymousClass6, new Float[]{fValueOf2, fValueOf, fValueOf2});
            z20Var2.a = 2000L;
            z20Var2.easeInOut(fArr2);
            return z20Var2.build();
        }
        if (i == 2) {
            float[] fArr3 = {0.0f, 0.5f, 1.0f};
            z20 z20Var3 = new z20(this);
            z20Var3.holder(fArr3, anonymousClass6, new Float[]{fValueOf2, fValueOf, fValueOf2});
            z20Var3.a = 1200L;
            z20Var3.easeInOut(fArr3);
            return z20Var3.build();
        }
        if (i == 3) {
            float[] fArr4 = {0.0f, 0.5f, 1.0f};
            z20 z20Var4 = new z20(this);
            z20Var4.holder(fArr4, anonymousClass6, new Float[]{fValueOf2, fValueOf, fValueOf2});
            z20Var4.a = 2000L;
            z20Var4.easeInOut(fArr4);
            return z20Var4.build();
        }
        if (i == 4) {
            float[] fArr5 = {0.0f, 0.39f, 0.4f, 1.0f};
            z20 z20Var5 = new z20(this);
            z20Var5.holder(fArr5, anonymousClass1, new Integer[]{0, 0, 255, 0});
            z20Var5.a = 1200L;
            z20Var5.easeInOut(fArr5);
            return z20Var5.build();
        }
        if (i != 5) {
            float[] fArr6 = {0.0f, 0.4f, 0.8f, 1.0f};
            z20 z20Var6 = new z20(this);
            z20Var6.holder(fArr6, anonymousClass6, new Float[]{fValueOf2, fValueOf, fValueOf2, fValueOf2});
            z20Var6.a = 1400L;
            z20Var6.easeInOut(fArr6);
            return z20Var6.build();
        }
        float[] fArr7 = {0.0f, 0.5f, 1.0f};
        z20 z20Var7 = new z20(this);
        z20Var7.holder(fArr7, Sprite.ROTATE_X, new Integer[]{0, -180, -180});
        z20Var7.holder(fArr7, Sprite.ROTATE_Y, new Integer[]{0, 0, -180});
        z20Var7.a = 1200L;
        z20Var7.easeInOut(fArr7);
        return z20Var7.build();
    }
}
