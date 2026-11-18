package com.trilead.ssh2;

import defpackage.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class DHGexParameters {
    private static final int MAX_ALLOWED = 8192;
    private static final int MIN_ALLOWED = 1024;
    private final int max_group_len;
    private final int min_group_len;
    private final int pref_group_len;

    public DHGexParameters() {
        this(1024, 1024, 4096);
    }

    public DHGexParameters(int i) {
        if (i < 1024 || i > 8192) {
            d.AnonymousClass0.m$2("pref_group_len out of range!");
            throw null;
        }
        this.pref_group_len = i;
        this.min_group_len = 0;
        this.max_group_len = 0;
    }

    public DHGexParameters(int i, int i2, int i3) {
        if (i < 1024 || i > 8192) {
            d.AnonymousClass0.m$2("min_group_len out of range!");
            throw null;
        }
        if (i2 < 1024 || i2 > 8192) {
            d.AnonymousClass0.m$2("pref_group_len out of range!");
            throw null;
        }
        if (i3 < 1024 || i3 > 8192) {
            d.AnonymousClass0.m$2("max_group_len out of range!");
            throw null;
        }
        if (i2 < i || i2 > i3) {
            d.AnonymousClass0.m$2("pref_group_len is incompatible with min and max!");
            throw null;
        }
        if (i3 < i) {
            d.AnonymousClass0.m$2("max_group_len must not be smaller than min_group_len!");
            throw null;
        }
        this.min_group_len = i;
        this.pref_group_len = i2;
        this.max_group_len = i3;
    }

    public int getMax_group_len() {
        return this.max_group_len;
    }

    public int getMin_group_len() {
        return this.min_group_len;
    }

    public int getPref_group_len() {
        return this.pref_group_len;
    }
}
