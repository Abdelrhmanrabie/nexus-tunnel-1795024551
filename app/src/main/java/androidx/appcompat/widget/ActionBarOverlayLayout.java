package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.Toolbar.d;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.ak;
import defpackage.cg1;
import defpackage.fg1;
import defpackage.fk0;
import defpackage.g5;
import defpackage.gk0;
import defpackage.hk0;
import defpackage.ke1;
import defpackage.qd1;
import defpackage.t20;
import defpackage.wk;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements wk, fk0, gk0 {
    public static final int[] H = {R.style.k, android.R.attr.windowContentOverlay};
    public cg1 A;
    public OverScroller B;
    public ViewPropertyAnimator C;
    public final a D;
    public final b E;
    public final c F;
    public final hk0 G;
    public int b;
    public int c;
    public ContentFrameLayout d;
    public ActionBarContainer f;
    public androidx.appcompat.widget.d g;
    public Drawable i;
    public boolean j;
    public boolean n;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public final Rect t;
    public final Rect u;
    public final Rect v;
    public fg1 w;
    public fg1 x;
    public fg1 y;
    public fg1 z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.C = null;
            actionBarOverlayLayout.q = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.C = null;
            actionBarOverlayLayout.q = false;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.k();
            actionBarOverlayLayout.C = actionBarOverlayLayout.f.animate().translationY(0.0f).setListener(actionBarOverlayLayout.D);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.k();
            actionBarOverlayLayout.C = actionBarOverlayLayout.f.animate().translationY(-actionBarOverlayLayout.f.getHeight()).setListener(actionBarOverlayLayout.D);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface d {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e() {
            super(-1, -1);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        fg1 fg1Var = fg1.b;
        this.w = fg1Var;
        this.x = fg1Var;
        this.y = fg1Var;
        this.z = fg1Var;
        this.D = new a();
        this.E = new b();
        this.F = new c();
        l(context);
        this.G = new hk0();
    }

    public static boolean j(FrameLayout frameLayout, Rect rect, boolean z) {
        boolean z2;
        e eVar = (e) frameLayout.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
        int i2 = rect.left;
        if (i != i2) {
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i2;
            z2 = true;
        } else {
            z2 = false;
        }
        int i3 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        int i4 = rect.top;
        if (i3 != i4) {
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = i4;
            z2 = true;
        }
        int i5 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
        int i6 = rect.right;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i6;
            z2 = true;
        }
        if (z) {
            int i7 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            int i8 = rect.bottom;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i8;
                return true;
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.i == null || this.j) {
            return;
        }
        if (this.f.getVisibility() == 0) {
            translationY = (int) (this.f.getTranslationY() + this.f.getBottom() + 0.5f);
        } else {
            translationY = 0;
        }
        this.i.setBounds(0, translationY, getWidth(), this.i.getIntrinsicHeight() + translationY);
        this.i.draw(canvas);
    }

    public final void e(f fVar, g5 g5Var) {
        m();
        androidx.appcompat.widget.d dVar = this.g;
        androidx.appcompat.widget.a aVar = dVar.n;
        Toolbar toolbar = dVar.a;
        if (aVar == null) {
            androidx.appcompat.widget.a aVar2 = new androidx.appcompat.widget.a(toolbar.getContext());
            dVar.n = aVar2;
            aVar2.o = R.attr.bq;
        }
        androidx.appcompat.widget.a aVar3 = dVar.n;
        aVar3.g = g5Var;
        if (fVar == null && toolbar.mMenuView == null) {
            return;
        }
        toolbar.ensureMenuView();
        f fVar2 = toolbar.mMenuView.b;
        if (fVar2 == fVar) {
            return;
        }
        if (fVar2 != null) {
            fVar2.removeMenuPresenter(toolbar.mOuterActionMenuPresenter);
            fVar2.removeMenuPresenter(toolbar.mExpandedMenuPresenter);
        }
        if (toolbar.mExpandedMenuPresenter == null) {
            toolbar.mExpandedMenuPresenter = toolbar.new d();
        }
        aVar3.x = true;
        Context context = toolbar.mPopupContext;
        if (fVar != null) {
            fVar.addMenuPresenter(aVar3, context);
            fVar.addMenuPresenter(toolbar.mExpandedMenuPresenter, toolbar.mPopupContext);
        } else {
            aVar3.initForMenu(context, null);
            toolbar.mExpandedMenuPresenter.initForMenu(toolbar.mPopupContext, null);
            aVar3.updateMenuView(true);
            toolbar.mExpandedMenuPresenter.updateMenuView(true);
        }
        ActionMenuView actionMenuView = toolbar.mMenuView;
        int i = toolbar.mPopupTheme;
        if (actionMenuView.d != i) {
            actionMenuView.d = i;
            if (i == 0) {
                actionMenuView.c = actionMenuView.getContext();
            } else {
                actionMenuView.c = new ContextThemeWrapper(actionMenuView.getContext(), i);
            }
        }
        ActionMenuView actionMenuView2 = toolbar.mMenuView;
        actionMenuView2.g = aVar3;
        aVar3.n = actionMenuView2;
        actionMenuView2.b = aVar3.d;
        toolbar.mOuterActionMenuPresenter = aVar3;
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    @Override // android.view.ViewGroup
    public final int getNestedScrollAxes() {
        hk0 hk0Var = this.G;
        return hk0Var.b | hk0Var.a;
    }

    public final void h(int i) {
        m();
        if (i == 2 || i == 5) {
            this.g.getClass();
        } else {
            if (i != 109) {
                return;
            }
            this.n = true;
            this.j = getContext().getApplicationInfo().targetSdkVersion < 19;
        }
    }

    public final void k() {
        removeCallbacks(this.E);
        removeCallbacks(this.F);
        ViewPropertyAnimator viewPropertyAnimator = this.C;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void l(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(H);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.i = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.j = context.getApplicationInfo().targetSdkVersion < 19;
        this.B = new OverScroller(context);
    }

    public final void m() {
        if (this.d == null) {
            this.d = (ContentFrameLayout) findViewById(R.attr.bf);
            this.f = (ActionBarContainer) findViewById(R.attr.bg);
            View viewFindViewById = findViewById(R.attr.be);
            if (!(viewFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(viewFindViewById.getClass().getSimpleName()));
            }
            Toolbar toolbar = (Toolbar) viewFindViewById;
            if (toolbar.mWrapper == null) {
                toolbar.mWrapper = new androidx.appcompat.widget.d(toolbar, true);
            }
            this.g = toolbar.mWrapper;
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        m();
        fg1 fg1VarG = fg1.g(this, windowInsets);
        boolean zJ = j(this.f, new Rect(fg1VarG.b(), fg1VarG.d(), fg1VarG.c(), fg1VarG.a()), false);
        WeakHashMap weakHashMap = qd1.a;
        WindowInsets windowInsetsF = fg1VarG.f();
        Rect rect = this.t;
        if (windowInsetsF != null) {
            fg1.g(this, computeSystemWindowInsets(windowInsetsF, rect));
        } else {
            rect.setEmpty();
        }
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        fg1.k kVar = fg1VarG.a;
        fg1 fg1VarL = kVar.l(i, i2, i3, i4);
        this.w = fg1VarL;
        boolean z = true;
        if (!this.x.equals(fg1VarL)) {
            this.x = this.w;
            zJ = true;
        }
        Rect rect2 = this.u;
        if (rect2.equals(rect)) {
            z = zJ;
        } else {
            rect2.set(rect);
        }
        if (z) {
            requestLayout();
        }
        return kVar.a().a.c().a.b().f();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        l(getContext());
        WeakHashMap weakHashMap = qd1.a;
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int measuredHeight;
        ak cVar;
        fg1 fg1VarB;
        m();
        measureChildWithMargins(this.f, i, 0, i2, 0);
        e eVar = (e) this.f.getLayoutParams();
        int iMax = Math.max(0, this.f.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f.getMeasuredState());
        WeakHashMap weakHashMap = qd1.a;
        boolean z = (getWindowSystemUiVisibility() & 256) != 0;
        if (z) {
            measuredHeight = this.b;
        } else {
            measuredHeight = this.f.getVisibility() != 8 ? this.f.getMeasuredHeight() : 0;
        }
        Rect rect = this.v;
        rect.set(this.t);
        fg1 fg1Var = this.w;
        this.y = fg1Var;
        if (this.n || z) {
            t20 t20VarA = t20.a(fg1Var.b(), this.y.d() + measuredHeight, this.y.c(), this.y.a());
            fg1 fg1Var2 = this.y;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                cVar = new fg1.d(fg1Var2);
            } else if (i3 >= 29) {
                cVar = new fg1.c(fg1Var2);
            } else {
                fg1.b bVar = new fg1.b(false);
                bVar.a = fg1Var2.f();
                cVar = bVar;
            }
            cVar.d(t20VarA);
            fg1VarB = cVar.b();
        } else {
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            fg1VarB = fg1Var.a.l(0, measuredHeight, 0, 0);
        }
        this.y = fg1VarB;
        j(this.d, rect, true);
        if (!this.z.equals(this.y)) {
            fg1 fg1Var3 = this.y;
            this.z = fg1Var3;
            qd1.b(this.d, fg1Var3);
        }
        measureChildWithMargins(this.d, i, 0, i2, 0);
        e eVar2 = (e) this.d.getLayoutParams();
        int iMax3 = Math.max(iMax, this.d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.p || !z) {
            return false;
        }
        this.B.fling(0, 0, 0, (int) f2, 0, 0, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, Integer.MAX_VALUE);
        int finalY = this.B.getFinalY();
        int height = this.f.getHeight();
        k();
        if (finalY > height) {
            this.F.run();
        } else {
            this.E.run();
        }
        this.q = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // defpackage.fk0
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.r + i2;
        this.r = i5;
        k();
        this.f.setTranslationY(-Math.max(0, Math.min(i5, this.f.getHeight())));
    }

    @Override // defpackage.fk0
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // defpackage.gk0
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, i, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        ke1 ke1Var;
        this.G.a = i;
        ActionBarContainer actionBarContainer = this.f;
        this.r = actionBarContainer != null ? -((int) actionBarContainer.getTranslationY()) : 0;
        k();
        cg1 cg1Var = this.A;
        if (cg1Var == null || (ke1Var = cg1Var.t) == null) {
            return;
        }
        ke1Var.a();
        cg1Var.t = null;
    }

    @Override // defpackage.fk0
    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f.getVisibility() != 0) {
            return false;
        }
        return this.p;
    }

    @Override // defpackage.fk0
    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.p || this.q) {
            return;
        }
        int i = this.r;
        int height = this.f.getHeight();
        k();
        postDelayed(i <= height ? this.E : this.F, 600L);
    }

    @Override // defpackage.fk0
    public final void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        m();
        int i2 = this.s ^ i;
        this.s = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        cg1 cg1Var = this.A;
        if (cg1Var != null) {
            cg1Var.p = !z2;
            if (z || !z2) {
                if (cg1Var.q) {
                    cg1Var.q = false;
                    cg1Var.w(true);
                }
            } else if (!cg1Var.q) {
                cg1Var.q = true;
                cg1Var.w(true);
            }
        }
        if ((i2 & 256) == 0 || this.A == null) {
            return;
        }
        WeakHashMap weakHashMap = qd1.a;
        requestApplyInsets();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.c = i;
        cg1 cg1Var = this.A;
        if (cg1Var != null) {
            cg1Var.o = i;
        }
    }

    public final void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.p) {
            this.p = z;
            if (z) {
                return;
            }
            k();
            k();
            this.f.setTranslationY(-Math.max(0, Math.min(0, this.f.getHeight())));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
