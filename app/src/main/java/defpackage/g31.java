package defpackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class g31 extends Thread {
    public final BufferedReader b;
    public final a c;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface a {
        void a(String str);
    }

    public g31(InputStream inputStream, a aVar) {
        this.b = new BufferedReader(new InputStreamReader(inputStream));
        this.c = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r5 = this;
            g31$a r0 = r5.c
            java.io.BufferedReader r1 = r5.b
        L4:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L10 java.io.IOException -> L12
            if (r2 == 0) goto L32
            if (r0 == 0) goto L4
            r0.a(r2)     // Catch: java.lang.Throwable -> L10 java.io.IOException -> L12
            goto L4
        L10:
            r0 = move-exception
            goto L2e
        L12:
            r2 = move-exception
            if (r0 == 0) goto L32
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L10
            r3.<init>()     // Catch: java.lang.Throwable -> L10
            java.lang.String r4 = "StreamGobbler error: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L10
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L10
            r3.append(r2)     // Catch: java.lang.Throwable -> L10
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L10
            r0.a(r2)     // Catch: java.lang.Throwable -> L10
            goto L32
        L2e:
            r1.close()     // Catch: java.io.IOException -> L31
        L31:
            throw r0
        L32:
            r1.close()     // Catch: java.io.IOException -> L35
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g31.run():void");
    }
}
