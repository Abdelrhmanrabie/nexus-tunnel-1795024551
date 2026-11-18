package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;
import defpackage.d;
import defpackage.e;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    public float cradleVerticalOffset;
    public float fabCornerSize = -1.0f;
    public float fabDiameter;
    public final float fabMargin;
    public float horizontalOffset;
    public final float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f2, float f3) {
        this.fabMargin = f;
        this.roundedCornerRadius = f2;
        if (f3 < 0.0f) {
            d.AnonymousClass0.m$2("cradleVerticalOffset must be positive.");
            throw null;
        }
        this.cradleVerticalOffset = f3;
        this.horizontalOffset = 0.0f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public final void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        float f4;
        float f5;
        float f6;
        float f7;
        ShapePath shapePath2;
        float f8;
        float f9;
        float f10;
        float f11 = this.fabDiameter;
        if (f11 == 0.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f12 = this.fabMargin;
        float f13 = ((f12 * 2.0f) + f11) / 2.0f;
        float f14 = f3 * this.roundedCornerRadius;
        float f15 = f2 + this.horizontalOffset;
        float fA = e.a(1.0f, f3, f13, this.cradleVerticalOffset * f3);
        if (fA / f13 >= 1.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f16 = this.fabCornerSize;
        float f17 = f16 * f3;
        boolean z = f16 == -1.0f || Math.abs((f16 * 2.0f) - f11) < 0.1f;
        if (z) {
            f4 = fA;
            f5 = 0.0f;
        } else {
            f5 = 1.75f;
            f4 = 0.0f;
        }
        float f18 = f13 + f14;
        float f19 = f4 + f14;
        float fSqrt = (float) Math.sqrt((f18 * f18) - (f19 * f19));
        float f20 = f15 - fSqrt;
        float f21 = f15 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f19));
        float f22 = 90.0f;
        float f23 = (90.0f - degrees) + f5;
        shapePath.lineTo(f20, 0.0f);
        float f24 = f20 - f14;
        float f25 = f20 + f14;
        float f26 = f14 * 2.0f;
        shapePath.addArc(f24, 0.0f, f25, f26, 270.0f, degrees);
        if (z) {
            f9 = f15 - f13;
            f7 = (-f13) - f4;
            f8 = f15 + f13;
            f22 = 180.0f - f23;
            f10 = (f23 * 2.0f) - 180.0f;
            shapePath2 = shapePath;
            f6 = f13 - f4;
        } else {
            float f27 = (f17 * 2.0f) + f12;
            float f28 = f15 - f13;
            f6 = f17 + f12;
            f7 = -f6;
            shapePath2 = shapePath;
            shapePath2.addArc(f28, f7, f27 + f28, f6, 180.0f - f23, ((f23 * 2.0f) - 180.0f) / 2.0f);
            f8 = f15 + f13;
            shapePath2.lineTo(f8 - ((f12 / 2.0f) + f17), f6);
            f9 = f8 - f27;
            f10 = f23 - 90.0f;
        }
        shapePath2.addArc(f9, f7, f8, f6, f22, f10);
        shapePath.addArc(f21 - f14, 0.0f, f21 + f14, f26, 270.0f - degrees, degrees);
        shapePath.lineTo(f, 0.0f);
    }
}
