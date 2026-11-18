package defpackage;

import java.util.concurrent.Executors;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class k11 extends yx0 {
    public static final xw0 d;

    static {
        Executors.newScheduledThreadPool(0).shutdown();
        d = new xw0(Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())), "RxSingleScheduler", true);
    }
}
