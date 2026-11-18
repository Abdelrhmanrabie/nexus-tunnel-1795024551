package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.qd1;
import java.util.Arrays;
import java.util.Locale;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {
    public final EditText hourEditText;
    public final ChipTextInputComboView hourTextInput;
    public final TextWatcher hourTextWatcher;
    public final EditText minuteEditText;
    public final ChipTextInputComboView minuteTextInput;
    public final TextWatcher minuteTextWatcher;
    public final TimeModel time;
    public final LinearLayout timePickerView;
    public final MaterialButtonToggleGroup toggle;

    public TimePickerTextInputPresenter(LinearLayout linearLayout, TimeModel timeModel) {
        TextWatcherAdapter textWatcherAdapter = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
                try {
                    boolean zIsEmpty = TextUtils.isEmpty(editable);
                    TimePickerTextInputPresenter timePickerTextInputPresenter = TimePickerTextInputPresenter.this;
                    if (zIsEmpty) {
                        timePickerTextInputPresenter.time.minute = 0;
                        return;
                    }
                    timePickerTextInputPresenter.time.minute = Integer.parseInt(editable.toString()) % 60;
                } catch (NumberFormatException unused) {
                }
            }
        };
        this.minuteTextWatcher = textWatcherAdapter;
        TextWatcherAdapter textWatcherAdapter2 = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.2
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
                try {
                    boolean zIsEmpty = TextUtils.isEmpty(editable);
                    TimePickerTextInputPresenter timePickerTextInputPresenter = TimePickerTextInputPresenter.this;
                    if (zIsEmpty) {
                        timePickerTextInputPresenter.time.setHour(0);
                    } else {
                        timePickerTextInputPresenter.time.setHour(Integer.parseInt(editable.toString()));
                    }
                } catch (NumberFormatException unused) {
                }
            }
        };
        this.hourTextWatcher = textWatcherAdapter2;
        this.timePickerView = linearLayout;
        this.time = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.attr.q_);
        this.minuteTextInput = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.attr.q7);
        this.hourTextInput = chipTextInputComboView2;
        TextView textView = (TextView) chipTextInputComboView.findViewById(R.attr.q9);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(R.attr.q9);
        textView.setText(resources.getString(R.string.hg));
        textView2.setText(resources.getString(R.string.hf));
        chipTextInputComboView.setTag(R.attr.x0, 12);
        chipTextInputComboView2.setTag(R.attr.x0, 10);
        if (timeModel.format == 0) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) linearLayout.findViewById(R.attr.q6);
            this.toggle = materialButtonToggleGroup;
            materialButtonToggleGroup.onButtonCheckedListeners.add(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.4
                @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
                public final void onButtonChecked(int i, boolean z) {
                    TimePickerTextInputPresenter.this.time.setPeriod(i == R.attr.q5 ? 1 : 0);
                }
            });
            materialButtonToggleGroup.setVisibility(0);
            updateSelection();
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int iIntValue = ((Integer) view.getTag(R.attr.x0)).intValue();
                TimePickerTextInputPresenter timePickerTextInputPresenter = TimePickerTextInputPresenter.this;
                timePickerTextInputPresenter.time.selection = iIntValue;
                timePickerTextInputPresenter.minuteTextInput.setChecked(iIntValue == 12);
                timePickerTextInputPresenter.hourTextInput.setChecked(iIntValue == 10);
                timePickerTextInputPresenter.updateSelection();
            }
        };
        chipTextInputComboView2.setOnClickListener(onClickListener);
        chipTextInputComboView.setOnClickListener(onClickListener);
        MaxInputValidator maxInputValidator = timeModel.hourInputValidator;
        EditText editText = chipTextInputComboView2.editText;
        InputFilter[] filters = editText.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = maxInputValidator;
        editText.setFilters(inputFilterArr);
        MaxInputValidator maxInputValidator2 = timeModel.minuteInputValidator;
        EditText editText2 = chipTextInputComboView.editText;
        InputFilter[] filters2 = editText2.getFilters();
        InputFilter[] inputFilterArr2 = (InputFilter[]) Arrays.copyOf(filters2, filters2.length + 1);
        inputFilterArr2[filters2.length] = maxInputValidator2;
        editText2.setFilters(inputFilterArr2);
        EditText editText3 = chipTextInputComboView2.textInputLayout.editText;
        this.hourEditText = editText3;
        EditText editText4 = chipTextInputComboView.textInputLayout.editText;
        this.minuteEditText = editText4;
        TimePickerTextInputKeyController timePickerTextInputKeyController = new TimePickerTextInputKeyController(chipTextInputComboView2, chipTextInputComboView, timeModel);
        qd1.l(chipTextInputComboView2.chip, new ClickActionDelegate(linearLayout.getContext(), R.string.h3));
        qd1.l(chipTextInputComboView.chip, new ClickActionDelegate(linearLayout.getContext(), R.string.h5));
        editText3.addTextChangedListener(textWatcherAdapter2);
        editText4.addTextChangedListener(textWatcherAdapter);
        setTime(timeModel);
        TextInputLayout textInputLayout = timePickerTextInputKeyController.hourLayoutComboView.textInputLayout;
        TextInputLayout textInputLayout2 = timePickerTextInputKeyController.minuteLayoutComboView.textInputLayout;
        EditText editText5 = textInputLayout.editText;
        EditText editText6 = textInputLayout2.editText;
        editText5.setImeOptions(268435461);
        editText6.setImeOptions(268435462);
        editText5.setOnEditorActionListener(timePickerTextInputKeyController);
        editText5.setOnKeyListener(timePickerTextInputKeyController);
        editText6.setOnKeyListener(timePickerTextInputKeyController);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void hide() {
        InputMethodManager inputMethodManager;
        LinearLayout linearLayout = this.timePickerView;
        View focusedChild = linearLayout.getFocusedChild();
        if (focusedChild != null && (inputMethodManager = (InputMethodManager) linearLayout.getContext().getSystemService(InputMethodManager.class)) != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        linearLayout.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void invalidate() {
        setTime(this.time);
    }

    public final void setTime(TimeModel timeModel) {
        EditText editText = this.hourEditText;
        TextWatcher textWatcher = this.hourTextWatcher;
        editText.removeTextChangedListener(textWatcher);
        EditText editText2 = this.minuteEditText;
        TextWatcher textWatcher2 = this.minuteTextWatcher;
        editText2.removeTextChangedListener(textWatcher2);
        Locale locale = this.timePickerView.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(timeModel.minute));
        String str2 = String.format(locale, "%02d", Integer.valueOf(timeModel.getHourForDisplay()));
        this.minuteTextInput.setText(str);
        this.hourTextInput.setText(str2);
        editText.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher2);
        updateSelection();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void show() {
        this.timePickerView.setVisibility(0);
    }

    public final void updateSelection() {
        MaterialButton materialButton;
        MaterialButtonToggleGroup materialButtonToggleGroup = this.toggle;
        if (materialButtonToggleGroup == null) {
            return;
        }
        int i = this.time.period == 0 ? R.attr.q4 : R.attr.q5;
        if (i == materialButtonToggleGroup.checkedId || (materialButton = (MaterialButton) materialButtonToggleGroup.findViewById(i)) == null) {
            return;
        }
        materialButton.setChecked(true);
    }
}
