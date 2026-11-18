package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.R;
import defpackage.b2;
import defpackage.fg1;
import defpackage.lm0;
import defpackage.qd1;
import defpackage.t20;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {
    public boolean drawBottomInsetForeground;
    public boolean drawTopInsetForeground;
    public final Drawable insetForeground;
    public Rect insets;
    public final Rect tempRect;

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tempRect = new Rect();
        this.drawTopInsetForeground = true;
        this.drawBottomInsetForeground = true;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i, org.hamotunnelplus.xyz.R.plurals.wk, new int[0]);
        this.insetForeground = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(true);
        lm0 lm0Var = new lm0() { // from class: com.google.android.material.internal.ScrimInsetsFrameLayout.1
            @Override // defpackage.lm0
            public final fg1 onApplyWindowInsets(View view, fg1 fg1Var) {
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                if (scrimInsetsFrameLayout.insets == null) {
                    scrimInsetsFrameLayout.insets = new Rect();
                }
                scrimInsetsFrameLayout.insets.set(fg1Var.b(), fg1Var.d(), fg1Var.c(), fg1Var.a());
                scrimInsetsFrameLayout.onInsetsChanged(fg1Var);
                fg1.k kVar = fg1Var.a;
                scrimInsetsFrameLayout.setWillNotDraw(kVar.j().equals(t20.e) || scrimInsetsFrameLayout.insetForeground == null);
                WeakHashMap weakHashMap = qd1.a;
                scrimInsetsFrameLayout.postInvalidateOnAnimation();
                return kVar.c();
            }
        };
        WeakHashMap weakHashMap = qd1.a;
        b2.u(this, lm0Var);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.insets == null || (drawable = this.insetForeground) == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        boolean z = this.drawTopInsetForeground;
        Rect rect = this.tempRect;
        if (z) {
            rect.set(0, 0, width, this.insets.top);
            drawable.setBounds(rect);
            drawable.draw(canvas);
        }
        if (this.drawBottomInsetForeground) {
            rect.set(0, height - this.insets.bottom, width, height);
            drawable.setBounds(rect);
            drawable.draw(canvas);
        }
        Rect rect2 = this.insets;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        drawable.setBounds(rect);
        drawable.draw(canvas);
        Rect rect3 = this.insets;
        rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void onInsetsChanged(fg1 fg1Var) {
    }
}
