package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityUserAssetUrlBinding {
    public final EditText etRemarks;
    public final EditText etUrl;
    private final ScrollView rootView;

    private ActivityUserAssetUrlBinding(ScrollView scrollView, EditText editText, EditText editText2) {
        this.rootView = scrollView;
        this.etRemarks = editText;
        this.etUrl = editText2;
    }

    public static ActivityUserAssetUrlBinding bind(View view) {
        int i = R.id.et_remarks;
        EditText editText = (EditText) e.p(view, i);
        if (editText != null) {
            i = R.id.et_url;
            EditText editText2 = (EditText) e.p(view, i);
            if (editText2 != null) {
                return new ActivityUserAssetUrlBinding((ScrollView) view, editText, editText2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityUserAssetUrlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUserAssetUrlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_user_asset_url, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
