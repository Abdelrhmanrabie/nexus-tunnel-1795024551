package defpackage;

import android.os.Looper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class yf0 {
    public static final y00 a;

    static {
        String property;
        Object next;
        int i = i51.a;
        y00 y00Var = null;
        try {
            property = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            Boolean.parseBoolean(property);
        }
        try {
            Iterator it = fz0.E(new ug(new ge(5, Arrays.asList(new o3()).iterator()))).iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    ((o3) next).getClass();
                    do {
                        ((o3) it.next()).getClass();
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            if (((o3) next) != null) {
                try {
                    Looper mainLooper = Looper.getMainLooper();
                    if (mainLooper == null) {
                        throw new IllegalStateException("The main looper is not available");
                    }
                    y00Var = new y00(a10.a(mainLooper), false);
                    if (y00Var != null) {
                        a = y00Var;
                        return;
                    }
                } catch (Throwable unused2) {
                }
            }
            d.AnonymousClass0.m("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
