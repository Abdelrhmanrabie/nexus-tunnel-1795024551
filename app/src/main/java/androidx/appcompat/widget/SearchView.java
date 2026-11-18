package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import defpackage.b2;
import defpackage.m6;
import defpackage.qd1;
import defpackage.ue1;
import defpackage.x4;
import defpackage.zd;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;
import renz.javacodez.v2ray.AppConfig;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SearchView extends androidx.appcompat.widget.b implements zd {
    public static final n U;
    public final CharSequence A;
    public final boolean D;
    public boolean E;
    public final CharSequence H;
    public boolean J;
    public final int K;
    public boolean N;
    public int O;
    public final b R;
    public final c S;
    public final SearchAutoComplete b;
    public final View c;
    public final View d;
    public final View f;
    public final ImageView g;
    public final ImageView i;
    public final ImageView j;
    public final ImageView n;
    public final View o;
    public p p;
    public final Rect q;
    public final Rect r;
    public final int[] s;
    public final int[] t;
    public final ImageView u;
    public final Drawable v;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class SearchAutoComplete extends x4 {
        public int b;
        public SearchView c;
        public boolean d;
        public final a f;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                if (searchAutoComplete.d) {
                    ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                    searchAutoComplete.d = false;
                }
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, R.style.bd);
            this.f = new a();
            this.b = getThreshold();
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.b <= 0 || super.enoughToFilter();
        }

        @Override // defpackage.x4, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.d) {
                a aVar = this.f;
                removeCallbacks(aVar);
                post(aVar);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            int i;
            super.onFinishInflate();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 < 960 || i3 < 720 || configuration.orientation != 2) {
                i = (i2 >= 600 || (i2 >= 640 && i3 >= 480)) ? 192 : 160;
            } else {
                i = 256;
            }
            setMinWidth((int) TypedValue.applyDimension(1, i, displayMetrics));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            SearchView searchView = this.c;
            searchView.o(searchView.E);
            searchView.post(searchView.R);
            if (searchView.b.hasFocus()) {
                searchView.d();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.c.hasFocus() && getVisibility() == 0) {
                this.d = true;
                Context context = getContext();
                n nVar = SearchView.U;
                if (context.getResources().getConfiguration().orientation == 2) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        setInputMethodMode(1);
                        if (enoughToFilter()) {
                            showDropDown();
                            return;
                        }
                        return;
                    }
                    n nVar2 = SearchView.U;
                    nVar2.getClass();
                    n.a();
                    Method method = nVar2.c;
                    if (method != null) {
                        try {
                            method.invoke(this, Boolean.TRUE);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }

        public final void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            a aVar = this.f;
            if (!z) {
                this.d = false;
                removeCallbacks(aVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.d = true;
                    return;
                }
                this.d = false;
                removeCallbacks(aVar);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void setThreshold(int i) {
            super.setThreshold(i);
            this.b = i;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView searchView = SearchView.this;
            TextUtils.isEmpty(searchView.b.getText());
            searchView.i.setVisibility(8);
            searchView.n.setVisibility(8);
            searchView.j();
            searchView.f.setVisibility(8);
            charSequence.toString();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SearchView.this.k();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SearchView.this.getClass();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            SearchView.this.getClass();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int dimensionPixelSize;
            SearchView searchView = SearchView.this;
            View view2 = searchView.o;
            if (view2.getWidth() > 1) {
                Resources resources = searchView.getContext().getResources();
                int paddingLeft = searchView.d.getPaddingLeft();
                Rect rect = new Rect();
                boolean zA = ue1.a(searchView);
                if (searchView.D) {
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.af) + resources.getDimensionPixelSize(R.dimen.ae);
                } else {
                    dimensionPixelSize = 0;
                }
                SearchAutoComplete searchAutoComplete = searchView.b;
                searchAutoComplete.getDropDownBackground().getPadding(rect);
                int i9 = rect.left;
                searchAutoComplete.setDropDownHorizontalOffset(zA ? -i9 : paddingLeft - (i9 + dimensionPixelSize));
                searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SearchView searchView = SearchView.this;
            ImageView imageView = searchView.g;
            SearchAutoComplete searchAutoComplete = searchView.b;
            if (view == imageView) {
                searchView.o(false);
                searchAutoComplete.requestFocus();
                searchAutoComplete.setImeVisibility(true);
                return;
            }
            if (view == searchView.j) {
                if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
                    searchAutoComplete.setText(AppConfig.CUSTOM);
                    searchAutoComplete.requestFocus();
                    searchAutoComplete.setImeVisibility(true);
                    return;
                } else {
                    if (searchView.D) {
                        searchView.clearFocus();
                        searchView.o(true);
                        return;
                    }
                    return;
                }
            }
            if (view != searchView.i) {
                if (view != searchView.n && view == searchAutoComplete) {
                    searchView.d();
                    return;
                }
                return;
            }
            Editable text = searchAutoComplete.getText();
            if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
                return;
            }
            searchAutoComplete.setImeVisibility(false);
            searchAutoComplete.dismissDropDown();
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView.this.getClass();
            return false;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchAutoComplete searchAutoComplete = SearchView.this.b;
            Editable text = searchAutoComplete.getText();
            if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
                return true;
            }
            searchAutoComplete.setImeVisibility(false);
            searchAutoComplete.dismissDropDown();
            return true;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
            SearchView.this.getClass();
            throw null;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            SearchView.this.b.getText();
            throw null;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface k {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface l {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface m {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class n {
        public final Method a;
        public final Method b;
        public final Method c;

        public n() {
            this.a = null;
            this.b = null;
            this.c = null;
            a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                this.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                this.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class o extends defpackage.d {
        public static final Parcelable.Creator<o> CREATOR = new a();
        public boolean b;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public class a implements Parcelable.ClassLoaderCreator<o> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new o(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new o[i];
            }
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public o(Parcelable parcelable) {
            super(parcelable);
        }

        public final String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.b + "}";
        }

        @Override // defpackage.d, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.b));
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class p extends TouchDelegate {
        public final SearchAutoComplete a;
        public final Rect b;
        public final Rect c;
        public final Rect d;
        public final int e;
        public boolean f;

        public p(Rect rect, Rect rect2, SearchAutoComplete searchAutoComplete) {
            super(rect, searchAutoComplete);
            int scaledTouchSlop = ViewConfiguration.get(searchAutoComplete.getContext()).getScaledTouchSlop();
            this.e = scaledTouchSlop;
            Rect rect3 = new Rect();
            this.b = rect3;
            Rect rect4 = new Rect();
            this.d = rect4;
            Rect rect5 = new Rect();
            this.c = rect5;
            rect3.set(rect);
            rect4.set(rect);
            int i = -scaledTouchSlop;
            rect4.inset(i, i);
            rect5.set(rect2);
            this.a = searchAutoComplete;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x003f  */
        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            float width;
            int height;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f;
                    if (z2 && !this.d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else if (action != 3) {
                    z = true;
                    z3 = false;
                } else {
                    z2 = this.f;
                    this.f = false;
                }
                z3 = z2;
                z = true;
            } else if (this.b.contains(x, y)) {
                this.f = true;
                z = true;
            } else {
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            Rect rect = this.c;
            SearchAutoComplete searchAutoComplete = this.a;
            if (!z || rect.contains(x, y)) {
                width = x - rect.left;
                height = y - rect.top;
            } else {
                width = searchAutoComplete.getWidth() / 2;
                height = searchAutoComplete.getHeight() / 2;
            }
            motionEvent.setLocation(width, height);
            return searchAutoComplete.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        U = Build.VERSION.SDK_INT < 29 ? new n() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.zj);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.q = new Rect();
        this.r = new Rect();
        this.s = new int[2];
        this.t = new int[2];
        this.R = new b();
        this.S = new c();
        new WeakHashMap();
        f fVar = new f();
        g gVar = new g();
        h hVar = new h();
        i iVar = new i();
        j jVar = new j();
        a aVar = new a();
        int[] iArr = b2.v;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        m6 m6Var = new m6(context, typedArrayObtainStyledAttributes);
        qd1.k(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i2);
        LayoutInflater.from(context).inflate(typedArrayObtainStyledAttributes.getResourceId(9, R.layout.z), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.attr.wj);
        this.b = searchAutoComplete;
        searchAutoComplete.c = this;
        this.c = findViewById(R.attr.wf);
        View viewFindViewById = findViewById(R.attr.wi);
        this.d = viewFindViewById;
        View viewFindViewById2 = findViewById(R.attr.zw);
        this.f = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.attr.wc);
        this.g = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.attr.wg);
        this.i = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.attr.wd);
        this.j = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.attr.wm);
        this.n = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.attr.wh);
        this.u = imageView5;
        viewFindViewById.setBackground(m6Var.e(10));
        viewFindViewById2.setBackground(m6Var.e(14));
        imageView.setImageDrawable(m6Var.e(13));
        imageView2.setImageDrawable(m6Var.e(7));
        imageView3.setImageDrawable(m6Var.e(4));
        imageView4.setImageDrawable(m6Var.e(16));
        imageView5.setImageDrawable(m6Var.e(13));
        this.v = m6Var.e(12);
        b2.a(getResources().getString(R.string.w), imageView);
        typedArrayObtainStyledAttributes.getResourceId(15, R.layout.y);
        typedArrayObtainStyledAttributes.getResourceId(5, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(aVar);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(gVar);
        searchAutoComplete.setOnFocusChangeListener(new d());
        boolean z = typedArrayObtainStyledAttributes.getBoolean(8, true);
        if (this.D != z) {
            this.D = z;
            o(z);
            l();
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize != -1) {
            this.K = dimensionPixelSize;
            requestLayout();
        }
        this.A = typedArrayObtainStyledAttributes.getText(6);
        this.H = typedArrayObtainStyledAttributes.getText(11);
        int i3 = typedArrayObtainStyledAttributes.getInt(3, -1);
        if (i3 != -1) {
            searchAutoComplete.setImeOptions(i3);
        }
        int i4 = typedArrayObtainStyledAttributes.getInt(2, -1);
        if (i4 != -1) {
            searchAutoComplete.setInputType(i4);
        }
        setFocusable(typedArrayObtainStyledAttributes.getBoolean(0, true));
        m6Var.n();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        new Intent("android.speech.action.RECOGNIZE_SPEECH").addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.o = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        o(this.D);
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.J = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.b;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.J = false;
    }

    public final void d() {
        int i2 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.b;
        if (i2 >= 29) {
            searchAutoComplete.refreshAutoCompleteResults();
            return;
        }
        n nVar = U;
        nVar.getClass();
        n.a();
        Method method = nVar.a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        n.a();
        Method method2 = nVar.b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void j() {
        boolean zIsEmpty = TextUtils.isEmpty(this.b.getText());
        int i2 = (!zIsEmpty || (this.D && !this.N)) ? 0 : 8;
        ImageView imageView = this.j;
        imageView.setVisibility(i2);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void k() {
        int[] iArr = this.b.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.d.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
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
    public final void l() {
        Drawable drawable;
        CharSequence charSequence;
        CharSequence charSequence2 = this.H;
        CharSequence charSequence3 = charSequence2;
        if (charSequence2 == null) {
            charSequence = this.A;
        }
        if (charSequence3 == null) {
            charSequence3 = charSequence;
            charSequence3 = AppConfig.CUSTOM;
        }
        charSequence3 = charSequence;
        boolean z = this.D;
        SearchAutoComplete searchAutoComplete = this.b;
        CharSequence charSequence4 = charSequence3;
        if (z && (drawable = this.v) != null) {
            charSequence4 = charSequence3;
            int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(charSequence3);
            charSequence4 = spannableStringBuilder;
        }
        charSequence4 = charSequence3;
        searchAutoComplete.setHint(charSequence4);
    }

    public final void o(boolean z) {
        this.E = z;
        int i2 = z ? 0 : 8;
        TextUtils.isEmpty(this.b.getText());
        this.g.setVisibility(i2);
        this.i.setVisibility(8);
        this.c.setVisibility(z ? 8 : 0);
        ImageView imageView = this.u;
        imageView.setVisibility((imageView.getDrawable() == null || this.D) ? 8 : 0);
        j();
        this.n.setVisibility(8);
        this.f.setVisibility(8);
    }

    @Override // defpackage.zd
    public final void onActionViewCollapsed() {
        SearchAutoComplete searchAutoComplete = this.b;
        searchAutoComplete.setText(AppConfig.CUSTOM);
        searchAutoComplete.setSelection(searchAutoComplete.length());
        clearFocus();
        o(true);
        searchAutoComplete.setImeOptions(this.O);
        this.N = false;
    }

    @Override // defpackage.zd
    public final void onActionViewExpanded() {
        if (this.N) {
            return;
        }
        this.N = true;
        SearchAutoComplete searchAutoComplete = this.b;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.O = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText(AppConfig.CUSTOM);
        o(false);
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.R);
        post(this.S);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.b;
            int[] iArr = this.s;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.t;
            getLocationInWindow(iArr2);
            int i6 = iArr[1] - iArr2[1];
            int i7 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i7;
            int height = searchAutoComplete.getHeight() + i6;
            Rect rect = this.q;
            rect.set(i7, i6, width, height);
            int i8 = rect.left;
            int i9 = rect.right;
            int i10 = i5 - i3;
            Rect rect2 = this.r;
            rect2.set(i8, 0, i9, i10);
            p pVar = this.p;
            if (pVar == null) {
                p pVar2 = new p(rect2, rect, searchAutoComplete);
                this.p = pVar2;
                setTouchDelegate(pVar2);
            } else {
                pVar.b.set(rect2);
                Rect rect3 = pVar.d;
                rect3.set(rect2);
                int i11 = -pVar.e;
                rect3.inset(i11, i11);
                pVar.c.set(rect);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0067  */
    @Override // androidx.appcompat.widget.b, android.view.View
    public final void onMeasure(int i2, int i3) {
        int dimensionPixelSize;
        int mode;
        int size;
        if (this.E) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                size2 = this.K;
                if (size2 <= 0) {
                    size2 = getContext().getResources().getDimensionPixelSize(R.dimen.as);
                }
            } else if (mode2 == 1073741824 && (dimensionPixelSize = this.K) > 0) {
            }
            mode = View.MeasureSpec.getMode(i3);
            size = View.MeasureSpec.getSize(i3);
            if (mode != Integer.MIN_VALUE) {
                size = Math.min(getContext().getResources().getDimensionPixelSize(R.dimen.ar), size);
            } else if (mode == 0) {
                size = getContext().getResources().getDimensionPixelSize(R.dimen.ar);
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
        }
        dimensionPixelSize = this.K;
        if (dimensionPixelSize <= 0) {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.as);
        }
        size2 = Math.min(dimensionPixelSize, size2);
        mode = View.MeasureSpec.getMode(i3);
        size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            size = Math.min(getContext().getResources().getDimensionPixelSize(R.dimen.ar), size);
        } else if (mode == 0) {
            size = getContext().getResources().getDimensionPixelSize(R.dimen.ar);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.mSuperState);
        o(oVar.b);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.b = this.E;
        return oVar;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.R);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i2, Rect rect) {
        if (this.J || !isFocusable()) {
            return false;
        }
        if (this.E) {
            return super.requestFocus(i2, rect);
        }
        boolean zRequestFocus = this.b.requestFocus(i2, rect);
        if (zRequestFocus) {
            o(false);
        }
        return zRequestFocus;
    }
}
