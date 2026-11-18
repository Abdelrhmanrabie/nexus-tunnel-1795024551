package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityServerShadowsocksBinding {
    public final EditText etId;
    private final ScrollView rootView;
    public final Spinner spSecurity;

    private ActivityServerShadowsocksBinding(ScrollView scrollView, EditText editText, Spinner spinner) {
        this.rootView = scrollView;
        this.etId = editText;
        this.spSecurity = spinner;
    }

    public static ActivityServerShadowsocksBinding bind(View view) {
        int i = R.id.et_id;
        EditText editText = (EditText) e.p(view, i);
        if (editText != null) {
            i = R.id.sp_security;
            Spinner spinner = (Spinner) e.p(view, i);
            if (spinner != null) {
                return new ActivityServerShadowsocksBinding((ScrollView) view, editText, spinner);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityServerShadowsocksBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityServerShadowsocksBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_server_shadowsocks, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
