package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class TimePickerTextInputKeyController implements TextView.OnEditorActionListener, View.OnKeyListener {
    public final ChipTextInputComboView hourLayoutComboView;
    public boolean keyListenerRunning = false;
    public final ChipTextInputComboView minuteLayoutComboView;
    public final TimeModel time;

    public TimePickerTextInputKeyController(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.hourLayoutComboView = chipTextInputComboView;
        this.minuteLayoutComboView = chipTextInputComboView2;
        this.time = timeModel;
    }

    public final void moveSelection(int i) {
        this.minuteLayoutComboView.setChecked(i == 12);
        this.hourLayoutComboView.setChecked(i == 10);
        this.time.selection = i;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = i == 5;
        if (z) {
            moveSelection(12);
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.keyListenerRunning) {
            return false;
        }
        boolean z = true;
        this.keyListenerRunning = true;
        EditText editText = (EditText) view;
        if (this.time.selection != 12) {
            Editable text = editText.getText();
            if (text != null && i >= 7 && i <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
                moveSelection(12);
            } else {
                z = false;
            }
        } else if (i == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            moveSelection(10);
        } else {
            z = false;
        }
        this.keyListenerRunning = false;
        return z;
    }
}
