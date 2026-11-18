package com.android.volley;

import android.text.TextUtils;
import defpackage.fb$1;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Header {
    public final String mName;
    public final String mValue;

    public Header(String str, String str2) {
        this.mName = str;
        this.mValue = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Header.class != obj.getClass()) {
            return false;
        }
        Header header = (Header) obj;
        return TextUtils.equals(this.mName, header.mName) && TextUtils.equals(this.mValue, header.mValue);
    }

    public final int hashCode() {
        return this.mValue.hashCode() + (this.mName.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Header[name=");
        sb.append(this.mName);
        sb.append(",value=");
        return fb$1.m(sb, this.mValue, "]");
    }
}
