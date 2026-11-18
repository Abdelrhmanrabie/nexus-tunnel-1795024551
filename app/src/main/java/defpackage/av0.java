package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.appcompat.app.e;
import java.net.URL;
import net.lingala.zip4j.util.InternalZipConstants;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class av0 implements DialogInterface.OnCancelListener, View.OnClickListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {
    public final RadioGroup c;
    public final e d;
    public final Context f;
    public qz g;
    public final SharedPreferences.Editor j;
    public final EditText n;
    public final Spinner o;
    public final Spinner p;
    public final RadioGroup q;
    public final CheckBox r;
    public final CheckBox s;
    public final CheckBox t;
    public final CheckBox u;
    public final CheckBox v;
    public final CheckBox w;

    public av0(Context context) {
        this.f = context;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.j = defaultSharedPreferences.edit();
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.bz, (ViewGroup) null);
        EditText editText = (EditText) viewInflate.findViewById(R.attr.a2p);
        this.n = editText;
        RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(R.attr.z4);
        this.c = radioGroup;
        Spinner spinner = (Spinner) viewInflate.findViewById(R.attr.vl);
        this.o = spinner;
        Spinner spinner2 = (Spinner) viewInflate.findViewById(R.attr.nn);
        this.p = spinner2;
        RadioGroup radioGroup2 = (RadioGroup) viewInflate.findViewById(R.attr.v9);
        this.q = radioGroup2;
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.attr.th);
        this.r = checkBox;
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.attr.lm);
        this.s = checkBox2;
        CheckBox checkBox3 = (CheckBox) viewInflate.findViewById(R.attr.vo);
        this.t = checkBox3;
        CheckBox checkBox4 = (CheckBox) viewInflate.findViewById(R.attr.oe);
        this.u = checkBox4;
        CheckBox checkBox5 = (CheckBox) viewInflate.findViewById(R.attr.u0);
        this.v = checkBox5;
        CheckBox checkBox6 = (CheckBox) viewInflate.findViewById(R.attr.j2);
        this.w = checkBox6;
        Button button = (Button) viewInflate.findViewById(R.attr.lr);
        View viewFindViewById = viewInflate.findViewById(R.attr.fh);
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, R.layout.fh, new String[]{"CONNECT", "GET", "POST", "HEAD", "PUT", "PATCH", "DELETE"}));
        spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(context, R.layout.fh, new String[]{"Normal", "Front Inject", "Back Inject"}));
        ((RadioButton) radioGroup2.getChildAt(defaultSharedPreferences.getInt("QUERY_MODE", 0))).setChecked(true);
        ((RadioButton) radioGroup.getChildAt(defaultSharedPreferences.getInt("Split", 2))).setChecked(true);
        editText.setText(defaultSharedPreferences.getString("URL_HOST", AppConfig.CUSTOM));
        spinner.setSelection(defaultSharedPreferences.getInt("SELECTED_REQUEST_METHOD", 0), false);
        spinner2.setSelection(defaultSharedPreferences.getInt("SELECTED_INJECT_METHOD", 0), false);
        checkBox.setChecked(defaultSharedPreferences.getBoolean("ONLINE_HOST", false));
        checkBox2.setChecked(defaultSharedPreferences.getBoolean("FORWARD_HOST", false));
        checkBox3.setChecked(defaultSharedPreferences.getBoolean("REVERSE_PROXY", false));
        checkBox4.setChecked(defaultSharedPreferences.getBoolean("KEEP_ALIVE", false));
        checkBox5.setChecked(defaultSharedPreferences.getBoolean("PROXY_AUTH", false));
        checkBox6.setChecked(defaultSharedPreferences.getBoolean("DUAL_CONNECT", false));
        radioGroup.setOnCheckedChangeListener(this);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        radioGroup2.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);
        viewFindViewById.setOnClickListener(this);
        e eVarCreate = new e.a(context).create();
        this.d = eVarCreate;
        eVarCreate.b(viewInflate);
        eVarCreate.setOnCancelListener(this);
    }

    public final String a() {
        int selectedItemPosition = this.p.getSelectedItemPosition();
        RadioGroup radioGroup = this.c;
        int iIndexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
        if (selectedItemPosition == 0) {
            return "[crlf]";
        }
        if (selectedItemPosition == 1) {
            return "[crlf][crlf]";
        }
        if (selectedItemPosition != 2) {
            return null;
        }
        return iIndexOfChild == 2 ? "[crlf][crlf]" : "[crlf]";
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
    public final String b() {
        String str;
        String str2;
        StringBuilder sb;
        EditText editText = this.n;
        String strM = ak.AnonymousClass0.m(AppConfig.HTTP, editText.getText().toString(), InternalZipConstants.ZIP_FILE_SEPARATOR);
        try {
            strM = new URL(strM).getHost();
        } catch (Exception unused) {
        }
        String strN = e.n("Host: ", strM, "[crlf]");
        String strN2 = this.r.isChecked() ? e.n("X-Online-Host: ", strM, "[crlf]") : AppConfig.CUSTOM;
        String strN3 = this.s.isChecked() ? e.n("X-Forward-Host: ", strM, "[crlf]") : AppConfig.CUSTOM;
        String strN4 = this.t.isChecked() ? e.n("X-Forwarded-For: ", strM, "[crlf]") : AppConfig.CUSTOM;
        String str3 = this.v.isChecked() ? "Proxy-Authorization: [auth][crlf]" : AppConfig.CUSTOM;
        String str4 = this.u.isChecked() ? "Connection: Keep-Alive[crlf]" : AppConfig.CUSTOM;
        StringBuilder sb2 = new StringBuilder();
        sb2.append((String) this.o.getSelectedItem());
        sb2.append(" ");
        sb2.append(AppConfig.HTTP + editText.getText().toString() + InternalZipConstants.ZIP_FILE_SEPARATOR);
        sb2.append(" ");
        Spinner spinner = this.p;
        int selectedItemPosition = spinner.getSelectedItemPosition();
        RadioGroup radioGroup = this.c;
        int iIndexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
        if (iIndexOfChild == 0 || iIndexOfChild == 1) {
            str = "HTTP/1.1";
        } else if (iIndexOfChild == 2) {
            if (selectedItemPosition != 0) {
                if (selectedItemPosition == 1) {
                    str = "HTTP/1.1";
                } else if (selectedItemPosition != 2) {
                    str = null;
                }
            }
            str = "[protocol]";
        } else {
            str = null;
        }
        String strM2 = fb$1.m(sb2, str, "[crlf]");
        String str5 = this.w.isChecked() ? "CONNECT [host_port] [protocol][crlf][crlf]" : "[crlf]";
        RadioGroup radioGroup2 = this.q;
        int iIndexOfChild2 = radioGroup2.indexOfChild(radioGroup2.findViewById(radioGroup2.getCheckedRadioButtonId()));
        if (radioGroup.getCheckedRadioButtonId() == R.attr.z5) {
            str2 = "[instant_split]";
        } else if (radioGroup.getCheckedRadioButtonId() == R.attr.z3) {
            str2 = "[delay_split]";
        } else {
            str2 = radioGroup.getCheckedRadioButtonId() == R.attr.z6 ? AppConfig.CUSTOM : null;
        }
        int selectedItemPosition2 = spinner.getSelectedItemPosition();
        if (selectedItemPosition2 == 0) {
            StringBuilder sb3 = new StringBuilder("CONNECT ");
            sb3.append(c(iIndexOfChild2, strM, a()));
            sb3.append(strN);
            sb3.append(strN2);
            sb3.append(strN3);
            sb3.append(strN4);
            sb3.append(str3);
            return fb$1.m(sb3, str4, str5);
        }
        if (selectedItemPosition2 == 1) {
            sb = new StringBuilder();
            sb.append(strM2);
            sb.append(strN);
            sb.append(strN2);
            sb.append(strN3);
            sb.append(strN4);
            sb.append(str3);
            sb.append(str4);
            sb.append("[crlf]");
            sb.append(str2);
            sb.append("CONNECT ");
            sb.append(c(iIndexOfChild2, strM, "[crlf]"));
        } else {
            if (selectedItemPosition2 != 2) {
                return AppConfig.CUSTOM;
            }
            sb = new StringBuilder("CONNECT ");
            sb.append(c(iIndexOfChild2, strM, a()));
            sb.append(str2);
            sb.append(strM2);
            sb.append(strN);
            sb.append(strN2);
            sb.append(strN3);
            sb.append(strN4);
            sb.append(str3);
            sb.append(str4);
        }
        sb.append(str5);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:17:0x003f  */
    public final String c(int i, String str, String str2) {
        String str3;
        StringBuilder sb;
        RadioGroup radioGroup = this.q;
        int iIndexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
        int selectedItemPosition = this.p.getSelectedItemPosition();
        RadioGroup radioGroup2 = this.c;
        int iIndexOfChild2 = radioGroup2.indexOfChild(radioGroup2.findViewById(radioGroup2.getCheckedRadioButtonId()));
        if (selectedItemPosition == 0 || selectedItemPosition == 1) {
            str3 = "[protocol]";
        } else if (selectedItemPosition != 2) {
            str3 = null;
        } else if (iIndexOfChild != 0) {
            if (iIndexOfChild != 1 && iIndexOfChild != 2) {
                str3 = null;
            } else if (iIndexOfChild2 == 2) {
                str3 = "HTTP/1.1";
            } else {
                str3 = "[protocol]";
            }
        } else if (iIndexOfChild2 == 2) {
            str3 = "HTTP/1.1";
        } else {
            str3 = "[protocol]";
        }
        if (i != 0) {
            if (i == 1) {
                sb = ak.o(str, "@");
            } else {
                if (i != 2) {
                    return null;
                }
                sb = e.d("[host_port]@");
            }
            sb.append(str);
            sb.append(" ");
            sb.append(str3);
            sb.append(str2);
            return sb.toString();
        }
        sb = new StringBuilder();
        str = "[host_port]";
        sb.append(str);
        sb.append(" ");
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.g.f();
        this.d.dismiss();
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        int id = radioGroup.getId();
        if (id == R.attr.v9) {
            this.j.putInt("QUERY_MODE", radioGroup.indexOfChild((RadioButton) radioGroup.findViewById(i))).apply();
            return;
        }
        if (id != R.attr.z4) {
            return;
        }
        int iIndexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
        Spinner spinner = this.p;
        if (iIndexOfChild == 0 || iIndexOfChild == 1) {
            spinner.setSelection(2);
            this.o.setSelection(1);
        } else {
            if (iIndexOfChild != 2) {
                return;
            }
            spinner.setSelection(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String string = this.n.getText().toString();
        if (view.getId() == R.attr.lr) {
            if (string.isEmpty()) {
                Toast.makeText(this.f, "URL/Host is empty", 1).show();
                return;
            }
            SharedPreferences.Editor editor = this.j;
            editor.putString("URL_HOST", string);
            editor.putBoolean("ONLINE_HOST", this.r.isChecked());
            editor.putBoolean("FORWARD_HOST", this.s.isChecked());
            editor.putBoolean("REVERSE_PROXY", this.t.isChecked());
            editor.putBoolean("KEEP_ALIVE", this.u.isChecked());
            editor.putBoolean("PROXY_AUTH", this.v.isChecked());
            editor.putBoolean("DUAL_CONNECT", this.w.isChecked());
            RadioGroup radioGroup = this.c;
            editor.putInt("Split", radioGroup.indexOfChild((RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())));
            editor.putString("FIXED_PAYLOAD", b());
            editor.apply();
            qz qzVar = this.g;
            ((zx$a) qzVar.a).h(b());
        } else if (view.getId() != R.attr.fh) {
            return;
        } else {
            this.g.f();
        }
        this.d.dismiss();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        SharedPreferences.Editor editorPutInt;
        int id = adapterView.getId();
        SharedPreferences.Editor editor = this.j;
        if (id == R.attr.nn) {
            int i2 = 1;
            if (i != 0) {
                if (i == 1 || i == 2) {
                }
                editorPutInt = editor.putInt("SELECTED_INJECT_METHOD", i);
            } else {
                ((RadioButton) this.c.getChildAt(2)).setChecked(true);
                i2 = 0;
            }
            this.o.setSelection(i2);
            editorPutInt = editor.putInt("SELECTED_INJECT_METHOD", i);
        } else {
            if (id != R.attr.vl) {
                return;
            }
            editor.putInt("SELECTED_REQUEST_METHOD", i).apply();
            editorPutInt = editor.putString("METHOD", (String) adapterView.getSelectedItem());
        }
        editorPutInt.apply();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
