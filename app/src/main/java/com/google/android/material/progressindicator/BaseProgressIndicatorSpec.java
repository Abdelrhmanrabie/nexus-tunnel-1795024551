package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import defpackage.d;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProgressIndicatorSpec {
    public final int hideAnimationBehavior;
    public final int[] indicatorColors;
    public final int showAnimationBehavior;
    public final int trackColor;
    public final int trackCornerRadius;
    public final int trackThickness;

    public BaseProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i, int i2) {
        int iCompositeARGBWithAlpha;
        this.indicatorColors = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.nj);
        ThemeEnforcement.checkCompatibleTheme(context, attributeSet, i, i2);
        int[] iArr = com.google.android.material.R.styleable.BaseProgressIndicator;
        ThemeEnforcement.checkTextAppearance(context, attributeSet, iArr, i, i2, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        int dimensionPixelSize2 = MaterialResources.getDimensionPixelSize(context, typedArrayObtainStyledAttributes, 8, dimensionPixelSize);
        this.trackThickness = dimensionPixelSize2;
        this.trackCornerRadius = Math.min(MaterialResources.getDimensionPixelSize(context, typedArrayObtainStyledAttributes, 7, 0), dimensionPixelSize2 / 2);
        this.showAnimationBehavior = typedArrayObtainStyledAttributes.getInt(4, 0);
        this.hideAnimationBehavior = typedArrayObtainStyledAttributes.getInt(1, 0);
        if (!typedArrayObtainStyledAttributes.hasValue(2)) {
            TypedValue typedValueResolve = MaterialAttributes.resolve(context, R.style.gn);
            this.indicatorColors = new int[]{typedValueResolve != null ? typedValueResolve.data : -1};
        } else if (typedArrayObtainStyledAttributes.peekValue(2).type != 1) {
            this.indicatorColors = new int[]{typedArrayObtainStyledAttributes.getColor(2, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(2, -1));
            this.indicatorColors = intArray;
            if (intArray.length == 0) {
                d.AnonymousClass0.m$2("indicatorColors cannot be empty when indicatorColor is not used.");
                throw null;
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            iCompositeARGBWithAlpha = typedArrayObtainStyledAttributes.getColor(6, -1);
        } else {
            int i3 = this.indicatorColors[0];
            this.trackColor = i3;
            TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
            float f = typedArrayObtainStyledAttributes2.getFloat(0, 0.2f);
            typedArrayObtainStyledAttributes2.recycle();
            iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i3, (int) (f * 255.0f));
        }
        this.trackColor = iCompositeARGBWithAlpha;
        typedArrayObtainStyledAttributes.recycle();
    }

    public abstract void validateSpec();
}
