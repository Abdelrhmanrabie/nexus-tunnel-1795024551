package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import defpackage.b2;
import defpackage.e;
import defpackage.jz;
import defpackage.m6;
import defpackage.qd1;
import defpackage.s5;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final Toolbar a;
    public int b;
    public final View d;
    public final Drawable e;
    public final Drawable f;
    public Drawable g;
    public final boolean h;
    public CharSequence i;
    public final CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public androidx.appcompat.widget.a n;
    public final int o;
    public final Drawable p;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends e {
        public boolean o;
        public final /* synthetic */ int p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(4);
            this.p = i;
            this.o = false;
        }

        @Override // defpackage.e, defpackage.le1
        public final void a() {
            d.this.a.setVisibility(0);
        }

        @Override // defpackage.e, defpackage.le1
        public final void onAnimationCancel() {
            this.o = true;
        }

        @Override // defpackage.le1
        public final void onAnimationEnd() {
            if (this.o) {
                return;
            }
            d.this.a.setVisibility(this.p);
        }
    }

    public d(Toolbar toolbar, boolean z) {
        this.o = 0;
        this.a = toolbar;
        CharSequence charSequence = toolbar.mTitleText;
        this.i = charSequence;
        this.j = toolbar.mSubtitleText;
        this.h = charSequence != null;
        this.g = toolbar.getNavigationIcon();
        m6 m6VarM = m6.m(toolbar.getContext(), null, b2.f17a, R.style.m);
        TypedArray typedArray = (TypedArray) m6VarM.a;
        int i = 15;
        Drawable drawableE = m6VarM.e(15);
        this.p = drawableE;
        if (z) {
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                this.h = true;
                this.i = text;
                if ((this.b & 8) != 0) {
                    toolbar.setTitle(text);
                    qd1.m(text, toolbar.getRootView());
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                this.j = text2;
                if ((this.b & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable drawableE2 = m6VarM.e(20);
            if (drawableE2 != null) {
                this.f = drawableE2;
                w();
            }
            Drawable drawableE3 = m6VarM.e(17);
            if (drawableE3 != null) {
                this.e = drawableE3;
                w();
            }
            if (this.g == null && drawableE != null) {
                v(drawableE);
            }
            i(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.d;
                if (view != null && (this.b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.d = viewInflate;
                if (viewInflate != null && (this.b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                i(this.b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int iMax = Math.max(dimensionPixelOffset, 0);
                int iMax2 = Math.max(dimensionPixelOffset2, 0);
                toolbar.ensureContentInsets();
                toolbar.mContentInsets.a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.mTitleTextAppearance = resourceId2;
                AppCompatTextView appCompatTextView = toolbar.mTitleTextView;
                if (appCompatTextView != null) {
                    appCompatTextView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.mSubtitleTextAppearance = resourceId3;
                AppCompatTextView appCompatTextView2 = toolbar.mSubtitleTextView;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0 && toolbar.mPopupTheme != resourceId4) {
                toolbar.mPopupTheme = resourceId4;
                if (resourceId4 == 0) {
                    toolbar.mPopupContext = toolbar.getContext();
                } else {
                    toolbar.mPopupContext = new ContextThemeWrapper(toolbar.getContext(), resourceId4);
                }
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.p = toolbar.getNavigationIcon();
            } else {
                i = 11;
            }
            this.b = i;
        }
        m6VarM.n();
        this.o = R.string.c;
        s5 s5Var = toolbar.mNavButtonView;
        if (TextUtils.isEmpty(s5Var != null ? s5Var.getContentDescription() : null)) {
            l(R.string.c);
        }
        s5 s5Var2 = toolbar.mNavButtonView;
        this.k = s5Var2 != null ? s5Var2.getContentDescription() : null;
        jz jzVar = new jz(this);
        toolbar.ensureNavButtonView();
        toolbar.mNavButtonView.setOnClickListener(jzVar);
    }

    public final void i(int i) {
        View view;
        Drawable drawable;
        CharSequence text;
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            int i3 = i2 & 4;
            Toolbar toolbar = this.a;
            CharSequence charSequence = null;
            if (i3 != 0) {
                int i4 = i & 4;
                if (i4 != 0 && i4 != 0) {
                    if (TextUtils.isEmpty(this.k)) {
                        int i5 = this.o;
                        text = i5 != 0 ? toolbar.getContext().getText(i5) : null;
                    } else {
                        text = this.k;
                    }
                    toolbar.setNavigationContentDescription(text);
                }
                if ((this.b & 4) != 0) {
                    drawable = this.g;
                    if (drawable == null) {
                        drawable = this.p;
                    }
                } else {
                    drawable = null;
                }
                toolbar.setNavigationIcon(drawable);
            }
            if ((i2 & 3) != 0) {
                w();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    toolbar.setTitle(this.i);
                    charSequence = this.j;
                } else {
                    toolbar.setTitle(null);
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) == 0 || (view = this.d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                toolbar.addView(view);
            } else {
                toolbar.removeView(view);
            }
        }
    }

    public final void l(int i) {
        Toolbar toolbar = this.a;
        String string = i == 0 ? null : toolbar.getContext().getString(i);
        this.k = string;
        if ((this.b & 4) != 0) {
            if (!TextUtils.isEmpty(string)) {
                toolbar.setNavigationContentDescription(this.k);
            } else {
                int i2 = this.o;
                toolbar.setNavigationContentDescription(i2 != 0 ? toolbar.getContext().getText(i2) : null);
            }
        }
    }

    public final void o() {
        androidx.appcompat.widget.a aVar;
        ActionMenuView actionMenuView = this.a.mMenuView;
        if (actionMenuView == null || (aVar = actionMenuView.g) == null) {
            return;
        }
        aVar.b();
        androidx.appcompat.widget.a.C0001a c0001a = aVar.A;
        if (c0001a == null || !c0001a.b()) {
            return;
        }
        c0001a.j.dismiss();
    }

    public final void setWindowTitle(CharSequence charSequence) {
        boolean z = this.h;
        if (z) {
            return;
        }
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            Toolbar toolbar = this.a;
            toolbar.setTitle(charSequence);
            if (z) {
                qd1.m(charSequence, toolbar.getRootView());
            }
        }
    }

    public final void v(Drawable drawable) {
        this.g = drawable;
        if ((this.b & 4) == 0) {
            drawable = null;
        } else if (drawable == null) {
            drawable = this.p;
        }
        this.a.setNavigationIcon(drawable);
    }

    public final void w() {
        Drawable drawable;
        int i = this.b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f) == null) {
            drawable = this.e;
        }
        this.a.setLogo(drawable);
    }
}
