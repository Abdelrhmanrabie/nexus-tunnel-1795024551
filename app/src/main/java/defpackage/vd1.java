package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import java.util.WeakHashMap;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class vd1 {
    public static final a x = new a();
    public int a;
    public int b;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public final float m;
    public float n;
    public int o;
    public final int p;
    public int q;
    public final OverScroller r;
    public final v3 s;
    public View t;
    public boolean u;
    public final ViewGroup v;
    public int c = -1;
    public final as0 w = new as0(7, this);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public vd1(Context context, ViewGroup viewGroup, v3 v3Var) {
        if (v3Var == null) {
            d.AnonymousClass0.m$2("Callback may not be null");
            throw null;
        }
        this.v = viewGroup;
        this.s = v3Var;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.p = i;
        this.o = i;
        this.b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.r = new OverScroller(context, x);
    }

    public final void a() {
        this.c = -1;
        float[] fArr = this.d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public final void b(View view, int i) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.v;
        if (parent != viewGroup) {
            d.AnonymousClass0.m$1("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (", viewGroup, ")");
            return;
        }
        this.t = view;
        this.c = i;
        this.s.onViewCaptured(view, i);
        p(1);
    }

    public final boolean c(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (this.q & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        float f3 = this.b;
        if (fAbs <= f3 && fAbs2 <= f3) {
            return false;
        }
        if (fAbs < fAbs2 * 0.5f) {
            this.s.getClass();
        }
        return (this.i[i] & i2) == 0 && fAbs > ((float) this.b);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0044 A[RETURN] */
    public final boolean d(View view, float f, float f2) {
        if (view != null) {
            v3 v3Var = this.s;
            boolean z = v3Var.getViewHorizontalDragRange(view) > 0;
            boolean z2 = v3Var.getViewVerticalDragRange() > 0;
            if (z && z2) {
                float f3 = (f2 * f2) + (f * f);
                int i = this.b;
                if (f3 > i * i) {
                    return true;
                }
            } else if (!z ? !(!z2 || Math.abs(f2) <= this.b) : Math.abs(f) > this.b) {
                return true;
            }
        }
        return false;
    }

    public final void e(int i) {
        float[] fArr = this.d;
        if (fArr != null) {
            int i2 = this.k;
            int i3 = 1 << i;
            if ((i3 & i2) != 0) {
                fArr[i] = 0.0f;
                this.e[i] = 0.0f;
                this.f[i] = 0.0f;
                this.g[i] = 0.0f;
                this.h[i] = 0;
                this.i[i] = 0;
                this.j[i] = 0;
                this.k = (~i3) & i2;
            }
        }
    }

    public final int f(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f = width / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i) / width) - 0.5f) * 0.47123894f)) * f) + f;
        int iAbs = Math.abs(i2);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    public final boolean g() {
        if (this.a == 2) {
            OverScroller overScroller = this.r;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.t.getLeft();
            int top = currY - this.t.getTop();
            if (left != 0) {
                View view = this.t;
                WeakHashMap weakHashMap = qd1.a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.t;
                WeakHashMap weakHashMap2 = qd1.a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.s.onViewPositionChanged(this.t, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.v.post(this.w);
            }
        }
        return this.a == 2;
    }

    public final View i(int i, int i2) {
        ViewGroup viewGroup = this.v;
        int childCount = viewGroup.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                return null;
            }
            this.s.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
    }

    public final boolean j(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        OverScroller overScroller = this.r;
        int i7 = 0;
        if (i5 == 0 && i6 == 0) {
            overScroller.abortAnimation();
            p(0);
            return false;
        }
        View view = this.t;
        int i8 = (int) this.n;
        int i9 = (int) this.m;
        int iAbs = Math.abs(i3);
        if (iAbs < i8) {
            i3 = 0;
        } else if (iAbs > i9) {
            i3 = i3 > 0 ? i9 : -i9;
        }
        int i10 = (int) this.n;
        int iAbs2 = Math.abs(i4);
        if (iAbs2 < i10) {
            i4 = i7;
        } else if (iAbs2 > i9) {
            if (i4 > 0) {
                i4 = i9;
            } else {
                i7 = -i9;
                i4 = i7;
            }
        }
        int iAbs3 = Math.abs(i5);
        int iAbs4 = Math.abs(i6);
        int iAbs5 = Math.abs(i3);
        int iAbs6 = Math.abs(i4);
        int i11 = iAbs5 + iAbs6;
        int i12 = iAbs3 + iAbs4;
        if (i3 != 0) {
            f = iAbs5;
            f2 = i11;
        } else {
            f = iAbs3;
            f2 = i12;
        }
        float f5 = f / f2;
        if (i4 != 0) {
            f3 = iAbs6;
            f4 = i11;
        } else {
            f3 = iAbs4;
            f4 = i12;
        }
        float f6 = f3 / f4;
        v3 v3Var = this.s;
        overScroller.startScroll(left, top, i5, i6, (int) ((f(i6, i4, v3Var.getViewVerticalDragRange()) * f6) + (f(i5, i3, v3Var.getViewHorizontalDragRange(view)) * f5)));
        p(2);
        return true;
    }

    public final void k(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        v3 v3Var = this.s;
        int i2 = 0;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewI = i((int) x2, (int) y);
            n(pointerId, x2, y);
            t(viewI, pointerId);
            if ((this.h[pointerId] & this.q) != 0) {
                v3Var.onEdgeTouched();
                return;
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.a == 1) {
                    int i3 = this.c;
                    if (((this.k & (1 << i3)) != 0 ? 1 : 0) == 0) {
                        return;
                    }
                    int iFindPointerIndex = motionEvent.findPointerIndex(i3);
                    float x3 = motionEvent.getX(iFindPointerIndex);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f;
                    int i4 = this.c;
                    int i5 = (int) (x3 - fArr[i4]);
                    int i6 = (int) (y2 - this.g[i4]);
                    int left = this.t.getLeft() + i5;
                    int top = this.t.getTop() + i6;
                    int left2 = this.t.getLeft();
                    int top2 = this.t.getTop();
                    if (i5 != 0) {
                        left = v3Var.clampViewPositionHorizontal(this.t, left);
                        WeakHashMap weakHashMap = qd1.a;
                        this.t.offsetLeftAndRight(left - left2);
                    }
                    if (i6 != 0) {
                        top = v3Var.clampViewPositionVertical(this.t, top);
                        WeakHashMap weakHashMap2 = qd1.a;
                        this.t.offsetTopAndBottom(top - top2);
                    }
                    if (i5 != 0 || i6 != 0) {
                        v3Var.onViewPositionChanged(this.t, left, top);
                    }
                } else {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i7 = 0; i7 < pointerCount; i7++) {
                        int pointerId2 = motionEvent.getPointerId(i7);
                        if ((this.k & (1 << pointerId2)) != 0) {
                            float x4 = motionEvent.getX(i7);
                            float y3 = motionEvent.getY(i7);
                            float f = x4 - this.d[pointerId2];
                            float f2 = y3 - this.e[pointerId2];
                            m(pointerId2, f, f2);
                            if (this.a == 1) {
                                break;
                            }
                            View viewI2 = i((int) x4, (int) y3);
                            if (d(viewI2, f, f2) && t(viewI2, pointerId2)) {
                                break;
                            }
                        }
                    }
                }
                o(motionEvent);
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int pointerId3 = motionEvent.getPointerId(actionIndex);
                    if (this.a == 1 && pointerId3 == this.c) {
                        int pointerCount2 = motionEvent.getPointerCount();
                        while (true) {
                            if (i2 >= pointerCount2) {
                                i = -1;
                                break;
                            }
                            int pointerId4 = motionEvent.getPointerId(i2);
                            if (pointerId4 != this.c) {
                                View viewI3 = i((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                                View view = this.t;
                                if (viewI3 == view && t(view, pointerId4)) {
                                    i = this.c;
                                    break;
                                }
                            }
                            i2++;
                        }
                        if (i == -1) {
                            l();
                        }
                    }
                    e(pointerId3);
                    return;
                }
                int pointerId5 = motionEvent.getPointerId(actionIndex);
                float x5 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                n(pointerId5, x5, y4);
                if (this.a == 0) {
                    t(i((int) x5, (int) y4), pointerId5);
                    if ((this.h[pointerId5] & this.q) != 0) {
                        v3Var.onEdgeTouched();
                        return;
                    }
                    return;
                }
                int i8 = (int) x5;
                int i9 = (int) y4;
                View view2 = this.t;
                if (view2 != null && i8 >= view2.getLeft() && i8 < view2.getRight() && i9 >= view2.getTop() && i9 < view2.getBottom()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    t(this.t, pointerId5);
                    return;
                }
                return;
            }
            if (this.a == 1) {
                this.u = true;
                v3Var.onViewReleased(this.t, 0.0f, 0.0f);
                this.u = false;
                if (this.a == 1) {
                    p(0);
                }
            }
        } else if (this.a == 1) {
            l();
        }
        a();
    }

    public final void l() {
        VelocityTracker velocityTracker = this.l;
        float f = this.m;
        velocityTracker.computeCurrentVelocity(InternalZipConstants.AES_HASH_ITERATIONS, f);
        float xVelocity = this.l.getXVelocity(this.c);
        float f2 = this.n;
        float fAbs = Math.abs(xVelocity);
        float f3 = 0.0f;
        if (fAbs < f2) {
            xVelocity = 0.0f;
        } else if (fAbs > f) {
            xVelocity = xVelocity > 0.0f ? f : -f;
        }
        float yVelocity = this.l.getYVelocity(this.c);
        float f4 = this.n;
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 >= f4) {
            if (fAbs2 > f) {
                if (yVelocity <= 0.0f) {
                    f = -f;
                }
                f3 = f;
            } else {
                f3 = yVelocity;
            }
        }
        this.u = true;
        this.s.onViewReleased(this.t, xVelocity, f3);
        this.u = false;
        if (this.a == 1) {
            p(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3, types: [v3] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void m(int i, float f, float f2) {
        int i2;
        boolean zC = c(f, f2, i, 1);
        ?? r0 = zC;
        if (c(f2, f, i, 4)) {
            r0 = (zC ? 1 : 0) | 4;
        }
        ?? r1 = r0;
        if (c(f, f2, i, 2)) {
            r1 = (r0 == true ? 1 : 0) | 2;
        }
        ?? r2 = r1;
        if (c(f2, f, i, 8)) {
            i2 = (r1 == true ? 1 : 0) | 8;
        }
        if (r2 == 0) {
            r2 = i2;
            return;
        }
        r2 = i2;
        int[] iArr = this.i;
        iArr[i] = (iArr[i] | r2) == true ? 1 : 0;
        this.s.onEdgeDragStarted(r2, i);
    }

    public final void n(int i, float f, float f2) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
        float[] fArr9 = this.d;
        this.f[i] = f;
        fArr9[i] = f;
        float[] fArr10 = this.e;
        this.g[i] = f2;
        fArr10[i] = f2;
        int[] iArr7 = this.h;
        int i3 = (int) f;
        int i4 = (int) f2;
        ViewGroup viewGroup = this.v;
        int i5 = i3 < viewGroup.getLeft() + this.o ? 1 : 0;
        if (i4 < viewGroup.getTop() + this.o) {
            i5 |= 4;
        }
        if (i3 > viewGroup.getRight() - this.o) {
            i5 |= 2;
        }
        if (i4 > viewGroup.getBottom() - this.o) {
            i5 |= 8;
        }
        iArr7[i] = i5;
        this.k = (1 << i) | this.k;
    }

    public final void o(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if ((this.k & (1 << pointerId)) != 0) {
                float x2 = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f[pointerId] = x2;
                this.g[pointerId] = y;
            }
        }
    }

    public final void p(int i) {
        this.v.removeCallbacks(this.w);
        if (this.a != i) {
            this.a = i;
            this.s.onViewDragStateChanged(i);
            if (this.a == 0) {
                this.t = null;
            }
        }
    }

    public final boolean q(int i, int i2) {
        if (this.u) {
            return j(i, i2, (int) this.l.getXVelocity(this.c), (int) this.l.getYVelocity(this.c));
        }
        d.AnonymousClass0.m("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00da  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:70:0x011f  */
    public final boolean r(MotionEvent motionEvent) {
        View viewI;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        v3 v3Var = this.s;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            n(pointerId, x2, y);
            View viewI2 = i((int) x2, (int) y);
            if (viewI2 == this.t && this.a == 2) {
                t(viewI2, pointerId);
            }
            if ((this.h[pointerId] & this.q) != 0) {
                v3Var.onEdgeTouched();
            }
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                a();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x3 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                n(pointerId2, x3, y2);
                int i = this.a;
                if (i == 0) {
                    if ((this.h[pointerId2] & this.q) != 0) {
                        v3Var.onEdgeTouched();
                    }
                } else if (i == 2 && (viewI = i((int) x3, (int) y2)) == this.t) {
                    t(viewI, pointerId2);
                }
            } else if (actionMasked == 6) {
                e(motionEvent.getPointerId(actionIndex));
            }
        } else if (this.d != null && this.e != null) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                int pointerId3 = motionEvent.getPointerId(i2);
                if ((this.k & (1 << pointerId3)) != 0) {
                    float x4 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x4 - this.d[pointerId3];
                    float f2 = y3 - this.e[pointerId3];
                    View viewI3 = i((int) x4, (int) y3);
                    boolean z = viewI3 != null && d(viewI3, f, f2);
                    if (!z) {
                        m(pointerId3, f, f2);
                        if (this.a != 1) {
                            break;
                        }
                    } else {
                        int left = viewI3.getLeft();
                        int iClampViewPositionHorizontal = v3Var.clampViewPositionHorizontal(viewI3, ((int) f) + left);
                        int top = viewI3.getTop();
                        int iClampViewPositionVertical = v3Var.clampViewPositionVertical(viewI3, ((int) f2) + top);
                        int viewHorizontalDragRange = v3Var.getViewHorizontalDragRange(viewI3);
                        int viewVerticalDragRange = v3Var.getViewVerticalDragRange();
                        if ((viewHorizontalDragRange == 0 || (viewHorizontalDragRange > 0 && iClampViewPositionHorizontal == left)) && (viewVerticalDragRange == 0 || (viewVerticalDragRange > 0 && iClampViewPositionVertical == top))) {
                            break;
                        }
                        m(pointerId3, f, f2);
                        if (this.a != 1 || (z && t(viewI3, pointerId3))) {
                            break;
                        }
                    }
                }
            }
            o(motionEvent);
        }
        return this.a == 1;
    }

    public final boolean s(View view, int i, int i2) {
        this.t = view;
        this.c = -1;
        boolean zJ = j(i, i2, 0, 0);
        if (!zJ && this.a == 0 && this.t != null) {
            this.t = null;
        }
        return zJ;
    }

    public final boolean t(View view, int i) {
        if (view == this.t && this.c == i) {
            return true;
        }
        if (view == null || !this.s.tryCaptureView(view, i)) {
            return false;
        }
        this.c = i;
        b(view, i);
        return true;
    }
}
