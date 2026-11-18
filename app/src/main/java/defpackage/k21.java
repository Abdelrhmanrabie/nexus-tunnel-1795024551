package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.a;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class k21 extends y1 implements f.a {
    public final Context d;
    public final ActionBarContextView f;
    public final g g;
    public WeakReference i;
    public boolean j;
    public final f n;

    public k21(Context context, ActionBarContextView actionBarContextView, g gVar) {
        this.d = context;
        this.f = actionBarContextView;
        this.g = gVar;
        f fVar = new f(actionBarContextView.getContext());
        fVar.mDefaultShowAsAction = 1;
        this.n = fVar;
        fVar.mCallback = this;
    }

    @Override // defpackage.y1
    public final void a() {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g.d(this);
    }

    @Override // defpackage.y1
    public final View b() {
        WeakReference weakReference = this.i;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // defpackage.y1
    public final f c() {
        return this.n;
    }

    @Override // defpackage.y1
    public final l41 d() {
        return new l41(this.f.getContext());
    }

    @Override // defpackage.y1
    public final CharSequence e() {
        return this.f.p;
    }

    @Override // defpackage.y1
    public final CharSequence f() {
        return this.f.o;
    }

    @Override // defpackage.y1
    public final void g() {
        this.g.a(this, this.n);
    }

    @Override // defpackage.y1
    public final boolean h() {
        return this.f.y;
    }

    @Override // defpackage.y1
    public final void i(View view) {
        this.f.setCustomView(view);
        this.i = view != null ? new WeakReference(view) : null;
    }

    @Override // defpackage.y1
    public final void j(int i) {
        k(this.d.getString(i));
    }

    @Override // defpackage.y1
    public final void k(CharSequence charSequence) {
        ActionBarContextView actionBarContextView = this.f;
        actionBarContextView.p = charSequence;
        actionBarContextView.g();
    }

    @Override // defpackage.y1
    public final void l(int i) {
        m(this.d.getString(i));
    }

    @Override // defpackage.y1
    public final void m(CharSequence charSequence) {
        ActionBarContextView actionBarContextView = this.f;
        actionBarContextView.o = charSequence;
        actionBarContextView.g();
        qd1.m(charSequence, actionBarContextView);
    }

    @Override // defpackage.y1
    public final void n(boolean z) {
        this.c = z;
        ActionBarContextView actionBarContextView = this.f;
        if (z != actionBarContextView.y) {
            actionBarContextView.requestLayout();
        }
        actionBarContextView.y = z;
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final boolean onMenuItemSelected(f fVar, MenuItem menuItem) {
        return ((y1.a) this.g.a).c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final void onMenuModeChange(f fVar) {
        g();
        a aVar = this.f.f;
        if (aVar != null) {
            aVar.d();
        }
    }
}
