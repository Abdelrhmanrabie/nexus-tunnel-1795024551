package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import defpackage.ak;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public final boolean Z;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, ak.a(context, R.style.x7, android.R.attr.preferenceScreenStyle));
        this.Z = true;
    }

    @Override // androidx.preference.Preference
    public final void n() {
        b bVar;
        if (this.s != null || this.t != null || this.U.size() == 0 || (bVar = this.c.j) == null) {
            return;
        }
        bVar.onNavigateToScreen(this);
    }
}
