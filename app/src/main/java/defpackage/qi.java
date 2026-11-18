package defpackage;

import java.util.Arrays;
import java.util.List;
import java.util.ServiceConfigurationError;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class qi {
    public static final List a;

    static {
        try {
            p3 p3Var = new p3(ke.f52b);
            p3Var._preHandler = p3Var;
            a = fz0.E(new ug(new ge(5, Arrays.asList(p3Var).iterator())));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
