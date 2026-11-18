package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class c6 extends g {
    public final b6 d;
    public Drawable e;
    public ColorStateList f;
    public PorterDuff.Mode g;
    public boolean h;
    public boolean i;

    public c6(b6 b6Var) {
        super(27, (Object) b6Var, false);
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.d = b6Var;
    }

    @Override // defpackage.g
    public final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, R.style.zo);
        b6 b6Var = this.d;
        Context context = b6Var.getContext();
        int[] iArr = b2.g;
        m6 m6VarM = m6.m(context, attributeSet, iArr, R.style.zo);
        TypedArray typedArray = (TypedArray) m6VarM.a;
        qd1.k(b6Var, b6Var.getContext(), iArr, attributeSet, (TypedArray) m6VarM.a, R.style.zo);
        Drawable drawableF = m6VarM.f(0);
        if (drawableF != null) {
            b6Var.setThumb(drawableF);
        }
        Drawable drawableE = m6VarM.e(1);
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.e = drawableE;
        if (drawableE != null) {
            drawableE.setCallback(b6Var);
            drawableE.setLayoutDirection(b6Var.getLayoutDirection());
            if (drawableE.isStateful()) {
                drawableE.setState(b6Var.getDrawableState());
            }
            c();
        }
        b6Var.invalidate();
        if (typedArray.hasValue(3)) {
            this.g = fp.d(typedArray.getInt(3, -1), this.g);
            this.i = true;
        }
        if (typedArray.hasValue(2)) {
            this.f = m6VarM.b(2);
            this.h = true;
        }
        m6VarM.n();
        c();
    }

    public final void c() {
        Drawable drawable = this.e;
        if (drawable != null) {
            if (this.h || this.i) {
                Drawable drawableMutate = drawable.mutate();
                this.e = drawableMutate;
                if (this.h) {
                    drawableMutate.setTintList(this.f);
                }
                if (this.i) {
                    this.e.setTintMode(this.g);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.d.getDrawableState());
                }
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.e != null) {
            b6 b6Var = this.d;
            int max = b6Var.getMax();
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.e.setBounds(-i, -i2, i, i2);
                float width = ((b6Var.getWidth() - b6Var.getPaddingLeft()) - b6Var.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(b6Var.getPaddingLeft(), b6Var.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
