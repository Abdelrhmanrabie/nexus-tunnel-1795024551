package com.blacksquircle.ui.editorkit.widget.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import com.blacksquircle.ui.editorkit.widget.TextScroller;
import defpackage.u5;
import java.util.ArrayList;
import java.util.Iterator;
import net.lingala.zip4j.util.InternalZipConstants;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class ScrollableEditText extends u5 {
    public boolean horizontallyScrollable;
    public final float maximumVelocity;
    public final ArrayList scrollListeners;
    public final OverScroller textScroller;
    public VelocityTracker velocityTracker;

    public ScrollableEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.bd);
    }

    public ScrollableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.textScroller = new OverScroller(context);
        this.scrollListeners = new ArrayList();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // android.widget.TextView, android.view.View
    public final void computeScroll() {
        OverScroller overScroller = this.textScroller;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            if (currY >= 0 || getScrollY() - Math.abs(currY) > 0) {
                scrollTo(currX, currY);
            }
            postInvalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        Iterator it = this.scrollListeners.iterator();
        while (it.hasNext()) {
            ((TextScroller) it.next()).onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Iterator it = this.scrollListeners.iterator();
        while (it.hasNext()) {
            ((TextScroller) it.next()).onScrollChanged(getScrollX(), getScrollY(), getScrollX(), getScrollY());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        int action = motionEvent.getAction();
        OverScroller overScroller = this.textScroller;
        if (action == 0) {
            if (!overScroller.isFinished()) {
                overScroller.abortAnimation();
            }
            VelocityTracker velocityTracker3 = this.velocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.clear();
            }
        } else if (action == 1) {
            VelocityTracker velocityTracker4 = this.velocityTracker;
            if (velocityTracker4 != null) {
                velocityTracker4.computeCurrentVelocity(InternalZipConstants.AES_HASH_ITERATIONS, this.maximumVelocity);
            }
            int xVelocity = (!this.horizontallyScrollable || (velocityTracker = this.velocityTracker) == null) ? 0 : (int) velocityTracker.getXVelocity();
            VelocityTracker velocityTracker5 = this.velocityTracker;
            int yVelocity = velocityTracker5 != null ? (int) velocityTracker5.getYVelocity() : 0;
            if (Math.abs(yVelocity) < 0 || Math.abs(xVelocity) < 0) {
                VelocityTracker velocityTracker6 = this.velocityTracker;
                if (velocityTracker6 != null) {
                    velocityTracker6.recycle();
                }
                this.velocityTracker = null;
            } else if (xVelocity != 0 || yVelocity != 0) {
                overScroller.fling(getScrollX(), getScrollY(), -xVelocity, -yVelocity, 0, getPaddingEnd() + getPaddingStart() + (getLayout().getWidth() - getWidth()), 0, getPaddingBottom() + getPaddingTop() + (getLayout().getHeight() - getHeight()));
            }
        } else if (action == 2 && (velocityTracker2 = this.velocityTracker) != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public final void setHorizontallyScrolling(boolean z) {
        super.setHorizontallyScrolling(z);
        this.horizontallyScrollable = z;
    }
}
