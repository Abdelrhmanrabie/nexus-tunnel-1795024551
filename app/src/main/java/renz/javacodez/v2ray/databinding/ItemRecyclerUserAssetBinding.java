package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ItemRecyclerUserAssetBinding {
    public final TextView assetName;
    public final TextView assetProperties;
    public final LinearLayout layoutEdit;
    public final LinearLayout layoutRemove;
    private final LinearLayout rootView;

    private ItemRecyclerUserAssetBinding(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.assetName = textView;
        this.assetProperties = textView2;
        this.layoutEdit = linearLayout2;
        this.layoutRemove = linearLayout3;
    }

    public static ItemRecyclerUserAssetBinding bind(View view) {
        int i = R.id.asset_name;
        TextView textView = (TextView) e.p(view, i);
        if (textView != null) {
            i = R.id.asset_properties;
            TextView textView2 = (TextView) e.p(view, i);
            if (textView2 != null) {
                i = R.id.layout_edit;
                LinearLayout linearLayout = (LinearLayout) e.p(view, i);
                if (linearLayout != null) {
                    i = R.id.layout_remove;
                    LinearLayout linearLayout2 = (LinearLayout) e.p(view, i);
                    if (linearLayout2 != null) {
                        return new ItemRecyclerUserAssetBinding((LinearLayout) view, textView, textView2, linearLayout, linearLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemRecyclerUserAssetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRecyclerUserAssetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_recycler_user_asset, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
