package renz.javacodez.v2ray.fmtkt;

import defpackage.ak;
import defpackage.e4;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.Hysteria2Bean;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.V2rayConfig;
import renz.javacodez.v2ray.extension._ExtKt;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class Hysteria2Fmt extends FmtBase {
    public static final Hysteria2Fmt INSTANCE = new Hysteria2Fmt();

    private Hysteria2Fmt() {
    }

    public final ProfileItem parse(String str) {
        Boolean boolValueOf;
        boolean zDecodeSettingsBool = MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_ALLOW_INSECURE, false);
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.HYSTERIA2);
        Utils utils = Utils.INSTANCE;
        URI uri = new URI(utils.fixIllegalUrl(str));
        String fragment = uri.getFragment();
        String str2 = AppConfig.CUSTOM;
        if (fragment == null) {
            fragment = AppConfig.CUSTOM;
        }
        profileItemCreate.setRemarks(utils.urlDecode(fragment));
        profileItemCreate.setServer(_ExtKt.getIdnHost(uri));
        profileItemCreate.setServerPort(String.valueOf(uri.getPort()));
        profileItemCreate.setPassword(uri.getUserInfo());
        String str3 = AppConfig.TLS;
        profileItemCreate.setSecurity(AppConfig.TLS);
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() != 0) {
            Map<String, String> queryParam = getQueryParam(uri);
            String str4 = queryParam.get("security");
            if (str4 != null) {
                str3 = str4;
            }
            profileItemCreate.setSecurity(str3);
            String str5 = queryParam.get("insecure");
            if (str5 == null || str5.length() == 0) {
                boolValueOf = Boolean.valueOf(zDecodeSettingsBool);
            } else {
                String str6 = queryParam.get("insecure");
                if (str6 != null) {
                    str2 = str6;
                }
                boolValueOf = Boolean.valueOf(str2.equals("1"));
            }
            profileItemCreate.setInsecure(boolValueOf);
            profileItemCreate.setSni(queryParam.get("sni"));
            profileItemCreate.setAlpn(queryParam.get("alpn"));
            profileItemCreate.setObfsPassword(queryParam.get("obfs-password"));
            profileItemCreate.setPortHopping(queryParam.get("mport"));
            profileItemCreate.setPinSHA256(queryParam.get("pinSHA256"));
        }
        return profileItemCreate;
    }

    public final Hysteria2Bean toNativeConfig(ProfileItem profileItem, int i) {
        Hysteria2Bean.TransportBean transportBean;
        String serverAddressAndPort;
        String obfsPassword = profileItem.getObfsPassword();
        String pinSHA256 = null;
        Hysteria2Bean.ObfsBean obfsBean = obfsPassword == null || obfsPassword.length() == 0 ? null : new Hysteria2Bean.ObfsBean("salamander", new Hysteria2Bean.ObfsBean.SalamanderBean(profileItem.getObfsPassword()));
        String portHopping = profileItem.getPortHopping();
        if (portHopping == null || portHopping.length() == 0) {
            transportBean = null;
        } else {
            String portHoppingInterval = profileItem.getPortHoppingInterval();
            if (portHoppingInterval == null) {
                portHoppingInterval = "30";
            }
            transportBean = new Hysteria2Bean.TransportBean("udp", new Hysteria2Bean.TransportBean.TransportUdpBean(portHoppingInterval.concat("s")));
        }
        String portHopping2 = profileItem.getPortHopping();
        if (portHopping2 == null || portHopping2.length() == 0) {
            serverAddressAndPort = profileItem.getServerAddressAndPort();
        } else {
            serverAddressAndPort = Utils.INSTANCE.getIpv6Address(profileItem.getServer()) + ':' + profileItem.getPortHopping();
        }
        String str = serverAddressAndPort;
        String password = profileItem.getPassword();
        Hysteria2Bean.Socks5Bean socks5Bean = new Hysteria2Bean.Socks5Bean(ak.h(i, "127.0.0.1:"));
        Hysteria2Bean.Socks5Bean socks5Bean2 = new Hysteria2Bean.Socks5Bean(ak.h(i, "127.0.0.1:"));
        String sni = profileItem.getSni();
        if (sni == null) {
            sni = profileItem.getServer();
        }
        Boolean insecure = profileItem.getInsecure();
        String pinSHA257 = profileItem.getPinSHA256();
        if (pinSHA257 != null && pinSHA257.length() != 0) {
            pinSHA256 = profileItem.getPinSHA256();
        }
        return new Hysteria2Bean(str, password, null, obfsBean, socks5Bean, socks5Bean2, new Hysteria2Bean.TlsBean(sni, insecure, pinSHA256), transportBean, 4, null);
    }

    public final V2rayConfig.OutboundBean toOutbound(ProfileItem profileItem) {
        return V2rayConfig.OutboundBean.Companion.create(EConfigType.HYSTERIA2);
    }

    public final String toUri(ProfileItem profileItem) {
        HashMap<String, String> map = new HashMap<>();
        String security = profileItem.getSecurity();
        if (security != null) {
            map.put("security", security);
        }
        String sni = profileItem.getSni();
        boolean z = sni != null && sni.length() > 0;
        String str = AppConfig.CUSTOM;
        if (z) {
            if (sni == null) {
                sni = AppConfig.CUSTOM;
            }
            map.put("sni", sni);
        }
        String alpn = profileItem.getAlpn();
        if (alpn != null && alpn.length() > 0) {
            map.put("alpn", alpn);
        }
        map.put("insecure", e4.a(profileItem.getInsecure(), Boolean.TRUE) ? "1" : "0");
        String obfsPassword = profileItem.getObfsPassword();
        if (obfsPassword != null && obfsPassword.length() > 0) {
            map.put("obfs", "salamander");
            String obfsPassword2 = profileItem.getObfsPassword();
            if (obfsPassword2 == null) {
                obfsPassword2 = AppConfig.CUSTOM;
            }
            map.put("obfs-password", obfsPassword2);
        }
        String portHopping = profileItem.getPortHopping();
        if (portHopping != null && portHopping.length() > 0) {
            String portHopping2 = profileItem.getPortHopping();
            if (portHopping2 == null) {
                portHopping2 = AppConfig.CUSTOM;
            }
            map.put("mport", portHopping2);
        }
        String pinSHA256 = profileItem.getPinSHA256();
        if (pinSHA256 != null && pinSHA256.length() > 0) {
            String pinSHA257 = profileItem.getPinSHA256();
            if (pinSHA257 != null) {
                str = pinSHA257;
            }
            map.put("pinSHA256", str);
        }
        return toUri(profileItem, profileItem.getPassword(), map);
    }
}
