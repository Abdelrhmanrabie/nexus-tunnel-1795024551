package defpackage;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ui {
    public static final int[] a = {R.attr.interpolator, R.attr.duration, R.attr.startDelay, R.attr.matchOrder};
    public static final int[] b = {R.attr.transitionVisibilityMode};

    public static Intent a(w4 w4Var) {
        Intent parentActivityIntent = w4Var.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String strC = c(w4Var, w4Var.getComponentName());
            if (strC == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(w4Var, strC);
            try {
                return c(w4Var, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static final cn.d a(ur0 ur0Var) {
        int i = ur0Var == null ? -1 : xr0$a.b[ur0Var.ordinal()];
        if (i == 1) {
            return cn.d;
        }
        if (i == 3) {
            return cn.b;
        }
        if (i == 4) {
            return cn.c;
        }
        if (i != 5) {
            return i != 6 ? cn.a : cn.f;
        }
        return cn.e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r3 <= r4) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.v9 a(defpackage.cv r7, defpackage.gi0 r8, java.io.InputStream r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "Kotlin built-in definition format version is not supported: expected "
            r9 r1 = defpackage.r9.f     // Catch: java.lang.Throwable -> L40
            r9 r1 = defpackage.e4.a(r9)     // Catch: java.lang.Throwable -> L40
            r9 r2 = defpackage.r9.f     // Catch: java.lang.Throwable -> L40
            int r3 = r1.c     // Catch: java.lang.Throwable -> L40
            int r4 = r2.c     // Catch: java.lang.Throwable -> L40
            int r5 = r2.b     // Catch: java.lang.Throwable -> L40
            int r6 = r1.b     // Catch: java.lang.Throwable -> L40
            if (r6 != 0) goto L19
            if (r5 != 0) goto L46
            if (r3 != r4) goto L46
            goto L1d
        L19:
            if (r6 != r5) goto L46
            if (r3 > r4) goto L46
        L1d:
            q9 r0 = defpackage.q9.m     // Catch: java.lang.Throwable -> L40
            ps r0 = r0.a     // Catch: java.lang.Throwable -> L40
            ar0$a r2 = defpackage.jr0.q     // Catch: java.lang.Throwable -> L40
            r2.getClass()     // Catch: java.lang.Throwable -> L40
            xd r2 = new xd     // Catch: java.lang.Throwable -> L40
            r2.<init>(r9)     // Catch: java.lang.Throwable -> L40
            jr0 r3 = new jr0     // Catch: java.lang.Throwable -> L40
            r3.<init>(r2, r0)     // Catch: java.lang.Throwable -> L40
            r0 = 0
            r2.a(r0)     // Catch: java.lang.Throwable -> L40 defpackage.t30 -> L42
            ar0.a.b(r3)     // Catch: java.lang.Throwable -> L40
            r9.close()
            v9 r9 = new v9
            r9.<init>(r7, r8, r3, r1)
            return r9
        L40:
            r7 = move-exception
            goto L65
        L42:
            r7 = move-exception
            r7.b = r3     // Catch: java.lang.Throwable -> L40
            throw r7     // Catch: java.lang.Throwable -> L40
        L46:
            java.lang.UnsupportedOperationException r7 = new java.lang.UnsupportedOperationException     // Catch: java.lang.Throwable -> L40
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L40
            r8.append(r2)     // Catch: java.lang.Throwable -> L40
            java.lang.String r0 = ", actual "
            r8.append(r0)     // Catch: java.lang.Throwable -> L40
            r8.append(r1)     // Catch: java.lang.Throwable -> L40
            java.lang.String r0 = ". Please update Kotlin"
            r8.append(r0)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L40
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L40
            throw r7     // Catch: java.lang.Throwable -> L40
        L65:
            throw r7     // Catch: java.lang.Throwable -> L66
        L66:
            r8 = move-exception
            defpackage.e.F0(r9, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ui.a(cv, gi0, java.io.InputStream):v9");
    }

    public static xg0 a(ak akVar) {
        if (akVar instanceof p80$b) {
            p80$b p80_b = (p80$b) akVar;
            return new xg0(e4.j(p80_b.a, p80_b.b));
        }
        if (!(akVar instanceof p80$a)) {
            d.AnonymousClass0.m();
            return null;
        }
        p80$a p80_a = (p80$a) akVar;
        return new xg0(p80_a.a + '#' + p80_a.b);
    }

    public static final xh a(li liVar) {
        if (liVar.a(e.b$1) == null) {
            liVar = liVar.y(new f70());
        }
        return new xh(liVar);
    }

    public static void a(int i, int i2, int i3) {
        if (i >= 0 && i2 <= i3) {
            if (i > i2) {
                throw new IllegalArgumentException(ak.i(i, i2, "fromIndex: ", " > toIndex: "));
            }
            return;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
    }

    public static void a(Throwable th) {
        if (!(th instanceof ym0) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof wf)) {
            th = new ob1("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | " + th, th);
        }
        th.printStackTrace();
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    public static final la.a b(gr0 gr0Var) {
        int i = gr0Var == null ? -1 : xr0$a.a[gr0Var.ordinal()];
        la.a aVar = la.a.b;
        if (i != 1) {
            if (i == 2) {
                return la.a.c;
            }
            if (i == 3) {
                return la.a.d;
            }
            if (i == 4) {
                return la.a.f;
            }
        }
        return aVar;
    }

    public static String c(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        int i;
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            i = 269222528;
        } else {
            i = i2 >= 24 ? 787072 : 640;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }
}
