package defpackage;

import android.text.ClipboardManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.e;
import org.hamotunnelplus.xyz.R;
import org.json.JSONObject;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class az implements View.OnClickListener {
    public final /* synthetic */ int G0;
    public final /* synthetic */ HamoTunnelPlusMain b;

    public /* synthetic */ az(HamoTunnelPlusMain hamoTunnelPlusMain, int i) {
        this.G0 = i;
        this.b = hamoTunnelPlusMain;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String strA;
        String strA2;
        long j;
        int i = this.G0;
        HamoTunnelPlusMain hamoTunnelPlusMain = this.b;
        int i2 = 5;
        int i3 = 4;
        int i4 = 3;
        switch (i) {
            case 0:
                HamoTunnelPlusMain.L(hamoTunnelPlusMain);
                break;
            case 1:
                if (!hamoTunnelPlusMain.M0.isChecked()) {
                    HamoTunnelPlusMain.L(hamoTunnelPlusMain);
                } else {
                    hamoTunnelPlusMain.H(uh.a(-15939354656030L));
                }
                break;
            case 2:
                hamoTunnelPlusMain.C0.q();
                break;
            case 3:
                String strTrim = hamoTunnelPlusMain.G0.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    strA = uh.a(-18224277257502L);
                } else if (strTrim.startsWith(uh.a(-18348831309086L))) {
                    try {
                        JSONObject jSONObject = new JSONObject(mc1.b(hamoTunnelPlusMain, strTrim.replace(uh.a(-18426140720414L), uh.a(-18503450131742L))));
                        if (jSONObject.has(uh.a(-18507745099038L)) && jSONObject.getBoolean(uh.a(-18529219935518L))) {
                            hamoTunnelPlusMain.H(uh.a(-18550694771998L));
                        } else {
                            hamoTunnelPlusMain.y0(strTrim);
                        }
                    } catch (Exception e) {
                        strA = uh.a(-18696723660062L) + e.getMessage();
                    }
                }
                hamoTunnelPlusMain.H(strA);
                break;
            case 4:
                String strTrim2 = hamoTunnelPlusMain.G0.getText().toString().trim();
                if (strTrim2.isEmpty()) {
                    strA2 = uh.a(-18786917973278L);
                } else if (strTrim2.startsWith(uh.a(-18911472024862L))) {
                    try {
                        ((ClipboardManager) hamoTunnelPlusMain.getSystemService(uh.a(-19070385814814L))).setText(uh.a(-19113335487774L).concat(mc1.d(new JSONObject(mc1.b(hamoTunnelPlusMain, strTrim2.replace(uh.a(-18988781436190L), uh.a(-19066090847518L)))).toString())));
                        hamoTunnelPlusMain.H(uh.a(-19190644899102L));
                    } catch (Exception e2) {
                        strA2 = uh.a(-19280839212318L) + e2.getMessage();
                    }
                }
                hamoTunnelPlusMain.H(strA2);
                break;
            case 5:
                int i5 = HamoTunnelPlusMain.b1;
                e eVarCreate = new e.a(hamoTunnelPlusMain).create();
                eVarCreate.setTitle(uh.a(-39643279162654L));
                View viewInflate = hamoTunnelPlusMain.getLayoutInflater().inflate(R.layout.b4, (ViewGroup) null);
                View viewFindViewById = viewInflate.findViewById(R.attr.nm);
                EditText editText = (EditText) viewInflate.findViewById(R.attr.gb);
                EditText editText2 = (EditText) viewInflate.findViewById(R.attr.ga);
                Spinner spinner = (Spinner) viewInflate.findViewById(R.attr.gw);
                RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(R.attr.gm);
                EditText editText3 = (EditText) viewInflate.findViewById(R.attr.gk);
                View viewFindViewById2 = viewInflate.findViewById(R.attr.gl);
                EditText editText4 = (EditText) viewInflate.findViewById(R.attr.gc);
                View viewFindViewById3 = viewInflate.findViewById(R.attr.gd);
                View viewFindViewById4 = viewInflate.findViewById(R.attr.gg);
                RadioGroup radioGroup2 = (RadioGroup) viewInflate.findViewById(R.attr.u1);
                EditText editText5 = (EditText) viewInflate.findViewById(R.attr.gf);
                EditText editText6 = (EditText) viewInflate.findViewById(R.attr.gh);
                CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.attr.g9);
                View viewFindViewById5 = viewInflate.findViewById(R.attr.in);
                EditText editText7 = (EditText) viewInflate.findViewById(R.attr.g_);
                View viewFindViewById6 = viewInflate.findViewById(R.attr.a2y);
                EditText editText8 = (EditText) viewInflate.findViewById(R.attr.c7);
                Button button = (Button) viewInflate.findViewById(R.attr.ge);
                spinner.setOnItemSelectedListener(new mz(hamoTunnelPlusMain, viewFindViewById, viewFindViewById2, viewFindViewById5, radioGroup, viewFindViewById6, viewFindViewById3, viewFindViewById4));
                radioGroup.setOnCheckedChangeListener(new nz(hamoTunnelPlusMain, viewFindViewById2, viewFindViewById5, radioGroup, viewFindViewById3, viewFindViewById4, editText4));
                checkBox.setOnCheckedChangeListener(new oz(hamoTunnelPlusMain, editText5));
                viewInflate.findViewById(R.attr.gj).setOnClickListener(new jz(hamoTunnelPlusMain, editText4, 2));
                spinner.setSelection(hamoTunnelPlusMain.i0.c());
                ((RadioButton) radioGroup.getChildAt(hamoTunnelPlusMain.i0.t())).setChecked(true);
                kk0 kk0Var = new kk0();
                kk0Var.b = new qz(0, editText7);
                kk0Var.execute(hamoTunnelPlusMain);
                int iC = hamoTunnelPlusMain.i0.c();
                viewFindViewById.setVisibility(0);
                HamoTunnelPlusMain.c0(viewFindViewById2, viewFindViewById5, radioGroup, viewFindViewById6);
                if (iC == 0) {
                    HamoTunnelPlusMain.C0(viewFindViewById3, viewFindViewById4);
                } else if (iC == 1) {
                    HamoTunnelPlusMain.C0(viewFindViewById2, viewFindViewById3, viewFindViewById4);
                } else if (iC == 2) {
                    HamoTunnelPlusMain.c0(viewFindViewById3, viewFindViewById4);
                    HamoTunnelPlusMain.C0(viewFindViewById2);
                } else if (iC == 3) {
                    if (hamoTunnelPlusMain.i0.t() == 0) {
                        HamoTunnelPlusMain.c0(viewFindViewById2, viewFindViewById5);
                        HamoTunnelPlusMain.C0(radioGroup, viewFindViewById3, viewFindViewById4);
                        j = -39707703672094L;
                    } else {
                        HamoTunnelPlusMain.c0(viewFindViewById5);
                        HamoTunnelPlusMain.C0(radioGroup, viewFindViewById2, viewFindViewById3, viewFindViewById4);
                        j = -40201624911134L;
                    }
                    editText4.setText(uh.a(j));
                } else if (iC == 4) {
                    HamoTunnelPlusMain.c0(viewFindViewById, viewFindViewById5);
                    HamoTunnelPlusMain.C0(viewFindViewById6);
                } else if (iC == 5) {
                    HamoTunnelPlusMain.c0(viewFindViewById);
                    HamoTunnelPlusMain.C0(viewFindViewById5);
                }
                button.setOnClickListener(new rz(hamoTunnelPlusMain, editText, editText2, editText3, editText4, editText5, editText6, editText7, editText8, radioGroup2, eVarCreate));
                eVarCreate.b(viewInflate);
                eVarCreate.show();
                break;
            case 6:
                int i6 = HamoTunnelPlusMain.b1;
                View viewInflate2 = hamoTunnelPlusMain.getLayoutInflater().inflate(R.layout.aq, (ViewGroup) null);
                e eVarCreate2 = new e.a(hamoTunnelPlusMain).create();
                hamoTunnelPlusMain.G0 = (EditText) viewInflate2.findViewById(R.attr.c6);
                View viewFindViewById7 = viewInflate2.findViewById(R.attr.e0);
                EditText editText9 = hamoTunnelPlusMain.G0;
                ig igVar = hamoTunnelPlusMain.i0;
                igVar.getClass();
                editText9.setText(igVar.a.getString(uh.a(-133458249809182L), uh.a(-133544149155102L)));
                hamoTunnelPlusMain.G0.addTextChangedListener(new gz(hamoTunnelPlusMain, viewInflate2, viewFindViewById7));
                viewFindViewById7.setOnClickListener(new az(hamoTunnelPlusMain, i4));
                viewInflate2.findViewById(R.attr.dx).setOnClickListener(new az(hamoTunnelPlusMain, i3));
                viewInflate2.findViewById(R.attr.dt).setOnClickListener(new jz(hamoTunnelPlusMain, eVarCreate2, 0));
                viewInflate2.findViewById(R.attr.dv).setOnClickListener(new kz(0, eVarCreate2));
                viewInflate2.findViewById(R.attr.dy).setOnClickListener(new az(hamoTunnelPlusMain, i2));
                eVarCreate2.b(viewInflate2);
                eVarCreate2.show();
                break;
            case 7:
                ig igVar2 = hamoTunnelPlusMain.i0;
                boolean zIsChecked = hamoTunnelPlusMain.M0.isChecked();
                igVar2.getClass();
                String strA3 = uh.a(-130078110547230L);
                hy0.a aVar = igVar2.b;
                aVar.putBoolean(strA3, zIsChecked);
                aVar.apply();
                hamoTunnelPlusMain.Q0();
                break;
            case 8:
                int i7 = HamoTunnelPlusMain.b1;
                hamoTunnelPlusMain.A0();
                break;
            case 9:
                HamoTunnelPlusMain.K(hamoTunnelPlusMain);
                break;
            default:
                HamoTunnelPlusMain.K(hamoTunnelPlusMain);
                break;
        }
    }
}
