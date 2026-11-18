package renz.javacodez.v2ray.dto;

import defpackage.a7;
import defpackage.gr;
import defpackage.hr;
import defpackage.z;
import defpackage.zk;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum EConfigType {
    VMESS(1, AppConfig.VMESS),
    CUSTOM(2, AppConfig.CUSTOM),
    SHADOWSOCKS(3, AppConfig.SHADOWSOCKS),
    SOCKS(4, AppConfig.SOCKS),
    VLESS(5, AppConfig.VLESS),
    TROJAN(6, AppConfig.TROJAN),
    WIREGUARD(7, AppConfig.WIREGUARD),
    HYSTERIA2(9, AppConfig.HYSTERIA2),
    HTTP(10, AppConfig.HTTP);

    private final String protocolScheme;
    private final int value;
    private static final /* synthetic */ gr $ENTRIES = new hr(values());
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(zk zkVar) {
            this();
        }

        public final EConfigType fromInt(int i) {
            Object next;
            z zVar = (z) EConfigType.getEntries();
            zVar.getClass();
            a7 a7Var = new a7(1, zVar);
            while (a7Var.hasNext()) {
                next = a7Var.next();
                if (((EConfigType) next).getValue() == i) {
                    return (EConfigType) next;
                }
            }
            next = null;
            return (EConfigType) next;
        }
    }

    EConfigType(int i, String str) {
        this.value = i;
        this.protocolScheme = str;
    }

    public static gr getEntries() {
        return $ENTRIES;
    }

    public final String getProtocolScheme() {
        return this.protocolScheme;
    }

    public final int getValue() {
        return this.value;
    }
}
