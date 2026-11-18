package defpackage;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class nz implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;
    public final /* synthetic */ RadioGroup d;
    public final /* synthetic */ View f;
    public final /* synthetic */ View g;
    public final /* synthetic */ EditText i;
    public final /* synthetic */ HamoTunnelPlusMain j;

    public nz(HamoTunnelPlusMain hamoTunnelPlusMain, View view, View view2, RadioGroup radioGroup, View view3, View view4, EditText editText) {
        this.j = hamoTunnelPlusMain;
        this.b = view;
        this.c = view2;
        this.d = radioGroup;
        this.f = view3;
        this.g = view4;
        this.i = editText;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        long j;
        int iIndexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
        ig igVar = this.j.i0;
        igVar.getClass();
        String strA = uh.a(-131284996357406L);
        hy0.a aVar = igVar.b;
        aVar.putInt(strA, iIndexOfChild);
        aVar.apply();
        View view = this.g;
        View view2 = this.f;
        View view3 = this.b;
        RadioGroup radioGroup2 = this.d;
        View view4 = this.c;
        if (iIndexOfChild == 0) {
            HamoTunnelPlusMain.c0(view3, view4);
            HamoTunnelPlusMain.C0(radioGroup2, view2, view);
            j = -22854252002590L;
        } else {
            HamoTunnelPlusMain.c0(view4);
            HamoTunnelPlusMain.C0(radioGroup2, view3, view2, view);
            j = -23348173241630L;
        }
        this.i.setText(uh.a(j));
    }
}
