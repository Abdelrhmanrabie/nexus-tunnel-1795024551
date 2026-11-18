package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import defpackage.b2;
import defpackage.cg;
import defpackage.ha;
import defpackage.jf;
import defpackage.pu;
import defpackage.xu;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class f extends c.AbstractC0013c {
    public static final a d = new a();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b implements c.g {
        public final Context a;
        public final pu b;
        public final a c;
        public final Object d;
        public ThreadPoolExecutor f;
        public ThreadPoolExecutor g;
        public c.h h;

        public b(Context context, pu puVar) {
            a aVar = f.d;
            this.d = new Object();
            if (context == null) {
                defpackage.d.AnonymousClass0.m$1("Context cannot be null");
                throw null;
            }
            this.a = context.getApplicationContext();
            this.b = puVar;
            this.c = aVar;
        }

        @Override // androidx.emoji2.text.c.g
        public final void a(c.h hVar) {
            synchronized (this.d) {
                this.h = hVar;
            }
            c();
        }

        public final void b() {
            synchronized (this.d) {
                try {
                    this.h = null;
                    ThreadPoolExecutor threadPoolExecutor = this.g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f = null;
                    this.g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void c() {
            synchronized (this.d) {
                try {
                    if (this.h != null) {
                        if (this.f == null) {
                            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new cg("emojiCompat"));
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                            this.g = threadPoolExecutor;
                            this.f = threadPoolExecutor;
                        }
                        this.f.execute(new jf(this, 2, 0));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final xu d() {
            try {
                a aVar = this.c;
                Context context = this.a;
                pu puVar = this.b;
                aVar.getClass();
                ha haVarA = b2.a(context, puVar);
                int i = haVarA.b;
                if (i != 0) {
                    throw new RuntimeException(defpackage.e.i(i, "fetchFonts failed (", ")"));
                }
                xu[] xuVarArr = (xu[]) haVarA.a;
                if (xuVarArr == null || xuVarArr.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return xuVarArr[0];
            } catch (PackageManager.NameNotFoundException e) {
                defpackage.d.AnonymousClass0.m$1("provider not found", (Throwable) e);
                return null;
            }
        }
    }

    public f(Context context, pu puVar) {
        super(new b(context, puVar));
    }
}
