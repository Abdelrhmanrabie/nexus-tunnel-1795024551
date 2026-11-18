package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityRoutingSettingBinding {
    public final CoordinatorLayout mainContent;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;
    public final Spinner spDomainStrategy;

    private ActivityRoutingSettingBinding(RelativeLayout relativeLayout, CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, Spinner spinner) {
        this.rootView = relativeLayout;
        this.mainContent = coordinatorLayout;
        this.recyclerView = recyclerView;
        this.spDomainStrategy = spinner;
    }

    public static ActivityRoutingSettingBinding bind(View view) {
        int i = R.id.main_content;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) e.p(view, i);
        if (coordinatorLayout != null) {
            i = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) e.p(view, i);
            if (recyclerView != null) {
                i = R.id.sp_domain_strategy;
                Spinner spinner = (Spinner) e.p(view, i);
                if (spinner != null) {
                    return new ActivityRoutingSettingBinding((RelativeLayout) view, coordinatorLayout, recyclerView, spinner);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityRoutingSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRoutingSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_routing_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
