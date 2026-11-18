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
public final class LayoutTlsBinding {
    public final EditText etPublicKey;
    public final EditText etShortId;
    public final EditText etSni;
    public final EditText etSpiderX;
    public final LinearLayout layAllowInsecure;
    public final LinearLayout layPublicKey;
    public final LinearLayout layShortId;
    public final LinearLayout laySni;
    public final LinearLayout laySpiderX;
    public final LinearLayout layStreamAlpn;
    public final LinearLayout layStreamFingerprint;
    public final LinearLayout layStreamSecurity;
    private final LinearLayout rootView;
    public final Spinner spAllowInsecure;
    public final Spinner spStreamAlpn;
    public final Spinner spStreamFingerprint;
    public final Spinner spStreamSecurity;

    private LayoutTlsBinding(LinearLayout linearLayout, EditText editText, EditText editText2, EditText editText3, EditText editText4, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, Spinner spinner, Spinner spinner2, Spinner spinner3, Spinner spinner4) {
        this.rootView = linearLayout;
        this.etPublicKey = editText;
        this.etShortId = editText2;
        this.etSni = editText3;
        this.etSpiderX = editText4;
        this.layAllowInsecure = linearLayout2;
        this.layPublicKey = linearLayout3;
        this.layShortId = linearLayout4;
        this.laySni = linearLayout5;
        this.laySpiderX = linearLayout6;
        this.layStreamAlpn = linearLayout7;
        this.layStreamFingerprint = linearLayout8;
        this.layStreamSecurity = linearLayout9;
        this.spAllowInsecure = spinner;
        this.spStreamAlpn = spinner2;
        this.spStreamFingerprint = spinner3;
        this.spStreamSecurity = spinner4;
    }

    public static LayoutTlsBinding bind(View view) {
        int i = R.id.et_public_key;
        EditText editText = (EditText) e.p(view, i);
        if (editText != null) {
            i = R.id.et_short_id;
            EditText editText2 = (EditText) e.p(view, i);
            if (editText2 != null) {
                i = R.id.et_sni;
                EditText editText3 = (EditText) e.p(view, i);
                if (editText3 != null) {
                    i = R.id.et_spider_x;
                    EditText editText4 = (EditText) e.p(view, i);
                    if (editText4 != null) {
                        i = R.id.lay_allow_insecure;
                        LinearLayout linearLayout = (LinearLayout) e.p(view, i);
                        if (linearLayout != null) {
                            i = R.id.lay_public_key;
                            LinearLayout linearLayout2 = (LinearLayout) e.p(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.lay_short_id;
                                LinearLayout linearLayout3 = (LinearLayout) e.p(view, i);
                                if (linearLayout3 != null) {
                                    i = R.id.lay_sni;
                                    LinearLayout linearLayout4 = (LinearLayout) e.p(view, i);
                                    if (linearLayout4 != null) {
                                        i = R.id.lay_spider_x;
                                        LinearLayout linearLayout5 = (LinearLayout) e.p(view, i);
                                        if (linearLayout5 != null) {
                                            i = R.id.lay_stream_alpn;
                                            LinearLayout linearLayout6 = (LinearLayout) e.p(view, i);
                                            if (linearLayout6 != null) {
                                                i = R.id.lay_stream_fingerprint;
                                                LinearLayout linearLayout7 = (LinearLayout) e.p(view, i);
                                                if (linearLayout7 != null) {
                                                    i = R.id.lay_stream_security;
                                                    LinearLayout linearLayout8 = (LinearLayout) e.p(view, i);
                                                    if (linearLayout8 != null) {
                                                        i = R.id.sp_allow_insecure;
                                                        Spinner spinner = (Spinner) e.p(view, i);
                                                        if (spinner != null) {
                                                            i = R.id.sp_stream_alpn;
                                                            Spinner spinner2 = (Spinner) e.p(view, i);
                                                            if (spinner2 != null) {
                                                                i = R.id.sp_stream_fingerprint;
                                                                Spinner spinner3 = (Spinner) e.p(view, i);
                                                                if (spinner3 != null) {
                                                                    i = R.id.sp_stream_security;
                                                                    Spinner spinner4 = (Spinner) e.p(view, i);
                                                                    if (spinner4 != null) {
                                                                        return new LayoutTlsBinding((LinearLayout) view, editText, editText2, editText3, editText4, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, spinner, spinner2, spinner3, spinner4);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LayoutTlsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutTlsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_tls, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
