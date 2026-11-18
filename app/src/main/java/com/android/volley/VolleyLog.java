package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import defpackage.ak;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class VolleyLog {
    public static final boolean DEBUG = Log.isLoggable("Volley", 2);
    public static final String CLASS_NAME = VolleyLog.class.getName();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class MarkerLog {
        public static final boolean ENABLED = VolleyLog.DEBUG;
        public final ArrayList mMarkers = new ArrayList();
        public boolean mFinished = false;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public final class Marker {
            public final String name;
            public final long thread;
            public final long time;

            public Marker(String str, long j, long j2) {
                this.name = str;
                this.thread = j;
                this.time = j2;
            }
        }

        public final synchronized void add(String str, long j) {
            if (this.mFinished) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.mMarkers.add(new Marker(str, j, SystemClock.elapsedRealtime()));
        }

        public final void finalize() {
            if (this.mFinished) {
                return;
            }
            finish("Request on the loose");
            VolleyLog.buildMessage("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public final synchronized void finish(String str) {
            this.mFinished = true;
            ArrayList arrayList = this.mMarkers;
            long j = arrayList.size() == 0 ? 0L : ((Marker) arrayList.get(arrayList.size() - 1)).time - ((Marker) arrayList.get(0)).time;
            if (j <= 0) {
                return;
            }
            long j2 = ((Marker) this.mMarkers.get(0)).time;
            VolleyLog.buildMessage("(%-4d ms) %s", Long.valueOf(j), str);
            for (Marker marker : this.mMarkers) {
                long j3 = marker.time;
                VolleyLog.buildMessage("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(marker.thread), marker.name);
                j2 = j3;
            }
        }
    }

    public static void buildMessage(String str, Object... objArr) {
        String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClassName().equals(CLASS_NAME)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                ak.o(strSubstring.substring(strSubstring.lastIndexOf(36) + 1), ".").append(stackTrace[i].getMethodName());
                break;
            }
        }
        Locale locale = Locale.US;
        Thread.currentThread().getId();
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            buildMessage(str, objArr);
        }
    }
}
