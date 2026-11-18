package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.o1;
import defpackage.qd1;
import defpackage.s1;
import defpackage.v3;
import defpackage.vd1;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public boolean interceptingEvents;
    public OnDismissListener listener;
    public vd1 viewDragHelper;
    public int swipeDirection = 2;
    public final float dragDismissThreshold = 0.5f;
    public float alphaStartSwipeDistance = 0.0f;
    public float alphaEndSwipeDistance = 0.5f;
    public final v3 dragCallback = new v3() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1
        public int activePointerId = -1;
        public int originalCapturedViewLeft;

        /* JADX WARN: Code duplicated, block: B:12:0x0019  */
        /* JADX WARN: Code duplicated, block: B:13:0x0021  */
        @Override // defpackage.v3
        public final int clampViewPositionHorizontal(View view, int i) {
            int width;
            int width2;
            WeakHashMap weakHashMap = qd1.a;
            boolean z = view.getLayoutDirection() == 1;
            int i2 = SwipeDismissBehavior.this.swipeDirection;
            if (i2 == 0) {
                if (z) {
                    width = this.originalCapturedViewLeft - view.getWidth();
                    width2 = this.originalCapturedViewLeft;
                } else {
                    width = this.originalCapturedViewLeft;
                    width2 = view.getWidth() + width;
                }
            } else if (i2 != 1) {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = view.getWidth() + this.originalCapturedViewLeft;
            } else if (z) {
                width = this.originalCapturedViewLeft;
                width2 = view.getWidth() + width;
            } else {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = this.originalCapturedViewLeft;
            }
            return Math.min(Math.max(width, i), width2);
        }

        @Override // defpackage.v3
        public final int clampViewPositionVertical(View view, int i) {
            return view.getTop();
        }

        @Override // defpackage.v3
        public final int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // defpackage.v3
        public final void onViewCaptured(View view, int i) {
            this.activePointerId = i;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // defpackage.v3
        public final void onViewDragStateChanged(int i) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i);
            }
        }

        @Override // defpackage.v3
        public final void onViewPositionChanged(View view, int i, int i2) {
            float f = this.originalCapturedViewLeft;
            float width = view.getWidth();
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            float f2 = (width * swipeDismissBehavior.alphaStartSwipeDistance) + f;
            float width2 = (view.getWidth() * swipeDismissBehavior.alphaEndSwipeDistance) + this.originalCapturedViewLeft;
            float f3 = i;
            if (f3 <= f2) {
                view.setAlpha(1.0f);
            } else if (f3 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((f3 - f2) / (width2 - f2))), 1.0f));
            }
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0052  */
        /* JADX WARN: Code duplicated, block: B:29:0x005a  */
        /* JADX WARN: Code duplicated, block: B:30:0x005c  */
        /* JADX WARN: Code duplicated, block: B:32:0x005f  */
        @Override // defpackage.v3
        public final void onViewReleased(View view, float f, float f2) {
            int left;
            int i;
            int i2;
            OnDismissListener onDismissListener;
            this.activePointerId = -1;
            int width = view.getWidth();
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            boolean z = false;
            if (f != 0.0f) {
                WeakHashMap weakHashMap = qd1.a;
                boolean z2 = view.getLayoutDirection() == 1;
                int i3 = swipeDismissBehavior.swipeDirection;
                if (i3 != 2 && (i3 != 0 ? i3 != 1 || (!z2 ? f < 0.0f : f > 0.0f) : !z2 ? f > 0.0f : f < 0.0f)) {
                    i2 = this.originalCapturedViewLeft;
                } else {
                    left = view.getLeft();
                    i = this.originalCapturedViewLeft;
                    if (left < i) {
                        i2 = i - width;
                    } else {
                        i2 = i + width;
                    }
                    z = true;
                }
            } else {
                if (Math.abs(view.getLeft() - this.originalCapturedViewLeft) >= Math.round(view.getWidth() * swipeDismissBehavior.dragDismissThreshold)) {
                    left = view.getLeft();
                    i = this.originalCapturedViewLeft;
                    if (left < i) {
                        i2 = i - width;
                    } else {
                        i2 = i + width;
                    }
                    z = true;
                } else {
                    i2 = this.originalCapturedViewLeft;
                }
            }
            if (swipeDismissBehavior.viewDragHelper.q(i2, view.getTop())) {
                SettleRunnable settleRunnable = new SettleRunnable(view, z);
                WeakHashMap weakHashMap2 = qd1.a;
                view.postOnAnimation(settleRunnable);
            } else {
                if (!z || (onDismissListener = swipeDismissBehavior.listener) == null) {
                    return;
                }
                onDismissListener.onDismiss(view);
            }
        }

        @Override // defpackage.v3
        public final boolean tryCaptureView(View view, int i) {
            int i2 = this.activePointerId;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.canSwipeDismissView(view);
        }
    };

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class SettleRunnable implements Runnable {
        public final boolean dismiss;
        public final View view;

        public SettleRunnable(View view, boolean z) {
            this.view = view;
            this.dismiss = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OnDismissListener onDismissListener;
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            vd1 vd1Var = swipeDismissBehavior.viewDragHelper;
            View view = this.view;
            if (vd1Var != null && vd1Var.g()) {
                WeakHashMap weakHashMap = qd1.a;
                view.postOnAnimation(this);
            } else {
                if (!this.dismiss || (onDismissListener = swipeDismissBehavior.listener) == null) {
                    return;
                }
                onDismissListener.onDismiss(view);
            }
        }
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zIsPointInChildBounds = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zIsPointInChildBounds = coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = zIsPointInChildBounds;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!zIsPointInChildBounds) {
            return false;
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = new vd1(coordinatorLayout.getContext(), coordinatorLayout, this.dragCallback);
        }
        return this.viewDragHelper.r(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        WeakHashMap weakHashMap = qd1.a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            qd1.i(view, 1048576);
            qd1.g(view, 0);
            if (canSwipeDismissView(view)) {
                qd1.j(view, o1.a.l, new s1() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                    @Override // defpackage.s1
                    public final boolean perform(View view2) {
                        SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
                        boolean z = false;
                        if (!swipeDismissBehavior.canSwipeDismissView(view2)) {
                            return false;
                        }
                        WeakHashMap weakHashMap2 = qd1.a;
                        boolean z2 = view2.getLayoutDirection() == 1;
                        int i2 = swipeDismissBehavior.swipeDirection;
                        if ((i2 == 0 && z2) || (i2 == 1 && !z2)) {
                            z = true;
                        }
                        int width = view2.getWidth();
                        if (z) {
                            width = -width;
                        }
                        view2.offsetLeftAndRight(width);
                        view2.setAlpha(0.0f);
                        OnDismissListener onDismissListener = swipeDismissBehavior.listener;
                        if (onDismissListener != null) {
                            onDismissListener.onDismiss(view2);
                        }
                        return true;
                    }
                });
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        vd1 vd1Var = this.viewDragHelper;
        if (vd1Var == null) {
            return false;
        }
        vd1Var.k(motionEvent);
        return true;
    }
}
