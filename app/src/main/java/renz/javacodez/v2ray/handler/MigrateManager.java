package renz.javacodez.v2ray.handler;

import com.tencent.mmkv.MMKV;
import defpackage.e4;
import defpackage.he;
import defpackage.q31;
import defpackage.rc0;
import defpackage.uh0;
import defpackage.v41;
import java.util.List;
import java.util.Locale;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.NetworkType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.ServerConfig;
import renz.javacodez.v2ray.dto.V2rayConfig;
import renz.javacodez.v2ray.util.JsonUtil;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MigrateManager {
    private static final String ID_SERVER_CONFIG = "SERVER_CONFIG";
    public static final MigrateManager INSTANCE = new MigrateManager();
    private static final rc0 serverStorage$delegate;

    static {
        int i = 0;
        serverStorage$delegate = new v41(new uh0(i, i));
    }

    private MigrateManager() {
    }

    private final ServerConfig decodeServerConfigOld(String str) {
        String strDecodeString;
        if (q31.m0(str) || (strDecodeString = getServerStorage().decodeString(str)) == null || q31.m0(strDecodeString)) {
            return null;
        }
        return (ServerConfig) JsonUtil.INSTANCE.fromJson(strDecodeString, ServerConfig.class);
    }

    private final MMKV getServerStorage() {
        return (MMKV) serverStorage$delegate.getValue();
    }

    private final ProfileItem migrate2ProfileCommon(ServerConfig serverConfig) {
        String flow;
        List<V2rayConfig.OutboundBean.OutSettingsBean.ServersBean> servers;
        V2rayConfig.OutboundBean.OutSettingsBean.ServersBean serversBean;
        String type;
        V2rayConfig.OutboundBean.StreamSettingsBean.TlsSettingsBean tlsSettings;
        List<String> alpn;
        V2rayConfig.OutboundBean.StreamSettingsBean.GrpcSettingsBean grpcSettings;
        V2rayConfig.OutboundBean.StreamSettingsBean.GrpcSettingsBean grpcSettings2;
        V2rayConfig.OutboundBean.StreamSettingsBean.GrpcSettingsBean grpcSettings3;
        V2rayConfig.OutboundBean.StreamSettingsBean.QuicSettingBean quicSettings;
        V2rayConfig.OutboundBean.StreamSettingsBean.QuicSettingBean quicSettings2;
        V2rayConfig.OutboundBean.StreamSettingsBean.KcpSettingsBean kcpSettings;
        List<V2rayConfig.OutboundBean.OutSettingsBean.VnextBean> vnext;
        V2rayConfig.OutboundBean.OutSettingsBean.VnextBean vnextBean;
        List<V2rayConfig.OutboundBean.OutSettingsBean.VnextBean.UsersBean> users;
        V2rayConfig.OutboundBean.OutSettingsBean.VnextBean.UsersBean usersBean;
        ProfileItem profileItemCreate = ProfileItem.Companion.create(serverConfig.getConfigType());
        V2rayConfig.OutboundBean proxyOutbound = serverConfig.getProxyOutbound();
        if (proxyOutbound == null) {
            return null;
        }
        profileItemCreate.setRemarks(serverConfig.getRemarks());
        profileItemCreate.setServer(proxyOutbound.getServerAddress());
        profileItemCreate.setServerPort(String.valueOf(proxyOutbound.getServerPort()));
        profileItemCreate.setMethod(proxyOutbound.getSecurityEncryption());
        profileItemCreate.setPassword(proxyOutbound.getPassword());
        V2rayConfig.OutboundBean.OutSettingsBean settings = proxyOutbound.getSettings();
        if (settings == null || (vnext = settings.getVnext()) == null || (vnextBean = (V2rayConfig.OutboundBean.OutSettingsBean.VnextBean) he.K0(vnext)) == null || (users = vnextBean.getUsers()) == null || (usersBean = (V2rayConfig.OutboundBean.OutSettingsBean.VnextBean.UsersBean) he.K0(users)) == null || (flow = usersBean.getFlow()) == null) {
            V2rayConfig.OutboundBean.OutSettingsBean settings2 = proxyOutbound.getSettings();
            flow = (settings2 == null || (servers = settings2.getServers()) == null || (serversBean = (V2rayConfig.OutboundBean.OutSettingsBean.ServersBean) he.K0(servers)) == null) ? null : serversBean.getFlow();
        }
        profileItemCreate.setFlow(flow);
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings = proxyOutbound.getStreamSettings();
        if (streamSettings == null || (type = streamSettings.getNetwork()) == null) {
            type = NetworkType.TCP.getType();
        }
        profileItemCreate.setNetwork(type);
        List<String> transportSettingDetails = proxyOutbound.getTransportSettingDetails();
        boolean zA = false;
        if (transportSettingDetails != null) {
            String str = transportSettingDetails.get(0);
            String str2 = AppConfig.CUSTOM;
            if (str == null) {
                str = AppConfig.CUSTOM;
            }
            profileItemCreate.setHeaderType(str);
            String str3 = transportSettingDetails.get(1);
            if (str3 == null) {
                str3 = AppConfig.CUSTOM;
            }
            profileItemCreate.setHost(str3);
            String str4 = transportSettingDetails.get(2);
            if (str4 != null) {
                str2 = str4;
            }
            profileItemCreate.setPath(str2);
        }
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings2 = proxyOutbound.getStreamSettings();
        profileItemCreate.setSeed((streamSettings2 == null || (kcpSettings = streamSettings2.getKcpSettings()) == null) ? null : kcpSettings.getSeed());
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings3 = proxyOutbound.getStreamSettings();
        profileItemCreate.setQuicSecurity((streamSettings3 == null || (quicSettings2 = streamSettings3.getQuicSettings()) == null) ? null : quicSettings2.getSecurity());
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings4 = proxyOutbound.getStreamSettings();
        profileItemCreate.setQuicKey((streamSettings4 == null || (quicSettings = streamSettings4.getQuicSettings()) == null) ? null : quicSettings.getKey());
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings5 = proxyOutbound.getStreamSettings();
        if (streamSettings5 != null && (grpcSettings3 = streamSettings5.getGrpcSettings()) != null) {
            zA = e4.a(grpcSettings3.getMultiMode(), Boolean.TRUE);
        }
        profileItemCreate.setMode(zA ? "multi" : "gun");
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings6 = proxyOutbound.getStreamSettings();
        profileItemCreate.setServiceName((streamSettings6 == null || (grpcSettings2 = streamSettings6.getGrpcSettings()) == null) ? null : grpcSettings2.getServiceName());
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings7 = proxyOutbound.getStreamSettings();
        profileItemCreate.setAuthority((streamSettings7 == null || (grpcSettings = streamSettings7.getGrpcSettings()) == null) ? null : grpcSettings.getAuthority());
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings8 = proxyOutbound.getStreamSettings();
        profileItemCreate.setSecurity(streamSettings8 != null ? streamSettings8.getSecurity() : null);
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings9 = proxyOutbound.getStreamSettings();
        if (streamSettings9 == null || (tlsSettings = streamSettings9.getRealitySettings()) == null) {
            V2rayConfig.OutboundBean.StreamSettingsBean streamSettings10 = proxyOutbound.getStreamSettings();
            tlsSettings = streamSettings10 != null ? streamSettings10.getTlsSettings() : null;
        }
        profileItemCreate.setInsecure(tlsSettings != null ? Boolean.valueOf(tlsSettings.getAllowInsecure()) : null);
        profileItemCreate.setSni(tlsSettings != null ? tlsSettings.getServerName() : null);
        profileItemCreate.setFingerPrint(tlsSettings != null ? tlsSettings.getFingerprint() : null);
        profileItemCreate.setAlpn(String.valueOf(Utils.INSTANCE.removeWhiteSpace((tlsSettings == null || (alpn = tlsSettings.getAlpn()) == null) ? null : he.R0(alpn, ",", null, null, null, 62))));
        profileItemCreate.setPublicKey(tlsSettings != null ? tlsSettings.getPublicKey() : null);
        profileItemCreate.setShortId(tlsSettings != null ? tlsSettings.getShortId() : null);
        profileItemCreate.setSpiderX(tlsSettings != null ? tlsSettings.getSpiderX() : null);
        return profileItemCreate;
    }

    private final ProfileItem migrate2ProfileCustom(ServerConfig serverConfig) {
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.CUSTOM);
        V2rayConfig.OutboundBean proxyOutbound = serverConfig.getProxyOutbound();
        if (proxyOutbound == null) {
            return null;
        }
        profileItemCreate.setRemarks(serverConfig.getRemarks());
        profileItemCreate.setServer(proxyOutbound.getServerAddress());
        profileItemCreate.setServerPort(String.valueOf(proxyOutbound.getServerPort()));
        return profileItemCreate;
    }

    private final ProfileItem migrate2ProfileHttp(ServerConfig serverConfig) {
        List<V2rayConfig.OutboundBean.OutSettingsBean.ServersBean> servers;
        V2rayConfig.OutboundBean.OutSettingsBean.ServersBean serversBean;
        List<V2rayConfig.OutboundBean.OutSettingsBean.ServersBean.SocksUsersBean> users;
        V2rayConfig.OutboundBean.OutSettingsBean.ServersBean.SocksUsersBean socksUsersBean;
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.HTTP);
        V2rayConfig.OutboundBean proxyOutbound = serverConfig.getProxyOutbound();
        String user = null;
        if (proxyOutbound == null) {
            return null;
        }
        profileItemCreate.setRemarks(serverConfig.getRemarks());
        profileItemCreate.setServer(proxyOutbound.getServerAddress());
        profileItemCreate.setServerPort(String.valueOf(proxyOutbound.getServerPort()));
        V2rayConfig.OutboundBean.OutSettingsBean settings = proxyOutbound.getSettings();
        if (settings != null && (servers = settings.getServers()) != null && (serversBean = (V2rayConfig.OutboundBean.OutSettingsBean.ServersBean) he.K0(servers)) != null && (users = serversBean.getUsers()) != null && (socksUsersBean = (V2rayConfig.OutboundBean.OutSettingsBean.ServersBean.SocksUsersBean) he.K0(users)) != null) {
            user = socksUsersBean.getUser();
        }
        profileItemCreate.setUsername(user);
        profileItemCreate.setPassword(proxyOutbound.getPassword());
        return profileItemCreate;
    }

    private final ProfileItem migrate2ProfileHysteria2(ServerConfig serverConfig) {
        V2rayConfig.OutboundBean.StreamSettingsBean.TlsSettingsBean tlsSettings;
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.HYSTERIA2);
        V2rayConfig.OutboundBean proxyOutbound = serverConfig.getProxyOutbound();
        if (proxyOutbound == null) {
            return null;
        }
        profileItemCreate.setRemarks(serverConfig.getRemarks());
        profileItemCreate.setServer(proxyOutbound.getServerAddress());
        profileItemCreate.setServerPort(String.valueOf(proxyOutbound.getServerPort()));
        profileItemCreate.setPassword(proxyOutbound.getPassword());
        profileItemCreate.setSecurity(AppConfig.TLS);
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings = proxyOutbound.getStreamSettings();
        if (streamSettings != null && (tlsSettings = streamSettings.getTlsSettings()) != null) {
            profileItemCreate.setInsecure(Boolean.valueOf(tlsSettings.getAllowInsecure()));
            profileItemCreate.setSni(tlsSettings.getServerName());
            Utils utils = Utils.INSTANCE;
            List<String> alpn = tlsSettings.getAlpn();
            String strRemoveWhiteSpace = utils.removeWhiteSpace(alpn != null ? he.R0(alpn, ",", null, null, null, 62) : null);
            if (strRemoveWhiteSpace == null) {
                strRemoveWhiteSpace = AppConfig.CUSTOM;
            }
            profileItemCreate.setAlpn(strRemoveWhiteSpace);
        }
        V2rayConfig.OutboundBean.OutSettingsBean settings = proxyOutbound.getSettings();
        profileItemCreate.setObfsPassword(settings != null ? settings.getObfsPassword() : null);
        return profileItemCreate;
    }

    private final ProfileItem migrate2ProfileSocks(ServerConfig serverConfig) {
        List<V2rayConfig.OutboundBean.OutSettingsBean.ServersBean> servers;
        V2rayConfig.OutboundBean.OutSettingsBean.ServersBean serversBean;
        List<V2rayConfig.OutboundBean.OutSettingsBean.ServersBean.SocksUsersBean> users;
        V2rayConfig.OutboundBean.OutSettingsBean.ServersBean.SocksUsersBean socksUsersBean;
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.SOCKS);
        V2rayConfig.OutboundBean proxyOutbound = serverConfig.getProxyOutbound();
        String user = null;
        if (proxyOutbound == null) {
            return null;
        }
        profileItemCreate.setRemarks(serverConfig.getRemarks());
        profileItemCreate.setServer(proxyOutbound.getServerAddress());
        profileItemCreate.setServerPort(String.valueOf(proxyOutbound.getServerPort()));
        V2rayConfig.OutboundBean.OutSettingsBean settings = proxyOutbound.getSettings();
        if (settings != null && (servers = settings.getServers()) != null && (serversBean = (V2rayConfig.OutboundBean.OutSettingsBean.ServersBean) he.K0(servers)) != null && (users = serversBean.getUsers()) != null && (socksUsersBean = (V2rayConfig.OutboundBean.OutSettingsBean.ServersBean.SocksUsersBean) he.K0(users)) != null) {
            user = socksUsersBean.getUser();
        }
        profileItemCreate.setUsername(user);
        profileItemCreate.setPassword(proxyOutbound.getPassword());
        return profileItemCreate;
    }

    private final ProfileItem migrate2ProfileWireguard(ServerConfig serverConfig) {
        V2rayConfig.OutboundBean.OutSettingsBean.WireGuardBean wireGuardBean;
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.WIREGUARD);
        V2rayConfig.OutboundBean proxyOutbound = serverConfig.getProxyOutbound();
        if (proxyOutbound == null) {
            return null;
        }
        profileItemCreate.setRemarks(serverConfig.getRemarks());
        profileItemCreate.setServer(proxyOutbound.getServerAddress());
        profileItemCreate.setServerPort(String.valueOf(proxyOutbound.getServerPort()));
        V2rayConfig.OutboundBean.OutSettingsBean settings = proxyOutbound.getSettings();
        if (settings != null) {
            profileItemCreate.setSecretKey(settings.getSecretKey());
            Utils utils = Utils.INSTANCE;
            profileItemCreate.setLocalAddress(String.valueOf(utils.removeWhiteSpace(he.R0((List) settings.getAddress(), ",", null, null, null, 62))));
            List<V2rayConfig.OutboundBean.OutSettingsBean.WireGuardBean> peers = settings.getPeers();
            profileItemCreate.setPublicKey((peers == null || (wireGuardBean = (V2rayConfig.OutboundBean.OutSettingsBean.WireGuardBean) he.N0(peers, 0)) == null) ? null : wireGuardBean.getPublicKey());
            profileItemCreate.setMtu(settings.getMtu());
            List<Integer> reserved = settings.getReserved();
            profileItemCreate.setReserved(String.valueOf(utils.removeWhiteSpace(reserved != null ? he.R0(reserved, ",", null, null, null, 62) : null)));
        }
        return profileItemCreate;
    }

    private final ProfileItem migrateServerConfig2ProfileSub(ServerConfig serverConfig) {
        V2rayConfig.OutboundBean proxyOutbound = serverConfig.getProxyOutbound();
        String protocol = proxyOutbound != null ? proxyOutbound.getProtocol() : null;
        Locale locale = Locale.ROOT;
        if (e4.a(protocol, "VMESS".toLowerCase(locale)) || e4.a(protocol, "VLESS".toLowerCase(locale)) || e4.a(protocol, "TROJAN".toLowerCase(locale)) || e4.a(protocol, "SHADOWSOCKS".toLowerCase(locale))) {
            return migrate2ProfileCommon(serverConfig);
        }
        if (e4.a(protocol, "SOCKS".toLowerCase(locale))) {
            return migrate2ProfileSocks(serverConfig);
        }
        if (e4.a(protocol, "HTTP".toLowerCase(locale))) {
            return migrate2ProfileHttp(serverConfig);
        }
        if (e4.a(protocol, "WIREGUARD".toLowerCase(locale))) {
            return migrate2ProfileWireguard(serverConfig);
        }
        if (e4.a(protocol, "HYSTERIA2".toLowerCase(locale))) {
            return migrate2ProfileHysteria2(serverConfig);
        }
        if (e4.a(protocol, "CUSTOM".toLowerCase(locale))) {
            return migrate2ProfileCustom(serverConfig);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV serverStorage_delegate$lambda$0() {
        return MMKV.mmkvWithID(ID_SERVER_CONFIG, 2);
    }
}
