package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import defpackage.b2;
import defpackage.fg1;
import defpackage.lm0;
import defpackage.qd1;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class ViewUtils {

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public interface OnApplyWindowInsetsListener {
        fg1 onApplyWindowInsets(View view, fg1 fg1Var, RelativePadding relativePadding);
    }

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int i, int i2, int i3, int i4) {
            this.start = i;
            this.top = i2;
            this.end = i3;
            this.bottom = i4;
        }

        public RelativePadding(RelativePadding relativePadding) {
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }
    }

    private ViewUtils() {
    }

    public static void doOnApplyWindowInsets(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        WeakHashMap weakHashMap = qd1.a;
        final RelativePadding relativePadding = new RelativePadding(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
        b2.u(view, new lm0() { // from class: com.google.android.material.internal.ViewUtils.3
            @Override // defpackage.lm0
            public final fg1 onApplyWindowInsets(View view2, fg1 fg1Var) {
                return onApplyWindowInsetsListener.onApplyWindowInsets(view2, fg1Var, new RelativePadding(relativePadding));
            }
        });
        if (view.isAttachedToWindow()) {
            view.requestApplyInsets();
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.internal.ViewUtils.4
                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View view2) {
                    view2.removeOnAttachStateChangeListener(this);
                    WeakHashMap weakHashMap2 = qd1.a;
                    view2.requestApplyInsets();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View view2) {
                }
            });
        }
    }

    public static void doOnApplyWindowInsets(BottomAppBar bottomAppBar, AttributeSet attributeSet, int i, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        TypedArray typedArrayObtainStyledAttributes = bottomAppBar.getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i, org.hamotunnelplus.xyz.R.plurals.a0p);
        final boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        final boolean z2 = typedArrayObtainStyledAttributes.getBoolean(1, false);
        final boolean z3 = typedArrayObtainStyledAttributes.getBoolean(2, false);
        typedArrayObtainStyledAttributes.recycle();
        doOnApplyWindowInsets(bottomAppBar, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ViewUtils.2
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public final fg1 onApplyWindowInsets(View view, fg1 fg1Var, RelativePadding relativePadding) {
                if (z) {
                    relativePadding.bottom = fg1Var.a() + relativePadding.bottom;
                }
                boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(view);
                if (z2) {
                    if (zIsLayoutRtl) {
                        relativePadding.end = fg1Var.b() + relativePadding.end;
                    } else {
                        relativePadding.start = fg1Var.b() + relativePadding.start;
                    }
                }
                if (z3) {
                    if (zIsLayoutRtl) {
                        relativePadding.start = fg1Var.c() + relativePadding.start;
                    } else {
                        relativePadding.end = fg1Var.c() + relativePadding.end;
                    }
                }
                int i2 = relativePadding.start;
                int i3 = relativePadding.top;
                int i4 = relativePadding.end;
                int i5 = relativePadding.bottom;
                WeakHashMap weakHashMap = qd1.a;
                view.setPaddingRelative(i2, i3, i4, i5);
                OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = onApplyWindowInsetsListener;
                return onApplyWindowInsetsListener2 != null ? onApplyWindowInsetsListener2.onApplyWindowInsets(view, fg1Var, relativePadding) : fg1Var;
            }
        });
    }

    public static float dpToPx(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static ViewGroup getContentView(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static ViewOverlayImpl getOverlay(View view) {
        if (view == null) {
            return null;
        }
        return new ViewOverlayApi18(view);
    }

    public static boolean isLayoutRtl(View view) {
        WeakHashMap weakHashMap = qd1.a;
        return view.getLayoutDirection() == 1;
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void requestFocusAndShowKeyboard(final View view) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.ViewUtils.1
            @Override // java.lang.Runnable
            public final void run() {
                View view2 = view;
                ((InputMethodManager) view2.getContext().getSystemService("input_method")).showSoftInput(view2, 1);
            }
        });
    }
}
