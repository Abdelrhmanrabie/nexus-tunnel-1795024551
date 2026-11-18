package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ak;
import defpackage.mv;
import defpackage.tv;
import defpackage.uv;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class p implements LayoutInflater.Factory2 {
    public final q b;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ u b;

        public a(u uVar) {
            this.b = uVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            u uVar = this.b;
            Fragment fragment = uVar.c;
            uVar.i();
            y.f((ViewGroup) fragment.mView.getParent(), p.this.b.G()).e();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    public p(q qVar) {
        this.b = qVar;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00ea A[PHI: r0 r13
      0x00ea: PHI (r0v9 androidx.fragment.app.Fragment) = (r0v7 androidx.fragment.app.Fragment), (r0v12 androidx.fragment.app.Fragment) binds: [B:48:0x00e8, B:43:0x00ca] A[DONT_GENERATE, DONT_INLINE]
      0x00ea: PHI (r13v10 androidx.fragment.app.u) = (r13v9 androidx.fragment.app.u), (r13v17 androidx.fragment.app.u) binds: [B:48:0x00e8, B:43:0x00ca] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        u uVarG;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        q qVar = this.b;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, qVar);
        }
        if (AppConfig.TAG_FRAGMENT.equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ak.L);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(0);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            String string = typedArrayObtainStyledAttributes.getString(2);
            typedArrayObtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = Fragment.class.isAssignableFrom(o.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    Fragment fragmentC = resourceId != -1 ? qVar.C(resourceId) : null;
                    if (fragmentC == null && string != null) {
                        fragmentC = qVar.D(string);
                    }
                    if (fragmentC == null && id != -1) {
                        fragmentC = qVar.C(id);
                    }
                    if (fragmentC == null) {
                        o oVarF = qVar.F();
                        context.getClassLoader();
                        fragmentC = oVarF.a(attributeValue);
                        fragmentC.mFromLayout = true;
                        fragmentC.mFragmentId = resourceId != 0 ? resourceId : id;
                        fragmentC.mContainerId = id;
                        fragmentC.mTag = string;
                        fragmentC.mInLayout = true;
                        fragmentC.mFragmentManager = qVar;
                        mv mvVar = qVar.u;
                        fragmentC.mHost = mvVar;
                        fragmentC.onInflate((Context) mvVar.c, attributeSet, fragmentC.mSavedFragmentState);
                        uVarG = qVar.a(fragmentC);
                        if (Log.isLoggable("FragmentManager", 2)) {
                            fragmentC.toString();
                            Integer.toHexString(resourceId);
                        }
                    } else {
                        if (fragmentC.mInLayout) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        fragmentC.mInLayout = true;
                        fragmentC.mFragmentManager = qVar;
                        mv mvVar2 = qVar.u;
                        fragmentC.mHost = mvVar2;
                        fragmentC.onInflate((Context) mvVar2.c, attributeSet, fragmentC.mSavedFragmentState);
                        uVarG = qVar.g(fragmentC);
                        if (Log.isLoggable("FragmentManager", 2)) {
                            fragmentC.toString();
                            Integer.toHexString(resourceId);
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    uv.b bVar = uv.a;
                    uv.c(new tv(fragmentC, "Attempting to use <fragment> tag to add fragment " + fragmentC + " to container " + viewGroup));
                    uv.a(fragmentC).getClass();
                    uv.a[] aVarArr = uv.a.o;
                    fragmentC.mContainer = viewGroup;
                    uVarG.i();
                    uVarG.h();
                    View view2 = fragmentC.mView;
                    if (view2 == null) {
                        throw new IllegalStateException(defpackage.e.n("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragmentC.mView.getTag() == null) {
                        fragmentC.mView.setTag(string);
                    }
                    fragmentC.mView.addOnAttachStateChangeListener(new a(uVarG));
                    return fragmentC.mView;
                }
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
