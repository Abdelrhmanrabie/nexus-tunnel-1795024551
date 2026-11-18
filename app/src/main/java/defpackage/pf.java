package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.e;
import androidx.lifecycle.i;
import androidx.savedstate.a;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class pf extends Dialog implements he0, vm0, tx0 {
    public i b;
    public final sx0 c;
    public final OnBackPressedDispatcher d;

    public pf(Context context, int i) {
        super(context, i);
        this.c = new sx0(this);
        this.d = new OnBackPressedDispatcher(new jf(this, 0, 2));
    }

    public static void a(pf pfVar) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        super.addContentView(view, layoutParams);
    }

    public final void b() {
        getWindow().getDecorView().setTag(R.attr.a37, this);
        getWindow().getDecorView().setTag(R.attr.a38, this);
        getWindow().getDecorView().setTag(R.attr.a39, this);
    }

    @Override // defpackage.he0
    public final e getLifecycle() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this);
        this.b = iVar2;
        return iVar2;
    }

    @Override // defpackage.vm0
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.d;
    }

    @Override // defpackage.tx0
    public final a getSavedStateRegistry() {
        return this.c.b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.d.c();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            OnBackPressedDispatcher onBackPressedDispatcher = this.d;
            onBackPressedDispatcher.f = onBackInvokedDispatcher;
            onBackPressedDispatcher.d(onBackPressedDispatcher.h);
        }
        this.c.b(bundle);
        i iVar = this.b;
        if (iVar == null) {
            iVar = new i(this);
            this.b = iVar;
        }
        iVar.f(e.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        this.c.c(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        i iVar = this.b;
        if (iVar == null) {
            iVar = new i(this);
            this.b = iVar;
        }
        iVar.f(e.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        i iVar = this.b;
        if (iVar == null) {
            iVar = new i(this);
            this.b = iVar;
        }
        iVar.f(e.a.ON_DESTROY);
        this.b = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public final void setContentView(int i) {
        b();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view) {
        b();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        super.setContentView(view, layoutParams);
    }
}
