package renz.javacodez.vpn.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import renz.javacodez.vpn.service.IPHunterInteractionService;
import renz.javacodez.vpn.service.IPHunterInteractionSession;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class RenzUtils {
    public static native boolean checkAppSign(Context context);

    public static native boolean containsArray(byte[] bArr, byte[] bArr2);

    public static native byte[] decrypt(Context context, byte[] bArr, int i);

    public static native byte[] encrypt(byte[] bArr, int i);

    public static native byte[] helloWorld();

    public static native void initializeApp(Context context);

    public static native void play(CountDownTimer countDownTimer);

    public static native void setSessionOff(IPHunterInteractionService iPHunterInteractionService);

    public static native void setSessionOn(IPHunterInteractionService iPHunterInteractionService);

    public static native byte[] stayHumbleAlways();

    public static native void toggle(IPHunterInteractionSession iPHunterInteractionSession, Bundle bundle);
}
