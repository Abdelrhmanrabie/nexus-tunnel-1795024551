package com.blacksquircle.ui.editorkit.widget.internal;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import defpackage.l7;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class LineNumbersEditText extends ScrollableEditText {
    public LineNumbersEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.bd);
    }

    public LineNumbersEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        new l7();
        new SpannableStringBuilder(AppConfig.CUSTOM);
        setGravity(8388659);
        setInputType(655361);
    }
}
