package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import defpackage.d;
import defpackage.gp;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ShadowDrawableWrapper extends gp {
    public static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    public final boolean addPaddingForCorners;
    public final RectF contentBounds;
    public final float cornerRadius;
    public final Paint cornerShadowPaint;
    public Path cornerShadowPath;
    public boolean dirty;
    public final Paint edgeShadowPaint;
    public final boolean printedShadowClipWarning;
    public final float rawMaxShadowSize;
    public final float rawShadowSize;
    public final int shadowEndColor;
    public final int shadowMiddleColor;
    public final float shadowSize;
    public final int shadowStartColor;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = context.getColor(R.color.cq);
        this.shadowMiddleColor = context.getColor(R.color.cp);
        this.shadowEndColor = context.getColor(R.color.co);
        Paint paint = new Paint(5);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.cornerRadius = Math.round(f);
        this.contentBounds = new RectF();
        Paint paint2 = new Paint(paint);
        this.edgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        if (f2 < 0.0f || f3 < 0.0f) {
            d.AnonymousClass0.m$2("invalid shadow size");
            throw null;
        }
        int iRound = Math.round(f2);
        float f4 = iRound % 2 == 1 ? iRound - 1 : iRound;
        int iRound2 = Math.round(f3);
        float f5 = iRound2 % 2 == 1 ? iRound2 - 1 : iRound2;
        if (f4 > f5) {
            this.printedShadowClipWarning = true;
            f4 = f5;
        }
        if (this.rawShadowSize == f4 && this.rawMaxShadowSize == f5) {
            return;
        }
        this.rawShadowSize = f4;
        this.rawMaxShadowSize = f5;
        this.shadowSize = Math.round(f4 * 1.5f);
        this.dirty = true;
        invalidateSelf();
    }

    @Override // defpackage.gp, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f;
        boolean z;
        boolean z2;
        float f2;
        float f3;
        float f4;
        int i;
        float f5;
        boolean z3;
        boolean z4 = this.dirty;
        float f6 = this.shadowSize;
        Paint paint = this.cornerShadowPaint;
        float f7 = this.cornerRadius;
        Paint paint2 = this.edgeShadowPaint;
        RectF rectF = this.contentBounds;
        if (z4) {
            Rect bounds = getBounds();
            z2 = true;
            float f8 = this.rawMaxShadowSize;
            float f9 = 1.5f * f8;
            f2 = 2.0f;
            f3 = 1.0f;
            rectF.set(bounds.left + f8, bounds.top + f9, bounds.right - f8, bounds.bottom - f9);
            this.mDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            float f10 = -f7;
            RectF rectF2 = new RectF(f10, f10, f7, f7);
            RectF rectF3 = new RectF(rectF2);
            float f11 = -f6;
            rectF3.inset(f11, f11);
            Path path = this.cornerShadowPath;
            if (path == null) {
                this.cornerShadowPath = new Path();
            } else {
                path.reset();
            }
            this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
            this.cornerShadowPath.moveTo(f10, 0.0f);
            this.cornerShadowPath.rLineTo(f11, 0.0f);
            this.cornerShadowPath.arcTo(rectF3, 180.0f, 90.0f, false);
            this.cornerShadowPath.arcTo(rectF2, 270.0f, -90.0f, false);
            this.cornerShadowPath.close();
            float f12 = -rectF3.top;
            int i2 = this.shadowEndColor;
            int i3 = this.shadowMiddleColor;
            int i4 = this.shadowStartColor;
            f = 0.0f;
            if (f12 > 0.0f) {
                float f13 = f7 / f12;
                z3 = false;
                paint.setShader(new RadialGradient(0.0f, 0.0f, f12, new int[]{0, i4, i3, i2}, new float[]{0.0f, f13, ((1.0f - f13) / 2.0f) + f13, 1.0f}, Shader.TileMode.CLAMP));
            } else {
                z3 = false;
            }
            paint2.setShader(new LinearGradient(0.0f, rectF2.top, 0.0f, rectF3.top, new int[]{i4, i3, i2}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            z = z3;
            paint2.setAntiAlias(z);
            this.dirty = z;
        } else {
            f = 0.0f;
            z = false;
            z2 = true;
            f2 = 2.0f;
            f3 = 1.0f;
        }
        int iSave = canvas.save();
        canvas.rotate(f, rectF.centerX(), rectF.centerY());
        float f14 = -f7;
        float f15 = f14 - f6;
        float f16 = f7 * f2;
        boolean z5 = rectF.width() - f16 > f ? z2 : z;
        if (rectF.height() - f16 <= f) {
            z2 = z;
        }
        float f17 = this.rawShadowSize;
        float f18 = f7 / ((f17 - (0.5f * f17)) + f7);
        float f19 = f7 / ((f17 - (0.25f * f17)) + f7);
        float f20 = f7 / ((f17 - (f17 * f3)) + f7);
        int iSave2 = canvas.save();
        canvas.translate(rectF.left + f7, rectF.top + f7);
        canvas.scale(f18, f19);
        canvas.drawPath(this.cornerShadowPath, paint);
        if (z5) {
            canvas.scale(f3 / f18, f3);
            i = iSave2;
            f4 = f15;
            canvas.drawRect(0.0f, f4, rectF.width() - f16, f14, paint2);
        } else {
            f4 = f15;
            i = iSave2;
        }
        canvas.restoreToCount(i);
        int iSave3 = canvas.save();
        canvas.translate(rectF.right - f7, rectF.bottom - f7);
        canvas.scale(f18, r18);
        canvas.rotate(180.0f);
        canvas.drawPath(this.cornerShadowPath, paint);
        if (z5) {
            canvas.scale(1.0f / f18, 1.0f);
            canvas.drawRect(0.0f, f4, rectF.width() - f16, f14 + f6, paint2);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(rectF.left + f7, rectF.bottom - f7);
        canvas.scale(f18, r18);
        canvas.rotate(270.0f);
        canvas.drawPath(this.cornerShadowPath, paint);
        if (z2) {
            canvas.scale(1.0f / f20, 1.0f);
            f5 = f14;
            canvas.drawRect(0.0f, f4, rectF.height() - f16, f5, paint2);
        } else {
            f5 = f14;
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        canvas.translate(rectF.right - f7, rectF.top + f7);
        canvas.scale(f18, f19);
        canvas.rotate(90.0f);
        canvas.drawPath(this.cornerShadowPath, paint);
        if (z2) {
            canvas.scale(1.0f / f19, 1.0f);
            canvas.drawRect(0.0f, f4, rectF.height() - f16, f5, paint2);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(iSave);
        super.draw(canvas);
    }

    @Override // defpackage.gp, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // defpackage.gp, android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        float f = this.rawMaxShadowSize * 1.5f;
        double d = COS_45;
        float f2 = this.cornerRadius;
        boolean z = this.addPaddingForCorners;
        if (z) {
            f = (float) (((1.0d - d) * ((double) f2)) + ((double) f));
        }
        int iCeil = (int) Math.ceil(f);
        float f3 = this.rawMaxShadowSize;
        if (z) {
            f3 = (float) (((1.0d - d) * ((double) f2)) + ((double) f3));
        }
        int iCeil2 = (int) Math.ceil(f3);
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    @Override // defpackage.gp, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    @Override // defpackage.gp, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        super.setAlpha(i);
        this.cornerShadowPaint.setAlpha(i);
        this.edgeShadowPaint.setAlpha(i);
    }
}
