package renz.javacodez.v2ray.fmtkt;

import defpackage.e4;
import defpackage.he;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.V2rayConfig;
import renz.javacodez.v2ray.extension._ExtKt;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.util.JsonUtil;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class VlessFmt extends FmtBase {
    public static final VlessFmt INSTANCE = new VlessFmt();

    private VlessFmt() {
    }

    public final ProfileItem parse(String str) {
        boolean zDecodeSettingsBool = MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_ALLOW_INSECURE, false);
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.VLESS);
        Utils utils = Utils.INSTANCE;
        URI uri = new URI(utils.fixIllegalUrl(str));
        String rawQuery = uri.getRawQuery();
        if (rawQuery == null || rawQuery.length() == 0) {
            return null;
        }
        Map<String, String> queryParam = getQueryParam(uri);
        String fragment = uri.getFragment();
        if (fragment == null) {
            fragment = AppConfig.CUSTOM;
        }
        profileItemCreate.setRemarks(utils.urlDecode(fragment));
        profileItemCreate.setServer(_ExtKt.getIdnHost(uri));
        profileItemCreate.setServerPort(String.valueOf(uri.getPort()));
        profileItemCreate.setPassword(uri.getUserInfo());
        String str2 = queryParam.get("encryption");
        if (str2 == null) {
            str2 = "none";
        }
        profileItemCreate.setMethod(str2);
        getItemFormQuery(profileItemCreate, queryParam, zDecodeSettingsBool);
        return profileItemCreate;
    }

    public final V2rayConfig.OutboundBean toOutbound(ProfileItem profileItem) {
        String sni;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings2;
        V2rayConfig.OutboundBean.StreamSettingsBean.XhttpSettingsBean xhttpSettings;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings3;
        V2rayConfig.OutboundBean.StreamSettingsBean.XhttpSettingsBean xhttpSettings2;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings4;
        V2rayConfig.OutboundBean.OutSettingsBean settings;
        List<V2rayConfig.OutboundBean.OutSettingsBean.VnextBean> vnext;
        V2rayConfig.OutboundBean.OutSettingsBean.VnextBean vnextBean;
        V2rayConfig.OutboundBean outboundBeanCreate = V2rayConfig.OutboundBean.Companion.create(EConfigType.VLESS);
        if (outboundBeanCreate != null && (settings = outboundBeanCreate.getSettings()) != null && (vnext = settings.getVnext()) != null && (vnextBean = (V2rayConfig.OutboundBean.OutSettingsBean.VnextBean) he.K0(vnext)) != null) {
            String server = profileItem.getServer();
            if (server == null) {
                server = AppConfig.CUSTOM;
            }
            vnextBean.setAddress(server);
            String serverPort = profileItem.getServerPort();
            if (serverPort == null) {
                serverPort = AppConfig.CUSTOM;
            }
            vnextBean.setPort(Integer.parseInt(serverPort));
            V2rayConfig.OutboundBean.OutSettingsBean.VnextBean.UsersBean usersBean = vnextBean.getUsers().get(0);
            String password = profileItem.getPassword();
            if (password == null) {
                password = AppConfig.CUSTOM;
            }
            usersBean.setId(password);
            vnextBean.getUsers().get(0).setEncryption(profileItem.getMethod());
            vnextBean.getUsers().get(0).setFlow(profileItem.getFlow());
        }
        if (outboundBeanCreate == null || (streamSettings4 = outboundBeanCreate.getStreamSettings()) == null) {
            sni = null;
        } else {
            String network = profileItem.getNetwork();
            sni = streamSettings4.populateTransportSettings(network == null ? AppConfig.CUSTOM : network, profileItem.getHeaderType(), profileItem.getHost(), profileItem.getPath(), profileItem.getSeed(), profileItem.getQuicSecurity(), profileItem.getQuicKey(), profileItem.getMode(), profileItem.getServiceName(), profileItem.getAuthority());
        }
        if (outboundBeanCreate != null && (streamSettings3 = outboundBeanCreate.getStreamSettings()) != null && (xhttpSettings2 = streamSettings3.getXhttpSettings()) != null) {
            xhttpSettings2.setMode(profileItem.getXhttpMode());
        }
        if (outboundBeanCreate != null && (streamSettings2 = outboundBeanCreate.getStreamSettings()) != null && (xhttpSettings = streamSettings2.getXhttpSettings()) != null) {
            xhttpSettings.setExtra(JsonUtil.INSTANCE.parseString(profileItem.getXhttpExtra()));
        }
        if (outboundBeanCreate != null && (streamSettings = outboundBeanCreate.getStreamSettings()) != null) {
            String security = profileItem.getSecurity();
            String str = security == null ? AppConfig.CUSTOM : security;
            boolean zA = e4.a(profileItem.getInsecure(), Boolean.TRUE);
            String sni2 = profileItem.getSni();
            if (sni2 != null && sni2.length() != 0) {
                sni = profileItem.getSni();
            }
            streamSettings.populateTlsSettings(str, zA, sni, profileItem.getFingerPrint(), profileItem.getAlpn(), profileItem.getPublicKey(), profileItem.getShortId(), profileItem.getSpiderX());
        }
        return outboundBeanCreate;
    }

    public final String toUri(ProfileItem profileItem) {
        HashMap<String, String> queryDic = getQueryDic(profileItem);
        String method = profileItem.getMethod();
        if (method == null) {
            method = "none";
        }
        queryDic.put("encryption", method);
        return toUri(profileItem, profileItem.getPassword(), queryDic);
    }
}
