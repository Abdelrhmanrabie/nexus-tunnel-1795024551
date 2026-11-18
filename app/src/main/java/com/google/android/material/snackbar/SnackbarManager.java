package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class SnackbarManager {
    public static SnackbarManager snackbarManager;
    public SnackbarRecord currentSnackbar;
    public SnackbarRecord nextSnackbar;
    public final Object lock = new Object();
    public final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager.1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager snackbarManager2 = SnackbarManager.this;
            SnackbarRecord snackbarRecord = (SnackbarRecord) message.obj;
            synchronized (snackbarManager2.lock) {
                try {
                    if (snackbarManager2.currentSnackbar == snackbarRecord || snackbarManager2.nextSnackbar == snackbarRecord) {
                        snackbarManager2.cancelSnackbarLocked(snackbarRecord, 2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
    });

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface Callback {
        void dismiss(int i);

        void show();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SnackbarRecord {
        public final WeakReference callback;
        public int duration;
        public boolean paused;

        public SnackbarRecord(int i, Callback callback) {
            this.callback = new WeakReference(callback);
            this.duration = i;
        }
    }

    private SnackbarManager() {
    }

    public static SnackbarManager getInstance() {
        if (snackbarManager == null) {
            snackbarManager = new SnackbarManager();
        }
        return snackbarManager;
    }

    public final boolean cancelSnackbarLocked(SnackbarRecord snackbarRecord, int i) {
        Callback callback = (Callback) snackbarRecord.callback.get();
        if (callback == null) {
            return false;
        }
        this.handler.removeCallbacksAndMessages(snackbarRecord);
        callback.dismiss(i);
        return true;
    }

    public final boolean isCurrentSnackbarLocked(Callback callback) {
        SnackbarRecord snackbarRecord = this.currentSnackbar;
        return (snackbarRecord == null || callback == null || snackbarRecord.callback.get() != callback) ? false : true;
    }

    public final void pauseTimeout(Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    SnackbarRecord snackbarRecord = this.currentSnackbar;
                    if (!snackbarRecord.paused) {
                        snackbarRecord.paused = true;
                        this.handler.removeCallbacksAndMessages(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void restoreTimeoutIfPaused(Callback callback) {
        synchronized (this.lock) {
            try {
                if (isCurrentSnackbarLocked(callback)) {
                    SnackbarRecord snackbarRecord = this.currentSnackbar;
                    if (snackbarRecord.paused) {
                        snackbarRecord.paused = false;
                        scheduleTimeoutLocked(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void scheduleTimeoutLocked(SnackbarRecord snackbarRecord) {
        int i = snackbarRecord.duration;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        Handler handler = this.handler;
        handler.removeCallbacksAndMessages(snackbarRecord);
        handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), i);
    }
}
