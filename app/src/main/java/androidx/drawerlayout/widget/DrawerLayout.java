package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import defpackage.a1;
import defpackage.ak;
import defpackage.fg1;
import defpackage.i00;
import defpackage.ip;
import defpackage.o1;
import defpackage.qd1;
import defpackage.s1;
import defpackage.t20;
import defpackage.v3;
import defpackage.vd1;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    public static final int[] J = {R.attr.colorPrimaryDark};
    public static final int[] K = {R.attr.layout_gravity};
    public static final boolean L;
    public static final boolean M;
    public static final boolean N;
    public float A;
    public float B;
    public final Drawable C;
    public WindowInsets D;
    public boolean E;
    public final ArrayList F;
    public Rect G;
    public Matrix H;
    public final a I;
    public final c b;
    public final float c;
    public final int d;
    public final int f;
    public float g;
    public final Paint i;
    public final vd1 j;
    public final vd1 n;
    public final g o;
    public final g p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public i00 y;
    public ArrayList z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements s1 {
        public a() {
        }

        @Override // defpackage.s1
        public final boolean perform(View view) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            drawerLayout.getClass();
            if (!DrawerLayout.m(view) || drawerLayout.h(view) == 2) {
                return false;
            }
            drawerLayout.b(view);
            return true;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b extends a1 {
        public final Rect a = new Rect();

        public b() {
        }

        @Override // defpackage.a1
        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            accessibilityEvent.getText();
            DrawerLayout drawerLayout = DrawerLayout.this;
            View viewF = drawerLayout.f();
            if (viewF == null) {
                return true;
            }
            int i = drawerLayout.i(viewF);
            WeakHashMap weakHashMap = qd1.a;
            Gravity.getAbsoluteGravity(i, drawerLayout.getLayoutDirection());
            return true;
        }

        @Override // defpackage.a1
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // defpackage.a1
        public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
            AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
            boolean z = DrawerLayout.L;
            View.AccessibilityDelegate accessibilityDelegate = this.mOriginalDelegate;
            if (z) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoObtain);
                o1Var.c = -1;
                accessibilityNodeInfo.setSource(view);
                WeakHashMap weakHashMap = qd1.a;
                Object parentForAccessibility = view.getParentForAccessibility();
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfo.setParent((View) parentForAccessibility);
                }
                Rect rect = this.a;
                accessibilityNodeInfoObtain.getBoundsInScreen(rect);
                accessibilityNodeInfo.setBoundsInScreen(rect);
                accessibilityNodeInfo.setVisibleToUser(accessibilityNodeInfoObtain.isVisibleToUser());
                accessibilityNodeInfo.setPackageName(accessibilityNodeInfoObtain.getPackageName());
                o1Var.i(accessibilityNodeInfoObtain.getClassName());
                accessibilityNodeInfo.setContentDescription(accessibilityNodeInfoObtain.getContentDescription());
                accessibilityNodeInfo.setEnabled(accessibilityNodeInfoObtain.isEnabled());
                accessibilityNodeInfo.setFocused(accessibilityNodeInfoObtain.isFocused());
                accessibilityNodeInfo.setAccessibilityFocused(accessibilityNodeInfoObtain.isAccessibilityFocused());
                accessibilityNodeInfo.setSelected(accessibilityNodeInfoObtain.isSelected());
                o1Var.a(accessibilityNodeInfoObtain.getActions());
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.k(childAt)) {
                        accessibilityNodeInfo.addChild(childAt);
                    }
                }
            }
            o1Var.i("androidx.drawerlayout.widget.DrawerLayout");
            accessibilityNodeInfo.setFocusable(false);
            accessibilityNodeInfo.setFocused(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) o1.a.e.a);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) o1.a.f.a);
        }

        @Override // defpackage.a1
        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.L || DrawerLayout.k(view)) {
                return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class c extends a1 {
        @Override // defpackage.a1
        public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
            AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            if (DrawerLayout.k(view)) {
                return;
            }
            accessibilityNodeInfo.setParent(null);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface d {
        void b();

        void c();

        void d(View view, float f);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class e extends ViewGroup.MarginLayoutParams {
        public final int a;
        public float b;
        public boolean c;
        public int d;

        public e() {
            super(-1, -1);
            this.a = 0;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.K);
            this.a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0;
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.a = 0;
            this.a = eVar.a;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class f extends defpackage.d {
        public static final Parcelable.Creator<f> CREATOR = new a();
        public int b;
        public int c;
        public int d;
        public int f;
        public int g;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Parcelable.ClassLoaderCreator<f> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new f[i];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = 0;
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }

        public f(Parcelable parcelable) {
            super(parcelable);
            this.b = 0;
        }

        @Override // defpackage.d, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class g extends v3 {
        public final int a;
        public vd1 b;
        public final a c = new a();

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                View viewD;
                int width;
                g gVar = g.this;
                int i = gVar.b.o;
                int i2 = gVar.a;
                boolean z = i2 == 3;
                DrawerLayout drawerLayout = DrawerLayout.this;
                if (z) {
                    viewD = drawerLayout.d(3);
                    width = (viewD != null ? -viewD.getWidth() : 0) + i;
                } else {
                    viewD = drawerLayout.d(5);
                    width = drawerLayout.getWidth() - i;
                }
                if (viewD != null) {
                    if (((!z || viewD.getLeft() >= width) && (z || viewD.getLeft() <= width)) || drawerLayout.h(viewD) != 0) {
                        return;
                    }
                    e eVar = (e) viewD.getLayoutParams();
                    gVar.b.s(viewD, width, viewD.getTop());
                    eVar.c = true;
                    drawerLayout.invalidate();
                    View viewD2 = drawerLayout.d(i2 == 3 ? 5 : 3);
                    if (viewD2 != null) {
                        drawerLayout.b(viewD2);
                    }
                    if (drawerLayout.x) {
                        return;
                    }
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    int childCount = drawerLayout.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        drawerLayout.getChildAt(i3).dispatchTouchEvent(motionEventObtain);
                    }
                    motionEventObtain.recycle();
                    drawerLayout.x = true;
                }
            }
        }

        public g(int i) {
            this.a = i;
        }

        @Override // defpackage.v3
        public final int clampViewPositionHorizontal(View view, int i) {
            int width;
            int width2;
            DrawerLayout drawerLayout = DrawerLayout.this;
            if (drawerLayout.a(view, 3)) {
                width2 = -view.getWidth();
                width = 0;
            } else {
                width = drawerLayout.getWidth();
                width2 = width - view.getWidth();
            }
            return Math.max(width2, Math.min(i, width));
        }

        @Override // defpackage.v3
        public final int clampViewPositionVertical(View view, int i) {
            return view.getTop();
        }

        @Override // defpackage.v3
        public final int getViewHorizontalDragRange(View view) {
            DrawerLayout.this.getClass();
            if (DrawerLayout.n(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // defpackage.v3
        public final void onEdgeDragStarted(int i, int i2) {
            int i3 = (i & 1) == 1 ? 3 : 5;
            DrawerLayout drawerLayout = DrawerLayout.this;
            View viewD = drawerLayout.d(i3);
            if (viewD == null || drawerLayout.h(viewD) != 0) {
                return;
            }
            this.b.b(viewD, i2);
        }

        @Override // defpackage.v3
        public final void onEdgeTouched() {
            DrawerLayout.this.postDelayed(this.c, 160L);
        }

        @Override // defpackage.v3
        public final void onViewCaptured(View view, int i) {
            ((e) view.getLayoutParams()).c = false;
            int i2 = this.a == 3 ? 5 : 3;
            DrawerLayout drawerLayout = DrawerLayout.this;
            View viewD = drawerLayout.d(i2);
            if (viewD != null) {
                drawerLayout.b(viewD);
            }
        }

        @Override // defpackage.v3
        public final void onViewDragStateChanged(int i) {
            int i2;
            View rootView;
            View view = this.b.t;
            DrawerLayout drawerLayout = DrawerLayout.this;
            int i3 = drawerLayout.j.a;
            int i4 = drawerLayout.n.a;
            if (i3 == 1 || i4 == 1) {
                i2 = 1;
            } else {
                i2 = 2;
                if (i3 != 2 && i4 != 2) {
                    i2 = 0;
                }
            }
            if (view != null && i == 0) {
                float f = ((e) view.getLayoutParams()).b;
                if (f == 0.0f) {
                    e eVar = (e) view.getLayoutParams();
                    if ((eVar.d & 1) == 1) {
                        eVar.d = 0;
                        ArrayList arrayList = drawerLayout.z;
                        if (arrayList != null) {
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                ((d) drawerLayout.z.get(size)).b();
                            }
                        }
                        drawerLayout.u(view, false);
                        drawerLayout.t(view);
                        if (drawerLayout.hasWindowFocus() && (rootView = drawerLayout.getRootView()) != null) {
                            rootView.sendAccessibilityEvent(32);
                        }
                    }
                } else if (f == 1.0f) {
                    e eVar2 = (e) view.getLayoutParams();
                    if ((eVar2.d & 1) == 0) {
                        eVar2.d = 1;
                        ArrayList arrayList2 = drawerLayout.z;
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                ((d) drawerLayout.z.get(size2)).c();
                            }
                        }
                        drawerLayout.u(view, true);
                        drawerLayout.t(view);
                        if (drawerLayout.hasWindowFocus()) {
                            drawerLayout.sendAccessibilityEvent(32);
                        }
                    }
                }
            }
            if (i2 != drawerLayout.q) {
                drawerLayout.q = i2;
                ArrayList arrayList3 = drawerLayout.z;
                if (arrayList3 != null) {
                    for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
                        ((d) drawerLayout.z.get(size3)).getClass();
                    }
                }
            }
        }

        @Override // defpackage.v3
        public final void onViewPositionChanged(View view, int i, int i2) {
            int width = view.getWidth();
            DrawerLayout drawerLayout = DrawerLayout.this;
            float width2 = (drawerLayout.a(view, 3) ? i + width : drawerLayout.getWidth() - i) / width;
            drawerLayout.s(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            drawerLayout.invalidate();
        }

        @Override // defpackage.v3
        public final void onViewReleased(View view, float f, float f2) {
            int i;
            DrawerLayout drawerLayout = DrawerLayout.this;
            drawerLayout.getClass();
            float f3 = ((e) view.getLayoutParams()).b;
            int width = view.getWidth();
            if (drawerLayout.a(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && f3 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = drawerLayout.getWidth();
                if (f < 0.0f || (f == 0.0f && f3 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.b.q(i, view.getTop());
            drawerLayout.invalidate();
        }

        @Override // defpackage.v3
        public final boolean tryCaptureView(View view, int i) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            drawerLayout.getClass();
            return DrawerLayout.n(view) && drawerLayout.a(view, this.a) && drawerLayout.h(view) == 0;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        L = true;
        M = true;
        N = i >= 29;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, org.hamotunnelplus.xyz.R.style.k1);
        this.b = new c();
        this.f = -1728053248;
        this.i = new Paint();
        this.s = true;
        this.t = 3;
        this.u = 3;
        this.v = 3;
        this.w = 3;
        this.I = new a();
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.d = (int) ((64.0f * f2) + 0.5f);
        float f3 = f2 * 400.0f;
        g gVar = new g(3);
        this.o = gVar;
        g gVar2 = new g(5);
        this.p = gVar2;
        vd1 vd1Var = new vd1(getContext(), this, gVar);
        vd1Var.b = (int) (vd1Var.b * 1.0f);
        this.j = vd1Var;
        vd1Var.q = 1;
        vd1Var.n = f3;
        gVar.b = vd1Var;
        vd1 vd1Var2 = new vd1(getContext(), this, gVar2);
        vd1Var2.b = (int) (vd1Var2.b * 1.0f);
        this.n = vd1Var2;
        vd1Var2.q = 2;
        vd1Var2.n = f3;
        gVar2.b = vd1Var2;
        setFocusableInTouchMode(true);
        WeakHashMap weakHashMap = qd1.a;
        setImportantForAccessibility(1);
        qd1.l(this, new b());
        setMotionEventSplittingEnabled(false);
        if (getFitsSystemWindows()) {
            setOnApplyWindowInsetsListener(new ip());
            setSystemUiVisibility(1280);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(J);
            try {
                this.C = typedArrayObtainStyledAttributes.getDrawable(0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, defpackage.e.m$1, org.hamotunnelplus.xyz.R.style.k1, 0);
        try {
            this.c = typedArrayObtainStyledAttributes2.hasValue(0) ? typedArrayObtainStyledAttributes2.getDimension(0, 0.0f) : getResources().getDimension(org.hamotunnelplus.xyz.R.dimen.c1);
            typedArrayObtainStyledAttributes2.recycle();
            this.F = new ArrayList();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    public static String j(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        return (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    public static boolean k(View view) {
        WeakHashMap weakHashMap = qd1.a;
        return (view.getImportantForAccessibility() == 4 || view.getImportantForAccessibility() == 2) ? false : true;
    }

    public static boolean l(View view) {
        return ((e) view.getLayoutParams()).a == 0;
    }

    public static boolean m(View view) {
        if (n(view)) {
            return (((e) view.getLayoutParams()).d & 1) == 1;
        }
        defpackage.d.AnonymousClass0.m$1("View ", view, " is not a drawer");
        return false;
    }

    public static boolean n(View view) {
        int i = ((e) view.getLayoutParams()).a;
        WeakHashMap weakHashMap = qd1.a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    public static boolean o(View view) {
        if (n(view)) {
            return ((e) view.getLayoutParams()).b > 0.0f;
        }
        defpackage.d.AnonymousClass0.m$1("View ", view, " is not a drawer");
        return false;
    }

    public final boolean a(View view, int i) {
        return (i(view) & i) == i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        ArrayList arrayList2;
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        int i3 = 0;
        boolean z = false;
        while (true) {
            arrayList2 = this.F;
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (!n(childAt)) {
                arrayList2.add(childAt);
            } else if (m(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = true;
            }
            i3++;
        }
        if (!z) {
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) arrayList2.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        arrayList2.clear();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        int i2;
        View childAt;
        super.addView(view, i, layoutParams);
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            i2 = 1;
            if (i3 >= childCount) {
                childAt = null;
                break;
            }
            childAt = getChildAt(i3);
            if ((((e) childAt.getLayoutParams()).d & 1) == 1) {
                break;
            } else {
                i3++;
            }
        }
        if (childAt != null || n(view)) {
            WeakHashMap weakHashMap = qd1.a;
            i2 = 4;
        } else {
            WeakHashMap weakHashMap2 = qd1.a;
        }
        view.setImportantForAccessibility(i2);
        if (L) {
            return;
        }
        qd1.l(view, this.b);
    }

    public final void b(View view) {
        int width;
        int top;
        vd1 vd1Var;
        if (!n(view)) {
            defpackage.d.AnonymousClass0.m$1("View ", view, " is not a sliding drawer");
            return;
        }
        e eVar = (e) view.getLayoutParams();
        if (this.s) {
            eVar.b = 0.0f;
            eVar.d = 0;
        } else {
            eVar.d |= 4;
            if (a(view, 3)) {
                width = -view.getWidth();
                top = view.getTop();
                vd1Var = this.j;
            } else {
                width = getWidth();
                top = view.getTop();
                vd1Var = this.n;
            }
            vd1Var.s(view, width, top);
        }
        invalidate();
    }

    public final void c(boolean z) {
        int width;
        int top;
        vd1 vd1Var;
        int childCount = getChildCount();
        boolean zS = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            e eVar = (e) childAt.getLayoutParams();
            if (n(childAt) && (!z || eVar.c)) {
                int width2 = childAt.getWidth();
                if (a(childAt, 3)) {
                    width = -width2;
                    top = childAt.getTop();
                    vd1Var = this.j;
                } else {
                    width = getWidth();
                    top = childAt.getTop();
                    vd1Var = this.n;
                }
                zS |= vd1Var.s(childAt, width, top);
                eVar.c = false;
            }
        }
        g gVar = this.o;
        DrawerLayout.this.removeCallbacks(gVar.c);
        g gVar2 = this.p;
        DrawerLayout.this.removeCallbacks(gVar2.c);
        if (zS) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(fMax, ((e) getChildAt(i).getLayoutParams()).b);
        }
        this.g = fMax;
        boolean zG = this.j.g();
        boolean zG2 = this.n.g();
        if (zG || zG2) {
            WeakHashMap weakHashMap = qd1.a;
            postInvalidateOnAnimation();
        }
    }

    public final View d(int i) {
        WeakHashMap weakHashMap = qd1.a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection()) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((i(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean zDispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.g <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (this.G == null) {
                this.G = new Rect();
            }
            childAt.getHitRect(this.G);
            if (this.G.contains((int) x, (int) y) && !l(childAt)) {
                if (childAt.getMatrix().isIdentity()) {
                    float scrollX = getScrollX() - childAt.getLeft();
                    float scrollY = getScrollY() - childAt.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                } else {
                    float scrollX2 = getScrollX() - childAt.getLeft();
                    float scrollY2 = getScrollY() - childAt.getTop();
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.offsetLocation(scrollX2, scrollY2);
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.H == null) {
                            this.H = new Matrix();
                        }
                        matrix.invert(this.H);
                        motionEventObtain.transform(this.H);
                    }
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (zDispatchGenericMotionEvent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        Drawable background;
        int height = getHeight();
        boolean zL = l(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i = 0;
        if (zL) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && (background = childAt.getBackground()) != null && background.getOpacity() == -1 && n(childAt) && childAt.getHeight() >= height) {
                    if (a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        float f2 = this.g;
        if (f2 > 0.0f && zL) {
            int i4 = ((int) (((this.f & (-16777216)) >>> 24) * f2)) << 24;
            Paint paint = this.i;
            paint.setColor(i4);
            canvas.drawRect(i, 0.0f, width, getHeight(), paint);
        }
        return zDrawChild;
    }

    public final View f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (n(childAt) && o(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public final int g(int i) {
        WeakHashMap weakHashMap = qd1.a;
        int layoutDirection = getLayoutDirection();
        if (i == 3) {
            int i2 = this.t;
            if (i2 != 3) {
                return i2;
            }
            int i3 = layoutDirection == 0 ? this.v : this.w;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.u;
            if (i4 != 3) {
                return i4;
            }
            int i5 = layoutDirection == 0 ? this.w : this.v;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.v;
            if (i6 != 3) {
                return i6;
            }
            int i7 = layoutDirection == 0 ? this.t : this.u;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.w;
        if (i8 != 3) {
            return i8;
        }
        int i9 = layoutDirection == 0 ? this.u : this.t;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public final int h(View view) {
        if (n(view)) {
            return g(((e) view.getLayoutParams()).a);
        }
        defpackage.d.AnonymousClass0.m$1("View ", view, " is not a drawer");
        return 0;
    }

    public final int i(View view) {
        int i = ((e) view.getLayoutParams()).a;
        WeakHashMap weakHashMap = qd1.a;
        return Gravity.getAbsoluteGravity(i, getLayoutDirection());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        if (!this.E || (drawable = this.C) == null) {
            return;
        }
        WindowInsets windowInsets = this.D;
        int systemWindowInsetTop = windowInsets != null ? windowInsets.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            drawable.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            drawable.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005e  */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View viewI;
        int actionMasked = motionEvent.getActionMasked();
        vd1 vd1Var = this.j;
        boolean zR = vd1Var.r(motionEvent) | this.n.r(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                c(true);
                this.x = false;
            } else if (actionMasked == 2) {
                int length = vd1Var.d.length;
                for (int i = 0; i < length; i++) {
                    if ((vd1Var.k & (1 << i)) != 0) {
                        float f2 = vd1Var.f[i] - vd1Var.d[i];
                        float f3 = vd1Var.g[i] - vd1Var.e[i];
                        float f4 = (f3 * f3) + (f2 * f2);
                        int i2 = vd1Var.b;
                        if (f4 > i2 * i2) {
                            g gVar = this.o;
                            DrawerLayout.this.removeCallbacks(gVar.c);
                            g gVar2 = this.p;
                            DrawerLayout.this.removeCallbacks(gVar2.c);
                            break;
                        }
                    }
                }
            } else if (actionMasked == 3) {
                c(true);
                this.x = false;
            }
            z = false;
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.A = x;
            this.B = y;
            z = this.g > 0.0f && (viewI = vd1Var.i((int) x, (int) y)) != null && l(viewI);
            this.x = false;
        }
        if (!zR && !z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (!((e) getChildAt(i3).getLayoutParams()).c) {
                }
            }
            if (!this.x) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || f() == null) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View viewF = f();
        if (viewF != null && h(viewF) == 0) {
            c(false);
        }
        return viewF != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WindowInsets rootWindowInsets;
        float f2;
        int i5;
        int measuredHeight;
        int i6;
        int i7;
        boolean z2 = true;
        this.r = true;
        int i8 = i3 - i;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (l(childAt)) {
                    int i10 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                    childAt.layout(i10, ((ViewGroup.MarginLayoutParams) eVar).topMargin, childAt.getMeasuredWidth() + i10, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f3 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (eVar.b * f3));
                        f2 = (measuredWidth + i5) / f3;
                    } else {
                        float f4 = measuredWidth;
                        int i11 = i8 - ((int) (eVar.b * f4));
                        f2 = (i8 - i11) / f4;
                        i5 = i11;
                    }
                    boolean z3 = f2 != eVar.b ? z2 : false;
                    int i12 = eVar.a & 112;
                    if (i12 != 16) {
                        if (i12 != 80) {
                            measuredHeight = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                            i6 = measuredWidth + i5;
                            i7 = measuredHeight2 + measuredHeight;
                        } else {
                            int i13 = i4 - i2;
                            measuredHeight = (i13 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - childAt.getMeasuredHeight();
                            i6 = measuredWidth + i5;
                            i7 = i13 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                        }
                        childAt.layout(i5, measuredHeight, i6, i7);
                    } else {
                        int i14 = i4 - i2;
                        int i15 = (i14 - measuredHeight2) / 2;
                        int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        if (i15 < i16) {
                            i15 = i16;
                        } else {
                            int i17 = i15 + measuredHeight2;
                            int i18 = i14 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                            if (i17 > i18) {
                                i15 = i18 - measuredHeight2;
                            }
                        }
                        childAt.layout(i5, i15, measuredWidth + i5, measuredHeight2 + i15);
                    }
                    if (z3) {
                        s(childAt, f2);
                    }
                    int i19 = eVar.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i19) {
                        childAt.setVisibility(i19);
                    }
                }
            }
            i9++;
            z2 = true;
        }
        if (N && (rootWindowInsets = getRootWindowInsets()) != null) {
            t20 t20VarI = fg1.g(null, rootWindowInsets).a.i();
            vd1 vd1Var = this.j;
            vd1Var.o = Math.max(vd1Var.p, t20VarI.a);
            vd1 vd1Var2 = this.n;
            vd1Var2.o = Math.max(vd1Var2.p, t20VarI.c);
        }
        this.r = false;
        this.s = false;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        boolean z;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                defpackage.d.AnonymousClass0.m$2("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
                return;
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        if (this.D != null) {
            WeakHashMap weakHashMap = qd1.a;
            if (getFitsSystemWindows()) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        WeakHashMap weakHashMap2 = qd1.a;
        int layoutDirection = getLayoutDirection();
        int childCount = getChildCount();
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(eVar.a, layoutDirection);
                    boolean fitsSystemWindows = childAt.getFitsSystemWindows();
                    WindowInsets windowInsetsReplaceSystemWindowInsets = this.D;
                    if (fitsSystemWindows) {
                        if (absoluteGravity == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                    } else {
                        if (absoluteGravity == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom();
                    }
                }
                if (l(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, 1073741824));
                } else {
                    if (!n(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (M) {
                        float elevation = childAt.getElevation();
                        float f2 = this.c;
                        if (elevation != f2) {
                            childAt.setElevation(f2);
                        }
                    }
                    int i4 = i(childAt) & 7;
                    boolean z4 = i4 == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        throw new IllegalStateException(ak.AnonymousClass0.m("Child drawer has absolute gravity ", j(i4), " but this DrawerLayout already has a drawer view along that edge"));
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.d + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((ViewGroup.MarginLayoutParams) eVar).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, ((ViewGroup.MarginLayoutParams) eVar).height));
                }
            }
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        View viewD;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.mSuperState);
        int i = fVar.b;
        if (i != 0 && (viewD = d(i)) != null) {
            p(viewD);
        }
        int i2 = fVar.c;
        if (i2 != 3) {
            r(i2, 3);
        }
        int i3 = fVar.d;
        if (i3 != 3) {
            r(i3, 5);
        }
        int i4 = fVar.f;
        if (i4 != 3) {
            r(i4, 8388611);
        }
        int i5 = fVar.g;
        if (i5 != 3) {
            r(i5, 8388613);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        if (M) {
            return;
        }
        WeakHashMap weakHashMap = qd1.a;
        getLayoutDirection();
        getLayoutDirection();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            e eVar = (e) getChildAt(i).getLayoutParams();
            int i2 = eVar.d;
            boolean z = i2 == 1;
            boolean z2 = i2 == 2;
            if (z || z2) {
                fVar.b = eVar.a;
                break;
            }
        }
        fVar.c = this.t;
        fVar.d = this.u;
        fVar.f = this.v;
        fVar.g = this.w;
        return fVar;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        vd1 vd1Var = this.j;
        vd1Var.k(motionEvent);
        this.n.k(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.A = x;
            this.B = y;
        } else {
            if (action == 1) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View viewI = vd1Var.i((int) x2, (int) y2);
                if (viewI != null && l(viewI)) {
                    float f2 = x2 - this.A;
                    float f3 = y2 - this.B;
                    int i = vd1Var.b;
                    if ((f3 * f3) + (f2 * f2) < i * i) {
                        int childCount = getChildCount();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= childCount) {
                                childAt = null;
                                break;
                            }
                            childAt = getChildAt(i2);
                            if ((((e) childAt.getLayoutParams()).d & 1) == 1) {
                                break;
                            }
                            i2++;
                        }
                        z = childAt == null || h(childAt) == 2;
                    }
                }
                c(z);
                return true;
            }
            if (action != 3) {
                return true;
            }
            c(true);
        }
        this.x = false;
        return true;
    }

    public final void p(View view) {
        if (!n(view)) {
            defpackage.d.AnonymousClass0.m$1("View ", view, " is not a sliding drawer");
            return;
        }
        e eVar = (e) view.getLayoutParams();
        if (this.s) {
            eVar.b = 1.0f;
            eVar.d = 1;
            u(view, true);
            t(view);
        } else {
            eVar.d |= 2;
            if (a(view, 3)) {
                this.j.s(view, 0, view.getTop());
            } else {
                this.n.s(view, getWidth() - view.getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public final void q() {
        View viewD = d(8388611);
        if (viewD == null) {
            throw new IllegalArgumentException(ak.AnonymousClass0.m("No drawer view found with gravity ", j(8388611)));
        }
        p(viewD);
    }

    public final void r(int i, int i2) {
        View viewD;
        WeakHashMap weakHashMap = qd1.a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection());
        if (i2 == 3) {
            this.t = i;
        } else if (i2 == 5) {
            this.u = i;
        } else if (i2 == 8388611) {
            this.v = i;
        } else if (i2 == 8388613) {
            this.w = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.j : this.n).a();
        }
        if (i != 1) {
            if (i == 2 && (viewD = d(absoluteGravity)) != null) {
                p(viewD);
                return;
            }
            return;
        }
        View viewD2 = d(absoluteGravity);
        if (viewD2 != null) {
            b(viewD2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            c(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.r) {
            return;
        }
        super.requestLayout();
    }

    public final void s(View view, float f2) {
        e eVar = (e) view.getLayoutParams();
        if (f2 == eVar.b) {
            return;
        }
        eVar.b = f2;
        ArrayList arrayList = this.z;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((d) this.z.get(size)).d(view, f2);
            }
        }
    }

    public final void t(View view) {
        o1.a aVar = o1.a.l;
        qd1.i(view, aVar.a());
        qd1.g(view, 0);
        if (!m(view) || h(view) == 2) {
            return;
        }
        qd1.j(view, aVar, this.I);
    }

    public final void u(View view, boolean z) {
        int i;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z || n(childAt)) && !(z && childAt == view)) {
                WeakHashMap weakHashMap = qd1.a;
                i = 4;
            } else {
                WeakHashMap weakHashMap2 = qd1.a;
                i = 1;
            }
            childAt.setImportantForAccessibility(i);
        }
    }
}
