package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class i71 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static i71 p;
    public static i71 q;
    public final View b;
    public final CharSequence c;
    public final int d;
    public final a f = new a(this, 0);
    public final a g = new a(this, 1);
    public int i;
    public int j;
    public e91 n;
    public boolean o;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Runnable {
        public final /* synthetic */ int G0;
        public final /* synthetic */ i71 b;

        public /* synthetic */ a(i71 i71Var, int i) {
            this.G0 = i;
            this.b = i71Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.G0;
            i71 i71Var = this.b;
            if (i != 0) {
                i71Var.a();
            } else {
                i71Var.c(false);
            }
        }
    }

    public i71(CharSequence charSequence, View view) {
        this.b = view;
        this.c = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = ud1.a;
        this.d = Build.VERSION.SDK_INT >= 28 ? viewConfiguration.getScaledHoverSlop() : viewConfiguration.getScaledTouchSlop() / 2;
        this.i = Integer.MAX_VALUE;
        this.j = Integer.MAX_VALUE;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(i71 i71Var) {
        i71 i71Var2 = p;
        if (i71Var2 != null) {
            i71Var2.b.removeCallbacks(i71Var2.f);
        }
        p = i71Var;
        if (i71Var != null) {
            i71Var.b.postDelayed(i71Var.f, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        i71 i71Var = q;
        View view = this.b;
        if (i71Var == this) {
            q = null;
            e91 e91Var = this.n;
            if (e91Var != null) {
                View view2 = (View) e91Var.b;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) e91Var.a).getSystemService("window")).removeView(view2);
                }
                this.n = null;
                this.i = Integer.MAX_VALUE;
                this.j = Integer.MAX_VALUE;
                view.removeOnAttachStateChangeListener(this);
            }
        }
        if (p == this) {
            b(null);
        }
        view.removeCallbacks(this.g);
    }

    public final void c(boolean z) {
        int height;
        int i;
        long longPressTimeout;
        long j;
        long j2;
        int i2;
        WeakHashMap weakHashMap = qd1.a;
        View view = this.b;
        if (view.isAttachedToWindow()) {
            b(null);
            i71 i71Var = q;
            if (i71Var != null) {
                i71Var.a();
            }
            q = this;
            this.o = z;
            e91 e91Var = new e91(view.getContext());
            this.n = e91Var;
            int width = this.i;
            int i3 = this.j;
            boolean z2 = this.o;
            View view2 = (View) e91Var.b;
            boolean z3 = view2.getParent() != null;
            Context context = (Context) e91Var.a;
            if (z3 && view2.getParent() != null) {
                ((WindowManager) context.getSystemService("window")).removeView(view2);
            }
            ((TextView) e91Var.c).setText(this.c);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) e91Var.d;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.q3);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.q2);
                height = i3 + dimensionPixelOffset2;
                i = i3 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(z2 ? R.dimen.q6 : R.dimen.q5);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                for (Context context2 = view.getContext(); context2 instanceof ContextWrapper; context2 = ((ContextWrapper) context2).getBaseContext()) {
                    if (context2 instanceof Activity) {
                        rootView = ((Activity) context2).getWindow().getDecorView();
                        break;
                    }
                }
            }
            if (rootView != null) {
                Rect rect = (Rect) e91Var.e;
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i2 = 0;
                } else {
                    Resources resources = context.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i2 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                int[] iArr = (int[]) e91Var.g;
                rootView.getLocationOnScreen(iArr);
                int[] iArr2 = (int[]) e91Var.f;
                view.getLocationOnScreen(iArr2);
                int i4 = iArr2[i2] - iArr[i2];
                iArr2[i2] = i4;
                iArr2[1] = iArr2[1] - iArr[1];
                layoutParams.x = (i4 + width) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, i2);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i5 = iArr2[1];
                int i6 = ((i + i5) - dimensionPixelOffset3) - measuredHeight;
                int i7 = i5 + height + dimensionPixelOffset3;
                if (!z2 ? measuredHeight + i7 > rect.height() : i6 >= 0) {
                    layoutParams.y = i6;
                } else {
                    layoutParams.y = i7;
                }
            }
            ((WindowManager) context.getSystemService("window")).addView(view2, layoutParams);
            view.addOnAttachStateChangeListener(this);
            if (this.o) {
                j2 = 2500;
            } else {
                if ((view.getWindowSystemUiVisibility() & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 15000;
                }
                j2 = j - longPressTimeout;
            }
            a aVar = this.g;
            view.removeCallbacks(aVar);
            view.postDelayed(aVar, j2);
        }
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.n == null || !this.o) {
            View view2 = this.b;
            AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
                int action = motionEvent.getAction();
                if (action != 7) {
                    if (action == 10) {
                        this.i = Integer.MAX_VALUE;
                        this.j = Integer.MAX_VALUE;
                        a();
                        return false;
                    }
                } else if (view2.isEnabled() && this.n == null) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int iAbs = Math.abs(x - this.i);
                    int i = this.d;
                    if (iAbs > i || Math.abs(y - this.j) > i) {
                        this.i = x;
                        this.j = y;
                        b(this);
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.i = view.getWidth() / 2;
        this.j = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }
}
