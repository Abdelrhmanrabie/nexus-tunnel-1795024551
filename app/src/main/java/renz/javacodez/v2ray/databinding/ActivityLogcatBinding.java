package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityLogcatBinding {
    public final ProgressBar pbWaiting;
    private final RelativeLayout rootView;
    public final ScrollView svLogcat;
    public final TextView tvLogcat;

    private ActivityLogcatBinding(RelativeLayout relativeLayout, ProgressBar progressBar, ScrollView scrollView, TextView textView) {
        this.rootView = relativeLayout;
        this.pbWaiting = progressBar;
        this.svLogcat = scrollView;
        this.tvLogcat = textView;
    }

    public static ActivityLogcatBinding bind(View view) {
        int i = R.id.pb_waiting;
        ProgressBar progressBar = (ProgressBar) e.p(view, i);
        if (progressBar != null) {
            i = R.id.sv_logcat;
            ScrollView scrollView = (ScrollView) e.p(view, i);
            if (scrollView != null) {
                i = R.id.tv_logcat;
                TextView textView = (TextView) e.p(view, i);
                if (textView != null) {
                    return new ActivityLogcatBinding((RelativeLayout) view, progressBar, scrollView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityLogcatBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityLogcatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_logcat, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
