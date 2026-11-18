package com.trilead.ssh2;

import java.net.Socket;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public interface ProxyData {
    void close();

    Socket openConnection(String str, int i, int i2);
}
