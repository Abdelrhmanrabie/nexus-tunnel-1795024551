package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivitySubSettingBinding {
    public final CoordinatorLayout mainContent;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;

    private ActivitySubSettingBinding(RelativeLayout relativeLayout, CoordinatorLayout coordinatorLayout, RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.mainContent = coordinatorLayout;
        this.recyclerView = recyclerView;
    }

    public static ActivitySubSettingBinding bind(View view) {
        int i = R.id.main_content;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) e.p(view, i);
        if (coordinatorLayout != null) {
            i = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) e.p(view, i);
            if (recyclerView != null) {
                return new ActivitySubSettingBinding((RelativeLayout) view, coordinatorLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivitySubSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySubSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_sub_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
