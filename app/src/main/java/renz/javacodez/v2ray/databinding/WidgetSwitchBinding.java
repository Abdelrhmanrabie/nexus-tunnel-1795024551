package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetSwitchBinding {
    public final ImageView imageSwitch;
    public final LinearLayout layoutBackground;
    public final LinearLayout layoutSwitch;
    private final LinearLayout rootView;

    private WidgetSwitchBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.imageSwitch = imageView;
        this.layoutBackground = linearLayout2;
        this.layoutSwitch = linearLayout3;
    }

    public static WidgetSwitchBinding bind(View view) {
        int i = R.id.image_switch;
        ImageView imageView = (ImageView) e.p(view, i);
        if (imageView != null) {
            i = R.id.layout_background;
            LinearLayout linearLayout = (LinearLayout) e.p(view, i);
            if (linearLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) view;
                return new WidgetSwitchBinding(linearLayout2, imageView, linearLayout, linearLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static WidgetSwitchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WidgetSwitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.widget_switch, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
