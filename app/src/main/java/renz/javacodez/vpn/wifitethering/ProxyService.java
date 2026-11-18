package renz.javacodez.vpn.wifitethering;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.as0;
import defpackage.bs0;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ProxyService extends Service {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a extends renz.javacodez.vpn.wifitethering.a.AbstractBinderC0044a {
        public a() {
        }

        @Override // renz.javacodez.vpn.wifitethering.a
        public final boolean isRunning() {
            return bs0.a().b;
        }

        @Override // renz.javacodez.vpn.wifitethering.a
        public final boolean start() {
            ProxyService proxyService = ProxyService.this;
            int i = ProxyService.b;
            proxyService.getClass();
            bs0 bs0VarA = bs0.a();
            int i2 = 0;
            if (bs0VarA.b) {
                return false;
            }
            synchronized (bs0VarA) {
                if (!bs0VarA.b) {
                    try {
                        bs0VarA.c = Selector.open();
                        ServerSocketChannel serverSocketChannelOpen = ServerSocketChannel.open();
                        bs0VarA.d = serverSocketChannelOpen;
                        serverSocketChannelOpen.configureBlocking(false);
                        while (bs0VarA.a < 50146) {
                            try {
                                bs0VarA.d.socket().bind(new InetSocketAddress(bs0VarA.a));
                                break;
                            } catch (IOException unused) {
                                bs0VarA.a++;
                            }
                        }
                        if (bs0VarA.a < 50146) {
                            bs0VarA.d.register(bs0VarA.c, 16);
                            bs0VarA.b = true;
                            Thread thread = new Thread(new as0(i2, bs0VarA));
                            thread.setDaemon(false);
                            thread.setName("ProxyServer");
                            thread.start();
                            return true;
                        }
                    } catch (ClosedChannelException | Exception unused2) {
                    }
                }
                return false;
            }
        }

        @Override // renz.javacodez.vpn.wifitethering.a
        public final boolean stop() {
            ProxyService proxyService = ProxyService.this;
            int i = ProxyService.b;
            proxyService.getClass();
            bs0 bs0VarA = bs0.a();
            if (!bs0VarA.b) {
                return false;
            }
            synchronized (bs0VarA) {
                if (!bs0VarA.b) {
                    return false;
                }
                bs0VarA.b = false;
                try {
                    bs0VarA.c.wakeup();
                    bs0VarA.c.close();
                    bs0VarA.c = null;
                } catch (Exception unused) {
                }
                try {
                    bs0VarA.d.close();
                    bs0VarA.d = null;
                } catch (IOException unused2) {
                }
                return true;
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new a();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
    }
}
