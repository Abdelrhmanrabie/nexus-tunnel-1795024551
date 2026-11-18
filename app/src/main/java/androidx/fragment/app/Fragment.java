package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.LiveData;
import defpackage.ak;
import defpackage.be1;
import defpackage.ce1;
import defpackage.cj;
import defpackage.dy;
import defpackage.ey;
import defpackage.g30;
import defpackage.g41;
import defpackage.he0;
import defpackage.jx;
import defpackage.k2;
import defpackage.kv;
import defpackage.l2;
import defpackage.mv;
import defpackage.o2;
import defpackage.q2;
import defpackage.qv;
import defpackage.sv;
import defpackage.sx0;
import defpackage.tv;
import defpackage.tx0;
import defpackage.u2;
import defpackage.uv;
import defpackage.xe0;
import defpackage.xi0;
import defpackage.xz0;
import defpackage.yi0;
import defpackage.z11;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, he0, ce1, androidx.lifecycle.c, tx0 {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    j mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    q mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    androidx.lifecycle.t.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    q mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    mv mHost;
    boolean mInLayout;
    boolean mIsCreated;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.i mLifecycleRegistry;
    androidx.lifecycle.e.b mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<l> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    Runnable mPostponedDurationRunnable;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    private final l mSavedStateAttachListener;
    sx0 mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    x mViewLifecycleOwner;
    yi0 mViewLifecycleOwnerLiveData;
    String mWho;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a extends o2 {
        public a(AtomicReference atomicReference) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c extends l {
        public c() {
        }

        @Override // androidx.fragment.app.Fragment.l
        public final void a() {
            Fragment fragment = Fragment.this;
            fragment.mSavedStateRegistryController.a();
            androidx.lifecycle.o.b(fragment);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Fragment.this.callStartTransitionListener(false);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class e implements Runnable {
        public final /* synthetic */ y b;

        public e(y yVar) {
            this.b = yVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.c();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class f extends kv {
        public f() {
        }

        @Override // defpackage.kv
        public final View b(int i) {
            Fragment fragment = Fragment.this;
            View view = fragment.mView;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException(ak.l("Fragment ", fragment, " does not have a view"));
        }

        @Override // defpackage.kv
        public final boolean c() {
            return Fragment.this.mView != null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class g implements jx {
        public g() {
        }

        @Override // defpackage.jx
        public final q2 apply() {
            Fragment fragment = Fragment.this;
            Object obj = fragment.mHost;
            return obj instanceof u2 ? ((u2) obj).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class h implements jx {
        public final /* synthetic */ q2 a;

        public h(q2 q2Var) {
            this.a = q2Var;
        }

        @Override // defpackage.jx
        public final q2 apply() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class i extends l {
        public final /* synthetic */ jx a;
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ l2 c;
        public final /* synthetic */ k2 d;

        public i(jx jxVar, AtomicReference atomicReference, l2 l2Var, k2 k2Var) {
            this.a = jxVar;
            this.b = atomicReference;
            this.c = l2Var;
            this.d = k2Var;
        }

        @Override // androidx.fragment.app.Fragment.l
        public final void a() {
            Fragment fragment = Fragment.this;
            this.b.set(this.a.apply().c(fragment.generateActivityResultKey(), fragment, this.c, this.d));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class j {
        public boolean a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public ArrayList g;
        public ArrayList h;
        public Object i = null;
        public Object j;
        public Object k;
        public Object l;
        public Object m;
        public Object n;
        public Boolean o;
        public Boolean p;
        public float q;
        public View r;
        public boolean s;

        public j() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.j = obj;
            this.k = null;
            this.l = obj;
            this.m = null;
            this.n = obj;
            this.q = 1.0f;
            this.r = null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class k extends RuntimeException {
        public k(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class l {
        public abstract void a();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class m implements Parcelable {
        public static final Parcelable.Creator<m> CREATOR = new a();
        public final Bundle b;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Parcelable.ClassLoaderCreator<m> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new m(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final m createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new m(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new m[i];
            }
        }

        public m(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.b = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.b);
        }
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new qv();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new b();
        this.mMaxState = androidx.lifecycle.e.b.RESUMED;
        this.mViewLifecycleOwnerLiveData = new yi0();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList<>();
        this.mSavedStateAttachListener = new c();
        initLifecycle();
    }

    public Fragment(int i2) {
        this();
        this.mContentLayoutId = i2;
    }

    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) o.c(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle == null) {
                return fragment;
            }
            bundle.setClassLoader(fragment.getClass().getClassLoader());
            fragment.setArguments(bundle);
            return fragment;
        } catch (IllegalAccessException e2) {
            throw new k(defpackage.e.n("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (InstantiationException e3) {
            throw new k(defpackage.e.n("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e3);
        } catch (NoSuchMethodException e4) {
            throw new k(defpackage.e.n("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e4);
        } catch (InvocationTargetException e5) {
            throw new k(defpackage.e.n("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e5);
        }
    }

    public void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        q qVar;
        j jVar = this.mAnimationInfo;
        if (jVar != null) {
            jVar.s = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (qVar = this.mFragmentManager) == null) {
            return;
        }
        y yVarF = y.f(viewGroup, qVar.G());
        yVarF.h();
        if (z) {
            this.mHost.d.post(new e(yVarF));
        } else {
            yVarF.c();
        }
    }

    public kv createFragmentContainer() {
        return new f();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment(false);
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            xe0.a(this).b(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.v(ak.j(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final j ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new j();
        }
        return this.mAnimationInfo;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.c.c(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final n getActivity() {
        mv mvVar = this.mHost;
        if (mvVar == null) {
            return null;
        }
        return mvVar.b;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        j jVar = this.mAnimationInfo;
        if (jVar == null || (bool = jVar.p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        j jVar = this.mAnimationInfo;
        if (jVar == null || (bool = jVar.o) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        return null;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final q getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(ak.l("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        mv mvVar = this.mHost;
        if (mvVar == null) {
            return null;
        }
        return mvVar.c;
    }

    @Override // androidx.lifecycle.c
    public cj getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && Log.isLoggable("FragmentManager", 3)) {
            Objects.toString(requireContext().getApplicationContext());
        }
        xi0 xi0Var = new xi0();
        LinkedHashMap linkedHashMap = xi0Var.a;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.s.a, application);
        }
        linkedHashMap.put(androidx.lifecycle.o.a, this);
        linkedHashMap.put(androidx.lifecycle.o.b, this);
        if (getArguments() != null) {
            linkedHashMap.put(androidx.lifecycle.o.c, getArguments());
        }
        return xi0Var;
    }

    @Override // androidx.lifecycle.c
    public androidx.lifecycle.t.b getDefaultViewModelProviderFactory() {
        Application application = null;
        if (this.mFragmentManager == null) {
            defpackage.d.AnonymousClass0.m("Can't access ViewModels from detached fragment");
            return null;
        }
        if (this.mDefaultFactory == null) {
            for (Context applicationContext = requireContext().getApplicationContext(); applicationContext instanceof ContextWrapper; applicationContext = ((ContextWrapper) applicationContext).getBaseContext()) {
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
            }
            if (application == null && Log.isLoggable("FragmentManager", 3)) {
                Objects.toString(requireContext().getApplicationContext());
            }
            this.mDefaultFactory = new androidx.lifecycle.p(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public int getEnterAnim() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 0;
        }
        return jVar.b;
    }

    public Object getEnterTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        return jVar.i;
    }

    public xz0 getEnterTransitionCallback() {
        return null;
    }

    public int getExitAnim() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 0;
        }
        return jVar.c;
    }

    public Object getExitTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        return jVar.k;
    }

    public xz0 getExitTransitionCallback() {
        return null;
    }

    public View getFocusedView() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        return jVar.r;
    }

    public final q getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        mv mvVar = this.mHost;
        if (mvVar == null) {
            return null;
        }
        return n.this;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        mv mvVar = this.mHost;
        if (mvVar == null) {
            defpackage.d.AnonymousClass0.m("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
            return null;
        }
        n nVar = n.this;
        LayoutInflater layoutInflaterCloneInContext = nVar.getLayoutInflater().cloneInContext(nVar);
        layoutInflaterCloneInContext.setFactory2(this.mChildFragmentManager.f);
        return layoutInflaterCloneInContext;
    }

    @Override // defpackage.he0
    public androidx.lifecycle.e getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public xe0 getLoaderManager() {
        return xe0.a(this);
    }

    public final int getMinimumMaxLifecycleState() {
        androidx.lifecycle.e.b bVar = this.mMaxState;
        return (bVar == androidx.lifecycle.e.b.INITIALIZED || this.mParentFragment == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    public int getNextTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 0;
        }
        return jVar.f;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final q getParentFragmentManager() {
        q qVar = this.mFragmentManager;
        if (qVar != null) {
            return qVar;
        }
        throw new IllegalStateException(ak.l("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return false;
        }
        return jVar.a;
    }

    public int getPopEnterAnim() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 0;
        }
        return jVar.d;
    }

    public int getPopExitAnim() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 0;
        }
        return jVar.e;
    }

    public float getPostOnViewCreatedAlpha() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 1.0f;
        }
        return jVar.q;
    }

    public Object getReenterTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.l;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final boolean getRetainInstance() {
        uv.b bVar = uv.a;
        uv.c(new dy(this, "Attempting to get retain instance for fragment " + this));
        uv.a(this).getClass();
        uv.a[] aVarArr = uv.a.o;
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.j;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // defpackage.tx0
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b;
    }

    public Object getSharedElementEnterTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        return jVar.m;
    }

    public Object getSharedElementReturnTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.n;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        j jVar = this.mAnimationInfo;
        return (jVar == null || (arrayList = jVar.g) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        j jVar = this.mAnimationInfo;
        return (jVar == null || (arrayList = jVar.h) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i2) {
        return getResources().getString(i2);
    }

    public final String getString(int i2, Object... objArr) {
        return getResources().getString(i2, objArr);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final Fragment getTargetFragment() {
        return getTargetFragment(true);
    }

    public final Fragment getTargetFragment(boolean z) {
        String str;
        if (z) {
            uv.b bVar = uv.a;
            uv.c(new ey(this, "Attempting to get target fragment from fragment " + this));
            uv.a(this).getClass();
            uv.a[] aVarArr = uv.a.o;
        }
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        q qVar = this.mFragmentManager;
        if (qVar == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return qVar.c.b(str);
    }

    public final int getTargetRequestCode() {
        uv.b bVar = uv.a;
        uv.c(new ey(this, "Attempting to get target request code from fragment " + this));
        uv.a(this).getClass();
        uv.a[] aVarArr = uv.a.o;
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i2) {
        return getResources().getText(i2);
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public he0 getViewLifecycleOwner() {
        x xVar = this.mViewLifecycleOwner;
        if (xVar != null) {
            return xVar;
        }
        defpackage.d.AnonymousClass0.m("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
        return null;
    }

    public LiveData<he0> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // defpackage.ce1
    public be1 getViewModelStore() {
        String str;
        if (this.mFragmentManager == null) {
            str = "Can't access ViewModels from detached fragment";
        } else {
            if (getMinimumMaxLifecycleState() != 1) {
                HashMap map = this.mFragmentManager.M.c;
                be1 be1Var = (be1) map.get(this.mWho);
                if (be1Var != null) {
                    return be1Var;
                }
                be1 be1Var2 = new be1();
                map.put(this.mWho, be1Var2);
                return be1Var2;
            }
            str = "Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported";
        }
        defpackage.d.AnonymousClass0.m(str);
        return null;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void initLifecycle() {
        this.mLifecycleRegistry = new androidx.lifecycle.i(this);
        this.mSavedStateRegistryController = new sx0(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        l lVar = this.mSavedStateAttachListener;
        if (this.mState >= 0) {
            lVar.a();
        } else {
            this.mOnPreAttachedListeners.add(lVar);
        }
    }

    public void initState() {
        initLifecycle();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new qv();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (this.mHidden) {
            return true;
        }
        if (this.mFragmentManager != null) {
            Fragment fragment = this.mParentFragment;
            if (fragment == null ? false : fragment.isHidden()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (!this.mMenuVisible) {
            return false;
        }
        if (this.mFragmentManager != null) {
            Fragment fragment = this.mParentFragment;
            if (!(fragment == null ? true : fragment.isMenuVisible())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPostponed() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return false;
        }
        return jVar.s;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        q qVar = this.mFragmentManager;
        if (qVar == null) {
            return false;
        }
        return qVar.K();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.M();
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (Log.isLoggable("FragmentManager", 2)) {
            toString();
            Objects.toString(intent);
        }
    }

    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        mv mvVar = this.mHost;
        n nVar = mvVar == null ? null : mvVar.b;
        if (nVar != null) {
            this.mCalled = false;
            onAttach((Activity) nVar);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        q qVar = this.mChildFragmentManager;
        if (qVar.t >= 1) {
            return;
        }
        qVar.F = false;
        qVar.G = false;
        qVar.M.f = false;
        qVar.u(1);
    }

    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        return null;
    }

    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        mv mvVar = this.mHost;
        n nVar = mvVar == null ? null : mvVar.b;
        if (nVar != null) {
            this.mCalled = false;
            onInflate((Activity) nVar, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.M();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new g41(ak.l("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            toString();
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
        q qVar = this.mChildFragmentManager;
        qVar.F = false;
        qVar.G = false;
        qVar.M.f = false;
        qVar.u(4);
    }

    public void performAttach() {
        Iterator<l> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.c(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach((Context) this.mHost.c);
        if (!this.mCalled) {
            throw new g41(ak.l("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it2 = this.mFragmentManager.n.iterator();
        while (it2.hasNext()) {
            ((sv) it2.next()).a(this);
        }
        q qVar = this.mChildFragmentManager;
        qVar.F = false;
        qVar.G = false;
        qVar.M.f = false;
        qVar.u(0);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        for (Fragment fragment : this.mChildFragmentManager.c.f()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.j(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.M();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new androidx.lifecycle.h() { // from class: androidx.fragment.app.Fragment.6
            @Override // androidx.lifecycle.h
            public final void a(he0 he0Var, androidx.lifecycle.e.a aVar) {
                View view;
                if (aVar != androidx.lifecycle.e.a.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        this.mSavedStateRegistryController.b(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new g41(ak.l("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.f(androidx.lifecycle.e.a.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z = true;
        }
        return this.mChildFragmentManager.k(menu, menuInflater) | z;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.M();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new x(this, getViewModelStore());
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        x xVar = this.mViewLifecycleOwner;
        if (viewOnCreateView == null) {
            if (xVar.f == null) {
                this.mViewLifecycleOwner = null;
                return;
            } else {
                defpackage.d.AnonymousClass0.m("Called getViewLifecycleOwner() but onCreateView() returned null");
                return;
            }
        }
        xVar.b();
        this.mView.setTag(R.attr.a37, this.mViewLifecycleOwner);
        this.mView.setTag(R.attr.a3_, this.mViewLifecycleOwner);
        this.mView.setTag(R.attr.a39, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.i(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.l();
        this.mLifecycleRegistry.f(androidx.lifecycle.e.a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new g41(ak.l("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.u(1);
        if (this.mView != null) {
            x xVar = this.mViewLifecycleOwner;
            xVar.b();
            if (xVar.f.d.compareTo(androidx.lifecycle.e.b.CREATED) >= 0) {
                x xVar2 = this.mViewLifecycleOwner;
                xVar2.f.f(androidx.lifecycle.e.a.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new g41(ak.l("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        z11 z11Var = xe0.a(this).b.a;
        if (z11Var.g() <= 0) {
            this.mPerformedCreateView = false;
        } else {
            z11Var.h(0).getClass();
            defpackage.d.AnonymousClass0.m$1();
        }
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new g41(ak.l("Fragment ", this, " did not call through to super.onDetach()"));
        }
        q qVar = this.mChildFragmentManager;
        if (qVar.H) {
            return;
        }
        qVar.l();
        this.mChildFragmentManager = new qv();
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
        for (Fragment fragment : this.mChildFragmentManager.c.f()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        for (Fragment fragment : this.mChildFragmentManager.c.f()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.p(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.q(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.u(5);
        if (this.mView != null) {
            x xVar = this.mViewLifecycleOwner;
            xVar.f.f(androidx.lifecycle.e.a.ON_PAUSE);
        }
        this.mLifecycleRegistry.f(androidx.lifecycle.e.a.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new g41(ak.l("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        for (Fragment fragment : this.mChildFragmentManager.c.f()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z = true;
        }
        return this.mChildFragmentManager.t(menu) | z;
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean zJ = q.J(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zJ) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zJ);
            onPrimaryNavigationFragmentChanged(zJ);
            q qVar = this.mChildFragmentManager;
            qVar.a0();
            qVar.r(qVar.x);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.M();
        this.mChildFragmentManager.y(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new g41(ak.l("Fragment ", this, " did not call through to super.onResume()"));
        }
        androidx.lifecycle.i iVar = this.mLifecycleRegistry;
        androidx.lifecycle.e.a aVar = androidx.lifecycle.e.a.ON_RESUME;
        iVar.f(aVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.f.f(aVar);
        }
        q qVar = this.mChildFragmentManager;
        qVar.F = false;
        qVar.G = false;
        qVar.M.f = false;
        qVar.u(7);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.c(bundle);
        bundle.putParcelable("android:support:fragments", this.mChildFragmentManager.T());
    }

    public void performStart() {
        this.mChildFragmentManager.M();
        this.mChildFragmentManager.y(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new g41(ak.l("Fragment ", this, " did not call through to super.onStart()"));
        }
        androidx.lifecycle.i iVar = this.mLifecycleRegistry;
        androidx.lifecycle.e.a aVar = androidx.lifecycle.e.a.ON_START;
        iVar.f(aVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.f.f(aVar);
        }
        q qVar = this.mChildFragmentManager;
        qVar.F = false;
        qVar.G = false;
        qVar.M.f = false;
        qVar.u(5);
    }

    public void performStop() {
        q qVar = this.mChildFragmentManager;
        qVar.G = true;
        qVar.M.f = true;
        qVar.u(4);
        if (this.mView != null) {
            x xVar = this.mViewLifecycleOwner;
            xVar.f.f(androidx.lifecycle.e.a.ON_STOP);
        }
        this.mLifecycleRegistry.f(androidx.lifecycle.e.a.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new g41(ak.l("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.u(2);
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().s = true;
    }

    public final void postponeEnterTransition(long j2, TimeUnit timeUnit) {
        ensureAnimationInfo().s = true;
        q qVar = this.mFragmentManager;
        Handler handler = qVar != null ? qVar.u.d : new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
    }

    public final a prepareCallInternal(l2 l2Var, jx jxVar, k2 k2Var) {
        if (this.mState > 1) {
            throw new IllegalStateException(ak.l("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
        }
        AtomicReference atomicReference = new AtomicReference();
        i iVar = new i(jxVar, atomicReference, l2Var, k2Var);
        if (this.mState >= 0) {
            iVar.a();
        } else {
            this.mOnPreAttachedListeners.add(iVar);
        }
        return new a(atomicReference);
    }

    public final <I, O> o2 registerForActivityResult(l2 l2Var, k2 k2Var) {
        return prepareCallInternal(l2Var, new g(), k2Var);
    }

    public final <I, O> o2 registerForActivityResult(l2 l2Var, q2 q2Var, k2 k2Var) {
        return prepareCallInternal(l2Var, new h(q2Var), k2Var);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(String[] strArr, int i2) {
        if (this.mHost == null) {
            throw new IllegalStateException(ak.l("Fragment ", this, " not attached to Activity"));
        }
        q parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.C == null) {
            parentFragmentManager.u.getClass();
            return;
        }
        parentFragmentManager.D.addLast(new q.k(this.mWho, i2));
        parentFragmentManager.C.a(strArr);
    }

    public final n requireActivity() {
        n activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(ak.l("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(ak.l("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(ak.l("Fragment ", this, " not attached to a context."));
    }

    public final q requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(ak.l("Fragment ", this, " not attached to a host."));
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(ak.l("Fragment ", this, " is not attached to any Fragment or host"));
        }
        StringBuilder sb = new StringBuilder("Fragment ");
        sb.append(this);
        Context context = getContext();
        sb.append(" is not a child Fragment, it is directly attached to ");
        sb.append(context);
        throw new IllegalStateException(sb.toString());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(ak.l("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.S(parcelable);
        q qVar = this.mChildFragmentManager;
        qVar.F = false;
        qVar.G = false;
        qVar.M.f = false;
        qVar.u(1);
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            x xVar = this.mViewLifecycleOwner;
            xVar.g.b(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new g41(ak.l("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            x xVar2 = this.mViewLifecycleOwner;
            xVar2.f.f(androidx.lifecycle.e.a.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().p = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().o = Boolean.valueOf(z);
    }

    public void setAnimations(int i2, int i3, int i4, int i5) {
        if (this.mAnimationInfo == null && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return;
        }
        ensureAnimationInfo().b = i2;
        ensureAnimationInfo().c = i3;
        ensureAnimationInfo().d = i4;
        ensureAnimationInfo().e = i5;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager == null || !isStateSaved()) {
            this.mArguments = bundle;
        } else {
            defpackage.d.AnonymousClass0.m("Fragment already added and state has been saved");
        }
    }

    public void setEnterSharedElementCallback(xz0 xz0Var) {
        ensureAnimationInfo().getClass();
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().i = obj;
    }

    public void setExitSharedElementCallback(xz0 xz0Var) {
        ensureAnimationInfo().getClass();
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().k = obj;
    }

    public void setFocusedView(View view) {
        ensureAnimationInfo().r = view;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            n.this.invalidateOptionsMenu();
        }
    }

    public void setInitialSavedState(m mVar) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            defpackage.d.AnonymousClass0.m("Fragment already added");
            return;
        }
        if (mVar == null || (bundle = mVar.b) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                n.this.invalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int i2) {
        if (this.mAnimationInfo == null && i2 == 0) {
            return;
        }
        ensureAnimationInfo();
        this.mAnimationInfo.f = i2;
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        ensureAnimationInfo().a = z;
    }

    public void setPostOnViewCreatedAlpha(float f2) {
        ensureAnimationInfo().q = f2;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().l = obj;
    }

    public void setRetainInstance(boolean z) {
        uv.b bVar = uv.a;
        uv.c(new dy(this, "Attempting to set retain instance for fragment " + this));
        uv.a(this).getClass();
        uv.a[] aVarArr = uv.a.o;
        this.mRetainInstance = z;
        q qVar = this.mFragmentManager;
        if (qVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
            return;
        }
        s sVar = qVar.M;
        if (z) {
            sVar.a(this);
        } else {
            sVar.c(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().j = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().m = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ensureAnimationInfo();
        j jVar = this.mAnimationInfo;
        jVar.g = arrayList;
        jVar.h = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().n = obj;
    }

    public void setTargetFragment(Fragment fragment, int i2) {
        if (fragment != null) {
            uv.b bVar = uv.a;
            uv.c(new ey(this, "Attempting to set target fragment " + fragment + " with request code " + i2 + " for fragment " + this));
            uv.a(this).getClass();
            uv.a[] aVarArr = uv.a.o;
        }
        q qVar = this.mFragmentManager;
        q qVar2 = fragment != null ? fragment.mFragmentManager : null;
        if (qVar != null && qVar2 != null && qVar != qVar2) {
            throw new IllegalArgumentException(ak.l("Fragment ", fragment, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (Fragment targetFragment = fragment; targetFragment != null; targetFragment = targetFragment.getTargetFragment(false)) {
            if (targetFragment.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment != null) {
            if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
                this.mTargetWho = null;
                this.mTarget = fragment;
            } else {
                this.mTargetWho = fragment.mWho;
            }
            this.mTargetRequestCode = i2;
        }
        this.mTargetWho = null;
        this.mTarget = null;
        this.mTargetRequestCode = i2;
    }

    public void setUserVisibleHint(boolean z) {
        uv.b bVar = uv.a;
        uv.c(new tv(this, "Attempting to set user visible hint to " + z + " for fragment " + this));
        uv.a(this).getClass();
        uv.a[] aVarArr = uv.a.o;
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            q qVar = this.mFragmentManager;
            u uVarG = qVar.g(this);
            Fragment fragment = uVarG.c;
            if (fragment.mDeferStart) {
                if (qVar.b) {
                    qVar.I = true;
                } else {
                    fragment.mDeferStart = false;
                    uVarG.i();
                }
            }
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 5 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        mv mvVar = this.mHost;
        if (mvVar != null) {
            n.a aVar = (n.a) mvVar;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
                n nVar = n.this;
                if (i2 < 32 && i2 == 31) {
                    try {
                        return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(nVar.getApplication().getPackageManager(), str)).booleanValue();
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                        return nVar.shouldShowRequestPermissionRationale(str);
                    }
                }
                return nVar.shouldShowRequestPermissionRationale(str);
            }
        }
        return false;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        mv mvVar = this.mHost;
        if (mvVar == null) {
            throw new IllegalStateException(ak.l("Fragment ", this, " not attached to Activity"));
        }
        mvVar.c.startActivity(intent, bundle);
    }

    public void startActivityForResult(Intent intent, int i2) {
        startActivityForResult(intent, i2, null);
    }

    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(ak.l("Fragment ", this, " not attached to Activity"));
        }
        q parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.A != null) {
            parentFragmentManager.D.addLast(new q.k(this.mWho, i2));
            if (intent != null && bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            parentFragmentManager.A.a(intent);
            return;
        }
        mv mvVar = parentFragmentManager.u;
        if (i2 == -1) {
            mvVar.c.startActivity(intent, bundle);
        } else {
            mvVar.getClass();
            defpackage.d.AnonymousClass0.m("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(ak.l("Fragment ", this, " not attached to Activity"));
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            toString();
            Objects.toString(intentSender);
            Objects.toString(intent);
            Objects.toString(bundle);
        }
        q parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.B == null) {
            mv mvVar = parentFragmentManager.u;
            if (i2 == -1) {
                mvVar.b.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
                return;
            } else {
                mvVar.getClass();
                defpackage.d.AnonymousClass0.m("Starting intent sender with a requestCode requires a FragmentActivity host");
                return;
            }
        }
        if (bundle != null) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (Log.isLoggable("FragmentManager", 2)) {
                bundle.toString();
                intent.toString();
                Objects.toString(this);
            }
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        g30 g30Var = new g30(intentSender, intent, i3, i4);
        parentFragmentManager.D.addLast(new q.k(this.mWho, i2));
        if (Log.isLoggable("FragmentManager", 2)) {
            toString();
        }
        parentFragmentManager.B.a(g30Var);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !ensureAnimationInfo().s) {
            return;
        }
        if (this.mHost == null) {
            ensureAnimationInfo().s = false;
        } else if (Looper.myLooper() != this.mHost.d.getLooper()) {
            this.mHost.d.postAtFrontOfQueue(new d());
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }
}
