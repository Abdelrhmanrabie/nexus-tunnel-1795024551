package renz.javacodez.vpn.service;

import android.content.Intent;
import android.os.Bundle;
import android.service.voice.VoiceInteractionService;
import defpackage.uh;
import renz.javacodez.vpn.utils.RenzUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class IPHunterInteractionService extends VoiceInteractionService {
    static {
        uh.a(-76013062225182L);
        uh.a(-76137616276766L);
    }

    @Override // android.service.voice.VoiceInteractionService
    public final void onReady() {
        super.onReady();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        if (intent.getAction().equals(uh.a(-75759659154718L))) {
            RenzUtils.setSessionOn(this);
            return 1;
        }
        if (!intent.getAction().equals(uh.a(-75884213206302L))) {
            return 2;
        }
        RenzUtils.setSessionOff(this);
        return 1;
    }

    @Override // android.service.voice.VoiceInteractionService
    public final void showSession(Bundle bundle, int i) {
        super.showSession(bundle, i);
    }
}
