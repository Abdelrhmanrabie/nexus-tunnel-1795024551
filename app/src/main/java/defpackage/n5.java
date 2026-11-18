package defpackage;

import android.app.Dialog;
import androidx.appcompat.app.f;
import androidx.fragment.app.m;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class n5 extends m {
    @Override // androidx.fragment.app.m
    public final void setupDialog(Dialog dialog, int i) {
        if (!(dialog instanceof f)) {
            super.setupDialog(dialog, i);
            return;
        }
        f fVar = (f) dialog;
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        fVar.getDelegate().t(1);
    }
}
