package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ItemRecyclerSubSettingBinding {
    public final SwitchCompat chkEnable;
    public final LinearLayout infoContainer;
    public final LinearLayout itemBg;
    public final CardView itemCardview;
    public final LinearLayout layoutEdit;
    public final LinearLayout layoutShare;
    private final LinearLayout rootView;
    public final TextView tvName;
    public final TextView tvUrl;

    private ItemRecyclerSubSettingBinding(LinearLayout linearLayout, SwitchCompat switchCompat, LinearLayout linearLayout2, LinearLayout linearLayout3, CardView cardView, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.chkEnable = switchCompat;
        this.infoContainer = linearLayout2;
        this.itemBg = linearLayout3;
        this.itemCardview = cardView;
        this.layoutEdit = linearLayout4;
        this.layoutShare = linearLayout5;
        this.tvName = textView;
        this.tvUrl = textView2;
    }

    public static ItemRecyclerSubSettingBinding bind(View view) {
        int i = R.id.chk_enable;
        SwitchCompat switchCompat = (SwitchCompat) e.p(view, i);
        if (switchCompat != null) {
            i = R.id.info_container;
            LinearLayout linearLayout = (LinearLayout) e.p(view, i);
            if (linearLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) view;
                i = R.id.item_cardview;
                CardView cardView = (CardView) e.p(view, i);
                if (cardView != null) {
                    i = R.id.layout_edit;
                    LinearLayout linearLayout3 = (LinearLayout) e.p(view, i);
                    if (linearLayout3 != null) {
                        i = R.id.layout_share;
                        LinearLayout linearLayout4 = (LinearLayout) e.p(view, i);
                        if (linearLayout4 != null) {
                            i = R.id.tv_name;
                            TextView textView = (TextView) e.p(view, i);
                            if (textView != null) {
                                i = R.id.tv_url;
                                TextView textView2 = (TextView) e.p(view, i);
                                if (textView2 != null) {
                                    return new ItemRecyclerSubSettingBinding(linearLayout2, switchCompat, linearLayout, linearLayout2, cardView, linearLayout3, linearLayout4, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemRecyclerSubSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRecyclerSubSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_recycler_sub_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
