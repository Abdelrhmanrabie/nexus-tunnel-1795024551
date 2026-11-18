package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import defpackage.pq;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class a extends pq {
        @Override // defpackage.pq, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            int i = m.$r8$clinit;
            m.b.b(activity);
        }
    }
}
