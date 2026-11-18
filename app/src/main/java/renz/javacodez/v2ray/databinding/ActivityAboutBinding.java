package renz.javacodez.v2ray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import defpackage.e;
import renz.javacodez.v2ray.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityAboutBinding {
    public final LinearLayout layoutBackup;
    public final LinearLayout layoutFeedback;
    public final LinearLayout layoutOssLicenses;
    public final LinearLayout layoutPrivacyPolicy;
    public final LinearLayout layoutRestore;
    public final LinearLayout layoutShare;
    public final LinearLayout layoutSoureCcode;
    public final LinearLayout layoutTgChannel;
    private final ScrollView rootView;
    public final TextView tvBackupSummary;
    public final TextView tvVersion;

    private ActivityAboutBinding(ScrollView scrollView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.layoutBackup = linearLayout;
        this.layoutFeedback = linearLayout2;
        this.layoutOssLicenses = linearLayout3;
        this.layoutPrivacyPolicy = linearLayout4;
        this.layoutRestore = linearLayout5;
        this.layoutShare = linearLayout6;
        this.layoutSoureCcode = linearLayout7;
        this.layoutTgChannel = linearLayout8;
        this.tvBackupSummary = textView;
        this.tvVersion = textView2;
    }

    public static ActivityAboutBinding bind(View view) {
        int i = R.id.layout_backup;
        LinearLayout linearLayout = (LinearLayout) e.p(view, i);
        if (linearLayout != null) {
            i = R.id.layout_feedback;
            LinearLayout linearLayout2 = (LinearLayout) e.p(view, i);
            if (linearLayout2 != null) {
                i = R.id.layout_oss_licenses;
                LinearLayout linearLayout3 = (LinearLayout) e.p(view, i);
                if (linearLayout3 != null) {
                    i = R.id.layout_privacy_policy;
                    LinearLayout linearLayout4 = (LinearLayout) e.p(view, i);
                    if (linearLayout4 != null) {
                        i = R.id.layout_restore;
                        LinearLayout linearLayout5 = (LinearLayout) e.p(view, i);
                        if (linearLayout5 != null) {
                            i = R.id.layout_share;
                            LinearLayout linearLayout6 = (LinearLayout) e.p(view, i);
                            if (linearLayout6 != null) {
                                i = R.id.layout_soure_ccode;
                                LinearLayout linearLayout7 = (LinearLayout) e.p(view, i);
                                if (linearLayout7 != null) {
                                    i = R.id.layout_tg_channel;
                                    LinearLayout linearLayout8 = (LinearLayout) e.p(view, i);
                                    if (linearLayout8 != null) {
                                        i = R.id.tv_backup_summary;
                                        TextView textView = (TextView) e.p(view, i);
                                        if (textView != null) {
                                            i = R.id.tv_version;
                                            TextView textView2 = (TextView) e.p(view, i);
                                            if (textView2 != null) {
                                                return new ActivityAboutBinding((ScrollView) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, textView, textView2);
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

    public static ActivityAboutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_about, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public ScrollView getRoot() {
        return this.rootView;
    }
}
