package renz.javacodez.v2ray.viewmodel;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.os.Build;
import defpackage.ae;
import defpackage.ai;
import defpackage.bx;
import defpackage.d;
import defpackage.e;
import defpackage.e4;
import defpackage.h70;
import defpackage.he;
import defpackage.jo0;
import defpackage.q31;
import defpackage.r3;
import defpackage.rc0;
import defpackage.t41;
import defpackage.tb1;
import defpackage.ti;
import defpackage.uh0;
import defpackage.ui;
import defpackage.uo;
import defpackage.v41;
import defpackage.vi;
import defpackage.yi0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.V2RAYApp;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.dto.ServerAffiliationInfo;
import renz.javacodez.v2ray.dto.ServersCache;
import renz.javacodez.v2ray.fmtkt.CustomFmt;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.handler.SettingsManager;
import renz.javacodez.v2ray.util.MessageUtil;
import renz.javacodez.v2ray.util.SpeedtestUtil;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MainViewModel extends r3 {
    private final rc0 isRunning$delegate;
    private String keywordFilter;
    private final MainViewModel$mMsgReceiver$1 mMsgReceiver;
    private List<String> serverList;
    private final List<ServersCache> serversCache;
    private String subscriptionId;
    private final rc0 tcpingTestScope$delegate;
    private final rc0 updateListAction$delegate;
    private final rc0 updateTestResultAction$delegate;

    /* JADX INFO: renamed from: renz.javacodez.v2ray.viewmodel.MainViewModel$initAssets$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class AnonymousClass1 extends t41 implements bx {
        final /* synthetic */ AssetManager $assets;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AssetManager assetManager, ai aiVar) {
            super(aiVar);
            this.$assets = assetManager;
        }

        @Override // defpackage.i8
        public final ai create(Object obj, ai aiVar) {
            return MainViewModel.this.new AnonymousClass1(this.$assets, aiVar);
        }

        @Override // defpackage.bx
        public final Object invoke(ti tiVar, ai aiVar) {
            return ((AnonymousClass1) create(tiVar, aiVar)).invokeSuspend(tb1.a);
        }

        @Override // defpackage.i8
        public final Object invokeSuspend(Object obj) throws Throwable {
            vi viVar = vi.b;
            if (this.label != 0) {
                d.AnonymousClass0.m("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            e4.b(obj);
            SettingsManager.INSTANCE.initAssets(MainViewModel.this.getApplication(), this.$assets);
            return tb1.a;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class ServerDelay {
        private String guid;
        private long testDelayMillis;

        public ServerDelay(String str, long j) {
            this.guid = str;
            this.testDelayMillis = j;
        }

        public static /* synthetic */ ServerDelay copy$default(ServerDelay serverDelay, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = serverDelay.guid;
            }
            if ((i & 2) != 0) {
                j = serverDelay.testDelayMillis;
            }
            return serverDelay.copy(str, j);
        }

        public final String component1() {
            return this.guid;
        }

        public final long component2() {
            return this.testDelayMillis;
        }

        public final ServerDelay copy(String str, long j) {
            return new ServerDelay(str, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ServerDelay)) {
                return false;
            }
            ServerDelay serverDelay = (ServerDelay) obj;
            return e4.a(this.guid, serverDelay.guid) && this.testDelayMillis == serverDelay.testDelayMillis;
        }

        public final String getGuid() {
            return this.guid;
        }

        public final long getTestDelayMillis() {
            return this.testDelayMillis;
        }

        public int hashCode() {
            int iHashCode = this.guid.hashCode() * 31;
            long j = this.testDelayMillis;
            return iHashCode + ((int) (j ^ (j >>> 32)));
        }

        public final void setGuid(String str) {
            this.guid = str;
        }

        public final void setTestDelayMillis(long j) {
            this.testDelayMillis = j;
        }

        public String toString() {
            return "ServerDelay(guid=" + this.guid + ", testDelayMillis=" + this.testDelayMillis + ')';
        }
    }

    /* JADX INFO: renamed from: renz.javacodez.v2ray.viewmodel.MainViewModel$testAllRealPing$2, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class AnonymousClass2 extends t41 implements bx {
        final /* synthetic */ List<ServersCache> $serversCopy;
        int label;
        final /* synthetic */ MainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<ServersCache> list, MainViewModel mainViewModel, ai aiVar) {
            super(aiVar);
            this.$serversCopy = list;
            this.this$0 = mainViewModel;
        }

        @Override // defpackage.i8
        public final ai create(Object obj, ai aiVar) {
            return new AnonymousClass2(this.$serversCopy, this.this$0, aiVar);
        }

        @Override // defpackage.bx
        public final Object invoke(ti tiVar, ai aiVar) {
            return ((AnonymousClass2) create(tiVar, aiVar)).invokeSuspend(tb1.a);
        }

        @Override // defpackage.i8
        public final Object invokeSuspend(Object obj) throws Throwable {
            vi viVar = vi.b;
            if (this.label != 0) {
                d.AnonymousClass0.m("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            e4.b(obj);
            Iterator<ServersCache> it = this.$serversCopy.iterator();
            while (it.hasNext()) {
                MessageUtil.INSTANCE.sendMsg2TestService(this.this$0.getApplication(), 7, it.next().getGuid());
            }
            return tb1.a;
        }
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [renz.javacodez.v2ray.viewmodel.MainViewModel$mMsgReceiver$1] */
    public MainViewModel(Application application) {
        super(application);
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        this.serverList = mmkvManager.decodeServerList();
        String strDecodeSettingsString = mmkvManager.decodeSettingsString(AppConfig.CACHE_SUBSCRIPTION_ID, AppConfig.CUSTOM);
        this.subscriptionId = strDecodeSettingsString == null ? AppConfig.CUSTOM : strDecodeSettingsString;
        this.keywordFilter = AppConfig.CUSTOM;
        this.serversCache = new ArrayList();
        this.isRunning$delegate = new v41(new uh0(4, 1));
        int i = 3;
        this.updateListAction$delegate = new v41(new uh0(i, 2));
        this.updateTestResultAction$delegate = new v41(new uh0(i, i));
        this.tcpingTestScope$delegate = new v41(new uh0(i, 0));
        this.mMsgReceiver = new BroadcastReceiver() { // from class: renz.javacodez.v2ray.viewmodel.MainViewModel$mMsgReceiver$1
            /* JADX WARN: Code duplicated, block: B:20:0x0033  */
            /* JADX WARN: Code duplicated, block: B:30:0x0053  */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Object serializableExtra;
                yi0 updateTestResultAction;
                Object stringExtra;
                Integer numValueOf = intent != null ? Integer.valueOf(intent.getIntExtra("key", 0)) : null;
                if (numValueOf != null && numValueOf.intValue() == 11) {
                    updateTestResultAction = this.this$0.isRunning();
                    stringExtra = Boolean.TRUE;
                } else if (numValueOf != null && numValueOf.intValue() == 12) {
                    updateTestResultAction = this.this$0.isRunning();
                    stringExtra = Boolean.FALSE;
                } else if (numValueOf != null && numValueOf.intValue() == 31) {
                    updateTestResultAction = this.this$0.isRunning();
                    stringExtra = Boolean.TRUE;
                } else if ((numValueOf != null && numValueOf.intValue() == 32) || (numValueOf != null && numValueOf.intValue() == 41)) {
                    updateTestResultAction = this.this$0.isRunning();
                    stringExtra = Boolean.FALSE;
                } else {
                    if (numValueOf == null || numValueOf.intValue() != 61) {
                        if (numValueOf != null && numValueOf.intValue() == 71) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                serializableExtra = intent.getSerializableExtra("content", jo0.class);
                            } else {
                                Object serializableExtra2 = intent.getSerializableExtra("content");
                                serializableExtra = (jo0) (serializableExtra2 instanceof jo0 ? serializableExtra2 : null);
                            }
                            jo0 jo0Var = (jo0) serializableExtra;
                            if (jo0Var == null) {
                                return;
                            }
                            String str = (String) jo0Var.b;
                            MmkvManager.INSTANCE.encodeServerTestDelayMillis(str, ((Number) jo0Var.c).longValue());
                            this.this$0.getUpdateListAction().i(Integer.valueOf(this.this$0.getPosition(str)));
                            return;
                        }
                        return;
                    }
                    updateTestResultAction = this.this$0.getUpdateTestResultAction();
                    stringExtra = intent.getStringExtra("content");
                }
                updateTestResultAction.i(stringExtra);
            }
        };
    }

    private final ti getTcpingTestScope() {
        return (ti) this.tcpingTestScope$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yi0 isRunning_delegate$lambda$0() {
        return new yi0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ti tcpingTestScope_delegate$lambda$3() {
        return ui.a(uo.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yi0 updateListAction_delegate$lambda$1() {
        return new yi0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yi0 updateTestResultAction_delegate$lambda$2() {
        return new yi0();
    }

    public final boolean appendCustomConfigServer(String str) {
        if (q31.e0(str, "inbounds") && q31.e0(str, "outbounds") && q31.e0(str, "routing")) {
            try {
                ProfileItem profileItem = CustomFmt.INSTANCE.parse(str);
                if (profileItem != null) {
                    profileItem.setSubscriptionId(this.subscriptionId);
                    MmkvManager mmkvManager = MmkvManager.INSTANCE;
                    String strEncodeServerConfig = mmkvManager.encodeServerConfig(AppConfig.CUSTOM, profileItem);
                    mmkvManager.encodeServerRaw(strEncodeServerConfig, str);
                    this.serverList.add(0, strEncodeServerConfig);
                    this.serversCache.add(0, new ServersCache(strEncodeServerConfig, profileItem));
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final String getKeywordFilter() {
        return this.keywordFilter;
    }

    public final int getPosition(String str) {
        int i = 0;
        for (Object obj : this.serversCache) {
            int i2 = i + 1;
            if (i < 0) {
                e.q0();
                throw null;
            }
            if (e4.a(((ServersCache) obj).getGuid(), str)) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    public final List<ServersCache> getServersCache() {
        return this.serversCache;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final yi0 getUpdateListAction() {
        return (yi0) this.updateListAction$delegate.getValue();
    }

    public final yi0 getUpdateTestResultAction() {
        return (yi0) this.updateTestResultAction$delegate.getValue();
    }

    public final void initAssets(AssetManager assetManager) {
        e.Y0(e.w(this), uo.a, new AnonymousClass1(assetManager, null), 2);
    }

    public final yi0 isRunning() {
        return (yi0) this.isRunning$delegate.getValue();
    }

    @Override // defpackage.zd1
    public void onCleared() {
        ((V2RAYApp) getApplication()).unregisterReceiver(this.mMsgReceiver);
        h70 h70Var = (h70) getTcpingTestScope().x().a(e.b$1);
        if (h70Var != null) {
            e.A0(h70Var);
        }
        SpeedtestUtil.INSTANCE.closeAllTcpSockets();
    }

    public final int removeAllServer() {
        if (this.subscriptionId.length() == 0 && this.keywordFilter.length() == 0) {
            return MmkvManager.INSTANCE.removeAllServer();
        }
        Iterator it = he.g1(this.serversCache).iterator();
        while (it.hasNext()) {
            MmkvManager.INSTANCE.removeServer(((ServersCache) it.next()).getGuid());
        }
        return he.g1(this.serversCache).size();
    }

    public final int removeInvalidServer() {
        if (this.subscriptionId.length() == 0 && this.keywordFilter.length() == 0) {
            return MmkvManager.INSTANCE.removeInvalidServer(AppConfig.CUSTOM);
        }
        Iterator it = he.g1(this.serversCache).iterator();
        int iRemoveInvalidServer = 0;
        while (it.hasNext()) {
            iRemoveInvalidServer += MmkvManager.INSTANCE.removeInvalidServer(((ServersCache) it.next()).getGuid());
        }
        return iRemoveInvalidServer;
    }

    public final void setKeywordFilter(String str) {
        this.keywordFilter = str;
    }

    public final void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    public final void sortByTestResults() {
        ArrayList<ServerDelay> arrayList = new ArrayList();
        List<String> listDecodeServerList = MmkvManager.INSTANCE.decodeServerList();
        for (String str : listDecodeServerList) {
            ServerAffiliationInfo serverAffiliationInfoDecodeServerAffiliationInfo = MmkvManager.INSTANCE.decodeServerAffiliationInfo(str);
            long testDelayMillis = serverAffiliationInfoDecodeServerAffiliationInfo != null ? serverAffiliationInfoDecodeServerAffiliationInfo.getTestDelayMillis() : 0L;
            if (testDelayMillis <= 0) {
                testDelayMillis = 999999;
            }
            arrayList.add(new ServerDelay(str, testDelayMillis));
        }
        if (arrayList.size() > 1) {
            Comparator comparator = new Comparator() { // from class: renz.javacodez.v2ray.viewmodel.MainViewModel$sortByTestResults$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return e.l(Long.valueOf(((MainViewModel.ServerDelay) t).getTestDelayMillis()), Long.valueOf(((MainViewModel.ServerDelay) t2).getTestDelayMillis()));
                }
            };
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, comparator);
            }
        }
        for (ServerDelay serverDelay : arrayList) {
            listDecodeServerList.remove(serverDelay.getGuid());
            listDecodeServerList.add(serverDelay.getGuid());
        }
        MmkvManager.INSTANCE.encodeServerList(listDecodeServerList);
    }

    public final void startListenBroadcast() {
        isRunning().i(Boolean.FALSE);
        IntentFilter intentFilter = new IntentFilter(AppConfig.BROADCAST_ACTION_ACTIVITY);
        if (Build.VERSION.SDK_INT >= 33) {
            ((V2RAYApp) getApplication()).registerReceiver(this.mMsgReceiver, intentFilter, Utils.INSTANCE.receiverFlags());
        } else {
            ((V2RAYApp) getApplication()).registerReceiver(this.mMsgReceiver, intentFilter);
        }
        MessageUtil.INSTANCE.sendMsg2Service(getApplication(), 1, AppConfig.CUSTOM);
    }

    public final void swapServer(int i, int i2) {
        int length = this.subscriptionId.length();
        List<String> list = this.serverList;
        if (length == 0) {
            Collections.swap(list, i, i2);
        } else {
            Collections.swap(this.serverList, list.indexOf(this.serversCache.get(i).getGuid()), this.serverList.indexOf(this.serversCache.get(i2).getGuid()));
        }
        Collections.swap(this.serversCache, i, i2);
        MmkvManager.INSTANCE.encodeServerList(this.serverList);
    }

    public final void testAllRealPing() {
        MessageUtil.INSTANCE.sendMsg2TestService(getApplication(), 72, AppConfig.CUSTOM);
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        List<ServersCache> list = this.serversCache;
        ArrayList arrayList = new ArrayList(ae.y0(list));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ServersCache) it.next()).getGuid());
        }
        mmkvManager.clearAllTestDelayResults(he.g1(arrayList));
        getUpdateListAction().i(-1);
        e.Y0(e.w(this), uo.a, new AnonymousClass2(he.g1(this.serversCache), this, null), 2);
    }

    public final void testAllTcping() {
        h70 h70Var = (h70) getTcpingTestScope().x().a(e.b$1);
        if (h70Var != null) {
            e.A0(h70Var);
        }
        SpeedtestUtil.INSTANCE.closeAllTcpSockets();
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        List<ServersCache> list = this.serversCache;
        ArrayList arrayList = new ArrayList(ae.y0(list));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ServersCache) it.next()).getGuid());
        }
        mmkvManager.clearAllTestDelayResults(he.g1(arrayList));
        for (ServersCache serversCache : he.g1(this.serversCache)) {
            ProfileItem profile = serversCache.getProfile();
            String server = profile.getServer();
            String serverPort = profile.getServerPort();
            if (server != null && serverPort != null) {
                e.Y0(getTcpingTestScope(), null, new MainViewModel$testAllTcping$2$1(server, serverPort, serversCache, this, null), 3);
            }
        }
    }

    public final void testCurrentServerRealPing() {
        MessageUtil.INSTANCE.sendMsg2Service(getApplication(), 6, AppConfig.CUSTOM);
    }
}
