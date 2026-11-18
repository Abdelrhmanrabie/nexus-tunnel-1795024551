package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.ThemeEnforcement;
import defpackage.d;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LinearProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    public boolean drawHorizontallyInverse;
    public final int indeterminateAnimationType;
    public final int indicatorDirection;

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.s6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.plurals.a1r);
        int i2 = LinearProgressIndicator.$r8$clinit;
    }

    public LinearProgressIndicatorSpec(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int i3 = LinearProgressIndicator.$r8$clinit;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R.styleable.LinearProgressIndicator, R.style.s6, R.plurals.a1r, new int[0]);
        this.indeterminateAnimationType = typedArrayObtainStyledAttributes.getInt(0, 1);
        int i4 = typedArrayObtainStyledAttributes.getInt(1, 0);
        this.indicatorDirection = i4;
        typedArrayObtainStyledAttributes.recycle();
        validateSpec();
        this.drawHorizontallyInverse = i4 == 1;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicatorSpec
    public final void validateSpec() {
        String str;
        if (this.indeterminateAnimationType == 0) {
            if (this.trackCornerRadius > 0) {
                str = "Rounded corners are not supported in contiguous indeterminate animation.";
            } else if (this.indicatorColors.length >= 3) {
                return;
            } else {
                str = "Contiguous indeterminate animation must be used with 3 or more indicator colors.";
            }
            d.AnonymousClass0.m$2(str);
        }
    }
}
