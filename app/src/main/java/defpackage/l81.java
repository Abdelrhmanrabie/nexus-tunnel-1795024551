package defpackage;

import android.content.Context;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class l81 extends Thread implements g31.a {
    public File b;
    public final Context c;
    public final String d;
    public final String f;
    public final String g;
    public final ParcelFileDescriptor j;
    public final String o;
    public final String p;
    public a q;
    public Process r;
    public final int n = 1500;
    public final boolean i = true;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface a {
        void onStart();

        void onStop();
    }

    public l81(Context context, ParcelFileDescriptor parcelFileDescriptor, String str, String str2, String str3, String str4, String str5) {
        this.c = context;
        this.j = parcelFileDescriptor;
        this.o = str;
        this.p = str2;
        this.f = str3;
        this.g = str4;
        this.d = str5;
    }

    public static boolean b(ParcelFileDescriptor parcelFileDescriptor, File file) throws InterruptedException {
        for (int i = 10; i >= 0; i--) {
            try {
                LocalSocket localSocket = new LocalSocket();
                localSocket.connect(new LocalSocketAddress(file.getAbsolutePath(), LocalSocketAddress.Namespace.FILESYSTEM));
                localSocket.setFileDescriptorsForSend(new FileDescriptor[]{parcelFileDescriptor.getFileDescriptor()});
                localSocket.getOutputStream().write(42);
                localSocket.shutdownOutput();
                localSocket.close();
                return true;
            } catch (IOException unused) {
                Thread.sleep(500L);
            }
        }
        return false;
    }

    @Override // g31.a
    public final void a(String str) {
    }

    @Override // java.lang.Thread
    public final synchronized void interrupt() {
        super.interrupt();
        Process process = this.r;
        if (process != null) {
            process.destroy();
        }
        try {
            File file = this.b;
            if (file != null) {
                mc1.o(file);
            }
        } catch (Exception unused) {
        }
        this.r = null;
        this.b = null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        File file;
        Context context = this.c;
        a aVar = this.q;
        if (aVar != null) {
            aVar.onStart();
        }
        try {
            StringBuilder sb = new StringBuilder();
            File fileB = b2.b(context, "libtun2socks", new File(context.getFilesDir(), "libtun2socks"));
            this.b = fileB;
            if (fileB == null) {
                throw new IOException("Bin Tun2Socks not found");
            }
            ParcelFileDescriptor parcelFileDescriptor = this.j;
            if (parcelFileDescriptor == null) {
                throw new IOException("Invalid VPN interface fd.");
            }
            if (Build.VERSION.SDK_INT >= 24) {
                file = context.getDataDir();
            } else {
                String str = context.getApplicationInfo().dataDir;
                file = str != null ? new File(str) : null;
            }
            File file2 = new File(file, "sock_path");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            sb.append(fileB.getCanonicalPath());
            sb.append(" --netif-ipaddr ");
            sb.append(this.o);
            sb.append(" --netif-netmask ");
            sb.append(this.p);
            sb.append(" --socks-server-addr ");
            sb.append(this.f);
            sb.append(" --tunmtu ");
            sb.append(this.n);
            sb.append(" --tunfd ");
            sb.append(parcelFileDescriptor.getFd());
            sb.append(" --sock ");
            sb.append(file2.getAbsolutePath());
            sb.append(" --loglevel 3");
            String str2 = this.g;
            if (str2 != null) {
                if (this.i) {
                    sb.append(" --udpgw-transparent-dns");
                }
                sb.append(" --udpgw-remote-server-addr ");
                sb.append(str2);
            }
            String str3 = this.d;
            if (str3 != null) {
                sb.append(" --dnsgw ");
                sb.append(str3);
            }
            Process processExec = Runtime.getRuntime().exec(sb.toString());
            this.r = processExec;
            g31 g31Var = new g31(processExec.getInputStream(), this);
            g31 g31Var2 = new g31(this.r.getErrorStream(), this);
            g31Var.start();
            g31Var2.start();
            if (!b(parcelFileDescriptor, file2)) {
                throw new IOException("Failed to send FD. Device may not support this feature.");
            }
            this.r.waitFor();
            this.r = null;
            a aVar2 = this.q;
            if (aVar2 != null) {
                aVar2.onStop();
            }
        } catch (Exception unused) {
        }
    }
}
