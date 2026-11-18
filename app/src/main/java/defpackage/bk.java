package defpackage;

import java.io.File;
import java.io.IOException;
import renz.javacodez.vpn.service.SSHVPNService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class bk extends Thread {
    public final ig b;
    public final SSHVPNService c;
    public Process d;
    public File f;

    public bk(SSHVPNService sSHVPNService) {
        this.c = sSHVPNService;
        this.b = ig.h(sSHVPNService);
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        Process process = this.d;
        if (process != null) {
            process.destroy();
        }
        try {
            File file = this.f;
            if (file != null) {
                mc1.o(file);
            }
        } catch (Exception unused) {
        }
        this.d = null;
        this.f = null;
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        SSHVPNService sSHVPNService = this.c;
        ig igVar = this.b;
        try {
            String strE = igVar.e();
            hy0 hy0Var = igVar.a;
            String string = hy0Var.getString(uh.a(-132758170139934L), uh.a(-132788234911006L));
            String string2 = hy0Var.getString(uh.a(-132698040597790L), uh.a(-132753875172638L));
            StringBuilder sb = new StringBuilder();
            File fileB = b2.b(sSHVPNService, "libdns", new File(sSHVPNService.getFilesDir(), "libdns"));
            this.f = fileB;
            if (fileB == null) {
                throw new IOException("DNS bin not found");
            }
            sb.append(fileB.getCanonicalPath());
            sb.append(" -config hu``hqb`c -udp " + strE + ":53   -pubkey " + string + " " + string2 + " 127.0.0.1:" + sSHVPNService.z);
            Process processExec = Runtime.getRuntime().exec(sb.toString());
            this.d = processExec;
            bj bjVar = new bj(3, this);
            g31 g31Var = new g31(processExec.getInputStream(), bjVar);
            g31 g31Var2 = new g31(this.d.getErrorStream(), bjVar);
            g31Var.start();
            g31Var2.start();
            this.d.waitFor();
        } catch (IOException | InterruptedException unused) {
        }
    }
}
