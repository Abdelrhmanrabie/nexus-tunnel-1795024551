package renz.javacodez.v2ray.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.r;
import androidx.preference.CheckBoxPreference;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.b;
import defpackage.e4;
import defpackage.k7;
import defpackage.lw;
import defpackage.ou0;
import defpackage.q31;
import defpackage.rc0;
import defpackage.v41;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import renz.javacodez.v2ray.AppConfig;
import renz.javacodez.v2ray.R;
import renz.javacodez.v2ray.handler.MmkvManager;
import renz.javacodez.v2ray.ui.SettingsActivity;
import renz.javacodez.v2ray.util.Utils;
import renz.javacodez.v2ray.viewmodel.SettingsViewModel;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsActivity extends BaseActivity {
    private final rc0 settingsViewModel$delegate = new r(ou0.a.b(SettingsViewModel.class), new SettingsActivity$special$$inlined$viewModels$default$2(this), new SettingsActivity$special$$inlined$viewModels$default$1(this), new SettingsActivity$special$$inlined$viewModels$default$3(null, this));

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class SettingsFragment extends b {
        private final rc0 appendHttpProxy$delegate;
        private final rc0 autoUpdateCheck$delegate;
        private final rc0 autoUpdateInterval$delegate;
        private final rc0 delayTestUrl$delegate;
        private final rc0 domesticDns$delegate;
        private final rc0 fakeDns$delegate;
        private final rc0 fragment$delegate;
        private final rc0 fragmentInterval$delegate;
        private final rc0 fragmentLength$delegate;
        private final rc0 fragmentPackets$delegate;
        private final rc0 localDns$delegate;
        private final rc0 localDnsPort$delegate;
        private final rc0 mode$delegate;
        private final rc0 mux$delegate;
        private final rc0 muxConcurrency$delegate;
        private final rc0 muxXudpConcurrency$delegate;
        private final rc0 muxXudpQuic$delegate;
        private final rc0 perAppProxy$delegate;
        private final rc0 remoteDns$delegate;
        private final rc0 socksPort$delegate;
        private final rc0 vpnDns$delegate;

        public SettingsFragment() {
            final int i = 0;
            this.perAppProxy$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i2 = i;
                    int i3 = i;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i2 == 0) {
                        if (i3 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i3 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i3 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i3 != 3) {
                            return i3 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i2 != 1) {
                        if (i3 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i3 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i3 != 2) {
                            return i3 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i3 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i3 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i3 != 2) {
                        return i3 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            final int i2 = 2;
            this.localDns$delegate = new v41(new k7(this, i2, i2));
            final int i3 = 3;
            final int i4 = 1;
            this.fakeDns$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i5 = i4;
                    int i6 = i3;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i5 == 0) {
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i6 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i6 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i6 != 3) {
                            return i6 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i5 != 1) {
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i6 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i6 != 2) {
                            return i6 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i6 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i6 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i6 != 2) {
                        return i6 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.appendHttpProxy$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i5 = i2;
                    int i6 = i3;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i5 == 0) {
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i6 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i6 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i6 != 3) {
                            return i6 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i5 != 1) {
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i6 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i6 != 2) {
                            return i6 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i6 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i6 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i6 != 2) {
                        return i6 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.localDnsPort$delegate = new v41(new k7(this, i3, i2));
            final int i5 = 4;
            this.vpnDns$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i6 = i;
                    int i7 = i5;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i6 == 0) {
                        if (i7 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i7 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i7 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i7 != 3) {
                            return i7 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i6 != 1) {
                        if (i7 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i7 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i7 != 2) {
                            return i7 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i7 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i7 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i7 != 2) {
                        return i7 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.mux$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i6 = i4;
                    int i7 = i5;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i6 == 0) {
                        if (i7 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i7 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i7 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i7 != 3) {
                            return i7 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i6 != 1) {
                        if (i7 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i7 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i7 != 2) {
                            return i7 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i7 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i7 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i7 != 2) {
                        return i7 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.muxConcurrency$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i6 = i2;
                    int i7 = i5;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i6 == 0) {
                        if (i7 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i7 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i7 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i7 != 3) {
                            return i7 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i6 != 1) {
                        if (i7 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i7 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i7 != 2) {
                            return i7 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i7 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i7 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i7 != 2) {
                        return i7 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.muxXudpConcurrency$delegate = new v41(new k7(this, i5, i2));
            final int i6 = 5;
            this.muxXudpQuic$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i7 = i;
                    int i8 = i6;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i7 == 0) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i8 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i8 != 3) {
                            return i8 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i7 != 1) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i8 != 2) {
                            return i8 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i8 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i8 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i8 != 2) {
                        return i8 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.fragment$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i7 = i4;
                    int i8 = i;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i7 == 0) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i8 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i8 != 3) {
                            return i8 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i7 != 1) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i8 != 2) {
                            return i8 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i8 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i8 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i8 != 2) {
                        return i8 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.fragmentPackets$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i7 = i2;
                    int i8 = i;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i7 == 0) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i8 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i8 != 3) {
                            return i8 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i7 != 1) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i8 != 2) {
                            return i8 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i8 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i8 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i8 != 2) {
                        return i8 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.fragmentLength$delegate = new v41(new k7(this, i, i2));
            this.fragmentInterval$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i7 = i;
                    int i8 = i4;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i7 == 0) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i8 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i8 != 3) {
                            return i8 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i7 != 1) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i8 != 2) {
                            return i8 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i8 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i8 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i8 != 2) {
                        return i8 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.autoUpdateCheck$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i7 = i4;
                    int i8 = i4;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i7 == 0) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i8 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i8 != 3) {
                            return i8 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i7 != 1) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i8 != 2) {
                            return i8 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i8 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i8 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i8 != 2) {
                        return i8 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.autoUpdateInterval$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i7 = i2;
                    int i8 = i4;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i7 == 0) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i8 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i8 != 3) {
                            return i8 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i7 != 1) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i8 != 2) {
                            return i8 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i8 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i8 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i8 != 2) {
                        return i8 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.socksPort$delegate = new v41(new k7(this, i4, i2));
            this.remoteDns$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i7 = i;
                    int i8 = i2;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i7 == 0) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i8 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i8 != 3) {
                            return i8 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i7 != 1) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i8 != 2) {
                            return i8 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i8 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i8 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i8 != 2) {
                        return i8 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.domesticDns$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i7 = i4;
                    int i8 = i2;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i7 == 0) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i8 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i8 != 3) {
                            return i8 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i7 != 1) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i8 != 2) {
                            return i8 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i8 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i8 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i8 != 2) {
                        return i8 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.delayTestUrl$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i7 = i2;
                    int i8 = i2;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i7 == 0) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i8 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i8 != 3) {
                            return i8 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i7 != 1) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i8 != 2) {
                            return i8 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i8 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i8 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i8 != 2) {
                        return i8 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
            this.mode$delegate = new v41(new lw(this) { // from class: tz0
                public final /* synthetic */ SettingsActivity.SettingsFragment c;

                {
                    this.c = this;
                }

                @Override // defpackage.lw
                public final Object invoke() {
                    int i7 = i;
                    int i8 = i3;
                    SettingsActivity.SettingsFragment settingsFragment = this.c;
                    if (i7 == 0) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.perAppProxy_delegate$lambda$0(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.fragmentInterval_delegate$lambda$13(settingsFragment);
                        }
                        if (i8 == 2) {
                            return SettingsActivity.SettingsFragment.remoteDns_delegate$lambda$17(settingsFragment);
                        }
                        if (i8 != 3) {
                            return i8 != 4 ? SettingsActivity.SettingsFragment.muxXudpQuic_delegate$lambda$9(settingsFragment) : SettingsActivity.SettingsFragment.vpnDns_delegate$lambda$5(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.mode_delegate$lambda$20(settingsFragment);
                    }
                    if (i7 != 1) {
                        if (i8 == 0) {
                            return SettingsActivity.SettingsFragment.fragmentPackets_delegate$lambda$11(settingsFragment);
                        }
                        if (i8 == 1) {
                            return SettingsActivity.SettingsFragment.autoUpdateInterval_delegate$lambda$15(settingsFragment);
                        }
                        if (i8 != 2) {
                            return i8 != 3 ? SettingsActivity.SettingsFragment.muxConcurrency_delegate$lambda$7(settingsFragment) : SettingsActivity.SettingsFragment.appendHttpProxy_delegate$lambda$3(settingsFragment);
                        }
                        return SettingsActivity.SettingsFragment.delayTestUrl_delegate$lambda$19(settingsFragment);
                    }
                    if (i8 == 0) {
                        return SettingsActivity.SettingsFragment.fragment_delegate$lambda$10(settingsFragment);
                    }
                    if (i8 == 1) {
                        return SettingsActivity.SettingsFragment.autoUpdateCheck_delegate$lambda$14(settingsFragment);
                    }
                    if (i8 != 2) {
                        return i8 != 3 ? SettingsActivity.SettingsFragment.mux_delegate$lambda$6(settingsFragment) : SettingsActivity.SettingsFragment.fakeDns_delegate$lambda$2(settingsFragment);
                    }
                    return SettingsActivity.SettingsFragment.domesticDns_delegate$lambda$18(settingsFragment);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CheckBoxPreference appendHttpProxy_delegate$lambda$3(SettingsFragment settingsFragment) {
            return (CheckBoxPreference) settingsFragment.findPreference(AppConfig.PREF_APPEND_HTTP_PROXY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CheckBoxPreference autoUpdateCheck_delegate$lambda$14(SettingsFragment settingsFragment) {
            return (CheckBoxPreference) settingsFragment.findPreference(AppConfig.SUBSCRIPTION_AUTO_UPDATE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditTextPreference autoUpdateInterval_delegate$lambda$15(SettingsFragment settingsFragment) {
            return (EditTextPreference) settingsFragment.findPreference(AppConfig.SUBSCRIPTION_AUTO_UPDATE_INTERVAL);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditTextPreference delayTestUrl_delegate$lambda$19(SettingsFragment settingsFragment) {
            return (EditTextPreference) settingsFragment.findPreference(AppConfig.PREF_DELAY_TEST_URL);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditTextPreference domesticDns_delegate$lambda$18(SettingsFragment settingsFragment) {
            return (EditTextPreference) settingsFragment.findPreference(AppConfig.PREF_DOMESTIC_DNS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CheckBoxPreference fakeDns_delegate$lambda$2(SettingsFragment settingsFragment) {
            return (CheckBoxPreference) settingsFragment.findPreference(AppConfig.PREF_FAKE_DNS_ENABLED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditTextPreference fragmentInterval_delegate$lambda$13(SettingsFragment settingsFragment) {
            return (EditTextPreference) settingsFragment.findPreference(AppConfig.PREF_FRAGMENT_INTERVAL);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditTextPreference fragmentLength_delegate$lambda$12(SettingsFragment settingsFragment) {
            return (EditTextPreference) settingsFragment.findPreference(AppConfig.PREF_FRAGMENT_LENGTH);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ListPreference fragmentPackets_delegate$lambda$11(SettingsFragment settingsFragment) {
            return (ListPreference) settingsFragment.findPreference(AppConfig.PREF_FRAGMENT_PACKETS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CheckBoxPreference fragment_delegate$lambda$10(SettingsFragment settingsFragment) {
            return (CheckBoxPreference) settingsFragment.findPreference(AppConfig.PREF_FRAGMENT_ENABLED);
        }

        private final CheckBoxPreference getAppendHttpProxy() {
            return (CheckBoxPreference) this.appendHttpProxy$delegate.getValue();
        }

        private final CheckBoxPreference getAutoUpdateCheck() {
            return (CheckBoxPreference) this.autoUpdateCheck$delegate.getValue();
        }

        private final EditTextPreference getAutoUpdateInterval() {
            return (EditTextPreference) this.autoUpdateInterval$delegate.getValue();
        }

        private final EditTextPreference getDelayTestUrl() {
            return (EditTextPreference) this.delayTestUrl$delegate.getValue();
        }

        private final EditTextPreference getDomesticDns() {
            return (EditTextPreference) this.domesticDns$delegate.getValue();
        }

        private final CheckBoxPreference getFakeDns() {
            return (CheckBoxPreference) this.fakeDns$delegate.getValue();
        }

        private final CheckBoxPreference getFragment() {
            return (CheckBoxPreference) this.fragment$delegate.getValue();
        }

        private final EditTextPreference getFragmentInterval() {
            return (EditTextPreference) this.fragmentInterval$delegate.getValue();
        }

        private final EditTextPreference getFragmentLength() {
            return (EditTextPreference) this.fragmentLength$delegate.getValue();
        }

        private final ListPreference getFragmentPackets() {
            return (ListPreference) this.fragmentPackets$delegate.getValue();
        }

        private final CheckBoxPreference getLocalDns() {
            return (CheckBoxPreference) this.localDns$delegate.getValue();
        }

        private final EditTextPreference getLocalDnsPort() {
            return (EditTextPreference) this.localDnsPort$delegate.getValue();
        }

        private final ListPreference getMode() {
            return (ListPreference) this.mode$delegate.getValue();
        }

        private final CheckBoxPreference getMux() {
            return (CheckBoxPreference) this.mux$delegate.getValue();
        }

        private final EditTextPreference getMuxConcurrency() {
            return (EditTextPreference) this.muxConcurrency$delegate.getValue();
        }

        private final EditTextPreference getMuxXudpConcurrency() {
            return (EditTextPreference) this.muxXudpConcurrency$delegate.getValue();
        }

        private final ListPreference getMuxXudpQuic() {
            return (ListPreference) this.muxXudpQuic$delegate.getValue();
        }

        private final CheckBoxPreference getPerAppProxy() {
            return (CheckBoxPreference) this.perAppProxy$delegate.getValue();
        }

        private final EditTextPreference getRemoteDns() {
            return (EditTextPreference) this.remoteDns$delegate.getValue();
        }

        private final EditTextPreference getSocksPort() {
            return (EditTextPreference) this.socksPort$delegate.getValue();
        }

        private final EditTextPreference getVpnDns() {
            return (EditTextPreference) this.vpnDns$delegate.getValue();
        }

        private final void initSharedPreference() {
            ListPreference listPreference;
            for (EditTextPreference editTextPreference : Arrays.asList(getLocalDnsPort(), getVpnDns(), getMuxConcurrency(), getMuxXudpConcurrency(), getFragmentLength(), getFragmentInterval(), getAutoUpdateInterval(), getSocksPort(), getRemoteDns(), getDomesticDns(), getDelayTestUrl())) {
                if (editTextPreference != null) {
                    editTextPreference.A(String.valueOf(editTextPreference.g()));
                }
            }
            for (String str : Collections.singletonList(AppConfig.PREF_SNIFFING_ENABLED)) {
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference(str);
                if (checkBoxPreference != null) {
                    checkBoxPreference.A(MmkvManager.INSTANCE.decodeSettingsBool(str, true));
                }
            }
            for (String str2 : Arrays.asList(AppConfig.PREF_ROUTE_ONLY_ENABLED, AppConfig.PREF_IS_BOOTED, AppConfig.PREF_BYPASS_APPS, AppConfig.PREF_SPEED_ENABLED, AppConfig.PREF_CONFIRM_REMOVE, AppConfig.PREF_START_SCAN_IMMEDIATE, AppConfig.PREF_PREFER_IPV6, AppConfig.PREF_PROXY_SHARING, AppConfig.PREF_ALLOW_INSECURE)) {
                CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference(str2);
                if (checkBoxPreference2 != null) {
                    checkBoxPreference2.A(MmkvManager.INSTANCE.decodeSettingsBool(str2, false));
                }
            }
            for (String str3 : Arrays.asList(AppConfig.PREF_ROUTING_DOMAIN_STRATEGY, AppConfig.PREF_MUX_XUDP_QUIC, AppConfig.PREF_FRAGMENT_PACKETS, AppConfig.PREF_LANGUAGE, AppConfig.PREF_UI_MODE_NIGHT, AppConfig.PREF_LOGLEVEL, AppConfig.PREF_MODE)) {
                MmkvManager mmkvManager = MmkvManager.INSTANCE;
                if (mmkvManager.decodeSettingsString(str3) != null && (listPreference = (ListPreference) findPreference(str3)) != null) {
                    listPreference.C(mmkvManager.decodeSettingsString(str3));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditTextPreference localDnsPort_delegate$lambda$4(SettingsFragment settingsFragment) {
            return (EditTextPreference) settingsFragment.findPreference(AppConfig.PREF_LOCAL_DNS_PORT);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CheckBoxPreference localDns_delegate$lambda$1(SettingsFragment settingsFragment) {
            return (CheckBoxPreference) settingsFragment.findPreference(AppConfig.PREF_LOCAL_DNS_ENABLED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ListPreference mode_delegate$lambda$20(SettingsFragment settingsFragment) {
            return (ListPreference) settingsFragment.findPreference(AppConfig.PREF_MODE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditTextPreference muxConcurrency_delegate$lambda$7(SettingsFragment settingsFragment) {
            return (EditTextPreference) settingsFragment.findPreference(AppConfig.PREF_MUX_CONCURRENCY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditTextPreference muxXudpConcurrency_delegate$lambda$8(SettingsFragment settingsFragment) {
            return (EditTextPreference) settingsFragment.findPreference(AppConfig.PREF_MUX_XUDP_CONCURRENCY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ListPreference muxXudpQuic_delegate$lambda$9(SettingsFragment settingsFragment) {
            return (ListPreference) settingsFragment.findPreference(AppConfig.PREF_MUX_XUDP_QUIC);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CheckBoxPreference mux_delegate$lambda$6(SettingsFragment settingsFragment) {
            return (CheckBoxPreference) settingsFragment.findPreference(AppConfig.PREF_MUX_ENABLED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$21(SettingsFragment settingsFragment, Preference preference, Object obj) {
            settingsFragment.updateLocalDns(((Boolean) obj).booleanValue());
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$22(SettingsFragment settingsFragment, Preference preference, Object obj) {
            String str = (String) obj;
            EditTextPreference localDnsPort = settingsFragment.getLocalDnsPort();
            if (localDnsPort == null) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                str = AppConfig.PORT_LOCAL_DNS;
            }
            localDnsPort.x(str);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$23(SettingsFragment settingsFragment, Preference preference, Object obj) {
            EditTextPreference vpnDns = settingsFragment.getVpnDns();
            if (vpnDns == null) {
                return true;
            }
            vpnDns.x((String) obj);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$24(SettingsFragment settingsFragment, Preference preference, Object obj) {
            settingsFragment.updateMux(((Boolean) obj).booleanValue());
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$25(SettingsFragment settingsFragment, Preference preference, Object obj) {
            settingsFragment.updateMuxConcurrency((String) obj);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$26(SettingsFragment settingsFragment, Preference preference, Object obj) {
            settingsFragment.updateMuxXudpConcurrency((String) obj);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$27(SettingsFragment settingsFragment, Preference preference, Object obj) {
            settingsFragment.updateFragment(((Boolean) obj).booleanValue());
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$28(SettingsFragment settingsFragment, Preference preference, Object obj) {
            settingsFragment.updateFragmentPackets((String) obj);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$29(SettingsFragment settingsFragment, Preference preference, Object obj) {
            settingsFragment.updateFragmentLength((String) obj);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$30(SettingsFragment settingsFragment, Preference preference, Object obj) {
            settingsFragment.updateFragmentInterval((String) obj);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$31(SettingsFragment settingsFragment, Preference preference, Object obj) {
            String str = (String) obj;
            EditTextPreference socksPort = settingsFragment.getSocksPort();
            if (socksPort == null) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                str = AppConfig.PORT_SOCKS;
            }
            socksPort.x(str);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$32(SettingsFragment settingsFragment, Preference preference, Object obj) {
            String str = (String) obj;
            EditTextPreference remoteDns = settingsFragment.getRemoteDns();
            if (remoteDns == null) {
                return true;
            }
            if (e4.a(str, AppConfig.CUSTOM)) {
                str = "1.1.1.1";
            }
            remoteDns.x(str);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$33(SettingsFragment settingsFragment, Preference preference, Object obj) {
            String str = (String) obj;
            EditTextPreference domesticDns = settingsFragment.getDomesticDns();
            if (domesticDns == null) {
                return true;
            }
            if (e4.a(str, AppConfig.CUSTOM)) {
                str = AppConfig.DNS_DIRECT;
            }
            domesticDns.x(str);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$34(SettingsFragment settingsFragment, Preference preference, Object obj) {
            String str = (String) obj;
            EditTextPreference delayTestUrl = settingsFragment.getDelayTestUrl();
            if (delayTestUrl == null) {
                return true;
            }
            if (e4.a(str, AppConfig.CUSTOM)) {
                str = AppConfig.DelayTestUrl;
            }
            delayTestUrl.x(str);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onCreatePreferences$lambda$35(SettingsFragment settingsFragment, Preference preference, Object obj) {
            settingsFragment.updateMode(obj.toString());
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CheckBoxPreference perAppProxy_delegate$lambda$0(SettingsFragment settingsFragment) {
            return (CheckBoxPreference) settingsFragment.findPreference(AppConfig.PREF_PER_APP_PROXY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditTextPreference remoteDns_delegate$lambda$17(SettingsFragment settingsFragment) {
            return (EditTextPreference) settingsFragment.findPreference(AppConfig.PREF_REMOTE_DNS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditTextPreference socksPort_delegate$lambda$16(SettingsFragment settingsFragment) {
            return (EditTextPreference) settingsFragment.findPreference(AppConfig.PREF_SOCKS_PORT);
        }

        private final void updateFragment(boolean z) {
            ListPreference fragmentPackets = getFragmentPackets();
            if (fragmentPackets != null) {
                fragmentPackets.v(z);
            }
            EditTextPreference fragmentLength = getFragmentLength();
            if (fragmentLength != null) {
                fragmentLength.v(z);
            }
            EditTextPreference fragmentInterval = getFragmentInterval();
            if (fragmentInterval != null) {
                fragmentInterval.v(z);
            }
            if (z) {
                MmkvManager mmkvManager = MmkvManager.INSTANCE;
                updateFragmentPackets(mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_PACKETS, "tlshello"));
                updateFragmentLength(mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_LENGTH, "50-100"));
                updateFragmentInterval(mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_INTERVAL, "10-20"));
            }
        }

        private final void updateFragmentInterval(String str) {
            EditTextPreference fragmentInterval = getFragmentInterval();
            if (fragmentInterval != null) {
                fragmentInterval.x(String.valueOf(str));
            }
        }

        private final void updateFragmentLength(String str) {
            EditTextPreference fragmentLength = getFragmentLength();
            if (fragmentLength != null) {
                fragmentLength.x(String.valueOf(str));
            }
        }

        private final void updateFragmentPackets(String str) {
            ListPreference fragmentPackets = getFragmentPackets();
            if (fragmentPackets != null) {
                fragmentPackets.x(String.valueOf(str));
            }
        }

        private final void updateLocalDns(boolean z) {
            CheckBoxPreference fakeDns = getFakeDns();
            if (fakeDns != null) {
                fakeDns.v(z);
            }
            EditTextPreference localDnsPort = getLocalDnsPort();
            if (localDnsPort != null) {
                localDnsPort.v(z);
            }
            EditTextPreference vpnDns = getVpnDns();
            if (vpnDns != null) {
                vpnDns.v(!z);
            }
        }

        private final void updateMode(String str) {
            boolean zA = e4.a(str, AppConfig.VPN);
            CheckBoxPreference perAppProxy = getPerAppProxy();
            if (perAppProxy != null) {
                perAppProxy.v(zA);
            }
            CheckBoxPreference perAppProxy2 = getPerAppProxy();
            if (perAppProxy2 != null) {
                perAppProxy2.A(MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_PER_APP_PROXY, false));
            }
            CheckBoxPreference localDns = getLocalDns();
            if (localDns != null) {
                localDns.v(zA);
            }
            CheckBoxPreference fakeDns = getFakeDns();
            if (fakeDns != null) {
                fakeDns.v(zA);
            }
            CheckBoxPreference appendHttpProxy = getAppendHttpProxy();
            if (appendHttpProxy != null) {
                appendHttpProxy.v(zA);
            }
            EditTextPreference localDnsPort = getLocalDnsPort();
            if (localDnsPort != null) {
                localDnsPort.v(zA);
            }
            EditTextPreference vpnDns = getVpnDns();
            if (vpnDns != null) {
                vpnDns.v(zA);
            }
            if (zA) {
                updateLocalDns(MmkvManager.INSTANCE.decodeSettingsBool(AppConfig.PREF_LOCAL_DNS_ENABLED, false));
            }
        }

        private final void updateMux(boolean z) {
            EditTextPreference muxConcurrency = getMuxConcurrency();
            if (muxConcurrency != null) {
                muxConcurrency.v(z);
            }
            EditTextPreference muxXudpConcurrency = getMuxXudpConcurrency();
            if (muxXudpConcurrency != null) {
                muxXudpConcurrency.v(z);
            }
            ListPreference muxXudpQuic = getMuxXudpQuic();
            if (muxXudpQuic != null) {
                muxXudpQuic.v(z);
            }
            if (z) {
                MmkvManager mmkvManager = MmkvManager.INSTANCE;
                updateMuxConcurrency(mmkvManager.decodeSettingsString(AppConfig.PREF_MUX_CONCURRENCY, "8"));
                updateMuxXudpConcurrency(mmkvManager.decodeSettingsString(AppConfig.PREF_MUX_XUDP_CONCURRENCY, "8"));
            }
        }

        private final void updateMuxConcurrency(String str) {
            Integer numU;
            int iIntValue = (str == null || (numU = q31.U(str)) == null) ? 8 : numU.intValue();
            EditTextPreference muxConcurrency = getMuxConcurrency();
            if (muxConcurrency != null) {
                muxConcurrency.x(String.valueOf(iIntValue));
            }
        }

        private final void updateMuxXudpConcurrency(String str) {
            if (str == null) {
                ListPreference muxXudpQuic = getMuxXudpQuic();
                if (muxXudpQuic != null) {
                    muxXudpQuic.v(true);
                    return;
                }
                return;
            }
            Integer numU = q31.U(str);
            int iIntValue = numU != null ? numU.intValue() : 8;
            EditTextPreference muxXudpConcurrency = getMuxXudpConcurrency();
            if (muxXudpConcurrency != null) {
                muxXudpConcurrency.x(String.valueOf(iIntValue));
            }
            ListPreference muxXudpQuic2 = getMuxXudpQuic();
            if (muxXudpQuic2 != null) {
                muxXudpQuic2.v(iIntValue >= 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EditTextPreference vpnDns_delegate$lambda$5(SettingsFragment settingsFragment) {
            return (EditTextPreference) settingsFragment.findPreference(AppConfig.PREF_VPN_DNS);
        }

        @Override // androidx.preference.b
        public void onCreatePreferences(Bundle bundle, String str) {
            addPreferencesFromResource(R.xml.pref_settings);
            CheckBoxPreference localDns = getLocalDns();
            final int i = 0;
            if (localDns != null) {
                localDns.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i2 = i;
                        int i3 = i;
                        if (i2 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i3 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i3 != 1) {
                                return i3 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i2 == 1) {
                            if (i3 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i3 != 1) {
                                return i3 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i2 != 2) {
                            if (i3 != 0) {
                                return i3 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i3 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i3 != 1) {
                            return i3 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            EditTextPreference localDnsPort = getLocalDnsPort();
            final int i2 = 2;
            final int i3 = 1;
            if (localDnsPort != null) {
                localDnsPort.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i4 = i2;
                        int i5 = i3;
                        if (i4 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i5 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i5 != 1) {
                                return i5 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i4 == 1) {
                            if (i5 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i5 != 1) {
                                return i5 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i4 != 2) {
                            if (i5 != 0) {
                                return i5 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i5 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 1) {
                            return i5 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            EditTextPreference vpnDns = getVpnDns();
            final int i4 = 3;
            if (vpnDns != null) {
                vpnDns.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i4;
                        int i6 = i3;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            CheckBoxPreference mux = getMux();
            if (mux != null) {
                mux.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i;
                        int i6 = i2;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            EditTextPreference muxConcurrency = getMuxConcurrency();
            if (muxConcurrency != null) {
                muxConcurrency.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i3;
                        int i6 = i2;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            EditTextPreference muxXudpConcurrency = getMuxXudpConcurrency();
            if (muxXudpConcurrency != null) {
                muxXudpConcurrency.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i2;
                        int i6 = i2;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            CheckBoxPreference fragment = getFragment();
            if (fragment != null) {
                fragment.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i4;
                        int i6 = i2;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            ListPreference fragmentPackets = getFragmentPackets();
            if (fragmentPackets != null) {
                fragmentPackets.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i;
                        int i6 = i4;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            EditTextPreference fragmentLength = getFragmentLength();
            if (fragmentLength != null) {
                fragmentLength.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i3;
                        int i6 = i4;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            EditTextPreference fragmentInterval = getFragmentInterval();
            if (fragmentInterval != null) {
                fragmentInterval.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i2;
                        int i6 = i4;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            EditTextPreference socksPort = getSocksPort();
            if (socksPort != null) {
                socksPort.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i3;
                        int i6 = i;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            EditTextPreference remoteDns = getRemoteDns();
            if (remoteDns != null) {
                remoteDns.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i2;
                        int i6 = i;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            EditTextPreference domesticDns = getDomesticDns();
            if (domesticDns != null) {
                domesticDns.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i4;
                        int i6 = i;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            EditTextPreference delayTestUrl = getDelayTestUrl();
            if (delayTestUrl != null) {
                delayTestUrl.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i;
                        int i6 = i3;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            ListPreference mode = getMode();
            if (mode != null) {
                mode.g = new Preference.d(this) { // from class: pz0
                    public final /* synthetic */ SettingsActivity.SettingsFragment b;

                    {
                        this.b = this;
                    }

                    @Override // androidx.preference.Preference.d
                    public final boolean a(Preference preference, Serializable serializable) {
                        int i5 = i3;
                        int i6 = i3;
                        if (i5 == 0) {
                            SettingsActivity.SettingsFragment settingsFragment = this.b;
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$21(settingsFragment, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$28(settingsFragment, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$24(settingsFragment, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$34(settingsFragment, preference, serializable);
                        }
                        SettingsActivity.SettingsFragment settingsFragment2 = this.b;
                        if (i5 == 1) {
                            if (i6 == 0) {
                                return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$31(settingsFragment2, preference, serializable);
                            }
                            if (i6 != 1) {
                                return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$29(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$25(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$35(settingsFragment2, preference, serializable);
                        }
                        if (i5 != 2) {
                            if (i6 != 0) {
                                return i6 != 1 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$27(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$23(settingsFragment2, preference, serializable);
                            }
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$33(settingsFragment2, preference, serializable);
                        }
                        if (i6 == 0) {
                            return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$32(settingsFragment2, preference, serializable);
                        }
                        if (i6 != 1) {
                            return i6 != 2 ? SettingsActivity.SettingsFragment.onCreatePreferences$lambda$30(settingsFragment2, preference, serializable) : SettingsActivity.SettingsFragment.onCreatePreferences$lambda$26(settingsFragment2, preference, serializable);
                        }
                        return SettingsActivity.SettingsFragment.onCreatePreferences$lambda$22(settingsFragment2, preference, serializable);
                    }
                };
            }
            ListPreference mode2 = getMode();
            if (mode2 != null) {
                mode2.Y = R.layout.preference_with_help_link;
            }
        }

        @Override // androidx.preference.b, androidx.fragment.app.Fragment
        public void onStart() {
            super.onStart();
            MmkvManager mmkvManager = MmkvManager.INSTANCE;
            updateMode(mmkvManager.decodeSettingsString(AppConfig.PREF_MODE, AppConfig.VPN));
            CheckBoxPreference localDns = getLocalDns();
            if (localDns != null) {
                localDns.A(mmkvManager.decodeSettingsBool(AppConfig.PREF_LOCAL_DNS_ENABLED, false));
            }
            CheckBoxPreference fakeDns = getFakeDns();
            if (fakeDns != null) {
                fakeDns.A(mmkvManager.decodeSettingsBool(AppConfig.PREF_FAKE_DNS_ENABLED, false));
            }
            CheckBoxPreference appendHttpProxy = getAppendHttpProxy();
            if (appendHttpProxy != null) {
                appendHttpProxy.A(mmkvManager.decodeSettingsBool(AppConfig.PREF_APPEND_HTTP_PROXY, false));
            }
            EditTextPreference localDnsPort = getLocalDnsPort();
            if (localDnsPort != null) {
                localDnsPort.x(mmkvManager.decodeSettingsString(AppConfig.PREF_LOCAL_DNS_PORT, AppConfig.PORT_LOCAL_DNS));
            }
            EditTextPreference vpnDns = getVpnDns();
            if (vpnDns != null) {
                vpnDns.x(mmkvManager.decodeSettingsString(AppConfig.PREF_VPN_DNS, "1.1.1.1"));
            }
            updateMux(mmkvManager.decodeSettingsBool(AppConfig.PREF_MUX_ENABLED, false));
            CheckBoxPreference mux = getMux();
            if (mux != null) {
                mux.A(mmkvManager.decodeSettingsBool(AppConfig.PREF_MUX_ENABLED, false));
            }
            EditTextPreference muxConcurrency = getMuxConcurrency();
            if (muxConcurrency != null) {
                muxConcurrency.x(mmkvManager.decodeSettingsString(AppConfig.PREF_MUX_CONCURRENCY, "8"));
            }
            EditTextPreference muxXudpConcurrency = getMuxXudpConcurrency();
            if (muxXudpConcurrency != null) {
                muxXudpConcurrency.x(mmkvManager.decodeSettingsString(AppConfig.PREF_MUX_XUDP_CONCURRENCY, "8"));
            }
            updateFragment(mmkvManager.decodeSettingsBool(AppConfig.PREF_FRAGMENT_ENABLED, false));
            CheckBoxPreference fragment = getFragment();
            if (fragment != null) {
                fragment.A(mmkvManager.decodeSettingsBool(AppConfig.PREF_FRAGMENT_ENABLED, false));
            }
            ListPreference fragmentPackets = getFragmentPackets();
            if (fragmentPackets != null) {
                fragmentPackets.x(mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_PACKETS, "tlshello"));
            }
            EditTextPreference fragmentLength = getFragmentLength();
            if (fragmentLength != null) {
                fragmentLength.x(mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_LENGTH, "50-100"));
            }
            EditTextPreference fragmentInterval = getFragmentInterval();
            if (fragmentInterval != null) {
                fragmentInterval.x(mmkvManager.decodeSettingsString(AppConfig.PREF_FRAGMENT_INTERVAL, "10-20"));
            }
            CheckBoxPreference autoUpdateCheck = getAutoUpdateCheck();
            if (autoUpdateCheck != null) {
                autoUpdateCheck.A(mmkvManager.decodeSettingsBool(AppConfig.SUBSCRIPTION_AUTO_UPDATE, false));
            }
            EditTextPreference autoUpdateInterval = getAutoUpdateInterval();
            if (autoUpdateInterval != null) {
                autoUpdateInterval.x(mmkvManager.decodeSettingsString(AppConfig.SUBSCRIPTION_AUTO_UPDATE_INTERVAL, AppConfig.SUBSCRIPTION_DEFAULT_UPDATE_INTERVAL));
            }
            EditTextPreference autoUpdateInterval2 = getAutoUpdateInterval();
            if (autoUpdateInterval2 != null) {
                autoUpdateInterval2.v(mmkvManager.decodeSettingsBool(AppConfig.SUBSCRIPTION_AUTO_UPDATE, false));
            }
            EditTextPreference socksPort = getSocksPort();
            if (socksPort != null) {
                socksPort.x(mmkvManager.decodeSettingsString(AppConfig.PREF_SOCKS_PORT, AppConfig.PORT_SOCKS));
            }
            EditTextPreference remoteDns = getRemoteDns();
            if (remoteDns != null) {
                remoteDns.x(mmkvManager.decodeSettingsString(AppConfig.PREF_REMOTE_DNS, "1.1.1.1"));
            }
            EditTextPreference domesticDns = getDomesticDns();
            if (domesticDns != null) {
                domesticDns.x(mmkvManager.decodeSettingsString(AppConfig.PREF_DOMESTIC_DNS, AppConfig.DNS_DIRECT));
            }
            EditTextPreference delayTestUrl = getDelayTestUrl();
            if (delayTestUrl != null) {
                delayTestUrl.x(mmkvManager.decodeSettingsString(AppConfig.PREF_DELAY_TEST_URL, AppConfig.DelayTestUrl));
            }
            initSharedPreference();
        }
    }

    private final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel$delegate.getValue();
    }

    @Override // renz.javacodez.v2ray.ui.BaseActivity, androidx.fragment.app.n, androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        setTitle(getString(R.string.title_settings));
        getSettingsViewModel().startListenPreferenceChange();
    }

    public final void onModeHelpClicked(View view) {
        Utils.INSTANCE.openUri(this, AppConfig.v2rayNGWikiMode);
    }
}
