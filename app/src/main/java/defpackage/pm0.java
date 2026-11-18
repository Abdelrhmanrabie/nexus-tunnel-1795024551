package defpackage;

import androidx.activity.OnBackPressedDispatcher;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class pm0 extends oc0 implements lw {
    public final /* synthetic */ int G0;
    public final /* synthetic */ OnBackPressedDispatcher b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ pm0(OnBackPressedDispatcher onBackPressedDispatcher, int i) {
        super(0);
        this.G0 = i;
        this.b = onBackPressedDispatcher;
    }

    @Override // defpackage.lw
    public final Object invoke() {
        int i = this.G0;
        OnBackPressedDispatcher onBackPressedDispatcher = this.b;
        if (i == 0 || i != 1) {
            onBackPressedDispatcher.c();
        } else {
            onBackPressedDispatcher.b();
        }
        return tb1.a;
    }
}
