package defpackage;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.c;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class hq implements InputFilter {
    public final TextView a;
    public a b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends c.e {
        public final WeakReference a;
        public final WeakReference b;

        public a(TextView textView, hq hqVar) {
            this.a = new WeakReference(textView);
            this.b = new WeakReference(hqVar);
        }

        @Override // androidx.emoji2.text.c.e
        public final void b() {
            InputFilter[] filters;
            int length;
            TextView textView = (TextView) this.a.get();
            InputFilter inputFilter = (InputFilter) this.b.get();
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    if (textView.isAttachedToWindow()) {
                        c cVarA = c.a();
                        CharSequence text = textView.getText();
                        if (text == null) {
                            length = 0;
                        } else {
                            cVarA.getClass();
                            length = text.length();
                        }
                        CharSequence charSequenceF = cVarA.f(0, length, text);
                        int selectionStart = Selection.getSelectionStart(charSequenceF);
                        int selectionEnd = Selection.getSelectionEnd(charSequenceF);
                        textView.setText(charSequenceF);
                        if (charSequenceF instanceof Spannable) {
                            Spannable spannable = (Spannable) charSequenceF;
                            if (selectionStart >= 0 && selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionStart, selectionEnd);
                                return;
                            } else if (selectionStart >= 0) {
                                Selection.setSelection(spannable, selectionStart);
                                return;
                            } else {
                                if (selectionEnd >= 0) {
                                    Selection.setSelection(spannable, selectionEnd);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    public hq(TextView textView) {
        this.a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        TextView textView = this.a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int iB = c.a().b();
        if (iB != 0) {
            if (iB == 1) {
                if ((i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i != 0 || i2 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return c.a().f(0, charSequence.length(), charSequence);
            }
            if (iB != 3) {
                return charSequence;
            }
        }
        c cVarA = c.a();
        if (this.b == null) {
            this.b = new a(textView, this);
        }
        cVarA.g(this.b);
        return charSequence;
    }
}
