package org.apache.http.conn.ssl;

import defpackage.ak;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SubjectName {
    public final int type;
    public final String value;

    public SubjectName(String str, int i) {
        this.value = str;
        if (i <= 0) {
            throw new IllegalArgumentException(ak.j("Type", " may not be negative or zero"));
        }
        this.type = i;
    }

    public final String toString() {
        return this.value;
    }
}
