package renz.javacodez.v2ray.ui;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.t;
import defpackage.lw;
import defpackage.oc0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsActivity$special$$inlined$viewModels$default$1 extends oc0 implements lw {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsActivity$special$$inlined$viewModels$default$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    @Override // defpackage.lw
    public final t.b invoke() {
        return this.$this_viewModels.getDefaultViewModelProviderFactory();
    }
}
