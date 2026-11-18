package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.view.View;
import defpackage.n5;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BottomSheetDialogFragment extends n5 {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class BottomSheetDismissCallback extends BottomSheetBehavior.BottomSheetCallback {
        private BottomSheetDismissCallback() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View view) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View view, int i) {
            if (i == 5) {
                BottomSheetDialogFragment.this.dismissInternal(false, false);
            }
        }
    }

    @Override // androidx.fragment.app.m
    public final Dialog onCreateDialog() {
        return new BottomSheetDialog(getContext(), this.mTheme);
    }
}
