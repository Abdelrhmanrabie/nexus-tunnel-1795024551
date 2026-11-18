package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import defpackage.je;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ChipDrawable extends MaterialShapeDrawable implements Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    public static final int[] DEFAULT_STATE = {R.attr.state_enabled};
    public static final ShapeDrawable closeIconRippleMask = new ShapeDrawable(new OvalShape());
    public int alpha;
    public boolean checkable;
    public Drawable checkedIcon;
    public ColorStateList checkedIconTint;
    public boolean checkedIconVisible;
    public ColorStateList chipBackgroundColor;
    public float chipCornerRadius;
    public float chipEndPadding;
    public Drawable chipIcon;
    public float chipIconSize;
    public ColorStateList chipIconTint;
    public boolean chipIconVisible;
    public float chipMinHeight;
    public final Paint chipPaint;
    public float chipStartPadding;
    public ColorStateList chipStrokeColor;
    public float chipStrokeWidth;
    public ColorStateList chipSurfaceColor;
    public Drawable closeIcon;
    public float closeIconEndPadding;
    public RippleDrawable closeIconRipple;
    public float closeIconSize;
    public float closeIconStartPadding;
    public int[] closeIconStateSet;
    public ColorStateList closeIconTint;
    public boolean closeIconVisible;
    public ColorFilter colorFilter;
    public ColorStateList compatRippleColor;
    public final Context context;
    public boolean currentChecked;
    public int currentChipBackgroundColor;
    public int currentChipStrokeColor;
    public int currentChipSurfaceColor;
    public int currentCompatRippleColor;
    public int currentCompositeSurfaceBackgroundColor;
    public int currentTextColor;
    public int currentTint;
    public WeakReference delegate;
    public final Paint.FontMetrics fontMetrics;
    public boolean hasChipIconTint;
    public float iconEndPadding;
    public float iconStartPadding;
    public boolean isShapeThemingEnabled;
    public int maxWidth;
    public final PointF pointF;
    public final RectF rectF;
    public ColorStateList rippleColor;
    public final Path shapePath;
    public boolean shouldDrawText;
    public CharSequence text;
    public final TextDrawableHelper textDrawableHelper;
    public float textEndPadding;
    public float textStartPadding;
    public ColorStateList tint;
    public PorterDuffColorFilter tintFilter;
    public PorterDuff.Mode tintMode;
    public TextUtils.TruncateAt truncateAt;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    private ChipDrawable(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.chipCornerRadius = -1.0f;
        this.chipPaint = new Paint(1);
        this.fontMetrics = new Paint.FontMetrics();
        this.rectF = new RectF();
        this.pointF = new PointF();
        this.shapePath = new Path();
        this.alpha = 255;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        this.delegate = new WeakReference(null);
        initializeElevationOverlay(context);
        this.context = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        this.text = AppConfig.CUSTOM;
        textDrawableHelper.textPaint.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = DEFAULT_STATE;
        setState(iArr);
        if (!Arrays.equals(this.closeIconStateSet, iArr)) {
            this.closeIconStateSet = iArr;
            if (showsCloseIcon()) {
                onStateChange(getState(), iArr);
            }
        }
        this.shouldDrawText = true;
        closeIconRippleMask.setTint(-1);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:102:0x0202  */
    /* JADX WARN: Code duplicated, block: B:105:0x0226  */
    /* JADX WARN: Code duplicated, block: B:108:0x0232  */
    /* JADX WARN: Code duplicated, block: B:111:0x023f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0247  */
    /* JADX WARN: Code duplicated, block: B:117:0x025f  */
    /* JADX WARN: Code duplicated, block: B:119:0x026a  */
    /* JADX WARN: Code duplicated, block: B:122:0x0276  */
    /* JADX WARN: Code duplicated, block: B:129:0x028f  */
    /* JADX WARN: Code duplicated, block: B:139:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:141:0x02da  */
    /* JADX WARN: Code duplicated, block: B:156:0x031b  */
    /* JADX WARN: Code duplicated, block: B:159:0x032f  */
    /* JADX WARN: Code duplicated, block: B:161:0x0340  */
    /* JADX WARN: Code duplicated, block: B:164:0x034f  */
    /* JADX WARN: Code duplicated, block: B:166:0x0360  */
    /* JADX WARN: Code duplicated, block: B:169:0x036f  */
    /* JADX WARN: Code duplicated, block: B:172:0x0383  */
    /* JADX WARN: Code duplicated, block: B:175:0x0397  */
    /* JADX WARN: Code duplicated, block: B:177:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:180:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:182:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:185:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:63:0x0155  */
    /* JADX WARN: Code duplicated, block: B:65:0x0158  */
    /* JADX WARN: Code duplicated, block: B:67:0x015e  */
    /* JADX WARN: Code duplicated, block: B:68:0x0163  */
    /* JADX WARN: Code duplicated, block: B:71:0x0173  */
    /* JADX WARN: Code duplicated, block: B:74:0x017f  */
    /* JADX WARN: Code duplicated, block: B:77:0x018a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0194  */
    /* JADX WARN: Code duplicated, block: B:81:0x019c  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:98:0x01f9  */
    public static ChipDrawable createFromAttributes(Context context, AttributeSet attributeSet, int i) {
        TextUtils.TruncateAt truncateAt;
        Drawable drawable;
        Drawable drawable2;
        float dimension;
        Drawable drawable3;
        Drawable drawable4;
        ColorStateList colorStateList;
        float dimension2;
        boolean z;
        Drawable drawable5;
        float dimension3;
        float dimension4;
        float dimension5;
        float dimension6;
        float dimension7;
        float dimension8;
        float dimension9;
        float dimension10;
        float fCalculateChipIconWidth;
        float fCalculateChipIconWidth2;
        float fCalculateChipIconWidth3;
        float fCalculateChipIconWidth4;
        ColorStateList colorStateList2;
        Drawable drawable6;
        float fCalculateChipIconWidth5;
        float fCalculateChipIconWidth6;
        float fCalculateChipIconWidth7;
        float fCalculateChipIconWidth8;
        float fCalculateCloseIconWidth;
        float fCalculateCloseIconWidth2;
        float fCalculateChipIconWidth9;
        float fCalculateChipIconWidth10;
        ColorStateList colorStateList3;
        float fCalculateChipIconWidth11;
        Drawable drawableMutate;
        float fCalculateChipIconWidth12;
        int resourceId;
        ChipDrawable chipDrawable = new ChipDrawable(context, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.a1a);
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(chipDrawable.context, attributeSet, com.google.android.material.R.styleable.Chip, i, org.hamotunnelplus.xyz.R.plurals.a1a, new int[0]);
        chipDrawable.isShapeThemingEnabled = typedArrayObtainStyledAttributes.hasValue(37);
        Context context2 = chipDrawable.context;
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 24);
        if (chipDrawable.chipSurfaceColor != colorStateList4) {
            chipDrawable.chipSurfaceColor = colorStateList4;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 11);
        if (chipDrawable.chipBackgroundColor != colorStateList5) {
            chipDrawable.chipBackgroundColor = colorStateList5;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        float dimension11 = typedArrayObtainStyledAttributes.getDimension(19, 0.0f);
        if (chipDrawable.chipMinHeight != dimension11) {
            chipDrawable.chipMinHeight = dimension11;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        if (typedArrayObtainStyledAttributes.hasValue(12)) {
            float dimension12 = typedArrayObtainStyledAttributes.getDimension(12, 0.0f);
            if (chipDrawable.chipCornerRadius != dimension12) {
                chipDrawable.chipCornerRadius = dimension12;
                ShapeAppearanceModel shapeAppearanceModel = chipDrawable.getShapeAppearanceModel();
                shapeAppearanceModel.getClass();
                ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
                builder.setAllCornerSizes(dimension12);
                chipDrawable.setShapeAppearanceModel(builder.build());
            }
        }
        ColorStateList colorStateList6 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 22);
        if (chipDrawable.chipStrokeColor != colorStateList6) {
            chipDrawable.chipStrokeColor = colorStateList6;
            if (chipDrawable.isShapeThemingEnabled) {
                chipDrawable.setStrokeColor(colorStateList6);
            }
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        float dimension13 = typedArrayObtainStyledAttributes.getDimension(23, 0.0f);
        if (chipDrawable.chipStrokeWidth != dimension13) {
            chipDrawable.chipStrokeWidth = dimension13;
            chipDrawable.chipPaint.setStrokeWidth(dimension13);
            if (chipDrawable.isShapeThemingEnabled) {
                chipDrawable.setStrokeWidth(dimension13);
            }
            chipDrawable.invalidateSelf();
        }
        ColorStateList colorStateList7 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 36);
        if (chipDrawable.rippleColor != colorStateList7) {
            chipDrawable.rippleColor = colorStateList7;
            chipDrawable.compatRippleColor = null;
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        CharSequence text = typedArrayObtainStyledAttributes.getText(5);
        if (text == null) {
            text = AppConfig.CUSTOM;
        }
        boolean zEquals = TextUtils.equals(chipDrawable.text, text);
        TextDrawableHelper textDrawableHelper = chipDrawable.textDrawableHelper;
        if (!zEquals) {
            chipDrawable.text = text;
            textDrawableHelper.textWidthDirty = true;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        TextAppearance textAppearance = (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? null : new TextAppearance(context2, resourceId);
        textAppearance.textSize = typedArrayObtainStyledAttributes.getDimension(1, textAppearance.textSize);
        textDrawableHelper.setTextAppearance(textAppearance, context2);
        int i2 = typedArrayObtainStyledAttributes.getInt(3, 0);
        if (i2 == 1) {
            truncateAt = TextUtils.TruncateAt.START;
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    truncateAt = TextUtils.TruncateAt.END;
                }
                chipDrawable.setChipIconVisible(typedArrayObtainStyledAttributes.getBoolean(18, false));
                if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
                    chipDrawable.setChipIconVisible(typedArrayObtainStyledAttributes.getBoolean(15, false));
                }
                drawable = MaterialResources.getDrawable(context2, typedArrayObtainStyledAttributes, 14);
                drawable2 = chipDrawable.chipIcon;
                if (drawable2 == null) {
                    drawable2 = null;
                }
                if (drawable2 != drawable) {
                    fCalculateChipIconWidth11 = chipDrawable.calculateChipIconWidth();
                    if (drawable != null) {
                        drawableMutate = drawable.mutate();
                    } else {
                        drawableMutate = null;
                    }
                    chipDrawable.chipIcon = drawableMutate;
                    fCalculateChipIconWidth12 = chipDrawable.calculateChipIconWidth();
                    unapplyChildDrawable(drawable2);
                    if (chipDrawable.showsChipIcon()) {
                        chipDrawable.applyChildDrawable(chipDrawable.chipIcon);
                    }
                    chipDrawable.invalidateSelf();
                    if (fCalculateChipIconWidth11 != fCalculateChipIconWidth12) {
                        chipDrawable.onSizeChange();
                    }
                }
                if (typedArrayObtainStyledAttributes.hasValue(17)) {
                    colorStateList3 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 17);
                    chipDrawable.hasChipIconTint = true;
                    if (chipDrawable.chipIconTint != colorStateList3) {
                        chipDrawable.chipIconTint = colorStateList3;
                        if (chipDrawable.showsChipIcon()) {
                            chipDrawable.chipIcon.setTintList(colorStateList3);
                        }
                        chipDrawable.onStateChange(chipDrawable.getState());
                    }
                }
                dimension = typedArrayObtainStyledAttributes.getDimension(16, -1.0f);
                if (chipDrawable.chipIconSize != dimension) {
                    fCalculateChipIconWidth9 = chipDrawable.calculateChipIconWidth();
                    chipDrawable.chipIconSize = dimension;
                    fCalculateChipIconWidth10 = chipDrawable.calculateChipIconWidth();
                    chipDrawable.invalidateSelf();
                    if (fCalculateChipIconWidth9 != fCalculateChipIconWidth10) {
                        chipDrawable.onSizeChange();
                    }
                }
                chipDrawable.setCloseIconVisible(typedArrayObtainStyledAttributes.getBoolean(31, false));
                if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
                    chipDrawable.setCloseIconVisible(typedArrayObtainStyledAttributes.getBoolean(26, false));
                }
                drawable3 = MaterialResources.getDrawable(context2, typedArrayObtainStyledAttributes, 25);
                drawable4 = chipDrawable.closeIcon;
                if (drawable4 == null) {
                    drawable4 = null;
                }
                if (drawable4 != drawable3) {
                    fCalculateCloseIconWidth = chipDrawable.calculateCloseIconWidth();
                    chipDrawable.closeIcon = drawable3 != null ? drawable3.mutate() : null;
                    chipDrawable.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(chipDrawable.rippleColor), chipDrawable.closeIcon, closeIconRippleMask);
                    fCalculateCloseIconWidth2 = chipDrawable.calculateCloseIconWidth();
                    unapplyChildDrawable(drawable4);
                    if (chipDrawable.showsCloseIcon()) {
                        chipDrawable.applyChildDrawable(chipDrawable.closeIcon);
                    }
                    chipDrawable.invalidateSelf();
                    if (fCalculateCloseIconWidth != fCalculateCloseIconWidth2) {
                        chipDrawable.onSizeChange();
                    }
                }
                colorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 30);
                if (chipDrawable.closeIconTint != colorStateList) {
                    chipDrawable.closeIconTint = colorStateList;
                    if (chipDrawable.showsCloseIcon()) {
                        chipDrawable.closeIcon.setTintList(colorStateList);
                    }
                    chipDrawable.onStateChange(chipDrawable.getState());
                }
                dimension2 = typedArrayObtainStyledAttributes.getDimension(28, 0.0f);
                if (chipDrawable.closeIconSize != dimension2) {
                    chipDrawable.closeIconSize = dimension2;
                    chipDrawable.invalidateSelf();
                    if (chipDrawable.showsCloseIcon()) {
                        chipDrawable.onSizeChange();
                    }
                }
                z = typedArrayObtainStyledAttributes.getBoolean(6, false);
                if (chipDrawable.checkable != z) {
                    chipDrawable.checkable = z;
                    fCalculateChipIconWidth7 = chipDrawable.calculateChipIconWidth();
                    if (!z && chipDrawable.currentChecked) {
                        chipDrawable.currentChecked = false;
                    }
                    fCalculateChipIconWidth8 = chipDrawable.calculateChipIconWidth();
                    chipDrawable.invalidateSelf();
                    if (fCalculateChipIconWidth7 != fCalculateChipIconWidth8) {
                        chipDrawable.onSizeChange();
                    }
                }
                chipDrawable.setCheckedIconVisible(typedArrayObtainStyledAttributes.getBoolean(10, false));
                if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
                    chipDrawable.setCheckedIconVisible(typedArrayObtainStyledAttributes.getBoolean(8, false));
                }
                drawable5 = MaterialResources.getDrawable(context2, typedArrayObtainStyledAttributes, 7);
                if (chipDrawable.checkedIcon != drawable5) {
                    fCalculateChipIconWidth5 = chipDrawable.calculateChipIconWidth();
                    chipDrawable.checkedIcon = drawable5;
                    fCalculateChipIconWidth6 = chipDrawable.calculateChipIconWidth();
                    unapplyChildDrawable(chipDrawable.checkedIcon);
                    chipDrawable.applyChildDrawable(chipDrawable.checkedIcon);
                    chipDrawable.invalidateSelf();
                    if (fCalculateChipIconWidth5 != fCalculateChipIconWidth6) {
                        chipDrawable.onSizeChange();
                    }
                }
                if (typedArrayObtainStyledAttributes.hasValue(9) && chipDrawable.checkedIconTint != (colorStateList2 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 9))) {
                    chipDrawable.checkedIconTint = colorStateList2;
                    if (chipDrawable.checkedIconVisible && (drawable6 = chipDrawable.checkedIcon) != null && chipDrawable.checkable) {
                        drawable6.setTintList(colorStateList2);
                    }
                    chipDrawable.onStateChange(chipDrawable.getState());
                }
                MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, 39);
                MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, 33);
                dimension3 = typedArrayObtainStyledAttributes.getDimension(21, 0.0f);
                if (chipDrawable.chipStartPadding != dimension3) {
                    chipDrawable.chipStartPadding = dimension3;
                    chipDrawable.invalidateSelf();
                    chipDrawable.onSizeChange();
                }
                dimension4 = typedArrayObtainStyledAttributes.getDimension(35, 0.0f);
                if (chipDrawable.iconStartPadding != dimension4) {
                    fCalculateChipIconWidth3 = chipDrawable.calculateChipIconWidth();
                    chipDrawable.iconStartPadding = dimension4;
                    fCalculateChipIconWidth4 = chipDrawable.calculateChipIconWidth();
                    chipDrawable.invalidateSelf();
                    if (fCalculateChipIconWidth3 != fCalculateChipIconWidth4) {
                        chipDrawable.onSizeChange();
                    }
                }
                dimension5 = typedArrayObtainStyledAttributes.getDimension(34, 0.0f);
                if (chipDrawable.iconEndPadding != dimension5) {
                    fCalculateChipIconWidth = chipDrawable.calculateChipIconWidth();
                    chipDrawable.iconEndPadding = dimension5;
                    fCalculateChipIconWidth2 = chipDrawable.calculateChipIconWidth();
                    chipDrawable.invalidateSelf();
                    if (fCalculateChipIconWidth != fCalculateChipIconWidth2) {
                        chipDrawable.onSizeChange();
                    }
                }
                dimension6 = typedArrayObtainStyledAttributes.getDimension(41, 0.0f);
                if (chipDrawable.textStartPadding != dimension6) {
                    chipDrawable.textStartPadding = dimension6;
                    chipDrawable.invalidateSelf();
                    chipDrawable.onSizeChange();
                }
                dimension7 = typedArrayObtainStyledAttributes.getDimension(40, 0.0f);
                if (chipDrawable.textEndPadding != dimension7) {
                    chipDrawable.textEndPadding = dimension7;
                    chipDrawable.invalidateSelf();
                    chipDrawable.onSizeChange();
                }
                dimension8 = typedArrayObtainStyledAttributes.getDimension(29, 0.0f);
                if (chipDrawable.closeIconStartPadding != dimension8) {
                    chipDrawable.closeIconStartPadding = dimension8;
                    chipDrawable.invalidateSelf();
                    if (chipDrawable.showsCloseIcon()) {
                        chipDrawable.onSizeChange();
                    }
                }
                dimension9 = typedArrayObtainStyledAttributes.getDimension(27, 0.0f);
                if (chipDrawable.closeIconEndPadding != dimension9) {
                    chipDrawable.closeIconEndPadding = dimension9;
                    chipDrawable.invalidateSelf();
                    if (chipDrawable.showsCloseIcon()) {
                        chipDrawable.onSizeChange();
                    }
                }
                dimension10 = typedArrayObtainStyledAttributes.getDimension(13, 0.0f);
                if (chipDrawable.chipEndPadding != dimension10) {
                    chipDrawable.chipEndPadding = dimension10;
                    chipDrawable.invalidateSelf();
                    chipDrawable.onSizeChange();
                }
                chipDrawable.maxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, Integer.MAX_VALUE);
                typedArrayObtainStyledAttributes.recycle();
                return chipDrawable;
            }
            truncateAt = TextUtils.TruncateAt.MIDDLE;
        }
        chipDrawable.truncateAt = truncateAt;
        chipDrawable.setChipIconVisible(typedArrayObtainStyledAttributes.getBoolean(18, false));
        if (attributeSet != null) {
            chipDrawable.setChipIconVisible(typedArrayObtainStyledAttributes.getBoolean(15, false));
        }
        drawable = MaterialResources.getDrawable(context2, typedArrayObtainStyledAttributes, 14);
        drawable2 = chipDrawable.chipIcon;
        if (drawable2 == null) {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            fCalculateChipIconWidth11 = chipDrawable.calculateChipIconWidth();
            if (drawable != null) {
                drawableMutate = drawable.mutate();
            } else {
                drawableMutate = null;
            }
            chipDrawable.chipIcon = drawableMutate;
            fCalculateChipIconWidth12 = chipDrawable.calculateChipIconWidth();
            unapplyChildDrawable(drawable2);
            if (chipDrawable.showsChipIcon()) {
                chipDrawable.applyChildDrawable(chipDrawable.chipIcon);
            }
            chipDrawable.invalidateSelf();
            if (fCalculateChipIconWidth11 != fCalculateChipIconWidth12) {
                chipDrawable.onSizeChange();
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(17)) {
            colorStateList3 = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 17);
            chipDrawable.hasChipIconTint = true;
            if (chipDrawable.chipIconTint != colorStateList3) {
                chipDrawable.chipIconTint = colorStateList3;
                if (chipDrawable.showsChipIcon()) {
                    chipDrawable.chipIcon.setTintList(colorStateList3);
                }
                chipDrawable.onStateChange(chipDrawable.getState());
            }
        }
        dimension = typedArrayObtainStyledAttributes.getDimension(16, -1.0f);
        if (chipDrawable.chipIconSize != dimension) {
            fCalculateChipIconWidth9 = chipDrawable.calculateChipIconWidth();
            chipDrawable.chipIconSize = dimension;
            fCalculateChipIconWidth10 = chipDrawable.calculateChipIconWidth();
            chipDrawable.invalidateSelf();
            if (fCalculateChipIconWidth9 != fCalculateChipIconWidth10) {
                chipDrawable.onSizeChange();
            }
        }
        chipDrawable.setCloseIconVisible(typedArrayObtainStyledAttributes.getBoolean(31, false));
        if (attributeSet != null) {
            chipDrawable.setCloseIconVisible(typedArrayObtainStyledAttributes.getBoolean(26, false));
        }
        drawable3 = MaterialResources.getDrawable(context2, typedArrayObtainStyledAttributes, 25);
        drawable4 = chipDrawable.closeIcon;
        if (drawable4 == null) {
            drawable4 = null;
        }
        if (drawable4 != drawable3) {
            fCalculateCloseIconWidth = chipDrawable.calculateCloseIconWidth();
            chipDrawable.closeIcon = drawable3 != null ? drawable3.mutate() : null;
            chipDrawable.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(chipDrawable.rippleColor), chipDrawable.closeIcon, closeIconRippleMask);
            fCalculateCloseIconWidth2 = chipDrawable.calculateCloseIconWidth();
            unapplyChildDrawable(drawable4);
            if (chipDrawable.showsCloseIcon()) {
                chipDrawable.applyChildDrawable(chipDrawable.closeIcon);
            }
            chipDrawable.invalidateSelf();
            if (fCalculateCloseIconWidth != fCalculateCloseIconWidth2) {
                chipDrawable.onSizeChange();
            }
        }
        colorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, 30);
        if (chipDrawable.closeIconTint != colorStateList) {
            chipDrawable.closeIconTint = colorStateList;
            if (chipDrawable.showsCloseIcon()) {
                chipDrawable.closeIcon.setTintList(colorStateList);
            }
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        dimension2 = typedArrayObtainStyledAttributes.getDimension(28, 0.0f);
        if (chipDrawable.closeIconSize != dimension2) {
            chipDrawable.closeIconSize = dimension2;
            chipDrawable.invalidateSelf();
            if (chipDrawable.showsCloseIcon()) {
                chipDrawable.onSizeChange();
            }
        }
        z = typedArrayObtainStyledAttributes.getBoolean(6, false);
        if (chipDrawable.checkable != z) {
            chipDrawable.checkable = z;
            fCalculateChipIconWidth7 = chipDrawable.calculateChipIconWidth();
            if (!z) {
                chipDrawable.currentChecked = false;
            }
            fCalculateChipIconWidth8 = chipDrawable.calculateChipIconWidth();
            chipDrawable.invalidateSelf();
            if (fCalculateChipIconWidth7 != fCalculateChipIconWidth8) {
                chipDrawable.onSizeChange();
            }
        }
        chipDrawable.setCheckedIconVisible(typedArrayObtainStyledAttributes.getBoolean(10, false));
        if (attributeSet != null) {
            chipDrawable.setCheckedIconVisible(typedArrayObtainStyledAttributes.getBoolean(8, false));
        }
        drawable5 = MaterialResources.getDrawable(context2, typedArrayObtainStyledAttributes, 7);
        if (chipDrawable.checkedIcon != drawable5) {
            fCalculateChipIconWidth5 = chipDrawable.calculateChipIconWidth();
            chipDrawable.checkedIcon = drawable5;
            fCalculateChipIconWidth6 = chipDrawable.calculateChipIconWidth();
            unapplyChildDrawable(chipDrawable.checkedIcon);
            chipDrawable.applyChildDrawable(chipDrawable.checkedIcon);
            chipDrawable.invalidateSelf();
            if (fCalculateChipIconWidth5 != fCalculateChipIconWidth6) {
                chipDrawable.onSizeChange();
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(9)) {
            chipDrawable.checkedIconTint = colorStateList2;
            if (chipDrawable.checkedIconVisible) {
                drawable6.setTintList(colorStateList2);
            }
            chipDrawable.onStateChange(chipDrawable.getState());
        }
        MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, 39);
        MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, 33);
        dimension3 = typedArrayObtainStyledAttributes.getDimension(21, 0.0f);
        if (chipDrawable.chipStartPadding != dimension3) {
            chipDrawable.chipStartPadding = dimension3;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        dimension4 = typedArrayObtainStyledAttributes.getDimension(35, 0.0f);
        if (chipDrawable.iconStartPadding != dimension4) {
            fCalculateChipIconWidth3 = chipDrawable.calculateChipIconWidth();
            chipDrawable.iconStartPadding = dimension4;
            fCalculateChipIconWidth4 = chipDrawable.calculateChipIconWidth();
            chipDrawable.invalidateSelf();
            if (fCalculateChipIconWidth3 != fCalculateChipIconWidth4) {
                chipDrawable.onSizeChange();
            }
        }
        dimension5 = typedArrayObtainStyledAttributes.getDimension(34, 0.0f);
        if (chipDrawable.iconEndPadding != dimension5) {
            fCalculateChipIconWidth = chipDrawable.calculateChipIconWidth();
            chipDrawable.iconEndPadding = dimension5;
            fCalculateChipIconWidth2 = chipDrawable.calculateChipIconWidth();
            chipDrawable.invalidateSelf();
            if (fCalculateChipIconWidth != fCalculateChipIconWidth2) {
                chipDrawable.onSizeChange();
            }
        }
        dimension6 = typedArrayObtainStyledAttributes.getDimension(41, 0.0f);
        if (chipDrawable.textStartPadding != dimension6) {
            chipDrawable.textStartPadding = dimension6;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        dimension7 = typedArrayObtainStyledAttributes.getDimension(40, 0.0f);
        if (chipDrawable.textEndPadding != dimension7) {
            chipDrawable.textEndPadding = dimension7;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        dimension8 = typedArrayObtainStyledAttributes.getDimension(29, 0.0f);
        if (chipDrawable.closeIconStartPadding != dimension8) {
            chipDrawable.closeIconStartPadding = dimension8;
            chipDrawable.invalidateSelf();
            if (chipDrawable.showsCloseIcon()) {
                chipDrawable.onSizeChange();
            }
        }
        dimension9 = typedArrayObtainStyledAttributes.getDimension(27, 0.0f);
        if (chipDrawable.closeIconEndPadding != dimension9) {
            chipDrawable.closeIconEndPadding = dimension9;
            chipDrawable.invalidateSelf();
            if (chipDrawable.showsCloseIcon()) {
                chipDrawable.onSizeChange();
            }
        }
        dimension10 = typedArrayObtainStyledAttributes.getDimension(13, 0.0f);
        if (chipDrawable.chipEndPadding != dimension10) {
            chipDrawable.chipEndPadding = dimension10;
            chipDrawable.invalidateSelf();
            chipDrawable.onSizeChange();
        }
        chipDrawable.maxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        return chipDrawable;
    }

    public static boolean isStateful(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean isStateful(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void unapplyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final void applyChildDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.closeIcon) {
            if (drawable.isStateful()) {
                drawable.setState(this.closeIconStateSet);
            }
            drawable.setTintList(this.closeIconTint);
            return;
        }
        Drawable drawable2 = this.chipIcon;
        if (drawable == drawable2 && this.hasChipIconTint) {
            drawable2.setTintList(this.chipIconTint);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void calculateChipIconBounds(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f = this.chipStartPadding + this.iconStartPadding;
            Drawable drawable = this.currentChecked ? this.checkedIcon : this.chipIcon;
            float intrinsicWidth = this.chipIconSize;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + intrinsicWidth;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - intrinsicWidth;
            }
            Drawable drawable2 = this.currentChecked ? this.checkedIcon : this.chipIcon;
            float fCeil = this.chipIconSize;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(ViewUtils.dpToPx(this.context, 24));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    public final float calculateChipIconWidth() {
        if (!showsChipIcon() && !showsCheckedIcon()) {
            return 0.0f;
        }
        float f = this.iconStartPadding;
        Drawable drawable = this.currentChecked ? this.checkedIcon : this.chipIcon;
        float intrinsicWidth = this.chipIconSize;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f + this.iconEndPadding;
    }

    public final float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2;
        int iSaveLayerAlpha;
        int i2;
        float f;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.alpha) == 0) {
            return;
        }
        if (i < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z = this.isShapeThemingEnabled;
        Paint paint = this.chipPaint;
        RectF rectF = this.rectF;
        if (!z) {
            paint.setColor(this.currentChipSurfaceColor);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, getChipCornerRadius(), getChipCornerRadius(), paint);
        }
        if (!this.isShapeThemingEnabled) {
            paint.setColor(this.currentChipBackgroundColor);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.colorFilter;
            if (colorFilter == null) {
                colorFilter = this.tintFilter;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, getChipCornerRadius(), getChipCornerRadius(), paint);
        }
        if (this.isShapeThemingEnabled) {
            super.draw(canvas);
        }
        if (this.chipStrokeWidth > 0.0f && !this.isShapeThemingEnabled) {
            paint.setColor(this.currentChipStrokeColor);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.isShapeThemingEnabled) {
                ColorFilter colorFilter2 = this.colorFilter;
                if (colorFilter2 == null) {
                    colorFilter2 = this.tintFilter;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f2 = bounds.left;
            float f3 = this.chipStrokeWidth / 2.0f;
            rectF.set(f2 + f3, bounds.top + f3, bounds.right - f3, bounds.bottom - f3);
            float f4 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
            canvas2.drawRoundRect(rectF, f4, f4, paint);
        }
        paint.setColor(this.currentCompatRippleColor);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.isShapeThemingEnabled) {
            RectF rectF2 = new RectF(bounds);
            Path path = this.shapePath;
            calculatePathForSize(rectF2, path);
            drawShape(canvas2, paint, path, getBoundsAsRectF$1());
        } else {
            canvas2.drawRoundRect(rectF, getChipCornerRadius(), getChipCornerRadius(), paint);
        }
        if (showsChipIcon()) {
            calculateChipIconBounds(bounds, rectF);
            float f5 = rectF.left;
            float f6 = rectF.top;
            canvas2.translate(f5, f6);
            this.chipIcon.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.chipIcon.draw(canvas2);
            canvas2.translate(-f5, -f6);
        }
        if (showsCheckedIcon()) {
            calculateChipIconBounds(bounds, rectF);
            float f7 = rectF.left;
            float f8 = rectF.top;
            canvas2.translate(f7, f8);
            this.checkedIcon.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.checkedIcon.draw(canvas2);
            canvas2.translate(-f7, -f8);
        }
        if (this.shouldDrawText && this.text != null) {
            PointF pointF = this.pointF;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.text;
            TextDrawableHelper textDrawableHelper = this.textDrawableHelper;
            if (charSequence != null) {
                float fCalculateChipIconWidth = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + fCalculateChipIconWidth;
                } else {
                    pointF.x = bounds.right - fCalculateChipIconWidth;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = textDrawableHelper.textPaint;
                Paint.FontMetrics fontMetrics = this.fontMetrics;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.text != null) {
                float fCalculateChipIconWidth2 = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                float fCalculateCloseIconWidth = calculateCloseIconWidth() + this.chipEndPadding + this.textEndPadding;
                int layoutDirection = getLayoutDirection();
                int i3 = bounds.left;
                if (layoutDirection == 0) {
                    rectF.left = i3 + fCalculateChipIconWidth2;
                    f = bounds.right - fCalculateCloseIconWidth;
                } else {
                    rectF.left = i3 + fCalculateCloseIconWidth;
                    f = bounds.right - fCalculateChipIconWidth2;
                }
                rectF.right = f;
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            TextAppearance textAppearance = textDrawableHelper.textAppearance;
            TextPaint textPaint2 = textDrawableHelper.textPaint;
            if (textAppearance != null) {
                textPaint2.drawableState = getState();
                textDrawableHelper.textAppearance.updateDrawState(this.context, textPaint2, textDrawableHelper.fontCallback);
            }
            textPaint2.setTextAlign(align);
            boolean z2 = Math.round(textDrawableHelper.getTextWidth(this.text.toString())) > Math.round(rectF.width());
            if (z2) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i2 = iSave;
            } else {
                i2 = 0;
            }
            CharSequence charSequenceEllipsize = this.text;
            if (z2 && this.truncateAt != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.truncateAt);
            }
            canvas2.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            if (z2) {
                canvas2.restoreToCount(i2);
            }
        }
        if (showsCloseIcon()) {
            rectF.setEmpty();
            if (showsCloseIcon()) {
                float f9 = this.chipEndPadding + this.closeIconEndPadding;
                if (getLayoutDirection() == 0) {
                    float f10 = bounds.right - f9;
                    rectF.right = f10;
                    rectF.left = f10 - this.closeIconSize;
                } else {
                    float f11 = bounds.left + f9;
                    rectF.left = f11;
                    rectF.right = f11 + this.closeIconSize;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f12 = this.closeIconSize;
                float f13 = fExactCenterY - (f12 / 2.0f);
                rectF.top = f13;
                rectF.bottom = f13 + f12;
            }
            float f14 = rectF.left;
            float f15 = rectF.top;
            canvas2.translate(f14, f15);
            this.closeIcon.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.closeIconRipple.setBounds(this.closeIcon.getBounds());
            this.closeIconRipple.jumpToCurrentState();
            this.closeIconRipple.draw(canvas2);
            canvas2.translate(-f14, -f15);
        }
        if (this.alpha < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.alpha;
    }

    public final float getChipCornerRadius() {
        return this.isShapeThemingEnabled ? getTopLeftCornerResolvedSize() : this.chipCornerRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(calculateCloseIconWidth() + this.textDrawableHelper.getTextWidth(this.text.toString()) + calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding + this.textEndPadding + this.chipEndPadding), this.maxWidth);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.isShapeThemingEnabled) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.chipMinHeight, this.chipCornerRadius);
        } else {
            outline.setRoundRect(bounds, this.chipCornerRadius);
            outline2 = outline;
        }
        outline2.setAlpha(this.alpha / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (isStateful(this.chipSurfaceColor) || isStateful(this.chipBackgroundColor) || isStateful(this.chipStrokeColor)) {
            return true;
        }
        TextAppearance textAppearance = this.textDrawableHelper.textAppearance;
        if (textAppearance == null || (colorStateList = textAppearance.textColor) == null || !colorStateList.isStateful()) {
            return (this.checkedIconVisible && this.checkedIcon != null && this.checkable) || isStateful(this.chipIcon) || isStateful(this.checkedIcon) || isStateful(this.tint);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (showsChipIcon()) {
            zOnLayoutDirectionChanged |= this.chipIcon.setLayoutDirection(i);
        }
        if (showsCheckedIcon()) {
            zOnLayoutDirectionChanged |= this.checkedIcon.setLayoutDirection(i);
        }
        if (showsCloseIcon()) {
            zOnLayoutDirectionChanged |= this.closeIcon.setLayoutDirection(i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (showsChipIcon()) {
            zOnLevelChange |= this.chipIcon.setLevel(i);
        }
        if (showsCheckedIcon()) {
            zOnLevelChange |= this.checkedIcon.setLevel(i);
        }
        if (showsCloseIcon()) {
            zOnLevelChange |= this.closeIcon.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    public final void onSizeChange() {
        Delegate delegate = (Delegate) this.delegate.get();
        if (delegate != null) {
            delegate.onChipDrawableSizeChange();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final boolean onStateChange(int[] iArr) {
        if (this.isShapeThemingEnabled) {
            super.onStateChange(iArr);
        }
        return onStateChange(iArr, this.closeIconStateSet);
    }

    public final boolean onStateChange(int[] iArr, int[] iArr2) {
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.chipSurfaceColor;
        int iCompositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.currentChipSurfaceColor) : 0);
        boolean state = true;
        if (this.currentChipSurfaceColor != iCompositeElevationOverlayIfNeeded) {
            this.currentChipSurfaceColor = iCompositeElevationOverlayIfNeeded;
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.chipBackgroundColor;
        int iCompositeElevationOverlayIfNeeded2 = compositeElevationOverlayIfNeeded(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.currentChipBackgroundColor) : 0);
        if (this.currentChipBackgroundColor != iCompositeElevationOverlayIfNeeded2) {
            this.currentChipBackgroundColor = iCompositeElevationOverlayIfNeeded2;
            zOnStateChange = true;
        }
        int iB = je.b(iCompositeElevationOverlayIfNeeded2, iCompositeElevationOverlayIfNeeded);
        if ((this.currentCompositeSurfaceBackgroundColor != iB) | (getFillColor() == null)) {
            this.currentCompositeSurfaceBackgroundColor = iB;
            setFillColor(ColorStateList.valueOf(iB));
            zOnStateChange = true;
        }
        ColorStateList colorStateList4 = this.chipStrokeColor;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.currentChipStrokeColor) : 0;
        if (this.currentChipStrokeColor != colorForState) {
            this.currentChipStrokeColor = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.compatRippleColor == null || !RippleUtils.shouldDrawRippleCompat(iArr)) ? 0 : this.compatRippleColor.getColorForState(iArr, this.currentCompatRippleColor);
        if (this.currentCompatRippleColor != colorForState2) {
            this.currentCompatRippleColor = colorForState2;
        }
        TextAppearance textAppearance = this.textDrawableHelper.textAppearance;
        int colorForState3 = (textAppearance == null || (colorStateList = textAppearance.textColor) == null) ? 0 : colorStateList.getColorForState(iArr, this.currentTextColor);
        if (this.currentTextColor != colorForState3) {
            this.currentTextColor = colorForState3;
            zOnStateChange = true;
        }
        int[] state2 = getState();
        if (state2 != null) {
            int length = state2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (state2[i] != 16842912) {
                        i++;
                    } else if (this.checkable) {
                        z = true;
                        break;
                    }
                }
                z = false;
                break;
            }
        } else {
            z = false;
            break;
        }
        if (this.currentChecked == z || this.checkedIcon == null) {
            z2 = false;
        } else {
            float fCalculateChipIconWidth = calculateChipIconWidth();
            this.currentChecked = z;
            if (fCalculateChipIconWidth != calculateChipIconWidth()) {
                zOnStateChange = true;
                z2 = true;
            } else {
                z2 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList5 = this.tint;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.currentTint) : 0;
        if (this.currentTint != colorForState4) {
            this.currentTint = colorForState4;
            ColorStateList colorStateList6 = this.tint;
            PorterDuff.Mode mode = this.tintMode;
            this.tintFilter = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
        } else {
            state = zOnStateChange;
        }
        if (isStateful(this.chipIcon)) {
            state |= this.chipIcon.setState(iArr);
        }
        if (isStateful(this.checkedIcon)) {
            state |= this.checkedIcon.setState(iArr);
        }
        if (isStateful(this.closeIcon)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.closeIcon.setState(iArr3);
        }
        if (isStateful(this.closeIconRipple)) {
            state |= this.closeIconRipple.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z2) {
            onSizeChange();
        }
        return state;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    public final void setCheckedIconVisible(boolean z) {
        if (this.checkedIconVisible != z) {
            boolean zShowsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z;
            boolean zShowsCheckedIcon2 = showsCheckedIcon();
            if (zShowsCheckedIcon != zShowsCheckedIcon2) {
                Drawable drawable = this.checkedIcon;
                if (zShowsCheckedIcon2) {
                    applyChildDrawable(drawable);
                } else {
                    unapplyChildDrawable(drawable);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public final void setChipIconVisible(boolean z) {
        if (this.chipIconVisible != z) {
            boolean zShowsChipIcon = showsChipIcon();
            this.chipIconVisible = z;
            boolean zShowsChipIcon2 = showsChipIcon();
            if (zShowsChipIcon != zShowsChipIcon2) {
                Drawable drawable = this.chipIcon;
                if (zShowsChipIcon2) {
                    applyChildDrawable(drawable);
                } else {
                    unapplyChildDrawable(drawable);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public final void setCloseIconVisible(boolean z) {
        if (this.closeIconVisible != z) {
            boolean zShowsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z;
            boolean zShowsCloseIcon2 = showsCloseIcon();
            if (zShowsCloseIcon != zShowsCloseIcon2) {
                Drawable drawable = this.closeIcon;
                if (zShowsCloseIcon2) {
                    applyChildDrawable(drawable);
                } else {
                    unapplyChildDrawable(drawable);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.colorFilter != colorFilter) {
            this.colorFilter = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.tintMode != mode) {
            this.tintMode = mode;
            ColorStateList colorStateList = this.tint;
            this.tintFilter = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z, z2);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z, z2);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final boolean showsCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.currentChecked;
    }

    public final boolean showsChipIcon() {
        return this.chipIconVisible && this.chipIcon != null;
    }

    public final boolean showsCloseIcon() {
        return this.closeIconVisible && this.closeIcon != null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
