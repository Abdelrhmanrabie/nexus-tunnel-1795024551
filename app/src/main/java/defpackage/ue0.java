package defpackage;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class ue0 implements View.OnTouchListener {
    public static final int w = ViewConfiguration.getTapTimeout();
    public final s7$a b;
    public final AccelerateInterpolator c;
    public final jp d;
    public as0 f;
    public final float[] g;
    public final float[] i;
    public final int j;
    public final int n;
    public final float[] o;
    public final float[] p;
    public final float[] q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public final jp x;

    public ue0(jp jpVar) {
        s7$a s7_a = new s7$a();
        s7_a.e = Long.MIN_VALUE;
        s7_a.g = -1L;
        s7_a.f = 0L;
        this.b = s7_a;
        this.c = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.g = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.i = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.o = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.p = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.q = fArr5;
        this.d = jpVar;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.j = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.n = w;
        s7_a.a = 500;
        s7_a.b = 500;
        this.x = jpVar;
    }

    public static float b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        return f < f2 ? f2 : f;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x003c  */
    /* JADX WARN: Code duplicated, block: B:15:0x004b  */
    /* JADX WARN: Code duplicated, block: B:17:0x0051  */
    public final float a(float f, float f2, float f3, int i) {
        float fB;
        float interpolation;
        float fB2 = b(this.g[i] * f2, 0.0f, this.i[i]);
        float fC = c(f2 - f, fB2) - c(f, fB2);
        AccelerateInterpolator accelerateInterpolator = this.c;
        if (fC >= 0.0f) {
            if (fC > 0.0f) {
                interpolation = accelerateInterpolator.getInterpolation(fC);
            } else {
                fB = 0.0f;
            }
            if (fB == 0.0f) {
                return 0.0f;
            }
            float f4 = this.o[i];
            float f5 = this.p[i];
            float f6 = this.q[i];
            float f7 = f4 * f3;
            return fB > 0.0f ? b(fB * f7, f5, f6) : -b((-fB) * f7, f5, f6);
        }
        interpolation = -accelerateInterpolator.getInterpolation(-fC);
        fB = b(interpolation, -1.0f, 1.0f);
        if (fB == 0.0f) {
            return 0.0f;
        }
        float f8 = this.o[i];
        float f9 = this.p[i];
        float f10 = this.q[i];
        float f11 = f8 * f3;
        if (fB > 0.0f) {
        }
    }

    public final float c(float f, float f2) {
        if (f2 != 0.0f) {
            int i = this.j;
            if (i == 0 || i == 1) {
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    if (this.u && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f < 0.0f) {
                return f / (-f2);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.s) {
            this.u = false;
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        s7$a s7_a = this.b;
        int i2 = (int) (jCurrentAnimationTimeMillis - s7_a.e);
        int i3 = s7_a.b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        s7_a.i = i;
        s7_a.h = s7_a.a(jCurrentAnimationTimeMillis);
        s7_a.g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        jp jpVar;
        int count;
        s7$a s7_a = this.b;
        float f = s7_a.d;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(s7_a.c);
        if (iAbs != 0 && (count = (jpVar = this.x).getCount()) != 0) {
            int childCount = jpVar.getChildCount();
            int firstVisiblePosition = jpVar.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && jpVar.getChildAt(0).getTop() >= 0)) : !(i >= count && jpVar.getChildAt(childCount - 1).getBottom() <= jpVar.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.v
            r1 = 0
            if (r0 != 0) goto L7
            goto L7d
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7d
        L17:
            r7.d()
            return r1
        L1b:
            r7.t = r2
            r7.r = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            jp r4 = r7.d
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            s7$a r9 = r7.b
            r9.c = r0
            r9.d = r8
            boolean r8 = r7.u
            if (r8 != 0) goto L7d
            boolean r8 = r7.e()
            if (r8 == 0) goto L7d
            as0 r8 = r7.f
            if (r8 != 0) goto L61
            as0 r8 = new as0
            r9 = 6
            r8.<init>(r9, r7)
            r7.f = r8
        L61:
            r7.u = r2
            r7.s = r2
            boolean r8 = r7.r
            if (r8 != 0) goto L76
            int r8 = r7.n
            if (r8 <= 0) goto L76
            as0 r9 = r7.f
            long r5 = (long) r8
            java.util.WeakHashMap r8 = defpackage.qd1.a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7b
        L76:
            as0 r8 = r7.f
            r8.run()
        L7b:
            r7.r = r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ue0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
