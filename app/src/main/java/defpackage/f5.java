package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.a;
import androidx.lifecycle.e;
import com.jcraft.jzlib.GZIPHeader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class f5 extends e5 implements androidx.appcompat.view.menu.f.a, LayoutInflater.Factory2 {
    public static final o01 g0 = new o01();
    public static final int[] h0 = {R.attr.windowBackground};
    public static final boolean i0 = !"robolectric".equals(Build.FINGERPRINT);
    public static final boolean j0 = true;
    public boolean A;
    public ViewGroup B;
    public TextView C;
    public View D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public k[] M;
    public k N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public Configuration S;
    public final int T;
    public int U;
    public boolean V;
    public boolean W;
    public g X;
    public g Y;
    public boolean Z;
    public int a0;
    public boolean c0;
    public Rect d0;
    public Rect e0;
    public final Object f;
    public k6 f0;
    public final Context g;
    public Window i;
    public f j;
    public final Object n;
    public t1 o;
    public l41 p;
    public CharSequence q;
    public wk r;
    public g5 s;
    public g5 t;
    public y1 u;
    public ActionBarContextView v;
    public PopupWindow w;
    public i5 x;
    public je1 y = null;
    public final i5 b0 = new i5(this, 1);

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class f implements Window.Callback {
        public final Window.Callback b;
        public f71.b c;

        public f(Window.Callback callback) {
            if (callback != null) {
                this.b = callback;
            } else {
                d.AnonymousClass0.m$2("Window callback may not be null");
                throw null;
            }
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
            return this.b.dispatchGenericMotionEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f5.this.I(keyEvent) || this.b.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x004a  */
        /* JADX WARN: Code duplicated, block: B:29:0x004e  */
        /* JADX WARN: Code duplicated, block: B:39:0x0073  */
        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            int keyCode;
            boolean zPerformShortcut;
            androidx.appcompat.view.menu.f fVar;
            androidx.appcompat.view.menu.f fVar2;
            if (!this.b.dispatchKeyShortcutEvent(keyEvent)) {
                int keyCode2 = keyEvent.getKeyCode();
                f5 f5Var = f5.this;
                f5Var.Q();
                t1 t1Var = f5Var.o;
                if (t1Var == null || !t1Var.i(keyCode2, keyEvent)) {
                    k kVar = f5Var.N;
                    if (kVar == null) {
                        if (f5Var.N == null) {
                            k kVarO = f5Var.O(0);
                            f5Var.U(kVarO, keyEvent);
                            keyCode = keyEvent.getKeyCode();
                            if (keyEvent.isSystem()) {
                                zPerformShortcut = false;
                            } else {
                                zPerformShortcut = fVar.performShortcut(keyCode, keyEvent, 1);
                            }
                            kVarO.k = false;
                            if (zPerformShortcut) {
                            }
                        }
                        return false;
                    }
                    if (!((!keyEvent.isSystem() && (kVar.k || f5Var.U(kVar, keyEvent)) && (fVar2 = kVar.h) != null) ? fVar2.performShortcut(keyEvent.getKeyCode(), keyEvent, 1) : false)) {
                        if (f5Var.N == null) {
                            k kVarO2 = f5Var.O(0);
                            f5Var.U(kVarO2, keyEvent);
                            keyCode = keyEvent.getKeyCode();
                            if (keyEvent.isSystem() && ((kVarO2.k || f5Var.U(kVarO2, keyEvent)) && (fVar = kVarO2.h) != null)) {
                                zPerformShortcut = fVar.performShortcut(keyCode, keyEvent, 1);
                            } else {
                                zPerformShortcut = false;
                            }
                            kVarO2.k = false;
                            if (zPerformShortcut) {
                            }
                        }
                        return false;
                    }
                    k kVar2 = f5Var.N;
                    if (kVar2 != null) {
                        kVar2.l = true;
                        return true;
                    }
                }
            }
            return true;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            return this.b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return this.b.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
            return this.b.dispatchTrackballEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(ActionMode actionMode) {
            this.b.onActionModeFinished(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(ActionMode actionMode) {
            this.b.onActionModeStarted(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
            this.b.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.f)) {
                return this.b.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int i) {
            f71.b bVar = this.c;
            if (bVar != null) {
                View view = i == 0 ? new View(f71.this.a.a.getContext()) : null;
                if (view != null) {
                    return view;
                }
            }
            return this.b.onCreatePanelView(i);
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
            this.b.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
            return this.b.onMenuItemSelected(i, menuItem);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int i, Menu menu) {
            onMenuOpened$ag1(i, menu);
            if (i == 108) {
                f5 f5Var = f5.this;
                f5Var.Q();
                t1 t1Var = f5Var.o;
                if (t1Var != null) {
                    t1Var.c(true);
                }
            }
            return true;
        }

        public final boolean onMenuOpened$ag1(int i, Menu menu) {
            return this.b.onMenuOpened(i, menu);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int i, Menu menu) {
            onPanelClosed$ag1(i, menu);
            f5 f5Var = f5.this;
            if (i == 108) {
                f5Var.Q();
                t1 t1Var = f5Var.o;
                if (t1Var != null) {
                    t1Var.c(false);
                    return;
                }
                return;
            }
            if (i == 0) {
                k kVarO = f5Var.O(i);
                if (kVarO.m) {
                    f5Var.G(kVarO, false);
                }
            }
        }

        public final void onPanelClosed$ag1(int i, Menu menu) {
            this.b.onPanelClosed(i, menu);
        }

        @Override // android.view.Window.Callback
        public final void onPointerCaptureChanged(boolean z) {
            this.b.onPointerCaptureChanged(z);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.f fVar = menu instanceof androidx.appcompat.view.menu.f ? (androidx.appcompat.view.menu.f) menu : null;
            if (i == 0 && fVar == null) {
                return false;
            }
            if (fVar != null) {
                fVar.mOverrideVisibleItems = true;
            }
            f71.b bVar = this.c;
            if (bVar != null && i == 0) {
                f71 f71Var = f71.this;
                if (!f71Var.d) {
                    f71Var.a.m = true;
                    f71Var.d = true;
                }
            }
            boolean zOnPreparePanel = this.b.onPreparePanel(i, view, menu);
            if (fVar != null) {
                fVar.mOverrideVisibleItems = false;
            }
            return zOnPreparePanel;
        }

        @Override // android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
            androidx.appcompat.view.menu.f fVar = f5.this.O(0).h;
            if (fVar != null) {
                onProvideKeyboardShortcuts$ag1(list, fVar, i);
            } else {
                onProvideKeyboardShortcuts$ag1(list, menu, i);
            }
        }

        public final void onProvideKeyboardShortcuts$ag1(List list, Menu menu, int i) {
            this.b.onProvideKeyboardShortcuts(list, menu, i);
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return this.b.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(SearchEvent searchEvent) {
            return this.b.onSearchRequested(searchEvent);
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
            this.b.onWindowAttributesChanged(layoutParams);
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean z) {
            this.b.onWindowFocusChanged(z);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (i != 0) {
                return this.b.onWindowStartingActionMode(callback, i);
            }
            f5 f5Var = f5.this;
            oo ooVar = new oo(f5Var.g, callback);
            y1 y1VarB = f5Var.B(ooVar);
            if (y1VarB != null) {
                return ooVar.e(y1VarB);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class g extends k8 {
        public final /* synthetic */ int G0 = 0;
        public final Object c;

        public g(Context context) {
            super(f5.this);
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        public g(m6 m6Var) {
            super(f5.this);
            this.c = m6Var;
        }

        @Override // defpackage.k8
        public final IntentFilter b() {
            IntentFilter intentFilter;
            String str;
            if (this.G0 != 0) {
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.TIME_SET");
                intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                str = "android.intent.action.TIME_TICK";
            } else {
                intentFilter = new IntentFilter();
                str = "android.os.action.POWER_SAVE_MODE_CHANGED";
            }
            intentFilter.addAction(str);
            return intentFilter;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x003c  */
        @Override // defpackage.k8
        public final int c() {
            Location lastKnownLocation;
            boolean z;
            long j;
            int i = this.G0;
            Object obj = this.c;
            if (i == 0) {
                return ((PowerManager) obj).isPowerSaveMode() ? 2 : 1;
            }
            m6 m6Var = (m6) obj;
            n81$a n81_a = (n81$a) m6Var.b;
            if (n81_a.b > System.currentTimeMillis()) {
                z = n81_a.a;
            } else {
                Context context = (Context) m6Var.c;
                int iE0 = e.E0(context, "android.permission.ACCESS_COARSE_LOCATION");
                LocationManager locationManager = (LocationManager) m6Var.a;
                Location lastKnownLocation2 = null;
                if (iE0 == 0) {
                    try {
                        if (locationManager.isProviderEnabled("network")) {
                            lastKnownLocation = locationManager.getLastKnownLocation("network");
                        } else {
                            lastKnownLocation = null;
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    lastKnownLocation = null;
                }
                if (e.E0(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    try {
                        if (locationManager.isProviderEnabled("gps")) {
                            lastKnownLocation2 = locationManager.getLastKnownLocation("gps");
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (lastKnownLocation2 == null || lastKnownLocation == null ? lastKnownLocation2 != null : lastKnownLocation2.getTime() > lastKnownLocation.getTime()) {
                    lastKnownLocation = lastKnownLocation2;
                }
                boolean z2 = false;
                if (lastKnownLocation != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (m81.d == null) {
                        m81.d = new m81();
                    }
                    m81 m81Var = m81.d;
                    m81Var.a(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), jCurrentTimeMillis - 86400000);
                    m81Var.a(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), jCurrentTimeMillis);
                    z2 = m81Var.c == 1;
                    long j2 = m81Var.b;
                    long j3 = m81Var.a;
                    m81Var.a(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), 86400000 + jCurrentTimeMillis);
                    long j4 = m81Var.b;
                    if (j2 == -1 || j3 == -1) {
                        j = jCurrentTimeMillis + 43200000;
                    } else {
                        if (jCurrentTimeMillis > j3) {
                            j2 = j4;
                        } else if (jCurrentTimeMillis > j2) {
                            j2 = j3;
                        }
                        j = j2 + 60000;
                    }
                    n81_a.a = z2;
                    n81_a.b = j;
                } else {
                    int i2 = Calendar.getInstance().get(11);
                    if (i2 < 6 || i2 >= 22) {
                        z = true;
                    }
                }
                z = z2;
            }
            return z ? 2 : 1;
        }

        @Override // defpackage.k8
        public final void d() {
            f5.this.C(true);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class j extends ContentFrameLayout {
        public j(yh yhVar) {
            super(yhVar, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f5.this.I(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    f5 f5Var = f5.this;
                    f5Var.G(f5Var.O(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(e.s(getContext(), i));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class k {
        public final int a;
        public int b;
        public int c;
        public int d;
        public j e;
        public View f;
        public View g;
        public androidx.appcompat.view.menu.f h;
        public d i;
        public yh j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n = false;
        public boolean o;
        public Bundle p;

        public k(int i) {
            this.a = i;
        }
    }

    public f5(Context context, Window window, a5 a5Var, Object obj) {
        w4 w4Var;
        this.T = -100;
        this.g = context;
        this.n = a5Var;
        this.f = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (context instanceof w4) {
                        w4Var = (w4) context;
                        break;
                    } else if (context instanceof ContextWrapper) {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                w4Var = null;
                break;
            }
            if (w4Var != null) {
                this.T = ((f5) w4Var.getDelegate()).T;
            }
        }
        if (this.T == -100) {
            String name = this.f.getClass().getName();
            o01 o01Var = g0;
            Integer num = (Integer) o01Var.getOrDefault(name, null);
            if (num != null) {
                this.T = num.intValue();
                o01Var.remove(this.f.getClass().getName());
            }
        }
        if (window != null) {
            D(window);
        }
        o5.d();
    }

    public static Configuration H(Context context, int i, Configuration configuration) {
        int i2;
        if (i != 1) {
            i2 = i != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i2 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    @Override // defpackage.e5
    public final void A(CharSequence charSequence) {
        this.q = charSequence;
        wk wkVar = this.r;
        if (wkVar != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) wkVar;
            actionBarOverlayLayout.m();
            actionBarOverlayLayout.g.setWindowTitle(charSequence);
            return;
        }
        t1 t1Var = this.o;
        if (t1Var != null) {
            t1Var.r(charSequence);
            return;
        }
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0132  */
    /* JADX WARN: Type inference failed for: r2v1, types: [a5, java.lang.Object] */
    @Override // defpackage.e5
    public final y1 B(y1.a aVar) {
        y1 y1VarOnWindowStartingSupportActionMode;
        boolean z;
        ViewGroup viewGroup;
        if (aVar == null) {
            d.AnonymousClass0.m$2("ActionMode callback can not be null.");
            return null;
        }
        y1 y1Var = this.u;
        if (y1Var != null) {
            y1Var.a();
        }
        defpackage.g gVar = new defpackage.g(10, this, aVar);
        Q();
        t1 t1Var = this.o;
        ?? r2 = this.n;
        if (t1Var != null) {
            y1 y1VarS = t1Var.s(gVar);
            this.u = y1VarS;
            if (y1VarS != null) {
                r2.onSupportActionModeStarted(y1VarS);
            }
        }
        if (this.u == null) {
            je1 je1Var = this.y;
            if (je1Var != null) {
                je1Var.b();
            }
            y1 y1Var2 = this.u;
            if (y1Var2 != null) {
                y1Var2.a();
            }
            if (this.R) {
                y1VarOnWindowStartingSupportActionMode = null;
            } else {
                try {
                    y1VarOnWindowStartingSupportActionMode = r2.onWindowStartingSupportActionMode(gVar);
                } catch (AbstractMethodError unused) {
                    y1VarOnWindowStartingSupportActionMode = null;
                }
            }
            if (y1VarOnWindowStartingSupportActionMode != null) {
                this.u = y1VarOnWindowStartingSupportActionMode;
            } else {
                int i = 0;
                if (this.v == null) {
                    if (this.J) {
                        TypedValue typedValue = new TypedValue();
                        Context context = this.g;
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(org.hamotunnelplus.xyz.R.style.q, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            yh yhVar = new yh(context, 0);
                            yhVar.getTheme().setTo(themeNewTheme);
                            context = yhVar;
                        }
                        this.v = new ActionBarContextView(context, null);
                        PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, org.hamotunnelplus.xyz.R.style.a5);
                        this.w = popupWindow;
                        popupWindow.setWindowLayoutType(2);
                        this.w.setContentView(this.v);
                        this.w.setWidth(-1);
                        context.getTheme().resolveAttribute(org.hamotunnelplus.xyz.R.style.k, typedValue, true);
                        this.v.g = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
                        this.w.setHeight(-2);
                        this.x = new i5(this, i);
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.B.findViewById(org.hamotunnelplus.xyz.R.attr.bs);
                        if (viewStubCompat != null) {
                            viewStubCompat.f = LayoutInflater.from(M());
                            this.v = (ActionBarContextView) viewStubCompat.a();
                        }
                    }
                }
                if (this.v != null) {
                    je1 je1Var2 = this.y;
                    if (je1Var2 != null) {
                        je1Var2.b();
                    }
                    this.v.h();
                    k21 k21Var = new k21(this.v.getContext(), this.v, gVar);
                    if (((y1.a) gVar.a).b(k21Var, k21Var.n)) {
                        k21Var.g();
                        this.v.f(k21Var);
                        this.u = k21Var;
                        if (this.A && (viewGroup = this.B) != null) {
                            WeakHashMap weakHashMap = qd1.a;
                            z = viewGroup.isLaidOut();
                        }
                        ActionBarContextView actionBarContextView = this.v;
                        if (z) {
                            actionBarContextView.setAlpha(0.0f);
                            je1 je1VarA = qd1.a(this.v);
                            je1VarA.a(1.0f);
                            this.y = je1VarA;
                            je1VarA.d(new j5(i, this));
                        } else {
                            actionBarContextView.setAlpha(1.0f);
                            this.v.setVisibility(0);
                            if (this.v.getParent() instanceof View) {
                                View view = (View) this.v.getParent();
                                WeakHashMap weakHashMap2 = qd1.a;
                                view.requestApplyInsets();
                            }
                        }
                        if (this.w != null) {
                            this.i.getDecorView().post(this.x);
                        }
                    } else {
                        this.u = null;
                    }
                }
            }
            y1 y1Var3 = this.u;
            if (y1Var3 != null) {
                r2.onSupportActionModeStarted(y1Var3);
            }
            this.u = this.u;
        }
        return this.u;
    }

    /* JADX WARN: Code duplicated, block: B:92:0x0133 A[PHI: r4
      0x0133: PHI (r4v13 java.lang.Object) = (r4v12 java.lang.Object), (r4v16 java.lang.Object) binds: [B:90:0x0130, B:81:0x0116] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean C(boolean z) {
        boolean z2;
        Object obj;
        int i;
        int i2 = 0;
        if (this.R) {
            return false;
        }
        int i3 = this.T;
        if (i3 == -100) {
            i3 = e5.b;
        }
        Context context = this.g;
        int iR = R(context, i3);
        Object obj2 = null;
        Configuration configurationH = H(context, iR, null);
        boolean z3 = this.W;
        Object obj3 = this.f;
        boolean z4 = 1;
        z4 = 1;
        z4 = 1;
        z4 = 1;
        z4 = 1;
        z4 = 1;
        if (z3 || !(obj3 instanceof Activity)) {
            this.W = true;
            z2 = this.V;
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                z2 = false;
            } else {
                try {
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 29) {
                        i = 269221888;
                    } else {
                        i = i4 >= 24 ? 786432 : 0;
                    }
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, obj3.getClass()), i);
                    this.V = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
                } catch (PackageManager.NameNotFoundException unused) {
                    this.V = false;
                }
                this.W = true;
                z2 = this.V;
            }
        }
        Configuration configuration = this.S;
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int i5 = configuration.uiMode & 48;
        int i6 = configurationH.uiMode & 48;
        if (i5 != i6 && z && !z2 && this.P && ((i0 || this.Q) && (obj3 instanceof Activity))) {
            Activity activity = (Activity) obj3;
            if (!activity.isChild()) {
                if (Build.VERSION.SDK_INT >= 28) {
                    activity.recreate();
                } else {
                    new Handler(activity.getMainLooper()).post(new jf(activity, z4 ? 1 : 0, i2));
                }
                i2 = 1;
            }
        }
        if (i2 != 0 || i5 == i6) {
            z4 = i2;
        } else {
            Resources resources = context.getResources();
            Configuration configuration2 = new Configuration(resources.getConfiguration());
            configuration2.uiMode = i6 | (resources.getConfiguration().uiMode & (-49));
            resources.updateConfiguration(configuration2, null);
            int i7 = Build.VERSION.SDK_INT;
            if (i7 < 26 && i7 < 28) {
                if (i7 >= 24) {
                    if (!v3.h) {
                        try {
                            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                            v3.g = declaredField;
                            declaredField.setAccessible(true);
                        } catch (NoSuchFieldException unused2) {
                        }
                        v3.h = true;
                    }
                    Field field = v3.g;
                    if (field != null) {
                        try {
                            obj = field.get(resources);
                        } catch (IllegalAccessException unused3) {
                            obj = null;
                        }
                        if (obj != null) {
                            if (!v3.f57b) {
                                try {
                                    Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                                    v3.a = declaredField2;
                                    declaredField2.setAccessible(true);
                                } catch (NoSuchFieldException unused4) {
                                }
                                v3.f57b = true;
                            }
                            Field field2 = v3.a;
                            if (field2 != null) {
                                try {
                                    obj2 = field2.get(obj);
                                } catch (IllegalAccessException unused5) {
                                }
                            }
                            if (obj2 != null) {
                                v3.a(obj2);
                            }
                        }
                    }
                } else {
                    if (!v3.f57b) {
                        try {
                            Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                            v3.a = declaredField3;
                            declaredField3.setAccessible(true);
                        } catch (NoSuchFieldException unused6) {
                        }
                        v3.f57b = true;
                    }
                    Field field3 = v3.a;
                    if (field3 != null) {
                        try {
                            obj2 = field3.get(resources);
                        } catch (IllegalAccessException unused7) {
                        }
                    }
                    if (obj2 != null) {
                        v3.a(obj2);
                    }
                }
            }
            int i8 = this.U;
            if (i8 != 0) {
                context.setTheme(i8);
                context.getTheme().applyStyle(this.U, true);
            }
            if (z2 && (obj3 instanceof Activity)) {
                Activity activity2 = (Activity) obj3;
                if (!(activity2 instanceof he0) ? !(!this.Q || this.R) : ((he0) activity2).getLifecycle().b().compareTo(e.b.CREATED) >= 0) {
                    activity2.onConfigurationChanged(configuration2);
                }
            }
        }
        if (z4 != 0 && (obj3 instanceof w4)) {
            ((w4) obj3).onNightModeChanged(iR);
        }
        if (i3 == 0) {
            N(context).e();
        } else {
            g gVar = this.X;
            if (gVar != null) {
                gVar.a();
            }
        }
        g gVar2 = this.Y;
        if (i3 == 3) {
            if (gVar2 == null) {
                this.Y = new g(context);
            }
            this.Y.e();
        } else if (gVar2 != null) {
            gVar2.a();
        }
        return z4;
    }

    public final void D(Window window) {
        int resourceId;
        Drawable drawableG;
        if (this.i != null) {
            d.AnonymousClass0.m("AppCompat has already installed itself into the Window");
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof f) {
            d.AnonymousClass0.m("AppCompat has already installed itself into the Window");
            return;
        }
        f fVar = new f(callback);
        this.j = fVar;
        window.setCallback(fVar);
        int[] iArr = h0;
        Context context = this.g;
        Drawable drawable = null;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        if (typedArrayObtainStyledAttributes.hasValue(0) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) != 0) {
            o5 o5VarA = o5.a();
            synchronized (o5VarA) {
                drawableG = o5VarA.a.g(context, resourceId, true);
            }
            drawable = drawableG;
        }
        if (drawable != null) {
            window.setBackgroundDrawable(drawable);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.i = window;
    }

    public final void E(int i, k kVar, androidx.appcompat.view.menu.f fVar) {
        if (fVar == null) {
            if (kVar == null && i >= 0) {
                k[] kVarArr = this.M;
                if (i < kVarArr.length) {
                    kVar = kVarArr[i];
                }
            }
            if (kVar != null) {
                fVar = kVar.h;
            }
        }
        if ((kVar == null || kVar.m) && !this.R) {
            this.j.b.onPanelClosed(i, fVar);
        }
    }

    public final void F(androidx.appcompat.view.menu.f fVar) {
        if (this.L) {
            return;
        }
        this.L = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.r;
        actionBarOverlayLayout.m();
        actionBarOverlayLayout.g.o();
        Window.Callback callback = this.i.getCallback();
        if (callback != null && !this.R) {
            callback.onPanelClosed(108, fVar);
        }
        this.L = false;
    }

    public final void G(k kVar, boolean z) {
        j jVar;
        wk wkVar;
        if (z && kVar.a == 0 && (wkVar = this.r) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) wkVar;
            actionBarOverlayLayout.m();
            if (actionBarOverlayLayout.g.a.isOverflowMenuShowing()) {
                F(kVar.h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.g.getSystemService("window");
        if (windowManager != null && kVar.m && (jVar = kVar.e) != null) {
            windowManager.removeView(jVar);
            if (z) {
                E(kVar.a, kVar, null);
            }
        }
        kVar.k = false;
        kVar.l = false;
        kVar.m = false;
        kVar.f = null;
        kVar.n = true;
        if (this.N == kVar) {
            this.N = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0148 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e1  */
    public final boolean I(KeyEvent keyEvent) {
        View decorView;
        boolean z;
        boolean z2;
        boolean zShowOverflowMenu;
        boolean zU;
        AudioManager audioManager;
        ActionMenuView actionMenuView;
        a aVar;
        Object obj = this.f;
        if (((!(obj instanceof jb0$a) && !(obj instanceof androidx.appcompat.app.f)) || (decorView = this.i.getDecorView()) == null || !ak.a(decorView, keyEvent)) && (keyEvent.getKeyCode() != 82 || !this.j.b.dispatchKeyEvent(keyEvent))) {
            int keyCode = keyEvent.getKeyCode();
            if (keyEvent.getAction() == 0) {
                if (keyCode == 4) {
                    this.O = (keyEvent.getFlags() & 128) != 0;
                    return false;
                }
                if (keyCode == 82) {
                    if (keyEvent.getRepeatCount() == 0) {
                        k kVarO = O(0);
                        if (!kVarO.m) {
                            U(kVarO, keyEvent);
                            return true;
                        }
                    }
                }
                return false;
            }
            if (keyCode != 4) {
                if (keyCode == 82) {
                    if (this.u == null) {
                        k kVarO2 = O(0);
                        wk wkVar = this.r;
                        Context context = this.g;
                        if (wkVar != null) {
                            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) wkVar;
                            actionBarOverlayLayout.m();
                            Toolbar toolbar = actionBarOverlayLayout.g.a;
                            if (toolbar.getVisibility() != 0 || (actionMenuView = toolbar.mMenuView) == null || !actionMenuView.f || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                                z2 = kVarO2.m;
                                if (!z2 || kVarO2.l) {
                                    G(kVarO2, true);
                                    zShowOverflowMenu = z2;
                                } else {
                                    if (kVarO2.k) {
                                        if (kVarO2.o) {
                                            kVarO2.k = false;
                                            zU = U(kVarO2, keyEvent);
                                        } else {
                                            zU = true;
                                        }
                                        if (zU) {
                                            S(kVarO2, keyEvent);
                                            zShowOverflowMenu = true;
                                        }
                                    }
                                    zShowOverflowMenu = false;
                                }
                            } else {
                                ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) this.r;
                                actionBarOverlayLayout2.m();
                                if (actionBarOverlayLayout2.g.a.isOverflowMenuShowing()) {
                                    ActionBarOverlayLayout actionBarOverlayLayout3 = (ActionBarOverlayLayout) this.r;
                                    actionBarOverlayLayout3.m();
                                    ActionMenuView actionMenuView2 = actionBarOverlayLayout3.g.a.mMenuView;
                                    if (actionMenuView2 != null && (aVar = actionMenuView2.g) != null && aVar.b()) {
                                        zShowOverflowMenu = true;
                                    }
                                } else if (!this.R && U(kVarO2, keyEvent)) {
                                    ActionBarOverlayLayout actionBarOverlayLayout4 = (ActionBarOverlayLayout) this.r;
                                    actionBarOverlayLayout4.m();
                                    zShowOverflowMenu = actionBarOverlayLayout4.g.a.showOverflowMenu();
                                }
                                zShowOverflowMenu = false;
                            }
                        } else {
                            z2 = kVarO2.m;
                            if (z2) {
                            }
                            G(kVarO2, true);
                            zShowOverflowMenu = z2;
                        }
                        if (zShowOverflowMenu && (audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio")) != null) {
                            audioManager.playSoundEffect(0);
                            return true;
                        }
                    }
                }
                return false;
            }
            boolean z3 = this.O;
            this.O = false;
            k kVarO3 = O(0);
            if (!kVarO3.m) {
                y1 y1Var = this.u;
                if (y1Var != null) {
                    y1Var.a();
                } else {
                    Q();
                    t1 t1Var = this.o;
                    if (t1Var == null || !t1Var.b()) {
                        z = false;
                    }
                    if (z) {
                        return false;
                    }
                }
                z = true;
                if (z) {
                    return false;
                }
            } else if (!z3) {
                G(kVarO3, true);
                return true;
            }
        }
        return true;
    }

    public final void J(int i) {
        k kVarO = O(i);
        if (kVarO.h != null) {
            Bundle bundle = new Bundle();
            kVarO.h.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                kVarO.p = bundle;
            }
            kVarO.h.stopDispatchingItemsChanged();
            kVarO.h.clear();
        }
        kVarO.o = true;
        kVarO.n = true;
        if ((i == 108 || i == 0) && this.r != null) {
            k kVarO2 = O(0);
            kVarO2.k = false;
            U(kVarO2, null);
        }
    }

    public final void K() {
        ViewGroup viewGroup;
        if (this.A) {
            return;
        }
        int[] iArr = b2.j;
        Context context = this.g;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            d.AnonymousClass0.m("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
            return;
        }
        int i = 0;
        if (typedArrayObtainStyledAttributes.getBoolean(renz.javacodez.v2ray.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            t(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            t(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            t(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            t(10);
        }
        this.J = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        L();
        this.i.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.K) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(this.I ? org.hamotunnelplus.xyz.R.layout.w : org.hamotunnelplus.xyz.R.layout.v, (ViewGroup) null);
        } else if (this.J) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(org.hamotunnelplus.xyz.R.layout.m, (ViewGroup) null);
            this.H = false;
            this.G = false;
        } else if (this.G) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(org.hamotunnelplus.xyz.R.style.q, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new yh(context, typedValue.resourceId) : context).inflate(org.hamotunnelplus.xyz.R.layout.x, (ViewGroup) null);
            wk wkVar = (wk) viewGroup.findViewById(org.hamotunnelplus.xyz.R.attr.ht);
            this.r = wkVar;
            Window.Callback callback = this.i.getCallback();
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) wkVar;
            actionBarOverlayLayout.m();
            actionBarOverlayLayout.g.l = callback;
            if (this.H) {
                ((ActionBarOverlayLayout) this.r).h(109);
            }
            if (this.E) {
                ((ActionBarOverlayLayout) this.r).h(2);
            }
            if (this.F) {
                ((ActionBarOverlayLayout) this.r).h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.G + ", windowActionBarOverlay: " + this.H + ", android:windowIsFloating: " + this.J + ", windowActionModeOverlay: " + this.I + ", windowNoTitle: " + this.K + " }");
        }
        g5 g5Var = new g5(this, i);
        WeakHashMap weakHashMap = qd1.a;
        b2.u(viewGroup, g5Var);
        if (this.r == null) {
            this.C = (TextView) viewGroup.findViewById(org.hamotunnelplus.xyz.R.attr.a1g);
        }
        Method method = ue1.a;
        try {
            Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method2.isAccessible()) {
                method2.setAccessible(true);
            }
            method2.invoke(viewGroup, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(org.hamotunnelplus.xyz.R.attr.bf);
        ViewGroup viewGroup2 = (ViewGroup) this.i.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.i.setContentView(viewGroup);
        contentFrameLayout.n = new g5(this, 4);
        this.B = viewGroup;
        Object obj = this.f;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.q;
        if (!TextUtils.isEmpty(title)) {
            wk wkVar2 = this.r;
            if (wkVar2 != null) {
                ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) wkVar2;
                actionBarOverlayLayout2.m();
                actionBarOverlayLayout2.g.setWindowTitle(title);
            } else {
                t1 t1Var = this.o;
                if (t1Var != null) {
                    t1Var.r(title);
                } else {
                    TextView textView = this.C;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.B.findViewById(R.id.content);
        View decorView = this.i.getDecorView();
        contentFrameLayout2.j.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        WeakHashMap weakHashMap2 = qd1.a;
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        if (contentFrameLayout2.b == null) {
            contentFrameLayout2.b = new TypedValue();
        }
        typedArrayObtainStyledAttributes2.getValue(renz.javacodez.v2ray.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.b);
        if (contentFrameLayout2.c == null) {
            contentFrameLayout2.c = new TypedValue();
        }
        typedArrayObtainStyledAttributes2.getValue(renz.javacodez.v2ray.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.c);
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            if (contentFrameLayout2.d == null) {
                contentFrameLayout2.d = new TypedValue();
            }
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.d);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(123)) {
            if (contentFrameLayout2.f == null) {
                contentFrameLayout2.f = new TypedValue();
            }
            typedArrayObtainStyledAttributes2.getValue(123, contentFrameLayout2.f);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            if (contentFrameLayout2.g == null) {
                contentFrameLayout2.g = new TypedValue();
            }
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.g);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            if (contentFrameLayout2.i == null) {
                contentFrameLayout2.i = new TypedValue();
            }
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.i);
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.A = true;
        k kVarO = O(0);
        if (this.R || kVarO.h != null) {
            return;
        }
        this.a0 |= 4096;
        if (this.Z) {
            return;
        }
        this.i.getDecorView().postOnAnimation(this.b0);
        this.Z = true;
    }

    public final void L() {
        if (this.i == null) {
            Object obj = this.f;
            if (obj instanceof Activity) {
                D(((Activity) obj).getWindow());
            }
        }
        if (this.i != null) {
            return;
        }
        d.AnonymousClass0.m("We have not been given a Window");
    }

    public final Context M() {
        Q();
        t1 t1Var = this.o;
        Context contextE = t1Var != null ? t1Var.e() : null;
        return contextE == null ? this.g : contextE;
    }

    public final g N(Context context) {
        if (this.X == null) {
            if (m6.d$1 == null) {
                Context applicationContext = context.getApplicationContext();
                m6.d$1 = new m6(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.X = new g(m6.d$1);
        }
        return this.X;
    }

    public final k O(int i) {
        k[] kVarArr = this.M;
        if (kVarArr == null || kVarArr.length <= i) {
            k[] kVarArr2 = new k[i + 1];
            if (kVarArr != null) {
                System.arraycopy(kVarArr, 0, kVarArr2, 0, kVarArr.length);
            }
            this.M = kVarArr2;
            kVarArr = kVarArr2;
        }
        k kVar = kVarArr[i];
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(i);
        kVarArr[i] = kVar2;
        return kVar2;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    public final void Q() {
        cg1 cg1Var;
        t1 t1Var;
        K();
        if (this.G && this.o == null) {
            Object obj = this.f;
            if (!(obj instanceof Activity)) {
                if (obj instanceof Dialog) {
                    cg1Var = new cg1((Dialog) obj);
                }
                t1Var = this.o;
                if (t1Var != null) {
                    t1Var.l(this.c0);
                }
            }
            cg1Var = new cg1(this.H, (Activity) obj);
            this.o = cg1Var;
            t1Var = this.o;
            if (t1Var != null) {
                t1Var.l(this.c0);
            }
        }
    }

    public final int R(Context context, int i) {
        g gVarN;
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            d.AnonymousClass0.m("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                            return 0;
                        }
                        if (this.Y == null) {
                            this.Y = new g(context);
                        }
                        gVarN = this.Y;
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    gVarN = N(context);
                }
                return gVarN.c();
            }
            return i;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0162, code lost:
    
        if (r14.i.getCount() > 0) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S(f5.k r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instruction units count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f5.S(f5$k, android.view.KeyEvent):void");
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:74:0x0103  */
    /* JADX WARN: Code duplicated, block: B:80:0x0118  */
    public final boolean U(k kVar, KeyEvent keyEvent) {
        androidx.appcompat.view.menu.f fVar;
        wk wkVar;
        wk wkVar2;
        Resources.Theme themeNewTheme;
        wk wkVar3;
        wk wkVar4;
        if (!this.R) {
            if (kVar.k) {
                return true;
            }
            k kVar2 = this.N;
            if (kVar2 != null && kVar2 != kVar) {
                G(kVar2, false);
            }
            Window.Callback callback = this.i.getCallback();
            int i = kVar.a;
            if (callback != null) {
                kVar.g = callback.onCreatePanelView(i);
            }
            boolean z = i == 0 || i == 108;
            if (z && (wkVar4 = this.r) != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) wkVar4;
                actionBarOverlayLayout.m();
                actionBarOverlayLayout.g.m = true;
            }
            if (kVar.g == null && (!z || !(this.o instanceof f71))) {
                androidx.appcompat.view.menu.f fVar2 = kVar.h;
                if (fVar2 == null || kVar.o) {
                    if (fVar2 == null) {
                        Context context = this.g;
                        if ((i == 0 || i == 108) && this.r != null) {
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme theme = context.getTheme();
                            theme.resolveAttribute(org.hamotunnelplus.xyz.R.style.q, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                                themeNewTheme.applyStyle(typedValue.resourceId, true);
                                themeNewTheme.resolveAttribute(org.hamotunnelplus.xyz.R.style.r, typedValue, true);
                            } else {
                                theme.resolveAttribute(org.hamotunnelplus.xyz.R.style.r, typedValue, true);
                                themeNewTheme = null;
                            }
                            if (typedValue.resourceId != 0) {
                                if (themeNewTheme == null) {
                                    themeNewTheme = context.getResources().newTheme();
                                    themeNewTheme.setTo(theme);
                                }
                                themeNewTheme.applyStyle(typedValue.resourceId, true);
                            }
                            if (themeNewTheme != null) {
                                yh yhVar = new yh(context, 0);
                                yhVar.getTheme().setTo(themeNewTheme);
                                context = yhVar;
                            }
                        }
                        androidx.appcompat.view.menu.f fVar3 = new androidx.appcompat.view.menu.f(context);
                        fVar3.mCallback = this;
                        androidx.appcompat.view.menu.f fVar4 = kVar.h;
                        if (fVar3 != fVar4) {
                            if (fVar4 != null) {
                                fVar4.removeMenuPresenter(kVar.i);
                            }
                            kVar.h = fVar3;
                            d dVar = kVar.i;
                            if (dVar != null) {
                                fVar3.addMenuPresenter(dVar, fVar3.mContext);
                            }
                        }
                        if (kVar.h != null) {
                            if (z && (wkVar2 = this.r) != null) {
                                if (this.s == null) {
                                    this.s = new g5(this, 2);
                                }
                                ((ActionBarOverlayLayout) wkVar2).e(kVar.h, this.s);
                            }
                            kVar.h.stopDispatchingItemsChanged();
                            if (callback.onCreatePanelMenu(i, kVar.h)) {
                                kVar.o = false;
                            } else {
                                fVar = kVar.h;
                                if (fVar != null) {
                                    fVar.removeMenuPresenter(kVar.i);
                                    kVar.h = null;
                                }
                                if (z && (wkVar = this.r) != null) {
                                    ((ActionBarOverlayLayout) wkVar).e(null, this.s);
                                }
                            }
                        }
                    } else {
                        if (z) {
                            if (this.s == null) {
                                this.s = new g5(this, 2);
                            }
                            ((ActionBarOverlayLayout) wkVar2).e(kVar.h, this.s);
                        }
                        kVar.h.stopDispatchingItemsChanged();
                        if (callback.onCreatePanelMenu(i, kVar.h)) {
                            fVar = kVar.h;
                            if (fVar != null) {
                                fVar.removeMenuPresenter(kVar.i);
                                kVar.h = null;
                            }
                            if (z) {
                                ((ActionBarOverlayLayout) wkVar).e(null, this.s);
                            }
                        } else {
                            kVar.o = false;
                        }
                    }
                }
                kVar.h.stopDispatchingItemsChanged();
                Bundle bundle = kVar.p;
                if (bundle != null) {
                    kVar.h.restoreActionViewStates(bundle);
                    kVar.p = null;
                }
                if (!callback.onPreparePanel(0, kVar.g, kVar.h)) {
                    if (z && (wkVar3 = this.r) != null) {
                        ((ActionBarOverlayLayout) wkVar3).e(null, this.s);
                    }
                    kVar.h.startDispatchingItemsChanged();
                    return false;
                }
                kVar.h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
                kVar.h.startDispatchingItemsChanged();
            }
            kVar.k = true;
            kVar.l = false;
            this.N = kVar;
            return true;
        }
        return false;
    }

    public final void V() {
        if (this.A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Override // defpackage.e5
    public final void j() {
        Q();
        t1 t1Var = this.o;
        if (t1Var == null || !t1Var.f()) {
            this.a0 |= 1;
            if (this.Z) {
                return;
            }
            View decorView = this.i.getDecorView();
            WeakHashMap weakHashMap = qd1.a;
            decorView.postOnAnimation(this.b0);
            this.Z = true;
        }
    }

    @Override // defpackage.e5
    public final void l() {
        String strC;
        this.P = true;
        C(false);
        L();
        Object obj = this.f;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strC = ui.c(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                t1 t1Var = this.o;
                if (t1Var == null) {
                    this.c0 = true;
                } else {
                    t1Var.l(true);
                }
            }
            synchronized (e5.d) {
                e5.s(this);
                e5.c.add(new WeakReference(this));
            }
        }
        this.S = new Configuration(this.g.getResources().getConfiguration());
        this.Q = true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    @Override // defpackage.e5
    public final void m() {
        if (this.f instanceof Activity) {
            synchronized (e5.d) {
                e5.s(this);
            }
        }
        if (this.Z) {
            this.i.getDecorView().removeCallbacks(this.b0);
        }
        this.R = true;
        if (this.T != -100) {
            Object obj = this.f;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                g0.put(this.f.getClass().getName(), Integer.valueOf(this.T));
            } else {
                g0.remove(this.f.getClass().getName());
            }
        } else {
            g0.remove(this.f.getClass().getName());
        }
        t1 t1Var = this.o;
        if (t1Var != null) {
            t1Var.h();
        }
        g gVar = this.X;
        if (gVar != null) {
            gVar.a();
        }
        g gVar2 = this.Y;
        if (gVar2 != null) {
            gVar2.a();
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View y5Var;
        k6 k6Var;
        View view2 = null;
        if (this.f0 == null) {
            int[] iArr = b2.j;
            Context context2 = this.g;
            String string = context2.obtainStyledAttributes(iArr).getString(116);
            if (string == null) {
                k6Var = new k6();
            } else {
                try {
                    this.f0 = (k6) context2.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable unused) {
                    k6Var = new k6();
                    this.f0 = k6Var;
                }
            }
            this.f0 = k6Var;
        }
        k6 k6Var2 = this.f0;
        int i = dd1.$r8$clinit;
        k6Var2.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b2.A, 0, 0);
        byte b = 4;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.recycle();
        Context yhVar = (resourceId == 0 || ((context instanceof yh) && ((yh) context).a == resourceId)) ? context : new yh(context, resourceId);
        str.getClass();
        switch (str.hashCode()) {
            case -1946472170:
                b = !str.equals("RatingBar") ? (byte) -1 : (byte) 0;
                break;
            case -1455429095:
                b = !str.equals("CheckedTextView") ? (byte) -1 : (byte) 1;
                break;
            case -1346021293:
                b = !str.equals("MultiAutoCompleteTextView") ? (byte) -1 : (byte) 2;
                break;
            case -938935918:
                b = !str.equals("TextView") ? (byte) -1 : (byte) 3;
                break;
            case -937446323:
                if (!str.equals("ImageButton")) {
                    b = -1;
                }
                break;
            case -658531749:
                b = !str.equals("SeekBar") ? (byte) -1 : (byte) 5;
                break;
            case -339785223:
                b = !str.equals("Spinner") ? (byte) -1 : (byte) 6;
                break;
            case 776382189:
                b = !str.equals("RadioButton") ? (byte) -1 : (byte) 7;
                break;
            case 799298502:
                b = !str.equals("ToggleButton") ? (byte) -1 : (byte) 8;
                break;
            case 1125864064:
                b = !str.equals("ImageView") ? (byte) -1 : (byte) 9;
                break;
            case 1413872058:
                b = !str.equals("AutoCompleteTextView") ? (byte) -1 : (byte) 10;
                break;
            case 1601505219:
                b = !str.equals("CheckBox") ? (byte) -1 : GZIPHeader.OS_WIN32;
                break;
            case 1666676343:
                b = !str.equals("EditText") ? (byte) -1 : GZIPHeader.OS_QDOS;
                break;
            case 2001146706:
                b = !str.equals("Button") ? (byte) -1 : GZIPHeader.OS_RISCOS;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                y5Var = new y5(yhVar, attributeSet);
                break;
            case 1:
                y5Var = new b5(yhVar, attributeSet);
                break;
            case 2:
                y5Var = new u5(yhVar, attributeSet);
                break;
            case 3:
                y5Var = k6Var2.createTextView(yhVar, attributeSet);
                break;
            case 4:
                y5Var = new s5(yhVar, attributeSet);
                break;
            case 5:
                y5Var = new b6(yhVar, attributeSet);
                break;
            case 6:
                y5Var = new e6(yhVar, attributeSet, org.hamotunnelplus.xyz.R.style.a0t);
                break;
            case 7:
                y5Var = k6Var2.createRadioButton(yhVar, attributeSet);
                break;
            case 8:
                y5Var = new j6(yhVar, attributeSet);
                break;
            case 9:
                y5Var = new AppCompatImageView(yhVar, attributeSet);
                break;
            case 10:
                y5Var = k6Var2.createAutoCompleteTextView(yhVar, attributeSet);
                break;
            case 11:
                y5Var = k6Var2.createCheckBox(yhVar, attributeSet);
                break;
            case 12:
                y5Var = new p5(yhVar, attributeSet);
                break;
            case 13:
                y5Var = k6Var2.createButton(yhVar, attributeSet);
                break;
            default:
                y5Var = null;
                break;
        }
        if (y5Var != null || context == yhVar) {
            view2 = y5Var;
        } else {
            Object[] objArr = k6Var2.mConstructorArgs;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = yhVar;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = k6.sClassPrefixList;
                        if (i2 < 3) {
                            View viewCreateViewByPrefix = k6Var2.createViewByPrefix(yhVar, str, strArr[i2]);
                            if (viewCreateViewByPrefix != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                view2 = viewCreateViewByPrefix;
                            } else {
                                i2++;
                            }
                        } else {
                            objArr[0] = null;
                            objArr[1] = null;
                        }
                    }
                } else {
                    View viewCreateViewByPrefix2 = k6Var2.createViewByPrefix(yhVar, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    view2 = viewCreateViewByPrefix2;
                }
            } catch (Exception unused2) {
                objArr[0] = view2;
                objArr[1] = view2;
            } catch (Throwable th) {
                objArr[0] = view2;
                objArr[1] = view2;
                throw th;
            }
        }
        if (view2 != null) {
            Context context3 = view2.getContext();
            if (context3 instanceof ContextWrapper) {
                WeakHashMap weakHashMap = qd1.a;
                if (view2.hasOnClickListeners()) {
                    TypedArray typedArrayObtainStyledAttributes2 = context3.obtainStyledAttributes(attributeSet, k6.sOnClickAttrs);
                    String string2 = typedArrayObtainStyledAttributes2.getString(0);
                    if (string2 != null) {
                        view2.setOnClickListener(new jz.a(view2, string2));
                    }
                    typedArrayObtainStyledAttributes2.recycle();
                }
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray typedArrayObtainStyledAttributes3 = yhVar.obtainStyledAttributes(attributeSet, k6.sAccessibilityHeading);
                if (typedArrayObtainStyledAttributes3.hasValue(0)) {
                    boolean z = typedArrayObtainStyledAttributes3.getBoolean(0, false);
                    WeakHashMap weakHashMap2 = qd1.a;
                    new md1(3).e(view2, Boolean.valueOf(z));
                }
                typedArrayObtainStyledAttributes3.recycle();
                TypedArray typedArrayObtainStyledAttributes4 = yhVar.obtainStyledAttributes(attributeSet, k6.sAccessibilityPaneTitle);
                if (typedArrayObtainStyledAttributes4.hasValue(0)) {
                    qd1.m(typedArrayObtainStyledAttributes4.getString(0), view2);
                }
                typedArrayObtainStyledAttributes4.recycle();
                TypedArray typedArrayObtainStyledAttributes5 = yhVar.obtainStyledAttributes(attributeSet, k6.sScreenReaderFocusable);
                if (typedArrayObtainStyledAttributes5.hasValue(0)) {
                    boolean z2 = typedArrayObtainStyledAttributes5.getBoolean(0, false);
                    WeakHashMap weakHashMap3 = qd1.a;
                    new md1(org.hamotunnelplus.xyz.R.attr.a0b, Boolean.class, 0, 28, 0).e(view2, Boolean.valueOf(z2));
                }
                typedArrayObtainStyledAttributes5.recycle();
            }
        }
        return view2;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    @Override // androidx.appcompat.view.menu.f.a
    public final boolean onMenuItemSelected(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        int length;
        int i;
        k kVar;
        Window.Callback callback = this.i.getCallback();
        if (callback != null && !this.R) {
            androidx.appcompat.view.menu.f rootMenu = fVar.getRootMenu();
            k[] kVarArr = this.M;
            if (kVarArr != null) {
                length = kVarArr.length;
                i = 0;
            } else {
                length = 0;
                i = 0;
            }
            while (i < length) {
                kVar = kVarArr[i];
                if (kVar == null || kVar.h != rootMenu) {
                    i++;
                } else if (kVar != null) {
                    return callback.onMenuItemSelected(kVar.a, menuItem);
                }
            }
            kVar = null;
            if (kVar != null) {
                return callback.onMenuItemSelected(kVar.a, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        if (r6.c() != false) goto L20;
     */
    @Override // androidx.appcompat.view.menu.f.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMenuModeChange(androidx.appcompat.view.menu.f r6) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f5.onMenuModeChange(androidx.appcompat.view.menu.f):void");
    }

    @Override // defpackage.e5
    public final boolean t(int i) {
        if (i == 8) {
            i = 108;
        } else if (i == 9) {
            i = 109;
        }
        if (this.K && i == 108) {
            return false;
        }
        if (this.G && i == 1) {
            this.G = false;
        }
        if (i == 1) {
            V();
            this.K = true;
            return true;
        }
        if (i == 2) {
            V();
            this.E = true;
            return true;
        }
        if (i == 5) {
            V();
            this.F = true;
            return true;
        }
        if (i == 10) {
            V();
            this.I = true;
            return true;
        }
        if (i == 108) {
            V();
            this.G = true;
            return true;
        }
        if (i != 109) {
            return this.i.requestFeature(i);
        }
        V();
        this.H = true;
        return true;
    }

    @Override // defpackage.e5
    public final void u(int i) {
        K();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.g).inflate(i, viewGroup);
        this.j.b.onContentChanged();
    }
}
