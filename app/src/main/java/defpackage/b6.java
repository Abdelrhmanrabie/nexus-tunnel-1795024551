package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class b6 extends SeekBar {
    public final c6 b;

    public b6(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.style.zo);
        j61.a(this, getContext());
        c6 c6Var = new c6(this);
        this.b = c6Var;
        c6Var.a(attributeSet, R.style.zo);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        c6 c6Var = this.b;
        Drawable drawable = c6Var.e;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        b6 b6Var = c6Var.d;
        if (drawable.setState(b6Var.getDrawableState())) {
            b6Var.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.b.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.b.d(canvas);
    }
}
