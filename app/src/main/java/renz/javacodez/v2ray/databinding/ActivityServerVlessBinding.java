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
public final class ActivityServerVlessBinding {
    public final EditText etId;
    public final EditText etSecurity;
    private final ScrollView rootView;
    public final Spinner spFlow;

    private ActivityServerVlessBinding(ScrollView scrollView, EditText editText, EditText editText2, Spinner spinner) {
        this.rootView = scrollView;
        this.etId = editText;
        this.etSecurity = editText2;
        this.spFlow = spinner;
    }

    public static ActivityServerVlessBinding bind(View view) {
        int i = R.id.et_id;
        EditText editText = (EditText) e.p(view, i);
        if (editText != null) {
            i = R.id.et_security;
            EditText editText2 = (EditText) e.p(view, i);
            if (editText2 != null) {
                i = R.id.sp_flow;
                Spinner spinner = (Spinner) e.p(view, i);
                if (spinner != null) {
                    return new ActivityServerVlessBinding((ScrollView) view, editText, editText2, spinner);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityServerVlessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityServerVlessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_server_vless, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
