package com.google.zxing.common;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class StringUtils {
    public static final boolean ASSUME_SHIFT_JIS;
    public static final String PLATFORM_DEFAULT_ENCODING;

    static {
        String strName = Charset.defaultCharset().name();
        PLATFORM_DEFAULT_ENCODING = strName;
        ASSUME_SHIFT_JIS = "SJIS".equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }
}
