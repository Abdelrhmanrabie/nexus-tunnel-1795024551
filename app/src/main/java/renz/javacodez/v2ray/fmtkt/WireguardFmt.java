package renz.javacodez.v2ray.fmtkt;

import defpackage.ae;
import defpackage.fz0;
import defpackage.ge;
import defpackage.he;
import defpackage.q31;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.V2rayConfig;
import renz.javacodez.v2ray.extension._ExtKt;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class WireguardFmt extends FmtBase {
    public static final WireguardFmt INSTANCE = new WireguardFmt();

    private WireguardFmt() {
    }

    public final ProfileItem parse(String str) {
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.WIREGUARD);
        Utils utils = Utils.INSTANCE;
        URI uri = new URI(utils.fixIllegalUrl(str));
        String rawQuery = uri.getRawQuery();
        if (rawQuery == null || rawQuery.length() == 0) {
            return null;
        }
        Map<String, String> queryParam = getQueryParam(uri);
        String fragment = uri.getFragment();
        String str2 = AppConfig.CUSTOM;
        if (fragment == null) {
            fragment = AppConfig.CUSTOM;
        }
        profileItemCreate.setRemarks(utils.urlDecode(fragment));
        profileItemCreate.setServer(_ExtKt.getIdnHost(uri));
        profileItemCreate.setServerPort(String.valueOf(uri.getPort()));
        String userInfo = uri.getUserInfo();
        if (userInfo == null) {
            userInfo = AppConfig.CUSTOM;
        }
        profileItemCreate.setSecretKey(userInfo);
        String str3 = queryParam.get("address");
        if (str3 == null) {
            str3 = AppConfig.WIREGUARD_LOCAL_ADDRESS_V4;
        }
        profileItemCreate.setLocalAddress(str3);
        String str4 = queryParam.get("publickey");
        if (str4 == null) {
            str4 = AppConfig.CUSTOM;
        }
        profileItemCreate.setPublicKey(str4);
        String str5 = queryParam.get("presharedkey");
        if (str5 != null) {
            str2 = str5;
        }
        profileItemCreate.setPreSharedKey(str2);
        String str6 = queryParam.get("mtu");
        if (str6 == null) {
            str6 = AppConfig.WIREGUARD_LOCAL_MTU;
        }
        profileItemCreate.setMtu(Integer.valueOf(utils.parseInt(str6)));
        String str7 = queryParam.get("reserved");
        if (str7 == null) {
            str7 = "0,0,0";
        }
        profileItemCreate.setReserved(str7);
        return profileItemCreate;
    }

    public final ProfileItem parseWireguardConfFile(String str) {
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.WIREGUARD);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator it = fz0.E(new ge(3, str)).iterator();
        Object obj = null;
        while (it.hasNext()) {
            String string = q31.C0((String) it.next()).toString();
            if (string.length() != 0 && !string.startsWith("#")) {
                if (string.regionMatches(true, 0, "[Interface]", 0, 11)) {
                    obj = "Interface";
                } else if (string.regionMatches(true, 0, "[Peer]", 0, 6)) {
                    obj = "Peer";
                } else if (obj != null) {
                    List listS0 = q31.s0(string, new String[]{"="}, 2);
                    ArrayList arrayList = new ArrayList(ae.y0(listS0));
                    Iterator it2 = listS0.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(q31.C0((String) it2.next()).toString());
                    }
                    if (arrayList.size() == 2) {
                        String lowerCase = ((String) arrayList.get(0)).toLowerCase(Locale.ROOT);
                        String str2 = (String) arrayList.get(1);
                        if (obj.equals("Interface")) {
                            linkedHashMap.put(lowerCase, str2);
                        } else if (obj.equals("Peer")) {
                            linkedHashMap2.put(lowerCase, str2);
                        }
                    }
                }
            }
        }
        String str3 = (String) linkedHashMap.get("privatekey");
        if (str3 == null) {
            str3 = AppConfig.CUSTOM;
        }
        profileItemCreate.setSecretKey(str3);
        profileItemCreate.setRemarks(String.valueOf(System.currentTimeMillis()));
        String str4 = (String) linkedHashMap.get("address");
        if (str4 == null) {
            str4 = AppConfig.WIREGUARD_LOCAL_ADDRESS_V4;
        }
        profileItemCreate.setLocalAddress(str4);
        Utils utils = Utils.INSTANCE;
        String str5 = (String) linkedHashMap.get("mtu");
        if (str5 == null) {
            str5 = AppConfig.WIREGUARD_LOCAL_MTU;
        }
        profileItemCreate.setMtu(Integer.valueOf(utils.parseInt(str5)));
        String str6 = (String) linkedHashMap2.get("publickey");
        if (str6 == null) {
            str6 = AppConfig.CUSTOM;
        }
        profileItemCreate.setPublicKey(str6);
        String str7 = (String) linkedHashMap2.get("presharedkey");
        if (str7 == null) {
            str7 = AppConfig.CUSTOM;
        }
        profileItemCreate.setPreSharedKey(str7);
        String str8 = (String) linkedHashMap2.get("endpoint");
        if (str8 == null) {
            str8 = AppConfig.CUSTOM;
        }
        List listS1 = q31.s0(str8, new String[]{":"}, 2);
        if (listS1.size() == 2) {
            profileItemCreate.setServer((String) listS1.get(0));
            profileItemCreate.setServerPort((String) listS1.get(1));
        } else {
            profileItemCreate.setServer(str8);
            profileItemCreate.setServerPort(AppConfig.CUSTOM);
        }
        String str9 = (String) linkedHashMap2.get("reserved");
        if (str9 == null) {
            str9 = "0,0,0";
        }
        profileItemCreate.setReserved(str9);
        return profileItemCreate;
    }

    public final V2rayConfig.OutboundBean toOutbound(ProfileItem profileItem) {
        V2rayConfig.OutboundBean.OutSettingsBean settings;
        ArrayList arrayList;
        V2rayConfig.OutboundBean.OutSettingsBean.WireGuardBean wireGuardBean;
        V2rayConfig.OutboundBean outboundBeanCreate = V2rayConfig.OutboundBean.Companion.create(EConfigType.WIREGUARD);
        if (outboundBeanCreate != null && (settings = outboundBeanCreate.getSettings()) != null) {
            settings.setSecretKey(profileItem.getSecretKey());
            String localAddress = profileItem.getLocalAddress();
            if (localAddress == null) {
                localAddress = AppConfig.WIREGUARD_LOCAL_ADDRESS_V4;
            }
            settings.setAddress(q31.s0(localAddress, new String[]{","}, 6));
            List<V2rayConfig.OutboundBean.OutSettingsBean.WireGuardBean> peers = settings.getPeers();
            if (peers != null && (wireGuardBean = (V2rayConfig.OutboundBean.OutSettingsBean.WireGuardBean) he.M0(peers)) != null) {
                String publicKey = profileItem.getPublicKey();
                String str = AppConfig.CUSTOM;
                if (publicKey == null) {
                    publicKey = AppConfig.CUSTOM;
                }
                wireGuardBean.setPublicKey(publicKey);
                String preSharedKey = profileItem.getPreSharedKey();
                if (preSharedKey != null) {
                    str = preSharedKey;
                }
                wireGuardBean.setPreSharedKey(str);
                wireGuardBean.setEndpoint(Utils.INSTANCE.getIpv6Address(profileItem.getServer()) + ':' + profileItem.getServerPort());
            }
            settings.setMtu(profileItem.getMtu());
            String reserved = profileItem.getReserved();
            if (reserved != null) {
                List listS0 = q31.s0(reserved, new String[]{","}, 6);
                arrayList = new ArrayList(ae.y0(listS0));
                Iterator it = listS0.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
                }
            } else {
                arrayList = null;
            }
            settings.setReserved(arrayList);
        }
        return outboundBeanCreate;
    }

    public final String toUri(ProfileItem profileItem) {
        HashMap<String, String> map = new HashMap<>();
        String publicKey = profileItem.getPublicKey();
        String str = AppConfig.CUSTOM;
        if (publicKey == null) {
            publicKey = AppConfig.CUSTOM;
        }
        map.put("publickey", publicKey);
        if (profileItem.getReserved() != null) {
            String strRemoveWhiteSpace = Utils.INSTANCE.removeWhiteSpace(profileItem.getReserved());
            if (strRemoveWhiteSpace == null) {
                strRemoveWhiteSpace = AppConfig.CUSTOM;
            }
            map.put("reserved", strRemoveWhiteSpace);
        }
        Utils utils = Utils.INSTANCE;
        String strRemoveWhiteSpace2 = utils.removeWhiteSpace(profileItem.getLocalAddress());
        if (strRemoveWhiteSpace2 == null) {
            strRemoveWhiteSpace2 = AppConfig.CUSTOM;
        }
        map.put("address", strRemoveWhiteSpace2);
        if (profileItem.getMtu() != null) {
            map.put("mtu", String.valueOf(profileItem.getMtu()));
        }
        if (profileItem.getPreSharedKey() != null) {
            String strRemoveWhiteSpace3 = utils.removeWhiteSpace(profileItem.getPreSharedKey());
            if (strRemoveWhiteSpace3 != null) {
                str = strRemoveWhiteSpace3;
            }
            map.put("presharedkey", str);
        }
        return toUri(profileItem, profileItem.getSecretKey(), map);
    }
}
