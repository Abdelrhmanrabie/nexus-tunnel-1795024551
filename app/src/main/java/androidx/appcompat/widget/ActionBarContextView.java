package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.k;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.b2;
import defpackage.e;
import defpackage.qd1;
import defpackage.ue1;
import defpackage.y1;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends defpackage.c {
    public CharSequence o;
    public CharSequence p;
    public View q;
    public View r;
    public View s;
    public LinearLayout t;
    public TextView u;
    public TextView v;
    public final int w;
    public final int x;
    public boolean y;
    public final int z;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public final class a implements View.OnClickListener {
        public final /* synthetic */ y1 b;

        public a(y1 y1Var) {
            this.b = y1Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.a();
        }
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, R.style.a9);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b2.d, R.style.a9, 0);
        Drawable drawable = (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : e.s(context, resourceId);
        WeakHashMap weakHashMap = qd1.a;
        setBackground(drawable);
        this.w = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.x = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.g = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.z = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.f);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0072  */
    /* JADX WARN: Code duplicated, block: B:21:0x008a  */
    public final void f(y1 y1Var) {
        View viewInflate;
        androidx.appcompat.widget.a aVar;
        androidx.appcompat.widget.a aVar2;
        k kVar;
        k kVar2;
        androidx.appcompat.widget.a.C0001a c0001a;
        View view = this.q;
        if (view != null) {
            if (view.getParent() == null) {
                viewInflate = this.q;
            }
            View viewFindViewById = this.q.findViewById(R.attr.bt);
            this.r = viewFindViewById;
            viewFindViewById.setOnClickListener(new a(y1Var));
            f fVarC = y1Var.c();
            aVar = this.f;
            if (aVar != null) {
                aVar.b();
                c0001a = aVar.A;
                if (c0001a != null && c0001a.b()) {
                    c0001a.j.dismiss();
                }
            }
            androidx.appcompat.widget.a aVar3 = new androidx.appcompat.widget.a(getContext());
            this.f = aVar3;
            aVar3.s = true;
            aVar3.t = true;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            fVarC.addMenuPresenter(this.f, this.c);
            aVar2 = this.f;
            kVar = aVar2.n;
            if (kVar == null) {
                k kVar3 = (k) aVar2.f.inflate(aVar2.i, (ViewGroup) this, false);
                aVar2.n = kVar3;
                kVar3.initialize(aVar2.d);
                aVar2.updateMenuView(true);
            }
            kVar2 = aVar2.n;
            if (kVar != kVar2) {
                ActionMenuView actionMenuView = (ActionMenuView) kVar2;
                actionMenuView.g = aVar2;
                aVar2.n = actionMenuView;
                actionMenuView.b = aVar2.d;
            }
            ActionMenuView actionMenuView2 = (ActionMenuView) kVar2;
            this.d = actionMenuView2;
            WeakHashMap weakHashMap = qd1.a;
            actionMenuView2.setBackground(null);
            addView(this.d, layoutParams);
        }
        viewInflate = LayoutInflater.from(getContext()).inflate(this.z, (ViewGroup) this, false);
        this.q = viewInflate;
        addView(viewInflate);
        View viewFindViewById2 = this.q.findViewById(R.attr.bt);
        this.r = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new a(y1Var));
        f fVarC2 = y1Var.c();
        aVar = this.f;
        if (aVar != null) {
            aVar.b();
            c0001a = aVar.A;
            if (c0001a != null) {
                c0001a.j.dismiss();
            }
        }
        androidx.appcompat.widget.a aVar4 = new androidx.appcompat.widget.a(getContext());
        this.f = aVar4;
        aVar4.s = true;
        aVar4.t = true;
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -1);
        fVarC2.addMenuPresenter(this.f, this.c);
        aVar2 = this.f;
        kVar = aVar2.n;
        if (kVar == null) {
            k kVar4 = (k) aVar2.f.inflate(aVar2.i, (ViewGroup) this, false);
            aVar2.n = kVar4;
            kVar4.initialize(aVar2.d);
            aVar2.updateMenuView(true);
        }
        kVar2 = aVar2.n;
        if (kVar != kVar2) {
            ActionMenuView actionMenuView3 = (ActionMenuView) kVar2;
            actionMenuView3.g = aVar2;
            aVar2.n = actionMenuView3;
            actionMenuView3.b = aVar2.d;
        }
        ActionMenuView actionMenuView4 = (ActionMenuView) kVar2;
        this.d = actionMenuView4;
        WeakHashMap weakHashMap2 = qd1.a;
        actionMenuView4.setBackground(null);
        addView(this.d, layoutParams2);
    }

    public final void g() {
        if (this.t == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.t = linearLayout;
            this.u = (TextView) linearLayout.findViewById(R.attr.bk);
            this.v = (TextView) this.t.findViewById(R.attr.bj);
            int i = this.w;
            if (i != 0) {
                this.u.setTextAppearance(getContext(), i);
            }
            int i2 = this.x;
            if (i2 != 0) {
                this.v.setTextAppearance(getContext(), i2);
            }
        }
        this.u.setText(this.o);
        this.v.setText(this.p);
        boolean zIsEmpty = TextUtils.isEmpty(this.o);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.p);
        int i3 = 0;
        this.v.setVisibility(!zIsEmpty2 ? 0 : 8);
        LinearLayout linearLayout2 = this.t;
        if (zIsEmpty && zIsEmpty2) {
            i3 = 8;
        }
        linearLayout2.setVisibility(i3);
        if (this.t.getParent() == null) {
            addView(this.t);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public final void h() {
        removeAllViews();
        this.s = null;
        this.d = null;
        this.f = null;
        View view = this.r;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.appcompat.widget.a aVar = this.f;
        if (aVar != null) {
            aVar.b();
            androidx.appcompat.widget.a.C0001a c0001a = this.f.A;
            if (c0001a == null || !c0001a.b()) {
                return;
            }
            c0001a.j.dismiss();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean zA = ue1.a(this);
        int paddingRight = zA ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.q;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.q.getLayoutParams();
            int i5 = zA ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zA ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i7 = zA ? paddingRight - i5 : paddingRight + i5;
            int iD = defpackage.c.d(i7, paddingTop, paddingTop2, this.q, zA) + i7;
            paddingRight = zA ? iD - i6 : iD + i6;
        }
        LinearLayout linearLayout = this.t;
        if (linearLayout != null && this.s == null && linearLayout.getVisibility() != 8) {
            paddingRight += defpackage.c.d(paddingRight, paddingTop, paddingTop2, this.t, zA);
        }
        View view2 = this.s;
        if (view2 != null) {
            defpackage.c.d(paddingRight, paddingTop, paddingTop2, view2, zA);
        }
        int paddingLeft = zA ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.d;
        if (actionMenuView != null) {
            defpackage.c.d(paddingLeft, paddingTop, paddingTop2, actionMenuView, !zA);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.g;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i2);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        View view = this.q;
        if (view != null) {
            int iC = defpackage.c.c(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.q.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.d;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = defpackage.c.c(this.d, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.t;
        if (linearLayout != null && this.s == null) {
            if (this.y) {
                this.t.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.t.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.t.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = defpackage.c.c(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.s;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i3 = layoutParams.width;
            int i4 = i3 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i3 >= 0) {
                paddingLeft = Math.min(i3, paddingLeft);
            }
            int i5 = layoutParams.height;
            int i6 = i5 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i5 >= 0) {
                iMin = Math.min(i5, iMin);
            }
            this.s.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(iMin, i6));
        }
        if (this.g <= 0) {
            int childCount = getChildCount();
            size2 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                int measuredHeight = getChildAt(i7).getMeasuredHeight() + paddingBottom;
                if (measuredHeight > size2) {
                    size2 = measuredHeight;
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // defpackage.c
    public final void setContentHeight(int i) {
        this.g = i;
    }

    public final void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.s;
        if (view2 != null) {
            removeView(view2);
        }
        this.s = view;
        if (view != null && (linearLayout = this.t) != null) {
            removeView(linearLayout);
            this.t = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
