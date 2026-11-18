package defpackage;

import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum lg1 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(AppConfig.CUSTOM),
    BYTE_STRING(fa.b),
    ENUM(null),
    MESSAGE(null);

    public final Object b;

    lg1(Object obj) {
        this.b = obj;
    }
}
