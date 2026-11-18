package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import defpackage.e20;
import defpackage.m6;
import defpackage.uq;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements e20 {
    @Override // defpackage.e20
    public final Object a(Context context) {
        if (!((HashSet) m6.c(context).b).contains(ProcessLifecycleInitializer.class)) {
            defpackage.d.AnonymousClass0.m("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
            return null;
        }
        if (!g.a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new g.a());
        }
        k kVar = k.o;
        kVar.getClass();
        kVar.g = new Handler();
        kVar.i.f(e.a.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new l(kVar));
        return kVar;
    }

    @Override // defpackage.e20
    public final List dependencies() {
        return uq.b;
    }
}
