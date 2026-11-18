package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.lingala.zip4j.util.InternalZipConstants;
import renz.javacodez.vpn.service.RenzOpenVPNservice;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class cs0 extends Thread {
    public final String b;
    public final String c;
    public final boolean d;
    public final Socket f;
    public final Socket g;

    public cs0(Socket socket, Socket socket2, boolean z, String str, String str2) {
        this.f = socket;
        this.g = socket2;
        this.d = z;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Socket socket = this.g;
        Socket socket2 = this.f;
        boolean z = this.d;
        byte[] bArr = new byte[Integer.parseInt(z ? this.b : this.c)];
        try {
            try {
                InputStream inputStream = socket2.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        return;
                    }
                    try {
                        try {
                            String str = new String(bArr, 0, i);
                            if (!z) {
                                String[] strArrSplit = str.split("\r\n");
                                if (strArrSplit[0].startsWith("HTTP/")) {
                                    String str2 = strArrSplit[0];
                                    int i2 = Integer.parseInt(str2.substring(9, 12));
                                    String strSubstring = str2.substring(13);
                                    String str3 = "<b>Status: " + String.valueOf(i2) + " (" + strSubstring + ")</b>";
                                    RenzOpenVPNservice renzOpenVPNservice = b2.f19b;
                                    if (renzOpenVPNservice != null) {
                                        renzOpenVPNservice.n(str3);
                                    }
                                    if (i2 != 200) {
                                        outputStream.write("HTTP/1.1 200 OK\r\n\r\n".getBytes(InternalZipConstants.AES_HASH_CHARSET));
                                    }
                                }
                                outputStream.flush();
                            }
                            outputStream.write(bArr, 0, i);
                            outputStream.flush();
                        } catch (IOException unused) {
                        }
                    } catch (Exception unused2) {
                        socket2.close();
                        socket.close();
                        return;
                    } catch (Throwable unused3) {
                        socket2.close();
                        socket.close();
                    }
                }
            } catch (Exception unused4) {
                if (socket2 != null) {
                    socket2.close();
                }
                if (socket != null) {
                    socket.close();
                }
            }
        } catch (IOException unused5) {
        }
    }
}
