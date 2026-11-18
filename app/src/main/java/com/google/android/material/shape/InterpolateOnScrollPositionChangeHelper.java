package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import defpackage.d;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class InterpolateOnScrollPositionChangeHelper {
    public final ScrollView containingScrollView;
    public final MaterialShapeDrawable materialShapeDrawable;
    public final View shapedView;
    public final int[] scrollLocation = new int[2];
    public final int[] containerLocation = new int[2];

    public InterpolateOnScrollPositionChangeHelper(View view, MaterialShapeDrawable materialShapeDrawable, ScrollView scrollView) {
        new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                float f;
                InterpolateOnScrollPositionChangeHelper interpolateOnScrollPositionChangeHelper = InterpolateOnScrollPositionChangeHelper.this;
                MaterialShapeDrawable materialShapeDrawable2 = interpolateOnScrollPositionChangeHelper.materialShapeDrawable;
                int[] iArr = interpolateOnScrollPositionChangeHelper.containerLocation;
                int[] iArr2 = interpolateOnScrollPositionChangeHelper.scrollLocation;
                View view2 = interpolateOnScrollPositionChangeHelper.shapedView;
                ScrollView scrollView2 = interpolateOnScrollPositionChangeHelper.containingScrollView;
                if (scrollView2 == null) {
                    return;
                }
                if (scrollView2.getChildCount() == 0) {
                    d.AnonymousClass0.m("Scroll bar must contain a child to calculate interpolation.");
                    return;
                }
                scrollView2.getLocationInWindow(iArr2);
                scrollView2.getChildAt(0).getLocationInWindow(iArr);
                int top = (view2.getTop() - iArr2[1]) + iArr[1];
                int height = view2.getHeight();
                int height2 = scrollView2.getHeight();
                if (top >= 0) {
                    int i = top + height;
                    if (i > height2) {
                        f = 1.0f - ((i - height2) / height);
                    } else if (materialShapeDrawable2.drawableState.interpolation == 1.0f) {
                        return;
                    } else {
                        materialShapeDrawable2.setInterpolation(1.0f);
                    }
                    view2.invalidate();
                }
                f = (top / height) + 1.0f;
                materialShapeDrawable2.setInterpolation(Math.max(0.0f, Math.min(1.0f, f)));
                view2.invalidate();
            }
        };
        this.shapedView = view;
        this.materialShapeDrawable = materialShapeDrawable;
        this.containingScrollView = scrollView;
    }
}
