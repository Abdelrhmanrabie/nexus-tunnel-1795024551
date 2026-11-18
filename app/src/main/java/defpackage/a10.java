package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class a10 {
    static {
        Object aVar;
        try {
            aVar = new y00(a(Looper.getMainLooper()), false);
        } catch (Throwable th) {
            aVar = new bw0.a(th);
        }
        if (aVar instanceof bw0.a) {
            aVar = null;
        }
    }

    public static final Handler a(Looper looper) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        if (Build.VERSION.SDK_INT >= 28) {
            objNewInstance = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        } else {
            try {
                objNewInstance = Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        return (Handler) objNewInstance;
    }
}
