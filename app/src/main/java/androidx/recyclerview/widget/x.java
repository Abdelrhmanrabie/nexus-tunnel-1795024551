package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.a1;
import defpackage.o1;
import defpackage.qz;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class x extends a1 {
    public final a mItemDelegate;
    public final RecyclerView mRecyclerView;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class a extends a1 {
        public final x a;
        public final WeakHashMap b = new WeakHashMap();

        public a(x xVar) {
            this.a = xVar;
        }

        @Override // defpackage.a1
        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            a1 a1Var = (a1) this.b.get(view);
            return a1Var != null ? a1Var.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // defpackage.a1
        public final qz getAccessibilityNodeProvider(View view) {
            a1 a1Var = (a1) this.b.get(view);
            return a1Var != null ? a1Var.getAccessibilityNodeProvider(view) : super.getAccessibilityNodeProvider(view);
        }

        @Override // defpackage.a1
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            a1 a1Var = (a1) this.b.get(view);
            if (a1Var != null) {
                a1Var.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // defpackage.a1
        public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
            RecyclerView.o oVar;
            x xVar = this.a;
            if (!xVar.mRecyclerView.hasPendingAdapterUpdates() && (oVar = xVar.mRecyclerView.mLayout) != null) {
                oVar.onInitializeAccessibilityNodeInfoForItem(view, o1Var);
                a1 a1Var = (a1) this.b.get(view);
                if (a1Var != null) {
                    a1Var.onInitializeAccessibilityNodeInfo(view, o1Var);
                    return;
                }
            }
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, o1Var.a);
        }

        @Override // defpackage.a1
        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            a1 a1Var = (a1) this.b.get(view);
            if (a1Var != null) {
                a1Var.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // defpackage.a1
        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            a1 a1Var = (a1) this.b.get(viewGroup);
            return a1Var != null ? a1Var.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // defpackage.a1
        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.a.mRecyclerView;
            if (recyclerView.hasPendingAdapterUpdates() || recyclerView.mLayout == null) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            a1 a1Var = (a1) this.b.get(view);
            if (a1Var != null) {
                if (a1Var.performAccessibilityAction(view, i, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            RecyclerView.v vVar = recyclerView.mLayout.mRecyclerView.mRecycler;
            return false;
        }

        @Override // defpackage.a1
        public final void sendAccessibilityEvent(View view, int i) {
            a1 a1Var = (a1) this.b.get(view);
            if (a1Var != null) {
                a1Var.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        }

        @Override // defpackage.a1
        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            a1 a1Var = (a1) this.b.get(view);
            if (a1Var != null) {
                a1Var.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public x(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        a1 itemDelegate = getItemDelegate();
        this.mItemDelegate = (itemDelegate == null || !(itemDelegate instanceof a)) ? new a(this) : (a) itemDelegate;
    }

    public a1 getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // defpackage.a1
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        RecyclerView.o oVar;
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.mRecyclerView.hasPendingAdapterUpdates() || (oVar = ((RecyclerView) view).mLayout) == null) {
            return;
        }
        oVar.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // defpackage.a1
    public void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
        RecyclerView.o oVar;
        AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView.hasPendingAdapterUpdates() || (oVar = recyclerView.mLayout) == null) {
            return;
        }
        RecyclerView recyclerView2 = oVar.mRecyclerView;
        RecyclerView.v vVar = recyclerView2.mRecycler;
        RecyclerView.a0 a0Var = recyclerView2.mState;
        if (recyclerView2.canScrollVertically(-1) || oVar.mRecyclerView.canScrollHorizontally(-1)) {
            o1Var.a(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
            accessibilityNodeInfo.setScrollable(true);
        }
        if (oVar.mRecyclerView.canScrollVertically(1) || oVar.mRecyclerView.canScrollHorizontally(1)) {
            o1Var.a(4096);
            accessibilityNodeInfo.setScrollable(true);
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) qz.a(oVar.getRowCountForAccessibility(vVar, a0Var), oVar.getColumnCountForAccessibility(vVar, a0Var), 0).a);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007a A[PHI: r0
      0x007a: PHI (r0v7 int) = (r0v3 int), (r0v11 int) binds: [B:26:0x006b, B:19:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.a1
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        RecyclerView.o oVar;
        int paddingTop;
        int paddingLeft;
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (!recyclerView.hasPendingAdapterUpdates() && (oVar = recyclerView.mLayout) != null) {
            RecyclerView recyclerView2 = oVar.mRecyclerView;
            RecyclerView.v vVar = recyclerView2.mRecycler;
            if (i == 4096) {
                paddingTop = recyclerView2.canScrollVertically(1) ? (oVar.mHeight - oVar.getPaddingTop()) - oVar.getPaddingBottom() : 0;
                if (oVar.mRecyclerView.canScrollHorizontally(1)) {
                    paddingLeft = (oVar.mWidth - oVar.getPaddingLeft()) - oVar.getPaddingRight();
                } else {
                    paddingLeft = 0;
                }
            } else if (i != 8192) {
                paddingLeft = 0;
                paddingTop = 0;
            } else {
                paddingTop = recyclerView2.canScrollVertically(-1) ? -((oVar.mHeight - oVar.getPaddingTop()) - oVar.getPaddingBottom()) : 0;
                if (oVar.mRecyclerView.canScrollHorizontally(-1)) {
                    paddingLeft = -((oVar.mWidth - oVar.getPaddingLeft()) - oVar.getPaddingRight());
                } else {
                    paddingLeft = 0;
                }
            }
            if (paddingTop != 0 || paddingLeft != 0) {
                oVar.mRecyclerView.smoothScrollBy(paddingLeft, paddingTop, true);
                return true;
            }
        }
        return false;
    }
}
