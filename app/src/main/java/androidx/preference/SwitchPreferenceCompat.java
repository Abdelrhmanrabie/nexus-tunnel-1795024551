package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import defpackage.ak;
import defpackage.vp0;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    public final a Y;
    public final String Z;
    public final String a0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Boolean boolValueOf = Boolean.valueOf(z);
            SwitchPreferenceCompat switchPreferenceCompat = SwitchPreferenceCompat.this;
            if (switchPreferenceCompat.a(boolValueOf)) {
                switchPreferenceCompat.A(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.style.a29);
        this.Y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.m, R.style.a29, 0);
        String string = typedArrayObtainStyledAttributes.getString(7);
        this.U = string == null ? typedArrayObtainStyledAttributes.getString(0) : string;
        if (this.T) {
            i();
        }
        String string2 = typedArrayObtainStyledAttributes.getString(6);
        this.V = string2 == null ? typedArrayObtainStyledAttributes.getString(1) : string2;
        if (!this.T) {
            i();
        }
        String string3 = typedArrayObtainStyledAttributes.getString(9);
        this.Z = string3 == null ? typedArrayObtainStyledAttributes.getString(3) : string3;
        i();
        String string4 = typedArrayObtainStyledAttributes.getString(8);
        this.a0 = string4 == null ? typedArrayObtainStyledAttributes.getString(4) : string4;
        i();
        this.X = typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.T);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOnInternal(this.Z);
            switchCompat.requestLayout();
            if (switchCompat.isChecked()) {
                switchCompat.setOnStateDescriptionOnRAndAbove();
            }
            switchCompat.setTextOffInternal(this.a0);
            switchCompat.requestLayout();
            if (!switchCompat.isChecked()) {
                switchCompat.setOffStateDescriptionOnRAndAbove();
            }
            switchCompat.setOnCheckedChangeListener(this.Y);
        }
    }

    @Override // androidx.preference.Preference
    public final void m(vp0 vp0Var) {
        super.m(vp0Var);
        C(vp0Var.a(R.attr.zz));
        B(vp0Var.a(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void t(View view) {
        super.t(view);
        if (((AccessibilityManager) this.b.getSystemService("accessibility")).isEnabled()) {
            C(view.findViewById(R.attr.zz));
            B(view.findViewById(android.R.id.summary));
        }
    }
}
