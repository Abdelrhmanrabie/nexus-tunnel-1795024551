package renz.javacodez.v2ray.ui;

import defpackage.ai;
import defpackage.bx;
import defpackage.d;
import defpackage.e4;
import defpackage.t41;
import defpackage.tb1;
import defpackage.ti;
import defpackage.vi;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatActivity$logcat$1$process$1 extends t41 implements bx {
    final /* synthetic */ LinkedHashSet<String> $lst;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogcatActivity$logcat$1$process$1(LinkedHashSet<String> linkedHashSet, ai aiVar) {
        super(aiVar);
        this.$lst = linkedHashSet;
    }

    @Override // defpackage.i8
    public final ai create(Object obj, ai aiVar) {
        return new LogcatActivity$logcat$1$process$1(this.$lst, aiVar);
    }

    @Override // defpackage.bx
    public final Object invoke(ti tiVar, ai aiVar) {
        return ((LogcatActivity$logcat$1$process$1) create(tiVar, aiVar)).invokeSuspend(tb1.a);
    }

    @Override // defpackage.i8
    public final Object invokeSuspend(Object obj) throws Throwable {
        vi viVar = vi.b;
        if (this.label == 0) {
            e4.b(obj);
            return Runtime.getRuntime().exec((String[]) this.$lst.toArray(new String[0]));
        }
        d.AnonymousClass0.m("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
