package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.q;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.navigation.NavController;
import defpackage.bk0;
import defpackage.d;
import defpackage.e4;
import defpackage.he0;
import java.util.ArrayDeque;
import java.util.HashSet;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
@bk0.a("dialog")
public final class DialogFragmentNavigator extends bk0 {
    public final h e;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends androidx.navigation.a {
        public a(bk0 bk0Var) {
            super(bk0Var);
        }
    }

    public DialogFragmentNavigator(Context context, q qVar) {
        new HashSet();
        this.e = new h() { // from class: androidx.navigation.fragment.DialogFragmentNavigator.1
            @Override // androidx.lifecycle.h
            public final void a(he0 he0Var, e.a aVar) {
                NavController navControllerA;
                if (aVar == e.a.ON_STOP) {
                    m mVar = (m) he0Var;
                    if (mVar.requireDialog().isShowing()) {
                        return;
                    }
                    for (Fragment parentFragment = mVar; parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
                        Fragment fragment = parentFragment.getParentFragmentManager().x;
                    }
                    View view = mVar.getView();
                    if (view != null) {
                        navControllerA = e4.a(view);
                    } else {
                        Dialog dialog = mVar.mDialog;
                        if (dialog == null || dialog.getWindow() == null) {
                            d.AnonymousClass0.m("Fragment ", mVar, " does not have a NavController set");
                            return;
                        }
                        navControllerA = e4.a(dialog.getWindow().getDecorView());
                    }
                    ArrayDeque arrayDeque = navControllerA.h;
                    if (arrayDeque.isEmpty()) {
                        return;
                    }
                    if (arrayDeque.isEmpty() || arrayDeque.getLast() == null) {
                        throw null;
                    }
                    d.AnonymousClass0.m$1();
                }
            }
        };
    }
}
