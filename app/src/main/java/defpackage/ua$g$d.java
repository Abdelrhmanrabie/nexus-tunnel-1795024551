package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ua$g$d extends ua.f {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ua$g$d(Method method, boolean z, int i, int i2) {
        super(method, z, i);
        this.G0 = i2;
    }

    @Override // ua.f, defpackage.ta
    public final Object call(Object[] objArr) {
        int i = this.G0;
        b2.a(this, objArr);
        if (i == 0) {
            return e(objArr.length <= 1 ? new Object[0] : ae.A0(1, objArr.length, objArr), objArr[0]);
        }
        if (i != 1) {
            return e(objArr, null);
        }
        d(objArr.length == 0 ? null : objArr[0]);
        return e(objArr.length <= 1 ? new Object[0] : ae.A0(1, objArr.length, objArr), null);
    }
}
