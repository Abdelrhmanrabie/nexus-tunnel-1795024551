package com.trilead.ssh2;

import com.trilead.ssh2.channel.ChannelManager;
import com.trilead.ssh2.channel.DynamicAcceptThread;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class DynamicPortForwarder {
    ChannelManager cm;
    DynamicAcceptThread dat;

    public DynamicPortForwarder(ChannelManager channelManager, int i) {
        this.cm = channelManager;
        DynamicAcceptThread dynamicAcceptThread = new DynamicAcceptThread(channelManager, i);
        this.dat = dynamicAcceptThread;
        dynamicAcceptThread.setDaemon(true);
        this.dat.start();
    }

    public DynamicPortForwarder(ChannelManager channelManager, InetSocketAddress inetSocketAddress) {
        this.cm = channelManager;
        DynamicAcceptThread dynamicAcceptThread = new DynamicAcceptThread(channelManager, inetSocketAddress);
        this.dat = dynamicAcceptThread;
        dynamicAcceptThread.setDaemon(true);
        this.dat.start();
    }

    public void close() {
        this.dat.stopWorking();
    }
}
