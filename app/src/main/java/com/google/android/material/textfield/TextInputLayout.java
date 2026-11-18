package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.transition.c;
import androidx.transition.j;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import defpackage.a1;
import defpackage.b2;
import defpackage.d;
import defpackage.d61;
import defpackage.e;
import defpackage.fp;
import defpackage.je;
import defpackage.m6;
import defpackage.o1;
import defpackage.o5;
import defpackage.qd1;
import defpackage.rv0;
import defpackage.t8;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    public ValueAnimator animator;
    public MaterialShapeDrawable boxBackground;
    public int boxBackgroundColor;
    public final int boxBackgroundMode;
    public int boxCollapsedPaddingTopPx;
    public final int boxLabelCutoutPaddingPx;
    public int boxStrokeColor;
    public final int boxStrokeWidthDefaultPx;
    public final int boxStrokeWidthFocusedPx;
    public int boxStrokeWidthPx;
    public MaterialShapeDrawable boxUnderline;
    public final CollapsingTextHelper collapsingTextHelper;
    public final boolean counterEnabled;
    public final int counterMaxLength;
    public final int counterOverflowTextAppearance;
    public final ColorStateList counterOverflowTextColor;
    public boolean counterOverflowed;
    public final int counterTextAppearance;
    public final ColorStateList counterTextColor;
    public final AppCompatTextView counterView;
    public final int defaultFilledBackgroundColor;
    public ColorStateList defaultHintTextColor;
    public final int defaultStrokeColor;
    public final int disabledColor;
    public final int disabledFilledBackgroundColor;
    public EditText editText;
    public final LinkedHashSet editTextAttachedListeners;
    public ColorDrawable endDummyDrawable;
    public int endDummyDrawableWidth;
    public final LinkedHashSet endIconChangedListeners;
    public final SparseArray endIconDelegates;
    public final FrameLayout endIconFrame;
    public int endIconMode;
    public final ColorStateList endIconTintList;
    public final PorterDuff.Mode endIconTintMode;
    public final CheckableImageButton endIconView;
    public final LinearLayout endLayout;
    public final ColorStateList errorIconTintList;
    public final CheckableImageButton errorIconView;
    public final boolean expandedHintEnabled;
    public final int focusedFilledBackgroundColor;
    public final int focusedStrokeColor;
    public final ColorStateList focusedTextColor;
    public final boolean hasEndIconTintList;
    public final boolean hasEndIconTintMode;
    public final boolean hasStartIconTintList;
    public final boolean hasStartIconTintMode;
    public CharSequence hint;
    public final boolean hintAnimationEnabled;
    public final boolean hintEnabled;
    public boolean hintExpanded;
    public final int hoveredFilledBackgroundColor;
    public final int hoveredStrokeColor;
    public boolean inDrawableStateChanged;
    public final IndicatorViewController indicatorViewController;
    public final FrameLayout inputFrame;
    public boolean isProvidingHint;
    public int maxWidth;
    public int minWidth;
    public Drawable originalEditTextEndDrawable;
    public CharSequence originalHint;
    public boolean placeholderEnabled;
    public c placeholderFadeIn;
    public c placeholderFadeOut;
    public CharSequence placeholderText;
    public int placeholderTextAppearance;
    public final ColorStateList placeholderTextColor;
    public AppCompatTextView placeholderTextView;
    public final CharSequence prefixText;
    public final AppCompatTextView prefixTextView;
    public boolean restoringSavedState;
    public final ShapeAppearanceModel shapeAppearanceModel;
    public ColorDrawable startDummyDrawable;
    public int startDummyDrawableWidth;
    public final ColorStateList startIconTintList;
    public final PorterDuff.Mode startIconTintMode;
    public final CheckableImageButton startIconView;
    public final LinearLayout startLayout;
    public final ColorStateList strokeErrorColor;
    public final CharSequence suffixText;
    public final AppCompatTextView suffixTextView;
    public final Rect tmpBoundsRect;
    public final Rect tmpRect;
    public final RectF tmpRectF;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class AccessibilityDelegate extends a1 {
        public final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        @Override // defpackage.a1
        public void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
            AppCompatTextView appCompatTextView;
            AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            TextInputLayout textInputLayout = this.layout;
            EditText editText = textInputLayout.editText;
            CharSequence contentDescription = null;
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = textInputLayout.getHint();
            CharSequence error = textInputLayout.getError();
            CharSequence charSequence = textInputLayout.placeholderEnabled ? textInputLayout.placeholderText : null;
            int i = textInputLayout.counterMaxLength;
            if (textInputLayout.counterEnabled && textInputLayout.counterOverflowed && (appCompatTextView = textInputLayout.counterView) != null) {
                contentDescription = appCompatTextView.getContentDescription();
            }
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean zIsEmpty2 = TextUtils.isEmpty(hint);
            boolean z = textInputLayout.hintExpanded;
            boolean zIsEmpty3 = TextUtils.isEmpty(error);
            boolean z2 = (zIsEmpty3 && TextUtils.isEmpty(contentDescription)) ? false : true;
            String string = !zIsEmpty2 ? hint.toString() : AppConfig.CUSTOM;
            if (!zIsEmpty) {
                accessibilityNodeInfo.setText(text);
            } else if (!TextUtils.isEmpty(string)) {
                accessibilityNodeInfo.setText(string);
                if (!z && charSequence != null) {
                    charSequence = string + ", " + ((Object) charSequence);
                    accessibilityNodeInfo.setText(charSequence);
                }
            } else if (charSequence != null) {
                accessibilityNodeInfo.setText(charSequence);
            }
            if (!TextUtils.isEmpty(string)) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    o1Var.m(string);
                } else {
                    if (!zIsEmpty) {
                        string = ((Object) text) + ", " + string;
                    }
                    accessibilityNodeInfo.setText(string);
                }
                if (i2 >= 26) {
                    accessibilityNodeInfo.setShowingHintText(zIsEmpty);
                } else {
                    o1Var.h(4, zIsEmpty);
                }
            }
            if (text == null || text.length() != i) {
                i = -1;
            }
            accessibilityNodeInfo.setMaxTextLength(i);
            if (z2) {
                if (zIsEmpty3) {
                    error = contentDescription;
                }
                accessibilityNodeInfo.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(R.attr.a17);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnEditTextAttachedListener {
        void onEditTextAttached(TextInputLayout textInputLayout);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnEndIconChangedListener {
        void onEndIconChanged(TextInputLayout textInputLayout, int i);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SavedState extends d {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.textfield.TextInputLayout.SavedState.1
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
        public CharSequence error;
        public CharSequence helperText;
        public CharSequence hintText;
        public boolean isEndIconChecked;
        public CharSequence placeholderText;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.error = (CharSequence) creator.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() == 1;
            this.hintText = (CharSequence) creator.createFromParcel(parcel);
            this.helperText = (CharSequence) creator.createFromParcel(parcel);
            this.placeholderText = (CharSequence) creator.createFromParcel(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.error) + " hint=" + ((Object) this.hintText) + " helperText=" + ((Object) this.helperText) + " placeholderText=" + ((Object) this.placeholderText) + "}";
        }

        @Override // defpackage.d, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, parcel, i);
            TextUtils.writeToParcel(this.helperText, parcel, i);
            TextUtils.writeToParcel(this.placeholderText, parcel, i);
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.a4s);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        int i2;
        int i3;
        CollapsingTextHelper collapsingTextHelper;
        IndicatorViewController indicatorViewController;
        int i4;
        PorterDuff.Mode tintMode;
        ColorStateList colorStateList;
        int i5;
        ColorStateList colorStateListB;
        ColorStateList colorStateListB2;
        ColorStateList colorStateListB3;
        ColorStateList colorStateListB4;
        PorterDuff.Mode tintMode2;
        ColorStateList colorStateList2;
        PorterDuff.Mode tintMode3;
        ColorStateList colorStateList3;
        CharSequence text;
        ColorStateList colorStateList4;
        int defaultColor;
        int colorForState;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, R.plurals.wo), attributeSet, i);
        this.minWidth = -1;
        this.maxWidth = -1;
        IndicatorViewController indicatorViewController2 = new IndicatorViewController(this);
        this.indicatorViewController = indicatorViewController2;
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet();
        this.endIconMode = 0;
        SparseArray sparseArray = new SparseArray();
        this.endIconDelegates = sparseArray;
        this.endIconChangedListeners = new LinkedHashSet();
        CollapsingTextHelper collapsingTextHelper2 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper2;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.inputFrame = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.startLayout = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.endLayout = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.endIconFrame = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        collapsingTextHelper2.textSizeInterpolator = linearInterpolator;
        collapsingTextHelper2.recalculate(false);
        collapsingTextHelper2.positionInterpolator = linearInterpolator;
        collapsingTextHelper2.recalculate(false);
        if (collapsingTextHelper2.collapsedTextGravity != 8388659) {
            collapsingTextHelper2.collapsedTextGravity = 8388659;
            collapsingTextHelper2.recalculate(false);
        }
        m6 m6VarObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.TextInputLayout, i, R.plurals.wo, 20, 18, 33, 38, 42);
        TypedArray typedArray = (TypedArray) m6VarObtainTintedStyledAttributes.a;
        this.hintEnabled = typedArray.getBoolean(41, true);
        setHint(typedArray.getText(4));
        this.hintAnimationEnabled = typedArray.getBoolean(40, true);
        this.expandedHintEnabled = typedArray.getBoolean(35, true);
        if (typedArray.hasValue(3)) {
            i2 = -1;
            int dimensionPixelSize = typedArray.getDimensionPixelSize(3, -1);
            this.minWidth = dimensionPixelSize;
            EditText editText = this.editText;
            if (editText != null && dimensionPixelSize != -1) {
                editText.setMinWidth(dimensionPixelSize);
            }
        } else {
            i2 = -1;
        }
        if (typedArray.hasValue(2)) {
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(2, i2);
            this.maxWidth = dimensionPixelSize2;
            EditText editText2 = this.editText;
            if (editText2 != null && dimensionPixelSize2 != i2) {
                editText2.setMaxWidth(dimensionPixelSize2);
            }
        }
        ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder(context2, attributeSet, i, R.plurals.wo).build();
        this.shapeAppearanceModel = shapeAppearanceModelBuild;
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(R.dimen.o6);
        this.boxCollapsedPaddingTopPx = typedArray.getDimensionPixelOffset(7, 0);
        int dimensionPixelSize3 = typedArray.getDimensionPixelSize(14, context2.getResources().getDimensionPixelSize(R.dimen.o7));
        this.boxStrokeWidthDefaultPx = dimensionPixelSize3;
        this.boxStrokeWidthFocusedPx = typedArray.getDimensionPixelSize(15, context2.getResources().getDimensionPixelSize(R.dimen.o8));
        this.boxStrokeWidthPx = dimensionPixelSize3;
        float dimension = typedArray.getDimension(11, -1.0f);
        float dimension2 = typedArray.getDimension(10, -1.0f);
        float dimension3 = typedArray.getDimension(8, -1.0f);
        float dimension4 = typedArray.getDimension(9, -1.0f);
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder(shapeAppearanceModelBuild);
        if (dimension >= 0.0f) {
            builder.topLeftCornerSize = new AbsoluteCornerSize(dimension);
        }
        if (dimension2 >= 0.0f) {
            builder.topRightCornerSize = new AbsoluteCornerSize(dimension2);
        }
        if (dimension3 >= 0.0f) {
            builder.bottomRightCornerSize = new AbsoluteCornerSize(dimension3);
        }
        if (dimension4 >= 0.0f) {
            builder.bottomLeftCornerSize = new AbsoluteCornerSize(dimension4);
        }
        this.shapeAppearanceModel = builder.build();
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context2, m6VarObtainTintedStyledAttributes, 5);
        if (colorStateList5 != null) {
            int defaultColor2 = colorStateList5.getDefaultColor();
            this.defaultFilledBackgroundColor = defaultColor2;
            this.boxBackgroundColor = defaultColor2;
            if (colorStateList5.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateList5.getColorForState(new int[]{-16842910}, -1);
                this.focusedFilledBackgroundColor = colorStateList5.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                colorForState = colorStateList5.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.focusedFilledBackgroundColor = defaultColor2;
                ColorStateList colorStateList6 = b2.getColorStateList(context2, R.color.ph);
                this.disabledFilledBackgroundColor = colorStateList6.getColorForState(new int[]{-16842910}, -1);
                colorForState = colorStateList6.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
            this.hoveredFilledBackgroundColor = colorForState;
            i3 = 0;
        } else {
            i3 = 0;
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.focusedFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        if (typedArray.hasValue(1)) {
            ColorStateList colorStateListB5 = m6VarObtainTintedStyledAttributes.b(1);
            this.focusedTextColor = colorStateListB5;
            this.defaultHintTextColor = colorStateListB5;
        }
        ColorStateList colorStateList7 = MaterialResources.getColorStateList(context2, m6VarObtainTintedStyledAttributes, 12);
        int color = typedArray.getColor(12, i3);
        this.focusedStrokeColor = color;
        this.defaultStrokeColor = context2.getColor(R.color.q4);
        this.disabledColor = context2.getColor(R.color.q5);
        this.hoveredStrokeColor = context2.getColor(R.color.q8);
        if (colorStateList7 != null) {
            if (colorStateList7.isStateful()) {
                this.defaultStrokeColor = colorStateList7.getDefaultColor();
                this.disabledColor = colorStateList7.getColorForState(new int[]{-16842910}, -1);
                this.hoveredStrokeColor = colorStateList7.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
                defaultColor = colorStateList7.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
            } else {
                defaultColor = color != colorStateList7.getDefaultColor() ? colorStateList7.getDefaultColor() : defaultColor;
                updateTextInputBoxState();
            }
            this.focusedStrokeColor = defaultColor;
            updateTextInputBoxState();
        }
        if (typedArray.hasValue(13) && this.strokeErrorColor != (colorStateList4 = MaterialResources.getColorStateList(context2, m6VarObtainTintedStyledAttributes, 13))) {
            this.strokeErrorColor = colorStateList4;
            updateTextInputBoxState();
        }
        if (typedArray.getResourceId(42, -1) != -1) {
            collapsingTextHelper2.setCollapsedTextAppearance(typedArray.getResourceId(42, 0));
            this.focusedTextColor = collapsingTextHelper2.collapsedTextColor;
            if (this.editText != null) {
                updateLabelState(false, false);
                updateInputLayoutMargins();
            }
        }
        int resourceId = typedArray.getResourceId(33, 0);
        CharSequence text2 = typedArray.getText(28);
        boolean z = typedArray.getBoolean(29, false);
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.bo, (ViewGroup) linearLayout2, false);
        this.errorIconView = checkableImageButton;
        checkableImageButton.setId(R.attr.a13);
        checkableImageButton.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        if (typedArray.hasValue(30)) {
            Drawable drawableE = m6VarObtainTintedStyledAttributes.e(30);
            checkableImageButton.setImageDrawable(drawableE);
            setErrorIconVisible(drawableE != null && indicatorViewController2.errorEnabled);
        }
        if (typedArray.hasValue(31)) {
            ColorStateList colorStateList8 = MaterialResources.getColorStateList(context2, m6VarObtainTintedStyledAttributes, 31);
            this.errorIconTintList = colorStateList8;
            Drawable drawable = checkableImageButton.getDrawable();
            if (drawable != null) {
                drawable = drawable.mutate();
                drawable.setTintList(colorStateList8);
            }
            if (checkableImageButton.getDrawable() != drawable) {
                checkableImageButton.setImageDrawable(drawable);
            }
        }
        if (typedArray.hasValue(32)) {
            collapsingTextHelper = collapsingTextHelper2;
            PorterDuff.Mode tintMode4 = ViewUtils.parseTintMode(typedArray.getInt(32, -1), null);
            Drawable drawable2 = checkableImageButton.getDrawable();
            if (drawable2 != null) {
                drawable2 = drawable2.mutate();
                drawable2.setTintMode(tintMode4);
            }
            if (checkableImageButton.getDrawable() != drawable2) {
                checkableImageButton.setImageDrawable(drawable2);
            }
        } else {
            collapsingTextHelper = collapsingTextHelper2;
        }
        checkableImageButton.setContentDescription(getResources().getText(R.string.e4));
        WeakHashMap weakHashMap = qd1.a;
        checkableImageButton.setImportantForAccessibility(2);
        checkableImageButton.setClickable(false);
        checkableImageButton.pressable = false;
        checkableImageButton.setFocusable(false);
        int resourceId2 = typedArray.getResourceId(38, 0);
        boolean z2 = typedArray.getBoolean(37, false);
        CharSequence text3 = typedArray.getText(36);
        int resourceId3 = typedArray.getResourceId(50, 0);
        CharSequence text4 = typedArray.getText(49);
        int resourceId4 = typedArray.getResourceId(53, 0);
        CharSequence text5 = typedArray.getText(52);
        int resourceId5 = typedArray.getResourceId(63, 0);
        CharSequence text6 = typedArray.getText(62);
        boolean z3 = typedArray.getBoolean(16, false);
        int i6 = typedArray.getInt(17, -1);
        if (this.counterMaxLength != i6) {
            this.counterMaxLength = i6 <= 0 ? -1 : i6;
            if (this.counterEnabled && this.counterView != null) {
                EditText editText3 = this.editText;
                updateCounter(editText3 == null ? 0 : editText3.getText().length());
            }
        }
        this.counterTextAppearance = typedArray.getResourceId(20, 0);
        this.counterOverflowTextAppearance = typedArray.getResourceId(18, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.bp, (ViewGroup) linearLayout, false);
        this.startIconView = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams()).setMarginEnd(0);
        }
        checkableImageButton2.setOnClickListener(null);
        setIconClickable(checkableImageButton2);
        checkableImageButton2.setOnLongClickListener(null);
        setIconClickable(checkableImageButton2);
        if (typedArray.hasValue(59)) {
            Drawable drawableE2 = m6VarObtainTintedStyledAttributes.e(59);
            checkableImageButton2.setImageDrawable(drawableE2);
            if (drawableE2 != null) {
                indicatorViewController = indicatorViewController2;
                i4 = resourceId2;
                applyIconTint(checkableImageButton2, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
                if (checkableImageButton2.getVisibility() != 0) {
                    checkableImageButton2.setVisibility(0);
                    updatePrefixTextViewPadding();
                    updateDummyDrawables();
                }
                refreshIconDrawableState(checkableImageButton2, this.startIconTintList);
            } else {
                indicatorViewController = indicatorViewController2;
                i4 = resourceId2;
                if (checkableImageButton2.getVisibility() == 0) {
                    checkableImageButton2.setVisibility(8);
                    updatePrefixTextViewPadding();
                    updateDummyDrawables();
                }
                checkableImageButton2.setOnClickListener(null);
                setIconClickable(checkableImageButton2);
                checkableImageButton2.setOnLongClickListener(null);
                setIconClickable(checkableImageButton2);
                if (checkableImageButton2.getContentDescription() != null) {
                    checkableImageButton2.setContentDescription(null);
                }
            }
            if (typedArray.hasValue(58) && checkableImageButton2.getContentDescription() != (text = typedArray.getText(58))) {
                checkableImageButton2.setContentDescription(text);
            }
            boolean z4 = typedArray.getBoolean(57, true);
            if (checkableImageButton2.checkable != z4) {
                checkableImageButton2.checkable = z4;
                checkableImageButton2.sendAccessibilityEvent(0);
            }
        } else {
            indicatorViewController = indicatorViewController2;
            i4 = resourceId2;
        }
        if (typedArray.hasValue(60) && this.startIconTintList != (colorStateList3 = MaterialResources.getColorStateList(context2, m6VarObtainTintedStyledAttributes, 60))) {
            this.startIconTintList = colorStateList3;
            this.hasStartIconTintList = true;
            applyIconTint(checkableImageButton2, true, colorStateList3, this.hasStartIconTintMode, this.startIconTintMode);
        }
        if (typedArray.hasValue(61) && this.startIconTintMode != (tintMode3 = ViewUtils.parseTintMode(typedArray.getInt(61, -1), null))) {
            this.startIconTintMode = tintMode3;
            this.hasStartIconTintMode = true;
            applyIconTint(checkableImageButton2, this.hasStartIconTintList, this.startIconTintList, true, tintMode3);
        }
        int i7 = typedArray.getInt(6, 0);
        if (i7 != this.boxBackgroundMode) {
            this.boxBackgroundMode = i7;
            if (this.editText != null) {
                onApplyBoxBackgroundMode();
            }
        }
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.bo, (ViewGroup) frameLayout2, false);
        this.endIconView = checkableImageButton3;
        frameLayout2.addView(checkableImageButton3);
        checkableImageButton3.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton3.getLayoutParams()).setMarginStart(0);
        }
        int resourceId6 = typedArray.getResourceId(24, 0);
        sparseArray.append(-1, new CustomEndIconDelegate(this, resourceId6));
        sparseArray.append(0, new NoEndIconDelegate(this));
        sparseArray.append(1, new PasswordToggleEndIconDelegate(this, resourceId6 == 0 ? typedArray.getResourceId(45, 0) : resourceId6));
        sparseArray.append(2, new ClearTextEndIconDelegate(this, resourceId6));
        sparseArray.append(3, new DropdownMenuEndIconDelegate(this, resourceId6));
        if (typedArray.hasValue(25)) {
            setEndIconMode(typedArray.getInt(25, 0));
            if (typedArray.hasValue(23)) {
                setEndIconContentDescription(typedArray.getText(23));
            }
            boolean z5 = typedArray.getBoolean(22, true);
            if (checkableImageButton3.checkable != z5) {
                checkableImageButton3.checkable = z5;
                checkableImageButton3.sendAccessibilityEvent(0);
            }
        } else if (typedArray.hasValue(46)) {
            setEndIconMode(typedArray.getBoolean(46, false) ? 1 : 0);
            setEndIconContentDescription(typedArray.getText(44));
            if (typedArray.hasValue(47) && this.endIconTintList != (colorStateList = MaterialResources.getColorStateList(context2, m6VarObtainTintedStyledAttributes, 47))) {
                this.endIconTintList = colorStateList;
                this.hasEndIconTintList = true;
                applyEndIconTint();
            }
            if (typedArray.hasValue(48) && this.endIconTintMode != (tintMode = ViewUtils.parseTintMode(typedArray.getInt(48, -1), null))) {
                this.endIconTintMode = tintMode;
                this.hasEndIconTintMode = true;
                applyEndIconTint();
            }
        }
        if (!typedArray.hasValue(46)) {
            if (typedArray.hasValue(26) && this.endIconTintList != (colorStateList2 = MaterialResources.getColorStateList(context2, m6VarObtainTintedStyledAttributes, 26))) {
                this.endIconTintList = colorStateList2;
                this.hasEndIconTintList = true;
                applyEndIconTint();
            }
            if (typedArray.hasValue(27) && this.endIconTintMode != (tintMode2 = ViewUtils.parseTintMode(typedArray.getInt(27, -1), null))) {
                this.endIconTintMode = tintMode2;
                this.hasEndIconTintMode = true;
                applyEndIconTint();
            }
        }
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.prefixTextView = appCompatTextView;
        appCompatTextView.setId(R.attr.a19);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        appCompatTextView.setAccessibilityLiveRegion(1);
        linearLayout.addView(checkableImageButton2);
        linearLayout.addView(appCompatTextView);
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(context2);
        this.suffixTextView = appCompatTextView2;
        appCompatTextView2.setId(R.attr.a1_);
        appCompatTextView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        appCompatTextView2.setAccessibilityLiveRegion(1);
        linearLayout2.addView(appCompatTextView2);
        linearLayout2.addView(checkableImageButton);
        linearLayout2.addView(frameLayout2);
        setHelperTextEnabled(z2);
        setHelperText(text3);
        IndicatorViewController indicatorViewController3 = indicatorViewController;
        int i8 = i4;
        indicatorViewController3.helperTextTextAppearance = i8;
        AppCompatTextView appCompatTextView3 = indicatorViewController3.helperTextView;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setTextAppearance(i8);
        }
        setErrorEnabled(z);
        indicatorViewController3.errorTextAppearance = resourceId;
        AppCompatTextView appCompatTextView4 = indicatorViewController3.errorView;
        if (appCompatTextView4 != null) {
            indicatorViewController3.textInputView.setTextAppearanceCompatWithErrorFallback(appCompatTextView4, resourceId);
        }
        indicatorViewController3.errorViewContentDescription = text2;
        AppCompatTextView appCompatTextView5 = indicatorViewController3.errorView;
        if (appCompatTextView5 != null) {
            appCompatTextView5.setContentDescription(text2);
        }
        setPlaceholderText(text4);
        this.placeholderTextAppearance = resourceId3;
        AppCompatTextView appCompatTextView6 = this.placeholderTextView;
        if (appCompatTextView6 != null) {
            appCompatTextView6.setTextAppearance(resourceId3);
        }
        this.prefixText = TextUtils.isEmpty(text5) ? null : text5;
        appCompatTextView.setText(text5);
        updatePrefixTextVisibility();
        appCompatTextView.setTextAppearance(resourceId4);
        this.suffixText = TextUtils.isEmpty(text6) ? null : text6;
        appCompatTextView2.setText(text6);
        updateSuffixTextVisibility();
        appCompatTextView2.setTextAppearance(resourceId5);
        if (typedArray.hasValue(34)) {
            ColorStateList colorStateListB6 = m6VarObtainTintedStyledAttributes.b(34);
            indicatorViewController3.errorViewTextColor = colorStateListB6;
            AppCompatTextView appCompatTextView7 = indicatorViewController3.errorView;
            if (appCompatTextView7 != null && colorStateListB6 != null) {
                appCompatTextView7.setTextColor(colorStateListB6);
            }
        }
        if (typedArray.hasValue(39)) {
            ColorStateList colorStateListB7 = m6VarObtainTintedStyledAttributes.b(39);
            indicatorViewController3.helperTextViewTextColor = colorStateListB7;
            AppCompatTextView appCompatTextView8 = indicatorViewController3.helperTextView;
            if (appCompatTextView8 != null && colorStateListB7 != null) {
                appCompatTextView8.setTextColor(colorStateListB7);
            }
        }
        if (typedArray.hasValue(43) && this.focusedTextColor != (colorStateListB4 = m6VarObtainTintedStyledAttributes.b(43))) {
            if (this.defaultHintTextColor == null) {
                collapsingTextHelper.setCollapsedTextColor(colorStateListB4);
            }
            this.focusedTextColor = colorStateListB4;
            if (this.editText != null) {
                updateLabelState(false, false);
            }
        }
        if (typedArray.hasValue(21) && this.counterTextColor != (colorStateListB3 = m6VarObtainTintedStyledAttributes.b(21))) {
            this.counterTextColor = colorStateListB3;
            updateCounterTextAppearanceAndColor();
        }
        if (typedArray.hasValue(19) && this.counterOverflowTextColor != (colorStateListB2 = m6VarObtainTintedStyledAttributes.b(19))) {
            this.counterOverflowTextColor = colorStateListB2;
            updateCounterTextAppearanceAndColor();
        }
        if (typedArray.hasValue(51) && this.placeholderTextColor != (colorStateListB = m6VarObtainTintedStyledAttributes.b(51))) {
            this.placeholderTextColor = colorStateListB;
            AppCompatTextView appCompatTextView9 = this.placeholderTextView;
            if (appCompatTextView9 != null && colorStateListB != null) {
                appCompatTextView9.setTextColor(colorStateListB);
            }
        }
        if (typedArray.hasValue(54)) {
            appCompatTextView.setTextColor(m6VarObtainTintedStyledAttributes.b(54));
        }
        if (typedArray.hasValue(64)) {
            appCompatTextView2.setTextColor(m6VarObtainTintedStyledAttributes.b(64));
        }
        if (this.counterEnabled != z3) {
            if (z3) {
                AppCompatTextView appCompatTextView10 = new AppCompatTextView(getContext());
                this.counterView = appCompatTextView10;
                appCompatTextView10.setId(R.attr.a15);
                appCompatTextView10.setMaxLines(1);
                indicatorViewController3.addIndicator(appCompatTextView10, 2);
                ((ViewGroup.MarginLayoutParams) appCompatTextView10.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R.dimen.o9));
                updateCounterTextAppearanceAndColor();
                EditText editText4 = this.editText;
                updateCounter(editText4 == null ? 0 : editText4.getText().length());
                i5 = 2;
            } else {
                i5 = 2;
                indicatorViewController3.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z3;
        } else {
            i5 = 2;
        }
        setEnabled(typedArray.getBoolean(0, true));
        m6VarObtainTintedStyledAttributes.n();
        setImportantForAccessibility(i5);
        int i9 = Build.VERSION.SDK_INT;
        if (i9 < 26 || i9 < 26) {
            return;
        }
        setImportantForAutofill(1);
    }

    public static void applyIconTint(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = drawable.mutate();
            if (z) {
                drawable.setTintList(colorStateList);
            }
            if (z2) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    public static void setIconClickable(CheckableImageButton checkableImageButton) {
        WeakHashMap weakHashMap = qd1.a;
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        checkableImageButton.setFocusable(zHasOnClickListeners);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.pressable = zHasOnClickListeners;
        checkableImageButton.setLongClickable(false);
        checkableImageButton.setImportantForAccessibility(zHasOnClickListeners ? 1 : 2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        boolean z;
        boolean z2;
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.inputFrame;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        updateInputLayoutMargins();
        EditText editText = (EditText) view;
        if (this.editText != null) {
            d.AnonymousClass0.m$2("We already have an EditText, can only have one");
            return;
        }
        this.editText = editText;
        int i2 = this.minWidth;
        this.minWidth = i2;
        if (i2 != -1) {
            editText.setMinWidth(i2);
        }
        int i3 = this.maxWidth;
        this.maxWidth = i3;
        EditText editText2 = this.editText;
        if (editText2 != null && i3 != -1) {
            editText2.setMaxWidth(i3);
        }
        onApplyBoxBackgroundMode();
        AccessibilityDelegate accessibilityDelegate = new AccessibilityDelegate(this);
        EditText editText3 = this.editText;
        if (editText3 != null) {
            qd1.l(editText3, accessibilityDelegate);
        }
        Typeface typeface = this.editText.getTypeface();
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        CancelableFontCallback cancelableFontCallback = collapsingTextHelper.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        if (collapsingTextHelper.collapsedTypeface != typeface) {
            collapsingTextHelper.collapsedTypeface = typeface;
            z = true;
        } else {
            z = false;
        }
        CancelableFontCallback cancelableFontCallback2 = collapsingTextHelper.expandedFontCallback;
        if (cancelableFontCallback2 != null) {
            cancelableFontCallback2.cancelled = true;
        }
        if (collapsingTextHelper.expandedTypeface != typeface) {
            collapsingTextHelper.expandedTypeface = typeface;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || z2) {
            collapsingTextHelper.recalculate(false);
        }
        float textSize = this.editText.getTextSize();
        if (collapsingTextHelper.expandedTextSize != textSize) {
            collapsingTextHelper.expandedTextSize = textSize;
            collapsingTextHelper.recalculate(false);
        }
        int gravity = this.editText.getGravity();
        int i4 = (gravity & (-113)) | 48;
        if (collapsingTextHelper.collapsedTextGravity != i4) {
            collapsingTextHelper.collapsedTextGravity = i4;
            collapsingTextHelper.recalculate(false);
        }
        if (collapsingTextHelper.expandedTextGravity != gravity) {
            collapsingTextHelper.expandedTextGravity = gravity;
            collapsingTextHelper.recalculate(false);
        }
        this.editText.addTextChangedListener(new TextWatcher() { // from class: com.google.android.material.textfield.TextInputLayout.1
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
                TextInputLayout textInputLayout = TextInputLayout.this;
                textInputLayout.updateLabelState(!textInputLayout.restoringSavedState, false);
                if (textInputLayout.counterEnabled) {
                    textInputLayout.updateCounter(editable.length());
                }
                if (textInputLayout.placeholderEnabled) {
                    textInputLayout.updatePlaceholderText(editable.length());
                }
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            }
        });
        if (this.defaultHintTextColor == null) {
            this.defaultHintTextColor = this.editText.getHintTextColors();
        }
        if (this.hintEnabled) {
            if (TextUtils.isEmpty(this.hint)) {
                CharSequence hint = this.editText.getHint();
                this.originalHint = hint;
                setHint(hint);
                this.editText.setHint((CharSequence) null);
            }
            this.isProvidingHint = true;
        }
        if (this.counterView != null) {
            updateCounter(this.editText.getText().length());
        }
        updateEditTextBackground();
        this.indicatorViewController.adjustIndicatorPadding();
        this.startLayout.bringToFront();
        this.endLayout.bringToFront();
        this.endIconFrame.bringToFront();
        this.errorIconView.bringToFront();
        Iterator it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            ((OnEditTextAttachedListener) it.next()).onEditTextAttached(this);
        }
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        updateLabelState(false, true);
    }

    public final void animateToExpansionFraction(float f) {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper.expandedFraction == f) {
            return;
        }
        if (this.animator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.animator = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.TextInputLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
        }
        this.animator.setFloatValues(collapsingTextHelper.expandedFraction, f);
        this.animator.start();
    }

    public final void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    public final int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        int i = this.boxBackgroundMode;
        if (i == 0 || i == 1) {
            collapsedTextHeight = collapsingTextHelper.getCollapsedTextHeight();
        } else {
            if (i != 2) {
                return 0;
            }
            collapsedTextHeight = collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    public final boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof CutoutDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.editText;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.originalHint != null) {
            boolean z = this.isProvidingHint;
            this.isProvidingHint = false;
            CharSequence hint = editText.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.editText.setHint(hint);
                this.isProvidingHint = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.inputFrame;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
            View childAt = frameLayout.getChildAt(i2);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.editText) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
        MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.boxStrokeWidthPx;
            this.boxUnderline.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        boolean z;
        ColorStateList colorStateList;
        if (this.inDrawableStateChanged) {
            return;
        }
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper != null) {
            collapsingTextHelper.state = drawableState;
            ColorStateList colorStateList2 = collapsingTextHelper.collapsedTextColor;
            if ((colorStateList2 == null || !colorStateList2.isStateful()) && ((colorStateList = collapsingTextHelper.expandedTextColor) == null || !colorStateList.isStateful())) {
                z = false;
            } else {
                collapsingTextHelper.recalculate(false);
                z = true;
            }
        } else {
            z = false;
        }
        if (this.editText != null) {
            WeakHashMap weakHashMap = qd1.a;
            updateLabelState(isLaidOut() && isEnabled(), false);
        }
        updateEditTextBackground();
        updateTextInputBoxState();
        if (z) {
            invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final int getBaseline() {
        EditText editText = this.editText;
        if (editText == null) {
            return super.getBaseline();
        }
        return calculateLabelMarginTop() + getPaddingTop() + editText.getBaseline();
    }

    public final EndIconDelegate getEndIconDelegate() {
        int i = this.endIconMode;
        SparseArray sparseArray = this.endIconDelegates;
        EndIconDelegate endIconDelegate = (EndIconDelegate) sparseArray.get(i);
        return endIconDelegate != null ? endIconDelegate : (EndIconDelegate) sparseArray.get(0);
    }

    public final CharSequence getError() {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.errorEnabled) {
            return indicatorViewController.errorText;
        }
        return null;
    }

    public final CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    public final boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public final void onApplyBoxBackgroundMode() {
        EditText editText;
        int paddingStart;
        int dimensionPixelSize;
        int paddingEnd;
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        int i3 = this.boxBackgroundMode;
        MaterialShapeDrawable materialShapeDrawable = null;
        if (i3 != 0) {
            ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearanceModel;
            if (i3 == 1) {
                this.boxBackground = new MaterialShapeDrawable(shapeAppearanceModel);
                materialShapeDrawable = new MaterialShapeDrawable();
            } else {
                if (i3 != 2) {
                    throw new IllegalArgumentException(i3 + " is illegal; only @BoxBackgroundMode constants are supported.");
                }
                this.boxBackground = (!this.hintEnabled || (this.boxBackground instanceof CutoutDrawable)) ? new MaterialShapeDrawable(shapeAppearanceModel) : new CutoutDrawable(shapeAppearanceModel);
            }
        } else {
            this.boxBackground = null;
        }
        this.boxUnderline = materialShapeDrawable;
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackground != null && editText2.getBackground() == null && i3 != 0) {
            EditText editText3 = this.editText;
            MaterialShapeDrawable materialShapeDrawable2 = this.boxBackground;
            WeakHashMap weakHashMap = qd1.a;
            editText3.setBackground(materialShapeDrawable2);
        }
        updateTextInputBoxState();
        if (i3 == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                resources2 = getResources();
                i2 = R.dimen.ix;
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                resources2 = getResources();
                i2 = R.dimen.iw;
            }
            this.boxCollapsedPaddingTopPx = resources2.getDimensionPixelSize(i2);
        }
        if (this.editText != null && i3 == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                editText = this.editText;
                WeakHashMap weakHashMap2 = qd1.a;
                paddingStart = editText.getPaddingStart();
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.iv);
                paddingEnd = this.editText.getPaddingEnd();
                resources = getResources();
                i = R.dimen.iu;
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                editText = this.editText;
                WeakHashMap weakHashMap3 = qd1.a;
                paddingStart = editText.getPaddingStart();
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.it);
                paddingEnd = this.editText.getPaddingEnd();
                resources = getResources();
                i = R.dimen.is;
            }
            editText.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, resources.getDimensionPixelSize(i));
        }
        if (i3 != 0) {
            updateInputLayoutMargins();
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:56:0x0107  */
    /* JADX WARN: Code duplicated, block: B:61:0x013e  */
    /* JADX WARN: Code duplicated, block: B:67:0x0164  */
    /* JADX WARN: Code duplicated, block: B:77:0x0188  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a1  */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int measuredWidth;
        int i5;
        int i6;
        int i7;
        Rect rect;
        int compoundPaddingTop;
        int compoundPaddingBottom;
        int i8;
        int i9;
        int i10;
        Rect rect2;
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.editText;
        if (editText != null) {
            Rect rect3 = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, editText, rect3);
            MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
            if (materialShapeDrawable != null) {
                int i11 = rect3.bottom;
                materialShapeDrawable.setBounds(rect3.left, i11 - this.boxStrokeWidthFocusedPx, rect3.right, i11);
            }
            if (this.hintEnabled) {
                float textSize = this.editText.getTextSize();
                CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
                if (collapsingTextHelper.expandedTextSize != textSize) {
                    collapsingTextHelper.expandedTextSize = textSize;
                    collapsingTextHelper.recalculate(false);
                }
                int gravity = this.editText.getGravity();
                int i12 = (gravity & (-113)) | 48;
                if (collapsingTextHelper.collapsedTextGravity != i12) {
                    collapsingTextHelper.collapsedTextGravity = i12;
                    collapsingTextHelper.recalculate(false);
                }
                if (collapsingTextHelper.expandedTextGravity != gravity) {
                    collapsingTextHelper.expandedTextGravity = gravity;
                    collapsingTextHelper.recalculate(false);
                }
                if (this.editText == null) {
                    throw new IllegalStateException();
                }
                WeakHashMap weakHashMap = qd1.a;
                boolean z2 = getLayoutDirection() == 1;
                int i13 = rect3.bottom;
                Rect rect4 = this.tmpBoundsRect;
                rect4.bottom = i13;
                int i14 = rect3.left;
                CharSequence charSequence = this.prefixText;
                int i15 = this.boxBackgroundMode;
                AppCompatTextView appCompatTextView = this.prefixTextView;
                EditText editText2 = this.editText;
                if (i15 != 1) {
                    if (i15 != 2) {
                        int compoundPaddingLeft = editText2.getCompoundPaddingLeft() + i14;
                        if (charSequence != null && !z2) {
                            compoundPaddingLeft = (compoundPaddingLeft - appCompatTextView.getMeasuredWidth()) + appCompatTextView.getPaddingLeft();
                        }
                        rect4.left = compoundPaddingLeft;
                        paddingTop = getPaddingTop();
                    } else {
                        rect4.left = editText2.getPaddingLeft() + i14;
                        rect4.top = rect3.top - calculateLabelMarginTop();
                        measuredWidth = rect3.right - this.editText.getPaddingRight();
                    }
                    rect4.right = measuredWidth;
                    i5 = rect4.left;
                    i6 = rect4.top;
                    i7 = rect4.bottom;
                    rect = collapsingTextHelper.collapsedBounds;
                    if (rect.left == i5 || rect.top != i6 || rect.right != measuredWidth || rect.bottom != i7) {
                        rect.set(i5, i6, measuredWidth, i7);
                        collapsingTextHelper.boundsChanged = true;
                        collapsingTextHelper.onBoundsChanged();
                    }
                    if (this.editText != null) {
                        throw new IllegalStateException();
                    }
                    TextPaint textPaint = collapsingTextHelper.tmpPaint;
                    textPaint.setTextSize(collapsingTextHelper.expandedTextSize);
                    textPaint.setTypeface(collapsingTextHelper.expandedTypeface);
                    textPaint.setLetterSpacing(collapsingTextHelper.expandedLetterSpacing);
                    float f = -textPaint.ascent();
                    rect4.left = this.editText.getCompoundPaddingLeft() + rect3.left;
                    if (i15 == 1 || this.editText.getMinLines() > 1) {
                        compoundPaddingTop = rect3.top + this.editText.getCompoundPaddingTop();
                    } else {
                        compoundPaddingTop = (int) (rect3.centerY() - (f / 2.0f));
                    }
                    rect4.top = compoundPaddingTop;
                    rect4.right = rect3.right - this.editText.getCompoundPaddingRight();
                    if (i15 == 1 || this.editText.getMinLines() > 1) {
                        compoundPaddingBottom = rect3.bottom - this.editText.getCompoundPaddingBottom();
                    } else {
                        compoundPaddingBottom = (int) (rect4.top + f);
                    }
                    rect4.bottom = compoundPaddingBottom;
                    i8 = rect4.left;
                    i9 = rect4.top;
                    i10 = rect4.right;
                    rect2 = collapsingTextHelper.expandedBounds;
                    if (rect2.left == i8 || rect2.top != i9 || rect2.right != i10 || rect2.bottom != compoundPaddingBottom) {
                        rect2.set(i8, i9, i10, compoundPaddingBottom);
                        collapsingTextHelper.boundsChanged = true;
                        collapsingTextHelper.onBoundsChanged();
                    }
                    collapsingTextHelper.recalculate(false);
                    if (cutoutEnabled() || this.hintExpanded) {
                    }
                    openCutout();
                    return;
                }
                int compoundPaddingLeft2 = editText2.getCompoundPaddingLeft() + i14;
                if (charSequence != null && !z2) {
                    compoundPaddingLeft2 = (compoundPaddingLeft2 - appCompatTextView.getMeasuredWidth()) + appCompatTextView.getPaddingLeft();
                }
                rect4.left = compoundPaddingLeft2;
                paddingTop = rect3.top + this.boxCollapsedPaddingTopPx;
                rect4.top = paddingTop;
                int compoundPaddingRight = rect3.right - this.editText.getCompoundPaddingRight();
                measuredWidth = (charSequence == null || !z2) ? compoundPaddingRight : (appCompatTextView.getMeasuredWidth() - appCompatTextView.getPaddingRight()) + compoundPaddingRight;
                rect4.right = measuredWidth;
                i5 = rect4.left;
                i6 = rect4.top;
                i7 = rect4.bottom;
                rect = collapsingTextHelper.collapsedBounds;
                if (rect.left == i5) {
                    rect.set(i5, i6, measuredWidth, i7);
                    collapsingTextHelper.boundsChanged = true;
                    collapsingTextHelper.onBoundsChanged();
                } else {
                    rect.set(i5, i6, measuredWidth, i7);
                    collapsingTextHelper.boundsChanged = true;
                    collapsingTextHelper.onBoundsChanged();
                }
                if (this.editText != null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint2 = collapsingTextHelper.tmpPaint;
                textPaint2.setTextSize(collapsingTextHelper.expandedTextSize);
                textPaint2.setTypeface(collapsingTextHelper.expandedTypeface);
                textPaint2.setLetterSpacing(collapsingTextHelper.expandedLetterSpacing);
                float f2 = -textPaint2.ascent();
                rect4.left = this.editText.getCompoundPaddingLeft() + rect3.left;
                if (i15 == 1) {
                    compoundPaddingTop = rect3.top + this.editText.getCompoundPaddingTop();
                } else {
                    compoundPaddingTop = rect3.top + this.editText.getCompoundPaddingTop();
                }
                rect4.top = compoundPaddingTop;
                rect4.right = rect3.right - this.editText.getCompoundPaddingRight();
                if (i15 == 1) {
                    compoundPaddingBottom = rect3.bottom - this.editText.getCompoundPaddingBottom();
                } else {
                    compoundPaddingBottom = rect3.bottom - this.editText.getCompoundPaddingBottom();
                }
                rect4.bottom = compoundPaddingBottom;
                i8 = rect4.left;
                i9 = rect4.top;
                i10 = rect4.right;
                rect2 = collapsingTextHelper.expandedBounds;
                if (rect2.left == i8) {
                    rect2.set(i8, i9, i10, compoundPaddingBottom);
                    collapsingTextHelper.boundsChanged = true;
                    collapsingTextHelper.onBoundsChanged();
                } else {
                    rect2.set(i8, i9, i10, compoundPaddingBottom);
                    collapsingTextHelper.boundsChanged = true;
                    collapsingTextHelper.onBoundsChanged();
                }
                collapsingTextHelper.recalculate(false);
                if (cutoutEnabled()) {
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        boolean z;
        EditText editText;
        int iMax;
        super.onMeasure(i, i2);
        if (this.editText != null && this.editText.getMeasuredHeight() < (iMax = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            this.editText.setMinimumHeight(iMax);
            z = true;
        } else {
            z = false;
        }
        boolean zUpdateDummyDrawables = updateDummyDrawables();
        if (z || zUpdateDummyDrawables) {
            this.editText.post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.3
                @Override // java.lang.Runnable
                public final void run() {
                    TextInputLayout.this.editText.requestLayout();
                }
            });
        }
        if (this.placeholderTextView != null && (editText = this.editText) != null) {
            this.placeholderTextView.setGravity(editText.getGravity());
            this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        }
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            this.endIconView.post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.2
                @Override // java.lang.Runnable
                public final void run() {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.endIconView.performClick();
                    textInputLayout.endIconView.jumpDrawablesToCurrentState();
                }
            });
        }
        setHint(savedState.hintText);
        setHelperText(savedState.helperText);
        setPlaceholderText(savedState.placeholderText);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        savedState.isEndIconChecked = this.endIconMode != 0 && this.endIconView.checked;
        savedState.hintText = getHint();
        savedState.helperText = indicatorViewController.helperTextEnabled ? indicatorViewController.helperText : null;
        savedState.placeholderText = this.placeholderEnabled ? this.placeholderText : null;
        return savedState;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    public final void openCutout() {
        float f;
        float f2;
        float f3;
        float f4;
        if (cutoutEnabled()) {
            int width = this.editText.getWidth();
            int gravity = this.editText.getGravity();
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            boolean zCalculateIsRtl = collapsingTextHelper.calculateIsRtl(collapsingTextHelper.text);
            collapsingTextHelper.isRtl = zCalculateIsRtl;
            Rect rect = collapsingTextHelper.collapsedBounds;
            if (gravity != 17 && (gravity & 7) != 1) {
                if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !zCalculateIsRtl : zCalculateIsRtl) {
                    f = rect.right;
                    f2 = collapsingTextHelper.collapsedTextWidth;
                } else {
                    f3 = rect.left;
                }
                RectF rectF = this.tmpRectF;
                rectF.left = f3;
                float f5 = rect.top;
                rectF.top = f5;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f4 = (width / 2.0f) + (collapsingTextHelper.collapsedTextWidth / 2.0f);
                } else {
                    f4 = ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !zCalculateIsRtl : zCalculateIsRtl) ? rect.right : collapsingTextHelper.collapsedTextWidth + f3;
                }
                rectF.right = f4;
                rectF.bottom = collapsingTextHelper.getCollapsedTextHeight() + f5;
                float f6 = rectF.left;
                float f7 = this.boxLabelCutoutPaddingPx;
                rectF.left = f6 - f7;
                rectF.right += f7;
                rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.boxStrokeWidthPx);
                CutoutDrawable cutoutDrawable = (CutoutDrawable) this.boxBackground;
                cutoutDrawable.getClass();
                cutoutDrawable.setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
            }
            f = width / 2.0f;
            f2 = collapsingTextHelper.collapsedTextWidth / 2.0f;
            f3 = f - f2;
            RectF rectF2 = this.tmpRectF;
            rectF2.left = f3;
            float f8 = rect.top;
            rectF2.top = f8;
            if (gravity != 17) {
                f4 = (width / 2.0f) + (collapsingTextHelper.collapsedTextWidth / 2.0f);
            } else {
                f4 = (width / 2.0f) + (collapsingTextHelper.collapsedTextWidth / 2.0f);
            }
            rectF2.right = f4;
            rectF2.bottom = collapsingTextHelper.getCollapsedTextHeight() + f8;
            float f9 = rectF2.left;
            float f10 = this.boxLabelCutoutPaddingPx;
            rectF2.left = f9 - f10;
            rectF2.right += f10;
            rectF2.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF2.height() / 2.0f)) + this.boxStrokeWidthPx);
            CutoutDrawable cutoutDrawable2 = (CutoutDrawable) this.boxBackground;
            cutoutDrawable2.getClass();
            cutoutDrawable2.setCutout(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom);
        }
    }

    public final void refreshIconDrawableState(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    @Override // android.view.View
    public final void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public final void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.endIconView;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public final void setEndIconDrawable(int i) {
        Drawable drawableS = i != 0 ? e.s(getContext(), i) : null;
        CheckableImageButton checkableImageButton = this.endIconView;
        checkableImageButton.setImageDrawable(drawableS);
        if (drawableS != null) {
            applyEndIconTint();
            refreshIconDrawableState(checkableImageButton, this.endIconTintList);
        }
    }

    public final void setEndIconMode(int i) {
        int i2 = this.endIconMode;
        this.endIconMode = i;
        Iterator it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            ((OnEndIconChangedListener) it.next()).onEndIconChanged(this, i2);
        }
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode)) {
            getEndIconDelegate().initialize();
            applyEndIconTint();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + i);
    }

    public final void setEndIconVisible(boolean z) {
        if (isEndIconVisible() != z) {
            this.endIconView.setVisibility(z ? 0 : 8);
            updateSuffixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public final void setError(CharSequence charSequence) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (!indicatorViewController.errorEnabled) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            indicatorViewController.hideError();
            return;
        }
        indicatorViewController.cancelCaptionAnimator();
        indicatorViewController.errorText = charSequence;
        indicatorViewController.errorView.setText(charSequence);
        int i = indicatorViewController.captionDisplayed;
        if (i != 1) {
            indicatorViewController.captionToShow = 1;
        }
        indicatorViewController.updateCaptionViewsVisibility(i, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.errorView, charSequence));
    }

    public final void setErrorEnabled(boolean z) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        TextInputLayout textInputLayout = indicatorViewController.textInputView;
        if (indicatorViewController.errorEnabled == z) {
            return;
        }
        indicatorViewController.cancelCaptionAnimator();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController.context);
            indicatorViewController.errorView = appCompatTextView;
            appCompatTextView.setId(R.attr.a16);
            indicatorViewController.errorView.setTextAlignment(5);
            int i = indicatorViewController.errorTextAppearance;
            indicatorViewController.errorTextAppearance = i;
            AppCompatTextView appCompatTextView2 = indicatorViewController.errorView;
            if (appCompatTextView2 != null) {
                indicatorViewController.textInputView.setTextAppearanceCompatWithErrorFallback(appCompatTextView2, i);
            }
            ColorStateList colorStateList = indicatorViewController.errorViewTextColor;
            indicatorViewController.errorViewTextColor = colorStateList;
            AppCompatTextView appCompatTextView3 = indicatorViewController.errorView;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = indicatorViewController.errorViewContentDescription;
            indicatorViewController.errorViewContentDescription = charSequence;
            AppCompatTextView appCompatTextView4 = indicatorViewController.errorView;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            indicatorViewController.errorView.setVisibility(4);
            AppCompatTextView appCompatTextView5 = indicatorViewController.errorView;
            WeakHashMap weakHashMap = qd1.a;
            appCompatTextView5.setAccessibilityLiveRegion(1);
            indicatorViewController.addIndicator(indicatorViewController.errorView, 0);
        } else {
            indicatorViewController.hideError();
            indicatorViewController.removeIndicator(indicatorViewController.errorView, 0);
            indicatorViewController.errorView = null;
            textInputLayout.updateEditTextBackground();
            textInputLayout.updateTextInputBoxState();
        }
        indicatorViewController.errorEnabled = z;
    }

    public final void setErrorIconVisible(boolean z) {
        this.errorIconView.setVisibility(z ? 0 : 8);
        this.endIconFrame.setVisibility(z ? 8 : 0);
        updateSuffixTextViewPadding();
        if (this.endIconMode != 0) {
            return;
        }
        updateDummyDrawables();
    }

    public final void setHelperText(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (zIsEmpty) {
            if (indicatorViewController.helperTextEnabled) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!indicatorViewController.helperTextEnabled) {
            setHelperTextEnabled(true);
        }
        indicatorViewController.cancelCaptionAnimator();
        indicatorViewController.helperText = charSequence;
        indicatorViewController.helperTextView.setText(charSequence);
        int i = indicatorViewController.captionDisplayed;
        if (i != 2) {
            indicatorViewController.captionToShow = 2;
        }
        indicatorViewController.updateCaptionViewsVisibility(i, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.helperTextView, charSequence));
    }

    public final void setHelperTextEnabled(boolean z) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        TextInputLayout textInputLayout = indicatorViewController.textInputView;
        if (indicatorViewController.helperTextEnabled == z) {
            return;
        }
        indicatorViewController.cancelCaptionAnimator();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController.context);
            indicatorViewController.helperTextView = appCompatTextView;
            appCompatTextView.setId(R.attr.a17);
            indicatorViewController.helperTextView.setTextAlignment(5);
            indicatorViewController.helperTextView.setVisibility(4);
            AppCompatTextView appCompatTextView2 = indicatorViewController.helperTextView;
            WeakHashMap weakHashMap = qd1.a;
            appCompatTextView2.setAccessibilityLiveRegion(1);
            int i = indicatorViewController.helperTextTextAppearance;
            indicatorViewController.helperTextTextAppearance = i;
            AppCompatTextView appCompatTextView3 = indicatorViewController.helperTextView;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTextAppearance(i);
            }
            ColorStateList colorStateList = indicatorViewController.helperTextViewTextColor;
            indicatorViewController.helperTextViewTextColor = colorStateList;
            AppCompatTextView appCompatTextView4 = indicatorViewController.helperTextView;
            if (appCompatTextView4 != null && colorStateList != null) {
                appCompatTextView4.setTextColor(colorStateList);
            }
            indicatorViewController.addIndicator(indicatorViewController.helperTextView, 1);
        } else {
            indicatorViewController.cancelCaptionAnimator();
            int i2 = indicatorViewController.captionDisplayed;
            if (i2 == 2) {
                indicatorViewController.captionToShow = 0;
            }
            indicatorViewController.updateCaptionViewsVisibility(i2, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.helperTextView, null));
            indicatorViewController.removeIndicator(indicatorViewController.helperTextView, 1);
            indicatorViewController.helperTextView = null;
            textInputLayout.updateEditTextBackground();
            textInputLayout.updateTextInputBoxState();
        }
        indicatorViewController.helperTextEnabled = z;
    }

    public final void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            if (!TextUtils.equals(charSequence, this.hint)) {
                this.hint = charSequence;
                CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
                if (charSequence == null || !TextUtils.equals(collapsingTextHelper.text, charSequence)) {
                    collapsingTextHelper.text = charSequence;
                    collapsingTextHelper.textToDraw = null;
                    Bitmap bitmap = collapsingTextHelper.expandedTitleTexture;
                    if (bitmap != null) {
                        bitmap.recycle();
                        collapsingTextHelper.expandedTitleTexture = null;
                    }
                    collapsingTextHelper.recalculate(false);
                }
                if (!this.hintExpanded) {
                    openCutout();
                }
            }
            sendAccessibilityEvent(2048);
        }
    }

    public final void setPlaceholderText(CharSequence charSequence) {
        if (this.placeholderEnabled && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        }
        EditText editText = this.editText;
        updatePlaceholderText(editText != null ? editText.getText().length() : 0);
    }

    public final void setPlaceholderTextEnabled(boolean z) {
        if (this.placeholderEnabled == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.placeholderTextView = appCompatTextView;
            appCompatTextView.setId(R.attr.a18);
            c cVar = new c();
            cVar.mDuration = 87L;
            LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
            cVar.mInterpolator = linearInterpolator;
            this.placeholderFadeIn = cVar;
            cVar.mStartDelay = 67L;
            c cVar2 = new c();
            cVar2.mDuration = 87L;
            cVar2.mInterpolator = linearInterpolator;
            this.placeholderFadeOut = cVar2;
            AppCompatTextView appCompatTextView2 = this.placeholderTextView;
            WeakHashMap weakHashMap = qd1.a;
            appCompatTextView2.setAccessibilityLiveRegion(1);
            int i = this.placeholderTextAppearance;
            this.placeholderTextAppearance = i;
            AppCompatTextView appCompatTextView3 = this.placeholderTextView;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTextAppearance(i);
            }
            AppCompatTextView appCompatTextView4 = this.placeholderTextView;
            if (appCompatTextView4 != null) {
                this.inputFrame.addView(appCompatTextView4);
                this.placeholderTextView.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView5 = this.placeholderTextView;
            if (appCompatTextView5 != null) {
                appCompatTextView5.setVisibility(8);
            }
            this.placeholderTextView = null;
        }
        this.placeholderEnabled = z;
    }

    public final void setTextAppearanceCompatWithErrorFallback(AppCompatTextView appCompatTextView, int i) {
        try {
            appCompatTextView.setTextAppearance(i);
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        appCompatTextView.setTextAppearance(R.plurals.m4);
        appCompatTextView.setTextColor(getContext().getColor(R.color.cn));
    }

    public final void updateCounter(int i) {
        String str;
        boolean z = this.counterOverflowed;
        AppCompatTextView appCompatTextView = this.counterView;
        int i2 = this.counterMaxLength;
        String string = null;
        if (i2 == -1) {
            appCompatTextView.setText(String.valueOf(i));
            appCompatTextView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            this.counterOverflowed = i > i2;
            appCompatTextView.setContentDescription(getContext().getString(this.counterOverflowed ? R.string.bu : R.string.bt, Integer.valueOf(i), Integer.valueOf(i2)));
            if (z != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            String str2 = t8.d;
            t8 t8Var = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? t8.g : t8.f;
            String string2 = getContext().getString(R.string.bv, Integer.valueOf(i), Integer.valueOf(i2));
            t8Var.getClass();
            if (string2 != null) {
                boolean zB = d61.c.b(string2, string2.length());
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                String str3 = t8.e;
                String str4 = t8.d;
                boolean z2 = t8Var.a;
                boolean zB2 = (zB ? d61.b : d61.a).b(string2, string2.length());
                if (z2 || !(zB2 || t8.a(string2) == 1)) {
                    str = (!z2 || (zB2 && t8.a(string2) != -1)) ? AppConfig.CUSTOM : str3;
                } else {
                    str = str4;
                }
                spannableStringBuilder.append((CharSequence) str);
                if (zB != z2) {
                    spannableStringBuilder.append(zB ? (char) 8235 : (char) 8234);
                    spannableStringBuilder.append((CharSequence) string2);
                    spannableStringBuilder.append((char) 8236);
                } else {
                    spannableStringBuilder.append((CharSequence) string2);
                }
                boolean zB3 = (zB ? d61.b : d61.a).b(string2, string2.length());
                if (!z2 && (zB3 || t8.b(string2) == 1)) {
                    str3 = str4;
                } else if (!z2 || (zB3 && t8.b(string2) != -1)) {
                    str3 = AppConfig.CUSTOM;
                }
                spannableStringBuilder.append((CharSequence) str3);
                string = spannableStringBuilder.toString();
            }
            appCompatTextView.setText(string);
        }
        if (this.editText == null || z == this.counterOverflowed) {
            return;
        }
        updateLabelState(false, false);
        updateTextInputBoxState();
        updateEditTextBackground();
    }

    public final void updateCounterTextAppearanceAndColor() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.counterView;
        if (appCompatTextView != null) {
            setTextAppearanceCompatWithErrorFallback(appCompatTextView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (!this.counterOverflowed || (colorStateList = this.counterOverflowTextColor) == null) {
                return;
            }
            this.counterView.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    public final boolean updateDummyDrawables() {
        boolean z;
        ColorDrawable colorDrawable;
        EditText editText;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        if (this.editText == null) {
            return false;
        }
        Drawable drawable4 = this.startIconView.getDrawable();
        LinearLayout linearLayout = this.startLayout;
        boolean z2 = true;
        CheckableImageButton checkableImageButton = null;
        if (!(drawable4 == null && this.prefixText == null) && linearLayout.getMeasuredWidth() > 0) {
            int measuredWidth = linearLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
            if (this.startDummyDrawable == null || this.startDummyDrawableWidth != measuredWidth) {
                ColorDrawable colorDrawable2 = new ColorDrawable();
                this.startDummyDrawable = colorDrawable2;
                this.startDummyDrawableWidth = measuredWidth;
                colorDrawable2.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = this.editText.getCompoundDrawablesRelative();
            Drawable drawable5 = compoundDrawablesRelative[0];
            ColorDrawable colorDrawable3 = this.startDummyDrawable;
            if (drawable5 != colorDrawable3) {
                this.editText.setCompoundDrawablesRelative(colorDrawable3, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z = true;
            } else {
                z = false;
            }
        } else if (this.startDummyDrawable != null) {
            Drawable[] compoundDrawablesRelative2 = this.editText.getCompoundDrawablesRelative();
            this.editText.setCompoundDrawablesRelative(null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
            this.startDummyDrawable = null;
            z = true;
        } else {
            z = false;
        }
        CheckableImageButton checkableImageButton2 = this.errorIconView;
        if ((checkableImageButton2.getVisibility() == 0 || ((this.endIconMode != 0 && isEndIconVisible()) || this.suffixText != null)) && this.endLayout.getMeasuredWidth() > 0) {
            int measuredWidth2 = this.suffixTextView.getMeasuredWidth() - this.editText.getPaddingRight();
            if (checkableImageButton2.getVisibility() == 0) {
                checkableImageButton = checkableImageButton2;
            } else if (this.endIconMode != 0 && isEndIconVisible()) {
                checkableImageButton = this.endIconView;
            }
            if (checkableImageButton != null) {
                measuredWidth2 = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth() + measuredWidth2;
            }
            Drawable[] compoundDrawablesRelative3 = this.editText.getCompoundDrawablesRelative();
            ColorDrawable colorDrawable4 = this.endDummyDrawable;
            if (colorDrawable4 == null || this.endDummyDrawableWidth == measuredWidth2) {
                if (colorDrawable4 == null) {
                    ColorDrawable colorDrawable5 = new ColorDrawable();
                    this.endDummyDrawable = colorDrawable5;
                    this.endDummyDrawableWidth = measuredWidth2;
                    colorDrawable5.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable6 = compoundDrawablesRelative3[2];
                colorDrawable = this.endDummyDrawable;
                if (drawable6 != colorDrawable) {
                    this.originalEditTextEndDrawable = drawable6;
                    editText = this.editText;
                    drawable = compoundDrawablesRelative3[0];
                    drawable2 = compoundDrawablesRelative3[1];
                    drawable3 = compoundDrawablesRelative3[3];
                }
            } else {
                this.endDummyDrawableWidth = measuredWidth2;
                colorDrawable4.setBounds(0, 0, measuredWidth2, 1);
                editText = this.editText;
                drawable = compoundDrawablesRelative3[0];
                drawable2 = compoundDrawablesRelative3[1];
                colorDrawable = this.endDummyDrawable;
                drawable3 = compoundDrawablesRelative3[3];
            }
            editText.setCompoundDrawablesRelative(drawable, drawable2, colorDrawable, drawable3);
            return true;
        }
        if (this.endDummyDrawable != null) {
            Drawable[] compoundDrawablesRelative4 = this.editText.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative4[2] == this.endDummyDrawable) {
                this.editText.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.originalEditTextEndDrawable, compoundDrawablesRelative4[3]);
            } else {
                z2 = z;
            }
            this.endDummyDrawable = null;
            return z2;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void updateEditTextBackground() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        int currentTextColor;
        PorterDuff.Mode mode;
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        EditText editText = this.editText;
        if (editText == null || this.boxBackgroundMode != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (fp.a(background)) {
            background = background.mutate();
        }
        if (indicatorViewController.errorShouldBeShown()) {
            appCompatTextView = indicatorViewController.errorView;
            if (appCompatTextView == null) {
                currentTextColor = -1;
            }
            mode = PorterDuff.Mode.SRC_IN;
            PorterDuff.Mode mode2 = o5.b;
            synchronized (o5.class) {
                PorterDuffColorFilter porterDuffColorFilterH = rv0.h(currentTextColor, mode);
            }
            background.setColorFilter(porterDuffColorFilterH);
        }
        if (!this.counterOverflowed || (appCompatTextView = this.counterView) == null) {
            background.clearColorFilter();
            this.editText.refreshDrawableState();
            return;
        }
        currentTextColor = appCompatTextView.getCurrentTextColor();
        mode = PorterDuff.Mode.SRC_IN;
        PorterDuff.Mode mode3 = o5.b;
        synchronized (o5.class) {
            PorterDuffColorFilter porterDuffColorFilterH2 = rv0.h(currentTextColor, mode);
            background.setColorFilter(porterDuffColorFilterH2);
        }
    }

    public final void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            FrameLayout frameLayout = this.inputFrame;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iCalculateLabelMarginTop = calculateLabelMarginTop();
            if (iCalculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = iCalculateLabelMarginTop;
                frameLayout.requestLayout();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0078 A[PHI: r0
      0x0078: PHI (r0v4 androidx.appcompat.widget.AppCompatTextView) = (r0v3 androidx.appcompat.widget.AppCompatTextView), (r0v7 androidx.appcompat.widget.AppCompatTextView) binds: [B:35:0x0076, B:29:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    public final void updateLabelState(boolean z, boolean z2) {
        ColorStateList textColors;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.editText;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.editText;
        boolean z4 = editText2 != null && editText2.hasFocus();
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        boolean zErrorShouldBeShown = indicatorViewController.errorShouldBeShown();
        ColorStateList colorStateList = this.defaultHintTextColor;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (colorStateList != null) {
            collapsingTextHelper.setCollapsedTextColor(colorStateList);
            ColorStateList colorStateList2 = this.defaultHintTextColor;
            if (collapsingTextHelper.expandedTextColor != colorStateList2) {
                collapsingTextHelper.expandedTextColor = colorStateList2;
                collapsingTextHelper.recalculate(false);
            }
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.defaultHintTextColor;
            int colorForState = this.disabledColor;
            if (colorStateList3 != null) {
                colorForState = colorStateList3.getColorForState(new int[]{-16842910}, colorForState);
            }
            collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(colorForState));
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(colorForState);
            if (collapsingTextHelper.expandedTextColor != colorStateListValueOf) {
                collapsingTextHelper.expandedTextColor = colorStateListValueOf;
                collapsingTextHelper.recalculate(false);
            }
        } else if (zErrorShouldBeShown) {
            appCompatTextView = indicatorViewController.errorView;
            if (appCompatTextView != null) {
                textColors = appCompatTextView.getTextColors();
            } else {
                textColors = null;
            }
            collapsingTextHelper.setCollapsedTextColor(textColors);
        } else {
            if (this.counterOverflowed && (appCompatTextView = this.counterView) != null) {
                textColors = appCompatTextView.getTextColors();
            } else if (z4 && (textColors = this.focusedTextColor) != null) {
            }
            collapsingTextHelper.setCollapsedTextColor(textColors);
        }
        boolean z5 = this.hintAnimationEnabled;
        if (z3 || !this.expandedHintEnabled || (isEnabled() && z4)) {
            if (!z2 && !this.hintExpanded) {
                return;
            }
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.animator.cancel();
            }
            if (z && z5) {
                animateToExpansionFraction(1.0f);
            } else {
                collapsingTextHelper.setExpansionFraction(1.0f);
            }
            this.hintExpanded = false;
            if (cutoutEnabled()) {
                openCutout();
            }
            EditText editText3 = this.editText;
            updatePlaceholderText(editText3 != null ? editText3.getText().length() : 0);
        } else {
            if (!z2 && this.hintExpanded) {
                return;
            }
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.animator.cancel();
            }
            if (z && z5) {
                animateToExpansionFraction(0.0f);
            } else {
                collapsingTextHelper.setExpansionFraction(0.0f);
            }
            if (cutoutEnabled() && !((CutoutDrawable) this.boxBackground).cutoutBounds.isEmpty() && cutoutEnabled()) {
                ((CutoutDrawable) this.boxBackground).setCutout(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.hintExpanded = true;
            AppCompatTextView appCompatTextView2 = this.placeholderTextView;
            if (appCompatTextView2 != null && this.placeholderEnabled) {
                appCompatTextView2.setText((CharSequence) null);
                j.a(this.inputFrame, this.placeholderFadeOut);
                this.placeholderTextView.setVisibility(4);
            }
        }
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    public final void updatePlaceholderText(int i) {
        FrameLayout frameLayout = this.inputFrame;
        if (i != 0 || this.hintExpanded) {
            AppCompatTextView appCompatTextView = this.placeholderTextView;
            if (appCompatTextView == null || !this.placeholderEnabled) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            j.a(frameLayout, this.placeholderFadeOut);
            this.placeholderTextView.setVisibility(4);
            return;
        }
        AppCompatTextView appCompatTextView2 = this.placeholderTextView;
        if (appCompatTextView2 == null || !this.placeholderEnabled) {
            return;
        }
        appCompatTextView2.setText(this.placeholderText);
        j.a(frameLayout, this.placeholderFadeIn);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
    }

    public final void updatePrefixTextViewPadding() {
        int paddingStart;
        if (this.editText == null) {
            return;
        }
        if (this.startIconView.getVisibility() == 0) {
            paddingStart = 0;
        } else {
            EditText editText = this.editText;
            WeakHashMap weakHashMap = qd1.a;
            paddingStart = editText.getPaddingStart();
        }
        int compoundPaddingTop = this.editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.j1);
        int compoundPaddingBottom = this.editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = qd1.a;
        this.prefixTextView.setPaddingRelative(paddingStart, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void updatePrefixTextVisibility() {
        this.prefixTextView.setVisibility((this.prefixText == null || this.hintExpanded) ? 8 : 0);
        updateDummyDrawables();
    }

    public final void updateSuffixTextViewPadding() {
        int paddingEnd;
        if (this.editText == null) {
            return;
        }
        if (isEndIconVisible() || this.errorIconView.getVisibility() == 0) {
            paddingEnd = 0;
        } else {
            EditText editText = this.editText;
            WeakHashMap weakHashMap = qd1.a;
            paddingEnd = editText.getPaddingEnd();
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.j1);
        int paddingTop = this.editText.getPaddingTop();
        int paddingBottom = this.editText.getPaddingBottom();
        WeakHashMap weakHashMap2 = qd1.a;
        this.suffixTextView.setPaddingRelative(dimensionPixelSize, paddingTop, paddingEnd, paddingBottom);
    }

    public final void updateSuffixTextVisibility() {
        AppCompatTextView appCompatTextView = this.suffixTextView;
        int visibility = appCompatTextView.getVisibility();
        boolean z = (this.suffixText == null || this.hintExpanded) ? false : true;
        appCompatTextView.setVisibility(z ? 0 : 8);
        if (visibility != appCompatTextView.getVisibility()) {
            getEndIconDelegate().onSuffixVisibilityChanged(z);
        }
        updateDummyDrawables();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x013c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x013e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0141  */
    /* JADX WARN: Code duplicated, block: B:108:0x014a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0153  */
    /* JADX WARN: Code duplicated, block: B:117:0x016e  */
    /* JADX WARN: Code duplicated, block: B:119:0x017b  */
    /* JADX WARN: Code duplicated, block: B:123:0x0193  */
    /* JADX WARN: Code duplicated, block: B:127:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x005f  */
    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085 A[PHI: r4
      0x0085: PHI (r4v9 androidx.appcompat.widget.AppCompatTextView) = (r4v6 androidx.appcompat.widget.AppCompatTextView), (r4v12 androidx.appcompat.widget.AppCompatTextView) binds: [B:42:0x005d, B:34:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:80:0x0103  */
    /* JADX WARN: Code duplicated, block: B:83:0x0109  */
    /* JADX WARN: Code duplicated, block: B:91:0x011d  */
    /* JADX WARN: Code duplicated, block: B:95:0x012c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0132  */
    /* JADX WARN: Code duplicated, block: B:98:0x0135  */
    /* JADX WARN: Code duplicated, block: B:99:0x0137 A[ADDED_TO_REGION] */
    public final void updateTextInputBoxState() {
        int defaultColor;
        AppCompatTextView appCompatTextView;
        int colorForState;
        int colorForState2;
        CheckableImageButton checkableImageButton;
        boolean z;
        EndIconDelegate endIconDelegate;
        int i;
        int i2;
        MaterialShapeDrawable materialShapeDrawable;
        int iB;
        MaterialShapeDrawable materialShapeDrawable2;
        int i3;
        int i4;
        int i5;
        int i6;
        EditText editText;
        EditText editText2;
        if (this.boxBackground == null || this.boxBackgroundMode == 0) {
            return;
        }
        boolean z2 = isFocused() || ((editText2 = this.editText) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.editText) != null && editText.isHovered());
        boolean zIsEnabled = isEnabled();
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (!zIsEnabled) {
            defaultColor = this.disabledColor;
        } else if (indicatorViewController.errorShouldBeShown()) {
            if (this.strokeErrorColor != null) {
                defaultColor = this.strokeErrorColor.getDefaultColor();
                colorForState = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
                colorForState2 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
                if (z2) {
                    this.boxStrokeColor = colorForState2;
                } else if (z3) {
                    this.boxStrokeColor = colorForState;
                }
                checkableImageButton = this.errorIconView;
                if (checkableImageButton.getDrawable() == null && indicatorViewController.errorEnabled && indicatorViewController.errorShouldBeShown()) {
                    z = true;
                } else {
                    z = false;
                }
                setErrorIconVisible(z);
                refreshIconDrawableState(checkableImageButton, this.errorIconTintList);
                refreshIconDrawableState(this.startIconView, this.startIconTintList);
                ColorStateList colorStateList = this.endIconTintList;
                CheckableImageButton checkableImageButton2 = this.endIconView;
                refreshIconDrawableState(checkableImageButton2, colorStateList);
                endIconDelegate = getEndIconDelegate();
                endIconDelegate.getClass();
                if (endIconDelegate instanceof DropdownMenuEndIconDelegate) {
                    if (indicatorViewController.errorShouldBeShown() || checkableImageButton2.getDrawable() == null) {
                        applyEndIconTint();
                    } else {
                        Drawable drawableMutate = checkableImageButton2.getDrawable().mutate();
                        AppCompatTextView appCompatTextView2 = indicatorViewController.errorView;
                        drawableMutate.setTint(appCompatTextView2 != null ? appCompatTextView2.getCurrentTextColor() : -1);
                        checkableImageButton2.setImageDrawable(drawableMutate);
                    }
                }
                i = this.boxStrokeWidthPx;
                if (z2 || !isEnabled()) {
                    i2 = this.boxStrokeWidthDefaultPx;
                } else {
                    i2 = this.boxStrokeWidthFocusedPx;
                }
                this.boxStrokeWidthPx = i2;
                if (i2 != i && this.boxBackgroundMode == 2 && cutoutEnabled() && !this.hintExpanded) {
                    if (cutoutEnabled()) {
                        ((CutoutDrawable) this.boxBackground).setCutout(0.0f, 0.0f, 0.0f, 0.0f);
                    }
                    openCutout();
                }
                if (this.boxBackgroundMode == 1) {
                    if (!isEnabled()) {
                        i6 = this.disabledFilledBackgroundColor;
                    } else if (!z3 && !z2) {
                        i6 = this.hoveredFilledBackgroundColor;
                    } else if (z2) {
                        i6 = this.focusedFilledBackgroundColor;
                    } else {
                        i6 = this.defaultFilledBackgroundColor;
                    }
                    this.boxBackgroundColor = i6;
                }
                materialShapeDrawable = this.boxBackground;
                if (materialShapeDrawable == null) {
                    return;
                }
                materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
                if (this.boxBackgroundMode == 2 && (i4 = this.boxStrokeWidthPx) > -1 && (i5 = this.boxStrokeColor) != 0) {
                    MaterialShapeDrawable materialShapeDrawable3 = this.boxBackground;
                    materialShapeDrawable3.setStrokeWidth(i4);
                    materialShapeDrawable3.setStrokeColor(ColorStateList.valueOf(i5));
                }
                iB = this.boxBackgroundColor;
                if (this.boxBackgroundMode == 1) {
                    TypedValue typedValueResolve = MaterialAttributes.resolve(getContext(), R.style.gx);
                    iB = je.b(this.boxBackgroundColor, typedValueResolve != null ? typedValueResolve.data : 0);
                }
                this.boxBackgroundColor = iB;
                this.boxBackground.setFillColor(ColorStateList.valueOf(iB));
                if (this.endIconMode == 3) {
                    this.editText.getBackground().invalidateSelf();
                }
                materialShapeDrawable2 = this.boxUnderline;
                if (materialShapeDrawable2 != null) {
                    if (this.boxStrokeWidthPx > -1 && (i3 = this.boxStrokeColor) != 0) {
                        materialShapeDrawable2.setFillColor(ColorStateList.valueOf(i3));
                    }
                    invalidate();
                }
                invalidate();
            }
            appCompatTextView = indicatorViewController.errorView;
            if (appCompatTextView != null) {
                defaultColor = appCompatTextView.getCurrentTextColor();
            } else {
                defaultColor = -1;
            }
        } else if (!this.counterOverflowed || (appCompatTextView = this.counterView) == null) {
            if (z2) {
                defaultColor = this.focusedStrokeColor;
            } else {
                defaultColor = z3 ? this.hoveredStrokeColor : this.defaultStrokeColor;
            }
        } else {
            if (this.strokeErrorColor != null) {
                defaultColor = this.strokeErrorColor.getDefaultColor();
                colorForState = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
                colorForState2 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
                if (z2) {
                    this.boxStrokeColor = colorForState2;
                } else if (z3) {
                    this.boxStrokeColor = colorForState;
                }
                checkableImageButton = this.errorIconView;
                if (checkableImageButton.getDrawable() == null) {
                    z = false;
                } else {
                    z = false;
                }
                setErrorIconVisible(z);
                refreshIconDrawableState(checkableImageButton, this.errorIconTintList);
                refreshIconDrawableState(this.startIconView, this.startIconTintList);
                ColorStateList colorStateList2 = this.endIconTintList;
                CheckableImageButton checkableImageButton3 = this.endIconView;
                refreshIconDrawableState(checkableImageButton3, colorStateList2);
                endIconDelegate = getEndIconDelegate();
                endIconDelegate.getClass();
                if (endIconDelegate instanceof DropdownMenuEndIconDelegate) {
                    if (indicatorViewController.errorShouldBeShown()) {
                        applyEndIconTint();
                    } else {
                        applyEndIconTint();
                    }
                }
                i = this.boxStrokeWidthPx;
                if (z2) {
                    i2 = this.boxStrokeWidthDefaultPx;
                } else {
                    i2 = this.boxStrokeWidthDefaultPx;
                }
                this.boxStrokeWidthPx = i2;
                if (i2 != i) {
                    if (cutoutEnabled()) {
                        ((CutoutDrawable) this.boxBackground).setCutout(0.0f, 0.0f, 0.0f, 0.0f);
                    }
                    openCutout();
                }
                if (this.boxBackgroundMode == 1) {
                    if (!isEnabled()) {
                        i6 = this.disabledFilledBackgroundColor;
                    } else if (!z3) {
                        if (z2) {
                            i6 = this.focusedFilledBackgroundColor;
                        } else {
                            i6 = this.defaultFilledBackgroundColor;
                        }
                    } else if (z2) {
                        i6 = this.focusedFilledBackgroundColor;
                    } else {
                        i6 = this.defaultFilledBackgroundColor;
                    }
                    this.boxBackgroundColor = i6;
                }
                materialShapeDrawable = this.boxBackground;
                if (materialShapeDrawable == null) {
                    return;
                }
                materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
                if (this.boxBackgroundMode == 2) {
                    MaterialShapeDrawable materialShapeDrawable4 = this.boxBackground;
                    materialShapeDrawable4.setStrokeWidth(i4);
                    materialShapeDrawable4.setStrokeColor(ColorStateList.valueOf(i5));
                }
                iB = this.boxBackgroundColor;
                if (this.boxBackgroundMode == 1) {
                    TypedValue typedValueResolve2 = MaterialAttributes.resolve(getContext(), R.style.gx);
                    iB = je.b(this.boxBackgroundColor, typedValueResolve2 != null ? typedValueResolve2.data : 0);
                }
                this.boxBackgroundColor = iB;
                this.boxBackground.setFillColor(ColorStateList.valueOf(iB));
                if (this.endIconMode == 3) {
                    this.editText.getBackground().invalidateSelf();
                }
                materialShapeDrawable2 = this.boxUnderline;
                if (materialShapeDrawable2 != null) {
                    if (this.boxStrokeWidthPx > -1) {
                        materialShapeDrawable2.setFillColor(ColorStateList.valueOf(i3));
                    }
                    invalidate();
                }
                invalidate();
            }
            defaultColor = appCompatTextView.getCurrentTextColor();
        }
        this.boxStrokeColor = defaultColor;
        checkableImageButton = this.errorIconView;
        if (checkableImageButton.getDrawable() == null) {
            z = false;
        } else {
            z = false;
        }
        setErrorIconVisible(z);
        refreshIconDrawableState(checkableImageButton, this.errorIconTintList);
        refreshIconDrawableState(this.startIconView, this.startIconTintList);
        ColorStateList colorStateList3 = this.endIconTintList;
        CheckableImageButton checkableImageButton4 = this.endIconView;
        refreshIconDrawableState(checkableImageButton4, colorStateList3);
        endIconDelegate = getEndIconDelegate();
        endIconDelegate.getClass();
        if (endIconDelegate instanceof DropdownMenuEndIconDelegate) {
            if (indicatorViewController.errorShouldBeShown()) {
                applyEndIconTint();
            } else {
                applyEndIconTint();
            }
        }
        i = this.boxStrokeWidthPx;
        if (z2) {
            i2 = this.boxStrokeWidthDefaultPx;
        } else {
            i2 = this.boxStrokeWidthDefaultPx;
        }
        this.boxStrokeWidthPx = i2;
        if (i2 != i) {
            if (cutoutEnabled()) {
                ((CutoutDrawable) this.boxBackground).setCutout(0.0f, 0.0f, 0.0f, 0.0f);
            }
            openCutout();
        }
        if (this.boxBackgroundMode == 1) {
            if (!isEnabled()) {
                i6 = this.disabledFilledBackgroundColor;
            } else if (!z3) {
                if (z2) {
                    i6 = this.focusedFilledBackgroundColor;
                } else {
                    i6 = this.defaultFilledBackgroundColor;
                }
            } else if (z2) {
                i6 = this.focusedFilledBackgroundColor;
            } else {
                i6 = this.defaultFilledBackgroundColor;
            }
            this.boxBackgroundColor = i6;
        }
        materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable == null) {
            return;
        }
        materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
        if (this.boxBackgroundMode == 2) {
            MaterialShapeDrawable materialShapeDrawable5 = this.boxBackground;
            materialShapeDrawable5.setStrokeWidth(i4);
            materialShapeDrawable5.setStrokeColor(ColorStateList.valueOf(i5));
        }
        iB = this.boxBackgroundColor;
        if (this.boxBackgroundMode == 1) {
            TypedValue typedValueResolve3 = MaterialAttributes.resolve(getContext(), R.style.gx);
            iB = je.b(this.boxBackgroundColor, typedValueResolve3 != null ? typedValueResolve3.data : 0);
        }
        this.boxBackgroundColor = iB;
        this.boxBackground.setFillColor(ColorStateList.valueOf(iB));
        if (this.endIconMode == 3) {
            this.editText.getBackground().invalidateSelf();
        }
        materialShapeDrawable2 = this.boxUnderline;
        if (materialShapeDrawable2 != null) {
            if (this.boxStrokeWidthPx > -1) {
                materialShapeDrawable2.setFillColor(ColorStateList.valueOf(i3));
            }
            invalidate();
        }
        invalidate();
    }
}
