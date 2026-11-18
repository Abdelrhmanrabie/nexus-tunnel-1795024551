package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutProgressBinding {
    public final ProgressBar pbWaiting;
    private final LinearLayout rootView;

    private LayoutProgressBinding(LinearLayout linearLayout, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.pbWaiting = progressBar;
    }

    public static LayoutProgressBinding bind(View view) {
        int i = R.id.pb_waiting;
        ProgressBar progressBar = (ProgressBar) e.p(view, i);
        if (progressBar != null) {
            return new LayoutProgressBinding((LinearLayout) view, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
