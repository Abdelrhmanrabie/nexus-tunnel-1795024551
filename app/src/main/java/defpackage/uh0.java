package defpackage;

import renz.javacodez.v2ray.handler.MigrateManager;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.handler.V2rayConfigManager;
import renz.javacodez.v2ray.plugin.PluginManager;
import renz.javacodez.v2ray.service.V2RayTestService;
import renz.javacodez.v2ray.service.V2RayVpnService;
import renz.javacodez.v2ray.util.PluginUtil;
import renz.javacodez.v2ray.viewmodel.MainViewModel;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class uh0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ int b;

    public /* synthetic */ uh0(int i, int i2) {
        this.G0 = i2;
        this.b = i;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        int i2 = this.b;
        if (i == 0) {
            if (i2 == 0) {
                return MigrateManager.serverStorage_delegate$lambda$0();
            }
            if (i2 != 1) {
                return i2 != 2 ? MainViewModel.tcpingTestScope_delegate$lambda$3() : V2rayConfigManager.updateOutboundWithGlobalSettings$lambda$8();
            }
            return MmkvManager.serverAffStorage_delegate$lambda$3();
        }
        if (i == 1) {
            if (i2 == 0) {
                return MmkvManager.mainStorage_delegate$lambda$0();
            }
            if (i2 == 1) {
                return MmkvManager.subStorage_delegate$lambda$4();
            }
            if (i2 != 2) {
                return i2 != 3 ? MainViewModel.isRunning_delegate$lambda$0() : V2RayVpnService.defaultNetworkRequest_delegate$lambda$0();
            }
            return V2RayTestService.realTestScope_delegate$lambda$0();
        }
        if (i != 2) {
            if (i2 == 0) {
                return MmkvManager.serverRawStorage_delegate$lambda$2();
            }
            if (i2 != 1) {
                return i2 != 2 ? MainViewModel.updateTestResultAction_delegate$lambda$2() : PluginManager.fetchPlugins$lambda$2$lambda$1();
            }
            return MmkvManager.settingsStorage_delegate$lambda$6();
        }
        if (i2 == 0) {
            return MmkvManager.profileFullStorage_delegate$lambda$1();
        }
        if (i2 != 1) {
            return i2 != 2 ? MainViewModel.updateListAction_delegate$lambda$1() : PluginUtil.procService_delegate$lambda$0();
        }
        return MmkvManager.assetStorage_delegate$lambda$5();
    }
}
