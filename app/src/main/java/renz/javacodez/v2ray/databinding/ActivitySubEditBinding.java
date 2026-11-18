package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.appcompat.widget.SwitchCompat;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivitySubEditBinding {
    public final SwitchCompat autoUpdateCheck;
    public final SwitchCompat chkEnable;
    public final EditText etFilter;
    public final EditText etNextProfile;
    public final EditText etPreProfile;
    public final EditText etRemarks;
    public final EditText etUrl;
    private final ScrollView rootView;

    private ActivitySubEditBinding(ScrollView scrollView, SwitchCompat switchCompat, SwitchCompat switchCompat2, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5) {
        this.rootView = scrollView;
        this.autoUpdateCheck = switchCompat;
        this.chkEnable = switchCompat2;
        this.etFilter = editText;
        this.etNextProfile = editText2;
        this.etPreProfile = editText3;
        this.etRemarks = editText4;
        this.etUrl = editText5;
    }

    public static ActivitySubEditBinding bind(View view) {
        int i = R.id.auto_update_check;
        SwitchCompat switchCompat = (SwitchCompat) e.p(view, i);
        if (switchCompat != null) {
            i = R.id.chk_enable;
            SwitchCompat switchCompat2 = (SwitchCompat) e.p(view, i);
            if (switchCompat2 != null) {
                i = R.id.et_filter;
                EditText editText = (EditText) e.p(view, i);
                if (editText != null) {
                    i = R.id.et_next_profile;
                    EditText editText2 = (EditText) e.p(view, i);
                    if (editText2 != null) {
                        i = R.id.et_pre_profile;
                        EditText editText3 = (EditText) e.p(view, i);
                        if (editText3 != null) {
                            i = R.id.et_remarks;
                            EditText editText4 = (EditText) e.p(view, i);
                            if (editText4 != null) {
                                i = R.id.et_url;
                                EditText editText5 = (EditText) e.p(view, i);
                                if (editText5 != null) {
                                    return new ActivitySubEditBinding((ScrollView) view, switchCompat, switchCompat2, editText, editText2, editText3, editText4, editText5);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivitySubEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySubEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_sub_edit, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
