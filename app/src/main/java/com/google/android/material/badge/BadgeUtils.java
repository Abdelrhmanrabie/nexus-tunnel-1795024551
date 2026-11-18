package com.google.android.material.badge;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BadgeUtils {

    /* JADX INFO: renamed from: com.google.android.material.badge.BadgeUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ BadgeDrawable val$badgeDrawable;
        public final /* synthetic */ FrameLayout val$customBadgeParent;
        public final /* synthetic */ int val$menuItemId;
        public final /* synthetic */ Toolbar val$toolbar;

        public AnonymousClass1(Toolbar toolbar, int i, BadgeDrawable badgeDrawable, FrameLayout frameLayout) {
            this.val$toolbar = toolbar;
            this.val$menuItemId = i;
            this.val$badgeDrawable = badgeDrawable;
            this.val$customBadgeParent = frameLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toolbar toolbar;
            ActionMenuView actionMenuView;
            ActionMenuItemView actionMenuItemView;
            int i = 0;
            int i2 = 0;
            while (true) {
                toolbar = this.val$toolbar;
                if (i2 >= toolbar.getChildCount()) {
                    actionMenuView = null;
                    break;
                }
                View childAt = toolbar.getChildAt(i2);
                if (childAt instanceof ActionMenuView) {
                    actionMenuView = (ActionMenuView) childAt;
                    break;
                }
                i2++;
            }
            if (actionMenuView == null) {
                actionMenuItemView = null;
                break;
            }
            while (true) {
                if (i >= actionMenuView.getChildCount()) {
                    actionMenuItemView = null;
                    break;
                }
                View childAt2 = actionMenuView.getChildAt(i);
                if (childAt2 instanceof ActionMenuItemView) {
                    actionMenuItemView = (ActionMenuItemView) childAt2;
                    if (actionMenuItemView.b.a == this.val$menuItemId) {
                        break;
                    }
                }
                i++;
            }
            if (actionMenuItemView != null) {
                Resources resources = toolbar.getResources();
                int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.jj);
                BadgeDrawable badgeDrawable = this.val$badgeDrawable;
                badgeDrawable.savedState.additionalHorizontalOffset = dimensionPixelOffset;
                badgeDrawable.updateCenterAndBounds();
                badgeDrawable.savedState.additionalVerticalOffset = resources.getDimensionPixelOffset(R.dimen.jk);
                badgeDrawable.updateCenterAndBounds();
                Rect rect = new Rect();
                actionMenuItemView.getDrawingRect(rect);
                badgeDrawable.setBounds(rect);
                badgeDrawable.updateBadgeCoordinates(actionMenuItemView, this.val$customBadgeParent);
                WeakReference weakReference = badgeDrawable.customBadgeParentRef;
                if ((weakReference != null ? (FrameLayout) weakReference.get() : null) == null) {
                    actionMenuItemView.getOverlay().add(badgeDrawable);
                } else {
                    WeakReference weakReference2 = badgeDrawable.customBadgeParentRef;
                    (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(badgeDrawable);
                }
            }
        }
    }

    private BadgeUtils() {
    }
}
