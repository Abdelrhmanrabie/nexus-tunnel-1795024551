package renz.javacodez.vpn.service;

import android.os.Handler;
import java.util.TimerTask;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class a extends TimerTask {
    public final /* synthetic */ RenzOpenVPNservice.f b;
    public final /* synthetic */ RenzOpenVPNservice c;

    public a(RenzOpenVPNservice renzOpenVPNservice, RenzOpenVPNservice.f fVar) {
        this.c = renzOpenVPNservice;
        this.b = fVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        if (this.b.j == R.string.cr) {
            RenzOpenVPNservice renzOpenVPNservice = this.c;
            if (renzOpenVPNservice.s == null || (handler = renzOpenVPNservice.r) == null) {
                return;
            }
            handler.sendEmptyMessage(99);
        }
    }
}
