package com.google.crypto.tink.internal;

import com.google.crypto.tink.subtle.Hex;
import java.util.Arrays;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Ed25519$CachedXYT {
    public final long[] t2d;
    public final long[] yMinusX;
    public final long[] yPlusX;

    public Ed25519$CachedXYT() {
        Ed25519$CachedXYT ed25519$CachedXYT = Hex.CACHED_NEUTRAL;
        this.yPlusX = Arrays.copyOf(ed25519$CachedXYT.yPlusX, 10);
        this.yMinusX = Arrays.copyOf(ed25519$CachedXYT.yMinusX, 10);
        this.t2d = Arrays.copyOf(ed25519$CachedXYT.t2d, 10);
    }

    public Ed25519$CachedXYT(long[] jArr, long[] jArr2, long[] jArr3) {
        this.yPlusX = jArr;
        this.yMinusX = jArr2;
        this.t2d = jArr3;
    }

    public final void copyConditional(Ed25519$CachedXYT ed25519$CachedXYT, int i) {
        Hex.copyConditional(this.yPlusX, ed25519$CachedXYT.yPlusX, i);
        Hex.copyConditional(this.yMinusX, ed25519$CachedXYT.yMinusX, i);
        Hex.copyConditional(this.t2d, ed25519$CachedXYT.t2d, i);
    }

    public void multByZ(long[] jArr, long[] jArr2) {
        System.arraycopy(jArr2, 0, jArr, 0, 10);
    }
}
