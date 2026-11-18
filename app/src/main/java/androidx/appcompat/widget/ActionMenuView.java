package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.fragment.app.q;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.c5;
import defpackage.f71;
import defpackage.ue1;
import java.util.Iterator;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends androidx.appcompat.widget.b implements f.b, k {
    public f b;
    public Context c;
    public int d;
    public boolean f;
    public androidx.appcompat.widget.a g;
    public c5 i;
    public f71.b j;
    public boolean n;
    public int o;
    public final int p;
    public final int q;
    public Toolbar.a r;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface a {
        boolean a();

        boolean b();
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class b implements j.a {
        @Override // androidx.appcompat.view.menu.j.a
        public final boolean a(f fVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void onCloseMenu(f fVar, boolean z) {
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class c extends androidx.appcompat.widget.b.a {
        public boolean a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;
        public boolean f;

        public c() {
            super(-2, -2);
            this.a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.a = cVar.a;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class d implements f.a {
        public d() {
        }

        /* JADX WARN: Code duplicated, block: B:15:0x003c A[RETURN] */
        @Override // androidx.appcompat.view.menu.f.a
        public final boolean onMenuItemSelected(f fVar, MenuItem menuItem) {
            boolean zOnMenuItemSelected;
            Toolbar.a aVar = ActionMenuView.this.r;
            if (aVar != null) {
                Toolbar toolbar = Toolbar.this;
                Iterator it = toolbar.mMenuHostHelper.b.iterator();
                while (it.hasNext()) {
                    if (q.this.p(menuItem)) {
                        zOnMenuItemSelected = true;
                        if (zOnMenuItemSelected) {
                            return true;
                        }
                    }
                }
                f71.b bVar = toolbar.mOnMenuItemClickListener;
                zOnMenuItemSelected = bVar != null ? f71.this.b.b.onMenuItemSelected(0, menuItem) : false;
                if (zOnMenuItemSelected) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void onMenuModeChange(f fVar) {
            f71.b bVar = ActionMenuView.this.j;
            if (bVar != null) {
                bVar.onMenuModeChange(fVar);
            }
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface e {
    }

    public ActionMenuView() {
        throw null;
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBaselineAligned = false;
        float f = context.getResources().getDisplayMetrics().density;
        this.p = (int) (56.0f * f);
        this.q = (int) (f * 4.0f);
        this.c = context;
        this.d = 0;
    }

    public static c b(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            c cVar = new c();
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
            return cVar;
        }
        c cVar2 = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar2).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar2).gravity = 16;
        }
        return cVar2;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public final boolean a(h hVar) {
        return this.b.performItemAction(hVar, null, 0);
    }

    public final boolean c(int i) {
        boolean zA = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            zA = ((a) childAt).a();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? zA : ((a) childAt2).b() | zA;
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        c cVar = new c();
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup
    public final androidx.appcompat.widget.b.a generateDefaultLayoutParams() {
        c cVar = new c();
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup
    public final androidx.appcompat.widget.b.a generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ androidx.appcompat.widget.b.a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    public final f getMenu() {
        if (this.b == null) {
            Context context = getContext();
            f fVar = new f(context);
            this.b = fVar;
            fVar.mCallback = new d();
            androidx.appcompat.widget.a aVar = new androidx.appcompat.widget.a(context);
            this.g = aVar;
            aVar.s = true;
            aVar.t = true;
            j.a bVar = this.i;
            if (bVar == null) {
                bVar = new b();
            }
            aVar.g = bVar;
            this.b.addMenuPresenter(aVar, this.c);
            androidx.appcompat.widget.a aVar2 = this.g;
            aVar2.n = this;
            this.b = aVar2.d;
        }
        return this.b;
    }

    @Override // androidx.appcompat.view.menu.k
    public final void initialize(f fVar) {
        this.b = fVar;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.a aVar = this.g;
        if (aVar != null) {
            aVar.updateMenuView(false);
            if (this.g.c()) {
                this.g.b();
                this.g.d();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.appcompat.widget.a aVar = this.g;
        if (aVar != null) {
            aVar.b();
            androidx.appcompat.widget.a.C0001a c0001a = aVar.A;
            if (c0001a == null || !c0001a.b()) {
                return;
            }
            c0001a.j.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.n) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int i6 = i3 - i;
        int paddingRight = (i6 - getPaddingRight()) - getPaddingLeft();
        boolean zA = ue1.a(this);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (c(i10)) {
                        measuredWidth += this.mDividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zA) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i11 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    c(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i6 / 2) - (measuredWidth2 / 2);
            int i13 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int iMax = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (zA) {
            int width2 = getWidth() - getPaddingRight();
            while (i7 < childCount) {
                View childAt3 = getChildAt(i7);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.a) {
                    int i15 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i15 - measuredWidth3, i16, i15, measuredHeight3 + i16);
                    width2 = i15 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
                i7++;
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        while (i7 < childCount) {
            View childAt4 = getChildAt(i7);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.a) {
                int i17 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i18 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i17, i18, i17 + measuredWidth4, measuredHeight4 + i18);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax + i17;
            }
            i7++;
        }
    }

    @Override // androidx.appcompat.widget.b, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        f fVar;
        boolean z4 = this.n;
        boolean z5 = View.MeasureSpec.getMode(i) == 1073741824;
        this.n = z5;
        if (z4 != z5) {
            this.o = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.n && (fVar = this.b) != null && size != this.o) {
            this.o = size;
            fVar.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.n || childCount <= 0) {
            for (int i6 = 0; i6 < childCount; i6++) {
                c cVar = (c) getChildAt(i6).getLayoutParams();
                ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
        int i7 = size2 - paddingRight;
        int i8 = this.p;
        int i9 = i7 / i8;
        int i10 = i7 % i8;
        if (i9 == 0) {
            setMeasuredDimension(i7, 0);
            return;
        }
        int i11 = (i10 / i9) + i8;
        int childCount2 = getChildCount();
        int i12 = 0;
        int iMax = 0;
        int i13 = 0;
        int iMax2 = 0;
        boolean z6 = false;
        int i14 = 0;
        long j = 0;
        while (true) {
            i3 = this.q;
            if (i13 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i13);
            int i15 = size3;
            if (childAt.getVisibility() == 8) {
                i4 = paddingBottom;
            } else {
                boolean z7 = childAt instanceof ActionMenuItemView;
                i12++;
                if (z7) {
                    childAt.setPadding(i3, 0, i3, 0);
                }
                c cVar2 = (c) childAt.getLayoutParams();
                cVar2.f = false;
                cVar2.c = 0;
                cVar2.b = 0;
                cVar2.d = false;
                ((LinearLayout.LayoutParams) cVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) cVar2).rightMargin = 0;
                cVar2.e = z7 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i16 = cVar2.a ? 1 : i9;
                c cVar3 = (c) childAt.getLayoutParams();
                i4 = paddingBottom;
                int i17 = i9;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i4, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z7 ? (ActionMenuItemView) childAt : null;
                boolean z8 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z9 = z8;
                if (i16 <= 0 || (z8 && i16 < 2)) {
                    i5 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i16 * i11, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i5 = measuredWidth / i11;
                    if (measuredWidth % i11 != 0) {
                        i5++;
                    }
                    if (z9 && i5 < 2) {
                        i5 = 2;
                    }
                }
                cVar3.d = !cVar3.a && z9;
                cVar3.b = i5;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11 * i5, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i5);
                if (cVar2.d) {
                    i14++;
                }
                if (cVar2.a) {
                    z6 = true;
                }
                int i18 = i17 - i5;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i5 == 1) {
                    j |= (long) (1 << i13);
                }
                i9 = i18;
            }
            i13++;
            size3 = i15;
            paddingBottom = i4;
        }
        int i19 = size3;
        int i20 = i9;
        boolean z10 = z6 && i12 == 2;
        int i21 = i20;
        boolean z11 = false;
        while (true) {
            if (i14 <= 0 || i21 <= 0) {
                z = z11;
                break;
            }
            int i22 = Integer.MAX_VALUE;
            long j2 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i24 < childCount2) {
                boolean z12 = z10;
                c cVar4 = (c) getChildAt(i24).getLayoutParams();
                boolean z13 = z11;
                if (cVar4.d) {
                    int i25 = cVar4.b;
                    if (i25 < i22) {
                        j2 = 1 << i24;
                        i22 = i25;
                        i23 = 1;
                    } else if (i25 == i22) {
                        j2 |= 1 << i24;
                        i23++;
                    }
                }
                i24++;
                z11 = z13;
                z10 = z12;
            }
            boolean z14 = z10;
            z = z11;
            j |= j2;
            if (i23 > i21) {
                break;
            }
            int i26 = i22 + 1;
            int i27 = 0;
            while (i27 < childCount2) {
                View childAt2 = getChildAt(i27);
                c cVar5 = (c) childAt2.getLayoutParams();
                int i28 = iMax;
                long j3 = 1 << i27;
                if ((j2 & j3) != 0) {
                    if (!z14 || !cVar5.e) {
                        z3 = true;
                    } else if (i21 == 1) {
                        z3 = true;
                        childAt2.setPadding(i3 + i11, 0, i3, 0);
                    } else {
                        z3 = true;
                    }
                    cVar5.b++;
                    cVar5.f = z3;
                    i21--;
                } else if (cVar5.b == i26) {
                    j |= j3;
                }
                i27++;
                iMax = i28;
            }
            z10 = z14;
            z11 = true;
        }
        int i29 = iMax;
        boolean z15 = !z6 && i12 == 1;
        if (i21 <= 0 || j == 0 || (i21 >= i12 - 1 && !z15 && iMax2 <= 1)) {
            z2 = z;
        } else {
            float fBitCount = Long.bitCount(j);
            if (!z15) {
                if ((j & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
                int i30 = childCount2 - 1;
                if ((j & ((long) (1 << i30))) != 0 && !((c) getChildAt(i30).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
            }
            int i31 = fBitCount > 0.0f ? (int) ((i21 * i11) / fBitCount) : 0;
            boolean z16 = z;
            for (int i32 = 0; i32 < childCount2; i32++) {
                if ((j & ((long) (1 << i32))) != 0) {
                    View childAt3 = getChildAt(i32);
                    c cVar6 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar6.c = i31;
                        cVar6.f = true;
                        if (i32 == 0 && !cVar6.e) {
                            ((LinearLayout.LayoutParams) cVar6).leftMargin = (-i31) / 2;
                        }
                        z16 = true;
                    } else if (cVar6.a) {
                        cVar6.c = i31;
                        cVar6.f = true;
                        ((LinearLayout.LayoutParams) cVar6).rightMargin = (-i31) / 2;
                        z16 = true;
                    } else {
                        if (i32 != 0) {
                            ((LinearLayout.LayoutParams) cVar6).leftMargin = i31 / 2;
                        }
                        if (i32 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) cVar6).rightMargin = i31 / 2;
                        }
                    }
                }
            }
            z2 = z16;
        }
        if (z2) {
            for (int i33 = 0; i33 < childCount2; i33++) {
                View childAt4 = getChildAt(i33);
                c cVar7 = (c) childAt4.getLayoutParams();
                if (cVar7.f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar7.b * i11) + cVar7.c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i7, mode != 1073741824 ? i29 : i19);
    }
}
