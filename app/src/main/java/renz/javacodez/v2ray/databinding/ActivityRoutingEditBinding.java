package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.appcompat.widget.SwitchCompat;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityRoutingEditBinding {
    public final SwitchCompat chkLocked;
    public final EditText etDomain;
    public final EditText etIp;
    public final EditText etNetwork;
    public final EditText etPort;
    public final EditText etProtocol;
    public final EditText etRemarks;
    private final ScrollView rootView;
    public final Spinner spOutboundTag;

    private ActivityRoutingEditBinding(ScrollView scrollView, SwitchCompat switchCompat, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, Spinner spinner) {
        this.rootView = scrollView;
        this.chkLocked = switchCompat;
        this.etDomain = editText;
        this.etIp = editText2;
        this.etNetwork = editText3;
        this.etPort = editText4;
        this.etProtocol = editText5;
        this.etRemarks = editText6;
        this.spOutboundTag = spinner;
    }

    public static ActivityRoutingEditBinding bind(View view) {
        int i = R.id.chk_locked;
        SwitchCompat switchCompat = (SwitchCompat) e.p(view, i);
        if (switchCompat != null) {
            i = R.id.et_domain;
            EditText editText = (EditText) e.p(view, i);
            if (editText != null) {
                i = R.id.et_ip;
                EditText editText2 = (EditText) e.p(view, i);
                if (editText2 != null) {
                    i = R.id.et_network;
                    EditText editText3 = (EditText) e.p(view, i);
                    if (editText3 != null) {
                        i = R.id.et_port;
                        EditText editText4 = (EditText) e.p(view, i);
                        if (editText4 != null) {
                            i = R.id.et_protocol;
                            EditText editText5 = (EditText) e.p(view, i);
                            if (editText5 != null) {
                                i = R.id.et_remarks;
                                EditText editText6 = (EditText) e.p(view, i);
                                if (editText6 != null) {
                                    i = R.id.sp_outbound_tag;
                                    Spinner spinner = (Spinner) e.p(view, i);
                                    if (spinner != null) {
                                        return new ActivityRoutingEditBinding((ScrollView) view, switchCompat, editText, editText2, editText3, editText4, editText5, editText6, spinner);
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

    public static ActivityRoutingEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRoutingEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_routing_edit, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
