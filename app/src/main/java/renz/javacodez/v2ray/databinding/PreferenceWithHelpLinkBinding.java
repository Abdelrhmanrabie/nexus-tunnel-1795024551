package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import defpackage.d;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceWithHelpLinkBinding {
    private final Button rootView;

    private PreferenceWithHelpLinkBinding(Button button) {
        this.rootView = button;
    }

    public static PreferenceWithHelpLinkBinding bind(View view) {
        if (view != null) {
            return new PreferenceWithHelpLinkBinding((Button) view);
        }
        d.AnonymousClass0.m$1("rootView");
        return null;
    }

    public static PreferenceWithHelpLinkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PreferenceWithHelpLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.preference_with_help_link, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public Button getRoot() {
        return this.rootView;
    }
}
