package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context) {
        this(context, null);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TypedValue typedValueResolve = MaterialAttributes.resolve(context2, org.hamotunnelplus.xyz.R.style.a3y);
        if (typedValueResolve != null && typedValueResolve.type == 18 && typedValueResolve.data == 0) {
            return;
        }
        Resources.Theme theme = context2.getTheme();
        int[] iArr = com.google.android.material.R.styleable.MaterialTextView;
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i, i2);
        int[] iArr2 = {1, 2};
        int dimensionPixelSize = -1;
        for (int i3 = 0; i3 < 2 && dimensionPixelSize < 0; i3++) {
            dimensionPixelSize = MaterialResources.getDimensionPixelSize(context2, typedArrayObtainStyledAttributes, iArr2[i3], -1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (dimensionPixelSize != -1) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, i, i2);
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
        typedArrayObtainStyledAttributes2.recycle();
        if (resourceId != -1) {
            TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, com.google.android.material.R.styleable.MaterialTextAppearance);
            Context context3 = getContext();
            int[] iArr3 = {1, 2};
            int dimensionPixelSize2 = -1;
            for (int i4 = 0; i4 < 2 && dimensionPixelSize2 < 0; i4++) {
                dimensionPixelSize2 = MaterialResources.getDimensionPixelSize(context3, typedArrayObtainStyledAttributes3, iArr3[i4], -1);
            }
            typedArrayObtainStyledAttributes3.recycle();
            if (dimensionPixelSize2 >= 0) {
                setLineHeight(dimensionPixelSize2);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, org.hamotunnelplus.xyz.R.style.a3y);
        if (typedValueResolve != null && typedValueResolve.type == 18 && typedValueResolve.data == 0) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, com.google.android.material.R.styleable.MaterialTextAppearance);
        Context context2 = getContext();
        int[] iArr = {1, 2};
        int dimensionPixelSize = -1;
        for (int i2 = 0; i2 < 2 && dimensionPixelSize < 0; i2++) {
            dimensionPixelSize = MaterialResources.getDimensionPixelSize(context2, typedArrayObtainStyledAttributes, iArr[i2], -1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (dimensionPixelSize >= 0) {
            setLineHeight(dimensionPixelSize);
        }
    }
}
