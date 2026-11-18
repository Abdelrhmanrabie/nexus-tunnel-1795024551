package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
class MaxInputValidator implements InputFilter {
    public final int max;

    public MaxInputValidator(int i) {
        this.max = i;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i3, i4, charSequence.subSequence(i, i2).toString());
            if (Integer.parseInt(sb.toString()) <= this.max) {
                return null;
            }
            return AppConfig.CUSTOM;
        } catch (NumberFormatException unused) {
            return AppConfig.CUSTOM;
        }
    }
}
