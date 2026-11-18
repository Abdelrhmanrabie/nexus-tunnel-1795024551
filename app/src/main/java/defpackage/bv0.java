package defpackage;

import renz.javacodez.vpn.service.RenzOpenVPNservice;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bv0 implements uo0.b, l81.a {
    public final /* synthetic */ int G0;
    public final /* synthetic */ RenzOpenVPNservice a;

    public /* synthetic */ bv0(RenzOpenVPNservice renzOpenVPNservice, int i) {
        this.G0 = i;
        this.a = renzOpenVPNservice;
    }

    @Override // uo0.b, l81.a
    public void onStart() {
        this.a.m(uh.a(this.G0 != 1 ? -86810610007326L : -86608746544414L));
    }

    @Override // uo0.b, l81.a
    public void onStop() {
        if (this.G0 != 1) {
            this.a.m(uh.a(-86887919418654L));
        } else {
            String strA = uh.a(-86668876086558L);
            RenzOpenVPNservice renzOpenVPNservice = this.a;
            renzOpenVPNservice.m(strA);
            renzOpenVPNservice.v();
        }
    }
}
