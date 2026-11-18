package renz.javacodez.v2ray.dto;

import defpackage.e;
import defpackage.e4;
import defpackage.zk;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class AssetUrlItem {
    private final long addedTime;
    private long lastUpdated;
    private String remarks;
    private String url;

    public AssetUrlItem() {
        this(null, null, 0L, 0L, 15, null);
    }

    public AssetUrlItem(String str, String str2, long j, long j2) {
        this.remarks = str;
        this.url = str2;
        this.addedTime = j;
        this.lastUpdated = j2;
    }

    public /* synthetic */ AssetUrlItem(String str, String str2, long j, long j2, int i, zk zkVar) {
        this((i & 1) != 0 ? AppConfig.CUSTOM : str, (i & 2) != 0 ? AppConfig.CUSTOM : str2, (i & 4) != 0 ? System.currentTimeMillis() : j, (i & 8) != 0 ? -1L : j2);
    }

    public static /* synthetic */ AssetUrlItem copy$default(AssetUrlItem assetUrlItem, String str, String str2, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = assetUrlItem.remarks;
        }
        if ((i & 2) != 0) {
            str2 = assetUrlItem.url;
        }
        if ((i & 4) != 0) {
            j = assetUrlItem.addedTime;
        }
        if ((i & 8) != 0) {
            j2 = assetUrlItem.lastUpdated;
        }
        long j3 = j2;
        return assetUrlItem.copy(str, str2, j, j3);
    }

    public final String component1() {
        return this.remarks;
    }

    public final String component2() {
        return this.url;
    }

    public final long component3() {
        return this.addedTime;
    }

    public final long component4() {
        return this.lastUpdated;
    }

    public final AssetUrlItem copy(String str, String str2, long j, long j2) {
        return new AssetUrlItem(str, str2, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AssetUrlItem)) {
            return false;
        }
        AssetUrlItem assetUrlItem = (AssetUrlItem) obj;
        return e4.a(this.remarks, assetUrlItem.remarks) && e4.a(this.url, assetUrlItem.url) && this.addedTime == assetUrlItem.addedTime && this.lastUpdated == assetUrlItem.lastUpdated;
    }

    public final long getAddedTime() {
        return this.addedTime;
    }

    public final long getLastUpdated() {
        return this.lastUpdated;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iD = e.d(this.remarks.hashCode() * 31, this.url);
        long j = this.addedTime;
        int i = (iD + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.lastUpdated;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final void setLastUpdated(long j) {
        this.lastUpdated = j;
    }

    public final void setRemarks(String str) {
        this.remarks = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "AssetUrlItem(remarks=" + this.remarks + ", url=" + this.url + ", addedTime=" + this.addedTime + ", lastUpdated=" + this.lastUpdated + ')';
    }
}
