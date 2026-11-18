package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class uu {
    public static final vf0 a = new vf0(16);
    public static final ThreadPoolExecutor b;
    public static final Object c;
    public static final o01 d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a {
        public final Typeface a;
        public final int b;

        public a(int i) {
            this.a = null;
            this.b = i;
        }

        public a(Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new hv0());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b = threadPoolExecutor;
        c = new Object();
        d = new o01();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0036 A[EDGE_INSN: B:21:0x0036->B:25:0x003e BREAK  A[LOOP:0: B:17:0x002c->B:23:0x003a]] */
    public static a a(String str, Context context, pu puVar, int i) {
        int i2;
        vf0 vf0Var = a;
        Typeface typeface = (Typeface) vf0Var.get(str);
        if (typeface != null) {
            return new a(typeface);
        }
        try {
            ha haVarA = b2.a(context, puVar);
            xu[] xuVarArr = (xu[]) haVarA.a;
            int i3 = haVarA.b;
            int i4 = 1;
            if (i3 != 0) {
                if (i3 != 1) {
                    i2 = -3;
                    break;
                }
                i2 = -2;
            } else {
                if (xuVarArr == null || xuVarArr.length == 0) {
                    i2 = i4;
                    break;
                }
                int length = xuVarArr.length;
                i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        i2 = i4;
                        break;
                    }
                    int i6 = xuVarArr[i5].e;
                    if (i6 != 0) {
                        if (i6 >= 0) {
                            i2 = i6;
                            break;
                        }
                        i2 = -3;
                        break;
                    }
                    i5++;
                }
            }
            if (i2 != 0) {
                return new a(i2);
            }
            Typeface typefaceB = ta1.a.b(context, xuVarArr, i);
            if (typefaceB == null) {
                return new a(-3);
            }
            vf0Var.put(str, typefaceB);
            return new a(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new a(-1);
        }
    }
}
