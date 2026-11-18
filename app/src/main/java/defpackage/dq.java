package defpackage;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.a;
import androidx.emoji2.text.c;
import androidx.emoji2.text.d;
import androidx.emoji2.text.f;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import renz.javacodez.vpn.activities.HamoTunnelPlusMain;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dq implements Runnable {
    public final /* synthetic */ int G0;
    public final Object b;
    public final Object c;
    public final Object d;

    public /* synthetic */ dq(Object obj, Object obj2, Object obj3, int i) {
        this.G0 = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public /* synthetic */ dq(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.G0 = i;
        this.b = obj2;
        this.c = obj3;
        this.d = obj;
    }

    private final void run$com$android$volley$ExecutorDelivery$ResponseDeliveryRunnable() {
        HamoTunnelPlusMain.p pVar;
        ((StringRequest) this.b).isCanceled();
        Response response = (Response) this.c;
        VolleyError volleyError = (VolleyError) response.error;
        boolean z = volleyError == null;
        StringRequest stringRequest = (StringRequest) this.b;
        if (z) {
            String str = (String) response.result;
            stringRequest.getClass();
            synchronized (stringRequest.mLock) {
                pVar = stringRequest.mListener;
            }
            if (pVar != null) {
                pVar.onResponse(str);
            }
        } else {
            stringRequest.deliverError(volleyError);
        }
        boolean z2 = ((Response) this.c).intermediate;
        StringRequest stringRequest2 = (StringRequest) this.b;
        if (z2) {
            stringRequest2.addMarker("intermediate-response");
        } else {
            stringRequest2.finish("done");
        }
        Runnable runnable = (Runnable) this.d;
        if (runnable != null) {
            runnable.run();
        }
    }

    private final void run$dq() {
        EmojiCompatInitializer.b bVar = (EmojiCompatInitializer.b) this.b;
        c.h hVar = (c.h) this.c;
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.d;
        try {
            f fVarA = a.a(bVar.a);
            if (fVarA == null) {
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            }
            f.b bVar2 = (f.b) fVarA.a;
            synchronized (bVar2.d) {
                bVar2.f = threadPoolExecutor;
            }
            fVarA.a.a(new d(hVar, threadPoolExecutor));
        } catch (Throwable th) {
            hVar.a(th);
            threadPoolExecutor.shutdown();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        long jElapsedRealtime;
        int i = this.G0;
        if (i == 0) {
            run$dq();
            return;
        }
        if (i == 1) {
            run$com$android$volley$ExecutorDelivery$ResponseDeliveryRunnable();
            return;
        }
        if (i == 2) {
            try {
                objCall = ((qu) this.b).call();
            } catch (Exception unused) {
                objCall = null;
            }
            ((Handler) this.d).post(new f2((ru) this.c, objCall, 5, false));
            return;
        }
        if (((tz) this.d).a.i0.s() == 2 || ((tz) this.d).a.i0.s() == 3 || ((tz) this.d).a.i0.s() == 1 || ((tz) this.d).a.i0.s() == 4) {
            ((tz) this.d).a.o.setText((String) this.b);
            ((tz) this.d).a.p.setText((String) this.c);
            HamoTunnelPlusMain hamoTunnelPlusMain = ((tz) this.d).a;
            TextView textView = hamoTunnelPlusMain.x;
            z21$a z21_a = hamoTunnelPlusMain.n0;
            synchronized (z21_a) {
                jElapsedRealtime = SystemClock.elapsedRealtime() - z21_a.b;
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long j = jElapsedRealtime / 3600000;
            TimeUnit timeUnit2 = TimeUnit.HOURS;
            long millis = (jElapsedRealtime - timeUnit2.toMillis(j)) / 60000;
            textView.setText(String.format("%02d:%02d:%02d", Long.valueOf(j), Long.valueOf(millis), Long.valueOf(((jElapsedRealtime - timeUnit2.toMillis(j)) - TimeUnit.MINUTES.toMillis(millis)) / 1000)));
        }
    }
}
