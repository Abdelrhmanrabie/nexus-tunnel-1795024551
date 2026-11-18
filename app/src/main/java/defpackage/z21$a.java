package defpackage;

import android.os.SystemClock;
import java.util.ArrayList;
import net.lingala.zip4j.util.InternalZipConstants;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class z21$a {
    public boolean a;
    public long b;
    public ArrayList c;
    public long d;
    public ArrayList e;
    public long f;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public long a = 0;
    }

    public static String b(long j, boolean z) {
        int i = z ? InternalZipConstants.AES_HASH_ITERATIONS : 1024;
        if (j < i) {
            return j + " B";
        }
        double d = j;
        double d2 = i;
        int iLog = (int) (Math.log(d) / Math.log(d2));
        StringBuilder sb = new StringBuilder();
        sb.append((z ? "kMGTPE" : "KMGTPE").charAt(iLog - 1));
        sb.append(z ? AppConfig.CUSTOM : "i");
        return String.format("%.1f %sB", Double.valueOf(d / Math.pow(d2, iLog)), sb.toString());
    }

    public static void d(long j, long j2, ArrayList arrayList) {
        for (int i = 0; i < (j / j2) + 1; i++) {
            arrayList.add(arrayList.size(), new a());
            if (arrayList.size() >= 24) {
                arrayList.remove(0);
            }
        }
    }

    public final synchronized void a(long j) {
        c();
        ArrayList arrayList = this.c;
        ((a) arrayList.get(arrayList.size() - 1)).a += j;
        ArrayList arrayList2 = this.e;
        ((a) arrayList2.get(arrayList2.size() - 1)).a += j;
    }

    public final void c() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.d;
        if (j >= 300000) {
            d(j, 300000L, this.c);
            this.d = (jElapsedRealtime / 300000) * 300000;
        }
        long j2 = jElapsedRealtime - this.f;
        if (j2 >= 1000) {
            d(j2, 1000L, this.e);
            this.f = (jElapsedRealtime / 1000) * 1000;
        }
    }

    public final synchronized void e() {
        try {
            this.a = false;
            this.b = 0L;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.d = (jElapsedRealtime / 300000) * 300000;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 24; i++) {
                arrayList.add(new a());
            }
            this.c = arrayList;
            this.f = (jElapsedRealtime / 1000) * 1000;
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 24; i2++) {
                arrayList2.add(new a());
            }
            this.e = arrayList2;
        } catch (Throwable th) {
            throw th;
        }
    }
}
