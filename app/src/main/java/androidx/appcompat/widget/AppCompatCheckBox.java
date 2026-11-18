package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView;
import defpackage.c5;
import defpackage.e;
import defpackage.g;
import defpackage.g6;
import defpackage.j61;
import defpackage.y4;
import defpackage.z61;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox {
    public g mAppCompatEmojiTextHelper;
    public final y4 mBackgroundTintHelper;
    public final c5 mCompoundButtonHelper;
    public final g6 mTextHelper;

    public AppCompatCheckBox(Context context) {
        this(context, null);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.e4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        z61.a(context);
        j61.a(this, getContext());
        c5 c5Var = new c5(1, this);
        this.mCompoundButtonHelper = c5Var;
        c5Var.b(attributeSet, i);
        y4 y4Var = new y4(this);
        this.mBackgroundTintHelper = y4Var;
        y4Var.d(attributeSet, i);
        g6 g6Var = new g6(this);
        this.mTextHelper = g6Var;
        g6Var.d(attributeSet, i);
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new g((TextView) this);
        }
        this.mAppCompatEmojiTextHelper.c(attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
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

    @Override // android.widget.TextView
    public final void setAllCaps(boolean z) {
        super.setAllCaps(z);
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new g((TextView) this);
        }
        this.mAppCompatEmojiTextHelper.d(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        y4 y4Var = this.mBackgroundTintHelper;
        if (y4Var != null) {
            y4Var.f(i);
        }
    }

    @Override // android.widget.CompoundButton
    public final void setButtonDrawable(int i) {
        setButtonDrawable(e.s(getContext(), i));
    }

    @Override // android.widget.CompoundButton
    public final void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        c5 c5Var = this.mCompoundButtonHelper;
        if (c5Var != null) {
            if (c5Var.f) {
                c5Var.f = false;
            } else {
                c5Var.f = true;
                c5Var.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new g((TextView) this);
        }
        super.setFilters(this.mAppCompatEmojiTextHelper.a(inputFilterArr));
    }
}
