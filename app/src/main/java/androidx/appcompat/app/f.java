package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.a5;
import defpackage.ak;
import defpackage.e5;
import defpackage.f5;
import defpackage.jb0$a;
import defpackage.t1;
import defpackage.y1;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class f extends Dialog implements a5 {
    public f5 mDelegate;
    public final a mKeyDispatcher;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements jb0$a {
        public a() {
        }

        @Override // defpackage.jb0$a
        public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.superDispatchKeyEvent(keyEvent);
        }
    }

    public f(Context context) {
        this(context, 0);
    }

    public f(Context context, int i) {
        int i2;
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.style.j9, typedValue, true);
            i2 = typedValue.resourceId;
        } else {
            i2 = i;
        }
        super(context, i2);
        this.mKeyDispatcher = new a();
        e5 delegate = getDelegate();
        if (i == 0) {
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(R.style.j9, typedValue2, true);
            i = typedValue2.resourceId;
        }
        ((f5) delegate).U = i;
        delegate.l();
    }

    public f(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mKeyDispatcher = new a();
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        f5 f5Var = (f5) getDelegate();
        f5Var.K();
        ((ViewGroup) f5Var.B.findViewById(android.R.id.content)).addView(view, layoutParams);
        f5Var.j.b.onContentChanged();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        getDelegate().m();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return ak.b(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        f5 f5Var = (f5) getDelegate();
        f5Var.K();
        return f5Var.i.findViewById(i);
    }

    public final e5 getDelegate() {
        if (this.mDelegate == null) {
            int i = e5.b;
            this.mDelegate = new f5(getContext(), getWindow(), this, this);
        }
        return this.mDelegate;
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        getDelegate().j();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        f5 f5Var = (f5) getDelegate();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(f5Var.g);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(f5Var);
        } else {
            layoutInflaterFrom.getFactory2();
        }
        super.onCreate(bundle);
        getDelegate().l();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        f5 f5Var = (f5) getDelegate();
        f5Var.Q();
        t1 t1Var = f5Var.o;
        if (t1Var != null) {
            t1Var.q(false);
        }
    }

    @Override // defpackage.a5
    public final void onSupportActionModeFinished(y1 y1Var) {
    }

    @Override // defpackage.a5
    public final void onSupportActionModeStarted(y1 y1Var) {
    }

    @Override // defpackage.a5
    public final y1 onWindowStartingSupportActionMode(y1.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        getDelegate().u(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        f5 f5Var = (f5) getDelegate();
        f5Var.K();
        ViewGroup viewGroup = (ViewGroup) f5Var.B.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        f5Var.j.b.onContentChanged();
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        f5 f5Var = (f5) getDelegate();
        f5Var.K();
        ViewGroup viewGroup = (ViewGroup) f5Var.B.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        f5Var.j.b.onContentChanged();
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        getDelegate().A(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().A(charSequence);
    }

    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
