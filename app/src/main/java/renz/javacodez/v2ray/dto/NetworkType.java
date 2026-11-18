package renz.javacodez.v2ray.dto;

import defpackage.a7;
import defpackage.e4;
import defpackage.gr;
import defpackage.hr;
import defpackage.z;
import defpackage.zk;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum NetworkType {
    TCP(AppConfig.DEFAULT_NETWORK),
    KCP("kcp"),
    WS("ws"),
    HTTP_UPGRADE("httpupgrade"),
    XHTTP("xhttp"),
    HTTP(AppConfig.HEADER_TYPE_HTTP),
    H2("h2"),
    GRPC("grpc"),
    SPLIT_HTTP("splithttp");

    private final String type;
    private static final /* synthetic */ gr $ENTRIES = new hr(values());
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(zk zkVar) {
            this();
        }

        public final NetworkType fromString(String str) {
            Object next;
            z zVar = (z) NetworkType.getEntries();
            zVar.getClass();
            a7 a7Var = new a7(1, zVar);
            do {
                if (!a7Var.hasNext()) {
                    next = null;
                    break;
                }
                next = a7Var.next();
            } while (!e4.a(((NetworkType) next).getType(), str));
            NetworkType networkType = (NetworkType) next;
            return networkType == null ? NetworkType.TCP : networkType;
        }
    }

    NetworkType(String str) {
        this.type = str;
    }

    public static gr getEntries() {
        return $ENTRIES;
    }

    public final String getType() {
        return this.type;
    }
}
