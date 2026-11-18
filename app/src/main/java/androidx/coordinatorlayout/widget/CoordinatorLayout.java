package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import defpackage.ak;
import defpackage.b2;
import defpackage.fg1;
import defpackage.fk0;
import defpackage.gk0;
import defpackage.hk0;
import defpackage.ip0;
import defpackage.lm0;
import defpackage.o01;
import defpackage.oo;
import defpackage.qd1;
import defpackage.yd1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements fk0, gk0 {
    public static final Class[] CONSTRUCTOR_PARAMS;
    public static final i TOP_SORTED_CHILDREN_COMPARATOR;
    public static final String WIDGET_PACKAGE_NAME;
    public static final ThreadLocal sConstructors;
    public static final ip0 sRectPool;
    public a mApplyWindowInsetsListener;
    public final int[] mBehaviorConsumed;
    public View mBehaviorTouchView;
    public final oo mChildDag;
    public final ArrayList mDependencySortedChildren;
    public boolean mDisallowInterceptReset;
    public boolean mDrawStatusBarBackground;
    public boolean mIsAttachedToWindow;
    public final int[] mKeylines;
    public fg1 mLastInsets;
    public boolean mNeedsPreDrawListener;
    public final hk0 mNestedScrollingParentHelper;
    public View mNestedScrollingTarget;
    public final int[] mNestedScrollingV2ConsumedCompat;
    public ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    public g mOnPreDrawListener;
    public final Drawable mStatusBarBackground;
    public final ArrayList mTempDependenciesList;
    public final ArrayList mTempList1;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements lm0 {
        public a() {
        }

        @Override // defpackage.lm0
        public final fg1 onApplyWindowInsets(View view, fg1 fg1Var) {
            fg1.k kVar = fg1Var.a;
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            if (!Objects.equals(coordinatorLayout.mLastInsets, fg1Var)) {
                coordinatorLayout.mLastInsets = fg1Var;
                boolean z = fg1Var.d() > 0;
                coordinatorLayout.mDrawStatusBarBackground = z;
                coordinatorLayout.setWillNotDraw(!z && coordinatorLayout.getBackground() == null);
                if (!kVar.m()) {
                    int childCount = coordinatorLayout.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = coordinatorLayout.getChildAt(i);
                        WeakHashMap weakHashMap = qd1.a;
                        if (childAt.getFitsSystemWindows() && ((f) childAt.getLayoutParams()).a != null && kVar.m()) {
                            break;
                        }
                    }
                }
                coordinatorLayout.requestLayout();
            }
            return fg1Var;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface b {
        c getBehavior();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static abstract class c<V extends View> {
        public c() {
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public boolean getInsetDodgeRect(View view, Rect rect) {
            return false;
        }

        public boolean layoutDependsOn(View view, View view2) {
            return false;
        }

        public void onAttachedToLayoutParams(f fVar) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            return false;
        }

        public boolean onNestedPreFling(View view) {
            return false;
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
            iArr[0] = iArr[0] + i2;
            iArr[1] = iArr[1] + i3;
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(View view, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            return false;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
        Class value();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            coordinatorLayout.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = coordinatorLayout.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class f extends ViewGroup.MarginLayoutParams {
        public c a;
        public boolean b;
        public final int c;
        public int d;
        public final int e;
        public final int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public View k;
        public View l;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q;

        public f() {
            super(-2, -2);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public f(Context context, AttributeSet attributeSet) {
            c cVar;
            super(context, attributeSet);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, defpackage.e.f32d);
            this.c = typedArrayObtainStyledAttributes.getInteger(0, 0);
            this.f = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            this.d = typedArrayObtainStyledAttributes.getInteger(2, 0);
            this.e = typedArrayObtainStyledAttributes.getInteger(6, -1);
            this.g = typedArrayObtainStyledAttributes.getInt(5, 0);
            this.h = typedArrayObtainStyledAttributes.getInt(4, 0);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(3);
            this.b = zHasValue;
            if (zHasValue) {
                String string = typedArrayObtainStyledAttributes.getString(3);
                Class[] clsArr = CoordinatorLayout.CONSTRUCTOR_PARAMS;
                if (TextUtils.isEmpty(string)) {
                    cVar = null;
                } else {
                    if (string.startsWith(".")) {
                        string = context.getPackageName() + string;
                    } else if (string.indexOf(46) < 0) {
                        String str = CoordinatorLayout.WIDGET_PACKAGE_NAME;
                        if (!TextUtils.isEmpty(str)) {
                            string = str + '.' + string;
                        }
                    }
                    try {
                        ThreadLocal threadLocal = CoordinatorLayout.sConstructors;
                        Map map = (Map) threadLocal.get();
                        if (map == null) {
                            map = new HashMap();
                            threadLocal.set(map);
                        }
                        Constructor<?> constructor = (Constructor) map.get(string);
                        if (constructor == null) {
                            constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.CONSTRUCTOR_PARAMS);
                            constructor.setAccessible(true);
                            map.put(string, constructor);
                        }
                        cVar = (c) constructor.newInstance(context, attributeSet);
                    } catch (Exception e) {
                        throw new RuntimeException(ak.m("Could not inflate Behavior subclass ", string), e);
                    }
                }
                this.a = cVar;
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar2 = this.a;
            if (cVar2 != null) {
                cVar2.onAttachedToLayoutParams(this);
            }
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public final boolean a(int i) {
            if (i == 0) {
                return this.n;
            }
            if (i != 1) {
                return false;
            }
            return this.o;
        }

        public final void b(c cVar) {
            c cVar2 = this.a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.onDetachedFromLayoutParams();
                }
                this.a = cVar;
                this.b = true;
                if (cVar != null) {
                    cVar.onAttachedToLayoutParams(this);
                }
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class h extends defpackage.d {
        public static final Parcelable.Creator<h> CREATOR = new a();
        public SparseArray b;

        /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new h[i];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i = parcel.readInt();
            int[] iArr = new int[i];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.b = new SparseArray(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.b.append(iArr[i2], parcelableArray[i2]);
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // defpackage.d, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray sparseArray = this.b;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.b.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.b.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class i implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View view, View view2) {
            WeakHashMap weakHashMap = qd1.a;
            float z = view.getZ();
            float z2 = view2.getZ();
            if (z > z2) {
                return -1;
            }
            return z < z2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = r0 != null ? r0.getName() : null;
        TOP_SORTED_CHILDREN_COMPARATOR = new i();
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal();
        sRectPool = new ip0(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.hs);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        CoordinatorLayout coordinatorLayout;
        Context context2;
        int i3;
        int i4;
        super(context, attributeSet, i2);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new oo(0);
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new hk0();
        int[] iArr = defpackage.e.f29c;
        TypedArray typedArrayObtainStyledAttributes = i2 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, R.plurals.a3q) : context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i2 == 0) {
                i4 = R.plurals.a3q;
                i3 = 0;
            } else {
                i3 = i2;
                i4 = 0;
            }
            coordinatorLayout = this;
            context2 = context;
            coordinatorLayout.saveAttributeDataForStyleable(context2, iArr, attributeSet, typedArrayObtainStyledAttributes, i3, i4);
        } else {
            coordinatorLayout = this;
            context2 = context;
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            coordinatorLayout.mKeylines = intArray;
            float f2 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i5 = 0; i5 < length; i5++) {
                int[] iArr2 = coordinatorLayout.mKeylines;
                iArr2[i5] = (int) (iArr2[i5] * f2);
            }
        }
        coordinatorLayout.mStatusBarBackground = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new e());
        WeakHashMap weakHashMap = qd1.a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect acquireTempRect() {
        Rect rect = (Rect) sRectPool.b();
        return rect == null ? new Rect() : rect;
    }

    public static void getDesiredAnchoredChildRectWithoutConstraints(int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int iWidth;
        int iHeight;
        int i5 = fVar.c;
        if (i5 == 0) {
            i5 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i5, i2);
        int i6 = fVar.d;
        if ((i6 & 7) == 0) {
            i6 |= 8388611;
        }
        if ((i6 & 112) == 0) {
            i6 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i6, i2);
        int i7 = absoluteGravity & 7;
        int i8 = absoluteGravity & 112;
        int i9 = absoluteGravity2 & 7;
        int i10 = absoluteGravity2 & 112;
        if (i9 != 1) {
            iWidth = i9 != 5 ? rect.left : rect.right;
        } else {
            iWidth = rect.left + (rect.width() / 2);
        }
        if (i10 != 16) {
            iHeight = i10 != 80 ? rect.top : rect.bottom;
        } else {
            iHeight = rect.top + (rect.height() / 2);
        }
        if (i7 == 1) {
            iWidth -= i3 / 2;
        } else if (i7 != 5) {
            iWidth -= i3;
        }
        if (i8 == 16) {
            iHeight -= i4 / 2;
        } else if (i8 != 80) {
            iHeight -= i4;
        }
        rect2.set(iWidth, iHeight, i3 + iWidth, i4 + iHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f getResolvedLayoutParams(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.b) {
            if (view instanceof b) {
                fVar.b(((b) view).getBehavior());
            } else {
                d dVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    dVar = (d) superclass.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.b((c) dVar.value().getDeclaredConstructor(null).newInstance(null));
                    } catch (Exception unused) {
                        dVar.value().getClass();
                    }
                }
            }
            fVar.b = true;
        }
        return fVar;
    }

    public static void setInsetOffsetX(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.i;
        if (i3 != i2) {
            WeakHashMap weakHashMap = qd1.a;
            view.offsetLeftAndRight(i2 - i3);
            fVar.i = i2;
        }
    }

    public static void setInsetOffsetY(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.j;
        if (i3 != i2) {
            WeakHashMap weakHashMap = qd1.a;
            view.offsetTopAndBottom(i2 - i3);
            fVar.j = i2;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public final void constrainChildRect(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i2 + iMax, i3 + iMax2);
    }

    public final void dispatchDependentViewsChanged(View view) {
        List list = (List) ((o01) this.mChildDag.b).getOrDefault(view, null);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            View view2 = (View) list.get(i2);
            c cVar = ((f) view2.getLayoutParams()).a;
            if (cVar != null) {
                cVar.onDependentViewChanged(this, view2, view);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        c cVar = ((f) view.getLayoutParams()).a;
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public final void getChildRect(View view, Rect rect, boolean z) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList getDependencies(View view) {
        o01 o01Var = (o01) this.mChildDag.b;
        int i2 = o01Var.d;
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayList arrayList2 = (ArrayList) o01Var.k(i3);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(o01Var.i(i3));
            }
        }
        ArrayList arrayList3 = this.mTempDependenciesList;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void getDescendantRect(View view, Rect rect) {
        ThreadLocal threadLocal = yd1.a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = yd1.a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        yd1.a(this, view, matrix);
        ThreadLocal threadLocal3 = yd1.b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    @Override // android.view.ViewGroup
    public final int getNestedScrollAxes() {
        hk0 hk0Var = this.mNestedScrollingParentHelper;
        return hk0Var.b | hk0Var.a;
    }

    @Override // android.view.View
    public final int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public final int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final boolean isPointInChildBounds(View view, int i2, int i3) {
        ip0 ip0Var = sRectPool;
        Rect rectAcquireTempRect = acquireTempRect();
        getDescendantRect(view, rectAcquireTempRect);
        try {
            return rectAcquireTempRect.contains(i2, i3);
        } finally {
            rectAcquireTempRect.setEmpty();
            ip0Var.a(rectAcquireTempRect);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null) {
            WeakHashMap weakHashMap = qd1.a;
            if (getFitsSystemWindows()) {
                requestApplyInsets();
            }
        }
        this.mIsAttachedToWindow = true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00de  */
    public final void onChildViewsChanged(int i2) {
        int i3;
        Rect rect;
        int i4;
        ArrayList arrayList;
        boolean zOnDependentViewChanged;
        boolean z;
        boolean z2;
        int width;
        int i5;
        int i6;
        int i7;
        int height;
        int i8;
        int i9;
        int i10;
        f fVar;
        int i11;
        View view;
        c cVar;
        WeakHashMap weakHashMap = qd1.a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList2 = this.mDependencySortedChildren;
        int size = arrayList2.size();
        Rect rectAcquireTempRect = acquireTempRect();
        Rect rectAcquireTempRect2 = acquireTempRect();
        Rect rectAcquireTempRect3 = acquireTempRect();
        int i12 = 0;
        while (true) {
            ip0 ip0Var = sRectPool;
            if (i12 >= size) {
                Rect rect2 = rectAcquireTempRect3;
                rectAcquireTempRect.setEmpty();
                ip0Var.a(rectAcquireTempRect);
                rectAcquireTempRect2.setEmpty();
                ip0Var.a(rectAcquireTempRect2);
                rect2.setEmpty();
                ip0Var.a(rect2);
                return;
            }
            View view2 = (View) arrayList2.get(i12);
            f fVar2 = (f) view2.getLayoutParams();
            if (i2 != 0 || view2.getVisibility() != 8) {
                int i13 = 0;
                while (i13 < i12) {
                    if (fVar2.l == ((View) arrayList2.get(i13))) {
                        f fVar3 = (f) view2.getLayoutParams();
                        if (fVar3.k != null) {
                            Rect rectAcquireTempRect4 = acquireTempRect();
                            Rect rectAcquireTempRect5 = acquireTempRect();
                            f fVar4 = fVar2;
                            Rect rectAcquireTempRect6 = acquireTempRect();
                            getDescendantRect(fVar3.k, rectAcquireTempRect4);
                            getChildRect(view2, rectAcquireTempRect5, false);
                            int measuredWidth = view2.getMeasuredWidth();
                            View view3 = view2;
                            int measuredHeight = view3.getMeasuredHeight();
                            fVar = fVar4;
                            i11 = i13;
                            layoutDirection = layoutDirection;
                            view = view3;
                            getDesiredAnchoredChildRectWithoutConstraints(layoutDirection, rectAcquireTempRect4, rectAcquireTempRect6, fVar3, measuredWidth, measuredHeight);
                            boolean z3 = (rectAcquireTempRect6.left == rectAcquireTempRect5.left && rectAcquireTempRect6.top == rectAcquireTempRect5.top) ? false : true;
                            constrainChildRect(fVar3, rectAcquireTempRect6, measuredWidth, measuredHeight);
                            int i14 = rectAcquireTempRect6.left - rectAcquireTempRect5.left;
                            int i15 = rectAcquireTempRect6.top - rectAcquireTempRect5.top;
                            if (i14 != 0) {
                                WeakHashMap weakHashMap2 = qd1.a;
                                view.offsetLeftAndRight(i14);
                            }
                            if (i15 != 0) {
                                WeakHashMap weakHashMap3 = qd1.a;
                                view.offsetTopAndBottom(i15);
                            }
                            if (z3 && (cVar = fVar3.a) != null) {
                                cVar.onDependentViewChanged(this, view, fVar3.k);
                            }
                            rectAcquireTempRect4.setEmpty();
                            ip0Var.a(rectAcquireTempRect4);
                            rectAcquireTempRect5.setEmpty();
                            ip0Var.a(rectAcquireTempRect5);
                            rectAcquireTempRect6.setEmpty();
                            ip0Var.a(rectAcquireTempRect6);
                        } else {
                            fVar = fVar2;
                            i11 = i13;
                            view = view2;
                        }
                    } else {
                        fVar = fVar2;
                        i11 = i13;
                        view = view2;
                    }
                    i13 = i11 + 1;
                    fVar2 = fVar;
                    view2 = view;
                    arrayList2 = arrayList2;
                    size = size;
                    i12 = i12;
                    rectAcquireTempRect3 = rectAcquireTempRect3;
                }
                ArrayList arrayList3 = arrayList2;
                f fVar5 = fVar2;
                int i16 = size;
                Rect rect3 = rectAcquireTempRect3;
                i3 = i12;
                View view4 = view2;
                getChildRect(view4, rectAcquireTempRect2, true);
                if (fVar5.g != 0 && !rectAcquireTempRect2.isEmpty()) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(fVar5.g, layoutDirection);
                    int i17 = absoluteGravity & 112;
                    if (i17 == 48) {
                        rectAcquireTempRect.top = Math.max(rectAcquireTempRect.top, rectAcquireTempRect2.bottom);
                    } else if (i17 == 80) {
                        rectAcquireTempRect.bottom = Math.max(rectAcquireTempRect.bottom, getHeight() - rectAcquireTempRect2.top);
                    }
                    int i18 = absoluteGravity & 7;
                    if (i18 == 3) {
                        rectAcquireTempRect.left = Math.max(rectAcquireTempRect.left, rectAcquireTempRect2.right);
                    } else if (i18 == 5) {
                        rectAcquireTempRect.right = Math.max(rectAcquireTempRect.right, getWidth() - rectAcquireTempRect2.left);
                    }
                }
                if (fVar5.h != 0 && view4.getVisibility() == 0) {
                    WeakHashMap weakHashMap4 = qd1.a;
                    if (view4.isLaidOut() && view4.getWidth() > 0 && view4.getHeight() > 0) {
                        f fVar6 = (f) view4.getLayoutParams();
                        c cVar2 = fVar6.a;
                        Rect rectAcquireTempRect7 = acquireTempRect();
                        Rect rectAcquireTempRect8 = acquireTempRect();
                        rectAcquireTempRect8.set(view4.getLeft(), view4.getTop(), view4.getRight(), view4.getBottom());
                        if (cVar2 == null || !cVar2.getInsetDodgeRect(view4, rectAcquireTempRect7)) {
                            rectAcquireTempRect7.set(rectAcquireTempRect8);
                        } else if (!rectAcquireTempRect8.contains(rectAcquireTempRect7)) {
                            throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectAcquireTempRect7.toShortString() + " | Bounds:" + rectAcquireTempRect8.toShortString());
                        }
                        rectAcquireTempRect8.setEmpty();
                        ip0Var.a(rectAcquireTempRect8);
                        if (!rectAcquireTempRect7.isEmpty()) {
                            int absoluteGravity2 = Gravity.getAbsoluteGravity(fVar6.h, layoutDirection);
                            if ((absoluteGravity2 & 48) != 48 || (i9 = (rectAcquireTempRect7.top - ((ViewGroup.MarginLayoutParams) fVar6).topMargin) - fVar6.j) >= (i10 = rectAcquireTempRect.top)) {
                                z = false;
                            } else {
                                setInsetOffsetY(view4, i10 - i9);
                                z = true;
                            }
                            if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - rectAcquireTempRect7.bottom) - ((ViewGroup.MarginLayoutParams) fVar6).bottomMargin) + fVar6.j) < (i8 = rectAcquireTempRect.bottom)) {
                                setInsetOffsetY(view4, height - i8);
                                z = true;
                            }
                            if (!z) {
                                setInsetOffsetY(view4, 0);
                            }
                            if ((absoluteGravity2 & 3) != 3 || (i6 = (rectAcquireTempRect7.left - ((ViewGroup.MarginLayoutParams) fVar6).leftMargin) - fVar6.i) >= (i7 = rectAcquireTempRect.left)) {
                                z2 = false;
                            } else {
                                setInsetOffsetX(view4, i7 - i6);
                                z2 = true;
                            }
                            if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - rectAcquireTempRect7.right) - ((ViewGroup.MarginLayoutParams) fVar6).rightMargin) + fVar6.i) < (i5 = rectAcquireTempRect.right)) {
                                setInsetOffsetX(view4, width - i5);
                                z2 = true;
                            }
                            if (!z2) {
                                setInsetOffsetX(view4, 0);
                            }
                        }
                        rectAcquireTempRect7.setEmpty();
                        ip0Var.a(rectAcquireTempRect7);
                    }
                }
                if (i2 != 2) {
                    rect = rect3;
                    rect.set(((f) view4.getLayoutParams()).q);
                    if (rect.equals(rectAcquireTempRect2)) {
                        arrayList = arrayList3;
                        i4 = i16;
                    } else {
                        ((f) view4.getLayoutParams()).q.set(rectAcquireTempRect2);
                    }
                } else {
                    rect = rect3;
                }
                int i19 = i3 + 1;
                i4 = i16;
                while (true) {
                    arrayList = arrayList3;
                    if (i19 >= i4) {
                        break;
                    }
                    View view5 = (View) arrayList.get(i19);
                    f fVar7 = (f) view5.getLayoutParams();
                    c cVar3 = fVar7.a;
                    if (cVar3 != null && cVar3.layoutDependsOn(view5, view4)) {
                        if (i2 == 0 && fVar7.p) {
                            fVar7.p = false;
                        } else {
                            if (i2 != 2) {
                                zOnDependentViewChanged = cVar3.onDependentViewChanged(this, view5, view4);
                            } else {
                                cVar3.onDependentViewRemoved(this, view4);
                                zOnDependentViewChanged = true;
                            }
                            if (i2 == 1) {
                                fVar7.p = zOnDependentViewChanged;
                            }
                        }
                    }
                    i19++;
                    arrayList3 = arrayList;
                }
            } else {
                arrayList = arrayList2;
                i4 = size;
                rect = rectAcquireTempRect3;
                i3 = i12;
            }
            i12 = i3 + 1;
            rectAcquireTempRect3 = rect;
            size = i4;
            arrayList2 = arrayList;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view, 0);
        }
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        if (!this.mDrawStatusBarBackground || (drawable = this.mStatusBarBackground) == null) {
            return;
        }
        fg1 fg1Var = this.mLastInsets;
        int iD = fg1Var != null ? fg1Var.d() : 0;
        if (iD > 0) {
            drawable.setBounds(0, 0, getWidth(), iD);
            drawable.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean zPerformIntercept = performIntercept(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zPerformIntercept;
        }
        resetTouchBehaviors(true);
        return zPerformIntercept;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        c cVar;
        WeakHashMap weakHashMap = qd1.a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.mDependencySortedChildren;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = (View) arrayList.get(i6);
            if (view.getVisibility() != 8 && ((cVar = ((f) view.getLayoutParams()).a) == null || !cVar.onLayoutChild(this, view, layoutDirection))) {
                onLayoutChild(view, layoutDirection);
            }
        }
    }

    public final void onLayoutChild(View view, int i2) {
        int i3;
        f fVar = (f) view.getLayoutParams();
        View view2 = fVar.k;
        if (view2 == null && fVar.f != -1) {
            defpackage.d.AnonymousClass0.m("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
            return;
        }
        ip0 ip0Var = sRectPool;
        if (view2 != null) {
            Rect rectAcquireTempRect = acquireTempRect();
            Rect rectAcquireTempRect2 = acquireTempRect();
            try {
                getDescendantRect(view2, rectAcquireTempRect);
                f fVar2 = (f) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                getDesiredAnchoredChildRectWithoutConstraints(i2, rectAcquireTempRect, rectAcquireTempRect2, fVar2, measuredWidth, measuredHeight);
                constrainChildRect(fVar2, rectAcquireTempRect2, measuredWidth, measuredHeight);
                view.layout(rectAcquireTempRect2.left, rectAcquireTempRect2.top, rectAcquireTempRect2.right, rectAcquireTempRect2.bottom);
                return;
            } finally {
                rectAcquireTempRect.setEmpty();
                ip0Var.a(rectAcquireTempRect);
                rectAcquireTempRect2.setEmpty();
                ip0Var.a(rectAcquireTempRect2);
            }
        }
        int i4 = fVar.e;
        if (i4 < 0) {
            f fVar3 = (f) view.getLayoutParams();
            Rect rectAcquireTempRect3 = acquireTempRect();
            rectAcquireTempRect3.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
            if (this.mLastInsets != null) {
                WeakHashMap weakHashMap = qd1.a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectAcquireTempRect3.left = this.mLastInsets.b() + rectAcquireTempRect3.left;
                    rectAcquireTempRect3.top = this.mLastInsets.d() + rectAcquireTempRect3.top;
                    rectAcquireTempRect3.right -= this.mLastInsets.c();
                    rectAcquireTempRect3.bottom -= this.mLastInsets.a();
                }
            }
            Rect rectAcquireTempRect4 = acquireTempRect();
            int i5 = fVar3.c;
            if ((i5 & 7) == 0) {
                i5 |= 8388611;
            }
            if ((i5 & 112) == 0) {
                i5 |= 48;
            }
            Gravity.apply(i5, view.getMeasuredWidth(), view.getMeasuredHeight(), rectAcquireTempRect3, rectAcquireTempRect4, i2);
            view.layout(rectAcquireTempRect4.left, rectAcquireTempRect4.top, rectAcquireTempRect4.right, rectAcquireTempRect4.bottom);
            rectAcquireTempRect3.setEmpty();
            ip0Var.a(rectAcquireTempRect3);
            rectAcquireTempRect4.setEmpty();
            ip0Var.a(rectAcquireTempRect4);
            return;
        }
        f fVar4 = (f) view.getLayoutParams();
        int i6 = fVar4.c;
        if (i6 == 0) {
            i6 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i6, i2);
        int i7 = absoluteGravity & 7;
        int i8 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i2 == 1) {
            i4 = width - i4;
        }
        int[] iArr = this.mKeylines;
        int i9 = 0;
        if (iArr != null && i4 >= 0 && i4 < iArr.length) {
            i3 = iArr[i4];
        } else {
            toString();
            i3 = 0;
        }
        int i10 = i3 - measuredWidth2;
        if (i7 == 1) {
            i10 += measuredWidth2 / 2;
        } else if (i7 == 5) {
            i10 += measuredWidth2;
        }
        if (i8 == 16) {
            i9 = measuredHeight2 / 2;
        } else if (i8 == 80) {
            i9 = measuredHeight2;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin, Math.min(i10, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin, Math.min(i9, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    /* JADX WARN: Code duplicated, block: B:193:0x007b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0081  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:37:0x0085
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // android.view.View
    public final void onMeasure(int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 884
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public final void onMeasureChild(int i2, int i3, int i4, View view) {
        measureChildWithMargins(view, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                ((f) childAt.getLayoutParams()).a(0);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f3) {
        c cVar;
        int childCount = getChildCount();
        boolean zOnNestedPreFling = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (cVar = fVar.a) != null) {
                    zOnNestedPreFling |= cVar.onNestedPreFling(view);
                }
            }
        }
        return zOnNestedPreFling;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        onNestedPreScroll(view, i2, i3, iArr, 0);
    }

    @Override // defpackage.fk0
    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        c cVar;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i4) && (cVar = fVar.a) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.onNestedPreScroll(this, childAt, view, i2, i3, iArr2, i4);
                    iMax = i2 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i3 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i2, i3, i4, i5, 0);
    }

    @Override // defpackage.fk0
    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        onNestedScroll(view, i2, i3, i4, i5, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // defpackage.gk0
    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        c cVar;
        int childCount = getChildCount();
        int iMax = 0;
        int iMax2 = 0;
        boolean z = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i6) && (cVar = fVar.a) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.onNestedScroll(this, childAt, i3, i4, i5, iArr2);
                    iMax = i4 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i5 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        onNestedScrollAccepted(view, view2, i2, 0);
    }

    @Override // defpackage.fk0
    public final void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        hk0 hk0Var = this.mNestedScrollingParentHelper;
        if (i3 == 1) {
            hk0Var.b = i2;
        } else {
            hk0Var.a = i2;
        }
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            ((f) getChildAt(i4).getLayoutParams()).getClass();
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.mSuperState);
        SparseArray sparseArray = hVar.b;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVar = getResolvedLayoutParams(childAt).a;
            if (id != -1 && cVar != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                cVar.onRestoreInstanceState(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVar = ((f) childAt.getLayoutParams()).a;
            if (id != -1 && cVar != null && (parcelableOnSaveInstanceState = cVar.onSaveInstanceState(childAt)) != null) {
                sparseArray.append(id, parcelableOnSaveInstanceState);
            }
        }
        hVar.b = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        return onStartNestedScroll(view, view2, i2, 0);
    }

    @Override // defpackage.fk0
    public final boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVar = fVar.a;
                if (cVar != null) {
                    boolean zOnStartNestedScroll = cVar.onStartNestedScroll(this, childAt, view, view2, i2, i3);
                    z |= zOnStartNestedScroll;
                    if (i3 == 0) {
                        fVar.n = zOnStartNestedScroll;
                    } else if (i3 == 1) {
                        fVar.o = zOnStartNestedScroll;
                    }
                } else if (i3 == 0) {
                    fVar.n = false;
                } else if (i3 == 1) {
                    fVar.o = false;
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // defpackage.fk0
    public final void onStopNestedScroll(View view, int i2) {
        hk0 hk0Var = this.mNestedScrollingParentHelper;
        if (i2 == 1) {
            hk0Var.b = 0;
        } else {
            hk0Var.a = 0;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i2)) {
                c cVar = fVar.a;
                if (cVar != null) {
                    cVar.onStopNestedScroll(this, childAt, view, i2);
                }
                if (i2 == 0) {
                    fVar.n = false;
                } else if (i2 == 1) {
                    fVar.o = false;
                }
                fVar.p = false;
            }
        }
        this.mNestedScrollingTarget = null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029 A[PHI: r3
      0x0029: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:9:0x0020, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    /* JADX WARN: Code duplicated, block: B:15:0x0035 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:18:0x004a  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zPerformIntercept;
        boolean zOnTouchEvent;
        MotionEvent motionEventObtain;
        int actionMasked = motionEvent.getActionMasked();
        if (this.mBehaviorTouchView == null) {
            zPerformIntercept = performIntercept(motionEvent, 1);
            if (!zPerformIntercept) {
                zOnTouchEvent = false;
            }
            motionEventObtain = null;
            if (this.mBehaviorTouchView == null) {
                zOnTouchEvent |= super.onTouchEvent(motionEvent);
            } else if (zPerformIntercept) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEventObtain);
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
            if (actionMasked == 1 && actionMasked != 3) {
                return zOnTouchEvent;
            }
            resetTouchBehaviors(false);
            return zOnTouchEvent;
        }
        zPerformIntercept = false;
        c cVar = ((f) this.mBehaviorTouchView.getLayoutParams()).a;
        if (cVar != null) {
            zOnTouchEvent = cVar.onTouchEvent(this, this.mBehaviorTouchView, motionEvent);
        } else {
            zOnTouchEvent = false;
        }
        motionEventObtain = null;
        if (this.mBehaviorTouchView == null) {
            zOnTouchEvent |= super.onTouchEvent(motionEvent);
        } else if (zPerformIntercept) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            motionEventObtain = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEventObtain);
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        if (actionMasked == 1) {
        }
        resetTouchBehaviors(false);
        return zOnTouchEvent;
    }

    public final boolean performIntercept(MotionEvent motionEvent, int i2) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.mTempList1;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i3) : i3));
        }
        i iVar = TOP_SORTED_CHILDREN_COMPARATOR;
        if (iVar != null) {
            Collections.sort(arrayList, iVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zOnInterceptTouchEvent = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) arrayList.get(i4);
            c cVar = ((f) view.getLayoutParams()).a;
            if (zOnInterceptTouchEvent && actionMasked != 0) {
                if (cVar != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i2 == 0) {
                        cVar.onInterceptTouchEvent(this, view, motionEventObtain);
                    } else if (i2 == 1) {
                        cVar.onTouchEvent(this, view, motionEventObtain);
                    }
                }
            } else if (!zOnInterceptTouchEvent && cVar != null) {
                if (i2 == 0) {
                    zOnInterceptTouchEvent = cVar.onInterceptTouchEvent(this, view, motionEvent);
                } else if (i2 == 1) {
                    zOnInterceptTouchEvent = cVar.onTouchEvent(this, view, motionEvent);
                }
                if (zOnInterceptTouchEvent) {
                    this.mBehaviorTouchView = view;
                }
            }
        }
        arrayList.clear();
        return zOnInterceptTouchEvent;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        c cVar = ((f) view.getLayoutParams()).a;
        if (cVar == null || !cVar.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.mDisallowInterceptReset) {
            return;
        }
        resetTouchBehaviors(false);
        this.mDisallowInterceptReset = true;
    }

    public final void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c cVar = ((f) childAt.getLayoutParams()).a;
            if (cVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    cVar.onInterceptTouchEvent(this, childAt, motionEventObtain);
                } else {
                    cVar.onTouchEvent(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).getClass();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    @Override // android.view.View
    public final void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public final void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    @Override // android.view.View
    public final void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        drawable.setVisible(z, false);
    }

    public final void setupForInsets() {
        WeakHashMap weakHashMap = qd1.a;
        if (!getFitsSystemWindows()) {
            b2.u(this, null);
            return;
        }
        if (this.mApplyWindowInsetsListener == null) {
            this.mApplyWindowInsetsListener = new a();
        }
        b2.u(this, this.mApplyWindowInsetsListener);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }
}
