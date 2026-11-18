package defpackage;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.a;
import androidx.appcompat.widget.d;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class f71 extends t1 {
    public final d a;
    public final f5.f b;
    public final b c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final ArrayList g = new ArrayList();
    public final as0 h = new as0(3, this);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b implements Toolbar.f, f.a {
        public /* synthetic */ b() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public boolean onMenuItemSelected(f fVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public void onMenuModeChange(f fVar) {
            f71 f71Var = f71.this;
            boolean zIsOverflowMenuShowing = f71Var.a.a.isOverflowMenuShowing();
            f5.f fVar2 = f71Var.b;
            if (zIsOverflowMenuShowing) {
                fVar2.onPanelClosed(108, fVar);
            } else if (fVar2.onPreparePanel(0, null, fVar)) {
                fVar2.onMenuOpened(108, fVar);
            }
        }
    }

    public f71(Toolbar toolbar, CharSequence charSequence, f5.f fVar) {
        b bVar = new b();
        d dVar = new d(toolbar, false);
        this.a = dVar;
        fVar.getClass();
        this.b = fVar;
        dVar.l = fVar;
        toolbar.mOnMenuItemClickListener = bVar;
        dVar.setWindowTitle(charSequence);
        this.c = new b();
    }

    @Override // defpackage.t1
    public final boolean a() {
        a aVar;
        ActionMenuView actionMenuView = this.a.a.mMenuView;
        return (actionMenuView == null || (aVar = actionMenuView.g) == null || !aVar.b()) ? false : true;
    }

    @Override // defpackage.t1
    public final boolean b() {
        h hVar;
        Toolbar.d dVar = this.a.a.mExpandedMenuPresenter;
        if (dVar == null || (hVar = dVar.c) == null) {
            return false;
        }
        hVar.collapseActionView();
        return true;
    }

    @Override // defpackage.t1
    public final void c(boolean z) {
        if (z == this.f) {
            return;
        }
        this.f = z;
        ArrayList arrayList = this.g;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        d.AnonymousClass0.m$1();
    }

    @Override // defpackage.t1
    public final int d() {
        return this.a.b;
    }

    @Override // defpackage.t1
    public final Context e() {
        return this.a.a.getContext();
    }

    @Override // defpackage.t1
    public final boolean f() {
        d dVar = this.a;
        Toolbar toolbar = dVar.a;
        as0 as0Var = this.h;
        toolbar.removeCallbacks(as0Var);
        Toolbar toolbar2 = dVar.a;
        WeakHashMap weakHashMap = qd1.a;
        toolbar2.postOnAnimation(as0Var);
        return true;
    }

    @Override // defpackage.t1
    public final void g() {
    }

    @Override // defpackage.t1
    public final void h() {
        this.a.a.removeCallbacks(this.h);
    }

    @Override // defpackage.t1
    public final boolean i(int i, KeyEvent keyEvent) {
        f fVarT = t();
        if (fVarT == null) {
            return false;
        }
        fVarT.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return fVarT.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.t1
    public final boolean j(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            k();
        }
        return true;
    }

    @Override // defpackage.t1
    public final boolean k() {
        return this.a.a.showOverflowMenu();
    }

    @Override // defpackage.t1
    public final void l(boolean z) {
    }

    @Override // defpackage.t1
    public final void m(boolean z) {
        d dVar = this.a;
        dVar.i((dVar.b & (-5)) | 4);
    }

    @Override // defpackage.t1
    public final void o(int i) {
        this.a.l(i);
    }

    @Override // defpackage.t1
    public final void p(hp hpVar) {
        this.a.v(hpVar);
    }

    @Override // defpackage.t1
    public final void q(boolean z) {
    }

    @Override // defpackage.t1
    public final void r(CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    public final f t() {
        boolean z = this.e;
        d dVar = this.a;
        if (!z) {
            c5 c5Var = new c5(3, this);
            b bVar = new b();
            Toolbar toolbar = dVar.a;
            toolbar.mActionMenuPresenterCallback = c5Var;
            toolbar.mMenuBuilderCallback = bVar;
            ActionMenuView actionMenuView = toolbar.mMenuView;
            if (actionMenuView != null) {
                actionMenuView.i = c5Var;
                actionMenuView.j = bVar;
            }
            this.e = true;
        }
        return dVar.a.getMenu();
    }
}
