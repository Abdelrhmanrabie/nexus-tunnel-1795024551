package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.a71;
import defpackage.d;
import defpackage.e;
import defpackage.qd1;
import defpackage.y4;
import defpackage.z4;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends z4 implements Checkable, Shapeable {
    public static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public boolean broadcasting;
    public boolean checked;
    public Drawable icon;
    public final int iconGravity;
    public int iconLeft;
    public final int iconPadding;
    public final int iconSize;
    public final ColorStateList iconTint;
    public final PorterDuff.Mode iconTintMode;
    public int iconTop;
    public final MaterialButtonHelper materialButtonHelper;
    public final LinkedHashSet onCheckedChangeListeners;
    public OnPressedChangeListener onPressedChangeListenerInternal;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnPressedChangeListener {
        void onPressedChanged();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SavedState extends d {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.button.MaterialButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public boolean checked;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            this.checked = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // defpackage.d, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.checked ? 1 : 0);
        }
    }

    public MaterialButton(Context context) {
        this(context, null);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.sw);
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
    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.a0x), attributeSet, i);
        this.onCheckedChangeListeners = new LinkedHashSet();
        this.checked = false;
        this.broadcasting = false;
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.MaterialButton, i, org.hamotunnelplus.xyz.R.plurals.a0x, new int[0]);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        this.iconPadding = dimensionPixelSize;
        int i2 = typedArrayObtainStyledAttributes.getInt(15, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.iconTintMode = ViewUtils.parseTintMode(i2, mode);
        this.iconTint = MaterialResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes, 14);
        this.icon = MaterialResources.getDrawable(getContext(), typedArrayObtainStyledAttributes, 10);
        this.iconGravity = typedArrayObtainStyledAttributes.getInteger(11, 1);
        this.iconSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, 0);
        MaterialButtonHelper materialButtonHelper = new MaterialButtonHelper(this, ShapeAppearanceModel.builder(context2, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.a0x).build());
        this.materialButtonHelper = materialButtonHelper;
        materialButtonHelper.insetLeft = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        materialButtonHelper.insetRight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0);
        materialButtonHelper.insetTop = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
        materialButtonHelper.insetBottom = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, 0);
        if (typedArrayObtainStyledAttributes.hasValue(8)) {
            int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, -1);
            ShapeAppearanceModel shapeAppearanceModel = materialButtonHelper.shapeAppearanceModel;
            shapeAppearanceModel.getClass();
            ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModel);
            builder.setAllCornerSizes(dimensionPixelSize2);
            materialButtonHelper.setShapeAppearanceModel(builder.build());
        }
        materialButtonHelper.strokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(20, 0);
        materialButtonHelper.backgroundTintMode = ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(7, -1), mode);
        MaterialButton materialButton = materialButtonHelper.materialButton;
        materialButtonHelper.backgroundTint = MaterialResources.getColorStateList(materialButton.getContext(), typedArrayObtainStyledAttributes, 6);
        materialButtonHelper.strokeColor = MaterialResources.getColorStateList(materialButton.getContext(), typedArrayObtainStyledAttributes, 19);
        materialButtonHelper.rippleColor = MaterialResources.getColorStateList(materialButton.getContext(), typedArrayObtainStyledAttributes, 16);
        materialButtonHelper.checkable = typedArrayObtainStyledAttributes.getBoolean(5, false);
        materialButtonHelper.elevation = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0);
        WeakHashMap weakHashMap = qd1.a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            materialButtonHelper.backgroundOverwritten = true;
            materialButton.setSupportBackgroundTintList(materialButtonHelper.backgroundTint);
            materialButton.setSupportBackgroundTintMode(materialButtonHelper.backgroundTintMode);
            z2 = false;
            z = true;
        } else {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialButtonHelper.shapeAppearanceModel);
            materialShapeDrawable.initializeElevationOverlay(materialButton.getContext());
            materialShapeDrawable.setTintList(materialButtonHelper.backgroundTint);
            PorterDuff.Mode mode2 = materialButtonHelper.backgroundTintMode;
            if (mode2 != null) {
                materialShapeDrawable.setTintMode(mode2);
            }
            float f = materialButtonHelper.strokeWidth;
            ColorStateList colorStateList = materialButtonHelper.strokeColor;
            materialShapeDrawable.setStrokeWidth(f);
            materialShapeDrawable.setStrokeColor(colorStateList);
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialButtonHelper.shapeAppearanceModel);
            materialShapeDrawable2.setTint(0);
            float f2 = materialButtonHelper.strokeWidth;
            z = true;
            int color = materialButtonHelper.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(materialButton, org.hamotunnelplus.xyz.R.style.gx) : 0;
            materialShapeDrawable2.setStrokeWidth(f2);
            materialShapeDrawable2.setStrokeColor(ColorStateList.valueOf(color));
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialButtonHelper.shapeAppearanceModel);
            materialButtonHelper.maskDrawable = materialShapeDrawable3;
            materialShapeDrawable3.setTint(-1);
            RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(materialButtonHelper.rippleColor), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable}), materialButtonHelper.insetLeft, materialButtonHelper.insetTop, materialButtonHelper.insetRight, materialButtonHelper.insetBottom), materialButtonHelper.maskDrawable);
            materialButtonHelper.rippleDrawable = rippleDrawable;
            super.setBackgroundDrawable(rippleDrawable);
            z2 = false;
            MaterialShapeDrawable materialShapeDrawable4 = materialButtonHelper.getMaterialShapeDrawable(false);
            if (materialShapeDrawable4 != null) {
                materialShapeDrawable4.setElevation(materialButtonHelper.elevation);
            }
        }
        materialButton.setPaddingRelative(paddingStart + materialButtonHelper.insetLeft, paddingTop + materialButtonHelper.insetTop, paddingEnd + materialButtonHelper.insetRight, paddingBottom + materialButtonHelper.insetBottom);
        typedArrayObtainStyledAttributes.recycle();
        setCompoundDrawablePadding(dimensionPixelSize);
        updateIcon(this.icon != null ? z : z2);
    }

    @Override // android.view.View
    public final ColorStateList getBackgroundTintList() {
        a71 a71Var;
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.backgroundTint;
        }
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var == null || (a71Var = y4Var.e) == null) {
            return null;
        }
        return a71Var.a;
    }

    @Override // android.view.View
    public final PorterDuff.Mode getBackgroundTintMode() {
        a71 a71Var;
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.backgroundTintMode;
        }
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var == null || (a71Var = y4Var.e) == null) {
            return null;
        }
        return a71Var.b;
    }

    @Override // com.google.android.material.shape.Shapeable
    public final ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.shapeAppearanceModel;
        }
        d.AnonymousClass0.m("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
        return null;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.checked;
    }

    public final boolean isUsingOriginalBackground() {
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        return (materialButtonHelper == null || materialButtonHelper.backgroundOverwritten) ? false : true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground()) {
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        if (materialButtonHelper != null && materialButtonHelper.checkable) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (this.checked) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // defpackage.z4, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        accessibilityEvent.setClassName(((materialButtonHelper == null || !materialButtonHelper.checkable) ? Button.class : CompoundButton.class).getName());
        accessibilityEvent.setChecked(this.checked);
    }

    @Override // defpackage.z4, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        accessibilityNodeInfo.setClassName(((materialButtonHelper == null || !materialButtonHelper.checkable) ? Button.class : CompoundButton.class).getName());
        accessibilityNodeInfo.setCheckable(materialButtonHelper != null && materialButtonHelper.checkable);
        accessibilityNodeInfo.setChecked(this.checked);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        setChecked(savedState.checked);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = this.checked;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateIconPosition(i, i2);
    }

    @Override // defpackage.z4, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.icon != null) {
            if (this.icon.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public final void resetIconDrawable() {
        int i = this.iconGravity;
        boolean z = true;
        if (i != 1 && i != 2) {
            z = false;
        }
        if (z) {
            setCompoundDrawablesRelative(this.icon, null, null, null);
            return;
        }
        if (i == 3 || i == 4) {
            setCompoundDrawablesRelative(null, null, this.icon, null);
        } else if (i == 16 || i == 32) {
            setCompoundDrawablesRelative(null, this.icon, null, null);
        }
    }

    @Override // android.view.View
    public final void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        if (!isUsingOriginalBackground()) {
            super.setBackgroundColor(i);
            return;
        }
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        if (materialButtonHelper.getMaterialShapeDrawable(false) != null) {
            materialButtonHelper.getMaterialShapeDrawable(false).setTint(i);
        }
    }

    @Override // defpackage.z4, android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        if (isUsingOriginalBackground()) {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            materialButtonHelper.backgroundOverwritten = true;
            MaterialButton materialButton = materialButtonHelper.materialButton;
            materialButton.setSupportBackgroundTintList(materialButtonHelper.backgroundTint);
            materialButton.setSupportBackgroundTintMode(materialButtonHelper.backgroundTintMode);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // defpackage.z4, android.view.View
    public final void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? e.s(getContext(), i) : null);
    }

    @Override // android.view.View
    public final void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public final void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z) {
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        if (materialButtonHelper == null || !materialButtonHelper.checkable || !isEnabled() || this.checked == z) {
            return;
        }
        this.checked = z;
        refreshDrawableState();
        if (this.broadcasting) {
            return;
        }
        this.broadcasting = true;
        Iterator it = this.onCheckedChangeListeners.iterator();
        while (it.hasNext()) {
            ((OnCheckedChangeListener) it.next()).onCheckedChanged(this, this.checked);
        }
        this.broadcasting = false;
    }

    @Override // android.view.View
    public final void setElevation(float f) {
        super.setElevation(f);
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.getMaterialShapeDrawable(false).setElevation(f);
        }
    }

    @Override // android.view.View
    public final void setPressed(boolean z) {
        OnPressedChangeListener onPressedChangeListener = this.onPressedChangeListenerInternal;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.onPressedChanged();
        }
        super.setPressed(z);
    }

    @Override // com.google.android.material.shape.Shapeable
    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShapeAppearanceModel(shapeAppearanceModel);
        } else {
            d.AnonymousClass0.m("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
    }

    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (materialButtonHelper.backgroundTint != colorStateList) {
                materialButtonHelper.backgroundTint = colorStateList;
                if (materialButtonHelper.getMaterialShapeDrawable(false) != null) {
                    materialButtonHelper.getMaterialShapeDrawable(false).setTintList(materialButtonHelper.backgroundTint);
                    return;
                }
                return;
            }
            return;
        }
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            if (y4Var.e == null) {
                y4Var.e = new a71();
            }
            a71 a71Var = y4Var.e;
            a71Var.a = colorStateList;
            a71Var.d = true;
            y4Var.a();
        }
    }

    public final void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (isUsingOriginalBackground()) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (materialButtonHelper.backgroundTintMode != mode) {
                materialButtonHelper.backgroundTintMode = mode;
                if (materialButtonHelper.getMaterialShapeDrawable(false) == null || materialButtonHelper.backgroundTintMode == null) {
                    return;
                }
                materialButtonHelper.getMaterialShapeDrawable(false).setTintMode(materialButtonHelper.backgroundTintMode);
                return;
            }
            return;
        }
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            if (y4Var.e == null) {
                y4Var.e = new a71();
            }
            a71 a71Var = y4Var.e;
            a71Var.b = mode;
            a71Var.c = true;
            y4Var.a();
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.checked);
    }

    public final void updateIcon(boolean z) {
        Drawable drawable = this.icon;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.icon = drawableMutate;
            drawableMutate.setTintList(this.iconTint);
            PorterDuff.Mode mode = this.iconTintMode;
            if (mode != null) {
                this.icon.setTintMode(mode);
            }
            int intrinsicHeight = this.iconSize;
            int intrinsicWidth = intrinsicHeight != 0 ? intrinsicHeight : this.icon.getIntrinsicWidth();
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.icon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.icon;
            int i = this.iconLeft;
            int i2 = this.iconTop;
            drawable2.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
            this.icon.setVisible(true, z);
        }
        if (z) {
            resetIconDrawable();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i3 = this.iconGravity;
        if (((i3 == 1 || i3 == 2) && drawable3 != this.icon) || (((i3 == 3 || i3 == 4) && drawable5 != this.icon) || ((i3 == 16 || i3 == 32) && drawable4 != this.icon))) {
            resetIconDrawable();
        }
    }

    public final void updateIconPosition(int i, int i2) {
        if (this.icon == null || getLayout() == null) {
            return;
        }
        int i3 = this.iconPadding;
        int intrinsicWidth = this.iconSize;
        int i4 = this.iconGravity;
        if (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4) {
            this.iconTop = 0;
            if (i4 == 1 || i4 == 3) {
                this.iconLeft = 0;
                updateIcon(false);
                return;
            }
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.icon.getIntrinsicWidth();
            }
            TextPaint paint = getPaint();
            String string = getText().toString();
            if (getTransformationMethod() != null) {
                string = getTransformationMethod().getTransformation(string, this).toString();
            }
            int iMin = i - Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
            WeakHashMap weakHashMap = qd1.a;
            int paddingEnd = ((((iMin - getPaddingEnd()) - intrinsicWidth) - i3) - getPaddingStart()) / 2;
            if ((getLayoutDirection() == 1) != (i4 == 4)) {
                paddingEnd = -paddingEnd;
            }
            if (this.iconLeft != paddingEnd) {
                this.iconLeft = paddingEnd;
                updateIcon(false);
            }
            return;
        }
        if (i4 == 16 || i4 == 32) {
            this.iconLeft = 0;
            if (i4 == 16) {
                this.iconTop = 0;
                updateIcon(false);
                return;
            }
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.icon.getIntrinsicHeight();
            }
            TextPaint paint2 = getPaint();
            String string2 = getText().toString();
            if (getTransformationMethod() != null) {
                string2 = getTransformationMethod().getTransformation(string2, this).toString();
            }
            Rect rect = new Rect();
            paint2.getTextBounds(string2, 0, string2.length(), rect);
            int iMin2 = (((((i2 - Math.min(rect.height(), getLayout().getHeight())) - getPaddingTop()) - intrinsicWidth) - i3) - getPaddingBottom()) / 2;
            if (this.iconTop != iMin2) {
                this.iconTop = iMin2;
                updateIcon(false);
            }
        }
    }
}
