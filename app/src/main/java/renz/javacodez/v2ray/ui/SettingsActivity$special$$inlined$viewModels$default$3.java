package renz.javacodez.v2ray.ui;

import androidx.activity.ComponentActivity;
import defpackage.cj;
import defpackage.lw;
import defpackage.oc0;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsActivity$special$$inlined$viewModels$default$3 extends oc0 implements lw {
    final /* synthetic */ lw $extrasProducer;
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsActivity$special$$inlined$viewModels$default$3(lw lwVar, ComponentActivity componentActivity) {
        super(0);
        this.$extrasProducer = lwVar;
        this.$this_viewModels = componentActivity;
    }

    @Override // defpackage.lw
    public final cj invoke() {
        cj cjVar;
        lw lwVar = this.$extrasProducer;
        return (lwVar == null || (cjVar = (cj) lwVar.invoke()) == null) ? this.$this_viewModels.getDefaultViewModelCreationExtras() : cjVar;
    }
}
