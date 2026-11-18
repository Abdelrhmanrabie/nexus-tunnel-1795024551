package renz.javacodez.v2ray.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import defpackage.ai;
import defpackage.bx;
import defpackage.d;
import defpackage.ds;
import defpackage.e;
import defpackage.e4;
import defpackage.h70;
import defpackage.jo0;
import defpackage.rc0;
import defpackage.t41;
import defpackage.tb1;
import defpackage.ti;
import defpackage.uh0;
import defpackage.ui;
import defpackage.v41;
import defpackage.vi;
import go.Seq;
import java.util.concurrent.Executors;
import libv2ray.Libv2ray;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.dto.ConfigResult;
import renz.javacodez.v2ray.dto.EConfigType;
import renz.javacodez.v2ray.dto.ProfileItem;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.handler.V2rayConfigManager;
import renz.javacodez.v2ray.util.MessageUtil;
import renz.javacodez.v2ray.util.PluginUtil;
import renz.javacodez.v2ray.util.SpeedtestUtil;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class V2RayTestService extends Service {
    private final rc0 realTestScope$delegate = new v41(new uh0(2, 1));

    /* JADX INFO: renamed from: renz.javacodez.v2ray.service.V2RayTestService$onStartCommand$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class AnonymousClass1 extends t41 implements bx {
        final /* synthetic */ String $guid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, ai aiVar) {
            super(aiVar);
            this.$guid = str;
        }

        @Override // defpackage.i8
        public final ai create(Object obj, ai aiVar) {
            return V2RayTestService.this.new AnonymousClass1(this.$guid, aiVar);
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
            MessageUtil.INSTANCE.sendMsg2UI(V2RayTestService.this, 71, new jo0(this.$guid, new Long(V2RayTestService.this.startRealPing(this.$guid))));
            return tb1.a;
        }
    }

    private final ti getRealTestScope() {
        return (ti) this.realTestScope$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ti realTestScope_delegate$lambda$0() {
        return ui.a(new ds(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long startRealPing(String str) {
        ProfileItem profileItemDecodeServerConfig = MmkvManager.INSTANCE.decodeServerConfig(this, str);
        if (profileItemDecodeServerConfig == null) {
            return -1L;
        }
        if (profileItemDecodeServerConfig.getConfigType() == EConfigType.HYSTERIA2) {
            return PluginUtil.INSTANCE.realPingHy2(this, profileItemDecodeServerConfig);
        }
        ConfigResult v2rayConfig = V2rayConfigManager.INSTANCE.getV2rayConfig(this, str);
        if (v2rayConfig.getStatus()) {
            return SpeedtestUtil.INSTANCE.realPing(v2rayConfig.getContent());
        }
        return -1L;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Seq.setContext((Context) this);
        Utils utils = Utils.INSTANCE;
        Libv2ray.initV2Env(utils.userAssetPath(this), utils.getDeviceIdForXUDPBaseKey());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        h70 h70Var;
        Object serializableExtra;
        Integer numValueOf = intent != null ? Integer.valueOf(intent.getIntExtra("key", 0)) : null;
        if (numValueOf != null && numValueOf.intValue() == 7) {
            if (Build.VERSION.SDK_INT >= 33) {
                serializableExtra = intent.getSerializableExtra("content", String.class);
            } else {
                Object serializableExtra2 = intent.getSerializableExtra("content");
                if (!(serializableExtra2 instanceof String)) {
                    serializableExtra2 = null;
                }
                serializableExtra = (String) serializableExtra2;
            }
            String str = (String) serializableExtra;
            if (str == null) {
                str = AppConfig.CUSTOM;
            }
            e.Y0(getRealTestScope(), null, new AnonymousClass1(str, null), 3);
        } else if (numValueOf != null && numValueOf.intValue() == 72 && (h70Var = (h70) getRealTestScope().x().a(e.b$1)) != null) {
            e.A0(h70Var);
        }
        return super.onStartCommand(intent, i, i2);
    }
}
