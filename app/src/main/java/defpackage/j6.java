package defpackage;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.ToggleButton;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class j6 extends ToggleButton {
    public final y4 b;
    public final g6 c;
    public g d;

    public j6(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        j61.a(this, getContext());
        y4 y4Var = new y4(this);
        this.b = y4Var;
        y4Var.d(attributeSet, R.attr.buttonStyleToggle);
        g6 g6Var = new g6(this);
        this.c = g6Var;
        g6Var.d(attributeSet, R.attr.buttonStyleToggle);
        if (this.d == null) {
            this.d = new g((TextView) this);
        }
        this.d.c(attributeSet, R.attr.buttonStyleToggle);
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        y4 y4Var = this.b;
        if (y4Var != null) {
            y4Var.a();
        }
        g6 g6Var = this.c;
        if (g6Var != null) {
            g6Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setAllCaps(boolean z) {
        super.setAllCaps(z);
        if (this.d == null) {
            this.d = new g((TextView) this);
        }
        this.d.d(z);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        y4 y4Var = this.b;
        if (y4Var != null) {
            y4Var.e();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        y4 y4Var = this.b;
        if (y4Var != null) {
            y4Var.f(i);
        }
    }

    @Override // android.widget.TextView
    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.d == null) {
            this.d = new g((TextView) this);
        }
        super.setFilters(this.d.a(inputFilterArr));
    }
}
