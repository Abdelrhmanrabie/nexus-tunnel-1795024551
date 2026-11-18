package renz.javacodez.v2ray.dto;

import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.a7;
import defpackage.ae;
import defpackage.d;
import defpackage.e;
import defpackage.e4;
import defpackage.fb$1;
import defpackage.he;
import defpackage.n70;
import defpackage.q31;
import defpackage.z;
import defpackage.zk;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class V2rayConfig {
    private final Object api;
    private final Object browserForwarder;
    private Object burstObservatory;
    private DnsBean dns;
    private Object fakedns;
    private final ArrayList<InboundBean> inbounds;
    private final LogBean log;
    private Object observatory;
    private ArrayList<OutboundBean> outbounds;
    private PolicyBean policy;
    private String remarks;
    private final Object reverse;
    private final RoutingBean routing;
    private Object stats;
    private final Object transport;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class DnsBean {
        private final String clientIp;
        private final Boolean disableCache;
        private Map<String, ? extends Object> hosts;
        private final String queryStrategy;
        private ArrayList<Object> servers;
        private final String tag;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class ServersBean {
            private String address;
            private final String clientIp;
            private List<String> domains;
            private List<String> expectIPs;
            private Integer port;
            private final Boolean skipFallback;

            public ServersBean() {
                this(null, null, null, null, null, null, 63, null);
            }

            public ServersBean(String str, Integer num, List<String> list, List<String> list2, String str2, Boolean bool) {
                this.address = str;
                this.port = num;
                this.domains = list;
                this.expectIPs = list2;
                this.clientIp = str2;
                this.skipFallback = bool;
            }

            public /* synthetic */ ServersBean(String str, Integer num, List list, List list2, String str2, Boolean bool, int i, zk zkVar) {
                this((i & 1) != 0 ? AppConfig.CUSTOM : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : bool);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ServersBean copy$default(ServersBean serversBean, String str, Integer num, List list, List list2, String str2, Boolean bool, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = serversBean.address;
                }
                if ((i & 2) != 0) {
                    num = serversBean.port;
                }
                if ((i & 4) != 0) {
                    list = serversBean.domains;
                }
                if ((i & 8) != 0) {
                    list2 = serversBean.expectIPs;
                }
                if ((i & 16) != 0) {
                    str2 = serversBean.clientIp;
                }
                if ((i & 32) != 0) {
                    bool = serversBean.skipFallback;
                }
                String str3 = str2;
                Boolean bool2 = bool;
                return serversBean.copy(str, num, list, list2, str3, bool2);
            }

            public final String component1() {
                return this.address;
            }

            public final Integer component2() {
                return this.port;
            }

            public final List<String> component3() {
                return this.domains;
            }

            public final List<String> component4() {
                return this.expectIPs;
            }

            public final String component5() {
                return this.clientIp;
            }

            public final Boolean component6() {
                return this.skipFallback;
            }

            public final ServersBean copy(String str, Integer num, List<String> list, List<String> list2, String str2, Boolean bool) {
                return new ServersBean(str, num, list, list2, str2, bool);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ServersBean)) {
                    return false;
                }
                ServersBean serversBean = (ServersBean) obj;
                return e4.a(this.address, serversBean.address) && e4.a(this.port, serversBean.port) && e4.a(this.domains, serversBean.domains) && e4.a(this.expectIPs, serversBean.expectIPs) && e4.a(this.clientIp, serversBean.clientIp) && e4.a(this.skipFallback, serversBean.skipFallback);
            }

            public final String getAddress() {
                return this.address;
            }

            public final String getClientIp() {
                return this.clientIp;
            }

            public final List<String> getDomains() {
                return this.domains;
            }

            public final List<String> getExpectIPs() {
                return this.expectIPs;
            }

            public final Integer getPort() {
                return this.port;
            }

            public final Boolean getSkipFallback() {
                return this.skipFallback;
            }

            public int hashCode() {
                int iHashCode = this.address.hashCode() * 31;
                Integer num = this.port;
                int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
                List<String> list = this.domains;
                int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
                List<String> list2 = this.expectIPs;
                int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
                String str = this.clientIp;
                int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
                Boolean bool = this.skipFallback;
                return iHashCode5 + (bool != null ? bool.hashCode() : 0);
            }

            public final void setAddress(String str) {
                this.address = str;
            }

            public final void setDomains(List<String> list) {
                this.domains = list;
            }

            public final void setExpectIPs(List<String> list) {
                this.expectIPs = list;
            }

            public final void setPort(Integer num) {
                this.port = num;
            }

            public String toString() {
                return "ServersBean(address=" + this.address + ", port=" + this.port + ", domains=" + this.domains + ", expectIPs=" + this.expectIPs + ", clientIp=" + this.clientIp + ", skipFallback=" + this.skipFallback + ')';
            }
        }

        public DnsBean() {
            this(null, null, null, null, null, null, 63, null);
        }

        public DnsBean(ArrayList<Object> arrayList, Map<String, ? extends Object> map, String str, Boolean bool, String str2, String str3) {
            this.servers = arrayList;
            this.hosts = map;
            this.clientIp = str;
            this.disableCache = bool;
            this.queryStrategy = str2;
            this.tag = str3;
        }

        public /* synthetic */ DnsBean(ArrayList arrayList, Map map, String str, Boolean bool, String str2, String str3, int i, zk zkVar) {
            this((i & 1) != 0 ? null : arrayList, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DnsBean copy$default(DnsBean dnsBean, ArrayList arrayList, Map map, String str, Boolean bool, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = dnsBean.servers;
            }
            if ((i & 2) != 0) {
                map = dnsBean.hosts;
            }
            if ((i & 4) != 0) {
                str = dnsBean.clientIp;
            }
            if ((i & 8) != 0) {
                bool = dnsBean.disableCache;
            }
            if ((i & 16) != 0) {
                str2 = dnsBean.queryStrategy;
            }
            if ((i & 32) != 0) {
                str3 = dnsBean.tag;
            }
            String str4 = str2;
            String str5 = str3;
            return dnsBean.copy(arrayList, map, str, bool, str4, str5);
        }

        public final ArrayList<Object> component1() {
            return this.servers;
        }

        public final Map<String, Object> component2() {
            return this.hosts;
        }

        public final String component3() {
            return this.clientIp;
        }

        public final Boolean component4() {
            return this.disableCache;
        }

        public final String component5() {
            return this.queryStrategy;
        }

        public final String component6() {
            return this.tag;
        }

        public final DnsBean copy(ArrayList<Object> arrayList, Map<String, ? extends Object> map, String str, Boolean bool, String str2, String str3) {
            return new DnsBean(arrayList, map, str, bool, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DnsBean)) {
                return false;
            }
            DnsBean dnsBean = (DnsBean) obj;
            return e4.a(this.servers, dnsBean.servers) && e4.a(this.hosts, dnsBean.hosts) && e4.a(this.clientIp, dnsBean.clientIp) && e4.a(this.disableCache, dnsBean.disableCache) && e4.a(this.queryStrategy, dnsBean.queryStrategy) && e4.a(this.tag, dnsBean.tag);
        }

        public final String getClientIp() {
            return this.clientIp;
        }

        public final Boolean getDisableCache() {
            return this.disableCache;
        }

        public final Map<String, Object> getHosts() {
            return this.hosts;
        }

        public final String getQueryStrategy() {
            return this.queryStrategy;
        }

        public final ArrayList<Object> getServers() {
            return this.servers;
        }

        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            ArrayList<Object> arrayList = this.servers;
            int iHashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
            Map<String, ? extends Object> map = this.hosts;
            int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
            String str = this.clientIp;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.disableCache;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str2 = this.queryStrategy;
            int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.tag;
            return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
        }

        public final void setHosts(Map<String, ? extends Object> map) {
            this.hosts = map;
        }

        public final void setServers(ArrayList<Object> arrayList) {
            this.servers = arrayList;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("DnsBean(servers=");
            sb.append(this.servers);
            sb.append(", hosts=");
            sb.append(this.hosts);
            sb.append(", clientIp=");
            sb.append(this.clientIp);
            sb.append(", disableCache=");
            sb.append(this.disableCache);
            sb.append(", queryStrategy=");
            sb.append(this.queryStrategy);
            sb.append(", tag=");
            return fb$1.m(sb, this.tag, ')');
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class FakednsBean {
        private String ipPool;
        private int poolSize;

        /* JADX WARN: Multi-variable type inference failed */
        public FakednsBean() {
            this(null, 0, 3, 0 == true ? 1 : 0);
        }

        public FakednsBean(String str, int i) {
            this.ipPool = str;
            this.poolSize = i;
        }

        public /* synthetic */ FakednsBean(String str, int i, int i2, zk zkVar) {
            this((i2 & 1) != 0 ? "198.18.0.0/15" : str, (i2 & 2) != 0 ? 10000 : i);
        }

        public static /* synthetic */ FakednsBean copy$default(FakednsBean fakednsBean, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = fakednsBean.ipPool;
            }
            if ((i2 & 2) != 0) {
                i = fakednsBean.poolSize;
            }
            return fakednsBean.copy(str, i);
        }

        public final String component1() {
            return this.ipPool;
        }

        public final int component2() {
            return this.poolSize;
        }

        public final FakednsBean copy(String str, int i) {
            return new FakednsBean(str, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FakednsBean)) {
                return false;
            }
            FakednsBean fakednsBean = (FakednsBean) obj;
            return e4.a(this.ipPool, fakednsBean.ipPool) && this.poolSize == fakednsBean.poolSize;
        }

        public final String getIpPool() {
            return this.ipPool;
        }

        public final int getPoolSize() {
            return this.poolSize;
        }

        public int hashCode() {
            return (this.ipPool.hashCode() * 31) + this.poolSize;
        }

        public final void setIpPool(String str) {
            this.ipPool = str;
        }

        public final void setPoolSize(int i) {
            this.poolSize = i;
        }

        public String toString() {
            return "FakednsBean(ipPool=" + this.ipPool + ", poolSize=" + this.poolSize + ')';
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class InboundBean {
        private final Object allocate;
        private String listen;
        private int port;
        private String protocol;
        private final Object settings;
        private final SniffingBean sniffing;
        private final Object streamSettings;
        private String tag;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class InSettingsBean {
            private final String address;
            private final String auth;
            private final String network;
            private final Integer port;
            private final Boolean udp;
            private final Integer userLevel;

            public InSettingsBean() {
                this(null, null, null, null, null, null, 63, null);
            }

            public InSettingsBean(String str, Boolean bool, Integer num, String str2, Integer num2, String str3) {
                this.auth = str;
                this.udp = bool;
                this.userLevel = num;
                this.address = str2;
                this.port = num2;
                this.network = str3;
            }

            public /* synthetic */ InSettingsBean(String str, Boolean bool, Integer num, String str2, Integer num2, String str3, int i, zk zkVar) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str3);
            }

            public static /* synthetic */ InSettingsBean copy$default(InSettingsBean inSettingsBean, String str, Boolean bool, Integer num, String str2, Integer num2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = inSettingsBean.auth;
                }
                if ((i & 2) != 0) {
                    bool = inSettingsBean.udp;
                }
                if ((i & 4) != 0) {
                    num = inSettingsBean.userLevel;
                }
                if ((i & 8) != 0) {
                    str2 = inSettingsBean.address;
                }
                if ((i & 16) != 0) {
                    num2 = inSettingsBean.port;
                }
                if ((i & 32) != 0) {
                    str3 = inSettingsBean.network;
                }
                Integer num3 = num2;
                String str4 = str3;
                return inSettingsBean.copy(str, bool, num, str2, num3, str4);
            }

            public final String component1() {
                return this.auth;
            }

            public final Boolean component2() {
                return this.udp;
            }

            public final Integer component3() {
                return this.userLevel;
            }

            public final String component4() {
                return this.address;
            }

            public final Integer component5() {
                return this.port;
            }

            public final String component6() {
                return this.network;
            }

            public final InSettingsBean copy(String str, Boolean bool, Integer num, String str2, Integer num2, String str3) {
                return new InSettingsBean(str, bool, num, str2, num2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InSettingsBean)) {
                    return false;
                }
                InSettingsBean inSettingsBean = (InSettingsBean) obj;
                return e4.a(this.auth, inSettingsBean.auth) && e4.a(this.udp, inSettingsBean.udp) && e4.a(this.userLevel, inSettingsBean.userLevel) && e4.a(this.address, inSettingsBean.address) && e4.a(this.port, inSettingsBean.port) && e4.a(this.network, inSettingsBean.network);
            }

            public final String getAddress() {
                return this.address;
            }

            public final String getAuth() {
                return this.auth;
            }

            public final String getNetwork() {
                return this.network;
            }

            public final Integer getPort() {
                return this.port;
            }

            public final Boolean getUdp() {
                return this.udp;
            }

            public final Integer getUserLevel() {
                return this.userLevel;
            }

            public int hashCode() {
                String str = this.auth;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                Boolean bool = this.udp;
                int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
                Integer num = this.userLevel;
                int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
                String str2 = this.address;
                int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
                Integer num2 = this.port;
                int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
                String str3 = this.network;
                return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("InSettingsBean(auth=");
                sb.append(this.auth);
                sb.append(", udp=");
                sb.append(this.udp);
                sb.append(", userLevel=");
                sb.append(this.userLevel);
                sb.append(", address=");
                sb.append(this.address);
                sb.append(", port=");
                sb.append(this.port);
                sb.append(", network=");
                return fb$1.m(sb, this.network, ')');
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class SniffingBean {
            private final ArrayList<String> destOverride;
            private boolean enabled;
            private final Boolean metadataOnly;
            private Boolean routeOnly;

            public SniffingBean(boolean z, ArrayList<String> arrayList, Boolean bool, Boolean bool2) {
                this.enabled = z;
                this.destOverride = arrayList;
                this.metadataOnly = bool;
                this.routeOnly = bool2;
            }

            public /* synthetic */ SniffingBean(boolean z, ArrayList arrayList, Boolean bool, Boolean bool2, int i, zk zkVar) {
                this(z, arrayList, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SniffingBean copy$default(SniffingBean sniffingBean, boolean z, ArrayList arrayList, Boolean bool, Boolean bool2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = sniffingBean.enabled;
                }
                if ((i & 2) != 0) {
                    arrayList = sniffingBean.destOverride;
                }
                if ((i & 4) != 0) {
                    bool = sniffingBean.metadataOnly;
                }
                if ((i & 8) != 0) {
                    bool2 = sniffingBean.routeOnly;
                }
                return sniffingBean.copy(z, arrayList, bool, bool2);
            }

            public final boolean component1() {
                return this.enabled;
            }

            public final ArrayList<String> component2() {
                return this.destOverride;
            }

            public final Boolean component3() {
                return this.metadataOnly;
            }

            public final Boolean component4() {
                return this.routeOnly;
            }

            public final SniffingBean copy(boolean z, ArrayList<String> arrayList, Boolean bool, Boolean bool2) {
                return new SniffingBean(z, arrayList, bool, bool2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SniffingBean)) {
                    return false;
                }
                SniffingBean sniffingBean = (SniffingBean) obj;
                return this.enabled == sniffingBean.enabled && e4.a(this.destOverride, sniffingBean.destOverride) && e4.a(this.metadataOnly, sniffingBean.metadataOnly) && e4.a(this.routeOnly, sniffingBean.routeOnly);
            }

            public final ArrayList<String> getDestOverride() {
                return this.destOverride;
            }

            public final boolean getEnabled() {
                return this.enabled;
            }

            public final Boolean getMetadataOnly() {
                return this.metadataOnly;
            }

            public final Boolean getRouteOnly() {
                return this.routeOnly;
            }

            public int hashCode() {
                int iHashCode = (this.destOverride.hashCode() + ((this.enabled ? 1231 : 1237) * 31)) * 31;
                Boolean bool = this.metadataOnly;
                int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
                Boolean bool2 = this.routeOnly;
                return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
            }

            public final void setEnabled(boolean z) {
                this.enabled = z;
            }

            public final void setRouteOnly(Boolean bool) {
                this.routeOnly = bool;
            }

            public String toString() {
                return "SniffingBean(enabled=" + this.enabled + ", destOverride=" + this.destOverride + ", metadataOnly=" + this.metadataOnly + ", routeOnly=" + this.routeOnly + ')';
            }
        }

        public InboundBean(String str, int i, String str2, String str3, Object obj, SniffingBean sniffingBean, Object obj2, Object obj3) {
            this.tag = str;
            this.port = i;
            this.protocol = str2;
            this.listen = str3;
            this.settings = obj;
            this.sniffing = sniffingBean;
            this.streamSettings = obj2;
            this.allocate = obj3;
        }

        public /* synthetic */ InboundBean(String str, int i, String str2, String str3, Object obj, SniffingBean sniffingBean, Object obj2, Object obj3, int i2, zk zkVar) {
            this(str, i, str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : obj, sniffingBean, (i2 & 64) != 0 ? null : obj2, (i2 & 128) != 0 ? null : obj3);
        }

        public static /* synthetic */ InboundBean copy$default(InboundBean inboundBean, String str, int i, String str2, String str3, Object obj, SniffingBean sniffingBean, Object obj2, Object obj3, int i2, Object obj4) {
            if ((i2 & 1) != 0) {
                str = inboundBean.tag;
            }
            if ((i2 & 2) != 0) {
                i = inboundBean.port;
            }
            if ((i2 & 4) != 0) {
                str2 = inboundBean.protocol;
            }
            if ((i2 & 8) != 0) {
                str3 = inboundBean.listen;
            }
            if ((i2 & 16) != 0) {
                obj = inboundBean.settings;
            }
            if ((i2 & 32) != 0) {
                sniffingBean = inboundBean.sniffing;
            }
            if ((i2 & 64) != 0) {
                obj2 = inboundBean.streamSettings;
            }
            if ((i2 & 128) != 0) {
                obj3 = inboundBean.allocate;
            }
            Object obj5 = obj2;
            Object obj6 = obj3;
            Object obj7 = obj;
            SniffingBean sniffingBean2 = sniffingBean;
            return inboundBean.copy(str, i, str2, str3, obj7, sniffingBean2, obj5, obj6);
        }

        public final String component1() {
            return this.tag;
        }

        public final int component2() {
            return this.port;
        }

        public final String component3() {
            return this.protocol;
        }

        public final String component4() {
            return this.listen;
        }

        public final Object component5() {
            return this.settings;
        }

        public final SniffingBean component6() {
            return this.sniffing;
        }

        public final Object component7() {
            return this.streamSettings;
        }

        public final Object component8() {
            return this.allocate;
        }

        public final InboundBean copy(String str, int i, String str2, String str3, Object obj, SniffingBean sniffingBean, Object obj2, Object obj3) {
            return new InboundBean(str, i, str2, str3, obj, sniffingBean, obj2, obj3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InboundBean)) {
                return false;
            }
            InboundBean inboundBean = (InboundBean) obj;
            return e4.a(this.tag, inboundBean.tag) && this.port == inboundBean.port && e4.a(this.protocol, inboundBean.protocol) && e4.a(this.listen, inboundBean.listen) && e4.a(this.settings, inboundBean.settings) && e4.a(this.sniffing, inboundBean.sniffing) && e4.a(this.streamSettings, inboundBean.streamSettings) && e4.a(this.allocate, inboundBean.allocate);
        }

        public final Object getAllocate() {
            return this.allocate;
        }

        public final String getListen() {
            return this.listen;
        }

        public final int getPort() {
            return this.port;
        }

        public final String getProtocol() {
            return this.protocol;
        }

        public final Object getSettings() {
            return this.settings;
        }

        public final SniffingBean getSniffing() {
            return this.sniffing;
        }

        public final Object getStreamSettings() {
            return this.streamSettings;
        }

        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            int iD = e.d(((this.tag.hashCode() * 31) + this.port) * 31, this.protocol);
            String str = this.listen;
            int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
            Object obj = this.settings;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            SniffingBean sniffingBean = this.sniffing;
            int iHashCode3 = (iHashCode2 + (sniffingBean == null ? 0 : sniffingBean.hashCode())) * 31;
            Object obj2 = this.streamSettings;
            int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
            Object obj3 = this.allocate;
            return iHashCode4 + (obj3 != null ? obj3.hashCode() : 0);
        }

        public final void setListen(String str) {
            this.listen = str;
        }

        public final void setPort(int i) {
            this.port = i;
        }

        public final void setProtocol(String str) {
            this.protocol = str;
        }

        public final void setTag(String str) {
            this.tag = str;
        }

        public String toString() {
            return "InboundBean(tag=" + this.tag + ", port=" + this.port + ", protocol=" + this.protocol + ", listen=" + this.listen + ", settings=" + this.settings + ", sniffing=" + this.sniffing + ", streamSettings=" + this.streamSettings + ", allocate=" + this.allocate + ')';
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class LogBean {
        private final String access;
        private final Boolean dnsLog;
        private final String error;
        private String loglevel;

        public LogBean(String str, String str2, String str3, Boolean bool) {
            this.access = str;
            this.error = str2;
            this.loglevel = str3;
            this.dnsLog = bool;
        }

        public /* synthetic */ LogBean(String str, String str2, String str3, Boolean bool, int i, zk zkVar) {
            this(str, str2, str3, (i & 8) != 0 ? null : bool);
        }

        public static /* synthetic */ LogBean copy$default(LogBean logBean, String str, String str2, String str3, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = logBean.access;
            }
            if ((i & 2) != 0) {
                str2 = logBean.error;
            }
            if ((i & 4) != 0) {
                str3 = logBean.loglevel;
            }
            if ((i & 8) != 0) {
                bool = logBean.dnsLog;
            }
            return logBean.copy(str, str2, str3, bool);
        }

        public final String component1() {
            return this.access;
        }

        public final String component2() {
            return this.error;
        }

        public final String component3() {
            return this.loglevel;
        }

        public final Boolean component4() {
            return this.dnsLog;
        }

        public final LogBean copy(String str, String str2, String str3, Boolean bool) {
            return new LogBean(str, str2, str3, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LogBean)) {
                return false;
            }
            LogBean logBean = (LogBean) obj;
            return e4.a(this.access, logBean.access) && e4.a(this.error, logBean.error) && e4.a(this.loglevel, logBean.loglevel) && e4.a(this.dnsLog, logBean.dnsLog);
        }

        public final String getAccess() {
            return this.access;
        }

        public final Boolean getDnsLog() {
            return this.dnsLog;
        }

        public final String getError() {
            return this.error;
        }

        public final String getLoglevel() {
            return this.loglevel;
        }

        public int hashCode() {
            int iD = e.d(this.access.hashCode() * 31, this.error);
            String str = this.loglevel;
            int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.dnsLog;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        public final void setLoglevel(String str) {
            this.loglevel = str;
        }

        public String toString() {
            return "LogBean(access=" + this.access + ", error=" + this.error + ", loglevel=" + this.loglevel + ", dnsLog=" + this.dnsLog + ')';
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class OutboundBean {
        public static final Companion Companion = new Companion(null);
        private MuxBean mux;
        private String protocol;
        private final Object proxySettings;
        private final String sendThrough;
        private OutSettingsBean settings;
        private StreamSettingsBean streamSettings;
        private String tag;

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
                        iArr[EConfigType.SHADOWSOCKS.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[EConfigType.SOCKS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[EConfigType.HTTP.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[EConfigType.TROJAN.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[EConfigType.HYSTERIA2.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[EConfigType.WIREGUARD.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[EConfigType.CUSTOM.ordinal()] = 9;
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

            /* JADX WARN: Multi-variable type inference failed */
            public final OutboundBean create(EConfigType eConfigType) {
                switch (WhenMappings.$EnumSwitchMapping$0[eConfigType.ordinal()]) {
                    case 1:
                    case 2:
                        String lowerCase = eConfigType.name().toLowerCase(Locale.ROOT);
                        String str = null;
                        String str2 = null;
                        List listSingletonList = Collections.singletonList(new OutSettingsBean.VnextBean.UsersBean(null, null, str, 0, str2, null, 63, null));
                        Object[] objArr = 0 == true ? 1 : 0;
                        Object[] objArr2 = 0 == true ? 1 : 0;
                        Object[] objArr3 = 0 == true ? 1 : 0;
                        Object[] objArr4 = 0 == true ? 1 : 0;
                        Object[] objArr5 = 0 == true ? 1 : 0;
                        OutSettingsBean outSettingsBean = new OutSettingsBean(Collections.singletonList(new OutSettingsBean.VnextBean(null, 0, listSingletonList, 3, 0 == true ? 1 : 0)), objArr5, null, null, null, objArr, str, objArr2, str2, objArr3, null, objArr4, null, null, null, null, null, 131070, null);
                        String str3 = null;
                        StreamSettingsBean.QuicSettingBean quicSettingBean = null;
                        StreamSettingsBean.GrpcSettingsBean grpcSettingsBean = null;
                        StreamSettingsBean.Hy2steriaSettingsBean hy2steriaSettingsBean = null;
                        Object[] objArr6 = 0 == true ? 1 : 0;
                        Object[] objArr7 = 0 == true ? 1 : 0;
                        Object[] objArr8 = 0 == true ? 1 : 0;
                        Object[] objArr9 = 0 == true ? 1 : 0;
                        Object[] objArr10 = 0 == true ? 1 : 0;
                        Object[] objArr11 = 0 == true ? 1 : 0;
                        Object[] objArr12 = 0 == true ? 1 : 0;
                        Object[] objArr13 = 0 == true ? 1 : 0;
                        Object[] objArr14 = 0 == true ? 1 : 0;
                        Object[] objArr15 = 0 == true ? 1 : 0;
                        String str4 = null;
                        Object[] objArr16 = 0 == true ? 1 : 0;
                        return new OutboundBean(str4, lowerCase, outSettingsBean, new StreamSettingsBean(objArr6, str3, objArr8, objArr7, objArr11, objArr9, objArr10, objArr12, objArr13, objArr14, quicSettingBean, objArr15, grpcSettingsBean, hy2steriaSettingsBean, null, null, 65535, null), 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 113, objArr16);
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        String lowerCase2 = eConfigType.name().toLowerCase(Locale.ROOT);
                        String str5 = null;
                        List listSingletonList2 = Collections.singletonList(new OutSettingsBean.ServersBean(null, null, false, null, 0, 0, null, str5, null, null, 1023, null));
                        Object[] objArr17 = 0 == true ? 1 : 0;
                        Object[] objArr18 = 0 == true ? 1 : 0;
                        Object[] objArr19 = 0 == true ? 1 : 0;
                        Object[] objArr20 = 0 == true ? 1 : 0;
                        Object[] objArr21 = 0 == true ? 1 : 0;
                        OutSettingsBean outSettingsBean2 = new OutSettingsBean(null, objArr17, null, listSingletonList2, objArr18, objArr19, null, objArr20, str5, 0 == true ? 1 : 0, objArr21, str5, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, 0 == true ? 1 : 0, null, 131063, null);
                        String str6 = null;
                        StreamSettingsBean.KcpSettingsBean kcpSettingsBean = null;
                        StreamSettingsBean.HttpupgradeSettingsBean httpupgradeSettingsBean = null;
                        StreamSettingsBean.HttpSettingsBean httpSettingsBean = null;
                        StreamSettingsBean.QuicSettingBean quicSettingBean2 = null;
                        StreamSettingsBean.GrpcSettingsBean grpcSettingsBean2 = null;
                        StreamSettingsBean.Hy2steriaSettingsBean hy2steriaSettingsBean2 = null;
                        Object[] objArr22 = 0 == true ? 1 : 0;
                        Object[] objArr23 = 0 == true ? 1 : 0;
                        Object[] objArr24 = 0 == true ? 1 : 0;
                        Object[] objArr25 = 0 == true ? 1 : 0;
                        Object[] objArr26 = 0 == true ? 1 : 0;
                        Object[] objArr27 = 0 == true ? 1 : 0;
                        String str7 = null;
                        Object[] objArr28 = 0 == true ? 1 : 0;
                        Object[] objArr29 = 0 == true ? 1 : 0;
                        return new OutboundBean(str7, lowerCase2, outSettingsBean2, new StreamSettingsBean(str6, str5, objArr22, kcpSettingsBean, objArr25, httpupgradeSettingsBean, objArr23, objArr24, httpSettingsBean, objArr26, quicSettingBean2, objArr27, grpcSettingsBean2, hy2steriaSettingsBean2, null, null, 65535, null), objArr28, 0 == true ? 1 : 0, null, 113, objArr29);
                    case 8:
                        String lowerCase3 = eConfigType.name().toLowerCase(Locale.ROOT);
                        String str8 = null;
                        zk zkVar = null;
                        List listSingletonList3 = Collections.singletonList(new OutSettingsBean.WireGuardBean(null, null, str8, 7, zkVar));
                        List list = null;
                        OutSettingsBean.FragmentBean fragmentBean = null;
                        List list2 = null;
                        List list3 = null;
                        OutSettingsBean.Response response = null;
                        String str9 = null;
                        Object obj = null;
                        Integer num = null;
                        String str10 = null;
                        String str11 = null;
                        Integer num2 = null;
                        Object[] objArr30 = 0 == true ? 1 : 0;
                        Object[] objArr31 = 0 == true ? 1 : 0;
                        return new OutboundBean(null, lowerCase3, new OutSettingsBean(list, fragmentBean, list2, list3, response, str9, obj, num, str10, str11, num2, null, AppConfig.CUSTOM, listSingletonList3, objArr30, objArr31, str8, 118783, zkVar), 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 121, 0 == true ? 1 : 0);
                    default:
                        d.AnonymousClass0.m();
                    case 9:
                        return null;
                }
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class MuxBean {
            private int concurrency;
            private boolean enabled;
            private int xudpConcurrency;
            private String xudpProxyUDP443;

            public MuxBean(boolean z, int i, int i2, String str) {
                this.enabled = z;
                this.concurrency = i;
                this.xudpConcurrency = i2;
                this.xudpProxyUDP443 = str;
            }

            public /* synthetic */ MuxBean(boolean z, int i, int i2, String str, int i3, zk zkVar) {
                this(z, (i3 & 2) != 0 ? 8 : i, (i3 & 4) != 0 ? 8 : i2, (i3 & 8) != 0 ? AppConfig.CUSTOM : str);
            }

            public static /* synthetic */ MuxBean copy$default(MuxBean muxBean, boolean z, int i, int i2, String str, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    z = muxBean.enabled;
                }
                if ((i3 & 2) != 0) {
                    i = muxBean.concurrency;
                }
                if ((i3 & 4) != 0) {
                    i2 = muxBean.xudpConcurrency;
                }
                if ((i3 & 8) != 0) {
                    str = muxBean.xudpProxyUDP443;
                }
                return muxBean.copy(z, i, i2, str);
            }

            public final boolean component1() {
                return this.enabled;
            }

            public final int component2() {
                return this.concurrency;
            }

            public final int component3() {
                return this.xudpConcurrency;
            }

            public final String component4() {
                return this.xudpProxyUDP443;
            }

            public final MuxBean copy(boolean z, int i, int i2, String str) {
                return new MuxBean(z, i, i2, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MuxBean)) {
                    return false;
                }
                MuxBean muxBean = (MuxBean) obj;
                return this.enabled == muxBean.enabled && this.concurrency == muxBean.concurrency && this.xudpConcurrency == muxBean.xudpConcurrency && e4.a(this.xudpProxyUDP443, muxBean.xudpProxyUDP443);
            }

            public final int getConcurrency() {
                return this.concurrency;
            }

            public final boolean getEnabled() {
                return this.enabled;
            }

            public final int getXudpConcurrency() {
                return this.xudpConcurrency;
            }

            public final String getXudpProxyUDP443() {
                return this.xudpProxyUDP443;
            }

            public int hashCode() {
                return this.xudpProxyUDP443.hashCode() + ((((((this.enabled ? 1231 : 1237) * 31) + this.concurrency) * 31) + this.xudpConcurrency) * 31);
            }

            public final void setConcurrency(int i) {
                this.concurrency = i;
            }

            public final void setEnabled(boolean z) {
                this.enabled = z;
            }

            public final void setXudpConcurrency(int i) {
                this.xudpConcurrency = i;
            }

            public final void setXudpProxyUDP443(String str) {
                this.xudpProxyUDP443 = str;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("MuxBean(enabled=");
                sb.append(this.enabled);
                sb.append(", concurrency=");
                sb.append(this.concurrency);
                sb.append(", xudpConcurrency=");
                sb.append(this.xudpConcurrency);
                sb.append(", xudpProxyUDP443=");
                return fb$1.m(sb, this.xudpProxyUDP443, ')');
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class OutSettingsBean {
            private Object address;
            private String domainStrategy;
            private FragmentBean fragment;
            private final String inboundTag;
            private Integer mtu;
            private final String network;
            private List<NoiseBean> noises;
            private String obfsPassword;
            private final List<WireGuardBean> peers;
            private final Integer port;
            private final String redirect;
            private List<Integer> reserved;
            private Response response;
            private String secretKey;
            private List<ServersBean> servers;
            private final Integer userLevel;
            private List<VnextBean> vnext;

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class FragmentBean {
                private String interval;
                private String length;
                private String packets;

                public FragmentBean() {
                    this(null, null, null, 7, null);
                }

                public FragmentBean(String str, String str2, String str3) {
                    this.packets = str;
                    this.length = str2;
                    this.interval = str3;
                }

                public /* synthetic */ FragmentBean(String str, String str2, String str3, int i, zk zkVar) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
                }

                public static /* synthetic */ FragmentBean copy$default(FragmentBean fragmentBean, String str, String str2, String str3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = fragmentBean.packets;
                    }
                    if ((i & 2) != 0) {
                        str2 = fragmentBean.length;
                    }
                    if ((i & 4) != 0) {
                        str3 = fragmentBean.interval;
                    }
                    return fragmentBean.copy(str, str2, str3);
                }

                public final String component1() {
                    return this.packets;
                }

                public final String component2() {
                    return this.length;
                }

                public final String component3() {
                    return this.interval;
                }

                public final FragmentBean copy(String str, String str2, String str3) {
                    return new FragmentBean(str, str2, str3);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof FragmentBean)) {
                        return false;
                    }
                    FragmentBean fragmentBean = (FragmentBean) obj;
                    return e4.a(this.packets, fragmentBean.packets) && e4.a(this.length, fragmentBean.length) && e4.a(this.interval, fragmentBean.interval);
                }

                public final String getInterval() {
                    return this.interval;
                }

                public final String getLength() {
                    return this.length;
                }

                public final String getPackets() {
                    return this.packets;
                }

                public int hashCode() {
                    String str = this.packets;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.length;
                    int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    String str3 = this.interval;
                    return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
                }

                public final void setInterval(String str) {
                    this.interval = str;
                }

                public final void setLength(String str) {
                    this.length = str;
                }

                public final void setPackets(String str) {
                    this.packets = str;
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder("FragmentBean(packets=");
                    sb.append(this.packets);
                    sb.append(", length=");
                    sb.append(this.length);
                    sb.append(", interval=");
                    return fb$1.m(sb, this.interval, ')');
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class NoiseBean {
                private String delay;
                private String packet;
                private String type;

                public NoiseBean() {
                    this(null, null, null, 7, null);
                }

                public NoiseBean(String str, String str2, String str3) {
                    this.type = str;
                    this.packet = str2;
                    this.delay = str3;
                }

                public /* synthetic */ NoiseBean(String str, String str2, String str3, int i, zk zkVar) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
                }

                public static /* synthetic */ NoiseBean copy$default(NoiseBean noiseBean, String str, String str2, String str3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = noiseBean.type;
                    }
                    if ((i & 2) != 0) {
                        str2 = noiseBean.packet;
                    }
                    if ((i & 4) != 0) {
                        str3 = noiseBean.delay;
                    }
                    return noiseBean.copy(str, str2, str3);
                }

                public final String component1() {
                    return this.type;
                }

                public final String component2() {
                    return this.packet;
                }

                public final String component3() {
                    return this.delay;
                }

                public final NoiseBean copy(String str, String str2, String str3) {
                    return new NoiseBean(str, str2, str3);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof NoiseBean)) {
                        return false;
                    }
                    NoiseBean noiseBean = (NoiseBean) obj;
                    return e4.a(this.type, noiseBean.type) && e4.a(this.packet, noiseBean.packet) && e4.a(this.delay, noiseBean.delay);
                }

                public final String getDelay() {
                    return this.delay;
                }

                public final String getPacket() {
                    return this.packet;
                }

                public final String getType() {
                    return this.type;
                }

                public int hashCode() {
                    String str = this.type;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.packet;
                    int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    String str3 = this.delay;
                    return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
                }

                public final void setDelay(String str) {
                    this.delay = str;
                }

                public final void setPacket(String str) {
                    this.packet = str;
                }

                public final void setType(String str) {
                    this.type = str;
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder("NoiseBean(type=");
                    sb.append(this.type);
                    sb.append(", packet=");
                    sb.append(this.packet);
                    sb.append(", delay=");
                    return fb$1.m(sb, this.delay, ')');
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class Response {
                private String type;

                public Response(String str) {
                    this.type = str;
                }

                public static /* synthetic */ Response copy$default(Response response, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = response.type;
                    }
                    return response.copy(str);
                }

                public final String component1() {
                    return this.type;
                }

                public final Response copy(String str) {
                    return new Response(str);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Response) && e4.a(this.type, ((Response) obj).type);
                }

                public final String getType() {
                    return this.type;
                }

                public int hashCode() {
                    return this.type.hashCode();
                }

                public final void setType(String str) {
                    this.type = str;
                }

                public String toString() {
                    return fb$1.m(new StringBuilder("Response(type="), this.type, ')');
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class ServersBean {
                private String address;
                private final String email;
                private String flow;
                private final Boolean ivCheck;
                private int level;
                private String method;
                private boolean ota;
                private String password;
                private int port;
                private List<SocksUsersBean> users;

                /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
                public static final class SocksUsersBean {
                    private int level;
                    private String pass;
                    private String user;

                    public SocksUsersBean() {
                        this(null, null, 0, 7, null);
                    }

                    public SocksUsersBean(String str, String str2, int i) {
                        this.user = str;
                        this.pass = str2;
                        this.level = i;
                    }

                    public /* synthetic */ SocksUsersBean(String str, String str2, int i, int i2, zk zkVar) {
                        this((i2 & 1) != 0 ? AppConfig.CUSTOM : str, (i2 & 2) != 0 ? AppConfig.CUSTOM : str2, (i2 & 4) != 0 ? 8 : i);
                    }

                    public static /* synthetic */ SocksUsersBean copy$default(SocksUsersBean socksUsersBean, String str, String str2, int i, int i2, Object obj) {
                        if ((i2 & 1) != 0) {
                            str = socksUsersBean.user;
                        }
                        if ((i2 & 2) != 0) {
                            str2 = socksUsersBean.pass;
                        }
                        if ((i2 & 4) != 0) {
                            i = socksUsersBean.level;
                        }
                        return socksUsersBean.copy(str, str2, i);
                    }

                    public final String component1() {
                        return this.user;
                    }

                    public final String component2() {
                        return this.pass;
                    }

                    public final int component3() {
                        return this.level;
                    }

                    public final SocksUsersBean copy(String str, String str2, int i) {
                        return new SocksUsersBean(str, str2, i);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof SocksUsersBean)) {
                            return false;
                        }
                        SocksUsersBean socksUsersBean = (SocksUsersBean) obj;
                        return e4.a(this.user, socksUsersBean.user) && e4.a(this.pass, socksUsersBean.pass) && this.level == socksUsersBean.level;
                    }

                    public final int getLevel() {
                        return this.level;
                    }

                    public final String getPass() {
                        return this.pass;
                    }

                    public final String getUser() {
                        return this.user;
                    }

                    public int hashCode() {
                        return e.d(this.user.hashCode() * 31, this.pass) + this.level;
                    }

                    public final void setLevel(int i) {
                        this.level = i;
                    }

                    public final void setPass(String str) {
                        this.pass = str;
                    }

                    public final void setUser(String str) {
                        this.user = str;
                    }

                    public String toString() {
                        return "SocksUsersBean(user=" + this.user + ", pass=" + this.pass + ", level=" + this.level + ')';
                    }
                }

                public ServersBean() {
                    this(null, null, false, null, 0, 0, null, null, null, null, 1023, null);
                }

                public ServersBean(String str, String str2, boolean z, String str3, int i, int i2, String str4, String str5, Boolean bool, List<SocksUsersBean> list) {
                    this.address = str;
                    this.method = str2;
                    this.ota = z;
                    this.password = str3;
                    this.port = i;
                    this.level = i2;
                    this.email = str4;
                    this.flow = str5;
                    this.ivCheck = bool;
                    this.users = list;
                }

                public /* synthetic */ ServersBean(String str, String str2, boolean z, String str3, int i, int i2, String str4, String str5, Boolean bool, List list, int i3, zk zkVar) {
                    this((i3 & 1) != 0 ? AppConfig.CUSTOM : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? AppConfig.DEFAULT_PORT : i, (i3 & 32) != 0 ? 8 : i2, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? null : str5, (i3 & 256) != 0 ? null : bool, (i3 & 512) != 0 ? null : list);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ ServersBean copy$default(ServersBean serversBean, String str, String str2, boolean z, String str3, int i, int i2, String str4, String str5, Boolean bool, List list, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        str = serversBean.address;
                    }
                    if ((i3 & 2) != 0) {
                        str2 = serversBean.method;
                    }
                    if ((i3 & 4) != 0) {
                        z = serversBean.ota;
                    }
                    if ((i3 & 8) != 0) {
                        str3 = serversBean.password;
                    }
                    if ((i3 & 16) != 0) {
                        i = serversBean.port;
                    }
                    if ((i3 & 32) != 0) {
                        i2 = serversBean.level;
                    }
                    if ((i3 & 64) != 0) {
                        str4 = serversBean.email;
                    }
                    if ((i3 & 128) != 0) {
                        str5 = serversBean.flow;
                    }
                    if ((i3 & 256) != 0) {
                        bool = serversBean.ivCheck;
                    }
                    if ((i3 & 512) != 0) {
                        list = serversBean.users;
                    }
                    Boolean bool2 = bool;
                    List list2 = list;
                    String str6 = str4;
                    String str7 = str5;
                    int i4 = i;
                    int i5 = i2;
                    return serversBean.copy(str, str2, z, str3, i4, i5, str6, str7, bool2, list2);
                }

                public final String component1() {
                    return this.address;
                }

                public final List<SocksUsersBean> component10() {
                    return this.users;
                }

                public final String component2() {
                    return this.method;
                }

                public final boolean component3() {
                    return this.ota;
                }

                public final String component4() {
                    return this.password;
                }

                public final int component5() {
                    return this.port;
                }

                public final int component6() {
                    return this.level;
                }

                public final String component7() {
                    return this.email;
                }

                public final String component8() {
                    return this.flow;
                }

                public final Boolean component9() {
                    return this.ivCheck;
                }

                public final ServersBean copy(String str, String str2, boolean z, String str3, int i, int i2, String str4, String str5, Boolean bool, List<SocksUsersBean> list) {
                    return new ServersBean(str, str2, z, str3, i, i2, str4, str5, bool, list);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof ServersBean)) {
                        return false;
                    }
                    ServersBean serversBean = (ServersBean) obj;
                    return e4.a(this.address, serversBean.address) && e4.a(this.method, serversBean.method) && this.ota == serversBean.ota && e4.a(this.password, serversBean.password) && this.port == serversBean.port && this.level == serversBean.level && e4.a(this.email, serversBean.email) && e4.a(this.flow, serversBean.flow) && e4.a(this.ivCheck, serversBean.ivCheck) && e4.a(this.users, serversBean.users);
                }

                public final String getAddress() {
                    return this.address;
                }

                public final String getEmail() {
                    return this.email;
                }

                public final String getFlow() {
                    return this.flow;
                }

                public final Boolean getIvCheck() {
                    return this.ivCheck;
                }

                public final int getLevel() {
                    return this.level;
                }

                public final String getMethod() {
                    return this.method;
                }

                public final boolean getOta() {
                    return this.ota;
                }

                public final String getPassword() {
                    return this.password;
                }

                public final int getPort() {
                    return this.port;
                }

                public final List<SocksUsersBean> getUsers() {
                    return this.users;
                }

                public int hashCode() {
                    int iHashCode = this.address.hashCode() * 31;
                    String str = this.method;
                    int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.ota ? 1231 : 1237)) * 31;
                    String str2 = this.password;
                    int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.port) * 31) + this.level) * 31;
                    String str3 = this.email;
                    int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                    String str4 = this.flow;
                    int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                    Boolean bool = this.ivCheck;
                    int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
                    List<SocksUsersBean> list = this.users;
                    return iHashCode6 + (list != null ? list.hashCode() : 0);
                }

                public final void setAddress(String str) {
                    this.address = str;
                }

                public final void setFlow(String str) {
                    this.flow = str;
                }

                public final void setLevel(int i) {
                    this.level = i;
                }

                public final void setMethod(String str) {
                    this.method = str;
                }

                public final void setOta(boolean z) {
                    this.ota = z;
                }

                public final void setPassword(String str) {
                    this.password = str;
                }

                public final void setPort(int i) {
                    this.port = i;
                }

                public final void setUsers(List<SocksUsersBean> list) {
                    this.users = list;
                }

                public String toString() {
                    return "ServersBean(address=" + this.address + ", method=" + this.method + ", ota=" + this.ota + ", password=" + this.password + ", port=" + this.port + ", level=" + this.level + ", email=" + this.email + ", flow=" + this.flow + ", ivCheck=" + this.ivCheck + ", users=" + this.users + ')';
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class VnextBean {
                private String address;
                private int port;
                private List<UsersBean> users;

                /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
                public static final class UsersBean {
                    private Integer alterId;
                    private String encryption;
                    private String flow;
                    private String id;
                    private int level;
                    private String security;

                    public UsersBean() {
                        this(null, null, null, 0, null, null, 63, null);
                    }

                    public UsersBean(String str, Integer num, String str2, int i, String str3, String str4) {
                        this.id = str;
                        this.alterId = num;
                        this.security = str2;
                        this.level = i;
                        this.encryption = str3;
                        this.flow = str4;
                    }

                    public /* synthetic */ UsersBean(String str, Integer num, String str2, int i, String str3, String str4, int i2, zk zkVar) {
                        this((i2 & 1) != 0 ? AppConfig.CUSTOM : str, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? 8 : i, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4);
                    }

                    public static /* synthetic */ UsersBean copy$default(UsersBean usersBean, String str, Integer num, String str2, int i, String str3, String str4, int i2, Object obj) {
                        if ((i2 & 1) != 0) {
                            str = usersBean.id;
                        }
                        if ((i2 & 2) != 0) {
                            num = usersBean.alterId;
                        }
                        if ((i2 & 4) != 0) {
                            str2 = usersBean.security;
                        }
                        if ((i2 & 8) != 0) {
                            i = usersBean.level;
                        }
                        if ((i2 & 16) != 0) {
                            str3 = usersBean.encryption;
                        }
                        if ((i2 & 32) != 0) {
                            str4 = usersBean.flow;
                        }
                        String str5 = str3;
                        String str6 = str4;
                        return usersBean.copy(str, num, str2, i, str5, str6);
                    }

                    public final String component1() {
                        return this.id;
                    }

                    public final Integer component2() {
                        return this.alterId;
                    }

                    public final String component3() {
                        return this.security;
                    }

                    public final int component4() {
                        return this.level;
                    }

                    public final String component5() {
                        return this.encryption;
                    }

                    public final String component6() {
                        return this.flow;
                    }

                    public final UsersBean copy(String str, Integer num, String str2, int i, String str3, String str4) {
                        return new UsersBean(str, num, str2, i, str3, str4);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof UsersBean)) {
                            return false;
                        }
                        UsersBean usersBean = (UsersBean) obj;
                        return e4.a(this.id, usersBean.id) && e4.a(this.alterId, usersBean.alterId) && e4.a(this.security, usersBean.security) && this.level == usersBean.level && e4.a(this.encryption, usersBean.encryption) && e4.a(this.flow, usersBean.flow);
                    }

                    public final Integer getAlterId() {
                        return this.alterId;
                    }

                    public final String getEncryption() {
                        return this.encryption;
                    }

                    public final String getFlow() {
                        return this.flow;
                    }

                    public final String getId() {
                        return this.id;
                    }

                    public final int getLevel() {
                        return this.level;
                    }

                    public final String getSecurity() {
                        return this.security;
                    }

                    public int hashCode() {
                        int iHashCode = this.id.hashCode() * 31;
                        Integer num = this.alterId;
                        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
                        String str = this.security;
                        int iHashCode3 = (((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.level) * 31;
                        String str2 = this.encryption;
                        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.flow;
                        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
                    }

                    public final void setAlterId(Integer num) {
                        this.alterId = num;
                    }

                    public final void setEncryption(String str) {
                        this.encryption = str;
                    }

                    public final void setFlow(String str) {
                        this.flow = str;
                    }

                    public final void setId(String str) {
                        this.id = str;
                    }

                    public final void setLevel(int i) {
                        this.level = i;
                    }

                    public final void setSecurity(String str) {
                        this.security = str;
                    }

                    public String toString() {
                        StringBuilder sb = new StringBuilder("UsersBean(id=");
                        sb.append(this.id);
                        sb.append(", alterId=");
                        sb.append(this.alterId);
                        sb.append(", security=");
                        sb.append(this.security);
                        sb.append(", level=");
                        sb.append(this.level);
                        sb.append(", encryption=");
                        sb.append(this.encryption);
                        sb.append(", flow=");
                        return fb$1.m(sb, this.flow, ')');
                    }
                }

                public VnextBean(String str, int i, List<UsersBean> list) {
                    this.address = str;
                    this.port = i;
                    this.users = list;
                }

                public /* synthetic */ VnextBean(String str, int i, List list, int i2, zk zkVar) {
                    this((i2 & 1) != 0 ? AppConfig.CUSTOM : str, (i2 & 2) != 0 ? AppConfig.DEFAULT_PORT : i, list);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ VnextBean copy$default(VnextBean vnextBean, String str, int i, List list, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        str = vnextBean.address;
                    }
                    if ((i2 & 2) != 0) {
                        i = vnextBean.port;
                    }
                    if ((i2 & 4) != 0) {
                        list = vnextBean.users;
                    }
                    return vnextBean.copy(str, i, list);
                }

                public final String component1() {
                    return this.address;
                }

                public final int component2() {
                    return this.port;
                }

                public final List<UsersBean> component3() {
                    return this.users;
                }

                public final VnextBean copy(String str, int i, List<UsersBean> list) {
                    return new VnextBean(str, i, list);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof VnextBean)) {
                        return false;
                    }
                    VnextBean vnextBean = (VnextBean) obj;
                    return e4.a(this.address, vnextBean.address) && this.port == vnextBean.port && e4.a(this.users, vnextBean.users);
                }

                public final String getAddress() {
                    return this.address;
                }

                public final int getPort() {
                    return this.port;
                }

                public final List<UsersBean> getUsers() {
                    return this.users;
                }

                public int hashCode() {
                    return this.users.hashCode() + (((this.address.hashCode() * 31) + this.port) * 31);
                }

                public final void setAddress(String str) {
                    this.address = str;
                }

                public final void setPort(int i) {
                    this.port = i;
                }

                public final void setUsers(List<UsersBean> list) {
                    this.users = list;
                }

                public String toString() {
                    return "VnextBean(address=" + this.address + ", port=" + this.port + ", users=" + this.users + ')';
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class WireGuardBean {
                private String endpoint;
                private String preSharedKey;
                private String publicKey;

                public WireGuardBean() {
                    this(null, null, null, 7, null);
                }

                public WireGuardBean(String str, String str2, String str3) {
                    this.publicKey = str;
                    this.preSharedKey = str2;
                    this.endpoint = str3;
                }

                public /* synthetic */ WireGuardBean(String str, String str2, String str3, int i, zk zkVar) {
                    this((i & 1) != 0 ? AppConfig.CUSTOM : str, (i & 2) != 0 ? AppConfig.CUSTOM : str2, (i & 4) != 0 ? AppConfig.CUSTOM : str3);
                }

                public static /* synthetic */ WireGuardBean copy$default(WireGuardBean wireGuardBean, String str, String str2, String str3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = wireGuardBean.publicKey;
                    }
                    if ((i & 2) != 0) {
                        str2 = wireGuardBean.preSharedKey;
                    }
                    if ((i & 4) != 0) {
                        str3 = wireGuardBean.endpoint;
                    }
                    return wireGuardBean.copy(str, str2, str3);
                }

                public final String component1() {
                    return this.publicKey;
                }

                public final String component2() {
                    return this.preSharedKey;
                }

                public final String component3() {
                    return this.endpoint;
                }

                public final WireGuardBean copy(String str, String str2, String str3) {
                    return new WireGuardBean(str, str2, str3);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof WireGuardBean)) {
                        return false;
                    }
                    WireGuardBean wireGuardBean = (WireGuardBean) obj;
                    return e4.a(this.publicKey, wireGuardBean.publicKey) && e4.a(this.preSharedKey, wireGuardBean.preSharedKey) && e4.a(this.endpoint, wireGuardBean.endpoint);
                }

                public final String getEndpoint() {
                    return this.endpoint;
                }

                public final String getPreSharedKey() {
                    return this.preSharedKey;
                }

                public final String getPublicKey() {
                    return this.publicKey;
                }

                public int hashCode() {
                    return this.endpoint.hashCode() + e.d(this.publicKey.hashCode() * 31, this.preSharedKey);
                }

                public final void setEndpoint(String str) {
                    this.endpoint = str;
                }

                public final void setPreSharedKey(String str) {
                    this.preSharedKey = str;
                }

                public final void setPublicKey(String str) {
                    this.publicKey = str;
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder("WireGuardBean(publicKey=");
                    sb.append(this.publicKey);
                    sb.append(", preSharedKey=");
                    sb.append(this.preSharedKey);
                    sb.append(", endpoint=");
                    return fb$1.m(sb, this.endpoint, ')');
                }
            }

            public OutSettingsBean() {
                this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
            }

            public OutSettingsBean(List<VnextBean> list, FragmentBean fragmentBean, List<NoiseBean> list2, List<ServersBean> list3, Response response, String str, Object obj, Integer num, String str2, String str3, Integer num2, String str4, String str5, List<WireGuardBean> list4, List<Integer> list5, Integer num3, String str6) {
                this.vnext = list;
                this.fragment = fragmentBean;
                this.noises = list2;
                this.servers = list3;
                this.response = response;
                this.network = str;
                this.address = obj;
                this.port = num;
                this.domainStrategy = str2;
                this.redirect = str3;
                this.userLevel = num2;
                this.inboundTag = str4;
                this.secretKey = str5;
                this.peers = list4;
                this.reserved = list5;
                this.mtu = num3;
                this.obfsPassword = str6;
            }

            public /* synthetic */ OutSettingsBean(List list, FragmentBean fragmentBean, List list2, List list3, Response response, String str, Object obj, Integer num, String str2, String str3, Integer num2, String str4, String str5, List list4, List list5, Integer num3, String str6, int i, zk zkVar) {
                this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : fragmentBean, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : list3, (i & 16) != 0 ? null : response, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : obj, (i & 128) != 0 ? null : num, (i & 256) != 0 ? null : str2, (i & 512) != 0 ? null : str3, (i & 1024) != 0 ? null : num2, (i & 2048) != 0 ? null : str4, (i & 4096) != 0 ? null : str5, (i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? null : list4, (i & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) != 0 ? null : list5, (i & AttribFlags.SSH_FILEXFER_ATTR_CTIME) != 0 ? null : num3, (i & 65536) != 0 ? null : str6);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ OutSettingsBean copy$default(OutSettingsBean outSettingsBean, List list, FragmentBean fragmentBean, List list2, List list3, Response response, String str, Object obj, Integer num, String str2, String str3, Integer num2, String str4, String str5, List list4, List list5, Integer num3, String str6, int i, Object obj2) {
                String str7;
                Integer num4;
                List list6 = (i & 1) != 0 ? outSettingsBean.vnext : list;
                FragmentBean fragmentBean2 = (i & 2) != 0 ? outSettingsBean.fragment : fragmentBean;
                List list7 = (i & 4) != 0 ? outSettingsBean.noises : list2;
                List list8 = (i & 8) != 0 ? outSettingsBean.servers : list3;
                Response response2 = (i & 16) != 0 ? outSettingsBean.response : response;
                String str8 = (i & 32) != 0 ? outSettingsBean.network : str;
                Object obj3 = (i & 64) != 0 ? outSettingsBean.address : obj;
                Integer num5 = (i & 128) != 0 ? outSettingsBean.port : num;
                String str9 = (i & 256) != 0 ? outSettingsBean.domainStrategy : str2;
                String str10 = (i & 512) != 0 ? outSettingsBean.redirect : str3;
                Integer num6 = (i & 1024) != 0 ? outSettingsBean.userLevel : num2;
                String str11 = (i & 2048) != 0 ? outSettingsBean.inboundTag : str4;
                String str12 = (i & 4096) != 0 ? outSettingsBean.secretKey : str5;
                List list9 = (i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? outSettingsBean.peers : list4;
                List list10 = list6;
                List list11 = (i & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) != 0 ? outSettingsBean.reserved : list5;
                Integer num7 = (i & AttribFlags.SSH_FILEXFER_ATTR_CTIME) != 0 ? outSettingsBean.mtu : num3;
                if ((i & 65536) != 0) {
                    num4 = num7;
                    str7 = outSettingsBean.obfsPassword;
                } else {
                    str7 = str6;
                    num4 = num7;
                }
                return outSettingsBean.copy(list10, fragmentBean2, list7, list8, response2, str8, obj3, num5, str9, str10, num6, str11, str12, list9, list11, num4, str7);
            }

            public final List<VnextBean> component1() {
                return this.vnext;
            }

            public final String component10() {
                return this.redirect;
            }

            public final Integer component11() {
                return this.userLevel;
            }

            public final String component12() {
                return this.inboundTag;
            }

            public final String component13() {
                return this.secretKey;
            }

            public final List<WireGuardBean> component14() {
                return this.peers;
            }

            public final List<Integer> component15() {
                return this.reserved;
            }

            public final Integer component16() {
                return this.mtu;
            }

            public final String component17() {
                return this.obfsPassword;
            }

            public final FragmentBean component2() {
                return this.fragment;
            }

            public final List<NoiseBean> component3() {
                return this.noises;
            }

            public final List<ServersBean> component4() {
                return this.servers;
            }

            public final Response component5() {
                return this.response;
            }

            public final String component6() {
                return this.network;
            }

            public final Object component7() {
                return this.address;
            }

            public final Integer component8() {
                return this.port;
            }

            public final String component9() {
                return this.domainStrategy;
            }

            public final OutSettingsBean copy(List<VnextBean> list, FragmentBean fragmentBean, List<NoiseBean> list2, List<ServersBean> list3, Response response, String str, Object obj, Integer num, String str2, String str3, Integer num2, String str4, String str5, List<WireGuardBean> list4, List<Integer> list5, Integer num3, String str6) {
                return new OutSettingsBean(list, fragmentBean, list2, list3, response, str, obj, num, str2, str3, num2, str4, str5, list4, list5, num3, str6);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OutSettingsBean)) {
                    return false;
                }
                OutSettingsBean outSettingsBean = (OutSettingsBean) obj;
                return e4.a(this.vnext, outSettingsBean.vnext) && e4.a(this.fragment, outSettingsBean.fragment) && e4.a(this.noises, outSettingsBean.noises) && e4.a(this.servers, outSettingsBean.servers) && e4.a(this.response, outSettingsBean.response) && e4.a(this.network, outSettingsBean.network) && e4.a(this.address, outSettingsBean.address) && e4.a(this.port, outSettingsBean.port) && e4.a(this.domainStrategy, outSettingsBean.domainStrategy) && e4.a(this.redirect, outSettingsBean.redirect) && e4.a(this.userLevel, outSettingsBean.userLevel) && e4.a(this.inboundTag, outSettingsBean.inboundTag) && e4.a(this.secretKey, outSettingsBean.secretKey) && e4.a(this.peers, outSettingsBean.peers) && e4.a(this.reserved, outSettingsBean.reserved) && e4.a(this.mtu, outSettingsBean.mtu) && e4.a(this.obfsPassword, outSettingsBean.obfsPassword);
            }

            public final Object getAddress() {
                return this.address;
            }

            public final String getDomainStrategy() {
                return this.domainStrategy;
            }

            public final FragmentBean getFragment() {
                return this.fragment;
            }

            public final String getInboundTag() {
                return this.inboundTag;
            }

            public final Integer getMtu() {
                return this.mtu;
            }

            public final String getNetwork() {
                return this.network;
            }

            public final List<NoiseBean> getNoises() {
                return this.noises;
            }

            public final String getObfsPassword() {
                return this.obfsPassword;
            }

            public final List<WireGuardBean> getPeers() {
                return this.peers;
            }

            public final Integer getPort() {
                return this.port;
            }

            public final String getRedirect() {
                return this.redirect;
            }

            public final List<Integer> getReserved() {
                return this.reserved;
            }

            public final Response getResponse() {
                return this.response;
            }

            public final String getSecretKey() {
                return this.secretKey;
            }

            public final List<ServersBean> getServers() {
                return this.servers;
            }

            public final Integer getUserLevel() {
                return this.userLevel;
            }

            public final List<VnextBean> getVnext() {
                return this.vnext;
            }

            public int hashCode() {
                List<VnextBean> list = this.vnext;
                int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
                FragmentBean fragmentBean = this.fragment;
                int iHashCode2 = (iHashCode + (fragmentBean == null ? 0 : fragmentBean.hashCode())) * 31;
                List<NoiseBean> list2 = this.noises;
                int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
                List<ServersBean> list3 = this.servers;
                int iHashCode4 = (iHashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
                Response response = this.response;
                int iHashCode5 = (iHashCode4 + (response == null ? 0 : response.hashCode())) * 31;
                String str = this.network;
                int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
                Object obj = this.address;
                int iHashCode7 = (iHashCode6 + (obj == null ? 0 : obj.hashCode())) * 31;
                Integer num = this.port;
                int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
                String str2 = this.domainStrategy;
                int iHashCode9 = (iHashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.redirect;
                int iHashCode10 = (iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
                Integer num2 = this.userLevel;
                int iHashCode11 = (iHashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
                String str4 = this.inboundTag;
                int iHashCode12 = (iHashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.secretKey;
                int iHashCode13 = (iHashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
                List<WireGuardBean> list4 = this.peers;
                int iHashCode14 = (iHashCode13 + (list4 == null ? 0 : list4.hashCode())) * 31;
                List<Integer> list5 = this.reserved;
                int iHashCode15 = (iHashCode14 + (list5 == null ? 0 : list5.hashCode())) * 31;
                Integer num3 = this.mtu;
                int iHashCode16 = (iHashCode15 + (num3 == null ? 0 : num3.hashCode())) * 31;
                String str6 = this.obfsPassword;
                return iHashCode16 + (str6 != null ? str6.hashCode() : 0);
            }

            public final void setAddress(Object obj) {
                this.address = obj;
            }

            public final void setDomainStrategy(String str) {
                this.domainStrategy = str;
            }

            public final void setFragment(FragmentBean fragmentBean) {
                this.fragment = fragmentBean;
            }

            public final void setMtu(Integer num) {
                this.mtu = num;
            }

            public final void setNoises(List<NoiseBean> list) {
                this.noises = list;
            }

            public final void setObfsPassword(String str) {
                this.obfsPassword = str;
            }

            public final void setReserved(List<Integer> list) {
                this.reserved = list;
            }

            public final void setResponse(Response response) {
                this.response = response;
            }

            public final void setSecretKey(String str) {
                this.secretKey = str;
            }

            public final void setServers(List<ServersBean> list) {
                this.servers = list;
            }

            public final void setVnext(List<VnextBean> list) {
                this.vnext = list;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("OutSettingsBean(vnext=");
                sb.append(this.vnext);
                sb.append(", fragment=");
                sb.append(this.fragment);
                sb.append(", noises=");
                sb.append(this.noises);
                sb.append(", servers=");
                sb.append(this.servers);
                sb.append(", response=");
                sb.append(this.response);
                sb.append(", network=");
                sb.append(this.network);
                sb.append(", address=");
                sb.append(this.address);
                sb.append(", port=");
                sb.append(this.port);
                sb.append(", domainStrategy=");
                sb.append(this.domainStrategy);
                sb.append(", redirect=");
                sb.append(this.redirect);
                sb.append(", userLevel=");
                sb.append(this.userLevel);
                sb.append(", inboundTag=");
                sb.append(this.inboundTag);
                sb.append(", secretKey=");
                sb.append(this.secretKey);
                sb.append(", peers=");
                sb.append(this.peers);
                sb.append(", reserved=");
                sb.append(this.reserved);
                sb.append(", mtu=");
                sb.append(this.mtu);
                sb.append(", obfsPassword=");
                return fb$1.m(sb, this.obfsPassword, ')');
            }
        }

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class StreamSettingsBean {
            private final Object dsSettings;
            private GrpcSettingsBean grpcSettings;
            private HttpSettingsBean httpSettings;
            private HttpupgradeSettingsBean httpupgradeSettings;
            private Hy2steriaSettingsBean hy2steriaSettings;
            private KcpSettingsBean kcpSettings;
            private String network;
            private QuicSettingBean quicSettings;
            private TlsSettingsBean realitySettings;
            private String security;
            private SockoptBean sockopt;
            private SplithttpSettingsBean splithttpSettings;
            private TcpSettingsBean tcpSettings;
            private TlsSettingsBean tlsSettings;
            private WsSettingsBean wsSettings;
            private XhttpSettingsBean xhttpSettings;

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class GrpcSettingsBean {
                private String authority;
                private Integer health_check_timeout;
                private Integer idle_timeout;
                private Boolean multiMode;
                private String serviceName;

                public GrpcSettingsBean() {
                    this(null, null, null, null, null, 31, null);
                }

                public GrpcSettingsBean(String str, String str2, Boolean bool, Integer num, Integer num2) {
                    this.serviceName = str;
                    this.authority = str2;
                    this.multiMode = bool;
                    this.idle_timeout = num;
                    this.health_check_timeout = num2;
                }

                public /* synthetic */ GrpcSettingsBean(String str, String str2, Boolean bool, Integer num, Integer num2, int i, zk zkVar) {
                    this((i & 1) != 0 ? AppConfig.CUSTOM : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2);
                }

                public static /* synthetic */ GrpcSettingsBean copy$default(GrpcSettingsBean grpcSettingsBean, String str, String str2, Boolean bool, Integer num, Integer num2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = grpcSettingsBean.serviceName;
                    }
                    if ((i & 2) != 0) {
                        str2 = grpcSettingsBean.authority;
                    }
                    if ((i & 4) != 0) {
                        bool = grpcSettingsBean.multiMode;
                    }
                    if ((i & 8) != 0) {
                        num = grpcSettingsBean.idle_timeout;
                    }
                    if ((i & 16) != 0) {
                        num2 = grpcSettingsBean.health_check_timeout;
                    }
                    Integer num3 = num2;
                    Boolean bool2 = bool;
                    return grpcSettingsBean.copy(str, str2, bool2, num, num3);
                }

                public final String component1() {
                    return this.serviceName;
                }

                public final String component2() {
                    return this.authority;
                }

                public final Boolean component3() {
                    return this.multiMode;
                }

                public final Integer component4() {
                    return this.idle_timeout;
                }

                public final Integer component5() {
                    return this.health_check_timeout;
                }

                public final GrpcSettingsBean copy(String str, String str2, Boolean bool, Integer num, Integer num2) {
                    return new GrpcSettingsBean(str, str2, bool, num, num2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof GrpcSettingsBean)) {
                        return false;
                    }
                    GrpcSettingsBean grpcSettingsBean = (GrpcSettingsBean) obj;
                    return e4.a(this.serviceName, grpcSettingsBean.serviceName) && e4.a(this.authority, grpcSettingsBean.authority) && e4.a(this.multiMode, grpcSettingsBean.multiMode) && e4.a(this.idle_timeout, grpcSettingsBean.idle_timeout) && e4.a(this.health_check_timeout, grpcSettingsBean.health_check_timeout);
                }

                public final String getAuthority() {
                    return this.authority;
                }

                public final Integer getHealth_check_timeout() {
                    return this.health_check_timeout;
                }

                public final Integer getIdle_timeout() {
                    return this.idle_timeout;
                }

                public final Boolean getMultiMode() {
                    return this.multiMode;
                }

                public final String getServiceName() {
                    return this.serviceName;
                }

                public int hashCode() {
                    int iHashCode = this.serviceName.hashCode() * 31;
                    String str = this.authority;
                    int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                    Boolean bool = this.multiMode;
                    int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
                    Integer num = this.idle_timeout;
                    int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
                    Integer num2 = this.health_check_timeout;
                    return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
                }

                public final void setAuthority(String str) {
                    this.authority = str;
                }

                public final void setHealth_check_timeout(Integer num) {
                    this.health_check_timeout = num;
                }

                public final void setIdle_timeout(Integer num) {
                    this.idle_timeout = num;
                }

                public final void setMultiMode(Boolean bool) {
                    this.multiMode = bool;
                }

                public final void setServiceName(String str) {
                    this.serviceName = str;
                }

                public String toString() {
                    return "GrpcSettingsBean(serviceName=" + this.serviceName + ", authority=" + this.authority + ", multiMode=" + this.multiMode + ", idle_timeout=" + this.idle_timeout + ", health_check_timeout=" + this.health_check_timeout + ')';
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class HttpSettingsBean {
                private List<String> host;
                private String path;

                /* JADX WARN: Multi-variable type inference failed */
                public HttpSettingsBean() {
                    this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                }

                public HttpSettingsBean(List<String> list, String str) {
                    this.host = list;
                    this.path = str;
                }

                public /* synthetic */ HttpSettingsBean(List list, String str, int i, zk zkVar) {
                    this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? null : str);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ HttpSettingsBean copy$default(HttpSettingsBean httpSettingsBean, List list, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = httpSettingsBean.host;
                    }
                    if ((i & 2) != 0) {
                        str = httpSettingsBean.path;
                    }
                    return httpSettingsBean.copy(list, str);
                }

                public final List<String> component1() {
                    return this.host;
                }

                public final String component2() {
                    return this.path;
                }

                public final HttpSettingsBean copy(List<String> list, String str) {
                    return new HttpSettingsBean(list, str);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof HttpSettingsBean)) {
                        return false;
                    }
                    HttpSettingsBean httpSettingsBean = (HttpSettingsBean) obj;
                    return e4.a(this.host, httpSettingsBean.host) && e4.a(this.path, httpSettingsBean.path);
                }

                public final List<String> getHost() {
                    return this.host;
                }

                public final String getPath() {
                    return this.path;
                }

                public int hashCode() {
                    int iHashCode = this.host.hashCode() * 31;
                    String str = this.path;
                    return iHashCode + (str == null ? 0 : str.hashCode());
                }

                public final void setHost(List<String> list) {
                    this.host = list;
                }

                public final void setPath(String str) {
                    this.path = str;
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder("HttpSettingsBean(host=");
                    sb.append(this.host);
                    sb.append(", path=");
                    return fb$1.m(sb, this.path, ')');
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class HttpupgradeSettingsBean {
                private final Boolean acceptProxyProtocol;
                private String host;
                private String path;

                public HttpupgradeSettingsBean() {
                    this(null, null, null, 7, null);
                }

                public HttpupgradeSettingsBean(String str, String str2, Boolean bool) {
                    this.path = str;
                    this.host = str2;
                    this.acceptProxyProtocol = bool;
                }

                public /* synthetic */ HttpupgradeSettingsBean(String str, String str2, Boolean bool, int i, zk zkVar) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool);
                }

                public static /* synthetic */ HttpupgradeSettingsBean copy$default(HttpupgradeSettingsBean httpupgradeSettingsBean, String str, String str2, Boolean bool, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = httpupgradeSettingsBean.path;
                    }
                    if ((i & 2) != 0) {
                        str2 = httpupgradeSettingsBean.host;
                    }
                    if ((i & 4) != 0) {
                        bool = httpupgradeSettingsBean.acceptProxyProtocol;
                    }
                    return httpupgradeSettingsBean.copy(str, str2, bool);
                }

                public final String component1() {
                    return this.path;
                }

                public final String component2() {
                    return this.host;
                }

                public final Boolean component3() {
                    return this.acceptProxyProtocol;
                }

                public final HttpupgradeSettingsBean copy(String str, String str2, Boolean bool) {
                    return new HttpupgradeSettingsBean(str, str2, bool);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof HttpupgradeSettingsBean)) {
                        return false;
                    }
                    HttpupgradeSettingsBean httpupgradeSettingsBean = (HttpupgradeSettingsBean) obj;
                    return e4.a(this.path, httpupgradeSettingsBean.path) && e4.a(this.host, httpupgradeSettingsBean.host) && e4.a(this.acceptProxyProtocol, httpupgradeSettingsBean.acceptProxyProtocol);
                }

                public final Boolean getAcceptProxyProtocol() {
                    return this.acceptProxyProtocol;
                }

                public final String getHost() {
                    return this.host;
                }

                public final String getPath() {
                    return this.path;
                }

                public int hashCode() {
                    String str = this.path;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.host;
                    int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    Boolean bool = this.acceptProxyProtocol;
                    return iHashCode2 + (bool != null ? bool.hashCode() : 0);
                }

                public final void setHost(String str) {
                    this.host = str;
                }

                public final void setPath(String str) {
                    this.path = str;
                }

                public String toString() {
                    return "HttpupgradeSettingsBean(path=" + this.path + ", host=" + this.host + ", acceptProxyProtocol=" + this.acceptProxyProtocol + ')';
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class Hy2steriaSettingsBean {
                private Hy2CongestionBean congestion;
                private String password;
                private Boolean use_udp_extension;

                /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
                public static final class Hy2CongestionBean {
                    private Integer down_mbps;
                    private String type;
                    private Integer up_mbps;

                    public Hy2CongestionBean() {
                        this(null, null, null, 7, null);
                    }

                    public Hy2CongestionBean(String str, Integer num, Integer num2) {
                        this.type = str;
                        this.up_mbps = num;
                        this.down_mbps = num2;
                    }

                    public /* synthetic */ Hy2CongestionBean(String str, Integer num, Integer num2, int i, zk zkVar) {
                        this((i & 1) != 0 ? "bbr" : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2);
                    }

                    public static /* synthetic */ Hy2CongestionBean copy$default(Hy2CongestionBean hy2CongestionBean, String str, Integer num, Integer num2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = hy2CongestionBean.type;
                        }
                        if ((i & 2) != 0) {
                            num = hy2CongestionBean.up_mbps;
                        }
                        if ((i & 4) != 0) {
                            num2 = hy2CongestionBean.down_mbps;
                        }
                        return hy2CongestionBean.copy(str, num, num2);
                    }

                    public final String component1() {
                        return this.type;
                    }

                    public final Integer component2() {
                        return this.up_mbps;
                    }

                    public final Integer component3() {
                        return this.down_mbps;
                    }

                    public final Hy2CongestionBean copy(String str, Integer num, Integer num2) {
                        return new Hy2CongestionBean(str, num, num2);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Hy2CongestionBean)) {
                            return false;
                        }
                        Hy2CongestionBean hy2CongestionBean = (Hy2CongestionBean) obj;
                        return e4.a(this.type, hy2CongestionBean.type) && e4.a(this.up_mbps, hy2CongestionBean.up_mbps) && e4.a(this.down_mbps, hy2CongestionBean.down_mbps);
                    }

                    public final Integer getDown_mbps() {
                        return this.down_mbps;
                    }

                    public final String getType() {
                        return this.type;
                    }

                    public final Integer getUp_mbps() {
                        return this.up_mbps;
                    }

                    public int hashCode() {
                        String str = this.type;
                        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                        Integer num = this.up_mbps;
                        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
                        Integer num2 = this.down_mbps;
                        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
                    }

                    public final void setDown_mbps(Integer num) {
                        this.down_mbps = num;
                    }

                    public final void setType(String str) {
                        this.type = str;
                    }

                    public final void setUp_mbps(Integer num) {
                        this.up_mbps = num;
                    }

                    public String toString() {
                        return "Hy2CongestionBean(type=" + this.type + ", up_mbps=" + this.up_mbps + ", down_mbps=" + this.down_mbps + ')';
                    }
                }

                public Hy2steriaSettingsBean() {
                    this(null, null, null, 7, null);
                }

                public Hy2steriaSettingsBean(String str, Boolean bool, Hy2CongestionBean hy2CongestionBean) {
                    this.password = str;
                    this.use_udp_extension = bool;
                    this.congestion = hy2CongestionBean;
                }

                public /* synthetic */ Hy2steriaSettingsBean(String str, Boolean bool, Hy2CongestionBean hy2CongestionBean, int i, zk zkVar) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? Boolean.TRUE : bool, (i & 4) != 0 ? null : hy2CongestionBean);
                }

                public static /* synthetic */ Hy2steriaSettingsBean copy$default(Hy2steriaSettingsBean hy2steriaSettingsBean, String str, Boolean bool, Hy2CongestionBean hy2CongestionBean, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = hy2steriaSettingsBean.password;
                    }
                    if ((i & 2) != 0) {
                        bool = hy2steriaSettingsBean.use_udp_extension;
                    }
                    if ((i & 4) != 0) {
                        hy2CongestionBean = hy2steriaSettingsBean.congestion;
                    }
                    return hy2steriaSettingsBean.copy(str, bool, hy2CongestionBean);
                }

                public final String component1() {
                    return this.password;
                }

                public final Boolean component2() {
                    return this.use_udp_extension;
                }

                public final Hy2CongestionBean component3() {
                    return this.congestion;
                }

                public final Hy2steriaSettingsBean copy(String str, Boolean bool, Hy2CongestionBean hy2CongestionBean) {
                    return new Hy2steriaSettingsBean(str, bool, hy2CongestionBean);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Hy2steriaSettingsBean)) {
                        return false;
                    }
                    Hy2steriaSettingsBean hy2steriaSettingsBean = (Hy2steriaSettingsBean) obj;
                    return e4.a(this.password, hy2steriaSettingsBean.password) && e4.a(this.use_udp_extension, hy2steriaSettingsBean.use_udp_extension) && e4.a(this.congestion, hy2steriaSettingsBean.congestion);
                }

                public final Hy2CongestionBean getCongestion() {
                    return this.congestion;
                }

                public final String getPassword() {
                    return this.password;
                }

                public final Boolean getUse_udp_extension() {
                    return this.use_udp_extension;
                }

                public int hashCode() {
                    String str = this.password;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    Boolean bool = this.use_udp_extension;
                    int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
                    Hy2CongestionBean hy2CongestionBean = this.congestion;
                    return iHashCode2 + (hy2CongestionBean != null ? hy2CongestionBean.hashCode() : 0);
                }

                public final void setCongestion(Hy2CongestionBean hy2CongestionBean) {
                    this.congestion = hy2CongestionBean;
                }

                public final void setPassword(String str) {
                    this.password = str;
                }

                public final void setUse_udp_extension(Boolean bool) {
                    this.use_udp_extension = bool;
                }

                public String toString() {
                    return "Hy2steriaSettingsBean(password=" + this.password + ", use_udp_extension=" + this.use_udp_extension + ", congestion=" + this.congestion + ')';
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class KcpSettingsBean {
                private boolean congestion;
                private int downlinkCapacity;
                private HeaderBean header;
                private int mtu;
                private int readBufferSize;
                private String seed;
                private int tti;
                private int uplinkCapacity;
                private int writeBufferSize;

                /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
                public static final class HeaderBean {
                    private String type;

                    /* JADX WARN: Multi-variable type inference failed */
                    public HeaderBean() {
                        this(null, 1, 0 == true ? 1 : 0);
                    }

                    public HeaderBean(String str) {
                        this.type = str;
                    }

                    public /* synthetic */ HeaderBean(String str, int i, zk zkVar) {
                        this((i & 1) != 0 ? "none" : str);
                    }

                    public static /* synthetic */ HeaderBean copy$default(HeaderBean headerBean, String str, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = headerBean.type;
                        }
                        return headerBean.copy(str);
                    }

                    public final String component1() {
                        return this.type;
                    }

                    public final HeaderBean copy(String str) {
                        return new HeaderBean(str);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof HeaderBean) && e4.a(this.type, ((HeaderBean) obj).type);
                    }

                    public final String getType() {
                        return this.type;
                    }

                    public int hashCode() {
                        return this.type.hashCode();
                    }

                    public final void setType(String str) {
                        this.type = str;
                    }

                    public String toString() {
                        return fb$1.m(new StringBuilder("HeaderBean(type="), this.type, ')');
                    }
                }

                public KcpSettingsBean() {
                    this(0, 0, 0, 0, false, 0, 0, null, null, 511, null);
                }

                public KcpSettingsBean(int i, int i2, int i3, int i4, boolean z, int i5, int i6, HeaderBean headerBean, String str) {
                    this.mtu = i;
                    this.tti = i2;
                    this.uplinkCapacity = i3;
                    this.downlinkCapacity = i4;
                    this.congestion = z;
                    this.readBufferSize = i5;
                    this.writeBufferSize = i6;
                    this.header = headerBean;
                    this.seed = str;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public /* synthetic */ KcpSettingsBean(int i, int i2, int i3, int i4, boolean z, int i5, int i6, HeaderBean headerBean, String str, int i7, zk zkVar) {
                    this((i7 & 1) != 0 ? 1350 : i, (i7 & 2) != 0 ? 50 : i2, (i7 & 4) != 0 ? 12 : i3, (i7 & 8) != 0 ? 100 : i4, (i7 & 16) != 0 ? false : z, (i7 & 32) != 0 ? 1 : i5, (i7 & 64) != 0 ? 1 : i6, (i7 & 128) != 0 ? new HeaderBean(null, 1, 0 == true ? 1 : 0) : headerBean, (i7 & 256) != 0 ? null : str);
                }

                public static /* synthetic */ KcpSettingsBean copy$default(KcpSettingsBean kcpSettingsBean, int i, int i2, int i3, int i4, boolean z, int i5, int i6, HeaderBean headerBean, String str, int i7, Object obj) {
                    if ((i7 & 1) != 0) {
                        i = kcpSettingsBean.mtu;
                    }
                    if ((i7 & 2) != 0) {
                        i2 = kcpSettingsBean.tti;
                    }
                    if ((i7 & 4) != 0) {
                        i3 = kcpSettingsBean.uplinkCapacity;
                    }
                    if ((i7 & 8) != 0) {
                        i4 = kcpSettingsBean.downlinkCapacity;
                    }
                    if ((i7 & 16) != 0) {
                        z = kcpSettingsBean.congestion;
                    }
                    if ((i7 & 32) != 0) {
                        i5 = kcpSettingsBean.readBufferSize;
                    }
                    if ((i7 & 64) != 0) {
                        i6 = kcpSettingsBean.writeBufferSize;
                    }
                    if ((i7 & 128) != 0) {
                        headerBean = kcpSettingsBean.header;
                    }
                    if ((i7 & 256) != 0) {
                        str = kcpSettingsBean.seed;
                    }
                    HeaderBean headerBean2 = headerBean;
                    String str2 = str;
                    int i8 = i5;
                    int i9 = i6;
                    boolean z2 = z;
                    int i10 = i3;
                    return kcpSettingsBean.copy(i, i2, i10, i4, z2, i8, i9, headerBean2, str2);
                }

                public final int component1() {
                    return this.mtu;
                }

                public final int component2() {
                    return this.tti;
                }

                public final int component3() {
                    return this.uplinkCapacity;
                }

                public final int component4() {
                    return this.downlinkCapacity;
                }

                public final boolean component5() {
                    return this.congestion;
                }

                public final int component6() {
                    return this.readBufferSize;
                }

                public final int component7() {
                    return this.writeBufferSize;
                }

                public final HeaderBean component8() {
                    return this.header;
                }

                public final String component9() {
                    return this.seed;
                }

                public final KcpSettingsBean copy(int i, int i2, int i3, int i4, boolean z, int i5, int i6, HeaderBean headerBean, String str) {
                    return new KcpSettingsBean(i, i2, i3, i4, z, i5, i6, headerBean, str);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof KcpSettingsBean)) {
                        return false;
                    }
                    KcpSettingsBean kcpSettingsBean = (KcpSettingsBean) obj;
                    return this.mtu == kcpSettingsBean.mtu && this.tti == kcpSettingsBean.tti && this.uplinkCapacity == kcpSettingsBean.uplinkCapacity && this.downlinkCapacity == kcpSettingsBean.downlinkCapacity && this.congestion == kcpSettingsBean.congestion && this.readBufferSize == kcpSettingsBean.readBufferSize && this.writeBufferSize == kcpSettingsBean.writeBufferSize && e4.a(this.header, kcpSettingsBean.header) && e4.a(this.seed, kcpSettingsBean.seed);
                }

                public final boolean getCongestion() {
                    return this.congestion;
                }

                public final int getDownlinkCapacity() {
                    return this.downlinkCapacity;
                }

                public final HeaderBean getHeader() {
                    return this.header;
                }

                public final int getMtu() {
                    return this.mtu;
                }

                public final int getReadBufferSize() {
                    return this.readBufferSize;
                }

                public final String getSeed() {
                    return this.seed;
                }

                public final int getTti() {
                    return this.tti;
                }

                public final int getUplinkCapacity() {
                    return this.uplinkCapacity;
                }

                public final int getWriteBufferSize() {
                    return this.writeBufferSize;
                }

                public int hashCode() {
                    int iHashCode = (this.header.hashCode() + (((((((((((((this.mtu * 31) + this.tti) * 31) + this.uplinkCapacity) * 31) + this.downlinkCapacity) * 31) + (this.congestion ? 1231 : 1237)) * 31) + this.readBufferSize) * 31) + this.writeBufferSize) * 31)) * 31;
                    String str = this.seed;
                    return iHashCode + (str == null ? 0 : str.hashCode());
                }

                public final void setCongestion(boolean z) {
                    this.congestion = z;
                }

                public final void setDownlinkCapacity(int i) {
                    this.downlinkCapacity = i;
                }

                public final void setHeader(HeaderBean headerBean) {
                    this.header = headerBean;
                }

                public final void setMtu(int i) {
                    this.mtu = i;
                }

                public final void setReadBufferSize(int i) {
                    this.readBufferSize = i;
                }

                public final void setSeed(String str) {
                    this.seed = str;
                }

                public final void setTti(int i) {
                    this.tti = i;
                }

                public final void setUplinkCapacity(int i) {
                    this.uplinkCapacity = i;
                }

                public final void setWriteBufferSize(int i) {
                    this.writeBufferSize = i;
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder("KcpSettingsBean(mtu=");
                    sb.append(this.mtu);
                    sb.append(", tti=");
                    sb.append(this.tti);
                    sb.append(", uplinkCapacity=");
                    sb.append(this.uplinkCapacity);
                    sb.append(", downlinkCapacity=");
                    sb.append(this.downlinkCapacity);
                    sb.append(", congestion=");
                    sb.append(this.congestion);
                    sb.append(", readBufferSize=");
                    sb.append(this.readBufferSize);
                    sb.append(", writeBufferSize=");
                    sb.append(this.writeBufferSize);
                    sb.append(", header=");
                    sb.append(this.header);
                    sb.append(", seed=");
                    return fb$1.m(sb, this.seed, ')');
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class QuicSettingBean {
                private HeaderBean header;
                private String key;
                private String security;

                /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
                public static final class HeaderBean {
                    private String type;

                    /* JADX WARN: Multi-variable type inference failed */
                    public HeaderBean() {
                        this(null, 1, 0 == true ? 1 : 0);
                    }

                    public HeaderBean(String str) {
                        this.type = str;
                    }

                    public /* synthetic */ HeaderBean(String str, int i, zk zkVar) {
                        this((i & 1) != 0 ? "none" : str);
                    }

                    public static /* synthetic */ HeaderBean copy$default(HeaderBean headerBean, String str, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = headerBean.type;
                        }
                        return headerBean.copy(str);
                    }

                    public final String component1() {
                        return this.type;
                    }

                    public final HeaderBean copy(String str) {
                        return new HeaderBean(str);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof HeaderBean) && e4.a(this.type, ((HeaderBean) obj).type);
                    }

                    public final String getType() {
                        return this.type;
                    }

                    public int hashCode() {
                        return this.type.hashCode();
                    }

                    public final void setType(String str) {
                        this.type = str;
                    }

                    public String toString() {
                        return fb$1.m(new StringBuilder("HeaderBean(type="), this.type, ')');
                    }
                }

                public QuicSettingBean() {
                    this(null, null, null, 7, null);
                }

                public QuicSettingBean(String str, String str2, HeaderBean headerBean) {
                    this.security = str;
                    this.key = str2;
                    this.header = headerBean;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public /* synthetic */ QuicSettingBean(String str, String str2, HeaderBean headerBean, int i, zk zkVar) {
                    this((i & 1) != 0 ? "none" : str, (i & 2) != 0 ? AppConfig.CUSTOM : str2, (i & 4) != 0 ? new HeaderBean(null, 1, 0 == true ? 1 : 0) : headerBean);
                }

                public static /* synthetic */ QuicSettingBean copy$default(QuicSettingBean quicSettingBean, String str, String str2, HeaderBean headerBean, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = quicSettingBean.security;
                    }
                    if ((i & 2) != 0) {
                        str2 = quicSettingBean.key;
                    }
                    if ((i & 4) != 0) {
                        headerBean = quicSettingBean.header;
                    }
                    return quicSettingBean.copy(str, str2, headerBean);
                }

                public final String component1() {
                    return this.security;
                }

                public final String component2() {
                    return this.key;
                }

                public final HeaderBean component3() {
                    return this.header;
                }

                public final QuicSettingBean copy(String str, String str2, HeaderBean headerBean) {
                    return new QuicSettingBean(str, str2, headerBean);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof QuicSettingBean)) {
                        return false;
                    }
                    QuicSettingBean quicSettingBean = (QuicSettingBean) obj;
                    return e4.a(this.security, quicSettingBean.security) && e4.a(this.key, quicSettingBean.key) && e4.a(this.header, quicSettingBean.header);
                }

                public final HeaderBean getHeader() {
                    return this.header;
                }

                public final String getKey() {
                    return this.key;
                }

                public final String getSecurity() {
                    return this.security;
                }

                public int hashCode() {
                    return this.header.hashCode() + e.d(this.security.hashCode() * 31, this.key);
                }

                public final void setHeader(HeaderBean headerBean) {
                    this.header = headerBean;
                }

                public final void setKey(String str) {
                    this.key = str;
                }

                public final void setSecurity(String str) {
                    this.security = str;
                }

                public String toString() {
                    return "QuicSettingBean(security=" + this.security + ", key=" + this.key + ", header=" + this.header + ')';
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class SockoptBean {
                private Boolean TcpNoDelay;
                private String dialerProxy;
                private Integer mark;
                private Boolean tcpFastOpen;
                private Integer tcpKeepAliveIdle;
                private String tproxy;

                public SockoptBean() {
                    this(null, null, null, null, null, null, 63, null);
                }

                public SockoptBean(Boolean bool, Integer num, Boolean bool2, String str, Integer num2, String str2) {
                    this.TcpNoDelay = bool;
                    this.tcpKeepAliveIdle = num;
                    this.tcpFastOpen = bool2;
                    this.tproxy = str;
                    this.mark = num2;
                    this.dialerProxy = str2;
                }

                public /* synthetic */ SockoptBean(Boolean bool, Integer num, Boolean bool2, String str, Integer num2, String str2, int i, zk zkVar) {
                    this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str2);
                }

                public static /* synthetic */ SockoptBean copy$default(SockoptBean sockoptBean, Boolean bool, Integer num, Boolean bool2, String str, Integer num2, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        bool = sockoptBean.TcpNoDelay;
                    }
                    if ((i & 2) != 0) {
                        num = sockoptBean.tcpKeepAliveIdle;
                    }
                    if ((i & 4) != 0) {
                        bool2 = sockoptBean.tcpFastOpen;
                    }
                    if ((i & 8) != 0) {
                        str = sockoptBean.tproxy;
                    }
                    if ((i & 16) != 0) {
                        num2 = sockoptBean.mark;
                    }
                    if ((i & 32) != 0) {
                        str2 = sockoptBean.dialerProxy;
                    }
                    Integer num3 = num2;
                    String str3 = str2;
                    return sockoptBean.copy(bool, num, bool2, str, num3, str3);
                }

                public final Boolean component1() {
                    return this.TcpNoDelay;
                }

                public final Integer component2() {
                    return this.tcpKeepAliveIdle;
                }

                public final Boolean component3() {
                    return this.tcpFastOpen;
                }

                public final String component4() {
                    return this.tproxy;
                }

                public final Integer component5() {
                    return this.mark;
                }

                public final String component6() {
                    return this.dialerProxy;
                }

                public final SockoptBean copy(Boolean bool, Integer num, Boolean bool2, String str, Integer num2, String str2) {
                    return new SockoptBean(bool, num, bool2, str, num2, str2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof SockoptBean)) {
                        return false;
                    }
                    SockoptBean sockoptBean = (SockoptBean) obj;
                    return e4.a(this.TcpNoDelay, sockoptBean.TcpNoDelay) && e4.a(this.tcpKeepAliveIdle, sockoptBean.tcpKeepAliveIdle) && e4.a(this.tcpFastOpen, sockoptBean.tcpFastOpen) && e4.a(this.tproxy, sockoptBean.tproxy) && e4.a(this.mark, sockoptBean.mark) && e4.a(this.dialerProxy, sockoptBean.dialerProxy);
                }

                public final String getDialerProxy() {
                    return this.dialerProxy;
                }

                public final Integer getMark() {
                    return this.mark;
                }

                public final Boolean getTcpFastOpen() {
                    return this.tcpFastOpen;
                }

                public final Integer getTcpKeepAliveIdle() {
                    return this.tcpKeepAliveIdle;
                }

                public final Boolean getTcpNoDelay() {
                    return this.TcpNoDelay;
                }

                public final String getTproxy() {
                    return this.tproxy;
                }

                public int hashCode() {
                    Boolean bool = this.TcpNoDelay;
                    int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
                    Integer num = this.tcpKeepAliveIdle;
                    int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
                    Boolean bool2 = this.tcpFastOpen;
                    int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
                    String str = this.tproxy;
                    int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
                    Integer num2 = this.mark;
                    int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
                    String str2 = this.dialerProxy;
                    return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
                }

                public final void setDialerProxy(String str) {
                    this.dialerProxy = str;
                }

                public final void setMark(Integer num) {
                    this.mark = num;
                }

                public final void setTcpFastOpen(Boolean bool) {
                    this.tcpFastOpen = bool;
                }

                public final void setTcpKeepAliveIdle(Integer num) {
                    this.tcpKeepAliveIdle = num;
                }

                public final void setTcpNoDelay(Boolean bool) {
                    this.TcpNoDelay = bool;
                }

                public final void setTproxy(String str) {
                    this.tproxy = str;
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder("SockoptBean(TcpNoDelay=");
                    sb.append(this.TcpNoDelay);
                    sb.append(", tcpKeepAliveIdle=");
                    sb.append(this.tcpKeepAliveIdle);
                    sb.append(", tcpFastOpen=");
                    sb.append(this.tcpFastOpen);
                    sb.append(", tproxy=");
                    sb.append(this.tproxy);
                    sb.append(", mark=");
                    sb.append(this.mark);
                    sb.append(", dialerProxy=");
                    return fb$1.m(sb, this.dialerProxy, ')');
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class SplithttpSettingsBean {
                private String host;
                private final Integer maxConcurrentUploads;
                private final Integer maxUploadSize;
                private String path;

                public SplithttpSettingsBean() {
                    this(null, null, null, null, 15, null);
                }

                public SplithttpSettingsBean(String str, String str2, Integer num, Integer num2) {
                    this.path = str;
                    this.host = str2;
                    this.maxUploadSize = num;
                    this.maxConcurrentUploads = num2;
                }

                public /* synthetic */ SplithttpSettingsBean(String str, String str2, Integer num, Integer num2, int i, zk zkVar) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
                }

                public static /* synthetic */ SplithttpSettingsBean copy$default(SplithttpSettingsBean splithttpSettingsBean, String str, String str2, Integer num, Integer num2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = splithttpSettingsBean.path;
                    }
                    if ((i & 2) != 0) {
                        str2 = splithttpSettingsBean.host;
                    }
                    if ((i & 4) != 0) {
                        num = splithttpSettingsBean.maxUploadSize;
                    }
                    if ((i & 8) != 0) {
                        num2 = splithttpSettingsBean.maxConcurrentUploads;
                    }
                    return splithttpSettingsBean.copy(str, str2, num, num2);
                }

                public final String component1() {
                    return this.path;
                }

                public final String component2() {
                    return this.host;
                }

                public final Integer component3() {
                    return this.maxUploadSize;
                }

                public final Integer component4() {
                    return this.maxConcurrentUploads;
                }

                public final SplithttpSettingsBean copy(String str, String str2, Integer num, Integer num2) {
                    return new SplithttpSettingsBean(str, str2, num, num2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof SplithttpSettingsBean)) {
                        return false;
                    }
                    SplithttpSettingsBean splithttpSettingsBean = (SplithttpSettingsBean) obj;
                    return e4.a(this.path, splithttpSettingsBean.path) && e4.a(this.host, splithttpSettingsBean.host) && e4.a(this.maxUploadSize, splithttpSettingsBean.maxUploadSize) && e4.a(this.maxConcurrentUploads, splithttpSettingsBean.maxConcurrentUploads);
                }

                public final String getHost() {
                    return this.host;
                }

                public final Integer getMaxConcurrentUploads() {
                    return this.maxConcurrentUploads;
                }

                public final Integer getMaxUploadSize() {
                    return this.maxUploadSize;
                }

                public final String getPath() {
                    return this.path;
                }

                public int hashCode() {
                    String str = this.path;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.host;
                    int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    Integer num = this.maxUploadSize;
                    int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
                    Integer num2 = this.maxConcurrentUploads;
                    return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
                }

                public final void setHost(String str) {
                    this.host = str;
                }

                public final void setPath(String str) {
                    this.path = str;
                }

                public String toString() {
                    return "SplithttpSettingsBean(path=" + this.path + ", host=" + this.host + ", maxUploadSize=" + this.maxUploadSize + ", maxConcurrentUploads=" + this.maxConcurrentUploads + ')';
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class TcpSettingsBean {
                private final Boolean acceptProxyProtocol;
                private HeaderBean header;

                /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
                public static final class HeaderBean {
                    private RequestBean request;
                    private Object response;
                    private String type;

                    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
                    public static final class RequestBean {
                        private HeadersBean headers;
                        private final String method;
                        private List<String> path;
                        private final String version;

                        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
                        public static final class HeadersBean {
                            private final List<String> Connection;
                            private List<String> Host;
                            private final String Pragma;

                            @SerializedName("Accept-Encoding")
                            private final List<String> acceptEncoding;

                            @SerializedName("User-Agent")
                            private final List<String> userAgent;

                            public HeadersBean() {
                                this(null, null, null, null, null, 31, null);
                            }

                            public HeadersBean(List<String> list, List<String> list2, List<String> list3, List<String> list4, String str) {
                                this.Host = list;
                                this.userAgent = list2;
                                this.acceptEncoding = list3;
                                this.Connection = list4;
                                this.Pragma = str;
                            }

                            public /* synthetic */ HeadersBean(List list, List list2, List list3, List list4, String str, int i, zk zkVar) {
                                this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : list4, (i & 16) != 0 ? null : str);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public static /* synthetic */ HeadersBean copy$default(HeadersBean headersBean, List list, List list2, List list3, List list4, String str, int i, Object obj) {
                                if ((i & 1) != 0) {
                                    list = headersBean.Host;
                                }
                                if ((i & 2) != 0) {
                                    list2 = headersBean.userAgent;
                                }
                                if ((i & 4) != 0) {
                                    list3 = headersBean.acceptEncoding;
                                }
                                if ((i & 8) != 0) {
                                    list4 = headersBean.Connection;
                                }
                                if ((i & 16) != 0) {
                                    str = headersBean.Pragma;
                                }
                                String str2 = str;
                                List list5 = list3;
                                return headersBean.copy(list, list2, list5, list4, str2);
                            }

                            public final List<String> component1() {
                                return this.Host;
                            }

                            public final List<String> component2() {
                                return this.userAgent;
                            }

                            public final List<String> component3() {
                                return this.acceptEncoding;
                            }

                            public final List<String> component4() {
                                return this.Connection;
                            }

                            public final String component5() {
                                return this.Pragma;
                            }

                            public final HeadersBean copy(List<String> list, List<String> list2, List<String> list3, List<String> list4, String str) {
                                return new HeadersBean(list, list2, list3, list4, str);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (!(obj instanceof HeadersBean)) {
                                    return false;
                                }
                                HeadersBean headersBean = (HeadersBean) obj;
                                return e4.a(this.Host, headersBean.Host) && e4.a(this.userAgent, headersBean.userAgent) && e4.a(this.acceptEncoding, headersBean.acceptEncoding) && e4.a(this.Connection, headersBean.Connection) && e4.a(this.Pragma, headersBean.Pragma);
                            }

                            public final List<String> getAcceptEncoding() {
                                return this.acceptEncoding;
                            }

                            public final List<String> getConnection() {
                                return this.Connection;
                            }

                            public final List<String> getHost() {
                                return this.Host;
                            }

                            public final String getPragma() {
                                return this.Pragma;
                            }

                            public final List<String> getUserAgent() {
                                return this.userAgent;
                            }

                            public int hashCode() {
                                List<String> list = this.Host;
                                int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
                                List<String> list2 = this.userAgent;
                                int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
                                List<String> list3 = this.acceptEncoding;
                                int iHashCode3 = (iHashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
                                List<String> list4 = this.Connection;
                                int iHashCode4 = (iHashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
                                String str = this.Pragma;
                                return iHashCode4 + (str != null ? str.hashCode() : 0);
                            }

                            public final void setHost(List<String> list) {
                                this.Host = list;
                            }

                            public String toString() {
                                StringBuilder sb = new StringBuilder("HeadersBean(Host=");
                                sb.append(this.Host);
                                sb.append(", userAgent=");
                                sb.append(this.userAgent);
                                sb.append(", acceptEncoding=");
                                sb.append(this.acceptEncoding);
                                sb.append(", Connection=");
                                sb.append(this.Connection);
                                sb.append(", Pragma=");
                                return fb$1.m(sb, this.Pragma, ')');
                            }
                        }

                        public RequestBean() {
                            this(null, null, null, null, 15, null);
                        }

                        public RequestBean(List<String> list, HeadersBean headersBean, String str, String str2) {
                            this.path = list;
                            this.headers = headersBean;
                            this.version = str;
                            this.method = str2;
                        }

                        public /* synthetic */ RequestBean(List list, HeadersBean headersBean, String str, String str2, int i, zk zkVar) {
                            this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? new HeadersBean(null, null, null, null, null, 31, null) : headersBean, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public static /* synthetic */ RequestBean copy$default(RequestBean requestBean, List list, HeadersBean headersBean, String str, String str2, int i, Object obj) {
                            if ((i & 1) != 0) {
                                list = requestBean.path;
                            }
                            if ((i & 2) != 0) {
                                headersBean = requestBean.headers;
                            }
                            if ((i & 4) != 0) {
                                str = requestBean.version;
                            }
                            if ((i & 8) != 0) {
                                str2 = requestBean.method;
                            }
                            return requestBean.copy(list, headersBean, str, str2);
                        }

                        public final List<String> component1() {
                            return this.path;
                        }

                        public final HeadersBean component2() {
                            return this.headers;
                        }

                        public final String component3() {
                            return this.version;
                        }

                        public final String component4() {
                            return this.method;
                        }

                        public final RequestBean copy(List<String> list, HeadersBean headersBean, String str, String str2) {
                            return new RequestBean(list, headersBean, str, str2);
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (!(obj instanceof RequestBean)) {
                                return false;
                            }
                            RequestBean requestBean = (RequestBean) obj;
                            return e4.a(this.path, requestBean.path) && e4.a(this.headers, requestBean.headers) && e4.a(this.version, requestBean.version) && e4.a(this.method, requestBean.method);
                        }

                        public final HeadersBean getHeaders() {
                            return this.headers;
                        }

                        public final String getMethod() {
                            return this.method;
                        }

                        public final List<String> getPath() {
                            return this.path;
                        }

                        public final String getVersion() {
                            return this.version;
                        }

                        public int hashCode() {
                            int iHashCode = (this.headers.hashCode() + (this.path.hashCode() * 31)) * 31;
                            String str = this.version;
                            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                            String str2 = this.method;
                            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
                        }

                        public final void setHeaders(HeadersBean headersBean) {
                            this.headers = headersBean;
                        }

                        public final void setPath(List<String> list) {
                            this.path = list;
                        }

                        public String toString() {
                            StringBuilder sb = new StringBuilder("RequestBean(path=");
                            sb.append(this.path);
                            sb.append(", headers=");
                            sb.append(this.headers);
                            sb.append(", version=");
                            sb.append(this.version);
                            sb.append(", method=");
                            return fb$1.m(sb, this.method, ')');
                        }
                    }

                    public HeaderBean() {
                        this(null, null, null, 7, null);
                    }

                    public HeaderBean(String str, RequestBean requestBean, Object obj) {
                        this.type = str;
                        this.request = requestBean;
                        this.response = obj;
                    }

                    public /* synthetic */ HeaderBean(String str, RequestBean requestBean, Object obj, int i, zk zkVar) {
                        this((i & 1) != 0 ? "none" : str, (i & 2) != 0 ? null : requestBean, (i & 4) != 0 ? null : obj);
                    }

                    public static /* synthetic */ HeaderBean copy$default(HeaderBean headerBean, String str, RequestBean requestBean, Object obj, int i, Object obj2) {
                        if ((i & 1) != 0) {
                            str = headerBean.type;
                        }
                        if ((i & 2) != 0) {
                            requestBean = headerBean.request;
                        }
                        if ((i & 4) != 0) {
                            obj = headerBean.response;
                        }
                        return headerBean.copy(str, requestBean, obj);
                    }

                    public final String component1() {
                        return this.type;
                    }

                    public final RequestBean component2() {
                        return this.request;
                    }

                    public final Object component3() {
                        return this.response;
                    }

                    public final HeaderBean copy(String str, RequestBean requestBean, Object obj) {
                        return new HeaderBean(str, requestBean, obj);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof HeaderBean)) {
                            return false;
                        }
                        HeaderBean headerBean = (HeaderBean) obj;
                        return e4.a(this.type, headerBean.type) && e4.a(this.request, headerBean.request) && e4.a(this.response, headerBean.response);
                    }

                    public final RequestBean getRequest() {
                        return this.request;
                    }

                    public final Object getResponse() {
                        return this.response;
                    }

                    public final String getType() {
                        return this.type;
                    }

                    public int hashCode() {
                        int iHashCode = this.type.hashCode() * 31;
                        RequestBean requestBean = this.request;
                        int iHashCode2 = (iHashCode + (requestBean == null ? 0 : requestBean.hashCode())) * 31;
                        Object obj = this.response;
                        return iHashCode2 + (obj != null ? obj.hashCode() : 0);
                    }

                    public final void setRequest(RequestBean requestBean) {
                        this.request = requestBean;
                    }

                    public final void setResponse(Object obj) {
                        this.response = obj;
                    }

                    public final void setType(String str) {
                        this.type = str;
                    }

                    public String toString() {
                        return "HeaderBean(type=" + this.type + ", request=" + this.request + ", response=" + this.response + ')';
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                public TcpSettingsBean() {
                    this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                }

                public TcpSettingsBean(HeaderBean headerBean, Boolean bool) {
                    this.header = headerBean;
                    this.acceptProxyProtocol = bool;
                }

                public /* synthetic */ TcpSettingsBean(HeaderBean headerBean, Boolean bool, int i, zk zkVar) {
                    if ((i & 1) != 0) {
                        headerBean = new HeaderBean(null, null, null, 7, null);
                    }
                    this(headerBean, (i & 2) != 0 ? null : bool);
                }

                public static /* synthetic */ TcpSettingsBean copy$default(TcpSettingsBean tcpSettingsBean, HeaderBean headerBean, Boolean bool, int i, Object obj) {
                    if ((i & 1) != 0) {
                        headerBean = tcpSettingsBean.header;
                    }
                    if ((i & 2) != 0) {
                        bool = tcpSettingsBean.acceptProxyProtocol;
                    }
                    return tcpSettingsBean.copy(headerBean, bool);
                }

                public final HeaderBean component1() {
                    return this.header;
                }

                public final Boolean component2() {
                    return this.acceptProxyProtocol;
                }

                public final TcpSettingsBean copy(HeaderBean headerBean, Boolean bool) {
                    return new TcpSettingsBean(headerBean, bool);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof TcpSettingsBean)) {
                        return false;
                    }
                    TcpSettingsBean tcpSettingsBean = (TcpSettingsBean) obj;
                    return e4.a(this.header, tcpSettingsBean.header) && e4.a(this.acceptProxyProtocol, tcpSettingsBean.acceptProxyProtocol);
                }

                public final Boolean getAcceptProxyProtocol() {
                    return this.acceptProxyProtocol;
                }

                public final HeaderBean getHeader() {
                    return this.header;
                }

                public int hashCode() {
                    int iHashCode = this.header.hashCode() * 31;
                    Boolean bool = this.acceptProxyProtocol;
                    return iHashCode + (bool == null ? 0 : bool.hashCode());
                }

                public final void setHeader(HeaderBean headerBean) {
                    this.header = headerBean;
                }

                public String toString() {
                    return "TcpSettingsBean(header=" + this.header + ", acceptProxyProtocol=" + this.acceptProxyProtocol + ')';
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class TlsSettingsBean {
                private boolean allowInsecure;
                private final List<String> alpn;
                private final List<Object> certificates;
                private final String cipherSuites;
                private final Boolean disableSystemRoot;
                private final Boolean enableSessionResumption;
                private final String fingerprint;
                private final String maxVersion;
                private final String minVersion;
                private final Boolean preferServerCipherSuites;
                private String publicKey;
                private String serverName;
                private String shortId;
                private final boolean show;
                private String spiderX;

                public TlsSettingsBean() {
                    this(false, null, null, null, null, null, null, null, null, null, null, false, null, null, null, 32767, null);
                }

                public TlsSettingsBean(boolean z, String str, List<String> list, String str2, String str3, Boolean bool, String str4, String str5, List<? extends Object> list2, Boolean bool2, Boolean bool3, boolean z2, String str6, String str7, String str8) {
                    this.allowInsecure = z;
                    this.serverName = str;
                    this.alpn = list;
                    this.minVersion = str2;
                    this.maxVersion = str3;
                    this.preferServerCipherSuites = bool;
                    this.cipherSuites = str4;
                    this.fingerprint = str5;
                    this.certificates = list2;
                    this.disableSystemRoot = bool2;
                    this.enableSessionResumption = bool3;
                    this.show = z2;
                    this.publicKey = str6;
                    this.shortId = str7;
                    this.spiderX = str8;
                }

                public /* synthetic */ TlsSettingsBean(boolean z, String str, List list, String str2, String str3, Boolean bool, String str4, String str5, List list2, Boolean bool2, Boolean bool3, boolean z2, String str6, String str7, String str8, int i, zk zkVar) {
                    this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : list2, (i & 512) != 0 ? null : bool2, (i & 1024) != 0 ? null : bool3, (i & 2048) == 0 ? z2 : false, (i & 4096) != 0 ? null : str6, (i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? null : str7, (i & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) != 0 ? null : str8);
                }

                public final boolean component1() {
                    return this.allowInsecure;
                }

                public final Boolean component10() {
                    return this.disableSystemRoot;
                }

                public final Boolean component11() {
                    return this.enableSessionResumption;
                }

                public final boolean component12() {
                    return this.show;
                }

                public final String component13() {
                    return this.publicKey;
                }

                public final String component14() {
                    return this.shortId;
                }

                public final String component15() {
                    return this.spiderX;
                }

                public final String component2() {
                    return this.serverName;
                }

                public final List<String> component3() {
                    return this.alpn;
                }

                public final String component4() {
                    return this.minVersion;
                }

                public final String component5() {
                    return this.maxVersion;
                }

                public final Boolean component6() {
                    return this.preferServerCipherSuites;
                }

                public final String component7() {
                    return this.cipherSuites;
                }

                public final String component8() {
                    return this.fingerprint;
                }

                public final List<Object> component9() {
                    return this.certificates;
                }

                public final TlsSettingsBean copy(boolean z, String str, List<String> list, String str2, String str3, Boolean bool, String str4, String str5, List<? extends Object> list2, Boolean bool2, Boolean bool3, boolean z2, String str6, String str7, String str8) {
                    return new TlsSettingsBean(z, str, list, str2, str3, bool, str4, str5, list2, bool2, bool3, z2, str6, str7, str8);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof TlsSettingsBean)) {
                        return false;
                    }
                    TlsSettingsBean tlsSettingsBean = (TlsSettingsBean) obj;
                    return this.allowInsecure == tlsSettingsBean.allowInsecure && e4.a(this.serverName, tlsSettingsBean.serverName) && e4.a(this.alpn, tlsSettingsBean.alpn) && e4.a(this.minVersion, tlsSettingsBean.minVersion) && e4.a(this.maxVersion, tlsSettingsBean.maxVersion) && e4.a(this.preferServerCipherSuites, tlsSettingsBean.preferServerCipherSuites) && e4.a(this.cipherSuites, tlsSettingsBean.cipherSuites) && e4.a(this.fingerprint, tlsSettingsBean.fingerprint) && e4.a(this.certificates, tlsSettingsBean.certificates) && e4.a(this.disableSystemRoot, tlsSettingsBean.disableSystemRoot) && e4.a(this.enableSessionResumption, tlsSettingsBean.enableSessionResumption) && this.show == tlsSettingsBean.show && e4.a(this.publicKey, tlsSettingsBean.publicKey) && e4.a(this.shortId, tlsSettingsBean.shortId) && e4.a(this.spiderX, tlsSettingsBean.spiderX);
                }

                public final boolean getAllowInsecure() {
                    return this.allowInsecure;
                }

                public final List<String> getAlpn() {
                    return this.alpn;
                }

                public final List<Object> getCertificates() {
                    return this.certificates;
                }

                public final String getCipherSuites() {
                    return this.cipherSuites;
                }

                public final Boolean getDisableSystemRoot() {
                    return this.disableSystemRoot;
                }

                public final Boolean getEnableSessionResumption() {
                    return this.enableSessionResumption;
                }

                public final String getFingerprint() {
                    return this.fingerprint;
                }

                public final String getMaxVersion() {
                    return this.maxVersion;
                }

                public final String getMinVersion() {
                    return this.minVersion;
                }

                public final Boolean getPreferServerCipherSuites() {
                    return this.preferServerCipherSuites;
                }

                public final String getPublicKey() {
                    return this.publicKey;
                }

                public final String getServerName() {
                    return this.serverName;
                }

                public final String getShortId() {
                    return this.shortId;
                }

                public final boolean getShow() {
                    return this.show;
                }

                public final String getSpiderX() {
                    return this.spiderX;
                }

                public int hashCode() {
                    int i = (this.allowInsecure ? 1231 : 1237) * 31;
                    String str = this.serverName;
                    int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
                    List<String> list = this.alpn;
                    int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
                    String str2 = this.minVersion;
                    int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                    String str3 = this.maxVersion;
                    int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                    Boolean bool = this.preferServerCipherSuites;
                    int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
                    String str4 = this.cipherSuites;
                    int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
                    String str5 = this.fingerprint;
                    int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
                    List<Object> list2 = this.certificates;
                    int iHashCode8 = (iHashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
                    Boolean bool2 = this.disableSystemRoot;
                    int iHashCode9 = (iHashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
                    Boolean bool3 = this.enableSessionResumption;
                    int iHashCode10 = (((iHashCode9 + (bool3 == null ? 0 : bool3.hashCode())) * 31) + (this.show ? 1231 : 1237)) * 31;
                    String str6 = this.publicKey;
                    int iHashCode11 = (iHashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
                    String str7 = this.shortId;
                    int iHashCode12 = (iHashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
                    String str8 = this.spiderX;
                    return iHashCode12 + (str8 != null ? str8.hashCode() : 0);
                }

                public final void setAllowInsecure(boolean z) {
                    this.allowInsecure = z;
                }

                public final void setPublicKey(String str) {
                    this.publicKey = str;
                }

                public final void setServerName(String str) {
                    this.serverName = str;
                }

                public final void setShortId(String str) {
                    this.shortId = str;
                }

                public final void setSpiderX(String str) {
                    this.spiderX = str;
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder("TlsSettingsBean(allowInsecure=");
                    sb.append(this.allowInsecure);
                    sb.append(", serverName=");
                    sb.append(this.serverName);
                    sb.append(", alpn=");
                    sb.append(this.alpn);
                    sb.append(", minVersion=");
                    sb.append(this.minVersion);
                    sb.append(", maxVersion=");
                    sb.append(this.maxVersion);
                    sb.append(", preferServerCipherSuites=");
                    sb.append(this.preferServerCipherSuites);
                    sb.append(", cipherSuites=");
                    sb.append(this.cipherSuites);
                    sb.append(", fingerprint=");
                    sb.append(this.fingerprint);
                    sb.append(", certificates=");
                    sb.append(this.certificates);
                    sb.append(", disableSystemRoot=");
                    sb.append(this.disableSystemRoot);
                    sb.append(", enableSessionResumption=");
                    sb.append(this.enableSessionResumption);
                    sb.append(", show=");
                    sb.append(this.show);
                    sb.append(", publicKey=");
                    sb.append(this.publicKey);
                    sb.append(", shortId=");
                    sb.append(this.shortId);
                    sb.append(", spiderX=");
                    return fb$1.m(sb, this.spiderX, ')');
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class WsSettingsBean {
                private final Boolean acceptProxyProtocol;
                private HeadersBean headers;
                private final Integer maxEarlyData;
                private String path;
                private final Boolean useBrowserForwarding;

                /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
                public static final class HeadersBean {
                    private String Host;

                    /* JADX WARN: Multi-variable type inference failed */
                    public HeadersBean() {
                        this(null, 1, 0 == true ? 1 : 0);
                    }

                    public HeadersBean(String str) {
                        this.Host = str;
                    }

                    public /* synthetic */ HeadersBean(String str, int i, zk zkVar) {
                        this((i & 1) != 0 ? AppConfig.CUSTOM : str);
                    }

                    public static /* synthetic */ HeadersBean copy$default(HeadersBean headersBean, String str, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = headersBean.Host;
                        }
                        return headersBean.copy(str);
                    }

                    public final String component1() {
                        return this.Host;
                    }

                    public final HeadersBean copy(String str) {
                        return new HeadersBean(str);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof HeadersBean) && e4.a(this.Host, ((HeadersBean) obj).Host);
                    }

                    public final String getHost() {
                        return this.Host;
                    }

                    public int hashCode() {
                        return this.Host.hashCode();
                    }

                    public final void setHost(String str) {
                        this.Host = str;
                    }

                    public String toString() {
                        return fb$1.m(new StringBuilder("HeadersBean(Host="), this.Host, ')');
                    }
                }

                public WsSettingsBean() {
                    this(null, null, null, null, null, 31, null);
                }

                public WsSettingsBean(String str, HeadersBean headersBean, Integer num, Boolean bool, Boolean bool2) {
                    this.path = str;
                    this.headers = headersBean;
                    this.maxEarlyData = num;
                    this.useBrowserForwarding = bool;
                    this.acceptProxyProtocol = bool2;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public /* synthetic */ WsSettingsBean(String str, HeadersBean headersBean, Integer num, Boolean bool, Boolean bool2, int i, zk zkVar) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? new HeadersBean(null, 1, 0 == true ? 1 : 0) : headersBean, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2);
                }

                public static /* synthetic */ WsSettingsBean copy$default(WsSettingsBean wsSettingsBean, String str, HeadersBean headersBean, Integer num, Boolean bool, Boolean bool2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = wsSettingsBean.path;
                    }
                    if ((i & 2) != 0) {
                        headersBean = wsSettingsBean.headers;
                    }
                    if ((i & 4) != 0) {
                        num = wsSettingsBean.maxEarlyData;
                    }
                    if ((i & 8) != 0) {
                        bool = wsSettingsBean.useBrowserForwarding;
                    }
                    if ((i & 16) != 0) {
                        bool2 = wsSettingsBean.acceptProxyProtocol;
                    }
                    Boolean bool3 = bool2;
                    Integer num2 = num;
                    return wsSettingsBean.copy(str, headersBean, num2, bool, bool3);
                }

                public final String component1() {
                    return this.path;
                }

                public final HeadersBean component2() {
                    return this.headers;
                }

                public final Integer component3() {
                    return this.maxEarlyData;
                }

                public final Boolean component4() {
                    return this.useBrowserForwarding;
                }

                public final Boolean component5() {
                    return this.acceptProxyProtocol;
                }

                public final WsSettingsBean copy(String str, HeadersBean headersBean, Integer num, Boolean bool, Boolean bool2) {
                    return new WsSettingsBean(str, headersBean, num, bool, bool2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof WsSettingsBean)) {
                        return false;
                    }
                    WsSettingsBean wsSettingsBean = (WsSettingsBean) obj;
                    return e4.a(this.path, wsSettingsBean.path) && e4.a(this.headers, wsSettingsBean.headers) && e4.a(this.maxEarlyData, wsSettingsBean.maxEarlyData) && e4.a(this.useBrowserForwarding, wsSettingsBean.useBrowserForwarding) && e4.a(this.acceptProxyProtocol, wsSettingsBean.acceptProxyProtocol);
                }

                public final Boolean getAcceptProxyProtocol() {
                    return this.acceptProxyProtocol;
                }

                public final HeadersBean getHeaders() {
                    return this.headers;
                }

                public final Integer getMaxEarlyData() {
                    return this.maxEarlyData;
                }

                public final String getPath() {
                    return this.path;
                }

                public final Boolean getUseBrowserForwarding() {
                    return this.useBrowserForwarding;
                }

                public int hashCode() {
                    String str = this.path;
                    int iHashCode = (this.headers.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31;
                    Integer num = this.maxEarlyData;
                    int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
                    Boolean bool = this.useBrowserForwarding;
                    int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
                    Boolean bool2 = this.acceptProxyProtocol;
                    return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
                }

                public final void setHeaders(HeadersBean headersBean) {
                    this.headers = headersBean;
                }

                public final void setPath(String str) {
                    this.path = str;
                }

                public String toString() {
                    return "WsSettingsBean(path=" + this.path + ", headers=" + this.headers + ", maxEarlyData=" + this.maxEarlyData + ", useBrowserForwarding=" + this.useBrowserForwarding + ", acceptProxyProtocol=" + this.acceptProxyProtocol + ')';
                }
            }

            /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
            public static final class XhttpSettingsBean {
                private Object extra;
                private String host;
                private String mode;
                private String path;

                public XhttpSettingsBean() {
                    this(null, null, null, null, 15, null);
                }

                public XhttpSettingsBean(String str, String str2, String str3, Object obj) {
                    this.path = str;
                    this.host = str2;
                    this.mode = str3;
                    this.extra = obj;
                }

                public /* synthetic */ XhttpSettingsBean(String str, String str2, String str3, Object obj, int i, zk zkVar) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : obj);
                }

                public static /* synthetic */ XhttpSettingsBean copy$default(XhttpSettingsBean xhttpSettingsBean, String str, String str2, String str3, Object obj, int i, Object obj2) {
                    if ((i & 1) != 0) {
                        str = xhttpSettingsBean.path;
                    }
                    if ((i & 2) != 0) {
                        str2 = xhttpSettingsBean.host;
                    }
                    if ((i & 4) != 0) {
                        str3 = xhttpSettingsBean.mode;
                    }
                    if ((i & 8) != 0) {
                        obj = xhttpSettingsBean.extra;
                    }
                    return xhttpSettingsBean.copy(str, str2, str3, obj);
                }

                public final String component1() {
                    return this.path;
                }

                public final String component2() {
                    return this.host;
                }

                public final String component3() {
                    return this.mode;
                }

                public final Object component4() {
                    return this.extra;
                }

                public final XhttpSettingsBean copy(String str, String str2, String str3, Object obj) {
                    return new XhttpSettingsBean(str, str2, str3, obj);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof XhttpSettingsBean)) {
                        return false;
                    }
                    XhttpSettingsBean xhttpSettingsBean = (XhttpSettingsBean) obj;
                    return e4.a(this.path, xhttpSettingsBean.path) && e4.a(this.host, xhttpSettingsBean.host) && e4.a(this.mode, xhttpSettingsBean.mode) && e4.a(this.extra, xhttpSettingsBean.extra);
                }

                public final Object getExtra() {
                    return this.extra;
                }

                public final String getHost() {
                    return this.host;
                }

                public final String getMode() {
                    return this.mode;
                }

                public final String getPath() {
                    return this.path;
                }

                public int hashCode() {
                    String str = this.path;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.host;
                    int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    String str3 = this.mode;
                    int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                    Object obj = this.extra;
                    return iHashCode3 + (obj != null ? obj.hashCode() : 0);
                }

                public final void setExtra(Object obj) {
                    this.extra = obj;
                }

                public final void setHost(String str) {
                    this.host = str;
                }

                public final void setMode(String str) {
                    this.mode = str;
                }

                public final void setPath(String str) {
                    this.path = str;
                }

                public String toString() {
                    return "XhttpSettingsBean(path=" + this.path + ", host=" + this.host + ", mode=" + this.mode + ", extra=" + this.extra + ')';
                }
            }

            public StreamSettingsBean() {
                this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
            }

            public StreamSettingsBean(String str, String str2, TcpSettingsBean tcpSettingsBean, KcpSettingsBean kcpSettingsBean, WsSettingsBean wsSettingsBean, HttpupgradeSettingsBean httpupgradeSettingsBean, SplithttpSettingsBean splithttpSettingsBean, XhttpSettingsBean xhttpSettingsBean, HttpSettingsBean httpSettingsBean, TlsSettingsBean tlsSettingsBean, QuicSettingBean quicSettingBean, TlsSettingsBean tlsSettingsBean2, GrpcSettingsBean grpcSettingsBean, Hy2steriaSettingsBean hy2steriaSettingsBean, Object obj, SockoptBean sockoptBean) {
                this.network = str;
                this.security = str2;
                this.tcpSettings = tcpSettingsBean;
                this.kcpSettings = kcpSettingsBean;
                this.wsSettings = wsSettingsBean;
                this.httpupgradeSettings = httpupgradeSettingsBean;
                this.splithttpSettings = splithttpSettingsBean;
                this.xhttpSettings = xhttpSettingsBean;
                this.httpSettings = httpSettingsBean;
                this.tlsSettings = tlsSettingsBean;
                this.quicSettings = quicSettingBean;
                this.realitySettings = tlsSettingsBean2;
                this.grpcSettings = grpcSettingsBean;
                this.hy2steriaSettings = hy2steriaSettingsBean;
                this.dsSettings = obj;
                this.sockopt = sockoptBean;
            }

            public /* synthetic */ StreamSettingsBean(String str, String str2, TcpSettingsBean tcpSettingsBean, KcpSettingsBean kcpSettingsBean, WsSettingsBean wsSettingsBean, HttpupgradeSettingsBean httpupgradeSettingsBean, SplithttpSettingsBean splithttpSettingsBean, XhttpSettingsBean xhttpSettingsBean, HttpSettingsBean httpSettingsBean, TlsSettingsBean tlsSettingsBean, QuicSettingBean quicSettingBean, TlsSettingsBean tlsSettingsBean2, GrpcSettingsBean grpcSettingsBean, Hy2steriaSettingsBean hy2steriaSettingsBean, Object obj, SockoptBean sockoptBean, int i, zk zkVar) {
                this((i & 1) != 0 ? AppConfig.DEFAULT_NETWORK : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : tcpSettingsBean, (i & 8) != 0 ? null : kcpSettingsBean, (i & 16) != 0 ? null : wsSettingsBean, (i & 32) != 0 ? null : httpupgradeSettingsBean, (i & 64) != 0 ? null : splithttpSettingsBean, (i & 128) != 0 ? null : xhttpSettingsBean, (i & 256) != 0 ? null : httpSettingsBean, (i & 512) != 0 ? null : tlsSettingsBean, (i & 1024) != 0 ? null : quicSettingBean, (i & 2048) != 0 ? null : tlsSettingsBean2, (i & 4096) != 0 ? null : grpcSettingsBean, (i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? null : hy2steriaSettingsBean, (i & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) != 0 ? null : obj, (i & AttribFlags.SSH_FILEXFER_ATTR_CTIME) != 0 ? null : sockoptBean);
            }

            public final String component1() {
                return this.network;
            }

            public final TlsSettingsBean component10() {
                return this.tlsSettings;
            }

            public final QuicSettingBean component11() {
                return this.quicSettings;
            }

            public final TlsSettingsBean component12() {
                return this.realitySettings;
            }

            public final GrpcSettingsBean component13() {
                return this.grpcSettings;
            }

            public final Hy2steriaSettingsBean component14() {
                return this.hy2steriaSettings;
            }

            public final Object component15() {
                return this.dsSettings;
            }

            public final SockoptBean component16() {
                return this.sockopt;
            }

            public final String component2() {
                return this.security;
            }

            public final TcpSettingsBean component3() {
                return this.tcpSettings;
            }

            public final KcpSettingsBean component4() {
                return this.kcpSettings;
            }

            public final WsSettingsBean component5() {
                return this.wsSettings;
            }

            public final HttpupgradeSettingsBean component6() {
                return this.httpupgradeSettings;
            }

            public final SplithttpSettingsBean component7() {
                return this.splithttpSettings;
            }

            public final XhttpSettingsBean component8() {
                return this.xhttpSettings;
            }

            public final HttpSettingsBean component9() {
                return this.httpSettings;
            }

            public final StreamSettingsBean copy(String str, String str2, TcpSettingsBean tcpSettingsBean, KcpSettingsBean kcpSettingsBean, WsSettingsBean wsSettingsBean, HttpupgradeSettingsBean httpupgradeSettingsBean, SplithttpSettingsBean splithttpSettingsBean, XhttpSettingsBean xhttpSettingsBean, HttpSettingsBean httpSettingsBean, TlsSettingsBean tlsSettingsBean, QuicSettingBean quicSettingBean, TlsSettingsBean tlsSettingsBean2, GrpcSettingsBean grpcSettingsBean, Hy2steriaSettingsBean hy2steriaSettingsBean, Object obj, SockoptBean sockoptBean) {
                return new StreamSettingsBean(str, str2, tcpSettingsBean, kcpSettingsBean, wsSettingsBean, httpupgradeSettingsBean, splithttpSettingsBean, xhttpSettingsBean, httpSettingsBean, tlsSettingsBean, quicSettingBean, tlsSettingsBean2, grpcSettingsBean, hy2steriaSettingsBean, obj, sockoptBean);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof StreamSettingsBean)) {
                    return false;
                }
                StreamSettingsBean streamSettingsBean = (StreamSettingsBean) obj;
                return e4.a(this.network, streamSettingsBean.network) && e4.a(this.security, streamSettingsBean.security) && e4.a(this.tcpSettings, streamSettingsBean.tcpSettings) && e4.a(this.kcpSettings, streamSettingsBean.kcpSettings) && e4.a(this.wsSettings, streamSettingsBean.wsSettings) && e4.a(this.httpupgradeSettings, streamSettingsBean.httpupgradeSettings) && e4.a(this.splithttpSettings, streamSettingsBean.splithttpSettings) && e4.a(this.xhttpSettings, streamSettingsBean.xhttpSettings) && e4.a(this.httpSettings, streamSettingsBean.httpSettings) && e4.a(this.tlsSettings, streamSettingsBean.tlsSettings) && e4.a(this.quicSettings, streamSettingsBean.quicSettings) && e4.a(this.realitySettings, streamSettingsBean.realitySettings) && e4.a(this.grpcSettings, streamSettingsBean.grpcSettings) && e4.a(this.hy2steriaSettings, streamSettingsBean.hy2steriaSettings) && e4.a(this.dsSettings, streamSettingsBean.dsSettings) && e4.a(this.sockopt, streamSettingsBean.sockopt);
            }

            public final Object getDsSettings() {
                return this.dsSettings;
            }

            public final GrpcSettingsBean getGrpcSettings() {
                return this.grpcSettings;
            }

            public final HttpSettingsBean getHttpSettings() {
                return this.httpSettings;
            }

            public final HttpupgradeSettingsBean getHttpupgradeSettings() {
                return this.httpupgradeSettings;
            }

            public final Hy2steriaSettingsBean getHy2steriaSettings() {
                return this.hy2steriaSettings;
            }

            public final KcpSettingsBean getKcpSettings() {
                return this.kcpSettings;
            }

            public final String getNetwork() {
                return this.network;
            }

            public final QuicSettingBean getQuicSettings() {
                return this.quicSettings;
            }

            public final TlsSettingsBean getRealitySettings() {
                return this.realitySettings;
            }

            public final String getSecurity() {
                return this.security;
            }

            public final SockoptBean getSockopt() {
                return this.sockopt;
            }

            public final SplithttpSettingsBean getSplithttpSettings() {
                return this.splithttpSettings;
            }

            public final TcpSettingsBean getTcpSettings() {
                return this.tcpSettings;
            }

            public final TlsSettingsBean getTlsSettings() {
                return this.tlsSettings;
            }

            public final WsSettingsBean getWsSettings() {
                return this.wsSettings;
            }

            public final XhttpSettingsBean getXhttpSettings() {
                return this.xhttpSettings;
            }

            public int hashCode() {
                int iHashCode = this.network.hashCode() * 31;
                String str = this.security;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                TcpSettingsBean tcpSettingsBean = this.tcpSettings;
                int iHashCode3 = (iHashCode2 + (tcpSettingsBean == null ? 0 : tcpSettingsBean.hashCode())) * 31;
                KcpSettingsBean kcpSettingsBean = this.kcpSettings;
                int iHashCode4 = (iHashCode3 + (kcpSettingsBean == null ? 0 : kcpSettingsBean.hashCode())) * 31;
                WsSettingsBean wsSettingsBean = this.wsSettings;
                int iHashCode5 = (iHashCode4 + (wsSettingsBean == null ? 0 : wsSettingsBean.hashCode())) * 31;
                HttpupgradeSettingsBean httpupgradeSettingsBean = this.httpupgradeSettings;
                int iHashCode6 = (iHashCode5 + (httpupgradeSettingsBean == null ? 0 : httpupgradeSettingsBean.hashCode())) * 31;
                SplithttpSettingsBean splithttpSettingsBean = this.splithttpSettings;
                int iHashCode7 = (iHashCode6 + (splithttpSettingsBean == null ? 0 : splithttpSettingsBean.hashCode())) * 31;
                XhttpSettingsBean xhttpSettingsBean = this.xhttpSettings;
                int iHashCode8 = (iHashCode7 + (xhttpSettingsBean == null ? 0 : xhttpSettingsBean.hashCode())) * 31;
                HttpSettingsBean httpSettingsBean = this.httpSettings;
                int iHashCode9 = (iHashCode8 + (httpSettingsBean == null ? 0 : httpSettingsBean.hashCode())) * 31;
                TlsSettingsBean tlsSettingsBean = this.tlsSettings;
                int iHashCode10 = (iHashCode9 + (tlsSettingsBean == null ? 0 : tlsSettingsBean.hashCode())) * 31;
                QuicSettingBean quicSettingBean = this.quicSettings;
                int iHashCode11 = (iHashCode10 + (quicSettingBean == null ? 0 : quicSettingBean.hashCode())) * 31;
                TlsSettingsBean tlsSettingsBean2 = this.realitySettings;
                int iHashCode12 = (iHashCode11 + (tlsSettingsBean2 == null ? 0 : tlsSettingsBean2.hashCode())) * 31;
                GrpcSettingsBean grpcSettingsBean = this.grpcSettings;
                int iHashCode13 = (iHashCode12 + (grpcSettingsBean == null ? 0 : grpcSettingsBean.hashCode())) * 31;
                Hy2steriaSettingsBean hy2steriaSettingsBean = this.hy2steriaSettings;
                int iHashCode14 = (iHashCode13 + (hy2steriaSettingsBean == null ? 0 : hy2steriaSettingsBean.hashCode())) * 31;
                Object obj = this.dsSettings;
                int iHashCode15 = (iHashCode14 + (obj == null ? 0 : obj.hashCode())) * 31;
                SockoptBean sockoptBean = this.sockopt;
                return iHashCode15 + (sockoptBean != null ? sockoptBean.hashCode() : 0);
            }

            public final void populateTlsSettings(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
                ArrayList arrayList;
                String str8 = str.length() == 0 ? null : str;
                this.security = str8;
                if (str8 == null) {
                    return;
                }
                String str9 = (str2 == null || str2.length() == 0) ? null : str2;
                String str10 = (str3 == null || str3.length() == 0) ? null : str3;
                if (str4 == null || str4.length() == 0) {
                    arrayList = null;
                } else {
                    List listS0 = q31.s0(str4, new String[]{","}, 6);
                    ArrayList arrayList2 = new ArrayList(ae.y0(listS0));
                    Iterator it = listS0.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(q31.C0((String) it.next()).toString());
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : arrayList2) {
                        if (((String) obj).length() > 0) {
                            arrayList3.add(obj);
                        }
                    }
                    arrayList = arrayList3;
                }
                TlsSettingsBean tlsSettingsBean = new TlsSettingsBean(z, str9, arrayList, null, null, null, null, str10, null, null, null, false, (str5 == null || str5.length() == 0) ? null : str5, (str6 == null || str6.length() == 0) ? null : str6, (str7 == null || str7.length() == 0) ? null : str7, 3960, null);
                if (e4.a(this.security, AppConfig.TLS)) {
                    this.tlsSettings = tlsSettingsBean;
                    this.realitySettings = null;
                } else if (e4.a(this.security, AppConfig.REALITY)) {
                    this.tlsSettings = null;
                    this.realitySettings = tlsSettingsBean;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Boolean, java.lang.String, java.util.List, renz.javacodez.v2ray.dto.V2rayConfig$OutboundBean$StreamSettingsBean$TcpSettingsBean$HeaderBean, zk] */
            /* JADX WARN: Type inference failed for: r11v1 */
            /* JADX WARN: Type inference failed for: r11v3 */
            /* JADX WARN: Type inference failed for: r11v4 */
            public final String populateTransportSettings(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
                String type = str.length() == 0 ? NetworkType.TCP.getType() : str;
                this.network = type;
                boolean zA = e4.a(type, NetworkType.TCP.getType());
                int i = 3;
                String str11 = AppConfig.CUSTOM;
                String str12 = 0;
                str12 = 0;
                if (zA) {
                    TcpSettingsBean tcpSettingsBean = new TcpSettingsBean(str12, str12, i, str12);
                    if (e4.a(str2, AppConfig.HEADER_TYPE_HTTP)) {
                        tcpSettingsBean.getHeader().setType(AppConfig.HEADER_TYPE_HTTP);
                        if (!TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str4)) {
                            TcpSettingsBean.HeaderBean.RequestBean requestBean = new TcpSettingsBean.HeaderBean.RequestBean(null, null, null, null, 15, null);
                            TcpSettingsBean.HeaderBean.RequestBean.HeadersBean headers = requestBean.getHeaders();
                            List listS0 = q31.s0(str3 == null ? AppConfig.CUSTOM : str3, new String[]{","}, 6);
                            ArrayList arrayList = new ArrayList(ae.y0(listS0));
                            Iterator it = listS0.iterator();
                            while (it.hasNext()) {
                                arrayList.add(q31.C0((String) it.next()).toString());
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj : arrayList) {
                                if (((String) obj).length() > 0) {
                                    arrayList2.add(obj);
                                }
                            }
                            headers.setHost(arrayList2);
                            if (str4 != null) {
                                str11 = str4;
                            }
                            List listS1 = q31.s0(str11, new String[]{","}, 6);
                            ArrayList arrayList3 = new ArrayList(ae.y0(listS1));
                            Iterator it2 = listS1.iterator();
                            while (it2.hasNext()) {
                                arrayList3.add(q31.C0((String) it2.next()).toString());
                            }
                            ArrayList arrayList4 = new ArrayList();
                            for (Object obj2 : arrayList3) {
                                if (((String) obj2).length() > 0) {
                                    arrayList4.add(obj2);
                                }
                            }
                            requestBean.setPath(arrayList4);
                            tcpSettingsBean.getHeader().setRequest(requestBean);
                            List<String> host = requestBean.getHeaders().getHost();
                            if (host != null) {
                                str12 = (String) he.N0(host, 0);
                            }
                        }
                    } else {
                        tcpSettingsBean.getHeader().setType("none");
                        str12 = str3;
                    }
                    this.tcpSettings = tcpSettingsBean;
                    return str12;
                }
                if (e4.a(type, NetworkType.KCP.getType())) {
                    KcpSettingsBean kcpSettingsBean = new KcpSettingsBean(0, 0, 0, 0, false, 0, 0, null, null, 511, null);
                    kcpSettingsBean.getHeader().setType(str2 != null ? str2 : "none");
                    if (str5 == null || str5.length() == 0) {
                        kcpSettingsBean.setSeed(null);
                    } else {
                        kcpSettingsBean.setSeed(str5);
                    }
                    this.kcpSettings = kcpSettingsBean;
                    return null;
                }
                boolean zA2 = e4.a(type, NetworkType.WS.getType());
                String str13 = InternalZipConstants.ZIP_FILE_SEPARATOR;
                if (zA2) {
                    WsSettingsBean wsSettingsBean = new WsSettingsBean(null, null, null, null, null, 31, null);
                    WsSettingsBean.HeadersBean headers2 = wsSettingsBean.getHeaders();
                    if (str3 != null) {
                        str11 = str3;
                    }
                    headers2.setHost(str11);
                    if (str4 != null) {
                        str13 = str4;
                    }
                    wsSettingsBean.setPath(str13);
                    this.wsSettings = wsSettingsBean;
                    return str3;
                }
                if (e4.a(type, NetworkType.HTTP_UPGRADE.getType())) {
                    HttpupgradeSettingsBean httpupgradeSettingsBean = new HttpupgradeSettingsBean(null, null, null, 7, null);
                    if (str3 != null) {
                        str11 = str3;
                    }
                    httpupgradeSettingsBean.setHost(str11);
                    if (str4 != null) {
                        str13 = str4;
                    }
                    httpupgradeSettingsBean.setPath(str13);
                    this.httpupgradeSettings = httpupgradeSettingsBean;
                    return str3;
                }
                if (e4.a(type, NetworkType.SPLIT_HTTP.getType())) {
                    SplithttpSettingsBean splithttpSettingsBean = new SplithttpSettingsBean(null, null, null, null, 15, null);
                    if (str3 != null) {
                        str11 = str3;
                    }
                    splithttpSettingsBean.setHost(str11);
                    String host2 = splithttpSettingsBean.getHost();
                    if (str4 != null) {
                        str13 = str4;
                    }
                    splithttpSettingsBean.setPath(str13);
                    this.splithttpSettings = splithttpSettingsBean;
                    return host2;
                }
                if (e4.a(type, NetworkType.XHTTP.getType())) {
                    XhttpSettingsBean xhttpSettingsBean = new XhttpSettingsBean(null, null, null, null, 15, null);
                    if (str3 != null) {
                        str11 = str3;
                    }
                    xhttpSettingsBean.setHost(str11);
                    if (str4 != null) {
                        str13 = str4;
                    }
                    xhttpSettingsBean.setPath(str13);
                    this.xhttpSettings = xhttpSettingsBean;
                    return str3;
                }
                NetworkType networkType = NetworkType.H2;
                if (!e4.a(type, networkType.getType()) && !e4.a(type, NetworkType.HTTP.getType())) {
                    if (!e4.a(type, NetworkType.GRPC.getType())) {
                        return null;
                    }
                    GrpcSettingsBean grpcSettingsBean = new GrpcSettingsBean(null, null, null, null, null, 31, null);
                    grpcSettingsBean.setMultiMode(Boolean.valueOf(e4.a(str8, "multi")));
                    grpcSettingsBean.setServiceName(str9 == null ? AppConfig.CUSTOM : str9);
                    if (str10 != null) {
                        str11 = str10;
                    }
                    grpcSettingsBean.setAuthority(str11);
                    grpcSettingsBean.setIdle_timeout(60);
                    grpcSettingsBean.setHealth_check_timeout(20);
                    this.grpcSettings = grpcSettingsBean;
                    return str10;
                }
                this.network = networkType.getType();
                HttpSettingsBean httpSettingsBean = new HttpSettingsBean(str12, str12, i, str12);
                if (str3 != null) {
                    str11 = str3;
                }
                List listS2 = q31.s0(str11, new String[]{","}, 6);
                ArrayList arrayList5 = new ArrayList(ae.y0(listS2));
                Iterator it3 = listS2.iterator();
                while (it3.hasNext()) {
                    arrayList5.add(q31.C0((String) it3.next()).toString());
                }
                ArrayList arrayList6 = new ArrayList();
                for (Object obj3 : arrayList5) {
                    if (((String) obj3).length() > 0) {
                        arrayList6.add(obj3);
                    }
                }
                httpSettingsBean.setHost(arrayList6);
                String str14 = (String) he.N0(httpSettingsBean.getHost(), 0);
                if (str4 != null) {
                    str13 = str4;
                }
                httpSettingsBean.setPath(str13);
                this.httpSettings = httpSettingsBean;
                return str14;
            }

            public final void setGrpcSettings(GrpcSettingsBean grpcSettingsBean) {
                this.grpcSettings = grpcSettingsBean;
            }

            public final void setHttpSettings(HttpSettingsBean httpSettingsBean) {
                this.httpSettings = httpSettingsBean;
            }

            public final void setHttpupgradeSettings(HttpupgradeSettingsBean httpupgradeSettingsBean) {
                this.httpupgradeSettings = httpupgradeSettingsBean;
            }

            public final void setHy2steriaSettings(Hy2steriaSettingsBean hy2steriaSettingsBean) {
                this.hy2steriaSettings = hy2steriaSettingsBean;
            }

            public final void setKcpSettings(KcpSettingsBean kcpSettingsBean) {
                this.kcpSettings = kcpSettingsBean;
            }

            public final void setNetwork(String str) {
                this.network = str;
            }

            public final void setQuicSettings(QuicSettingBean quicSettingBean) {
                this.quicSettings = quicSettingBean;
            }

            public final void setRealitySettings(TlsSettingsBean tlsSettingsBean) {
                this.realitySettings = tlsSettingsBean;
            }

            public final void setSecurity(String str) {
                this.security = str;
            }

            public final void setSockopt(SockoptBean sockoptBean) {
                this.sockopt = sockoptBean;
            }

            public final void setSplithttpSettings(SplithttpSettingsBean splithttpSettingsBean) {
                this.splithttpSettings = splithttpSettingsBean;
            }

            public final void setTcpSettings(TcpSettingsBean tcpSettingsBean) {
                this.tcpSettings = tcpSettingsBean;
            }

            public final void setTlsSettings(TlsSettingsBean tlsSettingsBean) {
                this.tlsSettings = tlsSettingsBean;
            }

            public final void setWsSettings(WsSettingsBean wsSettingsBean) {
                this.wsSettings = wsSettingsBean;
            }

            public final void setXhttpSettings(XhttpSettingsBean xhttpSettingsBean) {
                this.xhttpSettings = xhttpSettingsBean;
            }

            public String toString() {
                return "StreamSettingsBean(network=" + this.network + ", security=" + this.security + ", tcpSettings=" + this.tcpSettings + ", kcpSettings=" + this.kcpSettings + ", wsSettings=" + this.wsSettings + ", httpupgradeSettings=" + this.httpupgradeSettings + ", splithttpSettings=" + this.splithttpSettings + ", xhttpSettings=" + this.xhttpSettings + ", httpSettings=" + this.httpSettings + ", tlsSettings=" + this.tlsSettings + ", quicSettings=" + this.quicSettings + ", realitySettings=" + this.realitySettings + ", grpcSettings=" + this.grpcSettings + ", hy2steriaSettings=" + this.hy2steriaSettings + ", dsSettings=" + this.dsSettings + ", sockopt=" + this.sockopt + ')';
            }
        }

        public OutboundBean(String str, String str2, OutSettingsBean outSettingsBean, StreamSettingsBean streamSettingsBean, Object obj, String str3, MuxBean muxBean) {
            this.tag = str;
            this.protocol = str2;
            this.settings = outSettingsBean;
            this.streamSettings = streamSettingsBean;
            this.proxySettings = obj;
            this.sendThrough = str3;
            this.mux = muxBean;
        }

        public /* synthetic */ OutboundBean(String str, String str2, OutSettingsBean outSettingsBean, StreamSettingsBean streamSettingsBean, Object obj, String str3, MuxBean muxBean, int i, zk zkVar) {
            this((i & 1) != 0 ? AppConfig.TAG_PROXY : str, str2, (i & 4) != 0 ? null : outSettingsBean, (i & 8) != 0 ? null : streamSettingsBean, (i & 16) != 0 ? null : obj, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? new MuxBean(false, 0, 0, null, 14, null) : muxBean);
        }

        public static /* synthetic */ OutboundBean copy$default(OutboundBean outboundBean, String str, String str2, OutSettingsBean outSettingsBean, StreamSettingsBean streamSettingsBean, Object obj, String str3, MuxBean muxBean, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = outboundBean.tag;
            }
            if ((i & 2) != 0) {
                str2 = outboundBean.protocol;
            }
            if ((i & 4) != 0) {
                outSettingsBean = outboundBean.settings;
            }
            if ((i & 8) != 0) {
                streamSettingsBean = outboundBean.streamSettings;
            }
            if ((i & 16) != 0) {
                obj = outboundBean.proxySettings;
            }
            if ((i & 32) != 0) {
                str3 = outboundBean.sendThrough;
            }
            if ((i & 64) != 0) {
                muxBean = outboundBean.mux;
            }
            String str4 = str3;
            MuxBean muxBean2 = muxBean;
            Object obj3 = obj;
            OutSettingsBean outSettingsBean2 = outSettingsBean;
            return outboundBean.copy(str, str2, outSettingsBean2, streamSettingsBean, obj3, str4, muxBean2);
        }

        public final String component1() {
            return this.tag;
        }

        public final String component2() {
            return this.protocol;
        }

        public final OutSettingsBean component3() {
            return this.settings;
        }

        public final StreamSettingsBean component4() {
            return this.streamSettings;
        }

        public final Object component5() {
            return this.proxySettings;
        }

        public final String component6() {
            return this.sendThrough;
        }

        public final MuxBean component7() {
            return this.mux;
        }

        public final OutboundBean copy(String str, String str2, OutSettingsBean outSettingsBean, StreamSettingsBean streamSettingsBean, Object obj, String str3, MuxBean muxBean) {
            return new OutboundBean(str, str2, outSettingsBean, streamSettingsBean, obj, str3, muxBean);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OutboundBean)) {
                return false;
            }
            OutboundBean outboundBean = (OutboundBean) obj;
            return e4.a(this.tag, outboundBean.tag) && e4.a(this.protocol, outboundBean.protocol) && e4.a(this.settings, outboundBean.settings) && e4.a(this.streamSettings, outboundBean.streamSettings) && e4.a(this.proxySettings, outboundBean.proxySettings) && e4.a(this.sendThrough, outboundBean.sendThrough) && e4.a(this.mux, outboundBean.mux);
        }

        public final MuxBean getMux() {
            return this.mux;
        }

        public final String getPassword() {
            List<OutSettingsBean.VnextBean> vnext;
            OutSettingsBean.VnextBean vnextBean;
            List<OutSettingsBean.VnextBean.UsersBean> users;
            OutSettingsBean.VnextBean.UsersBean usersBean;
            List<OutSettingsBean.ServersBean> servers;
            OutSettingsBean.ServersBean serversBean;
            List<OutSettingsBean.ServersBean> servers2;
            OutSettingsBean.ServersBean serversBean2;
            List<OutSettingsBean.ServersBean.SocksUsersBean> users2;
            OutSettingsBean.ServersBean.SocksUsersBean socksUsersBean;
            OutSettingsBean outSettingsBean;
            if (q31.X(this.protocol, "VMESS") || q31.X(this.protocol, "VLESS")) {
                OutSettingsBean outSettingsBean2 = this.settings;
                if (outSettingsBean2 == null || (vnext = outSettingsBean2.getVnext()) == null || (vnextBean = (OutSettingsBean.VnextBean) he.K0(vnext)) == null || (users = vnextBean.getUsers()) == null || (usersBean = (OutSettingsBean.VnextBean.UsersBean) he.K0(users)) == null) {
                    return null;
                }
                return usersBean.getId();
            }
            if (q31.X(this.protocol, "SHADOWSOCKS") || q31.X(this.protocol, "TROJAN") || q31.X(this.protocol, "HYSTERIA2")) {
                OutSettingsBean outSettingsBean3 = this.settings;
                if (outSettingsBean3 == null || (servers = outSettingsBean3.getServers()) == null || (serversBean = (OutSettingsBean.ServersBean) he.K0(servers)) == null) {
                    return null;
                }
                return serversBean.getPassword();
            }
            if (!q31.X(this.protocol, "SOCKS") && !q31.X(this.protocol, "HTTP")) {
                if (!q31.X(this.protocol, "WIREGUARD") || (outSettingsBean = this.settings) == null) {
                    return null;
                }
                return outSettingsBean.getSecretKey();
            }
            OutSettingsBean outSettingsBean4 = this.settings;
            if (outSettingsBean4 == null || (servers2 = outSettingsBean4.getServers()) == null || (serversBean2 = (OutSettingsBean.ServersBean) he.K0(servers2)) == null || (users2 = serversBean2.getUsers()) == null || (socksUsersBean = (OutSettingsBean.ServersBean.SocksUsersBean) he.K0(users2)) == null) {
                return null;
            }
            return socksUsersBean.getPass();
        }

        public final String getProtocol() {
            return this.protocol;
        }

        public final Object getProxySettings() {
            return this.proxySettings;
        }

        public final String getSecurityEncryption() {
            OutSettingsBean outSettingsBean;
            List<OutSettingsBean.ServersBean> servers;
            OutSettingsBean.ServersBean serversBean;
            List<OutSettingsBean.VnextBean> vnext;
            OutSettingsBean.VnextBean vnextBean;
            List<OutSettingsBean.VnextBean.UsersBean> users;
            OutSettingsBean.VnextBean.UsersBean usersBean;
            List<OutSettingsBean.VnextBean> vnext2;
            OutSettingsBean.VnextBean vnextBean2;
            List<OutSettingsBean.VnextBean.UsersBean> users2;
            OutSettingsBean.VnextBean.UsersBean usersBean2;
            if (q31.X(this.protocol, "VMESS")) {
                OutSettingsBean outSettingsBean2 = this.settings;
                if (outSettingsBean2 == null || (vnext2 = outSettingsBean2.getVnext()) == null || (vnextBean2 = (OutSettingsBean.VnextBean) he.K0(vnext2)) == null || (users2 = vnextBean2.getUsers()) == null || (usersBean2 = (OutSettingsBean.VnextBean.UsersBean) he.K0(users2)) == null) {
                    return null;
                }
                return usersBean2.getSecurity();
            }
            if (!q31.X(this.protocol, "VLESS")) {
                if (!q31.X(this.protocol, "SHADOWSOCKS") || (outSettingsBean = this.settings) == null || (servers = outSettingsBean.getServers()) == null || (serversBean = (OutSettingsBean.ServersBean) he.K0(servers)) == null) {
                    return null;
                }
                return serversBean.getMethod();
            }
            OutSettingsBean outSettingsBean3 = this.settings;
            if (outSettingsBean3 == null || (vnext = outSettingsBean3.getVnext()) == null || (vnextBean = (OutSettingsBean.VnextBean) he.K0(vnext)) == null || (users = vnextBean.getUsers()) == null || (usersBean = (OutSettingsBean.VnextBean.UsersBean) he.K0(users)) == null) {
                return null;
            }
            return usersBean.getEncryption();
        }

        public final String getSendThrough() {
            return this.sendThrough;
        }

        public final String getServerAddress() {
            List<OutSettingsBean.VnextBean> vnext;
            OutSettingsBean.VnextBean vnextBean;
            List<OutSettingsBean.ServersBean> servers;
            OutSettingsBean.ServersBean serversBean;
            OutSettingsBean outSettingsBean;
            List<OutSettingsBean.WireGuardBean> peers;
            OutSettingsBean.WireGuardBean wireGuardBean;
            String endpoint;
            if (q31.X(this.protocol, "VMESS") || q31.X(this.protocol, "VLESS")) {
                OutSettingsBean outSettingsBean2 = this.settings;
                if (outSettingsBean2 == null || (vnext = outSettingsBean2.getVnext()) == null || (vnextBean = (OutSettingsBean.VnextBean) he.K0(vnext)) == null) {
                    return null;
                }
                return vnextBean.getAddress();
            }
            if (q31.X(this.protocol, "SHADOWSOCKS") || q31.X(this.protocol, "SOCKS") || q31.X(this.protocol, "HTTP") || q31.X(this.protocol, "TROJAN") || q31.X(this.protocol, "HYSTERIA2")) {
                OutSettingsBean outSettingsBean3 = this.settings;
                if (outSettingsBean3 == null || (servers = outSettingsBean3.getServers()) == null || (serversBean = (OutSettingsBean.ServersBean) he.K0(servers)) == null) {
                    return null;
                }
                return serversBean.getAddress();
            }
            if (!q31.X(this.protocol, "WIREGUARD") || (outSettingsBean = this.settings) == null || (peers = outSettingsBean.getPeers()) == null || (wireGuardBean = (OutSettingsBean.WireGuardBean) he.K0(peers)) == null || (endpoint = wireGuardBean.getEndpoint()) == null) {
                return null;
            }
            int iN0 = q31.n0(endpoint, ":");
            return iN0 == -1 ? endpoint : endpoint.substring(0, iN0);
        }

        public final String getServerAddressAndPort() {
            String serverAddress = getServerAddress();
            if (serverAddress == null) {
                serverAddress = AppConfig.CUSTOM;
            }
            return Utils.INSTANCE.getIpv6Address(serverAddress) + ':' + getServerPort();
        }

        public final Integer getServerPort() {
            List<OutSettingsBean.VnextBean> vnext;
            OutSettingsBean.VnextBean vnextBean;
            int port;
            List<OutSettingsBean.ServersBean> servers;
            OutSettingsBean.ServersBean serversBean;
            OutSettingsBean outSettingsBean;
            List<OutSettingsBean.WireGuardBean> peers;
            OutSettingsBean.WireGuardBean wireGuardBean;
            String endpoint;
            if (q31.X(this.protocol, "VMESS") || q31.X(this.protocol, "VLESS")) {
                OutSettingsBean outSettingsBean2 = this.settings;
                if (outSettingsBean2 == null || (vnext = outSettingsBean2.getVnext()) == null || (vnextBean = (OutSettingsBean.VnextBean) he.K0(vnext)) == null) {
                    return null;
                }
                port = vnextBean.getPort();
            } else if (q31.X(this.protocol, "SHADOWSOCKS") || q31.X(this.protocol, "SOCKS") || q31.X(this.protocol, "HTTP") || q31.X(this.protocol, "TROJAN") || q31.X(this.protocol, "HYSTERIA2")) {
                OutSettingsBean outSettingsBean3 = this.settings;
                if (outSettingsBean3 == null || (servers = outSettingsBean3.getServers()) == null || (serversBean = (OutSettingsBean.ServersBean) he.K0(servers)) == null) {
                    return null;
                }
                port = serversBean.getPort();
            } else {
                if (!q31.X(this.protocol, "WIREGUARD") || (outSettingsBean = this.settings) == null || (peers = outSettingsBean.getPeers()) == null || (wireGuardBean = (OutSettingsBean.WireGuardBean) he.K0(peers)) == null || (endpoint = wireGuardBean.getEndpoint()) == null) {
                    return null;
                }
                int iN0 = q31.n0(endpoint, ":");
                if (iN0 != -1) {
                    endpoint = endpoint.substring(iN0 + 1, endpoint.length());
                }
                port = Integer.parseInt(endpoint);
            }
            return Integer.valueOf(port);
        }

        public final OutSettingsBean getSettings() {
            return this.settings;
        }

        public final StreamSettingsBean getStreamSettings() {
            return this.streamSettings;
        }

        public final String getTag() {
            return this.tag;
        }

        public final List<String> getTransportSettingDetails() {
            StreamSettingsBean streamSettingsBean;
            String network;
            StreamSettingsBean streamSettingsBean2;
            StreamSettingsBean.GrpcSettingsBean grpcSettings;
            StreamSettingsBean.HttpSettingsBean httpSettings;
            StreamSettingsBean.XhttpSettingsBean xhttpSettings;
            StreamSettingsBean.SplithttpSettingsBean splithttpSettings;
            StreamSettingsBean.HttpupgradeSettingsBean httpupgradeSettings;
            StreamSettingsBean.WsSettingsBean wsSettings;
            StreamSettingsBean.KcpSettingsBean kcpSettings;
            StreamSettingsBean.TcpSettingsBean tcpSettings;
            List<String> path;
            StreamSettingsBean.TcpSettingsBean.HeaderBean.RequestBean.HeadersBean headers;
            List<String> host;
            String strR0 = null;
            if ((q31.X(this.protocol, "VMESS") || q31.X(this.protocol, "VLESS") || q31.X(this.protocol, "TROJAN") || q31.X(this.protocol, "SHADOWSOCKS")) && (streamSettingsBean = this.streamSettings) != null && (network = streamSettingsBean.getNetwork()) != null) {
                boolean zEquals = network.equals(NetworkType.TCP.getType());
                String str = AppConfig.CUSTOM;
                if (zEquals) {
                    StreamSettingsBean streamSettingsBean3 = this.streamSettings;
                    if (streamSettingsBean3 != null && (tcpSettings = streamSettingsBean3.getTcpSettings()) != null) {
                        String type = tcpSettings.getHeader().getType();
                        StreamSettingsBean.TcpSettingsBean.HeaderBean.RequestBean request = tcpSettings.getHeader().getRequest();
                        String strR1 = (request == null || (headers = request.getHeaders()) == null || (host = headers.getHost()) == null) ? null : he.R0(host, ",", null, null, null, 62);
                        if (strR1 == null) {
                            strR1 = AppConfig.CUSTOM;
                        }
                        StreamSettingsBean.TcpSettingsBean.HeaderBean.RequestBean request2 = tcpSettings.getHeader().getRequest();
                        if (request2 != null && (path = request2.getPath()) != null) {
                            strR0 = he.R0(path, ",", null, null, null, 62);
                        }
                        if (strR0 != null) {
                            str = strR0;
                        }
                        return Arrays.asList(type, strR1, str);
                    }
                } else if (network.equals(NetworkType.KCP.getType())) {
                    StreamSettingsBean streamSettingsBean4 = this.streamSettings;
                    if (streamSettingsBean4 != null && (kcpSettings = streamSettingsBean4.getKcpSettings()) != null) {
                        String type2 = kcpSettings.getHeader().getType();
                        String seed = kcpSettings.getSeed();
                        if (seed == null) {
                            seed = AppConfig.CUSTOM;
                        }
                        return Arrays.asList(type2, AppConfig.CUSTOM, seed);
                    }
                } else if (network.equals(NetworkType.WS.getType())) {
                    StreamSettingsBean streamSettingsBean5 = this.streamSettings;
                    if (streamSettingsBean5 != null && (wsSettings = streamSettingsBean5.getWsSettings()) != null) {
                        return Arrays.asList(AppConfig.CUSTOM, wsSettings.getHeaders().getHost(), wsSettings.getPath());
                    }
                } else if (network.equals(NetworkType.HTTP_UPGRADE.getType())) {
                    StreamSettingsBean streamSettingsBean6 = this.streamSettings;
                    if (streamSettingsBean6 != null && (httpupgradeSettings = streamSettingsBean6.getHttpupgradeSettings()) != null) {
                        return Arrays.asList(AppConfig.CUSTOM, httpupgradeSettings.getHost(), httpupgradeSettings.getPath());
                    }
                } else if (network.equals(NetworkType.SPLIT_HTTP.getType())) {
                    StreamSettingsBean streamSettingsBean7 = this.streamSettings;
                    if (streamSettingsBean7 != null && (splithttpSettings = streamSettingsBean7.getSplithttpSettings()) != null) {
                        return Arrays.asList(AppConfig.CUSTOM, splithttpSettings.getHost(), splithttpSettings.getPath());
                    }
                } else if (network.equals(NetworkType.XHTTP.getType())) {
                    StreamSettingsBean streamSettingsBean8 = this.streamSettings;
                    if (streamSettingsBean8 != null && (xhttpSettings = streamSettingsBean8.getXhttpSettings()) != null) {
                        return Arrays.asList(AppConfig.CUSTOM, xhttpSettings.getHost(), xhttpSettings.getPath());
                    }
                } else if (network.equals(NetworkType.H2.getType())) {
                    StreamSettingsBean streamSettingsBean9 = this.streamSettings;
                    if (streamSettingsBean9 != null && (httpSettings = streamSettingsBean9.getHttpSettings()) != null) {
                        return Arrays.asList(AppConfig.CUSTOM, he.R0(httpSettings.getHost(), ",", null, null, null, 62), httpSettings.getPath());
                    }
                } else if (network.equals(NetworkType.GRPC.getType()) && (streamSettingsBean2 = this.streamSettings) != null && (grpcSettings = streamSettingsBean2.getGrpcSettings()) != null) {
                    String str2 = e4.a(grpcSettings.getMultiMode(), Boolean.TRUE) ? "multi" : "gun";
                    String authority = grpcSettings.getAuthority();
                    if (authority != null) {
                        str = authority;
                    }
                    return Arrays.asList(str2, str, grpcSettings.getServiceName());
                }
            }
            return null;
        }

        public int hashCode() {
            int iD = e.d(this.tag.hashCode() * 31, this.protocol);
            OutSettingsBean outSettingsBean = this.settings;
            int iHashCode = (iD + (outSettingsBean == null ? 0 : outSettingsBean.hashCode())) * 31;
            StreamSettingsBean streamSettingsBean = this.streamSettings;
            int iHashCode2 = (iHashCode + (streamSettingsBean == null ? 0 : streamSettingsBean.hashCode())) * 31;
            Object obj = this.proxySettings;
            int iHashCode3 = (iHashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
            String str = this.sendThrough;
            int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            MuxBean muxBean = this.mux;
            return iHashCode4 + (muxBean != null ? muxBean.hashCode() : 0);
        }

        public final void setMux(MuxBean muxBean) {
            this.mux = muxBean;
        }

        public final void setProtocol(String str) {
            this.protocol = str;
        }

        public final void setSettings(OutSettingsBean outSettingsBean) {
            this.settings = outSettingsBean;
        }

        public final void setStreamSettings(StreamSettingsBean streamSettingsBean) {
            this.streamSettings = streamSettingsBean;
        }

        public final void setTag(String str) {
            this.tag = str;
        }

        public String toString() {
            return "OutboundBean(tag=" + this.tag + ", protocol=" + this.protocol + ", settings=" + this.settings + ", streamSettings=" + this.streamSettings + ", proxySettings=" + this.proxySettings + ", sendThrough=" + this.sendThrough + ", mux=" + this.mux + ')';
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class PolicyBean {
        private Map<String, LevelBean> levels;
        private Object system;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class LevelBean {
            private Integer bufferSize;
            private Integer connIdle;
            private Integer downlinkOnly;
            private Integer handshake;
            private final Boolean statsUserDownlink;
            private final Boolean statsUserUplink;
            private Integer uplinkOnly;

            public LevelBean() {
                this(null, null, null, null, null, null, null, 127, null);
            }

            public LevelBean(Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Boolean bool2, Integer num5) {
                this.handshake = num;
                this.connIdle = num2;
                this.uplinkOnly = num3;
                this.downlinkOnly = num4;
                this.statsUserUplink = bool;
                this.statsUserDownlink = bool2;
                this.bufferSize = num5;
            }

            public /* synthetic */ LevelBean(Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Boolean bool2, Integer num5, int i, zk zkVar) {
                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : num5);
            }

            public static /* synthetic */ LevelBean copy$default(LevelBean levelBean, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Boolean bool2, Integer num5, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = levelBean.handshake;
                }
                if ((i & 2) != 0) {
                    num2 = levelBean.connIdle;
                }
                if ((i & 4) != 0) {
                    num3 = levelBean.uplinkOnly;
                }
                if ((i & 8) != 0) {
                    num4 = levelBean.downlinkOnly;
                }
                if ((i & 16) != 0) {
                    bool = levelBean.statsUserUplink;
                }
                if ((i & 32) != 0) {
                    bool2 = levelBean.statsUserDownlink;
                }
                if ((i & 64) != 0) {
                    num5 = levelBean.bufferSize;
                }
                Boolean bool3 = bool2;
                Integer num6 = num5;
                Boolean bool4 = bool;
                Integer num7 = num3;
                return levelBean.copy(num, num2, num7, num4, bool4, bool3, num6);
            }

            public final Integer component1() {
                return this.handshake;
            }

            public final Integer component2() {
                return this.connIdle;
            }

            public final Integer component3() {
                return this.uplinkOnly;
            }

            public final Integer component4() {
                return this.downlinkOnly;
            }

            public final Boolean component5() {
                return this.statsUserUplink;
            }

            public final Boolean component6() {
                return this.statsUserDownlink;
            }

            public final Integer component7() {
                return this.bufferSize;
            }

            public final LevelBean copy(Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Boolean bool2, Integer num5) {
                return new LevelBean(num, num2, num3, num4, bool, bool2, num5);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof LevelBean)) {
                    return false;
                }
                LevelBean levelBean = (LevelBean) obj;
                return e4.a(this.handshake, levelBean.handshake) && e4.a(this.connIdle, levelBean.connIdle) && e4.a(this.uplinkOnly, levelBean.uplinkOnly) && e4.a(this.downlinkOnly, levelBean.downlinkOnly) && e4.a(this.statsUserUplink, levelBean.statsUserUplink) && e4.a(this.statsUserDownlink, levelBean.statsUserDownlink) && e4.a(this.bufferSize, levelBean.bufferSize);
            }

            public final Integer getBufferSize() {
                return this.bufferSize;
            }

            public final Integer getConnIdle() {
                return this.connIdle;
            }

            public final Integer getDownlinkOnly() {
                return this.downlinkOnly;
            }

            public final Integer getHandshake() {
                return this.handshake;
            }

            public final Boolean getStatsUserDownlink() {
                return this.statsUserDownlink;
            }

            public final Boolean getStatsUserUplink() {
                return this.statsUserUplink;
            }

            public final Integer getUplinkOnly() {
                return this.uplinkOnly;
            }

            public int hashCode() {
                Integer num = this.handshake;
                int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
                Integer num2 = this.connIdle;
                int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
                Integer num3 = this.uplinkOnly;
                int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
                Integer num4 = this.downlinkOnly;
                int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
                Boolean bool = this.statsUserUplink;
                int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
                Boolean bool2 = this.statsUserDownlink;
                int iHashCode6 = (iHashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
                Integer num5 = this.bufferSize;
                return iHashCode6 + (num5 != null ? num5.hashCode() : 0);
            }

            public final void setBufferSize(Integer num) {
                this.bufferSize = num;
            }

            public final void setConnIdle(Integer num) {
                this.connIdle = num;
            }

            public final void setDownlinkOnly(Integer num) {
                this.downlinkOnly = num;
            }

            public final void setHandshake(Integer num) {
                this.handshake = num;
            }

            public final void setUplinkOnly(Integer num) {
                this.uplinkOnly = num;
            }

            public String toString() {
                return "LevelBean(handshake=" + this.handshake + ", connIdle=" + this.connIdle + ", uplinkOnly=" + this.uplinkOnly + ", downlinkOnly=" + this.downlinkOnly + ", statsUserUplink=" + this.statsUserUplink + ", statsUserDownlink=" + this.statsUserDownlink + ", bufferSize=" + this.bufferSize + ')';
            }
        }

        public PolicyBean(Map<String, LevelBean> map, Object obj) {
            this.levels = map;
            this.system = obj;
        }

        public /* synthetic */ PolicyBean(Map map, Object obj, int i, zk zkVar) {
            this(map, (i & 2) != 0 ? null : obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PolicyBean copy$default(PolicyBean policyBean, Map map, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                map = policyBean.levels;
            }
            if ((i & 2) != 0) {
                obj = policyBean.system;
            }
            return policyBean.copy(map, obj);
        }

        public final Map<String, LevelBean> component1() {
            return this.levels;
        }

        public final Object component2() {
            return this.system;
        }

        public final PolicyBean copy(Map<String, LevelBean> map, Object obj) {
            return new PolicyBean(map, obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PolicyBean)) {
                return false;
            }
            PolicyBean policyBean = (PolicyBean) obj;
            return e4.a(this.levels, policyBean.levels) && e4.a(this.system, policyBean.system);
        }

        public final Map<String, LevelBean> getLevels() {
            return this.levels;
        }

        public final Object getSystem() {
            return this.system;
        }

        public int hashCode() {
            int iHashCode = this.levels.hashCode() * 31;
            Object obj = this.system;
            return iHashCode + (obj == null ? 0 : obj.hashCode());
        }

        public final void setLevels(Map<String, LevelBean> map) {
            this.levels = map;
        }

        public final void setSystem(Object obj) {
            this.system = obj;
        }

        public String toString() {
            return "PolicyBean(levels=" + this.levels + ", system=" + this.system + ')';
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class RoutingBean {
        private final List<Object> balancers;
        private String domainMatcher;
        private String domainStrategy;
        private ArrayList<RulesBean> rules;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class RulesBean {
            private final String attrs;
            private String balancerTag;
            private ArrayList<String> domain;
            private final String domainMatcher;
            private List<String> inboundTag;
            private ArrayList<String> ip;
            private final String network;
            private String outboundTag;
            private String port;
            private final List<String> protocol;
            private final List<String> source;
            private final String sourcePort;
            private String type;
            private final List<String> user;

            public RulesBean() {
                this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
            }

            public RulesBean(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str2, String str3, String str4, String str5, String str6, List<String> list, List<String> list2, List<String> list3, List<String> list4, String str7, String str8) {
                this.type = str;
                this.ip = arrayList;
                this.domain = arrayList2;
                this.outboundTag = str2;
                this.balancerTag = str3;
                this.port = str4;
                this.sourcePort = str5;
                this.network = str6;
                this.source = list;
                this.user = list2;
                this.inboundTag = list3;
                this.protocol = list4;
                this.attrs = str7;
                this.domainMatcher = str8;
            }

            public /* synthetic */ RulesBean(String str, ArrayList arrayList, ArrayList arrayList2, String str2, String str3, String str4, String str5, String str6, List list, List list2, List list3, List list4, String str7, String str8, int i, zk zkVar) {
                this((i & 1) != 0 ? "field" : str, (i & 2) != 0 ? null : arrayList, (i & 4) != 0 ? null : arrayList2, (i & 8) != 0 ? AppConfig.CUSTOM : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : list, (i & 512) != 0 ? null : list2, (i & 1024) != 0 ? null : list3, (i & 2048) != 0 ? null : list4, (i & 4096) != 0 ? null : str7, (i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? null : str8);
            }

            public final String component1() {
                return this.type;
            }

            public final List<String> component10() {
                return this.user;
            }

            public final List<String> component11() {
                return this.inboundTag;
            }

            public final List<String> component12() {
                return this.protocol;
            }

            public final String component13() {
                return this.attrs;
            }

            public final String component14() {
                return this.domainMatcher;
            }

            public final ArrayList<String> component2() {
                return this.ip;
            }

            public final ArrayList<String> component3() {
                return this.domain;
            }

            public final String component4() {
                return this.outboundTag;
            }

            public final String component5() {
                return this.balancerTag;
            }

            public final String component6() {
                return this.port;
            }

            public final String component7() {
                return this.sourcePort;
            }

            public final String component8() {
                return this.network;
            }

            public final List<String> component9() {
                return this.source;
            }

            public final RulesBean copy(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str2, String str3, String str4, String str5, String str6, List<String> list, List<String> list2, List<String> list3, List<String> list4, String str7, String str8) {
                return new RulesBean(str, arrayList, arrayList2, str2, str3, str4, str5, str6, list, list2, list3, list4, str7, str8);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RulesBean)) {
                    return false;
                }
                RulesBean rulesBean = (RulesBean) obj;
                return e4.a(this.type, rulesBean.type) && e4.a(this.ip, rulesBean.ip) && e4.a(this.domain, rulesBean.domain) && e4.a(this.outboundTag, rulesBean.outboundTag) && e4.a(this.balancerTag, rulesBean.balancerTag) && e4.a(this.port, rulesBean.port) && e4.a(this.sourcePort, rulesBean.sourcePort) && e4.a(this.network, rulesBean.network) && e4.a(this.source, rulesBean.source) && e4.a(this.user, rulesBean.user) && e4.a(this.inboundTag, rulesBean.inboundTag) && e4.a(this.protocol, rulesBean.protocol) && e4.a(this.attrs, rulesBean.attrs) && e4.a(this.domainMatcher, rulesBean.domainMatcher);
            }

            public final String getAttrs() {
                return this.attrs;
            }

            public final String getBalancerTag() {
                return this.balancerTag;
            }

            public final ArrayList<String> getDomain() {
                return this.domain;
            }

            public final String getDomainMatcher() {
                return this.domainMatcher;
            }

            public final List<String> getInboundTag() {
                return this.inboundTag;
            }

            public final ArrayList<String> getIp() {
                return this.ip;
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

            public final List<String> getSource() {
                return this.source;
            }

            public final String getSourcePort() {
                return this.sourcePort;
            }

            public final String getType() {
                return this.type;
            }

            public final List<String> getUser() {
                return this.user;
            }

            public int hashCode() {
                int iHashCode = this.type.hashCode() * 31;
                ArrayList<String> arrayList = this.ip;
                int iHashCode2 = (iHashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
                ArrayList<String> arrayList2 = this.domain;
                int iD = e.d((iHashCode2 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31, this.outboundTag);
                String str = this.balancerTag;
                int iHashCode3 = (iD + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.port;
                int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.sourcePort;
                int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.network;
                int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
                List<String> list = this.source;
                int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
                List<String> list2 = this.user;
                int iHashCode8 = (iHashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
                List<String> list3 = this.inboundTag;
                int iHashCode9 = (iHashCode8 + (list3 == null ? 0 : list3.hashCode())) * 31;
                List<String> list4 = this.protocol;
                int iHashCode10 = (iHashCode9 + (list4 == null ? 0 : list4.hashCode())) * 31;
                String str5 = this.attrs;
                int iHashCode11 = (iHashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.domainMatcher;
                return iHashCode11 + (str6 != null ? str6.hashCode() : 0);
            }

            public final void setBalancerTag(String str) {
                this.balancerTag = str;
            }

            public final void setDomain(ArrayList<String> arrayList) {
                this.domain = arrayList;
            }

            public final void setInboundTag(List<String> list) {
                this.inboundTag = list;
            }

            public final void setIp(ArrayList<String> arrayList) {
                this.ip = arrayList;
            }

            public final void setOutboundTag(String str) {
                this.outboundTag = str;
            }

            public final void setPort(String str) {
                this.port = str;
            }

            public final void setType(String str) {
                this.type = str;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("RulesBean(type=");
                sb.append(this.type);
                sb.append(", ip=");
                sb.append(this.ip);
                sb.append(", domain=");
                sb.append(this.domain);
                sb.append(", outboundTag=");
                sb.append(this.outboundTag);
                sb.append(", balancerTag=");
                sb.append(this.balancerTag);
                sb.append(", port=");
                sb.append(this.port);
                sb.append(", sourcePort=");
                sb.append(this.sourcePort);
                sb.append(", network=");
                sb.append(this.network);
                sb.append(", source=");
                sb.append(this.source);
                sb.append(", user=");
                sb.append(this.user);
                sb.append(", inboundTag=");
                sb.append(this.inboundTag);
                sb.append(", protocol=");
                sb.append(this.protocol);
                sb.append(", attrs=");
                sb.append(this.attrs);
                sb.append(", domainMatcher=");
                return fb$1.m(sb, this.domainMatcher, ')');
            }
        }

        public RoutingBean(String str, String str2, ArrayList<RulesBean> arrayList, List<? extends Object> list) {
            this.domainStrategy = str;
            this.domainMatcher = str2;
            this.rules = arrayList;
            this.balancers = list;
        }

        public /* synthetic */ RoutingBean(String str, String str2, ArrayList arrayList, List list, int i, zk zkVar) {
            this(str, (i & 2) != 0 ? null : str2, arrayList, (i & 8) != 0 ? null : list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RoutingBean copy$default(RoutingBean routingBean, String str, String str2, ArrayList arrayList, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = routingBean.domainStrategy;
            }
            if ((i & 2) != 0) {
                str2 = routingBean.domainMatcher;
            }
            if ((i & 4) != 0) {
                arrayList = routingBean.rules;
            }
            if ((i & 8) != 0) {
                list = routingBean.balancers;
            }
            return routingBean.copy(str, str2, arrayList, list);
        }

        public final String component1() {
            return this.domainStrategy;
        }

        public final String component2() {
            return this.domainMatcher;
        }

        public final ArrayList<RulesBean> component3() {
            return this.rules;
        }

        public final List<Object> component4() {
            return this.balancers;
        }

        public final RoutingBean copy(String str, String str2, ArrayList<RulesBean> arrayList, List<? extends Object> list) {
            return new RoutingBean(str, str2, arrayList, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RoutingBean)) {
                return false;
            }
            RoutingBean routingBean = (RoutingBean) obj;
            return e4.a(this.domainStrategy, routingBean.domainStrategy) && e4.a(this.domainMatcher, routingBean.domainMatcher) && e4.a(this.rules, routingBean.rules) && e4.a(this.balancers, routingBean.balancers);
        }

        public final List<Object> getBalancers() {
            return this.balancers;
        }

        public final String getDomainMatcher() {
            return this.domainMatcher;
        }

        public final String getDomainStrategy() {
            return this.domainStrategy;
        }

        public final ArrayList<RulesBean> getRules() {
            return this.rules;
        }

        public int hashCode() {
            int iHashCode = this.domainStrategy.hashCode() * 31;
            String str = this.domainMatcher;
            int iHashCode2 = (this.rules.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31;
            List<Object> list = this.balancers;
            return iHashCode2 + (list != null ? list.hashCode() : 0);
        }

        public final void setDomainMatcher(String str) {
            this.domainMatcher = str;
        }

        public final void setDomainStrategy(String str) {
            this.domainStrategy = str;
        }

        public final void setRules(ArrayList<RulesBean> arrayList) {
            this.rules = arrayList;
        }

        public String toString() {
            return "RoutingBean(domainStrategy=" + this.domainStrategy + ", domainMatcher=" + this.domainMatcher + ", rules=" + this.rules + ", balancers=" + this.balancers + ')';
        }
    }

    public V2rayConfig(String str, Object obj, LogBean logBean, PolicyBean policyBean, ArrayList<InboundBean> arrayList, ArrayList<OutboundBean> arrayList2, DnsBean dnsBean, RoutingBean routingBean, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        this.remarks = str;
        this.stats = obj;
        this.log = logBean;
        this.policy = policyBean;
        this.inbounds = arrayList;
        this.outbounds = arrayList2;
        this.dns = dnsBean;
        this.routing = routingBean;
        this.api = obj2;
        this.transport = obj3;
        this.reverse = obj4;
        this.fakedns = obj5;
        this.browserForwarder = obj6;
        this.observatory = obj7;
        this.burstObservatory = obj8;
    }

    public /* synthetic */ V2rayConfig(String str, Object obj, LogBean logBean, PolicyBean policyBean, ArrayList arrayList, ArrayList arrayList2, DnsBean dnsBean, RoutingBean routingBean, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, int i, zk zkVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : obj, logBean, policyBean, arrayList, arrayList2, dnsBean, routingBean, (i & 256) != 0 ? null : obj2, (i & 512) != 0 ? null : obj3, (i & 1024) != 0 ? null : obj4, (i & 2048) != 0 ? null : obj5, (i & 4096) != 0 ? null : obj6, (i & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? null : obj7, (i & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) != 0 ? null : obj8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonElement toPrettyPrinting$lambda$2(Double d, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(d != null ? Integer.valueOf((int) d.doubleValue()) : null);
    }

    public final String component1() {
        return this.remarks;
    }

    public final Object component10() {
        return this.transport;
    }

    public final Object component11() {
        return this.reverse;
    }

    public final Object component12() {
        return this.fakedns;
    }

    public final Object component13() {
        return this.browserForwarder;
    }

    public final Object component14() {
        return this.observatory;
    }

    public final Object component15() {
        return this.burstObservatory;
    }

    public final Object component2() {
        return this.stats;
    }

    public final LogBean component3() {
        return this.log;
    }

    public final PolicyBean component4() {
        return this.policy;
    }

    public final ArrayList<InboundBean> component5() {
        return this.inbounds;
    }

    public final ArrayList<OutboundBean> component6() {
        return this.outbounds;
    }

    public final DnsBean component7() {
        return this.dns;
    }

    public final RoutingBean component8() {
        return this.routing;
    }

    public final Object component9() {
        return this.api;
    }

    public final V2rayConfig copy(String str, Object obj, LogBean logBean, PolicyBean policyBean, ArrayList<InboundBean> arrayList, ArrayList<OutboundBean> arrayList2, DnsBean dnsBean, RoutingBean routingBean, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return new V2rayConfig(str, obj, logBean, policyBean, arrayList, arrayList2, dnsBean, routingBean, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof V2rayConfig)) {
            return false;
        }
        V2rayConfig v2rayConfig = (V2rayConfig) obj;
        return e4.a(this.remarks, v2rayConfig.remarks) && e4.a(this.stats, v2rayConfig.stats) && e4.a(this.log, v2rayConfig.log) && e4.a(this.policy, v2rayConfig.policy) && e4.a(this.inbounds, v2rayConfig.inbounds) && e4.a(this.outbounds, v2rayConfig.outbounds) && e4.a(this.dns, v2rayConfig.dns) && e4.a(this.routing, v2rayConfig.routing) && e4.a(this.api, v2rayConfig.api) && e4.a(this.transport, v2rayConfig.transport) && e4.a(this.reverse, v2rayConfig.reverse) && e4.a(this.fakedns, v2rayConfig.fakedns) && e4.a(this.browserForwarder, v2rayConfig.browserForwarder) && e4.a(this.observatory, v2rayConfig.observatory) && e4.a(this.burstObservatory, v2rayConfig.burstObservatory);
    }

    public final Object getApi() {
        return this.api;
    }

    public final Object getBrowserForwarder() {
        return this.browserForwarder;
    }

    public final Object getBurstObservatory() {
        return this.burstObservatory;
    }

    public final DnsBean getDns() {
        return this.dns;
    }

    public final Object getFakedns() {
        return this.fakedns;
    }

    public final ArrayList<InboundBean> getInbounds() {
        return this.inbounds;
    }

    public final LogBean getLog() {
        return this.log;
    }

    public final Object getObservatory() {
        return this.observatory;
    }

    public final ArrayList<OutboundBean> getOutbounds() {
        return this.outbounds;
    }

    public final PolicyBean getPolicy() {
        return this.policy;
    }

    public final OutboundBean getProxyOutbound() {
        for (OutboundBean outboundBean : this.outbounds) {
            z zVar = (z) EConfigType.getEntries();
            zVar.getClass();
            a7 a7Var = new a7(1, zVar);
            while (a7Var.hasNext()) {
                if (q31.X(outboundBean.getProtocol(), ((EConfigType) a7Var.next()).name())) {
                    return outboundBean;
                }
            }
        }
        return null;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public final Object getReverse() {
        return this.reverse;
    }

    public final RoutingBean getRouting() {
        return this.routing;
    }

    public final Object getStats() {
        return this.stats;
    }

    public final Object getTransport() {
        return this.transport;
    }

    public int hashCode() {
        String str = this.remarks;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Object obj = this.stats;
        int iHashCode2 = (this.log.hashCode() + ((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31)) * 31;
        PolicyBean policyBean = this.policy;
        int iHashCode3 = (this.routing.hashCode() + ((this.dns.hashCode() + ((this.outbounds.hashCode() + ((this.inbounds.hashCode() + ((iHashCode2 + (policyBean == null ? 0 : policyBean.hashCode())) * 31)) * 31)) * 31)) * 31)) * 31;
        Object obj2 = this.api;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.transport;
        int iHashCode5 = (iHashCode4 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
        Object obj4 = this.reverse;
        int iHashCode6 = (iHashCode5 + (obj4 == null ? 0 : obj4.hashCode())) * 31;
        Object obj5 = this.fakedns;
        int iHashCode7 = (iHashCode6 + (obj5 == null ? 0 : obj5.hashCode())) * 31;
        Object obj6 = this.browserForwarder;
        int iHashCode8 = (iHashCode7 + (obj6 == null ? 0 : obj6.hashCode())) * 31;
        Object obj7 = this.observatory;
        int iHashCode9 = (iHashCode8 + (obj7 == null ? 0 : obj7.hashCode())) * 31;
        Object obj8 = this.burstObservatory;
        return iHashCode9 + (obj8 != null ? obj8.hashCode() : 0);
    }

    public final void setBurstObservatory(Object obj) {
        this.burstObservatory = obj;
    }

    public final void setDns(DnsBean dnsBean) {
        this.dns = dnsBean;
    }

    public final void setFakedns(Object obj) {
        this.fakedns = obj;
    }

    public final void setObservatory(Object obj) {
        this.observatory = obj;
    }

    public final void setOutbounds(ArrayList<OutboundBean> arrayList) {
        this.outbounds = arrayList;
    }

    public final void setPolicy(PolicyBean policyBean) {
        this.policy = policyBean;
    }

    public final void setRemarks(String str) {
        this.remarks = str;
    }

    public final void setStats(Object obj) {
        this.stats = obj;
    }

    public final String toPrettyPrinting() {
        return new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().registerTypeAdapter(new TypeToken<Double>() { // from class: renz.javacodez.v2ray.dto.V2rayConfig.toPrettyPrinting.1
        }.getType(), new n70(1)).create().toJson(this);
    }

    public String toString() {
        return "V2rayConfig(remarks=" + this.remarks + ", stats=" + this.stats + ", log=" + this.log + ", policy=" + this.policy + ", inbounds=" + this.inbounds + ", outbounds=" + this.outbounds + ", dns=" + this.dns + ", routing=" + this.routing + ", api=" + this.api + ", transport=" + this.transport + ", reverse=" + this.reverse + ", fakedns=" + this.fakedns + ", browserForwarder=" + this.browserForwarder + ", observatory=" + this.observatory + ", burstObservatory=" + this.burstObservatory + ')';
    }
}
