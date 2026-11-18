package renz.javacodez.v2ray.viewmodel;

import defpackage.ai;
import defpackage.bx;
import defpackage.d;
import defpackage.e;
import defpackage.e4;
import defpackage.hl;
import defpackage.t41;
import defpackage.tb1;
import defpackage.ti;
import defpackage.uo;
import defpackage.vi;
import defpackage.yf0;
import renz.javacodez.v2ray.dto.ServersCache;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.util.SpeedtestUtil;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class MainViewModel$testAllTcping$2$1 extends t41 implements bx {
    final /* synthetic */ ServersCache $item;
    final /* synthetic */ String $serverAddress;
    final /* synthetic */ String $serverPort;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainViewModel this$0;

    /* JADX INFO: renamed from: renz.javacodez.v2ray.viewmodel.MainViewModel$testAllTcping$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class AnonymousClass1 extends t41 implements bx {
        final /* synthetic */ ServersCache $item;
        final /* synthetic */ long $testResult;
        int label;
        final /* synthetic */ MainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ServersCache serversCache, long j, MainViewModel mainViewModel, ai aiVar) {
            super(aiVar);
            this.$item = serversCache;
            this.$testResult = j;
            this.this$0 = mainViewModel;
        }

        @Override // defpackage.i8
        public final ai create(Object obj, ai aiVar) {
            return new AnonymousClass1(this.$item, this.$testResult, this.this$0, aiVar);
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
            MmkvManager.INSTANCE.encodeServerTestDelayMillis(this.$item.getGuid(), this.$testResult);
            this.this$0.getUpdateListAction().i(new Integer(this.this$0.getPosition(this.$item.getGuid())));
            return tb1.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainViewModel$testAllTcping$2$1(String str, String str2, ServersCache serversCache, MainViewModel mainViewModel, ai aiVar) {
        super(aiVar);
        this.$serverAddress = str;
        this.$serverPort = str2;
        this.$item = serversCache;
        this.this$0 = mainViewModel;
    }

    @Override // defpackage.i8
    public final ai create(Object obj, ai aiVar) {
        MainViewModel$testAllTcping$2$1 mainViewModel$testAllTcping$2$1 = new MainViewModel$testAllTcping$2$1(this.$serverAddress, this.$serverPort, this.$item, this.this$0, aiVar);
        mainViewModel$testAllTcping$2$1.L$0 = obj;
        return mainViewModel$testAllTcping$2$1;
    }

    @Override // defpackage.bx
    public final Object invoke(ti tiVar, ai aiVar) {
        return ((MainViewModel$testAllTcping$2$1) create(tiVar, aiVar)).invokeSuspend(tb1.a);
    }

    @Override // defpackage.i8
    public final Object invokeSuspend(Object obj) throws Throwable {
        ti tiVar;
        vi viVar = vi.b;
        int i = this.label;
        if (i == 0) {
            e4.b(obj);
            ti tiVar2 = (ti) this.L$0;
            SpeedtestUtil speedtestUtil = SpeedtestUtil.INSTANCE;
            String str = this.$serverAddress;
            int i2 = Integer.parseInt(this.$serverPort);
            this.L$0 = tiVar2;
            this.label = 1;
            Object objTcping = speedtestUtil.tcping(str, i2, this);
            if (objTcping == viVar) {
                return viVar;
            }
            tiVar = tiVar2;
            obj = objTcping;
        } else {
            if (i != 1) {
                d.AnonymousClass0.m("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            tiVar = (ti) this.L$0;
            e4.b(obj);
        }
        long jLongValue = ((Number) obj).longValue();
        hl hlVar = uo.a;
        e.Y0(tiVar, yf0.a, new AnonymousClass1(this.$item, jLongValue, this.this$0, null), 2);
        return tb1.a;
    }
}
