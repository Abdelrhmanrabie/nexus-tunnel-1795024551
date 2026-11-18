package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import defpackage.ih0;
import defpackage.jh0;
import defpackage.jp;
import defpackage.qd1;
import defpackage.v5;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class l extends ih0 implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public boolean A;
    public final Context c;
    public final f d;
    public final e f;
    public final boolean g;
    public final int i;
    public final int j;
    public final int n;
    public final jh0 o;
    public PopupWindow.OnDismissListener r;
    public View s;
    public View t;
    public j.a u;
    public ViewTreeObserver v;
    public boolean w;
    public boolean x;
    public int y;
    public final a p = new a();
    public final b q = new b();
    public int z = 0;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            l lVar = l.this;
            boolean zA = lVar.a();
            jh0 jh0Var = lVar.o;
            if (!zA || jh0Var.D) {
                return;
            }
            View view = lVar.t;
            if (view == null || !view.isShown()) {
                lVar.dismiss();
            } else {
                jh0Var.show();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            l lVar = l.this;
            ViewTreeObserver viewTreeObserver = lVar.v;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    lVar.v = view.getViewTreeObserver();
                }
                lVar.v.removeGlobalOnLayoutListener(lVar.p);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(int i, int i2, Context context, View view, f fVar, boolean z) {
        this.c = context;
        this.d = fVar;
        this.g = z;
        this.f = new e(fVar, LayoutInflater.from(context), z, R.layout.t);
        this.j = i;
        this.n = i2;
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.x));
        this.s = view;
        this.o = new jh0(context, null, i, i2);
        fVar.addMenuPresenter(this, context);
    }

    @Override // defpackage.b01
    public final boolean a() {
        return !this.w && this.o.E.isShowing();
    }

    @Override // defpackage.ih0
    public final void b(f fVar) {
    }

    @Override // defpackage.ih0
    public final void d(View view) {
        this.s = view;
    }

    @Override // defpackage.b01
    public final void dismiss() {
        if (a()) {
            this.o.dismiss();
        }
    }

    @Override // defpackage.ih0
    public final void e(boolean z) {
        this.f.d = z;
    }

    @Override // defpackage.ih0
    public final void f(int i) {
        this.z = i;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean flagActionItems() {
        return false;
    }

    @Override // defpackage.ih0
    public final void g(int i) {
        this.o.i = i;
    }

    @Override // defpackage.ih0
    public final void h(PopupWindow.OnDismissListener onDismissListener) {
        this.r = onDismissListener;
    }

    @Override // defpackage.ih0
    public final void i(boolean z) {
        this.A = z;
    }

    @Override // defpackage.ih0
    public final void j(int i) {
        this.o.h(i);
    }

    @Override // defpackage.b01
    public final jp n() {
        return this.o.d;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void onCloseMenu(f fVar, boolean z) {
        if (fVar != this.d) {
            return;
        }
        dismiss();
        j.a aVar = this.u;
        if (aVar != null) {
            aVar.onCloseMenu(fVar, z);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.w = true;
        this.d.close(true);
        ViewTreeObserver viewTreeObserver = this.v;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.v = this.t.getViewTreeObserver();
            }
            this.v.removeGlobalOnLayoutListener(this.p);
            this.v = null;
        }
        this.t.removeOnAttachStateChangeListener(this.q);
        PopupWindow.OnDismissListener onDismissListener = this.r;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.j
    public final Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean onSubMenuSelected(m mVar) {
        boolean z;
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.j, this.n, this.c, this.t, mVar, this.g);
            j.a aVar = this.u;
            iVar.i = aVar;
            ih0 ih0Var = iVar.j;
            if (ih0Var != null) {
                ih0Var.setCallback(aVar);
            }
            int size = mVar.mItems.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                MenuItem item = mVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            iVar.h = z;
            ih0 ih0Var2 = iVar.j;
            if (ih0Var2 != null) {
                ih0Var2.e(z);
            }
            iVar.k = this.r;
            this.r = null;
            this.d.close(false);
            jh0 jh0Var = this.o;
            int width = jh0Var.i;
            int iK = jh0Var.k();
            int i2 = this.z;
            View view = this.s;
            WeakHashMap weakHashMap = qd1.a;
            if ((Gravity.getAbsoluteGravity(i2, view.getLayoutDirection()) & 7) == 5) {
                width += this.s.getWidth();
            }
            if (!iVar.b()) {
                if (iVar.f != null) {
                    iVar.d(width, iK, true, true);
                }
            }
            j.a aVar2 = this.u;
            if (aVar2 != null) {
                aVar2.a(mVar);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void setCallback(j.a aVar) {
        this.u = aVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.b01
    public final void show() {
        View view;
        if (a()) {
            return;
        }
        if (this.w || (view = this.s) == null) {
            defpackage.d.AnonymousClass0.m("StandardMenuPopup cannot be used without an anchor");
            return;
        }
        this.t = view;
        jh0 jh0Var = this.o;
        jh0Var.E.setOnDismissListener(this);
        jh0Var.v = this;
        jh0Var.D = true;
        v5 v5Var = jh0Var.E;
        v5Var.setFocusable(true);
        View view2 = this.t;
        boolean z = this.v == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.v = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.p);
        }
        view2.addOnAttachStateChangeListener(this.q);
        jh0Var.u = view2;
        jh0Var.r = this.z;
        boolean z2 = this.x;
        Context context = this.c;
        e eVar = this.f;
        if (!z2) {
            this.y = ih0.c(eVar, context, this.i);
            this.x = true;
        }
        jh0Var.p(this.y);
        v5Var.setInputMethodMode(2);
        Rect rect = this.b;
        jh0Var.C = rect != null ? new Rect(rect) : null;
        jh0Var.show();
        jp jpVar = jh0Var.d;
        jpVar.setOnKeyListener(this);
        if (this.A) {
            f fVar = this.d;
            if (fVar.mHeaderTitle != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.s, (ViewGroup) jpVar, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(fVar.mHeaderTitle);
                }
                frameLayout.setEnabled(false);
                jpVar.addHeaderView(frameLayout, null, false);
            }
        }
        jh0Var.l(eVar);
        jh0Var.show();
    }

    @Override // androidx.appcompat.view.menu.j
    public final void updateMenuView(boolean z) {
        this.x = false;
        e eVar = this.f;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }
}
