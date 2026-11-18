package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.ActionMenuView;
import com.trilead.ssh2.sftp.AttribFlags;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends ViewGroup {
    public final a b;
    public final Context c;
    public ActionMenuView d;
    public androidx.appcompat.widget.a f;
    public int g;
    public je1 i;
    public boolean j;
    public boolean n;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements le1 {
        public boolean a;
        public int b;
        public final Object c;

        public a(c cVar) {
            this.c = cVar;
            this.a = false;
        }

        public a(u01 u01Var, int i, boolean z) {
            this.c = u01Var;
            this.b = i;
            this.a = z;
        }

        @Override // defpackage.le1
        public void a() {
            c.super.setVisibility(0);
            this.a = false;
        }

        @Override // defpackage.le1
        public void onAnimationCancel() {
            this.a = true;
        }

        @Override // defpackage.le1
        public void onAnimationEnd() {
            if (this.a) {
                return;
            }
            c cVar = (c) this.c;
            cVar.i = null;
            c.super.setVisibility(this.b);
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.style.j, typedValue, true) || typedValue.resourceId == 0) {
            this.c = context;
        } else {
            this.c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int c(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED), i2);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    public static int d(int i, int i2, int i3, View view, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public final je1 e(int i, long j) {
        je1 je1Var = this.i;
        if (je1Var != null) {
            je1Var.b();
        }
        a aVar = this.b;
        if (i != 0) {
            je1 je1VarA = qd1.a(this);
            je1VarA.a(0.0f);
            je1VarA.c(j);
            ((c) aVar.c).i = je1VarA;
            aVar.b = i;
            je1VarA.d(aVar);
            return je1VarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        je1 je1VarA2 = qd1.a(this);
        je1VarA2.a(1.0f);
        je1VarA2.c(j);
        ((c) aVar.c).i = je1VarA2;
        aVar.b = i;
        je1VarA2.d(aVar);
        return je1VarA2;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        int i;
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, b2.f17a, R.style.m, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
        androidx.appcompat.widget.a aVar = this.f;
        if (aVar != null) {
            Configuration configuration2 = aVar.c.getResources().getConfiguration();
            int i2 = configuration2.screenWidthDp;
            int i3 = configuration2.screenHeightDp;
            if (configuration2.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
                i = 5;
            } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
                i = 4;
            } else {
                i = i2 >= 360 ? 3 : 2;
            }
            aVar.w = i;
            f fVar = aVar.d;
            if (fVar != null) {
                fVar.onItemsChanged(true);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.n = false;
        }
        if (!this.n) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.n = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.n = false;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.j = false;
        }
        if (!this.j) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.j = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.j = false;
        return true;
    }

    public void setContentHeight(int i) {
        this.g = i;
        requestLayout();
    }

    @Override // android.view.View
    public final void setVisibility(int i) {
        if (i != getVisibility()) {
            je1 je1Var = this.i;
            if (je1Var != null) {
                je1Var.b();
            }
            super.setVisibility(i);
        }
    }
}
