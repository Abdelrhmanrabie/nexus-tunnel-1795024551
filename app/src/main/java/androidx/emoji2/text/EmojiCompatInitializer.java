package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import androidx.lifecycle.ProcessLifecycleInitializer;
import defpackage.cg;
import defpackage.dq;
import defpackage.e20;
import defpackage.el;
import defpackage.he0;
import defpackage.m6;
import defpackage.t71;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements e20 {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends androidx.emoji2.text.c.AbstractC0013c {
        public a(Context context) {
            super(new b(context));
            this.b = 1;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b implements androidx.emoji2.text.c.g {
        public final Context a;

        public b(Context context) {
            this.a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.c.g
        public final void a(androidx.emoji2.text.c.h hVar) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new cg("EmojiCompatInitializer"));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            threadPoolExecutor.execute(new dq(this, hVar, threadPoolExecutor, 0));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                int i = t71.$r8$clinit;
                Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (androidx.emoji2.text.c.j != null) {
                    androidx.emoji2.text.c.a().c();
                }
            } finally {
                int i2 = t71.$r8$clinit;
                Trace.endSection();
            }
        }
    }

    @Override // defpackage.e20
    public final Object a(Context context) {
        a aVar = new a(context);
        if (androidx.emoji2.text.c.j == null) {
            synchronized (androidx.emoji2.text.c.i) {
                try {
                    if (androidx.emoji2.text.c.j == null) {
                        androidx.emoji2.text.c.j = new androidx.emoji2.text.c(aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        c(context);
        return Boolean.TRUE;
    }

    public final void c(Context context) {
        Object objB;
        m6 m6VarC = m6.c(context);
        m6VarC.getClass();
        synchronized (m6.e) {
            try {
                objB = ((HashMap) m6VarC.a).get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = m6VarC.b(new HashSet(), ProcessLifecycleInitializer.class);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        final androidx.lifecycle.e lifecycle = ((he0) objB).getLifecycle();
        lifecycle.a(new el() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // defpackage.el
            public final void onResume() {
                EmojiCompatInitializer.this.getClass();
                (Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new c(), 500L);
                lifecycle.c(this);
            }
        });
    }

    @Override // defpackage.e20
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
