package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.media.AudioManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import renz.javacodez.vpn.utils.RenzUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class mc1 {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends TimerTask {
        public final /* synthetic */ AudioManager b;
        public final /* synthetic */ int c;

        public a(AudioManager audioManager, int i) {
            this.b = audioManager;
            this.c = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            AudioManager audioManager = this.b;
            int streamVolume = audioManager.getStreamVolume(3);
            int i = this.c;
            if (streamVolume < i) {
                audioManager.setStreamVolume(3, i - 1, 0);
            }
        }
    }

    static {
        uh.a(-158085592284446L);
        uh.a(-158227326205214L);
        uh.a(-158369060125982L);
        uh.a(-158747017248030L);
        uh.a(-158832916593950L);
        uh.a(-164059891793182L);
        uh.a(-164094251531550L);
        uh.a(-164128611269918L);
        Pattern.compile(uh.a(-164197330746654L));
    }

    public static String b(Context context, String str) {
        long j;
        if (str.isEmpty()) {
            j = -156474979548446L;
        } else {
            try {
                return new String(RenzUtils.decrypt(context, str.getBytes(), 0));
            } catch (Exception unused) {
                j = -156479274515742L;
            }
        }
        return uh.a(j);
    }

    public static String c(ContextWrapper contextWrapper, String str, int i) {
        long j;
        if (str.isEmpty()) {
            j = -156492159417630L;
        } else {
            try {
                return new String(RenzUtils.decrypt(contextWrapper, str.getBytes(), i));
            } catch (Exception unused) {
                j = -156496454384926L;
            }
        }
        return uh.a(j);
    }

    public static String d(String str) {
        long j;
        if (str.isEmpty()) {
            j = -156466389613854L;
        } else {
            try {
                return new String(RenzUtils.encrypt(str.getBytes(), 0));
            } catch (Exception unused) {
                j = -156470684581150L;
            }
        }
        return uh.a(j);
    }

    public static String e(String str) {
        long j;
        if (str.isEmpty()) {
            j = -156483569483038L;
        } else {
            try {
                return new String(RenzUtils.encrypt(str.getBytes(), 1));
            } catch (Exception unused) {
                j = -156487864450334L;
            }
        }
        return uh.a(j);
    }

    public static int g(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            Socket socket = new Socket();
            try {
                try {
                    socket.connect(new InetSocketAddress(uh.a(-156324655693086L), i3), InternalZipConstants.AES_HASH_ITERATIONS);
                } catch (IOException unused) {
                    return i3;
                }
            } catch (SocketTimeoutException unused2) {
            } catch (IOException unused3) {
                socket.close();
                return i3;
            } catch (Throwable th) {
                try {
                    socket.close();
                } catch (IOException unused4) {
                }
                throw th;
            }
            try {
                socket.close();
            } catch (IOException unused5) {
            }
        }
        return 8989;
    }

    public static String h() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (hostAddress.indexOf(58) < 0) {
                            return hostAddress;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return uh.a(-149684636253470L);
    }

    public static boolean m(String str) {
        return Pattern.compile(uh.a(-157557311307038L)).matcher(str).find();
    }

    public static void o(File file) throws Exception {
        int i;
        String strA = uh.a(-155826439486750L);
        int i2 = 0;
        do {
            String name = file.getName();
            String[] strArr = {uh.a(-155689000533278L), uh.a(-155719065304350L), uh.a(-155744835108126L)};
            int i3 = 0;
            while (true) {
                if (i3 >= 3) {
                    i = -1;
                    break;
                }
                Process processExec = Runtime.getRuntime().exec(strArr[i3]);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (!line.contains(uh.a(-155792079748382L)) && line.contains(name)) {
                            String[] strArrSplit = line.split(uh.a(-155809259617566L));
                            try {
                                try {
                                    i = Integer.parseInt(strArrSplit[1]);
                                } catch (NumberFormatException unused) {
                                    i = Integer.parseInt(strArrSplit[0]);
                                }
                                try {
                                    processExec.destroy();
                                    break;
                                } catch (Exception unused2) {
                                    break;
                                }
                            } catch (Throwable th) {
                                try {
                                    processExec.destroy();
                                } catch (Exception unused3) {
                                }
                                throw th;
                            }
                        }
                    }
                }
                i3++;
            }
            if (i == -1) {
                return;
            }
            i2++;
            String strValueOf = String.valueOf(i);
            String[] strArr2 = {uh.a(-155839324388638L), uh.a(-155843619355934L), uh.a(-155882274061598L)};
            for (int i4 = 0; i4 < 3; i4++) {
                try {
                    Runtime.getRuntime().exec(strArr2[i4] + uh.a(-155920928767262L) + strA + uh.a(-155959583472926L) + file.getName());
                } catch (IOException unused4) {
                }
                try {
                    Runtime.getRuntime().exec(strArr2[i4] + uh.a(-155968173407518L) + strA + uh.a(-156006828113182L) + file.getCanonicalPath());
                } catch (IOException unused5) {
                }
            }
            String[] strArr3 = {uh.a(-156075547589918L), uh.a(-156079842557214L), uh.a(-156118497262878L)};
            for (int i5 = 0; i5 < 3; i5++) {
                try {
                    Runtime.getRuntime().exec(strArr3[i5] + uh.a(-156157151968542L) + strA + uh.a(-156182921772318L) + strValueOf);
                } catch (IOException e) {
                    uh.a(-156191511706910L);
                    String.format(uh.a(-156195806674206L), strValueOf, e.getMessage());
                }
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused6) {
            }
        } while (i2 <= 4);
        throw new Exception(uh.a(-156015418047774L) + file.getAbsolutePath());
    }

    public static String r(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            char[] cArr = new char[1024];
            while (true) {
                int i = bufferedReader.read(cArr, 0, 1024);
                if (i <= 0) {
                    break;
                }
                sb.append(cArr, 0, i);
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static void s(File file, String str) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
