package com.blacksquircle.ui.editorkit.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.blacksquircle.ui.editorkit.widget.internal.SyntaxHighlightEditText;
import defpackage.f61;
import defpackage.fb$1;
import defpackage.h6;
import defpackage.zk;
import java.util.ArrayList;
import java.util.Iterator;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class TextProcessor extends SyntaxHighlightEditText {
    public final ArrayList plugins;

    public TextProcessor(Context context) {
        this(context, null, 0, 6, null);
    }

    public TextProcessor(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public TextProcessor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.plugins = new ArrayList();
    }

    public /* synthetic */ TextProcessor(Context context, AttributeSet attributeSet, int i, int i2, zk zkVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.style.bd : i);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        ArrayList arrayList = this.plugins;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw fb$1.m(it);
        }
        super.onDraw(canvas);
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            throw fb$1.m(it2);
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        Iterator it = this.plugins.iterator();
        if (it.hasNext()) {
            throw fb$1.m(it);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        Iterator it = this.plugins.iterator();
        if (it.hasNext()) {
            throw fb$1.m(it);
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Iterator it = this.plugins.iterator();
        if (it.hasNext()) {
            throw fb$1.m(it);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Iterator it = this.plugins.iterator();
        if (it.hasNext()) {
            throw fb$1.m(it);
        }
    }

    @Override // com.blacksquircle.ui.editorkit.widget.internal.SyntaxHighlightEditText, com.blacksquircle.ui.editorkit.widget.internal.ScrollableEditText, android.widget.TextView, android.view.View
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        Iterator it = this.plugins.iterator();
        if (it.hasNext()) {
            throw fb$1.m(it);
        }
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        post(new f61(this, i, i2));
    }

    @Override // com.blacksquircle.ui.editorkit.widget.internal.SyntaxHighlightEditText, com.blacksquircle.ui.editorkit.widget.internal.ScrollableEditText, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Iterator it = this.plugins.iterator();
        if (it.hasNext()) {
            throw fb$1.m(it);
        }
    }

    @Override // com.blacksquircle.ui.editorkit.widget.internal.ScrollableEditText, android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Iterator it = this.plugins.iterator();
        if (it.hasNext()) {
            throw fb$1.m(it);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public final void setTextSize(float f) {
        super.setTextSize(f);
        post(new f61(this, f));
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        post(new h6(3, this, typeface));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        super.showDropDown();
        Iterator it = this.plugins.iterator();
        if (it.hasNext()) {
            throw fb$1.m(it);
        }
    }
}
