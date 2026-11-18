package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivitySettingsBinding {
    public final FragmentContainerView fragmentSettings;
    private final LinearLayout rootView;

    private ActivitySettingsBinding(LinearLayout linearLayout, FragmentContainerView fragmentContainerView) {
        this.rootView = linearLayout;
        this.fragmentSettings = fragmentContainerView;
    }

    public static ActivitySettingsBinding bind(View view) {
        int i = R.id.fragment_settings;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) e.p(view, i);
        if (fragmentContainerView != null) {
            return new ActivitySettingsBinding((LinearLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivitySettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
