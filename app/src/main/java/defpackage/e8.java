package defpackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e8 extends Thread {
    public ServerSocket b;
    public Socket c;
    public boolean d;

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            ServerSocket serverSocket = new ServerSocket();
            this.b = serverSocket;
            serverSocket.setReuseAddress(true);
            this.b.bind(new InetSocketAddress(0));
            this.b.getLocalPort();
            while (this.d) {
                try {
                    try {
                        this.c = this.b.accept();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.c.getInputStream()));
                        while (bufferedReader.readLine() != null) {
                            OutputStream outputStream = this.c.getOutputStream();
                            outputStream.write("HTTP/1.1 200 CONNECTED\r\n\r\n".getBytes());
                            outputStream.flush();
                            if (!this.c.isClosed()) {
                                this.c.close();
                            }
                        }
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    OutputStream outputStream2 = this.c.getOutputStream();
                    outputStream2.write("HTTP/1.1 200 CONNECTED\r\n\r\n".getBytes());
                    outputStream2.flush();
                    if (!this.c.isClosed()) {
                        this.c.close();
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        super.run();
    }
}
