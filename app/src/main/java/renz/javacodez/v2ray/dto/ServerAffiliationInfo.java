package renz.javacodez.v2ray.dto;

import defpackage.zk;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ServerAffiliationInfo {
    private long testDelayMillis;

    public ServerAffiliationInfo() {
        this(0L, 1, null);
    }

    public ServerAffiliationInfo(long j) {
        this.testDelayMillis = j;
    }

    public /* synthetic */ ServerAffiliationInfo(long j, int i, zk zkVar) {
        this((i & 1) != 0 ? 0L : j);
    }

    public static /* synthetic */ ServerAffiliationInfo copy$default(ServerAffiliationInfo serverAffiliationInfo, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = serverAffiliationInfo.testDelayMillis;
        }
        return serverAffiliationInfo.copy(j);
    }

    public final long component1() {
        return this.testDelayMillis;
    }

    public final ServerAffiliationInfo copy(long j) {
        return new ServerAffiliationInfo(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ServerAffiliationInfo) && this.testDelayMillis == ((ServerAffiliationInfo) obj).testDelayMillis;
    }

    public final long getTestDelayMillis() {
        return this.testDelayMillis;
    }

    public final String getTestDelayString() {
        if (this.testDelayMillis == 0) {
            return AppConfig.CUSTOM;
        }
        return this.testDelayMillis + "ms";
    }

    public int hashCode() {
        long j = this.testDelayMillis;
        return (int) (j ^ (j >>> 32));
    }

    public final void setTestDelayMillis(long j) {
        this.testDelayMillis = j;
    }

    public String toString() {
        return "ServerAffiliationInfo(testDelayMillis=" + this.testDelayMillis + ')';
    }
}
