package renz.javacodez.v2ray;

import android.text.TextUtils;
import defpackage.e;
import java.util.ArrayList;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.fmtkt.CustomFmt;
import renz.javacodez.v2ray.fmtkt.Hysteria2Fmt;
import renz.javacodez.v2ray.fmtkt.ShadowsocksFmt;
import renz.javacodez.v2ray.fmtkt.SocksFmt;
import renz.javacodez.v2ray.fmtkt.TrojanFmt;
import renz.javacodez.v2ray.fmtkt.VlessFmt;
import renz.javacodez.v2ray.fmtkt.VmessFmt;
import renz.javacodez.v2ray.fmtkt.WireguardFmt;
import renz.javacodez.v2ray.handler.MmkvManager;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class AppConfig {
    public static final String ANG_CONFIG = "ang_config";
    public static final String ANG_PACKAGE = "org.hamotunnelplus.xyz";
    public static final String BROADCAST_ACTION_ACTIVITY = "renz.javacodez.v2ray.action.activity";
    public static final String BROADCAST_ACTION_SERVICE = "renz.javacodez.v2ray.action.service";
    public static final String BROADCAST_ACTION_WIDGET_CLICK = "renz.javacodez.v2ray.action.widget.click";
    public static final String CACHE_KEYWORD_FILTER = "cache_keyword_filter";
    public static final String CACHE_SUBSCRIPTION_ID = "cache_subscription_id";
    public static final String CUSTOM = "";
    public static final int DEFAULT_LEVEL = 8;
    public static final String DEFAULT_NETWORK = "tcp";
    public static final int DEFAULT_PORT = 443;
    public static final String DEFAULT_SECURITY = "auto";
    public static final String DIR_ASSETS = "assets";
    public static final String DIR_BACKUPS = "backups";
    public static final String DNS_CLOUDFLARE_DOMAIN = "one.one.one.one";
    public static final String DNS_DIRECT = "223.5.5.5";
    public static final String DNS_GOOGLE_DOMAIN = "dns.google";
    public static final String DNS_PROXY = "1.1.1.1";
    public static final String DNS_VPN = "1.1.1.1";
    public static final String DOWNLINK = "downlink";
    public static final String DelayTestUrl = "https://www.gstatic.com/generate_204";
    public static final String DelayTestUrl2 = "https://www.google.com/generate_204";
    public static final String GEOIP_CN = "geoip:cn";
    public static final String GEOIP_PRIVATE = "geoip:private";
    public static final String GEOSITE_CN = "geosite:cn";
    public static final String GEOSITE_PRIVATE = "geosite:private";
    public static final String GOOGLEAPIS_CN_DOMAIN = "domain:googleapis.cn";
    public static final String GOOGLEAPIS_COM_DOMAIN = "googleapis.com";
    public static final String GeoUrl = "https://github.com/Loyalsoldier/v2ray-rules-dat/releases/latest/download/";
    public static final String HEADER_TYPE_HTTP = "http";
    public static final String HTTP = "http://";
    public static final String HY2 = "hy2://";
    public static final String HYSTERIA2 = "hysteria2://";
    public static final String LOOPBACK = "127.0.0.1";
    public static final int MSG_MEASURE_CONFIG = 7;
    public static final int MSG_MEASURE_CONFIG_CANCEL = 72;
    public static final int MSG_MEASURE_CONFIG_SUCCESS = 71;
    public static final int MSG_MEASURE_DELAY = 6;
    public static final int MSG_MEASURE_DELAY_SUCCESS = 61;
    public static final int MSG_REGISTER_CLIENT = 1;
    public static final int MSG_STATE_NOT_RUNNING = 12;
    public static final int MSG_STATE_RESTART = 5;
    public static final int MSG_STATE_RUNNING = 11;
    public static final int MSG_STATE_START = 3;
    public static final int MSG_STATE_START_FAILURE = 32;
    public static final int MSG_STATE_START_SUCCESS = 31;
    public static final int MSG_STATE_STOP = 4;
    public static final int MSG_STATE_STOP_SUCCESS = 41;
    public static final int MSG_UNREGISTER_CLIENT = 2;
    public static final String PORT_HTTP = "10809";
    public static final String PORT_LOCAL_DNS = "10853";
    public static final String PORT_SOCKS = "10808";
    public static final String PREF_ALLOW_INSECURE = "pref_allow_insecure";
    public static final String PREF_APPEND_HTTP_PROXY = "pref_append_http_proxy";
    public static final String PREF_BYPASS_APPS = "pref_bypass_apps";
    public static final String PREF_CONFIRM_REMOVE = "pref_confirm_remove";
    public static final String PREF_DELAY_TEST_URL = "pref_delay_test_url";
    public static final String PREF_DOMESTIC_DNS = "pref_domestic_dns";
    public static final String PREF_FAKE_DNS_ENABLED = "pref_fake_dns_enabled";
    public static final String PREF_FRAGMENT_ENABLED = "pref_fragment_enabled";
    public static final String PREF_FRAGMENT_INTERVAL = "pref_fragment_interval";
    public static final String PREF_FRAGMENT_LENGTH = "pref_fragment_length";
    public static final String PREF_FRAGMENT_PACKETS = "pref_fragment_packets";
    public static final String PREF_INAPP_BUY_IS_PREMIUM = "pref_inapp_buy_is_premium";
    public static final String PREF_IS_BOOTED = "pref_is_booted";
    public static final String PREF_LANGUAGE = "pref_language";
    public static final String PREF_LOCAL_DNS_ENABLED = "pref_local_dns_enabled";
    public static final String PREF_LOCAL_DNS_PORT = "pref_local_dns_port";
    public static final String PREF_LOGLEVEL = "pref_core_loglevel";
    public static final String PREF_MODE = "pref_mode";
    public static final String PREF_MUX_CONCURRENCY = "pref_mux_concurrency";
    public static final String PREF_MUX_ENABLED = "pref_mux_enabled";
    public static final String PREF_MUX_XUDP_CONCURRENCY = "pref_mux_xudp_concurrency";
    public static final String PREF_MUX_XUDP_QUIC = "pref_mux_xudp_quic";
    public static final String PREF_PER_APP_PROXY = "pref_per_app_proxy";
    public static final String PREF_PER_APP_PROXY_SET = "pref_per_app_proxy_set";
    public static final String PREF_PREFER_IPV6 = "pref_prefer_ipv6";
    public static final String PREF_PROXY_SHARING = "pref_proxy_sharing_enabled";
    public static final String PREF_REMOTE_DNS = "pref_remote_dns";
    public static final String PREF_ROUTE_ONLY_ENABLED = "pref_route_only_enabled";
    public static final String PREF_ROUTING_DOMAIN_STRATEGY = "pref_routing_domain_strategy";
    public static final String PREF_ROUTING_RULESET = "pref_routing_ruleset";
    public static final String PREF_SNIFFING_ENABLED = "pref_sniffing_enabled";
    public static final String PREF_SOCKS_PORT = "pref_socks_port";
    public static final String PREF_SPEED_ENABLED = "pref_speed_enabled";
    public static final String PREF_START_SCAN_IMMEDIATE = "pref_start_scan_immediate";
    public static final String PREF_UI_MODE_NIGHT = "pref_ui_mode_night";
    public static final String PREF_VPN_DNS = "pref_vpn_dns";
    public static final String PROTOCOL_FREEDOM = "freedom";
    public static final String PromotionUrl = "aHR0cHM6Ly85LjIzNDQ1Ni54eXovYWJjLmh0bWw=";
    public static final String RAY_NG_CHANNEL_ID = "RAY_NG_M_CH_ID";
    public static final String RAY_NG_CHANNEL_NAME = "v2rayNG Background Service";
    public static final String REALITY = "reality";
    public static final String SHADOWSOCKS = "ss://";
    public static final String SOCKS = "socks://";
    public static final String SUBSCRIPTION_AUTO_UPDATE = "pref_auto_update_subscription";
    public static final String SUBSCRIPTION_AUTO_UPDATE_INTERVAL = "pref_auto_update_interval";
    public static final String SUBSCRIPTION_DEFAULT_UPDATE_INTERVAL = "1440";
    public static final String SUBSCRIPTION_UPDATE_CHANNEL = "subscription_update_channel";
    public static final String SUBSCRIPTION_UPDATE_CHANNEL_NAME = "Subscription Update Service";
    public static final String SUBSCRIPTION_UPDATE_TASK_NAME = "subscription_updater";
    public static final String TAG_BLOCKED = "block";
    public static final String TAG_DIRECT = "direct";
    public static final String TAG_FRAGMENT = "fragment";
    public static final String TAG_PROXY = "proxy";
    public static final String TASKER_DEFAULT_GUID = "Default";
    public static final String TASKER_EXTRA_BUNDLE = "com.twofortyfouram.locale.intent.extra.BUNDLE";
    public static final String TASKER_EXTRA_BUNDLE_GUID = "tasker_extra_bundle_guid";
    public static final String TASKER_EXTRA_BUNDLE_SWITCH = "tasker_extra_bundle_switch";
    public static final String TASKER_EXTRA_STRING_BLURB = "com.twofortyfouram.locale.intent.extra.BLURB";
    public static final String TLS = "tls";
    public static final String TROJAN = "trojan://";
    public static final String TUIC = "tuic://";
    public static final String TgChannelUrl = "https://t.me/github_2dust";
    public static final String UPLINK = "uplink";
    public static final String VLESS = "vless://";
    public static final String VMESS = "vmess://";
    public static final String VPN = "VPN";
    public static final String WIREGUARD = "wireguard://";
    public static final String WIREGUARD_LOCAL_ADDRESS_V4 = "172.16.0.2/32";
    public static final String WIREGUARD_LOCAL_ADDRESS_V6 = "2606:4700:110:8f81:d551:a0:532e:a2b3/128";
    public static final String WIREGUARD_LOCAL_MTU = "1420";
    public static final String androidpackagenamelistUrl = "https://raw.githubusercontent.com/2dust/androidpackagenamelist/master/proxy.txt";
    public static final String v2rayCustomRoutingListUrl = "https://raw.githubusercontent.com/2dust/v2rayCustomRoutingList/master/";
    public static final String v2rayNGIssues = "https://github.com/2dust/v2rayNG/issues";
    public static final String v2rayNGPrivacyPolicy = "https://raw.githubusercontent.com/2dust/v2rayNG/master/CR.md";
    public static final String v2rayNGUrl = "https://github.com/2dust/v2rayNG";
    public static final String v2rayNGWikiMode = "https://github.com/2dust/v2rayNG/wiki/Mode";
    public static final AppConfig INSTANCE = new AppConfig();
    private static final ArrayList<String> DNS_CLOUDFLARE_ADDRESSES = e.c("1.1.1.1", "1.0.0.1", "2606:4700:4700::1111", "2606:4700:4700::1001");
    private static final ArrayList<String> DNS_GOOGLE_ADDRESSES = e.c("8.8.8.8", "8.8.4.4", "2001:4860:4860::8888", "2001:4860:4860::8844");

    private AppConfig() {
    }

    public static final int importConfig(String str, String str2) {
        ProfileItem profileItem;
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith(EConfigType.VMESS.getProtocolScheme())) {
                        profileItem = VmessFmt.INSTANCE.parse(str);
                    } else if (str.startsWith(EConfigType.SHADOWSOCKS.getProtocolScheme())) {
                        profileItem = ShadowsocksFmt.INSTANCE.parse(str);
                    } else if (str.startsWith(EConfigType.SOCKS.getProtocolScheme())) {
                        profileItem = SocksFmt.INSTANCE.parse(str);
                    } else if (str.startsWith(EConfigType.TROJAN.getProtocolScheme())) {
                        profileItem = TrojanFmt.INSTANCE.parse(str);
                    } else if (str.startsWith(EConfigType.VLESS.getProtocolScheme())) {
                        profileItem = VlessFmt.INSTANCE.parse(str);
                    } else if (str.startsWith(EConfigType.WIREGUARD.getProtocolScheme())) {
                        profileItem = WireguardFmt.INSTANCE.parse(str);
                    } else {
                        profileItem = (str.startsWith(EConfigType.HYSTERIA2.getProtocolScheme()) || str.startsWith(HY2)) ? Hysteria2Fmt.INSTANCE.parse(str) : null;
                    }
                    if (profileItem == null) {
                        return R.string.toast_incorrect_protocol;
                    }
                    profileItem.setRemarks(str2);
                    profileItem.setSubscriptionId("v2ray");
                    MmkvManager mmkvManager = MmkvManager.INSTANCE;
                    mmkvManager.setSelectServer(mmkvManager.encodeServerConfig("renz-v2ray-non-custom", profileItem));
                    return R.string.toast_success;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return R.string.toast_incorrect_protocol;
            }
        }
        return R.string.toast_none_data;
    }

    public static final int importCustomConfig(String str, String str2) {
        try {
            ProfileItem profileItem = CustomFmt.INSTANCE.parse(str2);
            profileItem.setSubscriptionId("v2ray");
            profileItem.setRemarks(str);
            MmkvManager mmkvManager = MmkvManager.INSTANCE;
            String strEncodeServerConfig = mmkvManager.encodeServerConfig("renz-v2ray", profileItem);
            mmkvManager.encodeServerRaw(strEncodeServerConfig, str2);
            mmkvManager.setSelectServer(strEncodeServerConfig);
            return R.string.toast_success;
        } catch (Exception e) {
            e.printStackTrace();
            return R.string.toast_incorrect_protocol;
        }
    }

    public final ArrayList<String> getDNS_CLOUDFLARE_ADDRESSES() {
        return DNS_CLOUDFLARE_ADDRESSES;
    }

    public final ArrayList<String> getDNS_GOOGLE_ADDRESSES() {
        return DNS_GOOGLE_ADDRESSES;
    }
}
