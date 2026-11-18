package defpackage;

import android.R;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.preference.EditTextPreference;
import androidx.preference.a;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class zp extends a {
    public EditText o;
    public CharSequence p;
    public final as0 q = new as0(8, this);
    public long r = -1;

    @Override // androidx.preference.a
    public final void b(View view) {
        super.b(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.o = editText;
        if (editText == null) {
            d.AnonymousClass0.m("Dialog view must contain an EditText with id @android:id/edit");
            return;
        }
        editText.requestFocus();
        this.o.setText(this.p);
        EditText editText2 = this.o;
        editText2.setSelection(editText2.getText().length());
        ((EditTextPreference) a()).getClass();
    }

    @Override // androidx.preference.a
    public final void c(boolean z) {
        if (z) {
            String string = this.o.getText().toString();
            EditTextPreference editTextPreference = (EditTextPreference) a();
            if (editTextPreference.a(string)) {
                editTextPreference.A(string);
            }
        }
    }

    public final void f() {
        long j = this.r;
        if (j == -1 || j + 1000 <= SystemClock.currentThreadTimeMillis()) {
            return;
        }
        EditText editText = this.o;
        if (editText == null || !editText.isFocused() || ((InputMethodManager) this.o.getContext().getSystemService("input_method")).showSoftInput(this.o, 0)) {
            this.r = -1L;
            return;
        }
        EditText editText2 = this.o;
        as0 as0Var = this.q;
        editText2.removeCallbacks(as0Var);
        this.o.postDelayed(as0Var, 50L);
    }

    @Override // androidx.preference.a, androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p = bundle == null ? ((EditTextPreference) a()).Z : bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
    }

    @Override // androidx.preference.a, androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.p);
    }
}
