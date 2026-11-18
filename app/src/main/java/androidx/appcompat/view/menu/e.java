package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.ArrayList;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class e extends BaseAdapter {
    public final f b;
    public int c = -1;
    public boolean d;
    public final boolean f;
    public final LayoutInflater g;
    public final int i;

    public e(f fVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.f = z;
        this.g = layoutInflater;
        this.b = fVar;
        this.i = i;
        b();
    }

    public final void b() {
        f fVar = this.b;
        h hVar = fVar.mExpandedItem;
        if (hVar != null) {
            fVar.flagActionItems();
            ArrayList arrayList = fVar.mNonActionItems;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((h) arrayList.get(i)) == hVar) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final h getItem(int i) {
        ArrayList visibleItems;
        boolean z = this.f;
        f fVar = this.b;
        if (z) {
            fVar.flagActionItems();
            visibleItems = fVar.mNonActionItems;
        } else {
            visibleItems = fVar.getVisibleItems();
        }
        int i2 = this.c;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (h) visibleItems.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList visibleItems;
        boolean z = this.f;
        f fVar = this.b;
        if (z) {
            fVar.flagActionItems();
            visibleItems = fVar.mNonActionItems;
        } else {
            visibleItems = fVar.getVisibleItems();
        }
        int i = this.c;
        int size = visibleItems.size();
        return i < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.g.inflate(this.i, viewGroup, false);
        }
        int i2 = getItem(i).b;
        int i3 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        boolean z = this.b.isGroupDividerEnabled() && i2 != (i3 >= 0 ? getItem(i3).b : i2);
        ImageView imageView = listMenuItemView.n;
        if (imageView != null) {
            imageView.setVisibility((listMenuItemView.u || !z) ? 8 : 0);
        }
        k.a aVar = (k.a) view;
        if (this.d) {
            listMenuItemView.w = true;
            listMenuItemView.s = true;
        }
        aVar.initialize(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
