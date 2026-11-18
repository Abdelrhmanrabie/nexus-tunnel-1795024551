package defpackage;

import android.view.KeyEvent;
import android.widget.CompoundButton;
import android.widget.EditText;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class oz implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int G0 = 1;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ KeyEvent.Callback c;

    public oz(EditText editText, EditText editText2) {
        this.b = editText;
        this.c = editText2;
    }

    public oz(HamoTunnelPlusMain hamoTunnelPlusMain, EditText editText) {
        this.c = hamoTunnelPlusMain;
        this.b = editText;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean z2;
        if (this.G0 != 0) {
            this.b.setEnabled(z);
            ((EditText) this.c).setEnabled(z);
            return;
        }
        ig igVar = ((HamoTunnelPlusMain) this.c).i0;
        igVar.getClass();
        String strA = uh.a(-131044478188830L);
        hy0.a aVar = igVar.b;
        aVar.putBoolean(strA, z);
        aVar.apply();
        EditText editText = this.b;
        if (z) {
            editText.setText(uh.a(-24396145261854L));
            z2 = false;
        } else {
            editText.setText(uh.a(-24439094934814L));
            z2 = true;
        }
        editText.setEnabled(z2);
    }
}
