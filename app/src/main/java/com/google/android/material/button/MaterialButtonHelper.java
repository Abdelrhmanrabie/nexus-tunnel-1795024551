package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class MaterialButtonHelper {
    public ColorStateList backgroundTint;
    public PorterDuff.Mode backgroundTintMode;
    public boolean checkable;
    public int elevation;
    public int insetBottom;
    public int insetLeft;
    public int insetRight;
    public int insetTop;
    public MaterialShapeDrawable maskDrawable;
    public final MaterialButton materialButton;
    public ColorStateList rippleColor;
    public RippleDrawable rippleDrawable;
    public ShapeAppearanceModel shapeAppearanceModel;
    public ColorStateList strokeColor;
    public int strokeWidth;
    public boolean shouldDrawSurfaceColorStroke = false;
    public boolean backgroundOverwritten = false;

    public MaterialButtonHelper(MaterialButton materialButton, ShapeAppearanceModel shapeAppearanceModel) {
        this.materialButton = materialButton;
        this.shapeAppearanceModel = shapeAppearanceModel;
    }

    public final Shapeable getMaskDrawable() {
        RippleDrawable rippleDrawable = this.rippleDrawable;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        int numberOfLayers = this.rippleDrawable.getNumberOfLayers();
        RippleDrawable rippleDrawable2 = this.rippleDrawable;
        return (Shapeable) (numberOfLayers > 2 ? rippleDrawable2.getDrawable(2) : rippleDrawable2.getDrawable(1));
    }

    public final MaterialShapeDrawable getMaterialShapeDrawable(boolean z) {
        RippleDrawable rippleDrawable = this.rippleDrawable;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        if (getMaterialShapeDrawable(false) != null) {
            getMaterialShapeDrawable(false).setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (getMaterialShapeDrawable(true) != null) {
            getMaterialShapeDrawable(true).setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (getMaskDrawable() != null) {
            getMaskDrawable().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }
}
