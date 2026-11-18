package defpackage;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.c;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class mq implements TextWatcher {
    public final EditText b;
    public a d;
    public boolean f = true;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends c.e {
        public final WeakReference a;

        public a(EditText editText) {
            this.a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.c.e
        public final void b() {
            mq.a((EditText) this.a.get(), 1);
        }
    }

    public mq(EditText editText) {
        this.b = editText;
    }

    public static void a(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            c cVarA = c.a();
            if (editableText == null) {
                length = 0;
            } else {
                cVarA.getClass();
                length = editableText.length();
            }
            cVarA.f(0, length, editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText = this.b;
        if (editText.isInEditMode() || !this.f || c.j == null || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iB = c.a().b();
        if (iB != 0) {
            if (iB == 1) {
                c.a().f(i, i3 + i, (Spannable) charSequence);
                return;
            } else if (iB != 3) {
                return;
            }
        }
        c cVarA = c.a();
        if (this.d == null) {
            this.d = new a(editText);
        }
        cVarA.g(this.d);
    }
}
