package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import defpackage.vp0;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    public final ArrayAdapter e0;
    public Spinner f0;
    public final a g0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            if (i >= 0) {
                DropDownPreference dropDownPreference = DropDownPreference.this;
                String string = dropDownPreference.a0[i].toString();
                if (string.equals(dropDownPreference.b0) || !dropDownPreference.a(string)) {
                    return;
                }
                dropDownPreference.C(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.style.k4);
        this.g0 = new a();
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item);
        this.e0 = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.Z;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void i() {
        super.i();
        ArrayAdapter arrayAdapter = this.e0;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public final void m(vp0 vp0Var) {
        CharSequence[] charSequenceArr;
        Spinner spinner = (Spinner) vp0Var.itemView.findViewById(R.attr.yz);
        this.f0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.e0);
        this.f0.setOnItemSelectedListener(this.g0);
        Spinner spinner2 = this.f0;
        String str = this.b0;
        int i = -1;
        if (str != null && (charSequenceArr = this.a0) != null) {
            for (int length = charSequenceArr.length - 1; length >= 0; length--) {
                if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                    i = length;
                    break;
                }
            }
        }
        spinner2.setSelection(i);
        super.m(vp0Var);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void n() {
        this.f0.performClick();
    }
}
