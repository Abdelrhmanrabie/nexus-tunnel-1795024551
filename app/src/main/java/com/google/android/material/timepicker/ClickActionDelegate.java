package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import defpackage.a1;
import defpackage.o1;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class ClickActionDelegate extends a1 {
    public final o1.a clickAction;

    public ClickActionDelegate(Context context, int i) {
        this.clickAction = new o1.a(16, context.getString(i));
    }

    @Override // defpackage.a1
    public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, o1Var.a);
        o1Var.b(this.clickAction);
    }
}
