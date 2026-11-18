package renz.javacodez.v2ray.dto;

import defpackage.e;
import defpackage.e4;
import defpackage.fb$1;
import defpackage.zk;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SubscriptionItem {
    private final long addedTime;
    private boolean autoUpdate;
    private boolean enabled;
    private String filter;
    private long lastUpdated;
    private String nextProfile;
    private String prevProfile;
    private String remarks;
    private final Integer updateInterval;
    private String url;

    public SubscriptionItem() {
        this(null, null, false, 0L, 0L, false, null, null, null, null, 1023, null);
    }

    public SubscriptionItem(String str, String str2, boolean z, long j, long j2, boolean z2, Integer num, String str3, String str4, String str5) {
        this.remarks = str;
        this.url = str2;
        this.enabled = z;
        this.addedTime = j;
        this.lastUpdated = j2;
        this.autoUpdate = z2;
        this.updateInterval = num;
        this.prevProfile = str3;
        this.nextProfile = str4;
        this.filter = str5;
    }

    public /* synthetic */ SubscriptionItem(String str, String str2, boolean z, long j, long j2, boolean z2, Integer num, String str3, String str4, String str5, int i, zk zkVar) {
        this((i & 1) != 0 ? AppConfig.CUSTOM : str, (i & 2) != 0 ? AppConfig.CUSTOM : str2, (i & 4) != 0 ? true : z, (i & 8) != 0 ? System.currentTimeMillis() : j, (i & 16) != 0 ? -1L : j2, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : str5);
    }

    public static /* synthetic */ SubscriptionItem copy$default(SubscriptionItem subscriptionItem, String str, String str2, boolean z, long j, long j2, boolean z2, Integer num, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subscriptionItem.remarks;
        }
        if ((i & 2) != 0) {
            str2 = subscriptionItem.url;
        }
        if ((i & 4) != 0) {
            z = subscriptionItem.enabled;
        }
        if ((i & 8) != 0) {
            j = subscriptionItem.addedTime;
        }
        if ((i & 16) != 0) {
            j2 = subscriptionItem.lastUpdated;
        }
        if ((i & 32) != 0) {
            z2 = subscriptionItem.autoUpdate;
        }
        if ((i & 64) != 0) {
            num = subscriptionItem.updateInterval;
        }
        if ((i & 128) != 0) {
            str3 = subscriptionItem.prevProfile;
        }
        if ((i & 256) != 0) {
            str4 = subscriptionItem.nextProfile;
        }
        if ((i & 512) != 0) {
            str5 = subscriptionItem.filter;
        }
        String str6 = str5;
        String str7 = str3;
        boolean z3 = z2;
        long j3 = j2;
        long j4 = j;
        boolean z4 = z;
        return subscriptionItem.copy(str, str2, z4, j4, j3, z3, num, str7, str4, str6);
    }

    public final String component1() {
        return this.remarks;
    }

    public final String component10() {
        return this.filter;
    }

    public final String component2() {
        return this.url;
    }

    public final boolean component3() {
        return this.enabled;
    }

    public final long component4() {
        return this.addedTime;
    }

    public final long component5() {
        return this.lastUpdated;
    }

    public final boolean component6() {
        return this.autoUpdate;
    }

    public final Integer component7() {
        return this.updateInterval;
    }

    public final String component8() {
        return this.prevProfile;
    }

    public final String component9() {
        return this.nextProfile;
    }

    public final SubscriptionItem copy(String str, String str2, boolean z, long j, long j2, boolean z2, Integer num, String str3, String str4, String str5) {
        return new SubscriptionItem(str, str2, z, j, j2, z2, num, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionItem)) {
            return false;
        }
        SubscriptionItem subscriptionItem = (SubscriptionItem) obj;
        return e4.a(this.remarks, subscriptionItem.remarks) && e4.a(this.url, subscriptionItem.url) && this.enabled == subscriptionItem.enabled && this.addedTime == subscriptionItem.addedTime && this.lastUpdated == subscriptionItem.lastUpdated && this.autoUpdate == subscriptionItem.autoUpdate && e4.a(this.updateInterval, subscriptionItem.updateInterval) && e4.a(this.prevProfile, subscriptionItem.prevProfile) && e4.a(this.nextProfile, subscriptionItem.nextProfile) && e4.a(this.filter, subscriptionItem.filter);
    }

    public final long getAddedTime() {
        return this.addedTime;
    }

    public final boolean getAutoUpdate() {
        return this.autoUpdate;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final long getLastUpdated() {
        return this.lastUpdated;
    }

    public final String getNextProfile() {
        return this.nextProfile;
    }

    public final String getPrevProfile() {
        return this.prevProfile;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public final Integer getUpdateInterval() {
        return this.updateInterval;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iD = e.d(this.remarks.hashCode() * 31, this.url);
        int i = this.enabled ? 1231 : 1237;
        long j = this.addedTime;
        int i2 = (((iD + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.lastUpdated;
        int i3 = (((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.autoUpdate ? 1231 : 1237)) * 31;
        Integer num = this.updateInterval;
        int iHashCode = (i3 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.prevProfile;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nextProfile;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.filter;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setAutoUpdate(boolean z) {
        this.autoUpdate = z;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setFilter(String str) {
        this.filter = str;
    }

    public final void setLastUpdated(long j) {
        this.lastUpdated = j;
    }

    public final void setNextProfile(String str) {
        this.nextProfile = str;
    }

    public final void setPrevProfile(String str) {
        this.prevProfile = str;
    }

    public final void setRemarks(String str) {
        this.remarks = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SubscriptionItem(remarks=");
        sb.append(this.remarks);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", enabled=");
        sb.append(this.enabled);
        sb.append(", addedTime=");
        sb.append(this.addedTime);
        sb.append(", lastUpdated=");
        sb.append(this.lastUpdated);
        sb.append(", autoUpdate=");
        sb.append(this.autoUpdate);
        sb.append(", updateInterval=");
        sb.append(this.updateInterval);
        sb.append(", prevProfile=");
        sb.append(this.prevProfile);
        sb.append(", nextProfile=");
        sb.append(this.nextProfile);
        sb.append(", filter=");
        return fb$1.m(sb, this.filter, ')');
    }
}
