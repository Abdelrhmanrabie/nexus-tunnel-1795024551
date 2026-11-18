package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import defpackage.h6;
import defpackage.jg0;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements c.InterfaceC0023c {
        public a() {
        }

        @Override // androidx.profileinstaller.c.InterfaceC0023c
        public final void b(int i, Serializable serializable) {
            if (i == 6 || i == 7 || i == 8) {
            }
            ProfileInstallReceiver.this.setResultCode(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ee  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        File codeCacheDir;
        int i;
        int i2;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            c.b(context, new jg0(2), new a(), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        setResultCode(11);
                        return;
                    }
                    return;
                }
                a aVar = new a();
                try {
                    c.a(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    new h6(aVar, 10, null, 1).run();
                    return;
                } catch (PackageManager.NameNotFoundException e) {
                    new h6(aVar, 7, e, 1).run();
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            if (Build.VERSION.SDK_INT >= 24) {
                Process.sendSignal(Process.myPid(), 10);
                i2 = 12;
            } else {
                i2 = 13;
            }
            setResultCode(i2);
            return;
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        if (!"DROP_SHADER_CACHE".equals(extras.getString("EXTRA_BENCHMARK_OPERATION"))) {
            setResultCode(16);
            return;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 34) {
            if (i3 < 24) {
                if (i3 == 23) {
                }
                if (androidx.profileinstaller.a.a(codeCacheDir)) {
                    i = 14;
                } else {
                    i = 15;
                }
                setResultCode(i);
            }
            context = context.createDeviceProtectedStorageContext();
            codeCacheDir = context.getCodeCacheDir();
            if (androidx.profileinstaller.a.a(codeCacheDir)) {
                i = 14;
            } else {
                i = 15;
            }
            setResultCode(i);
        }
        context = context.createDeviceProtectedStorageContext();
        codeCacheDir = context.getCacheDir();
        if (androidx.profileinstaller.a.a(codeCacheDir)) {
            i = 14;
        } else {
            i = 15;
        }
        setResultCode(i);
    }
}
