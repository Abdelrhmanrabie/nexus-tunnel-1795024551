package androidx.fragment.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import defpackage.ah0;
import defpackage.an0;
import defpackage.b2;
import defpackage.be1;
import defpackage.ce1;
import defpackage.dn0;
import defpackage.ev;
import defpackage.fv;
import defpackage.hf;
import defpackage.ih;
import defpackage.kh0;
import defpackage.lv;
import defpackage.mv;
import defpackage.q2;
import defpackage.qv;
import defpackage.sv;
import defpackage.tx0;
import defpackage.u2;
import defpackage.vm0;
import defpackage.wm0;
import defpackage.xe0;
import defpackage.xz0;
import defpackage.zm0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class n extends ComponentActivity implements b2.e {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final androidx.lifecycle.i mFragmentLifecycleRegistry;
    final lv mFragments;
    boolean mResumed;
    boolean mStopped;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a extends mv implements wm0, dn0, zm0, an0, ce1, vm0, u2, tx0, sv, ah0 {
        public a() {
            super(n.this);
        }

        @Override // defpackage.sv
        public final void a(Fragment fragment) {
            n.this.onAttachFragment(fragment);
        }

        @Override // defpackage.ah0
        public final void addMenuProvider(kh0 kh0Var) {
            n.this.addMenuProvider(kh0Var);
        }

        @Override // defpackage.wm0
        public final void addOnConfigurationChangedListener(ih ihVar) {
            n.this.addOnConfigurationChangedListener(ihVar);
        }

        @Override // defpackage.zm0
        public final void addOnMultiWindowModeChangedListener(ih ihVar) {
            n.this.addOnMultiWindowModeChangedListener(ihVar);
        }

        @Override // defpackage.an0
        public final void addOnPictureInPictureModeChangedListener(ih ihVar) {
            n.this.addOnPictureInPictureModeChangedListener(ihVar);
        }

        @Override // defpackage.dn0
        public final void addOnTrimMemoryListener(ih ihVar) {
            n.this.addOnTrimMemoryListener(ihVar);
        }

        @Override // defpackage.kv
        public final View b(int i) {
            return n.this.findViewById(i);
        }

        @Override // defpackage.kv
        public final boolean c() {
            Window window = n.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // defpackage.u2
        public final q2 getActivityResultRegistry() {
            return n.this.getActivityResultRegistry();
        }

        @Override // defpackage.he0
        public final androidx.lifecycle.e getLifecycle() {
            return n.this.mFragmentLifecycleRegistry;
        }

        @Override // defpackage.vm0
        public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return n.this.getOnBackPressedDispatcher();
        }

        @Override // defpackage.tx0
        public final androidx.savedstate.a getSavedStateRegistry() {
            return n.this.getSavedStateRegistry();
        }

        @Override // defpackage.ce1
        public final be1 getViewModelStore() {
            return n.this.getViewModelStore();
        }

        @Override // defpackage.ah0
        public final void removeMenuProvider(kh0 kh0Var) {
            n.this.removeMenuProvider(kh0Var);
        }

        @Override // defpackage.wm0
        public final void removeOnConfigurationChangedListener(ih ihVar) {
            n.this.removeOnConfigurationChangedListener(ihVar);
        }

        @Override // defpackage.zm0
        public final void removeOnMultiWindowModeChangedListener(ih ihVar) {
            n.this.removeOnMultiWindowModeChangedListener(ihVar);
        }

        @Override // defpackage.an0
        public final void removeOnPictureInPictureModeChangedListener(ih ihVar) {
            n.this.removeOnPictureInPictureModeChangedListener(ihVar);
        }

        @Override // defpackage.dn0
        public final void removeOnTrimMemoryListener(ih ihVar) {
            n.this.removeOnTrimMemoryListener(ihVar);
        }
    }

    public n() {
        this.mFragments = new lv(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.i(this);
        this.mStopped = true;
        init();
    }

    public n(int i) {
        super(i);
        this.mFragments = new lv(new a());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.i(this);
        this.mStopped = true;
        init();
    }

    public static boolean markState(q qVar, androidx.lifecycle.e.b bVar) {
        boolean zMarkState = false;
        for (Fragment fragment : qVar.c.f()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    zMarkState |= markState(fragment.getChildFragmentManager(), bVar);
                }
                x xVar = fragment.mViewLifecycleOwner;
                androidx.lifecycle.e.b bVar2 = androidx.lifecycle.e.b.STARTED;
                if (xVar != null) {
                    xVar.b();
                    if (xVar.f.d.compareTo(bVar2) >= 0) {
                        androidx.lifecycle.i iVar = fragment.mViewLifecycleOwner.f;
                        iVar.e("setCurrentState");
                        iVar.g(bVar);
                        zMarkState = true;
                    }
                }
                if (fragment.mLifecycleRegistry.d.compareTo(bVar2) >= 0) {
                    androidx.lifecycle.i iVar2 = fragment.mLifecycleRegistry;
                    iVar2.e("setCurrentState");
                    iVar2.g(bVar);
                    zMarkState = true;
                }
            }
        }
        return zMarkState;
    }

    public static void r(n nVar, Context context) {
        a aVar = nVar.mFragments.a;
        aVar.f.c(aVar, aVar, null);
    }

    public static /* synthetic */ Bundle s(n nVar) {
        nVar.markFragmentsCreated();
        nVar.mFragmentLifecycleRegistry.f(androidx.lifecycle.e.a.ON_STOP);
        return new Bundle();
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.a.f.f.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                xe0.a(this).b(str2, printWriter);
            }
            this.mFragments.a.f.v(str, fileDescriptor, printWriter, strArr);
        }
    }

    public q getSupportFragmentManager() {
        return this.mFragments.a.f;
    }

    public xe0 getSupportLoaderManager() {
        return xe0.a(this);
    }

    public final void init() {
        int i = 0;
        getSavedStateRegistry().c(LIFECYCLE_TAG, new ev(i, this));
        addOnConfigurationChangedListener(new fv(this, i, i));
        int i2 = 1;
        addOnNewIntentListener(new fv(this, i, i2));
        addOnContextAvailableListener(new hf(this, i2));
    }

    public void markFragmentsCreated() {
        while (markState(getSupportFragmentManager(), androidx.lifecycle.e.b.CREATED)) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i, i2, intent);
    }

    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.activity.ComponentActivity, defpackage.Cif, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.e.a.ON_CREATE);
        qv qvVar = this.mFragments.a.f;
        qvVar.F = false;
        qvVar.G = false;
        qvVar.M.f = false;
        qvVar.u(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.a.f.l();
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.e.a.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return this.mFragments.a.f.j(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.a.f.u(5);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.e.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.a.f.y(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.e.a.ON_RESUME);
        qv qvVar = this.mFragments.a.f;
        qvVar.F = false;
        qvVar.G = false;
        qvVar.M.f = false;
        qvVar.u(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            qv qvVar = this.mFragments.a.f;
            qvVar.F = false;
            qvVar.G = false;
            qvVar.M.f = false;
            qvVar.u(4);
        }
        this.mFragments.a.f.y(true);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.e.a.ON_START);
        qv qvVar2 = this.mFragments.a.f;
        qvVar2.F = false;
        qvVar2.G = false;
        qvVar2.M.f = false;
        qvVar2.u(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        qv qvVar = this.mFragments.a.f;
        qvVar.G = true;
        qvVar.M.f = true;
        qvVar.u(4);
        this.mFragmentLifecycleRegistry.f(androidx.lifecycle.e.a.ON_STOP);
    }

    public void setEnterSharedElementCallback(xz0 xz0Var) {
        setEnterSharedElementCallback((SharedElementCallback) null);
    }

    public void setExitSharedElementCallback(xz0 xz0Var) {
        setExitSharedElementCallback((SharedElementCallback) null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            startActivityForResult(intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }

    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i == -1) {
            startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        finishAfterTransition();
    }

    public void supportPostponeEnterTransition() {
        postponeEnterTransition();
    }

    public void supportStartPostponedEnterTransition() {
        startPostponedEnterTransition();
    }

    @Override // b2.e
    public final void validateRequestPermissionsRequestCode(int i) {
    }
}
