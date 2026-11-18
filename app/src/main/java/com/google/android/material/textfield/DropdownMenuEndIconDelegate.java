package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import defpackage.o1;
import defpackage.qd1;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class DropdownMenuEndIconDelegate extends EndIconDelegate {
    public final TextInputLayout.AccessibilityDelegate accessibilityDelegate;
    public AccessibilityManager accessibilityManager;
    public final TextInputLayout.OnEditTextAttachedListener dropdownMenuOnEditTextAttachedListener;
    public long dropdownPopupActivatedAt;
    public boolean dropdownPopupDirty;
    public final TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    public final TextWatcher exposedDropdownEndIconTextWatcher;
    public ValueAnimator fadeInAnim;
    public ValueAnimator fadeOutAnim;
    public StateListDrawable filledPopupBackground;
    public boolean isEndIconChecked;
    public final View.OnFocusChangeListener onFocusChangeListener;
    public MaterialShapeDrawable outlinedPopupBackground;

    /* JADX INFO: renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$4, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class AnonymousClass4 implements TextInputLayout.OnEditTextAttachedListener {
        public AnonymousClass4() {
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0029  */
        /* JADX WARN: Code duplicated, block: B:21:0x0053  */
        /* JADX WARN: Code duplicated, block: B:22:0x00a2 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:23:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:26:0x00e1  */
        /* JADX WARN: Code duplicated, block: B:30:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:33:0x0103  */
        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public final void onEditTextAttached(TextInputLayout textInputLayout) {
            Drawable drawable;
            TextInputLayout textInputLayout2;
            CheckableImageButton checkableImageButton;
            TextInputLayout.AccessibilityDelegate accessibilityDelegate;
            EditText editText;
            int i;
            MaterialShapeDrawable materialShapeDrawable;
            int color;
            int[][] iArr;
            EditText editText2 = textInputLayout.editText;
            if (!(editText2 instanceof AutoCompleteTextView)) {
                throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
            }
            final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText2;
            final DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
            TextInputLayout textInputLayout3 = dropdownMenuEndIconDelegate.textInputLayout;
            TextWatcher textWatcher = dropdownMenuEndIconDelegate.exposedDropdownEndIconTextWatcher;
            int i2 = textInputLayout3.boxBackgroundMode;
            if (i2 != 2) {
                if (i2 == 1) {
                    drawable = dropdownMenuEndIconDelegate.filledPopupBackground;
                }
                textInputLayout2 = dropdownMenuEndIconDelegate.textInputLayout;
                if (autoCompleteTextView.getKeyListener() == null) {
                    i = textInputLayout2.boxBackgroundMode;
                    if (i == 1 && i != 2) {
                        throw new IllegalStateException();
                    }
                    materialShapeDrawable = textInputLayout2.boxBackground;
                    color = MaterialColors.getColor(autoCompleteTextView, R.style.g5);
                    iArr = new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]};
                    if (i == 2) {
                        int color2 = MaterialColors.getColor(autoCompleteTextView, R.style.gx);
                        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
                        int iLayer = MaterialColors.layer(color, color2, 0.1f);
                        materialShapeDrawable2.setFillColor(new ColorStateList(iArr, new int[]{iLayer, 0}));
                        materialShapeDrawable2.setTint(color2);
                        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iLayer, color2});
                        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
                        materialShapeDrawable3.setTint(-1);
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
                        WeakHashMap weakHashMap = qd1.a;
                        autoCompleteTextView.setBackground(layerDrawable);
                    } else if (i == 1) {
                        int i3 = textInputLayout2.boxBackgroundColor;
                        RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.layer(color, i3, 0.1f), i3}), materialShapeDrawable, materialShapeDrawable);
                        WeakHashMap weakHashMap2 = qd1.a;
                        autoCompleteTextView.setBackground(rippleDrawable);
                    }
                }
                autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.7
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate2 = DropdownMenuEndIconDelegate.this;
                            dropdownMenuEndIconDelegate2.getClass();
                            long jCurrentTimeMillis = System.currentTimeMillis() - dropdownMenuEndIconDelegate2.dropdownPopupActivatedAt;
                            if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
                                dropdownMenuEndIconDelegate2.dropdownPopupDirty = false;
                            }
                            DropdownMenuEndIconDelegate.access$500(dropdownMenuEndIconDelegate2, autoCompleteTextView);
                        }
                        return false;
                    }
                });
                autoCompleteTextView.setOnFocusChangeListener(dropdownMenuEndIconDelegate.onFocusChangeListener);
                autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.8
                    @Override // android.widget.AutoCompleteTextView.OnDismissListener
                    public final void onDismiss() {
                        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate2 = DropdownMenuEndIconDelegate.this;
                        dropdownMenuEndIconDelegate2.dropdownPopupDirty = true;
                        dropdownMenuEndIconDelegate2.dropdownPopupActivatedAt = System.currentTimeMillis();
                        dropdownMenuEndIconDelegate2.setEndIconChecked(false);
                    }
                });
                autoCompleteTextView.setThreshold(0);
                autoCompleteTextView.removeTextChangedListener(textWatcher);
                autoCompleteTextView.addTextChangedListener(textWatcher);
                checkableImageButton = textInputLayout.endIconView;
                if (!checkableImageButton.checkable) {
                    checkableImageButton.checkable = true;
                    checkableImageButton.sendAccessibilityEvent(0);
                }
                textInputLayout.errorIconView.setImageDrawable(null);
                textInputLayout.setErrorIconVisible(false);
                if (autoCompleteTextView.getKeyListener() == null) {
                    CheckableImageButton checkableImageButton2 = dropdownMenuEndIconDelegate.endIconView;
                    WeakHashMap weakHashMap3 = qd1.a;
                    checkableImageButton2.setImportantForAccessibility(2);
                }
                accessibilityDelegate = dropdownMenuEndIconDelegate.accessibilityDelegate;
                editText = textInputLayout.editText;
                if (editText != null) {
                    qd1.l(editText, accessibilityDelegate);
                }
                textInputLayout.setEndIconVisible(true);
            }
            drawable = dropdownMenuEndIconDelegate.outlinedPopupBackground;
            autoCompleteTextView.setDropDownBackgroundDrawable(drawable);
            textInputLayout2 = dropdownMenuEndIconDelegate.textInputLayout;
            if (autoCompleteTextView.getKeyListener() == null) {
                i = textInputLayout2.boxBackgroundMode;
                if (i == 1) {
                }
                materialShapeDrawable = textInputLayout2.boxBackground;
                color = MaterialColors.getColor(autoCompleteTextView, R.style.g5);
                iArr = new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]};
                if (i == 2) {
                    int color3 = MaterialColors.getColor(autoCompleteTextView, R.style.gx);
                    MaterialShapeDrawable materialShapeDrawable4 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
                    int iLayer2 = MaterialColors.layer(color, color3, 0.1f);
                    materialShapeDrawable4.setFillColor(new ColorStateList(iArr, new int[]{iLayer2, 0}));
                    materialShapeDrawable4.setTint(color3);
                    ColorStateList colorStateList2 = new ColorStateList(iArr, new int[]{iLayer2, color3});
                    MaterialShapeDrawable materialShapeDrawable5 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
                    materialShapeDrawable5.setTint(-1);
                    LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList2, materialShapeDrawable4, materialShapeDrawable5), materialShapeDrawable});
                    WeakHashMap weakHashMap4 = qd1.a;
                    autoCompleteTextView.setBackground(layerDrawable2);
                } else if (i == 1) {
                    int i4 = textInputLayout2.boxBackgroundColor;
                    RippleDrawable rippleDrawable2 = new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.layer(color, i4, 0.1f), i4}), materialShapeDrawable, materialShapeDrawable);
                    WeakHashMap weakHashMap5 = qd1.a;
                    autoCompleteTextView.setBackground(rippleDrawable2);
                }
            }
            autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.7
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate2 = DropdownMenuEndIconDelegate.this;
                        dropdownMenuEndIconDelegate2.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis() - dropdownMenuEndIconDelegate2.dropdownPopupActivatedAt;
                        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
                            dropdownMenuEndIconDelegate2.dropdownPopupDirty = false;
                        }
                        DropdownMenuEndIconDelegate.access$500(dropdownMenuEndIconDelegate2, autoCompleteTextView);
                    }
                    return false;
                }
            });
            autoCompleteTextView.setOnFocusChangeListener(dropdownMenuEndIconDelegate.onFocusChangeListener);
            autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.8
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate2 = DropdownMenuEndIconDelegate.this;
                    dropdownMenuEndIconDelegate2.dropdownPopupDirty = true;
                    dropdownMenuEndIconDelegate2.dropdownPopupActivatedAt = System.currentTimeMillis();
                    dropdownMenuEndIconDelegate2.setEndIconChecked(false);
                }
            });
            autoCompleteTextView.setThreshold(0);
            autoCompleteTextView.removeTextChangedListener(textWatcher);
            autoCompleteTextView.addTextChangedListener(textWatcher);
            checkableImageButton = textInputLayout.endIconView;
            if (!checkableImageButton.checkable) {
                checkableImageButton.checkable = true;
                checkableImageButton.sendAccessibilityEvent(0);
            }
            textInputLayout.errorIconView.setImageDrawable(null);
            textInputLayout.setErrorIconVisible(false);
            if (autoCompleteTextView.getKeyListener() == null) {
                CheckableImageButton checkableImageButton3 = dropdownMenuEndIconDelegate.endIconView;
                WeakHashMap weakHashMap6 = qd1.a;
                checkableImageButton3.setImportantForAccessibility(2);
            }
            accessibilityDelegate = dropdownMenuEndIconDelegate.accessibilityDelegate;
            editText = textInputLayout.editText;
            if (editText != null) {
                qd1.l(editText, accessibilityDelegate);
            }
            textInputLayout.setEndIconVisible(true);
        }
    }

    public DropdownMenuEndIconDelegate(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
        this.exposedDropdownEndIconTextWatcher = new TextWatcherAdapter() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                EditText editText = dropdownMenuEndIconDelegate.textInputLayout.editText;
                if (!(editText instanceof AutoCompleteTextView)) {
                    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
                }
                final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
                if (dropdownMenuEndIconDelegate.accessibilityManager.isTouchExplorationEnabled() && autoCompleteTextView.getKeyListener() != null && !dropdownMenuEndIconDelegate.endIconView.hasFocus()) {
                    autoCompleteTextView.dismissDropDown();
                }
                autoCompleteTextView.post(new Runnable() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean zIsPopupShowing = autoCompleteTextView.isPopupShowing();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        DropdownMenuEndIconDelegate.this.setEndIconChecked(zIsPopupShowing);
                        DropdownMenuEndIconDelegate.this.dropdownPopupDirty = zIsPopupShowing;
                    }
                });
            }
        };
        this.onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                dropdownMenuEndIconDelegate.textInputLayout.endIconView.setActivated(z);
                if (z) {
                    return;
                }
                dropdownMenuEndIconDelegate.setEndIconChecked(false);
                dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
            }
        };
        this.accessibilityDelegate = new TextInputLayout.AccessibilityDelegate(this.textInputLayout) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, defpackage.a1
            public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
                super.onInitializeAccessibilityNodeInfo(view, o1Var);
                if (!DropdownMenuEndIconDelegate.isEditable(DropdownMenuEndIconDelegate.this.textInputLayout.editText)) {
                    o1Var.i(Spinner.class.getName());
                }
                if (Build.VERSION.SDK_INT >= 26 ? o1Var.a.isShowingHintText() : o1Var.e(4)) {
                    o1Var.m(null);
                }
            }

            @Override // defpackage.a1
            public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                EditText editText = dropdownMenuEndIconDelegate.textInputLayout.editText;
                if (!(editText instanceof AutoCompleteTextView)) {
                    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
                }
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
                if (accessibilityEvent.getEventType() == 1 && dropdownMenuEndIconDelegate.accessibilityManager.isTouchExplorationEnabled() && !DropdownMenuEndIconDelegate.isEditable(dropdownMenuEndIconDelegate.textInputLayout.editText)) {
                    DropdownMenuEndIconDelegate.access$500(dropdownMenuEndIconDelegate, autoCompleteTextView);
                }
            }
        };
        this.dropdownMenuOnEditTextAttachedListener = new AnonymousClass4();
        this.endIconChangedListener = new TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.5
            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public final void onEndIconChanged(TextInputLayout textInputLayout2, int i2) {
                final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout2.editText;
                if (autoCompleteTextView == null || i2 != 3) {
                    return;
                }
                autoCompleteTextView.post(new Runnable() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.5.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        autoCompleteTextView.removeTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
                    }
                });
                if (autoCompleteTextView.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.this.onFocusChangeListener) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                autoCompleteTextView.setOnDismissListener(null);
            }
        };
        this.dropdownPopupDirty = false;
        this.isEndIconChecked = false;
        this.dropdownPopupActivatedAt = Long.MAX_VALUE;
    }

    public static void access$500(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, AutoCompleteTextView autoCompleteTextView) {
        dropdownMenuEndIconDelegate.getClass();
        if (autoCompleteTextView == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - dropdownMenuEndIconDelegate.dropdownPopupActivatedAt;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
        }
        if (dropdownMenuEndIconDelegate.dropdownPopupDirty) {
            dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
            return;
        }
        dropdownMenuEndIconDelegate.setEndIconChecked(!dropdownMenuEndIconDelegate.isEndIconChecked);
        if (!dropdownMenuEndIconDelegate.isEndIconChecked) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    public static boolean isEditable(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public final MaterialShapeDrawable getPopUpMaterialShapeDrawable(float f, float f2, float f3, int i) {
        RelativeCornerSize relativeCornerSize = ShapeAppearanceModel.PILL;
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
        builder.topLeftCornerSize = new AbsoluteCornerSize(f);
        builder.topRightCornerSize = new AbsoluteCornerSize(f);
        builder.bottomLeftCornerSize = new AbsoluteCornerSize(f2);
        builder.bottomRightCornerSize = new AbsoluteCornerSize(f2);
        ShapeAppearanceModel shapeAppearanceModelBuild = builder.build();
        Paint paint = MaterialShapeDrawable.clearPaint;
        Context context = this.context;
        int iResolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.style.gx, "MaterialShapeDrawable");
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(iResolveOrThrow));
        materialShapeDrawable.setElevation(f3);
        materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModelBuild);
        materialShapeDrawable.setPadding(0, i, 0, i);
        return materialShapeDrawable;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        Context context = this.context;
        float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.nm);
        float dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.lt);
        int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.lv);
        MaterialShapeDrawable popUpMaterialShapeDrawable = getPopUpMaterialShapeDrawable(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable popUpMaterialShapeDrawable2 = getPopUpMaterialShapeDrawable(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.outlinedPopupBackground = popUpMaterialShapeDrawable;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.filledPopupBackground = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, popUpMaterialShapeDrawable);
        this.filledPopupBackground.addState(new int[0], popUpMaterialShapeDrawable2);
        int i = this.customEndIcon;
        if (i == 0) {
            i = R.drawable.mr;
        }
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconDrawable(i);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.ea));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                DropdownMenuEndIconDelegate.access$500(dropdownMenuEndIconDelegate, (AutoCompleteTextView) dropdownMenuEndIconDelegate.textInputLayout.editText);
            }
        };
        CheckableImageButton checkableImageButton = textInputLayout.endIconView;
        checkableImageButton.setOnClickListener(onClickListener);
        TextInputLayout.setIconClickable(checkableImageButton);
        LinkedHashSet linkedHashSet = textInputLayout.editTextAttachedListeners;
        TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener = this.dropdownMenuOnEditTextAttachedListener;
        linkedHashSet.add(onEditTextAttachedListener);
        if (textInputLayout.editText != null) {
            ((AnonymousClass4) onEditTextAttachedListener).onEditTextAttached(textInputLayout);
        }
        textInputLayout.endIconChangedListeners.add(this.endIconChangedListener);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat.setDuration(67);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropdownMenuEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.fadeInAnim = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat2.setDuration(50);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropdownMenuEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.fadeOutAnim = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                dropdownMenuEndIconDelegate.endIconView.setChecked(dropdownMenuEndIconDelegate.isEndIconChecked);
                dropdownMenuEndIconDelegate.fadeInAnim.start();
            }
        });
        this.accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final boolean isBoxBackgroundModeSupported(int i) {
        return i != 0;
    }

    public final void setEndIconChecked(boolean z) {
        if (this.isEndIconChecked != z) {
            this.isEndIconChecked = z;
            this.fadeInAnim.cancel();
            this.fadeOutAnim.start();
        }
    }
}
