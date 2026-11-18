package com.google.android.material.navigationrail;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.fg1;
import defpackage.m6;
import defpackage.qd1;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class NavigationRailView extends NavigationBarView {
    public final View headerView;
    public final int topMargin;

    public NavigationRailView(Context context) {
        this(context, null);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.vd);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.plurals.a2g);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.n4);
        this.topMargin = dimensionPixelSize;
        m6 m6VarObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(getContext(), attributeSet, com.google.android.material.R.styleable.NavigationRailView, i, i2, new int[0]);
        TypedArray typedArray = (TypedArray) m6VarObtainTintedStyledAttributes.a;
        int resourceId = typedArray.getResourceId(0, 0);
        if (resourceId != 0) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
            View view = this.headerView;
            if (view != null) {
                removeView(view);
                this.headerView = null;
            }
            this.headerView = viewInflate;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = dimensionPixelSize;
            addView(viewInflate, 0, layoutParams);
        }
        int i3 = typedArray.getInt(2, 49);
        NavigationRailMenuView navigationRailMenuView = (NavigationRailMenuView) this.menuView;
        FrameLayout.LayoutParams layoutParams2 = navigationRailMenuView.layoutParams;
        if (layoutParams2.gravity != i3) {
            layoutParams2.gravity = i3;
            navigationRailMenuView.setLayoutParams(layoutParams2);
        }
        if (typedArray.hasValue(1)) {
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(1, -1);
            NavigationRailMenuView navigationRailMenuView2 = (NavigationRailMenuView) this.menuView;
            if (navigationRailMenuView2.itemMinimumHeight != dimensionPixelSize2) {
                navigationRailMenuView2.itemMinimumHeight = dimensionPixelSize2;
                navigationRailMenuView2.requestLayout();
            }
        }
        m6VarObtainTintedStyledAttributes.n();
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener(this) { // from class: com.google.android.material.navigationrail.NavigationRailView.1
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public final fg1 onApplyWindowInsets(View view2, fg1 fg1Var, ViewUtils.RelativePadding relativePadding) {
                relativePadding.top = fg1Var.d() + relativePadding.top;
                relativePadding.bottom = fg1Var.a() + relativePadding.bottom;
                WeakHashMap weakHashMap = qd1.a;
                boolean z = view2.getLayoutDirection() == 1;
                int iB = fg1Var.b();
                int iC = fg1Var.c();
                int i4 = relativePadding.start;
                if (z) {
                    iB = iC;
                }
                int i5 = i4 + iB;
                relativePadding.start = i5;
                view2.setPaddingRelative(i5, relativePadding.top, relativePadding.end, relativePadding.bottom);
                return fg1Var;
            }
        });
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public final NavigationBarMenuView createNavigationBarMenuView(Context context) {
        return new NavigationRailMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public final int getMaxItemCount() {
        return 7;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        NavigationRailMenuView navigationRailMenuView = (NavigationRailMenuView) this.menuView;
        View view = this.headerView;
        int i5 = 0;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        int i6 = this.topMargin;
        if (z2) {
            int bottom = this.headerView.getBottom() + i6;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i5 = bottom - top;
            }
        } else if ((navigationRailMenuView.layoutParams.gravity & 112) == 48) {
            i5 = i6;
        }
        if (i5 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i5, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i5);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i) != 1073741824 && suggestedMinimumWidth > 0) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), getPaddingRight() + getPaddingLeft() + suggestedMinimumWidth), 1073741824);
        }
        super.onMeasure(i, i2);
        View view = this.headerView;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        measureChild((NavigationRailMenuView) this.menuView, i, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.headerView.getMeasuredHeight()) - this.topMargin, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED));
    }
}
