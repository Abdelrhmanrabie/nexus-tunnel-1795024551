package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gz implements TextWatcher {
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;
    public final /* synthetic */ HamoTunnelPlusMain d;

    public gz(HamoTunnelPlusMain hamoTunnelPlusMain, View view, View view2) {
        this.d = hamoTunnelPlusMain;
        this.b = view;
        this.c = view2;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean zIsEmpty = editable.toString().isEmpty();
        View view = this.c;
        View view2 = this.b;
        if (zIsEmpty) {
            view2.findViewById(R.attr.dx).setVisibility(8);
            view.setVisibility(8);
            return;
        }
        view2.findViewById(R.attr.dx).setVisibility(0);
        view.setVisibility(0);
        ig igVar = this.d.i0;
        String string = editable.toString();
        hy0.a aVar = igVar.b;
        aVar.putString(uh.a(-133548444122398L), string);
        aVar.apply();
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
