package defpackage;

import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class t61 implements ta {
    public static final t61 a = new t61();

    @Override // defpackage.ta
    public final List a() {
        return uq.b;
    }

    @Override // defpackage.ta
    public final Object call(Object[] objArr) {
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    @Override // defpackage.ta
    public final Type getReturnType() {
        return Void.TYPE;
    }
}
