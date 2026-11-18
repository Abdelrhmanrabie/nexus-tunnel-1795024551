package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import defpackage.d;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class NavHeaderBinding {
    private final LinearLayout rootView;

    private NavHeaderBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public static NavHeaderBinding bind(View view) {
        if (view != null) {
            return new NavHeaderBinding((LinearLayout) view);
        }
        d.AnonymousClass0.m$1("rootView");
        return null;
    }

    public static NavHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NavHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.nav_header, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
