package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import java.util.Random;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dq0 implements Choreographer.FrameCallback {
    public final /* synthetic */ int G0 = 0;
    public final /* synthetic */ Object c;

    public dq0(m6 m6Var) {
        this.c = m6Var;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0052  */
    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    /* JADX WARN: Code duplicated, block: B:21:0x0068  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0082  */
    /* JADX WARN: Code duplicated, block: B:27:0x008a  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:39:0x0121  */
    /* JADX WARN: Code duplicated, block: B:41:0x012c  */
    /* JADX WARN: Code duplicated, block: B:44:0x0147  */
    /* JADX WARN: Code duplicated, block: B:48:0x015e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0164 A[LOOP:1: B:46:0x0156->B:50:0x0164, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x017a  */
    /* JADX WARN: Code duplicated, block: B:83:0x0167 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0172 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0176 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x002f  */
    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        long j2;
        long j3;
        boolean z;
        float f;
        i21 i21Var;
        long j4;
        i21 i21Var2;
        double d;
        float f2;
        long j5;
        float f3;
        i21 i21Var3;
        boolean z2;
        ThreadLocal threadLocal;
        u3 u3Var;
        ArrayList arrayList;
        int iIndexOf;
        int i;
        ArrayList arrayList2;
        int size;
        boolean z3 = false;
        if (this.G0 == 0) {
            (Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new df((Context) this.c, 2, 0), new Random().nextInt(Math.max(InternalZipConstants.AES_HASH_ITERATIONS, 1)) + 5000);
            return;
        }
        qz qzVar = (qz) ((m6) this.c).a;
        qzVar.getClass();
        long jUptimeMillis = SystemClock.uptimeMillis();
        u3 u3Var2 = (u3) qzVar.a;
        long jUptimeMillis2 = SystemClock.uptimeMillis();
        int i2 = 0;
        while (true) {
            ArrayList arrayList3 = u3Var2.b;
            if (i2 >= arrayList3.size()) {
                if (u3Var2.e) {
                    int size2 = arrayList3.size();
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        } else if (arrayList3.get(size2) == null) {
                            arrayList3.remove(size2);
                        }
                    }
                    u3Var2.e = false;
                }
                if (arrayList3.size() > 0) {
                    if (u3Var2.d == null) {
                        u3Var2.d = new m6(u3Var2.c);
                    }
                    m6 m6Var = u3Var2.d;
                    ((Choreographer) m6Var.b).postFrameCallback((dq0) m6Var.c);
                    return;
                }
                return;
            }
            h21 h21Var = (h21) arrayList3.get(i2);
            if (h21Var == null) {
                j4 = jUptimeMillis;
            } else {
                o01 o01Var = u3Var2.a;
                Long l = (Long) o01Var.getOrDefault(h21Var, null);
                if (l == null) {
                    j2 = h21Var.h;
                    if (j2 == 0) {
                        h21Var.h = jUptimeMillis;
                        h21Var.b(h21Var.b);
                        j4 = jUptimeMillis;
                    } else {
                        j3 = jUptimeMillis - j2;
                        h21Var.h = jUptimeMillis;
                        z = h21Var.t;
                        f = h21Var.s;
                        if (z) {
                            if (f != Float.MAX_VALUE) {
                                h21Var.r.i = f;
                                h21Var.s = Float.MAX_VALUE;
                            }
                            h21Var.b = (float) h21Var.r.i;
                            h21Var.a = 0.0f;
                            h21Var.t = z3;
                            j4 = jUptimeMillis;
                        } else {
                            i21Var = h21Var.r;
                            j4 = jUptimeMillis;
                            if (f != Float.MAX_VALUE) {
                                double d2 = i21Var.i;
                                j5 = j3 / 2;
                                np$o np_oA = i21Var.a(h21Var.b, h21Var.a, j5);
                                i21 i21Var4 = h21Var.r;
                                i21Var4.i = h21Var.s;
                                h21Var.s = Float.MAX_VALUE;
                                d = np_oA.a;
                                f2 = np_oA.b;
                                i21Var2 = i21Var4;
                            } else {
                                i21Var2 = i21Var;
                                d = h21Var.b;
                                f2 = h21Var.a;
                                j5 = j3;
                            }
                            np$o np_oA2 = i21Var2.a(d, f2, j5);
                            float f4 = np_oA2.a;
                            h21Var.b = f4;
                            h21Var.a = np_oA2.b;
                            float fMax = Math.max(f4, -3.4028235E38f);
                            h21Var.b = fMax;
                            float fMin = Math.min(fMax, Float.MAX_VALUE);
                            h21Var.b = fMin;
                            f3 = h21Var.a;
                            i21Var3 = h21Var.r;
                            i21Var3.getClass();
                            if (Math.abs(f3) < i21Var3.e) {
                            }
                            z2 = false;
                            float fMin2 = Math.min(h21Var.b, Float.MAX_VALUE);
                            h21Var.b = fMin2;
                            float fMax2 = Math.max(fMin2, -3.4028235E38f);
                            h21Var.b = fMax2;
                            h21Var.b(fMax2);
                            if (z2) {
                                h21Var.f = false;
                                threadLocal = u3.f;
                                if (threadLocal.get() == null) {
                                    threadLocal.set(new u3());
                                }
                                u3Var = (u3) threadLocal.get();
                                u3Var.a.remove(h21Var);
                                arrayList = u3Var.b;
                                iIndexOf = arrayList.indexOf(h21Var);
                                if (iIndexOf >= 0) {
                                    arrayList.set(iIndexOf, null);
                                    u3Var.e = true;
                                }
                                h21Var.h = 0L;
                                h21Var.c = false;
                                i = 0;
                                while (true) {
                                    arrayList2 = h21Var.j;
                                    if (i < arrayList2.size()) {
                                        size = arrayList2.size();
                                        while (true) {
                                            size--;
                                            if (size >= 0) {
                                                if (arrayList2.get(size) == null) {
                                                    arrayList2.remove(size);
                                                }
                                            }
                                        }
                                    } else {
                                        if (arrayList2.get(i) == null) {
                                            arrayList2.get(i).getClass();
                                            d.AnonymousClass0.m$1();
                                            return;
                                        }
                                        i++;
                                    }
                                }
                            } else {
                                continue;
                            }
                        }
                        z2 = true;
                        float fMin3 = Math.min(h21Var.b, Float.MAX_VALUE);
                        h21Var.b = fMin3;
                        float fMax3 = Math.max(fMin3, -3.4028235E38f);
                        h21Var.b = fMax3;
                        h21Var.b(fMax3);
                        if (z2) {
                            h21Var.f = false;
                            threadLocal = u3.f;
                            if (threadLocal.get() == null) {
                                threadLocal.set(new u3());
                            }
                            u3Var = (u3) threadLocal.get();
                            u3Var.a.remove(h21Var);
                            arrayList = u3Var.b;
                            iIndexOf = arrayList.indexOf(h21Var);
                            if (iIndexOf >= 0) {
                                arrayList.set(iIndexOf, null);
                                u3Var.e = true;
                            }
                            h21Var.h = 0L;
                            h21Var.c = false;
                            i = 0;
                            while (true) {
                                arrayList2 = h21Var.j;
                                if (i < arrayList2.size()) {
                                    size = arrayList2.size();
                                    while (true) {
                                        size--;
                                        if (size >= 0) {
                                            if (arrayList2.get(size) == null) {
                                                arrayList2.remove(size);
                                            }
                                        }
                                    }
                                } else {
                                    if (arrayList2.get(i) == null) {
                                        arrayList2.get(i).getClass();
                                        d.AnonymousClass0.m$1();
                                        return;
                                    }
                                    i++;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } else if (l.longValue() < jUptimeMillis2) {
                    o01Var.remove(h21Var);
                    j2 = h21Var.h;
                    if (j2 == 0) {
                        h21Var.h = jUptimeMillis;
                        h21Var.b(h21Var.b);
                        j4 = jUptimeMillis;
                    } else {
                        j3 = jUptimeMillis - j2;
                        h21Var.h = jUptimeMillis;
                        z = h21Var.t;
                        f = h21Var.s;
                        if (z) {
                            if (f != Float.MAX_VALUE) {
                                h21Var.r.i = f;
                                h21Var.s = Float.MAX_VALUE;
                            }
                            h21Var.b = (float) h21Var.r.i;
                            h21Var.a = 0.0f;
                            h21Var.t = z3;
                            j4 = jUptimeMillis;
                        } else {
                            i21Var = h21Var.r;
                            j4 = jUptimeMillis;
                            if (f != Float.MAX_VALUE) {
                                double d3 = i21Var.i;
                                j5 = j3 / 2;
                                np$o np_oA3 = i21Var.a(h21Var.b, h21Var.a, j5);
                                i21 i21Var5 = h21Var.r;
                                i21Var5.i = h21Var.s;
                                h21Var.s = Float.MAX_VALUE;
                                d = np_oA3.a;
                                f2 = np_oA3.b;
                                i21Var2 = i21Var5;
                            } else {
                                i21Var2 = i21Var;
                                d = h21Var.b;
                                f2 = h21Var.a;
                                j5 = j3;
                            }
                            np$o np_oA4 = i21Var2.a(d, f2, j5);
                            float f5 = np_oA4.a;
                            h21Var.b = f5;
                            h21Var.a = np_oA4.b;
                            float fMax4 = Math.max(f5, -3.4028235E38f);
                            h21Var.b = fMax4;
                            float fMin4 = Math.min(fMax4, Float.MAX_VALUE);
                            h21Var.b = fMin4;
                            f3 = h21Var.a;
                            i21Var3 = h21Var.r;
                            i21Var3.getClass();
                            if (Math.abs(f3) < i21Var3.e || Math.abs(fMin4 - ((float) i21Var3.i)) >= i21Var3.d) {
                                z2 = false;
                            } else {
                                h21Var.b = (float) h21Var.r.i;
                                h21Var.a = 0.0f;
                            }
                            float fMin5 = Math.min(h21Var.b, Float.MAX_VALUE);
                            h21Var.b = fMin5;
                            float fMax5 = Math.max(fMin5, -3.4028235E38f);
                            h21Var.b = fMax5;
                            h21Var.b(fMax5);
                            if (z2) {
                                h21Var.f = false;
                                threadLocal = u3.f;
                                if (threadLocal.get() == null) {
                                    threadLocal.set(new u3());
                                }
                                u3Var = (u3) threadLocal.get();
                                u3Var.a.remove(h21Var);
                                arrayList = u3Var.b;
                                iIndexOf = arrayList.indexOf(h21Var);
                                if (iIndexOf >= 0) {
                                    arrayList.set(iIndexOf, null);
                                    u3Var.e = true;
                                }
                                h21Var.h = 0L;
                                h21Var.c = false;
                                i = 0;
                                while (true) {
                                    arrayList2 = h21Var.j;
                                    if (i < arrayList2.size()) {
                                        size = arrayList2.size();
                                        while (true) {
                                            size--;
                                            if (size >= 0) {
                                                if (arrayList2.get(size) == null) {
                                                    arrayList2.remove(size);
                                                }
                                            }
                                        }
                                    } else {
                                        if (arrayList2.get(i) == null) {
                                            arrayList2.get(i).getClass();
                                            d.AnonymousClass0.m$1();
                                            return;
                                        }
                                        i++;
                                    }
                                }
                            } else {
                                continue;
                            }
                        }
                        z2 = true;
                        float fMin6 = Math.min(h21Var.b, Float.MAX_VALUE);
                        h21Var.b = fMin6;
                        float fMax6 = Math.max(fMin6, -3.4028235E38f);
                        h21Var.b = fMax6;
                        h21Var.b(fMax6);
                        if (z2) {
                            h21Var.f = false;
                            threadLocal = u3.f;
                            if (threadLocal.get() == null) {
                                threadLocal.set(new u3());
                            }
                            u3Var = (u3) threadLocal.get();
                            u3Var.a.remove(h21Var);
                            arrayList = u3Var.b;
                            iIndexOf = arrayList.indexOf(h21Var);
                            if (iIndexOf >= 0) {
                                arrayList.set(iIndexOf, null);
                                u3Var.e = true;
                            }
                            h21Var.h = 0L;
                            h21Var.c = false;
                            i = 0;
                            while (true) {
                                arrayList2 = h21Var.j;
                                if (i < arrayList2.size()) {
                                    size = arrayList2.size();
                                    while (true) {
                                        size--;
                                        if (size >= 0) {
                                            if (arrayList2.get(size) == null) {
                                                arrayList2.remove(size);
                                            }
                                        }
                                    }
                                } else {
                                    if (arrayList2.get(i) == null) {
                                        arrayList2.get(i).getClass();
                                        d.AnonymousClass0.m$1();
                                        return;
                                    }
                                    i++;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    j4 = jUptimeMillis;
                }
            }
            i2++;
            jUptimeMillis = j4;
            z3 = false;
        }
    }
}
