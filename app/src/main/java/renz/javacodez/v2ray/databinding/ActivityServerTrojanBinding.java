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
public final class ActivityServerTrojanBinding {
    public final EditText etId;
    private final ScrollView rootView;

    private ActivityServerTrojanBinding(ScrollView scrollView, EditText editText) {
        this.rootView = scrollView;
        this.etId = editText;
    }

    public static ActivityServerTrojanBinding bind(View view) {
        int i = R.id.et_id;
        EditText editText = (EditText) e.p(view, i);
        if (editText != null) {
            return new ActivityServerTrojanBinding((ScrollView) view, editText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityServerTrojanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityServerTrojanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_server_trojan, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
