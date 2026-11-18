package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import defpackage.cb;
import defpackage.e4;
import defpackage.he0;
import defpackage.lw;
import defpackage.mm0;
import defpackage.nm0;
import defpackage.pm0;
import defpackage.tb1;
import defpackage.tm0;
import defpackage.um0;
import defpackage.vx;
import defpackage.z6;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    public final Runnable a;
    public final z6 c;
    public mm0 d;
    public final OnBackInvokedCallback e;
    public OnBackInvokedDispatcher f;
    public boolean g;
    public boolean h;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class LifecycleOnBackPressedCancellable implements h, cb {
        public final e b;
        public final mm0 c;
        public b d;

        public LifecycleOnBackPressedCancellable(e eVar, mm0 mm0Var) {
            this.b = eVar;
            this.c = mm0Var;
            eVar.a(this);
        }

        @Override // androidx.lifecycle.h
        public final void a(he0 he0Var, e.a aVar) {
            if (aVar != e.a.ON_START) {
                if (aVar != e.a.ON_STOP) {
                    if (aVar == e.a.ON_DESTROY) {
                        cancel();
                        return;
                    }
                    return;
                } else {
                    b bVar = this.d;
                    if (bVar != null) {
                        bVar.cancel();
                        return;
                    }
                    return;
                }
            }
            OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
            onBackPressedDispatcher.getClass();
            z6 z6Var = onBackPressedDispatcher.c;
            mm0 mm0Var = this.c;
            z6Var.addLast(mm0Var);
            b bVar2 = onBackPressedDispatcher.new b(mm0Var);
            mm0Var.b.add(bVar2);
            onBackPressedDispatcher.e();
            mm0Var.c = new um0(onBackPressedDispatcher);
            this.d = bVar2;
        }

        @Override // defpackage.cb
        public final void cancel() {
            this.b.c(this);
            mm0 mm0Var = this.c;
            mm0Var.getClass();
            mm0Var.b.remove(this);
            b bVar = this.d;
            if (bVar != null) {
                bVar.cancel();
            }
            this.d = null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class a {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements cb {
        public final mm0 b;

        public b(mm0 mm0Var) {
            this.b = mm0Var;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [lw, vx] */
        @Override // defpackage.cb
        public final void cancel() {
            OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
            z6 z6Var = onBackPressedDispatcher.c;
            mm0 mm0Var = this.b;
            z6Var.remove(mm0Var);
            if (e4.a(onBackPressedDispatcher.d, mm0Var)) {
                mm0Var.getClass();
                onBackPressedDispatcher.d = null;
            }
            mm0Var.getClass();
            mm0Var.b.remove(this);
            ?? r0 = mm0Var.c;
            if (r0 != 0) {
                r0.invoke();
            }
            mm0Var.c = null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final /* synthetic */ class c extends vx implements lw {
        public c(OnBackPressedDispatcher onBackPressedDispatcher) {
            super(onBackPressedDispatcher);
        }

        @Override // defpackage.lw
        public final Object invoke() {
            ((OnBackPressedDispatcher) this.receiver).e();
            return tb1.a;
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        OnBackInvokedCallback tm0Var;
        this.a = runnable;
        this.c = new z6();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                int i2 = 0;
                int i3 = 1;
                tm0Var = new tm0(new nm0(this, i2), new nm0(this, i3), new pm0(this, i2), new pm0(this, i3));
            } else {
                final pm0 pm0Var = new pm0(this, 2);
                tm0Var = new OnBackInvokedCallback() { // from class: sm0
                    @Override // android.window.OnBackInvokedCallback
                    public final void onBackInvoked() {
                        pm0Var.invoke();
                    }
                };
            }
            this.e = tm0Var;
        }
    }

    public final void a(he0 he0Var, mm0 mm0Var) {
        e lifecycle = he0Var.getLifecycle();
        if (lifecycle.b() == e.b.DESTROYED) {
            return;
        }
        mm0Var.b.add(new LifecycleOnBackPressedCancellable(lifecycle, mm0Var));
        e();
        mm0Var.c = new c(this);
    }

    public final void b() {
        Object objPrevious;
        if (this.d == null) {
            z6 z6Var = this.c;
            ListIterator listIterator = z6Var.listIterator(z6Var.d);
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!((mm0) objPrevious).a);
        }
        this.d = null;
    }

    public final void c() {
        Object objPrevious;
        mm0 mm0Var = this.d;
        if (mm0Var == null) {
            z6 z6Var = this.c;
            ListIterator listIterator = z6Var.listIterator(z6Var.d);
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!((mm0) objPrevious).a);
            mm0Var = (mm0) objPrevious;
        }
        this.d = null;
        if (mm0Var != null) {
            mm0Var.a();
            return;
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void d(boolean z) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f;
        if (onBackInvokedDispatcher == null || (onBackInvokedCallback = this.e) == null) {
            return;
        }
        boolean z2 = false;
        if (z && !this.g) {
            onBackInvokedDispatcher.registerOnBackInvokedCallback(0, onBackInvokedCallback);
            z2 = true;
        } else if (z || !this.g) {
            return;
        } else {
            onBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback);
        }
        this.g = z2;
    }

    public final void e() {
        boolean z;
        boolean z2 = this.h;
        z6 z6Var = this.c;
        if (z6Var != null && z6Var.isEmpty()) {
            z = false;
            break;
        }
        Iterator it = z6Var.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (((mm0) it.next()).a) {
                z = true;
                break;
            }
        }
        this.h = z;
        if (z == z2 || Build.VERSION.SDK_INT < 33) {
            return;
        }
        d(z);
    }
}
