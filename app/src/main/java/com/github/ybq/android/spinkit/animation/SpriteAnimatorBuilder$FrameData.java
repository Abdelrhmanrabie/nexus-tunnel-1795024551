package com.github.ybq.android.spinkit.animation;

import android.util.Property;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class SpriteAnimatorBuilder$FrameData {
    public final float[] fractions;
    public final Property property;
    public final Object[] values;

    public SpriteAnimatorBuilder$FrameData(float[] fArr, Property property, Object[] objArr) {
        this.fractions = fArr;
        this.property = property;
        this.values = objArr;
    }
}
