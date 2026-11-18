package renz.javacodez.vpn.activities;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertController;
import defpackage.hk0;
import defpackage.mc1;
import defpackage.p0;
import defpackage.sp;
import defpackage.sy;
import defpackage.tp;
import defpackage.uh;
import defpackage.vp;
import defpackage.w4;
import defpackage.wp;
import defpackage.xp;
import defpackage.yp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import net.lingala.zip4j.ZipFile;
import net.openvpn.ovpn3.ProxyList;
import org.hamotunnelplus.xyz.R;
import org.json.JSONArray;
import org.json.JSONObject;
import renz.javacodez.vpn.service.RenzInjectorService;
import renz.javacodez.vpn.service.RenzOpenVPNservice;
import renz.javacodez.vpn.service.SSHVPNService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class d extends w4 implements RenzInjectorService.c, RenzOpenVPNservice.g, SSHVPNService.e {
    public static RenzInjectorService i;
    public SSHVPNService f;
    public RenzOpenVPNservice b = null;
    public final a c = new a();
    public final b d = new b();
    public final c g = new c();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RenzOpenVPNservice renzOpenVPNservice = RenzOpenVPNservice.this;
            d dVar = d.this;
            dVar.b = renzOpenVPNservice;
            uh.a(-2753805057310L);
            uh.a(-2831114468638L);
            dVar.b.toString();
            dVar.b.c(dVar);
            dVar.B();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            uh.a(-2959963487518L);
            uh.a(-3037272898846L);
            d.this.b = null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RenzInjectorService renzInjectorService = RenzInjectorService.this;
            d.i = renzInjectorService;
            renzInjectorService.n = d.this;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d.i = null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            SSHVPNService sSHVPNService = SSHVPNService.this;
            d dVar = d.this;
            dVar.f = sSHVPNService;
            sSHVPNService.n = dVar;
            dVar.C();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.f = null;
        }
    }

    static {
        uh.a(-11648682327326L);
    }

    public static String E(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            char[] cArr = new char[1024];
            while (true) {
                int i2 = bufferedReader.read(cArr, 0, 1024);
                if (i2 <= 0) {
                    break;
                }
                sb.append(cArr, 0, i2);
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public final void A(String str, String str2, HamoTunnelPlusMain.r rVar) {
        androidx.appcompat.app.e.a aVar = new androidx.appcompat.app.e.a(this);
        AlertController.b bVar = aVar.P;
        bVar.g = str2;
        aVar.setPositiveButton(R.string.kd, new sy(0, rVar));
        if (str != null) {
            bVar.e = str;
        }
        aVar.show();
    }

    public void B() {
    }

    public void C() {
    }

    public final RenzOpenVPNservice.m D() {
        RenzOpenVPNservice renzOpenVPNservice = this.b;
        if (renzOpenVPNservice != null) {
            return renzOpenVPNservice.j();
        }
        return null;
    }

    public final String F(int i2) {
        return getResources().getString(i2);
    }

    public void H(String str) {
        Toast.makeText(this, str, 1).show();
    }

    public final void I() {
        SSHVPNService sSHVPNService = this.f;
        if (sSHVPNService != null) {
            sSHVPNService.h();
        }
        RenzInjectorService renzInjectorService = i;
        if (renzInjectorService != null) {
            renzInjectorService.n();
        }
        J(false);
    }

    public final void J(boolean z) {
        uh.a(-6932808236318L);
        uh.a(-7010117647646L);
        startService(new Intent(this, (Class<?>) RenzOpenVPNservice.class).setAction(uh.a(-6692290067742L)).putExtra(uh.a(-6825434053918L), z));
    }

    public void a(RenzOpenVPNservice.f fVar) {
    }

    public void b(int i2) {
    }

    public void c() {
    }

    public void d(RenzOpenVPNservice.j jVar) {
    }

    public PendingIntent e(int i2) {
        return null;
    }

    public void g() {
    }

    @Override // androidx.fragment.app.n, androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public void onCreate(Bundle bundle) {
        yp tpVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 35) {
            int i3 = sp.a;
            p0 p0Var = p0.b$15;
            hk0 hk0Var = new hk0(0, 0);
            hk0 hk0Var2 = new hk0(sp.a, sp.b);
            View decorView = getWindow().getDecorView();
            boolean zBooleanValue = ((Boolean) p0Var.invoke(decorView.getResources())).booleanValue();
            boolean zBooleanValue2 = ((Boolean) p0Var.invoke(decorView.getResources())).booleanValue();
            if (i2 >= 30) {
                tpVar = new xp(1);
            } else if (i2 >= 29) {
                tpVar = new wp(1);
            } else if (i2 >= 28) {
                tpVar = new vp(1);
            } else {
                tpVar = i2 >= 26 ? new tp(1) : new tp(0);
            }
            yp ypVar = tpVar;
            ypVar.c(hk0Var, hk0Var2, getWindow(), zBooleanValue, zBooleanValue2);
            ypVar.d(getWindow());
        }
        super.onCreate(bundle);
    }

    public final RenzOpenVPNservice.k t() {
        RenzOpenVPNservice renzOpenVPNservice = this.b;
        if (renzOpenVPNservice == null) {
            return null;
        }
        RenzOpenVPNservice.k kVar = renzOpenVPNservice.f;
        if (kVar != null) {
            return kVar;
        }
        RenzOpenVPNservice.m mVarJ = renzOpenVPNservice.j();
        if (mVarJ.size() >= 1) {
            return mVarJ.get(0);
        }
        return null;
    }

    public final void u() {
        uh.a(-4261338578206L);
        uh.a(-4338647989534L);
        RenzOpenVPNservice renzOpenVPNservice = this.b;
        if (renzOpenVPNservice != null) {
            ArrayDeque<RenzOpenVPNservice.g> arrayDeque = renzOpenVPNservice.c;
            arrayDeque.remove(this);
            uh.a(-107443632897310L);
            String.format(uh.a(-107508057406750L), Integer.valueOf(arrayDeque.size()));
            unbindService(this.c);
            this.b = null;
        }
    }

    public final void v(boolean z) {
        RenzOpenVPNservice renzOpenVPNservice = this.b;
        if (renzOpenVPNservice != null) {
            renzOpenVPNservice.h(z ? 16 : 0, uh.a(-108221021977886L), null, null, this);
        }
    }

    public final JSONArray w() {
        try {
            return new JSONArray(mc1.b(this, E(new FileInputStream(new File(getFilesDir(), uh.a(-3655748189470L))))));
        } catch (Exception unused) {
            return new JSONArray();
        }
    }

    public final JSONObject x() {
        File file = new File(getFilesDir(), uh.a(-3578438778142L));
        try {
            if (!file.exists()) {
                return new JSONObject(mc1.b(this, E(getResources().openRawResource(R.raw.f))));
            }
            ZipFile zipFile = new ZipFile(file);
            return new JSONObject(mc1.b(this, E(zipFile.getInputStream(zipFile.getFileHeader(uh.a(-3629978385694L))))));
        } catch (Exception unused) {
            return null;
        }
    }

    public final ProxyList y() {
        RenzOpenVPNservice renzOpenVPNservice = this.b;
        if (renzOpenVPNservice != null) {
            return renzOpenVPNservice.w;
        }
        return null;
    }

    public final boolean z() {
        RenzOpenVPNservice renzOpenVPNservice = this.b;
        return renzOpenVPNservice != null && renzOpenVPNservice.b;
    }
}
