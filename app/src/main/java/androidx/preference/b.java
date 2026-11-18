package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.o;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.ak;
import defpackage.qd1;
import defpackage.te0;
import defpackage.ti0;
import defpackage.tp0;
import defpackage.vp0;
import defpackage.zp;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends Fragment implements androidx.preference.e.c, androidx.preference.e.a, androidx.preference.e.b, DialogPreference.a {
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private static final String TAG = "PreferenceFragment";
    private boolean mHavePrefs;
    private boolean mInitDone;
    RecyclerView mList;
    private androidx.preference.e mPreferenceManager;
    private Runnable mSelectPreferenceRunnable;
    private final d mDividerDecoration = new d();
    private int mLayoutResId = R.layout.et;
    private final Handler mHandler = new a(Looper.getMainLooper());
    private final Runnable mRequestFocus = new RunnableC0022b();

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            b.this.bindPreferences();
        }
    }

    /* JADX INFO: renamed from: androidx.preference.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class RunnableC0022b implements Runnable {
        public RunnableC0022b() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView recyclerView = b.this.mList;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class c implements Runnable {
        public final /* synthetic */ Preference b;
        public final /* synthetic */ String c;

        public c(Preference preference, String str) {
            this.b = preference;
            this.c = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            b bVar = b.this;
            RecyclerView.g gVar = bVar.mList.mAdapter;
            if (!(gVar instanceof PreferenceGroup.a)) {
                if (gVar == 0) {
                    return;
                }
                defpackage.d.AnonymousClass0.m("Adapter must implement PreferencePositionCallback");
                return;
            }
            PreferenceGroup.a aVar = (PreferenceGroup.a) gVar;
            String str = this.c;
            Preference preference = this.b;
            int iA = preference != null ? aVar.a(preference) : aVar.b(str);
            RecyclerView recyclerView = bVar.mList;
            if (iA != -1) {
                recyclerView.scrollToPosition(iA);
            } else {
                gVar.mObservable.registerObserver(new h(gVar, recyclerView, preference, str));
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d extends RecyclerView.n {
        public Drawable a;
        public int b;
        public boolean c = true;

        public d() {
        }

        public final boolean d(View view, RecyclerView recyclerView) {
            RecyclerView.d0 childViewHolder = recyclerView.getChildViewHolder(view);
            if (!(childViewHolder instanceof vp0) || !((vp0) childViewHolder).e) {
                return false;
            }
            boolean z = this.c;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z;
            }
            RecyclerView.d0 childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(iIndexOfChild + 1));
            return (childViewHolder2 instanceof vp0) && ((vp0) childViewHolder2).d;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView) {
            if (d(view, recyclerView)) {
                rect.bottom = this.b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public final void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
            if (this.a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (d(childAt, recyclerView)) {
                    int height = childAt.getHeight() + ((int) childAt.getY());
                    this.a.setBounds(0, height, width, this.b + height);
                    this.a.draw(canvas);
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface e {
        boolean a();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface f {
        boolean a();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface g {
        boolean a();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class h extends RecyclerView.i {
        public final RecyclerView.g a;
        public final RecyclerView b;
        public final Preference c;
        public final String d;

        public h(RecyclerView.g<?> gVar, RecyclerView recyclerView, Preference preference, String str) {
            this.a = gVar;
            this.b = recyclerView;
            this.c = preference;
            this.d = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            RecyclerView.g gVar = this.a;
            gVar.mObservable.unregisterObserver(this);
            PreferenceGroup.a aVar = (PreferenceGroup.a) gVar;
            Preference preference = this.c;
            int iA = preference != null ? aVar.a(preference) : aVar.b(this.d);
            if (iA != -1) {
                this.b.scrollToPosition(iA);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onChanged() {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeChanged() {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void onItemRangeChanged(int i, Preference preference) {
            a();
        }
    }

    public void addPreferencesFromResource(int i) {
        androidx.preference.e eVar = this.mPreferenceManager;
        if (eVar == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
        setPreferenceScreen(eVar.e(requireContext(), i, getPreferenceScreen()));
    }

    public void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(onCreateAdapter(preferenceScreen));
            preferenceScreen.k();
        }
        onBindPreferences();
    }

    @Override // androidx.preference.DialogPreference.a
    public <T extends Preference> T findPreference(CharSequence charSequence) {
        PreferenceScreen preferenceScreen;
        androidx.preference.e eVar = this.mPreferenceManager;
        if (eVar == null || (preferenceScreen = eVar.g) == null) {
            return null;
        }
        return (T) preferenceScreen.A(charSequence);
    }

    public Fragment getCallbackFragment() {
        return null;
    }

    public final RecyclerView getListView() {
        return this.mList;
    }

    public androidx.preference.e getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.g;
    }

    public void onBindPreferences() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(R.style.x9, typedValue, true);
        int i = typedValue.resourceId;
        if (i == 0) {
            i = R.plurals.iy;
        }
        requireContext().getTheme().applyStyle(i, false);
        androidx.preference.e eVar = new androidx.preference.e(requireContext());
        this.mPreferenceManager = eVar;
        eVar.j = this;
        onCreatePreferences(bundle, getArguments() != null ? getArguments().getString(ARG_PREFERENCE_ROOT) : null);
    }

    public RecyclerView.g onCreateAdapter(PreferenceScreen preferenceScreen) {
        return new androidx.preference.c(preferenceScreen);
    }

    public RecyclerView.o onCreateLayoutManager() {
        return new LinearLayoutManager(requireContext());
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.attr.vh)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.ev, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        tp0 tp0Var = new tp0(recyclerView2);
        recyclerView2.mAccessibilityDelegate = tp0Var;
        qd1.l(recyclerView2, tp0Var);
        return recyclerView2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = requireContext().obtainStyledAttributes(null, ak.h, R.style.x3, 0);
        this.mLayoutResId = typedArrayObtainStyledAttributes.getResourceId(0, this.mLayoutResId);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(3, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(requireContext());
        View viewInflate = layoutInflaterCloneInContext.inflate(this.mLayoutResId, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(android.R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            defpackage.d.AnonymousClass0.m("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewOnCreateRecyclerView = onCreateRecyclerView(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewOnCreateRecyclerView == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.mList = recyclerViewOnCreateRecyclerView;
        recyclerViewOnCreateRecyclerView.addItemDecoration(this.mDividerDecoration);
        setDivider(drawable);
        if (dimensionPixelSize != -1) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mDividerDecoration.c = z;
        if (this.mList.getParent() == null) {
            viewGroup2.addView(this.mList);
        }
        this.mHandler.post(this.mRequestFocus);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            getListView().setAdapter(null);
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            if (preferenceScreen != null) {
                preferenceScreen.o();
            }
            onUnbindPreferences();
        }
        this.mList = null;
        super.onDestroyView();
    }

    @Override // androidx.preference.e.a
    public void onDisplayPreferenceDialog(Preference preference) {
        String str;
        m ti0Var;
        Bundle bundle;
        boolean zA = getCallbackFragment() instanceof e ? ((e) getCallbackFragment()).a() : false;
        for (Fragment parentFragment = this; !zA && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof e) {
                zA = ((e) parentFragment).a();
            }
        }
        if (!zA && (getContext() instanceof e)) {
            zA = ((e) getContext()).a();
        }
        if (!zA && (getActivity() instanceof e)) {
            zA = ((e) getActivity()).a();
        }
        if (!zA && getParentFragmentManager().D(DIALOG_FRAGMENT_TAG) == null) {
            if (preference instanceof EditTextPreference) {
                str = preference.r;
                ti0Var = new zp();
                bundle = new Bundle(1);
            } else if (preference instanceof ListPreference) {
                str = preference.r;
                ti0Var = new te0();
                bundle = new Bundle(1);
            } else {
                if (!(preference instanceof MultiSelectListPreference)) {
                    throw new IllegalArgumentException(ak.AnonymousClass0.m("Cannot display dialog for an unknown Preference type: ", preference.getClass().getSimpleName(), ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference."));
                }
                str = preference.r;
                ti0Var = new ti0();
                bundle = new Bundle(1);
            }
            bundle.putString("key", str);
            ti0Var.setArguments(bundle);
            ti0Var.setTargetFragment(this, 0);
            q parentFragmentManager = getParentFragmentManager();
            ti0Var.mDismissed = false;
            ti0Var.mShownByMe = true;
            parentFragmentManager.getClass();
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(parentFragmentManager);
            aVar.p = true;
            aVar.d(0, ti0Var, DIALOG_FRAGMENT_TAG, 1);
            aVar.g(false);
        }
    }

    @Override // androidx.preference.e.b
    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        boolean zA = getCallbackFragment() instanceof g ? ((g) getCallbackFragment()).a() : false;
        for (Fragment parentFragment = this; !zA && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof g) {
                zA = ((g) parentFragment).a();
            }
        }
        if (!zA && (getContext() instanceof g)) {
            zA = ((g) getContext()).a();
        }
        if (zA || !(getActivity() instanceof g)) {
            return;
        }
        ((g) getActivity()).a();
    }

    @Override // androidx.preference.e.c
    public boolean onPreferenceTreeClick(Preference preference) {
        if (preference.t == null) {
            return false;
        }
        boolean zA = getCallbackFragment() instanceof f ? ((f) getCallbackFragment()).a() : false;
        for (Fragment parentFragment = this; !zA && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof f) {
                zA = ((f) parentFragment).a();
            }
        }
        if (!zA && (getContext() instanceof f)) {
            zA = ((f) getContext()).a();
        }
        if (!zA && (getActivity() instanceof f)) {
            zA = ((f) getActivity()).a();
        }
        if (zA) {
            return true;
        }
        q parentFragmentManager = getParentFragmentManager();
        if (preference.u == null) {
            preference.u = new Bundle();
        }
        Bundle bundle = preference.u;
        o oVarF = parentFragmentManager.F();
        requireActivity().getClassLoader();
        Fragment fragmentA = oVarF.a(preference.t);
        fragmentA.setArguments(bundle);
        fragmentA.setTargetFragment(this, 0);
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(parentFragmentManager);
        int id = ((View) requireView().getParent()).getId();
        if (id == 0) {
            defpackage.d.AnonymousClass0.m$2("Must use non-zero containerViewId");
            return false;
        }
        aVar.d(id, fragmentA, null, 2);
        if (!aVar.h) {
            defpackage.d.AnonymousClass0.m("This FragmentTransaction is not allowed to be added to the back stack.");
            return false;
        }
        aVar.g = true;
        aVar.i = null;
        aVar.g(false);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.c(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        androidx.preference.e eVar = this.mPreferenceManager;
        eVar.h = this;
        eVar.i = this;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        androidx.preference.e eVar = this.mPreferenceManager;
        eVar.h = null;
        eVar.i = null;
    }

    public void onUnbindPreferences() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        if (bundle != null && (bundle2 = bundle.getBundle(PREFERENCES_TAG)) != null && (preferenceScreen = getPreferenceScreen()) != null) {
            preferenceScreen.b(bundle2);
        }
        if (this.mHavePrefs) {
            bindPreferences();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void scrollToPreference(Preference preference) {
        c cVar = new c(preference, null);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = cVar;
        } else {
            cVar.run();
        }
    }

    public void scrollToPreference(String str) {
        c cVar = new c(null, str);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = cVar;
        } else {
            cVar.run();
        }
    }

    public void setDivider(Drawable drawable) {
        int intrinsicHeight;
        d dVar = this.mDividerDecoration;
        if (drawable != null) {
            dVar.getClass();
            intrinsicHeight = drawable.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
        }
        dVar.b = intrinsicHeight;
        dVar.a = drawable;
        RecyclerView recyclerView = b.this.mList;
        if (recyclerView.mItemDecorations.size() == 0) {
            return;
        }
        RecyclerView.o oVar = recyclerView.mLayout;
        if (oVar != null) {
            oVar.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        recyclerView.markItemDecorInsetsDirty();
        recyclerView.requestLayout();
    }

    public void setDividerHeight(int i) {
        d dVar = this.mDividerDecoration;
        dVar.b = i;
        RecyclerView recyclerView = b.this.mList;
        if (recyclerView.mItemDecorations.size() == 0) {
            return;
        }
        RecyclerView.o oVar = recyclerView.mLayout;
        if (oVar != null) {
            oVar.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        recyclerView.markItemDecorInsetsDirty();
        recyclerView.requestLayout();
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        androidx.preference.e eVar = this.mPreferenceManager;
        PreferenceScreen preferenceScreen2 = eVar.g;
        if (preferenceScreen != preferenceScreen2) {
            if (preferenceScreen2 != null) {
                preferenceScreen2.o();
            }
            eVar.g = preferenceScreen;
            if (preferenceScreen != null) {
                onUnbindPreferences();
                this.mHavePrefs = true;
                if (!this.mInitDone || this.mHandler.hasMessages(1)) {
                    return;
                }
                this.mHandler.obtainMessage(1).sendToTarget();
            }
        }
    }

    public void setPreferencesFromResource(int i, String str) {
        PreferenceScreen preferenceScreen;
        Preference preferenceA;
        androidx.preference.e eVar = this.mPreferenceManager;
        if (eVar == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
        PreferenceScreen preferenceScreenE = eVar.e(requireContext(), i, null);
        if (str != null) {
            preferenceA = preferenceScreenE.A(str);
            if (!(preferenceA instanceof PreferenceScreen)) {
                preferenceScreen = preferenceScreenE;
                preferenceScreen = preferenceA;
                throw new IllegalArgumentException(defpackage.e.n("Preference object with key ", str, " is not a PreferenceScreen"));
            }
        }
        preferenceScreen = preferenceScreenE;
        preferenceScreen = preferenceA;
        preferenceScreen = preferenceScreenE;
        setPreferenceScreen(preferenceScreen);
    }
}
