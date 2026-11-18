package com.github.mikephil.charting.utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class FSize extends ObjectPool.Poolable {
    public static final ObjectPool pool;
    public float width = 0.0f;
    public float height = 0.0f;

    static {
        ObjectPool objectPoolCreate = ObjectPool.create(256, new FSize());
        pool = objectPoolCreate;
        objectPoolCreate.replenishPercentage = 0.5f;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FSize)) {
            return false;
        }
        FSize fSize = (FSize) obj;
        return this.width == fSize.width && this.height == fSize.height;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.width) ^ Float.floatToIntBits(this.height);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public final ObjectPool.Poolable instantiate() {
        return new FSize();
    }

    public final String toString() {
        return this.width + "x" + this.height;
    }
}
