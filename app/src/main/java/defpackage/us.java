package defpackage;

import java.io.File;
import java.io.IOException;
import renz.javacodez.vpn.service.SSHVPNService;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class us extends Thread {
    public final ig b;
    public final SSHVPNService c;
    public Process d;
    public File f;

    static {
        uh.a(-68990790696222L);
    }

    public us(SSHVPNService sSHVPNService) {
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
            igVar.getClass();
            String string = igVar.a.getString(uh.a(-132698040597790L), uh.a(-132753875172638L));
            File fileB = b2.b(sSHVPNService, uh.a(-68690142985502L), new File(sSHVPNService.getFilesDir(), uh.a(-68754567494942L)));
            this.f = fileB;
            if (fileB == null) {
                throw new IOException(uh.a(-68818992004382L));
            }
            String[] strArr = {igVar.m(), string};
            for (int i = 0; i < 2; i++) {
                Process processExec = Runtime.getRuntime().exec(String.format(uh.a(-68913481284894L), this.f.getCanonicalPath(), igVar.e(), strArr[i], sSHVPNService.getPackageName()));
                this.d = processExec;
                ke keVar = new ke(this, 23);
                g31 g31Var = new g31(processExec.getInputStream(), keVar);
                g31 g31Var2 = new g31(this.d.getErrorStream(), keVar);
                g31Var.start();
                g31Var2.start();
                this.d.waitFor();
            }
        } catch (IOException | InterruptedException unused) {
        }
    }

    @Override // java.lang.Thread
    public final synchronized void start() {
        super.start();
    }
}
