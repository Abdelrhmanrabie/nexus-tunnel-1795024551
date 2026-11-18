package renz.javacodez.v2ray.util;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ai;
import defpackage.e;
import defpackage.fc;
import defpackage.h70;
import defpackage.he;
import defpackage.jo0;
import defpackage.q31;
import defpackage.uq;
import defpackage.vu0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import libv2ray.Libv2ray;
import net.lingala.zip4j.util.InternalZipConstants;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.R;
import renz.javacodez.v2ray.extension._ExtKt;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SpeedtestUtil {
    public static final SpeedtestUtil INSTANCE = new SpeedtestUtil();
    private static final ArrayList<Socket> tcpTestingSockets = new ArrayList<>();

    private SpeedtestUtil() {
    }

    public final void closeAllTcpSockets() {
        synchronized (this) {
            try {
                for (Socket socket : tcpTestingSockets) {
                    if (socket != null) {
                        socket.close();
                    }
                }
                tcpTestingSockets.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String getLibVersion() {
        return Libv2ray.checkVersionX();
    }

    public final String ping(String str) {
        Collection collectionE1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("/system/bin/ping -c 3 ".concat(str)).getInputStream(), fc.a), AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
            try {
                String strS = e.S(bufferedReader);
                bufferedReader.close();
                if (TextUtils.isEmpty(strS)) {
                    return "-1ms";
                }
                List listA = new vu0(InternalZipConstants.ZIP_FILE_SEPARATOR).a(strS.substring(q31.k0(strS, "min/avg/max/mdev", 0, 6) + 19));
                if (!listA.isEmpty()) {
                    ListIterator listIterator = listA.listIterator(listA.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            collectionE1 = uq.b;
                            break;
                        }
                        if (((String) listIterator.previous()).length() != 0) {
                            collectionE1 = he.e1(listA, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                } else {
                    collectionE1 = uq.b;
                    break;
                }
                String[] strArr = (String[]) collectionE1.toArray(new String[0]);
                if (strArr.length <= 0 || strArr[0].length() >= 10) {
                    return "-1ms";
                }
                return ((int) Float.parseFloat(strArr[0])) + "ms";
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    e.F0(bufferedReader, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "-1ms";
        }
    }

    public final long realPing(String str) {
        try {
            return Libv2ray.measureOutboundDelay(str, Utils.getDelayTestUrl$default(Utils.INSTANCE, false, 1, null));
        } catch (Exception e) {
            e.toString();
            return -1L;
        }
    }

    public final long socketConnectTime(String str, int i) {
        ArrayList<Socket> arrayList;
        try {
            Socket socket = new Socket();
            synchronized (this) {
                arrayList = tcpTestingSockets;
                arrayList.add(socket);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            socket.connect(new InetSocketAddress(str, i), 3000);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            synchronized (this) {
                arrayList.remove(socket);
            }
            socket.close();
            return jCurrentTimeMillis2;
        } catch (UnknownHostException e) {
            e = e;
            e.printStackTrace();
            return -1L;
        } catch (IOException e2) {
            e2.toString();
            return -1L;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return -1L;
        }
    }

    public final Object tcping(String str, int i, ai aiVar) {
        long j = -1;
        for (int i2 = 0; i2 < 2; i2++) {
            long jSocketConnectTime = socketConnectTime(str, i);
            h70 h70Var = (h70) aiVar.getContext().a(e.b$1);
            if (!(h70Var != null ? h70Var.isActive() : true)) {
                break;
            }
            if (jSocketConnectTime != -1 && (j == -1 || jSocketConnectTime < j)) {
                j = jSocketConnectTime;
            }
        }
        return new Long(j);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c0  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public final jo0 testConnection(Context context, int i) {
        Exception e;
        HttpURLConnection httpURLConnection;
        IOException e2;
        String string;
        long jElapsedRealtime = -1;
        ?? r4 = 0;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(Utils.getDelayTestUrl$default(Utils.INSTANCE, false, 1, null)).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(AppConfig.LOOPBACK, (int) i)));
                try {
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setRequestProperty("Connection", "close");
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setUseCaches(false);
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    int responseCode = httpURLConnection.getResponseCode();
                    jElapsedRealtime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    if (responseCode != 204 && (responseCode != 200 || _ExtKt.getResponseLength(httpURLConnection) != 0)) {
                        throw new IOException(context.getString(R.string.connection_test_error_status_code, Integer.valueOf(responseCode)));
                    }
                    string = context.getString(R.string.connection_test_available, Long.valueOf(jElapsedRealtime));
                } catch (IOException e3) {
                    e2 = e3;
                    string = context.getString(R.string.connection_test_error, e2.getMessage());
                    if (httpURLConnection != null) {
                    }
                    return new jo0(Long.valueOf(jElapsedRealtime), string);
                } catch (Exception e4) {
                    e = e4;
                    string = context.getString(R.string.connection_test_error, e.getMessage());
                    if (httpURLConnection != null) {
                    }
                    return new jo0(Long.valueOf(jElapsedRealtime), string);
                }
            } catch (Throwable th) {
                th = th;
                r4 = i;
                if (r4 != 0) {
                    r4.disconnect();
                }
                throw th;
            }
        } catch (IOException e5) {
            e2 = e5;
            httpURLConnection = null;
        } catch (Exception e6) {
            e = e6;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (r4 != 0) {
                r4.disconnect();
            }
            throw th;
        }
        httpURLConnection.disconnect();
        return new jo0(Long.valueOf(jElapsedRealtime), string);
    }
}
