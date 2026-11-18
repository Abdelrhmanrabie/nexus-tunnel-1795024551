package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.qd1;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SwitchMaterial extends SwitchCompat {
    public static final int[][] ENABLED_CHECKED_STATES = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public final ElevationOverlayProvider elevationOverlayProvider;
    public ColorStateList materialThemeColorsThumbTintList;
    public ColorStateList materialThemeColorsTrackTintList;
    public final boolean useMaterialThemeColors;

    public SwitchMaterial(Context context) {
        this(context, null);
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.a2a);
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.a1m), attributeSet, i);
        Context context2 = getContext();
        this.elevationOverlayProvider = new ElevationOverlayProvider(context2);
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.SwitchMaterial, i, org.hamotunnelplus.xyz.R.plurals.a1m, new int[0]);
        this.useMaterialThemeColors = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int[][] iArr = ENABLED_CHECKED_STATES;
        boolean z = this.useMaterialThemeColors;
        if (z && this.mThumbTintList == null) {
            if (this.materialThemeColorsThumbTintList == null) {
                int color = MaterialColors.getColor(this, org.hamotunnelplus.xyz.R.style.gx);
                int color2 = MaterialColors.getColor(this, org.hamotunnelplus.xyz.R.style.g4);
                float dimension = getResources().getDimension(org.hamotunnelplus.xyz.R.dimen.o3);
                ElevationOverlayProvider elevationOverlayProvider = this.elevationOverlayProvider;
                if (elevationOverlayProvider.elevationOverlayEnabled) {
                    float elevation = 0.0f;
                    for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
                        WeakHashMap weakHashMap = qd1.a;
                        elevation += ((View) parent).getElevation();
                    }
                    dimension += elevation;
                }
                int iCompositeOverlayIfNeeded = elevationOverlayProvider.compositeOverlayIfNeeded(color, dimension);
                this.materialThemeColorsThumbTintList = new ColorStateList(iArr, new int[]{MaterialColors.layer(color, color2, 1.0f), iCompositeOverlayIfNeeded, MaterialColors.layer(color, color2, 0.38f), iCompositeOverlayIfNeeded});
            }
            this.mThumbTintList = this.materialThemeColorsThumbTintList;
            this.mHasThumbTint = true;
            applyThumbTint();
        }
        if (z && this.mTrackTintList == null) {
            if (this.materialThemeColorsTrackTintList == null) {
                int color3 = MaterialColors.getColor(this, org.hamotunnelplus.xyz.R.style.gx);
                int color4 = MaterialColors.getColor(this, org.hamotunnelplus.xyz.R.style.g4);
                int color5 = MaterialColors.getColor(this, org.hamotunnelplus.xyz.R.style.gh);
                this.materialThemeColorsTrackTintList = new ColorStateList(iArr, new int[]{MaterialColors.layer(color3, color4, 0.54f), MaterialColors.layer(color3, color5, 0.32f), MaterialColors.layer(color3, color4, 0.12f), MaterialColors.layer(color3, color5, 0.12f)});
            }
            this.mTrackTintList = this.materialThemeColorsTrackTintList;
            this.mHasTrackTint = true;
            applyTrackTint();
        }
    }
}
