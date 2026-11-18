package renz.javacodez.vpn.service;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import defpackage.uh;
import renz.javacodez.vpn.utils.RenzUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class IPHunterInteractionSession extends VoiceInteractionSession {
    public IPHunterInteractionSession(Context context) {
        super(context);
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onHandleAssist(Bundle bundle, AssistStructure assistStructure, AssistContent assistContent) {
        super.onHandleAssist(bundle, assistStructure, assistContent);
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onPrepareShow(Bundle bundle, int i) {
        String string = bundle.getString(uh.a(-76266465295646L));
        if (string != null && string.equals(uh.a(-76296530066718L))) {
            RenzUtils.toggle(this, bundle);
        }
        super.onPrepareShow(bundle, i);
    }
}
