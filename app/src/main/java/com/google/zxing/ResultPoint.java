package com.google.zxing;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResultPoint {
    public final float x;
    public final float y;

    public ResultPoint(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float f = resultPoint.x;
        float f2 = resultPoint.y;
        float f3 = f - resultPoint2.x;
        float f4 = f2 - resultPoint2.y;
        return (float) Math.sqrt((f4 * f4) + (f3 * f3));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ResultPoint)) {
            return false;
        }
        ResultPoint resultPoint = (ResultPoint) obj;
        return this.x == resultPoint.x && this.y == resultPoint.y;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.y) + (Float.floatToIntBits(this.x) * 31);
    }

    public final String toString() {
        return "(" + this.x + ',' + this.y + ')';
    }
}
