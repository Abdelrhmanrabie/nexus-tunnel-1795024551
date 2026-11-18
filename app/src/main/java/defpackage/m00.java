package defpackage;

import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import androidx.appcompat.app.e;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class m00 implements View.OnClickListener {
    public final /* synthetic */ EditText b;
    public final /* synthetic */ EditText c;
    public final /* synthetic */ Switch d;
    public final /* synthetic */ e f;
    public final /* synthetic */ HamoTunnelPlusMain g;

    public m00(HamoTunnelPlusMain hamoTunnelPlusMain, EditText editText, EditText editText2, Switch r4, e eVar) {
        this.g = hamoTunnelPlusMain;
        this.b = editText;
        this.c = editText2;
        this.d = r4;
        this.f = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String strTrim = this.b.getText().toString().trim();
        String strTrim2 = this.c.getText().toString().trim();
        boolean zIsEmpty = strTrim.isEmpty();
        HamoTunnelPlusMain hamoTunnelPlusMain = this.g;
        if (zIsEmpty || strTrim2.isEmpty()) {
            hamoTunnelPlusMain.H(uh.a(-34983239646494L));
            return;
        }
        ig igVar = hamoTunnelPlusMain.i0;
        boolean zIsChecked = this.d.isChecked();
        igVar.getClass();
        String strA = uh.a(-131516924591390L);
        hy0.a aVar = igVar.b;
        aVar.putBoolean(strA, zIsChecked);
        aVar.apply();
        hy0.a aVar2 = hamoTunnelPlusMain.i0.b;
        aVar2.putString(uh.a(-131680133348638L), strTrim);
        aVar2.apply();
        hy0.a aVar3 = hamoTunnelPlusMain.i0.b;
        aVar3.putString(uh.a(-131856227007774L), strTrim2);
        aVar3.apply();
        this.f.dismiss();
    }
}
