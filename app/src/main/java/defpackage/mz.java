package defpackage;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class mz implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;
    public final /* synthetic */ View d;
    public final /* synthetic */ RadioGroup f;
    public final /* synthetic */ View g;
    public final /* synthetic */ View i;
    public final /* synthetic */ View j;
    public final /* synthetic */ HamoTunnelPlusMain n;

    public mz(HamoTunnelPlusMain hamoTunnelPlusMain, View view, View view2, View view3, RadioGroup radioGroup, View view4, View view5, View view6) {
        this.n = hamoTunnelPlusMain;
        this.b = view;
        this.c = view2;
        this.d = view3;
        this.f = radioGroup;
        this.g = view4;
        this.i = view5;
        this.j = view6;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        HamoTunnelPlusMain hamoTunnelPlusMain = this.n;
        ig igVar = hamoTunnelPlusMain.i0;
        igVar.getClass();
        String strA = uh.a(-129996506168606L);
        hy0.a aVar = igVar.b;
        aVar.putInt(strA, i);
        aVar.apply();
        View view2 = this.b;
        view2.setVisibility(0);
        View view3 = this.c;
        View view4 = this.d;
        RadioGroup radioGroup = this.f;
        View view5 = this.g;
        HamoTunnelPlusMain.c0(view3, view4, radioGroup, view5);
        View view6 = this.j;
        View view7 = this.i;
        if (i == 0) {
            HamoTunnelPlusMain.C0(view7, view6);
            return;
        }
        if (i == 1) {
            HamoTunnelPlusMain.C0(view3, view7, view6);
            return;
        }
        if (i == 2) {
            HamoTunnelPlusMain.c0(view7, view6);
            HamoTunnelPlusMain.C0(view3);
            return;
        }
        if (i == 3) {
            if (hamoTunnelPlusMain.i0.t() == 0) {
                HamoTunnelPlusMain.C0(radioGroup, view7, view6);
                return;
            } else {
                HamoTunnelPlusMain.C0(radioGroup, view3, view7, view6);
                return;
            }
        }
        if (i == 4) {
            HamoTunnelPlusMain.c0(view2, view4);
            HamoTunnelPlusMain.C0(view5);
        } else {
            if (i != 5) {
                return;
            }
            HamoTunnelPlusMain.c0(view2);
            HamoTunnelPlusMain.C0(view4);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
