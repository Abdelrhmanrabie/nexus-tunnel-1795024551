package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutAddressPortBinding {
    public final EditText etAddress;
    public final EditText etPort;
    public final EditText etRemarks;
    private final LinearLayout rootView;

    private LayoutAddressPortBinding(LinearLayout linearLayout, EditText editText, EditText editText2, EditText editText3) {
        this.rootView = linearLayout;
        this.etAddress = editText;
        this.etPort = editText2;
        this.etRemarks = editText3;
    }

    public static LayoutAddressPortBinding bind(View view) {
        int i = R.id.et_address;
        EditText editText = (EditText) e.p(view, i);
        if (editText != null) {
            i = R.id.et_port;
            EditText editText2 = (EditText) e.p(view, i);
            if (editText2 != null) {
                i = R.id.et_remarks;
                EditText editText3 = (EditText) e.p(view, i);
                if (editText3 != null) {
                    return new LayoutAddressPortBinding((LinearLayout) view, editText, editText2, editText3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutAddressPortBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutAddressPortBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_address_port, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
