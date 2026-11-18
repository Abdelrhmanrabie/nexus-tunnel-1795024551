package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ih0 implements b01, j, AdapterView.OnItemClickListener {
    public Rect b;

    public static int c(e eVar, Context context, int i) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = eVar.getCount();
        int i2 = 0;
        int i3 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = eVar.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = eVar.getView(i4, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public abstract void b(f fVar);

    @Override // androidx.appcompat.view.menu.j
    public final boolean collapseItemActionView(h hVar) {
        return false;
    }

    public abstract void d(View view);

    public abstract void e(boolean z);

    @Override // androidx.appcompat.view.menu.j
    public final boolean expandItemActionView(h hVar) {
        return false;
    }

    public abstract void f(int i);

    public abstract void g(int i);

    @Override // androidx.appcompat.view.menu.j
    public final int getId() {
        return 0;
    }

    public abstract void h(PopupWindow.OnDismissListener onDismissListener);

    public abstract void i(boolean z);

    @Override // androidx.appcompat.view.menu.j
    public final void initForMenu(Context context, f fVar) {
    }

    public abstract void j(int i);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (e) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (e) listAdapter).b.performItemAction((MenuItem) listAdapter.getItem(i), this, !(this instanceof b) ? 0 : 4);
    }
}
