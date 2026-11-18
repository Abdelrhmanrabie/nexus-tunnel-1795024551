package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g00 implements TextWatcher {
    public final /* synthetic */ HamoTunnelPlusMain b;

    public g00(HamoTunnelPlusMain hamoTunnelPlusMain) {
        this.b = hamoTunnelPlusMain;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.b.z0.c(charSequence.toString());
    }
}
