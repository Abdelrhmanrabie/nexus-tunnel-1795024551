package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import renz.javacodez.vpn.service.RenzOpenVPNservice;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ng extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ RenzOpenVPNservice.d a;

    public ng(RenzOpenVPNservice.d dVar) {
        this.a = dVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.a.b();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLosing(Network network, int i) {
        this.a.getClass();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.a.b();
    }
}
