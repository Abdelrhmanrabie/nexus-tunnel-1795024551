package renz.javacodez.v2ray.handler;

import android.content.Context;
import android.text.TextUtils;
import defpackage.ae;
import defpackage.d;
import defpackage.e;
import defpackage.e4;
import defpackage.he;
import defpackage.jo0;
import defpackage.q31;
import defpackage.rc0;
import defpackage.uh0;
import defpackage.v41;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import net.lingala.zip4j.util.InternalZipConstants;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.ConfigResult;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.RulesetItem;
import renz.javacodez.v2ray.dto.SubscriptionItem;
import renz.javacodez.v2ray.dto.V2rayConfig;
import renz.javacodez.v2ray.fmtkt.HttpFmt;
import renz.javacodez.v2ray.fmtkt.Hysteria2Fmt;
import renz.javacodez.v2ray.fmtkt.ShadowsocksFmt;
import renz.javacodez.v2ray.fmtkt.SocksFmt;
import renz.javacodez.v2ray.fmtkt.TrojanFmt;
import renz.javacodez.v2ray.fmtkt.VlessFmt;
import renz.javacodez.v2ray.fmtkt.VmessFmt;
import renz.javacodez.v2ray.fmtkt.WireguardFmt;
import renz.javacodez.v2ray.util.JsonUtil;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class V2rayConfigManager {
    public static final V2rayConfigManager INSTANCE = new V2rayConfigManager();

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
                iArr[EConfigType.CUSTOM.ordinal()] = 2;
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
                iArr[EConfigType.VLESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EConfigType.TROJAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EConfigType.WIREGUARD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EConfigType.HYSTERIA2.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EConfigType.HTTP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private V2rayConfigManager() {
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00f0 A[Catch: Exception -> 0x0048, TryCatch #0 {Exception -> 0x0048, blocks: (B:3:0x0003, B:5:0x000e, B:7:0x002e, B:10:0x004b, B:16:0x005e, B:27:0x008c, B:29:0x009c, B:32:0x00a7, B:33:0x00e3, B:35:0x00e9, B:46:0x0119, B:47:0x0132, B:38:0x00f0, B:39:0x00f4, B:41:0x00fa, B:43:0x010c, B:19:0x0065, B:20:0x0069, B:22:0x006f, B:24:0x0081), top: B:51:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00fa A[Catch: Exception -> 0x0048, TryCatch #0 {Exception -> 0x0048, blocks: (B:3:0x0003, B:5:0x000e, B:7:0x002e, B:10:0x004b, B:16:0x005e, B:27:0x008c, B:29:0x009c, B:32:0x00a7, B:33:0x00e3, B:35:0x00e9, B:46:0x0119, B:47:0x0132, B:38:0x00f0, B:39:0x00f4, B:41:0x00fa, B:43:0x010c, B:19:0x0065, B:20:0x0069, B:22:0x006f, B:24:0x0081), top: B:51:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x010c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    private final boolean customLocalDns(V2rayConfig v2rayConfig) {
        ArrayList<V2rayConfig.OutboundBean> outbounds;
        try {
            if (MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_FAKE_DNS_ENABLED)) {
                ArrayList arrayListC = e.c(AppConfig.GEOSITE_CN);
                ArrayList<String> arrayListUserRule2Domain = userRule2Domain(AppConfig.TAG_PROXY);
                ArrayList<String> arrayListUserRule2Domain2 = userRule2Domain(AppConfig.TAG_DIRECT);
                ArrayList<Object> servers = v2rayConfig.getDns().getServers();
                if (servers != null) {
                    servers.add(0, new V2rayConfig.DnsBean.ServersBean("fakedns", null, he.X0(arrayListUserRule2Domain2, he.X0(arrayListUserRule2Domain, arrayListC)), null, null, null, 58, null));
                }
            }
            List<String> remoteDnsServers = Utils.INSTANCE.getRemoteDnsServers();
            ArrayList<V2rayConfig.InboundBean> inbounds = v2rayConfig.getInbounds();
            if (!(inbounds != null) || !inbounds.isEmpty()) {
                Iterator<T> it = inbounds.iterator();
                while (true) {
                    if (it.hasNext()) {
                        V2rayConfig.InboundBean inboundBean = (V2rayConfig.InboundBean) it.next();
                        if (!e4.a(inboundBean.getProtocol(), "dokodemo-door") || !e4.a(inboundBean.getTag(), "dns-in")) {
                        }
                    }
                    outbounds = v2rayConfig.getOutbounds();
                    if (outbounds != null || !outbounds.isEmpty()) {
                        for (V2rayConfig.OutboundBean outboundBean : outbounds) {
                            if (!e4.a(outboundBean.getProtocol(), "dns") && e4.a(outboundBean.getTag(), "dns-out")) {
                                v2rayConfig.getRouting().getRules().add(0, new V2rayConfig.RoutingBean.RulesBean(null, null, null, "dns-out", null, null, null, null, null, null, e.c("dns-in"), null, null, null, 15347, null));
                                return true;
                            }
                        }
                    }
                    v2rayConfig.getOutbounds().add(new V2rayConfig.OutboundBean("dns-out", "dns", null, null, null, null, null, 48, null));
                    v2rayConfig.getRouting().getRules().add(0, new V2rayConfig.RoutingBean.RulesBean(null, null, null, "dns-out", null, null, null, null, null, null, e.c("dns-in"), null, null, null, 15347, null));
                    return true;
                }
            }
            Utils utils = Utils.INSTANCE;
            v2rayConfig.getInbounds().add(new V2rayConfig.InboundBean("dns-in", utils.parseInt(MmkvManager.INSTANCE.decodeSettingsString(AppConfig.PREF_LOCAL_DNS_PORT), Integer.parseInt(AppConfig.PORT_LOCAL_DNS)), "dokodemo-door", AppConfig.LOOPBACK, new V2rayConfig.InboundBean.InSettingsBean(null, null, null, utils.isPureIpAddress((String) he.K0(remoteDnsServers)) ? (String) he.K0(remoteDnsServers) : "1.1.1.1", 53, "tcp,udp", 7, null), null, null, null, 192, null));
            outbounds = v2rayConfig.getOutbounds();
            if (outbounds != null) {
                while (r0.hasNext()) {
                    if (!e4.a(outboundBean.getProtocol(), "dns")) {
                    }
                }
                v2rayConfig.getOutbounds().add(new V2rayConfig.OutboundBean("dns-out", "dns", null, null, null, null, null, 48, null));
            } else {
                while (r0.hasNext()) {
                    if (!e4.a(outboundBean.getProtocol(), "dns")) {
                    }
                }
                v2rayConfig.getOutbounds().add(new V2rayConfig.OutboundBean("dns-out", "dns", null, null, null, null, null, 48, null));
            }
            v2rayConfig.getRouting().getRules().add(0, new V2rayConfig.RoutingBean.RulesBean(null, null, null, "dns-out", null, null, null, null, null, null, e.c("dns-in"), null, null, null, 15347, null));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean dns(V2rayConfig v2rayConfig) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ArrayList arrayList = new ArrayList();
            List<String> remoteDnsServers = Utils.INSTANCE.getRemoteDnsServers();
            ArrayList<String> arrayListUserRule2Domain = userRule2Domain(AppConfig.TAG_PROXY);
            Iterator<T> it = remoteDnsServers.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
            if (arrayListUserRule2Domain.size() > 0) {
                arrayList.add(new V2rayConfig.DnsBean.ServersBean((String) he.K0(remoteDnsServers), null, arrayListUserRule2Domain, null, null, null, 58, null));
            }
            Utils utils = Utils.INSTANCE;
            List<String> domesticDnsServers = utils.getDomesticDnsServers();
            ArrayList<String> arrayListUserRule2Domain2 = userRule2Domain(AppConfig.TAG_DIRECT);
            boolean zContains = arrayListUserRule2Domain2.contains(AppConfig.GEOSITE_CN);
            ArrayList arrayListC = e.c(AppConfig.GEOIP_CN);
            if (arrayListUserRule2Domain2.size() > 0) {
                arrayList.add(new V2rayConfig.DnsBean.ServersBean((String) he.K0(domesticDnsServers), null, arrayListUserRule2Domain2, zContains ? arrayListC : null, null, Boolean.TRUE, 18, null));
            }
            if (utils.isPureIpAddress((String) he.K0(domesticDnsServers))) {
                v2rayConfig.getRouting().getRules().add(0, new V2rayConfig.RoutingBean.RulesBean(null, e.c(he.K0(domesticDnsServers)), null, AppConfig.TAG_DIRECT, null, "53", null, null, null, null, null, null, null, null, 16337, null));
            }
            ArrayList<String> arrayListUserRule2Domain3 = userRule2Domain(AppConfig.TAG_BLOCKED);
            if (arrayListUserRule2Domain3.size() > 0) {
                ArrayList<jo0> arrayList2 = new ArrayList(ae.y0(arrayListUserRule2Domain3));
                Iterator<T> it2 = arrayListUserRule2Domain3.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new jo0((String) it2.next(), AppConfig.LOOPBACK));
                }
                for (jo0 jo0Var : arrayList2) {
                    linkedHashMap.put(jo0Var.b, jo0Var.c);
                }
            }
            linkedHashMap.put(AppConfig.GOOGLEAPIS_CN_DOMAIN, AppConfig.GOOGLEAPIS_COM_DOMAIN);
            AppConfig appConfig = AppConfig.INSTANCE;
            linkedHashMap.put(AppConfig.DNS_CLOUDFLARE_DOMAIN, appConfig.getDNS_CLOUDFLARE_ADDRESSES());
            linkedHashMap.put(AppConfig.DNS_GOOGLE_DOMAIN, appConfig.getDNS_GOOGLE_ADDRESSES());
            v2rayConfig.setDns(new V2rayConfig.DnsBean(arrayList, linkedHashMap, null, null, null, null, 60, null));
            if (Utils.INSTANCE.isPureIpAddress((String) he.K0(remoteDnsServers))) {
                v2rayConfig.getRouting().getRules().add(0, new V2rayConfig.RoutingBean.RulesBean(null, e.c(he.K0(remoteDnsServers)), null, AppConfig.TAG_PROXY, null, "53", null, null, null, null, null, null, null, null, 16337, null));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void fakedns(V2rayConfig v2rayConfig) {
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        if (mmkvManager.decodeSettingsBool(AppConfig.PREF_LOCAL_DNS_ENABLED) && mmkvManager.decodeSettingsBool(AppConfig.PREF_FAKE_DNS_ENABLED)) {
            v2rayConfig.setFakedns(Collections.singletonList(new V2rayConfig.FakednsBean(null, 0, 3, 0 == true ? 1 : 0)));
        }
    }

    private final ConfigResult getV2rayNonCustomConfig(Context context, ProfileItem profileItem) throws IOException {
        ConfigResult configResult = new ConfigResult(false, null, null, null, 14, null);
        String server = profileItem.getServer();
        if (server != null) {
            Utils utils = Utils.INSTANCE;
            if (utils.isIpAddress(server) || utils.isValidUrl(server)) {
                String textFromAssets = utils.readTextFromAssets(context, "v2ray_config.json");
                if (!TextUtils.isEmpty(textFromAssets)) {
                    V2rayConfig v2rayConfig = (V2rayConfig) JsonUtil.INSTANCE.fromJson(textFromAssets, V2rayConfig.class);
                    V2rayConfig.LogBean log = v2rayConfig.getLog();
                    MmkvManager mmkvManager = MmkvManager.INSTANCE;
                    String strDecodeSettingsString = mmkvManager.decodeSettingsString(AppConfig.PREF_LOGLEVEL);
                    if (strDecodeSettingsString == null) {
                        strDecodeSettingsString = "warning";
                    }
                    log.setLoglevel(strDecodeSettingsString);
                    v2rayConfig.setRemarks(profileItem.getRemarks());
                    inbounds(v2rayConfig);
                    boolean z = profileItem.getConfigType() == EConfigType.HYSTERIA2;
                    jo0 jo0VarOutbounds = outbounds(v2rayConfig, profileItem, z);
                    if (jo0VarOutbounds != null) {
                        jo0 jo0VarMoreOutbounds = moreOutbounds(context, v2rayConfig, profileItem.getSubscriptionId(), z);
                        routing(v2rayConfig);
                        fakedns(v2rayConfig);
                        dns(v2rayConfig);
                        if (mmkvManager.decodeSettingsBool(AppConfig.PREF_LOCAL_DNS_ENABLED)) {
                            customLocalDns(v2rayConfig);
                        }
                        if (!mmkvManager.decodeSettingsBool(AppConfig.PREF_SPEED_ENABLED)) {
                            v2rayConfig.setStats(null);
                            v2rayConfig.setPolicy(null);
                        }
                        configResult.setStatus(true);
                        configResult.setContent(v2rayConfig.toPrettyPrinting());
                        if (((Boolean) jo0VarMoreOutbounds.b).booleanValue()) {
                            jo0VarOutbounds = jo0VarMoreOutbounds;
                        }
                        configResult.setDomainPort((String) jo0VarOutbounds.c);
                        return configResult;
                    }
                }
            }
        }
        return configResult;
    }

    private final boolean inbounds(V2rayConfig v2rayConfig) {
        V2rayConfig.InboundBean.SniffingBean sniffing;
        ArrayList<String> destOverride;
        V2rayConfig.InboundBean.SniffingBean sniffing2;
        ArrayList<String> destOverride2;
        try {
            int socksPort = SettingsManager.INSTANCE.getSocksPort();
            for (V2rayConfig.InboundBean inboundBean : v2rayConfig.getInbounds()) {
                if (!MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_PROXY_SHARING)) {
                    inboundBean.setListen(AppConfig.LOOPBACK);
                }
            }
            v2rayConfig.getInbounds().get(0).setPort(socksPort);
            MmkvManager mmkvManager = MmkvManager.INSTANCE;
            boolean z = mmkvManager.decodeSettingsBool(AppConfig.PREF_FAKE_DNS_ENABLED);
            boolean zDecodeSettingsBool = mmkvManager.decodeSettingsBool(AppConfig.PREF_SNIFFING_ENABLED, true);
            V2rayConfig.InboundBean.SniffingBean sniffing3 = v2rayConfig.getInbounds().get(0).getSniffing();
            if (sniffing3 != null) {
                sniffing3.setEnabled(z || zDecodeSettingsBool);
            }
            V2rayConfig.InboundBean.SniffingBean sniffing4 = v2rayConfig.getInbounds().get(0).getSniffing();
            if (sniffing4 != null) {
                sniffing4.setRouteOnly(Boolean.valueOf(mmkvManager.decodeSettingsBool(AppConfig.PREF_ROUTE_ONLY_ENABLED, false)));
            }
            if (!zDecodeSettingsBool && (sniffing2 = v2rayConfig.getInbounds().get(0).getSniffing()) != null && (destOverride2 = sniffing2.getDestOverride()) != null) {
                destOverride2.clear();
            }
            if (z && (sniffing = v2rayConfig.getInbounds().get(0).getSniffing()) != null && (destOverride = sniffing.getDestOverride()) != null) {
                destOverride.add("fakedns");
            }
            if (Utils.INSTANCE.isXray()) {
                v2rayConfig.getInbounds().remove(1);
                return true;
            }
            v2rayConfig.getInbounds().get(1).setPort(SettingsManager.INSTANCE.getHttpPort());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private final jo0 moreOutbounds(Context context, V2rayConfig v2rayConfig, String str, boolean z) {
        V2rayConfig.OutboundBean proxyOutbound;
        V2rayConfig.OutboundBean proxyOutbound2;
        Boolean bool = Boolean.FALSE;
        String serverAddressAndPort = AppConfig.CUSTOM;
        jo0 jo0Var = new jo0(bool, AppConfig.CUSTOM);
        if (!z) {
            MmkvManager mmkvManager = MmkvManager.INSTANCE;
            if (!mmkvManager.decodeSettingsBool(AppConfig.PREF_FRAGMENT_ENABLED, false) && str.length() != 0) {
                try {
                    SubscriptionItem subscriptionItemDecodeSubscription = mmkvManager.decodeSubscription(str);
                    if (subscriptionItemDecodeSubscription != null) {
                        V2rayConfig.OutboundBean outboundBean = v2rayConfig.getOutbounds().get(0);
                        SettingsManager settingsManager = SettingsManager.INSTANCE;
                        ProfileItem serverViaRemarks = settingsManager.getServerViaRemarks(context, subscriptionItemDecodeSubscription.getPrevProfile());
                        if (serverViaRemarks != null && (proxyOutbound2 = getProxyOutbound(serverViaRemarks)) != null) {
                            updateOutboundWithGlobalSettings(proxyOutbound2);
                            proxyOutbound2.setTag("proxy2");
                            v2rayConfig.getOutbounds().add(proxyOutbound2);
                            V2rayConfig.OutboundBean.StreamSettingsBean streamSettings = outboundBean.getStreamSettings();
                            if (streamSettings != null) {
                                streamSettings.setSockopt(new V2rayConfig.OutboundBean.StreamSettingsBean.SockoptBean(null, null, null, null, null, proxyOutbound2.getTag(), 31, null));
                            }
                            serverAddressAndPort = serverViaRemarks.getServerAddressAndPort();
                        }
                        ProfileItem serverViaRemarks2 = settingsManager.getServerViaRemarks(context, subscriptionItemDecodeSubscription.getNextProfile());
                        if (serverViaRemarks2 != null && (proxyOutbound = getProxyOutbound(serverViaRemarks2)) != null) {
                            updateOutboundWithGlobalSettings(proxyOutbound);
                            proxyOutbound.setTag(AppConfig.TAG_PROXY);
                            v2rayConfig.getOutbounds().add(0, proxyOutbound);
                            outboundBean.setTag("proxy1");
                            V2rayConfig.OutboundBean.StreamSettingsBean streamSettings2 = proxyOutbound.getStreamSettings();
                            if (streamSettings2 != null) {
                                streamSettings2.setSockopt(new V2rayConfig.OutboundBean.StreamSettingsBean.SockoptBean(null, null, null, null, null, outboundBean.getTag(), 31, null));
                            }
                        }
                        if (serverAddressAndPort.length() > 0) {
                            return new jo0(Boolean.TRUE, serverAddressAndPort);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return jo0Var;
                }
            }
        }
        return jo0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final jo0 outbounds(V2rayConfig v2rayConfig, ProfileItem profileItem, boolean z) throws IOException {
        if (!z) {
            V2rayConfig.OutboundBean proxyOutbound = getProxyOutbound(profileItem);
            if (proxyOutbound == null || !updateOutboundWithGlobalSettings(proxyOutbound)) {
                return null;
            }
            if (v2rayConfig.getOutbounds().isEmpty()) {
                v2rayConfig.getOutbounds().add(proxyOutbound);
            } else {
                v2rayConfig.getOutbounds().set(0, proxyOutbound);
            }
            updateOutboundFragment(v2rayConfig);
            return new jo0(Boolean.TRUE, profileItem.getServerAddressAndPort());
        }
        int iFindFreePort = Utils.INSTANCE.findFreePort(Arrays.asList(Integer.valueOf(SettingsManager.INSTANCE.getSocksPort() + 100), 0));
        V2rayConfig.OutboundBean.OutSettingsBean.Response response = null;
        V2rayConfig.OutboundBean.MuxBean muxBean = null;
        Object[] objArr = null == true ? 1 : 0;
        Object[] objArr2 = null == true ? 1 : 0;
        Object[] objArr3 = null == true ? 1 : 0;
        Object[] objArr4 = null == true ? 1 : 0;
        Object[] objArr5 = null == true ? 1 : 0;
        Object[] objArr6 = null == true ? 1 : 0;
        V2rayConfig.OutboundBean outboundBean = new V2rayConfig.OutboundBean(objArr5, "SOCKS".toLowerCase(Locale.ROOT), new V2rayConfig.OutboundBean.OutSettingsBean(objArr, objArr2, objArr3, Collections.singletonList(new V2rayConfig.OutboundBean.OutSettingsBean.ServersBean(AppConfig.LOOPBACK, null, false, null, iFindFreePort, 0, null, null, null, null, 1006, null)), response, objArr4, muxBean, null, null, null, null, null, null, null, null, null, null, 131063, null), null == true ? 1 : 0, response, null == true ? 1 : 0, muxBean, 57, objArr6);
        if (v2rayConfig.getOutbounds().isEmpty()) {
            v2rayConfig.getOutbounds().add(outboundBean);
        } else {
            v2rayConfig.getOutbounds().set(0, outboundBean);
        }
        return new jo0(Boolean.TRUE, outboundBean.getServerAddressAndPort());
    }

    private final boolean routing(V2rayConfig v2rayConfig) {
        try {
            V2rayConfig.RoutingBean routing = v2rayConfig.getRouting();
            MmkvManager mmkvManager = MmkvManager.INSTANCE;
            String strDecodeSettingsString = mmkvManager.decodeSettingsString(AppConfig.PREF_ROUTING_DOMAIN_STRATEGY);
            if (strDecodeSettingsString == null) {
                strDecodeSettingsString = "IPIfNonMatch";
            }
            routing.setDomainStrategy(strDecodeSettingsString);
            List<RulesetItem> listDecodeRoutingRulesets = mmkvManager.decodeRoutingRulesets();
            if (listDecodeRoutingRulesets == null) {
                return true;
            }
            Iterator<T> it = listDecodeRoutingRulesets.iterator();
            while (it.hasNext()) {
                INSTANCE.routingUserRule((RulesetItem) it.next(), v2rayConfig);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private final void routingUserRule(RulesetItem rulesetItem, V2rayConfig v2rayConfig) {
        if (rulesetItem != null) {
            try {
                if (rulesetItem.getEnabled()) {
                    JsonUtil jsonUtil = JsonUtil.INSTANCE;
                    v2rayConfig.getRouting().getRules().add((V2rayConfig.RoutingBean.RulesBean) jsonUtil.fromJson(jsonUtil.toJson(rulesetItem), V2rayConfig.RoutingBean.RulesBean.class));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0050 A[Catch: Exception -> 0x0026, TRY_LEAVE, TryCatch #0 {Exception -> 0x0026, blocks: (B:3:0x0003, B:6:0x0010, B:8:0x0021, B:12:0x002a, B:15:0x0032, B:17:0x0042, B:19:0x0048, B:22:0x0050, B:26:0x006d, B:28:0x007d, B:30:0x0083, B:32:0x0089, B:44:0x00b4, B:47:0x00c2, B:51:0x00cd, B:53:0x0156, B:35:0x0092, B:37:0x00a2, B:38:0x00a6, B:40:0x00ac), top: B:57:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:28:0x007d A[Catch: Exception -> 0x0026, TryCatch #0 {Exception -> 0x0026, blocks: (B:3:0x0003, B:6:0x0010, B:8:0x0021, B:12:0x002a, B:15:0x0032, B:17:0x0042, B:19:0x0048, B:22:0x0050, B:26:0x006d, B:28:0x007d, B:30:0x0083, B:32:0x0089, B:44:0x00b4, B:47:0x00c2, B:51:0x00cd, B:53:0x0156, B:35:0x0092, B:37:0x00a2, B:38:0x00a6, B:40:0x00ac), top: B:57:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0082  */
    /* JADX WARN: Code duplicated, block: B:35:0x0092 A[Catch: Exception -> 0x0026, TryCatch #0 {Exception -> 0x0026, blocks: (B:3:0x0003, B:6:0x0010, B:8:0x0021, B:12:0x002a, B:15:0x0032, B:17:0x0042, B:19:0x0048, B:22:0x0050, B:26:0x006d, B:28:0x007d, B:30:0x0083, B:32:0x0089, B:44:0x00b4, B:47:0x00c2, B:51:0x00cd, B:53:0x0156, B:35:0x0092, B:37:0x00a2, B:38:0x00a6, B:40:0x00ac), top: B:57:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a2 A[Catch: Exception -> 0x0026, TryCatch #0 {Exception -> 0x0026, blocks: (B:3:0x0003, B:6:0x0010, B:8:0x0021, B:12:0x002a, B:15:0x0032, B:17:0x0042, B:19:0x0048, B:22:0x0050, B:26:0x006d, B:28:0x007d, B:30:0x0083, B:32:0x0089, B:44:0x00b4, B:47:0x00c2, B:51:0x00cd, B:53:0x0156, B:35:0x0092, B:37:0x00a2, B:38:0x00a6, B:40:0x00ac), top: B:57:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ac A[Catch: Exception -> 0x0026, TryCatch #0 {Exception -> 0x0026, blocks: (B:3:0x0003, B:6:0x0010, B:8:0x0021, B:12:0x002a, B:15:0x0032, B:17:0x0042, B:19:0x0048, B:22:0x0050, B:26:0x006d, B:28:0x007d, B:30:0x0083, B:32:0x0089, B:44:0x00b4, B:47:0x00c2, B:51:0x00cd, B:53:0x0156, B:35:0x0092, B:37:0x00a2, B:38:0x00a6, B:40:0x00ac), top: B:57:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:53:0x0156 A[Catch: Exception -> 0x0026, TRY_LEAVE, TryCatch #0 {Exception -> 0x0026, blocks: (B:3:0x0003, B:6:0x0010, B:8:0x0021, B:12:0x002a, B:15:0x0032, B:17:0x0042, B:19:0x0048, B:22:0x0050, B:26:0x006d, B:28:0x007d, B:30:0x0083, B:32:0x0089, B:44:0x00b4, B:47:0x00c2, B:51:0x00cd, B:53:0x0156, B:35:0x0092, B:37:0x00a2, B:38:0x00a6, B:40:0x00ac), top: B:57:0x0003 }] */
    private final boolean updateOutboundFragment(V2rayConfig v2rayConfig) {
        String strDecodeSettingsString;
        String str;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings;
        String security;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings2;
        String strDecodeSettingsString2;
        String strDecodeSettingsString3;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings3;
        try {
            MmkvManager mmkvManager = MmkvManager.INSTANCE;
            if (mmkvManager.decodeSettingsBool(AppConfig.PREF_FRAGMENT_ENABLED, false)) {
                V2rayConfig.OutboundBean.StreamSettingsBean streamSettings4 = v2rayConfig.getOutbounds().get(0).getStreamSettings();
                if (e4.a(streamSettings4 != null ? streamSettings4.getSecurity() : null, AppConfig.TLS)) {
                    V2rayConfig.OutboundBean outboundBean = new V2rayConfig.OutboundBean(AppConfig.TAG_FRAGMENT, AppConfig.PROTOCOL_FREEDOM, null, null, null, null, null, 60, null);
                    strDecodeSettingsString = mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_PACKETS);
                    str = "tlshello";
                    if (strDecodeSettingsString == null) {
                        strDecodeSettingsString = "tlshello";
                    }
                    streamSettings = v2rayConfig.getOutbounds().get(0).getStreamSettings();
                    if (streamSettings != null) {
                        security = streamSettings.getSecurity();
                    } else {
                        security = null;
                    }
                    if (e4.a(security, AppConfig.REALITY) || !strDecodeSettingsString.equals("tlshello")) {
                        streamSettings2 = v2rayConfig.getOutbounds().get(0).getStreamSettings();
                        if (e4.a(streamSettings2 != null ? streamSettings2.getSecurity() : null, AppConfig.TLS) || strDecodeSettingsString.equals("tlshello")) {
                            str = strDecodeSettingsString;
                        }
                    } else {
                        str = "1-3";
                    }
                    strDecodeSettingsString2 = mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_LENGTH);
                    if (strDecodeSettingsString2 == null) {
                        strDecodeSettingsString2 = "50-100";
                    }
                    strDecodeSettingsString3 = mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_INTERVAL);
                    if (strDecodeSettingsString3 == null) {
                        strDecodeSettingsString3 = "10-20";
                    }
                    outboundBean.setSettings(new V2rayConfig.OutboundBean.OutSettingsBean(null, new V2rayConfig.OutboundBean.OutSettingsBean.FragmentBean(str, strDecodeSettingsString2, strDecodeSettingsString3), Collections.singletonList(new V2rayConfig.OutboundBean.OutSettingsBean.NoiseBean("rand", "10-20", "10-16")), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131065, null));
                    outboundBean.setStreamSettings(new V2rayConfig.OutboundBean.StreamSettingsBean(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new V2rayConfig.OutboundBean.StreamSettingsBean.SockoptBean(Boolean.TRUE, null, null, null, 255, null, 46, null), 32767, null));
                    v2rayConfig.getOutbounds().add(outboundBean);
                    streamSettings3 = v2rayConfig.getOutbounds().get(0).getStreamSettings();
                    if (streamSettings3 != null) {
                        streamSettings3.setSockopt(new V2rayConfig.OutboundBean.StreamSettingsBean.SockoptBean(null, null, null, null, null, AppConfig.TAG_FRAGMENT, 31, null));
                    }
                } else {
                    V2rayConfig.OutboundBean.StreamSettingsBean streamSettings5 = v2rayConfig.getOutbounds().get(0).getStreamSettings();
                    if (e4.a(streamSettings5 != null ? streamSettings5.getSecurity() : null, AppConfig.REALITY)) {
                        V2rayConfig.OutboundBean outboundBean2 = new V2rayConfig.OutboundBean(AppConfig.TAG_FRAGMENT, AppConfig.PROTOCOL_FREEDOM, null, null, null, null, null, 60, null);
                        strDecodeSettingsString = mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_PACKETS);
                        str = "tlshello";
                        if (strDecodeSettingsString == null) {
                            strDecodeSettingsString = "tlshello";
                        }
                        streamSettings = v2rayConfig.getOutbounds().get(0).getStreamSettings();
                        if (streamSettings != null) {
                            security = streamSettings.getSecurity();
                        } else {
                            security = null;
                        }
                        if (e4.a(security, AppConfig.REALITY)) {
                            streamSettings2 = v2rayConfig.getOutbounds().get(0).getStreamSettings();
                            if (e4.a(streamSettings2 != null ? streamSettings2.getSecurity() : null, AppConfig.TLS)) {
                                str = strDecodeSettingsString;
                            } else {
                                str = strDecodeSettingsString;
                            }
                        } else {
                            streamSettings2 = v2rayConfig.getOutbounds().get(0).getStreamSettings();
                            if (e4.a(streamSettings2 != null ? streamSettings2.getSecurity() : null, AppConfig.TLS)) {
                                str = strDecodeSettingsString;
                            } else {
                                str = strDecodeSettingsString;
                            }
                        }
                        strDecodeSettingsString2 = mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_LENGTH);
                        if (strDecodeSettingsString2 == null) {
                            strDecodeSettingsString2 = "50-100";
                        }
                        strDecodeSettingsString3 = mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_INTERVAL);
                        if (strDecodeSettingsString3 == null) {
                            strDecodeSettingsString3 = "10-20";
                        }
                        outboundBean2.setSettings(new V2rayConfig.OutboundBean.OutSettingsBean(null, new V2rayConfig.OutboundBean.OutSettingsBean.FragmentBean(str, strDecodeSettingsString2, strDecodeSettingsString3), Collections.singletonList(new V2rayConfig.OutboundBean.OutSettingsBean.NoiseBean("rand", "10-20", "10-16")), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131065, null));
                        outboundBean2.setStreamSettings(new V2rayConfig.OutboundBean.StreamSettingsBean(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new V2rayConfig.OutboundBean.StreamSettingsBean.SockoptBean(Boolean.TRUE, null, null, null, 255, null, 46, null), 32767, null));
                        v2rayConfig.getOutbounds().add(outboundBean2);
                        streamSettings3 = v2rayConfig.getOutbounds().get(0).getStreamSettings();
                        if (streamSettings3 != null) {
                            streamSettings3.setSockopt(new V2rayConfig.OutboundBean.StreamSettingsBean.SockoptBean(null, null, null, null, null, AppConfig.TAG_FRAGMENT, 31, null));
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private final boolean updateOutboundWithGlobalSettings(V2rayConfig.OutboundBean outboundBean) {
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean tcpSettings;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean header;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean.RequestBean request;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean.RequestBean.HeadersBean headers;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean tcpSettings2;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean header2;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean.RequestBean request2;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean tcpSettings3;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean header3;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean tcpSettings4;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean header4;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean.RequestBean request3;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean.RequestBean.HeadersBean headers2;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean tcpSettings5;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean header5;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean.RequestBean request4;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean tcpSettings6;
        V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean header6;
        List listSingletonList;
        V2rayConfig.OutboundBean.OutSettingsBean settings;
        List<V2rayConfig.OutboundBean.OutSettingsBean.VnextBean> vnext;
        V2rayConfig.OutboundBean.OutSettingsBean.VnextBean vnextBean;
        List<V2rayConfig.OutboundBean.OutSettingsBean.VnextBean.UsersBean> users;
        V2rayConfig.OutboundBean.OutSettingsBean.VnextBean.UsersBean usersBean;
        String flow;
        int i = 0;
        try {
            MmkvManager mmkvManager = MmkvManager.INSTANCE;
            boolean zDecodeSettingsBool = mmkvManager.decodeSettingsBool(AppConfig.PREF_MUX_ENABLED, false);
            String protocol = outboundBean.getProtocol();
            if (q31.X(protocol, "SHADOWSOCKS") || q31.X(protocol, "SOCKS") || q31.X(protocol, "HTTP") || q31.X(protocol, "TROJAN") || q31.X(protocol, "WIREGUARD") || q31.X(protocol, "HYSTERIA2") || (q31.X(protocol, "VLESS") && (settings = outboundBean.getSettings()) != null && (vnext = settings.getVnext()) != null && (vnextBean = (V2rayConfig.OutboundBean.OutSettingsBean.VnextBean) he.K0(vnext)) != null && (users = vnextBean.getUsers()) != null && (usersBean = (V2rayConfig.OutboundBean.OutSettingsBean.VnextBean.UsersBean) he.K0(users)) != null && (flow = usersBean.getFlow()) != null && flow.length() > 0)) {
                zDecodeSettingsBool = false;
            }
            if (zDecodeSettingsBool) {
                V2rayConfig.OutboundBean.MuxBean mux = outboundBean.getMux();
                if (mux != null) {
                    mux.setEnabled(true);
                }
                V2rayConfig.OutboundBean.MuxBean mux2 = outboundBean.getMux();
                if (mux2 != null) {
                    mux2.setConcurrency(mmkvManager.decodeSettingsInt(AppConfig.PREF_MUX_CONCURRENCY, 8));
                }
                V2rayConfig.OutboundBean.MuxBean mux3 = outboundBean.getMux();
                if (mux3 != null) {
                    mux3.setXudpConcurrency(mmkvManager.decodeSettingsInt(AppConfig.PREF_MUX_XUDP_CONCURRENCY, 16));
                }
                V2rayConfig.OutboundBean.MuxBean mux4 = outboundBean.getMux();
                if (mux4 != null) {
                    String strDecodeSettingsString = mmkvManager.decodeSettingsString(AppConfig.PREF_MUX_XUDP_QUIC);
                    if (strDecodeSettingsString == null) {
                        strDecodeSettingsString = "reject";
                    }
                    mux4.setXudpProxyUDP443(strDecodeSettingsString);
                }
            } else {
                V2rayConfig.OutboundBean.MuxBean mux5 = outboundBean.getMux();
                if (mux5 != null) {
                    mux5.setEnabled(false);
                }
                V2rayConfig.OutboundBean.MuxBean mux6 = outboundBean.getMux();
                if (mux6 != null) {
                    mux6.setConcurrency(-1);
                }
            }
            boolean zX = q31.X(protocol, "WIREGUARD");
            List<String> host = null;
            if (zX) {
                V2rayConfig.OutboundBean.OutSettingsBean settings2 = outboundBean.getSettings();
                if ((settings2 != null ? settings2.getAddress() : null) == null) {
                    listSingletonList = Arrays.asList(AppConfig.WIREGUARD_LOCAL_ADDRESS_V4, AppConfig.WIREGUARD_LOCAL_ADDRESS_V6);
                } else {
                    V2rayConfig.OutboundBean.OutSettingsBean settings3 = outboundBean.getSettings();
                    listSingletonList = (List) (settings3 != null ? settings3.getAddress() : null);
                }
                if (!mmkvManager.decodeSettingsBool(AppConfig.PREF_PREFER_IPV6)) {
                    listSingletonList = Collections.singletonList(he.K0(listSingletonList));
                }
                V2rayConfig.OutboundBean.OutSettingsBean settings4 = outboundBean.getSettings();
                if (settings4 != null) {
                    settings4.setAddress(listSingletonList);
                }
            }
            V2rayConfig.OutboundBean.StreamSettingsBean streamSettings = outboundBean.getStreamSettings();
            if (e4.a(streamSettings != null ? streamSettings.getNetwork() : null, AppConfig.DEFAULT_NETWORK)) {
                V2rayConfig.OutboundBean.StreamSettingsBean streamSettings2 = outboundBean.getStreamSettings();
                if (e4.a((streamSettings2 == null || (tcpSettings6 = streamSettings2.getTcpSettings()) == null || (header6 = tcpSettings6.getHeader()) == null) ? null : header6.getType(), AppConfig.HEADER_TYPE_HTTP)) {
                    V2rayConfig.OutboundBean.StreamSettingsBean streamSettings3 = outboundBean.getStreamSettings();
                    List<String> path = (streamSettings3 == null || (tcpSettings5 = streamSettings3.getTcpSettings()) == null || (header5 = tcpSettings5.getHeader()) == null || (request4 = header5.getRequest()) == null) ? null : request4.getPath();
                    V2rayConfig.OutboundBean.StreamSettingsBean streamSettings4 = outboundBean.getStreamSettings();
                    if (streamSettings4 != null && (tcpSettings4 = streamSettings4.getTcpSettings()) != null && (header4 = tcpSettings4.getHeader()) != null && (request3 = header4.getRequest()) != null && (headers2 = request3.getHeaders()) != null) {
                        host = headers2.getHost();
                    }
                    v41 v41Var = new v41(new uh0(2, i));
                    V2rayConfig.OutboundBean.StreamSettingsBean streamSettings5 = outboundBean.getStreamSettings();
                    if (streamSettings5 != null && (tcpSettings3 = streamSettings5.getTcpSettings()) != null && (header3 = tcpSettings3.getHeader()) != null) {
                        header3.setRequest((V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean.RequestBean) JsonUtil.INSTANCE.fromJson(updateOutboundWithGlobalSettings$lambda$9(v41Var), V2rayConfig.OutboundBean.StreamSettingsBean.TcpSettingsBean.HeaderBean.RequestBean.class));
                    }
                    V2rayConfig.OutboundBean.StreamSettingsBean streamSettings6 = outboundBean.getStreamSettings();
                    if (streamSettings6 != null && (tcpSettings2 = streamSettings6.getTcpSettings()) != null && (header2 = tcpSettings2.getHeader()) != null && (request2 = header2.getRequest()) != null) {
                        if (path == null || path.isEmpty()) {
                            path = Collections.singletonList(InternalZipConstants.ZIP_FILE_SEPARATOR);
                        }
                        request2.setPath(path);
                    }
                    V2rayConfig.OutboundBean.StreamSettingsBean streamSettings7 = outboundBean.getStreamSettings();
                    if (streamSettings7 != null && (tcpSettings = streamSettings7.getTcpSettings()) != null && (header = tcpSettings.getHeader()) != null && (request = header.getRequest()) != null && (headers = request.getHeaders()) != null) {
                        headers.setHost(host);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String updateOutboundWithGlobalSettings$lambda$8() {
        return "{\"version\":\"1.1\",\"method\":\"GET\",\"headers\":{\"User-Agent\":[\"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.6478.122 Mobile Safari/537.36\"],\"Accept-Encoding\":[\"gzip, deflate\"],\"Connection\":[\"keep-alive\"],\"Pragma\":\"no-cache\"}}";
    }

    private static final String updateOutboundWithGlobalSettings$lambda$9(rc0 rc0Var) {
        return (String) rc0Var.getValue();
    }

    private final ArrayList<String> userRule2Domain(String str) {
        List<String> domain;
        List<String> domain2;
        ArrayList<String> arrayList = new ArrayList<>();
        List<RulesetItem> listDecodeRoutingRulesets = MmkvManager.INSTANCE.decodeRoutingRulesets();
        if (listDecodeRoutingRulesets != null) {
            for (RulesetItem rulesetItem : listDecodeRoutingRulesets) {
                if (rulesetItem != null && rulesetItem.getEnabled() && e4.a(rulesetItem.getOutboundTag(), str) && (domain = rulesetItem.getDomain()) != null && !domain.isEmpty() && (domain2 = rulesetItem.getDomain()) != null) {
                    for (String str2 : domain2) {
                        if (!e4.a(str2, AppConfig.GEOSITE_PRIVATE) && (str2.startsWith("geosite:") || str2.startsWith("domain:"))) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final V2rayConfig.OutboundBean getProxyOutbound(ProfileItem profileItem) {
        switch (WhenMappings.$EnumSwitchMapping$0[profileItem.getConfigType().ordinal()]) {
            case 1:
                return VmessFmt.INSTANCE.toOutbound(profileItem);
            case 2:
                return null;
            case 3:
                return ShadowsocksFmt.INSTANCE.toOutbound(profileItem);
            case 4:
                return SocksFmt.INSTANCE.toOutbound(profileItem);
            case 5:
                return VlessFmt.INSTANCE.toOutbound(profileItem);
            case 6:
                return TrojanFmt.INSTANCE.toOutbound(profileItem);
            case 7:
                return WireguardFmt.INSTANCE.toOutbound(profileItem);
            case 8:
                return Hysteria2Fmt.INSTANCE.toOutbound(profileItem);
            case 9:
                return HttpFmt.INSTANCE.toOutbound(profileItem);
            default:
                d.AnonymousClass0.m();
                return null;
        }
    }

    public final ConfigResult getV2rayConfig(Context context, String str) {
        try {
            MmkvManager mmkvManager = MmkvManager.INSTANCE;
            ProfileItem profileItemDecodeServerConfig = mmkvManager.decodeServerConfig(context, str);
            if (profileItemDecodeServerConfig == null) {
                return new ConfigResult(false, null, null, null, 14, null);
            }
            if (profileItemDecodeServerConfig.getConfigType() != EConfigType.CUSTOM) {
                ConfigResult v2rayNonCustomConfig = getV2rayNonCustomConfig(context, profileItemDecodeServerConfig);
                v2rayNonCustomConfig.setGuid(str);
                return v2rayNonCustomConfig;
            }
            String strDecodeServerRaw = mmkvManager.decodeServerRaw(context, str);
            if (strDecodeServerRaw != null) {
                return new ConfigResult(true, str, strDecodeServerRaw, profileItemDecodeServerConfig.getServerAddressAndPort());
            }
            return new ConfigResult(false, null, null, null, 14, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ConfigResult(false, null, null, null, 14, null);
        }
    }
}
