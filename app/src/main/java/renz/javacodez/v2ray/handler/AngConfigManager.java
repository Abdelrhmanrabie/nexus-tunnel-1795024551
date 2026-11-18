package renz.javacodez.v2ray.handler;

import android.text.TextUtils;
import defpackage.e4;
import java.util.regex.Pattern;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.R;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.SubscriptionItem;
import renz.javacodez.v2ray.fmtkt.Hysteria2Fmt;
import renz.javacodez.v2ray.fmtkt.ShadowsocksFmt;
import renz.javacodez.v2ray.fmtkt.SocksFmt;
import renz.javacodez.v2ray.fmtkt.TrojanFmt;
import renz.javacodez.v2ray.fmtkt.VlessFmt;
import renz.javacodez.v2ray.fmtkt.VmessFmt;
import renz.javacodez.v2ray.fmtkt.WireguardFmt;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class AngConfigManager {
    public static final AngConfigManager INSTANCE = new AngConfigManager();

    private AngConfigManager() {
    }

    private final int parseConfig(String str, String str2, SubscriptionItem subscriptionItem, ProfileItem profileItem) {
        ProfileItem profileItem2;
        String filter;
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith(EConfigType.VMESS.getProtocolScheme())) {
                        profileItem2 = VmessFmt.INSTANCE.parse(str);
                    } else if (str.startsWith(EConfigType.SHADOWSOCKS.getProtocolScheme())) {
                        profileItem2 = ShadowsocksFmt.INSTANCE.parse(str);
                    } else if (str.startsWith(EConfigType.SOCKS.getProtocolScheme())) {
                        profileItem2 = SocksFmt.INSTANCE.parse(str);
                    } else if (str.startsWith(EConfigType.TROJAN.getProtocolScheme())) {
                        profileItem2 = TrojanFmt.INSTANCE.parse(str);
                    } else if (str.startsWith(EConfigType.VLESS.getProtocolScheme())) {
                        profileItem2 = VlessFmt.INSTANCE.parse(str);
                    } else if (str.startsWith(EConfigType.WIREGUARD.getProtocolScheme())) {
                        profileItem2 = WireguardFmt.INSTANCE.parse(str);
                    } else {
                        profileItem2 = (str.startsWith(EConfigType.HYSTERIA2.getProtocolScheme()) || str.startsWith(AppConfig.HY2)) ? Hysteria2Fmt.INSTANCE.parse(str) : null;
                    }
                    if (profileItem2 == null) {
                        return R.string.toast_incorrect_protocol;
                    }
                    if ((subscriptionItem != null ? subscriptionItem.getFilter() : null) != null && (filter = subscriptionItem.getFilter()) != null && filter.length() > 0 && profileItem2.getRemarks().length() > 0) {
                        String filter2 = subscriptionItem.getFilter();
                        if (filter2 == null) {
                            filter2 = AppConfig.CUSTOM;
                        }
                        if (!Pattern.compile(filter2).matcher(profileItem2.getRemarks()).find()) {
                            return -1;
                        }
                    }
                    profileItem2.setSubscriptionId(str2);
                    MmkvManager mmkvManager = MmkvManager.INSTANCE;
                    String strEncodeServerConfig = mmkvManager.encodeServerConfig(AppConfig.CUSTOM, profileItem2);
                    if (profileItem != null && e4.a(profileItem2.getServer(), profileItem.getServer()) && e4.a(profileItem2.getServerPort(), profileItem.getServerPort())) {
                        mmkvManager.setSelectServer(strEncodeServerConfig);
                    }
                    return 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return R.string.toast_none_data;
    }
}
