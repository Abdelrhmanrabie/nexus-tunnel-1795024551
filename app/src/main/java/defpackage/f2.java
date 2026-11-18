package defpackage;

import android.app.Application;
import android.graphics.Typeface;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import com.android.volley.CacheDispatcher;
import com.android.volley.toolbox.StringRequest;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class f2 implements Runnable {
    public final /* synthetic */ int G0;
    public Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ f2(int i, Object obj, Object obj2) {
        this.G0 = i;
        this.c = obj;
        this.b = obj2;
    }

    public /* synthetic */ f2(Object obj, Object obj2, int i, boolean z) {
        this.G0 = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        le0 le0Var;
        int i = 0;
        switch (this.G0) {
            case 0:
                ((i2.a) this.b).b = this.c;
                return;
            case 1:
                ((b81.b) this.b).f = true;
                ((b81.c) this.c).b.remove((b81.b) this.b);
                return;
            case 2:
                try {
                    ((CacheDispatcher) this.b).mNetworkQueue.put((StringRequest) this.c);
                    return;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            case 3:
                ((Application) this.c).unregisterActivityLifecycleCallbacks((i2.a) this.b);
                return;
            case 4:
                try {
                    Method method = i2.d;
                    Object obj = this.b;
                    Object obj2 = this.c;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                        return;
                    } else {
                        i2.e.invoke(obj2, obj, Boolean.FALSE);
                        return;
                    }
                } catch (RuntimeException e) {
                    if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                        throw e;
                    }
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            case 5:
                ((ru) this.b).accept(this.c);
                return;
            case 6:
                break;
            case 7:
                ComponentActivity.access$addObserverForBackInvoker((ComponentActivity) this.c, (OnBackPressedDispatcher) this.b);
                return;
            case 8:
                ak akVar = ((ta1.a) this.b).m;
                if (akVar != null) {
                    akVar.onFontRetrieved((Typeface) this.c);
                    return;
                }
                return;
            default:
                ((ak) this.b).onFontRetrieved((Typeface) this.c);
                return;
        }
        do {
            try {
                ((Runnable) this.b).run();
            } catch (Throwable th) {
                b2.a((li) rq.b, th);
            }
            le0Var = (le0) this.c;
            Runnable runnableB = le0Var.B();
            if (runnableB == null) {
                return;
            }
            this.b = runnableB;
            i++;
        } while (i < 16);
        ub1.d.x(le0Var, this);
    }
}
