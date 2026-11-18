package com.trilead.ssh2;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface InteractiveCallback {
    String[] replyToChallenge(String str, String str2, int i, String[] strArr, boolean[] zArr);
}
