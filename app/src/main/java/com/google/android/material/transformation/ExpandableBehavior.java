package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.expandable.ExpandableWidget;
import defpackage.qd1;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {
    public int currentState;

    public ExpandableBehavior() {
        this.currentState = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentState = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean layoutDependsOn(View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        boolean zIsExpanded = expandableWidget.isExpanded();
        int i = this.currentState;
        if (zIsExpanded) {
            if (i != 0 && i != 2) {
                return false;
            }
        } else if (i != 1) {
            return false;
        }
        this.currentState = expandableWidget.isExpanded() ? 1 : 2;
        onExpandedStateChange((View) expandableWidget, view, expandableWidget.isExpanded(), true);
        return true;
    }

    public abstract void onExpandedStateChange(View view, View view2, boolean z, boolean z2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, final View view, int i) {
        final ExpandableWidget expandableWidget;
        WeakHashMap weakHashMap = qd1.a;
        if (!view.isLaidOut()) {
            ArrayList dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    expandableWidget = null;
                    break;
                }
                View view2 = (View) dependencies.get(i2);
                if (layoutDependsOn(view, view2)) {
                    expandableWidget = (ExpandableWidget) view2;
                    break;
                }
                i2++;
            }
            if (expandableWidget != null) {
                boolean zIsExpanded = expandableWidget.isExpanded();
                int i3 = this.currentState;
                if (!zIsExpanded ? i3 == 1 : !(i3 != 0 && i3 != 2)) {
                    final int i4 = expandableWidget.isExpanded() ? 1 : 2;
                    this.currentState = i4;
                    view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.transformation.ExpandableBehavior.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public final boolean onPreDraw() {
                            View view3 = view;
                            view3.getViewTreeObserver().removeOnPreDrawListener(this);
                            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                            if (expandableBehavior.currentState == i4) {
                                ExpandableWidget expandableWidget2 = expandableWidget;
                                expandableBehavior.onExpandedStateChange((View) expandableWidget2, view3, expandableWidget2.isExpanded(), false);
                            }
                            return false;
                        }
                    });
                }
            }
        }
        return false;
    }
}
