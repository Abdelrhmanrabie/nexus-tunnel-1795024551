package renz.javacodez.vpn.wifitethering;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.e;
import androidx.appcompat.widget.Toolbar;
import defpackage.w4;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class MainActivityWifi extends w4 implements View.OnClickListener, ServiceConnection, CompoundButton.OnCheckedChangeListener {
    public renz.javacodez.vpn.wifitethering.a b = null;
    public TextView c;
    public Switch d;
    public TextView f;
    public SharedPreferences g;
    public SharedPreferences.Editor i;
    public Notification.Builder j;
    public NotificationManager n;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.d.setText(getString(z ? R.string.dj : R.string.a4));
        this.d.setTextColor(getResources().getColor(z ? R.color.az : R.color.b9));
        this.i.putBoolean("proxy_enable", z).apply();
        t();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        int id = view.getId();
        if (id != R.attr.bx) {
            if (id == R.attr.by) {
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.TetherSettings"));
                intent.setFlags(268435456);
                startActivity(intent);
                return;
            }
            return;
        }
        TextView textView = new TextView(this);
        StringBuilder sb = new StringBuilder("Proxy Hostname : ");
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        string = inetAddressNextElement.getHostAddress().toString();
                        sb.append(string);
                        sb.append("\nProxy Port : 8080");
                        textView.setText(sb.toString());
                        textView.setTextIsSelectable(true);
                        textView.setTextSize(15.0f);
                        e.a aVar = new e.a(this);
                        AlertController.b bVar = aVar.P;
                        bVar.e = "Long click to copy";
                        bVar.y = textView;
                        bVar.D = true;
                        bVar.z = 60;
                        bVar.B = 60;
                        aVar.setPositiveButton("OK", new a());
                        aVar.show();
                    }
                }
            }
            string = "No IP Available";
        } catch (SocketException unused) {
            string = "ERROR Obtaining IP";
        }
        sb.append(string);
        sb.append("\nProxy Port : 8080");
        textView.setText(sb.toString());
        textView.setTextIsSelectable(true);
        textView.setTextSize(15.0f);
        e.a aVar2 = new e.a(this);
        AlertController.b bVar2 = aVar2.P;
        bVar2.e = "Long click to copy";
        bVar2.y = textView;
        bVar2.D = true;
        bVar2.z = 60;
        bVar2.B = 60;
        aVar2.setPositiveButton("OK", new a());
        aVar2.show();
    }

    @Override // androidx.fragment.app.n, androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Resources resources;
        int i;
        super.onCreate(bundle);
        this.n = (NotificationManager) getSystemService("notification");
        Notification.Builder builder = new Notification.Builder(this);
        this.j = builder;
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId(getPackageName() + ".SHV");
            NotificationManager notificationManager = this.n;
            NotificationChannel notificationChannel = new NotificationChannel(getPackageName() + ".SHV", getString(R.string.app), 4);
            notificationChannel.setShowBadge(true);
            notificationChannel.enableLights(true);
            notificationChannel.shouldShowLights();
            notificationChannel.setLightColor(-16711936);
            notificationChannel.setLockscreenVisibility(1);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("proxy_pref", 0);
        this.g = sharedPreferences;
        this.i = sharedPreferences.edit();
        setContentView(R.layout.an);
        setSupportActionBar((Toolbar) findViewById(R.attr.a1s));
        getSupportActionBar().m(true);
        this.c = (TextView) findViewById(R.attr.a28);
        Switch r6 = (Switch) findViewById(R.attr.ek);
        this.d = r6;
        r6.setOnCheckedChangeListener(this);
        this.d.setPadding(20, 0, 0, 0);
        this.d.setText(getString(this.g.getBoolean("proxy_enable", false) ? R.string.dj : R.string.a4));
        Switch r7 = this.d;
        if (this.g.getBoolean("proxy_enable", false)) {
            resources = getResources();
            i = R.color.az;
        } else {
            resources = getResources();
            i = R.color.b9;
        }
        r7.setTextColor(resources.getColor(i));
        ((Button) findViewById(R.attr.by)).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.attr.bx);
        this.f = textView;
        textView.setOnClickListener(this);
        this.f.setText("Click Here");
        bindService(new Intent(this, (Class<?>) ProxyService.class), this, 1);
    }

    @Override // defpackage.w4, androidx.fragment.app.n, android.app.Activity
    public final void onDestroy() {
        unbindService(this);
        super.onDestroy();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        renz.javacodez.vpn.wifitethering.a aVar = (renz.javacodez.vpn.wifitethering.a) iBinder;
        this.b = aVar;
        if (aVar != null) {
            t();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.b = null;
    }

    @Override // defpackage.w4
    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public final void t() {
        boolean zIsRunning;
        boolean zStop;
        Resources resources;
        int i;
        boolean zStart;
        renz.javacodez.vpn.wifitethering.a aVar = this.b;
        if (aVar == null) {
            return;
        }
        try {
            zIsRunning = aVar.isRunning();
        } catch (RemoteException e) {
            e.printStackTrace();
            zIsRunning = false;
        }
        boolean z = this.g.getBoolean("proxy_enable", false);
        if (z && !zIsRunning) {
            try {
                zStart = this.b.start();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                zStart = false;
            }
            if (zStart) {
                this.j.setContentTitle(getString(R.string.app));
                this.j.setSmallIcon(R.drawable.ic_app_icon);
                this.j.setDefaults(-1);
                this.j.setPriority(1);
                this.j.setContentText(getResources().getString(R.string.pz));
                this.j.setTicker(getResources().getString(R.string.ml));
                this.j.setStyle(new Notification.BigTextStyle().bigText(getResources().getString(R.string.pz)));
                this.j.setOngoing(true);
                this.j.setOnlyAlertOnce(true);
                this.j.setUsesChronometer(true);
                this.j.setVisibility(1);
                Notification.Builder builder = this.j;
                int i2 = Build.VERSION.SDK_INT >= 31 ? 67108864 : 0;
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(this, (Class<?>) MainActivityWifi.class));
                intent.addFlags(131072);
                builder.setContentIntent(PendingIntent.getActivity(this, 0, intent, i2));
                this.n.notify(637504782, this.j.getNotification());
                resources = getResources();
                i = R.string.ms;
                Toast.makeText(this, resources.getString(i), 0).show();
            }
        } else if (!z && zIsRunning) {
            try {
                zStop = this.b.stop();
            } catch (RemoteException e3) {
                e3.printStackTrace();
                zStop = false;
            }
            if (zStop) {
                this.c.setText(R.string.mj);
                this.n.cancel(637504782);
                resources = getResources();
                i = R.string.mt;
                Toast.makeText(this, resources.getString(i), 0).show();
            }
        }
        try {
            zIsRunning = this.b.isRunning();
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
        TextView textView = this.c;
        if (zIsRunning) {
            textView.setText(R.string.ml);
            this.d.setChecked(true);
        } else {
            textView.setText(R.string.mj);
            this.d.setChecked(false);
        }
    }
}
