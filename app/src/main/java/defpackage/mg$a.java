package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class mg$a {
    public final int a = 0;
    public final int b = 0;

    public mg$a(ConnectivityManager connectivityManager) {
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                this.b += networkInfo.getType() == 1 ? 1 : 0;
                this.a += networkInfo.getType() != 0 ? 0 : 1;
            }
        }
    }
}
