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
public final class ItemQrcodeBinding {
    public final ImageView ivQcode;
    private final LinearLayout rootView;

    private ItemQrcodeBinding(LinearLayout linearLayout, ImageView imageView) {
        this.rootView = linearLayout;
        this.ivQcode = imageView;
    }

    public static ItemQrcodeBinding bind(View view) {
        int i = R.id.iv_qcode;
        ImageView imageView = (ImageView) e.p(view, i);
        if (imageView != null) {
            return new ItemQrcodeBinding((LinearLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemQrcodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemQrcodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_qrcode, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
