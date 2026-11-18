package com.google.android.material.textfield;

import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class CustomEndIconDelegate extends EndIconDelegate {
    public CustomEndIconDelegate(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        int i = this.customEndIcon;
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconDrawable(i);
        CheckableImageButton checkableImageButton = textInputLayout.endIconView;
        checkableImageButton.setOnClickListener(null);
        TextInputLayout.setIconClickable(checkableImageButton);
        checkableImageButton.setOnLongClickListener(null);
        TextInputLayout.setIconClickable(checkableImageButton);
    }
}
