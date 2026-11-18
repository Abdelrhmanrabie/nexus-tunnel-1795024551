package renz.javacodez.v2ray.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.e;
import androidx.lifecycle.f;
import defpackage.ai;
import defpackage.ak;
import defpackage.bx;
import defpackage.d;
import defpackage.e4;
import defpackage.hl;
import defpackage.i41;
import defpackage.k7;
import defpackage.rc0;
import defpackage.t41;
import defpackage.tb1;
import defpackage.ti;
import defpackage.uo;
import defpackage.v41;
import defpackage.vi;
import defpackage.yf0;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import renz.javacodez.v2ray.R;
import renz.javacodez.v2ray.databinding.ActivityLogcatBinding;
import renz.javacodez.v2ray.extension._ExtKt;
import renz.javacodez.v2ray.util.Utils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatActivity extends BaseActivity {
    private final rc0 binding$delegate = new v41(new k7(this, 5, 2));

    /* JADX INFO: renamed from: renz.javacodez.v2ray.ui.LogcatActivity$logcat$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class AnonymousClass1 extends t41 implements bx {
        final /* synthetic */ boolean $shouldFlushLog;
        Object L$0;
        int label;
        final /* synthetic */ LogcatActivity this$0;

        /* JADX INFO: renamed from: renz.javacodez.v2ray.ui.LogcatActivity$logcat$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class C00431 extends t41 implements bx {
            final /* synthetic */ LinkedHashSet<String> $lst;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00431(LinkedHashSet<String> linkedHashSet, ai aiVar) {
                super(aiVar);
                this.$lst = linkedHashSet;
            }

            @Override // defpackage.i8
            public final ai create(Object obj, ai aiVar) {
                return new C00431(this.$lst, aiVar);
            }

            @Override // defpackage.bx
            public final Object invoke(ti tiVar, ai aiVar) {
                return ((C00431) create(tiVar, aiVar)).invokeSuspend(tb1.a);
            }

            @Override // defpackage.i8
            public final Object invokeSuspend(Object obj) throws Throwable {
                vi viVar = vi.b;
                if (this.label == 0) {
                    e4.b(obj);
                    return new Integer(Runtime.getRuntime().exec((String[]) this.$lst.toArray(new String[0])).waitFor());
                }
                d.AnonymousClass0.m("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
        }

        /* JADX INFO: renamed from: renz.javacodez.v2ray.ui.LogcatActivity$logcat$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class AnonymousClass2 extends t41 implements bx {
            final /* synthetic */ String $allText;
            int label;
            final /* synthetic */ LogcatActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(LogcatActivity logcatActivity, String str, ai aiVar) {
                super(aiVar);
                this.this$0 = logcatActivity;
                this.$allText = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspend$lambda$0(LogcatActivity logcatActivity) {
                logcatActivity.getBinding().svLogcat.fullScroll(130);
            }

            @Override // defpackage.i8
            public final ai create(Object obj, ai aiVar) {
                return new AnonymousClass2(this.this$0, this.$allText, aiVar);
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
                this.this$0.getBinding().tvLogcat.setText(this.this$0.hideIPsAndDomains(this.$allText));
                this.this$0.getBinding().tvLogcat.setMovementMethod(new ScrollingMovementMethod());
                this.this$0.getBinding().pbWaiting.setVisibility(8);
                Handler handler = new Handler(Looper.getMainLooper());
                final LogcatActivity logcatActivity = this.this$0;
                return Boolean.valueOf(handler.post(new Runnable() { // from class: renz.javacodez.v2ray.ui.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        LogcatActivity.AnonymousClass1.AnonymousClass2.invokeSuspend$lambda$0(logcatActivity);
                    }
                }));
            }
        }

        /* JADX INFO: renamed from: renz.javacodez.v2ray.ui.LogcatActivity$logcat$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static final class AnonymousClass3 extends t41 implements bx {
            int label;
            final /* synthetic */ LogcatActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(LogcatActivity logcatActivity, ai aiVar) {
                super(aiVar);
                this.this$0 = logcatActivity;
            }

            @Override // defpackage.i8
            public final ai create(Object obj, ai aiVar) {
                return new AnonymousClass3(this.this$0, aiVar);
            }

            @Override // defpackage.bx
            public final Object invoke(ti tiVar, ai aiVar) {
                return ((AnonymousClass3) create(tiVar, aiVar)).invokeSuspend(tb1.a);
            }

            @Override // defpackage.i8
            public final Object invokeSuspend(Object obj) throws Throwable {
                vi viVar = vi.b;
                if (this.label != 0) {
                    d.AnonymousClass0.m("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                e4.b(obj);
                this.this$0.getBinding().pbWaiting.setVisibility(8);
                _ExtKt.toast(this.this$0, R.string.toast_failure);
                return tb1.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, LogcatActivity logcatActivity, ai aiVar) {
            super(aiVar);
            this.$shouldFlushLog = z;
            this.this$0 = logcatActivity;
        }

        @Override // defpackage.i8
        public final ai create(Object obj, ai aiVar) {
            return new AnonymousClass1(this.$shouldFlushLog, this.this$0, aiVar);
        }

        @Override // defpackage.bx
        public final Object invoke(ti tiVar, ai aiVar) {
            return ((AnonymousClass1) create(tiVar, aiVar)).invokeSuspend(tb1.a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a6, code lost:
        
            if (defpackage.e.u1(r13, r14, r4) == r1) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00c4, code lost:
        
            if (defpackage.e.u1(r13, r14, r3) == r1) goto L39;
         */
        @Override // defpackage.i8
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: renz.javacodez.v2ray.ui.LogcatActivity.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivityLogcatBinding binding_delegate$lambda$0(LogcatActivity logcatActivity) {
        return ActivityLogcatBinding.inflate(logcatActivity.getLayoutInflater());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityLogcatBinding getBinding() {
        return (ActivityLogcatBinding) this.binding$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String hideIPsAndDomains(String str) {
        return replaceWithHidden(replaceWithHidden(str, "(\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b)"), "(\\b[A-Za-z0-9-]+(?:\\.[A-Za-z]{2,})+\\b)");
    }

    private final void logcat(boolean z) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        getBinding().pbWaiting.setVisibility(0);
        e lifecycle = getLifecycle();
        loop0: while (true) {
            AtomicReference atomicReference = lifecycle.a;
            lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) atomicReference.get();
            if (lifecycleCoroutineScopeImpl != null) {
                break;
            }
            i41 i41Var = new i41();
            hl hlVar = uo.a;
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, ak.a(i41Var, yf0.a.i));
            do {
                if (atomicReference.compareAndSet(null, lifecycleCoroutineScopeImpl)) {
                    hl hlVar2 = uo.a;
                    defpackage.e.Y0(lifecycleCoroutineScopeImpl, yf0.a.i, new f(lifecycleCoroutineScopeImpl, null), 2);
                    break loop0;
                }
            } while (atomicReference.get() == null);
        }
        defpackage.e.Y0(lifecycleCoroutineScopeImpl, uo.a, new AnonymousClass1(z, this, null), 2);
    }

    private final String replaceWithHidden(String str, String str2) {
        Matcher matcher = Pattern.compile(str2).matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, hide(matcher.group()));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public final String hide(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    @Override // renz.javacodez.v2ray.ui.BaseActivity, androidx.fragment.app.n, androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getBinding().getRoot());
        setTitle(getString(R.string.title_logcat));
        logcat(false);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logcat, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // renz.javacodez.v2ray.ui.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.copy_all) {
            Utils.INSTANCE.setClipboard(this, getBinding().tvLogcat.getText().toString());
            _ExtKt.toast(this, R.string.toast_success);
            return true;
        }
        if (itemId != R.id.clear_all) {
            return super.onOptionsItemSelected(menuItem);
        }
        logcat(true);
        return true;
    }
}
