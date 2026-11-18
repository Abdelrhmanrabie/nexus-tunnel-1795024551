package renz.javacodez.vpn.activities;

import android.content.Context;
import renz.javacodez.v2ray.V2RAYApp;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class HamoTunnelPlusApplication extends V2RAYApp {
    public static Context d;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface c {
    }

    static {
        System.loadLibrary("wbi");
    }

    @Override // renz.javacodez.v2ray.V2RAYApp, android.app.Application
    public final native void onCreate();
}
