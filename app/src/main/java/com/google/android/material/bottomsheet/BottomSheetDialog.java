package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.appcompat.app.f;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.trilead.ssh2.sftp.AttribFlags;
import defpackage.a1;
import defpackage.b2;
import defpackage.d;
import defpackage.fg1;
import defpackage.je;
import defpackage.lm0;
import defpackage.o1;
import defpackage.qd1;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.hamotunnelplus.xyz.R;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class BottomSheetDialog extends f {
    public static final /* synthetic */ int $r8$clinit = 0;
    public BottomSheetBehavior behavior;
    public FrameLayout bottomSheet;
    public final BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    public boolean cancelable;
    public boolean canceledOnTouchOutside;
    public boolean canceledOnTouchOutsideSet;
    public FrameLayout container;
    public CoordinatorLayout coordinator;
    public BottomSheetBehavior.BottomSheetCallback edgeToEdgeCallback;
    public final boolean edgeToEdgeEnabled;

    /* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
    public static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {
        public final fg1 insetsCompat;
        public final boolean lightBottomSheet;
        public final boolean lightStatusBar;

        private EdgeToEdgeCallback(View view, fg1 fg1Var) {
            ColorStateList backgroundTintList;
            int color;
            boolean z;
            boolean z2;
            this.insetsCompat = fg1Var;
            boolean z3 = (view.getSystemUiVisibility() & AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) != 0;
            this.lightStatusBar = z3;
            MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.from(view).materialShapeDrawable;
            if (materialShapeDrawable != null) {
                backgroundTintList = materialShapeDrawable.getFillColor();
            } else {
                WeakHashMap weakHashMap = qd1.a;
                backgroundTintList = view.getBackgroundTintList();
            }
            if (backgroundTintList != null) {
                color = backgroundTintList.getDefaultColor();
            } else {
                if (!(view.getBackground() instanceof ColorDrawable)) {
                    this.lightBottomSheet = z3;
                    return;
                }
                color = ((ColorDrawable) view.getBackground()).getColor();
            }
            if (color != 0) {
                ThreadLocal threadLocal = je.a;
                double[] dArr = (double[]) threadLocal.get();
                if (dArr == null) {
                    dArr = new double[3];
                    threadLocal.set(dArr);
                }
                int iRed = Color.red(color);
                int iGreen = Color.green(color);
                int iBlue = Color.blue(color);
                if (dArr.length != 3) {
                    d.AnonymousClass0.m$2("outXyz must have a length of 3.");
                    throw null;
                }
                double d = ((double) iRed) / 255.0d;
                double dPow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
                double d2 = ((double) iGreen) / 255.0d;
                double dPow2 = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
                z = false;
                double d3 = ((double) iBlue) / 255.0d;
                double dPow3 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
                dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
                double d4 = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
                dArr[1] = d4;
                dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
                z2 = d4 / 100.0d > 0.5d ? true : z2;
                this.lightBottomSheet = z2;
            }
            z = false;
            z2 = z;
            this.lightBottomSheet = z2;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View view) {
            setPaddingForPosition(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View view, int i) {
            setPaddingForPosition(view);
        }

        public final void setPaddingForPosition(View view) {
            int top = view.getTop();
            fg1 fg1Var = this.insetsCompat;
            if (top < fg1Var.d()) {
                int i = BottomSheetDialog.$r8$clinit;
                int systemUiVisibility = view.getSystemUiVisibility();
                view.setSystemUiVisibility(this.lightBottomSheet ? systemUiVisibility | AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT : systemUiVisibility & (-8193));
                view.setPadding(view.getPaddingLeft(), fg1Var.d() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                int i2 = BottomSheetDialog.$r8$clinit;
                int systemUiVisibility2 = view.getSystemUiVisibility();
                view.setSystemUiVisibility(this.lightStatusBar ? systemUiVisibility2 | AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT : systemUiVisibility2 & (-8193));
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }
    }

    public BottomSheetDialog(Context context) {
        this(context, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.style.kh}).getBoolean(0, false);
    }

    public BottomSheetDialog(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            i = context.getTheme().resolveAttribute(R.style.cq, typedValue, true) ? typedValue.resourceId : R.plurals.pm;
        }
        super(context, i);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.5
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View view) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View view, int i2) {
                if (i2 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        getDelegate().t(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.style.kh}).getBoolean(0, false);
    }

    public BottomSheetDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.5
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View view) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View view, int i2) {
                if (i2 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        getDelegate().t(1);
        this.cancelable = z;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.style.kh}).getBoolean(0, false);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        super.cancel();
    }

    public final void ensureContainerAndBehavior() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.bc, null);
            this.container = frameLayout;
            this.coordinator = (CoordinatorLayout) frameLayout.findViewById(R.attr.g2);
            FrameLayout frameLayout2 = (FrameLayout) this.container.findViewById(R.attr.i1);
            this.bottomSheet = frameLayout2;
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout2);
            this.behavior = bottomSheetBehaviorFrom;
            ArrayList arrayList = bottomSheetBehaviorFrom.callbacks;
            BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = this.bottomSheetCallback;
            if (!arrayList.contains(bottomSheetCallback)) {
                arrayList.add(bottomSheetCallback);
            }
            this.behavior.setHideable(this.cancelable);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z = this.edgeToEdgeEnabled && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z);
            }
            CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z);
            }
            if (z) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    @Override // androidx.appcompat.app.f, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior == null || bottomSheetBehavior.state != 5) {
            return;
        }
        bottomSheetBehavior.setState(4);
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.cancelable != z) {
            this.cancelable = z;
            BottomSheetBehavior bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z);
            }
        }
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z;
        this.canceledOnTouchOutsideSet = true;
    }

    @Override // androidx.appcompat.app.f, android.app.Dialog
    public final void setContentView(int i) {
        super.setContentView(wrapInBottomSheet(null, i, null));
    }

    @Override // androidx.appcompat.app.f, android.app.Dialog
    public final void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(view, 0, null));
    }

    @Override // androidx.appcompat.app.f, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(view, 0, layoutParams));
    }

    public final FrameLayout wrapInBottomSheet(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(R.attr.g2);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            FrameLayout frameLayout = this.bottomSheet;
            lm0 lm0Var = new lm0() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.1
                @Override // defpackage.lm0
                public final fg1 onApplyWindowInsets(View view2, fg1 fg1Var) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = bottomSheetDialog.edgeToEdgeCallback;
                    if (bottomSheetCallback != null) {
                        bottomSheetDialog.behavior.callbacks.remove(bottomSheetCallback);
                    }
                    EdgeToEdgeCallback edgeToEdgeCallback = new EdgeToEdgeCallback(bottomSheetDialog.bottomSheet, fg1Var);
                    bottomSheetDialog.edgeToEdgeCallback = edgeToEdgeCallback;
                    ArrayList arrayList = bottomSheetDialog.behavior.callbacks;
                    if (!arrayList.contains(edgeToEdgeCallback)) {
                        arrayList.add(edgeToEdgeCallback);
                    }
                    return fg1Var;
                }
            };
            WeakHashMap weakHashMap = qd1.a;
            b2.u(frameLayout, lm0Var);
        }
        this.bottomSheet.removeAllViews();
        FrameLayout frameLayout2 = this.bottomSheet;
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.attr.a1x).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.cancelable && bottomSheetDialog.isShowing()) {
                    if (!bottomSheetDialog.canceledOnTouchOutsideSet) {
                        TypedArray typedArrayObtainStyledAttributes = bottomSheetDialog.getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
                        bottomSheetDialog.canceledOnTouchOutside = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                        bottomSheetDialog.canceledOnTouchOutsideSet = true;
                    }
                    if (bottomSheetDialog.canceledOnTouchOutside) {
                        bottomSheetDialog.cancel();
                    }
                }
            }
        });
        qd1.l(this.bottomSheet, new a1() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.3
            @Override // defpackage.a1
            public final void onInitializeAccessibilityNodeInfo(View view2, o1 o1Var) {
                boolean z;
                AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
                this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                if (BottomSheetDialog.this.cancelable) {
                    o1Var.a(1048576);
                    z = true;
                } else {
                    z = false;
                }
                accessibilityNodeInfo.setDismissable(z);
            }

            @Override // defpackage.a1
            public final boolean performAccessibilityAction(View view2, int i2, Bundle bundle) {
                if (i2 == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.cancelable) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view2, i2, bundle);
            }
        });
        this.bottomSheet.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.container;
    }
}
