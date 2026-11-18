package com.google.android.material.transition.platform;

import android.graphics.Path;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class MaskEvaluator {
    public ShapeAppearanceModel currentShapeAppearanceModel;
    public final Path path = new Path();
    public final Path startPath = new Path();
    public final Path endPath = new Path();
    public final ShapeAppearancePathProvider pathProvider = ShapeAppearancePathProvider.getInstance();
}
