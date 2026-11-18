package renz.javacodez.vpn.activities;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.vpn.service.RenzInjectorService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class FileDialog extends ListActivity {
    public static final String y = Environment.getExternalStorageDirectory().getAbsolutePath();
    public InputMethodManager f;
    public LinearLayout i;
    public LinearLayout j;
    public EditText n;
    public ArrayList<HashMap<String, Object>> o;
    public TextView r;
    public TextView s;
    public String t;
    public Button v;
    public File w;
    public boolean b = false;
    public String c = InternalZipConstants.ZIP_FILE_SEPARATOR;
    public String[] d = null;
    public final HashMap<String, Integer> g = new HashMap<>();
    public boolean p = false;
    public boolean q = false;
    public ArrayList u = null;
    public int x = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FileDialog fileDialog = FileDialog.this;
            if (fileDialog.w != null) {
                fileDialog.getIntent().putExtra("RESULT_PATH", fileDialog.w.getPath());
                fileDialog.setResult(-1, fileDialog.getIntent());
                fileDialog.finish();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FileDialog fileDialog = FileDialog.this;
            fileDialog.i.setVisibility(0);
            fileDialog.j.setVisibility(8);
            fileDialog.f.hideSoftInputFromWindow(view.getWindowToken(), 0);
            fileDialog.v.setEnabled(false);
            fileDialog.n.setText(AppConfig.CUSTOM);
            fileDialog.n.requestFocus();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FileDialog fileDialog = FileDialog.this;
            fileDialog.setResult(0, fileDialog.getIntent());
            fileDialog.finish();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FileDialog fileDialog = FileDialog.this;
            if (fileDialog.n.getText().length() > 0) {
                fileDialog.getIntent().putExtra("RESULT_PATH", fileDialog.c + InternalZipConstants.ZIP_FILE_SEPARATOR + ((Object) fileDialog.n.getText()));
                fileDialog.setResult(-1, fileDialog.getIntent());
                fileDialog.finish();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class e implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public final void a(int i, String str) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", str);
        map.put("image", Integer.valueOf(i));
        this.o.add(map);
    }

    public final void b(String str) {
        File[] fileArr;
        boolean z = str.length() < this.c.length();
        Integer num = this.g.get(this.t);
        this.c = str;
        ArrayList arrayList = new ArrayList();
        this.u = new ArrayList();
        this.o = new ArrayList<>();
        File file = new File(this.c);
        File[] fileArrListFiles = file.listFiles();
        String str2 = y;
        if (fileArrListFiles == null) {
            this.c = str2;
            file = new File(this.c);
            fileArrListFiles = file.listFiles();
        }
        c(R.string.em, this.c);
        if (!this.c.equals(str2)) {
            arrayList.add("ExtStorage");
            a(R.drawable.e9, "ExtStorage");
            this.u.add(str2);
        }
        if (!this.c.equals(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            arrayList.add("../");
            a(R.drawable.e9, "../");
            this.u.add(file.getParent());
            this.t = file.getParent();
        }
        TreeMap treeMap = new TreeMap();
        TreeMap treeMap2 = new TreeMap();
        TreeMap treeMap3 = new TreeMap();
        TreeMap treeMap4 = new TreeMap();
        int length = fileArrListFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = fileArrListFiles[i];
            if (!file2.isDirectory()) {
                String name = file2.getName();
                String lowerCase = name.toLowerCase();
                if (this.d != null) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = this.d;
                        fileArr = fileArrListFiles;
                        if (i2 >= strArr.length) {
                            break;
                        } else if (!lowerCase.endsWith(strArr[i2].toLowerCase())) {
                            i2++;
                            fileArrListFiles = fileArr;
                        }
                    }
                } else {
                    fileArr = fileArrListFiles;
                }
                treeMap3.put(name, name);
                treeMap4.put(name, file2.getPath());
                break;
            } else {
                String name2 = file2.getName();
                treeMap.put(name2, name2);
                treeMap2.put(name2, file2.getPath());
                fileArr = fileArrListFiles;
            }
            i++;
            fileArrListFiles = fileArr;
        }
        arrayList.addAll(treeMap.tailMap(AppConfig.CUSTOM).values());
        arrayList.addAll(treeMap3.tailMap(AppConfig.CUSTOM).values());
        this.u.addAll(treeMap2.tailMap(AppConfig.CUSTOM).values());
        this.u.addAll(treeMap4.tailMap(AppConfig.CUSTOM).values());
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, this.o, R.layout.bx, new String[]{"key", "image"}, new int[]{R.attr.lb, R.attr.la});
        Iterator it = treeMap.tailMap(AppConfig.CUSTOM).values().iterator();
        while (it.hasNext()) {
            a(R.drawable.e9, (String) it.next());
        }
        Iterator it2 = treeMap3.tailMap(AppConfig.CUSTOM).values().iterator();
        while (it2.hasNext()) {
            a(R.drawable.e8, (String) it2.next());
        }
        simpleAdapter.notifyDataSetChanged();
        setListAdapter(simpleAdapter);
        if (num == null || !z) {
            return;
        }
        getListView().setSelection(num.intValue());
    }

    public final void c(int i, String str) {
        if (this.q) {
            setTitle(str);
            return;
        }
        this.r.setText(((Object) getText(i)) + ": " + str);
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(0, getIntent());
        RenzInjectorService renzInjectorService = renz.javacodez.vpn.activities.d.i;
        setContentView(R.layout.bw);
        this.r = (TextView) findViewById(R.attr.l8);
        this.s = (TextView) findViewById(R.attr.l9);
        this.n = (EditText) findViewById(R.attr.l4);
        this.p = getIntent().getBooleanExtra("OPTION_ONE_CLICK_SELECT", this.p);
        boolean booleanExtra = getIntent().getBooleanExtra("OPTION_CURRENT_PATH_IN_TITLEBAR", this.q);
        this.q = booleanExtra;
        if (booleanExtra) {
            this.r.setVisibility(8);
        }
        String stringExtra = getIntent().getStringExtra("OPTION_PROMPT");
        TextView textView = this.s;
        if (stringExtra != null) {
            textView.setText(stringExtra);
            this.s.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        this.f = (InputMethodManager) getSystemService("input_method");
        Button button = (Button) findViewById(R.attr.l3);
        this.v = button;
        button.setEnabled(false);
        this.v.setOnClickListener(new a());
        Button button2 = (Button) findViewById(R.attr.l2);
        button2.setOnClickListener(new b());
        this.x = getIntent().getIntExtra("SELECTION_MODE", 0);
        this.d = getIntent().getStringArrayExtra("FORMAT_FILTER");
        this.b = getIntent().getBooleanExtra("CAN_SELECT_DIR", false);
        if (this.x == 1) {
            button2.setVisibility(8);
        }
        this.j = (LinearLayout) findViewById(R.attr.l7);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.attr.l5);
        this.i = linearLayout;
        linearLayout.setVisibility(8);
        if (this.x == 1 && this.p) {
            this.j.setVisibility(8);
        }
        ((Button) findViewById(R.attr.l0)).setOnClickListener(new c());
        ((Button) findViewById(R.attr.l1)).setOnClickListener(new d());
        String stringExtra2 = getIntent().getStringExtra("START_PATH");
        if (stringExtra2 == null) {
            stringExtra2 = InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        if (this.b) {
            this.w = new File(stringExtra2);
            this.v.setEnabled(true);
        }
        b(stringExtra2);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.v.setEnabled(false);
        if (this.i.getVisibility() == 0) {
            this.i.setVisibility(8);
            this.j.setVisibility(0);
            return true;
        }
        if (this.c.equals(y)) {
            return super.onKeyDown(i, keyEvent);
        }
        b(this.t);
        return true;
    }

    @Override // android.app.ListActivity
    public final void onListItemClick(ListView listView, View view, int i, long j) {
        File file = new File((String) this.u.get(i));
        if (!this.p) {
            this.i.setVisibility(8);
            this.j.setVisibility(0);
            this.f.hideSoftInputFromWindow(view.getWindowToken(), 0);
            this.v.setEnabled(false);
        }
        if (!file.isDirectory()) {
            this.w = file;
            view.setSelected(true);
            this.v.setEnabled(true);
            c(R.string.ep, file.getPath());
            if (this.p) {
                this.v.performClick();
                return;
            }
            return;
        }
        this.v.setEnabled(false);
        if (!file.canRead()) {
            new AlertDialog.Builder(this).setIcon(R.drawable.e4).setTitle("[" + file.getName() + "] " + ((Object) getText(R.string.ei))).setPositiveButton("OK", new e()).show();
            return;
        }
        this.g.put(this.c, Integer.valueOf(i));
        b((String) this.u.get(i));
        if (this.b) {
            this.w = file;
            view.setSelected(true);
            this.v.setEnabled(true);
        }
    }
}
