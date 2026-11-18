package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hp extends Drawable {
    public static final float m = (float) Math.toRadians(45.0d);
    public final Paint a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final boolean f;
    public final Path g;
    public final int h;
    public boolean i;
    public float j;
    public final float k;
    public final int l;

    public hp(Context context) {
        Paint paint = new Paint();
        this.a = paint;
        this.g = new Path();
        this.i = false;
        this.l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, b2.n, R.style.jz, R.plurals.f1);
        int color = typedArrayObtainStyledAttributes.getColor(3, 0);
        if (color != paint.getColor()) {
            paint.setColor(color);
            invalidateSelf();
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(7, 0.0f);
        if (paint.getStrokeWidth() != dimension) {
            paint.setStrokeWidth(dimension);
            this.k = (float) (Math.cos(m) * ((double) (dimension / 2.0f)));
            invalidateSelf();
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(6, true);
        if (this.f != z) {
            this.f = z;
            invalidateSelf();
        }
        float fRound = Math.round(typedArrayObtainStyledAttributes.getDimension(5, 0.0f));
        if (fRound != this.e) {
            this.e = fRound;
            invalidateSelf();
        }
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.c = Math.round(typedArrayObtainStyledAttributes.getDimension(2, 0.0f));
        this.b = Math.round(typedArrayObtainStyledAttributes.getDimension(0, 0.0f));
        this.d = typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = this.l;
        boolean z = i != 0 && (i == 1 || (i == 3 ? getLayoutDirection() == 0 : getLayoutDirection() == 1));
        float f = this.b;
        float fSqrt = (float) Math.sqrt(f * f * 2.0f);
        float f2 = this.j;
        float f3 = this.c;
        float fA = e.a(fSqrt, f3, f2, f3);
        float fA2 = e.a(this.d, f3, f2, f3);
        float f4 = this.k;
        float fRound = Math.round(((f4 - 0.0f) * f2) + 0.0f);
        float f5 = this.j;
        float fA3 = e.a(m, 0.0f, f5, 0.0f);
        float f6 = z ? 0.0f : -180.0f;
        float fA4 = e.a(z ? 180.0f : 0.0f, f6, f5, f6);
        double d = fA;
        double d2 = fA3;
        float fRound2 = Math.round(Math.cos(d2) * d);
        float fRound3 = Math.round(Math.sin(d2) * d);
        Path path = this.g;
        path.rewind();
        Paint paint = this.a;
        float strokeWidth = paint.getStrokeWidth();
        float f7 = this.e;
        float f8 = strokeWidth + f7;
        float fA5 = e.a(-f4, f8, this.j, f8);
        float f9 = (-fA2) / 2.0f;
        path.moveTo(f9 + fRound, 0.0f);
        path.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        path.moveTo(f9, fA5);
        path.rLineTo(fRound2, fRound3);
        path.moveTo(f9, -fA5);
        path.rLineTo(fRound2, -fRound3);
        path.close();
        canvas.save();
        float strokeWidth2 = paint.getStrokeWidth();
        canvas.translate(bounds.centerX(), (strokeWidth2 * 1.5f) + f7 + ((((int) ((bounds.height() - (3.0f * strokeWidth2)) - (f7 * 2.0f))) / 4) * 2));
        if (this.f) {
            canvas.rotate(fA4 * (this.i ^ z ? -1 : 1));
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Paint paint = this.a;
        if (i != paint.getAlpha()) {
            paint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
