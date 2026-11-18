package defpackage;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends ClickableSpan {
    public final int b;
    public final o1 c;
    public final int d;

    public z0(int i, o1 o1Var, int i2) {
        this.b = i;
        this.c = o1Var;
        this.d = i2;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.b);
        this.c.a.performAction(this.d, bundle);
    }
}
