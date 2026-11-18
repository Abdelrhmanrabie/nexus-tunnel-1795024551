package renz.javacodez.v2ray.dto;

import defpackage.e;
import defpackage.e4;
import defpackage.zk;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class RulesetItem {
    private List<String> domain;
    private boolean enabled;
    private List<String> ip;
    private Boolean locked;
    private String network;
    private String outboundTag;
    private String port;
    private List<String> protocol;
    private String remarks;

    public RulesetItem() {
        this(null, null, null, null, null, null, null, false, null, 511, null);
    }

    public RulesetItem(String str, List<String> list, List<String> list2, String str2, String str3, String str4, List<String> list3, boolean z, Boolean bool) {
        this.remarks = str;
        this.ip = list;
        this.domain = list2;
        this.outboundTag = str2;
        this.port = str3;
        this.network = str4;
        this.protocol = list3;
        this.enabled = z;
        this.locked = bool;
    }

    public /* synthetic */ RulesetItem(String str, List list, List list2, String str2, String str3, String str4, List list3, boolean z, Boolean bool, int i, zk zkVar) {
        this((i & 1) != 0 ? AppConfig.CUSTOM : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? AppConfig.CUSTOM : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : list3, (i & 128) != 0 ? true : z, (i & 256) != 0 ? Boolean.FALSE : bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RulesetItem copy$default(RulesetItem rulesetItem, String str, List list, List list2, String str2, String str3, String str4, List list3, boolean z, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rulesetItem.remarks;
        }
        if ((i & 2) != 0) {
            list = rulesetItem.ip;
        }
        if ((i & 4) != 0) {
            list2 = rulesetItem.domain;
        }
        if ((i & 8) != 0) {
            str2 = rulesetItem.outboundTag;
        }
        if ((i & 16) != 0) {
            str3 = rulesetItem.port;
        }
        if ((i & 32) != 0) {
            str4 = rulesetItem.network;
        }
        if ((i & 64) != 0) {
            list3 = rulesetItem.protocol;
        }
        if ((i & 128) != 0) {
            z = rulesetItem.enabled;
        }
        if ((i & 256) != 0) {
            bool = rulesetItem.locked;
        }
        boolean z2 = z;
        Boolean bool2 = bool;
        String str5 = str4;
        List list4 = list3;
        String str6 = str3;
        List list5 = list2;
        return rulesetItem.copy(str, list, list5, str2, str6, str5, list4, z2, bool2);
    }

    public final String component1() {
        return this.remarks;
    }

    public final List<String> component2() {
        return this.ip;
    }

    public final List<String> component3() {
        return this.domain;
    }

    public final String component4() {
        return this.outboundTag;
    }

    public final String component5() {
        return this.port;
    }

    public final String component6() {
        return this.network;
    }

    public final List<String> component7() {
        return this.protocol;
    }

    public final boolean component8() {
        return this.enabled;
    }

    public final Boolean component9() {
        return this.locked;
    }

    public final RulesetItem copy(String str, List<String> list, List<String> list2, String str2, String str3, String str4, List<String> list3, boolean z, Boolean bool) {
        return new RulesetItem(str, list, list2, str2, str3, str4, list3, z, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RulesetItem)) {
            return false;
        }
        RulesetItem rulesetItem = (RulesetItem) obj;
        return e4.a(this.remarks, rulesetItem.remarks) && e4.a(this.ip, rulesetItem.ip) && e4.a(this.domain, rulesetItem.domain) && e4.a(this.outboundTag, rulesetItem.outboundTag) && e4.a(this.port, rulesetItem.port) && e4.a(this.network, rulesetItem.network) && e4.a(this.protocol, rulesetItem.protocol) && this.enabled == rulesetItem.enabled && e4.a(this.locked, rulesetItem.locked);
    }

    public final List<String> getDomain() {
        return this.domain;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> getIp() {
        return this.ip;
    }

    public final Boolean getLocked() {
        return this.locked;
    }

    public final String getNetwork() {
        return this.network;
    }

    public final String getOutboundTag() {
        return this.outboundTag;
    }

    public final String getPort() {
        return this.port;
    }

    public final List<String> getProtocol() {
        return this.protocol;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public int hashCode() {
        String str = this.remarks;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.ip;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.domain;
        int iD = e.d((iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31, this.outboundTag);
        String str2 = this.port;
        int iHashCode3 = (iD + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.network;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list3 = this.protocol;
        int iHashCode5 = (((iHashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31) + (this.enabled ? 1231 : 1237)) * 31;
        Boolean bool = this.locked;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setDomain(List<String> list) {
        this.domain = list;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setIp(List<String> list) {
        this.ip = list;
    }

    public final void setLocked(Boolean bool) {
        this.locked = bool;
    }

    public final void setNetwork(String str) {
        this.network = str;
    }

    public final void setOutboundTag(String str) {
        this.outboundTag = str;
    }

    public final void setPort(String str) {
        this.port = str;
    }

    public final void setProtocol(List<String> list) {
        this.protocol = list;
    }

    public final void setRemarks(String str) {
        this.remarks = str;
    }

    public String toString() {
        return "RulesetItem(remarks=" + this.remarks + ", ip=" + this.ip + ", domain=" + this.domain + ", outboundTag=" + this.outboundTag + ", port=" + this.port + ", network=" + this.network + ", protocol=" + this.protocol + ", enabled=" + this.enabled + ", locked=" + this.locked + ')';
    }
}
