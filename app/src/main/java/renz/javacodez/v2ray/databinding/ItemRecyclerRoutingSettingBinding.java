package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ItemRecyclerRoutingSettingBinding {
    public final SwitchCompat chkEnable;
    public final TextView domainIp;
    public final ImageView imgLocked;
    public final LinearLayout infoContainer;
    public final LinearLayout itemBg;
    public final CardView itemCardview;
    public final LinearLayout layoutEdit;
    public final TextView outboundTag;
    public final TextView remarks;
    private final LinearLayout rootView;

    private ItemRecyclerRoutingSettingBinding(LinearLayout linearLayout, SwitchCompat switchCompat, TextView textView, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, CardView cardView, LinearLayout linearLayout4, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.chkEnable = switchCompat;
        this.domainIp = textView;
        this.imgLocked = imageView;
        this.infoContainer = linearLayout2;
        this.itemBg = linearLayout3;
        this.itemCardview = cardView;
        this.layoutEdit = linearLayout4;
        this.outboundTag = textView2;
        this.remarks = textView3;
    }

    public static ItemRecyclerRoutingSettingBinding bind(View view) {
        int i = R.id.chk_enable;
        SwitchCompat switchCompat = (SwitchCompat) e.p(view, i);
        if (switchCompat != null) {
            i = R.id.domainIp;
            TextView textView = (TextView) e.p(view, i);
            if (textView != null) {
                i = R.id.img_locked;
                ImageView imageView = (ImageView) e.p(view, i);
                if (imageView != null) {
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
                                i = R.id.outboundTag;
                                TextView textView2 = (TextView) e.p(view, i);
                                if (textView2 != null) {
                                    i = R.id.remarks;
                                    TextView textView3 = (TextView) e.p(view, i);
                                    if (textView3 != null) {
                                        return new ItemRecyclerRoutingSettingBinding(linearLayout2, switchCompat, textView, imageView, linearLayout, linearLayout2, cardView, linearLayout3, textView2, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemRecyclerRoutingSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRecyclerRoutingSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_recycler_routing_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
