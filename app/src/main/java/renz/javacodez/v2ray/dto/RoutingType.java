package renz.javacodez.v2ray.dto;

import defpackage.gr;
import defpackage.hr;
import defpackage.zk;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public enum RoutingType {
    WHITE("custom_routing_white"),
    BLACK("custom_routing_black"),
    GLOBAL("custom_routing_global"),
    WHITE_IRAN("custom_routing_white_iran");

    private final String fileName;
    private static final /* synthetic */ gr $ENTRIES = new hr(values());
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(zk zkVar) {
            this();
        }

        public final RoutingType fromIndex(int i) {
            if (i != 0) {
                if (i == 1) {
                    return RoutingType.BLACK;
                }
                if (i == 2) {
                    return RoutingType.GLOBAL;
                }
                if (i == 3) {
                    return RoutingType.WHITE_IRAN;
                }
            }
            return RoutingType.WHITE;
        }
    }

    RoutingType(String str) {
        this.fileName = str;
    }

    public static gr getEntries() {
        return $ENTRIES;
    }

    public final String getFileName() {
        return this.fileName;
    }
}
