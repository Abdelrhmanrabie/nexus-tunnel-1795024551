package renz.javacodez.v2ray.fmtkt;

import defpackage.he;
import java.util.Collections;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.V2rayConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class HttpFmt extends FmtBase {
    public static final HttpFmt INSTANCE = new HttpFmt();

    private HttpFmt() {
    }

    public final V2rayConfig.OutboundBean toOutbound(ProfileItem profileItem) {
        V2rayConfig.OutboundBean.OutSettingsBean settings;
        List<V2rayConfig.OutboundBean.OutSettingsBean.ServersBean> servers;
        V2rayConfig.OutboundBean.OutSettingsBean.ServersBean serversBean;
        V2rayConfig.OutboundBean outboundBeanCreate = V2rayConfig.OutboundBean.Companion.create(EConfigType.HTTP);
        if (outboundBeanCreate != null && (settings = outboundBeanCreate.getSettings()) != null && (servers = settings.getServers()) != null && (serversBean = (V2rayConfig.OutboundBean.OutSettingsBean.ServersBean) he.K0(servers)) != null) {
            String server = profileItem.getServer();
            String str = AppConfig.CUSTOM;
            if (server == null) {
                server = AppConfig.CUSTOM;
            }
            serversBean.setAddress(server);
            String serverPort = profileItem.getServerPort();
            if (serverPort == null) {
                serverPort = AppConfig.CUSTOM;
            }
            serversBean.setPort(Integer.parseInt(serverPort));
            String username = profileItem.getUsername();
            if (username != null && username.length() > 0) {
                V2rayConfig.OutboundBean.OutSettingsBean.ServersBean.SocksUsersBean socksUsersBean = new V2rayConfig.OutboundBean.OutSettingsBean.ServersBean.SocksUsersBean(null, null, 0, 7, null);
                String username2 = profileItem.getUsername();
                if (username2 == null) {
                    username2 = AppConfig.CUSTOM;
                }
                socksUsersBean.setUser(username2);
                String password = profileItem.getPassword();
                if (password != null) {
                    str = password;
                }
                socksUsersBean.setPass(str);
                serversBean.setUsers(Collections.singletonList(socksUsersBean));
            }
        }
        return outboundBeanCreate;
    }
}
