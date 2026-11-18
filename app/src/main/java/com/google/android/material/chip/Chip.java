package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.customview.widget.a;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.d;
import defpackage.o1;
import defpackage.qd1;
import defpackage.qz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable {
    public final ChipDrawable chipDrawable;
    public boolean closeIconFocused;
    public boolean closeIconHovered;
    public boolean closeIconPressed;
    public boolean deferredCheckedValue;
    public final boolean ensureMinTouchTargetSize;
    public final TextAppearanceFontCallback fontCallback;
    public InsetDrawable insetBackgroundDrawable;
    public int lastLayoutDirection;
    public int minTouchTargetSize;
    public CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
    public final Rect rect;
    public final RectF rectF;
    public RippleDrawable ripple;
    public static final Rect EMPTY_BOUNDS = new Rect();
    public static final int[] SELECTED_STATE = {R.attr.state_selected};
    public static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class ChipTouchHelper extends a {
        public ChipTouchHelper(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.a
        public final void getVisibleVirtualViews(ArrayList arrayList) {
            arrayList.add(0);
            int[] iArr = Chip.CHECKABLE_STATE_SET;
            ChipDrawable chipDrawable = Chip.this.chipDrawable;
        }

        @Override // androidx.customview.widget.a
        public final boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (i2 == 16) {
                Chip chip = Chip.this;
                if (i == 0) {
                    return chip.performClick();
                }
                if (i == 1) {
                    chip.playSoundEffect(0);
                }
            }
            return false;
        }

        @Override // androidx.customview.widget.a
        public final void onPopulateNodeForHost(o1 o1Var) {
            AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
            Chip chip = Chip.this;
            ChipDrawable chipDrawable = chip.chipDrawable;
            accessibilityNodeInfo.setCheckable(chipDrawable != null && chipDrawable.checkable);
            accessibilityNodeInfo.setClickable(chip.isClickable());
            o1Var.i(chip.getAccessibilityClassName());
            accessibilityNodeInfo.setText(chip.getText());
        }

        @Override // androidx.customview.widget.a
        public final void onPopulateNodeForVirtualView(int i, o1 o1Var) {
            AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
            CharSequence charSequence = AppConfig.CUSTOM;
            if (i != 1) {
                accessibilityNodeInfo.setContentDescription(AppConfig.CUSTOM);
                accessibilityNodeInfo.setBoundsInParent(Chip.EMPTY_BOUNDS);
                return;
            }
            Chip chip = Chip.this;
            chip.getClass();
            CharSequence text = chip.getText();
            Context context = chip.getContext();
            if (!TextUtils.isEmpty(text)) {
                charSequence = text;
            }
            accessibilityNodeInfo.setContentDescription(context.getString(org.hamotunnelplus.xyz.R.string.io, charSequence).trim());
            RectF rectF = chip.rectF;
            rectF.setEmpty();
            Rect rect = chip.rect;
            rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            accessibilityNodeInfo.setBoundsInParent(rect);
            o1Var.b(o1.a.g);
            accessibilityNodeInfo.setEnabled(chip.isEnabled());
        }

        @Override // androidx.customview.widget.a
        public final void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
            if (i == 1) {
                Chip chip = Chip.this;
                chip.closeIconFocused = z;
                chip.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.ev);
    }

    public Chip(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.a1a), attributeSet, i);
        this.rect = new Rect();
        this.rectF = new RectF();
        this.fontCallback = new TextAppearanceFontCallback() { // from class: com.google.android.material.chip.Chip.1
            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public final void onFontRetrievalFailed(int i2) {
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public final void onFontRetrieved(Typeface typeface, boolean z) {
                Chip chip = Chip.this;
                ChipDrawable chipDrawable = chip.chipDrawable;
                chip.setText(chipDrawable.shouldDrawText ? chipDrawable.text : chip.getText());
                chip.requestLayout();
                chip.invalidate();
            }
        };
        Context context2 = getContext();
        if (attributeSet != null) {
            attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background");
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                d.AnonymousClass0.m$3("Please set left drawable using R.attr#chipIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                d.AnonymousClass0.m$3("Please set start drawable using R.attr#chipIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                d.AnonymousClass0.m$3("Please set end drawable using R.attr#closeIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                d.AnonymousClass0.m$3("Please set end drawable using R.attr#closeIcon.");
                throw null;
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                d.AnonymousClass0.m$3("Chip does not support multi-line text");
                throw null;
            }
            attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627);
        }
        ChipDrawable chipDrawableCreateFromAttributes = ChipDrawable.createFromAttributes(context2, attributeSet, i);
        int[] iArr = com.google.android.material.R.styleable.Chip;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, iArr, i, org.hamotunnelplus.xyz.R.plurals.a1a, new int[0]);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(32, false);
        this.ensureMinTouchTargetSize = z;
        this.minTouchTargetSize = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
        typedArrayObtainStyledAttributes.recycle();
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != chipDrawableCreateFromAttributes) {
            if (chipDrawable != null) {
                chipDrawable.delegate = new WeakReference(null);
            }
            this.chipDrawable = chipDrawableCreateFromAttributes;
            chipDrawableCreateFromAttributes.shouldDrawText = false;
            chipDrawableCreateFromAttributes.delegate = new WeakReference(this);
            ensureAccessibleTouchTarget(this.minTouchTargetSize);
        }
        WeakHashMap weakHashMap = qd1.a;
        chipDrawableCreateFromAttributes.setElevation(getElevation());
        ThemeEnforcement.checkCompatibleTheme(context2, attributeSet, i, org.hamotunnelplus.xyz.R.plurals.a1a);
        ThemeEnforcement.checkTextAppearance(context2, attributeSet, iArr, i, org.hamotunnelplus.xyz.R.plurals.a1a, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, i, org.hamotunnelplus.xyz.R.plurals.a1a);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        new ChipTouchHelper(this);
        qd1.l(this, null);
        if (!zHasValue) {
            setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.chip.Chip.2
                @Override // android.view.ViewOutlineProvider
                public final void getOutline(View view, Outline outline) {
                    ChipDrawable chipDrawable2 = Chip.this.chipDrawable;
                    if (chipDrawable2 != null) {
                        chipDrawable2.getOutline(outline);
                    } else {
                        outline.setAlpha(0.0f);
                    }
                }
            });
        }
        setChecked(this.deferredCheckedValue);
        setText(chipDrawableCreateFromAttributes.text);
        setEllipsize(chipDrawableCreateFromAttributes.truncateAt);
        updateTextPaintDrawState();
        if (!this.chipDrawable.shouldDrawText) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        super.setGravity(8388627);
        updatePaddingInternal();
        if (z) {
            setMinHeight(this.minTouchTargetSize);
        }
        this.lastLayoutDirection = getLayoutDirection();
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i;
        int i2;
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.chipDrawable;
        boolean zOnStateChange = false;
        if (chipDrawable != null && ChipDrawable.isStateful(chipDrawable.closeIcon)) {
            ?? IsEnabled = isEnabled();
            if (this.closeIconFocused) {
                i = IsEnabled;
                i = IsEnabled + 1;
            }
            i = IsEnabled;
            int i3 = i;
            if (this.closeIconHovered) {
                i3 = i + 1;
            }
            int i4 = i3;
            if (this.closeIconPressed) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (isChecked()) {
                i5 = i4 + 1;
            }
            int[] iArr = new int[i5];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.closeIconFocused) {
                iArr[i2] = 16842908;
                i2++;
            }
            if (this.closeIconHovered) {
                iArr[i2] = 16843623;
                i2++;
            }
            if (this.closeIconPressed) {
                iArr[i2] = 16842919;
                i2++;
            }
            if (isChecked()) {
                iArr[i2] = 16842913;
            }
            ChipDrawable chipDrawable2 = this.chipDrawable;
            if (!Arrays.equals(chipDrawable2.closeIconStateSet, iArr)) {
                chipDrawable2.closeIconStateSet = iArr;
                if (chipDrawable2.showsCloseIcon()) {
                    zOnStateChange = chipDrawable2.onStateChange(chipDrawable2.getState(), iArr);
                }
            }
        }
        if (zOnStateChange) {
            invalidate();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0042 A[PHI: r11
      0x0042: PHI (r11v3 com.google.android.material.chip.ChipDrawable) = (r11v2 com.google.android.material.chip.ChipDrawable), (r11v9 com.google.android.material.chip.ChipDrawable) binds: [B:17:0x0040, B:7:0x0013] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:19:0x0045  */
    public final void ensureAccessibleTouchTarget(int i) {
        ChipDrawable chipDrawable;
        float f;
        this.minTouchTargetSize = i;
        if (this.ensureMinTouchTargetSize) {
            int iMax = Math.max(0, i - ((int) this.chipDrawable.chipMinHeight));
            int iMax2 = Math.max(0, i - this.chipDrawable.getIntrinsicWidth());
            if (iMax2 > 0 || iMax > 0) {
                int i2 = iMax2 > 0 ? iMax2 / 2 : 0;
                int i3 = iMax > 0 ? iMax / 2 : 0;
                if (this.insetBackgroundDrawable != null) {
                    Rect rect = new Rect();
                    this.insetBackgroundDrawable.getPadding(rect);
                    if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                        updateBackgroundDrawable();
                        return;
                    }
                }
                if (getMinHeight() != i) {
                    setMinHeight(i);
                }
                if (getMinWidth() != i) {
                    setMinWidth(i);
                }
                this.insetBackgroundDrawable = new InsetDrawable((Drawable) this.chipDrawable, i2, i3, i2, i3);
            } else {
                if (this.insetBackgroundDrawable == null) {
                    updateBackgroundDrawable();
                    return;
                }
                this.insetBackgroundDrawable = null;
                setMinWidth(0);
                chipDrawable = this.chipDrawable;
                if (chipDrawable != null) {
                    f = chipDrawable.chipMinHeight;
                } else {
                    f = 0.0f;
                }
                setMinHeight((int) f);
            }
        } else {
            if (this.insetBackgroundDrawable == null) {
                updateBackgroundDrawable();
                return;
            }
            this.insetBackgroundDrawable = null;
            setMinWidth(0);
            chipDrawable = this.chipDrawable;
            if (chipDrawable != null) {
                f = chipDrawable.chipMinHeight;
            } else {
                f = 0.0f;
            }
            setMinHeight((int) f);
        }
        updateBackgroundDrawable();
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public final CharSequence getAccessibilityClassName() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null || !chipDrawable.checkable) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).singleSelection) ? "android.widget.RadioButton" : "android.widget.CompoundButton";
    }

    @Override // android.widget.TextView
    public final TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            return chipDrawable.truncateAt;
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    public final ShapeAppearanceModel getShapeAppearanceModel() {
        return this.chipDrawable.getShapeAppearanceModel();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.chipDrawable);
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public final void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.minTouchTargetSize);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, SELECTED_STATE);
        }
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null && chipDrawable.checkable) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        boolean zContains;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                zContains = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        RectF rectF = this.rectF;
        rectF.setEmpty();
        zContains = rectF.contains(motionEvent.getX(), motionEvent.getY());
        if (this.closeIconHovered != zContains) {
            this.closeIconHovered = zContains;
            refreshDrawableState();
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        ChipDrawable chipDrawable = this.chipDrawable;
        int i2 = 0;
        accessibilityNodeInfo.setCheckable(chipDrawable != null && chipDrawable.checkable);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (!chipGroup.singleLine) {
                i = -1;
                break;
            }
            i = 0;
            while (true) {
                if (i2 >= chipGroup.getChildCount()) {
                    i = -1;
                    break;
                }
                if (chipGroup.getChildAt(i2) instanceof Chip) {
                    if (((Chip) chipGroup.getChildAt(i2)) == this) {
                        break;
                    } else {
                        i++;
                    }
                }
                i2++;
            }
            Object tag = getTag(org.hamotunnelplus.xyz.R.attr.vw);
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) qz.a(isChecked(), tag instanceof Integer ? ((Integer) tag).intValue() : -1, 1, i, 1).a);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        RectF rectF = this.rectF;
        rectF.setEmpty();
        if (rectF.contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.lastLayoutDirection != i) {
            this.lastLayoutDirection = i;
            updatePaddingInternal();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003b  */
    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        RectF rectF = this.rectF;
        rectF.setEmpty();
        boolean zContains = rectF.contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    boolean z2 = this.closeIconPressed;
                    if (z2) {
                        if (!zContains && z2) {
                            this.closeIconPressed = false;
                            refreshDrawableState();
                        }
                        z = true;
                    }
                } else if (actionMasked != 3) {
                }
                z = false;
            } else {
                if (this.closeIconPressed) {
                    playSoundEffect(0);
                    z = true;
                }
                if (this.closeIconPressed) {
                    this.closeIconPressed = false;
                    refreshDrawableState();
                }
            }
            z = false;
            if (this.closeIconPressed) {
                this.closeIconPressed = false;
                refreshDrawableState();
            }
        } else if (zContains) {
            if (!this.closeIconPressed) {
                this.closeIconPressed = true;
                refreshDrawableState();
            }
            z = true;
        } else {
            z = false;
        }
        return z || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackground(Drawable drawable) {
        Drawable drawable2 = this.insetBackgroundDrawable;
        if (drawable2 == null) {
            drawable2 = this.chipDrawable;
        }
        if (drawable == drawable2 || drawable == this.ripple) {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        Drawable drawable2 = this.insetBackgroundDrawable;
        if (drawable2 == null) {
            drawable2 = this.chipDrawable;
        }
        if (drawable == drawable2 || drawable == this.ripple) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public final void setBackgroundResource(int i) {
    }

    @Override // android.view.View
    public final void setBackgroundTintList(ColorStateList colorStateList) {
    }

    @Override // android.view.View
    public final void setBackgroundTintMode(PorterDuff.Mode mode) {
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) {
            this.deferredCheckedValue = z;
            return;
        }
        if (chipDrawable.checkable) {
            boolean zIsChecked = isChecked();
            super.setChecked(z);
            if (zIsChecked == z || (onCheckedChangeListener = this.onCheckedChangeListenerInternal) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        String str;
        if (drawable != null) {
            str = "Please set start drawable using R.attr#chipIcon.";
        } else {
            if (drawable3 == null) {
                super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
                return;
            }
            str = "Please set end drawable using R.attr#closeIcon.";
        }
        d.AnonymousClass0.m$3(str);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        String str;
        if (drawable != null) {
            str = "Please set start drawable using R.attr#chipIcon.";
        } else {
            if (drawable3 == null) {
                super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
                return;
            }
            str = "Please set end drawable using R.attr#closeIcon.";
        }
        d.AnonymousClass0.m$3(str);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        String str;
        if (i != 0) {
            str = "Please set start drawable using R.attr#chipIcon.";
        } else {
            if (i3 == 0) {
                super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
                return;
            }
            str = "Please set end drawable using R.attr#closeIcon.";
        }
        d.AnonymousClass0.m$3(str);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        String str;
        if (drawable != null) {
            str = "Please set start drawable using R.attr#chipIcon.";
        } else {
            if (drawable3 == null) {
                super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            str = "Please set end drawable using R.attr#closeIcon.";
        }
        d.AnonymousClass0.m$3(str);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        String str;
        if (i != 0) {
            str = "Please set start drawable using R.attr#chipIcon.";
        } else {
            if (i3 == 0) {
                super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
                return;
            }
            str = "Please set end drawable using R.attr#closeIcon.";
        }
        d.AnonymousClass0.m$3(str);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        String str;
        if (drawable != null) {
            str = "Please set left drawable using R.attr#chipIcon.";
        } else {
            if (drawable3 == null) {
                super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            str = "Please set right drawable using R.attr#closeIcon.";
        }
        d.AnonymousClass0.m$3(str);
    }

    @Override // android.view.View
    public final void setElevation(float f) {
        super.setElevation(f);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.setElevation(f);
        }
    }

    @Override // android.widget.TextView
    public final void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.chipDrawable == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            d.AnonymousClass0.m$3("Text within a chip are not allowed to scroll.");
            return;
        }
        super.setEllipsize(truncateAt);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.truncateAt = truncateAt;
        }
    }

    @Override // android.widget.TextView
    public final void setGravity(int i) {
        if (i != 8388627) {
            return;
        }
        super.setGravity(i);
    }

    @Override // android.view.View
    public final void setLayoutDirection(int i) {
        if (this.chipDrawable == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public final void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
        } else {
            d.AnonymousClass0.m$3("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public final void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
        } else {
            d.AnonymousClass0.m$3("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public final void setMaxWidth(int i) {
        super.setMaxWidth(i);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            chipDrawable.maxWidth = i;
        }
    }

    @Override // android.widget.TextView
    public final void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
        } else {
            d.AnonymousClass0.m$3("Chip does not support multi-line text");
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.chipDrawable.setShapeAppearanceModel(shapeAppearanceModel);
    }

    @Override // android.widget.TextView
    public final void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
        } else {
            d.AnonymousClass0.m$3("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = AppConfig.CUSTOM;
        }
        super.setText(chipDrawable.shouldDrawText ? null : charSequence, bufferType);
        ChipDrawable chipDrawable2 = this.chipDrawable;
        if (chipDrawable2 == null || TextUtils.equals(chipDrawable2.text, charSequence)) {
            return;
        }
        chipDrawable2.text = charSequence;
        chipDrawable2.textDrawableHelper.textWidthDirty = true;
        chipDrawable2.invalidateSelf();
        chipDrawable2.onSizeChange();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(int i) {
        super.setTextAppearance(i);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            Context context = chipDrawable.context;
            chipDrawable.textDrawableHelper.setTextAppearance(new TextAppearance(context, i), context);
        }
        updateTextPaintDrawState();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            Context context2 = chipDrawable.context;
            chipDrawable.textDrawableHelper.setTextAppearance(new TextAppearance(context2, i), context2);
        }
        updateTextPaintDrawState();
    }

    public final void updateBackgroundDrawable() {
        ChipDrawable chipDrawable = this.chipDrawable;
        ColorStateList colorStateListSanitizeRippleDrawableColor = RippleUtils.sanitizeRippleDrawableColor(chipDrawable.rippleColor);
        InsetDrawable insetDrawable = this.insetBackgroundDrawable;
        Drawable drawable = chipDrawable;
        if (insetDrawable != null) {
            drawable = insetDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateListSanitizeRippleDrawableColor, drawable, null);
        this.ripple = rippleDrawable;
        WeakHashMap weakHashMap = qd1.a;
        setBackground(rippleDrawable);
        updatePaddingInternal();
    }

    public final void updatePaddingInternal() {
        ChipDrawable chipDrawable;
        if (TextUtils.isEmpty(getText()) || (chipDrawable = this.chipDrawable) == null) {
            return;
        }
        int iCalculateCloseIconWidth = (int) (chipDrawable.calculateCloseIconWidth() + chipDrawable.textEndPadding + chipDrawable.chipEndPadding);
        int iCalculateChipIconWidth = (int) (chipDrawable.calculateChipIconWidth() + chipDrawable.textStartPadding + chipDrawable.chipStartPadding);
        if (this.insetBackgroundDrawable != null) {
            Rect rect = new Rect();
            this.insetBackgroundDrawable.getPadding(rect);
            iCalculateChipIconWidth += rect.left;
            iCalculateCloseIconWidth += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = qd1.a;
        setPaddingRelative(iCalculateChipIconWidth, paddingTop, iCalculateCloseIconWidth, paddingBottom);
    }

    public final void updateTextPaintDrawState() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable = this.chipDrawable;
        if (chipDrawable != null) {
            paint.drawableState = chipDrawable.getState();
        }
        ChipDrawable chipDrawable2 = this.chipDrawable;
        TextAppearance textAppearance = chipDrawable2 != null ? chipDrawable2.textDrawableHelper.textAppearance : null;
        if (textAppearance != null) {
            textAppearance.updateDrawState(getContext(), paint, this.fontCallback);
        }
    }
}
