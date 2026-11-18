package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import defpackage.qd1;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class l extends RecyclerView.n implements RecyclerView.s {
    public static final int[] C = {R.attr.state_pressed};
    public static final int[] D = new int[0];
    public int A;
    public final a B;
    public final int a;
    public final int b;
    public final StateListDrawable c;
    public final Drawable d;
    public final int e;
    public final int f;
    public final StateListDrawable g;
    public final Drawable h;
    public final int i;
    public final int j;
    public int k;
    public int l;
    public float m;
    public int n;
    public int o;
    public float p;
    public final RecyclerView s;
    public final ValueAnimator z;
    public int q = 0;
    public int r = 0;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;
    public int w = 0;
    public final int[] x = new int[2];
    public final int[] y = new int[2];

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l lVar = l.this;
            int i = lVar.A;
            ValueAnimator valueAnimator = lVar.z;
            if (i == 1) {
                valueAnimator.cancel();
            } else if (i != 2) {
                return;
            }
            lVar.A = 3;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            valueAnimator.setDuration(500);
            valueAnimator.start();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b extends RecyclerView.t {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            l lVar = l.this;
            int iComputeVerticalScrollRange = lVar.s.computeVerticalScrollRange();
            int i3 = lVar.r;
            int i4 = iComputeVerticalScrollRange - i3;
            int i5 = lVar.a;
            lVar.t = i4 > 0 && i3 >= i5;
            int iComputeHorizontalScrollRange = lVar.s.computeHorizontalScrollRange();
            int i6 = lVar.q;
            boolean z = iComputeHorizontalScrollRange - i6 > 0 && i6 >= i5;
            lVar.u = z;
            boolean z2 = lVar.t;
            if (!z2 && !z) {
                if (lVar.v != 0) {
                    lVar.g(0);
                    return;
                }
                return;
            }
            if (z2) {
                float f = i3;
                lVar.l = (int) ((((f / 2.0f) + iComputeVerticalScrollOffset) * f) / iComputeVerticalScrollRange);
                lVar.k = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
            }
            if (lVar.u) {
                float f2 = iComputeHorizontalScrollOffset;
                float f3 = i6;
                lVar.o = (int) ((((f3 / 2.0f) + f2) * f3) / iComputeHorizontalScrollRange);
                lVar.n = Math.min(i6, (i6 * i6) / iComputeHorizontalScrollRange);
            }
            int i7 = lVar.v;
            if (i7 == 0 || i7 == 1) {
                lVar.g(1);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c extends AnimatorListenerAdapter {
        public boolean b = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (this.b) {
                this.b = false;
                return;
            }
            l lVar = l.this;
            if (((Float) lVar.z.getAnimatedValue()).floatValue() == 0.0f) {
                lVar.A = 0;
                lVar.g(0);
            } else {
                lVar.A = 2;
                lVar.s.invalidate();
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            l lVar = l.this;
            lVar.c.setAlpha(iFloatValue);
            lVar.d.setAlpha(iFloatValue);
            lVar.s.invalidate();
        }
    }

    public l(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = valueAnimatorOfFloat;
        this.A = 0;
        a aVar = new a();
        this.B = aVar;
        b bVar = new b();
        this.c = stateListDrawable;
        this.d = drawable;
        this.g = stateListDrawable2;
        this.h = drawable2;
        this.e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i, drawable.getIntrinsicWidth());
        this.i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.j = Math.max(i, drawable2.getIntrinsicWidth());
        this.a = i2;
        this.b = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new d());
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.mItemDecorations;
            RecyclerView.o oVar = recyclerView2.mLayout;
            if (oVar != null) {
                oVar.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
            }
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.markItemDecorInsetsDirty();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.s;
            recyclerView3.mOnItemTouchListeners.remove(this);
            if (recyclerView3.mInterceptingOnItemTouchListener == this) {
                recyclerView3.mInterceptingOnItemTouchListener = null;
            }
            ArrayList arrayList2 = this.s.mScrollListeners;
            if (arrayList2 != null) {
                arrayList2.remove(bVar);
            }
            this.s.removeCallbacks(aVar);
        }
        this.s = recyclerView;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(this);
            recyclerView.mOnItemTouchListeners.add(this);
            recyclerView.addOnScrollListener(bVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:54:0x010c  */
    @Override // androidx.recyclerview.widget.RecyclerView.s
    public final void a(MotionEvent motionEvent) {
        int i;
        int i2;
        if (this.v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zE = e(motionEvent.getX(), motionEvent.getY());
            boolean zD = d(motionEvent.getX(), motionEvent.getY());
            if (zE || zD) {
                if (zD) {
                    this.w = 1;
                    this.p = (int) motionEvent.getX();
                } else if (zE) {
                    this.w = 2;
                    this.m = (int) motionEvent.getY();
                }
                g(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.v == 2) {
            this.m = 0.0f;
            this.p = 0.0f;
            g(1);
            this.w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.v == 2) {
            h();
            int i3 = this.w;
            RecyclerView recyclerView = this.s;
            int i4 = this.b;
            if (i3 == 1) {
                float x = motionEvent.getX();
                int[] iArr = this.y;
                iArr[0] = i4;
                int i5 = this.q - i4;
                iArr[1] = i5;
                float fMax = Math.max(i4, Math.min(i5, x));
                if (Math.abs(this.o - fMax) >= 2.0f) {
                    float f = this.p;
                    int iComputeHorizontalScrollRange = recyclerView.computeHorizontalScrollRange();
                    int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
                    int i6 = this.q;
                    int i7 = iArr[1] - iArr[0];
                    if (i7 == 0) {
                        i2 = 0;
                    } else {
                        int i8 = iComputeHorizontalScrollRange - i6;
                        i2 = (int) (((fMax - f) / i7) * i8);
                        int i9 = iComputeHorizontalScrollOffset + i2;
                        if (i9 >= i8 || i9 < 0) {
                            i2 = 0;
                        }
                    }
                    if (i2 != 0) {
                        recyclerView.scrollBy(i2, 0);
                    }
                    this.p = fMax;
                }
            }
            if (this.w == 2) {
                float y = motionEvent.getY();
                int[] iArr2 = this.x;
                iArr2[0] = i4;
                int i10 = this.r - i4;
                iArr2[1] = i10;
                float fMax2 = Math.max(i4, Math.min(i10, y));
                if (Math.abs(this.l - fMax2) < 2.0f) {
                    return;
                }
                float f2 = this.m;
                int iComputeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                int i11 = this.r;
                int i12 = iArr2[1] - iArr2[0];
                if (i12 == 0) {
                    i = 0;
                } else {
                    int i13 = iComputeVerticalScrollRange - i11;
                    i = (int) (((fMax2 - f2) / i12) * i13);
                    int i14 = iComputeVerticalScrollOffset + i;
                    if (i14 >= i13 || i14 < 0) {
                        i = 0;
                    }
                }
                if (i != 0) {
                    recyclerView.scrollBy(0, i);
                }
                this.m = fMax2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public final boolean c(MotionEvent motionEvent) {
        int i = this.v;
        if (i != 1) {
            return i == 2;
        }
        boolean zE = e(motionEvent.getX(), motionEvent.getY());
        boolean zD = d(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (!zE && !zD) {
            return false;
        }
        if (zD) {
            this.w = 1;
            this.p = (int) motionEvent.getX();
        } else if (zE) {
            this.w = 2;
            this.m = (int) motionEvent.getY();
        }
        g(2);
        return true;
    }

    public final boolean d(float f, float f2) {
        if (f2 < this.r - this.i) {
            return false;
        }
        int i = this.o;
        int i2 = this.n / 2;
        return f >= ((float) (i - i2)) && f <= ((float) (i2 + i));
    }

    public final boolean e(float f, float f2) {
        WeakHashMap weakHashMap = qd1.a;
        boolean z = this.s.getLayoutDirection() == 1;
        int i = this.e;
        if (!z ? f >= this.q - i : f <= i) {
            int i2 = this.l;
            int i3 = this.k / 2;
            if (f2 >= i2 - i3 && f2 <= i3 + i2) {
                return true;
            }
        }
        return false;
    }

    public final void g(int i) {
        int i2;
        a aVar = this.B;
        RecyclerView recyclerView = this.s;
        StateListDrawable stateListDrawable = this.c;
        if (i == 2 && this.v != 2) {
            stateListDrawable.setState(C);
            recyclerView.removeCallbacks(aVar);
        }
        if (i == 0) {
            recyclerView.invalidate();
        } else {
            h();
        }
        if (this.v != 2 || i == 2) {
            i2 = i == 1 ? 1500 : 1200;
            this.v = i;
        }
        stateListDrawable.setState(D);
        recyclerView.removeCallbacks(aVar);
        recyclerView.postDelayed(aVar, i2);
        this.v = i;
    }

    public final void h() {
        int i = this.A;
        ValueAnimator valueAnimator = this.z;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        int i;
        int i2 = this.q;
        RecyclerView recyclerView2 = this.s;
        if (i2 != recyclerView2.getWidth() || this.r != recyclerView2.getHeight()) {
            this.q = recyclerView2.getWidth();
            this.r = recyclerView2.getHeight();
            g(0);
            return;
        }
        if (this.A != 0) {
            if (this.t) {
                int i3 = this.q;
                int i4 = this.e;
                int i5 = i3 - i4;
                int i6 = this.l;
                int i7 = this.k;
                int i8 = i6 - (i7 / 2);
                StateListDrawable stateListDrawable = this.c;
                stateListDrawable.setBounds(0, 0, i4, i7);
                int i9 = this.r;
                Drawable drawable = this.d;
                drawable.setBounds(0, 0, this.f, i9);
                WeakHashMap weakHashMap = qd1.a;
                if (recyclerView2.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i4, i8);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    i = -i4;
                } else {
                    canvas.translate(i5, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i8);
                    stateListDrawable.draw(canvas);
                    i = -i5;
                }
                canvas.translate(i, -i8);
            }
            if (this.u) {
                int i10 = this.r;
                int i11 = this.i;
                int i12 = i10 - i11;
                int i13 = this.o;
                int i14 = this.n;
                int i15 = i13 - (i14 / 2);
                StateListDrawable stateListDrawable2 = this.g;
                stateListDrawable2.setBounds(0, 0, i14, i11);
                int i16 = this.q;
                Drawable drawable2 = this.h;
                drawable2.setBounds(0, 0, i16, this.j);
                canvas.translate(0.0f, i12);
                drawable2.draw(canvas);
                canvas.translate(i15, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i15, -i12);
            }
        }
    }
}
