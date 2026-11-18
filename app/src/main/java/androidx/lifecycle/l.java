package androidx.lifecycle;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import defpackage.pq;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class l extends pq {
    public final /* synthetic */ k this$0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends pq {
        public final /* synthetic */ k this$0;

        public a(k kVar) {
            this.this$0 = kVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPostResumed(Activity activity) {
            this.this$0.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPostStarted(Activity activity) {
            k kVar = this.this$0;
            int i = kVar.b + 1;
            kVar.b = i;
            if (i == 1 && kVar.f) {
                kVar.i.f(e.a.ON_START);
                kVar.f = false;
            }
        }
    }

    public l(k kVar) {
        this.this$0 = kVar;
    }

    @Override // defpackage.pq, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 29) {
            int i = m.$r8$clinit;
            ((m) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag")).b = this.this$0.n;
        }
    }

    @Override // defpackage.pq, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        k kVar = this.this$0;
        int i = kVar.c - 1;
        kVar.c = i;
        if (i == 0) {
            kVar.g.postDelayed(kVar.j, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.registerActivityLifecycleCallbacks(new a(this.this$0));
    }

    @Override // defpackage.pq, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        k kVar = this.this$0;
        int i = kVar.b - 1;
        kVar.b = i;
        if (i == 0 && kVar.d) {
            kVar.i.f(e.a.ON_STOP);
            kVar.f = true;
        }
    }
}
