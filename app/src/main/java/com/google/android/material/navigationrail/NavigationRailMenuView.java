package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    public int itemMinimumHeight;
    public final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(Context context) {
        super(context);
        this.itemMinimumHeight = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        this.itemActiveIndicatorResizeable = true;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.activeIndicatorResizeable = true;
            }
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    public final NavigationBarItemView createNavigationBarItemView(Context context) {
        return new NavigationRailItemView(context);
    }

    public final int makeSharedHeightSpec(int i, int i2, int i3) {
        int iMax = i2 / Math.max(1, i3);
        int size = this.itemMinimumHeight;
        if (size == -1) {
            size = View.MeasureSpec.getSize(i);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, iMax), 0);
    }

    public final int measureSharedChildHeights(int i, int i2, int i3, View view) {
        int measuredHeight;
        makeSharedHeightSpec(i, i2, i3);
        int iMakeSharedHeightSpec = view == null ? makeSharedHeightSpec(i, i2, i3) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i, iMakeSharedHeightSpec);
                    measuredHeight = childAt.getMeasuredHeight();
                } else {
                    measuredHeight = 0;
                }
                i4 += measuredHeight;
            }
        }
        return i4;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i6;
                childAt.layout(0, i6, i5, measuredHeight);
                i6 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int iMeasureSharedChildHeights;
        int measuredHeight;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.menu.getVisibleItems().size();
        if (size2 <= 1 || !NavigationBarMenuView.isShifting(this.labelVisibilityMode, size2)) {
            iMeasureSharedChildHeights = measureSharedChildHeights(i, size, size2, null);
        } else {
            View childAt = getChildAt(this.selectedItemPosition);
            if (childAt != null) {
                int iMakeSharedHeightSpec = makeSharedHeightSpec(i, size, size2);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(i, iMakeSharedHeightSpec);
                    measuredHeight = childAt.getMeasuredHeight();
                } else {
                    measuredHeight = 0;
                }
                size -= measuredHeight;
                size2--;
            } else {
                measuredHeight = 0;
            }
            iMeasureSharedChildHeights = measureSharedChildHeights(i, size, size2, childAt) + measuredHeight;
        }
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i), i, 0), View.resolveSizeAndState(iMeasureSharedChildHeights, i2, 0));
    }
}
