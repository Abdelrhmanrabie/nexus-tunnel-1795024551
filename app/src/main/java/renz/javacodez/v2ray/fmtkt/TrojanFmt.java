package renz.javacodez.v2ray.fmtkt;

import defpackage.e4;
import defpackage.he;
import java.net.URI;
import java.util.List;
import java.util.Map;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.NetworkType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.V2rayConfig;
import renz.javacodez.v2ray.extension._ExtKt;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class TrojanFmt extends FmtBase {
    public static final TrojanFmt INSTANCE = new TrojanFmt();

    private TrojanFmt() {
    }

    public final ProfileItem parse(String str) {
        boolean zDecodeSettingsBool = MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_ALLOW_INSECURE, false);
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.TROJAN);
        Utils utils = Utils.INSTANCE;
        URI uri = new URI(utils.fixIllegalUrl(str));
        String fragment = uri.getFragment();
        if (fragment == null) {
            fragment = AppConfig.CUSTOM;
        }
        profileItemCreate.setRemarks(utils.urlDecode(fragment));
        profileItemCreate.setServer(_ExtKt.getIdnHost(uri));
        profileItemCreate.setServerPort(String.valueOf(uri.getPort()));
        profileItemCreate.setPassword(uri.getUserInfo());
        String rawQuery = uri.getRawQuery();
        boolean z = rawQuery == null || rawQuery.length() == 0;
        String str2 = AppConfig.TLS;
        if (z) {
            profileItemCreate.setNetwork(NetworkType.TCP.getType());
            profileItemCreate.setSecurity(AppConfig.TLS);
            profileItemCreate.setInsecure(Boolean.valueOf(zDecodeSettingsBool));
            return profileItemCreate;
        }
        Map<String, String> queryParam = getQueryParam(uri);
        getItemFormQuery(profileItemCreate, queryParam, zDecodeSettingsBool);
        String str3 = queryParam.get("security");
        if (str3 != null) {
            str2 = str3;
        }
        profileItemCreate.setSecurity(str2);
        return profileItemCreate;
    }

    public final V2rayConfig.OutboundBean toOutbound(ProfileItem profileItem) {
        String sni;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings2;
        V2rayConfig.OutboundBean.OutSettingsBean settings;
        List<V2rayConfig.OutboundBean.OutSettingsBean.ServersBean> servers;
        V2rayConfig.OutboundBean.OutSettingsBean.ServersBean serversBean;
        V2rayConfig.OutboundBean outboundBeanCreate = V2rayConfig.OutboundBean.Companion.create(EConfigType.TROJAN);
        if (outboundBeanCreate != null && (settings = outboundBeanCreate.getSettings()) != null && (servers = settings.getServers()) != null && (serversBean = (V2rayConfig.OutboundBean.OutSettingsBean.ServersBean) he.K0(servers)) != null) {
            String server = profileItem.getServer();
            if (server == null) {
                server = AppConfig.CUSTOM;
            }
            serversBean.setAddress(server);
            String serverPort = profileItem.getServerPort();
            if (serverPort == null) {
                serverPort = AppConfig.CUSTOM;
            }
            serversBean.setPort(Integer.parseInt(serverPort));
            serversBean.setPassword(profileItem.getPassword());
            serversBean.setFlow(profileItem.getFlow());
        }
        if (outboundBeanCreate == null || (streamSettings2 = outboundBeanCreate.getStreamSettings()) == null) {
            sni = null;
        } else {
            String network = profileItem.getNetwork();
            sni = streamSettings2.populateTransportSettings(network == null ? AppConfig.CUSTOM : network, profileItem.getHeaderType(), profileItem.getHost(), profileItem.getPath(), profileItem.getSeed(), profileItem.getQuicSecurity(), profileItem.getQuicKey(), profileItem.getMode(), profileItem.getServiceName(), profileItem.getAuthority());
        }
        if (outboundBeanCreate != null && (streamSettings = outboundBeanCreate.getStreamSettings()) != null) {
            String security = profileItem.getSecurity();
            if (security == null) {
                security = AppConfig.CUSTOM;
            }
            boolean zA = e4.a(profileItem.getInsecure(), Boolean.TRUE);
            String sni2 = profileItem.getSni();
            if (sni2 != null && sni2.length() != 0) {
                sni = profileItem.getSni();
            }
            streamSettings.populateTlsSettings(security, zA, sni, profileItem.getFingerPrint(), profileItem.getAlpn(), profileItem.getPublicKey(), profileItem.getShortId(), profileItem.getSpiderX());
        }
        return outboundBeanCreate;
    }

    public final String toUri(ProfileItem profileItem) {
        return toUri(profileItem, profileItem.getPassword(), getQueryDic(profileItem));
    }
}
