package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import defpackage.ak;
import defpackage.vp0;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
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
            SwitchPreference switchPreference = SwitchPreference.this;
            if (switchPreference.a(boolValueOf)) {
                switchPreference.A(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchPreference(Context context, AttributeSet attributeSet) {
        int iA = ak.a(context, R.style.a2_, android.R.attr.switchPreferenceStyle);
        super(context, attributeSet, iA);
        this.Y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.l, iA, 0);
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
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.T);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.Z);
            r4.setTextOff(this.a0);
            r4.setOnCheckedChangeListener(this.Y);
        }
    }

    @Override // androidx.preference.Preference
    public final void m(vp0 vp0Var) {
        super.m(vp0Var);
        C(vp0Var.a(android.R.id.switch_widget));
        B(vp0Var.a(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void t(View view) {
        super.t(view);
        if (((AccessibilityManager) this.b.getSystemService("accessibility")).isEnabled()) {
            C(view.findViewById(android.R.id.switch_widget));
            B(view.findViewById(android.R.id.summary));
        }
    }
}
