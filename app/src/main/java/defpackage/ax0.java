package defpackage;

import renz.javacodez.vpn.service.SSHVPNService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ax0 implements uo0.b, l81.a {
    public final /* synthetic */ int G0;
    public final /* synthetic */ SSHVPNService a;

    public /* synthetic */ ax0(SSHVPNService sSHVPNService, int i) {
        this.G0 = i;
        this.a = sSHVPNService;
    }

    @Override // uo0.b, l81.a
    public final void onStart() {
        this.a.e(uh.a(this.G0 != 0 ? -118915490544926L : -118795231460638L));
    }

    @Override // uo0.b, l81.a
    public final void onStop() {
        if (this.G0 != 0) {
            this.a.e(uh.a(-118992799956254L));
        } else {
            String strA = uh.a(-118855361002782L);
            SSHVPNService sSHVPNService = this.a;
            sSHVPNService.e(strA);
            sSHVPNService.i();
        }
    }
}
