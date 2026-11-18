package com.blacksquircle.ui.editorkit.widget.internal;

import android.content.Context;
import android.util.AttributeSet;
import com.android.volley.toolbox.HurlStack;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class UndoRedoEditText extends LineNumbersEditText {
    public UndoRedoEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.bd);
    }

    public UndoRedoEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        new HurlStack();
        new HurlStack();
    }
}
