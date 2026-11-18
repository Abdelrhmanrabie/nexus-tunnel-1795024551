package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class y4 {
    public final View a;
    public a71 d;
    public a71 e;
    public a71 f;
    public int c = -1;
    public final o5 b = o5.a();

    public y4(View view) {
        this.a = view;
    }

    public final void a() {
        View view = this.a;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.d != null) {
                if (this.f == null) {
                    this.f = new a71();
                }
                a71 a71Var = this.f;
                a71Var.a = null;
                a71Var.d = false;
                a71Var.b = null;
                a71Var.c = false;
                WeakHashMap weakHashMap = qd1.a;
                ColorStateList backgroundTintList = view.getBackgroundTintList();
                if (backgroundTintList != null) {
                    a71Var.d = true;
                    a71Var.a = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = view.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    a71Var.c = true;
                    a71Var.b = backgroundTintMode;
                }
                if (a71Var.d || a71Var.c) {
                    o5.e(background, a71Var, view.getDrawableState());
                    return;
                }
            }
            a71 a71Var2 = this.e;
            if (a71Var2 != null) {
                o5.e(background, a71Var2, view.getDrawableState());
                return;
            }
            a71 a71Var3 = this.d;
            if (a71Var3 != null) {
                o5.e(background, a71Var3, view.getDrawableState());
            }
        }
    }

    public final void d(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListI;
        View view = this.a;
        Context context = view.getContext();
        int[] iArr = b2.B;
        m6 m6VarM = m6.m(context, attributeSet, iArr, i);
        View view2 = this.a;
        qd1.k(view2, view2.getContext(), iArr, attributeSet, (TypedArray) m6VarM.a, i);
        try {
            if (((TypedArray) m6VarM.a).hasValue(0)) {
                this.c = ((TypedArray) m6VarM.a).getResourceId(0, -1);
                o5 o5Var = this.b;
                Context context2 = view.getContext();
                int i2 = this.c;
                synchronized (o5Var) {
                    colorStateListI = o5Var.a.i(context2, i2);
                }
                if (colorStateListI != null) {
                    g(colorStateListI);
                }
            }
            if (((TypedArray) m6VarM.a).hasValue(1)) {
                view.setBackgroundTintList(m6VarM.b(1));
            }
            if (((TypedArray) m6VarM.a).hasValue(2)) {
                view.setBackgroundTintMode(fp.d(((TypedArray) m6VarM.a).getInt(2, -1), null));
            }
            m6VarM.n();
        } catch (Throwable th) {
            m6VarM.n();
            throw th;
        }
    }

    public final void e() {
        this.c = -1;
        g(null);
        a();
    }

    public final void f(int i) {
        ColorStateList colorStateListI;
        this.c = i;
        o5 o5Var = this.b;
        if (o5Var != null) {
            Context context = this.a.getContext();
            synchronized (o5Var) {
                colorStateListI = o5Var.a.i(context, i);
            }
        } else {
            colorStateListI = null;
        }
        g(colorStateListI);
        a();
    }

    public final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new a71();
            }
            a71 a71Var = this.d;
            a71Var.a = colorStateList;
            a71Var.d = true;
        } else {
            this.d = null;
        }
        a();
    }
}
