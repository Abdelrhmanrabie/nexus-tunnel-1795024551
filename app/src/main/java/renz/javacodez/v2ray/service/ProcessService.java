package renz.javacodez.v2ray.service;

import android.content.Context;
import defpackage.ai;
import defpackage.bx;
import defpackage.d;
import defpackage.e;
import defpackage.e4;
import defpackage.t41;
import defpackage.tb1;
import defpackage.ti;
import defpackage.ui;
import defpackage.uo;
import defpackage.vi;
import java.util.List;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessService {
    private Process process;

    /* JADX INFO: renamed from: renz.javacodez.v2ray.service.ProcessService$runProcess$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class AnonymousClass1 extends t41 implements bx {
        int label;

        public AnonymousClass1(ai aiVar) {
            super(aiVar);
        }

        @Override // defpackage.i8
        public final ai create(Object obj, ai aiVar) {
            return ProcessService.this.new AnonymousClass1(aiVar);
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
            Thread.sleep(50L);
            Process process = ProcessService.this.process;
            if (process != null) {
                new Integer(process.waitFor());
            }
            return tb1.a;
        }
    }

    public final void runProcess(Context context, List<String> list) {
        list.toString();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(list);
            processBuilder.redirectErrorStream(true);
            this.process = processBuilder.directory(context.getFilesDir()).start();
            e.Y0(ui.a(uo.b), null, new AnonymousClass1(null), 3);
            String.valueOf(this.process);
        } catch (Exception e) {
            e.toString();
        }
    }

    public final void stopProcess() {
        try {
            Process process = this.process;
            if (process != null) {
                process.destroy();
            }
        } catch (Exception e) {
            e.toString();
        }
    }
}
