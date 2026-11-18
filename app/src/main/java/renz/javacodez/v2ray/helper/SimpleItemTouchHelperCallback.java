package renz.javacodez.v2ray.helper;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;
import defpackage.qd1;
import defpackage.rc;
import defpackage.zk;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleItemTouchHelperCallback extends n {
    private static final float ALPHA_FULL = 1.0f;
    private static final long ANIMATION_DURATION = 200;
    public static final Companion Companion = new Companion(null);
    private static final float SWIPE_THRESHOLD = 0.25f;
    private final ItemTouchHelperAdapter mAdapter;
    private ValueAnimator mReturnAnimator;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(zk zkVar) {
            this();
        }
    }

    public SimpleItemTouchHelperCallback(ItemTouchHelperAdapter itemTouchHelperAdapter) {
        this.mAdapter = itemTouchHelperAdapter;
    }

    private final void returnViewToOriginalPosition(RecyclerView.d0 d0Var) {
        ValueAnimator valueAnimator = this.mReturnAnimator;
        if (valueAnimator != null) {
            if (!valueAnimator.isRunning()) {
                valueAnimator = null;
            }
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(d0Var.itemView.getTranslationX(), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new rc(3, d0Var));
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.setDuration(ANIMATION_DURATION);
        valueAnimatorOfFloat.start();
        this.mReturnAnimator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void returnViewToOriginalPosition$lambda$2$lambda$1(RecyclerView.d0 d0Var, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        d0Var.itemView.setTranslationX(fFloatValue);
        View view = d0Var.itemView;
        view.setAlpha(ALPHA_FULL - (Math.abs(fFloatValue) / (view.getWidth() * SWIPE_THRESHOLD)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void clearView(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        View view = d0Var.itemView;
        Object tag = view.getTag(R.attr.o_);
        if (tag instanceof Float) {
            float fFloatValue = ((Float) tag).floatValue();
            WeakHashMap weakHashMap = qd1.a;
            view.setElevation(fFloatValue);
        }
        view.setTag(R.attr.o_, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        d0Var.itemView.setAlpha(ALPHA_FULL);
        if (d0Var instanceof ItemTouchHelperViewHolder) {
            ((ItemTouchHelperViewHolder) d0Var).onItemClear();
        }
        this.mAdapter.onItemMoveCompleted();
    }

    @Override // androidx.recyclerview.widget.n
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        return n.makeMovementFlags(recyclerView.mLayout instanceof GridLayoutManager ? 15 : 3, 48);
    }

    public float getSwipeEscapeVelocity(float f) {
        return f * 10;
    }

    public float getSwipeThreshold(RecyclerView.d0 d0Var) {
        return 1.1f;
    }

    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.n
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i, boolean z) {
        if (i != 1) {
            super.onChildDraw(canvas, recyclerView, d0Var, f, f2, i, z);
            return;
        }
        View view = d0Var.itemView;
        float width = view.getWidth() * SWIPE_THRESHOLD;
        float fAbs = Math.abs(f);
        float fMin = Math.min(fAbs, width) * Math.signum(f);
        float fMin2 = ALPHA_FULL - (Math.min(fAbs, width) / width);
        view.setTranslationX(fMin);
        view.setAlpha(fMin2);
        if (fAbs < width || !z) {
            return;
        }
        returnViewToOriginalPosition(d0Var);
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        int adapterPositionInRecyclerView;
        RecyclerView recyclerView2;
        RecyclerView.g gVar;
        int adapterPositionInRecyclerView2;
        RecyclerView recyclerView3;
        RecyclerView.g gVar2;
        if (d0Var.mItemViewType != d0Var2.mItemViewType) {
            return false;
        }
        ItemTouchHelperAdapter itemTouchHelperAdapter = this.mAdapter;
        int i = -1;
        if (d0Var.mBindingAdapter == null || (recyclerView3 = d0Var.mOwnerRecyclerView) == null || (gVar2 = recyclerView3.mAdapter) == null || (adapterPositionInRecyclerView = recyclerView3.getAdapterPositionInRecyclerView(d0Var)) == -1 || d0Var.mBindingAdapter != gVar2) {
            adapterPositionInRecyclerView = -1;
        }
        if (d0Var2.mBindingAdapter != null && (recyclerView2 = d0Var2.mOwnerRecyclerView) != null && (gVar = recyclerView2.mAdapter) != null && (adapterPositionInRecyclerView2 = recyclerView2.getAdapterPositionInRecyclerView(d0Var2)) != -1 && d0Var2.mBindingAdapter == gVar) {
            i = adapterPositionInRecyclerView2;
        }
        itemTouchHelperAdapter.onItemMove(adapterPositionInRecyclerView, i);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSelectedChanged(RecyclerView.d0 d0Var, int i) {
        if (i == 0 || !(d0Var instanceof ItemTouchHelperViewHolder)) {
            return;
        }
        ((ItemTouchHelperViewHolder) d0Var).onItemSelected();
    }

    public void onSwiped(RecyclerView.d0 d0Var, int i) {
        returnViewToOriginalPosition(d0Var);
    }
}
