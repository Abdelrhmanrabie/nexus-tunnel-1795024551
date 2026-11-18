package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ItemRecyclerFooterBinding {
    public final LinearLayout itemBg;
    public final LinearLayout layoutEdit;
    private final LinearLayout rootView;

    private ItemRecyclerFooterBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.itemBg = linearLayout2;
        this.layoutEdit = linearLayout3;
    }

    public static ItemRecyclerFooterBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.layout_edit;
        LinearLayout linearLayout2 = (LinearLayout) e.p(view, i);
        if (linearLayout2 != null) {
            return new ItemRecyclerFooterBinding(linearLayout, linearLayout, linearLayout2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemRecyclerFooterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRecyclerFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_recycler_footer, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
