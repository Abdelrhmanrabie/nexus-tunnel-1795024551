package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class t30 extends IOException {
    public b0 b;

    public t30(String str) {
        super(str);
        this.b = null;
    }

    public static t30 b() {
        return new t30("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }
}
