package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutTransportBinding {
    public final EditText etExtra;
    public final EditText etPath;
    public final EditText etRequestHost;
    public final LinearLayout layoutExtra;
    private final LinearLayout rootView;
    public final Spinner spHeaderType;
    public final TextView spHeaderTypeTitle;
    public final Spinner spNetwork;
    public final TextView tvPath;
    public final TextView tvRequestHost;

    private LayoutTransportBinding(LinearLayout linearLayout, EditText editText, EditText editText2, EditText editText3, LinearLayout linearLayout2, Spinner spinner, TextView textView, Spinner spinner2, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.etExtra = editText;
        this.etPath = editText2;
        this.etRequestHost = editText3;
        this.layoutExtra = linearLayout2;
        this.spHeaderType = spinner;
        this.spHeaderTypeTitle = textView;
        this.spNetwork = spinner2;
        this.tvPath = textView2;
        this.tvRequestHost = textView3;
    }

    public static LayoutTransportBinding bind(View view) {
        int i = R.id.et_extra;
        EditText editText = (EditText) e.p(view, i);
        if (editText != null) {
            i = R.id.et_path;
            EditText editText2 = (EditText) e.p(view, i);
            if (editText2 != null) {
                i = R.id.et_request_host;
                EditText editText3 = (EditText) e.p(view, i);
                if (editText3 != null) {
                    i = R.id.layout_extra;
                    LinearLayout linearLayout = (LinearLayout) e.p(view, i);
                    if (linearLayout != null) {
                        i = R.id.sp_header_type;
                        Spinner spinner = (Spinner) e.p(view, i);
                        if (spinner != null) {
                            i = R.id.sp_header_type_title;
                            TextView textView = (TextView) e.p(view, i);
                            if (textView != null) {
                                i = R.id.sp_network;
                                Spinner spinner2 = (Spinner) e.p(view, i);
                                if (spinner2 != null) {
                                    i = R.id.tv_path;
                                    TextView textView2 = (TextView) e.p(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tv_request_host;
                                        TextView textView3 = (TextView) e.p(view, i);
                                        if (textView3 != null) {
                                            return new LayoutTransportBinding((LinearLayout) view, editText, editText2, editText3, linearLayout, spinner, textView, spinner2, textView2, textView3);
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

    public static LayoutTransportBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutTransportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_transport, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
