package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import defpackage.ih0;
import defpackage.jh0;
import defpackage.jp;
import defpackage.qd1;
import defpackage.v5;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b extends ih0 implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public int A;
    public boolean C;
    public j.a D;
    public ViewTreeObserver E;
    public PopupWindow.OnDismissListener F;
    public boolean G;
    public final Context c;
    public final int d;
    public final int f;
    public final int g;
    public final boolean i;
    public final Handler j;
    public View u;
    public View v;
    public int w;
    public boolean x;
    public boolean y;
    public int z;
    public final ArrayList n = new ArrayList();
    public final ArrayList o = new ArrayList();
    public final a p = new a();
    public final ViewOnAttachStateChangeListenerC0000b q = new ViewOnAttachStateChangeListenerC0000b();
    public final c r = new c();
    public int s = 0;
    public int t = 0;
    public boolean B = false;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            b bVar = b.this;
            if (bVar.a()) {
                ArrayList arrayList = bVar.o;
                if (arrayList.size() <= 0 || ((d) arrayList.get(0)).a.D) {
                    return;
                }
                View view = bVar.v;
                if (view == null || !view.isShown()) {
                    bVar.dismiss();
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a.show();
                }
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class ViewOnAttachStateChangeListenerC0000b implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC0000b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            b bVar = b.this;
            ViewTreeObserver viewTreeObserver = bVar.E;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    bVar.E = view.getViewTreeObserver();
                }
                bVar.E.removeGlobalOnLayoutListener(bVar.p);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c {
        public c() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class d {
        public final jh0 a;
        public final f b;
        public final int c;

        public d(jh0 jh0Var, f fVar, int i) {
            this.a = jh0Var;
            this.b = fVar;
            this.c = i;
        }
    }

    public b(Context context, View view, int i, int i2, boolean z) {
        this.c = context;
        this.u = view;
        this.f = i;
        this.g = i2;
        this.i = z;
        WeakHashMap weakHashMap = qd1.a;
        this.w = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.x));
        this.j = new Handler();
    }

    @Override // defpackage.b01
    public final boolean a() {
        ArrayList arrayList = this.o;
        return arrayList.size() > 0 && ((d) arrayList.get(0)).a.E.isShowing();
    }

    @Override // defpackage.ih0
    public final void b(f fVar) {
        fVar.addMenuPresenter(this, this.c);
        if (a()) {
            l(fVar);
        } else {
            this.n.add(fVar);
        }
    }

    @Override // defpackage.ih0
    public final void d(View view) {
        if (this.u != view) {
            this.u = view;
            int i = this.s;
            WeakHashMap weakHashMap = qd1.a;
            this.t = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        }
    }

    @Override // defpackage.b01
    public final void dismiss() {
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        if (size <= 0) {
            return;
        }
        d[] dVarArr = (d[]) arrayList.toArray(new d[size]);
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            d dVar = dVarArr[size];
            if (dVar.a.E.isShowing()) {
                dVar.a.dismiss();
            }
        }
    }

    @Override // defpackage.ih0
    public final void e(boolean z) {
        this.B = z;
    }

    @Override // defpackage.ih0
    public final void f(int i) {
        if (this.s != i) {
            this.s = i;
            View view = this.u;
            WeakHashMap weakHashMap = qd1.a;
            this.t = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean flagActionItems() {
        return false;
    }

    @Override // defpackage.ih0
    public final void g(int i) {
        this.x = true;
        this.z = i;
    }

    @Override // defpackage.ih0
    public final void h(PopupWindow.OnDismissListener onDismissListener) {
        this.F = onDismissListener;
    }

    @Override // defpackage.ih0
    public final void i(boolean z) {
        this.C = z;
    }

    @Override // defpackage.ih0
    public final void j(int i) {
        this.y = true;
        this.A = i;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0165  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void l(f fVar) {
        boolean z;
        char c2;
        View childAt;
        d dVar;
        int i;
        int i2;
        int i3;
        int width;
        MenuItem menuItem;
        e eVar;
        int headersCount;
        int firstVisiblePosition;
        Context context = this.c;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        e eVar2 = new e(fVar, layoutInflaterFrom, this.i, R.layout.l);
        if (!a() && this.B) {
            eVar2.d = true;
        } else if (a()) {
            int size = fVar.mItems.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    z = false;
                    break;
                }
                MenuItem item = fVar.getItem(i4);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i4++;
            }
            eVar2.d = z;
        }
        int iC = ih0.c(eVar2, context, this.d);
        jh0 jh0Var = new jh0(context, null, this.f, this.g);
        jh0Var.I = this.r;
        jh0Var.v = this;
        v5 v5Var = jh0Var.E;
        v5Var.setOnDismissListener(this);
        jh0Var.u = this.u;
        jh0Var.r = this.t;
        jh0Var.D = true;
        v5Var.setFocusable(true);
        v5Var.setInputMethodMode(2);
        jh0Var.l(eVar2);
        jh0Var.p(iC);
        jh0Var.r = this.t;
        ArrayList arrayList = this.o;
        if (arrayList.size() > 0) {
            dVar = (d) arrayList.get(arrayList.size() - 1);
            f fVar2 = dVar.b;
            int size2 = fVar2.mItems.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size2) {
                    menuItem = null;
                    break;
                }
                MenuItem item2 = fVar2.getItem(i5);
                if (item2.hasSubMenu() && fVar == item2.getSubMenu()) {
                    menuItem = item2;
                    break;
                }
                i5++;
            }
            if (menuItem == null) {
                c2 = 0;
            } else {
                jp jpVar = dVar.a.d;
                ListAdapter adapter = jpVar.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    eVar = (e) headerViewListAdapter.getWrappedAdapter();
                } else {
                    eVar = (e) adapter;
                    headersCount = 0;
                }
                int count = eVar.getCount();
                int i6 = 0;
                c2 = 0;
                while (true) {
                    if (i6 >= count) {
                        i6 = -1;
                        break;
                    } else if (menuItem == eVar.getItem(i6)) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 != -1 && (firstVisiblePosition = (i6 + headersCount) - jpVar.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < jpVar.getChildCount()) {
                    childAt = jpVar.getChildAt(firstVisiblePosition);
                }
            }
            childAt = null;
        } else {
            c2 = 0;
            childAt = null;
            dVar = null;
        }
        if (childAt != null) {
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = jh0.J;
                if (method != null) {
                    try {
                        Object[] objArr = new Object[1];
                        objArr[c2] = Boolean.FALSE;
                        method.invoke(v5Var, objArr);
                    } catch (Exception unused) {
                    }
                }
            } else {
                v5Var.setTouchModal(c2);
            }
            v5Var.setEnterTransition(null);
            jp jpVar2 = ((d) arrayList.get(arrayList.size() - 1)).a.d;
            int[] iArr = new int[2];
            jpVar2.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            this.v.getWindowVisibleDisplayFrame(rect);
            if (this.w == 1) {
                if (jpVar2.getWidth() + iArr[0] + iC > rect.right) {
                    i = 0;
                } else {
                    i = 1;
                }
            } else if (iArr[0] - iC < 0) {
                i = 1;
            } else {
                i = 0;
            }
            boolean z2 = i == 1;
            this.w = i;
            if (Build.VERSION.SDK_INT >= 26) {
                jh0Var.u = childAt;
                i2 = 0;
                i3 = 0;
            } else {
                int[] iArr2 = new int[2];
                this.u.getLocationOnScreen(iArr2);
                int[] iArr3 = new int[2];
                childAt.getLocationOnScreen(iArr3);
                if ((this.t & 7) == 5) {
                    iArr2[0] = this.u.getWidth() + iArr2[0];
                    iArr3[0] = childAt.getWidth() + iArr3[0];
                }
                int i7 = iArr3[0] - iArr2[0];
                i2 = iArr3[1] - iArr2[1];
                i3 = i7;
            }
            if ((this.t & 5) != 5) {
                width = z2 ? i3 + childAt.getWidth() : i3 - iC;
            } else if (z2) {
                width = i3 + iC;
            } else {
                iC = childAt.getWidth();
            }
            jh0Var.i = width;
            jh0Var.q = true;
            jh0Var.p = true;
            jh0Var.h(i2);
        } else {
            if (this.x) {
                jh0Var.i = this.z;
            }
            if (this.y) {
                jh0Var.h(this.A);
            }
            Rect rect2 = this.b;
            jh0Var.C = rect2 != null ? new Rect(rect2) : null;
        }
        arrayList.add(new d(jh0Var, fVar, this.w));
        jh0Var.show();
        jp jpVar3 = jh0Var.d;
        jpVar3.setOnKeyListener(this);
        if (dVar == null && this.C && fVar.mHeaderTitle != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.s, (ViewGroup) jpVar3, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(fVar.mHeaderTitle);
            jpVar3.addHeaderView(frameLayout, null, false);
            jh0Var.show();
        }
    }

    @Override // defpackage.b01
    public final jp n() {
        ArrayList arrayList = this.o;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((d) arrayList.get(arrayList.size() - 1)).a.d;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void onCloseMenu(f fVar, boolean z) {
        int i;
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (fVar == ((d) arrayList.get(i2)).b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0) {
            return;
        }
        int i3 = i2 + 1;
        if (i3 < arrayList.size()) {
            ((d) arrayList.get(i3)).b.close(false);
        }
        d dVar = (d) arrayList.remove(i2);
        dVar.b.removeMenuPresenter(this);
        boolean z2 = this.G;
        jh0 jh0Var = dVar.a;
        if (z2) {
            jh0Var.E.setExitTransition(null);
            jh0Var.E.setAnimationStyle(0);
        }
        jh0Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            i = ((d) arrayList.get(size2 - 1)).c;
        } else {
            View view = this.u;
            WeakHashMap weakHashMap = qd1.a;
            i = view.getLayoutDirection() == 1 ? 0 : 1;
        }
        this.w = i;
        if (size2 != 0) {
            if (z) {
                ((d) arrayList.get(0)).b.close(false);
                return;
            }
            return;
        }
        dismiss();
        j.a aVar = this.D;
        if (aVar != null) {
            aVar.onCloseMenu(fVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.E;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.E.removeGlobalOnLayoutListener(this.p);
            }
            this.E = null;
        }
        this.v.removeOnAttachStateChangeListener(this.q);
        this.F.onDismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        d dVar;
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                dVar = null;
                break;
            }
            dVar = (d) arrayList.get(i);
            if (!dVar.a.E.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (dVar != null) {
            dVar.b.close(false);
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
        for (d dVar : this.o) {
            if (mVar == dVar.b) {
                dVar.a.d.requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        b(mVar);
        j.a aVar = this.D;
        if (aVar != null) {
            aVar.a(mVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void setCallback(j.a aVar) {
        this.D = aVar;
    }

    @Override // defpackage.b01
    public final void show() {
        if (a()) {
            return;
        }
        ArrayList arrayList = this.n;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            l((f) it.next());
        }
        arrayList.clear();
        View view = this.u;
        this.v = view;
        if (view != null) {
            boolean z = this.E == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.E = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.p);
            }
            this.v.addOnAttachStateChangeListener(this.q);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void updateMenuView(boolean z) {
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((d) it.next()).a.d.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((e) adapter).notifyDataSetChanged();
        }
    }
}
