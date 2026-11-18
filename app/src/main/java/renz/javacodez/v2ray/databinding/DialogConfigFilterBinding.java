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
public final class DialogConfigFilterBinding {
    public final EditText etKeyword;
    private final ScrollView rootView;
    public final Spinner spSubscriptionId;

    private DialogConfigFilterBinding(ScrollView scrollView, EditText editText, Spinner spinner) {
        this.rootView = scrollView;
        this.etKeyword = editText;
        this.spSubscriptionId = spinner;
    }

    public static DialogConfigFilterBinding bind(View view) {
        int i = R.id.et_keyword;
        EditText editText = (EditText) e.p(view, i);
        if (editText != null) {
            i = R.id.sp_subscriptionId;
            Spinner spinner = (Spinner) e.p(view, i);
            if (spinner != null) {
                return new DialogConfigFilterBinding((ScrollView) view, editText, spinner);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogConfigFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogConfigFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_config_filter, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
