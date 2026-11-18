package defpackage;

import java.util.Random;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {
    public static final h0 c;

    static {
        Integer num = e40$a.a;
        c = (num == null || num.intValue() >= 34) ? new dp0() : new ts();
    }

    public abstract Random b();
}
