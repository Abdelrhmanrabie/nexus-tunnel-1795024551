package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import androidx.appcompat.app.e;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.d;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.hamotunnelplus.xyz.R;
import org.json.JSONArray;
import org.json.JSONObject;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class jz implements View.OnClickListener {
    public final /* synthetic */ int G0;
    public final Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements View.OnClickListener {
        public final /* synthetic */ int G0;
        public final View b;
        public final Object c;
        public Object d;
        public Object f;

        public a(View view, String str) {
            this.G0 = 2;
            this.b = view;
            this.c = str;
        }

        public /* synthetic */ a(jz jzVar, EditText editText, JSONObject jSONObject, e eVar, int i) {
            this.G0 = i;
            this.f = jzVar;
            this.b = editText;
            this.c = jSONObject;
            this.d = eVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean z;
            ig igVar;
            boolean z2;
            Method method;
            int i = this.G0;
            Object obj = this.c;
            View view2 = this.b;
            int i2 = 4;
            if (i == 0) {
                JSONObject jSONObject = (JSONObject) obj;
                String string = ((EditText) view2).getText().toString();
                boolean zIsEmpty = string.isEmpty();
                jz jzVar = (jz) this.f;
                HamoTunnelPlusMain hamoTunnelPlusMain = (HamoTunnelPlusMain) jzVar.c;
                if (zIsEmpty) {
                    hamoTunnelPlusMain.H(uh.a(-19371033525534L));
                    return;
                }
                try {
                    if (!string.equals(jSONObject.getString(uh.a(-19504177511710L)))) {
                        hamoTunnelPlusMain.H(uh.a(-19568602021150L));
                        return;
                    }
                    jSONObject.put(uh.a(-19731810778398L), uh.a(-19753285614878L));
                    JSONArray jSONArrayW = hamoTunnelPlusMain.w();
                    if (jSONArrayW.length() > 0) {
                        z = false;
                        for (int i3 = 0; i3 < jSONArrayW.length(); i3++) {
                            if (mc1.b(hamoTunnelPlusMain, jSONObject.getString(uh.a(-19791940320542L))).equalsIgnoreCase(mc1.b(hamoTunnelPlusMain, jSONArrayW.getJSONObject(i3).getString(uh.a(-19813415157022L))))) {
                                jSONArrayW.put(i3, jSONObject);
                                z = true;
                            }
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        jSONArrayW.put(jSONObject);
                    }
                    mc1.s(new File(hamoTunnelPlusMain.getFilesDir(), uh.a(-19834889993502L)), mc1.d(jSONArrayW.toString()));
                    hamoTunnelPlusMain.i0.M(mc1.b(hamoTunnelPlusMain, jSONObject.getString(uh.a(-19920789339422L))));
                    hamoTunnelPlusMain.i0();
                    hamoTunnelPlusMain.i0.N(hamoTunnelPlusMain.k0.indexOf(jSONObject));
                    int i4 = jSONObject.getInt(uh.a(-19942264175902L));
                    if (i4 == 8 || i4 == 10 || i4 == 9) {
                        if (i4 == 8) {
                            hamoTunnelPlusMain.k0(2);
                            igVar = hamoTunnelPlusMain.i0;
                            i2 = 2;
                        } else if (i4 == 10) {
                            hamoTunnelPlusMain.k0(4);
                            igVar = hamoTunnelPlusMain.i0;
                        } else {
                            hamoTunnelPlusMain.k0(3);
                            i2 = 3;
                            igVar = hamoTunnelPlusMain.i0;
                        }
                        igVar.b0(i2);
                    } else {
                        hamoTunnelPlusMain.k0(0);
                        hamoTunnelPlusMain.i0.b0(0);
                    }
                    hamoTunnelPlusMain.H(uh.a(-19989508816158L));
                    ((e) this.d).dismiss();
                    ((e) jzVar.b).dismiss();
                } catch (Exception e) {
                    hamoTunnelPlusMain.H(uh.a(-20058228292894L) + e.getMessage());
                }
            } else {
                if (i != 1) {
                    if (((Method) this.d) != null) {
                        break;
                    }
                    Context context = view2.getContext();
                    while (true) {
                        String str = (String) obj;
                        if (context == null) {
                            int id = view2.getId();
                            String str2 = id == -1 ? AppConfig.CUSTOM : " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                            StringBuilder sbQ = ak.q("Could not find method ", str, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                            sbQ.append(view2.getClass());
                            sbQ.append(str2);
                            throw new IllegalStateException(sbQ.toString());
                        }
                        try {
                            if (!context.isRestricted() && (method = context.getClass().getMethod(str, View.class)) != null) {
                                this.d = method;
                                this.f = context;
                                break;
                            }
                        } catch (NoSuchMethodException unused) {
                        }
                        context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                    }
                    try {
                        ((Method) this.d).invoke((Context) this.f, view);
                        return;
                    } catch (IllegalAccessException e2) {
                        throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
                    } catch (InvocationTargetException e3) {
                        throw new IllegalStateException("Could not execute method for android:onClick", e3);
                    }
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                String string2 = ((EditText) view2).getText().toString();
                boolean zIsEmpty2 = string2.isEmpty();
                jz jzVar2 = (jz) this.f;
                HamoTunnelPlusMain hamoTunnelPlusMain2 = (HamoTunnelPlusMain) jzVar2.c;
                if (zIsEmpty2) {
                    hamoTunnelPlusMain2.H(uh.a(-20148422606110L));
                    return;
                }
                try {
                    if (!string2.equals(jSONObject2.getString(uh.a(-20281566592286L)))) {
                        hamoTunnelPlusMain2.H(uh.a(-20345991101726L));
                        return;
                    }
                    jSONObject2.put(uh.a(-20509199858974L), uh.a(-20530674695454L));
                    JSONArray jSONArrayW2 = hamoTunnelPlusMain2.w();
                    if (jSONArrayW2.length() > 0) {
                        z2 = false;
                        for (int i5 = 0; i5 < jSONArrayW2.length(); i5++) {
                            if (mc1.b(hamoTunnelPlusMain2, jSONObject2.getString(uh.a(-20569329401118L))).equalsIgnoreCase(mc1.b(hamoTunnelPlusMain2, jSONArrayW2.getJSONObject(i5).getString(uh.a(-20590804237598L))))) {
                                jSONArrayW2.put(i5, jSONObject2);
                                z2 = true;
                            }
                        }
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        jSONArrayW2.put(jSONObject2);
                    }
                    mc1.s(new File(hamoTunnelPlusMain2.getFilesDir(), uh.a(-20612279074078L)), mc1.d(jSONArrayW2.toString()));
                    hamoTunnelPlusMain2.i0.M(mc1.b(hamoTunnelPlusMain2, jSONObject2.getString(uh.a(-20698178419998L))));
                    hamoTunnelPlusMain2.i0();
                    hamoTunnelPlusMain2.i0.N(hamoTunnelPlusMain2.k0.indexOf(jSONObject2));
                    int i6 = jSONObject2.getInt(uh.a(-20719653256478L));
                    if (i6 != 8 && i6 != 10 && i6 != 9) {
                        hamoTunnelPlusMain2.k0(0);
                    } else if (i6 == 8) {
                        hamoTunnelPlusMain2.k0(2);
                    } else if (i6 == 10) {
                        hamoTunnelPlusMain2.k0(4);
                    } else {
                        hamoTunnelPlusMain2.k0(3);
                    }
                    hamoTunnelPlusMain2.i0();
                    hamoTunnelPlusMain2.H(uh.a(-20766897896734L));
                    ((e) this.d).dismiss();
                    ((e) jzVar2.b).dismiss();
                } catch (Exception e4) {
                    hamoTunnelPlusMain2.H(uh.a(-20835617373470L) + e4.getMessage());
                }
            }
        }
    }

    public jz(d dVar) {
        this.G0 = 1;
        this.c = dVar;
        this.b = new x1(dVar.a.getContext(), dVar.i);
    }

    public /* synthetic */ jz(HamoTunnelPlusMain hamoTunnelPlusMain, KeyEvent.Callback callback, int i) {
        this.G0 = i;
        this.c = hamoTunnelPlusMain;
        this.b = callback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String strA;
        boolean z;
        e eVarCreate;
        View viewFindViewById;
        a aVar;
        String strA2;
        boolean z2;
        int i = this.G0;
        if (i != 0) {
            if (i == 1) {
                d dVar = (d) this.c;
                Window.Callback callback = dVar.l;
                if (callback == null || !dVar.m) {
                    return;
                }
                callback.onMenuItemSelected(0, (x1) this.b);
                return;
            }
            if (i == 2) {
                HamoTunnelPlusMain hamoTunnelPlusMain = (HamoTunnelPlusMain) this.c;
                qz qzVar = new qz(12, false);
                qzVar.a = new zx$a() { // from class: pz$a
                    @Override // defpackage.zx$a
                    public final void h(String str) {
                        ((EditText) this.b.b).setText(str);
                    }

                    @Override // defpackage.zx$a
                    public final void onCancel() {
                    }
                };
                av0 av0Var = new av0(hamoTunnelPlusMain);
                av0Var.g = qzVar;
                av0Var.d.show();
                return;
            }
            boolean zIsChecked = ((SwitchCompat) this.b).isChecked();
            HamoTunnelPlusMain hamoTunnelPlusMain2 = (HamoTunnelPlusMain) this.c;
            hamoTunnelPlusMain2.F0.getClass();
            if (zIsChecked) {
                e5.x(2);
            } else {
                e5.x(1);
            }
            hamoTunnelPlusMain2.C0.c(false);
            return;
        }
        HamoTunnelPlusMain hamoTunnelPlusMain3 = (HamoTunnelPlusMain) this.c;
        String strTrim = hamoTunnelPlusMain3.G0.getText().toString().trim();
        if (strTrim.isEmpty()) {
            hamoTunnelPlusMain3.H(uh.a(-20925811686686L));
            return;
        }
        boolean zStartsWith = strTrim.startsWith(uh.a(-21050365738270L));
        e eVar = (e) this.b;
        if (zStartsWith) {
            try {
                JSONObject jSONObject = new JSONObject(mc1.b(hamoTunnelPlusMain3, strTrim.replace(uh.a(-21127675149598L), uh.a(-21204984560926L))));
                if (jSONObject.has(uh.a(-21209279528222L)) && jSONObject.getBoolean(uh.a(-21260819135774L))) {
                    if (e.j(jSONObject.getString(uh.a(-21312358743326L)))) {
                        strA2 = uh.a(-21342423514398L);
                    } else if (jSONObject.has(uh.a(-21497042337054L)) && jSONObject.getBoolean(uh.a(-21552876911902L))) {
                        View viewInflate = hamoTunnelPlusMain3.getLayoutInflater().inflate(R.layout.bu, (ViewGroup) null);
                        EditText editText = (EditText) viewInflate.findViewById(R.attr.jk);
                        eVarCreate = new e.a(hamoTunnelPlusMain3).create();
                        eVarCreate.setTitle(uh.a(-21608711486750L));
                        eVarCreate.b(viewInflate);
                        viewFindViewById = viewInflate.findViewById(R.attr.si);
                        aVar = new a(this, editText, jSONObject, eVarCreate, 0);
                    } else {
                        try {
                            jSONObject.put(uh.a(-21681725930782L), uh.a(-21703200767262L));
                            JSONArray jSONArrayW = hamoTunnelPlusMain3.w();
                            if (jSONArrayW.length() > 0) {
                                z2 = false;
                                for (int i2 = 0; i2 < jSONArrayW.length(); i2++) {
                                    if (mc1.b(hamoTunnelPlusMain3, jSONObject.getString(uh.a(-21741855472926L))).equalsIgnoreCase(mc1.b(hamoTunnelPlusMain3, jSONArrayW.getJSONObject(i2).getString(uh.a(-21763330309406L))))) {
                                        jSONArrayW.put(i2, jSONObject);
                                        z2 = true;
                                    }
                                }
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                jSONArrayW.put(jSONObject);
                            }
                            mc1.s(new File(hamoTunnelPlusMain3.getFilesDir(), uh.a(-21784805145886L)), mc1.d(jSONArrayW.toString()));
                            hamoTunnelPlusMain3.i0.M(mc1.b(hamoTunnelPlusMain3, jSONObject.getString(uh.a(-21870704491806L))));
                            hamoTunnelPlusMain3.i0();
                            hamoTunnelPlusMain3.i0.N(hamoTunnelPlusMain3.k0.indexOf(jSONObject));
                            int i3 = jSONObject.getInt(uh.a(-21892179328286L));
                            if (i3 != 8 && i3 != 10 && i3 != 9) {
                                hamoTunnelPlusMain3.k0(0);
                            } else if (i3 == 8) {
                                hamoTunnelPlusMain3.k0(2);
                            } else if (i3 == 10) {
                                hamoTunnelPlusMain3.k0(4);
                            } else {
                                hamoTunnelPlusMain3.k0(3);
                            }
                            hamoTunnelPlusMain3.H(uh.a(-21939423968542L));
                            eVar.dismiss();
                            return;
                        } catch (Exception e) {
                            strA2 = uh.a(-22008143445278L) + e.getMessage();
                        }
                    }
                    hamoTunnelPlusMain3.H(strA2);
                    return;
                }
                if (!jSONObject.has(uh.a(-22098337758494L)) || !jSONObject.getBoolean(uh.a(-22154172333342L))) {
                    jSONObject.put(uh.a(-22283021352222L), uh.a(-22304496188702L));
                    JSONArray jSONArrayW2 = hamoTunnelPlusMain3.w();
                    if (jSONArrayW2.length() > 0) {
                        z = false;
                        for (int i4 = 0; i4 < jSONArrayW2.length(); i4++) {
                            if (mc1.b(hamoTunnelPlusMain3, jSONObject.getString(uh.a(-22343150894366L))).equalsIgnoreCase(mc1.b(hamoTunnelPlusMain3, jSONArrayW2.getJSONObject(i4).getString(uh.a(-22364625730846L))))) {
                                jSONArrayW2.put(i4, jSONObject);
                                z = true;
                            }
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        jSONArrayW2.put(jSONObject);
                    }
                    mc1.s(new File(hamoTunnelPlusMain3.getFilesDir(), uh.a(-22386100567326L)), mc1.d(jSONArrayW2.toString()));
                    hamoTunnelPlusMain3.i0.M(mc1.b(hamoTunnelPlusMain3, jSONObject.getString(uh.a(-22471999913246L))));
                    hamoTunnelPlusMain3.i0();
                    hamoTunnelPlusMain3.i0.N(hamoTunnelPlusMain3.k0.indexOf(jSONObject));
                    int i5 = jSONObject.getInt(uh.a(-22493474749726L));
                    if (i5 != 8 && i5 != 10 && i5 != 9) {
                        hamoTunnelPlusMain3.k0(0);
                    } else if (i5 == 8) {
                        hamoTunnelPlusMain3.k0(2);
                    } else if (i5 == 10) {
                        hamoTunnelPlusMain3.k0(4);
                    } else {
                        hamoTunnelPlusMain3.k0(3);
                    }
                    hamoTunnelPlusMain3.i0();
                    hamoTunnelPlusMain3.H(uh.a(-22540719389982L));
                    eVar.dismiss();
                }
                View viewInflate2 = hamoTunnelPlusMain3.getLayoutInflater().inflate(R.layout.bu, (ViewGroup) null);
                EditText editText2 = (EditText) viewInflate2.findViewById(R.attr.jk);
                eVarCreate = new e.a(hamoTunnelPlusMain3).create();
                eVarCreate.setTitle(uh.a(-22210006908190L));
                eVarCreate.b(viewInflate2);
                viewFindViewById = viewInflate2.findViewById(R.attr.si);
                aVar = new a(this, editText2, jSONObject, eVarCreate, 1);
                viewFindViewById.setOnClickListener(aVar);
                eVarCreate.show();
                return;
            } catch (Exception e2) {
                strA = uh.a(-22609438866718L) + e2.getMessage();
                hamoTunnelPlusMain3.H(strA);
            }
        } else {
            strA = uh.a(-22669568408862L);
        }
        hamoTunnelPlusMain3.H(strA);
        eVar.dismiss();
    }
}
