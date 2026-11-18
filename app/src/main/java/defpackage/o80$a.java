package defpackage;

import java.util.Arrays;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class o80$a extends e4 {
    public final List a;

    public o80$a(Class cls) {
        Object[] declaredMethods = cls.getDeclaredMethods();
        nu nuVar = new nu(2);
        if (declaredMethods.length != 0) {
            declaredMethods = Arrays.copyOf(declaredMethods, declaredMethods.length);
            if (declaredMethods.length > 1) {
                Arrays.sort(declaredMethods, nuVar);
            }
        }
        int i = ae.$r8$clinit;
        this.a = Arrays.asList(declaredMethods);
    }

    @Override // defpackage.e4
    public final String a() {
        return he.R0(this.a, AppConfig.CUSTOM, "<init>(", ")V", ld0.b$24, 24);
    }
}
