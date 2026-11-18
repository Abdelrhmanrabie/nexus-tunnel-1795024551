package renz.javacodez.v2ray.dto;

import defpackage.e;
import defpackage.e4;
import defpackage.fb$1;
import defpackage.zk;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ConfigResult {
    private String content;
    private String domainPort;
    private String guid;
    private boolean status;

    public ConfigResult(boolean z, String str, String str2, String str3) {
        this.status = z;
        this.guid = str;
        this.content = str2;
        this.domainPort = str3;
    }

    public /* synthetic */ ConfigResult(boolean z, String str, String str2, String str3, int i, zk zkVar) {
        this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? AppConfig.CUSTOM : str2, (i & 8) != 0 ? null : str3);
    }

    public static /* synthetic */ ConfigResult copy$default(ConfigResult configResult, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = configResult.status;
        }
        if ((i & 2) != 0) {
            str = configResult.guid;
        }
        if ((i & 4) != 0) {
            str2 = configResult.content;
        }
        if ((i & 8) != 0) {
            str3 = configResult.domainPort;
        }
        return configResult.copy(z, str, str2, str3);
    }

    public final boolean component1() {
        return this.status;
    }

    public final String component2() {
        return this.guid;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.domainPort;
    }

    public final ConfigResult copy(boolean z, String str, String str2, String str3) {
        return new ConfigResult(z, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigResult)) {
            return false;
        }
        ConfigResult configResult = (ConfigResult) obj;
        return this.status == configResult.status && e4.a(this.guid, configResult.guid) && e4.a(this.content, configResult.content) && e4.a(this.domainPort, configResult.domainPort);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDomainPort() {
        return this.domainPort;
    }

    public final String getGuid() {
        return this.guid;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i = (this.status ? 1231 : 1237) * 31;
        String str = this.guid;
        int iD = e.d((i + (str == null ? 0 : str.hashCode())) * 31, this.content);
        String str2 = this.domainPort;
        return iD + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setDomainPort(String str) {
        this.domainPort = str;
    }

    public final void setGuid(String str) {
        this.guid = str;
    }

    public final void setStatus(boolean z) {
        this.status = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConfigResult(status=");
        sb.append(this.status);
        sb.append(", guid=");
        sb.append(this.guid);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", domainPort=");
        return fb$1.m(sb, this.domainPort, ')');
    }
}
