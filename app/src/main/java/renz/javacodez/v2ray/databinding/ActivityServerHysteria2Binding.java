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
public final class ActivityServerHysteria2Binding {
    public final EditText etId;
    public final EditText etObfsPassword;
    public final EditText etPortHop;
    public final EditText etPortHopInterval;
    private final ScrollView rootView;

    private ActivityServerHysteria2Binding(ScrollView scrollView, EditText editText, EditText editText2, EditText editText3, EditText editText4) {
        this.rootView = scrollView;
        this.etId = editText;
        this.etObfsPassword = editText2;
        this.etPortHop = editText3;
        this.etPortHopInterval = editText4;
    }

    public static ActivityServerHysteria2Binding bind(View view) {
        int i = R.id.et_id;
        EditText editText = (EditText) e.p(view, i);
        if (editText != null) {
            i = R.id.et_obfs_password;
            EditText editText2 = (EditText) e.p(view, i);
            if (editText2 != null) {
                i = R.id.et_port_hop;
                EditText editText3 = (EditText) e.p(view, i);
                if (editText3 != null) {
                    i = R.id.et_port_hop_interval;
                    EditText editText4 = (EditText) e.p(view, i);
                    if (editText4 != null) {
                        return new ActivityServerHysteria2Binding((ScrollView) view, editText, editText2, editText3, editText4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityServerHysteria2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityServerHysteria2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_server_hysteria2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
