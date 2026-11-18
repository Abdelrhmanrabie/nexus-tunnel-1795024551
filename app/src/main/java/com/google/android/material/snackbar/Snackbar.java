package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.d;
import net.lingala.zip4j.util.InternalZipConstants;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] SNACKBAR_CONTENT_STYLE_ATTRS = {R.style.a0n, R.style.a0p};
    public final AccessibilityManager accessibilityManager;

    /* JADX INFO: renamed from: com.google.android.material.snackbar.Snackbar$1, reason: invalid class name */
    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener val$listener;

        public AnonymousClass1(View.OnClickListener onClickListener) {
            this.val$listener = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.val$listener.onClick(view);
            Snackbar.this.dispatchDismiss(1);
        }
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }

    private Snackbar(Context context, ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        super(context, viewGroup, view, contentViewCallback);
        this.accessibilityManager = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static Snackbar make(View view, String str) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        while (true) {
            if (!(view instanceof CoordinatorLayout)) {
                if (view instanceof FrameLayout) {
                    if (view.getId() != 16908290) {
                        viewGroup2 = (ViewGroup) view;
                    }
                }
                if (view != null) {
                    Object parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                }
                if (view == null) {
                    viewGroup = viewGroup2;
                    break;
                }
            }
            viewGroup = (ViewGroup) view;
            break;
        }
        if (viewGroup == null) {
            d.AnonymousClass0.m$2("No suitable parent found from the given view. Please provide a valid view.");
            return null;
        }
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) layoutInflaterFrom.inflate((resourceId == -1 || resourceId2 == -1) ? R.layout.be : R.layout.do_res_0x7f0d00a2, viewGroup, false);
        Snackbar snackbar = new Snackbar(context, viewGroup, snackbarContentLayout, snackbarContentLayout);
        ((SnackbarContentLayout) snackbar.view.getChildAt(0)).messageView.setText(str);
        snackbar.duration = InternalZipConstants.AES_HASH_ITERATIONS;
        return snackbar;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public final void dismiss() {
        dispatchDismiss(3);
    }

    public final void show() {
        SnackbarManager snackbarManager = SnackbarManager.getInstance();
        int recommendedTimeoutMillis = this.duration;
        if (recommendedTimeoutMillis == -2) {
            recommendedTimeoutMillis = -2;
        } else if (Build.VERSION.SDK_INT >= 29) {
            recommendedTimeoutMillis = this.accessibilityManager.getRecommendedTimeoutMillis(recommendedTimeoutMillis, 3);
        }
        BaseTransientBottomBar.AnonymousClass5 anonymousClass5 = this.managerCallback;
        synchronized (snackbarManager.lock) {
            try {
                if (snackbarManager.isCurrentSnackbarLocked(anonymousClass5)) {
                    SnackbarManager.SnackbarRecord snackbarRecord = snackbarManager.currentSnackbar;
                    snackbarRecord.duration = recommendedTimeoutMillis;
                    snackbarManager.handler.removeCallbacksAndMessages(snackbarRecord);
                    snackbarManager.scheduleTimeoutLocked(snackbarManager.currentSnackbar);
                } else {
                    SnackbarManager.SnackbarRecord snackbarRecord2 = snackbarManager.nextSnackbar;
                    if (snackbarRecord2 == null || anonymousClass5 == null || snackbarRecord2.callback.get() != anonymousClass5) {
                        snackbarManager.nextSnackbar = new SnackbarManager.SnackbarRecord(recommendedTimeoutMillis, anonymousClass5);
                    } else {
                        snackbarManager.nextSnackbar.duration = recommendedTimeoutMillis;
                    }
                    SnackbarManager.SnackbarRecord snackbarRecord3 = snackbarManager.currentSnackbar;
                    if (snackbarRecord3 == null || !snackbarManager.cancelSnackbarLocked(snackbarRecord3, 4)) {
                        snackbarManager.currentSnackbar = null;
                        SnackbarManager.SnackbarRecord snackbarRecord4 = snackbarManager.nextSnackbar;
                        if (snackbarRecord4 != null) {
                            snackbarManager.currentSnackbar = snackbarRecord4;
                            snackbarManager.nextSnackbar = null;
                            SnackbarManager.Callback callback = (SnackbarManager.Callback) snackbarRecord4.callback.get();
                            if (callback != null) {
                                callback.show();
                            } else {
                                snackbarManager.currentSnackbar = null;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
