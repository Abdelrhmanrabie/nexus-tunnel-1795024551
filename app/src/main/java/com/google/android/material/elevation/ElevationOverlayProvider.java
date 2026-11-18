package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import defpackage.je;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ElevationOverlayProvider {
    public static final int OVERLAY_ACCENT_COLOR_ALPHA = (int) Math.round(5.1000000000000005d);
    public final int colorSurface;
    public final float displayDensity;
    public final int elevationOverlayAccentColor;
    public final int elevationOverlayColor;
    public final boolean elevationOverlayEnabled;

    /* JADX WARN: Illegal instructions before constructor call */
    public ElevationOverlayProvider(Context context) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, R.style.ke);
        boolean z = (typedValueResolve == null || typedValueResolve.type != 18 || typedValueResolve.data == 0) ? false : true;
        TypedValue typedValueResolve2 = MaterialAttributes.resolve(context, R.style.kd);
        int i = typedValueResolve2 != null ? typedValueResolve2.data : 0;
        TypedValue typedValueResolve3 = MaterialAttributes.resolve(context, R.style.kc);
        int i2 = typedValueResolve3 != null ? typedValueResolve3.data : 0;
        TypedValue typedValueResolve4 = MaterialAttributes.resolve(context, R.style.gx);
        this(z, i, i2, typedValueResolve4 != null ? typedValueResolve4.data : 0, context.getResources().getDisplayMetrics().density);
    }

    public ElevationOverlayProvider(boolean z, int i, int i2, int i3, float f) {
        this.elevationOverlayEnabled = z;
        this.elevationOverlayColor = i;
        this.elevationOverlayAccentColor = i2;
        this.colorSurface = i3;
        this.displayDensity = f;
    }

    public final int compositeOverlayIfNeeded(int i, float f) {
        int i2;
        if (!this.elevationOverlayEnabled || je.c(i, 255) != this.colorSurface) {
            return i;
        }
        float f2 = this.displayDensity;
        float fMin = (f2 <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / f2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iLayer = MaterialColors.layer(je.c(i, 255), this.elevationOverlayColor, fMin);
        if (fMin > 0.0f && (i2 = this.elevationOverlayAccentColor) != 0) {
            iLayer = je.b(je.c(i2, OVERLAY_ACCENT_COLOR_ALPHA), iLayer);
        }
        return je.c(iLayer, iAlpha);
    }
}
