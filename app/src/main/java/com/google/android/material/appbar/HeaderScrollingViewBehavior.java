package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.e;
import defpackage.fg1;
import defpackage.qd1;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    public int overlayTop;
    public final Rect tempRect1;
    public final Rect tempRect2;
    public int verticalLayoutGap;

    public HeaderScrollingViewBehavior() {
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    public abstract AppBarLayout findFirstDependency(ArrayList arrayList);

    public float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    public int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public final void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        AppBarLayout appBarLayoutFindFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
        int bottom = 0;
        if (appBarLayoutFindFirstDependency != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            int paddingLeft = coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
            int bottom2 = appBarLayoutFindFirstDependency.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin;
            int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin;
            int bottom3 = ((appBarLayoutFindFirstDependency.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
            Rect rect = this.tempRect1;
            rect.set(paddingLeft, bottom2, width, bottom3);
            fg1 fg1Var = coordinatorLayout.mLastInsets;
            if (fg1Var != null) {
                WeakHashMap weakHashMap = qd1.a;
                if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rect.left = fg1Var.b() + rect.left;
                    rect.right -= fg1Var.c();
                }
            }
            int i2 = fVar.c;
            if (i2 == 0) {
                i2 = 8388659;
            }
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            Rect rect2 = this.tempRect2;
            Gravity.apply(i2, measuredWidth, measuredHeight, rect, rect2, i);
            if (this.overlayTop != 0) {
                float overlapRatioForOffset = getOverlapRatioForOffset(appBarLayoutFindFirstDependency);
                int i3 = this.overlayTop;
                bottom = e.d((int) (overlapRatioForOffset * i3), 0, i3);
            }
            view.layout(rect2.left, rect2.top - bottom, rect2.right, rect2.bottom - bottom);
            bottom = rect2.top - appBarLayoutFindFirstDependency.getBottom();
        } else {
            coordinatorLayout.onLayoutChild(view, i);
        }
        this.verticalLayoutGap = bottom;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        AppBarLayout appBarLayoutFindFirstDependency;
        fg1 fg1Var;
        int i4 = view.getLayoutParams().height;
        if ((i4 != -1 && i4 != -2) || (appBarLayoutFindFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size > 0) {
            WeakHashMap weakHashMap = qd1.a;
            if (appBarLayoutFindFirstDependency.getFitsSystemWindows() && (fg1Var = coordinatorLayout.mLastInsets) != null) {
                size += fg1Var.a() + fg1Var.d();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.onMeasureChild(i, i2, View.MeasureSpec.makeMeasureSpec((size + getScrollRange(appBarLayoutFindFirstDependency)) - appBarLayoutFindFirstDependency.getMeasuredHeight(), i4 == -1 ? 1073741824 : AttribFlags.SSH_FILEXFER_ATTR_EXTENDED), view);
        return true;
    }
}
