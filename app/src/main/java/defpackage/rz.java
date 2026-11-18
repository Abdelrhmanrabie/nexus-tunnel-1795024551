package defpackage;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.appcompat.app.e;
import org.json.JSONObject;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class rz implements View.OnClickListener {
    public final /* synthetic */ EditText b;
    public final /* synthetic */ EditText c;
    public final /* synthetic */ EditText d;
    public final /* synthetic */ EditText f;
    public final /* synthetic */ EditText g;
    public final /* synthetic */ EditText i;
    public final /* synthetic */ EditText j;
    public final /* synthetic */ EditText n;
    public final /* synthetic */ RadioGroup o;
    public final /* synthetic */ e p;
    public final /* synthetic */ HamoTunnelPlusMain q;

    public rz(HamoTunnelPlusMain hamoTunnelPlusMain, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, EditText editText8, RadioGroup radioGroup, e eVar) {
        this.q = hamoTunnelPlusMain;
        this.b = editText;
        this.c = editText2;
        this.d = editText3;
        this.f = editText4;
        this.g = editText5;
        this.i = editText6;
        this.j = editText7;
        this.n = editText8;
        this.o = radioGroup;
        this.p = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:79:0x027e A[Catch: Exception -> 0x00cd, TryCatch #0 {Exception -> 0x00cd, blocks: (B:7:0x0060, B:9:0x00c3, B:13:0x00d1, B:77:0x027a, B:79:0x027e, B:24:0x012a, B:26:0x0130, B:82:0x02b1, B:27:0x013b, B:28:0x014b, B:30:0x0151, B:31:0x015c, B:32:0x01a5, B:34:0x01ad, B:36:0x01b3, B:38:0x01b9, B:41:0x01c0, B:42:0x01cf, B:43:0x01da, B:45:0x01e0, B:47:0x01e6, B:49:0x01ec, B:52:0x01f3, B:53:0x0202, B:54:0x020d, B:56:0x0213, B:57:0x021e, B:58:0x022b, B:60:0x0231, B:62:0x0237, B:64:0x023d, B:67:0x0244, B:68:0x0251, B:69:0x025b, B:71:0x0261, B:73:0x0267, B:76:0x026e, B:81:0x02a8), top: B:88:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String strA;
        String strA2;
        EditText editText;
        String string = this.b.getText().toString();
        String string2 = this.c.getText().toString();
        String string3 = this.d.getText().toString();
        String string4 = this.f.getText().toString();
        String string5 = this.g.getText().toString();
        String string6 = this.i.getText().toString();
        String string7 = this.j.getText().toString();
        String string8 = this.n.getText().toString();
        boolean zIsEmpty = string.isEmpty();
        HamoTunnelPlusMain hamoTunnelPlusMain = this.q;
        if (zIsEmpty || string2.isEmpty()) {
            strA = uh.a(-24443389902110L);
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(uh.a(-24589418790174L), mc1.d(string));
                jSONObject.put(uh.a(-24610893626654L), mc1.e(string3));
                jSONObject.put(uh.a(-24645253365022L), mc1.e(string4));
                String strA3 = uh.a(-24679613103390L);
                RadioGroup radioGroup = this.o;
                jSONObject.put(strA3, radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(uh.a(-24731152710942L), mc1.d(string5.isEmpty() ? uh.a(-24756922514718L) : string5));
                jSONObject2.put(uh.a(-24799872187678L), mc1.d(string6));
                jSONObject.put(uh.a(-24821347024158L), jSONObject2);
                jSONObject.put(uh.a(-24881476566302L), false);
                jSONObject.put(uh.a(-24920131271966L), mc1.d(string2));
                int iC = hamoTunnelPlusMain.i0.c();
                if (iC == 0) {
                    if (!string4.isEmpty() && !string5.isEmpty() && !string6.isEmpty()) {
                        jSONObject.put(uh.a(-25044685323550L), 2);
                        editText = hamoTunnelPlusMain.G0;
                        if (editText != null) {
                            editText.setText(uh.a(-26152786885918L).concat(mc1.d(jSONObject.toString())));
                            hamoTunnelPlusMain.H(uh.a(-26230096297246L));
                            this.p.dismiss();
                            return;
                        }
                        return;
                    }
                    strA2 = uh.a(-24941606108446L);
                    hamoTunnelPlusMain.H(strA2);
                    return;
                }
                if (iC == 1) {
                    if (!string3.isEmpty() && !string4.isEmpty() && !string5.isEmpty() && !string6.isEmpty()) {
                        jSONObject.put(uh.a(-25195009178910L), 5);
                        editText = hamoTunnelPlusMain.G0;
                        if (editText != null) {
                            editText.setText(uh.a(-26152786885918L).concat(mc1.d(jSONObject.toString())));
                            hamoTunnelPlusMain.H(uh.a(-26230096297246L));
                            this.p.dismiss();
                            return;
                        }
                        return;
                    }
                    strA2 = uh.a(-25091929963806L);
                    hamoTunnelPlusMain.H(strA2);
                    return;
                }
                if (iC == 2) {
                    if (string3.isEmpty()) {
                        strA2 = uh.a(-25242253819166L);
                        hamoTunnelPlusMain.H(strA2);
                        return;
                    }
                    jSONObject.put(uh.a(-25302383361310L), 3);
                    editText = hamoTunnelPlusMain.G0;
                    if (editText != null) {
                        editText.setText(uh.a(-26152786885918L).concat(mc1.d(jSONObject.toString())));
                        hamoTunnelPlusMain.H(uh.a(-26230096297246L));
                        this.p.dismiss();
                        return;
                    }
                    return;
                }
                if (iC == 3) {
                    if (hamoTunnelPlusMain.i0.t() == 0) {
                        if (!string4.isEmpty() && !string5.isEmpty() && !string6.isEmpty()) {
                            jSONObject.put(uh.a(-25452707216670L), 6);
                            editText = hamoTunnelPlusMain.G0;
                            if (editText != null) {
                                editText.setText(uh.a(-26152786885918L).concat(mc1.d(jSONObject.toString())));
                                hamoTunnelPlusMain.H(uh.a(-26230096297246L));
                                this.p.dismiss();
                                return;
                            }
                            return;
                        }
                        strA2 = uh.a(-25349628001566L);
                        hamoTunnelPlusMain.H(strA2);
                        return;
                    }
                    if (!string3.isEmpty() && !string4.isEmpty() && !string5.isEmpty() && !string6.isEmpty()) {
                        jSONObject.put(uh.a(-25603031072030L), 7);
                        editText = hamoTunnelPlusMain.G0;
                        if (editText != null) {
                            editText.setText(uh.a(-26152786885918L).concat(mc1.d(jSONObject.toString())));
                            hamoTunnelPlusMain.H(uh.a(-26230096297246L));
                            this.p.dismiss();
                            return;
                        }
                        return;
                    }
                    strA2 = uh.a(-25499951856926L);
                    hamoTunnelPlusMain.H(strA2);
                    return;
                }
                if (iC != 4) {
                    if (iC == 5) {
                        if (string7.isEmpty()) {
                            strA2 = uh.a(-25650275712286L);
                            hamoTunnelPlusMain.H(strA2);
                            return;
                        }
                        jSONObject.put(uh.a(-25731880090910L), 10);
                    }
                    editText = hamoTunnelPlusMain.G0;
                    if (editText != null) {
                        editText.setText(uh.a(-26152786885918L).concat(mc1.d(jSONObject.toString())));
                        hamoTunnelPlusMain.H(uh.a(-26230096297246L));
                        this.p.dismiss();
                        return;
                    }
                    return;
                }
                if (string8.isEmpty()) {
                    strA2 = uh.a(-25779124731166L);
                    hamoTunnelPlusMain.H(strA2);
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(uh.a(-25877908978974L), true);
                jSONObject3.put(uh.a(-25968103292190L), mc1.e(string8));
                jSONObject3.put(uh.a(-26045412703518L), 0);
                jSONObject.put(uh.a(-26079772441886L), jSONObject3);
                jSONObject.put(uh.a(-26105542245662L), 9);
                editText = hamoTunnelPlusMain.G0;
                if (editText != null) {
                    editText.setText(uh.a(-26152786885918L).concat(mc1.d(jSONObject.toString())));
                    hamoTunnelPlusMain.H(uh.a(-26230096297246L));
                    this.p.dismiss();
                    return;
                }
                return;
            } catch (Exception e) {
                strA = uh.a(-26315995643166L) + e.getMessage();
            }
        }
        hamoTunnelPlusMain.H(strA);
    }
}
