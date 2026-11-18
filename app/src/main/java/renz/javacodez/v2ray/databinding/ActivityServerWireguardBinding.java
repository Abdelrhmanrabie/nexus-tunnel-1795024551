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
public final class ActivityServerWireguardBinding {
    public final EditText etId;
    public final EditText etLocalAddress;
    public final EditText etLocalMtu;
    public final EditText etPresharedKey;
    public final EditText etPublicKey;
    public final EditText etReserved1;
    private final ScrollView rootView;

    private ActivityServerWireguardBinding(ScrollView scrollView, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6) {
        this.rootView = scrollView;
        this.etId = editText;
        this.etLocalAddress = editText2;
        this.etLocalMtu = editText3;
        this.etPresharedKey = editText4;
        this.etPublicKey = editText5;
        this.etReserved1 = editText6;
    }

    public static ActivityServerWireguardBinding bind(View view) {
        int i = R.id.et_id;
        EditText editText = (EditText) e.p(view, i);
        if (editText != null) {
            i = R.id.et_local_address;
            EditText editText2 = (EditText) e.p(view, i);
            if (editText2 != null) {
                i = R.id.et_local_mtu;
                EditText editText3 = (EditText) e.p(view, i);
                if (editText3 != null) {
                    i = R.id.et_preshared_key;
                    EditText editText4 = (EditText) e.p(view, i);
                    if (editText4 != null) {
                        i = R.id.et_public_key;
                        EditText editText5 = (EditText) e.p(view, i);
                        if (editText5 != null) {
                            i = R.id.et_reserved1;
                            EditText editText6 = (EditText) e.p(view, i);
                            if (editText6 != null) {
                                return new ActivityServerWireguardBinding((ScrollView) view, editText, editText2, editText3, editText4, editText5, editText6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityServerWireguardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityServerWireguardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_server_wireguard, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
