package defpackage;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class fg1 {
    public static final fg1 b;
    public final k a;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class b extends ak {
        public static Field c = null;
        public static boolean d = false;
        public static Constructor e = null;
        public static boolean f = false;
        public WindowInsets a;
        public t20 b;

        @Override // defpackage.ak
        public final fg1 b() {
            fg1 fg1VarG = fg1.g(null, this.a);
            k kVar = fg1VarG.a;
            kVar.o();
            kVar.q(this.b);
            return fg1VarG;
        }

        @Override // defpackage.ak
        public final void c(t20 t20Var) {
            this.b = t20Var;
        }

        @Override // defpackage.ak
        public final void d(t20 t20Var) {
            WindowInsets windowInsets = this.a;
            if (windowInsets != null) {
                this.a = windowInsets.replaceSystemWindowInsets(t20Var.a, t20Var.b, t20Var.c, t20Var.d);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c extends ak {
        public final WindowInsets.Builder a;

        public c() {
            super(9);
            this.a = new WindowInsets.Builder();
        }

        public c(fg1 fg1Var) {
            super(false);
            WindowInsets windowInsetsF = fg1Var.f();
            this.a = windowInsetsF != null ? new WindowInsets.Builder(windowInsetsF) : new WindowInsets.Builder();
        }

        @Override // defpackage.ak
        public final fg1 b() {
            fg1 fg1VarG = fg1.g(null, this.a.build());
            fg1VarG.a.o();
            return fg1VarG;
        }

        @Override // defpackage.ak
        public final void c(t20 t20Var) {
            this.a.setStableInsets(Insets.of(t20Var.a, t20Var.b, t20Var.c, t20Var.d));
        }

        @Override // defpackage.ak
        public final void d(t20 t20Var) {
            this.a.setSystemWindowInsets(Insets.of(t20Var.a, t20Var.b, t20Var.c, t20Var.d));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class d extends c {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class g extends k {
        public static boolean h = false;
        public static Method i;
        public static Class j;
        public static Field k;
        public static Field l;
        public final WindowInsets c;
        public t20 e;
        public fg1 f;
        public t20 g;
        public t20 m;

        public g(fg1 fg1Var, WindowInsets windowInsets) {
            super(fg1Var);
            this.e = null;
            this.c = windowInsets;
            this.m = null;
        }

        @Override // fg1.k
        public final fg1 b() {
            return fg1.g(null, this.c.consumeStableInsets());
        }

        @Override // fg1.k
        public final fg1 c() {
            return fg1.g(null, this.c.consumeSystemWindowInsets());
        }

        @Override // fg1.k
        public void d(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                defpackage.d.AnonymousClass0.m$3("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
                return;
            }
            t20 t20VarA = null;
            if (!h) {
                try {
                    i = View.class.getDeclaredMethod("getViewRootImpl", null);
                    Class<?> cls = Class.forName("android.view.View$AttachInfo");
                    j = cls;
                    k = cls.getDeclaredField("mVisibleInsets");
                    l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                    k.setAccessible(true);
                    l.setAccessible(true);
                } catch (ReflectiveOperationException e) {
                    e.getMessage();
                }
                h = true;
            }
            Method method = i;
            if (method != null && j != null && k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke != null) {
                        Rect rect = (Rect) k.get(l.get(objInvoke));
                        if (rect != null) {
                            t20VarA = t20.a(rect.left, rect.top, rect.right, rect.bottom);
                        }
                    }
                } catch (ReflectiveOperationException e2) {
                    e2.getMessage();
                }
            }
            if (t20VarA == null) {
                t20VarA = t20.e;
            }
            this.g = t20VarA;
        }

        @Override // fg1.k
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.g, ((g) obj).g);
            }
            return false;
        }

        /* JADX WARN: Code duplicated, block: B:58:0x00a4  */
        @Override // fg1.k
        public t20 f() {
            t20 t20VarA;
            t20 t20Var;
            t20 t20Var2 = t20.e;
            t20 t20VarA2 = t20Var2;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i2 & 16) != 0) {
                    if (i2 == 1) {
                        t20VarA = t20.a(0, j().b, 0, 0);
                    } else if (i2 == 2) {
                        t20 t20VarJ = j();
                        fg1 fg1Var = this.f;
                        t20 t20VarH = fg1Var != null ? fg1Var.a.h() : null;
                        int iMin = t20VarJ.d;
                        if (t20VarH != null) {
                            iMin = Math.min(iMin, t20VarH.d);
                        }
                        t20VarA = t20.a(t20VarJ.a, 0, t20VarJ.c, iMin);
                    } else if (i2 == 8) {
                        t20 t20VarJ2 = j();
                        fg1 fg1Var2 = this.f;
                        t20 t20VarH2 = fg1Var2 != null ? fg1Var2.a.h() : t20Var2;
                        int i3 = t20VarJ2.d;
                        if (i3 <= t20VarH2.d && ((t20Var = this.g) == null || t20Var.equals(t20Var2) || (i3 = this.g.d) <= t20VarH2.d)) {
                            t20VarA = t20Var2;
                        } else {
                            t20VarA = t20.a(0, 0, 0, i3);
                        }
                    } else if (i2 == 16) {
                        t20VarA = i();
                    } else if (i2 == 32) {
                        t20VarA = g();
                    } else if (i2 == 64) {
                        t20VarA = k();
                    } else if (i2 == 128) {
                        fg1 fg1Var3 = this.f;
                        vo voVarE = fg1Var3 != null ? fg1Var3.a.e() : e();
                        if (voVarE != null) {
                            int i4 = Build.VERSION.SDK_INT;
                            DisplayCutout displayCutout = voVarE.a;
                            t20VarA = t20.a(i4 >= 28 ? displayCutout.getSafeInsetLeft() : 0, i4 >= 28 ? displayCutout.getSafeInsetTop() : 0, i4 >= 28 ? displayCutout.getSafeInsetRight() : 0, i4 >= 28 ? displayCutout.getSafeInsetBottom() : 0);
                        } else {
                            t20VarA = t20Var2;
                        }
                    } else {
                        t20VarA = t20Var2;
                    }
                    t20VarA2 = t20.a(Math.max(t20VarA2.a, t20VarA.a), Math.max(t20VarA2.b, t20VarA.b), Math.max(t20VarA2.c, t20VarA.c), Math.max(t20VarA2.d, t20VarA.d));
                }
            }
            return t20VarA2;
        }

        @Override // fg1.k
        public final t20 h() {
            if (this.m == null) {
                WindowInsets windowInsets = this.c;
                this.m = t20.a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
            }
            return this.m;
        }

        @Override // fg1.k
        public final t20 j() {
            if (this.e == null) {
                WindowInsets windowInsets = this.c;
                this.e = t20.a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @Override // fg1.k
        public fg1 l(int i2, int i3, int i4, int i5) {
            ak cVar;
            fg1 fg1VarG = fg1.g(null, this.c);
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 30) {
                cVar = new d(fg1VarG);
            } else if (i6 >= 29) {
                cVar = new c(fg1VarG);
            } else {
                b bVar = new b(false);
                bVar.a = fg1VarG.f();
                cVar = bVar;
            }
            cVar.d(fg1.e(j(), i2, i3, i4, i5));
            cVar.c(fg1.e(h(), i2, i3, i4, i5));
            return cVar.b();
        }

        @Override // fg1.k
        public final boolean m() {
            return this.c.isConsumed();
        }

        @Override // fg1.k
        public final boolean n() {
            return this.c.isRound();
        }

        @Override // fg1.k
        public final void o() {
        }

        @Override // fg1.k
        public final void p(fg1 fg1Var) {
            this.f = fg1Var;
        }

        @Override // fg1.k
        public void q(t20 t20Var) {
            this.m = t20Var;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class h extends g {
        @Override // fg1.k
        public final fg1 a() {
            return fg1.g(null, this.c.consumeDisplayCutout());
        }

        @Override // fg1.k
        public final vo e() {
            DisplayCutout displayCutout = this.c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new vo(displayCutout);
        }

        @Override // fg1.g, fg1.k
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Objects.equals(this.c, hVar.c) && Objects.equals(this.g, hVar.g);
        }

        @Override // fg1.k
        public final int hashCode() {
            return this.c.hashCode();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class i extends h {
        public t20 n;
        public t20 o;
        public t20 p;

        public i(fg1 fg1Var, WindowInsets windowInsets) {
            super(fg1Var, windowInsets);
            this.n = null;
            this.o = null;
            this.p = null;
        }

        @Override // fg1.k
        public final t20 g() {
            if (this.o == null) {
                Insets mandatorySystemGestureInsets = this.c.getMandatorySystemGestureInsets();
                this.o = t20.a(mandatorySystemGestureInsets.left, mandatorySystemGestureInsets.top, mandatorySystemGestureInsets.right, mandatorySystemGestureInsets.bottom);
            }
            return this.o;
        }

        @Override // fg1.k
        public final t20 i() {
            if (this.n == null) {
                Insets systemGestureInsets = this.c.getSystemGestureInsets();
                this.n = t20.a(systemGestureInsets.left, systemGestureInsets.top, systemGestureInsets.right, systemGestureInsets.bottom);
            }
            return this.n;
        }

        @Override // fg1.k
        public final t20 k() {
            if (this.p == null) {
                Insets tappableElementInsets = this.c.getTappableElementInsets();
                this.p = t20.a(tappableElementInsets.left, tappableElementInsets.top, tappableElementInsets.right, tappableElementInsets.bottom);
            }
            return this.p;
        }

        @Override // fg1.g, fg1.k
        public final fg1 l(int i, int i2, int i3, int i4) {
            return fg1.g(null, this.c.inset(i, i2, i3, i4));
        }

        @Override // fg1.g, fg1.k
        public final void q(t20 t20Var) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class j extends i {
        public static final fg1 q = fg1.g(null, WindowInsets.CONSUMED);

        @Override // fg1.g, fg1.k
        public final void d(View view) {
        }

        @Override // fg1.g, fg1.k
        public final t20 f() {
            int iStatusBars;
            int i = 0;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i2 & 16) != 0) {
                    if (i2 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i2 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i2 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i2 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i2 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i2 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i2 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i2 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i |= iStatusBars;
                }
            }
            Insets insets = this.c.getInsets(i);
            return t20.a(insets.left, insets.top, insets.right, insets.bottom);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class k {
        public static final fg1 b;
        public final fg1 a;

        /* JADX WARN: Code duplicated, block: B:18:0x0042  */
        /* JADX WARN: Code duplicated, block: B:33:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:39:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        static {
            Constructor constructor;
            ak cVar;
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                cVar = new d();
            } else if (i >= 29) {
                cVar = new c();
            } else {
                b bVar = new b(9);
                if (!b.d) {
                    try {
                        b.c = WindowInsets.class.getDeclaredField("CONSUMED");
                    } catch (ReflectiveOperationException unused) {
                    }
                    b.d = true;
                }
                Field field = b.c;
                WindowInsets windowInsets = null;
                if (field != null) {
                    try {
                        WindowInsets windowInsets2 = (WindowInsets) field.get(null);
                        if (windowInsets2 != null) {
                            windowInsets = new WindowInsets(windowInsets2);
                        } else {
                            if (!b.f) {
                                try {
                                    b.e = WindowInsets.class.getConstructor(Rect.class);
                                } catch (ReflectiveOperationException unused2) {
                                }
                                b.f = true;
                            }
                            constructor = b.e;
                            if (constructor != null) {
                                try {
                                    windowInsets = (WindowInsets) constructor.newInstance(new Rect());
                                } catch (ReflectiveOperationException unused3) {
                                }
                            }
                        }
                    } catch (ReflectiveOperationException unused4) {
                    }
                } else {
                    if (!b.f) {
                        b.e = WindowInsets.class.getConstructor(Rect.class);
                        b.f = true;
                    }
                    constructor = b.e;
                    if (constructor != null) {
                        windowInsets = (WindowInsets) constructor.newInstance(new Rect());
                    }
                }
                bVar.a = windowInsets;
                cVar = bVar;
            }
            b = cVar.b().a.a().a.b().a.c();
        }

        public k(fg1 fg1Var) {
            this.a = fg1Var;
        }

        public fg1 a() {
            return this.a;
        }

        public fg1 b() {
            return this.a;
        }

        public fg1 c() {
            return this.a;
        }

        public void d(View view) {
        }

        public vo e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return n() == kVar.n() && m() == kVar.m() && Objects.equals(j(), kVar.j()) && Objects.equals(h(), kVar.h()) && Objects.equals(e(), kVar.e());
        }

        public t20 f() {
            return t20.e;
        }

        public t20 g() {
            return j();
        }

        public t20 h() {
            return t20.e;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
        }

        public t20 i() {
            return j();
        }

        public t20 j() {
            return t20.e;
        }

        public t20 k() {
            return j();
        }

        public fg1 l(int i, int i2, int i3, int i4) {
            return b;
        }

        public boolean m() {
            return false;
        }

        public boolean n() {
            return false;
        }

        public void o() {
        }

        public void p(fg1 fg1Var) {
        }

        public void q(t20 t20Var) {
        }
    }

    static {
        b = Build.VERSION.SDK_INT >= 30 ? j.q : k.b;
    }

    public fg1() {
        this.a = new k(this);
    }

    public fg1(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        this.a = i2 >= 30 ? new j(this, windowInsets) : i2 >= 29 ? new i(this, windowInsets) : i2 >= 28 ? new h(this, windowInsets) : new g(this, windowInsets);
    }

    public static t20 e(t20 t20Var, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, t20Var.a - i2);
        int iMax2 = Math.max(0, t20Var.b - i3);
        int iMax3 = Math.max(0, t20Var.c - i4);
        int iMax4 = Math.max(0, t20Var.d - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? t20Var : t20.a(iMax, iMax2, iMax3, iMax4);
    }

    public static fg1 g(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        fg1 fg1Var = new fg1(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = qd1.a;
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            fg1 fg1VarG = null;
            if (rootWindowInsets != null) {
                fg1VarG = g(null, rootWindowInsets);
                k kVar = fg1VarG.a;
                kVar.p(fg1VarG);
                kVar.d(view.getRootView());
            }
            k kVar2 = fg1Var.a;
            kVar2.p(fg1VarG);
            kVar2.d(view.getRootView());
        }
        return fg1Var;
    }

    public final int a() {
        return this.a.j().d;
    }

    public final int b() {
        return this.a.j().a;
    }

    public final int c() {
        return this.a.j().c;
    }

    public final int d() {
        return this.a.j().b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fg1)) {
            return false;
        }
        return Objects.equals(this.a, ((fg1) obj).a);
    }

    public final WindowInsets f() {
        k kVar = this.a;
        if (kVar instanceof g) {
            return ((g) kVar).c;
        }
        return null;
    }

    public final int hashCode() {
        k kVar = this.a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }
}
