package renz.javacodez.vpn.activities;

import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.ClipboardManager;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.CacheDispatcher;
import com.android.volley.NetworkDispatcher;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.erlite.themelite.ThemeLite;
import com.github.guilhe.views.CircularProgressView;
import com.github.guilhe.views.CircularProgressView$getAnimator$1$1;
import com.github.guilhe.views.CircularProgressView$setProgress$2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.jakewharton.processphoenix.ProcessPhoenix;
import com.tencent.mmkv.MMKV;
import defpackage.av0;
import defpackage.bj;
import defpackage.c3;
import defpackage.df;
import defpackage.e3;
import defpackage.f00;
import defpackage.g;
import defpackage.g00;
import defpackage.gf1;
import defpackage.hg;
import defpackage.hy0;
import defpackage.ig;
import defpackage.jk;
import defpackage.kk0;
import defpackage.lg;
import defpackage.m70;
import defpackage.mc1;
import defpackage.qz;
import defpackage.rc;
import defpackage.uh;
import defpackage.w4;
import defpackage.w61;
import defpackage.z21$a;
import defpackage.zx$a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import net.lingala.zip4j.ZipFile;
import net.openvpn.ovpn3.ClientAPI_ConnectionInfo;
import net.openvpn.ovpn3.PasswordUtil;
import net.openvpn.ovpn3.PrefUtil;
import net.openvpn.ovpn3.ProxyList;
import net.openvpn.ovpn3.SpinUtil;
import org.hamotunnelplus.xyz.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import renz.javacodez.v2ray.ui.LogcatActivity;
import renz.javacodez.v2ray.util.Utils;
import renz.javacodez.v2ray.viewmodel.MainViewModel;
import renz.javacodez.vpn.service.RenzInjectorService;
import renz.javacodez.vpn.service.RenzOpenVPNservice;
import renz.javacodez.vpn.service.SSHVPNService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class HamoTunnelPlusMain extends renz.javacodez.vpn.activities.d implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemSelectedListener, TextView.OnEditorActionListener, RadioGroup.OnCheckedChangeListener, BottomNavigationView.OnNavigationItemSelectedListener, zx$a {
    public static final /* synthetic */ int b1 = 0;
    public boolean A;
    public jk A0;
    public TextView B;
    public Toolbar B0;
    public ScrollView C;
    public DrawerLayout C0;
    public EditText D;
    public NavigationView D0;
    public View E;
    public TextView E0;
    public CheckBox F;
    public ThemeLite F0;
    public EditText G;
    public EditText G0;
    public View H;
    public TextView H0;
    public CheckBox I;
    public View I0;
    public View J;
    public hy0 J0;
    public PrefUtil K;
    public hy0.a K0;
    public ImageButton L;
    public TextView L0;
    public View M;
    public SwitchCompat M0;
    public Spinner N;
    public View N0;
    public ProgressBar O;
    public ImageButton P;
    public View Q;
    public Spinner R;
    public PasswordUtil S;
    public boolean S0;
    public EditText T;
    public Button T0;
    public View U;
    public volatile boolean U0;
    public Spinner V;
    public View V0;
    public int W;
    public long W0;
    public View X;
    public MainViewModel X0;
    public View Y;
    public TextView Y0;
    public final Handler Z;
    public View Z0;
    public final a a0;
    public final AtomicBoolean a1;
    public ImageView b0;
    public TextView c0;
    public View[] d0;
    public final Handler e0;
    public final b f0;
    public EditText g0;
    public View h0;
    public ig i0;
    public String j;
    public boolean j0;
    public ArrayList<JSONObject> k0;
    public e3 l0;
    public ArrayList<JSONObject> m0;
    public View n;
    public z21$a n0;
    public TextView o;
    public View o0;
    public TextView p;
    public View p0;
    public TextView q;
    public View r;
    public View s;
    public w61 s0;
    public View t;
    public w t0;
    public View u;
    public Timer u0;
    public v v;
    public TextView w;
    public TextView x;
    public v y;
    public View z;
    public c3 z0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = HamoTunnelPlusMain.b1;
            HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
            hamoTunnelPlusMain.G0();
            Handler handler = hamoTunnelPlusMain.Z;
            a aVar = hamoTunnelPlusMain.a0;
            handler.removeCallbacks(aVar);
            handler.postDelayed(aVar, 1000L);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
            if (hamoTunnelPlusMain.z()) {
                return;
            }
            hamoTunnelPlusMain.P0(65536, null, false);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ View b;

        public c(View view) {
            this.b = view;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.b.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ RadioGroup b;

        public d(RadioGroup radioGroup) {
            this.b = radioGroup;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.b.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class e implements View.OnClickListener {
        public final /* synthetic */ EditText b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CheckBox d;
        public final /* synthetic */ RadioGroup f;
        public final /* synthetic */ CheckBox g;
        public final /* synthetic */ CheckBox i;
        public final /* synthetic */ androidx.appcompat.app.e j;

        public e(EditText editText, String str, CheckBox checkBox, RadioGroup radioGroup, CheckBox checkBox2, CheckBox checkBox3, androidx.appcompat.app.e eVar) {
            this.b = editText;
            this.c = str;
            this.d = checkBox;
            this.f = radioGroup;
            this.g = checkBox2;
            this.i = checkBox3;
            this.j = eVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i;
            CheckBox checkBox = this.g;
            CheckBox checkBox2 = this.d;
            String string = this.b.getText().toString();
            String strA = uh.a(-26414779890974L);
            String str = this.c;
            if (str.startsWith(strA)) {
                String strReplace = str.replace(uh.a(-26492089302302L), uh.a(-26569398713630L));
                HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
                try {
                    JSONObject jSONObject = new JSONObject(mc1.b(hamoTunnelPlusMain, strReplace));
                    jSONObject.put(uh.a(-26573693680926L), checkBox2.isChecked());
                    if (checkBox2.isChecked()) {
                        RadioGroup radioGroup = this.f;
                        int iIndexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
                        String strA2 = uh.a(-26625233288478L);
                        Calendar calendar = Calendar.getInstance();
                        if (iIndexOfChild != 0) {
                            if (iIndexOfChild == 1) {
                                i = 30;
                            } else if (iIndexOfChild == 2) {
                                i = 60;
                            } else if (iIndexOfChild == 3) {
                                i = 90;
                            } else if (iIndexOfChild == 4) {
                                calendar.add(2, 6);
                            } else {
                                if (iIndexOfChild != 5) {
                                    throw new IllegalArgumentException(uh.a(-140368852188446L));
                                }
                                calendar.add(1, 1);
                            }
                            calendar.add(6, i);
                        } else {
                            calendar.add(10, 1);
                        }
                        jSONObject.put(strA2, new SimpleDateFormat(uh.a(-140433276697886L)).format(calendar.getTime()));
                    }
                    if (checkBox.isChecked() && string.isEmpty()) {
                        hamoTunnelPlusMain.H(uh.a(-26655298059550L));
                        return;
                    }
                    jSONObject.put(uh.a(-26766967209246L), checkBox.isChecked());
                    jSONObject.put(uh.a(-26822801784094L), string);
                    jSONObject.put(uh.a(-26887226293534L), this.i.isChecked());
                    ((ClipboardManager) hamoTunnelPlusMain.getSystemService(uh.a(-26908701130014L))).setText(uh.a(-26951650802974L).concat(mc1.d(jSONObject.toString())));
                    hamoTunnelPlusMain.H(uh.a(-27028960214302L));
                    this.j.dismiss();
                } catch (Exception e) {
                    hamoTunnelPlusMain.H(uh.a(-27119154527518L) + e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class h implements AdapterView.OnItemSelectedListener {
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;
        public final /* synthetic */ RadioGroup d;
        public final /* synthetic */ View f;
        public final /* synthetic */ View g;
        public final /* synthetic */ View i;
        public final /* synthetic */ View j;
        public final /* synthetic */ EditText n;

        public h(View view, View view2, RadioGroup radioGroup, View view3, View view4, View view5, View view6, EditText editText) {
            this.b = view;
            this.c = view2;
            this.d = radioGroup;
            this.f = view3;
            this.g = view4;
            this.i = view5;
            this.j = view6;
            this.n = editText;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            long j2;
            HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
            ig igVar = hamoTunnelPlusMain.i0;
            igVar.getClass();
            String strA = uh.a(-129996506168606L);
            hy0.a aVar = igVar.b;
            aVar.putInt(strA, i);
            aVar.apply();
            View view2 = this.b;
            view2.setVisibility(0);
            View view3 = this.c;
            RadioGroup radioGroup = this.d;
            View view4 = this.f;
            View view5 = this.g;
            HamoTunnelPlusMain.c0(view3, radioGroup, view4, view5);
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
                    j2 = -30812826402078L;
                } else {
                    HamoTunnelPlusMain.C0(radioGroup, view3, view7, view6);
                    j2 = -31306747641118L;
                }
                this.n.setText(uh.a(j2));
                return;
            }
            if (i == 4) {
                HamoTunnelPlusMain.c0(view2, view5);
                HamoTunnelPlusMain.C0(view4);
            } else {
                if (i != 5) {
                    return;
                }
                HamoTunnelPlusMain.c0(view2, view4);
                HamoTunnelPlusMain.C0(view5);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class i implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ RadioGroup b;
        public final /* synthetic */ View c;
        public final /* synthetic */ View d;
        public final /* synthetic */ View f;

        public i(RadioGroup radioGroup, View view, View view2, View view3) {
            this.b = radioGroup;
            this.c = view;
            this.d = view2;
            this.f = view3;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            int iIndexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
            ig igVar = HamoTunnelPlusMain.this.i0;
            igVar.getClass();
            String strA = uh.a(-131284996357406L);
            hy0.a aVar = igVar.b;
            aVar.putInt(strA, iIndexOfChild);
            aVar.apply();
            View view = this.d;
            View view2 = this.c;
            View view3 = this.f;
            RadioGroup radioGroup2 = this.b;
            if (iIndexOfChild != 0) {
                HamoTunnelPlusMain.C0(radioGroup2, view3, view2, view);
            } else {
                HamoTunnelPlusMain.C0(radioGroup2, view2, view);
                HamoTunnelPlusMain.c0(view3);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class j implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ EditText b;

        public j(EditText editText) {
            this.b = editText;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            boolean z2;
            ig igVar = HamoTunnelPlusMain.this.i0;
            igVar.getClass();
            String strA = uh.a(-131044478188830L);
            hy0.a aVar = igVar.b;
            aVar.putBoolean(strA, z);
            aVar.apply();
            EditText editText = this.b;
            if (z) {
                editText.setText(uh.a(-31749129272606L));
                z2 = false;
            } else {
                editText.setText(uh.a(-31792078945566L));
                z2 = true;
            }
            editText.setEnabled(z2);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class k implements View.OnClickListener {
        public final /* synthetic */ EditText b;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements zx$a {
            public a() {
            }

            @Override // defpackage.zx$a
            public final void h(String str) {
                k.this.b.setText(str);
            }

            @Override // defpackage.zx$a
            public final void onCancel() {
            }
        }

        public k(EditText editText) {
            this.b = editText;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
            qz qzVar = new qz(12, false);
            qzVar.a = new a();
            av0 av0Var = new av0(hamoTunnelPlusMain);
            av0Var.g = qzVar;
            av0Var.d.show();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class l implements kk0.a {
        public final /* synthetic */ EditText a;

        public l(EditText editText) {
            this.a = editText;
        }

        @Override // kk0.a
        public final void a(String str) {
            EditText editText = this.a;
            editText.setText(str);
            editText.setEnabled(true);
            editText.setHint(uh.a(-31796373912862L));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class m implements View.OnClickListener {
        public final /* synthetic */ EditText b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ EditText g;
        public final /* synthetic */ RadioGroup i;
        public final /* synthetic */ CheckBox j;
        public final /* synthetic */ EditText n;
        public final /* synthetic */ androidx.appcompat.app.e o;

        public m(EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, RadioGroup radioGroup, CheckBox checkBox, EditText editText6, androidx.appcompat.app.e eVar) {
            this.b = editText;
            this.c = editText2;
            this.d = editText3;
            this.f = editText4;
            this.g = editText5;
            this.i = radioGroup;
            this.j = checkBox;
            this.n = editText6;
            this.o = eVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            long j;
            long j2;
            hy0.a aVar;
            String string = this.b.getText().toString();
            String string2 = this.c.getText().toString();
            String string3 = this.d.getText().toString();
            String string4 = this.f.getText().toString();
            String string5 = this.g.getText().toString();
            RadioGroup radioGroup = this.i;
            int iIndexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
            boolean zIsChecked = this.j.isChecked();
            String string6 = this.n.getText().toString();
            HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
            int iC = hamoTunnelPlusMain.i0.c();
            androidx.appcompat.app.e eVar = this.o;
            if (iC != 0) {
                j = -130623571393822L;
                if (iC != 1) {
                    if (iC != 2) {
                        if (iC == 3) {
                            if (hamoTunnelPlusMain.i0.t() == 0) {
                                if (string2.isEmpty() || string3.isEmpty() || string4.isEmpty()) {
                                    j2 = -32066956852510L;
                                }
                                ig igVar = hamoTunnelPlusMain.i0;
                                igVar.getClass();
                                String strA = uh.a(-130460362636574L);
                                hy0.a aVar2 = igVar.b;
                                aVar2.putString(strA, string2);
                                aVar2.apply();
                                igVar.K(string2);
                                ig igVar2 = hamoTunnelPlusMain.i0;
                                igVar2.getClass();
                                String strA2 = uh.a(-130756715379998L);
                                hy0.a aVar3 = igVar2.b;
                                aVar3.putString(strA2, string3);
                                aVar3.apply();
                                igVar2.P(string3);
                                ig igVar3 = hamoTunnelPlusMain.i0;
                                igVar3.Q(string4);
                                String strA3 = uh.a(-130894154333470L);
                                hy0.a aVar4 = igVar3.b;
                                aVar4.putString(strA3, string4);
                                aVar4.apply();
                                ig igVar4 = hamoTunnelPlusMain.i0;
                                igVar4.J(true);
                                String strA4 = uh.a(-130623571393822L);
                                aVar = igVar4.b;
                                aVar.putBoolean(strA4, true);
                            } else if (string.isEmpty() || string2.isEmpty() || string3.isEmpty() || string4.isEmpty()) {
                                j2 = -32170036067614L;
                            } else {
                                hamoTunnelPlusMain.i0.G(string);
                                ig igVar5 = hamoTunnelPlusMain.i0;
                                igVar5.getClass();
                                String strA5 = uh.a(-130460362636574L);
                                hy0.a aVar5 = igVar5.b;
                                aVar5.putString(strA5, string2);
                                aVar5.apply();
                                igVar5.K(string2);
                                ig igVar6 = hamoTunnelPlusMain.i0;
                                igVar6.getClass();
                                String strA6 = uh.a(-130756715379998L);
                                hy0.a aVar6 = igVar6.b;
                                aVar6.putString(strA6, string3);
                                aVar6.apply();
                                igVar6.P(string3);
                                ig igVar7 = hamoTunnelPlusMain.i0;
                                igVar7.Q(string4);
                                String strA7 = uh.a(-130894154333470L);
                                hy0.a aVar7 = igVar7.b;
                                aVar7.putString(strA7, string4);
                                aVar7.apply();
                                ig igVar8 = hamoTunnelPlusMain.i0;
                                igVar8.J(true);
                                String strA8 = uh.a(-130623571393822L);
                                aVar = igVar8.b;
                                aVar.putBoolean(strA8, true);
                            }
                            aVar.apply();
                            eVar.dismiss();
                            hamoTunnelPlusMain.k0(0);
                        }
                        if (iC != 4) {
                            if (iC != 5) {
                                return;
                            }
                            if (!string6.isEmpty()) {
                                ig igVar9 = hamoTunnelPlusMain.i0;
                                igVar9.getClass();
                                hy0.a aVar8 = igVar9.b;
                                aVar8.putString(uh.a(-132534831840542L), string6);
                                aVar8.apply();
                                aVar8.putString(uh.a(-132912788962590L), string6);
                                aVar8.apply();
                                hamoTunnelPlusMain.i0.J(false);
                                hamoTunnelPlusMain.i0.W(10);
                                hamoTunnelPlusMain.k0(4);
                                eVar.dismiss();
                                return;
                            }
                            j2 = -32350424694046L;
                        } else {
                            if (!string5.isEmpty()) {
                                hy0.a aVar9 = hamoTunnelPlusMain.i0.b;
                                aVar9.putInt(uh.a(-132092450209054L), iIndexOfChild);
                                aVar9.apply();
                                hy0.a aVar10 = hamoTunnelPlusMain.i0.b;
                                aVar10.putString(uh.a(-132212709293342L), string5);
                                aVar10.apply();
                                hy0.a aVar11 = hamoTunnelPlusMain.i0.b;
                                aVar11.putBoolean(uh.a(-132345853279518L), zIsChecked);
                                aVar11.apply();
                                hamoTunnelPlusMain.k0(3);
                                eVar.dismiss();
                                return;
                            }
                            j2 = -32273115282718L;
                        }
                    } else if (string.isEmpty()) {
                        j2 = -32006827310366L;
                    } else {
                        hamoTunnelPlusMain.i0.G(string);
                    }
                } else if (string.isEmpty() || string2.isEmpty() || string3.isEmpty() || string4.isEmpty()) {
                    j2 = -31903748095262L;
                } else {
                    hamoTunnelPlusMain.i0.G(string);
                    ig igVar10 = hamoTunnelPlusMain.i0;
                    igVar10.getClass();
                    String strA9 = uh.a(-130460362636574L);
                    hy0.a aVar12 = igVar10.b;
                    aVar12.putString(strA9, string2);
                    aVar12.apply();
                    igVar10.K(string2);
                    ig igVar11 = hamoTunnelPlusMain.i0;
                    igVar11.getClass();
                    String strA10 = uh.a(-130756715379998L);
                    hy0.a aVar13 = igVar11.b;
                    aVar13.putString(strA10, string3);
                    aVar13.apply();
                    igVar11.P(string3);
                    ig igVar12 = hamoTunnelPlusMain.i0;
                    igVar12.Q(string4);
                    String strA11 = uh.a(-130894154333470L);
                    hy0.a aVar14 = igVar12.b;
                    aVar14.putString(strA11, string4);
                    aVar14.apply();
                }
                hamoTunnelPlusMain.H(uh.a(j2));
                return;
            }
            j = -130623571393822L;
            if (string2.isEmpty() || string3.isEmpty() || string4.isEmpty()) {
                j2 = -31800668880158L;
                hamoTunnelPlusMain.H(uh.a(j2));
                return;
            }
            ig igVar13 = hamoTunnelPlusMain.i0;
            igVar13.getClass();
            String strA12 = uh.a(-130460362636574L);
            hy0.a aVar15 = igVar13.b;
            aVar15.putString(strA12, string2);
            aVar15.apply();
            igVar13.K(string2);
            ig igVar14 = hamoTunnelPlusMain.i0;
            igVar14.getClass();
            String strA13 = uh.a(-130756715379998L);
            hy0.a aVar16 = igVar14.b;
            aVar16.putString(strA13, string3);
            aVar16.apply();
            igVar14.P(string3);
            ig igVar15 = hamoTunnelPlusMain.i0;
            igVar15.Q(string4);
            String strA14 = uh.a(-130894154333470L);
            hy0.a aVar17 = igVar15.b;
            aVar17.putString(strA14, string4);
            aVar17.apply();
            ig igVar16 = hamoTunnelPlusMain.i0;
            igVar16.J(false);
            String strA15 = uh.a(j);
            aVar = igVar16.b;
            aVar.putBoolean(strA15, false);
            aVar.apply();
            eVar.dismiss();
            hamoTunnelPlusMain.k0(0);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class n implements DialogInterface.OnCancelListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
            hamoTunnelPlusMain.M0.setChecked(false);
            ig igVar = hamoTunnelPlusMain.i0;
            igVar.getClass();
            String strA = uh.a(-130078110547230L);
            hy0.a aVar = igVar.b;
            aVar.putBoolean(strA, false);
            aVar.apply();
            hamoTunnelPlusMain.Q0();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class p implements Response.Listener {
        public p() {
        }

        @Override // com.android.volley.Response.Listener
        public final void onResponse(Object obj) {
            boolean zMatches;
            String str = (String) obj;
            HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
            if (str.isEmpty()) {
                return;
            }
            String strTrim = str.trim();
            int i = mc1.$r8$clinit;
            if (!strTrim.isEmpty() && strTrim.length() >= 16) {
                try {
                    zMatches = Pattern.compile(uh.a(-156500749352222L)).matcher(strTrim).matches();
                } catch (IllegalArgumentException unused) {
                    zMatches = false;
                }
            } else {
                zMatches = false;
            }
            if (zMatches) {
                try {
                    String string = hamoTunnelPlusMain.x().getString(uh.a(-35073433959710L));
                    if (m70.a(new JSONObject(mc1.b(hamoTunnelPlusMain, strTrim)).getString(uh.a(-35107793698078L)), string)) {
                        try {
                            HamoTunnelPlusMain.P(hamoTunnelPlusMain, strTrim);
                        } catch (Exception unused2) {
                            hamoTunnelPlusMain.H(uh.a(-35142153436446L));
                        }
                    } else {
                        hamoTunnelPlusMain.m0(string);
                    }
                } catch (Exception unused3) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class q implements Response.ErrorListener {
        @Override // com.android.volley.Response.ErrorListener
        public final void onErrorResponse(VolleyError volleyError) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class r implements Runnable {
        public final /* synthetic */ w4 b;

        public r(w4 w4Var) {
            this.b = w4Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
            v vVar = hamoTunnelPlusMain.v;
            if (vVar != v.f && vVar != v.b) {
                this.b.finish();
            }
            hamoTunnelPlusMain.v = v.b;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
            if (hamoTunnelPlusMain.y != v.b) {
                hamoTunnelPlusMain.finish();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class t extends TimerTask {

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Runnable {
            public a() {
            }

            /* JADX WARN: Code duplicated, block: B:12:0x0055  */
            @Override // java.lang.Runnable
            public final void run() {
                String strA;
                StringBuilder sbD;
                long j;
                HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
                TextView textView = hamoTunnelPlusMain.E0;
                String strConcat = mc1.h().concat(uh.a(-49508819041566L));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) hamoTunnelPlusMain.getSystemService(uh.a(-49517408976158L))).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    strA = uh.a(-49624783158558L);
                } else {
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        sbD = defpackage.e.d(strConcat);
                        j = -49573243551006L;
                    } else if (type != 1) {
                        strA = uh.a(-49624783158558L);
                    } else {
                        sbD = defpackage.e.d(strConcat);
                        j = -49603308322078L;
                    }
                    sbD.append(uh.a(j));
                    strA = sbD.toString();
                }
                textView.setText(strA);
            }
        }

        public t() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            HamoTunnelPlusMain.this.runOnUiThread(new a());
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class u {
        public u() {
        }

        public final void a(String str) {
            String string;
            int i;
            ProxyList proxyListY;
            int i2 = HamoTunnelPlusMain.b1;
            HamoTunnelPlusMain hamoTunnelPlusMain = HamoTunnelPlusMain.this;
            hamoTunnelPlusMain.getClass();
            String strA = uh.a(-60954906885406L);
            String strR = hamoTunnelPlusMain.i0.r();
            String strJ = hamoTunnelPlusMain.i0.j();
            String strT0 = hamoTunnelPlusMain.t0();
            String str2 = (hamoTunnelPlusMain.Q.getVisibility() != 0 || (proxyListY = hamoTunnelPlusMain.y()) == null) ? null : proxyListY.get_enabled(false);
            hamoTunnelPlusMain.U.getVisibility();
            if (hamoTunnelPlusMain.H.getVisibility() == 0) {
                string = hamoTunnelPlusMain.G.getText().toString();
                boolean zIsChecked = hamoTunnelPlusMain.I.isChecked();
                hamoTunnelPlusMain.K.set_boolean_by_profile(strT0, uh.a(-61075165969694L), zIsChecked);
                PasswordUtil passwordUtil = hamoTunnelPlusMain.S;
                if (zIsChecked) {
                    passwordUtil.set(uh.a(-61148180413726L), strT0, string);
                } else {
                    passwordUtil.remove(uh.a(-61161065315614L), strT0);
                }
            } else {
                string = null;
            }
            String string2 = hamoTunnelPlusMain.u.getVisibility() == 0 ? hamoTunnelPlusMain.T.getText().toString() : null;
            hamoTunnelPlusMain.S();
            String str3 = hamoTunnelPlusMain.K.get_string(uh.a(-61173950217502L));
            String str4 = hamoTunnelPlusMain.K.get_string(uh.a(-61216899890462L));
            String strA2 = uh.a(-61238374726942L);
            String str5 = hamoTunnelPlusMain.K.get_string(uh.a(-61255554596126L));
            hamoTunnelPlusMain.T();
            String strA3 = uh.a(-4446022171934L);
            try {
                PackageInfo packageInfo = hamoTunnelPlusMain.getPackageManager().getPackageInfo(hamoTunnelPlusMain.getPackageName(), 0);
                strA3 = packageInfo.versionName;
                i = packageInfo.versionCode;
            } catch (Exception unused) {
                uh.a(-4463202041118L);
                uh.a(-4540511452446L);
                i = 0;
            }
            String str6 = String.format(uh.a(-4656475569438L), strA, strA3, Integer.valueOf(i));
            String strA4 = uh.a(-4695130275102L);
            Intent intentPutExtra = new Intent(hamoTunnelPlusMain, (Class<?>) RenzOpenVPNservice.class).setAction(uh.a(-4781029621022L)).putExtra(strA4.concat(uh.a(-4901288705310L)), strT0).putExtra(strA4.concat(uh.a(-4939943410974L)), str6).putExtra(strA4.concat(uh.a(-4995777985822L)), str2).putExtra(strA4.concat(uh.a(-5047317593374L)), (String) null).putExtra(strA4.concat(uh.a(-5116037070110L)), (String) null).putExtra(strA4.concat(uh.a(-5184756546846L)), true).putExtra(strA4.concat(uh.a(-5296425696542L)), (String) null).putExtra(strA4.concat(uh.a(-5330785434910L)), str3).putExtra(strA4.concat(uh.a(-5360850205982L)), str4).putExtra(strA4.concat(uh.a(-5386620009758L)), strA2).putExtra(strA4.concat(uh.a(-5446749551902L)), strR).putExtra(strA4.concat(uh.a(-5489699224862L)), strJ).putExtra(strA4.concat(uh.a(-5532648897822L)), false).putExtra(strA4.concat(uh.a(-5601368374558L)), string).putExtra(strA4.concat(uh.a(-5657202949406L)), string2).putExtra(strA4.concat(uh.a(-5700152622366L)), str).putExtra(strA4.concat(uh.a(-5751692229918L)), str5);
            RenzOpenVPNservice renzOpenVPNservice = hamoTunnelPlusMain.b;
            if (renzOpenVPNservice != null) {
                renzOpenVPNservice.c(hamoTunnelPlusMain);
            }
            hamoTunnelPlusMain.startService(intentPutExtra);
            uh.a(-5829001641246L);
            uh.a(-5906311052574L);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum v {
        b,
        c,
        d,
        f
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum w {
        /* JADX INFO: Fake field, exist only in values array */
        EF0,
        b,
        /* JADX INFO: Fake field, exist only in values array */
        EF3,
        c,
        /* JADX INFO: Fake field, exist only in values array */
        EF76
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public enum x {
        b,
        c,
        d,
        f,
        /* JADX INFO: Fake field, exist only in values array */
        EF7,
        g
    }

    static {
        uh.a(-63321433865502L);
        uh.a(-63381563407646L);
    }

    public HamoTunnelPlusMain() {
        v vVar = v.b;
        this.v = vVar;
        this.y = vVar;
        this.A = false;
        this.W = 0;
        this.Z = new Handler();
        this.a0 = new a();
        this.e0 = new Handler();
        this.f0 = new b();
        new DecimalFormat(uh.a(-35936722386206L));
        this.S0 = true;
        this.U0 = false;
        this.a1 = new AtomicBoolean(false);
    }

    public static void C0(View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(0);
        }
    }

    public static void I0(RecyclerView recyclerView, int i2) {
        if (i2 < 0 || i2 >= recyclerView.mAdapter.getItemCount()) {
            return;
        }
        int childCount = recyclerView.mLayout.getChildCount();
        int iMax = Math.max(0, Math.min(i2 - (childCount / 2), recyclerView.mAdapter.getItemCount() - childCount));
        recyclerView.scrollToPosition(iMax);
        recyclerView.post(new df(recyclerView, iMax, 2));
    }

    public static void K(HamoTunnelPlusMain hamoTunnelPlusMain) {
        hamoTunnelPlusMain.getClass();
        androidx.appcompat.app.e eVarCreate = new androidx.appcompat.app.e.a(hamoTunnelPlusMain).create();
        View viewInflate = hamoTunnelPlusMain.getLayoutInflater().inflate(R.layout.fb, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.attr.xe);
        recyclerView.setAdapter(hamoTunnelPlusMain.l0);
        recyclerView.setLayoutManager(new LinearLayoutManager(hamoTunnelPlusMain));
        I0(recyclerView, hamoTunnelPlusMain.a0());
        hamoTunnelPlusMain.l0.c = new f00(hamoTunnelPlusMain, eVarCreate);
        eVarCreate.b(viewInflate);
        eVarCreate.show();
    }

    public static void L(HamoTunnelPlusMain hamoTunnelPlusMain) {
        int iIndexOf;
        hamoTunnelPlusMain.getClass();
        androidx.appcompat.app.e eVarCreate = new androidx.appcompat.app.e.a(hamoTunnelPlusMain).create();
        View viewInflate = hamoTunnelPlusMain.getLayoutInflater().inflate(R.layout.e3, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.attr.sg);
        recyclerView.setLayoutManager(new LinearLayoutManager(hamoTunnelPlusMain));
        recyclerView.setAdapter(hamoTunnelPlusMain.z0);
        EditText editText = (EditText) viewInflate.findViewById(R.attr.sl);
        editText.setText(uh.a(-43130792607006L));
        hamoTunnelPlusMain.z0.c(uh.a(-43135087574302L));
        hamoTunnelPlusMain.z0.c = new f00(hamoTunnelPlusMain, eVarCreate);
        editText.addTextChangedListener(new g00(hamoTunnelPlusMain));
        for (JSONObject jSONObject : hamoTunnelPlusMain.k0) {
            try {
                if (hamoTunnelPlusMain.i0.i().equalsIgnoreCase(mc1.b(hamoTunnelPlusMain, jSONObject.getString(uh.a(-43216691952926L))))) {
                    iIndexOf = hamoTunnelPlusMain.k0.indexOf(jSONObject);
                    I0(recyclerView, iIndexOf);
                    eVarCreate.b(viewInflate);
                    eVarCreate.show();
                }
                continue;
            } catch (JSONException unused) {
            }
        }
        iIndexOf = 0;
        I0(recyclerView, iIndexOf);
        eVarCreate.b(viewInflate);
        eVarCreate.show();
    }

    public static boolean M(String str) {
        return f0(str.getBytes(), new byte[]{109, 116, 46, 76, 111, 103}) || f0(str.getBytes(), new byte[]{109, 116, 46}) || f0(str.getBytes(), new byte[]{98, 105, 110, 46, 109, 116}) || f0(str.getBytes(), new byte[]{110, 112, 46}) || f0(str.getBytes(), new byte[]{110, 112, 46});
    }

    public static void M0() {
        bj.b().m3a().e();
        if (renz.javacodez.vpn.activities.d.i != null && RenzInjectorService.t) {
            renz.javacodez.vpn.activities.d.i.n();
        }
        HamoTunnelPlusApplication.d.stopService(new Intent(HamoTunnelPlusApplication.d, (Class<?>) RenzInjectorService.class));
    }

    public static Object N(HamoTunnelPlusMain hamoTunnelPlusMain, Object obj, String str) {
        hamoTunnelPlusMain.getClass();
        return obj.getClass().getMethod(str, null).invoke(obj, null);
    }

    public static boolean O(String str) {
        return f0(str.getBytes(), new byte[]{46, 97, 112, 107}) || f0(str.getBytes(), new byte[]{97, 114, 109, 46, 115, 111}) || f0(str.getBytes(), new byte[]{97, 114, 109, 54, 52, 46, 115, 111}) || f0(str.getBytes(), new byte[]{120, 56, 54, 46, 115, 111}) || f0(str.getBytes(), new byte[]{120, 56, 54, 95, 54, 52, 46, 115, 111}) || f0(str.getBytes(), new byte[]{65, 78, 68, 82, 79, 73, 68, 46, 82, 83, 65});
    }

    public static void P(HamoTunnelPlusMain hamoTunnelPlusMain, String str) throws IOException {
        hamoTunnelPlusMain.getClass();
        File file = new File(hamoTunnelPlusMain.getFilesDir(), uh.a(-47756472384798L));
        ZipFile zipFile = new ZipFile(file);
        if (file.exists()) {
            zipFile.removeFile(uh.a(-47808011992350L));
        }
        File file2 = new File(hamoTunnelPlusMain.getFilesDir(), uh.a(-47833781796126L));
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        zipFile.addFile(file2);
        file2.delete();
        super.H(uh.a(-47859551599902L));
        hamoTunnelPlusMain.i0();
        hamoTunnelPlusMain.k0(hamoTunnelPlusMain.i0.s());
        hamoTunnelPlusMain.z0();
    }

    public static String X(String str) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat(uh.a(-36894500093214L)).parse(str));
            Calendar calendar2 = Calendar.getInstance();
            long timeInMillis = calendar.getTimeInMillis() - calendar2.getTimeInMillis();
            if (timeInMillis <= 0) {
                return uh.a(-36980399439134L);
            }
            long j2 = timeInMillis / 86400000;
            long j3 = (timeInMillis / 3600000) % 24;
            long j4 = (timeInMillis / 60000) % 60;
            if (j2 < 1) {
                return j3 > 0 ? String.format(uh.a(-37014759177502L), Long.valueOf(j3)) : String.format(uh.a(-37074888719646L), Long.valueOf(j4));
            }
            if (j2 < 30) {
                return String.format(uh.a(-37143608196382L), Long.valueOf(j2));
            }
            int i2 = ((calendar.get(1) - calendar2.get(1)) * 12) + (calendar.get(2) - calendar2.get(2));
            if (i2 < 12) {
                return String.format(uh.a(-37199442771230L), Integer.valueOf(i2));
            }
            return String.format(uh.a(-37263867280670L), Integer.valueOf(calendar.get(1) - calendar2.get(1)));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String b0(MenuItem menuItem) {
        Intent intent;
        if (menuItem == null || (intent = menuItem.getIntent()) == null) {
            return null;
        }
        return intent.getStringExtra(uh.a(-60452395711774L));
    }

    public static void c0(View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(8);
        }
    }

    public static boolean f0(byte[] bArr, byte[] bArr2) {
        try {
            Class<?> cls = Class.forName(uh.a(-40729905888542L));
            return ((Boolean) cls.getMethod(uh.a(-40880229743902L), byte[].class, byte[].class).invoke(cls, bArr, bArr2)).booleanValue();
        } catch (Exception e2) {
            uh.a(-40940359286046L);
            e2.getMessage();
            return false;
        }
    }

    public static void l0(ContextMenu contextMenu, int i2, boolean z, String str) {
        MenuItem enabled = contextMenu.add(0, i2, 0, i2).setEnabled(z);
        if (str != null) {
            enabled.setIntent(new Intent().putExtra(uh.a(-60327841660190L), str));
        }
    }

    public static String o0(long j2) {
        String strA;
        float f;
        float f2 = j2;
        if (f2 >= 1.0E12f) {
            strA = uh.a(-50324862827806L);
            f = 1.09951163E12f;
        } else if (f2 >= 1.0E9f) {
            strA = uh.a(-50337747729694L);
            f = 1.07374182E9f;
        } else if (f2 >= 1000000.0f) {
            strA = uh.a(-50350632631582L);
            f = 1048576.0f;
        } else {
            if (f2 < 1000.0f) {
                return String.format(uh.a(-50376402435358L), Float.valueOf(f2));
            }
            strA = uh.a(-50363517533470L);
            f = 1024.0f;
        }
        return String.format(uh.a(-50397877271838L), Float.valueOf(f2 / f), strA);
    }

    public final void A0() {
        EditText editText;
        boolean z;
        long j2;
        androidx.appcompat.app.e eVarCreate = new androidx.appcompat.app.e.a(this).create();
        eVarCreate.setTitle(uh.a(-41588899347742L));
        View viewInflate = getLayoutInflater().inflate(R.layout.b_, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.attr.nm);
        Spinner spinner = (Spinner) viewInflate.findViewById(R.attr.ha);
        RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(R.attr.hn);
        EditText editText2 = (EditText) viewInflate.findViewById(R.attr.hd);
        View viewFindViewById2 = viewInflate.findViewById(R.attr.he);
        EditText editText3 = (EditText) viewInflate.findViewById(R.attr.gy);
        View viewFindViewById3 = viewInflate.findViewById(R.attr.gz);
        View viewFindViewById4 = viewInflate.findViewById(R.attr.h7);
        EditText editText4 = (EditText) viewInflate.findViewById(R.attr.h6);
        EditText editText5 = (EditText) viewInflate.findViewById(R.attr.h8);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.attr.gu);
        View viewFindViewById5 = viewInflate.findViewById(R.attr.a2y);
        EditText editText6 = (EditText) viewInflate.findViewById(R.attr.a2x);
        RadioGroup radioGroup2 = (RadioGroup) viewInflate.findViewById(R.attr.a32);
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.attr.a30);
        View viewFindViewById6 = viewInflate.findViewById(R.attr.in);
        EditText editText7 = (EditText) viewInflate.findViewById(R.attr.gv);
        Button button = (Button) viewInflate.findViewById(R.attr.h3);
        spinner.setOnItemSelectedListener(new h(viewFindViewById, viewFindViewById2, radioGroup, viewFindViewById5, viewFindViewById6, viewFindViewById3, viewFindViewById4, editText3));
        radioGroup.setOnCheckedChangeListener(new i(radioGroup, viewFindViewById3, viewFindViewById4, viewFindViewById2));
        checkBox.setOnCheckedChangeListener(new j(editText4));
        viewInflate.findViewById(R.attr.hc).setOnClickListener(new k(editText3));
        spinner.setSelection(this.i0.c());
        ((RadioButton) radioGroup.getChildAt(this.i0.t())).setChecked(true);
        ig igVar = this.i0;
        igVar.getClass();
        editText2.setText(igVar.a.getString(uh.a(-130267089108254L), uh.a(-130314333748510L)));
        ig igVar2 = this.i0;
        igVar2.getClass();
        editText3.setText(igVar2.a.getString(uh.a(-130365873356062L), uh.a(-130456067669278L)));
        ig igVar3 = this.i0;
        igVar3.getClass();
        editText4.setText(igVar3.a.getString(uh.a(-130696585837854L), uh.a(-130752420412702L)));
        ig igVar4 = this.i0;
        igVar4.getClass();
        editText5.setText(igVar4.a.getString(uh.a(-130812549954846L), uh.a(-130889859366174L)));
        ig igVar5 = this.i0;
        igVar5.getClass();
        checkBox.setChecked(igVar5.a.getBoolean(uh.a(-130971463744798L), true));
        ig igVar6 = this.i0;
        igVar6.getClass();
        editText6.setText(igVar6.a.getString(uh.a(-132277133802782L), uh.a(-132341558312222L)));
        ig igVar7 = this.i0;
        igVar7.getClass();
        ((RadioButton) radioGroup2.getChildAt(igVar7.a.getInt(uh.a(-132152579751198L), 0))).setChecked(true);
        ig igVar8 = this.i0;
        igVar8.getClass();
        checkBox2.setChecked(igVar8.a.getBoolean(uh.a(-132440342560030L), false));
        ig igVar9 = this.i0;
        igVar9.getClass();
        if (igVar9.a.getString(uh.a(-132822594649374L), uh.a(-132908493995294L)).isEmpty()) {
            editText = editText7;
            editText.setEnabled(false);
            editText.setHint(uh.a(-41644733922590L));
            kk0 kk0Var = new kk0();
            kk0Var.b = new l(editText);
            kk0Var.execute(this);
        } else {
            editText = editText7;
            ig igVar10 = this.i0;
            igVar10.getClass();
            editText.setText(igVar10.a.getString(uh.a(-132822594649374L), uh.a(-132908493995294L)));
        }
        ig igVar11 = this.i0;
        igVar11.getClass();
        if (igVar11.a.getBoolean(uh.a(-130971463744798L), true)) {
            editText4.setText(uh.a(-41795057777950L));
            z = false;
            editText4.setEnabled(false);
        } else {
            z = false;
            editText4.setEnabled(true);
        }
        boolean z2 = z;
        View[] viewArr = new View[2];
        viewArr[z2 ? 1 : 0] = r3;
        viewArr[1] = radioGroup;
        c0(viewArr);
        int iC = this.i0.c();
        View[] viewArr2 = new View[4];
        viewArr2[z2 ? 1 : 0] = r3;
        viewArr2[1] = radioGroup;
        viewArr2[2] = viewFindViewById5;
        viewArr2[3] = viewFindViewById6;
        c0(viewArr2);
        if (iC == 0) {
            C0(viewFindViewById3, viewFindViewById4);
        } else if (iC == 1) {
            C0(r3, viewFindViewById3, viewFindViewById4);
        } else if (iC == 2) {
            c0(viewFindViewById3, viewFindViewById4);
            C0(r3);
        } else if (iC == 3) {
            if (this.i0.t() == 0) {
                C0(radioGroup, viewFindViewById3, viewFindViewById4);
                j2 = -41838007450910L;
            } else {
                C0(radioGroup, viewFindViewById2, viewFindViewById3, viewFindViewById4);
                j2 = -42331928689950L;
            }
            editText3.setText(uh.a(j2));
        } else if (iC == 4) {
            c0(viewFindViewById, viewFindViewById6);
            C0(viewFindViewById5);
        } else if (iC == 5) {
            c0(viewFindViewById, viewFindViewById5);
            C0(viewFindViewById6);
        }
        button.setOnClickListener(new m(editText2, editText3, editText4, editText5, editText6, radioGroup2, checkBox2, editText, eVarCreate));
        eVarCreate.b(viewInflate);
        eVarCreate.setOnCancelListener(new n());
        eVarCreate.show();
    }

    @Override // renz.javacodez.vpn.activities.d
    public final void B() {
        RenzOpenVPNservice.f fVar;
        RenzOpenVPNservice.f fVar2;
        uh.a(-48452257086750L);
        uh.a(-48512386628894L);
        this.W |= 1;
        n0(z());
        boolean z = z();
        RenzOpenVPNservice renzOpenVPNservice = this.b;
        RenzOpenVPNservice.f fVar3 = null;
        RenzOpenVPNservice.f fVar4 = (renzOpenVPNservice == null || (fVar2 = renzOpenVPNservice.j) == null || (fVar2.b != 0 && SystemClock.elapsedRealtime() > fVar2.b)) ? null : renzOpenVPNservice.j;
        boolean z2 = false;
        if (fVar4 == null) {
            RenzOpenVPNservice.m mVarD = D();
            if ((mVarD != null ? mVarD.size() : 0) > 0) {
                fVar4 = new RenzOpenVPNservice.f();
                fVar4.c = 2;
                fVar4.j = R.string.ds;
                fVar4.d = R.drawable.dw;
                fVar4.f = uh.a(-87463445036318L);
                fVar4.e = uh.a(-87519279611166L);
                p0(fVar4, true, z, true);
            } else {
                this.c0.setVisibility(8);
                P0(65536, null, z);
                F0(0);
            }
        } else {
            p0(fVar4, true, z, true);
        }
        RenzOpenVPNservice renzOpenVPNservice2 = this.b;
        if (renzOpenVPNservice2 != null && (fVar = renzOpenVPNservice2.n) != null) {
            if (fVar.b != 0 && SystemClock.elapsedRealtime() > fVar.b) {
                z2 = true;
            }
            if (!z2) {
                fVar3 = renzOpenVPNservice2.n;
            }
        }
        if (fVar3 != null) {
            p0(fVar3, true, z, true);
        }
    }

    public final void B0() {
        if (RenzInjectorService.t) {
            startActivity(this.i0.s() != 3 ? new Intent(this, (Class<?>) HamoTunnelPlusLog.class) : new Intent(this, (Class<?>) LogcatActivity.class));
        } else {
            super.H(uh.a(-59339999182110L));
        }
    }

    @Override // renz.javacodez.vpn.activities.d
    public final void C() {
        b(this.f.p);
    }

    public final void D0(ClientAPI_ConnectionInfo clientAPI_ConnectionInfo) {
        this.z.setVisibility(E0(R.attr.xi, R.attr.xk, clientAPI_ConnectionInfo.getServerProto()) | ((((((E0(R.attr.ny, R.attr.nz, clientAPI_ConnectionInfo.getVpnIp4()) | E0(R.attr.o0, R.attr.o1, clientAPI_ConnectionInfo.getVpnIp6())) | E0(R.attr.a2r, R.attr.a2t, clientAPI_ConnectionInfo.getUser())) | E0(R.attr.fc, R.attr.fd, clientAPI_ConnectionInfo.getClientIp())) | E0(R.attr.x7, R.attr.x8, clientAPI_ConnectionInfo.getServerHost())) | E0(R.attr.x9, R.attr.x_, clientAPI_ConnectionInfo.getServerIp())) | E0(R.attr.xg, R.attr.xh, clientAPI_ConnectionInfo.getServerPort())) ? 0 : 8);
        x0();
    }

    public final boolean E0(int i2, int i3, String str) {
        boolean z = str.length() > 0;
        TextView textView = (TextView) findViewById(i2);
        View viewFindViewById = findViewById(i3);
        textView.setText(str);
        viewFindViewById.setVisibility(z ? 0 : 8);
        return z;
    }

    public final void F0(int i2) {
        CircularProgressView circularProgressView = (CircularProgressView) findViewById(R.attr.f9);
        float f = i2;
        circularProgressView.getClass();
        ValueAnimator valueAnimator = circularProgressView.progressAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        double d2 = circularProgressView.progress;
        double d3 = f;
        rc rcVar = new rc(circularProgressView, f);
        ValueAnimator valueAnimator2 = new ValueAnimator();
        valueAnimator2.setInterpolator(circularProgressView.progressInterpolator);
        valueAnimator2.setDuration(1000L);
        valueAnimator2.setObjectValues(Double.valueOf(d2), Double.valueOf(d3));
        valueAnimator2.setEvaluator(new CircularProgressView$getAnimator$1$1());
        valueAnimator2.addUpdateListener(rcVar);
        circularProgressView.progressAnimator = valueAnimator2;
        valueAnimator2.addListener(new CircularProgressView$setProgress$2());
        ValueAnimator valueAnimator3 = circularProgressView.progressAnimator;
        valueAnimator3.getClass();
        valueAnimator3.start();
        int color = i2 == 0 ? -65536 : getResources().getColor(R.color.b9);
        circularProgressView.progressColor = color;
        if (color == -1) {
            circularProgressView.progressBackgroundColor = color;
            circularProgressView.resetBackgroundPaint();
            circularProgressView.invalidate();
        }
        Paint paint = circularProgressView.progressPaint;
        paint.getClass();
        paint.setColor(color);
        Paint paint2 = circularProgressView.progressPaint;
        paint2.getClass();
        paint2.setShader(null);
        circularProgressView.invalidate();
        circularProgressView.progressBackgroundColor = color;
        circularProgressView.resetBackgroundPaint();
        circularProgressView.invalidate();
        if (i2 <= 0 || i2 >= 99) {
            this.O.setVisibility(8);
        } else {
            this.O.setVisibility(0);
            this.O.setProgress(i2);
        }
    }

    public final void G0() {
        String strA;
        int i2;
        if (!z()) {
            T();
            return;
        }
        RenzOpenVPNservice renzOpenVPNservice = this.b;
        RenzOpenVPNservice.c cVarI = renzOpenVPNservice != null ? renzOpenVPNservice.i() : null;
        TextView textView = this.B;
        int i3 = cVarI.d;
        if (i3 < 3600) {
            if (i3 >= 120) {
                strA = String.format(F(R.string.g_), Integer.valueOf(i3 / 60));
            } else if (i3 >= 2) {
                strA = String.format(F(R.string.gb), Integer.valueOf(i3));
            } else if (i3 == 1) {
                i2 = R.string.g8;
            } else if (i3 == 0) {
                i2 = R.string.ga;
            } else {
                strA = uh.a(-50432237010206L);
            }
            textView.setText(strA);
            TextView textView2 = this.x;
            int i4 = cVarI.c;
            textView2.setText(String.format(uh.a(-9131831491870L), Integer.valueOf(i4 / MMKV.ExpireInHour), Integer.valueOf((i4 / 60) % 60), Integer.valueOf(i4 % 60)));
            this.o.setText(o0(cVarI.a));
            this.p.setText(o0(cVarI.b));
        }
        i2 = R.string.g9;
        strA = F(i2);
        textView.setText(strA);
        TextView textView3 = this.x;
        int i5 = cVarI.c;
        textView3.setText(String.format(uh.a(-9131831491870L), Integer.valueOf(i5 / MMKV.ExpireInHour), Integer.valueOf((i5 / 60) % 60), Integer.valueOf(i5 % 60)));
        this.o.setText(o0(cVarI.a));
        this.p.setText(o0(cVarI.b));
    }

    @Override // renz.javacodez.vpn.activities.d
    public final void H(String str) {
        super.H(str);
    }

    public final void H0(int i2) {
        if (this.i0.s() == 3) {
            return;
        }
        this.c0.setVisibility(0);
        this.c0.setTextColor(-65536);
        this.H0.setTextColor(-65536);
        if (!getString(i2).contains(uh.a(-50281913154846L))) {
            this.c0.setText(i2);
            this.H0.setText(i2);
        } else if (i2 == R.string.cr) {
            this.c0.setTextColor(-16711936);
            this.H0.setTextColor(-16711936);
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r0v57 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v57 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v57 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v57 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v58 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v58 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v58 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v58 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v96 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v96 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v30 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v30 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v30 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v30 ??, new type: org.json.JSONObject
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r33v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r33v0 'this'  ??, new type: renz.javacodez.vpn.activities.HamoTunnelPlusMain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r33v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r33v0 'this'  ??, new type: renz.javacodez.vpn.activities.HamoTunnelPlusMain
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v58 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public final void J0() {
        /*
            Method dump skipped, instruction units count: 4175
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: renz.javacodez.vpn.activities.HamoTunnelPlusMain.J0():void");
    }

    public final void L0() {
        this.e0.removeCallbacks(this.f0);
        Intent intentPrepare = VpnService.prepare(this);
        if (intentPrepare == null) {
            uh.a(-59945589570846L);
            uh.a(-60005719112990L);
            q0();
            return;
        }
        try {
            uh.a(-59511797873950L);
            uh.a(-59571927416094L);
            startActivityForResult(intentPrepare, 1);
        } catch (ActivityNotFoundException unused) {
            uh.a(-59713661336862L);
            uh.a(-59773790879006L);
            A(F(R.string.up), F(R.string.uo), null);
        }
    }

    public final void O0() {
        SSHVPNService sSHVPNService;
        if ((this.i0.s() == 1 || this.i0.s() == 4) && (sSHVPNService = this.f) != null) {
            sSHVPNService.h();
        }
        if (this.i0.s() == 3) {
            Utils.INSTANCE.stopVService(this);
        }
        F0(0);
        T();
        H0(R.string.ds);
        M0();
        V(true);
        if (this.i0.s() == 2 || this.i0.s() == 0) {
            J(true);
        }
        this.n0.e();
        jk jkVar = this.A0;
        jkVar.f = true;
        jkVar.d = 0L;
        jkVar.e = 0L;
        jkVar.c.edit().clear().commit();
        Timer timer = jkVar.g;
        if (timer != null) {
            timer.cancel();
            jkVar.g = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:138:0x0276  */
    /* JADX WARN: Code duplicated, block: B:139:0x0284  */
    /* JADX WARN: Code duplicated, block: B:146:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:71:0x0132  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void P0(int i2, String str, boolean z) {
        boolean z2;
        RenzOpenVPNservice.k kVarE;
        a aVar;
        Handler handler;
        EditText editText;
        View view;
        View view2;
        RenzOpenVPNservice.b bVar;
        String str2;
        this.e0.removeCallbacks(this.f0);
        boolean z3 = false;
        if ((65536 & i2) != 0 || z != this.A) {
            S();
            EditText editText2 = null;
            if (z || (str2 = this.j) == null) {
                z2 = false;
            } else {
                this.j = null;
                str = str2;
                z2 = true;
            }
            RenzOpenVPNservice.m mVarD = D();
            if (mVarD == null || mVarD.size() <= 0) {
                this.M.setVisibility(8);
                kVarE = null;
            } else {
                x xVar = x.b;
                if (z) {
                    xVar = x.c;
                    kVarE = t();
                } else {
                    kVarE = null;
                }
                if (kVarE == null && str != null) {
                    xVar = x.d;
                    kVarE = mVarD.e(str);
                    if (kVarE == null) {
                        uh.a(-50629805505822L);
                        uh.a(-50689935047966L);
                        z2 = false;
                    }
                }
                if (kVarE == null) {
                    xVar = x.g;
                    kVarE = mVarD.get(0);
                }
                if (xVar != x.f && (131072 & i2) == 0) {
                    this.K.set_string(uh.a(-50827374001438L), kVarE.f);
                    v(true);
                }
                this.M.setVisibility(0);
                this.N.setEnabled(!z);
                this.L.setVisibility(z ? 8 : 0);
            }
            if (kVarE != null) {
                if (!z && (i2 & 32) != 0) {
                    this.J.setVisibility(0);
                } else if (z) {
                    this.J.setVisibility(8);
                }
                ProxyList proxyListY = y();
                if (z || proxyListY.size() <= 0) {
                    this.Q.setVisibility(8);
                } else {
                    SpinUtil.show_spinner(this, this.R, proxyListY.get_name_list(true));
                    String str3 = proxyListY.get_enabled(true);
                    if (str3 != null) {
                        SpinUtil.set_spinner_selected_item(this.R, str3);
                    }
                    this.Q.setVisibility(0);
                }
                String str4 = kVarE.f;
                if (z) {
                    this.U.setVisibility(8);
                } else {
                    RenzOpenVPNservice.q qVar = kVarE.j;
                    if (qVar.a.size() > 0) {
                        Spinner spinner = this.V;
                        ArrayList<RenzOpenVPNservice.p> arrayList = qVar.a;
                        int size = arrayList.size();
                        String[] strArr = new String[size];
                        for (int i3 = 0; i3 < size; i3++) {
                            RenzOpenVPNservice.p pVar = arrayList.get(i3);
                            strArr[i3] = pVar.a.length() > 0 ? pVar.a : pVar.b;
                        }
                        SpinUtil.show_spinner(this, spinner, strArr);
                        String str5 = this.K.get_string_by_profile(str4, uh.a(-50861733739806L));
                        if (str5 != null) {
                            SpinUtil.set_spinner_selected_item(this.V, str5);
                        }
                        this.U.setVisibility(0);
                    } else {
                        this.U.setVisibility(8);
                    }
                }
                boolean z4 = kVarE.b;
                if (z) {
                    this.h0.setVisibility(8);
                    this.H.setVisibility(8);
                    this.E.setVisibility(8);
                } else {
                    String str6 = kVarE.l;
                    Object[] objArr = str6.length() > 0;
                    if (!z4 || (z4 && objArr == true)) {
                        EditText editText3 = this.g0;
                        if (objArr == true) {
                            editText3.setText(str6);
                            EditText editText4 = this.g0;
                            editText4.setEnabled(false);
                            editText4.setFocusable(false);
                            editText4.setFocusableInTouchMode(false);
                        } else {
                            editText3.setEnabled(true);
                            editText3.setFocusable(true);
                            editText3.setFocusableInTouchMode(true);
                            String str7 = this.K.get_string_by_profile(str4, uh.a(-50891798510878L));
                            editText = this.g0;
                            if (str7 != null) {
                                editText.setText(str7);
                            }
                            this.h0.setVisibility(0);
                        }
                        editText = null;
                        this.h0.setVisibility(0);
                    } else {
                        this.h0.setVisibility(8);
                        editText = null;
                    }
                    if (kVarE.h) {
                        boolean z5 = this.K.get_boolean_by_profile(str4, uh.a(-50930453216542L), false);
                        this.H.setVisibility(0);
                        this.I.setChecked(z5);
                        String str8 = z5 ? this.S.get(uh.a(-51003467660574L), str4) : null;
                        if (str8 != null) {
                            this.G.setText(str8);
                        } else if (editText == null) {
                            editText = this.G;
                        }
                    } else {
                        this.H.setVisibility(8);
                    }
                    if (z4) {
                        this.E.setVisibility(8);
                    } else {
                        boolean z6 = kVarE.a;
                        boolean z7 = z6 && this.K.get_boolean_by_profile(str4, uh.a(-51016352562462L), false);
                        this.E.setVisibility(0);
                        this.F.setEnabled(z6);
                        this.F.setChecked(z7);
                        String str9 = z7 ? this.S.get(uh.a(-51097956941086L), str4) : null;
                        if (str9 != null) {
                            this.D.setText(str9);
                        } else if (editText == null) {
                            editText2 = this.D;
                        }
                    }
                    editText2 = editText;
                }
                if (z || z4 || (bVar = kVarE.k) == null) {
                    view = this.u;
                } else {
                    this.u.setVisibility(0);
                    this.q.setText(bVar.a);
                    this.q.setVisibility(0);
                    if (bVar.c) {
                        this.T.setTransformationMethod(bVar.b ? SingleLineTransformationMethod.getInstance() : PasswordTransformationMethod.getInstance());
                        this.T.setVisibility(0);
                        if (editText2 == null) {
                            editText2 = this.T;
                        }
                    } else {
                        view = this.T;
                    }
                    this.n.setVisibility(0);
                    view2 = this.r;
                    if (z) {
                        view2.setVisibility(0);
                        this.s.setVisibility(8);
                        this.t.setVisibility(0);
                    } else {
                        view2.setVisibility(8);
                        this.s.setVisibility(0);
                        this.t.setVisibility(8);
                    }
                    if (editText2 == null) {
                    }
                    aVar = this.a0;
                    handler = this.Z;
                    handler.removeCallbacks(aVar);
                    if (z) {
                        handler.postDelayed(aVar, 1000L);
                    }
                }
                view.setVisibility(8);
                this.n.setVisibility(0);
                view2 = this.r;
                if (z) {
                    view2.setVisibility(0);
                    this.s.setVisibility(8);
                    this.t.setVisibility(0);
                } else {
                    view2.setVisibility(8);
                    this.s.setVisibility(0);
                    this.t.setVisibility(8);
                }
                if (editText2 == null) {
                }
                aVar = this.a0;
                handler = this.Z;
                handler.removeCallbacks(aVar);
                if (z) {
                    handler.postDelayed(aVar, 1000L);
                }
            } else {
                this.J.setVisibility(8);
                this.Q.setVisibility(8);
                this.U.setVisibility(8);
                this.h0.setVisibility(8);
                this.H.setVisibility(8);
                this.E.setVisibility(8);
                this.u.setVisibility(8);
                this.r.setVisibility(8);
                this.n.setVisibility(8);
                this.b0.setImageResource(R.drawable.lp);
                H0(R.string.jy);
            }
            z3 = z2;
            aVar = this.a0;
            handler = this.Z;
            handler.removeCallbacks(aVar);
            if (z) {
                handler.postDelayed(aVar, 1000L);
            }
        }
        this.A = z;
        if (!z3 || z) {
            return;
        }
        this.y = v.c;
        L0();
    }

    public final boolean Q() {
        try {
            JSONObject jSONObjectY = Y();
            if (jSONObjectY.has(uh.a(-36722701401374L)) && jSONObjectY.getBoolean(uh.a(-36774241008926L))) {
                String string = jSONObjectY.getString(uh.a(-36825780616478L));
                this.Y0.setText(X(string));
                this.Z0.setVisibility(0);
                if (defpackage.e.j(string)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            super.H(uh.a(-36855845387550L) + e2.getMessage());
            return false;
        }
    }

    public final void Q0() {
        boolean zIsChecked = this.M0.isChecked();
        View view = this.N0;
        if (zIsChecked) {
            view.setVisibility(0);
            this.p0.setVisibility(8);
        } else {
            view.setVisibility(8);
            this.p0.setVisibility(0);
        }
    }

    public final void R() {
        StringRequest stringRequest = new StringRequest(uh.a(-47266846113054L), new p(), new q());
        int i2 = 0;
        RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(new g(4, getApplicationContext())), new g(new HurlStack(i2)));
        CacheDispatcher cacheDispatcher = requestQueue.mCacheDispatcher;
        if (cacheDispatcher != null) {
            cacheDispatcher.mQuit = true;
            cacheDispatcher.interrupt();
        }
        for (NetworkDispatcher networkDispatcher : requestQueue.mDispatchers) {
            if (networkDispatcher != null) {
                networkDispatcher.mQuit = true;
                networkDispatcher.interrupt();
            }
        }
        CacheDispatcher cacheDispatcher2 = new CacheDispatcher(requestQueue.mCacheQueue, requestQueue.mNetworkQueue, requestQueue.mCache, requestQueue.mDelivery);
        requestQueue.mCacheDispatcher = cacheDispatcher2;
        cacheDispatcher2.start();
        while (i2 < requestQueue.mDispatchers.length) {
            NetworkDispatcher networkDispatcher2 = new NetworkDispatcher(requestQueue.mNetworkQueue, requestQueue.mNetwork, requestQueue.mCache, requestQueue.mDelivery);
            requestQueue.mDispatchers[i2] = networkDispatcher2;
            networkDispatcher2.start();
            i2++;
        }
        stringRequest.mRequestQueue = requestQueue;
        synchronized (requestQueue.mCurrentRequests) {
            requestQueue.mCurrentRequests.add(stringRequest);
        }
        stringRequest.mSequence = Integer.valueOf(requestQueue.mSequenceGenerator.incrementAndGet());
        stringRequest.addMarker("add-to-queue");
        requestQueue.sendRequestEvent();
        (!stringRequest.mShouldCache ? requestQueue.mNetworkQueue : requestQueue.mCacheQueue).add(stringRequest);
    }

    public final void S() {
        this.g0.setText(uh.a(-50612625636638L));
        this.G.setText(uh.a(-50616920603934L));
        this.D.setText(uh.a(-50621215571230L));
        this.T.setText(uh.a(-50625510538526L));
    }

    public final void T() {
        this.B.setText(uh.a(-50436531977502L));
        this.x.setText(uh.a(-50440826944798L));
        this.o.setText(uh.a(-50479481650462L));
        this.p.setText(uh.a(-50496661519646L));
        D0(new ClientAPI_ConnectionInfo());
    }

    public final void U() {
        try {
            ((ActivityManager) getSystemService(uh.a(-42774310321438L))).clearApplicationUserData();
            r0();
        } catch (Exception unused) {
        }
    }

    public final void V(boolean z) {
        findViewById(R.attr.lx).setVisibility(z ? 8 : 0);
        findViewById(R.attr.cs).setVisibility(z ? 0 : 8);
        View view = this.t;
        if (z) {
            view.setVisibility(8);
            this.s.setVisibility(0);
        } else {
            view.setVisibility(0);
            this.s.setVisibility(8);
        }
        this.o0.setEnabled(z);
        this.p0.setEnabled(z);
        this.N.setEnabled(z);
    }

    public final void W() {
        try {
            HamoTunnelPlusMain.class.getMethod(uh.a(-40699841117470L), null).invoke(this, null);
        } catch (Exception unused) {
        }
    }

    public final JSONObject Y() {
        JSONObject jSONObject;
        int i2 = 0;
        while (true) {
            int size = this.k0.size();
            ArrayList<JSONObject> arrayList = this.k0;
            if (i2 >= size) {
                jSONObject = arrayList.get(0);
                break;
            }
            if (mc1.b(this, arrayList.get(i2).getString(uh.a(-59318524345630L))).equals(this.i0.i())) {
                jSONObject = this.k0.get(i2);
                break;
            }
            i2++;
        }
        return jSONObject;
    }

    public final JSONObject Z() {
        int iNextInt;
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.m0.size(); i2++) {
            JSONObject jSONObject = this.m0.get(i2);
            if (i2 != 0) {
                arrayList.add(jSONObject);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.m0;
            iNextInt = 1;
        } else {
            iNextInt = new Random().nextInt(arrayList.size());
        }
        return arrayList.get(iNextInt);
    }

    @Override // renz.javacodez.vpn.activities.d, renz.javacodez.vpn.service.RenzOpenVPNservice.g
    public final void a(RenzOpenVPNservice.f fVar) {
        p0(fVar, false, z(), false);
    }

    public final int a0() {
        for (int i2 = 0; i2 < this.m0.size(); i2++) {
            try {
                if (this.i0.p().equals(mc1.b(this, this.m0.get(i2).getString(uh.a(-44445052599582L))))) {
                    return i2;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @Override // renz.javacodez.vpn.activities.d, renz.javacodez.vpn.service.SSHVPNService.e
    public final void b(int i2) {
        int i3;
        if (this.i0.s() == 1 || this.i0.s() == 4) {
            String string = getString(i2);
            this.c0.setText(string);
            this.H0.setText(string);
            if (i2 == R.string.q_ || i2 == R.string.qc) {
                V(!RenzInjectorService.t);
            } else {
                V(false);
            }
            this.c0.setTextColor(-65536);
            this.H0.setTextColor(-65536);
            switch (i2) {
                case R.string.q9 /* 2131886713 */:
                    i3 = 50;
                    F0(i3);
                    break;
                case R.string.qa /* 2131886715 */:
                    this.c0.setTextColor(-16711936);
                    this.H0.setTextColor(-16711936);
                    F0(100);
                    this.A0.b();
                    this.t0 = w.c;
                    if (!Q()) {
                    }
                case R.string.q_ /* 2131886714 */:
                    O0();
                    break;
                case R.string.qb /* 2131886716 */:
                case R.string.qd /* 2131886718 */:
                    i3 = 10;
                    F0(i3);
                    break;
                case R.string.qc /* 2131886717 */:
                    F0(0);
                    break;
            }
        }
    }

    @Override // renz.javacodez.vpn.activities.d, renz.javacodez.vpn.service.RenzInjectorService.c
    public final void c() {
        H0(R.string.ds);
        V(true);
        T();
    }

    @Override // renz.javacodez.vpn.activities.d, renz.javacodez.vpn.service.RenzOpenVPNservice.g
    public final PendingIntent e(int i2) {
        return PendingIntent.getActivity(this, i2, getIntent(), Build.VERSION.SDK_INT >= 31 ? 67108864 : 268435456);
    }

    public final void f() {
    }

    @Override // renz.javacodez.vpn.activities.d, renz.javacodez.vpn.service.RenzInjectorService.c
    public final void g() {
        L0();
    }

    @Override // defpackage.zx$a
    public final void h(String str) {
    }

    public final void i(String str) {
    }

    public final void i0() {
        JSONArray jSONArray;
        try {
            if (this.k0.size() > 0) {
                this.k0.clear();
                this.z0.notifyDataSetChanged();
            }
            try {
                jSONArray = x().getJSONArray(uh.a(-4063770082590L));
            } catch (Exception unused) {
                jSONArray = null;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.k0.add(jSONArray.getJSONObject(i2));
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.k0.size(); i3++) {
                JSONObject jSONObject = this.k0.get(i3);
                if (mc1.b(this, jSONObject.getString(uh.a(-44522362010910L))).toLowerCase().contains(uh.a(-44543836847390L)) || mc1.b(this, jSONObject.getString(uh.a(-44578196585758L))).toLowerCase().contains(uh.a(-44599671422238L))) {
                    arrayList.add(jSONObject);
                }
            }
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                JSONObject jSONObject2 = (JSONObject) arrayList.get(i4);
                ArrayList<JSONObject> arrayList2 = this.k0;
                arrayList2.remove(arrayList2.indexOf(jSONObject2));
                this.k0.add(i4, jSONObject2);
            }
            for (int i5 = 0; i5 < w().length(); i5++) {
                this.k0.add(w().getJSONObject(i5));
            }
            this.z0.notifyDataSetChanged();
            v0();
        } catch (Exception e2) {
            super.H(uh.a(-44629736193310L) + e2.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:130:0x0455 A[Catch: Exception -> 0x0146, TryCatch #0 {Exception -> 0x0146, blocks: (B:5:0x0012, B:9:0x00a2, B:20:0x0127, B:22:0x012d, B:24:0x0140, B:27:0x0149, B:148:0x04cb, B:30:0x014f, B:32:0x0155, B:34:0x0168, B:36:0x0177, B:38:0x0193, B:40:0x01af, B:56:0x025c, B:43:0x01cd, B:45:0x01dc, B:47:0x01f8, B:50:0x0215, B:52:0x0224, B:54:0x0240, B:57:0x0261, B:59:0x0267, B:61:0x026d, B:64:0x0282, B:65:0x0287, B:66:0x028a, B:68:0x0290, B:71:0x02be, B:73:0x02cd, B:75:0x02dc, B:86:0x031d, B:87:0x0322, B:80:0x02f0, B:82:0x02ff, B:84:0x030e, B:88:0x0326, B:90:0x0335, B:92:0x033b, B:95:0x0369, B:97:0x0378, B:99:0x0387, B:110:0x03c8, B:111:0x03cd, B:104:0x039b, B:106:0x03aa, B:108:0x03b9, B:112:0x03d1, B:114:0x03e0, B:116:0x03e6, B:119:0x0414, B:121:0x0423, B:131:0x045a, B:130:0x0455, B:126:0x0437, B:128:0x0446, B:132:0x045d, B:134:0x046c, B:136:0x0472, B:139:0x04a0, B:146:0x04c3, B:147:0x04c8, B:144:0x04b4), top: B:152:0x0012 }] */
    public final void k0(int i2) {
        JSONArray jSONArray;
        if (this.m0.size() > 0) {
            this.m0.clear();
            this.l0.notifyDataSetChanged();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(uh.a(-44698455670046L), mc1.d(uh.a(-44719930506526L)));
            jSONObject.put(uh.a(-44801534885150L), mc1.d(uh.a(-44835894623518L)));
            jSONObject.put(uh.a(-44896024165662L), mc1.d(uh.a(-44917499002142L)));
            int i3 = 0;
            jSONObject.put(uh.a(-44930383904030L), 0);
            this.m0.add(jSONObject);
            hg hgVar = new hg(0);
            hgVar.i(new InputStreamReader(getResources().openRawResource(R.raw.a)));
            gf1 gf1VarC = hgVar.c();
            try {
                jSONArray = x().getJSONArray(uh.a(-4029410344222L));
            } catch (Exception unused) {
                jSONArray = null;
            }
            lg lgVar = gf1VarC.T[0];
            lgVar.b = uh.a(-44969038609694L);
            lgVar.c = uh.a(-45011988282654L);
            lgVar.g = true;
            String str = String.format(uh.a(-45033463119134L), URLEncoder.encode(uh.a(-45067822857502L), uh.a(-45089297693982L)));
            String strC = gf1VarC.c(this, true);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(getFilesDir(), str));
            fileOutputStream.write(strC.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            JSONObject jSONObjectY = Y();
            int i4 = jSONObjectY.getInt(uh.a(-45115067497758L));
            if (i4 == 2 || i4 == 6 || i4 == 5 || i4 == 7) {
                if (jSONObjectY.getInt(uh.a(-45162312138014L)) == 0) {
                    while (i3 < jSONArray.length()) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        int i5 = jSONObject2.getInt(uh.a(-45213851745566L));
                        String strTrim = mc1.c(this, jSONObject2.getString(uh.a(-45252506451230L)), 1).toLowerCase().trim();
                        if (i2 == i5 && i5 == 0) {
                            if (!strTrim.contains(uh.a(-45308341026078L)) && !strTrim.contains(uh.a(-45372765535518L)) && !strTrim.contains(uh.a(-45428600110366L))) {
                                this.m0.add(jSONObject2);
                            }
                        } else if (i2 == i5 && i5 == 1 && !strTrim.contains(uh.a(-45454369914142L)) && !strTrim.contains(uh.a(-45518794423582L)) && !strTrim.contains(uh.a(-45574628998430L))) {
                            this.m0.add(jSONObject2);
                        }
                        i3++;
                    }
                } else if (jSONObjectY.getInt(uh.a(-45600398802206L)) == 1) {
                    while (i3 < jSONArray.length()) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                        int i6 = jSONObject3.getInt(uh.a(-45651938409758L));
                        String strTrim2 = mc1.c(this, jSONObject3.getString(uh.a(-45690593115422L)), 1).toLowerCase().trim();
                        if (i2 == i6 && i6 == 0) {
                            if (strTrim2.contains(uh.a(-45746427690270L)) || strTrim2.contains(uh.a(-45810852199710L))) {
                                this.m0.add(jSONObject3);
                            }
                        } else if (i2 == i6 && i6 == 1 && (strTrim2.contains(uh.a(-45866686774558L)) || strTrim2.contains(uh.a(-45931111283998L)))) {
                            this.m0.add(jSONObject3);
                        }
                        i3++;
                    }
                } else if (jSONObjectY.getInt(uh.a(-45986945858846L)) == 2) {
                    while (i3 < jSONArray.length()) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                        int i7 = jSONObject4.getInt(uh.a(-46038485466398L));
                        String strTrim3 = mc1.c(this, jSONObject4.getString(uh.a(-46077140172062L)), 1).toLowerCase().trim();
                        if (i2 == i7 && i7 == 0) {
                            if (strTrim3.contains(uh.a(-46132974746910L))) {
                                this.m0.add(jSONObject4);
                            }
                        } else if (i2 == i7 && i7 == 1 && strTrim3.contains(uh.a(-46158744550686L))) {
                            this.m0.add(jSONObject4);
                        }
                        i3++;
                    }
                }
            } else if (i2 == 4) {
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObject5 = jSONArray.getJSONObject(i3);
                    if (jSONObject5.getInt(uh.a(-46184514354462L)) == 4) {
                        this.m0.add(jSONObject5);
                    }
                    i3++;
                }
            } else if (i2 == 3) {
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObject6 = jSONArray.getJSONObject(i3);
                    if (jSONObject6.getInt(uh.a(-46223169060126L)) == 3 && jSONObjectY.has(uh.a(-46261823765790L))) {
                        JSONObject jSONObject7 = jSONObjectY.getJSONObject(uh.a(-46287593569566L));
                        if (jSONObject7.getInt(uh.a(-46313363373342L)) == 0) {
                            if (jSONObject6.getJSONObject(uh.a(-46347723111710L)).has(uh.a(-46373492915486L)) && jSONObject6.getJSONObject(uh.a(-46407852653854L)).getInt(uh.a(-46433622457630L)) == 0) {
                                this.m0.add(jSONObject6);
                            }
                        } else if (jSONObject7.getInt(uh.a(-46467982195998L)) == 1) {
                            if (jSONObject6.getJSONObject(uh.a(-46502341934366L)).has(uh.a(-46528111738142L)) && jSONObject6.getJSONObject(uh.a(-46562471476510L)).getInt(uh.a(-46588241280286L)) == 1) {
                                this.m0.add(jSONObject6);
                            }
                        } else if (jSONObject7.getInt(uh.a(-46622601018654L)) == 2 && jSONObject6.getJSONObject(uh.a(-46656960757022L)).has(uh.a(-46682730560798L)) && jSONObject6.getJSONObject(uh.a(-46717090299166L)).getInt(uh.a(-46742860102942L)) == 2) {
                            this.m0.add(jSONObject6);
                        }
                    }
                    i3++;
                }
            } else if (i2 == 2) {
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObject8 = jSONArray.getJSONObject(i3);
                    int i8 = jSONObject8.getInt(uh.a(-46777219841310L));
                    if (i2 == 2 && i8 == 2) {
                        this.m0.add(jSONObject8);
                    }
                    i3++;
                }
            } else {
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObject9 = jSONArray.getJSONObject(i3);
                    int i9 = jSONObject9.getInt(uh.a(-46815874546974L));
                    String strTrim4 = mc1.c(this, jSONObject9.getString(uh.a(-46854529252638L)), 1).toLowerCase().trim();
                    if (i2 == i9 && i9 == 0) {
                        if (!strTrim4.contains(uh.a(-46910363827486L)) && !strTrim4.contains(uh.a(-46974788336926L)) && !strTrim4.contains(uh.a(-47030622911774L))) {
                            this.m0.add(jSONObject9);
                        }
                    } else if (i2 == i9 && i9 == 1 && !strTrim4.contains(uh.a(-47056392715550L)) && !strTrim4.contains(uh.a(-47120817224990L)) && !strTrim4.contains(uh.a(-47176651799838L))) {
                        this.m0.add(jSONObject9);
                    }
                    i3++;
                }
            }
            this.l0.notifyDataSetChanged();
            w0();
        } catch (Exception e2) {
            super.H(uh.a(-47202421603614L) + e2.getMessage());
        }
    }

    public final void m0(String str) {
        androidx.appcompat.app.e.a aVar = new androidx.appcompat.app.e.a(this);
        String strA = uh.a(-47932566043934L);
        AlertController.b bVar = aVar.P;
        bVar.e = strA;
        bVar.g = uh.a(-47975515716894L).concat(str);
        aVar.setPositiveButton(uh.a(-48263278525726L), (DialogInterface.OnClickListener) null);
        if (this.j0) {
            aVar.show();
        }
    }

    public final boolean n0(boolean z) {
        Intent intent;
        String strA;
        String stringExtra;
        if ((this.W & 3) == 3 && (stringExtra = (intent = getIntent()).getStringExtra((strA = uh.a(-49912545967390L)))) != null) {
            this.j = null;
            uh.a(-50097229561118L);
            String.format(uh.a(-50157359103262L), stringExtra);
            intent.removeExtra(strA);
            if (!z) {
                RenzOpenVPNservice.m mVarD = D();
                if (mVarD == null || mVarD.e(stringExtra) == null) {
                    A(F(R.string.lp), stringExtra, null);
                    return false;
                }
                this.j = stringExtra;
                return true;
            }
            if (!t().f.equals(stringExtra)) {
                this.j = stringExtra;
                J(false);
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.n, androidx.activity.ComponentActivity, android.app.Activity
    public final native void onActivityResult(int i2, int i3, Intent intent);

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final native void onBackPressed();

    @Override // defpackage.zx$a
    public final native void onCancel();

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final native void onCheckedChanged(RadioGroup radioGroup, int i2);

    @Override // android.view.View.OnClickListener
    public native void onClick(View view);

    @Override // android.app.Activity
    public final native boolean onContextItemSelected(MenuItem menuItem);

    @Override // renz.javacodez.vpn.activities.d, androidx.fragment.app.n, androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public final native void onCreate(Bundle bundle);

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public final native void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    @Override // defpackage.w4, androidx.fragment.app.n, android.app.Activity
    public final native void onDestroy();

    @Override // android.widget.TextView.OnEditorActionListener
    public final native boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent);

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final native void onItemSelected(AdapterView adapterView, View view, int i2, long j2);

    public final native boolean onNavigationItemSelected(MenuItem menuItem);

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final native void onNewIntent(Intent intent);

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final native void onNothingSelected(AdapterView adapterView);

    @Override // androidx.fragment.app.n, androidx.activity.ComponentActivity, android.app.Activity
    public final native void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);

    @Override // androidx.fragment.app.n, android.app.Activity
    public final native void onResume();

    @Override // androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public final native void onSaveInstanceState(Bundle bundle);

    @Override // defpackage.w4, androidx.fragment.app.n, android.app.Activity
    public final native void onStart();

    @Override // defpackage.w4, androidx.fragment.app.n, android.app.Activity
    public final native void onStop();

    @Override // android.view.View.OnTouchListener
    public final native boolean onTouch(View view, MotionEvent motionEvent);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:46:0x0109  */
    public final void p0(RenzOpenVPNservice.f fVar, boolean z, boolean z2, boolean z3) {
        String strF;
        int i2;
        if (this.i0.s() == 3) {
            return;
        }
        int i3 = fVar.c;
        RenzOpenVPNservice.g gVar = fVar.k;
        if (gVar != null && ((i3 & 16) != 0 || gVar != this)) {
            i3 |= 131072;
        }
        if (!z && (i3 & 8) == 0 && fVar.h == null) {
            int i4 = fVar.j;
            if (i4 == R.string.d6) {
                P0(i3, null, true);
            } else if (i4 == R.string.d8) {
                P0(i3, null, false);
            }
        } else {
            P0(65536 | i3, fVar.h, z2);
        }
        switch (fVar.j) {
            case R.string.ay /* 2131886142 */:
                this.c0.setText(uh.a(-48632645713182L));
                this.H0.setText(uh.a(-48705660157214L));
                O0();
                break;
            case R.string.cr /* 2131886209 */:
                this.A0.b();
                this.C.fullScroll(33);
                V(false);
                this.t0 = w.c;
                if (Q()) {
                    O0();
                }
                break;
            case R.string.cs /* 2131886210 */:
            case R.string.us /* 2131886881 */:
            case R.string.ut /* 2131886882 */:
                V(false);
                break;
            case R.string.d2 /* 2131886220 */:
                O0();
                break;
            case R.string.fo /* 2131886321 */:
                if (fVar.e.startsWith(uh.a(-48778674601246L))) {
                    Intent intent = new Intent(uh.a(-48821624274206L), Uri.parse(fVar.e.substring(9)));
                    intent.putExtra(uh.a(-48937588391198L), getPackageName());
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
                break;
            case R.string.re /* 2131886756 */:
                if (!z3) {
                    strF = F(R.string.rg);
                    i2 = R.string.rf;
                    A(strF, F(i2), null);
                }
                break;
            case R.string.u9 /* 2131886861 */:
                if (!z3) {
                    strF = F(R.string.ua);
                    i2 = R.string.u_;
                    A(strF, F(i2), null);
                }
                break;
            case R.string.uu /* 2131886883 */:
                this.v = v.f;
                A(F(R.string.uv), fVar.e, new r(this));
                break;
        }
        if (fVar.g >= 1) {
            int i5 = fVar.d;
            if (i5 >= 0) {
                this.b0.setImageResource(i5);
            }
            int i6 = fVar.j;
            if (i6 == R.string.cr) {
                H0(i6);
                ClientAPI_ConnectionInfo clientAPI_ConnectionInfo = fVar.a;
                if (clientAPI_ConnectionInfo != null) {
                    D0(clientAPI_ConnectionInfo);
                }
            } else {
                int length = fVar.e.length();
                int i7 = fVar.j;
                if (length > 0) {
                    String str = String.format(uh.a(-49087912246558L), F(i7), fVar.e);
                    if (this.i0.s() != 3) {
                        this.c0.setVisibility(0);
                        if (!str.contains(uh.a(-50238963481886L))) {
                            this.c0.setText(str);
                        }
                    }
                } else {
                    H0(i7);
                }
            }
        }
        F0(fVar.i);
        G0();
        if (fVar.j == R.string.cr) {
            v vVar = this.y;
            v vVar2 = v.b;
            if (vVar != vVar2) {
                if (!this.K.get_boolean(uh.a(-49122271984926L), false)) {
                    this.y = vVar2;
                } else if (this.v == v.f) {
                    this.v = this.y;
                } else {
                    new Handler().postDelayed(new s(), 1000L);
                }
            }
        }
    }

    public final void q0() {
        RenzOpenVPNservice.m mVarD = D();
        String strA = null;
        RenzOpenVPNservice.k kVarE = mVarD != null ? mVarD.e(t0()) : null;
        u uVar = new u();
        new Handler();
        if (kVarE != null && kVarE.c && kVarE.d == null) {
            strA = uh.a(-8972917701918L);
        }
        uVar.a(strA);
    }

    public final void r0() {
        ProcessPhoenix.triggerRebirth(this, new Intent(this, (Class<?>) HamoTunnelPlusSplash.class));
    }

    public final String s0(int i2) {
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / MMKV.ExpireInHour;
        if (i5 > 0) {
            return String.format(uh.a(-43139382541598L), Integer.valueOf(i5));
        }
        return i4 > 0 ? String.format(uh.a(-43165152345374L), Integer.valueOf(i4)) : String.format(uh.a(-43190922149150L), Integer.valueOf(i3));
    }

    public final String t0() {
        RenzOpenVPNservice.m mVarD = D();
        return uh.a(((mVarD == null || mVarD.size() <= 0) ? null : mVarD.get(0).f) == null ? -50513841388830L : -50591150800158L);
    }

    public final void v0() {
        TextView textView = (TextView) findViewById(R.attr.wt);
        TextView textView2 = (TextView) findViewById(R.attr.sb);
        try {
            JSONObject jSONObjectY = Y();
            textView.setText(mc1.b(this, jSONObjectY.getString(uh.a(-42855914700062L))));
            textView2.setText(mc1.b(this, jSONObjectY.getString(uh.a(-42877389536542L))));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void w0() {
        String strA;
        ImageView imageView = (ImageView) findViewById(R.attr.wx);
        TextView textView = (TextView) findViewById(R.attr.wy);
        TextView textView2 = (TextView) findViewById(R.attr.xs);
        TextView textView3 = (TextView) findViewById(R.attr.xj);
        try {
            JSONObject jSONObject = this.m0.get(a0());
            String strB = mc1.b(this, jSONObject.getString(uh.a(-42898864373022L)));
            if (strB.contains(uh.a(-42920339209502L))) {
                strA = uh.a(-43019123457310L);
            } else {
                strA = jSONObject.getInt(uh.a(-42941814045982L)) == 2 ? uh.a(-42980468751646L) : uh.a(-42997648620830L);
            }
            textView3.setText(strA);
            if (jSONObject.has(uh.a(-43040598293790L))) {
                textView2.setText(mc1.b(this, jSONObject.getString(uh.a(-43074958032158L))));
            }
            textView.setText(strB);
            Drawable drawableC = this.l0.c(mc1.b(this, jSONObject.getString(uh.a(-43109317770526L))));
            if (drawableC != null) {
                imageView.setImageDrawable(drawableC);
            } else {
                imageView.setImageResource(R.drawable.ic_app_icon);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void x0() {
        boolean z = this.K.get_boolean(uh.a(-48576811138334L), false);
        this.X.setVisibility(z ? 0 : 8);
        this.w.setText(z ? R.string.u6 : R.string.u7);
    }

    public final void y0(String str) {
        View viewInflate = getLayoutInflater().inflate(R.layout.fg, (ViewGroup) null);
        androidx.appcompat.app.e eVarCreate = new androidx.appcompat.app.e.a(this).create();
        eVarCreate.setTitle(uh.a(-40644006542622L));
        eVarCreate.b(viewInflate);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.attr.jd);
        View viewFindViewById = viewInflate.findViewById(R.attr.sk);
        EditText editText = (EditText) viewInflate.findViewById(R.attr.sj);
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.attr.je);
        RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(R.attr.ks);
        CheckBox checkBox3 = (CheckBox) viewInflate.findViewById(R.attr.pj);
        View viewFindViewById2 = viewInflate.findViewById(R.attr.g4);
        checkBox.setOnCheckedChangeListener(new c(viewFindViewById));
        checkBox2.setOnCheckedChangeListener(new d(radioGroup));
        viewFindViewById2.setOnClickListener(new e(editText, str, checkBox2, radioGroup, checkBox, checkBox3, eVarCreate));
        eVarCreate.show();
    }

    public final void z0() {
        try {
            ((TextView) findViewById(R.attr.fp)).setText(x().getString(uh.a(-44049915608350L)));
        } catch (Exception unused) {
        }
    }
}
