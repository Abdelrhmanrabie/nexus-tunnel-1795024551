package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class sl0 {
    public final Service a;
    public CharSequence e;
    public CharSequence f;
    public PendingIntent g;
    public int j;
    public g l;
    public Bundle n;
    public final String q;
    public final boolean r;
    public final Notification s;
    public final ArrayList t;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public boolean k = true;

    public sl0(Service service, String str) {
        Notification notification = new Notification();
        this.s = notification;
        this.a = service;
        this.q = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.j = 0;
        this.t = new ArrayList();
        this.r = true;
    }

    public static CharSequence c(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final void a(int i, String str, PendingIntent pendingIntent) {
        this.b.add(new pl0(i == 0 ? null : IconCompat.b(i), str, pendingIntent, new Bundle()));
    }

    public final Notification b() {
        Bundle bundle;
        m6 m6Var = new m6(this);
        Notification.Builder builder = (Notification.Builder) m6Var.a;
        sl0 sl0Var = (sl0) m6Var.b;
        g gVar = sl0Var.l;
        if (gVar != null) {
            new Notification.BigTextStyle(builder).setBigContentTitle(null).bigText((CharSequence) gVar.b);
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 26 && i < 24) {
            builder.setExtras((Bundle) m6Var.c);
        }
        Notification notificationBuild = builder.build();
        if (gVar != null) {
            sl0Var.l.getClass();
        }
        if (gVar != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
        }
        return notificationBuild;
    }

    public final void g(g gVar) {
        if (this.l != gVar) {
            this.l = gVar;
            if (((sl0) gVar.a) != this) {
                gVar.a = this;
                g(gVar);
            }
        }
    }
}
