package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import defpackage.ak;
import defpackage.vp0;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, ak.a(context, R.style.x0, android.R.attr.preferenceCategoryStyle));
    }

    @Override // androidx.preference.Preference
    public final boolean h() {
        return false;
    }

    @Override // androidx.preference.Preference
    public final void m(vp0 vp0Var) {
        super.m(vp0Var);
        if (Build.VERSION.SDK_INT >= 28) {
            vp0Var.itemView.setAccessibilityHeading(true);
        }
    }

    @Override // androidx.preference.Preference
    public final boolean y() {
        return !super.h();
    }
}
