package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutTlsHysteria2Binding {
    public final EditText etPinsha256;
    public final EditText etSni;
    public final LinearLayout layAllowInsecure;
    public final LinearLayout laySni;
    public final LinearLayout layStreamSecurity;
    private final LinearLayout rootView;
    public final Spinner spAllowInsecure;
    public final Spinner spStreamSecurity;

    private LayoutTlsHysteria2Binding(LinearLayout linearLayout, EditText editText, EditText editText2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, Spinner spinner, Spinner spinner2) {
        this.rootView = linearLayout;
        this.etPinsha256 = editText;
        this.etSni = editText2;
        this.layAllowInsecure = linearLayout2;
        this.laySni = linearLayout3;
        this.layStreamSecurity = linearLayout4;
        this.spAllowInsecure = spinner;
        this.spStreamSecurity = spinner2;
    }

    public static LayoutTlsHysteria2Binding bind(View view) {
        int i = R.id.et_pinsha256;
        EditText editText = (EditText) e.p(view, i);
        if (editText != null) {
            i = R.id.et_sni;
            EditText editText2 = (EditText) e.p(view, i);
            if (editText2 != null) {
                i = R.id.lay_allow_insecure;
                LinearLayout linearLayout = (LinearLayout) e.p(view, i);
                if (linearLayout != null) {
                    i = R.id.lay_sni;
                    LinearLayout linearLayout2 = (LinearLayout) e.p(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.lay_stream_security;
                        LinearLayout linearLayout3 = (LinearLayout) e.p(view, i);
                        if (linearLayout3 != null) {
                            i = R.id.sp_allow_insecure;
                            Spinner spinner = (Spinner) e.p(view, i);
                            if (spinner != null) {
                                i = R.id.sp_stream_security;
                                Spinner spinner2 = (Spinner) e.p(view, i);
                                if (spinner2 != null) {
                                    return new LayoutTlsHysteria2Binding((LinearLayout) view, editText, editText2, linearLayout, linearLayout2, linearLayout3, spinner, spinner2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutTlsHysteria2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutTlsHysteria2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_tls_hysteria2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
