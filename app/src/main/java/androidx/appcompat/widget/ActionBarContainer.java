package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.b2;
import defpackage.qd1;
import defpackage.u1;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    public boolean b;
    public View d;
    public View f;
    public final Drawable g;
    public final Drawable i;
    public final Drawable j;
    public final boolean n;
    public boolean o;
    public final int p;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u1 u1Var = new u1(this);
        WeakHashMap weakHashMap = qd1.a;
        setBackground(u1Var);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b2.f17a);
        boolean z = false;
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.g = drawable;
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(2);
        this.i = drawable2;
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.attr.z2) {
            this.n = true;
            this.j = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.n ? !(drawable != null || drawable2 != null) : this.j == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.g;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(getDrawableState());
        }
        Drawable drawable3 = this.j;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        drawable3.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.j;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.d = findViewById(R.attr.be);
        this.f = findViewById(R.attr.bm);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.b || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = true;
        if (this.n) {
            Drawable drawable = this.j;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            Drawable drawable2 = this.g;
            if (drawable2 != null) {
                if (this.d.getVisibility() == 0) {
                    left = this.d.getLeft();
                    top = this.d.getTop();
                    right = this.d.getRight();
                    view = this.d;
                } else {
                    View view2 = this.f;
                    if (view2 == null || view2.getVisibility() != 0) {
                        drawable2.setBounds(0, 0, 0, 0);
                    } else {
                        left = this.f.getLeft();
                        top = this.f.getTop();
                        right = this.f.getRight();
                        view = this.f;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
            } else {
                z2 = false;
            }
            this.o = false;
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        if (this.d == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.p) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        }
        super.onMeasure(i, i2);
        if (this.d == null) {
            return;
        }
        View.MeasureSpec.getMode(i2);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public final void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.j;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.g;
        boolean z = this.n;
        if (drawable == drawable2 && !z) {
            return true;
        }
        if (drawable == this.i && this.o) {
            return true;
        }
        return (drawable == this.j && z) || super.verifyDrawable(drawable);
    }
}
