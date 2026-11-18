package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    public final Chip chip;
    public final EditText editText;
    public final TextInputLayout textInputLayout;
    public final TextWatcher watcher;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class TextFormatter extends TextWatcherAdapter {
        private TextFormatter() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            boolean zIsEmpty = TextUtils.isEmpty(editable);
            ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
            if (zIsEmpty) {
                Chip chip = chipTextInputComboView.chip;
                Resources resources = chipTextInputComboView.getResources();
                Parcelable.Creator<TimeModel> creator = TimeModel.CREATOR;
                chip.setText(String.format(resources.getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt("00"))));
                return;
            }
            Chip chip2 = chipTextInputComboView.chip;
            Resources resources2 = chipTextInputComboView.getResources();
            Parcelable.Creator<TimeModel> creator2 = TimeModel.CREATOR;
            chip2.setText(String.format(resources2.getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(editable)))));
        }
    }

    public ChipTextInputComboView(Context context) {
        this(context, null);
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R.layout.d3, (ViewGroup) this, false);
        this.chip = chip;
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R.layout.d4, (ViewGroup) this, false);
        this.textInputLayout = textInputLayout;
        EditText editText = textInputLayout.editText;
        this.editText = editText;
        editText.setVisibility(4);
        TextFormatter textFormatter = new TextFormatter();
        this.watcher = textFormatter;
        editText.addTextChangedListener(textFormatter);
        if (Build.VERSION.SDK_INT >= 24) {
            editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
        addView(chip);
        addView(textInputLayout);
        editText.setSaveEnabled(false);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.chip.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT >= 24) {
            this.editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z) {
        Chip chip = this.chip;
        chip.setChecked(z);
        int i = z ? 0 : 4;
        EditText editText = this.editText;
        editText.setVisibility(i);
        chip.setVisibility(z ? 8 : 0);
        if (chip.isChecked()) {
            ViewUtils.requestFocusAndShowKeyboard(editText);
            if (TextUtils.isEmpty(editText.getText())) {
                return;
            }
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.chip.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setTag(int i, Object obj) {
        this.chip.setTag(i, obj);
    }

    public final void setText(String str) {
        Resources resources = getResources();
        Parcelable.Creator<TimeModel> creator = TimeModel.CREATOR;
        this.chip.setText(String.format(resources.getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(str))));
        EditText editText = this.editText;
        if (TextUtils.isEmpty(editText.getText())) {
            return;
        }
        TextWatcher textWatcher = this.watcher;
        editText.removeTextChangedListener(textWatcher);
        editText.setText((CharSequence) null);
        editText.addTextChangedListener(textWatcher);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.chip.toggle();
    }
}
