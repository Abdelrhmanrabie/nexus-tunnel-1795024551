package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AlertController;
import java.util.ArrayList;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d implements j, AdapterView.OnItemClickListener {
    public Context b;
    public LayoutInflater c;
    public f d;
    public ExpandedMenuView f;
    public j.a g;
    public a i;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a extends BaseAdapter {
        public int b = -1;

        public a() {
            b();
        }

        public final void b() {
            f fVar = d.this.d;
            h hVar = fVar.mExpandedItem;
            if (hVar != null) {
                fVar.flagActionItems();
                ArrayList arrayList = fVar.mNonActionItems;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (((h) arrayList.get(i)) == hVar) {
                        this.b = i;
                        return;
                    }
                }
            }
            this.b = -1;
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final h getItem(int i) {
            f fVar = d.this.d;
            fVar.flagActionItems();
            ArrayList arrayList = fVar.mNonActionItems;
            int i2 = this.b;
            if (i2 >= 0 && i >= i2) {
                i++;
            }
            return (h) arrayList.get(i);
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            f fVar = d.this.d;
            fVar.flagActionItems();
            int size = fVar.mNonActionItems.size();
            return this.b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = d.this.c.inflate(R.layout.q, viewGroup, false);
            }
            ((k.a) view).initialize(getItem(i));
            return view;
        }

        @Override // android.widget.BaseAdapter
        public final void notifyDataSetChanged() {
            b();
            super.notifyDataSetChanged();
        }
    }

    public d(Context context) {
        this.b = context;
        this.c = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean collapseItemActionView(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean expandItemActionView(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void initForMenu(Context context, f fVar) {
        if (this.b != null) {
            this.b = context;
            if (this.c == null) {
                this.c = LayoutInflater.from(context);
            }
        }
        this.d = fVar;
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void onCloseMenu(f fVar, boolean z) {
        j.a aVar = this.g;
        if (aVar != null) {
            aVar.onCloseMenu(fVar, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.d.performItemAction(this.i.getItem(i), this, 0);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final Parcelable onSaveInstanceState() {
        if (this.f == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean onSubMenuSelected(m mVar) {
        boolean zHasVisibleItems = mVar.hasVisibleItems();
        Context context = mVar.mContext;
        if (!zHasVisibleItems) {
            return false;
        }
        g gVar = new g(mVar);
        androidx.appcompat.app.e.a aVar = new androidx.appcompat.app.e.a(context);
        AlertController.b bVar = aVar.P;
        d dVar = new d(bVar.a);
        gVar.d = dVar;
        dVar.g = gVar;
        mVar.addMenuPresenter(dVar, context);
        d dVar2 = gVar.d;
        if (dVar2.i == null) {
            dVar2.i = dVar2.new a();
        }
        bVar.v = dVar2.i;
        bVar.w = gVar;
        View view = mVar.mHeaderView;
        if (view != null) {
            bVar.f = view;
        } else {
            bVar.d = mVar.mHeaderIcon;
            bVar.e = mVar.mHeaderTitle;
        }
        bVar.t = gVar;
        androidx.appcompat.app.e eVarCreate = aVar.create();
        gVar.c = eVarCreate;
        eVarCreate.setOnDismissListener(gVar);
        WindowManager.LayoutParams attributes = gVar.c.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        gVar.c.show();
        j.a aVar2 = this.g;
        if (aVar2 == null) {
            return true;
        }
        aVar2.a(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void setCallback(j.a aVar) {
        throw null;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void updateMenuView(boolean z) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }
}
