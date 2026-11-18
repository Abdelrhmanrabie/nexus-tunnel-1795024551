package renz.javacodez.v2ray.fmtkt;

import android.text.TextUtils;
import defpackage.e4;
import defpackage.he;
import defpackage.q31;
import java.net.URI;
import java.util.List;
import java.util.Map;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.NetworkType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.V2rayConfig;
import renz.javacodez.v2ray.dto.VmessQRCode;
import renz.javacodez.v2ray.extension._ExtKt;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.util.JsonUtil;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class VmessFmt extends FmtBase {
    public static final VmessFmt INSTANCE = new VmessFmt();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkType.values().length];
            try {
                iArr[NetworkType.KCP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkType.GRPC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private VmessFmt() {
    }

    public final ProfileItem parse(String str) {
        if (q31.j0(str, '?', 0, 6) > 0 && q31.j0(str, '&', 0, 6) > 0) {
            return parseVmessStd(str);
        }
        boolean zDecodeSettingsBool = MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_ALLOW_INSECURE, false);
        ProfileItem.Companion companion = ProfileItem.Companion;
        EConfigType eConfigType = EConfigType.VMESS;
        ProfileItem profileItemCreate = companion.create(eConfigType);
        String strDecode = Utils.INSTANCE.decode(q31.b0(str, eConfigType.getProtocolScheme(), AppConfig.CUSTOM));
        if (TextUtils.isEmpty(strDecode)) {
            return null;
        }
        VmessQRCode vmessQRCode = (VmessQRCode) JsonUtil.INSTANCE.fromJson(strDecode, VmessQRCode.class);
        if (TextUtils.isEmpty(vmessQRCode.getAdd()) || TextUtils.isEmpty(vmessQRCode.getPort()) || TextUtils.isEmpty(vmessQRCode.getId()) || TextUtils.isEmpty(vmessQRCode.getNet())) {
            return null;
        }
        profileItemCreate.setRemarks(vmessQRCode.getPs());
        profileItemCreate.setServer(vmessQRCode.getAdd());
        profileItemCreate.setServerPort(vmessQRCode.getPort());
        profileItemCreate.setPassword(vmessQRCode.getId());
        profileItemCreate.setMethod(TextUtils.isEmpty(vmessQRCode.getScy()) ? AppConfig.DEFAULT_SECURITY : vmessQRCode.getScy());
        profileItemCreate.setNetwork(vmessQRCode.getNet());
        profileItemCreate.setHeaderType(vmessQRCode.getType());
        profileItemCreate.setHost(vmessQRCode.getHost());
        profileItemCreate.setPath(vmessQRCode.getPath());
        int i = WhenMappings.$EnumSwitchMapping$0[NetworkType.Companion.fromString(profileItemCreate.getNetwork()).ordinal()];
        if (i == 1) {
            profileItemCreate.setSeed(vmessQRCode.getPath());
        } else if (i == 2) {
            profileItemCreate.setMode(vmessQRCode.getType());
            profileItemCreate.setServiceName(vmessQRCode.getPath());
            profileItemCreate.setAuthority(vmessQRCode.getHost());
        }
        profileItemCreate.setSecurity(vmessQRCode.getTls());
        profileItemCreate.setInsecure(Boolean.valueOf(zDecodeSettingsBool));
        profileItemCreate.setSni(vmessQRCode.getSni());
        profileItemCreate.setFingerPrint(vmessQRCode.getFp());
        profileItemCreate.setAlpn(vmessQRCode.getAlpn());
        return profileItemCreate;
    }

    public final ProfileItem parseVmessStd(String str) {
        boolean zDecodeSettingsBool = MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_ALLOW_INSECURE, false);
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.VMESS);
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
        profileItemCreate.setMethod(AppConfig.DEFAULT_SECURITY);
        getItemFormQuery(profileItemCreate, queryParam, zDecodeSettingsBool);
        return profileItemCreate;
    }

    public final V2rayConfig.OutboundBean toOutbound(ProfileItem profileItem) {
        String sni;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings;
        V2rayConfig.OutboundBean.StreamSettingsBean streamSettings2;
        V2rayConfig.OutboundBean.OutSettingsBean settings;
        List<V2rayConfig.OutboundBean.OutSettingsBean.VnextBean> vnext;
        V2rayConfig.OutboundBean.OutSettingsBean.VnextBean vnextBean;
        V2rayConfig.OutboundBean outboundBeanCreate = V2rayConfig.OutboundBean.Companion.create(EConfigType.VMESS);
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
            vnextBean.getUsers().get(0).setSecurity(profileItem.getMethod());
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
            streamSettings.populateTlsSettings(security, zA, sni, profileItem.getFingerPrint(), profileItem.getAlpn(), null, null, null);
        }
        return outboundBeanCreate;
    }

    public final String toUri(ProfileItem profileItem) {
        VmessQRCode vmessQRCode = new VmessQRCode(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        vmessQRCode.setV("2");
        vmessQRCode.setPs(profileItem.getRemarks());
        String server = profileItem.getServer();
        String str = AppConfig.CUSTOM;
        if (server == null) {
            server = AppConfig.CUSTOM;
        }
        vmessQRCode.setAdd(server);
        String serverPort = profileItem.getServerPort();
        if (serverPort == null) {
            serverPort = AppConfig.CUSTOM;
        }
        vmessQRCode.setPort(serverPort);
        String password = profileItem.getPassword();
        if (password == null) {
            password = AppConfig.CUSTOM;
        }
        vmessQRCode.setId(password);
        String method = profileItem.getMethod();
        if (method == null) {
            method = AppConfig.CUSTOM;
        }
        vmessQRCode.setScy(method);
        vmessQRCode.setAid("0");
        String network = profileItem.getNetwork();
        if (network == null) {
            network = AppConfig.CUSTOM;
        }
        vmessQRCode.setNet(network);
        String headerType = profileItem.getHeaderType();
        if (headerType == null) {
            headerType = AppConfig.CUSTOM;
        }
        vmessQRCode.setType(headerType);
        int i = WhenMappings.$EnumSwitchMapping$0[NetworkType.Companion.fromString(profileItem.getNetwork()).ordinal()];
        if (i == 1) {
            String seed = profileItem.getSeed();
            if (seed == null) {
                seed = AppConfig.CUSTOM;
            }
            vmessQRCode.setPath(seed);
        } else if (i == 2) {
            String mode = profileItem.getMode();
            if (mode == null) {
                mode = AppConfig.CUSTOM;
            }
            vmessQRCode.setType(mode);
            String serviceName = profileItem.getServiceName();
            if (serviceName == null) {
                serviceName = AppConfig.CUSTOM;
            }
            vmessQRCode.setPath(serviceName);
            String authority = profileItem.getAuthority();
            if (authority == null) {
                authority = AppConfig.CUSTOM;
            }
            vmessQRCode.setHost(authority);
        }
        String host = profileItem.getHost();
        if (host != null && host.length() > 0) {
            vmessQRCode.setHost(host);
        }
        String path = profileItem.getPath();
        if (path != null && path.length() > 0) {
            vmessQRCode.setPath(path);
        }
        String security = profileItem.getSecurity();
        if (security == null) {
            security = AppConfig.CUSTOM;
        }
        vmessQRCode.setTls(security);
        String sni = profileItem.getSni();
        if (sni == null) {
            sni = AppConfig.CUSTOM;
        }
        vmessQRCode.setSni(sni);
        String fingerPrint = profileItem.getFingerPrint();
        if (fingerPrint == null) {
            fingerPrint = AppConfig.CUSTOM;
        }
        vmessQRCode.setFp(fingerPrint);
        String alpn = profileItem.getAlpn();
        if (alpn != null) {
            str = alpn;
        }
        vmessQRCode.setAlpn(str);
        return Utils.INSTANCE.encode(JsonUtil.INSTANCE.toJson(vmessQRCode));
    }
}
