package com.google.crypto.tink.internal;

import com.google.crypto.tink.subtle.Hex;
import defpackage.m6;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Ed25519$XYZT {
    public final long[] t;
    public final m6 xyz;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Ed25519$XYZT(int i) {
        this(new m6(3), new long[10]);
        if (i != 1) {
            return;
        }
        Ed25519$XYZT ed25519$XYZT = Hex.NEUTRAL;
        this.xyz = new m6(ed25519$XYZT.xyz);
        this.t = Arrays.copyOf(ed25519$XYZT.t, 10);
    }

    public Ed25519$XYZT(Ed25519$XYZT ed25519$XYZT) {
        this(0);
        fromPartialXYZT(this, ed25519$XYZT);
    }

    public /* synthetic */ Ed25519$XYZT(m6 m6Var, long[] jArr) {
        this.xyz = m6Var;
        this.t = jArr;
    }

    public static void fromPartialXYZT(Ed25519$XYZT ed25519$XYZT, Ed25519$XYZT ed25519$XYZT2) {
        m6 m6Var = ed25519$XYZT.xyz;
        long[] jArr = (long[]) m6Var.a;
        m6 m6Var2 = ed25519$XYZT2.xyz;
        long[] jArr2 = (long[]) m6Var2.a;
        long[] jArr3 = ed25519$XYZT2.t;
        Hex.mult(jArr, jArr2, jArr3);
        long[] jArr4 = (long[]) m6Var.b;
        long[] jArr5 = (long[]) m6Var2.b;
        long[] jArr6 = (long[]) m6Var2.c;
        Hex.mult(jArr4, jArr5, jArr6);
        Hex.mult((long[]) m6Var.c, jArr6, jArr3);
        Hex.mult(ed25519$XYZT.t, (long[]) m6Var2.a, (long[]) m6Var2.b);
    }
}
