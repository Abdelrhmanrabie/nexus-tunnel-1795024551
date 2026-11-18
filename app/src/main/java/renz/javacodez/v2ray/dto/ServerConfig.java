package renz.javacodez.v2ray.dto;

import defpackage.ae;
import defpackage.d;
import defpackage.e;
import defpackage.e4;
import defpackage.zk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ServerConfig {
    public static final Companion Companion = new Companion(null);
    private final long addedTime;
    private final EConfigType configType;
    private final int configVersion;
    private V2rayConfig fullConfig;
    private final V2rayConfig.OutboundBean outboundBean;
    private String remarks;
    private String subscriptionId;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Companion {

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[EConfigType.values().length];
                try {
                    iArr[EConfigType.VMESS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EConfigType.VLESS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EConfigType.CUSTOM.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EConfigType.SHADOWSOCKS.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[EConfigType.SOCKS.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[EConfigType.HTTP.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[EConfigType.TROJAN.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[EConfigType.HYSTERIA2.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[EConfigType.WIREGUARD.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(zk zkVar) {
            this();
        }

        public final ServerConfig create(EConfigType eConfigType) {
            switch (WhenMappings.$EnumSwitchMapping$0[eConfigType.ordinal()]) {
                case 1:
                case 2:
                    return new ServerConfig(0, eConfigType, null, 0L, null, new V2rayConfig.OutboundBean(null, eConfigType.name().toLowerCase(Locale.ROOT), new V2rayConfig.OutboundBean.OutSettingsBean(Collections.singletonList(new V2rayConfig.OutboundBean.OutSettingsBean.VnextBean(null, 0, Collections.singletonList(new V2rayConfig.OutboundBean.OutSettingsBean.VnextBean.UsersBean(null, null, null, 0, null, null, 63, null)), 3, null)), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131070, null), new V2rayConfig.OutboundBean.StreamSettingsBean(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null), null, null, null, 113, null), null, 93, null);
                case 3:
                    return new ServerConfig(0, eConfigType, null, 0L, null, null, null, R.styleable.AppCompatTheme_windowMinWidthMinor, null);
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    V2rayConfig v2rayConfig = null;
                    return new ServerConfig(0, eConfigType, null, 0L, null, new V2rayConfig.OutboundBean(null, eConfigType.name().toLowerCase(Locale.ROOT), new V2rayConfig.OutboundBean.OutSettingsBean(null, null, null, Collections.singletonList(new V2rayConfig.OutboundBean.OutSettingsBean.ServersBean(null, null, false, null, 0, 0, null, null, null, null, 1023, null)), null, null, null, null, null, null, null, null, null, null, null, null, null, 131063, null), new V2rayConfig.OutboundBean.StreamSettingsBean(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null), null, null, null, 113, null), v2rayConfig, 93, null);
                case 9:
                    return new ServerConfig(0, eConfigType, null, 0L, null, new V2rayConfig.OutboundBean(null, eConfigType.name().toLowerCase(Locale.ROOT), new V2rayConfig.OutboundBean.OutSettingsBean(null, null, null, null, null, null, null, null, null, null, null, null, AppConfig.CUSTOM, Collections.singletonList(new V2rayConfig.OutboundBean.OutSettingsBean.WireGuardBean(null, null, null, 7, null)), null, null, null, 118783, null), null, null, null, null, 121, null), null, 93, null);
                default:
                    d.AnonymousClass0.m();
                    return null;
            }
        }
    }

    public ServerConfig(int i, EConfigType eConfigType, String str, long j, String str2, V2rayConfig.OutboundBean outboundBean, V2rayConfig v2rayConfig) {
        this.configVersion = i;
        this.configType = eConfigType;
        this.subscriptionId = str;
        this.addedTime = j;
        this.remarks = str2;
        this.outboundBean = outboundBean;
        this.fullConfig = v2rayConfig;
    }

    public /* synthetic */ ServerConfig(int i, EConfigType eConfigType, String str, long j, String str2, V2rayConfig.OutboundBean outboundBean, V2rayConfig v2rayConfig, int i2, zk zkVar) {
        this((i2 & 1) != 0 ? 3 : i, eConfigType, (i2 & 4) != 0 ? AppConfig.CUSTOM : str, (i2 & 8) != 0 ? System.currentTimeMillis() : j, (i2 & 16) != 0 ? AppConfig.CUSTOM : str2, (i2 & 32) != 0 ? null : outboundBean, (i2 & 64) != 0 ? null : v2rayConfig);
    }

    public static /* synthetic */ ServerConfig copy$default(ServerConfig serverConfig, int i, EConfigType eConfigType, String str, long j, String str2, V2rayConfig.OutboundBean outboundBean, V2rayConfig v2rayConfig, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = serverConfig.configVersion;
        }
        if ((i2 & 2) != 0) {
            eConfigType = serverConfig.configType;
        }
        if ((i2 & 4) != 0) {
            str = serverConfig.subscriptionId;
        }
        if ((i2 & 8) != 0) {
            j = serverConfig.addedTime;
        }
        if ((i2 & 16) != 0) {
            str2 = serverConfig.remarks;
        }
        if ((i2 & 32) != 0) {
            outboundBean = serverConfig.outboundBean;
        }
        if ((i2 & 64) != 0) {
            v2rayConfig = serverConfig.fullConfig;
        }
        V2rayConfig v2rayConfig2 = v2rayConfig;
        String str3 = str2;
        long j2 = j;
        String str4 = str;
        return serverConfig.copy(i, eConfigType, str4, j2, str3, outboundBean, v2rayConfig2);
    }

    public final int component1() {
        return this.configVersion;
    }

    public final EConfigType component2() {
        return this.configType;
    }

    public final String component3() {
        return this.subscriptionId;
    }

    public final long component4() {
        return this.addedTime;
    }

    public final String component5() {
        return this.remarks;
    }

    public final V2rayConfig.OutboundBean component6() {
        return this.outboundBean;
    }

    public final V2rayConfig component7() {
        return this.fullConfig;
    }

    public final ServerConfig copy(int i, EConfigType eConfigType, String str, long j, String str2, V2rayConfig.OutboundBean outboundBean, V2rayConfig v2rayConfig) {
        return new ServerConfig(i, eConfigType, str, j, str2, outboundBean, v2rayConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServerConfig)) {
            return false;
        }
        ServerConfig serverConfig = (ServerConfig) obj;
        return this.configVersion == serverConfig.configVersion && this.configType == serverConfig.configType && e4.a(this.subscriptionId, serverConfig.subscriptionId) && this.addedTime == serverConfig.addedTime && e4.a(this.remarks, serverConfig.remarks) && e4.a(this.outboundBean, serverConfig.outboundBean) && e4.a(this.fullConfig, serverConfig.fullConfig);
    }

    public final long getAddedTime() {
        return this.addedTime;
    }

    public final List<String> getAllOutboundTags() {
        if (this.configType != EConfigType.CUSTOM) {
            return e.d0(AppConfig.TAG_PROXY, AppConfig.TAG_DIRECT, AppConfig.TAG_BLOCKED);
        }
        V2rayConfig v2rayConfig = this.fullConfig;
        if (v2rayConfig == null) {
            return new ArrayList();
        }
        ArrayList<V2rayConfig.OutboundBean> outbounds = v2rayConfig.getOutbounds();
        ArrayList arrayList = new ArrayList(ae.y0(outbounds));
        Iterator<T> it = outbounds.iterator();
        while (it.hasNext()) {
            arrayList.add(((V2rayConfig.OutboundBean) it.next()).getTag());
        }
        return new ArrayList(arrayList);
    }

    public final EConfigType getConfigType() {
        return this.configType;
    }

    public final int getConfigVersion() {
        return this.configVersion;
    }

    public final V2rayConfig getFullConfig() {
        return this.fullConfig;
    }

    public final V2rayConfig.OutboundBean getOutboundBean() {
        return this.outboundBean;
    }

    public final V2rayConfig.OutboundBean getProxyOutbound() {
        if (this.configType != EConfigType.CUSTOM) {
            return this.outboundBean;
        }
        V2rayConfig v2rayConfig = this.fullConfig;
        if (v2rayConfig != null) {
            return v2rayConfig.getProxyOutbound();
        }
        return null;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public int hashCode() {
        int iD = e.d((this.configType.hashCode() + (this.configVersion * 31)) * 31, this.subscriptionId);
        long j = this.addedTime;
        int iD2 = e.d((iD + ((int) (j ^ (j >>> 32)))) * 31, this.remarks);
        V2rayConfig.OutboundBean outboundBean = this.outboundBean;
        int iHashCode = (iD2 + (outboundBean == null ? 0 : outboundBean.hashCode())) * 31;
        V2rayConfig v2rayConfig = this.fullConfig;
        return iHashCode + (v2rayConfig != null ? v2rayConfig.hashCode() : 0);
    }

    public final void setFullConfig(V2rayConfig v2rayConfig) {
        this.fullConfig = v2rayConfig;
    }

    public final void setRemarks(String str) {
        this.remarks = str;
    }

    public final void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    public String toString() {
        return "ServerConfig(configVersion=" + this.configVersion + ", configType=" + this.configType + ", subscriptionId=" + this.subscriptionId + ", addedTime=" + this.addedTime + ", remarks=" + this.remarks + ", outboundBean=" + this.outboundBean + ", fullConfig=" + this.fullConfig + ')';
    }
}
