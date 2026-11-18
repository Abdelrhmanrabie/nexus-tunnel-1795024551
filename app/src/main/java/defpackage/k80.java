package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class k80 implements ao0 {
    public final ji0 c;
    public final fn d;
    public final ff0.j e;

    public k80(ff0 ff0Var, ku0 ku0Var, ji0 ji0Var, oo ooVar, a80 a80Var, a80 a80Var2, yk0 yk0Var) {
        this.c = ji0Var;
        this.e = ff0Var.d(new i(11, this));
        bj bjVar = new bj(28, this);
        q9 q9Var = q9.m;
        this.d = new fn(ff0Var, ji0Var, bjVar, new g(ji0Var, ooVar, q9Var), this, mr.a, e.a$4, Arrays.asList(new p9(ff0Var, ji0Var), new u70(ff0Var, ji0Var)), ooVar, a80Var, a80Var2, q9Var.a, yk0Var, 262144);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003c  */
    @Override // defpackage.ao0
    public final boolean a(cv cvVar) throws IOException {
        InputStream inputStream;
        wn0 wn0VarA;
        ff0.j jVar = this.e;
        Object obj = jVar.c.get(cvVar);
        if (obj == null || obj == ff0.l.c) {
            if (cvVar.h(m21.h)) {
                q9.m.getClass();
                String strA = q9.a(cvVar);
                ClassLoader classLoader = x9.class.getClassLoader();
                if (classLoader == null) {
                    inputStream = ClassLoader.getSystemResourceAsStream(strA);
                } else {
                    URL resource = classLoader.getResource(strA);
                    if (resource == null) {
                        inputStream = null;
                    } else {
                        URLConnection uRLConnectionOpenConnection = resource.openConnection();
                        uRLConnectionOpenConnection.setUseCaches(false);
                        inputStream = uRLConnectionOpenConnection.getInputStream();
                    }
                }
            } else {
                inputStream = null;
            }
            wn0VarA = inputStream == null ? null : ui.a(cvVar, this.c, inputStream);
        } else {
            wn0VarA = (wn0) jVar.invoke(cvVar);
        }
        return wn0VarA == null;
    }

    @Override // defpackage.ao0
    public final List b(cv cvVar) {
        return e.Z(this.e.invoke(cvVar));
    }

    @Override // defpackage.ao0
    public final void c(cv cvVar, ArrayList arrayList) {
        e.s0(arrayList, this.e.invoke(cvVar));
    }

    @Override // defpackage.ao0
    public final Collection l(cv cvVar, nw nwVar) {
        return yq.b;
    }
}
