package defpackage;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class al extends ur implements Runnable {
    public static volatile Thread _thread;
    public static volatile int debugStatus;
    public static final al o;
    public static final long p;

    static {
        Long l;
        al alVar = new al();
        o = alVar;
        alVar.C(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        p = timeUnit.toNanos(l.longValue());
    }

    @Override // defpackage.ur
    public final Thread E() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(al.class.getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // defpackage.ur
    public final void H(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.H(runnable);
    }

    public final synchronized void M() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            ur.i.set(this, null);
            ur.j.set(this, null);
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        p61.a.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i != 2 && i != 3) {
                    debugStatus = 1;
                    notifyAll();
                    long j = Long.MAX_VALUE;
                    while (true) {
                        Thread.interrupted();
                        long jK = K();
                        if (jK == Long.MAX_VALUE) {
                            long jNanoTime = System.nanoTime();
                            if (j == Long.MAX_VALUE) {
                                j = p + jNanoTime;
                            }
                            long j2 = j - jNanoTime;
                            if (j2 <= 0) {
                                _thread = null;
                                M();
                                if (J()) {
                                    return;
                                }
                                E();
                                return;
                            }
                            if (jK > j2) {
                                jK = j2;
                            }
                        } else {
                            j = Long.MAX_VALUE;
                        }
                        if (jK > 0) {
                            int i2 = debugStatus;
                            if (i2 == 2 || i2 == 3) {
                                break;
                                break;
                            }
                            LockSupport.parkNanos(this, jK);
                        }
                    }
                    _thread = null;
                    M();
                    if (J()) {
                        return;
                    }
                    E();
                    return;
                }
                _thread = null;
                M();
                if (J()) {
                    return;
                }
                E();
            }
        } catch (Throwable th) {
            _thread = null;
            M();
            if (!J()) {
                E();
            }
            throw th;
        }
    }

    @Override // defpackage.ur
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
