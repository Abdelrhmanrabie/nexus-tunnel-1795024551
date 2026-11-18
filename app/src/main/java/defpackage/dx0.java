package defpackage;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import renz.javacodez.vpn.service.RenzInjectorService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class dx0 implements HandshakeCompletedListener {
    public final /* synthetic */ ex0 a;

    public dx0(ex0 ex0Var) {
        this.a = ex0Var;
    }

    @Override // javax.net.ssl.HandshakeCompletedListener
    public final void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
        String strM = ak.AnonymousClass0.m("<b>Cipher Suite: ", handshakeCompletedEvent.getSession().getCipherSuite(), "</b>");
        RenzInjectorService renzInjectorService = this.a.c;
        renzInjectorService.h(strM);
        renzInjectorService.h("HandshakeCompleted!");
    }
}
