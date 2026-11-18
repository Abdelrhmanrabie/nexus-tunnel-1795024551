package com.github.ybq.android.spinkit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.Pulse;
import com.github.ybq.android.spinkit.style.PulseRing;
import com.github.ybq.android.spinkit.style.RotatingPlane;
import com.github.ybq.android.spinkit.style.Wave;
import defpackage.d;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SpinKitView extends ProgressBar {
    public final int mColor;
    public Sprite mSprite;

    public SpinKitView(Context context) {
        this(context, null);
    }

    public SpinKitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.d);
    }

    public SpinKitView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.plurals.kc);
    }

    public SpinKitView(Context context, AttributeSet attributeSet, int i, int i2) {
        Sprite rotatingPlane;
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SpinKitView, i, i2);
        Style style = Style.values()[typedArrayObtainStyledAttributes.getInt(1, 0)];
        int color = typedArrayObtainStyledAttributes.getColor(0, -1);
        this.mColor = color;
        typedArrayObtainStyledAttributes.recycle();
        switch (style.ordinal()) {
            case 0:
                rotatingPlane = new RotatingPlane(0);
                break;
            case 1:
                rotatingPlane = new Wave(3);
                break;
            case 2:
                rotatingPlane = new Wave(0);
                break;
            case 3:
                rotatingPlane = new Wave(8);
                break;
            case 4:
                rotatingPlane = new Pulse(0);
                break;
            case 5:
                rotatingPlane = new Wave(1);
                break;
            case 6:
                rotatingPlane = new Wave(7);
                break;
            case 7:
                rotatingPlane = new Circle(0);
                break;
            case 8:
                rotatingPlane = new Wave(2);
                break;
            case 9:
                rotatingPlane = new Circle(1);
                break;
            case 10:
                rotatingPlane = new Wave(4);
                break;
            case 11:
                rotatingPlane = new Pulse(5, false);
                break;
            case 12:
                rotatingPlane = new Wave(5);
                break;
            case 13:
                rotatingPlane = new PulseRing();
                break;
            case 14:
                rotatingPlane = new Wave(6);
                break;
            default:
                rotatingPlane = null;
                break;
        }
        rotatingPlane.setColor(color);
        setIndeterminateDrawable(rotatingPlane);
        setIndeterminate(true);
    }

    @Override // android.widget.ProgressBar
    public final Drawable getIndeterminateDrawable() {
        return this.mSprite;
    }

    @Override // android.view.View
    public final void onScreenStateChanged(int i) {
        Sprite sprite;
        super.onScreenStateChanged(i);
        if (i != 0 || (sprite = this.mSprite) == null) {
            return;
        }
        sprite.stop();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.mSprite != null && getVisibility() == 0) {
            this.mSprite.start();
        }
    }

    @Override // android.widget.ProgressBar
    public final void setIndeterminateDrawable(Drawable drawable) {
        if (drawable instanceof Sprite) {
            setIndeterminateDrawable((Sprite) drawable);
        } else {
            d.AnonymousClass0.m$2("this d must be instanceof Sprite");
        }
    }

    public final void setIndeterminateDrawable(Sprite sprite) {
        super.setIndeterminateDrawable((Drawable) sprite);
        this.mSprite = sprite;
        if (sprite.getColor() == 0) {
            this.mSprite.setColor(this.mColor);
        }
        onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
        if (getVisibility() == 0) {
            this.mSprite.start();
        }
    }

    @Override // android.view.View
    public final void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        if (drawable instanceof Sprite) {
            ((Sprite) drawable).stop();
        }
    }
}
