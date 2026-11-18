package defpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class gb1 extends Thread {
    public boolean b;
    public final o6 c;
    public final BufferedReader d;

    public gb1(InputStream inputStream, o6 o6Var) {
        this.d = new BufferedReader(new InputStreamReader(inputStream));
        this.c = o6Var;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        BufferedReader bufferedReader;
        String line;
        while (true) {
            try {
                boolean z = this.b;
                bufferedReader = this.d;
                if (z || (line = bufferedReader.readLine()) == null) {
                    break;
                }
                o6 o6Var = this.c;
                if (o6Var != null) {
                    lb1 lb1Var = (lb1) o6Var.a;
                    int i = lb1.$r8$clinit;
                    lb1Var.a(line);
                }
            } catch (IOException e) {
                e.getMessage();
                return;
            }
        }
        bufferedReader.close();
    }
}
