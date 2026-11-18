package renz.javacodez.v2ray.dto;

import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.e;
import defpackage.e4;
import defpackage.fb$1;
import defpackage.zk;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileItem {
    public static final Companion Companion = new Companion(null);
    private long addedTime;
    private String alpn;
    private String authority;
    private final EConfigType configType;
    private final int configVersion;
    private String fingerPrint;
    private String flow;
    private String headerType;
    private String host;
    private Boolean insecure;
    private String localAddress;
    private String method;
    private String mode;
    private Integer mtu;
    private String network;
    private String obfsPassword;
    private String password;
    private String path;
    private String pinSHA256;
    private String portHopping;
    private String portHoppingInterval;
    private String preSharedKey;
    private String publicKey;
    private String quicKey;
    private String quicSecurity;
    private String remarks;
    private String reserved;
    private String secretKey;
    private String security;
    private String seed;
    private String server;
    private String serverPort;
    private String serviceName;
    private String shortId;
    private String sni;
    private String spiderX;
    private String subscriptionId;
    private String username;
    private String xhttpExtra;
    private String xhttpMode;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(zk zkVar) {
            this();
        }

        public final ProfileItem create(EConfigType eConfigType) {
            return new ProfileItem(0, eConfigType, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -3, 255, null);
        }
    }

    public ProfileItem(int i, EConfigType eConfigType, String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, Boolean bool, String str25, String str26, String str27, String str28, String str29, String str30, String str31, Integer num, String str32, String str33, String str34, String str35) {
        this.configVersion = i;
        this.configType = eConfigType;
        this.subscriptionId = str;
        this.addedTime = j;
        this.remarks = str2;
        this.server = str3;
        this.serverPort = str4;
        this.password = str5;
        this.method = str6;
        this.flow = str7;
        this.username = str8;
        this.network = str9;
        this.headerType = str10;
        this.host = str11;
        this.path = str12;
        this.seed = str13;
        this.quicSecurity = str14;
        this.quicKey = str15;
        this.mode = str16;
        this.serviceName = str17;
        this.authority = str18;
        this.xhttpMode = str19;
        this.xhttpExtra = str20;
        this.security = str21;
        this.sni = str22;
        this.alpn = str23;
        this.fingerPrint = str24;
        this.insecure = bool;
        this.publicKey = str25;
        this.shortId = str26;
        this.spiderX = str27;
        this.secretKey = str28;
        this.preSharedKey = str29;
        this.localAddress = str30;
        this.reserved = str31;
        this.mtu = num;
        this.obfsPassword = str32;
        this.portHopping = str33;
        this.portHoppingInterval = str34;
        this.pinSHA256 = str35;
    }

    public /* synthetic */ ProfileItem(int i, EConfigType eConfigType, String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, Boolean bool, String str25, String str26, String str27, String str28, String str29, String str30, String str31, Integer num, String str32, String str33, String str34, String str35, int i2, int i3, zk zkVar) {
        this((i2 & 1) != 0 ? 4 : i, eConfigType, (i2 & 4) != 0 ? AppConfig.CUSTOM : str, (i2 & 8) != 0 ? System.currentTimeMillis() : j, (i2 & 16) == 0 ? str2 : AppConfig.CUSTOM, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? null : str5, (i2 & 256) != 0 ? null : str6, (i2 & 512) != 0 ? null : str7, (i2 & 1024) != 0 ? null : str8, (i2 & 2048) != 0 ? null : str9, (i2 & 4096) != 0 ? null : str10, (i2 & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0 ? null : str11, (i2 & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) != 0 ? null : str12, (i2 & AttribFlags.SSH_FILEXFER_ATTR_CTIME) != 0 ? null : str13, (i2 & 65536) != 0 ? null : str14, (i2 & 131072) != 0 ? null : str15, (i2 & 262144) != 0 ? null : str16, (i2 & 524288) != 0 ? null : str17, (i2 & 1048576) != 0 ? null : str18, (i2 & 2097152) != 0 ? null : str19, (i2 & 4194304) != 0 ? null : str20, (i2 & 8388608) != 0 ? null : str21, (i2 & 16777216) != 0 ? null : str22, (i2 & 33554432) != 0 ? null : str23, (i2 & 67108864) != 0 ? null : str24, (i2 & 134217728) != 0 ? null : bool, (i2 & 268435456) != 0 ? null : str25, (i2 & 536870912) != 0 ? null : str26, (i2 & 1073741824) != 0 ? null : str27, (i2 & AttribFlags.SSH_FILEXFER_ATTR_EXTENDED) != 0 ? null : str28, (i3 & 1) != 0 ? null : str29, (i3 & 2) != 0 ? null : str30, (i3 & 4) != 0 ? null : str31, (i3 & 8) != 0 ? null : num, (i3 & 16) != 0 ? null : str32, (i3 & 32) != 0 ? null : str33, (i3 & 64) != 0 ? null : str34, (i3 & 128) != 0 ? null : str35);
    }

    public final int component1() {
        return this.configVersion;
    }

    public final String component10() {
        return this.flow;
    }

    public final String component11() {
        return this.username;
    }

    public final String component12() {
        return this.network;
    }

    public final String component13() {
        return this.headerType;
    }

    public final String component14() {
        return this.host;
    }

    public final String component15() {
        return this.path;
    }

    public final String component16() {
        return this.seed;
    }

    public final String component17() {
        return this.quicSecurity;
    }

    public final String component18() {
        return this.quicKey;
    }

    public final String component19() {
        return this.mode;
    }

    public final EConfigType component2() {
        return this.configType;
    }

    public final String component20() {
        return this.serviceName;
    }

    public final String component21() {
        return this.authority;
    }

    public final String component22() {
        return this.xhttpMode;
    }

    public final String component23() {
        return this.xhttpExtra;
    }

    public final String component24() {
        return this.security;
    }

    public final String component25() {
        return this.sni;
    }

    public final String component26() {
        return this.alpn;
    }

    public final String component27() {
        return this.fingerPrint;
    }

    public final Boolean component28() {
        return this.insecure;
    }

    public final String component29() {
        return this.publicKey;
    }

    public final String component3() {
        return this.subscriptionId;
    }

    public final String component30() {
        return this.shortId;
    }

    public final String component31() {
        return this.spiderX;
    }

    public final String component32() {
        return this.secretKey;
    }

    public final String component33() {
        return this.preSharedKey;
    }

    public final String component34() {
        return this.localAddress;
    }

    public final String component35() {
        return this.reserved;
    }

    public final Integer component36() {
        return this.mtu;
    }

    public final String component37() {
        return this.obfsPassword;
    }

    public final String component38() {
        return this.portHopping;
    }

    public final String component39() {
        return this.portHoppingInterval;
    }

    public final long component4() {
        return this.addedTime;
    }

    public final String component40() {
        return this.pinSHA256;
    }

    public final String component5() {
        return this.remarks;
    }

    public final String component6() {
        return this.server;
    }

    public final String component7() {
        return this.serverPort;
    }

    public final String component8() {
        return this.password;
    }

    public final String component9() {
        return this.method;
    }

    public final ProfileItem copy(int i, EConfigType eConfigType, String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, Boolean bool, String str25, String str26, String str27, String str28, String str29, String str30, String str31, Integer num, String str32, String str33, String str34, String str35) {
        return new ProfileItem(i, eConfigType, str, j, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, bool, str25, str26, str27, str28, str29, str30, str31, num, str32, str33, str34, str35);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ProfileItem profileItem = (ProfileItem) obj;
        return e4.a(this.server, profileItem.server) && e4.a(this.serverPort, profileItem.serverPort) && e4.a(this.password, profileItem.password) && e4.a(this.method, profileItem.method) && e4.a(this.flow, profileItem.flow) && e4.a(this.username, profileItem.username) && e4.a(this.network, profileItem.network) && e4.a(this.headerType, profileItem.headerType) && e4.a(this.host, profileItem.host) && e4.a(this.path, profileItem.path) && e4.a(this.seed, profileItem.seed) && e4.a(this.quicSecurity, profileItem.quicSecurity) && e4.a(this.quicKey, profileItem.quicKey) && e4.a(this.mode, profileItem.mode) && e4.a(this.serviceName, profileItem.serviceName) && e4.a(this.authority, profileItem.authority) && e4.a(this.xhttpMode, profileItem.xhttpMode) && e4.a(this.security, profileItem.security) && e4.a(this.sni, profileItem.sni) && e4.a(this.alpn, profileItem.alpn) && e4.a(this.fingerPrint, profileItem.fingerPrint) && e4.a(this.publicKey, profileItem.publicKey) && e4.a(this.shortId, profileItem.shortId) && e4.a(this.secretKey, profileItem.secretKey) && e4.a(this.localAddress, profileItem.localAddress) && e4.a(this.reserved, profileItem.reserved) && e4.a(this.mtu, profileItem.mtu) && e4.a(this.obfsPassword, profileItem.obfsPassword) && e4.a(this.portHopping, profileItem.portHopping) && e4.a(this.portHoppingInterval, profileItem.portHoppingInterval) && e4.a(this.pinSHA256, profileItem.pinSHA256);
    }

    public final long getAddedTime() {
        return this.addedTime;
    }

    public final List<String> getAllOutboundTags() {
        return e.d0(AppConfig.TAG_PROXY, AppConfig.TAG_DIRECT, AppConfig.TAG_BLOCKED);
    }

    public final String getAlpn() {
        return this.alpn;
    }

    public final String getAuthority() {
        return this.authority;
    }

    public final EConfigType getConfigType() {
        return this.configType;
    }

    public final int getConfigVersion() {
        return this.configVersion;
    }

    public final String getFingerPrint() {
        return this.fingerPrint;
    }

    public final String getFlow() {
        return this.flow;
    }

    public final String getHeaderType() {
        return this.headerType;
    }

    public final String getHost() {
        return this.host;
    }

    public final Boolean getInsecure() {
        return this.insecure;
    }

    public final String getLocalAddress() {
        return this.localAddress;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getMode() {
        return this.mode;
    }

    public final Integer getMtu() {
        return this.mtu;
    }

    public final String getNetwork() {
        return this.network;
    }

    public final String getObfsPassword() {
        return this.obfsPassword;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPinSHA256() {
        return this.pinSHA256;
    }

    public final String getPortHopping() {
        return this.portHopping;
    }

    public final String getPortHoppingInterval() {
        return this.portHoppingInterval;
    }

    public final String getPreSharedKey() {
        return this.preSharedKey;
    }

    public final String getPublicKey() {
        return this.publicKey;
    }

    public final String getQuicKey() {
        return this.quicKey;
    }

    public final String getQuicSecurity() {
        return this.quicSecurity;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public final String getReserved() {
        return this.reserved;
    }

    public final String getSecretKey() {
        return this.secretKey;
    }

    public final String getSecurity() {
        return this.security;
    }

    public final String getSeed() {
        return this.seed;
    }

    public final String getServer() {
        return this.server;
    }

    public final String getServerAddressAndPort() {
        return Utils.INSTANCE.getIpv6Address(this.server) + ':' + this.serverPort;
    }

    public final String getServerPort() {
        return this.serverPort;
    }

    public final String getServiceName() {
        return this.serviceName;
    }

    public final String getShortId() {
        return this.shortId;
    }

    public final String getSni() {
        return this.sni;
    }

    public final String getSpiderX() {
        return this.spiderX;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getXhttpExtra() {
        return this.xhttpExtra;
    }

    public final String getXhttpMode() {
        return this.xhttpMode;
    }

    public int hashCode() {
        int iD = e.d((this.configType.hashCode() + (this.configVersion * 31)) * 31, this.subscriptionId);
        long j = this.addedTime;
        int iD2 = e.d((iD + ((int) (j ^ (j >>> 32)))) * 31, this.remarks);
        String str = this.server;
        int iHashCode = (iD2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.serverPort;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.password;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.method;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.flow;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.username;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.network;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.headerType;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.host;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.path;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.seed;
        int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.quicSecurity;
        int iHashCode12 = (iHashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.quicKey;
        int iHashCode13 = (iHashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.mode;
        int iHashCode14 = (iHashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.serviceName;
        int iHashCode15 = (iHashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.authority;
        int iHashCode16 = (iHashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.xhttpMode;
        int iHashCode17 = (iHashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.xhttpExtra;
        int iHashCode18 = (iHashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.security;
        int iHashCode19 = (iHashCode18 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.sni;
        int iHashCode20 = (iHashCode19 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.alpn;
        int iHashCode21 = (iHashCode20 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.fingerPrint;
        int iHashCode22 = (iHashCode21 + (str22 == null ? 0 : str22.hashCode())) * 31;
        Boolean bool = this.insecure;
        int iHashCode23 = (iHashCode22 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str23 = this.publicKey;
        int iHashCode24 = (iHashCode23 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.shortId;
        int iHashCode25 = (iHashCode24 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.spiderX;
        int iHashCode26 = (iHashCode25 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.secretKey;
        int iHashCode27 = (iHashCode26 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.preSharedKey;
        int iHashCode28 = (iHashCode27 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.localAddress;
        int iHashCode29 = (iHashCode28 + (str28 == null ? 0 : str28.hashCode())) * 31;
        String str29 = this.reserved;
        int iHashCode30 = (iHashCode29 + (str29 == null ? 0 : str29.hashCode())) * 31;
        Integer num = this.mtu;
        int iHashCode31 = (iHashCode30 + (num == null ? 0 : num.hashCode())) * 31;
        String str30 = this.obfsPassword;
        int iHashCode32 = (iHashCode31 + (str30 == null ? 0 : str30.hashCode())) * 31;
        String str31 = this.portHopping;
        int iHashCode33 = (iHashCode32 + (str31 == null ? 0 : str31.hashCode())) * 31;
        String str32 = this.portHoppingInterval;
        int iHashCode34 = (iHashCode33 + (str32 == null ? 0 : str32.hashCode())) * 31;
        String str33 = this.pinSHA256;
        return iHashCode34 + (str33 != null ? str33.hashCode() : 0);
    }

    public final void setAddedTime(long j) {
        this.addedTime = j;
    }

    public final void setAlpn(String str) {
        this.alpn = str;
    }

    public final void setAuthority(String str) {
        this.authority = str;
    }

    public final void setFingerPrint(String str) {
        this.fingerPrint = str;
    }

    public final void setFlow(String str) {
        this.flow = str;
    }

    public final void setHeaderType(String str) {
        this.headerType = str;
    }

    public final void setHost(String str) {
        this.host = str;
    }

    public final void setInsecure(Boolean bool) {
        this.insecure = bool;
    }

    public final void setLocalAddress(String str) {
        this.localAddress = str;
    }

    public final void setMethod(String str) {
        this.method = str;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final void setMtu(Integer num) {
        this.mtu = num;
    }

    public final void setNetwork(String str) {
        this.network = str;
    }

    public final void setObfsPassword(String str) {
        this.obfsPassword = str;
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setPinSHA256(String str) {
        this.pinSHA256 = str;
    }

    public final void setPortHopping(String str) {
        this.portHopping = str;
    }

    public final void setPortHoppingInterval(String str) {
        this.portHoppingInterval = str;
    }

    public final void setPreSharedKey(String str) {
        this.preSharedKey = str;
    }

    public final void setPublicKey(String str) {
        this.publicKey = str;
    }

    public final void setQuicKey(String str) {
        this.quicKey = str;
    }

    public final void setQuicSecurity(String str) {
        this.quicSecurity = str;
    }

    public final void setRemarks(String str) {
        this.remarks = str;
    }

    public final void setReserved(String str) {
        this.reserved = str;
    }

    public final void setSecretKey(String str) {
        this.secretKey = str;
    }

    public final void setSecurity(String str) {
        this.security = str;
    }

    public final void setSeed(String str) {
        this.seed = str;
    }

    public final void setServer(String str) {
        this.server = str;
    }

    public final void setServerPort(String str) {
        this.serverPort = str;
    }

    public final void setServiceName(String str) {
        this.serviceName = str;
    }

    public final void setShortId(String str) {
        this.shortId = str;
    }

    public final void setSni(String str) {
        this.sni = str;
    }

    public final void setSpiderX(String str) {
        this.spiderX = str;
    }

    public final void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final void setXhttpExtra(String str) {
        this.xhttpExtra = str;
    }

    public final void setXhttpMode(String str) {
        this.xhttpMode = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ProfileItem(configVersion=");
        sb.append(this.configVersion);
        sb.append(", configType=");
        sb.append(this.configType);
        sb.append(", subscriptionId=");
        sb.append(this.subscriptionId);
        sb.append(", addedTime=");
        sb.append(this.addedTime);
        sb.append(", remarks=");
        sb.append(this.remarks);
        sb.append(", server=");
        sb.append(this.server);
        sb.append(", serverPort=");
        sb.append(this.serverPort);
        sb.append(", password=");
        sb.append(this.password);
        sb.append(", method=");
        sb.append(this.method);
        sb.append(", flow=");
        sb.append(this.flow);
        sb.append(", username=");
        sb.append(this.username);
        sb.append(", network=");
        sb.append(this.network);
        sb.append(", headerType=");
        sb.append(this.headerType);
        sb.append(", host=");
        sb.append(this.host);
        sb.append(", path=");
        sb.append(this.path);
        sb.append(", seed=");
        sb.append(this.seed);
        sb.append(", quicSecurity=");
        sb.append(this.quicSecurity);
        sb.append(", quicKey=");
        sb.append(this.quicKey);
        sb.append(", mode=");
        sb.append(this.mode);
        sb.append(", serviceName=");
        sb.append(this.serviceName);
        sb.append(", authority=");
        sb.append(this.authority);
        sb.append(", xhttpMode=");
        sb.append(this.xhttpMode);
        sb.append(", xhttpExtra=");
        sb.append(this.xhttpExtra);
        sb.append(", security=");
        sb.append(this.security);
        sb.append(", sni=");
        sb.append(this.sni);
        sb.append(", alpn=");
        sb.append(this.alpn);
        sb.append(", fingerPrint=");
        sb.append(this.fingerPrint);
        sb.append(", insecure=");
        sb.append(this.insecure);
        sb.append(", publicKey=");
        sb.append(this.publicKey);
        sb.append(", shortId=");
        sb.append(this.shortId);
        sb.append(", spiderX=");
        sb.append(this.spiderX);
        sb.append(", secretKey=");
        sb.append(this.secretKey);
        sb.append(", preSharedKey=");
        sb.append(this.preSharedKey);
        sb.append(", localAddress=");
        sb.append(this.localAddress);
        sb.append(", reserved=");
        sb.append(this.reserved);
        sb.append(", mtu=");
        sb.append(this.mtu);
        sb.append(", obfsPassword=");
        sb.append(this.obfsPassword);
        sb.append(", portHopping=");
        sb.append(this.portHopping);
        sb.append(", portHoppingInterval=");
        sb.append(this.portHoppingInterval);
        sb.append(", pinSHA256=");
        return fb$1.m(sb, this.pinSHA256, ')');
    }
}
