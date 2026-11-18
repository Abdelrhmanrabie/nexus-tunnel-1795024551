package defpackage;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class h20 implements ta {
    public final ta a;
    public final m6 c;

    /* JADX WARN: Code duplicated, block: B:18:0x0059  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00aa, code lost:
    
        if (defpackage.j20.b(r5) != false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h20(defpackage.ta r10, defpackage.ox r11) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h20.<init>(ta, ox):void");
    }

    @Override // defpackage.ta
    public final List a() {
        return this.a.a();
    }

    @Override // defpackage.ta
    public final Object call(Object[] objArr) {
        Object objInvoke;
        m6 m6Var = this.c;
        y20 y20Var = (y20) m6Var.a;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        int i = y20Var.b;
        int i2 = y20Var.c;
        if (i <= i2) {
            while (true) {
                int i3 = i + 1;
                Method method = ((Method[]) m6Var.b)[i];
                Object objInvoke2 = objArr[i];
                if (method != null) {
                    objInvoke2 = objInvoke2 != null ? method.invoke(objInvoke2, null) : lc1.c(method.getReturnType());
                }
                objArrCopyOf[i] = objInvoke2;
                if (i == i2) {
                    break;
                }
                i = i3;
            }
        }
        Object objCall = this.a.call(objArrCopyOf);
        Method method2 = (Method) m6Var.c;
        return (method2 == null || (objInvoke = method2.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    @Override // defpackage.ta
    public final Type getReturnType() {
        return this.a.getReturnType();
    }
}
