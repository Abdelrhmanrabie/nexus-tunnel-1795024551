package defpackage;

import android.content.Intent;
import renz.javacodez.vpn.service.RenzOpenVPNservice;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ev0 implements Runnable {
    public final /* synthetic */ String b;
    public final /* synthetic */ Intent c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ RenzOpenVPNservice f;

    public ev0(RenzOpenVPNservice renzOpenVPNservice, String str, Intent intent, boolean z) {
        this.f = renzOpenVPNservice;
        this.b = str;
        this.c = intent;
        this.d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = RenzOpenVPNservice.M;
        this.f.e(this.b, this.c, this.d);
    }
}
