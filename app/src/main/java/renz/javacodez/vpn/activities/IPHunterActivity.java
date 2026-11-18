package renz.javacodez.vpn.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.mc1;
import defpackage.uh;
import defpackage.wr;
import defpackage.y2;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.vpn.service.IPHunterInteractionService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class IPHunterActivity extends renz.javacodez.vpn.activities.d {
    public static final /* synthetic */ int B = 0;
    public TextView A;
    public EditText j;
    public Button n;
    public RecyclerView p;
    public ArrayList<String> q;
    public y2 r;
    public ConnectivityManager t;
    public View v;
    public Spinner w;
    public String[] x;
    public String y;
    public Timer z;
    public final Handler o = new Handler();
    public final a s = new a();
    public boolean u = false;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = IPHunterActivity.B;
            IPHunterActivity.this.L();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            IPHunterActivity iPHunterActivity = IPHunterActivity.this;
            iPHunterActivity.y = iPHunterActivity.x[i];
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            IPHunterActivity iPHunterActivity = IPHunterActivity.this;
            if (TextUtils.isEmpty(iPHunterActivity.j.getText().toString())) {
                iPHunterActivity.H(uh.a(-65129615097118L));
                return;
            }
            if (iPHunterActivity.u) {
                iPHunterActivity.v.setEnabled(true);
                iPHunterActivity.w.setEnabled(true);
                iPHunterActivity.u = false;
                iPHunterActivity.o.removeCallbacks(iPHunterActivity.s);
                iPHunterActivity.n.setText(uh.a(-65786745093406L));
                iPHunterActivity.K(uh.a(-65812514897182L));
                return;
            }
            iPHunterActivity.u = true;
            iPHunterActivity.v.setEnabled(false);
            iPHunterActivity.w.setEnabled(false);
            iPHunterActivity.n.setText(uh.a(-65683665878302L));
            iPHunterActivity.K(uh.a(-65705140714782L));
            iPHunterActivity.L();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(uh.a(-65228399344926L));
            IPHunterActivity iPHunterActivity = IPHunterActivity.this;
            if (intent.resolveActivity(iPHunterActivity.getPackageManager()) != null) {
                iPHunterActivity.startActivity(intent);
            } else {
                Toast.makeText(iPHunterActivity.getApplicationContext(), uh.a(-65391608102174L), 0).show();
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            IPHunterActivity.this.finish();
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            IPHunterActivity.this.finish();
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class g extends TimerTask {

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPHunterActivity.this.A.setText(mc1.h());
            }
        }

        public g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            IPHunterActivity.this.runOnUiThread(new a());
        }
    }

    public final void K(String str) {
        this.q.add(str);
        this.r.notifyDataSetChanged();
    }

    public final void L() {
        Intent intent;
        long j;
        Handler handler = this.o;
        a aVar = this.s;
        handler.removeCallbacks(aVar);
        this.v.setEnabled(!this.u);
        this.w.setEnabled(!this.u);
        String strH = mc1.h();
        if (this.u) {
            NetworkInfo activeNetworkInfo = this.t.getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            String[] strArrSplit = this.j.getText().toString().split(uh.a(-65889824308510L));
            StringBuilder sb = new StringBuilder();
            for (String str : strArrSplit) {
                sb.append(uh.a(-65898414243102L));
                sb.append(Pattern.quote(str));
                sb.append(uh.a(-65907004177694L));
                sb.toString().replace(uh.a(-65915594112286L), uh.a(-65924184046878L));
            }
            if (Pattern.compile(sb.substring(0, sb.length() - 1)).matcher(strH).find()) {
                this.u = false;
                this.v.setEnabled(true);
                this.n.setText(uh.a(-65937068948766L));
                handler.removeCallbacks(aVar);
                H(uh.a(-65962838752542L) + strH + uh.a(-66010083392798L));
                K(uh.a(-66074507902238L) + strH + uh.a(-66117457575198L));
            } else {
                if (z) {
                    K(uh.a(-66181882084638L).concat(strH));
                    K(uh.a(-66203356921118L));
                    intent = new Intent(this, (Class<?>) IPHunterInteractionService.class);
                    j = -66448170056990L;
                } else {
                    K(uh.a(-66323616005406L));
                    intent = new Intent(this, (Class<?>) IPHunterInteractionService.class);
                    j = -66572724108574L;
                }
                startService(intent.setAction(uh.a(j)));
            }
        }
        handler.postDelayed(aVar, Long.parseLong(this.y));
    }

    @Override // renz.javacodez.vpn.activities.d, androidx.fragment.app.n, androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.c_);
        getSupportActionBar().m(true);
        Thread.setDefaultUncaughtExceptionHandler(new wr(this));
        this.t = (ConnectivityManager) getSystemService(uh.a(-65627831303454L));
        this.A = (TextView) findViewById(R.attr.nw);
        this.j = (EditText) findViewById(R.attr.nx);
        this.n = (Button) findViewById(R.attr.zi);
        this.p = (RecyclerView) findViewById(R.attr.nt);
        this.v = findViewById(R.attr.nv);
        this.w = (Spinner) findViewById(R.attr.z0);
        String[] stringArray = getResources().getStringArray(R.array.b);
        this.x = stringArray;
        this.y = stringArray[this.w.getSelectedItemPosition()];
        this.w.setOnItemSelectedListener(new b());
        ArrayList<String> arrayList = new ArrayList<>();
        this.q = arrayList;
        this.r = new y2(this, arrayList);
        this.p.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView = this.p;
        recyclerView.mHasFixedSize = true;
        recyclerView.setAdapter(this.r);
        this.n.setOnClickListener(new c());
    }

    @Override // defpackage.w4, androidx.fragment.app.n, android.app.Activity
    public final void onDestroy() {
        Timer timer = this.z;
        if (timer != null) {
            timer.cancel();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.n, android.app.Activity
    public final void onResume() {
        androidx.appcompat.app.e.a aVar;
        String string;
        NetworkInfo activeNetworkInfo = this.t.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() != 0) {
            H(uh.a(-66701573127454L));
            finish();
            super.onResume();
        }
        if (Build.VERSION.SDK_INT >= 30) {
            int i = mc1.$r8$clinit;
            boolean z = false;
            ComponentName componentName = null;
            try {
                Method declaredMethod = UserHandle.class.getDeclaredMethod(uh.a(-149332448935198L), null);
                declaredMethod.setAccessible(true);
                Integer num = (Integer) declaredMethod.invoke(null, null);
                if (num != null) {
                    Object objNewInstance = Class.forName(uh.a(-149371103640862L)).getConstructor(Context.class).newInstance(this);
                    Method declaredMethod2 = objNewInstance.getClass().getDeclaredMethod(uh.a(-149530017430814L), Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    componentName = (ComponentName) declaredMethod2.invoke(objNewInstance, num);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (componentName != null && componentName.getPackageName().equals(getPackageName())) {
                z = true;
            }
            if (!((z || (string = Settings.Secure.getString(getContentResolver(), uh.a(-149641686580510L))) == null || !string.startsWith(getPackageName())) ? z : true)) {
                aVar = new androidx.appcompat.app.e.a(this);
                String strA = uh.a(-66950681230622L);
                AlertController.b bVar = aVar.P;
                bVar.e = strA;
                bVar.g = uh.a(-67096710118686L);
                aVar.setPositiveButton(uh.a(-67762430049566L), new d());
                String strA2 = uh.a(-67822559591710L);
                e eVar = new e();
                bVar.k = strA2;
                bVar.m = eVar;
            }
            Timer timer = new Timer();
            this.z = timer;
            timer.scheduleAtFixedRate(new g(), 0L, 1000L);
            super.onResume();
        }
        aVar = new androidx.appcompat.app.e.a(this);
        String strA3 = uh.a(-67852624362782L);
        AlertController.b bVar2 = aVar.P;
        bVar2.e = strA3;
        bVar2.g = uh.a(-67955703577886L);
        aVar.setPositiveButton(uh.a(-68677258083614L), new f());
        aVar.setCancelable();
        aVar.create().show();
        Timer timer2 = new Timer();
        this.z = timer2;
        timer2.scheduleAtFixedRate(new g(), 0L, 1000L);
        super.onResume();
    }
}
