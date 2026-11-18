package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import android.view.animation.Interpolator;
import defpackage.a40;
import defpackage.b40;
import defpackage.qd1;
import java.util.List;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
    public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
    public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
    private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
    static final int RELATIVE_DIR_FLAGS = 3158064;
    private static final Interpolator sDragScrollInterpolator = new a();
    private static final Interpolator sDragViewScrollCapInterpolator = new b();
    private int mCachedMaxScrollSpeed = -1;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return f * f * f * f * f;
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public static int convertToRelativeDirection(int i, int i2) {
        int i3;
        int i4 = i & ABS_HORIZONTAL_DIR_FLAGS;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 << 2;
        } else {
            int i6 = i4 << 1;
            i5 |= (-789517) & i6;
            i3 = (i6 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
        }
        return i5 | i3;
    }

    public static b40 getDefaultUIUtil() {
        return defpackage.e.a$5;
    }

    public static int makeFlag(int i, int i2) {
        return i2 << (i * 8);
    }

    public static int makeMovementFlags(int i, int i2) {
        return makeFlag(2, i) | makeFlag(1, i2) | makeFlag(0, i2 | i);
    }

    public boolean canDropOver(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        return true;
    }

    public RecyclerView.d0 chooseDropTarget(RecyclerView.d0 d0Var, List<RecyclerView.d0> list, int i, int i2) {
        int bottom;
        int iAbs;
        int top;
        int iAbs2;
        int left;
        int iAbs3;
        int right;
        int iAbs4;
        int width = d0Var.itemView.getWidth() + i;
        View view = d0Var.itemView;
        int height = view.getHeight() + i2;
        int left2 = i - view.getLeft();
        int top2 = i2 - view.getTop();
        int size = list.size();
        RecyclerView.d0 d0Var2 = null;
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView.d0 d0Var3 = list.get(i4);
            if (left2 > 0 && (right = d0Var3.itemView.getRight() - width) < 0 && d0Var3.itemView.getRight() > view.getRight() && (iAbs4 = Math.abs(right)) > i3) {
                d0Var2 = d0Var3;
                i3 = iAbs4;
            }
            if (left2 < 0 && (left = d0Var3.itemView.getLeft() - i) > 0 && d0Var3.itemView.getLeft() < view.getLeft() && (iAbs3 = Math.abs(left)) > i3) {
                d0Var2 = d0Var3;
                i3 = iAbs3;
            }
            if (top2 < 0 && (top = d0Var3.itemView.getTop() - i2) > 0 && d0Var3.itemView.getTop() < view.getTop() && (iAbs2 = Math.abs(top)) > i3) {
                d0Var2 = d0Var3;
                i3 = iAbs2;
            }
            if (top2 > 0 && (bottom = d0Var3.itemView.getBottom() - height) < 0 && d0Var3.itemView.getBottom() > view.getBottom() && (iAbs = Math.abs(bottom)) > i3) {
                d0Var2 = d0Var3;
                i3 = iAbs;
            }
        }
        return d0Var2;
    }

    public int convertToAbsoluteDirection(int i, int i2) {
        int i3;
        int i4 = i & RELATIVE_DIR_FLAGS;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 >> 2;
        } else {
            int i6 = i4 >> 1;
            i5 |= (-3158065) & i6;
            i3 = (i6 & RELATIVE_DIR_FLAGS) >> 2;
        }
        return i5 | i3;
    }

    public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        int movementFlags = getMovementFlags(recyclerView, d0Var);
        WeakHashMap weakHashMap = qd1.a;
        return convertToAbsoluteDirection(movementFlags, recyclerView.getLayoutDirection());
    }

    public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
        k kVar = recyclerView.mItemAnimator;
        if (kVar == null) {
            return i == 8 ? 200L : 250L;
        }
        return i == 8 ? kVar.e : kVar.d;
    }

    public int getBoundingBoxMargin() {
        return 0;
    }

    public float getMoveThreshold(RecyclerView.d0 d0Var) {
        return 0.5f;
    }

    public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.d0 d0Var);

    public float getSwipeVelocityThreshold(float f) {
        return f;
    }

    public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        return (getAbsoluteMovementFlags(recyclerView, d0Var) & 16711680) != 0;
    }

    public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        return (getAbsoluteMovementFlags(recyclerView, d0Var) & 65280) != 0;
    }

    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
        if (this.mCachedMaxScrollSpeed == -1) {
            this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.dw);
        }
        int interpolation = (int) (sDragScrollInterpolator.getInterpolation(j <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS ? j / 2000.0f : 1.0f) * ((int) (sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)) * ((int) Math.signum(i2)) * this.mCachedMaxScrollSpeed)));
        if (interpolation == 0) {
            return i2 > 0 ? 1 : -1;
        }
        return interpolation;
    }

    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i, boolean z) {
        View view = d0Var.itemView;
        if (z && view.getTag(R.attr.o_) == null) {
            WeakHashMap weakHashMap = qd1.a;
            Float fValueOf = Float.valueOf(view.getElevation());
            int childCount = recyclerView.getChildCount();
            float f3 = 0.0f;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (childAt != view) {
                    WeakHashMap weakHashMap2 = qd1.a;
                    float elevation = childAt.getElevation();
                    if (elevation > f3) {
                        f3 = elevation;
                    }
                }
            }
            view.setElevation(f3 + 1.0f);
            view.setTag(R.attr.o_, fValueOf);
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i, boolean z) {
        View view = d0Var.itemView;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<o> list, int i, float f, float f2) {
        if (list.size() > 0) {
            list.get(0).getClass();
            throw null;
        }
        if (d0Var != null) {
            int iSave = canvas.save();
            onChildDraw(canvas, recyclerView, d0Var, f, f2, i, true);
            canvas.restoreToCount(iSave);
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<o> list, int i, float f, float f2) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            o oVar = list.get(i2);
            int iSave = canvas.save();
            oVar.getClass();
            onChildDrawOver(canvas, recyclerView, null, 0.0f, 0.0f, 0, false);
            canvas.restoreToCount(iSave);
        }
        if (d0Var != null) {
            int iSave2 = canvas.save();
            onChildDrawOver(canvas, recyclerView, d0Var, f, f2, i, true);
            canvas.restoreToCount(iSave2);
        }
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            list.get(size).getClass();
            list.remove(size);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMoved(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i, RecyclerView.d0 d0Var2, int i2, int i3, int i4) {
        int iE;
        RecyclerView.o oVar = recyclerView.mLayout;
        if (!(oVar instanceof a40)) {
            if (oVar.canScrollHorizontally()) {
                if (RecyclerView.o.getDecoratedLeft(d0Var2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (RecyclerView.o.getDecoratedRight(d0Var2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (oVar.canScrollVertically()) {
                if (RecyclerView.o.getDecoratedTop(d0Var2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (RecyclerView.o.getDecoratedBottom(d0Var2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                    return;
                }
                return;
            }
            return;
        }
        View view = d0Var.itemView;
        View view2 = d0Var2.itemView;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) ((a40) oVar);
        linearLayoutManager.assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        linearLayoutManager.ensureLayoutState();
        linearLayoutManager.resolveShouldLayoutReverse();
        int position = RecyclerView.o.getPosition(view);
        int position2 = RecyclerView.o.getPosition(view2);
        byte b2 = position < position2 ? (byte) 1 : (byte) -1;
        boolean z = linearLayoutManager.mShouldReverseLayout;
        u uVar = linearLayoutManager.mOrientationHelper;
        if (z) {
            if (b2 == 1) {
                int iG = uVar.g() - (linearLayoutManager.mOrientationHelper.c(view) + linearLayoutManager.mOrientationHelper.e(view2));
                linearLayoutManager.mPendingScrollPosition = position2;
                linearLayoutManager.mPendingScrollPositionOffset = iG;
                LinearLayoutManager.d dVar = linearLayoutManager.mPendingSavedState;
                if (dVar != null) {
                    dVar.b = -1;
                }
                linearLayoutManager.requestLayout();
                return;
            }
            iE = uVar.g() - linearLayoutManager.mOrientationHelper.b(view2);
        } else {
            if (b2 != -1) {
                int iB = uVar.b(view2) - linearLayoutManager.mOrientationHelper.c(view);
                linearLayoutManager.mPendingScrollPosition = position2;
                linearLayoutManager.mPendingScrollPositionOffset = iB;
                LinearLayoutManager.d dVar2 = linearLayoutManager.mPendingSavedState;
                if (dVar2 != null) {
                    dVar2.b = -1;
                }
                linearLayoutManager.requestLayout();
                return;
            }
            iE = uVar.e(view2);
        }
        linearLayoutManager.mPendingScrollPosition = position2;
        linearLayoutManager.mPendingScrollPositionOffset = iE;
        LinearLayoutManager.d dVar3 = linearLayoutManager.mPendingSavedState;
        if (dVar3 != null) {
            dVar3.b = -1;
        }
        linearLayoutManager.requestLayout();
    }
}
