package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import defpackage.ak;
import defpackage.ce1;
import defpackage.fb$1;
import defpackage.mv;
import defpackage.nv;
import defpackage.qd1;
import defpackage.tv;
import defpackage.uv;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class u {
    public final nv a;
    public final v b;
    public final Fragment c;
    public boolean d = false;
    public int e = -1;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View b;

        public a(View view) {
            this.b = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            View view2 = this.b;
            view2.removeOnAttachStateChangeListener(this);
            WeakHashMap weakHashMap = qd1.a;
            view2.requestApplyInsets();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    public u(nv nvVar, v vVar, Fragment fragment) {
        this.a = nvVar;
        this.b = vVar;
        this.c = fragment;
    }

    public u(nv nvVar, v vVar, Fragment fragment, t tVar) {
        this.a = nvVar;
        this.b = vVar;
        this.c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = tVar.s;
        fragment.mSavedFragmentState = bundle == null ? new Bundle() : bundle;
    }

    public u(nv nvVar, v vVar, ClassLoader classLoader, o oVar, t tVar) {
        this.a = nvVar;
        this.b = vVar;
        Fragment fragmentA = oVar.a(tVar.b);
        Bundle bundle = tVar.p;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentA.setArguments(bundle);
        fragmentA.mWho = tVar.c;
        fragmentA.mFromLayout = tVar.d;
        fragmentA.mRestored = true;
        fragmentA.mFragmentId = tVar.f;
        fragmentA.mContainerId = tVar.g;
        fragmentA.mTag = tVar.i;
        fragmentA.mRetainInstance = tVar.j;
        fragmentA.mRemoving = tVar.n;
        fragmentA.mDetached = tVar.o;
        fragmentA.mHidden = tVar.q;
        fragmentA.mMaxState = androidx.lifecycle.e.b.values()[tVar.r];
        Bundle bundle2 = tVar.s;
        fragmentA.mSavedFragmentState = bundle2 == null ? new Bundle() : bundle2;
        this.c = fragmentA;
        if (Log.isLoggable("FragmentManager", 2)) {
            Objects.toString(fragmentA);
        }
    }

    public final void a() {
        int iIndexOfChild;
        View view;
        View view2;
        v vVar = this.b;
        vVar.getClass();
        Fragment fragment = this.c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            iIndexOfChild = -1;
            break;
        }
        ArrayList arrayList = vVar.a;
        int iIndexOf = arrayList.indexOf(fragment);
        for (int i = iIndexOf - 1; i >= 0; i--) {
            Fragment fragment2 = (Fragment) arrayList.get(i);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= arrayList.size()) {
                iIndexOfChild = -1;
                break;
            }
            Fragment fragment3 = (Fragment) arrayList.get(iIndexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                iIndexOfChild = viewGroup.indexOfChild(view);
                break;
            }
        }
        fragment.mContainer.addView(fragment.mView, iIndexOfChild);
    }

    public final void b() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.c;
        if (zIsLoggable) {
            Objects.toString(fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        v vVar = this.b;
        u uVar = null;
        if (fragment2 != null) {
            u uVar2 = (u) vVar.b.get(fragment2.mWho);
            if (uVar2 == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                Fragment fragment3 = fragment.mTarget;
                sb.append(" declared target fragment ");
                sb.append(fragment3);
                sb.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(sb.toString());
            }
            fragment.mTargetWho = fragment.mTarget.mWho;
            fragment.mTarget = null;
            uVar = uVar2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (uVar = (u) vVar.b.get(str)) == null) {
                StringBuilder sb2 = new StringBuilder("Fragment ");
                sb2.append(fragment);
                sb2.append(" declared target fragment ");
                throw new IllegalStateException(fb$1.m(sb2, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (uVar != null) {
            uVar.i();
        }
        q qVar = fragment.mFragmentManager;
        fragment.mHost = qVar.u;
        fragment.mParentFragment = qVar.w;
        nv nvVar = this.a;
        nvVar.g();
        fragment.performAttach();
        nvVar.b();
    }

    public final int c() {
        Fragment fragment = this.c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int iMin = this.e;
        int iOrdinal = fragment.mMaxState.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (fragment.mFromLayout) {
            boolean z = fragment.mInLayout;
            int i = this.e;
            if (z) {
                iMin = Math.max(i, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = i < 4 ? Math.min(iMin, fragment.mState) : Math.min(iMin, 1);
            }
        }
        if (!fragment.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        y.d.b bVar = null;
        y.d dVar = null;
        if (viewGroup != null) {
            y yVarF = y.f(viewGroup, fragment.getParentFragmentManager().G());
            y.d dVarD = yVarF.d(fragment);
            y.d.b bVar2 = dVarD != null ? dVarD.b : null;
            for (y.d dVar2 : yVarF.c) {
                if (dVar2.c.equals(fragment) && !dVar2.f) {
                    dVar = dVar2;
                    break;
                }
            }
            bVar = (dVar == null || !(bVar2 == null || bVar2 == y.d.b.NONE)) ? bVar2 : dVar.b;
        }
        if (bVar == y.d.b.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (bVar == y.d.b.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else if (fragment.mRemoving) {
            iMin = fragment.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Objects.toString(fragment);
        }
        return iMin;
    }

    public final void d() {
        String resourceName;
        Fragment fragment = this.c;
        if (fragment.mFromLayout) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Objects.toString(fragment);
        }
        LayoutInflater layoutInflaterPerformGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            int i = fragment.mContainerId;
            if (i == 0) {
                viewGroup = null;
            } else {
                if (i == -1) {
                    throw new IllegalArgumentException(ak.l("Cannot create fragment ", fragment, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) fragment.mFragmentManager.v.b(i);
                if (viewGroup == null) {
                    if (!fragment.mRestored) {
                        try {
                            resourceName = fragment.getResources().getResourceName(fragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + resourceName + ") for fragment " + fragment);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    uv.b bVar = uv.a;
                    uv.c(new tv(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView"));
                    uv.a(fragment).getClass();
                    uv.a[] aVarArr = uv.a.o;
                }
            }
        }
        fragment.mContainer = viewGroup;
        fragment.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            fragment.mView.setTag(R.attr.ln, fragment);
            if (viewGroup != null) {
                a();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view2 = fragment.mView;
            WeakHashMap weakHashMap = qd1.a;
            boolean zIsAttachedToWindow = view2.isAttachedToWindow();
            View view3 = fragment.mView;
            if (zIsAttachedToWindow) {
                view3.requestApplyInsets();
            } else {
                view3.addOnAttachStateChangeListener(new a(view3));
            }
            fragment.performViewCreated();
            this.a.m();
            int visibility = fragment.mView.getVisibility();
            fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
            if (fragment.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment.mView.findFocus();
                if (viewFindFocus != null) {
                    fragment.setFocusedView(viewFindFocus);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        viewFindFocus.toString();
                        Objects.toString(fragment);
                    }
                }
                fragment.mView.setAlpha(0.0f);
            }
        }
        fragment.mState = 2;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    public final void e() {
        boolean z;
        Fragment fragmentB;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.c;
        if (zIsLoggable) {
            Objects.toString(fragment);
        }
        boolean zIsChangingConfigurations = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        v vVar = this.b;
        if (z2 && !fragment.mBeingSaved) {
        }
        if (z2) {
            z = true;
        } else {
            s sVar = vVar.d;
            if ((sVar.a.containsKey(fragment.mWho) && sVar.d) ? sVar.e : true) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            String str = fragment.mTargetWho;
            if (str != null && (fragmentB = vVar.b(str)) != null && fragmentB.mRetainInstance) {
                fragment.mTarget = fragmentB;
            }
            fragment.mState = 0;
            return;
        }
        mv mvVar = fragment.mHost;
        if (mvVar instanceof ce1) {
            zIsChangingConfigurations = vVar.d.e;
        } else {
            n nVar = mvVar.c;
            if (nVar != null) {
                zIsChangingConfigurations = true ^ nVar.isChangingConfigurations();
            }
        }
        if ((z2 && !fragment.mBeingSaved) || zIsChangingConfigurations) {
            s sVar2 = vVar.d;
            sVar2.getClass();
            if (Log.isLoggable("FragmentManager", 3)) {
                Objects.toString(fragment);
            }
            sVar2.b(fragment.mWho);
        }
        fragment.performDestroy();
        this.a.d();
        for (u uVar : vVar.d()) {
            if (uVar != null) {
                String str2 = fragment.mWho;
                Fragment fragment2 = uVar.c;
                if (str2.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        String str3 = fragment.mTargetWho;
        if (str3 != null) {
            fragment.mTarget = vVar.b(str3);
        }
        vVar.h(this);
    }

    public final void f() {
        View view;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.c;
        if (zIsLoggable) {
            Objects.toString(fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        fragment.performDestroyView();
        this.a.n();
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.i(null);
        fragment.mInLayout = false;
    }

    public final void g() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.c;
        if (zIsLoggable) {
            Objects.toString(fragment);
        }
        fragment.performDetach();
        this.a.e();
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            s sVar = this.b.d;
            if (!((sVar.a.containsKey(fragment.mWho) && sVar.d) ? sVar.e : true)) {
                return;
            }
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Objects.toString(fragment);
        }
        fragment.initState();
    }

    public final void h() {
        Fragment fragment = this.c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (Log.isLoggable("FragmentManager", 3)) {
                Objects.toString(fragment);
            }
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(R.attr.ln, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.performViewCreated();
                this.a.m();
                fragment.mState = 2;
            }
        }
    }

    public final void i() {
        ViewGroup viewGroup;
        y.d.c cVar;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z = this.d;
        Fragment fragment = this.c;
        if (z) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Objects.toString(fragment);
                return;
            }
            return;
        }
        try {
            this.d = true;
            boolean z2 = false;
            while (true) {
                int iC = c();
                int i = fragment.mState;
                v vVar = this.b;
                if (iC == i) {
                    if (!z2 && i == -1 && fragment.mRemoving && !fragment.isInBackStack() && !fragment.mBeingSaved) {
                        if (Log.isLoggable("FragmentManager", 3)) {
                            Objects.toString(fragment);
                        }
                        s sVar = vVar.d;
                        sVar.getClass();
                        if (Log.isLoggable("FragmentManager", 3)) {
                            Objects.toString(fragment);
                        }
                        sVar.b(fragment.mWho);
                        vVar.h(this);
                        if (Log.isLoggable("FragmentManager", 3)) {
                            Objects.toString(fragment);
                        }
                        fragment.initState();
                    }
                    if (fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            y yVarF = y.f(viewGroup, fragment.getParentFragmentManager().G());
                            boolean z3 = fragment.mHidden;
                            y.d.b bVar = y.d.b.NONE;
                            if (z3) {
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Objects.toString(fragment);
                                }
                                cVar = y.d.c.GONE;
                            } else {
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Objects.toString(fragment);
                                }
                                cVar = y.d.c.VISIBLE;
                            }
                            yVarF.a(cVar, bVar, this);
                        }
                        q qVar = fragment.mFragmentManager;
                        if (qVar != null && fragment.mAdded && q.I(fragment)) {
                            qVar.E = true;
                        }
                        fragment.mHiddenChanged = false;
                        fragment.onHiddenChanged(fragment.mHidden);
                        fragment.mChildFragmentManager.o();
                    }
                    return;
                }
                nv nvVar = this.a;
                if (iC > i) {
                    switch (i + 1) {
                        case 0:
                            b();
                            continue;
                        case 1:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Objects.toString(fragment);
                            }
                            if (!fragment.mIsCreated) {
                                nvVar.h();
                                fragment.performCreate(fragment.mSavedFragmentState);
                                nvVar.c();
                            } else {
                                fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
                            }
                            break;
                        case 2:
                            h();
                            d();
                            continue;
                        case 3:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Objects.toString(fragment);
                            }
                            fragment.performActivityCreated(fragment.mSavedFragmentState);
                            nvVar.a();
                            continue;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                y yVarF2 = y.f(viewGroup3, fragment.getParentFragmentManager().G());
                                y.d.c cVarB = y.d.c.b(fragment.mView.getVisibility());
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Objects.toString(fragment);
                                }
                                yVarF2.a(cVarB, y.d.b.ADDING, this);
                            }
                            fragment.mState = 4;
                            continue;
                        case 5:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Objects.toString(fragment);
                            }
                            fragment.performStart();
                            nvVar.k();
                            continue;
                        case 6:
                            fragment.mState = 6;
                            continue;
                        case 7:
                            k();
                            continue;
                        default:
                            continue;
                    }
                    fragment.mState = 1;
                } else {
                    switch (i - 1) {
                        case -1:
                            g();
                            continue;
                        case 0:
                            if (fragment.mBeingSaved) {
                                if (((t) vVar.c.get(fragment.mWho)) == null) {
                                    l();
                                }
                            }
                            e();
                            continue;
                        case 1:
                            f();
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            continue;
                        case 3:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Objects.toString(fragment);
                            }
                            if (fragment.mBeingSaved) {
                                l();
                            } else if (fragment.mView != null && fragment.mSavedViewState == null) {
                                m();
                            }
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                y yVarF3 = y.f(viewGroup2, fragment.getParentFragmentManager().G());
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Objects.toString(fragment);
                                }
                                yVarF3.a(y.d.c.REMOVED, y.d.b.REMOVING, this);
                            }
                            fragment.mState = 3;
                            continue;
                        case 4:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Objects.toString(fragment);
                            }
                            fragment.performStop();
                            nvVar.l();
                            continue;
                        case 5:
                            fragment.mState = 5;
                            continue;
                        case 6:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Objects.toString(fragment);
                            }
                            fragment.performPause();
                            nvVar.f();
                            continue;
                        default:
                            continue;
                    }
                    fragment.mState = 1;
                }
                z2 = true;
            }
        } finally {
            this.d = false;
        }
    }

    public final void j(ClassLoader classLoader) {
        Fragment fragment = this.c;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("android:view_registry_state");
        String string = fragment.mSavedFragmentState.getString("android:target_state");
        fragment.mTargetWho = string;
        if (string != null) {
            fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Boolean bool = fragment.mSavedUserVisibleHint;
        if (bool != null) {
            fragment.mUserVisibleHint = bool.booleanValue();
            fragment.mSavedUserVisibleHint = null;
        } else {
            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (fragment.mUserVisibleHint) {
            return;
        }
        fragment.mDeferStart = true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d  */
    public final void k() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.c;
        if (zIsLoggable) {
            Objects.toString(fragment);
        }
        View focusedView = fragment.getFocusedView();
        if (focusedView != null) {
            if (focusedView == fragment.mView) {
                focusedView.requestFocus();
                if (Log.isLoggable("FragmentManager", 2)) {
                    focusedView.toString();
                    Objects.toString(fragment);
                    Objects.toString(fragment.mView.findFocus());
                }
            } else {
                ViewParent parent = focusedView.getParent();
                while (true) {
                    if (parent != null) {
                        if (parent == fragment.mView) {
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
                focusedView.requestFocus();
                if (Log.isLoggable("FragmentManager", 2)) {
                    focusedView.toString();
                    Objects.toString(fragment);
                    Objects.toString(fragment.mView.findFocus());
                }
            }
        }
        fragment.setFocusedView(null);
        fragment.performResume();
        this.a.i();
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final void l() {
        Fragment fragment = this.c;
        t tVar = new t(fragment);
        if (fragment.mState <= -1 || tVar.s != null) {
            tVar.s = fragment.mSavedFragmentState;
        } else {
            Bundle bundle = new Bundle();
            fragment.performSaveInstanceState(bundle);
            this.a.j();
            if (bundle.isEmpty()) {
                bundle = null;
            }
            if (fragment.mView != null) {
                m();
            }
            if (fragment.mSavedViewState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
            }
            if (fragment.mSavedViewRegistryState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBundle("android:view_registry_state", fragment.mSavedViewRegistryState);
            }
            if (!fragment.mUserVisibleHint) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
            }
            tVar.s = bundle;
            if (fragment.mTargetWho != null) {
                if (bundle == null) {
                    tVar.s = new Bundle();
                }
                tVar.s.putString("android:target_state", fragment.mTargetWho);
                int i = fragment.mTargetRequestCode;
                if (i != 0) {
                    tVar.s.putInt("android:target_req_state", i);
                }
            }
        }
    }

    public final void m() {
        Fragment fragment = this.c;
        if (fragment.mView == null) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Objects.toString(fragment);
            Objects.toString(fragment.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.mViewLifecycleOwner.g.c(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        fragment.mSavedViewRegistryState = bundle;
    }
}
