package androidx.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.q;
import androidx.lifecycle.e;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import defpackage.Cif;
import defpackage.ah0;
import defpackage.ak;
import defpackage.an0;
import defpackage.b2;
import defpackage.be1;
import defpackage.ce1;
import defpackage.cf;
import defpackage.cj;
import defpackage.df;
import defpackage.dh0;
import defpackage.dn0;
import defpackage.e4;
import defpackage.ef;
import defpackage.f2;
import defpackage.g30;
import defpackage.gf;
import defpackage.h6;
import defpackage.he0;
import defpackage.hf;
import defpackage.ih;
import defpackage.jf;
import defpackage.k2;
import defpackage.kh0;
import defpackage.kw;
import defpackage.l2;
import defpackage.lf;
import defpackage.lw;
import defpackage.o2;
import defpackage.o6;
import defpackage.oc0;
import defpackage.ph;
import defpackage.q2;
import defpackage.rc0;
import defpackage.sx0;
import defpackage.tx0;
import defpackage.u2;
import defpackage.ui0;
import defpackage.v41;
import defpackage.vm0;
import defpackage.w90;
import defpackage.wm0;
import defpackage.xi0;
import defpackage.xm0;
import defpackage.xo0;
import defpackage.zd1;
import defpackage.zm0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends Cif implements ce1, androidx.lifecycle.c, tx0, vm0, u2, wm0, dn0, zm0, an0, ah0 {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final b Companion = new b();
    private be1 _viewModelStore;
    private final q2 activityResultRegistry;
    private int contentLayoutId;
    private final ph contextAwareHelper;
    private final rc0 defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    private final rc0 fullyDrawnReporter$delegate;
    private final dh0 menuHostHelper;
    private final AtomicInteger nextLocalRequestCode;
    private final rc0 onBackPressedDispatcher$delegate;
    private final CopyOnWriteArrayList<ih> onConfigurationChangedListeners;
    private final CopyOnWriteArrayList<ih> onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<ih> onNewIntentListeners;
    private final CopyOnWriteArrayList<ih> onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<ih> onTrimMemoryListeners;
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    private final d reportFullyDrawnExecutor;
    private final sx0 savedStateRegistryController;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class a {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class b {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class c {
        public Object a;
        public be1 b;
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface d extends Executor {
        void b();

        void h(View view);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class e implements d, ViewTreeObserver.OnDrawListener, Runnable {
        public final long b = SystemClock.uptimeMillis() + ((long) 10000);
        public Runnable c;
        public boolean d;

        public e() {
        }

        @Override // androidx.activity.ComponentActivity.d
        public final void b() {
            ComponentActivity componentActivity = ComponentActivity.this;
            componentActivity.getWindow().getDecorView().removeCallbacks(this);
            componentActivity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.c = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.d) {
                int i = 0;
                decorView.postOnAnimation(new jf(this, i, i));
            } else if (e4.a(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // androidx.activity.ComponentActivity.d
        public final void h(View view) {
            if (this.d) {
                return;
            }
            this.d = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            boolean z;
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
                this.c = null;
                kw fullyDrawnReporter = ComponentActivity.this.getFullyDrawnReporter();
                synchronized (fullyDrawnReporter.c) {
                    z = fullyDrawnReporter.d;
                }
                if (!z) {
                    return;
                }
            } else if (SystemClock.uptimeMillis() <= this.b) {
                return;
            }
            this.d = false;
            ComponentActivity.this.getWindow().getDecorView().post(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class f extends q2 {
        public f() {
        }

        @Override // defpackage.q2
        public final void b(int i, l2 l2Var, Object obj) {
            Bundle bundleExtra;
            int i2;
            ComponentActivity componentActivity = ComponentActivity.this;
            o6 o6VarB = l2Var.b(componentActivity, obj);
            if (o6VarB != null) {
                new Handler(Looper.getMainLooper()).post(new h6(this, i, o6VarB, 2));
                return;
            }
            Intent intentA = l2Var.a(obj);
            if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                intentA.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else {
                bundleExtra = null;
            }
            Bundle bundle = bundleExtra;
            int i3 = 0;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                b2.a(componentActivity, stringArrayExtra, i);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                componentActivity.startActivityForResult(intentA, i, bundle);
                return;
            }
            g30 g30Var = (g30) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                i2 = i;
                try {
                    componentActivity.startIntentSenderForResult(g30Var.b, i2, g30Var.c, g30Var.d, g30Var.f, 0, bundle);
                } catch (IntentSender.SendIntentException e) {
                    e = e;
                    new Handler(Looper.getMainLooper()).post(new lf(this, i2, i3, e));
                }
            } catch (IntentSender.SendIntentException e2) {
                e = e2;
                i2 = i;
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class g extends oc0 implements lw {
        public g() {
            super(0);
        }

        @Override // defpackage.lw
        public final Object invoke() {
            ComponentActivity componentActivity = ComponentActivity.this;
            return new p(componentActivity.getApplication(), componentActivity, componentActivity.getIntent() != null ? componentActivity.getIntent().getExtras() : null);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class h extends oc0 implements lw {
        public h() {
            super(0);
        }

        @Override // defpackage.lw
        public final Object invoke() {
            ComponentActivity componentActivity = ComponentActivity.this;
            d dVar = componentActivity.reportFullyDrawnExecutor;
            new androidx.activity.a(componentActivity);
            return new kw(dVar);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class i extends oc0 implements lw {
        public i() {
            super(0);
        }

        @Override // defpackage.lw
        public final Object invoke() {
            ComponentActivity componentActivity = ComponentActivity.this;
            OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new df(componentActivity, 1, 0));
            if (Build.VERSION.SDK_INT >= 33) {
                if (!e4.a(Looper.myLooper(), Looper.getMainLooper())) {
                    new Handler(Looper.getMainLooper()).post(new f2(7, componentActivity, onBackPressedDispatcher));
                    return onBackPressedDispatcher;
                }
                ComponentActivity.access$addObserverForBackInvoker(componentActivity, onBackPressedDispatcher);
            }
            return onBackPressedDispatcher;
        }
    }

    public ComponentActivity() {
        this.contextAwareHelper = new ph();
        int i2 = 0;
        this.menuHostHelper = new dh0(new df(this, i2, i2));
        sx0 sx0Var = new sx0(this);
        this.savedStateRegistryController = sx0Var;
        this.reportFullyDrawnExecutor = new e();
        this.fullyDrawnReporter$delegate = new v41(new h());
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new f();
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList<>();
        if (getLifecycle() == null) {
            defpackage.d.AnonymousClass0.m("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
            throw null;
        }
        getLifecycle().a(new ef(i2, this));
        getLifecycle().a(new androidx.lifecycle.h() { // from class: ff
            @Override // androidx.lifecycle.h
            public final void a(he0 he0Var, e.a aVar) {
                ComponentActivity.o(this.b, he0Var, aVar);
            }
        });
        getLifecycle().a(new androidx.lifecycle.h() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.h
            public final void a(he0 he0Var, androidx.lifecycle.e.a aVar) {
                ComponentActivity componentActivity = ComponentActivity.this;
                ComponentActivity.access$ensureViewModelStore(componentActivity);
                componentActivity.getLifecycle().c(this);
            }
        });
        sx0Var.a();
        o.b(this);
        if (Build.VERSION.SDK_INT <= 23) {
            getLifecycle().a(new ImmLeaksCleaner(this));
        }
        getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new gf(i2, this));
        addOnContextAvailableListener(new hf(this, i2));
        this.defaultViewModelProviderFactory$delegate = new v41(new g());
        this.onBackPressedDispatcher$delegate = new v41(new i());
    }

    public ComponentActivity(int i2) {
        this();
        this.contentLayoutId = i2;
    }

    public static final void access$addObserverForBackInvoker(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
        componentActivity.getLifecycle().a(new cf(componentActivity, onBackPressedDispatcher));
    }

    public static final void access$ensureViewModelStore(ComponentActivity componentActivity) {
        if (componentActivity._viewModelStore == null) {
            c cVar = (c) componentActivity.getLastNonConfigurationInstance();
            if (cVar != null) {
                componentActivity._viewModelStore = cVar.b;
            }
            if (componentActivity._viewModelStore == null) {
                componentActivity._viewModelStore = new be1();
            }
        }
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    public static void j(ComponentActivity componentActivity, Context context) {
        Bundle bundleA = componentActivity.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (bundleA != null) {
            q2 q2Var = componentActivity.activityResultRegistry;
            q2Var.getClass();
            ArrayList<Integer> integerArrayList = bundleA.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            ArrayList<String> stringArrayList2 = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            if (stringArrayList2 != null) {
                q2Var.d.addAll(stringArrayList2);
            }
            Bundle bundle = bundleA.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            Bundle bundle2 = q2Var.g;
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            int size = stringArrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = stringArrayList.get(i2);
                LinkedHashMap linkedHashMap = q2Var.b;
                boolean zContainsKey = linkedHashMap.containsKey(str);
                LinkedHashMap linkedHashMap2 = q2Var.a;
                if (zContainsKey) {
                    Integer num = (Integer) linkedHashMap.remove(str);
                    if (bundle2.containsKey(str)) {
                        continue;
                    } else {
                        if (linkedHashMap2 instanceof w90) {
                            e4.c("kotlin.collections.MutableMap", linkedHashMap2);
                            throw null;
                        }
                        linkedHashMap2.remove(num);
                    }
                }
                int iIntValue = integerArrayList.get(i2).intValue();
                String str2 = stringArrayList.get(i2);
                linkedHashMap2.put(Integer.valueOf(iIntValue), str2);
                linkedHashMap.put(str2, Integer.valueOf(iIntValue));
            }
        }
    }

    public static void k(ComponentActivity componentActivity) {
        componentActivity.invalidateMenu();
    }

    public static Bundle l(ComponentActivity componentActivity) {
        Bundle bundle = new Bundle();
        q2 q2Var = componentActivity.activityResultRegistry;
        q2Var.getClass();
        LinkedHashMap linkedHashMap = q2Var.b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(q2Var.d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(q2Var.g));
        return bundle;
    }

    public static void m(ComponentActivity componentActivity, he0 he0Var, androidx.lifecycle.e.a aVar) {
        Window window;
        View viewPeekDecorView;
        if (aVar != androidx.lifecycle.e.a.ON_STOP || (window = componentActivity.getWindow()) == null || (viewPeekDecorView = window.peekDecorView()) == null) {
            return;
        }
        viewPeekDecorView.cancelPendingInputEvents();
    }

    public static void n(OnBackPressedDispatcher onBackPressedDispatcher, ComponentActivity componentActivity, he0 he0Var, androidx.lifecycle.e.a aVar) {
        if (aVar == androidx.lifecycle.e.a.ON_CREATE) {
            onBackPressedDispatcher.f = componentActivity.getOnBackInvokedDispatcher();
            onBackPressedDispatcher.d(onBackPressedDispatcher.h);
        }
    }

    public static void o(ComponentActivity componentActivity, he0 he0Var, androidx.lifecycle.e.a aVar) {
        if (aVar == androidx.lifecycle.e.a.ON_DESTROY) {
            componentActivity.contextAwareHelper.b = null;
            if (!componentActivity.isChangingConfigurations()) {
                LinkedHashMap linkedHashMap = componentActivity.getViewModelStore().a;
                Iterator it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    ((zd1) it.next()).clear();
                }
                linkedHashMap.clear();
            }
            componentActivity.reportFullyDrawnExecutor.b();
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.reportFullyDrawnExecutor.h(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // defpackage.ah0
    public void addMenuProvider(kh0 kh0Var) {
        dh0 dh0Var = this.menuHostHelper;
        dh0Var.b.add(kh0Var);
        dh0Var.a.run();
    }

    public void addMenuProvider(kh0 kh0Var, he0 he0Var) {
        dh0 dh0Var = this.menuHostHelper;
        dh0Var.b.add(kh0Var);
        dh0Var.a.run();
        androidx.lifecycle.e lifecycle = he0Var.getLifecycle();
        HashMap map = dh0Var.c;
        dh0.a aVar = (dh0.a) map.remove(kh0Var);
        if (aVar != null) {
            aVar.a.c(aVar.b);
            aVar.b = null;
        }
        map.put(kh0Var, new dh0.a(lifecycle, new cf(dh0Var, kh0Var)));
    }

    public void addMenuProvider(final kh0 kh0Var, he0 he0Var, final androidx.lifecycle.e.b bVar) {
        final dh0 dh0Var = this.menuHostHelper;
        dh0Var.getClass();
        androidx.lifecycle.e lifecycle = he0Var.getLifecycle();
        HashMap map = dh0Var.c;
        dh0.a aVar = (dh0.a) map.remove(kh0Var);
        if (aVar != null) {
            aVar.a.c(aVar.b);
            aVar.b = null;
        }
        map.put(kh0Var, new dh0.a(lifecycle, new androidx.lifecycle.h() { // from class: ch0
            @Override // androidx.lifecycle.h
            public final void a(he0 he0Var2, e.a aVar2) {
                e.a aVar3;
                dh0 dh0Var2 = dh0Var;
                dh0Var2.getClass();
                e.a.Companion.getClass();
                e.b bVar2 = bVar;
                int iOrdinal = bVar2.ordinal();
                e.a aVar4 = null;
                if (iOrdinal == 2) {
                    aVar3 = e.a.ON_CREATE;
                } else if (iOrdinal != 3) {
                    aVar3 = iOrdinal != 4 ? null : e.a.ON_RESUME;
                } else {
                    aVar3 = e.a.ON_START;
                }
                Runnable runnable = dh0Var2.a;
                CopyOnWriteArrayList copyOnWriteArrayList = dh0Var2.b;
                kh0 kh0Var2 = kh0Var;
                if (aVar2 == aVar3) {
                    copyOnWriteArrayList.add(kh0Var2);
                } else {
                    e.a aVar5 = e.a.ON_DESTROY;
                    if (aVar2 == aVar5) {
                        dh0Var2.c(kh0Var2);
                        return;
                    }
                    int iOrdinal2 = bVar2.ordinal();
                    if (iOrdinal2 == 2) {
                        aVar4 = aVar5;
                    } else if (iOrdinal2 == 3) {
                        aVar4 = e.a.ON_STOP;
                    } else if (iOrdinal2 == 4) {
                        aVar4 = e.a.ON_PAUSE;
                    }
                    if (aVar2 != aVar4) {
                        return;
                    } else {
                        copyOnWriteArrayList.remove(kh0Var2);
                    }
                }
                runnable.run();
            }
        }));
    }

    @Override // defpackage.wm0
    public final void addOnConfigurationChangedListener(ih ihVar) {
        this.onConfigurationChangedListeners.add(ihVar);
    }

    public final void addOnContextAvailableListener(xm0 xm0Var) {
        ph phVar = this.contextAwareHelper;
        phVar.getClass();
        ComponentActivity componentActivity = phVar.b;
        if (componentActivity != null) {
            xm0Var.a(componentActivity);
        }
        phVar.a.add(xm0Var);
    }

    @Override // defpackage.zm0
    public final void addOnMultiWindowModeChangedListener(ih ihVar) {
        this.onMultiWindowModeChangedListeners.add(ihVar);
    }

    public final void addOnNewIntentListener(ih ihVar) {
        this.onNewIntentListeners.add(ihVar);
    }

    @Override // defpackage.an0
    public final void addOnPictureInPictureModeChangedListener(ih ihVar) {
        this.onPictureInPictureModeChangedListeners.add(ihVar);
    }

    @Override // defpackage.dn0
    public final void addOnTrimMemoryListener(ih ihVar) {
        this.onTrimMemoryListeners.add(ihVar);
    }

    public final void addOnUserLeaveHintListener(Runnable runnable) {
        this.onUserLeaveHintListeners.add(runnable);
    }

    @Override // defpackage.u2
    public final q2 getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @Override // androidx.lifecycle.c
    public cj getDefaultViewModelCreationExtras() {
        xi0 xi0Var = new xi0();
        Application application = getApplication();
        LinkedHashMap linkedHashMap = xi0Var.a;
        if (application != null) {
            linkedHashMap.put(s.a, getApplication());
        }
        linkedHashMap.put(o.a, this);
        linkedHashMap.put(o.b, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            linkedHashMap.put(o.c, extras);
        }
        return xi0Var;
    }

    @Override // androidx.lifecycle.c
    public t.b getDefaultViewModelProviderFactory() {
        return (t.b) this.defaultViewModelProviderFactory$delegate.getValue();
    }

    public kw getFullyDrawnReporter() {
        return (kw) this.fullyDrawnReporter$delegate.getValue();
    }

    public Object getLastCustomNonConfigurationInstance() {
        c cVar = (c) getLastNonConfigurationInstance();
        if (cVar != null) {
            return cVar.a;
        }
        return null;
    }

    @Override // defpackage.Cif, defpackage.he0
    public androidx.lifecycle.e getLifecycle() {
        return super.getLifecycle();
    }

    @Override // defpackage.vm0
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return (OnBackPressedDispatcher) this.onBackPressedDispatcher$delegate.getValue();
    }

    @Override // defpackage.tx0
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.savedStateRegistryController.b;
    }

    @Override // defpackage.ce1
    public be1 getViewModelStore() {
        if (getApplication() == null) {
            defpackage.d.AnonymousClass0.m("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
            return null;
        }
        if (this._viewModelStore == null) {
            c cVar = (c) getLastNonConfigurationInstance();
            if (cVar != null) {
                this._viewModelStore = cVar.b;
            }
            if (this._viewModelStore == null) {
                this._viewModelStore = new be1();
            }
        }
        return this._viewModelStore;
    }

    public void initializeViewTreeOwners() {
        getWindow().getDecorView().setTag(R.attr.a37, this);
        getWindow().getDecorView().setTag(R.attr.a3_, this);
        getWindow().getDecorView().setTag(R.attr.a39, this);
        getWindow().getDecorView().setTag(R.attr.a38, this);
        getWindow().getDecorView().setTag(R.attr.vk, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (this.activityResultRegistry.a(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        getOnBackPressedDispatcher().c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<ih> it = this.onConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // defpackage.Cif, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.savedStateRegistryController.b(bundle);
        ph phVar = this.contextAwareHelper;
        phVar.getClass();
        phVar.b = this;
        Iterator it = phVar.a.iterator();
        while (it.hasNext()) {
            ((xm0) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i2 = m.$r8$clinit;
        m.b.b(this);
        int i3 = this.contentLayoutId;
        if (i3 != 0) {
            setContentView(i3);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i2, menu);
        dh0 dh0Var = this.menuHostHelper;
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = dh0Var.b.iterator();
        while (it.hasNext()) {
            q.this.k(menu, menuInflater);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 != 0) {
            return false;
        }
        Iterator it = this.menuHostHelper.b.iterator();
        while (it.hasNext()) {
            if (q.this.p(menuItem)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<ih> it = this.onMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new ui0(z));
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator<ih> it = this.onMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new ui0(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<ih> it = this.onNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        Iterator it = this.menuHostHelper.b.iterator();
        while (it.hasNext()) {
            q.this.q(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<ih> it = this.onPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new xo0(z));
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator<ih> it = this.onPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new xo0(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onPreparePanel(i2, view, menu);
        Iterator it = this.menuHostHelper.b.iterator();
        while (it.hasNext()) {
            q.this.t(menu);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (this.activityResultRegistry.a(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        c cVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        be1 be1Var = this._viewModelStore;
        if (be1Var == null && (cVar = (c) getLastNonConfigurationInstance()) != null) {
            be1Var = cVar.b;
        }
        if (be1Var == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        c cVar2 = new c();
        cVar2.a = objOnRetainCustomNonConfigurationInstance;
        cVar2.b = be1Var;
        return cVar2;
    }

    @Override // defpackage.Cif, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (getLifecycle() instanceof androidx.lifecycle.i) {
            androidx.lifecycle.i iVar = (androidx.lifecycle.i) getLifecycle();
            androidx.lifecycle.e.b bVar = androidx.lifecycle.e.b.CREATED;
            iVar.e("setCurrentState");
            iVar.g(bVar);
        }
        super.onSaveInstanceState(bundle);
        this.savedStateRegistryController.c(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        Iterator<ih> it = this.onTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i2));
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator<Runnable> it = this.onUserLeaveHintListeners.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public Context peekAvailableContext() {
        return this.contextAwareHelper.b;
    }

    public final <I, O> o2 registerForActivityResult(l2 l2Var, k2 k2Var) {
        return registerForActivityResult(l2Var, this.activityResultRegistry, k2Var);
    }

    public final <I, O> o2 registerForActivityResult(l2 l2Var, q2 q2Var, k2 k2Var) {
        return q2Var.c("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, l2Var, k2Var);
    }

    @Override // defpackage.ah0
    public void removeMenuProvider(kh0 kh0Var) {
        this.menuHostHelper.c(kh0Var);
    }

    @Override // defpackage.wm0
    public final void removeOnConfigurationChangedListener(ih ihVar) {
        this.onConfigurationChangedListeners.remove(ihVar);
    }

    public final void removeOnContextAvailableListener(xm0 xm0Var) {
        ph phVar = this.contextAwareHelper;
        phVar.getClass();
        phVar.a.remove(xm0Var);
    }

    @Override // defpackage.zm0
    public final void removeOnMultiWindowModeChangedListener(ih ihVar) {
        this.onMultiWindowModeChangedListeners.remove(ihVar);
    }

    public final void removeOnNewIntentListener(ih ihVar) {
        this.onNewIntentListeners.remove(ihVar);
    }

    @Override // defpackage.an0
    public final void removeOnPictureInPictureModeChangedListener(ih ihVar) {
        this.onPictureInPictureModeChangedListeners.remove(ihVar);
    }

    @Override // defpackage.dn0
    public final void removeOnTrimMemoryListener(ih ihVar) {
        this.onTrimMemoryListeners.remove(ihVar);
    }

    public final void removeOnUserLeaveHintListener(Runnable runnable) {
        this.onUserLeaveHintListeners.remove(runnable);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (ak.a()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            kw fullyDrawnReporter = getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.c) {
                try {
                    fullyDrawnReporter.d = true;
                    Iterator it = fullyDrawnReporter.e.iterator();
                    while (it.hasNext()) {
                        ((lw) it.next()).invoke();
                    }
                    fullyDrawnReporter.e.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            Trace.endSection();
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        initializeViewTreeOwners();
        this.reportFullyDrawnExecutor.h(getWindow().getDecorView());
        super.setContentView(i2);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        this.reportFullyDrawnExecutor.h(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.reportFullyDrawnExecutor.h(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }
}
