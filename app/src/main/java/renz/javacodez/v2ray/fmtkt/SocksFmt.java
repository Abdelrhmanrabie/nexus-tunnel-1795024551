package renz.javacodez.v2ray.fmtkt;

import defpackage.he;
import defpackage.q31;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.V2rayConfig;
import renz.javacodez.v2ray.extension._ExtKt;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SocksFmt extends FmtBase {
    public static final SocksFmt INSTANCE = new SocksFmt();

    private SocksFmt() {
    }

    public final ProfileItem parse(String str) {
        ProfileItem profileItemCreate = ProfileItem.Companion.create(EConfigType.SOCKS);
        Utils utils = Utils.INSTANCE;
        URI uri = new URI(utils.fixIllegalUrl(str));
        if (_ExtKt.getIdnHost(uri).length() == 0 || uri.getPort() <= 0) {
            return null;
        }
        String fragment = uri.getFragment();
        if (fragment == null) {
            fragment = AppConfig.CUSTOM;
        }
        profileItemCreate.setRemarks(utils.urlDecode(fragment));
        profileItemCreate.setServer(_ExtKt.getIdnHost(uri));
        profileItemCreate.setServerPort(String.valueOf(uri.getPort()));
        String userInfo = uri.getUserInfo();
        if (userInfo != null && userInfo.length() != 0) {
            List listS0 = q31.s0(utils.decode(uri.getUserInfo()), new String[]{":"}, 2);
            if (listS0.size() == 2) {
                profileItemCreate.setUsername((String) he.K0(listS0));
                profileItemCreate.setPassword((String) he.T0(listS0));
            }
        }
        return profileItemCreate;
    }

    public final V2rayConfig.OutboundBean toOutbound(ProfileItem profileItem) {
        V2rayConfig.OutboundBean.OutSettingsBean settings;
        List<V2rayConfig.OutboundBean.OutSettingsBean.ServersBean> servers;
        V2rayConfig.OutboundBean.OutSettingsBean.ServersBean serversBean;
        V2rayConfig.OutboundBean outboundBeanCreate = V2rayConfig.OutboundBean.Companion.create(EConfigType.SOCKS);
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

    public final String toUri(ProfileItem profileItem) {
        String str;
        String username = profileItem.getUsername();
        if (username == null || username.length() <= 0) {
            str = ":";
        } else {
            str = profileItem.getUsername() + ':' + profileItem.getPassword();
        }
        return toUri(profileItem, Utils.INSTANCE.encode(str), null);
    }
}
