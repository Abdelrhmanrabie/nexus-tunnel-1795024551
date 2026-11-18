package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b5 extends CheckedTextView {
    public final c5 b;
    public final y4 c;
    public final g6 d;
    public g f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b5(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.style.ec);
        z61.a(context);
        j61.a(this, getContext());
        g6 g6Var = new g6(this);
        this.d = g6Var;
        g6Var.d(attributeSet, R.style.ec);
        g6Var.b();
        y4 y4Var = new y4(this);
        this.c = y4Var;
        y4Var.d(attributeSet, R.style.ec);
        this.b = new c5(0, this);
        Context context2 = getContext();
        int[] iArr = b2.l;
        m6 m6VarM = m6.m(context2, attributeSet, iArr, R.style.ec);
        TypedArray typedArray = (TypedArray) m6VarM.a;
        qd1.k(this, getContext(), iArr, attributeSet, (TypedArray) m6VarM.a, R.style.ec);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(e.s(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        setCheckMarkDrawable(e.s(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(e.s(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(m6VarM.b(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(fp.d(typedArray.getInt(3, -1), null));
            }
            m6VarM.n();
            if (this.f == null) {
                this.f = new g((TextView) this);
            }
            this.f.c(attributeSet, R.style.ec);
        } catch (Throwable th) {
            m6VarM.n();
            throw th;
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        g6 g6Var = this.d;
        if (g6Var != null) {
            g6Var.b();
        }
        y4 y4Var = this.c;
        if (y4Var != null) {
            y4Var.a();
        }
        c5 c5Var = this.b;
        if (c5Var != null) {
            ((b5) c5Var.a).getCheckMarkDrawable();
        }
    }

    @Override // android.widget.TextView
    public final ActionMode.Callback getCustomSelectionActionModeCallback() {
        return ak.e(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        e.g1(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public final void setAllCaps(boolean z) {
        super.setAllCaps(z);
        if (this.f == null) {
            this.f = new g((TextView) this);
        }
        this.f.d(z);
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        y4 y4Var = this.c;
        if (y4Var != null) {
            y4Var.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        y4 y4Var = this.c;
        if (y4Var != null) {
            y4Var.f(i);
        }
    }

    @Override // android.widget.CheckedTextView
    public final void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(e.s(getContext(), i));
    }

    @Override // android.widget.CheckedTextView
    public final void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        c5 c5Var = this.b;
        if (c5Var != null) {
            if (c5Var.f) {
                c5Var.f = false;
            } else {
                c5Var.f = true;
                ((b5) c5Var.a).getCheckMarkDrawable();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(ak.f(callback, this));
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        g6 g6Var = this.d;
        if (g6Var != null) {
            g6Var.e(context, i);
        }
    }
}
