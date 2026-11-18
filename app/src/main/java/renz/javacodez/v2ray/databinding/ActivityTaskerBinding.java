package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.widget.SwitchCompat;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityTaskerBinding {
    public final ListView listview;
    private final LinearLayout rootView;
    public final SwitchCompat switchStartService;

    private ActivityTaskerBinding(LinearLayout linearLayout, ListView listView, SwitchCompat switchCompat) {
        this.rootView = linearLayout;
        this.listview = listView;
        this.switchStartService = switchCompat;
    }

    public static ActivityTaskerBinding bind(View view) {
        int i = R.id.listview;
        ListView listView = (ListView) e.p(view, i);
        if (listView != null) {
            i = R.id.switch_start_service;
            SwitchCompat switchCompat = (SwitchCompat) e.p(view, i);
            if (switchCompat != null) {
                return new ActivityTaskerBinding((LinearLayout) view, listView, switchCompat);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityTaskerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityTaskerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_tasker, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
