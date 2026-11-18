package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.recyclerview.widget.n;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.a1;
import defpackage.dk0;
import defpackage.e4;
import defpackage.ed1;
import defpackage.ek0;
import defpackage.fd1;
import defpackage.gk0;
import defpackage.hk0;
import defpackage.io;
import defpackage.o1;
import defpackage.qd1;
import defpackage.ud1;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements gk0, dk0 {
    public static final float H = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final a I = new a();
    public static final int[] J = {R.attr.fillViewport};
    public int A;
    public int B;
    public e C;
    public final hk0 D;
    public final ek0 E;
    public float F;
    public final io G;
    public final float b;
    public long c;
    public final Rect d;
    public final OverScroller f;
    public final EdgeEffect g;
    public final EdgeEffect i;
    public int j;
    public boolean n;
    public boolean o;
    public View p;
    public boolean q;
    public VelocityTracker r;
    public final boolean s;
    public final boolean t;
    public final int u;
    public final int v;
    public final int w;
    public int x;
    public final int[] y;
    public final int[] z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends a1 {
        @Override // defpackage.a1
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
        }

        @Override // defpackage.a1
        public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
            int scrollRange;
            AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            o1Var.i(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfo.setScrollable(true);
            if (nestedScrollView.getScrollY() > 0) {
                o1Var.b(o1.a.i);
                o1Var.b(o1.a.m);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                o1Var.b(o1.a.h);
                o1Var.b(o1.a.n);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
        
            if (r6 != r5.getScrollY()) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
        
            if (r6 != r5.getScrollY()) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
        
            r5.q(0 - r5.getScrollX(), r6 - r5.getScrollY(), true);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0087, code lost:
        
            return true;
         */
        @Override // defpackage.a1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean performAccessibilityAction(android.view.View r5, int r6, android.os.Bundle r7) {
            /*
                r4 = this;
                boolean r7 = super.performAccessibilityAction(r5, r6, r7)
                r0 = 1
                if (r7 == 0) goto L8
                return r0
            L8:
                androidx.core.widget.NestedScrollView r5 = (androidx.core.widget.NestedScrollView) r5
                boolean r7 = r5.isEnabled()
                r1 = 0
                if (r7 != 0) goto L13
                goto L88
            L13:
                int r7 = r5.getHeight()
                android.graphics.Rect r2 = new android.graphics.Rect
                r2.<init>()
                android.graphics.Matrix r3 = r5.getMatrix()
                boolean r3 = r3.isIdentity()
                if (r3 == 0) goto L30
                boolean r3 = r5.getGlobalVisibleRect(r2)
                if (r3 == 0) goto L30
                int r7 = r2.height()
            L30:
                r2 = 4096(0x1000, float:5.74E-42)
                if (r6 == r2) goto L5d
                r2 = 8192(0x2000, float:1.14794E-41)
                if (r6 == r2) goto L43
                r2 = 16908344(0x1020038, float:2.3877386E-38)
                if (r6 == r2) goto L43
                r2 = 16908346(0x102003a, float:2.3877392E-38)
                if (r6 == r2) goto L5d
                goto L88
            L43:
                int r6 = r5.getPaddingBottom()
                int r7 = r7 - r6
                int r6 = r5.getPaddingTop()
                int r7 = r7 - r6
                int r6 = r5.getScrollY()
                int r6 = r6 - r7
                int r6 = java.lang.Math.max(r6, r1)
                int r7 = r5.getScrollY()
                if (r6 == r7) goto L88
                goto L7a
            L5d:
                int r6 = r5.getPaddingBottom()
                int r7 = r7 - r6
                int r6 = r5.getPaddingTop()
                int r7 = r7 - r6
                int r6 = r5.getScrollY()
                int r6 = r6 + r7
                int r7 = r5.getScrollRange()
                int r6 = java.lang.Math.min(r6, r7)
                int r7 = r5.getScrollY()
                if (r6 == r7) goto L88
            L7a:
                int r7 = r5.getScrollX()
                int r1 = r1 - r7
                int r7 = r5.getScrollY()
                int r6 = r6 - r7
                r5.q(r1, r6, r0)
                return r0
            L88:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.a.performAccessibilityAction(android.view.View, int, android.os.Bundle):boolean");
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c {
        public c() {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface d {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();
        public int b;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Parcelable.Creator<e> {
            @Override // android.os.Parcelable.Creator
            public final e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final e[] newArray(int i) {
                return new e[i];
            }
        }

        public e(Parcel parcel) {
            super(parcel);
            this.b = parcel.readInt();
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        public final String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.b + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        EdgeEffect edgeEffect;
        EdgeEffect edgeEffect2;
        super(context, attributeSet, org.hamotunnelplus.xyz.R.style.vh);
        this.d = new Rect();
        this.n = true;
        this.o = false;
        this.p = null;
        this.q = false;
        this.t = true;
        this.x = -1;
        this.y = new int[2];
        this.z = new int[2];
        this.G = new io(getContext(), new c());
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            try {
                edgeEffect = new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                edgeEffect = new EdgeEffect(context);
            }
        } else {
            edgeEffect = new EdgeEffect(context);
        }
        this.g = edgeEffect;
        if (i >= 31) {
            try {
                edgeEffect2 = new EdgeEffect(context, attributeSet);
            } catch (Throwable unused2) {
                edgeEffect2 = new EdgeEffect(context);
            }
        } else {
            edgeEffect2 = new EdgeEffect(context);
        }
        this.i = edgeEffect2;
        this.b = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.u = viewConfiguration.getScaledTouchSlop();
        this.v = viewConfiguration.getScaledMinimumFlingVelocity();
        this.w = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, J, org.hamotunnelplus.xyz.R.style.vh, 0);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        if (z != this.s) {
            this.s = z;
            requestLayout();
        }
        typedArrayObtainStyledAttributes.recycle();
        this.D = new hk0();
        this.E = new ek0(this);
        setNestedScrollingEnabled(true);
        qd1.l(this, I);
    }

    public static boolean h(View view, NestedScrollView nestedScrollView) {
        if (view == nestedScrollView) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && h((View) parent, nestedScrollView);
    }

    public final boolean a(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int height = (int) (getHeight() * 0.5f);
        if (viewFindNextFocus == null || !i(viewFindNextFocus, height, getHeight())) {
            if (i == 33 && getScrollY() < height) {
                height = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                height = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), height);
            }
            if (height == 0) {
                return false;
            }
            if (i != 130) {
                height = -height;
            }
            o(height, 0, 1, true);
        } else {
            Rect rect = this.d;
            viewFindNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(viewFindNextFocus, rect);
            o(b(rect), 0, 1, true);
            viewFindNextFocus.requestFocus(i);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && !i(viewFindFocus, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
        } else {
            defpackage.d.AnonymousClass0.m("ScrollView can host only one direct child");
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
        } else {
            defpackage.d.AnonymousClass0.m("ScrollView can host only one direct child");
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
        } else {
            defpackage.d.AnonymousClass0.m("ScrollView can host only one direct child");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
        } else {
            defpackage.d.AnonymousClass0.m("ScrollView can host only one direct child");
        }
    }

    public final int b(Rect rect) {
        if (getChildCount() != 0) {
            int height = getHeight();
            int scrollY = getScrollY();
            int i = scrollY + height;
            int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
            if (rect.top > 0) {
                scrollY += verticalFadingEdgeLength;
            }
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
            int i3 = rect.bottom;
            if (i3 > i2 && rect.top > scrollY) {
                return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i2, (childAt.getBottom() + layoutParams.bottomMargin) - i);
            }
            if (rect.top < scrollY && i3 < i2) {
                return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
            }
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007e  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:39:0x00dd  */
    @Override // android.view.View
    public final void computeScroll() {
        int iRound;
        int[] iArr;
        int i;
        int scrollRange;
        int overScrollMode;
        OverScroller overScroller = this.f;
        if (overScroller.isFinished()) {
            return;
        }
        overScroller.computeScrollOffset();
        int currY = overScroller.getCurrY();
        int i2 = currY - this.B;
        int height = getHeight();
        EdgeEffect edgeEffect = this.i;
        EdgeEffect edgeEffect2 = this.g;
        if (i2 <= 0 || e4.a(edgeEffect2) == 0.0f) {
            if (i2 < 0 && e4.a(edgeEffect) != 0.0f) {
                float f = height;
                iRound = Math.round(e4.b(edgeEffect, (i2 * 4.0f) / f, 0.5f) * (f / 4.0f));
                if (iRound != i2) {
                    edgeEffect.finish();
                }
            }
            int i3 = i2;
            this.B = currY;
            iArr = this.z;
            iArr[1] = 0;
            this.E.c(0, i3, iArr, null, 1);
            i = i3 - iArr[1];
            scrollRange = getScrollRange();
            if (i != 0) {
                int scrollY = getScrollY();
                l(i, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                int i4 = i - scrollY2;
                iArr[1] = 0;
                this.E.e(0, scrollY2, 0, i4, this.y, 1, iArr);
                i = i4 - iArr[1];
            }
            if (i != 0) {
                overScrollMode = getOverScrollMode();
                if (overScrollMode != 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    if (i < 0) {
                        if (edgeEffect2.isFinished()) {
                            edgeEffect2.onAbsorb((int) overScroller.getCurrVelocity());
                        }
                    } else if (edgeEffect.isFinished()) {
                        edgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                    }
                }
                overScroller.abortAnimation();
                t(1);
            }
            if (overScroller.isFinished()) {
                t(1);
            } else {
                postInvalidateOnAnimation();
            }
        }
        iRound = Math.round(e4.b(edgeEffect2, ((-i2) * 4.0f) / height, 0.5f) * ((-height) / 4.0f));
        if (iRound != i2) {
            edgeEffect2.finish();
        }
        i2 -= iRound;
        int i5 = i2;
        this.B = currY;
        iArr = this.z;
        iArr[1] = 0;
        this.E.c(0, i5, iArr, null, 1);
        i = i5 - iArr[1];
        scrollRange = getScrollRange();
        if (i != 0) {
            int scrollY3 = getScrollY();
            l(i, getScrollX(), scrollY3, scrollRange);
            int scrollY4 = getScrollY() - scrollY3;
            int i6 = i - scrollY4;
            iArr[1] = 0;
            this.E.e(0, scrollY4, 0, i6, this.y, 1, iArr);
            i = i6 - iArr[1];
        }
        if (i != 0) {
            overScrollMode = getOverScrollMode();
            if (overScrollMode != 0) {
                if (i < 0) {
                    if (edgeEffect2.isFinished()) {
                        edgeEffect2.onAbsorb((int) overScroller.getCurrVelocity());
                    }
                } else if (edgeEffect.isFinished()) {
                    edgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                }
            } else if (i < 0) {
                if (edgeEffect2.isFinished()) {
                    edgeEffect2.onAbsorb((int) overScroller.getCurrVelocity());
                }
            } else if (edgeEffect.isFinished()) {
                edgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
            }
            overScroller.abortAnimation();
            t(1);
        }
        if (overScroller.isFinished()) {
            postInvalidateOnAnimation();
        } else {
            t(1);
        }
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? (scrollY - iMax) + bottom : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || e(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.E.a(f, f2, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return this.E.b(f, f2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.E.c(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.E.e(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.g;
        int paddingLeft2 = 0;
        if (!edgeEffect.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (getClipToPadding()) {
                width -= getPaddingRight() + getPaddingLeft();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (getClipToPadding()) {
                height -= getPaddingBottom() + getPaddingTop();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect2 = this.i;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (getClipToPadding()) {
            width2 -= getPaddingRight() + getPaddingLeft();
            paddingLeft2 = getPaddingLeft();
        }
        if (getClipToPadding()) {
            height2 -= getPaddingBottom() + getPaddingTop();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0033  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
    
        if (r0 != 123) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(android.view.KeyEvent r6) {
        /*
            r5 = this;
            android.graphics.Rect r0 = r5.d
            r0.setEmpty()
            int r0 = r5.getChildCount()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L33
            android.view.View r0 = r5.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            int r0 = r0.getHeight()
            int r4 = r3.topMargin
            int r0 = r0 + r4
            int r3 = r3.bottomMargin
            int r0 = r0 + r3
            int r3 = r5.getHeight()
            int r4 = r5.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r5.getPaddingBottom()
            int r3 = r3 - r4
            if (r0 <= r3) goto L33
            r0 = r1
            goto L34
        L33:
            r0 = r2
        L34:
            r3 = 130(0x82, float:1.82E-43)
            if (r0 != 0) goto L5f
            boolean r0 = r5.isFocused()
            if (r0 == 0) goto Lb7
            int r6 = r6.getKeyCode()
            r0 = 4
            if (r6 == r0) goto Lb7
            android.view.View r6 = r5.findFocus()
            if (r6 != r5) goto L4c
            r6 = 0
        L4c:
            android.view.FocusFinder r0 = android.view.FocusFinder.getInstance()
            android.view.View r6 = r0.findNextFocus(r5, r6, r3)
            if (r6 == 0) goto Lb7
            if (r6 == r5) goto Lb7
            boolean r6 = r6.requestFocus(r3)
            if (r6 == 0) goto Lb7
            return r1
        L5f:
            int r0 = r6.getAction()
            if (r0 != 0) goto Lb7
            int r0 = r6.getKeyCode()
            r1 = 19
            r4 = 33
            if (r0 == r1) goto La7
            r1 = 20
            if (r0 == r1) goto L97
            r1 = 62
            if (r0 == r1) goto L8c
            r6 = 92
            if (r0 == r6) goto Lad
            r6 = 93
            if (r0 == r6) goto L9d
            r6 = 122(0x7a, float:1.71E-43)
            if (r0 == r6) goto L88
            r6 = 123(0x7b, float:1.72E-43)
            if (r0 == r6) goto L93
            goto Lb7
        L88:
            r5.m(r4)
            return r2
        L8c:
            boolean r6 = r6.isShiftPressed()
            if (r6 == 0) goto L93
            r3 = r4
        L93:
            r5.m(r3)
            return r2
        L97:
            boolean r6 = r6.isAltPressed()
            if (r6 == 0) goto La2
        L9d:
            boolean r6 = r5.g(r3)
            return r6
        La2:
            boolean r6 = r5.a(r3)
            return r6
        La7:
            boolean r6 = r6.isAltPressed()
            if (r6 == 0) goto Lb2
        Lad:
            boolean r6 = r5.g(r4)
            return r6
        Lb2:
            boolean r6 = r5.a(r4)
            return r6
        Lb7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.e(android.view.KeyEvent):boolean");
    }

    public final void f(int i) {
        if (getChildCount() > 0) {
            this.f.fling(getScrollX(), getScrollY(), 0, i, 0, 0, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, Integer.MAX_VALUE, 0, 0);
            r(1);
            this.B = getScrollY();
            postInvalidateOnAnimation();
        }
    }

    public final boolean g(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.d;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return n(i, rect.top, rect.bottom);
    }

    @Override // android.view.View
    public final float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.ViewGroup
    public final int getNestedScrollAxes() {
        hk0 hk0Var = this.D;
        return hk0Var.b | hk0Var.a;
    }

    public final int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public final float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public final float getVerticalScrollFactorCompat() {
        if (this.F == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                defpackage.d.AnonymousClass0.m("Expected theme to define listPreferredItemHeight.");
                return 0.0f;
            }
            this.F = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.F;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.E.f(0) != null;
    }

    public final boolean i(View view, int i, int i2) {
        Rect rect = this.d;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i >= getScrollY() && rect.top - i <= getScrollY() + i2;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.E.d;
    }

    public final void j(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.E.e(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    public final void k(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.x) {
            int i = actionIndex == 0 ? 1 : 0;
            this.j = (int) motionEvent.getY(i);
            this.x = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.r;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean l(int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2;
        int i6;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i7 = i3 + i;
        if (i2 <= 0 && i2 >= 0) {
            i5 = i2;
            z = false;
        } else {
            z = true;
            i5 = 0;
        }
        if (i7 > i4) {
            z2 = true;
            i6 = i4;
        } else if (i7 < 0) {
            i4 = 0;
            z2 = true;
            i6 = i4;
        } else {
            i6 = i7;
            z2 = false;
        }
        if (z2 && this.E.f(1) == null) {
            this.f.springBack(i5, i6, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i5, i6);
        return z || z2;
    }

    public final void m(int i) {
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.d;
        if (z) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i2 = rect.top;
        int i3 = height + i2;
        rect.bottom = i3;
        n(i, i2, i3);
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    public final boolean n(int i, int i2, int i3) {
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z2 = i == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z4 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4 && z5) {
                            view = view2;
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (z5) {
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i2 < scrollY || i3 > i4) {
            o(z2 ? i2 - scrollY : i3 - i4, 0, 1, true);
            z = true;
        } else {
            z = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i);
        }
        return z;
    }

    public final int o(int i, int i2, int i3, boolean z) {
        int i4;
        int i5;
        boolean z2;
        VelocityTracker velocityTracker;
        if (i3 == 1) {
            r(i3);
        }
        boolean zC = this.E.c(0, i, this.z, this.y, i3);
        int[] iArr = this.z;
        int[] iArr2 = this.y;
        if (zC) {
            i4 = i - iArr[1];
            i5 = iArr2[1];
        } else {
            i4 = i;
            i5 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        boolean z3 = (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z;
        boolean z4 = l(i4, 0, scrollY, scrollRange) && this.E.f(i3) == null;
        int scrollY2 = getScrollY() - scrollY;
        iArr[1] = 0;
        this.E.e(0, scrollY2, 0, i4 - scrollY2, this.y, i3, iArr);
        int i6 = i5 + iArr2[1];
        int i7 = i4 - iArr[1];
        int i8 = scrollY + i7;
        EdgeEffect edgeEffect = this.i;
        EdgeEffect edgeEffect2 = this.g;
        if (i8 < 0) {
            if (z3) {
                e4.b(edgeEffect2, (-i7) / getHeight(), i2 / getWidth());
                if (!edgeEffect.isFinished()) {
                    edgeEffect.onRelease();
                }
            }
        } else if (i8 > scrollRange && z3) {
            e4.b(edgeEffect, i7 / getHeight(), 1.0f - (i2 / getWidth()));
            if (!edgeEffect2.isFinished()) {
                edgeEffect2.onRelease();
            }
        }
        if (edgeEffect2.isFinished() && edgeEffect.isFinished()) {
            z2 = z4;
        } else {
            postInvalidateOnAnimation();
            z2 = false;
        }
        if (z2 && i3 == 0 && (velocityTracker = this.r) != null) {
            velocityTracker.clear();
        }
        if (i3 == 1) {
            t(i3);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.o = false;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:70:0x011a  */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue;
        int i;
        int width;
        int i2;
        int scaledMinimumFlingVelocity;
        int scaledMaximumFlingVelocity;
        boolean z;
        int i3;
        float yVelocity;
        float f;
        float fSqrt;
        float fAbs;
        long j;
        int i4;
        int i5;
        if (motionEvent.getAction() != 8 || this.q) {
            return false;
        }
        if ((motionEvent.getSource() & 2) == 2) {
            i = 9;
            axisValue = motionEvent.getAxisValue(9);
            width = (int) motionEvent.getX();
        } else if ((motionEvent.getSource() & 4194304) == 4194304) {
            axisValue = motionEvent.getAxisValue(26);
            width = getWidth() / 2;
            i = 26;
        } else {
            axisValue = 0.0f;
            i = 0;
            width = 0;
        }
        if (axisValue == 0.0f) {
            return false;
        }
        o(-((int) (getVerticalScrollFactorCompat() * axisValue)), width, 1, (motionEvent.getSource() & 8194) == 8194);
        if (i == 0) {
            return true;
        }
        io ioVar = this.G;
        ioVar.getClass();
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        int i6 = ioVar.h;
        int[] iArr = ioVar.j;
        int i7 = 1;
        if (i6 == source && ioVar.i == deviceId && ioVar.g == i) {
            z = false;
            i2 = 0;
        } else {
            Context context = ioVar.a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int deviceId2 = motionEvent.getDeviceId();
            i2 = 0;
            int source2 = motionEvent.getSource();
            int i8 = Build.VERSION.SDK_INT;
            Method method = ud1.a;
            if (i8 >= 34) {
                scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity(deviceId2, i, source2);
            } else {
                InputDevice device = InputDevice.getDevice(deviceId2);
                if (device == null || device.getMotionRange(i, source2) == null) {
                    scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                } else {
                    Resources resources = context.getResources();
                    int identifier = (source2 == 4194304 && i == 26) ? resources.getIdentifier("config_viewMinRotaryEncoderFlingVelocity", "dimen", "android") : -1;
                    Objects.requireNonNull(viewConfiguration);
                    if (identifier == -1) {
                        scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                    } else if (identifier == 0 || (scaledMinimumFlingVelocity = resources.getDimensionPixelSize(identifier)) < 0) {
                        scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                    }
                }
            }
            iArr[0] = scaledMinimumFlingVelocity;
            int deviceId3 = motionEvent.getDeviceId();
            int source3 = motionEvent.getSource();
            if (i8 >= 34) {
                scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity(deviceId3, i, source3);
            } else {
                InputDevice device2 = InputDevice.getDevice(deviceId3);
                if (device2 == null || device2.getMotionRange(i, source3) == null) {
                    scaledMaximumFlingVelocity = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                } else {
                    Resources resources2 = context.getResources();
                    int identifier2 = (source3 == 4194304 && i == 26) ? resources2.getIdentifier("config_viewMaxRotaryEncoderFlingVelocity", "dimen", "android") : -1;
                    Objects.requireNonNull(viewConfiguration);
                    if (identifier2 == -1) {
                        scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                    } else if (identifier2 == 0 || (scaledMaximumFlingVelocity = resources2.getDimensionPixelSize(identifier2)) < 0) {
                        scaledMaximumFlingVelocity = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                    }
                }
            }
            iArr[1] = scaledMaximumFlingVelocity;
            ioVar.h = source;
            ioVar.i = deviceId;
            ioVar.g = i;
            z = true;
        }
        int i9 = iArr[i2];
        VelocityTracker velocityTracker = ioVar.e;
        if (i9 == Integer.MAX_VALUE) {
            if (velocityTracker == null) {
                return true;
            }
            velocityTracker.recycle();
            ioVar.e = null;
            return true;
        }
        if (velocityTracker == null) {
            ioVar.e = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = ioVar.e;
        Map map = ed1.a;
        velocityTracker2.addMovement(motionEvent);
        int i10 = 20;
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            Map map2 = ed1.a;
            if (!map2.containsKey(velocityTracker2)) {
                map2.put(velocityTracker2, new fd1());
            }
            fd1 fd1Var = (fd1) map2.get(velocityTracker2);
            fd1Var.getClass();
            long eventTime = motionEvent.getEventTime();
            int i11 = fd1Var.d;
            long[] jArr = fd1Var.b;
            if (i11 != 0 && eventTime - jArr[fd1Var.e] > 40) {
                fd1Var.d = i2;
                fd1Var.c = 0.0f;
            }
            int i12 = (fd1Var.e + 1) % 20;
            fd1Var.e = i12;
            int i13 = fd1Var.d;
            if (i13 != 20) {
                fd1Var.d = i13 + 1;
            }
            fd1Var.a[i12] = motionEvent.getAxisValue(26);
            jArr[fd1Var.e] = eventTime;
        }
        int i14 = InternalZipConstants.AES_HASH_ITERATIONS;
        velocityTracker2.computeCurrentVelocity(InternalZipConstants.AES_HASH_ITERATIONS, Float.MAX_VALUE);
        fd1 fd1Var2 = (fd1) ed1.a.get(velocityTracker2);
        if (fd1Var2 != null) {
            int i15 = fd1Var2.d;
            if (i15 < 2) {
                i3 = i;
                fSqrt = 0.0f;
            } else {
                int i16 = fd1Var2.e;
                int i17 = ((i16 + 20) - (i15 - 1)) % 20;
                long[] jArr2 = fd1Var2.b;
                long j2 = jArr2[i16];
                while (true) {
                    j = jArr2[i17];
                    long j3 = j2 - j;
                    i4 = fd1Var2.d;
                    if (j3 <= 100) {
                        break;
                    }
                    fd1Var2.d = i4 - 1;
                    i17 = (i17 + 1) % 20;
                }
                if (i4 < 2) {
                    i3 = i;
                    fSqrt = 0.0f;
                } else {
                    float[] fArr = fd1Var2.a;
                    if (i4 == 2) {
                        int i18 = (i17 + 1) % 20;
                        long j4 = jArr2[i18];
                        if (j == j4) {
                            i3 = i;
                            fSqrt = 0.0f;
                        } else {
                            i3 = i;
                            fSqrt = fArr[i18] / (j4 - j);
                        }
                    } else {
                        float f2 = 0.0f;
                        int i19 = 0;
                        int i20 = 0;
                        while (true) {
                            if (i19 >= fd1Var2.d - 1) {
                                break;
                            }
                            int i21 = i19 + i17;
                            long j5 = jArr2[i21 % 20];
                            int i22 = (i21 + 1) % i10;
                            if (jArr2[i22] == j5) {
                                i5 = i20;
                            } else {
                                i5 = i20 + 1;
                                float fSqrt2 = (f2 >= 0.0f ? 1.0f : -1.0f) * ((float) Math.sqrt(Math.abs(f2) * 2.0f));
                                float f3 = fArr[i22] / (jArr2[i22] - j5);
                                float fAbs2 = (Math.abs(f3) * (f3 - fSqrt2)) + f2;
                                if (i5 == i7) {
                                    fAbs2 *= 0.5f;
                                }
                                f2 = fAbs2;
                            }
                            i19++;
                            i = i;
                            i7 = 1;
                            i20 = i5;
                            i10 = 20;
                        }
                        i3 = i;
                        fSqrt = ((float) Math.sqrt(Math.abs(f2) * 2.0f)) * (f2 >= 0.0f ? 1.0f : -1.0f);
                        i14 = InternalZipConstants.AES_HASH_ITERATIONS;
                    }
                }
            }
            float f4 = fSqrt * i14;
            fd1Var2.c = f4;
            if (f4 < (-Math.abs((float) r5))) {
                fAbs = -Math.abs(Float.MAX_VALUE);
            } else if (fd1Var2.c > Math.abs((float) r5)) {
                fAbs = Math.abs((float) r5);
            }
            fd1Var2.c = fAbs;
        } else {
            i3 = i;
        }
        int i23 = i3;
        if (Build.VERSION.SDK_INT >= 34) {
            yVelocity = velocityTracker2.getAxisVelocity(i23);
        } else if (i23 == 0) {
            yVelocity = velocityTracker2.getXVelocity();
        } else if (i23 == 1) {
            yVelocity = velocityTracker2.getYVelocity();
        } else {
            fd1 fd1Var3 = (fd1) ed1.a.get(velocityTracker2);
            yVelocity = (fd1Var3 == null || i23 != 26) ? 0.0f : fd1Var3.c;
        }
        NestedScrollView nestedScrollView = NestedScrollView.this;
        float f5 = yVelocity * (-nestedScrollView.getVerticalScrollFactorCompat());
        float fSignum = Math.signum(f5);
        if (z || (fSignum != Math.signum(ioVar.f) && fSignum != 0.0f)) {
            nestedScrollView.f.abortAnimation();
        }
        if (Math.abs(f5) < iArr[0]) {
            return true;
        }
        int i24 = iArr[1];
        float fMax = Math.max(-i24, Math.min(f5, i24));
        if (fMax == 0.0f) {
            f = 0.0f;
        } else {
            nestedScrollView.f.abortAnimation();
            nestedScrollView.f((int) fMax);
            f = fMax;
        }
        ioVar.f = f;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x006d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x008f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:70:0x010f  */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int iFindPointerIndex;
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.q) {
            return true;
        }
        int i = action & 255;
        OverScroller overScroller = this.f;
        if (i == 0) {
            int y = (int) motionEvent.getY();
            int x = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y < childAt.getTop() - scrollY || y >= childAt.getBottom() - scrollY || x < childAt.getLeft() || x >= childAt.getRight()) {
                    if (!s(motionEvent) && overScroller.isFinished()) {
                        z = false;
                    }
                    this.q = z;
                    velocityTracker = this.r;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.r = null;
                    }
                } else {
                    this.j = y;
                    this.x = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker3 = this.r;
                    if (velocityTracker3 == null) {
                        this.r = VelocityTracker.obtain();
                    } else {
                        velocityTracker3.clear();
                    }
                    this.r.addMovement(motionEvent);
                    overScroller.computeScrollOffset();
                    if (!s(motionEvent) && overScroller.isFinished()) {
                        z = false;
                    }
                    this.q = z;
                    r(0);
                }
            } else {
                if (!s(motionEvent)) {
                    z = false;
                }
                this.q = z;
                velocityTracker = this.r;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.r = null;
                }
            }
        } else if (i == 1) {
            this.q = false;
            this.x = -1;
            velocityTracker2 = this.r;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.r = null;
            }
            if (overScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            t(0);
        } else if (i == 2) {
            int i2 = this.x;
            if (i2 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i2)) != -1) {
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                if (Math.abs(y2 - this.j) > this.u && (2 & getNestedScrollAxes()) == 0) {
                    this.q = true;
                    this.j = y2;
                    if (this.r == null) {
                        this.r = VelocityTracker.obtain();
                    }
                    this.r.addMovement(motionEvent);
                    this.A = 0;
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
        } else if (i == 3) {
            this.q = false;
            this.x = -1;
            velocityTracker2 = this.r;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.r = null;
            }
            if (overScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            t(0);
        } else if (i == 6) {
            k(motionEvent);
        }
        return this.q;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.n = false;
        View view = this.p;
        if (view != null && h(view, this)) {
            View view2 = this.p;
            Rect rect = this.d;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iB = b(rect);
            if (iB != 0) {
                scrollBy(0, iB);
            }
        }
        this.p = null;
        if (!this.o) {
            if (this.C != null) {
                scrollTo(getScrollX(), this.C.b);
                this.C = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < measuredHeight && scrollY >= 0) {
                i5 = paddingTop + scrollY > measuredHeight ? measuredHeight - paddingTop : scrollY;
            }
            if (i5 != scrollY) {
                scrollTo(getScrollX(), i5);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.o = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.s && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        f((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return this.E.b(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        this.E.c(i, i2, iArr, null, 0);
    }

    @Override // defpackage.fk0
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        this.E.c(i, i2, iArr, null, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        j(i4, 0, null);
    }

    @Override // defpackage.fk0
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        j(i4, i5, null);
    }

    @Override // defpackage.gk0
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        j(i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // defpackage.fk0
    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        hk0 hk0Var = this.D;
        if (i2 == 1) {
            hk0Var.b = i;
        } else {
            hk0Var.a = i;
        }
        r(i2);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        View viewFindNextFocus = rect == null ? focusFinder.findNextFocus(this, null, i) : focusFinder.findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus != null && i(viewFindNextFocus, 0, getHeight())) {
            return viewFindNextFocus.requestFocus(i, rect);
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        this.C = eVar;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.b = getScrollY();
        return eVar;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !i(viewFindFocus, 0, i4)) {
            return;
        }
        Rect rect = this.d;
        viewFindFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(viewFindFocus, rect);
        int iB = b(rect);
        if (iB != 0) {
            if (this.t) {
                q(0, iB, false);
            } else {
                scrollBy(0, iB);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // defpackage.fk0
    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // defpackage.fk0
    public final void onStopNestedScroll(View view, int i) {
        hk0 hk0Var = this.D;
        if (i == 1) {
            hk0Var.b = 0;
        } else {
            hk0Var.a = 0;
        }
        t(i);
    }

    /* JADX WARN: Code duplicated, block: B:83:0x0188 A[PHI: r2
      0x0188: PHI (r2v9 int) = (r2v8 int), (r2v18 int) binds: [B:82:0x0186, B:28:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x0193  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        int i;
        EdgeEffect edgeEffect;
        VelocityTracker velocityTracker;
        float fB;
        if (this.r == null) {
            this.r = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.A = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        float f = 0.0f;
        motionEventObtain.offsetLocation(0.0f, this.A);
        OverScroller overScroller = this.f;
        if (actionMasked != 0) {
            EdgeEffect edgeEffect2 = this.g;
            EdgeEffect edgeEffect3 = this.i;
            if (actionMasked == 1) {
                i = -1;
                VelocityTracker velocityTracker2 = this.r;
                velocityTracker2.computeCurrentVelocity(InternalZipConstants.AES_HASH_ITERATIONS, this.w);
                int yVelocity = (int) velocityTracker2.getYVelocity(this.x);
                if (Math.abs(yVelocity) >= this.v) {
                    if (e4.a(edgeEffect2) == 0.0f) {
                        yVelocity = -yVelocity;
                        if (e4.a(edgeEffect3) == 0.0f) {
                            float f2 = yVelocity;
                            if (!this.E.b(0.0f, f2)) {
                                dispatchNestedFling(0.0f, f2, true);
                            }
                        } else if (p(edgeEffect3, yVelocity)) {
                            edgeEffect = edgeEffect3;
                            edgeEffect.onAbsorb(yVelocity);
                        }
                        f(yVelocity);
                    } else if (p(edgeEffect2, yVelocity)) {
                        edgeEffect = edgeEffect2;
                        edgeEffect.onAbsorb(yVelocity);
                    } else {
                        yVelocity = -yVelocity;
                        f(yVelocity);
                    }
                } else if (overScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.x = i;
                this.q = false;
                velocityTracker = this.r;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.r = null;
                }
                t(0);
                edgeEffect2.onRelease();
                edgeEffect3.onRelease();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.x);
                if (iFindPointerIndex != -1) {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i2 = this.j - y;
                    float x = motionEvent.getX(iFindPointerIndex) / getWidth();
                    float height = i2 / getHeight();
                    if (e4.a(edgeEffect2) != 0.0f) {
                        fB = -e4.b(edgeEffect2, -height, x);
                        if (e4.a(edgeEffect2) == 0.0f) {
                            edgeEffect2.onRelease();
                        }
                        f = fB;
                    } else if (e4.a(edgeEffect3) != 0.0f) {
                        fB = e4.b(edgeEffect3, height, 1.0f - x);
                        if (e4.a(edgeEffect3) == 0.0f) {
                            edgeEffect2 = edgeEffect3;
                            edgeEffect2.onRelease();
                        }
                        f = fB;
                    }
                    int iRound = Math.round(f * getHeight());
                    if (iRound != 0) {
                        invalidate();
                    }
                    int i3 = i2 - iRound;
                    if (!this.q) {
                        int iAbs = Math.abs(i3);
                        int i4 = this.u;
                        if (iAbs > i4) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.q = true;
                            i3 = i3 > 0 ? i3 - i4 : i3 + i4;
                        }
                    }
                    if (this.q) {
                        int iO = o(i3, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.j = y - iO;
                        this.A += iO;
                    }
                }
            } else if (actionMasked == 3) {
                if (!this.q || getChildCount() <= 0) {
                    i = -1;
                } else {
                    i = -1;
                    if (overScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        postInvalidateOnAnimation();
                    }
                }
                this.x = i;
                this.q = false;
                velocityTracker = this.r;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.r = null;
                }
                t(0);
                edgeEffect2.onRelease();
                edgeEffect3.onRelease();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.j = (int) motionEvent.getY(actionIndex);
                this.x = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                k(motionEvent);
                this.j = (int) motionEvent.getY(motionEvent.findPointerIndex(this.x));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.q && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!overScroller.isFinished()) {
                overScroller.abortAnimation();
                t(1);
            }
            int y2 = (int) motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            this.j = y2;
            this.x = pointerId;
            r(0);
        }
        VelocityTracker velocityTracker3 = this.r;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public final boolean p(EdgeEffect edgeEffect, int i) {
        if (i > 0) {
            return true;
        }
        float fA = e4.a(edgeEffect) * getHeight();
        float fAbs = Math.abs(-i) * 0.35f;
        float f = this.b * 0.015f;
        double dLog = Math.log(fAbs / f);
        double d2 = H;
        return ((float) (Math.exp((d2 / (d2 - 1.0d)) * dLog) * ((double) f))) < fA;
    }

    public final void q(int i, int i2, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.c;
        OverScroller overScroller = this.f;
        if (jCurrentAnimationTimeMillis > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            overScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY, n.DEFAULT_SWIPE_ANIMATION_DURATION);
            if (z) {
                r(1);
            } else {
                t(1);
            }
            this.B = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!overScroller.isFinished()) {
                overScroller.abortAnimation();
                t(1);
            }
            scrollBy(i, i2);
        }
        this.c = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void r(int i) {
        this.E.g(2, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.n) {
            this.p = view2;
        } else {
            Rect rect = this.d;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iB = b(rect);
            if (iB != 0) {
                scrollBy(0, iB);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iB = b(rect);
        boolean z2 = iB != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iB);
                return z2;
            }
            q(0, iB, false);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        VelocityTracker velocityTracker;
        if (z && (velocityTracker = this.r) != null) {
            velocityTracker.recycle();
            this.r = null;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.n = true;
        super.requestLayout();
    }

    public final boolean s(MotionEvent motionEvent) {
        boolean z;
        EdgeEffect edgeEffect = this.g;
        if (e4.a(edgeEffect) != 0.0f) {
            e4.b(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z = true;
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.i;
        if (e4.a(edgeEffect2) == 0.0f) {
            return z;
        }
        e4.b(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i < 0) {
                i = 0;
            } else if (width + i > width2) {
                i = width2 - width;
            }
            if (height >= height2 || i2 < 0) {
                i2 = 0;
            } else if (height + i2 > height2) {
                i2 = height2 - height;
            }
            if (i == getScrollX() && i2 == getScrollY()) {
                return;
            }
            super.scrollTo(i, i2);
        }
    }

    @Override // android.view.View
    public final void setNestedScrollingEnabled(boolean z) {
        ek0 ek0Var = this.E;
        if (ek0Var.d) {
            WeakHashMap weakHashMap = qd1.a;
            ek0Var.c.stopNestedScroll();
        }
        ek0Var.d = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return this.E.g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        t(0);
    }

    public final void t(int i) {
        this.E.h(i);
    }
}
