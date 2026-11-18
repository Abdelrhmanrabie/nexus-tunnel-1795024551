package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.b;
import defpackage.a1;
import defpackage.b2;
import defpackage.o1;
import defpackage.qd1;
import defpackage.sv0;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: https://t.me/SaltSoupGarage */
/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements k.a {
    public static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public final a1 accessibilityDelegate;
    public FrameLayout actionArea;
    public boolean checkable;
    public Drawable emptyDrawable;
    public boolean hasIconTintList;
    public int iconSize;
    public ColorStateList iconTintList;
    public h itemData;
    public boolean needsEmptyIcon;
    public final CheckedTextView textView;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a1 a1Var = new a1() { // from class: com.google.android.material.internal.NavigationMenuItemView.1
            @Override // defpackage.a1
            public final void onInitializeAccessibilityNodeInfo(View view, o1 o1Var) {
                AccessibilityNodeInfo accessibilityNodeInfo = o1Var.a;
                this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCheckable(NavigationMenuItemView.this.checkable);
            }
        };
        this.accessibilityDelegate = a1Var;
        if (this.mOrientation != 0) {
            this.mOrientation = 0;
            requestLayout();
        }
        LayoutInflater.from(context).inflate(org.hamotunnelplus.xyz.R.layout.bn, (ViewGroup) this, true);
        this.iconSize = context.getResources().getDimensionPixelSize(org.hamotunnelplus.xyz.R.dimen.cr);
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(org.hamotunnelplus.xyz.R.attr.i4);
        this.textView = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        qd1.l(checkedTextView, a1Var);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final h getItemData() {
        return this.itemData;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final void initialize(h hVar) {
        b.a aVar;
        int i;
        StateListDrawable stateListDrawable;
        this.itemData = hVar;
        int i2 = hVar.a;
        if (i2 > 0) {
            setId(i2);
        }
        setVisibility(hVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(org.hamotunnelplus.xyz.R.style.g5, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = qd1.a;
            setBackground(stateListDrawable);
        }
        boolean zIsCheckable = hVar.isCheckable();
        refreshDrawableState();
        boolean z = this.checkable;
        CheckedTextView checkedTextView = this.textView;
        if (z != zIsCheckable) {
            this.checkable = zIsCheckable;
            this.accessibilityDelegate.sendAccessibilityEvent(checkedTextView, 2048);
        }
        boolean zIsChecked = hVar.isChecked();
        refreshDrawableState();
        checkedTextView.setChecked(zIsChecked);
        setEnabled(hVar.isEnabled());
        checkedTextView.setText(hVar.e);
        setIcon(hVar.getIcon());
        View actionView = hVar.getActionView();
        if (actionView != null) {
            if (this.actionArea == null) {
                this.actionArea = (FrameLayout) ((ViewStub) findViewById(org.hamotunnelplus.xyz.R.attr.i3)).inflate();
            }
            this.actionArea.removeAllViews();
            this.actionArea.addView(actionView);
        }
        setContentDescription(hVar.q);
        b2.a(hVar.r, this);
        h hVar2 = this.itemData;
        if (hVar2.e == null && hVar2.getIcon() == null && this.itemData.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.actionArea;
            if (frameLayout == null) {
                return;
            }
            aVar = (b.a) frameLayout.getLayoutParams();
            i = -1;
        } else {
            checkedTextView.setVisibility(0);
            FrameLayout frameLayout2 = this.actionArea;
            if (frameLayout2 == null) {
                return;
            }
            aVar = (b.a) frameLayout2.getLayoutParams();
            i = -2;
        }
        ((LinearLayout.LayoutParams) aVar).width = i;
        this.actionArea.setLayoutParams(aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        h hVar = this.itemData;
        if (hVar != null && hVar.isCheckable() && this.itemData.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    public final void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.hasIconTintList) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.iconTintList);
            }
            int i = this.iconSize;
            drawable.setBounds(0, 0, i, i);
        } else if (this.needsEmptyIcon) {
            if (this.emptyDrawable == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = sv0.a;
                Drawable drawable2 = resources.getDrawable(org.hamotunnelplus.xyz.R.drawable.n1, theme);
                this.emptyDrawable = drawable2;
                if (drawable2 != null) {
                    int i2 = this.iconSize;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.emptyDrawable;
        }
        this.textView.setCompoundDrawablesRelative(drawable, null, null, null);
    }
}
