package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class cg1 extends t1 implements ActionBarOverlayLayout.d {
    public Context a;
    public Context b;
    public ActionBarOverlayLayout c;
    public ActionBarContainer d;
    public androidx.appcompat.widget.d e;
    public ActionBarContextView f;
    public final View g;
    public boolean h;
    public d i;
    public d j;
    public g k;
    public boolean l;
    public final ArrayList m;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public ke1 t;
    public boolean u;
    public boolean v;
    public final a w;
    public final a x;
    public final bj y;
    public static final AccelerateInterpolator z = new AccelerateInterpolator();
    public static final DecelerateInterpolator A = new DecelerateInterpolator();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends e {
        public final /* synthetic */ int G0;
        public final /* synthetic */ cg1 o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(cg1 cg1Var, int i) {
            super(4);
            this.G0 = i;
            this.o = cg1Var;
        }

        @Override // defpackage.le1
        public final void onAnimationEnd() {
            View view;
            int i = this.G0;
            cg1 cg1Var = this.o;
            if (i != 0) {
                cg1Var.t = null;
                cg1Var.d.requestLayout();
                return;
            }
            if (cg1Var.p && (view = cg1Var.g) != null) {
                view.setTranslationY(0.0f);
                cg1Var.d.setTranslationY(0.0f);
            }
            cg1Var.d.setVisibility(8);
            ActionBarContainer actionBarContainer = cg1Var.d;
            actionBarContainer.b = false;
            actionBarContainer.setDescendantFocusability(262144);
            cg1Var.t = null;
            g gVar = cg1Var.k;
            if (gVar != null) {
                gVar.d(cg1Var.j);
                cg1Var.j = null;
                cg1Var.k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = cg1Var.c;
            if (actionBarOverlayLayout != null) {
                WeakHashMap weakHashMap = qd1.a;
                actionBarOverlayLayout.requestApplyInsets();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d extends y1 implements f.a {
        public final Context d;
        public final f f;
        public g g;
        public WeakReference i;

        public d(Context context, g gVar) {
            this.d = context;
            this.g = gVar;
            f fVar = new f(context);
            fVar.mDefaultShowAsAction = 1;
            this.f = fVar;
            fVar.mCallback = this;
        }

        @Override // defpackage.y1
        public final void a() {
            cg1 cg1Var = cg1.this;
            if (cg1Var.i != this) {
                return;
            }
            if (cg1Var.q) {
                cg1Var.j = this;
                cg1Var.k = this.g;
            } else {
                this.g.d(this);
            }
            this.g = null;
            cg1Var.t(false);
            ActionBarContextView actionBarContextView = cg1Var.f;
            if (actionBarContextView.q == null) {
                actionBarContextView.h();
            }
            cg1Var.c.setHideOnContentScrollEnabled(cg1Var.v);
            cg1Var.i = null;
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
            return this.f;
        }

        @Override // defpackage.y1
        public final l41 d() {
            return new l41(this.d);
        }

        @Override // defpackage.y1
        public final CharSequence e() {
            return cg1.this.f.p;
        }

        @Override // defpackage.y1
        public final CharSequence f() {
            return cg1.this.f.o;
        }

        @Override // defpackage.y1
        public final void g() {
            if (cg1.this.i != this) {
                return;
            }
            f fVar = this.f;
            fVar.stopDispatchingItemsChanged();
            try {
                this.g.a(this, fVar);
            } finally {
                fVar.startDispatchingItemsChanged();
            }
        }

        @Override // defpackage.y1
        public final boolean h() {
            return cg1.this.f.y;
        }

        @Override // defpackage.y1
        public final void i(View view) {
            cg1.this.f.setCustomView(view);
            this.i = new WeakReference(view);
        }

        @Override // defpackage.y1
        public final void j(int i) {
            k(cg1.this.a.getResources().getString(i));
        }

        @Override // defpackage.y1
        public final void k(CharSequence charSequence) {
            ActionBarContextView actionBarContextView = cg1.this.f;
            actionBarContextView.p = charSequence;
            actionBarContextView.g();
        }

        @Override // defpackage.y1
        public final void l(int i) {
            m(cg1.this.a.getResources().getString(i));
        }

        @Override // defpackage.y1
        public final void m(CharSequence charSequence) {
            ActionBarContextView actionBarContextView = cg1.this.f;
            actionBarContextView.o = charSequence;
            actionBarContextView.g();
            qd1.m(charSequence, actionBarContextView);
        }

        @Override // defpackage.y1
        public final void n(boolean z) {
            this.c = z;
            ActionBarContextView actionBarContextView = cg1.this.f;
            if (z != actionBarContextView.y) {
                actionBarContextView.requestLayout();
            }
            actionBarContextView.y = z;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean onMenuItemSelected(f fVar, MenuItem menuItem) {
            g gVar = this.g;
            if (gVar != null) {
                return ((y1.a) gVar.a).c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void onMenuModeChange(f fVar) {
            if (this.g == null) {
                return;
            }
            g();
            androidx.appcompat.widget.a aVar = cg1.this.f.f;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    public cg1(Dialog dialog) {
        new ArrayList();
        this.m = new ArrayList();
        this.o = 0;
        this.p = true;
        this.s = true;
        this.w = new a(this, 0);
        this.x = new a(this, 1);
        this.y = new bj(4, this);
        u(dialog.getWindow().getDecorView());
    }

    public cg1(boolean z2, Activity activity) {
        new ArrayList();
        this.m = new ArrayList();
        this.o = 0;
        this.p = true;
        this.s = true;
        this.w = new a(this, 0);
        this.x = new a(this, 1);
        this.y = new bj(4, this);
        View decorView = activity.getWindow().getDecorView();
        u(decorView);
        if (z2) {
            return;
        }
        this.g = decorView.findViewById(R.id.content);
    }

    @Override // defpackage.t1
    public final boolean b() {
        Toolbar.d dVar;
        h hVar;
        androidx.appcompat.widget.d dVar2 = this.e;
        if (dVar2 == null || (dVar = dVar2.a.mExpandedMenuPresenter) == null || (hVar = dVar.c) == null) {
            return false;
        }
        hVar.collapseActionView();
        return true;
    }

    @Override // defpackage.t1
    public final void c(boolean z2) {
        if (z2 == this.l) {
            return;
        }
        this.l = z2;
        ArrayList arrayList = this.m;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        defpackage.d.AnonymousClass0.m$1();
    }

    @Override // defpackage.t1
    public final int d() {
        return this.e.b;
    }

    @Override // defpackage.t1
    public final Context e() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(org.hamotunnelplus.xyz.R.style.r, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.b = new ContextThemeWrapper(this.a, i);
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    @Override // defpackage.t1
    public final void g() {
        v(this.a.getResources().getBoolean(org.hamotunnelplus.xyz.R.bool.a));
    }

    @Override // defpackage.t1
    public final boolean i(int i, KeyEvent keyEvent) {
        f fVar;
        d dVar = this.i;
        if (dVar == null || (fVar = dVar.f) == null) {
            return false;
        }
        fVar.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return fVar.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.t1
    public final void l(boolean z2) {
        if (this.h) {
            return;
        }
        m(z2);
    }

    @Override // defpackage.t1
    public final void m(boolean z2) {
        int i = z2 ? 4 : 0;
        androidx.appcompat.widget.d dVar = this.e;
        int i2 = dVar.b;
        this.h = true;
        dVar.i((i & 4) | (i2 & (-5)));
    }

    @Override // defpackage.t1
    public final void o(int i) {
        this.e.l(i);
    }

    @Override // defpackage.t1
    public final void p(hp hpVar) {
        this.e.v(hpVar);
    }

    @Override // defpackage.t1
    public final void q(boolean z2) {
        ke1 ke1Var;
        this.u = z2;
        if (z2 || (ke1Var = this.t) == null) {
            return;
        }
        ke1Var.a();
    }

    @Override // defpackage.t1
    public final void r(CharSequence charSequence) {
        this.e.setWindowTitle(charSequence);
    }

    @Override // defpackage.t1
    public final y1 s(g gVar) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f.h();
        d dVar2 = new d(this.f.getContext(), gVar);
        f fVar = dVar2.f;
        fVar.stopDispatchingItemsChanged();
        try {
            boolean zB = ((y1.a) dVar2.g.a).b(dVar2, fVar);
            fVar.startDispatchingItemsChanged();
            if (!zB) {
                return null;
            }
            this.i = dVar2;
            dVar2.g();
            this.f.f(dVar2);
            t(true);
            return dVar2;
        } catch (Throwable th) {
            fVar.startDispatchingItemsChanged();
            throw th;
        }
    }

    public final void t(boolean z2) {
        je1 je1VarA;
        je1 je1VarE;
        boolean z3 = this.r;
        if (z2) {
            if (!z3) {
                this.r = true;
                w(false);
            }
        } else if (z3) {
            this.r = false;
            w(false);
        }
        ActionBarContainer actionBarContainer = this.d;
        WeakHashMap weakHashMap = qd1.a;
        boolean zIsLaidOut = actionBarContainer.isLaidOut();
        androidx.appcompat.widget.d dVar = this.e;
        if (!zIsLaidOut) {
            if (z2) {
                dVar.a.setVisibility(4);
                this.f.setVisibility(0);
                return;
            } else {
                dVar.a.setVisibility(0);
                this.f.setVisibility(8);
                return;
            }
        }
        if (z2) {
            je1VarE = qd1.a(dVar.a);
            je1VarE.a(0.0f);
            je1VarE.c(100L);
            je1VarE.d(dVar.new a(4));
            je1VarA = this.f.e(0, 200L);
        } else {
            je1VarA = qd1.a(dVar.a);
            je1VarA.a(1.0f);
            je1VarA.c(200L);
            je1VarA.d(dVar.new a(0));
            je1VarE = this.f.e(8, 100L);
        }
        ke1 ke1Var = new ke1();
        ArrayList arrayList = ke1Var.a;
        arrayList.add(je1VarE);
        View view = (View) je1VarE.a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) je1VarA.a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(je1VarA);
        ke1Var.b();
    }

    public final void u(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(org.hamotunnelplus.xyz.R.attr.ht);
        this.c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.A = this;
            if (actionBarOverlayLayout.getWindowToken() != null) {
                actionBarOverlayLayout.A.o = actionBarOverlayLayout.c;
                int i = actionBarOverlayLayout.s;
                if (i != 0) {
                    actionBarOverlayLayout.onWindowSystemUiVisibilityChanged(i);
                    WeakHashMap weakHashMap = qd1.a;
                    actionBarOverlayLayout.requestApplyInsets();
                }
            }
        }
        View viewFindViewById = view.findViewById(org.hamotunnelplus.xyz.R.attr.be);
        if (!(viewFindViewById instanceof Toolbar)) {
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(viewFindViewById != null ? viewFindViewById.getClass().getSimpleName() : "null"));
        }
        Toolbar toolbar = (Toolbar) viewFindViewById;
        if (toolbar.mWrapper == null) {
            toolbar.mWrapper = new androidx.appcompat.widget.d(toolbar, true);
        }
        this.e = toolbar.mWrapper;
        this.f = (ActionBarContextView) view.findViewById(org.hamotunnelplus.xyz.R.attr.bm);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(org.hamotunnelplus.xyz.R.attr.bg);
        this.d = actionBarContainer;
        androidx.appcompat.widget.d dVar = this.e;
        if (dVar == null || this.f == null || actionBarContainer == null) {
            throw new IllegalStateException("cg1".concat(" can only be used with a compatible window decor layout"));
        }
        Context context = dVar.a.getContext();
        this.a = context;
        if ((this.e.b & 4) != 0) {
            this.h = true;
        }
        int i2 = context.getApplicationInfo().targetSdkVersion;
        this.e.getClass();
        v(context.getResources().getBoolean(org.hamotunnelplus.xyz.R.bool.a));
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(null, b2.f17a, org.hamotunnelplus.xyz.R.style.m, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
            if (!actionBarOverlayLayout2.n) {
                defpackage.d.AnonymousClass0.m("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                return;
            } else {
                this.v = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            }
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.d;
            WeakHashMap weakHashMap2 = qd1.a;
            actionBarContainer2.setElevation(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void v(boolean z2) {
        Object obj;
        if (z2) {
            this.d.getClass();
            obj = this.e;
        } else {
            this.e.getClass();
            obj = this.d;
        }
        obj.getClass();
        this.e.getClass();
        Toolbar toolbar = this.e.a;
        toolbar.getClass();
        toolbar.requestLayout();
        this.c.getClass();
    }

    public final void w(boolean z2) {
        boolean z3 = this.r || !this.q;
        boolean z4 = this.s;
        View view = this.g;
        bj bjVar = this.y;
        if (!z3) {
            if (z4) {
                this.s = false;
                ke1 ke1Var = this.t;
                if (ke1Var != null) {
                    ke1Var.a();
                }
                int i = this.o;
                a aVar = this.w;
                if (i != 0 || (!this.u && !z2)) {
                    aVar.onAnimationEnd();
                    return;
                }
                this.d.setAlpha(1.0f);
                ActionBarContainer actionBarContainer = this.d;
                actionBarContainer.b = true;
                actionBarContainer.setDescendantFocusability(393216);
                ke1 ke1Var2 = new ke1();
                float f = -this.d.getHeight();
                if (z2) {
                    int[] iArr = {0, 0};
                    this.d.getLocationInWindow(iArr);
                    f -= iArr[1];
                }
                je1 je1VarA = qd1.a(this.d);
                je1VarA.e(f);
                View view2 = (View) je1VarA.a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(bjVar != null ? new rc(2, bjVar) : null);
                }
                boolean z5 = ke1Var2.e;
                ArrayList arrayList = ke1Var2.a;
                if (!z5) {
                    arrayList.add(je1VarA);
                }
                if (this.p && view != null) {
                    je1 je1VarA2 = qd1.a(view);
                    je1VarA2.e(f);
                    if (!ke1Var2.e) {
                        arrayList.add(je1VarA2);
                    }
                }
                boolean z6 = ke1Var2.e;
                if (!z6) {
                    ke1Var2.c = z;
                }
                if (!z6) {
                    ke1Var2.b = 250L;
                }
                if (!z6) {
                    ke1Var2.d = aVar;
                }
                this.t = ke1Var2;
                ke1Var2.b();
                return;
            }
            return;
        }
        if (z4) {
            return;
        }
        this.s = true;
        ke1 ke1Var3 = this.t;
        if (ke1Var3 != null) {
            ke1Var3.a();
        }
        this.d.setVisibility(0);
        int i2 = this.o;
        a aVar2 = this.x;
        if (i2 == 0 && (this.u || z2)) {
            this.d.setTranslationY(0.0f);
            float f2 = -this.d.getHeight();
            if (z2) {
                int[] iArr2 = {0, 0};
                this.d.getLocationInWindow(iArr2);
                f2 -= iArr2[1];
            }
            this.d.setTranslationY(f2);
            ke1 ke1Var4 = new ke1();
            je1 je1VarA3 = qd1.a(this.d);
            je1VarA3.e(0.0f);
            View view3 = (View) je1VarA3.a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(bjVar != null ? new rc(2, bjVar) : null);
            }
            boolean z7 = ke1Var4.e;
            ArrayList arrayList2 = ke1Var4.a;
            if (!z7) {
                arrayList2.add(je1VarA3);
            }
            if (this.p && view != null) {
                view.setTranslationY(f2);
                je1 je1VarA4 = qd1.a(view);
                je1VarA4.e(0.0f);
                if (!ke1Var4.e) {
                    arrayList2.add(je1VarA4);
                }
            }
            boolean z8 = ke1Var4.e;
            if (!z8) {
                ke1Var4.c = A;
            }
            if (!z8) {
                ke1Var4.b = 250L;
            }
            if (!z8) {
                ke1Var4.d = aVar2;
            }
            this.t = ke1Var4;
            ke1Var4.b();
        } else {
            this.d.setAlpha(1.0f);
            this.d.setTranslationY(0.0f);
            if (this.p && view != null) {
                view.setTranslationY(0.0f);
            }
            aVar2.onAnimationEnd();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = qd1.a;
            actionBarOverlayLayout.requestApplyInsets();
        }
    }
}
