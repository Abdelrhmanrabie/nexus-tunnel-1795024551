package defpackage;

import android.content.Intent;
import android.os.Build;
import java.io.PrintWriter;
import java.io.StringWriter;
import renz.javacodez.vpn.activities.ExceptionActivity;
import renz.javacodez.vpn.activities.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class wr implements Thread.UncaughtExceptionHandler {
    public final d a;

    public wr(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        d dVar = this.a;
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        try {
            Intent intent = new Intent(dVar, (Class<?>) ExceptionActivity.class);
            intent.putExtra("error", "************ APPLICATION ERROR ************\n\n" + stringWriter.toString() + "\n************ DEVICE INFORMATION ***********\nBrand: " + Build.BRAND + "\nDevice: " + Build.DEVICE + "\nModel: " + Build.MODEL + "\nId: " + Build.ID + "\nProduct: " + Build.PRODUCT + "\n\n************ FIRMWARE ************\nSDK: " + Build.VERSION.SDK + "\nRelease: " + Build.VERSION.RELEASE + "\nIncremental: " + Build.VERSION.INCREMENTAL + "\nReport the bug to the Developer Thank you\n");
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            dVar.startActivity(intent);
            dVar.finish();
        } catch (Throwable th2) {
            throw new NoClassDefFoundError(th2.getMessage());
        }
    }
}
