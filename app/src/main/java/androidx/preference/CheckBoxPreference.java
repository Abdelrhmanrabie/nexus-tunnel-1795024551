package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import defpackage.ak;
import defpackage.vp0;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    public final a Y;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Boolean boolValueOf = Boolean.valueOf(z);
            CheckBoxPreference checkBoxPreference = CheckBoxPreference.this;
            if (checkBoxPreference.a(boolValueOf)) {
                checkBoxPreference.A(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        int iA = ak.a(context, R.style.e0, android.R.attr.checkBoxPreferenceStyle);
        super(context, attributeSet, iA);
        this.Y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.f5b, iA, 0);
        String string = typedArrayObtainStyledAttributes.getString(5);
        this.U = string == null ? typedArrayObtainStyledAttributes.getString(0) : string;
        if (this.T) {
            i();
        }
        String string2 = typedArrayObtainStyledAttributes.getString(4);
        this.V = string2 == null ? typedArrayObtainStyledAttributes.getString(1) : string2;
        if (!this.T) {
            i();
        }
        this.X = typedArrayObtainStyledAttributes.getBoolean(3, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.T);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.Y);
        }
    }

    @Override // androidx.preference.Preference
    public final void m(vp0 vp0Var) {
        super.m(vp0Var);
        C(vp0Var.a(android.R.id.checkbox));
        B(vp0Var.a(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void t(View view) {
        super.t(view);
        if (((AccessibilityManager) this.b.getSystemService("accessibility")).isEnabled()) {
            C(view.findViewById(android.R.id.checkbox));
            B(view.findViewById(android.R.id.summary));
        }
    }
}
