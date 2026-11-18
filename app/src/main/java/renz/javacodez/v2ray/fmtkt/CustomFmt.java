package renz.javacodez.v2ray.fmtkt;

import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.V2rayConfig;
import renz.javacodez.v2ray.util.JsonUtil;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class CustomFmt extends FmtBase {
    public static final CustomFmt INSTANCE = new CustomFmt();

    private CustomFmt() {
    }

    public final ProfileItem parse(String str) {
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.CUSTOM);
        V2rayConfig v2rayConfig = (V2rayConfig) JsonUtil.INSTANCE.fromJson(str, V2rayConfig.class);
        V2rayConfig.OutboundBean proxyOutbound = v2rayConfig.getProxyOutbound();
        String remarks = v2rayConfig.getRemarks();
        if (remarks == null) {
            remarks = String.valueOf(System.currentTimeMillis());
        }
        profileItemCreate.setRemarks(remarks);
        profileItemCreate.setServer(proxyOutbound != null ? proxyOutbound.getServerAddress() : null);
        profileItemCreate.setServerPort(String.valueOf(proxyOutbound != null ? proxyOutbound.getServerPort() : null));
        return profileItemCreate;
    }
}
