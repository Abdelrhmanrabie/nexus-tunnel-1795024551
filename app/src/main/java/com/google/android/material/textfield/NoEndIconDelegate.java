package com.google.android.material.textfield;

import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class NoEndIconDelegate extends EndIconDelegate {
    public NoEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout, 0);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        TextInputLayout textInputLayout = this.textInputLayout;
        CheckableImageButton checkableImageButton = textInputLayout.endIconView;
        checkableImageButton.setOnClickListener(null);
        TextInputLayout.setIconClickable(checkableImageButton);
        textInputLayout.endIconView.setImageDrawable(null);
        textInputLayout.setEndIconContentDescription(null);
    }
}
