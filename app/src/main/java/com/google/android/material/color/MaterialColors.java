package com.google.android.material.color;

import android.graphics.Color;
import android.view.View;
import com.google.android.material.resources.MaterialAttributes;
import defpackage.je;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MaterialColors {
    private MaterialColors() {
    }

    public static int compositeARGBWithAlpha(int i, int i2) {
        return je.c(i, (Color.alpha(i) * i2) / 255);
    }

    public static int getColor(View view, int i) {
        return MaterialAttributes.resolveOrThrow(view.getContext(), i, view.getClass().getCanonicalName());
    }

    public static int layer(int i, int i2, float f) {
        return je.b(je.c(i2, Math.round(Color.alpha(i2) * f)), i);
    }
}
