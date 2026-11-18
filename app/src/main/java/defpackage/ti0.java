package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.e;
import androidx.preference.MultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ti0 extends androidx.preference.a {
    public final HashSet o = new HashSet();
    public boolean p;
    public CharSequence[] q;
    public CharSequence[] r;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements DialogInterface.OnMultiChoiceClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
            ti0 ti0Var = ti0.this;
            HashSet hashSet = ti0Var.o;
            boolean z2 = ti0Var.p;
            CharSequence[] charSequenceArr = ti0Var.r;
            ti0Var.p = (z ? hashSet.add(charSequenceArr[i].toString()) : hashSet.remove(charSequenceArr[i].toString())) | z2;
        }
    }

    @Override // androidx.preference.a
    public final void c(boolean z) {
        if (z && this.p) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) a();
            HashSet hashSet = this.o;
            if (multiSelectListPreference.a(hashSet)) {
                multiSelectListPreference.A(hashSet);
            }
        }
        this.p = false;
    }

    @Override // androidx.preference.a
    public final void d(e.a aVar) {
        int length = this.r.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.o.contains(this.r[i].toString());
        }
        CharSequence[] charSequenceArr = this.q;
        a aVar2 = new a();
        AlertController.b bVar = aVar.P;
        bVar.u = charSequenceArr;
        bVar.I = aVar2;
        bVar.E = zArr;
        bVar.F = true;
    }

    @Override // androidx.preference.a, androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.onCreate(bundle);
        HashSet hashSet = this.o;
        if (bundle != null) {
            hashSet.clear();
            hashSet.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.p = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.q = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.r = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) a();
        if (multiSelectListPreference.Z == null || (charSequenceArr = multiSelectListPreference.a0) == null) {
            d.AnonymousClass0.m("MultiSelectListPreference requires an entries array and an entryValues array.");
            return;
        }
        hashSet.clear();
        hashSet.addAll(multiSelectListPreference.b0);
        this.p = false;
        this.q = multiSelectListPreference.Z;
        this.r = charSequenceArr;
    }

    @Override // androidx.preference.a, androidx.fragment.app.m, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.o));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.p);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.q);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.r);
    }
}
