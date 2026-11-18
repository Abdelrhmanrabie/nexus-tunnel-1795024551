package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.e;
import androidx.preference.ListPreference;
import androidx.preference.a;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class te0 extends a {
    public int o;
    public CharSequence[] p;
    public CharSequence[] q;

    @Override // androidx.preference.a
    public final void c(boolean z) {
        int i;
        if (!z || (i = this.o) < 0) {
            return;
        }
        String string = this.q[i].toString();
        ListPreference listPreference = (ListPreference) a();
        if (listPreference.a(string)) {
            listPreference.C(string);
        }
    }

    @Override // androidx.preference.a
    public final void d(e.a aVar) {
        CharSequence[] charSequenceArr = this.p;
        int i = this.o;
        sy syVar = new sy(2, this);
        AlertController.b bVar = aVar.P;
        bVar.u = charSequenceArr;
        bVar.w = syVar;
        bVar.H = i;
        bVar.G = true;
        aVar.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // androidx.preference.a, androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.onCreate(bundle);
        if (bundle != null) {
            this.o = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.p = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.q = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreference = (ListPreference) a();
        if (listPreference.Z == null || (charSequenceArr = listPreference.a0) == null) {
            d.AnonymousClass0.m("ListPreference requires an entries array and an entryValues array.");
            return;
        }
        String str = listPreference.b0;
        int i = -1;
        if (str != null) {
            for (int length = charSequenceArr.length - 1; length >= 0; length--) {
                if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                    i = length;
                    break;
                }
            }
        }
        this.o = i;
        this.p = listPreference.Z;
        this.q = charSequenceArr;
    }

    @Override // androidx.preference.a, androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.o);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.p);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.q);
    }
}
