package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import defpackage.d;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityNoneBinding {
    private final RelativeLayout rootView;

    private ActivityNoneBinding(RelativeLayout relativeLayout) {
        this.rootView = relativeLayout;
    }

    public static ActivityNoneBinding bind(View view) {
        if (view != null) {
            return new ActivityNoneBinding((RelativeLayout) view);
        }
        d.AnonymousClass0.m$1("rootView");
        return null;
    }

    public static ActivityNoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityNoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_none, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
