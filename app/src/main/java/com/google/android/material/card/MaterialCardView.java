package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.e4;
import defpackage.qd1;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {
    public static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public final MaterialCardViewHelper cardViewHelper;
    public boolean checked;
    public final boolean isParentCardViewDoneInitializing;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnCheckedChangeListener {
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.tf);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.a19), attributeSet, i);
        this.checked = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R.styleable.MaterialCardView, i, org.hamotunnelplus.xyz.R.plurals.a19, new int[0]);
        MaterialCardViewHelper materialCardViewHelper = new MaterialCardViewHelper(this, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.a19);
        this.cardViewHelper = materialCardViewHelper;
        ColorStateList colorStateList = this.mCardViewDelegate.a.h;
        MaterialShapeDrawable materialShapeDrawable = materialCardViewHelper.bgDrawable;
        materialShapeDrawable.setFillColor(colorStateList);
        Rect rect = this.mContentPadding;
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        Rect rect2 = materialCardViewHelper.userContentPadding;
        rect2.set(i2, i3, i4, i5);
        MaterialCardView materialCardView = materialCardViewHelper.materialCardView;
        boolean z = materialCardView.mPreventCornerOverlap;
        CardView.a aVar = materialCardView.mCardViewDelegate;
        float f = 0.0f;
        float fCalculateActualCornerPadding = ((!z || materialShapeDrawable.isRoundRect()) && !materialCardViewHelper.shouldAddCornerPaddingOutsideCardBackground()) ? 0.0f : materialCardViewHelper.calculateActualCornerPadding();
        if (materialCardView.mPreventCornerOverlap && materialCardView.mCompatPadding) {
            f = (float) ((1.0d - MaterialCardViewHelper.COS_45) * ((double) aVar.a.a));
        }
        int i6 = (int) (fCalculateActualCornerPadding - f);
        materialCardView.mContentPadding.set(rect2.left + i6, rect2.top + i6, rect2.right + i6, rect2.bottom + i6);
        e4.b(aVar);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(materialCardView.getContext(), typedArrayObtainStyledAttributes, 10);
        materialCardViewHelper.strokeColor = colorStateList2;
        if (colorStateList2 == null) {
            materialCardViewHelper.strokeColor = ColorStateList.valueOf(-1);
        }
        materialCardViewHelper.strokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, 0);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        materialCardViewHelper.checkable = z2;
        materialCardView.setLongClickable(z2);
        materialCardViewHelper.checkedIconTint = MaterialResources.getColorStateList(materialCardView.getContext(), typedArrayObtainStyledAttributes, 5);
        Drawable drawable = MaterialResources.getDrawable(materialCardView.getContext(), typedArrayObtainStyledAttributes, 2);
        materialCardViewHelper.checkedIcon = drawable;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            materialCardViewHelper.checkedIcon = drawableMutate;
            drawableMutate.setTintList(materialCardViewHelper.checkedIconTint);
            boolean z3 = materialCardView.checked;
            Drawable drawable2 = materialCardViewHelper.checkedIcon;
            if (drawable2 != null) {
                drawable2.setAlpha(z3 ? 255 : 0);
            }
        }
        LayerDrawable layerDrawable = materialCardViewHelper.clickableForegroundDrawable;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(org.hamotunnelplus.xyz.R.attr.rk, materialCardViewHelper.checkedIcon);
        }
        materialCardViewHelper.checkedIconSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
        materialCardViewHelper.checkedIconMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0);
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(materialCardView.getContext(), typedArrayObtainStyledAttributes, 6);
        materialCardViewHelper.rippleColor = colorStateList3;
        if (colorStateList3 == null) {
            materialCardViewHelper.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(materialCardView, org.hamotunnelplus.xyz.R.style.g5));
        }
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(materialCardView.getContext(), typedArrayObtainStyledAttributes, 1);
        colorStateList4 = colorStateList4 == null ? ColorStateList.valueOf(0) : colorStateList4;
        MaterialShapeDrawable materialShapeDrawable2 = materialCardViewHelper.foregroundContentDrawable;
        materialShapeDrawable2.setFillColor(colorStateList4);
        RippleDrawable rippleDrawable = materialCardViewHelper.rippleDrawable;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(materialCardViewHelper.rippleColor);
        }
        materialShapeDrawable.setElevation(CardView.this.getElevation());
        float f2 = materialCardViewHelper.strokeWidth;
        ColorStateList colorStateList5 = materialCardViewHelper.strokeColor;
        materialShapeDrawable2.setStrokeWidth(f2);
        materialShapeDrawable2.setStrokeColor(colorStateList5);
        super.setBackgroundDrawable(materialCardViewHelper.insetDrawable(materialShapeDrawable));
        Drawable clickableForeground = materialCardView.isClickable() ? materialCardViewHelper.getClickableForeground() : materialShapeDrawable2;
        materialCardViewHelper.fgDrawable = clickableForeground;
        materialCardView.setForeground(materialCardViewHelper.insetDrawable(clickableForeground));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.google.android.material.shape.Shapeable
    public final ShapeAppearanceModel getShapeAppearanceModel() {
        return this.cardViewHelper.shapeAppearanceModel;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.checked;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.cardViewHelper.bgDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (materialCardViewHelper != null && materialCardViewHelper.checkable) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (this.checked) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.checked);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        accessibilityNodeInfo.setCheckable(materialCardViewHelper != null && materialCardViewHelper.checkable);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.checked);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        MaterialCardView materialCardView = materialCardViewHelper.materialCardView;
        if (materialCardViewHelper.clickableForegroundDrawable != null) {
            int i5 = materialCardViewHelper.checkedIconMargin;
            int i6 = materialCardViewHelper.checkedIconSize;
            int iCeil = (measuredWidth - i5) - i6;
            int iCeil2 = (measuredHeight - i5) - i6;
            if (materialCardView.mCompatPadding) {
                iCeil2 -= (int) Math.ceil(((materialCardView.mCardViewDelegate.a.e * 1.5f) + (materialCardViewHelper.shouldAddCornerPaddingOutsideCardBackground() ? materialCardViewHelper.calculateActualCornerPadding() : 0.0f)) * 2.0f);
                iCeil -= (int) Math.ceil((materialCardViewHelper.materialCardView.mCardViewDelegate.a.e + (materialCardViewHelper.shouldAddCornerPaddingOutsideCardBackground() ? materialCardViewHelper.calculateActualCornerPadding() : 0.0f)) * 2.0f);
            }
            int i7 = iCeil2;
            int i8 = materialCardViewHelper.checkedIconMargin;
            WeakHashMap weakHashMap = qd1.a;
            if (materialCardView.getLayoutDirection() == 1) {
                i4 = iCeil;
                i3 = i8;
            } else {
                i3 = iCeil;
                i4 = i8;
            }
            materialCardViewHelper.clickableForegroundDrawable.setLayerInset(2, i3, materialCardViewHelper.checkedIconMargin, i4, i7);
        }
    }

    @Override // android.view.View
    public final void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        if (this.isParentCardViewDoneInitializing) {
            MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
            if (!materialCardViewHelper.isBackgroundOverwritten) {
                materialCardViewHelper.isBackgroundOverwritten = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z) {
        if (this.checked != z) {
            toggle();
        }
    }

    @Override // android.view.View
    public final void setClickable(boolean z) {
        super.setClickable(z);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (materialCardViewHelper != null) {
            Drawable drawable = materialCardViewHelper.fgDrawable;
            MaterialCardView materialCardView = materialCardViewHelper.materialCardView;
            Drawable clickableForeground = materialCardView.isClickable() ? materialCardViewHelper.getClickableForeground() : materialCardViewHelper.foregroundContentDrawable;
            materialCardViewHelper.fgDrawable = clickableForeground;
            if (drawable != clickableForeground) {
                if (materialCardView.getForeground() instanceof InsetDrawable) {
                    ((InsetDrawable) materialCardView.getForeground()).setDrawable(clickableForeground);
                } else {
                    materialCardView.setForeground(materialCardViewHelper.insetDrawable(clickableForeground));
                }
            }
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        RectF rectF = new RectF();
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        rectF.set(materialCardViewHelper.bgDrawable.getBounds());
        setClipToOutline(shapeAppearanceModel.isRoundRect(rectF));
        materialCardViewHelper.setShapeAppearanceModel(shapeAppearanceModel);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        RippleDrawable rippleDrawable;
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (materialCardViewHelper != null && materialCardViewHelper.checkable && isEnabled()) {
            this.checked = !this.checked;
            refreshDrawableState();
            if (Build.VERSION.SDK_INT > 26 && (rippleDrawable = materialCardViewHelper.rippleDrawable) != null) {
                Rect bounds = rippleDrawable.getBounds();
                int i = bounds.bottom;
                materialCardViewHelper.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
                materialCardViewHelper.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i);
            }
            boolean z = this.checked;
            Drawable drawable = materialCardViewHelper.checkedIcon;
            if (drawable != null) {
                drawable.setAlpha(z ? 255 : 0);
            }
        }
    }
}
