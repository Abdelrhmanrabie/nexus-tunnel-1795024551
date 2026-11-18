package renz.javacodez.v2ray.dto;

import defpackage.e;
import defpackage.e4;
import defpackage.zk;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileLiteItem {
    private final EConfigType configType;
    private String remarks;
    private String server;
    private Integer serverPort;
    private String subscriptionId;

    public ProfileLiteItem(EConfigType eConfigType, String str, String str2, String str3, Integer num) {
        this.configType = eConfigType;
        this.subscriptionId = str;
        this.remarks = str2;
        this.server = str3;
        this.serverPort = num;
    }

    public /* synthetic */ ProfileLiteItem(EConfigType eConfigType, String str, String str2, String str3, Integer num, int i, zk zkVar) {
        this(eConfigType, (i & 2) != 0 ? AppConfig.CUSTOM : str, (i & 4) != 0 ? AppConfig.CUSTOM : str2, str3, num);
    }

    public static /* synthetic */ ProfileLiteItem copy$default(ProfileLiteItem profileLiteItem, EConfigType eConfigType, String str, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            eConfigType = profileLiteItem.configType;
        }
        if ((i & 2) != 0) {
            str = profileLiteItem.subscriptionId;
        }
        if ((i & 4) != 0) {
            str2 = profileLiteItem.remarks;
        }
        if ((i & 8) != 0) {
            str3 = profileLiteItem.server;
        }
        if ((i & 16) != 0) {
            num = profileLiteItem.serverPort;
        }
        Integer num2 = num;
        String str4 = str2;
        return profileLiteItem.copy(eConfigType, str, str4, str3, num2);
    }

    public final EConfigType component1() {
        return this.configType;
    }

    public final String component2() {
        return this.subscriptionId;
    }

    public final String component3() {
        return this.remarks;
    }

    public final String component4() {
        return this.server;
    }

    public final Integer component5() {
        return this.serverPort;
    }

    public final ProfileLiteItem copy(EConfigType eConfigType, String str, String str2, String str3, Integer num) {
        return new ProfileLiteItem(eConfigType, str, str2, str3, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileLiteItem)) {
            return false;
        }
        ProfileLiteItem profileLiteItem = (ProfileLiteItem) obj;
        return this.configType == profileLiteItem.configType && e4.a(this.subscriptionId, profileLiteItem.subscriptionId) && e4.a(this.remarks, profileLiteItem.remarks) && e4.a(this.server, profileLiteItem.server) && e4.a(this.serverPort, profileLiteItem.serverPort);
    }

    public final EConfigType getConfigType() {
        return this.configType;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public final String getServer() {
        return this.server;
    }

    public final Integer getServerPort() {
        return this.serverPort;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public int hashCode() {
        int iD = e.d(e.d(this.configType.hashCode() * 31, this.subscriptionId), this.remarks);
        String str = this.server;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.serverPort;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final void setRemarks(String str) {
        this.remarks = str;
    }

    public final void setServer(String str) {
        this.server = str;
    }

    public final void setServerPort(Integer num) {
        this.serverPort = num;
    }

    public final void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    public String toString() {
        return "ProfileLiteItem(configType=" + this.configType + ", subscriptionId=" + this.subscriptionId + ", remarks=" + this.remarks + ", server=" + this.server + ", serverPort=" + this.serverPort + ')';
    }
}
