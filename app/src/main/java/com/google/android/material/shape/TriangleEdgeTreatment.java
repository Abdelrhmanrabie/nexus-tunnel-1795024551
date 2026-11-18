package com.google.android.material.shape;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    public final boolean inside;
    public final float size;

    public TriangleEdgeTreatment(float f, boolean z) {
        this.size = f;
        this.inside = z;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public final void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        float f4 = this.size;
        float f5 = f4 * f3;
        shapePath.lineTo(f2 - f5, 0.0f);
        if (!this.inside) {
            f4 = -f4;
        }
        shapePath.lineTo(f2, f4 * f3);
        shapePath.lineTo(f5 + f2, 0.0f);
        shapePath.lineTo(f, 0.0f);
    }
}
