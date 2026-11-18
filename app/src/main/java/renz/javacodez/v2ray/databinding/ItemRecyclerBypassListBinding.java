package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ItemRecyclerBypassListBinding {
    public final AppCompatCheckBox checkBox;
    public final AppCompatImageView icon;
    public final AppCompatTextView name;
    public final AppCompatTextView packageName;
    private final LinearLayout rootView;

    private ItemRecyclerBypassListBinding(LinearLayout linearLayout, AppCompatCheckBox appCompatCheckBox, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.rootView = linearLayout;
        this.checkBox = appCompatCheckBox;
        this.icon = appCompatImageView;
        this.name = appCompatTextView;
        this.packageName = appCompatTextView2;
    }

    public static ItemRecyclerBypassListBinding bind(View view) {
        int i = R.id.check_box;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) e.p(view, i);
        if (appCompatCheckBox != null) {
            i = R.id.icon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) e.p(view, i);
            if (appCompatImageView != null) {
                i = R.id.name;
                AppCompatTextView appCompatTextView = (AppCompatTextView) e.p(view, i);
                if (appCompatTextView != null) {
                    i = R.id.package_name;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) e.p(view, i);
                    if (appCompatTextView2 != null) {
                        return new ItemRecyclerBypassListBinding((LinearLayout) view, appCompatCheckBox, appCompatImageView, appCompatTextView, appCompatTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemRecyclerBypassListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRecyclerBypassListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_recycler_bypass_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
