package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityBypassListBinding {
    public final LinearLayout containerBypassApps;
    public final LinearLayout containerPerAppProxy;
    public final LinearLayout headerView;
    public final ProgressBar pbWaiting;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final SwitchCompat switchBypassApps;
    public final SwitchCompat switchPerAppProxy;

    private ActivityBypassListBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ProgressBar progressBar, RecyclerView recyclerView, SwitchCompat switchCompat, SwitchCompat switchCompat2) {
        this.rootView = linearLayout;
        this.containerBypassApps = linearLayout2;
        this.containerPerAppProxy = linearLayout3;
        this.headerView = linearLayout4;
        this.pbWaiting = progressBar;
        this.recyclerView = recyclerView;
        this.switchBypassApps = switchCompat;
        this.switchPerAppProxy = switchCompat2;
    }

    public static ActivityBypassListBinding bind(View view) {
        int i = R.id.container_bypass_apps;
        LinearLayout linearLayout = (LinearLayout) e.p(view, i);
        if (linearLayout != null) {
            i = R.id.container_per_app_proxy;
            LinearLayout linearLayout2 = (LinearLayout) e.p(view, i);
            if (linearLayout2 != null) {
                i = R.id.header_view;
                LinearLayout linearLayout3 = (LinearLayout) e.p(view, i);
                if (linearLayout3 != null) {
                    i = R.id.pb_waiting;
                    ProgressBar progressBar = (ProgressBar) e.p(view, i);
                    if (progressBar != null) {
                        i = R.id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) e.p(view, i);
                        if (recyclerView != null) {
                            i = R.id.switch_bypass_apps;
                            SwitchCompat switchCompat = (SwitchCompat) e.p(view, i);
                            if (switchCompat != null) {
                                i = R.id.switch_per_app_proxy;
                                SwitchCompat switchCompat2 = (SwitchCompat) e.p(view, i);
                                if (switchCompat2 != null) {
                                    return new ActivityBypassListBinding((LinearLayout) view, linearLayout, linearLayout2, linearLayout3, progressBar, recyclerView, switchCompat, switchCompat2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityBypassListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBypassListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bypass_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
