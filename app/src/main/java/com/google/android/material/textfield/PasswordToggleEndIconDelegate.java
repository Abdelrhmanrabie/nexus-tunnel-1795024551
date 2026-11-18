package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import java.util.LinkedHashSet;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class PasswordToggleEndIconDelegate extends EndIconDelegate {
    public final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;
    public final TextInputLayout.OnEndIconChangedListener onEndIconChangedListener;
    public final TextWatcher textWatcher;

    /* JADX INFO: renamed from: com.google.android.material.textfield.PasswordToggleEndIconDelegate$2, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class AnonymousClass2 implements TextInputLayout.OnEditTextAttachedListener {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public final void onEditTextAttached(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.editText;
            textInputLayout.setEndIconVisible(true);
            CheckableImageButton checkableImageButton = textInputLayout.endIconView;
            if (!checkableImageButton.checkable) {
                checkableImageButton.checkable = true;
                checkableImageButton.sendAccessibilityEvent(0);
            }
            PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = PasswordToggleEndIconDelegate.this;
            CheckableImageButton checkableImageButton2 = passwordToggleEndIconDelegate.endIconView;
            TextWatcher textWatcher = passwordToggleEndIconDelegate.textWatcher;
            checkableImageButton2.setChecked(!PasswordToggleEndIconDelegate.access$000(passwordToggleEndIconDelegate));
            editText.removeTextChangedListener(textWatcher);
            editText.addTextChangedListener(textWatcher);
        }
    }

    public PasswordToggleEndIconDelegate(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
        this.textWatcher = new TextWatcherAdapter() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = PasswordToggleEndIconDelegate.this;
                passwordToggleEndIconDelegate.endIconView.setChecked(!PasswordToggleEndIconDelegate.access$000(passwordToggleEndIconDelegate));
            }
        };
        this.onEditTextAttachedListener = new AnonymousClass2();
        this.onEndIconChangedListener = new TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public final void onEndIconChanged(TextInputLayout textInputLayout2, int i2) {
                final EditText editText = textInputLayout2.editText;
                if (editText == null || i2 != 1) {
                    return;
                }
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.post(new Runnable() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        editText.removeTextChangedListener(PasswordToggleEndIconDelegate.this.textWatcher);
                    }
                });
            }
        };
    }

    public static boolean access$000(PasswordToggleEndIconDelegate passwordToggleEndIconDelegate) {
        EditText editText = passwordToggleEndIconDelegate.textInputLayout.editText;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        int i = this.customEndIcon;
        if (i == 0) {
            i = R.drawable.ds;
        }
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconDrawable(i);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.ko));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = PasswordToggleEndIconDelegate.this;
                EditText editText = passwordToggleEndIconDelegate.textInputLayout.editText;
                if (editText == null) {
                    return;
                }
                int selectionEnd = editText.getSelectionEnd();
                editText.setTransformationMethod(PasswordToggleEndIconDelegate.access$000(passwordToggleEndIconDelegate) ? null : PasswordTransformationMethod.getInstance());
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
                TextInputLayout textInputLayout2 = passwordToggleEndIconDelegate.textInputLayout;
                textInputLayout2.refreshIconDrawableState(textInputLayout2.endIconView, textInputLayout2.endIconTintList);
            }
        };
        CheckableImageButton checkableImageButton = textInputLayout.endIconView;
        checkableImageButton.setOnClickListener(onClickListener);
        TextInputLayout.setIconClickable(checkableImageButton);
        LinkedHashSet linkedHashSet = textInputLayout.editTextAttachedListeners;
        TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener = this.onEditTextAttachedListener;
        linkedHashSet.add(onEditTextAttachedListener);
        if (textInputLayout.editText != null) {
            ((AnonymousClass2) onEditTextAttachedListener).onEditTextAttached(textInputLayout);
        }
        textInputLayout.endIconChangedListeners.add(this.onEndIconChangedListener);
        EditText editText = textInputLayout.editText;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}
