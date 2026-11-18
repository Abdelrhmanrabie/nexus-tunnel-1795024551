package defpackage;

import java.util.Collections;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class w60 {
    public static final cv a = new cv("java.lang.Class");

    public static final ca1 a(v91 v91Var, n60 n60Var) {
        return n60Var.a == 1 ? new da1(e.r1(v91Var)) : new da1(v91Var);
    }

    public static n60 b(int i, boolean z, td0 td0Var, int i2) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            td0Var = null;
        }
        ak.r(i, "<this>");
        return new n60(i, z, td0Var != null ? Collections.singleton(td0Var) : null, 18);
    }
}
