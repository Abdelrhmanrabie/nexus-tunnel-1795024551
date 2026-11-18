package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import java.util.LinkedHashSet;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class ClearTextEndIconDelegate extends EndIconDelegate {
    public final TextWatcher clearTextEndIconTextWatcher;
    public final TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener;
    public final TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    public AnimatorSet iconInAnim;
    public ValueAnimator iconOutAnim;
    public final View.OnFocusChangeListener onFocusChangeListener;

    /* JADX INFO: renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$3, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class AnonymousClass3 implements TextInputLayout.OnEditTextAttachedListener {
        public AnonymousClass3() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public final void onEditTextAttached(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.editText;
            ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
            boolean zAccess$000 = ClearTextEndIconDelegate.access$000(clearTextEndIconDelegate);
            TextWatcher textWatcher = clearTextEndIconDelegate.clearTextEndIconTextWatcher;
            View.OnFocusChangeListener onFocusChangeListener = clearTextEndIconDelegate.onFocusChangeListener;
            textInputLayout.setEndIconVisible(zAccess$000);
            CheckableImageButton checkableImageButton = textInputLayout.endIconView;
            if (checkableImageButton.checkable) {
                checkableImageButton.checkable = false;
                checkableImageButton.sendAccessibilityEvent(0);
            }
            editText.setOnFocusChangeListener(onFocusChangeListener);
            clearTextEndIconDelegate.endIconView.setOnFocusChangeListener(onFocusChangeListener);
            editText.removeTextChangedListener(textWatcher);
            editText.addTextChangedListener(textWatcher);
        }
    }

    public ClearTextEndIconDelegate(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
        this.clearTextEndIconTextWatcher = new TextWatcher() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                if (clearTextEndIconDelegate.textInputLayout.suffixText != null) {
                    return;
                }
                clearTextEndIconDelegate.animateIcon(ClearTextEndIconDelegate.access$000(clearTextEndIconDelegate));
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        };
        this.onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                clearTextEndIconDelegate.animateIcon(ClearTextEndIconDelegate.access$000(clearTextEndIconDelegate));
            }
        };
        this.clearTextOnEditTextAttachedListener = new AnonymousClass3();
        this.endIconChangedListener = new TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4
            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public final void onEndIconChanged(TextInputLayout textInputLayout2, int i2) {
                final EditText editText = textInputLayout2.editText;
                if (editText == null || i2 != 2) {
                    return;
                }
                editText.post(new Runnable() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
                    }
                });
                View.OnFocusChangeListener onFocusChangeListener = editText.getOnFocusChangeListener();
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                View.OnFocusChangeListener onFocusChangeListener2 = clearTextEndIconDelegate.onFocusChangeListener;
                CheckableImageButton checkableImageButton = clearTextEndIconDelegate.endIconView;
                if (onFocusChangeListener == onFocusChangeListener2) {
                    editText.setOnFocusChangeListener(null);
                }
                if (checkableImageButton.getOnFocusChangeListener() == clearTextEndIconDelegate.onFocusChangeListener) {
                    checkableImageButton.setOnFocusChangeListener(null);
                }
            }
        };
    }

    public static boolean access$000(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        EditText editText = clearTextEndIconDelegate.textInputLayout.editText;
        if (editText != null) {
            return (editText.hasFocus() || clearTextEndIconDelegate.endIconView.hasFocus()) && editText.getText().length() > 0;
        }
        return false;
    }

    public final void animateIcon(boolean z) {
        boolean z2 = this.textInputLayout.isEndIconVisible() == z;
        if (z && !this.iconInAnim.isRunning()) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if (z2) {
                this.iconInAnim.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.iconInAnim.cancel();
        this.iconOutAnim.start();
        if (z2) {
            this.iconOutAnim.end();
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        int i = this.customEndIcon;
        if (i == 0) {
            i = R.drawable.mu;
        }
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconDrawable(i);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.by));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                Editable text = clearTextEndIconDelegate.textInputLayout.editText.getText();
                if (text != null) {
                    text.clear();
                }
                TextInputLayout textInputLayout2 = clearTextEndIconDelegate.textInputLayout;
                textInputLayout2.refreshIconDrawableState(textInputLayout2.endIconView, textInputLayout2.endIconTintList);
            }
        };
        CheckableImageButton checkableImageButton = textInputLayout.endIconView;
        checkableImageButton.setOnClickListener(onClickListener);
        TextInputLayout.setIconClickable(checkableImageButton);
        LinkedHashSet linkedHashSet = textInputLayout.editTextAttachedListeners;
        TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener = this.clearTextOnEditTextAttachedListener;
        linkedHashSet.add(onEditTextAttachedListener);
        if (textInputLayout.editText != null) {
            ((AnonymousClass3) onEditTextAttachedListener).onEditTextAttached(textInputLayout);
        }
        textInputLayout.endIconChangedListeners.add(this.endIconChangedListener);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                clearTextEndIconDelegate.endIconView.setScaleX(fFloatValue);
                clearTextEndIconDelegate.endIconView.setScaleY(fFloatValue);
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat2.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat2.setDuration(100L);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.iconInAnim = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.iconInAnim.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(true);
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat3.setDuration(100L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.iconOutAnim = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(false);
            }
        });
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void onSuffixVisibilityChanged(boolean z) {
        if (this.textInputLayout.suffixText == null) {
            return;
        }
        animateIcon(z);
    }
}
