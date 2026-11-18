package defpackage;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class bv implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public final float b;
    public final int c;
    public final int d;
    public final View f;
    public a g;
    public a i;
    public boolean j;
    public int n;
    public final int[] o = new int[2];

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Runnable {
        public final /* synthetic */ int G0;
        public final /* synthetic */ bv b;

        public /* synthetic */ a(bv bvVar, int i) {
            this.G0 = i;
            this.b = bvVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.G0;
            bv bvVar = this.b;
            if (i == 0) {
                ViewParent parent = bvVar.f.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
                return;
            }
            bvVar.a();
            View view = bvVar.f;
            if (view.isEnabled() && !view.isLongClickable() && bvVar.c()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                bvVar.j = true;
            }
        }
    }

    public bv(View view) {
        this.f = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.b = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.c = tapTimeout;
        this.d = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        a aVar = this.i;
        View view = this.f;
        if (aVar != null) {
            view.removeCallbacks(aVar);
        }
        a aVar2 = this.g;
        if (aVar2 != null) {
            view.removeCallbacks(aVar2);
        }
    }

    public abstract b01 b();

    public abstract boolean c();

    public boolean d() {
        b01 b01VarB = b();
        if (b01VarB == null || !b01VarB.a()) {
            return true;
        }
        b01VarB.dismiss();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005c  */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cb  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        jp jpVarN;
        boolean z2 = this.j;
        View view2 = this.f;
        int i = 1;
        int i2 = 0;
        if (z2) {
            b01 b01VarB = b();
            if (b01VarB != null && b01VarB.a() && (jpVarN = b01VarB.n()) != null && jpVarN.isShown()) {
                MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.o;
                view2.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(iArr[0], iArr[1]);
                jpVarN.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(-iArr[0], -iArr[1]);
                boolean zB = jpVarN.b(motionEventObtainNoHistory, this.n);
                motionEventObtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z3 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (zB && z3) {
                    z = true;
                } else if (d()) {
                    z = false;
                } else {
                    z = true;
                }
            } else if (d()) {
                z = true;
            } else {
                z = false;
            }
        } else {
            if (view2.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 == 0) {
                    this.n = motionEvent.getPointerId(0);
                    if (this.g == null) {
                        this.g = new a(this, i2);
                    }
                    view2.postDelayed(this.g, this.c);
                    if (this.i == null) {
                        this.i = new a(this, i);
                    }
                    view2.postDelayed(this.i, this.d);
                } else if (actionMasked2 == 1) {
                    a();
                } else if (actionMasked2 == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.n);
                    if (iFindPointerIndex >= 0) {
                        float x = motionEvent.getX(iFindPointerIndex);
                        float y = motionEvent.getY(iFindPointerIndex);
                        float f = this.b;
                        float f2 = -f;
                        if (x < f2 || y < f2 || x >= (view2.getRight() - view2.getLeft()) + f || y >= (view2.getBottom() - view2.getTop()) + f) {
                            a();
                            view2.getParent().requestDisallowInterceptTouchEvent(true);
                            if (c()) {
                                z = true;
                            }
                        }
                    }
                } else if (actionMasked2 == 3) {
                    a();
                }
                z = false;
            } else {
                z = false;
            }
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view2.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.j = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.j = false;
        this.n = -1;
        a aVar = this.g;
        if (aVar != null) {
            this.f.removeCallbacks(aVar);
        }
    }
}
