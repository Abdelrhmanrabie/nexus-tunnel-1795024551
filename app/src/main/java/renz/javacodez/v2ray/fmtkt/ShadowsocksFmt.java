package renz.javacodez.v2ray.fmtkt;

import defpackage.e4;
import defpackage.fb$1;
import defpackage.g;
import defpackage.he;
import defpackage.q31;
import defpackage.uq;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.NetworkType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.V2rayConfig;
import renz.javacodez.v2ray.extension._ExtKt;
import renz.javacodez.v2ray.plugin.PluginContract;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ShadowsocksFmt extends FmtBase {
    public static final ShadowsocksFmt INSTANCE = new ShadowsocksFmt();

    private ShadowsocksFmt() {
    }

    public final ProfileItem parse(String str) {
        ProfileItem sip002 = parseSip002(str);
        return sip002 == null ? parseLegacy(str) : sip002;
    }

    public final ProfileItem parseLegacy(String str) {
        String strDecode;
        ProfileItem.Companion companion = ProfileItem.Companion;
        EConfigType eConfigType = EConfigType.SHADOWSOCKS;
        ProfileItem profileItemCreate = companion.create(eConfigType);
        String strB0 = q31.b0(str, eConfigType.getProtocolScheme(), AppConfig.CUSTOM);
        int iK0 = q31.k0(strB0, "#", 0, 6);
        if (iK0 > 0) {
            try {
                profileItemCreate.setRemarks(Utils.INSTANCE.urlDecode(strB0.substring(iK0 + 1, strB0.length())));
            } catch (Exception e) {
                e.printStackTrace();
            }
            strB0 = strB0.substring(0, iK0);
        }
        int iK1 = q31.k0(strB0, "@", 0, 6);
        if (iK1 > 0) {
            strDecode = Utils.INSTANCE.decode(strB0.substring(0, iK1)) + strB0.substring(iK1, strB0.length());
        } else {
            strDecode = Utils.INSTANCE.decode(strB0);
        }
        Matcher matcher = Pattern.compile("^(.+?):(.*)@(.+?):(\\d+?)/?$").matcher(strDecode);
        g gVar = !matcher.matches() ? null : new g(14, (Object) matcher, false);
        if (gVar == null) {
            return null;
        }
        String strSubstring = (String) gVar.a().get(3);
        if (strSubstring.length() >= 2) {
            if ((fb$1.m(strSubstring) ? strSubstring.startsWith("[") : q31.o0(strSubstring, false, "[", 0, 1)) && strSubstring.endsWith("]")) {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
            }
        }
        profileItemCreate.setServer(strSubstring);
        profileItemCreate.setServerPort((String) gVar.a().get(4));
        profileItemCreate.setPassword((String) gVar.a().get(2));
        profileItemCreate.setMethod(((String) gVar.a().get(1)).toLowerCase(Locale.ROOT));
        return profileItemCreate;
    }

    public final ProfileItem parseSip002(String str) {
        String userInfo;
        Map<String, String> queryParam;
        String str2;
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.SHADOWSOCKS);
        Utils utils = Utils.INSTANCE;
        URI uri = new URI(utils.fixIllegalUrl(str));
        if (_ExtKt.getIdnHost(uri).length() == 0 || uri.getPort() <= 0 || (userInfo = uri.getUserInfo()) == null || userInfo.length() == 0) {
            return null;
        }
        String fragment = uri.getFragment();
        if (fragment == null) {
            fragment = AppConfig.CUSTOM;
        }
        profileItemCreate.setRemarks(utils.urlDecode(fragment));
        profileItemCreate.setServer(_ExtKt.getIdnHost(uri));
        profileItemCreate.setServerPort(String.valueOf(uri.getPort()));
        List listS0 = q31.e0(uri.getUserInfo(), ":") ? q31.s0(uri.getUserInfo(), new String[]{":"}, 2) : q31.s0(utils.decode(uri.getUserInfo()), new String[]{":"}, 2);
        if (listS0.size() == 2) {
            profileItemCreate.setMethod((String) he.K0(listS0));
            profileItemCreate.setPassword((String) he.T0(listS0));
        }
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() != 0 && (str2 = (queryParam = getQueryParam(uri)).get(PluginContract.SCHEME)) != null && q31.e0(str2, "obfs=http")) {
            HashMap map = new HashMap();
            String str3 = queryParam.get(PluginContract.SCHEME);
            Iterator it = (str3 != null ? q31.s0(str3, new String[]{";"}, 6) : uq.b).iterator();
            while (it.hasNext()) {
                List listS1 = q31.s0((String) it.next(), new String[]{"="}, 6);
                if (listS1.size() == 2) {
                    map.put(he.K0(listS1), he.T0(listS1));
                }
            }
            profileItemCreate.setNetwork(NetworkType.TCP.getType());
            profileItemCreate.setHeaderType(AppConfig.HEADER_TYPE_HTTP);
            profileItemCreate.setHost((String) map.get("obfs-host"));
            profileItemCreate.setPath((String) map.get(PluginContract.COLUMN_PATH));
        }
        return profileItemCreate;
    }

    public final V2rayConfig.OutboundBean toOutbound(ProfileItem profileItem) {
        String sni;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings2;
        V2rayConfig.OutboundBean.OutSettingsBean settings;
        List<V2rayConfig.OutboundBean.OutSettingsBean.ServersBean> servers;
        V2rayConfig.OutboundBean.OutSettingsBean.ServersBean serversBean;
        V2rayConfig.OutboundBean outboundBeanCreate = V2rayConfig.OutboundBean.Companion.create(EConfigType.SHADOWSOCKS);
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
            serversBean.setMethod(profileItem.getMethod());
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
        return toUri(profileItem, Utils.INSTANCE.encode(profileItem.getMethod() + ':' + profileItem.getPassword()), null);
    }
}
