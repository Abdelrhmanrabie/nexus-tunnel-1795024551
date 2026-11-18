package defpackage;

import android.content.SharedPreferences;
import android.net.TrafficStats;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class jk {
    public final tz a;
    public final z21$a b;
    public final SharedPreferences c;
    public long d;
    public long e;
    public Timer g;
    public boolean f = true;
    public long h = TrafficStats.getTotalRxBytes();
    public long i = TrafficStats.getTotalTxBytes();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            jk jkVar = jk.this;
            if (jkVar.f || jkVar.a == null) {
                return;
            }
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            long totalTxBytes = TrafficStats.getTotalTxBytes();
            System.currentTimeMillis();
            jk jkVar2 = jk.this;
            long j = totalRxBytes - jkVar2.d;
            long j2 = totalTxBytes - jkVar2.e;
            long j3 = totalRxBytes - jkVar2.h;
            long j4 = totalTxBytes - jkVar2.i;
            z21$a z21_a = jkVar2.b;
            synchronized (z21_a) {
                z21_a.c();
                ArrayList arrayList = z21_a.c;
                ((z21$a.a) arrayList.get(arrayList.size() - 1)).getClass();
                ArrayList arrayList2 = z21_a.e;
                ((z21$a.a) arrayList2.get(arrayList2.size() - 1)).getClass();
            }
            jk.this.b.a(j3);
            jk jkVar3 = jk.this;
            jkVar3.h = totalRxBytes;
            jkVar3.i = totalTxBytes;
            String strA = jk.a(j);
            String strA2 = jk.a(j2);
            jkVar3.b.getClass();
            z21$a.b(j3, true);
            z21$a.b(j4, true);
            tz tzVar = jkVar3.a;
            if (tzVar != null) {
                SharedPreferences sharedPreferences = jkVar3.c;
                sharedPreferences.edit().putLong("TOTAL_DOWNLOAD", jkVar3.d).commit();
                sharedPreferences.edit().putLong("TOTAL_UPLOAD", jkVar3.e).commit();
                tzVar.a.runOnUiThread(new dq(tzVar, strA, strA2, 3, false));
            }
        }
    }

    public jk(HamoTunnelPlusMain hamoTunnelPlusMain, tz tzVar) {
        ig.h(hamoTunnelPlusMain);
        this.a = tzVar;
        this.b = bj.b().m3a();
        SharedPreferences sharedPreferences = hamoTunnelPlusMain.getSharedPreferences("DATA_USAGE", 0);
        this.c = sharedPreferences;
        this.d = sharedPreferences.getLong("TOTAL_DOWNLOAD", TrafficStats.getTotalRxBytes());
        this.e = sharedPreferences.getLong("TOTAL_UPLOAD", TrafficStats.getTotalTxBytes());
    }

    public static String a(long j) {
        String str;
        float f;
        float f2 = j;
        if (f2 >= 1.0E12f) {
            str = "TB";
            f = 1.09951163E12f;
        } else if (f2 >= 1.0E9f) {
            str = "GB";
            f = 1.07374182E9f;
        } else if (f2 >= 1000000.0f) {
            str = "MB";
            f = 1048576.0f;
        } else {
            if (f2 < 1000.0f) {
                return String.format("%.0f", Float.valueOf(f2));
            }
            str = "KB";
            f = 1024.0f;
        }
        return String.format("%.2f %s", Float.valueOf(f2 / f), str);
    }

    public final void b() {
        if (this.f) {
            if (this.d == 0 || this.e == 0) {
                long totalRxBytes = TrafficStats.getTotalRxBytes();
                SharedPreferences sharedPreferences = this.c;
                this.d = sharedPreferences.getLong("TOTAL_DOWNLOAD", totalRxBytes);
                this.e = sharedPreferences.getLong("TOTAL_UPLOAD", TrafficStats.getTotalTxBytes());
            }
            Timer timer = new Timer();
            this.g = timer;
            timer.scheduleAtFixedRate(new b(), 0L, 1000L);
            this.f = false;
        }
    }
}
