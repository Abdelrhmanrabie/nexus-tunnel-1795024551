package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class u5 extends MultiAutoCompleteTextView {
    public static final int[] TINT_ATTRS = {R.attr.popupBackground};
    public final g mAppCompatEmojiEditTextHelper;
    public final y4 mBackgroundTintHelper;
    public final g6 mTextHelper;

    public u5(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.hamotunnelplus.xyz.R.style.bd);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        z61.a(context);
        j61.a(this, getContext());
        m6 m6VarM = m6.m(getContext(), attributeSet, TINT_ATTRS, i);
        if (((TypedArray) m6VarM.a).hasValue(0)) {
            setDropDownBackgroundDrawable(m6VarM.e(0));
        }
        m6VarM.n();
        y4 y4Var = new y4(this);
        this.mBackgroundTintHelper = y4Var;
        y4Var.d(attributeSet, i);
        g6 g6Var = new g6(this);
        this.mTextHelper = g6Var;
        g6Var.d(attributeSet, i);
        g6Var.b();
        g gVar = new g(this, 20);
        this.mAppCompatEmojiEditTextHelper = gVar;
        gVar.b(attributeSet, i);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = isFocusable();
        int inputType = super.getInputType();
        KeyListener keyListenerA = gVar.a(keyListener);
        if (keyListenerA == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerA);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.a();
        }
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        e.g1(editorInfo, inputConnectionOnCreateInputConnection, this);
        return this.mAppCompatEmojiEditTextHelper.c(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.f(i);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public final void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(e.s(getContext(), i));
    }

    @Override // android.widget.TextView
    public final void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.a(keyListener));
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        g6 g6Var = this.mTextHelper;
        if (g6Var != null) {
            g6Var.e(context, i);
        }
    }
}
