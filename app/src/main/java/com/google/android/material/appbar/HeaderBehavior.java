package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.e;
import defpackage.qd1;
import java.util.WeakHashMap;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    public int activePointerId;
    public Runnable flingRunnable;
    public boolean isBeingDragged;
    public int lastMotionY;
    public OverScroller scroller;
    public int touchSlop;
    public VelocityTracker velocityTracker;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class FlingRunnable implements Runnable {
        public final View layout;
        public final CoordinatorLayout parent;

        public FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.parent = coordinatorLayout;
            this.layout = v;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HeaderBehavior headerBehavior;
            OverScroller overScroller;
            View view = this.layout;
            if (view == null || (overScroller = (headerBehavior = HeaderBehavior.this).scroller) == null) {
                return;
            }
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            CoordinatorLayout coordinatorLayout = this.parent;
            if (!zComputeScrollOffset) {
                headerBehavior.onFlingFinished(coordinatorLayout, view);
                return;
            }
            headerBehavior.setHeaderTopBottomOffset(coordinatorLayout, view, headerBehavior.scroller.getCurrY(), AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, Integer.MAX_VALUE);
            WeakHashMap weakHashMap = qd1.a;
            view.postOnAnimation(this);
        }
    }

    public HeaderBehavior() {
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    public boolean canDragView(View view) {
        return false;
    }

    public int getMaxDragOffset(View view) {
        return -view.getHeight();
    }

    public int getScrollRangeForDragFling(View view) {
        return view.getHeight();
    }

    public void onFlingFinished(CoordinatorLayout coordinatorLayout, View view) {
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    /* JADX WARN: Code duplicated, block: B:26:0x0060  */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0071  */
    /* JADX WARN: Code duplicated, block: B:40:0x008b  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int y;
        boolean z;
        OverScroller overScroller;
        int iFindPointerIndex;
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.isBeingDragged) {
            int i = this.activePointerId;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                if (Math.abs(y2 - this.lastMotionY) > this.touchSlop) {
                    this.lastMotionY = y2;
                    return true;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.activePointerId = -1;
                    int x = (int) motionEvent.getX();
                    y = (int) motionEvent.getY();
                    if (canDragView(view)) {
                        z = false;
                    } else {
                        z = false;
                    }
                    this.isBeingDragged = z;
                    if (z) {
                        this.lastMotionY = y;
                        this.activePointerId = motionEvent.getPointerId(0);
                        if (this.velocityTracker == null) {
                            this.velocityTracker = VelocityTracker.obtain();
                        }
                        overScroller = this.scroller;
                        if (overScroller != null) {
                            this.scroller.abortAnimation();
                            return true;
                        }
                    }
                }
                velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                }
            }
        } else {
            if (motionEvent.getActionMasked() == 0) {
                this.activePointerId = -1;
                int x2 = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (canDragView(view) || !coordinatorLayout.isPointInChildBounds(view, x2, y)) {
                    z = false;
                } else {
                    z = true;
                }
                this.isBeingDragged = z;
                if (z) {
                    this.lastMotionY = y;
                    this.activePointerId = motionEvent.getPointerId(0);
                    if (this.velocityTracker == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    }
                    overScroller = this.scroller;
                    if (overScroller != null && !overScroller.isFinished()) {
                        this.scroller.abortAnimation();
                        return true;
                    }
                }
            }
            velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00da A[ADDED_TO_REGION] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                if (iFindPointerIndex != -1) {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i = this.lastMotionY - y;
                    this.lastMotionY = y;
                    setHeaderTopBottomOffset(coordinatorLayout, view, getTopBottomOffsetForScrollingSibling() - i, getMaxDragOffset(view), 0);
                }
            }
            if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i2 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.activePointerId = motionEvent.getPointerId(i2);
                    this.lastMotionY = (int) (motionEvent.getY(i2) + 0.5f);
                }
            }
            z = false;
            velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return !this.isBeingDragged || z;
        }
        VelocityTracker velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.velocityTracker.computeCurrentVelocity(InternalZipConstants.AES_HASH_ITERATIONS);
            float yVelocity = this.velocityTracker.getYVelocity(this.activePointerId);
            int i3 = -getScrollRangeForDragFling(view);
            Runnable runnable = this.flingRunnable;
            if (runnable != null) {
                view.removeCallbacks(runnable);
                this.flingRunnable = null;
            }
            if (this.scroller == null) {
                this.scroller = new OverScroller(view.getContext());
            }
            this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(yVelocity), 0, 0, i3, 0);
            if (this.scroller.computeScrollOffset()) {
                FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, view);
                this.flingRunnable = flingRunnable;
                WeakHashMap weakHashMap = qd1.a;
                view.postOnAnimation(flingRunnable);
            } else {
                onFlingFinished(coordinatorLayout, view);
            }
            z = true;
        }
        this.isBeingDragged = false;
        this.activePointerId = -1;
        velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
        velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.isBeingDragged) {
        }
        z = false;
        this.isBeingDragged = false;
        this.activePointerId = -1;
        velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
        velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.isBeingDragged) {
        }
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        int iD;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (iD = e.d(i, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(iD);
        return topAndBottomOffset - iD;
    }
}
