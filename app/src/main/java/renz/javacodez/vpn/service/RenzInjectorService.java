package renz.javacodez.vpn.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import defpackage.b2;
import defpackage.cs0;
import defpackage.e;
import defpackage.e8;
import defpackage.ex0;
import defpackage.hy0;
import defpackage.ig;
import defpackage.mc1;
import defpackage.pc1$a;
import defpackage.uh;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import renz.javacodez.v2ray.service.V2RayServiceManager;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class RenzInjectorService extends Service implements Runnable, Handler.Callback {
    public static boolean t;
    public Thread b;
    public Handler c;
    public ig d;
    public ServerSocket f;
    public Socket g;
    public Socket i;
    public int j = 0;
    public c n;
    public HttpsURLConnection o;
    public e8 p;
    public SSLSocket q;
    public int r;
    public int s;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RenzInjectorService renzInjectorService = RenzInjectorService.this;
            ServerSocket serverSocket = renzInjectorService.f;
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                renzInjectorService.f = null;
            }
            Socket socket = renzInjectorService.g;
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            Socket socket2 = renzInjectorService.i;
            if (socket2 != null) {
                try {
                    socket2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                renzInjectorService.i = null;
            }
            SSLSocket sSLSocket = renzInjectorService.q;
            if (sSLSocket != null) {
                try {
                    sSLSocket.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                renzInjectorService.q = null;
            }
            Thread thread = renzInjectorService.b;
            if (thread != null) {
                thread.interrupt();
            }
            HttpsURLConnection httpsURLConnection = renzInjectorService.o;
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            e8 e8Var = renzInjectorService.p;
            if (e8Var != null) {
                try {
                    ServerSocket serverSocket2 = e8Var.b;
                    if (serverSocket2 != null) {
                        serverSocket2.close();
                    }
                    Socket socket3 = e8Var.c;
                    if (socket3 != null) {
                        socket3.close();
                    }
                    e8Var.d = false;
                    e8Var.interrupt();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface c {
        void c();

        void g();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d extends Binder {
        public d() {
        }
    }

    static {
        uh.a(-83408995908894L);
        t = false;
    }

    public static String a(String str, String str2, String str3) {
        while (str.contains(str2)) {
            Matcher matcher = Pattern.compile(uh.a(-82459808136478L)).matcher(str);
            if (matcher.find()) {
                int iIntValue = Integer.valueOf(matcher.group(1)).intValue();
                String strA = uh.a(-82545707482398L);
                for (int i = 0; i < iIntValue; i++) {
                    strA = ((Object) strA) + str3;
                }
                StringBuilder sbD = e.d(str2);
                sbD.append(String.valueOf(iIntValue));
                sbD.append(uh.a(-82550002449694L));
                str = str.replace(sbD.toString(), strA);
            }
        }
        return str;
    }

    public static boolean b(OutputStream outputStream, String str) throws InterruptedException, IOException {
        if (!str.contains(uh.a(-81347411606814L))) {
            return true;
        }
        for (String str2 : str.split(Pattern.quote(uh.a(-81381771345182L)))) {
            if (b(outputStream, str2)) {
                outputStream.write(str2.getBytes());
                outputStream.flush();
                Thread.sleep(1000L);
            }
        }
        return false;
    }

    public static String f(String str) {
        if (str.contains(uh.a(-82210700033310L))) {
            str = a(str, uh.a(-82232174869790L), uh.a(-82253649706270L));
        }
        if (str.contains(uh.a(-82262239640862L))) {
            str = a(str, uh.a(-82283714477342L), uh.a(-82305189313822L));
        }
        if (str.contains(uh.a(-82313779248414L))) {
            str = a(str, uh.a(-82343844019486L), uh.a(-82373908790558L));
        }
        return str.contains(uh.a(-82386793692446L)) ? a(str, uh.a(-82416858463518L), uh.a(-82446923234590L)) : str;
    }

    public static int k(InputStream inputStream, byte[] bArr) throws IOException {
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = inputStream.read();
            if (i3 == -1) {
                throw new IOException(uh.a(-79453331029278L));
            }
            i++;
            bArr[i] = (byte) i3;
            if (i3 == 13) {
                z = true;
            } else {
                if (i3 == 10) {
                    return i2;
                }
                if (z) {
                    throw new IOException(uh.a(-79569295146270L));
                }
                i2++;
                if (i >= bArr.length) {
                    throw new IOException(uh.a(-79861352922398L).concat(new String(bArr, uh.a(-80007381810462L))));
                }
            }
        }
    }

    public static void m(OutputStream outputStream) throws IOException {
        outputStream.write(uh.a(-82996679048478L).getBytes());
        outputStream.flush();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0048  */
    public final void c() throws IOException {
        ex0 ex0Var = new ex0(this);
        String strM = this.d.m();
        ig igVar = this.d;
        igVar.getClass();
        if (igVar.a.getInt(uh.a(-129073088199966L), 3) == 0) {
            strM = this.d.m();
        } else {
            ig igVar2 = this.d;
            igVar2.getClass();
            if (igVar2.a.getInt(uh.a(-129073088199966L), 3) != 1) {
                strM = this.d.m();
            } else if (!this.d.a().isEmpty()) {
                strM = this.d.a();
            }
        }
        ig igVar3 = this.d;
        igVar3.getClass();
        String strReplace = igVar3.a.getString(uh.a(-128184029969694L), uh.a(-128201209838878L)).replace(uh.a(-80054626450718L), strM);
        if (strReplace.contains(uh.a(-80080396254494L))) {
            String[] strArrSplit = strReplace.split(uh.a(-80088986189086L));
            strReplace = strArrSplit[new Random().nextInt(strArrSplit.length)];
        } else if (strReplace.contains(uh.a(-80097576123678L))) {
            String[] strArrSplit2 = strReplace.split(uh.a(-80106166058270L));
            strReplace = strArrSplit2[new Random().nextInt(strArrSplit2.length)];
        } else if (strReplace.contains(uh.a(-80114755992862L))) {
            String[] strArrSplit3 = strReplace.split(uh.a(-80123345927454L));
            strReplace = strArrSplit3[new Random().nextInt(strArrSplit3.length)];
        }
        URL url = new URL(uh.a(-80131935862046L) + strReplace);
        String host = url.getHost();
        if (url.getPort() > 0) {
            StringBuilder sbD = e.d(host);
            sbD.append(uh.a(-80170590567710L));
            sbD.append(url.getPort());
            host = sbD.toString();
        }
        if (!url.getPath().equals(uh.a(-80179180502302L))) {
            StringBuilder sbD2 = e.d(host);
            sbD2.append(url.getPath());
            host = sbD2.toString();
        }
        h(uh.a(-80187770436894L).concat(ig.u(host)));
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, this.p.b.getLocalSocketAddress()));
        this.o = httpsURLConnection;
        httpsURLConnection.setHostnameVerifier(new b());
        this.o.setSSLSocketFactory(ex0Var);
        this.o.connect();
    }

    public final void d(int i, String str) throws IOException {
        Socket socket = new Socket();
        this.i = socket;
        socket.connect(new InetSocketAddress(str, i), 30000);
    }

    /* JADX WARN: Code duplicated, block: B:62:0x03a8 A[Catch: Exception -> 0x0051, TRY_ENTER, TryCatch #0 {Exception -> 0x0051, blocks: (B:3:0x0003, B:5:0x0019, B:7:0x001f, B:9:0x003b, B:13:0x0054, B:15:0x007c, B:17:0x0080, B:18:0x0092, B:20:0x0109, B:50:0x0317, B:59:0x03a2, B:62:0x03a8, B:64:0x03ae, B:66:0x03b6, B:69:0x03bf, B:71:0x03c5, B:22:0x0154, B:25:0x0160, B:27:0x01b6, B:49:0x0314, B:30:0x01c7, B:33:0x01d3, B:35:0x023c, B:37:0x0257, B:40:0x025f, B:43:0x02ad, B:46:0x02b9, B:48:0x0312, B:53:0x0325, B:56:0x0331, B:58:0x039d), top: B:77:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x03ae A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:3:0x0003, B:5:0x0019, B:7:0x001f, B:9:0x003b, B:13:0x0054, B:15:0x007c, B:17:0x0080, B:18:0x0092, B:20:0x0109, B:50:0x0317, B:59:0x03a2, B:62:0x03a8, B:64:0x03ae, B:66:0x03b6, B:69:0x03bf, B:71:0x03c5, B:22:0x0154, B:25:0x0160, B:27:0x01b6, B:49:0x0314, B:30:0x01c7, B:33:0x01d3, B:35:0x023c, B:37:0x0257, B:40:0x025f, B:43:0x02ad, B:46:0x02b9, B:48:0x0312, B:53:0x0325, B:56:0x0331, B:58:0x039d), top: B:77:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x03bf A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:3:0x0003, B:5:0x0019, B:7:0x001f, B:9:0x003b, B:13:0x0054, B:15:0x007c, B:17:0x0080, B:18:0x0092, B:20:0x0109, B:50:0x0317, B:59:0x03a2, B:62:0x03a8, B:64:0x03ae, B:66:0x03b6, B:69:0x03bf, B:71:0x03c5, B:22:0x0154, B:25:0x0160, B:27:0x01b6, B:49:0x0314, B:30:0x01c7, B:33:0x01d3, B:35:0x023c, B:37:0x0257, B:40:0x025f, B:43:0x02ad, B:46:0x02b9, B:48:0x0312, B:53:0x0325, B:56:0x0331, B:58:0x039d), top: B:77:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x03c5 A[Catch: Exception -> 0x0051, TRY_LEAVE, TryCatch #0 {Exception -> 0x0051, blocks: (B:3:0x0003, B:5:0x0019, B:7:0x001f, B:9:0x003b, B:13:0x0054, B:15:0x007c, B:17:0x0080, B:18:0x0092, B:20:0x0109, B:50:0x0317, B:59:0x03a2, B:62:0x03a8, B:64:0x03ae, B:66:0x03b6, B:69:0x03bf, B:71:0x03c5, B:22:0x0154, B:25:0x0160, B:27:0x01b6, B:49:0x0314, B:30:0x01c7, B:33:0x01d3, B:35:0x023c, B:37:0x0257, B:40:0x025f, B:43:0x02ad, B:46:0x02b9, B:48:0x0312, B:53:0x0325, B:56:0x0331, B:58:0x039d), top: B:77:0x0003 }] */
    public final boolean e() {
        String strJ;
        Socket socket;
        SSLSocket sSLSocket;
        Socket socket2;
        try {
            String line = new BufferedReader(new InputStreamReader(this.g.getInputStream())).readLine();
            if (line != null && line.length() > 0) {
                String strA = uh.a(-76863465749790L);
                if (line.concat(strA).equals(uh.a(-76876350651678L))) {
                    i(uh.a(-76880645618974L), uh.a(-76932185226526L));
                    return false;
                }
                i(uh.a(-77116868820254L), this.d.p());
                ig igVar = this.d;
                igVar.getClass();
                if (!igVar.a.getBoolean(uh.a(-130172599827742L), false) && this.r != 0) {
                    i(uh.a(-77185588296990L), this.d.i());
                }
                h(new String[]{uh.a(-140605075389726L), uh.a(-140656614997278L), uh.a(-140751104277790L), uh.a(-140841298591006L), uh.a(-140888543231262L), uh.a(-140978737544478L), uh.a(-141064636890398L), uh.a(-141137651334430L), uh.a(-141206370811166L), uh.a(-141223550680350L), uh.a(-141249320484126L)}[this.d.q()]);
                int i = this.r;
                if (i == 0) {
                    String str = line.concat(strA).split(uh.a(-77258602741022L))[0].split(uh.a(-77271487642910L))[1];
                    d(Integer.parseInt(str.split(uh.a(-77288667512094L))[1]), str.split(uh.a(-77280077577502L))[0]);
                } else if (i == 1) {
                    strJ = j(line.concat(strA));
                    if (strJ != null) {
                        String str2 = line.concat(strA).split(uh.a(-77297257446686L))[0].split(uh.a(-77310142348574L))[1];
                        d(Integer.parseInt(str2.split(uh.a(-77327322217758L))[1]), str2.split(uh.a(-77318732283166L))[0]);
                        if (!strJ.equals(uh.a(-77335912152350L))) {
                            socket = this.i;
                            g(strJ, socket);
                        }
                    }
                } else if (i == 2) {
                    String strJ2 = j(line.concat(strA));
                    if (strJ2 != null) {
                        String strL = this.d.l();
                        ig igVar2 = this.d;
                        igVar2.getClass();
                        int i2 = Integer.parseInt(igVar2.a.getString(uh.a(-127793187945758L), uh.a(-127840432586014L)));
                        i(uh.a(-77348797054238L), uh.a(-77413221563678L).concat(ig.u(strL + uh.a(-77340207119646L) + i2)));
                        d(i2, strL);
                        if (!strJ2.equals(uh.a(-77477646073118L))) {
                            g(strJ2, this.i);
                            ig igVar3 = this.d;
                            igVar3.getClass();
                            if (igVar3.a.getBoolean(uh.a(-129575599373598L), true)) {
                                l();
                            }
                        }
                        sSLSocket = this.q;
                        socket2 = this.g;
                        if (sSLSocket != null) {
                            if (!socket2.isClosed() && this.i.isConnected() && this.q.isConnected()) {
                                return true;
                            }
                        } else if (socket2.isClosed() && this.i.isConnected()) {
                            return true;
                        }
                    }
                } else if (i == 3) {
                    String str3 = line.concat(strA).split(uh.a(-77481941040414L))[0].split(uh.a(-77494825942302L))[1];
                    d(Integer.parseInt(str3.split(uh.a(-77512005811486L))[1]), str3.split(uh.a(-77503415876894L))[0]);
                    c();
                } else if (i == 4) {
                    strJ = j(line.concat(strA));
                    if (strJ != null) {
                        String str4 = line.concat(strA).split(uh.a(-77520595746078L))[0].split(uh.a(-77533480647966L))[1];
                        d(Integer.parseInt(str4.split(uh.a(-77550660517150L))[1]), str4.split(uh.a(-77542070582558L))[0]);
                        c();
                        if (!strJ.equals(uh.a(-77559250451742L))) {
                            socket = this.q;
                            g(strJ, socket);
                        }
                    }
                } else if (i != 5) {
                    sSLSocket = this.q;
                    socket2 = this.g;
                    if (sSLSocket != null) {
                        if (!socket2.isClosed()) {
                            return true;
                        }
                    } else if (socket2.isClosed()) {
                    }
                } else {
                    String strJ3 = j(line.concat(strA));
                    if (strJ3 != null) {
                        String strL2 = this.d.l();
                        ig igVar4 = this.d;
                        igVar4.getClass();
                        int i3 = Integer.parseInt(igVar4.a.getString(uh.a(-127793187945758L), uh.a(-127840432586014L)));
                        i(uh.a(-77572135353630L), uh.a(-77636559863070L).concat(ig.u(strL2 + uh.a(-77563545419038L) + i3)));
                        d(i3, strL2);
                        c();
                        if (!strJ3.equals(uh.a(-77700984372510L))) {
                            g(strJ3, this.q);
                        }
                        sSLSocket = this.q;
                        socket2 = this.g;
                        if (sSLSocket != null) {
                            if (!socket2.isClosed()) {
                                return true;
                            }
                        } else if (socket2.isClosed()) {
                        }
                    }
                }
                m(this.g.getOutputStream());
                sSLSocket = this.q;
                socket2 = this.g;
                if (sSLSocket != null) {
                    if (!socket2.isClosed()) {
                        return true;
                    }
                } else if (socket2.isClosed()) {
                }
            }
            return false;
        } catch (Exception e) {
            i(uh.a(-77705279339806L), e.toString());
            return false;
        }
    }

    public final void g(String str, Socket socket) throws InterruptedException, IOException {
        OutputStream outputStream = socket.getOutputStream();
        if (str.contains(uh.a(-80243605011742L))) {
            Random random = new Random();
            String[] strArrSplit = str.split(Pattern.quote(uh.a(-80282259717406L)));
            str = strArrSplit[random.nextInt(strArrSplit.length)];
        }
        int i = 0;
        if (str.contains(uh.a(-80320914423070L))) {
            String[] strArrSplit2 = str.split(Pattern.quote(uh.a(-80359569128734L)));
            int i2 = this.j;
            String str2 = strArrSplit2[i2];
            int i3 = i2 + 1;
            this.j = i3;
            if (i3 > strArrSplit2.length - 1) {
                this.j = 0;
            }
            str = str2;
        }
        if (str.contains(uh.a(-80398223834398L))) {
            Matcher matcher = Pattern.compile(uh.a(-80436878540062L)).matcher(str);
            while (matcher.find()) {
                String[] strArrSplit3 = matcher.group(1).split(uh.a(-80509892984094L));
                str = str.replace(matcher.group(0), strArrSplit3[this.s]);
                int i4 = this.s + 1;
                this.s = i4;
                if (i4 >= strArrSplit3.length) {
                    this.s = 0;
                }
            }
        }
        str.replace(uh.a(-80518482918686L), uh.a(-80531367820574L));
        h(uh.a(-80552842657054L));
        if (str.contains(uh.a(-80595792330014L))) {
            String[] strArrSplit4 = str.split(Pattern.quote(uh.a(-80655921872158L)));
            int length = strArrSplit4.length;
            while (i < length) {
                String str3 = strArrSplit4[i];
                if (b(outputStream, str3)) {
                    outputStream.write(str3.getBytes(uh.a(-80716051414302L)));
                    outputStream.flush();
                    Thread.sleep(1000L);
                }
                i++;
            }
            return;
        }
        if (str.contains(uh.a(-80763296054558L))) {
            String[] strArrSplit5 = str.split(Pattern.quote(uh.a(-80832015531294L)));
            int length2 = strArrSplit5.length;
            while (i < length2) {
                String str4 = strArrSplit5[i];
                if (b(outputStream, str4)) {
                    outputStream.write(str4.getBytes(uh.a(-80900735008030L)));
                    outputStream.flush();
                    Thread.sleep(0L);
                }
                i++;
            }
            return;
        }
        if (str.contains(uh.a(-80947979648286L))) {
            String[] strArrSplit6 = str.split(Pattern.quote(uh.a(-81016699125022L)));
            int length3 = strArrSplit6.length;
            while (i < length3) {
                String str5 = strArrSplit6[i];
                if (b(outputStream, str5)) {
                    outputStream.write(str5.getBytes(uh.a(-81085418601758L)));
                    outputStream.flush();
                    Thread.sleep(0L);
                }
                i++;
            }
            return;
        }
        if (!str.contains(uh.a(-81132663242014L))) {
            if (b(outputStream, str)) {
                outputStream.write(str.getBytes(uh.a(-81300166966558L)));
                outputStream.flush();
                return;
            }
            return;
        }
        String[] strArrSplit7 = str.split(Pattern.quote(uh.a(-81192792784158L)));
        int length4 = strArrSplit7.length;
        while (i < length4) {
            String str6 = strArrSplit7[i];
            if (b(outputStream, str6)) {
                outputStream.write(str6.getBytes(uh.a(-81252922326302L)));
                outputStream.flush();
                Thread.sleep(1000L);
            }
            i++;
        }
    }

    public final void h(String str) {
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1, str));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        ig igVar;
        Intent intent;
        long j;
        int i = message.what;
        if (i == 1) {
            RenzOpenVPNservice renzOpenVPNservice = b2.f19b;
            String strReplace = (String) message.obj;
            if (renzOpenVPNservice != null && (igVar = this.d) != null) {
                if (strReplace.contains(igVar.m())) {
                    strReplace = strReplace.replace(this.d.m(), ig.u(this.d.m()));
                }
                renzOpenVPNservice.n(strReplace);
            }
        } else if (i != 2) {
            if (i == 3) {
                intent = new Intent(this, (Class<?>) RenzOpenVPNservice.class);
                j = -83297326759198L;
                startService(intent.setAction(uh.a(j)));
                return true;
            }
            if (i == 4) {
                V2RayServiceManager.INSTANCE.startV2Ray(this);
                return true;
            }
        } else {
            if (this.d.s() == 0) {
                this.n.g();
                return true;
            }
            if (this.d.s() == 1 || this.d.s() == 4) {
                intent = new Intent(this, (Class<?>) SSHVPNService.class);
                j = -83220017347870L;
                startService(intent.setAction(uh.a(j)));
                return true;
            }
        }
        return true;
    }

    public final void i(String str, String str2) {
        h(String.format(uh.a(-83159887805726L), str, str2));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x01bc A[Catch: Exception -> 0x0083, TRY_LEAVE, TryCatch #0 {Exception -> 0x0083, blocks: (B:5:0x0008, B:7:0x0012, B:17:0x0086, B:18:0x008c, B:20:0x01bc, B:10:0x005f, B:12:0x0070, B:14:0x007c), top: B:25:0x0008 }] */
    public final String j(String str) {
        String strF = null;
        if (str != null) {
            try {
                if (!str.equals(uh.a(-81416131083550L))) {
                    String str2 = str.split(uh.a(-81420426050846L))[0];
                    String[] strArrSplit = str2.split(uh.a(-81433310952734L));
                    String[] strArrSplit2 = strArrSplit[1].split(uh.a(-81441900887326L));
                    String strM = this.d.m();
                    String str3 = strArrSplit2[1];
                    ig igVar = this.d;
                    igVar.getClass();
                    if (igVar.a.getInt(uh.a(-129073088199966L), 3) != 0) {
                        ig igVar2 = this.d;
                        igVar2.getClass();
                        if (igVar2.a.getInt(uh.a(-129073088199966L), 3) == 1) {
                            if (!this.d.a().isEmpty()) {
                                strM = this.d.a();
                            }
                        }
                        ig igVar3 = this.d;
                        igVar3.getClass();
                        strF = f(igVar3.a.getString(uh.a(-127681518796062L), uh.a(-127737353370910L)).replace(uh.a(-81450490821918L), strM).replace(uh.a(-81476260625694L), strM).replace(uh.a(-81489145527582L), str).replace(uh.a(-81536390167838L), str2).replace(uh.a(-81562159971614L), strArrSplit[0]).replace(uh.a(-81600814677278L), strArrSplit[1]).replace(uh.a(-81652354284830L), strM).replace(uh.a(-81682419055902L), str3).replace(uh.a(-81712483826974L), strArrSplit[2]).replace(uh.a(-81759728467230L), uh.a(-81781203303710L)).replace(uh.a(-81789793238302L), uh.a(-81811268074782L)).replace(uh.a(-81819858009374L), uh.a(-81849922780446L)).replace(uh.a(-81862807682334L), uh.a(-81892872453406L)).replace(uh.a(-81905757355294L), uh.a(-81918642257182L)).replace(uh.a(-81927232191774L), uh.a(-81940117093662L)));
                        if (strF.contains(uh.a(-81948707028254L))) {
                            ig igVar4 = this.d;
                            igVar4.getClass();
                            String strA = uh.a(-129524059766046L);
                            hy0.a aVar = igVar4.b;
                            aVar.putBoolean(strA, false);
                            aVar.apply();
                        }
                        return strF;
                    }
                    strM = this.d.m();
                    ig igVar5 = this.d;
                    igVar5.getClass();
                    strF = f(igVar5.a.getString(uh.a(-127681518796062L), uh.a(-127737353370910L)).replace(uh.a(-81450490821918L), strM).replace(uh.a(-81476260625694L), strM).replace(uh.a(-81489145527582L), str).replace(uh.a(-81536390167838L), str2).replace(uh.a(-81562159971614L), strArrSplit[0]).replace(uh.a(-81600814677278L), strArrSplit[1]).replace(uh.a(-81652354284830L), strM).replace(uh.a(-81682419055902L), str3).replace(uh.a(-81712483826974L), strArrSplit[2]).replace(uh.a(-81759728467230L), uh.a(-81781203303710L)).replace(uh.a(-81789793238302L), uh.a(-81811268074782L)).replace(uh.a(-81819858009374L), uh.a(-81849922780446L)).replace(uh.a(-81862807682334L), uh.a(-81892872453406L)).replace(uh.a(-81905757355294L), uh.a(-81918642257182L)).replace(uh.a(-81927232191774L), uh.a(-81940117093662L)));
                    if (strF.contains(uh.a(-81948707028254L))) {
                        ig igVar6 = this.d;
                        igVar6.getClass();
                        String strA2 = uh.a(-129524059766046L);
                        hy0.a aVar2 = igVar6.b;
                        aVar2.putBoolean(strA2, false);
                        aVar2.apply();
                    }
                    return strF;
                }
            } catch (Exception e) {
                i(uh.a(-81983066766622L), e.toString());
            }
        }
        i(uh.a(-82043196308766L), uh.a(-82103325850910L));
        return strF;
    }

    public final void l() throws IOException {
        String str;
        String string;
        int iK;
        byte[] bArr = new byte[1024];
        InputStream inputStream = this.i.getInputStream();
        int iK2 = k(inputStream, bArr);
        uh.a(-77765408881950L);
        try {
            str = new String(bArr, 0, iK2, uh.a(-77769703849246L));
            while (true) {
                iK = k(inputStream, bArr);
                if (iK == 0) {
                    break;
                }
                StringBuilder sbD = e.d(string);
                sbD.append(uh.a(-78182020709662L));
                String string2 = sbD.toString();
                try {
                    string = string2 + new String(bArr, 0, iK, uh.a(-78190610644254L));
                } catch (UnsupportedEncodingException unused) {
                    StringBuilder sbD2 = e.d(string2);
                    sbD2.append(new String(bArr, 0, iK));
                    string = sbD2.toString();
                }
            }
        } catch (UnsupportedEncodingException unused2) {
            str = new String(bArr, 0, iK2);
        }
        h(uh.a(-77816948489502L) + str + uh.a(-77855603195166L));
        int i = Integer.parseInt(str.substring(9, 12));
        if (i != 200) {
            String strValueOf = String.valueOf(i);
            str.replace(str, uh.a(-77898552868126L));
            h(uh.a(-77967272344862L));
            uh.a(-78083236461854L);
            uh.a(-78121891167518L);
            Integer.parseInt(strValueOf.replace(strValueOf, uh.a(-78164840840478L)));
        }
        string = str;
        if (!string.isEmpty()) {
            h(string);
        }
        OutputStream outputStream = this.g.getOutputStream();
        if (!str.startsWith(uh.a(-78237855284510L))) {
            throw new IOException(uh.a(-78263625088286L));
        }
        if (str.length() < 14) {
            throw new IOException(uh.a(-78482668420382L));
        }
        if (str.charAt(8) != ' ') {
            throw new IOException(uh.a(-78701711752478L));
        }
        if (str.charAt(12) != ' ') {
            throw new IOException(uh.a(-78920755084574L));
        }
        if (iK < 0 || iK > 999) {
            throw new IOException(uh.a(-79139798416670L));
        }
        if (iK != 200) {
            outputStream.write(uh.a(-79358841748766L).concat(uh.a(-79427561225502L)).concat(uh.a(-79440446127390L)).getBytes());
            outputStream.flush();
        }
    }

    public final void n() {
        t = false;
        h(uh.a(-76730321763614L));
        this.j = 0;
        this.s = 0;
        new Thread(new a()).start();
        stopForeground(true);
        stopSelf();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new d();
    }

    @Override // android.app.Service
    public final void onCreate() {
        this.c = new Handler(this);
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (action.equals(uh.a(-76489803595038L))) {
            this.b = new Thread(this, uh.a(-76515573398814L));
            ig igVarH = ig.h(this);
            this.d = igVarH;
            this.r = igVarH.q();
            h(uh.a(-76579997908254L));
            t = true;
            Thread thread = this.b;
            if (thread != null) {
                thread.interrupt();
            }
            this.b.start();
        } else if (action.equals(uh.a(-76708846927134L))) {
            this.n.c();
        }
        super.onStart(intent, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Socket socket;
        Socket socket2;
        String strA;
        String strA2;
        if (this.d.s() == 2) {
            this.c.sendEmptyMessage(3);
            return;
        }
        if (this.d.s() == 3) {
            this.c.sendEmptyMessage(4);
            return;
        }
        try {
            int iG = mc1.g(8989, 9);
            ig.e = iG;
            h(String.format(uh.a(-82558592384286L), Integer.toString(iG)));
            h(uh.a(-82670261533982L));
            this.f = new ServerSocket(iG);
            int i = this.r;
            if (i == 3 || i == 4 || i == 5) {
                e8 e8Var = this.p;
                if (e8Var != null) {
                    ServerSocket serverSocket = e8Var.b;
                    if (serverSocket != null) {
                        serverSocket.close();
                    }
                    Socket socket3 = e8Var.c;
                    if (socket3 != null) {
                        socket3.close();
                    }
                    e8Var.d = false;
                    e8Var.interrupt();
                }
                e8 e8Var2 = new e8();
                e8Var2.d = true;
                this.p = e8Var2;
                e8Var2.start();
            }
            this.c.sendEmptyMessage(2);
            while (t) {
                Socket socketAccept = this.f.accept();
                this.g = socketAccept;
                if (socketAccept == null || socketAccept.isClosed() || !e()) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused) {
                    }
                    Socket socket4 = this.g;
                    if (socket4 != null) {
                        try {
                            socket4.close();
                        } catch (IOException unused2) {
                        }
                    }
                    Socket socket5 = this.i;
                    if (socket5 != null) {
                        try {
                            socket5.close();
                        } catch (IOException unused3) {
                        }
                    }
                } else {
                    this.g.setKeepAlive(true);
                    SSLSocket sSLSocket = this.q;
                    if (sSLSocket == null || !sSLSocket.isConnected()) {
                        Socket socket6 = this.i;
                        if (socket6 != null && socket6.isConnected()) {
                            this.i.setKeepAlive(true);
                            Socket socket7 = this.i;
                            pc1$a pc1_a = b2.f15a;
                            if (pc1_a != null ? pc1_a.a(socket7) : false) {
                                h(uh.a(-83082578394398L));
                            }
                            socket = this.g;
                            socket2 = this.i;
                            strA = uh.a(-82867830029598L);
                            strA2 = uh.a(-82893599833374L);
                        }
                    } else {
                        this.q.setKeepAlive(true);
                        this.i.setKeepAlive(true);
                        SSLSocket sSLSocket2 = this.q;
                        pc1$a pc1_a2 = b2.f15a;
                        if (pc1_a2 != null ? pc1_a2.a(sSLSocket2) : false) {
                            h(uh.a(-83082578394398L));
                        }
                        socket = this.g;
                        socket2 = this.q;
                        strA = uh.a(-82816290422046L);
                        strA2 = uh.a(-82842060225822L);
                    }
                    Socket socket8 = socket;
                    Socket socket9 = socket2;
                    String str = strA;
                    String str2 = strA2;
                    new cs0(socket8, socket9, true, str, str2).start();
                    new cs0(socket9, socket8, false, str, str2).start();
                }
            }
        } catch (Exception e) {
            h(String.format(uh.a(-83189952576798L), uh.a(-82919369637150L), e.getMessage()));
        }
    }
}
