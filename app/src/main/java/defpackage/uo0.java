package defpackage;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class uo0 extends Thread {
    public b b;
    public Process c;
    public File d;
    public final Context f;
    public final String[] g;
    public final int i = 53;
    public final String j;
    public final int n;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface b {
        void onStart();

        void onStop();
    }

    public uo0(Context context, String[] strArr, String str, int i) {
        this.f = context;
        this.g = strArr;
        this.j = str;
        this.n = i;
    }

    public final File a(File file, String[] strArr, int i, String str, int i2) {
        Context context = this.f;
        int i3 = mc1.$r8$clinit;
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[1024];
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.d)));
            while (true) {
                int i4 = bufferedReader.read(cArr);
                if (i4 <= 0) {
                    break;
                }
                sb.append(cArr, 0, i4);
            }
        } catch (Exception e) {
            sb.append(e.getMessage());
        }
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        int i5 = 0;
        while (i5 < strArr.length) {
            String str2 = strArr[i5];
            StringBuilder sb3 = new StringBuilder("server");
            i5++;
            sb3.append(Integer.toString(i5));
            sb2.append(String.format("server {\n label= \"%1$s\";\n ip = %2$s;\n port = %3$d;\n uptest = none;\n }\n", sb3.toString(), str2, Integer.valueOf(i)));
        }
        String str3 = String.format(string, sb2.toString(), file.getCanonicalPath(), str, Integer.valueOf(i2));
        File file2 = new File(file, "pdnsd.conf");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file2, false);
            fileWriter.write(str3);
            fileWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        File file3 = new File(file, "pdnsd.cache");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Exception unused) {
            }
        }
        return file2;
    }

    @Override // java.lang.Thread
    public final synchronized void interrupt() {
        super.interrupt();
        Process process = this.c;
        if (process != null) {
            process.destroy();
        }
        try {
            File file = this.d;
            if (file != null) {
                mc1.o(file);
            }
        } catch (Exception unused) {
        }
        this.c = null;
        this.d = null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0098  */
    /* JADX WARN: Code duplicated, block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Object obj;
        uo0 uo0Var;
        b bVar;
        Context context = this.f;
        b bVar2 = this.b;
        if (bVar2 != null) {
            bVar2.onStart();
        }
        try {
            File file = new File(context.getFilesDir(), "libpdnsd");
            File fileB = b2.b(context, "libpdnsd", file);
            this.d = fileB;
            try {
                if (fileB == null) {
                    throw new IOException("Bin Pdnsd não encontrada");
                }
                uo0 uo0Var2 = this;
                Process processExec = Runtime.getRuntime().exec(uo0Var2.d.getCanonicalPath() + " -v9 -c " + uo0Var2.a(context.getFilesDir(), this.g, this.i, this.j, this.n).toString());
                uo0Var2.c = processExec;
                ke keVar = new ke(this, 22);
                g31 g31Var = new g31(processExec.getInputStream(), keVar);
                g31 g31Var2 = new g31(uo0Var2.c.getErrorStream(), keVar);
                g31Var.start();
                g31Var2.start();
                uo0Var2.c.waitFor();
                uo0Var = uo0Var2;
                uo0Var.c = null;
                bVar = uo0Var.b;
                if (bVar != null) {
                    bVar.onStop();
                }
            } catch (IOException e) {
                e = e;
                obj = file;
                e.getMessage();
                uo0Var = obj;
            } catch (Exception e2) {
                e = e2;
                obj = file;
                e.getMessage();
                uo0Var = obj;
            }
        } catch (IOException e3) {
            e = e3;
            obj = this;
        } catch (Exception e4) {
            e = e4;
            obj = this;
        }
        e.getMessage();
        uo0Var = obj;
        uo0Var.c = null;
        bVar = uo0Var.b;
        if (bVar != null) {
            bVar.onStop();
        }
    }
}
