package renz.javacodez.v2ray;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.mmkv.MMKV;
import defpackage.zk;
import renz.javacodez.v2ray.handler.SettingsManager;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class V2RAYApp extends Application {
    public static final Companion Companion = new Companion(null);
    public static V2RAYApp application;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(zk zkVar) {
            this();
        }

        public final V2RAYApp getApplication() {
            V2RAYApp v2RAYApp = V2RAYApp.application;
            v2RAYApp.getClass();
            return v2RAYApp;
        }

        public final void setApplication(V2RAYApp v2RAYApp) {
            V2RAYApp.application = v2RAYApp;
        }
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Companion.setApplication(this);
    }

    public final PackageInfo getPackageInfo(String str) {
        return getPackageManager().getPackageInfo(str, Build.VERSION.SDK_INT >= 28 ? 134217728 : 64);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        MMKV.initialize(this);
        SettingsManager.INSTANCE.initRoutingRulesets(this);
    }
}
