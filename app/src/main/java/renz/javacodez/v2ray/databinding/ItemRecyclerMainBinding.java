package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ItemRecyclerMainBinding {
    public final CardView cardView;
    public final LinearLayout infoContainer;
    public final LinearLayout itemBg;
    public final LinearLayout layoutEdit;
    public final LinearLayout layoutIndicator;
    public final LinearLayout layoutRemove;
    public final LinearLayout layoutShare;
    private final LinearLayout rootView;
    public final TextView tvName;
    public final TextView tvStatistics;
    public final TextView tvSubscription;
    public final TextView tvTestResult;
    public final TextView tvType;

    private ItemRecyclerMainBinding(LinearLayout linearLayout, CardView cardView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.cardView = cardView;
        this.infoContainer = linearLayout2;
        this.itemBg = linearLayout3;
        this.layoutEdit = linearLayout4;
        this.layoutIndicator = linearLayout5;
        this.layoutRemove = linearLayout6;
        this.layoutShare = linearLayout7;
        this.tvName = textView;
        this.tvStatistics = textView2;
        this.tvSubscription = textView3;
        this.tvTestResult = textView4;
        this.tvType = textView5;
    }

    public static ItemRecyclerMainBinding bind(View view) {
        int i = R.id.card_view;
        CardView cardView = (CardView) e.p(view, i);
        if (cardView != null) {
            i = R.id.info_container;
            LinearLayout linearLayout = (LinearLayout) e.p(view, i);
            if (linearLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) view;
                i = R.id.layout_edit;
                LinearLayout linearLayout3 = (LinearLayout) e.p(view, i);
                if (linearLayout3 != null) {
                    i = R.id.layout_indicator;
                    LinearLayout linearLayout4 = (LinearLayout) e.p(view, i);
                    if (linearLayout4 != null) {
                        i = R.id.layout_remove;
                        LinearLayout linearLayout5 = (LinearLayout) e.p(view, i);
                        if (linearLayout5 != null) {
                            i = R.id.layout_share;
                            LinearLayout linearLayout6 = (LinearLayout) e.p(view, i);
                            if (linearLayout6 != null) {
                                i = R.id.tv_name;
                                TextView textView = (TextView) e.p(view, i);
                                if (textView != null) {
                                    i = R.id.tv_statistics;
                                    TextView textView2 = (TextView) e.p(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tv_subscription;
                                        TextView textView3 = (TextView) e.p(view, i);
                                        if (textView3 != null) {
                                            i = R.id.tv_test_result;
                                            TextView textView4 = (TextView) e.p(view, i);
                                            if (textView4 != null) {
                                                i = R.id.tv_type;
                                                TextView textView5 = (TextView) e.p(view, i);
                                                if (textView5 != null) {
                                                    return new ItemRecyclerMainBinding(linearLayout2, cardView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, textView, textView2, textView3, textView4, textView5);
                                                }
                                            }
                                        }
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

    public static ItemRecyclerMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRecyclerMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_recycler_main, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
